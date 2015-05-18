// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.text.Path;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

// Referenced classes of package gnu.kawa.xml:
//            Document, KDocument

private static class key extends SoftReference
{

    static ReferenceQueue queue = new ReferenceQueue();
    Path key;


    public (Path path, KDocument kdocument)
    {
        super(kdocument, queue);
        key = path;
    }
}
