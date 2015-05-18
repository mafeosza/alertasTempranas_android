// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.Writer;

// Referenced classes of package gnu.lists:
//            StableVector, CharSeq, FString, Consumer, 
//            SimpleVector, SubCharSeq

public class CharBuffer extends StableVector
    implements CharSeq, Serializable
{

    private FString string;

    protected CharBuffer()
    {
    }

    public CharBuffer(int i)
    {
        this(new FString(i));
    }

    public CharBuffer(FString fstring)
    {
        super(fstring);
        string = fstring;
    }

    public char charAt(int i)
    {
        int j = i;
        if (i >= gapStart)
        {
            j = i + (gapEnd - gapStart);
        }
        return string.charAt(j);
    }

    public void consume(int i, int j, Consumer consumer)
    {
        char ac[] = string.data;
        int l = i;
        int k = j;
        if (i < gapStart)
        {
            l = gapStart - i;
            k = l;
            if (l > j)
            {
                k = j;
            }
            consumer.write(ac, i, k);
            k = j - k;
            l = i + k;
        }
        if (k > 0)
        {
            consumer.write(ac, l + (gapEnd - gapStart), k);
        }
    }

    public void delete(int i, int j)
    {
        i = createPos(i, false);
        removePos(i, j);
        releasePos(i);
    }

    public void dump()
    {
        int i = 0;
        System.err.println((new StringBuilder()).append("Buffer Content dump.  size:").append(size()).append("  buffer:").append(getArray().length).toString());
        System.err.print("before gap: \"");
        System.err.print(new String(getArray(), 0, gapStart));
        System.err.println((new StringBuilder()).append("\" (gapStart:").append(gapStart).append(" gapEnd:").append(gapEnd).append(')').toString());
        System.err.print("after gap: \"");
        System.err.print(new String(getArray(), gapEnd, getArray().length - gapEnd));
        System.err.println("\"");
        boolean aflag[];
        if (positions != null)
        {
            i = positions.length;
        }
        System.err.println((new StringBuilder()).append("Positions (size: ").append(i).append(" free:").append(free).append("):").toString());
        aflag = null;
        if (free != -2)
        {
            boolean aflag1[] = new boolean[positions.length];
            int j = free;
            do
            {
                aflag = aflag1;
                if (j < 0)
                {
                    break;
                }
                aflag1[j] = true;
                j = positions[j];
            } while (true);
        }
        int k = 0;
        while (k < i) 
        {
            int l = positions[k];
            if (free != -2 ? !aflag[k] : l != -2)
            {
                System.err.println((new StringBuilder()).append("position#").append(k).append(": ").append(l >> 1).append(" isAfter:").append(l & 1).toString());
            }
            k++;
        }
    }

    public final void fill(char c)
    {
        char ac[] = string.data;
        int i = ac.length;
        do
        {
            i--;
            if (i < gapEnd)
            {
                break;
            }
            ac[i] = c;
        } while (true);
        i = gapStart;
        do
        {
            i--;
            if (i >= 0)
            {
                ac[i] = c;
            } else
            {
                return;
            }
        } while (true);
    }

    public void fill(int i, int j, char c)
    {
        char ac[] = string.data;
        int k = i;
        if (gapStart < j)
        {
            i = gapStart;
        } else
        {
            i = j;
        }
        for (; k < i; k++)
        {
            ac[k] = c;
        }

        for (int l = i + (gapEnd - gapStart); l < i + j; l++)
        {
            ac[l] = c;
        }

    }

    public char[] getArray()
    {
        return (char[])(char[])base.getBuffer();
    }

    public void getChars(int i, int j, char ac[], int k)
    {
        char ac1[] = string.data;
        int i1 = i;
        int l = k;
        if (i < gapStart)
        {
            int j1;
            if (j < gapStart)
            {
                l = j;
            } else
            {
                l = gapStart;
            }
            j1 = l - i;
            i1 = i;
            l = k;
            if (j1 > 0)
            {
                System.arraycopy(ac1, i, ac, k, j1);
                i1 = i + j1;
                l = k + j1;
            }
        }
        i = gapEnd - gapStart;
        k = i1 + i;
        i = (j + i) - k;
        if (i > 0)
        {
            System.arraycopy(ac1, k, ac, l, i);
        }
    }

    public int indexOf(int i, int j)
    {
        char ac[];
        char c;
        char c1;
        int k;
        int i1;
        if (i >= 0x10000)
        {
            c = (char)((i - 0x10000 >> 10) + 55296);
            c1 = (char)((i & 0x3ff) + 56320);
        } else
        {
            c = (char)i;
            c1 = '\0';
        }
        ac = getArray();
        k = j;
        i1 = gapStart;
        i = k;
        j = i1;
        if (k >= i1)
        {
            i = k + (gapEnd - gapStart);
            j = ac.length;
        }
        do
        {
            int j1 = i;
            int l = j;
            if (i == j)
            {
                l = ac.length;
                if (i >= l)
                {
                    break;
                }
                j1 = gapEnd;
            }
            if (ac[j1] == c && (c1 == 0 || (j1 + 1 >= l ? gapEnd < ac.length && ac[gapEnd] == c1 : ac[j1 + 1] == c1)))
            {
                if (j1 > gapStart)
                {
                    return j1 - (gapEnd - gapStart);
                } else
                {
                    return j1;
                }
            }
            i = j1 + 1;
            j = l;
        } while (true);
        return -1;
    }

    public void insert(int i, String s, boolean flag)
    {
        int j = s.length();
        gapReserve(i, j);
        s.getChars(0, j, string.data, i);
        gapStart = gapStart + j;
    }

    public int lastIndexOf(int i, int j)
    {
        char c;
        if (i >= 0x10000)
        {
            char c1 = (char)((i - 0x10000 >> 10) + 55296);
            c = (char)((i & 0x3ff) + 56320);
            i = c1;
        } else
        {
            c = '\0';
            c2 = (char)i;
            i = c;
            c = c2;
        }
        do
        {
            char c2 = j - 1;
            if (c2 >= 0)
            {
                j = c2;
                if (charAt(c2) == c)
                {
                    if (i == 0)
                    {
                        return c2;
                    }
                    j = c2;
                    if (c2 > 0)
                    {
                        j = c2;
                        if (charAt(c2 - 1) == i)
                        {
                            return c2 - 1;
                        }
                    }
                }
            } else
            {
                return -1;
            }
        } while (true);
    }

    public int length()
    {
        return size();
    }

    public void setCharAt(int i, char c)
    {
        int j = i;
        if (i >= gapStart)
        {
            j = i + (gapEnd - gapStart);
        }
        string.setCharAt(j, c);
    }

    public CharSequence subSequence(int i, int j)
    {
        int k = size();
        if (i < 0 || j < i || j > k)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return new SubCharSeq(this, base.createPos(i, false), base.createPos(j, true));
        }
    }

    public String substring(int i, int j)
    {
        int k = size();
        if (i < 0 || j < i || j > k)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            j -= i;
            i = getSegment(i, j);
            return new String(getArray(), i, j);
        }
    }

    public String toString()
    {
        int i = size();
        int j = getSegment(0, i);
        return new String(getArray(), j, i);
    }

    public void writeTo(int i, int j, Writer writer)
        throws IOException
    {
        char ac[] = string.data;
        int l = i;
        int k = j;
        if (i < gapStart)
        {
            l = gapStart - i;
            k = l;
            if (l > j)
            {
                k = j;
            }
            writer.write(ac, i, k);
            k = j - k;
            l = i + k;
        }
        if (k > 0)
        {
            writer.write(ac, l + (gapEnd - gapStart), k);
        }
    }

    public void writeTo(int i, int j, Appendable appendable)
        throws IOException
    {
        if (appendable instanceof Writer)
        {
            writeTo(i, j, (Writer)appendable);
            return;
        } else
        {
            appendable.append(this, i, i + j);
            return;
        }
    }

    public void writeTo(Writer writer)
        throws IOException
    {
        char ac[] = string.data;
        writer.write(ac, 0, gapStart);
        writer.write(ac, gapEnd, ac.length - gapEnd);
    }

    public void writeTo(Appendable appendable)
        throws IOException
    {
        writeTo(0, size(), appendable);
    }
}
