// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.UnicodeUtils;
import gnu.lists.FString;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.WrongType;
import gnu.text.Char;
import java.util.Locale;
import kawa.lib.misc;

public class unicode extends ModuleBody
{

    public static final unicode $instance;
    static final SimpleSymbol Lit0;
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
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod char$Mnalphabetic$Qu;
    public static final ModuleMethod char$Mnci$Eq$Qu;
    public static final ModuleMethod char$Mnci$Gr$Eq$Qu;
    public static final ModuleMethod char$Mnci$Gr$Qu;
    public static final ModuleMethod char$Mnci$Ls$Eq$Qu;
    public static final ModuleMethod char$Mnci$Ls$Qu;
    public static final ModuleMethod char$Mndowncase;
    public static final ModuleMethod char$Mnfoldcase;
    public static final ModuleMethod char$Mngeneral$Mncategory;
    public static final ModuleMethod char$Mnlower$Mncase$Qu;
    public static final ModuleMethod char$Mnnumeric$Qu;
    public static final ModuleMethod char$Mntitle$Mncase$Qu;
    public static final ModuleMethod char$Mntitlecase;
    public static final ModuleMethod char$Mnupcase;
    public static final ModuleMethod char$Mnupper$Mncase$Qu;
    public static final ModuleMethod char$Mnwhitespace$Qu;
    public static final ModuleMethod string$Mnci$Eq$Qu;
    public static final ModuleMethod string$Mnci$Gr$Eq$Qu;
    public static final ModuleMethod string$Mnci$Gr$Qu;
    public static final ModuleMethod string$Mnci$Ls$Eq$Qu;
    public static final ModuleMethod string$Mnci$Ls$Qu;
    public static final ModuleMethod string$Mndowncase;
    public static final ModuleMethod string$Mnfoldcase;
    public static final ModuleMethod string$Mnnormalize$Mnnfc;
    public static final ModuleMethod string$Mnnormalize$Mnnfd;
    public static final ModuleMethod string$Mnnormalize$Mnnfkc;
    public static final ModuleMethod string$Mnnormalize$Mnnfkd;
    public static final ModuleMethod string$Mntitlecase;
    public static final ModuleMethod string$Mnupcase;

    public unicode()
    {
        ModuleInfo.register(this);
    }

    public static Char charDowncase(Char char1)
    {
        return Char.make(Character.toLowerCase(char1.intValue()));
    }

