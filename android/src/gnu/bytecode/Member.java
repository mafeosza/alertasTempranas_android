// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            ClassType

public interface Member
{

    public abstract ClassType getDeclaringClass();

    public abstract int getModifiers();

    public abstract String getName();

    public abstract boolean getStaticFlag();

    public abstract void setName(String s);
}
