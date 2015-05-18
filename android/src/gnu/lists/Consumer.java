// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


public interface Consumer
    extends Appendable
{

    public abstract Consumer append(char c);

    public abstract Consumer append(CharSequence charsequence);

    public abstract Consumer append(CharSequence charsequence, int i, int j);

    public abstract void endAttribute();

    public abstract void endDocument();

    public abstract void endElement();

    public abstract boolean ignoring();

    public abstract void startAttribute(Object obj);

    public abstract void startDocument();

    public abstract void startElement(Object obj);

    public abstract void write(int i);

    public abstract void write(CharSequence charsequence, int i, int j);

    public abstract void write(String s);

    public abstract void write(char ac[], int i, int j);

    public abstract void writeBoolean(boolean flag);

    public abstract void writeDouble(double d);

    public abstract void writeFloat(float f);

    public abstract void writeInt(int i);

    public abstract void writeLong(long l);

    public abstract void writeObject(Object obj);
}
