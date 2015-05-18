// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            genwrite

public class pp.MnDO extends ModuleBody
{
    public class genwrite.frame1 extends ModuleBody
    {

        final ModuleMethod lambda$Fn1;
        Object left;
        Object result;
        genwrite.frame0 staticLink;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 1)
            {
                if (lambda22(obj))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        boolean lambda22(Object obj)
        {
            result = lists.cons(obj, result);
            AddOp addop = AddOp.$Mn;
            Object obj1 = left;
            CharSequence charsequence;
            try
            {
                charsequence = (CharSequence)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "string-length", 1, obj);
            }
            left = addop.apply2(obj1, Integer.valueOf(strings.stringLength(charsequence)));
            return ((Boolean)Scheme.numGrt.apply2(left, genwrite.Lit1)).booleanValue();
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 1)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return super.match1(modulemethod, obj, callcontext);
            }
        }

        public genwrite.frame1()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
            modulemethod.setProperty("source-location", "genwrite.scm:72");
            lambda$Fn1 = modulemethod;
        }
    }


    Procedure pp$MnAND;
    Procedure pp$MnBEGIN;
    Procedure pp$MnCASE;
    Procedure pp$MnCOND;
    Procedure pp$MnDO;
    Procedure pp$MnIF;
    Procedure pp$MnLAMBDA;
    Procedure pp$MnLET;
    Procedure pp$Mnexpr;
    Procedure pp$Mnexpr$Mnlist;
     staticLink;

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 2: // '\002'
            return lambda8ppExpr(obj, obj1, obj2);

        case 3: // '\003'
            return lambda13ppExprList(obj, obj1, obj2);

        case 4: // '\004'
            return lambda14pp$MnLAMBDA(obj, obj1, obj2);

        case 5: // '\005'
            return lambda15pp$MnIF(obj, obj1, obj2);

        case 6: // '\006'
            return lambda16pp$MnCOND(obj, obj1, obj2);

        case 7: // '\007'
            return lambda17pp$MnCASE(obj, obj1, obj2);

        case 8: // '\b'
            return lambda18pp$MnAND(obj, obj1, obj2);

        case 9: // '\t'
            return lambda19pp$MnLET(obj, obj1, obj2);

        case 10: // '\n'
            return lambda20pp$MnBEGIN(obj, obj1, obj2);

        case 11: // '\013'
            return lambda21pp$MnDO(obj, obj1, obj2);
        }
    }

    public Object lambda10ppList(Object obj, Object obj1, Object obj2, Object obj3)
    {
        obj1 = staticLink.ambda4out("(", obj1);
        return lambda11ppDown(obj, obj1, obj1, obj2, obj3);
    }

    public Object lambda11ppDown(Object obj, Object obj1, Object obj2, Object obj3, Object obj4)
    {
        while (obj1 != Boolean.FALSE) 
        {
            if (lists.isPair(obj))
            {
                Object obj6 = lists.cdr.apply1(obj);
                Object obj5;
                if (lists.isNull(obj6))
                {
                    obj5 = AddOp.$Pl.apply2(obj3, genwrite.Lit17);
                } else
                {
                    obj5 = genwrite.Lit1;
                }
                obj1 = lambda7pr(lists.car.apply1(obj), lambda6indent(obj2, obj1), obj5, obj4);
                obj = obj6;
            } else
            if (lists.isNull(obj))
            {
                return staticLink.ambda4out(")", obj1);
            } else
            {
                return staticLink.ambda4out(")", lambda7pr(obj, lambda6indent(obj2, staticLink.ambda4out(".", lambda6indent(obj2, obj1))), AddOp.$Pl.apply2(obj3, genwrite.Lit17), obj4));
            }
        }
        return obj1;
    }

    public Object lambda12ppGeneral(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6)
    {
        Object obj7;
        Object obj8 = lists.car.apply1(obj);
        obj7 = lists.cdr.apply1(obj);
        obj = staticLink.ambda5wr(obj8, staticLink.ambda4out("(", obj1));
        Object obj9;
        Object obj10;
        if (obj3 == Boolean.FALSE ? obj3 != Boolean.FALSE : lists.isPair(obj7))
        {
            obj8 = lists.car.apply1(obj7);
            obj3 = lists.cdr.apply1(obj7);
            obj = staticLink.ambda5wr(obj8, staticLink.ambda4out(" ", obj));
            obj8 = AddOp.$Pl.apply2(obj1, genwrite.Lit19);
            obj9 = AddOp.$Pl.apply2(obj, genwrite.Lit17);
        } else
        {
            obj8 = AddOp.$Pl.apply2(obj1, genwrite.Lit19);
            obj9 = AddOp.$Pl.apply2(obj, genwrite.Lit17);
            obj3 = obj7;
        }
        if (obj4 == Boolean.FALSE) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        obj7 = obj3;
        if (!lists.isPair(obj3)) goto _L4; else goto _L3
_L3:
        obj10 = lists.car.apply1(obj3);
        obj7 = lists.cdr.apply1(obj3);
        if (lists.isNull(obj7))
        {
            obj1 = AddOp.$Pl.apply2(obj2, genwrite.Lit17);
        } else
        {
            obj1 = genwrite.Lit1;
        }
        obj1 = lambda7pr(obj10, lambda6indent(obj9, obj), obj1, obj4);
_L4:
        if (obj5 == Boolean.FALSE ? obj5 != Boolean.FALSE : lists.isPair(obj7))
        {
            obj4 = lists.car.apply1(obj7);
            obj3 = lists.cdr.apply1(obj7);
            if (lists.isNull(obj3))
            {
                obj = AddOp.$Pl.apply2(obj2, genwrite.Lit17);
            } else
            {
                obj = genwrite.Lit1;
            }
            obj1 = lambda7pr(obj4, lambda6indent(obj9, obj1), obj, obj5);
            obj = obj3;
        } else
        {
            obj = obj7;
        }
        return lambda11ppDown(obj, obj1, obj8, obj2, obj6);
_L2:
        obj1 = obj;
        obj7 = obj3;
        if (obj4 == Boolean.FALSE) goto _L4; else goto _L3
    }

    public Object lambda13ppExprList(Object obj, Object obj1, Object obj2)
    {
        return lambda10ppList(obj, obj1, obj2, pp$Mnexpr);
    }

    public Object lambda14pp$MnLAMBDA(Object obj, Object obj1, Object obj2)
    {
        return lambda12ppGeneral(obj, obj1, obj2, Boolean.FALSE, pp$Mnexpr$Mnlist, Boolean.FALSE, pp$Mnexpr);
    }

    public Object lambda15pp$MnIF(Object obj, Object obj1, Object obj2)
    {
        return lambda12ppGeneral(obj, obj1, obj2, Boolean.FALSE, pp$Mnexpr, Boolean.FALSE, pp$Mnexpr);
    }

    public Object lambda16pp$MnCOND(Object obj, Object obj1, Object obj2)
    {
        return lambda9ppCall(obj, obj1, obj2, pp$Mnexpr$Mnlist);
    }

    public Object lambda17pp$MnCASE(Object obj, Object obj1, Object obj2)
    {
        return lambda12ppGeneral(obj, obj1, obj2, Boolean.FALSE, pp$Mnexpr, Boolean.FALSE, pp$Mnexpr$Mnlist);
    }

    public Object lambda18pp$MnAND(Object obj, Object obj1, Object obj2)
    {
        return lambda9ppCall(obj, obj1, obj2, pp$Mnexpr);
    }

    public Object lambda19pp$MnLET(Object obj, Object obj1, Object obj2)
    {
        Object obj3 = lists.cdr.apply1(obj);
        boolean flag = lists.isPair(obj3);
        if (flag)
        {
            flag = misc.isSymbol(lists.car.apply1(obj3));
        }
        if (flag)
        {
            obj3 = Boolean.TRUE;
        } else
        {
            obj3 = Boolean.FALSE;
        }
        return lambda12ppGeneral(obj, obj1, obj2, obj3, pp$Mnexpr$Mnlist, Boolean.FALSE, pp$Mnexpr);
    }

    public Object lambda20pp$MnBEGIN(Object obj, Object obj1, Object obj2)
    {
        return lambda12ppGeneral(obj, obj1, obj2, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, pp$Mnexpr);
    }

    public Object lambda21pp$MnDO(Object obj, Object obj1, Object obj2)
    {
        return lambda12ppGeneral(obj, obj1, obj2, Boolean.FALSE, pp$Mnexpr$Mnlist, pp$Mnexpr$Mnlist, pp$Mnexpr);
    }

    public Object lambda6indent(Object obj, Object obj1)
    {
        if (obj1 == Boolean.FALSE) goto _L2; else goto _L1
_L1:
        if (Scheme.numLss.apply2(obj, obj1) == Boolean.FALSE) goto _L4; else goto _L3
_L3:
        Object obj2;
        obj2 = staticLink.ambda4out(strings.makeString(1, genwrite.Lit0), obj1);
        obj1 = obj2;
        if (obj2 == Boolean.FALSE) goto _L6; else goto _L5
_L5:
        obj1 = genwrite.Lit1;
_L7:
        Object obj3 = obj1;
        if (Scheme.numGrt.apply2(obj, genwrite.Lit1) != Boolean.FALSE)
        {
            if (Scheme.numGrt.apply2(obj, genwrite.Lit15) != Boolean.FALSE)
            {
                obj = AddOp.$Mn.apply2(obj, genwrite.Lit16);
                obj1 = staticLink.ambda4out("        ", obj1);
                continue; /* Loop/switch isn't completed */
            }
            obj3 = staticLink;
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "substring", 3, obj);
            }
            obj3 = ((staticLink) (obj3)).ambda4out(strings.substring("        ", 0, i), obj1);
        }
        obj1 = obj3;
