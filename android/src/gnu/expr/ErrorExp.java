// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.mapping.OutPort;
import gnu.text.SourceMessages;

// Referenced classes of package gnu.expr:
//            Expression, Compilation, Target

public class ErrorExp extends Expression
{

    String message;

    public ErrorExp(String s)
    {
        message = s;
    }

    public ErrorExp(String s, Compilation compilation)
    {
        compilation.getMessages().error('e', s);
        message = s;
    }

    public ErrorExp(String s, SourceMessages sourcemessages)
    {
        sourcemessages.error('e', s);
        message = s;
    }

    public void compile(Compilation compilation, Target target)
    {
        throw new Error((new StringBuilder()).append(compilation.getFileName()).append(":").append(compilation.getLineNumber()).append(": internal error: compiling error expression: ").append(message).toString());
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        outport.startLogicalBlock("(Error", false, ")");
        outport.writeSpaceLinear();
        outport.print(message);
        outport.endLogicalBlock(")");
    }
}
