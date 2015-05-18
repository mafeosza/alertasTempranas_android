// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package appinventor.ai_mafeosza.AlertasTempranas;

import com.google.youngandroid.runtime;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package appinventor.ai_mafeosza.AlertasTempranas:
//            Pautas

public class  extends ModuleBody
{

    Object $end;
    final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 2, null, 4097);

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 2)
        {
            return lambda24(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda24(Object obj)
    {
        if (runtime.lookupGlobalVarInCurrentFormEnvironment(Pautas.Lit3, runtime.$Stthe$Mnnull$Mnvalue$St) != Boolean.FALSE)
        {
            return runtime.addGlobalVarToCurrentFormEnvironment(Pautas.Lit3, Boolean.FALSE);
        } else
        {
            return runtime.addGlobalVarToCurrentFormEnvironment(Pautas.Lit4, runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.lookupGlobalVarInCurrentFormEnvironment(Pautas.Lit4, runtime.$Stthe$Mnnull$Mnvalue$St), "", Scheme.applyToArgs.apply4(runtime.lookupGlobalVarInCurrentFormEnvironment(Pautas.Lit14, runtime.$Stthe$Mnnull$Mnvalue$St), obj, "", $end)), Pautas.Lit56, "join"));
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 2)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public ()
    {
    }
}
