// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package kawa.lang:
//            SyntaxTemplate, SyntaxPattern, SyntaxForm, Translator

public class SyntaxRule extends SyntaxTemplate
    implements Externalizable
{

    SyntaxPattern pattern;

    public SyntaxRule()
    {
    }

    public SyntaxRule(SyntaxPattern syntaxpattern, Object obj, SyntaxForm syntaxform, Translator translator)
    {
        super(obj, syntaxform, translator);
        pattern = syntaxpattern;
    }

    public SyntaxRule(SyntaxPattern syntaxpattern, String s, String s1, Object aobj[], int i)
    {
        super(s, s1, aobj, i);
        pattern = syntaxpattern;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        pattern = (SyntaxPattern)objectinput.readObject();
        super.readExternal(objectinput);
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(pattern);
        super.writeExternal(objectoutput);
    }
}
