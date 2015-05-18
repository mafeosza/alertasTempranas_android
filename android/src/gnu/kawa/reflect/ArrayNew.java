// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.Type;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;

public class ArrayNew extends Procedure1
    implements Externalizable
{

    Type element_type;

    public ArrayNew(Type type)
    {
        element_type = type;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileArrays:validateArrayNew");
        Procedure.compilerKey.set(this, "*gnu.kawa.reflect.CompileArrays:getForArrayNew");
    }

    public Object apply1(Object obj)
    {
        return Array.newInstance(element_type.getImplementationType().getReflectClass(), ((Number)obj).intValue());
    }

    public boolean isSideEffectFree()
    {
        return true;
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
