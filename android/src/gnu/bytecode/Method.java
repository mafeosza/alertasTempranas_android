// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Stack;

// Referenced classes of package gnu.bytecode:
//            AttrContainer, Member, ClassType, Type, 
//            Variable, ConstantPool, CpoolUtf8, Attribute, 
//            CodeAttr, ExceptionsAttr, Scope

public class Method
    implements AttrContainer, Member
{

    int access_flags;
    Type arg_types[];
    Attribute attributes;
    ClassType classfile;
    CodeAttr code;
    ExceptionsAttr exceptions;
    private String name;
    int name_index;
    Method next;
    Type return_type;
    String signature;
    int signature_index;

    private Method()
    {
    }

    Method(ClassType classtype, int i)
    {
        if (classtype.last_method == null)
        {
            classtype.methods = this;
        } else
        {
            classtype.last_method.next = this;
        }
        classtype.last_method = this;
        classtype.methods_count = classtype.methods_count + 1;
        access_flags = i;
        classfile = classtype;
    }

    public Method(Method method, ClassType classtype)
    {
        arg_types = method.arg_types;
        return_type = method.return_type;
        name = method.name;
        access_flags = method.access_flags;
        classfile = classtype;
    }

    public static Method makeCloneMethod(Type type)
    {
        Method method = new Method();
        method.name = "clone";
        method.access_flags = 1;
        method.arg_types = Type.typeArray0;
        method.return_type = type;
        method.classfile = Type.pointer_type;
        return method;
    }

    public static String makeSignature(Type atype[], Type type)
    {
        StringBuilder stringbuilder = new StringBuilder(100);
        int j = atype.length;
        stringbuilder.append('(');
        for (int i = 0; i < j; i++)
        {
            stringbuilder.append(atype[i].getSignature());
        }

        stringbuilder.append(')');
        stringbuilder.append(type.getSignature());
        return stringbuilder.toString();
    }

    public void allocate_local(Variable variable)
    {
        variable.allocateLocal(code);
    }

    void assignConstants()
    {
        ConstantPool constantpool = getConstants();
        if (name_index == 0 && name != null)
        {
            name_index = constantpool.addUtf8(name).index;
        }
        if (signature_index == 0)
        {
            signature_index = constantpool.addUtf8(getSignature()).index;
        }
        Attribute.assignConstants(this, classfile);
    }

    public void cleanupAfterCompilation()
    {
        attributes = null;
        exceptions = null;
        code = null;
    }

    public void compile_checkcast(Type type)
    {
        code.emitCheckcast(type);
    }

    public void compile_push_this()
    {
        code.emitPushThis();
    }

    public void compile_push_value(Variable variable)
    {
        code.emitLoad(variable);
    }

    public void compile_store_value(Variable variable)
    {
        code.emitStore(variable);
    }

    public final Attribute getAttributes()
    {
        return attributes;
    }

    public final CodeAttr getCode()
    {
        return code;
    }

    public final ConstantPool getConstants()
    {
        return classfile.constants;
    }

    public ClassType getDeclaringClass()
    {
        return classfile;
    }

    public final ExceptionsAttr getExceptionAttr()
    {
        return exceptions;
    }

    public final ClassType[] getExceptions()
    {
        if (exceptions == null)
        {
            return null;
        } else
        {
            return exceptions.getExceptions();
        }
    }

    public int getModifiers()
    {
        return access_flags;
    }

    public final String getName()
    {
        return name;
    }

    public final Method getNext()
    {
        return next;
    }

    public final Type[] getParameterTypes()
    {
        return arg_types;
    }

    public final Type getReturnType()
    {
        return return_type;
    }

    public String getSignature()
    {
        if (signature == null)
        {
            signature = makeSignature(arg_types, return_type);
        }
        return signature;
    }

    public final boolean getStaticFlag()
    {
        return (access_flags & 8) != 0;
    }

    public void initCode()
    {
        if (classfile.constants == null)
        {
            classfile.constants = new ConstantPool();
        }
        prepareCode(0);
        code.sourceDbgExt = classfile.sourceDbgExt;
        code.noteParamTypes();
        code.pushScope();
    }

    public void init_param_slots()
    {
        startCode();
    }

    void instruction_start_hook(int i)
    {
        prepareCode(i);
    }

    public final boolean isAbstract()
    {
        return (access_flags & 0x400) != 0;
    }

    void kill_local(Variable variable)
    {
        variable.freeLocal(code);
    }

    public void listParameters(StringBuffer stringbuffer)
    {
        int j = arg_types.length;
        stringbuffer.append('(');
        for (int i = 0; i < j; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(',');
            }
            stringbuffer.append(arg_types[i].getName());
        }

        stringbuffer.append(')');
    }

    public void maybe_compile_checkcast(Type type)
    {
        if (type != code.topType())
        {
            code.emitCheckcast(type);
        }
    }

    public Scope popScope()
    {
        return code.popScope();
    }

    final Type pop_stack_type()
    {
        return code.popType();
    }

    void prepareCode(int i)
    {
        if (code == null)
        {
            code = new CodeAttr(this);
        }
        code.reserve(i);
    }

    public Scope pushScope()
    {
        prepareCode(0);
        return code.pushScope();
    }

    final void push_stack_type(Type type)
    {
        code.pushType(type);
    }

    public void push_var(Variable variable)
    {
        code.emitLoad(variable);
    }

    public final boolean reachableHere()
    {
        return code.reachableHere();
    }

    public final void setAttributes(Attribute attribute)
    {
        attributes = attribute;
    }

    public void setExceptions(ClassType aclasstype[])
    {
        if (exceptions == null)
        {
            exceptions = new ExceptionsAttr(this);
        }
        exceptions.setExceptions(aclasstype);
    }

    public void setExceptions(short aword0[])
    {
        if (exceptions == null)
        {
            exceptions = new ExceptionsAttr(this);
        }
        exceptions.setExceptions(aword0, classfile);
    }

    public void setModifiers(int i)
    {
        access_flags = i;
    }

    public final void setName(int i)
    {
        if (i <= 0)
        {
            name = null;
        } else
        {
            name = ((CpoolUtf8)getConstants().getForced(i, 1)).string;
        }
        name_index = i;
    }

    public final void setName(String s)
    {
        name = s;
    }

    public void setSignature(int i)
    {
        CpoolUtf8 cpoolutf8 = (CpoolUtf8)getConstants().getForced(i, 1);
        signature_index = i;
        setSignature(cpoolutf8.string);
    }

    public void setSignature(String s)
    {
        int k = s.length();
        if (k < 3 || s.charAt(0) != '(')
        {
            throw new ClassFormatError("bad method signature");
        }
        int i = 1;
        Stack stack = new Stack();
        do
        {
            int j = Type.signatureLength(s, i);
            if (j < 0)
            {
                if (i < k && s.charAt(i) == ')')
                {
                    arg_types = new Type[stack.size()];
                    j = stack.size();
                    do
                    {
                        j--;
                        if (j >= 0)
                        {
                            arg_types[j] = (Type)stack.pop();
                        } else
                        {
                            return_type = Type.signatureToType(s, i + 1, k - i - 1);
                            return;
                        }
                    } while (true);
                } else
                {
                    throw new ClassFormatError("bad method signature");
                }
            }
            stack.push(Type.signatureToType(s, i, j));
            i += j;
        } while (true);
    }

    public final void setStaticFlag(boolean flag)
    {
        if (flag)
        {
            access_flags = access_flags | 8;
            return;
        } else
        {
            access_flags = access_flags ^ -9;
            return;
        }
    }

    public CodeAttr startCode()
    {
        initCode();
        code.addParamLocals();
        return code;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(100);
        stringbuffer.append(getDeclaringClass().getName());
        stringbuffer.append('.');
        stringbuffer.append(name);
        if (arg_types != null)
        {
            listParameters(stringbuffer);
            stringbuffer.append(return_type.getName());
        }
        return stringbuffer.toString();
    }

    void write(DataOutputStream dataoutputstream, ClassType classtype)
        throws IOException
    {
        dataoutputstream.writeShort(access_flags);
        dataoutputstream.writeShort(name_index);
        dataoutputstream.writeShort(signature_index);
        Attribute.writeAll(this, dataoutputstream);
    }
}
