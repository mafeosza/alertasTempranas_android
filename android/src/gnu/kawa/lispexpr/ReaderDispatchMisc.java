// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.bytecode.Type;
import gnu.expr.Keyword;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.util.regex.Pattern;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReadTableEntry, LispReader, ReadTable

public class ReaderDispatchMisc extends ReadTableEntry
{

    private static ReaderDispatchMisc instance = new ReaderDispatchMisc();
    protected int code;

    public ReaderDispatchMisc()
    {
        code = -1;
    }

    public ReaderDispatchMisc(int i)
    {
        code = i;
    }

    public static ReaderDispatchMisc getInstance()
    {
        return instance;
    }

    public static Pattern readRegex(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        char c;
        LineBufferedReader linebufferedreader;
        boolean flag;
        int l;
        l = lexer.tokenBufferLength;
        linebufferedreader = lexer.getPort();
        c = '\0';
        flag = false;
        if (linebufferedreader instanceof InPort)
        {
            c = ((InPort)linebufferedreader).readState;
            ((InPort)linebufferedreader).readState = '/';
        }
_L8:
        j = linebufferedreader.read();
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        lexer.eofError("unexpected EOF in regex literal");
        if (j != i) goto _L2; else goto _L1
_L1:
        Object obj = new String(lexer.tokenBuffer, l, lexer.tokenBufferLength - l);
        i = ((flag) ? 1 : 0);
_L3:
        j = lexer.peek();
        int k;
        if (j == 105 || j == 73)
        {
            i |= 0x42;
        } else
        {
            if (j != 115 && j != 83)
            {
                continue; /* Loop/switch isn't completed */
            }
            i |= 0x20;
        }
_L11:
        lexer.skip();
          goto _L3
        obj;
        lexer.tokenBufferLength = l;
        if (linebufferedreader instanceof InPort)
        {
            ((InPort)linebufferedreader).readState = c;
        }
        throw obj;
_L2:
        k = j;
        if (j != 92)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        k = linebufferedreader.read();
        if (k == 32 || k == 9 || k == 13) goto _L5; else goto _L4
_L4:
        j = k;
        if (k != 10) goto _L6; else goto _L5
_L5:
        j = k;
        if (!(lexer instanceof LispReader)) goto _L6; else goto _L7
_L7:
        j = ((LispReader)lexer).readEscape(k);
        if (j == -2) goto _L8; else goto _L6
_L6:
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        lexer.eofError("unexpected EOF in regex literal");
        k = j;
        if (j == i)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        lexer.tokenBufferAppend(92);
        k = j;
        lexer.tokenBufferAppend(k);
          goto _L8
_L10:
label0:
        {
            if (!Character.isLetter(j))
            {
                break label0;
            }
            lexer.error((new StringBuilder()).append("unrecognized regex option '").append((char)j).append('\'').toString());
        }
        break MISSING_BLOCK_LABEL_110;
        obj = Pattern.compile(((String) (obj)), i);
        lexer.tokenBufferLength = l;
        if (linebufferedreader instanceof InPort)
        {
            ((InPort)linebufferedreader).readState = c;
        }
        return ((Pattern) (obj));
        if (j != 109 && j != 77) goto _L10; else goto _L9
_L9:
        i |= 8;
          goto _L11
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        char c;
        boolean flag;
        Object obj;
        obj = (LispReader)lexer;
        flag = false;
        c = '\0';
        if (code >= 0)
        {
            i = code;
        }
        i;
        JVM INSTR lookupswitch 20: default 196
    //                   33: 274
    //                   35: 942
    //                   44: 588
    //                   47: 418
    //                   58: 210
    //                   59: 506
    //                   61: 875
    //                   66: 389
    //                   68: 371
    //                   69: 397
    //                   70: 284
    //                   73: 397
    //                   79: 380
    //                   82: 315
    //                   83: 307
    //                   84: 280
    //                   85: 307
    //                   88: 362
    //                   92: 268
    //                   124: 425;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L11 _L13 _L14 _L15 _L16 _L15 _L17 _L18 _L19
_L1:
        lexer.error("An invalid #-construct was read.");
        obj = Values.empty;
_L31:
        return obj;
_L6:
        i = ((LispReader) (obj)).tokenBufferLength;
        ((LispReader) (obj)).readToken(((LispReader) (obj)).read(), 'P', ReadTable.getCurrent());
        j = ((LispReader) (obj)).tokenBufferLength;
        lexer = new String(((LispReader) (obj)).tokenBuffer, i, j - i);
        obj.tokenBufferLength = i;
        return Keyword.make(lexer.intern());
_L18:
        return LispReader.readCharacter(((LispReader) (obj)));
_L2:
        return LispReader.readSpecial(((LispReader) (obj)));
_L16:
        return Boolean.TRUE;
_L12:
        if (Character.isDigit((char)lexer.peek()))
        {
            return LispReader.readSimpleVector(((LispReader) (obj)), 'F');
        } else
        {
            return Boolean.FALSE;
        }
_L15:
        return LispReader.readSimpleVector(((LispReader) (obj)), (char)i);
_L14:
        i = j;
        if (j > 36)
        {
            lexer.error((new StringBuilder()).append("the radix ").append(j).append(" is too big (max is 36)").toString());
            i = 36;
        }
        return LispReader.readNumberWithRadix(0, ((LispReader) (obj)), i);
_L17:
        return LispReader.readNumberWithRadix(0, ((LispReader) (obj)), 16);
_L10:
        return LispReader.readNumberWithRadix(0, ((LispReader) (obj)), 10);
_L13:
        return LispReader.readNumberWithRadix(0, ((LispReader) (obj)), 8);
_L9:
        return LispReader.readNumberWithRadix(0, ((LispReader) (obj)), 2);
_L11:
        ((LispReader) (obj)).tokenBufferAppend(35);
        ((LispReader) (obj)).tokenBufferAppend(i);
        return LispReader.readNumberWithRadix(2, ((LispReader) (obj)), 0);
_L5:
        return readRegex(lexer, i, j);
_L19:
        lexer = ((LispReader) (obj)).getPort();
        if (lexer instanceof InPort)
        {
            c = ((InPort)lexer).readState;
            ((InPort)lexer).readState = '|';
        }
        ((LispReader) (obj)).readNestedComment('#', '|');
        if (lexer instanceof InPort)
        {
            ((InPort)lexer).readState = c;
        }
        return Values.empty;
        obj;
        if (lexer instanceof InPort)
        {
            ((InPort)lexer).readState = c;
        }
        throw obj;
_L7:
        lexer = ((LispReader) (obj)).getPort();
        c = flag;
        if (lexer instanceof InPort)
        {
            c = ((InPort)lexer).readState;
            ((InPort)lexer).readState = ';';
        }
        ((LispReader) (obj)).readObject();
        if (lexer instanceof InPort)
        {
            ((InPort)lexer).readState = c;
        }
        return Values.empty;
        obj;
        if (lexer instanceof InPort)
        {
            ((InPort)lexer).readState = c;
        }
        throw obj;
_L4:
        if (((LispReader) (obj)).getPort().peek() != 40) goto _L21; else goto _L20
_L20:
        obj = ((LispReader) (obj)).readObject();
        i = LList.listLength(obj, false);
        if (i <= 0 || !(((Pair)obj).getCar() instanceof Symbol)) goto _L21; else goto _L22
_L22:
        Object obj1;
        Object obj2;
        obj1 = ((Pair)obj).getCar().toString();
        obj2 = ReadTable.getCurrent().getReaderCtor(((String) (obj1)));
        if (obj2 != null) goto _L24; else goto _L23
_L23:
        lexer.error((new StringBuilder()).append("unknown reader constructor ").append(((String) (obj1))).toString());
_L27:
        return Boolean.FALSE;
_L24:
        if ((obj2 instanceof Procedure) || (obj2 instanceof Type)) goto _L26; else goto _L25
_L25:
        lexer.error("reader constructor must be procedure or type name");
          goto _L27
_L26:
        Object aobj[];
        int k = i - 1;
        if (obj2 instanceof Type)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        aobj = new Object[i + k];
        obj = ((Pair)obj).getCdr();
        for (j = 0; j < k; j++)
        {
            obj = (Pair)obj;
            aobj[i + j] = ((Pair) (obj)).getCar();
            obj = ((Pair) (obj)).getCdr();
        }

        if (i <= 0) goto _L29; else goto _L28
_L28:
        aobj[0] = obj2;
        return Invoke.make.applyN(aobj);
_L29:
        obj = ((Procedure)obj2).applyN(aobj);
        return obj;
        obj;
        lexer.error((new StringBuilder()).append("caught ").append(obj).append(" applying reader constructor ").append(((String) (obj1))).toString());
          goto _L27
_L21:
        lexer.error("a non-empty list starting with a symbol must follow #,");
          goto _L27
_L8:
        obj1 = ((LispReader) (obj)).readObject();
        obj = obj1;
        if (!(lexer instanceof LispReader)) goto _L31; else goto _L30
_L30:
        LispReader lispreader = (LispReader)lexer;
        obj = lispreader.sharedStructureTable;
        lexer = ((Lexer) (obj));
        if (obj == null)
        {
            lexer = new GeneralHashTable();
            lispreader.sharedStructureTable = lexer;
        }
        lexer.put(Integer.valueOf(j), obj1);
        return obj1;
_L3:
        if (!(lexer instanceof LispReader))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((LispReader)lexer).sharedStructureTable;
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = ((GeneralHashTable) (obj)).get(Integer.valueOf(j), lexer);
        obj = obj1;
        if (obj1 != lexer) goto _L31; else goto _L32
_L32:
        lexer.error("an unrecognized #n# back-reference was read");
        return Values.empty;
    }

}
