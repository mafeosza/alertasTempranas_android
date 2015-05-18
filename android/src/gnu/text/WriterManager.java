// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.Writer;
import java.lang.reflect.Method;

// Referenced classes of package gnu.text:
//            WriterRef

public class WriterManager
    implements Runnable
{

    public static final WriterManager instance = new WriterManager();
    WriterRef first;

    public WriterManager()
    {
    }

    public WriterRef register(Writer writer)
    {
        this;
        JVM INSTR monitorenter ;
        WriterRef writerref;
        writer = new WriterRef(writer);
        writerref = first;
        if (writerref == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        writer.next = writerref.next;
        writerref.prev = writer;
        first = writer;
        this;
        JVM INSTR monitorexit ;
        return writer;
        writer;
        throw writer;
    }

    public boolean registerShutdownHook()
    {
        try
        {
            Runtime runtime = Runtime.getRuntime();
            runtime.getClass().getDeclaredMethod("addShutdownHook", new Class[] {
                java/lang/Thread
            }).invoke(runtime, new Object[] {
                new Thread(this)
            });
        }
        catch (Throwable throwable)
        {
            return false;
        }
        return true;
    }

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        WriterRef writerref = first;
_L1:
        if (writerref == null)
        {
            break MISSING_BLOCK_LABEL_35;
        }
        Object obj = writerref.get();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        Exception exception;
        try
        {
            ((Writer)obj).close();
        }
        catch (Exception exception1) { }
        writerref = writerref.next;
          goto _L1
        first = null;
        this;
        JVM INSTR monitorexit ;
        return;
        exception;
        throw exception;
    }

    public void unregister(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (obj != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        WriterRef writerref;
        WriterRef writerref1;
        obj = (WriterRef)obj;
        writerref = ((WriterRef) (obj)).next;
        writerref1 = ((WriterRef) (obj)).prev;
        if (writerref == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        writerref.prev = writerref1;
        if (writerref1 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        writerref1.next = writerref;
        if (obj == first)
        {
            first = writerref;
        }
        if (true) goto _L1; else goto _L3
_L3:
        obj;
        throw obj;
    }

}
