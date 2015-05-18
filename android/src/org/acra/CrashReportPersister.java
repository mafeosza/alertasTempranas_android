// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Iterator;
import java.util.Set;
import org.acra.collector.CrashReportData;

// Referenced classes of package org.acra:
//            ReportField

final class CrashReportPersister
{

    private static final int CONTINUE = 3;
    private static final int IGNORE = 5;
    private static final int KEY_DONE = 4;
    private static final String LINE_SEPARATOR = "\n";
    private static final int NONE = 0;
    private static final int SLASH = 1;
    private static final int UNICODE = 2;
    private final Context context;

    CrashReportPersister(Context context1)
    {
        context = context1;
    }

    private void dumpString(StringBuilder stringbuilder, String s, boolean flag)
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
                        boolean flag1 = false;
                        int i = ((flag1) ? 1 : 0);
                        if (!flag)
                        {
                            i = ((flag1) ? 1 : 0);
                            if (s.length() < 0)
                            {
                                i = ((flag1) ? 1 : 0);
                                if (s.charAt(0) == ' ')
                                {
                                    stringbuilder.append("\\ ");
                                    i = 0 + 1;
                                }
                            }
                        }
label4:
                        do
                        {
                            {
                                if (i >= s.length())
                                {
                                    break label0;
                                }
                                char c = s.charAt(i);
                                switch (c)
                                {
                                case 11: // '\013'
                                default:
                                    if ("\\#!=:".indexOf(c) >= 0 || flag && c == ' ')
                                    {
                                        stringbuilder.append('\\');
                                    }
                                    if (c >= ' ' && c <= '~')
                                    {
                                        stringbuilder.append(c);
                                    } else
                                    {
                                        String s1 = Integer.toHexString(c);
                                        stringbuilder.append("\\u");
                                        for (int j = 0; j < 4 - s1.length(); j++)
                                        {
                                            stringbuilder.append("0");
                                        }

                                        stringbuilder.append(s1);
                                    }
                                    break;

                                case 9: // '\t'
                                    break label4;

                                case 10: // '\n'
                                    break label3;

                                case 12: // '\f'
                                    break label2;

                                case 13: // '\r'
                                    break label1;
                                }
                            }
                            i++;
                        } while (true);
                        stringbuilder.append("\\t");
                        break MISSING_BLOCK_LABEL_149;
                    }
                    stringbuilder.append("\\n");
                    break MISSING_BLOCK_LABEL_149;
                }
                stringbuilder.append("\\f");
                break MISSING_BLOCK_LABEL_149;
            }
            stringbuilder.append("\\r");
            break MISSING_BLOCK_LABEL_149;
        }
    }

    private boolean isEbcdic(BufferedInputStream bufferedinputstream)
        throws IOException
    {
        byte byte0;
        do
        {
            byte0 = (byte)bufferedinputstream.read();
            if (byte0 == -1 || byte0 == 35 || byte0 == 10 || byte0 == 61)
            {
                return false;
            }
        } while (byte0 != 21);
        return true;
    }

    private CrashReportData load(Reader reader)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        int i1;
        int j1;
        i = 0;
        j1 = 0;
        i1 = 0;
        char ac[] = new char[40];
        int j;
        boolean flag;
        j = -1;
        flag = true;
        CrashReportData crashreportdata;
        Object obj1;
        crashreportdata = new CrashReportData();
        obj1 = new BufferedReader(reader, 8192);
        int l;
        l = 0;
        reader = ac;
_L10:
        int k = ((BufferedReader) (obj1)).read();
        if (k != -1) goto _L2; else goto _L1
_L1:
        if (i != 2 || i1 > 4) goto _L4; else goto _L3
_L3:
        throw new IllegalArgumentException("luni.08");
        reader;
        this;
        JVM INSTR monitorexit ;
        throw reader;
_L2:
        char c1;
        Object obj;
        c1 = (char)k;
        obj = reader;
        if (l == reader.length)
        {
            obj = new char[reader.length * 2];
            System.arraycopy(reader, 0, obj, 0, l);
        }
        int k1;
        int l1;
        int i2;
        i2 = i1;
        k1 = i;
        k = l;
        l1 = j1;
        if (i != 2) goto _L6; else goto _L5
_L5:
        k = Character.digit(c1, 16);
        if (k < 0) goto _L8; else goto _L7
