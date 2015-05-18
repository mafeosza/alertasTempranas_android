// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import gnu.lists.FString;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package gnu.text:
//            Path, URLPath, URIStringPath, FilePath

public class URIPath extends Path
    implements Comparable
{

    final URI uri;

    URIPath(URI uri1)
    {
        uri = uri1;
    }

    public static URIPath coerceToURIPathOrNull(Object obj)
    {
        if (obj instanceof URIPath)
        {
            return (URIPath)obj;
        }
        if (obj instanceof URL)
        {
            return URLPath.valueOf((URL)obj);
        }
        if (obj instanceof URI)
        {
            return valueOf((URI)obj);
        }
        if ((obj instanceof File) || (obj instanceof Path) || (obj instanceof FString))
        {
            obj = obj.toString();
        } else
        if (obj instanceof String)
        {
            obj = (String)obj;
        } else
        {
            return null;
        }
        return valueOf(((String) (obj)));
    }

    public static String encodeForUri(String s, char c)
    {
        StringBuffer stringbuffer;
        int l1;
        stringbuffer = new StringBuffer();
        l1 = s.length();
        break MISSING_BLOCK_LABEL_14;
        int i2 = stringbuffer.length();
        int i1 = 0;
        int k;
        if (l >= 128 && l >= 2048 && l >= 0x10000);
        do
        {
            int k1;
            if (i1 == 0)
            {
                k = 7;
            } else
            {
                k = 6 - i1;
            }
            if (l < 1 << k)
            {
                k = l;
                l = k;
                if (i1 > 0)
                {
                    l = k | 65408 >> i1 & 0xff;
                }
                k = 0;
            } else
            {
                k = l & 0x3f | 0x80;
                j1 = l >> 6;
                l = k;
                k = j1;
            }
            k1 = i1 + 1;
            i1 = 0;
            while (i1 <= 1) 
            {
                int j1 = l & 0xf;
                if (j1 <= 9)
                {
                    j1 += 48;
                } else
                {
                    j1 = (j1 - 10) + 65;
                }
                stringbuffer.insert(i2, (char)j1);
                l >>= 4;
                i1++;
            }
            stringbuffer.insert(i2, '%');
            l = k;
            i1 = k1;
        } while (k != 0);
        int l;
        for (int i = 0; i < l1;)
        {
            int j = i + 1;
            char c1 = s.charAt(i);
            l = c1;
            i = j;
            if (c1 >= '\uD800')
            {
                l = c1;
                i = j;
                if (c1 < '\uDC00')
                {
                    l = c1;
                    i = j;
                    if (j < l1)
                    {
                        l = (c1 - 55296) * 1024 + (s.charAt(j) - 56320) + 0x10000;
                        i = j + 1;
                    }
                }
            }
            if (c != 'H' ? l >= 97 && l <= 122 || l >= 65 && l <= 90 || l >= 48 && l <= 57 || l == 45 || l == 95 || l == 46 || l == 126 || c == 'I' && (l == 59 || l == 47 || l == 63 || l == 58 || l == 42 || l == 39 || l == 40 || l == 41 || l == 64 || l == 38 || l == 61 || l == 43 || l == 36 || l == 44 || l == 91 || l == 93 || l == 35 || l == 33 || l == 37) : l >= 32 && l <= 126)
            {
                stringbuffer.append((char)l);
            } else
            {
                break MISSING_BLOCK_LABEL_345;
            }
        }

        return stringbuffer.toString();
    }

    public static URIPath makeURI(Object obj)
    {
        URIPath uripath = coerceToURIPathOrNull(obj);
        if (uripath == null)
        {
            throw new WrongType((String)null, -4, obj, "URI");
        } else
        {
            return uripath;
        }
    }

    public static URIPath valueOf(String s)
    {
        try
        {
            s = new URIStringPath(new URI(encodeForUri(s, 'I')), s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw WrappedException.wrapIfNeeded(s);
        }
        return s;
    }

    public static URIPath valueOf(URI uri1)
    {
        return new URIPath(uri1);
    }

    public int compareTo(URIPath uripath)
    {
        return uri.compareTo(uripath.uri);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((URIPath)obj);
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof URIPath) && uri.equals(((URIPath)obj).uri);
    }

    public boolean exists()
    {
        boolean flag = true;
        URLConnection urlconnection = toURL().openConnection();
        Throwable throwable;
        long l;
        if (urlconnection instanceof HttpURLConnection)
        {
            return ((HttpURLConnection)urlconnection).getResponseCode() == 200;
        }
        l = urlconnection.getLastModified();
        if (l == 0L)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_50;
        throwable;
        flag = false;
        return flag;
    }

    public String getAuthority()
    {
        return uri.getAuthority();
    }

    public Path getCanonical()
    {
        if (isAbsolute())
        {
            URI uri1 = uri.normalize();
            if (uri1 == uri)
            {
                return this;
            } else
            {
                return valueOf(uri1);
            }
        } else
        {
            return getAbsolute().getCanonical();
        }
    }

    public long getContentLength()
    {
        return (long)URLPath.getContentLength(toURL());
    }

    public String getFragment()
    {
        return uri.getFragment();
    }

    public String getHost()
    {
        return uri.getHost();
    }

    public long getLastModified()
    {
        return URLPath.getLastModified(toURL());
    }

    public String getPath()
    {
        return uri.getPath();
    }

    public int getPort()
    {
        return uri.getPort();
    }

    public String getQuery()
    {
        return uri.getQuery();
    }

    public String getScheme()
    {
        return uri.getScheme();
    }

    public String getUserInfo()
    {
        return uri.getUserInfo();
    }

    public int hashCode()
    {
        return uri.hashCode();
    }

    public boolean isAbsolute()
    {
        return uri.isAbsolute();
    }

    public InputStream openInputStream()
        throws IOException
    {
        return URLPath.openInputStream(toURL());
    }

    public OutputStream openOutputStream()
        throws IOException
    {
        return URLPath.openOutputStream(toURL());
    }

    public Path resolve(String s)
    {
        if (Path.uriSchemeSpecified(s))
        {
            return valueOf(s);
        }
        char c = File.separatorChar;
        String s1 = s;
        if (c != '/')
        {
            if (s.length() >= 2 && (s.charAt(1) == ':' && Character.isLetter(s.charAt(0)) || s.charAt(0) == c && s.charAt(1) == c))
            {
                return FilePath.valueOf(new File(s));
            }
            s1 = s.replace(c, '/');
        }
        try
        {
            s = uri.resolve(new URI(null, s1, null));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw WrappedException.wrapIfNeeded(s);
        }
        return valueOf(s);
    }

    public String toString()
    {
        return toURIString();
    }

    public String toURIString()
    {
        return uri.toString();
    }

    public URL toURL()
    {
        return Path.toURL(uri.toString());
    }

    public URI toUri()
    {
        return uri;
    }
}
