// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Location, Procedure, WrappedException

public class ProcLocation extends Location
{

    Object args[];
    Procedure proc;

    public ProcLocation(Procedure procedure, Object aobj[])
    {
        proc = procedure;
        args = aobj;
    }

    public Object get(Object obj)
    {
        try
        {
            obj = proc.applyN(args);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrappedException(((Throwable) (obj)));
        }
        return obj;
    }

    public boolean isBound()
    {
        return true;
    }

    public void set(Object obj)
    {
        int i = args.length;
        Object aobj[] = new Object[i + 1];
        aobj[i] = obj;
        System.arraycopy(((Object) (args)), 0, ((Object) (aobj)), 0, i);
        try
        {
            proc.setN(aobj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrappedException(((Throwable) (obj)));
        }
    }
}
