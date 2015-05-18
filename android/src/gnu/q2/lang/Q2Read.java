// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.q2.lang;

import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.LispReader;
import gnu.kawa.xml.MakeAttribute;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.Sequence;
import gnu.mapping.InPort;
import gnu.text.LineBufferedReader;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import kawa.standard.begin;

// Referenced classes of package gnu.q2.lang:
//            Q2

public class Q2Read extends LispReader
{

    int curIndentation;
    int expressionStartColumn;
    String expressionStartFile;
    int expressionStartLine;

    public Q2Read(InPort inport)
    {
        super(inport);
        init();
    }

    public Q2Read(InPort inport, SourceMessages sourcemessages)
    {
        super(inport, sourcemessages);
        init();
    }

    public static Object readObject(InPort inport)
        throws IOException, SyntaxException
    {
        return (new Q2Read(inport)).readObject();
    }

    void init()
    {
        ((InPort)port).readState = ' ';
    }

    public Object readCommand()
        throws IOException, SyntaxException
    {
        int i = skipIndentation();
        Object obj;
        if (i < 0)
        {
            obj = Sequence.eofValue;
        } else
        {
            curIndentation = i;
            Object obj1 = readIndentCommand();
            obj = obj1;
            if (!interactive)
            {
                port.reset();
                return obj1;
            }
        }
        return obj;
    }

