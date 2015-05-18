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
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

// Referenced classes of package gnu.text:
//            FilePath, URLPath, URIPath

public abstract class Path
{

    public static Path defaultPath;
    private static ThreadLocal pathLocation = new ThreadLocal();
    public static final FilePath userDirPath;

    protected Path()
    {
    }

    public static Path coerceToPathOrNull(Object obj)
    {
        if (obj instanceof Path)
        {
            return (Path)obj;
        }
        if (obj instanceof URL)
        {
            return URLPath.valueOf((URL)obj);
        }
        if (obj instanceof URI)
        {
            return URIPath.valueOf((URI)obj);
        }
        if (obj instanceof File)
        {
            return FilePath.valueOf((File)obj);
        }
        if (obj instanceof FString)
        {
            obj = obj.toString();
        } else
        {
            if (!(obj instanceof String))
            {
                return null;
            }
            obj = (String)obj;
        }
        if (uriSchemeSpecified(((String) (obj))))
        {
            return URIPath.valueOf(((String) (obj)));
        } else
        {
            return FilePath.valueOf(((String) (obj)));
        }
    }

    public static Path currentPath()
    {
        Path path = (Path)pathLocation.get();
        if (path != null)
        {
            return path;
        } else
        {
            return defaultPath;
        }
    }

    public static InputStream openInputStream(Object obj)
        throws IOException
    {
        return valueOf(obj).openInputStream();
    }

    public static String relativize(String s, String s1)
        throws URISyntaxException, IOException
    {
label0:
        {
            String s2 = (new URI(s1)).normalize().toString();
            Object obj = URLPath.valueOf(s).toURI().normalize().toString();
            int l = s2.length();
            int i1 = ((String) (obj)).length();
            int i = 0;
            int k = 0;
            int j = 0;
label1:
            do
            {
                char c;
label2:
                {
                    if (i < l && i < i1)
                    {
                        c = s2.charAt(i);
                        if (c == ((String) (obj)).charAt(i))
                        {
                            break label2;
                        }
                    }
                    s1 = s;
                    if (j <= 0)
                    {
                        break label0;
                    }
                    if (k <= j + 2 && l > j + 2)
                    {
                        s1 = s;
                        if (s2.charAt(j + 2) == '/')
                        {
                            break label0;
                        }
                    }
                    s = s2.substring(k + 1);
                    s1 = ((String) (obj)).substring(k + 1);
                    obj = new StringBuilder();
                    i = s.length();
                    do
                    {
                        j = i - 1;
                        if (j < 0)
                        {
                            break;
                        }
                        i = j;
                        if (s.charAt(j) == '/')
                        {
                            ((StringBuilder) (obj)).append("../");
                            i = j;
                        }
                    } while (true);
                    break label1;
                }
                if (c == '/')
                {
                    k = i;
                }
                if (c == ':')
                {
                    j = i;
                }
                i++;
            } while (true);
            ((StringBuilder) (obj)).append(s1);
            s1 = ((StringBuilder) (obj)).toString();
        }
        return s1;
    }

    public static void setCurrentPath(Path path)
    {
        pathLocation.set(path);
    }

    public static URL toURL(String s)
    {
        String s1 = s;
        try
        {
            if (!uriSchemeSpecified(s))
            {
                s = currentPath().resolve(s);
                if (s.isAbsolute())
                {
                    return s.toURL();
                }
                s1 = s.toString();
            }
            s = new URL(s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw WrappedException.wrapIfNeeded(s);
        }
        return s;
    }

    public static int uriSchemeLength(String s)
    {
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            char c = s.charAt(i);
            if (c == ':')
            {
                return i;
            }
            if (i != 0 ? !Character.isLetterOrDigit(c) && c != '+' && c != '-' && c != '.' : !Character.isLetter(c))
            {
                return -1;
            }
        }

        return -1;
    }

