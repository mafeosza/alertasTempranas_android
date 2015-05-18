// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.kawa.reflect.OccurrenceType;
import gnu.mapping.Values;

// Referenced classes of package gnu.expr:
//            Target, Compilation

public class StackTarget extends Target
{

    Type type;

    public StackTarget(Type type1)
    {
        type = type1;
    }

    static boolean compileFromStack0(Compilation compilation, Type type1, Type type2)
    {
        if (type2 != type1) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        CodeAttr codeattr;
        codeattr = compilation.getCode();
        if (type1.isVoid())
        {
            compilation.compileConstant(Values.empty);
            compilation = Type.pointer_type;
        } else
        {
            compilation = type1;
            if (type1 instanceof PrimType)
            {
                compilation = type1;
                if (type2 instanceof PrimType)
                {
                    codeattr.emitConvert(type1, type2);
                    return true;
                }
            }
        }
        if (!(compilation instanceof ArrayType))
        {
            break; /* Loop/switch isn't completed */
        }
        if (type2 == Type.pointer_type || "java.lang.Cloneable".equals(type2.getName()))
        {
            continue; /* Loop/switch isn't completed */
        }
_L4:
        if (CodeAttr.castNeeded(compilation.getImplementationType(), type2.getImplementationType()))
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        type2.emitConvertFromPrimitive(compilation, codeattr);
        compilation = codeattr.topType();
          goto _L4
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static void convert(Compilation compilation, Type type1, Type type2)
    {
        if (!compileFromStack0(compilation, type1, type2))
        {
            emitCoerceFromObject(type2, compilation);
        }
    }

    protected static void emitCoerceFromObject(Type type1, Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        if (type1 instanceof OccurrenceType)
        {
            compilation.compileConstant(type1, Target.pushObject);
            codeattr.emitSwap();
            codeattr.emitInvokeVirtual(ClassType.make("gnu.bytecode.Type").getDeclaredMethod("coerceFromObject", 1));
            return;
        } else
        {
            compilation.usedClass(type1);
            type1.emitCoerceFromObject(codeattr);
            return;
        }
    }

    public static Target getInstance(Type type1)
    {
        if (type1.isVoid())
        {
            return Target.Ignore;
        }
        if (type1 == Type.pointer_type)
        {
            return Target.pushObject;
        } else
        {
            return new StackTarget(type1);
        }
    }

    public void compileFromStack(Compilation compilation, Type type1)
    {
        if (!compileFromStack0(compilation, type1))
        {
            emitCoerceFromObject(type, compilation);
        }
    }

    protected boolean compileFromStack0(Compilation compilation, Type type1)
    {
        return compileFromStack0(compilation, type1, type);
    }

    public Type getType()
    {
        return type;
    }
}
