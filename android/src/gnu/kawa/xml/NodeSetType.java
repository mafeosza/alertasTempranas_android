// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.Type;
import gnu.kawa.reflect.OccurrenceType;

public class NodeSetType extends OccurrenceType
{

    public NodeSetType(Type type)
    {
        super(type, 0, -1);
    }

    public static Type getInstance(Type type)
    {
        return new NodeSetType(type);
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append("node-set").toString();
    }
}
