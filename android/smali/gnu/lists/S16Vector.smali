.class public Lgnu/lists/S16Vector;
.super Lgnu/lists/SimpleVector;
.source "S16Vector.java"

# interfaces
.implements Ljava/io/Externalizable;
.implements Ljava/lang/Comparable;


# static fields
.field protected static empty:[S


# instance fields
.field data:[S


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x0

    new-array v0, v0, [S

    sput-object v0, Lgnu/lists/S16Vector;->empty:[S

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 20
    sget-object v0, Lgnu/lists/S16Vector;->empty:[S

    iput-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    .line 21
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 33
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 34
    new-array v0, p1, [S

    iput-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    .line 35
    iput p1, p0, Lgnu/lists/S16Vector;->size:I

    .line 36
    return-void
.end method

.method public constructor <init>(IS)V
    .locals 1
    .param p1, "size"    # I
    .param p2, "value"    # S

    .prologue
    .line 24
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 25
    new-array v0, p1, [S

    .line 26
    .local v0, "array":[S
    iput-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    .line 27
    iput p1, p0, Lgnu/lists/S16Vector;->size:I

    .line 28
    :goto_0
    add-int/lit8 p1, p1, -0x1

    if-ltz p1, :cond_0

    .line 29
    aput-short p2, v0, p1

    goto :goto_0

    .line 30
    :cond_0
    return-void
.end method

.method public constructor <init>(Lgnu/lists/Sequence;)V
    .locals 1
    .param p1, "seq"    # Lgnu/lists/Sequence;

    .prologue
    .line 45
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 46
    invoke-interface {p1}, Lgnu/lists/Sequence;->size()I

    move-result v0

    new-array v0, v0, [S

    iput-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    .line 47
    invoke-virtual {p0, p1}, Lgnu/lists/S16Vector;->addAll(Ljava/util/Collection;)Z

    .line 48
    return-void
.end method

.method public constructor <init>([S)V
    .locals 1
    .param p1, "data"    # [S

    .prologue
    .line 39
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 40
    iput-object p1, p0, Lgnu/lists/S16Vector;->data:[S

    .line 41
    array-length v0, p1

    iput v0, p0, Lgnu/lists/S16Vector;->size:I

    .line 42
    return-void
.end method


# virtual methods
.method protected clearBuffer(II)V
    .locals 3
    .param p1, "start"    # I
    .param p2, "count"    # I

    .prologue
    .line 120
    move v0, p1

    .end local p1    # "start":I
    .local v0, "start":I
    :goto_0
    add-int/lit8 p2, p2, -0x1

    if-ltz p2, :cond_0

    .line 121
    iget-object v1, p0, Lgnu/lists/S16Vector;->data:[S

    add-int/lit8 p1, v0, 0x1

    .end local v0    # "start":I
    .restart local p1    # "start":I
    const/4 v2, 0x0

    aput-short v2, v1, v0

    move v0, p1

    .end local p1    # "start":I
    .restart local v0    # "start":I
    goto :goto_0

    .line 122
    :cond_0
    return-void
.end method

.method public compareTo(Ljava/lang/Object;)I
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 154
    check-cast p1, Lgnu/lists/S16Vector;

    .end local p1    # "obj":Ljava/lang/Object;
    invoke-static {p0, p1}, Lgnu/lists/S16Vector;->compareToInt(Lgnu/lists/SimpleVector;Lgnu/lists/SimpleVector;)I

    move-result v0

    return v0
.end method

.method public consumeNext(ILgnu/lists/Consumer;)Z
    .locals 2
    .param p1, "ipos"    # I
    .param p2, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 133
    ushr-int/lit8 v0, p1, 0x1

    .line 134
    .local v0, "index":I
    iget v1, p0, Lgnu/lists/S16Vector;->size:I

    if-lt v0, v1, :cond_0

    .line 135
    const/4 v1, 0x0

    .line 137
    :goto_0
    return v1

    .line 136
    :cond_0
    iget-object v1, p0, Lgnu/lists/S16Vector;->data:[S

    aget-short v1, v1, v0

    invoke-interface {p2, v1}, Lgnu/lists/Consumer;->writeInt(I)V

    .line 137
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public consumePosRange(IILgnu/lists/Consumer;)V
    .locals 3
    .param p1, "iposStart"    # I
    .param p2, "iposEnd"    # I
    .param p3, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 142
    invoke-interface {p3}, Lgnu/lists/Consumer;->ignoring()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 150
    :cond_0
    return-void

    .line 144
    :cond_1
    ushr-int/lit8 v1, p1, 0x1

    .line 145
    .local v1, "i":I
    ushr-int/lit8 v0, p2, 0x1

    .line 146
    .local v0, "end":I
    iget v2, p0, Lgnu/lists/S16Vector;->size:I

    if-le v0, v2, :cond_2

    .line 147
    iget v0, p0, Lgnu/lists/S16Vector;->size:I

    .line 148
    :cond_2
    :goto_0
    if-ge v1, v0, :cond_0

    .line 149
    iget-object v2, p0, Lgnu/lists/S16Vector;->data:[S

    aget-short v2, v2, v1

    invoke-interface {p3, v2}, Lgnu/lists/Consumer;->writeInt(I)V

    .line 148
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public final get(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 89
    iget v0, p0, Lgnu/lists/S16Vector;->size:I

    if-le p1, v0, :cond_0

    .line 90
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 91
    :cond_0
    iget-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    aget-short v0, v0, p1

    invoke-static {v0}, Lgnu/lists/Convert;->toObject(S)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected getBuffer()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    return-object v0
.end method

.method public final getBuffer(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 96
    iget-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    aget-short v0, v0, p1

    invoke-static {v0}, Lgnu/lists/Convert;->toObject(S)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getBufferLength()I
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    array-length v0, v0

    return v0
.end method

.method public getElementKind()I
    .locals 1

    .prologue
    .line 126
    const/16 v0, 0x14

    return v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    const-string v0, "s16"

    return-object v0
.end method

.method public final intAtBuffer(I)I
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 84
    iget-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    aget-short v0, v0, p1

    return v0
.end method

.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 4
    .param p1, "in"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 172
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v2

    .line 173
    .local v2, "size":I
    new-array v0, v2, [S

    .line 174
    .local v0, "data":[S
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 175
    invoke-interface {p1}, Ljava/io/ObjectInput;->readShort()S

    move-result v3

    aput-short v3, v0, v1

    .line 174
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 176
    :cond_0
    iput-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    .line 177
    iput v2, p0, Lgnu/lists/S16Vector;->size:I

    .line 178
    return-void
.end method

.method public setBuffer(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "index"    # I
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 101
    iget-object v1, p0, Lgnu/lists/S16Vector;->data:[S

    aget-short v0, v1, p1

    .line 102
    .local v0, "old":S
    iget-object v1, p0, Lgnu/lists/S16Vector;->data:[S

    invoke-static {p2}, Lgnu/lists/Convert;->toShort(Ljava/lang/Object;)S

    move-result v2

    aput-short v2, v1, p1

    .line 103
    invoke-static {v0}, Lgnu/lists/Convert;->toObject(S)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public setBufferLength(I)V
    .locals 4
    .param p1, "length"    # I

    .prologue
    const/4 v3, 0x0

    .line 58
    iget-object v2, p0, Lgnu/lists/S16Vector;->data:[S

    array-length v0, v2

    .line 59
    .local v0, "oldLength":I
    if-eq v0, p1, :cond_0

    .line 61
    new-array v1, p1, [S

    .line 62
    .local v1, "tmp":[S
    iget-object v2, p0, Lgnu/lists/S16Vector;->data:[S

    if-ge v0, p1, :cond_1

    .end local v0    # "oldLength":I
    :goto_0
    invoke-static {v2, v3, v1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 64
    iput-object v1, p0, Lgnu/lists/S16Vector;->data:[S

    .line 66
    .end local v1    # "tmp":[S
    :cond_0
    return-void

    .restart local v0    # "oldLength":I
    .restart local v1    # "tmp":[S
    :cond_1
    move v0, p1

    .line 62
    goto :goto_0
.end method

.method public final setShortAt(IS)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # S

    .prologue
    .line 108
    iget v0, p0, Lgnu/lists/S16Vector;->size:I

    if-le p1, v0, :cond_0

    .line 109
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 110
    :cond_0
    iget-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    aput-short p2, v0, p1

    .line 111
    return-void
.end method

.method public final setShortAtBuffer(IS)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # S

    .prologue
    .line 115
    iget-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    aput-short p2, v0, p1

    .line 116
    return-void
.end method

.method public final shortAt(I)S
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 72
    iget v0, p0, Lgnu/lists/S16Vector;->size:I

    if-le p1, v0, :cond_0

    .line 73
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 74
    :cond_0
    iget-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    aget-short v0, v0, p1

    return v0
.end method

.method public final shortAtBuffer(I)S
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 79
    iget-object v0, p0, Lgnu/lists/S16Vector;->data:[S

    aget-short v0, v0, p1

    return v0
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 3
    .param p1, "out"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 163
    iget v1, p0, Lgnu/lists/S16Vector;->size:I

    .line 164
    .local v1, "size":I
    invoke-interface {p1, v1}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 165
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 166
    iget-object v2, p0, Lgnu/lists/S16Vector;->data:[S

    aget-short v2, v2, v0

    invoke-interface {p1, v2}, Ljava/io/ObjectOutput;->writeShort(I)V

    .line 165
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 167
    :cond_0
    return-void
.end method
