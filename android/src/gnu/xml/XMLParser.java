// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.xml;

import gnu.lists.Consumer;
import gnu.text.LineBufferedReader;
import gnu.text.LineInputStreamReader;
import gnu.text.Path;
import gnu.text.SourceMessages;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package gnu.xml:
//            XMLFilter

public class XMLParser
{

    private static final int ATTRIBUTE_SEEN_EQ_STATE = 11;
    private static final int ATTRIBUTE_SEEN_NAME_STATE = 8;
    static final String BAD_ENCODING_SYNTAX = "bad 'encoding' declaration";
    static final String BAD_STANDALONE_SYNTAX = "bad 'standalone' declaration";
    private static final int BEGIN_ELEMENT_STATE = 2;
    private static final int DOCTYPE_NAME_SEEN_STATE = 16;
    private static final int DOCTYPE_SEEN_STATE = 13;
    private static final int END_ELEMENT_STATE = 4;
    private static final int EXPECT_NAME_MODIFIER = 1;
    private static final int EXPECT_RIGHT_STATE = 27;
    private static final int INIT_LEFT_QUEST_STATE = 30;
    private static final int INIT_LEFT_STATE = 34;
    private static final int INIT_STATE = 0;
    private static final int INIT_TEXT_STATE = 31;
    private static final int INVALID_VERSION_DECL = 35;
    private static final int MAYBE_ATTRIBUTE_STATE = 10;
    private static final int PREV_WAS_CR_STATE = 28;
    private static final int SAW_AMP_SHARP_STATE = 26;
    private static final int SAW_AMP_STATE = 25;
    private static final int SAW_ENTITY_REF = 6;
    private static final int SAW_EOF_ERROR = 37;
    private static final int SAW_ERROR = 36;
    private static final int SAW_LEFT_EXCL_MINUS_STATE = 22;
    private static final int SAW_LEFT_EXCL_STATE = 20;
    private static final int SAW_LEFT_QUEST_STATE = 21;
    private static final int SAW_LEFT_SLASH_STATE = 19;
    private static final int SAW_LEFT_STATE = 14;
    private static final int SKIP_SPACES_MODIFIER = 2;
    private static final int TEXT_STATE = 1;

    public XMLParser()
    {
    }

