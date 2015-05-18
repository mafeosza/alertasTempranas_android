// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.reflect.InstanceOf;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.text.Char;

// Referenced classes of package gnu.kawa.lispexpr:
//            LangObjType

public class LangPrimType extends PrimType
    implements TypeValue
{

    public static final PrimType byteType;
    public static final LangPrimType charType;
    public static final PrimType doubleType;
    public static final PrimType floatType;
    public static final PrimType intType;
    public static final PrimType longType;
    public static final PrimType shortType;
    public static final LangPrimType voidType;
    PrimType implementationType;
    Language language;

    public LangPrimType(PrimType primtype)
    {
        super(primtype);
        implementationType = primtype;
    }

    public LangPrimType(PrimType primtype, Language language1)
    {
        super(primtype);
        language = language1;
        implementationType = primtype;
    }

    public LangPrimType(String s, String s1, int i, Class class1)
    {
        super(s, s1, i, class1);
    }

    public LangPrimType(String s, String s1, int i, Class class1, Language language1)
    {
        this(s, s1, i, class1);
        implementationType = Type.signatureToPrimitive(s1.charAt(0));
        language = language1;
    }

    public char charValue(Object obj)
    {
        if (obj instanceof Character)
        {
            return ((Character)obj).charValue();
        } else
        {
            return ((Char)obj).charValue();
        }
    }

    public Object coerceFromObject(Object obj)
    {
        if (obj.getClass() == reflectClass)
        {
            return obj;
        }
        switch (getSignature().charAt(0))
        {
        default:
            return super.coerceFromObject(obj);

        case 90: // 'Z'
            if (language.isTrue(obj))
            {
                obj = Boolean.TRUE;
            } else
            {
                obj = Boolean.FALSE;
            }
            return obj;

        case 67: // 'C'
            return new Character(((Char)obj).charValue());

        case 86: // 'V'
            return Values.empty;
        }
    }

    public Object coerceToObject(Object obj)
    {
        getSignature().charAt(0);
        JVM INSTR lookupswitch 3: default 44
    //                   67: 67
    //                   86: 87
    //                   90: 52;
           goto _L1 _L2 _L3 _L4
_L1:
        Object obj1 = super.coerceToObject(obj);
_L6:
        return obj1;
_L4:
        return language.booleanObject(((Boolean)obj).booleanValue());
_L2:
        obj1 = obj;
        if (obj instanceof Char) goto _L6; else goto _L5
_L5:
        return Char.make(((Character)obj).charValue());
_L3:
        return Values.empty;
    }

    public int compare(Type type)
    {
        char c = getSignature().charAt(0);
        if (type instanceof PrimType)
        {
            char c1 = type.getSignature().charAt(0);
            if (c == c1)
            {
                return 0;
            }
            if (c == 'V')
            {
                return 1;
            }
            if (c1 == 'V' || c1 == 'Z')
            {
                return -1;
            }
        }
        if (c == 'V' || c == 'Z')
        {
            return 1;
        }
        if (c == 'C' && type.getName().equals("gnu.text.Char"))
        {
            return -1;
        }
        if (type instanceof LangObjType)
        {
            return swappedCompareResult(type.compare(this));
        } else
        {
            return super.compare(type);
        }
    }

    public Expression convertValue(Expression expression)
    {
        return null;
    }

    public void emitCoerceFromObject(CodeAttr codeattr)
    {
        switch (getSignature().charAt(0))
        {
        default:
            super.emitCoerceFromObject(codeattr);
            return;

        case 90: // 'Z'
            language.emitCoerceToBoolean(codeattr);
            return;

        case 67: // 'C'
            ClassType classtype = ClassType.make("gnu.text.Char");
            gnu.bytecode.Method method = classtype.getDeclaredMethod("charValue", 0);
            codeattr.emitCheckcast(classtype);
            codeattr.emitInvokeVirtual(method);
            return;
        }
    }

    public void emitCoerceToObject(CodeAttr codeattr)
    {
        getSignature().charAt(0);
        JVM INSTR lookupswitch 2: default 36
    //                   67: 100
    //                   90: 67;
           goto _L1 _L2 _L3
_L1:
        super.emitCoerceToObject(codeattr);
_L5:
        if (false)
        {
            codeattr.emitInvokeStatic(ClassType.make(null).getDeclaredMethod("make", new Type[] {
                null
            }));
        }
        return;
_L3:
        codeattr.emitIfIntNotZero();
        language.emitPushBoolean(true, codeattr);
        codeattr.emitElse();
        language.emitPushBoolean(false, codeattr);
        codeattr.emitFi();
        continue; /* Loop/switch isn't completed */
_L2:
        codeattr.emitInvokeStatic(ClassType.make("gnu.text.Char").getDeclaredMethod("make", 1));
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void emitIsInstance(CodeAttr codeattr)
    {
        switch (getSignature().charAt(0))
        {
        default:
            super.emitIsInstance(codeattr);
            return;

        case 90: // 'Z'
            codeattr.emitPop(1);
            codeattr.emitPushInt(1);
            return;

        case 67: // 'C'
            codeattr.emitInstanceof(ClassType.make("gnu.text.Char"));
            return;
        }
    }

    public void emitIsInstance(Variable variable, Compilation compilation, Target target)
    {
        InstanceOf.emitIsInstance(this, variable, compilation, target);
    }

    public void emitTestIf(Variable variable, Declaration declaration, Compilation compilation)
    {
        getSignature().charAt(0);
        CodeAttr codeattr = compilation.getCode();
        if (variable != null)
        {
            codeattr.emitLoad(variable);
        }
        if (declaration != null)
        {
            codeattr.emitDup();
            declaration.compileStore(compilation);
        }
        emitIsInstance(codeattr);
        codeattr.emitIfIntNotZero();
    }

    public Procedure getConstructor()
    {
        return null;
    }

    public Type getImplementationType()
    {
        return implementationType;
    }

    static 
    {
        byteType = Type.byteType;
        shortType = Type.shortType;
        intType = Type.intType;
        longType = Type.longType;
        floatType = Type.floatType;
        doubleType = Type.doubleType;
        charType = new LangPrimType(Type.charType);
        voidType = new LangPrimType(Type.voidType);
    }
}
