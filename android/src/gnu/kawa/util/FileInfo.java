// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.util;

import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.text.Path;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Hashtable;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileInfo
{

    static final Pattern childPat = Pattern.compile("<a .*</a>");
    static Hashtable fileMap = new Hashtable();
    static final Pattern linkPat = Pattern.compile(" href=['\"]([^'\"]*)['\"]");
    static final Pattern parentPat = Pattern.compile("<ul[^>]* parent=['\"]([^'\"]*)['\"]");
    StringBuffer beforeNavbarText;
    ByteArrayOutputStream bout;
    String childLinkText[];
    OutPort cout;
    File file;
    FileInputStream fin;
    InPort in;
    int nchildren;
    StringBuffer newNavbarText;
    StringBuffer oldNavbarText;
    FileInfo parent;
    String parentName;
    String path;
    boolean scanned;
    boolean writeNeeded;

    FileInfo()
    {
    }

    public static FileInfo find(File file1)
        throws Throwable
    {
        String s = file1.getCanonicalPath();
        FileInfo fileinfo1 = (FileInfo)fileMap.get(s);
        FileInfo fileinfo = fileinfo1;
        if (fileinfo1 == null)
        {
            fileinfo = new FileInfo();
            fileinfo.file = file1;
            fileMap.put(s, fileinfo);
        }
        return fileinfo;
    }

    public void scan()
        throws Throwable
    {
        if (!scanned) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        boolean flag;
        boolean flag2;
        scanned = true;
        fin = new FileInputStream(file);
        in = new InPort(new BufferedInputStream(fin));
        oldNavbarText = new StringBuffer();
        newNavbarText = new StringBuffer();
        if (writeNeeded)
        {
            bout = new ByteArrayOutputStream();
            cout = new OutPort(bout);
        }
        flag2 = false;
        flag = false;
        obj = new Vector();
_L6:
        String s = in.readLine();
        if (s != null) goto _L4; else goto _L3
_L3:
        s = new String[((Vector) (obj)).size()];
        nchildren = s.length;
        ((Vector) (obj)).copyInto(s);
        childLinkText = s;
        if (!writeNeeded)
        {
            in.close();
        }
        if (parentName != null)
        {
            obj = find(new File(file.toURI().resolve(parentName)));
            ((FileInfo) (obj)).scan();
            parent = ((FileInfo) (obj));
            return;
        }
          goto _L1
_L4:
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        if (s.indexOf("<!--end-generated-navbar-->") < 0) goto _L5; else goto _L3
_L5:
        boolean flag1;
        boolean flag3;
        oldNavbarText.append(s);
        oldNavbarText.append('\n');
        flag1 = flag;
        if (flag)
        {
            if (s.indexOf("<!--end-children-toc-->") >= 0)
            {
                flag1 = false;
            } else
            {
                Matcher matcher = childPat.matcher(s);
                if (matcher.find())
                {
                    ((Vector) (obj)).add(matcher.group());
                }
                matcher = parentPat.matcher(s);
                flag1 = flag;
                if (matcher.find())
                {
                    flag1 = flag;
                    if (parentName == null)
                    {
                        parentName = matcher.group(1);
                        flag1 = flag;
                    }
                }
            }
        }
        flag3 = flag2;
        if (s.indexOf("<!--start-children-toc-->") >= 0)
        {
            flag1 = true;
            flag3 = flag2;
        }
_L7:
        flag = flag1;
        flag2 = flag3;
        if (writeNeeded)
        {
            flag = flag1;
            flag2 = flag3;
            if (!flag3)
            {
                cout.println(s);
                flag = flag1;
                flag2 = flag3;
            }
        }
          goto _L6
        flag1 = flag;
        flag3 = flag2;
        if (s.indexOf("<!--start-generated-navbar-->") >= 0)
        {
            flag3 = true;
            flag1 = flag;
        }
          goto _L7
    }

    public void write()
        throws Throwable
    {
        int i = 0;
        for (FileInfo fileinfo = this; fileinfo.parent != null;)
        {
            fileinfo = fileinfo.parent;
            i++;
        }

        cout.println("<!--start-generated-navbar-->");
        writeLinks(i, newNavbarText);
        cout.print(newNavbarText);
        cout.println("<!--end-generated-navbar-->");
        do
        {
            String s = in.readLine();
            if (s == null)
            {
                new StringBuffer();
                in.close();
                if (oldNavbarText.toString().equals(newNavbarText.toString()))
                {
                    System.err.println((new StringBuilder()).append("fixup ").append(file).append(" - no change").toString());
                    return;
                } else
                {
                    FileOutputStream fileoutputstream = new FileOutputStream(file);
                    fileoutputstream.write(bout.toByteArray());
                    fileoutputstream.close();
                    System.err.println((new StringBuilder()).append("fixup ").append(file).append(" - updated").toString());
                    return;
                }
            }
            cout.println(s);
        } while (true);
    }

    public void writeLinks(int i, StringBuffer stringbuffer)
        throws Throwable
    {
        Object obj;
        boolean flag1;
        FileInfo fileinfo = this;
        FileInfo fileinfo1 = null;
        int j = i;
        do
        {
            j--;
            if (j < 0)
            {
                break;
            }
            fileinfo1 = fileinfo;
            fileinfo = fileinfo.parent;
        } while (true);
        if (i == 0)
        {
            stringbuffer.append("<!--start-children-toc-->\n");
        }
        String s;
        Object obj1;
        URI uri;
        URI uri1;
        int k;
        if (i == 0 && parentName != null)
        {
            stringbuffer.append("<ul parent=\"");
            stringbuffer.append(parentName);
            stringbuffer.append("\">\n");
        } else
        {
            stringbuffer.append("<ul>\n");
        }
        uri = file.toURI();
        uri1 = fileinfo.file.toURI();
        k = 0;
_L8:
        if (k >= fileinfo.nchildren) goto _L2; else goto _L1
_L1:
        s = fileinfo.childLinkText[k];
        flag1 = false;
        obj = s;
        if (i <= 0) goto _L4; else goto _L3
_L3:
        obj = linkPat.matcher(s);
        ((Matcher) (obj)).find();
        s = ((Matcher) (obj)).group(1);
        obj1 = uri1.resolve(s);
        obj1 = ((Matcher) (obj)).replaceFirst((new StringBuilder()).append(" href=\"").append(Path.relativize(((URI) (obj1)).toString(), uri.toString())).append("\"").toString());
        j = s.indexOf('#');
        obj = s;
        if (j >= 0)
        {
            obj = s.substring(0, j);
        }
        boolean flag;
        if (find(new File(uri1.resolve(((String) (obj))))) == fileinfo1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = flag;
        obj = obj1;
        if (flag) goto _L4; else goto _L5
_L5:
        flag1 = flag;
        obj = obj1;
        if (i <= 1) goto _L4; else goto _L6
_L6:
        k++;
        continue; /* Loop/switch isn't completed */
_L4:
        stringbuffer.append("<li>");
        stringbuffer.append(((String) (obj)));
        if (flag1)
        {
            stringbuffer.append('\n');
            writeLinks(i - 1, stringbuffer);
        }
        stringbuffer.append("</li>\n");
        if (true) goto _L6; else goto _L2
_L2:
        stringbuffer.append("</ul>\n");
        if (i == 0)
        {
            stringbuffer.append("<!--end-children-toc-->\n");
        }
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

}