    public static LineInputStreamReader XMLStreamReader(InputStream inputstream)
        throws IOException
    {
        LineInputStreamReader lineinputstreamreader;
        int i;
        int j;
        int k;
        int l;
        k = -1;
        lineinputstreamreader = new LineInputStreamReader(inputstream);
        l = lineinputstreamreader.getByte();
        if (l < 0)
        {
            i = -1;
        } else
        {
            i = lineinputstreamreader.getByte();
        }
        if (i < 0)
        {
            j = -1;
        } else
        {
            j = lineinputstreamreader.getByte();
        }
        if (l != 239 || i != 187 || j != 191) goto _L2; else goto _L1
_L1:
        lineinputstreamreader.resetStart(3);
        lineinputstreamreader.setCharset("UTF-8");
_L11:
        lineinputstreamreader.setKeepFullLines(false);
        return lineinputstreamreader;
_L2:
        if (l == 255 && i == 254 && j != 0)
        {
            lineinputstreamreader.resetStart(2);
            lineinputstreamreader.setCharset("UTF-16LE");
            continue; /* Loop/switch isn't completed */
        }
        if (l == 254 && i == 255 && j != 0)
        {
            lineinputstreamreader.resetStart(2);
            lineinputstreamreader.setCharset("UTF-16BE");
            continue; /* Loop/switch isn't completed */
        }
        if (j >= 0)
        {
            k = lineinputstreamreader.getByte();
        }
        if (l == 76 && i == 111 && j == 167 && k == 148)
        {
            throw new RuntimeException("XMLParser: EBCDIC encodings not supported");
        }
        lineinputstreamreader.resetStart(0);
        if ((l != 60 || (i != 63 || j != 120 || k != 109) && (i != 0 || j != 63 || k != 0)) && (l != 0 || i != 60 || j != 0 || k != 63))
        {
            break MISSING_BLOCK_LABEL_421;
        }
        char ac[] = lineinputstreamreader.buffer;
        inputstream = ac;
        if (ac == null)
        {
            inputstream = new char[8192];
            lineinputstreamreader.buffer = inputstream;
        }
        j = 0;
        l = 0;
_L7:
        int i1;
        do
        {
            i1 = lineinputstreamreader.getByte();
        } while (i1 == 0);
        if (i1 >= 0) goto _L4; else goto _L3
_L3:
        lineinputstreamreader.pos = 0;
        lineinputstreamreader.limit = j;
        continue; /* Loop/switch isn't completed */
_L4:
        k = j + 1;
        inputstream[j] = (char)(i1 & 0xff);
        if (l != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i1 != 62)
        {
            break; /* Loop/switch isn't completed */
        }
        j = k;
        if (true) goto _L3; else goto _L5
_L5:
label0:
        {
            if (i1 != 39)
            {
                i = l;
                if (i1 != 34)
                {
                    break label0;
                }
            }
            i = i1;
        }
_L8:
        j = k;
        l = i;
        if (true) goto _L7; else goto _L6
_L6:
        i = l;
        if (i1 == l)
        {
            i = 0;
        }
          goto _L8
        if (true) goto _L7; else goto _L9
_L9:
        lineinputstreamreader.setCharset("UTF-8");
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static void parse(LineBufferedReader linebufferedreader, SourceMessages sourcemessages, Consumer consumer)
        throws IOException
    {
        consumer = new XMLFilter(consumer);
        consumer.setMessages(sourcemessages);
        consumer.setSourceLocator(linebufferedreader);
        consumer.startDocument();
        sourcemessages = linebufferedreader.getPath();
        if (sourcemessages != null)
        {
            consumer.writeDocumentUri(sourcemessages);
        }
        parse(linebufferedreader, ((XMLFilter) (consumer)));
        consumer.endDocument();
    }

    public static void parse(LineBufferedReader linebufferedreader, SourceMessages sourcemessages, XMLFilter xmlfilter)
        throws IOException
    {
        xmlfilter.setMessages(sourcemessages);
        xmlfilter.setSourceLocator(linebufferedreader);
        xmlfilter.startDocument();
        sourcemessages = linebufferedreader.getPath();
        if (sourcemessages != null)
        {
            xmlfilter.writeDocumentUri(sourcemessages);
        }
        parse(linebufferedreader, xmlfilter);
        xmlfilter.endDocument();
        linebufferedreader.close();
    }

    public static void parse(LineBufferedReader linebufferedreader, XMLFilter xmlfilter)
    {
        char c;
        String s;
        char ac[];
        int i;
        int j;
        int l;
        int j1;
        int k1;
        int j2;
        byte byte0;
        int l2;
        ac = linebufferedreader.buffer;
        i = linebufferedreader.pos;
        k1 = linebufferedreader.limit;
        j = 0;
        l2 = 60;
        byte0 = 14;
        c = ' ';
        j2 = 0;
        l = -1;
        s = null;
        j1 = k1;
_L128:
        String s1;
        int k;
        s1 = s;
        k = i;
        j;
        JVM INSTR tableswitch 0 37: default 220
    //                   0 302
    //                   1 513
    //                   2 1936
    //                   3 1141
    //                   4 4923
    //                   5 1141
    //                   6 1753
    //                   7 1141
    //                   8 4646
    //                   9 1141
    //                   10 4529
    //                   11 4790
    //                   12 1025
    //                   13 4231
    //                   14 1813
    //                   15 1025
    //                   16 4244
    //                   17 1141
    //                   18 220
    //                   19 4911
    //                   20 5205
    //                   21 1966
    //                   22 220
    //                   23 1025
    //                   24 1141
    //                   25 1705
    //                   26 5216
    //                   27 4950
    //                   28 926
    //                   29 1025
    //                   30 1966
    //                   31 333
    //                   32 1025
    //                   33 1141
    //                   34 376
    //                   35 420
    //                   36 428
    //                   37 498;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L5 _L7 _L5 _L8 _L5 _L9 _L10 _L11 _L12 _L13 _L11 _L14 _L5 _L1 _L15 _L16 _L17 _L1 _L11 _L5 _L18 _L19 _L20 _L21 _L11 _L17 _L22 _L11 _L5 _L23 _L24 _L25 _L26
_L1:
        int i1;
        int l1;
        int i2;
        int k2;
        byte byte1;
        k2 = l2;
        k = j;
        s1 = s;
        byte1 = byte0;
        i2 = l;
        l1 = j2;
        i1 = j1;
_L28:
        char c1;
        char c2;
        int i3;
        if (i < k1)
        {
            j = i + 1;
            c = ac[i];
            j1 = i1;
            j2 = l1;
            l = i2;
            byte0 = byte1;
            s = s1;
            i = j;
            j = k;
            l2 = k2;
            continue; /* Loop/switch isn't completed */
        }
        j = i - i1;
          goto _L27
_L2:
        k = 31;
        i1 = j1;
        l1 = j2;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        k2 = l2;
          goto _L28
_L22:
        if (c == '<')
        {
            k = 34;
            i1 = j1;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k2 = l2;
        } else
        {
            j = 1;
            continue; /* Loop/switch isn't completed */
        }
          goto _L28
_L23:
        if (c == '?')
        {
            i1 = i;
            k = 33;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k2 = l2;
        } else
        {
            j = 14;
            continue; /* Loop/switch isn't completed */
        }
          goto _L28
_L24:
        k = l;
        s1 = "invalid xml version specifier";
_L25:
        linebufferedreader.pos = k;
        xmlfilter.error('e', s1);
        do
        {
            if (k >= k1)
            {
                return;
            }
            i = k + 1;
            c = ac[k];
            k = i;
        } while (c != '>');
        k = 1;
        i1 = j1;
        l1 = j2;
        i2 = l;
        byte1 = byte0;
        k2 = l2;
          goto _L28
_L26:
        linebufferedreader.pos = i;
        xmlfilter.error('f', "unexpected end-of-file");
        return;
_L3:
        i1 = i - 1;
        k = i;
_L45:
        if (c != l2) goto _L30; else goto _L29
_L29:
        j = byte0;
_L33:
        l1 = i - k;
        if (l1 > 0)
        {
            linebufferedreader.pos = i;
            xmlfilter.textFromParser(ac, i1, l1);
        }
        i1 = ac.length;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        k = j;
        k2 = l2;
          goto _L28
_L30:
        if (c != '&') goto _L32; else goto _L31
_L31:
        j = 25;
          goto _L33
_L32:
        if (c != '\r') goto _L35; else goto _L34
_L34:
        l1 = i - k;
        linebufferedreader.pos = i;
        if (l1 > 0)
        {
            xmlfilter.textFromParser(ac, i1, l1);
        }
        if (i >= k1) goto _L37; else goto _L36
_L36:
        c = ac[i];
        if (c != '\n') goto _L39; else goto _L38
_L38:
        k = i + 1;
        i2 = k;
_L44:
        linebufferedreader.incrLineNumber(1, k);
        l1 = k;
        c1 = c;
        j1 = i;
_L46:
        if (l1 != k1) goto _L41; else goto _L40
_L40:
        k = i2 - 1;
        i = l1;
        i1 = j1;
        c = c1;
          goto _L33
_L39:
        xmlfilter.linefeedFromParser();
        if (c != '\205') goto _L43; else goto _L42
_L42:
        k = i + 1;
        i2 = k + 1;
          goto _L44
_L43:
        linebufferedreader.incrLineNumber(1, i);
        i1 = i;
        i++;
        k = i;
          goto _L45
_L37:
        xmlfilter.linefeedFromParser();
        k = 28;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        k2 = l2;
          goto _L28
_L35:
        if (c == '\205' || c == '\u2028')
        {
            k = i - k;
            linebufferedreader.pos = i - 1;
            if (k > 0)
            {
                xmlfilter.textFromParser(ac, i1, k);
            }
            xmlfilter.linefeedFromParser();
            linebufferedreader.incrLineNumber(1, i);
            i2 = i + 1;
            j1 = i;
            c1 = c;
            l1 = i;
        } else
        {
            j1 = i1;
            i2 = k;
            c1 = c;
            l1 = i;
            if (c == '\n')
            {
                linebufferedreader.incrLineNumber(1, i);
                j1 = i1;
                i2 = k;
                c1 = c;
                l1 = i;
            }
        }
          goto _L46
_L41:
        c = ac[l1];
        i = l1 + 1;
        i1 = j1;
        k = i2;
          goto _L45
_L21:
        k2 = 1;
        i1 = 1;
        if (c == '\n')
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (c == '\205')
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if ((k | j) != 0)
        {
            linebufferedreader.incrLineNumber(1, i);
            i1 = j1;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k = k2;
            k2 = l2;
        } else
        {
            linebufferedreader.incrLineNumber(1, i - 1);
            j = i1;
            continue; /* Loop/switch isn't completed */
        }
          goto _L28
_L11:
        if (c == ' ') goto _L1; else goto _L47
_L47:
        if (c == '\t')
        {
            i1 = j1;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k = j;
            k2 = l2;
        } else
        if (c == '\n' || c == '\r' || c == '\205' || c == '\u2028')
        {
            linebufferedreader.incrLineNumber(1, i);
            i1 = j1;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k = j;
            k2 = l2;
        } else
        {
            j -= 2;
            continue; /* Loop/switch isn't completed */
        }
          goto _L28
_L5:
        i3 = j1 + 1;
        j2 = i;
_L51:
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && c != '_' && c != ':' && (c < '\300' || c > '\u02FF' && (c < '\u0370' || (c > '\u1FFF' || c == '\u037E') && (c < '\u200C' || c > '\u200D' && (c < '\u2070' || c > '\u218F') && (c < '\u2C00' || c > '\u2FEF') && (c < '\u3001' || c > '\uD7FF') && (c < '\uF900' || c > '\uFFFD')))) && (j2 <= i3 || c < '0' || c > '9') && c != '.' && c != '-' && c != '\267' && (c <= '\u0300' || c > '\u036F' && (c < '\u203F' || c > '\u2040'))) goto _L49; else goto _L48
_L48:
        i1 = j1;
        l1 = i3;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        i = j2;
        k = j;
        k2 = l2;
        if (j2 >= k1) goto _L28; else goto _L50
_L50:
        c = ac[j2];
        j2++;
          goto _L51
_L49:
        j--;
        k = j2 - i3;
        int j3;
        if (k == 0)
        {
            if (j == 8)
            {
                s = "missing or invalid attribute name";
            } else
            if (j == 2 || j == 4)
            {
                s = "missing or invalid element name";
            } else
            {
                s = "missing or invalid name";
            }
            j = 36;
            i = j2;
            j2 = k;
        } else
        {
            i = j2;
            j2 = k;
        }
        continue; /* Loop/switch isn't completed */
_L56:
        if (c != 'x' || l != 0) goto _L53; else goto _L52
_L52:
        l = 16;
        i3 = l1;
_L60:
        i1 = j1;
        l1 = i3;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        i = j2;
        k = j;
        k2 = l2;
        if (j2 >= k1) goto _L28; else goto _L54
_L54:
        c = ac[j2];
        j2++;
        l1 = i3;
_L126:
        if (c != ';') goto _L56; else goto _L55
_L55:
        linebufferedreader.pos = j2;
        xmlfilter.emitCharacterReference(l1, ac, j1, j2 - 1 - j1);
        k = 1;
        i1 = j1;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        i = j2;
        k2 = l2;
          goto _L28
_L53:
        if (l1 < 0x8000000) goto _L58; else goto _L57
_L57:
        linebufferedreader.pos = j2;
        xmlfilter.error('e', "invalid character reference");
        k = 1;
        i1 = j1;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        i = j2;
        k2 = l2;
          goto _L28
_L58:
        if (l == 0)
        {
            i = 10;
        } else
        {
            i = l;
        }
        k = Character.digit(c, i);
        if (k < 0) goto _L57; else goto _L59
_L59:
        i3 = l1 * i + k;
          goto _L60
_L18:
        if (c == '#')
        {
            k = 26;
            i1 = i;
            l1 = 0;
            i2 = 0;
            byte1 = byte0;
            s1 = s;
            k2 = l2;
        } else
        {
            j1 = i - 1;
            j = 7;
            continue; /* Loop/switch isn't completed */
        }
          goto _L28
_L7:
        linebufferedreader.pos = i;
        if (c != ';')
        {
            xmlfilter.error('w', "missing ';'");
        }
        xmlfilter.emitEntityReference(ac, j1, j2);
        i1 = k1;
        k = 1;
        l1 = j2;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        k2 = l2;
          goto _L28
_L13:
        if (c == '/')
        {
            k = 19;
            i1 = j1;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k2 = l2;
        } else
        if (c == '?')
        {
            i1 = i;
            k = 24;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k2 = l2;
        } else
        if (c == '!')
        {
            k = 20;
            i1 = i;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k2 = l2;
        } else
        {
            j1 = i - 1;
            j = 3;
            continue; /* Loop/switch isn't completed */
        }
          goto _L28
_L4:
        linebufferedreader.pos = i - j2;
        xmlfilter.emitStartElement(ac, j1, j2);
        j = 12;
        j1 = k1;
        continue; /* Loop/switch isn't completed */
_L17:
        if (l < 0)
        {
            j3 = i - 1;
            l = i;
        } else
        {
            j3 = l;
            l = i;
        }
_L83:
        if (c != '>') goto _L62; else goto _L61
_L61:
        k = l - 2;
        if (ac[k] != '?' || k < j3) goto _L62; else goto _L63
_L63:
        linebufferedreader.pos = l;
        if (j2 != 3 || ac[j1] != 'x' || ac[j1 + 1] != 'm' || ac[j1 + 2] != 'l') goto _L65; else goto _L64
_L64:
        if (j != 30) goto _L67; else goto _L66
_L66:
        if (k <= j3 + 7 || ac[j3] != 'v' || ac[j3 + 1] != 'e' || ac[j3 + 2] != 'r' || ac[j3 + 3] != 's' || ac[j3 + 4] != 'i' || ac[j3 + 5] != 'o' || ac[j3 + 6] != 'n')
        {
            i = j3;
            s = "xml declaration without version";
            j = 36;
            l = j3;
            continue; /* Loop/switch isn't completed */
        }
        j = j3 + 7;
        c = ac[j];
        do
        {
            i = j;
            if (!Character.isWhitespace(c))
            {
                break;
            }
            j++;
            i = j;
            if (j >= k)
            {
                break;
            }
            c = ac[j];
        } while (true);
        if (c != '=')
        {
            k = 35;
            j = l;
            l = i;
            i = j;
            j = k;
            continue; /* Loop/switch isn't completed */
        }
        j = i + 1;
        c = ac[j];
        do
        {
            i = j;
            if (!Character.isWhitespace(c))
            {
                break;
            }
            j++;
            i = j;
            if (j >= k)
            {
                break;
            }
            c = ac[j];
        } while (true);
        if (c != '\'' && c != '"')
        {
            k = 35;
            j = l;
            l = i;
            i = j;
            j = k;
            continue; /* Loop/switch isn't completed */
        }
        i++;
        j = i;
        c1 = c;
_L77:
        if (j == k)
        {
            k = 35;
            j = l;
            l = i;
            c = c1;
            i = j;
            j = k;
            continue; /* Loop/switch isn't completed */
        }
        c1 = ac[j];
        if (c1 != c) goto _L69; else goto _L68
_L68:
        c = c1;
        if (j != i + 3) goto _L71; else goto _L70
_L70:
        c = c1;
        if (ac[i] != '1') goto _L71; else goto _L72
_L72:
        c = c1;
        if (ac[i + 1] != '.') goto _L71; else goto _L73
_L73:
        c1 = ac[i + 2];
        c = c1;
        if (c1 == '0') goto _L75; else goto _L74
_L74:
        c = c1;
_L71:
        if (c != '1')
        {
            break; /* Loop/switch isn't completed */
        }
          goto _L75
_L69:
        j++;
        if (true) goto _L77; else goto _L76
_L76:
        k = 35;
        j = l;
        l = i;
        i = j;
        j = k;
        continue; /* Loop/switch isn't completed */
_L75:
        for (i = j + 1; i < k && Character.isWhitespace(ac[i]); i++) { }
        j = i;
        c1 = c;
        if (k > i + 7)
        {
            j = i;
            c1 = c;
            if (ac[i] == 'e')
            {
                j = i;
                c1 = c;
                if (ac[i + 1] == 'n')
                {
                    j = i;
                    c1 = c;
                    if (ac[i + 2] == 'c')
                    {
                        j = i;
                        c1 = c;
                        if (ac[i + 3] == 'o')
                        {
                            j = i;
                            c1 = c;
                            if (ac[i + 4] == 'd')
                            {
                                j = i;
                                c1 = c;
                                if (ac[i + 5] == 'i')
                                {
                                    j = i;
                                    c1 = c;
                                    if (ac[i + 6] == 'n')
                                    {
                                        j = i;
                                        c1 = c;
                                        if (ac[i + 7] == 'g')
                                        {
                                            j = i + 8;
                                            c = ac[j];
                                            do
                                            {
                                                i = j;
                                                if (!Character.isWhitespace(c))
                                                {
                                                    break;
                                                }
                                                j++;
                                                i = j;
                                                if (j >= k)
                                                {
                                                    break;
                                                }
                                                c = ac[j];
                                            } while (true);
                                            if (c != '=')
                                            {
                                                s = "bad 'encoding' declaration";
                                                k = 36;
                                                j = l;
                                                l = i;
                                                i = j;
                                                j = k;
                                                continue; /* Loop/switch isn't completed */
                                            }
                                            j = i + 1;
                                            c = ac[j];
                                            do
                                            {
                                                i = j;
                                                if (!Character.isWhitespace(c))
                                                {
                                                    break;
                                                }
                                                j++;
                                                i = j;
                                                if (j >= k)
                                                {
                                                    break;
                                                }
                                                c = ac[j];
                                            } while (true);
                                            if (c != '\'' && c != '"')
                                            {
                                                s = "bad 'encoding' declaration";
                                                k = 36;
                                                j = l;
                                                l = i;
                                                i = j;
                                                j = k;
                                                continue; /* Loop/switch isn't completed */
                                            }
                                            i++;
                                            j = i;
                                            c1 = c;
                                            do
                                            {
                                                if (j == k)
                                                {
                                                    s = "bad 'encoding' declaration";
                                                    k = 36;
                                                    j = l;
                                                    l = i;
                                                    c = c1;
                                                    i = j;
                                                    j = k;
                                                    continue; /* Loop/switch isn't completed */
                                                }
                                                c2 = ac[j];
                                                if (c2 == c)
                                                {
                                                    s1 = new String(ac, i, j - i);
                                                    if (linebufferedreader instanceof LineInputStreamReader)
                                                    {
                                                        ((LineInputStreamReader)linebufferedreader).setCharset(s1);
                                                    }
                                                    i = j + 1;
                                                    do
                                                    {
                                                        j = i;
                                                        c1 = c2;
                                                        if (i >= k)
                                                        {
                                                            break;
                                                        }
                                                        j = i;
                                                        c1 = c2;
                                                        if (!Character.isWhitespace(ac[i]))
                                                        {
                                                            break;
                                                        }
                                                        i++;
                                                    } while (true);
                                                    break;
                                                }
                                                j++;
                                                c1 = c2;
                                            } while (true);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        i = j;
        c = c1;
        if (k <= j + 9)
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j] != 's')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j + 1] != 't')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j + 2] != 'a')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j + 3] != 'n')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j + 4] != 'd')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j + 5] != 'a')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j + 6] != 'l')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j + 7] != 'o')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j + 8] != 'n')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        i = j;
        c = c1;
        if (ac[j + 9] != 'e')
        {
            break MISSING_BLOCK_LABEL_3589;
        }
        j += 10;
        c = ac[j];
        do
        {
            i = j;
            if (!Character.isWhitespace(c))
            {
                break;
            }
            j++;
            i = j;
            if (j >= k)
            {
                break;
            }
            c = ac[j];
        } while (true);
        if (c != '=')
        {
            s = "bad 'standalone' declaration";
            k = 36;
            j = l;
            l = i;
            i = j;
            j = k;
            continue; /* Loop/switch isn't completed */
        }
        j = i + 1;
        c = ac[j];
        do
        {
            i = j;
            if (!Character.isWhitespace(c))
            {
                break;
            }
            j++;
            i = j;
            if (j >= k)
            {
                break;
            }
            c = ac[j];
        } while (true);
        if (c != '\'' && c != '"')
        {
            s = "bad 'standalone' declaration";
            k = 36;
            j = l;
            l = i;
            i = j;
            j = k;
            continue; /* Loop/switch isn't completed */
        }
        i++;
        j = i;
        c1 = c;
