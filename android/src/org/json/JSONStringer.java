// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.io.StringWriter;

// Referenced classes of package org.json:
//            JSONWriter

public class JSONStringer extends JSONWriter
{

    public JSONStringer()
    {
        super(new StringWriter());
    }

    public String toString()
    {
        if (mode == 'd')
        {
            return writer.toString();
        } else
        {
            return null;
        }
    }
}
