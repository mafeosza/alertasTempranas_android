// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            Web

static class index extends Exception
{

    final int errorNumber;
    final int index;

    (int i, int j)
    {
        errorNumber = i;
        index = j;
    }
}
