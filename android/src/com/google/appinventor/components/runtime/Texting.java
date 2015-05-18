// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;
import com.google.appinventor.components.runtime.util.OAuth2Helper;
import com.google.appinventor.components.runtime.util.OnInitializeListener;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, OnResumeListener, OnPauseListener, 
//            OnStopListener, ComponentContainer, Form, EventDispatcher

public class Texting extends AndroidNonvisibleComponent
    implements Component, OnResumeListener, OnPauseListener, OnInitializeListener, OnStopListener
{
    class AsyncAuthenticate extends AsyncTask
    {

        final Texting this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            Log.i("Texting Component", "Authenticating");
            return (new OAuth2Helper()).getRefreshedAuthToken(Texting.activity, "grandcentral");
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            Log.i("Texting Component", (new StringBuilder()).append("authToken = ").append(s).toString());
            authToken = s;
            Toast.makeText(Texting.activity, "Finished authentication", 0).show();
            processPendingQueue();
        }

        AsyncAuthenticate()
        {
            this$0 = Texting.this;
            super();
        }
    }

    class AsyncSendMessage extends AsyncTask
    {

        final Texting this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            String s;
            String s1;
            String s2;
            s1 = as[0];
            s2 = as[1];
            s = "";
            Log.i("Texting Component", (new StringBuilder()).append("Async sending phoneNumber = ").append(s1).append(" message = ").append(s2).toString());
            as = s;
            s1 = (new StringBuilder()).append(URLEncoder.encode("phoneNumber", "UTF-8")).append("=").append(URLEncoder.encode(s1, "UTF-8")).append("&").append(URLEncoder.encode("text", "UTF-8")).append("=").append(URLEncoder.encode(s2, "UTF-8")).toString();
            as = s;
            if (gvHelper != null)
            {
                break MISSING_BLOCK_LABEL_154;
            }
            as = s;
            gvHelper = new GoogleVoiceUtil(authToken);
            as = s;
            if (!gvHelper.isInitialized())
            {
                break MISSING_BLOCK_LABEL_215;
            }
            as = s;
            s = gvHelper.sendGvSms(s1);
            as = s;
            Log.i("Texting Component", (new StringBuilder()).append("Sent SMS, response = ").append(s).toString());
            as = s;
            break MISSING_BLOCK_LABEL_223;
            return "IO Error: unable to create GvHelper";
            Exception exception;
            exception;
            exception.printStackTrace();
            return as;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            int i;
            super.onPostExecute(s);
            boolean flag1 = false;
            i = 0;
            boolean flag = flag1;
            JSONObject jsonobject;
            int j;
            try
            {
                jsonobject = new JSONObject(s);
            }
            catch (JSONException jsonexception)
            {
                jsonexception.printStackTrace();
                continue; /* Loop/switch isn't completed */
            }
            flag = flag1;
            flag1 = jsonobject.getBoolean("ok");
            flag = flag1;
            j = jsonobject.getJSONObject("data").getInt("code");
            i = j;
            flag = flag1;
_L6:
            if (!flag) goto _L2; else goto _L1
_L1:
            Toast.makeText(Texting.activity, "Message sent", 0).show();
_L4:
            return;
_L2:
            if (i == 58)
            {
                Toast.makeText(Texting.activity, "Errcode 58: SMS limit reached", 0).show();
                return;
            }
            if (!s.contains("IO Error")) goto _L4; else goto _L3
_L3:
            Toast.makeText(Texting.activity, s, 0).show();
            return;
            if (true) goto _L6; else goto _L5
_L5:
        }

        AsyncSendMessage()
        {
            this$0 = Texting.this;
            super();
        }
    }

    class GoogleVoiceUtil
    {

        private final int MAX_REDIRECTS = 5;
        String authToken;
        String general;
        private boolean isInitialized;
        int redirectCounter;
        String rnrSEE;
        final Texting this$0;

        private String sendGvSms(String s)
        {
            Log.i("Texting Component", "sendGvSms()");
            String s1 = "";
            OutputStreamWriter outputstreamwriter;
            Object obj;
            try
            {
                s = (new StringBuilder()).append(s).append("&").append(URLEncoder.encode("_rnr_se", "UTF-8")).append("=").append(URLEncoder.encode(rnrSEE, "UTF-8")).toString();
                Log.i("Texting Component", (new StringBuilder()).append("smsData = ").append(s).toString());
                obj = (new URL("https://www.google.com/voice/b/0/sms/send/")).openConnection();
                ((URLConnection) (obj)).setRequestProperty("Authorization", (new StringBuilder()).append("GoogleLogin auth=").append(authToken).toString());
                ((URLConnection) (obj)).setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/525.13 (KHTML, like Gecko) Chrome/0.A.B.C Safari/525.13");
                ((URLConnection) (obj)).setDoOutput(true);
                ((URLConnection) (obj)).setConnectTimeout(30000);
                Log.i("Texting Component", (new StringBuilder()).append("sms request = ").append(obj).toString());
                outputstreamwriter = new OutputStreamWriter(((URLConnection) (obj)).getOutputStream());
                outputstreamwriter.write(s);
                outputstreamwriter.flush();
                obj = new BufferedReader(new InputStreamReader(((URLConnection) (obj)).getInputStream()));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.i("Texting Component", (new StringBuilder()).append("IO Error on Send ").append(s.getMessage()).toString());
                s.printStackTrace();
                return "IO Error Message not sent";
            }
            s = s1;
            s1 = ((BufferedReader) (obj)).readLine();
            if (s1 == null)
            {
                break MISSING_BLOCK_LABEL_257;
            }
            s = (new StringBuilder()).append(s).append(s1).append("\n\r").toString();
            break MISSING_BLOCK_LABEL_220;
            Log.i("Texting Component", (new StringBuilder()).append("sendGvSms:  Sent SMS, response = ").append(s).toString());
            outputstreamwriter.close();
            ((BufferedReader) (obj)).close();
            if (s.equals(""))
            {
                throw new IOException("No Response Data Received.");
            }
            return s;
        }

        private void setRNRSEE()
            throws IOException
        {
            Log.i("Texting Component", "setRNRSEE()");
            if (general != null)
            {
                if (general.contains("'_rnr_se': '"))
                {
                    rnrSEE = general.split("'_rnr_se': '", 2)[1].split("',", 2)[0];
                    Log.i("Texting Component", "Successfully Received rnr_se.");
                    return;
                } else
                {
                    Log.i("Texting Component", (new StringBuilder()).append("Answer did not contain rnr_se! ").append(general).toString());
                    throw new IOException((new StringBuilder()).append("Answer did not contain rnr_se! ").append(general).toString());
                }
            } else
            {
                Log.i("Texting Component", "setRNRSEE(): Answer was null!");
                throw new IOException("setRNRSEE(): Answer was null!");
            }
        }

        String get(String s)
            throws IOException
        {
            Object obj;
            HttpURLConnection httpurlconnection;
            int j;
            httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
            j = 0;
            int i = j;
            try
            {
                httpurlconnection.setRequestProperty("Authorization", (new StringBuilder()).append("GoogleLogin auth=").append(authToken).toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IOException((new StringBuilder()).append(s).append(" : ").append(httpurlconnection.getResponseMessage()).append("(").append(i).append(") : IO Error.").toString());
            }
            i = j;
            httpurlconnection.setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/525.13 (KHTML, like Gecko) Chrome/0.A.B.C Safari/525.13");
            i = j;
            httpurlconnection.setInstanceFollowRedirects(false);
            i = j;
            httpurlconnection.connect();
            i = j;
            j = httpurlconnection.getResponseCode();
            i = j;
            Log.i("Texting Component", (new StringBuilder()).append(s).append(" - ").append(httpurlconnection.getResponseMessage()).toString());
            if (j == 200)
            {
                obj = httpurlconnection.getInputStream();
            } else
            {
                if (j == 301 || j == 302 || j == 303 || j == 307)
                {
                    redirectCounter = redirectCounter + 1;
                    if (redirectCounter > 5)
                    {
                        redirectCounter = 0;
                        throw new IOException((new StringBuilder()).append(s).append(" : ").append(httpurlconnection.getResponseMessage()).append("(").append(j).append(") : Too many redirects. exiting.").toString());
                    }
                    obj = httpurlconnection.getHeaderField("Location");
                    if (obj != null && !((String) (obj)).equals(""))
                    {
                        System.out.println((new StringBuilder()).append(s).append(" - ").append(j).append(" - new URL: ").append(((String) (obj))).toString());
                        return get(((String) (obj)));
                    } else
                    {
                        throw new IOException((new StringBuilder()).append(s).append(" : ").append(httpurlconnection.getResponseMessage()).append("(").append(j).append(") : Received moved answer but no Location. exiting.").toString());
                    }
                }
                obj = httpurlconnection.getErrorStream();
            }
            redirectCounter = 0;
            if (obj == null)
            {
                throw new IOException((new StringBuilder()).append(s).append(" : ").append(httpurlconnection.getResponseMessage()).append("(").append(j).append(") : InputStream was null : exiting.").toString());
            }
            StringBuffer stringbuffer;
            obj = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj))));
            stringbuffer = new StringBuffer();
