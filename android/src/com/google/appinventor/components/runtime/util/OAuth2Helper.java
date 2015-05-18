// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.extensions.android2.auth.GoogleAccountManager;
import java.io.IOException;

public class OAuth2Helper
{

    public static final String PREF_ACCOUNT_NAME = "accountName";
    public static final String PREF_AUTH_TOKEN = "authToken";
    public static final String TAG = "OAuthHelper";
    private static String errorMessage = "Error during OAuth";

    public OAuth2Helper()
    {
    }

    private AccountManagerFuture getAccountManagerResult(Activity activity, GoogleCredential googlecredential, String s, String s1)
    {
        GoogleAccountManager googleaccountmanager = new GoogleAccountManager(activity);
        googleaccountmanager.invalidateAuthToken(googlecredential.getAccessToken());
        AccountManager.get(activity).invalidateAuthToken(s, null);
        googlecredential = googleaccountmanager.getAccountByName(s1);
        if (googlecredential != null)
        {
            Log.i("OAuthHelper", "Getting token by account");
            return googleaccountmanager.getAccountManager().getAuthToken(googlecredential, s, true, null, null);
        } else
        {
            Log.i("OAuthHelper", "Getting token by features, possibly prompting user to select an account");
            return googleaccountmanager.getAccountManager().getAuthTokenByFeatures("com.google", s, null, activity, null, null, null, null);
        }
    }

    public static String getErrorMessage()
    {
        Log.i("OAuthHelper", (new StringBuilder()).append("getErrorMessage = ").append(errorMessage).toString());
        return errorMessage;
    }

    private boolean isUiThread()
    {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    private void persistCredentials(SharedPreferences sharedpreferences, String s, String s1)
    {
        Log.i("OAuthHelper", (new StringBuilder()).append("Persisting credentials, acct =").append(s).toString());
        sharedpreferences = sharedpreferences.edit();
        sharedpreferences.putString("accountName", s);
        sharedpreferences.putString("authToken", s1);
        sharedpreferences.commit();
    }

    public static void resetAccountCredential(Activity activity)
    {
        Log.i("OAuthHelper", "Reset credentials");
        activity = activity.getPreferences(0).edit();
        activity.remove("authToken");
        activity.remove("accountName");
        activity.commit();
    }

    public String getRefreshedAuthToken(Activity activity, String s)
    {
        Log.i("OAuthHelper", "getRefreshedAuthToken()");
        if (isUiThread())
        {
            throw new IllegalArgumentException("Can't get authtoken from UI thread");
        }
        SharedPreferences sharedpreferences = activity.getPreferences(0);
        String s2 = sharedpreferences.getString("accountName", null);
        String s1 = sharedpreferences.getString("authToken", null);
        Object obj = new GoogleCredential();
        ((GoogleCredential) (obj)).setAccessToken(s1);
        s = getAccountManagerResult(activity, ((GoogleCredential) (obj)), s, s2);
        s2 = s1;
        obj = s1;
        String s3 = s1;
        Bundle bundle;
        try
        {
            bundle = (Bundle)s.getResult();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            resetAccountCredential(activity);
            errorMessage = "Error: operation cancelled";
            return s2;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.printStackTrace();
            errorMessage = "Error: Authenticator error";
            return ((String) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            activity.printStackTrace();
            errorMessage = "Error: I/O error";
            return s3;
        }
        s2 = s1;
        obj = s1;
        s3 = s1;
        s = bundle.get("authtoken").toString();
        s2 = s;
        obj = s;
        s3 = s;
        persistCredentials(sharedpreferences, bundle.getString("authAccount"), s);
        return s;
    }

}
