// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.ecmascript;

import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.LambdaExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.lists.Sequence;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.text.SyntaxException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;
import kawa.standard.Scheme;

// Referenced classes of package gnu.ecmascript:
//            Lexer, Prompter, Reserved

public class Parser
{

    public static final Expression emptyArgs[] = new Expression[0];
    static Expression emptyStatement;
    public static Expression eofExpr;
    public int errors;
    Lexer lexer;
    InPort port;
    Object previous_token;
    Object token;

    public Parser(InPort inport)
    {
        port = inport;
        lexer = new Lexer(inport);
    }

    public static void main(String args[])
    {
        OutPort outport;
        new Scheme();
        args = InPort.inDefault();
        if (args instanceof TtyInPort)
        {
            Prompter prompter = new Prompter();
            ((TtyInPort)args).setPrompter((Procedure)prompter);
        }
        args = new Parser(args);
        outport = OutPort.outDefault();
_L1:
        Object obj;
        try
        {
            obj = args.parseStatement();
            if (obj == eofExpr)
            {
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String args[])
        {
            System.err.println((new StringBuilder()).append("caught exception:").append(args).toString());
            args.printStackTrace(System.err);
            return;
        }
        outport.print("[Expression: ");
        ((Expression) (obj)).print(outport);
        outport.println("]");
        obj = ((Expression) (obj)).eval(Environment.user());
        outport.print("result: ");
        outport.print(obj);
        outport.println();
          goto _L1
    }

    public Expression buildLoop(Expression expression, Expression expression1, Expression expression2, Expression expression3)
    {
        if (expression != null)
        {
            return new BeginExp(new Expression[] {
                expression, buildLoop(null, expression1, expression2, expression3)
            });
        } else
        {
            throw new Error("not implemented - buildLoop");
        }
    }

    public String getIdentifier()
        throws IOException, SyntaxException
    {
        Object obj = getToken();
        if (obj instanceof String)
        {
            return (String)obj;
        } else
        {
            syntaxError("missing identifier");
            return "??";
        }
    }

    public void getSemicolon()
        throws IOException, SyntaxException
    {
        token = peekToken();
        if (token == Lexer.semicolonToken)
        {
            skipToken();
        } else
        if (token != Lexer.rbraceToken && token != Lexer.eofToken && previous_token != Lexer.eolToken)
        {
            syntaxError("missing ';' after expression");
            return;
        }
    }

    public Object getToken()
        throws IOException, SyntaxException
    {
        Object obj = peekToken();
        skipToken();
        return obj;
    }

    public Expression makeCallExpression(Expression expression, Expression aexpression[])
    {
        return new ApplyExp(expression, aexpression);
    }

    public Expression makeNewExpression(Expression expression, Expression aexpression[])
    {
        expression = aexpression;
        if (aexpression == null)
        {
            expression = emptyArgs;
        }
        return new ApplyExp(null, expression);
    }

    public Expression makePropertyAccessor(Expression expression, Expression expression1)
    {
        return null;
    }

    public Expression[] parseArguments()
        throws IOException, SyntaxException
    {
        skipToken();
        if (peekToken() == Lexer.rparenToken)
        {
            skipToken();
            return emptyArgs;
        }
        Vector vector = new Vector(10);
        do
        {
            Expression aexpression[];
            do
            {
                vector.addElement(parseAssignmentExpression());
                aexpression = ((Expression []) (getToken()));
                if (aexpression == Lexer.rparenToken)
                {
                    aexpression = new Expression[vector.size()];
                    vector.copyInto(aexpression);
                    return aexpression;
                }
            } while (aexpression == Lexer.commaToken);
            syntaxError((new StringBuilder()).append("invalid token '").append(aexpression).append("' in argument list").toString());
        } while (true);
    }

    public Expression parseAssignmentExpression()
        throws IOException, SyntaxException
    {
        Expression expression1;
        Object obj1;
        expression1 = parseConditionalExpression();
        obj1 = peekToken();
        if (obj1 != Lexer.equalToken) goto _L2; else goto _L1
_L1:
        Object obj;
        skipToken();
        obj = parseAssignmentExpression();
        if (!(expression1 instanceof ReferenceExp)) goto _L4; else goto _L3
_L3:
        obj = new SetExp(((ReferenceExp)expression1).getName(), ((Expression) (obj)));
        ((SetExp) (obj)).setDefining(true);
_L6:
        return ((Expression) (obj));
_L4:
        return syntaxError("unmplemented non-symbol ihs in assignment");
_L2:
        obj = expression1;
        if (obj1 instanceof Reserved)
        {
            obj1 = (Reserved)obj1;
            obj = expression1;
            if (((Reserved) (obj1)).isAssignmentOp())
            {
                skipToken();
                Expression expression = parseAssignmentExpression();
                return new ApplyExp(new QuoteExp(((Reserved) (obj1)).proc), new Expression[] {
                    expression1, expression
                });
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Expression parseBinaryExpression(int i)
        throws IOException, SyntaxException
    {
        Object obj = parseUnaryExpression();
_L5:
        token = peekToken();
        if (token instanceof Reserved) goto _L2; else goto _L1
_L1:
        Reserved reserved;
        return ((Expression) (obj));
_L2:
        if ((reserved = (Reserved)token).prio < i) goto _L1; else goto _L3
_L3:
        getToken();
        Expression expression = parseBinaryExpression(reserved.prio + 1);
        obj = new ApplyExp(new QuoteExp(reserved.proc), new Expression[] {
            obj, expression
        });
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Expression parseBlock()
        throws IOException, SyntaxException
    {
        Expression aexpression1[];
        int i;
        aexpression1 = null;
        if (getToken() != Lexer.lbraceToken)
        {
            return syntaxError("extened '{'");
        }
        i = 0;
_L10:
        Expression aexpression[];
        boolean flag;
        token = peekToken();
        if (token == Lexer.rbraceToken)
        {
            skipToken();
            if (aexpression1 == null)
            {
                return emptyStatement;
            }
            flag = true;
        } else
        {
            flag = false;
        }
        if (aexpression1 != null) goto _L2; else goto _L1
_L1:
        aexpression = new Expression[2];
_L7:
        if (flag)
        {
            return new BeginExp(aexpression);
        }
        break MISSING_BLOCK_LABEL_142;
_L2:
        if (!flag) goto _L4; else goto _L3
_L3:
        aexpression = aexpression1;
        if (aexpression1.length == i) goto _L6; else goto _L5
_L5:
        int j;
        if (flag)
        {
            j = i;
        } else
        {
            j = aexpression1.length * 2;
        }
        aexpression = new Expression[j];
        System.arraycopy(aexpression1, 0, aexpression, 0, i);
_L6:
        if (true) goto _L7; else goto _L4
_L4:
        aexpression = aexpression1;
        if (aexpression1.length > i) goto _L8; else goto _L5
_L8:
        continue; /* Loop/switch isn't completed */
        aexpression[i] = parseStatement();
        i++;
        aexpression1 = aexpression;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public Expression parseConditionalExpression()
        throws IOException, SyntaxException
    {
        Expression expression = parseBinaryExpression(1);
        if (peekToken() != Lexer.condToken)
        {
            return expression;
        }
        skipToken();
        Expression expression1 = parseAssignmentExpression();
        if (getToken() != Lexer.colonToken)
        {
            return syntaxError("expected ':' in conditional expression");
        } else
        {
            return new IfExp(expression, expression1, parseAssignmentExpression());
        }
    }

    public Expression parseExpression()
        throws IOException, SyntaxException
    {
        Expression aexpression1[];
        int i;
        aexpression1 = null;
        i = 0;
_L10:
        Expression expression;
        boolean flag;
        expression = parseAssignmentExpression();
        if (peekToken() != Lexer.commaToken)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (aexpression1 != null) goto _L2; else goto _L1
_L1:
        Expression aexpression[];
        if (flag)
        {
            return expression;
        }
        aexpression = new Expression[2];
_L7:
        aexpression[i] = expression;
        if (flag)
        {
            return new BeginExp(aexpression);
        }
        break MISSING_BLOCK_LABEL_130;
_L2:
        if (!flag) goto _L4; else goto _L3
_L3:
        aexpression = aexpression1;
        if (aexpression1.length == i + 1) goto _L6; else goto _L5
_L5:
        int j;
        if (flag)
        {
            j = i + 1;
        } else
        {
            j = aexpression1.length * 2;
        }
        aexpression = new Expression[j];
        System.arraycopy(aexpression1, 0, aexpression, 0, i);
_L6:
        if (true) goto _L7; else goto _L4
_L4:
        aexpression = aexpression1;
        if (aexpression1.length > i) goto _L8; else goto _L5
_L8:
        continue; /* Loop/switch isn't completed */
        skipToken();
        i++;
        aexpression1 = aexpression;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public Expression parseFunctionDefinition()
        throws IOException, SyntaxException
    {
        Object obj;
        Object obj1;
        skipToken();
        obj = getIdentifier();
        obj1 = getToken();
        if (obj1 != Lexer.lparenToken)
        {
            return syntaxError((new StringBuilder()).append("expected '(' - got:").append(obj1).toString());
        }
        obj1 = new Vector(10);
        if (peekToken() != Lexer.rparenToken) goto _L2; else goto _L1
_L1:
        skipToken();
_L3:
        obj1 = new LambdaExp(parseBlock());
        ((LambdaExp) (obj1)).setName(((String) (obj)));
        obj = new SetExp(obj, ((Expression) (obj1)));
        ((SetExp) (obj)).setDefining(true);
        return ((Expression) (obj));
_L4:
        Object obj2;
        if (obj2 != Lexer.commaToken)
        {
            syntaxError((new StringBuilder()).append("invalid token '").append(obj2).append("' in argument list").toString());
        }
_L2:
        ((Vector) (obj1)).addElement(getIdentifier());
        obj2 = getToken();
        if (obj2 != Lexer.rparenToken) goto _L4; else goto _L3
    }

    public Expression parseIfStatement()
        throws IOException, SyntaxException
    {
        skipToken();
        Object obj = getToken();
        if (obj != Lexer.lparenToken)
        {
            return syntaxError((new StringBuilder()).append("expected '(' - got:").append(obj).toString());
        }
        Expression expression = parseExpression();
        obj = getToken();
        if (obj != Lexer.rparenToken)
        {
            return syntaxError((new StringBuilder()).append("expected ')' - got:").append(obj).toString());
        }
        Expression expression1 = parseStatement();
        if (peekToken() == Lexer.elseToken)
        {
            skipToken();
            obj = parseStatement();
        } else
        {
            obj = null;
        }
        return new IfExp(expression, expression1, ((Expression) (obj)));
    }

    public Expression parseLeftHandSideExpression()
        throws IOException, SyntaxException
    {
        int i = 0;
        for (; peekToken() == Lexer.newToken; skipToken())
        {
            i++;
        }

        Expression expression = parsePrimaryExpression();
        Expression expression2;
        int j;
        do
        {
            Object obj = peekToken();
            if (obj == Lexer.dotToken)
            {
                skipToken();
                expression = makePropertyAccessor(expression, new QuoteExp(getIdentifier()));
                continue;
            }
            if (obj == Lexer.lbracketToken)
            {
                skipToken();
                Expression expression1 = parseExpression();
                obj = getToken();
                if (obj != Lexer.rbracketToken)
                {
                    return syntaxError((new StringBuilder()).append("expected ']' - got:").append(obj).toString());
                }
                expression = makePropertyAccessor(expression, expression1);
                continue;
            }
            expression2 = expression;
            j = i;
            if (obj != Lexer.lparenToken)
            {
                break;
            }
            expression2 = parseArguments();
            System.err.println((new StringBuilder()).append("after parseArgs:").append(peekToken()).toString());
            if (i > 0)
            {
                expression = makeNewExpression(expression, expression2);
                i--;
            } else
            {
                expression = makeCallExpression(expression, expression2);
            }
        } while (true);
        for (; j > 0; j--)
        {
            expression2 = makeNewExpression(expression2, null);
        }

        return expression2;
    }

    public Expression parsePostfixExpression()
        throws IOException, SyntaxException
    {
        Expression expression = parseLeftHandSideExpression();
        Object obj = peekTokenOrLine();
        if (obj != Reserved.opPlusPlus && obj != Reserved.opMinusMinus)
        {
            return expression;
        } else
        {
            skipToken();
            return new ApplyExp(new QuoteExp(((Reserved)obj).proc), new Expression[] {
                expression
            });
        }
    }

    public Expression parsePrimaryExpression()
        throws IOException, SyntaxException
    {
        Object obj = getToken();
        if (obj instanceof QuoteExp)
        {
            return (QuoteExp)obj;
        }
        if (obj instanceof String)
        {
            return new ReferenceExp((String)obj);
        }
        if (obj == Lexer.lparenToken)
        {
            obj = parseExpression();
            Object obj1 = getToken();
            if (obj1 != Lexer.rparenToken)
            {
                return syntaxError((new StringBuilder()).append("expected ')' - got:").append(obj1).toString());
            } else
            {
                return ((Expression) (obj));
            }
        } else
        {
            return syntaxError((new StringBuilder()).append("unexpected token: ").append(obj).toString());
        }
    }

    public Expression parseStatement()
        throws IOException, SyntaxException
    {
        Object obj = peekToken();
        if (!(obj instanceof Reserved)) goto _L2; else goto _L1
_L1:
        ((Reserved)obj).prio;
        JVM INSTR lookupswitch 3: default 52
    //                   31: 63
    //                   32: 68
    //                   41: 73;
           goto _L2 _L3 _L4 _L5
_L2:
        if (obj == Lexer.eofToken)
        {
            return eofExpr;
        }
        break; /* Loop/switch isn't completed */
_L3:
        return parseIfStatement();
_L4:
        return parseWhileStatement();
_L5:
        return parseFunctionDefinition();
        if (obj == Lexer.semicolonToken)
        {
            skipToken();
            return emptyStatement;
        }
        if (obj == Lexer.lbraceToken)
        {
            return parseBlock();
        } else
        {
            Expression expression = parseExpression();
            getSemicolon();
            return expression;
        }
    }

    public Expression parseUnaryExpression()
        throws IOException, SyntaxException
    {
        return parsePostfixExpression();
    }

    public Expression parseWhileStatement()
        throws IOException, SyntaxException
    {
        skipToken();
        Object obj = getToken();
        if (obj != Lexer.lparenToken)
        {
            return syntaxError((new StringBuilder()).append("expected '(' - got:").append(obj).toString());
        }
        obj = parseExpression();
        Object obj1 = getToken();
        if (obj1 != Lexer.rparenToken)
        {
            return syntaxError((new StringBuilder()).append("expected ')' - got:").append(obj1).toString());
        } else
        {
            return buildLoop(null, ((Expression) (obj)), null, parseStatement());
        }
    }

    public Object peekToken()
        throws IOException, SyntaxException
    {
        if (token == null)
        {
            token = lexer.getToken();
        }
        for (; token == Lexer.eolToken; token = lexer.getToken())
        {
            skipToken();
        }

        return token;
    }

    public Object peekTokenOrLine()
        throws IOException, SyntaxException
    {
        if (token == null)
        {
            token = lexer.getToken();
        }
        return token;
    }

    public final void skipToken()
    {
        if (token != Lexer.eofToken)
        {
            previous_token = token;
            token = null;
        }
    }

    public Expression syntaxError(String s)
    {
        errors = errors + 1;
        OutPort outport = OutPort.errDefault();
        String s1 = port.getName();
        int i = port.getLineNumber() + 1;
        int j = port.getColumnNumber() + 1;
        if (i > 0)
        {
            if (s1 != null)
            {
                outport.print(s1);
            }
            outport.print(':');
            outport.print(i);
            if (j > 1)
            {
                outport.print(':');
                outport.print(j);
            }
            outport.print(": ");
        }
        outport.println(s);
        return new ErrorExp(s);
    }

    static 
    {
        eofExpr = new QuoteExp(Sequence.eofValue);
        emptyStatement = new QuoteExp(Values.empty);
    }
}
