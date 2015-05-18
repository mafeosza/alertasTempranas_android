// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.util.Log;
import com.google.appinventor.components.runtime.NearField;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.nio.charset.Charset;
import java.util.Locale;

public class GingerbreadUtil
{

    private GingerbreadUtil()
    {
    }

    public static boolean clearCookies(CookieHandler cookiehandler)
    {
        if (cookiehandler instanceof CookieManager)
        {
            cookiehandler = ((CookieManager)cookiehandler).getCookieStore();
            if (cookiehandler != null)
            {
                cookiehandler.removeAll();
                return true;
            }
        }
        return false;
    }

    public static NdefRecord createTextRecord(String s, boolean flag)
    {
        byte abyte0[] = Locale.getDefault().getLanguage().getBytes(Charset.forName("US-ASCII"));
        Object obj;
        int i;
        if (flag)
        {
            obj = Charset.forName("UTF-8");
        } else
        {
            obj = Charset.forName("UTF-16");
        }
        s = s.getBytes(((Charset) (obj)));
        if (flag)
        {
            i = 0;
        } else
        {
            i = 128;
        }
        i = (char)(abyte0.length + i);
        obj = new byte[abyte0.length + 1 + s.length];
        obj[0] = (byte)i;
        System.arraycopy(abyte0, 0, obj, 1, abyte0.length);
        System.arraycopy(s, 0, obj, abyte0.length + 1, s.length);
        return new NdefRecord((short)1, NdefRecord.RTD_TEXT, new byte[0], ((byte []) (obj)));
    }

    public static void disableNFCAdapter(Activity activity, NfcAdapter nfcadapter)
    {
        nfcadapter.disableForegroundNdefPush(activity);
    }

    public static void enableNFCWriteMode(Activity activity, NfcAdapter nfcadapter, String s)
    {
        nfcadapter.enableForegroundNdefPush(activity, new NdefMessage(new NdefRecord[] {
            createTextRecord(s, true)
        }));
    }

    public static CookieHandler newCookieManager()
    {
        return new CookieManager();
    }

    public static NfcAdapter newNfcAdapter(Context context)
    {
        return NfcAdapter.getDefaultAdapter(context);
    }

    public static void resolveNFCIntent(Intent intent, NearField nearfield)
    {
        if (!"android.nfc.action.NDEF_DISCOVERED".equals(intent.getAction()))
        {
            break MISSING_BLOCK_LABEL_190;
        }
        if (!nearfield.ReadMode()) goto _L2; else goto _L1
_L1:
        android.os.Parcelable aparcelable[] = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (aparcelable != null)
        {
            NdefMessage andefmessage[] = new NdefMessage[aparcelable.length];
            int i = 0;
            do
            {
                intent = andefmessage;
                if (i >= aparcelable.length)
                {
                    break;
                }
                andefmessage[i] = (NdefMessage)aparcelable[i];
                i++;
            } while (true);
        } else
        {
            intent = new byte[0];
            NdefMessage ndefmessage = new NdefMessage(new NdefRecord[] {
                new NdefRecord((short)5, intent, intent, intent)
            });
            intent = new NdefMessage[1];
            intent[0] = ndefmessage;
        }
        nearfield.TagRead((new String(intent[0].getRecords()[0].getPayload())).substring(3));
_L4:
        return;
_L2:
        Tag tag;
        tag = (Tag)intent.getParcelableExtra("android.nfc.extra.TAG");
        intent = null;
        if (nearfield.WriteType() == 1)
        {
            intent = new NdefMessage(new NdefRecord[] {
                createTextRecord(nearfield.TextToWrite(), true)
            });
        }
        if (!writeNFCTag(intent, tag)) goto _L4; else goto _L3
_L3:
        nearfield.TagWritten();
        return;
        Log.e("nearfield", (new StringBuilder()).append("Unknown intent ").append(intent).toString());
        return;
    }

    public static boolean writeNFCTag(NdefMessage ndefmessage, Tag tag)
    {
        int i = ndefmessage.toByteArray().length;
        Ndef ndef = Ndef.get(tag);
        if (ndef == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        ndef.connect();
        if (!ndef.isWritable())
        {
            return false;
        }
        if (ndef.getMaxSize() < i)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        ndef.writeNdefMessage(ndefmessage);
        return true;
        tag = NdefFormatable.get(tag);
        if (tag == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        tag.connect();
        tag.format(ndefmessage);
        return true;
        ndefmessage;
        return false;
        ndefmessage;
        return false;
    }
}
