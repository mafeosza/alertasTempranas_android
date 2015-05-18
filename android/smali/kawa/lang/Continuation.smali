.class public Lkawa/lang/Continuation;
.super Lgnu/mapping/MethodProc;
.source "Continuation.java"


# static fields
.field static counter:I


# instance fields
.field id:I

.field public invoked:Z


# direct methods
.method public constructor <init>(Lgnu/mapping/CallContext;)V
    .locals 0
    .param p1, "ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 18
    invoke-direct {p0}, Lgnu/mapping/MethodProc;-><init>()V

    .line 19
    return-void
.end method

.method public static handleException(Ljava/lang/Throwable;Lkawa/lang/Continuation;)Ljava/lang/Object;
    .locals 2
    .param p0, "ex"    # Ljava/lang/Throwable;
    .param p1, "cont"    # Lkawa/lang/Continuation;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 48
    instance-of v1, p0, Lkawa/lang/CalledContinuation;

    if-eqz v1, :cond_0

    move-object v0, p0

    check-cast v0, Lkawa/lang/CalledContinuation;

    .local v0, "cex":Lkawa/lang/CalledContinuation;
    iget-object v1, v0, Lkawa/lang/CalledContinuation;->continuation:Lkawa/lang/Continuation;

    if-eq v1, p1, :cond_1

    .line 50
    .end local v0    # "cex":Lkawa/lang/CalledContinuation;
    :cond_0
    throw p0

    .line 51
    .restart local v0    # "cex":Lkawa/lang/CalledContinuation;
    :cond_1
    const/4 v1, 0x1

    iput-boolean v1, p1, Lkawa/lang/Continuation;->invoked:Z

    .line 52
    iget-object v1, v0, Lkawa/lang/CalledContinuation;->values:[Ljava/lang/Object;

    invoke-static {v1}, Lgnu/mapping/Values;->make([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public static handleException$X(Ljava/lang/Throwable;Lkawa/lang/Continuation;Lgnu/mapping/CallContext;)V
    .locals 6
    .param p0, "ex"    # Ljava/lang/Throwable;
    .param p1, "cont"    # Lkawa/lang/Continuation;
    .param p2, "ctx"    # Lgnu/mapping/CallContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 34
    instance-of v4, p0, Lkawa/lang/CalledContinuation;

    if-eqz v4, :cond_0

    move-object v0, p0

    check-cast v0, Lkawa/lang/CalledContinuation;

    .local v0, "cex":Lkawa/lang/CalledContinuation;
    iget-object v4, v0, Lkawa/lang/CalledContinuation;->continuation:Lkawa/lang/Continuation;

    if-eq v4, p1, :cond_1

    .line 36
    .end local v0    # "cex":Lkawa/lang/CalledContinuation;
    :cond_0
    throw p0

    .line 37
    .restart local v0    # "cex":Lkawa/lang/CalledContinuation;
    :cond_1
    const/4 v4, 0x1

    iput-boolean v4, p1, Lkawa/lang/Continuation;->invoked:Z

    .line 38
    iget-object v3, v0, Lkawa/lang/CalledContinuation;->values:[Ljava/lang/Object;

    .line 39
    .local v3, "values":[Ljava/lang/Object;
    array-length v2, v3

    .line 40
    .local v2, "nvalues":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_2

    .line 41
    iget-object v4, p2, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    aget-object v5, v3, v1

    invoke-interface {v4, v5}, Lgnu/lists/Consumer;->writeObject(Ljava/lang/Object;)V

    .line 40
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 42
    :cond_2
    return-void
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 2
    .param p1, "ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 23
    iget-boolean v0, p0, Lkawa/lang/Continuation;->invoked:Z

    if-eqz v0, :cond_0

    .line 24
    new-instance v0, Lkawa/lang/GenericError;

    const-string v1, "implementation restriction: continuation can only be used once"

    invoke-direct {v0, v1}, Lkawa/lang/GenericError;-><init>(Ljava/lang/String;)V

    throw v0

    .line 26
    :cond_0
    new-instance v0, Lkawa/lang/CalledContinuation;

    iget-object v1, p1, Lgnu/mapping/CallContext;->values:[Ljava/lang/Object;

    invoke-direct {v0, v1, p0, p1}, Lkawa/lang/CalledContinuation;-><init>([Ljava/lang/Object;Lkawa/lang/Continuation;Lgnu/mapping/CallContext;)V

    throw v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 57
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "#<continuation "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lkawa/lang/Continuation;->id:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Lkawa/lang/Continuation;->invoked:Z

    if-eqz v0, :cond_0

    const-string v0, " (invoked)>"

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string v0, ">"

    goto :goto_0
.end method
