// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Label;
import gnu.bytecode.Type;

// Referenced classes of package gnu.expr:
//            Target, Compilation, Language

public class ConditionalTarget extends Target
{

    public Label ifFalse;
    public Label ifTrue;
    Language language;
    public boolean trueBranchComesFirst;

    public ConditionalTarget(Label label, Label label1, Language language1)
    {
        trueBranchComesFirst = true;
        ifTrue = label;
        ifFalse = label1;
        language = language1;
    }

    public void compileFromStack(Compilation compilation, Type type)
    {
        CodeAttr codeattr = compilation.getCode();
        type.getSignature().charAt(0);
        JVM INSTR lookupswitch 5: default 64
    //                   68: 114
    //                   70: 122
    //                   74: 88
    //                   76: 147
    //                   91: 147;
           goto _L1 _L2 _L3 _L4 _L5 _L5
_L5:
        break MISSING_BLOCK_LABEL_147;
_L1:
        if (trueBranchComesFirst)
        {
            codeattr.emitGotoIfIntEqZero(ifFalse);
            codeattr.emitGoto(ifTrue);
            return;
        } else
        {
            codeattr.emitGotoIfIntNeZero(ifTrue);
            codeattr.emitGoto(ifFalse);
            return;
        }
_L4:
        codeattr.emitPushLong(0L);
_L6:
        if (trueBranchComesFirst)
        {
            codeattr.emitGotoIfEq(ifFalse);
        } else
        {
            codeattr.emitGotoIfNE(ifTrue);
        }
        emitGotoFirstBranch(codeattr);
        return;
_L2:
        codeattr.emitPushDouble(0.0D);
          goto _L6
_L3:
        codeattr.emitPushFloat(0.0F);
          goto _L6
        if (language == null)
        {
            type = Boolean.FALSE;
        } else
        {
            type = ((Type) (language.booleanObject(false)));
        }
        compilation.compileConstant(type);
          goto _L6
    }

    public final void emitGotoFirstBranch(CodeAttr codeattr)
    {
        Label label;
        if (trueBranchComesFirst)
        {
            label = ifTrue;
        } else
        {
            label = ifFalse;
        }
        codeattr.emitGoto(label);
    }

    public Type getType()
    {
        return Type.booleanType;
    }
}
