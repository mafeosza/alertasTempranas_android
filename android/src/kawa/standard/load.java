// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.mapping.Environment;
import gnu.mapping.Procedure1;
import gnu.mapping.Values;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import kawa.Shell;

public class load extends Procedure1
{

    public static final load load = new load("load", false);
    public static final load loadRelative = new load("load-relative", true);
    boolean relative;

    public load(String s, boolean flag)
    {
        super(s);
        relative = flag;
    }

    public final Object apply1(Object obj)
        throws Throwable
    {
        return apply2(obj, Environment.getCurrent());
    }

    public final Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        Path path;
        Environment environment;
        Path path1;
        try
        {
            environment = (Environment)obj1;
            path = Path.valueOf(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder()).append("cannot load ").append(((FileNotFoundException) (obj)).getMessage()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new RuntimeException((new StringBuilder()).append("load: errors while compiling '").append(obj).append("':\n").append(((SyntaxException) (obj1)).getMessages().toString(20)).toString());
        }
        obj1 = path;
        if (!relative)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        path1 = (Path)Shell.currentLoadPath.get();
        obj1 = path;
        if (path1 == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        obj1 = path1.resolve(path);
        Shell.runFile(((Path) (obj1)).openInputStream(), ((Path) (obj1)), environment, true, 0);
        obj1 = Values.empty;
        return obj1;
    }

}
