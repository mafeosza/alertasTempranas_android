// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.appinventor.components.runtime:
//            HandlesEventDispatching, Component

public class EventDispatcher
{
    private static final class EventClosure
    {

        private final String componentId;
        private final String eventName;

        public boolean equals(Object obj)
        {
            if (this != obj)
            {
                if (obj == null || getClass() != obj.getClass())
                {
                    return false;
                }
                obj = (EventClosure)obj;
                if (!componentId.equals(((EventClosure) (obj)).componentId))
                {
                    return false;
                }
                if (!eventName.equals(((EventClosure) (obj)).eventName))
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return eventName.hashCode() * 31 + componentId.hashCode();
        }



        private EventClosure(String s, String s1)
        {
            componentId = s;
            eventName = s1;
        }

    }

    private static final class EventRegistry
    {

        private final HandlesEventDispatching dispatchDelegate;
        private final HashMap eventClosuresMap = new HashMap();


        EventRegistry(HandlesEventDispatching handleseventdispatching)
        {
            dispatchDelegate = handleseventdispatching;
        }
    }


    private static final boolean DEBUG = false;
    private static final Map mapDispatchDelegateToEventRegistry = new HashMap();

    private EventDispatcher()
    {
    }

    private static transient boolean delegateDispatchEvent(HandlesEventDispatching handleseventdispatching, Set set, Component component, Object aobj[])
    {
        boolean flag = false;
        set = set.iterator();
        do
        {
            if (!set.hasNext())
            {
                break;
            }
            EventClosure eventclosure = (EventClosure)set.next();
            if (handleseventdispatching.dispatchEvent(component, eventclosure.componentId, eventclosure.eventName, aobj))
            {
                flag = true;
            }
        } while (true);
        return flag;
    }

    public static transient boolean dispatchEvent(Component component, String s, Object aobj[])
    {
        boolean flag1 = false;
        HandlesEventDispatching handleseventdispatching = component.getDispatchDelegate();
        boolean flag = flag1;
        if (handleseventdispatching.canDispatchEvent(component, s))
        {
            s = (Set)getEventRegistry(handleseventdispatching).eventClosuresMap.get(s);
            flag = flag1;
            if (s != null)
            {
                flag = flag1;
                if (s.size() > 0)
                {
                    flag = delegateDispatchEvent(handleseventdispatching, s, component, aobj);
                }
            }
        }
        return flag;
    }

    private static EventRegistry getEventRegistry(HandlesEventDispatching handleseventdispatching)
    {
        EventRegistry eventregistry1 = (EventRegistry)mapDispatchDelegateToEventRegistry.get(handleseventdispatching);
        EventRegistry eventregistry = eventregistry1;
        if (eventregistry1 == null)
        {
            eventregistry = new EventRegistry(handleseventdispatching);
            mapDispatchDelegateToEventRegistry.put(handleseventdispatching, eventregistry);
        }
        return eventregistry;
    }

    public static String makeFullEventName(String s, String s1)
    {
        return (new StringBuilder()).append(s).append('$').append(s1).toString();
    }

    public static void registerEventForDelegation(HandlesEventDispatching handleseventdispatching, String s, String s1)
    {
        EventRegistry eventregistry = getEventRegistry(handleseventdispatching);
        Set set = (Set)eventregistry.eventClosuresMap.get(s1);
        handleseventdispatching = set;
        if (set == null)
        {
            handleseventdispatching = new HashSet();
            eventregistry.eventClosuresMap.put(s1, handleseventdispatching);
        }
        handleseventdispatching.add(new EventClosure(s, s1));
    }

    public static void removeDispatchDelegate(HandlesEventDispatching handleseventdispatching)
    {
        handleseventdispatching = removeEventRegistry(handleseventdispatching);
        if (handleseventdispatching != null)
        {
            ((EventRegistry) (handleseventdispatching)).eventClosuresMap.clear();
        }
    }

    private static EventRegistry removeEventRegistry(HandlesEventDispatching handleseventdispatching)
    {
        return (EventRegistry)mapDispatchDelegateToEventRegistry.remove(handleseventdispatching);
    }

    public static void unregisterAllEventsForDelegation()
    {
        for (Iterator iterator = mapDispatchDelegateToEventRegistry.values().iterator(); iterator.hasNext(); ((EventRegistry)iterator.next()).eventClosuresMap.clear()) { }
    }

    public static void unregisterEventForDelegation(HandlesEventDispatching handleseventdispatching, String s, String s1)
    {
        handleseventdispatching = (Set)getEventRegistry(handleseventdispatching).eventClosuresMap.get(s1);
        if (handleseventdispatching != null && !handleseventdispatching.isEmpty())
        {
            s1 = new HashSet();
            Iterator iterator = handleseventdispatching.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                EventClosure eventclosure = (EventClosure)iterator.next();
                if (eventclosure.componentId.equals(s))
                {
                    s1.add(eventclosure);
                }
            } while (true);
            s = s1.iterator();
            while (s.hasNext()) 
            {
                handleseventdispatching.remove((EventClosure)s.next());
            }
        }
    }

}
