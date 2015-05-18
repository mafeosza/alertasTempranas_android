// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;

// Referenced classes of package gnu.mapping:
//            HasNamedParts, SymbolRef, SimpleSymbol, Symbol, 
//            Environment

public class Namespace
    implements Externalizable, HasNamedParts
{

    public static final Namespace EmptyNamespace = valueOf("");
    protected static final Hashtable nsTable = new Hashtable(50);
    int log2Size;
    private int mask;
    String name;
    int num_bindings;
    protected String prefix;
    protected SymbolRef table[];

    protected Namespace()
    {
        this(64);
    }

    protected Namespace(int i)
    {
        prefix = "";
        for (log2Size = 4; i > 1 << log2Size; log2Size = log2Size + 1) { }
        i = 1 << log2Size;
        table = new SymbolRef[i];
        mask = i - 1;
    }

    public static Namespace create()
    {
        return new Namespace(64);
    }

    public static Namespace create(int i)
    {
        return new Namespace(i);
    }

    public static Namespace getDefault()
    {
        return EmptyNamespace;
    }

    public static Symbol getDefaultSymbol(String s)
    {
        return EmptyNamespace.getSymbol(s);
    }

    public static Namespace makeUnknownNamespace(String s)
    {
        String s1;
        if (s == null || s == "")
        {
            s1 = "";
        } else
        {
            s1 = (new StringBuilder()).append("http://kawa.gnu.org/unknown-namespace/").append(s).toString();
        }
        return valueOf(s1, s);
    }

    public static Namespace valueOf()
    {
        return EmptyNamespace;
    }

    public static Namespace valueOf(String s)
    {
        String s1;
        s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        s = nsTable;
        s;
        JVM INSTR monitorenter ;
        Namespace namespace = (Namespace)nsTable.get(s1);
        if (namespace == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        s;
        JVM INSTR monitorexit ;
        return namespace;
        namespace = new Namespace();
        namespace.setName(s1.intern());
        nsTable.put(s1, namespace);
        s;
        JVM INSTR monitorexit ;
        return namespace;
        Exception exception;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static Namespace valueOf(String s, SimpleSymbol simplesymbol)
    {
        if (simplesymbol == null)
        {
            simplesymbol = null;
        } else
        {
            simplesymbol = simplesymbol.getName();
        }
        return valueOf(s, ((String) (simplesymbol)));
    }

    public static Namespace valueOf(String s, String s1)
    {
        String s2;
        if (s1 == null || s1.length() == 0)
        {
            return valueOf(s);
        }
        s2 = (new StringBuilder()).append(s1).append(" -> ").append(s).toString();
        synchronized (nsTable)
        {
            Object obj = nsTable.get(s2);
            if (!(obj instanceof Namespace))
            {
                break MISSING_BLOCK_LABEL_78;
            }
            s = (Namespace)obj;
        }
        return s;
        s;
        hashtable;
        JVM INSTR monitorexit ;
        throw s;
        Namespace namespace;
        namespace = new Namespace();
        namespace.setName(s.intern());
        namespace.prefix = s1.intern();
        nsTable.put(s2, namespace);
        hashtable;
        JVM INSTR monitorexit ;
        return namespace;
    }

    public Symbol add(Symbol symbol, int i)
    {
        i &= mask;
        SymbolRef symbolref = new SymbolRef(symbol, this);
        symbol.namespace = this;
        symbolref.next = table[i];
        table[i] = symbolref;
        num_bindings = num_bindings + 1;
        if (num_bindings >= table.length)
        {
            rehash();
        }
        return symbol;
    }

    public Object get(String s)
    {
        return Environment.getCurrent().get(getSymbol(s));
    }

    public final String getName()
    {
        return name;
    }

    public final String getPrefix()
    {
        return prefix;
    }

    public Symbol getSymbol(String s)
    {
        return lookup(s, s.hashCode(), true);
    }

    public boolean isConstant(String s)
    {
        return false;
    }

    public Symbol lookup(String s)
    {
        return lookup(s, s.hashCode(), false);
    }

    public Symbol lookup(String s, int i, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Symbol symbol = lookupInternal(s, i);
        if (symbol == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        this;
        JVM INSTR monitorexit ;
        return symbol;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_69;
        }
        if (this != EmptyNamespace)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        s = new SimpleSymbol(s);
_L1:
        s = add(s, i);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        s = new Symbol(this, s);
          goto _L1
        this;
        JVM INSTR monitorexit ;
        return null;
    }

    protected final Symbol lookupInternal(String s, int i)
    {
        i &= mask;
        SymbolRef symbolref1 = null;
        SymbolRef symbolref = table[i];
        while (symbolref != null) 
        {
            SymbolRef symbolref2 = symbolref.next;
            Symbol symbol = symbolref.getSymbol();
            if (symbol == null)
            {
                if (symbolref1 == null)
                {
                    table[i] = symbolref2;
                } else
                {
                    symbolref1.next = symbolref2;
                }
                num_bindings = num_bindings - 1;
            } else
            {
                if (symbol.getLocalPart().equals(s))
                {
                    return symbol;
                }
                symbolref1 = symbolref;
            }
            symbolref = symbolref2;
        }
        return null;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        name = ((String)objectinput.readObject()).intern();
        prefix = (String)objectinput.readObject();
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        String s = getName();
        if (s != null)
        {
            Namespace namespace;
            if (prefix != null && prefix.length() != 0)
            {
                s = (new StringBuilder()).append(prefix).append(" -> ").append(s).toString();
            }
            namespace = (Namespace)nsTable.get(s);
            if (namespace != null)
            {
                return namespace;
            }
            nsTable.put(s, this);
        }
        return this;
    }

    protected void rehash()
    {
        SymbolRef asymbolref1[];
        int l;
        int j1;
        int k = table.length;
        int i = k * 2;
        j1 = i - 1;
        l = 0;
        SymbolRef asymbolref[] = table;
        asymbolref1 = new SymbolRef[i];
        do
        {
label0:
            {
                int i1 = k - 1;
                if (i1 < 0)
                {
                    break label0;
                }
                SymbolRef symbolref = asymbolref[i1];
                int j = l;
                do
                {
                    l = j;
                    k = i1;
                    if (symbolref == null)
                    {
                        break;
                    }
                    SymbolRef symbolref1 = symbolref.next;
                    Symbol symbol = symbolref.getSymbol();
                    k = j;
                    if (symbol != null)
                    {
                        l = symbol.getName().hashCode() & j1;
                        k = j + 1;
                        symbolref.next = asymbolref1[l];
                        asymbolref1[l] = symbolref;
                    }
                    symbolref = symbolref1;
                    j = k;
                } while (true);
            }
        } while (true);
        table = asymbolref1;
        log2Size = log2Size + 1;
        mask = j1;
        num_bindings = l;
        return;
    }

    public boolean remove(Symbol symbol)
    {
        this;
        JVM INSTR monitorenter ;
        int i = symbol.getLocalPart().hashCode() & mask;
        SymbolRef symbolref1 = null;
        SymbolRef symbolref = table[i];
_L4:
        if (symbolref == null) goto _L2; else goto _L1
_L1:
        SymbolRef symbolref2;
        Symbol symbol1;
        symbolref2 = symbolref.next;
        symbol1 = symbolref.getSymbol();
        if (symbol1 != null && symbol1 != symbol)
        {
            break MISSING_BLOCK_LABEL_99;
        }
        if (symbolref1 != null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        table[i] = symbolref2;
_L3:
        num_bindings = num_bindings - 1;
        if (symbol1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        this;
        JVM INSTR monitorexit ;
        return true;
        symbolref1.next = symbolref2;
          goto _L3
        symbol;
        this;
        JVM INSTR monitorexit ;
        throw symbol;
        symbolref1 = symbolref;
        symbolref = symbolref2;
          goto _L4
_L2:
        this;
        JVM INSTR monitorexit ;
        return false;
    }

    public final void setName(String s)
    {
        name = s;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("#,(namespace \"");
        stringbuilder.append(name);
        stringbuilder.append('"');
        if (prefix != null && prefix != "")
        {
            stringbuilder.append(' ');
            stringbuilder.append(prefix);
        }
        stringbuilder.append(')');
        return stringbuilder.toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(getName());
        objectoutput.writeObject(prefix);
    }

}
