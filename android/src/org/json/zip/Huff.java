// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import org.json.JSONException;

// Referenced classes of package org.json.zip:
//            None, PostMortem, BitWriter, JSONzip, 
//            BitReader

public class Huff
    implements None, PostMortem
{
    private static class Symbol
        implements PostMortem
    {

        public Symbol back;
        public final int integer;
        public Symbol next;
        public Symbol one;
        public long weight;
        public Symbol zero;

        public boolean postMortem(PostMortem postmortem)
        {
            boolean flag1;
            boolean flag2;
            flag1 = true;
            flag2 = true;
            postmortem = (Symbol)postmortem;
            if (integer == ((Symbol) (postmortem)).integer && weight == ((Symbol) (postmortem)).weight) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            Symbol symbol;
            Symbol symbol1;
            boolean flag;
            if (back != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (((Symbol) (postmortem)).back == null)
            {
                flag1 = false;
            }
            if (flag != flag1) goto _L1; else goto _L3
_L3:
            symbol = zero;
            symbol1 = one;
            if (symbol != null) goto _L5; else goto _L4
_L4:
            if (((Symbol) (postmortem)).zero != null) goto _L1; else goto _L6
_L6:
            if (symbol1 != null)
            {
                break MISSING_BLOCK_LABEL_120;
            }
            if (((Symbol) (postmortem)).one != null) goto _L1; else goto _L7
_L7:
            return flag2;
_L5:
            flag2 = symbol.postMortem(((PostMortem) (((Symbol) (postmortem)).zero)));
              goto _L6
            flag2 = symbol1.postMortem(((PostMortem) (((Symbol) (postmortem)).one)));
              goto _L7
        }

        public Symbol(int i)
        {
            integer = i;
            weight = 0L;
            next = null;
            back = null;
            one = null;
            zero = null;
        }
    }


    private final int domain;
    private final Symbol symbols[];
    private Symbol table;
    private boolean upToDate;
    private int width;

    public Huff(int i)
    {
        upToDate = false;
        domain = i;
        int k = i * 2 - 1;
        symbols = new Symbol[k];
        for (int j = 0; j < i; j++)
        {
            symbols[j] = new Symbol(j);
        }

        for (; i < k; i++)
        {
            symbols[i] = new Symbol(-1);
        }

    }

    private boolean postMortem(int i)
    {
        Symbol symbol;
        int ai[];
        boolean flag;
        flag = true;
        ai = new int[domain];
        symbol = symbols[i];
        if (symbol.integer == i) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = 0;
_L4:
        Symbol symbol1 = symbol.back;
        if (symbol1 == null)
        {
            if (symbol == table)
            {
                width = 0;
                for (symbol = table; symbol.integer == -1;)
                {
                    j--;
                    if (ai[j] != 0)
                    {
                        symbol = symbol.one;
                    } else
                    {
                        symbol = symbol.zero;
                    }
                }

                break MISSING_BLOCK_LABEL_138;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (symbol1.zero != symbol)
        {
            continue; /* Loop/switch isn't completed */
        }
        ai[j] = 0;
_L6:
        j++;
        symbol = symbol1;
        if (true) goto _L4; else goto _L3
_L3:
        if (symbol1.one != symbol) goto _L1; else goto _L5
_L5:
        ai[j] = 1;
          goto _L6
        if (symbol.integer != i || j != 0)
        {
            flag = false;
        }
        return flag;
        if (true) goto _L1; else goto _L7
_L7:
    }

    private void write(Symbol symbol, BitWriter bitwriter)
        throws JSONException
    {
        Symbol symbol1;
        try
        {
            symbol1 = symbol.back;
        }
        // Misplaced declaration of an exception variable
        catch (Symbol symbol)
        {
            throw new JSONException(symbol);
        }
        if (symbol1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        width = width + 1;
        write(symbol1, bitwriter);
        if (symbol1.zero == symbol)
        {
            bitwriter.zero();
            return;
        }
        bitwriter.one();
        return;
    }

    public void generate()
    {
        if (upToDate) goto _L2; else goto _L1
_L1:
        Symbol symbol;
        Symbol symbol1;
        int i;
        symbol = symbols[0];
        symbol1 = symbol;
        table = null;
        symbol.next = null;
        i = 1;
_L7:
        if (i >= domain) goto _L4; else goto _L3
_L3:
        Symbol symbol3 = symbols[i];
        if (symbol3.weight >= symbol.weight) goto _L6; else goto _L5
_L5:
        symbol3.next = symbol;
        symbol = symbol3;
_L8:
        i++;
          goto _L7
_L6:
        Symbol symbol2;
        symbol2 = symbol1;
        if (symbol3.weight < symbol1.weight)
        {
            symbol2 = symbol;
        }
_L9:
label0:
        {
            symbol1 = symbol2.next;
            if (symbol1 != null && symbol3.weight >= symbol1.weight)
            {
                break label0;
            }
            symbol3.next = symbol1;
            symbol2.next = symbol3;
            symbol1 = symbol3;
        }
          goto _L8
        symbol2 = symbol1;
          goto _L9
_L4:
        i = domain;
        symbol1 = symbol;
_L13:
        Symbol symbol4 = symbol;
        Symbol symbol6 = symbol4.next;
        symbol2 = symbol6.next;
        symbol = symbols[i];
        i++;
        symbol.weight = symbol4.weight + symbol6.weight;
        symbol.zero = symbol4;
        symbol.one = symbol6;
        symbol.back = null;
        symbol4.back = symbol;
        symbol6.back = symbol;
        if (symbol2 != null) goto _L11; else goto _L10
_L10:
        table = symbol;
        upToDate = true;
_L2:
        return;
_L11:
        if (symbol.weight < symbol2.weight)
        {
            symbol.next = symbol2;
            symbol1 = symbol;
            continue; /* Loop/switch isn't completed */
        }
        Symbol symbol5;
        do
        {
            symbol5 = symbol1.next;
            if (symbol5 != null && symbol.weight >= symbol5.weight)
            {
                symbol1 = symbol5;
            } else
            {
                break;
            }
        } while (true);
        symbol.next = symbol5;
        symbol1.next = symbol;
        symbol1 = symbol;
        symbol = symbol2;
        if (true) goto _L13; else goto _L12
_L12:
          goto _L8
    }

    public boolean postMortem(PostMortem postmortem)
    {
        for (int i = 0; i < domain; i++)
        {
            if (!postMortem(i))
            {
                JSONzip.log("\nBad huff ");
                JSONzip.logchar(i, i);
                return false;
            }
        }

        return table.postMortem(((Huff)postmortem).table);
    }

    public int read(BitReader bitreader)
        throws JSONException
    {
        Symbol symbol;
        width = 0;
        symbol = table;
_L2:
        do
        {
            if (symbol.integer != -1)
            {
                break MISSING_BLOCK_LABEL_53;
            }
            width = width + 1;
            if (!bitreader.bit())
            {
                break MISSING_BLOCK_LABEL_45;
            }
            symbol = symbol.one;
        } while (true);
        int i;
        try
        {
            symbol = symbol.zero;
        }
        // Misplaced declaration of an exception variable
        catch (BitReader bitreader)
        {
            throw new JSONException(bitreader);
        }
        if (true) goto _L2; else goto _L1
_L1:
        tick(symbol.integer);
        i = symbol.integer;
        return i;
    }

    public void tick(int i)
    {
        Symbol symbol = symbols[i];
        symbol.weight = symbol.weight + 1L;
        upToDate = false;
    }

    public void tick(int i, int j)
    {
        for (; i <= j; i++)
        {
            tick(i);
        }

    }

    public void write(int i, BitWriter bitwriter)
        throws JSONException
    {
        width = 0;
        write(symbols[i], bitwriter);
        tick(i);
    }
}
