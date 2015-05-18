// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.lists.FString;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.InPort;
import gnu.mapping.Procedure1;
import gnu.text.CompoundFormat;
import gnu.text.LineBufferedReader;
import gnu.text.LiteralFormat;
import gnu.text.PadFormat;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.text.Format;
import java.text.ParseException;
import java.util.Vector;

// Referenced classes of package gnu.kawa.functions:
//            LispFormat, ObjectFormat, IntegerFormat

public class ParseFormat extends Procedure1
{

    public static final int PARAM_FROM_LIST = 0xa0000000;
    public static final int PARAM_UNSPECIFIED = 0xc0000000;
    public static final int SEEN_HASH = 16;
    public static final int SEEN_MINUS = 1;
    public static final int SEEN_PLUS = 2;
    public static final int SEEN_SPACE = 4;
    public static final int SEEN_ZERO = 8;
    public static final ParseFormat parseFormat = new ParseFormat(false);
    boolean emacsStyle;

    public ParseFormat(boolean flag)
    {
        emacsStyle = true;
        emacsStyle = flag;
    }

    public static ReportFormat asFormat(Object obj, char c)
    {
        ReportFormat reportformat;
        Exception exception;
        try
        {
            if (obj instanceof ReportFormat)
            {
                return (ReportFormat)obj;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder()).append("Error parsing format (").append(obj).append(")").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder()).append("Invalid format (").append(obj).append(")").toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException("End while parsing format");
        }
        if (c != '~')
        {
            break MISSING_BLOCK_LABEL_30;
        }
        return new LispFormat(obj.toString());
        if (!(obj instanceof FString)) goto _L2; else goto _L1
_L1:
        obj = (FString)obj;
        obj = new CharArrayInPort(((FString) (obj)).data, ((FString) (obj)).size);
_L4:
        reportformat = parseFormat(((LineBufferedReader) (obj)), c);
        ((InPort) (obj)).close();
        return reportformat;
_L2:
        obj = new CharArrayInPort(obj.toString());
        if (true) goto _L4; else goto _L3
_L3:
        exception;
        ((InPort) (obj)).close();
        throw exception;
    }

    public static ReportFormat parseFormat(LineBufferedReader linebufferedreader, char c)
        throws ParseException, IOException
    {
        Vector vector;
        StringBuffer stringbuffer;
        int j;
        stringbuffer = new StringBuffer(100);
        j = 0;
        vector = new Vector();
_L26:
        int k = linebufferedreader.read();
        int i = k;
        if (k >= 0)
        {
            if (k != c)
            {
                stringbuffer.append((char)k);
                continue; /* Loop/switch isn't completed */
            }
            k = linebufferedreader.read();
            i = k;
            if (k == c)
            {
                stringbuffer.append((char)k);
                continue; /* Loop/switch isn't completed */
            }
        }
        k = stringbuffer.length();
        if (k > 0)
        {
            char ac[] = new char[k];
            stringbuffer.getChars(0, k, ac, 0);
            stringbuffer.setLength(0);
            vector.addElement(new LiteralFormat(ac));
        }
        if (i < 0)
        {
            c = vector.size();
            char c1;
            Object obj;
            int l;
            int i1;
            int j1;
            int k1;
            int l1;
            byte byte0;
            boolean flag;
            if (c == '\001')
            {
                linebufferedreader = ((LineBufferedReader) (vector.elementAt(0)));
                if (linebufferedreader instanceof ReportFormat)
                {
                    return (ReportFormat)linebufferedreader;
                }
            }
            linebufferedreader = new Format[c];
            vector.copyInto(linebufferedreader);
            return new CompoundFormat(linebufferedreader);
            continue; /* Loop/switch isn't completed */
        }
        l = i;
        l1 = j;
        if (i == 36)
        {
            j = Character.digit((char)linebufferedreader.read(), 10);
            i = j;
            if (j < 0)
            {
                throw new ParseException("missing number (position) after '%$'", -1);
            }
            do
            {
                l = linebufferedreader.read();
                j = Character.digit((char)l, 10);
                if (j >= 0)
                {
                    i = i * 10 + j;
                } else
                {
                    break;
                }
            } while (true);
            l1 = i - 1;
        }
        i = 0;
_L19:
        (char)l;
        JVM INSTR lookupswitch 5: default 304
    //                   32: 530
    //                   35: 549
    //                   43: 521
    //                   45: 506
    //                   48: 539;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        j = 0xc0000000;
        i1 = Character.digit((char)l, 10);
        if (i1 < 0) goto _L8; else goto _L7
_L7:
        j = i1;
_L21:
        i1 = linebufferedreader.read();
        l = Character.digit((char)i1, 10);
        if (l >= 0) goto _L10; else goto _L9
_L9:
        l = 0xc0000000;
        k1 = i1;
        if (i1 != 46) goto _L12; else goto _L11
_L11:
        if (i1 != 42) goto _L14; else goto _L13
_L13:
        l = 0xa0000000;
        k1 = i1;
_L12:
        k1;
        JVM INSTR lookupswitch 10: default 472
    //                   83: 635
    //                   88: 719
    //                   100: 719
    //                   101: 927
    //                   102: 927
    //                   103: 927
    //                   105: 719
    //                   111: 719
    //                   115: 635
    //                   120: 719;
           goto _L15 _L16 _L17 _L17 _L18 _L18 _L18 _L17 _L17 _L16 _L17
_L15:
        throw new ParseException((new StringBuilder()).append("unknown format character '").append(k1).append("'").toString(), -1);
_L5:
        i |= 1;
_L20:
        l = linebufferedreader.read();
          goto _L19
_L4:
        i |= 2;
          goto _L20
_L2:
        i |= 4;
          goto _L20
_L6:
        i |= 8;
          goto _L20
_L3:
        i |= 0x10;
          goto _L20
_L10:
        j = j * 10 + l;
          goto _L21
_L8:
        i1 = l;
        if (l == 42)
        {
            j = 0xa0000000;
            i1 = l;
        }
          goto _L9
_L14:
        i1 = 0;
_L23:
        k1 = linebufferedreader.read();
        j1 = Character.digit((char)k1, 10);
        l = i1;
        if (j1 < 0) goto _L12; else goto _L22
_L22:
        i1 = i1 * 10 + j1;
          goto _L23
          goto _L12
_L16:
        if (k1 == 83)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = new ObjectFormat(flag, l);
_L24:
        if (j > 0)
        {
            if ((i & 8) != 0)
            {
                c1 = '0';
            } else
            {
                c1 = ' ';
            }
            if ((i & 1) != 0)
            {
                i = 100;
            } else
            if (c1 == '0')
            {
                i = -1;
            } else
            {
                i = 0;
            }
            obj = new PadFormat(((Format) (obj)), j, c1, i);
        }
        vector.addElement(obj);
        j = l1 + 1;
        continue; /* Loop/switch isn't completed */
_L17:
        j1 = 0;
        if (k1 == 100 || k1 == 105)
        {
            i1 = 10;
        } else
        if (k1 == 111)
        {
            i1 = 8;
        } else
        {
            byte0 = 16;
            i1 = byte0;
            if (k1 == 88)
            {
                j1 = 32;
                i1 = byte0;
            }
        }
        if ((i & 9) == 8)
        {
            byte0 = 48;
        } else
        {
            byte0 = 32;
        }
        k1 = j1;
        if ((i & 0x10) != 0)
        {
            k1 = j1 | 8;
        }
        j1 = k1;
        if ((i & 2) != 0)
        {
            j1 = k1 | 2;
        }
        k1 = j1;
        if ((i & 1) != 0)
        {
            k1 = j1 | 0x10;
        }
        j1 = k1;
        if ((i & 4) != 0)
        {
            j1 = k1 | 4;
        }
        if (l != 0xc0000000)
        {
            i &= -9;
            obj = IntegerFormat.getInstance(i1, l, 48, 0xc0000000, 0xc0000000, j1 | 0x40);
        } else
        {
            obj = IntegerFormat.getInstance(i1, j, byte0, 0xc0000000, 0xc0000000, j1);
        }
          goto _L24
_L18:
        obj = new ObjectFormat(false);
          goto _L24
        if (true) goto _L26; else goto _L25
_L25:
    }

    public Object apply1(Object obj)
    {
        char c;
        if (emacsStyle)
        {
            c = '?';
        } else
        {
            c = '~';
        }
        return asFormat(obj, c);
    }

    public ReportFormat parseFormat(LineBufferedReader linebufferedreader)
        throws ParseException, IOException
    {
        char c;
        if (emacsStyle)
        {
            c = '?';
        } else
        {
            c = '~';
        }
        return parseFormat(linebufferedreader, c);
    }

}
