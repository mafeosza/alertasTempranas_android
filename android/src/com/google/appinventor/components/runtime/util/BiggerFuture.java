// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.RunnableClosure;

public class BiggerFuture extends Thread
{

    public BiggerFuture(Procedure procedure, InPort inport, OutPort outport, OutPort outport1, String s, long l)
    {
        super(new ThreadGroup("biggerthreads"), new RunnableClosure(procedure, inport, outport, outport1), s, l);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("#<future ");
        stringbuffer.append(getName());
        stringbuffer.append(">");
        return stringbuffer.toString();
    }
}
