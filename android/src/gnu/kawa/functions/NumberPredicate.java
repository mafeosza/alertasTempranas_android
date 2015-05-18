// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import gnu.math.IntNum;

// Referenced classes of package gnu.kawa.functions:
//            Arithmetic

public class NumberPredicate extends Procedure1
    implements Inlineable
{

    public static final int EVEN = 2;
    public static final int ODD = 1;
    Language language;
    final int op;

    public NumberPredicate(Language language1, String s, int i)
    {
        super(s);
        language = language1;
        op = i;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyNumberPredicate");
    }

    public Object apply1(Object obj)
    {
        obj = LangObjType.coerceIntNum(obj);
        op;
        JVM INSTR tableswitch 1 2: default 32
    //                   1 40
    //                   2 54;
           goto _L1 _L2 _L3
_L1:
        throw new Error();
_L2:
        boolean flag = ((IntNum) (obj)).isOdd();
_L5:
        return getLanguage().booleanObject(flag);
_L3:
        if (!((IntNum) (obj)).isOdd())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Expression aexpression[] = applyexp.getArgs();
        if (aexpression.length == 1 && (op == 1 || op == 2))
        {
            Expression expression = aexpression[0];
            if (Arithmetic.classifyType(expression.getType()) <= 4)
            {
                applyexp = StackTarget.getInstance(Type.intType);
                CodeAttr codeattr = compilation.getCode();
                if (op == 2)
                {
                    codeattr.emitPushInt(1);
                }
                expression.compile(compilation, applyexp);
                codeattr.emitPushInt(1);
                codeattr.emitAnd();
                if (op == 2)
                {
                    codeattr.emitSub(Type.intType);
                }
                target.compileFromStack(compilation, Type.booleanType);
                return;
            }
        }
        ApplyExp.compile(applyexp, compilation, target);
    }

    protected final Language getLanguage()
    {
        return language;
    }

    public int numArgs()
    {
        return 4097;
    }
}
