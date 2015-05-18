// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.KeyPair;
import gnu.mapping.Symbol;
import gnu.text.SourceLocator;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

// Referenced classes of package gnu.expr:
//            ExpExpVisitor, LambdaExp, Expression, Compilation, 
//            Language, ModuleExp, Declaration, ScopeExp, 
//            ClassExp, ReferenceExp, FluidLetExp, ApplyExp, 
//            QuoteExp, PrimProcedure, LetExp, BeginExp, 
//            SetExp, ThisExp

public class FindCapturedVars extends ExpExpVisitor
{

    int backJumpPossible;
    ModuleExp currentModule;
    Hashtable unknownDecls;

    public FindCapturedVars()
    {
        backJumpPossible = 0;
        unknownDecls = null;
        currentModule = null;
    }

    static Expression checkInlineable(LambdaExp lambdaexp, Set set)
    {
        Object obj1;
label0:
        {
            if (lambdaexp.returnContinuation == LambdaExp.unknownContinuation)
            {
                return lambdaexp.returnContinuation;
            }
            if (set.contains(lambdaexp))
            {
                return lambdaexp.returnContinuation;
            }
            if (lambdaexp.getCanRead() || lambdaexp.isClassMethod() || lambdaexp.min_args != lambdaexp.max_args)
            {
                lambdaexp.returnContinuation = LambdaExp.unknownContinuation;
                return LambdaExp.unknownContinuation;
            }
            set.add(lambdaexp);
            Object obj = lambdaexp.returnContinuation;
            obj1 = obj;
            if (lambdaexp.tailCallers == null)
            {
                break label0;
            }
            Iterator iterator = lambdaexp.tailCallers.iterator();
label1:
            do
            {
                do
                {
                    obj1 = obj;
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    LambdaExp lambdaexp1 = (LambdaExp)iterator.next();
                    obj1 = checkInlineable(lambdaexp1, set);
                    if (obj1 == LambdaExp.unknownContinuation)
                    {
                        if (obj == null || obj == lambdaexp1.body)
                        {
                            obj = lambdaexp1.body;
                            lambdaexp.inlineHome = lambdaexp1;
                        } else
                        {
                            lambdaexp.returnContinuation = LambdaExp.unknownContinuation;
                            return ((Expression) (obj1));
                        }
                    } else
                    {
                        if (obj != null)
                        {
                            continue label1;
                        }
                        obj = obj1;
                        if (lambdaexp.inlineHome == null)
                        {
                            if (lambdaexp.nestedIn(lambdaexp1))
                            {
                                obj = lambdaexp1;
                            } else
                            {
                                obj = lambdaexp1.inlineHome;
                            }
                            lambdaexp.inlineHome = ((LambdaExp) (obj));
                            obj = obj1;
                        }
                    }
                } while (true);
            } while ((obj1 == null || obj == obj1) && !lambdaexp.getFlag(32));
            lambdaexp.returnContinuation = LambdaExp.unknownContinuation;
            return LambdaExp.unknownContinuation;
        }
        return ((Expression) (obj1));
    }

    public static void findCapturedVars(Expression expression, Compilation compilation)
    {
        FindCapturedVars findcapturedvars = new FindCapturedVars();
        findcapturedvars.setContext(compilation);
        expression.visit(findcapturedvars, null);
    }

    Declaration allocUnboundDecl(Object obj, boolean flag)
    {
        Object obj1 = obj;
        Object obj2 = obj1;
        boolean flag1 = flag;
        if (flag)
        {
            obj2 = obj1;
            flag1 = flag;
            Declaration declaration;
            if (obj instanceof Symbol)
            {
                if (!getCompilation().getLanguage().hasSeparateFunctionNamespace())
                {
                    flag1 = false;
                    obj2 = obj1;
                } else
                {
                    obj2 = new KeyPair((Symbol)obj, EnvironmentKey.FUNCTION);
                    flag1 = flag;
                }
            }
        }
        if (unknownDecls == null)
        {
            unknownDecls = new Hashtable(100);
            obj1 = null;
        } else
        {
            obj1 = (Declaration)unknownDecls.get(obj2);
        }
        declaration = ((Declaration) (obj1));
        if (obj1 == null)
        {
            declaration = currentModule.addDeclaration(obj);
            declaration.setSimple(false);
            declaration.setPrivate(true);
            if (flag1)
            {
                declaration.setProcedureDecl(true);
            }
            if (currentModule.isStatic())
            {
                declaration.setFlag(2048L);
            }
            declaration.setCanRead(true);
            declaration.setCanWrite(true);
            declaration.setFlag(0x50000L);
            declaration.setIndirectBinding(true);
            unknownDecls.put(obj2, declaration);
        }
        return declaration;
    }

