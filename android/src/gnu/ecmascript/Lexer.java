// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.ecmascript;

import gnu.expr.QuoteExp;
import gnu.lists.Sequence;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Hashtable;

// Referenced classes of package gnu.ecmascript:
//            Reserved

public class Lexer extends gnu.text.Lexer
{

    public static final Char colonToken = Char.make(58);
    public static final Char commaToken = Char.make(44);
    public static final Char condToken = Char.make(63);
    public static final Char dotToken = Char.make(46);
    public static final Reserved elseToken = new Reserved("else", 38);
    public static final Object eofToken;
    public static final Object eolToken = Char.make(10);
    public static final Char equalToken = Char.make(61);
    public static final Char lbraceToken = Char.make(123);
    public static final Char lbracketToken = Char.make(91);
    public static final Char lparenToken = Char.make(40);
    public static final Reserved newToken = new Reserved("new", 39);
    public static final Char notToken = Char.make(33);
    public static final Char rbraceToken = Char.make(125);
    public static final Char rbracketToken = Char.make(93);
    static Hashtable reserved;
    public static final Char rparenToken = Char.make(41);
    public static final Char semicolonToken = Char.make(59);
    public static final Char tildeToken = Char.make(126);
    private boolean prevWasCR;

    public Lexer(InPort inport)
    {
        super(inport);
        prevWasCR = false;
    }

    public static Object checkReserved(String s)
    {
        if (reserved == null)
        {
            initReserved();
        }
        return reserved.get(s);
    }

    public static Object getToken(InPort inport)
        throws IOException, SyntaxException
    {
        return (new Lexer(inport)).getToken();
    }

    static void initReserved()
    {
        gnu/ecmascript/Lexer;
        JVM INSTR monitorenter ;
        if (reserved == null)
        {
            reserved = new Hashtable(20);
            reserved.put("null", new QuoteExp(null));
            reserved.put("true", new QuoteExp(Boolean.TRUE));
            reserved.put("false", new QuoteExp(Boolean.FALSE));
            reserved.put("var", new Reserved("var", 30));
            reserved.put("if", new Reserved("if", 31));
            reserved.put("while", new Reserved("while", 32));
            reserved.put("for", new Reserved("for", 33));
            reserved.put("continue", new Reserved("continue", 34));
            reserved.put("break", new Reserved("break", 35));
            reserved.put("return", new Reserved("return", 36));
            reserved.put("with", new Reserved("with", 37));
            reserved.put("function", new Reserved("function", 41));
            reserved.put("this", new Reserved("this", 40));
            reserved.put("else", elseToken);
            reserved.put("new", newToken);
        }
        gnu/ecmascript/Lexer;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void main(String args[])
    {
        args = new Lexer(InPort.inDefault());
        Object obj;
        Object obj1;
        do
        {
            obj = args.getToken();
            obj1 = OutPort.outDefault();
            ((OutPort) (obj1)).print("token:");
            ((OutPort) (obj1)).print(obj);
            ((OutPort) (obj1)).println((new StringBuilder()).append(" [class:").append(obj.getClass()).append("]").toString());
            obj1 = Sequence.eofValue;
        } while (obj != obj1);
        return;
        args;
        System.err.println((new StringBuilder()).append("caught exception:").append(args).toString());
        return;
    }

    public String getIdentifier(int i)
        throws IOException
    {
        StringBuffer stringbuffer;
        i = port.pos;
        int j = i - 1;
        int k = port.limit;
        char ac[];
        for (ac = port.buffer; i < k && Character.isJavaIdentifierPart(ac[i]); i++) { }
        port.pos = i;
        if (i < k)
        {
            return new String(ac, j, i - j);
        }
        stringbuffer = new StringBuffer();
        stringbuffer.append(ac, j, i - j);
_L3:
        i = port.read();
        if (i >= 0) goto _L2; else goto _L1
_L1:
        return stringbuffer.toString();
_L2:
label0:
        {
            if (!Character.isJavaIdentifierPart((char)i))
            {
                break label0;
            }
            stringbuffer.append((char)i);
        }
          goto _L3
        port.unread_quick();
          goto _L1
    }

    public Double getNumericLiteral(int i)
        throws IOException
    {
        StringBuffer stringbuffer;
        int j;
        int k;
        boolean flag;
        int l = 10;
        j = l;
        k = i;
        if (i == 48)
        {
            i = read();
            long l1;
            if (i == 120 || i == 88)
            {
                j = 16;
                k = read();
            } else
            {
                j = l;
                k = i;
                if (i != 46)
                {
                    j = l;
                    k = i;
                    if (i != 101)
                    {
                        j = l;
                        k = i;
                        if (i != 69)
                        {
                            j = 8;
                            k = i;
                        }
                    }
                }
            }
        }
        i = port.pos;
        l = i;
        if (k >= 0)
        {
            l = i - 1;
        }
        port.pos = l;
        l1 = readDigitsInBuffer(port, j);
        if (port.pos > l)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0 && port.pos < port.limit)
        {
            k = port.buffer[port.pos];
            if (!Character.isLetterOrDigit((char)k) && k != 46)
            {
                double d;
                if (l1 >= 0L)
                {
                    d = l1;
                } else
                {
                    d = IntNum.valueOf(port.buffer, l, port.pos - l, j, false).doubleValue();
                }
                return new Double(d);
            }
        }
        if (j != 10)
        {
            error("invalid character in non-decimal number");
        }
        stringbuffer = new StringBuffer(20);
        if (i != 0)
        {
            stringbuffer.append(port.buffer, l, port.pos - l);
        }
        k = -1;
        flag = false;
_L4:
        int j1;
        do
        {
label0:
            {
                j1 = port.read();
                if (Character.digit((char)j1, j) < 0)
                {
                    break label0;
                }
                i = 1;
                stringbuffer.append((char)j1);
            }
        } while (true);
        j1;
        JVM INSTR lookupswitch 3: default 388
    //                   46: 442
    //                   69: 475
    //                   101: 475;
           goto _L1 _L2 _L3 _L3
_L1:
        int i1;
        i1 = j1;
        k = ((flag) ? 1 : 0);
_L6:
        if (i1 >= 0)
        {
            port.unread();
        }
        if (k != 0)
        {
            stringbuffer.append('e');
            stringbuffer.append(k);
        }
        return new Double(stringbuffer.toString());
_L2:
        if (k >= 0)
        {
            error("duplicate '.' in number");
        } else
        {
            k = stringbuffer.length();
            stringbuffer.append('.');
        }
          goto _L4
_L3:
        k = ((flag) ? 1 : 0);
        i1 = j1;
        if (j != 10) goto _L6; else goto _L5
_L5:
        j = port.peek();
        if (j == 43 || j == 45) goto _L8; else goto _L7
_L7:
        k = ((flag) ? 1 : 0);
        i1 = j1;
        if (Character.digit((char)j, 10) < 0) goto _L6; else goto _L8
_L8:
        if (i == 0)
        {
            error("mantissa with no digits");
        }
        k = readOptionalExponent();
        i1 = read();
          goto _L6
    }

