.class public Lcom/google/appinventor/components/runtime/util/FroyoUtil;
.super Ljava/lang/Object;
.source "FroyoUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    return-void
.end method

.method public static abandonFocus(Landroid/media/AudioManager;Ljava/lang/Object;)V
    .locals 0
    .param p0, "am"    # Landroid/media/AudioManager;
    .param p1, "afChangeListener"    # Ljava/lang/Object;

    .prologue
    .line 115
    check-cast p1, Landroid/media/AudioManager$OnAudioFocusChangeListener;

    .end local p1    # "afChangeListener":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Landroid/media/AudioManager;->abandonAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;)I

    .line 116
    return-void
.end method

.method public static focusRequestGranted(Landroid/media/AudioManager;Ljava/lang/Object;)Z
    .locals 3
    .param p0, "am"    # Landroid/media/AudioManager;
    .param p1, "afChangeListener"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    .line 104
    check-cast p1, Landroid/media/AudioManager$OnAudioFocusChangeListener;

    .end local p1    # "afChangeListener":Ljava/lang/Object;
    const/4 v2, 0x3

    invoke-virtual {p0, p1, v2, v1}, Landroid/media/AudioManager;->requestAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I

    move-result v0

    .line 106
    .local v0, "result":I
    if-ne v0, v1, :cond_0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getRotation(Landroid/view/Display;)I
    .locals 1
    .param p0, "display"    # Landroid/view/Display;

    .prologue
    .line 40
    invoke-virtual {p0}, Landroid/view/Display;->getRotation()I

    move-result v0

    return v0
.end method

.method public static getWebViewClient(ZZLcom/google/appinventor/components/runtime/Form;Lcom/google/appinventor/components/runtime/Component;)Landroid/webkit/WebViewClient;
    .locals 1
    .param p0, "ignoreErrors"    # Z
    .param p1, "followLinks"    # Z
    .param p2, "form"    # Lcom/google/appinventor/components/runtime/Form;
    .param p3, "component"    # Lcom/google/appinventor/components/runtime/Component;

    .prologue
    .line 128
    new-instance v0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;

    invoke-direct {v0, p1, p0, p2, p3}, Lcom/google/appinventor/components/runtime/util/FroyoUtil$2;-><init>(ZZLcom/google/appinventor/components/runtime/Form;Lcom/google/appinventor/components/runtime/Component;)V

    return-object v0
.end method

.method public static setAudioFocusChangeListener(Lcom/google/appinventor/components/runtime/Player;)Ljava/lang/Object;
    .locals 1
    .param p0, "player"    # Lcom/google/appinventor/components/runtime/Player;

    .prologue
    .line 59
    new-instance v0, Lcom/google/appinventor/components/runtime/util/FroyoUtil$1;

    invoke-direct {v0, p0}, Lcom/google/appinventor/components/runtime/util/FroyoUtil$1;-><init>(Lcom/google/appinventor/components/runtime/Player;)V

    .line 94
    .local v0, "afChangeListener":Lcom/google/appinventor/components/runtime/util/FroyoUtil$1;
    return-object v0
.end method

.method public static setAudioManager(Landroid/app/Activity;)Landroid/media/AudioManager;
    .locals 1
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 50
    const-string v0, "audio"

    invoke-virtual {p0, v0}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    return-object v0
.end method
