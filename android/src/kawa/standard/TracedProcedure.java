// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.kawa.functions.ObjectFormat;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.math.IntNum;
import java.io.IOException;
import java.io.PrintWriter;

public class TracedProcedure extends ProcedureN
{

    static Symbol curIndentSym = Symbol.makeUninterned("current-indentation");
    static int indentationStep = 2;
    boolean enabled;
    public Procedure proc;

    public TracedProcedure(Procedure procedure, boolean flag)
    {
        proc = procedure;
        enabled = flag;
        procedure = procedure.getName();
        if (procedure != null)
        {
            setName(procedure);
        }
    }

    public static Procedure doTrace(Procedure procedure, boolean flag)
    {
        if (procedure instanceof TracedProcedure)
        {
            ((TracedProcedure)procedure).enabled = flag;
            return procedure;
        } else
        {
            return new TracedProcedure(procedure, flag);
        }
    }

    static void indent(int i, PrintWriter printwriter)
    {
        do
        {
            i--;
            if (i >= 0)
            {
                printwriter.print(' ');
            } else
            {
                return;
            }
        } while (true);
    }

    static void put(Object obj, PrintWriter printwriter)
    {
        try
        {
            if (!ObjectFormat.format(obj, printwriter, 50, true))
            {
                printwriter.print("...");
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            printwriter.print("<caught ");
        }
        printwriter.print(obj);
        printwriter.print('>');
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        Object obj;
        Object obj1;
        Location location;
        OutPort outport;
        int i;
        if (!enabled)
        {
            break MISSING_BLOCK_LABEL_274;
        }
        location = Environment.getCurrent().getLocation(curIndentSym);
        obj = location.get(null);
        int k;
        if (!(obj instanceof IntNum))
        {
            i = 0;
            location.set(IntNum.zero());
        } else
        {
            i = ((IntNum)obj).intValue();
        }
        outport = OutPort.errDefault();
        obj1 = getName();
        obj = obj1;
        if (obj1 == null)
        {
            obj = "??";
        }
        indent(i, outport);
        outport.print("call to ");
        outport.print(((String) (obj)));
        k = aobj.length;
        outport.print(" (");
        for (int j = 0; j < k; j++)
        {
            if (j > 0)
            {
                outport.print(' ');
            }
            put(aobj[j], outport);
        }

        outport.println(")");
        obj1 = location.setWithSave(IntNum.make(indentationStep + i));
        aobj = ((Object []) (proc.applyN(aobj)));
        location.setRestore(obj1);
        indent(i, outport);
        outport.print("return from ");
        outport.print(((String) (obj)));
        outport.print(" => ");
        put(((Object) (aobj)), outport);
        outport.println();
        return ((Object) (aobj));
        aobj;
        indent(i, outport);
        outport.println((new StringBuilder()).append("procedure ").append(((String) (obj))).append(" throws exception ").append(((Object) (aobj))).toString());
        throw aobj;
        aobj;
        location.setRestore(obj1);
        throw aobj;
        return proc.applyN(aobj);
    }

    public void print(PrintWriter printwriter)
    {
        printwriter.print("#<procedure ");
        String s = getName();
        if (s == null)
        {
            printwriter.print("<unnamed>");
        } else
        {
            printwriter.print(s);
        }
        if (enabled)
        {
            s = ", traced>";
        } else
        {
            s = ">";
        }
        printwriter.print(s);
    }

}
