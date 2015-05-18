// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;
import kawa.lang.Syntax;

// Referenced classes of package gnu.kawa.reflect:
//            ClassMemberLocation

public class FieldLocation extends ClassMemberLocation
{

    static final int CONSTANT = 4;
    static final int INDIRECT_LOCATION = 2;
    public static final int KIND_FLAGS_SET = 64;
    public static final int PROCEDURE = 16;
    static final int SETUP_DONE = 1;
    public static final int SYNTAX = 32;
    static final int VALUE_SET = 8;
    Declaration decl;
    private int flags;
    Object value;

    public FieldLocation(Object obj, ClassType classtype, String s)
    {
        super(obj, classtype, s);
    }

    public FieldLocation(Object obj, String s, String s1)
    {
        super(obj, ClassType.make(s), s1);
    }

    public FieldLocation(Object obj, Field field)
    {
        super(obj, field);
        type = (ClassType)Type.make(field.getDeclaringClass());
    }

    private Object getFieldValue()
    {
        super.setup();
        Object obj;
        try
        {
            obj = rfield.get(instance);
        }
        catch (Throwable throwable)
        {
            throw WrappedException.wrapIfNeeded(throwable);
        }
        return obj;
    }

    public static FieldLocation make(Object obj, Declaration declaration)
    {
        gnu.bytecode.Field field = declaration.field;
        obj = new FieldLocation(obj, field.getDeclaringClass(), field.getName());
        ((FieldLocation) (obj)).setDeclaration(declaration);
        return ((FieldLocation) (obj));
    }

    public static FieldLocation make(Object obj, String s, String s1)
    {
        return new FieldLocation(obj, ClassType.make(s), s1);
    }

