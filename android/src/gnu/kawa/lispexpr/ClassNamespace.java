// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.kawa.functions.GetNamedPart;
import gnu.mapping.Namespace;
import gnu.mapping.WrappedException;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;

public class ClassNamespace extends Namespace
    implements Externalizable
{

    ClassType ctype;

    public ClassNamespace()
    {
    }

    public ClassNamespace(ClassType classtype)
    {
        setName((new StringBuilder()).append("class:").append(classtype.getName()).toString());
        ctype = classtype;
    }

    public static ClassNamespace getInstance(String s, ClassType classtype)
    {
label0:
        {
            synchronized (nsTable)
            {
                Object obj = nsTable.get(s);
                if (!(obj instanceof ClassNamespace))
                {
                    break label0;
                }
                s = (ClassNamespace)obj;
            }
            return s;
        }
        classtype = new ClassNamespace(classtype);
        nsTable.put(s, classtype);
        hashtable;
        JVM INSTR monitorexit ;
        return classtype;
        s;
        hashtable;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Object get(String s)
    {
        try
        {
            s = ((String) (GetNamedPart.getTypePart(ctype, s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw WrappedException.wrapIfNeeded(s);
        }
        return s;
    }

    public ClassType getClassType()
    {
        return ctype;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        ctype = (ClassType)objectinput.readObject();
        setName((new StringBuilder()).append("class:").append(ctype.getName()).toString());
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        String s = getName();
        if (s != null)
        {
            Namespace namespace = (Namespace)nsTable.get(s);
            if (namespace instanceof ClassNamespace)
            {
                return namespace;
            }
            nsTable.put(s, this);
        }
        return this;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(ctype);
    }
}
