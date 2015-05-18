// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.expr.Declaration;
import gnu.mapping.Environment;
import gnu.mapping.Symbol;
import kawa.lang.Macro;

// Referenced classes of package gnu.kawa.reflect:
//            FieldLocation

public class StaticFieldLocation extends FieldLocation
{

    public StaticFieldLocation(ClassType classtype, String s)
    {
        super(null, classtype, s);
    }

    public StaticFieldLocation(String s, String s1)
    {
        super(null, ClassType.make(s), s1);
    }

    public StaticFieldLocation(java.lang.reflect.Field field)
    {
        super(null, field);
    }

    public static StaticFieldLocation define(Environment environment, Symbol symbol, Object obj, String s, String s1)
    {
        s = new StaticFieldLocation(s, s1);
        environment.addLocation(symbol, obj, s);
        return s;
    }

    public static StaticFieldLocation make(Declaration declaration)
    {
        Object obj = declaration.field;
        obj = new StaticFieldLocation(((Field) (obj)).getDeclaringClass(), ((Field) (obj)).getName());
        ((StaticFieldLocation) (obj)).setDeclaration(declaration);
        return ((StaticFieldLocation) (obj));
    }

    public static StaticFieldLocation make(String s, String s1)
    {
        return new StaticFieldLocation(s, s1);
    }

    public Object get(Object obj)
    {
        obj = super.get(obj);
        if (obj instanceof Macro)
        {
            getDeclaration();
        }
        return obj;
    }
}
