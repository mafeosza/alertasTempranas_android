// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.mapping.CallContext;
import gnu.mapping.Values;
import gnu.xml.NodeTree;
import gnu.xml.TextUtils;
import gnu.xml.XMLFilter;

// Referenced classes of package gnu.kawa.xml:
//            NodeConstructor, KText

public class MakeText extends NodeConstructor
{

    public static final MakeText makeText = new MakeText();

    public MakeText()
    {
    }

    public static void text$X(Object obj, CallContext callcontext)
    {
        gnu.lists.Consumer consumer;
        XMLFilter xmlfilter;
        if (obj == null || (obj instanceof Values) && ((Values)obj).isEmpty())
        {
            return;
        }
        consumer = callcontext.consumer;
        xmlfilter = NodeConstructor.pushNodeContext(callcontext);
        TextUtils.textValue(obj, xmlfilter);
        NodeConstructor.popNodeContext(consumer, callcontext);
        return;
        obj;
        NodeConstructor.popNodeContext(consumer, callcontext);
        throw obj;
    }

    public void apply(CallContext callcontext)
    {
        text$X(callcontext.getNextArg(null), callcontext);
    }

    public Object apply1(Object obj)
    {
        if (obj == null || (obj instanceof Values) && ((Values)obj).isEmpty())
        {
            return obj;
        } else
        {
            NodeTree nodetree = new NodeTree();
            TextUtils.textValue(obj, new XMLFilter(nodetree));
            return KText.make(nodetree);
        }
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        ApplyExp.compile(applyexp, compilation, target);
    }

    public void compileToNode(ApplyExp applyexp, Compilation compilation, ConsumerTarget consumertarget)
    {
label0:
        {
            CodeAttr codeattr = compilation.getCode();
            Object obj = applyexp.getArgs()[0];
            applyexp = consumertarget.getConsumerVariable();
            if (obj instanceof QuoteExp)
            {
                consumertarget = ((ConsumerTarget) (((QuoteExp)obj).getValue()));
                if (consumertarget instanceof String)
                {
                    compilation = (String)consumertarget;
                    consumertarget = CodeAttr.calculateSplit(compilation);
                    int l = consumertarget.length();
                    obj = ((ClassType)applyexp.getType()).getMethod("write", new Type[] {
                        Type.string_type
                    });
                    int j = 0;
                    for (int i = 0; i < l; i++)
                    {
                        codeattr.emitLoad(applyexp);
                        int k = j + consumertarget.charAt(i);
                        codeattr.emitPushString(compilation.substring(j, k));
                        codeattr.emitInvoke(((gnu.bytecode.Method) (obj)));
                        j = k;
                    }

                    break label0;
                }
            }
            ((Expression) (obj)).compile(compilation, Target.pushObject);
            codeattr.emitLoad(applyexp);
            codeattr.emitInvokeStatic(ClassType.make("gnu.xml.TextUtils").getDeclaredMethod("textValue", 2));
        }
    }

    public int numArgs()
    {
        return 4097;
    }

}
