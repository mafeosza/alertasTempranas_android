// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Environment, SimpleEnvironment

static class  extends InheritableThreadLocal
{

    protected Environment childValue(Environment environment)
    {
        Environment environment1 = environment;
        if (environment == null)
        {
            environment1 = Environment.getCurrent();
        }
        environment = environment1.cloneForThread();
        environment.flags = ((SimpleEnvironment) (environment)).flags | 8;
        environment.flags = ((SimpleEnvironment) (environment)).flags & 0xffffffef;
        return environment;
    }

    protected volatile Object childValue(Object obj)
    {
        return childValue((Environment)obj);
    }

    ()
    {
    }
}
