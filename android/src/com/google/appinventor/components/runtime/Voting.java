// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.WebServiceUtil;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, EventDispatcher

public class Voting extends AndroidNonvisibleComponent
    implements Component
{

    private static final String BALLOT_OPTIONS_PARAMETER = "options";
    private static final String BALLOT_QUESTION_PARAMETER = "question";
    private static final String ID_REQUESTED_PARAMETER = "idRequested";
    private static final String IS_POLLING_PARAMETER = "isPolling";
    private static final String LOG_TAG = "Voting";
    private static final String REQUESTBALLOT_COMMAND = "requestballot";
    private static final String SENDBALLOT_COMMAND = "sendballot";
    private static final String USER_CHOICE_PARAMETER = "userchoice";
    private static final String USER_ID_PARAMETER = "userid";
    private Activity activityContext;
    private Handler androidUIHandler;
    private ArrayList ballotOptions;
    private String ballotOptionsString;
    private String ballotQuestion;
    private Boolean idRequested;
    private Boolean isPolling;
    private String serviceURL;
    private ComponentContainer theContainer;
    private String userChoice;
    private String userId;

    public Voting(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        serviceURL = "http://androvote.appspot.com";
        userId = "";
        isPolling = Boolean.valueOf(false);
        idRequested = Boolean.valueOf(false);
        ballotQuestion = "";
        ballotOptions = new ArrayList();
        userChoice = "";
        androidUIHandler = new Handler();
        theContainer = componentcontainer;
        activityContext = componentcontainer.$context();
        serviceURL = "http://androvote.appspot.com";
    }

    private ArrayList JSONArrayToArrayList(JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(jsonarray.getString(i));
        }

        return arraylist;
    }

    private void postRequestBallot()
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final Voting this$0;

            public void onFailure(String s)
            {
                Log.w("Voting", (new StringBuilder()).append("postRequestBallot Failure ").append(s).toString());
                androidUIHandler.post(s. new Runnable() {

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

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                if (jsonobject == null)
                {
                    androidUIHandler.post(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            WebServiceError("The Web server did not respond to your request for a ballot");
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    return;
                }
                try
                {
                    Log.i("Voting", (new StringBuilder()).append("postRequestBallot: ballot retrieved ").append(jsonobject).toString());
                    isPolling = Boolean.valueOf(jsonobject.getBoolean("isPolling"));
                    if (isPolling.booleanValue())
                    {
                        idRequested = Boolean.valueOf(jsonobject.getBoolean("idRequested"));
                        ballotQuestion = jsonobject.getString("question");
                        ballotOptionsString = jsonobject.getString("options");
                        ballotOptions = JSONArrayToArrayList(new JSONArray(ballotOptionsString));
                        androidUIHandler.post(new Runnable() {

                            final _cls2 this$1;

                            public void run()
                            {
                                GotBallot();
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        });
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    androidUIHandler.post(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            WebServiceError("The Web server returned a garbled object");
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    return;
                }
                androidUIHandler.post(new Runnable() {

                    final _cls2 this$1;

                    public void run()
                    {
                        NoOpenPoll();
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
                return;
            }

            
            {
                this$0 = Voting.this;
                super();
            }
        };
        WebServiceUtil.getInstance().postCommandReturningObject(serviceURL, "requestballot", null, asynccallbackpair);
    }

    private void postSendBallot(String s, String s1)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final Voting this$0;

            public void onFailure(String s2)
            {
                Log.w("Voting", (new StringBuilder()).append("postSendBallot Failure ").append(s2).toString());
                androidUIHandler.post(s2. new Runnable() {

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
                onSuccess((String)obj);
            }

            public void onSuccess(String s2)
            {
                androidUIHandler.post(new Runnable() {

                    final _cls4 this$1;

                    public void run()
                    {
                        GotBallotConfirmation();
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
            }

            
            {
                this$0 = Voting.this;
                super();
            }
        };
        WebServiceUtil.getInstance().postCommand(serviceURL, "sendballot", Lists.newArrayList(new NameValuePair[] {
            new BasicNameValuePair("userchoice", s), new BasicNameValuePair("userid", s1)
        }), asynccallbackpair);
    }

    public List BallotOptions()
    {
        return ballotOptions;
    }

    public String BallotQuestion()
    {
        return ballotQuestion;
    }

    public void GotBallot()
    {
        EventDispatcher.dispatchEvent(this, "GotBallot", new Object[0]);
    }

    public void GotBallotConfirmation()
    {
        EventDispatcher.dispatchEvent(this, "GotBallotConfirmation", new Object[0]);
    }

    public void NoOpenPoll()
    {
        EventDispatcher.dispatchEvent(this, "NoOpenPoll", new Object[0]);
    }

    public void RequestBallot()
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final Voting this$0;

            public void run()
            {
                postRequestBallot();
            }

            
            {
                this$0 = Voting.this;
                super();
            }
        });
    }

    public void SendBallot()
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final Voting this$0;

            public void run()
            {
                postSendBallot(userChoice, userId);
            }

            
            {
                this$0 = Voting.this;
                super();
            }
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

    public String UserChoice()
    {
        return userChoice;
    }

    public void UserChoice(String s)
    {
        userChoice = s;
    }

    public String UserEmailAddress()
    {
        return "";
    }

    public String UserId()
    {
        return userId;
    }

    public void UserId(String s)
    {
        userId = s;
    }

    public void WebServiceError(String s)
    {
        EventDispatcher.dispatchEvent(this, "WebServiceError", new Object[] {
            s
        });
    }






/*
    static Boolean access$202(Voting voting, Boolean boolean1)
    {
        voting.isPolling = boolean1;
        return boolean1;
    }

*/


/*
    static Boolean access$302(Voting voting, Boolean boolean1)
    {
        voting.idRequested = boolean1;
        return boolean1;
    }

*/


/*
    static String access$402(Voting voting, String s)
    {
        voting.ballotQuestion = s;
        return s;
    }

*/



/*
    static String access$502(Voting voting, String s)
    {
        voting.ballotOptionsString = s;
        return s;
    }

*/


/*
    static ArrayList access$602(Voting voting, ArrayList arraylist)
    {
        voting.ballotOptions = arraylist;
        return arraylist;
    }

*/



}
