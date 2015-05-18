// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;

// Referenced classes of package gnu.bytecode:
//            ClassType

public class ArrayClassLoader extends ClassLoader
{

    Hashtable cmap;
    URL context;
    Hashtable map;

    public ArrayClassLoader()
    {
        map = new Hashtable(100);
        cmap = new Hashtable(100);
    }

    public ArrayClassLoader(ClassLoader classloader)
    {
        super(classloader);
        map = new Hashtable(100);
        cmap = new Hashtable(100);
    }

    public ArrayClassLoader(String as[], byte abyte0[][])
    {
        map = new Hashtable(100);
        cmap = new Hashtable(100);
        int i = abyte0.length;
        do
        {
            i--;
            if (i >= 0)
            {
                addClass(as[i], abyte0[i]);
            } else
            {
                return;
            }
        } while (true);
    }

    public ArrayClassLoader(byte abyte0[][])
    {
        map = new Hashtable(100);
        cmap = new Hashtable(100);
        int i = abyte0.length;
        do
        {
            i--;
            if (i >= 0)
            {
                addClass((new StringBuilder()).append("lambda").append(i).toString(), abyte0[i]);
            } else
            {
                return;
            }
        } while (true);
    }

    public static Package getContextPackage(String s)
    {
        Object obj;
        obj = Thread.currentThread().getContextClassLoader();
        if (!(obj instanceof ArrayClassLoader))
        {
            break MISSING_BLOCK_LABEL_26;
        }
        obj = ((ArrayClassLoader)obj).getPackage(s);
        return ((Package) (obj));
        SecurityException securityexception;
        securityexception;
        return Package.getPackage(s);
    }

    public void addClass(ClassType classtype)
    {
        map.put(classtype.getName(), classtype);
    }

    public void addClass(Class class1)
    {
        cmap.put(class1.getName(), class1);
    }

    public void addClass(String s, byte abyte0[])
    {
        map.put(s, abyte0);
    }

    protected URL findResource(String s)
    {
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_30;
        }
        URL url;
        url = new URL(context, s);
        url.openConnection().connect();
        return url;
        Throwable throwable;
        throwable;
        return super.findResource(s);
    }

    public InputStream getResourceAsStream(String s)
    {
        InputStream inputstream = super.getResourceAsStream(s);
        Object obj = inputstream;
        if (inputstream == null)
        {
            obj = inputstream;
            if (s.endsWith(".class"))
            {
                s = s.substring(0, s.length() - 6).replace('/', '.');
                s = ((String) (map.get(s)));
                obj = inputstream;
                if (s instanceof byte[])
                {
                    obj = new ByteArrayInputStream((byte[])(byte[])s);
                }
            }
        }
        return ((InputStream) (obj));
    }

    public URL getResourceContext()
    {
        return context;
    }

    public Class loadClass(String s)
        throws ClassNotFoundException
    {
        Object obj;
        obj = cmap.get(s);
        if (obj != null)
        {
            return (Class)obj;
        }
        Object obj1 = map.get(s);
        obj = obj1;
        if (obj1 instanceof ClassType)
        {
            obj = (ClassType)obj1;
            if (((ClassType) (obj)).isExisting())
            {
                obj = ((ClassType) (obj)).reflectClass;
            } else
            {
                obj = ((ClassType) (obj)).writeToArray();
            }
        }
        if (!(obj instanceof byte[]))
        {
            break MISSING_BLOCK_LABEL_133;
        }
        this;
        JVM INSTR monitorenter ;
        obj = map.get(s);
        if (!(obj instanceof byte[])) goto _L2; else goto _L1
_L1:
        obj = (byte[])(byte[])obj;
        obj = defineClass(s, ((byte []) (obj)), 0, obj.length);
        cmap.put(s, obj);
        s = ((String) (obj));
_L3:
        this;
        JVM INSTR monitorexit ;
_L4:
        return s;
_L2:
        s = (Class)obj;
          goto _L3
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (obj == null)
        {
            s = getParent().loadClass(s);
        } else
        {
            s = (Class)obj;
        }
          goto _L4
    }

    public Class loadClass(String s, boolean flag)
        throws ClassNotFoundException
    {
        s = loadClass(s);
        if (flag)
        {
            resolveClass(s);
        }
        return s;
    }

    public void setResourceContext(URL url)
    {
        context = url;
    }
}
