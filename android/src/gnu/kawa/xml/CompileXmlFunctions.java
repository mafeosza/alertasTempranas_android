// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.QuoteExp;
import gnu.mapping.Procedure;

// Referenced classes of package gnu.kawa.xml:
//            MakeUnescapedData, TreeScanner, NodeSetType

public class CompileXmlFunctions
{

    public CompileXmlFunctions()
    {
    }

    public static Expression validateApplyMakeUnescapedData(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        type = applyexp.getArgs();
        inlinecalls = applyexp;
        if (type.length == 1)
        {
            inlinecalls = applyexp;
            if (type[0] instanceof QuoteExp)
            {
                inlinecalls = new QuoteExp(((MakeUnescapedData)procedure).apply1(((QuoteExp)type[0]).getValue()));
            }
        }
        return inlinecalls;
    }

    public static Expression validateApplyTreeScanner(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        inlinecalls = ((TreeScanner)procedure).type;
        if (applyexp.getTypeRaw() == null && (inlinecalls instanceof Type))
        {
            applyexp.setType(NodeSetType.getInstance((Type)inlinecalls));
        }
        return applyexp;
    }
}
