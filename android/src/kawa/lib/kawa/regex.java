// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib.kawa;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class regex extends ModuleBody
{
    public class frame extends ModuleBody
    {

        Object loop;
        Matcher matcher;
        Object repl;
        StringBuffer sbuf;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 1)
            {
                return lambda1loop();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public String lambda1loop()
        {
            if (matcher.find())
            {
                Matcher matcher1 = matcher;
                StringBuffer stringbuffer = sbuf;
                Object obj = Scheme.applyToArgs.apply2(repl, matcher.group());
                if (obj == null)
                {
                    obj = null;
                } else
                {
                    obj = obj.toString();
                }
                matcher1.appendReplacement(stringbuffer, Matcher.quoteReplacement(((String) (obj))));
            }
            matcher.appendTail(sbuf);
            return sbuf.toString();
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 1)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public frame()
        {
            loop = new ModuleMethod(this, 1, regex.Lit0, 0);
        }
    }


    public static final regex $instance;
    static final SimpleSymbol Lit0 = (SimpleSymbol)(new SimpleSymbol("loop")).readResolve();
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    public static final ModuleMethod regex$Mnmatch;
    public static final ModuleMethod regex$Mnmatch$Mnpositions;
    public static final ModuleMethod regex$Mnmatch$Qu;
    public static final ModuleMethod regex$Mnquote;
    public static final ModuleMethod regex$Mnreplace;
    public static final ModuleMethod regex$Mnreplace$St;
    public static final ModuleMethod regex$Mnsplit;

    public regex()
    {
        ModuleInfo.register(this);
    }

    public static boolean isRegexMatch(Object obj, CharSequence charsequence)
    {
        return isRegexMatch(obj, charsequence, 0);
    }

    public static boolean isRegexMatch(Object obj, CharSequence charsequence, int i)
    {
        return isRegexMatch(obj, charsequence, i, charsequence.length());
    }

    public static boolean isRegexMatch(Object obj, CharSequence charsequence, int i, int j)
    {
        if (obj instanceof Pattern)
        {
            Pattern pattern;
            try
            {
                pattern = (Pattern)obj;
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                throw new WrongType(charsequence, "rex", -2, obj);
            }
            obj = pattern;
        } else
        {
            obj = Pattern.compile(obj.toString());
        }
        obj = ((Pattern) (obj)).matcher(charsequence);
        ((Matcher) (obj)).region(i, j);
        return ((Matcher) (obj)).find();
    }

    public static Object regexMatch(Object obj, CharSequence charsequence)
    {
        return regexMatch(obj, charsequence, 0);
    }

    public static Object regexMatch(Object obj, CharSequence charsequence, int i)
    {
        return regexMatch(obj, charsequence, i, charsequence.length());
    }

    public static Object regexMatch(Object obj, CharSequence charsequence, int i, int j)
    {
        if (obj instanceof Pattern)
        {
            Object obj1;
            Matcher matcher;
            try
            {
                obj1 = (Pattern)obj;
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                throw new WrongType(charsequence, "rex", -2, obj);
            }
            obj = obj1;
        } else
        {
            obj = Pattern.compile(obj.toString());
        }
        matcher = ((Pattern) (obj)).matcher(charsequence);
        matcher.region(i, j);
        if (matcher.find())
        {
            i = matcher.groupCount();
            obj = LList.Empty;
            do
            {
                if (i < 0)
                {
                    return obj;
                }
                j = matcher.start(i);
                if (j < 0)
                {
                    obj1 = Boolean.FALSE;
                } else
                {
                    obj1 = charsequence.subSequence(j, matcher.end(i));
                }
                obj = lists.cons(obj1, obj);
                i--;
            } while (true);
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static Object regexMatchPositions(Object obj, CharSequence charsequence)
    {
        return regexMatchPositions(obj, charsequence, 0);
    }

    public static Object regexMatchPositions(Object obj, CharSequence charsequence, int i)
    {
        return regexMatchPositions(obj, charsequence, i, charsequence.length());
    }

    public static Object regexMatchPositions(Object obj, CharSequence charsequence, int i, int j)
    {
        if (obj instanceof Pattern)
        {
            Object obj1;
            try
            {
                obj1 = (Pattern)obj;
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                throw new WrongType(charsequence, "rex", -2, obj);
            }
            obj = obj1;
        } else
        {
            obj = Pattern.compile(obj.toString());
        }
        obj1 = ((Pattern) (obj)).matcher(charsequence);
        ((Matcher) (obj1)).region(i, j);
        if (((Matcher) (obj1)).find())
        {
            i = ((Matcher) (obj1)).groupCount();
            obj = LList.Empty;
            do
            {
                if (i < 0)
                {
                    return obj;
                }
                j = ((Matcher) (obj1)).start(i);
                if (j < 0)
                {
                    charsequence = Boolean.FALSE;
                } else
                {
                    charsequence = lists.cons(Integer.valueOf(j), Integer.valueOf(((Matcher) (obj1)).end(i)));
                }
                obj = lists.cons(charsequence, obj);
                i--;
            } while (true);
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static String regexQuote(CharSequence charsequence)
    {
        if (charsequence == null)
        {
            charsequence = null;
        } else
        {
            charsequence = charsequence.toString();
        }
        return Pattern.quote(charsequence);
    }

    public static CharSequence regexReplace(Object obj, CharSequence charsequence, Object obj1)
    {
        Object obj3 = null;
        Object obj2 = null;
        if (obj instanceof Pattern)
        {
            Object obj4;
            try
            {
                obj4 = (Pattern)obj;
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                throw new WrongType(charsequence, "rex", -2, obj);
            }
            obj = obj4;
        } else
        {
            obj = Pattern.compile(obj.toString());
        }
        obj4 = ((Pattern) (obj)).matcher(charsequence);
        if (!((Matcher) (obj4)).find()) goto _L2; else goto _L1
_L1:
        charsequence = new StringBuffer();
        if (!misc.isProcedure(obj1)) goto _L4; else goto _L3
_L3:
        obj = Scheme.applyToArgs.apply2(obj1, ((Matcher) (obj4)).group());
        if (obj == null)
        {
            obj = obj2;
        } else
        {
            obj = obj.toString();
        }
        obj = Matcher.quoteReplacement(((String) (obj)));
_L6:
        ((Matcher) (obj4)).appendReplacement(charsequence, ((String) (obj)));
        ((Matcher) (obj4)).appendTail(charsequence);
        charsequence = charsequence.toString();
_L2:
        return charsequence;
_L4:
        obj = obj3;
        if (obj1 != null)
        {
            obj = obj1.toString();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static CharSequence regexReplace$St(Object obj, CharSequence charsequence, Object obj1)
    {
        frame frame1 = new frame();
        frame1.repl = obj1;
        if (obj instanceof Pattern)
        {
            try
            {
                obj1 = (Pattern)obj;
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                throw new WrongType(charsequence, "rex", -2, obj);
            }
            obj = obj1;
        } else
        {
            obj = Pattern.compile(obj.toString());
        }
        frame1.matcher = ((Pattern) (obj)).matcher(charsequence);
        frame1.sbuf = new StringBuffer();
        if (misc.isProcedure(frame1.repl))
        {
            frame1.loop = frame1.loop;
            return frame1.lambda1loop();
        }
        charsequence = frame1.matcher;
        obj = frame1.repl;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        return charsequence.replaceAll(((String) (obj)));
    }

    public static LList regexSplit(Object obj, CharSequence charsequence)
    {
        if (obj instanceof Pattern)
        {
            Pattern pattern;
            try
            {
                pattern = (Pattern)obj;
            }
            // Misplaced declaration of an exception variable
            catch (CharSequence charsequence)
            {
                throw new WrongType(charsequence, "rex", -2, obj);
            }
            obj = pattern;
        } else
        {
            obj = Pattern.compile(obj.toString());
        }
        return LList.makeList(((Pattern) (obj)).split(charsequence, -1), 0);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 2)
        {
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-quote", 1, obj);
            }
            return regexQuote(modulemethod);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 3: // '\003'
            try
            {
                modulemethod = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match?", 2, obj1);
            }
            if (isRegexMatch(obj, modulemethod))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 6: // '\006'
            try
            {
                modulemethod = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match", 2, obj1);
            }
            return regexMatch(obj, modulemethod);

        case 9: // '\t'
            try
            {
                modulemethod = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match-positions", 2, obj1);
            }
            return regexMatchPositions(obj, modulemethod);

        case 12: // '\f'
            break;
        }
        try
        {
            modulemethod = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "regex-split", 2, obj1);
        }
        return regexSplit(obj, modulemethod);
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 3: // '\003'
            int i;
            try
            {
                modulemethod = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match?", 2, obj1);
            }
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match?", 3, obj2);
            }
            if (isRegexMatch(obj, modulemethod, i))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 6: // '\006'
            try
            {
                modulemethod = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match", 2, obj1);
            }
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match", 3, obj2);
            }
            return regexMatch(obj, modulemethod, i);

        case 9: // '\t'
            try
            {
                modulemethod = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match-positions", 2, obj1);
            }
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match-positions", 3, obj2);
            }
            return regexMatchPositions(obj, modulemethod, i);

        case 13: // '\r'
            try
            {
                modulemethod = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-replace", 2, obj1);
            }
            return regexReplace(obj, modulemethod, obj2);

        case 14: // '\016'
            break;
        }
        try
        {
            modulemethod = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "regex-replace*", 2, obj1);
        }
        return regexReplace$St(obj, modulemethod, obj2);
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);

        case 3: // '\003'
            int i;
            int j;
            try
            {
                modulemethod = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match?", 2, obj1);
            }
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match?", 3, obj2);
            }
            try
            {
                j = ((Number)obj3).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match?", 4, obj3);
            }
            if (isRegexMatch(obj, modulemethod, i, j))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 6: // '\006'
            try
            {
                modulemethod = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match", 2, obj1);
            }
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match", 3, obj2);
            }
            try
            {
                j = ((Number)obj3).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "regex-match", 4, obj3);
            }
            return regexMatch(obj, modulemethod, i, j);

        case 9: // '\t'
            break;
        }
        try
        {
            modulemethod = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "regex-match-positions", 2, obj1);
        }
        try
        {
            i = ((Number)obj2).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "regex-match-positions", 3, obj2);
        }
        try
        {
            j = ((Number)obj3).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "regex-match-positions", 4, obj3);
        }
        return regexMatchPositions(obj, modulemethod, i, j);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 2)
        {
            if (obj instanceof CharSequence)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return 0xfff40001;
            }
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 12: // '\f'
            callcontext.value1 = obj;
            if (obj1 instanceof CharSequence)
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            } else
            {
                return 0xfff40002;
            }

        case 9: // '\t'
            callcontext.value1 = obj;
            if (obj1 instanceof CharSequence)
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            } else
            {
                return 0xfff40002;
            }

        case 6: // '\006'
            callcontext.value1 = obj;
            if (obj1 instanceof CharSequence)
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            } else
            {
                return 0xfff40002;
            }

        case 3: // '\003'
            callcontext.value1 = obj;
            break;
        }
        if (obj1 instanceof CharSequence)
        {
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return 0xfff40002;
        }
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);

        case 14: // '\016'
            callcontext.value1 = obj;
            if (obj1 instanceof CharSequence)
            {
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            } else
            {
                return 0xfff40002;
            }

        case 13: // '\r'
            callcontext.value1 = obj;
            if (obj1 instanceof CharSequence)
            {
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            } else
            {
                return 0xfff40002;
            }

        case 9: // '\t'
            callcontext.value1 = obj;
            if (obj1 instanceof CharSequence)
            {
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            } else
            {
                return 0xfff40002;
            }

        case 6: // '\006'
            callcontext.value1 = obj;
            if (obj1 instanceof CharSequence)
            {
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            } else
            {
                return 0xfff40002;
            }

        case 3: // '\003'
            callcontext.value1 = obj;
            break;
        }
        if (obj1 instanceof CharSequence)
        {
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        } else
        {
            return 0xfff40002;
        }
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);

        case 9: // '\t'
            callcontext.value1 = obj;
            if (obj1 instanceof CharSequence)
            {
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            } else
            {
                return 0xfff40002;
            }

        case 6: // '\006'
            callcontext.value1 = obj;
            if (obj1 instanceof CharSequence)
            {
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            } else
            {
                return 0xfff40002;
            }

        case 3: // '\003'
            callcontext.value1 = obj;
            break;
        }
        if (obj1 instanceof CharSequence)
        {
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.value4 = obj3;
            callcontext.proc = modulemethod;
            callcontext.pc = 4;
            return 0;
        } else
        {
            return 0xfff40002;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit7 = (SimpleSymbol)(new SimpleSymbol("regex-replace*")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("regex-replace")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("regex-split")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("regex-match-positions")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("regex-match")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("regex-match?")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("regex-quote")).readResolve();
        $instance = new regex();
        regex regex1 = $instance;
        regex$Mnquote = new ModuleMethod(regex1, 2, Lit1, 4097);
        regex$Mnmatch$Qu = new ModuleMethod(regex1, 3, Lit2, 16386);
        regex$Mnmatch = new ModuleMethod(regex1, 6, Lit3, 16386);
        regex$Mnmatch$Mnpositions = new ModuleMethod(regex1, 9, Lit4, 16386);
        regex$Mnsplit = new ModuleMethod(regex1, 12, Lit5, 8194);
        regex$Mnreplace = new ModuleMethod(regex1, 13, Lit6, 12291);
        regex$Mnreplace$St = new ModuleMethod(regex1, 14, Lit7, 12291);
        $instance.run();
    }
}
