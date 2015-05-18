// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.math.IntNum;
import gnu.text.CaseConvertFormat;
import gnu.text.Char;
import gnu.text.CompoundFormat;
import gnu.text.FlushFormat;
import gnu.text.LiteralFormat;
import gnu.text.ReportFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Stack;
import java.util.Vector;

// Referenced classes of package gnu.kawa.functions:
//            IntegerFormat, LispPluralFormat, LispRealFormat, ObjectFormat, 
//            LispObjectFormat, LispCharacterFormat, LispRepositionFormat, LispIterationFormat, 
//            LispPrettyFormat, LispChoiceFormat, LispEscapeFormat, LispTabulateFormat, 
//            LispFreshlineFormat, LispIndentFormat, LispNewlineFormat

public class LispFormat extends CompoundFormat
{

    public static final String paramFromCount = "<from count>";
    public static final String paramFromList = "<from list>";
    public static final String paramUnspecified = "<unspecified>";

    public LispFormat(String s)
        throws ParseException
    {
        this(s.toCharArray());
    }

    public LispFormat(char ac[])
        throws ParseException
    {
        this(ac, 0, ac.length);
    }

    public LispFormat(char ac[], int i, int j)
        throws ParseException
    {
        StringBuffer stringbuffer;
        Stack stack;
        int k;
        int l1;
        super(null, 0);
        byte byte0 = -1;
        boolean flag = false;
        stringbuffer = new StringBuffer(100);
        stack = new Stack();
        l1 = i + j;
        k = i;
        i = byte0;
        j = ((flag) ? 1 : 0);
_L37:
        int i1;
        do
        {
            if ((k >= l1 || ac[k] == '~') && stringbuffer.length() > 0)
            {
                stack.push(new LiteralFormat(stringbuffer));
                stringbuffer.setLength(0);
            }
            if (k >= l1)
            {
                char c;
                Object obj;
                int l;
                int j1;
                int k1;
                int i2;
                int j2;
                int k2;
                int l2;
                boolean flag1;
                boolean flag2;
                if (k > l1)
                {
                    throw new IndexOutOfBoundsException();
                }
                if (i >= 0)
                {
                    throw new ParseException("missing ~] or ~}", k);
                } else
                {
                    length = stack.size();
                    formats = new Format[length];
                    stack.copyInto(formats);
                    return;
                }
            }
label0:
            {
                i1 = k + 1;
                c = ac[k];
                if (c == '~')
                {
                    break label0;
                }
                stringbuffer.append(c);
                k = i1;
            }
        } while (true);
        l = stack.size();
        k = i1 + 1;
        c = ac[i1];
_L8:
        if (c == '#')
        {
            stack.push("<from count>");
            c = ac[k];
            k++;
        } else
        {
label1:
            {
                if (c != 'v' && c != 'V')
                {
                    break label1;
                }
                stack.push("<from list>");
                c = ac[k];
                k++;
            }
        }
_L5:
        if (c == ',') goto _L2; else goto _L1
_L1:
        flag2 = false;
        flag1 = false;
        i1 = k;
_L4:
        if (c != ':')
        {
            break; /* Loop/switch isn't completed */
        }
        flag2 = true;
_L9:
        c = ac[i1];
        i1++;
        if (true) goto _L4; else goto _L3
        if (c != '-' && Character.digit(c, 10) < 0)
        {
            break MISSING_BLOCK_LABEL_438;
        }
        if (c == '-')
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            i1 = k + 1;
            c = ac[k];
            k = i1;
        }
        i1 = 0;
        j1 = k;
_L6:
label2:
        {
            k1 = Character.digit(c, 10);
            if (k1 >= 0)
            {
                break label2;
            }
            if (j1 - k < 8)
            {
                k = i1;
                if (flag1)
                {
                    k = -i1;
                }
                obj = IntNum.make(k);
            } else
            {
                obj = IntNum.valueOf(ac, k, j1 - k, 10, flag1);
            }
            stack.push(obj);
            k = j1;
        }
          goto _L5
        i1 = i1 * 10 + k1;
        c = ac[j1];
        j1++;
          goto _L6
        if (c != '\'')
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = k + 1;
        stack.push(Char.make(ac[k]));
        k = i1 + 1;
        c = ac[i1];
          goto _L5
        if (c != ',') goto _L1; else goto _L7
_L7:
        stack.push("<unspecified>");
          goto _L5
_L2:
        c = ac[k];
        k++;
          goto _L8
_L3:
label3:
        {
            if (c != '@')
            {
                break label3;
            }
            flag1 = true;
        }
          goto _L9
        c = Character.toUpperCase(c);
        k = stack.size() - l;
        c;
        JVM INSTR lookupswitch 36: default 844
    //                   10: 2559
    //                   33: 2617
    //                   36: 1069
    //                   37: 2912
    //                   38: 2664
    //                   40: 1415
    //                   41: 1502
    //                   42: 1392
    //                   59: 2268
    //                   60: 1760
    //                   62: 1862
    //                   63: 1571
    //                   65: 1240
    //                   66: 874
    //                   67: 1356
    //                   68: 874
    //                   69: 1069
    //                   70: 1069
    //                   71: 1069
    //                   73: 2683
    //                   79: 874
    //                   80: 1057
    //                   82: 874
    //                   83: 1240
    //                   84: 2625
    //                   87: 1240
    //                   88: 874
    //                   89: 1240
    //                   91: 2160
    //                   93: 2411
    //                   94: 2522
    //                   95: 2719
    //                   123: 1602
    //                   124: 2833
    //                   125: 1672
    //                   126: 2813;
           goto _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L24 _L13 _L13 _L13 _L26 _L24 _L27 _L24 _L23 _L28 _L23 _L24 _L23 _L29 _L30 _L31 _L32 _L33 _L34 _L35 _L36
_L10:
        throw new ParseException((new StringBuilder()).append("unrecognized format specifier ~").append(c).toString(), i1);
_L24:
        j1 = l;
        if (c == 'R')
        {
            k = getParam(stack, j1);
            j1++;
        } else
        if (c == 'D')
        {
            k = 10;
        } else
        if (c == 'O')
        {
            k = 8;
        } else
        if (c == 'X')
        {
            k = 16;
        } else
        {
            k = 2;
        }
        i2 = getParam(stack, j1);
        j2 = getParam(stack, j1 + 1);
        k2 = getParam(stack, j1 + 2);
        l2 = getParam(stack, j1 + 3);
        j1 = 0;
        if (flag2)
        {
            j1 = false | true;
        }
        k1 = j1;
        if (flag1)
        {
            k1 = j1 | 2;
        }
        obj = IntegerFormat.getInstance(k, i2, j2, k2, l2, k1);
_L38:
        stack.setSize(l);
        stack.push(obj);
        k = i1;
          goto _L37
_L27:
        obj = LispPluralFormat.getInstance(flag2, flag1);
          goto _L38
_L13:
        obj = new LispRealFormat();
        obj.op = c;
        obj.arg1 = getParam(stack, l);
        obj.arg2 = getParam(stack, l + 1);
        obj.arg3 = getParam(stack, l + 2);
        obj.arg4 = getParam(stack, l + 3);
        if (c != '$')
        {
            obj.arg5 = getParam(stack, l + 4);
            if (c == 'E' || c == 'G')
            {
                obj.arg6 = getParam(stack, l + 5);
                obj.arg7 = getParam(stack, l + 6);
            }
        }
        obj.showPlus = flag1;
        obj.internalPad = flag2;
        if (((LispRealFormat) (obj)).argsUsed == 0)
        {
            obj = ((LispRealFormat) (obj)).resolve(null, 0);
        }
          goto _L38
_L23:
        if (c != 'A')
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        obj = ObjectFormat.getInstance(flag2);
        if (k > 0)
        {
            j1 = getParam(stack, l);
            k1 = getParam(stack, l + 1);
            i2 = getParam(stack, l + 2);
            j2 = getParam(stack, l + 3);
            obj = (ReportFormat)obj;
            if (flag1)
            {
                k = 0;
            } else
            {
                k = 100;
            }
            obj = new LispObjectFormat(((ReportFormat) (obj)), j1, k1, i2, j2, k);
        }
          goto _L38
_L25:
        if (k > 0)
        {
            k = getParam(stack, l);
        } else
        {
            k = 0xa0000000;
        }
        obj = LispCharacterFormat.getInstance(k, 1, flag1, flag2);
          goto _L38
_L18:
        obj = new LispRepositionFormat(getParam(stack, l), flag2, flag1);
          goto _L38
_L16:
        if (flag2)
        {
            if (flag1)
            {
                c = 'U';
            } else
            {
                c = 'C';
            }
        } else
        if (flag1)
        {
            c = 'T';
        } else
        {
            c = 'L';
        }
        obj = new CaseConvertFormat(null, c);
        stack.setSize(l);
        stack.push(obj);
        stack.push(IntNum.make(i));
        i = l;
        k = i1;
          goto _L37
_L17:
        if (i < 0 || !(stack.elementAt(i) instanceof CaseConvertFormat))
        {
            throw new ParseException("saw ~) without matching ~(", i1);
        }
        ((CaseConvertFormat)stack.elementAt(i)).setBaseFormat(popFormats(stack, i + 2, l));
        i = ((IntNum)stack.pop()).intValue();
        k = i1;
          goto _L37
_L22:
        obj = new LispIterationFormat();
        obj.seenAt = flag1;
        obj.maxIterations = 1;
        obj.atLeastOnce = true;
          goto _L38
_L33:
        obj = new LispIterationFormat();
        obj.seenAt = flag1;
        obj.seenColon = flag2;
        obj.maxIterations = getParam(stack, l);
        stack.setSize(l);
        stack.push(obj);
        stack.push(IntNum.make(i));
        i = l;
        k = i1;
          goto _L37
_L35:
        if (i < 0 || !(stack.elementAt(i) instanceof LispIterationFormat))
        {
            throw new ParseException("saw ~} without matching ~{", i1);
        }
        obj = (LispIterationFormat)stack.elementAt(i);
        obj.atLeastOnce = flag2;
        if (l > i + 2)
        {
            obj.body = popFormats(stack, i + 2, l);
        }
        i = ((IntNum)stack.pop()).intValue();
        k = i1;
          goto _L37
_L20:
        obj = new LispPrettyFormat();
        obj.seenAt = flag1;
        if (flag2)
        {
            obj.prefix = "(";
            obj.suffix = ")";
        } else
        {
            obj.prefix = "";
            obj.suffix = "";
        }
        stack.setSize(l);
        stack.push(obj);
        stack.push(IntNum.make(i));
        stack.push(IntNum.make(j));
        i = l;
        j = 0;
        k = i1;
          goto _L37
_L21:
        if (i < 0 || !(stack.elementAt(i) instanceof LispPrettyFormat))
        {
            throw new ParseException("saw ~> without matching ~<", i1);
        }
        stack.push(popFormats(stack, i + 3 + j, l));
        obj = (LispPrettyFormat)stack.elementAt(i);
        obj.segments = getFormats(stack, i + 3, stack.size());
        stack.setSize(i + 3);
        ((IntNum)stack.pop()).intValue();
        l = ((IntNum)stack.pop()).intValue();
        if (flag2)
        {
            j1 = ((LispPrettyFormat) (obj)).segments.length;
            if (j1 > 3)
            {
                throw new ParseException("too many segments in Logical Block format", i1);
            }
            if (j1 >= 2)
            {
                if (!(((LispPrettyFormat) (obj)).segments[0] instanceof LiteralFormat))
                {
                    throw new ParseException("prefix segment is not literal", i1);
                }
                obj.prefix = ((LiteralFormat)((LispPrettyFormat) (obj)).segments[0]).content();
                obj.body = ((LispPrettyFormat) (obj)).segments[1];
            } else
            {
                obj.body = ((LispPrettyFormat) (obj)).segments[0];
            }
            k = i1;
            i = l;
            if (j1 >= 3)
            {
                if (!(((LispPrettyFormat) (obj)).segments[2] instanceof LiteralFormat))
                {
                    throw new ParseException("suffix segment is not literal", i1);
                }
                obj.suffix = ((LiteralFormat)((LispPrettyFormat) (obj)).segments[2]).content();
                k = i1;
                i = l;
            }
        } else
        {
            throw new ParseException("not implemented: justfication i.e. ~<...~>", i1);
        }
          goto _L37
_L29:
        obj = new LispChoiceFormat();
        obj.param = getParam(stack, l);
        if (((LispChoiceFormat) (obj)).param == 0xc0000000)
        {
            obj.param = 0xa0000000;
        }
        if (flag2)
        {
            obj.testBoolean = true;
        }
        if (flag1)
        {
            obj.skipIfFalse = true;
        }
        stack.setSize(l);
        stack.push(obj);
        stack.push(IntNum.make(i));
        stack.push(IntNum.make(j));
        i = l;
        j = 0;
        k = i1;
          goto _L37
_L19:
label4:
        {
            if (i < 0)
            {
                break label4;
            }
            if (stack.elementAt(i) instanceof LispChoiceFormat)
            {
                obj = (LispChoiceFormat)stack.elementAt(i);
                if (flag2)
                {
                    obj.lastIsDefault = true;
                }
                stack.push(popFormats(stack, i + 3 + j, l));
                j++;
                k = i1;
            } else
            {
                if (!(stack.elementAt(i) instanceof LispPrettyFormat))
                {
                    break label4;
                }
                obj = (LispPrettyFormat)stack.elementAt(i);
                if (flag1)
                {
                    obj.perLine = true;
                }
                stack.push(popFormats(stack, i + 3 + j, l));
                j++;
                k = i1;
            }
        }
          goto _L37
        throw new ParseException("saw ~; without matching ~[ or ~<", i1);
_L30:
        if (i < 0 || !(stack.elementAt(i) instanceof LispChoiceFormat))
        {
            throw new ParseException("saw ~] without matching ~[", i1);
        }
        stack.push(popFormats(stack, i + 3 + j, l));
        ((LispChoiceFormat)stack.elementAt(i)).choices = getFormats(stack, i + 3, stack.size());
        stack.setSize(i + 3);
        j = ((IntNum)stack.pop()).intValue();
        i = ((IntNum)stack.pop()).intValue();
        k = i1;
          goto _L37
_L31:
        obj = new LispEscapeFormat(getParam(stack, l), getParam(stack, l + 1), getParam(stack, l + 2));
          goto _L38
_L11:
        if (flag1)
        {
            stringbuffer.append(c);
        }
        k = i1;
        if (flag2) goto _L37; else goto _L39
_L39:
        k = i1;
        if (i1 < l1)
        {
            k = i1 + 1;
            if (Character.isWhitespace(ac[i1]))
            {
                break MISSING_BLOCK_LABEL_2995;
            }
            k--;
        }
          goto _L37
_L12:
        obj = FlushFormat.getInstance();
          goto _L38
_L28:
        obj = new LispTabulateFormat(getParam(stack, l), getParam(stack, l + 1), getParam(stack, l + 2), flag1);
          goto _L38
_L15:
        obj = new LispFreshlineFormat(getParam(stack, l));
          goto _L38
_L26:
        j1 = getParam(stack, l);
        k = j1;
        if (j1 == 0xc0000000)
        {
            k = 0;
        }
        obj = LispIndentFormat.getInstance(k, flag2);
          goto _L38
_L32:
        k = getParam(stack, l);
        j1 = k;
        if (k == 0xc0000000)
        {
            j1 = 1;
        }
        if (!flag2 || !flag1);
        if (flag1 && flag2)
        {
            k = 82;
        } else
        if (flag1)
        {
            k = 77;
        } else
        if (flag2)
        {
            k = 70;
        } else
        {
            k = 78;
        }
        obj = LispNewlineFormat.getInstance(j1, k);
          goto _L38
_L36:
        if (k != 0) goto _L34; else goto _L40
_L40:
        stringbuffer.append(c);
        k = i1;
          goto _L37
_L34:
        k = getParam(stack, l);
        j1 = k;
        if (k == 0xc0000000)
        {
            j1 = 1;
        }
        k1 = getParam(stack, l + 1);
        k = k1;
        if (k1 == 0xc0000000)
        {
            if (c == '|')
            {
                k = 12;
            } else
            {
                k = 126;
            }
        }
        obj = LispCharacterFormat.getInstance(k, j1, false, false);
          goto _L38
_L14:
        j1 = getParam(stack, l);
        k = j1;
        if (j1 == 0xc0000000)
        {
            k = 1;
        }
        obj = LispNewlineFormat.getInstance(k, 76);
          goto _L38
        i1 = k;
          goto _L39
    }

    public static Object[] asArray(Object obj)
    {
        if (obj instanceof Object[])
        {
            return (Object[])(Object[])obj;
        }
        if (!(obj instanceof Sequence))
        {
            return null;
        }
        int k = ((Sequence)obj).size();
        Object aobj[] = new Object[k];
        int i;
        for (i = 0; obj instanceof Pair; i++)
        {
            obj = (Pair)obj;
            aobj[i] = ((Pair) (obj)).getCar();
            obj = ((Pair) (obj)).getCdr();
        }

        if (i < k)
        {
            if (!(obj instanceof Sequence))
            {
                return null;
            }
            obj = (Sequence)obj;
            for (int j = i; j < k; j++)
            {
                aobj[j] = ((Sequence) (obj)).get(i + j);
            }

        }
        return aobj;
    }

    static Format[] getFormats(Vector vector, int i, int j)
    {
        Format aformat[] = new Format[j - i];
        for (int k = i; k < j; k++)
        {
            aformat[k - i] = (Format)vector.elementAt(k);
        }

        return aformat;
    }

    public static int getParam(Vector vector, int i)
    {
        if (i < vector.size())
        {
            vector = ((Vector) (vector.elementAt(i)));
            if (vector == "<from list>")
            {
                return 0xa0000000;
            }
            if (vector == "<from count>")
            {
                return 0xb0000000;
            }
            if (vector != "<unspecified>")
            {
                return getParam(vector, 0xc0000000);
            }
        }
        return 0xc0000000;
    }

    static Format popFormats(Vector vector, int i, int j)
    {
        Object obj;
        if (j == i + 1)
        {
            obj = (Format)vector.elementAt(i);
        } else
        {
            obj = new CompoundFormat(getFormats(vector, i, j));
        }
        vector.setSize(i);
        return ((Format) (obj));
    }
}
