// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.lists.Consumer;
import gnu.text.PrettyWriter;

// Referenced classes of package gnu.mapping:
//            OutPort, CharArrayInPort

public class CharArrayOutPort extends OutPort
{

    public CharArrayOutPort()
    {
        super(null, false, CharArrayInPort.stringPath);
    }

    public void close()
    {
    }

    protected boolean closeOnExit()
    {
        return false;
    }

    public int length()
    {
        return bout.bufferFillPointer;
    }

    public void reset()
    {
        bout.bufferFillPointer = 0;
    }

    public void setLength(int i)
    {
        bout.bufferFillPointer = i;
    }

    public char[] toCharArray()
    {
        int i = bout.bufferFillPointer;
        char ac[] = new char[i];
        System.arraycopy(bout.buffer, 0, ac, 0, i);
        return ac;
    }

    public String toString()
    {
        return new String(bout.buffer, 0, bout.bufferFillPointer);
    }

    public String toSubString(int i)
    {
        return new String(bout.buffer, i, bout.bufferFillPointer - i);
    }

    public String toSubString(int i, int j)
    {
        if (j > bout.bufferFillPointer)
        {
            throw new IndexOutOfBoundsException();
        } else
        {
            return new String(bout.buffer, i, j - i);
        }
    }

    public void writeTo(int i, int j, Consumer consumer)
    {
        consumer.write(bout.buffer, i, j);
    }

    public void writeTo(Consumer consumer)
    {
        consumer.write(bout.buffer, 0, bout.bufferFillPointer);
    }
}
