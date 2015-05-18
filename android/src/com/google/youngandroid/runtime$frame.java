// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.youngandroid;

import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.util.PropertyUtil;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Format;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;

// Referenced classes of package com.google.youngandroid:
//            runtime

public class lambda.Fn1 extends ModuleBody
{

    Object component$Mnname;
    Object component$Mnto$Mnadd;
    Object existing$Mncomponent;
    Object init$Mnprops$Mnthunk;
    final ModuleMethod lambda$Fn1;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 1)
        {
            return lambda1();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    Object lambda1()
    {
        if (init$Mnprops$Mnthunk != Boolean.FALSE)
        {
            Scheme.applyToArgs.apply1(init$Mnprops$Mnthunk);
        }
        if (existing$Mncomponent != Boolean.FALSE)
        {
            runtime.androidLog(Format.formatToString(0, new Object[] {
                "Copying component properties for ~A", component$Mnname
            }));
            Object obj = existing$Mncomponent;
            Component component;
            Component component1;
            try
            {
                component = (Component)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "com.google.appinventor.components.runtime.util.PropertyUtil.copyComponentProperties(com.google.appinventor.components.runtime.Component,com.google.appinventor.components.runtime.Component)", 1, obj);
            }
            obj = component$Mnto$Mnadd;
            try
            {
                component1 = (Component)obj;
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "com.google.appinventor.components.runtime.util.PropertyUtil.copyComponentProperties(com.google.appinventor.components.runtime.Component,com.google.appinventor.components.runtime.Component)", 2, obj);
            }
            return PropertyUtil.copyComponentProperties(component, component1);
        } else
        {
            return Values.empty;
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public ime.util.PropertyUtil()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 0);
        modulemethod.setProperty("source-location", "/tmp/runtime2895667505349593926.scm:94");
        lambda$Fn1 = modulemethod;
    }
}
