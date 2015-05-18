// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, ClassType, ConstantPool, CpoolUtf8, 
//            Member, ClassTypeWriter

public class SignatureAttr extends Attribute
{

    String signature;
    int signature_index;

    public SignatureAttr(int i, Member member)
    {
        super("Signature");
        if (member instanceof ClassType)
        {
            member = (ClassType)member;
        } else
        {
            member = member.getDeclaringClass();
        }
        signature = ((CpoolUtf8)((ClassType) (member)).constants.getForced(i, 1)).string;
        signature_index = i;
    }

    public SignatureAttr(String s)
    {
        super("Signature");
        signature = s;
    }

    public void assignConstants(ClassType classtype)
    {
        super.assignConstants(classtype);
        if (signature_index == 0)
        {
            signature_index = classtype.getConstants().addUtf8(signature).getIndex();
        }
    }

    public final int getLength()
    {
        return 2;
    }

    public final String getSignature()
    {
        return signature;
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        super.print(classtypewriter);
        classtypewriter.print("  ");
        classtypewriter.printOptionalIndex(signature_index);
        classtypewriter.print('"');
        classtypewriter.print(getSignature());
        classtypewriter.println('"');
    }

    protected void setSignature(String s)
    {
        signature = s;
        signature_index = 0;
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(signature_index);
    }
}
