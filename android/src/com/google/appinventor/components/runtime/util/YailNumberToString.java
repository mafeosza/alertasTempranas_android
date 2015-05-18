// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class YailNumberToString
{

    private static final double BIGBOUND = 1000000D;
    static final String LOG_TAG = "YailNumberToString";
    private static final double SMALLBOUND = 9.9999999999999995E-07D;
    private static final String decPattern = "#####0.0####";
    static DecimalFormat decimalFormat;
    static Locale locale;
    static DecimalFormat sciFormat;
    private static final String sciPattern = "0.####E0";
    static DecimalFormatSymbols symbols;

    public YailNumberToString()
    {
    }

    public static String format(double d)
    {
        if (d == Math.rint(d))
        {
            return String.valueOf((int)d);
        }
        double d1 = Math.abs(d);
        if (d1 < 1000000D && d1 > 9.9999999999999995E-07D)
        {
            return decimalFormat.format(d);
        } else
        {
            return sciFormat.format(d);
        }
    }

    static 
    {
        locale = Locale.US;
        symbols = new DecimalFormatSymbols(locale);
        decimalFormat = new DecimalFormat("#####0.0####", symbols);
        sciFormat = new DecimalFormat("0.####E0", symbols);
    }
}
