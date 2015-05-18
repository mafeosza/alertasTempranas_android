// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.mapping.WrongArguments;
import gnu.text.SourceLocator;

// Referenced classes of package gnu.expr:
//            Expression, Special, IgnoreTarget, Compilation, 
//            StackTarget, Target, Language, InlineCalls, 
//            Declaration, ApplyExp, PrimProcedure, ReferenceExp, 
//            ExpVisitor

public class QuoteExp extends Expression
{

    public static final int EXPLICITLY_TYPED = 2;
    public static final int SHARED_CONSTANT = 4;
    public static QuoteExp abstractExp;
    public static final QuoteExp classObjectExp;
    public static QuoteExp falseExp;
    public static QuoteExp nullExp;
    public static QuoteExp trueExp;
    public static QuoteExp undefined_exp;
    public static QuoteExp voidExp;
    protected Type type;
    Object value;

    public QuoteExp(Object obj)
    {
        value = obj;
    }

    public QuoteExp(Object obj, Type type1)
    {
        value = obj;
        setType(type1);
    }

    public static QuoteExp getInstance(Object obj)
    {
        return getInstance(obj, null);
    }

    public static QuoteExp getInstance(Object obj, SourceLocator sourcelocator)
    {
        if (obj == null)
        {
            return nullExp;
        }
        if (obj == Type.pointer_type)
        {
            return classObjectExp;
        }
        if (obj == Special.undefined)
        {
            return undefined_exp;
        }
        if (obj == Values.empty)
        {
            return voidExp;
        }
        if (obj instanceof Boolean)
        {
            if (((Boolean)obj).booleanValue())
            {
                return trueExp;
            } else
            {
                return falseExp;
            }
        }
        obj = new QuoteExp(obj);
        if (sourcelocator != null)
        {
            ((QuoteExp) (obj)).setLocation(sourcelocator);
        }
        return ((QuoteExp) (obj));
    }

    static QuoteExp makeShared(Object obj)
    {
        obj = new QuoteExp(obj);
        ((QuoteExp) (obj)).setFlag(4);
        return ((QuoteExp) (obj));
    }

    static QuoteExp makeShared(Object obj, Type type1)
    {
        obj = new QuoteExp(obj, type1);
        ((QuoteExp) (obj)).setFlag(4);
        return ((QuoteExp) (obj));
    }

    public void apply(CallContext callcontext)
    {
        callcontext.writeValue(value);
    }

    public void compile(Compilation compilation, Target target)
    {
        if (type == null || type == Type.pointer_type || (target instanceof IgnoreTarget) || (type instanceof ObjectType) && type.isInstance(value))
        {
            compilation.compileConstant(value, target);
            return;
        } else
        {
            compilation.compileConstant(value, StackTarget.getInstance(type));
            target.compileFromStack(compilation, type);
            return;
        }
    }

    public Expression deepCopy(IdentityHashTable identityhashtable)
    {
        return this;
    }

    public final Type getRawType()
    {
        return type;
    }

    public final Type getType()
    {
        if (type != null)
        {
            return type;
        }
        if (value == Values.empty)
        {
            return Type.voidType;
        }
        if (value == null)
        {
            return Type.nullType;
        }
        if (this == undefined_exp)
        {
            return Type.pointer_type;
        } else
        {
            return Type.make(value.getClass());
        }
    }

    public final Object getValue()
    {
        return value;
    }

    public boolean isExplicitlyTyped()
    {
        return getFlag(2);
    }

    public boolean isSharedConstant()
    {
        return getFlag(4);
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        Object obj;
        Object obj1;
        outport.startLogicalBlock("(Quote", ")", 2);
        outport.writeSpaceLinear();
        obj1 = value;
        obj = obj1;
        if (obj1 instanceof Expression)
        {
            obj = obj1.toString();
        }
        obj1 = outport.objectFormat;
        outport.objectFormat = Language.getDefaultLanguage().getFormat(true);
        outport.print(obj);
        if (type != null)
        {
            outport.print(" ::");
            outport.print(type.getName());
        }
        outport.objectFormat = ((gnu.lists.AbstractFormat) (obj1));
        outport.endLogicalBlock(")");
        return;
        Exception exception;
        exception;
        outport.objectFormat = ((gnu.lists.AbstractFormat) (obj1));
        throw exception;
    }

