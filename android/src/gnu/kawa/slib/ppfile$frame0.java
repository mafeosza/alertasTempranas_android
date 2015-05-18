// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.ports;
import kawa.lib.rnrs.unicode;
import kawa.standard.Scheme;
import kawa.standard.readchar;

// Referenced classes of package gnu.kawa.slib:
//            ppfile, pp

public class lambda.Fn2 extends ModuleBody
{

    final ModuleMethod lambda$Fn2;
    Object port;
     staticLink;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            return lambda2(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Object lambda2(Object obj)
    {
        Object obj1 = readchar.peekChar.apply1(port);
label0:
        do
        {
            boolean flag = ports.isEofObject(obj1);
            if (flag)
            {
                if (flag)
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            }
            Object obj2;
            Char char1;
            try
            {
                obj2 = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "char-whitespace?", 1, obj1);
            }
            if (unicode.isCharWhitespace(((Char) (obj2))))
            {
                ports.display(readchar.readChar.apply1(port), obj);
                obj1 = readchar.peekChar.apply1(port);
                continue;
            }
            obj2 = ppfile.Lit0;
            try
            {
                char1 = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "char=?", 2, obj1);
            }
            if (characters.isChar$Eq(((Char) (obj2)), char1))
            {
                do
                {
                    flag = ports.isEofObject(obj1);
                    if (flag)
                    {
                        if (flag)
                        {
                            return Boolean.TRUE;
                        } else
                        {
                            return Boolean.FALSE;
                        }
                    }
                    obj2 = ppfile.Lit1;
                    try
                    {
                        char1 = (Char)obj1;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "char=?", 2, obj1);
                    }
                    if (characters.isChar$Eq(((Char) (obj2)), char1))
                    {
                        ports.display(readchar.readChar.apply1(port), obj);
                        obj1 = readchar.peekChar.apply1(port);
                        continue label0;
                    }
                    ports.display(readchar.readChar.apply1(port), obj);
                    obj1 = readchar.peekChar.apply1(port);
                } while (true);
            }
            obj1 = port;
            try
            {
                obj2 = (InPort)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "read", 1, obj1);
            }
            obj1 = ports.read(((InPort) (obj2)));
            flag = ports.isEofObject(obj1);
            if (flag)
            {
                if (flag)
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            }
            pp.prettyPrint(Scheme.applyToArgs.apply2(staticLink.ilter, obj1), obj);
            obj2 = readchar.peekChar.apply1(port);
            obj1 = obj2;
            if (Scheme.isEqv.apply2(ppfile.Lit1, obj2) != Boolean.FALSE)
            {
                readchar.readChar.apply1(port);
                obj1 = readchar.peekChar.apply1(port);
            }
        } while (true);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
        modulemethod.setProperty("source-location", "ppfile.scm:34");
        lambda$Fn2 = modulemethod;
    }
}
