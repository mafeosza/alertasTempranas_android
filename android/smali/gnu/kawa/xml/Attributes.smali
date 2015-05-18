.class public Lgnu/kawa/xml/Attributes;
.super Lgnu/mapping/MethodProc;
.source "Attributes.java"


# static fields
.field public static final attributes:Lgnu/kawa/xml/Attributes;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 10
    new-instance v0, Lgnu/kawa/xml/Attributes;

    invoke-direct {v0}, Lgnu/kawa/xml/Attributes;-><init>()V

    sput-object v0, Lgnu/kawa/xml/Attributes;->attributes:Lgnu/kawa/xml/Attributes;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lgnu/mapping/MethodProc;-><init>()V

    return-void
.end method

.method public static attributes(Lgnu/lists/TreeList;ILgnu/lists/Consumer;)V
    .locals 7
    .param p0, "tlist"    # Lgnu/lists/TreeList;
    .param p1, "index"    # I
    .param p2, "consumer"    # Lgnu/lists/Consumer;

    .prologue
    .line 16
    invoke-virtual {p0, p1}, Lgnu/lists/TreeList;->gotoAttributesStart(I)I

    move-result v0

    .line 17
    .local v0, "attr":I
    sget-object v4, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Attributes called, at:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    invoke-virtual {p0}, Lgnu/lists/TreeList;->dump()V

    .line 18
    :goto_0
    if-ltz v0, :cond_0

    .line 20
    shl-int/lit8 v1, v0, 0x1

    .line 21
    .local v1, "ipos":I
    invoke-virtual {p0, v1}, Lgnu/lists/TreeList;->getNextKind(I)I

    move-result v2

    .line 22
    .local v2, "kind":I
    const/16 v4, 0x23

    if-eq v2, v4, :cond_1

    .line 32
    .end local v1    # "ipos":I
    .end local v2    # "kind":I
    :cond_0
    return-void

    .line 25
    .restart local v1    # "ipos":I
    .restart local v2    # "kind":I
    :cond_1
    invoke-virtual {p0, v0}, Lgnu/lists/TreeList;->nextDataIndex(I)I

    move-result v3

    .line 26
    .local v3, "next":I
    instance-of v4, p2, Lgnu/lists/PositionConsumer;

    if-eqz v4, :cond_2

    move-object v4, p2

    .line 27
    check-cast v4, Lgnu/lists/PositionConsumer;

    invoke-interface {v4, p0, v1}, Lgnu/lists/PositionConsumer;->writePosition(Lgnu/lists/AbstractSequence;I)V

    .line 30
    :goto_1
    move v0, v3

    .line 31
    goto :goto_0

    .line 29
    :cond_2
    invoke-virtual {p0, v0, v3, p2}, Lgnu/lists/TreeList;->consumeIRange(IILgnu/lists/Consumer;)I

    goto :goto_1
.end method

.method public static attributes(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    .locals 3
    .param p0, "node"    # Ljava/lang/Object;
    .param p1, "consumer"    # Lgnu/lists/Consumer;

    .prologue
    .line 36
    instance-of v1, p0, Lgnu/lists/TreeList;

    if-eqz v1, :cond_1

    .line 38
    check-cast p0, Lgnu/lists/TreeList;

    .end local p0    # "node":Ljava/lang/Object;
    const/4 v1, 0x0

    invoke-static {p0, v1, p1}, Lgnu/kawa/xml/Attributes;->attributes(Lgnu/lists/TreeList;ILgnu/lists/Consumer;)V

    .line 46
    :cond_0
    :goto_0
    return-void

    .line 40
    .restart local p0    # "node":Ljava/lang/Object;
    :cond_1
    instance-of v1, p0, Lgnu/lists/SeqPosition;

    if-eqz v1, :cond_0

    instance-of v1, p0, Lgnu/lists/TreePosition;

    if-nez v1, :cond_0

    move-object v0, p0

    .line 42
    check-cast v0, Lgnu/lists/SeqPosition;

    .line 43
    .local v0, "pos":Lgnu/lists/SeqPosition;
    iget-object v1, v0, Lgnu/lists/SeqPosition;->sequence:Lgnu/lists/AbstractSequence;

    instance-of v1, v1, Lgnu/lists/TreeList;

    if-eqz v1, :cond_0

    .line 44
    iget-object v1, v0, Lgnu/lists/SeqPosition;->sequence:Lgnu/lists/AbstractSequence;

    check-cast v1, Lgnu/lists/TreeList;

    iget v2, v0, Lgnu/lists/SeqPosition;->ipos:I

    shr-int/lit8 v2, v2, 0x1

    invoke-static {v1, v2, p1}, Lgnu/kawa/xml/Attributes;->attributes(Lgnu/lists/TreeList;ILgnu/lists/Consumer;)V

    goto :goto_0
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 6
    .param p1, "ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 50
    iget-object v0, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 51
    .local v0, "consumer":Lgnu/lists/Consumer;
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->getNextArg()Ljava/lang/Object;

    move-result-object v3

    .line 52
    .local v3, "node":Ljava/lang/Object;
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->lastArg()V

    .line 53
    instance-of v5, v3, Lgnu/mapping/Values;

    if-eqz v5, :cond_2

    move-object v4, v3

    .line 55
    check-cast v4, Lgnu/lists/TreeList;

    .line 56
    .local v4, "tlist":Lgnu/lists/TreeList;
    const/4 v1, 0x0

    .line 59
    .local v1, "index":I
    :goto_0
    shl-int/lit8 v5, v1, 0x1

    invoke-virtual {v4, v5}, Lgnu/lists/TreeList;->getNextKind(I)I

    move-result v2

    .line 60
    .local v2, "kind":I
    if-nez v2, :cond_0

    .line 71
    .end local v1    # "index":I
    .end local v2    # "kind":I
    .end local v4    # "tlist":Lgnu/lists/TreeList;
    :goto_1
    return-void

    .line 62
    .restart local v1    # "index":I
    .restart local v2    # "kind":I
    .restart local v4    # "tlist":Lgnu/lists/TreeList;
    :cond_0
    const/16 v5, 0x20

    if-ne v2, v5, :cond_1

    .line 63
    shl-int/lit8 v5, v1, 0x1

    invoke-virtual {v4, v5}, Lgnu/lists/TreeList;->getPosNext(I)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v5, v0}, Lgnu/kawa/xml/Attributes;->attributes(Ljava/lang/Object;Lgnu/lists/Consumer;)V

    .line 66
    :goto_2
    invoke-virtual {v4, v1}, Lgnu/lists/TreeList;->nextDataIndex(I)I

    move-result v1

    .line 67
    goto :goto_0

    .line 65
    :cond_1
    invoke-static {v4, v1, v0}, Lgnu/kawa/xml/Attributes;->attributes(Lgnu/lists/TreeList;ILgnu/lists/Consumer;)V

    goto :goto_2

    .line 70
    .end local v1    # "index":I
    .end local v2    # "kind":I
    .end local v4    # "tlist":Lgnu/lists/TreeList;
    :cond_2
    invoke-static {v3, v0}, Lgnu/kawa/xml/Attributes;->attributes(Ljava/lang/Object;Lgnu/lists/Consumer;)V

    goto :goto_1
.end method

.method public numArgs()I
    .locals 1

    .prologue
    .line 12
    const/16 v0, 0x1001

    return v0
.end method