_L80:
        if (j == k)
        {
            s = "bad 'standalone' declaration";
            k = 36;
            j = l;
            l = i;
            c = c1;
            i = j;
            j = k;
            continue; /* Loop/switch isn't completed */
        }
        c1 = ac[j];
        if (c1 != c) goto _L79; else goto _L78
_L79:
        j++;
          goto _L80
_L78:
        if (j == i + 3 && ac[i] == 'y' && ac[i + 1] == 'e' && ac[i + 2] == 's' || j == i + 2 && ac[i] == 'n' && ac[i + 1] == 'o')
        {
            j++;
            do
            {
                i = j;
                c = c1;
                if (j >= k)
                {
                    break;
                }
                i = j;
                c = c1;
                if (!Character.isWhitespace(ac[j]))
                {
                    break;
                }
                j++;
            } while (true);
        } else
        {
            s = "bad 'standalone' declaration";
            k = 36;
            j = l;
            l = i;
            c = c1;
            i = j;
            j = k;
            continue; /* Loop/switch isn't completed */
        }
        c1 = c;
        if (k != i)
        {
            s = "junk at end of xml declaration";
            j = i;
            k = 36;
            l = i;
            i = j;
            j = k;
            continue; /* Loop/switch isn't completed */
        }
          goto _L81
