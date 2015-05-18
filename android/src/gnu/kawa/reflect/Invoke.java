// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.TypeValue;
import gnu.kawa.lispexpr.ClassNamespace;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.lang.reflect.Array;

// Referenced classes of package gnu.kawa.reflect:
//            CompileInvoke, ClassMethods, SlotSet

public class Invoke extends ProcedureN
{

    public static final Invoke invoke = new Invoke("invoke", '*');
    public static final Invoke invokeSpecial = new Invoke("invoke-special", 'P');
    public static final Invoke invokeStatic = new Invoke("invoke-static", 'S');
    public static final Invoke make = new Invoke("make", 'N');
    char kind;
    Language language;

    public Invoke(String s, char c)
    {
        this(s, c, Language.getDefaultLanguage());
    }

    public Invoke(String s, char c, Language language1)
    {
        super(s);
        kind = c;
        language = language1;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileInvoke:validateApplyInvoke");
    }

    public static PrimProcedure getStaticMethod(ClassType classtype, String s, Expression aexpression[])
    {
        gnu/kawa/reflect/Invoke;
        JVM INSTR monitorenter ;
        classtype = CompileInvoke.getStaticMethod(classtype, s, aexpression);
        gnu/kawa/reflect/Invoke;
        JVM INSTR monitorexit ;
        return classtype;
        classtype;
        throw classtype;
    }

    public static Object invoke$V(Object aobj[])
        throws Throwable
    {
        return invoke.applyN(aobj);
    }

    public static Object invokeStatic$V(Object aobj[])
        throws Throwable
    {
        return invokeStatic.applyN(aobj);
    }

    public static Object make$V(Object aobj[])
        throws Throwable
    {
        return make.applyN(aobj);
    }

