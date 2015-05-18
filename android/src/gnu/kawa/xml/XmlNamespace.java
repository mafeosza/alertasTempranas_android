// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.mapping.Namespace;
import gnu.xml.NamespaceBinding;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;

// Referenced classes of package gnu.kawa.xml:
//            ElementType

public class XmlNamespace extends Namespace
    implements Externalizable
{

    public static final XmlNamespace HTML = valueOf("http://www.w3.org/1999/xhtml", "");
    public static final NamespaceBinding HTML_BINDINGS;
    public static final String XHTML_NAMESPACE = "http://www.w3.org/1999/xhtml";

    public XmlNamespace()
    {
    }

    public static XmlNamespace getInstance(String s, String s1)
    {
        String s2;
label0:
        {
            s2 = (new StringBuilder()).append(s).append(" [xml] -> ").append(s1).toString();
            synchronized (nsTable)
            {
                Object obj = nsTable.get(s2);
                if (!(obj instanceof XmlNamespace))
                {
                    break label0;
                }
                s = (XmlNamespace)obj;
            }
            return s;
        }
        XmlNamespace xmlnamespace;
        xmlnamespace = new XmlNamespace();
        xmlnamespace.setName(s1.intern());
        xmlnamespace.prefix = s.intern();
        nsTable.put(s2, xmlnamespace);
        hashtable;
        JVM INSTR monitorexit ;
        return xmlnamespace;
        s;
        hashtable;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static XmlNamespace valueOf(String s, String s1)
    {
        return getInstance(s1, s);
    }

    public Object get(String s)
    {
        s = ElementType.make(getSymbol(s));
        if (this == HTML)
        {
            s.setNamespaceNodes(HTML_BINDINGS);
        }
        return s;
    }

    public boolean isConstant(String s)
    {
        return true;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        setName((String)objectinput.readObject());
        prefix = (String)objectinput.readObject();
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        String s = (new StringBuilder()).append(prefix).append(" -> ").append(getName()).toString();
        Namespace namespace = (Namespace)nsTable.get(s);
        if (namespace instanceof XmlNamespace)
        {
            return namespace;
        } else
        {
            nsTable.put(s, this);
            return this;
        }
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(getName());
        objectoutput.writeObject(prefix);
    }

    static 
    {
        HTML_BINDINGS = new NamespaceBinding(null, "http://www.w3.org/1999/xhtml", NamespaceBinding.predefinedXML);
    }
}
