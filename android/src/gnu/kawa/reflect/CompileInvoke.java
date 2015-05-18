// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.TypeValue;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

// Referenced classes of package gnu.kawa.reflect:
//            SlotSet, ClassMethods, Invoke, ArrayNew, 
//            ArraySet

public class CompileInvoke
{

    public CompileInvoke()
    {
    }

    private static void append(PrimProcedure aprimprocedure[], int i, StringBuffer stringbuffer)
    {
        for (int j = 0; j < i; j++)
        {
            stringbuffer.append("\n  candidate: ");
            stringbuffer.append(aprimprocedure[j]);
        }

    }

    static Object[] checkKeywords(ObjectType objecttype, Expression aexpression[], int i, ClassType classtype)
    {
        int k = aexpression.length;
        int j;
        for (j = 0; j * 2 + i + 1 < k && (aexpression[j * 2 + i].valueIfConstant() instanceof Keyword); j++) { }
        Object aobj[] = new Object[j];
        k = 0;
        while (k < j) 
        {
            String s = ((Keyword)aexpression[k * 2 + i].valueIfConstant()).getName();
            gnu.bytecode.Member member = SlotSet.lookupMember(objecttype, s, classtype);
            Object obj = member;
            if (member == null)
            {
                obj = objecttype.getMethod(ClassExp.slotToMethodName("add", s), SlotSet.type1Array);
            }
            if (obj == null)
            {
                obj = s;
            }
            aobj[k] = obj;
            k++;
        }
        return aobj;
    }

    private static String getMethodName(Expression aexpression[], char c)
    {
        if (c == 'N')
        {
            return "<init>";
        }
        if (c == 'P')
        {
            c = '\002';
        } else
        {
            c = '\001';
        }
        if (aexpression.length >= c + 1)
        {
            return ClassMethods.checkName(aexpression[c], false);
        } else
        {
            return null;
        }
    }

    protected static PrimProcedure[] getMethods(ObjectType objecttype, String s, ClassType classtype, Invoke invoke)
    {
        char c = 'P';
        char c1 = invoke.kind;
        if (c1 != 'P')
        {
            if (c1 == '*' || c1 == 'V')
            {
                c = 'V';
            } else
            {
                c = '\0';
            }
        }
        return ClassMethods.getMethods(objecttype, s, c, classtype, invoke.language);
    }

