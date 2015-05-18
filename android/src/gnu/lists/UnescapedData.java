// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class UnescapedData
    implements CharSequence, Externalizable
{

    String data;

    public UnescapedData()
    {
    }

    public UnescapedData(String s)
    {
        data = s;
    }

    public char charAt(int i)
    {
        return data.charAt(i);
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof UnescapedData) && data.equals(obj.toString());
    }

    public final String getData()
    {
        return data;
    }

    public final int hashCode()
    {
        if (data == null)
        {
            return 0;
        } else
        {
            return data.hashCode();
        }
    }

    public int length()
    {
        return data.length();
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        data = (String)objectinput.readObject();
    }

    public CharSequence subSequence(int i, int j)
    {
        return new UnescapedData(data.substring(i, j));
    }

    public final String toString()
    {
        return data;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(data);
    }
}
