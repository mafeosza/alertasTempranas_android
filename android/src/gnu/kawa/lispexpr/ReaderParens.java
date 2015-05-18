// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReadTableEntry, LispReader, ReadTable

public class ReaderParens extends ReadTableEntry
{

    private static ReaderParens instance;
    char close;
    Object command;
    int kind;
    char open;

    public ReaderParens(char c, char c1, int i, Object obj)
    {
        open = c;
        close = c1;
        kind = i;
        command = obj;
    }

    public static ReaderParens getInstance(char c, char c1)
    {
        return getInstance(c, c1, 5);
    }

    public static ReaderParens getInstance(char c, char c1, int i)
    {
        if (c == '(' && c1 == ')' && i == 5)
        {
            if (instance == null)
            {
                instance = new ReaderParens(c, c1, i, null);
            }
            return instance;
        } else
        {
            return new ReaderParens(c, c1, i, null);
        }
    }

    public static ReaderParens getInstance(char c, char c1, int i, Object obj)
    {
        if (obj == null)
        {
            return getInstance(c, c1, i);
        } else
        {
            return new ReaderParens(c, c1, i, obj);
        }
    }

    public static Object readList(LispReader lispreader, int i, int j, int k)
        throws IOException, SyntaxException
    {
        char c;
        Object obj;
        Object obj1;
        LineBufferedReader linebufferedreader;
        ReadTable readtable;
        int l;
        int j1;
        int k1;
        int l1;
        int i2;
        linebufferedreader = lispreader.getPort();
        if (k == 93)
        {
            c = '[';
        } else
        {
            c = '(';
        }
        c = lispreader.pushNesting(c);
        k1 = linebufferedreader.getLineNumber();
        i2 = linebufferedreader.getColumnNumber();
        obj1 = null;
        obj = lispreader.makeNil();
        j = 0;
        i = 0;
        readtable = ReadTable.getCurrent();
_L11:
        l1 = linebufferedreader.getLineNumber();
        l = linebufferedreader.getColumnNumber();
        j1 = linebufferedreader.read();
        if (j1 != k) goto _L2; else goto _L1
_L1:
        lispreader.popNesting(c);
        return obj;
_L2:
        if (j1 >= 0)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        lispreader.eofError("unexpected EOF in list starting here", k1 + 1, i2);
        if (j1 != 46) goto _L4; else goto _L3
_L3:
        Object obj2;
        int i1;
        i1 = linebufferedreader.peek();
        obj2 = readtable.lookup(i1);
        j1 = ((ReadTableEntry) (obj2)).getKind();
        if (j1 != 1 && j1 != 5 && j1 != 0) goto _L6; else goto _L5
_L5:
        linebufferedreader.skip();
        l++;
        if (i1 != k)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        lispreader.error((new StringBuilder()).append("unexpected '").append((char)k).append("' after '.'").toString());
          goto _L1
        obj;
        lispreader.popNesting(c);
        throw obj;
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        lispreader.eofError("unexpected EOF in list starting here", k1 + 1, i2);
        if (j == 0) goto _L8; else goto _L7
_L7:
        lispreader.error("multiple '.' in list");
        i = 0;
        obj = lispreader.makeNil();
        obj1 = null;
          goto _L8
_L13:
        Object obj3;
        obj1 = lispreader.readValues(j, ((ReadTableEntry) (obj3)), readtable);
        if (obj1 != Values.empty) goto _L10; else goto _L9
_L9:
        obj1 = obj2;
        j = i1;
          goto _L11
_L6:
        j1 = 46;
        obj2 = ReadTableEntry.getConstituentInstance();
        i1 = j;
        j = j1;
          goto _L12
_L4:
        obj3 = readtable.lookup(j1);
        obj2 = obj1;
        i1 = j;
        j = j1;
          goto _L13
_L10:
        obj1 = lispreader.handlePostfix(obj1, readtable, l1, l);
        if (i == 0) goto _L15; else goto _L14
_L14:
        lispreader.error("multiple values after '.'");
        obj1 = null;
        obj = lispreader.makeNil();
        i = 0;
        j = i1;
          goto _L11
_L20:
        obj1 = lispreader.makePair(obj1, j, l);
          goto _L16
_L19:
        lispreader.setCdr(obj2, obj1);
          goto _L17
_L8:
        boolean flag = true;
        j = i1;
        i1 = ((flag) ? 1 : 0);
_L12:
        obj3 = obj2;
        obj2 = obj1;
          goto _L13
_L15:
        if (i1 == 0)
        {
            break MISSING_BLOCK_LABEL_442;
        }
        i = 1;
_L16:
        if (obj2 != null) goto _L19; else goto _L18
_L18:
        obj = obj1;
_L17:
        j = i1;
          goto _L11
        j = l1;
        if (obj2 == null)
        {
            j = k1;
            l = i2 - 1;
        }
          goto _L20
    }

    public int getKind()
    {
        return kind;
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        Object obj1 = readList((LispReader)lexer, i, j, close);
        Object obj = obj1;
        if (command != null)
        {
            obj = lexer.getPort();
            i = ((LineBufferedReader) (obj)).getLineNumber();
            j = ((LineBufferedReader) (obj)).getColumnNumber();
            obj = ((LispReader)lexer).makePair(command, i, j);
            ((LispReader)lexer).setCdr(obj, obj1);
        }
        return obj;
    }
}
