// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            Label, CodeAttr, Type

public class IfState
{

    boolean doing_else;
    Label end_label;
    IfState previous;
    int stack_growth;
    int start_stack_size;
    Type then_stacked_types[];

    public IfState(CodeAttr codeattr)
    {
        this(codeattr, new Label(codeattr));
    }

    public IfState(CodeAttr codeattr, Label label)
    {
        previous = codeattr.if_stack;
        codeattr.if_stack = this;
        end_label = label;
        start_stack_size = codeattr.SP;
    }
}
