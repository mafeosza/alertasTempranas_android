// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.xml.NodeTree;
import gnu.xml.XMLFilter;

// Referenced classes of package gnu.kawa.xml:
//            KNode

public abstract class NodeConstructor extends MethodProc
    implements Inlineable
{

    static final Method popNodeConsumerMethod;
    static final Method popNodeContextMethod;
    static final Method pushNodeConsumerMethod;
    static final Method pushNodeContextMethod;
    static final ClassType typeKNode = ClassType.make("gnu.kawa.xml.KNode");
    static final ClassType typeNodeConstructor;
    static final ClassType typeXMLFilter = ClassType.make("gnu.xml.XMLFilter");

    public NodeConstructor()
    {
    }

    public static void compileChild(Expression expression, Compilation compilation, ConsumerTarget consumertarget)
    {
        if (expression instanceof ApplyExp)
        {
            ApplyExp applyexp = (ApplyExp)expression;
            Object obj = applyexp.getFunction();
            if (obj instanceof QuoteExp)
            {
                obj = ((QuoteExp)obj).getValue();
                if (obj instanceof NodeConstructor)
                {
                    ((NodeConstructor)obj).compileToNode(applyexp, compilation, consumertarget);
                    return;
                }
            }
        }
        expression.compileWithPosition(compilation, consumertarget);
    }

    public static void compileUsingNodeTree(Expression expression, Compilation compilation, Target target)
    {
        ConsumerTarget.compileUsingConsumer(expression, compilation, target, typeNodeConstructor.getDeclaredMethod("makeNode", 0), typeNodeConstructor.getDeclaredMethod("finishNode", 1));
    }

    public static KNode finishNode(XMLFilter xmlfilter)
    {
        return KNode.make((NodeTree)xmlfilter.out);
    }

    public static XMLFilter makeNode()
    {
        return new XMLFilter(new NodeTree());
    }

    public static void popNodeConsumer(Consumer consumer, Consumer consumer1)
    {
        if (consumer != consumer1)
        {
            Object obj = consumer1;
            if (consumer1 instanceof XMLFilter)
            {
                obj = KNode.make((NodeTree)((XMLFilter)consumer1).out);
            }
            consumer.writeObject(obj);
        }
    }

    public static void popNodeContext(Consumer consumer, CallContext callcontext)
    {
        Consumer consumer1 = callcontext.consumer;
        if (consumer != consumer1)
        {
            Object obj = consumer1;
            if (consumer1 instanceof XMLFilter)
            {
                obj = KNode.make((NodeTree)((XMLFilter)consumer1).out);
            }
            consumer.writeObject(obj);
            callcontext.consumer = consumer;
        }
    }

    public static XMLFilter pushNodeConsumer(Consumer consumer)
    {
        if (consumer instanceof XMLFilter)
        {
            return (XMLFilter)consumer;
        } else
        {
            return new XMLFilter(new NodeTree());
        }
    }

    public static XMLFilter pushNodeContext(CallContext callcontext)
    {
        Consumer consumer = callcontext.consumer;
        if (consumer instanceof XMLFilter)
        {
            return (XMLFilter)consumer;
        } else
        {
            XMLFilter xmlfilter = new XMLFilter(new NodeTree());
            callcontext.consumer = xmlfilter;
            return xmlfilter;
        }
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        if (target instanceof IgnoreTarget)
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        }
        if (!(target instanceof ConsumerTarget))
        {
            compileUsingNodeTree(applyexp, compilation, target);
            return;
        }
        target = (ConsumerTarget)target;
        Variable variable = target.getConsumerVariable();
        if (variable.getType().isSubtype(typeXMLFilter))
        {
            compileToNode(applyexp, compilation, target);
            return;
        }
        int i = applyexp.getArgs().length;
        CodeAttr codeattr = compilation.getCode();
        Variable variable1 = codeattr.pushScope().addVariable(codeattr, typeXMLFilter, null);
        if (target.isContextTarget())
        {
            compilation.loadCallContext();
            codeattr.emitInvokeStatic(pushNodeContextMethod);
        } else
        {
            codeattr.emitLoad(variable);
            codeattr.emitInvokeStatic(pushNodeConsumerMethod);
        }
        codeattr.emitStore(variable1);
        codeattr.emitTryStart(true, Type.void_type);
        compileToNode(applyexp, compilation, new ConsumerTarget(variable1));
        codeattr.emitTryEnd();
        codeattr.emitFinallyStart();
        codeattr.emitLoad(variable);
        if (target.isContextTarget())
        {
            compilation.loadCallContext();
            codeattr.emitInvokeStatic(popNodeContextMethod);
        } else
        {
            codeattr.emitLoad(variable1);
            codeattr.emitInvokeStatic(popNodeConsumerMethod);
        }
        codeattr.emitFinallyEnd();
        codeattr.emitTryCatchEnd();
        codeattr.popScope();
    }

    public abstract void compileToNode(ApplyExp applyexp, Compilation compilation, ConsumerTarget consumertarget);

    public Type getReturnType(Expression aexpression[])
    {
        return Compilation.typeObject;
    }

    static 
    {
        typeNodeConstructor = ClassType.make("gnu.kawa.xml.NodeConstructor");
        pushNodeContextMethod = typeNodeConstructor.getDeclaredMethod("pushNodeContext", 1);
        popNodeContextMethod = typeNodeConstructor.getDeclaredMethod("popNodeContext", 2);
        pushNodeConsumerMethod = typeNodeConstructor.getDeclaredMethod("pushNodeConsumer", 1);
        popNodeConsumerMethod = typeNodeConstructor.getDeclaredMethod("popNodeConsumer", 2);
    }
}
