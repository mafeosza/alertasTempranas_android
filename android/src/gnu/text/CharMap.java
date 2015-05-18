// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import gnu.kawa.util.AbstractWeakHashTable;

// Referenced classes of package gnu.text:
//            Char

class CharMap extends AbstractWeakHashTable
{

    CharMap()
    {
    }

    public Char get(int i)
    {
        cleanup();
        int j = hashToIndex(i);
        for (gnu.kawa.util.AbstractWeakHashTable.WEntry wentry = ((gnu.kawa.util.AbstractWeakHashTable.WEntry[])table)[j]; wentry != null; wentry = wentry.next)
        {
            Char char2 = (Char)wentry.getValue();
            if (char2.intValue() == i)
            {
                return char2;
            }
        }

        Char char1 = new Char(i);
        super.put(char1, char1);
        return char1;
    }

    protected Char getKeyFromValue(Char char1)
    {
        return char1;
    }

    protected volatile Object getKeyFromValue(Object obj)
    {
        return getKeyFromValue((Char)obj);
    }

    protected boolean matches(Char char1, Char char2)
    {
        return char1.intValue() == char2.intValue();
    }
}
