// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Target;
import gnu.expr.TypeValue;
import gnu.lists.ItemPredicate;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.kawa.reflect:
//            SingletonType, InstanceOf

public class OccurrenceType extends ObjectType
    implements Externalizable, TypeValue
{

    public static final Type emptySequenceType;
    static final Method isInstanceMethod;
    public static final ClassType typeOccurrenceType;
    Type base;
    int maxOccurs;
    int minOccurs;

    public OccurrenceType(Type type, int i, int j)
    {
        base = type;
        minOccurs = i;
        maxOccurs = j;
    }

    public static Type getInstance(Type type, int i, int j)
    {
        if (i == 1 && j == 1)
        {
            return type;
        }
        if (i == 0 && j < 0 && (type == SingletonType.instance || type == Type.pointer_type))
        {
            return Type.pointer_type;
        } else
        {
            return new OccurrenceType(type, i, j);
        }
    }

    public static char itemCountCode(Type type)
    {
        int j = itemCountRange(type);
        int i = j & 0xfff;
        j >>= 12;
        if (j == 0)
        {
            return '0';
        }
        if (i == 0)
        {
            return j != 1 ? '*' : '?';
        }
        return i != 1 || j != 1 ? '+' : '1';
    }

    public static boolean itemCountIsOne(Type type)
    {
        return itemCountRange(type) == 4097;
    }

    public static boolean itemCountIsZeroOrOne(Type type)
    {
        return itemCountRange(type) >> 13 == 0;
    }

    public static int itemCountRange(Type type)
    {
        int i = 0;
        if (!(type instanceof SingletonType))
        {
            if (type instanceof OccurrenceType)
            {
                type = (OccurrenceType)type;
                int j = type.minOccurs();
                int k = type.maxOccurs();
                int j1 = itemCountRange(type.getBase());
                if (j == 1 && k == 1 || j1 == 0)
                {
                    return j1;
                }
                i = k;
                if (k > 0xfffff)
                {
                    i = -1;
                }
                if (i == 0)
                {
                    return 0;
                }
                int i1 = j1 >> 12;
                k = i;
                int l = j;
                if (j1 != 4097)
                {
                    k = j;
                    if (j > 4095)
                    {
                        k = 4095;
                    }
                    k *= j1 & 0xfff;
                    j = k;
                    if (k > 4095)
                    {
                        j = 4095;
                    }
                    if (i < 0 || i1 < 0)
                    {
                        i = -1;
                    } else
                    {
                        i *= i1;
                    }
                    k = i;
                    l = j;
                    if (i > 0xfffff)
                    {
                        k = -1;
                        l = j;
                    }
                }
                return k << 12 | l;
            }
            if (type instanceof PrimType)
            {
                if (!type.isVoid())
                {
                    i = 4097;
                }
                return i;
            }
            if (!(type instanceof ArrayType) && (!(type instanceof ObjectType) || type.compare(Compilation.typeValues) != -3))
            {
                return -4096;
            }
        }
        return 4097;
    }

    public static Type itemPrimeType(Type type)
    {
        for (; type instanceof OccurrenceType; type = ((OccurrenceType)type).getBase()) { }
        if (itemCountIsOne(type))
        {
            return type;
        } else
        {
            return SingletonType.instance;
        }
    }

    public Object coerceFromObject(Object obj)
    {
        Object obj1;
        if ((obj instanceof Values) || minOccurs > 1 || maxOccurs == 0)
        {
            obj1 = obj;
            if (!isInstance(obj))
            {
                throw new ClassCastException();
            }
        } else
        {
            obj1 = base.coerceFromObject(obj);
        }
        return obj1;
    }

    public int compare(Type type)
    {
        if (type instanceof OccurrenceType)
        {
            type = (OccurrenceType)type;
            if (minOccurs == ((OccurrenceType) (type)).minOccurs && maxOccurs == ((OccurrenceType) (type)).maxOccurs)
            {
                return base.compare(type.getBase());
            }
        }
        return -2;
    }

    public Expression convertValue(Expression expression)
    {
        return null;
    }

    public void emitIsInstance(Variable variable, Compilation compilation, Target target)
    {
        InstanceOf.emitIsInstance(this, variable, compilation, target);
    }

    public void emitTestIf(Variable variable, Declaration declaration, Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        if (variable != null)
        {
            codeattr.emitLoad(variable);
        }
        if (declaration != null)
        {
            codeattr.emitDup();
            declaration.compileStore(compilation);
        }
        compilation.compileConstant(this);
        codeattr.emitSwap();
        codeattr.emitInvokeVirtual(isInstanceMethod);
        codeattr.emitIfIntNotZero();
    }

    public Type getBase()
    {
        return base;
    }

    public Procedure getConstructor()
    {
        return null;
    }

    public Type getImplementationType()
    {
        return Type.pointer_type;
    }

    public boolean isInstance(Object obj)
    {
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag4 = true;
        flag2 = true;
        flag3 = false;
        if (!(obj instanceof Values)) goto _L2; else goto _L1
_L1:
        int i;
        int j;
        int k;
        boolean flag;
        obj = (Values)obj;
        i = ((Values) (obj)).startPos();
        j = 0;
        flag = false;
        k = i;
        if (!(base instanceof ItemPredicate)) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1 = (ItemPredicate)base;
        j = i;
        i = ((flag) ? 1 : 0);
_L25:
        flag4 = ((ItemPredicate) (obj1)).isInstancePos(((gnu.lists.AbstractSequence) (obj)), j);
        j = ((Values) (obj)).nextPos(j);
        if (j != 0) goto _L6; else goto _L5
_L5:
        if (i < minOccurs) goto _L8; else goto _L7
_L7:
        boolean flag1 = flag2;
        if (maxOccurs < 0) goto _L10; else goto _L9
_L9:
        if (i > maxOccurs) goto _L8; else goto _L11
_L11:
        flag1 = flag2;
_L10:
        return flag1;
_L8:
        flag1 = false;
        if (true) goto _L10; else goto _L6
_L6:
        flag1 = flag3;
        if (!flag4) goto _L10; else goto _L12
_L12:
        i++;
        continue; /* Loop/switch isn't completed */
_L21:
        j++;
_L4:
        k = ((Values) (obj)).nextPos(k);
        if (k != 0) goto _L14; else goto _L13
_L13:
        if (j < minOccurs) goto _L16; else goto _L15
_L15:
        flag1 = flag4;
        if (maxOccurs < 0) goto _L18; else goto _L17
_L17:
        if (j > maxOccurs) goto _L16; else goto _L19
_L19:
        flag1 = flag4;
_L18:
        return flag1;
_L16:
        flag1 = false;
        if (true) goto _L18; else goto _L14
_L14:
        obj1 = ((Values) (obj)).getPosPrevious(k);
        if (base.isInstance(obj1)) goto _L21; else goto _L20
_L20:
        return false;
_L2:
        flag1 = flag3;
        if (minOccurs > 1) goto _L10; else goto _L22
_L22:
        flag1 = flag3;
        if (maxOccurs == 0) goto _L10; else goto _L23
_L23:
        return base.isInstance(obj);
        if (true) goto _L25; else goto _L24
_L24:
    }

    public int maxOccurs()
    {
        return maxOccurs;
    }

    public int minOccurs()
    {
        return minOccurs;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        base = (Type)objectinput.readObject();
        minOccurs = objectinput.readInt();
        maxOccurs = objectinput.readInt();
    }

    public String toString()
    {
        String s = base.toString();
        StringBuffer stringbuffer;
        boolean flag;
        if (s == null || s.indexOf(' ') >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        stringbuffer = new StringBuffer();
        if (flag)
        {
            stringbuffer.append('(');
        }
        stringbuffer.append(s);
        if (flag)
        {
            stringbuffer.append(')');
        }
        if (minOccurs != 1 || maxOccurs != 1)
        {
            if (minOccurs == 0 && maxOccurs == 1)
            {
                stringbuffer.append('?');
            } else
            if (minOccurs == 1 && maxOccurs == -1)
            {
                stringbuffer.append('+');
            } else
            if (minOccurs == 0 && maxOccurs == -1)
            {
                stringbuffer.append('*');
            } else
            {
                stringbuffer.append('{');
                stringbuffer.append(minOccurs);
                stringbuffer.append(',');
                if (maxOccurs >= 0)
                {
                    stringbuffer.append(maxOccurs);
                } else
                {
                    stringbuffer.append('*');
                }
                stringbuffer.append('}');
            }
        }
        return stringbuffer.toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(base);
        objectoutput.writeInt(minOccurs);
        objectoutput.writeInt(maxOccurs);
    }

    static 
    {
        emptySequenceType = getInstance(SingletonType.instance, 0, 0);
        typeOccurrenceType = ClassType.make("gnu.kawa.reflect.OccurrenceType");
        isInstanceMethod = typeOccurrenceType.getDeclaredMethod("isInstance", 1);
    }
}
