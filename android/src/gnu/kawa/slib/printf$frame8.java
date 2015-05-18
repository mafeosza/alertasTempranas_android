// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.numbers;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class  extends ModuleBody
{

    CharSequence str;

    public Object lambda17dig(Object obj)
    {
        CharSequence charsequence = str;
        int i;
        try
        {
            i = ((Number)obj).intValue();
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "string-ref", 2, obj);
        }
        i = strings.stringRef(charsequence, i);
        if (unicode.isCharNumeric(Char.make(i)))
        {
            return numbers.string$To$Number(strings.$make$string$(new Object[] {
                Char.make(i)
            }));
        } else
        {
            return printf.Lit1;
        }
    }

    public ()
    {
    }
}
