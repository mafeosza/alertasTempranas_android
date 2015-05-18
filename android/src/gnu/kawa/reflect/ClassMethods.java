// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.GenericProc;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.lists.FString;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import java.util.Vector;

// Referenced classes of package gnu.kawa.reflect:
//            MethodFilter

public class ClassMethods extends Procedure2
{

    public static final ClassMethods classMethods;

    public ClassMethods()
    {
    }

    public static MethodProc apply(ObjectType objecttype, String s, char c, Language language)
    {
        PrimProcedure aprimprocedure[] = getMethods(objecttype, s, c, null, language);
        GenericProc genericproc = null;
        language = null;
        for (int i = 0; i < aprimprocedure.length;)
        {
            PrimProcedure primprocedure = aprimprocedure[i];
            GenericProc genericproc1 = genericproc;
            if (language != null)
            {
                genericproc1 = genericproc;
                if (genericproc == null)
                {
                    genericproc1 = new GenericProc();
                    genericproc1.add(language);
                }
            }
            language = primprocedure;
            if (genericproc1 != null)
            {
                genericproc1.add(language);
            }
            i++;
            genericproc = genericproc1;
        }

        if (genericproc != null)
        {
            genericproc.setName((new StringBuilder()).append(objecttype.getName()).append(".").append(s).toString());
            return genericproc;
        } else
        {
            return language;
        }
    }

    public static MethodProc apply(Procedure procedure, Object obj, Object obj1)
    {
        Object obj2 = obj;
        if (obj instanceof Class)
        {
            obj2 = Type.make((Class)obj);
        }
        if (obj2 instanceof ClassType)
        {
            obj = (ClassType)obj2;
        } else
        if ((obj2 instanceof String) || (obj2 instanceof FString) || (obj2 instanceof Symbol))
        {
            obj = ClassType.make(obj2.toString());
        } else
        {
            throw new WrongType(procedure, 0, null);
        }
        if ((obj1 instanceof String) || (obj1 instanceof FString) || (obj1 instanceof Symbol))
        {
            obj1 = obj1.toString();
            procedure = ((Procedure) (obj1));
            if (!"<init>".equals(obj1))
            {
                procedure = Compilation.mangleName(((String) (obj1)));
            }
            obj1 = apply(((ObjectType) (obj)), ((String) (procedure)), '\0', Language.getDefaultLanguage());
            if (obj1 == null)
            {
                throw new RuntimeException((new StringBuilder()).append("no applicable method named `").append(procedure).append("' in ").append(((ClassType) (obj)).getName()).toString());
            } else
            {
                return ((MethodProc) (obj1));
            }
        } else
        {
            throw new WrongType(procedure, 1, null);
        }
    }

    static String checkName(Expression expression)
    {
        Object obj = null;
        String s = obj;
        if (expression instanceof QuoteExp)
        {
            expression = ((Expression) (((QuoteExp)expression).getValue()));
            if ((expression instanceof FString) || (expression instanceof String))
            {
                s = expression.toString();
            } else
            {
                s = obj;
                if (expression instanceof Symbol)
                {
                    return ((Symbol)expression).getName();
                }
            }
        }
        return s;
    }

    static String checkName(Expression expression, boolean flag)
    {
        Expression expression1;
        Object obj;
        obj = null;
        expression1 = obj;
        if (!(expression instanceof QuoteExp)) goto _L2; else goto _L1
_L1:
        expression = ((Expression) (((QuoteExp)expression).getValue()));
        if (!(expression instanceof FString) && !(expression instanceof String)) goto _L4; else goto _L3
_L3:
        expression = expression.toString();
_L7:
        if (!Compilation.isValidJavaName(expression))
        {
            break; /* Loop/switch isn't completed */
        }
        expression1 = expression;
_L2:
        return expression1;
_L4:
        expression1 = obj;
        if (!(expression instanceof Symbol)) goto _L2; else goto _L5
_L5:
        expression = ((Symbol)expression).getName();
        if (true) goto _L7; else goto _L6
_L6:
        return Compilation.mangleName(expression, flag);
    }