    public String getStringLiteral(char c)
        throws IOException, SyntaxException
    {
        char ac[];
        int i;
        int j;
        int k;
        j = port.pos;
        k = port.limit;
        ac = port.buffer;
        i = j;
_L5:
        if (i >= k) goto _L2; else goto _L1
_L1:
        int l;
        l = ac[i];
        if (l == c)
        {
            port.pos = i + 1;
            return new String(ac, j, i - j);
        }
        if (l != '\\' && l != '\n' && l != '\r') goto _L3; else goto _L2
_L2:
        StringBuffer stringbuffer;
        port.pos = i;
        stringbuffer = new StringBuffer();
        stringbuffer.append(ac, j, i - j);
_L20:
        j = port.read();
        if (j == c)
        {
            return stringbuffer.toString();
        }
        if (j < 0)
        {
            eofError("unterminated string literal");
        }
        if (j == 10 || j == 13)
        {
            fatal("string literal not terminated before end of line");
        }
        i = j;
          goto _L4
_L3:
        i++;
          goto _L5
_L4:
        if (j != 92) goto _L7; else goto _L6
_L6:
        k = port.read();
        i = k;
        k;
        JVM INSTR lookupswitch 13: default 328
    //                   -1: 361
    //                   10: 368
    //                   13: 368
    //                   34: 350
    //                   39: 350
    //                   92: 350
    //                   98: 382
    //                   102: 403
    //                   110: 396
    //                   114: 410
    //                   116: 389
    //                   117: 417
    //                   120: 417;
           goto _L8 _L9 _L10 _L10 _L11 _L11 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L17
_L11:
        break; /* Loop/switch isn't completed */
_L8:
        i = k;
        if (k < 48)
        {
            break; /* Loop/switch isn't completed */
        }
        if (k <= 55) goto _L19; else goto _L18
_L18:
        i = k;
_L7:
        stringbuffer.append((char)i);
          goto _L20
_L9:
        eofError("eof following '\\' in string");
_L10:
        fatal("line terminator following '\\' in string");
        i = k;
          goto _L7
_L12:
        i = 8;
          goto _L7
_L16:
        i = 9;
          goto _L7
_L14:
        i = 10;
          goto _L7
_L13:
        i = 12;
          goto _L7
_L15:
        i = 13;
          goto _L7
_L17:
        i = 0;
        if (k == 120)
        {
            j = 2;
        } else
        {
            j = 4;
        }
_L21:
label0:
        {
            l = j - 1;
            j = i;
            if (l >= 0)
            {
                j = port.read();
                if (j < 0)
                {
                    eofError((new StringBuilder()).append("eof following '\\").append((char)k).append("' in string").toString());
                }
                j = Character.forDigit((char)j, 16);
                if (j >= 0)
                {
                    break label0;
                }
                error((new StringBuilder()).append("invalid char following '\\").append((char)k).append("' in string").toString());
                j = 63;
            }
            i = j;
        }
          goto _L7
        i = i * 16 + j;
        j = l;
          goto _L21
_L19:
        i = 0;
        j = 3;
_L22:
        j--;
        if (j >= 0)
        {
label1:
            {
                k = port.read();
                if (k < 0)
                {
                    eofError("eof in octal escape in string literal");
                }
                k = Character.forDigit((char)k, 8);
                if (k >= 0)
                {
                    break label1;
                }
                port.unread_quick();
            }
        }
          goto _L7
        i = i * 8 + k;
          goto _L22
    }

