// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.util.Log;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            NanoHTTPD

private class mySocket
    implements Runnable
{

    private Socket mySocket;
    final NanoHTTPD this$0;

    private void decodeHeader(BufferedReader bufferedreader, Properties properties, Properties properties1, Properties properties2)
        throws InterruptedException
    {
        Object obj = bufferedreader.readLine();
        if (obj == null)
        {
            return;
        }
        String s;
        int i;
        obj = new StringTokenizer(((String) (obj)));
        if (!((StringTokenizer) (obj)).hasMoreTokens())
        {
            sendError("400 Bad Request", "BAD REQUEST: Syntax error. Usage: GET /example/file.html");
        }
        properties.put("method", ((StringTokenizer) (obj)).nextToken());
        if (!((StringTokenizer) (obj)).hasMoreTokens())
        {
            sendError("400 Bad Request", "BAD REQUEST: Missing URI. Usage: GET /example/file.html");
        }
        s = ((StringTokenizer) (obj)).nextToken();
        i = s.indexOf('?');
        if (i < 0) goto _L2; else goto _L1
_L1:
        decodeParms(s.substring(i + 1), properties1);
        properties1 = decodePercent(s.substring(0, i));
_L6:
        if (!((StringTokenizer) (obj)).hasMoreTokens()) goto _L4; else goto _L3
_L3:
        obj = bufferedreader.readLine();
_L5:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).trim().length() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = ((String) (obj)).indexOf(':');
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        properties2.put(((String) (obj)).substring(0, i).trim().toLowerCase(), ((String) (obj)).substring(i + 1).trim());
        obj = bufferedreader.readLine();
        if (true) goto _L5; else goto _L4
_L2:
        properties1 = decodePercent(s);
          goto _L6
_L4:
        try
        {
            properties.put("uri", properties1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (BufferedReader bufferedreader)
        {
            sendError("500 Internal Server Error", (new StringBuilder()).append("SERVER INTERNAL ERROR: IOException: ").append(bufferedreader.getMessage()).toString());
        }
        return;
    }

    private void decodeMultipartData(String s, byte abyte0[], BufferedReader bufferedreader, Properties properties, Properties properties1)
        throws InterruptedException
    {
        int ai[] = getBoundaryPositions(abyte0, s.getBytes());
        int i = 1;
        Object obj2 = bufferedreader.readLine();
_L12:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_287;
        }
        if (((String) (obj2)).indexOf(s) == -1)
        {
            sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but next chunk does not start with boundary. Usage: GET /example/file.html");
        }
        int j = i + 1;
        Object obj;
        Object obj3;
        obj3 = new Properties();
        obj = bufferedreader.readLine();
_L2:
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((String) (obj)).trim().length() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = ((String) (obj)).indexOf(':');
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_127;
        }
        ((Properties) (obj3)).put(((String) (obj)).substring(0, i).trim().toLowerCase(), ((String) (obj)).substring(i + 1).trim());
        obj = bufferedreader.readLine();
        if (true) goto _L2; else goto _L1
_L1:
        i = j;
        obj2 = obj;
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj1 = ((Properties) (obj3)).getProperty("content-disposition");
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_171;
        }
        sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but no content-disposition info found. Usage: GET /example/file.html");
        obj1 = new StringTokenizer(((String) (obj1)), "; ");
        obj2 = new Properties();
_L4:
        String s1;
        do
        {
            if (!((StringTokenizer) (obj1)).hasMoreTokens())
            {
                break MISSING_BLOCK_LABEL_288;
            }
            s1 = ((StringTokenizer) (obj1)).nextToken();
            i = s1.indexOf('=');
        } while (i == -1);
        ((Properties) (obj2)).put(s1.substring(0, i).trim().toLowerCase(), s1.substring(i + 1).trim());
        if (true) goto _L4; else goto _L3
_L3:
        s;
        sendError("500 Internal Server Error", (new StringBuilder()).append("SERVER INTERNAL ERROR: IOException: ").append(s.getMessage()).toString());
        return;
        obj1 = ((Properties) (obj2)).getProperty("name");
        s1 = ((String) (obj1)).substring(1, ((String) (obj1)).length() - 1);
        obj1 = "";
        if (((Properties) (obj3)).getProperty("content-type") != null) goto _L6; else goto _L5
