// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class PreProcess
{

    static final String JAVA4_FEATURES = "+JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio";
    static final String JAVA5_FEATURES = "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName";
    static final String NO_JAVA4_FEATURES = "-JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android";
    static final String NO_JAVA6_FEATURES = "-JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer";
    static String version_features[] = {
        "java1", "-JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java2", "+JAVA2 -JAVA5 -use:java.util.IdentityHashMap -use:java.lang.CharSequence -use:java.lang.Throwable.getCause -use:java.net.URI -use:java.util.regex -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAVA5 -JAVA6 -JAVA6COMPAT5 -JAXP-QName -use:java.text.Normalizer -SAX2 -use:java.nio -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java4", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio -use:org.w3c.dom.Node -JAXP-1.3 -use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java4x", "-JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 +use:javax.xml.transform -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", "java5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6COMPAT5 -Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer", 
        "java6compat5", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName -JAVA6 -JAVA7 +JAVA6COMPAT5 +use:java.text.Normalizer -use:java.dyn -Android", "java6", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 -JAVA7 -JAVA6COMPAT5 +use:java.text.Normalizer -use:java.dyn -Android", "java7", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +use:javax.xml.transform +JAXP-1.3 -JAXP-QName +JAVA6 +JAVA7 -JAVA6COMPAT5 +use:java.text.Normalizer +use:java.dyn -Android", "android", "+JAVA5 +JAVA2 +use:java.util.IdentityHashMap +use:java.lang.CharSequence +use:java.lang.Throwable.getCause +use:java.net.URI +use:java.util.regex +SAX2 +use:java.nio +use:org.w3c.dom.Node +JAXP-1.3 -JAXP-QName -use:javax.xml.transform -JAVA6 -JAVA6COMPAT5 +Android -JAVA6 -JAVA7 -use:java.dyn -use:java.text.Normalizer"
    };
    String filename;
    Hashtable keywords;
    int lineno;
    byte resultBuffer[];
    int resultLength;

    public PreProcess()
    {
        keywords = new Hashtable();
    }

    public static void main(String args[])
    {
        PreProcess preprocess = new PreProcess();
        preprocess.keywords.put("true", Boolean.TRUE);
        preprocess.keywords.put("false", Boolean.FALSE);
        for (int i = 0; i < args.length; i++)
        {
            preprocess.handleArg(args[i]);
        }

    }

    void error(String s)
    {
        System.err.println((new StringBuilder()).append(filename).append(':').append(lineno).append(": ").append(s).toString());
        System.exit(-1);
    }

    public void filter(String s)
        throws Throwable
    {
        if (filter(s, new BufferedInputStream(new FileInputStream(s))))
        {
            FileOutputStream fileoutputstream = new FileOutputStream(s);
            fileoutputstream.write(resultBuffer, 0, resultLength);
            fileoutputstream.close();
            System.err.println((new StringBuilder()).append("Pre-processed ").append(s).toString());
        }
    }

    public boolean filter(String s, BufferedInputStream bufferedinputstream)
        throws Throwable
    {
        byte abyte0[];
        Object obj;
        int i;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        boolean flag;
        filename = s;
        abyte0 = new byte[2000];
        i = 0;
        j2 = 0;
        l = -1;
        lineno = 1;
        i2 = -1;
        k = 0;
        l1 = 0;
        j1 = 0;
        obj = null;
        flag = false;
        i1 = 0;
        k1 = 0;
_L3:
        int k2 = bufferedinputstream.read();
        if (k2 >= 0) goto _L2; else goto _L1
_L1:
        byte abyte1[];
        boolean flag1;
        flag1 = flag;
        abyte1 = abyte0;
        l = i;
_L7:
        if (l1 != 0)
        {
            lineno = k1;
            error((new StringBuilder()).append("unterminated ").append(((String) (obj))).toString());
        }
        resultBuffer = abyte1;
        resultLength = l;
        return flag1;
_L2:
label0:
        {
            if (i + 10 >= abyte0.length)
            {
                abyte1 = new byte[i * 2];
                System.arraycopy(abyte0, 0, abyte1, 0, i);
                abyte0 = abyte1;
            }
            if (k2 != 10 || i <= 0 || abyte0[i - 1] != 13)
            {
                break label0;
            }
            abyte0[i] = (byte)k2;
            i++;
        }
          goto _L3
        int j;
        if (i2 < 0 || l >= 0 || i1 > 0 || k2 == 13 || k2 == 10 || i2 != k && (k2 == 32 || k2 == 9))
        {
            break MISSING_BLOCK_LABEL_1582;
        }
        if (k2 == 47)
        {
            bufferedinputstream.mark(100);
            j = bufferedinputstream.read();
            if (j == 47)
            {
                j = 0;
            } else
            if (j == 42)
            {
                do
                {
                    j = bufferedinputstream.read();
                } while (j == 32 || j == 9);
                if (j != 35)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
            } else
            {
                j = 1;
            }
            bufferedinputstream.reset();
        } else
        {
            j = 1;
        }
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_1582;
        }
        j = i + 1;
        abyte0[i] = 47;
        i = j + 1;
        abyte0[j] = 47;
        abyte0[i] = 32;
        flag = true;
        i++;
        String s1;
        String s2;
        int l2;
        for (j = 1; k2 == 32 || k2 == 9 || l >= 0; j = i1)
        {
            break MISSING_BLOCK_LABEL_1559;
        }

        if (l1 <= 0 || i2 == k || k2 != 47) goto _L5; else goto _L4
_L4:
        i1 = bufferedinputstream.read();
        l = i;
        abyte1 = abyte0;
        flag1 = flag;
        if (i1 < 0) goto _L7; else goto _L6
_L6:
        if (i1 == 47) goto _L9; else goto _L8
_L8:
        abyte0[i] = 47;
        k2 = j;
        l = i + 1;
        j = i;
        i = k2;
_L11:
        abyte0[l] = (byte)i1;
        k2 = l + 1;
        if (i1 == 13 || i1 == 10)
        {
            {
                j = 0;
                l2 = -1;
                i = j2;
                j2 = j;
                Object obj1;
                while (i < k2 - 1) 
                {
                    j = j2;
                    l = l2;
                    if (abyte0[i] != 32)
                    {
                        j = j2;
                        l = l2;
                        if (abyte0[i] != 9)
                        {
                            if (l2 < 0)
                            {
                                j = i;
                                l = i;
                            } else
                            {
                                j = i;
                                l = l2;
                            }
                        }
                    }
                    i++;
                    j2 = j;
                    l2 = l;
                }
                i = k1;
                obj1 = obj;
                l = j1;
                j = i2;
                i1 = l1;
                if (j2 - l2 >= 4)
                {
                    i = k1;
                    obj1 = obj;
                    l = j1;
                    j = i2;
                    i1 = l1;
                    if (abyte0[l2] == 47)
                    {
                        i = k1;
                        obj1 = obj;
                        l = j1;
                        j = i2;
                        i1 = l1;
                        if (abyte0[l2 + 1] == 42)
                        {
                            i = k1;
                            obj1 = obj;
                            l = j1;
                            j = i2;
                            i1 = l1;
                            if (abyte0[j2 - 1] == 42)
                            {
                                i = k1;
                                obj1 = obj;
                                l = j1;
                                j = i2;
                                i1 = l1;
                                if (abyte0[j2] == 47)
                                {
                                    for (l2 += 2; l2 < j2 && abyte0[l2] == 32; l2++) { }
                                    for (j2 -= 2; j2 > l2 && abyte0[j2] == 32; j2--) { }
                                    i = k1;
                                    obj1 = obj;
                                    l = j1;
                                    j = i2;
                                    i1 = l1;
                                    if (abyte0[l2] == 35)
                                    {
                                        s2 = new String(abyte0, l2, (j2 - l2) + 1, "ISO-8859-1");
                                        j = s2.indexOf(' ');
                                        i = lineno;
                                        if (j > 0)
                                        {
                                            obj = s2.substring(0, j);
                                            s1 = s2.substring(j).trim();
                                            obj1 = keywords.get(s1);
                                        } else
                                        {
                                            s1 = "";
                                            obj1 = null;
                                            obj = s2;
                                        }
                                        if ("#ifdef".equals(obj) || "#ifndef".equals(obj))
                                        {
                                            if (obj1 == null)
                                            {
                                                System.err.println((new StringBuilder()).append(s).append(":").append(lineno).append(": warning - undefined keyword: ").append(s1).toString());
                                                obj1 = Boolean.FALSE;
                                            }
                                            j = l1 + 1;
                                            if (j1 > 0)
                                            {
                                                i1 = j;
                                                j = k;
                                                l = j1;
                                                obj1 = obj;
                                            } else
                                            {
                                                if (((String) (obj)).charAt(3) == 'n')
                                                {
                                                    l = 1;
                                                } else
                                                {
                                                    l = 0;
                                                }
                                                if (obj1 == Boolean.FALSE)
                                                {
                                                    i1 = 1;
                                                } else
                                                {
                                                    i1 = 0;
                                                }
                                                if (l != i1)
                                                {
                                                    l = j;
                                                    i1 = j;
                                                    j = k;
                                                    obj1 = obj;
                                                } else
                                                {
                                                    i1 = j;
                                                    obj1 = obj;
                                                    l = j1;
                                                    j = i2;
                                                }
                                            }
                                        } else
                                        if ("#else".equals(obj))
                                        {
                                            if (l1 == 0)
                                            {
                                                error((new StringBuilder()).append("unexpected ").append(((String) (obj))).toString());
                                                obj1 = obj;
                                                l = j1;
                                                j = i2;
                                                i1 = l1;
                                            } else
                                            if (l1 == j1)
                                            {
                                                j = -1;
                                                l = 0;
                                                obj1 = obj;
                                                i1 = l1;
                                            } else
                                            if (j1 == 0)
                                            {
                                                l = l1;
                                                j = k;
                                                obj1 = obj;
                                                i1 = l1;
                                            } else
                                            {
                                                j = k;
                                                obj1 = obj;
                                                l = j1;
                                                i1 = l1;
                                            }
                                        } else
                                        if ("#endif".equals(obj))
                                        {
                                            if (l1 == 0)
                                            {
                                                error((new StringBuilder()).append("unexpected ").append(((String) (obj))).toString());
                                            }
                                            if (l1 == j1)
                                            {
                                                j = 0;
                                                k = -1;
                                            } else
                                            if (j1 > 0)
                                            {
                                                j = j1;
                                            } else
                                            {
                                                j = j1;
                                                k = i2;
                                            }
                                            i1 = l1 - 1;
                                            obj1 = obj;
                                            l = j;
                                            j = k;
                                        } else
                                        {
                                            error((new StringBuilder()).append("unknown command: ").append(s2).toString());
                                            obj1 = obj;
                                            l = j1;
                                            j = i2;
                                            i1 = l1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                l2 = -1;
                k = 0;
                lineno = lineno + 1;
                j2 = k2;
                k1 = 0;
                l1 = i1;
                i2 = j;
                j1 = l;
                j = l2;
                obj = obj1;
                l = i;
                i = k1;
            }
            k1 = l;
            i1 = i;
            l = j;
            i = k2;
        } else
        {
            if (j < 0)
            {
                if (i1 == 9)
                {
                    k = k + 8 & -8;
                } else
                {
                    k++;
                }
                l = k1;
            } else
            {
                l = k1;
            }
            break MISSING_BLOCK_LABEL_1125;
        }
          goto _L3
_L9:
        i1 = bufferedinputstream.read();
        l = i;
        abyte1 = abyte0;
        flag1 = flag;
        if (i1 < 0) goto _L7; else goto _L10
_L10:
label1:
        {
            j = i1;
            if (i1 != 32)
            {
                break label1;
            }
            i1 = bufferedinputstream.read();
            if (i1 != 32)
            {
                j = i1;
                if (i1 != 9)
                {
                    break label1;
                }
            }
            k2 = -1;
            j = -1;
            l = i;
            flag = true;
            i = k2;
        }
          goto _L11
        l = i;
        k2 = i;
        flag = true;
        i1 = j;
        i = -1;
        j = k2;
          goto _L11
_L5:
        l2 = j;
        j = i;
        l = i;
        i1 = k2;
        i = l2;
          goto _L11
        i1 = i;
        i = j;
        j = l;
        l = i1;
        i1 = k2;
          goto _L11
    }

    void handleArg(String s)
    {
        int j;
label0:
        {
            int i = 0;
            if (s.charAt(0) == '%')
            {
                s = s.substring(1);
                do
                {
                    if (i >= version_features.length)
                    {
                        System.err.println((new StringBuilder()).append("Unknown version: ").append(s).toString());
                        System.exit(-1);
                    }
                    if (s.equals(version_features[i]))
                    {
                        String s1 = version_features[i + 1];
                        System.err.println((new StringBuilder()).append("(variant ").append(s).append(" maps to: ").append(s1).append(")").toString());
                        for (s = new StringTokenizer(s1); s.hasMoreTokens(); handleArg(s.nextToken())) { }
                        break;
                    }
                    i += 2;
                } while (true);
            } else
            {
                if (s.charAt(0) != '+')
                {
                    break label0;
                }
                keywords.put(s.substring(1), Boolean.TRUE);
            }
            return;
        }
        if (s.charAt(0) != '-')
        {
            break MISSING_BLOCK_LABEL_347;
        }
        j = s.indexOf('=');
        if (j <= 1) goto _L2; else goto _L1
_L1:
        Boolean boolean1;
        String s2;
        String s3;
        byte byte0;
        if (s.charAt(1) == '-')
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        s2 = s.substring(byte0, j);
        s3 = s.substring(j + 1);
        boolean1 = Boolean.FALSE;
        if (!s3.equalsIgnoreCase("true")) goto _L4; else goto _L3
_L3:
        s = Boolean.TRUE;
_L5:
        keywords.put(s2, s);
        return;
_L4:
        s = boolean1;
        if (!s3.equalsIgnoreCase("false"))
        {
            System.err.println((new StringBuilder()).append("invalid value ").append(s3).append(" for ").append(s2).toString());
            System.exit(-1);
            s = boolean1;
        }
        if (true) goto _L5; else goto _L2
_L2:
        keywords.put(s.substring(1), Boolean.FALSE);
        return;
        try
        {
            filter(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            System.err.println((new StringBuilder()).append("caught ").append(s).toString());
        }
        s.printStackTrace();
        System.exit(-1);
        return;
    }

}
