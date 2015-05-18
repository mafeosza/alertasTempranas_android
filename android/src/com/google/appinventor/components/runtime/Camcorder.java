// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import java.io.File;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, ActivityResultListener, Component, ComponentContainer, 
//            EventDispatcher, Form

public class Camcorder extends AndroidNonvisibleComponent
    implements ActivityResultListener, Component
{

    private static final String CAMCORDER_INTENT = "android.media.action.VIDEO_CAPTURE";
    private final ComponentContainer container;
    private int requestCode;

    public Camcorder(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        container = componentcontainer;
    }

    private void deleteFile(Uri uri)
    {
        File file = new File(uri.getPath());
        if (file.delete())
        {
            Log.i("CamcorderComponent", (new StringBuilder()).append("Deleted file ").append(uri.toString()).toString());
            return;
        }
        try
        {
            Log.i("CamcorderComponent", (new StringBuilder()).append("Could not delete file ").append(uri.toString()).toString());
            return;
        }
        catch (SecurityException securityexception)
        {
            Log.i("CamcorderComponent", (new StringBuilder()).append("Got security exception trying to delete file ").append(uri.toString()).toString());
        }
        return;
    }

    public void AfterRecording(String s)
    {
        EventDispatcher.dispatchEvent(this, "AfterRecording", new Object[] {
            s
        });
    }

    public void RecordVideo()
    {
        Object obj = Environment.getExternalStorageState();
        if ("mounted".equals(obj))
        {
            Log.i("CamcorderComponent", "External storage is available and writable");
            if (requestCode == 0)
            {
                requestCode = form.registerForActivityResult(this);
            }
            obj = new Intent("android.media.action.VIDEO_CAPTURE");
            container.$context().startActivityForResult(((Intent) (obj)), requestCode);
            return;
        }
        if ("mounted_ro".equals(obj))
        {
            form.dispatchErrorOccurredEvent(this, "RecordVideo", 704, new Object[0]);
            return;
        } else
        {
            form.dispatchErrorOccurredEvent(this, "RecordVideo", 705, new Object[0]);
            return;
        }
    }

    public void resultReturned(int i, int j, Intent intent)
    {
        Log.i("CamcorderComponent", (new StringBuilder()).append("Returning result. Request code = ").append(i).append(", result code = ").append(j).toString());
        if (i == requestCode && j == -1)
        {
            if (intent != null && intent.getData() != null)
            {
                intent = intent.getData();
                Log.i("CamcorderComponent", (new StringBuilder()).append("Calling Camcorder.AfterPicture with clip path ").append(intent.toString()).toString());
                AfterRecording(intent.toString());
                return;
            } else
            {
                Log.i("CamcorderComponent", "Couldn't find a clip file from the Camcorder result");
                form.dispatchErrorOccurredEvent(this, "TakeVideo", 1201, new Object[0]);
                return;
            }
        } else
        {
            Log.i("CamcorderComponent", "No clip filed rerturn; request failed");
            form.dispatchErrorOccurredEvent(this, "TakeVideo", 1201, new Object[0]);
            return;
        }
    }
}
