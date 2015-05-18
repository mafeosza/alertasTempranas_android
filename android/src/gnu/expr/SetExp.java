// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.functions.AddOp;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.math.IntNum;

// Referenced classes of package gnu.expr:
//            AccessExp, Declaration, ApplyExp, Expression, 
//            QuoteExp, ReferenceExp, Language, ModuleExp, 
//            ScopeExp, LambdaExp, IgnoreTarget, Compilation, 
//            BindingInitializer, Target, ClassExp, ExpVisitor

public class SetExp extends AccessExp
{

    public static final int BAD_SHORT = 0x10000;
    public static final int DEFINING_FLAG = 2;
    public static final int GLOBAL_FLAG = 4;
    public static final int HAS_VALUE = 64;
    public static final int PREFER_BINDING2 = 8;
    public static final int PROCEDURE = 16;
    public static final int SET_IF_UNBOUND = 32;
    Expression new_value;

    public SetExp(Declaration declaration, Expression expression)
    {
        binding = declaration;
        symbol = declaration.getSymbol();
        new_value = expression;
    }

    public SetExp(Object obj, Expression expression)
    {
        symbol = obj;
        new_value = expression;
    }

    public static int canUseInc(Expression expression, Declaration declaration)
    {
        Object obj = declaration.getVariable();
        if (!declaration.isSimple() || ((Variable) (obj)).getType().getImplementationType().promote() != Type.intType || !(expression instanceof ApplyExp)) goto _L2; else goto _L1
_L1:
        expression = (ApplyExp)expression;
        if (expression.getArgCount() != 2) goto _L2; else goto _L3
_L3:
        obj = expression.getFunction().valueIfConstant();
        if (obj != AddOp.$Pl) goto _L5; else goto _L4
_L4:
        int i = 1;
_L12:
        Object obj1;
        obj = expression.getArg(0);
        Expression expression1 = expression.getArg(1);
        obj1 = obj;
        expression = expression1;
        if (obj instanceof QuoteExp)
        {
            obj1 = obj;
            expression = expression1;
            if (i > 0)
            {
                expression = ((Expression) (obj));
                obj1 = expression1;
            }
        }
        if (!(obj1 instanceof ReferenceExp)) goto _L2; else goto _L6
_L6:
        obj = (ReferenceExp)obj1;
        if (((ReferenceExp) (obj)).getBinding() == declaration && !((ReferenceExp) (obj)).getDontDereference()) goto _L7; else goto _L2
_L2:
        return 0x10000;
_L5:
        if (obj == AddOp.$Mn)
        {
            i = -1;
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L2; else goto _L7
_L7:
        int j;
        expression = ((Expression) (expression.valueIfConstant()));
        if (!(expression instanceof Integer))
        {
            continue; /* Loop/switch isn't completed */
        }
        int l = ((Integer)expression).intValue();
        j = l;
        if (i < 0)
        {
            j = -l;
        }
        if ((short)j != j) goto _L2; else goto _L8
_L8:
        return j;
        if (!(expression instanceof IntNum)) goto _L2; else goto _L9
_L9:
        expression = (IntNum)expression;
        int k = 32767;
        int i1 = -32767;
        if (i > 0)
        {
            i1--;
        } else
        {
            k = 32767 + 1;
        }
        if (IntNum.compare(expression, i1) < 0 || IntNum.compare(expression, k) > 0) goto _L2; else goto _L10
_L10:
        return i * expression.intValue();
        if (true) goto _L12; else goto _L11
_L11:
    }

    public static SetExp makeDefinition(Declaration declaration, Expression expression)
    {
        declaration = new SetExp(declaration, expression);
        declaration.setDefining(true);
        return declaration;
    }

    public static SetExp makeDefinition(Object obj, Expression expression)
    {
        obj = new SetExp(obj, expression);
        ((SetExp) (obj)).setDefining(true);
        return ((SetExp) (obj));
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Environment environment = Environment.getCurrent();
        Object obj;
        Object obj1;
        Object obj2;
        Language language;
        if (symbol instanceof Symbol)
        {
            obj = (Symbol)symbol;
        } else
        {
            obj = environment.getSymbol(symbol.toString());
        }
        obj2 = null;
        language = Language.getDefaultLanguage();
        obj1 = obj2;
        if (isFuncDef())
        {
            obj1 = obj2;
            if (language.hasSeparateFunctionNamespace())
            {
                obj1 = EnvironmentKey.FUNCTION;
            }
        }
        if (isSetIfUnbound())
        {
            obj = environment.getLocation(((Symbol) (obj)), obj1);
            if (!((Location) (obj)).isBound())
            {
                ((Location) (obj)).set(new_value.eval(environment));
            }
            if (getHasValue())
            {
                callcontext.writeValue(obj);
            }
        } else
        {
            Object obj3 = new_value.eval(environment);
            if (binding != null && !(binding.context instanceof ModuleExp))
            {
                obj1 = ((Object) (callcontext.evalFrames[ScopeExp.nesting(binding.context)]));
                if (binding.isIndirectBinding())
                {
                    if (isDefining())
                    {
                        obj1[binding.evalIndex] = Location.make(((Symbol) (obj)));
                    }
                    ((Location)obj1[binding.evalIndex]).set(new_value);
                } else
                {
                    obj1[binding.evalIndex] = obj3;
                }
            } else
            if (isDefining())
            {
                environment.define(((Symbol) (obj)), obj1, obj3);
            } else
            {
                environment.put(((Symbol) (obj)), obj1, obj3);
            }
            if (getHasValue())
            {
                callcontext.writeValue(obj3);
                return;
            }
        }
    }

    public void compile(Compilation compilation, Target target)
    {
        Declaration declaration;
        CodeAttr codeattr;
        boolean flag;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        if ((new_value instanceof LambdaExp) && (target instanceof IgnoreTarget) && ((LambdaExp)new_value).getInlineOnly())
        {
            return;
        }
        codeattr = compilation.getCode();
        Expression expression;
        if (getHasValue() && !(target instanceof IgnoreTarget))
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        flag1 = false;
        flag4 = false;
        flag3 = false;
        flag5 = false;
        flag6 = false;
        flag7 = false;
        flag = false;
        declaration = binding;
        expression = declaration.getValue();
        if (!(expression instanceof LambdaExp) || !(declaration.context instanceof ModuleExp) || declaration.ignorable() || ((LambdaExp)expression).getName() == null || expression != new_value) goto _L2; else goto _L1
_L1:
        ((LambdaExp)new_value).compileSetField(compilation);
_L13:
        if (flag2 && !flag)
        {
            throw new Error("SetExp.compile: not implemented - return value");
        }
        break; /* Loop/switch isn't completed */
_L2:
        Object obj;
        Declaration declaration1;
        Object obj2;
        Declaration declaration2;
        SetExp setexp;
        if ((declaration.shouldEarlyInit() || declaration.isAlias()) && (declaration.context instanceof ModuleExp) && isDefining() && !declaration.ignorable())
        {
            if (declaration.shouldEarlyInit())
            {
                BindingInitializer.create(declaration, new_value, compilation);
            }
            if (flag2)
            {
                declaration.load(this, 0, compilation, Target.pushObject);
                flag = true;
            }
            continue; /* Loop/switch isn't completed */
        }
        obj = this;
        declaration1 = contextDecl();
        setexp = ((SetExp) (obj));
        obj2 = declaration;
        declaration2 = declaration1;
        if (isDefining()) goto _L4; else goto _L3
_L3:
        setexp = ((SetExp) (obj));
        obj2 = declaration;
        declaration2 = declaration1;
        if (declaration == null) goto _L4; else goto _L5
_L5:
        setexp = ((SetExp) (obj));
        obj2 = declaration;
        declaration2 = declaration1;
        if (!declaration.isAlias()) goto _L4; else goto _L6
_L6:
        obj2 = declaration.getValue();
        if (obj2 instanceof ReferenceExp) goto _L8; else goto _L7
_L7:
        declaration2 = declaration1;
        obj2 = declaration;
        setexp = ((SetExp) (obj));
_L4:
        if (!((Declaration) (obj2)).ignorable())
        {
            break; /* Loop/switch isn't completed */
        }
        new_value.compile(compilation, Target.Ignore);
        continue; /* Loop/switch isn't completed */
_L8:
        Declaration declaration3;
        ReferenceExp referenceexp;
        referenceexp = (ReferenceExp)obj2;
        declaration3 = referenceexp.binding;
        setexp = ((SetExp) (obj));
        obj2 = declaration;
        declaration2 = declaration1;
        if (declaration3 == null) goto _L4; else goto _L9
_L9:
        if (declaration1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        setexp = ((SetExp) (obj));
        obj2 = declaration;
        declaration2 = declaration1;
        if (declaration3.needsContext()) goto _L4; else goto _L10
_L10:
        declaration1 = referenceexp.contextDecl();
        obj = referenceexp;
        declaration = declaration3;
        if (true) goto _L3; else goto _L11
_L11:
        if (((Declaration) (obj2)).isAlias() && isDefining())
        {
            ((Declaration) (obj2)).load(this, 2, compilation, Target.pushObject);
            ClassType classtype = ClassType.make("gnu.mapping.IndirectableLocation");
            codeattr.emitCheckcast(classtype);
            new_value.compile(compilation, Target.pushObject);
            codeattr.emitInvokeVirtual(classtype.getDeclaredMethod("setAlias", 1));
        } else
        if (((Declaration) (obj2)).isIndirectBinding())
        {
            ((Declaration) (obj2)).load(setexp, 2, compilation, Target.pushObject);
            flag = flag4;
            if (isSetIfUnbound())
            {
                flag = flag1;
                if (flag2)
                {
                    codeattr.emitDup();
                    flag = true;
                }
                codeattr.pushScope();
                codeattr.emitDup();
                Variable variable = codeattr.addLocal(Compilation.typeLocation);
                codeattr.emitStore(variable);
                codeattr.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("isBound", 0));
                codeattr.emitIfIntEqZero();
                codeattr.emitLoad(variable);
            }
            new_value.compile(compilation, Target.pushObject);
            flag1 = flag;
            if (flag2)
            {
                flag1 = flag;
                if (!isSetIfUnbound())
                {
                    codeattr.emitDupX();
                    flag1 = true;
                }
            }
            codeattr.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("set", 1));
            flag = flag1;
            if (isSetIfUnbound())
            {
                codeattr.emitFi();
                codeattr.popScope();
                flag = flag1;
            }
        } else
        if (((Declaration) (obj2)).isSimple())
        {
            Type type1 = ((Declaration) (obj2)).getType();
            Variable variable2 = ((Declaration) (obj2)).getVariable();
            Variable variable1 = variable2;
            if (variable2 == null)
            {
                variable1 = ((Declaration) (obj2)).allocateVariable(codeattr);
            }
            int i = canUseInc(new_value, ((Declaration) (obj2)));
            if (i != 0x10000)
            {
                compilation.getCode().emitInc(variable1, (short)i);
                if (flag2)
                {
                    codeattr.emitLoad(variable1);
                    flag = true;
                }
            } else
            {
                new_value.compile(compilation, ((Declaration) (obj2)));
                flag = flag3;
                if (flag2)
                {
                    codeattr.emitDup(type1);
                    flag = true;
                }
                codeattr.emitStore(variable1);
            }
        } else
        if ((((Declaration) (obj2)).context instanceof ClassExp) && ((Declaration) (obj2)).field == null && !getFlag(16) && ((ClassExp)((Declaration) (obj2)).context).isMakingClassPair())
        {
            Object obj1 = ClassExp.slotToMethodName("set", ((Declaration) (obj2)).getName());
            ClassExp classexp = (ClassExp)((Declaration) (obj2)).context;
            obj1 = classexp.type.getDeclaredMethod(((String) (obj1)), 1);
            classexp.loadHeapFrame(compilation);
            new_value.compile(compilation, ((Declaration) (obj2)));
            flag = flag5;
            if (flag2)
            {
                codeattr.emitDupX();
                flag = true;
            }
            codeattr.emitInvoke(((gnu.bytecode.Method) (obj1)));
        } else
        {
            Field field = ((Declaration) (obj2)).field;
            if (!field.getStaticFlag())
            {
                ((Declaration) (obj2)).loadOwningObject(declaration2, compilation);
            }
            Type type = field.getType();
            new_value.compile(compilation, ((Declaration) (obj2)));
            compilation.usedClass(field.getDeclaringClass());
            if (field.getStaticFlag())
            {
                flag = flag6;
                if (flag2)
                {
                    codeattr.emitDup(type);
                    flag = true;
                }
                codeattr.emitPutStatic(field);
            } else
            {
                flag = flag7;
                if (flag2)
                {
                    codeattr.emitDupX();
                    flag = true;
                }
                codeattr.emitPutField(field);
            }
        }
        if (true) goto _L13; else goto _L12
_L12:
        if (flag2)
        {
            target.compileFromStack(compilation, getType());
            return;
        } else
        {
            compilation.compileConstant(Values.empty, target);
            return;
        }
    }

