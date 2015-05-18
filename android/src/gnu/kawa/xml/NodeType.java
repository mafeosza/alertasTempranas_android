// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.kawa.reflect.InstanceOf;
import gnu.lists.AbstractSequence;
import gnu.lists.NodePredicate;
import gnu.mapping.Procedure;
import gnu.xml.NodeTree;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.kawa.xml:
//            KNode

public class NodeType extends ObjectType
    implements TypeValue, NodePredicate, Externalizable
{

    public static final int ATTRIBUTE_OK = 4;
    public static final int COMMENT_OK = 16;
    public static final int DOCUMENT_OK = 8;
    public static final int ELEMENT_OK = 2;
    public static final int PI_OK = 32;
    public static final int TEXT_OK = 1;
    public static final NodeType anyNodeTest = new NodeType("node");
    static final Method coerceMethod;
    static final Method coerceOrNullMethod;
    public static final NodeType commentNodeTest = new NodeType("comment", 16);
    public static final NodeType documentNodeTest = new NodeType("document-node", 8);
    public static final NodeType nodeType = new NodeType("gnu.kawa.xml.KNode");
    public static final NodeType textNodeTest = new NodeType("text", 1);
    public static final ClassType typeKNode = ClassType.make("gnu.kawa.xml.KNode");
    public static final ClassType typeNodeType;
    int kinds;

    public NodeType(String s)
    {
        this(s, -1);
    }

    public NodeType(String s, int i)
    {
        super(s);
        kinds = -1;
        kinds = i;
    }

    public static KNode coerceForce(Object obj, int i)
    {
        KNode knode = coerceOrNull(obj, i);
        if (knode == null)
        {
            throw new ClassCastException((new StringBuilder()).append("coerce from ").append(obj.getClass()).toString());
        } else
        {
            return knode;
        }
    }

    public static KNode coerceOrNull(Object obj, int i)
    {
        Object obj1 = null;
        if (!(obj instanceof NodeTree)) goto _L2; else goto _L1
_L1:
        obj = KNode.make((NodeTree)obj);
_L5:
        if (!isInstance(((KNode) (obj)).sequence, ((KNode) (obj)).ipos, i))
        {
            obj = null;
        }
        obj1 = obj;
_L4:
        return ((KNode) (obj1));
_L2:
        if (!(obj instanceof KNode)) goto _L4; else goto _L3
_L3:
        obj = (KNode)obj;
          goto _L5
    }

    public static boolean isInstance(AbstractSequence abstractsequence, int i, int j)
    {
        i = abstractsequence.getNextKind(i);
        if (j >= 0) goto _L2; else goto _L1
_L1:
        if (i == 0) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        i;
        JVM INSTR tableswitch 0 37: default 184
    //                   0 186
    //                   1 184
    //                   2 184
    //                   3 184
    //                   4 184
    //                   5 184
    //                   6 184
    //                   7 184
    //                   8 184
    //                   9 184
    //                   10 184
    //                   11 184
    //                   12 184
    //                   13 184
    //                   14 184
    //                   15 184
    //                   16 184
    //                   17 188
    //                   18 188
    //                   19 188
    //                   20 188
    //                   21 188
    //                   22 188
    //                   23 188
    //                   24 188
    //                   25 188
    //                   26 188
    //                   27 188
    //                   28 188
    //                   29 188
    //                   30 184
    //                   31 184
    //                   32 188
    //                   33 196
    //                   34 212
    //                   35 204
    //                   36 221
    //                   37 230;
           goto _L5 _L6 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L5 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L7 _L5 _L5 _L7 _L8 _L9 _L10 _L11 _L12
_L12:
        continue; /* Loop/switch isn't completed */
_L5:
        return true;
_L6:
        return false;
_L7:
        if ((j & 1) != 0) goto _L3; else goto _L13
_L13:
        return false;
_L8:
        if ((j & 2) != 0) goto _L3; else goto _L14
_L14:
        return false;
_L10:
        if ((j & 4) != 0) goto _L3; else goto _L15
_L15:
        return false;
_L9:
        if ((j & 8) != 0) goto _L3; else goto _L16
_L16:
        return false;
_L11:
        if ((j & 0x10) != 0) goto _L3; else goto _L17
_L17:
        return false;
        if ((j & 0x20) != 0) goto _L3; else goto _L18
_L18:
        return false;
    }

    public Object coerceFromObject(Object obj)
    {
        return coerceForce(obj, kinds);
    }

    public int compare(Type type)
    {
        return getImplementationType().compare(type);
    }

    public Expression convertValue(Expression expression)
    {
        expression = new ApplyExp(coerceMethod, new Expression[] {
            expression
        });
        expression.setType(this);
        return expression;
    }

    public void emitCoerceFromObject(CodeAttr codeattr)
    {
        codeattr.emitPushInt(kinds);
        codeattr.emitInvokeStatic(coerceMethod);
    }

    protected void emitCoerceOrNullMethod(Variable variable, Compilation compilation)
    {
        compilation = compilation.getCode();
        if (variable != null)
        {
            compilation.emitLoad(variable);
        }
        compilation.emitPushInt(kinds);
        compilation.emitInvokeStatic(coerceOrNullMethod);
    }

    public void emitIsInstance(Variable variable, Compilation compilation, Target target)
    {
        if (target instanceof ConditionalTarget)
        {
            target = (ConditionalTarget)target;
            emitCoerceOrNullMethod(variable, compilation);
            variable = compilation.getCode();
            if (((ConditionalTarget) (target)).trueBranchComesFirst)
            {
                variable.emitGotoIfCompare1(((ConditionalTarget) (target)).ifFalse, 198);
            } else
            {
                variable.emitGotoIfCompare1(((ConditionalTarget) (target)).ifTrue, 199);
            }
            target.emitGotoFirstBranch(variable);
            return;
        } else
        {
            InstanceOf.emitIsInstance(this, variable, compilation, target);
            return;
        }
    }

    public void emitTestIf(Variable variable, Declaration declaration, Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        emitCoerceOrNullMethod(variable, compilation);
        if (declaration != null)
        {
            codeattr.emitDup();
            declaration.compileStore(compilation);
        }
        codeattr.emitIfNotNull();
    }

    public Procedure getConstructor()
    {
        return null;
    }

    public Type getImplementationType()
    {
        return typeKNode;
    }

    public boolean isInstance(Object obj)
    {
        if (obj instanceof KNode)
        {
            obj = (KNode)obj;
            return isInstancePos(((KNode) (obj)).sequence, ((KNode) (obj)).getPos());
        } else
        {
            return false;
        }
    }

    public boolean isInstancePos(AbstractSequence abstractsequence, int i)
    {
        return isInstance(abstractsequence, i, kinds);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        String s = objectinput.readUTF();
        if (s.length() > 0)
        {
            setName(s);
        }
        kinds = objectinput.readInt();
    }

    public String toString()
    {
        return (new StringBuilder()).append("NodeType ").append(getName()).toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        String s1 = getName();
        String s = s1;
        if (s1 == null)
        {
            s = "";
        }
        objectoutput.writeUTF(s);
        objectoutput.writeInt(kinds);
    }

    static 
    {
        typeNodeType = ClassType.make("gnu.kawa.xml.NodeType");
        coerceMethod = typeNodeType.getDeclaredMethod("coerceForce", 2);
        coerceOrNullMethod = typeNodeType.getDeclaredMethod("coerceOrNull", 2);
    }
}
