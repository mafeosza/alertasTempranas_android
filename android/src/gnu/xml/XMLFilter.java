// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.xml;

import gnu.expr.Keyword;
import gnu.kawa.sax.ContentConsumer;
import gnu.lists.AbstractSequence;
import gnu.lists.CharSeq;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.lists.UnescapedData;
import gnu.lists.XConsumer;
import gnu.mapping.Symbol;
import gnu.text.Char;
import gnu.text.LineBufferedReader;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xml.sax.AttributeList;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.DocumentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

// Referenced classes of package gnu.xml:
//            MappingInfo, NodeTree, NamespaceBinding, XName, 
//            TextUtils

public class XMLFilter
    implements DocumentHandler, ContentHandler, SourceLocator, XConsumer, PositionConsumer
{

    public static final int COPY_NAMESPACES_INHERIT = 2;
    public static final int COPY_NAMESPACES_PRESERVE = 1;
    private static final int SAW_KEYWORD = 1;
    private static final int SAW_WORD = 2;
    int attrCount;
    String attrLocalName;
    String attrPrefix;
    Consumer base;
    public transient int copyNamespacesMode;
    String currentNamespacePrefix;
    protected int ignoringLevel;
    LineBufferedReader in;
    boolean inStartTag;
    SourceLocator locator;
    MappingInfo mappingTable[];
    int mappingTableMask;
    private SourceMessages messages;
    boolean mismatchReported;
    NamespaceBinding namespaceBindings;
    public boolean namespacePrefixes;
    protected int nesting;
    public Consumer out;
    int previous;
    int startIndexes[];
    protected int stringizingElementNesting;
    protected int stringizingLevel;
    TreeList tlist;
    Object workStack[];

    public XMLFilter(Consumer consumer)
    {
        copyNamespacesMode = 1;
        previous = 0;
        stringizingElementNesting = -1;
        startIndexes = null;
        attrCount = -1;
        namespacePrefixes = false;
        mappingTable = new MappingInfo[128];
        mappingTableMask = mappingTable.length - 1;
        base = consumer;
        out = consumer;
        if (consumer instanceof NodeTree)
        {
            tlist = (NodeTree)consumer;
        } else
        {
            tlist = new TreeList();
        }
        namespaceBindings = NamespaceBinding.predefinedXML;
    }

    public static String duplicateAttributeMessage(Symbol symbol, Object obj)
    {
        StringBuffer stringbuffer = new StringBuffer("duplicate attribute: ");
        String s = symbol.getNamespaceURI();
        if (s != null && s.length() > 0)
        {
            stringbuffer.append('{');
            stringbuffer.append('}');
            stringbuffer.append(s);
        }
        stringbuffer.append(symbol.getLocalPart());
        if (obj != null)
        {
            stringbuffer.append(" in <");
            stringbuffer.append(obj);
            stringbuffer.append('>');
        }
        return stringbuffer.toString();
    }

    private void ensureSpaceInStartIndexes(int i)
    {
        if (startIndexes == null)
        {
            startIndexes = new int[20];
        } else
        if (i >= startIndexes.length)
        {
            int ai[] = new int[startIndexes.length * 2];
            System.arraycopy(startIndexes, 0, ai, 0, i);
            startIndexes = ai;
            return;
        }
    }

    private void ensureSpaceInWorkStack(int i)
    {
        if (workStack == null)
        {
            workStack = new Object[20];
        } else
        if (i >= workStack.length)
        {
            Object aobj[] = new Object[workStack.length * 2];
            System.arraycopy(((Object) (workStack)), 0, ((Object) (aobj)), 0, i);
            workStack = aobj;
            return;
        }
    }

    private NamespaceBinding mergeHelper(NamespaceBinding namespacebinding, NamespaceBinding namespacebinding1)
    {
        if (namespacebinding1 == NamespaceBinding.predefinedXML)
        {
            return namespacebinding;
        }
        Object obj = mergeHelper(namespacebinding, namespacebinding1.next);
        String s = namespacebinding1.uri;
        namespacebinding = ((NamespaceBinding) (obj));
        if (obj == null)
        {
            if (s == null)
            {
                return ((NamespaceBinding) (obj));
            }
            namespacebinding = NamespaceBinding.predefinedXML;
        }
        namespacebinding1 = namespacebinding1.prefix;
        obj = namespacebinding.resolve(namespacebinding1);
        if (obj != null ? ((String) (obj)).equals(s) : s == null)
        {
            return namespacebinding;
        } else
        {
            return findNamespaceBinding(namespacebinding1, s, namespacebinding);
        }
    }

    private String resolve(String s, boolean flag)
    {
        String s1;
        if (flag && s == null)
        {
            s1 = "";
        } else
        {
            String s2 = namespaceBindings.resolve(s);
            s1 = s2;
            if (s2 == null)
            {
                if (s != null)
                {
                    error('e', (new StringBuilder()).append("unknown namespace prefix '").append(s).append('\'').toString());
                }
                return "";
            }
        }
        return s1;
    }

    private boolean startAttributeCommon()
    {
        if (stringizingElementNesting >= 0)
        {
            ignoringLevel = ignoringLevel + 1;
        }
        int i = stringizingLevel;
        stringizingLevel = i + 1;
        if (i > 0)
        {
            return false;
        }
        if (attrCount < 0)
        {
            attrCount = 0;
        }
        ensureSpaceInWorkStack(nesting + attrCount);
        ensureSpaceInStartIndexes(attrCount);
        startIndexes[attrCount] = tlist.gapStart;
        attrCount = attrCount + 1;
        return true;
    }

    public volatile Consumer append(char c)
    {
        return append(c);
    }

    public volatile Consumer append(CharSequence charsequence)
    {
        return append(charsequence);
    }

    public volatile Consumer append(CharSequence charsequence, int i, int j)
    {
        return append(charsequence, i, j);
    }

    public XMLFilter append(char c)
    {
        write(c);
        return this;
    }

    public XMLFilter append(CharSequence charsequence)
    {
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        append(((CharSequence) (obj)), 0, ((CharSequence) (obj)).length());
        return this;
    }

    public XMLFilter append(CharSequence charsequence, int i, int j)
    {
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        write(((CharSequence) (obj)), i, j - i);
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
        if (base instanceof XConsumer)
        {
            ((XConsumer)base).beginEntity(obj);
        }
    }

    public void characters(char ac[], int i, int j)
        throws SAXException
    {
        write(ac, i, j);
    }

    protected void checkValidComment(char ac[], int i, int j)
    {
        int k = 1;
        do
        {
            int l;
label0:
            {
                l = j - 1;
                if (l >= 0)
                {
                    if (ac[i + l] == '-')
                    {
                        j = 1;
                    } else
                    {
                        j = 0;
                    }
                    if (k == 0 || j == 0)
                    {
                        break label0;
                    }
                    error('e', "consecutive or final hyphen in XML comment");
                }
                return;
            }
            k = j;
            j = l;
        } while (true);
    }

    protected boolean checkWriteAtomic()
    {
        previous = 0;
        if (ignoringLevel > 0)
        {
            return false;
        } else
        {
            closeStartTag();
            return true;
        }
    }

    void closeStartTag()
    {
        Object obj;
        Object obj1;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj9;
        int i;
        if (attrCount < 0 || stringizingLevel > 0)
        {
            return;
        }
        inStartTag = false;
        previous = 0;
        if (attrLocalName != null)
        {
            endAttribute();
        }
        if (nesting == 0)
        {
            obj5 = NamespaceBinding.predefinedXML;
        } else
        {
            obj5 = (NamespaceBinding)workStack[nesting - 2];
        }
        obj = namespaceBindings;
        i = 0;
        if (i > attrCount) goto _L2; else goto _L1
_L1:
        obj4 = workStack[(nesting + i) - 1];
        obj1 = obj;
        if (!(obj4 instanceof Symbol)) goto _L4; else goto _L3
_L3:
        obj9 = (Symbol)obj4;
        obj1 = ((Symbol) (obj9)).getPrefix();
        obj6 = obj1;
        if (obj1 == "")
        {
            obj6 = null;
        }
        obj1 = ((Symbol) (obj9)).getNamespaceURI();
        obj4 = obj1;
        if (obj1 == "")
        {
            obj4 = null;
        }
        if (i <= 0 || obj6 != null || obj4 != null) goto _L6; else goto _L5
_L5:
        obj1 = obj;
_L4:
        i++;
        obj = obj1;
        break MISSING_BLOCK_LABEL_56;
_L6:
        Object obj7;
        int l;
        l = 0;
        obj7 = obj;
_L15:
label0:
        {
            if (obj7 == obj5)
            {
                l = 1;
            }
            if (obj7 != null)
            {
                break label0;
            }
            if (obj6 == null)
            {
                obj1 = obj;
                if (obj4 == null)
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            obj1 = findNamespaceBinding(((String) (obj6)), ((String) (obj4)), ((NamespaceBinding) (obj)));
        }
        continue; /* Loop/switch isn't completed */
        if (((NamespaceBinding) (obj7)).prefix != obj6)
        {
            break MISSING_BLOCK_LABEL_401;
        }
        obj1 = obj;
        if (((NamespaceBinding) (obj7)).uri != obj4)
        {
label1:
            {
                if (!l)
                {
                    break label1;
                }
                obj1 = findNamespaceBinding(((String) (obj6)), ((String) (obj4)), ((NamespaceBinding) (obj)));
            }
        }
        continue; /* Loop/switch isn't completed */
        obj6 = obj;
_L14:
        if (obj6 != null) goto _L8; else goto _L7
_L7:
        l = 1;
_L11:
        obj1 = (new StringBuilder()).append("_ns_").append(l).toString().intern();
        if (((NamespaceBinding) (obj)).resolve(((String) (obj1))) != null) goto _L10; else goto _L9
_L9:
        obj6 = findNamespaceBinding(((String) (obj1)), ((String) (obj4)), ((NamespaceBinding) (obj)));
        obj7 = ((Symbol) (obj9)).getLocalName();
        obj = obj4;
        if (obj4 == null)
        {
            obj = "";
        }
        workStack[(nesting + i) - 1] = Symbol.make(((String) (obj)), ((String) (obj7)), ((String) (obj1)));
        obj1 = obj6;
        continue; /* Loop/switch isn't completed */
_L10:
        l++;
          goto _L11
_L8:
        if (((NamespaceBinding) (obj6)).uri != obj4)
        {
            break; /* Loop/switch isn't completed */
        }
        obj7 = ((NamespaceBinding) (obj6)).prefix;
        obj1 = obj7;
        if (((NamespaceBinding) (obj)).resolve(((String) (obj7))) == obj4) goto _L9; else goto _L12
_L12:
        obj6 = ((NamespaceBinding) (obj6)).next;
        if (true) goto _L14; else goto _L13
_L13:
        obj7 = ((NamespaceBinding) (obj7)).next;
        if (true) goto _L15; else goto _L2
_L2:
        l = 0;
_L36:
        int i1;
        if (l > attrCount)
        {
            break MISSING_BLOCK_LABEL_1363;
        }
        obj9 = workStack[(nesting + l) - 1];
        i1 = 0;
        i = 0;
        if (!(obj9 instanceof MappingInfo) && out != tlist) goto _L17; else goto _L16
_L16:
        if (obj9 instanceof MappingInfo)
        {
            obj6 = (MappingInfo)obj9;
            obj5 = ((MappingInfo) (obj6)).prefix;
            obj4 = ((MappingInfo) (obj6)).local;
            Object obj8;
            Object obj10;
            int l1;
            if (l > 0 && (obj5 == null && obj4 == "xmlns" || obj5 == "xmlns"))
            {
                i = 1;
                obj1 = "(namespace-node)";
            } else
            {
                boolean flag;
                if (l > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj1 = resolve(((String) (obj5)), flag);
            }
        } else
        {
            obj1 = (Symbol)obj9;
            obj6 = lookupTag(((Symbol) (obj1)));
            obj5 = ((MappingInfo) (obj6)).prefix;
            obj4 = ((MappingInfo) (obj6)).local;
            obj1 = ((Symbol) (obj1)).getNamespaceURI();
        }
        i1 = ((MappingInfo) (obj6)).tagHash;
        l1 = i1 & mappingTableMask;
        obj6 = mappingTable[l1];
_L29:
        if (obj6 != null) goto _L19; else goto _L18
_L18:
        obj6 = new MappingInfo();
        obj6.tagHash = i1;
        obj6.prefix = ((String) (obj5));
        obj6.local = ((String) (obj4));
        obj6.nextInBucket = mappingTable[l1];
        mappingTable[l1] = ((MappingInfo) (obj6));
        obj6.uri = ((String) (obj1));
        obj6.qname = Symbol.make(((String) (obj1)), ((String) (obj4)), ((String) (obj5)));
        obj5 = obj6;
        if (l == 0)
        {
            obj6.type = new XName(((MappingInfo) (obj6)).qname, ((NamespaceBinding) (obj)));
            obj6.namespaces = ((NamespaceBinding) (obj));
            obj5 = obj6;
        }
_L28:
        workStack[(nesting + l) - 1] = obj5;
_L31:
        i1 = 1;
_L22:
        if (i1 >= l)
        {
            break MISSING_BLOCK_LABEL_1078;
        }
        obj6 = workStack[(nesting + i1) - 1];
        if (!(obj6 instanceof Symbol)) goto _L21; else goto _L20
_L20:
        obj6 = (Symbol)obj6;
_L34:
        if (obj4 == ((Symbol) (obj6)).getLocalPart() && obj1 == ((Symbol) (obj6)).getNamespaceURI())
        {
            obj10 = workStack[nesting - 1];
            obj8 = obj10;
            if (obj10 instanceof MappingInfo)
            {
                obj8 = ((MappingInfo)obj10).qname;
            }
            error('e', duplicateAttributeMessage(((Symbol) (obj6)), obj8));
        }
_L33:
        i1++;
          goto _L22
_L19:
        if (((MappingInfo) (obj6)).tagHash != i1 || ((MappingInfo) (obj6)).local != obj4 || ((MappingInfo) (obj6)).prefix != obj5) goto _L24; else goto _L23
_L23:
        if (((MappingInfo) (obj6)).uri != null) goto _L26; else goto _L25
_L25:
        obj6.uri = ((String) (obj1));
        obj6.qname = Symbol.make(((String) (obj1)), ((String) (obj4)), ((String) (obj5)));
_L30:
        if (l != 0)
        {
            break MISSING_BLOCK_LABEL_1017;
        }
        if (((MappingInfo) (obj6)).namespaces != obj && ((MappingInfo) (obj6)).namespaces != null) goto _L24; else goto _L27
_L27:
        XName xname = ((MappingInfo) (obj6)).type;
        obj6.namespaces = ((NamespaceBinding) (obj));
        obj5 = obj6;
        if (xname == null)
        {
            obj6.type = new XName(((MappingInfo) (obj6)).qname, ((NamespaceBinding) (obj)));
            obj5 = obj6;
        }
          goto _L28
_L26:
        if (((MappingInfo) (obj6)).uri == obj1)
        {
            break MISSING_BLOCK_LABEL_994;
        }
_L24:
        obj6 = ((MappingInfo) (obj6)).nextInBucket;
          goto _L29
        if (((MappingInfo) (obj6)).qname == null)
        {
            obj6.qname = Symbol.make(((String) (obj1)), ((String) (obj4)), ((String) (obj5)));
        }
          goto _L30
        obj5 = ((MappingInfo) (obj6)).qname;
        obj5 = obj6;
          goto _L28
_L17:
        obj4 = (Symbol)obj9;
        obj1 = ((Symbol) (obj4)).getNamespaceURI();
        obj4 = ((Symbol) (obj4)).getLocalName();
        obj5 = null;
        i = i1;
          goto _L31
_L21:
        if (!(obj6 instanceof MappingInfo)) goto _L33; else goto _L32
_L32:
        obj6 = ((MappingInfo)obj6).qname;
          goto _L34
        int j1;
label2:
        {
            if (out != tlist)
            {
                break; /* Loop/switch isn't completed */
            }
            Object obj2;
            int i2;
            if (l == 0)
            {
                obj2 = ((MappingInfo) (obj5)).type;
            } else
            {
                obj2 = ((MappingInfo) (obj5)).qname;
            }
            i2 = ((MappingInfo) (obj5)).index;
            if (i2 > 0)
            {
                j1 = i2;
                if (tlist.objects[i2] == obj2)
                {
                    break label2;
                }
            }
            j1 = tlist.find(obj2);
            obj5.index = j1;
        }
        if (l == 0)
        {
            tlist.setElementName(tlist.gapEnd, j1);
        } else
        if (i == 0 || namespacePrefixes)
        {
            tlist.setAttributeName(startIndexes[l - 1], j1);
        }
_L37:
        l++;
        if (true) goto _L36; else goto _L35
_L35:
        Object obj3;
        if (obj5 == null)
        {
            obj3 = obj9;
        } else
        if (l == 0)
        {
            obj3 = ((MappingInfo) (obj5)).type;
        } else
        {
            obj3 = ((MappingInfo) (obj5)).qname;
        }
        if (l == 0)
        {
            out.startElement(obj3);
        } else
        if (i == 0 || namespacePrefixes)
        {
            out.startAttribute(obj3);
            int k1 = startIndexes[l - 1];
            int j;
            if (l < attrCount)
            {
                j = startIndexes[l];
            } else
            {
                j = tlist.gapStart;
            }
            tlist.consumeIRange(k1 + 5, j - 1, out);
            out.endAttribute();
        }
          goto _L37
        if (true) goto _L36; else goto _L38
_L38:
        if (out instanceof ContentConsumer)
        {
            ((ContentConsumer)out).endStartTag();
        }
        for (int k = 1; k <= attrCount; k++)
        {
            workStack[(nesting + k) - 1] = null;
        }

        if (out != tlist)
        {
            base = out;
            tlist.clear();
        }
        attrCount = -1;
        return;
        if (true) goto _L4; else goto _L39
_L39:
    }

    public void commentFromParser(char ac[], int i, int j)
    {
        if (stringizingLevel == 0)
        {
            closeStartTag();
            if (base instanceof XConsumer)
            {
                ((XConsumer)base).writeComment(ac, i, j);
            }
        } else
        if (stringizingElementNesting < 0)
        {
            base.write(ac, i, j);
            return;
        }
    }

    public void consume(SeqPosition seqposition)
    {
        writePosition(seqposition.sequence, seqposition.ipos);
    }

    public void emitCharacterReference(int i, char ac[], int j, int k)
    {
        if (i >= 0x10000)
        {
            Char.print(i, this);
            return;
        } else
        {
            write(i);
            return;
        }
    }

    public void emitDoctypeDecl(char ac[], int i, int j, int k, int l)
    {
    }

    public void emitEndAttributes()
    {
        if (attrLocalName != null)
        {
            endAttribute();
        }
        closeStartTag();
    }

    public void emitEndElement(char ac[], int i, int j)
    {
        if (attrLocalName != null)
        {
            error('e', "unclosed attribute");
            endAttribute();
        }
        if (!inElement())
        {
            error('e', "unmatched end element");
        } else
        {
            if (ac != null)
            {
                MappingInfo mappinginfo = lookupTag(ac, i, j);
                Object obj = workStack[nesting - 1];
                if ((obj instanceof MappingInfo) && !mismatchReported)
                {
                    obj = (MappingInfo)obj;
                    if (mappinginfo.local != ((MappingInfo) (obj)).local || mappinginfo.prefix != ((MappingInfo) (obj)).prefix)
                    {
                        StringBuffer stringbuffer = new StringBuffer("</");
                        stringbuffer.append(ac, i, j);
                        stringbuffer.append("> matching <");
                        ac = ((MappingInfo) (obj)).prefix;
                        if (ac != null)
                        {
                            stringbuffer.append(ac);
                            stringbuffer.append(':');
                        }
                        stringbuffer.append(((MappingInfo) (obj)).local);
                        stringbuffer.append('>');
                        error('e', stringbuffer.toString());
                        mismatchReported = true;
                    }
                }
            }
            closeStartTag();
            if (nesting > 0)
            {
                endElement();
                return;
            }
        }
    }

    public void emitEntityReference(char ac[], int i, int j)
    {
        byte byte1;
        char c;
        c = ac[i];
        byte1 = 63;
        if (j != 2 || ac[i + 1] != 't') goto _L2; else goto _L1
_L1:
        if (c != 'l') goto _L4; else goto _L3
_L3:
        byte byte0 = 60;
_L6:
        write(byte0);
        return;
_L4:
        byte0 = byte1;
        if (c == 'g')
        {
            byte0 = 62;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (j == 3)
        {
            byte0 = byte1;
            if (c == 'a')
            {
                byte0 = byte1;
                if (ac[i + 1] == 'm')
                {
                    byte0 = byte1;
                    if (ac[i + 2] == 'p')
                    {
                        byte0 = 38;
                    }
                }
            }
        } else
        {
            byte0 = byte1;
            if (j == 4)
            {
                j = ac[i + 1];
                char c1 = ac[i + 2];
                i = ac[i + 3];
                if (c == 'q' && j == 117 && c1 == 'o' && i == 116)
                {
                    byte0 = 34;
                } else
                {
                    byte0 = byte1;
                    if (c == 'a')
                    {
                        byte0 = byte1;
                        if (j == 112)
                        {
                            byte0 = byte1;
                            if (c1 == 'o')
                            {
                                byte0 = byte1;
                                if (i == 115)
                                {
                                    byte0 = 39;
                                }
                            }
                        }
                    }
                }
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void emitStartAttribute(char ac[], int i, int j)
    {
        if (attrLocalName != null)
        {
            endAttribute();
        }
        if (startAttributeCommon())
        {
            Object obj = lookupTag(ac, i, j);
            workStack[(nesting + attrCount) - 1] = obj;
            ac = ((MappingInfo) (obj)).prefix;
            obj = ((MappingInfo) (obj)).local;
            attrLocalName = ((String) (obj));
            attrPrefix = ac;
            if (ac != null)
            {
                if (ac == "xmlns")
                {
                    currentNamespacePrefix = ((String) (obj));
                }
            } else
            if (obj == "xmlns" && ac == null)
            {
                currentNamespacePrefix = "";
            }
            if (currentNamespacePrefix == null || namespacePrefixes)
            {
                tlist.startAttribute(0);
                return;
            }
        }
    }

    public void emitStartElement(char ac[], int i, int j)
    {
        closeStartTag();
        ac = lookupTag(ac, i, j);
        startElementCommon();
        ensureSpaceInWorkStack(nesting - 1);
        workStack[nesting - 1] = ac;
    }

    public void endAttribute()
    {
        if (attrLocalName != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i;
        if (previous == 1)
        {
            previous = 0;
            return;
        }
        if (stringizingElementNesting >= 0)
        {
            ignoringLevel = ignoringLevel - 1;
        }
        i = stringizingLevel - 1;
        stringizingLevel = i;
        if (i != 0) goto _L1; else goto _L3
_L3:
        if (attrLocalName != "id" || attrPrefix != "xml") goto _L5; else goto _L4
_L4:
        char ac[];
        int j;
        int l;
        j = startIndexes[attrCount - 1] + 5;
        l = tlist.gapStart;
        ac = tlist.data;
        i = j;
_L7:
        char ac1[];
        int k;
        int k1;
        int l1;
        int i2;
        if (i < l)
        {
label0:
            {
                k = i + 1;
                i = ac[i];
                if ((0xffff & i) <= 40959 && i != '\t' && i != '\r' && i != '\n' && (i != ' ' || k != l && ac[k] != ' '))
                {
                    break label0;
                }
                StringBuffer stringbuffer = new StringBuffer();
                tlist.stringValue(j, l, stringbuffer);
                tlist.gapStart = j;
                tlist.write(TextUtils.replaceWhitespace(stringbuffer.toString(), true));
            }
        }
_L5:
        attrLocalName = null;
        attrPrefix = null;
        if (currentNamespacePrefix == null || namespacePrefixes)
        {
            tlist.endAttribute();
        }
        if (currentNamespacePrefix == null) goto _L1; else goto _L6
_L6:
        k1 = startIndexes[attrCount - 1];
        i = k1;
        i2 = tlist.gapStart;
        l1 = i2 - i;
        ac1 = tlist.data;
        j = 0;
        k = i;
_L8:
        ac = ac1;
        int j1 = i;
        int i1 = l1;
        l = j;
        if (k < i2)
        {
            l = ac1[k];
            if ((0xffff & l) <= 40959)
            {
                break MISSING_BLOCK_LABEL_449;
            }
            StringBuffer stringbuffer1 = new StringBuffer();
            tlist.stringValue(i, i2, stringbuffer1);
            l = stringbuffer1.hashCode();
            j1 = 0;
            i1 = stringbuffer1.length();
            ac = new char[stringbuffer1.length()];
            stringbuffer1.getChars(0, i1, ac, 0);
        }
        tlist.gapStart = k1;
        String s;
        if (currentNamespacePrefix == "")
        {
            s = null;
        } else
        {
            s = currentNamespacePrefix;
        }
        namespaceBindings = lookupNamespaceBinding(s, ac, j1, i1, l, namespaceBindings).namespaces;
        currentNamespacePrefix = null;
        return;
        i = k;
          goto _L7
        j = j * 31 + l;
        k++;
          goto _L8
    }

    public void endDocument()
    {
        if (stringizingLevel > 0)
        {
            writeJoiner();
            return;
        }
        nesting = nesting - 2;
        namespaceBindings = (NamespaceBinding)workStack[nesting];
        workStack[nesting] = null;
        workStack[nesting + 1] = null;
        if (nesting == 0)
        {
            base.endDocument();
            return;
        } else
        {
            writeJoiner();
            return;
        }
    }

    public void endElement()
    {
        closeStartTag();
        nesting = nesting - 2;
        previous = 0;
        if (stringizingLevel == 0)
        {
            namespaceBindings = (NamespaceBinding)workStack[nesting];
            workStack[nesting] = null;
            workStack[nesting + 1] = null;
            base.endElement();
        } else
        if (stringizingElementNesting == nesting)
        {
            stringizingElementNesting = -1;
            previous = 2;
            return;
        }
    }

    public void endElement(String s)
        throws SAXException
    {
        endElement();
    }

    public void endElement(String s, String s1, String s2)
    {
        endElement();
    }

    public void endEntity()
    {
        if (base instanceof XConsumer)
        {
            ((XConsumer)base).endEntity();
        }
    }

    public void endPrefixMapping(String s)
    {
        namespaceBindings = namespaceBindings.getNext();
    }

    public void error(char c, String s)
    {
        if (messages == null)
        {
            throw new RuntimeException(s);
        }
        if (locator != null)
        {
            messages.error(c, locator, s);
            return;
        } else
        {
            messages.error(c, s);
            return;
        }
    }

    public NamespaceBinding findNamespaceBinding(String s, String s1, NamespaceBinding namespacebinding)
    {
        Object obj;
        int i;
        int j;
        if (s1 == null)
        {
            i = 0;
        } else
        {
            i = s1.hashCode();
        }
        j = i;
        if (s != null)
        {
            j = i ^ s.hashCode();
        }
        i = j & mappingTableMask;
        obj = mappingTable[i];
        do
        {
            if (obj == null)
            {
                MappingInfo mappinginfo = new MappingInfo();
                mappinginfo.nextInBucket = mappingTable[i];
                mappingTable[i] = mappinginfo;
                mappinginfo.tagHash = j;
                mappinginfo.prefix = s;
                mappinginfo.local = s1;
                mappinginfo.uri = s1;
                obj = s1;
                if (s1 == "")
                {
                    obj = null;
                }
                mappinginfo.namespaces = new NamespaceBinding(s, ((String) (obj)), namespacebinding);
                return mappinginfo.namespaces;
            }
            if (((MappingInfo) (obj)).tagHash == j && ((MappingInfo) (obj)).prefix == s)
            {
                NamespaceBinding namespacebinding1 = ((MappingInfo) (obj)).namespaces;
                if (namespacebinding1 != null && namespacebinding1.getNext() == namespaceBindings && namespacebinding1.getPrefix() == s && ((MappingInfo) (obj)).uri == s1)
                {
                    return ((MappingInfo) (obj)).namespaces;
                }
            }
            obj = ((MappingInfo) (obj)).nextInBucket;
        } while (true);
    }

    public int getColumnNumber()
    {
        if (in != null)
        {
            int i = in.getColumnNumber();
            if (i > 0)
            {
                return i;
            }
        }
        return -1;
    }

    public String getFileName()
    {
        if (in == null)
        {
            return null;
        } else
        {
            return in.getName();
        }
    }

    public int getLineNumber()
    {
        int i;
        if (in != null)
        {
            if ((i = in.getLineNumber()) >= 0)
            {
                return i + 1;
            }
        }
        return -1;
    }

    public String getPublicId()
    {
        return null;
    }

    public String getSystemId()
    {
        if (in == null)
        {
            return null;
        } else
        {
            return in.getName();
        }
    }

    public void ignorableWhitespace(char ac[], int i, int j)
        throws SAXException
    {
        write(ac, i, j);
    }

    public boolean ignoring()
    {
        return ignoringLevel > 0;
    }

    final boolean inElement()
    {
        int i;
        for (i = nesting; i > 0 && workStack[i - 1] == null; i -= 2) { }
        return i != 0;
    }

    public boolean isStableSourceLocation()
    {
        return false;
    }

    public void linefeedFromParser()
    {
        if (inElement() && checkWriteAtomic())
        {
            base.write(10);
        }
    }

    public MappingInfo lookupNamespaceBinding(String s, char ac[], int i, int j, int k, NamespaceBinding namespacebinding)
    {
        Object obj;
        int l;
        if (s != null)
        {
            k = s.hashCode() ^ k;
        }
        l = k & mappingTableMask;
        obj = mappingTable[l];
        do
        {
            if (obj == null)
            {
                MappingInfo mappinginfo = new MappingInfo();
                mappinginfo.nextInBucket = mappingTable[l];
                mappingTable[l] = mappinginfo;
                obj = (new String(ac, i, j)).intern();
                mappinginfo.tagHash = k;
                mappinginfo.prefix = s;
                mappinginfo.local = ((String) (obj));
                mappinginfo.uri = ((String) (obj));
                ac = ((char []) (obj));
                if (obj == "")
                {
                    ac = null;
                }
                mappinginfo.namespaces = new NamespaceBinding(s, ac, namespacebinding);
                return mappinginfo;
            }
            if (((MappingInfo) (obj)).tagHash == k && ((MappingInfo) (obj)).prefix == s)
            {
                NamespaceBinding namespacebinding1 = ((MappingInfo) (obj)).namespaces;
                if (namespacebinding1 != null && namespacebinding1.getNext() == namespaceBindings && namespacebinding1.getPrefix() == s && MappingInfo.equals(((MappingInfo) (obj)).uri, ac, i, j))
                {
                    return ((MappingInfo) (obj));
                }
            }
            obj = ((MappingInfo) (obj)).nextInBucket;
        } while (true);
    }

    MappingInfo lookupTag(Symbol symbol)
    {
        String s1 = symbol.getLocalPart();
        Object obj = symbol.getPrefix();
        String s = ((String) (obj));
        if (obj == "")
        {
            s = null;
        }
        String s2 = symbol.getNamespaceURI();
        int i = MappingInfo.hash(s, s1);
        int j = i & mappingTableMask;
        MappingInfo mappinginfo = mappingTable[j];
        obj = mappinginfo;
        do
        {
            if (obj == null)
            {
                obj = new MappingInfo();
                obj.qname = symbol;
                obj.prefix = s;
                obj.uri = s2;
                obj.local = s1;
                obj.tagHash = i;
                obj.nextInBucket = mappinginfo;
                mappingTable[j] = mappinginfo;
                return ((MappingInfo) (obj));
            }
            if (symbol == ((MappingInfo) (obj)).qname)
            {
                return ((MappingInfo) (obj));
            }
            if (s1 == ((MappingInfo) (obj)).local && ((MappingInfo) (obj)).qname == null && (s2 == ((MappingInfo) (obj)).uri || ((MappingInfo) (obj)).uri == null) && s == ((MappingInfo) (obj)).prefix)
            {
                obj.uri = s2;
                obj.qname = symbol;
                return ((MappingInfo) (obj));
            }
            obj = ((MappingInfo) (obj)).nextInBucket;
        } while (true);
    }

    MappingInfo lookupTag(char ac[], int i, int j)
    {
        int l = 0;
        int j1 = 0;
        int i1 = -1;
        int k = 0;
        while (k < j) 
        {
            char c = ac[i + k];
            if (c == ':' && i1 < 0)
            {
                i1 = k;
                c = '\0';
                j1 = l;
                l = c;
            } else
            {
                l = l * 31 + c;
            }
            k++;
        }
        l ^= j1;
        k = l & mappingTableMask;
        MappingInfo mappinginfo1 = mappingTable[k];
        MappingInfo mappinginfo = mappinginfo1;
        do
        {
            if (mappinginfo == null)
            {
                mappinginfo = new MappingInfo();
                mappinginfo.tagHash = l;
                if (i1 >= 0)
                {
                    mappinginfo.prefix = (new String(ac, i, i1)).intern();
                    l = i1 + 1;
                    mappinginfo.local = (new String(ac, i + l, j - l)).intern();
                } else
                {
                    mappinginfo.prefix = null;
                    mappinginfo.local = (new String(ac, i, j)).intern();
                }
                mappinginfo.nextInBucket = mappinginfo1;
                mappingTable[k] = mappinginfo1;
                return mappinginfo;
            }
            if (l == mappinginfo.tagHash && mappinginfo.match(ac, i, j))
            {
                return mappinginfo;
            }
            mappinginfo = mappinginfo.nextInBucket;
        } while (true);
    }

    public void processingInstruction(String s, String s1)
    {
        s1 = s1.toCharArray();
        processingInstructionCommon(s, s1, 0, s1.length);
    }

    void processingInstructionCommon(String s, char ac[], int i, int j)
    {
        if (stringizingLevel == 0)
        {
            closeStartTag();
            if (base instanceof XConsumer)
            {
                ((XConsumer)base).writeProcessingInstruction(s, ac, i, j);
            }
        } else
        if (stringizingElementNesting < 0)
        {
            base.write(ac, i, j);
            return;
        }
    }

    public void processingInstructionFromParser(char ac[], int i, int j, int k, int l)
    {
        if (j == 3 && !inElement() && ac[i] == 'x' && ac[i + 1] == 'm' && ac[i + 2] == 'l')
        {
            return;
        } else
        {
            processingInstructionCommon(new String(ac, i, j), ac, k, l);
            return;
        }
    }

    public void setDocumentLocator(Locator locator1)
    {
        if (locator1 instanceof SourceLocator)
        {
            locator = (SourceLocator)locator1;
        }
    }

    public void setMessages(SourceMessages sourcemessages)
    {
        messages = sourcemessages;
    }

    public void setSourceLocator(LineBufferedReader linebufferedreader)
    {
        in = linebufferedreader;
        locator = this;
    }

    public void setSourceLocator(SourceLocator sourcelocator)
    {
        locator = sourcelocator;
    }

    public void skippedEntity(String s)
    {
    }

    public void startAttribute(Object obj)
    {
        previous = 0;
        if (obj instanceof Symbol)
        {
            Object obj1 = (Symbol)obj;
            String s = ((Symbol) (obj1)).getLocalPart();
            attrLocalName = s;
            attrPrefix = ((Symbol) (obj1)).getPrefix();
            obj1 = ((Symbol) (obj1)).getNamespaceURI();
            if (obj1 == "http://www.w3.org/2000/xmlns/" || obj1 == "" && s == "xmlns")
            {
                error('e', "arttribute name cannot be 'xmlns' or in xmlns namespace");
            }
        }
        if (nesting == 2 && workStack[1] == null)
        {
            error('e', "attribute not allowed at document level");
        }
        if (attrCount < 0 && nesting > 0)
        {
            error('e', (new StringBuilder()).append("attribute '").append(obj).append("' follows non-attribute content").toString());
        }
        if (!startAttributeCommon())
        {
            return;
        }
        workStack[(nesting + attrCount) - 1] = obj;
        if (nesting == 0)
        {
            base.startAttribute(obj);
            return;
        } else
        {
            tlist.startAttribute(0);
            return;
        }
    }

    public void startDocument()
    {
        closeStartTag();
        if (stringizingLevel > 0)
        {
            writeJoiner();
            return;
        }
        if (nesting == 0)
        {
            base.startDocument();
        } else
        {
            writeJoiner();
        }
        ensureSpaceInWorkStack(nesting);
        workStack[nesting] = namespaceBindings;
        workStack[nesting + 1] = null;
        nesting = nesting + 2;
    }

    public void startElement(Object obj)
    {
        int i;
label0:
        {
            startElementCommon();
            if (stringizingLevel == 0)
            {
                ensureSpaceInWorkStack(nesting - 1);
                workStack[nesting - 1] = obj;
                if (copyNamespacesMode != 0)
                {
                    break label0;
                }
                namespaceBindings = NamespaceBinding.predefinedXML;
            }
            return;
        }
        if (copyNamespacesMode == 1 || nesting == 2)
        {
            if (obj instanceof XName)
            {
                obj = ((XName)obj).getNamespaceNodes();
            } else
            {
                obj = NamespaceBinding.predefinedXML;
            }
            namespaceBindings = ((NamespaceBinding) (obj));
            return;
        }
        i = 2;
_L2:
        NamespaceBinding namespacebinding;
        if (i == nesting)
        {
            namespacebinding = null;
        } else
        {
label1:
            {
                if (workStack[i + 1] == null)
                {
                    break label1;
                }
                namespacebinding = (NamespaceBinding)workStack[i];
            }
        }
        if (namespacebinding == null)
        {
            if (obj instanceof XName)
            {
                obj = ((XName)obj).getNamespaceNodes();
            } else
            {
                obj = NamespaceBinding.predefinedXML;
            }
            namespaceBindings = ((NamespaceBinding) (obj));
            return;
        }
        break; /* Loop/switch isn't completed */
        i += 2;
        if (true) goto _L2; else goto _L1
_L1:
        if (copyNamespacesMode == 2)
        {
            namespaceBindings = namespacebinding;
            return;
        }
        if (obj instanceof XName)
        {
            obj = ((XName)obj).getNamespaceNodes();
            if (NamespaceBinding.commonAncestor(namespacebinding, ((NamespaceBinding) (obj))) == namespacebinding)
            {
                namespaceBindings = ((NamespaceBinding) (obj));
                return;
            } else
            {
                namespaceBindings = mergeHelper(namespacebinding, ((NamespaceBinding) (obj)));
                return;
            }
        } else
        {
            namespaceBindings = namespacebinding;
            return;
        }
    }

    public void startElement(String s, String s1, String s2, Attributes attributes)
    {
        startElement(Symbol.make(s, s1));
        int j = attributes.getLength();
        for (int i = 0; i < j; i++)
        {
            startAttribute(Symbol.make(attributes.getURI(i), attributes.getLocalName(i)));
            write(attributes.getValue(i));
            endAttribute();
        }

    }

    public void startElement(String s, AttributeList attributelist)
    {
        startElement(s.intern());
        int j = attributelist.getLength();
        for (int i = 0; i < j; i++)
        {
            s = attributelist.getName(i).intern();
            attributelist.getType(i);
            String s1 = attributelist.getValue(i);
            startAttribute(s);
            write(s1);
            endAttribute();
        }

    }

    protected void startElementCommon()
    {
        closeStartTag();
        if (stringizingLevel != 0) goto _L2; else goto _L1
_L1:
        ensureSpaceInWorkStack(nesting);
        workStack[nesting] = namespaceBindings;
        tlist.startElement(0);
        base = tlist;
        attrCount = 0;
_L4:
        nesting = nesting + 2;
        return;
_L2:
        if (previous == 2 && stringizingElementNesting < 0)
        {
            write(32);
        }
        previous = 0;
        if (stringizingElementNesting < 0)
        {
            stringizingElementNesting = nesting;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void startPrefixMapping(String s, String s1)
    {
        namespaceBindings = findNamespaceBinding(s.intern(), s1.intern(), namespaceBindings);
    }

    public void textFromParser(char ac[], int i, int j)
    {
        if (inElement()) goto _L2; else goto _L1
_L1:
        int k = 0;
_L7:
        if (k != j) goto _L4; else goto _L3
_L3:
        return;
_L4:
        if (!Character.isWhitespace(ac[i + k]))
        {
            error('e', "text at document level");
            return;
        }
        k++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (j <= 0 || !checkWriteAtomic()) goto _L3; else goto _L5
_L5:
        base.write(ac, i, j);
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void write(int i)
    {
        if (checkWriteAtomic())
        {
            base.write(i);
        }
    }

    public void write(CharSequence charsequence, int i, int j)
    {
        if (j == 0)
        {
            writeJoiner();
        } else
        if (checkWriteAtomic())
        {
            base.write(charsequence, i, j);
            return;
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
        } else
        if (checkWriteAtomic())
        {
            base.write(ac, i, j);
            return;
        }
    }

    public void writeBoolean(boolean flag)
    {
        if (checkWriteAtomic())
        {
            base.writeBoolean(flag);
        }
    }

    public void writeCDATA(char ac[], int i, int j)
    {
label0:
        {
            if (checkWriteAtomic())
            {
                if (!(base instanceof XConsumer))
                {
                    break label0;
                }
                ((XConsumer)base).writeCDATA(ac, i, j);
            }
            return;
        }
        write(ac, i, j);
    }

    public void writeComment(char ac[], int i, int j)
    {
        checkValidComment(ac, i, j);
        commentFromParser(ac, i, j);
    }

    public void writeDocumentUri(Object obj)
    {
        if (nesting == 2 && (base instanceof TreeList))
        {
            ((TreeList)base).writeDocumentUri(obj);
        }
    }

    public void writeDouble(double d)
    {
        if (checkWriteAtomic())
        {
            base.writeDouble(d);
        }
    }

    public void writeFloat(float f)
    {
        if (checkWriteAtomic())
        {
            base.writeFloat(f);
        }
    }

    public void writeInt(int i)
    {
        if (checkWriteAtomic())
        {
            base.writeInt(i);
        }
    }

    protected void writeJoiner()
    {
        previous = 0;
        if (ignoringLevel == 0)
        {
            ((TreeList)base).writeJoiner();
        }
    }

    public void writeLong(long l)
    {
        if (checkWriteAtomic())
        {
            base.writeLong(l);
        }
    }

    public void writeObject(Object obj)
    {
        if (ignoringLevel <= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (obj instanceof SeqPosition)
        {
            obj = (SeqPosition)obj;
            writePosition(((SeqPosition) (obj)).sequence, ((SeqPosition) (obj)).getPos());
            return;
        }
        if (obj instanceof TreeList)
        {
            ((TreeList)obj).consume(this);
            return;
        }
        if (!(obj instanceof List) || (obj instanceof CharSeq))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((List)obj).iterator();
        int i = 0;
        while (((Iterator) (obj)).hasNext()) 
        {
            writeObject(((Iterator) (obj)).next());
            i++;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (obj instanceof Keyword)
        {
            startAttribute(((Keyword)obj).asSymbol());
            previous = 1;
            return;
        }
        closeStartTag();
        if (obj instanceof UnescapedData)
        {
            base.writeObject(obj);
            previous = 0;
            return;
        }
        if (previous == 2)
        {
            write(32);
        }
        TextUtils.textValue(obj, this);
        previous = 2;
        return;
    }

    public void writePosition(AbstractSequence abstractsequence, int i)
    {
        if (ignoringLevel <= 0)
        {
            if (stringizingLevel > 0 && previous == 2)
            {
                if (stringizingElementNesting < 0)
                {
                    write(32);
                }
                previous = 0;
            }
            abstractsequence.consumeNext(i, this);
            if (stringizingLevel > 0 && stringizingElementNesting < 0)
            {
                previous = 2;
                return;
            }
        }
    }

    public void writeProcessingInstruction(String s, char ac[], int i, int j)
    {
        s = TextUtils.replaceWhitespace(s, true);
        int l = i + j;
label0:
        do
        {
            int k = l - 1;
            if (k < i)
            {
                break;
            }
            char c = ac[k];
            int i1;
            do
            {
                l = k;
                if (c != '>')
                {
                    continue label0;
                }
                i1 = k - 1;
                l = i1;
                if (i1 < i)
                {
                    continue label0;
                }
                l = ac[i1];
                c = l;
                k = i1;
            } while (l != '?');
            error('e', "'?>' is not allowed in a processing-instruction");
            l = i1;
        } while (true);
        if ("xml".equalsIgnoreCase(s))
        {
            error('e', "processing-instruction target may not be 'xml' (ignoring case)");
        }
        if (!XName.isNCName(s))
        {
            error('e', (new StringBuilder()).append("processing-instruction target '").append(s).append("' is not a valid Name").toString());
        }
        processingInstructionCommon(s, ac, i, j);
    }
}
