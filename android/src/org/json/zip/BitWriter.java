// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import java.io.IOException;

public interface BitWriter
{

    public abstract long nrBits();

    public abstract void one()
        throws IOException;

    public abstract void pad(int i)
        throws IOException;

    public abstract void write(int i, int j)
        throws IOException;

    public abstract void zero()
        throws IOException;
}