    public static boolean uriSchemeSpecified(String s)
    {
        int i;
        boolean flag;
label0:
        {
label1:
            {
                flag = true;
                boolean flag1 = false;
                i = uriSchemeLength(s);
                if (i != 1 || File.separatorChar != '\\')
                {
                    break label0;
                }
                i = s.charAt(0);
                if (i >= 97)
                {
                    flag = flag1;
                    if (i <= 122)
                    {
                        break label1;
                    }
                }
                if (i >= 65)
                {
                    flag = flag1;
                    if (i <= 90)
                    {
                        break label1;
                    }
                }
                flag = true;
            }
            return flag;
        }
        if (i <= 0)
        {
            flag = false;
        }
        return flag;
    }

    public static Path valueOf(Object obj)
    {
        Path path = coerceToPathOrNull(obj);
        if (path == null)
        {
            throw new WrongType((String)null, -4, obj, "path");
        } else
        {
            return path;
        }
    }

    public boolean delete()
    {
        return false;
    }

    public boolean exists()
    {
        return getLastModified() != 0L;
    }

    public Path getAbsolute()
    {
        if (this == userDirPath)
        {
            return resolve("");
        } else
        {
            return currentPath().resolve(this);
        }
    }

    public String getAuthority()
    {
        return null;
    }

    public Path getCanonical()
    {
        return getAbsolute();
    }

    public CharSequence getCharContent(boolean flag)
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public long getContentLength()
    {
        return -1L;
    }

    public Path getDirectory()
    {
        if (isDirectory())
        {
            return this;
        } else
        {
            return resolve("");
        }
    }

    public String getExtension()
    {
        String s = getPath();
        if (s != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        int i = s.length();
_L5:
        int j = i - 1;
        if (j <= 0) goto _L1; else goto _L3
_L3:
        boolean flag;
        char c = s.charAt(j);
        flag = false;
        i = c;
        if (c == '.')
        {
            i = s.charAt(j - 1);
            flag = true;
        }
        if (i == '/' || (this instanceof FilePath) && i == File.separatorChar) goto _L1; else goto _L4
_L4:
        i = j;
        if (flag)
        {
            return s.substring(j + 1);
        }
          goto _L5
    }

    public String getFragment()
    {
        return null;
    }

    public String getHost()
    {
        return null;
    }

    public String getLast()
    {
        String s = getPath();
        if (s == null)
        {
            return null;
        }
        int i = s.length();
        int l = i;
        int j = i;
        do
        {
            int k = j - 1;
            if (k <= 0)
            {
                return "";
            }
            char c = s.charAt(k);
            if (c != '/')
            {
                j = k;
                if (!(this instanceof FilePath))
                {
                    continue;
                }
                j = k;
                if (c != File.separatorChar)
                {
                    continue;
                }
            }
            if (k + 1 == i)
            {
                l = k;
                j = k;
            } else
            {
                return s.substring(k + 1, l);
            }
        } while (true);
    }

    public abstract long getLastModified();

    public String getName()
    {
        return toString();
    }

    public Path getParent()
    {
        String s;
        if (isDirectory())
        {
            s = "..";
        } else
        {
            s = "";
        }
        return resolve(s);
    }

    public abstract String getPath();

    public int getPort()
    {
        return -1;
    }

    public String getQuery()
    {
        return null;
    }

    public abstract String getScheme();

    public String getUserInfo()
    {
        return null;
    }

    public abstract boolean isAbsolute();

    public boolean isDirectory()
    {
        String s = toString();
        int i = s.length();
        if (i > 0)
        {
            i = s.charAt(i - 1);
            if (i == '/' || i == File.separatorChar)
            {
                return true;
            }
        }
        return false;
    }

    public abstract InputStream openInputStream()
        throws IOException;

    public abstract OutputStream openOutputStream()
        throws IOException;

    public Reader openReader(boolean flag)
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public Writer openWriter()
        throws IOException
    {
        return new OutputStreamWriter(openOutputStream());
    }

    public Path resolve(Path path)
    {
        if (path.isAbsolute())
        {
            return path;
        } else
        {
            return resolve(path.toString());
        }
    }

    public abstract Path resolve(String s);

    public final URI toURI()
    {
        return toUri();
    }

    public String toURIString()
    {
        return toUri().toString();
    }

    public abstract URL toURL();

    public abstract URI toUri();

    static 
    {
        userDirPath = FilePath.valueOf(new File("."));
        defaultPath = userDirPath;
    }
}
