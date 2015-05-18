// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.text.NullReader;
import gnu.text.Path;
import java.io.IOException;

// Referenced classes of package gnu.mapping:
//            InPort

public class CharArrayInPort extends InPort
{

    static final Path stringPath = Path.valueOf("<string>");

    public CharArrayInPort(String s)
    {
        this(s.toCharArray());
    }

    public CharArrayInPort(char ac[])
    {
        this(ac, ac.length);
    }

    public CharArrayInPort(char ac[], int i)
    {
        super(NullReader.nullReader, stringPath);
        try
        {
            setBuffer(ac);
        }
        // Misplaced declaration of an exception variable
        catch (char ac[])
        {
            throw new Error(ac.toString());
        }
        limit = i;
    }

    public CharArrayInPort make(CharSequence charsequence)
    {
        char ac[];
        int j;
        if (charsequence instanceof FString)
        {
            charsequence = (FString)charsequence;
            return new CharArrayInPort(((FString) (charsequence)).data, ((FString) (charsequence)).size);
        }
        j = charsequence.length();
        ac = new char[j];
        if (!(charsequence instanceof String)) goto _L2; else goto _L1
_L1:
        ((String)charsequence).getChars(0, j, ac, 0);
_L4:
        return new CharArrayInPort(ac, j);
_L2:
        if (!(charsequence instanceof CharSeq))
        {
            int i = j;
            do
            {
                i--;
                if (i < 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                ac[i] = charsequence.charAt(i);
            } while (true);
        }
        ((CharSeq)charsequence).getChars(0, j, ac, 0);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int read()
        throws IOException
    {
        if (pos >= limit)
        {
            return -1;
        } else
        {
            return super.read();
        }
    }

}
