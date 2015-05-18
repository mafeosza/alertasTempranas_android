// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.text.SourceMessages;
import java.lang.reflect.InvocationTargetException;

// Referenced classes of package gnu.expr:
//            ExpExpVisitor, QuoteExp, LambdaExp, Expression, 
//            Declaration, ApplyExp, LetExp, Compilation, 
//            ObjectExp, Language, TypeValue, BeginExp, 
//            IfExp, ReferenceExp, ScopeExp, SetExp, 
//            TryExp

public class InlineCalls extends ExpExpVisitor
{

    private static Class inlinerMethodArgTypes[];

    public InlineCalls(Compilation compilation)
    {
        setContext(compilation);
    }

    public static Integer checkIntValue(Expression expression)
    {
        if (expression instanceof QuoteExp)
        {
            expression = (QuoteExp)expression;
            Object obj = expression.getValue();
            if (!expression.isExplicitlyTyped() && (obj instanceof IntNum))
            {
                expression = (IntNum)obj;
                if (expression.inIntRange())
                {
                    return Integer.valueOf(expression.intValue());
                }
            }
        }
        return null;
    }

    public static Long checkLongValue(Expression expression)
    {
        if (expression instanceof QuoteExp)
        {
            expression = (QuoteExp)expression;
            Object obj = expression.getValue();
            if (!expression.isExplicitlyTyped() && (obj instanceof IntNum))
            {
                expression = (IntNum)obj;
                if (expression.inLongRange())
                {
                    return Long.valueOf(expression.longValue());
                }
            }
        }
        return null;
    }

