// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            NanoHTTPD

class val.dataLen extends FileInputStream
{

    final NanoHTTPD this$0;
    final long val$dataLen;

    public int available()
        throws IOException
    {
        return (int)val$dataLen;
    }

    (long l)
    {
        this$0 = final_nanohttpd;
        val$dataLen = l;
        super(File.this);
    }
}
