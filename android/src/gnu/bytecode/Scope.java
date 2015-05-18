// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            Variable, VarEnumerator, Label, CodeAttr, 
//            Type

public class Scope
{

    Label end;
    Scope firstChild;
    Scope lastChild;
    Variable last_var;
    Scope nextSibling;
    Scope parent;
    boolean preserved;
    Label start;
    Variable vars;

    public Scope()
    {
    }

    public Scope(Label label, Label label1)
    {
        start = label;
        end = label1;
    }

    static boolean equals(byte abyte0[], byte abyte1[])
    {
        if (abyte0.length != abyte1.length)
        {
            return false;
        }
        if (abyte0 == abyte1)
        {
            return true;
        }
        int i = abyte0.length;
        do
        {
            int j = i - 1;
            if (j >= 0)
            {
                i = j;
                if (abyte0[j] != abyte1[j])
                {
                    return false;
                }
            } else
            {
                return true;
            }
        } while (true);
    }

    public Variable addVariable(CodeAttr codeattr, Type type, String s)
    {
        type = new Variable(s, type);
        addVariable(codeattr, ((Variable) (type)));
        return type;
    }

    public void addVariable(CodeAttr codeattr, Variable variable)
    {
        addVariable(variable);
        if (variable.isSimple() && codeattr != null)
        {
            variable.allocateLocal(codeattr);
        }
    }

    public void addVariable(Variable variable)
    {
        if (last_var == null)
        {
            vars = variable;
        } else
        {
            last_var.next = variable;
        }
        last_var = variable;
        variable.scope = this;
    }

    public void addVariableAfter(Variable variable, Variable variable1)
    {
        if (variable == null)
        {
            variable1.next = vars;
            vars = variable1;
        } else
        {
            variable1.next = variable.next;
            variable.next = variable1;
        }
        if (last_var == variable)
        {
            last_var = variable1;
        }
        if (variable1.next == variable1)
        {
            throw new Error("cycle");
        } else
        {
            variable1.scope = this;
            return;
        }
    }

    public VarEnumerator allVars()
    {
        return new VarEnumerator(this);
    }

    public final Variable firstVar()
    {
        return vars;
    }

    void freeLocals(CodeAttr codeattr)
    {
        if (!preserved)
        {
            for (Variable variable = vars; variable != null; variable = variable.next)
            {
                if (variable.isSimple() && !variable.dead())
                {
                    variable.freeLocal(codeattr);
                }
            }

            Scope scope = firstChild;
            while (scope != null) 
            {
                if (scope.preserved)
                {
                    scope.preserved = false;
                    scope.freeLocals(codeattr);
                }
                scope = scope.nextSibling;
            }
        }
    }

    public Variable getVariable(int i)
    {
        Variable variable = vars;
        do
        {
            i--;
            if (i >= 0)
            {
                variable = variable.next;
            } else
            {
                return variable;
            }
        } while (true);
    }

    public void linkChild(Scope scope)
    {
        parent = scope;
        if (scope == null)
        {
            return;
        }
        if (scope.lastChild == null)
        {
            scope.firstChild = this;
        } else
        {
            scope.lastChild.nextSibling = this;
        }
        scope.lastChild = this;
    }

    public Variable lookup(String s)
    {
        for (Variable variable = vars; variable != null; variable = variable.next)
        {
            if (s.equals(variable.name))
            {
                return variable;
            }
        }

        return null;
    }

    public void noteStartFunction(CodeAttr codeattr)
    {
        setStartPC(codeattr);
        start.setTypes(codeattr);
    }

    public void setStartPC(CodeAttr codeattr)
    {
        if (start == null)
        {
            start = new Label();
        }
        boolean flag = codeattr.reachableHere();
        start.define(codeattr);
        codeattr.setReachable(flag);
    }
}
