// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, CodeAttr, Method, VarEnumerator, 
//            Variable, ClassType, ConstantPool, CpoolUtf8, 
//            Type, Scope, ClassTypeWriter, Label

public class LocalVarsAttr extends Attribute
{

    public Scope current_scope;
    private Method method;
    Scope parameter_scope;
    Variable used[];

    public LocalVarsAttr(CodeAttr codeattr)
    {
        super("LocalVariableTable");
        addToFrontOf(codeattr);
        method = (Method)codeattr.getContainer();
        codeattr.locals = this;
    }

    public LocalVarsAttr(Method method1)
    {
        super("LocalVariableTable");
        CodeAttr codeattr = method1.code;
        method = method1;
        codeattr.locals = this;
    }

    public VarEnumerator allVars()
    {
        return new VarEnumerator(parameter_scope);
    }

    public void assignConstants(ClassType classtype)
    {
        super.assignConstants(classtype);
        VarEnumerator varenumerator = allVars();
        do
        {
            Variable variable = varenumerator.nextVar();
            if (variable == null)
            {
                break;
            }
            if (variable.isSimple() && variable.name != null)
            {
                if (variable.name_index == 0)
                {
                    variable.name_index = classtype.getConstants().addUtf8(variable.getName()).index;
                }
                if (variable.signature_index == 0)
                {
                    variable.signature_index = classtype.getConstants().addUtf8(variable.getType().getSignature()).index;
                }
            }
        } while (true);
    }

    public void enterScope(Scope scope)
    {
        CodeAttr codeattr;
        scope.linkChild(current_scope);
        current_scope = scope;
        codeattr = method.getCode();
        scope = scope.firstVar();
_L1:
        if (scope == null)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (scope.isSimple())
        {
            if (!scope.isAssigned())
            {
                scope.allocateLocal(codeattr);
            } else
            {
                if (used[((Variable) (scope)).offset] != null)
                {
                    continue; /* Loop/switch isn't completed */
                }
                used[((Variable) (scope)).offset] = scope;
            }
        }
_L3:
        scope = scope.nextVar();
          goto _L1
        if (used[((Variable) (scope)).offset] == scope) goto _L3; else goto _L2
_L2:
        throw new Error((new StringBuilder()).append("inconsistent local variable assignments for ").append(scope).append(" != ").append(used[((Variable) (scope)).offset]).toString());
    }

    public final int getCount()
    {
        int i = 0;
        VarEnumerator varenumerator = allVars();
        do
        {
            Variable variable = varenumerator.nextVar();
            if (variable == null)
            {
                break;
            }
            if (variable.shouldEmit())
            {
                i++;
            }
        } while (true);
        return i;
    }

    public final int getLength()
    {
        return getCount() * 10 + 2;
    }

    public final Method getMethod()
    {
        return method;
    }

    public final boolean isEmpty()
    {
        VarEnumerator varenumerator = allVars();
        do
        {
            Variable variable = varenumerator.nextVar();
            if (variable != null)
            {
                if (variable.isSimple() && variable.name != null)
                {
                    return false;
                }
            } else
            {
                return true;
            }
        } while (true);
    }

    public void preserveVariablesUpto(Scope scope)
    {
        for (Scope scope1 = current_scope; scope1 != scope; scope1 = scope1.parent)
        {
            scope1.preserved = true;
        }

    }

    public void print(ClassTypeWriter classtypewriter)
    {
        VarEnumerator varenumerator;
        varenumerator = allVars();
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.print(getLength());
        classtypewriter.print(", count: ");
        classtypewriter.println(getCount());
        varenumerator.reset();
_L9:
        Object obj = varenumerator.nextVar();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!((Variable) (obj)).isSimple() || ((Variable) (obj)).name == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        classtypewriter.print("  slot#");
        classtypewriter.print(((Variable) (obj)).offset);
        classtypewriter.print(": name: ");
        classtypewriter.printOptionalIndex(((Variable) (obj)).name_index);
        classtypewriter.print(((Variable) (obj)).getName());
        classtypewriter.print(", type: ");
        classtypewriter.printOptionalIndex(((Variable) (obj)).signature_index);
        classtypewriter.printSignature(((Variable) (obj)).getType());
        classtypewriter.print(" (pc: ");
        obj = ((Variable) (obj)).scope;
        if (obj == null || ((Scope) (obj)).start == null || ((Scope) (obj)).end == null) goto _L4; else goto _L3
_L3:
        int i = ((Scope) (obj)).start.position;
        if (i < 0) goto _L4; else goto _L5
_L5:
        int j = ((Scope) (obj)).end.position;
        if (j >= 0) goto _L6; else goto _L4
_L4:
        classtypewriter.print("unknown");
_L7:
        classtypewriter.println(')');
        continue; /* Loop/switch isn't completed */
_L6:
        classtypewriter.print(i);
        classtypewriter.print(" length: ");
        classtypewriter.print(j - i);
        if (true) goto _L7; else goto _L2
_L2:
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        VarEnumerator varenumerator = allVars();
        dataoutputstream.writeShort(getCount());
        varenumerator.reset();
        do
        {
            Variable variable = varenumerator.nextVar();
            if (variable == null)
            {
                break;
            }
            if (variable.shouldEmit())
            {
                Scope scope = variable.scope;
                int i = scope.start.position;
                int j = scope.end.position;
                dataoutputstream.writeShort(i);
                dataoutputstream.writeShort(j - i);
                dataoutputstream.writeShort(variable.name_index);
                dataoutputstream.writeShort(variable.signature_index);
                dataoutputstream.writeShort(variable.offset);
            }
        } while (true);
    }
}