    public final boolean getHasValue()
    {
        return (flags & 0x40) != 0;
    }

    public final Expression getNewValue()
    {
        return new_value;
    }

    public final Type getType()
    {
        if (!getHasValue())
        {
            return Type.voidType;
        }
        if (binding == null)
        {
            return Type.pointer_type;
        } else
        {
            return binding.getType();
        }
    }

    public final boolean isDefining()
    {
        return (flags & 2) != 0;
    }

    public final boolean isFuncDef()
    {
        return (flags & 0x10) != 0;
    }

    public final boolean isSetIfUnbound()
    {
        return (flags & 0x20) != 0;
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        String s;
        if (isDefining())
        {
            s = "(Define";
        } else
        {
            s = "(Set";
        }
        outport.startLogicalBlock(s, ")", 2);
        outport.writeSpaceFill();
        printLineColumn(outport);
        if (binding == null || symbol.toString() != binding.getName())
        {
            outport.print('/');
            outport.print(symbol);
        }
        if (binding != null)
        {
            outport.print('/');
            outport.print(binding);
        }
        outport.writeSpaceLinear();
        new_value.print(outport);
        outport.endLogicalBlock(")");
    }

    public final void setDefining(boolean flag)
    {
        if (flag)
        {
            flags = flags | 2;
            return;
        } else
        {
            flags = flags & -3;
            return;
        }
    }

    public final void setFuncDef(boolean flag)
    {
        if (flag)
        {
            flags = flags | 0x10;
            return;
        } else
        {
            flags = flags & 0xffffffef;
            return;
        }
    }

    public final void setHasValue(boolean flag)
    {
        if (flag)
        {
            flags = flags | 0x40;
            return;
        } else
        {
            flags = flags & 0xffffffbf;
            return;
        }
    }

    public final void setSetIfUnbound(boolean flag)
    {
        if (flag)
        {
            flags = flags | 0x20;
            return;
        } else
        {
            flags = flags & 0xffffffdf;
            return;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("SetExp[").append(symbol).append(":=").append(new_value).append(']').toString();
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitSetExp(this, obj);
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        new_value = expvisitor.visitAndUpdate(new_value, obj);
    }
}
