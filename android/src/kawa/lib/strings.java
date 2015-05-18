// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.CharSeq;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Strings;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Char;

// Referenced classes of package kawa.lib:
//            lists

public class strings extends ModuleBody
{

    public static final strings $instance;
    public static final ModuleMethod $make$string$;
    static final Char Lit0 = Char.make(32);
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod list$Mn$Grstring;
    public static final ModuleMethod make$Mnstring;
    public static final ModuleMethod string$Eq$Qu;
    public static final ModuleMethod string$Gr$Eq$Qu;
    public static final ModuleMethod string$Gr$Qu;
    public static final ModuleMethod string$Ls$Eq$Qu;
    public static final ModuleMethod string$Ls$Qu;
    public static final ModuleMethod string$Mn$Grlist;
    public static final ModuleMethod string$Mnappend;
    public static final ModuleMethod string$Mnappend$Slshared;
    public static final ModuleMethod string$Mncapitalize;
    public static final ModuleMethod string$Mncapitalize$Ex;
    public static final ModuleMethod string$Mncopy;
    public static final ModuleMethod string$Mndowncase$Ex;
    public static final ModuleMethod string$Mnfill$Ex;
    public static final ModuleMethod string$Mnlength;
    public static final ModuleMethod string$Mnref;
    public static final ModuleMethod string$Mnset$Ex;
    public static final ModuleMethod string$Mnupcase$Ex;
    public static final ModuleMethod string$Qu;
    public static final ModuleMethod substring;

    public static transient CharSequence $make$string$(Object aobj[])
    {
        int j = aobj.length;
        FString fstring = new FString(j);
        for (int i = 0; i < j; i++)
        {
            fstring.setCharAt(i, ((Char)aobj[i]).charValue());
        }

        return fstring;
    }

    public strings()
    {
        ModuleInfo.register(this);
    }

    public static boolean isString(Object obj)
    {
        return obj instanceof CharSequence;
    }

    public static boolean isString$Eq(Object obj, Object obj1)
    {
        return obj.toString().equals(obj1.toString());
    }

    public static boolean isString$Gr(Object obj, Object obj1)
    {
        return obj.toString().compareTo(obj1.toString()) > 0;
    }

    public static boolean isString$Gr$Eq(Object obj, Object obj1)
    {
        return obj.toString().compareTo(obj1.toString()) >= 0;
    }

    public static boolean isString$Ls(Object obj, Object obj1)
    {
        return obj.toString().compareTo(obj1.toString()) < 0;
    }

    public static boolean isString$Ls$Eq(Object obj, Object obj1)
    {
        return obj.toString().compareTo(obj1.toString()) <= 0;
    }