_L67:
        s = "<?xml must be at start of file";
        j = 36;
        i = l;
        l = j3;
        continue; /* Loop/switch isn't completed */
_L65:
        xmlfilter.processingInstructionFromParser(ac, j1, j2, j3, k - j3);
        c1 = c;
_L81:
        i1 = k1;
        i2 = -1;
        k = 1;
        l1 = j2;
        c = c1;
        byte1 = byte0;
        s1 = s;
        i = l;
        k2 = l2;
          goto _L28
_L62:
        i1 = j1;
        l1 = j2;
        i2 = j3;
        byte1 = byte0;
        s1 = s;
        i = l;
        k = j;
        k2 = l2;
        if (l >= k1) goto _L28; else goto _L82
_L82:
        c = ac[l];
        l++;
          goto _L83
_L90:
        i1 = j1;
        l1 = j3;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        i = j2;
        k = j;
        k2 = l2;
        if (j2 >= k1) goto _L28; else goto _L84
_L84:
        c = ac[j2];
        j2++;
        l1 = j3;
_L125:
        if (c != '>') goto _L86; else goto _L85
_L85:
        l1 = j2 - 1 - j1;
        if (l1 < 4 || ac[j1] != '-' || ac[j1 + 1] != '-') goto _L88; else goto _L87
