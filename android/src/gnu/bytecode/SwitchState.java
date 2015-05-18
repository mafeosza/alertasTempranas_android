// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            Label, CodeAttr, ClassType, Type, 
//            TryState

public class SwitchState
{

    Label after_label;
    Label cases_label;
    Label defaultLabel;
    Label labels[];
    int maxValue;
    int minValue;
    int numCases;
    TryState outerTry;
    Label switch_label;
    int values[];

    public SwitchState(CodeAttr codeattr)
    {
        switch_label = new Label(codeattr);
        cases_label = new Label(codeattr);
        after_label = new Label(codeattr);
        outerTry = codeattr.try_stack;
        numCases = 0;
    }

    public boolean addCase(int i, CodeAttr codeattr)
    {
        Label label = new Label(codeattr);
        label.setTypes(cases_label);
        label.define(codeattr);
        return insertCase(i, label, codeattr);
    }

    public boolean addCaseGoto(int i, CodeAttr codeattr, Label label)
    {
        boolean flag = insertCase(i, label, codeattr);
        label.setTypes(cases_label);
        codeattr.setUnreachable();
        return flag;
    }

    public void addDefault(CodeAttr codeattr)
    {
        Label label = new Label(codeattr);
        label.setTypes(cases_label);
        label.define(codeattr);
        if (defaultLabel != null)
        {
            throw new Error();
        } else
        {
            defaultLabel = label;
            return;
        }
    }

    public void exitSwitch(CodeAttr codeattr)
    {
        if (outerTry != codeattr.try_stack)
        {
            throw new Error("exitSwitch cannot exit through a try");
        } else
        {
            codeattr.emitGoto(after_label);
            return;
        }
    }

    public void finish(CodeAttr codeattr)
    {
        if (defaultLabel == null)
        {
            defaultLabel = new Label(codeattr);
            defaultLabel.define(codeattr);
            ClassType classtype = ClassType.make("java.lang.RuntimeException");
            codeattr.emitNew(classtype);
            codeattr.emitDup(classtype);
            codeattr.emitPushString("bad case value!");
            ClassType classtype1 = Type.string_type;
            PrimType primtype = Type.voidType;
            codeattr.emitInvokeSpecial(classtype.addMethod("<init>", 1, new Type[] {
                classtype1
            }, primtype));
            codeattr.emitThrow();
        }
        codeattr.fixupChain(switch_label, after_label);
        if (numCases > 1) goto _L2; else goto _L1
_L1:
        codeattr.pushType(Type.intType);
        if (numCases == 1)
        {
            if (minValue == 0)
            {
                codeattr.emitIfIntEqZero();
            } else
            {
                codeattr.emitPushInt(minValue);
                codeattr.emitIfEq();
            }
            codeattr.emitGoto(labels[0]);
            codeattr.emitElse();
            codeattr.emitGoto(defaultLabel);
            codeattr.emitFi();
        } else
        {
            codeattr.emitPop(1);
            codeattr.emitGoto(defaultLabel);
        }
_L4:
        codeattr.fixupChain(after_label, cases_label);
        return;
_L2:
        if (numCases * 2 < maxValue - minValue)
        {
            break; /* Loop/switch isn't completed */
        }
        codeattr.reserve(((maxValue - minValue) + 1) * 4 + 13);
        codeattr.fixupAdd(2, null);
        codeattr.put1(170);
        codeattr.fixupAdd(3, defaultLabel);
        codeattr.PC = codeattr.PC + 4;
        codeattr.put4(minValue);
        codeattr.put4(maxValue);
        int k = 0;
        int i = minValue;
        while (i <= maxValue) 
        {
            Label label;
            if (values[k] == i)
            {
                label = labels[k];
                k++;
            } else
            {
                label = defaultLabel;
            }
            codeattr.fixupAdd(3, label);
            codeattr.PC = codeattr.PC + 4;
            i++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        codeattr.reserve(numCases * 8 + 9);
        codeattr.fixupAdd(2, null);
        codeattr.put1(171);
        codeattr.fixupAdd(3, defaultLabel);
        codeattr.PC = codeattr.PC + 4;
        codeattr.put4(numCases);
        int j = 0;
        while (j < numCases) 
        {
            codeattr.put4(values[j]);
            codeattr.fixupAdd(3, labels[j]);
            codeattr.PC = codeattr.PC + 4;
            j++;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public int getMaxValue()
    {
        return maxValue;
    }

    public int getNumCases()
    {
        return numCases;
    }

    public boolean insertCase(int i, Label label, CodeAttr codeattr)
    {
        Label alabel[];
        if (values == null)
        {
            values = new int[10];
            labels = new Label[10];
            numCases = 1;
            maxValue = i;
            minValue = i;
            values[0] = i;
            labels[0] = label;
            return true;
        }
        codeattr = values;
        alabel = labels;
        if (numCases >= values.length)
        {
            values = new int[numCases * 2];
            labels = new Label[numCases * 2];
        }
        if (i >= minValue) goto _L2; else goto _L1
_L1:
        int l;
        l = 0;
        minValue = i;
_L4:
        int j = numCases - l;
        System.arraycopy(codeattr, l, values, l + 1, j);
        System.arraycopy(codeattr, 0, values, 0, l);
        values[l] = i;
        System.arraycopy(alabel, l, labels, l + 1, j);
        System.arraycopy(alabel, 0, labels, 0, l);
        labels[l] = label;
        numCases = numCases + 1;
        return true;
_L2:
        if (i <= maxValue)
        {
            break; /* Loop/switch isn't completed */
        }
        l = numCases;
        maxValue = i;
        if (true) goto _L4; else goto _L3
_L3:
        int i1 = 0;
        l = numCases - 1;
        int k = 0;
        while (i1 <= l) 
        {
            k = i1 + l >>> 1;
            if (codeattr[k] >= i)
            {
                l = k - 1;
            } else
            {
                k++;
                i1 = k;
            }
        }
        l = k;
        if (i == codeattr[k])
        {
            return false;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void switchValuePushed(CodeAttr codeattr)
    {
        codeattr.popType();
        cases_label.setTypes(codeattr);
        codeattr.fixupChain(cases_label, switch_label);
    }
}
