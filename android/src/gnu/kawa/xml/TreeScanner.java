// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.lists.PositionConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.kawa.xml:
//            KNode

public abstract class TreeScanner extends MethodProc
    implements Externalizable
{

    public NodePredicate type;

    TreeScanner()
    {
        setProperty(Procedure.validateApplyKey, "gnu.kawa.xml.CompileXmlFunctions:validateApplyTreeScanner");
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        PositionConsumer positionconsumer = (PositionConsumer)callcontext.consumer;
        Object obj = callcontext.getNextArg();
        callcontext.lastArg();
        try
        {
            callcontext = (KNode)obj;
        }
        // Misplaced declaration of an exception variable
        catch (CallContext callcontext)
        {
            throw new WrongType(getDesc(), -4, obj, "node()");
        }
        scan(((KNode) (callcontext)).sequence, callcontext.getPos(), positionconsumer);
    }

    public String getDesc()
    {
        String s1 = getClass().getName();
        int i = s1.lastIndexOf('.');
        String s = s1;
        if (i > 0)
        {
            s = s1.substring(i + 1);
        }
        return (new StringBuilder()).append(s).append("::").append(type).toString();
    }

    public NodePredicate getNodePredicate()
    {
        return type;
    }

    public int numArgs()
    {
        return 4097;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        type = (NodePredicate)objectinput.readObject();
    }

    public abstract void scan(AbstractSequence abstractsequence, int i, PositionConsumer positionconsumer);

    public String toString()
    {
        return (new StringBuilder()).append("#<").append(getClass().getName()).append(' ').append(type).append('>').toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(type);
    }
}
