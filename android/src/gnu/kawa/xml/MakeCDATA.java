// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.xml.TextUtils;

// Referenced classes of package gnu.kawa.xml:
//            NodeConstructor

public class MakeCDATA extends MethodProc
{

    public static final MakeCDATA makeCDATA = new MakeCDATA();

    public MakeCDATA()
    {
    }

    public void apply(CallContext callcontext)
    {
        gnu.lists.Consumer consumer;
        gnu.xml.XMLFilter xmlfilter;
        consumer = callcontext.consumer;
        xmlfilter = NodeConstructor.pushNodeContext(callcontext);
        StringBuffer stringbuffer;
        String s;
        stringbuffer = new StringBuffer();
        s = Location.UNBOUND;
_L1:
        Object obj = callcontext.getNextArg(s);
        if (obj != s)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        int i = stringbuffer.length();
        char ac[] = new char[i];
        stringbuffer.getChars(0, i, ac, 0);
        xmlfilter.writeCDATA(ac, 0, i);
        NodeConstructor.popNodeContext(consumer, callcontext);
        return;
        TextUtils.stringValue(obj, stringbuffer);
          goto _L1
        Exception exception;
        exception;
        NodeConstructor.popNodeContext(consumer, callcontext);
        throw exception;
    }

}
