// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.mapping.OutPort;

// Referenced classes of package gnu.expr:
//            Expression, ExpVisitor, Compilation, Target

public class LangExp extends Expression
{

    Object hook;

    public LangExp()
    {
    }

    public LangExp(Object obj)
    {
        hook = obj;
    }

    public void compile(Compilation compilation, Target target)
    {
        throw new RuntimeException("compile called on LangExp");
    }

    public Object getLangValue()
    {
        return hook;
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        outport.print("(LangExp ???)");
    }

    public void setLangValue(Object obj)
    {
        hook = obj;
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitLangExp(this, obj);
    }
}
