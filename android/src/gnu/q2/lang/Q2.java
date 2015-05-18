// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.q2.lang;

import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.lispexpr.ReadTable;
import gnu.lists.Consumer;
import gnu.lists.FString;
import gnu.mapping.InPort;
import gnu.mapping.Procedure;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.xml.XMLPrinter;
import java.io.Writer;
import kawa.standard.Scheme;

// Referenced classes of package gnu.q2.lang:
//            Q2ReaderParens, Q2Read, Prompter, Q2Apply

public class Q2 extends Scheme
{

    static final Object emptyForm = new FString();
    static Q2 instance;

    public Q2()
    {
        instance = this;
        ModuleBody.setMainPrintValues(true);
    }

    public static int compareIndentation(int i, int j)
    {
        int k = i >>> 16;
        int l = i >>> 16;
        i &= 0xff;
        j &= 0xff;
        if (k == l)
        {
            return i - j;
        }
        if (k < l && i <= j || k > l && i >= j)
        {
            return (k - l) * 8;
        } else
        {
            return 0x80000000;
        }
    }

    public static Q2 getQ2Instance()
    {
        if (instance == null)
        {
            new Q2();
        }
        return instance;
    }

    public static void registerEnvironment()
    {
        Language.setDefaults(new Q2());
    }

    public ReadTable createReadTable()
    {
        ReadTable readtable = ReadTable.createInitial();
        readtable.set(40, new Q2ReaderParens());
        readtable.setFinalColonIsKeyword(true);
        return readtable;
    }

    public Lexer getLexer(InPort inport, SourceMessages sourcemessages)
    {
        Compilation.defaultCallConvention = 2;
        return new Q2Read(inport, sourcemessages);
    }

    public Consumer getOutputConsumer(Writer writer)
    {
        return new XMLPrinter(writer, false);
    }

    public Procedure getPrompter()
    {
        return new Prompter();
    }

    public Expression makeApply(Expression expression, Expression aexpression[])
    {
        Expression aexpression1[] = new Expression[aexpression.length + 1];
        aexpression1[0] = expression;
        System.arraycopy(aexpression, 0, aexpression1, 1, aexpression.length);
        return new ApplyExp(Q2Apply.q2Apply, aexpression1);
    }

    public Expression makeBody(Expression aexpression[])
    {
        return new ApplyExp(AppendValues.appendValues, aexpression);
    }

}
