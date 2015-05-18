// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.expr.Special;
import gnu.kawa.util.GeneralHashTable;
import gnu.lists.Convert;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.S16Vector;
import gnu.lists.S32Vector;
import gnu.lists.S64Vector;
import gnu.lists.S8Vector;
import gnu.lists.Sequence;
import gnu.lists.SimpleVector;
import gnu.lists.U16Vector;
import gnu.lists.U32Vector;
import gnu.lists.U64Vector;
import gnu.lists.U8Vector;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.Complex;
import gnu.math.DComplex;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.math.BigDecimal;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReadTable, ReaderParens, ReaderIgnoreRestOfLine, LispLanguage, 
//            ReadTableEntry

public class LispReader extends Lexer
{

    static final int SCM_COMPLEX = 1;
    public static final int SCM_NUMBERS = 1;
    public static final char TOKEN_ESCAPE_CHAR = 65535;
    protected boolean seenEscapes;
    GeneralHashTable sharedStructureTable;

    public LispReader(LineBufferedReader linebufferedreader)
    {
        super(linebufferedreader);
    }

    public LispReader(LineBufferedReader linebufferedreader, SourceMessages sourcemessages)
    {
        super(linebufferedreader, sourcemessages);
    }

    static char getReadCase()
    {
        char c;
        try
        {
            c = Environment.getCurrent().get("symbol-read-case", "P").toString().charAt(0);
        }
        catch (Exception exception)
        {
            return 'P';
        }
        if (c != 'P')
        {
            if (c == 'u')
            {
                return 'U';
            }
            if (c == 'd' || c == 'l' || c == 'L')
            {
                return 'D';
            }
            if (c == 'i')
            {
                return 'I';
            }
        }
        return c;
    }

    private boolean isPotentialNumber(char ac[], int i, int j)
    {
        int k;
        int l;
        boolean flag;
        flag = true;
        l = 0;
        k = i;
_L2:
        char c;
        if (k >= j)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        c = ac[k];
        if (!Character.isDigit(c))
        {
            break; /* Loop/switch isn't completed */
        }
        l++;
_L3:
        k++;
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            if (c != '-' && c != '+')
            {
                break label0;
            }
            if (k + 1 == j)
            {
                return false;
            }
        }
          goto _L3
        continue; /* Loop/switch isn't completed */
        if (c == '#')
        {
            return true;
        }
        if (!Character.isLetter(c) && c != '/' && c != '_' && c != '^')
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k != i) goto _L3; else goto _L4
_L4:
        return false;
        if (c == '.') goto _L3; else goto _L5
_L5:
        return false;
        if (l <= 0)
        {
            flag = false;
        }
        return flag;
        if (true) goto _L2; else goto _L6
