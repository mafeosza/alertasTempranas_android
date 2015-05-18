// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;

// Referenced classes of package gnu.expr:
//            AccessExp, Declaration, QuoteExp, LambdaExp, 
//            Expression, ModuleExp, ScopeExp, ConsumerTarget, 
//            Compilation, ApplyExp, ExpVisitor, Target, 
//            InlineCalls

public class ReferenceExp extends AccessExp
{

    public static final int DONT_DEREFERENCE = 2;
    public static final int PREFER_BINDING2 = 8;
    public static final int PROCEDURE_NAME = 4;
    public static final int TYPE_NAME = 16;
    static int counter;
    int id;

    public ReferenceExp(Declaration declaration)
    {
        this(declaration.getSymbol(), declaration);
    }

    public ReferenceExp(Object obj)
    {
        int i = counter + 1;
        counter = i;
        id = i;
        symbol = obj;
    }

    public ReferenceExp(Object obj, Declaration declaration)
    {
        int i = counter + 1;
        counter = i;
        id = i;
        symbol = obj;
        binding = declaration;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object obj3 = null;
        if (binding == null || !binding.isAlias() || getDontDereference() || !(binding.value instanceof ReferenceExp)) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = (ReferenceExp)binding.value;
        if (((ReferenceExp) (obj)).getDontDereference() && ((ReferenceExp) (obj)).binding != null)
        {
            obj = ((ReferenceExp) (obj)).binding.getValue();
            if ((obj instanceof QuoteExp) || (obj instanceof ReferenceExp) || (obj instanceof LambdaExp))
            {
                ((Expression) (obj)).apply(callcontext);
                return;
            }
        }
        obj = binding.value.eval(callcontext);
_L9:
        Object obj1 = obj;
        if (!getDontDereference())
        {
            obj1 = obj;
            if (binding.isIndirectBinding())
            {
                obj1 = ((Location)obj).get();
            }
        }
        callcontext.writeValue(obj1);
        return;
_L2:
        if (binding == null || binding.field == null || !binding.field.getDeclaringClass().isExisting() || getDontDereference() && !binding.isIndirectBinding())
        {
            break MISSING_BLOCK_LABEL_301;
        }
        if (!binding.field.getStaticFlag())
        {
            break MISSING_BLOCK_LABEL_230;
        }
        obj = null;
_L3:
        try
        {
            obj = binding.field.getReflectField().get(obj);
        }
        // Misplaced declaration of an exception variable
        catch (CallContext callcontext)
        {
            throw new UnboundLocationException((new StringBuilder()).append("exception evaluating ").append(symbol).append(" from ").append(binding.field).append(" - ").append(callcontext).toString(), this);
        }
        continue; /* Loop/switch isn't completed */
        obj = contextDecl().getValue().eval(callcontext);
          goto _L3
        Object obj2;
        Environment environment;
        if (binding != null && ((binding.value instanceof QuoteExp) || (binding.value instanceof LambdaExp)) && binding.value != QuoteExp.undefined_exp && (!getDontDereference() || binding.isIndirectBinding()))
        {
            obj = binding.value.eval(callcontext);
            continue; /* Loop/switch isn't completed */
        }
        if (binding != null && (!(binding.context instanceof ModuleExp) || binding.isPrivate()))
        {
            break MISSING_BLOCK_LABEL_531;
        }
        environment = Environment.getCurrent();
        if (symbol instanceof Symbol)
        {
            obj = (Symbol)symbol;
        } else
        {
            obj = environment.getSymbol(symbol.toString());
        }
        obj2 = obj3;
        if (getFlag(8))
        {
            obj2 = obj3;
            if (isProcedureName())
            {
                obj2 = EnvironmentKey.FUNCTION;
            }
        }
        if (!getDontDereference()) goto _L5; else goto _L4
_L4:
        obj2 = environment.getLocation(((Symbol) (obj)), obj2);
_L7:
        callcontext.writeValue(obj2);
        return;
_L5:
        String s;
        s = Location.UNBOUND;
        obj3 = environment.get(((Symbol) (obj)), obj2, s);
        obj2 = obj3;
        if (obj3 != s) goto _L7; else goto _L6
_L6:
        throw new UnboundLocationException(obj, this);
        obj = callcontext.evalFrames[ScopeExp.nesting(binding.context)][binding.evalIndex];
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void compile(Compilation compilation, Target target)
    {
        if (!(target instanceof ConsumerTarget) || !((ConsumerTarget)target).compileWrite(this, compilation))
        {
            binding.load(this, flags, compilation, target);
        }
    }

    protected Expression deepCopy(IdentityHashTable identityhashtable)
    {
        Declaration declaration = (Declaration)identityhashtable.get(binding, binding);
        identityhashtable = new ReferenceExp(identityhashtable.get(symbol, symbol), declaration);
        identityhashtable.flags = getFlags();
        return identityhashtable;
    }

    public final boolean getDontDereference()
    {
        return (flags & 2) != 0;
    }

    public Type getType()
    {
        Object obj = binding;
        if (obj != null && !((Declaration) (obj)).isFluid()) goto _L2; else goto _L1
_L1:
        Object obj1 = Type.pointer_type;
_L4:
        return ((Type) (obj1));
_L2:
label0:
        {
            if (getDontDereference())
            {
                return Compilation.typeLocation;
            }
            Declaration declaration = Declaration.followAliases(((Declaration) (obj)));
            obj1 = declaration.getType();
            if (obj1 != null)
            {
                obj = obj1;
                if (obj1 != Type.pointer_type)
                {
                    break label0;
                }
            }
            Expression expression = declaration.getValue();
            obj = obj1;
            if (expression != null)
            {
                obj = obj1;
                if (expression != QuoteExp.undefined_exp)
                {
                    obj1 = declaration.value;
                    declaration.value = null;
                    obj = expression.getType();
                    declaration.value = ((Expression) (obj1));
                }
            }
        }
        obj1 = obj;
        if (obj == Type.toStringType)
        {
            return Type.javalangStringType;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final boolean isProcedureName()
    {
        return (flags & 4) != 0;
    }

    public boolean isSingleValue()
    {
        if (binding != null && binding.getFlag(0x40000L))
        {
            return true;
        } else
        {
            return super.isSingleValue();
        }
    }

    public final boolean isUnknown()
    {
        return Declaration.isUnknown(binding);
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        outport.print("(Ref/");
        outport.print(id);
        if (symbol != null && (binding == null || symbol.toString() != binding.getName()))
        {
            outport.print('/');
            outport.print(symbol);
        }
        if (binding != null)
        {
            outport.print('/');
            outport.print(binding);
        }
        outport.print(")");
    }

    public final void setDontDereference(boolean flag)
    {
        setFlag(flag, 2);
    }

    public final void setProcedureName(boolean flag)
    {
        setFlag(flag, 4);
    }

    public boolean side_effects()
    {
        return binding == null || !binding.isLexical();
    }

    public String toString()
    {
        return (new StringBuilder()).append("RefExp/").append(symbol).append('/').append(id).append('/').toString();
    }

    public Expression validateApply(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Declaration declaration)
    {
        declaration = binding;
        if (declaration != null && !declaration.getFlag(0x10000L))
        {
            declaration = Declaration.followAliases(declaration);
            if (!declaration.isIndirectBinding())
            {
                Expression expression = declaration.getValue();
                if (expression != null)
                {
                    return expression.validateApply(applyexp, inlinecalls, type, declaration);
                }
            }
        } else
        if (getSymbol() instanceof Symbol)
        {
            declaration = (Symbol)getSymbol();
            declaration = ((Declaration) (Environment.getCurrent().getFunction(declaration, null)));
            if (declaration instanceof Procedure)
            {
                return (new QuoteExp(declaration)).validateApply(applyexp, inlinecalls, type, null);
            }
        }
        applyexp.visitArgs(inlinecalls);
        return applyexp;
    }

    public final Object valueIfConstant()
    {
        if (binding != null)
        {
            Expression expression = binding.getValue();
            if (expression != null)
            {
                return expression.valueIfConstant();
            }
        }
        return null;
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitReferenceExp(this, obj);
    }
}
