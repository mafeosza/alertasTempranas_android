.class public abstract Lgnu/lists/ExtSequence;
.super Lgnu/lists/AbstractSequence;
.source "ExtSequence.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lgnu/lists/AbstractSequence;-><init>()V

    return-void
.end method


# virtual methods
.method public copyPos(I)I
    .locals 2
    .param p1, "ipos"    # I

    .prologue
    .line 15
    if-gtz p1, :cond_0

    .line 17
    .end local p1    # "ipos":I
    :goto_0
    return p1

    .restart local p1    # "ipos":I
    :cond_0
    sget-object v0, Lgnu/lists/PositionManager;->manager:Lgnu/lists/PositionManager;

    invoke-static {p1}, Lgnu/lists/PositionManager;->getPositionObject(I)Lgnu/lists/SeqPosition;

    move-result-object v1

    invoke-virtual {v1}, Lgnu/lists/SeqPosition;->copy()Lgnu/lists/SeqPosition;

    move-result-object v1

    invoke-virtual {v0, v1}, Lgnu/lists/PositionManager;->register(Lgnu/lists/SeqPosition;)I

    move-result p1

    goto :goto_0
.end method

.method protected isAfterPos(I)Z
    .locals 3
    .param p1, "ipos"    # I

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 28
    if-gtz p1, :cond_2

    .line 29
    if-gez p1, :cond_1

    .line 30
    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    .line 29
    goto :goto_0

    .line 30
    :cond_2
    invoke-static {p1}, Lgnu/lists/PositionManager;->getPositionObject(I)Lgnu/lists/SeqPosition;

    move-result-object v2

    iget v2, v2, Lgnu/lists/SeqPosition;->ipos:I

    and-int/lit8 v2, v2, 0x1

    if-nez v2, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method protected nextIndex(I)I
    .locals 1
    .param p1, "ipos"    # I

    .prologue
    .line 35
    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    invoke-virtual {p0}, Lgnu/lists/ExtSequence;->size()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    if-nez p1, :cond_1

    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    invoke-static {p1}, Lgnu/lists/PositionManager;->getPositionObject(I)Lgnu/lists/SeqPosition;

    move-result-object v0

    invoke-virtual {v0}, Lgnu/lists/SeqPosition;->nextIndex()I

    move-result v0

    goto :goto_0
.end method

.method protected releasePos(I)V
    .locals 1
    .param p1, "ipos"    # I

    .prologue
    .line 22
    if-lez p1, :cond_0

    .line 23
    sget-object v0, Lgnu/lists/PositionManager;->manager:Lgnu/lists/PositionManager;

    invoke-virtual {v0, p1}, Lgnu/lists/PositionManager;->release(I)V

    .line 24
    :cond_0
    return-void
.end method
