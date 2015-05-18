// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.VideoPlayer;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            SdkLevel, CustomMediaController, MediaUtil

public class FullScreenVideoUtil
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener
{

    public static final String ACTION_DATA = "ActionData";
    public static final String ACTION_SUCESS = "ActionSuccess";
    public static final int FULLSCREEN_VIDEO_ACTION_DURATION = 196;
    public static final int FULLSCREEN_VIDEO_ACTION_FULLSCREEN = 195;
    public static final int FULLSCREEN_VIDEO_ACTION_PAUSE = 192;
    public static final int FULLSCREEN_VIDEO_ACTION_PLAY = 191;
    public static final int FULLSCREEN_VIDEO_ACTION_SEEK = 190;
    public static final int FULLSCREEN_VIDEO_ACTION_SOURCE = 194;
    public static final int FULLSCREEN_VIDEO_ACTION_STOP = 193;
    public static final int FULLSCREEN_VIDEO_DIALOG_FLAG = 189;
    public static final String VIDEOPLAYER_FULLSCREEN = "FullScreenKey";
    public static final String VIDEOPLAYER_PLAYING = "PlayingKey";
    public static final String VIDEOPLAYER_POSITION = "PositionKey";
    public static final String VIDEOPLAYER_SOURCE = "SourceKey";
    private Form mForm;
    private VideoPlayer mFullScreenPlayer;
    private Bundle mFullScreenVideoBundle;
    private CustomMediaController mFullScreenVideoController;
    private Dialog mFullScreenVideoDialog;
    private FrameLayout mFullScreenVideoHolder;
    private VideoView mFullScreenVideoView;
    private Handler mHandler;
    private android.widget.FrameLayout.LayoutParams mMediaControllerParams;

    public FullScreenVideoUtil(Form form, Handler handler)
    {
        mMediaControllerParams = new android.widget.FrameLayout.LayoutParams(-1, -2, 80);
        mFullScreenPlayer = null;
        mForm = form;
        mHandler = handler;
        if (SdkLevel.getLevel() > 4)
        {
            mFullScreenVideoDialog = new Dialog(mForm, 0x1030007) {

                final FullScreenVideoUtil this$0;

                public void onBackPressed()
                {
                    Bundle bundle = new Bundle();
                    bundle.putInt("PositionKey", mFullScreenVideoView.getCurrentPosition());
                    bundle.putBoolean("PlayingKey", mFullScreenVideoView.isPlaying());
                    bundle.putString("SourceKey", mFullScreenVideoBundle.getString("SourceKey"));
                    mFullScreenPlayer.fullScreenKilled(bundle);
                    super.onBackPressed();
                }

                public void onStart()
                {
                    super.onStart();
                    startDialog();
                }

            
            {
                this$0 = FullScreenVideoUtil.this;
                super(context, i);
            }
            };
            return;
        } else
        {
            mFullScreenVideoDialog = new Dialog(mForm, 0x1030007) {

                final FullScreenVideoUtil this$0;

                public void onStart()
                {
                    super.onStart();
                    startDialog();
                }

                protected void onStop()
                {
                    Bundle bundle = new Bundle();
                    bundle.putInt("PositionKey", mFullScreenVideoView.getCurrentPosition());
                    bundle.putBoolean("PlayingKey", mFullScreenVideoView.isPlaying());
                    bundle.putString("SourceKey", mFullScreenVideoBundle.getString("SourceKey"));
                    mFullScreenPlayer.fullScreenKilled(bundle);
                    super.onStop();
                }

            
            {
                this$0 = FullScreenVideoUtil.this;
                super(context, i);
            }
            };
            return;
        }
    }

    private Bundle doFullScreenVideoAction(VideoPlayer videoplayer, Bundle bundle)
    {
        Log.i("Form.doFullScreenVideoAction", (new StringBuilder()).append("Source:").append(videoplayer).append(" Data:").append(bundle).toString());
        Bundle bundle1 = new Bundle();
        bundle1.putBoolean("ActionSuccess", true);
        if (bundle.getBoolean("FullScreenKey"))
        {
            mFullScreenPlayer = videoplayer;
            mFullScreenVideoBundle = bundle;
            if (!mFullScreenVideoDialog.isShowing())
            {
                mForm.showDialog(189);
                return bundle1;
            } else
            {
                mFullScreenVideoView.pause();
                bundle1.putBoolean("ActionSuccess", setSource(mFullScreenVideoBundle.getString("SourceKey"), false));
                return bundle1;
            }
        }
        if (showing())
        {
            bundle1.putBoolean("PlayingKey", mFullScreenVideoView.isPlaying());
            bundle1.putInt("PositionKey", mFullScreenVideoView.getCurrentPosition());
            bundle1.putString("SourceKey", mFullScreenVideoBundle.getString("SourceKey"));
            mFullScreenPlayer = null;
            mFullScreenVideoBundle = null;
            mForm.dismissDialog(189);
            return bundle1;
        } else
        {
            bundle1.putBoolean("ActionSuccess", false);
            return bundle1;
        }
    }

    public Dialog createFullScreenVideoDialog()
    {
        if (mFullScreenVideoBundle == null)
        {
            Log.i("Form.createFullScreenVideoDialog", "mFullScreenVideoBundle is null");
        }
        mFullScreenVideoView = new VideoView(mForm);
        mFullScreenVideoHolder = new FrameLayout(mForm);
        mFullScreenVideoController = new CustomMediaController(mForm);
        mFullScreenVideoView.setId(mFullScreenVideoView.hashCode());
        mFullScreenVideoHolder.setId(mFullScreenVideoHolder.hashCode());
        mFullScreenVideoView.setMediaController(mFullScreenVideoController);
        mFullScreenVideoView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final FullScreenVideoUtil this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                Log.i("FullScreenVideoUtil..onTouch", "Video Touched!!");
                return false;
            }

            
            {
                this$0 = FullScreenVideoUtil.this;
                super();
            }
        });
        mFullScreenVideoController.setAnchorView(mFullScreenVideoView);
        String s = mForm.ScreenOrientation();
        if (s.equals("landscape") || s.equals("sensorLandscape") || s.equals("reverseLandscape"))
        {
            mFullScreenVideoView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-2, -1, 17));
        } else
        {
            mFullScreenVideoView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2, 17));
        }
        mFullScreenVideoHolder.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        mFullScreenVideoHolder.addView(mFullScreenVideoView);
        mFullScreenVideoController.addTo(mFullScreenVideoHolder, mMediaControllerParams);
        mFullScreenVideoDialog.setContentView(mFullScreenVideoHolder);
        return mFullScreenVideoDialog;
    }

    public boolean dialogInitialized()
    {
        return mFullScreenVideoDialog != null;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        if (mFullScreenPlayer != null)
        {
            mFullScreenPlayer.Completed();
        }
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        Log.i("FullScreenVideoUtil..onPrepared", (new StringBuilder()).append("Seeking to:").append(mFullScreenVideoBundle.getInt("PositionKey")).toString());
        mFullScreenVideoView.seekTo(mFullScreenVideoBundle.getInt("PositionKey"));
        if (mFullScreenVideoBundle.getBoolean("PlayingKey"))
        {
            mFullScreenVideoView.start();
            return;
        } else
        {
            mFullScreenVideoView.start();
            mHandler.postDelayed(new Runnable() {

                final FullScreenVideoUtil this$0;

                public void run()
                {
                    mFullScreenVideoView.pause();
                }

            
            {
                this$0 = FullScreenVideoUtil.this;
                super();
            }
            }, 100L);
            return;
        }
    }

    public Bundle performAction(int i, VideoPlayer videoplayer, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        Bundle bundle;
        Log.i("Form.fullScreenVideoAction", (new StringBuilder()).append("Actions:").append(i).append(" Source:").append(videoplayer).append(": Current Source:").append(mFullScreenPlayer).append(" Data:").append(obj).toString());
        bundle = new Bundle();
        bundle.putBoolean("ActionSuccess", true);
        if (videoplayer != mFullScreenPlayer) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 190 196: default 484
    //                   190 229
    //                   191 195
    //                   192 156
    //                   193 270
    //                   194 304
    //                   195 143
    //                   196 347;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L3:
        bundle.putBoolean("ActionSuccess", false);
        videoplayer = bundle;
_L11:
        this;
        JVM INSTR monitorexit ;
        return videoplayer;
_L9:
        videoplayer = doFullScreenVideoAction(videoplayer, (Bundle)obj);
          goto _L11
_L6:
        if (!showing()) goto _L13; else goto _L12
_L12:
        mFullScreenVideoView.pause();
        videoplayer = bundle;
          goto _L11
        videoplayer;
        throw videoplayer;
_L13:
        bundle.putBoolean("ActionSuccess", false);
        videoplayer = bundle;
          goto _L11
_L5:
        if (!showing()) goto _L15; else goto _L14
_L14:
        mFullScreenVideoView.start();
        videoplayer = bundle;
          goto _L11
_L15:
        bundle.putBoolean("ActionSuccess", false);
        videoplayer = bundle;
          goto _L11
_L4:
        if (!showing()) goto _L17; else goto _L16
_L16:
        mFullScreenVideoView.seekTo(((Integer)obj).intValue());
        videoplayer = bundle;
          goto _L11
_L17:
        bundle.putBoolean("ActionSuccess", false);
        videoplayer = bundle;
          goto _L11
_L7:
        if (!showing()) goto _L19; else goto _L18
_L18:
        mFullScreenVideoView.stopPlayback();
        videoplayer = bundle;
          goto _L11
_L19:
        bundle.putBoolean("ActionSuccess", false);
        videoplayer = bundle;
          goto _L11
_L8:
        if (!showing()) goto _L21; else goto _L20
_L20:
        bundle.putBoolean("ActionSuccess", setSource((String)obj, true));
        videoplayer = bundle;
          goto _L11
_L21:
        bundle.putBoolean("ActionSuccess", false);
        videoplayer = bundle;
          goto _L11
_L10:
        if (!showing()) goto _L23; else goto _L22
_L22:
        bundle.putInt("ActionData", mFullScreenVideoView.getDuration());
        videoplayer = bundle;
          goto _L11
_L23:
        bundle.putBoolean("ActionSuccess", false);
        videoplayer = bundle;
          goto _L11
_L2:
        if (i != 195) goto _L3; else goto _L24
_L24:
        if (showing() && mFullScreenPlayer != null)
        {
            Bundle bundle1 = new Bundle();
            bundle1.putInt("PositionKey", mFullScreenVideoView.getCurrentPosition());
            bundle1.putBoolean("PlayingKey", mFullScreenVideoView.isPlaying());
            bundle1.putString("SourceKey", mFullScreenVideoBundle.getString("SourceKey"));
            mFullScreenPlayer.fullScreenKilled(bundle1);
        }
        videoplayer = doFullScreenVideoAction(videoplayer, (Bundle)obj);
          goto _L11
    }

    public void prepareFullScreenVideoDialog(Dialog dialog)
    {
        mFullScreenVideoView.setOnPreparedListener(this);
        mFullScreenVideoView.setOnCompletionListener(this);
    }

    public boolean setSource(String s, boolean flag)
    {
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_14;
        }
        mFullScreenVideoBundle.putInt("PositionKey", 0);
        MediaUtil.loadVideoView(mFullScreenVideoView, mForm, s);
        mFullScreenVideoBundle.putString("SourceKey", s);
        return true;
        IOException ioexception;
        ioexception;
        mForm.dispatchErrorOccurredEvent(mFullScreenPlayer, "Source", 701, new Object[] {
            s
        });
        return false;
    }

    public boolean showing()
    {
        return dialogInitialized() && mFullScreenVideoDialog.isShowing();
    }

    public void startDialog()
    {
        try
        {
            MediaUtil.loadVideoView(mFullScreenVideoView, mForm, mFullScreenVideoBundle.getString("SourceKey"));
            return;
        }
        catch (IOException ioexception)
        {
            mForm.dispatchErrorOccurredEvent(mFullScreenPlayer, "Source", 701, new Object[] {
                mFullScreenVideoBundle.getString("SourceKey")
            });
        }
    }



}
