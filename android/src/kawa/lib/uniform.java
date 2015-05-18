// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.F32Vector;
import gnu.lists.F64Vector;
import gnu.lists.LList;
import gnu.lists.S16Vector;
import gnu.lists.S32Vector;
import gnu.lists.S64Vector;
import gnu.lists.S8Vector;
import gnu.lists.U16Vector;
import gnu.lists.U32Vector;
import gnu.lists.U64Vector;
import gnu.lists.U8Vector;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;

public class uniform extends ModuleBody
{

    public static final uniform $instance;
    static final IntNum Lit0 = IntNum.make(0);
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
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit32;
    static final SimpleSymbol Lit33;
    static final SimpleSymbol Lit34;
    static final SimpleSymbol Lit35;
    static final SimpleSymbol Lit36;
    static final SimpleSymbol Lit37;
    static final SimpleSymbol Lit38;
    static final SimpleSymbol Lit39;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit40;
    static final SimpleSymbol Lit41;
    static final SimpleSymbol Lit42;
    static final SimpleSymbol Lit43;
    static final SimpleSymbol Lit44;
    static final SimpleSymbol Lit45;
    static final SimpleSymbol Lit46;
    static final SimpleSymbol Lit47;
    static final SimpleSymbol Lit48;
    static final SimpleSymbol Lit49;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit50;
    static final SimpleSymbol Lit51;
    static final SimpleSymbol Lit52;
    static final SimpleSymbol Lit53;
    static final SimpleSymbol Lit54;
    static final SimpleSymbol Lit55;
    static final SimpleSymbol Lit56;
    static final SimpleSymbol Lit57;
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit60;
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62;
    static final SimpleSymbol Lit63;
    static final SimpleSymbol Lit64;
    static final SimpleSymbol Lit65;
    static final SimpleSymbol Lit66;
    static final SimpleSymbol Lit67;
    static final SimpleSymbol Lit68;
    static final SimpleSymbol Lit69;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit70;
    static final SimpleSymbol Lit71;
    static final SimpleSymbol Lit72;
    static final SimpleSymbol Lit73;
    static final SimpleSymbol Lit74;
    static final SimpleSymbol Lit75;
    static final SimpleSymbol Lit76;
    static final SimpleSymbol Lit77;
    static final SimpleSymbol Lit78;
    static final SimpleSymbol Lit79;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit80;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod f32vector;
    public static final ModuleMethod f32vector$Mn$Grlist;
    public static final ModuleMethod f32vector$Mnlength;
    public static final ModuleMethod f32vector$Mnref;
    public static final ModuleMethod f32vector$Mnset$Ex;
    public static final ModuleMethod f32vector$Qu;
    public static final ModuleMethod f64vector;
    public static final ModuleMethod f64vector$Mn$Grlist;
    public static final ModuleMethod f64vector$Mnlength;
    public static final ModuleMethod f64vector$Mnref;
    public static final ModuleMethod f64vector$Mnset$Ex;
    public static final ModuleMethod f64vector$Qu;
    public static final ModuleMethod list$Mn$Grf32vector;
    public static final ModuleMethod list$Mn$Grf64vector;
    public static final ModuleMethod list$Mn$Grs16vector;
    public static final ModuleMethod list$Mn$Grs32vector;
    public static final ModuleMethod list$Mn$Grs64vector;
    public static final ModuleMethod list$Mn$Grs8vector;
    public static final ModuleMethod list$Mn$Gru16vector;
    public static final ModuleMethod list$Mn$Gru32vector;
    public static final ModuleMethod list$Mn$Gru64vector;
    public static final ModuleMethod list$Mn$Gru8vector;
    public static final ModuleMethod make$Mnf32vector;
    public static final ModuleMethod make$Mnf64vector;
    public static final ModuleMethod make$Mns16vector;
    public static final ModuleMethod make$Mns32vector;
    public static final ModuleMethod make$Mns64vector;
    public static final ModuleMethod make$Mns8vector;
    public static final ModuleMethod make$Mnu16vector;
    public static final ModuleMethod make$Mnu32vector;
    public static final ModuleMethod make$Mnu64vector;
    public static final ModuleMethod make$Mnu8vector;
    public static final ModuleMethod s16vector;
    public static final ModuleMethod s16vector$Mn$Grlist;
    public static final ModuleMethod s16vector$Mnlength;
    public static final ModuleMethod s16vector$Mnref;
    public static final ModuleMethod s16vector$Mnset$Ex;
    public static final ModuleMethod s16vector$Qu;
    public static final ModuleMethod s32vector;
    public static final ModuleMethod s32vector$Mn$Grlist;
    public static final ModuleMethod s32vector$Mnlength;
    public static final ModuleMethod s32vector$Mnref;
    public static final ModuleMethod s32vector$Mnset$Ex;
    public static final ModuleMethod s32vector$Qu;
    public static final ModuleMethod s64vector;
    public static final ModuleMethod s64vector$Mn$Grlist;
    public static final ModuleMethod s64vector$Mnlength;
    public static final ModuleMethod s64vector$Mnref;
    public static final ModuleMethod s64vector$Mnset$Ex;
    public static final ModuleMethod s64vector$Qu;
    public static final ModuleMethod s8vector;
    public static final ModuleMethod s8vector$Mn$Grlist;
    public static final ModuleMethod s8vector$Mnlength;
    public static final ModuleMethod s8vector$Mnref;
    public static final ModuleMethod s8vector$Mnset$Ex;
    public static final ModuleMethod s8vector$Qu;
    public static final ModuleMethod u16vector;
    public static final ModuleMethod u16vector$Mn$Grlist;
    public static final ModuleMethod u16vector$Mnlength;
    public static final ModuleMethod u16vector$Mnref;
    public static final ModuleMethod u16vector$Mnset$Ex;
    public static final ModuleMethod u16vector$Qu;
    public static final ModuleMethod u32vector;
    public static final ModuleMethod u32vector$Mn$Grlist;
    public static final ModuleMethod u32vector$Mnlength;
    public static final ModuleMethod u32vector$Mnref;
    public static final ModuleMethod u32vector$Mnset$Ex;
    public static final ModuleMethod u32vector$Qu;
    public static final ModuleMethod u64vector;
    public static final ModuleMethod u64vector$Mn$Grlist;
    public static final ModuleMethod u64vector$Mnlength;
    public static final ModuleMethod u64vector$Mnref;
    public static final ModuleMethod u64vector$Mnset$Ex;
    public static final ModuleMethod u64vector$Qu;
    public static final ModuleMethod u8vector;
    public static final ModuleMethod u8vector$Mn$Grlist;
    public static final ModuleMethod u8vector$Mnlength;
    public static final ModuleMethod u8vector$Mnref;
    public static final ModuleMethod u8vector$Mnset$Ex;
    public static final ModuleMethod u8vector$Qu;

