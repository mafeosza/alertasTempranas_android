.class Lcom/google/appinventor/components/runtime/YandexTranslate$2;
.super Ljava/lang/Object;
.source "YandexTranslate.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/YandexTranslate;->performRequest(Ljava/lang/String;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

.field final synthetic val$responseCode:Ljava/lang/String;

.field final synthetic val$translation:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/YandexTranslate;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 154
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$2;->this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

    iput-object p2, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$2;->val$responseCode:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$2;->val$translation:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 157
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$2;->this$0:Lcom/google/appinventor/components/runtime/YandexTranslate;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$2;->val$responseCode:Ljava/lang/String;

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/YandexTranslate$2;->val$translation:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/YandexTranslate;->GotTranslation(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    return-void
.end method
