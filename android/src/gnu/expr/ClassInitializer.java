// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;

// Referenced classes of package gnu.expr:
//            Initializer, ClassExp, Compilation, LambdaExp, 
//            Target

public class ClassInitializer extends Initializer
{

    ClassExp cexp;

    public ClassInitializer(ClassExp classexp, Compilation compilation)
    {
        field = classexp.allocFieldFor(compilation);
        classexp.compileMembers(compilation);
        cexp = classexp;
        if (field.getStaticFlag())
        {
            next = compilation.clinitChain;
            compilation.clinitChain = this;
            return;
        } else
        {
            classexp = classexp.getOwningLambda();
            next = ((LambdaExp) (classexp)).initChain;
            classexp.initChain = this;
            return;
        }
    }

    public void emit(Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        if (!field.getStaticFlag())
        {
            codeattr.emitPushThis();
        }
        cexp.compilePushClass(compilation, Target.pushValue(Compilation.typeClassType));
        if (field.getStaticFlag())
        {
            codeattr.emitPutStatic(field);
            return;
        } else
        {
            codeattr.emitPutField(field);
            return;
        }
    }
}
