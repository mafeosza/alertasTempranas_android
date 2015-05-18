// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;

// Referenced classes of package kawa.lang:
//            GenericError

public class RecordConstructor extends ProcedureN
{

    Field fields[];
    ClassType type;

    public RecordConstructor(ClassType classtype)
    {
        init(classtype);
    }

    public RecordConstructor(ClassType classtype, Object obj)
    {
        type = classtype;
        if (obj != null) goto _L2; else goto _L1
_L1:
        init(classtype);
_L4:
        return;
_L2:
        Field field;
        int i;
        int j;
        j = LList.listLength(obj, false);
        fields = new Field[j];
        field = classtype.getFields();
        i = 0;
_L5:
        if (i >= j) goto _L4; else goto _L3
_L3:
        Pair pair;
        String s;
        pair = (Pair)obj;
        s = pair.getCar().toString();
        obj = field;
_L6:
label0:
        {
            if (obj == null)
            {
                throw new RuntimeException((new StringBuilder()).append("no such field ").append(s).append(" in ").append(classtype.getName()).toString());
            }
            if (((Field) (obj)).getSourceName() != s)
            {
                break label0;
            }
            fields[i] = ((Field) (obj));
            obj = pair.getCdr();
            i++;
        }
          goto _L5
          goto _L4
        obj = ((Field) (obj)).getNext();
          goto _L6
    }

    public RecordConstructor(ClassType classtype, Field afield[])
    {
        type = classtype;
        fields = afield;
    }

    public RecordConstructor(Class class1)
    {
        init((ClassType)Type.make(class1));
    }

    public RecordConstructor(Class class1, Object obj)
    {
        this((ClassType)Type.make(class1), obj);
    }

    public RecordConstructor(Class class1, Field afield[])
    {
        this((ClassType)Type.make(class1), afield);
    }

    private void init(ClassType classtype)
    {
        type = classtype;
        classtype = classtype.getFields();
        int i = 0;
        for (Object obj = classtype; obj != null;)
        {
            int j = i;
            if ((((Field) (obj)).getModifiers() & 9) == 1)
            {
                j = i + 1;
            }
            obj = ((Field) (obj)).getNext();
            i = j;
        }

        fields = new Field[i];
        i = 0;
        for (; classtype != null; classtype = classtype.getNext())
        {
            if ((classtype.getModifiers() & 9) == 1)
            {
                Field afield[] = fields;
                int k = i + 1;
                afield[i] = classtype;
                i = k;
            }
        }

    }

    public Object applyN(Object aobj[])
    {
        Object obj;
        try
        {
            obj = type.getReflectClass().newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new GenericError(((InstantiationException) (aobj)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new GenericError(((IllegalAccessException) (aobj)).toString());
        }
        if (aobj.length != fields.length)
        {
            throw new WrongArguments(this, aobj.length);
        }
        int i = 0;
        while (i < aobj.length) 
        {
            Field field = fields[i];
            try
            {
                field.getReflectField().set(obj, aobj[i]);
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrappedException((new StringBuilder()).append("illegal access for field ").append(field.getName()).toString(), ((Throwable) (aobj)));
            }
            i++;
        }
        return obj;
    }

    public String getName()
    {
        return (new StringBuilder()).append(type.getName()).append(" constructor").toString();
    }

    public int numArgs()
    {
        int i = fields.length;
        return i << 12 | i;
    }
}
