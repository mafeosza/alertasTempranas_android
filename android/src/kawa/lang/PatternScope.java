// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Declaration;
import gnu.expr.LetExp;
import java.util.Vector;

// Referenced classes of package kawa.lang:
//            Translator

public class PatternScope extends LetExp
{

    public Declaration matchArray;
    public StringBuffer patternNesting;
    public Vector pattern_names;
    PatternScope previousSyntax;

    public PatternScope()
    {
        super(null);
    }

    public static void pop(Translator translator)
    {
        translator.patternScope = translator.patternScope.previousSyntax;
    }

    public static PatternScope push(Translator translator)
    {
        PatternScope patternscope = new PatternScope();
        PatternScope patternscope1 = translator.patternScope;
        patternscope.previousSyntax = patternscope1;
        translator.patternScope = patternscope;
        if (patternscope1 == null)
        {
            patternscope.pattern_names = new Vector();
            patternscope.patternNesting = new StringBuffer();
        } else
        {
            patternscope.pattern_names = (Vector)patternscope1.pattern_names.clone();
            patternscope.patternNesting = new StringBuffer(patternscope1.patternNesting.toString());
        }
        patternscope.outer = translator.currentScope();
        return patternscope;
    }
}
