// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.expr.ThisExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Macro;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class define_syntax extends Syntax
{

    public static final define_syntax define_macro = new define_syntax("%define-macro", false);
    public static final define_syntax define_syntax = new define_syntax("%define-syntax", true);
    static PrimProcedure makeHygienic;
    static PrimProcedure makeNonHygienic;
    static PrimProcedure setCapturedScope;
    static ClassType typeMacro;
    boolean hygienic;

    public define_syntax()
    {
        hygienic = true;
    }

    public define_syntax(Object obj, boolean flag)
    {
        super(obj);
        hygienic = flag;
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return translator.syntaxError("define-syntax not in a body");
    }

    public void scanForm(Pair pair, ScopeExp scopeexp, Translator translator)
    {
        Object obj = null;
        Object obj1;
        for (obj1 = pair.getCdr(); obj1 instanceof SyntaxForm; obj1 = ((SyntaxForm) (obj)).getDatum())
        {
            obj = (SyntaxForm)obj1;
        }

        Object obj2 = obj1;
        Object obj3;
        if (obj2 instanceof Pair)
        {
            obj2 = (Pair)obj2;
            obj1 = ((Pair) (obj2)).getCar();
            obj2 = ((Pair) (obj2)).getCdr();
        } else
        {
            obj1 = null;
        }
        obj3 = obj;
        for (; obj1 instanceof SyntaxForm; obj1 = ((SyntaxForm) (obj3)).getDatum())
        {
            obj3 = (SyntaxForm)obj1;
        }

        Object obj4 = translator.namespaceResolve(obj1);
        if (!(obj4 instanceof Symbol))
        {
            translator.formStack.addElement(translator.syntaxError((new StringBuilder()).append("missing macro name for ").append(Translator.safeCar(pair)).toString()));
        } else
        {
            if (obj2 == null || Translator.safeCdr(obj2) != LList.Empty)
            {
                translator.formStack.addElement(translator.syntaxError((new StringBuilder()).append("invalid syntax for ").append(getName()).toString()));
                return;
            }
            Declaration declaration = translator.define(obj4, ((SyntaxForm) (obj3)), scopeexp);
            declaration.setType(typeMacro);
            translator.push(declaration);
            pair = translator.currentMacroDefinition;
            obj3 = Macro.make(declaration);
            ((Macro) (obj3)).setHygienic(hygienic);
            translator.currentMacroDefinition = ((Macro) (obj3));
            obj = translator.rewrite_car((Pair)obj2, ((SyntaxForm) (obj)));
            translator.currentMacroDefinition = pair;
            obj3.expander = obj;
            if (obj instanceof LambdaExp)
            {
                ((LambdaExp)obj).setFlag(256);
            }
            obj2 = new QuoteExp(obj4);
            obj3 = ThisExp.makeGivingContext(scopeexp);
            if (hygienic)
            {
                pair = makeHygienic;
            } else
            {
                pair = makeNonHygienic;
            }
            pair = new ApplyExp(pair, new Expression[] {
                obj2, obj, obj3
            });
            declaration.noteValue(pair);
            declaration.setProcedureDecl(true);
            if (declaration.context instanceof ModuleExp)
            {
                pair = new SetExp(declaration, pair);
                pair.setDefining(true);
                if (translator.getLanguage().hasSeparateFunctionNamespace())
                {
                    pair.setFuncDef(true);
                }
                translator.formStack.addElement(pair);
                if (translator.immediate)
                {
                    pair = new ReferenceExp(declaration);
                    scopeexp = new QuoteExp(scopeexp);
                    translator.formStack.addElement(new ApplyExp(setCapturedScope, new Expression[] {
                        pair, scopeexp
                    }));
                    return;
                }
            }
        }
    }

    static 
    {
        typeMacro = ClassType.make("kawa.lang.Macro");
        makeHygienic = new PrimProcedure(typeMacro.getDeclaredMethod("make", 3));
        makeNonHygienic = new PrimProcedure(typeMacro.getDeclaredMethod("makeNonHygienic", 3));
        setCapturedScope = new PrimProcedure(typeMacro.getDeclaredMethod("setCapturedScope", 1));
        makeHygienic.setSideEffectFree();
        makeNonHygienic.setSideEffectFree();
    }
}
