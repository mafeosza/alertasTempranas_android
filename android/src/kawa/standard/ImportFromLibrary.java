// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.ModuleManager;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Procedure;
import java.io.PrintStream;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            require

public class ImportFromLibrary extends Syntax
{

    private static final String BUILTIN = "";
    private static final String MISSING = null;
    static final String SRFI97Map[][];
    public static final ImportFromLibrary instance = new ImportFromLibrary();
    public String classPrefixPath[] = {
        "", "kawa.lib."
    };

    public ImportFromLibrary()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return null;
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        Procedure procedure;
        String s;
        Object obj;
        Object obj2;
        Object obj3;
        int l;
        s = null;
        pair = ((Pair) (pair.getCdr()));
        if (!(pair instanceof Pair))
        {
            return false;
        }
        pair = (Pair)pair;
        obj = pair.getCar();
        if (LList.listLength(obj, false) <= 0)
        {
            translator.error('e', "expected <library reference> which must be a list");
            return false;
        }
        pair = ((Pair) (pair.getCdr()));
        procedure = s;
        if (pair instanceof Pair)
        {
            procedure = s;
            if (((Pair)pair).getCar() instanceof Procedure)
            {
                procedure = (Procedure)((Pair)pair).getCar();
            }
        }
        pair = null;
        s = null;
        obj3 = new StringBuffer();
        while (obj instanceof Pair) 
        {
            obj = (Pair)obj;
            Object obj1 = ((Pair) (obj)).getCar();
            obj = ((Pair) (obj)).getCdr();
            if (obj1 instanceof Pair)
            {
                if (pair != null)
                {
                    translator.error('e', (new StringBuilder()).append("duplicate version reference - was ").append(pair).toString());
                }
                pair = ((Pair) (obj1));
                System.err.println((new StringBuilder()).append("import version ").append(obj1).toString());
            } else
            if (obj1 instanceof String)
            {
                if (obj instanceof Pair)
                {
                    translator.error('e', "source specifier must be last elemnt in library reference");
                }
                s = (String)obj1;
            } else
            {
                if (((StringBuffer) (obj3)).length() > 0)
                {
                    ((StringBuffer) (obj3)).append('.');
                }
                ((StringBuffer) (obj3)).append(Compilation.mangleNameIfNeeded(obj1.toString()));
            }
        }
        pair = null;
        if (s != null)
        {
            obj = require.lookupModuleFromSourcePath(s, scopeexp);
            pair = ((Pair) (obj));
            if (obj == null)
            {
                translator.error('e', (new StringBuilder()).append("malformed URL: ").append(s).toString());
                return false;
            }
        }
        obj = ((StringBuffer) (obj3)).toString();
        s = ((String) (obj));
        if (!((String) (obj)).startsWith("srfi."))
        {
            break MISSING_BLOCK_LABEL_710;
        }
        obj3 = Compilation.demangleName(((String) (obj)).substring(5));
        int i = ((String) (obj3)).indexOf('.');
        if (i < 0)
        {
            s = null;
            i = ((String) (obj3)).length();
        } else
        {
            s = ((String) (obj3)).substring(i + 1);
        }
        obj2 = null;
        if (i >= 2) goto _L2; else goto _L1
_L1:
        obj = obj2;
        if (((String) (obj3)).charAt(0) != ':') goto _L3; else goto _L2
_L2:
        l = 1;
_L8:
        if (l != i) goto _L5; else goto _L4
_L4:
        obj = ((String) (obj3)).substring(1, i);
_L3:
        if (obj == null)
        {
            translator.error('e', "SRFI library reference must have the form: (srfi :NNN [name])");
            return false;
        }
        break; /* Loop/switch isn't completed */
_L5:
        obj = obj2;
        if (Character.digit(((String) (obj3)).charAt(l), 10) < 0) goto _L3; else goto _L6
_L6:
        l++;
        if (true) goto _L8; else goto _L7
_L7:
        int j = SRFI97Map.length;
        do
        {
            l = j - 1;
            if (l < 0)
            {
                translator.error('e', (new StringBuilder()).append("unknown SRFI number '").append(((String) (obj))).append("' in SRFI library reference").toString());
                return false;
            }
            j = l;
        } while (!SRFI97Map[l][0].equals(obj));
        String s2 = SRFI97Map[l][1];
        String s1 = SRFI97Map[l][2];
        if (s != null && !s.equals(s2))
        {
            translator.error('w', (new StringBuilder()).append("the name of SRFI ").append(((String) (obj))).append(" should be '").append(s2).append('\'').toString());
        }
        if (s1 == "")
        {
            return true;
        }
        if (s1 == MISSING)
        {
            translator.error('e', (new StringBuilder()).append("sorry - Kawa does not support SRFI ").append(((String) (obj))).append(" (").append(s2).append(')').toString());
            return false;
        }
        s = s1;
        int k;
        l = classPrefixPath.length;
        k = 0;
_L10:
        if (k >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (new StringBuilder()).append(classPrefixPath[k]).append(s).toString();
        obj = ModuleManager.getInstance().findWithClassName(((String) (obj)));
        pair = ((Pair) (obj));
_L11:
        k++;
        if (true) goto _L10; else goto _L9
        Exception exception;
        exception;
          goto _L11
_L9:
        if (pair == null)
        {
            translator.error('e', (new StringBuilder()).append("unknown class ").append(s).toString());
            return false;
        } else
        {
            require.importDefinitions(null, pair, procedure, vector, scopeexp, translator);
            return true;
        }
    }

