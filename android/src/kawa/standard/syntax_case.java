// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BlockExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ExitExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LetExp;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.math.IntNum;
import java.util.Vector;
import kawa.lang.Pattern;
import kawa.lang.PatternScope;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.SyntaxPattern;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            syntax_case_work

public class syntax_case extends Syntax
{

    public static final syntax_case syntax_case;
    PrimProcedure call_error;

    public syntax_case()
    {
    }

    public static Object error(String s, Object obj)
    {
        obj = (Translator)Compilation.getCurrent();
        if (obj == null)
        {
            throw new RuntimeException("no match in syntax-case");
        }
        s = ((Translator) (obj)).getCurrentSyntax();
        if (s == null)
        {
            s = "some syntax";
        } else
        {
            s = s.getName();
        }
        return ((Translator) (obj)).syntaxError((new StringBuilder()).append("no matching case while expanding ").append(s).toString());
    }

    Expression rewriteClauses(Object obj, syntax_case_work syntax_case_work1, Translator translator)
    {
        Object obj3;
        Object obj4;
        obj4 = translator.getLanguage();
        if (obj == LList.Empty)
        {
            obj = new QuoteExp("syntax-case");
            syntax_case_work1 = new ReferenceExp(syntax_case_work1.inputExpression);
            if (call_error == null)
            {
                translator = ClassType.make("kawa.standard.syntax_case");
                ClassType classtype = Compilation.javaStringType;
                ClassType classtype1 = Type.objectType;
                ClassType classtype2 = Type.objectType;
                call_error = new PrimProcedure(translator.addMethod("error", new Type[] {
                    classtype, classtype1
                }, classtype2, 9), ((gnu.expr.Language) (obj4)));
            }
            return new ApplyExp(call_error, new Expression[] {
                obj, syntax_case_work1
            });
        }
        obj3 = translator.pushPositionOf(obj);
        Object obj1;
        if (obj instanceof Pair)
        {
            obj1 = ((Pair)obj).getCar();
            if (obj1 instanceof Pair)
            {
                break MISSING_BLOCK_LABEL_170;
            }
        }
        obj = translator.syntaxError("syntax-case:  bad clause list");
        translator.popPositionOf(obj3);
        return ((Expression) (obj));
        PatternScope patternscope;
        Object obj5;
        obj5 = (Pair)obj1;
        patternscope = PatternScope.push(translator);
        patternscope.matchArray = translator.matchArray;
        translator.push(patternscope);
        obj1 = null;
        Object obj2;
        for (obj2 = ((Pair) (obj5)).getCdr(); obj2 instanceof SyntaxForm; obj2 = ((SyntaxForm) (obj1)).getDatum())
        {
            obj1 = (SyntaxForm)obj2;
        }

        if (obj2 instanceof Pair)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        obj = translator.syntaxError("missing syntax-case output expression");
        translator.popPositionOf(obj3);
        return ((Expression) (obj));
        int i;
        int j;
        i = patternscope.pattern_names.size();
        Object obj6 = new SyntaxPattern(((Pair) (obj5)).getCar(), syntax_case_work1.literal_identifiers, translator);
        j = ((SyntaxPattern) (obj6)).varCount();
        if (j > syntax_case_work1.maxVars)
        {
            syntax_case_work1.maxVars = j;
        }
        obj5 = new BlockExp();
        obj6 = new QuoteExp(obj6);
        ReferenceExp referenceexp = new ReferenceExp(syntax_case_work1.inputExpression);
        ReferenceExp referenceexp1 = new ReferenceExp(translator.matchArray);
        QuoteExp quoteexp = new QuoteExp(IntNum.zero());
        obj4 = new ApplyExp(new PrimProcedure(Pattern.matchPatternMethod, ((gnu.expr.Language) (obj4))), new Expression[] {
            obj6, referenceexp, referenceexp1, quoteexp
        });
        i = j - i;
        Expression aexpression[] = new Expression[i];
_L2:
        i--;
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        aexpression[i] = QuoteExp.undefined_exp;
        if (true) goto _L2; else goto _L1
        obj;
        translator.popPositionOf(obj3);
        throw obj;
_L1:
        Pair pair;
        patternscope.inits = aexpression;
        pair = (Pair)obj2;
        if (pair.getCdr() != LList.Empty) goto _L4; else goto _L3
_L3:
        obj1 = translator.rewrite_car(pair, ((SyntaxForm) (obj1)));
_L5:
        patternscope.setBody(((Expression) (obj1)));
        translator.pop(patternscope);
        PatternScope.pop(translator);
        ((BlockExp) (obj5)).setBody(new IfExp(((Expression) (obj4)), patternscope, new ExitExp(((BlockExp) (obj5)))), rewriteClauses(((Pair)obj).getCdr(), syntax_case_work1, translator));
        translator.popPositionOf(obj3);
        return ((Expression) (obj5));
_L4:
        obj2 = translator.rewrite_car(pair, ((SyntaxForm) (obj1)));
        if (pair.getCdr() instanceof Pair)
        {
            pair = (Pair)pair.getCdr();
            if (pair.getCdr() == LList.Empty)
            {
                break MISSING_BLOCK_LABEL_613;
            }
        }
        obj = translator.syntaxError("syntax-case:  bad clause");
        translator.popPositionOf(obj3);
        return ((Expression) (obj));
        obj1 = new IfExp(((Expression) (obj2)), translator.rewrite_car(pair, ((SyntaxForm) (obj1))), new ExitExp(((BlockExp) (obj5))));
          goto _L5
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        syntax_case_work syntax_case_work1 = new syntax_case_work();
        Object obj = pair.getCdr();
        if ((obj instanceof Pair) && (((Pair)obj).getCdr() instanceof Pair))
        {
            pair = new Expression[2];
            LetExp letexp = new LetExp(pair);
            syntax_case_work1.inputExpression = letexp.addDeclaration((String)null);
            Declaration declaration = translator.matchArray;
            Declaration declaration1 = letexp.addDeclaration((String)null);
            declaration1.setType(Compilation.objArrayType);
            declaration1.setCanRead(true);
            translator.matchArray = declaration1;
            syntax_case_work1.inputExpression.setCanRead(true);
            translator.push(letexp);
            obj = (Pair)obj;
            pair[0] = translator.rewrite(((Pair) (obj)).getCar());
            syntax_case_work1.inputExpression.noteValue(pair[0]);
            obj = (Pair)((Pair) (obj)).getCdr();
            syntax_case_work1.literal_identifiers = SyntaxPattern.getLiteralsList(((Pair) (obj)).getCar(), null, translator);
            letexp.body = rewriteClauses(((Pair) (obj)).getCdr(), syntax_case_work1, translator);
            translator.pop(letexp);
            obj = ClassType.make("kawa.lang.SyntaxPattern").getDeclaredMethod("allocVars", 2);
            Expression aexpression[] = new Expression[2];
            aexpression[0] = new QuoteExp(IntNum.make(syntax_case_work1.maxVars));
            if (declaration == null)
            {
                aexpression[1] = QuoteExp.nullExp;
            } else
            {
                aexpression[1] = new ReferenceExp(declaration);
            }
            pair[1] = new ApplyExp(((gnu.bytecode.Method) (obj)), aexpression);
            declaration1.noteValue(pair[1]);
            translator.matchArray = declaration;
            return letexp;
        } else
        {
            return translator.syntaxError("insufficiant arguments to syntax-case");
        }
    }

    static 
    {
        syntax_case = new syntax_case();
        syntax_case.setName("syntax-case");
    }
}