    public void capture(Declaration declaration)
    {
_L2:
        return;
        if (!declaration.getCanRead() && !declaration.getCanCall() || declaration.field != null && declaration.field.getStaticFlag() || comp.immediate && declaration.hasConstantValue()) goto _L2; else goto _L1
_L1:
        LambdaExp lambdaexp;
        LambdaExp lambdaexp5;
        lambdaexp = getCurrentLambda();
        Object obj = declaration.getContext();
        if (obj == null)
        {
            throw new Error((new StringBuilder()).append("null context for ").append(declaration).append(" curL:").append(lambdaexp).toString());
        }
        lambdaexp5 = ((ScopeExp) (obj)).currentLambda();
        LambdaExp lambdaexp3 = null;
        obj = null;
        while (lambdaexp != lambdaexp5 && lambdaexp.getInlineOnly()) 
        {
            LambdaExp lambdaexp4 = lambdaexp.outerLambda();
            LambdaExp lambdaexp1 = lambdaexp3;
            if (lambdaexp4 != lambdaexp3)
            {
                obj = lambdaexp4.firstChild;
                lambdaexp1 = lambdaexp4;
            }
            if (obj == null || lambdaexp.inlineHome == null)
            {
                lambdaexp.setCanCall(false);
                return;
            }
            lambdaexp = lambdaexp.getCaller();
            obj = ((LambdaExp) (obj)).nextSibling;
            lambdaexp3 = lambdaexp1;
        }
        if (!comp.usingCPStyle()) goto _L4; else goto _L3
_L3:
        if (lambdaexp instanceof ModuleExp) goto _L2; else goto _L5
_L5:
        Object obj1 = declaration.getValue();
        if (obj1 != null && (obj1 instanceof LambdaExp)) goto _L7; else goto _L6
_L6:
        obj1 = null;
_L11:
        if (!declaration.getFlag(0x10000L)) goto _L9; else goto _L8
_L8:
        LambdaExp lambdaexp2 = lambdaexp;
_L12:
        if (lambdaexp2 != lambdaexp5)
        {
label0:
            {
                if (lambdaexp2.nameDecl == null || !lambdaexp2.nameDecl.getFlag(2048L))
                {
                    break label0;
                }
                declaration.setFlag(2048L);
            }
        }
_L9:
        if (declaration.base != null)
        {
            declaration.base.setCanRead(true);
            capture(declaration.base);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (lambdaexp == lambdaexp5)
        {
            return;
        }
          goto _L5
_L7:
        lambdaexp2 = (LambdaExp)obj1;
        if (lambdaexp2.getInlineOnly()) goto _L2; else goto _L10
_L10:
        if (lambdaexp2.isHandlingTailCalls())
        {
            obj1 = null;
        } else
        {
            obj1 = lambdaexp2;
            if (lambdaexp2 == lambdaexp)
            {
                obj1 = lambdaexp2;
                if (!declaration.getCanRead())
                {
                    return;
                }
            }
        }
          goto _L11
        lambdaexp2 = lambdaexp2.outerLambda();
          goto _L12
        if (!declaration.getCanRead() && !declaration.getCanCall() && obj1 != null) goto _L2; else goto _L13
_L13:
        if (declaration.isStatic()) goto _L15; else goto _L14
_L14:
        if (!declaration.isFluid())
        {
            lambdaexp.setImportsLexVars();
        }
        lambdaexp2 = lambdaexp.outerLambda();
_L18:
        if (lambdaexp2 != lambdaexp5 && lambdaexp2 != null && (declaration.getCanRead() || obj1 != lambdaexp2)) goto _L16; else goto _L15
_L15:
        if (lambdaexp5 == null)
        {
            System.err.println((new StringBuilder()).append("null declLambda for ").append(declaration).append(" curL:").append(lambdaexp).toString());
            for (ScopeExp scopeexp = declaration.context; scopeexp != null; scopeexp = scopeexp.outer)
            {
                System.err.println((new StringBuilder()).append("- context:").append(scopeexp).toString());
            }

        }
        break; /* Loop/switch isn't completed */
_L16:
        Declaration declaration1 = lambdaexp2.nameDecl;
        if (declaration1 != null && declaration1.getFlag(2048L))
        {
            comp.error('e', (new StringBuilder()).append("static ").append(lambdaexp2.getName()).append(" references non-static ").append(declaration.getName()).toString());
        }
        if ((lambdaexp2 instanceof ClassExp) && lambdaexp2.getName() != null && ((ClassExp)lambdaexp2).isSimple())
        {
            comp.error('w', lambdaexp2.nameDecl, "simple class ", (new StringBuilder()).append(" requiring lexical link (because of reference to ").append(declaration.getName()).append(") - use define-class instead").toString());
        }
        lambdaexp2.setNeedsStaticLink();
        lambdaexp2 = lambdaexp2.outerLambda();
        if (true) goto _L18; else goto _L17
_L17:
        lambdaexp5.capture(declaration);
        return;
    }

    void capture(Declaration declaration, Declaration declaration1)
    {
        Declaration declaration2;
label0:
        {
            declaration2 = declaration1;
            if (!declaration1.isAlias())
            {
                break label0;
            }
            declaration2 = declaration1;
            if (!(declaration1.value instanceof ReferenceExp))
            {
                break label0;
            }
            ReferenceExp referenceexp = (ReferenceExp)declaration1.value;
            Declaration declaration3 = referenceexp.binding;
            declaration2 = declaration1;
            if (declaration3 == null)
            {
                break label0;
            }
            if (declaration != null)
            {
                declaration2 = declaration1;
                if (declaration3.needsContext())
                {
                    break label0;
                }
            }
            capture(referenceexp.contextDecl(), declaration3);
            return;
        }
        for (; declaration2.isFluid() && (declaration2.context instanceof FluidLetExp); declaration2 = declaration2.base) { }
        if (declaration != null && declaration2.needsContext())
        {
            capture(declaration);
            return;
        } else
        {
            capture(declaration2);
            return;
        }
    }

    void maybeWarnNoDeclarationSeen(Object obj, Compilation compilation, SourceLocator sourcelocator)
    {
        if (compilation.warnUndefinedVariable())
        {
            compilation.error('w', (new StringBuilder()).append("no declaration seen for ").append(obj).toString(), sourcelocator);
        }
    }

    protected Expression visitApplyExp(ApplyExp applyexp, Void void1)
    {
        boolean flag1;
        boolean flag2;
        int j;
        j = backJumpPossible;
        flag2 = false;
        flag1 = false;
        if (!(applyexp.func instanceof ReferenceExp) || Compilation.defaultCallConvention > 1) goto _L2; else goto _L1
_L1:
        int i;
        boolean flag;
        Object obj = Declaration.followAliases(((ReferenceExp)applyexp.func).binding);
        flag = flag1;
        i = ((flag2) ? 1 : 0);
        if (obj != null)
        {
            flag = flag1;
            i = ((flag2) ? 1 : 0);
            if (((Declaration) (obj)).context instanceof ModuleExp)
            {
                flag = flag1;
                i = ((flag2) ? 1 : 0);
                if (!((Declaration) (obj)).isPublic())
                {
                    flag = flag1;
                    i = ((flag2) ? 1 : 0);
                    if (!((Declaration) (obj)).getFlag(4096L))
                    {
                        obj = ((Declaration) (obj)).getValue();
                        flag = flag1;
                        i = ((flag2) ? 1 : 0);
                        if (obj instanceof LambdaExp)
                        {
                            flag = flag1;
                            i = ((flag2) ? 1 : 0);
                            if (!((LambdaExp)obj).getNeedsClosureEnv())
                            {
                                i = 1;
                                flag = flag1;
                            }
                        }
                    }
                }
            }
        }
_L4:
        if (i == 0)
        {
            applyexp.func = (Expression)applyexp.func.visit(this, void1);
        }
        if (exitValue == null && !flag)
        {
            applyexp.args = visitExps(applyexp.args, void1);
        }
        if (backJumpPossible > j)
        {
            applyexp.setFlag(8);
        }
        return applyexp;
_L2:
        flag = flag1;
        i = ((flag2) ? 1 : 0);
        if (applyexp.func instanceof QuoteExp)
        {
            flag = flag1;
            i = ((flag2) ? 1 : 0);
            if (applyexp.getArgCount() > 0)
            {
                Object obj2 = ((QuoteExp)applyexp.func).getValue();
                Object obj1 = applyexp.getArg(0);
                flag = flag1;
                i = ((flag2) ? 1 : 0);
                if (obj2 instanceof PrimProcedure)
                {
                    flag = flag1;
                    i = ((flag2) ? 1 : 0);
                    if (obj1 instanceof ReferenceExp)
                    {
                        obj2 = (PrimProcedure)obj2;
                        obj1 = Declaration.followAliases(((ReferenceExp)obj1).binding);
                        flag = flag1;
                        i = ((flag2) ? 1 : 0);
                        if (obj1 != null)
                        {
                            flag = flag1;
                            i = ((flag2) ? 1 : 0);
                            if (((Declaration) (obj1)).context instanceof ModuleExp)
                            {
                                flag = flag1;
                                i = ((flag2) ? 1 : 0);
                                if (!((Declaration) (obj1)).getFlag(4096L))
                                {
                                    Expression expression = ((Declaration) (obj1)).getValue();
                                    flag = flag1;
                                    i = ((flag2) ? 1 : 0);
                                    if (expression instanceof ClassExp)
                                    {
                                        Expression aexpression[] = applyexp.getArgs();
                                        flag = flag1;
                                        i = ((flag2) ? 1 : 0);
                                        if (!((LambdaExp)expression).getNeedsClosureEnv())
                                        {
                                            applyexp.nextCall = ((Declaration) (obj1)).firstCall;
                                            obj1.firstCall = applyexp;
                                            for (i = 1; i < aexpression.length; i++)
                                            {
                                                aexpression[i].visit(this, void1);
                                            }

                                            flag = true;
                                            i = 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile Object visitApplyExp(ApplyExp applyexp, Object obj)
    {
        return visitApplyExp(applyexp, (Void)obj);
    }

    protected Expression visitClassExp(ClassExp classexp, Void void1)
    {
        Expression expression = (Expression)super.visitClassExp(classexp, void1);
        if (classexp.explicitInit || classexp.instanceType.isInterface()) goto _L2; else goto _L1
_L1:
        Compilation.getConstructor(classexp.instanceType, classexp);
_L4:
        if (classexp.isSimple() && classexp.getNeedsClosureEnv() && classexp.nameDecl != null && classexp.nameDecl.getType() == Compilation.typeClass)
        {
            classexp.nameDecl.setType(Compilation.typeClassType);
        }
        return expression;
_L2:
        if (classexp.getNeedsClosureEnv())
        {
            void1 = classexp.firstChild;
            while (void1 != null) 
            {
                if ("*init*".equals(void1.getName()))
                {
                    void1.setNeedsStaticLink(true);
                }
                void1 = ((LambdaExp) (void1)).nextSibling;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected volatile Object visitClassExp(ClassExp classexp, Object obj)
    {
        return visitClassExp(classexp, (Void)obj);
    }

    public volatile void visitDefaultArgs(LambdaExp lambdaexp, Object obj)
    {
        visitDefaultArgs(lambdaexp, (Void)obj);
    }

    public void visitDefaultArgs(LambdaExp lambdaexp, Void void1)
    {
        if (lambdaexp.defaultArgs != null)
        {
            super.visitDefaultArgs(lambdaexp, void1);
            void1 = lambdaexp.firstDecl();
            while (void1 != null) 
            {
                if (!void1.isSimple())
                {
                    lambdaexp.setFlag(true, 512);
                    return;
                }
                void1 = void1.nextDecl();
            }
        }
    }

    protected Expression visitFluidLetExp(FluidLetExp fluidletexp, Void void1)
    {
        for (Declaration declaration = fluidletexp.firstDecl(); declaration != null; declaration = declaration.nextDecl())
        {
            if (declaration.base == null)
            {
                Object obj = declaration.getSymbol();
                Declaration declaration1 = allocUnboundDecl(obj, false);
                maybeWarnNoDeclarationSeen(obj, comp, fluidletexp);
                capture(declaration1);
                declaration.base = declaration1;
            }
        }

        return (Expression)super.visitLetExp(fluidletexp, void1);
    }

    protected volatile Object visitFluidLetExp(FluidLetExp fluidletexp, Object obj)
    {
        return visitFluidLetExp(fluidletexp, (Void)obj);
    }

    protected Expression visitLambdaExp(LambdaExp lambdaexp, Void void1)
    {
        if (checkInlineable(lambdaexp, new LinkedHashSet()) != LambdaExp.unknownContinuation && (!(lambdaexp.outer instanceof ModuleExp) || lambdaexp.nameDecl == null))
        {
            lambdaexp.setInlineOnly(true);
            backJumpPossible = backJumpPossible + 1;
        }
        return (Expression)super.visitLambdaExp(lambdaexp, void1);
    }

    protected volatile Object visitLambdaExp(LambdaExp lambdaexp, Object obj)
    {
        return visitLambdaExp(lambdaexp, (Void)obj);
    }

    protected Expression visitLetExp(LetExp letexp, Void void1)
    {
        if (letexp.body instanceof BeginExp)
        {
            Expression aexpression[] = letexp.inits;
            int l = aexpression.length;
            Expression aexpression1[] = ((BeginExp)letexp.body).exps;
            int j = 0;
            Object obj = letexp.firstDecl();
            int k;
            for (int i = 0; i < aexpression1.length && j < l; j = k)
            {
                Object obj2 = aexpression1[i];
                Object obj1 = obj;
                k = j;
                if (obj2 instanceof SetExp)
                {
                    obj2 = (SetExp)obj2;
                    obj1 = obj;
                    k = j;
                    if (((SetExp) (obj2)).binding == obj)
                    {
                        obj1 = obj;
                        k = j;
                        if (aexpression[j] == QuoteExp.nullExp)
                        {
                            obj1 = obj;
                            k = j;
                            if (((SetExp) (obj2)).isDefining())
                            {
                                obj1 = ((SetExp) (obj2)).new_value;
                                if (((obj1 instanceof QuoteExp) || (obj1 instanceof LambdaExp)) && ((Declaration) (obj)).getValue() == obj1)
                                {
                                    aexpression[j] = ((Expression) (obj1));
                                    aexpression1[i] = QuoteExp.voidExp;
                                }
                                k = j + 1;
                                obj1 = ((Declaration) (obj)).nextDecl();
                            }
                        }
                    }
                }
                i++;
                obj = obj1;
            }

        }
        return (Expression)super.visitLetExp(letexp, void1);
    }

    protected volatile Object visitLetExp(LetExp letexp, Object obj)
    {
        return visitLetExp(letexp, (Void)obj);
    }

    protected Expression visitModuleExp(ModuleExp moduleexp, Void void1)
    {
        ModuleExp moduleexp1;
        Hashtable hashtable;
        moduleexp1 = currentModule;
        hashtable = unknownDecls;
        currentModule = moduleexp;
        unknownDecls = null;
        moduleexp = visitLambdaExp(moduleexp, void1);
        currentModule = moduleexp1;
        unknownDecls = hashtable;
        return moduleexp;
        moduleexp;
        currentModule = moduleexp1;
        unknownDecls = hashtable;
        throw moduleexp;
    }

    protected volatile Object visitModuleExp(ModuleExp moduleexp, Object obj)
    {
        return visitModuleExp(moduleexp, (Void)obj);
    }

    protected Expression visitReferenceExp(ReferenceExp referenceexp, Void void1)
    {
        Declaration declaration = referenceexp.getBinding();
        void1 = declaration;
        if (declaration == null)
        {
            void1 = allocUnboundDecl(referenceexp.getSymbol(), referenceexp.isProcedureName());
            referenceexp.setBinding(void1);
        }
        if (void1.getFlag(0x10000L) && comp.resolve(referenceexp.getSymbol(), referenceexp.isProcedureName()) == null)
        {
            maybeWarnNoDeclarationSeen(referenceexp.getSymbol(), comp, referenceexp);
        }
        capture(referenceexp.contextDecl(), void1);
        return referenceexp;
    }

    protected volatile Object visitReferenceExp(ReferenceExp referenceexp, Object obj)
    {
        return visitReferenceExp(referenceexp, (Void)obj);
    }

    protected Expression visitSetExp(SetExp setexp, Void void1)
    {
        Declaration declaration1 = setexp.binding;
        Declaration declaration = declaration1;
        if (declaration1 == null)
        {
            declaration = allocUnboundDecl(setexp.getSymbol(), setexp.isFuncDef());
            setexp.binding = declaration;
        }
        if (!declaration.ignorable())
        {
            Declaration declaration2 = declaration;
            if (!setexp.isDefining())
            {
                declaration2 = Declaration.followAliases(declaration);
            }
            capture(setexp.contextDecl(), declaration2);
        }
        return (Expression)super.visitSetExp(setexp, void1);
    }

    protected volatile Object visitSetExp(SetExp setexp, Object obj)
    {
        return visitSetExp(setexp, (Void)obj);
    }

    protected Expression visitThisExp(ThisExp thisexp, Void void1)
    {
        if (thisexp.isForContext())
        {
            getCurrentLambda().setImportsLexVars();
            return thisexp;
        } else
        {
            return visitReferenceExp(thisexp, void1);
        }
    }

    protected volatile Object visitThisExp(ThisExp thisexp, Object obj)
    {
        return visitThisExp(thisexp, (Void)obj);
    }
}
