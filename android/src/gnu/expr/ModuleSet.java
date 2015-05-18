// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;


// Referenced classes of package gnu.expr:
//            ModuleManager

public abstract class ModuleSet
{

    public static final String MODULES_MAP = "$ModulesMap$";
    ModuleSet next;

    public ModuleSet()
    {
    }

    public abstract void register(ModuleManager modulemanager);
}
