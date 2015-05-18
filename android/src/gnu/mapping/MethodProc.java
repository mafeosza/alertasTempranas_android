// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;

// Referenced classes of package gnu.mapping:
//            ProcedureN, WrongArguments, WrongType, CallContext, 
//            Procedure

public abstract class MethodProc extends ProcedureN
{

    public static final int NO_MATCH = -1;
    public static final int NO_MATCH_AMBIGUOUS = 0xfff30000;
    public static final int NO_MATCH_BAD_TYPE = 0xfff40000;
    public static final int NO_MATCH_TOO_FEW_ARGS = 0xfff10000;
    public static final int NO_MATCH_TOO_MANY_ARGS = 0xfff20000;
    static final Type unknownArgTypes[];
    protected Object argTypes;

    public MethodProc()
    {
    }

    public static RuntimeException matchFailAsException(int i, Procedure procedure, Object aobj[])
    {
        short word0 = (short)i;
        if ((i & 0xffff0000) != 0xfff40000)
        {
            return new WrongArguments(procedure, aobj.length);
        }
        if (word0 > 0)
        {
            aobj = ((Object []) (aobj[word0 - 1]));
        } else
        {
            aobj = null;
        }
        return new WrongType(procedure, word0, ((Object) (aobj)));
    }

    public static int mostSpecific(MethodProc amethodproc[], int i)
    {
        if (i > 1) goto _L2; else goto _L1
_L1:
        int j = i - 1;
_L8:
        return j;
_L2:
        Object obj1;
        Object obj2;
        int k;
        obj2 = amethodproc[0];
        obj1 = null;
        k = 1;
        j = 0;
_L4:
        if (k >= i)
        {
            continue; /* Loop/switch isn't completed */
        }
        MethodProc methodproc = amethodproc[k];
        if (obj2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = mostSpecific(((MethodProc) (obj2)), methodproc);
        MethodProc methodproc1;
        int l;
        if (obj == null)
        {
            obj = obj1;
            if (obj1 == null)
            {
                obj = new MethodProc[i];
            }
            obj[0] = obj2;
            obj[1] = methodproc;
            j = 2;
            obj2 = null;
            obj1 = obj;
            obj = obj2;
        } else
        if (obj == methodproc)
        {
            obj = methodproc;
            j = k;
        } else
        {
            obj = obj2;
        }
_L5:
        k++;
        obj2 = obj;
        if (true) goto _L4; else goto _L3
_L3:
        l = 0;
_L6:
        if (l >= j)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        obj = obj1[l];
        methodproc1 = mostSpecific(((MethodProc) (obj)), methodproc);
        if (methodproc1 == obj)
        {
            obj = obj2;
        } else
        {
label0:
            {
                if (methodproc1 != null)
                {
                    break label0;
                }
                l = j + 1;
                obj1[j] = methodproc;
                obj = obj2;
                j = l;
            }
        }
          goto _L5
        l++;
          goto _L6
        obj = methodproc;
        j = k;
          goto _L5
        if (obj2 != null) goto _L8; else goto _L7
_L7:
        return -1;
    }

    public static MethodProc mostSpecific(MethodProc methodproc, MethodProc methodproc1)
    {
        int i = 0;
        int k = 0;
        boolean flag = false;
        int j1 = methodproc.minArgs();
        int k1 = methodproc1.minArgs();
        int i2 = methodproc.maxArgs();
        int l1 = methodproc1.maxArgs();
        if (i2 >= 0 && i2 < k1 || l1 >= 0 && l1 < j1)
        {
            methodproc = null;
        } else
        {
            int l = methodproc.numParameters();
            int j = methodproc1.numParameters();
            if (l <= j)
            {
                l = j;
            }
            j = ((flag) ? 1 : 0);
            if (i2 != l1)
            {
                if (i2 < 0)
                {
                    k = 1;
                }
                i = k;
                j = ((flag) ? 1 : 0);
                if (l1 < 0)
                {
                    j = 1;
                    i = k;
                }
            }
            if (j1 < k1)
            {
                k = 1;
            } else
            {
                k = i;
                if (j1 > k1)
                {
                    j = 1;
                    k = i;
                }
            }
            for (i = 0; i < l; i++)
            {
                int i1 = methodproc.getParameterType(i).compare(methodproc1.getParameterType(i));
                if (i1 == -1)
                {
                    j = 1;
                    if (k != 0)
                    {
                        return null;
                    }
                }
                if (i1 != 1)
                {
                    continue;
                }
                k = 1;
                if (j != 0)
                {
                    return null;
                }
            }

            if (j == 0)
            {
                if (k != 0)
                {
                    return methodproc1;
                } else
                {
                    return null;
                }
            }
        }
        return methodproc;
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        checkArgCount(this, aobj.length);
        CallContext callcontext = CallContext.getInstance();
        checkN(aobj, callcontext);
        return callcontext.runUntilValue();
    }

    public Type getParameterType(int i)
    {
        if (!(argTypes instanceof Type[]))
        {
            resolveParameterTypes();
        }
        Type atype[] = (Type[])(Type[])argTypes;
        if (i < atype.length && (i < atype.length - 1 || maxArgs() >= 0))
        {
            return atype[i];
        }
        if (maxArgs() < 0)
        {
            Type type = atype[atype.length - 1];
            if (type instanceof ArrayType)
            {
                return ((ArrayType)type).getComponentType();
            }
        }
        return Type.objectType;
    }

    public int isApplicable(Type atype[])
    {
        int i;
        int j;
        j = atype.length;
        i = numArgs();
        if (j >= (i & 0xfff) && (i < 0 || j <= i >> 12)) goto _L2; else goto _L1
_L1:
        j = -1;
_L4:
        return j;
_L2:
        boolean flag = true;
        do
        {
            int k = j - 1;
            j = ((flag) ? 1 : 0);
            if (k < 0)
            {
                continue;
            }
            int l = getParameterType(k).compare(atype[k]);
            if (l == -3)
            {
                return -1;
            }
            j = k;
            if (l < 0)
            {
                flag = false;
                j = k;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int numParameters()
    {
        int i = numArgs();
        int j = i >> 12;
        if (j >= 0)
        {
            return j;
        } else
        {
            return (i & 0xfff) + 1;
        }
    }

    protected void resolveParameterTypes()
    {
        argTypes = unknownArgTypes;
    }

    static 
    {
        unknownArgTypes = (new Type[] {
            Type.pointer_type
        });
    }
}