    public Object get(Object obj)
    {
        Object obj1;
        Object obj2;
        try
        {
            setup();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            return obj;
        }
        if ((flags & 8) == 0) goto _L2; else goto _L1
_L1:
        obj2 = value;
        obj1 = obj2;
        if ((flags & 4) == 0) goto _L4; else goto _L3
_L3:
        return obj2;
_L2:
        obj2 = getFieldValue();
        obj1 = obj2;
        if ((type.getDeclaredField(mname).getModifiers() & 0x10) != 0)
        {
            flags = flags | 8;
            if ((flags & 2) == 0)
            {
                flags = flags | 4;
            }
            value = obj2;
            obj1 = obj2;
        }
_L4:
        obj2 = obj1;
        if ((flags & 2) != 0)
        {
            obj2 = Location.UNBOUND;
            Location location = (Location)obj1;
            obj1 = location.get(obj2);
            if (obj1 == obj2)
            {
                return obj;
            }
            obj2 = obj1;
            if (location.isConstant())
            {
                flags = flags | 4;
                value = obj1;
                return obj1;
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public Declaration getDeclaration()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        if ((flags & 0x40) == 0)
        {
            setKindFlags();
        }
        obj1 = decl;
        Object obj = obj1;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        gnu.bytecode.Field field;
        obj1 = getMemberName();
        obj = getDeclaringClass();
        field = ((ClassType) (obj)).getDeclaredField(((String) (obj1)));
        if (field != null) goto _L4; else goto _L3
_L3:
        obj = null;
_L2:
        this;
        JVM INSTR monitorexit ;
        return ((Declaration) (obj));
_L4:
        obj = ModuleInfo.find(((ClassType) (obj))).getModuleExp().firstDecl();
_L5:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (((Declaration) (obj)).field == null || !((Declaration) (obj)).field.getName().equals(obj1))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        throw new RuntimeException((new StringBuilder()).append("no field found for ").append(this).toString());
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        obj = ((Declaration) (obj)).nextDecl();
          goto _L5
        decl = ((Declaration) (obj));
          goto _L2
    }

    public Type getFType()
    {
        return type.getDeclaredField(mname).getType();
    }

    public gnu.bytecode.Field getField()
    {
        return type.getDeclaredField(mname);
    }

    public boolean isBound()
    {
        if ((flags & 0x40) == 0)
        {
            setKindFlags();
        }
        if ((flags & 4) != 0 || (flags & 2) == 0)
        {
            return true;
        }
        Object obj;
        if ((flags & 8) != 0)
        {
            obj = value;
        } else
        {
            try
            {
                setup();
            }
            catch (Throwable throwable)
            {
                return false;
            }
            obj = getFieldValue();
            flags = flags | 8;
            value = obj;
        }
        return ((Location)obj).isBound();
    }

    public boolean isConstant()
    {
        boolean flag = false;
        if ((flags & 0x40) == 0)
        {
            setKindFlags();
        }
        if ((flags & 4) != 0)
        {
            flag = true;
        } else
        if (isIndirectLocation())
        {
            Object obj;
            if ((flags & 8) != 0)
            {
                obj = value;
            } else
            {
                try
                {
                    setup();
                }
                catch (Throwable throwable)
                {
                    return false;
                }
                obj = getFieldValue();
                flags = flags | 8;
                value = obj;
            }
            return ((Location)obj).isConstant();
        }
        return flag;
    }

    public boolean isIndirectLocation()
    {
        return (flags & 2) != 0;
    }

    public boolean isProcedureOrSyntax()
    {
        if ((flags & 0x40) == 0)
        {
            setKindFlags();
        }
        return (flags & 0x30) != 0;
    }

    public void set(Object obj)
    {
        setup();
        if ((flags & 2) == 0)
        {
            try
            {
                rfield.set(instance, obj);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw WrappedException.wrapIfNeeded(((Throwable) (obj)));
            }
        }
        Object obj1;
        if ((flags & 8) != 0)
        {
            obj1 = value;
        } else
        {
            flags = flags | 8;
            obj1 = getFieldValue();
            value = obj1;
        }
        ((Location)obj1).set(obj);
    }

    public void setDeclaration(Declaration declaration)
    {
        decl = declaration;
    }

    void setKindFlags()
    {
        Object obj;
        int i;
        obj = getMemberName();
        obj = getDeclaringClass().getDeclaredField(((String) (obj)));
        i = ((gnu.bytecode.Field) (obj)).getModifiers();
        obj = ((gnu.bytecode.Field) (obj)).getType();
        if (((Type) (obj)).isSubtype(Compilation.typeLocation))
        {
            flags = flags | 2;
        }
        if ((i & 0x10) == 0) goto _L2; else goto _L1
_L1:
        if ((flags & 2) != 0) goto _L4; else goto _L3
_L3:
        flags = flags | 4;
        if (((Type) (obj)).isSubtype(Compilation.typeProcedure))
        {
            flags = flags | 0x10;
        }
        if ((obj instanceof ClassType) && ((ClassType)obj).isSubclass("kawa.lang.Syntax"))
        {
            flags = flags | 0x20;
        }
_L2:
        flags = flags | 0x40;
        return;
_L4:
        Object obj1 = (Location)getFieldValue();
        if (obj1 instanceof FieldLocation)
        {
            obj1 = (FieldLocation)obj1;
            if ((((FieldLocation) (obj1)).flags & 0x40) == 0)
            {
                ((FieldLocation) (obj1)).setKindFlags();
            }
            flags = flags | ((FieldLocation) (obj1)).flags & 0x34;
            if ((((FieldLocation) (obj1)).flags & 4) != 0)
            {
                if ((((FieldLocation) (obj1)).flags & 8) != 0)
                {
                    value = ((FieldLocation) (obj1)).value;
                    flags = flags | 8;
                }
            } else
            {
                value = obj1;
                flags = flags | 8;
            }
        } else
        if (((Location) (obj1)).isConstant())
        {
            obj1 = ((Location) (obj1)).get(null);
            if (obj1 instanceof Procedure)
            {
                flags = flags | 0x10;
            }
            if (obj1 instanceof Syntax)
            {
                flags = flags | 0x20;
            }
            flags = flags | 0xc;
            value = obj1;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void setProcedure()
    {
        flags = flags | 0x54;
    }

    public void setRestore(Object obj)
    {
        if ((flags & 2) == 0)
        {
            super.setRestore(obj);
            return;
        } else
        {
            ((Location)value).setRestore(obj);
            return;
        }
    }

    public void setSyntax()
    {
        flags = flags | 0x64;
    }

    public Object setWithSave(Object obj)
    {
        if ((flags & 0x40) == 0)
        {
            setKindFlags();
        }
        if ((flags & 2) == 0)
        {
            return super.setWithSave(obj);
        }
        Object obj1;
        if ((flags & 8) != 0)
        {
            obj1 = value;
        } else
        {
            flags = flags | 8;
            obj1 = getFieldValue();
            value = obj1;
        }
        return ((Location)obj1).setWithSave(obj);
    }

    void setup()
    {
        this;
        JVM INSTR monitorenter ;
        if ((flags & 1) == 0)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        super.setup();
        if ((flags & 0x40) == 0)
        {
            setKindFlags();
        }
        flags = flags | 1;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("FieldLocation[");
        if (instance != null)
        {
            stringbuffer.append(instance);
            stringbuffer.append(' ');
        }
        String s;
        if (type == null)
        {
            s = "(null)";
        } else
        {
            s = type.getName();
        }
        stringbuffer.append(s);
        stringbuffer.append('.');
        stringbuffer.append(mname);
        stringbuffer.append(']');
        return stringbuffer.toString();
    }
}
