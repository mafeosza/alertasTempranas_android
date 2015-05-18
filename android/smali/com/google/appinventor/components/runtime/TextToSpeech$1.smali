.class Lcom/google/appinventor/components/runtime/TextToSpeech$1;
.super Ljava/lang/Object;
.source "TextToSpeech.java"

# interfaces
.implements Lcom/google/appinventor/components/runtime/util/ITextToSpeech$TextToSpeechCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/TextToSpeech;-><init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/TextToSpeech;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/TextToSpeech;)V
    .locals 0

    .prologue
    .line 130
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/TextToSpeech$1;->this$0:Lcom/google/appinventor/components/runtime/TextToSpeech;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFailure()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 139
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TextToSpeech$1;->this$0:Lcom/google/appinventor/components/runtime/TextToSpeech;

    # setter for: Lcom/google/appinventor/components/runtime/TextToSpeech;->result:Z
    invoke-static {v0, v1}, Lcom/google/appinventor/components/runtime/TextToSpeech;->access$002(Lcom/google/appinventor/components/runtime/TextToSpeech;Z)Z

    .line 140
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TextToSpeech$1;->this$0:Lcom/google/appinventor/components/runtime/TextToSpeech;

    invoke-virtual {v0, v1}, Lcom/google/appinventor/components/runtime/TextToSpeech;->AfterSpeaking(Z)V

    .line 141
    return-void
.end method

.method public onSuccess()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 133
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TextToSpeech$1;->this$0:Lcom/google/appinventor/components/runtime/TextToSpeech;

    # setter for: Lcom/google/appinventor/components/runtime/TextToSpeech;->result:Z
    invoke-static {v0, v1}, Lcom/google/appinventor/components/runtime/TextToSpeech;->access$002(Lcom/google/appinventor/components/runtime/TextToSpeech;Z)Z

    .line 134
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TextToSpeech$1;->this$0:Lcom/google/appinventor/components/runtime/TextToSpeech;

    invoke-virtual {v0, v1}, Lcom/google/appinventor/components/runtime/TextToSpeech;->AfterSpeaking(Z)V

    .line 135
    return-void
.end method
