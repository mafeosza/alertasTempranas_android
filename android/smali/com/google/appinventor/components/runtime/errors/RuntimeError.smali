.class public abstract Lcom/google/appinventor/components/runtime/errors/RuntimeError;
.super Ljava/lang/RuntimeException;
.source "RuntimeError.java"


# annotations
.annotation runtime Lcom/google/appinventor/components/annotations/SimpleObject;
.end annotation


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/RuntimeException;-><init>()V

    .line 22
    return-void
.end method

.method protected constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    .line 31
    return-void
.end method

.method public static convertToRuntimeError(Ljava/lang/Throwable;)Lcom/google/appinventor/components/runtime/errors/RuntimeError;
    .locals 1
    .param p0, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 41
    instance-of v0, p0, Lcom/google/appinventor/components/runtime/errors/RuntimeError;

    if-eqz v0, :cond_0

    .line 42
    check-cast p0, Lcom/google/appinventor/components/runtime/errors/RuntimeError;

    .line 53
    .end local p0    # "throwable":Ljava/lang/Throwable;
    :goto_0
    return-object p0

    .line 46
    .restart local p0    # "throwable":Ljava/lang/Throwable;
    :cond_0
    instance-of v0, p0, Ljava/lang/ArrayIndexOutOfBoundsException;

    if-eqz v0, :cond_1

    .line 47
    new-instance p0, Lcom/google/appinventor/components/runtime/errors/ArrayIndexOutOfBoundsError;

    .end local p0    # "throwable":Ljava/lang/Throwable;
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/errors/ArrayIndexOutOfBoundsError;-><init>()V

    goto :goto_0

    .line 49
    .restart local p0    # "throwable":Ljava/lang/Throwable;
    :cond_1
    instance-of v0, p0, Ljava/lang/IllegalArgumentException;

    if-eqz v0, :cond_2

    .line 50
    new-instance p0, Lcom/google/appinventor/components/runtime/errors/IllegalArgumentError;

    .end local p0    # "throwable":Ljava/lang/Throwable;
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/errors/IllegalArgumentError;-><init>()V

    goto :goto_0

    .line 52
    .restart local p0    # "throwable":Ljava/lang/Throwable;
    :cond_2
    instance-of v0, p0, Ljava/lang/NullPointerException;

    if-eqz v0, :cond_3

    .line 53
    new-instance p0, Lcom/google/appinventor/components/runtime/errors/UninitializedInstanceError;

    .end local p0    # "throwable":Ljava/lang/Throwable;
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/errors/UninitializedInstanceError;-><init>()V

    goto :goto_0

    .line 57
    .restart local p0    # "throwable":Ljava/lang/Throwable;
    :cond_3
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0, p0}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method
