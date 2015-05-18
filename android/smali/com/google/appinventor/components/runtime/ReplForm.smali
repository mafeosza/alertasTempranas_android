.class public Lcom/google/appinventor/components/runtime/ReplForm;
.super Lcom/google/appinventor/components/runtime/Form;
.source "ReplForm.java"


# static fields
.field private static final REPL_ASSET_DIR:Ljava/lang/String; = "/sdcard/AppInventor/assets/"

.field public static topform:Lcom/google/appinventor/components/runtime/ReplForm;


# instance fields
.field private IsUSBRepl:Z

.field private assetsLoaded:Z

.field private httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

.field private isDirect:Z

.field private replResult:Ljava/lang/Object;

.field private replResultFormName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 56
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/Form;-><init>()V

    .line 46
    iput-object v1, p0, Lcom/google/appinventor/components/runtime/ReplForm;->httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    .line 49
    iput-boolean v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->IsUSBRepl:Z

    .line 50
    iput-boolean v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->assetsLoaded:Z

    .line 51
    iput-boolean v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->isDirect:Z

    .line 52
    iput-object v1, p0, Lcom/google/appinventor/components/runtime/ReplForm;->replResult:Ljava/lang/Object;

    .line 53
    iput-object v1, p0, Lcom/google/appinventor/components/runtime/ReplForm;->replResultFormName:Ljava/lang/String;

    .line 57
    sput-object p0, Lcom/google/appinventor/components/runtime/ReplForm;->topform:Lcom/google/appinventor/components/runtime/ReplForm;

    .line 58
    return-void
.end method

.method private checkAssetDir()V
    .locals 2

    .prologue
    .line 212
    new-instance v0, Ljava/io/File;

    const-string v1, "/sdcard/AppInventor/assets/"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 213
    .local v0, "f":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_0

    .line 214
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 215
    :cond_0
    return-void
.end method


# virtual methods
.method HandleReturnValues()V
    .locals 3

    .prologue
    .line 156
    const-string v0, "ReplForm"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "HandleReturnValues() Called, replResult = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/ReplForm;->replResult:Ljava/lang/Object;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 157
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->replResult:Ljava/lang/Object;

    if-eqz v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->replResultFormName:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/ReplForm;->replResult:Ljava/lang/Object;

    invoke-virtual {p0, v0, v1}, Lcom/google/appinventor/components/runtime/ReplForm;->OtherScreenClosed(Ljava/lang/String;Ljava/lang/Object;)V

    .line 159
    const-string v0, "ReplForm"

    const-string v1, "Called OtherScreenClosed"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 160
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->replResult:Ljava/lang/Object;

    .line 162
    :cond_0
    return-void
.end method

.method public addSettingsButton(Landroid/view/Menu;)V
    .locals 4
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v3, 0x0

    .line 137
    const/4 v1, 0x3

    const-string v2, "Settings"

    invoke-interface {p1, v3, v3, v1, v2}, Landroid/view/Menu;->add(IIILjava/lang/CharSequence;)Landroid/view/MenuItem;

    move-result-object v1

    new-instance v2, Lcom/google/appinventor/components/runtime/ReplForm$2;

    invoke-direct {v2, p0}, Lcom/google/appinventor/components/runtime/ReplForm$2;-><init>(Lcom/google/appinventor/components/runtime/ReplForm;)V

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setOnMenuItemClickListener(Landroid/view/MenuItem$OnMenuItemClickListener;)Landroid/view/MenuItem;

    move-result-object v0

    .line 145
    .local v0, "showSettingsItem":Landroid/view/MenuItem;
    const v1, 0x1080093

    invoke-interface {v0, v1}, Landroid/view/MenuItem;->setIcon(I)Landroid/view/MenuItem;

    .line 146
    return-void
.end method

.method protected closeApplicationFromBlocks()V
    .locals 1

    .prologue
    .line 116
    new-instance v0, Lcom/google/appinventor/components/runtime/ReplForm$1;

    invoke-direct {v0, p0}, Lcom/google/appinventor/components/runtime/ReplForm$1;-><init>(Lcom/google/appinventor/components/runtime/ReplForm;)V

    invoke-virtual {p0, v0}, Lcom/google/appinventor/components/runtime/ReplForm;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 122
    return-void
.end method

.method protected closeForm(Landroid/content/Intent;)V
    .locals 1
    .param p1, "resultIntent"    # Landroid/content/Intent;

    .prologue
    .line 104
    const-string v0, "Not Yet"

    invoke-static {v0}, Lcom/google/appinventor/components/runtime/util/RetValManager;->popScreen(Ljava/lang/String;)V

    .line 105
    return-void
.end method

.method public isAssetsLoaded()Z
    .locals 1

    .prologue
    .line 223
    iget-boolean v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->assetsLoaded:Z

    return v0
.end method

