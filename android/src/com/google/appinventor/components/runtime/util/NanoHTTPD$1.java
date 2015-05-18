// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.io.IOException;
import java.net.ServerSocket;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            NanoHTTPD

class this._cls0
    implements Runnable
{

    final NanoHTTPD this$0;

    public void run()
    {
        do
        {
            try
            {
                new TPSession(NanoHTTPD.this, NanoHTTPD.access$000(NanoHTTPD.this).accept());
            }
            catch (IOException ioexception)
            {
                return;
            }
        } while (true);
    }

    TPSession()
    {
        this$0 = NanoHTTPD.this;
        super();
    }
}
