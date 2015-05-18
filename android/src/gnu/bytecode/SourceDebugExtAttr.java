// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, SourceFileAttr, ClassTypeWriter, ClassType

public class SourceDebugExtAttr extends Attribute
{

    int curFileIndex;
    String curFileName;
    int curLineIndex;
    byte data[];
    private String defaultStratumId;
    int dlength;
    int fileCount;
    int fileIDs[];
    String fileNames[];
    int lineCount;
    int lines[];
    int maxFileID;
    private String outputFileName;

    public SourceDebugExtAttr(ClassType classtype)
    {
        super("SourceDebugExtension");
        curLineIndex = -1;
        curFileIndex = -1;
        addToFrontOf(classtype);
    }

    private int fixLine(int i, int j)
    {
        int k;
        int l;
        int j1;
        l = lines[j];
        j1 = lines[j + 2];
        k = l;
        if (i >= l) goto _L2; else goto _L1
_L1:
        if (j <= 0) goto _L4; else goto _L3
_L3:
        return -1;
_L4:
        lines[j] = i;
        lines[j + 2] = ((l + j1) - 1 - i) + 1;
        lines[j + 3] = i;
        k = i;
_L2:
        int i1 = lines[j + 3] - k;
        if (i < k + j1)
        {
            return i + i1;
        }
        if (j == (lineCount - 1) * 5 || j == 0 && i < lines[8])
        {
            lines[j + 2] = (i - k) + 1;
            return i + i1;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    void addFile(String s)
    {
        if (curFileName != s && (s == null || !s.equals(curFileName))) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s1;
        int l;
        int i1;
        curFileName = s;
        s1 = SourceFileAttr.fixSourceFile(s);
        i1 = s1.lastIndexOf('/');
        if (i1 >= 0)
        {
            s = s1.substring(i1 + 1);
            String s2 = (new StringBuilder()).append(s).append('\n').append(s1).toString();
            s1 = s;
            s = s2;
        } else
        {
            s = s1;
        }
        if (curFileIndex >= 0 && s.equals(fileNames[curFileIndex])) goto _L1; else goto _L3
_L3:
        l = fileCount;
        for (int i = 0; i < l; i++)
        {
            if (i != curFileIndex && s.equals(fileNames[i]))
            {
                curFileIndex = i;
                curLineIndex = -1;
                return;
            }
        }

        if (fileIDs != null) goto _L5; else goto _L4
_L4:
        fileIDs = new int[5];
        fileNames = new String[5];
_L7:
        fileCount = fileCount + 1;
        int j = maxFileID + 1;
        maxFileID = j;
        int k = j << 1;
        j = k;
        if (i1 >= 0)
        {
            j = k + 1;
        }
        fileNames[l] = s;
        if (outputFileName == null)
        {
            outputFileName = s1;
        }
        fileIDs[l] = j;
        curFileIndex = l;
        curLineIndex = -1;
        return;
_L5:
        if (l >= fileIDs.length)
        {
            int ai[] = new int[l * 2];
            String as[] = new String[l * 2];
            System.arraycopy(fileIDs, 0, ai, 0, l);
            System.arraycopy(fileNames, 0, as, 0, l);
            fileIDs = ai;
            fileNames = as;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void addStratum(String s)
    {
        defaultStratumId = s;
    }

    public void assignConstants(ClassType classtype)
    {
        super.assignConstants(classtype);
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("SMAP\n");
        nonAsteriskString(outputFileName, stringbuffer);
        stringbuffer.append('\n');
        int i;
        if (defaultStratumId == null)
        {
            classtype = "Java";
        } else
        {
            classtype = defaultStratumId;
        }
        nonAsteriskString(classtype, stringbuffer);
        stringbuffer.append('\n');
        stringbuffer.append("*S ");
        stringbuffer.append(classtype);
        stringbuffer.append('\n');
        stringbuffer.append("*F\n");
        i = 0;
        while (i < fileCount) 
        {
            int l = fileIDs[i];
            boolean flag;
            if ((l & 1) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                stringbuffer.append("+ ");
            }
            stringbuffer.append(l >> 1);
            stringbuffer.append(' ');
            stringbuffer.append(fileNames[i]);
            stringbuffer.append('\n');
            i++;
        }
        if (lineCount > 0)
        {
            int i1 = 0;
            stringbuffer.append("*L\n");
            int j = 0;
            int k = 0;
            int k1;
            do
            {
                int j1 = lines[k];
                k1 = fileIDs[lines[k + 1]] >> 1;
                int l1 = lines[k + 2];
                int i2 = lines[k + 3];
                int j2 = lines[k + 4];
                stringbuffer.append(j1);
                j1 = i1;
                if (k1 != i1)
                {
                    stringbuffer.append('#');
                    stringbuffer.append(k1);
                    j1 = k1;
                }
                if (l1 != 1)
                {
                    stringbuffer.append(',');
                    stringbuffer.append(l1);
                }
                stringbuffer.append(':');
                stringbuffer.append(i2);
                if (j2 != 1)
                {
                    stringbuffer.append(',');
                    stringbuffer.append(j2);
                }
                stringbuffer.append('\n');
                k += 5;
                k1 = j + 1;
                j = k1;
                i1 = j1;
            } while (k1 < lineCount);
        }
        stringbuffer.append("*E\n");
        try
        {
            data = stringbuffer.toString().getBytes("UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (ClassType classtype)
        {
            throw new RuntimeException(classtype.toString());
        }
        dlength = data.length;
    }

    int fixLine(int i)
    {
        if (curLineIndex >= 0)
        {
            int j = fixLine(i, curLineIndex);
            if (j >= 0)
            {
                return j;
            }
        }
        int i1 = 0;
        int i2 = curFileIndex;
        for (int k = 0; k < lineCount; k++)
        {
            if (i1 != curLineIndex && i2 == lines[i1 + 1])
            {
                int j1 = fixLine(i, i1);
                if (j1 >= 0)
                {
                    curLineIndex = i1;
                    return j1;
                }
            }
            i1 += 5;
        }

        int l;
        int k1;
        if (lines == null)
        {
            lines = new int[20];
        } else
        if (i1 >= lines.length)
        {
            int ai[] = new int[i1 * 2];
            System.arraycopy(lines, 0, ai, 0, i1);
            lines = ai;
        }
        if (i1 == 0)
        {
            k1 = i;
            l = i;
        } else
        {
            k1 = lines[(i1 - 5) + 3] + lines[(i1 - 5) + 2];
            l = k1;
            if (i1 == 5)
            {
                l = k1;
                if (k1 < 10000)
                {
                    l = 10000;
                }
            }
            int l1 = l;
            k1 = l;
            l = l1;
        }
        lines[i1] = i;
        lines[i1 + 1] = i2;
        lines[i1 + 2] = 1;
        lines[i1 + 3] = k1;
        lines[i1 + 4] = 1;
        curLineIndex = i1;
        lineCount = lineCount + 1;
        return l;
    }

    public int getLength()
    {
        return dlength;
    }

    void nonAsteriskString(String s, StringBuffer stringbuffer)
    {
        if (s == null || s.length() == 0 || s.charAt(0) == '*')
        {
            stringbuffer.append(' ');
        }
        stringbuffer.append(s);
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.println(dlength);
        try
        {
            classtypewriter.print(new String(data, 0, dlength, "UTF-8"));
        }
        catch (Exception exception)
        {
            classtypewriter.print("(Caught ");
            classtypewriter.print(exception);
            classtypewriter.println(')');
        }
        if (dlength > 0 && data[dlength - 1] != 13 && data[dlength - 1] != 10)
        {
            classtypewriter.println();
        }
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.write(data, 0, dlength);
    }
}
