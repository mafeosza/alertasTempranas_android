// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Symbol

public interface EnvironmentKey
{

    public static final Object FUNCTION = Symbol.FUNCTION;

    public abstract Object getKeyProperty();

    public abstract Symbol getKeySymbol();

    public abstract boolean matches(EnvironmentKey environmentkey);

    public abstract boolean matches(Symbol symbol, Object obj);

}
