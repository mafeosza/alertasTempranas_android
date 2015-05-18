// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import java.io.IOException;

public interface BitReader
{

    public abstract boolean bit()
        throws IOException;

    public abstract long nrBits();

    public abstract boolean pad(int i)
        throws IOException;

    public abstract int read(int i)
        throws IOException;
}
