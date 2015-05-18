// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import gnu.lists.CharSeq;
import java.io.IOException;
import java.io.Reader;

public class QueueReader extends Reader
    implements Appendable
{

    boolean EOFseen;
    char buffer[];
    int limit;
    int mark;
    int pos;
    int readAheadLimit;

    public QueueReader()
    {
    }

    public QueueReader append(char c)
    {
        this;
        JVM INSTR monitorenter ;
        char ac[];
        int i;
        reserveSpace(1);
        ac = buffer;
        i = limit;
        limit = i + 1;
        ac[i] = c;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return this;
        Exception exception;
        exception;
        throw exception;
    }

    public QueueReader append(CharSequence charsequence)
    {
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        return append(((CharSequence) (obj)), 0, ((CharSequence) (obj)).length());
    }

    public QueueReader append(CharSequence charsequence, int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        int i1;
        obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        i1 = j - i;
        int l;
        reserveSpace(i1);
        l = limit;
        charsequence = buffer;
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        ((String)obj).getChars(i, j, charsequence, l);
_L6:
        limit = l + i1;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return this;
_L2:
        if (obj instanceof CharSeq)
        {
            ((CharSeq)obj).getChars(i, j, charsequence, l);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_104;
        charsequence;
        throw charsequence;
        int k;
        k = i;
        i = l;
_L4:
        if (k >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        charsequence[i] = ((CharSequence) (obj)).charAt(k);
        k++;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public volatile Appendable append(char c)
        throws IOException
    {
        return append(c);
    }

    public volatile Appendable append(CharSequence charsequence)
        throws IOException
    {
        return append(charsequence);
    }

    public volatile Appendable append(CharSequence charsequence, int i, int j)
        throws IOException
    {
        return append(charsequence, i, j);
    }

    public void append(char ac[])
    {
        append(ac, 0, ac.length);
    }

    public void append(char ac[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        reserveSpace(j);
        System.arraycopy(ac, i, buffer, limit, j);
        limit = limit + j;
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        ac;
        throw ac;
    }

    public void appendEOF()
    {
        this;
        JVM INSTR monitorenter ;
        EOFseen = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void checkAvailable()
    {
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        pos = 0;
        limit = 0;
        mark = 0;
        EOFseen = true;
        buffer = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void mark(int i)
    {
        this;
        JVM INSTR monitorenter ;
        readAheadLimit = i;
        mark = pos;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean markSupported()
    {
        return true;
    }

    public int read()
    {
        this;
        JVM INSTR monitorenter ;
_L8:
        if (pos < limit) goto _L2; else goto _L1
_L1:
        boolean flag = EOFseen;
        if (!flag) goto _L4; else goto _L3
_L3:
        int i = -1;
_L6:
        this;
        JVM INSTR monitorexit ;
        return i;
_L4:
        checkAvailable();
        try
        {
            wait();
        }
        catch (InterruptedException interruptedexception) { }
        continue; /* Loop/switch isn't completed */
_L2:
        char ac[];
        ac = buffer;
        i = pos;
        pos = i + 1;
        i = ac[i];
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public int read(char ac[], int i, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (j != 0) goto _L2; else goto _L1
_L1:
        i = 0;
_L8:
        this;
        JVM INSTR monitorexit ;
        return i;
_L6:
        checkAvailable();
        int k;
        int l;
        try
        {
            wait();
        }
        catch (InterruptedException interruptedexception) { }
_L2:
        if (pos < limit) goto _L4; else goto _L3
_L3:
        if (!EOFseen) goto _L6; else goto _L5
_L5:
        i = -1;
        continue; /* Loop/switch isn't completed */
_L4:
        l = limit - pos;
        k = j;
        if (j > l)
        {
            k = l;
        }
        System.arraycopy(buffer, pos, ac, i, k);
        pos = pos + k;
        i = k;
        if (true) goto _L8; else goto _L7
_L7:
        ac;
        throw ac;
    }

    public boolean ready()
    {
        this;
        JVM INSTR monitorenter ;
        if (pos < limit) goto _L2; else goto _L1
_L1:
        boolean flag = EOFseen;
        if (!flag) goto _L3; else goto _L2
_L2:
        flag = true;
_L5:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L3:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    protected void reserveSpace(int i)
    {
        if (buffer == null)
        {
            buffer = new char[i + 100];
        } else
        if (buffer.length < limit + i)
        {
            resize(i);
            return;
        }
    }

    public void reset()
    {
        this;
        JVM INSTR monitorenter ;
        if (readAheadLimit > 0)
        {
            pos = mark;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void resize(int i)
    {
        int j = limit - pos;
        char ac[];
        if (readAheadLimit > 0 && pos - mark <= readAheadLimit)
        {
            j = limit - mark;
        } else
        {
            mark = pos;
        }
        if (buffer.length < j + i)
        {
            ac = new char[j * 2 + i];
        } else
        {
            ac = buffer;
        }
        System.arraycopy(buffer, mark, ac, 0, j);
        buffer = ac;
        pos = pos - mark;
        mark = 0;
        limit = j;
    }
}
