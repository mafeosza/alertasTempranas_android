// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.util.Enumeration;
import java.util.NoSuchElementException;

// Referenced classes of package gnu.bytecode:
//            Scope, Variable

public class VarEnumerator
    implements Enumeration
{

    Scope currentScope;
    Variable next;
    Scope topScope;

    public VarEnumerator(Scope scope)
    {
        topScope = scope;
        reset();
    }

    private void fixup()
    {
_L5:
        if (next != null) goto _L2; else goto _L1
_L1:
        if (currentScope.firstChild == null) goto _L4; else goto _L3
_L3:
        currentScope = currentScope.firstChild;
_L7:
        next = currentScope.firstVar();
          goto _L5
_L6:
        currentScope = currentScope.parent;
_L4:
        if (currentScope.nextSibling != null)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        if (currentScope != topScope) goto _L6; else goto _L2
_L2:
        return;
        currentScope = currentScope.nextSibling;
          goto _L7
    }

    public final boolean hasMoreElements()
    {
        return next != null;
    }

    public Object nextElement()
    {
        Variable variable = nextVar();
        if (variable == null)
        {
            throw new NoSuchElementException("VarEnumerator");
        } else
        {
            return variable;
        }
    }

    public final Variable nextVar()
    {
        Variable variable = next;
        if (variable != null)
        {
            next = variable.nextVar();
            if (next == null)
            {
                fixup();
            }
        }
        return variable;
    }

    public final void reset()
    {
        currentScope = topScope;
        if (topScope != null)
        {
            next = currentScope.firstVar();
            if (next == null)
            {
                fixup();
            }
        }
    }
}
