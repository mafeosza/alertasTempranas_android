// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Format;
import gnu.lists.FVector;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            genwrite

public class  extends ModuleBody
{

    Object display$Qu;
    Object output;
    Object width;

    public static Object lambda1isReadMacro(Object obj)
    {
        Object obj1 = lists.car.apply1(obj);
        obj = lists.cdr.apply1(obj);
        Object obj2 = Scheme.isEqv.apply2(obj1, genwrite.Lit30);
        boolean flag;
        if (obj2 == Boolean.FALSE ? (obj3 = Scheme.isEqv.apply2(obj1, genwrite.Lit31)) == Boolean.FALSE ? (obj3 = Scheme.isEqv.apply2(obj1, genwrite.Lit32)) == Boolean.FALSE ? Scheme.isEqv.apply2(obj1, genwrite.Lit33) != Boolean.FALSE : obj3 != Boolean.FALSE : obj3 != Boolean.FALSE : obj2 != Boolean.FALSE)
        {
            flag = lists.isPair(obj);
            Object obj3;
            if (flag)
            {
                if (lists.isNull(lists.cdr.apply1(obj)))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            }
        } else
        {
            return Boolean.FALSE;
        }
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static Object lambda2readMacroBody(Object obj)
    {
        return lists.cadr.apply1(obj);
    }

    public static Object lambda3readMacroPrefix(Object obj)
    {
        Object obj1 = lists.car.apply1(obj);
        lists.cdr.apply1(obj);
        if (Scheme.isEqv.apply2(obj1, genwrite.Lit30) != Boolean.FALSE)
        {
            return "'";
        }
        if (Scheme.isEqv.apply2(obj1, genwrite.Lit31) != Boolean.FALSE)
        {
            return "`";
        }
        if (Scheme.isEqv.apply2(obj1, genwrite.Lit32) != Boolean.FALSE)
        {
            return ",";
        }
        if (Scheme.isEqv.apply2(obj1, genwrite.Lit33) != Boolean.FALSE)
        {
            return ",@";
        } else
        {
            return Values.empty;
        }
    }

    public Object lambda4out(Object obj, Object obj1)
    {
        if (obj1 != Boolean.FALSE)
        {
            Object obj3 = Scheme.applyToArgs.apply2(output, obj);
            Object obj2 = obj3;
            if (obj3 != Boolean.FALSE)
            {
                obj2 = AddOp.$Pl;
                CharSequence charsequence;
                try
                {
                    charsequence = (CharSequence)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
                }
                obj2 = ((Procedure) (obj2)).apply2(obj1, Integer.valueOf(strings.stringLength(charsequence)));
            }
            return obj2;
        } else
        {
            return obj1;
        }
    }

    public Object lambda5wr(Object obj, Object obj1)
    {
        if (!lists.isPair(obj))
        {
            break MISSING_BLOCK_LABEL_186;
        }
        if (lambda1isReadMacro(obj) == Boolean.FALSE) goto _L2; else goto _L1
_L1:
        Object obj2 = lambda5wr(lambda2readMacroBody(obj), lambda4out(lambda3readMacroPrefix(obj), obj1));
_L4:
        return obj2;
_L2:
        Object obj3;
        obj3 = obj1;
        obj2 = obj;
_L6:
        if (!lists.isPair(obj2))
        {
            break MISSING_BLOCK_LABEL_177;
        }
        Object obj4 = lists.cdr.apply1(obj2);
        obj1 = obj4;
        obj = obj3;
        if (obj3 != Boolean.FALSE)
        {
            obj = lambda5wr(lists.car.apply1(obj2), lambda4out("(", obj3));
            obj1 = obj4;
        }
_L5:
        obj2 = obj;
        if (obj == Boolean.FALSE) goto _L4; else goto _L3
_L3:
        if (lists.isPair(obj1))
        {
            obj2 = lists.cdr.apply1(obj1);
            obj = lambda5wr(lists.car.apply1(obj1), lambda4out(" ", obj));
            obj1 = obj2;
        } else
        if (lists.isNull(obj1))
        {
            return lambda4out(")", obj);
        } else
        {
            return lambda4out(")", lambda5wr(obj1, lambda4out(" . ", obj)));
        }
          goto _L5
          goto _L4
        return lambda4out("()", obj3);
        obj2 = obj;
        obj3 = obj1;
        if (!lists.isNull(obj))
        {
            if (vectors.isVector(obj))
            {
                try
                {
                    obj2 = (FVector)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "vector->list", 1, obj);
                }
                obj2 = vectors.vector$To$List(((FVector) (obj2)));
                obj3 = lambda4out("#", obj1);
            } else
            {
                if (display$Qu != Boolean.FALSE)
                {
                    obj2 = "~a";
                } else
                {
                    obj2 = "~s";
                }
                return lambda4out(Format.formatToString(0, new Object[] {
                    obj2, obj
                }), obj1);
            }
        }
          goto _L6
    }

    public ()
    {
    }
}
