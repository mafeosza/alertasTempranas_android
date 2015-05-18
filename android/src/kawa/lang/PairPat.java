// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package kawa.lang:
//            Pattern

public class PairPat extends Pattern
    implements Printable, Externalizable
{

    Pattern car;
    private int car_count;
    Pattern cdr;
    private int cdr_count;

    public PairPat()
    {
    }

    public PairPat(Pattern pattern, Pattern pattern1)
    {
        car = pattern;
        cdr = pattern1;
        car_count = pattern.varCount();
        cdr_count = pattern1.varCount();
    }

    public static PairPat make(Pattern pattern, Pattern pattern1)
    {
        return new PairPat(pattern, pattern1);
    }

    public boolean match(Object obj, Object aobj[], int i)
    {
        if (obj instanceof Pair)
        {
            if (car.match(((Pair) (obj = (Pair)obj)).getCar(), aobj, i) && cdr.match(((Pair) (obj)).getCdr(), aobj, car_count + i))
            {
                return true;
            }
        }
        return false;
    }

    public void print(Consumer consumer)
    {
        consumer.write("#<pair-pattern car: ");
        car.print(consumer);
        consumer.write(" cdr: ");
        cdr.print(consumer);
        consumer.write(62);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        car = (Pattern)objectinput.readObject();
        cdr = (Pattern)objectinput.readObject();
    }

    public int varCount()
    {
        return car_count + cdr_count;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(car);
        objectoutput.writeObject(cdr);
    }
}
