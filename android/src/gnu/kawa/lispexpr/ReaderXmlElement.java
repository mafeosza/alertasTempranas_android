// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.PrimProcedure;
import gnu.expr.Special;
import gnu.kawa.xml.CommentConstructor;
import gnu.kawa.xml.MakeAttribute;
import gnu.kawa.xml.MakeCDATA;
import gnu.kawa.xml.MakeProcInst;
import gnu.kawa.xml.MakeText;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Namespace;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import gnu.xml.XName;
import java.io.IOException;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReadTableEntry, LispReader, MakeXmlElement, ReadTable, 
//            ResolveNamespace

public class ReaderXmlElement extends ReadTableEntry
{

    static final String DEFAULT_ELEMENT_NAMESPACE = "[default-element-namespace]";

    public ReaderXmlElement()
    {
    }

    public static void namedEntity(LispReader lispreader, String s)
    {
        s = s.intern();
        byte byte0 = 63;
        if (s == "lt")
        {
            byte0 = 60;
        } else
        if (s == "gt")
        {
            byte0 = 62;
        } else
        if (s == "amp")
        {
            byte0 = 38;
        } else
        if (s == "quot")
        {
            byte0 = 34;
        } else
        if (s == "apos")
        {
            byte0 = 39;
        } else
        {
            lispreader.error((new StringBuilder()).append("unknown enity reference: '").append(s).append("'").toString());
        }
        lispreader.tokenBufferAppend(byte0);
    }

    public static Pair quote(Object obj)
    {
        return LList.list2(Namespace.EmptyNamespace.getSymbol("quote"), obj);
    }

    static void readCharRef(LispReader lispreader)
        throws IOException, SyntaxException
    {
        int i = lispreader.read();
        byte byte0;
        int j;
        if (i == 120)
        {
            byte0 = 16;
            i = lispreader.read();
        } else
        {
            byte0 = 10;
        }
        j = 0;
label0:
        do
        {
            int k;
            if (i >= 0)
            {
                k = Character.digit((char)i, byte0);
                break MISSING_BLOCK_LABEL_33;
            }
            do
            {
                if (i != 59)
                {
                    lispreader.unread(i);
                    lispreader.error("invalid character reference");
                    return;
                }
                break label0;
            } while (k < 0 || j >= 0x8000000);
            j = j * byte0 + k;
            i = lispreader.read();
        } while (true);
        if (j > 0 && j <= 55295 || j >= 57344 && j <= 65533 || j >= 0x10000 && j <= 0x10ffff)
        {
            lispreader.tokenBufferAppend(j);
            return;
        } else
        {
            lispreader.error((new StringBuilder()).append("invalid character value ").append(j).toString());
            return;
        }
    }

