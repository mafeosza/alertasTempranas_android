// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

// Referenced classes of package gnu.text:
//            SourceMessages

public class Options
{
    public static final class OptionInfo
    {

        Object defaultValue;
        String documentation;
        String key;
        int kind;
        OptionInfo next;

        public OptionInfo()
        {
        }
    }


    public static final int BOOLEAN_OPTION = 1;
    public static final int STRING_OPTION = 2;
    public static final String UNKNOWN = "unknown option name";
    OptionInfo first;
    HashMap infoTable;
    OptionInfo last;
    Options previous;
    HashMap valueTable;

    public Options()
    {
    }

    public Options(Options options)
    {
        previous = options;
    }

    private void error(String s, SourceMessages sourcemessages)
    {
        if (sourcemessages == null)
        {
            throw new RuntimeException(s);
        } else
        {
            sourcemessages.error('e', s);
            return;
        }
    }

    static Object valueOf(OptionInfo optioninfo, String s)
    {
label0:
        {
            Object obj = s;
            if ((optioninfo.kind & 1) != 0)
            {
                if (s != null && !s.equals("1") && !s.equals("on") && !s.equals("yes") && !s.equals("true"))
                {
                    break label0;
                }
                obj = Boolean.TRUE;
            }
            return obj;
        }
        if (s.equals("0") || s.equals("off") || s.equals("no") || s.equals("false"))
        {
            return Boolean.FALSE;
        } else
        {
            return null;
        }
    }

    public OptionInfo add(String s, int i, Object obj, String s1)
    {
        OptionInfo optioninfo;
        if (infoTable == null)
        {
            infoTable = new HashMap();
        } else
        if (infoTable.get(s) != null)
        {
            throw new RuntimeException((new StringBuilder()).append("duplicate option key: ").append(s).toString());
        }
        optioninfo = new OptionInfo();
        optioninfo.key = s;
        optioninfo.kind = i;
        optioninfo.defaultValue = obj;
        optioninfo.documentation = s1;
        if (first == null)
        {
            first = optioninfo;
        } else
        {
            last.next = optioninfo;
        }
        last = optioninfo;
        infoTable.put(s, optioninfo);
        return optioninfo;
    }

    public OptionInfo add(String s, int i, String s1)
    {
        return add(s, i, null, s1);
    }

    public Object get(OptionInfo optioninfo)
    {
        return get(optioninfo, null);
    }

    public Object get(OptionInfo optioninfo, Object obj)
    {
        Options options = this;
        Object obj1 = obj;
        for (obj = options; obj != null; obj = ((Options) (obj)).previous)
        {
            OptionInfo optioninfo1 = optioninfo;
            do
            {
                Object obj2;
                if (((Options) (obj)).valueTable == null)
                {
                    obj2 = null;
                } else
                {
                    obj2 = ((Options) (obj)).valueTable.get(optioninfo1.key);
                }
                if (obj2 != null)
                {
                    return obj2;
                }
                if (!(optioninfo1.defaultValue instanceof OptionInfo))
                {
                    break;
                }
                optioninfo1 = (OptionInfo)optioninfo1.defaultValue;
            } while (true);
            if (optioninfo1.defaultValue != null)
            {
                obj1 = optioninfo1.defaultValue;
            }
        }

        return obj1;
    }

    public Object get(String s, Object obj)
    {
        OptionInfo optioninfo = getInfo(s);
        if (optioninfo == null)
        {
            throw new RuntimeException((new StringBuilder()).append("invalid option key: ").append(s).toString());
        } else
        {
            return get(optioninfo, obj);
        }
    }

    public boolean getBoolean(OptionInfo optioninfo)
    {
        optioninfo = ((OptionInfo) (get(optioninfo, null)));
        if (optioninfo == null)
        {
            return false;
        } else
        {
            return ((Boolean)optioninfo).booleanValue();
        }
    }

