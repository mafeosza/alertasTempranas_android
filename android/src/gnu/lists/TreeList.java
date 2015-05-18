// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import gnu.text.Char;
import java.io.IOException;
import java.io.PrintWriter;

// Referenced classes of package gnu.lists:
//            AbstractSequence, XConsumer, PositionConsumer, Consumable, 
//            SeqPosition, Consumer, Sequence, Convert, 
//            TreePosition, NodePredicate, ElementPredicate, AttributePredicate, 
//            ItemPredicate

public class TreeList extends AbstractSequence
    implements Appendable, XConsumer, PositionConsumer, Consumable
{

    protected static final int BEGIN_ATTRIBUTE_LONG = 61705;
    public static final int BEGIN_ATTRIBUTE_LONG_SIZE = 5;
    protected static final int BEGIN_DOCUMENT = 61712;
    protected static final int BEGIN_ELEMENT_LONG = 61704;
    protected static final int BEGIN_ELEMENT_SHORT = 40960;
    protected static final int BEGIN_ELEMENT_SHORT_INDEX_MAX = 4095;
    public static final int BEGIN_ENTITY = 61714;
    public static final int BEGIN_ENTITY_SIZE = 5;
    static final char BOOL_FALSE = 61696;
    static final char BOOL_TRUE = 61697;
    static final int BYTE_PREFIX = 61440;
    static final int CDATA_SECTION = 61717;
    static final int CHAR_FOLLOWS = 61702;
    static final int COMMENT = 61719;
    protected static final int DOCUMENT_URI = 61720;
    static final int DOUBLE_FOLLOWS = 61701;
    static final int END_ATTRIBUTE = 61706;
    public static final int END_ATTRIBUTE_SIZE = 1;
    protected static final int END_DOCUMENT = 61713;
    protected static final int END_ELEMENT_LONG = 61708;
    protected static final int END_ELEMENT_SHORT = 61707;
    protected static final int END_ENTITY = 61715;
    static final int FLOAT_FOLLOWS = 61700;
    public static final int INT_FOLLOWS = 61698;
    static final int INT_SHORT_ZERO = 49152;
    static final int JOINER = 61718;
    static final int LONG_FOLLOWS = 61699;
    public static final int MAX_CHAR_SHORT = 40959;
    static final int MAX_INT_SHORT = 8191;
    static final int MIN_INT_SHORT = -4096;
    static final char OBJECT_REF_FOLLOWS = 61709;
    static final int OBJECT_REF_SHORT = 57344;
    static final int OBJECT_REF_SHORT_INDEX_MAX = 4095;
    protected static final char POSITION_PAIR_FOLLOWS = 61711;
    static final char POSITION_REF_FOLLOWS = 61710;
    protected static final int PROCESSING_INSTRUCTION = 61716;
    public int attrStart;
    int currentParent;
    public char data[];
    public int docStart;
    public int gapEnd;
    public int gapStart;
    public Object objects[];
    public int oindex;

    public TreeList()
    {
        currentParent = -1;
        resizeObjects();
        gapEnd = 200;
        data = new char[gapEnd];
    }

    public TreeList(TreeList treelist)
    {
        this(treelist, 0, treelist.data.length);
    }

    public TreeList(TreeList treelist, int i, int j)
    {
        this();
        treelist.consumeIRange(i, j, this);
    }

    private Object copyToList(int i, int j)
    {
        return new TreeList(this, i, j);
    }

    public Consumer append(char c)
    {
        write(c);
        return this;
    }

    public Consumer append(CharSequence charsequence)
    {
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        return append(((CharSequence) (obj)), 0, ((CharSequence) (obj)).length());
    }

    public Consumer append(CharSequence charsequence, int i, int j)
    {
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        for (; i < j; i++)
        {
            append(((CharSequence) (obj)).charAt(i));
        }

        return this;
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

    public void beginEntity(Object obj)
    {
        int i = -1;
        if (gapStart != 0)
        {
            return;
        }
        ensureSpace(6);
        gapEnd = gapEnd - 1;
        int j = gapStart;
        data[j] = '\uF112';
        setIntN(j + 1, find(obj));
        if (currentParent != -1)
        {
            i = currentParent - j;
        }
        setIntN(j + 3, i);
        gapStart = j + 5;
        currentParent = j;
        data[gapEnd] = '\uF113';
    }

    public void clear()
    {
        gapStart = 0;
        gapEnd = data.length;
        attrStart = 0;
        if (gapEnd > 1500)
        {
            gapEnd = 200;
            data = new char[gapEnd];
        }
        objects = null;
        oindex = 0;
        resizeObjects();
    }

    public int compare(int i, int j)
    {
        i = posToDataIndex(i);
        j = posToDataIndex(j);
        if (i < j)
        {
            return -1;
        }
        return i <= j ? 0 : 1;
    }

    public void consume(Consumer consumer)
    {
        consumeIRange(0, data.length, consumer);
    }

    public void consume(SeqPosition seqposition)
    {
        ensureSpace(3);
        int i = find(seqposition.copy());
        seqposition = data;
        int j = gapStart;
        gapStart = j + 1;
        seqposition[j] = '\uF10E';
        setIntN(gapStart, i);
        gapStart = gapStart + 2;
    }

    public int consumeIRange(int i, int j, Consumer consumer)
    {
        int k;
        int l;
        l = i;
        char ac[];
        int i1;
        if (i <= gapStart && j > gapStart)
        {
            k = gapStart;
            i = l;
        } else
        {
            k = j;
            i = l;
        }
_L10:
        l = k;
        i1 = i;
        if (i < k) goto _L2; else goto _L1
_L1:
        if (i != gapStart || j <= gapEnd) goto _L4; else goto _L3
_L3:
        i1 = gapEnd;
        l = j;
_L2:
        ac = data;
        i = i1 + 1;
        k = ac[i1];
        if (k > '\u9FFF') goto _L6; else goto _L5
_L5:
        i1 = i - 1;
_L36:
        if (i < l) goto _L8; else goto _L7
_L7:
        consumer.write(data, i1, i - i1);
        k = l;
        break MISSING_BLOCK_LABEL_28;
_L8:
        char ac1[] = data;
        k = i + 1;
        if (ac1[i] <= '\u9FFF')
        {
            break; /* Loop/switch isn't completed */
        }
        i = k - 1;
        if (true) goto _L7; else goto _L9
_L6:
        if (k >= 57344 && k <= 61439)
        {
            consumer.writeObject(objects[k - 57344]);
            k = l;
        } else
        if (k >= 40960 && k <= 45055)
        {
            consumer.startElement(objects[k - 40960]);
            i += 2;
            k = l;
        } else
        {
label0:
            {
                if (k < 45056 || k > 57343)
                {
                    break label0;
                }
                consumer.writeInt(k - 49152);
                k = l;
            }
        }
          goto _L10
        k;
        JVM INSTR tableswitch 61696 61720: default 388
    //                   61696 710
    //                   61697 710
    //                   61698 1073
    //                   61699 1120
    //                   61700 1095
    //                   61701 1142
    //                   61702 757
    //                   61703 388
    //                   61704 941
    //                   61705 1029
    //                   61706 1060
    //                   61707 924
    //                   61708 1005
    //                   61709 897
    //                   61710 857
    //                   61711 786
    //                   61712 416
    //                   61713 433
    //                   61714 446
    //                   61715 481
    //                   61716 645
    //                   61717 583
    //                   61718 741
    //                   61719 537
    //                   61720 502;
           goto _L11 _L12 _L12 _L13 _L14 _L15 _L16 _L17 _L11 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L34
_L11:
        throw new Error((new StringBuilder()).append("unknown code:").append(k).toString());
_L26:
        consumer.startDocument();
        i += 4;
        k = l;
          goto _L10
_L27:
        consumer.endDocument();
        k = l;
          goto _L10
_L28:
        if (consumer instanceof TreeList)
        {
            ((TreeList)consumer).beginEntity(objects[getIntN(i)]);
        }
        i += 4;
        k = l;
          goto _L10
_L29:
        if (consumer instanceof TreeList)
        {
            ((TreeList)consumer).endEntity();
            k = l;
        } else
        {
            k = l;
        }
          goto _L10
_L34:
        if (consumer instanceof TreeList)
        {
            ((TreeList)consumer).writeDocumentUri(objects[getIntN(i)]);
        }
        i += 2;
        k = l;
          goto _L10
_L33:
        k = getIntN(i);
        i += 2;
        if (consumer instanceof XConsumer)
        {
            ((XConsumer)consumer).writeComment(data, i, k);
        }
        i += k;
        k = l;
          goto _L10
_L31:
        k = getIntN(i);
        i += 2;
        if (consumer instanceof XConsumer)
        {
            ((XConsumer)consumer).writeCDATA(data, i, k);
        } else
        {
            consumer.write(data, i, k);
        }
        i += k;
        k = l;
          goto _L10
_L30:
        String s = (String)objects[getIntN(i)];
        k = getIntN(i + 2);
        i += 4;
        if (consumer instanceof XConsumer)
        {
            ((XConsumer)consumer).writeProcessingInstruction(s, data, i, k);
        }
        i += k;
        k = l;
          goto _L10
_L12:
        boolean flag;
        if (k != 61696)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        consumer.writeBoolean(flag);
        k = l;
          goto _L10
_L32:
        consumer.write("");
        k = l;
          goto _L10
_L17:
        consumer.write(data, i, (k + 1) - 61702);
        i++;
        k = l;
          goto _L10
_L25:
        AbstractSequence abstractsequence = (AbstractSequence)objects[getIntN(i)];
        k = getIntN(i + 2);
        if (consumer instanceof PositionConsumer)
        {
            ((PositionConsumer)consumer).writePosition(abstractsequence, k);
        } else
        {
            consumer.writeObject(abstractsequence.getIteratorAtPos(k));
        }
        i += 4;
        k = l;
          goto _L10
_L24:
        if (!(consumer instanceof PositionConsumer)) goto _L23; else goto _L35
_L35:
        ((PositionConsumer)consumer).consume((SeqPosition)objects[getIntN(i)]);
        i += 2;
        k = l;
          goto _L10
_L23:
        consumer.writeObject(objects[getIntN(i)]);
        i += 2;
        k = l;
          goto _L10
_L21:
        i++;
        consumer.endElement();
        k = l;
          goto _L10
_L18:
        int j1 = getIntN(i);
        if (j1 >= 0)
        {
            k = i - 1;
        } else
        {
            k = data.length;
        }
        i += 2;
        k = getIntN(j1 + k + 1);
        consumer.startElement(objects[k]);
        k = l;
          goto _L10
_L22:
        getIntN(i);
        consumer.endElement();
        i += 6;
        k = l;
          goto _L10
_L19:
        k = getIntN(i);
        consumer.startAttribute(objects[k]);
        i += 4;
        k = l;
          goto _L10
_L20:
        consumer.endAttribute();
        k = l;
          goto _L10
_L13:
        consumer.writeInt(getIntN(i));
        i += 2;
        k = l;
          goto _L10
_L15:
        consumer.writeFloat(Float.intBitsToFloat(getIntN(i)));
        i += 2;
        k = l;
          goto _L10
_L14:
        consumer.writeLong(getLongN(i));
        i += 4;
        k = l;
          goto _L10
_L16:
        consumer.writeDouble(Double.longBitsToDouble(getLongN(i)));
        i += 4;
        k = l;
          goto _L10
_L4:
        return i;
_L9:
        i = k;
          goto _L36
    }

    public boolean consumeNext(int i, Consumer consumer)
    {
        if (!hasNext(i))
        {
            return false;
        }
        int k = posToDataIndex(i);
        int j = nextNodeIndex(k, 0x7fffffff);
        i = j;
        if (j == k)
        {
            i = nextDataIndex(k);
        }
        if (i >= 0)
        {
            consumeIRange(k, i, consumer);
        }
        return true;
    }

    public void consumePosRange(int i, int j, Consumer consumer)
    {
        consumeIRange(posToDataIndex(i), posToDataIndex(j), consumer);
    }

    public int createPos(int i, boolean flag)
    {
        return createRelativePos(0, i, flag);
    }

    public int createRelativePos(int i, int j, boolean flag)
    {
        int k = j;
        if (flag)
        {
            if (j == 0)
            {
                if ((i & 1) != 0)
                {
                    return i;
                }
                if (i == 0)
                {
                    return 1;
                }
            }
            k = j - 1;
        }
        if (k < 0)
        {
            throw unsupported("backwards createRelativePos");
        }
        i = posToDataIndex(i);
        do
        {
            k--;
            if (k >= 0)
            {
                j = nextDataIndex(i);
                i = j;
                if (j < 0)
                {
                    throw new IndexOutOfBoundsException();
                }
            } else
            {
                j = i;
                if (i >= gapEnd)
                {
                    j = i - (gapEnd - gapStart);
                }
                if (flag)
                {
                    i = j + 1 << 1 | 1;
                } else
                {
                    i = j << 1;
                }
                return i;
            }
        } while (true);
    }

    public Object documentUriOfPos(int i)
    {
        i = posToDataIndex(i);
        break MISSING_BLOCK_LABEL_6;
        if (i != data.length && data[i] == '\uF110')
        {
            int j = i + 5;
            i = j;
            if (j == gapStart)
            {
                i = gapEnd;
            }
            if (i < data.length && data[i] == '\uF118')
            {
                return objects[getIntN(i + 1)];
            }
        }
        return null;
    }

    public void dump()
    {
        PrintWriter printwriter = new PrintWriter(System.out);
        dump(printwriter);
        printwriter.flush();
    }

    public void dump(PrintWriter printwriter)
    {
        printwriter.println((new StringBuilder()).append(getClass().getName()).append(" @").append(Integer.toHexString(System.identityHashCode(this))).append(" gapStart:").append(gapStart).append(" gapEnd:").append(gapEnd).append(" length:").append(data.length).toString());
        dump(printwriter, 0, data.length);
    }

    public void dump(PrintWriter printwriter, int i, int j)
    {
        int k;
        boolean flag = false;
        k = i;
        i = ((flag) ? 1 : 0);
_L11:
        if (k >= j)
        {
            break MISSING_BLOCK_LABEL_1772;
        }
        if (k < gapStart) goto _L2; else goto _L1
_L1:
        int l;
        int i1;
        i1 = k;
        l = i;
        if (k < gapEnd) goto _L3; else goto _L2
_L2:
        i1 = data[k];
        printwriter.print((new StringBuilder()).append("").append(k).append(": 0x").append(Integer.toHexString(i1)).append('=').append((short)i1).toString());
        l = i - 1;
        i = l;
        if (l >= 0) goto _L5; else goto _L4
_L4:
        if (i1 > 40959) goto _L7; else goto _L6
_L6:
        if (i1 >= 32 && i1 < 127)
        {
            printwriter.print((new StringBuilder()).append("='").append((char)i1).append("'").toString());
            i = l;
        } else
        if (i1 == 10)
        {
            printwriter.print("='\\n'");
            i = l;
        } else
        {
            printwriter.print((new StringBuilder()).append("='\\u").append(Integer.toHexString(i1)).append("'").toString());
            i = l;
        }
_L5:
        printwriter.println();
        i1 = k;
        l = i;
        if (true)
        {
            i1 = k;
            l = i;
            if (i > 0)
            {
                i1 = k + i;
                l = 0;
            }
        }
_L3:
        k = i1 + 1;
        i = l;
        continue; /* Loop/switch isn't completed */
_L7:
        if (i1 >= 57344 && i1 <= 61439)
        {
            i = i1 - 57344;
            Object obj = objects[i];
            printwriter.print((new StringBuilder()).append("=Object#").append(i).append('=').append(obj).append(':').append(obj.getClass().getName()).append('@').append(Integer.toHexString(System.identityHashCode(obj))).toString());
            i = l;
            continue; /* Loop/switch isn't completed */
        }
        if (i1 >= 40960 && i1 <= 45055)
        {
            i = i1 - 40960;
            l = data[k + 1];
            printwriter.print((new StringBuilder()).append("=BEGIN_ELEMENT_SHORT end:").append(l + k).append(" index#").append(i).append("=<").append(objects[i]).append('>').toString());
            i = 2;
            continue; /* Loop/switch isn't completed */
        }
        if (i1 < 45056 || i1 > 57343)
        {
            break; /* Loop/switch isn't completed */
        }
        printwriter.print((new StringBuilder()).append("= INT_SHORT:").append(i1 - 49152).toString());
        i = l;
        if (true) goto _L5; else goto _L8
_L8:
        switch (i1)
        {
        case 61703: 
        default:
            i = l;
            break;

        case 61696: 
            printwriter.print("= false");
            i = l;
            break;

        case 61698: 
            i = getIntN(k + 1);
            printwriter.print((new StringBuilder()).append("=INT_FOLLOWS value:").append(i).toString());
            i = 2;
            break;

        case 61699: 
            long l1 = getLongN(k + 1);
            printwriter.print((new StringBuilder()).append("=LONG_FOLLOWS value:").append(l1).toString());
            i = 4;
            break;

        case 61700: 
            i = getIntN(k + 1);
            printwriter.write((new StringBuilder()).append("=FLOAT_FOLLOWS value:").append(Float.intBitsToFloat(i)).toString());
            i = 2;
            break;

        case 61701: 
            long l2 = getLongN(k + 1);
            printwriter.print((new StringBuilder()).append("=DOUBLE_FOLLOWS value:").append(Double.longBitsToDouble(l2)).toString());
            i = 4;
            break;

        case 61712: 
            l = getIntN(k + 1);
            if (l < 0)
            {
                i = data.length;
            } else
            {
                i = k;
            }
            printwriter.print("=BEGIN_DOCUMENT end:");
            printwriter.print(l + i);
            printwriter.print(" parent:");
            printwriter.print(getIntN(k + 3));
            i = 4;
            break;

        case 61714: 
            i = getIntN(k + 1);
            printwriter.print("=BEGIN_ENTITY base:");
            printwriter.print(i);
            printwriter.print(" parent:");
            printwriter.print(getIntN(k + 3));
            i = 4;
            break;

        case 61715: 
            printwriter.print("=END_ENTITY");
            i = l;
            break;

        case 61720: 
            printwriter.print("=DOCUMENT_URI: ");
            i = getIntN(k + 1);
            printwriter.print(objects[i]);
            i = 2;
            break;

        case 61719: 
            printwriter.print("=COMMENT: '");
            i = getIntN(k + 1);
            printwriter.write(data, k + 3, i);
            printwriter.print('\'');
            i += 2;
            break;

        case 61717: 
            printwriter.print("=CDATA: '");
            i = getIntN(k + 1);
            printwriter.write(data, k + 3, i);
            printwriter.print('\'');
            i += 2;
            break;

        case 61716: 
            printwriter.print("=PROCESSING_INSTRUCTION: ");
            i = getIntN(k + 1);
            printwriter.print(objects[i]);
            printwriter.print(" '");
            i = getIntN(k + 3);
            printwriter.write(data, k + 5, i);
            printwriter.print('\'');
            i += 4;
            break;

        case 61713: 
            printwriter.print("=END_DOCUMENT");
            i = l;
            break;

        case 61697: 
            printwriter.print("= true");
            i = l;
            break;

        case 61718: 
            printwriter.print("= joiner");
            i = l;
            break;

        case 61702: 
            printwriter.print("=CHAR_FOLLOWS");
            i = 1;
            break;

        case 61709: 
        case 61710: 
            i = 2;
            break;

        case 61707: 
            printwriter.print("=END_ELEMENT_SHORT begin:");
            i = k - data[k + 1];
            printwriter.print(i);
            i = data[i] - 40960;
            printwriter.print(" -> #");
            printwriter.print(i);
            printwriter.print("=<");
            printwriter.print(objects[i]);
            printwriter.print('>');
            i = 1;
            break;

        case 61704: 
            l = getIntN(k + 1);
            if (l < 0)
            {
                i = data.length;
            } else
            {
                i = k;
            }
            i = l + i;
            printwriter.print("=BEGIN_ELEMENT_LONG end:");
            printwriter.print(i);
            i = getIntN(i + 1);
            printwriter.print(" -> #");
            printwriter.print(i);
            if (i >= 0 && i + 1 < objects.length)
            {
                printwriter.print((new StringBuilder()).append("=<").append(objects[i]).append('>').toString());
            } else
            {
                printwriter.print("=<out-of-bounds>");
            }
            i = 2;
            break;

        case 61708: 
            i = getIntN(k + 1);
            printwriter.print((new StringBuilder()).append("=END_ELEMENT_LONG name:").append(i).append("=<").append(objects[i]).append('>').toString());
            l = getIntN(k + 3);
            i = l;
            if (l < 0)
            {
                i = l + k;
            }
            printwriter.print((new StringBuilder()).append(" begin:").append(i).toString());
            l = getIntN(k + 5);
            i = l;
            if (l < 0)
            {
                i = l + k;
            }
            printwriter.print((new StringBuilder()).append(" parent:").append(i).toString());
            i = 6;
            break;

        case 61705: 
            i = getIntN(k + 1);
            printwriter.print((new StringBuilder()).append("=BEGIN_ATTRIBUTE name:").append(i).append("=").append(objects[i]).toString());
            l = getIntN(k + 3);
            if (l < 0)
            {
                i = data.length;
            } else
            {
                i = k;
            }
            printwriter.print((new StringBuilder()).append(" end:").append(l + i).toString());
            i = 4;
            break;

        case 61706: 
            printwriter.print("=END_ATTRIBUTE");
            i = l;
            break;

        case 61711: 
            printwriter.print("=POSITION_PAIR_FOLLOWS seq:");
            i = getIntN(k + 1);
            printwriter.print(i);
            printwriter.print('=');
            Object obj1 = objects[i];
            String s;
            if (obj1 == null)
            {
                s = null;
            } else
            {
                s = obj1.getClass().getName();
            }
            printwriter.print(s);
            printwriter.print('@');
            if (obj1 == null)
            {
                printwriter.print("null");
            } else
            {
                printwriter.print(Integer.toHexString(System.identityHashCode(obj1)));
            }
            printwriter.print(" ipos:");
            printwriter.print(getIntN(k + 3));
            i = 4;
            break;
        }
        if (true) goto _L5; else goto _L9
_L9:
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public void endAttribute()
    {
        if (attrStart <= 0)
        {
            return;
        }
        if (data[gapEnd] != '\uF10A')
        {
            throw new Error("unexpected endAttribute");
        } else
        {
            gapEnd = gapEnd + 1;
            setIntN(attrStart + 2, (gapStart - attrStart) + 1);
            attrStart = 0;
            char ac[] = data;
            int i = gapStart;
            gapStart = i + 1;
            ac[i] = '\uF10A';
            return;
        }
    }

    public void endDocument()
    {
        if (data[gapEnd] != '\uF111' || docStart <= 0 || data[currentParent] != '\uF110')
        {
            throw new Error("unexpected endDocument");
        }
        gapEnd = gapEnd + 1;
        setIntN(docStart, (gapStart - docStart) + 1);
        docStart = 0;
        char ac[] = data;
        int i = gapStart;
        gapStart = i + 1;
        ac[i] = '\uF111';
        i = getIntN(currentParent + 3);
        if (i < -1)
        {
            i += currentParent;
        }
        currentParent = i;
    }

    public void endElement()
    {
        int i;
label0:
        {
            if (data[gapEnd] != '\uF10C')
            {
                throw new Error("unexpected endElement");
            }
            i = getIntN(gapEnd + 1);
            int k = getIntN(gapEnd + 3);
            int j = getIntN(gapEnd + 5);
            currentParent = j;
            gapEnd = gapEnd + 7;
            int l = gapStart - k;
            int i1 = k - j;
            if (i < 4095 && l < 0x10000 && i1 < 0x10000)
            {
                data[k] = (char)(0xa000 | i);
                data[k + 1] = (char)l;
                data[k + 2] = (char)i1;
                data[gapStart] = '\uF10B';
                data[gapStart + 1] = (char)l;
                gapStart = gapStart + 2;
                return;
            }
            data[k] = '\uF108';
            setIntN(k + 1, l);
            data[gapStart] = '\uF10C';
            setIntN(gapStart + 1, i);
            setIntN(gapStart + 3, -l);
            if (j < gapStart)
            {
                i = j;
                if (k > gapStart)
                {
                    break label0;
                }
            }
            i = j - gapStart;
        }
        setIntN(gapStart + 5, i);
        gapStart = gapStart + 7;
    }

    public void endEntity()
    {
        if (gapEnd + 1 != data.length || data[gapEnd] != '\uF113')
        {
            return;
        }
        if (data[currentParent] != '\uF112')
        {
            throw new Error("unexpected endEntity");
        }
        gapEnd = gapEnd + 1;
        char ac[] = data;
        int i = gapStart;
        gapStart = i + 1;
        ac[i] = '\uF113';
        i = getIntN(currentParent + 3);
        if (i < -1)
        {
            i += currentParent;
        }
        currentParent = i;
    }

    public void ensureSpace(int i)
    {
        int j = gapEnd - gapStart;
        if (i > j)
        {
            int l = data.length;
            j = (l - j) + i;
            int k = l * 2;
            i = k;
            if (k < j)
            {
                i = j;
            }
            char ac[] = new char[i];
            if (gapStart > 0)
            {
                System.arraycopy(data, 0, ac, 0, gapStart);
            }
            j = l - gapEnd;
            if (j > 0)
            {
                System.arraycopy(data, gapEnd, ac, i - j, j);
            }
            gapEnd = i - j;
            data = ac;
        }
    }

    public int find(Object obj)
    {
        if (oindex == objects.length)
        {
            resizeObjects();
        }
        objects[oindex] = obj;
        int i = oindex;
        oindex = i + 1;
        return i;
    }

    public int firstAttributePos(int i)
    {
        i = gotoAttributesStart(posToDataIndex(i));
        if (i < 0)
        {
            return 0;
        } else
        {
            return i << 1;
        }
    }

    public int firstChildPos(int i)
    {
        i = gotoChildrenStart(posToDataIndex(i));
        if (i < 0)
        {
            return 0;
        } else
        {
            return i << 1;
        }
    }

    public Object get(int i)
    {
        boolean flag = false;
        int j = i;
        i = ((flag) ? 1 : 0);
        do
        {
            j--;
            if (j >= 0)
            {
                int k = nextPos(i);
                i = k;
                if (k == 0)
                {
                    throw new IndexOutOfBoundsException();
                }
            } else
            {
                return getPosNext(i);
            }
        } while (true);
    }

    public int getAttributeCount(int i)
    {
        int j = 0;
        for (i = firstAttributePos(i); i != 0 && getNextKind(i) == 35; i = nextPos(i))
        {
            j++;
        }

        return j;
    }

    protected int getIndexDifference(int i, int j)
    {
        int l = posToDataIndex(j);
        int i1 = posToDataIndex(i);
        j = 0;
        i = l;
        int k = i1;
        if (l > i1)
        {
            j = 1;
            k = l;
            i = i1;
        }
        i1 = 0;
        l = i;
        for (i = i1; l < k; i++)
        {
            l = nextDataIndex(l);
        }

        k = i;
        if (j != 0)
        {
            k = -i;
        }
        return k;
    }

    protected final int getIntN(int i)
    {
        return data[i] << 16 | data[i + 1] & 0xffff;
    }

    protected final long getLongN(int i)
    {
        char ac[] = data;
        return ((long)ac[i] & 65535L) << 48 | ((long)ac[i + 1] & 65535L) << 32 | ((long)ac[i + 2] & 65535L) << 16 | (long)ac[i + 3] & 65535L;
    }

    public int getNextKind(int i)
    {
        return getNextKindI(posToDataIndex(i));
    }

    public int getNextKindI(int i)
    {
        if (i != data.length) goto _L2; else goto _L1
_L1:
        return 0;
_L2:
        char c = data[i];
        if (c <= '\u9FFF')
        {
            return 29;
        }
        if (c >= '\uE000' && c <= '\uEFFF')
        {
            return 32;
        }
        if (c >= '\uA000' && c <= '\uAFFF')
        {
            return 33;
        }
        if ((0xff00 & c) == 61440)
        {
            return 28;
        }
        if (c >= '\uB000' && c <= '\uDFFF')
        {
            return 22;
        }
        switch (c)
        {
        case 61703: 
        case 61709: 
        case 61710: 
        case 61711: 
        case 61718: 
        default:
            return 32;

        case 61696: 
        case 61697: 
            return 27;

        case 61698: 
            return 22;

        case 61699: 
            return 24;

        case 61700: 
            return 25;

        case 61701: 
            return 26;

        case 61702: 
        case 61712: 
            return 34;

        case 61714: 
            return getNextKind(i + 5 << 1);

        case 61704: 
            return 33;

        case 61705: 
            return 35;

        case 61717: 
            return 31;

        case 61719: 
            return 36;

        case 61716: 
            return 37;

        case 61706: 
        case 61707: 
        case 61708: 
        case 61713: 
        case 61715: 
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public String getNextTypeName(int i)
    {
        Object obj = getNextTypeObject(i);
        if (obj == null)
        {
            return null;
        } else
        {
            return obj.toString();
        }
    }

    public Object getNextTypeObject(int i)
    {
        i = posToDataIndex(i);
_L4:
        if (i != data.length) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int j;
        j = data[i];
        if (j == 61714)
        {
            break; /* Loop/switch isn't completed */
        }
        if (j >= 40960 && j <= 45055)
        {
            i = j - 40960;
        } else
        if (j == 61704)
        {
            j = getIntN(i + 1);
            if (j < 0)
            {
                i = data.length;
            }
            i = getIntN(j + i + 1);
        } else
        {
            if (j != 61705)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = getIntN(i + 1);
        }
_L6:
        if (i >= 0)
        {
            return objects[i];
        }
        if (true) goto _L1; else goto _L3
_L3:
        i += 5;
          goto _L4
        if (j != 61716) goto _L1; else goto _L5
_L5:
        i = getIntN(i + 1);
          goto _L6
    }

    public Object getPosNext(int i)
    {
        i = posToDataIndex(i);
        if (i == data.length)
        {
            return Sequence.eofValue;
        }
        char c = data[i];
        if (c <= '\u9FFF')
        {
            return Convert.toObject(c);
        }
        if (c >= '\uE000' && c <= '\uEFFF')
        {
            return objects[c - 57344];
        }
        if (c >= '\uA000' && c <= '\uAFFF')
        {
            return copyToList(i, data[i + 1] + i + 2);
        }
        if (c >= '\uB000' && c <= '\uDFFF')
        {
            return Convert.toObject(c - 49152);
        }
        switch (c)
        {
        case 61703: 
        case 61714: 
        case 61715: 
        case 61716: 
        case 61717: 
        default:
            throw unsupported((new StringBuilder()).append("getPosNext, code=").append(Integer.toHexString(c)).toString());

        case 61712: 
            int i1 = getIntN(i + 1);
            int j;
            if (i1 < 0)
            {
                j = data.length;
            } else
            {
                j = i;
            }
            return copyToList(i, i1 + j + 1);

        case 61696: 
        case 61697: 
            boolean flag;
            if (c != '\uF100')
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return Convert.toObject(flag);

        case 61698: 
            return Convert.toObject(getIntN(i + 1));

        case 61699: 
            return Convert.toObject(getLongN(i + 1));

        case 61700: 
            return Convert.toObject(Float.intBitsToFloat(getIntN(i + 1)));

        case 61701: 
            return Convert.toObject(Double.longBitsToDouble(getLongN(i + 1)));

        case 61702: 
            return Convert.toObject(data[i + 1]);

        case 61705: 
            int j1 = getIntN(i + 3);
            int k;
            if (j1 < 0)
            {
                k = data.length;
            } else
            {
                k = i;
            }
            return copyToList(i, j1 + k + 1);

        case 61704: 
            int k1 = getIntN(i + 1);
            int l;
            if (k1 < 0)
            {
                l = data.length;
            } else
            {
                l = i;
            }
            return copyToList(i, k1 + l + 7);

        case 61706: 
        case 61707: 
        case 61708: 
        case 61713: 
            return Sequence.eofValue;

        case 61709: 
        case 61710: 
            return objects[getIntN(i + 1)];

        case 61718: 
            return "";

        case 61711: 
            return ((AbstractSequence)objects[getIntN(i + 1)]).getIteratorAtPos(getIntN(i + 3));
        }
    }

    public int getPosNextInt(int i)
    {
        int j = posToDataIndex(i);
        if (j < data.length)
        {
            char c = data[j];
            if (c >= '\uB000' && c <= '\uDFFF')
            {
                return c - 49152;
            }
            if (c == '\uF102')
            {
                return getIntN(j + 1);
            }
        }
        return ((Number)getPosNext(i)).intValue();
    }

    public Object getPosPrevious(int i)
    {
        if ((i & 1) != 0 && i != -1)
        {
            return getPosNext(i - 3);
        } else
        {
            return super.getPosPrevious(i);
        }
    }

    public int gotoAttributesStart(int i)
    {
        int j = i;
        if (i >= gapStart)
        {
            j = i + (gapEnd - gapStart);
        }
        if (j != data.length)
        {
            if ((i = data[j]) >= 40960 && i <= 45055 || i == 61704)
            {
                return j + 3;
            }
        }
        return -1;
    }

    public boolean gotoAttributesStart(TreePosition treeposition)
    {
        int i = gotoAttributesStart(treeposition.ipos >> 1);
        if (i < 0)
        {
            return false;
        } else
        {
            treeposition.push(this, i << 1);
            return true;
        }
    }

    public final int gotoChildrenStart(int i)
    {
        if (i != data.length) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        int j;
        j = data[i];
        if ((j < 40960 || j > 45055) && j != 61704)
        {
            continue; /* Loop/switch isn't completed */
        }
        i += 3;
_L4:
        do
        {
            j = i;
            if (i >= gapStart)
            {
                j = i + (gapEnd - gapStart);
            }
            i = data[j];
            if (i == 61705)
            {
                i = getIntN(j + 3);
                if (i < 0)
                {
                    j = data.length;
                }
                i = j + i;
            } else
            if (i == 61706 || i == 61718)
            {
                i = j + 1;
            } else
            if (i == 61720)
            {
                i = j + 3;
            } else
            {
                return j;
            }
        } while (true);
        if (j != 61712 && j != 61714) goto _L1; else goto _L3
_L3:
        i += 5;
          goto _L4
    }

    public boolean hasNext(int i)
    {
        i = posToDataIndex(i);
        if (i != data.length)
        {
            if ((i = data[i]) != 61706 && i != 61707 && i != 61708 && i != 61713)
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return System.identityHashCode(this);
    }

    public boolean ignoring()
    {
        return false;
    }

    public boolean isEmpty()
    {
        boolean flag = false;
        int i;
        if (gapStart == 0)
        {
            i = gapEnd;
        } else
        {
            i = 0;
        }
        if (i == data.length)
        {
            flag = true;
        }
        return flag;
    }

    public final int nextDataIndex(int i)
    {
        int j = i;
        if (i == gapStart)
        {
            j = gapEnd;
        }
        if (j == data.length)
        {
            return -1;
        }
        char ac[] = data;
        i = j + 1;
        j = ac[j];
        if (j <= '\u9FFF' || j >= '\uE000' && j <= '\uEFFF' || j >= '\uB000' && j <= '\uDFFF')
        {
            return i;
        }
        if (j >= '\uA000' && j <= '\uAFFF')
        {
            return data[i] + i + 1;
        }
        switch (j)
        {
        case 61703: 
        default:
            throw new Error((new StringBuilder()).append("unknown code:").append(Integer.toHexString(j)).toString());

        case 61712: 
            int k = getIntN(i);
            if (k < 0)
            {
                i = data.length;
            } else
            {
                i--;
            }
            return k + i + 1;

        case 61714: 
            i += 4;
            do
            {
                int l = i;
                if (i == gapStart)
                {
                    l = gapEnd;
                }
                if (l == data.length)
                {
                    return -1;
                }
                if (data[l] == '\uF113')
                {
                    return l + 1;
                }
                i = nextDataIndex(l);
            } while (true);

        case 61696: 
        case 61697: 
        case 61718: 
            return i;

        case 61702: 
            return i + 1;

        case 61698: 
        case 61700: 
        case 61709: 
        case 61710: 
            return i + 2;

        case 61711: 
            return i + 4;

        case 61706: 
        case 61707: 
        case 61708: 
        case 61713: 
        case 61715: 
            return -1;

        case 61704: 
            int i1 = getIntN(i);
            if (i1 < 0)
            {
                i = data.length;
            } else
            {
                i--;
            }
            return i1 + i + 7;

        case 61705: 
            int j1 = getIntN(i + 2);
            if (j1 < 0)
            {
                i = data.length;
            } else
            {
                i--;
            }
            return j1 + i + 1;

        case 61699: 
        case 61701: 
            return i + 4;

        case 61716: 
            i += 2;
            // fall through

        case 61717: 
        case 61719: 
            return i + 2 + getIntN(i);
        }
    }

    public int nextMatching(int i, ItemPredicate itempredicate, int j, boolean flag)
    {
        int k;
        boolean flag1;
        boolean flag2;
        int l;
        l = posToDataIndex(i);
        int i1 = posToDataIndex(j);
        j = l;
        i = j;
        if (itempredicate instanceof NodePredicate)
        {
            i = nextNodeIndex(j, i1);
        }
        if (itempredicate instanceof ElementPredicate)
        {
            flag1 = true;
            flag2 = false;
        } else
        if (itempredicate instanceof AttributePredicate)
        {
            flag1 = false;
            flag2 = false;
        } else
        {
            flag1 = true;
            flag2 = true;
        }
_L41:
        k = i;
        if (i == gapStart)
        {
            k = gapEnd;
        }
        if (k >= i1 && i1 != -1)
        {
            return 0;
        }
        i = data[k];
        if (i <= 40959 || i >= 57344 && i <= 61439 || i >= 45056 && i <= 57343)
        {
            if (flag2 && itempredicate.isInstancePos(this, k << 1))
            {
                i = k;
                if (k >= gapEnd)
                {
                    i = k - (gapEnd - gapStart);
                }
                return i << 1;
            }
            i = k + 1;
            continue; /* Loop/switch isn't completed */
        }
        i;
        JVM INSTR tableswitch 61696 61720: default 312
    //                   61696 561
    //                   61697 561
    //                   61698 425
    //                   61699 584
    //                   61700 425
    //                   61701 584
    //                   61702 440
    //                   61703 312
    //                   61704 669
    //                   61705 509
    //                   61706 494
    //                   61707 448
    //                   61708 478
    //                   61709 425
    //                   61710 425
    //                   61711 463
    //                   61712 403
    //                   61713 494
    //                   61714 417
    //                   61715 501
    //                   61716 599
    //                   61717 645
    //                   61718 576
    //                   61719 622
    //                   61720 395;
           goto _L1 _L2 _L2 _L3 _L4 _L3 _L4 _L5 _L1 _L6 _L7 _L8 _L9 _L10 _L3 _L3 _L11 _L12 _L8 _L13 _L14 _L15 _L16 _L17 _L18 _L19
_L1:
        if (i < 40960 || i > 45055) goto _L21; else goto _L20
_L20:
        if (flag)
        {
            j = k + 3;
        } else
        {
            j = data[k + 1] + k + 2;
        }
        i = j;
        if (!flag1)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = j;
        if (k <= l)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (itempredicate.isInstancePos(this, k << 1))
        {
            i = k;
            if (k >= gapEnd)
            {
                i = k - (gapEnd - gapStart);
            }
            return i << 1;
        } else
        {
            break; /* Loop/switch isn't completed */
        }
_L19:
        i = k + 3;
        break; /* Loop/switch isn't completed */
_L12:
        j = k + 5;
        i = j;
        if (false) goto _L23; else goto _L22
_L22:
        break MISSING_BLOCK_LABEL_341;
_L23:
        break; /* Loop/switch isn't completed */
_L13:
        i = k + 5;
        break; /* Loop/switch isn't completed */
_L3:
        j = k + 3;
        i = j;
        if (!flag2) goto _L25; else goto _L24
_L24:
        break MISSING_BLOCK_LABEL_341;
_L25:
        break; /* Loop/switch isn't completed */
_L5:
        i = k + 2;
        break; /* Loop/switch isn't completed */
_L9:
        if (!flag)
        {
            return 0;
        }
        i = k + 2;
        break; /* Loop/switch isn't completed */
_L11:
        j = k + 5;
        i = j;
        if (!flag2) goto _L27; else goto _L26
_L26:
        break MISSING_BLOCK_LABEL_341;
_L27:
        break; /* Loop/switch isn't completed */
_L10:
        if (!flag)
        {
            return 0;
        }
        i = k + 7;
        break; /* Loop/switch isn't completed */
_L8:
        if (!flag)
        {
            return 0;
        }
_L14:
        i = k + 1;
        break; /* Loop/switch isn't completed */
_L7:
        if (true)
        {
            j = getIntN(k + 3);
            if (j < 0)
            {
                i = data.length;
            } else
            {
                i = k;
            }
            j = j + 1 + i;
        } else
        {
            j = k + 5;
        }
        i = j;
        if (true) goto _L29; else goto _L28
_L28:
        break MISSING_BLOCK_LABEL_341;
_L29:
        break; /* Loop/switch isn't completed */
_L2:
        j = k + 1;
        i = j;
        if (!flag2) goto _L31; else goto _L30
_L30:
        break MISSING_BLOCK_LABEL_341;
_L31:
        break; /* Loop/switch isn't completed */
_L17:
        i = k + 1;
        break; /* Loop/switch isn't completed */
_L4:
        j = k + 5;
        i = j;
        if (!flag2) goto _L33; else goto _L32
_L32:
        break MISSING_BLOCK_LABEL_341;
_L33:
        break; /* Loop/switch isn't completed */
_L15:
        j = k + 5 + getIntN(k + 3);
        i = j;
        if (false) goto _L35; else goto _L34
_L34:
        break MISSING_BLOCK_LABEL_341;
_L35:
        break; /* Loop/switch isn't completed */
_L18:
        j = k + 3 + getIntN(k + 1);
        i = j;
        if (false) goto _L37; else goto _L36
_L36:
        break MISSING_BLOCK_LABEL_341;
_L37:
        break; /* Loop/switch isn't completed */
_L16:
        j = k + 3 + getIntN(k + 1);
        i = j;
        if (!flag2) goto _L39; else goto _L38
_L38:
        break MISSING_BLOCK_LABEL_341;
_L39:
        break; /* Loop/switch isn't completed */
_L6:
        if (flag)
        {
            j = k + 3;
        } else
        {
            j = getIntN(k + 1);
            if (j < 0)
            {
                i = data.length;
            } else
            {
                i = k;
            }
            j = i + j + 7;
        }
        i = j;
        if (!flag1) goto _L41; else goto _L40
_L40:
        break MISSING_BLOCK_LABEL_341;
_L21:
        throw new Error((new StringBuilder()).append("unknown code:").append(i).toString());
        if (true) goto _L41; else goto _L42
_L42:
    }

    public final int nextNodeIndex(int i, int j)
    {
        int k;
        int l;
        k = i;
        l = j;
        if ((0x80000000 | j) == -1)
        {
            l = data.length;
            k = i;
        }
_L6:
        i = k;
        if (k == gapStart)
        {
            i = gapEnd;
        }
        if (i < l) goto _L2; else goto _L1
_L1:
        return i;
_L2:
        j = data[i];
        if (j <= 40959 || j >= 57344 && j <= 61439 || j >= 45056 && j <= 57343 || (0xff00 & j) == 61440)
        {
            k = i + 1;
            break; /* Loop/switch isn't completed */
        }
        if (j >= 40960 && j <= 45055) goto _L1; else goto _L3
_L3:
        switch (j)
        {
        case 61709: 
        case 61710: 
        case 61711: 
        case 61717: 
        default:
            k = nextDataIndex(i);
            break; /* Loop/switch isn't completed */

        case 61704: 
        case 61705: 
        case 61706: 
        case 61707: 
        case 61708: 
        case 61712: 
        case 61713: 
        case 61715: 
        case 61716: 
        case 61719: 
            break;

        case 61720: 
            k = i + 3;
            break; /* Loop/switch isn't completed */

        case 61718: 
            k = i + 1;
            break; /* Loop/switch isn't completed */

        case 61714: 
            k = i + 5;
            break; /* Loop/switch isn't completed */
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int nextPos(int i)
    {
        int j = posToDataIndex(i);
        if (j == data.length)
        {
            return 0;
        }
        i = j;
        if (j >= gapEnd)
        {
            i = j - (gapEnd - gapStart);
        }
        return (i << 1) + 3;
    }

    public int parentOrEntityI(int i)
    {
        if (i != data.length) goto _L2; else goto _L1
_L1:
        return -1;
_L2:
        int i1;
        i1 = data[i];
        if (i1 == '\uF110' || i1 == '\uF112')
        {
            int j = getIntN(i + 3);
            if (j >= -1)
            {
                return j;
            } else
            {
                return i + j;
            }
        }
        if (i1 < '\uA000' || i1 > '\uAFFF')
        {
            break; /* Loop/switch isn't completed */
        }
        char c = data[i + 2];
        if (c != 0)
        {
            return i - c;
        }
        if (true) goto _L1; else goto _L3
_L3:
        int k = i;
        if (i1 != '\uF108') goto _L5; else goto _L4
_L4:
        k = getIntN(i + 1);
        if (k < 0)
        {
            i = data.length;
        }
        i1 = k + i;
        k = getIntN(i1 + 5);
        if (k == 0) goto _L1; else goto _L6
_L6:
        i = k;
        if (k < 0)
        {
            i = k + i1;
        }
        return i;
_L9:
        k = i + 1;
_L5:
        i = k;
        if (k == gapStart)
        {
            i = gapEnd;
        }
        if (i == data.length) goto _L1; else goto _L7
_L7:
        data[i];
        JVM INSTR tableswitch 61706 61713: default 216
    //                   61706 135
    //                   61707 230
    //                   61708 241
    //                   61709 216
    //                   61710 216
    //                   61711 216
    //                   61712 216
    //                   61713 9;
           goto _L8 _L9 _L10 _L11 _L8 _L8 _L8 _L8 _L12
_L12:
        continue; /* Loop/switch isn't completed */
_L8:
        i = nextDataIndex(i);
        k = i;
        if (i < 0)
        {
            return -1;
        }
          goto _L5
_L10:
        return i - data[i + 1];
_L11:
        int j1 = getIntN(i + 3);
        int l = j1;
        if (j1 < 0)
        {
            l = j1 + i;
        }
        return l;
        if (true) goto _L1; else goto _L13
_L13:
    }

    public int parentOrEntityPos(int i)
    {
        i = parentOrEntityI(posToDataIndex(i));
        if (i < 0)
        {
            return -1;
        } else
        {
            return i << 1;
        }
    }

    public int parentPos(int i)
    {
        i = posToDataIndex(i);
        int j;
        do
        {
            j = parentOrEntityI(i);
            if (j == -1)
            {
                return -1;
            }
            i = j;
        } while (data[j] == '\uF112');
        return j << 1;
    }

    public final int posToDataIndex(int i)
    {
        int j;
        if (i == -1)
        {
            j = data.length;
        } else
        {
            int k = i >>> 1;
            j = k;
            if ((i & 1) != 0)
            {
                j = k - 1;
            }
            k = j;
            if (j >= gapStart)
            {
                k = j + (gapEnd - gapStart);
            }
            j = k;
            if ((i & 1) != 0)
            {
                i = nextDataIndex(k);
                if (i < 0)
                {
                    return data.length;
                }
                j = i;
                if (i == gapStart)
                {
                    return i + (gapEnd - gapStart);
                }
            }
        }
        return j;
    }

    public final void resizeObjects()
    {
        Object aobj[];
        if (objects == null)
        {
            aobj = new Object[100];
        } else
        {
            int i = objects.length;
            aobj = new Object[i * 2];
            System.arraycopy(((Object) (objects)), 0, ((Object) (aobj)), 0, i);
        }
        objects = aobj;
    }

    public void setAttributeName(int i, int j)
    {
        setIntN(i + 1, j);
    }

    public void setElementName(int i, int j)
    {
        int k = i;
        if (data[i] == '\uF108')
        {
            k = getIntN(i + 1);
            if (k < 0)
            {
                i = data.length;
            }
            k = i + k;
        }
        if (k < gapEnd)
        {
            throw new Error("setElementName before gapEnd");
        } else
        {
            setIntN(k + 1, j);
            return;
        }
    }

    public final void setIntN(int i, int j)
    {
        data[i] = (char)(j >> 16);
        data[i + 1] = (char)j;
    }

    public int size()
    {
        int i = 0;
        int j = 0;
        do
        {
            j = nextPos(j);
            if (j == 0)
            {
                return i;
            }
            i++;
        } while (true);
    }

    public void startAttribute(int i)
    {
        ensureSpace(6);
        gapEnd = gapEnd - 1;
        char ac[] = data;
        int j = gapStart;
        gapStart = j + 1;
        ac[j] = '\uF109';
        if (attrStart != 0)
        {
            throw new Error("nested attribute");
        } else
        {
            attrStart = gapStart;
            setIntN(gapStart, i);
            setIntN(gapStart + 2, gapEnd - data.length);
            gapStart = gapStart + 4;
            data[gapEnd] = '\uF10A';
            return;
        }
    }

    public void startAttribute(Object obj)
    {
        startAttribute(find(obj));
    }

    public void startDocument()
    {
        int i = -1;
        ensureSpace(6);
        gapEnd = gapEnd - 1;
        int j = gapStart;
        data[j] = '\uF110';
        if (docStart != 0)
        {
            throw new Error("nested document");
        }
        docStart = j + 1;
        setIntN(j + 1, gapEnd - data.length);
        if (currentParent != -1)
        {
            i = currentParent - j;
        }
        setIntN(j + 3, i);
        currentParent = j;
        gapStart = j + 5;
        currentParent = j;
        data[gapEnd] = '\uF111';
    }

    public void startElement(int i)
    {
        ensureSpace(10);
        gapEnd = gapEnd - 7;
        char ac[] = data;
        int j = gapStart;
        gapStart = j + 1;
        ac[j] = '\uF108';
        setIntN(gapStart, gapEnd - data.length);
        gapStart = gapStart + 2;
        data[gapEnd] = '\uF10C';
        setIntN(gapEnd + 1, i);
        setIntN(gapEnd + 3, gapStart - 3);
        setIntN(gapEnd + 5, currentParent);
        currentParent = gapStart - 3;
    }

    public void startElement(Object obj)
    {
        startElement(find(obj));
    }

    public void statistics()
    {
        PrintWriter printwriter = new PrintWriter(System.out);
        statistics(printwriter);
        printwriter.flush();
    }

    public void statistics(PrintWriter printwriter)
    {
        printwriter.print("data array length: ");
        printwriter.println(data.length);
        printwriter.print("data array gap: ");
        printwriter.println(gapEnd - gapStart);
        printwriter.print("object array length: ");
        printwriter.println(objects.length);
    }

    public int stringValue(int i, StringBuffer stringbuffer)
    {
        int j = nextNodeIndex(i, 0x7fffffff);
        if (j > i)
        {
            stringValue(i, j, stringbuffer);
            return i;
        } else
        {
            return stringValue(false, i, stringbuffer);
        }
    }

    public int stringValue(boolean flag, int i, StringBuffer stringbuffer)
    {
        char c;
        Object obj;
        int j;
        int k;
        int l;
        obj = null;
        l = 0;
        k = 0;
        j = i;
        if (i >= gapStart)
        {
            j = i + (gapEnd - gapStart);
        }
        if (j == data.length)
        {
            return -1;
        }
        c = data[j];
        j++;
        if (c <= '\u9FFF')
        {
            stringbuffer.append(c);
            return j;
        }
        if (c < '\uE000' || c > '\uEFFF') goto _L2; else goto _L1
_L1:
        if (false)
        {
            stringbuffer.append(' ');
        }
        obj = objects[c - 57344];
        i = k;
_L4:
        if (obj != null)
        {
            stringbuffer.append(obj);
        }
        if (i > 0)
        {
            do
            {
                k = stringValue(true, i, stringbuffer);
                i = k;
            } while (k >= 0);
        }
        return j;
_L2:
        if (c < '\uA000' || c > '\uAFFF')
        {
            break; /* Loop/switch isn't completed */
        }
        i = j + 2;
        j = data[j] + j + 1;
        if (true) goto _L4; else goto _L3
_L3:
        if ((0xff00 & c) == 61440)
        {
            stringbuffer.append(c & 0xff);
            return j;
        }
        if (c >= '\uB000' && c <= '\uDFFF')
        {
            stringbuffer.append(c - 49152);
            return j;
        }
        i = j;
        switch (c)
        {
        case 61703: 
        case 61709: 
        case 61710: 
        default:
            throw new Error((new StringBuilder()).append("unimplemented: ").append(Integer.toHexString(c)).append(" at:").append(j).toString());

        case 61720: 
            return j + 2;

        case 61716: 
            i = j + 2;
            // fall through

        case 61717: 
        case 61719: 
            j = getIntN(i);
            i += 2;
            if (!flag || c == '\uF115')
            {
                stringbuffer.append(data, i, j);
            }
            return i + j;

        case 61696: 
        case 61697: 
            if (false)
            {
                stringbuffer.append(' ');
            }
            if (c != '\uF100')
            {
                flag = true;
            } else
            {
                flag = false;
            }
            stringbuffer.append(flag);
            return j;

        case 61698: 
            if (false)
            {
                stringbuffer.append(' ');
            }
            stringbuffer.append(getIntN(j));
            return j + 2;

        case 61699: 
            if (false)
            {
                stringbuffer.append(' ');
            }
            stringbuffer.append(getLongN(j));
            return j + 4;

        case 61700: 
            if (false)
            {
                stringbuffer.append(' ');
            }
            stringbuffer.append(Float.intBitsToFloat(getIntN(j)));
            return j + 2;

        case 61701: 
            if (false)
            {
                stringbuffer.append(' ');
            }
            stringbuffer.append(Double.longBitsToDouble(getLongN(j)));
            return j + 4;

        case 61702: 
            stringbuffer.append(data[j]);
            return j + 1;

        case 61712: 
        case 61714: 
            i = j + 4;
            j = nextDataIndex(j - 1);
            break;

        case 61704: 
            k = j + 2;
            l = getIntN(j);
            if (l < 0)
            {
                i = data.length;
            } else
            {
                i = j - 1;
            }
            j = l + i + 7;
            i = k;
            break;

        case 61718: 
            i = k;
            break;

        case 61706: 
        case 61707: 
        case 61708: 
        case 61713: 
        case 61715: 
            return -1;

        case 61705: 
            i = l;
            if (!flag)
            {
                i = j + 4;
            }
            k = getIntN(j + 2);
            if (k < 0)
            {
                j = data.length + 1;
            }
            j += k;
            break;

        case 61711: 
            AbstractSequence abstractsequence = (AbstractSequence)objects[getIntN(j)];
            i = getIntN(j + 2);
            ((TreeList)abstractsequence).stringValue(flag, i >> 1, stringbuffer);
            j += 4;
            i = k;
            break;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void stringValue(int i, int j, StringBuffer stringbuffer)
    {
        for (; i < j && i >= 0; i = stringValue(false, i, stringbuffer)) { }
    }

    public void toString(String s, StringBuffer stringbuffer)
    {
        int i;
        int j;
        int k;
        int i1;
        i = 0;
        i1 = gapStart;
        k = 0;
        j = 0;
_L3:
        int l;
        int j1;
label0:
        {
            l = i1;
            j1 = i;
            if (i < i1)
            {
                break label0;
            }
            if (i == gapStart)
            {
                i = gapEnd;
                i1 = data.length;
                l = i1;
                j1 = i;
                if (i != i1)
                {
                    break label0;
                }
            }
            return;
        }
        char ac[] = data;
        i = j1 + 1;
        j1 = ac[j1];
        if (j1 > 40959) goto _L2; else goto _L1
_L1:
        i1 = i - 1;
_L4:
        if (i < l)
        {
            char ac1[] = data;
            k = i + 1;
            if (ac1[i] <= '\u9FFF')
            {
                break MISSING_BLOCK_LABEL_1727;
            }
            i = k - 1;
        }
        k = j;
        if (j != 0)
        {
            stringbuffer.append('>');
            k = 0;
        }
        stringbuffer.append(data, i1, i - i1);
        j1 = 0;
        j = k;
        i1 = l;
        k = j1;
          goto _L3
_L2:
        if (j1 >= 57344 && j1 <= 61439)
        {
            i1 = j;
            if (j != 0)
            {
                stringbuffer.append('>');
                i1 = 0;
            }
            if (k != 0)
            {
                stringbuffer.append(s);
            } else
            {
                k = 1;
            }
            stringbuffer.append(objects[j1 - 57344]);
            j = i1;
            i1 = l;
        } else
        if (j1 >= 40960 && j1 <= 45055)
        {
            if (j != 0)
            {
                stringbuffer.append('>');
            }
            if (k != 0)
            {
                stringbuffer.append(s);
            }
            stringbuffer.append('<');
            stringbuffer.append(objects[j1 - 40960].toString());
            i += 2;
            k = 0;
            j = 1;
            i1 = l;
        } else
        if (j1 >= 45056 && j1 <= 57343)
        {
            i1 = j;
            if (j != 0)
            {
                stringbuffer.append('>');
                i1 = 0;
            }
            if (k != 0)
            {
                stringbuffer.append(s);
            } else
            {
                k = 1;
            }
            stringbuffer.append(j1 - 49152);
            j = i1;
            i1 = l;
        } else
        {
            switch (j1)
            {
            case 61703: 
            default:
                throw new Error((new StringBuilder()).append("unknown code:").append(j1).toString());

            case 61712: 
            case 61714: 
                i += 4;
                i1 = l;
                break;

            case 61720: 
                i += 2;
                i1 = l;
                break;

            case 61719: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                j = getIntN(i);
                i += 2;
                stringbuffer.append("<!--");
                stringbuffer.append(data, i, j);
                stringbuffer.append("-->");
                i += j;
                j = i1;
                i1 = l;
                break;

            case 61717: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                j = getIntN(i);
                i += 2;
                stringbuffer.append("<![CDATA[");
                stringbuffer.append(data, i, j);
                stringbuffer.append("]]>");
                i += j;
                j = i1;
                i1 = l;
                break;

            case 61716: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                stringbuffer.append("<?");
                j = getIntN(i);
                i += 2;
                stringbuffer.append(objects[j]);
                j1 = getIntN(i);
                j = i + 2;
                i = j;
                if (j1 > 0)
                {
                    stringbuffer.append(' ');
                    stringbuffer.append(data, j, j1);
                    i = j + j1;
                }
                stringbuffer.append("?>");
                j = i1;
                i1 = l;
                break;

            case 61713: 
            case 61715: 
                i1 = l;
                break;

            case 61696: 
            case 61697: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                boolean flag;
                if (k != 0)
                {
                    stringbuffer.append(s);
                } else
                {
                    k = 1;
                }
                if (j1 != 61696)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                stringbuffer.append(flag);
                j = i1;
                i1 = l;
                break;

            case 61718: 
                i1 = l;
                break;

            case 61702: 
                k = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    k = 0;
                }
                stringbuffer.append(data, i, (j1 + 1) - 61702);
                j1 = 0;
                i++;
                j = k;
                i1 = l;
                k = j1;
                break;

            case 61711: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                if (k != 0)
                {
                    stringbuffer.append(s);
                } else
                {
                    k = 1;
                }
                stringbuffer.append(((AbstractSequence)objects[getIntN(i)]).getIteratorAtPos(getIntN(i + 2)));
                i += 4;
                j = i1;
                i1 = l;
                break;

            case 61709: 
            case 61710: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                if (k != 0)
                {
                    stringbuffer.append(s);
                } else
                {
                    k = 1;
                }
                stringbuffer.append(objects[getIntN(i)]);
                i += 2;
                j = i1;
                i1 = l;
                break;

            case 61704: 
                j1 = getIntN(i);
                if (j1 >= 0)
                {
                    i1 = i - 1;
                } else
                {
                    i1 = data.length;
                }
                i += 2;
                i1 = getIntN(j1 + i1 + 1);
                if (j != 0)
                {
                    stringbuffer.append('>');
                } else
                if (k != 0)
                {
                    stringbuffer.append(s);
                }
                stringbuffer.append('<');
                stringbuffer.append(objects[i1]);
                k = 0;
                j = 1;
                i1 = l;
                break;

            case 61707: 
            case 61708: 
                if (j1 == 61707)
                {
                    char ac2[] = data;
                    k = i + 1;
                    i = ac2[i];
                    i1 = data[k - 2 - i] - 40960;
                    i = k;
                    k = i1;
                } else
                {
                    k = getIntN(i);
                    i += 6;
                }
                if (j != 0)
                {
                    stringbuffer.append("/>");
                } else
                {
                    stringbuffer.append("</");
                    stringbuffer.append(objects[k]);
                    stringbuffer.append('>');
                }
                j = 0;
                k = 1;
                i1 = l;
                break;

            case 61705: 
                j = getIntN(i);
                stringbuffer.append(' ');
                stringbuffer.append(objects[j]);
                stringbuffer.append("=\"");
                j = 0;
                i += 4;
                i1 = l;
                break;

            case 61706: 
                stringbuffer.append('"');
                j = 1;
                k = 0;
                i1 = l;
                break;

            case 61698: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                if (k != 0)
                {
                    stringbuffer.append(s);
                } else
                {
                    k = 1;
                }
                stringbuffer.append(getIntN(i));
                i += 2;
                j = i1;
                i1 = l;
                break;

            case 61700: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                if (k != 0)
                {
                    stringbuffer.append(s);
                } else
                {
                    k = 1;
                }
                stringbuffer.append(Float.intBitsToFloat(getIntN(i)));
                i += 2;
                j = i1;
                i1 = l;
                break;

            case 61699: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                if (k != 0)
                {
                    stringbuffer.append(s);
                } else
                {
                    k = 1;
                }
                stringbuffer.append(getLongN(i));
                i += 4;
                j = i1;
                i1 = l;
                break;

            case 61701: 
                i1 = j;
                if (j != 0)
                {
                    stringbuffer.append('>');
                    i1 = 0;
                }
                if (k != 0)
                {
                    stringbuffer.append(s);
                } else
                {
                    k = 1;
                }
                stringbuffer.append(Double.longBitsToDouble(getLongN(i)));
                i += 4;
                j = i1;
                i1 = l;
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L3
        i = k;
          goto _L4
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void write(int i)
    {
        ensureSpace(3);
        if (i <= 40959)
        {
            char ac[] = data;
            int j = gapStart;
            gapStart = j + 1;
            ac[j] = (char)i;
            return;
        }
        if (i < 0x10000)
        {
            char ac1[] = data;
            int k = gapStart;
            gapStart = k + 1;
            ac1[k] = '\uF106';
            ac1 = data;
            k = gapStart;
            gapStart = k + 1;
            ac1[k] = (char)i;
            return;
        } else
        {
            Char.print(i, this);
            return;
        }
    }

    public void write(CharSequence charsequence, int i, int j)
    {
        if (j == 0)
        {
            writeJoiner();
        }
        ensureSpace(j);
        while (j > 0) 
        {
            char c = charsequence.charAt(i);
            j--;
            if (c <= '\u9FFF')
            {
                char ac[] = data;
                int k = gapStart;
                gapStart = k + 1;
                ac[k] = c;
            } else
            {
                write(c);
                ensureSpace(j);
            }
            i++;
        }
    }

    public void write(String s)
    {
        write(((CharSequence) (s)), 0, s.length());
    }

    public void write(char ac[], int i, int j)
    {
        if (j == 0)
        {
            writeJoiner();
        }
        ensureSpace(j);
        while (j > 0) 
        {
            char c = ac[i];
            j--;
            if (c <= '\u9FFF')
            {
                char ac1[] = data;
                int k = gapStart;
                gapStart = k + 1;
                ac1[k] = c;
            } else
            {
                write(c);
                ensureSpace(j);
            }
            i++;
        }
    }

    public void writeBoolean(boolean flag)
    {
        ensureSpace(1);
        char ac[] = data;
        int j = gapStart;
        gapStart = j + 1;
        int i;
        if (flag)
        {
            i = 61697;
        } else
        {
            i = 61696;
        }
        ac[j] = i;
    }

    public void writeByte(int i)
    {
        ensureSpace(1);
        char ac[] = data;
        int j = gapStart;
        gapStart = j + 1;
        ac[j] = (char)(61440 + (i & 0xff));
    }

    public void writeCDATA(char ac[], int i, int j)
    {
        ensureSpace(j + 3);
        int k = gapStart;
        char ac1[] = data;
        int l = k + 1;
        ac1[k] = '\uF115';
        setIntN(l, j);
        k = l + 2;
        System.arraycopy(ac, i, data, k, j);
        gapStart = k + j;
    }

    public void writeComment(String s, int i, int j)
    {
        ensureSpace(j + 3);
        int k = gapStart;
        char ac[] = data;
        int l = k + 1;
        ac[k] = '\uF117';
        setIntN(l, j);
        k = l + 2;
        s.getChars(i, i + j, data, k);
        gapStart = k + j;
    }

    public void writeComment(char ac[], int i, int j)
    {
        ensureSpace(j + 3);
        int k = gapStart;
        char ac1[] = data;
        int l = k + 1;
        ac1[k] = '\uF117';
        setIntN(l, j);
        k = l + 2;
        System.arraycopy(ac, i, data, k, j);
        gapStart = k + j;
    }

    public void writeDocumentUri(Object obj)
    {
        ensureSpace(3);
        int i = find(obj);
        obj = data;
        int j = gapStart;
        gapStart = j + 1;
        obj[j] = '\uF118';
        setIntN(gapStart, i);
        gapStart = gapStart + 2;
    }

    public void writeDouble(double d)
    {
        ensureSpace(5);
        long l = Double.doubleToLongBits(d);
        char ac[] = data;
        int i = gapStart;
        gapStart = i + 1;
        ac[i] = '\uF105';
        ac = data;
        i = gapStart;
        gapStart = i + 1;
        ac[i] = (char)(int)(l >>> 48);
        ac = data;
        i = gapStart;
        gapStart = i + 1;
        ac[i] = (char)(int)(l >>> 32);
        ac = data;
        i = gapStart;
        gapStart = i + 1;
        ac[i] = (char)(int)(l >>> 16);
        ac = data;
        i = gapStart;
        gapStart = i + 1;
        ac[i] = (char)(int)l;
    }

    public void writeFloat(float f)
    {
        ensureSpace(3);
        int i = Float.floatToIntBits(f);
        char ac[] = data;
        int j = gapStart;
        gapStart = j + 1;
        ac[j] = '\uF104';
        ac = data;
        j = gapStart;
        gapStart = j + 1;
        ac[j] = (char)(i >>> 16);
        ac = data;
        j = gapStart;
        gapStart = j + 1;
        ac[j] = (char)i;
    }

    public void writeInt(int i)
    {
        ensureSpace(3);
        if (i >= -4096 && i <= 8191)
        {
            char ac[] = data;
            int j = gapStart;
            gapStart = j + 1;
            ac[j] = (char)(49152 + i);
            return;
        } else
        {
            char ac1[] = data;
            int k = gapStart;
            gapStart = k + 1;
            ac1[k] = '\uF102';
            setIntN(gapStart, i);
            gapStart = gapStart + 2;
            return;
        }
    }

    public void writeJoiner()
    {
        ensureSpace(1);
        char ac[] = data;
        int i = gapStart;
        gapStart = i + 1;
        ac[i] = '\uF116';
    }

    public void writeLong(long l)
    {
        ensureSpace(5);
        char ac[] = data;
        int i = gapStart;
        gapStart = i + 1;
        ac[i] = '\uF103';
        ac = data;
        i = gapStart;
        gapStart = i + 1;
        ac[i] = (char)(int)(l >>> 48);
        ac = data;
        i = gapStart;
        gapStart = i + 1;
        ac[i] = (char)(int)(l >>> 32);
        ac = data;
        i = gapStart;
        gapStart = i + 1;
        ac[i] = (char)(int)(l >>> 16);
        ac = data;
        i = gapStart;
        gapStart = i + 1;
        ac[i] = (char)(int)l;
    }

    public void writeObject(Object obj)
    {
        ensureSpace(3);
        int i = find(obj);
        if (i < 4096)
        {
            obj = data;
            int j = gapStart;
            gapStart = j + 1;
            obj[j] = (char)(0xe000 | i);
            return;
        } else
        {
            obj = data;
            int k = gapStart;
            gapStart = k + 1;
            obj[k] = '\uF10D';
            setIntN(gapStart, i);
            gapStart = gapStart + 2;
            return;
        }
    }

    public void writePosition(AbstractSequence abstractsequence, int i)
    {
        ensureSpace(5);
        data[gapStart] = '\uF10F';
        int j = find(abstractsequence);
        setIntN(gapStart + 1, j);
        setIntN(gapStart + 3, i);
        gapStart = gapStart + 5;
    }

    public void writeProcessingInstruction(String s, String s1, int i, int j)
    {
        ensureSpace(j + 5);
        int k = gapStart;
        char ac[] = data;
        int l = k + 1;
        ac[k] = '\uF114';
        setIntN(l, find(s));
        setIntN(l + 2, j);
        k = l + 4;
        s1.getChars(i, i + j, data, k);
        gapStart = k + j;
    }

    public void writeProcessingInstruction(String s, char ac[], int i, int j)
    {
        ensureSpace(j + 5);
        int k = gapStart;
        char ac1[] = data;
        int l = k + 1;
        ac1[k] = '\uF114';
        setIntN(l, find(s));
        setIntN(l + 2, j);
        k = l + 4;
        System.arraycopy(ac, i, data, k, j);
        gapStart = k + j;
    }
}
