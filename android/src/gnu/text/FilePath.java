// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import gnu.lists.FString;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;

// Referenced classes of package gnu.text:
//            Path, URIPath, URLPath

public class FilePath extends Path
    implements Comparable
{

    final File file;
    final String path;

    private FilePath(File file1)
    {
        file = file1;
        path = file1.toString();
    }

    private FilePath(File file1, String s)
    {
        file = file1;
        path = s;
    }

    public static FilePath coerceToFilePathOrNull(Object obj)
    {
        if (obj instanceof FilePath)
        {
            return (FilePath)obj;
        }
        if (obj instanceof URIPath)
        {
            return valueOf(new File(((URIPath)obj).uri));
        }
        if (obj instanceof URI)
        {
            return valueOf(new File((URI)obj));
        }
        if (obj instanceof File)
        {
            return valueOf((File)obj);
        }
        if (obj instanceof FString)
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

    public static FilePath makeFilePath(Object obj)
    {
        FilePath filepath = coerceToFilePathOrNull(obj);
        if (filepath == null)
        {
            throw new WrongType((String)null, -4, obj, "filepath");
        } else
        {
            return filepath;
        }
    }

    private static URI toUri(File file1)
    {
        char c;
        String s;
        try
        {
            if (file1.isAbsolute())
            {
                return file1.toURI();
            }
            s = file1.toString();
            c = File.separatorChar;
        }
        // Misplaced declaration of an exception variable
        catch (File file1)
        {
            throw WrappedException.wrapIfNeeded(file1);
        }
        file1 = s;
        if (c == '/')
        {
            break MISSING_BLOCK_LABEL_37;
        }
        file1 = s.replace(c, '/');
        file1 = new URI(null, null, file1, null);
        return file1;
    }

    public static FilePath valueOf(File file1)
    {
        return new FilePath(file1);
    }

    public static FilePath valueOf(String s)
    {
        return new FilePath(new File(s), s);
    }

    public int compareTo(FilePath filepath)
    {
        return file.compareTo(filepath.file);
    }

    public volatile int compareTo(Object obj)
    {
        return compareTo((FilePath)obj);
    }

    public boolean delete()
    {
        return toFile().delete();
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof FilePath) && file.equals(((FilePath)obj).file);
    }

    public boolean exists()
    {
        return file.exists();
    }

    public Path getCanonical()
    {
        FilePath filepath;
        File file1;
        try
        {
            file1 = file.getCanonicalFile();
        }
        catch (Throwable throwable)
        {
            return this;
        }
        filepath = this;
        if (!file1.equals(file))
        {
            filepath = valueOf(file1);
        }
        return filepath;
    }

    public long getContentLength()
    {
        long l1 = file.length();
        long l = l1;
        if (l1 == 0L)
        {
            l = l1;
            if (!file.exists())
            {
                l = -1L;
            }
        }
        return l;
    }

    public String getLast()
    {
        return file.getName();
    }

    public long getLastModified()
    {
        return file.lastModified();
    }

    public FilePath getParent()
    {
        File file1 = file.getParentFile();
        if (file1 == null)
        {
            return null;
        } else
        {
            return valueOf(file1);
        }
    }

    public volatile Path getParent()
    {
        return getParent();
    }

    public String getPath()
    {
        return file.getPath();
    }

    public String getScheme()
    {
        if (isAbsolute())
        {
            return "file";
        } else
        {
            return null;
        }
    }

    public int hashCode()
    {
        return file.hashCode();
    }

    public boolean isAbsolute()
    {
        return this == Path.userDirPath || file.isAbsolute();
    }

    public boolean isDirectory()
    {
        if (!file.isDirectory()) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        int i;
        if (file.exists())
        {
            break; /* Loop/switch isn't completed */
        }
        i = path.length();
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = path.charAt(i - 1);
        if (i == '/' || i == File.separatorChar) goto _L1; else goto _L3
_L3:
        return false;
    }

    public InputStream openInputStream()
        throws IOException
    {
        return new FileInputStream(file);
    }

    public OutputStream openOutputStream()
        throws IOException
    {
        return new FileOutputStream(file);
    }

    public Path resolve(String s)
    {
        if (Path.uriSchemeSpecified(s))
        {
            return URLPath.valueOf(s);
        }
        Object obj = new File(s);
        if (((File) (obj)).isAbsolute())
        {
            return valueOf(((File) (obj)));
        }
        char c = File.separatorChar;
        obj = s;
        if (c != '/')
        {
            obj = s.replace('/', c);
        }
        if (this == Path.userDirPath)
        {
            s = new File(System.getProperty("user.dir"), ((String) (obj)));
        } else
        {
            if (isDirectory())
            {
                s = file;
            } else
            {
                s = file.getParentFile();
            }
            s = new File(s, ((String) (obj)));
        }
        return valueOf(s);
    }

    public File toFile()
    {
        return file;
    }

    public String toString()
    {
        return path;
    }

    public URL toURL()
    {
        if (this == Path.userDirPath)
        {
            return resolve("").toURL();
        }
        if (!isAbsolute())
        {
            return getAbsolute().toURL();
        }
        URL url;
        try
        {
            url = file.toURI().toURL();
        }
        catch (Throwable throwable)
        {
            throw WrappedException.wrapIfNeeded(throwable);
        }
        return url;
    }

    public URI toUri()
    {
        if (this == Path.userDirPath)
        {
            return resolve("").toURI();
        } else
        {
            return toUri(file);
        }
    }
}