_L6:
        return obj1;
_L4:
        obj = AddOp.$Mn.apply2(obj, obj1);
        if (true) goto _L7; else goto _L2
_L2:
        return obj1;
    }

    public Object lambda7pr(Object obj, Object obj1, Object obj2, Object obj3)
    {
        ambda4out ambda4out = new <init>();
        ambda4out.staticLink = this;
        boolean flag = lists.isPair(obj);
        if (flag ? flag : vectors.isVector(obj))
        {
            LList llist = LList.Empty;
            ambda4out.left = numbers.min(new Object[] {
                AddOp.$Pl.apply2(AddOp.$Mn.apply2(AddOp.$Mn.apply2(staticLink.idth, obj1), obj2), genwrite.Lit17), genwrite.Lit18
            });
            ambda4out.result = llist;
            genwrite.genericWrite(obj, staticLink.Qu, Boolean.FALSE, ambda4out.Fn1);
            if (Scheme.numGrt.apply2(ambda4out.left, genwrite.Lit1) != Boolean.FALSE)
            {
                return staticLink.ambda4out(genwrite.reverseStringAppend(ambda4out.result), obj1);
            }
        } else
        {
            return staticLink.ambda5wr(obj, obj1);
        }
        if (lists.isPair(obj))
        {
            return Scheme.applyToArgs.apply4(obj3, obj, obj1, obj2);
        }
        try
        {
            obj3 = (FVector)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "vector->list", 1, obj);
        }
        return lambda10ppList(vectors.vector$To$List(((FVector) (obj3))), staticLink.ambda4out("#", obj1), obj2, pp$Mnexpr);
    }

    public Object lambda8ppExpr(Object obj, Object obj1, Object obj2)
    {
        if (ambda1isReadMacro(obj) != Boolean.FALSE)
        {
            return lambda7pr(ambda2readMacroBody(obj), staticLink.ambda4out(ambda3readMacroPrefix(obj), obj1), obj2, pp$Mnexpr);
        }
        Object obj4 = lists.car.apply1(obj);
        if (misc.isSymbol(obj4))
        {
            Object obj3 = Scheme.isEqv.apply2(obj4, genwrite.Lit2);
            if (obj3 == Boolean.FALSE ? (obj3 = Scheme.isEqv.apply2(obj4, genwrite.Lit3)) == Boolean.FALSE ? (obj3 = Scheme.isEqv.apply2(obj4, genwrite.Lit4)) == Boolean.FALSE ? Scheme.isEqv.apply2(obj4, genwrite.Lit5) != Boolean.FALSE : obj3 != Boolean.FALSE : obj3 != Boolean.FALSE : obj3 != Boolean.FALSE)
            {
                obj3 = pp$MnLAMBDA;
            } else
            {
                obj3 = Scheme.isEqv.apply2(obj4, genwrite.Lit6);
                if (obj3 == Boolean.FALSE ? Scheme.isEqv.apply2(obj4, genwrite.Lit7) != Boolean.FALSE : obj3 != Boolean.FALSE)
                {
                    obj3 = pp$MnIF;
                } else
                if (Scheme.isEqv.apply2(obj4, genwrite.Lit8) != Boolean.FALSE)
                {
                    obj3 = pp$MnCOND;
                } else
                if (Scheme.isEqv.apply2(obj4, genwrite.Lit9) != Boolean.FALSE)
                {
                    obj3 = pp$MnCASE;
                } else
                {
                    obj3 = Scheme.isEqv.apply2(obj4, genwrite.Lit10);
                    if (obj3 == Boolean.FALSE ? Scheme.isEqv.apply2(obj4, genwrite.Lit11) != Boolean.FALSE : obj3 != Boolean.FALSE)
                    {
                        obj3 = pp$MnAND;
                    } else
                    if (Scheme.isEqv.apply2(obj4, genwrite.Lit12) != Boolean.FALSE)
                    {
                        obj3 = pp$MnLET;
                    } else
                    if (Scheme.isEqv.apply2(obj4, genwrite.Lit13) != Boolean.FALSE)
                    {
                        obj3 = pp$MnBEGIN;
                    } else
                    if (Scheme.isEqv.apply2(obj4, genwrite.Lit14) != Boolean.FALSE)
                    {
                        obj3 = pp$MnDO;
                    } else
                    {
                        obj3 = Boolean.FALSE;
                    }
                }
            }
            if (obj3 != Boolean.FALSE)
            {
                return Scheme.applyToArgs.apply4(obj3, obj, obj1, obj2);
            }
            try
            {
                obj3 = (Symbol)obj4;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "symbol->string", 1, obj4);
            }
            if (strings.stringLength(misc.symbol$To$String(((Symbol) (obj3)))) > 5)
            {
                return lambda12ppGeneral(obj, obj1, obj2, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, pp$Mnexpr);
            } else
            {
                return lambda9ppCall(obj, obj1, obj2, pp$Mnexpr);
            }
        } else
        {
            return lambda10ppList(obj, obj1, obj2, pp$Mnexpr);
        }
    }

    public Object lambda9ppCall(Object obj, Object obj1, Object obj2, Object obj3)
    {
        Object obj5 = staticLink.ambda5wr(lists.car.apply1(obj), staticLink.ambda4out("(", obj1));
        Object obj4 = obj1;
        if (obj1 != Boolean.FALSE)
        {
            obj4 = lambda11ppDown(lists.cdr.apply1(obj), obj5, AddOp.$Pl.apply2(obj5, genwrite.Lit17), obj2, obj3);
        }
        return obj4;
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);

        case 11: // '\013'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 10: // '\n'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 9: // '\t'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 8: // '\b'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 7: // '\007'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 6: // '\006'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 5: // '\005'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 4: // '\004'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 3: // '\003'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
    }

    public lambda.Fn1()
    {
        pp$Mnexpr = new ModuleMethod(this, 2, genwrite.Lit20, 12291);
        pp$Mnexpr$Mnlist = new ModuleMethod(this, 3, genwrite.Lit21, 12291);
        pp$MnLAMBDA = new ModuleMethod(this, 4, genwrite.Lit22, 12291);
        pp$MnIF = new ModuleMethod(this, 5, genwrite.Lit23, 12291);
        pp$MnCOND = new ModuleMethod(this, 6, genwrite.Lit24, 12291);
        pp$MnCASE = new ModuleMethod(this, 7, genwrite.Lit25, 12291);
        pp$MnAND = new ModuleMethod(this, 8, genwrite.Lit26, 12291);
        pp$MnLET = new ModuleMethod(this, 9, genwrite.Lit27, 12291);
        pp$MnBEGIN = new ModuleMethod(this, 10, genwrite.Lit28, 12291);
        pp$MnDO = new ModuleMethod(this, 11, genwrite.Lit29, 12291);
    }
}
