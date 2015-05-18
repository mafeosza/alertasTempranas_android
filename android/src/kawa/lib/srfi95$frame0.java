// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.DivideOp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;

// Referenced classes of package kawa.lib:
//            srfi95, lists

public class ion extends ModuleBody
{

    Object keyer;
    Object less$Qu;
    Object seq;

    public Object lambda2step(Object obj)
    {
        if (Scheme.numGrt.apply2(obj, srfi95.Lit1) != Boolean.FALSE)
        {
            Object obj1 = DivideOp.quotient.apply2(obj, srfi95.Lit1);
            return srfi95.sort$ClMerge$Ex(lambda2step(obj1), lambda2step(AddOp.$Mn.apply2(obj, obj1)), less$Qu, keyer);
        }
        if (Scheme.numEqu.apply2(obj, srfi95.Lit1) != Boolean.FALSE)
        {
            Object obj2 = lists.car.apply1(seq);
            Object obj3 = lists.cadr.apply1(seq);
            obj = seq;
            seq = lists.cddr.apply1(seq);
            if (Scheme.applyToArgs.apply3(less$Qu, Scheme.applyToArgs.apply2(keyer, obj3), Scheme.applyToArgs.apply2(keyer, obj2)) != Boolean.FALSE)
            {
                Pair pair;
                try
                {
                    pair = (Pair)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj2)
                {
                    throw new WrongType(((ClassCastException) (obj2)), "set-car!", 1, obj);
                }
                lists.setCar$Ex(pair, obj3);
                obj3 = lists.cdr.apply1(obj);
                try
                {
                    pair = (Pair)obj3;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj3);
                }
                lists.setCar$Ex(pair, obj2);
            }
            obj2 = lists.cdr.apply1(obj);
            try
            {
                obj3 = (Pair)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, obj2);
            }
            lists.setCdr$Ex(((Pair) (obj3)), LList.Empty);
            return obj;
        }
        if (Scheme.numEqu.apply2(obj, srfi95.Lit2) != Boolean.FALSE)
        {
            obj = seq;
            seq = lists.cdr.apply1(seq);
            try
            {
                obj2 = (Pair)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "set-cdr!", 1, obj);
            }
            lists.setCdr$Ex(((Pair) (obj2)), LList.Empty);
            return obj;
        } else
        {
            return LList.Empty;
        }
    }

    public ion()
    {
    }
}
