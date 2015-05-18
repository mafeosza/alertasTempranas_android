// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.BeginExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.ScopeExp;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.text.Options;
import java.util.Stack;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class with_compile_options extends Syntax
{

    public static final with_compile_options with_compile_options;

    public with_compile_options()
    {
    }

    public static Object getOptions(Object obj, Stack stack, Syntax syntax, Translator translator)
    {
        Object obj1;
        Options options;
        boolean flag;
        flag = false;
        options = translator.currentOptions;
        Object obj2 = null;
        obj1 = obj;
        obj = obj2;
_L10:
        for (; obj1 instanceof SyntaxForm; obj1 = ((SyntaxForm) (obj)).getDatum())
        {
            obj = (SyntaxForm)obj1;
        }

        if (obj1 instanceof Pair) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            translator.error('e', (new StringBuilder()).append("no option keyword in ").append(syntax.getName()).toString());
        }
        return Translator.wrapSyntax(obj1, ((SyntaxForm) (obj)));
_L2:
        Object obj3;
        Object obj4;
        obj3 = (Pair)obj1;
        obj4 = Translator.stripSyntax(((Pair) (obj3)).getCar());
        if (!(obj4 instanceof Keyword)) goto _L1; else goto _L3
_L3:
        Object obj5;
        String s;
        s = ((Keyword)obj4).getName();
        flag = true;
        obj5 = translator.pushPositionOf(obj3);
        obj3 = ((Pair) (obj3)).getCdr();
        obj1 = obj;
        for (; obj3 instanceof SyntaxForm; obj3 = ((SyntaxForm) (obj1)).getDatum())
        {
            obj1 = (SyntaxForm)obj3;
        }

        if (obj3 instanceof Pair)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        translator.error('e', (new StringBuilder()).append("keyword ").append(s).append(" not followed by value").toString());
        obj = LList.Empty;
        translator.popPositionOf(obj5);
        return obj;
        Object obj6;
        obj = (Pair)obj3;
        obj4 = Translator.stripSyntax(((Pair) (obj)).getCar());
        obj3 = ((Pair) (obj)).getCdr();
        obj6 = options.getLocal(s);
        if (options.getInfo(s) != null)
        {
            break MISSING_BLOCK_LABEL_307;
        }
        translator.error('w', (new StringBuilder()).append("unknown compile option: ").append(s).toString());
        translator.popPositionOf(obj5);
        obj = obj1;
        obj1 = obj3;
        continue; /* Loop/switch isn't completed */
        if (!(obj4 instanceof FString)) goto _L5; else goto _L4
_L4:
        obj = obj4.toString();
_L7:
        options.set(s, obj, translator.getMessages());
        if (stack == null)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        stack.push(s);
        stack.push(obj6);
        stack.push(obj);
        translator.popPositionOf(obj5);
        obj = obj1;
        obj1 = obj3;
        continue; /* Loop/switch isn't completed */
_L5:
        obj = obj4;
        if (obj4 instanceof Boolean) goto _L7; else goto _L6
_L6:
        obj = obj4;
        if (obj4 instanceof Number) goto _L7; else goto _L8
_L8:
        obj = null;
        translator.error('e', (new StringBuilder()).append("invalid literal value for key ").append(s).toString());
          goto _L7
        obj;
        translator.popPositionOf(obj5);
        throw obj;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Object obj = pair.getCdr();
        if (!(obj instanceof Pair)) goto _L2; else goto _L1
_L1:
        Pair pair1 = (Pair)obj;
        if (!(pair1.getCar() instanceof Stack)) goto _L2; else goto _L3
_L3:
        pair = (Stack)pair1.getCar();
        obj = pair1.getCdr();
        translator.currentOptions.pushOptionValues(pair);
_L8:
        obj = translator.rewrite_body(obj);
        if (!(obj instanceof BeginExp)) goto _L5; else goto _L4
_L4:
        obj = (BeginExp)obj;
_L6:
        ((BeginExp) (obj)).setCompileOptions(pair);
        translator.currentOptions.popOptionValues(pair);
        return ((Expression) (obj));
_L2:
        pair = new Stack();
        obj = getOptions(obj, pair, this, translator);
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new BeginExp(new Expression[] {
            obj
        });
          goto _L6
        Exception exception;
        exception;
        translator.currentOptions.popOptionValues(pair);
        throw exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void scanForm(Pair pair, ScopeExp scopeexp, Translator translator)
    {
        Stack stack = new Stack();
        Object obj = getOptions(pair.getCdr(), stack, this, translator);
        if (obj == LList.Empty)
        {
            return;
        }
        if (obj == pair.getCdr())
        {
            translator.scanBody(obj, scopeexp, false);
            return;
        } else
        {
            scopeexp = new Pair(stack, translator.scanBody(obj, scopeexp, true));
            translator.currentOptions.popOptionValues(stack);
            translator.formStack.add(Translator.makePair(pair, pair.getCar(), scopeexp));
            return;
        }
    }

    static 
    {
        with_compile_options = new with_compile_options();
        with_compile_options.setName("with-compile-options");
    }
}
