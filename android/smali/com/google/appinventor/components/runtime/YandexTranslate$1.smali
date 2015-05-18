.class Lcom/google/appinventor/components/runtime/YandexTranslate$1;
.super Ljava/lang/Object;
.source "YandexTranslate.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/YandexTranslate;->RequestTranslation(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

.field final synthetic val$languageToTranslateTo:Ljava/lang/String;

.field final synthetic val$textToTranslate:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/YandexTranslate;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

    iput-object p2, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->val$languageToTranslateTo:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->val$textToTranslate:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 111
    :try_start_0
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->val$languageToTranslateTo:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->val$textToTranslate:Ljava/lang/String;

    # invokes: Lcom/google/appinventor/components/runtime/YandexTranslate;->performRequest(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v2, v3, v4}, Lcom/google/appinventor/components/runtime/YandexTranslate;->access$000(Lcom/google/appinventor/components/runtime/YandexTranslate;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1

    .line 119
    :goto_0
    return-void

    .line 112
    :catch_0
    move-exception v0

    .line 113
    .local v0, "e":Ljava/io/IOException;
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

    iget-object v2, v2, Lcom/google/appinventor/components/runtime/YandexTranslate;->form:Lcom/google/appinventor/components/runtime/Form;

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

    const-string v4, "RequestTranslation"

    const/16 v5, 0x89a

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/google/appinventor/components/runtime/Form;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    goto :goto_0

    .line 115
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v1

    .line 116
    .local v1, "je":Lorg/json/JSONException;
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

    iget-object v2, v2, Lcom/google/appinventor/components/runtime/YandexTranslate;->form:Lcom/google/appinventor/components/runtime/Form;

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;->this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

    const-string v4, "RequestTranslation"

    const/16 v5, 0x89b

    new-array v6, v6, [Ljava/lang/Object;

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/google/appinventor/components/runtime/Form;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    goto :goto_0
.end method