    public boolean getBoolean(OptionInfo optioninfo, boolean flag)
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = Boolean.TRUE;
        } else
        {
            boolean1 = Boolean.FALSE;
        }
        return ((Boolean)get(optioninfo, boolean1)).booleanValue();
    }

    public boolean getBoolean(String s)
    {
        return ((Boolean)get(s, Boolean.FALSE)).booleanValue();
    }

    public boolean getBoolean(String s, boolean flag)
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = Boolean.TRUE;
        } else
        {
            boolean1 = Boolean.FALSE;
        }
        return ((Boolean)get(s, boolean1)).booleanValue();
    }

    public String getDoc(String s)
    {
        OptionInfo optioninfo = getInfo(s);
        if (s == null)
        {
            return null;
        } else
        {
            return optioninfo.documentation;
        }
    }

    public OptionInfo getInfo(String s)
    {
        OptionInfo optioninfo;
        OptionInfo optioninfo1;
        if (infoTable == null)
        {
            optioninfo = null;
        } else
        {
            optioninfo = (OptionInfo)infoTable.get(s);
        }
        optioninfo1 = optioninfo;
        if (optioninfo == null)
        {
            optioninfo1 = optioninfo;
            if (previous != null)
            {
                optioninfo1 = previous.getInfo(s);
            }
        }
        return (OptionInfo)optioninfo1;
    }

    public Object getLocal(String s)
    {
        if (valueTable == null)
        {
            return null;
        } else
        {
            return valueTable.get(s);
        }
    }

    public ArrayList keys()
    {
        ArrayList arraylist = new ArrayList();
label0:
        for (Options options = this; options != null; options = options.previous)
        {
            if (options.infoTable == null)
            {
                continue;
            }
            Iterator iterator = options.infoTable.keySet().iterator();
            do
            {
                String s;
                do
                {
                    if (!iterator.hasNext())
                    {
                        continue label0;
                    }
                    s = (String)iterator.next();
                } while (arraylist.contains(s));
                arraylist.add(s);
            } while (true);
        }

        return arraylist;
    }

    public void popOptionValues(Vector vector)
    {
        int i = vector.size();
        do
        {
            i -= 3;
            if (i >= 0)
            {
                String s = (String)vector.elementAt(i);
                Object obj = vector.elementAt(i + 1);
                vector.setElementAt(null, i + 1);
                reset(s, obj);
            } else
            {
                return;
            }
        } while (true);
    }

    public void pushOptionValues(Vector vector)
    {
        int j = vector.size();
        for (int i = 0; i < j; i++)
        {
            int k = i + 1;
            String s = (String)vector.elementAt(i);
            Object obj = vector.elementAt(k);
            i = k + 1;
            vector.setElementAt(obj, k);
            set(s, vector.elementAt(i));
        }

    }

    public void reset(String s, Object obj)
    {
        if (valueTable == null)
        {
            valueTable = new HashMap();
        }
        if (obj == null)
        {
            valueTable.remove(s);
            return;
        } else
        {
            valueTable.put(s, obj);
            return;
        }
    }

    public String set(String s, String s1)
    {
        OptionInfo optioninfo = getInfo(s);
        if (optioninfo == null)
        {
            return "unknown option name";
        }
        s1 = ((String) (valueOf(optioninfo, s1)));
        if (s1 == null && (optioninfo.kind & 1) != 0)
        {
            return (new StringBuilder()).append("value of option ").append(s).append(" must be yes/no/true/false/on/off/1/0").toString();
        }
        if (valueTable == null)
        {
            valueTable = new HashMap();
        }
        valueTable.put(s, s1);
        return null;
    }

    public void set(String s, Object obj)
    {
        set(s, obj, null);
    }

    public void set(String s, Object obj, SourceMessages sourcemessages)
    {
        Object obj2 = getInfo(s);
        if (obj2 == null)
        {
            error((new StringBuilder()).append("invalid option key: ").append(s).toString(), sourcemessages);
            return;
        }
        if ((((OptionInfo) (obj2)).kind & 1) != 0)
        {
            Object obj1 = obj;
            if (obj instanceof String)
            {
                obj1 = valueOf(((OptionInfo) (obj2)), (String)obj);
            }
            obj2 = obj1;
            if (!(obj1 instanceof Boolean))
            {
                error((new StringBuilder()).append("value for option ").append(s).append(" must be boolean or yes/no/true/false/on/off/1/0").toString(), sourcemessages);
                return;
            }
        } else
        {
            obj2 = obj;
            if (obj == null)
            {
                obj2 = "";
            }
        }
        if (valueTable == null)
        {
            valueTable = new HashMap();
        }
        valueTable.put(s, obj2);
    }
}
