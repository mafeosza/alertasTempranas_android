// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Filter;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;

class MethodFilter
    implements Filter
{

    ClassType caller;
    int modifiers;
    int modmask;
    String name;
    int nlen;
    ObjectType receiver;

    public MethodFilter(String s, int i, int j, ClassType classtype, ObjectType objecttype)
    {
        name = s;
        nlen = s.length();
        modifiers = i;
        modmask = j;
        caller = classtype;
        receiver = objecttype;
    }

    public boolean select(Object obj)
    {
        Method method;
        int i;
        method = (Method)obj;
        obj = method.getName();
        i = method.getModifiers();
        if ((modmask & i) == modifiers && (i & 0x1000) == 0 && ((String) (obj)).startsWith(name)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        i = ((String) (obj)).length();
        if (i == nlen)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i != nlen + 2 || ((String) (obj)).charAt(nlen) != '$')
        {
            continue; /* Loop/switch isn't completed */
        }
        char c = ((String) (obj)).charAt(nlen + 1);
        if (c == 'V' || c == 'X')
        {
            break; /* Loop/switch isn't completed */
        }
        if (i != nlen + 4 || !((String) (obj)).endsWith("$V$X")) goto _L1; else goto _L3
_L3:
        boolean flag;
        if (receiver instanceof ClassType)
        {
            obj = (ClassType)receiver;
        } else
        {
            obj = method.getDeclaringClass();
        }
        if (caller == null || caller.isAccessible(((ClassType) (obj)), receiver, method.getModifiers()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }
}
