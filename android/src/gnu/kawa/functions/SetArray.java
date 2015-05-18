// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import java.lang.reflect.Array;

class SetArray extends Procedure2
{

    Object array;
    Type elementType;

    public SetArray(Object obj, Language language)
    {
        elementType = language.getTypeFor(obj.getClass().getComponentType());
        array = obj;
    }

    public Object apply2(Object obj, Object obj1)
    {
        obj1 = elementType.coerceFromObject(obj1);
        Array.set(array, ((Number)obj).intValue(), obj1);
        return Values.empty;
    }
}
