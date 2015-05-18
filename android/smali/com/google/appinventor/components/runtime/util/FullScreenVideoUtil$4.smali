.class Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil$4;
.super Ljava/lang/Object;
.source "FullScreenVideoUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil;->onPrepared(Landroid/media/MediaPlayer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil;)V
    .locals 0

    .prologue
    .line 444
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil$4;->this$0:Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 448
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil$4;->this$0:Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil;

    # getter for: Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil;->mFullScreenVideoView:Landroid/widget/VideoView;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil;->access$000(Lcom/google/appinventor/components/runtime/util/FullScreenVideoUtil;)Landroid/widget/VideoView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/VideoView;->pause()V

    .line 449
    return-void
.end method
