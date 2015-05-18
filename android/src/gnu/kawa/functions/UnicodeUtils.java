// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.text.BreakIterator;

public class UnicodeUtils
{

    static final Symbol Cc;
    static final Symbol Cf;
    static final Symbol Cn;
    static final Symbol Co;
    static final Symbol Cs;
    static final Symbol Ll;
    static final Symbol Lm;
    static final Symbol Lo;
    static final Symbol Lt;
    static final Symbol Lu;
    static final Symbol Mc;
    static final Symbol Me;
    static final Symbol Mn;
    static final Symbol Nd;
    static final Symbol Nl;
    static final Symbol No;
    static final Symbol Pc;
    static final Symbol Pd;
    static final Symbol Pe;
    static final Symbol Pf;
    static final Symbol Pi;
    static final Symbol Po;
    static final Symbol Ps;
    static final Symbol Sc;
    static final Symbol Sk;
    static final Symbol Sm;
    static final Symbol So;
    static final Symbol Zl;
    static final Symbol Zp;
    static final Symbol Zs;

    public UnicodeUtils()
    {
    }

    public static String capitalize(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        BreakIterator breakiterator = BreakIterator.getWordInstance();
        breakiterator.setText(s);
        int j = breakiterator.first();
        int i = breakiterator.next();
label0:
        do
        {
            if (i != -1)
            {
                boolean flag1 = false;
                int k = j;
                do
                {
label1:
                    {
                        boolean flag = flag1;
                        if (k < i)
                        {
                            if (!Character.isLetter(s.codePointAt(k)))
                            {
                                break label1;
                            }
                            flag = true;
                        }
                        if (!flag)
                        {
                            stringbuilder.append(s, j, i);
                        } else
                        {
                            stringbuilder.append(Character.toTitleCase(s.charAt(j)));
                            stringbuilder.append(s.substring(j + 1, i).toLowerCase());
                        }
                        j = i;
                        i = breakiterator.next();
                        continue label0;
                    }
                    k++;
                } while (true);
            }
            return stringbuilder.toString();
        } while (true);
    }

    public static String foldCase(CharSequence charsequence)
    {
        int i1 = charsequence.length();
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        Object obj = "";
_L4:
        return ((String) (obj));
_L2:
        int j;
        int k;
        obj = null;
        k = 0;
        j = 0;
_L5:
        StringBuilder stringbuilder;
        int i;
        boolean flag;
        int l;
        String s;
        if (j == i1)
        {
            i = -1;
        } else
        {
            i = charsequence.charAt(j);
        }
        if (i == 931 || i == 963 || i == 962)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (i >= 0 && i != 304 && i != 305)
        {
            stringbuilder = ((StringBuilder) (obj));
            l = k;
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_208;
            }
        }
        stringbuilder = ((StringBuilder) (obj));
        if (obj == null)
        {
            stringbuilder = ((StringBuilder) (obj));
            if (i >= 0)
            {
                stringbuilder = new StringBuilder();
            }
        }
        if (j <= k)
        {
            break MISSING_BLOCK_LABEL_155;
        }
        s = charsequence.subSequence(k, j).toString().toUpperCase().toLowerCase();
        obj = s;
        if (stringbuilder == null) goto _L4; else goto _L3
_L3:
        stringbuilder.append(s);
        if (i < 0)
        {
            return stringbuilder.toString();
        }
        if (flag)
        {
            i = 963;
        }
        stringbuilder.append((char)i);
        l = j + 1;
        j++;
        obj = stringbuilder;
        k = l;
          goto _L5
    }

    public static Symbol generalCategory(int i)
    {
        switch (Character.getType(i))
        {
        case 17: // '\021'
        default:
            return Cn;

        case 8: // '\b'
            return Mc;

        case 23: // '\027'
            return Pc;

        case 15: // '\017'
            return Cc;

        case 26: // '\032'
            return Sc;

        case 20: // '\024'
            return Pd;

        case 9: // '\t'
            return Nd;

        case 7: // '\007'
            return Me;

        case 22: // '\026'
            return Pe;

        case 30: // '\036'
            return Pf;

        case 16: // '\020'
            return Cf;

        case 29: // '\035'
            return Pi;

        case 10: // '\n'
            return Nl;

        case 13: // '\r'
            return Zl;

        case 2: // '\002'
            return Ll;

        case 25: // '\031'
            return Sm;

        case 4: // '\004'
            return Lm;

        case 27: // '\033'
            return Sk;

        case 6: // '\006'
            return Mn;

        case 5: // '\005'
            return Lo;

        case 11: // '\013'
            return No;

        case 24: // '\030'
            return Po;

        case 28: // '\034'
            return So;

        case 14: // '\016'
            return Zp;

        case 18: // '\022'
            return Co;

        case 12: // '\f'
            return Zs;

        case 21: // '\025'
            return Ps;

        case 19: // '\023'
            return Cs;

        case 3: // '\003'
            return Lt;

        case 1: // '\001'
            return Lu;
        }
    }

    public static boolean isWhitespace(int i)
    {
        boolean flag1 = false;
        if (i != 32 && (i < 9 || i > 13)) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (i < 133) goto _L4; else goto _L3
_L3:
        if (i == 133 || i == 160 || i == 5760 || i == 6158)
        {
            return true;
        }
        flag = flag1;
        if (i < 8192) goto _L4; else goto _L5
_L5:
        flag = flag1;
        if (i > 12288) goto _L4; else goto _L6
_L6:
        if (i <= 8202 || i == 8232 || i == 8233 || i == 8239 || i == 8287)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (i != 12288) goto _L4; else goto _L7
_L7:
        return true;
    }

    static 
    {
        Namespace namespace = Namespace.EmptyNamespace;
        Mc = namespace.getSymbol("Mc");
        Pc = namespace.getSymbol("Pc");
        Cc = namespace.getSymbol("Cc");
        Sc = namespace.getSymbol("Sc");
        Pd = namespace.getSymbol("Pd");
        Nd = namespace.getSymbol("Nd");
        Me = namespace.getSymbol("Me");
        Pe = namespace.getSymbol("Pe");
        Pf = namespace.getSymbol("Pf");
        Cf = namespace.getSymbol("Cf");
        Pi = namespace.getSymbol("Pi");
        Nl = namespace.getSymbol("Nl");
        Zl = namespace.getSymbol("Zl");
        Ll = namespace.getSymbol("Ll");
        Sm = namespace.getSymbol("Sm");
        Lm = namespace.getSymbol("Lm");
        Sk = namespace.getSymbol("Sk");
        Mn = namespace.getSymbol("Mn");
        Lo = namespace.getSymbol("Lo");
        No = namespace.getSymbol("No");
        Po = namespace.getSymbol("Po");
        So = namespace.getSymbol("So");
        Zp = namespace.getSymbol("Zp");
        Co = namespace.getSymbol("Co");
        Zs = namespace.getSymbol("Zs");
        Ps = namespace.getSymbol("Ps");
        Cs = namespace.getSymbol("Cs");
        Lt = namespace.getSymbol("Lt");
        Cn = namespace.getSymbol("Cn");
        Lu = namespace.getSymbol("Lu");
    }
}
