// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.IOException;

// Referenced classes of package gnu.lists:
//            Sequence, Consumer

public interface CharSeq
    extends CharSequence, Sequence
{

    public abstract char charAt(int i);

    public abstract void consume(int i, int j, Consumer consumer);

    public abstract void fill(char c);

    public abstract void fill(int i, int j, char c);

    public abstract void getChars(int i, int j, char ac[], int k);

    public abstract int length();

    public abstract void setCharAt(int i, char c);

    public abstract CharSequence subSequence(int i, int j);

    public abstract String toString();

    public abstract void writeTo(int i, int j, Appendable appendable)
        throws IOException;

    public abstract void writeTo(Appendable appendable)
        throws IOException;
}
