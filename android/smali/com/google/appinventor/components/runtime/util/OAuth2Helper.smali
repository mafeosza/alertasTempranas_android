.class public Lcom/google/appinventor/components/runtime/util/OAuth2Helper;
.super Ljava/lang/Object;
.source "OAuth2Helper.java"


# static fields
.field public static final PREF_ACCOUNT_NAME:Ljava/lang/String; = "accountName"

.field public static final PREF_AUTH_TOKEN:Ljava/lang/String; = "authToken"

.field public static final TAG:Ljava/lang/String; = "OAuthHelper"

.field private static errorMessage:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 77
    const-string v0, "Error during OAuth"

    sput-object v0, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->errorMessage:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getAccountManagerResult(Landroid/app/Activity;Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;Ljava/lang/String;Ljava/lang/String;)Landroid/accounts/AccountManagerFuture;
    .locals 14
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "credential"    # Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
    .param p3, "authTokenType"    # Ljava/lang/String;
    .param p4, "accountName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 150
    const/4 v13, 0x0

    .line 151
    .local v13, "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Landroid/os/Bundle;>;"
    new-instance v12, Lcom/google/api/client/googleapis/extensions/android2/auth/GoogleAccountManager;

    invoke-direct {v12, p1}, Lcom/google/api/client/googleapis/extensions/android2/auth/GoogleAccountManager;-><init>(Landroid/content/Context;)V

    .line 158
    .local v12, "accountManager":Lcom/google/api/client/googleapis/extensions/android2/auth/GoogleAccountManager;
    invoke-virtual/range {p2 .. p2}, Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;->getAccessToken()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v12, v1}, Lcom/google/api/client/googleapis/extensions/android2/auth/GoogleAccountManager;->invalidateAuthToken(Ljava/lang/String;)V

    .line 159
    invoke-static {p1}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v1

    const/4 v3, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v1, v0, v3}, Landroid/accounts/AccountManager;->invalidateAuthToken(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    move-object/from16 v0, p4

    invoke-virtual {v12, v0}, Lcom/google/api/client/googleapis/extensions/android2/auth/GoogleAccountManager;->getAccountByName(Ljava/lang/String;)Landroid/accounts/Account;

    move-result-object v2

    .line 166
    .local v2, "account":Landroid/accounts/Account;
    if-eqz v2, :cond_0

    .line 169
    const-string v1, "OAuthHelper"

    const-string v3, "Getting token by account"

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 170
    invoke-virtual {v12}, Lcom/google/api/client/googleapis/extensions/android2/auth/GoogleAccountManager;->getAccountManager()Landroid/accounts/AccountManager;

    move-result-object v1

    const/4 v4, 0x1

    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v3, p3

    invoke-virtual/range {v1 .. v6}, Landroid/accounts/AccountManager;->getAuthToken(Landroid/accounts/Account;Ljava/lang/String;ZLandroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v13

    .line 181
    :goto_0
    return-object v13

    .line 175
    :cond_0
    const-string v1, "OAuthHelper"

    const-string v3, "Getting token by features, possibly prompting user to select an account"

    invoke-static {v1, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 176
    invoke-virtual {v12}, Lcom/google/api/client/googleapis/extensions/android2/auth/GoogleAccountManager;->getAccountManager()Landroid/accounts/AccountManager;

    move-result-object v3

    const-string v4, "com.google"

    const/4 v6, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object/from16 v5, p3

    move-object v7, p1

    invoke-virtual/range {v3 .. v11}, Landroid/accounts/AccountManager;->getAuthTokenByFeatures(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/app/Activity;Landroid/os/Bundle;Landroid/os/Bundle;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    move-result-object v13

    goto :goto_0
.end method

.method public static getErrorMessage()Ljava/lang/String;
    .locals 3

    .prologue
    .line 225
    const-string v0, "OAuthHelper"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getErrorMessage = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->errorMessage:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 226
    sget-object v0, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->errorMessage:Ljava/lang/String;

    return-object v0
.end method

.method private isUiThread()Z
    .locals 2

    .prologue
    .line 188
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private persistCredentials(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "settings"    # Landroid/content/SharedPreferences;
    .param p2, "accountName"    # Ljava/lang/String;
    .param p3, "authToken"    # Ljava/lang/String;

    .prologue
    .line 198
    const-string v1, "OAuthHelper"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Persisting credentials, acct ="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 199
    invoke-interface {p1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 200
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "accountName"

    invoke-interface {v0, v1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 201
    const-string v1, "authToken"

    invoke-interface {v0, v1, p3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 202
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 203
    return-void
.end method

.method public static resetAccountCredential(Landroid/app/Activity;)V
    .locals 4
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 212
    const-string v2, "OAuthHelper"

    const-string v3, "Reset credentials"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 213
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Landroid/app/Activity;->getPreferences(I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 214
    .local v1, "settings":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 215
    .local v0, "editor2":Landroid/content/SharedPreferences$Editor;
    const-string v2, "authToken"

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 216
    const-string v2, "accountName"

    invoke-interface {v0, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 217
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 218
    return-void
.end method


# virtual methods
.method public getRefreshedAuthToken(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "authTokenType"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x0

    .line 89
    const-string v7, "OAuthHelper"

    const-string v8, "getRefreshedAuthToken()"

    invoke-static {v7, v8}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 91
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->isUiThread()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 92
    new-instance v7, Ljava/lang/IllegalArgumentException;

    const-string v8, "Can\'t get authtoken from UI thread"

    invoke-direct {v7, v8}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 95
    :cond_0
    const/4 v7, 0x0

    invoke-virtual {p1, v7}, Landroid/app/Activity;->getPreferences(I)Landroid/content/SharedPreferences;

    move-result-object v6

    .line 96
    .local v6, "settings":Landroid/content/SharedPreferences;
    const-string v7, "accountName"

    invoke-interface {v6, v7, v9}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 99
    .local v0, "accountName":Ljava/lang/String;
    const-string v7, "authToken"

    invoke-interface {v6, v7, v9}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 102
    .local v1, "authToken":Ljava/lang/String;
    new-instance v3, Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;

    invoke-direct {v3}, Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;-><init>()V

    .line 103
    .local v3, "credential":Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;
    invoke-virtual {v3, v1}, Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;->setAccessToken(Ljava/lang/String;)Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;

    .line 107
    invoke-direct {p0, p1, v3, p2, v0}, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->getAccountManagerResult(Landroid/app/Activity;Lcom/google/api/client/googleapis/auth/oauth2/GoogleCredential;Ljava/lang/String;Ljava/lang/String;)Landroid/accounts/AccountManagerFuture;

    move-result-object v5

    .line 113
    .local v5, "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Landroid/os/Bundle;>;"
    :try_start_0
    invoke-interface {v5}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    .line 114
    .local v2, "authTokenBundle":Landroid/os/Bundle;
    const-string v7, "authtoken"

    invoke-virtual {v2, v7}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 116
    const-string v7, "authAccount"

    invoke-virtual {v2, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v6, v7, v1}, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->persistCredentials(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    .line 132
    .end local v2    # "authTokenBundle":Landroid/os/Bundle;
    :goto_0
    return-object v1

    .line 119
    :catch_0
    move-exception v4

    .line 120
    .local v4, "e":Landroid/accounts/OperationCanceledException;
    invoke-virtual {v4}, Landroid/accounts/OperationCanceledException;->printStackTrace()V

    .line 121
    invoke-static {p1}, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->resetAccountCredential(Landroid/app/Activity;)V

    .line 122
    const-string v7, "Error: operation cancelled"

    sput-object v7, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->errorMessage:Ljava/lang/String;

    goto :goto_0

    .line 123
    .end local v4    # "e":Landroid/accounts/OperationCanceledException;
    :catch_1
    move-exception v4

    .line 124
    .local v4, "e":Landroid/accounts/AuthenticatorException;
    invoke-virtual {v4}, Landroid/accounts/AuthenticatorException;->printStackTrace()V

    .line 125
    const-string v7, "Error: Authenticator error"

    sput-object v7, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->errorMessage:Ljava/lang/String;

    goto :goto_0

    .line 126
    .end local v4    # "e":Landroid/accounts/AuthenticatorException;
    :catch_2
    move-exception v4

    .line 127
    .local v4, "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 128
    const-string v7, "Error: I/O error"

    sput-object v7, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->errorMessage:Ljava/lang/String;

    goto :goto_0
.end method
