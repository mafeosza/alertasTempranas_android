// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            MiscAttr, ClassTypeWriter, CpoolEntry, CpoolValue1, 
//            AttrContainer

public class RuntimeAnnotationsAttr extends MiscAttr
{

    int numEntries;

    public RuntimeAnnotationsAttr(String s, byte abyte0[], AttrContainer attrcontainer)
    {
        super(s, abyte0, 0, abyte0.length);
        addToFrontOf(attrcontainer);
        numEntries = u2(0);
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.print(getLength());
        classtypewriter.print(", number of entries: ");
        classtypewriter.println(numEntries);
        int j = offset;
        offset = j + 2;
        for (int i = 0; i < numEntries; i++)
        {
            printAnnotation(2, classtypewriter);
        }

        offset = j;
    }

    public void printAnnotation(int i, ClassTypeWriter classtypewriter)
    {
        int j = u2();
        classtypewriter.printSpaces(i);
        classtypewriter.printOptionalIndex(j);
        classtypewriter.print('@');
        classtypewriter.printContantUtf8AsClass(j);
        j = u2();
        classtypewriter.println();
        int k = i + 2;
        for (i = 0; i < j; i++)
        {
            int l = u2();
            classtypewriter.printSpaces(k);
            classtypewriter.printOptionalIndex(l);
            classtypewriter.printConstantTersely(l, 1);
            classtypewriter.print(" => ");
            printAnnotationElementValue(k, classtypewriter);
            classtypewriter.println();
        }

    }

    public void printAnnotationElementValue(int i, ClassTypeWriter classtypewriter)
    {
        byte byte0;
        byte byte1;
        byte byte2;
        byte byte3;
        boolean flag;
        int j1;
        j1 = u1();
        if ((classtypewriter.flags & 8) != 0)
        {
            classtypewriter.print("[kind:");
            if (j1 >= 65 && j1 <= 122)
            {
                classtypewriter.print((char)j1);
            } else
            {
                classtypewriter.print(j1);
            }
            classtypewriter.print("] ");
        }
        byte0 = 0;
        byte1 = 0;
        byte2 = 0;
        flag = false;
        byte3 = flag;
        j1;
        JVM INSTR lookupswitch 13: default 180
    //                   64: 439
    //                   66: 190
    //                   67: 190
    //                   68: 213
    //                   70: 226
    //                   73: 190
    //                   74: 201
    //                   83: 190
    //                   90: 190
    //                   91: 459
    //                   99: 423
    //                   101: 335
    //                   115: 238;
           goto _L1 _L2 _L3 _L3 _L4 _L5 _L3 _L6 _L3 _L3 _L7 _L8 _L9 _L10
_L1:
        return;
_L3:
        byte3 = flag;
        if (true)
        {
            byte3 = 3;
        }
_L6:
        byte0 = byte3;
        if (byte3 == 0)
        {
            byte0 = 5;
        }
_L4:
        byte1 = byte0;
        if (byte0 == 0)
        {
            byte1 = 6;
        }
_L5:
        byte2 = byte1;
        if (byte1 == 0)
        {
            byte2 = 4;
        }
_L10:
        i = byte2;
        if (byte2 == 0)
        {
            i = 1;
        }
        int j = u2();
        Object obj = classtypewriter.getCpoolEntry(j);
        classtypewriter.printOptionalIndex(((CpoolEntry) (obj)));
        if (j1 == 90 && obj != null && ((CpoolEntry) (obj)).getTag() == 3)
        {
            obj = (CpoolValue1)obj;
            if (((CpoolValue1) (obj)).value == 0 || ((CpoolValue1) (obj)).value == 1)
            {
                if (((CpoolValue1) (obj)).value == 0)
                {
                    obj = "false";
                } else
                {
                    obj = "true";
                }
                classtypewriter.print(((String) (obj)));
                return;
            }
        }
        classtypewriter.printConstantTersely(j, i);
        return;
_L9:
        i = u2();
        int k = u2();
        classtypewriter.print("enum[");
        if ((classtypewriter.flags & 8) != 0)
        {
            classtypewriter.print("type:");
        }
        classtypewriter.printOptionalIndex(i);
        classtypewriter.printContantUtf8AsClass(i);
        if ((classtypewriter.flags & 8) != 0)
        {
            classtypewriter.print(" value:");
        } else
        {
            classtypewriter.print(' ');
        }
        classtypewriter.printOptionalIndex(k);
        classtypewriter.printConstantTersely(k, 1);
        classtypewriter.print("]");
        return;
_L8:
        i = u2();
        classtypewriter.printOptionalIndex(i);
        classtypewriter.printContantUtf8AsClass(i);
        return;
_L2:
        classtypewriter.println();
        classtypewriter.printSpaces(i + 2);
        printAnnotation(i + 2, classtypewriter);
        return;
_L7:
        int i1 = u2();
        classtypewriter.print("array length:");
        classtypewriter.print(i1);
        int l = 0;
        while (l < i1) 
        {
            classtypewriter.println();
            classtypewriter.printSpaces(i + 2);
            classtypewriter.print(l);
            classtypewriter.print(": ");
            printAnnotationElementValue(i + 2, classtypewriter);
            l++;
        }
        if (true) goto _L1; else goto _L11
_L11:
    }
}