    public void setType(Type type1)
    {
        type = type1;
        setFlag(2);
    }

    public boolean side_effects()
    {
        return false;
    }

    public String toString()
    {
        return (new StringBuilder()).append("QuoteExp[").append(value).append("]").toString();
    }

    public Expression validateApply(ApplyExp applyexp, InlineCalls inlinecalls, Type type1, Declaration declaration)
    {
        if (this != undefined_exp) goto _L2; else goto _L1
_L1:
        return applyexp;
_L2:
        Procedure procedure;
        int j;
        Object obj = getValue();
        if (!(obj instanceof Procedure))
        {
            if (declaration == null || obj == null)
            {
                applyexp = "called value is not a procedure";
            } else
            {
                applyexp = (new StringBuilder()).append("calling ").append(declaration.getName()).append(" which is a ").append(obj.getClass().getName()).toString();
            }
            return inlinecalls.noteError(applyexp);
        }
        procedure = (Procedure)obj;
        j = applyexp.getArgCount();
        obj = WrongArguments.checkArgCount(procedure, j);
        if (obj != null)
        {
            return inlinecalls.noteError(((String) (obj)));
        }
        obj = inlinecalls.maybeInline(applyexp, type1, procedure);
        if (obj != null)
        {
            return ((Expression) (obj));
        }
        Expression aexpression[] = applyexp.args;
        MethodProc methodproc;
        int i;
        if (procedure instanceof MethodProc)
        {
            methodproc = (MethodProc)procedure;
        } else
        {
            methodproc = null;
        }
        i = 0;
        while (i < j) 
        {
            Type type2;
            Type type3;
            if (methodproc != null)
            {
                type2 = methodproc.getParameterType(i);
            } else
            {
                type2 = null;
            }
            type3 = type2;
            if (i == j - 1)
            {
                type3 = type2;
                if (type2 != null)
                {
                    type3 = type2;
                    if (methodproc.maxArgs() < 0)
                    {
                        type3 = type2;
                        if (i == methodproc.minArgs())
                        {
                            type3 = null;
                        }
                    }
                }
            }
            aexpression[i] = inlinecalls.visit(aexpression[i], type3);
            i++;
        }
        if (applyexp.getFlag(4))
        {
            Expression expression = applyexp.inlineIfConstant(procedure, inlinecalls);
            if (expression != applyexp)
            {
                return inlinecalls.visit(expression, type1);
            }
        }
        inlinecalls = inlinecalls.getCompilation();
        if (!inlinecalls.inlineOk(procedure))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (ApplyExp.asInlineable(procedure) == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (applyexp.getFunction() != this)
        {
            return (new ApplyExp(this, applyexp.getArgs())).setLine(applyexp);
        }
        if (true) goto _L1; else goto _L3
_L3:
        inlinecalls = PrimProcedure.getMethodFor(procedure, declaration, applyexp.args, inlinecalls.getLanguage());
        if (inlinecalls == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!inlinecalls.getStaticFlag() && declaration != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        inlinecalls = new ApplyExp(inlinecalls, applyexp.args);
_L5:
        return inlinecalls.setLine(applyexp);
        if (declaration.base == null) goto _L1; else goto _L4
_L4:
        type1 = new Expression[j + 1];
        System.arraycopy(applyexp.getArgs(), 0, type1, 1, j);
        type1[0] = new ReferenceExp(declaration.base);
        inlinecalls = new ApplyExp(inlinecalls, type1);
          goto _L5
        if (true) goto _L1; else goto _L6
_L6:
    }

    public final Object valueIfConstant()
    {
        return value;
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitQuoteExp(this, obj);
    }

    static 
    {
        undefined_exp = makeShared(Special.undefined);
        abstractExp = makeShared(Special.abstractSpecial);
        voidExp = makeShared(Values.empty, Type.voidType);
        trueExp = makeShared(Boolean.TRUE);
        falseExp = makeShared(Boolean.FALSE);
        nullExp = makeShared(null, Type.nullType);
        classObjectExp = makeShared(Type.objectType);
    }
}