    public static PrimProcedure getStaticMethod(ClassType classtype, String s, Expression aexpression[])
    {
        gnu/kawa/reflect/CompileInvoke;
        JVM INSTR monitorenter ;
        long l;
        s = getMethods(classtype, s, null, Invoke.invokeStatic);
        l = selectApplicable(s, classtype, aexpression, aexpression.length, 0, -1);
        int i;
        int j;
        i = (int)(l >> 32);
        j = (int)l;
        if (s != null) goto _L2; else goto _L1
_L1:
        i = -1;
_L4:
        if (i < 0)
        {
            classtype = null;
        } else
        {
            classtype = s[i];
        }
        return classtype;
_L2:
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        i = MethodProc.mostSpecific(s, i);
        continue; /* Loop/switch isn't completed */
        classtype;
        throw classtype;
        if (j == 1)
        {
            i = 0;
        } else
        {
            i = -1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static int hasKeywordArgument(int i, Expression aexpression[])
    {
        for (; i < aexpression.length; i++)
        {
            if (aexpression[i].valueIfConstant() instanceof Keyword)
            {
                return i;
            }
        }

        return aexpression.length;
    }

    private static long selectApplicable(PrimProcedure aprimprocedure[], ObjectType objecttype, Expression aexpression[], int i, int j, int k)
    {
        Type atype[] = new Type[i];
        i = 0;
        if (k >= 0)
        {
            atype[0] = objecttype;
            i = 0 + 1;
        }
        while (j < aexpression.length && i < atype.length) 
        {
            Expression expression = aexpression[j];
            objecttype = null;
            if (InlineCalls.checkIntValue(expression) != null)
            {
                objecttype = Type.intType;
            } else
            if (InlineCalls.checkLongValue(expression) != null)
            {
                objecttype = Type.longType;
            } else
            if (true)
            {
                objecttype = expression.getType();
            }
            atype[i] = objecttype;
            j++;
            i++;
        }
        return ClassMethods.selectApplicable(aprimprocedure, atype);
    }

    public static Expression validateApplyInvoke(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        char c;
        Object obj3;
        Object obj5;
        Object obj6;
        PrimProcedure aprimprocedure[];
        Expression aexpression1[];
        Compilation compilation;
        int i;
        int l;
        int i1;
        int j4;
        byte byte0;
        int k4;
        Invoke invoke;
        Expression expression;
label0:
        {
            Type type1;
label1:
            {
                invoke = (Invoke)procedure;
                c = invoke.kind;
                compilation = inlinecalls.getCompilation();
                aexpression1 = applyexp.getArgs();
                j4 = aexpression1.length;
                if (!compilation.mustCompile || j4 == 0 || (c == 'V' || c == '*') && j4 == 1)
                {
                    applyexp.visitArgs(inlinecalls);
                    return applyexp;
                }
                expression = inlinecalls.visit(aexpression1[0], null);
                aexpression1[0] = expression;
                Object obj4;
                if (c == 'V' || c == '*')
                {
                    procedure = expression.getType();
                } else
                {
                    procedure = invoke.language.getTypeFor(expression);
                }
                if ((procedure instanceof PairClassType) && c == 'N')
                {
                    obj3 = ((PairClassType)procedure).instanceType;
                } else
                if (procedure instanceof ObjectType)
                {
                    obj3 = (ObjectType)procedure;
                } else
                {
                    obj3 = null;
                }
                obj6 = getMethodName(aexpression1, c);
                if (c == 'V' || c == '*')
                {
                    l = j4 - 1;
                    i = 2;
                    i1 = 0;
                } else
                if (c == 'N')
                {
                    l = j4;
                    i = 0;
                    i1 = -1;
                } else
                if (c == 'S' || c == 's')
                {
                    l = j4 - 2;
                    i = 2;
                    i1 = -1;
                } else
                if (c == 'P')
                {
                    l = j4 - 2;
                    i = 3;
                    i1 = 1;
                } else
                {
                    applyexp.visitArgs(inlinecalls);
                    return applyexp;
                }
                if (c != 'N' || !(obj3 instanceof ArrayType))
                {
                    break label0;
                }
                obj3 = (ArrayType)obj3;
                type1 = ((ArrayType) (obj3)).getComponentType();
                procedure = null;
                i = 0;
                i1 = i;
                type = procedure;
                if (aexpression1.length < 3)
                {
                    break label1;
                }
                i1 = i;
                type = procedure;
                if (!(aexpression1[1] instanceof QuoteExp))
                {
                    break label1;
                }
                obj4 = ((QuoteExp)aexpression1[1]).getValue();
                i1 = i;
                type = procedure;
                if (!(obj4 instanceof Keyword))
                {
                    break label1;
                }
                obj4 = ((Keyword)obj4).getName();
                if (!"length".equals(obj4))
                {
                    i1 = i;
                    type = procedure;
                    if (!"size".equals(obj4))
                    {
                        break label1;
                    }
                }
                type = aexpression1[2];
                i1 = 1;
            }
            procedure = type;
            if (type == null)
            {
                procedure = QuoteExp.getInstance(new Integer(aexpression1.length - 1));
            }
            type = inlinecalls.visit(procedure, Type.intType);
            type = new ApplyExp(new ArrayNew(type1), new Expression[] {
                type
            });
            type.setType(((Type) (obj3)));
            if (i1 != 0 && aexpression1.length == 3)
            {
                return type;
            }
            LetExp letexp = new LetExp(new Expression[] {
                type
            });
            obj3 = letexp.addDeclaration((String)null, ((Type) (obj3)));
            ((Declaration) (obj3)).noteValue(type);
            obj6 = new BeginExp();
            l = 0;
            if (i1 != 0)
            {
                i = 3;
            } else
            {
                i = 1;
            }
            do
            {
                if (i >= aexpression1.length)
                {
                    break;
                }
                procedure = aexpression1[i];
                type = procedure;
                int j1 = i;
                int j2 = l;
                if (i1 != 0)
                {
                    type = procedure;
                    j1 = i;
                    j2 = l;
                    if (i + 1 < aexpression1.length)
                    {
                        type = procedure;
                        j1 = i;
                        j2 = l;
                        if (procedure instanceof QuoteExp)
                        {
                            Object obj7 = ((QuoteExp)procedure).getValue();
                            type = procedure;
                            j1 = i;
                            j2 = l;
                            if (obj7 instanceof Keyword)
                            {
                                type = ((Keyword)obj7).getName();
                                try
                                {
                                    j2 = Integer.parseInt(type);
                                }
                                // Misplaced declaration of an exception variable
                                catch (InlineCalls inlinecalls)
                                {
                                    compilation.error('e', (new StringBuilder()).append("non-integer keyword '").append(type).append("' in array constructor").toString());
                                    return applyexp;
                                }
                                j1 = i + 1;
                                type = aexpression1[j1];
                            }
                        }
                    }
                }
                type = inlinecalls.visit(type, type1);
                ((BeginExp) (obj6)).add(new ApplyExp(new ArraySet(type1), new Expression[] {
                    new ReferenceExp(((Declaration) (obj3))), QuoteExp.getInstance(new Integer(j2)), type
                }));
                l = j2 + 1;
                i = j1 + 1;
            } while (true);
            ((BeginExp) (obj6)).add(new ReferenceExp(((Declaration) (obj3))));
            letexp.body = ((Expression) (obj6));
            return letexp;
        }
        if (obj3 == null || obj6 == null)
        {
            break MISSING_BLOCK_LABEL_2721;
        }
        if ((obj3 instanceof TypeValue) && c == 'N')
        {
            procedure = ((TypeValue)obj3).getConstructor();
            if (procedure != null)
            {
                applyexp = new Expression[j4 - 1];
                System.arraycopy(aexpression1, 1, applyexp, 0, j4 - 1);
                return inlinecalls.visit(new ApplyExp(procedure, applyexp), type);
            }
        }
        if (compilation == null)
        {
            obj5 = null;
        } else
        if (compilation.curClass != null)
        {
            obj5 = compilation.curClass;
        } else
        {
            obj5 = compilation.mainClass;
        }
        try
        {
            aprimprocedure = getMethods(((ObjectType) (obj3)), ((String) (obj6)), ((ClassType) (obj5)), invoke);
            k4 = ClassMethods.selectApplicable(aprimprocedure, l);
        }
        // Misplaced declaration of an exception variable
        catch (InlineCalls inlinecalls)
        {
            compilation.error('w', (new StringBuilder()).append("unknown class: ").append(((ObjectType) (obj3)).getName()).toString());
            return applyexp;
        }
        byte0 = -1;
        if (c == 'N')
        {
            int k1 = hasKeywordArgument(1, aexpression1);
            if (k1 < aexpression1.length || k4 <= 0 && ClassMethods.selectApplicable(aprimprocedure, new Type[] {
    Compilation.typeClassType
}) >> 32 == 1L)
            {
                Object aobj[] = checkKeywords(((ObjectType) (obj3)), aexpression1, k1, ((ClassType) (obj5)));
                if (aobj.length * 2 == aexpression1.length - k1 || ClassMethods.selectApplicable(ClassMethods.getMethods(((ObjectType) (obj3)), "add", 'V', null, invoke.language), 2) > 0)
                {
                    procedure = null;
                    i = 0;
                    while (i < aobj.length) 
                    {
                        Procedure procedure1 = procedure;
                        if (aobj[i] instanceof String)
                        {
                            if (procedure == null)
                            {
                                procedure = new StringBuffer();
                                procedure.append("no field or setter ");
                            } else
                            {
                                procedure.append(", ");
                            }
                            procedure.append('`');
                            procedure.append(aobj[i]);
                            procedure.append('\'');
                            procedure1 = procedure;
                        }
                        i++;
                        procedure = procedure1;
                    }
                    if (procedure != null)
                    {
                        procedure.append(" in class ");
                        procedure.append(((ObjectType) (obj3)).getName());
                        compilation.error('w', procedure.toString());
                        return applyexp;
                    }
                    Object obj;
                    if (k1 < aexpression1.length)
                    {
                        procedure = new Expression[k1];
                        System.arraycopy(aexpression1, 0, procedure, 0, k1);
                        procedure = (ApplyExp)inlinecalls.visit(new ApplyExp(applyexp.getFunction(), procedure), ((Type) (obj3)));
                    } else
                    {
                        procedure = new ApplyExp(aprimprocedure[0], new Expression[] {
                            expression
                        });
                    }
                    procedure.setType(((Type) (obj3)));
                    obj = procedure;
                    if (aexpression1.length > 0)
                    {
                        i = 0;
                        obj = procedure;
                        while (i < aobj.length) 
                        {
                            obj6 = aobj[i];
                            if (obj6 instanceof Method)
                            {
                                procedure = ((Method)obj6).getParameterTypes()[0];
                            } else
                            if (obj6 instanceof Field)
                            {
                                procedure = ((Field)obj6).getType();
                            } else
                            {
                                procedure = null;
                            }
                            obj5 = procedure;
                            if (procedure != null)
                            {
                                obj5 = invoke.language.getLangTypeFor(procedure);
                            }
                            procedure = inlinecalls.visit(aexpression1[i * 2 + k1 + 1], ((Type) (obj5)));
                            obj5 = new QuoteExp(obj6);
                            obj = new ApplyExp(SlotSet.setFieldReturnObject, new Expression[] {
                                obj, obj5, procedure
                            });
                            ((ApplyExp) (obj)).setType(((Type) (obj3)));
                            i++;
                        }
                        if (k1 == aexpression1.length)
                        {
                            i = 1;
                        } else
                        {
                            i = aobj.length * 2 + k1;
                        }
                        procedure = ((Procedure) (obj));
                        obj = procedure;
                        if (i < aexpression1.length)
                        {
                            obj = new LetExp(new Expression[] {
                                procedure
                            });
                            obj3 = ((LetExp) (obj)).addDeclaration((String)null, ((Type) (obj3)));
                            ((Declaration) (obj3)).noteValue(procedure);
                            procedure = new BeginExp();
                            for (; i < aexpression1.length; i++)
                            {
                                obj5 = new ReferenceExp(((Declaration) (obj3)));
                                obj6 = QuoteExp.getInstance("add");
                                aprimprocedure = aexpression1[i];
                                procedure.add(inlinecalls.visit(new ApplyExp(Invoke.invoke, new Expression[] {
                                    obj5, obj6, aprimprocedure
                                }), null));
                            }

                            procedure.add(new ReferenceExp(((Declaration) (obj3))));
                            obj.body = procedure;
                        }
                    }
                    return inlinecalls.checkType(((Expression) (obj)).setLine(applyexp), type);
                }
            }
        }
        if (k4 < 0) goto _L2; else goto _L1
_L1:
        int l1 = 1;
_L5:
        if (l1 >= j4) goto _L4; else goto _L3
_L3:
        Object obj1;
        int k2;
        procedure = null;
        obj1 = null;
        if (l1 == j4 - 1)
        {
            k2 = 1;
        } else
        {
            k2 = 0;
        }
        if (c == 'P' && l1 == 2 || c != 'N' && l1 == 1)
        {
            obj1 = null;
        } else
        {
            if (c != 'P' || l1 != 1)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj1 = obj3;
        }
_L7:
        aexpression1[l1] = inlinecalls.visit(aexpression1[l1], ((Type) (obj1)));
        l1++;
          goto _L5
        if (k4 <= 0) goto _L7; else goto _L6
_L6:
        int j3;
        int l2;
        if (c == 'N')
        {
            l2 = 1;
        } else
        {
            l2 = i;
        }
        j3 = 0;
_L24:
        obj1 = procedure;
        if (j3 >= k4) goto _L7; else goto _L8
_L8:
        obj1 = aprimprocedure[j3];
        int k3;
        if (c != 'S' && ((PrimProcedure) (obj1)).takesTarget())
        {
            k3 = 1;
        } else
        {
            k3 = 0;
        }
        k3 = (l1 - l2) + k3;
        if (k2 && ((PrimProcedure) (obj1)).takesVarArgs() && k3 == ((PrimProcedure) (obj1)).minArgs())
        {
            procedure = null;
        } else
        {
            obj1 = ((PrimProcedure) (obj1)).getParameterType(k3);
            if (j3 == 0)
            {
                procedure = ((Procedure) (obj1));
            } else
            if ((obj1 instanceof PrimType) != (procedure instanceof PrimType))
            {
                procedure = null;
            } else
            {
                procedure = Type.lowestCommonSuperType(procedure, ((Type) (obj1)));
            }
        }
        obj1 = procedure;
        if (procedure == null) goto _L7; else goto _L9
_L9:
        j3++;
        break MISSING_BLOCK_LABEL_1776;
_L4:
        int i3;
        long l5 = selectApplicable(aprimprocedure, ((ObjectType) (obj3)), aexpression1, l, i, i1);
        i3 = (int)(l5 >> 32);
        k2 = (int)l5;
_L11:
        int i4;
        int l4 = aprimprocedure.length;
        procedure = aprimprocedure;
        int l3 = l;
        int i2 = i;
        i4 = k2;
        j3 = i3;
        if (i3 + k2 == 0)
        {
            procedure = aprimprocedure;
            l3 = l;
            i2 = i;
            i4 = k2;
            j3 = i3;
            if (c == 'N')
            {
                procedure = getMethods(((ObjectType) (obj3)), "valueOf", ((ClassType) (obj5)), Invoke.invokeStatic);
                i2 = 1;
                l3 = j4 - 1;
                long l6 = selectApplicable(procedure, ((ObjectType) (obj3)), aexpression1, l3, 1, -1);
                j3 = (int)(l6 >> 32);
                i4 = (int)l6;
            }
        }
        if (j3 + i4 == 0)
        {
label2:
            {
                if (c != 'P')
                {
                    l = byte0;
                    if (!compilation.warnInvokeUnknownMethod())
                    {
                        break label2;
                    }
                }
                Object obj2 = obj6;
                if (c == 'N')
                {
                    obj2 = (new StringBuilder()).append(((String) (obj6))).append("/valueOf").toString();
                }
                StringBuilder stringbuilder = new StringBuilder();
                int j;
                if (procedure.length + l4 == 0)
                {
                    stringbuilder.append("no accessible method '");
                } else
                if (k4 == 0xfff10000)
                {
                    stringbuilder.append("too few arguments for method '");
                } else
                if (k4 == 0xfff20000)
                {
                    stringbuilder.append("too many arguments for method '");
                } else
                {
                    stringbuilder.append("no possibly applicable method '");
                }
                stringbuilder.append(((String) (obj2)));
                stringbuilder.append("' in ");
                stringbuilder.append(((ObjectType) (obj3)).getName());
                if (c == 'P')
                {
                    c = 'e';
                } else
                {
                    c = 'w';
                }
                compilation.error(c, stringbuilder.toString());
                l = byte0;
            }
        } else
        {
label3:
            {
                if (j3 != 1 && (j3 != 0 || i4 != 1))
                {
                    break label3;
                }
                l = 0;
            }
        }
          goto _L10
_L2:
        i3 = 0;
        k2 = 0;
          goto _L11
        if (j3 <= 0)
        {
            break MISSING_BLOCK_LABEL_2587;
        }
        k2 = MethodProc.mostSpecific(procedure, j3);
        k = k2;
        if (k2 >= 0) goto _L13; else goto _L12
_L12:
        k = k2;
        if (c != 'S') goto _L13; else goto _L14
_L14:
        l = 0;
_L21:
        k = k2;
        if (l >= j3) goto _L13; else goto _L15
_L15:
        k = k2;
        if (!procedure[l].getStaticFlag())
        {
            break MISSING_BLOCK_LABEL_2567;
        }
        if (k2 < 0) goto _L17; else goto _L16
_L16:
        k = -1;
_L13:
        l = k;
        if (k >= 0) goto _L10; else goto _L18
_L18:
        if (c == 'P') goto _L20; else goto _L19
_L19:
        l = k;
        if (!compilation.warnInvokeUnknownMethod()) goto _L10; else goto _L20
_L20:
        aexpression = new StringBuffer();
        aexpression.append("more than one definitely applicable method `");
        aexpression.append(((String) (obj6)));
        aexpression.append("' in ");
        aexpression.append(((ObjectType) (obj3)).getName());
        append(procedure, j3, aexpression);
        if (c == 'P')
        {
            c = 'e';
        } else
        {
            c = 'w';
        }
        compilation.error(c, aexpression.toString());
        l = k;
          goto _L10
_L17:
        k = l;
        l++;
        k2 = k;
          goto _L21
        if (c == 'P') goto _L23; else goto _L22
_L22:
        l = byte0;
        if (!compilation.warnInvokeUnknownMethod()) goto _L10; else goto _L23
_L23:
        aexpression = new StringBuffer();
        aexpression.append("more than one possibly applicable method '");
        aexpression.append(((String) (obj6)));
        aexpression.append("' in ");
        aexpression.append(((ObjectType) (obj3)).getName());
        append(procedure, i4, aexpression);
        if (c == 'P')
        {
            c = 'e';
        } else
        {
            c = 'w';
        }
        compilation.error(c, aexpression.toString());
        l = byte0;
_L10:
        if (l < 0)
        {
            break MISSING_BLOCK_LABEL_2721;
        }
        Expression aexpression[] = new Expression[l3];
        procedure = procedure[l];
        procedure.takesVarArgs();
        j = 0;
        if (i1 >= 0)
        {
            aexpression[0] = aexpression1[i1];
            j = 0 + 1;
        }
        int k;
        for (l = i2; l < aexpression1.length && j < aexpression.length; j++)
        {
            aexpression[j] = aexpression1[l];
            l++;
        }

        procedure = new ApplyExp(procedure, aexpression);
        procedure.setLine(applyexp);
        return inlinecalls.visitApplyOnly(procedure, type);
        applyexp.visitArgs(inlinecalls);
        return applyexp;
          goto _L24
    }
}
