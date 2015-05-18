// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Language;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Environment;
import gnu.mapping.HasNamedParts;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import kawa.lang.Translator;

// Referenced classes of package gnu.kawa.functions:
//            GetNamedExp, GetNamedInstancePart, NamedPart, NamedPartSetter, 
//            SetNamedInstancePart

public class CompileNamedPart
{

    static final ClassType typeHasNamedParts = ClassType.make("gnu.mapping.HasNamedParts");

    public CompileNamedPart()
    {
    }

    public static String combineName(Expression expression, Expression expression1)
    {
label0:
        {
            Object obj;
label1:
            {
                obj = expression1.valueIfConstant();
                if (!(obj instanceof SimpleSymbol))
                {
                    break label0;
                }
                if (expression instanceof ReferenceExp)
                {
                    String s = ((ReferenceExp)expression).getSimpleName();
                    expression1 = s;
                    if (s != null)
                    {
                        break label1;
                    }
                }
                if (!(expression instanceof GetNamedExp))
                {
                    break label0;
                }
                expression1 = ((GetNamedExp)expression).combinedName;
                if (expression1 == null)
                {
                    break label0;
                }
            }
            return (new StringBuilder()).append(expression1).append(':').append(obj).toString().intern();
        }
        return null;
    }

    public static Expression makeExp(Type type, String s)
    {
        return makeExp(((Expression) (new QuoteExp(type))), ((Expression) (new QuoteExp(s))));
    }

    public static Expression makeExp(Expression expression, Expression expression1)
    {
        String s = combineName(expression, expression1);
        Environment environment = Environment.getCurrent();
        if (s != null)
        {
            Object obj1 = (Translator)Compilation.getCurrent();
            Symbol symbol = Namespace.EmptyNamespace.getSymbol(s);
            obj1 = ((Translator) (obj1)).lexical.lookup(symbol, false);
            if (!Declaration.isUnknown(((Declaration) (obj1))))
            {
                return new ReferenceExp(((Declaration) (obj1)));
            }
            if (symbol != null && environment.isBound(symbol, null))
            {
                return new ReferenceExp(s);
            }
        }
        Object obj2 = expression;
        if (expression instanceof ReferenceExp)
        {
            ReferenceExp referenceexp = (ReferenceExp)expression;
            obj2 = expression;
            if (referenceexp.isUnknown())
            {
                Object obj = referenceexp.getSymbol();
                if (obj instanceof Symbol)
                {
                    obj = (Symbol)obj;
                } else
                {
                    obj = environment.getSymbol(obj.toString());
                }
                obj2 = expression;
                if (environment.get(((gnu.mapping.EnvironmentKey) (obj)), null) == null)
                {
                    obj = referenceexp.getName();
                    try
                    {
                        obj2 = QuoteExp.getInstance(Type.make(ClassType.getContextClass(((String) (obj)))));
                    }
                    catch (Throwable throwable)
                    {
                        obj2 = expression;
                    }
                }
            }
        }
        expression = new GetNamedExp(new Expression[] {
            obj2, expression1
        });
        expression.combinedName = s;
        return expression;
    }

    public static Expression makeExp(Expression expression, String s)
    {
        return makeExp(expression, ((Expression) (new QuoteExp(s))));
    }

    public static Expression makeGetNamedInstancePartExp(Expression expression)
    {
        if (expression instanceof QuoteExp)
        {
            Object obj = ((QuoteExp)expression).getValue();
            if (obj instanceof SimpleSymbol)
            {
                return QuoteExp.getInstance(new GetNamedInstancePart(obj.toString()));
            }
        }
        QuoteExp quoteexp = new QuoteExp(ClassType.make("gnu.kawa.functions.GetNamedInstancePart"));
        return new ApplyExp(Invoke.make, new Expression[] {
            quoteexp, expression
        });
    }

    public static Expression validateGetNamedInstancePart(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        applyexp = applyexp.getArgs();
        GetNamedInstancePart getnamedinstancepart = (GetNamedInstancePart)procedure;
        if (getnamedinstancepart.isField)
        {
            procedure = new Expression[2];
            procedure[0] = applyexp[0];
            procedure[1] = new QuoteExp(getnamedinstancepart.pname);
            applyexp = SlotGet.field;
        } else
        {
            int i = applyexp.length;
            procedure = new Expression[i + 1];
            procedure[0] = applyexp[0];
            procedure[1] = new QuoteExp(getnamedinstancepart.pname);
            System.arraycopy(applyexp, 1, procedure, 2, i - 1);
            applyexp = Invoke.invoke;
        }
        return inlinecalls.visitApplyOnly(new ApplyExp(applyexp, procedure), type);
    }

