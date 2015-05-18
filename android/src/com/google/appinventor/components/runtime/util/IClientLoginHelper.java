// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;

public interface IClientLoginHelper
{

    public abstract HttpResponse execute(HttpUriRequest httpurirequest)
        throws ClientProtocolException, IOException;

    public abstract void forgetAccountName();

    public abstract String getAuthToken()
        throws ClientProtocolException;
}
