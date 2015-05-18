// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

// Referenced classes of package gnu.text:
//            Path

public class LineBufferedReader extends Reader
{

    public static final int BUFFER_SIZE = 8192;
    private static final int CONVERT_CR = 1;
    private static final int DONT_KEEP_FULL_LINES = 8;
    private static final int PREV_WAS_CR = 4;
    private static final int USER_BUFFER = 2;
    public char buffer[];
    private int flags;
    int highestPos;
    protected Reader in;
    public int limit;
    protected int lineNumber;
    private int lineStartPos;
    protected int markPos;
    Path path;
    public int pos;
    protected int readAheadLimit;
    public char readState;

    public LineBufferedReader(InputStream inputstream)
    {
        readState = '\n';
        readAheadLimit = 0;
        in = new InputStreamReader(inputstream);
    }

    public LineBufferedReader(Reader reader)
    {
        readState = '\n';
        readAheadLimit = 0;
        in = reader;
    }

    private void clearMark()
    {
        int i = 0;
        readAheadLimit = 0;
        if (lineStartPos >= 0)
        {
            i = lineStartPos;
        }
        do
        {
            int j = i + 1;
            if (j >= pos)
            {
                return;
            }
            char c = buffer[j - 1];
            if (c != '\n')
            {
                i = j;
                if (c != '\r')
                {
                    continue;
                }
                if (getConvertCR())
                {
                    i = j;
                    if (buffer[j] == '\n')
                    {
                        continue;
                    }
                }
            }
            lineNumber = lineNumber + 1;
            lineStartPos = j;
            i = j;
        } while (true);
    }

    static int countLines(char ac[], int i, int j)
    {
        int k = 0;
        char c;
        for (int l = 0; i < j; l = c)
        {
label0:
            {
                c = ac[i];
                if (c != '\n' || l == 13)
                {
                    l = k;
                    if (c != '\r')
                    {
                        break label0;
                    }
                }
                l = k + 1;
            }
            i++;
            k = l;
        }

        return k;
    }

