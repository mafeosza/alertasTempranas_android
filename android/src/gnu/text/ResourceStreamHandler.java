// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class ResourceStreamHandler extends URLStreamHandler
{

    public static final String CLASS_RESOURCE_URI_PREFIX = "class-resource:/";
    public static final int CLASS_RESOURCE_URI_PREFIX_LENGTH = 16;
    ClassLoader cloader;

    public ResourceStreamHandler(ClassLoader classloader)
    {
        cloader = classloader;
    }

    public static URL makeURL(Class class1)
        throws MalformedURLException
    {
        String s1 = class1.getName();
        int i = s1.lastIndexOf('.');
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("class-resource:/");
        String s = s1;
        if (i >= 0)
        {
            stringbuilder.append(s1.substring(0, i));
            stringbuilder.append('/');
            s = s1.substring(i + 1);
        }
        stringbuilder.append(s);
        return new URL(null, stringbuilder.toString(), new ResourceStreamHandler(class1.getClassLoader()));
    }

    public URLConnection openConnection(URL url)
        throws IOException
    {
        String s1 = url.toString();
        String s = s1.substring(16);
        int i = s.indexOf('/');
        url = s;
        if (i > 0)
        {
            url = (new StringBuilder()).append(s.substring(0, i).replace('.', '/')).append(s.substring(i)).toString();
        }
        url = cloader.getResource(url);
        if (url == null)
        {
            throw new FileNotFoundException(s1);
        } else
        {
            return url.openConnection();
        }
    }
}