_L87:
        j3 = l1;
        if (ac[j2 - 2] != '-') goto _L90; else goto _L89
_L89:
        j3 = l1;
        if (ac[j2 - 3] != '-') goto _L90; else goto _L91
_L91:
        linebufferedreader.pos = j2;
        xmlfilter.commentFromParser(ac, j1 + 2, l1 - 4);
_L93:
        i1 = k1;
        k = 1;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        i = j2;
        k2 = l2;
          goto _L28
_L88:
        if (l1 < 6 || ac[j1] != '[' || ac[j1 + 1] != 'C' || ac[j1 + 2] != 'D' || ac[j1 + 3] != 'A' || ac[j1 + 4] != 'T' || ac[j1 + 5] != 'A' || ac[j1 + 6] != '[') goto _L93; else goto _L92
_L92:
        j3 = l1;
        if (ac[j2 - 2] != ']') goto _L90; else goto _L94
_L94:
        j3 = l1;
        if (ac[j2 - 3] != ']') goto _L90; else goto _L95
_L95:
        linebufferedreader.pos = j2;
        xmlfilter.writeCDATA(ac, j1 + 7, j2 - 10 - j1);
          goto _L93
_L86:
        j3 = l1;
        if (j2 != j1 + 7) goto _L90; else goto _L96
