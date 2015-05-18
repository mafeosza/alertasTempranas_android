// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.media.SoundPool;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, OnResumeListener, OnStopListener, 
//            OnDestroyListener, Deleteable, ComponentContainer, Form

public class Sound extends AndroidNonvisibleComponent
    implements Component, OnResumeListener, OnStopListener, OnDestroyListener, Deleteable
{
    private class OnLoadHelper
    {

        final Sound this$0;

        public void setOnloadCompleteListener(SoundPool soundpool)
        {
            soundpool.setOnLoadCompleteListener(new android.media.SoundPool.OnLoadCompleteListener() {

                final OnLoadHelper this$1;

                public void onLoadComplete(SoundPool soundpool, int i, int j)
                {
                    loadComplete = true;
                }

            
            {
                this$1 = OnLoadHelper.this;
                super();
            }
            });
        }

        private OnLoadHelper()
        {
            this$0 = Sound.this;
            super();
        }

    }


    private static final int LOOP_MODE_NO_LOOP = 0;
    private static final int MAX_PLAY_DELAY_RETRIES = 10;
    private static final int MAX_STREAMS = 10;
    private static final float PLAYBACK_RATE_NORMAL = 1F;
    private static final int PLAY_DELAY_LENGTH = 50;
    private static final float VOLUME_FULL = 1F;
    private int delayRetries;
    private boolean loadComplete;
    private int minimumInterval;
    private final Handler playWaitHandler = new Handler();
    private int soundId;
    private final Map soundMap = new HashMap();
    private SoundPool soundPool;
    private String sourcePath;
    private int streamId;
    private final Component thisComponent = this;
    private long timeLastPlayed;
    private final Vibrator vibe;
    private final boolean waitForLoadToComplete;

    public Sound(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        boolean flag;
        if (SdkLevel.getLevel() >= 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        waitForLoadToComplete = flag;
        soundPool = new SoundPool(10, 3, 0);
        vibe = (Vibrator)form.getSystemService("vibrator");
        sourcePath = "";
        loadComplete = true;
        form.registerForOnResume(this);
        form.registerForOnStop(this);
        form.registerForOnDestroy(this);
        form.setVolumeControlStream(3);
        MinimumInterval(500);
        if (waitForLoadToComplete)
        {
            (new OnLoadHelper()).setOnloadCompleteListener(soundPool);
        }
    }

    private void playAndCheckResult()
    {
        streamId = soundPool.play(soundId, 1.0F, 1.0F, 0, 0, 1.0F);
        Log.i("Sound", (new StringBuilder()).append("SoundPool.play returned stream id ").append(streamId).toString());
        if (streamId == 0)
        {
            form.dispatchErrorOccurredEvent(this, "Play", 703, new Object[] {
                sourcePath
            });
        }
    }

    private void playWhenLoadComplete()
    {
        if (loadComplete || !waitForLoadToComplete)
        {
            playAndCheckResult();
            return;
        } else
        {
            Log.i("Sound", (new StringBuilder()).append("Sound not ready:  retrying.  Remaining retries = ").append(delayRetries).toString());
            playWaitHandler.postDelayed(new Runnable() , 50L);
            return;
        }
    }

    private void prepareToDie()
    {
        if (streamId != 0)
        {
            soundPool.stop(streamId);
            soundPool.unload(streamId);
        }
        soundPool.release();
        vibe.cancel();
        soundPool = null;
    }

    public int MinimumInterval()
    {
        return minimumInterval;
    }

    public void MinimumInterval(int i)
    {
        minimumInterval = i;
    }

    public void Pause()
    {
        if (streamId != 0)
        {
            soundPool.pause(streamId);
            return;
        } else
        {
            Log.i("Sound", "Unable to pause. Did you remember to call the Play function?");
            return;
        }
    }

    public void Play()
    {
        if (soundId != 0)
        {
            long l = System.currentTimeMillis();
            if (timeLastPlayed == 0L || l >= timeLastPlayed + (long)minimumInterval)
            {
                timeLastPlayed = l;
                delayRetries = 10;
                playWhenLoadComplete();
                return;
            } else
            {
                Log.i("Sound", "Unable to play because MinimumInterval has not elapsed since last play.");
                return;
            }
        } else
        {
            Log.i("Sound", "Sound Id was 0. Did you remember to set the Source property?");
            form.dispatchErrorOccurredEvent(this, "Play", 703, new Object[] {
                sourcePath
            });
            return;
        }
    }

    public void Resume()
    {
        if (streamId != 0)
        {
            soundPool.resume(streamId);
            return;
        } else
        {
            Log.i("Sound", "Unable to resume. Did you remember to call the Play function?");
            return;
        }
    }

    public void SoundError(String s)
    {
    }

    public String Source()
    {
        return sourcePath;
    }

    public void Source(String s)
    {
label0:
        {
            String s1 = s;
            if (s == null)
            {
                s1 = "";
            }
            sourcePath = s1;
            if (streamId != 0)
            {
                soundPool.stop(streamId);
                streamId = 0;
            }
            soundId = 0;
            if (sourcePath.length() != 0)
            {
                s = (Integer)soundMap.get(sourcePath);
                if (s == null)
                {
                    break label0;
                }
                soundId = s.intValue();
            }
            return;
        }
        Log.i("Sound", (new StringBuilder()).append("No existing sound with path ").append(sourcePath).append(".").toString());
        int i = MediaUtil.loadSoundPool(soundPool, form, sourcePath);
        if (i != 0)
        {
            try
            {
                soundMap.put(sourcePath, Integer.valueOf(i));
                Log.i("Sound", (new StringBuilder()).append("Successfully began loading sound: setting soundId to ").append(i).append(".").toString());
                soundId = i;
                loadComplete = false;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                form.dispatchErrorOccurredEvent(this, "Source", 701, new Object[] {
                    sourcePath
                });
            }
            return;
        }
        form.dispatchErrorOccurredEvent(this, "Source", 701, new Object[] {
            sourcePath
        });
        return;
    }

    public void Stop()
    {
        if (streamId != 0)
        {
            soundPool.stop(streamId);
            streamId = 0;
            return;
        } else
        {
            Log.i("Sound", "Unable to stop. Did you remember to call the Play function?");
            return;
        }
    }

    public void Vibrate(int i)
    {
        vibe.vibrate(i);
    }

    public void onDelete()
    {
        prepareToDie();
    }

    public void onDestroy()
    {
        prepareToDie();
    }

    public void onResume()
    {
        Log.i("Sound", "Got onResume");
        if (streamId != 0)
        {
            soundPool.resume(streamId);
        }
    }

    public void onStop()
    {
        Log.i("Sound", "Got onStop");
        if (streamId != 0)
        {
            soundPool.pause(streamId);
        }
    }



/*
    static boolean access$002(Sound sound, boolean flag)
    {
        sound.loadComplete = flag;
        return flag;
    }

*/




/*
    static int access$310(Sound sound)
    {
        int i = sound.delayRetries;
        sound.delayRetries = i - 1;
        return i;
    }

*/



}
