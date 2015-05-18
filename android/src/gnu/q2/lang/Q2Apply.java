// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.q2.lang;

import gnu.bytecode.Type;
import gnu.expr.Special;
import gnu.kawa.reflect.Invoke;
import gnu.lists.Consumable;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import java.util.Vector;

public class Q2Apply extends MethodProc
{

    public static Q2Apply q2Apply = new Q2Apply();

    public Q2Apply()
    {
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object obj;
        Special special;
label0:
        {
            special = Special.dfault;
            Object obj1 = callcontext.getNextArg(special);
            if (!(obj1 instanceof Procedure) && !(obj1 instanceof Type))
            {
                obj = obj1;
                if (!(obj1 instanceof Class))
                {
                    break label0;
                }
            }
            Vector vector = new Vector();
            if (obj1 instanceof Procedure)
            {
                obj = (Procedure)obj1;
            } else
            {
                vector.add(obj1);
                obj = Invoke.make;
            }
            do
            {
                obj1 = callcontext.getNextArg(special);
                if (obj1 == special)
                {
                    obj = ((Procedure) (obj)).applyN(vector.toArray());
                    int i;
                    if (obj instanceof Consumable)
                    {
                        ((Consumable)obj).consume(callcontext.consumer);
                        return;
                    } else
                    {
                        callcontext.writeValue(obj);
                        return;
                    }
                }
                if (obj1 instanceof Values)
                {
                    obj1 = ((Object) (((Values)obj1).getValues()));
                    i = 0;
                    while (i < obj1.length) 
                    {
                        vector.add(obj1[i]);
                        i++;
                    }
                } else
                {
                    vector.add(obj1);
                }
            } while (true);
        }
        while (obj != special) 
        {
            if (obj instanceof Consumable)
            {
                ((Consumable)obj).consume(callcontext.consumer);
            } else
            {
                callcontext.writeValue(obj);
            }
            obj = callcontext.getNextArg(special);
        }
    }

}
