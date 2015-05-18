// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


public interface Array
{

    public abstract Object get(int ai[]);

    public abstract int getEffectiveIndex(int ai[]);

    public abstract int getLowBound(int i);

    public abstract Object getRowMajor(int i);

    public abstract int getSize(int i);

    public abstract boolean isEmpty();

    public abstract int rank();

    public abstract Object set(int ai[], Object obj);

    public abstract Array transpose(int ai[], int ai1[], int i, int ai2[]);
}
