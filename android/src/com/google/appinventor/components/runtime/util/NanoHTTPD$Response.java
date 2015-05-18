// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            NanoHTTPD

public class data
{

    public InputStream data;
    public Properties header;
    public String mimeType;
    public String status;
    final NanoHTTPD this$0;

    public void addHeader(String s, String s1)
    {
        header.put(s, s1);
    }

    public ()
    {
        this$0 = NanoHTTPD.this;
        super();
        header = new Properties();
        status = "200 OK";
    }

    public status(String s, String s1, InputStream inputstream)
    {
        this$0 = NanoHTTPD.this;
        super();
        header = new Properties();
        status = s;
        mimeType = s1;
        data = inputstream;
    }

    public data(String s, String s1, String s2)
    {
        this$0 = NanoHTTPD.this;
        super();
        header = new Properties();
        status = s;
        mimeType = s1;
        try
        {
            data = new ByteArrayInputStream(s2.getBytes("UTF-8"));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (NanoHTTPD nanohttpd)
        {
            printStackTrace();
        }
    }
}