    public static CharSequence list$To$String(LList llist)
    {
        int j = lists.length(llist);
        Object obj = new FString(j);
        int i = 0;
        while (i < j) 
        {
            char c;
            Object obj1;
            CharSeq charseq;
            try
            {
                obj1 = (Pair)llist;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "pair", -2, llist);
            }
            try
            {
                charseq = (CharSeq)obj;
            }
            // Misplaced declaration of an exception variable
            catch (LList llist)
            {
                throw new WrongType(llist, "string-set!", 0, obj);
            }
            llist = ((LList) (((Pair) (obj1)).getCar()));
            try
            {
                c = ((Char)llist).charValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, llist);
            }
            stringSet$Ex(charseq, i, c);
            obj1 = ((Pair) (obj1)).getCdr();
            try
            {
                llist = (LList)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (LList llist)
            {
                throw new WrongType(llist, "list", -2, obj1);
            }
            i++;
        }
        return ((CharSequence) (obj));
    }

    public static CharSequence makeString(int i)
    {
        return makeString(i, Lit0);
    }

    public static CharSequence makeString(int i, Object obj)
    {
        char c;
        try
        {
            c = ((Char)obj).charValue();
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "gnu.lists.FString.<init>(int,char)", 2, obj);
        }
        return new FString(i, c);
    }

    public static LList string$To$List(CharSequence charsequence)
    {
        Object obj = LList.Empty;
        int i = stringLength(charsequence);
        do
        {
            i--;
            if (i < 0)
            {
                return ((LList) (obj));
            }
            obj = new Pair(Char.make(stringRef(charsequence, i)), obj);
        } while (true);
    }

    public static transient FString stringAppend(Object aobj[])
    {
        FString fstring = new FString();
        fstring.addAllStrings(aobj, 0);
        return fstring;
    }

    public static transient CharSequence stringAppend$SlShared(Object aobj[])
    {
        if (aobj.length == 0)
        {
            return new FString();
        }
        Object obj1 = aobj[0];
        Object obj;
        if (obj1 instanceof FString)
        {
            try
            {
                obj = (FString)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "fstr", -2, obj1);
            }
        } else
        {
            try
            {
                obj = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "string-copy", 0, obj1);
            }
            obj = stringCopy(((CharSequence) (obj)));
        }
        ((FString) (obj)).addAllStrings(aobj, 1);
        return ((CharSequence) (obj));
    }

    public static CharSequence stringCapitalize(CharSequence charsequence)
    {
        charsequence = stringCopy(charsequence);
        Strings.makeCapitalize(charsequence);
        return charsequence;
    }

    public static CharSequence stringCapitalize$Ex(CharSeq charseq)
    {
        Strings.makeCapitalize(charseq);
        return charseq;
    }

    public static FString stringCopy(CharSequence charsequence)
    {
        return new FString(charsequence);
    }

    public static CharSequence stringDowncase$Ex(CharSeq charseq)
    {
        Strings.makeLowerCase(charseq);
        return charseq;
    }

    public static void stringFill$Ex(CharSeq charseq, char c)
    {
        charseq.fill(c);
    }

    public static int stringLength(CharSequence charsequence)
    {
        return charsequence.length();
    }

    public static char stringRef(CharSequence charsequence, int i)
    {
        return charsequence.charAt(i);
    }

    public static void stringSet$Ex(CharSeq charseq, int i, char c)
    {
        charseq.setCharAt(i, c);
    }

    public static CharSequence stringUpcase$Ex(CharSeq charseq)
    {
        Strings.makeUpperCase(charseq);
        return charseq;
    }

    public static CharSequence substring(CharSequence charsequence, int i, int j)
    {
        return new FString(charsequence, i, j - i);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 17: // '\021'
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            if (isString(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 2: // '\002'
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-string", 1, obj);
            }
            return makeString(i);

        case 5: // '\005'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-length", 1, obj);
            }
            return Integer.valueOf(stringLength(modulemethod));

        case 14: // '\016'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string->list", 1, obj);
            }
            return string$To$List(modulemethod);

        case 15: // '\017'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->string", 1, obj);
            }
            return list$To$String(modulemethod);

        case 16: // '\020'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-copy", 1, obj);
            }
            return stringCopy(modulemethod);

        case 18: // '\022'
            try
            {
                modulemethod = (CharSeq)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-upcase!", 1, obj);
            }
            return stringUpcase$Ex(modulemethod);

        case 19: // '\023'
            try
            {
                modulemethod = (CharSeq)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-downcase!", 1, obj);
            }
            return stringDowncase$Ex(modulemethod);

        case 20: // '\024'
            try
            {
                modulemethod = (CharSeq)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-capitalize!", 1, obj);
            }
            return stringCapitalize$Ex(modulemethod);

        case 21: // '\025'
            break;
        }
        try
        {
            modulemethod = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "string-capitalize", 1, obj);
        }
        return stringCapitalize(modulemethod);
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 16: // '\020'
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 2: // '\002'
            char c;
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-string", 1, obj);
            }
            return makeString(i, obj1);

        case 6: // '\006'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ref", 2, obj1);
            }
            return Char.make(stringRef(modulemethod, i));

        case 8: // '\b'
            if (isString$Eq(obj, obj1))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 9: // '\t'
            if (isString$Ls(obj, obj1))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 10: // '\n'
            if (isString$Gr(obj, obj1))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 11: // '\013'
            if (isString$Ls$Eq(obj, obj1))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 12: // '\f'
            if (isString$Gr$Eq(obj, obj1))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 17: // '\021'
            break;
        }
        try
        {
            modulemethod = (CharSeq)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "string-fill!", 1, obj);
        }
        try
        {
            c = ((Char)obj1).charValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "string-fill!", 2, obj1);
        }
        stringFill$Ex(modulemethod, c);
        return Values.empty;
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 7: // '\007'
            char c;
            int i;
            int j;
            try
            {
                modulemethod = (CharSeq)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-set!", 2, obj1);
            }
            try
            {
                c = ((Char)obj2).charValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-set!", 3, obj2);
            }
            stringSet$Ex(modulemethod, i, c);
            return Values.empty;

        case 13: // '\r'
            break;
        }
        try
        {
            modulemethod = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "substring", 1, obj);
        }
        try
        {
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "substring", 2, obj1);
        }
        try
        {
            j = ((Number)obj2).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "substring", 3, obj2);
        }
        return substring(modulemethod, i, j);
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        switch (modulemethod.selector)
        {
        default:
            return super.applyN(modulemethod, aobj);

        case 4: // '\004'
            return $make$string$(aobj);

        case 22: // '\026'
            return stringAppend(aobj);

        case 23: // '\027'
            return stringAppend$SlShared(aobj);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 17: // '\021'
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 21: // '\025'
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

        case 20: // '\024'
            if (!(obj instanceof CharSeq))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 19: // '\023'
            if (!(obj instanceof CharSeq))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 18: // '\022'
            if (!(obj instanceof CharSeq))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 16: // '\020'
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

        case 15: // '\017'
            if (obj instanceof LList)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return 0xfff40001;
            }

        case 14: // '\016'
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

        case 5: // '\005'
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

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 1: // '\001'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 2 17: default 88
    //                   2 309
    //                   3 88
    //                   4 88
    //                   5 88
    //                   6 276
    //                   7 88
    //                   8 250
    //                   9 224
    //                   10 198
    //                   11 172
    //                   12 146
    //                   13 88
    //                   14 88
    //                   15 88
    //                   16 88
    //                   17 102;
           goto _L1 _L2 _L1 _L1 _L1 _L3 _L1 _L4 _L5 _L6 _L7 _L8 _L1 _L1 _L1 _L1 _L9
