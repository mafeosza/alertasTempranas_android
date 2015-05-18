// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

// Referenced classes of package gnu.mapping:
//            EnvironmentKey, Namespace, SimpleSymbol

public class Symbol
    implements EnvironmentKey, Comparable, Externalizable
{

    public static final Symbol FUNCTION = makeUninterned("(function)");
    public static final Symbol PLIST = makeUninterned("(property-list)");
    protected String name;
    Namespace namespace;

    public Symbol()
    {
    }

    public Symbol(Namespace namespace1, String s)
    {
        name = s;
        namespace = namespace1;
    }

    public static boolean equals(Symbol symbol, Symbol symbol1)
    {
        if (symbol != symbol1) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (symbol == null || symbol1 == null)
        {
            return false;
        }
        if (symbol.name != symbol1.name)
        {
            break; /* Loop/switch isn't completed */
        }
        symbol = symbol.namespace;
        symbol1 = symbol1.namespace;
        if (symbol == null || symbol1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((Namespace) (symbol)).name != ((Namespace) (symbol1)).name)
        {
            return false;
        }
        if (true) goto _L1; else goto _L3
_L3:
        return false;
    }

    public static Symbol make(Object obj, String s)
    {
        if (obj instanceof String)
        {
            obj = Namespace.valueOf((String)obj);
        } else
        {
            obj = (Namespace)obj;
        }
        if (obj == null || s == null)
        {
            return makeUninterned(s);
        } else
        {
            return ((Namespace) (obj)).getSymbol(s.intern());
        }
    }

    public static Symbol make(String s, String s1, String s2)
    {
        return Namespace.valueOf(s, s2).getSymbol(s1.intern());
    }

    public static Symbol makeUninterned(String s)
    {
        return new Symbol(null, s);
    }

    public static Symbol makeWithUnknownNamespace(String s, String s1)
    {
        return Namespace.makeUnknownNamespace(s1).getSymbol(s.intern());
    }

    public static Symbol parse(String s)
    {
        int i;
        int k;
        int l;
        int j1;
        byte byte0;
        boolean flag;
        int i2;
        i2 = s.length();
        k = -1;
        byte0 = -1;
        j1 = 0;
        flag = false;
        l = 0;
        i = 0;
_L2:
        int j;
        int i1;
        int k1 = k;
        i1 = ((flag) ? 1 : 0);
        j = l;
        int l1 = byte0;
        if (i < i2)
        {
            l1 = s.charAt(i);
            String s2;
            if (l1 == ':' && j1 == 0)
            {
                j = i;
                i1 = i + 1;
                l1 = byte0;
                k1 = k;
            } else
            {
label0:
                {
                    k1 = j1;
                    i1 = k;
                    j = l;
                    if (l1 == '{')
                    {
                        i1 = k;
                        j = l;
                        if (k < 0)
                        {
                            j = i;
                            i1 = i;
                        }
                        k1 = j1 + 1;
                    }
                    j1 = k1;
                    if (l1 != '}')
                    {
                        break label0;
                    }
                    k = k1 - 1;
                    if (k == 0)
                    {
                        l1 = i;
                        if (i < i2 && s.charAt(i + 1) == ':')
                        {
                            i += 2;
                        } else
                        {
                            i++;
                        }
                        k1 = i1;
                        i1 = i;
                    } else
                    {
                        j1 = k;
                        if (k >= 0)
                        {
                            break label0;
                        }
                        i = j;
                        k1 = i1;
                        i1 = i;
                        l1 = byte0;
                    }
                }
            }
        }
        if (k1 >= 0 && l1 > 0)
        {
            s2 = s.substring(k1 + 1, l1);
            String s1;
            if (j > 0)
            {
                s1 = s.substring(0, j);
            } else
            {
                s1 = null;
            }
            return valueOf(s.substring(i1), s2, s1);
        }
        break; /* Loop/switch isn't completed */
        i++;
        k = i1;
        l = j;
        if (true) goto _L2; else goto _L1
_L1:
        if (j > 0)
        {
            return makeWithUnknownNamespace(s.substring(i1), s.substring(0, j));
        } else
        {
            return valueOf(s);
        }
    }

    public static SimpleSymbol valueOf(String s)
    {
        return (SimpleSymbol)Namespace.EmptyNamespace.getSymbol(s.intern());
    }

    public static Symbol valueOf(String s, Object obj)
    {
        if (obj == null || obj == Boolean.FALSE)
        {
            return makeUninterned(s);
        }
        if (obj instanceof Namespace)
        {
            obj = (Namespace)obj;
        } else
        if (obj == Boolean.TRUE)
        {
            obj = Namespace.EmptyNamespace;
        } else
        {
            obj = Namespace.valueOf(((CharSequence)obj).toString());
        }
        return ((Namespace) (obj)).getSymbol(s.intern());
    }

    public static Symbol valueOf(String s, String s1, String s2)
    {
        return Namespace.valueOf(s1, s2).getSymbol(s.intern());
    }

    public int compareTo(Object obj)
    {
        obj = (Symbol)obj;
        if (getNamespaceURI() != ((Symbol) (obj)).getNamespaceURI())
        {
            throw new IllegalArgumentException("comparing Symbols in different namespaces");
        } else
        {
            return getLocalName().compareTo(((Symbol) (obj)).getLocalName());
        }
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof Symbol) && equals(this, (Symbol)obj);
    }

    public final Object getKeyProperty()
    {
        return null;
    }

    public final Symbol getKeySymbol()
    {
        return this;
    }

    public final String getLocalName()
    {
        return name;
    }

    public final String getLocalPart()
    {
        return name;
    }

    public final String getName()
    {
        return name;
    }

    public final Namespace getNamespace()
    {
        return namespace;
    }

    public final String getNamespaceURI()
    {
        Namespace namespace1 = getNamespace();
        if (namespace1 == null)
        {
            return null;
        } else
        {
            return namespace1.getName();
        }
    }

    public final String getPrefix()
    {
        Namespace namespace1 = namespace;
        if (namespace1 == null)
        {
            return "";
        } else
        {
            return namespace1.prefix;
        }
    }

    public final boolean hasEmptyNamespace()
    {
label0:
        {
            Object obj = getNamespace();
            if (obj != null)
            {
                obj = ((Namespace) (obj)).getName();
                if (obj != null && ((String) (obj)).length() != 0)
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode()
    {
        if (name == null)
        {
            return 0;
        } else
        {
            return name.hashCode();
        }
    }

    public boolean matches(EnvironmentKey environmentkey)
    {
        return equals(environmentkey.getKeySymbol(), this) && environmentkey.getKeyProperty() == null;
    }

    public boolean matches(Symbol symbol, Object obj)
    {
        return equals(symbol, this) && obj == null;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        namespace = (Namespace)objectinput.readObject();
        name = (String)objectinput.readObject();
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        if (namespace == null)
        {
            return this;
        } else
        {
            return make(namespace, getName());
        }
    }

    public final void setNamespace(Namespace namespace1)
    {
        namespace = namespace1;
    }

    public String toString()
    {
        return toString('P');
    }

    public String toString(char c)
    {
label0:
        {
            boolean flag1 = true;
            Object obj = getNamespaceURI();
            String s1 = getPrefix();
            String s;
            boolean flag;
            if (obj != null && ((String) (obj)).length() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (s1 == null || s1.length() <= 0)
            {
                flag1 = false;
            }
            s = getName();
            if (!flag)
            {
                obj = s;
                if (!flag1)
                {
                    break label0;
                }
            }
            obj = new StringBuilder();
            if (flag1 && (c != 'U' || !flag))
            {
                ((StringBuilder) (obj)).append(s1);
            }
            if (flag && (c != 'P' || !flag1))
            {
                ((StringBuilder) (obj)).append('{');
                ((StringBuilder) (obj)).append(getNamespaceURI());
                ((StringBuilder) (obj)).append('}');
            }
            ((StringBuilder) (obj)).append(':');
            ((StringBuilder) (obj)).append(s);
            obj = ((StringBuilder) (obj)).toString();
        }
        return ((String) (obj));
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(getNamespace());
        objectoutput.writeObject(getName());
    }

}
