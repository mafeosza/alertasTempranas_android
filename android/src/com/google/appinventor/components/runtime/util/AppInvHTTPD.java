// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.runtime.ReplForm;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.Properties;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kawa.standard.Scheme;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            NanoHTTPD, PackageInstaller, RetValManager, SdkLevel, 
//            EclairUtil

public class AppInvHTTPD extends NanoHTTPD
{

    private static final String LOG_TAG = "AppInvHTTPD";
    private static final String MIME_JSON = "application/json";
    private static final int YAV_SKEW_BACKWARD = 4;
    private static final int YAV_SKEW_FORWARD = 1;
    private static byte hmacKey[];
    private static int seq;
    private final Handler androidUIHandler = new Handler();
    private ReplForm form;
    private File rootDir;
    private Language scheme;
    private boolean secure;

    public AppInvHTTPD(int i, File file, boolean flag, ReplForm replform)
        throws IOException
    {
        super(i, file);
        rootDir = file;
        scheme = Scheme.getInstance("scheme");
        form = replform;
        secure = flag;
        ModuleExp.mustNeverCompile();
    }

    private void copyFile(File file, File file1)
    {
        byte abyte0[];
        file = new FileInputStream(file);
        file1 = new FileOutputStream(file1);
        abyte0 = new byte[32768];
_L1:
        int i = file.read(abyte0);
label0:
        {
            if (i <= 0)
            {
                break label0;
            }
            try
            {
                file1.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (File file)
            {
                file.printStackTrace();
                return;
            }
        }
          goto _L1
        file.close();
        file1.close();
        return;
    }

    private void doPackageUpdate(String s)
    {
        PackageInstaller.doPackageInstall(form, s);
    }

    public static void setHmacKey(String s)
    {
        hmacKey = s.getBytes();
        seq = 1;
    }

    public void resetSeq()
    {
        seq = 1;
    }

    public NanoHTTPD.Response serve(String s, String s1, Properties properties, Properties properties1, Properties properties2, Socket socket)
    {
        Log.d("AppInvHTTPD", (new StringBuilder()).append(s1).append(" '").append(s).append("' ").toString());
        if (!secure) goto _L2; else goto _L1
_L1:
        socket = socket.getInetAddress().getHostAddress();
        if (socket.equals("127.0.0.1")) goto _L2; else goto _L3
_L3:
        Log.d("AppInvHTTPD", (new StringBuilder()).append("Debug: hostAddress = ").append(socket).append(" while in secure mode, closing connection.").toString());
        s1 = new NanoHTTPD.Response(this, "200 OK", "application/json", (new StringBuilder()).append("{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid Source Location ").append(socket).append("\"}").toString());
        s1.addHeader("Access-Control-Allow-Origin", "*");
        s1.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        s1.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        s1.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
_L16:
        return s1;
_L2:
        int k;
        if (s1.equals("OPTIONS"))
        {
            for (s = properties.propertyNames(); s.hasMoreElements(); Log.d("AppInvHTTPD", (new StringBuilder()).append("  HDR: '").append(s1).append("' = '").append(properties.getProperty(s1)).append("'").toString()))
            {
                s1 = (String)s.nextElement();
            }

            s = new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
            s.addHeader("Access-Control-Allow-Origin", "*");
            s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
            s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
            s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
            return s;
        }
        if (!s.equals("/_newblocks"))
        {
            break MISSING_BLOCK_LABEL_1068;
        }
        properties = properties1.getProperty("seq", "0");
        k = Integer.parseInt(properties);
        s1 = properties1.getProperty("blockid");
        s = properties1.getProperty("code");
        properties1 = properties1.getProperty("mac", "no key provided");
        if (hmacKey == null) goto _L5; else goto _L4
_L4:
        Formatter formatter;
        int i;
        int i1;
        try
        {
            properties2 = Mac.getInstance("HmacSHA1");
            properties2.init(new SecretKeySpec(hmacKey, "RAW"));
            properties2 = properties2.doFinal((new StringBuilder()).append(s).append(properties).append(s1).toString().getBytes());
            socket = new StringBuffer(properties2.length * 2);
            formatter = new Formatter(socket);
            i1 = properties2.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("AppInvHTTPD", "Error working with hmac", s);
            form.dispatchErrorOccurredEvent(form, "AppInvHTTPD", 1801, new Object[] {
                "Exception working on HMAC"
            });
            return new NanoHTTPD.Response(this, "200 OK", "text/plain", "NOT");
        }
        i = 0;
        if (i >= i1)
        {
            break; /* Loop/switch isn't completed */
        }
        formatter.format("%02x", new Object[] {
            Byte.valueOf(properties2[i])
        });
        i++;
        if (true) goto _L7; else goto _L6
_L7:
        break MISSING_BLOCK_LABEL_440;
_L6:
        properties2 = socket.toString();
        Log.d("AppInvHTTPD", (new StringBuilder()).append("Incoming Mac = ").append(properties1).toString());
        Log.d("AppInvHTTPD", (new StringBuilder()).append("Computed Mac = ").append(properties2).toString());
        Log.d("AppInvHTTPD", (new StringBuilder()).append("Incoming seq = ").append(properties).toString());
        Log.d("AppInvHTTPD", (new StringBuilder()).append("Computed seq = ").append(seq).toString());
        Log.d("AppInvHTTPD", (new StringBuilder()).append("blockid = ").append(s1).toString());
        if (!properties1.equals(properties2))
        {
            Log.e("AppInvHTTPD", "Hmac does not match");
            form.dispatchErrorOccurredEvent(form, "AppInvHTTPD", 1801, new Object[] {
                "Invalid HMAC"
            });
            return new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid MAC\"}");
        }
        if (seq != k && seq != k + 1)
        {
            Log.e("AppInvHTTPD", "Seq does not match");
            form.dispatchErrorOccurredEvent(form, "AppInvHTTPD", 1801, new Object[] {
                "Invalid Seq"
            });
            return new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid Seq\"}");
        }
        if (seq == k + 1)
        {
            Log.e("AppInvHTTPD", "Seq Fixup Invoked");
        }
        seq = k + 1;
        properties = (new StringBuilder()).append("(begin (require <com.google.youngandroid.runtime>) (process-repl-input ").append(s1).append(" (begin ").append(s).append(" )))").toString();
        Log.d("AppInvHTTPD", (new StringBuilder()).append("To Eval: ").append(properties).toString());
        if (!s.equals("#f")) goto _L9; else goto _L8
_L8:
        Log.e("AppInvHTTPD", "Skipping evaluation of #f");
_L10:
        s = new NanoHTTPD.Response(this, "200 OK", "application/json", RetValManager.fetch(false));
_L11:
        s.addHeader("Access-Control-Allow-Origin", "*");
        s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        return s;
_L5:
        Log.e("AppInvHTTPD", "No HMAC Key");
        form.dispatchErrorOccurredEvent(form, "AppInvHTTPD", 1801, new Object[] {
            "No HMAC Key"
        });
        return new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: No HMAC Key\"}");
