// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.expr.QuoteExp;
import gnu.lists.FVector;
import gnu.mapping.InPort;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.Vector;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReadTableEntry, ReadTable, LispReader

public class ReaderVector extends ReadTableEntry
{

    char close;

    public ReaderVector(char c)
    {
        close = c;
    }

    public static FVector readVector(LispReader lispreader, LineBufferedReader linebufferedreader, int i, char c)
        throws IOException, SyntaxException
    {
        char c1;
        Vector vector;
        ReadTable readtable;
        c1 = ' ';
        if (linebufferedreader instanceof InPort)
        {
            char c2 = ((InPort)linebufferedreader).readState;
            InPort inport = (InPort)linebufferedreader;
            if (c == ']')
            {
                c1 = '[';
            } else
            {
                c1 = '(';
            }
            inport.readState = c1;
            c1 = c2;
        }
        vector = new Vector();
        readtable = ReadTable.getCurrent();
_L2:
        i = lispreader.read();
        if (i >= 0)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        lispreader.eofError("unexpected EOF in vector");
        if (i != c)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        lispreader = ((LispReader) (new Object[vector.size()]));
        vector.copyInto(lispreader);
        lispreader = new FVector(lispreader);
        if (linebufferedreader instanceof InPort)
        {
            ((InPort)linebufferedreader).readState = c1;
        }
        return lispreader;
        Object aobj[];
        Object obj1;
        int j;
        obj1 = lispreader.readValues(i, readtable);
        if (!(obj1 instanceof Values))
        {
            break MISSING_BLOCK_LABEL_186;
        }
        aobj = ((Values)obj1).getValues();
        j = aobj.length;
        i = 0;
_L3:
        if (i >= j) goto _L2; else goto _L1
_L1:
        vector.addElement(aobj[i]);
        i++;
          goto _L3
        Object obj = obj1;
        if (obj1 == QuoteExp.voidExp)
        {
            obj = Values.empty;
        }
        vector.addElement(obj);
          goto _L2
        lispreader;
        if (linebufferedreader instanceof InPort)
        {
            ((InPort)linebufferedreader).readState = c1;
        }
        throw lispreader;
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        return readVector((LispReader)lexer, lexer.getPort(), j, close);
    }
}
