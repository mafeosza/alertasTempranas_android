// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

// Referenced classes of package gnu.text:
//            LineBufferedReader, SourceMessages, SyntaxException, SourceError

public class Lexer extends Reader
{

    protected boolean interactive;
    SourceMessages messages;
    protected int nesting;
    protected LineBufferedReader port;
    private int saveTokenBufferLength;
    public char tokenBuffer[];
    public int tokenBufferLength;

    public Lexer(LineBufferedReader linebufferedreader)
    {
        messages = null;
        tokenBuffer = new char[100];
        tokenBufferLength = 0;
        saveTokenBufferLength = -1;
        port = linebufferedreader;
    }

    public Lexer(LineBufferedReader linebufferedreader, SourceMessages sourcemessages)
    {
        messages = null;
        tokenBuffer = new char[100];
        tokenBufferLength = 0;
        saveTokenBufferLength = -1;
        port = linebufferedreader;
        messages = sourcemessages;
    }

    public static long readDigitsInBuffer(LineBufferedReader linebufferedreader, int i)
    {
        int j;
        int i1;
        long l1;
        long l3;
        l1 = 0L;
        j = 0;
        l3 = 0x7fffffffffffffffL / (long)i;
        int k = linebufferedreader.pos;
        i1 = k;
        if (k >= linebufferedreader.limit)
        {
            return 0L;
        }
_L4:
        int l = Character.digit(linebufferedreader.buffer[i1], i);
        if (l >= 0) goto _L2; else goto _L1
_L1:
        linebufferedreader.pos = i1;
        int j1;
        long l2;
        if (j != 0)
        {
            return -1L;
        } else
        {
            return l1;
        }
_L2:
        if (l1 > l3)
        {
            j = 1;
            l2 = l1;
        } else
        {
            l2 = (long)i * l1 + (long)l;
        }
        l = j;
        if (l2 < 0L)
        {
            l = 1;
        }
        j1 = i1 + 1;
        i1 = j1;
        l1 = l2;
        j = l;
        if (j1 < linebufferedreader.limit) goto _L4; else goto _L3
_L3:
        i1 = j1;
        l1 = l2;
        j = l;
          goto _L1
    }

    public boolean checkErrors(PrintWriter printwriter, int i)
    {
        return messages != null && messages.checkErrors(printwriter, i);
    }

    public boolean checkNext(char c)
        throws IOException
    {
        int i = port.read();
        if (i == c)
        {
            return true;
        }
        if (i >= 0)
        {
            port.unread_quick();
        }
        return false;
    }

    public void clearErrors()
    {
        if (messages != null)
        {
            messages.clearErrors();
        }
    }

    public void close()
        throws IOException
    {
        port.close();
    }

    public void eofError(String s)
        throws SyntaxException
    {
        fatal(s);
    }

    public void eofError(String s, int i, int j)
        throws SyntaxException
    {
        error('f', port.getName(), i, j, s);
        throw new SyntaxException(messages);
    }

    public void error(char c, String s)
    {
        int j = port.getLineNumber();
        int i = port.getColumnNumber();
        String s1 = port.getName();
        if (i >= 0)
        {
            i++;
        } else
        {
            i = 0;
        }
        error(c, s1, j + 1, i, s);
    }

    public void error(char c, String s, int i, int j, String s1)
    {
        if (messages == null)
        {
            messages = new SourceMessages();
        }
        messages.error(c, s, i, j, s1);
    }

    public void error(String s)
    {
        error('e', s);
    }

    public void fatal(String s)
        throws SyntaxException
    {
        error('f', s);
        throw new SyntaxException(messages);
    }

    public int getColumnNumber()
    {
        return port.getColumnNumber();
    }

    public SourceError getErrors()
    {
        if (messages == null)
        {
            return null;
        } else
        {
            return messages.getErrors();
        }
    }

    public int getLineNumber()
    {
        return port.getLineNumber();
    }

    public SourceMessages getMessages()
    {
        return messages;
    }

    public String getName()
    {
        return port.getName();
    }

    public final LineBufferedReader getPort()
    {
        return port;
    }

    public boolean isInteractive()
    {
        return interactive;
    }

    public void mark()
        throws IOException
    {
        if (saveTokenBufferLength >= 0)
        {
            throw new Error("internal error: recursive call to mark not allowed");
        } else
        {
            port.mark(0x7fffffff);
            saveTokenBufferLength = tokenBufferLength;
            return;
        }
    }

    public int peek()
        throws IOException
    {
        return port.peek();
    }