_L9:
        scheme.eval(properties);
          goto _L10
        s;
        Log.e("AppInvHTTPD", "newblocks: Scheme Failure", s);
        RetValManager.appendReturnValue(s1, "BAD", s.toString());
        s = new NanoHTTPD.Response(this, "200 OK", "application/json", RetValManager.fetch(false));
          goto _L11
        if (s.equals("/_values"))
        {
            s = new NanoHTTPD.Response(this, "200 OK", "application/json", RetValManager.fetch(true));
            s.addHeader("Access-Control-Allow-Origin", "*");
            s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
            s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
            s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
            return s;
        }
        if (!s.equals("/_getversion")) goto _L13; else goto _L12
_L12:
        properties = form.getPackageName();
        s1 = form.getPackageManager().getPackageInfo(properties, 0);
        if (SdkLevel.getLevel() < 5) goto _L15; else goto _L14
_L14:
        s = EclairUtil.getInstallerPackageName("edu.mit.appinventor.aicompanion3", form);
_L17:
        properties1 = ((PackageInfo) (s1)).versionName;
        s1 = s;
        if (s == null)
        {
            s1 = "Not Known";
        }
        try
        {
            s = new NanoHTTPD.Response(this, "200 OK", "application/json", (new StringBuilder()).append("{\"version\" : \"").append(properties1).append("\", \"fingerprint\" : \"").append(Build.FINGERPRINT).append("\",").append(" \"installer\" : \"").append(s1).append("\", \"package\" : \"").append(properties).append("\" }").toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            s = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"verison\" : \"Unknown\"");
        }
        s.addHeader("Access-Control-Allow-Origin", "*");
        s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        s1 = s;
        if (secure)
        {
            seq = 1;
            androidUIHandler.post(new Runnable() {

                final AppInvHTTPD this$0;

                public void run()
                {
                    form.clear();
                }

            
            {
                this$0 = AppInvHTTPD.this;
                super();
            }
            });
            return s;
        }
          goto _L16
