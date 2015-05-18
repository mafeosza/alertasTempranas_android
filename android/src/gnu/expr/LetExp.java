// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.OutPort;

// Referenced classes of package gnu.expr:
//            ScopeExp, QuoteExp, Declaration, Expression, 
//            Compilation, Target, CheckedTarget, BindingInitializer, 
//            ExpVisitor

public class LetExp extends ScopeExp
{

    public Expression body;
    public Expression inits[];

    public LetExp(Expression aexpression[])
    {
        inits = aexpression;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object aobj[][];
        Object obj1;
        Object aobj2[];
        Object aobj3[];
        int i;
        int j;
        setIndexes();
        j = ScopeExp.nesting(this);
        aobj2 = new Object[frameSize];
        Object aobj1[][] = callcontext.evalFrames;
        if (aobj1 == null)
        {
            aobj = new Object[j + 10][];
            callcontext.evalFrames = aobj;
        } else
        {
            aobj = aobj1;
            if (j >= aobj1.length)
            {
                obj1 = ((Object) (new Object[j + 10][]));
                System.arraycopy(((Object) (aobj1)), 0, obj1, 0, aobj1.length);
                aobj = ((Object [][]) (obj1));
                callcontext.evalFrames = ((Object [][]) (obj1));
            }
        }
        aobj3 = aobj[j];
        aobj[j] = aobj2;
        i = 0;
        obj1 = firstDecl();
_L4:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_224;
        }
        if (inits[i] != QuoteExp.undefined_exp) goto _L2; else goto _L1
_L1:
        obj1 = ((Declaration) (obj1)).nextDecl();
        i++;
        continue; /* Loop/switch isn't completed */
_L2:
        Object obj2;
        Type type;
        obj2 = evalVariable(i, callcontext);
        type = ((Declaration) (obj1)).type;
        Object obj;
        obj = obj2;
        if (type == null)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        obj = obj2;
        if (type != Type.pointer_type)
        {
            obj = type.coerceFromObject(obj2);
        }
        obj2 = obj;
        if (((Declaration) (obj1)).isIndirectBinding())
        {
            obj2 = ((Declaration) (obj1)).makeIndirectLocationFor();
            ((Location) (obj2)).set(obj);
        }
        aobj2[i] = obj2;
          goto _L1
        callcontext;
        aobj[j] = aobj3;
        throw callcontext;
        body.apply(callcontext);
        aobj[j] = aobj3;
        return;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void compile(Compilation compilation, Target target)
    {
        CodeAttr codeattr = compilation.getCode();
        Declaration declaration = firstDecl();
        int i = 0;
        while (i < inits.length) 
        {
            Expression expression = inits[i];
            boolean flag = declaration.needsInit();
            if (flag && declaration.isSimple())
            {
                declaration.allocateVariable(codeattr);
            }
            Object obj;
            Target target1;
            if (!flag || declaration.isIndirectBinding() && expression == QuoteExp.undefined_exp)
            {
                target1 = Target.Ignore;
                obj = expression;
            } else
            {
                Type type = declaration.getType();
                Target target2 = CheckedTarget.getInstance(declaration);
                obj = expression;
                target1 = target2;
                if (expression == QuoteExp.undefined_exp)
                {
                    if (type instanceof PrimType)
                    {
                        obj = new QuoteExp(new Byte((byte)0));
                        target1 = target2;
                    } else
                    {
                        obj = expression;
                        target1 = target2;
                        if (type != null)
                        {
                            obj = expression;
                            target1 = target2;
                            if (type != Type.pointer_type)
                            {
                                obj = QuoteExp.nullExp;
                                target1 = target2;
                            }
                        }
                    }
                }
            }
            ((Expression) (obj)).compileWithPosition(compilation, target1);
            i++;
            declaration = declaration.nextDecl();
        }
        codeattr.enterScope(getVarScope());
        store_rest(compilation, 0, firstDecl());
        body.compileWithPosition(compilation, target);
        popScope(codeattr);
    }

    protected Object evalVariable(int i, CallContext callcontext)
        throws Throwable
    {
        return inits[i].eval(callcontext);
    }

    public Expression getBody()
    {
        return body;
    }

    public final Type getType()
    {
        return body.getType();
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        print(outport, "(Let", ")");
    }

    public void print(OutPort outport, String s, String s1)
    {
        outport.startLogicalBlock((new StringBuilder()).append(s).append("#").append(id).toString(), s1, 2);
        outport.writeSpaceFill();
        printLineColumn(outport);
        outport.startLogicalBlock("(", false, ")");
        s = firstDecl();
        int i = 0;
        while (s != null) 
        {
            if (i > 0)
            {
                outport.writeSpaceFill();
            }
            outport.startLogicalBlock("(", false, ")");
            s.printInfo(outport);
            int j = i;
            if (inits != null)
            {
                outport.writeSpaceFill();
                outport.print('=');
                outport.writeSpaceFill();
                if (i >= inits.length)
                {
                    outport.print("<missing init>");
                } else
                if (inits[i] == null)
                {
                    outport.print("<null>");
                } else
                {
                    inits[i].print(outport);
                }
                j = i + 1;
            }
            outport.endLogicalBlock(")");
            s = s.nextDecl();
            i = j;
        }
        outport.endLogicalBlock(")");
        outport.writeSpaceLinear();
        if (body == null)
        {
            outport.print("<null body>");
        } else
        {
            body.print(outport);
        }
        outport.endLogicalBlock(s1);
    }

    public void setBody(Expression expression)
    {
        body = expression;
    }

    void store_rest(Compilation compilation, int i, Declaration declaration)
    {
        if (declaration != null)
        {
            store_rest(compilation, i + 1, declaration.nextDecl());
            if (declaration.needsInit())
            {
                if (declaration.isIndirectBinding())
                {
                    CodeAttr codeattr = compilation.getCode();
                    if (inits[i] == QuoteExp.undefined_exp)
                    {
                        Object obj = declaration.getSymbol();
                        compilation.compileConstant(obj, Target.pushObject);
                        codeattr.emitInvokeStatic(BindingInitializer.makeLocationMethod(obj));
                    } else
                    {
                        declaration.pushIndirectBinding(compilation);
                    }
                }
                declaration.compileStore(compilation);
            }
        }
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitLetExp(this, obj);
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        visitInitializers(expvisitor, obj);
        if (expvisitor.exitValue == null)
        {
            body = expvisitor.visitAndUpdate(body, obj);
        }
    }

    public void visitInitializers(ExpVisitor expvisitor, Object obj)
    {
        Declaration declaration = firstDecl();
        for (int i = 0; i < inits.length;)
        {
            Expression expression = inits[i];
            if (expression == null)
            {
                throw new Error((new StringBuilder()).append("null1 init for ").append(this).append(" i:").append(i).append(" d:").append(declaration).toString());
            }
            Expression expression1 = expvisitor.visitAndUpdate(expression, obj);
            if (expression1 == null)
            {
                throw new Error((new StringBuilder()).append("null2 init for ").append(this).append(" was:").append(expression).toString());
            }
            inits[i] = expression1;
            if (declaration.value == expression)
            {
                declaration.value = expression1;
            }
            i++;
            declaration = declaration.nextDecl();
        }

    }
}
