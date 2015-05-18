// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package gnu.bytecode:
//            CodeAttr, LocalVarsAttr, PrimType, Type

public class Label
{

    int first_fixup;
    Type localTypes[];
    boolean needsStackMapEntry;
    int position;
    Type stackTypes[];
    private Object typeChangeListeners[];

    public Label()
    {
        this(-1);
    }

    public Label(int i)
    {
        position = i;
    }

    public Label(CodeAttr codeattr)
    {
        this(-1);
    }

    private void mergeLocalType(int i, Type type)
    {
        Type type1 = localTypes[i];
        type = mergeTypes(type1, type);
        localTypes[i] = type;
        if (type != type1)
        {
            notifyTypeChangeListeners(i, type);
        }
    }

    private void notifyTypeChangeListeners(int i, Type type)
    {
        Object aobj[] = typeChangeListeners;
        Object obj;
        if (aobj != null && aobj.length > i)
        {
            if ((obj = aobj[i]) != null)
            {
                if (obj instanceof Label)
                {
                    ((Label)obj).mergeLocalType(i, type);
                } else
                {
                    obj = ((ArrayList)obj).iterator();
                    while (((Iterator) (obj)).hasNext()) 
                    {
                        ((Label)((Iterator) (obj)).next()).mergeLocalType(i, type);
                    }
                }
                if (type == null)
                {
                    aobj[i] = null;
                    return;
                }
            }
        }
    }

    void addTypeChangeListener(int i, Label label)
    {
        Object aobj1[] = typeChangeListeners;
        if (aobj1 != null) goto _L2; else goto _L1
_L1:
        Object aobj[];
        aobj = new Object[i + 10];
        typeChangeListeners = aobj;
_L4:
        Object obj;
        obj = aobj[i];
        if (obj == null)
        {
            aobj[i] = label;
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        aobj = aobj1;
        if (aobj1.length <= i)
        {
            aobj = new Object[i + 10];
            System.arraycopy(((Object) (typeChangeListeners)), 0, ((Object) (aobj)), 0, typeChangeListeners.length);
            typeChangeListeners = aobj;
        }
        if (true) goto _L4; else goto _L3
_L3:
        ArrayList arraylist;
        if (obj instanceof Label)
        {
            ArrayList arraylist1 = new ArrayList();
            arraylist1.add((Label)obj);
            aobj[i] = arraylist1;
            arraylist = arraylist1;
        } else
        {
            arraylist = (ArrayList)obj;
        }
        arraylist.add(label);
        return;
    }

    void addTypeChangeListeners(CodeAttr codeattr)
    {
        if (codeattr.local_types != null && codeattr.previousLabel != null)
        {
            int j = codeattr.local_types.length;
            for (int i = 0; i < j; i++)
            {
                if (codeattr.local_types[i] != null && (codeattr.varsSetInCurrentBlock == null || codeattr.varsSetInCurrentBlock.length <= i || !codeattr.varsSetInCurrentBlock[i]))
                {
                    codeattr.previousLabel.addTypeChangeListener(i, this);
                }
            }

        }
    }

    public void define(CodeAttr codeattr)
    {
        if (!codeattr.reachableHere()) goto _L2; else goto _L1
_L1:
        setTypes(codeattr);
_L4:
        codeattr.previousLabel = this;
        codeattr.varsSetInCurrentBlock = null;
        defineRaw(codeattr);
        if (localTypes != null)
        {
            codeattr.setTypes(this);
        }
        codeattr.setReachable(true);
        return;
_L2:
        if (localTypes == null) goto _L4; else goto _L3
_L3:
        int i = localTypes.length;
_L7:
        int j = i - 1;
        if (j < 0) goto _L4; else goto _L5
_L5:
        i = j;
        if (localTypes[j] == null) goto _L7; else goto _L6
_L6:
        if (codeattr.locals.used == null) goto _L9; else goto _L8
_L8:
        i = j;
        if (codeattr.locals.used[j] != null) goto _L7; else goto _L9
_L9:
        localTypes[j] = null;
        i = j;
          goto _L7
    }

    public void defineRaw(CodeAttr codeattr)
    {
        if (position >= 0)
        {
            throw new Error("label definition more than once");
        }
        position = codeattr.PC;
        first_fixup = codeattr.fixup_count;
        if (first_fixup >= 0)
        {
            codeattr.fixupAdd(1, this);
        }
    }

    public final boolean defined()
    {
        return position >= 0;
    }

    Type mergeTypes(Type type, Type type1)
    {
        if ((type instanceof PrimType) != (type1 instanceof PrimType))
        {
            return null;
        } else
        {
            return Type.lowestCommonSuperType(type, type1);
        }
    }

    public void setTypes(CodeAttr codeattr)
    {
        addTypeChangeListeners(codeattr);
        if (stackTypes != null && codeattr.SP != stackTypes.length)
        {
            throw new InternalError();
        }
        Type atype[] = codeattr.local_types;
        int i;
        if (codeattr.local_types == null)
        {
            i = 0;
        } else
        {
            i = codeattr.local_types.length;
        }
        setTypes(atype, i, codeattr.stack_types, codeattr.SP);
    }

    public void setTypes(Label label)
    {
        setTypes(label.localTypes, label.localTypes.length, label.stackTypes, label.stackTypes.length);
    }

    void setTypes(Type atype[], int i, Type atype1[], int j)
    {
_L5:
        if (i > 0 && atype[i - 1] == null) goto _L2; else goto _L1
_L1:
        if (stackTypes != null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        if (j == 0)
        {
            stackTypes = Type.typeArray0;
        } else
        {
            stackTypes = new Type[j];
            System.arraycopy(atype1, 0, stackTypes, 0, j);
        }
        if (i != 0) goto _L4; else goto _L3
_L3:
        localTypes = Type.typeArray0;
_L6:
        return;
_L2:
        i--;
          goto _L5
_L4:
        localTypes = new Type[i];
        System.arraycopy(atype, 0, localTypes, 0, i);
        return;
        if (j != stackTypes.length)
        {
            throw new InternalError("inconsistent stack length");
        }
        for (int k = 0; k < j; k++)
        {
            stackTypes[k] = mergeTypes(stackTypes[k], atype1[k]);
        }

        int l;
        if (i < localTypes.length)
        {
            j = i;
        } else
        {
            j = localTypes.length;
        }
        for (l = 0; l < j; l++)
        {
            mergeLocalType(l, atype[l]);
        }

        while (i < localTypes.length) 
        {
            localTypes[i] = null;
            i++;
        }
          goto _L6
    }
}
