// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            object

public class define_class extends Syntax
{

    public static final define_class define_class = new define_class("define-class", false);
    public static final define_class define_simple_class = new define_class("define-simple-class", true);
    boolean isSimple;
    object objectSyntax;

    define_class(String s, boolean flag)
    {
        super(s);
        objectSyntax = object.objectSyntax;
        isSimple = flag;
    }

    define_class(object object1, boolean flag)
    {
        objectSyntax = object1;
        isSimple = flag;
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Object obj = null;
        Object obj1 = pair.getCdr();
        if (obj1 instanceof Pair)
        {
            pair = (Pair)obj1;
            obj = pair.getCar();
            if (!(obj instanceof Declaration))
            {
                return translator.syntaxError((new StringBuilder()).append(getName()).append(" can only be used in <body>").toString());
            }
            obj = (Declaration)obj;
        }
        obj1 = (ClassExp)((Declaration) (obj)).getValue();
        objectSyntax.rewriteClassDef((Object[])(Object[])pair.getCdr(), translator);
        pair = new SetExp(((Declaration) (obj)), ((Expression) (obj1)));
        pair.setDefining(true);
        return pair;
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        Object obj = pair.getCdr();
        SyntaxForm syntaxform = null;
        for (; obj instanceof SyntaxForm; obj = syntaxform.getDatum())
        {
            syntaxform = (SyntaxForm)obj;
        }

        if (!(obj instanceof Pair))
        {
            return super.scanForDefinitions(pair, vector, scopeexp, translator);
        }
        Pair pair1 = (Pair)obj;
        for (obj = pair1.getCar(); obj instanceof SyntaxForm; obj = syntaxform.getDatum())
        {
            syntaxform = (SyntaxForm)obj;
        }

        obj = translator.namespaceResolve(obj);
        if (!(obj instanceof String) && !(obj instanceof Symbol))
        {
            translator.error('e', "missing class name");
            return false;
        }
        Declaration declaration = translator.define(obj, syntaxform, scopeexp);
        if (pair1 instanceof PairWithPosition)
        {
            declaration.setLocation((PairWithPosition)pair1);
        }
        ClassExp classexp = new ClassExp(isSimple);
        declaration.noteValue(classexp);
        declaration.setFlag(0x20004000L);
        int i;
        if (isSimple)
        {
            scopeexp = Compilation.typeClass;
        } else
        {
            scopeexp = Compilation.typeClassType;
        }
        declaration.setType(scopeexp);
        translator.mustCompileHere();
        if (obj instanceof Symbol)
        {
            scopeexp = ((Symbol)obj).getName();
        } else
        {
            scopeexp = obj.toString();
        }
        i = scopeexp.length();
        obj = scopeexp;
        if (i > 2)
        {
            obj = scopeexp;
            if (scopeexp.charAt(0) == '<')
            {
                obj = scopeexp;
                if (scopeexp.charAt(i - 1) == '>')
                {
                    obj = scopeexp.substring(1, i - 1);
                }
            }
        }
        classexp.setName(((String) (obj)));
        for (scopeexp = ((ScopeExp) (pair1.getCdr())); scopeexp instanceof SyntaxForm; scopeexp = ((ScopeExp) (syntaxform.getDatum())))
        {
            syntaxform = (SyntaxForm)scopeexp;
        }

        if (!(scopeexp instanceof Pair))
        {
            translator.error('e', "missing class members");
            return false;
        }
        scopeexp = (Pair)scopeexp;
        obj = translator.currentScope();
        if (syntaxform != null)
        {
            translator.setCurrentScope(syntaxform.getScope());
        }
        Object aobj[] = objectSyntax.scanClassDef(scopeexp, classexp, translator);
        if (syntaxform != null)
        {
            translator.setCurrentScope(((ScopeExp) (obj)));
        }
        if (aobj == null)
        {
            return false;
        } else
        {
            vector.addElement(Translator.makePair(pair, this, Translator.makePair(scopeexp, declaration, ((Object) (aobj)))));
            return true;
        }
    }

}
