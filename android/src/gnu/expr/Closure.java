// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.MethodProc;
import java.lang.reflect.Array;

// Referenced classes of package gnu.expr:
//            LambdaExp, ScopeExp, Expression, Declaration, 
//            Keyword, Special

class Closure extends MethodProc
{

    Object evalFrames[][];
    LambdaExp lambda;

    public Closure(LambdaExp lambdaexp, CallContext callcontext)
    {
        lambda = lambdaexp;
        lambdaexp = ((LambdaExp) (callcontext.evalFrames));
        if (lambdaexp != null)
        {
            int i;
            for (i = lambdaexp.length; i > 0 && lambdaexp[i - 1] == null; i--) { }
            evalFrames = new Object[i][];
            System.arraycopy(lambdaexp, 0, ((Object) (evalFrames)), 0, i);
        }
        setSymbol(lambda.getSymbol());
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object aobj2[][];
        int k = ScopeExp.nesting(lambda);
        Object aobj[] = callcontext.values;
        aobj2 = callcontext.evalFrames;
        String s;
        Exception exception;
        Object aobj1[][];
        String s1;
        StringBuffer stringbuffer;
        int i;
        int j;
        if (evalFrames == null)
        {
            i = 0;
        } else
        {
            i = evalFrames.length;
        }
        j = i;
        if (k >= i)
        {
            j = k;
        }
        aobj1 = new Object[j + 10][];
        if (evalFrames != null)
        {
            System.arraycopy(((Object) (evalFrames)), 0, ((Object) (aobj1)), 0, evalFrames.length);
        }
        aobj1[k] = aobj;
        callcontext.evalFrames = aobj1;
        if (lambda.body != null)
        {
            break MISSING_BLOCK_LABEL_201;
        }
        stringbuffer = new StringBuffer("procedure ");
        s1 = lambda.getName();
        s = s1;
        if (s1 == null)
        {
            s = "<anonymous>";
        }
        stringbuffer.append(s);
        i = lambda.getLineNumber();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        stringbuffer.append(" at line ");
        stringbuffer.append(i);
        stringbuffer.append(" was called before it was expanded");
        throw new RuntimeException(stringbuffer.toString());
        exception;
        callcontext.evalFrames = aobj2;
        throw exception;
        lambda.body.apply(callcontext);
        callcontext.evalFrames = aobj2;
        return;
    }

    public Object getProperty(Object obj, Object obj1)
    {
        Object obj3 = super.getProperty(obj, obj1);
        Object obj2 = obj3;
        if (obj3 == null)
        {
            obj2 = lambda.getProperty(obj, obj1);
        }
        return obj2;
    }

    public int match0(CallContext callcontext)
    {
        return matchN(new Object[0], callcontext);
    }

    public int match1(Object obj, CallContext callcontext)
    {
        return matchN(new Object[] {
            obj
        }, callcontext);
    }

    public int match2(Object obj, Object obj1, CallContext callcontext)
    {
        return matchN(new Object[] {
            obj, obj1
        }, callcontext);
    }

    public int match3(Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        return matchN(new Object[] {
            obj, obj1, obj2
        }, callcontext);
    }

    public int match4(Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        return matchN(new Object[] {
            obj, obj1, obj2, obj3
        }, callcontext);
    }

    public int matchN(Object aobj[], CallContext callcontext)
    {
        Object obj;
        Declaration declaration;
        Object aobj1[];
        int i;
        int j;
        int k;
        int l;
        int k1;
        int l1;
        i = numArgs();
        k1 = aobj.length;
        j = i & 0xfff;
        if (k1 < j)
        {
            return 0xfff10000 | j;
        }
        i >>= 12;
        if (k1 > i && i >= 0)
        {
            return 0xfff20000 | i;
        }
        aobj1 = new Object[lambda.frameSize];
        Object obj1;
        int i1;
        if (lambda.keywords == null)
        {
            i = 0;
        } else
        {
            i = lambda.keywords.length;
        }
        if (lambda.defaultArgs == null)
        {
            l = 0;
        } else
        {
            l = lambda.defaultArgs.length - i;
        }
        k = 0;
        l1 = lambda.min_args;
        declaration = lambda.firstDecl();
        j = 0;
        i = 0;
_L3:
        if (declaration == null)
        {
            break MISSING_BLOCK_LABEL_520;
        }
        if (i >= l1) goto _L2; else goto _L1
_L1:
        i1 = i + 1;
        obj = aobj[i];
        i = i1;
_L4:
        obj1 = obj;
        Object obj2;
        Type type;
        int j1;
        int i2;
        if (declaration.type != null)
        {
            try
            {
                obj1 = declaration.type.coerceFromObject(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                return 0xfff40000 | i;
            }
        }
        obj = obj1;
        if (declaration.isIndirectBinding())
        {
            obj = declaration.makeIndirectLocationFor();
            ((Location) (obj)).set(obj1);
        }
        aobj1[declaration.evalIndex] = obj;
        declaration = declaration.nextDecl();
        if (true) goto _L3; else goto _L2
_L2:
        if (i < l1 + l)
        {
            if (i < k1)
            {
                j1 = i + 1;
                obj = aobj[i];
                i = j1;
            } else
            {
                obj = lambda.evalDefaultArg(k, callcontext);
            }
            k++;
        } else
        {
label0:
            {
                if (lambda.max_args >= 0 || i != l1 + l)
                {
                    break MISSING_BLOCK_LABEL_449;
                }
                if (!(declaration.type instanceof ArrayType))
                {
                    break MISSING_BLOCK_LABEL_439;
                }
                i2 = k1 - i;
                type = ((ArrayType)declaration.type).getComponentType();
                if (type != Type.objectType)
                {
                    break label0;
                }
                obj = ((Object) (new Object[i2]));
                System.arraycopy(((Object) (aobj)), i, obj, 0, i2);
            }
        }
          goto _L4
        obj2 = Array.newInstance(type.getReflectClass(), i2);
        j1 = 0;
_L6:
        obj = obj2;
        if (j1 >= i2) goto _L4; else goto _L5
_L5:
        try
        {
            obj = type.coerceFromObject(aobj[i + j1]);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            return 0xfff40000 | i + j1;
        }
        Array.set(obj2, j1, obj);
        j1++;
          goto _L6
        obj = LList.makeList(aobj, i);
          goto _L4
        obj = lambda.keywords;
        j1 = j + 1;
        obj2 = Keyword.searchForKeyword(aobj, l1 + l, obj[j]);
        obj = obj2;
        if (obj2 == Special.dfault)
        {
            obj = lambda.evalDefaultArg(k, callcontext);
        }
        k++;
        j = j1;
          goto _L4
        callcontext.values = aobj1;
        callcontext.where = 0;
        callcontext.next = 0;
        callcontext.proc = this;
        return 0;
    }

    public int numArgs()
    {
        return lambda.min_args | lambda.max_args << 12;
    }
}
