// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure1;
import gnu.text.Printable;
import gnu.text.ReportFormat;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package kawa.lang:
//            Translator, SyntaxRule, SyntaxForm, PatternScope, 
//            SyntaxPattern, Macro, Pattern, TemplateScope

public class SyntaxRules extends Procedure1
    implements Printable, Externalizable
{

    Object literal_identifiers[];
    int maxVars;
    SyntaxRule rules[];

    public SyntaxRules()
    {
        maxVars = 0;
    }

    public SyntaxRules(Object aobj[], Object obj, Translator translator)
    {
        SyntaxForm syntaxform;
        int i;
        int j;
        maxVars = 0;
        literal_identifiers = aobj;
        j = Translator.listLength(obj);
        i = j;
        if (j < 0)
        {
            i = 0;
            translator.syntaxError("missing or invalid syntax-rules");
        }
        rules = new SyntaxRule[i];
        syntaxform = null;
        j = 0;
_L5:
        if (j >= i) goto _L2; else goto _L1
_L1:
        Object obj2;
        Pair pair;
        for (; obj instanceof SyntaxForm; obj = syntaxform.getDatum())
        {
            syntaxform = (SyntaxForm)obj;
        }

        pair = (Pair)obj;
        obj = syntaxform;
        for (obj2 = pair.getCar(); obj2 instanceof SyntaxForm; obj2 = ((SyntaxForm) (obj)).getDatum())
        {
            obj = (SyntaxForm)obj2;
        }

        if (obj2 instanceof Pair) goto _L4; else goto _L3
_L3:
        translator.syntaxError((new StringBuilder()).append("missing pattern in ").append(j).append("'th syntax rule").toString());
_L7:
        return;
_L4:
        Object obj1;
        Object obj3;
        String s;
        int k;
        int i1;
        obj1 = obj;
        obj2 = (Pair)obj2;
        obj3 = ((Pair) (obj2)).getCar();
        s = translator.getFileName();
        k = translator.getLineNumber();
        i1 = translator.getColumnNumber();
        translator.setLine(obj2);
        for (obj2 = ((Pair) (obj2)).getCdr(); obj2 instanceof SyntaxForm; obj2 = ((SyntaxForm) (obj)).getDatum())
        {
            obj = (SyntaxForm)obj2;
        }

        if (obj2 instanceof Pair)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        translator.syntaxError((new StringBuilder()).append("missing template in ").append(j).append("'th syntax rule").toString());
        translator.setLine(s, k, i1);
        return;
        obj2 = (Pair)obj2;
        if (((Pair) (obj2)).getCdr() == LList.Empty)
        {
            break MISSING_BLOCK_LABEL_346;
        }
        translator.syntaxError((new StringBuilder()).append("junk after ").append(j).append("'th syntax rule").toString());
        translator.setLine(s, k, i1);
        return;
        Object obj4;
        obj4 = ((Pair) (obj2)).getCar();
        translator.push(PatternScope.push(translator));
        obj2 = obj3;
        while (obj2 instanceof SyntaxForm) 
        {
            obj1 = (SyntaxForm)obj2;
            obj2 = ((SyntaxForm) (obj1)).getDatum();
        }
        StringBuffer stringbuffer = new StringBuffer();
        if (!(obj2 instanceof Pair))
        {
            break MISSING_BLOCK_LABEL_516;
        }
        aobj[0] = ((Pair)obj2).getCar();
        obj2 = (Pair)obj2;
        stringbuffer.append('\f');
        stringbuffer.append('\030');
        obj1 = new SyntaxPattern(stringbuffer, ((Pair) (obj2)).getCdr(), ((SyntaxForm) (obj1)), aobj, translator);
        rules[j] = new SyntaxRule(((SyntaxPattern) (obj1)), obj4, ((SyntaxForm) (obj)), translator);
        PatternScope.pop(translator);
        translator.pop();
        translator.setLine(s, k, i1);
        j++;
        obj = pair.getCdr();
          goto _L5
        translator.syntaxError("pattern does not start with name");
        translator.setLine(s, k, i1);
        return;
        aobj;
        translator.setLine(s, k, i1);
        throw aobj;
_L2:
        i = rules.length;
_L8:
        j = i - 1;
        if (j < 0) goto _L7; else goto _L6
_L6:
        int l = rules[j].patternNesting.length();
        i = j;
        if (l > maxVars)
        {
            maxVars = l;
            i = j;
        }
          goto _L8
    }

    public SyntaxRules(Object aobj[], SyntaxRule asyntaxrule[], int i)
    {
        maxVars = 0;
        literal_identifiers = aobj;
        rules = asyntaxrule;
        maxVars = i;
    }

    public Object apply1(Object obj)
    {
        gnu.expr.ScopeExp scopeexp;
        Object obj1;
        if (!(obj instanceof SyntaxForm))
        {
            break MISSING_BLOCK_LABEL_56;
        }
        obj1 = (SyntaxForm)obj;
        obj = (Translator)Compilation.getCurrent();
        scopeexp = ((Translator) (obj)).currentScope();
        ((Translator) (obj)).setCurrentScope(((SyntaxForm) (obj1)).getScope());
        obj1 = expand(obj1, ((Translator) (obj)));
        ((Translator) (obj)).setCurrentScope(scopeexp);
        return obj1;
        Exception exception;
        exception;
        ((Translator) (obj)).setCurrentScope(scopeexp);
        throw exception;
        return expand(obj, (Translator)Compilation.getCurrent());
    }

    public Object expand(Object obj, Translator translator)
    {
        Object aobj[] = new Object[maxVars];
        Macro macro = (Macro)translator.getCurrentSyntax();
        for (int i = 0; i < rules.length; i++)
        {
            SyntaxRule syntaxrule = rules[i];
            if (syntaxrule == null)
            {
                return new ErrorExp((new StringBuilder()).append("error defining ").append(macro).toString());
            }
            if (syntaxrule.pattern.match(obj, aobj, 0))
            {
                return syntaxrule.execute(aobj, translator, TemplateScope.make(translator));
            }
        }

        return translator.syntaxError((new StringBuilder()).append("no matching syntax-rule for ").append(literal_identifiers[0]).toString());
    }

    public void print(Consumer consumer)
    {
        consumer.write("#<macro ");
        ReportFormat.print(literal_identifiers[0], consumer);
        consumer.write(62);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        literal_identifiers = (Object[])(Object[])objectinput.readObject();
        rules = (SyntaxRule[])(SyntaxRule[])objectinput.readObject();
        maxVars = objectinput.readInt();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(((Object) (literal_identifiers)));
        objectoutput.writeObject(rules);
        objectoutput.writeInt(maxVars);
    }
}
