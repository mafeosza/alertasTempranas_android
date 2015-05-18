// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            PlayerListDelta

public class GameInstance
{

    private String instanceId;
    private String leader;
    private Map messageTimes;
    private List players;

    public GameInstance(String s)
    {
        players = new ArrayList(0);
        messageTimes = new HashMap();
        instanceId = s;
        leader = "";
    }

    public String getInstanceId()
    {
        return instanceId;
    }

    public String getLeader()
    {
        return leader;
    }

    public String getMessageTime(String s)
    {
        if (messageTimes.containsKey(s))
        {
            return (String)messageTimes.get(s);
        } else
        {
            return "";
        }
    }

    public List getPlayers()
    {
        return players;
    }

    public void putMessageTime(String s, String s1)
    {
        messageTimes.put(s, s1);
    }

    public void setLeader(String s)
    {
        leader = s;
    }

    public PlayerListDelta setPlayers(List list)
    {
        if (list.equals(players))
        {
            return PlayerListDelta.NO_CHANGE;
        }
        List list1 = players;
        ArrayList arraylist = new ArrayList(list);
        players = new ArrayList(list);
        arraylist.removeAll(list1);
        list1.removeAll(list);
        if (arraylist.size() == 0 && list1.size() == 0)
        {
            return PlayerListDelta.NO_CHANGE;
        } else
        {
            return new PlayerListDelta(list1, arraylist);
        }
    }
}