_L1:
            String s1 = ((BufferedReader) (obj)).readLine();
label0:
            {
                if (s1 == null)
                {
                    break label0;
                }
                try
                {
                    stringbuffer.append((new StringBuilder()).append(s1).append("\n\r").toString());
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new IOException((new StringBuilder()).append(s).append(" - ").append(httpurlconnection.getResponseMessage()).append("(").append(j).append(") - ").append(((Exception) (obj)).getLocalizedMessage()).toString());
                }
            }
              goto _L1
            ((BufferedReader) (obj)).close();
            obj = stringbuffer.toString();
            return ((String) (obj));
        }

        public String getGeneral()
            throws IOException
        {
            Log.i("Texting Component", "getGeneral()");
            return get("https://www.google.com/voice/b/0");
        }

        public boolean isInitialized()
        {
            return isInitialized;
        }


        public GoogleVoiceUtil(String s)
        {
            this$0 = Texting.this;
            super();
            Log.i("Texting Component", "Creating GV Util");
            authToken = s;
            try
            {
                general = getGeneral();
                Log.i("Texting Component", (new StringBuilder()).append("general = ").append(general).toString());
                setRNRSEE();
                isInitialized = true;
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Texting texting)
            {
                printStackTrace();
            }
        }
    }


    private static final String CACHE_FILE = "textingmsgcache";
    public static final String GV_INTENT_FILTER = "com.google.android.apps.googlevoice.SMS_RECEIVED";
    public static final String GV_PACKAGE_NAME = "com.google.android.apps.googlevoice";
    private static final String GV_SERVICE = "grandcentral";
    public static final String GV_SMS_RECEIVED = "com.google.android.apps.googlevoice.SMS_RECEIVED";
    public static final String GV_SMS_SEND_URL = "https://www.google.com/voice/b/0/sms/send/";
    public static final String GV_URL = "https://www.google.com/voice/b/0";
    private static final String MESSAGE_DELIMITER = "\001";
    public static final String MESSAGE_TAG = "com.google.android.apps.googlevoice.TEXT";
    public static final String META_DATA_SMS_KEY = "sms_handler_component";
    public static final String META_DATA_SMS_VALUE = "Texting";
    public static final String PHONE_NUMBER_TAG = "com.google.android.apps.googlevoice.PHONE_NUMBER";
    private static final String PREF_FILE = "TextingState";
    private static final String PREF_GVENABLED = "gvenabled";
    private static final String PREF_RCVENABLED = "receiving2";
    private static final String PREF_RCVENABLED_LEGACY = "receiving";
    private static final String SENT = "SMS_SENT";
    private static final int SERVER_TIMEOUT_MS = 30000;
    public static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    public static final String TAG = "Texting Component";
    public static final String TELEPHONY_INTENT_FILTER = "android.provider.Telephony.SMS_RECEIVED";
    private static final String USER_AGENT = "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/525.13 (KHTML, like Gecko) Chrome/0.A.B.C Safari/525.13";
    private static final String UTF8 = "UTF-8";
    private static Activity activity;
    private static Object cacheLock = new Object();
    private static Component component;
    private static boolean isRunning;
    private static int messagesCached;
    private static int receivingEnabled = 2;
    private String authToken;
    private ComponentContainer container;
    private boolean googleVoiceEnabled;
    private GoogleVoiceUtil gvHelper;
    private boolean isInitialized;
    private String message;
    private Queue pendingQueue;
    private String phoneNumber;
    private SmsManager smsManager;

    public Texting(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        pendingQueue = new ConcurrentLinkedQueue();
        Log.d("Texting Component", "Texting constructor");
        container = componentcontainer;
        component = this;
        activity = componentcontainer.$context();
        SharedPreferences sharedpreferences = activity.getSharedPreferences("TextingState", 0);
        if (sharedpreferences != null)
        {
            receivingEnabled = sharedpreferences.getInt("receiving2", -1);
            if (receivingEnabled == -1)
            {
                if (sharedpreferences.getBoolean("receiving", true))
                {
                    receivingEnabled = 2;
                } else
                {
                    receivingEnabled = 1;
                }
            }
            googleVoiceEnabled = sharedpreferences.getBoolean("gvenabled", false);
            Log.i("Texting Component", (new StringBuilder()).append("Starting with receiving Enabled=").append(receivingEnabled).append(" GV enabled=").append(googleVoiceEnabled).toString());
        } else
        {
            receivingEnabled = 2;
            googleVoiceEnabled = false;
        }
        if (googleVoiceEnabled)
        {
            (new AsyncAuthenticate()).execute(new Void[0]);
        }
        smsManager = SmsManager.getDefault();
        PhoneNumber("");
        isInitialized = false;
        isRunning = false;
        componentcontainer.$form().registerForOnInitialize(this);
        componentcontainer.$form().registerForOnResume(this);
        componentcontainer.$form().registerForOnPause(this);
        componentcontainer.$form().registerForOnStop(this);
    }

    public static void MessageReceived(String s, String s1)
    {
label0:
        {
            if (receivingEnabled > 1)
            {
                Log.i("Texting Component", (new StringBuilder()).append("MessageReceived from ").append(s).append(":").append(s1).toString());
                if (!EventDispatcher.dispatchEvent(component, "MessageReceived", new Object[] {
    s, s1
}))
                {
                    break label0;
                }
                Log.i("Texting Component", "Dispatch successful");
            }
            return;
        }
        Log.i("Texting Component", "Dispatch failed, caching");
        synchronized (cacheLock)
        {
            addMessageToCache(activity, s, s1);
        }
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    private static void addMessageToCache(Context context, String s, String s1)
    {
        try
        {
            s = (new StringBuilder()).append(s).append(":").append(s1).append("\001").toString();
            Log.i("Texting Component", (new StringBuilder()).append("Caching ").append(s).toString());
            context = context.openFileOutput("textingmsgcache", 32768);
            context.write(s.getBytes());
            context.close();
            messagesCached++;
            Log.i("Texting Component", (new StringBuilder()).append("Cached ").append(s).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Texting Component", "File not found error writing to cache file");
            context.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("Texting Component", "I/O Error writing to cache file");
        }
        context.printStackTrace();
    }

    public static int getCachedMsgCount()
    {
        return messagesCached;
    }

    public static SmsMessage[] getMessagesFromIntent(Intent intent)
    {
        Object obj = ((Object) ((Object[])(Object[])intent.getSerializableExtra("pdus")));
        intent = new byte[obj.length][];
        for (int i = 0; i < obj.length; i++)
        {
            intent[i] = (byte[])(byte[])obj[i];
        }

        obj = new byte[intent.length][];
        int k = obj.length;
        SmsMessage asmsmessage[] = new SmsMessage[k];
        for (int j = 0; j < k; j++)
        {
            obj[j] = intent[j];
            asmsmessage[j] = SmsMessage.createFromPdu(obj[j]);
        }

        return asmsmessage;
    }

    private void handleSentMessage(Context context, BroadcastReceiver broadcastreceiver, int i, String s)
    {
        this;
        JVM INSTR monitorenter ;
        i;
        JVM INSTR tableswitch -1 4: default 40
    //                   -1 43
    //                   0 40
    //                   1 91
    //                   2 220
    //                   3 177
    //                   4 134;
           goto _L1 _L2 _L1 _L3 _L4 _L5 _L6
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Log.i("Texting Component", (new StringBuilder()).append("Received OK, msg:").append(s).toString());
        Toast.makeText(activity, "Message sent", 0).show();
          goto _L1
        context;
        throw context;
_L3:
        Log.e("Texting Component", (new StringBuilder()).append("Received generic failure, msg:").append(s).toString());
        Toast.makeText(activity, "Generic failure: message not sent", 0).show();
          goto _L1
_L6:
        Log.e("Texting Component", (new StringBuilder()).append("Received no service error, msg:").append(s).toString());
        Toast.makeText(activity, "No Sms service available. Message not sent.", 0).show();
          goto _L1
_L5:
        Log.e("Texting Component", (new StringBuilder()).append("Received null PDU error, msg:").append(s).toString());
        Toast.makeText(activity, "Received null PDU error. Message not sent.", 0).show();
          goto _L1
_L4:
        Log.e("Texting Component", (new StringBuilder()).append("Received radio off error, msg:").append(s).toString());
        Toast.makeText(activity, "Could not send SMS message: radio off.", 1).show();
          goto _L1
    }

    public static void handledReceivedMessage(Context context, String s, String s1)
    {
        if (isRunning)
        {
            MessageReceived(s, s1);
            return;
        }
        synchronized (cacheLock)
        {
            addMessageToCache(context, s, s1);
        }
        return;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    public static int isReceivingEnabled(Context context)
    {
label0:
        {
            context = context.getSharedPreferences("TextingState", 0);
            int j = context.getInt("receiving2", -1);
            int i = j;
            if (j == -1)
            {
                if (!context.getBoolean("receiving", true))
                {
                    break label0;
                }
                i = 2;
            }
            return i;
        }
        return 1;
    }

    public static boolean isRunning()
    {
        return isRunning;
    }

    private void processCachedMessages()
    {
        synchronized (cacheLock)
        {
            obj1 = retrieveCachedMessages();
        }
        if (obj1 == null)
        {
            return;
        }
        break MISSING_BLOCK_LABEL_23;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        Log.i("Texting Component", (new StringBuilder()).append("processing ").append(obj1.length).append(" cached messages ").toString());
        for (int i = 0; i < obj1.length; i++)
        {
            String s = obj1[i];
            Log.i("Texting Component", (new StringBuilder()).append("Message + ").append(i).append(" ").append(s).toString());
            int j = s.indexOf(":");
            if (receivingEnabled > 1 && j != -1)
            {
                MessageReceived(s.substring(0, j), s.substring(j + 1));
            }
        }

        return;
    }

    private void processPendingQueue()
    {
        String s;
        String s1;
        for (; pendingQueue.size() != 0; (new AsyncSendMessage()).execute(new String[] {
    s, s1
}))
        {
            s1 = (String)pendingQueue.remove();
            s = s1.substring(0, s1.indexOf(":::"));
            s1 = s1.substring(s1.indexOf(":::") + 3);
            Log.i("Texting Component", (new StringBuilder()).append("Sending queued message ").append(s).append(" ").append(s1).toString());
        }

    }

    private String[] retrieveCachedMessages()
    {
        Log.i("Texting Component", "Retrieving cached messages");
        FileInputStream fileinputstream;
        byte abyte0[];
        fileinputstream = activity.openFileInput("textingmsgcache");
        abyte0 = new byte[8192];
        if (fileinputstream != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        Log.e("Texting Component", "Null file stream returned from openFileInput");
        return null;
        String s;
        int i = fileinputstream.read(abyte0);
        Log.i("Texting Component", (new StringBuilder()).append("Read ").append(i).append(" bytes from ").append("textingmsgcache").toString());
        s = new String(abyte0, 0, i);
        fileinputstream.close();
        activity.deleteFile("textingmsgcache");
        messagesCached = 0;
        Log.i("Texting Component", (new StringBuilder()).append("Retrieved cache ").append(s).toString());
        return s.split("\001");
        Object obj;
        obj;
_L4:
        Log.e("Texting Component", "No Cache file found -- this is not (usually) an error");
        return null;
        obj;
_L2:
        Log.e("Texting Component", "I/O Error reading from cache file");
        ((IOException) (obj)).printStackTrace();
        return null;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void sendViaSms()
    {
        Log.i("Texting Component", "Sending via built-in Sms");
        ArrayList arraylist = smsManager.divideMessage(message);
        int j = arraylist.size();
        ArrayList arraylist1 = new ArrayList();
        for (int i = 0; i < j; i++)
        {
            arraylist1.add(PendingIntent.getBroadcast(activity, 0, new Intent("SMS_SENT"), 0));
        }

        BroadcastReceiver broadcastreceiver = new BroadcastReceiver() {

            final Texting this$0;

            public void onReceive(Context context, Intent intent)
            {
                this;
                JVM INSTR monitorenter ;
                handleSentMessage(context, null, getResultCode(), message);
                Texting.activity.unregisterReceiver(this);
_L2:
                this;
                JVM INSTR monitorexit ;
                return;
                context;
                Log.e("BroadcastReceiver", (new StringBuilder()).append("Error in onReceive for msgId ").append(intent.getAction()).toString());
                Log.e("BroadcastReceiver", context.getMessage());
                context.printStackTrace();
                if (true) goto _L2; else goto _L1
_L1:
                context;
                throw context;
            }

            
            {
                this$0 = Texting.this;
                super();
            }
        };
        activity.registerReceiver(broadcastreceiver, new IntentFilter("SMS_SENT"));
        smsManager.sendMultipartTextMessage(phoneNumber, null, arraylist, arraylist1, null);
    }

    public void GoogleVoiceEnabled(boolean flag)
    {
        if (SdkLevel.getLevel() >= 5)
        {
            googleVoiceEnabled = flag;
            android.content.SharedPreferences.Editor editor = activity.getSharedPreferences("TextingState", 0).edit();
            editor.putBoolean("gvenabled", flag);
            editor.commit();
            return;
        } else
        {
            Toast.makeText(activity, "Sorry, your phone's system does not support this option.", 1).show();
            return;
        }
    }

    public boolean GoogleVoiceEnabled()
    {
        return googleVoiceEnabled;
    }

    public String Message()
    {
        return message;
    }

    public void Message(String s)
    {
        Log.i("Texting Component", (new StringBuilder()).append("Message set: ").append(s).toString());
        message = s;
    }

    public String PhoneNumber()
    {
        return phoneNumber;
    }

    public void PhoneNumber(String s)
    {
        Log.i("Texting Component", (new StringBuilder()).append("PhoneNumber set: ").append(s).toString());
        phoneNumber = s;
    }

    public int ReceivingEnabled()
    {
        return receivingEnabled;
    }

    public void ReceivingEnabled(int i)
    {
        if (i < 1 || i > 3)
        {
            container.$form().dispatchErrorOccurredEvent(this, "Texting", 1701, new Object[] {
                Integer.valueOf(i)
            });
            return;
        } else
        {
            receivingEnabled = i;
            android.content.SharedPreferences.Editor editor = activity.getSharedPreferences("TextingState", 0).edit();
            editor.putInt("receiving2", i);
            editor.remove("receiving");
            editor.commit();
            return;
        }
    }

    public void SendMessage()
    {
        String s;
        String s1;
        Log.i("Texting Component", (new StringBuilder()).append("Sending message ").append(message).append(" to ").append(phoneNumber).toString());
        s = phoneNumber;
        s1 = message;
        if (!googleVoiceEnabled)
        {
            break MISSING_BLOCK_LABEL_216;
        }
        if (authToken != null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        Log.i("Texting Component", (new StringBuilder()).append("Need to get an authToken -- enqueing ").append(s).append(" ").append(s1).toString());
        if (pendingQueue.offer((new StringBuilder()).append(s).append(":::").append(s1).toString())) goto _L2; else goto _L1
_L1:
        Toast.makeText(activity, "Pending message queue full. Can't send message", 0).show();
_L4:
        return;
_L2:
        if (pendingQueue.size() != 1) goto _L4; else goto _L3
_L3:
        (new AsyncAuthenticate()).execute(new Void[0]);
        return;
        Log.i("Texting Component", "Creating AsyncSendMessage");
        (new AsyncSendMessage()).execute(new String[] {
            s, s1
        });
        return;
        Log.i("Texting Component", "Sending via SMS");
        sendViaSms();
        return;
    }

    public void onInitialize()
    {
        Log.i("Texting Component", "onInitialize()");
        isInitialized = true;
        isRunning = true;
        processCachedMessages();
        ((NotificationManager)activity.getSystemService("notification")).cancel(8647);
    }

    public void onPause()
    {
        Log.i("Texting Component", "onPause()");
        isRunning = false;
    }

    public void onResume()
    {
        Log.i("Texting Component", "onResume()");
        isRunning = true;
        if (isInitialized)
        {
            processCachedMessages();
            ((NotificationManager)activity.getSystemService("notification")).cancel(8647);
        }
    }

    public void onStop()
    {
        android.content.SharedPreferences.Editor editor = activity.getSharedPreferences("TextingState", 0).edit();
        editor.putInt("receiving2", receivingEnabled);
        editor.putBoolean("gvenabled", googleVoiceEnabled);
        editor.commit();
    }







/*
    static String access$302(Texting texting, String s)
    {
        texting.authToken = s;
        return s;
    }

*/




/*
    static GoogleVoiceUtil access$502(Texting texting, GoogleVoiceUtil googlevoiceutil)
    {
        texting.gvHelper = googlevoiceutil;
        return googlevoiceutil;
    }

*/
}