_L96:
        j3 = l1;
        if (ac[j1] != 'D') goto _L90; else goto _L97
_L97:
        j3 = l1;
        if (ac[j1 + 1] != 'O') goto _L90; else goto _L98
_L98:
        j3 = l1;
        if (ac[j1 + 2] != 'C') goto _L90; else goto _L99
_L99:
        j3 = l1;
        if (ac[j1 + 3] != 'T') goto _L90; else goto _L100
_L100:
        j3 = l1;
        if (ac[j1 + 4] != 'Y') goto _L90; else goto _L101
_L101:
        j3 = l1;
        if (ac[j1 + 5] != 'P') goto _L90; else goto _L102
_L102:
        j3 = l1;
        if (c != 'E') goto _L90; else goto _L103
_L103:
        i1 = k1;
        k = 15;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        i = j2;
        k2 = l2;
          goto _L28
_L12:
        j = 17;
        j1 = i - 1;
        continue; /* Loop/switch isn't completed */
_L14:
        if (l < 0)
        {
            i1 = i - 1 - j1 << 1;
            k = 0;
            l = i;
            i = i1;
        } else
        {
            k = i;
            i = l;
            l = k;
            k = l2;
        }
_L107:
        if (c != '\'' && c != '"') goto _L105; else goto _L104
