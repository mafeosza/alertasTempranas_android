// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa;

import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.Future;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.text.FilePath;
import java.io.IOException;
import java.net.Socket;

// Referenced classes of package kawa:
//            Telnet, Shell

public class TelnetRepl extends Procedure0
{

    Language language;
    Socket socket;

    public TelnetRepl(Language language1, Socket socket1)
    {
        language = language1;
        socket = socket1;
    }

    public static void serve(Language language1, Socket socket1)
        throws IOException
    {
        Object obj1 = new Telnet(socket1, true);
        Object obj = ((Telnet) (obj1)).getOutputStream();
        obj1 = ((Telnet) (obj1)).getInputStream();
        obj = new OutPort(((java.io.OutputStream) (obj)), FilePath.valueOf("/dev/stdout"));
        obj1 = new TtyInPort(((java.io.InputStream) (obj1)), FilePath.valueOf("/dev/stdin"), ((OutPort) (obj)));
        (new Future(new TelnetRepl(language1, socket1), ((gnu.mapping.InPort) (obj1)), ((OutPort) (obj)), ((OutPort) (obj)))).start();
    }

    public Object apply0()
    {
        Object obj;
        Shell.run(language, Environment.getCurrent());
        obj = Values.empty;
        IOException ioexception;
        try
        {
            socket.close();
        }
        catch (IOException ioexception1)
        {
            return obj;
        }
        return obj;
        obj;
        try
        {
            socket.close();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception) { }
        throw obj;
    }
}
