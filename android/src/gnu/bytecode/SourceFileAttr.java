// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, ClassType, ConstantPool, CpoolUtf8, 
//            ClassTypeWriter

public class SourceFileAttr extends Attribute
{

    String filename;
    int filename_index;

    public SourceFileAttr(int i, ClassType classtype)
    {
        super("SourceFile");
        filename = ((CpoolUtf8)classtype.constants.getForced(i, 1)).string;
        filename_index = i;
    }

    public SourceFileAttr(String s)
    {
        super("SourceFile");
        filename = s;
    }

    public static String fixSourceFile(String s)
    {
        String s2 = System.getProperty("file.separator", "/");
        String s1 = s;
        if (s2 != null)
        {
            s1 = s;
            if (s2.length() == 1)
            {
                char c = s2.charAt(0);
                s1 = s;
                if (c != '/')
                {
                    s1 = s.replace(c, '/');
                }
            }
        }
        return s1;
    }

    public static void setSourceFile(ClassType classtype, String s)
    {
        Attribute attribute = Attribute.get(classtype, "SourceFile");
        if (attribute != null && (attribute instanceof SourceFileAttr))
        {
            ((SourceFileAttr)attribute).setSourceFile(s);
            return;
        } else
        {
            (new SourceFileAttr(s)).addToFrontOf(classtype);
            return;
        }
    }

    public void assignConstants(ClassType classtype)
    {
        super.assignConstants(classtype);
        if (filename_index == 0)
        {
            filename_index = classtype.getConstants().addUtf8(filename).getIndex();
        }
    }

    public final int getLength()
    {
        return 2;
    }

    public String getSourceFile()
    {
        return filename;
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.print(getLength());
        classtypewriter.print(", ");
        classtypewriter.printOptionalIndex(filename_index);
        classtypewriter.print('"');
        classtypewriter.print(getSourceFile());
        classtypewriter.println('"');
    }

    public void setSourceFile(String s)
    {
        filename = s;
        filename_index = 0;
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(filename_index);
    }
}
