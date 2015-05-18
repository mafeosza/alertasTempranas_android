// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.lists.FString;
import gnu.lists.FVector;
import gnu.mapping.Environment;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;
import java.io.PrintStream;
import java.lang.reflect.Field;

// Referenced classes of package gnu.expr:
//            Language

public class ApplicationMainSupport
{

    public static String commandLineArgArray[];
    public static FVector commandLineArguments;
    public static boolean processCommandLinePropertyAssignments;
    static String propertyFields[][];

    public ApplicationMainSupport()
    {
    }

    public static void processArgs(String as[])
    {
        int j = 0;
        int i = 0;
        if (processCommandLinePropertyAssignments)
        {
            do
            {
                j = i;
                if (i >= as.length)
                {
                    break;
                }
                j = i;
                if (!processSetProperty(as[i]))
                {
                    break;
                }
                i++;
            } while (true);
        }
        setArgs(as, j);
    }

    public static void processSetProperties()
    {
        String as[] = commandLineArgArray;
        if (as == null)
        {
            processCommandLinePropertyAssignments = true;
        } else
        {
            int i;
            for (i = 0; i < as.length && processSetProperty(as[i]); i++) { }
            if (i != 0)
            {
                setArgs(as, i);
                return;
            }
        }
    }

    public static boolean processSetProperty(String s)
    {
        Object obj;
        int i;
        i = s.indexOf('=');
        if (i <= 0)
        {
            return false;
        }
        obj = s.substring(0, i);
        s = s.substring(i + 1);
        i = 0;
_L5:
        String as[] = propertyFields[i];
        if (as != null) goto _L2; else goto _L1
_L1:
        obj = Symbol.parse(((String) (obj)));
        Language.getDefaultLanguage();
        Environment.getCurrent().define(((Symbol) (obj)), null, s);
        return true;
_L2:
        String s1;
        String s2;
        if (!((String) (obj)).equals(as[0]))
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = as[1];
        s2 = as[2];
        ((ThreadLocation)Class.forName(s1).getDeclaredField(s2).get(null)).setGlobal(s);
        if (true) goto _L1; else goto _L3
        Throwable throwable;
        throwable;
        System.err.println((new StringBuilder()).append("error setting property ").append(((String) (obj))).append(" field ").append(s1).append('.').append(s2).append(": ").append(throwable).toString());
        System.exit(-1);
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static void setArgs(String as[], int i)
    {
        int j = as.length - i;
        Object aobj[] = new Object[j];
        if (i == 0)
        {
            commandLineArgArray = as;
        } else
        {
            String as1[] = new String[j];
            int k = j;
            do
            {
                k--;
                if (k < 0)
                {
                    break;
                }
                as1[k] = as[k + i];
            } while (true);
            commandLineArgArray = as1;
        }
        do
        {
            j--;
            if (j >= 0)
            {
                aobj[j] = new FString(as[j + i]);
            } else
            {
                commandLineArguments = new FVector(aobj);
                Environment.getCurrent().put("command-line-arguments", commandLineArguments);
                return;
            }
        } while (true);
    }

    static 
    {
        String as[] = {
            "out:base", "gnu.kawa.functions.DisplayFormat", "outBase"
        };
        String as1[] = {
            "out:radix", "gnu.kawa.functions.DisplayFormat", "outRadix"
        };
        String as2[] = {
            "out:miser-width", "gnu.text.PrettyWriter", "miserWidthLoc"
        };
        String as3[] = {
            "out:xml-indent", "gnu.xml.XMLPrinter", "indentLoc"
        };
        String as4[] = {
            "display:toolkit", "gnu.kawa.models.Display", "myDisplay"
        };
        propertyFields = (new String[][] {
            new String[] {
                "out:doctype-system", "gnu.xml.XMLPrinter", "doctypeSystem"
            }, new String[] {
                "out:doctype-public", "gnu.xml.XMLPrinter", "doctypePublic"
            }, as, as1, new String[] {
                "out:line-length", "gnu.text.PrettyWriter", "lineLengthLoc"
            }, new String[] {
                "out:right-margin", "gnu.text.PrettyWriter", "lineLengthLoc"
            }, as2, as3, as4, null
        });
    }
}
