// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.kawa.lispexpr.ReadTable;

// Referenced classes of package gnu.commonlisp.lang:
//            Lisp2

class Lisp2ReadTable extends ReadTable
{

    Lisp2ReadTable()
    {
    }

    protected Object makeSymbol(String s)
    {
        return Lisp2.asSymbol(s.intern());
    }
}
