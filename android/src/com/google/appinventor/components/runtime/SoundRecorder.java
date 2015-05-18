// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;
import com.google.appinventor.components.runtime.util.FileUtil;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, EventDispatcher, 
//            Form

public final class SoundRecorder extends AndroidNonvisibleComponent
    implements Component, android.media.MediaRecorder.OnErrorListener, android.media.MediaRecorder.OnInfoListener
{
    private class RecordingController
    {

        final String file;
        final MediaRecorder recorder = new MediaRecorder();
        final SoundRecorder this$0;

        void start()
            throws IllegalStateException
        {
            Log.i("SoundRecorder", "starting");
            try
            {
                recorder.start();
                return;
            }
            catch (IllegalStateException illegalstateexception)
            {
                Log.e("SoundRecorder", "got IllegalStateException. Are there two recorders running?", illegalstateexception);
            }
            throw new IllegalStateException("Is there another recording running?");
        }

        void stop()
        {
            recorder.setOnErrorListener(null);
            recorder.setOnInfoListener(null);
            recorder.stop();
            recorder.reset();
            recorder.release();
        }

        RecordingController(String s)
            throws IOException
        {
            this$0 = SoundRecorder.this;
            super();
            String s1 = s;
            if (s.equals(""))
            {
                s1 = FileUtil.getRecordingFile("3gp").getAbsolutePath();
            }
            file = s1;
            recorder.setAudioSource(1);
            recorder.setOutputFormat(1);
            recorder.setAudioEncoder(1);
            Log.i("SoundRecorder", (new StringBuilder()).append("Setting output file to ").append(file).toString());
            recorder.setOutputFile(file);
            Log.i("SoundRecorder", "preparing");
            recorder.prepare();
            recorder.setOnErrorListener(SoundRecorder.this);
            recorder.setOnInfoListener(SoundRecorder.this);
        }
    }


    private static final String TAG = "SoundRecorder";
    private RecordingController controller;
    private String savedRecording;

    public SoundRecorder(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        savedRecording = "";
    }

    public void AfterSoundRecorded(String s)
    {
        EventDispatcher.dispatchEvent(this, "AfterSoundRecorded", new Object[] {
            s
        });
    }

    public String SavedRecording()
    {
        return savedRecording;
    }

    public void SavedRecording(String s)
    {
        savedRecording = s;
    }

    public void Start()
    {
        if (controller != null)
        {
            Log.i("SoundRecorder", (new StringBuilder()).append("Start() called, but already recording to ").append(controller.file).toString());
            return;
        }
        Log.i("SoundRecorder", "Start() called");
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            form.dispatchErrorOccurredEvent(this, "Start", 705, new Object[0]);
            return;
        }
        try
        {
            controller = new RecordingController(savedRecording);
        }
        catch (Throwable throwable)
        {
            form.dispatchErrorOccurredEvent(this, "Start", 802, new Object[] {
                throwable.getMessage()
            });
            return;
        }
        try
        {
            controller.start();
        }
        catch (Throwable throwable1)
        {
            controller = null;
            form.dispatchErrorOccurredEvent(this, "Start", 802, new Object[] {
                throwable1.getMessage()
            });
            return;
        }
        StartedRecording();
    }

    public void StartedRecording()
    {
        EventDispatcher.dispatchEvent(this, "StartedRecording", new Object[0]);
    }

    public void Stop()
    {
        if (controller == null)
        {
            Log.i("SoundRecorder", "Stop() called, but already stopped.");
            return;
        }
        Log.i("SoundRecorder", "Stop() called");
        Log.i("SoundRecorder", "stopping");
        controller.stop();
        Log.i("SoundRecorder", (new StringBuilder()).append("Firing AfterSoundRecorded with ").append(controller.file).toString());
        AfterSoundRecorded(controller.file);
        controller = null;
        StoppedRecording();
        return;
        Object obj;
        obj;
        form.dispatchErrorOccurredEvent(this, "Stop", 801, new Object[0]);
        controller = null;
        StoppedRecording();
        return;
        obj;
        controller = null;
        StoppedRecording();
        throw obj;
    }

    public void StoppedRecording()
    {
        EventDispatcher.dispatchEvent(this, "StoppedRecording", new Object[0]);
    }

    public void onError(MediaRecorder mediarecorder, int i, int j)
    {
        if (controller == null || mediarecorder != controller.recorder)
        {
            Log.w("SoundRecorder", "onError called with wrong recorder. Ignoring.");
            return;
        }
        form.dispatchErrorOccurredEvent(this, "onError", 801, new Object[0]);
        controller.stop();
        controller = null;
        StoppedRecording();
        return;
        mediarecorder;
        Log.w("SoundRecorder", mediarecorder.getMessage());
        controller = null;
        StoppedRecording();
        return;
        mediarecorder;
        controller = null;
        StoppedRecording();
        throw mediarecorder;
    }

    public void onInfo(MediaRecorder mediarecorder, int i, int j)
    {
        if (controller == null || mediarecorder != controller.recorder)
        {
            Log.w("SoundRecorder", "onInfo called with wrong recorder. Ignoring.");
            return;
        } else
        {
            Log.i("SoundRecorder", "Recoverable condition while recording. Will attempt to stop normally.");
            controller.recorder.stop();
            return;
        }
    }
}
