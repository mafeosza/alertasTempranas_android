// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Procedure;
import gnu.text.Printable;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package kawa.lang:
//            Syntax, Quote, Translator

public class Macro extends Syntax
    implements Printable, Externalizable
{

    private ScopeExp capturedScope;
    public Object expander;
    private boolean hygienic;
    Object instance;

    public Macro()
    {
        hygienic = true;
    }

    public Macro(Object obj)
    {
        super(obj);
        hygienic = true;
    }

    public Macro(Object obj, Procedure procedure)
    {
        super(obj);
        hygienic = true;
        expander = new QuoteExp(procedure);
    }

    public Macro(Macro macro)
    {
        hygienic = true;
        name = macro.name;
        expander = macro.expander;
        hygienic = macro.hygienic;
    }

    public static Macro make(Declaration declaration)
    {
        Macro macro = new Macro(declaration.getSymbol());
        declaration.setSyntax();
        macro.capturedScope = declaration.context;
        return macro;
    }

    public static Macro make(Object obj, Procedure procedure)
    {
        return new Macro(obj, procedure);
    }

    public static Macro make(Object obj, Procedure procedure, Object obj1)
    {
        obj = new Macro(obj, procedure);
        obj.instance = obj1;
        return ((Macro) (obj));
    }

    public static Macro makeNonHygienic(Object obj, Procedure procedure)
    {
        obj = new Macro(obj, procedure);
        obj.hygienic = false;
        return ((Macro) (obj));
    }

    public static Macro makeNonHygienic(Object obj, Procedure procedure, Object obj1)
    {
        obj = new Macro(obj, procedure);
        obj.hygienic = false;
        obj.instance = obj1;
        return ((Macro) (obj));
    }

    public Object expand(Object obj, Translator translator)
    {
        Object obj2 = expander;
        if (!(obj2 instanceof Procedure) || (obj2 instanceof Expression)) goto _L2; else goto _L1
_L1:
        Object obj1 = (Procedure)obj2;
_L6:
        if (hygienic) goto _L4; else goto _L3
_L3:
        int j;
        obj = Quote.quote(obj, translator);
        j = Translator.listLength(obj);
        Macro macro;
        if (j <= 0)
        {
            try
            {
                return translator.syntaxError((new StringBuilder()).append("invalid macro argument list to ").append(this).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return translator.syntaxError((new StringBuilder()).append("evaluating syntax transformer '").append(getName()).append("' threw ").append(obj).toString());
            }
        }
          goto _L5
_L2:
        obj1 = obj2;
        if (obj2 instanceof Expression)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        macro = translator.currentMacroDefinition;
        translator.currentMacroDefinition = this;
        obj1 = translator.rewrite(obj2);
        expander = obj1;
        translator.currentMacroDefinition = macro;
        obj1 = (Procedure)((Expression)obj1).eval(translator.getGlobalEnvironment());
          goto _L6
        obj;
        translator.currentMacroDefinition = macro;
        throw obj;
_L5:
        Object aobj[] = new Object[j - 1];
        int i = 0;
_L8:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Pair)obj;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        aobj[i - 1] = ((Pair) (obj)).getCar();
        obj = ((Pair) (obj)).getCdr();
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        obj1 = ((Procedure) (obj1)).applyN(aobj);
_L10:
        if ((obj instanceof PairWithPosition) && (obj1 instanceof Pair) && !(obj1 instanceof PairWithPosition))
        {
            obj1 = (Pair)obj1;
            return new PairWithPosition((PairWithPosition)obj, ((Pair) (obj1)).getCar(), ((Pair) (obj1)).getCdr());
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj1 = ((Procedure) (obj1)).apply1(obj);
        if (true) goto _L10; else goto _L9
_L9:
        return obj1;
    }

    public ScopeExp getCapturedScope()
    {
        if (capturedScope != null) goto _L2; else goto _L1
_L1:
        if (!(instance instanceof ModuleExp)) goto _L4; else goto _L3
_L3:
        capturedScope = (ModuleExp)instance;
_L2:
        return capturedScope;
_L4:
        if (instance != null)
        {
            capturedScope = ModuleInfo.findFromInstance(instance).getModuleExp();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public final boolean isHygienic()
    {
        return hygienic;
    }

    public void print(Consumer consumer)
    {
        consumer.write("#<macro ");
        consumer.write(getName());
        consumer.write(62);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        setName((String)objectinput.readObject());
        expander = new QuoteExp(objectinput.readObject());
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return translator.rewrite(expand(pair, translator));
    }

    public Expression rewriteForm(Object obj, Translator translator)
    {
        return translator.rewrite(expand(obj, translator));
    }

    public void scanForm(Pair pair, ScopeExp scopeexp, Translator translator)
    {
        String s;
        Syntax syntax;
        int i;
        int j;
        s = translator.getFileName();
        i = translator.getLineNumber();
        j = translator.getColumnNumber();
        syntax = translator.currentSyntax;
        translator.setLine(pair);
        translator.currentSyntax = this;
        translator.scanForm(expand(pair, translator), scopeexp);
        translator.setLine(s, i, j);
        translator.currentSyntax = syntax;
        return;
        pair;
        translator.setLine(s, i, j);
        translator.currentSyntax = syntax;
        throw pair;
    }

    public void setCapturedScope(ScopeExp scopeexp)
    {
        capturedScope = scopeexp;
    }

    public final void setHygienic(boolean flag)
    {
        hygienic = flag;
    }

    public String toString()
    {
        return (new StringBuilder()).append("#<macro ").append(getName()).append('>').toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(getName());
        objectoutput.writeObject(((QuoteExp)expander).getValue());
    }
}
