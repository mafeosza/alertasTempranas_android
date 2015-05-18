// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.TypeValue;
import gnu.lists.AbstractSequence;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.kawa.xml:
//            NodeType, KProcessingInstruction

public class ProcessingInstructionType extends NodeType
    implements TypeValue, Externalizable
{

    static final Method coerceMethod;
    static final Method coerceOrNullMethod;
    public static final ProcessingInstructionType piNodeTest = new ProcessingInstructionType(null);
    public static final ClassType typeProcessingInstructionType;
    String target;

    public ProcessingInstructionType(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = "processing-instruction()";
        } else
        {
            s1 = (new StringBuilder()).append("processing-instruction(").append(s).append(")").toString();
        }
        super(s1);
        target = s;
    }

    public static KProcessingInstruction coerce(Object obj, String s)
    {
        obj = coerceOrNull(obj, s);
        if (obj == null)
        {
            throw new ClassCastException();
        } else
        {
            return ((KProcessingInstruction) (obj));
        }
    }

    public static KProcessingInstruction coerceOrNull(Object obj, String s)
    {
        obj = (KProcessingInstruction)NodeType.coerceOrNull(obj, 32);
        if (obj != null && (s == null || s.equals(((KProcessingInstruction) (obj)).getTarget())))
        {
            return ((KProcessingInstruction) (obj));
        } else
        {
            return null;
        }
    }

    public static ProcessingInstructionType getInstance(String s)
    {
        if (s == null)
        {
            return piNodeTest;
        } else
        {
            return new ProcessingInstructionType(s);
        }
    }

    public Object coerceFromObject(Object obj)
    {
        return coerce(obj, target);
    }

    public void emitCoerceFromObject(CodeAttr codeattr)
    {
        codeattr.emitPushString(target);
        codeattr.emitInvokeStatic(coerceMethod);
    }

    protected void emitCoerceOrNullMethod(Variable variable, Compilation compilation)
    {
        compilation = compilation.getCode();
        if (variable != null)
        {
            compilation.emitLoad(variable);
        }
        compilation.emitPushString(target);
        compilation.emitInvokeStatic(coerceOrNullMethod);
    }

    public Type getImplementationType()
    {
        return ClassType.make("gnu.kawa.xml.KProcessingInstruction");
    }

    public boolean isInstance(Object obj)
    {
        return coerceOrNull(obj, target) != null;
    }

    public boolean isInstancePos(AbstractSequence abstractsequence, int i)
    {
        boolean flag = false;
        int j = abstractsequence.getNextKind(i);
        if (j == 37)
        {
            if (target == null || target.equals(abstractsequence.getNextTypeObject(i)))
            {
                flag = true;
            }
        } else
        if (j == 32)
        {
            return isInstance(abstractsequence.getPosNext(i));
        }
        return flag;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        target = (String)objectinput.readObject();
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("ProcessingInstructionType ");
        String s;
        if (target == null)
        {
            s = "*";
        } else
        {
            s = target;
        }
        return stringbuilder.append(s).toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(target);
    }

    static 
    {
        typeProcessingInstructionType = ClassType.make("gnu.kawa.xml.ProcessingInstructionType");
        coerceMethod = typeProcessingInstructionType.getDeclaredMethod("coerce", 2);
        coerceOrNullMethod = typeProcessingInstructionType.getDeclaredMethod("coerceOrNull", 2);
    }
}
