// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;


// Referenced classes of package org.json.zip:
//            PostMortem, TrieKeep, JSONzip

class next
    implements PostMortem
{

    private int integer;
    private set next[];
    private final TrieKeep this$0;

    public next get(byte byte0)
    {
        return get(byte0 & 0xff);
    }

    public get get(int i)
    {
        if (next == null)
        {
            return null;
        } else
        {
            return next[i];
        }
    }

    public boolean postMortem(PostMortem postmortem)
    {
        postmortem = (next)postmortem;
        if (postmortem != null) goto _L2; else goto _L1
_L1:
        JSONzip.log("\nMisalign");
_L6:
        return false;
_L2:
        int i;
        if (integer != ((integer) (postmortem)).integer)
        {
            JSONzip.log("\nInteger " + integer + " <> " + ((integer) (postmortem)).integer);
            return false;
        }
        if (next == null)
        {
            if (((next) (postmortem)).next == null)
            {
                return true;
            } else
            {
                JSONzip.log("\nNext is null " + integer);
                return false;
            }
        }
        i = 0;
_L7:
        next next1;
        if (i >= 256)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        next1 = next[i];
        if (next1 == null) goto _L4; else goto _L3
_L3:
        if (!next1.postMortem(((PostMortem) (((postMortem) (postmortem)).next[i])))) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        if (((next) (postmortem)).next[i] == null) goto _L5; else goto _L8
_L8:
        JSONzip.log("\nMisalign " + i);
        return false;
        return true;
    }

    public void set(byte byte0, next next1)
    {
        set(byte0 & 0xff, next1);
    }

    public void set(int i, set set1)
    {
        if (next == null)
        {
            next = new next[256];
        }
        next[i] = set1;
    }

    public next vet(byte byte0)
    {
        return vet(byte0 & 0xff);
    }

    public vet vet(int i)
    {
        vet vet2 = get(i);
        vet vet1 = vet2;
        if (vet2 == null)
        {
            vet1 = new <init>();
            set(i, vet1);
        }
        return vet1;
    }



/*
    static int access$002( , int i)
    {
        .integer = i;
        return i;
    }

*/

    public integer()
    {
        this$0 = TrieKeep.this;
        integer = -1;
        next = null;
    }
}
