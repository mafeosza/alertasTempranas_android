.class final Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;
.super Ljava/lang/Object;
.source "PackageInstaller.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/util/PackageInstaller;->doPackageInstall(Lcom/google/appinventor/components/runtime/Form;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$form:Lcom/google/appinventor/components/runtime/Form;

.field final synthetic val$inurl:Ljava/lang/String;


# direct methods
.method constructor <init>(Ljava/lang/String;Lcom/google/appinventor/components/runtime/Form;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;->val$inurl:Ljava/lang/String;

    iput-object p2, p0, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;->val$form:Lcom/google/appinventor/components/runtime/Form;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 19

    .prologue
    .line 43
    :try_start_0
    new-instance v11, Ljava/net/URL;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;->val$inurl:Ljava/lang/String;

    invoke-direct {v11, v12}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 44
    .local v11, "url":Ljava/net/URL;
    invoke-virtual {v11}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v4

    .line 45
    .local v4, "conn":Ljava/net/URLConnection;
    new-instance v10, Ljava/io/File;

    const-string v12, "/sdcard/AppInventor/assets/"

    invoke-direct {v10, v12}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 46
    .local v10, "rootDir":Ljava/io/File;
    new-instance v6, Ljava/io/BufferedInputStream;

    invoke-virtual {v4}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v12

    invoke-direct {v6, v12}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 47
    .local v6, "instream":Ljava/io/InputStream;
    new-instance v2, Ljava/io/File;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v12, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, "/package.apk"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v2, v12}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 48
    .local v2, "apkfile":Ljava/io/File;
    new-instance v1, Ljava/io/FileOutputStream;

    invoke-direct {v1, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 49
    .local v1, "apkOut":Ljava/io/FileOutputStream;
    const v12, 0x8000

    new-array v3, v12, [B

    .line 51
    .local v3, "buffer":[B
    :goto_0
    const/4 v12, 0x0

    const v13, 0x8000

    invoke-virtual {v6, v3, v12, v13}, Ljava/io/InputStream;->read([BII)I

    move-result v8

    .local v8, "len":I
    if-lez v8, :cond_0

    .line 52
    const/4 v12, 0x0

    invoke-virtual {v1, v3, v12, v8}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 62
    .end local v1    # "apkOut":Ljava/io/FileOutputStream;
    .end local v2    # "apkfile":Ljava/io/File;
    .end local v3    # "buffer":[B
    .end local v4    # "conn":Ljava/net/URLConnection;
    .end local v6    # "instream":Ljava/io/InputStream;
    .end local v8    # "len":I
    .end local v10    # "rootDir":Ljava/io/File;
    .end local v11    # "url":Ljava/net/URL;
    :catch_0
    move-exception v5

    .line 63
    .local v5, "e":Ljava/lang/Exception;
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;->val$form:Lcom/google/appinventor/components/runtime/Form;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;->val$form:Lcom/google/appinventor/components/runtime/Form;

    const-string v14, "PackageInstaller"

    const/16 v15, 0x44d

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;->val$inurl:Ljava/lang/String;

    move-object/from16 v18, v0

    aput-object v18, v16, v17

    invoke-virtual/range {v12 .. v16}, Lcom/google/appinventor/components/runtime/Form;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    .line 66
    .end local v5    # "e":Ljava/lang/Exception;
    :goto_1
    return-void

    .line 54
    .restart local v1    # "apkOut":Ljava/io/FileOutputStream;
    .restart local v2    # "apkfile":Ljava/io/File;
    .restart local v3    # "buffer":[B
    .restart local v4    # "conn":Ljava/net/URLConnection;
    .restart local v6    # "instream":Ljava/io/InputStream;
    .restart local v8    # "len":I
    .restart local v10    # "rootDir":Ljava/io/File;
    .restart local v11    # "url":Ljava/net/URL;
    :cond_0
    :try_start_1
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V

    .line 55
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V

    .line 57
    const-string v12, "PackageInstaller(AppInventor)"

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "About to Install package from "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;->val$inurl:Ljava/lang/String;

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v12, v13}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 58
    new-instance v7, Landroid/content/Intent;

    const-string v12, "android.intent.action.VIEW"

    invoke-direct {v7, v12}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 59
    .local v7, "intent":Landroid/content/Intent;
    new-instance v12, Ljava/io/File;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v13, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "/package.apk"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v12}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v9

    .line 60
    .local v9, "packageuri":Landroid/net/Uri;
    const-string v12, "application/vnd.android.package-archive"

    invoke-virtual {v7, v9, v12}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 61
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;->val$form:Lcom/google/appinventor/components/runtime/Form;

    invoke-virtual {v12, v7}, Lcom/google/appinventor/components/runtime/Form;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method
