// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Expression;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.ListPat;
import kawa.lang.Pattern;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class prim_method extends Syntax
{

    public static final prim_method interface_method;
    public static final prim_method op1;
    private static Pattern pattern3 = new ListPat(3);
    private static Pattern pattern4 = new ListPat(4);
    public static final prim_method static_method;
    public static final prim_method virtual_method;
    int op_code;

    public prim_method()
    {
    }

    public prim_method(int i)
    {
        op_code = i;
    }

    int opcode()
    {
        return op_code;
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        Object aobj[];
        Type atype[];
        Type type;
        aobj = new Object[4];
        if (op_code != 0 ? pattern4.match(obj, aobj, 0) : pattern3.match(obj, aobj, 1))
        {
            if (!(aobj[3] instanceof LList))
            {
                return translator.syntaxError((new StringBuilder()).append("missing/invalid parameter list in ").append(getName()).toString());
            }
        } else
        {
            return translator.syntaxError((new StringBuilder()).append("wrong number of arguments to ").append(getName()).append("(opcode:").append(op_code).append(")").toString());
        }
        Object obj1 = (LList)aobj[3];
        int j = ((LList) (obj1)).size();
        atype = new Type[j];
        for (int i = 0; i < j; i++)
        {
            obj1 = (Pair)obj1;
            atype[i] = translator.exp2Type(((Pair) (obj1)));
            obj1 = (LList)((Pair) (obj1)).getCdr();
        }

        type = translator.exp2Type(new Pair(aobj[2], null));
        if (op_code != 0) goto _L2; else goto _L1
_L1:
        obj = new PrimProcedure(((Number)(Number)aobj[1]).intValue(), type, atype);
_L4:
        return new QuoteExp(obj);
_L2:
        Object obj2;
        Object obj3 = null;
        obj = translator.exp2Type((Pair)obj);
        obj2 = obj;
        if (obj != null)
        {
            obj2 = ((Type) (obj)).getImplementationType();
        }
        obj = obj3;
        obj2 = (ClassType)obj2;
        obj = obj2;
        ((ClassType) (obj2)).getReflectClass();
        obj = obj2;
_L5:
        if (aobj[1] instanceof Pair)
        {
            translator = (Pair)aobj[1];
            if (translator.getCar() == "quote")
            {
                aobj[1] = ((Pair)translator.getCdr()).getCar();
            }
        }
        obj = new PrimProcedure(op_code, ((ClassType) (obj)), aobj[1].toString(), type, atype);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        char c;
        if (obj == null)
        {
            c = 'e';
        } else
        {
            c = 'w';
            ((ClassType) (obj)).setExisting(false);
        }
        translator.error(c, (new StringBuilder()).append("unknown class: ").append(aobj[0]).toString());
          goto _L5
    }

    static 
    {
        virtual_method = new prim_method(182);
        virtual_method.setName("primitive-virtual-method");
        static_method = new prim_method(184);
        static_method.setName("primitive-static-method");
        interface_method = new prim_method(185);
        interface_method.setName("primitive-interface-method");
        op1 = new prim_method();
        op1.setName("primitive-op1");
    }
}
