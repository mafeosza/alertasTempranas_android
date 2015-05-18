// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.xml;

import gnu.expr.Keyword;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.UnescapedData;
import gnu.lists.XConsumer;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.math.DFloNum;
import gnu.math.RealNum;
import gnu.text.Char;
import gnu.text.Path;
import gnu.text.PrettyWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;

// Referenced classes of package gnu.xml:
//            NamespaceBinding, XName, NodeTree

public class XMLPrinter extends OutPort
    implements PositionConsumer, XConsumer
{

    private static final int COMMENT = -5;
    private static final int ELEMENT_END = -4;
    private static final int ELEMENT_START = -3;
    static final String HtmlEmptyTags = "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/";
    private static final int KEYWORD = -6;
    private static final int PROC_INST = -7;
    private static final int WORD = -2;
    public static final ThreadLocation doctypePublic = new ThreadLocation("doctype-public");
    public static final ThreadLocation doctypeSystem = new ThreadLocation("doctype-system");
    public static final ThreadLocation indentLoc = new ThreadLocation("xml-indent");
    boolean canonicalize;
    public boolean canonicalizeCDATA;
    Object elementNameStack[];
    int elementNesting;
    public boolean escapeNonAscii;
    public boolean escapeText;
    boolean inAttribute;
    int inComment;
    boolean inDocument;
    boolean inStartTag;
    public boolean indentAttributes;
    boolean isHtml;
    boolean isHtmlOrXhtml;
    NamespaceBinding namespaceBindings;
    NamespaceBinding namespaceSaveStack[];
    boolean needXMLdecl;
    int prev;
    public int printIndent;
    boolean printXMLdecl;
    char savedHighSurrogate;
    public boolean strict;
    Object style;
    boolean undeclareNamespaces;
    public int useEmptyElementTag;

    public XMLPrinter(OutPort outport, boolean flag)
    {
        super(outport, flag);
        printIndent = -1;
        printXMLdecl = false;
        inAttribute = false;
        inStartTag = false;
        needXMLdecl = false;
        canonicalize = true;
        useEmptyElementTag = 2;
        escapeText = true;
        escapeNonAscii = true;
        isHtml = false;
        isHtmlOrXhtml = false;
        undeclareNamespaces = false;
        namespaceBindings = NamespaceBinding.predefinedXML;
        namespaceSaveStack = new NamespaceBinding[20];
        elementNameStack = new Object[20];
        prev = 32;
    }

    public XMLPrinter(OutputStream outputstream)
    {
        super(new OutputStreamWriter(outputstream), false, false);
        printIndent = -1;
        printXMLdecl = false;
        inAttribute = false;
        inStartTag = false;
        needXMLdecl = false;
        canonicalize = true;
        useEmptyElementTag = 2;
        escapeText = true;
        escapeNonAscii = true;
        isHtml = false;
        isHtmlOrXhtml = false;
        undeclareNamespaces = false;
        namespaceBindings = NamespaceBinding.predefinedXML;
        namespaceSaveStack = new NamespaceBinding[20];
        elementNameStack = new Object[20];
        prev = 32;
    }

    public XMLPrinter(OutputStream outputstream, Path path)
    {
        super(new OutputStreamWriter(outputstream), true, false, path);
        printIndent = -1;
        printXMLdecl = false;
        inAttribute = false;
        inStartTag = false;
        needXMLdecl = false;
        canonicalize = true;
        useEmptyElementTag = 2;
        escapeText = true;
        escapeNonAscii = true;
        isHtml = false;
        isHtmlOrXhtml = false;
        undeclareNamespaces = false;
        namespaceBindings = NamespaceBinding.predefinedXML;
        namespaceSaveStack = new NamespaceBinding[20];
        elementNameStack = new Object[20];
        prev = 32;
    }

    public XMLPrinter(OutputStream outputstream, boolean flag)
    {
        super(new OutputStreamWriter(outputstream), true, flag);
        printIndent = -1;
        printXMLdecl = false;
        inAttribute = false;
        inStartTag = false;
        needXMLdecl = false;
        canonicalize = true;
        useEmptyElementTag = 2;
        escapeText = true;
        escapeNonAscii = true;
        isHtml = false;
        isHtmlOrXhtml = false;
        undeclareNamespaces = false;
        namespaceBindings = NamespaceBinding.predefinedXML;
        namespaceSaveStack = new NamespaceBinding[20];
        elementNameStack = new Object[20];
        prev = 32;
    }

    public XMLPrinter(Writer writer)
    {
        super(writer);
        printIndent = -1;
        printXMLdecl = false;
        inAttribute = false;
        inStartTag = false;
        needXMLdecl = false;
        canonicalize = true;
        useEmptyElementTag = 2;
        escapeText = true;
        escapeNonAscii = true;
        isHtml = false;
        isHtmlOrXhtml = false;
        undeclareNamespaces = false;
        namespaceBindings = NamespaceBinding.predefinedXML;
        namespaceSaveStack = new NamespaceBinding[20];
        elementNameStack = new Object[20];
        prev = 32;
    }

    public XMLPrinter(Writer writer, boolean flag)
    {
        super(writer, flag);
        printIndent = -1;
        printXMLdecl = false;
        inAttribute = false;
        inStartTag = false;
        needXMLdecl = false;
        canonicalize = true;
        useEmptyElementTag = 2;
        escapeText = true;
        escapeNonAscii = true;
        isHtml = false;
        isHtmlOrXhtml = false;
        undeclareNamespaces = false;
        namespaceBindings = NamespaceBinding.predefinedXML;
        namespaceSaveStack = new NamespaceBinding[20];
        elementNameStack = new Object[20];
        prev = 32;
    }

    static String formatDecimal(String s)
    {
        int j;
label0:
        {
            if (s.indexOf('.') >= 0)
            {
                int k = s.length();
                j = k;
                int i;
                char c;
                do
                {
                    i = j - 1;
                    c = s.charAt(i);
                    j = i;
                } while (c == '0');
                j = i;
                if (c != '.')
                {
                    j = i + 1;
                }
                if (j != k)
                {
                    break label0;
                }
            }
            return s;
        }
        return s.substring(0, j);
    }

    public static String formatDecimal(BigDecimal bigdecimal)
    {
        return formatDecimal(bigdecimal.toPlainString());
    }

    public static String formatDouble(double d)
    {
        if (Double.isNaN(d))
        {
            return "NaN";
        }
        boolean flag;
        if (d < 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (Double.isInfinite(d))
        {
            if (flag)
            {
                return "-INF";
            } else
            {
                return "INF";
            }
        }
        double d1;
        String s;
        if (flag)
        {
            d1 = -d;
        } else
        {
            d1 = d;
        }
        s = Double.toString(d);
        if ((d1 >= 1000000D || d1 < 9.9999999999999995E-07D) && d1 != 0.0D)
        {
            return RealNum.toStringScientific(s);
        } else
        {
            return formatDecimal(RealNum.toStringDecimal(s));
        }
    }

    public static String formatFloat(float f)
    {
        if (Float.isNaN(f))
        {
            return "NaN";
        }
        boolean flag;
        if (f < 0.0F)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (Float.isInfinite(f))
        {
            if (flag)
            {
                return "-INF";
            } else
            {
                return "INF";
            }
        }
        float f1;
        String s;
        if (flag)
        {
            f1 = -f;
        } else
        {
            f1 = f;
        }
        s = Float.toString(f);
        if ((f1 >= 1000000F || (double)f1 < 9.9999999999999995E-07D) && (double)f1 != 0.0D)
        {
            return RealNum.toStringScientific(s);
        } else
        {
            return formatDecimal(RealNum.toStringDecimal(s));
        }
    }

    public static boolean isHtmlEmptyElementTag(String s)
    {
        int i = "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/".indexOf(s);
        return i > 0 && "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/".charAt(i - 1) == '/' && "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/".charAt(s.length() + i) == '/';
    }

    public static XMLPrinter make(OutPort outport, Object obj)
    {
        outport = new XMLPrinter(outport, true);
        outport.setStyle(obj);
        return outport;
    }

    private void startWord()
    {
        closeTag();
        writeWordStart();
    }

    public static String toString(Object obj)
    {
        StringWriter stringwriter = new StringWriter();
        (new XMLPrinter(stringwriter)).writeObject(obj);
        return stringwriter.toString();
    }

    public void beginComment()
    {
        closeTag();
        if (printIndent >= 0 && (prev == -3 || prev == -4 || prev == -5))
        {
            byte byte0;
            if (printIndent > 0)
            {
                byte0 = 82;
            } else
            {
                byte0 = 78;
            }
            writeBreak(byte0);
        }
        bout.write("<!--");
        inComment = 1;
    }

    public void beginEntity(Object obj)
    {
    }

    public void closeTag()
    {
        if (inStartTag && !inAttribute)
        {
            if (printIndent >= 0 && indentAttributes)
            {
                endLogicalBlock("");
            }
            bout.write(62);
            inStartTag = false;
            prev = -3;
        } else
        if (needXMLdecl)
        {
            bout.write("<?xml version=\"1.0\"?>\n");
            if (printIndent >= 0)
            {
                startLogicalBlock("", "", 2);
            }
            needXMLdecl = false;
            prev = 62;
            return;
        }
    }

    public void consume(SeqPosition seqposition)
    {
        seqposition.sequence.consumeNext(seqposition.ipos, this);
    }

    public void endAttribute()
    {
        if (inAttribute)
        {
            if (prev != -6)
            {
                bout.write(34);
                inAttribute = false;
            }
            prev = 32;
        }
    }

    public void endComment()
    {
        bout.write("-->");
        prev = -5;
        inComment = 0;
    }

    public void endDocument()
    {
        inDocument = false;
        if (printIndent >= 0)
        {
            endLogicalBlock("");
        }
        freshLine();
    }

    public void endElement()
    {
        Object obj;
        String s;
        Object obj1;
        Object obj2;
        if (useEmptyElementTag == 0)
        {
            closeTag();
        }
        obj1 = elementNameStack[elementNesting - 1];
        String s1 = getHtmlTag(obj1);
        if (!inStartTag)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        if (printIndent >= 0 && indentAttributes)
        {
            endLogicalBlock("");
        }
        s = null;
        int i;
        if (s1 != null && isHtmlEmptyElementTag(s1))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (useEmptyElementTag == 0) goto _L2; else goto _L1
_L1:
        obj = s;
        if (s1 == null) goto _L4; else goto _L3
_L3:
        obj = s;
        if (i != 0) goto _L4; else goto _L2
_L2:
        obj = s;
        if (!(obj1 instanceof Symbol)) goto _L4; else goto _L5
_L5:
        obj2 = (Symbol)obj1;
        obj = ((Symbol) (obj2)).getPrefix();
        obj1 = ((Symbol) (obj2)).getNamespaceURI();
        obj2 = ((Symbol) (obj2)).getLocalName();
        if (obj == "") goto _L7; else goto _L6
_L6:
        obj = (new StringBuilder()).append("></").append(((String) (obj))).append(":").append(((String) (obj2))).append(">").toString();
_L4:
        s = ((String) (obj));
        if (obj == null)
        {
            if (i != 0 && isHtml)
            {
                s = ">";
            } else
            if (useEmptyElementTag == 2)
            {
                s = " />";
            } else
            {
                s = "/>";
            }
        }
        bout.write(s);
        inStartTag = false;
_L10:
        if (printIndent >= 0)
        {
            endLogicalBlock("");
        }
        prev = -4;
        if (s1 != null && !escapeText && ("script".equals(s1) || "style".equals(s1)))
        {
            escapeText = true;
        }
        obj = namespaceSaveStack;
        i = elementNesting - 1;
        elementNesting = i;
        namespaceBindings = obj[i];
        namespaceSaveStack[elementNesting] = null;
        elementNameStack[elementNesting] = null;
        return;
_L7:
        if (obj1 == "") goto _L9; else goto _L8
_L8:
        obj = s;
        if (obj1 != null) goto _L4; else goto _L9
_L9:
        obj = (new StringBuilder()).append("></").append(((String) (obj2))).append(">").toString();
          goto _L4
        if (printIndent >= 0)
        {
            setIndentation(0, false);
            if (prev == -4)
            {
                byte byte0;
                if (printIndent > 0)
                {
                    byte0 = 82;
                } else
                {
                    byte0 = 78;
                }
                writeBreak(byte0);
            }
        }
        bout.write("</");
        writeQName(obj1);
        bout.write(">");
          goto _L10
    }

    public void endEntity()
    {
    }

    protected void endNumber()
    {
        writeWordEnd();
    }

    public void error(String s, String s1)
    {
        throw new RuntimeException((new StringBuilder()).append("serialization error: ").append(s).append(" [").append(s1).append(']').toString());
    }

    protected String getHtmlTag(Object obj)
    {
        if (obj instanceof Symbol)
        {
            obj = (Symbol)obj;
            String s = ((Symbol) (obj)).getNamespaceURI();
            if (s == "http://www.w3.org/1999/xhtml" || isHtmlOrXhtml && s == "")
            {
                return ((Symbol) (obj)).getLocalPart();
            }
        } else
        if (isHtmlOrXhtml)
        {
            return obj.toString();
        }
        return null;
    }

    public boolean ignoring()
    {
        return false;
    }

    boolean mustHexEscape(int i)
    {
        return i >= 127 && (i <= 159 || escapeNonAscii) || i == 8232 || i < 32 && (inAttribute || i != 9 && i != 10);
    }

    public void print(Object obj)
    {
        Object obj1;
        if (obj instanceof BigDecimal)
        {
            obj1 = formatDecimal((BigDecimal)obj);
        } else
        if ((obj instanceof Double) || (obj instanceof DFloNum))
        {
            obj1 = formatDouble(((Number)obj).doubleValue());
        } else
        {
            obj1 = obj;
            if (obj instanceof Float)
            {
                obj1 = formatFloat(((Float)obj).floatValue());
            }
        }
        if (obj1 == null)
        {
            obj = "(null)";
        } else
        {
            obj = obj1.toString();
        }
        write(((String) (obj)));
    }

    void setIndentMode()
    {
        String s = null;
        Object obj = indentLoc.get(null);
        if (obj != null)
        {
            s = obj.toString();
        }
        if (s == null)
        {
            printIndent = -1;
            return;
        }
        if (s.equals("pretty"))
        {
            printIndent = 0;
            return;
        }
        if (s.equals("always") || s.equals("yes"))
        {
            printIndent = 1;
            return;
        } else
        {
            printIndent = -1;
            return;
        }
    }

    public void setPrintXMLdecl(boolean flag)
    {
        printXMLdecl = flag;
    }

    public void setStyle(Object obj)
    {
        style = obj;
        int i;
        if (canonicalize)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        useEmptyElementTag = i;
        if (!"html".equals(obj)) goto _L2; else goto _L1
_L1:
        isHtml = true;
        isHtmlOrXhtml = true;
        useEmptyElementTag = 2;
        if (namespaceBindings == NamespaceBinding.predefinedXML)
        {
            namespaceBindings = XmlNamespace.HTML_BINDINGS;
        }
_L4:
        if ("xhtml".equals(obj))
        {
            isHtmlOrXhtml = true;
            useEmptyElementTag = 2;
        }
        if ("plain".equals(obj))
        {
            escapeText = false;
        }
        return;
_L2:
        if (namespaceBindings == XmlNamespace.HTML_BINDINGS)
        {
            namespaceBindings = NamespaceBinding.predefinedXML;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void startAttribute(Object obj)
    {
        if (!inStartTag && strict)
        {
            error("attribute not in element", "SENR0001");
        }
        if (inAttribute)
        {
            bout.write(34);
        }
        inAttribute = true;
        bout.write(32);
        if (printIndent >= 0)
        {
            writeBreakFill();
        }
        bout.write(obj.toString());
        bout.write("=\"");
        prev = 32;
    }

    public void startDocument()
    {
        if (printXMLdecl)
        {
            needXMLdecl = true;
        }
        setIndentMode();
        inDocument = true;
        if (printIndent >= 0 && !needXMLdecl)
        {
            startLogicalBlock("", "", 2);
        }
    }

    public void startElement(Object obj)
    {
        Object obj1;
        Object obj2;
        NamespaceBinding namespacebinding1;
        NamespaceBinding anamespacebinding1[];
        String s2;
        NamespaceBinding namespacebinding2;
        String s3;
        int i;
        int j;
        int l;
        boolean flag;
        closeTag();
        if (elementNesting == 0)
        {
            if (!inDocument)
            {
                setIndentMode();
            }
            if (prev == -7)
            {
                write(10);
            }
            obj1 = doctypeSystem.get(null);
            if (obj1 != null)
            {
                obj2 = obj1.toString();
                if (((String) (obj2)).length() > 0)
                {
                    obj1 = doctypePublic.get(null);
                    bout.write("<!DOCTYPE ");
                    bout.write(obj.toString());
                    if (obj1 == null)
                    {
                        obj1 = null;
                    } else
                    {
                        obj1 = obj1.toString();
                    }
                    if (obj1 != null && ((String) (obj1)).length() > 0)
                    {
                        bout.write(" PUBLIC \"");
                        bout.write(((String) (obj1)));
                        bout.write("\" \"");
                    } else
                    {
                        bout.write(" SYSTEM \"");
                    }
                    bout.write(((String) (obj2)));
                    bout.write("\">");
                    println();
                }
            }
        }
        if (printIndent >= 0)
        {
            if (prev == -3 || prev == -4 || prev == -5)
            {
                if (printIndent > 0)
                {
                    i = 82;
                } else
                {
                    i = 78;
                }
                writeBreak(i);
            }
            startLogicalBlock("", "", 2);
        }
        bout.write(60);
        writeQName(obj);
        if (printIndent >= 0 && indentAttributes)
        {
            startLogicalBlock("", "", 2);
        }
        elementNameStack[elementNesting] = obj;
        obj1 = namespaceSaveStack;
        i = elementNesting;
        elementNesting = i + 1;
        obj1[i] = namespaceBindings;
        if (!(obj instanceof XName)) goto _L2; else goto _L1
_L1:
        obj2 = ((XName)obj).namespaceNodes;
        namespacebinding1 = NamespaceBinding.commonAncestor(((NamespaceBinding) (obj2)), namespaceBindings);
        if (obj2 == null)
        {
            i = 0;
        } else
        {
            i = ((NamespaceBinding) (obj2)).count(namespacebinding1);
        }
        anamespacebinding1 = new NamespaceBinding[i];
        i = 0;
        flag = canonicalize;
        obj1 = obj2;
_L13:
        if (obj1 == namespacebinding1) goto _L4; else goto _L3
_L3:
        j = i;
        ((NamespaceBinding) (obj1)).getUri();
        s2 = ((NamespaceBinding) (obj1)).getPrefix();
_L11:
        l = j - 1;
        if (l < 0) goto _L6; else goto _L5
_L5:
        namespacebinding2 = anamespacebinding1[l];
        s3 = namespacebinding2.getPrefix();
        if (s2 != s3) goto _L8; else goto _L7
_L7:
        obj1 = ((NamespaceBinding) (obj1)).next;
        continue; /* Loop/switch isn't completed */
_L8:
        j = l;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
          goto _L9
_L6:
        if (flag)
        {
            j = l + 1;
        } else
        {
            j = i;
        }
        anamespacebinding1[j] = ((NamespaceBinding) (obj1));
        i++;
        if (true) goto _L7; else goto _L9
_L9:
        if (s2 == null || s3 != null && s2.compareTo(s3) <= 0) goto _L6; else goto _L10
_L10:
        anamespacebinding1[l + 1] = namespacebinding2;
        j = l;
        if (true) goto _L11; else goto _L4
_L4:
        do
        {
            int k = i - 1;
            if (k < 0)
            {
                break;
            }
            Object obj3 = anamespacebinding1[k];
            String s = ((NamespaceBinding) (obj3)).prefix;
            obj3 = ((NamespaceBinding) (obj3)).uri;
            i = k;
            if (obj3 == namespaceBindings.resolve(s))
            {
                continue;
            }
            if (obj3 == null && s != null)
            {
                i = k;
                if (!undeclareNamespaces)
                {
                    continue;
                }
            }
            bout.write(32);
            if (s == null)
            {
                bout.write("xmlns");
            } else
            {
                bout.write("xmlns:");
                bout.write(s);
            }
            bout.write("=\"");
            inAttribute = true;
            if (obj3 != null)
            {
                write(((String) (obj3)));
            }
            inAttribute = false;
            bout.write(34);
            i = k;
        } while (true);
        if (undeclareNamespaces)
        {
            NamespaceBinding namespacebinding = namespaceBindings;
            while (namespacebinding != namespacebinding1) 
            {
                String s1 = namespacebinding.prefix;
                if (namespacebinding.uri != null && ((NamespaceBinding) (obj2)).resolve(s1) == null)
                {
                    bout.write(32);
                    if (s1 == null)
                    {
                        bout.write("xmlns");
                    } else
                    {
                        bout.write("xmlns:");
                        bout.write(s1);
                    }
                    bout.write("=\"\"");
                }
                namespacebinding = namespacebinding.next;
            }
        }
        namespaceBindings = ((NamespaceBinding) (obj2));
_L2:
        if (elementNesting >= namespaceSaveStack.length)
        {
            NamespaceBinding anamespacebinding[] = new NamespaceBinding[elementNesting * 2];
            System.arraycopy(namespaceSaveStack, 0, anamespacebinding, 0, elementNesting);
            namespaceSaveStack = anamespacebinding;
            anamespacebinding = ((NamespaceBinding []) (new Object[elementNesting * 2]));
            System.arraycopy(((Object) (elementNameStack)), 0, anamespacebinding, 0, elementNesting);
            elementNameStack = anamespacebinding;
        }
        inStartTag = true;
        obj = getHtmlTag(obj);
        if ("script".equals(obj) || "style".equals(obj))
        {
            escapeText = false;
        }
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    protected void startNumber()
    {
        startWord();
    }

    public void write(int i)
    {
        closeTag();
        if (printIndent >= 0 && (i == 13 || i == 10))
        {
            if (i != 10 || prev != 13)
            {
                writeBreak(82);
            }
            if (inComment > 0)
            {
                inComment = 1;
            }
            return;
        }
        if (!escapeText)
        {
            bout.write(i);
            prev = i;
            return;
        }
        if (inComment > 0)
        {
            if (i == 45)
            {
                if (inComment == 1)
                {
                    inComment = 2;
                } else
                {
                    bout.write(32);
                }
            } else
            {
                inComment = 1;
            }
            super.write(i);
            return;
        }
        prev = 59;
        if (i == 60 && (!isHtml || !inAttribute))
        {
            bout.write("&lt;");
            return;
        }
        if (i == 62)
        {
            bout.write("&gt;");
            return;
        }
        if (i == 38)
        {
            bout.write("&amp;");
            return;
        }
        if (i == 34 && inAttribute)
        {
            bout.write("&quot;");
            return;
        }
        if (mustHexEscape(i))
        {
            int j = i;
            int k = j;
            if (i >= 55296)
            {
                if (i < 56320)
                {
                    savedHighSurrogate = (char)i;
                    return;
                }
                k = j;
                if (i < 57344)
                {
                    k = (savedHighSurrogate - 55296) * 1024 + (j - 56320) + 0x10000;
                    savedHighSurrogate = '\0';
                }
            }
            bout.write((new StringBuilder()).append("&#x").append(Integer.toHexString(k).toUpperCase()).append(";").toString());
            return;
        } else
        {
            bout.write(i);
            prev = i;
            return;
        }
    }

    public void write(String s, int i, int j)
    {
        if (j > 0)
        {
            closeTag();
            int l = i + j;
            boolean flag = false;
            j = i;
            i = ((flag) ? 1 : 0);
            while (j < l) 
            {
                int k = j + 1;
                j = s.charAt(j);
                if (mustHexEscape(j) || (inComment <= 0 ? j == 60 || j == 62 || j == 38 || inAttribute && (j == 34 || j < 32) : j == 45 || inComment == 2))
                {
                    if (i > 0)
                    {
                        bout.write(s, k - 1 - i, i);
                    }
                    write(j);
                    i = 0;
                } else
                {
                    i++;
                }
                j = k;
            }
            if (i > 0)
            {
                bout.write(s, l - i, i);
            }
        }
        prev = 45;
    }

    public void write(char ac[], int i, int j)
    {
        if (j > 0)
        {
            closeTag();
            int l = i + j;
            boolean flag = false;
            j = i;
            i = ((flag) ? 1 : 0);
            while (j < l) 
            {
                int k = j + 1;
                j = ac[j];
                if (mustHexEscape(j) || (inComment <= 0 ? j == 60 || j == 62 || j == 38 || inAttribute && (j == 34 || j < 32) : j == 45 || inComment == 2))
                {
                    if (i > 0)
                    {
                        bout.write(ac, k - 1 - i, i);
                    }
                    write(j);
                    i = 0;
                } else
                {
                    i++;
                }
                j = k;
            }
            if (i > 0)
            {
                bout.write(ac, l - i, i);
            }
        }
        prev = 45;
    }

    public void writeBaseUri(Object obj)
    {
    }

    public void writeBoolean(boolean flag)
    {
        startWord();
        super.print(flag);
        writeWordEnd();
    }

    public void writeCDATA(char ac[], int i, int j)
    {
        if (canonicalizeCDATA)
        {
            write(ac, i, j);
            return;
        }
        closeTag();
        bout.write("<![CDATA[");
        int l1 = i + j;
        int l = i;
        int k = j;
        int j1 = i;
        for (i = l; i < l1 - 2;)
        {
            int k1 = i;
            int i1 = j1;
            j = k;
            if (ac[i] == ']')
            {
                k1 = i;
                i1 = j1;
                j = k;
                if (ac[i + 1] == ']')
                {
                    k1 = i;
                    i1 = j1;
                    j = k;
                    if (ac[i + 2] == '>')
                    {
                        if (i > j1)
                        {
                            bout.write(ac, j1, i - j1);
                        }
                        print("]]]><![CDATA[]>");
                        i1 = i + 3;
                        j = l1 - i1;
                        k1 = i + 2;
                    }
                }
            }
            i = k1 + 1;
            j1 = i1;
            k = j;
        }

        bout.write(ac, j1, k);
        bout.write("]]>");
        prev = 62;
    }

    public void writeComment(String s)
    {
        beginComment();
        write(s);
        endComment();
    }

    public void writeComment(char ac[], int i, int j)
    {
        beginComment();
        write(ac, i, j);
        endComment();
    }

    public void writeDouble(double d)
    {
        startWord();
        bout.write(formatDouble(d));
    }

    public void writeFloat(float f)
    {
        startWord();
        bout.write(formatFloat(f));
    }

    public void writeObject(Object obj)
    {
        if (obj instanceof SeqPosition)
        {
            bout.clearWordEnd();
            obj = (SeqPosition)obj;
            ((SeqPosition) (obj)).sequence.consumeNext(((SeqPosition) (obj)).ipos, this);
            if (((SeqPosition) (obj)).sequence instanceof NodeTree)
            {
                prev = 45;
            }
            return;
        }
        if ((obj instanceof Consumable) && !(obj instanceof UnescapedData))
        {
            ((Consumable)obj).consume(this);
            return;
        }
        if (obj instanceof Keyword)
        {
            startAttribute(((Keyword)obj).getName());
            prev = -6;
            return;
        }
        closeTag();
        if (obj instanceof UnescapedData)
        {
            bout.clearWordEnd();
            bout.write(((UnescapedData)obj).getData());
            prev = 45;
            return;
        }
        if (obj instanceof Char)
        {
            Char.print(((Char)obj).intValue(), this);
            return;
        } else
        {
            startWord();
            prev = 32;
            print(obj);
            writeWordEnd();
            prev = -2;
            return;
        }
    }

    public void writePosition(AbstractSequence abstractsequence, int i)
    {
        abstractsequence.consumeNext(i, this);
    }

    public void writeProcessingInstruction(String s, char ac[], int i, int j)
    {
        if ("xml".equals(s))
        {
            needXMLdecl = false;
        }
        closeTag();
        bout.write("<?");
        print(s);
        print(' ');
        bout.write(ac, i, j);
        bout.write("?>");
        prev = -7;
    }

    protected void writeQName(Object obj)
    {
        if (obj instanceof Symbol)
        {
            obj = (Symbol)obj;
            String s = ((Symbol) (obj)).getPrefix();
            if (s != null && s.length() > 0)
            {
                bout.write(s);
                bout.write(58);
            }
            bout.write(((Symbol) (obj)).getLocalPart());
            return;
        }
        PrettyWriter prettywriter = bout;
        if (obj == null)
        {
            obj = "{null name}";
        } else
        {
            obj = (String)obj;
        }
        prettywriter.write(((String) (obj)));
    }

}