_L1:
        i = super.match2(modulemethod, obj, obj1, callcontext);
_L11:
        return i;
_L9:
        if (!(obj instanceof CharSeq)) goto _L11; else goto _L10
_L10:
        callcontext.value1 = obj;
        if (obj1 instanceof Char)
        {
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return 0xfff40002;
        }
_L8:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L7:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L6:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L5:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L4:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L3:
        if (!(obj instanceof CharSequence)) goto _L11; else goto _L12
_L12:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L2:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);

        case 13: // '\r'
            if (obj instanceof CharSequence)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            } else
            {
                return 0xfff40001;
            }

        case 7: // '\007'
            break;
        }
        if (!(obj instanceof CharSeq))
        {
            return 0xfff40001;
        }
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        if (obj2 instanceof Char)
        {
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        } else
        {
            return 0xfff40003;
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 23: // '\027'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 22: // '\026'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 4: // '\004'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit22 = (SimpleSymbol)(new SimpleSymbol("string-append/shared")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("string-append")).readResolve();
        Lit20 = (SimpleSymbol)(new SimpleSymbol("string-capitalize")).readResolve();
        Lit19 = (SimpleSymbol)(new SimpleSymbol("string-capitalize!")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("string-downcase!")).readResolve();
        Lit17 = (SimpleSymbol)(new SimpleSymbol("string-upcase!")).readResolve();
        Lit16 = (SimpleSymbol)(new SimpleSymbol("string-fill!")).readResolve();
        Lit15 = (SimpleSymbol)(new SimpleSymbol("string-copy")).readResolve();
        Lit14 = (SimpleSymbol)(new SimpleSymbol("list->string")).readResolve();
        Lit13 = (SimpleSymbol)(new SimpleSymbol("string->list")).readResolve();
        Lit12 = (SimpleSymbol)(new SimpleSymbol("substring")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("string>=?")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("string<=?")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("string>?")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("string<?")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("string=?")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("string-set!")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("string-ref")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("string-length")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("$make$string$")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("make-string")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("string?")).readResolve();
        $instance = new strings();
        strings strings1 = $instance;
        string$Qu = new ModuleMethod(strings1, 1, Lit1, 4097);
        make$Mnstring = new ModuleMethod(strings1, 2, Lit2, 8193);
        $make$string$ = new ModuleMethod(strings1, 4, Lit3, -4096);
        string$Mnlength = new ModuleMethod(strings1, 5, Lit4, 4097);
        string$Mnref = new ModuleMethod(strings1, 6, Lit5, 8194);
        string$Mnset$Ex = new ModuleMethod(strings1, 7, Lit6, 12291);
        string$Eq$Qu = new ModuleMethod(strings1, 8, Lit7, 8194);
        string$Ls$Qu = new ModuleMethod(strings1, 9, Lit8, 8194);
        string$Gr$Qu = new ModuleMethod(strings1, 10, Lit9, 8194);
        string$Ls$Eq$Qu = new ModuleMethod(strings1, 11, Lit10, 8194);
        string$Gr$Eq$Qu = new ModuleMethod(strings1, 12, Lit11, 8194);
        substring = new ModuleMethod(strings1, 13, Lit12, 12291);
        string$Mn$Grlist = new ModuleMethod(strings1, 14, Lit13, 4097);
        list$Mn$Grstring = new ModuleMethod(strings1, 15, Lit14, 4097);
        string$Mncopy = new ModuleMethod(strings1, 16, Lit15, 4097);
        string$Mnfill$Ex = new ModuleMethod(strings1, 17, Lit16, 8194);
        string$Mnupcase$Ex = new ModuleMethod(strings1, 18, Lit17, 4097);
        string$Mndowncase$Ex = new ModuleMethod(strings1, 19, Lit18, 4097);
        string$Mncapitalize$Ex = new ModuleMethod(strings1, 20, Lit19, 4097);
        string$Mncapitalize = new ModuleMethod(strings1, 21, Lit20, 4097);
        string$Mnappend = new ModuleMethod(strings1, 22, Lit21, -4096);
        string$Mnappend$Slshared = new ModuleMethod(strings1, 23, Lit22, -4096);
        $instance.run();
    }
}
