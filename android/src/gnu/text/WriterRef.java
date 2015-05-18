// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.Writer;
import java.lang.ref.WeakReference;

class WriterRef extends WeakReference
{

    WriterRef next;
    WriterRef prev;

    public WriterRef(Writer writer)
    {
        super(writer);
    }
}
