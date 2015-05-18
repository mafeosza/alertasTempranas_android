// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.Type;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure3;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;

public class ArraySet extends Procedure3
    implements Externalizable
{

    Type element_type;

    public ArraySet(Type type)
    {
        element_type = type;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArraySet");
        Procedure.compilerKey.set(this, "*gnu.kawa.reflect.CompileArrays:getForArraySet");
    }

    public Object apply3(Object obj, Object obj1, Object obj2)
    {
        Array.set(obj, ((Number)obj1).intValue(), element_type.coerceFromObject(obj2));
        return Values.empty;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        element_type = (Type)objectinput.readObject();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(element_type);
    }
}
