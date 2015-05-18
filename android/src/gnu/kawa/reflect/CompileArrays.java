// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.Procedure;
import gnu.mapping.Values;

// Referenced classes of package gnu.kawa.reflect:
//            ArrayGet, ArrayLength, ArrayNew, ArraySet

public class CompileArrays
    implements Inlineable
{

    public char code;
    Procedure proc;

    public CompileArrays(Procedure procedure, char c)
    {
        proc = procedure;
        code = c;
    }

    public static void compileArrayGet(ArrayGet arrayget, ApplyExp applyexp, Compilation compilation, Target target)
    {
        arrayget = arrayget.element_type;
        applyexp = applyexp.getArgs();
        applyexp[0].compile(compilation, ArrayType.make(arrayget));
        applyexp[1].compile(compilation, Type.int_type);
        compilation.getCode().emitArrayLoad(arrayget);
        target.compileFromStack(compilation, arrayget);
    }

    public static void compileArrayLength(ArrayLength arraylength, ApplyExp applyexp, Compilation compilation, Target target)
    {
        arraylength = arraylength.element_type;
        applyexp.getArgs()[0].compile(compilation, ArrayType.make(arraylength));
        compilation.getCode().emitArrayLength();
        target.compileFromStack(compilation, LangPrimType.intType);
    }

    public static void compileArrayNew(ArrayNew arraynew, ApplyExp applyexp, Compilation compilation, Target target)
    {
        arraynew = arraynew.element_type;
        applyexp.getArgs()[0].compile(compilation, Type.intType);
        compilation.getCode().emitNewArray(arraynew.getImplementationType());
        target.compileFromStack(compilation, ArrayType.make(arraynew));
    }

    public static void compileArraySet(ArraySet arrayset, ApplyExp applyexp, Compilation compilation, Target target)
    {
        arrayset = arrayset.element_type;
        applyexp = applyexp.getArgs();
        applyexp[0].compile(compilation, ArrayType.make(arrayset));
        applyexp[1].compile(compilation, Type.int_type);
        applyexp[2].compile(compilation, arrayset);
        compilation.getCode().emitArrayStore(arrayset);
        compilation.compileConstant(Values.empty, target);
    }

    public static CompileArrays getForArrayGet(Object obj)
    {
        return new CompileArrays((Procedure)obj, 'G');
    }

    public static CompileArrays getForArrayLength(Object obj)
    {
        return new CompileArrays((Procedure)obj, 'L');
    }

    public static CompileArrays getForArrayNew(Object obj)
    {
        return new CompileArrays((Procedure)obj, 'N');
    }

    public static CompileArrays getForArraySet(Object obj)
    {
        return new CompileArrays((Procedure)obj, 'S');
    }

    public static Expression validateArrayGet(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        applyexp.setType(((ArrayGet)procedure).element_type);
        return applyexp;
    }

    public static Expression validateArrayLength(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        applyexp.setType(LangPrimType.intType);
        return applyexp;
    }

    public static Expression validateArrayNew(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        applyexp.setType(ArrayType.make(((ArrayNew)procedure).element_type));
        return applyexp;
    }

    public static Expression validateArraySet(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        applyexp.setType(Type.void_type);
        return applyexp;
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        switch (code)
        {
        default:
            compileArrayLength((ArrayLength)proc, applyexp, compilation, target);
            return;

        case 78: // 'N'
            compileArrayNew((ArrayNew)proc, applyexp, compilation, target);
            return;

        case 71: // 'G'
            compileArrayGet((ArrayGet)proc, applyexp, compilation, target);
            return;

        case 83: // 'S'
            compileArraySet((ArraySet)proc, applyexp, compilation, target);
            break;
        }
    }
}
