// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.Variable;
import gnu.mapping.Procedure;
import java.lang.reflect.Type;

// Referenced classes of package gnu.expr:
//            Expression, Compilation, Target, Declaration

public interface TypeValue
    extends Type
{

    public abstract Expression convertValue(Expression expression);

    public abstract void emitIsInstance(Variable variable, Compilation compilation, Target target);

    public abstract void emitTestIf(Variable variable, Declaration declaration, Compilation compilation);

    public abstract Procedure getConstructor();

    public abstract gnu.bytecode.Type getImplementationType();
}