    public static Expression validateGetNamedPart(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        Expression aexpression[];
        applyexp.visitArgs(inlinecalls);
        aexpression = applyexp.getArgs();
        if (aexpression.length == 2 && (aexpression[1] instanceof QuoteExp) && (applyexp instanceof GetNamedExp)) goto _L2; else goto _L1
_L1:
        return applyexp;
_L2:
        Object obj;
        String s;
        Type type1;
        Compilation compilation;
        Language language;
        Type type2;
        GetNamedExp getnamedexp;
        procedure = aexpression[0];
        obj = null;
        if (procedure instanceof ReferenceExp)
        {
            obj = (ReferenceExp)procedure;
            if ("*".equals(((ReferenceExp) (obj)).getName()))
            {
                return makeGetNamedInstancePartExp(aexpression[1]);
            }
            obj = ((ReferenceExp) (obj)).getBinding();
        }
        s = ((QuoteExp)aexpression[1]).getValue().toString();
        type1 = procedure.getType();
        if (procedure != QuoteExp.nullExp);
        compilation = inlinecalls.getCompilation();
        language = compilation.getLanguage();
        type2 = language.getTypeFor(procedure, false);
        if (compilation == null)
        {
            procedure = null;
        } else
        if (compilation.curClass != null)
        {
            procedure = compilation.curClass;
        } else
        {
            procedure = compilation.mainClass;
        }
        getnamedexp = (GetNamedExp)applyexp;
        if (type2 != null)
        {
            if (s.equals("<>"))
            {
                return new QuoteExp(type2);
            }
            if (type2 instanceof ObjectType)
            {
                if (s.equals("new"))
                {
                    return getnamedexp.setProcedureKind('N');
                }
                if (s.equals("instance?"))
                {
                    return getnamedexp.setProcedureKind('I');
                }
                if (s.equals("@"))
                {
                    return getnamedexp.setProcedureKind('C');
                }
            }
        }
        if (!(type2 instanceof ObjectType))
        {
            break; /* Loop/switch isn't completed */
        }
        if (s.length() > 1 && s.charAt(0) == '.')
        {
            return new QuoteExp(new NamedPart(type2, s, 'D'));
        }
        if (CompileReflect.checkKnownClass(type2, compilation) >= 0)
        {
            procedure = ClassMethods.getMethods((ObjectType)type2, Compilation.mangleName(s), '\0', procedure, language);
            if (procedure != null && procedure.length > 0)
            {
                getnamedexp.methods = procedure;
                return getnamedexp.setProcedureKind('S');
            } else
            {
                procedure = new ApplyExp(SlotGet.staticField, aexpression);
                procedure.setLine(applyexp);
                return inlinecalls.visitApplyOnly(procedure, type);
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (type2 == null);
        if (!type1.isSubtype(Compilation.typeClassType) && !type1.isSubtype(Type.javalangClassType))
        {
            if (type1 instanceof ObjectType)
            {
                ObjectType objecttype = (ObjectType)type1;
                gnu.expr.PrimProcedure aprimprocedure[] = ClassMethods.getMethods(objecttype, Compilation.mangleName(s), 'V', procedure, language);
                if (aprimprocedure != null && aprimprocedure.length > 0)
                {
                    getnamedexp.methods = aprimprocedure;
                    return getnamedexp.setProcedureKind('M');
                }
                if (type1.isSubtype(typeHasNamedParts))
                {
                    if (obj != null)
                    {
                        inlinecalls = ((InlineCalls) (Declaration.followAliases(((Declaration) (obj))).getConstantValue()));
                        if (inlinecalls != null)
                        {
                            inlinecalls = (HasNamedParts)inlinecalls;
                            if (inlinecalls.isConstant(s))
                            {
                                return QuoteExp.getInstance(inlinecalls.get(s));
                            }
                        }
                    }
                    inlinecalls = aexpression[0];
                    type = QuoteExp.getInstance(s);
                    return (new ApplyExp(typeHasNamedParts.getDeclaredMethod("get", 1), new Expression[] {
                        inlinecalls, type
                    })).setLine(applyexp);
                }
                if (SlotGet.lookupMember(objecttype, s, procedure) != null || s.equals("length") && (type1 instanceof ArrayType))
                {
                    procedure = new ApplyExp(SlotGet.field, aexpression);
                    procedure.setLine(applyexp);
                    return inlinecalls.visitApplyOnly(procedure, type);
                }
            }
            if (compilation.warnUnknownMember())
            {
                compilation.error('w', (new StringBuilder()).append("no known slot '").append(s).append("' in ").append(type1.getName()).toString());
                return applyexp;
            }
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public static Expression validateNamedPart(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        Expression aexpression1[] = applyexp.getArgs();
        procedure = (NamedPart)procedure;
        String s;
        switch (((NamedPart) (procedure)).kind)
        {
        default:
            return applyexp;

        case 68: // 'D'
            s = ((NamedPart) (procedure)).member.toString().substring(1);
            break;
        }
        Expression aexpression[] = new Expression[2];
        aexpression[1] = QuoteExp.getInstance(s);
        if (aexpression1.length > 0)
        {
            aexpression[0] = Compilation.makeCoercion(aexpression1[0], new QuoteExp(((NamedPart) (procedure)).container));
            procedure = SlotGet.field;
        } else
        {
            aexpression[0] = QuoteExp.getInstance(((NamedPart) (procedure)).container);
            procedure = SlotGet.staticField;
        }
        procedure = new ApplyExp(procedure, aexpression);
        procedure.setLine(applyexp);
        return inlinecalls.visitApplyOnly(procedure, type);
    }

    public static Expression validateNamedPartSetter(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        NamedPart namedpart;
        applyexp.visitArgs(inlinecalls);
        namedpart = (NamedPart)((NamedPartSetter)procedure).getGetter();
        procedure = applyexp;
        if (namedpart.kind != 'D') goto _L2; else goto _L1
_L1:
        Expression aexpression[];
        aexpression = new Expression[3];
        aexpression[1] = QuoteExp.getInstance(namedpart.member.toString().substring(1));
        aexpression[2] = applyexp.getArgs()[0];
        if (applyexp.getArgCount() != 1) goto _L4; else goto _L3
_L3:
        aexpression[0] = QuoteExp.getInstance(namedpart.container);
        procedure = SlotSet.set$Mnstatic$Mnfield$Ex;
_L7:
        procedure = new ApplyExp(procedure, aexpression);
        procedure.setLine(applyexp);
        procedure = inlinecalls.visitApplyOnly(procedure, type);
_L2:
        return procedure;
_L4:
        procedure = applyexp;
        if (applyexp.getArgCount() != 2) goto _L2; else goto _L5
_L5:
        aexpression[0] = Compilation.makeCoercion(applyexp.getArgs()[0], new QuoteExp(namedpart.container));
        procedure = SlotSet.set$Mnfield$Ex;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static Expression validateSetNamedInstancePart(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        applyexp = applyexp.getArgs();
        Object obj = ((SetNamedInstancePart)procedure).pname;
        procedure = applyexp[0];
        obj = new QuoteExp(obj);
        applyexp = applyexp[1];
        return inlinecalls.visitApplyOnly(new ApplyExp(SlotSet.set$Mnfield$Ex, new Expression[] {
            procedure, obj, applyexp
        }), type);
    }

    public static Expression validateSetNamedPart(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        String s;
        Type type1;
        applyexp.visitArgs(inlinecalls);
        procedure = applyexp.getArgs();
        if (procedure.length != 3 || !(procedure[1] instanceof QuoteExp))
        {
            return applyexp;
        }
        type = procedure[0];
        s = ((QuoteExp)procedure[1]).getValue().toString();
        type1 = type.getType();
        Compilation compilation = inlinecalls.getCompilation();
        inlinecalls = compilation.getLanguage().getTypeFor(type);
        if (compilation == null)
        {
            type = null;
        } else
        if (compilation.curClass != null)
        {
            type = compilation.curClass;
        } else
        {
            type = compilation.mainClass;
        }
        if (!(inlinecalls instanceof ClassType)) goto _L2; else goto _L1
_L1:
        inlinecalls = new ApplyExp(SlotSet.set$Mnstatic$Mnfield$Ex, procedure);
_L4:
        if (inlinecalls != applyexp)
        {
            inlinecalls.setLine(applyexp);
        }
        inlinecalls.setType(Type.voidType);
        return inlinecalls;
_L2:
        inlinecalls = applyexp;
        if (type1 instanceof ClassType)
        {
            inlinecalls = applyexp;
            if (SlotSet.lookupMember((ClassType)type1, s, type) != null)
            {
                inlinecalls = new ApplyExp(SlotSet.set$Mnfield$Ex, procedure);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
