.class Lorg/acra/ErrorReporter$2;
.super Ljava/lang/Thread;
.source "ErrorReporter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lorg/acra/ErrorReporter;->handleException(Ljava/lang/Throwable;Lorg/acra/ReportingInteractionMode;ZZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lorg/acra/ErrorReporter;


# direct methods
.method constructor <init>(Lorg/acra/ErrorReporter;)V
    .locals 0

    .prologue
    .line 608
    iput-object p1, p0, Lorg/acra/ErrorReporter$2;->this$0:Lorg/acra/ErrorReporter;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    .prologue
    const-wide/16 v10, 0xbb8

    const/4 v9, 0x0

    .line 612
    new-instance v0, Landroid/text/format/Time;

    invoke-direct {v0}, Landroid/text/format/Time;-><init>()V

    .line 613
    .local v0, "beforeWait":Landroid/text/format/Time;
    new-instance v3, Landroid/text/format/Time;

    invoke-direct {v3}, Landroid/text/format/Time;-><init>()V

    .line 614
    .local v3, "currentTime":Landroid/text/format/Time;
    invoke-virtual {v0}, Landroid/text/format/Time;->setToNow()V

    .line 615
    invoke-virtual {v0, v9}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v1

    .line 616
    .local v1, "beforeWaitInMillis":J
    const-wide/16 v5, 0x0

    .line 617
    .local v5, "elapsedTimeInMillis":J
    :goto_0
    cmp-long v7, v5, v10

    if-gez v7, :cond_0

    .line 620
    const-wide/16 v7, 0xbb8

    :try_start_0
    invoke-static {v7, v8}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 624
    :goto_1
    invoke-virtual {v3}, Landroid/text/format/Time;->setToNow()V

    .line 625
    invoke-virtual {v3, v9}, Landroid/text/format/Time;->toMillis(Z)J

    move-result-wide v7

    sub-long v5, v7, v1

    goto :goto_0

    .line 621
    :catch_0
    move-exception v4

    .line 622
    .local v4, "e1":Ljava/lang/InterruptedException;
    sget-object v7, Lorg/acra/ACRA;->LOG_TAG:Ljava/lang/String;

    const-string v8, "Interrupted while waiting for Toast to end."

    invoke-static {v7, v8, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 627
    .end local v4    # "e1":Ljava/lang/InterruptedException;
    :cond_0
    const/4 v7, 0x1

    # setter for: Lorg/acra/ErrorReporter;->toastWaitEnded:Z
    invoke-static {v7}, Lorg/acra/ErrorReporter;->access$102(Z)Z

    .line 628
    return-void
.end method
