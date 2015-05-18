// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.io.InputStream;

public class HoneycombUtil
{

    private HoneycombUtil()
    {
    }

    public static int getContactIdIndex(Cursor cursor)
    {
        return cursor.getColumnIndex("contact_id");
    }

    public static String[] getContactProjection()
    {
        return (new String[] {
            "_id", "display_name", "photo_thumb_uri", "photo_uri"
        });
    }

    public static Uri getContentUri()
    {
        return android.provider.ContactsContract.Contacts.CONTENT_URI;
    }

    public static Uri getDataContentUri()
    {
        return android.provider.ContactsContract.Data.CONTENT_URI;
    }

    public static Cursor getDataCursor(String s, Activity activity, String as[])
    {
        return activity.getContentResolver().query(android.provider.ContactsContract.Data.CONTENT_URI, as, "contact_id=? AND (mimetype=? OR mimetype=?)", new String[] {
            s, "vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/email_v2"
        }, null);
    }

    public static String getDataMimeType()
    {
        return "mimetype";
    }

    public static String[] getDataProjection()
    {
        return (new String[] {
            "mimetype", "data1", "data2", "data1", "data2"
        });
    }

    public static String getDisplayName()
    {
        return "display_name";
    }

    public static String[] getEmailAdapterProjection()
    {
        return (new String[] {
            "_id", "display_name", "data1", "mimetype"
        });
    }

    public static String getEmailAddress()
    {
        return "data1";
    }

    public static int getEmailIndex(Cursor cursor)
    {
        return cursor.getColumnIndex("data1");
    }

    public static String getEmailType()
    {
        return "vnd.android.cursor.item/email_v2";
    }

    public static int getIdIndex(Cursor cursor)
    {
        return cursor.getColumnIndex("_id");
    }

    public static int getMimeIndex(Cursor cursor)
    {
        return cursor.getColumnIndex("mimetype");
    }

    public static int getNameIndex(Cursor cursor)
    {
        return cursor.getColumnIndex("display_name");
    }

    public static String[] getNameProjection()
    {
        return (new String[] {
            "contact_id", "display_name", "photo_thumb_uri", "data1"
        });
    }

    public static Uri getPhoneContentUri()
    {
        return android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    }

    public static int getPhoneIndex(Cursor cursor)
    {
        return cursor.getColumnIndex("data1");
    }

    public static String getPhoneType()
    {
        return "vnd.android.cursor.item/phone_v2";
    }

    public static int getPhotoIndex(Cursor cursor)
    {
        return cursor.getColumnIndex("photo_uri");
    }

    public static int getThumbnailIndex(Cursor cursor)
    {
        return cursor.getColumnIndex("photo_thumb_uri");
    }

    public static String getTimesContacted()
    {
        return "times_contacted";
    }

    public static InputStream openContactPhotoInputStreamHelper(ContentResolver contentresolver, Uri uri)
    {
        return android.provider.ContactsContract.Contacts.openContactPhotoInputStream(contentresolver, uri);
    }
}
