// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.ApplyToArgs;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Location;
import gnu.mapping.LocationProc;
import gnu.mapping.ProcLocation;
import gnu.mapping.Procedure;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class location extends Syntax
{

    public static final location location;
    private static ClassType thisType = ClassType.make("kawa.standard.location");

    public location()
    {
    }

    public static Procedure makeLocationProc(Location location1)
    {
        return new LocationProc(location1);
    }

    public static Location makeProcLocation$V(Procedure procedure, Object aobj[])
    {
        int i = aobj.length;
        if ((procedure instanceof ApplyToArgs) && i > 0 && (aobj[0] instanceof Procedure))
        {
            procedure = (Procedure)aobj[0];
            if ((procedure instanceof LocationProc) && i == 1)
            {
                return ((LocationProc)procedure).getLocation();
            } else
            {
                Object aobj1[] = new Object[i - 1];
                System.arraycopy(((Object) (aobj)), 1, ((Object) (aobj1)), 0, aobj1.length);
                return new ProcLocation(procedure, aobj1);
            }
        }
        if ((procedure instanceof LocationProc) && i == 0)
        {
            return ((LocationProc)procedure).getLocation();
        } else
        {
            return new ProcLocation(procedure, aobj);
        }
    }

    public static Expression rewrite(Expression expression, Translator translator)
    {
        if (expression instanceof ReferenceExp)
        {
            expression = (ReferenceExp)expression;
            expression.setDontDereference(true);
            Declaration declaration = expression.getBinding();
            if (declaration != null)
            {
                declaration.maybeIndirectBinding(translator);
                translator = Declaration.followAliases(declaration);
                translator.setCanRead(true);
                translator.setCanWrite(true);
            }
            return expression;
        }
        if (expression instanceof ApplyExp)
        {
            expression = (ApplyExp)expression;
            translator = new Expression[expression.getArgs().length + 1];
            translator[0] = expression.getFunction();
            System.arraycopy(expression.getArgs(), 0, translator, 1, translator.length - 1);
            return Invoke.makeInvokeStatic(thisType, "makeProcLocation", translator);
        } else
        {
            return translator.syntaxError("invalid argument to location");
        }
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        if (!(obj instanceof Pair))
        {
            return translator.syntaxError("missing argument to location");
        }
        obj = (Pair)obj;
        if (((Pair) (obj)).getCdr() != LList.Empty)
        {
            return translator.syntaxError("extra arguments to location");
        } else
        {
            location location1 = location;
            obj = rewrite(translator.rewrite(((Pair) (obj)).getCar()), translator);
            return Invoke.makeInvokeStatic(thisType, "makeLocationProc", new Expression[] {
                obj
            });
        }
    }

    static 
    {
        location = new location();
        location.setName("location");
    }
}
