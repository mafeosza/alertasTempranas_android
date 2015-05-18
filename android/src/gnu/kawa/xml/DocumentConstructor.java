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
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;

// Referenced classes of package gnu.kawa.xml:
//            NodeConstructor

public class DocumentConstructor extends NodeConstructor
{

    public static final DocumentConstructor documentConstructor = new DocumentConstructor();
    static final Method endDocumentMethod;
    static final Method startDocumentMethod;

    public DocumentConstructor()
    {
    }

    public void apply(CallContext callcontext)
    {
        Consumer consumer;
        Object obj;
        consumer = callcontext.consumer;
        obj = pushNodeContext(callcontext);
        String s;
        s = Location.UNBOUND;
        ((Consumer) (obj)).startDocument();
_L1:
        Object obj1 = callcontext.getNextArg(s);
        if (obj1 != s)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        ((Consumer) (obj)).endDocument();
        popNodeContext(consumer, callcontext);
        return;
        if (!(obj1 instanceof Consumable))
        {
            break MISSING_BLOCK_LABEL_78;
        }
        ((Consumable)obj1).consume(((Consumer) (obj)));
          goto _L1
        obj;
        popNodeContext(consumer, callcontext);
        throw obj;
        ((Consumer) (obj)).writeObject(obj1);
          goto _L1
    }

    public void compileToNode(ApplyExp applyexp, Compilation compilation, ConsumerTarget consumertarget)
    {
        gnu.bytecode.Variable variable = consumertarget.getConsumerVariable();
        applyexp = applyexp.getArgs();
        int j = applyexp.length;
        CodeAttr codeattr = compilation.getCode();
        codeattr.emitLoad(variable);
        codeattr.emitInvokeInterface(startDocumentMethod);
        for (int i = 0; i < j; i++)
        {
            compileChild(applyexp[i], compilation, consumertarget);
        }

        codeattr.emitLoad(variable);
        codeattr.emitInvokeInterface(endDocumentMethod);
    }

    static 
    {
        startDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("startDocument", 0);
        endDocumentMethod = Compilation.typeConsumer.getDeclaredMethod("endDocument", 0);
    }
}