    public static ApplyExp makeInvokeStatic(ClassType classtype, String s, Expression aexpression[])
    {
        gnu/kawa/reflect/Invoke;
        JVM INSTR monitorenter ;
        PrimProcedure primprocedure = getStaticMethod(classtype, s, aexpression);
        if (primprocedure != null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        throw new RuntimeException((new StringBuilder()).append("missing or ambiguous method `").append(s).append("' in ").append(classtype.getName()).toString());
        classtype;
        gnu/kawa/reflect/Invoke;
        JVM INSTR monitorexit ;
        throw classtype;
        classtype = new ApplyExp(primprocedure, aexpression);
        gnu/kawa/reflect/Invoke;
        JVM INSTR monitorexit ;
        return classtype;
    }

    private static ObjectType typeFrom(Object obj, Invoke invoke1)
    {
        Object obj1 = obj;
        if (obj instanceof Class)
        {
            obj1 = Type.make((Class)obj);
        }
        if (obj1 instanceof ObjectType)
        {
            return (ObjectType)obj1;
        }
        if ((obj1 instanceof String) || (obj1 instanceof FString))
        {
            return ClassType.make(obj1.toString());
        }
        if (obj1 instanceof Symbol)
        {
            return ClassType.make(((Symbol)obj1).getName());
        }
        if (obj1 instanceof ClassNamespace)
        {
            return ((ClassNamespace)obj1).getClassType();
        } else
        {
            throw new WrongType(invoke1, 0, obj1, "class-specifier");
        }
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object aobj[] = callcontext.getArgs();
        if (kind == 'S' || kind == 'V' || kind == 's' || kind == '*')
        {
            int j = aobj.length;
            Procedure.checkArgCount(this, j);
            Object obj = aobj[0];
            Object aobj1[];
            int i;
            if (kind == 'S' || kind == 's')
            {
                obj = typeFrom(obj, this);
            } else
            {
                obj = Type.make(obj.getClass());
            }
            obj = lookupMethods((ObjectType)obj, aobj[1]);
            if (kind == 'S')
            {
                i = 2;
            } else
            {
                i = 1;
            }
            aobj1 = new Object[j - i];
            i = 0;
            if (kind == 'V' || kind == '*')
            {
                aobj1[0] = aobj[0];
                i = 0 + 1;
            }
            System.arraycopy(((Object) (aobj)), 2, ((Object) (aobj1)), i, j - 2);
            ((Procedure) (obj)).checkN(aobj1, callcontext);
            return;
        } else
        {
            callcontext.writeValue(applyN(aobj));
            return;
        }
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        Object obj;
        Object obj4;
        int i2;
        if (kind == 'P')
        {
            throw new RuntimeException((new StringBuilder()).append(getName()).append(": invoke-special not allowed at run time").toString());
        }
        i2 = aobj.length;
        Procedure.checkArgCount(this, i2);
        obj = aobj[0];
        Procedure procedure;
        int i;
        if (kind != 'V' && kind != '*')
        {
            obj = typeFrom(obj, this);
        } else
        {
            obj = (ObjectType)Type.make(obj.getClass());
        }
        if (kind != 'N') goto _L2; else goto _L1
_L1:
        obj4 = null;
        if (!(obj instanceof TypeValue)) goto _L4; else goto _L3
_L3:
        procedure = ((TypeValue)obj).getConstructor();
        if (procedure == null) goto _L4; else goto _L5
_L5:
        i = i2 - 1;
        obj = ((Object) (new Object[i]));
        System.arraycopy(((Object) (aobj)), 1, obj, 0, i);
        obj = procedure.applyN(((Object []) (obj)));
_L10:
        return obj;
_L4:
        Object obj1;
        obj1 = obj;
        if (obj instanceof PairClassType)
        {
            obj1 = ((PairClassType)obj).instanceType;
        }
        obj = obj1;
        if (!(obj1 instanceof ArrayType)) goto _L7; else goto _L6
_L6:
        Type type;
        int j;
        int i1;
        boolean flag;
        int k2;
        type = ((ArrayType)obj1).getComponentType();
        k2 = aobj.length - 1;
        if (k2 < 2 || !(aobj[1] instanceof Keyword))
        {
            break MISSING_BLOCK_LABEL_389;
        }
        obj = ((Keyword)aobj[1]).getName();
        if (!"length".equals(obj) && !"size".equals(obj))
        {
            break MISSING_BLOCK_LABEL_389;
        }
        i1 = ((Number)aobj[2]).intValue();
        j = 3;
        flag = true;
_L8:
        Object obj2 = Array.newInstance(type.getReflectClass(), i1);
        i1 = 0;
        do
        {
            obj = obj2;
            if (j > k2)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj4 = aobj[j];
            obj = obj4;
            i2 = j;
            int j2 = i1;
            if (flag)
            {
                obj = obj4;
                i2 = j;
                j2 = i1;
                if (obj4 instanceof Keyword)
                {
                    obj = obj4;
                    i2 = j;
                    j2 = i1;
                    if (j < k2)
                    {
                        obj = ((Keyword)obj4).getName();
                        try
                        {
                            j2 = Integer.parseInt(((String) (obj)));
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object aobj[])
                        {
                            throw new RuntimeException((new StringBuilder()).append("non-integer keyword '").append(((String) (obj))).append("' in array constructor").toString());
                        }
                        i2 = j + 1;
                        obj = aobj[i2];
                    }
                }
            }
            Array.set(obj2, j2, type.coerceFromObject(obj));
            i1 = j2 + 1;
            j = i2 + 1;
        } while (true);
        continue; /* Loop/switch isn't completed */
        i1 = k2;
        j = 1;
        flag = false;
          goto _L8
_L2:
        obj4 = aobj[1];
_L7:
        Object obj3;
label0:
        {
            obj4 = lookupMethods(((ObjectType) (obj)), obj4);
            if (kind != 'N')
            {
                int k;
                if (kind == 'S' || kind == 's')
                {
                    k = 2;
                } else
                {
                    k = 1;
                }
                obj = ((Object) (new Object[i2 - k]));
                k = 0;
                if (kind == 'V' || kind == '*')
                {
                    obj[0] = aobj[0];
                    k = 0 + 1;
                }
                System.arraycopy(((Object) (aobj)), 2, obj, k, i2 - 2);
                return ((MethodProc) (obj4)).applyN(((Object []) (obj)));
            }
            obj3 = CallContext.getInstance();
            int l;
            for (l = 0; l < aobj.length && !(aobj[l] instanceof Keyword); l++) { }
            int l1 = -1;
            int k1;
            if (l == aobj.length)
            {
                int j1 = ((MethodProc) (obj4)).matchN(aobj, ((CallContext) (obj3)));
                if (j1 == 0)
                {
                    return ((CallContext) (obj3)).runUntilValue();
                }
                MethodProc methodproc = ClassMethods.apply((ClassType)obj, "valueOf", '\0', language);
                if (methodproc != null)
                {
                    Object aobj1[] = new Object[i2 - 1];
                    System.arraycopy(((Object) (aobj)), 1, ((Object) (aobj1)), 0, i2 - 1);
                    l1 = methodproc.matchN(aobj1, ((CallContext) (obj3)));
                    j1 = l1;
                    if (l1 == 0)
                    {
                        return ((CallContext) (obj3)).runUntilValue();
                    }
                }
                obj3 = ((MethodProc) (obj4)).apply1(aobj[0]);
                l1 = j1;
            } else
            {
                obj3 = ((Object) (new Object[l]));
                System.arraycopy(((Object) (aobj)), 0, obj3, 0, l);
                obj3 = ((MethodProc) (obj4)).applyN(((Object []) (obj3)));
            }
            k1 = l;
label1:
            do
            {
                Object obj5;
label2:
                {
                    if (k1 + 1 < aobj.length)
                    {
                        obj5 = aobj[k1];
                        if (obj5 instanceof Keyword)
                        {
                            break label2;
                        }
                    }
                    if (l == aobj.length)
                    {
                        k1 = 1;
                    }
                    if (k1 == aobj.length)
                    {
                        break label0;
                    }
                    obj = ClassMethods.apply((ClassType)obj, "add", '\0', language);
                    if (obj == null)
                    {
                        throw MethodProc.matchFailAsException(l1, ((Procedure) (obj4)), aobj);
                    }
                    break label1;
                }
                obj5 = (Keyword)obj5;
                Object obj6 = aobj[k1 + 1];
                SlotSet.apply(false, obj3, ((Keyword) (obj5)).getName(), obj6);
                k1 += 2;
            } while (true);
            for (; k1 < aobj.length; k1++)
            {
                ((MethodProc) (obj)).apply2(obj3, aobj[k1]);
            }

        }
        return obj3;
        if (true) goto _L10; else goto _L9
_L9:
    }

    protected MethodProc lookupMethods(ObjectType objecttype, Object obj)
    {
        char c = 'P';
        MethodProc methodproc;
        if (kind == 'N')
        {
            obj = "<init>";
        } else
        {
            if ((obj instanceof String) || (obj instanceof FString))
            {
                obj = obj.toString();
            } else
            if (obj instanceof Symbol)
            {
                obj = ((Symbol)obj).getName();
            } else
            {
                throw new WrongType(this, 1, null);
            }
            obj = Compilation.mangleName(((String) (obj)));
        }
        if (kind != 'P')
        {
            if (kind == '*' || kind == 'V')
            {
                c = 'V';
            } else
            {
                c = '\0';
            }
        }
        methodproc = ClassMethods.apply(objecttype, ((String) (obj)), c, language);
        if (methodproc == null)
        {
            throw new RuntimeException((new StringBuilder()).append(getName()).append(": no method named `").append(((String) (obj))).append("' in class ").append(objecttype.getName()).toString());
        } else
        {
            return methodproc;
        }
    }

    public int numArgs()
    {
        int i;
        if (kind == 'N')
        {
            i = 1;
        } else
        {
            i = 2;
        }
        return i | 0xfffff000;
    }

}
