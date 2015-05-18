.class Lcom/google/appinventor/components/runtime/Sound$OnLoadHelper$1;
.super Ljava/lang/Object;
.source "Sound.java"

# interfaces
.implements Landroid/media/SoundPool$OnLoadCompleteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/Sound$OnLoadHelper;->setOnloadCompleteListener(Landroid/media/SoundPool;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/google/appinventor/components/runtime/Sound$OnLoadHelper;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/Sound$OnLoadHelper;)V
    .locals 0

    .prologue
    .line 73
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/Sound$OnLoadHelper$1;->this$1:Lcom/google/appinventor/components/runtime/Sound$OnLoadHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoadComplete(Landroid/media/SoundPool;II)V
    .locals 2
    .param p1, "soundPool"    # Landroid/media/SoundPool;
    .param p2, "sampleId"    # I
    .param p3, "status"    # I

    .prologue
    .line 75
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Sound$OnLoadHelper$1;->this$1:Lcom/google/appinventor/components/runtime/Sound$OnLoadHelper;

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/Sound$OnLoadHelper;->this$0:Lcom/google/appinventor/components/runtime/Sound;

    const/4 v1, 0x1

    # setter for: Lcom/google/appinventor/components/runtime/Sound;->loadComplete:Z
    invoke-static {v0, v1}, Lcom/google/appinventor/components/runtime/Sound;->access$002(Lcom/google/appinventor/components/runtime/Sound;Z)Z

    .line 76
    return-void
.end method
