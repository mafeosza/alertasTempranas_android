// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure0;
import java.lang.reflect.Field;

public class StaticGet extends Procedure0
    implements Inlineable
{

    ClassType ctype;
    gnu.bytecode.Field field;
    String fname;
    Field reflectField;

    public StaticGet(ClassType classtype, String s, Type type, int i)
    {
        ctype = classtype;
        fname = s;
        field = classtype.getField(s);
        if (field == null)
        {
            field = classtype.addField(s, type, i);
        }
    }

    StaticGet(Class class1, String s)
    {
        ctype = (ClassType)Type.make(class1);
        fname = s;
    }

    private gnu.bytecode.Field getField()
    {
        if (field == null)
        {
            field = ctype.getField(fname);
            if (field == null)
            {
                field = ctype.addField(fname, Type.make(reflectField.getType()), reflectField.getModifiers());
            }
        }
        return field;
    }

    public Object apply0()
    {
        if (reflectField == null)
        {
            Object obj = ctype.getReflectClass();
            try
            {
                reflectField = ((Class) (obj)).getField(fname);
            }
            catch (NoSuchFieldException nosuchfieldexception)
            {
                throw new RuntimeException((new StringBuilder()).append("no such field ").append(fname).append(" in ").append(((Class) (obj)).getName()).toString());
            }
        }
        try
        {
            obj = reflectField.get(null);
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new RuntimeException((new StringBuilder()).append("illegal access for field ").append(fname).toString());
        }
        return obj;
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        getField();
        compilation.getCode().emitGetStatic(field);
        target.compileFromStack(compilation, field.getType());
    }

    public Type getReturnType(Expression aexpression[])
    {
        return getField().getType();
    }
}
