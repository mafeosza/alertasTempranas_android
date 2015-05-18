// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;


// Referenced classes of package gnu.expr:
//            ApplyExp, Compilation, Target

public interface Inlineable
{

    public abstract void compile(ApplyExp applyexp, Compilation compilation, Target target);
}
