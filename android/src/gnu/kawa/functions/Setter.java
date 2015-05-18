// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import java.util.List;

// Referenced classes of package gnu.kawa.functions:
//            SetList, SetArray

public class Setter extends Procedure1
    implements HasSetter
{

    public static final Setter setter;

    public Setter()
    {
    }

    public static Object setter(Procedure procedure)
    {
        return procedure.getSetter();
    }

    public Object apply1(Object obj)
    {
        if (!(obj instanceof Procedure))
        {
            if (obj instanceof List)
            {
                return new SetList((List)obj);
            }
            if (obj.getClass().isArray())
            {
                return new SetArray(obj, Language.getDefaultLanguage());
            }
        }
        return ((Procedure)obj).getSetter();
    }

    public void set1(Object obj, Object obj1)
        throws Throwable
    {
        ((Procedure)obj).setSetter((Procedure)obj1);
    }

    static 
    {
        setter = new Setter();
        setter.setName("setter");
        setter.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompilationHelpers:validateSetter");
    }
}
