// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.text.Char;

// Referenced classes of package gnu.kawa.functions:
//            IsEqual, IsEq

public class IsEqv extends Procedure2
{

    IsEq isEq;
    Language language;

    public IsEqv(Language language1, String s, IsEq iseq)
    {
        language = language1;
        isEq = iseq;
        setName(s);
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompilationHelpers:validateIsEqv");
    }

    public static boolean apply(Object obj, Object obj1)
    {
        if (obj == obj1)
        {
            return true;
        }
        if ((obj instanceof Number) && (obj1 instanceof Number))
        {
            return IsEqual.numberEquals((Number)obj, (Number)obj1);
        }
        if ((obj instanceof Char) || (obj instanceof Symbol))
        {
            return obj.equals(obj1);
        } else
        {
            return false;
        }
    }

    public Object apply2(Object obj, Object obj1)
    {
        return language.booleanObject(apply(obj, obj1));
    }
}
