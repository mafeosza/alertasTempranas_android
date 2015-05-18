// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, ClassType, ConstantPool, CpoolEntry, 
//            CpoolString, CpoolUtf8, CpoolValue1, CpoolValue2, 
//            ClassTypeWriter

public class ConstantValueAttr extends Attribute
{

    Object value;
    int value_index;

    public ConstantValueAttr(int i)
    {
        super("ConstantValue");
        value_index = i;
    }

    public ConstantValueAttr(Object obj)
    {
        super("ConstantValue");
        value = obj;
    }

    public void assignConstants(ClassType classtype)
    {
        super.assignConstants(classtype);
        if (value_index != 0) goto _L2; else goto _L1
_L1:
        ConstantPool constantpool;
        constantpool = classtype.getConstants();
        classtype = null;
        if (!(value instanceof String)) goto _L4; else goto _L3
_L3:
        classtype = constantpool.addString((String)value);
_L6:
        value_index = classtype.getIndex();
_L2:
        return;
_L4:
        if (value instanceof Integer)
        {
            classtype = constantpool.addInt(((Integer)value).intValue());
        } else
        if (value instanceof Long)
        {
            classtype = constantpool.addLong(((Long)value).longValue());
        } else
        if (value instanceof Float)
        {
            classtype = constantpool.addFloat(((Float)value).floatValue());
        } else
        if (value instanceof Long)
        {
            classtype = constantpool.addDouble(((Double)value).doubleValue());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public final int getLength()
    {
        return 2;
    }

    public Object getValue(ConstantPool constantpool)
    {
        if (value != null)
        {
            return value;
        }
        constantpool = constantpool.getPoolEntry(value_index);
        constantpool.getTag();
        JVM INSTR tableswitch 3 8: default 64
    //                   3 86
    //                   4 128
    //                   5 107
    //                   6 152
    //                   7 64
    //                   8 69;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6
_L1:
        return value;
_L6:
        value = ((CpoolString)constantpool).getString().getString();
        continue; /* Loop/switch isn't completed */
_L2:
        value = new Integer(((CpoolValue1)constantpool).value);
        continue; /* Loop/switch isn't completed */
_L4:
        value = new Long(((CpoolValue2)constantpool).value);
        continue; /* Loop/switch isn't completed */
_L3:
        value = new Float(Float.intBitsToFloat(((CpoolValue1)constantpool).value));
        continue; /* Loop/switch isn't completed */
_L5:
        value = new Double(Double.longBitsToDouble(((CpoolValue2)constantpool).value));
        if (true) goto _L1; else goto _L7
_L7:
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.print(getLength());
        classtypewriter.print(", value: ");
        if (value_index == 0)
        {
            Object obj = getValue(classtypewriter.ctype.constants);
            if (obj instanceof String)
            {
                classtypewriter.printQuotedString((String)obj);
            } else
            {
                classtypewriter.print(obj);
            }
        } else
        {
            classtypewriter.printOptionalIndex(value_index);
            classtypewriter.ctype.constants.getPoolEntry(value_index).print(classtypewriter, 1);
        }
        classtypewriter.println();
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(value_index);
    }
}
