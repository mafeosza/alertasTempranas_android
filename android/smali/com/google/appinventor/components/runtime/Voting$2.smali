.class Lcom/google/appinventor/components/runtime/Voting$2;
.super Ljava/lang/Object;
.source "Voting.java"

# interfaces
.implements Lcom/google/appinventor/components/runtime/util/AsyncCallbackPair;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/Voting;->postRequestBallot()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/google/appinventor/components/runtime/util/AsyncCallbackPair",
        "<",
        "Lorg/json/JSONObject;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/Voting;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/Voting;)V
    .locals 0

    .prologue
    .line 268
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/String;)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 323
    const-string v0, "Voting"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "postRequestBallot Failure "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 324
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    # getter for: Lcom/google/appinventor/components/runtime/Voting;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/Voting;->access$100(Lcom/google/appinventor/components/runtime/Voting;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/google/appinventor/components/runtime/Voting$2$5;

    invoke-direct {v1, p0, p1}, Lcom/google/appinventor/components/runtime/Voting$2$5;-><init>(Lcom/google/appinventor/components/runtime/Voting$2;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 329
    return-void
.end method

.method public bridge synthetic onSuccess(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 268
    check-cast p1, Lorg/json/JSONObject;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/appinventor/components/runtime/Voting$2;->onSuccess(Lorg/json/JSONObject;)V

    return-void
.end method

.method public onSuccess(Lorg/json/JSONObject;)V
    .locals 5
    .param p1, "result"    # Lorg/json/JSONObject;

    .prologue
    .line 270
    if-nez p1, :cond_0

    .line 273
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    # getter for: Lcom/google/appinventor/components/runtime/Voting;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/google/appinventor/components/runtime/Voting;->access$100(Lcom/google/appinventor/components/runtime/Voting;)Landroid/os/Handler;

    move-result-object v1

    new-instance v2, Lcom/google/appinventor/components/runtime/Voting$2$1;

    invoke-direct {v2, p0}, Lcom/google/appinventor/components/runtime/Voting$2$1;-><init>(Lcom/google/appinventor/components/runtime/Voting$2;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 321
    :goto_0
    return-void

    .line 281
    :cond_0
    :try_start_0
    const-string v1, "Voting"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "postRequestBallot: ballot retrieved "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 286
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    const-string v2, "isPolling"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    # setter for: Lcom/google/appinventor/components/runtime/Voting;->isPolling:Ljava/lang/Boolean;
    invoke-static {v1, v2}, Lcom/google/appinventor/components/runtime/Voting;->access$202(Lcom/google/appinventor/components/runtime/Voting;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 287
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    # getter for: Lcom/google/appinventor/components/runtime/Voting;->isPolling:Ljava/lang/Boolean;
    invoke-static {v1}, Lcom/google/appinventor/components/runtime/Voting;->access$200(Lcom/google/appinventor/components/runtime/Voting;)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 289
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    const-string v2, "idRequested"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    # setter for: Lcom/google/appinventor/components/runtime/Voting;->idRequested:Ljava/lang/Boolean;
    invoke-static {v1, v2}, Lcom/google/appinventor/components/runtime/Voting;->access$302(Lcom/google/appinventor/components/runtime/Voting;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 290
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    const-string v2, "question"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    # setter for: Lcom/google/appinventor/components/runtime/Voting;->ballotQuestion:Ljava/lang/String;
    invoke-static {v1, v2}, Lcom/google/appinventor/components/runtime/Voting;->access$402(Lcom/google/appinventor/components/runtime/Voting;Ljava/lang/String;)Ljava/lang/String;

    .line 291
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    const-string v2, "options"

    invoke-virtual {p1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    # setter for: Lcom/google/appinventor/components/runtime/Voting;->ballotOptionsString:Ljava/lang/String;
    invoke-static {v1, v2}, Lcom/google/appinventor/components/runtime/Voting;->access$502(Lcom/google/appinventor/components/runtime/Voting;Ljava/lang/String;)Ljava/lang/String;

    .line 292
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    new-instance v3, Lorg/json/JSONArray;

    iget-object v4, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    # getter for: Lcom/google/appinventor/components/runtime/Voting;->ballotOptionsString:Ljava/lang/String;
    invoke-static {v4}, Lcom/google/appinventor/components/runtime/Voting;->access$500(Lcom/google/appinventor/components/runtime/Voting;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    # invokes: Lcom/google/appinventor/components/runtime/Voting;->JSONArrayToArrayList(Lorg/json/JSONArray;)Ljava/util/ArrayList;
    invoke-static {v2, v3}, Lcom/google/appinventor/components/runtime/Voting;->access$700(Lcom/google/appinventor/components/runtime/Voting;Lorg/json/JSONArray;)Ljava/util/ArrayList;

    move-result-object v2

    # setter for: Lcom/google/appinventor/components/runtime/Voting;->ballotOptions:Ljava/util/ArrayList;
    invoke-static {v1, v2}, Lcom/google/appinventor/components/runtime/Voting;->access$602(Lcom/google/appinventor/components/runtime/Voting;Ljava/util/ArrayList;)Ljava/util/ArrayList;

    .line 293
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    # getter for: Lcom/google/appinventor/components/runtime/Voting;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/google/appinventor/components/runtime/Voting;->access$100(Lcom/google/appinventor/components/runtime/Voting;)Landroid/os/Handler;

    move-result-object v1

    new-instance v2, Lcom/google/appinventor/components/runtime/Voting$2$2;

    invoke-direct {v2, p0}, Lcom/google/appinventor/components/runtime/Voting$2$2;-><init>(Lcom/google/appinventor/components/runtime/Voting$2;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 305
    :catch_0
    move-exception v0

    .line 313
    .local v0, "e":Lorg/json/JSONException;
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    # getter for: Lcom/google/appinventor/components/runtime/Voting;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/google/appinventor/components/runtime/Voting;->access$100(Lcom/google/appinventor/components/runtime/Voting;)Landroid/os/Handler;

    move-result-object v1

    new-instance v2, Lcom/google/appinventor/components/runtime/Voting$2$4;

    invoke-direct {v2, p0}, Lcom/google/appinventor/components/runtime/Voting$2$4;-><init>(Lcom/google/appinventor/components/runtime/Voting$2;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto/16 :goto_0

    .line 299
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Voting$2;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    # getter for: Lcom/google/appinventor/components/runtime/Voting;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v1}, Lcom/google/appinventor/components/runtime/Voting;->access$100(Lcom/google/appinventor/components/runtime/Voting;)Landroid/os/Handler;

    move-result-object v1

    new-instance v2, Lcom/google/appinventor/components/runtime/Voting$2$3;

    invoke-direct {v2, p0}, Lcom/google/appinventor/components/runtime/Voting$2$3;-><init>(Lcom/google/appinventor/components/runtime/Voting$2;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method
