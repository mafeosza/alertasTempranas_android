.class public final Lcom/google/appinventor/components/runtime/YandexTranslate;
.super Lcom/google/appinventor/components/runtime/AndroidNonvisibleComponent;
.source "YandexTranslate.java"


# annotations
.annotation runtime Lcom/google/appinventor/components/annotations/DesignerComponent;
    category = .enum Lcom/google/appinventor/components/common/ComponentCategory;->MEDIA:Lcom/google/appinventor/components/common/ComponentCategory;
    description = "Use this component to translate words and sentences between different languages. This component needs Internet access, as it will request translations to the Yandex.Translate service. Specify the source and target language in the form source-target using two letter language codes. So\"en-es\" will translate from English to Spanish while \"es-ru\" will translate from Spanish to Russian. If you leave out the source language, the service will attempt to detect the source language. So providing just \"es\" will attempt to detect the source language and translate it to Spanish.<p /> This component is powered by the Yandex translation service.  See http://api.yandex.com/translate/ for more information, including the list of available languages and the meanings of the language codes and status codes. <p />Note: Translation happens asynchronously in the background. When the translation is complete, the \"GotTranslation\" event is triggered."
    iconName = "images/yandex.png"
    nonVisible = true
    version = 0x1
.end annotation

.annotation runtime Lcom/google/appinventor/components/annotations/SimpleObject;
.end annotation

.annotation runtime Lcom/google/appinventor/components/annotations/UsesPermissions;
    permissionNames = "android.permission.INTERNET"
.end annotation


# static fields
.field public static final YANDEX_TRANSLATE_SERVICE_URL:Ljava/lang/String; = "https://translate.yandex.net/api/v1.5/tr.json/translate?key="


# instance fields
.field private final activity:Landroid/app/Activity;