.method public isDirect()Z
    .locals 1

    .prologue
    .line 190
    iget-boolean v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->isDirect:Z

    return v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "icicle"    # Landroid/os/Bundle;

    .prologue
    .line 62
    invoke-super {p0, p1}, Lcom/google/appinventor/components/runtime/Form;->onCreate(Landroid/os/Bundle;)V

    .line 63
    const-string v1, "ReplForm"

    const-string v2, "onCreate"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 64
    invoke-virtual {p0}, Lcom/google/appinventor/components/runtime/ReplForm;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 65
    .local v0, "intent":Landroid/content/Intent;
    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/google/appinventor/components/runtime/ReplForm;->processExtras(Landroid/content/Intent;Z)V

    .line 66
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 131
    invoke-super {p0, p1}, Lcom/google/appinventor/components/runtime/Form;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    .line 132
    invoke-virtual {p0, p1}, Lcom/google/appinventor/components/runtime/ReplForm;->addSettingsButton(Landroid/view/Menu;)V

    .line 133
    const/4 v0, 0x1

    return v0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 80
    invoke-super {p0}, Lcom/google/appinventor/components/runtime/Form;->onDestroy()V

    .line 81
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    invoke-virtual {v0}, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->stop()V

    .line 83
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    .line 85
    :cond_0
    invoke-virtual {p0}, Lcom/google/appinventor/components/runtime/ReplForm;->finish()V

    .line 86
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    .line 87
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 150
    invoke-super {p0, p1}, Lcom/google/appinventor/components/runtime/Form;->onNewIntent(Landroid/content/Intent;)V

    .line 151
    const-string v0, "ReplForm"

    const-string v1, "onNewIntent Called"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/google/appinventor/components/runtime/ReplForm;->processExtras(Landroid/content/Intent;Z)V

    .line 153
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 70
    invoke-super {p0}, Lcom/google/appinventor/components/runtime/Form;->onResume()V

    .line 71
    return-void
.end method

.method protected onStop()V
    .locals 0

    .prologue
    .line 75
    invoke-super {p0}, Lcom/google/appinventor/components/runtime/Form;->onStop()V

    .line 76
    return-void
.end method

.method protected processExtras(Landroid/content/Intent;Z)V
    .locals 6
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "restart"    # Z

    .prologue
    const/4 v5, 0x1

    .line 165
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 166
    .local v0, "extras":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 167
    const-string v2, "ReplForm"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "extras: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 168
    invoke-virtual {v0}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 169
    .local v1, "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 170
    const-string v3, "ReplForm"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Extra Key: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 173
    .end local v1    # "keys":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_0
    if-eqz v0, :cond_1

    const-string v2, "rundirect"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 174
    const-string v2, "ReplForm"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "processExtras rundirect is true and restart is "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 175
    iput-boolean v5, p0, Lcom/google/appinventor/components/runtime/ReplForm;->isDirect:Z

    .line 176
    iput-boolean v5, p0, Lcom/google/appinventor/components/runtime/ReplForm;->assetsLoaded:Z

    .line 177
    if-eqz p2, :cond_1

    .line 178
    invoke-virtual {p0}, Lcom/google/appinventor/components/runtime/ReplForm;->clear()V

    .line 179
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/ReplForm;->httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    if-eqz v2, :cond_2

    .line 180
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/ReplForm;->httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    invoke-virtual {v2}, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->resetSeq()V

    .line 187
    :cond_1
    :goto_1
    return-void

    .line 182
    :cond_2
    invoke-virtual {p0, v5}, Lcom/google/appinventor/components/runtime/ReplForm;->startHTTPD(Z)V

    .line 183
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/ReplForm;->httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    const-string v2, "emulator"

    invoke-static {v2}, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->setHmacKey(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public setAssetsLoaded()V
    .locals 1

    .prologue
    .line 227
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->assetsLoaded:Z

    .line 228
    return-void
.end method

.method public setFormName(Ljava/lang/String;)V
    .locals 3
    .param p1, "formName"    # Ljava/lang/String;

    .prologue
    .line 98
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/ReplForm;->formName:Ljava/lang/String;

    .line 99
    const-string v0, "ReplForm"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "formName is now "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 100
    return-void
.end method

.method public setIsUSBrepl()V
    .locals 1

    .prologue
    .line 194
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->IsUSBRepl:Z

    .line 195
    return-void
.end method

.method protected setResult(Ljava/lang/Object;)V
    .locals 3
    .param p1, "result"    # Ljava/lang/Object;

    .prologue
    .line 108
    const-string v0, "ReplForm"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "setResult: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 109
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/ReplForm;->replResult:Ljava/lang/Object;

    .line 110
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->formName:Ljava/lang/String;

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->replResultFormName:Ljava/lang/String;

    .line 111
    return-void
.end method

.method public startHTTPD(Z)V
    .locals 5
    .param p1, "secure"    # Z

    .prologue
    .line 200
    :try_start_0
    iget-object v1, p0, Lcom/google/appinventor/components/runtime/ReplForm;->httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    if-nez v1, :cond_0

    .line 201
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/ReplForm;->checkAssetDir()V

    .line 202
    new-instance v1, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    const/16 v2, 0x1f41

    new-instance v3, Ljava/io/File;

    const-string v4, "/sdcard/AppInventor/assets/"

    invoke-direct {v3, v4}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {v1, v2, v3, p1, p0}, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;-><init>(ILjava/io/File;ZLcom/google/appinventor/components/runtime/ReplForm;)V

    iput-object v1, p0, Lcom/google/appinventor/components/runtime/ReplForm;->httpdServer:Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    .line 203
    const-string v1, "ReplForm"

    const-string v2, "started AppInvHTTPD"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 208
    :cond_0
    :goto_0
    return-void

    .line 205
    :catch_0
    move-exception v0

    .line 206
    .local v0, "ex":Ljava/io/IOException;
    const-string v1, "ReplForm"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Setting up NanoHTTPD: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected startNewForm(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "nextFormName"    # Ljava/lang/String;
    .param p2, "startupValue"    # Ljava/lang/Object;

    .prologue
    .line 91
    if-eqz p2, :cond_0

    .line 92
    const-string v0, "open another screen with start value"

    invoke-static {p2, v0}, Lcom/google/appinventor/components/runtime/ReplForm;->jsonEncodeForForm(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/ReplForm;->startupValue:Ljava/lang/String;

    .line 94
    :cond_0
    invoke-static {p1, p2}, Lcom/google/appinventor/components/runtime/util/RetValManager;->pushScreen(Ljava/lang/String;Ljava/lang/Object;)V

    .line 95
    return-void
.end method
