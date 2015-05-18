// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.lists.Consumer;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package kawa.lang:
//            Pattern

public class AnyPat extends Pattern
    implements Printable, Externalizable
{

    public AnyPat()
    {
    }

    public static AnyPat make()
    {
        return new AnyPat();
    }

    public boolean match(Object obj, Object aobj[], int i)
    {
        aobj[i] = obj;
        return true;
    }

    public void print(Consumer consumer)
    {
        consumer.write("#<match any>");
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
    }

    public int varCount()
    {
        return 1;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
    }
}
