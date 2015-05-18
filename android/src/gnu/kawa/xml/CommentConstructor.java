// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.XConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import gnu.mapping.Values;
import gnu.xml.TextUtils;

// Referenced classes of package gnu.kawa.xml:
//            NodeConstructor

public class CommentConstructor extends MethodProc
{

    public static final CommentConstructor commentConstructor = new CommentConstructor();

    public CommentConstructor()
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
        int i;
        int k;
        i = 1;
        k = 0;
_L3:
        Object obj = callcontext.getNextArg(s);
        if (obj != s)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        i = stringbuffer.length();
        char ac[] = new char[i];
        stringbuffer.getChars(0, i, ac, 0);
        xmlfilter.writeComment(ac, 0, i);
        NodeConstructor.popNodeContext(consumer, callcontext);
        return;
        if (!(obj instanceof Values))
        {
            break MISSING_BLOCK_LABEL_165;
        }
        obj = (Values)obj;
        int j = 0;
_L1:
        int l = ((Values) (obj)).nextPos(j);
        j = i;
        if (l == 0)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        stringbuffer.append(' ');
        i = 0;
        TextUtils.stringValue(((Values) (obj)).getPosPrevious(l), stringbuffer);
        j = l;
          goto _L1
        Exception exception;
        exception;
        NodeConstructor.popNodeContext(consumer, callcontext);
        throw exception;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        stringbuffer.append(' ');
        j = 0;
        TextUtils.stringValue(obj, stringbuffer);
        k++;
        i = j;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public int numArgs()
    {
        return 4097;
    }

}
