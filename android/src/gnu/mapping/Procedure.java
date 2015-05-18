// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.bytecode.Type;
import gnu.expr.Expression;

// Referenced classes of package gnu.mapping:
//            PropertySet, Namespace, LazyPropertyKey, CallContext, 
//            WrongArguments, ProcedureN, MethodProc, HasSetter, 
//            Setter0, Setter1, Setter, Symbol

public abstract class Procedure extends PropertySet
{

    public static final LazyPropertyKey compilerKey = new LazyPropertyKey("compiler");
    private static final Symbol setterKey;
    private static final String sourceLocationKey = "source-location";
    public static final Symbol validateApplyKey;

    public Procedure()
    {
    }

    public Procedure(String s)
    {
        setName(s);
    }

    public static void apply(Procedure procedure, CallContext callcontext)
        throws Throwable
    {
        int i = callcontext.count;
        if (callcontext.where != 0 || i == 0) goto _L2; else goto _L1
_L1:
        procedure = ((Procedure) (procedure.applyN(callcontext.values)));
_L4:
        callcontext.writeValue(procedure);
        return;
_L2:
        switch (i)
        {
        default:
            procedure = ((Procedure) (procedure.applyN(callcontext.getArgs())));
            break;

        case 0: // '\0'
            procedure = ((Procedure) (procedure.apply0()));
            break;

        case 1: // '\001'
            procedure = ((Procedure) (procedure.apply1(callcontext.getNextArg())));
            break;

        case 2: // '\002'
            procedure = ((Procedure) (procedure.apply2(callcontext.getNextArg(), callcontext.getNextArg())));
            break;

        case 3: // '\003'
            procedure = ((Procedure) (procedure.apply3(callcontext.getNextArg(), callcontext.getNextArg(), callcontext.getNextArg())));
            break;

        case 4: // '\004'
            procedure = ((Procedure) (procedure.apply4(callcontext.getNextArg(), callcontext.getNextArg(), callcontext.getNextArg(), callcontext.getNextArg())));
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void checkArgCount(Procedure procedure, int i)
    {
        int j = procedure.numArgs();
        if (i < minArgs(j) || j >= 0 && i > maxArgs(j))
        {
            throw new WrongArguments(procedure, i);
        } else
        {
            return;
        }
    }

    public static int maxArgs(int i)
    {
        return i >> 12;
    }

    public static int minArgs(int i)
    {
        return i & 0xfff;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        apply(this, callcontext);
    }

    public abstract Object apply0()
        throws Throwable;

    public abstract Object apply1(Object obj)
        throws Throwable;

    public abstract Object apply2(Object obj, Object obj1)
        throws Throwable;

    public abstract Object apply3(Object obj, Object obj1, Object obj2)
        throws Throwable;

    public abstract Object apply4(Object obj, Object obj1, Object obj2, Object obj3)
        throws Throwable;

    public abstract Object applyN(Object aobj[])
        throws Throwable;

    public void check0(CallContext callcontext)
    {
        int i = match0(callcontext);
        if (i != 0)
        {
            throw MethodProc.matchFailAsException(i, this, ProcedureN.noArgs);
        } else
        {
            return;
        }
    }

    public void check1(Object obj, CallContext callcontext)
    {
        int i = match1(obj, callcontext);
        if (i != 0)
        {
            throw MethodProc.matchFailAsException(i, this, new Object[] {
                obj
            });
        } else
        {
            return;
        }
    }

    public void check2(Object obj, Object obj1, CallContext callcontext)
    {
        int i = match2(obj, obj1, callcontext);
        if (i != 0)
        {
            throw MethodProc.matchFailAsException(i, this, new Object[] {
                obj, obj1
            });
        } else
        {
            return;
        }
    }

    public void check3(Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        int i = match3(obj, obj1, obj2, callcontext);
        if (i != 0)
        {
            throw MethodProc.matchFailAsException(i, this, new Object[] {
                obj, obj1, obj2
            });
        } else
        {
            return;
        }
    }

    public void check4(Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        int i = match4(obj, obj1, obj2, obj3, callcontext);
        if (i != 0)
        {
            throw MethodProc.matchFailAsException(i, this, new Object[] {
                obj, obj1, obj2, obj3
            });
        } else
        {
            return;
        }
    }

    public void checkN(Object aobj[], CallContext callcontext)
    {
        int i = matchN(aobj, callcontext);
        if (i != 0)
        {
            throw MethodProc.matchFailAsException(i, this, aobj);
        } else
        {
            return;
        }
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Type.objectType;
    }

    public Procedure getSetter()
    {
        if (!(this instanceof HasSetter))
        {
            Object obj = getProperty(setterKey, null);
            if (obj instanceof Procedure)
            {
                return (Procedure)obj;
            } else
            {
                throw new RuntimeException((new StringBuilder()).append("procedure '").append(getName()).append("' has no setter").toString());
            }
        }
        int i = numArgs();
        if (i == 0)
        {
            return new Setter0(this);
        }
        if (i == 4097)
        {
            return new Setter1(this);
        } else
        {
            return new Setter(this);
        }
    }

    public String getSourceLocation()
    {
        Object obj = getProperty("source-location", null);
        if (obj == null)
        {
            return null;
        } else
        {
            return obj.toString();
        }
    }

    public boolean isSideEffectFree()
    {
        return false;
    }

    public int match0(CallContext callcontext)
    {
        int i = numArgs();
        int j = minArgs(i);
        if (j > 0)
        {
            return 0xfff10000 | j;
        }
        if (i < 0)
        {
            return matchN(ProcedureN.noArgs, callcontext);
        } else
        {
            callcontext.count = 0;
            callcontext.where = 0;
            callcontext.next = 0;
            callcontext.proc = this;
            return 0;
        }
    }

    public int match1(Object obj, CallContext callcontext)
    {
        int i = numArgs();
        int j = minArgs(i);
        if (j > 1)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            i = maxArgs(i);
            if (i < 1)
            {
                return 0xfff20000 | i;
            } else
            {
                callcontext.value1 = obj;
                callcontext.count = 1;
                callcontext.where = 1;
                callcontext.next = 0;
                callcontext.proc = this;
                return 0;
            }
        } else
        {
            return matchN(new Object[] {
                obj
            }, callcontext);
        }
    }

    public int match2(Object obj, Object obj1, CallContext callcontext)
    {
        int i = numArgs();
        int j = minArgs(i);
        if (j > 2)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            i = maxArgs(i);
            if (i < 2)
            {
                return 0xfff20000 | i;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.count = 2;
                callcontext.where = 33;
                callcontext.next = 0;
                callcontext.proc = this;
                return 0;
            }
        } else
        {
            return matchN(new Object[] {
                obj, obj1
            }, callcontext);
        }
    }

