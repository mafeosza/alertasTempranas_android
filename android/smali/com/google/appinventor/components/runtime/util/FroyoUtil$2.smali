.class final Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;
.super Landroid/webkit/WebViewClient;
.source "FroyoUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/util/FroyoUtil;->getWebViewClient(ZZLcom/google/appinventor/components/runtime/Form;Lcom/google/appinventor/components/runtime/Component;)Landroid/webkit/WebViewClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$component:Lcom/google/appinventor/components/runtime/Component;

.field final synthetic val$followLinks:Z

.field final synthetic val$form:Lcom/google/appinventor/components/runtime/Form;

.field final synthetic val$ignoreErrors:Z


# direct methods
.method constructor <init>(ZZLcom/google/appinventor/components/runtime/Form;Lcom/google/appinventor/components/runtime/Component;)V
    .locals 0

    .prologue
    .line 128
    iput-boolean p1, p0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;->val$followLinks:Z

    iput-boolean p2, p0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;->val$ignoreErrors:Z

    iput-object p3, p0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;->val$form:Lcom/google/appinventor/components/runtime/Form;

    iput-object p4, p0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;->val$component:Lcom/google/appinventor/components/runtime/Component;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 5
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "handler"    # Landroid/webkit/SslErrorHandler;
    .param p3, "error"    # Landroid/net/http/SslError;

    .prologue
    .line 136
    iget-boolean v0, p0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;->val$ignoreErrors:Z

    if-eqz v0, :cond_0

    .line 137
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->proceed()V

    .line 143
    :goto_0
    return-void

    .line 139
    :cond_0
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->cancel()V

    .line 140
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;->val$form:Lcom/google/appinventor/components/runtime/Form;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;->val$component:Lcom/google/appinventor/components/runtime/Component;

    const-string v2, "WebView"

    const/16 v3, 0x9c5

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/Form;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 131
    iget-boolean v0, p0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;->val$followLinks:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
