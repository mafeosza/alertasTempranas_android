// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.content.Context;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.acra.util.BoundedLinkedList;

class LogFileCollector
{

    private LogFileCollector()
    {
    }

    public static String collectLogFile(Context context, String s, int i)
        throws IOException
    {
        BoundedLinkedList boundedlinkedlist = new BoundedLinkedList(i);
        if (s.contains("/"))
        {
            context = new BufferedReader(new InputStreamReader(new FileInputStream(s)), 1024);
        } else
        {
            context = new BufferedReader(new InputStreamReader(context.openFileInput(s)), 1024);
        }
        for (s = context.readLine(); s != null; s = context.readLine())
        {
            boundedlinkedlist.add((new StringBuilder()).append(s).append("\n").toString());
        }

        return boundedlinkedlist.toString();
    }
}
