// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class export extends Syntax
{

    public static final export export = new export();
    public static final export module_export;

    public export()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return null;
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        Object obj2;
        vector = ((Vector) (pair.getCdr()));
        obj2 = translator.pushPositionOf(pair);
        if (!(scopeexp instanceof ModuleExp)) goto _L2; else goto _L1
_L1:
        ((ModuleExp)scopeexp).setFlag(16384);
        pair = null;
_L8:
        if (vector == LList.Empty) goto _L4; else goto _L3
_L3:
        translator.pushPositionOf(vector);
        for (; vector instanceof SyntaxForm; vector = ((Vector) (pair.getDatum())))
        {
            pair = (SyntaxForm)vector;
        }

          goto _L5
_L2:
        translator.error('e', (new StringBuilder()).append("'").append(getName()).append("' not at module level").toString());
        translator.popPositionOf(obj2);
        return true;
_L5:
        Object obj = pair;
        if (!(vector instanceof Pair)) goto _L7; else goto _L6
_L6:
        Pair pair1;
        pair1 = (Pair)vector;
        for (vector = ((Vector) (pair1.getCar())); vector instanceof SyntaxForm; vector = ((Vector) (((SyntaxForm) (obj)).getDatum())))
        {
            obj = (SyntaxForm)vector;
        }

        Object obj1 = vector;
        String s;
        if (!(vector instanceof String))
        {
            break MISSING_BLOCK_LABEL_207;
        }
        s = (String)vector;
        obj1 = vector;
        if (s.startsWith("namespace:"))
        {
            translator.error('w', "'namespace:' prefix ignored");
            obj1 = s.substring(10).intern();
        }
        if ((obj1 instanceof String) || (obj1 instanceof Symbol))
        {
            break MISSING_BLOCK_LABEL_327;
        }
          goto _L7
_L9:
        vector = scopeexp.getNoDefine(obj1);
        if (vector.getFlag(512L))
        {
            Translator.setLine(vector, pair1);
        }
        vector.setFlag(1024L);
        vector = ((Vector) (pair1.getCdr()));
          goto _L8
_L7:
        translator.error('e', (new StringBuilder()).append("invalid syntax in '").append(getName()).append('\'').toString());
        translator.popPositionOf(obj2);
        return false;
_L4:
        translator.popPositionOf(obj2);
        return true;
        pair;
        translator.popPositionOf(obj2);
        throw pair;
        if (obj == null);
          goto _L9
    }

    static 
    {
        module_export = new export();
        module_export.setName("module-export");
        module_export.setName("export");
    }
}
