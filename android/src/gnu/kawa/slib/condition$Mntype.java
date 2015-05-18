// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;


// Referenced classes of package gnu.kawa.slib:
//            conditions

public class all.Mnfields
{

    public Object all$Mnfields;
    public Object fields;
    public Object name;
    public Object supertype;

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer("#<condition-type ");
        stringbuffer.append(name);
        stringbuffer.append(">");
        return stringbuffer.toString();
    }

    public (Object obj, Object obj1, Object obj2, Object obj3)
    {
        name = obj;
        supertype = obj1;
        fields = obj2;
        all$Mnfields = obj3;
    }
}
