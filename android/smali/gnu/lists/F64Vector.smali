.class public Lgnu/lists/F64Vector;
.super Lgnu/lists/SimpleVector;
.source "F64Vector.java"

# interfaces
.implements Ljava/io/Externalizable;
.implements Ljava/lang/Comparable;


# static fields
.field protected static empty:[D


# instance fields
.field data:[D


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x0

    new-array v0, v0, [D

    sput-object v0, Lgnu/lists/F64Vector;->empty:[D

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 20
    sget-object v0, Lgnu/lists/F64Vector;->empty:[D

    iput-object v0, p0, Lgnu/lists/F64Vector;->data:[D

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
    new-array v0, p1, [D

    iput-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    .line 35
    iput p1, p0, Lgnu/lists/F64Vector;->size:I

    .line 36
    return-void
.end method

.method public constructor <init>(ID)V
    .locals 1
    .param p1, "size"    # I
    .param p2, "value"    # D

    .prologue
    .line 24
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 25
    new-array v0, p1, [D

    .line 26
    .local v0, "array":[D
    iput-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    .line 27
    iput p1, p0, Lgnu/lists/F64Vector;->size:I

    .line 28
    :goto_0
    add-int/lit8 p1, p1, -0x1

    if-ltz p1, :cond_0

    .line 29
    aput-wide p2, v0, p1

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

    new-array v0, v0, [D

    iput-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    .line 47
    invoke-virtual {p0, p1}, Lgnu/lists/F64Vector;->addAll(Ljava/util/Collection;)Z

    .line 48
    return-void
.end method

.method public constructor <init>([D)V
    .locals 1
    .param p1, "data"    # [D

    .prologue
    .line 39
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 40
    iput-object p1, p0, Lgnu/lists/F64Vector;->data:[D

    .line 41
    array-length v0, p1

    iput v0, p0, Lgnu/lists/F64Vector;->size:I

    .line 42
    return-void
.end method


# virtual methods
.method protected clearBuffer(II)V
    .locals 4
    .param p1, "start"    # I
    .param p2, "count"    # I

    .prologue
    .line 127
    move v0, p1

    .end local p1    # "start":I
    .local v0, "start":I
    :goto_0
    add-int/lit8 p2, p2, -0x1

    if-ltz p2, :cond_0

    .line 128
    iget-object v1, p0, Lgnu/lists/F64Vector;->data:[D

    add-int/lit8 p1, v0, 0x1

    .end local v0    # "start":I
    .restart local p1    # "start":I
    const-wide/16 v2, 0x0

    aput-wide v2, v1, v0

    move v0, p1

    .end local p1    # "start":I
    .restart local v0    # "start":I
    goto :goto_0

    .line 129
    :cond_0
    return-void
.end method

.method public compareTo(Ljava/lang/Object;)I
    .locals 12
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 166
    move-object v10, p1

    check-cast v10, Lgnu/lists/F64Vector;

    .line 167
    .local v10, "vec2":Lgnu/lists/F64Vector;
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    .line 168
    .local v0, "arr1":[D
    iget-object v1, v10, Lgnu/lists/F64Vector;->data:[D

    .line 169
    .local v1, "arr2":[D
    iget v4, p0, Lgnu/lists/F64Vector;->size:I

    .line 170
    .local v4, "n1":I
    iget v5, v10, Lgnu/lists/F64Vector;->size:I

    .line 171
    .local v5, "n2":I
    if-le v4, v5, :cond_0

    move v3, v5

    .line 172
    .local v3, "n":I
    :goto_0
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v3, :cond_3

    .line 174
    aget-wide v6, v0, v2

    .line 175
    .local v6, "v1":D
    aget-wide v8, v1, v2

    .line 176
    .local v8, "v2":D
    cmpl-double v11, v6, v8

    if-eqz v11, :cond_2

    .line 177
    cmpl-double v11, v6, v8

    if-lez v11, :cond_1

    const/4 v11, 0x1

    .line 179
    .end local v6    # "v1":D
    .end local v8    # "v2":D
    :goto_2
    return v11

    .end local v2    # "i":I
    .end local v3    # "n":I
    :cond_0
    move v3, v4

    .line 171
    goto :goto_0

    .line 177
    .restart local v2    # "i":I
    .restart local v3    # "n":I
    .restart local v6    # "v1":D
    .restart local v8    # "v2":D
    :cond_1
    const/4 v11, -0x1

    goto :goto_2

    .line 172
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 179
    .end local v6    # "v1":D
    .end local v8    # "v2":D
    :cond_3
    sub-int v11, v4, v5

    goto :goto_2
.end method

.method public consumeNext(ILgnu/lists/Consumer;)Z
    .locals 3
    .param p1, "ipos"    # I
    .param p2, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 140
    ushr-int/lit8 v0, p1, 0x1

    .line 141
    .local v0, "index":I
    iget v1, p0, Lgnu/lists/F64Vector;->size:I

    if-lt v0, v1, :cond_0

    .line 142
    const/4 v1, 0x0

    .line 144
    :goto_0
    return v1

    .line 143
    :cond_0
    iget-object v1, p0, Lgnu/lists/F64Vector;->data:[D

    aget-wide v1, v1, v0

    invoke-interface {p2, v1, v2}, Lgnu/lists/Consumer;->writeDouble(D)V

    .line 144
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public consumePosRange(IILgnu/lists/Consumer;)V
    .locals 4
    .param p1, "iposStart"    # I
    .param p2, "iposEnd"    # I
    .param p3, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 149
    invoke-interface {p3}, Lgnu/lists/Consumer;->ignoring()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 155
    :cond_0
    return-void

    .line 151
    :cond_1
    ushr-int/lit8 v1, p1, 0x1

    .line 152
    .local v1, "i":I
    ushr-int/lit8 v0, p2, 0x1

    .line 153
    .local v0, "end":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 154
    iget-object v2, p0, Lgnu/lists/F64Vector;->data:[D

    aget-wide v2, v2, v1

    invoke-interface {p3, v2, v3}, Lgnu/lists/Consumer;->writeDouble(D)V

    .line 153
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public final doubleAt(I)D
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 72
    iget v0, p0, Lgnu/lists/F64Vector;->size:I

    if-lt p1, v0, :cond_0

    .line 73
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 74
    :cond_0
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    aget-wide v0, v0, p1

    return-wide v0
.end method

.method public final doubleAtBuffer(I)D
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 79
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    aget-wide v0, v0, p1

    return-wide v0
.end method

.method public final get(I)Ljava/lang/Object;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 84
    iget v0, p0, Lgnu/lists/F64Vector;->size:I

    if-le p1, v0, :cond_0

    .line 85
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 86
    :cond_0
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    aget-wide v0, v0, p1

    invoke-static {v0, v1}, Lgnu/lists/Convert;->toObject(D)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected getBuffer()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    return-object v0
.end method

.method public final getBuffer(I)Ljava/lang/Object;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 91
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    aget-wide v0, v0, p1

    invoke-static {v0, v1}, Lgnu/lists/Convert;->toObject(D)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getBufferLength()I
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    array-length v0, v0

    return v0
.end method

.method public getElementKind()I
    .locals 1

    .prologue
    .line 133
    const/16 v0, 0x1a

    return v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 136
    const-string v0, "f64"

    return-object v0
.end method

.method public final intAtBuffer(I)I
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 96
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    aget-wide v0, v0, p1

    double-to-int v0, v0

    return v0
.end method

.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 5
    .param p1, "in"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 197
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v2

    .line 198
    .local v2, "size":I
    new-array v0, v2, [D

    .line 199
    .local v0, "data":[D
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 200
    invoke-interface {p1}, Ljava/io/ObjectInput;->readDouble()D

    move-result-wide v3

    aput-wide v3, v0, v1

    .line 199
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 201
    :cond_0
    iput-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    .line 202
    iput v2, p0, Lgnu/lists/F64Vector;->size:I

    .line 203
    return-void
.end method

.method public final setBuffer(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "index"    # I
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 113
    iget-object v1, p0, Lgnu/lists/F64Vector;->data:[D

    aget-wide v1, v1, p1

    invoke-static {v1, v2}, Lgnu/lists/Convert;->toObject(D)Ljava/lang/Object;

    move-result-object v0

    .line 114
    .local v0, "old":Ljava/lang/Object;
    iget-object v1, p0, Lgnu/lists/F64Vector;->data:[D

    invoke-static {p2}, Lgnu/lists/Convert;->toDouble(Ljava/lang/Object;)D

    move-result-wide v2

    aput-wide v2, v1, p1

    .line 115
    return-object v0
.end method

.method public setBufferLength(I)V
    .locals 4
    .param p1, "length"    # I

    .prologue
    const/4 v3, 0x0

    .line 58
    iget-object v2, p0, Lgnu/lists/F64Vector;->data:[D

    array-length v0, v2

    .line 59
    .local v0, "oldLength":I
    if-eq v0, p1, :cond_0

    .line 61
    new-array v1, p1, [D

    .line 62
    .local v1, "tmp":[D
    iget-object v2, p0, Lgnu/lists/F64Vector;->data:[D

    if-ge v0, p1, :cond_1

    .end local v0    # "oldLength":I
    :goto_0
    invoke-static {v2, v3, v1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 64
    iput-object v1, p0, Lgnu/lists/F64Vector;->data:[D

    .line 66
    .end local v1    # "tmp":[D
    :cond_0
    return-void

    .restart local v0    # "oldLength":I
    .restart local v1    # "tmp":[D
    :cond_1
    move v0, p1

    .line 62
    goto :goto_0
.end method

.method public final setDoubleAt(ID)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # D

    .prologue
    .line 101
    iget v0, p0, Lgnu/lists/F64Vector;->size:I

    if-le p1, v0, :cond_0

    .line 102
    new-instance v0, Ljava/lang/IndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/IndexOutOfBoundsException;-><init>()V

    throw v0

    .line 103
    :cond_0
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    aput-wide p2, v0, p1

    .line 104
    return-void
.end method

.method public final setDoubleAtBuffer(ID)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # D

    .prologue
    .line 108
    iget-object v0, p0, Lgnu/lists/F64Vector;->data:[D

    aput-wide p2, v0, p1

    .line 109
    return-void
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 4
    .param p1, "out"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 188
    iget v1, p0, Lgnu/lists/F64Vector;->size:I

    .line 189
    .local v1, "size":I
    invoke-interface {p1, v1}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 190
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 191
    iget-object v2, p0, Lgnu/lists/F64Vector;->data:[D

    aget-wide v2, v2, v0

    invoke-interface {p1, v2, v3}, Ljava/io/ObjectOutput;->writeDouble(D)V

    .line 190
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 192
    :cond_0
    return-void
.end method
