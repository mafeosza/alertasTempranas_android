// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;


// Referenced classes of package kawa.lang:
//            TemplateScope

public interface SyntaxForm
{

    public abstract Object getDatum();

    public abstract TemplateScope getScope();
}
