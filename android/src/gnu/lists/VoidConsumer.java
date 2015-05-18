// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            FilterConsumer

public class VoidConsumer extends FilterConsumer
{

    public static VoidConsumer instance = new VoidConsumer();

    public VoidConsumer()
    {
        super(null);
        skipping = true;
    }

    public static VoidConsumer getInstance()
    {
        return instance;
    }

    public boolean ignoring()
    {
        return true;
    }

}