    public static Pair readContent(LispReader lispreader, char c, Pair pair)
        throws IOException, SyntaxException
    {
        Object obj1;
        int j;
        lispreader.tokenBufferLength = 0;
        j = 0;
        obj1 = pair;
_L11:
        Object obj;
        String s;
        Object obj2;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        int k;
        int l;
        int i1;
        obj5 = null;
        pair = null;
        obj4 = null;
        obj6 = null;
        obj2 = null;
        s = null;
        obj7 = null;
        obj = null;
        l = lispreader.getLineNumber();
        i1 = lispreader.getColumnNumber();
        k = lispreader.read();
        if (k >= 0) goto _L2; else goto _L1
_L1:
        int i;
        lispreader.error("unexpected end-of-file");
        pair = ((Pair) (Special.eof));
        i = j;
_L9:
        s = ((String) (obj));
        if (pair != null)
        {
            s = ((String) (obj));
            if (lispreader.tokenBufferLength > 0)
            {
                s = lispreader.tokenBufferString();
                lispreader.tokenBufferLength = 0;
            }
        }
        obj = obj1;
        if (s != null)
        {
            obj = PairWithPosition.make(Pair.list2(MakeText.makeText, s), lispreader.makeNil(), null, -1, -1);
            ((Pair) (obj1)).setCdrBackdoor(obj);
        }
        if (pair == Special.eof)
        {
            return ((Pair) (obj));
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (k == c)
        {
            if (c == '<')
            {
                obj = obj6;
                if (lispreader.tokenBufferLength > 0)
                {
                    obj = lispreader.tokenBufferString();
                    lispreader.tokenBufferLength = 0;
                }
                i = lispreader.read();
                if (i == 47)
                {
                    pair = ((Pair) (Special.eof));
                } else
                {
                    pair = ((Pair) (readXMLConstructor(lispreader, i, true)));
                }
            } else
            if (lispreader.checkNext(c))
            {
                lispreader.tokenBufferAppend(c);
                pair = obj5;
                obj = obj2;
            } else
            {
                pair = ((Pair) (Special.eof));
                obj = obj2;
            }
            i = 0;
            continue; /* Loop/switch isn't completed */
        }
        if (k != 38) goto _L4; else goto _L3
_L3:
        i = lispreader.read();
        if (i != 35) goto _L6; else goto _L5
_L5:
        readCharRef(lispreader);
        obj = s;
_L7:
        i = 1;
        continue; /* Loop/switch isn't completed */
_L6:
label0:
        {
label1:
            {
                if (i != 40 && i != 123)
                {
                    break label0;
                }
                if (lispreader.tokenBufferLength <= 0)
                {
                    obj = obj7;
                    if (j == 0)
                    {
                        break label1;
                    }
                }
                obj = lispreader.tokenBufferString();
            }
            lispreader.tokenBufferLength = 0;
            pair = ((Pair) (readEscapedExpression(lispreader, i)));
            continue; /* Loop/switch isn't completed */
        }
        Object obj3 = readEntity(lispreader, i);
        pair = ((Pair) (obj3));
        obj = s;
        if (j != 0)
        {
            pair = ((Pair) (obj3));
            obj = s;
            if (lispreader.tokenBufferLength == 0)
            {
                obj = "";
                pair = ((Pair) (obj3));
            }
        }
        if (true) goto _L7; else goto _L4
_L4:
label2:
        {
            i = k;
            if (c == '<')
            {
                break label2;
            }
            if (k != 9 && k != 10)
            {
                i = k;
                if (k != 13)
                {
                    break label2;
                }
            }
            i = 32;
        }
        if (i == 60)
        {
            lispreader.error('e', "'<' must be quoted in a direct attribute value");
        }
        lispreader.tokenBufferAppend((char)i);
        pair = obj4;
        i = j;
        if (true) goto _L9; else goto _L8
_L8:
        j = i;
        obj1 = obj;
        if (pair != null)
        {
            obj1 = PairWithPosition.make(pair, lispreader.makeNil(), null, l + 1, i1);
            ((Pair) (obj)).setCdrBackdoor(obj1);
            j = i;
        }
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static Object readElementConstructor(LispReader lispreader, int i)
        throws IOException, SyntaxException
    {
label0:
        {
            int j1 = lispreader.getLineNumber() + 1;
            int k1 = lispreader.getColumnNumber() - 2;
            Object obj = readQNameExpression(lispreader, i, true);
            String s;
            Object obj3;
            PairWithPosition pairwithposition;
            PairWithPosition pairwithposition1;
            if (lispreader.tokenBufferLength == 0)
            {
                s = null;
            } else
            {
                s = lispreader.tokenBufferString();
            }
            pairwithposition1 = PairWithPosition.make(obj, LList.Empty, lispreader.getName(), j1, k1);
            pairwithposition = pairwithposition1;
            obj3 = LList.Empty;
            do
            {
                boolean flag = false;
                for (i = lispreader.readUnicodeChar(); i >= 0 && Character.isWhitespace(i);)
                {
                    i = lispreader.read();
                    flag = true;
                }

                if (i < 0 || i == 62 || i == 47)
                {
                    boolean flag1 = false;
                    flag = flag1;
                    int k = i;
                    if (i == 47)
                    {
                        k = lispreader.read();
                        Object obj1;
                        PairWithPosition pairwithposition2;
                        Object obj4;
                        if (k == 62)
                        {
                            flag = true;
                        } else
                        {
                            lispreader.unread(k);
                            flag = flag1;
                        }
                    }
                    if (flag)
                    {
                        break label0;
                    }
                    if (k != 62)
                    {
                        lispreader.error("missing '>' after start element");
                        return Boolean.FALSE;
                    }
                    break;
                }
                if (!flag)
                {
                    lispreader.error("missing space before attribute");
                }
                obj4 = readQNameExpression(lispreader, i, false);
                lispreader.getLineNumber();
                lispreader.getColumnNumber();
                i = lispreader.tokenBufferLength;
                pairwithposition2 = null;
                obj1 = pairwithposition2;
                if (lispreader.tokenBufferLength >= 5)
                {
                    obj1 = pairwithposition2;
                    if (lispreader.tokenBuffer[0] == 'x')
                    {
                        obj1 = pairwithposition2;
                        if (lispreader.tokenBuffer[1] == 'm')
                        {
                            obj1 = pairwithposition2;
                            if (lispreader.tokenBuffer[2] == 'l')
                            {
                                obj1 = pairwithposition2;
                                if (lispreader.tokenBuffer[3] == 'n')
                                {
                                    obj1 = pairwithposition2;
                                    if (lispreader.tokenBuffer[4] == 's')
                                    {
                                        if (lispreader.tokenBufferLength == 5)
                                        {
                                            obj1 = "";
                                        } else
                                        {
                                            obj1 = pairwithposition2;
                                            if (lispreader.tokenBuffer[5] == ':')
                                            {
                                                obj1 = new String(lispreader.tokenBuffer, 6, lispreader.tokenBufferLength - 6);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (skipSpace(lispreader, 32) != 61)
                {
                    lispreader.error("missing '=' after attribute");
                }
                i = skipSpace(lispreader, 32);
                pairwithposition2 = PairWithPosition.make(MakeAttribute.makeAttribute, LList.Empty, lispreader.getName(), j1, k1);
                obj4 = PairWithPosition.make(obj4, LList.Empty, lispreader.getName(), j1, k1);
                lispreader.setCdr(pairwithposition2, obj4);
                readContent(lispreader, (char)i, ((Pair) (obj4)));
                if (obj1 != null)
                {
                    obj3 = new PairWithPosition(((gnu.text.SourceLocator) (obj4)), Pair.make(obj1, ((PairWithPosition) (obj4)).getCdr()), obj3);
                } else
                {
                    obj1 = PairWithPosition.make(pairwithposition2, lispreader.makeNil(), null, -1, -1);
                    pairwithposition.setCdrBackdoor(obj1);
                    pairwithposition = ((PairWithPosition) (obj1));
                }
            } while (true);
            readContent(lispreader, '<', pairwithposition);
            i = lispreader.readUnicodeChar();
            int j = i;
            if (XName.isNameStart(i))
            {
                lispreader.tokenBufferLength = 0;
                j = i;
                do
                {
                    do
                    {
                        lispreader.tokenBufferAppend(j);
                        i = lispreader.readUnicodeChar();
                        j = i;
                    } while (XName.isNamePart(i));
                    j = i;
                } while (i == 58);
                Object obj2 = lispreader.tokenBufferString();
                if (s == null || !((String) (obj2)).equals(s))
                {
                    String s1 = lispreader.getName();
                    j = lispreader.getLineNumber();
                    int l = lispreader.getColumnNumber();
                    int i1 = lispreader.tokenBufferLength;
                    if (s == null)
                    {
                        obj2 = (new StringBuilder()).append("computed start tag closed by '</").append(((String) (obj2))).append(">'").toString();
                    } else
                    {
                        obj2 = (new StringBuilder()).append("'<").append(s).append(">' closed by '</").append(((String) (obj2))).append(">'").toString();
                    }
                    lispreader.error('e', s1, j + 1, l - i1, ((String) (obj2)));
                }
                lispreader.tokenBufferLength = 0;
                j = i;
            }
            if (skipSpace(lispreader, j) != 62)
            {
                lispreader.error("missing '>' after end element");
            }
        }
        obj2 = LList.reverseInPlace(obj3);
        return PairWithPosition.make(MakeXmlElement.makeXml, Pair.make(obj2, pairwithposition1), lispreader.getName(), j1, k1);
    }

    static Object readEntity(LispReader lispreader, int i)
        throws IOException, SyntaxException
    {
        int j = lispreader.tokenBufferLength;
        do
        {
label0:
            {
                char c;
                if (i >= 0)
                {
                    c = (char)i;
                    if (XName.isNamePart(c))
                    {
                        break label0;
                    }
                }
                if (i != 59)
                {
                    lispreader.unread(i);
                    lispreader.error("invalid entity reference");
                    return "?";
                } else
                {
                    String s = new String(lispreader.tokenBuffer, j, lispreader.tokenBufferLength - j);
                    lispreader.tokenBufferLength = j;
                    namedEntity(lispreader, s);
                    return null;
                }
            }
            lispreader.tokenBufferAppend(c);
            i = lispreader.read();
        } while (true);
    }

    static Object readEscapedExpression(LispReader lispreader, int i)
        throws IOException, SyntaxException
    {
        char c;
        LineBufferedReader linebufferedreader;
        int j;
        if (i == 40)
        {
            lispreader.unread(i);
            return lispreader.readObject();
        }
        linebufferedreader = lispreader.getPort();
        c = lispreader.pushNesting('{');
        i = linebufferedreader.getLineNumber();
        j = linebufferedreader.getColumnNumber();
        Pair pair = lispreader.makePair(new PrimProcedure(Compilation.typeValues.getDeclaredMethod("values", 1)), i, j);
        Object obj = pair;
        ReadTable readtable = ReadTable.getCurrent();
_L2:
        int k;
        int l;
        int i1;
        k = linebufferedreader.getLineNumber();
        l = linebufferedreader.getColumnNumber();
        i1 = linebufferedreader.read();
        if (i1 != 125)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        lispreader.tokenBufferLength = 0;
        if (obj != pair.getCdr())
        {
            break MISSING_BLOCK_LABEL_207;
        }
        obj = ((Pair) (obj)).getCar();
        lispreader.popNesting(c);
        return obj;
        if (i1 >= 0)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        lispreader.eofError("unexpected EOF in list starting here", i + 1, j);
        Object obj1 = lispreader.readValues(i1, readtable.lookup(i1), readtable);
        if (obj1 == Values.empty) goto _L2; else goto _L1
_L1:
        obj1 = lispreader.makePair(lispreader.handlePostfix(obj1, readtable, k, l), k, l);
        lispreader.setCdr(obj, obj1);
        obj = obj1;
          goto _L2
        lispreader.popNesting(c);
        return pair;
        Exception exception;
        exception;
        lispreader.popNesting(c);
        throw exception;
    }

    public static Object readQNameExpression(LispReader lispreader, int i, boolean flag)
        throws IOException, SyntaxException
    {
        lispreader.getName();
        int i1 = lispreader.getLineNumber();
        int j1 = lispreader.getColumnNumber();
        lispreader.tokenBufferLength = 0;
        if (XName.isNameStart(i))
        {
            int l = -1;
            int j = i;
            i = l;
            do
            {
                do
                {
                    lispreader.tokenBufferAppend(j);
                    l = lispreader.readUnicodeChar();
                    if (l != 58 || i >= 0)
                    {
                        break;
                    }
                    i = lispreader.tokenBufferLength;
                    j = l;
                } while (true);
                j = l;
            } while (XName.isNamePart(l));
            lispreader.unread(l);
            if (i >= 0 || flag)
            {
                int k = lispreader.tokenBufferLength;
                String s = (new String(lispreader.tokenBuffer, i + 1, k - i - 1)).intern();
                Object obj;
                if (i < 0)
                {
                    obj = "[default-element-namespace]";
                } else
                {
                    obj = (new String(lispreader.tokenBuffer, 0, i)).intern();
                }
                obj = Namespace.EmptyNamespace.getSymbol(((String) (obj)));
                return new Pair(ResolveNamespace.resolveQName, PairWithPosition.make(obj, new Pair(s, LList.Empty), lispreader.getName(), i1 + 1, j1));
            } else
            {
                return quote(Namespace.getDefaultSymbol(lispreader.tokenBufferString().intern()));
            }
        }
        if (i == 123 || i == 40)
        {
            return readEscapedExpression(lispreader, i);
        } else
        {
            lispreader.error("missing element name");
            return null;
        }
    }

    static Object readXMLConstructor(LispReader lispreader, int i, boolean flag)
        throws IOException, SyntaxException
    {
        char c;
        String s;
        int k2;
        int l2;
label0:
        {
            k2 = lispreader.getLineNumber() + 1;
            l2 = lispreader.getColumnNumber() - 2;
            if (i == 33)
            {
                i = lispreader.read();
                int j = i;
                if (i == 45)
                {
                    i = lispreader.peek();
                    j = i;
                    if (i == 45)
                    {
                        lispreader.skip();
                        if (!lispreader.readDelimited("-->"))
                        {
                            lispreader.error('f', lispreader.getName(), k2, l2, "unexpected end-of-file in XML comment starting here - expected \"-->\"");
                        }
                        lispreader = lispreader.tokenBufferString();
                        return LList.list2(CommentConstructor.commentConstructor, lispreader);
                    }
                }
                i = j;
                if (j == 91)
                {
                    int k = lispreader.read();
                    i = k;
                    if (k == 67)
                    {
                        int l = lispreader.read();
                        i = l;
                        if (l == 68)
                        {
                            int i1 = lispreader.read();
                            i = i1;
                            if (i1 == 65)
                            {
                                int j1 = lispreader.read();
                                i = j1;
                                if (j1 == 84)
                                {
                                    int k1 = lispreader.read();
                                    i = k1;
                                    if (k1 == 65)
                                    {
                                        int l1 = lispreader.read();
                                        i = l1;
                                        if (l1 == 91)
                                        {
                                            if (!lispreader.readDelimited("]]>"))
                                            {
                                                lispreader.error('f', lispreader.getName(), k2, l2, "unexpected end-of-file in CDATA starting here - expected \"]]>\"");
                                            }
                                            lispreader = lispreader.tokenBufferString();
                                            return LList.list2(MakeCDATA.makeCDATA, lispreader);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                lispreader.error('f', lispreader.getName(), k2, l2, "'<!' must be followed by '--' or '[CDATA['");
                for (; i >= 0 && i != 62 && i != 10 && i != 13; i = lispreader.read()) { }
                return null;
            }
            if (i != 63)
            {
                break MISSING_BLOCK_LABEL_471;
            }
            int i2 = lispreader.readUnicodeChar();
            if (i2 >= 0)
            {
                i = i2;
                if (XName.isNameStart(i2))
                {
                    break label0;
                }
            }
            lispreader.error("missing target after '<?'");
            i = i2;
        }
        int j2;
        do
        {
            lispreader.tokenBufferAppend(i);
            j2 = lispreader.readUnicodeChar();
            i = j2;
        } while (XName.isNamePart(j2));
        s = lispreader.tokenBufferString();
        i = 0;
        for (; j2 >= 0 && Character.isWhitespace(j2); j2 = lispreader.read())
        {
            i++;
        }

        lispreader.unread(j2);
        c = lispreader.pushNesting('?');
        if (!lispreader.readDelimited("?>"))
        {
            lispreader.error('f', lispreader.getName(), k2, l2, "unexpected end-of-file looking for \"?>\"");
        }
        lispreader.popNesting(c);
        if (i == 0 && lispreader.tokenBufferLength > 0)
        {
            lispreader.error("target must be followed by space or '?>'");
        }
        lispreader = lispreader.tokenBufferString();
        return LList.list3(MakeProcInst.makeProcInst, s, lispreader);
        Exception exception;
        exception;
        lispreader.popNesting(c);
        throw exception;
        return readElementConstructor(lispreader, i);
    }

    static int skipSpace(LispReader lispreader, int i)
        throws IOException, SyntaxException
    {
        do
        {
            if (i < 0 || !Character.isWhitespace(i))
            {
                return i;
            }
            i = lispreader.readUnicodeChar();
        } while (true);
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        lexer = (LispReader)lexer;
        return readXMLConstructor(lexer, lexer.readUnicodeChar(), false);
    }
}
