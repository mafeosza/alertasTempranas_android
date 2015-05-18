// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.expr.Target;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;

// Referenced classes of package gnu.kawa.xml:
//            NodeConstructor

public class MakeAttribute extends NodeConstructor
{

    static final Method endAttributeMethod;
    public static final MakeAttribute makeAttribute;
    public static final QuoteExp makeAttributeExp;
    static final Method startAttributeMethod;
    static final ClassType typeMakeAttribute;

    public MakeAttribute()
    {
    }

    public static void startAttribute(Consumer consumer, Object obj)
    {
        consumer.startAttribute(obj);
    }

    public void apply(CallContext callcontext)
    {
        Consumer consumer;
        gnu.xml.XMLFilter xmlfilter;
        consumer = callcontext.consumer;
        xmlfilter = pushNodeContext(callcontext);
        Special special;
        startAttribute(xmlfilter, callcontext.getNextArg());
        special = Special.dfault;
_L1:
        Object obj = callcontext.getNextArg(special);
        if (obj != special)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        xmlfilter.endAttribute();
        popNodeContext(consumer, callcontext);
        return;
        if (!(obj instanceof Consumable))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        ((Consumable)obj).consume(xmlfilter);
          goto _L1
        Exception exception;
        exception;
        popNodeContext(consumer, callcontext);
        throw exception;
        callcontext.writeValue(obj);
          goto _L1
    }

    public void compileToNode(ApplyExp applyexp, Compilation compilation, ConsumerTarget consumertarget)
    {
        gnu.bytecode.Variable variable = consumertarget.getConsumerVariable();
        applyexp = applyexp.getArgs();
        int j = applyexp.length;
        CodeAttr codeattr = compilation.getCode();
        codeattr.emitLoad(variable);
        codeattr.emitDup();
        applyexp[0].compile(compilation, Target.pushObject);
        codeattr.emitInvokeStatic(startAttributeMethod);
        for (int i = 1; i < j; i++)
        {
            compileChild(applyexp[i], compilation, consumertarget);
        }

        codeattr.emitInvokeInterface(endAttributeMethod);
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Compilation.typeObject;
    }

    public int numArgs()
    {
        return -4095;
    }

    static 
    {
        makeAttribute = new MakeAttribute();
        makeAttributeExp = new QuoteExp(makeAttribute);
        typeMakeAttribute = ClassType.make("gnu.kawa.xml.MakeAttribute");
        startAttributeMethod = typeMakeAttribute.getDeclaredMethod("startAttribute", 2);
        endAttributeMethod = Compilation.typeConsumer.getDeclaredMethod("endAttribute", 0);
    }
}
