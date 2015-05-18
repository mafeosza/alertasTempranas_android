// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.util.Log;
import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.text.FilePath;
import java.io.IOException;
import java.net.Socket;
import kawa.Shell;
import kawa.Telnet;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            BiggerFuture

public class TelnetRepl extends Procedure0
{

    private static final int REPL_STACK_SIZE = 0x40000;
    Language language;
    Socket socket;

    public TelnetRepl(Language language1, Socket socket1)
    {
        language = language1;
        socket = socket1;
    }

    public static Thread serve(Language language1, Socket socket1)
        throws IOException
    {
        Object obj1 = new Telnet(socket1, true);
        Object obj = ((Telnet) (obj1)).getOutputStream();
        obj1 = ((Telnet) (obj1)).getInputStream();
        obj = new OutPort(((java.io.OutputStream) (obj)), FilePath.valueOf("/dev/stdout"));
        obj1 = new TtyInPort(((java.io.InputStream) (obj1)), FilePath.valueOf("/dev/stdin"), ((OutPort) (obj)));
        language1 = new BiggerFuture(new TelnetRepl(language1, socket1), ((gnu.mapping.InPort) (obj1)), ((OutPort) (obj)), ((OutPort) (obj)), "Telnet Repl Thread", 0x40000L);
        language1.start();
        return language1;
    }

    public Object apply0()
    {
        Thread thread = Thread.currentThread();
        if (thread.getContextClassLoader() == null)
        {
            thread.setContextClassLoader(kawa/Telnet.getClassLoader());
        }
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
        Log.d("TelnetRepl", (new StringBuilder()).append("Repl is exiting with error ").append(((RuntimeException) (obj)).getMessage()).toString());
        ((RuntimeException) (obj)).printStackTrace();
        throw obj;
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
