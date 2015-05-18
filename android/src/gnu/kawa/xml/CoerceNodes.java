// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;

// Referenced classes of package gnu.kawa.xml:
//            Nodes

public class CoerceNodes extends Procedure1
    implements Inlineable
{

    public static final CoerceNodes coerceNodes = new CoerceNodes();
    public static final Method makeNodesMethod;
    public static final ClassType typeNodes;

    public CoerceNodes()
    {
    }

    public Object apply1(Object obj)
    {
        Nodes nodes = new Nodes();
        Values.writeValues(obj, nodes);
        return nodes;
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Expression aexpression[] = applyexp.getArgs();
        if (aexpression.length != 1)
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        } else
        {
            ConsumerTarget.compileUsingConsumer(aexpression[0], compilation, target, makeNodesMethod, null);
            return;
        }
    }

    public Type getReturnType(Expression aexpression[])
    {
        return typeNodes;
    }

    static 
    {
        typeNodes = ClassType.make("gnu.kawa.xml.Nodes");
        makeNodesMethod = typeNodes.getDeclaredMethod("<init>", 0);
    }
}
