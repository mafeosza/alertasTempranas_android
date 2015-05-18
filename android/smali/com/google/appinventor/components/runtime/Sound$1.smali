.class Lcom/google/appinventor/components/runtime/Sound$1;
.super Ljava/lang/Object;
.source "Sound.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/Sound;->playWhenLoadComplete()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/Sound;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/Sound;)V
    .locals 0

    .prologue
    .line 266
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/Sound$1;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 269
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Sound$1;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    # getter for: Lcom/google/appinventor/components/runtime/Sound;->loadComplete:Z
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/Sound;->access$000(Lcom/google/appinventor/components/runtime/Sound;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 270
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Sound$1;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    # invokes: Lcom/google/appinventor/components/runtime/Sound;->playAndCheckResult()V
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/Sound;->access$200(Lcom/google/appinventor/components/runtime/Sound;)V

    .line 278
    :goto_0
    return-void

    .line 271
    :cond_0
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Sound$1;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    # getter for: Lcom/google/appinventor/components/runtime/Sound;->delayRetries:I
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/Sound;->access$300(Lcom/google/appinventor/components/runtime/Sound;)I

    move-result v0

    if-lez v0, :cond_1

    .line 272
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Sound$1;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    # operator-- for: Lcom/google/appinventor/components/runtime/Sound;->delayRetries:I
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/Sound;->access$310(Lcom/google/appinventor/components/runtime/Sound;)I

    .line 273
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Sound$1;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    # invokes: Lcom/google/appinventor/components/runtime/Sound;->playWhenLoadComplete()V
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/Sound;->access$400(Lcom/google/appinventor/components/runtime/Sound;)V

    goto :goto_0

    .line 275
    :cond_1
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Sound$1;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/Sound;->form:Lcom/google/appinventor/components/runtime/Form;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/Sound$1;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    # getter for: Lcom/google/appinventor/components/runtime/Sound;->thisComponent:Lcom/google/appinventor/components/runtime/Component;
    invoke-static {v1}, Lcom/google/appinventor/components/runtime/Sound;->access$500(Lcom/google/appinventor/components/runtime/Sound;)Lcom/google/appinventor/components/runtime/Component;

    move-result-object v1

    const-string v2, "Play"

    const/16 v3, 0x2c6

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/google/appinventor/components/runtime/Sound$1;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    # getter for: Lcom/google/appinventor/components/runtime/Sound;->sourcePath:Ljava/lang/String;
    invoke-static {v6}, Lcom/google/appinventor/components/runtime/Sound;->access$600(Lcom/google/appinventor/components/runtime/Sound;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/Form;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    goto :goto_0
.end method
