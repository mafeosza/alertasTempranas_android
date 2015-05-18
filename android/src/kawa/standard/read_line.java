// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Special;
import gnu.lists.FString;
import gnu.mapping.Values;
import gnu.text.LineBufferedReader;
import java.io.IOException;

public class read_line
{

    public read_line()
    {
    }

    public static Object apply(LineBufferedReader linebufferedreader, String s)
        throws IOException
    {
        if (linebufferedreader.read() < 0)
        {
            linebufferedreader = ((LineBufferedReader) (Special.eof));
        } else
        {
label0:
            {
label1:
                {
                    int i1 = linebufferedreader.pos - 1;
                    int j1 = linebufferedreader.limit;
                    char ac[] = linebufferedreader.buffer;
                    int k = -1;
                    char c;
                    FString fstring;
                    StringBuffer stringbuffer;
                    int j;
                    int l;
                    for (int i = i1; i < j1; i = j)
                    {
                        j = i + 1;
                        char c1 = ac[i];
                        if (c1 != '\r' && c1 != '\n')
                        {
                            break label0;
                        }
                        j--;
                        if (s == "trim" || s == "peek")
                        {
                            i = k;
                            if (s == "peek")
                            {
                                i = 0;
                            }
                            if (c1 == '\n')
                            {
                                i = 1;
                            } else
                            {
                                l = j;
                                if (j + 1 >= j1)
                                {
                                    break label1;
                                }
                                if (ac[j + 1] == '\n')
                                {
                                    i = 2;
                                } else
                                {
                                    i = 1;
                                }
                            }
                            linebufferedreader.pos = j + i;
                        } else
                        {
                            i = k;
                            l = j;
                            if (s != "concat")
                            {
                                break label1;
                            }
                            i = k;
                            l = j;
                            if (c1 != '\n')
                            {
                                break label1;
                            }
                            j++;
                            linebufferedreader.pos = j;
                        }
                        return new FString(ac, i1, j - i1);
                    }

                    l = i;
                    i = k;
                }
                stringbuffer = new StringBuffer(100);
                if (l > i1)
                {
                    stringbuffer.append(ac, i1, l - i1);
                }
                linebufferedreader.pos = l;
                if (s == "peek")
                {
                    c = 'P';
                } else
                if (s == "concat" || s == "split")
                {
                    c = 'A';
                } else
                {
                    c = 'I';
                }
                linebufferedreader.readLine(stringbuffer, c);
                k = stringbuffer.length();
                j = k;
                if (s == "split")
                {
                    if (k == 0)
                    {
                        i = 0;
                        j = k;
                    } else
                    {
                        i = stringbuffer.charAt(k - 1);
                        if (i == '\r')
                        {
                            i = 1;
                        } else
                        if (i != 10)
                        {
                            i = 0;
                        } else
                        if (i > 2 && stringbuffer.charAt(k - 2) == '\r')
                        {
                            i = 2;
                        } else
                        {
                            i = 1;
                        }
                        j = k - i;
                    }
                }
                fstring = new FString(stringbuffer, 0, j);
                linebufferedreader = fstring;
                if (s == "split")
                {
                    return new Values(new Object[] {
                        fstring, new FString(stringbuffer, j - i, i)
                    });
                }
            }
        }
        return linebufferedreader;
    }
}
