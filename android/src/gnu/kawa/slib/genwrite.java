// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Format;
import gnu.lists.CharSeq;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.Char;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.strings;
import kawa.lib.vectors;
import kawa.standard.Scheme;

public class genwrite extends ModuleBody
{
    public class frame extends ModuleBody
    {

        Object display$Qu;
        Object output;
        Object width;

        public static Object lambda1isReadMacro(Object obj)
        {
            Object obj1 = lists.car.apply1(obj);
            obj = lists.cdr.apply1(obj);
            Object obj2 = Scheme.isEqv.apply2(obj1, genwrite.Lit30);
            boolean flag;
            if (obj2 == Boolean.FALSE ? (obj3 = Scheme.isEqv.apply2(obj1, genwrite.Lit31)) == Boolean.FALSE ? (obj3 = Scheme.isEqv.apply2(obj1, genwrite.Lit32)) == Boolean.FALSE ? Scheme.isEqv.apply2(obj1, genwrite.Lit33) != Boolean.FALSE : obj3 != Boolean.FALSE : obj3 != Boolean.FALSE : obj2 != Boolean.FALSE)
            {
                flag = lists.isPair(obj);
                Object obj3;
                if (flag)
                {
                    if (lists.isNull(lists.cdr.apply1(obj)))
                    {
                        return Boolean.TRUE;
                    } else
                    {
                        return Boolean.FALSE;
                    }
                }
            } else
            {
                return Boolean.FALSE;
            }
            if (flag)
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        }

        public static Object lambda2readMacroBody(Object obj)
        {
            return lists.cadr.apply1(obj);
        }

        public static Object lambda3readMacroPrefix(Object obj)
        {
            Object obj1 = lists.car.apply1(obj);
            lists.cdr.apply1(obj);
            if (Scheme.isEqv.apply2(obj1, genwrite.Lit30) != Boolean.FALSE)
            {
                return "'";
            }
            if (Scheme.isEqv.apply2(obj1, genwrite.Lit31) != Boolean.FALSE)
            {
                return "`";
            }
            if (Scheme.isEqv.apply2(obj1, genwrite.Lit32) != Boolean.FALSE)
            {
                return ",";
            }
            if (Scheme.isEqv.apply2(obj1, genwrite.Lit33) != Boolean.FALSE)
            {
                return ",@";
            } else
            {
                return Values.empty;
            }
        }

        public Object lambda4out(Object obj, Object obj1)
        {
            if (obj1 != Boolean.FALSE)
            {
                Object obj3 = Scheme.applyToArgs.apply2(output, obj);
                Object obj2 = obj3;
                if (obj3 != Boolean.FALSE)
                {
                    obj2 = AddOp.$Pl;
                    CharSequence charsequence;
                    try
                    {
                        charsequence = (CharSequence)obj;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
                    }
                    obj2 = ((Procedure) (obj2)).apply2(obj1, Integer.valueOf(strings.stringLength(charsequence)));
                }
                return obj2;
            } else
            {
                return obj1;
            }
        }

        public Object lambda5wr(Object obj, Object obj1)
        {
            if (!lists.isPair(obj))
            {
                break MISSING_BLOCK_LABEL_186;
            }
            if (lambda1isReadMacro(obj) == Boolean.FALSE) goto _L2; else goto _L1
_L1:
            Object obj2 = lambda5wr(lambda2readMacroBody(obj), lambda4out(lambda3readMacroPrefix(obj), obj1));
_L4:
            return obj2;
_L2:
            Object obj3;
            obj3 = obj1;
            obj2 = obj;
_L6:
            if (!lists.isPair(obj2))
            {
                break MISSING_BLOCK_LABEL_177;
            }
            Object obj4 = lists.cdr.apply1(obj2);
            obj1 = obj4;
            obj = obj3;
            if (obj3 != Boolean.FALSE)
            {
                obj = lambda5wr(lists.car.apply1(obj2), lambda4out("(", obj3));
                obj1 = obj4;
            }
_L5:
            obj2 = obj;
            if (obj == Boolean.FALSE) goto _L4; else goto _L3
_L3:
            if (lists.isPair(obj1))
            {
                obj2 = lists.cdr.apply1(obj1);
                obj = lambda5wr(lists.car.apply1(obj1), lambda4out(" ", obj));
                obj1 = obj2;
            } else
            if (lists.isNull(obj1))
            {
                return lambda4out(")", obj);
            } else
            {
                return lambda4out(")", lambda5wr(obj1, lambda4out(" . ", obj)));
            }
              goto _L5
              goto _L4
            return lambda4out("()", obj3);
            obj2 = obj;
            obj3 = obj1;
            if (!lists.isNull(obj))
            {
                if (vectors.isVector(obj))
                {
                    try
                    {
                        obj2 = (FVector)obj;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        throw new WrongType(((ClassCastException) (obj1)), "vector->list", 1, obj);
                    }
                    obj2 = vectors.vector$To$List(((FVector) (obj2)));
                    obj3 = lambda4out("#", obj1);
                } else
                {
                    if (display$Qu != Boolean.FALSE)
                    {
                        obj2 = "~a";
                    } else
                    {
                        obj2 = "~s";
                    }
                    return lambda4out(Format.formatToString(0, new Object[] {
                        obj2, obj
                    }), obj1);
                }
            }
              goto _L6
        }

