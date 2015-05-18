// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.collect;

import java.util.Collections;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Sets
{

    public Sets()
    {
    }

    public static HashSet newHashSet()
    {
        return new HashSet();
    }

    public static transient HashSet newHashSet(Object aobj[])
    {
        HashSet hashset = new HashSet((aobj.length * 4) / 3 + 1);
        Collections.addAll(hashset, aobj);
        return hashset;
    }

    public static transient SortedSet newSortedSet(Object aobj[])
    {
        TreeSet treeset = new TreeSet();
        Collections.addAll(treeset, aobj);
        return treeset;
    }
}
