// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import java.util.List;

class SetList extends Procedure2
{

    Type elementType;
    List list;

    public SetList(List list1)
    {
        list = list1;
    }

    public Object apply2(Object obj, Object obj1)
    {
        list.set(((Number)obj).intValue(), obj1);
        return Values.empty;
    }
}