    public int match3(Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        int i = numArgs();
        int j = minArgs(i);
        if (j > 3)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            i = maxArgs(i);
            if (i < 3)
            {
                return 0xfff20000 | i;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.count = 3;
                callcontext.where = 801;
                callcontext.next = 0;
                callcontext.proc = this;
                return 0;
            }
        } else
        {
            return matchN(new Object[] {
                obj, obj1, obj2
            }, callcontext);
        }
    }

    public int match4(Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        int i = numArgs();
        int j = minArgs(i);
        if (j > 4)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            i = maxArgs(i);
            if (i < 4)
            {
                return 0xfff20000 | i;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.count = 4;
                callcontext.where = 17185;
                callcontext.next = 0;
                callcontext.proc = this;
                return 0;
            }
        } else
        {
            return matchN(new Object[] {
                obj, obj1, obj2, obj3
            }, callcontext);
        }
    }

    public int matchN(Object aobj[], CallContext callcontext)
    {
        int i = numArgs();
        int j = minArgs(i);
        if (aobj.length < j)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            switch (aobj.length)
            {
            default:
                i = maxArgs(i);
                if (aobj.length > i)
                {
                    return 0xfff20000 | i;
                }
                break;

            case 0: // '\0'
                return match0(callcontext);

            case 1: // '\001'
                return match1(aobj[0], callcontext);

            case 2: // '\002'
                return match2(aobj[0], aobj[1], callcontext);

            case 3: // '\003'
                return match3(aobj[0], aobj[1], aobj[2], callcontext);

            case 4: // '\004'
                return match4(aobj[0], aobj[1], aobj[2], aobj[3], callcontext);
            }
        }
        callcontext.values = aobj;
        callcontext.count = aobj.length;
        callcontext.where = 0;
        callcontext.next = 0;
        callcontext.proc = this;
        return 0;
    }

    public final int maxArgs()
    {
        return maxArgs(numArgs());
    }

    public final int minArgs()
    {
        return minArgs(numArgs());
    }

    public int numArgs()
    {
        return -4096;
    }

    public void set0(Object obj)
        throws Throwable
    {
        getSetter().apply1(obj);
    }

    public void set1(Object obj, Object obj1)
        throws Throwable
    {
        getSetter().apply2(obj, obj1);
    }

    public void setN(Object aobj[])
        throws Throwable
    {
        getSetter().applyN(aobj);
    }

    public void setSetter(Procedure procedure)
    {
        if (this instanceof HasSetter)
        {
            throw new RuntimeException((new StringBuilder()).append("procedure '").append(getName()).append("' has builtin setter - cannot be modified").toString());
        } else
        {
            setProperty(setterKey, procedure);
            return;
        }
    }

    public void setSourceLocation(String s, int i)
    {
        setProperty("source-location", (new StringBuilder()).append(s).append(":").append(i).toString());
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("#<procedure ");
        String s1 = getName();
        String s = s1;
        if (s1 == null)
        {
            s = getSourceLocation();
        }
        s1 = s;
        if (s == null)
        {
            s1 = getClass().getName();
        }
        stringbuffer.append(s1);
        stringbuffer.append('>');
        return stringbuffer.toString();
    }

    static 
    {
        setterKey = Namespace.EmptyNamespace.getSymbol("setter");
        validateApplyKey = Namespace.EmptyNamespace.getSymbol("validate-apply");
    }
}
