// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.WebServiceUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, EventDispatcher

public class TinyWebDB extends AndroidNonvisibleComponent
    implements Component
{

    private static final String GETVALUE_COMMAND = "getvalue";
    private static final String LOG_TAG = "TinyWebDB";
    private static final String STOREAVALUE_COMMAND = "storeavalue";
    private static final String TAG_PARAMETER = "tag";
    private static final String VALUE_PARAMETER = "value";
    private Handler androidUIHandler;
    private String serviceURL;

    public TinyWebDB(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        androidUIHandler = new Handler();
        serviceURL = "http://appinvtinywebdb.appspot.com/";
    }

    private void postGetValue(final String tag)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final TinyWebDB this$0;
            final String val$tag;

            public void onFailure(String s)
            {
                androidUIHandler.post(s. new Runnable() {

                    final _cls4 this$1;
                    final String val$message;

                    public void run()
                    {
                        WebServiceError(message);
                    }

            
            {
                this$1 = final__pcls4;
                message = String.this;
                super();
            }
                });
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONArray)obj);
            }

            public void onSuccess(JSONArray jsonarray)
            {
                if (jsonarray == null)
                {
                    androidUIHandler.post(new Runnable() {

                        final _cls4 this$1;

                        public void run()
                        {
                            WebServiceError((new StringBuilder()).append("The Web server did not respond to the get value request for the tag ").append(tag).append(".").toString());
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                    return;
                }
                final String tagFromWebDB;
                tagFromWebDB = jsonarray.getString(1);
                jsonarray = jsonarray.getString(2);
                if (jsonarray.length() != 0)
                {
                    break MISSING_BLOCK_LABEL_89;
                }
                jsonarray = "";
_L1:
                try
                {
                    androidUIHandler.post(jsonarray. new Runnable() {

                        final _cls4 this$1;
                        final String val$tagFromWebDB;
                        final Object val$valueFromWebDB;

                        public void run()
                        {
                            GotValue(tagFromWebDB, valueFromWebDB);
                        }

            
            {
                this$1 = final__pcls4;
                tagFromWebDB = s;
                valueFromWebDB = Object.this;
                super();
            }
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (JSONArray jsonarray)
                {
                    androidUIHandler.post(new Runnable() {

                        final _cls4 this$1;

                        public void run()
                        {
                            WebServiceError((new StringBuilder()).append("The Web server returned a garbled value for the tag ").append(tag).append(".").toString());
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    });
                }
                return;
                jsonarray = ((JSONArray) (JsonUtil.getObjectFromJson(jsonarray)));
                  goto _L1
            }

            
            {
                this$0 = TinyWebDB.this;
                tag = s;
                super();
            }
        };
        WebServiceUtil.getInstance().postCommandReturningArray(serviceURL, "getvalue", Lists.newArrayList(new NameValuePair[] {
            new BasicNameValuePair("tag", tag)
        }), asynccallbackpair);
    }

    private void postStoreValue(String s, Object obj)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final TinyWebDB this$0;

            public void onFailure(String s1)
            {
                androidUIHandler.post(s1. new Runnable() {

                    final _cls2 this$1;
                    final String val$message;

                    public void run()
                    {
                        WebServiceError(message);
                    }

            
            {
                this$1 = final__pcls2;
                message = String.this;
                super();
            }
                });
            }

            public volatile void onSuccess(Object obj1)
            {
                onSuccess((String)obj1);
            }

            public void onSuccess(String s1)
            {
                androidUIHandler.post(new Runnable() {

                    final _cls2 this$1;

                    public void run()
                    {
                        ValueStored();
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            
            {
                this$0 = TinyWebDB.this;
                super();
            }
        };
        try
        {
            WebServiceUtil.getInstance().postCommand(serviceURL, "storeavalue", Lists.newArrayList(new NameValuePair[] {
                new BasicNameValuePair("tag", s), new BasicNameValuePair("value", JsonUtil.getJsonRepresentation(obj))
            }), asynccallbackpair);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new YailRuntimeError("Value failed to convert to JSON.", "JSON Creation Error.");
        }
    }

    public void GetValue(final String tag)
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final TinyWebDB this$0;
            final String val$tag;

            public void run()
            {
                postGetValue(tag);
            }

            
            {
                this$0 = TinyWebDB.this;
                tag = s;
                super();
            }
        });
    }

    public void GotValue(String s, Object obj)
    {
        EventDispatcher.dispatchEvent(this, "GotValue", new Object[] {
            s, obj
        });
    }

    public String ServiceURL()
    {
        return serviceURL;
    }

    public void ServiceURL(String s)
    {
        serviceURL = s;
    }

    public void StoreValue(final String tag, final Object valueToStore)
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final TinyWebDB this$0;
            final String val$tag;
            final Object val$valueToStore;

            public void run()
            {
                postStoreValue(tag, valueToStore);
            }

            
            {
                this$0 = TinyWebDB.this;
                tag = s;
                valueToStore = obj;
                super();
            }
        });
    }

    public void ValueStored()
    {
        EventDispatcher.dispatchEvent(this, "ValueStored", new Object[0]);
    }

    public void WebServiceError(String s)
    {
        EventDispatcher.dispatchEvent(this, "WebServiceError", new Object[] {
            s
        });
    }



}
