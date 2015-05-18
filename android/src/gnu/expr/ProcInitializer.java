// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.LocalVarsAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.mapping.Environment;
import gnu.mapping.PropertySet;
import gnu.mapping.Symbol;

// Referenced classes of package gnu.expr:
//            Initializer, Compilation, ModuleExp, LambdaExp, 
//            Language, ModuleMethod, ClassExp, Target, 
//            Expression, Declaration

public class ProcInitializer extends Initializer
{

    LambdaExp proc;

    public ProcInitializer(LambdaExp lambdaexp, Compilation compilation, Field field)
    {
        this.field = field;
        proc = lambdaexp;
        if (field.getStaticFlag())
        {
            lambdaexp = compilation.getModule();
        } else
        {
            lambdaexp = lambdaexp.getOwningLambda();
        }
        if ((lambdaexp instanceof ModuleExp) && compilation.isStatic())
        {
            next = compilation.clinitChain;
            compilation.clinitChain = this;
            return;
        } else
        {
            next = lambdaexp.initChain;
            lambdaexp.initChain = this;
            return;
        }
    }

    public static void emitLoadModuleMethod(LambdaExp lambdaexp, Compilation compilation)
    {
        Object obj2 = lambdaexp.nameDecl;
        Object obj;
        Object obj1;
        CodeAttr codeattr;
        int i;
        if (obj2 == null)
        {
            obj = lambdaexp.getName();
        } else
        {
            obj = ((Declaration) (obj2)).getSymbol();
        }
        codeattr = null;
        obj1 = codeattr;
        if (compilation.immediate)
        {
            obj1 = codeattr;
            if (obj != null)
            {
                obj1 = codeattr;
                if (obj2 != null)
                {
                    obj2 = Environment.getCurrent();
                    int j;
                    if (obj instanceof Symbol)
                    {
                        obj1 = (Symbol)obj;
                    } else
                    {
                        obj1 = Symbol.make("", obj.toString().intern());
                    }
                    obj2 = ((Environment) (obj2)).get(((Symbol) (obj1)), compilation.getLanguage().getEnvPropertyFor(lambdaexp.nameDecl), null);
                    obj1 = codeattr;
                    if (obj2 instanceof ModuleMethod)
                    {
                        obj1 = (ModuleMethod)obj2;
                    }
                }
            }
        }
        codeattr = compilation.getCode();
        obj2 = Compilation.typeModuleMethod;
        if (obj1 == null)
        {
            codeattr.emitNew(((ClassType) (obj2)));
            codeattr.emitDup(1);
            obj1 = "<init>";
        } else
        {
            compilation.compileConstant(obj1, Target.pushValue(((gnu.bytecode.Type) (obj2))));
            obj1 = "init";
        }
        obj2 = ((ClassType) (obj2)).getDeclaredMethod(((String) (obj1)), 4);
        if (lambdaexp.getNeedsClosureEnv())
        {
            obj1 = lambdaexp.getOwningLambda();
        } else
        {
            obj1 = compilation.getModule();
        }
        if ((obj1 instanceof ClassExp) && ((LambdaExp) (obj1)).staticLinkField != null)
        {
            codeattr.emitLoad(codeattr.getCurrentScope().getVariable(1));
        } else
        if (!(obj1 instanceof ModuleExp) || compilation.moduleClass == compilation.mainClass && !compilation.method.getStaticFlag())
        {
            codeattr.emitPushThis();
        } else
        {
            if (compilation.moduleInstanceVar == null)
            {
                compilation.moduleInstanceVar = codeattr.locals.current_scope.addVariable(codeattr, compilation.moduleClass, "$instance");
                if (compilation.moduleClass != compilation.mainClass && !compilation.isStatic())
                {
                    codeattr.emitNew(compilation.moduleClass);
                    codeattr.emitDup(compilation.moduleClass);
                    codeattr.emitInvokeSpecial(compilation.moduleClass.constructor);
                    compilation.moduleInstanceMainField = compilation.moduleClass.addField("$main", compilation.mainClass, 0);
                    codeattr.emitDup(compilation.moduleClass);
                    codeattr.emitPushThis();
                    codeattr.emitPutField(compilation.moduleInstanceMainField);
                } else
                {
                    codeattr.emitGetStatic(compilation.moduleInstanceMainField);
                }
                codeattr.emitStore(compilation.moduleInstanceVar);
            }
            codeattr.emitLoad(compilation.moduleInstanceVar);
        }
        codeattr.emitPushInt(lambdaexp.getSelectorValue(compilation));
        compilation.compileConstant(obj, Target.pushObject);
        j = lambdaexp.min_args;
        if (lambdaexp.keywords == null)
        {
            i = lambdaexp.max_args;
        } else
        {
            i = -1;
        }
        codeattr.emitPushInt(i << 12 | j);
        codeattr.emitInvoke(((Method) (obj2)));
        if (lambdaexp.properties != null)
        {
            j = lambdaexp.properties.length;
            i = 0;
            while (i < j) 
            {
                obj1 = lambdaexp.properties[i];
                if (obj1 != null && obj1 != PropertySet.nameKey)
                {
                    obj = lambdaexp.properties[i + 1];
                    codeattr.emitDup(1);
                    compilation.compileConstant(obj1);
                    obj1 = Target.pushObject;
                    if (obj instanceof Expression)
                    {
                        ((Expression)obj).compile(compilation, ((Target) (obj1)));
                    } else
                    {
                        compilation.compileConstant(obj, ((Target) (obj1)));
                    }
                    codeattr.emitInvokeVirtual(ClassType.make("gnu.mapping.PropertySet").getDeclaredMethod("setProperty", 2));
                }
                i += 2;
            }
        }
    }

    public void emit(Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        if (!field.getStaticFlag())
        {
            codeattr.emitPushThis();
        }
        emitLoadModuleMethod(proc, compilation);
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

    public void reportError(String s, Compilation compilation)
    {
        String s1 = compilation.getFileName();
        int i = compilation.getLineNumber();
        int j = compilation.getColumnNumber();
        compilation.setLocation(proc);
        String s2 = proc.getName();
        s = new StringBuffer(s);
        if (s2 == null)
        {
            s.append("unnamed procedure");
        } else
        {
            s.append("procedure ");
            s.append(s2);
        }
        compilation.error('e', s.toString());
        compilation.setLine(s1, i, j);
    }
}