_L104:
        if (k == 0)
        {
            j3 = c;
            l2 = i;
        } else
        {
            l2 = i;
            j3 = k;
            if (k == c)
            {
                j3 = 0;
                l2 = i;
            }
        }
_L109:
        i1 = j1;
        l1 = j2;
        i2 = l2;
        byte1 = byte0;
        s1 = s;
        i = l;
        k = j;
        k2 = j3;
        if (l >= k1) goto _L28; else goto _L106
_L106:
        c = ac[l];
        l++;
        i = l2;
        k = j3;
          goto _L107
_L105:
        l2 = i;
        j3 = k;
        if (k != 0) goto _L109; else goto _L108
_L108:
        if (c != '[') goto _L111; else goto _L110
_L110:
        l2 = i | 1;
        j3 = k;
          goto _L109
_L111:
        if (c != ']') goto _L113; else goto _L112
_L112:
        l2 = i & -2;
        j3 = k;
          goto _L109
_L113:
        l2 = i;
        j3 = k;
        if (c != '>') goto _L109; else goto _L114
_L114:
        l2 = i;
        j3 = k;
        if ((i & 1) != 0) goto _L109; else goto _L115
_L115:
        linebufferedreader.pos = l;
        i = (i >> 1) + j1;
        xmlfilter.emitDoctypeDecl(ac, j1, j2, i, l - 1 - i);
        k2 = 60;
        i1 = k1;
        i2 = -1;
        k = 1;
        l1 = j2;
        byte1 = byte0;
        s1 = s;
        i = l;
          goto _L28