_L5:
        obj2 = obj;
        obj3 = obj1;
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj;
        obj3 = obj1;
        if (((String) (obj)).indexOf(s) != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = bufferedreader.readLine();
        obj = obj2;
        if (obj2 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = ((String) (obj2)).indexOf(s);
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_415;
        }
        obj1 = (new StringBuilder()).append(((String) (obj1))).append(((String) (obj2))).toString();
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        obj1 = (new StringBuilder()).append(((String) (obj1))).append(((String) (obj2)).substring(0, i - 2)).toString();
        obj = obj2;
        if (true) goto _L5; else goto _L7
_L6:
        if (j > ai.length)
        {
            sendError("500 Internal Server Error", "Error processing request");
        }
        i = stripMultipartHeaders(abyte0, ai[j - 2]);
        properties1.put(s1, saveTmpFile(abyte0, i, ai[j - 1] - i - 4));
        obj = ((Properties) (obj2)).getProperty("filename");
        obj = ((String) (obj)).substring(1, ((String) (obj)).length() - 1);
_L10:
        obj1 = bufferedreader.readLine();
        obj2 = obj1;
        obj3 = obj;
        if (obj1 == null) goto _L7; else goto _L8
_L8:
        if (((String) (obj1)).indexOf(s) == -1) goto _L10; else goto _L9
_L9:
        obj3 = obj;
        obj2 = obj1;
_L7:
        properties.put(s1, obj3);
        i = j;
        if (true) goto _L12; else goto _L11
_L11:
    }

    private void decodeParms(String s, Properties properties)
        throws InterruptedException
    {
        if (s != null)
        {
            s = new StringTokenizer(s, "&");
            while (s.hasMoreTokens()) 
            {
                String s1 = s.nextToken();
                int i = s1.indexOf('=');
                if (i >= 0)
                {
                    properties.put(decodePercent(s1.substring(0, i)).trim(), decodePercent(s1.substring(i + 1)));
                }
            }
        }
    }

    private String decodePercent(String s)
        throws InterruptedException
    {
        StringBuffer stringbuffer;
        int i;
        char c;
        try
        {
            stringbuffer = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            sendError("400 Bad Request", "BAD REQUEST: Bad percent-encoding.");
            return null;
        }
        i = 0;
_L7:
        if (i >= s.length()) goto _L2; else goto _L1
_L1:
        c = s.charAt(i);
        c;
        JVM INSTR lookupswitch 2: default 125
    //                   37: 86
    //                   43: 65;
           goto _L3 _L4 _L5
_L3:
        stringbuffer.append(c);
        break MISSING_BLOCK_LABEL_128;
_L5:
        stringbuffer.append(' ');
        break MISSING_BLOCK_LABEL_128;
_L4:
        stringbuffer.append((char)Integer.parseInt(s.substring(i + 1, i + 3), 16));
        i += 2;
        break MISSING_BLOCK_LABEL_128;
_L2:
        s = stringbuffer.toString();
        return s;
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private String saveTmpFile(byte abyte0[], int i, int j)
    {
        Object obj = "";
        if (j > 0)
        {
            obj = System.getProperty("java.io.tmpdir");
            try
            {
                obj = File.createTempFile("NanoHTTPD", "", new File(((String) (obj))));
                FileOutputStream fileoutputstream = new FileOutputStream(((File) (obj)));
                fileoutputstream.write(abyte0, i, j);
                fileoutputstream.close();
                obj = ((File) (obj)).getAbsolutePath();
            }
            // Misplaced declaration of an exception variable
            catch (byte abyte0[])
            {
                NanoHTTPD.myErr.println((new StringBuilder()).append("Error: ").append(abyte0.getMessage()).toString());
                return "";
            }
        }
        return ((String) (obj));
    }

    private void sendError(String s, String s1)
        throws InterruptedException
    {
        sendResponse(s, "text/plain", null, new ByteArrayInputStream(s1.getBytes()));
        throw new InterruptedException();
    }

    private void sendResponse(String s, String s1, Properties properties, InputStream inputstream)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        try
        {
            throw new Error("sendResponse(): Status can't be null.");
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        mySocket.close();
_L8:
        return;
_L2:
        OutputStream outputstream;
        PrintWriter printwriter;
        outputstream = mySocket.getOutputStream();
        printwriter = new PrintWriter(outputstream);
        printwriter.print((new StringBuilder()).append("HTTP/1.0 ").append(s).append(" \r\n").toString());
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        printwriter.print((new StringBuilder()).append("Content-Type: ").append(s1).append("\r\n").toString());
        if (properties == null)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        if (properties.getProperty("Date") != null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        printwriter.print((new StringBuilder()).append("Date: ").append(NanoHTTPD.access$300().format(new Date())).append("\r\n").toString());
        if (properties == null)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        String s2;
        for (s = properties.keys(); s.hasMoreElements(); printwriter.print((new StringBuilder()).append(s1).append(": ").append(s2).append("\r\n").toString()))
        {
            s1 = (String)s.nextElement();
            s2 = properties.getProperty(s1);
        }

        printwriter.print("\r\n");
        printwriter.flush();
        if (inputstream == null) goto _L4; else goto _L3
_L3:
        int i;
        i = inputstream.available();
        s = new byte[NanoHTTPD.access$400()];
_L9:
        if (i <= 0) goto _L4; else goto _L5
_L5:
        int j;
        if (i <= NanoHTTPD.access$400())
        {
            break MISSING_BLOCK_LABEL_348;
        }
        j = NanoHTTPD.access$400();
_L10:
        j = inputstream.read(s, 0, j);
        if (j > 0) goto _L6; else goto _L4
_L4:
        outputstream.flush();
        outputstream.close();
        if (inputstream == null) goto _L8; else goto _L7
_L7:
        inputstream.close();
        return;
_L6:
        outputstream.write(s, 0, j);
        i -= j;
          goto _L9
        s;
        return;
        j = i;
          goto _L10
    }

    private int stripMultipartHeaders(byte abyte0[], int i)
    {
        int j = i;
        do
        {
label0:
            {
                i = j;
                if (j < abyte0.length)
                {
                    i = j;
                    if (abyte0[j] != 13)
                    {
                        break label0;
                    }
                    j++;
                    i = j;
                    if (abyte0[j] != 10)
                    {
                        break label0;
                    }
                    j++;
                    i = j;
                    if (abyte0[j] != 13)
                    {
                        break label0;
                    }
                    j++;
                    i = j;
                    if (abyte0[j] != 10)
                    {
                        break label0;
                    }
                    i = j;
                }
                return i + 1;
            }
            j = i + 1;
        } while (true);
    }

    public int[] getBoundaryPositions(byte abyte0[], byte abyte1[])
    {
        int k = 0;
        int l = -1;
        Vector vector = new Vector();
        int i = 0;
        while (i < abyte0.length) 
        {
            int j1;
            if (abyte0[i] == abyte1[k])
            {
                int i1 = l;
                if (k == 0)
                {
                    i1 = i;
                }
                int k1 = k + 1;
                j1 = i;
                l = i1;
                k = k1;
                if (k1 == abyte1.length)
                {
                    vector.addElement(new Integer(i1));
                    k = 0;
                    l = -1;
                    j1 = i;
                }
            } else
            {
                j1 = i - k;
                k = 0;
                l = -1;
            }
            i = j1 + 1;
        }
        abyte0 = new int[vector.size()];
        for (int j = 0; j < abyte0.length; j++)
        {
            abyte0[j] = ((Integer)vector.elementAt(j)).intValue();
        }

        return abyte0;
    }

    public void run()
    {
        byte abyte0[];
        Object obj;
        InputStream inputstream;
        Properties properties;
        Properties properties1;
        Properties properties2;
        Object obj1;
        Object obj2;
        Object obj3;
        NumberFormatException numberformatexception;
        BufferedReader bufferedreader;
        byte abyte1[];
        StringTokenizer stringtokenizer;
        char ac[];
        int i;
        int j;
        int k;
        int l;
        boolean flag;
        long l1;
        long l2;
        try
        {
            inputstream = mySocket.getInputStream();
        }
        catch (IOException ioexception)
        {
            try
            {
                sendError("500 Internal Server Error", (new StringBuilder()).append("SERVER INTERNAL ERROR: IOException: ").append(ioexception.getMessage()).toString());
                return;
            }
            catch (Throwable throwable)
            {
                return;
            }
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
        if (inputstream == null)
        {
            return;
        }
        abyte0 = new byte[8192];
        l = inputstream.read(abyte0, 0, 8192);
        if (l <= 0) goto _L2; else goto _L1
_L1:
        obj1 = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(abyte0, 0, l)));
        obj2 = new Properties();
        properties = new Properties();
        properties1 = new Properties();
        properties2 = new Properties();
        decodeHeader(((BufferedReader) (obj1)), ((Properties) (obj2)), properties, properties1);
        obj1 = ((Properties) (obj2)).getProperty("method");
        obj2 = ((Properties) (obj2)).getProperty("uri");
        l1 = 0x7fffffffffffffffL;
        obj3 = properties1.getProperty("content-length");
        l2 = l1;
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        i = Integer.parseInt(((String) (obj3)));
        l2 = i;
_L24:
        j = 0;
        flag = false;
_L14:
        i = ((flag) ? 1 : 0);
        k = j;
        if (j >= l) goto _L4; else goto _L3
_L3:
        i = j;
        if (abyte0[j] != 13) goto _L6; else goto _L5
_L5:
        j++;
        i = j;
        if (abyte0[j] != 10) goto _L6; else goto _L7
_L7:
        j++;
        i = j;
        if (abyte0[j] != 13) goto _L6; else goto _L8
_L8:
        k = j + 1;
        i = k;
        if (abyte0[k] != 10) goto _L6; else goto _L9
_L9:
        i = 1;
_L4:
        j = k + 1;
        obj3 = new ByteArrayOutputStream();
        if (j >= l) goto _L11; else goto _L10
_L10:
        ((ByteArrayOutputStream) (obj3)).write(abyte0, j, l - j);
          goto _L11
_L17:
        abyte0 = new byte[512];
        i = l;
_L13:
        if (i < 0 || l1 <= 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        j = inputstream.read(abyte0, 0, 512);
        l2 = l1 - (long)j;
        i = j;
        l1 = l2;
        if (j <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        ((ByteArrayOutputStream) (obj3)).write(abyte0, 0, j);
        i = j;
        l1 = l2;
        if (true) goto _L13; else goto _L12
_L6:
        j = i + 1;
          goto _L14
_L26:
        if (i == 0) goto _L16; else goto _L15
_L15:
        l1 = l2;
        if (l2 != 0x7fffffffffffffffL) goto _L17; else goto _L16
_L16:
        l1 = 0L;
          goto _L17
_L12:
        abyte1 = ((ByteArrayOutputStream) (obj3)).toByteArray();
        bufferedreader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(abyte1)));
        if (!((String) (obj1)).equalsIgnoreCase("POST")) goto _L19; else goto _L18
_L18:
        obj = "";
        stringtokenizer = new StringTokenizer(properties1.getProperty("content-type"), "; ");
        if (stringtokenizer.hasMoreTokens())
        {
            obj = stringtokenizer.nextToken();
        }
        if (!((String) (obj)).equalsIgnoreCase("multipart/form-data")) goto _L21; else goto _L20
_L20:
        if (!stringtokenizer.hasMoreTokens())
        {
            sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary missing. Usage: GET /example/file.html");
        }
        obj = new StringTokenizer(stringtokenizer.nextToken(), "=");
        if (((StringTokenizer) (obj)).countTokens() != 2)
        {
            sendError("400 Bad Request", "BAD REQUEST: Content type is multipart/form-data but boundary syntax error. Usage: GET /example/file.html");
        }
        ((StringTokenizer) (obj)).nextToken();
        decodeMultipartData(((StringTokenizer) (obj)).nextToken(), abyte1, bufferedreader, properties, properties2);
_L19:
        if (((String) (obj1)).equalsIgnoreCase("PUT"))
        {
            properties2.put("content", saveTmpFile(abyte1, 0, ((ByteArrayOutputStream) (obj3)).size()));
        }
        obj = serve(((String) (obj2)), ((String) (obj1)), properties1, properties, properties2, mySocket);
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_751;
        }
        sendError("500 Internal Server Error", "SERVER INTERNAL ERROR: Serve() returned a null response.");
_L23:
        bufferedreader.close();
        inputstream.close();
        return;
_L21:
        obj = "";
        ac = new char[512];
        i = bufferedreader.read(ac);
_L22:
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_739;
        }
        if (((String) (obj)).endsWith("\r\n"))
        {
            break MISSING_BLOCK_LABEL_739;
        }
        obj = (new StringBuilder()).append(((String) (obj))).append(String.valueOf(ac, 0, i)).toString();
        i = bufferedreader.read(ac);
          goto _L22
        decodeParms(((String) (obj)).trim(), properties);
          goto _L19
        sendResponse(((sendResponse) (obj)).tus, ((tus) (obj)).eType, ((eType) (obj)).der, ((der) (obj)).a);
          goto _L23
        numberformatexception;
        l2 = l1;
          goto _L24
_L2:
        return;
_L11:
        if (j >= l) goto _L26; else goto _L25
_L25:
        l1 = l2 - (long)((l - j) + 1);
          goto _L17
    }

    public (Socket socket)
    {
        this$0 = NanoHTTPD.this;
        super();
        mySocket = socket;
        Log.d("AppInvHTTPD", (new StringBuilder()).append("NanoHTTPD: getPoolSize() = ").append(NanoHTTPD.access$200(NanoHTTPD.this).getPoolSize()).toString());
        NanoHTTPD.access$200(NanoHTTPD.this).execute(this);
    }
}
