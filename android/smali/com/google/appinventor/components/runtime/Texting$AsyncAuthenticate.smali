.class Lcom/google/appinventor/components/runtime/Texting$AsyncAuthenticate;
.super Landroid/os/AsyncTask;
.source "Texting.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/appinventor/components/runtime/Texting;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "AsyncAuthenticate"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/Texting;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/Texting;)V
    .locals 0

    .prologue
    .line 922
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/Texting$AsyncAuthenticate;->this$0:Lcom/google/appinventor/components/runtime/Texting;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 922
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/appinventor/components/runtime/Texting$AsyncAuthenticate;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 3
    .param p1, "arg0"    # [Ljava/lang/Void;

    .prologue
    .line 926
    const-string v0, "Texting Component"

    const-string v1, "Authenticating"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 929
    new-instance v0, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;

    invoke-direct {v0}, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;-><init>()V

    # getter for: Lcom/google/appinventor/components/runtime/Texting;->activity:Landroid/app/Activity;
    invoke-static {}, Lcom/google/appinventor/components/runtime/Texting;->access$200()Landroid/app/Activity;

    move-result-object v1

    const-string v2, "grandcentral"

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/OAuth2Helper;->getRefreshedAuthToken(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 922
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/appinventor/components/runtime/Texting$AsyncAuthenticate;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    .line 937
    const-string v0, "Texting Component"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "authToken = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 938
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Texting$AsyncAuthenticate;->this$0:Lcom/google/appinventor/components/runtime/Texting;

    # setter for: Lcom/google/appinventor/components/runtime/Texting;->authToken:Ljava/lang/String;
    invoke-static {v0, p1}, Lcom/google/appinventor/components/runtime/Texting;->access$302(Lcom/google/appinventor/components/runtime/Texting;Ljava/lang/String;)Ljava/lang/String;

    .line 940
    # getter for: Lcom/google/appinventor/components/runtime/Texting;->activity:Landroid/app/Activity;
    invoke-static {}, Lcom/google/appinventor/components/runtime/Texting;->access$200()Landroid/app/Activity;

    move-result-object v0

    const-string v1, "Finished authentication"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 943
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Texting$AsyncAuthenticate;->this$0:Lcom/google/appinventor/components/runtime/Texting;

    # invokes: Lcom/google/appinventor/components/runtime/Texting;->processPendingQueue()V
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/Texting;->access$400(Lcom/google/appinventor/components/runtime/Texting;)V

    .line 944
    return-void
.end method