        public frame()
        {
        }
    }

    public class frame0 extends ModuleBody
    {

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
        frame staticLink;

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
            obj1 = staticLink.lambda4out("(", obj1);
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
                    return staticLink.lambda4out(")", obj1);
                } else
                {
                    return staticLink.lambda4out(")", lambda7pr(obj, lambda6indent(obj2, staticLink.lambda4out(".", lambda6indent(obj2, obj1))), AddOp.$Pl.apply2(obj3, genwrite.Lit17), obj4));
                }
            }
            return obj1;
        }

        public Object lambda12ppGeneral(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6)
        {
            Object obj7;
            Object obj8 = lists.car.apply1(obj);
            obj7 = lists.cdr.apply1(obj);
            obj = staticLink.lambda5wr(obj8, staticLink.lambda4out("(", obj1));
            Object obj9;
            Object obj10;
            if (obj3 == Boolean.FALSE ? obj3 != Boolean.FALSE : lists.isPair(obj7))
            {
                obj8 = lists.car.apply1(obj7);
                obj3 = lists.cdr.apply1(obj7);
                obj = staticLink.lambda5wr(obj8, staticLink.lambda4out(" ", obj));
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
            obj2 = staticLink.lambda4out(strings.makeString(1, genwrite.Lit0), obj1);
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
                    obj1 = staticLink.lambda4out("        ", obj1);
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
                obj3 = ((frame) (obj3)).lambda4out(strings.substring("        ", 0, i), obj1);
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
            frame1 frame1_1 = new frame1();
            frame1_1.staticLink = this;
            boolean flag = lists.isPair(obj);
            if (flag ? flag : vectors.isVector(obj))
            {
                LList llist = LList.Empty;
                frame1_1.left = numbers.min(new Object[] {
                    AddOp.$Pl.apply2(AddOp.$Mn.apply2(AddOp.$Mn.apply2(staticLink.width, obj1), obj2), genwrite.Lit17), genwrite.Lit18
                });
                frame1_1.result = llist;
                genwrite.genericWrite(obj, staticLink.Qu, Boolean.FALSE, frame1_1.Fn1);
                if (Scheme.numGrt.apply2(frame1_1.left, genwrite.Lit1) != Boolean.FALSE)
                {
                    return staticLink.lambda4out(genwrite.reverseStringAppend(frame1_1.result), obj1);
                }
            } else
            {
                return staticLink.lambda5wr(obj, obj1);
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
            return lambda10ppList(vectors.vector$To$List(((FVector) (obj3))), staticLink.lambda4out("#", obj1), obj2, pp$Mnexpr);
        }

        public Object lambda8ppExpr(Object obj, Object obj1, Object obj2)
        {
            if (frame.lambda1isReadMacro(obj) != Boolean.FALSE)
            {
                return lambda7pr(frame.lambda2readMacroBody(obj), staticLink.lambda4out(frame.lambda3readMacroPrefix(obj), obj1), obj2, pp$Mnexpr);
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
            Object obj5 = staticLink.lambda5wr(lists.car.apply1(obj), staticLink.lambda4out("(", obj1));
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

        public frame0()
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

    public class frame1 extends ModuleBody
    {

        final ModuleMethod lambda$Fn1;
        Object left;
        Object result;
        frame0 staticLink;

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

        public frame1()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
            modulemethod.setProperty("source-location", "genwrite.scm:72");
            lambda$Fn1 = modulemethod;
        }
    }


    public static final genwrite $instance;
    static final Char Lit0 = Char.make(10);
    static final IntNum Lit1 = IntNum.make(0);
    static final SimpleSymbol Lit10 = (SimpleSymbol)(new SimpleSymbol("and")).readResolve();
    static final SimpleSymbol Lit11 = (SimpleSymbol)(new SimpleSymbol("or")).readResolve();
    static final SimpleSymbol Lit12 = (SimpleSymbol)(new SimpleSymbol("let")).readResolve();
    static final SimpleSymbol Lit13 = (SimpleSymbol)(new SimpleSymbol("begin")).readResolve();
    static final SimpleSymbol Lit14 = (SimpleSymbol)(new SimpleSymbol("do")).readResolve();
    static final IntNum Lit15 = IntNum.make(7);
    static final IntNum Lit16 = IntNum.make(8);
    static final IntNum Lit17 = IntNum.make(1);
    static final IntNum Lit18 = IntNum.make(50);
    static final IntNum Lit19 = IntNum.make(2);
    static final SimpleSymbol Lit2 = (SimpleSymbol)(new SimpleSymbol("lambda")).readResolve();
    static final SimpleSymbol Lit20 = (SimpleSymbol)(new SimpleSymbol("pp-expr")).readResolve();
    static final SimpleSymbol Lit21 = (SimpleSymbol)(new SimpleSymbol("pp-expr-list")).readResolve();
    static final SimpleSymbol Lit22 = (SimpleSymbol)(new SimpleSymbol("pp-LAMBDA")).readResolve();
    static final SimpleSymbol Lit23 = (SimpleSymbol)(new SimpleSymbol("pp-IF")).readResolve();
    static final SimpleSymbol Lit24 = (SimpleSymbol)(new SimpleSymbol("pp-COND")).readResolve();
    static final SimpleSymbol Lit25 = (SimpleSymbol)(new SimpleSymbol("pp-CASE")).readResolve();
    static final SimpleSymbol Lit26 = (SimpleSymbol)(new SimpleSymbol("pp-AND")).readResolve();
    static final SimpleSymbol Lit27 = (SimpleSymbol)(new SimpleSymbol("pp-LET")).readResolve();
    static final SimpleSymbol Lit28 = (SimpleSymbol)(new SimpleSymbol("pp-BEGIN")).readResolve();
    static final SimpleSymbol Lit29 = (SimpleSymbol)(new SimpleSymbol("pp-DO")).readResolve();
    static final SimpleSymbol Lit3 = (SimpleSymbol)(new SimpleSymbol("let*")).readResolve();
    static final SimpleSymbol Lit30 = (SimpleSymbol)(new SimpleSymbol("quote")).readResolve();
    static final SimpleSymbol Lit31 = (SimpleSymbol)(new SimpleSymbol("quasiquote")).readResolve();
    static final SimpleSymbol Lit32 = (SimpleSymbol)(new SimpleSymbol("unquote")).readResolve();
    static final SimpleSymbol Lit33 = (SimpleSymbol)(new SimpleSymbol("unquote-splicing")).readResolve();
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit4 = (SimpleSymbol)(new SimpleSymbol("letrec")).readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol)(new SimpleSymbol("define")).readResolve();
    static final SimpleSymbol Lit6 = (SimpleSymbol)(new SimpleSymbol("if")).readResolve();
    static final SimpleSymbol Lit7 = (SimpleSymbol)(new SimpleSymbol("set!")).readResolve();
    static final SimpleSymbol Lit8 = (SimpleSymbol)(new SimpleSymbol("cond")).readResolve();
    static final SimpleSymbol Lit9 = (SimpleSymbol)(new SimpleSymbol("case")).readResolve();
    public static final ModuleMethod generic$Mnwrite;
    public static final ModuleMethod reverse$Mnstring$Mnappend;

    public genwrite()
    {
        ModuleInfo.register(this);
    }

    public static Object genericWrite(Object obj, Object obj1, Object obj2, Object obj3)
    {
        frame frame2 = new frame();
        frame2.Qu = obj1;
        frame2.width = obj2;
        frame2.output = obj3;
        if (frame2.width != Boolean.FALSE)
        {
            obj1 = strings.makeString(1, Lit0);
            obj2 = Lit1;
            obj3 = new frame0();
            obj3.staticLink = frame2;
            Procedure procedure = ((frame0) (obj3)).Mnexpr;
            Procedure procedure1 = ((frame0) (obj3)).Mnlist;
            Procedure procedure2 = ((frame0) (obj3)).MnLAMBDA;
            Procedure procedure3 = ((frame0) (obj3)).MnIF;
            Procedure procedure4 = ((frame0) (obj3)).MnCOND;
            Procedure procedure5 = ((frame0) (obj3)).MnCASE;
            Procedure procedure6 = ((frame0) (obj3)).MnAND;
            Procedure procedure7 = ((frame0) (obj3)).MnLET;
            Procedure procedure8 = ((frame0) (obj3)).MnBEGIN;
            obj3.MnDO = ((frame0) (obj3)).MnDO;
            obj3.MnBEGIN = procedure8;
            obj3.MnLET = procedure7;
            obj3.MnAND = procedure6;
            obj3.MnCASE = procedure5;
            obj3.MnCOND = procedure4;
            obj3.MnIF = procedure3;
            obj3.MnLAMBDA = procedure2;
            obj3.Mnlist = procedure1;
            obj3.Mnexpr = procedure;
            return frame2.lambda4out(obj1, ((frame0) (obj3)).lambda7pr(obj, obj2, Lit1, ((frame0) (obj3)).Mnexpr));
        } else
        {
            return frame2.lambda5wr(obj, Lit1);
        }
    }

    public static Object lambda23revStringAppend(Object obj, Object obj1)
    {
        if (!lists.isPair(obj)) goto _L2; else goto _L1
_L1:
        Object obj3;
        Object obj4;
        obj4 = lists.car.apply1(obj);
        Object obj2;
        Object obj5;
        CharSequence charsequence;
        int i;
        int j;
        int k;
        try
        {
            obj2 = (CharSequence)obj4;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj4);
        }
        i = strings.stringLength(((CharSequence) (obj2)));
        obj3 = lambda23revStringAppend(lists.cdr.apply1(obj), AddOp.$Pl.apply2(obj1, Integer.valueOf(i)));
        obj2 = Lit1;
        obj = AddOp.$Mn;
        obj5 = AddOp.$Mn;
        try
        {
            charsequence = (CharSequence)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj3);
        }
        obj = ((Procedure) (obj)).apply2(((Procedure) (obj5)).apply2(Integer.valueOf(strings.stringLength(charsequence)), obj1), Integer.valueOf(i));
        obj1 = obj2;
_L5:
        obj2 = obj3;
        if (Scheme.numLss.apply2(obj1, Integer.valueOf(i)) == Boolean.FALSE) goto _L4; else goto _L3
_L3:
        try
        {
            obj2 = (CharSeq)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, obj3);
        }
        try
        {
            j = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-set!", 2, obj);
        }
        try
        {
            obj5 = (CharSequence)obj4;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj4);
        }
        try
        {
            k = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
        }
        strings.stringSet$Ex(((CharSeq) (obj2)), j, strings.stringRef(((CharSequence) (obj5)), k));
        obj1 = AddOp.$Pl.apply2(obj1, Lit17);
        obj = AddOp.$Pl.apply2(obj, Lit17);
        if (true) goto _L5; else goto _L4
_L2:
        try
        {
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "make-string", 1, obj1);
        }
        obj2 = strings.makeString(i);
_L4:
        return obj2;
    }

    public static Object reverseStringAppend(Object obj)
    {
        return lambda23revStringAppend(obj, Lit1);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 13)
        {
            return reverseStringAppend(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        if (modulemethod.selector == 12)
        {
            return genericWrite(obj, obj1, obj2, obj3);
        } else
        {
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 13)
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

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        if (modulemethod.selector == 12)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.value4 = obj3;
            callcontext.proc = modulemethod;
            callcontext.pc = 4;
            return 0;
        } else
        {
            return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit35 = (SimpleSymbol)(new SimpleSymbol("reverse-string-append")).readResolve();
        Lit34 = (SimpleSymbol)(new SimpleSymbol("generic-write")).readResolve();
        $instance = new genwrite();
        genwrite genwrite1 = $instance;
        generic$Mnwrite = new ModuleMethod(genwrite1, 12, Lit34, 16388);
        reverse$Mnstring$Mnappend = new ModuleMethod(genwrite1, 13, Lit35, 4097);
        $instance.run();
    }
}
