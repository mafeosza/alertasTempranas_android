// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.collect.Lists;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            YailList

public final class CsvUtil
{
    private static class CsvParser
        implements Iterator
    {

        private final Pattern ESCAPED_QUOTE_PATTERN = Pattern.compile("\"\"");
        private final char buf[] = new char[10240];
        private int cellLength;
        private int delimitedCellLength;
        private final Reader in;
        private Exception lastException;
        private int limit;
        private boolean opened;
        private int pos;
        private long previouslyRead;

        private int checkedIndex(int i)
        {
            if (i < limit)
            {
                return i;
            } else
            {
                return indexAfterCompactionAndFilling(i);
            }
        }

        private int compact(int i)
        {
            int j = pos;
            pos = 0;
            int k = limit - j;
            if (k > 0)
            {
                System.arraycopy(buf, j, buf, 0, k);
            }
            limit = limit - j;
            previouslyRead = previouslyRead + (long)j;
            return i - j;
        }

        private void fill()
        {
            int i = buf.length - limit;
_L2:
            if (!opened || i <= 0)
            {
                break; /* Loop/switch isn't completed */
            }
            int j = in.read(buf, limit, i);
            if (j == -1)
            {
                try
                {
                    opened = false;
                }
                catch (IOException ioexception)
                {
                    lastException = ioexception;
                    opened = false;
                }
                continue; /* Loop/switch isn't completed */
            }
            limit = limit + j;
            i -= j;
            if (true) goto _L2; else goto _L1
_L1:
        }

        private boolean findDelimOrEnd(int i)
        {
            do
            {
label0:
                {
                    int j = i;
                    if (i >= limit)
                    {
                        j = indexAfterCompactionAndFilling(i);
                        if (j >= limit)
                        {
                            break label0;
                        }
                    }
                    switch (buf[j])
                    {
                    default:
                        lastException = new IOException("Syntax Error: non-whitespace between closing quote and delimiter or end");
                        return false;

                    case 13: // '\r'
                        j = checkedIndex(j + 1);
                        i = j;
                        if (buf[j] == '\n')
                        {
                            i = checkedIndex(j + 1);
                        }
                        delimitedCellLength = i - pos;
                        return true;

                    case 10: // '\n'
                    case 44: // ','
                        delimitedCellLength = checkedIndex(j + 1) - pos;
                        return true;

                    case 9: // '\t'
                    case 32: // ' '
                        i = j + 1;
                        break;
                    }
                    continue;
                }
                delimitedCellLength = limit - pos;
                return true;
            } while (true);
        }

        private boolean findUnescapedEndQuote(int i)
        {
            int j = i;
label0:
            do
            {
label1:
                {
                    i = j;
                    if (j >= limit)
                    {
                        i = indexAfterCompactionAndFilling(j);
                        if (i >= limit)
                        {
                            break label0;
                        }
                    }
                    j = i;
                    if (buf[i] != '"')
                    {
                        break label1;
                    }
                    i = checkedIndex(i + 1);
                    if (i != limit)
                    {
                        j = i;
                        if (buf[i] == '"')
                        {
                            break label1;
                        }
                    }
                    cellLength = i - pos;
                    return findDelimOrEnd(i);
                }
                j++;
            } while (true);
            lastException = new IllegalArgumentException("Syntax Error. unclosed quoted cell");
            return false;
        }

        private boolean findUnquotedCellEnd(int i)
        {
            do
            {
                int j = i;
                if (i >= limit)
                {
                    j = indexAfterCompactionAndFilling(i);
                    if (j >= limit)
                    {
                        break;
                    }
                }
                switch (buf[j])
                {
                default:
                    i = j + 1;
                    break;

                case 10: // '\n'
                case 44: // ','
                    cellLength = j - pos;
                    delimitedCellLength = cellLength + 1;
                    return true;

                case 13: // '\r'
                    cellLength = j - pos;
                    j = checkedIndex(j + 1);
                    i = j;
                    if (buf[j] == '\n')
                    {
                        i = checkedIndex(j + 1);
                    }
                    delimitedCellLength = i - pos;
                    return true;

                case 34: // '"'
                    lastException = new IllegalArgumentException("Syntax Error: quote in unquoted cell");
                    return false;
                }
            } while (true);
            i = limit - pos;
            cellLength = i;
            delimitedCellLength = i;
            return true;
        }

        private int indexAfterCompactionAndFilling(int i)
        {
            int j = i;
            if (pos > 0)
            {
                j = compact(i);
            }
            fill();
            return j;
        }

        private boolean lookingAtCell()
        {
            if (buf[pos] == '"')
            {
                return findUnescapedEndQuote(pos + 1);
            } else
            {
                return findUnquotedCellEnd(pos);
            }
        }

        public long getCharPosition()
        {
            return previouslyRead + (long)pos;
        }

        public boolean hasNext()
        {
            if (limit == 0)
            {
                fill();
            }
            return (pos < limit || indexAfterCompactionAndFilling(pos) < limit) && lookingAtCell();
        }

        public volatile Object next()
        {
            return next();
        }

        public ArrayList next()
        {
            ArrayList arraylist = Lists.newArrayList();
            do
            {
                boolean flag;
                boolean flag1;
                if (buf[pos] != '"')
                {
                    arraylist.add((new String(buf, pos, cellLength)).trim());
                } else
                {
                    String s = new String(buf, pos + 1, cellLength - 2);
                    arraylist.add(ESCAPED_QUOTE_PATTERN.matcher(s).replaceAll("\"").trim());
                }
                if (delimitedCellLength > 0 && buf[(pos + delimitedCellLength) - 1] == ',')
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                pos = pos + delimitedCellLength;
                cellLength = -1;
                delimitedCellLength = -1;
                if (pos < limit || indexAfterCompactionAndFilling(pos) < limit)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
            } while (flag && flag1 && lookingAtCell());
            return arraylist;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }

        public void skip(long l)
            throws IOException
        {
            do
            {
                int i;
label0:
                {
                    if (l > 0L)
                    {
                        i = in.read(buf, 0, Math.min((int)l, buf.length));
                        if (i >= 0)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                previouslyRead = previouslyRead + (long)i;
                l -= i;
            } while (true);
        }

        public void throwAnyProblem()
            throws Exception
        {
            if (lastException != null)
            {
                throw lastException;
            } else
            {
                return;
            }
        }

        public CsvParser(Reader reader)
        {
            opened = true;
            cellLength = -1;
            delimitedCellLength = -1;
            in = reader;
        }
    }


    private CsvUtil()
    {
    }

    public static YailList fromCsvRow(String s)
        throws Exception
    {
        s = new CsvParser(new StringReader(s));
        if (s.hasNext())
        {
            YailList yaillist = YailList.makeList(s.next());
            if (s.hasNext())
            {
                throw new IllegalArgumentException("CSV text has multiple rows. Expected just one row.");
            } else
            {
                s.throwAnyProblem();
                return yaillist;
            }
        } else
        {
            throw new IllegalArgumentException("CSV text cannot be parsed as a row.");
        }
    }

    public static YailList fromCsvTable(String s)
        throws Exception
    {
        s = new CsvParser(new StringReader(s));
        ArrayList arraylist = new ArrayList();
        for (; s.hasNext(); arraylist.add(YailList.makeList(s.next()))) { }
        s.throwAnyProblem();
        return YailList.makeList(arraylist);
    }

    private static void makeCsvRow(YailList yaillist, StringBuilder stringbuilder)
    {
        String s = "";
        Object aobj[] = yaillist.toArray();
        int j = aobj.length;
        int i = 0;
        yaillist = s;
        for (; i < j; i++)
        {
            String s1 = aobj[i].toString().replaceAll("\"", "\"\"");
            stringbuilder.append(yaillist).append("\"").append(s1).append("\"");
            yaillist = ",";
        }

    }

    public static String toCsvRow(YailList yaillist)
    {
        StringBuilder stringbuilder = new StringBuilder();
        makeCsvRow(yaillist, stringbuilder);
        return stringbuilder.toString();
    }

    public static String toCsvTable(YailList yaillist)
    {
        StringBuilder stringbuilder = new StringBuilder();
        yaillist = ((YailList) (yaillist.toArray()));
        int j = yaillist.length;
        for (int i = 0; i < j; i++)
        {
            makeCsvRow((YailList)yaillist[i], stringbuilder);
            stringbuilder.append("\r\n");
        }

        return stringbuilder.toString();
    }
}
