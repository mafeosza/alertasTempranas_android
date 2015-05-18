// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.WrongType;

// Referenced classes of package gnu.expr:
//            Keyword, Language

public class GenericProc extends MethodProc
{

    int count;
    int maxArgs;
    protected MethodProc methods[];
    int minArgs;

    public GenericProc()
    {
    }

    public GenericProc(String s)
    {
        setName(s);
    }

    public static GenericProc make(Object aobj[])
    {
        GenericProc genericproc = new GenericProc();
        genericproc.setProperties(aobj);
        return genericproc;
    }

    public static transient GenericProc makeWithoutSorting(Object aobj[])
    {
        GenericProc genericproc = new GenericProc();
        int j = aobj.length;
        int i = 0;
        while (i < j) 
        {
            Object obj = aobj[i];
            if (obj instanceof Keyword)
            {
                obj = (Keyword)obj;
                i++;
                genericproc.setProperty(((Keyword) (obj)), aobj[i]);
            } else
            {
                genericproc.addAtEnd((MethodProc)obj);
            }
            i++;
        }
        return genericproc;
    }

    public void add(MethodProc methodproc)
    {
        this;
        JVM INSTR monitorenter ;
        int j;
        j = count;
        addAtEnd(methodproc);
        int i = 0;
_L2:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (MethodProc.mostSpecific(methodproc, methods[i]) != methodproc)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        System.arraycopy(methods, i, methods, i + 1, j - i);
        methods[i] = methodproc;
        this;
        JVM INSTR monitorexit ;
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        methodproc;
        throw methodproc;
    }

    protected void add(MethodProc amethodproc[])
    {
        this;
        JVM INSTR monitorenter ;
        int j;
        j = amethodproc.length;
        if (methods == null)
        {
            methods = new MethodProc[j];
        }
          goto _L1
_L3:
        int i;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        add(amethodproc[i]);
        i++;
        continue; /* Loop/switch isn't completed */
        return;
        amethodproc;
        throw amethodproc;
_L1:
        i = 0;
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void addAtEnd(MethodProc methodproc)
    {
        this;
        JVM INSTR monitorenter ;
        int i = count;
        if (methods != null) goto _L2; else goto _L1
_L1:
        methods = new MethodProc[8];
_L4:
        int j;
        methods[i] = methodproc;
        j = methodproc.minArgs();
        if (j < minArgs || count == 0)
        {
            minArgs = j;
        }
        j = methodproc.maxArgs();
        if (j == -1)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        if (j <= maxArgs)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        maxArgs = j;
        count = i + 1;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (i < methods.length) goto _L4; else goto _L3
_L3:
        MethodProc amethodproc[] = new MethodProc[methods.length * 2];
        System.arraycopy(methods, 0, amethodproc, 0, i);
        methods = amethodproc;
          goto _L4
        methodproc;
        throw methodproc;
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        if (count == 1)
        {
            return methods[0].applyN(aobj);
        }
        checkArgCount(this, aobj.length);
        CallContext callcontext = CallContext.getInstance();
        for (int i = 0; i < count; i++)
        {
            if (methods[i].matchN(aobj, callcontext) == 0)
            {
                return callcontext.runUntilValue();
            }
        }

        throw new WrongType(this, -1, null);
    }

    public MethodProc getMethod(int i)
    {
        if (i >= count)
        {
            return null;
        } else
        {
            return methods[i];
        }
    }

    public int getMethodCount()
    {
        return count;
    }

    public int isApplicable(Type atype[])
    {
        byte byte0 = -1;
        int i = count;
        do
        {
            int j;
            int k;
label0:
            {
                j = i - 1;
                i = byte0;
                if (j >= 0)
                {
                    k = methods[j].isApplicable(atype);
                    if (k != 1)
                    {
                        break label0;
                    }
                    i = 1;
                }
                return i;
            }
            i = j;
            if (k == 0)
            {
                byte0 = 0;
                i = j;
            }
        } while (true);
    }

    public int match0(CallContext callcontext)
    {
        boolean flag = false;
        if (count != 1) goto _L2; else goto _L1
_L1:
        int i = methods[0].match0(callcontext);
_L4:
        return i;
_L2:
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= count)
                {
                    break label1;
                }
                i = ((flag) ? 1 : 0);
                if (methods[j].match0(callcontext) == 0)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        callcontext.proc = null;
        return -1;
    }

