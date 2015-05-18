// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.google.appinventor.components.runtime.util.HoneycombUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Picker, ActivityResultListener, ComponentContainer, Form

public class ContactPicker extends Picker
    implements ActivityResultListener
{

    private static String CONTACT_PROJECTION[];
    private static String DATA_PROJECTION[];
    private static final int EMAIL_INDEX = 1;
    private static final int NAME_INDEX = 0;
    private static final int PHONE_INDEX = 2;
    private static final String PROJECTION[] = {
        "name", "primary_email"
    };
    protected final Activity activityContext;
    protected String contactName;
    protected String contactPictureUri;
    protected String emailAddress;
    protected List emailAddressList;
    private final Uri intentUri;
    protected String phoneNumber;
    protected List phoneNumberList;

    public ContactPicker(ComponentContainer componentcontainer)
    {
        this(componentcontainer, android.provider.Contacts.People.CONTENT_URI);
    }

    protected ContactPicker(ComponentContainer componentcontainer, Uri uri)
    {
        super(componentcontainer);
        activityContext = componentcontainer.$context();
        if (SdkLevel.getLevel() >= 12 && uri.equals(android.provider.Contacts.People.CONTENT_URI))
        {
            intentUri = HoneycombUtil.getContentUri();
            return;
        }
        if (SdkLevel.getLevel() >= 12 && uri.equals(android.provider.Contacts.Phones.CONTENT_URI))
        {
            intentUri = HoneycombUtil.getPhoneContentUri();
            return;
        } else
        {
            intentUri = uri;
            return;
        }
    }

    public String ContactName()
    {
        return ensureNotNull(contactName);
    }

    public String EmailAddress()
    {
        return ensureNotNull(emailAddress);
    }

    public List EmailAddressList()
    {
        return ensureNotNull(emailAddressList);
    }

    public String PhoneNumber()
    {
        return ensureNotNull(phoneNumber);
    }

    public List PhoneNumberList()
    {
        return ensureNotNull(phoneNumberList);
    }

    public String Picture()
    {
        return ensureNotNull(contactPictureUri);
    }

    protected boolean checkContactUri(Uri uri, String s)
    {
        Log.i("ContactPicker", (new StringBuilder()).append("contactUri is ").append(uri).toString());
        if (uri == null || !"content".equals(uri.getScheme()))
        {
            Log.i("ContactPicker", "checkContactUri failed: A");
            puntContactSelection(1107);
            return false;
        }
        if (!uri.getSchemeSpecificPart().startsWith(s))
        {
            Log.i("ContactPicker", "checkContactUri failed: C");
            Log.i("ContactPicker", uri.getPath());
            puntContactSelection(1107);
            return false;
        } else
        {
            return true;
        }
    }

    protected String ensureNotNull(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return s1;
    }

    protected List ensureNotNull(List list)
    {
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        return ((List) (obj));
    }

    protected String getEmailAddress(String s)
    {
        Object obj;
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        s = "";
        obj = (new StringBuilder()).append("contact_methods._id = ").append(i).toString();
        obj = activityContext.getContentResolver().query(android.provider.Contacts.ContactMethods.CONTENT_EMAIL_URI, new String[] {
            "data"
        }, ((String) (obj)), null, null);
        if (((Cursor) (obj)).moveToFirst())
        {
            s = guardCursorGetString(((Cursor) (obj)), 0);
        }
        ((Cursor) (obj)).close();
        return ensureNotNull(s);
        s;
        ((Cursor) (obj)).close();
        throw s;
    }

    protected Intent getIntent()
    {
        return new Intent("android.intent.action.PICK", intentUri);
    }

    protected String guardCursorGetString(Cursor cursor, int i)
    {
        try
        {
            cursor = cursor.getString(i);
        }
        // Misplaced declaration of an exception variable
        catch (Cursor cursor)
        {
            cursor = "";
        }
        return ensureNotNull(cursor);
    }

    public void postHoneycombGetContactEmailAndPhone(Cursor cursor)
    {
        phoneNumber = "";
        emailAddress = "";
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        if (cursor.moveToFirst())
        {
            int i = HoneycombUtil.getPhoneIndex(cursor);
            int j = HoneycombUtil.getEmailIndex(cursor);
            int k = HoneycombUtil.getMimeIndex(cursor);
            String s = HoneycombUtil.getPhoneType();
            String s1 = HoneycombUtil.getEmailType();
            while (!cursor.isAfterLast()) 
            {
                String s2 = guardCursorGetString(cursor, k);
                if (s2.contains(s))
                {
                    arraylist.add(guardCursorGetString(cursor, i));
                } else
                if (s2.contains(s1))
                {
                    arraylist1.add(guardCursorGetString(cursor, j));
                } else
                {
                    Log.i("ContactPicker", (new StringBuilder()).append("Type mismatch: ").append(s2).append(" not ").append(s).append(" or ").append(s1).toString());
                }
                cursor.moveToNext();
            }
        }
        if (!arraylist.isEmpty())
        {
            phoneNumber = (String)arraylist.get(0);
        }
        if (!arraylist1.isEmpty())
        {
            emailAddress = (String)arraylist1.get(0);
        }
        phoneNumberList = arraylist;
        emailAddressList = arraylist1;
    }

    public String postHoneycombGetContactNameAndPicture(Cursor cursor)
    {
        String s = "";
        if (cursor.moveToFirst())
        {
            int i = HoneycombUtil.getIdIndex(cursor);
            int j = HoneycombUtil.getNameIndex(cursor);
            int k = HoneycombUtil.getThumbnailIndex(cursor);
            int l = HoneycombUtil.getPhotoIndex(cursor);
            s = guardCursorGetString(cursor, i);
            contactName = guardCursorGetString(cursor, j);
            contactPictureUri = guardCursorGetString(cursor, k);
            Log.i("ContactPicker", (new StringBuilder()).append("photo_uri=").append(guardCursorGetString(cursor, l)).toString());
        }
        return s;
    }

    public void preHoneycombGetContactInfo(Cursor cursor, Uri uri)
    {
        if (cursor.moveToFirst())
        {
            contactName = guardCursorGetString(cursor, 0);
            emailAddress = getEmailAddress(guardCursorGetString(cursor, 1));
            contactPictureUri = uri.toString();
            if (emailAddress.equals(""))
            {
                cursor = new ArrayList();
            } else
            {
                cursor = Arrays.asList(new String[] {
                    emailAddress
                });
            }
            emailAddressList = cursor;
        }
    }

    protected void puntContactSelection(int i)
    {
        contactName = "";
        emailAddress = "";
        contactPictureUri = "";
        container.$form().dispatchErrorOccurredEvent(this, "", i, new Object[0]);
    }

    public void resultReturned(int i, int j, Intent intent)
    {
        if (i != requestCode || j != -1) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Object obj2;
        Cursor cursor;
        Object obj3;
        Object obj4;
        String s;
        Object obj5;
        Uri uri;
        Log.i("ContactPicker", (new StringBuilder()).append("received intent is ").append(intent).toString());
        uri = intent.getData();
        if (SdkLevel.getLevel() >= 12)
        {
            intent = "//com.android.contacts/contact";
        } else
        {
            intent = "//contacts/people";
        }
        if (!checkContactUri(uri, intent)) goto _L4; else goto _L3
_L3:
        obj5 = null;
        cursor = null;
        obj3 = null;
        obj4 = null;
        s = null;
        intent = cursor;
        obj1 = obj3;
        obj = obj5;
        obj2 = obj4;
        if (SdkLevel.getLevel() < 12) goto _L6; else goto _L5
_L5:
        intent = cursor;
        obj1 = obj3;
        obj = obj5;
        obj2 = obj4;
        CONTACT_PROJECTION = HoneycombUtil.getContactProjection();
        intent = cursor;
        obj1 = obj3;
        obj = obj5;
        obj2 = obj4;
        cursor = activityContext.getContentResolver().query(uri, CONTACT_PROJECTION, null, null, null);
        intent = cursor;
        obj1 = obj3;
        obj = cursor;
        obj2 = obj4;
        s = postHoneycombGetContactNameAndPicture(cursor);
        intent = cursor;
        obj1 = obj3;
        obj = cursor;
        obj2 = obj4;
        DATA_PROJECTION = HoneycombUtil.getDataProjection();
        intent = cursor;
        obj1 = obj3;
        obj = cursor;
        obj2 = obj4;
        obj3 = HoneycombUtil.getDataCursor(s, activityContext, DATA_PROJECTION);
        intent = cursor;
        obj1 = obj3;
        obj = cursor;
        obj2 = obj3;
        postHoneycombGetContactEmailAndPhone(((Cursor) (obj3)));
_L9:
        intent = cursor;
        obj1 = obj3;
        obj = cursor;
        obj2 = obj3;
        Log.i("ContactPicker", (new StringBuilder()).append("Contact name = ").append(contactName).append(", email address = ").append(emailAddress).append(", phone number = ").append(phoneNumber).append(", contactPhotoUri = ").append(contactPictureUri).toString());
        if (cursor != null)
        {
            cursor.close();
        }
        if (obj3 != null)
        {
            ((Cursor) (obj3)).close();
        }
_L4:
        AfterPicking();
_L2:
        return;
_L6:
        intent = cursor;
        obj1 = obj3;
        obj = obj5;
        obj2 = obj4;
        cursor = activityContext.getContentResolver().query(uri, PROJECTION, null, null, null);
        intent = cursor;
        obj1 = obj3;
        obj = cursor;
        obj2 = obj4;
        preHoneycombGetContactInfo(cursor, uri);
        obj3 = s;
        continue; /* Loop/switch isn't completed */
        obj;
        obj = intent;
        obj2 = obj1;
        Log.i("ContactPicker", "checkContactUri failed: D");
        obj = intent;
        obj2 = obj1;
        puntContactSelection(1107);
        if (intent != null)
        {
            intent.close();
        }
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (true) goto _L4; else goto _L7
_L7:
        intent;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        throw intent;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
