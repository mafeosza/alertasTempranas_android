// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.Target;
import gnu.mapping.Procedure2;

public class IsEq extends Procedure2
    implements Inlineable
{

    Language language;

    public IsEq(Language language1, String s)
    {
        language = language1;
        setName(s);
    }

    public static void compile(Expression aexpression[], Compilation compilation, Target target, Language language1)
    {
        CodeAttr codeattr = compilation.getCode();
        aexpression[0].compile(compilation, Target.pushObject);
        aexpression[1].compile(compilation, Target.pushObject);
        if (target instanceof ConditionalTarget)
        {
            aexpression = (ConditionalTarget)target;
            if (((ConditionalTarget) (aexpression)).trueBranchComesFirst)
            {
                codeattr.emitGotoIfNE(((ConditionalTarget) (aexpression)).ifFalse);
            } else
            {
                codeattr.emitGotoIfEq(((ConditionalTarget) (aexpression)).ifTrue);
            }
            aexpression.emitGotoFirstBranch(codeattr);
            return;
        }
        codeattr.emitIfEq();
        if (target.getType() instanceof ClassType)
        {
            aexpression = ((Expression []) (language1.booleanObject(true)));
            language1 = ((Language) (language1.booleanObject(false)));
            compilation.compileConstant(aexpression, Target.pushObject);
            codeattr.emitElse();
            compilation.compileConstant(language1, Target.pushObject);
            if ((aexpression instanceof Boolean) && (language1 instanceof Boolean))
            {
                aexpression = Compilation.scmBooleanType;
            } else
            {
                aexpression = Type.pointer_type;
            }
        } else
        {
            codeattr.emitPushInt(1);
            codeattr.emitElse();
            codeattr.emitPushInt(0);
            aexpression = language1.getTypeFor(Boolean.TYPE);
        }
        codeattr.emitFi();
        target.compileFromStack(compilation, aexpression);
    }

    public boolean apply(Object obj, Object obj1)
    {
        return obj == obj1;
    }

    public Object apply2(Object obj, Object obj1)
    {
        Language language1 = language;
        boolean flag;
        if (obj == obj1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return language1.booleanObject(flag);
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        compile(applyexp.getArgs(), compilation, target, language);
    }

    public Type getReturnType(Expression aexpression[])
    {
        return language.getTypeFor(Boolean.TYPE);
    }
}