    public int match1(Object obj, CallContext callcontext)
    {
        boolean flag = false;
        if (count != 1) goto _L2; else goto _L1
_L1:
        int i = methods[0].match1(obj, callcontext);
_L4:
        return i;
_L2:
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= count)
                {
                    break label1;
                }
                i = ((flag) ? 1 : 0);
                if (methods[j].match1(obj, callcontext) == 0)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        callcontext.proc = null;
        return -1;
    }

    public int match2(Object obj, Object obj1, CallContext callcontext)
    {
        boolean flag = false;
        if (count != 1) goto _L2; else goto _L1
_L1:
        int i = methods[0].match2(obj, obj1, callcontext);
_L4:
        return i;
_L2:
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= count)
                {
                    break label1;
                }
                i = ((flag) ? 1 : 0);
                if (methods[j].match2(obj, obj1, callcontext) == 0)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        callcontext.proc = null;
        return -1;
    }

    public int match3(Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        boolean flag = false;
        if (count != 1) goto _L2; else goto _L1
_L1:
        int i = methods[0].match3(obj, obj1, obj2, callcontext);
_L4:
        return i;
_L2:
        int j = 0;
label0:
        do
        {
label1:
            {
                if (j >= count)
                {
                    break label1;
                }
                i = ((flag) ? 1 : 0);
                if (methods[j].match3(obj, obj1, obj2, callcontext) == 0)
                {
                    break label0;
                }
                j++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        callcontext.proc = null;
        return -1;
    }

    public int match4(Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        if (count == 1)
        {
            return methods[0].match4(obj, obj1, obj2, obj3, callcontext);
        }
        for (int i = 0; i < count; i++)
        {
            if (methods[i].match4(obj, obj1, obj2, obj3, callcontext) == 0)
            {
                return 0;
            }
        }

        callcontext.proc = null;
        return -1;
    }

    public int matchN(Object aobj[], CallContext callcontext)
    {
        int ai[];
        int i;
        int j;
        if (count == 1)
        {
            return methods[0].matchN(aobj, callcontext);
        }
        j = aobj.length;
        Type atype[] = new Type[j];
        Language language = Language.getDefaultLanguage();
        i = 0;
        while (i < j) 
        {
            Object obj = aobj[i];
            if (obj == null)
            {
                obj = Type.nullType;
            } else
            {
                obj = obj.getClass();
                if (language != null)
                {
                    obj = language.getTypeFor(((Class) (obj)));
                } else
                {
                    obj = Type.make(((Class) (obj)));
                }
            }
            atype[i] = ((Type) (obj));
            i++;
        }
        ai = new int[count];
        j = 0;
        int k = 0;
        int l1 = -1;
        i = 0;
        while (i < count) 
        {
            int i2 = methods[i].isApplicable(atype);
            int i1 = l1;
            if (j == 0)
            {
                i1 = l1;
                if (i2 >= 0)
                {
                    i1 = i;
                }
            }
            int j1;
            int k1;
            if (i2 > 0)
            {
                j1 = j + 1;
                k1 = k;
            } else
            {
                j1 = j;
                k1 = k;
                if (i2 == 0)
                {
                    k1 = k + 1;
                    j1 = j;
                }
            }
            ai[i] = i2;
            i++;
            l1 = i1;
            j = j1;
            k = k1;
        }
        if (j == 1 || j == 0 && k == 1)
        {
            return methods[l1].matchN(aobj, callcontext);
        }
        i = 0;
_L3:
        int l;
        if (i >= count)
        {
            break; /* Loop/switch isn't completed */
        }
        l = ai[i];
          goto _L1
_L5:
        i++;
        if (true) goto _L3; else goto _L2
_L1:
        if (l < 0 || l == 0 && j > 0 || methods[i].matchN(aobj, callcontext) != 0) goto _L5; else goto _L4
_L4:
        return 0;
_L2:
        callcontext.proc = null;
        return -1;
    }

    public int numArgs()
    {
        return minArgs | maxArgs << 12;
    }

    public final void setProperties(Object aobj[])
    {
        int j = aobj.length;
        int i = 0;
        while (i < j) 
        {
            Object obj = aobj[i];
            if (obj instanceof Keyword)
            {
                obj = (Keyword)obj;
                i++;
                setProperty(((Keyword) (obj)), aobj[i]);
            } else
            {
                add((MethodProc)obj);
            }
            i++;
        }
    }

    public void setProperty(Keyword keyword, Object obj)
    {
        String s = keyword.getName();
        if (s == "name")
        {
            setName(obj.toString());
            return;
        }
        if (s == "method")
        {
            add((MethodProc)obj);
            return;
        } else
        {
            super.setProperty(keyword.asSymbol(), obj);
            return;
        }
    }
}
