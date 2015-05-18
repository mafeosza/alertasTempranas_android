// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.IOException;
import java.util.List;

// Referenced classes of package gnu.lists:
//            SubSequence, CharSeq, AbstractSequence, Consumer

public class SubCharSeq extends SubSequence
    implements CharSeq
{

    public SubCharSeq(AbstractSequence abstractsequence, int i, int j)
    {
        super(abstractsequence, i, j);
    }

    private SubCharSeq subCharSeq(int i, int j)
    {
        int k = size();
        if (i < 0 || j < i || j > k)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return new SubCharSeq(base, base.createRelativePos(ipos0, i, false), base.createRelativePos(ipos0, j, true));
        }
    }

    public char charAt(int i)
    {
        if (i < 0 || i >= size())
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            int j = base.nextIndex(ipos0);
            return ((CharSeq)base).charAt(j + i);
        }
    }

    public void consume(int i, int j, Consumer consumer)
    {
        int k = base.nextIndex(ipos0);
        int l = base.nextIndex(ipos0);
        if (i < 0 || j < 0 || k + i + j > l)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            ((CharSeq)base).consume(k + i, j, consumer);
            return;
        }
    }

    public void fill(char c)
    {
        int i = base.nextIndex(ipos0);
        int j = base.nextIndex(ipos0);
        ((CharSeq)base).fill(i, j, c);
    }

    public void fill(int i, int j, char c)
    {
        int k = base.nextIndex(ipos0);
        int l = base.nextIndex(ipos0);
        if (i < 0 || j < i || k + j > l)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            ((CharSeq)base).fill(k + i, k + j, c);
            return;
        }
    }

    public void getChars(int i, int j, char ac[], int k)
    {
        while (i < j) 
        {
            ac[k] = charAt(i);
            i++;
            k++;
        }
    }

    public int length()
    {
        return size();
    }

    public void setCharAt(int i, char c)
    {
        if (i < 0 || i >= size())
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            int j = base.nextIndex(ipos0);
            ((CharSeq)base).setCharAt(j + i, c);
            return;
        }
    }

    public List subList(int i, int j)
    {
        return subCharSeq(i, j);
    }

    public CharSequence subSequence(int i, int j)
    {
        return subCharSeq(i, j);
    }

    public String toString()
    {
        int j = size();
        StringBuffer stringbuffer = new StringBuffer(j);
        for (int i = 0; i < j; i++)
        {
            stringbuffer.append(charAt(i));
        }

        return stringbuffer.toString();
    }

    public void writeTo(int i, int j, Appendable appendable)
        throws IOException
    {
        int k = base.nextIndex(ipos0);
        int l = base.nextIndex(ipos0);
        if (i < 0 || j < 0 || k + i + j > l)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            ((CharSeq)base).writeTo(k + i, j, appendable);
            return;
        }
    }

    public void writeTo(Appendable appendable)
        throws IOException
    {
        int i = base.nextIndex(ipos0);
        ((CharSeq)base).writeTo(i, size(), appendable);
    }
}
