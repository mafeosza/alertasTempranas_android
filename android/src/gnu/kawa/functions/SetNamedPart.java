// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Environment;
import gnu.mapping.HasSetter;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure3;
import gnu.mapping.Values;

public class SetNamedPart extends Procedure3
    implements HasSetter
{

    public static final SetNamedPart setNamedPart;

    public SetNamedPart()
    {
    }

    public Object apply3(Object obj, Object obj1, Object obj2)
    {
        Object obj3 = obj;
        if (obj instanceof Namespace)
        {
            obj = (Namespace)obj;
            obj3 = ((Namespace) (obj)).getName();
            if (!((String) (obj3)).startsWith("class:"))
            {
                break MISSING_BLOCK_LABEL_90;
            }
            obj3 = ClassType.make(((String) (obj3)).substring(6));
        }
        obj = obj3;
        if (obj3 instanceof Class)
        {
            obj = (ClassType)Type.make((Class)obj3);
        }
        if (!(obj instanceof ClassType))
        {
            break MISSING_BLOCK_LABEL_117;
        }
        Values values;
        SlotSet.setStaticField(obj, obj1.toString(), obj2);
        values = Values.empty;
        return values;
        obj = ((Namespace) (obj)).getSymbol(obj1.toString());
        Environment.getCurrent();
        Environment.getCurrent().put(((gnu.mapping.Symbol) (obj)), obj2);
        return Values.empty;
        Throwable throwable;
        throwable;
        SlotSet.setField(obj, obj1.toString(), obj2);
        return Values.empty;
    }

    static 
    {
        setNamedPart = new SetNamedPart();
        setNamedPart.setName("setNamedPart");
        setNamedPart.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateSetNamedPart");
    }
}
