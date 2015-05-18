// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import gnu.mapping.WrappedException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package gnu.text:
//            URIPath, ResourceStreamHandler, Path

public class URLPath extends URIPath
{

    final URL url;

    URLPath(URL url1)
    {
        super(toUri(url1));
        url = url1;
    }

    public static URLPath classResourcePath(Class class1)
    {
        URL url1 = ResourceStreamHandler.makeURL(class1);
        class1 = url1;
_L2:
        return valueOf(class1);
        SecurityException securityexception;
        securityexception;
        try
        {
            String s = (new StringBuilder()).append(class1.getName().replace('.', '/')).append(".class").toString();
            class1 = class1.getClassLoader().getResource(s);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw WrappedException.wrapIfNeeded(class1);
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static int getContentLength(URL url1)
    {
        int i;
        try
        {
            i = url1.openConnection().getContentLength();
        }
        // Misplaced declaration of an exception variable
        catch (URL url1)
        {
            return -1;
        }
        return i;
    }

    public static long getLastModified(URL url1)
    {
        long l;
        try
        {
            l = url1.openConnection().getLastModified();
        }
        // Misplaced declaration of an exception variable
        catch (URL url1)
        {
            return 0L;
        }
        return l;
    }

    public static InputStream openInputStream(URL url1)
        throws IOException
    {
        return url1.openConnection().getInputStream();
    }

    public static OutputStream openOutputStream(URL url1)
        throws IOException
    {
        Object obj;
        obj = url1.toString();
        if (!((String) (obj)).startsWith("file:"))
        {
            break MISSING_BLOCK_LABEL_40;
        }
        obj = new FileOutputStream(new File(new URI(((String) (obj)))));
        return ((OutputStream) (obj));
        Throwable throwable;
        throwable;
        url1 = url1.openConnection();
        url1.setDoInput(false);
        url1.setDoOutput(true);
        return url1.getOutputStream();
    }

    public static URI toUri(URL url1)
    {
        try
        {
            url1 = url1.toURI();
        }
        // Misplaced declaration of an exception variable
        catch (URL url1)
        {
            throw WrappedException.wrapIfNeeded(url1);
        }
        return url1;
    }

    public static URLPath valueOf(URL url1)
    {
        return new URLPath(url1);
    }

    public long getContentLength()
    {
        return (long)getContentLength(url);
    }

    public long getLastModified()
    {
        return getLastModified(url);
    }

    public boolean isAbsolute()
    {
        return true;
    }

    public InputStream openInputStream()
        throws IOException
    {
        return openInputStream(url);
    }

    public OutputStream openOutputStream()
        throws IOException
    {
        return openOutputStream(url);
    }

    public Path resolve(String s)
    {
        try
        {
            s = valueOf(new URL(url, s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw WrappedException.wrapIfNeeded(s);
        }
        return s;
    }

    public String toURIString()
    {
        return url.toString();
    }

    public URL toURL()
    {
        return url;
    }

    public URI toUri()
    {
        return toUri(url);
    }
}
