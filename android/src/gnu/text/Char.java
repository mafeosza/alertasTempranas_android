// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import gnu.lists.Consumer;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

// Referenced classes of package gnu.text:
//            CharMap

public class Char
    implements Comparable, Externalizable
{

    static Char ascii[];
    static char charNameValues[];
    static String charNames[];
    static CharMap hashTable = new CharMap();
    int value;

    public Char()
    {
    }

    Char(int i)
    {
        value = i;
    }

    public static Char make(int i)
    {
        if (i < 128)
        {
            return ascii[i];
        }
        Char char1;
        synchronized (hashTable)
        {
            char1 = hashTable.get(i);
        }
        return char1;
        exception;
        charmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static int nameToChar(String s)
    {
        int i = charNames.length;
_L4:
        int j = i - 1;
        if (j < 0) goto _L2; else goto _L1
_L1:
        i = j;
        if (!charNames[j].equals(s)) goto _L4; else goto _L3
_L3:
        int k = charNameValues[j];
_L10:
        return k;
_L2:
        int l;
        i = charNames.length;
        do
        {
            j = i - 1;
            if (j < 0)
            {
                break;
            }
            i = j;
            if (charNames[j].equalsIgnoreCase(s))
            {
                return charNameValues[j];
            }
        } while (true);
        l = s.length();
        if (l <= 1 || s.charAt(0) != 'u') goto _L6; else goto _L5
_L5:
        i = 0;
        j = 1;
_L8:
        k = i;
        if (j == l)
        {
            continue; /* Loop/switch isn't completed */
        }
        k = Character.digit(s.charAt(j), 16);
        if (k >= 0)
        {
            break MISSING_BLOCK_LABEL_160;
        }
_L6:
        if (l == 3 && s.charAt(1) == '-')
        {
            i = s.charAt(0);
            if (i == 'c' || i == 'C')
            {
                return s.charAt(2) & 0x1f;
            }
        }
        break MISSING_BLOCK_LABEL_173;
        i = (i << 4) + k;
        j++;
        if (true) goto _L8; else goto _L7
_L7:
        return -1;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static void print(int i, Consumer consumer)
    {
        if (i >= 0x10000)
        {
            consumer.write((char)((i - 0x10000 >> 10) + 55296));
            consumer.write((char)((i & 0x3ff) + 56320));
            return;
        } else
        {
            consumer.write((char)i);
            return;
        }
    }

    public static String toScmReadableString(int i)
    {
        StringBuffer stringbuffer = new StringBuffer(20);
        stringbuffer.append("#\\");
        for (int j = 0; j < charNameValues.length; j++)
        {
            if ((char)i == charNameValues[j])
            {
                stringbuffer.append(charNames[j]);
                return stringbuffer.toString();
            }
        }

        if (i < 32 || i > 127)
        {
            stringbuffer.append('x');
            stringbuffer.append(Integer.toString(i, 16));
        } else
        {
            stringbuffer.append((char)i);
        }
        return stringbuffer.toString();
    }

    public final char charValue()
    {
        return (char)value;
    }

    public int compareTo(Object obj)
    {
        return value - ((Char)obj).value;
    }

    public boolean equals(Object obj)
    {
        return obj != null && (obj instanceof Char) && ((Char)obj).intValue() == value;
    }

    public int hashCode()
    {
        return value;
    }

    public final int intValue()
    {
        return value;
    }

    public void print(Consumer consumer)
    {
        print(value, consumer);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        value = objectinput.readChar();
        if (value >= 55296 && value < 56319)
        {
            char c = objectinput.readChar();
            if (c >= '\uDC00' && c <= '\uDFFF')
            {
                value = (value - 55296 << 10) + (c - 56320) + 0x10000;
            }
        }
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        return make(value);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append('\'');
        if (value >= 32 && value < 127 && value != 39)
        {
            stringbuffer.append((char)value);
        } else
        {
            stringbuffer.append('\\');
            if (value == 39)
            {
                stringbuffer.append('\'');
            } else
            if (value == 10)
            {
                stringbuffer.append('n');
            } else
            if (value == 13)
            {
                stringbuffer.append('r');
            } else
            if (value == 9)
            {
                stringbuffer.append('t');
            } else
            if (value < 256)
            {
                String s = Integer.toOctalString(value);
                int i = 3 - s.length();
                do
                {
                    i--;
                    if (i < 0)
                    {
                        break;
                    }
                    stringbuffer.append('0');
                } while (true);
                stringbuffer.append(s);
            } else
            {
                stringbuffer.append('u');
                String s1 = Integer.toHexString(value);
                int j = 4 - s1.length();
                do
                {
                    j--;
                    if (j < 0)
                    {
                        break;
                    }
                    stringbuffer.append('0');
                } while (true);
                stringbuffer.append(s1);
            }
        }
        stringbuffer.append('\'');
        return stringbuffer.toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        if (value <= 55296) goto _L2; else goto _L1
_L1:
        if (value <= 65535) goto _L4; else goto _L3
_L3:
        objectoutput.writeChar((value - 0x10000 >> 10) + 55296);
        value = (value & 0x3ff) + 56320;
_L2:
        objectoutput.writeChar(value);
        return;
_L4:
        if (value <= 56319)
        {
            objectoutput.writeChar(value);
            value = 0;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    static 
    {
        ascii = new Char[128];
        int i = 128;
        do
        {
            i--;
            if (i >= 0)
            {
                ascii[i] = new Char(i);
            } else
            {
                charNameValues = (new char[] {
                    ' ', '\t', '\n', '\n', '\r', '\f', '\b', '\033', '\177', '\177', 
                    '\177', '\007', '\007', '\013', '\0'
                });
                charNames = (new String[] {
                    "space", "tab", "newline", "linefeed", "return", "page", "backspace", "esc", "delete", "del", 
                    "rubout", "alarm", "bel", "vtab", "nul"
                });
            }
        } while (true);
    }
}