    public Object readCommand(boolean flag)
        throws IOException, SyntaxException
    {
        Object obj;
        PairWithPosition pairwithposition;
        Object obj1;
        int j;
        int i1;
        port.getLineNumber();
        i1 = port.getColumnNumber();
        j = i1;
        obj1 = LList.Empty;
        pairwithposition = null;
        obj = null;
_L23:
        int k = read();
        if (k >= 0) goto _L2; else goto _L1
_L1:
        Object obj3 = obj;
_L8:
        Object obj2 = obj1;
        if (flag) goto _L4; else goto _L3
_L3:
        if (obj1 != obj3) goto _L6; else goto _L5
_L5:
        obj2 = ((PairWithPosition) (obj3)).getCar();
_L4:
        return obj2;
_L2:
        if (k == 32 || k == 9)
        {
            continue; /* Loop/switch isn't completed */
        }
        unread();
        obj3 = obj;
        if (k == 41) goto _L8; else goto _L7
_L7:
        int i;
        int j1;
        j1 = port.getLineNumber();
        i = port.getColumnNumber();
_L11:
        if (k != 13 && k != 10)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj1;
        if (singleLine()) goto _L4; else goto _L9
_L9:
        read();
        skipIndentation();
        int l = port.getColumnNumber();
        k = peek();
        i = l;
        if (l > i1)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = l;
        break; /* Loop/switch isn't completed */
        if (true) goto _L11; else goto _L10
_L10:
        if (i > i1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = obj;
        if (obj != null) goto _L8; else goto _L12
_L12:
        if (i != j || obj == null) goto _L14; else goto _L13
_L13:
        obj2 = readCommand();
_L17:
        obj3 = obj;
        if (obj2 != Sequence.eofValue)
        {
            j = i;
            obj3 = port.getName();
            obj2 = PairWithPosition.make(obj2, LList.Empty, ((String) (obj3)), j1 + 1, i + 1);
            PairWithPosition pairwithposition1;
            Object obj4;
            if (obj == null)
            {
                pairwithposition = ((PairWithPosition) (obj2));
                obj1 = obj2;
            } else
            {
                if (((PairWithPosition) (obj)).getCar() instanceof Keyword)
                {
                    obj3 = new QuoteExp(((Keyword)((PairWithPosition) (obj)).getCar()).getName());
                    ((PairWithPosition) (obj)).setCar(new PairWithPosition(((gnu.text.SourceLocator) (obj)), MakeAttribute.makeAttribute, new PairWithPosition(((gnu.text.SourceLocator) (obj)), obj3, obj2)));
                    continue; /* Loop/switch isn't completed */
                }
                ((PairWithPosition) (obj)).setCdrBackdoor(obj2);
            }
            obj = obj2;
            continue; /* Loop/switch isn't completed */
        }
          goto _L8
_L14:
        if (i >= j || obj == null)
        {
            break MISSING_BLOCK_LABEL_434;
        }
        obj2 = pairwithposition;
_L20:
        obj3 = ((PairWithPosition) (obj2)).getCdr();
        if (obj3 != LList.Empty) goto _L16; else goto _L15
_L15:
        obj3 = obj;
_L19:
        obj2 = readCommand();
        obj = obj3;
          goto _L17
_L16:
        pairwithposition1 = (PairWithPosition)obj3;
        j = pairwithposition1.getColumnNumber() - 1;
        if (j < i)
        {
            break MISSING_BLOCK_LABEL_427;
        }
        if (j > i)
        {
            error('e', "some tokens on previous line indented more than current line");
        }
        obj4 = pairwithposition1.getCdr();
        obj3 = obj;
        if (obj4 == LList.Empty) goto _L19; else goto _L18
_L18:
label0:
        {
            if (((PairWithPosition)obj4).getColumnNumber() - 1 != i)
            {
                break label0;
            }
            obj2 = (PairWithPosition)obj4;
        }
          goto _L20
        obj3 = (PairWithPosition)makePair(pairwithposition1, port.getLineNumber(), i);
        ((PairWithPosition) (obj2)).setCdrBackdoor(obj3);
          goto _L19
        obj2 = pairwithposition1;
          goto _L20
        obj2 = readObject();
          goto _L17
_L6:
        obj2 = obj1;
        if (obj3 != null) goto _L4; else goto _L21
_L21:
        return QuoteExp.voidExp;
        if (true) goto _L23; else goto _L22
_L22:
    }

    Object readIndentCommand()
        throws IOException, SyntaxException
    {
        Object obj;
        int i;
        i = curIndentation;
        obj = LList.Empty;
        LList llist = LList.Empty;
_L12:
        int j = read();
        if (j >= 0) goto _L2; else goto _L1
_L1:
        Object obj1 = obj;
_L4:
        return LList.reverseInPlace(obj1);
_L2:
        if (j == 32 || j == 9)
        {
            continue; /* Loop/switch isn't completed */
        }
        unread();
        obj1 = obj;
        if (j == 41) goto _L4; else goto _L3
_L3:
        if (j != 13 && j != 10) goto _L6; else goto _L5
_L5:
        obj1 = obj;
        if (singleLine()) goto _L4; else goto _L7
_L7:
        Object obj2;
        read();
        port.mark(0x7fffffff);
        j = skipIndentation();
        obj2 = LList.Empty;
        curIndentation = j;
          goto _L8
_L9:
        obj1 = obj;
        if (obj2 != LList.Empty)
        {
            obj1 = new Pair(new Pair(begin.begin, LList.reverseInPlace(obj2)), obj);
        }
          goto _L4
_L8:
        int l;
        if (curIndentation != -1 && j == curIndentation)
        {
            l = Q2.compareIndentation(j, i);
            if (l == 0x80000000)
            {
                error('e', "cannot compare indentation - mix of tabs and spaces");
            } else
            {
                if (l != -1 && l != 1)
                {
                    continue; /* Loop/switch isn't completed */
                }
                error('e', "indentation must differ by 2 or more");
            }
        }
          goto _L9
        if (l <= 0) goto _L9; else goto _L10
_L10:
        int i1 = port.getLineNumber();
        int k1 = port.getColumnNumber();
        obj2 = makePair(readIndentCommand(), obj2, i1, k1);
        if (true) goto _L8; else goto _L6
_L6:
        int k = port.getLineNumber();
        int j1 = port.getColumnNumber();
        obj = makePair(readObject(), obj, k, j1);
        if (true) goto _L12; else goto _L11
_L11:
    }

    void saveExpressionStartPosition()
    {
        expressionStartFile = port.getName();
        expressionStartLine = port.getLineNumber();
        expressionStartColumn = port.getColumnNumber();
    }

    boolean singleLine()
    {
        return interactive && nesting == 0;
    }

    int skipIndentation()
        throws IOException, SyntaxException
    {
        int j = 0;
        boolean flag = false;
        int i = port.read();
        int k;
        int l;
        do
        {
            k = i;
            l = ((flag) ? 1 : 0);
            if (i != 9)
            {
                break;
            }
            j++;
            i = port.read();
        } while (true);
        for (; k == 32; k = port.read())
        {
            l++;
        }

        if (k < 0)
        {
            return -1;
        } else
        {
            port.unread();
            return (j << 16) + l;
        }
    }
}
