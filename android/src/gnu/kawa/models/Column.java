// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import java.io.Serializable;

// Referenced classes of package gnu.kawa.models:
//            Box, Viewable

public class Column extends Box
    implements Viewable, Serializable
{

    public Column()
    {
    }

    public int getAxis()
    {
        return 1;
    }
}