_L7:
        k = (j1 << 4) + k;
        k1 = i1 + 1;
        reader = ((Reader) (obj));
        i1 = k1;
        j1 = k;
        if (k1 < 4) goto _L10; else goto _L9
_L9:
        i = k1;
        j1 = k;
          goto _L11
_L8:
        i = i1;
        if (i1 > 4) goto _L11; else goto _L12
_L12:
        throw new IllegalArgumentException("luni.09");
_L35:
        char c2 = k1;
        if (!Character.isWhitespace(c1)) goto _L14; else goto _L13
_L13:
        c2 = k1;
        if (k1 == 3)
        {
            c2 = '\005';
        }
        reader = ((Reader) (obj));
        i1 = i2;
        i = c2;
        l = k;
        j1 = l1;
          goto _L15
_L20:
        c2 = ((BufferedReader) (obj1)).read();
        reader = ((Reader) (obj));
        i1 = i2;
        i = k1;
        l = k;
        j1 = l1;
        if (c2 == -1) goto _L10; else goto _L16
_L16:
        c2 = (char)c2;
        reader = ((Reader) (obj));
        i1 = i2;
        i = k1;
        l = k;
        j1 = l1;
        if (c2 == '\r') goto _L10; else goto _L17
_L17:
        reader = ((Reader) (obj));
        i1 = i2;
        i = k1;
        l = k;
        j1 = l1;
        if (c2 == '\n') goto _L10; else goto _L18
_L18:
        if (c2 != '\205') goto _L20; else goto _L19
_L19:
        reader = ((Reader) (obj));
        i1 = i2;
        i = k1;
        l = k;
        j1 = l1;
          goto _L10
_L47:
        reader = new String(((char []) (obj)), 0, k);
        crashreportdata.put(Enum.valueOf(org/acra/ReportField, reader.substring(0, i)), reader.substring(i));
          goto _L21
_L4:
        k = j;
        if (j == -1)
        {
            k = j;
            if (l > 0)
            {
                k = l;
            }
        }
        if (k < 0)
        {
            break MISSING_BLOCK_LABEL_488;
        }
        reader = new String(reader, 0, l);
        obj1 = (ReportField)Enum.valueOf(org/acra/ReportField, reader.substring(0, k));
        obj = reader.substring(k);
        reader = ((Reader) (obj));
        if (i != 1)
        {
            break MISSING_BLOCK_LABEL_479;
        }
        reader = (new StringBuilder()).append(((String) (obj))).append("\0").toString();
        crashreportdata.put(((Enum) (obj1)), reader);
        this;
        JVM INSTR monitorexit ;
        return crashreportdata;
_L11:
label0:
        {
            k1 = 0;
            c2 = '\0';
            k = l + 1;
            obj[l] = (char)j1;
            if (c1 == '\n' || c1 == '\205')
            {
                break label0;
            }
            reader = ((Reader) (obj));
            i1 = i;
            i = c2;
            l = k;
        }
        if (true) goto _L10; else goto _L22
_L22:
        l1 = j1;
        i2 = i;
_L6:
        if (k1 != 1) goto _L24; else goto _L23
_L23:
        i = 0;
        c1;
        JVM INSTR lookupswitch 9: default 644
    //                   10: 721
    //                   13: 700
    //                   98: 742
    //                   102: 748
    //                   110: 754
    //                   114: 760
    //                   116: 766
    //                   117: 772
    //                   133: 721;
           goto _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32 _L33 _L26
_L25:
        c = c1;
_L34:
        flag = false;
        l = i;
        if (i == 4)
        {
            j = k;
            l = 0;
        }
        obj[k] = c;
        k++;
        reader = ((Reader) (obj));
        i1 = i2;
        i = l;
        l = k;
        j1 = l1;
          goto _L10
_L27:
        i = 3;
        reader = ((Reader) (obj));
        i1 = i2;
        l = k;
        j1 = l1;
          goto _L10
_L26:
        i = 5;
        reader = ((Reader) (obj));
        i1 = i2;
        l = k;
        j1 = l1;
          goto _L10
_L28:
        c = '\b';
          goto _L34
_L29:
        c = '\f';
          goto _L34
_L30:
        c = '\n';
          goto _L34
_L31:
        c = '\r';
          goto _L34
