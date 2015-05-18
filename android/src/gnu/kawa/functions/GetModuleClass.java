// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BindingInitializer;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.Target;
import gnu.mapping.Namespace;
import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import gnu.text.Path;
import gnu.text.URLPath;

public class GetModuleClass extends ProcedureN
    implements Inlineable
{

    private static Symbol CLASS_RESOURCE_NAME = Namespace.getDefaultSymbol("$class_resource_URL$");
    public static final GetModuleClass getModuleClass = new GetModuleClass();
    public static final GetModuleClass getModuleUri = new GetModuleClass();
    public static final GetModuleClass getModuleUriDummy = new GetModuleClass();
    static final Method maker;
    static final ClassType typeURLPath;

    public GetModuleClass()
    {
    }

    public static Expression getModuleClassURI(Compilation compilation)
    {
        Declaration declaration = compilation.mainLambda.lookup(CLASS_RESOURCE_NAME);
        Object obj = declaration;
        if (declaration == null)
        {
            Declaration declaration1 = new Declaration(CLASS_RESOURCE_NAME, typeURLPath);
            declaration1.setFlag(0x20004800L);
            if (compilation.immediate)
            {
                Object obj1 = compilation.minfo.getSourceAbsPath();
                obj = obj1;
                if (obj1 == null)
                {
                    obj = Path.currentPath();
                }
                obj1 = obj;
                if (!(obj instanceof URLPath))
                {
                    obj1 = URLPath.valueOf(((Path) (obj)).toURL());
                }
                obj = QuoteExp.getInstance(obj1);
            } else
            {
                obj = new ApplyExp(getModuleClass, Expression.noExpressions);
                obj = new ApplyExp(maker, new Expression[] {
                    obj
                });
            }
            declaration1.setValue(((Expression) (obj)));
            compilation.mainLambda.add(null, declaration1);
            obj = declaration1;
        }
        obj = new ReferenceExp(((Declaration) (obj)));
        if (compilation.immediate)
        {
            return ((Expression) (obj));
        } else
        {
            return new ApplyExp(getModuleUriDummy, new Expression[] {
                obj
            });
        }
    }

    public Object applyN(Object aobj[])
    {
        throw new Error("get-module-class must be inlined");
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        if (this == getModuleUriDummy)
        {
            applyexp = (ReferenceExp)applyexp.getArgs()[0];
            applyexp.compile(compilation, target);
            applyexp = applyexp.getBinding();
            target = applyexp.getValue();
            if (target != null)
            {
                BindingInitializer.create(applyexp, target, compilation);
                applyexp.setValue(null);
            }
            return;
        }
        compilation.loadClassRef(compilation.mainClass);
        if (this == getModuleUri)
        {
            compilation.getCode().emitInvoke(maker);
        }
        target.compileFromStack(compilation, applyexp.getType());
    }

    public Type getReturnType(Expression aexpression[])
    {
        if (this == getModuleClass)
        {
            return Type.javalangClassType;
        } else
        {
            return typeURLPath;
        }
    }

    public int numArgs()
    {
        return this != getModuleUriDummy ? 0 : 4097;
    }

    static 
    {
        typeURLPath = ClassType.make("gnu.text.URLPath");
        maker = typeURLPath.getDeclaredMethod("classResourcePath", 1);
    }
}
