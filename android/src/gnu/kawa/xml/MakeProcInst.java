// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.lists.Consumer;
import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.xml.TextUtils;

// Referenced classes of package gnu.kawa.xml:
//            NodeConstructor, KNode, UntypedAtomic

public class MakeProcInst extends NodeConstructor
{

    public static final MakeProcInst makeProcInst = new MakeProcInst();

    public MakeProcInst()
    {
    }

    public static void procInst$C(Object obj, Object obj1, Consumer consumer)
    {
        obj = KNode.atomicValue(obj);
        if (!(obj instanceof String) && !(obj instanceof UntypedAtomic))
        {
            throw new ClassCastException("invalid type of processing-instruction target [XPTY0004]");
        }
        if (!(consumer instanceof XConsumer))
        {
            return;
        }
        StringBuffer stringbuffer = new StringBuffer();
        if (obj1 instanceof Values)
        {
            obj1 = ((Object) (((Values)obj1).getValues()));
            for (int i = 0; i < obj1.length; i++)
            {
                if (i > 0)
                {
                    stringbuffer.append(' ');
                }
                TextUtils.stringValue(obj1[i], stringbuffer);
            }

        } else
        {
            TextUtils.stringValue(obj1, stringbuffer);
        }
        int k = stringbuffer.length();
        int j;
        for (j = 0; j < k && Character.isWhitespace(stringbuffer.charAt(j)); j++) { }
        obj1 = new char[k - j];
        stringbuffer.getChars(j, k, ((char []) (obj1)), 0);
        ((XConsumer)consumer).writeProcessingInstruction(obj.toString(), ((char []) (obj1)), 0, obj1.length);
    }

    public static void procInst$X(Object obj, Object obj1, CallContext callcontext)
    {
        Consumer consumer;
        gnu.xml.XMLFilter xmlfilter;
        consumer = callcontext.consumer;
        xmlfilter = NodeConstructor.pushNodeContext(callcontext);
        procInst$C(obj, obj1, xmlfilter);
        NodeConstructor.popNodeContext(consumer, callcontext);
        return;
        obj;
        NodeConstructor.popNodeContext(consumer, callcontext);
        throw obj;
    }

    public void apply(CallContext callcontext)
    {
        procInst$X(callcontext.getNextArg(null), callcontext.getNextArg(null), callcontext);
    }

    public void compileToNode(ApplyExp applyexp, Compilation compilation, ConsumerTarget consumertarget)
    {
        CodeAttr codeattr = compilation.getCode();
        applyexp = applyexp.getArgs();
        applyexp[0].compile(compilation, Target.pushObject);
        applyexp[1].compile(compilation, Target.pushObject);
        codeattr.emitLoad(consumertarget.getConsumerVariable());
        codeattr.emitInvokeStatic(ClassType.make("gnu.kawa.xml.MakeProcInst").getDeclaredMethod("procInst$C", 3));
    }

    public int numArgs()
    {
        return 8194;
    }

}
