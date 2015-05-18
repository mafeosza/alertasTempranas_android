// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;

// Referenced classes of package kawa.lib:
//            srfi95, lists

public class ion extends ModuleBody
{

    Object key;
    Object less$Qu;

    public Object lambda3loop(Object obj, Object obj1, Object obj2, Object obj3, Object obj4)
    {
        if (Scheme.applyToArgs.apply3(less$Qu, obj4, obj2) != Boolean.FALSE)
        {
            try
            {
                obj4 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-cdr!", 1, obj);
            }
            lists.setCdr$Ex(((Pair) (obj4)), obj3);
            if (lists.isNull(lists.cdr.apply1(obj3)))
            {
                try
                {
                    obj = (Pair)obj3;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, obj3);
                }
                lists.setCdr$Ex(((Pair) (obj)), obj1);
                return Values.empty;
            } else
            {
                return lambda3loop(obj3, obj1, obj2, lists.cdr.apply1(obj3), Scheme.applyToArgs.apply2(key, lists.cadr.apply1(obj3)));
            }
        }
        try
        {
            obj2 = (Pair)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "set-cdr!", 1, obj);
        }
        lists.setCdr$Ex(((Pair) (obj2)), obj1);
        if (lists.isNull(lists.cdr.apply1(obj1)))
        {
            try
            {
                obj = (Pair)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, obj1);
            }
            lists.setCdr$Ex(((Pair) (obj)), obj3);
            return Values.empty;
        } else
        {
            return lambda3loop(obj1, lists.cdr.apply1(obj1), Scheme.applyToArgs.apply2(key, lists.cadr.apply1(obj1)), obj3, obj4);
        }
    }

    public ion()
    {
    }
}
