// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.lists.Sequence;
import gnu.mapping.InPort;
import gnu.mapping.Procedure0or1;
import gnu.mapping.WrongType;
import gnu.text.Char;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class readchar extends Procedure0or1
{

    public static final readchar peekChar = new readchar(true);
    public static final readchar readChar = new readchar(false);
    boolean peeking;

    public readchar(boolean flag)
    {
        String s;
        if (flag)
        {
            s = "peek-char";
        } else
        {
            s = "read-char";
        }
        super(s);
        peeking = flag;
    }

    public final Object apply0()
    {
        return readChar(InPort.inDefault());
    }

    public final Object apply1(Object obj)
    {
        if (obj instanceof InPort)
        {
            return readChar((InPort)obj);
        }
        if (obj instanceof Reader)
        {
            return readChar((Reader)obj);
        }
        if (obj instanceof InputStream)
        {
            return readChar((InputStream)obj);
        } else
        {
            throw new WrongType(this, 1, obj, "<input-port>");
        }
    }

    final Object readChar(InPort inport)
    {
        if (!peeking) goto _L2; else goto _L1
_L1:
        int i = inport.peek();
_L4:
        if (i >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        return Sequence.eofValue;
_L2:
        i = inport.read();
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            inport = Char.make(i);
        }
        // Misplaced declaration of an exception variable
        catch (InPort inport)
        {
            throw new RuntimeException("IO Exception caught");
        }
        return inport;
    }

    final Object readChar(InputStream inputstream)
    {
        if (!peeking) goto _L2; else goto _L1
_L1:
        int i;
        inputstream.mark(1);
        i = inputstream.read();
        inputstream.reset();
_L4:
        if (i >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        return Sequence.eofValue;
_L2:
        i = inputstream.read();
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            inputstream = Char.make(i);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw new RuntimeException("IO Exception caught");
        }
        return inputstream;
    }

    final Object readChar(Reader reader)
    {
        if (!peeking) goto _L2; else goto _L1
_L1:
        int i;
        reader.mark(1);
        i = reader.read();
        reader.reset();
_L4:
        if (i >= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        return Sequence.eofValue;
_L2:
        i = reader.read();
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            reader = Char.make(i);
        }
        // Misplaced declaration of an exception variable
        catch (Reader reader)
        {
            throw new RuntimeException("IO Exception caught");
        }
        return reader;
    }

}
