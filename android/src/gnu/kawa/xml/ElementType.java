// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.TypeValue;
import gnu.lists.AbstractSequence;
import gnu.lists.ElementPredicate;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.xml.NamespaceBinding;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.xml.namespace.QName;

// Referenced classes of package gnu.kawa.xml:
//            NodeType, KElement, MakeElement

public class ElementType extends NodeType
    implements TypeValue, Externalizable, ElementPredicate
{

    public static final String MATCH_ANY_LOCALNAME = "";
    public static final Symbol MATCH_ANY_QNAME = new Symbol(null, "");
    public static final ElementType anyElement = make(null, null);
    static final Method coerceMethod;
    static final Method coerceOrNullMethod;
    public static final ClassType typeElementType;
    NamespaceBinding namespaceNodes;
    Symbol qname;

    public ElementType(Symbol symbol)
    {
        this(null, symbol);
    }

    public ElementType(String s, Symbol symbol)
    {
        if (s == null || s.length() <= 0)
        {
            s = (new StringBuilder()).append("ELEMENT ").append(symbol).append(" (*)").toString();
        }
        super(s);
        qname = symbol;
    }

    public static KElement coerce(Object obj, String s, String s1)
    {
        obj = coerceOrNull(obj, s, s1);
        if (obj == null)
        {
            throw new ClassCastException();
        } else
        {
            return ((KElement) (obj));
        }
    }

    public static KElement coerceOrNull(Object obj, String s, String s1)
    {
        KElement kelement = (KElement)NodeType.coerceOrNull(obj, 2);
        if (kelement != null) goto _L2; else goto _L1
_L1:
        obj = null;
_L4:
        return ((KElement) (obj));
_L2:
        String s2 = s1;
        if (s1 != null)
        {
            s2 = s1;
            if (s1.length() == 0)
            {
                s2 = null;
            }
        }
        obj = kelement.getNextTypeObject();
        if (obj instanceof Symbol)
        {
            obj = (Symbol)obj;
            s1 = ((Symbol) (obj)).getNamespaceURI();
            obj = ((Symbol) (obj)).getLocalName();
        } else
        if (obj instanceof QName)
        {
            obj = (QName)obj;
            s1 = ((QName) (obj)).getNamespaceURI();
            obj = ((QName) (obj)).getLocalPart();
        } else
        {
            s1 = "";
            obj = obj.toString().intern();
        }
        if (s2 != obj && s2 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = kelement;
        if (s == s1) goto _L4; else goto _L3
_L3:
        obj = kelement;
        if (s == null) goto _L4; else goto _L5
_L5:
        return null;
    }

    public static ElementType make(Symbol symbol)
    {
        return new ElementType(symbol);
    }

    public static ElementType make(String s, String s1)
    {
        if (s != null)
        {
            s = Symbol.make(s, s1);
        } else
        if (s1 == "")
        {
            s = MATCH_ANY_QNAME;
        } else
        {
            s = new Symbol(null, s1);
        }
        return new ElementType(s);
    }

    public Object coerceFromObject(Object obj)
    {
        return coerce(obj, qname.getNamespaceURI(), qname.getLocalName());
    }

    public void emitCoerceFromObject(CodeAttr codeattr)
    {
        codeattr.emitPushString(qname.getNamespaceURI());
        codeattr.emitPushString(qname.getLocalName());
        codeattr.emitInvokeStatic(coerceMethod);
    }

    protected void emitCoerceOrNullMethod(Variable variable, Compilation compilation)
    {
        compilation = compilation.getCode();
        if (variable != null)
        {
            compilation.emitLoad(variable);
        }
        compilation.emitPushString(qname.getNamespaceURI());
        compilation.emitPushString(qname.getLocalName());
        compilation.emitInvokeStatic(coerceOrNullMethod);
    }

    public Procedure getConstructor()
    {
        MakeElement makeelement = new MakeElement();
        makeelement.tag = qname;
        makeelement.setHandlingKeywordParameters(true);
        if (namespaceNodes != null)
        {
            makeelement.setNamespaceNodes(namespaceNodes);
        }
        return makeelement;
    }

    public Type getImplementationType()
    {
        return ClassType.make("gnu.kawa.xml.KElement");
    }

    public final String getLocalName()
    {
        return qname.getLocalName();
    }

    public NamespaceBinding getNamespaceNodes()
    {
        return namespaceNodes;
    }

    public final String getNamespaceURI()
    {
        return qname.getNamespaceURI();
    }

    public boolean isInstance(AbstractSequence abstractsequence, int i, Object obj)
    {
        String s3 = qname.getNamespaceURI();
        String s2 = qname.getLocalName();
        String s;
        if (obj instanceof Symbol)
        {
            abstractsequence = (Symbol)obj;
            obj = abstractsequence.getNamespaceURI();
            abstractsequence = abstractsequence.getLocalName();
        } else
        if (obj instanceof QName)
        {
            abstractsequence = (QName)obj;
            obj = abstractsequence.getNamespaceURI();
            abstractsequence = abstractsequence.getLocalPart();
        } else
        {
            String s1 = "";
            abstractsequence = obj.toString().intern();
            obj = s1;
        }
        s = s2;
        if (s2 != null)
        {
            s = s2;
            if (s2.length() == 0)
            {
                s = null;
            }
        }
        return (s == abstractsequence || s == null) && (s3 == obj || s3 == null);
    }

    public boolean isInstance(Object obj)
    {
        return coerceOrNull(obj, qname.getNamespaceURI(), qname.getLocalName()) != null;
    }

    public boolean isInstancePos(AbstractSequence abstractsequence, int i)
    {
        int j = abstractsequence.getNextKind(i);
        if (j == 33)
        {
            return isInstance(abstractsequence, i, abstractsequence.getNextTypeObject(i));
        }
        if (j == 32)
        {
            return isInstance(abstractsequence.getPosNext(i));
        } else
        {
            return false;
        }
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        String s = objectinput.readUTF();
        if (s.length() > 0)
        {
            setName(s);
        }
        qname = (Symbol)objectinput.readObject();
    }

    public void setNamespaceNodes(NamespaceBinding namespacebinding)
    {
        namespaceNodes = namespacebinding;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ElementType ").append(qname).toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        String s1 = getName();
        String s = s1;
        if (s1 == null)
        {
            s = "";
        }
        objectoutput.writeUTF(s);
        objectoutput.writeObject(qname);
    }

    static 
    {
        typeElementType = ClassType.make("gnu.kawa.xml.ElementType");
        coerceMethod = typeElementType.getDeclaredMethod("coerce", 3);
        coerceOrNullMethod = typeElementType.getDeclaredMethod("coerceOrNull", 3);
    }
}
