// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

// Referenced classes of package org.json:
//            JSONException, JSONObject, JSONArray

public class JSONTokener
{

    private long character;
    private boolean eof;
    private long index;
    private long line;
    private char previous;
    private Reader reader;
    private boolean usePrevious;

    public JSONTokener(InputStream inputstream)
        throws JSONException
    {
        this(((Reader) (new InputStreamReader(inputstream))));
    }

    public JSONTokener(Reader reader1)
    {
        if (!reader1.markSupported())
        {
            reader1 = new BufferedReader(reader1);
        }
        reader = reader1;
        eof = false;
        usePrevious = false;
        previous = '\0';
        index = 0L;
        character = 1L;
        line = 1L;
    }

    public JSONTokener(String s)
    {
        this(((Reader) (new StringReader(s))));
    }

    public static int dehexchar(char c)
    {
        if (c >= '0' && c <= '9')
        {
            return c - 48;
        }
        if (c >= 'A' && c <= 'F')
        {
            return c - 55;
        }
        if (c >= 'a' && c <= 'f')
        {
            return c - 87;
        } else
        {
            return -1;
        }
    }

    public void back()
        throws JSONException
    {
        if (usePrevious || index <= 0L)
        {
            throw new JSONException("Stepping back two steps is not supported");
        } else
        {
            index = index - 1L;
            character = character - 1L;
            usePrevious = true;
            eof = false;
            return;
        }
    }

    public boolean end()
    {
        return eof && !usePrevious;
    }

    public boolean more()
        throws JSONException
    {
        next();
        if (end())
        {
            return false;
        } else
        {
            back();
            return true;
        }
    }

    public char next()
        throws JSONException
    {
        long l = 0L;
        int i;
        if (usePrevious)
        {
            usePrevious = false;
            i = previous;
        } else
        {
            int j;
            try
            {
                j = reader.read();
            }
            catch (IOException ioexception)
            {
                throw new JSONException(ioexception);
            }
            i = j;
            if (j <= 0)
            {
                eof = true;
                i = 0;
            }
        }
        index = index + 1L;
        if (previous == '\r')
        {
            line = line + 1L;
            if (i != 10)
            {
                l = 1L;
            }
            character = l;
        } else
        if (i == 10)
        {
            line = 1L + line;
            character = 0L;
        } else
        {
            character = character + 1L;
        }
        previous = (char)i;
        return previous;
    }

    public char next(char c)
        throws JSONException
    {
        char c1 = next();
        if (c1 != c)
        {
            throw syntaxError("Expected '" + c + "' and instead saw '" + c1 + "'");
        } else
        {
            return c1;
        }
    }

    public String next(int i)
        throws JSONException
    {
        if (i == 0)
        {
            return "";
        }
        char ac[] = new char[i];
        for (int j = 0; j < i; j++)
        {
            ac[j] = next();
            if (end())
            {
                throw syntaxError("Substring bounds error");
            }
        }

        return new String(ac);
    }

    public char nextClean()
        throws JSONException
    {
        char c;
        do
        {
            c = next();
        } while (c != 0 && c <= ' ');
        return c;
    }

    public String nextString(char c)
        throws JSONException
    {
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            char c1 = next();
            switch (c1)
            {
            default:
                if (c1 == c)
                {
                    return stringbuffer.toString();
                }
                break;

            case 0: // '\0'
            case 10: // '\n'
            case 13: // '\r'
                throw syntaxError("Unterminated string");

            case 92: // '\\'
                c1 = next();
                switch (c1)
                {
                default:
                    throw syntaxError("Illegal escape.");

                case 98: // 'b'
                    stringbuffer.append('\b');
                    break;

                case 116: // 't'
                    stringbuffer.append('\t');
                    break;

                case 110: // 'n'
                    stringbuffer.append('\n');
                    break;

                case 102: // 'f'
                    stringbuffer.append('\f');
                    break;

                case 114: // 'r'
                    stringbuffer.append('\r');
                    break;

                case 117: // 'u'
                    stringbuffer.append((char)Integer.parseInt(next(4), 16));
                    break;

                case 34: // '"'
                case 39: // '\''
                case 47: // '/'
                case 92: // '\\'
                    stringbuffer.append(c1);
                    break;
                }
                continue;
            }
            stringbuffer.append(c1);
        } while (true);
    }

    public String nextTo(char c)
        throws JSONException
    {
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            char c1 = next();
            if (c1 == c || c1 == 0 || c1 == '\n' || c1 == '\r')
            {
                if (c1 != 0)
                {
                    back();
                }
                return stringbuffer.toString().trim();
            }
            stringbuffer.append(c1);
        } while (true);
    }

    public String nextTo(String s)
        throws JSONException
    {
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            char c = next();
            if (s.indexOf(c) >= 0 || c == 0 || c == '\n' || c == '\r')
            {
                if (c != 0)
                {
                    back();
                }
                return stringbuffer.toString().trim();
            }
            stringbuffer.append(c);
        } while (true);
    }

    public Object nextValue()
        throws JSONException
    {
        char c = nextClean();
        Object obj;
        switch (c)
        {
        default:
            obj = new StringBuffer();
            for (; c >= ' ' && ",:]}/\\\"[{;=#".indexOf(c) < 0; c = next())
            {
                ((StringBuffer) (obj)).append(c);
            }

            break;

        case 34: // '"'
        case 39: // '\''
            return nextString(c);

        case 123: // '{'
            back();
            return new JSONObject(this);

        case 91: // '['
            back();
            return new JSONArray(this);
        }
        back();
        obj = ((StringBuffer) (obj)).toString().trim();
        if ("".equals(obj))
        {
            throw syntaxError("Missing value");
        } else
        {
            return JSONObject.stringToValue(((String) (obj)));
        }
    }

    public char skipTo(char c)
        throws JSONException
    {
        long l;
        long l1;
        long l2;
        l = index;
        l1 = character;
        l2 = line;
        reader.mark(0xf4240);
_L1:
        char c1 = next();
        if (c1 == 0)
        {
            try
            {
                reader.reset();
                index = l;
                character = l1;
                line = l2;
            }
            catch (IOException ioexception)
            {
                throw new JSONException(ioexception);
            }
            return c1;
        }
        if (c1 == c)
        {
            back();
            return c1;
        }
          goto _L1
    }

    public JSONException syntaxError(String s)
    {
        return new JSONException(s + toString());
    }

    public String toString()
    {
        return " at " + index + " [character " + character + " line " + line + "]";
    }
}