.field private final key1:[B

.field private final key2:[B

.field private final yandexKey:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V
    .locals 2
    .param p1, "container"    # Lcom/google/appinventor/components/runtime/ComponentContainer;

    .prologue
    const/16 v1, 0x54

    .line 77
    invoke-interface {p1}, Lcom/google/appinventor/components/runtime/ComponentContainer;->$form()Lcom/google/appinventor/components/runtime/Form;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/google/appinventor/components/runtime/AndroidNonvisibleComponent;-><init>(Lcom/google/appinventor/components/runtime/Form;)V

    .line 54
    new-array v0, v1, [B

    fill-array-data v0, :array_0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->key1:[B

    .line 62
    new-array v0, v1, [B

    fill-array-data v0, :array_1

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->key2:[B

    .line 80
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->form:Lcom/google/appinventor/components/runtime/Form;

    invoke-virtual {v0}, Lcom/google/appinventor/components/runtime/Form;->setYandexTranslateTagline()V

    .line 84
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/YandexTranslate;->gk()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->yandexKey:Ljava/lang/String;

    .line 85
    invoke-interface {p1}, Lcom/google/appinventor/components/runtime/ComponentContainer;->$context()Landroid/app/Activity;

    move-result-object v0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->activity:Landroid/app/Activity;

    .line 86
    return-void

    .line 54
    nop

    :array_0
    .array-data 1
        -0x7ft
        -0x58t
        0x4ft
        0x50t
        0x41t
        0x70t
        -0x50t
        0x57t
        -0x3et
        0x7et
        -0x7dt
        -0x19t
        -0x1ft
        0x37t
        0x6bt
        -0x2at
        -0x3ft
        -0x3et
        0x21t
        -0x7at
        0x1t
        0x59t
        -0x21t
        0x17t
        -0x13t
        0x12t
        -0x51t
        0x25t
        -0x43t
        0x72t
        0x5ct
        -0x3ct
        -0x4ct
        -0x32t
        -0x3bt
        -0x31t
        -0x72t
        -0x40t
        -0x60t
        -0x4bt
        0x75t
        -0x74t
        0x35t
        -0x8t
        0x2ct
        0x6ft
        0x78t
        0x30t
        0x29t
        0x1et
        0x55t
        -0x74t
        -0x1ft
        0x11t
        0x57t
        -0x59t
        -0x31t
        -0x33t
        0x2ft
        0x5ct
        0x79t
        -0x3at
        -0x50t
        -0x19t
        0x56t
        0x7bt
        -0x24t
        -0x9t
        0x65t
        -0x70t
        -0x16t
        -0x1ct
        -0x1dt
        -0xet
        -0x7dt
        0x2et
        -0x67t
        -0x24t
        0x7dt
        0x72t
        0x23t
        -0x1ft
        0x1t
        0x7bt
    .end array-data

    .line 62
    :array_1
    .array-data 1
        -0xbt
        -0x26t
        0x21t
        0x23t
        0x2dt
        0x5et
        -0x7ft
        0x79t
        -0xdt
        0x50t
        -0x4ft
        -0x29t
        -0x30t
        0x3t
        0x5bt
        -0x1dt
        -0xft
        -0x9t
        0x75t
        -0x4at
        0x31t
        0x69t
        -0x1at
        0x22t
        -0x23t
        0x48t
        -0x7ft
        0x40t
        -0x74t
        0x45t
        0x6ft
        -0xct
        -0x30t
        -0x51t
        -0xbt
        -0x53t
        -0x45t
        -0xct
        -0x6ct
        -0x2at
        0x41t
        -0x48t
        0x56t
        -0x2at
        0x1bt
        0xct
        0x1at
        0x2t
        0x1ct
        0x7at
        0x33t
        -0x18t
        -0x2dt
        0x24t
        0x36t
        -0x6at
        -0x57t
        -0x3t
        0x1bt
        0x3et
        0x41t
        -0x10t
        -0x7et
        -0x2at
        0x63t
        0x4dt
        -0x46t
        -0x31t
        0x53t
        -0xct
        -0x72t
        -0x23t
        -0x2ct
        -0x6dt
        -0x4dt
        0x1ct
        -0x54t
        -0x42t
        0x48t
        0x16t
        0x12t
        -0x7et
        0x32t
        0x4et
    .end array-data
.end method

.method static synthetic access$000(Lcom/google/appinventor/components/runtime/YandexTranslate;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/YandexTranslate;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Lcom/google/appinventor/components/runtime/YandexTranslate;->performRequest(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private static getResponseContent(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    .locals 8
    .param p0, "connection"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, -0x1

    .line 175
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getContentEncoding()Ljava/lang/String;

    move-result-object v2

    .line 176
    .local v2, "encoding":Ljava/lang/String;
    if-nez v2, :cond_0

    .line 177
    const-string v2, "UTF-8"

    .line 179
    :cond_0
    new-instance v4, Ljava/io/InputStreamReader;

    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v6

    invoke-direct {v4, v6, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    .line 181
    .local v4, "reader":Ljava/io/InputStreamReader;
    :try_start_0
    invoke-virtual {p0}, Ljava/net/HttpURLConnection;->getContentLength()I

    move-result v1

    .line 182
    .local v1, "contentLength":I
    if-eq v1, v7, :cond_1

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 185
    .local v5, "sb":Ljava/lang/StringBuilder;
    :goto_0
    const/16 v6, 0x400

    new-array v0, v6, [C

    .line 187
    .local v0, "buf":[C
    :goto_1
    invoke-virtual {v4, v0}, Ljava/io/InputStreamReader;->read([C)I

    move-result v3

    .local v3, "read":I
    if-eq v3, v7, :cond_2

    .line 188
    const/4 v6, 0x0

    invoke-virtual {v5, v0, v6, v3}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 192
    .end local v0    # "buf":[C
    .end local v1    # "contentLength":I
    .end local v3    # "read":I
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    :catchall_0
    move-exception v6

    invoke-virtual {v4}, Ljava/io/InputStreamReader;->close()V

    throw v6

    .line 182
    .restart local v1    # "contentLength":I
    :cond_1
    :try_start_1
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    goto :goto_0

    .line 190
    .restart local v0    # "buf":[C
    .restart local v3    # "read":I
    .restart local v5    # "sb":Ljava/lang/StringBuilder;
    :cond_2
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v6

    .line 192
    invoke-virtual {v4}, Ljava/io/InputStreamReader;->close()V

    return-object v6
.end method

.method private gk()Ljava/lang/String;
    .locals 4

    .prologue
    .line 214
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->key1:[B

    array-length v2, v2

    new-array v1, v2, [B

    .line 215
    .local v1, "retval":[B
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->key1:[B

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 216
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->key1:[B

    aget-byte v2, v2, v0

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->key2:[B

    aget-byte v3, v3, v0

    xor-int/2addr v2, v3

    int-to-byte v2, v2

    aput-byte v2, v1, v0

    .line 215
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 218
    :cond_0
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v1}, Ljava/lang/String;-><init>([B)V

    return-object v2
.end method

.method private performRequest(Ljava/lang/String;Ljava/lang/String;)V
    .locals 10
    .param p1, "languageToTranslateTo"    # Ljava/lang/String;
    .param p2, "textToTranslate"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 134
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "https://translate.yandex.net/api/v1.5/tr.json/translate?key="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->yandexKey:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "&lang="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "&text="

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "UTF-8"

    invoke-static {p2, v9}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 139
    .local v1, "finalURL":Ljava/lang/String;
    new-instance v7, Ljava/net/URL;

    invoke-direct {v7, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 140
    .local v7, "url":Ljava/net/URL;
    invoke-virtual {v7}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;

    .line 141
    .local v0, "connection":Ljava/net/HttpURLConnection;
    if-eqz v0, :cond_0

    .line 143
    :try_start_0
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/YandexTranslate;->getResponseContent(Ljava/net/HttpURLConnection;)Ljava/lang/String;

    move-result-object v5

    .line 145
    .local v5, "responseContent":Ljava/lang/String;
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 147
    .local v2, "jsonResponse":Lorg/json/JSONObject;
    const-string v8, "code"

    invoke-virtual {v2, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 150
    .local v4, "responseCode":Ljava/lang/String;
    const-string v8, "text"

    invoke-virtual {v2, v8}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v3

    .line 151
    .local v3, "response":Lorg/json/JSONArray;
    const/4 v8, 0x0

    invoke-virtual {v3, v8}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 154
    .local v6, "translation":Ljava/lang/String;
    iget-object v8, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->activity:Landroid/app/Activity;

    new-instance v9, Lcom/google/appinventor/components/runtime/YandexTranslate$2;

    invoke-direct {v9, p0, v4, v6}, Lcom/google/appinventor/components/runtime/YandexTranslate$2;-><init>(Lcom/google/appinventor/components/runtime/YandexTranslate;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v8, v9}, Landroid/app/Activity;->runOnUiThread(Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 162
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 165
    .end local v2    # "jsonResponse":Lorg/json/JSONObject;
    .end local v3    # "response":Lorg/json/JSONArray;
    .end local v4    # "responseCode":Ljava/lang/String;
    .end local v5    # "responseContent":Ljava/lang/String;
    .end local v6    # "translation":Ljava/lang/String;
    :cond_0
    return-void

    .line 162
    :catchall_0
    move-exception v8

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    throw v8
.end method


# virtual methods
.method public GotTranslation(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "responseCode"    # Ljava/lang/String;
    .param p2, "translation"    # Ljava/lang/String;
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleEvent;
        description = "Event triggered when the Yandex.Translate service returns the translated text. This event also provides a response code for error handling. If the responseCode is not 200, then something went wrong with the call, and the translation will not be available."
    .end annotation

    .prologue
    .line 207
    const-string v0, "GotTranslation"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    invoke-static {p0, v0, v1}, Lcom/google/appinventor/components/runtime/EventDispatcher;->dispatchEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;[Ljava/lang/Object;)Z

    .line 208
    return-void
.end method

.method public RequestTranslation(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "languageToTranslateTo"    # Ljava/lang/String;
    .param p2, "textToTranslate"    # Ljava/lang/String;
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleFunction;
        description = "By providing a target language to translate to (for instance, \'es\' for Spanish, \'en\' for English, or \'ru\' for Russian), and a word or sentence to translate, this method will request a translation to the Yandex.Translate service.\nOnce the text is translated by the external service, the event GotTranslation will be executed.\nNote: Yandex.Translate will attempt to detect the source language. You can also specify prepending it to the language translation. I.e., es-ru will specify Spanish to Russian translation."
    .end annotation

    .prologue
    .line 101
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->yandexKey:Ljava/lang/String;

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/YandexTranslate;->form:Lcom/google/appinventor/components/runtime/Form;

    const-string v1, "RequestTranslation"

    const/16 v2, 0x899

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, p0, v1, v2, v3}, Lcom/google/appinventor/components/runtime/Form;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    .line 121
    :goto_0
    return-void

    .line 107
    :cond_0
    new-instance v0, Lcom/google/appinventor/components/runtime/YandexTranslate$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/google/appinventor/components/runtime/YandexTranslate$1;-><init>(Lcom/google/appinventor/components/runtime/YandexTranslate;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/google/appinventor/components/runtime/util/AsynchUtil;->runAsynchronously(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
