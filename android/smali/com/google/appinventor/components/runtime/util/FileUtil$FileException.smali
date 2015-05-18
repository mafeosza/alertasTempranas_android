.class public Lcom/google/appinventor/components/runtime/util/FileUtil$FileException;
.super Lcom/google/appinventor/components/runtime/errors/RuntimeError;
.source "FileUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/appinventor/components/runtime/util/FileUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FileException"
.end annotation


# instance fields
.field private final msgNumber:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "errorMsgNumber"    # I

    .prologue
    .line 287
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/errors/RuntimeError;-><init>()V

    .line 288
    iput p1, p0, Lcom/google/appinventor/components/runtime/util/FileUtil$FileException;->msgNumber:I

    .line 289
    return-void
.end method


# virtual methods
.method public getErrorMessageNumber()I
    .locals 1

    .prologue
    .line 292
    iget v0, p0, Lcom/google/appinventor/components/runtime/util/FileUtil$FileException;->msgNumber:I

    return v0
.end method