    public uniform()
    {
        ModuleInfo.register(this);
    }

    public static LList f32vector$To$List(F32Vector f32vector1)
    {
        return LList.makeList(f32vector1);
    }

    public static F32Vector f32vector$V(Object aobj[])
    {
        return list$To$F32vector(LList.makeList(aobj, 0));
    }

    public static int f32vectorLength(F32Vector f32vector1)
    {
        return f32vector1.size();
    }

    public static float f32vectorRef(F32Vector f32vector1, int i)
    {
        return f32vector1.floatAt(i);
    }

    public static void f32vectorSet$Ex(F32Vector f32vector1, int i, float f)
    {
        f32vector1.setFloatAt(i, f);
    }

    public static LList f64vector$To$List(F64Vector f64vector1)
    {
        return LList.makeList(f64vector1);
    }

    public static F64Vector f64vector$V(Object aobj[])
    {
        return list$To$F64vector(LList.makeList(aobj, 0));
    }

    public static int f64vectorLength(F64Vector f64vector1)
    {
        return f64vector1.size();
    }

    public static double f64vectorRef(F64Vector f64vector1, int i)
    {
        return f64vector1.doubleAt(i);
    }

    public static void f64vectorSet$Ex(F64Vector f64vector1, int i, double d)
    {
        f64vector1.setDoubleAt(i, d);
    }

    public static boolean isF32vector(Object obj)
    {
        return obj instanceof F32Vector;
    }

    public static boolean isF64vector(Object obj)
    {
        return obj instanceof F64Vector;
    }

    public static boolean isS16vector(Object obj)
    {
        return obj instanceof S16Vector;
    }

    public static boolean isS32vector(Object obj)
    {
        return obj instanceof S32Vector;
    }

    public static boolean isS64vector(Object obj)
    {
        return obj instanceof S64Vector;
    }

    public static boolean isS8vector(Object obj)
    {
        return obj instanceof S8Vector;
    }

    public static boolean isU16vector(Object obj)
    {
        return obj instanceof U16Vector;
    }

    public static boolean isU32vector(Object obj)
    {
        return obj instanceof U32Vector;
    }

    public static boolean isU64vector(Object obj)
    {
        return obj instanceof U64Vector;
    }

    public static boolean isU8vector(Object obj)
    {
        return obj instanceof U8Vector;
    }

    public static F32Vector list$To$F32vector(LList llist)
    {
        return new F32Vector(llist);
    }

    public static F64Vector list$To$F64vector(LList llist)
    {
        return new F64Vector(llist);
    }

    public static S16Vector list$To$S16vector(LList llist)
    {
        return new S16Vector(llist);
    }

    public static S32Vector list$To$S32vector(LList llist)
    {
        return new S32Vector(llist);
    }

    public static S64Vector list$To$S64vector(LList llist)
    {
        return new S64Vector(llist);
    }

    public static S8Vector list$To$S8vector(LList llist)
    {
        return new S8Vector(llist);
    }

    public static U16Vector list$To$U16vector(LList llist)
    {
        return new U16Vector(llist);
    }

    public static U32Vector list$To$U32vector(LList llist)
    {
        return new U32Vector(llist);
    }

    public static U64Vector list$To$U64vector(LList llist)
    {
        return new U64Vector(llist);
    }

    public static U8Vector list$To$U8vector(LList llist)
    {
        return new U8Vector(llist);
    }

    public static F32Vector makeF32vector(int i)
    {
        return makeF32vector(i, 0.0F);
    }

    public static F32Vector makeF32vector(int i, float f)
    {
        return new F32Vector(i, f);
    }

    public static F64Vector makeF64vector(int i)
    {
        return makeF64vector(i, 0.0D);
    }

    public static F64Vector makeF64vector(int i, double d)
    {
        return new F64Vector(i, d);
    }

    public static S16Vector makeS16vector(int i)
    {
        return makeS16vector(i, 0);
    }

    public static S16Vector makeS16vector(int i, int j)
    {
        return new S16Vector(i, (short)j);
    }

    public static S32Vector makeS32vector(int i)
    {
        return makeS32vector(i, 0);
    }

    public static S32Vector makeS32vector(int i, int j)
    {
        return new S32Vector(i, j);
    }

    public static S64Vector makeS64vector(int i)
    {
        return makeS64vector(i, 0L);
    }

    public static S64Vector makeS64vector(int i, long l)
    {
        return new S64Vector(i, l);
    }

    public static S8Vector makeS8vector(int i)
    {
        return makeS8vector(i, 0);
    }

    public static S8Vector makeS8vector(int i, int j)
    {
        return new S8Vector(i, (byte)j);
    }

    public static U16Vector makeU16vector(int i)
    {
        return makeU16vector(i, 0);
    }

    public static U16Vector makeU16vector(int i, int j)
    {
        return new U16Vector(i, (short)j);
    }

    public static U32Vector makeU32vector(int i)
    {
        return makeU32vector(i, 0L);
    }

    public static U32Vector makeU32vector(int i, long l)
    {
        return new U32Vector(i, (int)l);
    }

    public static U64Vector makeU64vector(int i)
    {
        return makeU64vector(i, Lit0);
    }

