// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            Filter, ClassType, Method

static class 
    implements Filter
{

    public static final  instance = new <init>();

    public boolean select(Object obj)
    {
        return ((Method)obj).isAbstract();
    }


    ()
    {
    }
}
