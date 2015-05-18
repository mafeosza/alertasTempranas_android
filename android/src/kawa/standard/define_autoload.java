// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.lispexpr.LispReader;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.InPort;
import gnu.mapping.Symbol;
import gnu.text.SyntaxException;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import kawa.lang.AutoloadProcedure;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class define_autoload extends Syntax
{

    public static final define_autoload define_autoload = new define_autoload("define-autoload", false);
    public static final define_autoload define_autoloads_from_file = new define_autoload("define-autoloads-from-file", true);
    boolean fromFile;

    public define_autoload(String s, boolean flag)
    {
        super(s);
        fromFile = flag;
    }

    public static void findAutoloadComments(LispReader lispreader, String s, ScopeExp scopeexp, Translator translator)
        throws IOException, SyntaxException
    {
        int i;
        int j1;
        i = 1;
        j1 = ";;;###autoload".length();
_L5:
        int k = lispreader.peek();
        if (k >= 0) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i1;
        if (k == 10 || k == 13)
        {
            lispreader.read();
            i = 1;
            continue; /* Loop/switch isn't completed */
        }
        i1 = k;
        if (i == 0)
        {
            break;
        }
        i1 = k;
        if (k != 59)
        {
            break;
        }
        int j = 0;
        i = k;
        do
        {
            if (j == j1)
            {
                i1 = i;
                if (j > 0)
                {
                    Object obj = lispreader.readObject();
                    if (obj instanceof Pair)
                    {
                        Pair pair = (Pair)obj;
                        Object obj2 = null;
                        Object obj1 = null;
                        obj = pair.getCar();
                        int l;
                        if (obj instanceof String)
                        {
                            obj = obj.toString();
                        } else
                        if (obj instanceof Symbol)
                        {
                            obj = ((Symbol)obj).getName();
                        } else
                        {
                            obj = null;
                        }
                        if (obj == "defun")
                        {
                            obj1 = ((Pair)pair.getCdr()).getCar().toString();
                            obj = new AutoloadProcedure(((String) (obj1)), s, translator.getLanguage());
                        } else
                        {
                            translator.error('w', (new StringBuilder()).append("unsupported ;;;###autoload followed by: ").append(pair.getCar()).toString());
                            obj = obj2;
                        }
                        if (obj != null)
                        {
                            obj1 = scopeexp.getDefine(obj1, 'w', translator);
                            obj = new QuoteExp(obj);
                            ((Declaration) (obj1)).setFlag(16384L);
                            ((Declaration) (obj1)).noteValue(((Expression) (obj)));
                            ((Declaration) (obj1)).setProcedureDecl(true);
                            ((Declaration) (obj1)).setType(Compilation.typeProcedure);
                        }
                    }
                    i = 0;
                    continue; /* Loop/switch isn't completed */
                }
                break;
            }
            l = lispreader.read();
            if (l < 0)
            {
                continue;
            }
            if (l == 10 || l == 13)
            {
                i = 1;
                continue; /* Loop/switch isn't completed */
            }
            i = l;
            if (j >= 0)
            {
                if (l == ";;;###autoload".charAt(j))
                {
                    j++;
                    i = l;
                } else
                {
                    j = -1;
                    i = l;
                }
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        boolean flag;
        flag = false;
        lispreader.skip();
        if (i1 != 35 || lispreader.peek() != 124)
        {
            break; /* Loop/switch isn't completed */
        }
        lispreader.skip();
        lispreader.readNestedComment('#', '|');
        i = ((flag) ? 1 : 0);
        if (true) goto _L5; else goto _L4
_L4:
        i = ((flag) ? 1 : 0);
        if (!Character.isWhitespace((char)i1))
        {
            i = ((flag) ? 1 : 0);
            if (lispreader.readObject(i1) == Sequence.eofValue)
            {
                return;
            }
        }
        if (true) goto _L5; else goto _L6
_L6:
    }

    public static boolean process(Object obj, Object obj1, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        if (!(obj instanceof Pair)) goto _L2; else goto _L1
_L1:
        obj = (Pair)obj;
        if (!process(((Pair) (obj)).getCar(), obj1, vector, scopeexp, translator) || !process(((Pair) (obj)).getCdr(), obj1, vector, scopeexp, translator)) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (obj != LList.Empty)
        {
            if ((obj instanceof String) || (obj instanceof Symbol))
            {
                vector = obj.toString();
                scopeexp = scopeexp.getDefine(vector, 'w', translator);
                obj = obj1;
                if (obj1 instanceof String)
                {
                    String s = (String)obj1;
                    int i = s.length();
                    obj = obj1;
                    if (i > 2)
                    {
                        obj = obj1;
                        if (s.charAt(0) == '<')
                        {
                            obj = obj1;
                            if (s.charAt(i - 1) == '>')
                            {
                                obj = s.substring(1, i - 1);
                            }
                        }
                    }
                }
                obj = new QuoteExp(new AutoloadProcedure(vector, obj.toString(), translator.getLanguage()));
                scopeexp.setFlag(16384L);
                scopeexp.noteValue(((Expression) (obj)));
                return true;
            } else
            {
                return false;
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return null;
    }

    public boolean scanFile(String s, ScopeExp scopeexp, Translator translator)
    {
        if (!s.endsWith(".el"));
        File file1 = new File(s);
        File file = file1;
        if (!file1.isAbsolute())
        {
            file = new File((new File(translator.getFileName())).getParent(), s);
        }
        String s3 = file.getPath();
        int i = s3.lastIndexOf('.');
        if (i >= 0)
        {
            String s1 = s3.substring(i);
            Language language = Language.getInstance(s1);
            if (language == null)
            {
                translator.syntaxError((new StringBuilder()).append("unknown extension for ").append(s3).toString());
                return true;
            }
            String s2 = translator.classPrefix;
            i = s1.length();
            for (s1 = s.substring(0, s.length() - i); s1.startsWith("../"); s1 = s1.substring(3))
            {
                int j = s2.lastIndexOf('.', s2.length() - 2);
                if (j < 0)
                {
                    translator.syntaxError((new StringBuilder()).append("cannot use relative filename \"").append(s).append("\" with simple prefix \"").append(s2).append("\"").toString());
                    return false;
                }
                s2 = s2.substring(0, j + 1);
            }

            s = (new StringBuilder()).append(s2).append(s1).toString().replace('/', '.');
            try
            {
                findAutoloadComments((LispReader)language.getLexer(InPort.openFile(s3), translator.getMessages()), s, scopeexp, translator);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                translator.syntaxError((new StringBuilder()).append("error reading ").append(s3).append(": ").append(s).toString());
                return true;
            }
        }
        return true;
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        boolean flag1 = false;
        if (pair.getCdr() instanceof Pair) goto _L2; else goto _L1
_L1:
        boolean flag = super.scanForDefinitions(pair, vector, scopeexp, translator);
_L6:
        return flag;
_L2:
        pair = (Pair)pair.getCdr();
        if (!fromFile)
        {
            break MISSING_BLOCK_LABEL_116;
        }
_L8:
        if (pair.getCar() instanceof CharSequence) goto _L4; else goto _L3
_L3:
        translator.syntaxError("invalid syntax for define-autoloads-from-file");
        return false;
_L4:
        flag = flag1;
        if (!scanFile(pair.getCar().toString(), scopeexp, translator)) goto _L6; else goto _L5
_L5:
        vector = ((Vector) (pair.getCdr()));
        if (vector == LList.Empty)
        {
            return true;
        }
        if (!(vector instanceof Pair)) goto _L3; else goto _L7
_L7:
        pair = (Pair)pair.getCdr();
          goto _L8
        Object obj = pair.getCar();
        if (pair.getCdr() instanceof Pair)
        {
            return process(obj, ((Pair)pair.getCdr()).getCar(), vector, scopeexp, translator);
        } else
        {
            translator.syntaxError("invalid syntax for define-autoload");
            return false;
        }
    }

}
