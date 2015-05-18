// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.kawa.functions.AppendValues;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;

// Referenced classes of package gnu.kawa.xml:
//            SortedNodes, SortNodes

public class UnionNodes extends Procedure2
    implements Inlineable
{

    public static final UnionNodes unionNodes = new UnionNodes();

    public UnionNodes()
    {
    }

    public Object apply2(Object obj, Object obj1)
    {
        SortedNodes sortednodes = new SortedNodes();
        Values.writeValues(obj, sortednodes);
        Values.writeValues(obj1, sortednodes);
        return sortednodes;
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        ConsumerTarget.compileUsingConsumer(new ApplyExp(AppendValues.appendValues, applyexp.getArgs()), compilation, target, SortNodes.makeSortedNodesMethod, null);
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Compilation.typeObject;
    }

}