_L32:
        c = '\t';
          goto _L34
_L33:
        i = 2;
        i1 = 0;
        j1 = 0;
        reader = ((Reader) (obj));
        l = k;
          goto _L10
_L24:
        c1;
        JVM INSTR lookupswitch 8: default 868
    //                   10: 981
    //                   13: 1008
    //                   33: 973
    //                   35: 973
    //                   58: 1105
    //                   61: 1105
    //                   92: 1074
    //                   133: 1008;
           goto _L35 _L36 _L37 _L38 _L38 _L39 _L39 _L40 _L37
_L39:
        continue; /* Loop/switch isn't completed */
_L15:
        if (k == 0) goto _L10; else goto _L41
_L41:
        reader = ((Reader) (obj));
        i1 = i2;
        i = c2;
        l = k;
        j1 = l1;
        if (k == j) goto _L10; else goto _L42
_L42:
        reader = ((Reader) (obj));
        i1 = i2;
        i = c2;
        l = k;
        j1 = l1;
        if (c2 == '\005') goto _L10; else goto _L43
_L43:
        if (j != -1) goto _L14; else goto _L44
_L44:
        i = 4;
        reader = ((Reader) (obj));
        i1 = i2;
        l = k;
        j1 = l1;
          goto _L10
_L38:
        if (!flag) goto _L35; else goto _L20
_L36:
        if (k1 != 3) goto _L37; else goto _L45
_L45:
        i = 5;
        reader = ((Reader) (obj));
        i1 = i2;
        l = k;
        j1 = l1;
          goto _L10
_L37:
        l = 0;
        flag = true;
        if (k <= 0 && (k != 0 || j != 0)) goto _L21; else goto _L46
_L46:
        i = j;
        if (j == -1)
        {
            i = k;
        }
          goto _L47
_L21:
        j = -1;
        k = 0;
        reader = ((Reader) (obj));
        i1 = i2;
        i = l;
        l = k;
        j1 = l1;
          goto _L10
_L40:
        if (k1 == 4)
        {
            j = k;
        }
        i = 1;
        reader = ((Reader) (obj));
        i1 = i2;
        l = k;
        j1 = l1;
          goto _L10
        if (j != -1) goto _L35; else goto _L48
_L48:
        i = 0;
        j = k;
        reader = ((Reader) (obj));
        i1 = i2;
        l = k;
        j1 = l1;
          goto _L10
_L14:
        if (c2 == '\005') goto _L50; else goto _L49
_L49:
        i = c2;
        c = c1;
        if (c2 != '\003') goto _L34; else goto _L50
_L50:
        i = 0;
        c = c1;
          goto _L34
    }

    public CrashReportData load(String s)
        throws IOException
    {
        FileInputStream fileinputstream;
        fileinputstream = context.openFileInput(s);
        if (fileinputstream == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid crash report fileName : ").append(s).toString());
        }
        boolean flag;
        s = new BufferedInputStream(fileinputstream, 8192);
        s.mark(0x7fffffff);
        flag = isEbcdic(s);
        s.reset();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        s = load(((Reader) (new InputStreamReader(s, "ISO8859-1"))));
        fileinputstream.close();
        return s;
        s = load(((Reader) (new InputStreamReader(s))));
        fileinputstream.close();
        return s;
        s;
        fileinputstream.close();
        throw s;
    }

    public void store(CrashReportData crashreportdata, String s)
        throws IOException
    {
        s = context.openFileOutput(s, 0);
        OutputStreamWriter outputstreamwriter;
        StringBuilder stringbuilder = new StringBuilder(200);
        outputstreamwriter = new OutputStreamWriter(s, "ISO8859_1");
        for (crashreportdata = crashreportdata.entrySet().iterator(); crashreportdata.hasNext(); stringbuilder.setLength(0))
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)crashreportdata.next();
            dumpString(stringbuilder, ((ReportField)entry.getKey()).toString(), true);
            stringbuilder.append('=');
            dumpString(stringbuilder, (String)entry.getValue(), false);
            stringbuilder.append("\n");
            outputstreamwriter.write(stringbuilder.toString());
        }

        break MISSING_BLOCK_LABEL_136;
        crashreportdata;
        s.close();
        throw crashreportdata;
        outputstreamwriter.flush();
        s.close();
        return;
    }
}
