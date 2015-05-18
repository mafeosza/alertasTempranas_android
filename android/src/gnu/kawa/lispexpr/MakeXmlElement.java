// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.kawa.xml.MakeElement;
import gnu.kawa.xml.MakeText;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.xml.NamespaceBinding;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class MakeXmlElement extends Syntax
{

    public static final MakeXmlElement makeXml;
    static final ClassType typeNamespace = ClassType.make("gnu.mapping.Namespace");

    public MakeXmlElement()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Object obj;
        NamespaceBinding namespacebinding;
        Object obj4;
        boolean flag;
        Object obj1 = (Pair)pair.getCdr();
        obj = ((Pair) (obj1)).getCar();
        obj4 = ((Pair) (obj1)).getCdr();
        flag = false;
        namespacebinding = translator.xmlElementNamespaces;
        obj1 = namespacebinding;
        while (obj instanceof Pair) 
        {
            boolean flag1 = flag;
            if (!flag)
            {
                translator.letStart();
                flag1 = true;
            }
            Pair pair1 = (Pair)obj;
            Object obj2 = (Pair)pair1.getCar();
            obj = (String)((Pair) (obj2)).getCar();
            Object obj3;
            if (((String) (obj)).length() == 0)
            {
                obj = null;
            } else
            {
                obj = ((String) (obj)).intern();
            }
            obj2 = ((Pair) (obj2)).getCdr();
            obj3 = new StringBuilder();
            while (obj2 instanceof Pair) 
            {
                Pair pair2 = (Pair)obj2;
                obj2 = pair2.getCar();
                if (LList.listLength(obj2, false) == 2 && (obj2 instanceof Pair) && ((Pair)obj2).getCar() == MakeText.makeText)
                {
                    obj2 = ((Pair)((Pair)obj2).getCdr()).getCar();
                } else
                {
                    obj2 = translator.rewrite_car(pair2, false).valueIfConstant();
                }
                if (obj2 == null)
                {
                    obj2 = translator.pushPositionOf(pair2);
                    translator.error('e', "namespace URI must be literal");
                    translator.popPositionOf(obj2);
                } else
                {
                    ((StringBuilder) (obj3)).append(obj2);
                }
                obj2 = pair2.getCdr();
            }
            obj3 = ((StringBuilder) (obj3)).toString().intern();
            if (obj3 == "")
            {
                obj2 = null;
            } else
            {
                obj2 = obj3;
            }
            obj2 = new NamespaceBinding(((String) (obj)), ((String) (obj2)), ((NamespaceBinding) (obj1)));
            if (obj == null)
            {
                obj1 = Namespace.valueOf(((String) (obj3)));
                obj = "[default-element-namespace]";
            } else
            {
                obj1 = XmlNamespace.getInstance(((String) (obj)), ((String) (obj3)));
            }
            translator.letVariable(Namespace.EmptyNamespace.getSymbol(((String) (obj))), typeNamespace, new QuoteExp(obj1)).setFlag(0x206000L);
            obj = pair1.getCdr();
            obj1 = obj2;
            flag = flag1;
        }
        obj = new MakeElement();
        ((MakeElement) (obj)).setNamespaceNodes(((NamespaceBinding) (obj1)));
        translator.xmlElementNamespaces = ((NamespaceBinding) (obj1));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        translator.letEnter();
        obj = translator.rewrite(Translator.makePair(pair, obj, obj4));
        pair = ((Pair) (obj));
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        pair = translator.letDone(((Expression) (obj)));
        translator.xmlElementNamespaces = namespacebinding;
        return pair;
        pair;
        translator.xmlElementNamespaces = namespacebinding;
        throw pair;
    }

    static 
    {
        makeXml = new MakeXmlElement();
        makeXml.setName("$make-xml$");
    }
}