    public Object getToken()
        throws IOException, SyntaxException
    {
        int i = read();
_L8:
        if (i >= 0) goto _L2; else goto _L1
_L1:
        Object obj = eofToken;
_L6:
        return obj;
_L2:
        if (Character.isWhitespace((char)i)) goto _L4; else goto _L3
_L3:
        switch (i)
        {
        default:
            if (Character.isJavaIdentifierStart((char)i))
            {
                String s = getIdentifier(i).intern();
                Object obj1 = checkReserved(s);
                obj = obj1;
                if (obj1 == null)
                {
                    return s;
                }
            } else
            {
                return Char.make((char)i);
            }
            break;

        case 46: // '.'
            i = port.peek();
            if (i >= 48 && i <= 57)
            {
                return new QuoteExp(getNumericLiteral(46));
            } else
            {
                return dotToken;
            }

        case 48: // '0'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
            return new QuoteExp(getNumericLiteral(i));

        case 34: // '"'
        case 39: // '\''
            return new QuoteExp(getStringLiteral((char)i));

        case 40: // '('
            return lparenToken;

        case 41: // ')'
            return rparenToken;

        case 91: // '['
            return lbracketToken;

        case 93: // ']'
            return rbracketToken;

        case 123: // '{'
            return lbraceToken;

        case 125: // '}'
            return rbraceToken;

        case 63: // '?'
            return condToken;

        case 58: // ':'
            return colonToken;

        case 59: // ';'
            return semicolonToken;

        case 44: // ','
            return commaToken;

        case 61: // '='
            if (port.peek() == 61)
            {
                port.skip_quick();
                return Reserved.opEqual;
            } else
            {
                return equalToken;
            }

        case 33: // '!'
            if (port.peek() == 61)
            {
                port.skip_quick();
                return Reserved.opNotEqual;
            } else
            {
                return notToken;
            }

        case 126: // '~'
            return tildeToken;

        case 42: // '*'
            return maybeAssignment(Reserved.opTimes);

        case 47: // '/'
            return maybeAssignment(Reserved.opDivide);

        case 94: // '^'
            return maybeAssignment(Reserved.opBitXor);

        case 37: // '%'
            return maybeAssignment(Reserved.opRemainder);

        case 43: // '+'
            if (port.peek() == 43)
            {
                port.skip_quick();
                return maybeAssignment(Reserved.opPlusPlus);
            } else
            {
                return maybeAssignment(Reserved.opPlus);
            }

        case 45: // '-'
            if (port.peek() == 45)
            {
                port.skip_quick();
                return maybeAssignment(Reserved.opMinusMinus);
            } else
            {
                return maybeAssignment(Reserved.opMinus);
            }

        case 38: // '&'
            if (port.peek() == 38)
            {
                port.skip_quick();
                return maybeAssignment(Reserved.opBoolAnd);
            } else
            {
                return maybeAssignment(Reserved.opBitAnd);
            }

        case 124: // '|'
            if (port.peek() == 124)
            {
                port.skip_quick();
                return maybeAssignment(Reserved.opBoolOr);
            } else
            {
                return maybeAssignment(Reserved.opBitOr);
            }

        case 62: // '>'
            switch (port.peek())
            {
            default:
                return Reserved.opGreater;

            case 62: // '>'
                port.skip_quick();
                if (port.peek() == 62)
                {
                    port.skip_quick();
                    return maybeAssignment(Reserved.opRshiftUnsigned);
                } else
                {
                    return maybeAssignment(Reserved.opRshiftSigned);
                }

            case 61: // '='
                port.skip_quick();
                return Reserved.opGreaterEqual;
            }

        case 60: // '<'
            switch (port.peek())
            {
            default:
                return Reserved.opLess;

            case 60: // '<'
                port.skip_quick();
                return maybeAssignment(Reserved.opLshift);

            case 61: // '='
                port.skip_quick();
                break;
            }
            return Reserved.opLessEqual;
        }
        if (true) goto _L6; else goto _L5
_L5:
_L4:
        if (i == 13)
        {
            prevWasCR = true;
            return eolToken;
        }
        if (i == 10 && !prevWasCR)
        {
            return eolToken;
        }
        prevWasCR = false;
        i = read();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Object maybeAssignment(Object obj)
        throws IOException, SyntaxException
    {
        int i = read();
        if (i == 61)
        {
            error("assignment operation not implemented");
        }
        if (i >= 0)
        {
            port.unread_quick();
        }
        return obj;
    }

    static 
    {
        eofToken = Sequence.eofValue;
    }
}
