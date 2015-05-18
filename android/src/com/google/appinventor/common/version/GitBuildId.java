// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.common.version;


public final class GitBuildId
{

    public static final String ACRA_URI = "${acra.uri}";
    public static final String ANT_BUILD_DATE = "March 29 2015";
    public static final String GIT_BUILD_FINGERPRINT = "156ee60cc9dd32a97c7043244b26b11a6f743994";
    public static final String GIT_BUILD_VERSION = "nb142";

    private GitBuildId()
    {
    }

    public static String getAcraUri()
    {
        if ("${acra.uri}".equals("${acra.uri}"))
        {
            return "";
        } else
        {
            return "${acra.uri}".trim();
        }
    }

    public static String getDate()
    {
        return "March 29 2015";
    }

    public static String getFingerprint()
    {
        return "156ee60cc9dd32a97c7043244b26b11a6f743994";
    }

    public static String getVersion()
    {
        String s = "nb142";
        if ("nb142" == "" || "nb142".contains(" "))
        {
            s = "none";
        }
        return s;
    }
}
