// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.lists.Consumer;
import gnu.lists.Sequence;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

public class Special
    implements Printable, Externalizable
{

    public static final Special abstractSpecial = new Special("abstract");
    public static final Special dfault = new Special("default");
    public static final Object eof;
    public static final Special key = new Special("key");
    public static final Special optional = new Special("optional");
    public static final Special rest = new Special("rest");
    public static final Special undefined = new Special("undefined");
    private String name;

    public Special()
    {
    }

    private Special(String s)
    {
        name = new String(s);
    }

    public static Special make(String s)
    {
        if (s == "optional")
        {
            return optional;
        }
        if (s == "rest")
        {
            return rest;
        }
        if (s == "key")
        {
            return key;
        }
        if (s == "default")
        {
            return dfault;
        } else
        {
            return new Special(s);
        }
    }

    public int hashCode()
    {
        return name.hashCode();
    }

    public void print(Consumer consumer)
    {
        consumer.write("#!");
        consumer.write(name);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        name = objectinput.readUTF();
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        return make(name);
    }

    public final String toString()
    {
        return (new StringBuilder()).append("#!").append(name).toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeUTF(name);
    }

    static 
    {
        eof = Sequence.eofValue;
    }
}
