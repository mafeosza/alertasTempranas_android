// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.expr.Declaration;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;

// Referenced classes of package gnu.kawa.functions:
//            ApplyToArgs, IsEq

public class Map extends ProcedureN
{

    final Declaration applyFieldDecl;
    final ApplyToArgs applyToArgs;
    boolean collect;
    final IsEq isEq;

    public Map(boolean flag, ApplyToArgs applytoargs, Declaration declaration, IsEq iseq)
    {
        String s;
        if (flag)
        {
            s = "map";
        } else
        {
            s = "for-each";
        }
        super(s);
        collect = flag;
        applyToArgs = applytoargs;
        applyFieldDecl = declaration;
        isEq = iseq;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyMap");
    }

    public static void forEach1(Procedure procedure, Object obj)
        throws Throwable
    {
        for (; obj != LList.Empty; obj = ((Pair) (obj)).getCdr())
        {
            obj = (Pair)obj;
            procedure.apply1(((Pair) (obj)).getCar());
        }

    }

    public static Object map1(Procedure procedure, Object obj)
        throws Throwable
    {
        Object obj1 = LList.Empty;
        Object obj3 = null;
        Object obj2 = obj;
        obj = obj3;
        while (obj2 != LList.Empty) 
        {
            Pair pair = (Pair)obj2;
            obj2 = new Pair(procedure.apply1(pair.getCar()), LList.Empty);
            if (obj == null)
            {
                obj1 = obj2;
            } else
            {
                ((Pair) (obj)).setCdr(obj2);
            }
            obj = obj2;
            obj2 = pair.getCdr();
        }
        return obj1;
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        if (obj instanceof Procedure)
        {
            obj = (Procedure)obj;
            if (collect)
            {
                return map1(((Procedure) (obj)), obj1);
            } else
            {
                forEach1(((Procedure) (obj)), obj1);
                return Values.empty;
            }
        } else
        {
            return applyN(new Object[] {
                obj, obj1
            });
        }
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        int k = aobj.length - 1;
        if (k != 1 || !(aobj[0] instanceof Procedure)) goto _L2; else goto _L1
_L1:
        Object obj = (Procedure)(Procedure)aobj[0];
        if (!collect) goto _L4; else goto _L3
_L3:
        obj = map1(((Procedure) (obj)), aobj[1]);
_L6:
        return obj;
_L4:
        forEach1(((Procedure) (obj)), aobj[1]);
        return Values.empty;
_L2:
        Object aobj1[];
        Object obj2;
        Pair pair;
        pair = null;
        Object aobj2[];
        Object obj3;
        int i;
        int j;
        if (collect)
        {
            obj = LList.Empty;
        } else
        {
            obj = Values.empty;
        }
        aobj2 = new Object[k];
        System.arraycopy(((Object) (aobj)), 1, ((Object) (aobj2)), 0, k);
        if (aobj[0] instanceof Procedure)
        {
            i = 0;
            aobj1 = new Object[k];
            obj2 = (Procedure)aobj[0];
            aobj = ((Object []) (obj));
        } else
        {
            i = 1;
            aobj1 = new Object[k + 1];
            aobj1[0] = aobj[0];
            obj2 = applyToArgs;
            aobj = ((Object []) (obj));
        }
_L8:
        j = 0;
_L7:
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        obj3 = aobj2[j];
        obj = ((Object) (aobj));
        if (obj3 == LList.Empty) goto _L6; else goto _L5
_L5:
        obj = (Pair)obj3;
        aobj1[i + j] = ((Pair) (obj)).getCar();
        aobj2[j] = ((Pair) (obj)).getCdr();
        j++;
          goto _L7
        Object obj1 = ((Procedure) (obj2)).applyN(aobj1);
        if (collect)
        {
            obj1 = new Pair(obj1, LList.Empty);
            if (pair == null)
            {
                aobj = ((Object []) (obj1));
            } else
            {
                pair.setCdr(obj1);
            }
            pair = ((Pair) (obj1));
        }
          goto _L8
    }
}
