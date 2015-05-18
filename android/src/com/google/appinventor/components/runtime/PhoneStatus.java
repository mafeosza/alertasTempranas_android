// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.util.Log;
import com.google.appinventor.components.runtime.util.AppInvHTTPD;
import com.google.appinventor.components.runtime.util.PackageInstaller;
import java.security.MessageDigest;
import java.util.Formatter;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, EventDispatcher, 
//            Form, ReplForm

public class PhoneStatus extends AndroidNonvisibleComponent
    implements Component
{

    private static final String LOG_TAG = "PhoneStatus";
    private static Activity activity;
    private static PhoneStatus mainInstance = null;
    private final Form form;

    public PhoneStatus(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        form = componentcontainer.$form();
        activity = componentcontainer.$context();
        if (mainInstance == null)
        {
            mainInstance = this;
        }
    }

    public static String GetWifiIpAddress()
    {
        int i = ((WifiManager)activity.getSystemService("wifi")).getDhcpInfo().ipAddress;
        if (isConnected())
        {
            return intToIp(i);
        } else
        {
            return "Error: No Wifi Connection";
        }
    }

    public static void doFault()
        throws Exception
    {
        throw new Exception("doFault called!");
    }

    static void doSettings()
    {
        Log.d("PhoneStatus", "doSettings called.");
        if (mainInstance != null)
        {
            mainInstance.OnSettings();
            return;
        } else
        {
            Log.d("PhoneStatus", "mainStance is null on doSettings");
            return;
        }
    }

    public static String intToIp(int i)
    {
        return (new StringBuilder()).append(i & 0xff).append(".").append(i >> 8 & 0xff).append(".").append(i >> 16 & 0xff).append(".").append(i >> 24 & 0xff).toString();
    }

    public static boolean isConnected()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)activity.getSystemService("connectivity");
        NetworkInfo networkinfo = null;
        if (connectivitymanager != null)
        {
            networkinfo = connectivitymanager.getNetworkInfo(1);
        }
        if (networkinfo == null)
        {
            return false;
        } else
        {
            return networkinfo.isConnected();
        }
    }

    public void OnSettings()
    {
        EventDispatcher.dispatchEvent(this, "OnSettings", new Object[0]);
    }

    public String getVersionName()
    {
        String s;
        try
        {
            s = form.getPackageManager().getPackageInfo(form.getPackageName(), 0).versionName;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.e("PhoneStatus", "Exception fetching package name.", namenotfoundexception);
            return "";
        }
        return s;
    }

    public void installURL(String s)
    {
        PackageInstaller.doPackageInstall(form, s);
    }

    public boolean isDirect()
    {
        Log.d("PhoneStatus", (new StringBuilder()).append("android.os.Build.VERSION.RELEASE = ").append(android.os.Build.VERSION.RELEASE).toString());
        Log.d("PhoneStatus", (new StringBuilder()).append("android.os.Build.PRODUCT = ").append(Build.PRODUCT).toString());
        if (Build.PRODUCT.contains("google_sdk"))
        {
            return true;
        }
        if (form instanceof ReplForm)
        {
            return ((ReplForm)form).isDirect();
        } else
        {
            return false;
        }
    }

    public void setAssetsLoaded()
    {
        if (form instanceof ReplForm)
        {
            ((ReplForm)form).setAssetsLoaded();
        }
    }

    public String setHmacSeedReturnCode(String s)
    {
        AppInvHTTPD.setHmacKey(s);
        MessageDigest messagedigest;
        byte abyte0[];
        StringBuffer stringbuffer;
        Formatter formatter;
        int j;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA1");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("PhoneStatus", "Exception getting SHA1 Instance", s);
            return "";
        }
        messagedigest.update(s.getBytes());
        abyte0 = messagedigest.digest();
        stringbuffer = new StringBuffer(abyte0.length * 2);
        formatter = new Formatter(stringbuffer);
        j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            formatter.format("%02x", new Object[] {
                Byte.valueOf(abyte0[i])
            });
        }

        Log.d("PhoneStatus", (new StringBuilder()).append("Seed = ").append(s).toString());
        Log.d("PhoneStatus", (new StringBuilder()).append("Code = ").append(stringbuffer.toString()).toString());
        return stringbuffer.toString();
    }

    public void shutdown()
    {
        form.finish();
        System.exit(0);
    }

    public void startHTTPD(boolean flag)
    {
        ReplForm.topform.startHTTPD(flag);
    }

}