    static 
    {
        String as[] = {
            "1", "lists", "gnu.kawa.slib.srfi1"
        };
        String as1[] = {
            "2", "and-let*", "gnu.kawa.slib.srfi2"
        };
        String as2[] = {
            "5", "let", MISSING
        };
        String as3[] = {
            "6", "basic-string-ports", ""
        };
        String as4[] = {
            "8", "receive", ""
        };
        String as5[] = {
            "9", "records", ""
        };
        String as6[] = {
            "11", "let-values", ""
        };
        String as7[] = {
            "13", "strings", "gnu.kawa.slib.srfi13"
        };
        String as8[] = {
            "14", "char-sets", MISSING
        };
        String as9[] = {
            "16", "case-lambda", ""
        };
        String as10[] = {
            "17", "generalized-set!", ""
        };
        String as11[] = {
            "18", "multithreading", MISSING
        };
        String s = MISSING;
        String as12[] = {
            "21", "real-time-multithreading", MISSING
        };
        String as13[] = {
            "23", "error", ""
        };
        String as14[] = {
            "25", "multi-dimensional-arrays", ""
        };
        String as15[] = {
            "26", "cut", ""
        };
        String s1 = MISSING;
        String as16[] = {
            "28", "basic-format-strings", ""
        };
        String s2 = MISSING;
        String as17[] = {
            "31", "rec", MISSING
        };
        String as18[] = {
            "38", "with-shared-structure", MISSING
        };
        String as19[] = {
            "39", "parameters", ""
        };
        String as20[] = {
            "41", "streams", MISSING
        };
        String as21[] = {
            "42", "eager-comprehensions", MISSING
        };
        String as22[] = {
            "43", "vectors", MISSING
        };
        String as23[] = {
            "44", "collections", MISSING
        };
        String as24[] = {
            "45", "lazy", MISSING
        };
        String as25[] = {
            "46", "syntax-rules", MISSING
        };
        String as26[] = {
            "47", "arrays", MISSING
        };
        String as27[] = {
            "48", "intermediate-format-strings", MISSING
        };
        String as28[] = {
            "51", "rest-values", MISSING
        };
        String as29[] = {
            "54", "cat", MISSING
        };
        String as30[] = {
            "57", "records", MISSING
        };
        String as31[] = {
            "59", "vicinities", MISSING
        };
        String as32[] = {
            "60", "integer-bits", MISSING
        };
        String s3 = MISSING;
        String as33[] = {
            "63", "arrays", MISSING
        };
        String as34[] = {
            "64", "testing", "gnu.kawa.slib.testing"
        };
        String as35[] = {
            "66", "octet-vectors", MISSING
        };
        String s4 = MISSING;
        String as36[] = {
            "69", "basic-hash-tables", "gnu.kawa.slib.srfi69"
        };
        String as37[] = {
            "71", "let", MISSING
        };
        String as38[] = {
            "74", "blobs", MISSING
        };
        String as39[] = {
            "78", "lightweight-testing", MISSING
        };
        String as40[] = {
            "86", "mu-and-nu", MISSING
        };
        String as41[] = {
            "87", "case", MISSING
        };
        String as42[] = {
            "95", "sorting-and-merging", "kawa.lib.srfi95"
        };
        SRFI97Map = (new String[][] {
            as, as1, as2, as3, as4, as5, as6, as7, as8, as9, 
            as10, as11, new String[] {
                "19", "time", s
            }, as12, as13, as14, as15, new String[] {
                "27", "random-bits", s1
            }, as16, new String[] {
                "29", "localization", s2
            }, 
            as17, as18, as19, as20, as21, as22, as23, as24, as25, as26, 
            as27, as28, as29, as30, as31, as32, new String[] {
                "61", "cond", s3
            }, as33, as34, as35, 
            new String[] {
                "67", "compare-procedures", s4
            }, as36, as37, as38, as39, as40, as41, as42
        });
    }
}
