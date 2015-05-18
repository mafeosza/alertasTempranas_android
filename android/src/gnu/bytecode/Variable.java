// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.util.Enumeration;
import java.util.NoSuchElementException;

// Referenced classes of package gnu.bytecode:
//            Location, Type, CodeAttr, LocalVarsAttr, 
//            Method, Scope, Label

public class Variable extends Location
    implements Enumeration
{

    private static final int LIVE_FLAG = 4;
    private static final int PARAMETER_FLAG = 2;
    private static final int SIMPLE_FLAG = 1;
    static final int UNASSIGNED = -1;
    private int flags;
    Variable next;
    int offset;
    Scope scope;

    public Variable()
    {
        flags = 1;
        offset = -1;
    }

    public Variable(String s)
    {
        flags = 1;
        offset = -1;
        setName(s);
    }

    public Variable(String s, Type type)
    {
        flags = 1;
        offset = -1;
        setName(s);
        setType(type);
    }

    private void setFlag(boolean flag, int i)
    {
        if (flag)
        {
            flags = flags | i;
            return;
        } else
        {
            flags = flags & ~i;
            return;
        }
    }

    public void allocateLocal(CodeAttr codeattr)
    {
        if (offset == -1)
        {
            int i = 0;
            while (!reserveLocal(i, codeattr)) 
            {
                i++;
            }
        }
    }

    public final boolean dead()
    {
        return (flags & 4) == 0;
    }

    public void freeLocal(CodeAttr codeattr)
    {
        flags = flags & -5;
        int i;
        if (getType().size > 4)
        {
            i = 2;
        } else
        {
            i = 1;
        }
        i = offset + i;
        do
        {
            int j = i - 1;
            if (j < offset)
            {
                break;
            }
            codeattr.locals.used[j] = null;
            Type atype[] = codeattr.local_types;
            i = j;
            if (atype != null)
            {
                atype[j] = null;
                i = j;
            }
        } while (true);
    }

    public final boolean hasMoreElements()
    {
        return next != null;
    }

    public final boolean isAssigned()
    {
        return offset != -1;
    }

    public final boolean isParameter()
    {
        return (flags & 2) != 0;
    }

    public final boolean isSimple()
    {
        return (flags & 1) != 0;
    }

    public Object nextElement()
    {
        if (next == null)
        {
            throw new NoSuchElementException("Variable enumeration");
        } else
        {
            return next;
        }
    }

    public final Variable nextVar()
    {
        return next;
    }

    public boolean reserveLocal(int i, CodeAttr codeattr)
    {
        int l = getType().getSizeInWords();
        if (codeattr.locals.used != null) goto _L2; else goto _L1
_L1:
        codeattr.locals.used = new Variable[l + 20];
_L6:
        int j = 0;
_L4:
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        Variable avariable[];
        if (codeattr.locals.used[i + j] != null)
        {
            return false;
        }
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (codeattr.getMaxLocals() + l >= codeattr.locals.used.length)
        {
            avariable = new Variable[codeattr.locals.used.length * 2 + l];
            System.arraycopy(codeattr.locals.used, 0, avariable, 0, codeattr.getMaxLocals());
            codeattr.locals.used = avariable;
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        for (int k = 0; k < l; k++)
        {
            codeattr.locals.used[i + k] = this;
        }

        if (i + l > codeattr.getMaxLocals())
        {
            codeattr.setMaxLocals(i + l);
        }
        offset = i;
        flags = flags | 4;
        if (offset == 0 && "<init>".equals(codeattr.getMethod().getName()))
        {
            setType(codeattr.local_types[0]);
        }
        return true;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final void setParameter(boolean flag)
    {
        setFlag(flag, 2);
    }

    public final void setSimple(boolean flag)
    {
        setFlag(flag, 1);
    }

    boolean shouldEmit()
    {
        Object obj = scope;
        if (isSimple() && name != null && obj != null)
        {
            Label label = ((Scope) (obj)).start;
            if (label != null)
            {
                int i = label.position;
                if (i >= 0)
                {
                    obj = ((Scope) (obj)).end;
                    if (obj != null && ((Label) (obj)).position > i)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Variable[").append(getName()).append(" offset:").append(offset).append(']').toString();
    }
}