    public static PrimProcedure[] getMethods(ObjectType objecttype, String s, char c, ClassType classtype, Language language)
    {
        Object obj = objecttype;
        if (objecttype == Type.tostring_type)
        {
            obj = Type.string_type;
        }
        PrimProcedure aprimprocedure[];
        int i;
        boolean flag;
        int j;
        boolean flag1;
        if (c == 'P')
        {
            objecttype = null;
        } else
        {
            objecttype = ((ObjectType) (obj));
        }
        objecttype = new MethodFilter(s, 0, 0, classtype, objecttype);
        if (c == 'P' || "<init>".equals(s))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        classtype = new Vector();
        if (flag)
        {
            i = 0;
        } else
        {
            i = 2;
        }
        ((ObjectType) (obj)).getMethods(objecttype, i, classtype);
        if (!flag && (!(obj instanceof ClassType) || ((ClassType)obj).isInterface()))
        {
            Type.pointer_type.getMethods(objecttype, 0, classtype);
        }
        if (flag)
        {
            i = classtype.size();
        } else
        {
            i = removeRedundantMethods(classtype);
        }
        aprimprocedure = new PrimProcedure[i];
        flag1 = false;
        j = i;
        i = ((flag1) ? 1 : 0);
        do
        {
            j--;
            if (j >= 0)
            {
                s = (Method)classtype.elementAt(j);
                objecttype = s;
                if (!flag)
                {
                    objecttype = s;
                    if (s.getDeclaringClass() != obj)
                    {
                        Type type = ((ObjectType) (obj)).getImplementationType();
                        objecttype = s;
                        if (type instanceof ClassType)
                        {
                            objecttype = new Method(s, (ClassType)type);
                        }
                    }
                }
                aprimprocedure[i] = new PrimProcedure(objecttype, c, language);
                i++;
            } else
            {
                return aprimprocedure;
            }
        } while (true);
    }

    private static int removeRedundantMethods(Vector vector)
    {
        int i;
        int j;
        i = vector.size();
        j = 1;
_L6:
        Method method;
        ClassType classtype;
        Type atype[];
        int k;
        int i1;
        if (j >= i)
        {
            break; /* Loop/switch isn't completed */
        }
        method = (Method)vector.elementAt(j);
        classtype = method.getDeclaringClass();
        atype = method.getParameterTypes();
        i1 = atype.length;
        k = 0;
_L2:
        Method method1;
        Type atype1[];
        if (k >= j)
        {
            break MISSING_BLOCK_LABEL_163;
        }
        method1 = (Method)vector.elementAt(k);
        atype1 = method1.getParameterTypes();
        if (i1 == atype1.length)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        k++;
        if (true) goto _L2; else goto _L1
_L1:
        int j1;
        int l = i1;
        do
        {
            j1 = l - 1;
            if (j1 < 0)
            {
                break;
            }
            l = j1;
        } while (atype[j1] == atype1[j1]);
        if (j1 >= 0) goto _L4; else goto _L3
_L3:
        if (classtype.isSubtype(method1.getDeclaringClass()))
        {
            vector.setElementAt(method, k);
        }
        vector.setElementAt(vector.elementAt(i - 1), j);
        i--;
        continue; /* Loop/switch isn't completed */
        j++;
        if (true) goto _L6; else goto _L5
_L5:
        return i;
    }

    public static int selectApplicable(PrimProcedure aprimprocedure[], int i)
    {
        int j = aprimprocedure.length;
        int i1 = 0;
        int j1 = 0;
        int k = 0;
        for (int l = 0; l < j;)
        {
            int k1 = aprimprocedure[l].numArgs();
            int l1 = Procedure.minArgs(k1);
            int i2 = Procedure.maxArgs(k1);
            boolean flag = false;
            if (i < l1)
            {
                j1++;
            } else
            if (i > i2 && i2 >= 0)
            {
                i1++;
            } else
            {
                flag = true;
            }
            if (flag)
            {
                k++;
                l++;
            } else
            {
                PrimProcedure primprocedure = aprimprocedure[j - 1];
                aprimprocedure[j - 1] = aprimprocedure[l];
                aprimprocedure[l] = primprocedure;
                j--;
            }
        }

        if (k > 0)
        {
            return k;
        }
        if (j1 > 0)
        {
            return 0xfff10000;
        }
        return i1 <= 0 ? 0 : 0xfff20000;
    }

    public static long selectApplicable(PrimProcedure aprimprocedure[], Type atype[])
    {
        int k = aprimprocedure.length;
        int l = 0;
        int j = 0;
        for (int i = 0; i < k;)
        {
            int i1 = aprimprocedure[i].isApplicable(atype);
            if (i1 < 0)
            {
                PrimProcedure primprocedure = aprimprocedure[k - 1];
                aprimprocedure[k - 1] = aprimprocedure[i];
                aprimprocedure[i] = primprocedure;
                k--;
            } else
            if (i1 > 0)
            {
                PrimProcedure primprocedure1 = aprimprocedure[l];
                aprimprocedure[l] = aprimprocedure[i];
                aprimprocedure[i] = primprocedure1;
                l++;
                i++;
            } else
            {
                j++;
                i++;
            }
        }

        return ((long)l << 32) + (long)j;
    }

    public Object apply2(Object obj, Object obj1)
    {
        return apply(this, obj, obj1);
    }

    static 
    {
        classMethods = new ClassMethods();
        classMethods.setName("class-methods");
    }
}