_L15:
        s = "Not Known";
          goto _L17
_L13:
        if (!s.equals("/_update") && !s.equals("/_install"))
        {
            break MISSING_BLOCK_LABEL_1885;
        }
        s = properties1.getProperty("url", "");
        s1 = properties1.getProperty("mac", "");
        if (s.equals("") || hmacKey == null || s1.equals(""))
        {
            break MISSING_BLOCK_LABEL_1835;
        }
        int j;
        int l;
        try
        {
            properties = new SecretKeySpec(hmacKey, "RAW");
            properties1 = Mac.getInstance("HmacSHA1");
            properties1.init(properties);
            properties = properties1.doFinal(s.getBytes());
            properties1 = new StringBuffer(properties.length * 2);
            properties2 = new Formatter(properties1);
            l = properties.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("AppInvHTTPD", "Error verifying update", s);
            form.dispatchErrorOccurredEvent(form, "AppInvHTTPD", 1801, new Object[] {
                "Exception working on HMAC for update"
            });
            s = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: Exception processing MAC\"}");
            s.addHeader("Access-Control-Allow-Origin", "*");
            s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
            s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
            s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
            return s;
        }
        j = 0;
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        properties2.format("%02x", new Object[] {
            Byte.valueOf(properties[j])
        });
        j++;
        if (true) goto _L19; else goto _L18
_L19:
        break MISSING_BLOCK_LABEL_1503;
_L18:
        properties = properties1.toString();
        Log.d("AppInvHTTPD", (new StringBuilder()).append("Incoming Mac (update) = ").append(s1).toString());
        Log.d("AppInvHTTPD", (new StringBuilder()).append("Computed Mac (update) = ").append(properties).toString());
        if (!s1.equals(properties))
        {
            Log.e("AppInvHTTPD", "Hmac does not match");
            form.dispatchErrorOccurredEvent(form, "AppInvHTTPD", 1801, new Object[] {
                "Invalid HMAC (update)"
            });
            s = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid MAC\"}");
            s.addHeader("Access-Control-Allow-Origin", "*");
            s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
            s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
            s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
            return s;
        } else
        {
            doPackageUpdate(s);
            s = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"OK\", \"message\" : \"Update Should Happen\"}");
            s.addHeader("Access-Control-Allow-Origin", "*");
            s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
            s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
            s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
            return s;
        }
        s = new NanoHTTPD.Response(this, "200 OK", "application/json", "{\"status\" : \"BAD\", \"message\" : \"Missing Parameters\"}");
        s.addHeader("Access-Control-Allow-Origin", "*");
        s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        return s;
