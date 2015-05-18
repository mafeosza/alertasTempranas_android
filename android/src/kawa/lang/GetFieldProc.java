// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure1;

public class GetFieldProc extends Procedure1
    implements Inlineable
{

    ClassType ctype;
    Field field;

    public GetFieldProc(ClassType classtype, String s)
    {
        ctype = classtype;
        field = Field.searchField(classtype.getFields(), s);
    }

    public GetFieldProc(ClassType classtype, String s, Type type, int i)
    {
        ctype = classtype;
        field = classtype.getField(s);
        if (field == null)
        {
            field = classtype.addField(s, type, i);
        }
    }

    public GetFieldProc(Class class1, String s)
    {
        this((ClassType)Type.make(class1), s);
    }

    private Field getField()
    {
        return field;
    }

    public Object apply1(Object obj)
    {
        try
        {
            obj = field.getReflectField().get(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder()).append("no such field ").append(field.getSourceName()).append(" in ").append(ctype.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder()).append("illegal access for field ").append(field.getSourceName()).toString());
        }
        return obj;
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        if (ctype.getReflectClass().getClassLoader() instanceof ArrayClassLoader)
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        } else
        {
            applyexp.getArgs()[0].compile(compilation, ctype);
            compilation.getCode().emitGetField(field);
            target.compileFromStack(compilation, field.getType());
            return;
        }
    }

    public Type getReturnType(Expression aexpression[])
    {
        return getField().getType();
    }
}
