// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package kawa.lang:
//            Pattern

public class ListRepeatPat extends Pattern
    implements Printable, Externalizable
{

    Pattern element_pattern;

    public ListRepeatPat()
    {
    }

    public ListRepeatPat(Pattern pattern)
    {
        element_pattern = pattern;
    }

    public static ListRepeatPat make(Pattern pattern)
    {
        return new ListRepeatPat(pattern);
    }

    public boolean match(Object obj, Object aobj[], int i)
    {
        int j1 = LList.listLength(obj, false);
        if (j1 < 0)
        {
            return false;
        }
        int i1 = element_pattern.varCount();
        int j = i1;
        do
        {
            j--;
            if (j < 0)
            {
                break;
            }
            aobj[i + j] = ((Object) (new Object[j1]));
        } while (true);
        Object aobj1[] = new Object[i1];
        for (int k = 0; k < j1; k++)
        {
            obj = (Pair)obj;
            if (!element_pattern.match(((Pair) (obj)).getCar(), aobj1, 0))
            {
                return false;
            }
            for (int l = 0; l < i1; l++)
            {
                ((Object[])(Object[])aobj[i + l])[k] = aobj1[l];
            }

            obj = ((Pair) (obj)).getCdr();
        }

        return true;
    }

    public void print(Consumer consumer)
    {
        consumer.write("#<list-repeat-pattern ");
        element_pattern.print(consumer);
        consumer.write(62);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        element_pattern = (Pattern)objectinput.readObject();
    }

    public int varCount()
    {
        return element_pattern.varCount();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(element_pattern);
    }
}
