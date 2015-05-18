// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

// Referenced classes of package gnu.kawa.lispexpr:
//            ClassNamespace

public class DefineNamespace extends Syntax
{

    public static final String XML_NAMESPACE_MAGIC = "&xml&";
    public static final DefineNamespace define_namespace;
    public static final DefineNamespace define_private_namespace;
    public static final DefineNamespace define_xml_namespace;
    private boolean makePrivate;
    private boolean makeXML;

    public DefineNamespace()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return translator.syntaxError("define-namespace is only allowed in a <body>");
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        Pair pair1;
        Pair pair2;
label0:
        {
            if (pair.getCdr() instanceof Pair)
            {
                pair1 = (Pair)pair.getCdr();
                if ((pair1.getCar() instanceof Symbol) && (pair1.getCdr() instanceof Pair))
                {
                    pair2 = (Pair)pair1.getCdr();
                    if (pair2.getCdr() == LList.Empty)
                    {
                        break label0;
                    }
                }
            }
            translator.error('e', "invalid syntax for define-namespace");
            return false;
        }
        pair = (Symbol)pair1.getCar();
        Declaration declaration = scopeexp.getDefine(pair, 'w', translator);
        translator.push(declaration);
        declaration.setFlag(0x244000L);
        if (makePrivate)
        {
            declaration.setFlag(0x1000000L);
            declaration.setPrivate(true);
        } else
        if (scopeexp instanceof ModuleExp)
        {
            declaration.setCanRead(true);
        }
        Translator.setLine(declaration, pair1);
        if (pair2.getCar() instanceof CharSequence)
        {
            scopeexp = pair2.getCar().toString();
            if (scopeexp.startsWith("class:"))
            {
                pair = ClassNamespace.getInstance(scopeexp, ClassType.make(scopeexp.substring(6)));
                declaration.setType(ClassType.make("gnu.kawa.lispexpr.ClassNamespace"));
            } else
            if (makeXML)
            {
                pair = XmlNamespace.getInstance(pair.getName(), scopeexp);
                declaration.setType(ClassType.make("gnu.kawa.xml.XmlNamespace"));
            } else
            {
                pair = Namespace.valueOf(scopeexp);
                declaration.setType(ClassType.make("gnu.mapping.Namespace"));
            }
            pair = new QuoteExp(pair);
            declaration.setFlag(8192L);
        } else
        {
            pair = translator.rewrite_car(pair2, false);
        }
        declaration.noteValue(pair);
        vector.addElement(SetExp.makeDefinition(declaration, pair));
        return true;
    }

    static 
    {
        define_namespace = new DefineNamespace();
        define_private_namespace = new DefineNamespace();
        define_xml_namespace = new DefineNamespace();
        define_namespace.setName("define-namespace");
        define_private_namespace.setName("define-private-namespace");
        define_private_namespace.makePrivate = true;
        define_xml_namespace.setName("define-xml-namespace");
        define_xml_namespace.makeXML = true;
    }
}
