// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import java.util.IdentityHashMap;

// Referenced classes of package gnu.expr:
//            LitTable, Compilation

public class Literal
{

    static final int CYCLIC = 4;
    static final int EMITTED = 8;
    static final int WRITING = 1;
    static final int WRITTEN = 2;
    public static final Literal nullLiteral;
    Type argTypes[];
    Object argValues[];
    public Field field;
    public int flags;
    int index;
    Literal next;
    public Type type;
    Object value;

    public Literal(Object obj, Field field1, LitTable littable)
    {
        value = obj;
        littable.literalTable.put(obj, this);
        field = field1;
        type = field1.getType();
        flags = 10;
    }

    Literal(Object obj, Type type1)
    {
        value = obj;
        type = type1;
    }

    public Literal(Object obj, Type type1, LitTable littable)
    {
        value = obj;
        littable.literalTable.put(obj, this);
        type = type1;
    }

    public Literal(Object obj, LitTable littable)
    {
        this(obj, (String)null, littable);
    }

    public Literal(Object obj, String s, LitTable littable)
    {
        value = obj;
        littable.literalTable.put(obj, this);
        type = Type.make(obj.getClass());
        assign(s, littable);
    }

    void assign(Field field1, LitTable littable)
    {
        next = littable.literalsChain;
        littable.literalsChain = this;
        field = field1;
    }

    void assign(LitTable littable)
    {
        assign((String)null, littable);
    }

    void assign(String s, LitTable littable)
    {
        int i;
        if (littable.comp.immediate)
        {
            i = 9;
        } else
        {
            i = 24;
        }
        if (s == null)
        {
            int j = littable.literalsCount;
            littable.literalsCount = j + 1;
            index = j;
            s = (new StringBuilder()).append("Lit").append(index).toString();
        } else
        {
            i |= 1;
        }
        assign(littable.mainClass.addField(s, type, i), littable);
    }

    public final Object getValue()
    {
        return value;
    }

    static 
    {
        nullLiteral = new Literal(null, Type.nullType);
    }
}