    private void reserve(char ac[], int i)
        throws IOException
    {
        int k = i + limit;
        if (k > ac.length) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        if (limit > 0)
        {
            System.arraycopy(buffer, i, ac, 0, limit);
        }
        buffer = ac;
        return;
_L2:
        char ac1[];
        int j;
        i = pos;
        j = i;
        if (readAheadLimit > 0)
        {
            j = i;
            if (markPos < pos)
            {
                if (pos - markPos > readAheadLimit || (flags & 2) != 0 && k - markPos > ac.length)
                {
                    clearMark();
                    j = i;
                } else
                {
                    j = markPos;
                }
            }
        }
        k -= ac.length;
        if (k > j)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        ac1 = ac;
        if (j > lineStartPos)
        {
            if ((flags & 8) == 0)
            {
                break; /* Loop/switch isn't completed */
            }
            ac1 = ac;
            i = j;
        }
_L5:
        lineStartPos = lineStartPos - i;
        limit = limit - i;
        markPos = markPos - i;
        pos = pos - i;
        highestPos = highestPos - i;
        ac = ac1;
        if (true) goto _L4; else goto _L3
_L3:
        if (k <= lineStartPos && j > lineStartPos)
        {
            i = lineStartPos;
            ac1 = ac;
        } else
        if ((flags & 2) != 0)
        {
            i = j - (j - k >> 2);
            ac1 = ac;
        } else
        {
            i = j;
            if (lineStartPos >= 0)
            {
                i = lineStartPos;
            }
            ac1 = new char[ac.length * 2];
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void close()
        throws IOException
    {
        in.close();
    }

    public int fill(int i)
        throws IOException
    {
        return in.read(buffer, pos, i);
    }

    public int getColumnNumber()
    {
        int i = 0;
        if (pos > 0)
        {
            char c = buffer[pos - 1];
            if (c == '\n' || c == '\r')
            {
                return 0;
            }
        }
        if (readAheadLimit <= 0)
        {
            return pos - lineStartPos;
        }
        int j;
        int k;
        if (lineStartPos >= 0)
        {
            i = lineStartPos;
        }
        k = i;
        j = i;
        for (; k < pos; k = i)
        {
            char ac[] = buffer;
            i = k + 1;
            k = ac[k];
            if (k == '\n' || k == '\r')
            {
                j = i;
            }
        }

        j = pos - j;
        i = j;
        if (lineStartPos < 0)
        {
            i = j - lineStartPos;
        }
        return i;
    }

    public final boolean getConvertCR()
    {
        return (flags & 1) != 0;
    }

    public int getLineNumber()
    {
        int k;
label0:
        {
            int i;
label1:
            {
                k = lineNumber;
                if (readAheadLimit != 0)
                {
                    break label0;
                }
                i = k;
                if (pos <= 0)
                {
                    break label1;
                }
                i = k;
                if (pos <= lineStartPos)
                {
                    break label1;
                }
                char c = buffer[pos - 1];
                if (c != '\n')
                {
                    i = k;
                    if (c != '\r')
                    {
                        break label1;
                    }
                }
                i = k + 1;
            }
            return i;
        }
        char ac[] = buffer;
        int j;
        if (lineStartPos < 0)
        {
            j = 0;
        } else
        {
            j = lineStartPos;
        }
        return k + countLines(ac, j, pos);
    }

    public String getName()
    {
        if (path == null)
        {
            return null;
        } else
        {
            return path.toString();
        }
    }

    public Path getPath()
    {
        return path;
    }

    public char getReadState()
    {
        return readState;
    }

    public void incrLineNumber(int i, int j)
    {
        lineNumber = lineNumber + i;
        lineStartPos = j;
    }

    public void lineStart(boolean flag)
        throws IOException
    {
    }

    public void mark(int i)
    {
        this;
        JVM INSTR monitorenter ;
        if (readAheadLimit > 0)
        {
            clearMark();
        }
        readAheadLimit = i;
        markPos = pos;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean markSupported()
    {
        return true;
    }

    public int peek()
        throws IOException
    {
        if (pos < limit && pos > 0)
        {
            char c = buffer[pos - 1];
            if (c != '\n' && c != '\r')
            {
                char c2 = buffer[pos];
                char c1 = c2;
                if (c2 == '\r')
                {
                    c1 = c2;
                    if (getConvertCR())
                    {
                        c1 = '\n';
                    }
                }
                return c1;
            }
        }
        int i = read();
        if (i >= 0)
        {
            unread_quick();
        }
        return i;
    }

    public int read()
        throws IOException
    {
        char c;
        int i;
        if (pos > 0)
        {
            c = buffer[pos - 1];
        } else
        if ((flags & 4) != 0)
        {
            c = '\r';
        } else
        if (lineStartPos >= 0)
        {
            c = '\n';
        } else
        {
            c = '\0';
        }
        if (c == '\r' || c == '\n')
        {
            if (lineStartPos < pos && (readAheadLimit == 0 || pos <= markPos))
            {
                lineStartPos = pos;
                lineNumber = lineNumber + 1;
            }
            boolean flag;
            if (pos < highestPos)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (c != '\n' || (pos > 1 ? buffer[pos - 2] != '\r' : (flags & 4) == 0))
            {
                lineStart(flag);
            }
            if (!flag)
            {
                highestPos = pos + 1;
            }
        }
        if (pos < limit) goto _L2; else goto _L1
_L1:
        if (buffer == null)
        {
            buffer = new char[8192];
        } else
        if (limit == buffer.length)
        {
            reserve(buffer, 1);
        }
        if (pos == 0)
        {
            if (c == '\r')
            {
                flags = flags | 4;
            } else
            {
                flags = flags & -5;
            }
        }
        i = fill(buffer.length - pos);
        if (i > 0) goto _L4; else goto _L3
_L3:
        i = -1;
_L6:
        return i;
_L4:
        limit = limit + i;
_L2:
        char c1;
        char ac[] = buffer;
        i = pos;
        pos = i + 1;
        c1 = ac[i];
        if (c1 != '\n')
        {
            break; /* Loop/switch isn't completed */
        }
        i = c1;
        if (c == '\r')
        {
            if (lineStartPos == pos - 1)
            {
                lineNumber = lineNumber - 1;
                lineStartPos = lineStartPos - 1;
            }
            i = c1;
            if (getConvertCR())
            {
                return read();
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
        i = c1;
        if (c1 == '\r')
        {
            i = c1;
            if (getConvertCR())
            {
                return 10;
            }
        }
        if (true) goto _L6; else goto _L7
_L7:
    }

    public int read(char ac[], int i, int j)
        throws IOException
    {
        int k;
        int l;
        int i1;
        if (pos >= limit)
        {
            k = 0;
        } else
        if (pos > 0)
        {
            k = buffer[pos - 1];
        } else
        if ((flags & 4) != 0 || lineStartPos >= 0)
        {
            k = 10;
        } else
        {
            k = 0;
        }
_L6:
        l = j;
        i1 = i;
        i = l;
        l = i1;
_L2:
        int j1;
        int k1;
        int l1;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        if (pos >= limit || k == 10 || k == 13)
        {
            if (pos >= limit && i < j)
            {
                return j - i;
            }
            k = read();
            if (k < 0)
            {
                i = j - i;
                if (i <= 0)
                {
                    return -1;
                } else
                {
                    return i;
                }
            }
            ac[l] = (char)k;
            i--;
            l++;
            continue; /* Loop/switch isn't completed */
        }
        int i2 = pos;
        int j2 = limit;
        i1 = k;
        k1 = j2;
        j1 = l;
        l1 = i2;
        if (i < j2 - i2)
        {
            k1 = i2 + i;
            l1 = i2;
            j1 = l;
            i1 = k;
        }
_L3:
label0:
        {
            k = i1;
            if (l1 < k1)
            {
                i1 = buffer[l1];
                k = i1;
                if (i1 != 10)
                {
                    if (i1 != 13)
                    {
                        break label0;
                    }
                    k = i1;
                }
            }
            i -= l1 - pos;
            pos = l1;
            l = j1;
        }
        if (true) goto _L2; else goto _L1
_L1:
        ac[j1] = (char)i1;
        l1++;
        j1++;
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        return j;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String readLine()
        throws IOException
    {
        int i;
        int k;
label0:
        {
label1:
            {
                i = read();
                if (i < 0)
                {
                    return null;
                }
                if (i == 13 || i == 10)
                {
                    return "";
                }
                i = pos - 1;
                do
                {
                    if (pos >= limit)
                    {
                        break;
                    }
                    char ac[] = buffer;
                    int j = pos;
                    pos = j + 1;
                    j = ac[j];
                    if (j != '\r' && j != '\n')
                    {
                        continue;
                    }
                    k = pos;
                    if (j == '\n' || getConvertCR())
                    {
                        break label0;
                    }
                    if (pos < limit)
                    {
                        break label1;
                    }
                    pos = pos - 1;
                    break;
                } while (true);
                StringBuffer stringbuffer = new StringBuffer(100);
                stringbuffer.append(buffer, i, pos - i);
                readLine(stringbuffer, 'I');
                return stringbuffer.toString();
            }
            if (buffer[pos] == '\n')
            {
                pos = pos + 1;
            }
        }
        return new String(buffer, i, k - 1 - i);
    }

    public void readLine(StringBuffer stringbuffer, char c)
        throws IOException
    {
_L7:
        if (read() >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        i = pos - 1;
        pos = i;
        int j;
        do
        {
            if (pos >= limit)
            {
                break MISSING_BLOCK_LABEL_187;
            }
            char ac[] = buffer;
            j = pos;
            pos = j + 1;
            j = ac[j];
        } while (j != '\r' && j != '\n');
        stringbuffer.append(buffer, i, pos - 1 - i);
        if (c == 'P')
        {
            pos = pos - 1;
            return;
        }
        if (!getConvertCR() && j != '\n')
        {
            break; /* Loop/switch isn't completed */
        }
        if (c != 'I')
        {
            stringbuffer.append('\n');
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (c != 'I')
        {
            stringbuffer.append('\r');
        }
        i = read();
        if (i != 10)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (c == 'I') goto _L1; else goto _L4
_L4:
        stringbuffer.append('\n');
        return;
        if (i < 0) goto _L1; else goto _L5
_L5:
        unread_quick();
        return;
        stringbuffer.append(buffer, i, pos - i);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean ready()
        throws IOException
    {
        return pos < limit || in.ready();
    }

    public void reset()
        throws IOException
    {
        if (readAheadLimit <= 0)
        {
            throw new IOException("mark invalid");
        }
        if (pos > highestPos)
        {
            highestPos = pos;
        }
        pos = markPos;
        readAheadLimit = 0;
    }

    public void setBuffer(char ac[])
        throws IOException
    {
        if (ac == null)
        {
            if (buffer != null)
            {
                ac = new char[buffer.length];
                System.arraycopy(buffer, 0, ac, 0, buffer.length);
                buffer = ac;
            }
            flags = flags & -3;
            return;
        }
        if (limit - pos > ac.length)
        {
            throw new IOException("setBuffer - too short");
        } else
        {
            flags = flags | 2;
            reserve(ac, 0);
            return;
        }
    }

    public final void setConvertCR(boolean flag)
    {
        if (flag)
        {
            flags = flags | 1;
            return;
        } else
        {
            flags = flags & -2;
            return;
        }
    }

    public void setKeepFullLines(boolean flag)
    {
        if (flag)
        {
            flags = flags & -9;
            return;
        } else
        {
            flags = flags | 8;
            return;
        }
    }

    public void setLineNumber(int i)
    {
        lineNumber = lineNumber + (i - getLineNumber());
    }

    public void setName(Object obj)
    {
        setPath(Path.valueOf(obj));
    }

    public void setPath(Path path1)
    {
        path = path1;
    }

    public int skip(int i)
        throws IOException
    {
        if (i >= 0) goto _L2; else goto _L1
_L1:
        int i1;
        int j;
        for (j = -i; j > 0 && pos > 0; j--)
        {
            unread();
        }

        i1 = i + j;
_L4:
        return i1;
_L2:
        int k;
        int l;
        l = i;
        if (pos >= limit)
        {
            k = 0;
        } else
        if (pos > 0)
        {
            k = buffer[pos - 1];
        } else
        if ((flags & 4) != 0 || lineStartPos >= 0)
        {
            k = 10;
        } else
        {
            k = 0;
        }
_L5:
        i1 = i;
        if (l <= 0) goto _L4; else goto _L3
_L3:
label0:
        {
            if (k != 10 && k != 13 && pos < limit)
            {
                break label0;
            }
            k = read();
            if (k < 0)
            {
                return i - l;
            }
            l--;
        }
        break MISSING_BLOCK_LABEL_52;
        int j1;
        int k1;
        int l1 = pos;
        int i2 = limit;
        i1 = k;
        k1 = i2;
        j1 = l1;
        if (l < i2 - l1)
        {
            k1 = l1 + l;
            j1 = l1;
            i1 = k;
        }
_L6:
label1:
        {
            k = i1;
            if (j1 < k1)
            {
                i1 = buffer[j1];
                k = i1;
                if (i1 != 10)
                {
                    if (i1 != 13)
                    {
                        break label1;
                    }
                    k = i1;
                }
            }
            l -= j1 - pos;
            pos = j1;
        }
          goto _L5
        j1++;
          goto _L6
    }

    public void skip()
        throws IOException
    {
        read();
    }

    public void skipRestOfLine()
        throws IOException
    {
_L5:
        int i = read();
        if (i >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (i != 13)
        {
            continue; /* Loop/switch isn't completed */
        }
        if ((i = read()) < 0 || i == 10) goto _L1; else goto _L3
_L3:
        unread();
        return;
        if (i != 10) goto _L5; else goto _L4
_L4:
    }

    public final void skip_quick()
        throws IOException
    {
        pos = pos + 1;
    }

    public void unread()
        throws IOException
    {
label0:
        {
            int j;
label1:
            {
                if (pos == 0)
                {
                    throw new IOException("unread too much");
                }
                pos = pos - 1;
                int i = buffer[pos];
                if (i != '\n' && i != '\r')
                {
                    break label0;
                }
                if (pos > 0 && i == '\n' && getConvertCR() && buffer[pos - 1] == '\r')
                {
                    pos = pos - 1;
                }
                if (pos >= lineStartPos)
                {
                    break label0;
                }
                lineNumber = lineNumber - 1;
                i = pos;
                char c;
                do
                {
                    j = i;
                    if (i <= 0)
                    {
                        break label1;
                    }
                    char ac[] = buffer;
                    j = i - 1;
                    c = ac[j];
                    if (c == '\r')
                    {
                        break;
                    }
                    i = j;
                } while (c != '\n');
                j++;
            }
            lineStartPos = j;
        }
    }

    public void unread_quick()
    {
        pos = pos - 1;
    }
}
