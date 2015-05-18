.class public Lcom/google/appinventor/components/runtime/util/PackageInstaller;
.super Ljava/lang/Object;
.source "PackageInstaller.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "PackageInstaller(AppInventor)"

.field private static final REPL_ASSET_DIR:Ljava/lang/String; = "/sdcard/AppInventor/assets/"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    return-void
.end method

.method public static doPackageInstall(Lcom/google/appinventor/components/runtime/Form;Ljava/lang/String;)V
    .locals 1
    .param p0, "form"    # Lcom/google/appinventor/components/runtime/Form;
    .param p1, "inurl"    # Ljava/lang/String;

    .prologue
    .line 39
    new-instance v0, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;

    invoke-direct {v0, p1, p0}, Lcom/google/appinventor/components/runtime/util/PackageInstaller$1;-><init>(Ljava/lang/String;Lcom/google/appinventor/components/runtime/Form;)V

    invoke-static {v0}, Lcom/google/appinventor/components/runtime/util/AsynchUtil;->runAsynchronously(Ljava/lang/Runnable;)V

    .line 68
    return-void
.end method
