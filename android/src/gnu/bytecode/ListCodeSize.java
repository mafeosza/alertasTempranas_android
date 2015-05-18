// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

// Referenced classes of package gnu.bytecode:
//            ClassType, ClassFileInput, Method, Type, 
//            CodeAttr

public class ListCodeSize
{

    public ListCodeSize()
    {
    }

    public static final void main(String args[])
    {
        String s;
        if (args.length == 0)
        {
            usage();
        }
        s = args[0];
        ClassType classtype;
        FileInputStream fileinputstream = new FileInputStream(s);
        classtype = new ClassType();
        new ClassFileInput(classtype, fileinputstream);
        if (args.length != 1) goto _L2; else goto _L1
_L1:
        args = classtype.getMethods();
_L4:
        if (args == null)
        {
            break; /* Loop/switch isn't completed */
        }
        print(args);
        args = args.getNext();
        if (true) goto _L4; else goto _L3
_L9:
        int i;
        if (i >= args.length) goto _L3; else goto _L5
_L5:
        Method method = classtype.getMethods();
_L7:
        if (method == null)
        {
            break; /* Loop/switch isn't completed */
        }
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(method.getName());
        method.listParameters(stringbuffer);
        stringbuffer.append(method.getReturnType().getName());
        if (stringbuffer.toString().startsWith(args[i]))
        {
            print(method);
        }
        method = method.getNext();
        if (true) goto _L7; else goto _L6
_L6:
        i++;
        continue; /* Loop/switch isn't completed */
        args;
        System.err.println((new StringBuilder()).append("File ").append(s).append(" not found").toString());
        System.exit(-1);
_L3:
        return;
        args;
        System.err.println(args);
        args.printStackTrace();
        System.exit(-1);
        return;
_L2:
        i = 1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    static void print(Method method)
    {
        System.out.print(method);
        method = method.getCode();
        if (method == null)
        {
            System.out.print(": no code");
        } else
        {
            System.out.print(": ");
            System.out.print(method.getPC());
            System.out.print(" bytes");
        }
        System.out.println();
    }

    public static void usage()
    {
        System.err.println("Usage: class methodname ...");
        System.exit(-1);
    }
}
