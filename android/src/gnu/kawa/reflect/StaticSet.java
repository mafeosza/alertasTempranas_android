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
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import java.lang.reflect.Field;

public class StaticSet extends Procedure1
    implements Inlineable
{

    ClassType ctype;
    gnu.bytecode.Field field;
    String fname;
    Field reflectField;

    public StaticSet(ClassType classtype, String s, Type type, int i)
    {
        ctype = classtype;
        fname = s;
        field = classtype.getField(s);
        if (field == null)
        {
            field = classtype.addField(s, type, i);
        }
    }

    StaticSet(Class class1, String s)
    {
        ctype = (ClassType)Type.make(class1);
        fname = s;
    }

    public Object apply1(Object obj)
    {
        if (reflectField == null)
        {
            Class class1 = ctype.getReflectClass();
            try
            {
                reflectField = class1.getField(fname);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException((new StringBuilder()).append("no such field ").append(fname).append(" in ").append(class1.getName()).toString());
            }
        }
        try
        {
            reflectField.set(null, obj);
            obj = Values.empty;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder()).append("illegal access for field ").append(fname).toString());
        }
        return obj;
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        if (field == null)
        {
            field = ctype.getField(fname);
            if (field == null)
            {
                field = ctype.addField(fname, Type.make(reflectField.getType()), reflectField.getModifiers());
            }
        }
        applyexp.getArgs()[0].compile(compilation, field.getType());
        compilation.getCode().emitPutStatic(field);
        compilation.compileConstant(Values.empty, target);
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Type.voidType;
    }
}
