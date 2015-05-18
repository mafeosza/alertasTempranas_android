// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            Consumer

public interface XConsumer
    extends Consumer
{

    public abstract void beginEntity(Object obj);

    public abstract void endEntity();

    public abstract void writeCDATA(char ac[], int i, int j);

    public abstract void writeComment(char ac[], int i, int j);

    public abstract void writeProcessingInstruction(String s, char ac[], int i, int j);
}
