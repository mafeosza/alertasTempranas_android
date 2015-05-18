// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import org.xml.sax.Locator;

public interface SourceLocator
    extends Locator
{

    public abstract int getColumnNumber();

    public abstract String getFileName();

    public abstract int getLineNumber();

    public abstract String getPublicId();

    public abstract String getSystemId();

    public abstract boolean isStableSourceLocation();
}
