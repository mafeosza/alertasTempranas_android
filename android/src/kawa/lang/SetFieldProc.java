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
import gnu.mapping.Procedure2;
import gnu.mapping.Values;

public class SetFieldProc extends Procedure2
    implements Inlineable
{

    ClassType ctype;
    Field field;

    public SetFieldProc(ClassType classtype, String s)
    {
        ctype = classtype;
        field = Field.searchField(classtype.getFields(), s);
    }

    public SetFieldProc(ClassType classtype, String s, Type type, int i)
    {
        ctype = classtype;
        field = classtype.getField(s);
        if (field == null)
        {
            field = classtype.addField(s, type, i);
        }
    }

    public SetFieldProc(Class class1, String s)
    {
        this((ClassType)Type.make(class1), s);
    }

    public Object apply2(Object obj, Object obj1)
    {
        try
        {
            field.getReflectField().set(obj, field.getType().coerceFromObject(obj1));
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
        return Values.empty;
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        if (ctype.getReflectClass().getClassLoader() instanceof ArrayClassLoader)
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        } else
        {
            applyexp = applyexp.getArgs();
            applyexp[0].compile(compilation, ctype);
            applyexp[1].compile(compilation, field.getType());
            compilation.getCode().emitPutField(field);
            compilation.compileConstant(Values.empty, target);
            return;
        }
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Type.voidType;
    }
}
