.class Lcom/google/appinventor/components/runtime/GameClient$20;
.super Ljava/lang/Object;
.source "GameClient.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/GameClient;->LeaveInstance()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/GameClient;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/GameClient;)V
    .locals 0

    .prologue
    .line 832
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/GameClient$20;->this$0:Lcom/google/appinventor/components/runtime/GameClient;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 834
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/GameClient$20;->this$0:Lcom/google/appinventor/components/runtime/GameClient;

    # invokes: Lcom/google/appinventor/components/runtime/GameClient;->postLeaveInstance()V
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/GameClient;->access$500(Lcom/google/appinventor/components/runtime/GameClient;)V

    .line 835
    return-void
.end method
