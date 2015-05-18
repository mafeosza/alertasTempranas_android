// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.expr.Keyword;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.kawa.xml.XmlNamespace;
import gnu.lists.AbstractFormat;
import gnu.lists.Array;
import gnu.lists.CharSeq;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.ConsumerWriter;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.SimpleVector;
import gnu.lists.Strings;
import gnu.mapping.Namespace;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import gnu.mapping.Values;
import gnu.math.IntNum;
import gnu.math.RatNum;
import gnu.text.Char;
import gnu.text.Printable;
import gnu.xml.XMLPrinter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DisplayFormat extends AbstractFormat
{

    public static final ThreadLocation outBase;
    public static final ThreadLocation outRadix = new ThreadLocation("out-radix");
    static Pattern r5rsIdentifierMinusInteriorColons = Pattern.compile("(([a-zA-Z]|[!$%&*/:<=>?^_~])([a-zA-Z]|[!$%&*/<=>?^_~]|[0-9]|([-+.@]))*[:]?)|([-+]|[.][.][.])");
    char language;
    boolean readable;

    public DisplayFormat(boolean flag, char c)
    {
        readable = flag;
        language = c;
    }

    public static DisplayFormat getCommonLispFormat(boolean flag)
    {
        return new DisplayFormat(flag, 'C');
    }

    public static DisplayFormat getEmacsLispFormat(boolean flag)
    {
        return new DisplayFormat(flag, 'E');
    }

    public static DisplayFormat getSchemeFormat(boolean flag)
    {
        return new DisplayFormat(flag, 'S');
    }

    public boolean getReadableOutput()
    {
        return readable;
    }

    int write(Array array, int i, int j, Consumer consumer)
    {
        int i1 = array.rank();
        int l = 0;
        boolean flag = false;
        String s;
        if (j > 0)
        {
            s = "(";
        } else
        if (i1 == 1)
        {
            s = "#(";
        } else
        {
            s = (new StringBuilder()).append("#").append(i1).append("a(").toString();
        }
        if (consumer instanceof OutPort)
        {
            ((OutPort)consumer).startLogicalBlock(s, false, ")");
        } else
        {
            write(s, consumer);
        }
        if (i1 > 0)
        {
            int j1 = array.getSize(j);
            int k1 = j + 1;
            j = 0;
            int k = i;
            i = ((flag) ? 1 : 0);
            do
            {
                l = i;
                if (j >= j1)
                {
                    break;
                }
                if (j > 0)
                {
                    write(" ", consumer);
                    if (consumer instanceof OutPort)
                    {
                        ((OutPort)consumer).writeBreakFill();
                    }
                }
                if (k1 == i1)
                {
                    writeObject(array.getRowMajor(k), consumer);
                    l = 1;
                } else
                {
                    l = write(array, k, k1, consumer);
                }
                k += l;
                i += l;
                j++;
            } while (true);
        }
        if (consumer instanceof OutPort)
        {
            ((OutPort)consumer).endLogicalBlock(")");
            return l;
        } else
        {
            write(")", consumer);
            return l;
        }
    }

    public void write(int i, Consumer consumer)
    {
        if (!getReadableOutput())
        {
            Char.print(i, consumer);
            return;
        }
        if (language == 'E' && i > 32)
        {
            consumer.write(63);
            Char.print(i, consumer);
            return;
        } else
        {
            write(Char.toScmReadableString(i), consumer);
            return;
        }
    }

    public void writeBoolean(boolean flag, Consumer consumer)
    {
        String s;
        if (language == 'S')
        {
            if (flag)
            {
                s = "#t";
            } else
            {
                s = "#f";
            }
        } else
        if (flag)
        {
            s = "t";
        } else
        {
            s = "nil";
        }
        write(s, consumer);
    }

    public void writeList(LList llist, OutPort outport)
    {
        Object obj = llist;
        outport.startLogicalBlock("(", false, ")");
        for (; obj instanceof Pair; obj = ((Pair) (obj)).getCdr())
        {
            if (obj != llist)
            {
                outport.writeSpaceFill();
            }
            obj = (Pair)obj;
            writeObject(((Pair) (obj)).getCar(), outport);
        }

        if (obj != LList.Empty)
        {
            outport.writeSpaceFill();
            outport.write(". ");
            writeObject(LList.checkNonList(obj), outport);
        }
        outport.endLogicalBlock(")");
    }

    public void writeObject(Object obj, Consumer consumer)
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!(consumer instanceof OutPort))
            {
                break label0;
            }
            flag = flag1;
            if (obj instanceof UntypedAtomic)
            {
                break label0;
            }
            flag = flag1;
            if (obj instanceof Values)
            {
                break label0;
            }
            if (!getReadableOutput())
            {
                flag = flag1;
                if (obj instanceof Char)
                {
                    break label0;
                }
                flag = flag1;
                if (obj instanceof CharSequence)
                {
                    break label0;
                }
                flag = flag1;
                if (obj instanceof Character)
                {
                    break label0;
                }
            }
            ((OutPort)consumer).writeWordStart();
            flag = true;
        }
        writeObjectRaw(obj, consumer);
        if (flag)
        {
            ((OutPort)consumer).writeWordEnd();
        }
    }

    public void writeObjectRaw(Object obj, Consumer consumer)
    {
        if (!(obj instanceof Boolean)) goto _L2; else goto _L1
_L1:
        writeBoolean(((Boolean)obj).booleanValue(), consumer);
_L4:
        return;
_L2:
        if (obj instanceof Char)
        {
            write(((Char)obj).intValue(), consumer);
            return;
        }
        if (obj instanceof Character)
        {
            write(((Character)obj).charValue(), consumer);
            return;
        }
        if (obj instanceof Symbol)
        {
            obj = (Symbol)obj;
            if (((Symbol) (obj)).getNamespace() == XmlNamespace.HTML)
            {
                write("html:", consumer);
                write(((Symbol) (obj)).getLocalPart(), consumer);
                return;
            } else
            {
                writeSymbol(((Symbol) (obj)), consumer, readable);
                return;
            }
        }
        if ((obj instanceof URI) && getReadableOutput() && (consumer instanceof PrintWriter))
        {
            write("#,(URI ", consumer);
            Strings.printQuoted(obj.toString(), (PrintWriter)consumer, 1);
            consumer.write(41);
            return;
        }
        if (!(obj instanceof CharSequence))
        {
            break; /* Loop/switch isn't completed */
        }
        CharSequence charsequence = (CharSequence)obj;
        if (getReadableOutput() && (consumer instanceof PrintWriter))
        {
            Strings.printQuoted(charsequence, (PrintWriter)consumer, 1);
            return;
        }
        if (obj instanceof String)
        {
            consumer.write((String)obj);
            return;
        }
        if (obj instanceof CharSeq)
        {
            obj = (CharSeq)obj;
            ((CharSeq) (obj)).consume(0, ((CharSeq) (obj)).size(), consumer);
            return;
        }
        int i1 = charsequence.length();
        int i = 0;
        while (i < i1) 
        {
            consumer.write(charsequence.charAt(i));
            i++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        int k;
        if ((obj instanceof LList) && (consumer instanceof OutPort))
        {
            writeList((LList)obj, (OutPort)consumer);
            return;
        }
        if (obj instanceof SimpleVector)
        {
            SimpleVector simplevector = (SimpleVector)obj;
            obj = simplevector.getTag();
            String s;
            int j;
            int j1;
            if (language == 'E')
            {
                obj = "[";
                s = "]";
            } else
            {
                if (obj == null)
                {
                    obj = "#(";
                } else
                {
                    obj = (new StringBuilder()).append("#").append(((String) (obj))).append("(").toString();
                }
                s = ")";
            }
            if (consumer instanceof OutPort)
            {
                ((OutPort)consumer).startLogicalBlock(((String) (obj)), false, s);
            } else
            {
                write(((String) (obj)), consumer);
            }
            j1 = simplevector.size();
            j = 0;
            do
            {
label0:
                {
                    if (j < j1 << 1)
                    {
                        if (j > 0 && (consumer instanceof OutPort))
                        {
                            ((OutPort)consumer).writeSpaceFill();
                        }
                        if (simplevector.consumeNext(j, consumer))
                        {
                            break label0;
                        }
                    }
                    if (consumer instanceof OutPort)
                    {
                        ((OutPort)consumer).endLogicalBlock(s);
                        return;
                    } else
                    {
                        write(s, consumer);
                        return;
                    }
                }
                j += 2;
            } while (true);
        }
        boolean flag;
label1:
        {
            if (obj instanceof Array)
            {
                write((Array)obj, 0, 0, consumer);
                return;
            }
            if (obj instanceof KNode)
            {
                if (getReadableOutput())
                {
                    write("#", consumer);
                }
                if (consumer instanceof Writer)
                {
                    consumer = (Writer)consumer;
                } else
                {
                    consumer = new ConsumerWriter(consumer);
                }
                consumer = new XMLPrinter(consumer);
                consumer.writeObject(obj);
                consumer.closeThis();
                return;
            }
            if (obj == Values.empty && getReadableOutput())
            {
                write("#!void", consumer);
                return;
            }
            if (obj instanceof Consumable)
            {
                ((Consumable)obj).consume(consumer);
                return;
            }
            if (obj instanceof Printable)
            {
                ((Printable)obj).print(consumer);
                return;
            }
            if (!(obj instanceof RatNum))
            {
                break; /* Loop/switch isn't completed */
            }
            k = 10;
            boolean flag1 = false;
            obj1 = outBase.get(null);
            Object obj2 = outRadix.get(null);
            flag = flag1;
            if (obj2 == null)
            {
                break label1;
            }
            if (obj2 != Boolean.TRUE)
            {
                flag = flag1;
                if (!"yes".equals(obj2.toString()))
                {
                    break label1;
                }
            }
            flag = true;
        }
        String s1;
        if (obj1 instanceof Number)
        {
            k = ((IntNum)obj1).intValue();
        } else
        if (obj1 != null)
        {
            k = Integer.parseInt(obj1.toString());
        }
_L6:
        s1 = ((RatNum)obj).toString(k);
        if (flag)
        {
            if (k == 16)
            {
                write("#x", consumer);
            } else
            if (k == 8)
            {
                write("#o", consumer);
            } else
            if (k == 2)
            {
                write("#b", consumer);
            } else
            if (k != 10 || !(obj instanceof IntNum))
            {
                write((new StringBuilder()).append("#").append(obj1).append("r").toString(), consumer);
            }
        }
        write(s1, consumer);
        if (flag && k == 10 && (obj instanceof IntNum))
        {
            write(".", consumer);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if ((obj instanceof Enum) && getReadableOutput())
        {
            write(obj.getClass().getName(), consumer);
            write(":", consumer);
            write(((Enum)obj).name(), consumer);
            return;
        }
        if (obj == null)
        {
            obj = null;
        } else
        {
            if (obj.getClass().isArray())
            {
                int k1 = java.lang.reflect.Array.getLength(obj);
                int l;
                if (consumer instanceof OutPort)
                {
                    ((OutPort)consumer).startLogicalBlock("[", false, "]");
                } else
                {
                    write("[", consumer);
                }
                for (l = 0; l < k1; l++)
                {
                    if (l > 0)
                    {
                        write(" ", consumer);
                        if (consumer instanceof OutPort)
                        {
                            ((OutPort)consumer).writeBreakFill();
                        }
                    }
                    writeObject(java.lang.reflect.Array.get(obj, l), consumer);
                }

                if (consumer instanceof OutPort)
                {
                    ((OutPort)consumer).endLogicalBlock("]");
                    return;
                } else
                {
                    write("]", consumer);
                    return;
                }
            }
            obj = obj.toString();
        }
        if (obj == null)
        {
            write("#!null", consumer);
            return;
        }
        write(((String) (obj)), consumer);
        return;
          goto _L6
        if (true) goto _L4; else goto _L7
_L7:
    }

    void writeSymbol(Symbol symbol, Consumer consumer, boolean flag)
    {
        String s;
        String s1;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag2 = true;
        s1 = symbol.getPrefix();
        Namespace namespace = symbol.getNamespace();
        if (namespace == null)
        {
            s = null;
        } else
        {
            s = namespace.getName();
        }
        if (s != null && s.length() > 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (s1 == null || s1.length() <= 0)
        {
            flag2 = false;
        }
        flag4 = false;
        if (namespace != Keyword.keywordNamespace) goto _L2; else goto _L1
_L1:
        if (language == 'C' || language == 'E')
        {
            consumer.write(58);
            flag3 = flag4;
        } else
        {
            flag3 = true;
        }
_L4:
        writeSymbol(symbol.getName(), consumer, flag);
        if (flag3)
        {
            consumer.write(58);
        }
        return;
_L2:
        if (!flag2)
        {
            flag3 = flag4;
            if (!flag1)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        if (flag2)
        {
            writeSymbol(s1, consumer, flag);
        }
        if (flag1 && (flag || !flag2))
        {
            consumer.write(123);
            consumer.write(s);
            consumer.write(125);
        }
        consumer.write(58);
        flag3 = flag4;
        if (true) goto _L4; else goto _L3
_L3:
    }

    void writeSymbol(String s, Consumer consumer, boolean flag)
    {
        int j;
        if (!flag || r5rsIdentifierMinusInteriorColons.matcher(s).matches())
        {
            break MISSING_BLOCK_LABEL_151;
        }
        j = s.length();
        if (j != 0) goto _L2; else goto _L1
_L1:
        write("||", consumer);
_L8:
        return;
_L2:
        int i;
        boolean flag2;
        flag2 = false;
        i = 0;
_L4:
        boolean flag1;
        if (i >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        char c = s.charAt(i);
        if (c != '|')
        {
            break; /* Loop/switch isn't completed */
        }
        String s1;
        if (flag2)
        {
            s1 = "|\\";
        } else
        {
            s1 = "\\";
        }
        write(s1, consumer);
        flag1 = false;
_L5:
        consumer.write(c);
        i++;
        flag2 = flag1;
        if (true) goto _L4; else goto _L3
_L3:
        flag1 = flag2;
        if (!flag2)
        {
            consumer.write(124);
            flag1 = true;
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
        if (!flag2) goto _L8; else goto _L7
_L7:
        consumer.write(124);
        return;
        write(s, consumer);
        return;
    }

    static 
    {
        outBase = new ThreadLocation("out-base");
        outBase.setGlobal(IntNum.ten());
    }
}
