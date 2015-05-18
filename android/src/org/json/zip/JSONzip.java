// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import java.io.PrintStream;

// Referenced classes of package org.json.zip:
//            None, PostMortem, Huff, MapKeep, 
//            TrieKeep

public abstract class JSONzip
    implements None, PostMortem
{

    public static final byte bcd[] = {
        48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 
        46, 45, 43, 69
    };
    public static final int end = 256;
    public static final int endOfNumber = bcd.length;
    public static final long int14 = 16384L;
    public static final long int4 = 16L;
    public static final long int7 = 128L;
    public static final int maxSubstringLength = 10;
    public static final int minSubstringLength = 3;
    public static final boolean probe = false;
    public static final int substringLimit = 40;
    public static final int twos[] = {
        1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 
        1024, 2048, 4096, 8192, 16384, 32768, 0x10000
    };
    public static final int zipArrayString = 6;
    public static final int zipArrayValue = 7;
    public static final int zipEmptyArray = 1;
    public static final int zipEmptyObject = 0;
    public static final int zipFalse = 3;
    public static final int zipNull = 4;
    public static final int zipObject = 5;
    public static final int zipTrue = 2;
    protected final Huff namehuff = new Huff(257);
    protected final MapKeep namekeep = new MapKeep(9);
    protected final MapKeep stringkeep = new MapKeep(11);
    protected final Huff substringhuff = new Huff(257);
    protected final TrieKeep substringkeep = new TrieKeep(12);
    protected final MapKeep values = new MapKeep(10);

    protected JSONzip()
    {
        namehuff.tick(32, 125);
        namehuff.tick(97, 122);
        namehuff.tick(256);
        namehuff.tick(256);
        substringhuff.tick(32, 125);
        substringhuff.tick(97, 122);
        substringhuff.tick(256);
        substringhuff.tick(256);
    }

    static void log()
    {
        log("\n");
    }

    static void log(int i)
    {
        log(i + " ");
    }

    static void log(int i, int j)
    {
        log(i + ":" + j + " ");
    }

    static void log(String s)
    {
        System.out.print(s);
    }

    static void logchar(int i, int j)
    {
        if (i > 32 && i <= 125)
        {
            log("'" + (char)i + "':" + j + " ");
            return;
        } else
        {
            log(i, j);
            return;
        }
    }

    protected void begin()
    {
        namehuff.generate();
        substringhuff.generate();
    }

    public boolean postMortem(PostMortem postmortem)
    {
        postmortem = (JSONzip)postmortem;
        return namehuff.postMortem(((JSONzip) (postmortem)).namehuff) && namekeep.postMortem(((JSONzip) (postmortem)).namekeep) && stringkeep.postMortem(((JSONzip) (postmortem)).stringkeep) && substringhuff.postMortem(((JSONzip) (postmortem)).substringhuff) && substringkeep.postMortem(((JSONzip) (postmortem)).substringkeep) && values.postMortem(((JSONzip) (postmortem)).values);
    }

}
