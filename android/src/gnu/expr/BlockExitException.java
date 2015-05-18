// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;


// Referenced classes of package gnu.expr:
//            ExitExp

class BlockExitException extends RuntimeException
{

    ExitExp exit;
    Object result;

    public BlockExitException(ExitExp exitexp, Object obj)
    {
        exit = exitexp;
        result = obj;
    }
}
