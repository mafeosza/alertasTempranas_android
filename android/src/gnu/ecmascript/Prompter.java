// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.ecmascript;

import gnu.mapping.InPort;
import gnu.mapping.Procedure1;

class Prompter extends Procedure1
{

    Prompter()
    {
    }

    public Object apply1(Object obj)
    {
        return prompt((InPort)obj);
    }

    String prompt(InPort inport)
    {
        return (new StringBuilder()).append("(EcmaScript:").append(inport.getLineNumber() + 1).append(") ").toString();
    }
}
