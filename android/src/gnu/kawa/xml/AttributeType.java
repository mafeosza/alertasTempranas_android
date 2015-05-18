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
import gnu.lists.AttributePredicate;
import gnu.lists.SeqPosition;
import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import javax.xml.namespace.QName;

// Referenced classes of package gnu.kawa.xml:
//            NodeType, KNode, KAttr, ElementType

public class AttributeType extends NodeType
    implements TypeValue, Externalizable, AttributePredicate
{

    static final Method coerceMethod;
    static final Method coerceOrNullMethod;
    public static final ClassType typeAttributeType;
    Symbol qname;

    public AttributeType(Symbol symbol)
    {
        this(null, symbol);
    }

    public AttributeType(String s, Symbol symbol)
    {
        if (s == null || s.length() <= 0)
        {
            s = (new StringBuilder()).append("ATTRIBUTE ").append(symbol).append(" (*)").toString();
        }
        super(s);
        qname = symbol;
    }

    public static SeqPosition coerce(Object obj, String s, String s1)
    {
        obj = coerceOrNull(obj, s, s1);
        if (obj == null)
        {
            throw new ClassCastException();
        } else
        {
            return ((SeqPosition) (obj));
        }
    }

    public static KAttr coerceOrNull(Object obj, String s, String s1)
    {
        KNode knode = NodeType.coerceOrNull(obj, 4);
        if (knode == null)
        {
            return null;
        }
        String s2 = s1;
        if (s1 != null)
        {
            s2 = s1;
            if (s1.length() == 0)
            {
                s2 = null;
            }
        }
        obj = knode.getNextTypeObject();
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
        if ((s2 == obj || s2 == null) && (s == s1 || s == null))
        {
            return (KAttr)knode;
        } else
        {
            return null;
        }
    }

    public static AttributeType make(Symbol symbol)
    {
        return new AttributeType(symbol);
    }

    public static AttributeType make(String s, String s1)
    {
        if (s != null)
        {
            s = Symbol.make(s, s1);
        } else
        if (s1 == "")
        {
            s = ElementType.MATCH_ANY_QNAME;
        } else
        {
            s = new Symbol(null, s1);
        }
        return new AttributeType(s);
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

    public Type getImplementationType()
    {
        return ClassType.make("gnu.kawa.xml.KAttr");
    }

    public final String getLocalName()
    {
        return qname.getLocalName();
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
        if (j == 35)
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

    public String toString()
    {
        return (new StringBuilder()).append("AttributeType ").append(qname).toString();
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
        typeAttributeType = ClassType.make("gnu.kawa.xml.AttributeType");
        coerceMethod = typeAttributeType.getDeclaredMethod("coerce", 3);
        coerceOrNullMethod = typeAttributeType.getDeclaredMethod("coerceOrNull", 3);
    }
}