_L9:
        k2 = 60;
        byte0 = 14;
        if (c == '/')
        {
            linebufferedreader.pos = i;
            xmlfilter.emitEndAttributes();
            xmlfilter.emitEndElement(null, 0, 0);
            k = 27;
            i1 = j1;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
        } else
        if (c == '>')
        {
            linebufferedreader.pos = i;
            xmlfilter.emitEndAttributes();
            k = 1;
            i1 = j1;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
        } else
        {
            j1 = i - 1;
            j = 9;
            l2 = k2;
            continue; /* Loop/switch isn't completed */
        }
          goto _L28
_L8:
        if (c == ' ' || c == '\t' || c == '\r' || c == '\n' || c == '\205') goto _L1; else goto _L116
_L116:
        if (c == '\u2028')
        {
            i1 = j1;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k = j;
            k2 = l2;
        } else
        {
            linebufferedreader.pos = i - j2;
            xmlfilter.emitStartAttribute(ac, j1, j2);
            i1 = k1;
            if (c == '=')
            {
                k = 11;
                l1 = j2;
                i2 = l;
                byte1 = byte0;
                s1 = s;
                k2 = l2;
            } else
            {
                xmlfilter.emitEndAttributes();
                s = "missing or misplaced '=' after attribute name";
                j = 36;
                j1 = i1;
                continue; /* Loop/switch isn't completed */
            }
        }
          goto _L28
_L10:
        if (c != '\'' && c != '"')
        {
            continue; /* Loop/switch isn't completed */
        }
        k2 = c;
        byte1 = 12;
        k = 1;
        i1 = j1;
        l1 = j2;
        i2 = l;
        s1 = s;
          goto _L28
        if (c == ' ' || c == '\t' || c == '\r' || c == '\n' || c == '\205') goto _L1; else goto _L117
_L117:
        if (c == '\u2028')
        {
            i1 = j1;
            l1 = j2;
            i2 = l;
            byte1 = byte0;
            s1 = s;
            k = j;
            k2 = l2;
        } else
        {
            s = "missing or unquoted attribute value";
            j = 36;
            continue; /* Loop/switch isn't completed */
        }
          goto _L28
_L15:
        j1 = i - 1;
        j = 5;
        continue; /* Loop/switch isn't completed */
_L6:
        linebufferedreader.pos = i;
        xmlfilter.emitEndElement(ac, j1, j2);
        j1 = k1;
        j = 29;
        continue; /* Loop/switch isn't completed */
_L20:
        if (c != '>')
        {
            s = "missing '>'";
            j = 36;
            continue; /* Loop/switch isn't completed */
        }
        k = 1;
        i1 = j1;
        l1 = j2;
        i2 = l;
        byte1 = byte0;
        s1 = s;
        k2 = l2;
          goto _L28
_L27:
        if (j <= 0) goto _L119; else goto _L118
_L118:
        linebufferedreader.pos = i1;
        linebufferedreader.mark(j + 1);
_L119:
        linebufferedreader.pos = i;
        if (linebufferedreader.read() >= 0) goto _L121; else goto _L120
_L121:
        if (j <= 0) goto _L123; else goto _L122
_L122:
        try
        {
            linebufferedreader.reset();
            linebufferedreader.skip(j);
        }
        // Misplaced declaration of an exception variable
        catch (LineBufferedReader linebufferedreader)
        {
            throw new RuntimeException(linebufferedreader.getMessage());
        }
_L124:
        i = linebufferedreader.pos;
        ac = linebufferedreader.buffer;
        k1 = linebufferedreader.limit;
        if (j > 0)
        {
            j1 = i - j;
        } else
        {
            j1 = k1;
        }
        c = ac[i];
        i++;
        j2 = l1;
        l = i2;
        byte0 = byte1;
        s = s1;
        j = k;
        l2 = k2;
        continue; /* Loop/switch isn't completed */
_L123:
        linebufferedreader.unread_quick();
          goto _L124
_L16:
        l1 = j2;
        j2 = i;
          goto _L125
_L19:
        l1 = j2;
        j2 = i;
          goto _L126
_L120:
        if (k == 1 || k == 28)
        {
            return;
        }
        j = 37;
        j1 = i1;
        j2 = l1;
        l = i2;
        byte0 = byte1;
        s = s1;
        l2 = k2;
        if (true) goto _L128; else goto _L127
_L127:
    }

    public static void parse(InputStream inputstream, Object obj, SourceMessages sourcemessages, Consumer consumer)
        throws IOException
    {
        inputstream = XMLStreamReader(inputstream);
        if (obj != null)
        {
            inputstream.setName(obj);
        }
        parse(((LineBufferedReader) (inputstream)), sourcemessages, consumer);
        inputstream.close();
    }

    public static void parse(Object obj, SourceMessages sourcemessages, Consumer consumer)
        throws IOException
    {
        parse(Path.openInputStream(obj), obj, sourcemessages, consumer);
    }
}