_L6:
    }

    public static Object parseNumber(CharSequence charsequence, int i)
    {
        char ac[];
        if (charsequence instanceof FString)
        {
            ac = ((FString)charsequence).data;
        } else
        {
            ac = charsequence.toString().toCharArray();
        }
        return parseNumber(ac, 0, charsequence.length(), '\0', i, 1);
    }

    public static Object parseNumber(char ac[], int i, int j, char c, int k, int l)
    {
        int i3 = i + j;
        if (i < i3) goto _L2; else goto _L1
_L1:
        ac = "no digits";
_L49:
        return ac;
_L2:
        char c1;
        int i1;
        int k1;
        k1 = i + 1;
        c1 = ac[i];
        i1 = k;
_L19:
        if (c1 != '#')
        {
            break; /* Loop/switch isn't completed */
        }
        if (k1 >= i3)
        {
            return "no digits";
        }
        k = k1 + 1;
        c1 = ac[k1];
        c1;
        JVM INSTR lookupswitch 12: default 168
    //                   66: 207
    //                   68: 243
    //                   69: 273
    //                   73: 273
    //                   79: 228
    //                   88: 258
    //                   98: 207
    //                   100: 243
    //                   101: 273
    //                   105: 273
    //                   111: 228
    //                   120: 258;
           goto _L3 _L4 _L5 _L6 _L6 _L7 _L8 _L4 _L5 _L6 _L6 _L7 _L8
_L3:
        k1 = 0;
_L17:
        int l1 = Character.digit(c1, 10);
        if (l1 >= 0) goto _L10; else goto _L9
_L9:
        if (c1 != 'R' && c1 != 'r') goto _L12; else goto _L11
_L11:
        if (i1 != 0)
        {
            return "duplicate radix specifier";
        }
        if (k1 < 2 || k1 > 35)
        {
            return "invalid radix specifier";
        }
        i1 = k1;
          goto _L13
_L4:
        if (i1 != 0)
        {
            return "duplicate radix specifier";
        }
        i1 = 2;
_L15:
        if (k >= i3)
        {
            return "no digits";
        }
        break; /* Loop/switch isn't completed */
_L7:
        if (i1 != 0)
        {
            return "duplicate radix specifier";
        }
        i1 = 8;
        continue; /* Loop/switch isn't completed */
_L5:
        if (i1 != 0)
        {
            return "duplicate radix specifier";
        }
        i1 = 10;
        continue; /* Loop/switch isn't completed */
_L8:
        if (i1 != 0)
        {
            return "duplicate radix specifier";
        }
        i1 = 16;
        continue; /* Loop/switch isn't completed */
_L6:
        if (c != 0)
        {
            if (c == ' ')
            {
                return "non-prefix exactness specifier";
            } else
            {
                return "duplicate exactness specifier";
            }
        }
        c = c1;
        continue; /* Loop/switch isn't completed */
_L10:
        k1 = k1 * 10 + l1;
        if (k >= i3)
        {
            return "missing letter after '#'";
        }
        c1 = ac[k];
        k++;
        continue; /* Loop/switch isn't completed */
_L13:
        if (true) goto _L15; else goto _L14
_L14:
        break; /* Loop/switch isn't completed */
_L12:
        return (new StringBuilder()).append("unknown modifier '#").append(c1).append('\'').toString();
        if (true) goto _L17; else goto _L16
_L16:
        c1 = ac[k];
        k1 = k + 1;
        if (true) goto _L19; else goto _L18
_L18:
        char c2;
        c2 = c;
        if (c == 0)
        {
            c2 = ' ';
        }
        k = i1;
        if (i1 != 0) goto _L21; else goto _L20
_L20:
        k = j - 1;
        if (k >= 0) goto _L23; else goto _L22
_L22:
        k = 10;
          goto _L21
_L23:
        j = k;
        if (ac[i + k] != '.') goto _L20; else goto _L24
_L24:
        k = 10;
_L21:
        boolean flag;
        boolean flag2;
        if (c1 == '-')
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (c1 == '-' || c1 == '+')
        {
            flag = true;
        } else
        {
            flag = false;
        }
        double d1;
        double d2;
        Object obj;
        Object obj1;
        int j1;
        int i2;
        int j2;
        int k2;
        int l2;
        long l3;
        long l4;
        boolean flag1;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        if (flag)
        {
            if (k1 >= i3)
            {
                return "no digits following sign";
            }
            j = k1 + 1;
            c1 = ac[k1];
        } else
        {
            j = k1;
        }
        if ((c1 == 'i' || c1 == 'I') && j == i3 && i == j - 2 && (l & 1) != 0)
        {
            i = ac[i];
            if (i != 43 && i != 45)
            {
                return "no digits";
            }
            if (c2 == 'i' || c2 == 'I')
            {
                double d;
                if (flag2)
                {
                    d = -1D;
                } else
                {
                    d = 1.0D;
                }
                return new DComplex(0.0D, d);
            }
            if (flag2)
            {
                ac = Complex.imMinusOne();
            } else
            {
                ac = Complex.imOne();
            }
            return ac;
        }
        flag4 = false;
        j2 = -1;
        j1 = -1;
        i2 = -1;
        flag3 = false;
        obj = null;
        l3 = 0L;
        i = j;
        flag1 = flag2;
        j = j1;
label0:
        {
            k1 = Character.digit(c1, k);
            if (k1 >= 0)
            {
                if (flag4 && i2 < 0)
                {
                    return "digit after '#' in number";
                }
                j1 = j;
                if (j < 0)
                {
                    j1 = i - 1;
                }
                l3 = (long)k * l3 + (long)k1;
                k1 = i2;
                j = j1;
                break label0;
            }
        }
        c1;
        JVM INSTR lookupswitch 12: default 944
    //                   46: 978
    //                   47: 1273
    //                   68: 1004
    //                   69: 1004
    //                   70: 1004
    //                   76: 1004
    //                   83: 1004
    //                   100: 1004
    //                   101: 1004
    //                   102: 1004
    //                   108: 1004
    //                   115: 1004;
           goto _L25 _L26 _L27 _L28 _L28 _L28 _L28 _L28 _L28 _L28 _L28 _L28 _L28
_L25:
        i--;
        j1 = j;
        flag7 = flag1;
        l4 = l3;
        k1 = i2;
        flag6 = flag4;
        obj1 = obj;
        flag5 = flag3;
          goto _L29
_L26:
        if (i2 >= 0)
        {
            return "duplicate '.' in number";
        }
        if (k != 10)
        {
            return "'.' in non-decimal number";
        }
        k1 = i - 1;
          goto _L30
_L28:
        if (i != i3 && k == 10) goto _L32; else goto _L31
_L31:
        i--;
        j1 = j;
        flag7 = flag1;
        l4 = l3;
        k1 = i2;
        flag6 = flag4;
        obj1 = obj;
        flag5 = flag3;
          goto _L29
_L32:
        c = ac[i];
        if (c != '+' && c != '-') goto _L34; else goto _L33
_L33:
        k1 = i + 1;
        if (k1 >= i3) goto _L36; else goto _L35
_L35:
        j1 = k1;
        if (Character.digit(ac[k1], 10) >= 0) goto _L37; else goto _L36
_L36:
        return "missing exponent digits";
_L34:
        j1 = i;
        if (Character.digit(c, 10) >= 0) goto _L37; else goto _L38
_L38:
        i--;
        j1 = j;
        flag7 = flag1;
        l4 = l3;
        k1 = i2;
        flag6 = flag4;
        obj1 = obj;
        flag5 = flag3;
          goto _L29
_L37:
        if (-1 >= 0)
        {
            return "duplicate exponent";
        }
        if (k != 10)
        {
            return "exponent in non-decimal number";
        }
        if (j < 0)
        {
            return "mantissa with no digits";
        }
        l2 = i - 1;
_L41:
        k2 = j1 + 1;
        j1 = j;
        flag7 = flag1;
        l4 = l3;
        i = k2;
        k1 = i2;
        j2 = l2;
        flag6 = flag4;
        obj1 = obj;
        flag5 = flag3;
        if (k2 >= i3) goto _L29; else goto _L39
_L39:
        j1 = k2;
        if (Character.digit(ac[k2], 10) >= 0) goto _L41; else goto _L40
_L40:
        j1 = j;
        flag7 = flag1;
        l4 = l3;
        i = k2;
        k1 = i2;
        j2 = l2;
        flag6 = flag4;
        obj1 = obj;
        flag5 = flag3;
          goto _L29
_L27:
        if (obj != null)
        {
            return "multiple fraction symbol '/'";
        }
        if (j < 0)
        {
            return "no digits before fraction symbol '/'";
        }
        if (-1 >= 0 || i2 >= 0)
        {
            return "fraction symbol '/' following exponent or '.'";
        }
        obj = valueOf(ac, j, i - j, k, flag1, l3);
        j = -1;
        l3 = 0L;
        flag1 = false;
        flag4 = false;
        flag3 = false;
        k1 = i2;
_L30:
        if (i == i3)
        {
            flag5 = flag3;
            obj1 = obj;
            flag6 = flag4;
            l4 = l3;
            flag7 = flag1;
            j1 = j;
            break MISSING_BLOCK_LABEL_743;
        }
        c1 = ac[i];
        i++;
        i2 = k1;
        break MISSING_BLOCK_LABEL_656;
_L29:
        j = 0;
        i2 = 0;
        if (j1 < 0)
        {
            j = i2;
            if (flag)
            {
                j = i2;
                if (i + 4 < i3)
                {
                    j = i2;
                    if (ac[i + 3] == '.')
                    {
                        j = i2;
                        if (ac[i + 4] == '0')
                        {
                            if (ac[i] == 'i' && ac[i + 1] == 'n' && ac[i + 2] == 'f')
                            {
                                j = 105;
                            } else
                            {
                                j = i2;
                                if (ac[i] == 'n')
                                {
                                    j = i2;
                                    if (ac[i + 1] == 'a')
                                    {
                                        j = i2;
                                        if (ac[i + 2] == 'n')
                                        {
                                            j = 110;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (j == 0)
            {
                return "no digits";
            }
            i2 = i + 5;
        } else
        {
            i2 = i;
        }
        if (!flag6)
        {
            if (!flag5);
        }
        if (c2 == 'i' || c2 == 'I' || c2 == ' ' && flag6)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        flag = false;
        k2 = 0;
        if (j != 0)
        {
            if (j == 105)
            {
                d1 = (1.0D / 0.0D);
            } else
            {
                d1 = (0.0D / 0.0D);
            }
            d2 = d1;
            if (flag7)
            {
                d2 = -d1;
            }
            obj = new DFloNum(d2);
            i = k2;
        } else
        if (j2 >= 0 || k1 >= 0)
        {
            j = j1;
            if (j1 > k1)
            {
                j = j1;
                if (k1 >= 0)
                {
                    j = k1;
                }
            }
            if (obj1 != null)
            {
                return "floating-point number after fraction symbol '/'";
            }
            obj1 = new String(ac, j, i2 - j);
            i = ((flag) ? 1 : 0);
            obj = obj1;
            if (j2 >= 0)
            {
                k = Character.toLowerCase(ac[j2]);
                i = k;
                obj = obj1;
                if (k != 101)
                {
                    i = j2 - j;
                    obj = (new StringBuilder()).append(((String) (obj1)).substring(0, i)).append('e').append(((String) (obj1)).substring(i + 1)).toString();
                    i = k;
                }
            }
            d2 = Convert.parseDouble(((String) (obj)));
            d1 = d2;
            if (flag7)
            {
                d1 = -d2;
            }
            obj = new DFloNum(d1);
        } else
        {
            obj = valueOf(ac, j1, i2 - j1, k, flag7, l4);
            if (obj1 != null)
            {
                if (((IntNum) (obj)).isZero())
                {
                    flag1 = ((IntNum) (obj1)).isZero();
                    if (i != 0)
                    {
                        if (flag1)
                        {
                            d1 = (0.0D / 0.0D);
                        } else
                        if (flag2)
                        {
                            d1 = (-1.0D / 0.0D);
                        } else
                        {
                            d1 = (1.0D / 0.0D);
                        }
                        obj = new DFloNum(d1);
                    } else
                    {
                        if (flag1)
                        {
                            return "0/0 is undefined";
                        }
                        obj = RatNum.make(((IntNum) (obj1)), ((IntNum) (obj)));
                    }
                } else
                {
                    obj = RatNum.make(((IntNum) (obj1)), ((IntNum) (obj)));
                }
            }
            if (i != 0 && ((RealNum) (obj)).isExact())
            {
                if (flag2 && ((RealNum) (obj)).isZero())
                {
                    d1 = 0.0D;
                } else
                {
                    d1 = ((RealNum) (obj)).doubleValue();
                }
                obj = new DFloNum(d1);
                i = k2;
            } else
            {
                i = k2;
            }
        }
        if (c2 == 'e') goto _L43; else goto _L42
_L42:
        obj1 = obj;
        if (c2 != 'E') goto _L44; else goto _L43
_L43:
        obj1 = ((RealNum) (obj)).toExact();
_L44:
        if (i2 >= i3) goto _L46; else goto _L45
_L45:
        i = i2 + 1;
        c = ac[i2];
        if (c != '@') goto _L48; else goto _L47
_L47:
        obj = parseNumber(ac, i, i3 - i, c2, 10, l);
        ac = ((char []) (obj));
        if (!(obj instanceof String))
        {
            if (!(obj instanceof RealNum))
            {
                return "invalid complex polar constant";
            }
            ac = (RealNum)obj;
            if (((RealNum) (obj1)).isZero() && !ac.isExact())
            {
                return new DFloNum(0.0D);
            } else
            {
                return Complex.polar(((RealNum) (obj1)), ac);
            }
        }
          goto _L49
_L48:
        if (c == '-' || c == '+')
        {
            i--;
            ac = ((char []) (parseNumber(ac, i, i3 - i, c2, 10, l)));
            if (ac instanceof String)
            {
                return ac;
            }
            if (!(ac instanceof Complex))
            {
                return (new StringBuilder()).append("invalid numeric constant (").append(ac).append(")").toString();
            }
            ac = (Complex)ac;
            if (!ac.re().isZero())
            {
                return "invalid numeric constant";
            } else
            {
                return Complex.make(((RealNum) (obj1)), ac.im());
            }
        }
        j = 0;
_L55:
        if (Character.isLetter(c)) goto _L51; else goto _L50
_L50:
        i--;
        k = j;
        j = i;
_L53:
        if (k == 1)
        {
            i = ac[j - 1];
            if (i == 105 || i == 73)
            {
                if (j < i3)
                {
                    return "junk after imaginary suffix 'i'";
                } else
                {
                    return Complex.make(IntNum.zero(), ((RealNum) (obj1)));
                }
            }
        }
        break; /* Loop/switch isn't completed */
_L51:
        l = j + 1;
        j = i;
        k = l;
        if (i == i3) goto _L53; else goto _L52
_L52:
        c = ac[i];
        i++;
        j = l;
        if (true) goto _L55; else goto _L54
_L54:
        return "excess junk after number";
_L46:
        if (!(obj1 instanceof DFloNum) || i <= 0 || i == 101) goto _L57; else goto _L56
_L56:
        d1 = ((RealNum) (obj1)).doubleValue();
        i;
        JVM INSTR lookupswitch 4: default 2232
    //                   100: 2242
    //                   102: 2235
    //                   108: 2248
    //                   115: 2235;
           goto _L57 _L58 _L59 _L60 _L59
_L57:
        return obj1;
_L59:
        return Float.valueOf((float)d1);
_L58:
        return Double.valueOf(d1);
_L60:
        return BigDecimal.valueOf(d1);
    }

    public static Object readCharacter(LispReader lispreader)
        throws IOException, SyntaxException
    {
        char ac[];
        String s;
        int l;
        int i1;
        char c;
        int i = lispreader.read();
        if (i < 0)
        {
            lispreader.eofError("unexpected EOF in character literal");
        }
        l = lispreader.tokenBufferLength;
        lispreader.tokenBufferAppend(i);
        lispreader.readToken(lispreader.read(), 'D', ReadTable.getCurrent());
        ac = lispreader.tokenBuffer;
        i1 = lispreader.tokenBufferLength - l;
        if (i1 == 1)
        {
            return Char.make(ac[l]);
        }
        s = new String(ac, l, i1);
        i = Char.nameToChar(s);
        if (i >= 0)
        {
            return Char.make(i);
        }
        c = ac[l];
        if (c != 'x' && c != 'X') goto _L2; else goto _L1
_L1:
        int j;
        int k;
        k = 0;
        j = 1;
_L6:
        int k1;
        if (j == i1)
        {
            return Char.make(k);
        }
        k1 = Character.digit(ac[l + j], 16);
        if (k1 >= 0) goto _L3; else goto _L2
_L2:
label0:
        {
            k = Character.digit(c, 8);
            if (k >= 0)
            {
                j = 1;
                break label0;
            }
        }
        break; /* Loop/switch isn't completed */
_L3:
        if ((k = k * 16 + k1) > 0x10ffff) goto _L2; else goto _L4
_L4:
        j++;
        if (true) goto _L6; else goto _L5
        k = k * 8 + j1;
        j++;
        if (j == i1)
        {
            return Char.make(k);
        }
        j1 = Character.digit(ac[l + j], 8);
        if (j1 >= 0)
        {
            break MISSING_BLOCK_LABEL_251;
        }
_L5:
        lispreader.error((new StringBuilder()).append("unknown character name: ").append(s).toString());
        return Char.make(63);
    }

    public static Object readNumberWithRadix(int i, LispReader lispreader, int j)
        throws IOException, SyntaxException
    {
        i = lispreader.tokenBufferLength - i;
        lispreader.readToken(lispreader.read(), 'P', ReadTable.getCurrent());
        int k = lispreader.tokenBufferLength;
        Object obj;
        if (i == k)
        {
            lispreader.error("missing numeric token");
            obj = IntNum.zero();
        } else
        {
            Object obj1 = parseNumber(lispreader.tokenBuffer, i, k - i, '\0', j, 0);
            if (obj1 instanceof String)
            {
                lispreader.error((String)obj1);
                return IntNum.zero();
            }
            obj = obj1;
            if (obj1 == null)
            {
                lispreader.error("invalid numeric constant");
                return IntNum.zero();
            }
        }
        return obj;
    }

    public static SimpleVector readSimpleVector(LispReader lispreader, char c)
        throws IOException, SyntaxException
    {
        int i;
        i = 0;
        do
        {
            int j = lispreader.read();
            if (j < 0)
            {
                lispreader.eofError("unexpected EOF reading uniform vector");
            }
            int k = Character.digit((char)j, 10);
            if (k < 0)
            {
                if (i != 8 && i != 16 && i != 32 && i != 64 || c == 'F' && i < 32 || j != 40)
                {
                    lispreader.error("invalid uniform vector syntax");
                    return null;
                }
                break;
            }
            i = i * 10 + k;
        } while (true);
        Object obj = ReaderParens.readList(lispreader, 40, -1, 41);
        if (LList.listLength(obj, false) < 0)
        {
            lispreader.error("invalid elements in uniform vector syntax");
            return null;
        }
        lispreader = (Sequence)obj;
        c;
        JVM INSTR lookupswitch 3: default 164
    //                   70: 166
    //                   83: 192
    //                   85: 236;
           goto _L1 _L2 _L3 _L4
_L1:
        return null;
_L2:
        i;
        JVM INSTR lookupswitch 2: default 192
    //                   32: 291
    //                   64: 300;
           goto _L3 _L5 _L6
_L3:
        i;
        JVM INSTR lookupswitch 4: default 236
    //                   8: 309
    //                   16: 318
    //                   32: 327
    //                   64: 336;
           goto _L4 _L7 _L8 _L9 _L10
_L4:
        switch (i)
        {
        default:
            return null;

        case 8: // '\b'
            return new U8Vector(lispreader);

        case 16: // '\020'
            return new U16Vector(lispreader);

        case 32: // ' '
            return new U32Vector(lispreader);

        case 64: // '@'
            return new U64Vector(lispreader);
        }
_L5:
        return new F32Vector(lispreader);
_L6:
        return new F64Vector(lispreader);
_L7:
        return new S8Vector(lispreader);
_L8:
        return new S16Vector(lispreader);
_L9:
        return new S32Vector(lispreader);
_L10:
        return new S64Vector(lispreader);
    }

    public static Object readSpecial(LispReader lispreader)
        throws IOException, SyntaxException
    {
        Values values = null;
        int j = lispreader.read();
        if (j < 0)
        {
            lispreader.eofError("unexpected EOF in #! special form");
        }
        if (j == 47 && lispreader.getLineNumber() == 0 && lispreader.getColumnNumber() == 3)
        {
            ReaderIgnoreRestOfLine.getInstance().read(lispreader, 35, 1);
            values = Values.empty;
        } else
        {
            int i = lispreader.tokenBufferLength;
            lispreader.tokenBufferAppend(j);
            lispreader.readToken(lispreader.read(), 'D', ReadTable.getCurrent());
            j = lispreader.tokenBufferLength;
            String s = new String(lispreader.tokenBuffer, i, j - i);
            if (s.equals("optional"))
            {
                return Special.optional;
            }
            if (s.equals("rest"))
            {
                return Special.rest;
            }
            if (s.equals("key"))
            {
                return Special.key;
            }
            if (s.equals("eof"))
            {
                return Special.eof;
            }
            if (s.equals("void"))
            {
                return QuoteExp.voidExp;
            }
            if (s.equals("default"))
            {
                return Special.dfault;
            }
            if (s.equals("undefined"))
            {
                return Special.undefined;
            }
            if (s.equals("abstract"))
            {
                return Special.abstractSpecial;
            }
            if (!s.equals("null"))
            {
                lispreader.error((new StringBuilder()).append("unknown named constant #!").append(s).toString());
                return null;
            }
        }
        return values;
    }

    private static IntNum valueOf(char ac[], int i, int j, int k, boolean flag, long l)
    {
        if (j + k <= 28)
        {
            long l1 = l;
            if (flag)
            {
                l1 = -l;
            }
            return IntNum.make(l1);
        } else
        {
            return IntNum.valueOf(ac, i, j, k, flag);
        }
    }

    Object handlePostfix(Object obj, ReadTable readtable, int i, int j)
        throws IOException, SyntaxException
    {
        Object obj1 = obj;
        if (obj == QuoteExp.voidExp)
        {
            obj1 = Values.empty;
        }
        do
        {
            int k = port.peek();
            if (k < 0 || k != readtable.postfixLookupOperator)
            {
                return obj1;
            }
            port.read();
            if (!validPostfixLookupStart(port.peek(), readtable))
            {
                unread();
                return obj1;
            }
            k = port.read();
            obj = readValues(k, readtable.lookup(k), readtable);
            obj = LList.list2(obj1, LList.list2(readtable.makeSymbol("quasiquote"), obj));
            obj1 = PairWithPosition.make(LispLanguage.lookup_sym, obj, port.getName(), i + 1, j + 1);
        } while (true);
    }

    protected Object makeNil()
    {
        return LList.Empty;
    }

    protected Pair makePair(Object obj, int i, int j)
    {
        return makePair(obj, LList.Empty, i, j);
    }

    protected Pair makePair(Object obj, Object obj1, int i, int j)
    {
        String s = port.getName();
        if (s != null && i >= 0)
        {
            return PairWithPosition.make(obj, obj1, s, i + 1, j + 1);
        } else
        {
            return Pair.make(obj, obj1);
        }
    }

    protected Object readAndHandleToken(int i, int j, ReadTable readtable)
        throws IOException, SyntaxException
    {
        readToken(i, getReadCase(), readtable);
        int k3 = tokenBufferLength;
        if (!seenEscapes)
        {
            Object obj = parseNumber(tokenBuffer, j, k3 - j, '\0', 0, 1);
            if (obj != null && !(obj instanceof String))
            {
                return obj;
            }
        }
        i = getReadCase();
        int k = i;
        int l;
        int i2;
        byte byte0;
        int i3;
        boolean flag;
        if (i == 73)
        {
            k = 0;
            l = 0;
            i = j;
            while (i < k3) 
            {
                char c = tokenBuffer[i];
                int i1;
                int l1;
                int j2;
                if (c == '\uFFFF')
                {
                    l1 = i + 1;
                    j2 = k;
                    i1 = l;
                } else
                if (Character.isLowerCase(c))
                {
                    i1 = l + 1;
                    l1 = i;
                    j2 = k;
                } else
                {
                    l1 = i;
                    i1 = l;
                    j2 = k;
                    if (Character.isUpperCase(c))
                    {
                        j2 = k + 1;
                        l1 = i;
                        i1 = l;
                    }
                }
                i = l1 + 1;
                l = i1;
                k = j2;
            }
            char ac[];
            int j1;
            int k2;
            if (l == 0)
            {
                k = 68;
            } else
            if (k == 0)
            {
                k = 85;
            } else
            {
                k = 80;
            }
        }
        if (k3 >= j + 2 && tokenBuffer[k3 - 1] == '}' && tokenBuffer[k3 - 2] != '\uFFFF' && peek() == 58)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i2 = -1;
        l = -1;
        byte0 = -1;
        i3 = 0;
        k2 = j;
        i = j;
        do
        {
            if (k2 < k3)
            {
                char c2 = tokenBuffer[k2];
                if (c2 == '\uFFFF')
                {
                    k2++;
                    char c1;
                    char ac1[];
                    String s;
                    String s1;
                    int k1;
                    int l2;
                    int j3;
                    if (k2 < k3)
                    {
                        ac = tokenBuffer;
                        j1 = i + 1;
                        ac[i] = tokenBuffer[k2];
                        j3 = l;
                        i = j1;
                        k1 = i3;
                    } else
                    {
                        k1 = i3;
                        j3 = l;
                    }
                } else
                {
                    k1 = i3;
                    j3 = l;
                    l2 = byte0;
                    if (flag)
                    {
                        if (c2 == '{')
                        {
                            if (l < 0)
                            {
                                j3 = i;
                            } else
                            {
                                j3 = l;
                                if (i3 == 0)
                                {
                                    j3 = l;
                                }
                            }
                            k1 = i3 + 1;
                            l2 = byte0;
                        } else
                        {
                            k1 = i3;
                            j3 = l;
                            l2 = byte0;
                            if (c2 == '}')
                            {
                                i3--;
                                if (i3 < 0)
                                {
                                    k1 = i3;
                                    j3 = l;
                                    l2 = byte0;
                                } else
                                {
                                    k1 = i3;
                                    j3 = l;
                                    l2 = byte0;
                                    if (i3 == 0)
                                    {
                                        if (byte0 < 0)
                                        {
                                            l2 = i;
                                            k1 = i3;
                                            j3 = l;
                                        } else
                                        {
                                            k1 = i3;
                                            j3 = l;
                                            l2 = byte0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (k1 > 0)
                    {
                        l = i2;
                        c1 = c2;
                    } else
                    if (c2 == ':')
                    {
                        if (i2 >= 0)
                        {
                            l = -1;
                        } else
                        {
                            l = i;
                        }
                        c1 = c2;
                    } else
                    if (k == 85)
                    {
                        c1 = Character.toUpperCase(c2);
                        l = i2;
                    } else
                    {
                        c1 = c2;
                        l = i2;
                        if (k == 68)
                        {
                            c1 = Character.toLowerCase(c2);
                            l = i2;
                        }
                    }
                    ac1 = tokenBuffer;
                    i2 = i + 1;
                    ac1[i] = c1;
                    i = i2;
                    i2 = l;
                    byte0 = l2;
                }
            } else
            {
                k = i - j;
                if (l >= 0 && byte0 > l)
                {
                    if (l > 0)
                    {
                        s = new String(tokenBuffer, j, l - j);
                    } else
                    {
                        s = null;
                    }
                    i = l + 1;
                    s1 = new String(tokenBuffer, i, byte0 - i);
                    read();
                    i = read();
                    readtable = ((ReadTable) (readValues(i, readtable.lookup(i), readtable)));
                    if (!(readtable instanceof SimpleSymbol))
                    {
                        error("expected identifier in symbol after '{URI}:'");
                    }
                    return Symbol.valueOf(readtable.toString(), s1, s);
                }
                if (readtable.initialColonIsKeyword && i2 == j && k > 1)
                {
                    j++;
                    return Keyword.make((new String(tokenBuffer, j, i - j)).intern());
                }
                if (readtable.finalColonIsKeyword && i2 == i - 1 && (k > 1 || seenEscapes))
                {
                    return Keyword.make((new String(tokenBuffer, j, k - 1)).intern());
                }
                return readtable.makeSymbol(new String(tokenBuffer, j, k));
            }
            k2++;
            i3 = k1;
            l = j3;
        } while (true);
    }

    public Object readCommand()
        throws IOException, SyntaxException
    {
        return readObject();
    }

    public int readEscape()
        throws IOException, SyntaxException
    {
        int i = read();
        if (i < 0)
        {
            eofError("unexpected EOF in character literal");
            return -1;
        } else
        {
            return readEscape(i);
        }
    }

    public final int readEscape(int i)
        throws IOException, SyntaxException
    {
        int j = i;
        (char)i;
        JVM INSTR lookupswitch 28: default 240
    //                   9: 307
    //                   10: 307
    //                   13: 307
    //                   32: 307
    //                   34: 290
    //                   48: 512
    //                   49: 512
    //                   50: 512
    //                   51: 512
    //                   52: 512
    //                   53: 512
    //                   54: 512
    //                   55: 512
    //                   67: 460
    //                   77: 417
    //                   88: 639
    //                   92: 296
    //                   94: 479
    //                   97: 242
    //                   98: 248
    //                   101: 284
    //                   102: 272
    //                   110: 260
    //                   114: 278
    //                   116: 254
    //                   117: 578
    //                   118: 266
    //                   120: 639;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_639;
_L24:
        return i;
_L10:
        i = 7;
        continue; /* Loop/switch isn't completed */
_L11:
        i = 8;
        continue; /* Loop/switch isn't completed */
_L16:
        i = 9;
        continue; /* Loop/switch isn't completed */
_L14:
        i = 10;
        continue; /* Loop/switch isn't completed */
_L18:
        i = 11;
        continue; /* Loop/switch isn't completed */
_L13:
        i = 12;
        continue; /* Loop/switch isn't completed */
_L15:
        i = 13;
        continue; /* Loop/switch isn't completed */
_L12:
        i = 27;
        continue; /* Loop/switch isn't completed */
_L3:
        i = 34;
        continue; /* Loop/switch isn't completed */
_L8:
        i = 92;
        continue; /* Loop/switch isn't completed */
_L20:
        j = read();
_L2:
        if (j < 0)
        {
            eofError("unexpected EOF in literal");
            return -1;
        }
        if (j != 10)
        {
            if (j != 13)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (peek() == 10)
            {
                skip();
            }
            j = 10;
        }
_L21:
        i = j;
        if (j != 10)
        {
            continue; /* Loop/switch isn't completed */
        }
_L23:
        i = read();
        if (i < 0)
        {
            eofError("unexpected EOF in literal");
            return -1;
        }
        continue; /* Loop/switch isn't completed */
        if (j == 32 || j == 9) goto _L20; else goto _L19
_L19:
        unread(j);
          goto _L21
        if (i == 32 || i == 9) goto _L23; else goto _L22
_L22:
        unread(i);
        return -2;
_L6:
        if (read() != 45)
        {
            error("Invalid escape character syntax");
            return 63;
        }
        int k = read();
        i = k;
        if (k == 92)
        {
            i = readEscape();
        }
        return i | 0x80;
_L5:
        if (read() != 45)
        {
            error("Invalid escape character syntax");
            return 63;
        }
_L9:
        int l = read();
        i = l;
        if (l == 92)
        {
            i = readEscape();
        }
        if (i == 63)
        {
            return 127;
        } else
        {
            return i & 0x9f;
        }
_L4:
        int i1 = i - 48;
        i = 0;
        int i2;
        do
        {
            int k1 = i + 1;
            i = i1;
            if (k1 >= 3)
            {
                continue; /* Loop/switch isn't completed */
            }
            i2 = read();
            i = Character.digit((char)i2, 8);
            if (i < 0)
            {
                break;
            }
            i1 = (i1 << 3) + i;
            i = k1;
        } while (true);
        i = i1;
        if (i2 >= 0)
        {
            unread(i2);
            i = i1;
        }
        if (true) goto _L24; else goto _L17
_L17:
        int j1 = 0;
        i = 4;
        do
        {
            int l1 = i - 1;
            i = j1;
            if (l1 < 0)
            {
                break;
            }
            i = read();
            if (i < 0)
            {
                eofError("premature EOF in \\u escape");
            }
            i = Character.digit((char)i, 16);
            if (i < 0)
            {
                error("non-hex character following \\u");
            }
            j1 = j1 * 16 + i;
            i = l1;
        } while (true);
        if (true) goto _L24; else goto _L25
_L25:
        return readHexEscape();
    }

    public int readHexEscape()
        throws IOException, SyntaxException
    {
        int i = 0;
        int j;
        do
        {
            j = read();
            int k = Character.digit((char)j, 16);
            if (k < 0)
            {
                break;
            }
            i = (i << 4) + k;
        } while (true);
        if (j != 59 && j >= 0)
        {
            unread(j);
        }
        return i;
    }

    public final void readNestedComment(char c, char c1)
        throws IOException, SyntaxException
    {
        int k;
        int j1;
        int k1;
        k = 1;
        j1 = port.getLineNumber();
        k1 = port.getColumnNumber();
_L6:
        int l = read();
        if (l != 124) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        l = read();
        i = l;
        j = k;
        if (l == c)
        {
            j = k - 1;
            i = l;
        }
_L4:
        if (i < 0)
        {
            eofError((new StringBuilder()).append("unexpected end-of-file in ").append(c).append(c1).append(" comment starting here").toString(), j1 + 1, k1 - 1);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        i = l;
        j = k;
        if (l == c)
        {
            int i1 = read();
            i = i1;
            j = k;
            if (i1 == c1)
            {
                j = k + 1;
                i = i1;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        k = j;
        if (j <= 0)
        {
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Object readObject()
        throws IOException, SyntaxException
    {
        char c;
        int i;
        c = ((InPort)port).readState;
        i = tokenBufferLength;
        ((InPort)port).readState = ' ';
        Object obj = ReadTable.getCurrent();
_L2:
        int j;
        int k;
        int l;
        j = port.getLineNumber();
        k = port.getColumnNumber();
        l = port.read();
        if (l >= 0)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        obj = Sequence.eofValue;
        tokenBufferLength = i;
        ((InPort)port).readState = c;
        return obj;
        Object obj1 = readValues(l, ((ReadTable) (obj)));
        if (obj1 == Values.empty) goto _L2; else goto _L1
_L1:
        obj = handlePostfix(obj1, ((ReadTable) (obj)), j, k);
        tokenBufferLength = i;
        ((InPort)port).readState = c;
        return obj;
        Exception exception;
        exception;
        tokenBufferLength = i;
        ((InPort)port).readState = c;
        throw exception;
    }

    public final Object readObject(int i)
        throws IOException, SyntaxException
    {
        unread(i);
        return readObject();
    }

    void readToken(int i, char c, ReadTable readtable)
        throws IOException, SyntaxException
    {
        char c1;
        int j;
        c1 = '\0';
        c = '\0';
        j = i;
        i = c;
_L2:
        ReadTableEntry readtableentry;
        char c2;
        if (j < 0)
        {
            if (c1 == 0)
            {
                break; /* Loop/switch isn't completed */
            }
            eofError("unexpected EOF between escapes");
        }
        readtableentry = readtable.lookup(j);
        c = readtableentry.getKind();
        if (c == 0)
        {
            if (c1 != 0)
            {
                tokenBufferAppend(65535);
                tokenBufferAppend(j);
                c = c1;
            } else
            {
label0:
                {
                    if (j != 125)
                    {
                        break label0;
                    }
                    i--;
                    if (i < 0)
                    {
                        break label0;
                    }
                    tokenBufferAppend(j);
                    c = c1;
                }
            }
        } else
        {
label1:
            {
label2:
                {
                    c2 = c;
                    if (j == readtable.postfixLookupOperator)
                    {
                        c2 = c;
                        if (c1 == 0)
                        {
                            int k = port.peek();
                            if (k == readtable.postfixLookupOperator)
                            {
                                unread(j);
                                return;
                            }
                            c2 = c;
                            if (validPostfixLookupStart(k, readtable))
                            {
                                c2 = '\005';
                            }
                        }
                    }
                    if (c2 != '\003')
                    {
                        break label1;
                    }
                    j = read();
                    if (j < 0)
                    {
                        eofError("unexpected EOF after single escape");
                    }
                    c = j;
                    if (!readtable.hexEscapeAfterBackslash)
                    {
                        break label2;
                    }
                    if (j != 120)
                    {
                        c = j;
                        if (j != 88)
                        {
                            break label2;
                        }
                    }
                    c = readHexEscape();
                }
                tokenBufferAppend(65535);
                tokenBufferAppend(c);
                seenEscapes = true;
                c = c1;
            }
        }
_L3:
        j = read();
        c1 = c;
        if (true) goto _L2; else goto _L1
        unread(j);
_L1:
        return;
        if (c2 == '\004')
        {
            if (c1 == 0)
            {
                c = '\001';
            } else
            {
                c = '\0';
            }
            seenEscapes = true;
        } else
        {
label3:
            {
                if (c1 == 0)
                {
                    break label3;
                }
                tokenBufferAppend(65535);
                tokenBufferAppend(j);
                c = c1;
            }
        }
          goto _L3
        c = i;
        switch (c2)
        {
        case 3: // '\003'
        default:
            c = c1;
            break;

        case 1: // '\001'
            unread(j);
            return;

        case 2: // '\002'
            c = i;
            if (j == 123)
            {
                c = i;
                if (readtableentry == ReadTableEntry.brace)
                {
                    c = i + 1;
                }
            }
            // fall through

        case 6: // '\006'
            tokenBufferAppend(j);
            i = c;
            c = c1;
            break;

        case 4: // '\004'
            c = '\001';
            seenEscapes = true;
            break;

        case 5: // '\005'
            unread(j);
            return;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    public Object readValues(int i, ReadTable readtable)
        throws IOException, SyntaxException
    {
        return readValues(i, readtable.lookup(i), readtable);
    }

    public Object readValues(int i, ReadTableEntry readtableentry, ReadTable readtable)
        throws IOException, SyntaxException
    {
        int j = tokenBufferLength;
        seenEscapes = false;
        switch (readtableentry.getKind())
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        default:
            return readAndHandleToken(i, j, readtable);

        case 0: // '\0'
            readtableentry = (new StringBuilder()).append("invalid character #\\").append((char)i).toString();
            if (interactive)
            {
                fatal(readtableentry);
            } else
            {
                error(readtableentry);
            }
            return Values.empty;

        case 1: // '\001'
            return Values.empty;

        case 5: // '\005'
        case 6: // '\006'
            return readtableentry.read(this, i, -1);
        }
    }

    protected void setCdr(Object obj, Object obj1)
    {
        ((Pair)obj).setCdrBackdoor(obj1);
    }

    protected boolean validPostfixLookupStart(int i, ReadTable readtable)
        throws IOException
    {
        if (i >= 0 && i != 58 && i != readtable.postfixLookupOperator)
        {
            if (i == 44)
            {
                return true;
            }
            i = readtable.lookup(i).getKind();
            if (i == 2 || i == 6 || i == 4 || i == 3)
            {
                return true;
            }
        }
        return false;
    }
}
