.class Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;
.super Ljava/lang/Object;
.source "InternalTextToSpeech.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech;->speak(Ljava/lang/String;Ljava/util/Locale;I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech;

.field final synthetic val$loc:Ljava/util/Locale;

.field final synthetic val$message:Ljava/lang/String;

.field final synthetic val$retries:I


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech;ILjava/lang/String;Ljava/util/Locale;)V
    .locals 0

    .prologue
    .line 120
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->this$0:Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech;

    iput p2, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->val$retries:I

    iput-object p3, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->val$message:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->val$loc:Ljava/util/Locale;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 122
    const-string v0, "InternalTTS"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "delaying call to speak.  Retries is: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->val$retries:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Message is: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->val$message:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 124
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->this$0:Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->val$message:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->val$loc:Ljava/util/Locale;

    iget v3, p0, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech$3;->val$retries:I

    add-int/lit8 v3, v3, 0x1

    # invokes: Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech;->speak(Ljava/lang/String;Ljava/util/Locale;I)V
    invoke-static {v0, v1, v2, v3}, Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech;->access$300(Lcom/google/appinventor/components/runtime/util/InternalTextToSpeech;Ljava/lang/String;Ljava/util/Locale;I)V

    .line 125
    return-void
.end method
