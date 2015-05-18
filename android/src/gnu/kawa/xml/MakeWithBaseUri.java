// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.lists.TreeList;
import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;

// Referenced classes of package gnu.kawa.xml:
//            NodeConstructor

public class MakeWithBaseUri extends NodeConstructor
{

    static final Method beginEntityMethod;
    static final Method endEntityMethod;
    public static final MakeWithBaseUri makeWithBaseUri = new MakeWithBaseUri();
    static final ClassType typeXConsumer;

    public MakeWithBaseUri()
    {
    }

    public void apply(CallContext callcontext)
    {
        gnu.lists.Consumer consumer;
        gnu.xml.XMLFilter xmlfilter;
        Object obj1;
        consumer = callcontext.consumer;
        xmlfilter = NodeConstructor.pushNodeContext(callcontext);
        Object obj = callcontext.getNextArg();
        obj1 = callcontext.getNextArg();
        if (xmlfilter instanceof XConsumer)
        {
            ((XConsumer)xmlfilter).beginEntity(obj);
        }
        Values.writeValues(obj1, xmlfilter);
        if (xmlfilter instanceof XConsumer)
        {
            ((XConsumer)xmlfilter).endEntity();
        }
        if (xmlfilter instanceof TreeList)
        {
            ((TreeList)xmlfilter).dump();
        }
        NodeConstructor.popNodeContext(consumer, callcontext);
        return;
        Exception exception;
        exception;
        if (xmlfilter instanceof XConsumer)
        {
            ((XConsumer)xmlfilter).endEntity();
        }
        if (xmlfilter instanceof TreeList)
        {
            ((TreeList)xmlfilter).dump();
        }
        NodeConstructor.popNodeContext(consumer, callcontext);
        throw exception;
    }

    public void compileToNode(ApplyExp applyexp, Compilation compilation, ConsumerTarget consumertarget)
    {
        gnu.bytecode.Variable variable = consumertarget.getConsumerVariable();
        applyexp = applyexp.getArgs();
        int i = applyexp.length;
        CodeAttr codeattr = compilation.getCode();
        codeattr.emitLoad(variable);
        applyexp[0].compile(compilation, Target.pushObject);
        codeattr.emitInvokeInterface(beginEntityMethod);
        compileChild(applyexp[1], compilation, consumertarget);
        codeattr.emitLoad(variable);
        codeattr.emitInvokeInterface(endEntityMethod);
    }

    public int numArgs()
    {
        return 8194;
    }

    static 
    {
        typeXConsumer = ClassType.make("gnu.lists.XConsumer");
        beginEntityMethod = typeXConsumer.getDeclaredMethod("beginEntity", 1);
        endEntityMethod = typeXConsumer.getDeclaredMethod("endEntity", 0);
    }
}
