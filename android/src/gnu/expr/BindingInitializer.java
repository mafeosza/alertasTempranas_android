// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.text.SourceMessages;

// Referenced classes of package gnu.expr:
//            Initializer, Declaration, Compilation, ModuleExp, 
//            Target, Expression, QuoteExp, LitTable, 
//            Literal, Language, StackTarget

public class BindingInitializer extends Initializer
{

    static final ClassType typeThreadLocation = ClassType.make("gnu.mapping.ThreadLocation");
    Declaration decl;
    Expression value;

    public BindingInitializer(Declaration declaration, Expression expression)
    {
        decl = declaration;
        value = expression;
        field = declaration.field;
    }

    public static void create(Declaration declaration, Expression expression, Compilation compilation)
    {
        expression = new BindingInitializer(declaration, expression);
        if (declaration.field == null ? declaration.isStatic() : declaration.field.getStaticFlag())
        {
            expression.next = compilation.clinitChain;
            compilation.clinitChain = expression;
            return;
        } else
        {
            expression.next = compilation.mainLambda.initChain;
            compilation.mainLambda.initChain = expression;
            return;
        }
    }

    public static Method makeLocationMethod(Object obj)
    {
        Type atype[] = new Type[1];
        if (obj instanceof Symbol)
        {
            atype[0] = Compilation.typeSymbol;
        } else
        {
            atype[0] = Type.javalangStringType;
        }
        return Compilation.typeLocation.getDeclaredMethod("make", atype);
    }

    public void emit(Compilation compilation)
    {
        if (!decl.ignorable()) goto _L2; else goto _L1
_L1:
        if (value != null)
        {
            value.compile(compilation, Target.Ignore);
        }
_L4:
        return;
_L2:
        Object obj;
        CodeAttr codeattr;
        codeattr = compilation.getCode();
        if (!(value instanceof QuoteExp))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ((QuoteExp)value).getValue();
        if (obj != null && !(obj instanceof String) && compilation.litTable.findLiteral(obj).field == field) goto _L4; else goto _L3
_L3:
        int i = decl.getLineNumber();
        SourceMessages sourcemessages = compilation.getMessages();
        gnu.text.SourceLocator sourcelocator = sourcemessages.swapSourceLocator(decl);
        if (i > 0)
        {
            codeattr.putLineNumber(decl.getFileName(), i);
        }
        if (field != null && !field.getStaticFlag())
        {
            codeattr.emitPushThis();
        }
        if (value == null)
        {
            Object obj1;
            Object obj3;
            if (compilation.getLanguage().hasSeparateFunctionNamespace() && decl.isProcedureDecl())
            {
                obj1 = EnvironmentKey.FUNCTION;
            } else
            {
                obj1 = null;
            }
            obj3 = decl.getSymbol();
            if (decl.getFlag(0x10010000L))
            {
                Object obj2 = obj3;
                if (obj3 instanceof String)
                {
                    obj2 = Namespace.EmptyNamespace.getSymbol((String)obj3);
                }
                compilation.compileConstant(obj2, Target.pushObject);
                if (obj1 == null)
                {
                    codeattr.emitPushNull();
                } else
                {
                    compilation.compileConstant(obj1, Target.pushObject);
                }
                codeattr.emitInvokeStatic(typeThreadLocation.getDeclaredMethod("getInstance", 2));
            } else
            if (decl.isFluid())
            {
                ClassType classtype;
                if (obj3 instanceof Symbol)
                {
                    classtype = Compilation.typeSymbol;
                } else
                {
                    classtype = Type.toStringType;
                }
                compilation.compileConstant(obj3, Target.pushObject);
                codeattr.emitInvokeStatic(typeThreadLocation.getDeclaredMethod("makeAnonymous", new Type[] {
                    classtype
                }));
            } else
            {
                compilation.compileConstant(obj3, Target.pushObject);
                codeattr.emitInvokeStatic(makeLocationMethod(obj3));
            }
        } else
        {
            Type type;
            if (field == null)
            {
                type = decl.getType();
            } else
            {
                type = field.getType();
            }
            value.compileWithPosition(compilation, StackTarget.getInstance(type));
        }
        if (field == null)
        {
            obj1 = decl.getVariable();
            compilation = ((Compilation) (obj1));
            if (obj1 == null)
            {
                compilation = decl.allocateVariable(codeattr);
            }
            codeattr.emitStore(compilation);
        } else
        if (field.getStaticFlag())
        {
            codeattr.emitPutStatic(field);
        } else
        {
            codeattr.emitPutField(field);
        }
        sourcemessages.swapSourceLocator(sourcelocator);
        return;
    }

}
