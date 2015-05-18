// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.media.AudioManager;
import android.net.http.SslError;
import android.view.Display;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.Player;

public class FroyoUtil
{

    private FroyoUtil()
    {
    }

    public static void abandonFocus(AudioManager audiomanager, Object obj)
    {
        audiomanager.abandonAudioFocus((android.media.AudioManager.OnAudioFocusChangeListener)obj);
    }

    public static boolean focusRequestGranted(AudioManager audiomanager, Object obj)
    {
        return audiomanager.requestAudioFocus((android.media.AudioManager.OnAudioFocusChangeListener)obj, 3, 1) == 1;
    }

    public static int getRotation(Display display)
    {
        return display.getRotation();
    }

    public static WebViewClient getWebViewClient(boolean flag, boolean flag1, Form form, Component component)
    {
        return new WebViewClient(flag1, flag, form, component) {

            final Component val$component;
            final boolean val$followLinks;
            final Form val$form;
            final boolean val$ignoreErrors;

            public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
            {
                if (ignoreErrors)
                {
                    sslerrorhandler.proceed();
                    return;
                } else
                {
                    sslerrorhandler.cancel();
                    form.dispatchErrorOccurredEvent(component, "WebView", 2501, new Object[0]);
                    return;
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webview, String s)
            {
                return !followLinks;
            }

            
            {
                followLinks = flag;
                ignoreErrors = flag1;
                form = form1;
                component = component1;
                super();
            }
        };
    }

    public static Object setAudioFocusChangeListener(Player player)
    {
        return new android.media.AudioManager.OnAudioFocusChangeListener(player) {

            private boolean playbackFlag;
            final Player val$player;

            public void onAudioFocusChange(int i)
            {
                i;
                JVM INSTR tableswitch -3 1: default 36
            //                           -3 37
            //                           -2 37
            //                           -1 68
            //                           0 36
            //                           1 81;
                   goto _L1 _L2 _L2 _L3 _L1 _L4
_L1:
                return;
_L2:
                if (player != null && player.playerState == 2)
                {
                    player.pause();
                    playbackFlag = true;
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L3:
                playbackFlag = false;
                player.OtherPlayerStarted();
                return;
_L4:
                if (player != null && playbackFlag && player.playerState == 4)
                {
                    player.Start();
                    playbackFlag = false;
                    return;
                }
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                player = player1;
                super();
                playbackFlag = false;
            }
        };
    }

    public static AudioManager setAudioManager(Activity activity)
    {
        return (AudioManager)activity.getSystemService("audio");
    }
}
