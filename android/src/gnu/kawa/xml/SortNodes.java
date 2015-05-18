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
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;

// Referenced classes of package gnu.kawa.xml:
//            SortedNodes

public class SortNodes extends Procedure1
    implements Inlineable
{

    public static final Method canonicalizeMethod;
    public static final Method makeSortedNodesMethod;
    public static final SortNodes sortNodes = new SortNodes();
    public static final ClassType typeSortedNodes;

    public SortNodes()
    {
    }

    public Object apply1(Object obj)
    {
        SortedNodes sortednodes = new SortedNodes();
        Values.writeValues(obj, sortednodes);
        if (sortednodes.count > 1)
        {
            return sortednodes;
        }
        if (sortednodes.count == 0)
        {
            return Values.empty;
        } else
        {
            return sortednodes.get(0);
        }
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Expression aexpression[] = applyexp.getArgs();
        if (aexpression.length != 1 || !compilation.mustCompile)
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        }
        if ((target instanceof ConsumerTarget) || (target instanceof StackTarget) && target.getType().isSubtype(Compilation.typeValues))
        {
            applyexp = null;
        } else
        {
            applyexp = canonicalizeMethod;
        }
        ConsumerTarget.compileUsingConsumer(aexpression[0], compilation, target, makeSortedNodesMethod, applyexp);
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Compilation.typeObject;
    }

    static 
    {
        typeSortedNodes = ClassType.make("gnu.kawa.xml.SortedNodes");
        makeSortedNodesMethod = typeSortedNodes.getDeclaredMethod("<init>", 0);
        canonicalizeMethod = Compilation.typeValues.getDeclaredMethod("canonicalize", 0);
    }
}