label0:
        {
            if (s.equals("/_package"))
            {
                s = properties1.getProperty("package", null);
                if (s == null)
                {
                    return new NanoHTTPD.Response(this, "200 OK", "text/plain", "NOT OK");
                } else
                {
                    Log.d("AppInvHTTPD", (new StringBuilder()).append(rootDir).append("/").append(s).toString());
                    s1 = new Intent("android.intent.action.VIEW");
                    s1.setDataAndType(Uri.fromFile(new File((new StringBuilder()).append(rootDir).append("/").append(s).toString())), "application/vnd.android.package-archive");
                    form.startActivity(s1);
                    return new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
                }
            }
            if (!s1.equals("PUT"))
            {
                break MISSING_BLOCK_LABEL_2363;
            }
            s1 = Boolean.valueOf(false);
            s = properties2.getProperty("content", null);
            if (s == null)
            {
                break MISSING_BLOCK_LABEL_2297;
            }
            properties2 = new File(s);
            properties = properties1.getProperty("filename", null);
            s = properties;
            if (properties == null)
            {
                break label0;
            }
            if (!properties.startsWith("..") && !properties.endsWith(".."))
            {
                s = properties;
                if (properties.indexOf("../") < 0)
                {
                    break label0;
                }
            }
            Log.d("AppInvHTTPD", (new StringBuilder()).append(" Ignoring invalid filename: ").append(properties).toString());
            s = null;
        }
        if (s != null)
        {
            properties = new File((new StringBuilder()).append(rootDir).append("/").append(s).toString());
            s = s1;
            if (!properties2.renameTo(properties))
            {
                copyFile(properties2, properties);
                properties2.delete();
                s = s1;
            }
        } else
        {
            properties2.delete();
            Log.e("AppInvHTTPD", "Received content without a file name!");
            s = Boolean.valueOf(true);
        }
_L20:
        if (s.booleanValue())
        {
            s = new NanoHTTPD.Response(this, "200 OK", "text/plain", "NOTOK");
            s.addHeader("Access-Control-Allow-Origin", "*");
            s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
            s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
            s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
            return s;
        } else
        {
            s = new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
            s.addHeader("Access-Control-Allow-Origin", "*");
            s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
            s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
            s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
            return s;
        }
        Log.e("AppInvHTTPD", "Received PUT without content.");
        s = Boolean.valueOf(true);
          goto _L20
        for (s1 = properties.propertyNames(); s1.hasMoreElements(); Log.d("AppInvHTTPD", (new StringBuilder()).append("  HDR: '").append(socket).append("' = '").append(properties.getProperty(socket)).append("'").toString()))
        {
            socket = (String)s1.nextElement();
        }

        for (s1 = properties1.propertyNames(); s1.hasMoreElements(); Log.d("AppInvHTTPD", (new StringBuilder()).append("  PRM: '").append(socket).append("' = '").append(properties1.getProperty(socket)).append("'").toString()))
        {
            socket = (String)s1.nextElement();
        }

        s1 = properties2.propertyNames();
        if (!s1.hasMoreElements()) goto _L22; else goto _L21
_L21:
label1:
        {
            s = (String)s1.nextElement();
            properties = properties2.getProperty(s);
            s1 = properties1.getProperty(s);
            if (!s1.startsWith("..") && !s1.endsWith(".."))
            {
                s = s1;
                if (s1.indexOf("../") < 0)
                {
                    break label1;
                }
            }
            Log.d("AppInvHTTPD", (new StringBuilder()).append(" Ignoring invalid filename: ").append(s1).toString());
            s = null;
        }
        s1 = new File(properties);
        if (s != null) goto _L24; else goto _L23
_L23:
        s1.delete();
_L25:
        Log.d("AppInvHTTPD", (new StringBuilder()).append(" UPLOADED: '").append(s).append("' was at '").append(properties).append("'").toString());
        s = new NanoHTTPD.Response(this, "200 OK", "text/plain", "OK");
        s.addHeader("Access-Control-Allow-Origin", "*");
        s.addHeader("Access-Control-Allow-Headers", "origin, content-type");
        s.addHeader("Access-Control-Allow-Methods", "POST,OPTIONS,GET,HEAD,PUT");
        s.addHeader("Allow", "POST,OPTIONS,GET,HEAD,PUT");
        return s;
_L24:
        properties1 = new File((new StringBuilder()).append(rootDir).append("/").append(s).toString());
        if (!s1.renameTo(properties1))
        {
            copyFile(s1, properties1);
            s1.delete();
        }
        if (true) goto _L25; else goto _L22
_L22:
        return serveFile(s, properties, rootDir, true);
          goto _L17
    }

}