    private static Class[] getInlinerMethodArgTypes()
        throws Exception
    {
        gnu/expr/InlineCalls;
        JVM INSTR monitorenter ;
        Class aclass1[] = inlinerMethodArgTypes;
        Class aclass[];
        aclass = aclass1;
        if (aclass1 != null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        aclass = new Class[4];
        aclass[0] = Class.forName("gnu.expr.ApplyExp");
        aclass[1] = Class.forName("gnu.expr.InlineCalls");
        aclass[2] = Class.forName("gnu.bytecode.Type");
        aclass[3] = Class.forName("gnu.mapping.Procedure");
        inlinerMethodArgTypes = aclass;
        gnu/expr/InlineCalls;
        JVM INSTR monitorexit ;
        return aclass;
        Exception exception;
        exception;
        throw exception;
    }

    public static Expression inlineCall(LambdaExp lambdaexp, Expression aexpression[], boolean flag)
    {
        if (lambdaexp.keywords != null || lambdaexp.nameDecl != null && !flag)
        {
            return null;
        }
        boolean flag1;
        if (lambdaexp.max_args < 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (lambdaexp.min_args == lambdaexp.max_args && lambdaexp.min_args == aexpression.length || flag1 && lambdaexp.min_args == 0)
        {
            Object obj = null;
            int i = 0;
            Expression aexpression1[];
            IdentityHashTable identityhashtable;
            if (flag)
            {
                IdentityHashTable identityhashtable1 = new IdentityHashTable();
                Expression aexpression3[] = Expression.deepCopy(aexpression, identityhashtable1);
                aexpression1 = aexpression3;
                identityhashtable = identityhashtable1;
                if (aexpression3 == null)
                {
                    aexpression1 = aexpression3;
                    identityhashtable = identityhashtable1;
                    if (aexpression != null)
                    {
                        return null;
                    }
                }
            } else
            {
                identityhashtable = null;
                aexpression1 = aexpression;
            }
            if (flag1)
            {
                Expression aexpression2[] = new Expression[aexpression.length + 1];
                aexpression2[0] = QuoteExp.getInstance(lambdaexp.firstDecl().type);
                System.arraycopy(aexpression, 0, aexpression2, 1, aexpression.length);
                aexpression1 = new Expression[1];
                aexpression1[0] = new ApplyExp(Invoke.make, aexpression2);
            }
            LetExp letexp = new LetExp(aexpression1);
            aexpression = lambdaexp.firstDecl();
            while (aexpression != null) 
            {
                Declaration declaration = aexpression.nextDecl();
                if (flag)
                {
                    obj = letexp.addDeclaration(((Declaration) (aexpression)).symbol, ((Declaration) (aexpression)).type);
                    if (((Declaration) (aexpression)).typeExp != null)
                    {
                        obj.typeExp = Expression.deepCopy(((Declaration) (aexpression)).typeExp);
                        if (((Declaration) (obj)).typeExp == null)
                        {
                            return null;
                        }
                    }
                    identityhashtable.put(aexpression, obj);
                } else
                {
                    lambdaexp.remove(((Declaration) (obj)), aexpression);
                    letexp.add(((Declaration) (obj)), aexpression);
                }
                if (!flag1 && !aexpression.getCanWrite())
                {
                    aexpression.setValue(aexpression1[i]);
                }
                obj = aexpression;
                aexpression = declaration;
                i++;
            }
            Expression expression = lambdaexp.body;
            aexpression = expression;
            if (flag)
            {
                expression = Expression.deepCopy(expression, identityhashtable);
                aexpression = expression;
                if (expression == null)
                {
                    aexpression = expression;
                    if (lambdaexp.body != null)
                    {
                        return null;
                    }
                }
            }
            letexp.body = aexpression;
            return letexp;
        } else
        {
            return null;
        }
    }

    public static Expression inlineCalls(Expression expression, Compilation compilation)
    {
        return (new InlineCalls(compilation)).visit(expression, ((Type) (null)));
    }

    public Expression checkType(Expression expression, Type type)
    {
        boolean flag = true;
        Object obj1 = expression.getType();
        boolean flag1;
        if ((type instanceof ClassType) && ((ClassType)type).isInterface() && ((Type) (obj1)).isSubtype(Compilation.typeProcedure) && !((Type) (obj1)).isSubtype(type))
        {
            if (expression instanceof LambdaExp)
            {
                Method method = ((ClassType)type).checkSingleAbstractMethod();
                if (method != null)
                {
                    obj1 = (LambdaExp)expression;
                    ObjectExp objectexp = new ObjectExp();
                    objectexp.setLocation(expression);
                    objectexp.supers = (new Expression[] {
                        new QuoteExp(type)
                    });
                    objectexp.setTypes(getCompilation());
                    expression = method.getName();
                    objectexp.addMethod(((LambdaExp) (obj1)), expression);
                    objectexp.addDeclaration(expression, Compilation.typeProcedure);
                    objectexp.firstChild = ((LambdaExp) (obj1));
                    objectexp.declareParts(comp);
                    return visit(objectexp, type);
                }
            }
            flag1 = true;
        } else
        {
            Object obj = obj1;
            if (obj1 == Type.toStringType)
            {
                obj = Type.javalangStringType;
            }
            if (type == null || type.compare(((Type) (obj))) != -3)
            {
                flag = false;
            }
            obj1 = obj;
            flag1 = flag;
            if (flag)
            {
                obj1 = obj;
                flag1 = flag;
                if (type instanceof TypeValue)
                {
                    Expression expression1 = ((TypeValue)type).convertValue(expression);
                    obj1 = obj;
                    flag1 = flag;
                    if (expression1 != null)
                    {
                        return expression1;
                    }
                }
            }
        }
        if (flag1)
        {
            Language language = comp.getLanguage();
            comp.error('w', (new StringBuilder()).append("type ").append(language.formatType(((Type) (obj1)))).append(" is incompatible with required type ").append(language.formatType(type)).toString(), expression);
        }
        return expression;
    }

    public QuoteExp fixIntValue(Expression expression)
    {
        expression = checkIntValue(expression);
        if (expression != null)
        {
            return new QuoteExp(expression, comp.getLanguage().getTypeFor(Integer.TYPE));
        } else
        {
            return null;
        }
    }

    public QuoteExp fixLongValue(Expression expression)
    {
        expression = checkLongValue(expression);
        if (expression != null)
        {
            return new QuoteExp(expression, comp.getLanguage().getTypeFor(Long.TYPE));
        } else
        {
            return null;
        }
    }

    public Expression maybeInline(ApplyExp applyexp, Type type, Procedure procedure)
    {
        procedure;
        JVM INSTR monitorenter ;
        Object obj1 = procedure.getProperty(Procedure.validateApplyKey, null);
        Object obj = obj1;
        int i;
        if (!(obj1 instanceof String))
        {
            break MISSING_BLOCK_LABEL_133;
        }
        obj1 = (String)obj1;
        i = ((String) (obj1)).indexOf(':');
        obj = null;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        obj = ((String) (obj1)).substring(0, i);
        obj1 = ((String) (obj1)).substring(i + 1);
        obj = Class.forName(((String) (obj)), true, procedure.getClass().getClassLoader()).getDeclaredMethod(((String) (obj1)), getInlinerMethodArgTypes());
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        error('e', (new StringBuilder()).append("inliner property string for ").append(procedure).append(" is not of the form CLASS:METHOD").toString());
        procedure;
        JVM INSTR monitorexit ;
        return null;
        procedure;
        JVM INSTR monitorexit ;
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object aobj[] = new Object[4];
        aobj[0] = applyexp;
        aobj[1] = this;
        aobj[2] = type;
        aobj[3] = procedure;
        if (!(obj instanceof Procedure)) goto _L4; else goto _L3
_L3:
        applyexp = (Expression)((Procedure)obj).applyN(aobj);
        return applyexp;
        applyexp;
        procedure;
        JVM INSTR monitorexit ;
        try
        {
            throw applyexp;
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            applyexp = type;
        }
        if (type instanceof InvocationTargetException)
        {
            applyexp = ((InvocationTargetException)type).getTargetException();
        }
        messages.error('e', (new StringBuilder()).append("caught exception in inliner for ").append(procedure).append(" - ").append(applyexp).toString(), applyexp);
_L2:
        return null;
_L4:
        if (!(obj instanceof java.lang.reflect.Method)) goto _L2; else goto _L5
_L5:
        applyexp = (Expression)((java.lang.reflect.Method)obj).invoke(null, aobj);
        return applyexp;
    }

    public Expression visit(Expression expression, Type type)
    {
        Expression expression1 = expression;
        if (!expression.getFlag(1))
        {
            expression.setFlag(1);
            expression1 = (Expression)super.visit(expression, type);
            expression1.setFlag(1);
        }
        return checkType(expression1, type);
    }

    public volatile Object visit(Expression expression, Object obj)
    {
        return visit(expression, (Type)obj);
    }

    protected Expression visitApplyExp(ApplyExp applyexp, Type type)
    {
        Expression expression = applyexp.func;
        if (expression instanceof LambdaExp)
        {
            Object obj = (LambdaExp)expression;
            obj = inlineCall((LambdaExp)expression, applyexp.args, false);
            if (obj != null)
            {
                return visit(((Expression) (obj)), type);
            }
        }
        expression = visit(expression, ((Type) (null)));
        applyexp.func = expression;
        return expression.validateApply(applyexp, this, type, null);
    }

    protected volatile Object visitApplyExp(ApplyExp applyexp, Object obj)
    {
        return visitApplyExp(applyexp, (Type)obj);
    }

    public final Expression visitApplyOnly(ApplyExp applyexp, Type type)
    {
        return applyexp.func.validateApply(applyexp, this, type, null);
    }

    protected Expression visitBeginExp(BeginExp beginexp, Type type)
    {
        int j = beginexp.length - 1;
        int i = 0;
        while (i <= j) 
        {
            Expression aexpression[] = beginexp.exps;
            Expression expression = beginexp.exps[i];
            Type type1;
            if (i < j)
            {
                type1 = null;
            } else
            {
                type1 = type;
            }
            aexpression[i] = visit(expression, type1);
            i++;
        }
        return beginexp;
    }

    protected volatile Object visitBeginExp(BeginExp beginexp, Object obj)
    {
        return visitBeginExp(beginexp, (Type)obj);
    }

    protected Expression visitIfExp(IfExp ifexp, Type type)
    {
        Expression expression1 = (Expression)ifexp.test.visit(this, null);
        Expression expression = expression1;
        if (expression1 instanceof ReferenceExp)
        {
            Object obj = ((ReferenceExp)expression1).getBinding();
            expression = expression1;
            if (obj != null)
            {
                obj = ((Declaration) (obj)).getValue();
                expression = expression1;
                if (obj instanceof QuoteExp)
                {
                    expression = expression1;
                    if (obj != QuoteExp.undefined_exp)
                    {
                        expression = ((Expression) (obj));
                    }
                }
            }
        }
        ifexp.test = expression;
        if (exitValue == null)
        {
            ifexp.then_clause = visit(ifexp.then_clause, type);
        }
        if (exitValue == null && ifexp.else_clause != null)
        {
            ifexp.else_clause = visit(ifexp.else_clause, type);
        }
        if (expression instanceof QuoteExp)
        {
            type = ifexp.select(comp.getLanguage().isTrue(((QuoteExp)expression).getValue()));
        } else
        {
            type = ifexp;
            if (expression.getType().isVoid())
            {
                boolean flag = comp.getLanguage().isTrue(Values.empty);
                comp.error('w', (new StringBuilder()).append("void-valued condition is always ").append(flag).toString());
                return new BeginExp(expression, ifexp.select(flag));
            }
        }
        return type;
    }

    protected volatile Object visitIfExp(IfExp ifexp, Object obj)
    {
        return visitIfExp(ifexp, (Type)obj);
    }

    protected Expression visitLambdaExp(LambdaExp lambdaexp, Type type)
    {
        Declaration declaration = lambdaexp.firstDecl();
        if (declaration != null && declaration.isThisParameter() && !lambdaexp.isClassMethod() && declaration.type == null)
        {
            declaration.setType(comp.mainClass);
        }
        return visitScopeExp(lambdaexp, type);
    }

    protected volatile Object visitLambdaExp(LambdaExp lambdaexp, Object obj)
    {
        return visitLambdaExp(lambdaexp, (Type)obj);
    }

    protected Expression visitLetExp(LetExp letexp, Type type)
    {
        Declaration declaration = letexp.firstDecl();
        int j = letexp.inits.length;
        int i = 0;
        while (i < j) 
        {
            Expression expression = letexp.inits[i];
            boolean flag = declaration.getFlag(8192L);
            Object obj1;
            if (flag && expression != QuoteExp.undefined_exp)
            {
                obj1 = declaration.getType();
            } else
            {
                obj1 = null;
            }
            obj1 = visit(expression, ((Type) (obj1)));
            letexp.inits[i] = ((Expression) (obj1));
            if (declaration.value == expression)
            {
                declaration.value = ((Expression) (obj1));
                if (!flag)
                {
                    declaration.setType(((Expression) (obj1)).getType());
                }
            }
            i++;
            declaration = declaration.nextDecl();
        }
        if (exitValue == null)
        {
            letexp.body = visit(letexp.body, type);
        }
        if (letexp.body instanceof ReferenceExp)
        {
            type = (ReferenceExp)letexp.body;
            Object obj = type.getBinding();
            if (obj != null && ((Declaration) (obj)).context == letexp && !type.getDontDereference() && j == 1)
            {
                type = letexp.inits[0];
                obj = ((Declaration) (obj)).getTypeExp();
                letexp = type;
                if (obj != QuoteExp.classObjectExp)
                {
                    letexp = visitApplyOnly(Compilation.makeCoercion(type, ((Expression) (obj))), null);
                }
                return letexp;
            }
        }
        return letexp;
    }

    protected volatile Object visitLetExp(LetExp letexp, Object obj)
    {
        return visitLetExp(letexp, (Type)obj);
    }

    protected Expression visitQuoteExp(QuoteExp quoteexp, Type type)
    {
        Object obj = quoteexp;
        if (quoteexp.getRawType() == null)
        {
            obj = quoteexp;
            if (!quoteexp.isSharedConstant())
            {
                Object obj1 = quoteexp.getValue();
                obj = quoteexp;
                if (obj1 != null)
                {
                    obj1 = comp.getLanguage().getTypeFor(obj1.getClass());
                    obj = obj1;
                    if (obj1 == Type.toStringType)
                    {
                        obj = Type.javalangStringType;
                    }
                    quoteexp.type = ((Type) (obj));
                    obj = quoteexp;
                    if (type instanceof PrimType)
                    {
                        char c = type.getSignature().charAt(0);
                        if (c == 'I')
                        {
                            type = fixIntValue(quoteexp);
                        } else
                        if (c == 'J')
                        {
                            type = fixLongValue(quoteexp);
                        } else
                        {
                            type = null;
                        }
                        obj = quoteexp;
                        if (type != null)
                        {
                            obj = type;
                        }
                    }
                }
            }
        }
        return ((Expression) (obj));
    }

    protected volatile Object visitQuoteExp(QuoteExp quoteexp, Object obj)
    {
        return visitQuoteExp(quoteexp, (Type)obj);
    }

    protected Expression visitReferenceExp(ReferenceExp referenceexp, Type type)
    {
        Declaration declaration = referenceexp.getBinding();
        if (declaration != null && declaration.field == null && !declaration.getCanWrite())
        {
            Object obj = declaration.getValue();
            if ((obj instanceof QuoteExp) && obj != QuoteExp.undefined_exp)
            {
                return visitQuoteExp((QuoteExp)obj, type);
            }
            if ((obj instanceof ReferenceExp) && !declaration.isAlias())
            {
                obj = (ReferenceExp)obj;
                Declaration declaration1 = ((ReferenceExp) (obj)).getBinding();
                Type type1 = declaration.getType();
                if (declaration1 != null && !declaration1.getCanWrite() && (type1 == null || type1 == Type.pointer_type || type1 == declaration1.getType()) && !((ReferenceExp) (obj)).getDontDereference())
                {
                    return visitReferenceExp(((ReferenceExp) (obj)), type);
                }
            }
            if (!referenceexp.isProcedureName() && (declaration.flags & 0x100080L) == 0x100080L)
            {
                comp.error('e', (new StringBuilder()).append("unimplemented: reference to method ").append(declaration.getName()).append(" as variable").toString());
                comp.error('e', declaration, "here is the definition of ", "");
            }
        }
        return (Expression)super.visitReferenceExp(referenceexp, type);
    }

    protected volatile Object visitReferenceExp(ReferenceExp referenceexp, Object obj)
    {
        return visitReferenceExp(referenceexp, (Type)obj);
    }

    protected Expression visitScopeExp(ScopeExp scopeexp, Type type)
    {
        scopeexp.visitChildren(this, null);
        visitDeclarationTypes(scopeexp);
        type = scopeexp.firstDecl();
        while (type != null) 
        {
            if (((Declaration) (type)).type == null)
            {
                Object obj = type.getValue();
                type.type = Type.objectType;
                if (obj != null && obj != QuoteExp.undefined_exp)
                {
                    obj = ((Expression) (obj)).getType();
                } else
                {
                    obj = Type.objectType;
                }
                type.setType(((Type) (obj)));
            }
            type = type.nextDecl();
        }
        return scopeexp;
    }

    protected volatile Object visitScopeExp(ScopeExp scopeexp, Object obj)
    {
        return visitScopeExp(scopeexp, (Type)obj);
    }

    protected Expression visitSetExp(SetExp setexp, Type type)
    {
        Declaration declaration = setexp.getBinding();
        super.visitSetExp(setexp, type);
        if (!setexp.isDefining() && declaration != null && (declaration.flags & 0x100080L) == 0x100080L)
        {
            comp.error('e', (new StringBuilder()).append("can't assign to method ").append(declaration.getName()).toString(), setexp);
        }
        if (declaration != null && declaration.getFlag(8192L) && CompileReflect.checkKnownClass(declaration.getType(), comp) < 0)
        {
            declaration.setType(Type.errorType);
        }
        return setexp;
    }

    protected volatile Object visitSetExp(SetExp setexp, Object obj)
    {
        return visitSetExp(setexp, (Type)obj);
    }

    protected Expression visitSetExpValue(Expression expression, Type type, Declaration declaration)
    {
        if (declaration == null || declaration.isAlias())
        {
            type = null;
        } else
        {
            type = declaration.type;
        }
        return visit(expression, type);
    }

    protected volatile Expression visitSetExpValue(Expression expression, Object obj, Declaration declaration)
    {
        return visitSetExpValue(expression, (Type)obj, declaration);
    }

    protected Expression visitTryExp(TryExp tryexp, Type type)
    {
        if (tryexp.getCatchClauses() == null && tryexp.getFinallyClause() == null)
        {
            return visit(tryexp.try_clause, type);
        } else
        {
            return (Expression)super.visitTryExp(tryexp, type);
        }
    }

    protected volatile Object visitTryExp(TryExp tryexp, Object obj)
    {
        return visitTryExp(tryexp, (Type)obj);
    }
}