    public static U64Vector makeU64vector(int i, IntNum intnum)
    {
        long l;
        try
        {
            l = intnum.longValue();
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "gnu.lists.U64Vector.<init>(int,long)", 2, intnum);
        }
        return new U64Vector(i, l);
    }

    public static U8Vector makeU8vector(int i)
    {
        return makeU8vector(i, 0);
    }

    public static U8Vector makeU8vector(int i, int j)
    {
        return new U8Vector(i, (byte)j);
    }

    public static LList s16vector$To$List(S16Vector s16vector1)
    {
        return LList.makeList(s16vector1);
    }

    public static S16Vector s16vector$V(Object aobj[])
    {
        return list$To$S16vector(LList.makeList(aobj, 0));
    }

    public static int s16vectorLength(S16Vector s16vector1)
    {
        return s16vector1.size();
    }

    public static int s16vectorRef(S16Vector s16vector1, int i)
    {
        return s16vector1.intAt(i);
    }

    public static void s16vectorSet$Ex(S16Vector s16vector1, int i, int j)
    {
        s16vector1.setShortAt(i, (short)j);
    }

    public static LList s32vector$To$List(S32Vector s32vector1)
    {
        return LList.makeList(s32vector1);
    }

    public static S32Vector s32vector$V(Object aobj[])
    {
        return list$To$S32vector(LList.makeList(aobj, 0));
    }

    public static int s32vectorLength(S32Vector s32vector1)
    {
        return s32vector1.size();
    }

    public static int s32vectorRef(S32Vector s32vector1, int i)
    {
        return s32vector1.intAt(i);
    }

    public static void s32vectorSet$Ex(S32Vector s32vector1, int i, int j)
    {
        s32vector1.setIntAt(i, j);
    }

    public static LList s64vector$To$List(S64Vector s64vector1)
    {
        return LList.makeList(s64vector1);
    }

    public static S64Vector s64vector$V(Object aobj[])
    {
        return list$To$S64vector(LList.makeList(aobj, 0));
    }

    public static int s64vectorLength(S64Vector s64vector1)
    {
        return s64vector1.size();
    }

    public static long s64vectorRef(S64Vector s64vector1, int i)
    {
        return s64vector1.longAt(i);
    }

    public static void s64vectorSet$Ex(S64Vector s64vector1, int i, long l)
    {
        s64vector1.setLongAt(i, l);
    }

    public static LList s8vector$To$List(S8Vector s8vector1)
    {
        return LList.makeList(s8vector1);
    }

    public static S8Vector s8vector$V(Object aobj[])
    {
        return list$To$S8vector(LList.makeList(aobj, 0));
    }

    public static int s8vectorLength(S8Vector s8vector1)
    {
        return s8vector1.size();
    }

    public static int s8vectorRef(S8Vector s8vector1, int i)
    {
        return s8vector1.intAt(i);
    }

    public static void s8vectorSet$Ex(S8Vector s8vector1, int i, int j)
    {
        s8vector1.setByteAt(i, (byte)j);
    }

    public static LList u16vector$To$List(U16Vector u16vector1)
    {
        return LList.makeList(u16vector1);
    }

    public static U16Vector u16vector$V(Object aobj[])
    {
        return list$To$U16vector(LList.makeList(aobj, 0));
    }

    public static int u16vectorLength(U16Vector u16vector1)
    {
        return u16vector1.size();
    }

    public static int u16vectorRef(U16Vector u16vector1, int i)
    {
        return u16vector1.intAt(i);
    }

    public static void u16vectorSet$Ex(U16Vector u16vector1, int i, int j)
    {
        u16vector1.setShortAt(i, (short)j);
    }

    public static LList u32vector$To$List(U32Vector u32vector1)
    {
        return LList.makeList(u32vector1);
    }

    public static U32Vector u32vector$V(Object aobj[])
    {
        return list$To$U32vector(LList.makeList(aobj, 0));
    }

    public static int u32vectorLength(U32Vector u32vector1)
    {
        return u32vector1.size();
    }

    public static long u32vectorRef(U32Vector u32vector1, int i)
    {
        return ((Number)u32vector1.get(i)).longValue();
    }

    public static void u32vectorSet$Ex(U32Vector u32vector1, int i, long l)
    {
        u32vector1.setIntAt(i, (int)l);
    }

    public static LList u64vector$To$List(U64Vector u64vector1)
    {
        return LList.makeList(u64vector1);
    }

    public static U64Vector u64vector$V(Object aobj[])
    {
        return list$To$U64vector(LList.makeList(aobj, 0));
    }

    public static int u64vectorLength(U64Vector u64vector1)
    {
        return u64vector1.size();
    }

    public static IntNum u64vectorRef(U64Vector u64vector1, int i)
    {
        return LangObjType.coerceIntNum(u64vector1.get(i));
    }

    public static void u64vectorSet$Ex(U64Vector u64vector1, int i, IntNum intnum)
    {
        long l;
        try
        {
            l = intnum.longValue();
        }
        // Misplaced declaration of an exception variable
        catch (U64Vector u64vector1)
        {
            throw new WrongType(u64vector1, "gnu.lists.U64Vector.setLongAt(int,long)", 3, intnum);
        }
        u64vector1.setLongAt(i, l);
    }

    public static LList u8vector$To$List(U8Vector u8vector1)
    {
        return LList.makeList(u8vector1);
    }

    public static U8Vector u8vector$V(Object aobj[])
    {
        return list$To$U8vector(LList.makeList(aobj, 0));
    }

    public static int u8vectorLength(U8Vector u8vector1)
    {
        return u8vector1.size();
    }

    public static int u8vectorRef(U8Vector u8vector1, int i)
    {
        return u8vector1.intAt(i);
    }

    public static void u8vectorSet$Ex(U8Vector u8vector1, int i, int j)
    {
        u8vector1.setByteAt(i, (byte)j);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 3: // '\003'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 12: // '\f'
        case 13: // '\r'
        case 15: // '\017'
        case 16: // '\020'
        case 21: // '\025'
        case 22: // '\026'
        case 24: // '\030'
        case 25: // '\031'
        case 30: // '\036'
        case 31: // '\037'
        case 33: // '!'
        case 34: // '"'
        case 39: // '\''
        case 40: // '('
        case 42: // '*'
        case 43: // '+'
        case 48: // '0'
        case 49: // '1'
        case 51: // '3'
        case 52: // '4'
        case 57: // '9'
        case 58: // ':'
        case 60: // '<'
        case 61: // '='
        case 66: // 'B'
        case 67: // 'C'
        case 69: // 'E'
        case 70: // 'F'
        case 75: // 'K'
        case 76: // 'L'
        case 78: // 'N'
        case 79: // 'O'
        case 84: // 'T'
        case 85: // 'U'
        case 87: // 'W'
        case 88: // 'X'
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            if (isS8vector(obj))
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
                throw new WrongType(modulemethod, "make-s8vector", 1, obj);
            }
            return makeS8vector(i);

        case 5: // '\005'
            try
            {
                modulemethod = (S8Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s8vector-length", 1, obj);
            }
            return Integer.valueOf(s8vectorLength(modulemethod));

        case 8: // '\b'
            try
            {
                modulemethod = (S8Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s8vector->list", 1, obj);
            }
            return s8vector$To$List(modulemethod);

        case 9: // '\t'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->s8vector", 1, obj);
            }
            return list$To$S8vector(modulemethod);

        case 10: // '\n'
            if (isU8vector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 11: // '\013'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u8vector", 1, obj);
            }
            return makeU8vector(i);

        case 14: // '\016'
            try
            {
                modulemethod = (U8Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u8vector-length", 1, obj);
            }
            return Integer.valueOf(u8vectorLength(modulemethod));

        case 17: // '\021'
            try
            {
                modulemethod = (U8Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u8vector->list", 1, obj);
            }
            return u8vector$To$List(modulemethod);

        case 18: // '\022'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->u8vector", 1, obj);
            }
            return list$To$U8vector(modulemethod);

        case 19: // '\023'
            if (isS16vector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 20: // '\024'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s16vector", 1, obj);
            }
            return makeS16vector(i);

        case 23: // '\027'
            try
            {
                modulemethod = (S16Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s16vector-length", 1, obj);
            }
            return Integer.valueOf(s16vectorLength(modulemethod));

        case 26: // '\032'
            try
            {
                modulemethod = (S16Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s16vector->list", 1, obj);
            }
            return s16vector$To$List(modulemethod);

        case 27: // '\033'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->s16vector", 1, obj);
            }
            return list$To$S16vector(modulemethod);

        case 28: // '\034'
            if (isU16vector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 29: // '\035'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u16vector", 1, obj);
            }
            return makeU16vector(i);

        case 32: // ' '
            try
            {
                modulemethod = (U16Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u16vector-length", 1, obj);
            }
            return Integer.valueOf(u16vectorLength(modulemethod));

        case 35: // '#'
            try
            {
                modulemethod = (U16Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u16vector->list", 1, obj);
            }
            return u16vector$To$List(modulemethod);

        case 36: // '$'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->u16vector", 1, obj);
            }
            return list$To$U16vector(modulemethod);

        case 37: // '%'
            if (isS32vector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 38: // '&'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s32vector", 1, obj);
            }
            return makeS32vector(i);

        case 41: // ')'
            try
            {
                modulemethod = (S32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s32vector-length", 1, obj);
            }
            return Integer.valueOf(s32vectorLength(modulemethod));

        case 44: // ','
            try
            {
                modulemethod = (S32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s32vector->list", 1, obj);
            }
            return s32vector$To$List(modulemethod);

        case 45: // '-'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->s32vector", 1, obj);
            }
            return list$To$S32vector(modulemethod);

        case 46: // '.'
            if (isU32vector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 47: // '/'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u32vector", 1, obj);
            }
            return makeU32vector(i);

        case 50: // '2'
            try
            {
                modulemethod = (U32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u32vector-length", 1, obj);
            }
            return Integer.valueOf(u32vectorLength(modulemethod));

        case 53: // '5'
            try
            {
                modulemethod = (U32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u32vector->list", 1, obj);
            }
            return u32vector$To$List(modulemethod);

        case 54: // '6'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->u32vector", 1, obj);
            }
            return list$To$U32vector(modulemethod);

        case 55: // '7'
            if (isS64vector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 56: // '8'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s64vector", 1, obj);
            }
            return makeS64vector(i);

        case 59: // ';'
            try
            {
                modulemethod = (S64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s64vector-length", 1, obj);
            }
            return Integer.valueOf(s64vectorLength(modulemethod));

        case 62: // '>'
            try
            {
                modulemethod = (S64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s64vector->list", 1, obj);
            }
            return s64vector$To$List(modulemethod);

        case 63: // '?'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->s64vector", 1, obj);
            }
            return list$To$S64vector(modulemethod);

        case 64: // '@'
            if (isU64vector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 65: // 'A'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u64vector", 1, obj);
            }
            return makeU64vector(i);

        case 68: // 'D'
            try
            {
                modulemethod = (U64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u64vector-length", 1, obj);
            }
            return Integer.valueOf(u64vectorLength(modulemethod));

        case 71: // 'G'
            try
            {
                modulemethod = (U64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u64vector->list", 1, obj);
            }
            return u64vector$To$List(modulemethod);

        case 72: // 'H'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->u64vector", 1, obj);
            }
            return list$To$U64vector(modulemethod);

        case 73: // 'I'
            if (isF32vector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 74: // 'J'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-f32vector", 1, obj);
            }
            return makeF32vector(i);

        case 77: // 'M'
            try
            {
                modulemethod = (F32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "f32vector-length", 1, obj);
            }
            return Integer.valueOf(f32vectorLength(modulemethod));

        case 80: // 'P'
            try
            {
                modulemethod = (F32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "f32vector->list", 1, obj);
            }
            return f32vector$To$List(modulemethod);

        case 81: // 'Q'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list->f32vector", 1, obj);
            }
            return list$To$F32vector(modulemethod);

        case 82: // 'R'
            if (isF64vector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 83: // 'S'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-f64vector", 1, obj);
            }
            return makeF64vector(i);

        case 86: // 'V'
            try
            {
                modulemethod = (F64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "f64vector-length", 1, obj);
            }
            return Integer.valueOf(f64vectorLength(modulemethod));

        case 89: // 'Y'
            try
            {
                modulemethod = (F64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "f64vector->list", 1, obj);
            }
            return f64vector$To$List(modulemethod);

        case 90: // 'Z'
            break;
        }
        try
        {
            modulemethod = (LList)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "list->f64vector", 1, obj);
        }
        return list$To$F64vector(modulemethod);
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 2: // '\002'
            double d;
            float f;
            int i;
            int j;
            long l;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s8vector", 1, obj);
            }
            try
            {
                j = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s8vector", 2, obj1);
            }
            return makeS8vector(i, j);

        case 6: // '\006'
            try
            {
                modulemethod = (S8Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s8vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s8vector-ref", 2, obj1);
            }
            return Integer.valueOf(s8vectorRef(modulemethod, i));

        case 11: // '\013'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u8vector", 1, obj);
            }
            try
            {
                j = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u8vector", 2, obj1);
            }
            return makeU8vector(i, j);

        case 15: // '\017'
            try
            {
                modulemethod = (U8Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u8vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u8vector-ref", 2, obj1);
            }
            return Integer.valueOf(u8vectorRef(modulemethod, i));

        case 20: // '\024'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s16vector", 1, obj);
            }
            try
            {
                j = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s16vector", 2, obj1);
            }
            return makeS16vector(i, j);

        case 24: // '\030'
            try
            {
                modulemethod = (S16Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s16vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s16vector-ref", 2, obj1);
            }
            return Integer.valueOf(s16vectorRef(modulemethod, i));

        case 29: // '\035'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u16vector", 1, obj);
            }
            try
            {
                j = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u16vector", 2, obj1);
            }
            return makeU16vector(i, j);

        case 33: // '!'
            try
            {
                modulemethod = (U16Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u16vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u16vector-ref", 2, obj1);
            }
            return Integer.valueOf(u16vectorRef(modulemethod, i));

        case 38: // '&'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s32vector", 1, obj);
            }
            try
            {
                j = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s32vector", 2, obj1);
            }
            return makeS32vector(i, j);

        case 42: // '*'
            try
            {
                modulemethod = (S32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s32vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s32vector-ref", 2, obj1);
            }
            return Integer.valueOf(s32vectorRef(modulemethod, i));

        case 47: // '/'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u32vector", 1, obj);
            }
            try
            {
                l = ((Number)obj1).longValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u32vector", 2, obj1);
            }
            return makeU32vector(i, l);

        case 51: // '3'
            try
            {
                modulemethod = (U32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u32vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u32vector-ref", 2, obj1);
            }
            return Long.valueOf(u32vectorRef(modulemethod, i));

        case 56: // '8'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s64vector", 1, obj);
            }
            try
            {
                l = ((Number)obj1).longValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-s64vector", 2, obj1);
            }
            return makeS64vector(i, l);

        case 60: // '<'
            try
            {
                modulemethod = (S64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s64vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s64vector-ref", 2, obj1);
            }
            return Long.valueOf(s64vectorRef(modulemethod, i));

        case 65: // 'A'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u64vector", 1, obj);
            }
            try
            {
                modulemethod = LangObjType.coerceIntNum(obj1);
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-u64vector", 2, obj1);
            }
            return makeU64vector(i, modulemethod);

        case 69: // 'E'
            try
            {
                modulemethod = (U64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u64vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u64vector-ref", 2, obj1);
            }
            return u64vectorRef(modulemethod, i);

        case 74: // 'J'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-f32vector", 1, obj);
            }
            try
            {
                f = ((Number)obj1).floatValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-f32vector", 2, obj1);
            }
            return makeF32vector(i, f);

        case 78: // 'N'
            try
            {
                modulemethod = (F32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "f32vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "f32vector-ref", 2, obj1);
            }
            return Float.valueOf(f32vectorRef(modulemethod, i));

        case 83: // 'S'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-f64vector", 1, obj);
            }
            try
            {
                d = ((Number)obj1).doubleValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-f64vector", 2, obj1);
            }
            return makeF64vector(i, d);

        case 87: // 'W'
            break;
        }
        try
        {
            modulemethod = (F64Vector)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "f64vector-ref", 1, obj);
        }
        try
        {
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "f64vector-ref", 2, obj1);
        }
        return Double.valueOf(f64vectorRef(modulemethod, i));
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 7: // '\007'
            double d;
            float f;
            int i;
            int j;
            long l;
            try
            {
                modulemethod = (S8Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s8vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s8vector-set!", 2, obj1);
            }
            try
            {
                j = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s8vector-set!", 3, obj2);
            }
            s8vectorSet$Ex(modulemethod, i, j);
            return Values.empty;

        case 16: // '\020'
            try
            {
                modulemethod = (U8Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u8vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u8vector-set!", 2, obj1);
            }
            try
            {
                j = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u8vector-set!", 3, obj2);
            }
            u8vectorSet$Ex(modulemethod, i, j);
            return Values.empty;

        case 25: // '\031'
            try
            {
                modulemethod = (S16Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s16vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s16vector-set!", 2, obj1);
            }
            try
            {
                j = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s16vector-set!", 3, obj2);
            }
            s16vectorSet$Ex(modulemethod, i, j);
            return Values.empty;

        case 34: // '"'
            try
            {
                modulemethod = (U16Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u16vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u16vector-set!", 2, obj1);
            }
            try
            {
                j = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u16vector-set!", 3, obj2);
            }
            u16vectorSet$Ex(modulemethod, i, j);
            return Values.empty;

        case 43: // '+'
            try
            {
                modulemethod = (S32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s32vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s32vector-set!", 2, obj1);
            }
            try
            {
                j = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s32vector-set!", 3, obj2);
            }
            s32vectorSet$Ex(modulemethod, i, j);
            return Values.empty;

        case 52: // '4'
            try
            {
                modulemethod = (U32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u32vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u32vector-set!", 2, obj1);
            }
            try
            {
                l = ((Number)obj2).longValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u32vector-set!", 3, obj2);
            }
            u32vectorSet$Ex(modulemethod, i, l);
            return Values.empty;

        case 61: // '='
            try
            {
                modulemethod = (S64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s64vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s64vector-set!", 2, obj1);
            }
            try
            {
                l = ((Number)obj2).longValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "s64vector-set!", 3, obj2);
            }
            s64vectorSet$Ex(modulemethod, i, l);
            return Values.empty;

        case 70: // 'F'
            try
            {
                modulemethod = (U64Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u64vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u64vector-set!", 2, obj1);
            }
            try
            {
                obj = LangObjType.coerceIntNum(obj2);
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "u64vector-set!", 3, obj2);
            }
            u64vectorSet$Ex(modulemethod, i, ((IntNum) (obj)));
            return Values.empty;

        case 79: // 'O'
            try
            {
                modulemethod = (F32Vector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "f32vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "f32vector-set!", 2, obj1);
            }
            try
            {
                f = ((Number)obj2).floatValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "f32vector-set!", 3, obj2);
            }
            f32vectorSet$Ex(modulemethod, i, f);
            return Values.empty;

        case 88: // 'X'
            break;
        }
        try
        {
            modulemethod = (F64Vector)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "f64vector-set!", 1, obj);
        }
        try
        {
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "f64vector-set!", 2, obj1);
        }
        try
        {
            d = ((Number)obj2).doubleValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "f64vector-set!", 3, obj2);
        }
        f64vectorSet$Ex(modulemethod, i, d);
        return Values.empty;
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        switch (modulemethod.selector)
        {
        default:
            return super.applyN(modulemethod, aobj);

        case 4: // '\004'
            return s8vector$V(aobj);

        case 13: // '\r'
            return u8vector$V(aobj);

        case 22: // '\026'
            return s16vector$V(aobj);

        case 31: // '\037'
            return u16vector$V(aobj);

        case 40: // '('
            return s32vector$V(aobj);

        case 49: // '1'
            return u32vector$V(aobj);

        case 58: // ':'
            return s64vector$V(aobj);

        case 67: // 'C'
            return u64vector$V(aobj);

        case 76: // 'L'
            return f32vector$V(aobj);

        case 85: // 'U'
            return f64vector$V(aobj);
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
        case 12: // '\f'
        case 13: // '\r'
        case 15: // '\017'
        case 16: // '\020'
        case 21: // '\025'
        case 22: // '\026'
        case 24: // '\030'
        case 25: // '\031'
        case 30: // '\036'
        case 31: // '\037'
        case 33: // '!'
        case 34: // '"'
        case 39: // '\''
        case 40: // '('
        case 42: // '*'
        case 43: // '+'
        case 48: // '0'
        case 49: // '1'
        case 51: // '3'
        case 52: // '4'
        case 57: // '9'
        case 58: // ':'
        case 60: // '<'
        case 61: // '='
        case 66: // 'B'
        case 67: // 'C'
        case 69: // 'E'
        case 70: // 'F'
        case 75: // 'K'
        case 76: // 'L'
        case 78: // 'N'
        case 79: // 'O'
        case 84: // 'T'
        case 85: // 'U'
        case 87: // 'W'
        case 88: // 'X'
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 90: // 'Z'
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

        case 89: // 'Y'
            if (!(obj instanceof F64Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 86: // 'V'
            if (!(obj instanceof F64Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 83: // 'S'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 82: // 'R'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 81: // 'Q'
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

        case 80: // 'P'
            if (!(obj instanceof F32Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 77: // 'M'
            if (!(obj instanceof F32Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 74: // 'J'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 73: // 'I'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 72: // 'H'
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

        case 71: // 'G'
            if (!(obj instanceof U64Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 68: // 'D'
            if (!(obj instanceof U64Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 65: // 'A'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 64: // '@'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 63: // '?'
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

        case 62: // '>'
            if (!(obj instanceof S64Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 59: // ';'
            if (!(obj instanceof S64Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 56: // '8'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 55: // '7'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 54: // '6'
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

        case 53: // '5'
            if (!(obj instanceof U32Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 50: // '2'
            if (!(obj instanceof U32Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 47: // '/'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 46: // '.'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 45: // '-'
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

        case 44: // ','
            if (!(obj instanceof S32Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 41: // ')'
            if (!(obj instanceof S32Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 38: // '&'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 37: // '%'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 36: // '$'
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

        case 35: // '#'
            if (!(obj instanceof U16Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 32: // ' '
            if (!(obj instanceof U16Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 29: // '\035'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 28: // '\034'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 27: // '\033'
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

        case 26: // '\032'
            if (!(obj instanceof S16Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 23: // '\027'
            if (!(obj instanceof S16Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 20: // '\024'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 19: // '\023'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 18: // '\022'
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

        case 17: // '\021'
            if (!(obj instanceof U8Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 14: // '\016'
            if (!(obj instanceof U8Vector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 11: // '\013'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 10: // '\n'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 9: // '\t'
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

        case 8: // '\b'
            if (!(obj instanceof S8Vector))
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
            if (!(obj instanceof S8Vector))
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
        JVM INSTR lookupswitch 20: default 180
    //                   2: 769
    //                   6: 736
    //                   11: 710
    //                   15: 677
    //                   20: 651
    //                   24: 618
    //                   29: 592
    //                   33: 559
    //                   38: 533
    //                   42: 500
    //                   47: 474
    //                   51: 441
    //                   56: 415
    //                   60: 382
    //                   65: 345
    //                   69: 312
    //                   74: 286
    //                   78: 253
    //                   83: 227
    //                   87: 194;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21
_L1:
        i = super.match2(modulemethod, obj, obj1, callcontext);
_L23:
        return i;
_L21:
        if (!(obj instanceof F64Vector)) goto _L23; else goto _L22
_L22:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L20:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L19:
        if (!(obj instanceof F32Vector)) goto _L23; else goto _L24
_L24:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L18:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L17:
        if (!(obj instanceof U64Vector)) goto _L23; else goto _L25
_L25:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L16:
        callcontext.value1 = obj;
        if (IntNum.asIntNumOrNull(obj1) != null)
        {
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return 0xfff40002;
        }
_L15:
        if (!(obj instanceof S64Vector)) goto _L23; else goto _L26
_L26:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L14:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L13:
        if (!(obj instanceof U32Vector)) goto _L23; else goto _L27
_L27:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L12:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L11:
        if (!(obj instanceof S32Vector)) goto _L23; else goto _L28
_L28:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L10:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L9:
        if (!(obj instanceof U16Vector)) goto _L23; else goto _L29
_L29:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L8:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L7:
        if (!(obj instanceof S16Vector)) goto _L23; else goto _L30
_L30:
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
        if (!(obj instanceof U8Vector)) goto _L23; else goto _L31
_L31:
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
        if (!(obj instanceof S8Vector)) goto _L23; else goto _L32
_L32:
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
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR lookupswitch 10: default 100
    //                   7: 488
    //                   16: 448
    //                   25: 408
    //                   34: 368
    //                   43: 328
    //                   52: 288
    //                   61: 248
    //                   70: 196
    //                   79: 156
    //                   88: 116;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        i = super.match3(modulemethod, obj, obj1, obj2, callcontext);
_L13:
        return i;
_L11:
        if (obj instanceof F64Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (obj instanceof F32Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (obj instanceof U64Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            if (IntNum.asIntNumOrNull(obj2) != null)
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
        continue; /* Loop/switch isn't completed */
_L8:
        if (obj instanceof S64Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (obj instanceof U32Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (obj instanceof S32Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (obj instanceof U16Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (obj instanceof S16Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (obj instanceof U8Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (obj instanceof S8Vector)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        if (true) goto _L13; else goto _L12
_L12:
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 85: // 'U'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 76: // 'L'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 67: // 'C'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 58: // ':'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 49: // '1'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 40: // '('
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 31: // '\037'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 22: // '\026'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 13: // '\r'
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
        Lit80 = (SimpleSymbol)(new SimpleSymbol("list->f64vector")).readResolve();
        Lit79 = (SimpleSymbol)(new SimpleSymbol("f64vector->list")).readResolve();
        Lit78 = (SimpleSymbol)(new SimpleSymbol("f64vector-set!")).readResolve();
        Lit77 = (SimpleSymbol)(new SimpleSymbol("f64vector-ref")).readResolve();
        Lit76 = (SimpleSymbol)(new SimpleSymbol("f64vector-length")).readResolve();
        Lit75 = (SimpleSymbol)(new SimpleSymbol("f64vector")).readResolve();
        Lit74 = (SimpleSymbol)(new SimpleSymbol("make-f64vector")).readResolve();
        Lit73 = (SimpleSymbol)(new SimpleSymbol("f64vector?")).readResolve();
        Lit72 = (SimpleSymbol)(new SimpleSymbol("list->f32vector")).readResolve();
        Lit71 = (SimpleSymbol)(new SimpleSymbol("f32vector->list")).readResolve();
        Lit70 = (SimpleSymbol)(new SimpleSymbol("f32vector-set!")).readResolve();
        Lit69 = (SimpleSymbol)(new SimpleSymbol("f32vector-ref")).readResolve();
        Lit68 = (SimpleSymbol)(new SimpleSymbol("f32vector-length")).readResolve();
        Lit67 = (SimpleSymbol)(new SimpleSymbol("f32vector")).readResolve();
        Lit66 = (SimpleSymbol)(new SimpleSymbol("make-f32vector")).readResolve();
        Lit65 = (SimpleSymbol)(new SimpleSymbol("f32vector?")).readResolve();
        Lit64 = (SimpleSymbol)(new SimpleSymbol("list->u64vector")).readResolve();
        Lit63 = (SimpleSymbol)(new SimpleSymbol("u64vector->list")).readResolve();
        Lit62 = (SimpleSymbol)(new SimpleSymbol("u64vector-set!")).readResolve();
        Lit61 = (SimpleSymbol)(new SimpleSymbol("u64vector-ref")).readResolve();
        Lit60 = (SimpleSymbol)(new SimpleSymbol("u64vector-length")).readResolve();
        Lit59 = (SimpleSymbol)(new SimpleSymbol("u64vector")).readResolve();
        Lit58 = (SimpleSymbol)(new SimpleSymbol("make-u64vector")).readResolve();
        Lit57 = (SimpleSymbol)(new SimpleSymbol("u64vector?")).readResolve();
        Lit56 = (SimpleSymbol)(new SimpleSymbol("list->s64vector")).readResolve();
        Lit55 = (SimpleSymbol)(new SimpleSymbol("s64vector->list")).readResolve();
        Lit54 = (SimpleSymbol)(new SimpleSymbol("s64vector-set!")).readResolve();
        Lit53 = (SimpleSymbol)(new SimpleSymbol("s64vector-ref")).readResolve();
        Lit52 = (SimpleSymbol)(new SimpleSymbol("s64vector-length")).readResolve();
        Lit51 = (SimpleSymbol)(new SimpleSymbol("s64vector")).readResolve();
        Lit50 = (SimpleSymbol)(new SimpleSymbol("make-s64vector")).readResolve();
        Lit49 = (SimpleSymbol)(new SimpleSymbol("s64vector?")).readResolve();
        Lit48 = (SimpleSymbol)(new SimpleSymbol("list->u32vector")).readResolve();
        Lit47 = (SimpleSymbol)(new SimpleSymbol("u32vector->list")).readResolve();
        Lit46 = (SimpleSymbol)(new SimpleSymbol("u32vector-set!")).readResolve();
        Lit45 = (SimpleSymbol)(new SimpleSymbol("u32vector-ref")).readResolve();
        Lit44 = (SimpleSymbol)(new SimpleSymbol("u32vector-length")).readResolve();
        Lit43 = (SimpleSymbol)(new SimpleSymbol("u32vector")).readResolve();
        Lit42 = (SimpleSymbol)(new SimpleSymbol("make-u32vector")).readResolve();
        Lit41 = (SimpleSymbol)(new SimpleSymbol("u32vector?")).readResolve();
        Lit40 = (SimpleSymbol)(new SimpleSymbol("list->s32vector")).readResolve();
        Lit39 = (SimpleSymbol)(new SimpleSymbol("s32vector->list")).readResolve();
        Lit38 = (SimpleSymbol)(new SimpleSymbol("s32vector-set!")).readResolve();
        Lit37 = (SimpleSymbol)(new SimpleSymbol("s32vector-ref")).readResolve();
        Lit36 = (SimpleSymbol)(new SimpleSymbol("s32vector-length")).readResolve();
        Lit35 = (SimpleSymbol)(new SimpleSymbol("s32vector")).readResolve();
        Lit34 = (SimpleSymbol)(new SimpleSymbol("make-s32vector")).readResolve();
        Lit33 = (SimpleSymbol)(new SimpleSymbol("s32vector?")).readResolve();
        Lit32 = (SimpleSymbol)(new SimpleSymbol("list->u16vector")).readResolve();
        Lit31 = (SimpleSymbol)(new SimpleSymbol("u16vector->list")).readResolve();
        Lit30 = (SimpleSymbol)(new SimpleSymbol("u16vector-set!")).readResolve();
        Lit29 = (SimpleSymbol)(new SimpleSymbol("u16vector-ref")).readResolve();
        Lit28 = (SimpleSymbol)(new SimpleSymbol("u16vector-length")).readResolve();
        Lit27 = (SimpleSymbol)(new SimpleSymbol("u16vector")).readResolve();
        Lit26 = (SimpleSymbol)(new SimpleSymbol("make-u16vector")).readResolve();
        Lit25 = (SimpleSymbol)(new SimpleSymbol("u16vector?")).readResolve();
        Lit24 = (SimpleSymbol)(new SimpleSymbol("list->s16vector")).readResolve();
        Lit23 = (SimpleSymbol)(new SimpleSymbol("s16vector->list")).readResolve();
        Lit22 = (SimpleSymbol)(new SimpleSymbol("s16vector-set!")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("s16vector-ref")).readResolve();
        Lit20 = (SimpleSymbol)(new SimpleSymbol("s16vector-length")).readResolve();
        Lit19 = (SimpleSymbol)(new SimpleSymbol("s16vector")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("make-s16vector")).readResolve();
        Lit17 = (SimpleSymbol)(new SimpleSymbol("s16vector?")).readResolve();
        Lit16 = (SimpleSymbol)(new SimpleSymbol("list->u8vector")).readResolve();
        Lit15 = (SimpleSymbol)(new SimpleSymbol("u8vector->list")).readResolve();
        Lit14 = (SimpleSymbol)(new SimpleSymbol("u8vector-set!")).readResolve();
        Lit13 = (SimpleSymbol)(new SimpleSymbol("u8vector-ref")).readResolve();
        Lit12 = (SimpleSymbol)(new SimpleSymbol("u8vector-length")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("u8vector")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("make-u8vector")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("u8vector?")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("list->s8vector")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("s8vector->list")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("s8vector-set!")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("s8vector-ref")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("s8vector-length")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("s8vector")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("make-s8vector")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("s8vector?")).readResolve();
        $instance = new uniform();
        uniform uniform1 = $instance;
        s8vector$Qu = new ModuleMethod(uniform1, 1, Lit1, 4097);
        make$Mns8vector = new ModuleMethod(uniform1, 2, Lit2, 8193);
        s8vector = new ModuleMethod(uniform1, 4, Lit3, -4096);
        s8vector$Mnlength = new ModuleMethod(uniform1, 5, Lit4, 4097);
        s8vector$Mnref = new ModuleMethod(uniform1, 6, Lit5, 8194);
        s8vector$Mnset$Ex = new ModuleMethod(uniform1, 7, Lit6, 12291);
        s8vector$Mn$Grlist = new ModuleMethod(uniform1, 8, Lit7, 4097);
        list$Mn$Grs8vector = new ModuleMethod(uniform1, 9, Lit8, 4097);
        u8vector$Qu = new ModuleMethod(uniform1, 10, Lit9, 4097);
        make$Mnu8vector = new ModuleMethod(uniform1, 11, Lit10, 8193);
        u8vector = new ModuleMethod(uniform1, 13, Lit11, -4096);
        u8vector$Mnlength = new ModuleMethod(uniform1, 14, Lit12, 4097);
        u8vector$Mnref = new ModuleMethod(uniform1, 15, Lit13, 8194);
        u8vector$Mnset$Ex = new ModuleMethod(uniform1, 16, Lit14, 12291);
        u8vector$Mn$Grlist = new ModuleMethod(uniform1, 17, Lit15, 4097);
        list$Mn$Gru8vector = new ModuleMethod(uniform1, 18, Lit16, 4097);
        s16vector$Qu = new ModuleMethod(uniform1, 19, Lit17, 4097);
        make$Mns16vector = new ModuleMethod(uniform1, 20, Lit18, 8193);
        s16vector = new ModuleMethod(uniform1, 22, Lit19, -4096);
        s16vector$Mnlength = new ModuleMethod(uniform1, 23, Lit20, 4097);
        s16vector$Mnref = new ModuleMethod(uniform1, 24, Lit21, 8194);
        s16vector$Mnset$Ex = new ModuleMethod(uniform1, 25, Lit22, 12291);
        s16vector$Mn$Grlist = new ModuleMethod(uniform1, 26, Lit23, 4097);
        list$Mn$Grs16vector = new ModuleMethod(uniform1, 27, Lit24, 4097);
        u16vector$Qu = new ModuleMethod(uniform1, 28, Lit25, 4097);
        make$Mnu16vector = new ModuleMethod(uniform1, 29, Lit26, 8193);
        u16vector = new ModuleMethod(uniform1, 31, Lit27, -4096);
        u16vector$Mnlength = new ModuleMethod(uniform1, 32, Lit28, 4097);
        u16vector$Mnref = new ModuleMethod(uniform1, 33, Lit29, 8194);
        u16vector$Mnset$Ex = new ModuleMethod(uniform1, 34, Lit30, 12291);
        u16vector$Mn$Grlist = new ModuleMethod(uniform1, 35, Lit31, 4097);
        list$Mn$Gru16vector = new ModuleMethod(uniform1, 36, Lit32, 4097);
        s32vector$Qu = new ModuleMethod(uniform1, 37, Lit33, 4097);
        make$Mns32vector = new ModuleMethod(uniform1, 38, Lit34, 8193);
        s32vector = new ModuleMethod(uniform1, 40, Lit35, -4096);
        s32vector$Mnlength = new ModuleMethod(uniform1, 41, Lit36, 4097);
        s32vector$Mnref = new ModuleMethod(uniform1, 42, Lit37, 8194);
        s32vector$Mnset$Ex = new ModuleMethod(uniform1, 43, Lit38, 12291);
        s32vector$Mn$Grlist = new ModuleMethod(uniform1, 44, Lit39, 4097);
        list$Mn$Grs32vector = new ModuleMethod(uniform1, 45, Lit40, 4097);
        u32vector$Qu = new ModuleMethod(uniform1, 46, Lit41, 4097);
        make$Mnu32vector = new ModuleMethod(uniform1, 47, Lit42, 8193);
        u32vector = new ModuleMethod(uniform1, 49, Lit43, -4096);
        u32vector$Mnlength = new ModuleMethod(uniform1, 50, Lit44, 4097);
        u32vector$Mnref = new ModuleMethod(uniform1, 51, Lit45, 8194);
        u32vector$Mnset$Ex = new ModuleMethod(uniform1, 52, Lit46, 12291);
        u32vector$Mn$Grlist = new ModuleMethod(uniform1, 53, Lit47, 4097);
        list$Mn$Gru32vector = new ModuleMethod(uniform1, 54, Lit48, 4097);
        s64vector$Qu = new ModuleMethod(uniform1, 55, Lit49, 4097);
        make$Mns64vector = new ModuleMethod(uniform1, 56, Lit50, 8193);
        s64vector = new ModuleMethod(uniform1, 58, Lit51, -4096);
        s64vector$Mnlength = new ModuleMethod(uniform1, 59, Lit52, 4097);
        s64vector$Mnref = new ModuleMethod(uniform1, 60, Lit53, 8194);
        s64vector$Mnset$Ex = new ModuleMethod(uniform1, 61, Lit54, 12291);
        s64vector$Mn$Grlist = new ModuleMethod(uniform1, 62, Lit55, 4097);
        list$Mn$Grs64vector = new ModuleMethod(uniform1, 63, Lit56, 4097);
        u64vector$Qu = new ModuleMethod(uniform1, 64, Lit57, 4097);
        make$Mnu64vector = new ModuleMethod(uniform1, 65, Lit58, 8193);
        u64vector = new ModuleMethod(uniform1, 67, Lit59, -4096);
        u64vector$Mnlength = new ModuleMethod(uniform1, 68, Lit60, 4097);
        u64vector$Mnref = new ModuleMethod(uniform1, 69, Lit61, 8194);
        u64vector$Mnset$Ex = new ModuleMethod(uniform1, 70, Lit62, 12291);
        u64vector$Mn$Grlist = new ModuleMethod(uniform1, 71, Lit63, 4097);
        list$Mn$Gru64vector = new ModuleMethod(uniform1, 72, Lit64, 4097);
        f32vector$Qu = new ModuleMethod(uniform1, 73, Lit65, 4097);
        make$Mnf32vector = new ModuleMethod(uniform1, 74, Lit66, 8193);
        f32vector = new ModuleMethod(uniform1, 76, Lit67, -4096);
        f32vector$Mnlength = new ModuleMethod(uniform1, 77, Lit68, 4097);
        f32vector$Mnref = new ModuleMethod(uniform1, 78, Lit69, 8194);
        f32vector$Mnset$Ex = new ModuleMethod(uniform1, 79, Lit70, 12291);
        f32vector$Mn$Grlist = new ModuleMethod(uniform1, 80, Lit71, 4097);
        list$Mn$Grf32vector = new ModuleMethod(uniform1, 81, Lit72, 4097);
        f64vector$Qu = new ModuleMethod(uniform1, 82, Lit73, 4097);
        make$Mnf64vector = new ModuleMethod(uniform1, 83, Lit74, 8193);
        f64vector = new ModuleMethod(uniform1, 85, Lit75, -4096);
        f64vector$Mnlength = new ModuleMethod(uniform1, 86, Lit76, 4097);
        f64vector$Mnref = new ModuleMethod(uniform1, 87, Lit77, 8194);
        f64vector$Mnset$Ex = new ModuleMethod(uniform1, 88, Lit78, 12291);
        f64vector$Mn$Grlist = new ModuleMethod(uniform1, 89, Lit79, 4097);
        list$Mn$Grf64vector = new ModuleMethod(uniform1, 90, Lit80, 4097);
        $instance.run();
    }
}
