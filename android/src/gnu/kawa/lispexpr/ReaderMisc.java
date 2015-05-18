// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;


// Referenced classes of package gnu.kawa.lispexpr:
//            ReadTableEntry

public class ReaderMisc extends ReadTableEntry
{

    int kind;

    public ReaderMisc(int i)
    {
        kind = i;
    }

    public int getKind()
    {
        return kind;
    }
}