    public void popNesting(char c)
    {
        getPort().readState = c;
        nesting = nesting - 1;
    }

    public char pushNesting(char c)
    {
        nesting = nesting + 1;
        LineBufferedReader linebufferedreader = getPort();
        char c1 = linebufferedreader.readState;
        linebufferedreader.readState = c;
        return c1;
    }

    public int read()
        throws IOException
    {
        return port.read();
    }

    public int read(char ac[], int i, int j)
        throws IOException
    {
        return port.read(ac, i, j);
    }

    public boolean readDelimited(String s)
        throws IOException, SyntaxException
    {
        tokenBufferLength = 0;
        int k = s.length();
        char c = s.charAt(k - 1);
        do
        {
            int l = read();
            if (l < 0)
            {
                return false;
            }
            if (l == c)
            {
                int j = tokenBufferLength;
                int i = k - 1;
                int i1 = j - i;
                if (i1 >= 0)
                {
                    do
                    {
                        if (i == 0)
                        {
                            tokenBufferLength = i1;
                            return true;
                        }
                        j = i - 1;
                        i = j;
                    } while (tokenBuffer[i1 + j] == s.charAt(j));
                }
            }
            tokenBufferAppend((char)l);
        } while (true);
    }

    public int readOptionalExponent()
        throws IOException
    {
        int i;
        int j;
        boolean flag;
        boolean flag1;
        int l;
        int k = read();
        flag = false;
        flag1 = false;
        if (k == 43 || k == 45)
        {
            i = read();
        } else
        {
            i = k;
            k = 0;
        }
        if (i < 0) goto _L2; else goto _L1
_L1:
        j = Character.digit((char)i, 10);
        if (j >= 0) goto _L3; else goto _L2
_L2:
        if (k != 0)
        {
            error("exponent sign not followed by digit");
        }
        j = 1;
        l = i;
_L5:
        if (l >= 0)
        {
            unread(l);
        }
        i = j;
        if (k == 45)
        {
            i = -j;
        }
        int i1;
        if (flag1)
        {
            return k != 45 ? 0x7fffffff : 0x80000000;
        } else
        {
            return i;
        }
_L3:
        i = j;
_L6:
        l = read();
        i1 = Character.digit((char)l, 10);
        flag1 = flag;
        j = i;
        if (i1 < 0) goto _L5; else goto _L4
_L4:
        if (i > 0xccccccb)
        {
            flag = true;
        }
        i = i * 10 + i1;
          goto _L6
    }

    public int readUnicodeChar()
        throws IOException
    {
        int j = port.read();
        int i = j;
        if (j >= 55296)
        {
            i = j;
            if (j < 56319)
            {
                int k = port.read();
                i = j;
                if (k >= 56320)
                {
                    i = j;
                    if (k <= 57343)
                    {
                        i = (j - 55296 << 10) + (j - 56320) + 0x10000;
                    }
                }
            }
        }
        return i;
    }

    public void reset()
        throws IOException
    {
        if (saveTokenBufferLength < 0)
        {
            throw new Error("internal error: reset called without prior mark");
        } else
        {
            port.reset();
            saveTokenBufferLength = -1;
            return;
        }
    }

    public boolean seenErrors()
    {
        return messages != null && messages.seenErrors();
    }

    public void setInteractive(boolean flag)
    {
        interactive = flag;
    }

    public void setMessages(SourceMessages sourcemessages)
    {
        messages = sourcemessages;
    }

    public void skip()
        throws IOException
    {
        port.skip();
    }

    protected void skip_quick()
        throws IOException
    {
        port.skip_quick();
    }

    public void tokenBufferAppend(int i)
    {
        int j = i;
        if (i >= 0x10000)
        {
            tokenBufferAppend((i - 0x10000 >> 10) + 55296);
            j = (i & 0x3ff) + 56320;
        }
        i = tokenBufferLength;
        char ac1[] = tokenBuffer;
        char ac[] = ac1;
        if (i == tokenBuffer.length)
        {
            tokenBuffer = new char[i * 2];
            System.arraycopy(ac1, 0, tokenBuffer, 0, i);
            ac = tokenBuffer;
        }
        ac[i] = (char)j;
        tokenBufferLength = i + 1;
    }

    public String tokenBufferString()
    {
        return new String(tokenBuffer, 0, tokenBufferLength);
    }

    protected void unread()
        throws IOException
    {
        port.unread();
    }

    public void unread(int i)
        throws IOException
    {
        if (i >= 0)
        {
            port.unread();
        }
    }

    protected void unread_quick()
        throws IOException
    {
        port.unread_quick();
    }
}
