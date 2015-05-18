// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.util.ArrayList;
import java.util.List;

public class PlayerListDelta
{

    public static PlayerListDelta NO_CHANGE = new PlayerListDelta(new ArrayList(), new ArrayList());
    private List playersAdded;
    private List playersRemoved;

    public PlayerListDelta(List list, List list1)
    {
        playersRemoved = list;
        playersAdded = list1;
    }

    public List getPlayersAdded()
    {
        return playersAdded;
    }

    public List getPlayersRemoved()
    {
        return playersRemoved;
    }

}
