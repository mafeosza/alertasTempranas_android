// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;

public class MakeList extends ProcedureN
    implements Inlineable
{

    public static final MakeList list;

    public MakeList()
    {
    }

    public static void compile(Expression aexpression[], int i, Compilation compilation)
    {
        int l = aexpression.length - i;
        CodeAttr codeattr = compilation.getCode();
        if (l == 0)
        {
            (new QuoteExp(LList.Empty)).compile(compilation, Target.pushObject);
            return;
        }
        if (l <= 4)
        {
            for (int j = 0; j < l; j++)
            {
                aexpression[i + j].compile(compilation, Target.pushObject);
            }

            codeattr.emitInvokeStatic(Compilation.scmListType.getDeclaredMethod((new StringBuilder()).append("list").append(l).toString(), null));
            return;
        }
        aexpression[i].compile(compilation, Target.pushObject);
        codeattr.emitInvokeStatic(Compilation.scmListType.getDeclaredMethod("list1", null));
        codeattr.emitDup(1);
        i++;
        int k = l - 1;
        int i1;
        do
        {
            l = k;
            i1 = i;
            if (k < 4)
            {
                break;
            }
            aexpression[i].compile(compilation, Target.pushObject);
            aexpression[i + 1].compile(compilation, Target.pushObject);
            aexpression[i + 2].compile(compilation, Target.pushObject);
            aexpression[i + 3].compile(compilation, Target.pushObject);
            k -= 4;
            i += 4;
            codeattr.emitInvokeStatic(Compilation.scmListType.getDeclaredMethod("chain4", null));
        } while (true);
        while (l > 0) 
        {
            aexpression[i1].compile(compilation, Target.pushObject);
            l--;
            i1++;
            codeattr.emitInvokeStatic(Compilation.scmListType.getDeclaredMethod("chain1", null));
        }
        codeattr.emitPop(1);
    }

    public static Object list$V(Object aobj[])
    {
        Object obj = LList.Empty;
        int i = aobj.length;
        do
        {
            i--;
            if (i >= 0)
            {
                obj = new Pair(aobj[i], obj);
            } else
            {
                return obj;
            }
        } while (true);
    }

    public Object applyN(Object aobj[])
    {
        return list$V(aobj);
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        compile(applyexp.getArgs(), 0, compilation);
        target.compileFromStack(compilation, applyexp.getType());
    }

    public Type getReturnType(Expression aexpression[])
    {
        if (aexpression.length > 0)
        {
            return Compilation.typePair;
        } else
        {
            return LangObjType.listType;
        }
    }

    static 
    {
        list = new MakeList();
        list.setName("list");
    }
}
