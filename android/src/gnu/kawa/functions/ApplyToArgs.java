// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;
import java.lang.reflect.Array;
import java.util.List;

public class ApplyToArgs extends ProcedureN
{

    Language language;

    public ApplyToArgs(String s, Language language1)
    {
        super(s);
        language = language1;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompilationHelpers:validateApplyToArgs");
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        Object obj = aobj[0];
        if (obj instanceof Procedure)
        {
            Object aobj1[] = new Object[aobj.length - 1];
            System.arraycopy(((Object) (aobj)), 1, ((Object) (aobj1)), 0, aobj1.length);
            return ((Procedure)obj).applyN(aobj1);
        }
        if ((obj instanceof Type) || (obj instanceof Class))
        {
            return Invoke.make.applyN(aobj);
        }
        if (obj instanceof List)
        {
            if (aobj.length != 2)
            {
                throw new WrongArguments(this, aobj.length);
            } else
            {
                int i = ((Number)aobj[1]).intValue();
                return ((List)obj).get(i);
            }
        }
        if (obj.getClass().isArray())
        {
            if (aobj.length != 2)
            {
                throw new WrongArguments(this, aobj.length);
            } else
            {
                return Array.get(obj, ((Number)aobj[1]).intValue());
            }
        } else
        {
            throw new WrongType(this, 0, obj, "procedure");
        }
    }

    public void check1(Object obj, CallContext callcontext)
    {
        if (obj instanceof Procedure)
        {
            ((Procedure)obj).check0(callcontext);
            return;
        } else
        {
            super.check1(obj, callcontext);
            return;
        }
    }

    public void check2(Object obj, Object obj1, CallContext callcontext)
    {
        if (obj instanceof Procedure)
        {
            ((Procedure)obj).check1(obj1, callcontext);
            return;
        } else
        {
            super.check2(obj, obj1, callcontext);
            return;
        }
    }

    public void check3(Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        if (obj instanceof Procedure)
        {
            ((Procedure)obj).check2(obj1, obj2, callcontext);
            return;
        } else
        {
            super.check3(obj, obj1, obj2, callcontext);
            return;
        }
    }

    public void check4(Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        if (obj instanceof Procedure)
        {
            ((Procedure)obj).check3(obj1, obj2, obj3, callcontext);
            return;
        } else
        {
            super.check4(obj, obj1, obj2, obj3, callcontext);
            return;
        }
    }

    public void checkN(Object aobj[], CallContext callcontext)
    {
        int i = matchN(aobj, callcontext);
        if (i != 0)
        {
            ApplyToArgs applytoargs = this;
            Object obj = applytoargs;
            callcontext = ((CallContext) (aobj));
            if (aobj.length > 0)
            {
                obj = applytoargs;
                callcontext = ((CallContext) (aobj));
                if (aobj[0] instanceof Procedure)
                {
                    obj = (Procedure)aobj[0];
                    callcontext = ((CallContext) (new Object[aobj.length - 1]));
                    System.arraycopy(((Object) (aobj)), 1, callcontext, 0, callcontext.length);
                }
            }
            throw MethodProc.matchFailAsException(i, ((Procedure) (obj)), callcontext);
        } else
        {
            return;
        }
    }

    public int match1(Object obj, CallContext callcontext)
    {
        if (obj instanceof Procedure)
        {
            return ((Procedure)obj).match0(callcontext);
        } else
        {
            return super.match1(obj, callcontext);
        }
    }

    public int match2(Object obj, Object obj1, CallContext callcontext)
    {
        if (obj instanceof Procedure)
        {
            return ((Procedure)obj).match1(obj1, callcontext);
        } else
        {
            return super.match2(obj, obj1, callcontext);
        }
    }

    public int match3(Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        if (obj instanceof Procedure)
        {
            return ((Procedure)obj).match2(obj1, obj2, callcontext);
        } else
        {
            return super.match3(obj, obj1, obj2, callcontext);
        }
    }

    public int match4(Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        if (obj instanceof Procedure)
        {
            return ((Procedure)obj).match3(obj1, obj2, obj3, callcontext);
        } else
        {
            return super.match4(obj, obj1, obj2, obj3, callcontext);
        }
    }

    public int matchN(Object aobj[], CallContext callcontext)
    {
        int i = aobj.length;
        if (i > 0 && (aobj[0] instanceof Procedure))
        {
            Procedure procedure = (Procedure)aobj[0];
            switch (i)
            {
            default:
                Object aobj1[] = new Object[i - 1];
                System.arraycopy(((Object) (aobj)), 1, ((Object) (aobj1)), 0, i - 1);
                return procedure.matchN(aobj1, callcontext);

            case 1: // '\001'
                return procedure.match0(callcontext);

            case 2: // '\002'
                return procedure.match1(aobj[1], callcontext);

            case 3: // '\003'
                return procedure.match2(aobj[1], aobj[2], callcontext);

            case 4: // '\004'
                return procedure.match3(aobj[1], aobj[2], aobj[3], callcontext);

            case 5: // '\005'
                return procedure.match4(aobj[1], aobj[2], aobj[3], aobj[4], callcontext);
            }
        } else
        {
            return super.matchN(aobj, callcontext);
        }
    }
}
