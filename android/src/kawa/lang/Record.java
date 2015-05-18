// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrappedException;
import java.io.PrintWriter;
import java.util.Vector;

// Referenced classes of package kawa.lang:
//            GenericError

public class Record
{

    public Record()
    {
    }

    static java.lang.reflect.Field getField(Class class1, String s)
        throws NoSuchFieldException
    {
        class1 = ((ClassType)Type.make(class1)).getFields();
_L3:
        if (class1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
          goto _L1
_L5:
        class1 = class1.getNext();
        if (true) goto _L3; else goto _L2
_L1:
        if ((class1.getModifiers() & 9) != 1 || !class1.getSourceName().equals(s)) goto _L5; else goto _L4
_L4:
        return class1.getReflectField();
_L2:
        throw new NoSuchFieldException();
    }

    public static boolean isRecord(Object obj)
    {
        return obj instanceof Record;
    }

    public static ClassType makeRecordType(String s, LList llist)
    {
        Object obj1 = ClassType.make("kawa.lang.Record");
        String s1 = Compilation.mangleNameIfNeeded(s);
        ClassType classtype = new ClassType(s1);
        classtype.setSuper(((ClassType) (obj1)));
        classtype.setModifiers(33);
        Object obj = classtype.addMethod("<init>", Type.typeArray0, Type.voidType, 1);
        obj1 = ((ClassType) (obj1)).addMethod("<init>", Type.typeArray0, Type.voidType, 1);
        obj = ((Method) (obj)).startCode();
        ((CodeAttr) (obj)).emitPushThis();
        ((CodeAttr) (obj)).emitInvokeSpecial(((Method) (obj1)));
        ((CodeAttr) (obj)).emitReturn();
        obj = llist;
        if (!s.equals(s1))
        {
            obj = classtype.addMethod("getTypeName", Type.typeArray0, Compilation.typeString, 1).startCode();
            ((CodeAttr) (obj)).emitPushString(s);
            ((CodeAttr) (obj)).emitReturn();
            obj = llist;
        }
        for (; obj != LList.Empty; obj = (LList)s.getCdr())
        {
            s = (Pair)obj;
            llist = s.getCar().toString();
            classtype.addField(Compilation.mangleNameIfNeeded(llist), Type.pointer_type, 1).setSourceName(llist.intern());
        }

        s = classtype.writeToArray();
        s = new ArrayClassLoader(new String[] {
            s1
        }, new byte[][] {
            s
        });
        try
        {
            Type.registerTypeForClass(s.loadClass(s1), classtype);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new InternalError(s.toString());
        }
        return classtype;
    }

    public static Object set1(Object obj, String s, Object obj1)
    {
        Class class1 = obj.getClass();
        Object obj2;
        try
        {
            java.lang.reflect.Field field = getField(class1, s);
            obj2 = field.get(obj);
            field.set(obj, obj1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new GenericError((new StringBuilder()).append("no such field ").append(s).append(" in ").append(class1.getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new GenericError((new StringBuilder()).append("illegal access for field ").append(s).toString());
        }
        return obj2;
    }

    public static LList typeFieldNames(ClassType classtype)
    {
        return typeFieldNames(classtype.getReflectClass());
    }

    public static LList typeFieldNames(Class class1)
    {
        LList llist = LList.Empty;
        class1 = ((ClassType)Type.make(class1)).getFields();
        Vector vector = new Vector(100);
        for (; class1 != null; class1 = class1.getNext())
        {
            if ((class1.getModifiers() & 9) == 1)
            {
                vector.addElement(SimpleSymbol.valueOf(class1.getSourceName()));
            }
        }

        int i = vector.size();
        class1 = llist;
        do
        {
            i--;
            if (i >= 0)
            {
                class1 = new Pair(vector.elementAt(i), class1);
            } else
            {
                return class1;
            }
        } while (true);
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            Object obj1 = getClass();
            if (obj == null || obj.getClass() != obj1)
            {
                return false;
            }
            obj1 = ((ClassType)Type.make(((Class) (obj1)))).getFields();
            while (obj1 != null) 
            {
                if ((((Field) (obj1)).getModifiers() & 9) == 1)
                {
                    Object obj2;
                    Object obj3;
                    try
                    {
                        obj3 = ((Field) (obj1)).getReflectField();
                        obj2 = ((java.lang.reflect.Field) (obj3)).get(this);
                        obj3 = ((java.lang.reflect.Field) (obj3)).get(obj);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrappedException(((Throwable) (obj)));
                    }
                    if (!obj2.equals(obj3))
                    {
                        return false;
                    }
                }
                obj1 = ((Field) (obj1)).getNext();
            }
        }
        return true;
    }

    public Object get(String s, Object obj)
    {
        obj = getClass();
        Object obj1;
        try
        {
            obj1 = getField(((Class) (obj)), s).get(this);
        }
        catch (NoSuchFieldException nosuchfieldexception)
        {
            throw new GenericError((new StringBuilder()).append("no such field ").append(s).append(" in ").append(((Class) (obj)).getName()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new GenericError((new StringBuilder()).append("illegal access for field ").append(s).toString());
        }
        return obj1;
    }

    public String getTypeName()
    {
        return getClass().getName();
    }

    public int hashCode()
    {
        java.lang.reflect.Field afield[];
        int i;
        int j;
        afield = getClass().getFields();
        j = 12345;
        i = 0;
_L2:
        Object obj;
        if (i >= afield.length)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = afield[i];
        obj = ((java.lang.reflect.Field) (obj)).get(this);
        int k;
        k = j;
        if (obj != null)
        {
            k = j ^ obj.hashCode();
        }
_L3:
        i++;
        j = k;
        if (true) goto _L2; else goto _L1
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        k = j;
          goto _L3
_L1:
        return j;
    }

    public void print(PrintWriter printwriter)
    {
        printwriter.print(toString());
    }

    public Object put(String s, Object obj)
    {
        return set1(this, s, obj);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(200);
        stringbuffer.append("#<");
        stringbuffer.append(getTypeName());
        Field field = ((ClassType)Type.make(getClass())).getFields();
        while (field != null) 
        {
            if ((field.getModifiers() & 9) == 1)
            {
                Object obj;
                try
                {
                    obj = field.getReflectField().get(this);
                }
                catch (Exception exception)
                {
                    exception = "#<illegal-access>";
                }
                stringbuffer.append(' ');
                stringbuffer.append(field.getSourceName());
                stringbuffer.append(": ");
                stringbuffer.append(obj);
            }
            field = field.getNext();
        }
        stringbuffer.append(">");
        return stringbuffer.toString();
    }
}
