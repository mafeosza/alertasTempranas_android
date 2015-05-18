// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Procedure

public class WrongArguments extends IllegalArgumentException
{

    public int number;
    Procedure proc;
    public String procname;
    public String usage;

    public WrongArguments(Procedure procedure, int i)
    {
        proc = procedure;
        number = i;
    }

    public WrongArguments(String s, int i, String s1)
    {
        procname = s;
        number = i;
        usage = s1;
    }

    public static String checkArgCount(Procedure procedure, int i)
    {
        int j = procedure.numArgs();
        String s1 = procedure.getName();
        String s = s1;
        if (s1 == null)
        {
            s = procedure.getClass().getName();
        }
        return checkArgCount(s, j & 0xfff, j >> 12, i);
    }

    public static String checkArgCount(String s, int i, int j, int k)
    {
        StringBuffer stringbuffer;
        boolean flag;
        if (k < i)
        {
            flag = false;
        } else
        if (j >= 0 && k > j)
        {
            flag = true;
        } else
        {
            return null;
        }
        stringbuffer = new StringBuffer(100);
        stringbuffer.append("call to ");
        if (s == null)
        {
            stringbuffer.append("unnamed procedure");
        } else
        {
            stringbuffer.append('\'');
            stringbuffer.append(s);
            stringbuffer.append('\'');
        }
        if (flag)
        {
            s = " has too many";
        } else
        {
            s = " has too few";
        }
        stringbuffer.append(s);
        stringbuffer.append(" arguments (");
        stringbuffer.append(k);
        if (i != j) goto _L2; else goto _L1
_L1:
        stringbuffer.append("; must be ");
        stringbuffer.append(i);
_L4:
        stringbuffer.append(')');
        return stringbuffer.toString();
_L2:
        stringbuffer.append("; min=");
        stringbuffer.append(i);
        if (j >= 0)
        {
            stringbuffer.append(", max=");
            stringbuffer.append(j);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getMessage()
    {
        if (proc != null)
        {
            String s = checkArgCount(proc, number);
            if (s != null)
            {
                return s;
            }
        }
        return super.getMessage();
    }
}
