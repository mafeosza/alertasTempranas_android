// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import kawa.standard.call_with_values;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class lambda.Fn49 extends ModuleBody
{
    public class srfi1.frame49 extends ModuleBody
    {

        Object a;
        Object b;
        final ModuleMethod lambda$Fn50 = new ModuleMethod(this, 50, null, 0);
        final ModuleMethod lambda$Fn51;
        srfi1.frame48 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 50)
            {
                return lambda67();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 51)
            {
                return lambda68(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda67()
        {
            return srfi1.lsetDiff$PlIntersection$Ex$V(staticLink.$Eq, a, new Object[] {
                b
            });
        }

        Object lambda68(Object obj, Object obj1)
        {
            srfi1.frame50 frame50_1 = new srfi1.frame50();
            frame50_1.staticLink = this;
            frame50_1.a$Mnint$Mnb = obj1;
            if (lists.isNull(obj))
            {
                return srfi1.lsetDifference$Ex$V(staticLink.$Eq, b, new Object[] {
                    a
                });
            }
            if (lists.isNull(frame50_1.a$Mnint$Mnb))
            {
                return srfi1.append$Ex$V(new Object[] {
                    b, a
                });
            } else
            {
                return srfi1.pairFold$V(frame50_1.lambda$Fn52, obj, b, new Object[0]);
            }
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 50)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 51)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            } else
            {
                return super.match2(modulemethod, obj, obj1, callcontext);
            }
        }

        public srfi1.frame49()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 51, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:1565");
            lambda$Fn51 = modulemethod;
        }
    }

    public class srfi1.frame50 extends ModuleBody
    {

        Object a$Mnint$Mnb;
        final ModuleMethod lambda$Fn52;
        srfi1.frame49 staticLink;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 49)
            {
                return lambda69(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda69(Object obj, Object obj1)
        {
            if (lists.member(lists.car.apply1(obj), a$Mnint$Mnb, staticLink.staticLink.$Eq) != Boolean.FALSE)
            {
                return obj1;
            }
            Pair pair;
            try
            {
                pair = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-cdr!", 1, obj);
            }
            lists.setCdr$Ex(pair, obj1);
            return obj;
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 49)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            } else
            {
                return super.match2(modulemethod, obj, obj1, callcontext);
            }
        }

        public srfi1.frame50()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 49, null, 8194);
            modulemethod.setProperty("source-location", "srfi1.scm:1568");
            lambda$Fn52 = modulemethod;
        }
    }


    Procedure $Eq;
    final ModuleMethod lambda$Fn49;

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 52)
        {
            return lambda66(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda66(Object obj, Object obj1)
    {
        lambda66 lambda66_1 = new <init>();
        lambda66_1.staticLink = this;
        lambda66_1.b = obj;
        lambda66_1.a = obj1;
        return call_with_values.callWithValues(lambda66_1.Fn50, lambda66_1.Fn51);
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 52)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return super.match2(modulemethod, obj, obj1, callcontext);
        }
    }

    public lambda.Fn51()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 52, null, 8194);
        modulemethod.setProperty("source-location", "srfi1.scm:1555");
        lambda$Fn49 = modulemethod;
    }
}
