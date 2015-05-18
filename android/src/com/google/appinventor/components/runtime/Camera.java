// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import java.io.File;
import java.util.Date;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, ActivityResultListener, Component, ComponentContainer, 
//            EventDispatcher, Form

public class Camera extends AndroidNonvisibleComponent
    implements ActivityResultListener, Component
{

    private static final String CAMERA_INTENT = "android.media.action.IMAGE_CAPTURE";
    private static final String CAMERA_OUTPUT = "output";
    private final ComponentContainer container;
    private Uri imageFile;
    private int requestCode;
    private boolean useFront;

    public Camera(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        container = componentcontainer;
        UseFront(false);
    }

    private void deleteFile(Uri uri)
    {
        File file = new File(uri.getPath());
        if (file.delete())
        {
            Log.i("CameraComponent", (new StringBuilder()).append("Deleted file ").append(uri.toString()).toString());
            return;
        }
        try
        {
            Log.i("CameraComponent", (new StringBuilder()).append("Could not delete file ").append(uri.toString()).toString());
            return;
        }
        catch (SecurityException securityexception)
        {
            Log.i("CameraComponent", (new StringBuilder()).append("Got security exception trying to delete file ").append(uri.toString()).toString());
        }
        return;
    }

    public void AfterPicture(String s)
    {
        EventDispatcher.dispatchEvent(this, "AfterPicture", new Object[] {
            s
        });
    }

    public void TakePicture()
    {
        Object obj = new Date();
        Object obj1 = Environment.getExternalStorageState();
        if ("mounted".equals(obj1))
        {
            Log.i("CameraComponent", "External storage is available and writable");
            imageFile = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), (new StringBuilder()).append("/Pictures/app_inventor_").append(((Date) (obj)).getTime()).append(".jpg").toString()));
            obj = new ContentValues();
            ((ContentValues) (obj)).put("_data", imageFile.getPath());
            ((ContentValues) (obj)).put("mime_type", "image/jpeg");
            ((ContentValues) (obj)).put("title", imageFile.getLastPathSegment());
            if (requestCode == 0)
            {
                requestCode = form.registerForActivityResult(this);
            }
            obj = container.$context().getContentResolver().insert(android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI, ((ContentValues) (obj)));
            obj1 = new Intent("android.media.action.IMAGE_CAPTURE");
            ((Intent) (obj1)).putExtra("output", ((android.os.Parcelable) (obj)));
            if (useFront)
            {
                ((Intent) (obj1)).putExtra("android.intent.extras.CAMERA_FACING", 1);
            }
            container.$context().startActivityForResult(((Intent) (obj1)), requestCode);
            return;
        }
        if ("mounted_ro".equals(obj1))
        {
            form.dispatchErrorOccurredEvent(this, "TakePicture", 704, new Object[0]);
            return;
        } else
        {
            form.dispatchErrorOccurredEvent(this, "TakePicture", 705, new Object[0]);
            return;
        }
    }

    public void UseFront(boolean flag)
    {
        useFront = flag;
    }

    public boolean UseFront()
    {
        return useFront;
    }

    public void resultReturned(int i, int j, Intent intent)
    {
        Log.i("CameraComponent", (new StringBuilder()).append("Returning result. Request code = ").append(i).append(", result code = ").append(j).toString());
        if (i == requestCode && j == -1)
        {
            if ((new File(imageFile.getPath())).length() != 0L)
            {
                AfterPicture(imageFile.toString());
                return;
            }
            deleteFile(imageFile);
            if (intent != null && intent.getData() != null)
            {
                intent = intent.getData();
                Log.i("CameraComponent", (new StringBuilder()).append("Calling Camera.AfterPicture with image path ").append(intent.toString()).toString());
                AfterPicture(intent.toString());
                return;
            } else
            {
                Log.i("CameraComponent", "Couldn't find an image file from the Camera result");
                form.dispatchErrorOccurredEvent(this, "TakePicture", 201, new Object[0]);
                return;
            }
        } else
        {
            deleteFile(imageFile);
            return;
        }
    }
}
