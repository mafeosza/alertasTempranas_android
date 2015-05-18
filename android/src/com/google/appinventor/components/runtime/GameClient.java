// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.GameInstance;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.PlayerListDelta;
import com.google.appinventor.components.runtime.util.WebServiceUtil;
import com.google.appinventor.components.runtime.util.YailList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, OnResumeListener, OnStopListener, 
//            ComponentContainer, Form, EventDispatcher

public class GameClient extends AndroidNonvisibleComponent
    implements Component, OnResumeListener, OnStopListener
{

    private static final String COMMAND_ARGUMENTS_KEY = "args";
    private static final String COMMAND_TYPE_KEY = "command";
    private static final String COUNT_KEY = "count";
    private static final String ERROR_RESPONSE_KEY = "e";
    private static final String GAME_ID_KEY = "gid";
    private static final String GET_INSTANCE_LISTS_COMMAND = "getinstancelists";
    private static final String GET_MESSAGES_COMMAND = "messages";
    private static final String INSTANCE_ID_KEY = "iid";
    private static final String INSTANCE_PUBLIC_KEY = "makepublic";
    private static final String INVITED_LIST_KEY = "invited";
    private static final String INVITEE_KEY = "inv";
    private static final String INVITE_COMMAND = "invite";
    private static final String JOINED_LIST_KEY = "joined";
    private static final String JOIN_INSTANCE_COMMAND = "joininstance";
    private static final String LEADER_KEY = "leader";
    private static final String LEAVE_INSTANCE_COMMAND = "leaveinstance";
    private static final String LOG_TAG = "GameClient";
    private static final String MESSAGES_LIST_KEY = "messages";
    private static final String MESSAGE_CONTENT_KEY = "contents";
    private static final String MESSAGE_RECIPIENTS_KEY = "mrec";
    private static final String MESSAGE_SENDER_KEY = "msender";
    private static final String MESSAGE_TIME_KEY = "mtime";
    private static final String NEW_INSTANCE_COMMAND = "newinstance";
    private static final String NEW_MESSAGE_COMMAND = "newmessage";
    private static final String PLAYERS_LIST_KEY = "players";
    private static final String PLAYER_ID_KEY = "pid";
    private static final String PUBLIC_LIST_KEY = "public";
    private static final String SERVER_COMMAND = "servercommand";
    private static final String SERVER_RETURN_VALUE_KEY = "response";
    private static final String SET_LEADER_COMMAND = "setleader";
    private static final String TYPE_KEY = "type";
    private Activity activityContext;
    private Handler androidUIHandler;
    private String gameId;
    private GameInstance instance;
    private List invitedInstances;
    private List joinedInstances;
    private List publicInstances;
    private String serviceUrl;
    private String userEmailAddress;

    public GameClient(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        userEmailAddress = "";
        androidUIHandler = new Handler();
        activityContext = componentcontainer.$context();
        form.registerForOnResume(this);
        form.registerForOnStop(this);
        gameId = "";
        instance = new GameInstance("");
        joinedInstances = Lists.newArrayList();
        invitedInstances = Lists.newArrayList();
        publicInstances = Lists.newArrayList();
        serviceUrl = "http://appinvgameserver.appspot.com";
    }

    private void postCommandToGameServer(String s, List list, AsyncCallbackPair asynccallbackpair)
    {
        postCommandToGameServer(s, list, asynccallbackpair, false);
    }

    private void postCommandToGameServer(final String commandName, final List params, final AsyncCallbackPair callback, final boolean allowInstanceIdChange)
    {
        callback = new AsyncCallbackPair() {

            final GameClient this$0;
            final boolean val$allowInstanceIdChange;
            final AsyncCallbackPair val$callback;
            final String val$commandName;
            final List val$params;

            public void onFailure(String s)
            {
                Log.d("GameClient", (new StringBuilder()).append("Posting to server failed for ").append(commandName).append(" with arguments ").append(params).append("\n Failure message: ").append(s).toString());
                callback.onFailure(s);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                Log.d("GameClient", (new StringBuilder()).append("Received response for ").append(commandName).append(": ").append(jsonobject.toString()).toString());
                String s;
                try
                {
                    if (jsonobject.getBoolean("e"))
                    {
                        callback.onFailure(jsonobject.getString("response"));
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    Log.w("GameClient", jsonobject);
                    callback.onFailure((new StringBuilder()).append("Failed to parse JSON response to command ").append(commandName).toString());
                    return;
                }
                s = jsonobject.getString("gid");
                if (!s.equals(GameId()))
                {
                    Info((new StringBuilder()).append("Incorrect game id in response: + ").append(s).append(".").toString());
                    return;
                }
                String s1;
                s1 = jsonobject.getString("iid");
                if (s1.equals(""))
                {
                    callback.onSuccess(jsonobject.getJSONObject("response"));
                    return;
                }
                if (!s1.equals(InstanceId()))
                {
                    break MISSING_BLOCK_LABEL_228;
                }
                updateInstanceInfo(jsonobject);
_L2:
                callback.onSuccess(jsonobject.getJSONObject("response"));
                return;
label0:
                {
                    if (!allowInstanceIdChange && !InstanceId().equals(""))
                    {
                        break label0;
                    }
                    instance = new GameInstance(s1);
                    updateInstanceInfo(jsonobject);
                    InstanceIdChanged(s1);
                }
                if (true) goto _L2; else goto _L1
_L1:
                Info((new StringBuilder()).append("Ignored server response to ").append(commandName).append(" for incorrect instance ").append(s1).append(".").toString());
                return;
            }

            
            {
                this$0 = GameClient.this;
                commandName = s;
                callback = asynccallbackpair;
                allowInstanceIdChange = flag;
                params = list;
                super();
            }
        };
        WebServiceUtil.getInstance().postCommandReturningObject(ServiceUrl(), commandName, params, callback);
    }

    private void postGetInstanceLists()
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final GameClient this$0;

            public void onFailure(String s)
            {
                WebServiceError("GetInstanceLists", "Failed to get up to date instance lists.");
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                processInstanceLists(jsonobject);
                FunctionCompleted("GetInstanceLists");
            }

            
            {
                this$0 = GameClient.this;
                super();
            }
        };
        postCommandToGameServer("getinstancelists", Lists.newArrayList(new NameValuePair[] {
            new BasicNameValuePair("gid", GameId()), new BasicNameValuePair("iid", InstanceId()), new BasicNameValuePair("pid", UserEmailAddress())
        }), asynccallbackpair);
    }

    private void postGetMessages(final String requestedType, int i)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final GameClient this$0;
            final String val$requestedType;

            public void onFailure(String s)
            {
                WebServiceError("GetMessages", s);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                int k;
                k = jsonobject.getInt("count");
                jsonobject = jsonobject.getJSONArray("messages");
                int j = 0;
_L2:
                if (j >= k)
                {
                    break; /* Loop/switch isn't completed */
                }
                Object obj = jsonobject.getJSONObject(j);
                String s = ((JSONObject) (obj)).getString("type");
                String s1 = ((JSONObject) (obj)).getString("msender");
                String s2 = ((JSONObject) (obj)).getString("mtime");
                obj = JsonUtil.getListFromJsonArray(((JSONObject) (obj)).getJSONArray("contents"));
                if (requestedType.equals(""))
                {
                    instance.putMessageTime(requestedType, s2);
                }
                instance.putMessageTime(s, s2);
                GotMessage(s, s1, ((List) (obj)));
                j++;
                if (true) goto _L2; else goto _L1
                jsonobject;
                Log.w("GameClient", jsonobject);
                Info("Failed to parse messages response.");
_L1:
                FunctionCompleted("GetMessages");
                return;
            }

            
            {
                this$0 = GameClient.this;
                requestedType = s;
                super();
            }
        };
        if (InstanceId().equals(""))
        {
            Info("You must join an instance before attempting to fetch messages.");
            return;
        } else
        {
            postCommandToGameServer("messages", Lists.newArrayList(new NameValuePair[] {
                new BasicNameValuePair("gid", GameId()), new BasicNameValuePair("iid", InstanceId()), new BasicNameValuePair("pid", UserEmailAddress()), new BasicNameValuePair("count", Integer.toString(i)), new BasicNameValuePair("mtime", instance.getMessageTime(requestedType)), new BasicNameValuePair("type", requestedType)
            }), asynccallbackpair);
            return;
        }
    }

    private void postInvite(String s)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final GameClient this$0;

            public void onFailure(String s1)
            {
                WebServiceError("Invite", s1);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                jsonobject = jsonobject.getString("inv");
                if (!jsonobject.equals("")) goto _L2; else goto _L1
_L1:
                Info((new StringBuilder()).append(jsonobject).append(" was already invited.").toString());
_L4:
                FunctionCompleted("Invite");
                return;
_L2:
                try
                {
                    Info((new StringBuilder()).append("Successfully invited ").append(jsonobject).append(".").toString());
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    Log.w("GameClient", jsonobject);
                    Info("Failed to parse invite player response.");
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = GameClient.this;
                super();
            }
        };
        if (InstanceId().equals(""))
        {
            Info("You must have joined an instance before you can invite new players.");
            return;
        } else
        {
            postCommandToGameServer("invite", Lists.newArrayList(new NameValuePair[] {
                new BasicNameValuePair("gid", GameId()), new BasicNameValuePair("iid", InstanceId()), new BasicNameValuePair("pid", UserEmailAddress()), new BasicNameValuePair("inv", s)
            }), asynccallbackpair);
            return;
        }
    }

    private void postLeaveInstance()
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final GameClient this$0;

            public void onFailure(String s)
            {
                WebServiceError("LeaveInstance", s);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                SetInstance("");
                processInstanceLists(jsonobject);
                FunctionCompleted("LeaveInstance");
            }

            
            {
                this$0 = GameClient.this;
                super();
            }
        };
        postCommandToGameServer("leaveinstance", Lists.newArrayList(new NameValuePair[] {
            new BasicNameValuePair("gid", GameId()), new BasicNameValuePair("iid", InstanceId()), new BasicNameValuePair("pid", UserEmailAddress())
        }), asynccallbackpair);
    }

    private void postMakeNewInstance(String s, Boolean boolean1)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final GameClient this$0;

            public void onFailure(String s1)
            {
                WebServiceError("MakeNewInstance", s1);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                processInstanceLists(jsonobject);
                NewInstanceMade(InstanceId());
                FunctionCompleted("MakeNewInstance");
            }

            
            {
                this$0 = GameClient.this;
                super();
            }
        };
        postCommandToGameServer("newinstance", Lists.newArrayList(new NameValuePair[] {
            new BasicNameValuePair("pid", UserEmailAddress()), new BasicNameValuePair("gid", GameId()), new BasicNameValuePair("iid", s), new BasicNameValuePair("makepublic", boolean1.toString())
        }), asynccallbackpair, true);
    }

    private void postNewMessage(String s, YailList yaillist, YailList yaillist1)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final GameClient this$0;

            public void onFailure(String s1)
            {
                WebServiceError("SendMessage", s1);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                FunctionCompleted("SendMessage");
            }

            
            {
                this$0 = GameClient.this;
                super();
            }
        };
        if (InstanceId().equals(""))
        {
            Info("You must have joined an instance before you can send messages.");
            return;
        } else
        {
            postCommandToGameServer("newmessage", Lists.newArrayList(new NameValuePair[] {
                new BasicNameValuePair("gid", GameId()), new BasicNameValuePair("iid", InstanceId()), new BasicNameValuePair("pid", UserEmailAddress()), new BasicNameValuePair("type", s), new BasicNameValuePair("mrec", yaillist.toJSONString()), new BasicNameValuePair("contents", yaillist1.toJSONString()), new BasicNameValuePair("mtime", instance.getMessageTime(s))
            }), asynccallbackpair);
            return;
        }
    }

    private void postServerCommand(final String command, final YailList arguments)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final GameClient this$0;
            final YailList val$arguments;
            final String val$command;

            public void onFailure(String s)
            {
                ServerCommandFailure(command, arguments);
                WebServiceError("ServerCommand", s);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                try
                {
                    ServerCommandSuccess(command, JsonUtil.getListFromJsonArray(jsonobject.getJSONArray("contents")));
                }
                // Misplaced declaration of an exception variable
                catch (JSONObject jsonobject)
                {
                    Log.w("GameClient", jsonobject);
                    Info("Server command response failed to parse.");
                }
                FunctionCompleted("ServerCommand");
            }

            
            {
                this$0 = GameClient.this;
                command = s;
                arguments = yaillist;
                super();
            }
        };
        Log.d("GameClient", (new StringBuilder()).append("Going to post ").append(command).append(" with args ").append(arguments).toString());
        postCommandToGameServer("servercommand", Lists.newArrayList(new NameValuePair[] {
            new BasicNameValuePair("gid", GameId()), new BasicNameValuePair("iid", InstanceId()), new BasicNameValuePair("pid", UserEmailAddress()), new BasicNameValuePair("command", command), new BasicNameValuePair("args", arguments.toJSONString())
        }), asynccallbackpair);
    }

    private void postSetInstance(String s)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final GameClient this$0;

            public void onFailure(String s1)
            {
                WebServiceError("SetInstance", s1);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                processInstanceLists(jsonobject);
                FunctionCompleted("SetInstance");
            }

            
            {
                this$0 = GameClient.this;
                super();
            }
        };
        postCommandToGameServer("joininstance", Lists.newArrayList(new NameValuePair[] {
            new BasicNameValuePair("gid", GameId()), new BasicNameValuePair("iid", s), new BasicNameValuePair("pid", UserEmailAddress())
        }), asynccallbackpair, true);
    }

    private void postSetLeader(String s)
    {
        AsyncCallbackPair asynccallbackpair = new AsyncCallbackPair() {

            final GameClient this$0;

            public void onFailure(String s1)
            {
                WebServiceError("SetLeader", s1);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((JSONObject)obj);
            }

            public void onSuccess(JSONObject jsonobject)
            {
                FunctionCompleted("SetLeader");
            }

            
            {
                this$0 = GameClient.this;
                super();
            }
        };
        if (InstanceId().equals(""))
        {
            Info("You must join an instance before attempting to set a leader.");
            return;
        } else
        {
            postCommandToGameServer("setleader", Lists.newArrayList(new NameValuePair[] {
                new BasicNameValuePair("gid", GameId()), new BasicNameValuePair("iid", InstanceId()), new BasicNameValuePair("pid", UserEmailAddress()), new BasicNameValuePair("leader", s)
            }), asynccallbackpair);
            return;
        }
    }

    private void processInstanceLists(JSONObject jsonobject)
    {
        try
        {
            joinedInstances = JsonUtil.getStringListFromJsonArray(jsonobject.getJSONArray("joined"));
            publicInstances = JsonUtil.getStringListFromJsonArray(jsonobject.getJSONArray("public"));
            Object obj = JsonUtil.getStringListFromJsonArray(jsonobject.getJSONArray("invited"));
            if (!((List) (obj)).equals(InvitedInstances()))
            {
                jsonobject = invitedInstances;
                invitedInstances = ((List) (obj));
                obj = new ArrayList(((java.util.Collection) (obj)));
                ((List) (obj)).removeAll(jsonobject);
                for (jsonobject = ((List) (obj)).iterator(); jsonobject.hasNext(); Invited((String)jsonobject.next())) { }
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.w("GameClient", jsonobject);
            Info("Instance lists failed to parse.");
        }
    }

    private void updateInstanceInfo(JSONObject jsonobject)
        throws JSONException
    {
        boolean flag = false;
        String s = jsonobject.getString("leader");
        jsonobject = JsonUtil.getStringListFromJsonArray(jsonobject.getJSONArray("players"));
        if (!Leader().equals(s))
        {
            instance.setLeader(s);
            flag = true;
        }
        jsonobject = instance.setPlayers(jsonobject);
        if (jsonobject != PlayerListDelta.NO_CHANGE)
        {
            for (Iterator iterator = jsonobject.getPlayersRemoved().iterator(); iterator.hasNext(); PlayerLeft((String)iterator.next())) { }
            for (jsonobject = jsonobject.getPlayersAdded().iterator(); jsonobject.hasNext(); PlayerJoined((String)jsonobject.next())) { }
        }
        if (flag)
        {
            NewLeader(Leader());
        }
    }

    public void FunctionCompleted(final String functionName)
    {
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$functionName;

            public void run()
            {
                Log.d("GameClient", (new StringBuilder()).append("Request completed: ").append(functionName).toString());
                EventDispatcher.dispatchEvent(GameClient.this, "FunctionCompleted", new Object[] {
                    functionName
                });
            }

            
            {
                this$0 = GameClient.this;
                functionName = s;
                super();
            }
        });
    }

    public String GameId()
    {
        return gameId;
    }

    public void GameId(String s)
    {
        gameId = s;
    }

    public void GetInstanceLists()
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final GameClient this$0;

            public void run()
            {
                postGetInstanceLists();
            }

            
            {
                this$0 = GameClient.this;
                super();
            }
        });
    }

    public void GetMessages(final String type, final int count)
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final GameClient this$0;
            final int val$count;
            final String val$type;

            public void run()
            {
                postGetMessages(type, count);
            }

            
            {
                this$0 = GameClient.this;
                type = s;
                count = i;
                super();
            }
        });
    }

    public void GotMessage(final String type, final String sender, final List contents)
    {
        Log.d("GameClient", (new StringBuilder()).append("Got message of type ").append(type).toString());
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final List val$contents;
            final String val$sender;
            final String val$type;

            public void run()
            {
                EventDispatcher.dispatchEvent(GameClient.this, "GotMessage", new Object[] {
                    type, sender, contents
                });
            }

            
            {
                this$0 = GameClient.this;
                type = s;
                sender = s1;
                contents = list;
                super();
            }
        });
    }

    public void Info(final String message)
    {
        Log.d("GameClient", (new StringBuilder()).append("Info: ").append(message).toString());
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$message;

            public void run()
            {
                EventDispatcher.dispatchEvent(GameClient.this, "Info", new Object[] {
                    message
                });
            }

            
            {
                this$0 = GameClient.this;
                message = s;
                super();
            }
        });
    }

    public void Initialize()
    {
        Log.d("GameClient", "Initialize");
        if (gameId.equals(""))
        {
            throw new YailRuntimeError("Game Id must not be empty.", "GameClient Configuration Error.");
        } else
        {
            return;
        }
    }

    public String InstanceId()
    {
        return instance.getInstanceId();
    }

    public void InstanceIdChanged(final String instanceId)
    {
        Log.d("GameClient", (new StringBuilder()).append("Instance id changed to ").append(instanceId).toString());
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$instanceId;

            public void run()
            {
                EventDispatcher.dispatchEvent(GameClient.this, "InstanceIdChanged", new Object[] {
                    instanceId
                });
            }

            
            {
                this$0 = GameClient.this;
                instanceId = s;
                super();
            }
        });
    }

    public void Invite(final String playerEmail)
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final GameClient this$0;
            final String val$playerEmail;

            public void run()
            {
                postInvite(playerEmail);
            }

            
            {
                this$0 = GameClient.this;
                playerEmail = s;
                super();
            }
        });
    }

    public void Invited(final String instanceId)
    {
        Log.d("GameClient", (new StringBuilder()).append("Player invited to ").append(instanceId).toString());
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$instanceId;

            public void run()
            {
                EventDispatcher.dispatchEvent(GameClient.this, "Invited", new Object[] {
                    instanceId
                });
            }

            
            {
                this$0 = GameClient.this;
                instanceId = s;
                super();
            }
        });
    }

    public List InvitedInstances()
    {
        return invitedInstances;
    }

    public List JoinedInstances()
    {
        return joinedInstances;
    }

    public String Leader()
    {
        return instance.getLeader();
    }

    public void LeaveInstance()
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final GameClient this$0;

            public void run()
            {
                postLeaveInstance();
            }

            
            {
                this$0 = GameClient.this;
                super();
            }
        });
    }

    public void MakeNewInstance(final String instanceId, final boolean makePublic)
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final GameClient this$0;
            final String val$instanceId;
            final boolean val$makePublic;

            public void run()
            {
                postMakeNewInstance(instanceId, Boolean.valueOf(makePublic));
            }

            
            {
                this$0 = GameClient.this;
                instanceId = s;
                makePublic = flag;
                super();
            }
        });
    }

    public void NewInstanceMade(final String instanceId)
    {
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$instanceId;

            public void run()
            {
                Log.d("GameClient", (new StringBuilder()).append("New instance made: ").append(instanceId).toString());
                EventDispatcher.dispatchEvent(GameClient.this, "NewInstanceMade", new Object[] {
                    instanceId
                });
            }

            
            {
                this$0 = GameClient.this;
                instanceId = s;
                super();
            }
        });
    }

    public void NewLeader(final String playerId)
    {
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$playerId;

            public void run()
            {
                Log.d("GameClient", (new StringBuilder()).append("Leader change to ").append(playerId).toString());
                EventDispatcher.dispatchEvent(GameClient.this, "NewLeader", new Object[] {
                    playerId
                });
            }

            
            {
                this$0 = GameClient.this;
                playerId = s;
                super();
            }
        });
    }

    public void PlayerJoined(final String playerId)
    {
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$playerId;

            public void run()
            {
                if (!playerId.equals(UserEmailAddress()))
                {
                    Log.d("GameClient", (new StringBuilder()).append("Player joined: ").append(playerId).toString());
                    EventDispatcher.dispatchEvent(GameClient.this, "PlayerJoined", new Object[] {
                        playerId
                    });
                }
            }

            
            {
                this$0 = GameClient.this;
                playerId = s;
                super();
            }
        });
    }

    public void PlayerLeft(final String playerId)
    {
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$playerId;

            public void run()
            {
                Log.d("GameClient", (new StringBuilder()).append("Player left: ").append(playerId).toString());
                EventDispatcher.dispatchEvent(GameClient.this, "PlayerLeft", new Object[] {
                    playerId
                });
            }

            
            {
                this$0 = GameClient.this;
                playerId = s;
                super();
            }
        });
    }

    public List Players()
    {
        return instance.getPlayers();
    }

    public List PublicInstances()
    {
        return publicInstances;
    }

    public void SendMessage(final String type, final YailList recipients, final YailList contents)
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final GameClient this$0;
            final YailList val$contents;
            final YailList val$recipients;
            final String val$type;

            public void run()
            {
                postNewMessage(type, recipients, contents);
            }

            
            {
                this$0 = GameClient.this;
                type = s;
                recipients = yaillist;
                contents = yaillist1;
                super();
            }
        });
    }

    public void ServerCommand(final String command, final YailList arguments)
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final GameClient this$0;
            final YailList val$arguments;
            final String val$command;

            public void run()
            {
                postServerCommand(command, arguments);
            }

            
            {
                this$0 = GameClient.this;
                command = s;
                arguments = yaillist;
                super();
            }
        });
    }

    public void ServerCommandFailure(final String command, final YailList arguments)
    {
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final YailList val$arguments;
            final String val$command;

            public void run()
            {
                Log.d("GameClient", (new StringBuilder()).append("Server command failed: ").append(command).toString());
                EventDispatcher.dispatchEvent(GameClient.this, "ServerCommandFailure", new Object[] {
                    command, arguments
                });
            }

            
            {
                this$0 = GameClient.this;
                command = s;
                arguments = yaillist;
                super();
            }
        });
    }

    public void ServerCommandSuccess(final String command, final List response)
    {
        Log.d("GameClient", (new StringBuilder()).append(command).append(" server command returned.").toString());
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$command;
            final List val$response;

            public void run()
            {
                EventDispatcher.dispatchEvent(GameClient.this, "ServerCommandSuccess", new Object[] {
                    command, response
                });
            }

            
            {
                this$0 = GameClient.this;
                command = s;
                response = list;
                super();
            }
        });
    }

    public void ServiceURL(String s)
    {
        if (s.endsWith("/"))
        {
            serviceUrl = s.substring(0, s.length() - 1);
            return;
        } else
        {
            serviceUrl = s;
            return;
        }
    }

    public String ServiceUrl()
    {
        return serviceUrl;
    }

    public void SetInstance(final String instanceId)
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final GameClient this$0;
            final String val$instanceId;

            public void run()
            {
                if (instanceId.equals(""))
                {
                    Log.d("GameClient", "Instance id set to empty string.");
                    if (!InstanceId().equals(""))
                    {
                        instance = new GameInstance("");
                        InstanceIdChanged("");
                        FunctionCompleted("SetInstance");
                    }
                    return;
                } else
                {
                    postSetInstance(instanceId);
                    return;
                }
            }

            
            {
                this$0 = GameClient.this;
                instanceId = s;
                super();
            }
        });
    }

    public void SetLeader(final String playerEmail)
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final GameClient this$0;
            final String val$playerEmail;

            public void run()
            {
                postSetLeader(playerEmail);
            }

            
            {
                this$0 = GameClient.this;
                playerEmail = s;
                super();
            }
        });
    }

    public String UserEmailAddress()
    {
        if (userEmailAddress.equals(""))
        {
            Info("User email address is empty.");
        }
        return userEmailAddress;
    }

    public void UserEmailAddress(String s)
    {
        userEmailAddress = s;
        UserEmailAddressSet(s);
    }

    public void UserEmailAddressSet(final String emailAddress)
    {
        Log.d("GameClient", "Email address set.");
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$emailAddress;

            public void run()
            {
                EventDispatcher.dispatchEvent(GameClient.this, "UserEmailAddressSet", new Object[] {
                    emailAddress
                });
            }

            
            {
                this$0 = GameClient.this;
                emailAddress = s;
                super();
            }
        });
    }

    public void WebServiceError(final String functionName, final String message)
    {
        Log.e("GameClient", (new StringBuilder()).append("WebServiceError: ").append(message).toString());
        androidUIHandler.post(new Runnable() {

            final GameClient this$0;
            final String val$functionName;
            final String val$message;

            public void run()
            {
                EventDispatcher.dispatchEvent(GameClient.this, "WebServiceError", new Object[] {
                    functionName, message
                });
            }

            
            {
                this$0 = GameClient.this;
                functionName = s;
                message = s1;
                super();
            }
        });
    }

    public void onResume()
    {
        Log.d("GameClient", "Activity Resumed.");
    }

    public void onStop()
    {
        Log.d("GameClient", "Activity Stopped.");
    }








/*
    static GameInstance access$302(GameClient gameclient, GameInstance gameinstance)
    {
        gameclient.instance = gameinstance;
        return gameinstance;
    }

*/






}
