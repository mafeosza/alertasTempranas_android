// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Writer;

// Referenced classes of package gnu.lists:
//            SimpleVector, CharSeq, Consumable, Sequence, 
//            Consumer, Convert

public class FString extends SimpleVector
    implements Comparable, Appendable, CharSeq, Externalizable, Consumable
{

    protected static char empty[] = new char[0];
    public char data[];

    public FString()
    {
        data = empty;
    }

    public FString(int i)
    {
        size = i;
        data = new char[i];
    }

    public FString(int i, char c)
    {
        char ac[] = new char[i];
        data = ac;
        size = i;
        do
        {
            i--;
            if (i >= 0)
            {
                ac[i] = c;
            } else
            {
                return;
            }
        } while (true);
    }

    public FString(CharSeq charseq)
    {
        this(charseq, 0, charseq.size());
    }

    public FString(CharSeq charseq, int i, int j)
    {
        char ac[] = new char[j];
        charseq.getChars(i, i + j, ac, 0);
        data = ac;
        size = j;
    }

    public FString(Sequence sequence)
    {
        data = new char[sequence.size()];
        addAll(sequence);
    }

    public FString(CharSequence charsequence)
    {
        this(charsequence, 0, charsequence.length());
    }

    public FString(CharSequence charsequence, int i, int j)
    {
        char ac[] = new char[j];
        int k = j;
        do
        {
            k--;
            if (k >= 0)
            {
                ac[k] = charsequence.charAt(i + k);
            } else
            {
                data = ac;
                size = j;
                return;
            }
        } while (true);
    }

    public FString(String s)
    {
        data = s.toCharArray();
        size = data.length;
    }

    public FString(StringBuffer stringbuffer)
    {
        this(stringbuffer, 0, stringbuffer.length());
    }

    public FString(StringBuffer stringbuffer, int i, int j)
    {
        size = j;
        data = new char[j];
        if (j > 0)
        {
            stringbuffer.getChars(i, i + j, data, 0);
        }
    }

    public FString(char ac[])
    {
        size = ac.length;
        data = ac;
    }

    public FString(char ac[], int i, int j)
    {
        size = j;
        data = new char[j];
        System.arraycopy(ac, i, data, 0, j);
    }

    public boolean addAll(FString fstring)
    {
        boolean flag = false;
        int i = size + fstring.size;
        if (data.length < i)
        {
            setBufferLength(i);
        }
        System.arraycopy(fstring.data, 0, data, size, fstring.size);
        size = i;
        if (fstring.size > 0)
        {
            flag = true;
        }
        return flag;
    }

    public boolean addAll(CharSequence charsequence)
    {
        int j;
        int k;
        boolean flag;
        flag = false;
        j = charsequence.length();
        k = size + j;
        if (data.length < k)
        {
            setBufferLength(k);
        }
        if (!(charsequence instanceof FString)) goto _L2; else goto _L1
_L1:
        System.arraycopy(((FString)charsequence).data, 0, data, size, j);
_L4:
        size = k;
        if (j > 0)
        {
            flag = true;
        }
        return flag;
_L2:
        if (charsequence instanceof String)
        {
            ((String)charsequence).getChars(0, j, data, size);
            continue; /* Loop/switch isn't completed */
        }
        if (!(charsequence instanceof CharSeq))
        {
            break; /* Loop/switch isn't completed */
        }
        ((CharSeq)charsequence).getChars(0, j, data, size);
        if (true) goto _L4; else goto _L3
_L3:
        int i = j;
        do
        {
            i--;
            if (i < 0)
            {
                continue;
            }
            data[size + i] = charsequence.charAt(i);
        } while (true);
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void addAllStrings(Object aobj[], int i)
    {
        int k = size;
        for (int j = i; j < aobj.length; j++)
        {
            k += ((CharSequence)aobj[j]).length();
        }

        if (data.length < k)
        {
            setBufferLength(k);
        }
        for (; i < aobj.length; i++)
        {
            addAll((CharSequence)aobj[i]);
        }

    }

    public FString append(char c)
    {
        int i = size;
        if (i >= data.length)
        {
            ensureBufferLength(i + 1);
        }
        data[i] = c;
        size = i + 1;
        return this;
    }

    public FString append(CharSequence charsequence)
    {
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        return append(((CharSequence) (obj)), 0, ((CharSequence) (obj)).length());
    }

    public FString append(CharSequence charsequence, int i, int j)
    {
        Object obj;
        int i1;
        obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        int k = j - i;
        i1 = size;
        if (i1 + k > data.length)
        {
            ensureBufferLength(i1 + k);
        }
        charsequence = data;
        if (!(obj instanceof String)) goto _L2; else goto _L1
_L1:
        ((String)obj).getChars(i, j, charsequence, i1);
_L4:
        size = i1;
        return this;
_L2:
        if (!(obj instanceof CharSeq))
        {
            break; /* Loop/switch isn't completed */
        }
        ((CharSeq)obj).getChars(i, j, charsequence, i1);
        if (true) goto _L4; else goto _L3
_L3:
        int l = i;
        i = i1;
        while (l < j) 
        {
            charsequence[i] = ((CharSequence) (obj)).charAt(l);
            l++;
            i++;
        }
        if (true) goto _L4; else goto _L5
_L5:
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

    public final char charAt(int i)
    {
        if (i >= size)
        {
            throw new StringIndexOutOfBoundsException(i);
        } else
        {
            return data[i];
        }
    }

    public final char charAtBuffer(int i)
    {
        return data[i];
    }

    protected void clearBuffer(int i, int j)
    {
        char ac[] = data;
        do
        {
            j--;
            if (j >= 0)
            {
                ac[i] = '\0';
                i++;
            } else
            {
                return;
            }
        } while (true);
    }

    public int compareTo(Object obj)
    {
        obj = (FString)obj;
        char ac[] = data;
        char ac1[] = ((FString) (obj)).data;
        int k = size;
        int l = ((FString) (obj)).size;
        int i;
        int j;
        if (k > l)
        {
            i = l;
        } else
        {
            i = k;
        }
        for (j = 0; j < i; j++)
        {
            int i1 = ac[j] - ac1[j];
            if (i1 != 0)
            {
                return i1;
            }
        }

        return k - l;
    }

    public void consume(Consumer consumer)
    {
        consumer.write(data, 0, data.length);
    }

    public boolean consumeNext(int i, Consumer consumer)
    {
        i >>>= 1;
        if (i >= size)
        {
            return false;
        } else
        {
            consumer.write(data[i]);
            return true;
        }
    }

    public void consumePosRange(int i, int j, Consumer consumer)
    {
        if (!consumer.ignoring())
        {
            int k = i >>> 1;
            j >>>= 1;
            i = j;
            if (j > size)
            {
                i = size;
            }
            if (i > k)
            {
                consumer.write(data, k, i - k);
                return;
            }
        }
    }

    public FString copy(int i, int j)
    {
        char ac[] = new char[j - i];
        char ac1[] = data;
        for (int k = i; k < j; k++)
        {
            ac[k - i] = ac1[k];
        }

        return new FString(ac);
    }

    public void ensureBufferLength(int i)
    {
        if (i > data.length)
        {
            char ac[];
            int j;
            if (i < 60)
            {
                j = 120;
            } else
            {
                j = i * 2;
            }
            ac = new char[j];
            System.arraycopy(data, 0, ac, 0, i);
            data = ac;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof FString))
        {
            obj = ((FString)obj).data;
            int i = size;
            if (obj != null && obj.length == i)
            {
                char ac[] = data;
                do
                {
                    int j = i - 1;
                    if (j >= 0)
                    {
                        i = j;
                        if (ac[j] != obj[j])
                        {
                            return false;
                        }
                    } else
                    {
                        return true;
                    }
                } while (true);
            }
        }
        return false;
    }

    public final void fill(char c)
    {
        char ac[] = data;
        int i = size;
        do
        {
            i--;
            if (i >= 0)
            {
                ac[i] = c;
            } else
            {
                return;
            }
        } while (true);
    }

    public void fill(int i, int j, char c)
    {
        if (i < 0 || j > size)
        {
            throw new IndexOutOfBoundsException();
        }
        char ac[] = data;
        for (; i < j; i++)
        {
            ac[i] = c;
        }

    }

    public final Object get(int i)
    {
        if (i >= size)
        {
            throw new ArrayIndexOutOfBoundsException();
        } else
        {
            return Convert.toObject(data[i]);
        }
    }

    protected Object getBuffer()
    {
        return data;
    }

    public final Object getBuffer(int i)
    {
        return Convert.toObject(data[i]);
    }

    public int getBufferLength()
    {
        return data.length;
    }

    public void getChars(int i, int j, StringBuffer stringbuffer)
    {
        if (i < 0 || i > j)
        {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (j > size)
        {
            throw new StringIndexOutOfBoundsException(j);
        }
        if (i < j)
        {
            stringbuffer.append(data, i, j - i);
        }
    }

    public void getChars(int i, int j, char ac[], int k)
    {
        if (i < 0 || i > j)
        {
            throw new StringIndexOutOfBoundsException(i);
        }
        if (j > size)
        {
            throw new StringIndexOutOfBoundsException(j);
        }
        if ((k + j) - i > ac.length)
        {
            throw new StringIndexOutOfBoundsException(k);
        }
        if (i < j)
        {
            System.arraycopy(data, i, ac, k, j - i);
        }
    }

    public void getChars(StringBuffer stringbuffer)
    {
        stringbuffer.append(data, 0, size);
    }

    public int getElementKind()
    {
        return 29;
    }

    public int hashCode()
    {
        char ac[] = data;
        int k = size;
        int j = 0;
        for (int i = 0; i < k; i++)
        {
            j = j * 31 + ac[i];
        }

        return j;
    }

    public int length()
    {
        return size;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        int j = objectinput.readInt();
        char ac[] = new char[j];
        for (int i = 0; i < j; i++)
        {
            ac[i] = objectinput.readChar();
        }

        data = ac;
        size = j;
    }

    public void replace(int i, String s)
    {
        s.getChars(0, s.length(), data, i);
    }

    public void replace(int i, char ac[], int j, int k)
    {
        System.arraycopy(ac, j, data, i, k);
    }

    public final Object setBuffer(int i, Object obj)
    {
        Object obj1 = Convert.toObject(data[i]);
        data[i] = Convert.toChar(obj);
        return obj1;
    }

    public void setBufferLength(int i)
    {
        int j = data.length;
        if (j != i)
        {
            char ac[] = new char[i];
            char ac1[] = data;
            if (j < i)
            {
                i = j;
            }
            System.arraycopy(ac1, 0, ac, 0, i);
            data = ac;
        }
    }

    public void setCharAt(int i, char c)
    {
        if (i < 0 || i >= size)
        {
            throw new StringIndexOutOfBoundsException(i);
        } else
        {
            data[i] = c;
            return;
        }
    }

    public void setCharAtBuffer(int i, char c)
    {
        data[i] = c;
    }

    public void shift(int i, int j, int k)
    {
        System.arraycopy(data, i, data, j, k);
    }

    public CharSequence subSequence(int i, int j)
    {
        return new FString(data, i, j - i);
    }

    public String substring(int i, int j)
    {
        return new String(data, i, j - i);
    }

    public char[] toCharArray()
    {
        int i = data.length;
        int j = size;
        if (j == i)
        {
            return data;
        } else
        {
            char ac[] = new char[j];
            System.arraycopy(data, 0, ac, 0, j);
            return ac;
        }
    }

    public String toString()
    {
        return new String(data, 0, size);
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        int j = size;
        objectoutput.writeInt(j);
        char ac[] = data;
        for (int i = 0; i < j; i++)
        {
            objectoutput.writeChar(ac[i]);
        }

    }

    public void writeTo(int i, int j, Appendable appendable)
        throws IOException
    {
        if (appendable instanceof Writer)
        {
            try
            {
                ((Writer)appendable).write(data, i, j);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Appendable appendable)
            {
                throw new RuntimeException(appendable);
            }
        } else
        {
            appendable.append(this, i, i + j);
            return;
        }
    }

    public void writeTo(Appendable appendable)
        throws IOException
    {
        writeTo(0, size, appendable);
    }

}
