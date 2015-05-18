.class Lcom/google/appinventor/components/runtime/Voting$4$1;
.super Ljava/lang/Object;
.source "Voting.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/Voting$4;->onSuccess(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/google/appinventor/components/runtime/Voting$4;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/Voting$4;)V
    .locals 0

    .prologue
    .line 392
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/Voting$4$1;->this$1:Lcom/google/appinventor/components/runtime/Voting$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 394
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Voting$4$1;->this$1:Lcom/google/appinventor/components/runtime/Voting$4;

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/Voting$4;->this$0:Lcom/google/appinventor/components/runtime/Voting;

    invoke-virtual {v0}, Lcom/google/appinventor/components/runtime/Voting;->GotBallotConfirmation()V

    .line 395
    return-void
.end method
