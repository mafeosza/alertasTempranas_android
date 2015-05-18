// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.CharSeq;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.numbers;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class lambda.Fn19 extends ModuleBody
{

    Object cnt;
    Object end;
    final ModuleMethod lambda$Fn19;
    Object s;
    Object str;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 21)
        {
            if (lambda33(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    boolean lambda33(Object obj)
    {
        if (!strings.isString(obj)) goto _L2; else goto _L1
_L1:
        Object obj1;
label0:
        {
label1:
            {
                if (str == Boolean.FALSE)
                {
                    obj1 = Scheme.numGEq;
                    Object obj2 = AddOp.$Mn.apply2(end, cnt);
                    char c;
                    Object obj3;
                    int i;
                    int j;
                    try
                    {
                        obj3 = (CharSequence)obj;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
                    }
                    if (((Procedure) (obj1)).apply2(obj2, Integer.valueOf(strings.stringLength(((CharSequence) (obj3))))) == Boolean.FALSE)
                    {
                        break label1;
                    }
                }
                try
                {
                    obj1 = (CharSequence)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
                }
                obj2 = numbers.min(new Object[] {
                    Integer.valueOf(strings.stringLength(((CharSequence) (obj1)))), AddOp.$Mn.apply2(end, cnt)
                });
                obj1 = printf.Lit1;
                while (Scheme.numGEq.apply2(obj1, obj2) == Boolean.FALSE) 
                {
                    Object obj4 = s;
                    try
                    {
                        obj3 = (CharSeq)obj4;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, obj4);
                    }
                    obj4 = cnt;
                    try
                    {
                        i = ((Number)obj4).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, obj4);
                    }
                    try
                    {
                        obj4 = (CharSequence)obj;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1)
                    {
                        throw new WrongType(((ClassCastException) (obj1)), "string-ref", 1, obj);
                    }
                    try
                    {
                        j = ((Number)obj1).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
                    }
                    strings.stringSet$Ex(((CharSeq) (obj3)), i, strings.stringRef(((CharSequence) (obj4)), j));
                    cnt = AddOp.$Pl.apply2(cnt, printf.Lit7);
                    obj1 = AddOp.$Pl.apply2(obj1, printf.Lit7);
                }
                break label0;
            }
            obj1 = s;
            try
            {
                obj2 = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj1);
            }
            obj1 = cnt;
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj1);
            }
            s = strings.stringAppend(new Object[] {
                strings.substring(((CharSequence) (obj2)), 0, i), obj
            });
            obj = s;
            try
            {
                obj1 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-length", 1, obj);
            }
            cnt = Integer.valueOf(strings.stringLength(((CharSequence) (obj1))));
            end = cnt;
        }
_L4:
        if (str != Boolean.FALSE)
        {
            if (Scheme.numGEq.apply2(cnt, end) != Boolean.FALSE)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        if (str != Boolean.FALSE)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + 1 & 1;
_L2:
        if (str != Boolean.FALSE)
        {
            obj1 = Scheme.numGEq.apply2(cnt, end);
        } else
        {
            obj1 = str;
        }
        if (obj1 == Boolean.FALSE)
        {
            obj1 = str;
            try
            {
                obj2 = Boolean.FALSE;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "x", -2, obj1);
            }
            if (obj1 != obj2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            i = i + 1 & 1;
            if (i == 0 ? i != 0 : Scheme.numGEq.apply2(cnt, end) != Boolean.FALSE)
            {
                s = strings.stringAppend(new Object[] {
                    s, strings.makeString(100)
                });
                obj1 = s;
                try
                {
                    obj2 = (CharSequence)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj1);
                }
                end = Integer.valueOf(strings.stringLength(((CharSequence) (obj2))));
            }
            obj1 = s;
            try
            {
                obj2 = (CharSeq)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, obj1);
            }
            obj1 = cnt;
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, obj1);
            }
            if (characters.isChar(obj))
            {
                try
                {
                    c = ((Char)obj).charValue();
                }
                catch (ClassCastException classcastexception)
                {
                    throw new WrongType(classcastexception, "string-set!", 3, obj);
                }
            } else
            {
                c = '?';
            }
            strings.stringSet$Ex(((CharSeq) (obj2)), i, c);
            cnt = AddOp.$Pl.apply2(cnt, printf.Lit7);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 21)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 21, null, 4097);
        modulemethod.setProperty("source-location", "printf.scm:564");
        lambda$Fn19 = modulemethod;
    }
}
