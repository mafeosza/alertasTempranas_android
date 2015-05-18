// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Filter;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.PairClassType;
import gnu.expr.PrimProcedure;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.functions.MakeList;
import gnu.kawa.reflect.InstanceOf;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import gnu.math.RealNum;
import gnu.text.FilePath;
import gnu.text.Path;
import gnu.text.URIPath;
import java.util.List;

public class LangObjType extends ObjectType
    implements TypeValue
{

    private static final int CLASSTYPE_TYPE_CODE = 6;
    private static final int CLASS_TYPE_CODE = 4;
    private static final int DFLONUM_TYPE_CODE = 15;
    private static final int FILEPATH_TYPE_CODE = 2;
    private static final int INTEGER_TYPE_CODE = 7;
    private static final int LIST_TYPE_CODE = 11;
    private static final int NUMERIC_TYPE_CODE = 10;
    private static final int PATH_TYPE_CODE = 1;
    private static final int RATIONAL_TYPE_CODE = 8;
    private static final int REAL_TYPE_CODE = 9;
    private static final int REGEX_TYPE_CODE = 14;
    private static final int STRING_TYPE_CODE = 13;
    private static final int TYPE_TYPE_CODE = 5;
    public static final LangObjType URIType = new LangObjType("URI", "gnu.text.URIPath", 3);
    private static final int URI_TYPE_CODE = 3;
    static final String VARARGS_SUFFIX = "";
    private static final int VECTOR_TYPE_CODE = 12;
    public static final LangObjType dflonumType = new LangObjType("DFloNum", "gnu.math.DFloNum", 15);
    public static final LangObjType filepathType = new LangObjType("filepath", "gnu.text.FilePath", 2);
    public static final LangObjType integerType = new LangObjType("integer", "gnu.math.IntNum", 7);
    public static final LangObjType listType = new LangObjType("list", "gnu.lists.LList", 11);
    static PrimProcedure makeFilepathProc = new PrimProcedure("gnu.text.FilePath", "makeFilePath", 1);
    static PrimProcedure makePathProc = new PrimProcedure("gnu.text.Path", "valueOf", 1);
    static PrimProcedure makeURIProc = new PrimProcedure("gnu.text.URIPath", "makeURI", 1);
    public static final LangObjType numericType = new LangObjType("number", "gnu.math.Numeric", 10);
    public static final LangObjType pathType = new LangObjType("path", "gnu.text.Path", 1);
    public static final LangObjType rationalType = new LangObjType("rational", "gnu.math.RatNum", 8);
    public static final LangObjType realType = new LangObjType("real", "gnu.math.RealNum", 9);
    public static final LangObjType regexType = new LangObjType("regex", "java.util.regex.Pattern", 14);
    public static final LangObjType stringType = new LangObjType("string", "java.lang.CharSequence", 13);
    static final ClassType typeArithmetic = ClassType.make("gnu.kawa.functions.Arithmetic");
    public static final LangObjType typeClass = new LangObjType("class", "java.lang.Class", 4);
    public static final LangObjType typeClassType = new LangObjType("class-type", "gnu.bytecode.ClassType", 6);
    public static final ClassType typeLangObjType = ClassType.make("gnu.kawa.lispexpr.LangObjType");
    public static final LangObjType typeType = new LangObjType("type", "gnu.bytecode.Type", 5);
    public static final LangObjType vectorType = new LangObjType("vector", "gnu.lists.FVector", 12);
    ClassType implementationType;
    final int typeCode;

    LangObjType(String s, String s1, int i)
    {
        super(s);
        implementationType = ClassType.make(s1);
        typeCode = i;
        setSignature(implementationType.getSignature());
    }

    public static DFloNum coerceDFloNum(Object obj)
    {
        DFloNum dflonum = DFloNum.asDFloNumOrNull(obj);
        if (dflonum == null && obj != null)
        {
            throw new WrongType(-4, obj, dflonumType);
        } else
        {
            return dflonum;
        }
    }

    public static IntNum coerceIntNum(Object obj)
    {
        IntNum intnum = IntNum.asIntNumOrNull(obj);
        if (intnum == null && obj != null)
        {
            throw new WrongType(-4, obj, integerType);
        } else
        {
            return intnum;
        }
    }

    public static Numeric coerceNumeric(Object obj)
    {
        Numeric numeric = Numeric.asNumericOrNull(obj);
        if (numeric == null && obj != null)
        {
            throw new WrongType(-4, obj, numericType);
        } else
        {
            return numeric;
        }
    }

    public static RatNum coerceRatNum(Object obj)
    {
        RatNum ratnum = RatNum.asRatNumOrNull(obj);
        if (ratnum == null && obj != null)
        {
            throw new WrongType(-4, obj, rationalType);
        } else
        {
            return ratnum;
        }
    }

    public static RealNum coerceRealNum(Object obj)
    {
        RealNum realnum = RealNum.asRealNumOrNull(obj);
        if (realnum == null && obj != null)
        {
            throw new WrongType(-4, obj, realType);
        } else
        {
            return realnum;
        }
    }

    public static Class coerceToClass(Object obj)
    {
        Class class1 = coerceToClassOrNull(obj);
        if (class1 == null && obj != null)
        {
            throw new ClassCastException((new StringBuilder()).append("cannot cast ").append(obj).append(" to type").toString());
        } else
        {
            return class1;
        }
    }

    public static Class coerceToClassOrNull(Object obj)
    {
        if (obj instanceof Class)
        {
            return (Class)obj;
        }
        if ((obj instanceof Type) && (obj instanceof ClassType) && !(obj instanceof PairClassType))
        {
            return ((ClassType)obj).getReflectClass();
        } else
        {
            return null;
        }
    }

    public static ClassType coerceToClassType(Object obj)
    {
        ClassType classtype = coerceToClassTypeOrNull(obj);
        if (classtype == null && obj != null)
        {
            throw new ClassCastException((new StringBuilder()).append("cannot cast ").append(obj).append(" to class-type").toString());
        } else
        {
            return classtype;
        }
    }

    public static ClassType coerceToClassTypeOrNull(Object obj)
    {
        if (obj instanceof ClassType)
        {
            return (ClassType)obj;
        }
        if (obj instanceof Class)
        {
            obj = Language.getDefaultLanguage().getTypeFor((Class)obj);
            if (obj instanceof ClassType)
            {
                return (ClassType)obj;
            }
        }
        return null;
    }

    public static Type coerceToType(Object obj)
    {
        Type type = coerceToTypeOrNull(obj);
        if (type == null && obj != null)
        {
            throw new ClassCastException((new StringBuilder()).append("cannot cast ").append(obj).append(" to type").toString());
        } else
        {
            return type;
        }
    }

    public static Type coerceToTypeOrNull(Object obj)
    {
        if (obj instanceof Type)
        {
            return (Type)obj;
        }
        if (obj instanceof Class)
        {
            return Language.getDefaultLanguage().getTypeFor((Class)obj);
        } else
        {
            return null;
        }
    }

    public Object coerceFromObject(Object obj)
    {
        switch (typeCode)
        {
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        default:
            return super.coerceFromObject(obj);

        case 1: // '\001'
            return Path.valueOf(obj);

        case 2: // '\002'
            return FilePath.makeFilePath(obj);

        case 3: // '\003'
            return URIPath.makeURI(obj);

        case 4: // '\004'
            return coerceToClass(obj);

        case 6: // '\006'
            return coerceToClassType(obj);

        case 5: // '\005'
            return coerceToType(obj);

        case 10: // '\n'
            return coerceNumeric(obj);

        case 9: // '\t'
            return coerceRealNum(obj);

        case 8: // '\b'
            return coerceRatNum(obj);

        case 7: // '\007'
            return coerceIntNum(obj);

        case 15: // '\017'
            return coerceDFloNum(obj);
        }
    }

    Method coercionMethod()
    {
        switch (typeCode)
        {
        default:
            return ((PrimProcedure)getConstructor()).getMethod();

        case 4: // '\004'
            return typeLangObjType.getDeclaredMethod("coerceToClass", 1);

        case 6: // '\006'
            return typeLangObjType.getDeclaredMethod("coerceToClassType", 1);

        case 5: // '\005'
            return typeLangObjType.getDeclaredMethod("coerceToType", 1);

        case 10: // '\n'
            return typeLangObjType.getDeclaredMethod("coerceNumeric", 1);

        case 9: // '\t'
            return typeLangObjType.getDeclaredMethod("coerceRealNum", 1);

        case 8: // '\b'
            return typeLangObjType.getDeclaredMethod("coerceRatNum", 1);

        case 7: // '\007'
            return typeLangObjType.getDeclaredMethod("coerceIntNum", 1);

        case 15: // '\017'
            return typeLangObjType.getDeclaredMethod("coerceDFloNum", 1);

        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            return null;
        }
    }

    Method coercionOrNullMethod()
    {
        ClassType classtype = implementationType;
        typeCode;
        JVM INSTR tableswitch 1 15: default 84
    //                   1 86
    //                   2 97
    //                   3 104
    //                   4 111
    //                   5 133
    //                   6 122
    //                   7 192
    //                   8 180
    //                   9 168
    //                   10 144
    //                   11 84
    //                   12 84
    //                   13 84
    //                   14 84
    //                   15 156;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L1 _L1 _L1 _L1 _L12
_L1:
        return null;
_L2:
        String s = "coerceToPathOrNull";
_L14:
        return classtype.getDeclaredMethod(s, 1);
_L3:
        s = "coerceToFilePathOrNull";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "coerceToURIPathOrNull";
        continue; /* Loop/switch isn't completed */
_L5:
        classtype = typeLangObjType;
        s = "coerceToClassOrNull";
        continue; /* Loop/switch isn't completed */
_L7:
        classtype = typeLangObjType;
        s = "coerceToClassTypeOrNull";
        continue; /* Loop/switch isn't completed */
_L6:
        classtype = typeLangObjType;
        s = "coerceToTypeOrNull";
        continue; /* Loop/switch isn't completed */
_L11:
        classtype = implementationType;
        s = "asNumericOrNull";
        continue; /* Loop/switch isn't completed */
_L12:
        classtype = implementationType;
        s = "asDFloNumOrNull";
        continue; /* Loop/switch isn't completed */
_L10:
        classtype = implementationType;
        s = "asRealNumOrNull";
        continue; /* Loop/switch isn't completed */
_L9:
        classtype = implementationType;
        s = "asRatNumOrNull";
        continue; /* Loop/switch isn't completed */
_L8:
        classtype = implementationType;
        s = "asIntNumOrNull";
        if (true) goto _L14; else goto _L13
_L13:
    }

    public int compare(Type type)
    {
        byte byte0 = -1;
        typeCode;
        JVM INSTR tableswitch 4 15: default 68
    //                   4 82
    //                   5 124
    //                   6 160
    //                   7 200
    //                   8 68
    //                   9 256
    //                   10 68
    //                   11 68
    //                   12 68
    //                   13 68
    //                   14 68
    //                   15 256;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L1 _L1 _L1 _L1 _L1 _L6
_L15:
        int i = getImplementationType().compare(type.getImplementationType());
_L8:
        return i;
_L2:
        i = byte0;
        if (type == typeType) goto _L8; else goto _L7
_L7:
        i = byte0;
        if (type == typeClassType) goto _L8; else goto _L9
_L9:
        i = byte0;
        if (type == typeType.implementationType) goto _L8; else goto _L10
_L10:
        if (type == typeClassType.implementationType)
        {
            return -1;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (type == typeClass || type == typeClassType || type == typeClass.implementationType || type == typeClassType.implementationType)
        {
            return 1;
        }
_L4:
        if (type == typeClass || type == typeClass.implementationType)
        {
            return 1;
        }
        i = byte0;
        if (type == typeType) goto _L8; else goto _L11
_L11:
        if (type == typeClass.implementationType)
        {
            return -1;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (!(type instanceof PrimType)) goto _L6; else goto _L12
_L12:
        type.getSignature().charAt(0);
        JVM INSTR lookupswitch 4: default 256
    //                   66: 301
    //                   73: 301
    //                   74: 301
    //                   83: 301;
           goto _L6 _L13 _L13 _L13 _L13
_L13:
        break; /* Loop/switch isn't completed */
_L6:
        if (!(type instanceof PrimType))
        {
            continue; /* Loop/switch isn't completed */
        }
        switch (type.getSignature().charAt(0))
        {
        case 68: // 'D'
        case 70: // 'F'
            return 1;
        }
_L1:
        if (true) goto _L15; else goto _L14
_L14:
        return 1;
    }

    public Expression convertValue(Expression expression)
    {
        Method method;
        if (typeCode != 7 && typeCode != 10 && typeCode != 9 && typeCode != 8 && typeCode != 15)
        {
            if ((method = coercionMethod()) != null)
            {
                expression = new ApplyExp(method, new Expression[] {
                    expression
                });
                expression.setType(this);
                return expression;
            }
        }
        return null;
    }

    public void emitCoerceFromObject(CodeAttr codeattr)
    {
        switch (typeCode)
        {
        default:
            codeattr.emitInvoke(coercionMethod());
            return;

        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            codeattr.emitCheckcast(implementationType);
            break;
        }
    }

    public void emitConvertFromPrimitive(Type type, CodeAttr codeattr)
    {
        Object obj;
        String s;
        Object obj3;
        Object obj4;
        Object obj5;
        obj4 = null;
        obj5 = null;
        obj = obj4;
        s = obj5;
        obj3 = type;
        typeCode;
        JVM INSTR tableswitch 7 15: default 72
    //                   7 212
    //                   8 212
    //                   9 212
    //                   10 212
    //                   11 82
    //                   12 82
    //                   13 82
    //                   14 82
    //                   15 111;
           goto _L1 _L2 _L2 _L2 _L2 _L3 _L3 _L3 _L3 _L4
_L1:
        obj3 = type;
        s = obj5;
        obj = obj4;
_L3:
        Object obj1;
        if (s != null)
        {
            codeattr.emitInvokeStatic(ClassType.make(s).getDeclaredMethod("make", new Type[] {
                obj
            }));
            return;
        } else
        {
            super.emitConvertFromPrimitive(((Type) (obj3)), codeattr);
            return;
        }
_L4:
        obj = obj4;
        s = obj5;
        obj3 = type;
        if (!(type instanceof PrimType)) goto _L3; else goto _L5
_L5:
        if (type == Type.intType || type == Type.byteType || type == Type.shortType || type == Type.longType) goto _L7; else goto _L6
_L6:
        obj1 = type;
        if (type != Type.floatType) goto _L8; else goto _L7
_L7:
        codeattr.emitConvert(type, Type.doubleType);
        obj1 = Type.doubleType;
_L8:
        obj = obj4;
        s = obj5;
        obj3 = obj1;
        if (obj1 == Type.doubleType)
        {
            s = "gnu.math.DFloNum";
            obj = obj1;
            obj3 = obj1;
        }
          goto _L3
_L2:
        obj = obj4;
        s = obj5;
        obj3 = type;
        if (!(type instanceof PrimType)) goto _L3; else goto _L9
_L9:
        if (type != Type.intType && type != Type.byteType && type != Type.shortType) goto _L11; else goto _L10
_L10:
        s = "gnu.math.IntNum";
        obj = Type.int_type;
        obj3 = type;
          goto _L3
_L11:
        if (type != Type.longType) goto _L13; else goto _L12
_L12:
        s = "gnu.math.IntNum";
        obj = Type.long_type;
        obj3 = type;
          goto _L3
_L13:
        if (typeCode == 9) goto _L15; else goto _L14
_L14:
        obj = obj4;
        s = obj5;
        obj3 = type;
        if (typeCode != 10) goto _L3; else goto _L15
_L15:
        Object obj2 = type;
        if (type == Type.floatType)
        {
            codeattr.emitConvert(Type.float_type, Type.double_type);
            obj2 = Type.doubleType;
        }
        obj = obj4;
        s = obj5;
        obj3 = obj2;
        if (obj2 == Type.doubleType)
        {
            s = "gnu.math.DFloNum";
            obj = Type.doubleType;
            obj3 = obj2;
        }
          goto _L3
    }

    public void emitIsInstance(Variable variable, Compilation compilation, Target target)
    {
        switch (typeCode)
        {
        default:
            InstanceOf.emitIsInstance(this, variable, compilation, target);
            return;

        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
            implementationType.emitIsInstance(compilation.getCode());
            break;
        }
        target.compileFromStack(compilation, compilation.getLanguage().getTypeFor(Boolean.TYPE));
    }

    public void emitTestIf(Variable variable, Declaration declaration, Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        if (variable != null)
        {
            codeattr.emitLoad(variable);
        }
        variable = coercionOrNullMethod();
        if (variable != null)
        {
            codeattr.emitInvokeStatic(variable);
        }
        if (declaration != null)
        {
            codeattr.emitDup();
            declaration.compileStore(compilation);
        }
        if (variable != null)
        {
            codeattr.emitIfNotNull();
            return;
        } else
        {
            implementationType.emitIsInstance(codeattr);
            codeattr.emitIfIntNotZero();
            return;
        }
    }

    public Procedure getConstructor()
    {
        switch (typeCode)
        {
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        default:
            return null;

        case 1: // '\001'
            return makePathProc;

        case 2: // '\002'
            return makeFilepathProc;

        case 3: // '\003'
            return makeURIProc;

        case 12: // '\f'
            return new PrimProcedure("gnu.lists.FVector", "make", 1);

        case 11: // '\013'
            return MakeList.list;

        case 13: // '\r'
            return new PrimProcedure("kawa.lib.strings", "$make$string$", 1);

        case 14: // '\016'
            return new PrimProcedure("java.util.regex.Pattern", "compile", 1);
        }
    }

    public Method getDeclaredMethod(String s, int i)
    {
        return implementationType.getDeclaredMethod(s, i);
    }

    public Field getField(String s, int i)
    {
        return implementationType.getField(s, i);
    }

    public Type getImplementationType()
    {
        return implementationType;
    }

    public Method getMethod(String s, Type atype[])
    {
        return implementationType.getMethod(s, atype);
    }

    public int getMethods(Filter filter, int i, List list)
    {
        return implementationType.getMethods(filter, i, list);
    }

    public Type getRealType()
    {
        return implementationType;
    }

    public Class getReflectClass()
    {
        return implementationType.getReflectClass();
    }

}
