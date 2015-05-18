// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Location, AttrContainer, Member, ClassType, 
//            ConstantPool, CpoolUtf8, Type, Attribute, 
//            ConstantValueAttr, CpoolEntry, PrimType

public class Field extends Location
    implements AttrContainer, Member
{

    Attribute attributes;
    int flags;
    Field next;
    ClassType owner;
    java.lang.reflect.Field rfield;
    String sourceName;

    public Field(ClassType classtype)
    {
        if (classtype.last_field == null)
        {
            classtype.fields = this;
        } else
        {
            classtype.last_field.next = this;
        }
        classtype.last_field = this;
        classtype.fields_count = classtype.fields_count + 1;
        owner = classtype;
    }

    public static Field searchField(Field field, String s)
    {
        for (; field != null; field = field.next)
        {
            if (field.getSourceName() == s)
            {
                return field;
            }
        }

        return null;
    }

    void assign_constants(ClassType classtype)
    {
        ConstantPool constantpool = classtype.constants;
        if (name_index == 0 && name != null)
        {
            name_index = constantpool.addUtf8(name).index;
        }
        if (signature_index == 0 && type != null)
        {
            signature_index = constantpool.addUtf8(type.getSignature()).index;
        }
        Attribute.assignConstants(this, classtype);
    }

    public final Attribute getAttributes()
    {
        return attributes;
    }

    public final ClassType getDeclaringClass()
    {
        return owner;
    }

    public final int getFlags()
    {
        return flags;
    }

    public final int getModifiers()
    {
        return flags;
    }

    public final Field getNext()
    {
        return next;
    }

    public java.lang.reflect.Field getReflectField()
        throws NoSuchFieldException
    {
        this;
        JVM INSTR monitorenter ;
        java.lang.reflect.Field field;
        if (rfield == null)
        {
            rfield = owner.getReflectClass().getDeclaredField(getName());
        }
        field = rfield;
        this;
        JVM INSTR monitorexit ;
        return field;
        Exception exception;
        exception;
        throw exception;
    }

    public String getSourceName()
    {
        if (sourceName == null)
        {
            sourceName = getName().intern();
        }
        return sourceName;
    }

    public final boolean getStaticFlag()
    {
        return (flags & 8) != 0;
    }

    public final void setAttributes(Attribute attribute)
    {
        attributes = attribute;
    }

    public final void setConstantValue(Object obj, ClassType classtype)
    {
        ConstantPool constantpool;
        int i;
        i = 0;
        ConstantPool constantpool1 = classtype.constants;
        constantpool = constantpool1;
        if (constantpool1 == null)
        {
            constantpool = new ConstantPool();
            classtype.constants = constantpool;
        }
        getType().getSignature().charAt(0);
        JVM INSTR lookupswitch 8: default 116
    //                   66: 183
    //                   67: 161
    //                   68: 228
    //                   70: 213
    //                   73: 183
    //                   74: 198
    //                   83: 183
    //                   90: 141;
           goto _L1 _L2 _L3 _L4 _L5 _L2 _L6 _L2 _L7
_L1:
        obj = constantpool.addString(obj.toString());
_L9:
        (new ConstantValueAttr(((CpoolEntry) (obj)).getIndex())).addToFrontOf(this);
        return;
_L7:
        if (PrimType.booleanValue(obj))
        {
            i = 1;
        }
        obj = constantpool.addInt(i);
        continue; /* Loop/switch isn't completed */
_L3:
        if (obj instanceof Character)
        {
            obj = constantpool.addInt(((Character)obj).charValue());
            continue; /* Loop/switch isn't completed */
        }
_L2:
        obj = constantpool.addInt(((Number)obj).intValue());
        continue; /* Loop/switch isn't completed */
_L6:
        obj = constantpool.addLong(((Number)obj).longValue());
        continue; /* Loop/switch isn't completed */
_L5:
        obj = constantpool.addFloat(((Number)obj).floatValue());
        continue; /* Loop/switch isn't completed */
_L4:
        obj = constantpool.addDouble(((Number)obj).doubleValue());
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void setSourceName(String s)
    {
        sourceName = s;
    }

    public final void setStaticFlag(boolean flag)
    {
        if (flag)
        {
            flags = flags | 8;
            return;
        } else
        {
            flags = flags ^ -9;
            return;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(100);
        stringbuffer.append("Field:");
        stringbuffer.append(getDeclaringClass().getName());
        stringbuffer.append('.');
        stringbuffer.append(name);
        return stringbuffer.toString();
    }

    void write(DataOutputStream dataoutputstream, ClassType classtype)
        throws IOException
    {
        dataoutputstream.writeShort(flags);
        dataoutputstream.writeShort(name_index);
        dataoutputstream.writeShort(signature_index);
        Attribute.writeAll(this, dataoutputstream);
    }
}
