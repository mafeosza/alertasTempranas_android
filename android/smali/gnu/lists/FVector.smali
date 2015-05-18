.class public Lgnu/lists/FVector;
.super Lgnu/lists/SimpleVector;
.source "FVector.java"

# interfaces
.implements Lgnu/lists/Consumable;
.implements Ljava/io/Externalizable;
.implements Ljava/lang/Comparable;


# static fields
.field protected static empty:[Ljava/lang/Object;


# instance fields
.field public data:[Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    sput-object v0, Lgnu/lists/FVector;->empty:[Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 21
    sget-object v0, Lgnu/lists/FVector;->empty:[Ljava/lang/Object;

    iput-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 22
    return-void
.end method

.method public constructor <init>(I)V
    .locals 1
    .param p1, "num"    # I

    .prologue
    .line 25
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 26
    iput p1, p0, Lgnu/lists/FVector;->size:I

    .line 27
    new-array v0, p1, [Ljava/lang/Object;

    iput-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 28
    return-void
.end method

.method public constructor <init>(ILjava/lang/Object;)V
    .locals 2
    .param p1, "num"    # I
    .param p2, "o"    # Ljava/lang/Object;

    .prologue
    .line 31
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 32
    new-array v0, p1, [Ljava/lang/Object;

    .line 33
    .local v0, "data":[Ljava/lang/Object;
    if-eqz p2, :cond_0

    .line 35
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, p1, :cond_0

    .line 36
    aput-object p2, v0, v1

    .line 35
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 38
    .end local v1    # "i":I
    :cond_0
    iput-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 39
    iput p1, p0, Lgnu/lists/FVector;->size:I

    .line 40
    return-void
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 1
    .param p1, "seq"    # Ljava/util/List;

    .prologue
    .line 51
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 52
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 53
    invoke-virtual {p0, p1}, Lgnu/lists/FVector;->addAll(Ljava/util/Collection;)Z

    .line 54
    return-void
.end method

.method public constructor <init>([Ljava/lang/Object;)V
    .locals 1
    .param p1, "data"    # [Ljava/lang/Object;

    .prologue
    .line 44
    invoke-direct {p0}, Lgnu/lists/SimpleVector;-><init>()V

    .line 45
    array-length v0, p1

    iput v0, p0, Lgnu/lists/FVector;->size:I

    .line 46
    iput-object p1, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 47
    return-void
.end method

.method public static varargs make([Ljava/lang/Object;)Lgnu/lists/FVector;
    .locals 1
    .param p0, "data"    # [Ljava/lang/Object;

    .prologue
    .line 66
    new-instance v0, Lgnu/lists/FVector;

    invoke-direct {v0, p0}, Lgnu/lists/FVector;-><init>([Ljava/lang/Object;)V

    return-object v0
.end method


# virtual methods
.method protected clearBuffer(II)V
    .locals 3
    .param p1, "start"    # I
    .param p2, "count"    # I

    .prologue
    .line 115
    iget-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .local v0, "d":[Ljava/lang/Object;
    move v1, p1

    .line 116
    .end local p1    # "start":I
    .local v1, "start":I
    :goto_0
    add-int/lit8 p2, p2, -0x1

    if-ltz p2, :cond_0

    .line 117
    add-int/lit8 p1, v1, 0x1

    .end local v1    # "start":I
    .restart local p1    # "start":I
    const/4 v2, 0x0

    aput-object v2, v0, v1

    move v1, p1

    .end local p1    # "start":I
    .restart local v1    # "start":I
    goto :goto_0

    .line 118
    :cond_0
    return-void
.end method

.method public compareTo(Ljava/lang/Object;)I
    .locals 10
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 141
    move-object v9, p1

    check-cast v9, Lgnu/lists/FVector;

    .line 142
    .local v9, "vec2":Lgnu/lists/FVector;
    iget-object v1, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 143
    .local v1, "d1":[Ljava/lang/Object;
    iget-object v2, v9, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 144
    .local v2, "d2":[Ljava/lang/Object;
    iget v5, p0, Lgnu/lists/FVector;->size:I

    .line 145
    .local v5, "n1":I
    iget v6, v9, Lgnu/lists/FVector;->size:I

    .line 146
    .local v6, "n2":I
    if-le v5, v6, :cond_0

    move v4, v6

    .line 147
    .local v4, "n":I
    :goto_0
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    if-ge v3, v4, :cond_2

    .line 149
    aget-object v7, v1, v3

    check-cast v7, Ljava/lang/Comparable;

    .line 150
    .local v7, "v1":Ljava/lang/Comparable;
    aget-object v8, v2, v3

    check-cast v8, Ljava/lang/Comparable;

    .line 151
    .local v8, "v2":Ljava/lang/Comparable;
    invoke-interface {v7, v8}, Ljava/lang/Comparable;->compareTo(Ljava/lang/Object;)I

    move-result v0

    .line 152
    .local v0, "d":I
    if-eqz v0, :cond_1

    .line 155
    .end local v0    # "d":I
    .end local v7    # "v1":Ljava/lang/Comparable;
    .end local v8    # "v2":Ljava/lang/Comparable;
    :goto_2
    return v0

    .end local v3    # "i":I
    .end local v4    # "n":I
    :cond_0
    move v4, v5

    .line 146
    goto :goto_0

    .line 147
    .restart local v0    # "d":I
    .restart local v3    # "i":I
    .restart local v4    # "n":I
    .restart local v7    # "v1":Ljava/lang/Comparable;
    .restart local v8    # "v2":Ljava/lang/Comparable;
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 155
    .end local v0    # "d":I
    .end local v7    # "v1":Ljava/lang/Comparable;
    .end local v8    # "v2":Ljava/lang/Comparable;
    :cond_2
    sub-int v0, v5, v6

    goto :goto_2
.end method

.method public consume(Lgnu/lists/Consumer;)V
    .locals 3
    .param p1, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 199
    const-string v2, "#vector"

    invoke-interface {p1, v2}, Lgnu/lists/Consumer;->startElement(Ljava/lang/Object;)V

    .line 200
    iget v1, p0, Lgnu/lists/FVector;->size:I

    .line 201
    .local v1, "len":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 202
    iget-object v2, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    aget-object v2, v2, v0

    invoke-interface {p1, v2}, Lgnu/lists/Consumer;->writeObject(Ljava/lang/Object;)V

    .line 201
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 203
    :cond_0
    invoke-interface {p1}, Lgnu/lists/Consumer;->endElement()V

    .line 204
    return-void
.end method

.method public consumeNext(ILgnu/lists/Consumer;)Z
    .locals 2
    .param p1, "ipos"    # I
    .param p2, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 178
    ushr-int/lit8 v0, p1, 0x1

    .line 179
    .local v0, "index":I
    iget v1, p0, Lgnu/lists/FVector;->size:I

    if-lt v0, v1, :cond_0

    .line 180
    const/4 v1, 0x0

    .line 182
    :goto_0
    return v1

    .line 181
    :cond_0
    iget-object v1, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    aget-object v1, v1, v0

    invoke-interface {p2, v1}, Lgnu/lists/Consumer;->writeObject(Ljava/lang/Object;)V

    .line 182
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public consumePosRange(IILgnu/lists/Consumer;)V
    .locals 3
    .param p1, "iposStart"    # I
    .param p2, "iposEnd"    # I
    .param p3, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 187
    invoke-interface {p3}, Lgnu/lists/Consumer;->ignoring()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 195
    :cond_0
    return-void

    .line 189
    :cond_1
    ushr-int/lit8 v1, p1, 0x1

    .line 190
    .local v1, "i":I
    ushr-int/lit8 v0, p2, 0x1

    .line 191
    .local v0, "end":I
    iget v2, p0, Lgnu/lists/FVector;->size:I

    if-le v0, v2, :cond_2

    .line 192
    iget v0, p0, Lgnu/lists/FVector;->size:I

    .line 193
    :cond_2
    :goto_0
    if-ge v1, v0, :cond_0

    .line 194
    iget-object v2, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    aget-object v2, v2, v1

    invoke-interface {p3, v2}, Lgnu/lists/Consumer;->writeObject(Ljava/lang/Object;)V

    .line 193
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 8
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x0

    .line 122
    if-eqz p1, :cond_0

    instance-of v6, p1, Lgnu/lists/FVector;

    if-nez v6, :cond_1

    .line 135
    :cond_0
    :goto_0
    return v5

    :cond_1
    move-object v3, p1

    .line 124
    check-cast v3, Lgnu/lists/FVector;

    .line 125
    .local v3, "obj_vec":Lgnu/lists/FVector;
    iget v1, p0, Lgnu/lists/FVector;->size:I

    .line 126
    .local v1, "n":I
    iget-object v6, v3, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    if-eqz v6, :cond_0

    iget v6, v3, Lgnu/lists/FVector;->size:I

    if-ne v6, v1, :cond_0

    .line 128
    iget-object v4, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 129
    .local v4, "this_data":[Ljava/lang/Object;
    iget-object v2, v3, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 130
    .local v2, "obj_data":[Ljava/lang/Object;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    if-ge v0, v1, :cond_2

    .line 132
    aget-object v6, v4, v0

    aget-object v7, v2, v0

    invoke-virtual {v6, v7}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 130
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 135
    :cond_2
    const/4 v5, 0x1

    goto :goto_0
.end method

.method public final get(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 101
    iget v0, p0, Lgnu/lists/FVector;->size:I

    if-lt p1, v0, :cond_0

    .line 102
    new-instance v0, Ljava/lang/ArrayIndexOutOfBoundsException;

    invoke-direct {v0}, Ljava/lang/ArrayIndexOutOfBoundsException;-><init>()V

    throw v0

    .line 103
    :cond_0
    iget-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method

.method protected getBuffer()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    return-object v0
.end method

.method public final getBuffer(I)Ljava/lang/Object;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 96
    iget-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getBufferLength()I
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    array-length v0, v0

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
    .line 223
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v2

    .line 224
    .local v2, "n":I
    new-array v0, v2, [Ljava/lang/Object;

    .line 225
    .local v0, "data":[Ljava/lang/Object;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 226
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v3

    aput-object v3, v0, v1

    .line 225
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 227
    :cond_0
    iput v2, p0, Lgnu/lists/FVector;->size:I

    .line 228
    iput-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 229
    return-void
.end method

.method public final setAll(Ljava/lang/Object;)V
    .locals 2
    .param p1, "new_value"    # Ljava/lang/Object;

    .prologue
    .line 171
    iget-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 172
    .local v0, "d":[Ljava/lang/Object;
    iget v1, p0, Lgnu/lists/FVector;->size:I

    .local v1, "i":I
    :goto_0
    add-int/lit8 v1, v1, -0x1

    if-ltz v1, :cond_0

    .line 173
    aput-object p1, v0, v1

    goto :goto_0

    .line 174
    :cond_0
    return-void
.end method

.method public final setBuffer(ILjava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "index"    # I
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 108
    iget-object v1, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    aget-object v0, v1, p1

    .line 109
    .local v0, "old":Ljava/lang/Object;
    iget-object v1, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    aput-object p2, v1, p1

    .line 110
    return-object v0
.end method

.method public setBufferLength(I)V
    .locals 4
    .param p1, "length"    # I

    .prologue
    const/4 v3, 0x0

    .line 77
    iget-object v2, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    array-length v0, v2

    .line 78
    .local v0, "oldLength":I
    if-eq v0, p1, :cond_0

    .line 80
    new-array v1, p1, [Ljava/lang/Object;

    .line 81
    .local v1, "tmp":[Ljava/lang/Object;
    iget-object v2, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    if-ge v0, p1, :cond_1

    .end local v0    # "oldLength":I
    :goto_0
    invoke-static {v2, v3, v1, v3, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 83
    iput-object v1, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 85
    .end local v1    # "tmp":[Ljava/lang/Object;
    :cond_0
    return-void

    .restart local v0    # "oldLength":I
    .restart local v1    # "tmp":[Ljava/lang/Object;
    :cond_1
    move v0, p1

    .line 81
    goto :goto_0
.end method

.method public shift(III)V
    .locals 2
    .param p1, "srcStart"    # I
    .param p2, "dstStart"    # I
    .param p3, "count"    # I

    .prologue
    .line 91
    iget-object v0, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    iget-object v1, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    invoke-static {v0, p1, v1, p2, p3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 92
    return-void
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
    .line 214
    iget v1, p0, Lgnu/lists/FVector;->size:I

    .line 215
    .local v1, "n":I
    invoke-interface {p1, v1}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 216
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 217
    iget-object v2, p0, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    aget-object v2, v2, v0

    invoke-interface {p1, v2}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 216
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 218
    :cond_0
    return-void
.end method
