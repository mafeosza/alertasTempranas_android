.class Lcom/google/appinventor/components/runtime/WebViewActivity$1;
.super Landroid/webkit/WebViewClient;
.source "WebViewActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/WebViewActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/WebViewActivity;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/WebViewActivity;)V
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/WebViewActivity$1;->this$0:Lcom/google/appinventor/components/runtime/WebViewActivity;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method


# virtual methods
.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 6
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 44
    const-string v3, "WebView"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Handling url "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 45
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 46
    .local v2, "uri":Landroid/net/Uri;
    invoke-virtual {v2}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 47
    .local v1, "scheme":Ljava/lang/String;
    const-string v3, "appinventor"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 48
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 49
    .local v0, "resultIntent":Landroid/content/Intent;
    invoke-virtual {v0, v2}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 50
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/WebViewActivity$1;->this$0:Lcom/google/appinventor/components/runtime/WebViewActivity;

    const/4 v4, -0x1

    invoke-virtual {v3, v4, v0}, Lcom/google/appinventor/components/runtime/WebViewActivity;->setResult(ILandroid/content/Intent;)V

    .line 51
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/WebViewActivity$1;->this$0:Lcom/google/appinventor/components/runtime/WebViewActivity;

    invoke-virtual {v3}, Lcom/google/appinventor/components/runtime/WebViewActivity;->finish()V

    .line 55
    .end local v0    # "resultIntent":Landroid/content/Intent;
    :goto_0
    const/4 v3, 0x1

    return v3

    .line 53
    :cond_0
    invoke-virtual {p1, p2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method
