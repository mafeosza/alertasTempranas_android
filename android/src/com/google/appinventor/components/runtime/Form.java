// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.collect.Sets;
import com.google.appinventor.components.runtime.util.AlignmentUtil;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.ErrorMessages;
import com.google.appinventor.components.runtime.util.FullScreenVideoUtil;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.OnInitializeListener;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Component, ComponentContainer, HandlesEventDispatching, ReplForm, 
//            Notifier, LinearLayout, EventDispatcher, OnStopListener, 
//            OnResumeListener, OnPauseListener, OnDestroyListener, Deleteable, 
//            ActivityResultListener, OnNewIntentListener, AndroidViewComponent, VideoPlayer

public class Form extends Activity
    implements Component, ComponentContainer, HandlesEventDispatching
{

    public static final String APPINVENTOR_URL_SCHEME = "appinventor";
    private static final String ARGUMENT_NAME = "APP_INVENTOR_START";
    private static final String LOG_TAG = "Form";
    private static final String RESULT_NAME = "APP_INVENTOR_RESULT";
    private static final int SWITCH_FORM_REQUEST_CODE = 1;
    protected static Form activeForm;
    private static boolean applicationIsBeingClosed;
    private static long minimumToastWait = 0x2540be400L;
    private static int nextRequestCode = 2;
    private String aboutScreen;
    private final HashMap activityResultMap = Maps.newHashMap();
    private AlignmentUtil alignmentSetter;
    private final Handler androidUIHandler = new Handler();
    private int backgroundColor;
    private Drawable backgroundDrawable;
    private String backgroundImagePath;
    private String closeAnimType;
    protected String formName;
    private FrameLayout frameLayout;
    private FullScreenVideoUtil fullScreenVideoUtil;
    private int horizontalAlignment;
    private long lastToastTime;
    private String nextFormName;
    private final Set onDestroyListeners = Sets.newHashSet();
    private final Set onInitializeListeners = Sets.newHashSet();
    private final Set onNewIntentListeners = Sets.newHashSet();
    private final Set onPauseListeners = Sets.newHashSet();
    private final Set onResumeListeners = Sets.newHashSet();
    private final Set onStopListeners = Sets.newHashSet();
    private String openAnimType;
    private boolean screenInitialized;
    private boolean scrollable;
    protected String startupValue;
    private int verticalAlignment;
    private LinearLayout viewLayout;
    private String yandexTranslateTagline;

    public Form()
    {
        backgroundImagePath = "";
        startupValue = "";
        lastToastTime = System.nanoTime() - minimumToastWait;
        yandexTranslateTagline = "";
    }

    private void closeApplication()
    {
        applicationIsBeingClosed = true;
        finish();
        if (formName.equals("Screen1"))
        {
            System.exit(0);
        }
    }

    private void closeApplicationFromMenu()
    {
        closeApplication();
    }

    private static Object decodeJSONStringForForm(String s, String s1)
    {
        Log.i("Form", (new StringBuilder()).append("decodeJSONStringForForm -- decoding JSON representation:").append(s).toString());
        Object obj = "";
        Object obj1;
        try
        {
            obj1 = JsonUtil.getObjectFromJson(s);
        }
        catch (JSONException jsonexception)
        {
            activeForm.dispatchErrorOccurredEvent(activeForm, s1, 903, new Object[] {
                s
            });
            return obj;
        }
        obj = obj1;
        Log.i("Form", (new StringBuilder()).append("decodeJSONStringForForm -- got decoded JSON:").append(obj1.toString()).toString());
        return obj1;
    }

    private void defaultPropertyValues()
    {
        Scrollable(false);
        BackgroundImage("");
        AboutScreen("");
        BackgroundColor(-1);
        AlignHorizontal(1);
        AlignVertical(1);
        Title("");
    }

    public static void finishActivity()
    {
        if (activeForm != null)
        {
            activeForm.closeForm(null);
            return;
        } else
        {
            throw new IllegalStateException("activeForm is null");
        }
    }

    public static void finishActivityWithResult(Object obj)
    {
        if (activeForm != null)
        {
            if (activeForm instanceof ReplForm)
            {
                ((ReplForm)activeForm).setResult(obj);
                activeForm.closeForm(null);
                return;
            } else
            {
                obj = jsonEncodeForForm(obj, "close screen with value");
                Intent intent = new Intent();
                intent.putExtra("APP_INVENTOR_RESULT", ((String) (obj)));
                activeForm.closeForm(intent);
                return;
            }
        } else
        {
            throw new IllegalStateException("activeForm is null");
        }
    }

    public static void finishActivityWithTextResult(String s)
    {
        if (activeForm != null)
        {
            Intent intent = new Intent();
            intent.putExtra("APP_INVENTOR_RESULT", s);
            activeForm.closeForm(intent);
            return;
        } else
        {
            throw new IllegalStateException("activeForm is null");
        }
    }

    public static void finishApplication()
    {
        if (activeForm != null)
        {
            activeForm.closeApplicationFromBlocks();
            return;
        } else
        {
            throw new IllegalStateException("activeForm is null");
        }
    }

    private static int generateNewRequestCode()
    {
        int i = nextRequestCode;
        nextRequestCode = i + 1;
        return i;
    }

    public static Form getActiveForm()
    {
        return activeForm;
    }

    public static String getStartText()
    {
        if (activeForm != null)
        {
            return activeForm.startupValue;
        } else
        {
            throw new IllegalStateException("activeForm is null");
        }
    }

    public static Object getStartValue()
    {
        if (activeForm != null)
        {
            return decodeJSONStringForForm(activeForm.startupValue, "get start value");
        } else
        {
            throw new IllegalStateException("activeForm is null");
        }
    }

    protected static String jsonEncodeForForm(Object obj, String s)
    {
        String s1 = "";
        Log.i("Form", (new StringBuilder()).append("jsonEncodeForForm -- creating JSON representation:").append(obj.toString()).toString());
        String s2;
        try
        {
            s2 = JsonUtil.getJsonRepresentation(obj);
        }
        catch (JSONException jsonexception)
        {
            activeForm.dispatchErrorOccurredEvent(activeForm, s, 904, new Object[] {
                obj.toString()
            });
            return s1;
        }
        s1 = s2;
        Log.i("Form", (new StringBuilder()).append("jsonEncodeForForm -- got JSON representation:").append(s2).toString());
        return s2;
    }

    private void showAboutApplicationNotification()
    {
        Notifier.oneButtonAlert(this, (new StringBuilder()).append(aboutScreen).append("<p><small><em>Invented with MIT App Inventor<br>appinventor.mit.edu</em></small></p>").append(yandexTranslateTagline).toString().replaceAll("\\n", "<br>"), "About this app", "Got it");
    }

    private void showExitApplicationNotification()
    {
        Runnable runnable = new Runnable() {

            final Form this$0;

            public void run()
            {
                closeApplicationFromMenu();
            }

            
            {
                this$0 = Form.this;
                super();
            }
        };
        Runnable runnable1 = new Runnable() {

            final Form this$0;

            public void run()
            {
            }

            
            {
                this$0 = Form.this;
                super();
            }
        };
        Notifier.twoButtonDialog(this, "Stop this application and exit? You'll need to relaunch the application to use it again.", "Stop application?", "Stop and exit", "Don't stop", false, runnable, runnable1, runnable1);
    }

    public static void switchForm(String s)
    {
        if (activeForm != null)
        {
            activeForm.startNewForm(s, null);
            return;
        } else
        {
            throw new IllegalStateException("activeForm is null");
        }
    }

    public static void switchFormWithStartValue(String s, Object obj)
    {
        Log.i("Form", (new StringBuilder()).append("Open another screen with start value:").append(s).toString());
        if (activeForm != null)
        {
            activeForm.startNewForm(s, obj);
            return;
        } else
        {
            throw new IllegalStateException("activeForm is null");
        }
    }

    public void $add(AndroidViewComponent androidviewcomponent)
    {
        viewLayout.add(androidviewcomponent);
    }

    public Activity $context()
    {
        return this;
    }

    protected void $define()
    {
        throw new UnsupportedOperationException();
    }

    public Form $form()
    {
        return this;
    }

    public String AboutScreen()
    {
        return aboutScreen;
    }

    public void AboutScreen(String s)
    {
        aboutScreen = s;
    }

    public int AlignHorizontal()
    {
        return horizontalAlignment;
    }

    public void AlignHorizontal(int i)
    {
        try
        {
            alignmentSetter.setHorizontalAlignment(i);
            horizontalAlignment = i;
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            dispatchErrorOccurredEvent(this, "HorizontalAlignment", 1401, new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    public int AlignVertical()
    {
        return verticalAlignment;
    }

    public void AlignVertical(int i)
    {
        try
        {
            alignmentSetter.setVerticalAlignment(i);
            verticalAlignment = i;
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            dispatchErrorOccurredEvent(this, "VerticalAlignment", 1402, new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    public void AppName(String s)
    {
    }

    public boolean BackPressed()
    {
        return EventDispatcher.dispatchEvent(this, "BackPressed", new Object[0]);
    }

    public int BackgroundColor()
    {
        return backgroundColor;
    }

    public void BackgroundColor(int i)
    {
        backgroundColor = i;
        if (i != 0)
        {
            viewLayout.getLayoutManager().setBackgroundColor(i);
            frameLayout.setBackgroundColor(i);
            return;
        } else
        {
            viewLayout.getLayoutManager().setBackgroundColor(-1);
            frameLayout.setBackgroundColor(-1);
            return;
        }
    }

    public String BackgroundImage()
    {
        return backgroundImagePath;
    }

    public void BackgroundImage(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        backgroundImagePath = s1;
        try
        {
            backgroundDrawable = MediaUtil.getBitmapDrawable(this, backgroundImagePath);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Form", (new StringBuilder()).append("Unable to load ").append(backgroundImagePath).toString());
            backgroundDrawable = null;
        }
        ViewUtil.setBackgroundImage(frameLayout, backgroundDrawable);
        frameLayout.invalidate();
    }

    public String CloseScreenAnimation()
    {
        return closeAnimType;
    }

    public void CloseScreenAnimation(String s)
    {
        if (s != "default" && s != "fade" && s != "zoom" && s != "slidehorizontal" && s != "slidevertical" && s != "none")
        {
            dispatchErrorOccurredEvent(this, "Screen", 905, new Object[] {
                s
            });
            return;
        } else
        {
            closeAnimType = s;
            return;
        }
    }

    public void ErrorOccurred(Component component, String s, int i, String s1)
    {
        String s2 = component.getClass().getName();
        s2 = s2.substring(s2.lastIndexOf(".") + 1);
        Log.e("Form", (new StringBuilder()).append("Form ").append(formName).append(" ErrorOccurred, errorNumber = ").append(i).append(", componentType = ").append(s2).append(", functionName = ").append(s).append(", messages = ").append(s1).toString());
        if (!EventDispatcher.dispatchEvent(this, "ErrorOccurred", new Object[] {
    component, s, Integer.valueOf(i), s1
}) && screenInitialized)
        {
            (new Notifier(this)).ShowAlert((new StringBuilder()).append("Error ").append(i).append(": ").append(s1).toString());
        }
    }

    public void ErrorOccurredDialog(Component component, String s, int i, String s1, String s2, String s3)
    {
        String s4 = component.getClass().getName();
        s4 = s4.substring(s4.lastIndexOf(".") + 1);
        Log.e("Form", (new StringBuilder()).append("Form ").append(formName).append(" ErrorOccurred, errorNumber = ").append(i).append(", componentType = ").append(s4).append(", functionName = ").append(s).append(", messages = ").append(s1).toString());
        if (!EventDispatcher.dispatchEvent(this, "ErrorOccurred", new Object[] {
    component, s, Integer.valueOf(i), s1
}) && screenInitialized)
        {
            (new Notifier(this)).ShowMessageDialog((new StringBuilder()).append("Error ").append(i).append(": ").append(s1).toString(), s2, s3);
        }
    }

    public int Height()
    {
        return frameLayout.getHeight();
    }

    public void Icon(String s)
    {
    }

    public void Initialize()
    {
        androidUIHandler.post(new Runnable() {

            final Form this$0;

            public void run()
            {
                if (frameLayout != null && frameLayout.getWidth() != 0 && frameLayout.getHeight() != 0)
                {
                    EventDispatcher.dispatchEvent(Form.this, "Initialize", new Object[0]);
                    screenInitialized = true;
                    for (Iterator iterator = onInitializeListeners.iterator(); iterator.hasNext(); ((OnInitializeListener)iterator.next()).onInitialize()) { }
                    if (Form.activeForm instanceof ReplForm)
                    {
                        ((ReplForm)Form.activeForm).HandleReturnValues();
                    }
                    return;
                } else
                {
                    androidUIHandler.post(this);
                    return;
                }
            }

            
            {
                this$0 = Form.this;
                super();
            }
        });
    }

    public String OpenScreenAnimation()
    {
        return openAnimType;
    }

    public void OpenScreenAnimation(String s)
    {
        if (s != "default" && s != "fade" && s != "zoom" && s != "slidehorizontal" && s != "slidevertical" && s != "none")
        {
            dispatchErrorOccurredEvent(this, "Screen", 905, new Object[] {
                s
            });
            return;
        } else
        {
            openAnimType = s;
            return;
        }
    }

    public void OtherScreenClosed(String s, Object obj)
    {
        Log.i("Form", (new StringBuilder()).append("Form ").append(formName).append(" OtherScreenClosed, otherScreenName = ").append(s).append(", result = ").append(obj.toString()).toString());
        EventDispatcher.dispatchEvent(this, "OtherScreenClosed", new Object[] {
            s, obj
        });
    }

    public String ScreenOrientation()
    {
        switch (getRequestedOrientation())
        {
        default:
            return "unspecified";

        case 3: // '\003'
            return "behind";

        case 0: // '\0'
            return "landscape";

        case 5: // '\005'
            return "nosensor";

        case 1: // '\001'
            return "portrait";

        case 4: // '\004'
            return "sensor";

        case -1: 
            return "unspecified";

        case 2: // '\002'
            return "user";

        case 10: // '\n'
            return "fullSensor";

        case 8: // '\b'
            return "reverseLandscape";

        case 9: // '\t'
            return "reversePortrait";

        case 6: // '\006'
            return "sensorLandscape";

        case 7: // '\007'
            return "sensorPortrait";
        }
    }

    public void ScreenOrientation(String s)
    {
        if (s.equalsIgnoreCase("behind"))
        {
            setRequestedOrientation(3);
            return;
        }
        if (s.equalsIgnoreCase("landscape"))
        {
            setRequestedOrientation(0);
            return;
        }
        if (s.equalsIgnoreCase("nosensor"))
        {
            setRequestedOrientation(5);
            return;
        }
        if (s.equalsIgnoreCase("portrait"))
        {
            setRequestedOrientation(1);
            return;
        }
        if (s.equalsIgnoreCase("sensor"))
        {
            setRequestedOrientation(4);
            return;
        }
        if (s.equalsIgnoreCase("unspecified"))
        {
            setRequestedOrientation(-1);
            return;
        }
        if (s.equalsIgnoreCase("user"))
        {
            setRequestedOrientation(2);
            return;
        }
        if (SdkLevel.getLevel() >= 9)
        {
            if (s.equalsIgnoreCase("fullSensor"))
            {
                setRequestedOrientation(10);
                return;
            }
            if (s.equalsIgnoreCase("reverseLandscape"))
            {
                setRequestedOrientation(8);
                return;
            }
            if (s.equalsIgnoreCase("reversePortrait"))
            {
                setRequestedOrientation(9);
                return;
            }
            if (s.equalsIgnoreCase("sensorLandscape"))
            {
                setRequestedOrientation(6);
                return;
            }
            if (s.equalsIgnoreCase("sensorPortrait"))
            {
                setRequestedOrientation(7);
                return;
            } else
            {
                dispatchErrorOccurredEvent(this, "ScreenOrientation", 901, new Object[] {
                    s
                });
                return;
            }
        } else
        {
            dispatchErrorOccurredEvent(this, "ScreenOrientation", 901, new Object[] {
                s
            });
            return;
        }
    }

    public void ScreenOrientationChanged()
    {
        EventDispatcher.dispatchEvent(this, "ScreenOrientationChanged", new Object[0]);
    }

    public void Scrollable(boolean flag)
    {
        if (scrollable == flag && frameLayout != null)
        {
            return;
        }
        if (frameLayout != null)
        {
            frameLayout.removeAllViews();
        }
        scrollable = flag;
        Object obj;
        if (flag)
        {
            obj = new ScrollView(this);
        } else
        {
            obj = new FrameLayout(this);
        }
        frameLayout = ((FrameLayout) (obj));
        frameLayout.addView(viewLayout.getLayoutManager(), new android.view.ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(backgroundColor);
        if (backgroundDrawable != null)
        {
            ViewUtil.setBackgroundImage(frameLayout, backgroundDrawable);
        }
        setContentView(frameLayout);
        frameLayout.requestLayout();
    }

    public boolean Scrollable()
    {
        return scrollable;
    }

    public String Title()
    {
        return getTitle().toString();
    }

    public void Title(String s)
    {
        setTitle(s);
    }

    public void VersionCode(int i)
    {
    }

    public void VersionName(String s)
    {
    }

    public int Width()
    {
        return frameLayout.getWidth();
    }

    public void addAboutInfoToMenu(Menu menu)
    {
        menu.add(0, 0, 2, "About this application").setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

            final Form this$0;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                showAboutApplicationNotification();
                return true;
            }

            
            {
                this$0 = Form.this;
                super();
            }
        }).setIcon(0x1080093);
    }

    public void addExitButtonToMenu(Menu menu)
    {
        menu.add(0, 0, 1, "Stop this application").setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

            final Form this$0;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                showExitApplicationNotification();
                return true;
            }

            
            {
                this$0 = Form.this;
                super();
            }
        }).setIcon(0x108005a);
    }

    public void callInitialize(Object obj)
        throws Throwable
    {
        Method method;
        try
        {
            method = obj.getClass().getMethod("Initialize", (Class[])null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.i("Form", (new StringBuilder()).append("Security exception ").append(((SecurityException) (obj)).getMessage()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            return;
        }
        try
        {
            Log.i("Form", (new StringBuilder()).append("calling Initialize method for Object ").append(obj.toString()).toString());
            method.invoke(obj, (Object[])null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.i("Form", (new StringBuilder()).append("invoke exception: ").append(((InvocationTargetException) (obj)).getMessage()).toString());
        }
        throw ((InvocationTargetException) (obj)).getTargetException();
    }

    public boolean canDispatchEvent(Component component, String s)
    {
        boolean flag;
        if (screenInitialized || component == this && s.equals("Initialize"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            activeForm = this;
        }
        return flag;
    }

    public void clear()
    {
        viewLayout.getLayoutManager().removeAllViews();
        defaultPropertyValues();
        screenInitialized = false;
    }

    protected void closeApplicationFromBlocks()
    {
        closeApplication();
    }

    protected void closeForm(Intent intent)
    {
        if (intent != null)
        {
            setResult(-1, intent);
        }
        finish();
        AnimationUtil.ApplyCloseScreenAnimation(this, closeAnimType);
    }

    public void deleteComponent(Object obj)
    {
        if (obj instanceof OnStopListener)
        {
            OnStopListener onstoplistener = (OnStopListener)obj;
            if (onStopListeners.contains(onstoplistener))
            {
                onStopListeners.remove(onstoplistener);
            }
        }
        if (obj instanceof OnResumeListener)
        {
            OnResumeListener onresumelistener = (OnResumeListener)obj;
            if (onResumeListeners.contains(onresumelistener))
            {
                onResumeListeners.remove(onresumelistener);
            }
        }
        if (obj instanceof OnPauseListener)
        {
            OnPauseListener onpauselistener = (OnPauseListener)obj;
            if (onPauseListeners.contains(onpauselistener))
            {
                onPauseListeners.remove(onpauselistener);
            }
        }
        if (obj instanceof OnDestroyListener)
        {
            OnDestroyListener ondestroylistener = (OnDestroyListener)obj;
            if (onDestroyListeners.contains(ondestroylistener))
            {
                onDestroyListeners.remove(ondestroylistener);
            }
        }
        if (obj instanceof Deleteable)
        {
            ((Deleteable)obj).onDelete();
        }
    }

    public transient void dispatchErrorOccurredEvent(final Component component, final String functionName, final int errorNumber, final Object messageArgs[])
    {
        runOnUiThread(new Runnable() {

            final Form this$0;
            final Component val$component;
            final int val$errorNumber;
            final String val$functionName;
            final Object val$messageArgs[];

            public void run()
            {
                String s = ErrorMessages.formatMessage(errorNumber, messageArgs);
                ErrorOccurred(component, functionName, errorNumber, s);
            }

            
            {
                this$0 = Form.this;
                errorNumber = i;
                messageArgs = aobj;
                component = component1;
                functionName = s;
                super();
            }
        });
    }

    public transient void dispatchErrorOccurredEventDialog(final Component component, final String functionName, final int errorNumber, final Object messageArgs[])
    {
        runOnUiThread(new Runnable() {

            final Form this$0;
            final Component val$component;
            final int val$errorNumber;
            final String val$functionName;
            final Object val$messageArgs[];

            public void run()
            {
                String s = ErrorMessages.formatMessage(errorNumber, messageArgs);
                ErrorOccurredDialog(component, functionName, errorNumber, s, (new StringBuilder()).append("Error in ").append(functionName).toString(), "Dismiss");
            }

            
            {
                this$0 = Form.this;
                errorNumber = i;
                messageArgs = aobj;
                component = component1;
                functionName = s;
                super();
            }
        });
    }

    public boolean dispatchEvent(Component component, String s, String s1, Object aobj[])
    {
        throw new UnsupportedOperationException();
    }

    public void dontGrabTouchEventsForComponent()
    {
        frameLayout.requestDisallowInterceptTouchEvent(true);
    }

    public Bundle fullScreenVideoAction(int i, VideoPlayer videoplayer, Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        videoplayer = fullScreenVideoUtil.performAction(i, videoplayer, obj);
        this;
        JVM INSTR monitorexit ;
        return videoplayer;
        videoplayer;
        throw videoplayer;
    }

    public HandlesEventDispatching getDispatchDelegate()
    {
        return this;
    }

    public String getOpenAnimType()
    {
        return openAnimType;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        Log.i("Form", (new StringBuilder()).append("Form ").append(formName).append(" got onActivityResult, requestCode = ").append(i).append(", resultCode = ").append(j).toString());
        if (i == 1)
        {
            if (intent != null && intent.hasExtra("APP_INVENTOR_RESULT"))
            {
                intent = intent.getStringExtra("APP_INVENTOR_RESULT");
            } else
            {
                intent = "";
            }
            intent = ((Intent) (decodeJSONStringForForm(intent, "other screen closed")));
            OtherScreenClosed(nextFormName, intent);
        } else
        {
            ActivityResultListener activityresultlistener = (ActivityResultListener)activityResultMap.get(Integer.valueOf(i));
            if (activityresultlistener != null)
            {
                activityresultlistener.resultReturned(i, j, intent);
                return;
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        final int newOrientation = configuration.orientation;
        if (newOrientation == 2 || newOrientation == 1)
        {
            androidUIHandler.post(new Runnable() {

                final Form this$0;
                final int val$newOrientation;

                public void run()
                {
                    boolean flag1 = false;
                    boolean flag = flag1;
                    if (frameLayout != null)
                    {
                        if (newOrientation == 2)
                        {
                            flag = flag1;
                            if (frameLayout.getWidth() >= frameLayout.getHeight())
                            {
                                flag = true;
                            }
                        } else
                        {
                            flag = flag1;
                            if (frameLayout.getHeight() >= frameLayout.getWidth())
                            {
                                flag = true;
                            }
                        }
                    }
                    if (flag)
                    {
                        ScreenOrientationChanged();
                        return;
                    } else
                    {
                        androidUIHandler.post(this);
                        return;
                    }
                }

            
            {
                this$0 = Form.this;
                newOrientation = i;
                super();
            }
            });
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getClass().getName();
        formName = bundle.substring(bundle.lastIndexOf('.') + 1);
        Log.d("Form", (new StringBuilder()).append("Form ").append(formName).append(" got onCreate").toString());
        activeForm = this;
        Log.i("Form", (new StringBuilder()).append("activeForm is now ").append(activeForm.formName).toString());
        viewLayout = new LinearLayout(this, 1);
        alignmentSetter = new AlignmentUtil(viewLayout);
        defaultPropertyValues();
        bundle = getIntent();
        if (bundle != null && bundle.hasExtra("APP_INVENTOR_START"))
        {
            startupValue = bundle.getStringExtra("APP_INVENTOR_START");
        }
        fullScreenVideoUtil = new FullScreenVideoUtil(this, androidUIHandler);
        int i = getWindow().getAttributes().softInputMode;
        getWindow().setSoftInputMode(i | 0x10);
        $define();
        Initialize();
    }

    public Dialog onCreateDialog(int i)
    {
        switch (i)
        {
        default:
            return super.onCreateDialog(i);

        case 189: 
            return fullScreenVideoUtil.createFullScreenVideoDialog();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        addExitButtonToMenu(menu);
        addAboutInfoToMenu(menu);
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        Log.i("Form", (new StringBuilder()).append("Form ").append(formName).append(" got onDestroy").toString());
        EventDispatcher.removeDispatchDelegate(this);
        for (Iterator iterator = onDestroyListeners.iterator(); iterator.hasNext(); ((OnDestroyListener)iterator.next()).onDestroy()) { }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (!BackPressed())
            {
                boolean flag = super.onKeyDown(i, keyevent);
                AnimationUtil.ApplyCloseScreenAnimation(this, closeAnimType);
                return flag;
            } else
            {
                return true;
            }
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Log.d("Form", (new StringBuilder()).append("Form ").append(formName).append(" got onNewIntent ").append(intent).toString());
        for (Iterator iterator = onNewIntentListeners.iterator(); iterator.hasNext(); ((OnNewIntentListener)iterator.next()).onNewIntent(intent)) { }
    }

    protected void onPause()
    {
        super.onPause();
        Log.i("Form", (new StringBuilder()).append("Form ").append(formName).append(" got onPause").toString());
        for (Iterator iterator = onPauseListeners.iterator(); iterator.hasNext(); ((OnPauseListener)iterator.next()).onPause()) { }
    }

    public void onPrepareDialog(int i, Dialog dialog)
    {
        switch (i)
        {
        default:
            super.onPrepareDialog(i, dialog);
            return;

        case 189: 
            fullScreenVideoUtil.prepareFullScreenVideoDialog(dialog);
            break;
        }
    }

    protected void onResume()
    {
        super.onResume();
        Log.i("Form", (new StringBuilder()).append("Form ").append(formName).append(" got onResume").toString());
        activeForm = this;
        if (applicationIsBeingClosed)
        {
            closeApplication();
        } else
        {
            Iterator iterator = onResumeListeners.iterator();
            while (iterator.hasNext()) 
            {
                ((OnResumeListener)iterator.next()).onResume();
            }
        }
    }

    protected void onStop()
    {
        super.onStop();
        Log.i("Form", (new StringBuilder()).append("Form ").append(formName).append(" got onStop").toString());
        for (Iterator iterator = onStopListeners.iterator(); iterator.hasNext(); ((OnStopListener)iterator.next()).onStop()) { }
    }

    public int registerForActivityResult(ActivityResultListener activityresultlistener)
    {
        int i = generateNewRequestCode();
        activityResultMap.put(Integer.valueOf(i), activityresultlistener);
        return i;
    }

    public void registerForOnDestroy(OnDestroyListener ondestroylistener)
    {
        onDestroyListeners.add(ondestroylistener);
    }

    public void registerForOnInitialize(OnInitializeListener oninitializelistener)
    {
        onInitializeListeners.add(oninitializelistener);
    }

    public void registerForOnNewIntent(OnNewIntentListener onnewintentlistener)
    {
        onNewIntentListeners.add(onnewintentlistener);
    }

    public void registerForOnPause(OnPauseListener onpauselistener)
    {
        onPauseListeners.add(onpauselistener);
    }

    public void registerForOnResume(OnResumeListener onresumelistener)
    {
        onResumeListeners.add(onresumelistener);
    }

    public void registerForOnStop(OnStopListener onstoplistener)
    {
        onStopListeners.add(onstoplistener);
    }

    public void setChildHeight(AndroidViewComponent androidviewcomponent, int i)
    {
        ViewUtil.setChildHeightForVerticalLayout(androidviewcomponent.getView(), i);
    }

    public void setChildWidth(AndroidViewComponent androidviewcomponent, int i)
    {
        ViewUtil.setChildWidthForVerticalLayout(androidviewcomponent.getView(), i);
    }

    void setYandexTranslateTagline()
    {
        yandexTranslateTagline = "<p><small>Language translation powered by Yandex.Translate</small></p>";
    }

    protected void startNewForm(String s, Object obj)
    {
        Log.i("Form", (new StringBuilder()).append("startNewForm:").append(s).toString());
        Intent intent = new Intent();
        intent.setClassName(this, (new StringBuilder()).append(getPackageName()).append(".").append(s).toString());
        String s1;
        if (obj == null)
        {
            s1 = "open another screen";
        } else
        {
            s1 = "open another screen with start value";
        }
        if (obj != null)
        {
            Log.i("Form", (new StringBuilder()).append("StartNewForm about to JSON encode:").append(obj).toString());
            obj = jsonEncodeForForm(obj, s1);
            Log.i("Form", (new StringBuilder()).append("StartNewForm got JSON encoding:").append(((String) (obj))).toString());
        } else
        {
            obj = "";
        }
        intent.putExtra("APP_INVENTOR_START", ((String) (obj)));
        nextFormName = s;
        Log.i("Form", (new StringBuilder()).append("about to start new form").append(s).toString());
        try
        {
            Log.i("Form", (new StringBuilder()).append("startNewForm starting activity:").append(intent).toString());
            startActivityForResult(intent, 1);
            AnimationUtil.ApplyOpenScreenAnimation(this, openAnimType);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            dispatchErrorOccurredEvent(this, s1, 902, new Object[] {
                s
            });
        }
    }

    protected boolean toastAllowed()
    {
        long l = System.nanoTime();
        if (l > lastToastTime + minimumToastWait)
        {
            lastToastTime = l;
            return true;
        } else
        {
            return false;
        }
    }

    public void unregisterForActivityResult(ActivityResultListener activityresultlistener)
    {
        Object obj = Lists.newArrayList();
        Iterator iterator = activityResultMap.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (activityresultlistener.equals(entry.getValue()))
            {
                ((List) (obj)).add(entry.getKey());
            }
        } while (true);
        for (activityresultlistener = ((List) (obj)).iterator(); activityresultlistener.hasNext(); activityResultMap.remove(obj))
        {
            obj = (Integer)activityresultlistener.next();
        }

    }





/*
    static boolean access$202(Form form, boolean flag)
    {
        form.screenInitialized = flag;
        return flag;
    }

*/




}
