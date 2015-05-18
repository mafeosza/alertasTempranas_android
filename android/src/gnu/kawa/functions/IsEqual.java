// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure2;

// Referenced classes of package gnu.kawa.functions:
//            Arithmetic, NumberCompare

public class IsEqual extends Procedure2
{

    Language language;

    public IsEqual(Language language1, String s)
    {
        language = language1;
        setName(s);
    }

    public static boolean apply(Object obj, Object obj1)
    {
        if (obj == obj1)
        {
            return true;
        }
        if (obj == null || obj1 == null)
        {
            return false;
        }
        if ((obj instanceof Number) && (obj1 instanceof Number))
        {
            return numberEquals((Number)obj, (Number)obj1);
        }
        if (obj instanceof CharSequence)
        {
            if (!(obj1 instanceof CharSequence))
            {
                return false;
            }
            obj = (CharSequence)obj;
            obj1 = (CharSequence)obj1;
            int i = ((CharSequence) (obj)).length();
            if (i != ((CharSequence) (obj1)).length())
            {
                return false;
            }
            do
            {
                int k = i - 1;
                if (k >= 0)
                {
                    i = k;
                    if (((CharSequence) (obj)).charAt(k) != ((CharSequence) (obj1)).charAt(k))
                    {
                        return false;
                    }
                } else
                {
                    return true;
                }
            } while (true);
        }
        if (obj instanceof FVector)
        {
            if (!(obj1 instanceof FVector))
            {
                return false;
            }
            obj = (FVector)obj;
            obj1 = (FVector)obj1;
            int j = ((FVector) (obj)).size;
            if (((FVector) (obj1)).data == null || ((FVector) (obj1)).size != j)
            {
                return false;
            }
            obj = ((Object) (((FVector) (obj)).data));
            obj1 = ((Object) (((FVector) (obj1)).data));
            do
            {
                int l = j - 1;
                if (l >= 0)
                {
                    j = l;
                    if (!apply(obj[l], obj1[l]))
                    {
                        return false;
                    }
                } else
                {
                    return true;
                }
            } while (true);
        } else
        if (obj instanceof LList)
        {
            if (!(obj instanceof Pair) || !(obj1 instanceof Pair))
            {
                return false;
            }
            Pair pair = (Pair)obj;
            obj = (Pair)obj1;
            obj1 = pair;
            do
            {
                if (!apply(((Pair) (obj1)).getCar(), ((Pair) (obj)).getCar()))
                {
                    return false;
                }
                obj1 = ((Pair) (obj1)).getCdr();
                obj = ((Pair) (obj)).getCdr();
                if (obj1 == obj)
                {
                    return true;
                }
                if (obj1 == null || obj == null)
                {
                    return false;
                }
                if (!(obj1 instanceof Pair) || !(obj instanceof Pair))
                {
                    return apply(obj1, obj);
                }
                obj1 = (Pair)obj1;
                obj = (Pair)obj;
            } while (true);
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static boolean numberEquals(Number number, Number number1)
    {
        boolean flag = Arithmetic.isExact(number);
        boolean flag1 = Arithmetic.isExact(number1);
        if (flag && flag1)
        {
            return NumberCompare.$Eq(number, number1);
        }
        return flag == flag1 && number.equals(number1);
    }

    public Object apply2(Object obj, Object obj1)
    {
        return language.booleanObject(apply(obj, obj1));
    }
}
