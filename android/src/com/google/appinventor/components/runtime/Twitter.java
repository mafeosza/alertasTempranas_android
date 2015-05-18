// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import twitter4j.DirectMessage;
import twitter4j.IDs;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, ActivityResultListener, Component, WebViewActivity, 
//            ComponentContainer, Form, EventDispatcher

public final class Twitter extends AndroidNonvisibleComponent
    implements ActivityResultListener, Component
{

    private static final String ACCESS_SECRET_TAG = "TwitterOauthAccessSecret";
    private static final String ACCESS_TOKEN_TAG = "TwitterOauthAccessToken";
    private static final String CALLBACK_URL = "appinventor://twitter";
    private static final String MAX_CHARACTERS = "160";
    private static final String MAX_MENTIONS_RETURNED = "20";
    private static final String URL_HOST = "twitter";
    private static final String WEBVIEW_ACTIVITY_CLASS = com/google/appinventor/components/runtime/WebViewActivity.getName();
    private String TwitPic_API_Key;
    private AccessToken accessToken;
    private String consumerKey;
    private String consumerSecret;
    private final ComponentContainer container;
    private final List directMessages = new ArrayList();
    private final List followers = new ArrayList();
    private final Handler handler = new Handler();
    private final List mentions = new ArrayList();
    private final int requestCode;
    private RequestToken requestToken;
    private final List searchResults = new ArrayList();
    private final SharedPreferences sharedPreferences;
    private final List timeline = new ArrayList();
    private twitter4j.Twitter twitter;
    private String userName;

    public Twitter(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        consumerKey = "";
        consumerSecret = "";
        TwitPic_API_Key = "";
        userName = "";
        container = componentcontainer;
        sharedPreferences = componentcontainer.$context().getSharedPreferences("Twitter", 0);
        accessToken = retrieveAccessToken();
        requestCode = form.registerForActivityResult(this);
    }

    private boolean checkAccessToken(String s, String s1)
    {
        accessToken = retrieveAccessToken();
        if (accessToken == null)
        {
            return false;
        }
        if (twitter == null)
        {
            twitter = (new TwitterFactory()).getInstance();
        }
        try
        {
            twitter.setOAuthConsumer(consumerKey, consumerSecret);
            twitter.setOAuthAccessToken(accessToken);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (userName.trim().length() == 0)
        {
            try
            {
                userName = twitter.verifyCredentials().getScreenName();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                deAuthorize();
                return false;
            }
        }
        return true;
    }

    private void deAuthorize()
    {
        requestToken = null;
        accessToken = null;
        userName = "";
        twitter4j.Twitter twitter1 = twitter;
        twitter = null;
        saveAccessToken(accessToken);
        if (twitter1 != null)
        {
            twitter1.setOAuthAccessToken(null);
        }
    }

    private AccessToken retrieveAccessToken()
    {
        String s = sharedPreferences.getString("TwitterOauthAccessToken", "");
        String s1 = sharedPreferences.getString("TwitterOauthAccessSecret", "");
        if (s.length() == 0 || s1.length() == 0)
        {
            return null;
        } else
        {
            return new AccessToken(s, s1);
        }
    }

    private void saveAccessToken(AccessToken accesstoken)
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        if (accesstoken == null)
        {
            editor.remove("TwitterOauthAccessToken");
            editor.remove("TwitterOauthAccessSecret");
        } else
        {
            editor.putString("TwitterOauthAccessToken", accesstoken.getToken());
            editor.putString("TwitterOauthAccessSecret", accesstoken.getTokenSecret());
        }
        editor.commit();
    }

    public void Authorize()
    {
        if (consumerKey.length() == 0 || consumerSecret.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "Authorize", 302, new Object[0]);
            return;
        }
        if (twitter == null)
        {
            twitter = (new TwitterFactory()).getInstance();
        }
        AsynchUtil.runAsynchronously(new Runnable() {

            final Twitter this$0;
            final String val$myConsumerKey;
            final String val$myConsumerSecret;

            public void run()
            {
                if (checkAccessToken(myConsumerKey, myConsumerSecret))
                {
                    handler.post(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            IsAuthorized();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    return;
                }
                try
                {
                    twitter.setOAuthConsumer(myConsumerKey, myConsumerSecret);
                    Object obj = twitter.getOAuthRequestToken("appinventor://twitter");
                    String s = ((RequestToken) (obj)).getAuthorizationURL();
                    requestToken = ((RequestToken) (obj));
                    obj = new Intent("android.intent.action.MAIN", Uri.parse(s));
                    ((Intent) (obj)).setClassName(container.$context(), Twitter.WEBVIEW_ACTIVITY_CLASS);
                    container.$context().startActivityForResult(((Intent) (obj)), requestCode);
                    return;
                }
                catch (TwitterException twitterexception)
                {
                    Log.i("Twitter", (new StringBuilder()).append("Got exception: ").append(twitterexception.getMessage()).toString());
                    twitterexception.printStackTrace();
                    form.dispatchErrorOccurredEvent(Twitter.this, "Authorize", 303, new Object[] {
                        twitterexception.getMessage()
                    });
                    DeAuthorize();
                    return;
                }
                catch (IllegalStateException illegalstateexception)
                {
                    Log.e("Twitter", "OAuthConsumer was already set: launch IsAuthorized()");
                }
                handler.post(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        IsAuthorized();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = Twitter.this;
                myConsumerKey = s;
                myConsumerSecret = s1;
                super();
            }
        });
    }

    public void CheckAuthorized()
    {
        AsynchUtil.runAsynchronously(new Runnable() {

            final Twitter this$0;
            final String val$myConsumerKey;
            final String val$myConsumerSecret;

            public void run()
            {
                if (checkAccessToken(myConsumerKey, myConsumerSecret))
                {
                    handler.post(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            IsAuthorized();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = Twitter.this;
                myConsumerKey = s;
                myConsumerSecret = s1;
                super();
            }
        });
    }

    public String ConsumerKey()
    {
        return consumerKey;
    }

    public void ConsumerKey(String s)
    {
        consumerKey = s;
    }

    public String ConsumerSecret()
    {
        return consumerSecret;
    }

    public void ConsumerSecret(String s)
    {
        consumerSecret = s;
    }

    public void DeAuthorize()
    {
        deAuthorize();
    }

    public void DirectMessage(final String user, final String message)
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "DirectMessage", 310, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Twitter this$0;
                final String val$message;
                final String val$user;

                public void run()
                {
                    try
                    {
                        twitter.sendDirectMessage(user, message);
                        return;
                    }
                    catch (TwitterException twitterexception)
                    {
                        form.dispatchErrorOccurredEvent(Twitter.this, "DirectMessage", 310, new Object[] {
                            twitterexception.getMessage()
                        });
                    }
                }

            
            {
                this$0 = Twitter.this;
                user = s;
                message = s1;
                super();
            }
            });
            return;
        }
    }

    public List DirectMessages()
    {
        return directMessages;
    }

    public void DirectMessagesReceived(List list)
    {
        EventDispatcher.dispatchEvent(this, "DirectMessagesReceived", new Object[] {
            list
        });
    }

    public void Follow(final String user)
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "Follow", 311, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Twitter this$0;
                final String val$user;

                public void run()
                {
                    try
                    {
                        twitter.createFriendship(user);
                        return;
                    }
                    catch (TwitterException twitterexception)
                    {
                        form.dispatchErrorOccurredEvent(Twitter.this, "Follow", 311, new Object[] {
                            twitterexception.getMessage()
                        });
                    }
                }

            
            {
                this$0 = Twitter.this;
                user = s;
                super();
            }
            });
            return;
        }
    }

    public List Followers()
    {
        return followers;
    }

    public void FollowersReceived(List list)
    {
        EventDispatcher.dispatchEvent(this, "FollowersReceived", new Object[] {
            list
        });
    }

    public List FriendTimeline()
    {
        return timeline;
    }

    public void FriendTimelineReceived(List list)
    {
        EventDispatcher.dispatchEvent(this, "FriendTimelineReceived", new Object[] {
            list
        });
    }

    public void IsAuthorized()
    {
        EventDispatcher.dispatchEvent(this, "IsAuthorized", new Object[0]);
    }

    public void Login(String s, String s1)
    {
        form.dispatchErrorOccurredEvent(this, "Login", 301, new Object[0]);
    }

    public List Mentions()
    {
        return mentions;
    }

    public void MentionsReceived(List list)
    {
        EventDispatcher.dispatchEvent(this, "MentionsReceived", new Object[] {
            list
        });
    }

    public void RequestDirectMessages()
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "RequestDirectMessages", 309, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                List messages;
                final Twitter this$0;

                public void run()
                {
                    messages = twitter.getDirectMessages();
                    handler.post(new Runnable() {

                        final _cls8 this$1;

                        public void run()
                        {
                            directMessages.clear();
                            DirectMessage directmessage;
                            for (Iterator iterator = messages.iterator(); iterator.hasNext(); directMessages.add((new StringBuilder()).append(directmessage.getSenderScreenName()).append(" ").append(directmessage.getText()).toString()))
                            {
                                directmessage = (DirectMessage)iterator.next();
                            }

                            DirectMessagesReceived(directMessages);
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    });
                    return;
                    Object obj;
                    obj;
                    form.dispatchErrorOccurredEvent(Twitter.this, "RequestDirectMessages", 309, new Object[] {
                        ((TwitterException) (obj)).getMessage()
                    });
                    handler.post(new _cls1());
                    return;
                    obj;
                    handler.post(new _cls1());
                    throw obj;
                }

            
            {
                this$0 = Twitter.this;
                super();
                messages = Collections.emptyList();
            }
            });
            return;
        }
    }

    public void RequestFollowers()
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "RequestFollowers", 308, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                List friends;
                final Twitter this$0;

                public void run()
                {
                    long al[];
                    int j;
                    al = twitter.getFollowersIDs(-1L).getIDs();
                    j = al.length;
                    int i = 0;
_L2:
                    long l;
                    if (i >= j)
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    l = al[i];
                    friends.add(twitter.showUser(l));
                    i++;
                    if (true) goto _L2; else goto _L1
_L1:
                    handler.post(new Runnable() {

                        final _cls7 this$1;

                        public void run()
                        {
                            followers.clear();
                            User user;
                            for (Iterator iterator = friends.iterator(); iterator.hasNext(); followers.add(user.getName()))
                            {
                                user = (User)iterator.next();
                            }

                            FollowersReceived(followers);
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    return;
                    Object obj;
                    obj;
                    form.dispatchErrorOccurredEvent(Twitter.this, "RequestFollowers", 308, new Object[] {
                        ((TwitterException) (obj)).getMessage()
                    });
                    handler.post(new _cls1());
                    return;
                    obj;
                    handler.post(new _cls1());
                    throw obj;
                }

            
            {
                this$0 = Twitter.this;
                super();
                friends = new ArrayList();
            }
            });
            return;
        }
    }

    public void RequestFriendTimeline()
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "RequestFriendTimeline", 313, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                List messages;
                final Twitter this$0;

                public void run()
                {
                    messages = twitter.getHomeTimeline();
                    handler.post(new Runnable() {

                        final _cls12 this$1;

                        public void run()
                        {
                            timeline.clear();
                            ArrayList arraylist;
                            for (Iterator iterator = messages.iterator(); iterator.hasNext(); timeline.add(arraylist))
                            {
                                Status status = (Status)iterator.next();
                                arraylist = new ArrayList();
                                arraylist.add(status.getUser().getScreenName());
                                arraylist.add(status.getText());
                            }

                            FriendTimelineReceived(timeline);
                        }

            
            {
                this$1 = _cls12.this;
                super();
            }
                    });
                    return;
                    Object obj;
                    obj;
                    form.dispatchErrorOccurredEvent(Twitter.this, "RequestFriendTimeline", 313, new Object[] {
                        ((TwitterException) (obj)).getMessage()
                    });
                    handler.post(new _cls1());
                    return;
                    obj;
                    handler.post(new _cls1());
                    throw obj;
                }

            
            {
                this$0 = Twitter.this;
                super();
                messages = Collections.emptyList();
            }
            });
            return;
        }
    }

    public void RequestMentions()
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "RequestMentions", 307, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                List replies;
                final Twitter this$0;

                public void run()
                {
                    replies = twitter.getMentionsTimeline();
                    handler.post(new Runnable() {

                        final _cls6 this$1;

                        public void run()
                        {
                            mentions.clear();
                            Status status;
                            for (Iterator iterator = replies.iterator(); iterator.hasNext(); mentions.add((new StringBuilder()).append(status.getUser().getScreenName()).append(" ").append(status.getText()).toString()))
                            {
                                status = (Status)iterator.next();
                            }

                            MentionsReceived(mentions);
                        }

            
            {
                this$1 = _cls6.this;
                super();
            }
                    });
                    return;
                    Object obj;
                    obj;
                    form.dispatchErrorOccurredEvent(Twitter.this, "RequestMentions", 307, new Object[] {
                        ((TwitterException) (obj)).getMessage()
                    });
                    handler.post(new _cls1());
                    return;
                    obj;
                    handler.post(new _cls1());
                    throw obj;
                }

            
            {
                this$0 = Twitter.this;
                super();
                replies = Collections.emptyList();
            }
            });
            return;
        }
    }

    public List SearchResults()
    {
        return searchResults;
    }

    public void SearchSuccessful(List list)
    {
        EventDispatcher.dispatchEvent(this, "SearchSuccessful", new Object[] {
            list
        });
    }

    public void SearchTwitter(final String query)
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "SearchTwitter", 314, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Twitter this$0;
                List tweets;
                final String val$query;

                public void run()
                {
                    tweets = twitter.search(new Query(query)).getTweets();
                    handler.post(new Runnable() {

                        final _cls13 this$1;

                        public void run()
                        {
                            searchResults.clear();
                            Status status;
                            for (Iterator iterator = tweets.iterator(); iterator.hasNext(); searchResults.add((new StringBuilder()).append(status.getUser().getName()).append(" ").append(status.getText()).toString()))
                            {
                                status = (Status)iterator.next();
                            }

                            SearchSuccessful(searchResults);
                        }

            
            {
                this$1 = _cls13.this;
                super();
            }
                    });
                    return;
                    Object obj;
                    obj;
                    form.dispatchErrorOccurredEvent(Twitter.this, "SearchTwitter", 314, new Object[] {
                        ((TwitterException) (obj)).getMessage()
                    });
                    handler.post(new _cls1());
                    return;
                    obj;
                    handler.post(new _cls1());
                    throw obj;
                }

            
            {
                this$0 = Twitter.this;
                query = s;
                super();
                tweets = Collections.emptyList();
            }
            });
            return;
        }
    }

    public void StopFollowing(final String user)
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "StopFollowing", 312, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Twitter this$0;
                final String val$user;

                public void run()
                {
                    try
                    {
                        twitter.destroyFriendship(user);
                        return;
                    }
                    catch (TwitterException twitterexception)
                    {
                        form.dispatchErrorOccurredEvent(Twitter.this, "StopFollowing", 312, new Object[] {
                            twitterexception.getMessage()
                        });
                    }
                }

            
            {
                this$0 = Twitter.this;
                user = s;
                super();
            }
            });
            return;
        }
    }

    public void Tweet(final String status)
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "Tweet", 306, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Twitter this$0;
                final String val$status;

                public void run()
                {
                    try
                    {
                        twitter.updateStatus(status);
                        return;
                    }
                    catch (TwitterException twitterexception)
                    {
                        form.dispatchErrorOccurredEvent(Twitter.this, "Tweet", 306, new Object[] {
                            twitterexception.getMessage()
                        });
                    }
                }

            
            {
                this$0 = Twitter.this;
                status = s;
                super();
            }
            });
            return;
        }
    }

    public void TweetWithImage(final String status, final String imagePath)
    {
        if (twitter == null || userName.length() == 0)
        {
            form.dispatchErrorOccurredEvent(this, "TweetWithImage", 306, new Object[] {
                "Need to login?"
            });
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Twitter this$0;
                final String val$imagePath;
                final String val$status;

                public void run()
                {
                    String s = imagePath;
                    Object obj = s;
                    if (s.startsWith("file://"))
                    {
                        obj = imagePath.replace("file://", "");
                    }
                    obj = new File(((String) (obj)));
                    if (((File) (obj)).exists())
                    {
                        StatusUpdate statusupdate = new StatusUpdate(status);
                        statusupdate.setMedia(((File) (obj)));
                        twitter.updateStatus(statusupdate);
                        return;
                    }
                    try
                    {
                        form.dispatchErrorOccurredEvent(Twitter.this, "TweetWithImage", 315, new Object[0]);
                        return;
                    }
                    catch (TwitterException twitterexception)
                    {
                        form.dispatchErrorOccurredEvent(Twitter.this, "TweetWithImage", 306, new Object[] {
                            twitterexception.getMessage()
                        });
                    }
                    return;
                }

            
            {
                this$0 = Twitter.this;
                imagePath = s;
                status = s1;
                super();
            }
            });
            return;
        }
    }

    public String TwitPic_API_Key()
    {
        return TwitPic_API_Key;
    }

    public void TwitPic_API_Key(String s)
    {
        TwitPic_API_Key = s;
    }

    public String Username()
    {
        return userName;
    }

    public void resultReturned(int i, int j, final Intent oauthVerifier)
    {
        Log.i("Twitter", (new StringBuilder()).append("Got result ").append(j).toString());
        if (oauthVerifier != null)
        {
            oauthVerifier = oauthVerifier.getData();
            if (oauthVerifier != null)
            {
                Log.i("Twitter", (new StringBuilder()).append("Intent URI: ").append(oauthVerifier.toString()).toString());
                oauthVerifier = oauthVerifier.getQueryParameter("oauth_verifier");
                if (twitter == null)
                {
                    Log.e("Twitter", "twitter field is unexpectedly null");
                    form.dispatchErrorOccurredEvent(this, "Authorize", 304, new Object[] {
                        "internal error: can't access Twitter library"
                    });
                    (new RuntimeException()).printStackTrace();
                }
                if (requestToken != null && oauthVerifier != null && oauthVerifier.length() != 0)
                {
                    AsynchUtil.runAsynchronously(new Runnable() {

                        final Twitter this$0;
                        final String val$oauthVerifier;

                        public void run()
                        {
                            try
                            {
                                AccessToken accesstoken = twitter.getOAuthAccessToken(requestToken, oauthVerifier);
                                accessToken = accesstoken;
                                userName = accessToken.getScreenName();
                                saveAccessToken(accesstoken);
                                handler.post(new Runnable() {

                                    final _cls3 this$1;

                                    public void run()
                                    {
                                        IsAuthorized();
                                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                                });
                                return;
                            }
                            catch (TwitterException twitterexception)
                            {
                                Log.e("Twitter", (new StringBuilder()).append("Got exception: ").append(twitterexception.getMessage()).toString());
                                twitterexception.printStackTrace();
                                form.dispatchErrorOccurredEvent(Twitter.this, "Authorize", 304, new Object[] {
                                    twitterexception.getMessage()
                                });
                                deAuthorize();
                                return;
                            }
                        }

            
            {
                this$0 = Twitter.this;
                oauthVerifier = s;
                super();
            }
                    });
                    return;
                } else
                {
                    form.dispatchErrorOccurredEvent(this, "Authorize", 305, new Object[0]);
                    deAuthorize();
                    return;
                }
            } else
            {
                Log.e("Twitter", "uri returned from WebView activity was unexpectedly null");
                deAuthorize();
                return;
            }
        } else
        {
            Log.e("Twitter", "intent returned from WebView activity was unexpectedly null");
            deAuthorize();
            return;
        }
    }













/*
    static RequestToken access$302(Twitter twitter1, RequestToken requesttoken)
    {
        twitter1.requestToken = requesttoken;
        return requesttoken;
    }

*/






/*
    static AccessToken access$702(Twitter twitter1, AccessToken accesstoken)
    {
        twitter1.accessToken = accesstoken;
        return accesstoken;
    }

*/


/*
    static String access$802(Twitter twitter1, String s)
    {
        twitter1.userName = s;
        return s;
    }

*/

}