    public static Char charFoldcase(Char char1)
    {
        int i = char1.intValue();
        boolean flag;
        if (i == 304)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag ? flag : i == 305)
        {
            return char1;
        } else
        {
            return Char.make(Character.toLowerCase(Character.toUpperCase(i)));
        }
    }

    public static Symbol charGeneralCategory(Char char1)
    {
        return UnicodeUtils.generalCategory(char1.intValue());
    }

    public static Char charTitlecase(Char char1)
    {
        return Char.make(Character.toTitleCase(char1.intValue()));
    }

    public static Char charUpcase(Char char1)
    {
        return Char.make(Character.toUpperCase(char1.intValue()));
    }

    public static boolean isCharAlphabetic(Char char1)
    {
        return Character.isLetter(char1.intValue());
    }

    public static boolean isCharCi$Eq(Char char1, Char char2)
    {
        return Character.toUpperCase(char1.intValue()) == Character.toUpperCase(char2.intValue());
    }

    public static boolean isCharCi$Gr(Char char1, Char char2)
    {
        return Character.toUpperCase(char1.intValue()) > Character.toUpperCase(char2.intValue());
    }

    public static boolean isCharCi$Gr$Eq(Char char1, Char char2)
    {
        return Character.toUpperCase(char1.intValue()) >= Character.toUpperCase(char2.intValue());
    }

    public static boolean isCharCi$Ls(Char char1, Char char2)
    {
        return Character.toUpperCase(char1.intValue()) < Character.toUpperCase(char2.intValue());
    }

    public static boolean isCharCi$Ls$Eq(Char char1, Char char2)
    {
        return Character.toUpperCase(char1.intValue()) <= Character.toUpperCase(char2.intValue());
    }

    public static boolean isCharLowerCase(Char char1)
    {
        return Character.isLowerCase(char1.intValue());
    }

    public static boolean isCharNumeric(Char char1)
    {
        return Character.isDigit(char1.intValue());
    }

    public static boolean isCharTitleCase(Char char1)
    {
        return Character.isTitleCase(char1.intValue());
    }

    public static boolean isCharUpperCase(Char char1)
    {
        return Character.isUpperCase(char1.intValue());
    }

    public static boolean isCharWhitespace(Char char1)
    {
        return UnicodeUtils.isWhitespace(char1.intValue());
    }

    public static boolean isStringCi$Eq(CharSequence charsequence, CharSequence charsequence1)
    {
        return UnicodeUtils.foldCase(charsequence).equals(UnicodeUtils.foldCase(charsequence1));
    }

    public static boolean isStringCi$Gr(CharSequence charsequence, CharSequence charsequence1)
    {
        return UnicodeUtils.foldCase(charsequence).compareTo(UnicodeUtils.foldCase(charsequence1)) > 0;
    }

    public static boolean isStringCi$Gr$Eq(CharSequence charsequence, CharSequence charsequence1)
    {
        return UnicodeUtils.foldCase(charsequence).compareTo(UnicodeUtils.foldCase(charsequence1)) >= 0;
    }

    public static boolean isStringCi$Ls(CharSequence charsequence, CharSequence charsequence1)
    {
        return UnicodeUtils.foldCase(charsequence).compareTo(UnicodeUtils.foldCase(charsequence1)) < 0;
    }

    public static boolean isStringCi$Ls$Eq(CharSequence charsequence, CharSequence charsequence1)
    {
        return UnicodeUtils.foldCase(charsequence).compareTo(UnicodeUtils.foldCase(charsequence1)) <= 0;
    }

    public static CharSequence stringDowncase(CharSequence charsequence)
    {
        return new FString(charsequence.toString().toLowerCase(Locale.ENGLISH));
    }

    public static CharSequence stringFoldcase(CharSequence charsequence)
    {
        return new FString(UnicodeUtils.foldCase(charsequence));
    }

    public static CharSequence stringNormalizeNfc(CharSequence charsequence)
    {
        return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
    }

    public static CharSequence stringNormalizeNfd(CharSequence charsequence)
    {
        return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
    }

    public static CharSequence stringNormalizeNfkc(CharSequence charsequence)
    {
        return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
    }

    public static CharSequence stringNormalizeNfkd(CharSequence charsequence)
    {
        return (CharSequence)misc.error$V("unicode string normalization not available", new Object[0]);
    }

    public static CharSequence stringTitlecase(CharSequence charsequence)
    {
        if (charsequence == null)
        {
            charsequence = null;
        } else
        {
            charsequence = charsequence.toString();
        }
        return new FString(UnicodeUtils.capitalize(charsequence));
    }

    public static CharSequence stringUpcase(CharSequence charsequence)
    {
        return new FString(charsequence.toString().toUpperCase(Locale.ENGLISH));
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-upcase", 1, obj);
            }
            return charUpcase(modulemethod);

        case 2: // '\002'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-downcase", 1, obj);
            }
            return charDowncase(modulemethod);

        case 3: // '\003'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-titlecase", 1, obj);
            }
            return charTitlecase(modulemethod);

        case 4: // '\004'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-alphabetic?", 1, obj);
            }
            if (isCharAlphabetic(modulemethod))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 5: // '\005'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-numeric?", 1, obj);
            }
            if (isCharNumeric(modulemethod))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 6: // '\006'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-whitespace?", 1, obj);
            }
            if (isCharWhitespace(modulemethod))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 7: // '\007'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-upper-case?", 1, obj);
            }
            if (isCharUpperCase(modulemethod))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 8: // '\b'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-lower-case?", 1, obj);
            }
            if (isCharLowerCase(modulemethod))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 9: // '\t'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-title-case?", 1, obj);
            }
            if (isCharTitleCase(modulemethod))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 10: // '\n'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-foldcase", 1, obj);
            }
            return charFoldcase(modulemethod);

        case 16: // '\020'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-general-category", 1, obj);
            }
            return charGeneralCategory(modulemethod);

        case 17: // '\021'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-upcase", 1, obj);
            }
            return stringUpcase(modulemethod);

        case 18: // '\022'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-downcase", 1, obj);
            }
            return stringDowncase(modulemethod);

        case 19: // '\023'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-titlecase", 1, obj);
            }
            return stringTitlecase(modulemethod);

        case 20: // '\024'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-foldcase", 1, obj);
            }
            return stringFoldcase(modulemethod);

        case 26: // '\032'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-normalize-nfd", 1, obj);
            }
            return stringNormalizeNfd(modulemethod);

        case 27: // '\033'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-normalize-nfkd", 1, obj);
            }
            return stringNormalizeNfkd(modulemethod);

        case 28: // '\034'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-normalize-nfc", 1, obj);
            }
            return stringNormalizeNfc(modulemethod);

        case 29: // '\035'
            break;
        }
        try
        {
            modulemethod = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "string-normalize-nfkc", 1, obj);
        }
        return stringNormalizeNfkc(modulemethod);
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 11: // '\013'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci=?", 1, obj);
            }
            try
            {
                obj = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci=?", 2, obj1);
            }
            if (isCharCi$Eq(modulemethod, ((Char) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 12: // '\f'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci<?", 1, obj);
            }
            try
            {
                obj = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci<?", 2, obj1);
            }
            if (isCharCi$Ls(modulemethod, ((Char) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 13: // '\r'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci>?", 1, obj);
            }
            try
            {
                obj = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci>?", 2, obj1);
            }
            if (isCharCi$Gr(modulemethod, ((Char) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 14: // '\016'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci<=?", 1, obj);
            }
            try
            {
                obj = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci<=?", 2, obj1);
            }
            if (isCharCi$Ls$Eq(modulemethod, ((Char) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 15: // '\017'
            try
            {
                modulemethod = (Char)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci>=?", 1, obj);
            }
            try
            {
                obj = (Char)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "char-ci>=?", 2, obj1);
            }
            if (isCharCi$Gr$Eq(modulemethod, ((Char) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 21: // '\025'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci=?", 1, obj);
            }
            try
            {
                obj = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci=?", 2, obj1);
            }
            if (isStringCi$Eq(modulemethod, ((CharSequence) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 22: // '\026'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci<?", 1, obj);
            }
            try
            {
                obj = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci<?", 2, obj1);
            }
            if (isStringCi$Ls(modulemethod, ((CharSequence) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 23: // '\027'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci>?", 1, obj);
            }
            try
            {
                obj = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci>?", 2, obj1);
            }
            if (isStringCi$Gr(modulemethod, ((CharSequence) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 24: // '\030'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci<=?", 1, obj);
            }
            try
            {
                obj = (CharSequence)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci<=?", 2, obj1);
            }
            if (isStringCi$Ls$Eq(modulemethod, ((CharSequence) (obj))))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 25: // '\031'
            break;
        }
        try
        {
            modulemethod = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "string-ci>=?", 1, obj);
        }
        try
        {
            obj = (CharSequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "string-ci>=?", 2, obj1);
        }
        if (isStringCi$Gr$Eq(modulemethod, ((CharSequence) (obj))))
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 29: // '\035'
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

        case 28: // '\034'
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

        case 27: // '\033'
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

        case 26: // '\032'
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

        case 19: // '\023'
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

        case 18: // '\022'
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

        case 17: // '\021'
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

        case 16: // '\020'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 10: // '\n'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 9: // '\t'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 8: // '\b'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 7: // '\007'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 6: // '\006'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 5: // '\005'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 4: // '\004'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 3: // '\003'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 2: // '\002'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 1: // '\001'
            break;
        }
        if (!(obj instanceof Char))
        {
            return 0xfff40001;
        } else
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 19: // '\023'
        case 20: // '\024'
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 25: // '\031'
            if (obj instanceof CharSequence)
            {
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
            } else
            {
                return 0xfff40001;
            }

        case 24: // '\030'
            if (obj instanceof CharSequence)
            {
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
            } else
            {
                return 0xfff40001;
            }

        case 23: // '\027'
            if (obj instanceof CharSequence)
            {
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
            } else
            {
                return 0xfff40001;
            }

        case 22: // '\026'
            if (obj instanceof CharSequence)
            {
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
            } else
            {
                return 0xfff40001;
            }

        case 21: // '\025'
            if (obj instanceof CharSequence)
            {
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
            } else
            {
                return 0xfff40001;
            }

        case 15: // '\017'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            }
            callcontext.value1 = obj;
            if (!(obj1 instanceof Char))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 14: // '\016'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            }
            callcontext.value1 = obj;
            if (!(obj1 instanceof Char))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 13: // '\r'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            }
            callcontext.value1 = obj;
            if (!(obj1 instanceof Char))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 12: // '\f'
            if (!(obj instanceof Char))
            {
                return 0xfff40001;
            }
            callcontext.value1 = obj;
            if (!(obj1 instanceof Char))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 11: // '\013'
            break;
        }
        if (!(obj instanceof Char))
        {
            return 0xfff40001;
        }
        callcontext.value1 = obj;
        if (!(obj1 instanceof Char))
        {
            return 0xfff40002;
        } else
        {
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit28 = (SimpleSymbol)(new SimpleSymbol("string-normalize-nfkc")).readResolve();
        Lit27 = (SimpleSymbol)(new SimpleSymbol("string-normalize-nfc")).readResolve();
        Lit26 = (SimpleSymbol)(new SimpleSymbol("string-normalize-nfkd")).readResolve();
        Lit25 = (SimpleSymbol)(new SimpleSymbol("string-normalize-nfd")).readResolve();
        Lit24 = (SimpleSymbol)(new SimpleSymbol("string-ci>=?")).readResolve();
        Lit23 = (SimpleSymbol)(new SimpleSymbol("string-ci<=?")).readResolve();
        Lit22 = (SimpleSymbol)(new SimpleSymbol("string-ci>?")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("string-ci<?")).readResolve();
        Lit20 = (SimpleSymbol)(new SimpleSymbol("string-ci=?")).readResolve();
        Lit19 = (SimpleSymbol)(new SimpleSymbol("string-foldcase")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("string-titlecase")).readResolve();
        Lit17 = (SimpleSymbol)(new SimpleSymbol("string-downcase")).readResolve();
        Lit16 = (SimpleSymbol)(new SimpleSymbol("string-upcase")).readResolve();
        Lit15 = (SimpleSymbol)(new SimpleSymbol("char-general-category")).readResolve();
        Lit14 = (SimpleSymbol)(new SimpleSymbol("char-ci>=?")).readResolve();
        Lit13 = (SimpleSymbol)(new SimpleSymbol("char-ci<=?")).readResolve();
        Lit12 = (SimpleSymbol)(new SimpleSymbol("char-ci>?")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("char-ci<?")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("char-ci=?")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("char-foldcase")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("char-title-case?")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("char-lower-case?")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("char-upper-case?")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("char-whitespace?")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("char-numeric?")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("char-alphabetic?")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("char-titlecase")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("char-downcase")).readResolve();
        Lit0 = (SimpleSymbol)(new SimpleSymbol("char-upcase")).readResolve();
        $instance = new unicode();
        unicode unicode1 = $instance;
        char$Mnupcase = new ModuleMethod(unicode1, 1, Lit0, 4097);
        char$Mndowncase = new ModuleMethod(unicode1, 2, Lit1, 4097);
        char$Mntitlecase = new ModuleMethod(unicode1, 3, Lit2, 4097);
        char$Mnalphabetic$Qu = new ModuleMethod(unicode1, 4, Lit3, 4097);
        char$Mnnumeric$Qu = new ModuleMethod(unicode1, 5, Lit4, 4097);
        char$Mnwhitespace$Qu = new ModuleMethod(unicode1, 6, Lit5, 4097);
        char$Mnupper$Mncase$Qu = new ModuleMethod(unicode1, 7, Lit6, 4097);
        char$Mnlower$Mncase$Qu = new ModuleMethod(unicode1, 8, Lit7, 4097);
        char$Mntitle$Mncase$Qu = new ModuleMethod(unicode1, 9, Lit8, 4097);
        char$Mnfoldcase = new ModuleMethod(unicode1, 10, Lit9, 4097);
        char$Mnci$Eq$Qu = new ModuleMethod(unicode1, 11, Lit10, 8194);
        char$Mnci$Ls$Qu = new ModuleMethod(unicode1, 12, Lit11, 8194);
        char$Mnci$Gr$Qu = new ModuleMethod(unicode1, 13, Lit12, 8194);
        char$Mnci$Ls$Eq$Qu = new ModuleMethod(unicode1, 14, Lit13, 8194);
        char$Mnci$Gr$Eq$Qu = new ModuleMethod(unicode1, 15, Lit14, 8194);
        char$Mngeneral$Mncategory = new ModuleMethod(unicode1, 16, Lit15, 4097);
        string$Mnupcase = new ModuleMethod(unicode1, 17, Lit16, 4097);
        string$Mndowncase = new ModuleMethod(unicode1, 18, Lit17, 4097);
        string$Mntitlecase = new ModuleMethod(unicode1, 19, Lit18, 4097);
        string$Mnfoldcase = new ModuleMethod(unicode1, 20, Lit19, 4097);
        string$Mnci$Eq$Qu = new ModuleMethod(unicode1, 21, Lit20, 8194);
        string$Mnci$Ls$Qu = new ModuleMethod(unicode1, 22, Lit21, 8194);
        string$Mnci$Gr$Qu = new ModuleMethod(unicode1, 23, Lit22, 8194);
        string$Mnci$Ls$Eq$Qu = new ModuleMethod(unicode1, 24, Lit23, 8194);
        string$Mnci$Gr$Eq$Qu = new ModuleMethod(unicode1, 25, Lit24, 8194);
        string$Mnnormalize$Mnnfd = new ModuleMethod(unicode1, 26, Lit25, 4097);
        string$Mnnormalize$Mnnfkd = new ModuleMethod(unicode1, 27, Lit26, 4097);
        string$Mnnormalize$Mnnfc = new ModuleMethod(unicode1, 28, Lit27, 4097);
        string$Mnnormalize$Mnnfkc = new ModuleMethod(unicode1, 29, Lit28, 4097);
        $instance.run();
    }
}
