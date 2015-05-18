// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;

public class InstanceOf extends Procedure2
    implements Inlineable
{

    static Method instanceMethod;
    static ClassType typeType;
    protected Language language;

    public InstanceOf(Language language1)
    {
        language = language1;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplyInstanceOf");
    }

    public InstanceOf(Language language1, String s)
    {
        this(language1);
        setName(s);
    }

    public static void emitIsInstance(TypeValue typevalue, Variable variable, Compilation compilation, Target target)
    {
        variable = compilation.getCode();
        typevalue.emitTestIf(null, null, compilation);
        typevalue = null;
        if (target instanceof ConditionalTarget)
        {
            typevalue = (ConditionalTarget)target;
            variable.emitGoto(((ConditionalTarget) (typevalue)).ifTrue);
        } else
        {
            variable.emitPushInt(1);
        }
        variable.emitElse();
        if (typevalue != null)
        {
            variable.emitGoto(((ConditionalTarget) (typevalue)).ifFalse);
        } else
        {
            variable.emitPushInt(0);
        }
        variable.emitFi();
        if (typevalue == null)
        {
            target.compileFromStack(compilation, compilation.getLanguage().getTypeFor(Boolean.TYPE));
        }
    }

    public Object apply2(Object obj, Object obj1)
    {
        Type type = language.asType(obj1);
        obj1 = type;
        if (type instanceof PrimType)
        {
            obj1 = ((PrimType)type).boxedType();
        }
        return language.booleanObject(((Type) (obj1)).isInstance(obj));
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Object obj;
        Expression aexpression[];
        CodeAttr codeattr;
        aexpression = applyexp.getArgs();
        codeattr = compilation.getCode();
        applyexp = null;
        obj = aexpression[1];
        if (obj instanceof QuoteExp)
        {
label0:
            {
                try
                {
                    obj = language.asType(((QuoteExp)obj).getValue());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    compilation.error('w', (new StringBuilder()).append("unknown type spec: ").append(null).toString());
                    continue; /* Loop/switch isn't completed */
                }
                applyexp = ((ApplyExp) (obj));
                break label0;
            }
        }
        applyexp = language.getTypeFor(((Expression) (obj)));
        if (true) goto _L2; else goto _L1
_L2:
        if (applyexp == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = applyexp;
        if (applyexp instanceof PrimType)
        {
            obj = ((PrimType)applyexp).boxedType();
        }
        aexpression[0].compile(compilation, Target.pushObject);
        if (obj instanceof TypeValue)
        {
            ((TypeValue)obj).emitIsInstance(null, compilation, target);
            return;
        }
        ((Type) (obj)).emitIsInstance(codeattr);
        compilation.usedClass(((Type) (obj)));
_L4:
        target.compileFromStack(compilation, language.getTypeFor(Boolean.TYPE));
        return;
_L1:
        if (typeType == null)
        {
            typeType = ClassType.make("gnu.bytecode.Type");
            instanceMethod = typeType.addMethod("isInstance", Compilation.apply1args, Type.boolean_type, 1);
        }
        aexpression[1].compile(compilation, typeType);
        aexpression[0].compile(compilation, Target.pushObject);
        codeattr.emitInvokeVirtual(instanceMethod);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Type getReturnType(Expression aexpression[])
    {
        return language.getTypeFor(Boolean.TYPE);
    }
}
