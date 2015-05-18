.class public Lgnu/math/BitOps;
.super Ljava/lang/Object;
.source "BitOps.java"


# static fields
.field static final bit4_count:[B


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 489
    const/16 v0, 0x10

    new-array v0, v0, [B

    fill-array-data v0, :array_0

    sput-object v0, Lgnu/math/BitOps;->bit4_count:[B

    return-void

    :array_0
    .array-data 1
        0x0t
        0x1t
        0x1t
        0x2t
        0x1t
        0x2t
        0x2t
        0x3t
        0x1t
        0x2t
        0x2t
        0x3t
        0x2t
        0x3t
        0x3t
        0x4t
    .end array-data
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static and(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    .locals 4
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # I

    .prologue
    const/4 v3, 0x0

    .line 128
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_0

    .line 129
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    and-int/2addr v2, p1

    invoke-static {v2}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v2

    .line 137
    :goto_0
    return-object v2

    .line 130
    :cond_0
    if-ltz p1, :cond_1

    .line 131
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v2, v2, v3

    and-int/2addr v2, p1

    invoke-static {v2}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v2

    goto :goto_0

    .line 132
    :cond_1
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    .line 133
    .local v0, "len":I
    new-array v1, v0, [I

    .line 134
    .local v1, "words":[I
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v2, v2, v3

    and-int/2addr v2, p1

    aput v2, v1, v3

    .line 135
    :goto_1
    add-int/lit8 v0, v0, -0x1

    if-lez v0, :cond_2

    .line 136
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v2, v2, v0

    aput v2, v1, v0

    goto :goto_1

    .line 137
    :cond_2
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v1, v2}, Lgnu/math/IntNum;->make([II)Lgnu/math/IntNum;

    move-result-object v2

    goto :goto_0
.end method

.method public static and(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 6
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 143
    iget-object v4, p1, Lgnu/math/IntNum;->words:[I

    if-nez v4, :cond_0

    .line 144
    iget v4, p1, Lgnu/math/IntNum;->ival:I

    invoke-static {p0, v4}, Lgnu/math/BitOps;->and(Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v4

    .line 158
    :goto_0
    return-object v4

    .line 145
    :cond_0
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    if-nez v4, :cond_1

    .line 146
    iget v4, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {p1, v4}, Lgnu/math/BitOps;->and(Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v4

    goto :goto_0

    .line 147
    :cond_1
    iget v4, p0, Lgnu/math/IntNum;->ival:I

    iget v5, p1, Lgnu/math/IntNum;->ival:I

    if-ge v4, v5, :cond_2

    .line 149
    move-object v2, p0

    .local v2, "temp":Lgnu/math/IntNum;
    move-object p0, p1

    move-object p1, v2

    .line 152
    .end local v2    # "temp":Lgnu/math/IntNum;
    :cond_2
    invoke-virtual {p1}, Lgnu/math/IntNum;->isNegative()Z

    move-result v4

    if-eqz v4, :cond_3

    iget v1, p0, Lgnu/math/IntNum;->ival:I

    .line 153
    .local v1, "len":I
    :goto_1
    new-array v3, v1, [I

    .line 154
    .local v3, "words":[I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    iget v4, p1, Lgnu/math/IntNum;->ival:I

    if-ge v0, v4, :cond_4

    .line 155
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    aget v4, v4, v0

    iget-object v5, p1, Lgnu/math/IntNum;->words:[I

    aget v5, v5, v0

    and-int/2addr v4, v5

    aput v4, v3, v0

    .line 154
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 152
    .end local v0    # "i":I
    .end local v1    # "len":I
    .end local v3    # "words":[I
    :cond_3
    iget v1, p1, Lgnu/math/IntNum;->ival:I

    goto :goto_1

    .line 156
    .restart local v0    # "i":I
    .restart local v1    # "len":I
    .restart local v3    # "words":[I
    :cond_4
    :goto_3
    if-ge v0, v1, :cond_5

    .line 157
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    aget v4, v4, v0

    aput v4, v3, v0

    .line 156
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 158
    :cond_5
    invoke-static {v3, v1}, Lgnu/math/IntNum;->make([II)Lgnu/math/IntNum;

    move-result-object v4

    goto :goto_0
.end method

.method public static bitCount(I)I
    .locals 3
    .param p0, "i"    # I

    .prologue
    .line 494
    const/4 v0, 0x0

    .line 495
    .local v0, "count":I
    :goto_0
    if-eqz p0, :cond_0

    .line 497
    sget-object v1, Lgnu/math/BitOps;->bit4_count:[B

    and-int/lit8 v2, p0, 0xf

    aget-byte v1, v1, v2

    add-int/2addr v0, v1

    .line 498
    ushr-int/lit8 p0, p0, 0x4

    goto :goto_0

    .line 500
    :cond_0
    return v0
.end method

.method public static bitCount(Lgnu/math/IntNum;)I
    .locals 4
    .param p0, "x"    # Lgnu/math/IntNum;

    .prologue
    .line 516
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    .line 517
    .local v2, "x_words":[I
    if-nez v2, :cond_1

    .line 519
    const/4 v1, 0x1

    .line 520
    .local v1, "x_len":I
    iget v3, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v3}, Lgnu/math/BitOps;->bitCount(I)I

    move-result v0

    .line 527
    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v3

    if-eqz v3, :cond_0

    mul-int/lit8 v3, v1, 0x20

    sub-int v0, v3, v0

    .end local v0    # "i":I
    :cond_0
    return v0

    .line 524
    .end local v1    # "x_len":I
    :cond_1
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    .line 525
    .restart local v1    # "x_len":I
    invoke-static {v2, v1}, Lgnu/math/BitOps;->bitCount([II)I

    move-result v0

    .restart local v0    # "i":I
    goto :goto_0
.end method

.method public static bitCount([II)I
    .locals 2
    .param p0, "x"    # [I
    .param p1, "len"    # I

    .prologue
    .line 505
    const/4 v0, 0x0

    .line 506
    .local v0, "count":I
    :goto_0
    add-int/lit8 p1, p1, -0x1

    if-ltz p1, :cond_0

    .line 507
    aget v1, p0, p1

    invoke-static {v1}, Lgnu/math/BitOps;->bitCount(I)I

    move-result v1

    add-int/2addr v0, v1

    goto :goto_0

    .line 508
    :cond_0
    return v0
.end method

.method public static bitOp(ILgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "op"    # I
    .param p1, "x"    # Lgnu/math/IntNum;
    .param p2, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 192
    sparse-switch p0, :sswitch_data_0

    .line 200
    new-instance v0, Lgnu/math/IntNum;

    invoke-direct {v0}, Lgnu/math/IntNum;-><init>()V

    .line 201
    .local v0, "result":Lgnu/math/IntNum;
    invoke-static {v0, p0, p1, p2}, Lgnu/math/BitOps;->setBitOp(Lgnu/math/IntNum;ILgnu/math/IntNum;Lgnu/math/IntNum;)V

    .line 202
    invoke-virtual {v0}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object p1

    .end local v0    # "result":Lgnu/math/IntNum;
    .end local p1    # "x":Lgnu/math/IntNum;
    :goto_0
    :sswitch_0
    return-object p1

    .line 194
    .restart local p1    # "x":Lgnu/math/IntNum;
    :sswitch_1
    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object p1

    goto :goto_0

    .line 195
    :sswitch_2
    invoke-static {p1, p2}, Lgnu/math/BitOps;->and(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object p1

    goto :goto_0

    :sswitch_3
    move-object p1, p2

    .line 197
    goto :goto_0

    .line 198
    :sswitch_4
    invoke-static {}, Lgnu/math/IntNum;->minusOne()Lgnu/math/IntNum;

    move-result-object p1

    goto :goto_0

    .line 192
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0x1 -> :sswitch_2
        0x3 -> :sswitch_0
        0x5 -> :sswitch_3
        0xf -> :sswitch_4
    .end sparse-switch
.end method

.method public static bitValue(Lgnu/math/IntNum;I)Z
    .locals 6
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "bitno"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 19
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    .line 20
    .local v0, "i":I
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    if-nez v4, :cond_3

    .line 22
    const/16 v4, 0x20

    if-lt p1, v4, :cond_2

    if-gez v0, :cond_1

    .line 27
    :cond_0
    :goto_0
    return v2

    :cond_1
    move v2, v3

    .line 22
    goto :goto_0

    :cond_2
    shr-int v4, v0, p1

    and-int/lit8 v4, v4, 0x1

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    .line 26
    :cond_3
    shr-int/lit8 v1, p1, 0x5

    .line 27
    .local v1, "wordno":I
    if-lt v1, v0, :cond_4

    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    add-int/lit8 v5, v0, -0x1

    aget v4, v4, v5

    if-ltz v4, :cond_0

    move v2, v3

    goto :goto_0

    :cond_4
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    aget v4, v4, v1

    shr-int/2addr v4, p1

    and-int/lit8 v4, v4, 0x1

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0
.end method

.method static dataBufferFor(Lgnu/math/IntNum;I)[I
    .locals 6
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "bitno"    # I

    .prologue
    const/4 v5, -0x1

    .line 37
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    .line 39
    .local v1, "i":I
    add-int/lit8 v4, p1, 0x1

    shr-int/lit8 v3, v4, 0x5

    .line 40
    .local v3, "nwords":I
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    if-nez v4, :cond_1

    .line 42
    if-nez v3, :cond_0

    .line 43
    const/4 v3, 0x1

    .line 44
    :cond_0
    new-array v0, v3, [I

    .line 45
    .local v0, "data":[I
    const/4 v4, 0x0

    aput v1, v0, v4

    .line 46
    if-gez v1, :cond_4

    .line 48
    const/4 v2, 0x1

    .local v2, "j":I
    :goto_0
    if-ge v2, v3, :cond_4

    .line 49
    aput v5, v0, v2

    .line 48
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 54
    .end local v0    # "data":[I
    .end local v2    # "j":I
    :cond_1
    add-int/lit8 v4, p1, 0x1

    shr-int/lit8 v3, v4, 0x5

    .line 55
    if-le v3, v1, :cond_2

    move v4, v3

    :goto_1
    new-array v0, v4, [I

    .line 56
    .restart local v0    # "data":[I
    move v2, v1

    .restart local v2    # "j":I
    :goto_2
    add-int/lit8 v2, v2, -0x1

    if-ltz v2, :cond_3

    .line 57
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    aget v4, v4, v2

    aput v4, v0, v2

    goto :goto_2

    .end local v0    # "data":[I
    .end local v2    # "j":I
    :cond_2
    move v4, v1

    .line 55
    goto :goto_1

    .line 58
    .restart local v0    # "data":[I
    .restart local v2    # "j":I
    :cond_3
    add-int/lit8 v4, v1, -0x1

    aget v4, v0, v4

    if-gez v4, :cond_4

    .line 60
    move v2, v1

    :goto_3
    if-ge v2, v3, :cond_4

    .line 61
    aput v5, v0, v2

    .line 60
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 64
    .end local v2    # "j":I
    :cond_4
    return-object v0
.end method

.method public static extract(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    .locals 13
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "startBit"    # I
    .param p2, "endBit"    # I

    .prologue
    .line 396
    const/16 v9, 0x20

    if-ge p2, v9, :cond_2

    .line 398
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    if-nez v9, :cond_1

    iget v7, p0, Lgnu/math/IntNum;->ival:I

    .line 399
    .local v7, "word0":I
    :goto_0
    const/4 v9, -0x1

    shl-int/2addr v9, p2

    xor-int/lit8 v9, v9, -0x1

    and-int/2addr v9, v7

    shr-int/2addr v9, p1

    invoke-static {v9}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object p0

    .line 445
    .end local v7    # "word0":I
    .end local p0    # "x":Lgnu/math/IntNum;
    :cond_0
    :goto_1
    return-object p0

    .line 398
    .restart local p0    # "x":Lgnu/math/IntNum;
    :cond_1
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    const/4 v10, 0x0

    aget v7, v9, v10

    goto :goto_0

    .line 402
    :cond_2
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    if-nez v9, :cond_6

    .line 404
    iget v9, p0, Lgnu/math/IntNum;->ival:I

    if-ltz v9, :cond_4

    .line 405
    const/16 v9, 0x1f

    if-lt p1, v9, :cond_3

    const/4 v9, 0x0

    :goto_2
    invoke-static {v9}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_1

    :cond_3
    iget v9, p0, Lgnu/math/IntNum;->ival:I

    shr-int/2addr v9, p1

    goto :goto_2

    .line 406
    :cond_4
    const/4 v8, 0x1

    .line 410
    .local v8, "x_len":I
    :goto_3
    invoke-virtual {p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v5

    .line 411
    .local v5, "neg":Z
    mul-int/lit8 v9, v8, 0x20

    if-le p2, v9, :cond_7

    .line 413
    mul-int/lit8 p2, v8, 0x20

    .line 414
    if-nez v5, :cond_5

    if-eqz p1, :cond_0

    .line 419
    :cond_5
    :goto_4
    sub-int v4, p2, p1

    .line 420
    .local v4, "length":I
    const/16 v9, 0x40

    if-ge v4, v9, :cond_a

    .line 423
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    if-nez v9, :cond_9

    .line 424
    iget v10, p0, Lgnu/math/IntNum;->ival:I

    const/16 v9, 0x20

    if-lt p1, v9, :cond_8

    const/16 v9, 0x1f

    :goto_5
    shr-int v9, v10, v9

    int-to-long v2, v9

    .line 427
    .local v2, "l":J
    :goto_6
    const-wide/16 v9, -0x1

    shl-long/2addr v9, v4

    const-wide/16 v11, -0x1

    xor-long/2addr v9, v11

    and-long/2addr v9, v2

    invoke-static {v9, v10}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_1

    .line 409
    .end local v2    # "l":J
    .end local v4    # "length":I
    .end local v5    # "neg":Z
    .end local v8    # "x_len":I
    :cond_6
    iget v8, p0, Lgnu/math/IntNum;->ival:I

    .restart local v8    # "x_len":I
    goto :goto_3

    .line 418
    .restart local v5    # "neg":Z
    :cond_7
    add-int/lit8 v9, p2, 0x1f

    shr-int/lit8 v8, v9, 0x5

    goto :goto_4

    .restart local v4    # "length":I
    :cond_8
    move v9, p1

    .line 424
    goto :goto_5

    .line 426
    :cond_9
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    invoke-static {v9, v8, p1}, Lgnu/math/MPN;->rshift_long([III)J

    move-result-wide v2

    .restart local v2    # "l":J
    goto :goto_6

    .line 429
    .end local v2    # "l":J
    :cond_a
    shr-int/lit8 v6, p1, 0x5

    .line 433
    .local v6, "startWord":I
    shr-int/lit8 v9, p2, 0x5

    add-int/lit8 v9, v9, 0x1

    sub-int v1, v9, v6

    .line 434
    .local v1, "buf_len":I
    new-array v0, v1, [I

    .line 435
    .local v0, "buf":[I
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    if-nez v9, :cond_c

    .line 436
    const/4 v10, 0x0

    const/16 v9, 0x20

    if-lt p1, v9, :cond_b

    const/4 v9, -0x1

    :goto_7
    aput v9, v0, v10

    .line 443
    :goto_8
    shr-int/lit8 v8, v4, 0x5

    .line 444
    aget v9, v0, v8

    const/4 v10, -0x1

    shl-int/2addr v10, v4

    xor-int/lit8 v10, v10, -0x1

    and-int/2addr v9, v10

    aput v9, v0, v8

    .line 445
    add-int/lit8 v9, v8, 0x1

    invoke-static {v0, v9}, Lgnu/math/IntNum;->make([II)Lgnu/math/IntNum;

    move-result-object p0

    goto/16 :goto_1

    .line 436
    :cond_b
    iget v9, p0, Lgnu/math/IntNum;->ival:I

    shr-int/2addr v9, p1

    goto :goto_7

    .line 439
    :cond_c
    sub-int/2addr v8, v6

    .line 440
    and-int/lit8 p1, p1, 0x1f

    .line 441
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    invoke-static {v0, v9, v6, v8, p1}, Lgnu/math/MPN;->rshift0([I[IIII)V

    goto :goto_8
.end method

.method public static ior(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 164
    const/4 v0, 0x7

    invoke-static {v0, p0, p1}, Lgnu/math/BitOps;->bitOp(ILgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static lowestBitSet(I)I
    .locals 2
    .param p0, "i"    # I

    .prologue
    .line 450
    if-nez p0, :cond_1

    .line 451
    const/4 v0, -0x1

    .line 465
    :cond_0
    :goto_0
    return v0

    .line 452
    :cond_1
    const/4 v0, 0x0

    .line 453
    .local v0, "index":I
    :goto_1
    and-int/lit16 v1, p0, 0xff

    if-nez v1, :cond_2

    .line 455
    ushr-int/lit8 p0, p0, 0x8

    .line 456
    add-int/lit8 v0, v0, 0x8

    goto :goto_1

    .line 458
    :cond_2
    :goto_2
    and-int/lit8 v1, p0, 0x3

    if-nez v1, :cond_3

    .line 460
    ushr-int/lit8 p0, p0, 0x2

    .line 461
    add-int/lit8 v0, v0, 0x2

    goto :goto_2

    .line 463
    :cond_3
    and-int/lit8 v1, p0, 0x1

    if-nez v1, :cond_0

    .line 464
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public static lowestBitSet(Lgnu/math/IntNum;)I
    .locals 5
    .param p0, "x"    # Lgnu/math/IntNum;

    .prologue
    .line 470
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    .line 471
    .local v3, "x_words":[I
    if-nez v3, :cond_0

    .line 473
    iget v4, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v4}, Lgnu/math/BitOps;->lowestBitSet(I)I

    move-result v4

    .line 484
    :goto_0
    return v4

    .line 477
    :cond_0
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    .line 478
    .local v2, "x_len":I
    const/4 v1, 0x0

    .local v1, "i":I
    :cond_1
    if-ge v1, v2, :cond_2

    .line 480
    aget v4, v3, v1

    invoke-static {v4}, Lgnu/math/BitOps;->lowestBitSet(I)I

    move-result v0

    .line 481
    .local v0, "b":I
    if-ltz v0, :cond_1

    .line 482
    add-int/lit8 v4, v0, 0x0

    goto :goto_0

    .line 484
    .end local v0    # "b":I
    :cond_2
    const/4 v4, -0x1

    goto :goto_0
.end method

.method public static not(Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 2
    .param p0, "x"    # Lgnu/math/IntNum;

    .prologue
    .line 176
    const/16 v0, 0xc

    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v1

    invoke-static {v0, p0, v1}, Lgnu/math/BitOps;->bitOp(ILgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static reverseBits(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    .locals 23
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "start"    # I
    .param p2, "end"    # I

    .prologue
    .line 532
    move-object/from16 v0, p0

    iget v9, v0, Lgnu/math/IntNum;->ival:I

    .line 533
    .local v9, "ival":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/math/IntNum;->words:[I

    move-object/from16 v16, v0

    .line 534
    .local v16, "xwords":[I
    if-nez v16, :cond_1

    .line 536
    const/16 v17, 0x3f

    move/from16 v0, p2

    move/from16 v1, v17

    if-ge v0, v1, :cond_1

    .line 538
    int-to-long v12, v9

    .line 539
    .local v12, "w":J
    move/from16 v7, p1

    .line 540
    .local v7, "i":I
    add-int/lit8 v10, p2, -0x1

    .line 541
    .local v10, "j":I
    :goto_0
    if-ge v7, v10, :cond_0

    .line 543
    shr-long v17, v12, v7

    const-wide/16 v19, 0x1

    and-long v2, v17, v19

    .line 544
    .local v2, "biti":J
    shr-long v17, v12, v10

    const-wide/16 v19, 0x1

    and-long v4, v17, v19

    .line 545
    .local v4, "bitj":J
    const-wide/16 v17, 0x1

    shl-long v17, v17, v7

    const-wide/16 v19, 0x1

    shl-long v19, v19, v10

    or-long v17, v17, v19

    const-wide/16 v19, -0x1

    xor-long v17, v17, v19

    and-long v12, v12, v17

    .line 546
    shl-long v17, v2, v10

    or-long v17, v17, v12

    shl-long v19, v4, v7

    or-long v12, v17, v19

    .line 547
    add-int/lit8 v7, v7, 0x1

    .line 548
    add-int/lit8 v10, v10, -0x1

    .line 549
    goto :goto_0

    .line 550
    .end local v2    # "biti":J
    .end local v4    # "bitj":J
    :cond_0
    invoke-static {v12, v13}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v17

    .line 582
    .end local v12    # "w":J
    :goto_1
    return-object v17

    .line 553
    .end local v7    # "i":I
    .end local v10    # "j":I
    :cond_1
    add-int/lit8 v17, p2, -0x1

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-static {v0, v1}, Lgnu/math/BitOps;->dataBufferFor(Lgnu/math/IntNum;I)[I

    move-result-object v6

    .line 554
    .local v6, "data":[I
    move/from16 v7, p1

    .line 555
    .restart local v7    # "i":I
    add-int/lit8 v10, p2, -0x1

    .line 556
    .restart local v10    # "j":I
    :goto_2
    if-ge v7, v10, :cond_3

    .line 558
    shr-int/lit8 v8, v7, 0x5

    .line 559
    .local v8, "ii":I
    shr-int/lit8 v11, v10, 0x5

    .line 560
    .local v11, "jj":I
    aget v14, v6, v8

    .line 561
    .local v14, "wi":I
    shr-int v17, v14, v7

    and-int/lit8 v2, v17, 0x1

    .line 562
    .local v2, "biti":I
    if-ne v8, v11, :cond_2

    .line 564
    shr-int v17, v14, v10

    and-int/lit8 v4, v17, 0x1

    .line 565
    .local v4, "bitj":I
    int-to-long v0, v14

    move-wide/from16 v17, v0

    const-wide/16 v19, 0x1

    shl-long v19, v19, v7

    const-wide/16 v21, 0x1

    shl-long v21, v21, v10

    or-long v19, v19, v21

    const-wide/16 v21, -0x1

    xor-long v19, v19, v21

    and-long v17, v17, v19

    move-wide/from16 v0, v17

    long-to-int v14, v0

    .line 566
    shl-int v17, v2, v10

    or-int v17, v17, v14

    shl-int v18, v4, v7

    or-int v14, v17, v18

    .line 578
    :goto_3
    aput v14, v6, v8

    .line 579
    add-int/lit8 v7, v7, 0x1

    .line 580
    add-int/lit8 v10, v10, -0x1

    .line 581
    goto :goto_2

    .line 570
    .end local v4    # "bitj":I
    :cond_2
    aget v15, v6, v11

    .line 571
    .local v15, "wj":I
    and-int/lit8 v17, v10, 0x1f

    shr-int v17, v15, v17

    and-int/lit8 v4, v17, 0x1

    .line 572
    .restart local v4    # "bitj":I
    const/16 v17, 0x1

    and-int/lit8 v18, v7, 0x1f

    shl-int v17, v17, v18

    xor-int/lit8 v17, v17, -0x1

    and-int v14, v14, v17

    .line 573
    const/16 v17, 0x1

    and-int/lit8 v18, v10, 0x1f

    shl-int v17, v17, v18

    xor-int/lit8 v17, v17, -0x1

    and-int v15, v15, v17

    .line 574
    and-int/lit8 v17, v7, 0x1f

    shl-int v17, v4, v17

    or-int v14, v14, v17

    .line 575
    and-int/lit8 v17, v10, 0x1f

    shl-int v17, v2, v17

    or-int v15, v15, v17

    .line 576
    aput v15, v6, v11

    goto :goto_3

    .line 582
    .end local v2    # "biti":I
    .end local v4    # "bitj":I
    .end local v8    # "ii":I
    .end local v11    # "jj":I
    .end local v14    # "wi":I
    .end local v15    # "wj":I
    :cond_3
    array-length v0, v6

    move/from16 v17, v0

    move/from16 v0, v17

    invoke-static {v6, v0}, Lgnu/math/IntNum;->make([II)Lgnu/math/IntNum;

    move-result-object v17

    goto :goto_1
.end method

.method public static setBitOp(Lgnu/math/IntNum;ILgnu/math/IntNum;Lgnu/math/IntNum;)V
    .locals 12
    .param p0, "result"    # Lgnu/math/IntNum;
    .param p1, "op"    # I
    .param p2, "x"    # Lgnu/math/IntNum;
    .param p3, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 208
    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    if-nez v10, :cond_5

    .line 217
    :cond_0
    :goto_0
    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    if-nez v10, :cond_7

    .line 219
    iget v8, p3, Lgnu/math/IntNum;->ival:I

    .line 220
    .local v8, "yi":I
    const/4 v9, 0x1

    .line 227
    .local v9, "ylen":I
    :goto_1
    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    if-nez v10, :cond_8

    .line 229
    iget v6, p2, Lgnu/math/IntNum;->ival:I

    .line 230
    .local v6, "xi":I
    const/4 v7, 0x1

    .line 237
    .local v7, "xlen":I
    :goto_2
    const/4 v10, 0x1

    if-le v7, v10, :cond_1

    .line 238
    invoke-virtual {p0, v7}, Lgnu/math/IntNum;->realloc(I)V

    .line 239
    :cond_1
    iget-object v5, p0, Lgnu/math/IntNum;->words:[I

    .line 240
    .local v5, "w":[I
    const/4 v1, 0x0

    .line 245
    .local v1, "i":I
    const/4 v0, 0x0

    .line 247
    .local v0, "finish":I
    packed-switch p1, :pswitch_data_0

    .line 368
    const/4 v3, -0x1

    .local v3, "ni":I
    move v2, v1

    .line 373
    .end local v1    # "i":I
    .local v2, "i":I
    :cond_2
    :goto_3
    add-int/lit8 v10, v2, 0x1

    if-ne v10, v7, :cond_3

    .line 374
    const/4 v0, 0x0

    .line 375
    :cond_3
    packed-switch v0, :pswitch_data_1

    move v1, v2

    .line 388
    .end local v2    # "i":I
    .restart local v1    # "i":I
    :cond_4
    :goto_4
    iput v1, p0, Lgnu/math/IntNum;->ival:I

    .line 389
    :goto_5
    return-void

    .line 209
    .end local v0    # "finish":I
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .end local v5    # "w":[I
    .end local v6    # "xi":I
    .end local v7    # "xlen":I
    .end local v8    # "yi":I
    .end local v9    # "ylen":I
    :cond_5
    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    if-eqz v10, :cond_6

    iget v10, p2, Lgnu/math/IntNum;->ival:I

    iget v11, p3, Lgnu/math/IntNum;->ival:I

    if-ge v10, v11, :cond_0

    .line 211
    :cond_6
    move-object v4, p2

    .local v4, "temp":Lgnu/math/IntNum;
    move-object p2, p3

    move-object p3, v4

    .line 212
    invoke-static {p1}, Lgnu/math/BitOps;->swappedOp(I)I

    move-result p1

    goto :goto_0

    .line 224
    .end local v4    # "temp":Lgnu/math/IntNum;
    :cond_7
    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    const/4 v11, 0x0

    aget v8, v10, v11

    .line 225
    .restart local v8    # "yi":I
    iget v9, p3, Lgnu/math/IntNum;->ival:I

    .restart local v9    # "ylen":I
    goto :goto_1

    .line 234
    :cond_8
    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    const/4 v11, 0x0

    aget v6, v10, v11

    .line 235
    .restart local v6    # "xi":I
    iget v7, p2, Lgnu/math/IntNum;->ival:I

    .restart local v7    # "xlen":I
    goto :goto_2

    .line 250
    .restart local v0    # "finish":I
    .restart local v1    # "i":I
    .restart local v5    # "w":[I
    :pswitch_0
    const/4 v3, 0x0

    .restart local v3    # "ni":I
    move v2, v1

    .line 251
    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto :goto_3

    .line 257
    :cond_9
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 255
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_6
    and-int v3, v6, v8

    .line 256
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_9

    .line 259
    if-gez v8, :cond_2

    const/4 v0, 0x1

    goto :goto_3

    .line 266
    :cond_a
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 264
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_7
    xor-int/lit8 v10, v8, -0x1

    and-int v3, v6, v10

    .line 265
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_a

    .line 268
    if-ltz v8, :cond_2

    const/4 v0, 0x1

    goto :goto_3

    .line 271
    .end local v2    # "i":I
    .end local v3    # "ni":I
    .restart local v1    # "i":I
    :pswitch_1
    move v3, v6

    .line 272
    .restart local v3    # "ni":I
    const/4 v0, 0x1

    move v2, v1

    .line 273
    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto :goto_3

    .line 279
    :cond_b
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 277
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_8
    xor-int/lit8 v10, v6, -0x1

    and-int v3, v10, v8

    .line 278
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_b

    .line 281
    if-gez v8, :cond_2

    const/4 v0, 0x2

    goto :goto_3

    .line 288
    :cond_c
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 286
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_9
    move v3, v8

    .line 287
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_c

    goto/16 :goto_3

    .line 296
    :cond_d
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 294
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_a
    xor-int v3, v6, v8

    .line 295
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_d

    .line 298
    if-gez v8, :cond_e

    const/4 v0, 0x2

    .line 299
    :goto_b
    goto/16 :goto_3

    .line 298
    :cond_e
    const/4 v0, 0x1

    goto :goto_b

    .line 305
    :cond_f
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 303
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_c
    or-int v3, v6, v8

    .line 304
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_f

    .line 307
    if-ltz v8, :cond_2

    const/4 v0, 0x1

    goto/16 :goto_3

    .line 314
    :cond_10
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 312
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_d
    or-int v10, v6, v8

    xor-int/lit8 v3, v10, -0x1

    .line 313
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_10

    .line 316
    if-ltz v8, :cond_2

    const/4 v0, 0x2

    goto/16 :goto_3

    .line 323
    :cond_11
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 321
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_e
    xor-int v10, v6, v8

    xor-int/lit8 v3, v10, -0x1

    .line 322
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_11

    .line 325
    if-ltz v8, :cond_12

    const/4 v0, 0x2

    .line 326
    :goto_f
    goto/16 :goto_3

    .line 325
    :cond_12
    const/4 v0, 0x1

    goto :goto_f

    .line 332
    :cond_13
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 330
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_10
    xor-int/lit8 v3, v8, -0x1

    .line 331
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_13

    goto/16 :goto_3

    .line 340
    :cond_14
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 338
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_11
    xor-int/lit8 v10, v8, -0x1

    or-int v3, v6, v10

    .line 339
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_14

    .line 342
    if-gez v8, :cond_2

    const/4 v0, 0x1

    goto/16 :goto_3

    .line 345
    .end local v2    # "i":I
    .end local v3    # "ni":I
    .restart local v1    # "i":I
    :pswitch_2
    xor-int/lit8 v3, v6, -0x1

    .line 346
    .restart local v3    # "ni":I
    const/4 v0, 0x2

    move v2, v1

    .line 347
    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_3

    .line 353
    :cond_15
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 351
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_12
    xor-int/lit8 v10, v6, -0x1

    or-int v3, v10, v8

    .line 352
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_15

    .line 355
    if-ltz v8, :cond_2

    const/4 v0, 0x2

    goto/16 :goto_3

    .line 362
    :cond_16
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v6, v10, v1

    iget-object v10, p3, Lgnu/math/IntNum;->words:[I

    aget v8, v10, v1

    move v2, v1

    .line 360
    .end local v1    # "i":I
    .end local v3    # "ni":I
    .restart local v2    # "i":I
    :goto_13
    and-int v10, v6, v8

    xor-int/lit8 v3, v10, -0x1

    .line 361
    .restart local v3    # "ni":I
    add-int/lit8 v10, v2, 0x1

    if-lt v10, v9, :cond_16

    .line 364
    if-gez v8, :cond_2

    const/4 v0, 0x2

    goto/16 :goto_3

    .line 378
    :pswitch_3
    if-nez v2, :cond_17

    if-nez v5, :cond_17

    .line 380
    iput v3, p0, Lgnu/math/IntNum;->ival:I

    move v1, v2

    .line 381
    .end local v2    # "i":I
    .restart local v1    # "i":I
    goto/16 :goto_5

    .line 383
    .end local v1    # "i":I
    .restart local v2    # "i":I
    :cond_17
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "i":I
    .restart local v1    # "i":I
    aput v3, v5, v2

    goto/16 :goto_4

    .line 385
    .end local v1    # "i":I
    .restart local v2    # "i":I
    :pswitch_4
    aput v3, v5, v2

    move v1, v2

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :goto_14
    add-int/lit8 v1, v1, 0x1

    if-ge v1, v7, :cond_4

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v10, v10, v1

    aput v10, v5, v1

    goto :goto_14

    .line 386
    .end local v1    # "i":I
    .restart local v2    # "i":I
    :pswitch_5
    aput v3, v5, v2

    move v1, v2

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :goto_15
    add-int/lit8 v1, v1, 0x1

    if-ge v1, v7, :cond_4

    iget-object v10, p2, Lgnu/math/IntNum;->words:[I

    aget v10, v10, v1

    xor-int/lit8 v10, v10, -0x1

    aput v10, v5, v1

    goto :goto_15

    .end local v3    # "ni":I
    :pswitch_6
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto :goto_13

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_7
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto :goto_12

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_8
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto :goto_11

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_9
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_10

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_a
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_e

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_b
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_d

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_c
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_c

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_d
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_a

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_e
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_9

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_f
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_8

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_10
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_7

    .end local v2    # "i":I
    .restart local v1    # "i":I
    :pswitch_11
    move v2, v1

    .end local v1    # "i":I
    .restart local v2    # "i":I
    goto/16 :goto_6

    .line 247
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_11
        :pswitch_10
        :pswitch_1
        :pswitch_f
        :pswitch_e
        :pswitch_d
        :pswitch_c
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_2
        :pswitch_7
        :pswitch_6
    .end packed-switch

    .line 375
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public static setBitValue(Lgnu/math/IntNum;II)Lgnu/math/IntNum;
    .locals 9
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "bitno"    # I
    .param p2, "newValue"    # I

    .prologue
    const/16 v5, 0x1f

    const/4 v4, 0x1

    .line 70
    and-int/lit8 p2, p2, 0x1

    .line 71
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    .line 74
    .local v1, "i":I
    iget-object v6, p0, Lgnu/math/IntNum;->words:[I

    if-nez v6, :cond_3

    .line 76
    if-ge p1, v5, :cond_0

    move v5, p1

    :cond_0
    shr-int v5, v1, v5

    and-int/lit8 v2, v5, 0x1

    .line 77
    .local v2, "oldValue":I
    if-ne v2, p2, :cond_2

    .line 95
    .end local p0    # "x":Lgnu/math/IntNum;
    :cond_1
    :goto_0
    return-object p0

    .line 79
    .restart local p0    # "x":Lgnu/math/IntNum;
    :cond_2
    const/16 v5, 0x3f

    if-ge p1, v5, :cond_4

    .line 80
    int-to-long v5, v1

    shl-int/2addr v4, p1

    int-to-long v7, v4

    xor-long v4, v5, v7

    invoke-static {v4, v5}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0

    .line 84
    .end local v2    # "oldValue":I
    :cond_3
    shr-int/lit8 v3, p1, 0x5

    .line 86
    .local v3, "wordno":I
    if-lt v3, v1, :cond_6

    .line 87
    iget-object v5, p0, Lgnu/math/IntNum;->words:[I

    add-int/lit8 v6, v1, -0x1

    aget v5, v5, v6

    if-gez v5, :cond_5

    move v2, v4

    .line 90
    .restart local v2    # "oldValue":I
    :goto_1
    if-eq v2, p2, :cond_1

    .line 93
    .end local v3    # "wordno":I
    :cond_4
    invoke-static {p0, p1}, Lgnu/math/BitOps;->dataBufferFor(Lgnu/math/IntNum;I)[I

    move-result-object v0

    .line 94
    .local v0, "data":[I
    shr-int/lit8 v5, p1, 0x5

    aget v6, v0, v5

    and-int/lit8 v7, p1, 0x1f

    shl-int/2addr v4, v7

    xor-int/2addr v4, v6

    aput v4, v0, v5

    .line 95
    array-length v4, v0

    invoke-static {v0, v4}, Lgnu/math/IntNum;->make([II)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0

    .line 87
    .end local v0    # "data":[I
    .end local v2    # "oldValue":I
    .restart local v3    # "wordno":I
    :cond_5
    const/4 v2, 0x0

    goto :goto_1

    .line 89
    :cond_6
    iget-object v5, p0, Lgnu/math/IntNum;->words:[I

    aget v5, v5, v3

    shr-int/2addr v5, p1

    and-int/lit8 v2, v5, 0x1

    .restart local v2    # "oldValue":I
    goto :goto_1
.end method

.method public static swappedOp(I)I
    .locals 1
    .param p0, "op"    # I

    .prologue
    .line 184
    const-string v0, "\u0000\u0001\u0004\u0005\u0002\u0003\u0006\u0007\u0008\t\u000c\r\n\u000b\u000e\u000f"

    invoke-virtual {v0, p0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    return v0
.end method

.method public static test(Lgnu/math/IntNum;I)Z
    .locals 3
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # I

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 101
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_1

    .line 102
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    and-int/2addr v2, p1

    if-eqz v2, :cond_0

    .line 103
    :goto_0
    return v0

    :cond_0
    move v0, v1

    .line 102
    goto :goto_0

    .line 103
    :cond_1
    if-ltz p1, :cond_2

    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v2, v2, v1

    and-int/2addr v2, p1

    if-eqz v2, :cond_3

    :cond_2
    move v1, v0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public static test(Lgnu/math/IntNum;Lgnu/math/IntNum;)Z
    .locals 4
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 109
    iget-object v2, p1, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_0

    .line 110
    iget v2, p1, Lgnu/math/IntNum;->ival:I

    invoke-static {p0, v2}, Lgnu/math/BitOps;->test(Lgnu/math/IntNum;I)Z

    move-result v2

    .line 122
    :goto_0
    return v2

    .line 111
    :cond_0
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_1

    .line 112
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {p1, v2}, Lgnu/math/BitOps;->test(Lgnu/math/IntNum;I)Z

    move-result v2

    goto :goto_0

    .line 113
    :cond_1
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    iget v3, p1, Lgnu/math/IntNum;->ival:I

    if-ge v2, v3, :cond_2

    .line 115
    move-object v1, p0

    .local v1, "temp":Lgnu/math/IntNum;
    move-object p0, p1

    move-object p1, v1

    .line 117
    .end local v1    # "temp":Lgnu/math/IntNum;
    :cond_2
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget v2, p1, Lgnu/math/IntNum;->ival:I

    if-ge v0, v2, :cond_4

    .line 119
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v2, v2, v0

    iget-object v3, p1, Lgnu/math/IntNum;->words:[I

    aget v3, v3, v0

    and-int/2addr v2, v3

    if-eqz v2, :cond_3

    .line 120
    const/4 v2, 0x1

    goto :goto_0

    .line 117
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 122
    :cond_4
    invoke-virtual {p1}, Lgnu/math/IntNum;->isNegative()Z

    move-result v2

    goto :goto_0
.end method

.method public static xor(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 170
    const/4 v0, 0x6

    invoke-static {v0, p0, p1}, Lgnu/math/BitOps;->bitOp(ILgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method
