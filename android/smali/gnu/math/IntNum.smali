.class public Lgnu/math/IntNum;
.super Lgnu/math/RatNum;
.source "IntNum.java"

# interfaces
.implements Ljava/io/Externalizable;


# static fields
.field static final maxFixNum:I = 0x400

.field static final minFixNum:I = -0x64

.field static final numFixNum:I = 0x465

.field static final smallFixNums:[Lgnu/math/IntNum;


# instance fields
.field public ival:I

.field public words:[I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 27
    const/16 v1, 0x465

    new-array v1, v1, [Lgnu/math/IntNum;

    sput-object v1, Lgnu/math/IntNum;->smallFixNums:[Lgnu/math/IntNum;

    .line 30
    const/16 v0, 0x465

    .local v0, "i":I
    :goto_0
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_0

    .line 31
    sget-object v1, Lgnu/math/IntNum;->smallFixNums:[Lgnu/math/IntNum;

    new-instance v2, Lgnu/math/IntNum;

    add-int/lit8 v3, v0, -0x64

    invoke-direct {v2, v3}, Lgnu/math/IntNum;-><init>(I)V

    aput-object v2, v1, v0

    goto :goto_0

    .line 32
    :cond_0
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Lgnu/math/RatNum;-><init>()V

    .line 36
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 41
    invoke-direct {p0}, Lgnu/math/RatNum;-><init>()V

    .line 42
    iput p1, p0, Lgnu/math/IntNum;->ival:I

    .line 43
    return-void
.end method

.method public static abs(Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "x"    # Lgnu/math/IntNum;

    .prologue
    .line 1611
    invoke-virtual {p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {p0}, Lgnu/math/IntNum;->neg(Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object p0

    .end local p0    # "x":Lgnu/math/IntNum;
    :cond_0
    return-object p0
.end method

.method public static final add(II)Lgnu/math/IntNum;
    .locals 4
    .param p0, "x"    # I
    .param p1, "y"    # I

    .prologue
    .line 326
    int-to-long v0, p0

    int-to-long v2, p1

    add-long/2addr v0, v2

    invoke-static {v0, v1}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static add(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    .locals 2
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # I

    .prologue
    .line 332
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    if-nez v1, :cond_0

    .line 333
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v1, p1}, Lgnu/math/IntNum;->add(II)Lgnu/math/IntNum;

    move-result-object v1

    .line 336
    :goto_0
    return-object v1

    .line 334
    :cond_0
    new-instance v0, Lgnu/math/IntNum;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lgnu/math/IntNum;-><init>(I)V

    .line 335
    .local v0, "result":Lgnu/math/IntNum;
    invoke-virtual {v0, p0, p1}, Lgnu/math/IntNum;->setAdd(Lgnu/math/IntNum;I)V

    .line 336
    invoke-virtual {v0}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object v1

    goto :goto_0
.end method

.method public static add(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 418
    const/4 v0, 0x1

    invoke-static {p0, p1, v0}, Lgnu/math/IntNum;->add(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static add(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    .locals 12
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;
    .param p2, "k"    # I

    .prologue
    const-wide v7, 0xffffffffL

    .line 430
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    if-nez v9, :cond_0

    iget-object v9, p1, Lgnu/math/IntNum;->words:[I

    if-nez v9, :cond_0

    .line 431
    int-to-long v7, p2

    iget v9, p1, Lgnu/math/IntNum;->ival:I

    int-to-long v9, v9

    mul-long/2addr v7, v9

    iget v9, p0, Lgnu/math/IntNum;->ival:I

    int-to-long v9, v9

    add-long/2addr v7, v9

    invoke-static {v7, v8}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v7

    .line 463
    :goto_0
    return-object v7

    .line 432
    :cond_0
    const/4 v9, 0x1

    if-eq p2, v9, :cond_1

    .line 434
    const/4 v9, -0x1

    if-ne p2, v9, :cond_2

    .line 435
    invoke-static {p1}, Lgnu/math/IntNum;->neg(Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object p1

    .line 439
    :cond_1
    :goto_1
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    if-nez v9, :cond_3

    .line 440
    iget v7, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {p1, v7}, Lgnu/math/IntNum;->add(Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v7

    goto :goto_0

    .line 437
    :cond_2
    invoke-static {p2}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v9

    invoke-static {p1, v9}, Lgnu/math/IntNum;->times(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object p1

    goto :goto_1

    .line 441
    :cond_3
    iget-object v9, p1, Lgnu/math/IntNum;->words:[I

    if-nez v9, :cond_4

    .line 442
    iget v7, p1, Lgnu/math/IntNum;->ival:I

    invoke-static {p0, v7}, Lgnu/math/IntNum;->add(Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v7

    goto :goto_0

    .line 445
    :cond_4
    iget v9, p1, Lgnu/math/IntNum;->ival:I

    iget v10, p0, Lgnu/math/IntNum;->ival:I

    if-le v9, v10, :cond_5

    .line 447
    move-object v4, p0

    .local v4, "tmp":Lgnu/math/IntNum;
    move-object p0, p1

    move-object p1, v4

    .line 449
    .end local v4    # "tmp":Lgnu/math/IntNum;
    :cond_5
    iget v9, p0, Lgnu/math/IntNum;->ival:I

    add-int/lit8 v9, v9, 0x1

    invoke-static {v9}, Lgnu/math/IntNum;->alloc(I)Lgnu/math/IntNum;

    move-result-object v3

    .line 450
    .local v3, "result":Lgnu/math/IntNum;
    iget v2, p1, Lgnu/math/IntNum;->ival:I

    .line 451
    .local v2, "i":I
    iget-object v9, v3, Lgnu/math/IntNum;->words:[I

    iget-object v10, p0, Lgnu/math/IntNum;->words:[I

    iget-object v11, p1, Lgnu/math/IntNum;->words:[I

    invoke-static {v9, v10, v11, v2}, Lgnu/math/MPN;->add_n([I[I[II)I

    move-result v9

    int-to-long v0, v9

    .line 452
    .local v0, "carry":J
    iget-object v9, p1, Lgnu/math/IntNum;->words:[I

    add-int/lit8 v10, v2, -0x1

    aget v9, v9, v10

    if-gez v9, :cond_6

    move-wide v5, v7

    .line 453
    .local v5, "y_ext":J
    :goto_2
    iget v9, p0, Lgnu/math/IntNum;->ival:I

    if-ge v2, v9, :cond_7

    .line 455
    iget-object v9, p0, Lgnu/math/IntNum;->words:[I

    aget v9, v9, v2

    int-to-long v9, v9

    and-long/2addr v9, v7

    add-long/2addr v9, v5

    add-long/2addr v0, v9

    .line 456
    iget-object v9, v3, Lgnu/math/IntNum;->words:[I

    long-to-int v10, v0

    aput v10, v9, v2

    .line 457
    const/16 v9, 0x20

    ushr-long/2addr v0, v9

    .line 453
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 452
    .end local v5    # "y_ext":J
    :cond_6
    const-wide/16 v5, 0x0

    goto :goto_2

    .line 459
    .restart local v5    # "y_ext":J
    :cond_7
    iget-object v7, p0, Lgnu/math/IntNum;->words:[I

    add-int/lit8 v8, v2, -0x1

    aget v7, v7, v8

    if-gez v7, :cond_8

    .line 460
    const-wide/16 v7, 0x1

    sub-long/2addr v5, v7

    .line 461
    :cond_8
    iget-object v7, v3, Lgnu/math/IntNum;->words:[I

    add-long v8, v0, v5

    long-to-int v8, v8

    aput v8, v7, v2

    .line 462
    add-int/lit8 v7, v2, 0x1

    iput v7, v3, Lgnu/math/IntNum;->ival:I

    .line 463
    invoke-virtual {v3}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object v7

    goto/16 :goto_0
.end method

.method public static alloc(I)Lgnu/math/IntNum;
    .locals 2
    .param p0, "nwords"    # I

    .prologue
    .line 141
    const/4 v1, 0x1

    if-gt p0, v1, :cond_0

    .line 142
    new-instance v0, Lgnu/math/IntNum;

    invoke-direct {v0}, Lgnu/math/IntNum;-><init>()V

    .line 145
    :goto_0
    return-object v0

    .line 143
    :cond_0
    new-instance v0, Lgnu/math/IntNum;

    invoke-direct {v0}, Lgnu/math/IntNum;-><init>()V

    .line 144
    .local v0, "result":Lgnu/math/IntNum;
    new-array v1, p0, [I

    iput-object v1, v0, Lgnu/math/IntNum;->words:[I

    goto :goto_0
.end method

.method public static asIntNumOrNull(Ljava/lang/Object;)Lgnu/math/IntNum;
    .locals 2
    .param p0, "value"    # Ljava/lang/Object;

    .prologue
    .line 92
    instance-of v0, p0, Lgnu/math/IntNum;

    if-eqz v0, :cond_0

    .line 93
    check-cast p0, Lgnu/math/IntNum;

    .line 100
    .end local p0    # "value":Ljava/lang/Object;
    :goto_0
    return-object p0

    .line 94
    .restart local p0    # "value":Ljava/lang/Object;
    :cond_0
    instance-of v0, p0, Ljava/math/BigInteger;

    if-eqz v0, :cond_1

    .line 95
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0xa

    invoke-static {v0, v1}, Lgnu/math/IntNum;->valueOf(Ljava/lang/String;I)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0

    .line 96
    :cond_1
    instance-of v0, p0, Ljava/lang/Number;

    if-eqz v0, :cond_3

    instance-of v0, p0, Ljava/lang/Integer;

    if-nez v0, :cond_2

    instance-of v0, p0, Ljava/lang/Long;

    if-nez v0, :cond_2

    instance-of v0, p0, Ljava/lang/Short;

    if-nez v0, :cond_2

    instance-of v0, p0, Ljava/lang/Byte;

    if-eqz v0, :cond_3

    .line 99
    :cond_2
    check-cast p0, Ljava/lang/Number;

    .end local p0    # "value":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/lang/Number;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0

    .line 100
    .restart local p0    # "value":Ljava/lang/Object;
    :cond_3
    const/4 p0, 0x0

    goto :goto_0
.end method

.method public static compare(Lgnu/math/IntNum;J)I
    .locals 10
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # J

    .prologue
    const/4 v7, 0x0

    const/4 v5, -0x1

    const/4 v6, 0x1

    .line 236
    iget-object v8, p0, Lgnu/math/IntNum;->words:[I

    if-nez v8, :cond_1

    .line 237
    iget v8, p0, Lgnu/math/IntNum;->ival:I

    int-to-long v2, v8

    .line 252
    .local v2, "x_word":J
    :goto_0
    cmp-long v8, v2, p1

    if-gez v8, :cond_7

    .end local v2    # "x_word":J
    :cond_0
    :goto_1
    return v5

    .line 240
    :cond_1
    invoke-virtual {p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v1

    .line 241
    .local v1, "x_negative":Z
    const-wide/16 v8, 0x0

    cmp-long v8, p1, v8

    if-gez v8, :cond_2

    move v4, v6

    .line 242
    .local v4, "y_negative":Z
    :goto_2
    if-eq v1, v4, :cond_3

    .line 243
    if-nez v1, :cond_0

    move v5, v6

    goto :goto_1

    .end local v4    # "y_negative":Z
    :cond_2
    move v4, v7

    .line 241
    goto :goto_2

    .line 244
    .restart local v4    # "y_negative":Z
    :cond_3
    iget-object v8, p0, Lgnu/math/IntNum;->words:[I

    if-nez v8, :cond_4

    move v0, v6

    .line 245
    .local v0, "x_len":I
    :goto_3
    if-ne v0, v6, :cond_5

    .line 246
    iget-object v8, p0, Lgnu/math/IntNum;->words:[I

    aget v8, v8, v7

    int-to-long v2, v8

    .restart local v2    # "x_word":J
    goto :goto_0

    .line 244
    .end local v0    # "x_len":I
    .end local v2    # "x_word":J
    :cond_4
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    goto :goto_3

    .line 247
    .restart local v0    # "x_len":I
    :cond_5
    const/4 v8, 0x2

    if-ne v0, v8, :cond_6

    .line 248
    invoke-virtual {p0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v2

    .restart local v2    # "x_word":J
    goto :goto_0

    .line 250
    .end local v2    # "x_word":J
    :cond_6
    if-nez v1, :cond_0

    move v5, v6

    goto :goto_1

    .line 252
    .end local v0    # "x_len":I
    .end local v1    # "x_negative":Z
    .end local v4    # "y_negative":Z
    .restart local v2    # "x_word":J
    :cond_7
    cmp-long v5, v2, p1

    if-lez v5, :cond_8

    move v5, v6

    goto :goto_1

    :cond_8
    move v5, v7

    goto :goto_1
.end method

.method public static compare(Lgnu/math/IntNum;Lgnu/math/IntNum;)I
    .locals 9
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    const/4 v6, 0x0

    const/4 v4, -0x1

    const/4 v5, 0x1

    .line 219
    iget-object v7, p0, Lgnu/math/IntNum;->words:[I

    if-nez v7, :cond_3

    iget-object v7, p1, Lgnu/math/IntNum;->words:[I

    if-nez v7, :cond_3

    .line 220
    iget v7, p0, Lgnu/math/IntNum;->ival:I

    iget v8, p1, Lgnu/math/IntNum;->ival:I

    if-ge v7, v8, :cond_1

    .line 229
    :cond_0
    :goto_0
    return v4

    .line 220
    :cond_1
    iget v4, p0, Lgnu/math/IntNum;->ival:I

    iget v7, p1, Lgnu/math/IntNum;->ival:I

    if-le v4, v7, :cond_2

    move v4, v5

    goto :goto_0

    :cond_2
    move v4, v6

    goto :goto_0

    .line 221
    :cond_3
    invoke-virtual {p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v1

    .line 222
    .local v1, "x_negative":Z
    invoke-virtual {p1}, Lgnu/math/IntNum;->isNegative()Z

    move-result v3

    .line 223
    .local v3, "y_negative":Z
    if-eq v1, v3, :cond_4

    .line 224
    if-nez v1, :cond_0

    move v4, v5

    goto :goto_0

    .line 225
    :cond_4
    iget-object v7, p0, Lgnu/math/IntNum;->words:[I

    if-nez v7, :cond_6

    move v0, v5

    .line 226
    .local v0, "x_len":I
    :goto_1
    iget-object v7, p1, Lgnu/math/IntNum;->words:[I

    if-nez v7, :cond_7

    move v2, v5

    .line 227
    .local v2, "y_len":I
    :goto_2
    if-eq v0, v2, :cond_9

    .line 228
    if-le v0, v2, :cond_5

    move v6, v5

    :cond_5
    if-eq v6, v1, :cond_8

    :goto_3
    move v4, v5

    goto :goto_0

    .line 225
    .end local v0    # "x_len":I
    .end local v2    # "y_len":I
    :cond_6
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    goto :goto_1

    .line 226
    .restart local v0    # "x_len":I
    :cond_7
    iget v2, p1, Lgnu/math/IntNum;->ival:I

    goto :goto_2

    .restart local v2    # "y_len":I
    :cond_8
    move v5, v4

    .line 228
    goto :goto_3

    .line 229
    :cond_9
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    iget-object v5, p1, Lgnu/math/IntNum;->words:[I

    invoke-static {v4, v5, v0}, Lgnu/math/MPN;->cmp([I[II)I

    move-result v4

    goto :goto_0
.end method

.method public static divide(JJLgnu/math/IntNum;Lgnu/math/IntNum;I)V
    .locals 14
    .param p0, "x"    # J
    .param p2, "y"    # J
    .param p4, "quotient"    # Lgnu/math/IntNum;
    .param p5, "remainder"    # Lgnu/math/IntNum;
    .param p6, "rounding_mode"    # I

    .prologue
    .line 553
    const/4 v11, 0x5

    move/from16 v0, p6

    if-ne v0, v11, :cond_0

    .line 554
    const-wide/16 v11, 0x0

    cmp-long v11, p2, v11

    if-gez v11, :cond_2

    const/16 p6, 0x2

    .line 555
    :cond_0
    :goto_0
    const-wide/16 v11, 0x0

    cmp-long v11, p0, v11

    if-gez v11, :cond_5

    .line 557
    const/4 v9, 0x1

    .line 558
    .local v9, "xNegative":Z
    const-wide/high16 v11, -0x8000000000000000L

    cmp-long v11, p0, v11

    if-nez v11, :cond_3

    .line 560
    invoke-static {p0, p1}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v11

    invoke-static/range {p2 .. p3}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v12

    move-object/from16 v0, p4

    move-object/from16 v1, p5

    move/from16 v2, p6

    invoke-static {v11, v12, v0, v1, v2}, Lgnu/math/IntNum;->divide(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;I)V

    .line 640
    :cond_1
    :goto_1
    return-void

    .line 554
    .end local v9    # "xNegative":Z
    :cond_2
    const/16 p6, 0x1

    goto :goto_0

    .line 564
    .restart local v9    # "xNegative":Z
    :cond_3
    neg-long p0, p0

    .line 569
    :goto_2
    const-wide/16 v11, 0x0

    cmp-long v11, p2, v11

    if-gez v11, :cond_e

    .line 571
    const/4 v10, 0x1

    .line 572
    .local v10, "yNegative":Z
    const-wide/high16 v11, -0x8000000000000000L

    cmp-long v11, p2, v11

    if-nez v11, :cond_7

    .line 574
    const/4 v11, 0x3

    move/from16 v0, p6

    if-ne v0, v11, :cond_6

    .line 576
    if-eqz p4, :cond_4

    .line 577
    const/4 v11, 0x0

    move-object/from16 v0, p4

    invoke-virtual {v0, v11}, Lgnu/math/IntNum;->set(I)V

    .line 578
    :cond_4
    if-eqz p5, :cond_1

    .line 579
    move-object/from16 v0, p5

    invoke-virtual {v0, p0, p1}, Lgnu/math/IntNum;->set(J)V

    goto :goto_1

    .line 567
    .end local v9    # "xNegative":Z
    .end local v10    # "yNegative":Z
    :cond_5
    const/4 v9, 0x0

    .restart local v9    # "xNegative":Z
    goto :goto_2

    .line 582
    .restart local v10    # "yNegative":Z
    :cond_6
    invoke-static {p0, p1}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v11

    invoke-static/range {p2 .. p3}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v12

    move-object/from16 v0, p4

    move-object/from16 v1, p5

    move/from16 v2, p6

    invoke-static {v11, v12, v0, v1, v2}, Lgnu/math/IntNum;->divide(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;I)V

    goto :goto_1

    .line 586
    :cond_7
    move-wide/from16 v0, p2

    neg-long v0, v0

    move-wide/from16 p2, v0

    .line 591
    :goto_3
    div-long v4, p0, p2

    .line 592
    .local v4, "q":J
    rem-long v7, p0, p2

    .line 593
    .local v7, "r":J
    xor-int v6, v9, v10

    .line 595
    .local v6, "qNegative":Z
    const/4 v3, 0x0

    .line 596
    .local v3, "add_one":Z
    const-wide/16 v11, 0x0

    cmp-long v11, v7, v11

    if-eqz v11, :cond_8

    .line 598
    packed-switch p6, :pswitch_data_0

    .line 612
    :cond_8
    :goto_4
    :pswitch_0
    if-eqz p4, :cond_b

    .line 614
    if-eqz v3, :cond_9

    .line 615
    const-wide/16 v11, 0x1

    add-long/2addr v4, v11

    .line 616
    :cond_9
    if-eqz v6, :cond_a

    .line 617
    neg-long v4, v4

    .line 618
    :cond_a
    move-object/from16 v0, p4

    invoke-virtual {v0, v4, v5}, Lgnu/math/IntNum;->set(J)V

    .line 620
    :cond_b
    if-eqz p5, :cond_1

    .line 623
    if-eqz v3, :cond_c

    .line 626
    sub-long v7, p2, v7

    .line 629
    if-nez v9, :cond_11

    const/4 v9, 0x1

    .line 636
    :cond_c
    :goto_5
    if-eqz v9, :cond_d

    .line 637
    neg-long v7, v7

    .line 638
    :cond_d
    move-object/from16 v0, p5

    invoke-virtual {v0, v7, v8}, Lgnu/math/IntNum;->set(J)V

    goto :goto_1

    .line 589
    .end local v3    # "add_one":Z
    .end local v4    # "q":J
    .end local v6    # "qNegative":Z
    .end local v7    # "r":J
    .end local v10    # "yNegative":Z
    :cond_e
    const/4 v10, 0x0

    .restart local v10    # "yNegative":Z
    goto :goto_3

    .line 604
    .restart local v3    # "add_one":Z
    .restart local v4    # "q":J
    .restart local v6    # "qNegative":Z
    .restart local v7    # "r":J
    :pswitch_1
    const/4 v11, 0x1

    move/from16 v0, p6

    if-ne v0, v11, :cond_f

    const/4 v11, 0x1

    :goto_6
    if-ne v6, v11, :cond_8

    .line 605
    const/4 v3, 0x1

    goto :goto_4

    .line 604
    :cond_f
    const/4 v11, 0x0

    goto :goto_6

    .line 608
    :pswitch_2
    const-wide/16 v11, 0x1

    and-long/2addr v11, v4

    sub-long v11, p2, v11

    const/4 v13, 0x1

    shr-long/2addr v11, v13

    cmp-long v11, v7, v11

    if-lez v11, :cond_10

    const/4 v3, 0x1

    :goto_7
    goto :goto_4

    :cond_10
    const/4 v3, 0x0

    goto :goto_7

    .line 629
    :cond_11
    const/4 v9, 0x0

    goto :goto_5

    .line 598
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public static divide(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;I)V
    .locals 29
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;
    .param p2, "quotient"    # Lgnu/math/IntNum;
    .param p3, "remainder"    # Lgnu/math/IntNum;
    .param p4, "rounding_mode"    # I

    .prologue
    .line 654
    move-object/from16 v0, p0

    iget-object v8, v0, Lgnu/math/IntNum;->words:[I

    if-eqz v8, :cond_0

    move-object/from16 v0, p0

    iget v8, v0, Lgnu/math/IntNum;->ival:I

    const/4 v9, 0x2

    if-gt v8, v9, :cond_3

    :cond_0
    move-object/from16 v0, p1

    iget-object v8, v0, Lgnu/math/IntNum;->words:[I

    if-eqz v8, :cond_1

    move-object/from16 v0, p1

    iget v8, v0, Lgnu/math/IntNum;->ival:I

    const/4 v9, 0x2

    if-gt v8, v9, :cond_3

    .line 657
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v4

    .line 658
    .local v4, "x_l":J
    invoke-virtual/range {p1 .. p1}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v6

    .line 659
    .local v6, "y_l":J
    const-wide/high16 v8, -0x8000000000000000L

    cmp-long v8, v4, v8

    if-eqz v8, :cond_3

    const-wide/high16 v8, -0x8000000000000000L

    cmp-long v8, v6, v8

    if-eqz v8, :cond_3

    move-object/from16 v8, p2

    move-object/from16 v9, p3

    move/from16 v10, p4

    .line 661
    invoke-static/range {v4 .. v10}, Lgnu/math/IntNum;->divide(JJLgnu/math/IntNum;Lgnu/math/IntNum;I)V

    .line 823
    .end local v4    # "x_l":J
    .end local v6    # "y_l":J
    :cond_2
    :goto_0
    return-void

    .line 666
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v21

    .line 667
    .local v21, "xNegative":Z
    invoke-virtual/range {p1 .. p1}, Lgnu/math/IntNum;->isNegative()Z

    move-result v26

    .line 668
    .local v26, "yNegative":Z
    xor-int v16, v21, v26

    .line 670
    .local v16, "qNegative":Z
    move-object/from16 v0, p1

    iget-object v8, v0, Lgnu/math/IntNum;->words:[I

    if-nez v8, :cond_4

    const/16 v27, 0x1

    .line 671
    .local v27, "ylen":I
    :goto_1
    move/from16 v0, v27

    new-array v0, v0, [I

    move-object/from16 v28, v0

    .line 672
    .local v28, "ywords":[I
    move-object/from16 v0, p1

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Lgnu/math/IntNum;->getAbsolute([I)V

    .line 673
    :goto_2
    const/4 v8, 0x1

    move/from16 v0, v27

    if-le v0, v8, :cond_5

    add-int/lit8 v8, v27, -0x1

    aget v8, v28, v8

    if-nez v8, :cond_5

    add-int/lit8 v27, v27, -0x1

    goto :goto_2

    .line 670
    .end local v27    # "ylen":I
    .end local v28    # "ywords":[I
    :cond_4
    move-object/from16 v0, p1

    iget v0, v0, Lgnu/math/IntNum;->ival:I

    move/from16 v27, v0

    goto :goto_1

    .line 675
    .restart local v27    # "ylen":I
    .restart local v28    # "ywords":[I
    :cond_5
    move-object/from16 v0, p0

    iget-object v8, v0, Lgnu/math/IntNum;->words:[I

    if-nez v8, :cond_6

    const/16 v23, 0x1

    .line 676
    .local v23, "xlen":I
    :goto_3
    add-int/lit8 v8, v23, 0x2

    new-array v0, v8, [I

    move-object/from16 v25, v0

    .line 677
    .local v25, "xwords":[I
    move-object/from16 v0, p0

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lgnu/math/IntNum;->getAbsolute([I)V

    move/from16 v24, v23

    .line 678
    .end local v23    # "xlen":I
    .local v24, "xlen":I
    :goto_4
    const/4 v8, 0x1

    move/from16 v0, v24

    if-le v0, v8, :cond_7

    add-int/lit8 v8, v24, -0x1

    aget v8, v25, v8

    if-nez v8, :cond_7

    add-int/lit8 v23, v24, -0x1

    .end local v24    # "xlen":I
    .restart local v23    # "xlen":I
    move/from16 v24, v23

    .end local v23    # "xlen":I
    .restart local v24    # "xlen":I
    goto :goto_4

    .line 675
    .end local v24    # "xlen":I
    .end local v25    # "xwords":[I
    :cond_6
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/math/IntNum;->ival:I

    move/from16 v23, v0

    goto :goto_3

    .line 682
    .restart local v24    # "xlen":I
    .restart local v25    # "xwords":[I
    :cond_7
    move-object/from16 v0, v25

    move/from16 v1, v24

    move-object/from16 v2, v28

    move/from16 v3, v27

    invoke-static {v0, v1, v2, v3}, Lgnu/math/MPN;->cmp([II[II)I

    move-result v13

    .line 683
    .local v13, "cmpval":I
    if-gez v13, :cond_9

    .line 685
    move-object/from16 v19, v25

    .local v19, "rwords":[I
    move-object/from16 v25, v28

    move-object/from16 v28, v19

    .line 686
    move/from16 v18, v24

    .local v18, "rlen":I
    const/16 v17, 0x1

    .local v17, "qlen":I
    const/4 v8, 0x0

    const/4 v9, 0x0

    aput v9, v25, v8

    move/from16 v23, v24

    .line 732
    .end local v19    # "rwords":[I
    .end local v24    # "xlen":I
    .restart local v23    # "xlen":I
    :cond_8
    :goto_5
    const/4 v8, 0x1

    move/from16 v0, v18

    if-le v0, v8, :cond_d

    add-int/lit8 v8, v18, -0x1

    aget v8, v28, v8

    if-nez v8, :cond_d

    .line 733
    add-int/lit8 v18, v18, -0x1

    goto :goto_5

    .line 688
    .end local v17    # "qlen":I
    .end local v18    # "rlen":I
    .end local v23    # "xlen":I
    .restart local v24    # "xlen":I
    :cond_9
    if-nez v13, :cond_a

    .line 690
    const/4 v8, 0x0

    const/4 v9, 0x1

    aput v9, v25, v8

    const/16 v17, 0x1

    .line 691
    .restart local v17    # "qlen":I
    const/4 v8, 0x0

    const/4 v9, 0x0

    aput v9, v28, v8

    const/16 v18, 0x1

    .restart local v18    # "rlen":I
    move/from16 v23, v24

    .end local v24    # "xlen":I
    .restart local v23    # "xlen":I
    goto :goto_5

    .line 693
    .end local v17    # "qlen":I
    .end local v18    # "rlen":I
    .end local v23    # "xlen":I
    .restart local v24    # "xlen":I
    :cond_a
    const/4 v8, 0x1

    move/from16 v0, v27

    if-ne v0, v8, :cond_b

    .line 695
    move/from16 v17, v24

    .line 696
    .restart local v17    # "qlen":I
    const/16 v18, 0x1

    .line 697
    .restart local v18    # "rlen":I
    const/4 v8, 0x0

    const/4 v9, 0x0

    aget v9, v28, v9

    move-object/from16 v0, v25

    move-object/from16 v1, v25

    move/from16 v2, v24

    invoke-static {v0, v1, v2, v9}, Lgnu/math/MPN;->divmod_1([I[III)I

    move-result v9

    aput v9, v28, v8

    move/from16 v23, v24

    .end local v24    # "xlen":I
    .restart local v23    # "xlen":I
    goto :goto_5

    .line 705
    .end local v17    # "qlen":I
    .end local v18    # "rlen":I
    .end local v23    # "xlen":I
    .restart local v24    # "xlen":I
    :cond_b
    add-int/lit8 v8, v27, -0x1

    aget v8, v28, v8

    invoke-static {v8}, Lgnu/math/MPN;->count_leading_zeros(I)I

    move-result v15

    .line 706
    .local v15, "nshift":I
    if-eqz v15, :cond_c

    .line 710
    const/4 v8, 0x0

    move-object/from16 v0, v28

    move-object/from16 v1, v28

    move/from16 v2, v27

    invoke-static {v0, v8, v1, v2, v15}, Lgnu/math/MPN;->lshift([II[III)I

    .line 714
    const/4 v8, 0x0

    move-object/from16 v0, v25

    move-object/from16 v1, v25

    move/from16 v2, v24

    invoke-static {v0, v8, v1, v2, v15}, Lgnu/math/MPN;->lshift([II[III)I

    move-result v22

    .line 715
    .local v22, "x_high":I
    add-int/lit8 v23, v24, 0x1

    .end local v24    # "xlen":I
    .restart local v23    # "xlen":I
    aput v22, v25, v24

    move/from16 v24, v23

    .line 718
    .end local v22    # "x_high":I
    .end local v23    # "xlen":I
    .restart local v24    # "xlen":I
    :cond_c
    move/from16 v0, v24

    move/from16 v1, v27

    if-ne v0, v1, :cond_22

    .line 719
    add-int/lit8 v23, v24, 0x1

    .end local v24    # "xlen":I
    .restart local v23    # "xlen":I
    const/4 v8, 0x0

    aput v8, v25, v24

    .line 720
    :goto_6
    move-object/from16 v0, v25

    move/from16 v1, v23

    move-object/from16 v2, v28

    move/from16 v3, v27

    invoke-static {v0, v1, v2, v3}, Lgnu/math/MPN;->divide([II[II)V

    .line 721
    move/from16 v18, v27

    .line 722
    .restart local v18    # "rlen":I
    const/4 v8, 0x0

    move-object/from16 v0, v28

    move-object/from16 v1, v25

    move/from16 v2, v18

    invoke-static {v0, v1, v8, v2, v15}, Lgnu/math/MPN;->rshift0([I[IIII)V

    .line 724
    add-int/lit8 v8, v23, 0x1

    sub-int v17, v8, v27

    .line 725
    .restart local v17    # "qlen":I
    if-eqz p2, :cond_8

    .line 727
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_7
    move/from16 v0, v17

    if-ge v14, v0, :cond_8

    .line 728
    add-int v8, v14, v27

    aget v8, v25, v8

    aput v8, v25, v14

    .line 727
    add-int/lit8 v14, v14, 0x1

    goto :goto_7

    .line 734
    .end local v14    # "i":I
    .end local v15    # "nshift":I
    :cond_d
    add-int/lit8 v8, v18, -0x1

    aget v8, v28, v8

    if-gez v8, :cond_e

    .line 736
    const/4 v8, 0x0

    aput v8, v28, v18

    .line 737
    add-int/lit8 v18, v18, 0x1

    .line 742
    :cond_e
    const/4 v11, 0x0

    .line 743
    .local v11, "add_one":Z
    const/4 v8, 0x1

    move/from16 v0, v18

    if-gt v0, v8, :cond_f

    const/4 v8, 0x0

    aget v8, v28, v8

    if-eqz v8, :cond_11

    .line 745
    :cond_f
    const/4 v8, 0x5

    move/from16 v0, p4

    if-ne v0, v8, :cond_10

    .line 747
    if-eqz v26, :cond_14

    const/16 p4, 0x2

    .line 749
    :cond_10
    :goto_8
    packed-switch p4, :pswitch_data_0

    .line 772
    :cond_11
    :goto_9
    :pswitch_0
    if-eqz p2, :cond_13

    .line 774
    add-int/lit8 v8, v17, -0x1

    aget v8, v25, v8

    if-gez v8, :cond_12

    .line 776
    const/4 v8, 0x0

    aput v8, v25, v17

    .line 777
    add-int/lit8 v17, v17, 0x1

    .line 779
    :cond_12
    move-object/from16 v0, p2

    move-object/from16 v1, v25

    move/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Lgnu/math/IntNum;->set([II)V

    .line 780
    if-eqz v16, :cond_1c

    .line 782
    if-eqz v11, :cond_1b

    .line 783
    invoke-virtual/range {p2 .. p2}, Lgnu/math/IntNum;->setInvert()V

    .line 790
    :cond_13
    :goto_a
    if-eqz p3, :cond_2

    .line 793
    move-object/from16 v0, p3

    move-object/from16 v1, v28

    move/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lgnu/math/IntNum;->set([II)V

    .line 794
    if-eqz v11, :cond_21

    .line 799
    move-object/from16 v0, p1

    iget-object v8, v0, Lgnu/math/IntNum;->words:[I

    if-nez v8, :cond_1e

    .line 801
    move-object/from16 v20, p3

    .line 802
    .local v20, "tmp":Lgnu/math/IntNum;
    if-eqz v26, :cond_1d

    const/4 v8, 0x0

    aget v8, v28, v8

    move-object/from16 v0, p1

    iget v9, v0, Lgnu/math/IntNum;->ival:I

    add-int/2addr v8, v9

    :goto_b
    move-object/from16 v0, v20

    invoke-virtual {v0, v8}, Lgnu/math/IntNum;->set(I)V

    .line 810
    :goto_c
    if-eqz v21, :cond_20

    .line 811
    move-object/from16 v0, p3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lgnu/math/IntNum;->setNegative(Lgnu/math/IntNum;)V

    goto/16 :goto_0

    .line 747
    .end local v20    # "tmp":Lgnu/math/IntNum;
    :cond_14
    const/16 p4, 0x1

    goto :goto_8

    .line 755
    :pswitch_1
    const/4 v8, 0x1

    move/from16 v0, p4

    if-ne v0, v8, :cond_15

    const/4 v8, 0x1

    :goto_d
    move/from16 v0, v16

    if-ne v0, v8, :cond_11

    .line 756
    const/4 v11, 0x1

    goto :goto_9

    .line 755
    :cond_15
    const/4 v8, 0x0

    goto :goto_d

    .line 760
    :pswitch_2
    if-nez p3, :cond_19

    new-instance v20, Lgnu/math/IntNum;

    invoke-direct/range {v20 .. v20}, Lgnu/math/IntNum;-><init>()V

    .line 761
    .restart local v20    # "tmp":Lgnu/math/IntNum;
    :goto_e
    move-object/from16 v0, v20

    move-object/from16 v1, v28

    move/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lgnu/math/IntNum;->set([II)V

    .line 762
    const/4 v8, 0x1

    move-object/from16 v0, v20

    invoke-static {v0, v8}, Lgnu/math/IntNum;->shift(Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v20

    .line 763
    if-eqz v26, :cond_16

    .line 764
    invoke-virtual/range {v20 .. v20}, Lgnu/math/IntNum;->setNegative()V

    .line 765
    :cond_16
    move-object/from16 v0, v20

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lgnu/math/IntNum;->compare(Lgnu/math/IntNum;Lgnu/math/IntNum;)I

    move-result v12

    .line 767
    .local v12, "cmp":I
    if-eqz v26, :cond_17

    .line 768
    neg-int v12, v12

    .line 769
    :cond_17
    const/4 v8, 0x1

    if-eq v12, v8, :cond_18

    if-nez v12, :cond_1a

    const/4 v8, 0x0

    aget v8, v25, v8

    and-int/lit8 v8, v8, 0x1

    if-eqz v8, :cond_1a

    :cond_18
    const/4 v11, 0x1

    :goto_f
    goto/16 :goto_9

    .end local v12    # "cmp":I
    .end local v20    # "tmp":Lgnu/math/IntNum;
    :cond_19
    move-object/from16 v20, p3

    .line 760
    goto :goto_e

    .line 769
    .restart local v12    # "cmp":I
    .restart local v20    # "tmp":Lgnu/math/IntNum;
    :cond_1a
    const/4 v11, 0x0

    goto :goto_f

    .line 785
    .end local v12    # "cmp":I
    .end local v20    # "tmp":Lgnu/math/IntNum;
    :cond_1b
    invoke-virtual/range {p2 .. p2}, Lgnu/math/IntNum;->setNegative()V

    goto :goto_a

    .line 787
    :cond_1c
    if-eqz v11, :cond_13

    .line 788
    const/4 v8, 0x1

    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Lgnu/math/IntNum;->setAdd(I)V

    goto/16 :goto_a

    .line 802
    .restart local v20    # "tmp":Lgnu/math/IntNum;
    :cond_1d
    const/4 v8, 0x0

    aget v8, v28, v8

    move-object/from16 v0, p1

    iget v9, v0, Lgnu/math/IntNum;->ival:I

    sub-int/2addr v8, v9

    goto :goto_b

    .line 805
    .end local v20    # "tmp":Lgnu/math/IntNum;
    :cond_1e
    if-eqz v26, :cond_1f

    const/4 v8, 0x1

    :goto_10
    move-object/from16 v0, p3

    move-object/from16 v1, p1

    invoke-static {v0, v1, v8}, Lgnu/math/IntNum;->add(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v20

    .restart local v20    # "tmp":Lgnu/math/IntNum;
    goto :goto_c

    .end local v20    # "tmp":Lgnu/math/IntNum;
    :cond_1f
    const/4 v8, -0x1

    goto :goto_10

    .line 813
    .restart local v20    # "tmp":Lgnu/math/IntNum;
    :cond_20
    move-object/from16 v0, p3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lgnu/math/IntNum;->set(Lgnu/math/IntNum;)V

    goto/16 :goto_0

    .line 819
    .end local v20    # "tmp":Lgnu/math/IntNum;
    :cond_21
    if-eqz v21, :cond_2

    .line 820
    invoke-virtual/range {p3 .. p3}, Lgnu/math/IntNum;->setNegative()V

    goto/16 :goto_0

    .end local v11    # "add_one":Z
    .end local v17    # "qlen":I
    .end local v18    # "rlen":I
    .end local v23    # "xlen":I
    .restart local v15    # "nshift":I
    .restart local v24    # "xlen":I
    :cond_22
    move/from16 v23, v24

    .end local v24    # "xlen":I
    .restart local v23    # "xlen":I
    goto/16 :goto_6

    .line 749
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public static equals(Lgnu/math/IntNum;Lgnu/math/IntNum;)Z
    .locals 5
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1301
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    if-nez v3, :cond_2

    iget-object v3, p1, Lgnu/math/IntNum;->words:[I

    if-nez v3, :cond_2

    .line 1302
    iget v3, p0, Lgnu/math/IntNum;->ival:I

    iget v4, p1, Lgnu/math/IntNum;->ival:I

    if-ne v3, v4, :cond_1

    .line 1310
    :cond_0
    :goto_0
    return v1

    :cond_1
    move v1, v2

    .line 1302
    goto :goto_0

    .line 1303
    :cond_2
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    if-eqz v3, :cond_3

    iget-object v3, p1, Lgnu/math/IntNum;->words:[I

    if-eqz v3, :cond_3

    iget v3, p0, Lgnu/math/IntNum;->ival:I

    iget v4, p1, Lgnu/math/IntNum;->ival:I

    if-eq v3, v4, :cond_4

    :cond_3
    move v1, v2

    .line 1304
    goto :goto_0

    .line 1305
    :cond_4
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    .local v0, "i":I
    :cond_5
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_0

    .line 1307
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    aget v3, v3, v0

    iget-object v4, p1, Lgnu/math/IntNum;->words:[I

    aget v4, v4, v0

    if-eq v3, v4, :cond_5

    move v1, v2

    .line 1308
    goto :goto_0
.end method

.method public static final gcd(II)I
    .locals 2
    .param p0, "a"    # I
    .param p1, "b"    # I

    .prologue
    .line 934
    if-le p1, p0, :cond_0

    .line 936
    move v0, p0

    .local v0, "tmp":I
    move p0, p1

    move p1, v0

    .line 940
    .end local v0    # "tmp":I
    :cond_0
    :goto_0
    if-nez p1, :cond_1

    .line 943
    .end local p0    # "a":I
    :goto_1
    return p0

    .line 942
    .restart local p0    # "a":I
    :cond_1
    const/4 v1, 0x1

    if-ne p1, v1, :cond_2

    move p0, p1

    .line 943
    goto :goto_1

    .line 946
    :cond_2
    move v0, p1

    .line 947
    .restart local v0    # "tmp":I
    rem-int p1, p0, p1

    .line 948
    move p0, v0

    .line 949
    goto :goto_0
.end method

.method public static gcd(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 10
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    const/4 v9, 0x0

    const/high16 v8, -0x80000000

    .line 955
    iget v3, p0, Lgnu/math/IntNum;->ival:I

    .line 956
    .local v3, "xval":I
    iget v5, p1, Lgnu/math/IntNum;->ival:I

    .line 957
    .local v5, "yval":I
    iget-object v7, p0, Lgnu/math/IntNum;->words:[I

    if-nez v7, :cond_4

    .line 959
    if-nez v3, :cond_0

    .line 960
    invoke-static {p1}, Lgnu/math/IntNum;->abs(Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v7

    .line 991
    :goto_0
    return-object v7

    .line 961
    :cond_0
    iget-object v7, p1, Lgnu/math/IntNum;->words:[I

    if-nez v7, :cond_3

    if-eq v3, v8, :cond_3

    if-eq v5, v8, :cond_3

    .line 964
    if-gez v3, :cond_1

    .line 965
    neg-int v3, v3

    .line 966
    :cond_1
    if-gez v5, :cond_2

    .line 967
    neg-int v5, v5

    .line 968
    :cond_2
    invoke-static {v3, v5}, Lgnu/math/IntNum;->gcd(II)I

    move-result v7

    invoke-static {v7}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v7

    goto :goto_0

    .line 970
    :cond_3
    const/4 v3, 0x1

    .line 972
    :cond_4
    iget-object v7, p1, Lgnu/math/IntNum;->words:[I

    if-nez v7, :cond_6

    .line 974
    if-nez v5, :cond_5

    .line 975
    invoke-static {p0}, Lgnu/math/IntNum;->abs(Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v7

    goto :goto_0

    .line 976
    :cond_5
    const/4 v5, 0x1

    .line 978
    :cond_6
    if-le v3, v5, :cond_8

    move v0, v3

    .line 979
    .local v0, "len":I
    :goto_1
    new-array v4, v0, [I

    .line 980
    .local v4, "xwords":[I
    new-array v6, v0, [I

    .line 981
    .local v6, "ywords":[I
    invoke-virtual {p0, v4}, Lgnu/math/IntNum;->getAbsolute([I)V

    .line 982
    invoke-virtual {p1, v6}, Lgnu/math/IntNum;->getAbsolute([I)V

    .line 983
    invoke-static {v4, v6, v0}, Lgnu/math/MPN;->gcd([I[II)I

    move-result v0

    .line 984
    new-instance v2, Lgnu/math/IntNum;

    invoke-direct {v2, v9}, Lgnu/math/IntNum;-><init>(I)V

    .line 987
    .local v2, "result":Lgnu/math/IntNum;
    add-int/lit8 v7, v0, -0x1

    aget v7, v4, v7

    if-gez v7, :cond_7

    .line 988
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "len":I
    .local v1, "len":I
    aput v9, v4, v0

    move v0, v1

    .line 989
    .end local v1    # "len":I
    .restart local v0    # "len":I
    :cond_7
    iput v0, v2, Lgnu/math/IntNum;->ival:I

    .line 990
    iput-object v4, v2, Lgnu/math/IntNum;->words:[I

    .line 991
    invoke-virtual {v2}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object v7

    goto :goto_0

    .end local v0    # "len":I
    .end local v2    # "result":Lgnu/math/IntNum;
    .end local v4    # "xwords":[I
    .end local v6    # "ywords":[I
    :cond_8
    move v0, v5

    .line 978
    goto :goto_1
.end method

.method public static intValue(Ljava/lang/Object;)I
    .locals 3
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    .line 1277
    move-object v0, p0

    check-cast v0, Lgnu/math/IntNum;

    .line 1278
    .local v0, "inum":Lgnu/math/IntNum;
    iget-object v1, v0, Lgnu/math/IntNum;->words:[I

    if-eqz v1, :cond_0

    .line 1280
    new-instance v1, Ljava/lang/ClassCastException;

    const-string v2, "integer too large"

    invoke-direct {v1, v2}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1281
    :cond_0
    iget v1, v0, Lgnu/math/IntNum;->ival:I

    return v1
.end method

.method public static lcm(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 5
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 996
    invoke-virtual {p0}, Lgnu/math/IntNum;->isZero()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p1}, Lgnu/math/IntNum;->isZero()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 997
    :cond_0
    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v1

    .line 1002
    :goto_0
    return-object v1

    .line 998
    :cond_1
    invoke-static {p0}, Lgnu/math/IntNum;->abs(Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object p0

    .line 999
    invoke-static {p1}, Lgnu/math/IntNum;->abs(Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object p1

    .line 1000
    new-instance v0, Lgnu/math/IntNum;

    invoke-direct {v0}, Lgnu/math/IntNum;-><init>()V

    .line 1001
    .local v0, "quotient":Lgnu/math/IntNum;
    invoke-static {p0, p1}, Lgnu/math/IntNum;->times(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v1

    invoke-static {p0, p1}, Lgnu/math/IntNum;->gcd(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x3

    invoke-static {v1, v2, v0, v3, v4}, Lgnu/math/IntNum;->divide(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;I)V

    .line 1002
    invoke-virtual {v0}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object v1

    goto :goto_0
.end method

.method public static make(I)Lgnu/math/IntNum;
    .locals 2
    .param p0, "value"    # I

    .prologue
    .line 48
    const/16 v0, -0x64

    if-lt p0, v0, :cond_0

    const/16 v0, 0x400

    if-gt p0, v0, :cond_0

    .line 49
    sget-object v0, Lgnu/math/IntNum;->smallFixNums:[Lgnu/math/IntNum;

    add-int/lit8 v1, p0, 0x64

    aget-object v0, v0, v1

    .line 51
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lgnu/math/IntNum;

    invoke-direct {v0, p0}, Lgnu/math/IntNum;-><init>(I)V

    goto :goto_0
.end method

.method public static make(J)Lgnu/math/IntNum;
    .locals 6
    .param p0, "value"    # J

    .prologue
    const/4 v4, 0x2

    .line 78
    const-wide/16 v2, -0x64

    cmp-long v2, p0, v2

    if-ltz v2, :cond_0

    const-wide/16 v2, 0x400

    cmp-long v2, p0, v2

    if-gtz v2, :cond_0

    .line 79
    sget-object v2, Lgnu/math/IntNum;->smallFixNums:[Lgnu/math/IntNum;

    long-to-int v3, p0

    add-int/lit8 v3, v3, 0x64

    aget-object v1, v2, v3

    .line 87
    :goto_0
    return-object v1

    .line 80
    :cond_0
    long-to-int v0, p0

    .line 81
    .local v0, "i":I
    int-to-long v2, v0

    cmp-long v2, v2, p0

    if-nez v2, :cond_1

    .line 82
    new-instance v1, Lgnu/math/IntNum;

    invoke-direct {v1, v0}, Lgnu/math/IntNum;-><init>(I)V

    goto :goto_0

    .line 83
    :cond_1
    invoke-static {v4}, Lgnu/math/IntNum;->alloc(I)Lgnu/math/IntNum;

    move-result-object v1

    .line 84
    .local v1, "result":Lgnu/math/IntNum;
    iput v4, v1, Lgnu/math/IntNum;->ival:I

    .line 85
    iget-object v2, v1, Lgnu/math/IntNum;->words:[I

    const/4 v3, 0x0

    aput v0, v2, v3

    .line 86
    iget-object v2, v1, Lgnu/math/IntNum;->words:[I

    const/4 v3, 0x1

    const/16 v4, 0x20

    shr-long v4, p0, v4

    long-to-int v4, v4

    aput v4, v2, v3

    goto :goto_0
.end method

.method public static make([I)Lgnu/math/IntNum;
    .locals 1
    .param p0, "words"    # [I

    .prologue
    .line 133
    array-length v0, p0

    invoke-static {p0, v0}, Lgnu/math/IntNum;->make([II)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static make([II)Lgnu/math/IntNum;
    .locals 2
    .param p0, "words"    # [I
    .param p1, "len"    # I

    .prologue
    .line 120
    if-nez p0, :cond_0

    .line 121
    invoke-static {p1}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v1

    .line 128
    :goto_0
    return-object v1

    .line 122
    :cond_0
    invoke-static {p0, p1}, Lgnu/math/IntNum;->wordsNeeded([II)I

    move-result p1

    .line 123
    const/4 v1, 0x1

    if-gt p1, v1, :cond_2

    .line 124
    if-nez p1, :cond_1

    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v1

    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    aget v1, p0, v1

    invoke-static {v1}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v1

    goto :goto_0

    .line 125
    :cond_2
    new-instance v0, Lgnu/math/IntNum;

    invoke-direct {v0}, Lgnu/math/IntNum;-><init>()V

    .line 126
    .local v0, "num":Lgnu/math/IntNum;
    iput-object p0, v0, Lgnu/math/IntNum;->words:[I

    .line 127
    iput p1, v0, Lgnu/math/IntNum;->ival:I

    move-object v1, v0

    .line 128
    goto :goto_0
.end method

.method public static makeU(J)Lgnu/math/IntNum;
    .locals 6
    .param p0, "value"    # J

    .prologue
    const/4 v3, 0x3

    const/4 v5, 0x0

    .line 106
    const-wide/16 v1, 0x0

    cmp-long v1, p0, v1

    if-ltz v1, :cond_0

    .line 107
    invoke-static {p0, p1}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v0

    .line 113
    :goto_0
    return-object v0

    .line 108
    :cond_0
    invoke-static {v3}, Lgnu/math/IntNum;->alloc(I)Lgnu/math/IntNum;

    move-result-object v0

    .line 109
    .local v0, "result":Lgnu/math/IntNum;
    iput v3, v0, Lgnu/math/IntNum;->ival:I

    .line 110
    iget-object v1, v0, Lgnu/math/IntNum;->words:[I

    long-to-int v2, p0

    aput v2, v1, v5

    .line 111
    iget-object v1, v0, Lgnu/math/IntNum;->words:[I

    const/4 v2, 0x1

    const/16 v3, 0x20

    shr-long v3, p0, v3

    long-to-int v3, v3

    aput v3, v1, v2

    .line 112
    iget-object v1, v0, Lgnu/math/IntNum;->words:[I

    const/4 v2, 0x2

    aput v5, v1, v2

    goto :goto_0
.end method

.method public static minusOne()Lgnu/math/IntNum;
    .locals 2

    .prologue
    .line 72
    sget-object v0, Lgnu/math/IntNum;->smallFixNums:[Lgnu/math/IntNum;

    const/16 v1, 0x63

    aget-object v0, v0, v1

    return-object v0
.end method

.method public static modulo(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 863
    const/4 v0, 0x1

    invoke-static {p0, p1, v0}, Lgnu/math/IntNum;->remainder(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static neg(Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 3
    .param p0, "x"    # Lgnu/math/IntNum;

    .prologue
    .line 1616
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    if-nez v1, :cond_0

    iget v1, p0, Lgnu/math/IntNum;->ival:I

    const/high16 v2, -0x80000000

    if-eq v1, v2, :cond_0

    .line 1617
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    neg-int v1, v1

    invoke-static {v1}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v1

    .line 1620
    :goto_0
    return-object v1

    .line 1618
    :cond_0
    new-instance v0, Lgnu/math/IntNum;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lgnu/math/IntNum;-><init>(I)V

    .line 1619
    .local v0, "result":Lgnu/math/IntNum;
    invoke-virtual {v0, p0}, Lgnu/math/IntNum;->setNegative(Lgnu/math/IntNum;)V

    .line 1620
    invoke-virtual {v0}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object v1

    goto :goto_0
.end method

.method public static negate([I[II)Z
    .locals 10
    .param p0, "dest"    # [I
    .param p1, "src"    # [I
    .param p2, "len"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 1573
    const-wide/16 v0, 0x1

    .line 1574
    .local v0, "carry":J
    add-int/lit8 v6, p2, -0x1

    aget v6, p1, v6

    if-gez v6, :cond_0

    move v3, v4

    .line 1575
    .local v3, "negative":Z
    :goto_0
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, p2, :cond_1

    .line 1577
    aget v6, p1, v2

    xor-int/lit8 v6, v6, -0x1

    int-to-long v6, v6

    const-wide v8, 0xffffffffL

    and-long/2addr v6, v8

    add-long/2addr v0, v6

    .line 1578
    long-to-int v6, v0

    aput v6, p0, v2

    .line 1579
    const/16 v6, 0x20

    shr-long/2addr v0, v6

    .line 1575
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .end local v2    # "i":I
    .end local v3    # "negative":Z
    :cond_0
    move v3, v5

    .line 1574
    goto :goto_0

    .line 1581
    .restart local v2    # "i":I
    .restart local v3    # "negative":Z
    :cond_1
    if-eqz v3, :cond_2

    add-int/lit8 v6, p2, -0x1

    aget v6, p0, v6

    if-gez v6, :cond_2

    :goto_2
    return v4

    :cond_2
    move v4, v5

    goto :goto_2
.end method

.method public static final one()Lgnu/math/IntNum;
    .locals 2

    .prologue
    .line 61
    sget-object v0, Lgnu/math/IntNum;->smallFixNums:[Lgnu/math/IntNum;

    const/16 v1, 0x65

    aget-object v0, v0, v1

    return-object v0
.end method

.method public static power(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    .locals 12
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # I

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 885
    if-gtz p1, :cond_2

    .line 887
    if-nez p1, :cond_1

    .line 888
    invoke-static {}, Lgnu/math/IntNum;->one()Lgnu/math/IntNum;

    move-result-object p0

    .line 927
    .end local p0    # "x":Lgnu/math/IntNum;
    :cond_0
    :goto_0
    return-object p0

    .line 890
    .restart local p0    # "x":Lgnu/math/IntNum;
    :cond_1
    new-instance v8, Ljava/lang/Error;

    const-string v9, "negative exponent"

    invoke-direct {v8, v9}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v8

    .line 892
    :cond_2
    invoke-virtual {p0}, Lgnu/math/IntNum;->isZero()Z

    move-result v10

    if-nez v10, :cond_0

    .line 894
    iget-object v10, p0, Lgnu/math/IntNum;->words:[I

    if-nez v10, :cond_4

    move v2, v8

    .line 895
    .local v2, "plen":I
    :goto_1
    invoke-virtual {p0}, Lgnu/math/IntNum;->intLength()I

    move-result v10

    mul-int/2addr v10, p1

    shr-int/lit8 v10, v10, 0x5

    mul-int/lit8 v11, v2, 0x2

    add-int v0, v10, v11

    .line 896
    .local v0, "blen":I
    invoke-virtual {p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v10

    if-eqz v10, :cond_5

    and-int/lit8 v10, p1, 0x1

    if-eqz v10, :cond_5

    move v1, v8

    .line 897
    .local v1, "negative":Z
    :goto_2
    new-array v3, v0, [I

    .line 898
    .local v3, "pow2":[I
    new-array v5, v0, [I

    .line 899
    .local v5, "rwords":[I
    new-array v7, v0, [I

    .line 900
    .local v7, "work":[I
    invoke-virtual {p0, v3}, Lgnu/math/IntNum;->getAbsolute([I)V

    .line 901
    const/4 v4, 0x1

    .line 902
    .local v4, "rlen":I
    aput v8, v5, v9

    .line 907
    :cond_3
    and-int/lit8 v8, p1, 0x1

    if-eqz v8, :cond_6

    .line 909
    invoke-static {v7, v3, v2, v5, v4}, Lgnu/math/MPN;->mul([I[II[II)V

    .line 910
    move-object v6, v7

    .local v6, "temp":[I
    move-object v7, v5

    move-object v5, v6

    .line 911
    add-int/2addr v4, v2

    .line 912
    :goto_3
    add-int/lit8 v8, v4, -0x1

    aget v8, v5, v8

    if-nez v8, :cond_6

    add-int/lit8 v4, v4, -0x1

    goto :goto_3

    .line 894
    .end local v0    # "blen":I
    .end local v1    # "negative":Z
    .end local v2    # "plen":I
    .end local v3    # "pow2":[I
    .end local v4    # "rlen":I
    .end local v5    # "rwords":[I
    .end local v6    # "temp":[I
    .end local v7    # "work":[I
    :cond_4
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    goto :goto_1

    .restart local v0    # "blen":I
    .restart local v2    # "plen":I
    :cond_5
    move v1, v9

    .line 896
    goto :goto_2

    .line 914
    .restart local v1    # "negative":Z
    .restart local v3    # "pow2":[I
    .restart local v4    # "rlen":I
    .restart local v5    # "rwords":[I
    .restart local v7    # "work":[I
    :cond_6
    shr-int/lit8 p1, p1, 0x1

    .line 915
    if-nez p1, :cond_9

    .line 923
    add-int/lit8 v8, v4, -0x1

    aget v8, v5, v8

    if-gez v8, :cond_7

    .line 924
    add-int/lit8 v4, v4, 0x1

    .line 925
    :cond_7
    if-eqz v1, :cond_8

    .line 926
    invoke-static {v5, v5, v4}, Lgnu/math/IntNum;->negate([I[II)Z

    .line 927
    :cond_8
    invoke-static {v5, v4}, Lgnu/math/IntNum;->make([II)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0

    .line 918
    :cond_9
    invoke-static {v7, v3, v2, v3, v2}, Lgnu/math/MPN;->mul([I[II[II)V

    .line 919
    move-object v6, v7

    .restart local v6    # "temp":[I
    move-object v7, v3

    move-object v3, v6

    .line 920
    mul-int/lit8 v2, v2, 0x2

    .line 921
    :goto_4
    add-int/lit8 v8, v2, -0x1

    aget v8, v3, v8

    if-nez v8, :cond_3

    add-int/lit8 v2, v2, -0x1

    goto :goto_4
.end method

.method public static quotient(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 834
    const/4 v0, 0x3

    invoke-static {p0, p1, v0}, Lgnu/math/IntNum;->quotient(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static quotient(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    .locals 2
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;
    .param p2, "rounding_mode"    # I

    .prologue
    .line 827
    new-instance v0, Lgnu/math/IntNum;

    invoke-direct {v0}, Lgnu/math/IntNum;-><init>()V

    .line 828
    .local v0, "quotient":Lgnu/math/IntNum;
    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1, p2}, Lgnu/math/IntNum;->divide(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;I)V

    .line 829
    invoke-virtual {v0}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object v1

    return-object v1
.end method

.method public static remainder(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 858
    const/4 v0, 0x3

    invoke-static {p0, p1, v0}, Lgnu/math/IntNum;->remainder(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static remainder(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    .locals 2
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;
    .param p2, "rounding_mode"    # I

    .prologue
    .line 849
    invoke-virtual {p1}, Lgnu/math/IntNum;->isZero()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 853
    .end local p0    # "x":Lgnu/math/IntNum;
    :goto_0
    return-object p0

    .line 851
    .restart local p0    # "x":Lgnu/math/IntNum;
    :cond_0
    new-instance v0, Lgnu/math/IntNum;

    invoke-direct {v0}, Lgnu/math/IntNum;-><init>()V

    .line 852
    .local v0, "rem":Lgnu/math/IntNum;
    const/4 v1, 0x0

    invoke-static {p0, p1, v1, v0, p2}, Lgnu/math/IntNum;->divide(Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;Lgnu/math/IntNum;I)V

    .line 853
    invoke-virtual {v0}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0
.end method

.method public static shift(II)I
    .locals 2
    .param p0, "x"    # I
    .param p1, "count"    # I

    .prologue
    const/16 v1, 0x20

    const/4 v0, 0x0

    .line 1110
    if-lt p1, v1, :cond_1

    .line 1117
    :cond_0
    :goto_0
    return v0

    .line 1112
    :cond_1
    if-ltz p1, :cond_2

    .line 1113
    shl-int v0, p0, p1

    goto :goto_0

    .line 1114
    :cond_2
    neg-int p1, p1

    .line 1115
    if-lt p1, v1, :cond_3

    .line 1116
    if-gez p0, :cond_0

    const/4 v0, -0x1

    goto :goto_0

    .line 1117
    :cond_3
    shr-int v0, p0, p1

    goto :goto_0
.end method

.method public static shift(JI)J
    .locals 3
    .param p0, "x"    # J
    .param p2, "count"    # I

    .prologue
    const/16 v2, 0x20

    const-wide/16 v0, 0x0

    .line 1122
    if-lt p2, v2, :cond_1

    .line 1129
    :cond_0
    :goto_0
    return-wide v0

    .line 1124
    :cond_1
    if-ltz p2, :cond_2

    .line 1125
    shl-long v0, p0, p2

    goto :goto_0

    .line 1126
    :cond_2
    neg-int p2, p2

    .line 1127
    if-lt p2, v2, :cond_3

    .line 1128
    cmp-long v2, p0, v0

    if-gez v2, :cond_0

    const-wide/16 v0, -0x1

    goto :goto_0

    .line 1129
    :cond_3
    shr-long v0, p0, p2

    goto :goto_0
.end method

.method public static shift(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    .locals 3
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "count"    # I

    .prologue
    const/4 v1, 0x0

    .line 1094
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_4

    .line 1096
    if-gtz p1, :cond_3

    .line 1097
    const/16 v2, -0x20

    if-le p1, v2, :cond_2

    iget v1, p0, Lgnu/math/IntNum;->ival:I

    neg-int v2, p1

    shr-int/2addr v1, v2

    :cond_0
    :goto_0
    invoke-static {v1}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object p0

    .line 1105
    .end local p0    # "x":Lgnu/math/IntNum;
    :cond_1
    :goto_1
    return-object p0

    .line 1097
    .restart local p0    # "x":Lgnu/math/IntNum;
    :cond_2
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    if-gez v2, :cond_0

    const/4 v1, -0x1

    goto :goto_0

    .line 1098
    :cond_3
    const/16 v2, 0x20

    if-ge p1, v2, :cond_4

    .line 1099
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    int-to-long v1, v1

    shl-long/2addr v1, p1

    invoke-static {v1, v2}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_1

    .line 1101
    :cond_4
    if-eqz p1, :cond_1

    .line 1103
    new-instance v0, Lgnu/math/IntNum;

    invoke-direct {v0, v1}, Lgnu/math/IntNum;-><init>(I)V

    .line 1104
    .local v0, "result":Lgnu/math/IntNum;
    invoke-virtual {v0, p0, p1}, Lgnu/math/IntNum;->setShift(Lgnu/math/IntNum;I)V

    .line 1105
    invoke-virtual {v0}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_1
.end method

.method public static sub(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 424
    const/4 v0, -0x1

    invoke-static {p0, p1, v0}, Lgnu/math/IntNum;->add(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static final ten()Lgnu/math/IntNum;
    .locals 2

    .prologue
    .line 66
    sget-object v0, Lgnu/math/IntNum;->smallFixNums:[Lgnu/math/IntNum;

    const/16 v1, 0x6e

    aget-object v0, v0, v1

    return-object v0
.end method

.method public static final times(II)Lgnu/math/IntNum;
    .locals 4
    .param p0, "x"    # I
    .param p1, "y"    # I

    .prologue
    .line 469
    int-to-long v0, p0

    int-to-long v2, p1

    mul-long/2addr v0, v2

    invoke-static {v0, v1}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static final times(Lgnu/math/IntNum;I)Lgnu/math/IntNum;
    .locals 8
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # I

    .prologue
    const/4 v4, 0x1

    .line 474
    if-nez p1, :cond_1

    .line 475
    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object p0

    .line 501
    .end local p0    # "x":Lgnu/math/IntNum;
    :cond_0
    :goto_0
    return-object p0

    .line 476
    .restart local p0    # "x":Lgnu/math/IntNum;
    :cond_1
    if-eq p1, v4, :cond_0

    .line 478
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    .line 479
    .local v3, "xwords":[I
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    .line 480
    .local v2, "xlen":I
    if-nez v3, :cond_2

    .line 481
    int-to-long v4, v2

    int-to-long v6, p1

    mul-long/2addr v4, v6

    invoke-static {v4, v5}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0

    .line 483
    :cond_2
    add-int/lit8 v5, v2, 0x1

    invoke-static {v5}, Lgnu/math/IntNum;->alloc(I)Lgnu/math/IntNum;

    move-result-object v1

    .line 484
    .local v1, "result":Lgnu/math/IntNum;
    add-int/lit8 v5, v2, -0x1

    aget v5, v3, v5

    if-gez v5, :cond_5

    .line 486
    const/4 v0, 0x1

    .line 487
    .local v0, "negative":Z
    iget-object v5, v1, Lgnu/math/IntNum;->words:[I

    invoke-static {v5, v3, v2}, Lgnu/math/IntNum;->negate([I[II)Z

    .line 488
    iget-object v3, v1, Lgnu/math/IntNum;->words:[I

    .line 492
    :goto_1
    if-gez p1, :cond_3

    .line 494
    if-nez v0, :cond_6

    move v0, v4

    .line 495
    :goto_2
    neg-int p1, p1

    .line 497
    :cond_3
    iget-object v4, v1, Lgnu/math/IntNum;->words:[I

    iget-object v5, v1, Lgnu/math/IntNum;->words:[I

    invoke-static {v5, v3, v2, p1}, Lgnu/math/MPN;->mul_1([I[III)I

    move-result v5

    aput v5, v4, v2

    .line 498
    add-int/lit8 v4, v2, 0x1

    iput v4, v1, Lgnu/math/IntNum;->ival:I

    .line 499
    if-eqz v0, :cond_4

    .line 500
    invoke-virtual {v1}, Lgnu/math/IntNum;->setNegative()V

    .line 501
    :cond_4
    invoke-virtual {v1}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0

    .line 491
    .end local v0    # "negative":Z
    :cond_5
    const/4 v0, 0x0

    .restart local v0    # "negative":Z
    goto :goto_1

    .line 494
    :cond_6
    const/4 v0, 0x0

    goto :goto_2
.end method

.method public static final times(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;
    .locals 9
    .param p0, "x"    # Lgnu/math/IntNum;
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 506
    iget-object v8, p1, Lgnu/math/IntNum;->words:[I

    if-nez v8, :cond_0

    .line 507
    iget v8, p1, Lgnu/math/IntNum;->ival:I

    invoke-static {p0, v8}, Lgnu/math/IntNum;->times(Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v8

    .line 545
    :goto_0
    return-object v8

    .line 508
    :cond_0
    iget-object v8, p0, Lgnu/math/IntNum;->words:[I

    if-nez v8, :cond_1

    .line 509
    iget v8, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {p1, v8}, Lgnu/math/IntNum;->times(Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v8

    goto :goto_0

    .line 510
    :cond_1
    const/4 v0, 0x0

    .line 513
    .local v0, "negative":Z
    iget v4, p0, Lgnu/math/IntNum;->ival:I

    .line 514
    .local v4, "xlen":I
    iget v6, p1, Lgnu/math/IntNum;->ival:I

    .line 515
    .local v6, "ylen":I
    invoke-virtual {p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v8

    if-eqz v8, :cond_4

    .line 517
    const/4 v0, 0x1

    .line 518
    new-array v5, v4, [I

    .line 519
    .local v5, "xwords":[I
    iget-object v8, p0, Lgnu/math/IntNum;->words:[I

    invoke-static {v5, v8, v4}, Lgnu/math/IntNum;->negate([I[II)Z

    .line 526
    :goto_1
    invoke-virtual {p1}, Lgnu/math/IntNum;->isNegative()Z

    move-result v8

    if-eqz v8, :cond_6

    .line 528
    if-nez v0, :cond_5

    const/4 v0, 0x1

    .line 529
    :goto_2
    new-array v7, v6, [I

    .line 530
    .local v7, "ywords":[I
    iget-object v8, p1, Lgnu/math/IntNum;->words:[I

    invoke-static {v7, v8, v6}, Lgnu/math/IntNum;->negate([I[II)Z

    .line 535
    :goto_3
    if-ge v4, v6, :cond_2

    .line 537
    move-object v3, v5

    .local v3, "twords":[I
    move-object v5, v7

    move-object v7, v3

    .line 538
    move v2, v4

    .local v2, "tlen":I
    move v4, v6

    move v6, v2

    .line 540
    .end local v2    # "tlen":I
    .end local v3    # "twords":[I
    :cond_2
    add-int v8, v4, v6

    invoke-static {v8}, Lgnu/math/IntNum;->alloc(I)Lgnu/math/IntNum;

    move-result-object v1

    .line 541
    .local v1, "result":Lgnu/math/IntNum;
    iget-object v8, v1, Lgnu/math/IntNum;->words:[I

    invoke-static {v8, v5, v4, v7, v6}, Lgnu/math/MPN;->mul([I[II[II)V

    .line 542
    add-int v8, v4, v6

    iput v8, v1, Lgnu/math/IntNum;->ival:I

    .line 543
    if-eqz v0, :cond_3

    .line 544
    invoke-virtual {v1}, Lgnu/math/IntNum;->setNegative()V

    .line 545
    :cond_3
    invoke-virtual {v1}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object v8

    goto :goto_0

    .line 523
    .end local v1    # "result":Lgnu/math/IntNum;
    .end local v5    # "xwords":[I
    .end local v7    # "ywords":[I
    :cond_4
    const/4 v0, 0x0

    .line 524
    iget-object v5, p0, Lgnu/math/IntNum;->words:[I

    .restart local v5    # "xwords":[I
    goto :goto_1

    .line 528
    :cond_5
    const/4 v0, 0x0

    goto :goto_2

    .line 533
    :cond_6
    iget-object v7, p1, Lgnu/math/IntNum;->words:[I

    .restart local v7    # "ywords":[I
    goto :goto_3
.end method

.method public static valueOf(Ljava/lang/String;)Lgnu/math/IntNum;
    .locals 1
    .param p0, "s"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;
        }
    .end annotation

    .prologue
    .line 1401
    const/16 v0, 0xa

    invoke-static {p0, v0}, Lgnu/math/IntNum;->valueOf(Ljava/lang/String;I)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public static valueOf(Ljava/lang/String;I)Lgnu/math/IntNum;
    .locals 12
    .param p0, "s"    # Ljava/lang/String;
    .param p1, "radix"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NumberFormatException;
        }
    .end annotation

    .prologue
    const/16 v11, 0x2b

    const/4 v10, 0x1

    .line 1347
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v6

    .line 1350
    .local v6, "len":I
    add-int v8, v6, p1

    const/16 v9, 0x1c

    if-gt v8, v9, :cond_1

    .line 1353
    if-le v6, v10, :cond_0

    const/4 v8, 0x0

    invoke-virtual {p0, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    if-ne v8, v11, :cond_0

    invoke-virtual {p0, v10}, Ljava/lang/String;->charAt(I)C

    move-result v8

    invoke-static {v8, p1}, Ljava/lang/Character;->digit(CI)I

    move-result v8

    if-ltz v8, :cond_0

    .line 1355
    invoke-virtual {p0, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p0

    .line 1357
    :cond_0
    invoke-static {p0, p1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;I)J

    move-result-wide v8

    invoke-static {v8, v9}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v8

    .line 1380
    :goto_0
    return-object v8

    .line 1360
    :cond_1
    const/4 v0, 0x0

    .line 1361
    .local v0, "byte_len":I
    new-array v2, v6, [B

    .line 1362
    .local v2, "bytes":[B
    const/4 v7, 0x0

    .line 1363
    .local v7, "negative":Z
    const/4 v5, 0x0

    .local v5, "i":I
    move v1, v0

    .end local v0    # "byte_len":I
    .local v1, "byte_len":I
    :goto_1
    if-ge v5, v6, :cond_6

    .line 1365
    invoke-virtual {p0, v5}, Ljava/lang/String;->charAt(I)C

    move-result v3

    .line 1366
    .local v3, "ch":C
    const/16 v8, 0x2d

    if-ne v3, v8, :cond_2

    if-nez v5, :cond_2

    .line 1367
    const/4 v7, 0x1

    move v0, v1

    .line 1363
    .end local v1    # "byte_len":I
    .restart local v0    # "byte_len":I
    :goto_2
    add-int/lit8 v5, v5, 0x1

    move v1, v0

    .end local v0    # "byte_len":I
    .restart local v1    # "byte_len":I
    goto :goto_1

    .line 1368
    :cond_2
    if-ne v3, v11, :cond_3

    if-nez v5, :cond_3

    move v0, v1

    .line 1369
    .end local v1    # "byte_len":I
    .restart local v0    # "byte_len":I
    goto :goto_2

    .line 1370
    .end local v0    # "byte_len":I
    .restart local v1    # "byte_len":I
    :cond_3
    const/16 v8, 0x5f

    if-eq v3, v8, :cond_7

    if-nez v1, :cond_4

    const/16 v8, 0x20

    if-eq v3, v8, :cond_7

    const/16 v8, 0x9

    if-ne v3, v8, :cond_4

    move v0, v1

    .line 1371
    .end local v1    # "byte_len":I
    .restart local v0    # "byte_len":I
    goto :goto_2

    .line 1374
    .end local v0    # "byte_len":I
    .restart local v1    # "byte_len":I
    :cond_4
    invoke-static {v3, p1}, Ljava/lang/Character;->digit(CI)I

    move-result v4

    .line 1375
    .local v4, "digit":I
    if-gez v4, :cond_5

    .line 1376
    new-instance v8, Ljava/lang/NumberFormatException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "For input string: \""

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/16 v10, 0x22

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/NumberFormatException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 1377
    :cond_5
    add-int/lit8 v0, v1, 0x1

    .end local v1    # "byte_len":I
    .restart local v0    # "byte_len":I
    int-to-byte v8, v4

    aput-byte v8, v2, v1

    goto :goto_2

    .line 1380
    .end local v0    # "byte_len":I
    .end local v3    # "ch":C
    .end local v4    # "digit":I
    .restart local v1    # "byte_len":I
    :cond_6
    invoke-static {v2, v1, v7, p1}, Lgnu/math/IntNum;->valueOf([BIZI)Lgnu/math/IntNum;

    move-result-object v8

    goto :goto_0

    .restart local v3    # "ch":C
    :cond_7
    move v0, v1

    .end local v1    # "byte_len":I
    .restart local v0    # "byte_len":I
    goto :goto_2
.end method

.method public static valueOf([BIZI)Lgnu/math/IntNum;
    .locals 5
    .param p0, "digits"    # [B
    .param p1, "byte_len"    # I
    .param p2, "negative"    # Z
    .param p3, "radix"    # I

    .prologue
    .line 1386
    invoke-static {p3}, Lgnu/math/MPN;->chars_per_word(I)I

    move-result v0

    .line 1387
    .local v0, "chars_per_word":I
    div-int v4, p1, v0

    add-int/lit8 v4, v4, 0x1

    new-array v3, v4, [I

    .line 1388
    .local v3, "words":[I
    invoke-static {v3, p0, p1, p3}, Lgnu/math/MPN;->set_str([I[BII)I

    move-result v1

    .line 1389
    .local v1, "size":I
    if-nez v1, :cond_0

    .line 1390
    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v4

    .line 1395
    :goto_0
    return-object v4

    .line 1391
    :cond_0
    add-int/lit8 v4, v1, -0x1

    aget v4, v3, v4

    if-gez v4, :cond_1

    .line 1392
    add-int/lit8 v2, v1, 0x1

    .end local v1    # "size":I
    .local v2, "size":I
    const/4 v4, 0x0

    aput v4, v3, v1

    move v1, v2

    .line 1393
    .end local v2    # "size":I
    .restart local v1    # "size":I
    :cond_1
    if-eqz p2, :cond_2

    .line 1394
    invoke-static {v3, v3, v1}, Lgnu/math/IntNum;->negate([I[II)Z

    .line 1395
    :cond_2
    invoke-static {v3, v1}, Lgnu/math/IntNum;->make([II)Lgnu/math/IntNum;

    move-result-object v4

    goto :goto_0
.end method

.method public static valueOf([CIIIZ)Lgnu/math/IntNum;
    .locals 7
    .param p0, "buf"    # [C
    .param p1, "offset"    # I
    .param p2, "length"    # I
    .param p3, "radix"    # I
    .param p4, "negative"    # Z

    .prologue
    .line 1324
    const/4 v0, 0x0

    .line 1325
    .local v0, "byte_len":I
    new-array v2, p2, [B

    .line 1326
    .local v2, "bytes":[B
    const/4 v5, 0x0

    .local v5, "i":I
    move v1, v0

    .end local v0    # "byte_len":I
    .local v1, "byte_len":I
    :goto_0
    if-ge v5, p2, :cond_2

    .line 1328
    add-int v6, p1, v5

    aget-char v3, p0, v6

    .line 1329
    .local v3, "ch":C
    const/16 v6, 0x2d

    if-ne v3, v6, :cond_0

    .line 1330
    const/4 p4, 0x1

    move v0, v1

    .line 1326
    .end local v1    # "byte_len":I
    .restart local v0    # "byte_len":I
    :goto_1
    add-int/lit8 v5, v5, 0x1

    move v1, v0

    .end local v0    # "byte_len":I
    .restart local v1    # "byte_len":I
    goto :goto_0

    .line 1331
    :cond_0
    const/16 v6, 0x5f

    if-eq v3, v6, :cond_4

    if-nez v1, :cond_1

    const/16 v6, 0x20

    if-eq v3, v6, :cond_4

    const/16 v6, 0x9

    if-ne v3, v6, :cond_1

    move v0, v1

    .line 1332
    .end local v1    # "byte_len":I
    .restart local v0    # "byte_len":I
    goto :goto_1

    .line 1335
    .end local v0    # "byte_len":I
    .restart local v1    # "byte_len":I
    :cond_1
    invoke-static {v3, p3}, Ljava/lang/Character;->digit(CI)I

    move-result v4

    .line 1336
    .local v4, "digit":I
    if-gez v4, :cond_3

    .line 1341
    .end local v3    # "ch":C
    .end local v4    # "digit":I
    :cond_2
    invoke-static {v2, v1, p4, p3}, Lgnu/math/IntNum;->valueOf([BIZI)Lgnu/math/IntNum;

    move-result-object v6

    return-object v6

    .line 1338
    .restart local v3    # "ch":C
    .restart local v4    # "digit":I
    :cond_3
    add-int/lit8 v0, v1, 0x1

    .end local v1    # "byte_len":I
    .restart local v0    # "byte_len":I
    int-to-byte v6, v4

    aput-byte v6, v2, v1

    goto :goto_1

    .end local v0    # "byte_len":I
    .end local v4    # "digit":I
    .restart local v1    # "byte_len":I
    :cond_4
    move v0, v1

    .end local v1    # "byte_len":I
    .restart local v0    # "byte_len":I
    goto :goto_1
.end method

.method public static wordsNeeded([II)I
    .locals 4
    .param p0, "words"    # [I
    .param p1, "len"    # I

    .prologue
    const/4 v3, -0x1

    .line 289
    move v0, p1

    .line 290
    .local v0, "i":I
    if-lez v0, :cond_1

    .line 292
    add-int/lit8 v0, v0, -0x1

    aget v1, p0, v0

    .line 293
    .local v1, "word":I
    if-ne v1, v3, :cond_2

    .line 295
    :cond_0
    if-lez v0, :cond_1

    add-int/lit8 v2, v0, -0x1

    aget v1, p0, v2

    if-gez v1, :cond_1

    .line 297
    add-int/lit8 v0, v0, -0x1

    .line 298
    if-eq v1, v3, :cond_0

    .line 306
    .end local v1    # "word":I
    :cond_1
    add-int/lit8 v2, v0, 0x1

    return v2

    .line 303
    .restart local v1    # "word":I
    :cond_2
    :goto_0
    if-nez v1, :cond_1

    if-lez v0, :cond_1

    add-int/lit8 v2, v0, -0x1

    aget v1, p0, v2

    if-ltz v1, :cond_1

    add-int/lit8 v0, v0, -0x1

    goto :goto_0
.end method

.method public static final zero()Lgnu/math/IntNum;
    .locals 2

    .prologue
    .line 56
    sget-object v0, Lgnu/math/IntNum;->smallFixNums:[Lgnu/math/IntNum;

    const/16 v1, 0x64

    aget-object v0, v0, v1

    return-object v0
.end method


# virtual methods
.method public add(Ljava/lang/Object;I)Lgnu/math/Numeric;
    .locals 1
    .param p1, "y"    # Ljava/lang/Object;
    .param p2, "k"    # I

    .prologue
    .line 1514
    instance-of v0, p1, Lgnu/math/IntNum;

    if-eqz v0, :cond_0

    .line 1515
    check-cast p1, Lgnu/math/IntNum;

    .end local p1    # "y":Ljava/lang/Object;
    invoke-static {p0, p1, p2}, Lgnu/math/IntNum;->add(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v0

    .line 1518
    :goto_0
    return-object v0

    .line 1516
    .restart local p1    # "y":Ljava/lang/Object;
    :cond_0
    instance-of v0, p1, Lgnu/math/Numeric;

    if-nez v0, :cond_1

    .line 1517
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 1518
    :cond_1
    check-cast p1, Lgnu/math/Numeric;

    .end local p1    # "y":Ljava/lang/Object;
    invoke-virtual {p1, p0, p2}, Lgnu/math/Numeric;->addReversed(Lgnu/math/Numeric;I)Lgnu/math/Numeric;

    move-result-object v0

    goto :goto_0
.end method

.method public asBigDecimal()Ljava/math/BigDecimal;
    .locals 2

    .prologue
    .line 1705
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    .line 1706
    new-instance v0, Ljava/math/BigDecimal;

    iget v1, p0, Lgnu/math/IntNum;->ival:I

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(I)V

    .line 1709
    :goto_0
    return-object v0

    .line 1707
    :cond_0
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    const/4 v1, 0x2

    if-gt v0, v1, :cond_1

    .line 1708
    invoke-virtual {p0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/math/BigDecimal;->valueOf(J)Ljava/math/BigDecimal;

    move-result-object v0

    goto :goto_0

    .line 1709
    :cond_1
    new-instance v0, Ljava/math/BigDecimal;

    invoke-virtual {p0}, Lgnu/math/IntNum;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public asBigInteger()Ljava/math/BigInteger;
    .locals 2

    .prologue
    .line 1698
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-eqz v0, :cond_0

    iget v0, p0, Lgnu/math/IntNum;->ival:I

    const/4 v1, 0x2

    if-gt v0, v1, :cond_1

    .line 1699
    :cond_0
    invoke-virtual {p0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/math/BigInteger;->valueOf(J)Ljava/math/BigInteger;

    move-result-object v0

    .line 1700
    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Ljava/math/BigInteger;

    invoke-virtual {p0}, Lgnu/math/IntNum;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/math/BigInteger;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public canonicalize()Lgnu/math/IntNum;
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 311
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-eqz v0, :cond_1

    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    iget v1, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v0, v1}, Lgnu/math/IntNum;->wordsNeeded([II)I

    move-result v0

    iput v0, p0, Lgnu/math/IntNum;->ival:I

    if-gt v0, v2, :cond_1

    .line 314
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    if-ne v0, v2, :cond_0

    .line 315
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    const/4 v1, 0x0

    aget v0, v0, v1

    iput v0, p0, Lgnu/math/IntNum;->ival:I

    .line 316
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lgnu/math/IntNum;->words:[I

    .line 318
    :cond_1
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_2

    iget v0, p0, Lgnu/math/IntNum;->ival:I

    const/16 v1, -0x64

    if-lt v0, v1, :cond_2

    iget v0, p0, Lgnu/math/IntNum;->ival:I

    const/16 v1, 0x400

    if-gt v0, v1, :cond_2

    .line 319
    sget-object v0, Lgnu/math/IntNum;->smallFixNums:[Lgnu/math/IntNum;

    iget v1, p0, Lgnu/math/IntNum;->ival:I

    add-int/lit8 v1, v1, 0x64

    aget-object p0, v0, v1

    .line 320
    .end local p0    # "this":Lgnu/math/IntNum;
    :cond_2
    return-object p0
.end method

.method checkBits(I)Z
    .locals 5
    .param p1, "n"    # I

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 1420
    if-gtz p1, :cond_1

    .line 1428
    :cond_0
    :goto_0
    return v1

    .line 1422
    :cond_1
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    if-nez v3, :cond_3

    .line 1423
    const/16 v3, 0x1f

    if-gt p1, v3, :cond_2

    iget v3, p0, Lgnu/math/IntNum;->ival:I

    shl-int v4, v2, p1

    add-int/lit8 v4, v4, -0x1

    and-int/2addr v3, v4

    if-eqz v3, :cond_0

    :cond_2
    move v1, v2

    goto :goto_0

    .line 1425
    :cond_3
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    shr-int/lit8 v3, p1, 0x5

    if-ge v0, v3, :cond_5

    .line 1426
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    aget v3, v3, v0

    if-eqz v3, :cond_4

    move v1, v2

    .line 1427
    goto :goto_0

    .line 1425
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 1428
    :cond_5
    and-int/lit8 v3, p1, 0x1f

    if-eqz v3, :cond_6

    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    aget v3, v3, v0

    and-int/lit8 v4, p1, 0x1f

    shl-int v4, v2, v4

    add-int/lit8 v4, v4, -0x1

    and-int/2addr v3, v4

    if-eqz v3, :cond_6

    :goto_2
    move v1, v2

    goto :goto_0

    :cond_6
    move v2, v1

    goto :goto_2
.end method

.method public compare(Ljava/lang/Object;)I
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 257
    instance-of v0, p1, Lgnu/math/IntNum;

    if-eqz v0, :cond_0

    .line 258
    check-cast p1, Lgnu/math/IntNum;

    .end local p1    # "obj":Ljava/lang/Object;
    invoke-static {p0, p1}, Lgnu/math/IntNum;->compare(Lgnu/math/IntNum;Lgnu/math/IntNum;)I

    move-result v0

    .line 259
    :goto_0
    return v0

    .restart local p1    # "obj":Ljava/lang/Object;
    :cond_0
    check-cast p1, Lgnu/math/RealNum;

    .end local p1    # "obj":Ljava/lang/Object;
    invoke-virtual {p1, p0}, Lgnu/math/RealNum;->compareReversed(Lgnu/math/Numeric;)I

    move-result v0

    goto :goto_0
.end method

.method public final denominator()Lgnu/math/IntNum;
    .locals 1

    .prologue
    .line 188
    invoke-static {}, Lgnu/math/IntNum;->one()Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public div(Ljava/lang/Object;)Lgnu/math/Numeric;
    .locals 3
    .param p1, "y"    # Ljava/lang/Object;

    .prologue
    .line 1532
    instance-of v1, p1, Lgnu/math/RatNum;

    if-eqz v1, :cond_0

    move-object v0, p1

    .line 1534
    check-cast v0, Lgnu/math/RatNum;

    .line 1535
    .local v0, "r":Lgnu/math/RatNum;
    invoke-virtual {v0}, Lgnu/math/RatNum;->denominator()Lgnu/math/IntNum;

    move-result-object v1

    invoke-static {p0, v1}, Lgnu/math/IntNum;->times(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v1

    invoke-virtual {v0}, Lgnu/math/RatNum;->numerator()Lgnu/math/IntNum;

    move-result-object v2

    invoke-static {v1, v2}, Lgnu/math/RatNum;->make(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/RatNum;

    move-result-object v1

    .line 1540
    .end local v0    # "r":Lgnu/math/RatNum;
    .end local p1    # "y":Ljava/lang/Object;
    :goto_0
    return-object v1

    .line 1538
    .restart local p1    # "y":Ljava/lang/Object;
    :cond_0
    instance-of v1, p1, Lgnu/math/Numeric;

    if-nez v1, :cond_1

    .line 1539
    new-instance v1, Ljava/lang/IllegalArgumentException;

    invoke-direct {v1}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v1

    .line 1540
    :cond_1
    check-cast p1, Lgnu/math/Numeric;

    .end local p1    # "y":Ljava/lang/Object;
    invoke-virtual {p1, p0}, Lgnu/math/Numeric;->divReversed(Lgnu/math/Numeric;)Lgnu/math/Numeric;

    move-result-object v1

    goto :goto_0
.end method

.method public doubleValue()D
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 1406
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    .line 1407
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    int-to-double v0, v0

    .line 1413
    :goto_0
    return-wide v0

    .line 1408
    :cond_0
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    const/4 v1, 0x2

    if-gt v0, v1, :cond_1

    .line 1409
    invoke-virtual {p0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v0

    long-to-double v0, v0

    goto :goto_0

    .line 1410
    :cond_1
    invoke-virtual {p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1411
    invoke-static {p0}, Lgnu/math/IntNum;->neg(Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v2, v1, v2}, Lgnu/math/IntNum;->roundToDouble(IZZ)D

    move-result-wide v0

    goto :goto_0

    .line 1413
    :cond_2
    invoke-virtual {p0, v2, v2, v2}, Lgnu/math/IntNum;->roundToDouble(IZZ)D

    move-result-wide v0

    goto :goto_0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 1316
    if-eqz p1, :cond_0

    instance-of v0, p1, Lgnu/math/IntNum;

    if-nez v0, :cond_1

    .line 1317
    :cond_0
    const/4 v0, 0x0

    .line 1318
    .end local p1    # "obj":Ljava/lang/Object;
    :goto_0
    return v0

    .restart local p1    # "obj":Ljava/lang/Object;
    :cond_1
    check-cast p1, Lgnu/math/IntNum;

    .end local p1    # "obj":Ljava/lang/Object;
    invoke-static {p0, p1}, Lgnu/math/IntNum;->equals(Lgnu/math/IntNum;Lgnu/math/IntNum;)Z

    move-result v0

    goto :goto_0
.end method

.method public format(ILjava/lang/StringBuffer;)V
    .locals 2
    .param p1, "radix"    # I
    .param p2, "buffer"    # Ljava/lang/StringBuffer;

    .prologue
    .line 1135
    const/16 v0, 0xa

    if-ne p1, v0, :cond_1

    .line 1137
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    .line 1139
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    invoke-virtual {p2, v0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 1149
    :goto_0
    return-void

    .line 1142
    :cond_0
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    const/4 v1, 0x2

    if-gt v0, v1, :cond_1

    .line 1144
    invoke-virtual {p0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v0

    invoke-virtual {p2, v0, v1}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 1148
    :cond_1
    invoke-virtual {p0, p1}, Lgnu/math/IntNum;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public format(ILjava/lang/StringBuilder;)V
    .locals 24
    .param p1, "radix"    # I
    .param p2, "buffer"    # Ljava/lang/StringBuilder;

    .prologue
    .line 1160
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/math/IntNum;->words:[I

    move-object/from16 v20, v0

    if-nez v20, :cond_2

    .line 1162
    const/16 v20, 0xa

    move/from16 v0, p1

    move/from16 v1, v20

    if-ne v0, v1, :cond_1

    .line 1163
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/math/IntNum;->ival:I

    move/from16 v20, v0

    move-object/from16 v0, p2

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 1249
    :cond_0
    :goto_0
    return-void

    .line 1165
    :cond_1
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/math/IntNum;->ival:I

    move/from16 v20, v0

    move/from16 v0, v20

    move/from16 v1, p1

    invoke-static {v0, v1}, Ljava/lang/Integer;->toString(II)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, p2

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 1167
    :cond_2
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/math/IntNum;->ival:I

    move/from16 v20, v0

    const/16 v21, 0x2

    move/from16 v0, v20

    move/from16 v1, v21

    if-gt v0, v1, :cond_4

    .line 1169
    invoke-virtual/range {p0 .. p0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v12

    .line 1170
    .local v12, "lval":J
    const/16 v20, 0xa

    move/from16 v0, p1

    move/from16 v1, v20

    if-ne v0, v1, :cond_3

    .line 1171
    move-object/from16 v0, p2

    invoke-virtual {v0, v12, v13}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 1173
    :cond_3
    move/from16 v0, p1

    invoke-static {v12, v13, v0}, Ljava/lang/Long;->toString(JI)Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, p2

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 1177
    .end local v12    # "lval":J
    :cond_4
    invoke-virtual/range {p0 .. p0}, Lgnu/math/IntNum;->isNegative()Z

    move-result v14

    .line 1179
    .local v14, "neg":Z
    if-nez v14, :cond_5

    const/16 v20, 0x10

    move/from16 v0, p1

    move/from16 v1, v20

    if-eq v0, v1, :cond_a

    .line 1181
    :cond_5
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/math/IntNum;->ival:I

    move/from16 v20, v0

    move/from16 v0, v20

    new-array v0, v0, [I

    move-object/from16 v18, v0

    .line 1182
    .local v18, "work":[I
    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lgnu/math/IntNum;->getAbsolute([I)V

    .line 1186
    :goto_1
    move-object/from16 v0, p0

    iget v11, v0, Lgnu/math/IntNum;->ival:I

    .line 1188
    .local v11, "len":I
    const/16 v20, 0x10

    move/from16 v0, p1

    move/from16 v1, v20

    if-ne v0, v1, :cond_b

    .line 1190
    if-eqz v14, :cond_6

    .line 1191
    const/16 v20, 0x2d

    move-object/from16 v0, p2

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1192
    :cond_6
    invoke-virtual/range {p2 .. p2}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    .line 1193
    .local v3, "buf_start":I
    move v7, v11

    .local v7, "i":I
    :cond_7
    add-int/lit8 v7, v7, -0x1

    if-ltz v7, :cond_0

    .line 1195
    aget v17, v18, v7

    .line 1196
    .local v17, "word":I
    const/16 v8, 0x8

    .local v8, "j":I
    :cond_8
    :goto_2
    add-int/lit8 v8, v8, -0x1

    if-ltz v8, :cond_7

    .line 1198
    mul-int/lit8 v20, v8, 0x4

    shr-int v20, v17, v20

    and-int/lit8 v6, v20, 0xf

    .line 1200
    .local v6, "hex_digit":I
    if-gtz v6, :cond_9

    invoke-virtual/range {p2 .. p2}, Ljava/lang/StringBuilder;->length()I

    move-result v20

    move/from16 v0, v20

    if-le v0, v3, :cond_8

    .line 1201
    :cond_9
    const/16 v20, 0x10

    move/from16 v0, v20

    invoke-static {v6, v0}, Ljava/lang/Character;->forDigit(II)C

    move-result v20

    move-object/from16 v0, p2

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_2

    .line 1185
    .end local v3    # "buf_start":I
    .end local v6    # "hex_digit":I
    .end local v7    # "i":I
    .end local v8    # "j":I
    .end local v11    # "len":I
    .end local v17    # "word":I
    .end local v18    # "work":[I
    :cond_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/math/IntNum;->words:[I

    move-object/from16 v18, v0

    .restart local v18    # "work":[I
    goto :goto_1

    .line 1207
    .restart local v11    # "len":I
    :cond_b
    invoke-static/range {p1 .. p1}, Lgnu/math/MPN;->chars_per_word(I)I

    move-result v4

    .line 1208
    .local v4, "chars_per_word":I
    move/from16 v19, p1

    .line 1209
    .local v19, "wradix":I
    move v8, v4

    .restart local v8    # "j":I
    :goto_3
    add-int/lit8 v8, v8, -0x1

    if-lez v8, :cond_c

    .line 1210
    mul-int v19, v19, p1

    goto :goto_3

    .line 1211
    :cond_c
    invoke-virtual/range {p2 .. p2}, Ljava/lang/StringBuilder;->length()I

    move-result v7

    .line 1214
    .restart local v7    # "i":I
    :cond_d
    move-object/from16 v0, v18

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-static {v0, v1, v11, v2}, Lgnu/math/MPN;->divmod_1([I[III)I

    move-result v16

    .line 1215
    .local v16, "wdigit":I
    :goto_4
    if-lez v11, :cond_e

    add-int/lit8 v20, v11, -0x1

    aget v20, v18, v20

    if-nez v20, :cond_e

    add-int/lit8 v11, v11, -0x1

    goto :goto_4

    .line 1216
    :cond_e
    move v8, v4

    :goto_5
    add-int/lit8 v8, v8, -0x1

    if-ltz v8, :cond_f

    .line 1218
    if-nez v11, :cond_11

    if-nez v16, :cond_11

    .line 1233
    :cond_f
    if-nez v11, :cond_d

    .line 1236
    if-eqz v14, :cond_10

    .line 1237
    const/16 v20, 0x2d

    move-object/from16 v0, p2

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 1239
    :cond_10
    invoke-virtual/range {p2 .. p2}, Ljava/lang/StringBuilder;->length()I

    move-result v20

    add-int/lit8 v8, v20, -0x1

    .line 1240
    :goto_6
    if-ge v7, v8, :cond_0

    .line 1242
    move-object/from16 v0, p2

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v15

    .line 1243
    .local v15, "tmp":C
    move-object/from16 v0, p2

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->charAt(I)C

    move-result v20

    move-object/from16 v0, p2

    move/from16 v1, v20

    invoke-virtual {v0, v7, v1}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    .line 1244
    move-object/from16 v0, p2

    invoke-virtual {v0, v8, v15}, Ljava/lang/StringBuilder;->setCharAt(IC)V

    .line 1245
    add-int/lit8 v7, v7, 0x1

    add-int/lit8 v8, v8, -0x1

    .line 1246
    goto :goto_6

    .line 1220
    .end local v15    # "tmp":C
    :cond_11
    if-gez v16, :cond_12

    .line 1222
    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v20, v0

    const-wide/16 v22, -0x1

    and-long v9, v20, v22

    .line 1223
    .local v9, "ldigit":J
    move/from16 v0, p1

    int-to-long v0, v0

    move-wide/from16 v20, v0

    rem-long v20, v9, v20

    move-wide/from16 v0, v20

    long-to-int v5, v0

    .line 1224
    .local v5, "digit":I
    div-int v16, v16, p1

    .line 1231
    .end local v9    # "ldigit":J
    :goto_7
    move/from16 v0, p1

    invoke-static {v5, v0}, Ljava/lang/Character;->forDigit(II)C

    move-result v20

    move-object/from16 v0, p2

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    goto :goto_5

    .line 1228
    .end local v5    # "digit":I
    :cond_12
    rem-int v5, v16, p1

    .line 1229
    .restart local v5    # "digit":I
    div-int v16, v16, p1

    goto :goto_7
.end method

.method public getAbsolute([I)V
    .locals 4
    .param p1, "words"    # [I

    .prologue
    const/4 v3, 0x0

    .line 1551
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_2

    .line 1553
    const/4 v1, 0x1

    .line 1554
    .local v1, "len":I
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    aput v2, p1, v3

    .line 1562
    :cond_0
    add-int/lit8 v2, v1, -0x1

    aget v2, p1, v2

    if-gez v2, :cond_1

    .line 1563
    invoke-static {p1, p1, v1}, Lgnu/math/IntNum;->negate([I[II)Z

    .line 1564
    :cond_1
    array-length v0, p1

    .local v0, "i":I
    :goto_0
    add-int/lit8 v0, v0, -0x1

    if-le v0, v1, :cond_3

    .line 1565
    aput v3, p1, v0

    goto :goto_0

    .line 1558
    .end local v0    # "i":I
    .end local v1    # "len":I
    :cond_2
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    .line 1559
    .restart local v1    # "len":I
    move v0, v1

    .restart local v0    # "i":I
    :goto_1
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_0

    .line 1560
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v2, v2, v0

    aput v2, p1, v0

    goto :goto_1

    .line 1566
    :cond_3
    return-void
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 1295
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    iget v0, p0, Lgnu/math/IntNum;->ival:I

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    const/4 v1, 0x0

    aget v0, v0, v1

    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    iget v2, p0, Lgnu/math/IntNum;->ival:I

    add-int/lit8 v2, v2, -0x1

    aget v1, v1, v2

    add-int/2addr v0, v1

    goto :goto_0
.end method

.method public inIntRange()Z
    .locals 4

    .prologue
    .line 1721
    const-wide/32 v0, -0x80000000

    const-wide/32 v2, 0x7fffffff

    invoke-virtual {p0, v0, v1, v2, v3}, Lgnu/math/IntNum;->inRange(JJ)Z

    move-result v0

    return v0
.end method

.method public inLongRange()Z
    .locals 4

    .prologue
    .line 1727
    const-wide/high16 v0, -0x8000000000000000L

    const-wide v2, 0x7fffffffffffffffL

    invoke-virtual {p0, v0, v1, v2, v3}, Lgnu/math/IntNum;->inRange(JJ)Z

    move-result v0

    return v0
.end method

.method public inRange(JJ)Z
    .locals 1
    .param p1, "lo"    # J
    .param p3, "hi"    # J

    .prologue
    .line 1715
    invoke-static {p0, p1, p2}, Lgnu/math/IntNum;->compare(Lgnu/math/IntNum;J)I

    move-result v0

    if-ltz v0, :cond_0

    invoke-static {p0, p3, p4}, Lgnu/math/IntNum;->compare(Lgnu/math/IntNum;J)I

    move-result v0

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public intLength()I
    .locals 2

    .prologue
    .line 1633
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    .line 1634
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v0}, Lgnu/math/MPN;->intLength(I)I

    move-result v0

    .line 1636
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    iget v1, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v0, v1}, Lgnu/math/MPN;->intLength([II)I

    move-result v0

    goto :goto_0
.end method

.method public intValue()I
    .locals 2

    .prologue
    .line 1269
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    .line 1270
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    .line 1271
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    const/4 v1, 0x0

    aget v0, v0, v1

    goto :goto_0
.end method

.method public final isMinusOne()Z
    .locals 2

    .prologue
    .line 280
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    iget v0, p0, Lgnu/math/IntNum;->ival:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final isNegative()Z
    .locals 2

    .prologue
    .line 193
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    iget v0, p0, Lgnu/math/IntNum;->ival:I

    :goto_0
    if-gez v0, :cond_1

    const/4 v0, 0x1

    :goto_1
    return v0

    :cond_0
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    iget v1, p0, Lgnu/math/IntNum;->ival:I

    add-int/lit8 v1, v1, -0x1

    aget v0, v0, v1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public final isOdd()Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 264
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_1

    iget v0, p0, Lgnu/math/IntNum;->ival:I

    .line 265
    .local v0, "low":I
    :goto_0
    and-int/lit8 v2, v0, 0x1

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    :cond_0
    return v1

    .line 264
    .end local v0    # "low":I
    :cond_1
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v0, v2, v1

    goto :goto_0
.end method

.method public final isOne()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 275
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    if-nez v1, :cond_0

    iget v1, p0, Lgnu/math/IntNum;->ival:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final isZero()Z
    .locals 1

    .prologue
    .line 270
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    iget v0, p0, Lgnu/math/IntNum;->ival:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public longValue()J
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v3, 0x0

    .line 1286
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_0

    .line 1287
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    int-to-long v0, v0

    .line 1290
    :goto_0
    return-wide v0

    .line 1288
    :cond_0
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    if-ne v0, v1, :cond_1

    .line 1289
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    aget v0, v0, v3

    int-to-long v0, v0

    goto :goto_0

    .line 1290
    :cond_1
    iget-object v0, p0, Lgnu/math/IntNum;->words:[I

    aget v0, v0, v1

    int-to-long v0, v0

    const/16 v2, 0x20

    shl-long/2addr v0, v2

    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v2, v2, v3

    int-to-long v2, v2

    const-wide v4, 0xffffffffL

    and-long/2addr v2, v4

    add-long/2addr v0, v2

    goto :goto_0
.end method

.method public mul(Ljava/lang/Object;)Lgnu/math/Numeric;
    .locals 1
    .param p1, "y"    # Ljava/lang/Object;

    .prologue
    .line 1523
    instance-of v0, p1, Lgnu/math/IntNum;

    if-eqz v0, :cond_0

    .line 1524
    check-cast p1, Lgnu/math/IntNum;

    .end local p1    # "y":Ljava/lang/Object;
    invoke-static {p0, p1}, Lgnu/math/IntNum;->times(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v0

    .line 1527
    :goto_0
    return-object v0

    .line 1525
    .restart local p1    # "y":Ljava/lang/Object;
    :cond_0
    instance-of v0, p1, Lgnu/math/Numeric;

    if-nez v0, :cond_1

    .line 1526
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0

    .line 1527
    :cond_1
    check-cast p1, Lgnu/math/Numeric;

    .end local p1    # "y":Ljava/lang/Object;
    invoke-virtual {p1, p0}, Lgnu/math/Numeric;->mulReversed(Lgnu/math/Numeric;)Lgnu/math/Numeric;

    move-result-object v0

    goto :goto_0
.end method

.method public neg()Lgnu/math/Numeric;
    .locals 1

    .prologue
    .line 1625
    invoke-static {p0}, Lgnu/math/IntNum;->neg(Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public final numerator()Lgnu/math/IntNum;
    .locals 0

    .prologue
    .line 183
    return-object p0
.end method

.method public power(Lgnu/math/IntNum;)Lgnu/math/Numeric;
    .locals 1
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    .line 868
    invoke-virtual {p0}, Lgnu/math/IntNum;->isOne()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 876
    .end local p0    # "this":Lgnu/math/IntNum;
    :cond_0
    :goto_0
    return-object p0

    .line 870
    .restart local p0    # "this":Lgnu/math/IntNum;
    :cond_1
    invoke-virtual {p0}, Lgnu/math/IntNum;->isMinusOne()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 871
    invoke-virtual {p1}, Lgnu/math/IntNum;->isOdd()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lgnu/math/IntNum;->one()Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0

    .line 872
    :cond_2
    iget-object v0, p1, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_3

    iget v0, p1, Lgnu/math/IntNum;->ival:I

    if-ltz v0, :cond_3

    .line 873
    iget v0, p1, Lgnu/math/IntNum;->ival:I

    invoke-static {p0, v0}, Lgnu/math/IntNum;->power(Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object p0

    goto :goto_0

    .line 874
    :cond_3
    invoke-virtual {p0}, Lgnu/math/IntNum;->isZero()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 875
    invoke-virtual {p1}, Lgnu/math/IntNum;->isNegative()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, -0x1

    invoke-static {v0}, Lgnu/math/RatNum;->infinity(I)Lgnu/math/RatNum;

    move-result-object p0

    goto :goto_0

    .line 876
    :cond_4
    invoke-super {p0, p1}, Lgnu/math/RatNum;->power(Lgnu/math/IntNum;)Lgnu/math/Numeric;

    move-result-object p0

    goto :goto_0
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
    .line 1674
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    .line 1675
    .local v0, "i":I
    const/high16 v3, -0x40000000    # -2.0f

    if-gt v0, v3, :cond_0

    .line 1677
    const v3, 0x7fffffff

    and-int/2addr v0, v3

    .line 1678
    const/4 v3, 0x1

    if-ne v0, v3, :cond_1

    .line 1679
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    .line 1688
    :cond_0
    :goto_0
    iput v0, p0, Lgnu/math/IntNum;->ival:I

    .line 1689
    return-void

    .line 1682
    :cond_1
    new-array v2, v0, [I

    .line 1683
    .local v2, "w":[I
    move v1, v0

    .local v1, "j":I
    :goto_1
    add-int/lit8 v1, v1, -0x1

    if-ltz v1, :cond_2

    .line 1684
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v3

    aput v3, v2, v1

    goto :goto_1

    .line 1685
    :cond_2
    iput-object v2, p0, Lgnu/math/IntNum;->words:[I

    goto :goto_0
.end method

.method public readResolve()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/ObjectStreamException;
        }
    .end annotation

    .prologue
    .line 1693
    invoke-virtual {p0}, Lgnu/math/IntNum;->canonicalize()Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method

.method public realloc(I)V
    .locals 4
    .param p1, "nwords"    # I

    .prologue
    const/4 v3, 0x0

    .line 152
    if-nez p1, :cond_2

    .line 154
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    if-eqz v1, :cond_1

    .line 156
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    if-lez v1, :cond_0

    .line 157
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    aget v1, v1, v3

    iput v1, p0, Lgnu/math/IntNum;->ival:I

    .line 158
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, Lgnu/math/IntNum;->words:[I

    .line 179
    :cond_1
    :goto_0
    return-void

    .line 161
    :cond_2
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    if-eqz v1, :cond_3

    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    array-length v1, v1

    if-lt v1, p1, :cond_3

    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    array-length v1, v1

    add-int/lit8 v2, p1, 0x2

    if-le v1, v2, :cond_1

    .line 165
    :cond_3
    new-array v0, p1, [I

    .line 166
    .local v0, "new_words":[I
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    if-nez v1, :cond_4

    .line 168
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    aput v1, v0, v3

    .line 169
    const/4 v1, 0x1

    iput v1, p0, Lgnu/math/IntNum;->ival:I

    .line 177
    :goto_1
    iput-object v0, p0, Lgnu/math/IntNum;->words:[I

    goto :goto_0

    .line 173
    :cond_4
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    if-ge p1, v1, :cond_5

    .line 174
    iput p1, p0, Lgnu/math/IntNum;->ival:I

    .line 175
    :cond_5
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    iget v2, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    goto :goto_1
.end method

.method public roundToDouble(IZZ)D
    .locals 16
    .param p1, "exp"    # I
    .param p2, "neg"    # Z
    .param p3, "remainder"    # Z

    .prologue
    .line 1442
    invoke-virtual/range {p0 .. p0}, Lgnu/math/IntNum;->intLength()I

    move-result v8

    .line 1446
    .local v8, "il":I
    add-int/lit8 v12, v8, -0x1

    add-int p1, p1, v12

    .line 1452
    const/16 v12, -0x433

    move/from16 v0, p1

    if-ge v0, v12, :cond_1

    .line 1453
    if-eqz p2, :cond_0

    const-wide/high16 v12, -0x8000000000000000L

    .line 1508
    :goto_0
    return-wide v12

    .line 1453
    :cond_0
    const-wide/16 v12, 0x0

    goto :goto_0

    .line 1456
    :cond_1
    const/16 v12, 0x3ff

    move/from16 v0, p1

    if-le v0, v12, :cond_3

    .line 1457
    if-eqz p2, :cond_2

    const-wide/high16 v12, -0x10000000000000L    # Double.NEGATIVE_INFINITY

    goto :goto_0

    :cond_2
    const-wide/high16 v12, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    goto :goto_0

    .line 1461
    :cond_3
    const/16 v12, -0x3fe

    move/from16 v0, p1

    if-lt v0, v12, :cond_5

    const/16 v11, 0x35

    .line 1465
    .local v11, "ml":I
    :goto_1
    add-int/lit8 v12, v11, 0x1

    sub-int v7, v8, v12

    .line 1466
    .local v7, "excess_bits":I
    if-lez v7, :cond_7

    .line 1467
    move-object/from16 v0, p0

    iget-object v12, v0, Lgnu/math/IntNum;->words:[I

    if-nez v12, :cond_6

    move-object/from16 v0, p0

    iget v12, v0, Lgnu/math/IntNum;->ival:I

    shr-int/2addr v12, v7

    int-to-long v9, v12

    .line 1474
    .local v9, "m":J
    :goto_2
    const/16 v12, 0x3ff

    move/from16 v0, p1

    if-ne v0, v12, :cond_b

    const/4 v12, 0x1

    shr-long v12, v9, v12

    const-wide v14, 0x1fffffffffffffL

    cmp-long v12, v12, v14

    if-nez v12, :cond_b

    .line 1476
    if-nez p3, :cond_4

    sub-int v12, v8, v11

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lgnu/math/IntNum;->checkBits(I)Z

    move-result v12

    if-eqz v12, :cond_9

    .line 1477
    :cond_4
    if-eqz p2, :cond_8

    const-wide/high16 v12, -0x10000000000000L    # Double.NEGATIVE_INFINITY

    goto :goto_0

    .line 1461
    .end local v7    # "excess_bits":I
    .end local v9    # "m":J
    .end local v11    # "ml":I
    :cond_5
    add-int/lit8 v12, p1, 0x35

    add-int/lit16 v11, v12, 0x3fe

    goto :goto_1

    .line 1467
    .restart local v7    # "excess_bits":I
    .restart local v11    # "ml":I
    :cond_6
    move-object/from16 v0, p0

    iget-object v12, v0, Lgnu/math/IntNum;->words:[I

    move-object/from16 v0, p0

    iget v13, v0, Lgnu/math/IntNum;->ival:I

    invoke-static {v12, v13, v7}, Lgnu/math/MPN;->rshift_long([III)J

    move-result-wide v9

    goto :goto_2

    .line 1470
    :cond_7
    invoke-virtual/range {p0 .. p0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v12

    neg-int v14, v7

    shl-long v9, v12, v14

    .restart local v9    # "m":J
    goto :goto_2

    .line 1477
    :cond_8
    const-wide/high16 v12, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    goto :goto_0

    .line 1479
    :cond_9
    if-eqz p2, :cond_a

    const-wide v12, -0x10000000000001L

    goto :goto_0

    :cond_a
    const-wide v12, 0x7fefffffffffffffL    # Double.MAX_VALUE

    goto :goto_0

    .line 1484
    :cond_b
    const-wide/16 v12, 0x1

    and-long/2addr v12, v9

    const-wide/16 v14, 0x1

    cmp-long v12, v12, v14

    if-nez v12, :cond_d

    const-wide/16 v12, 0x2

    and-long/2addr v12, v9

    const-wide/16 v14, 0x2

    cmp-long v12, v12, v14

    if-eqz v12, :cond_c

    if-nez p3, :cond_c

    move-object/from16 v0, p0

    invoke-virtual {v0, v7}, Lgnu/math/IntNum;->checkBits(I)Z

    move-result v12

    if-eqz v12, :cond_d

    .line 1487
    :cond_c
    const-wide/16 v12, 0x2

    add-long/2addr v9, v12

    .line 1489
    const-wide/high16 v12, 0x40000000000000L

    and-long/2addr v12, v9

    const-wide/16 v14, 0x0

    cmp-long v12, v12, v14

    if-eqz v12, :cond_e

    .line 1491
    add-int/lit8 p1, p1, 0x1

    .line 1493
    const/4 v12, 0x1

    shr-long/2addr v9, v12

    .line 1502
    :cond_d
    :goto_3
    const/4 v12, 0x1

    shr-long/2addr v9, v12

    .line 1504
    if-eqz p2, :cond_f

    const-wide/high16 v5, -0x8000000000000000L

    .line 1505
    .local v5, "bits_sign":J
    :goto_4
    move/from16 v0, p1

    add-int/lit16 v0, v0, 0x3ff

    move/from16 p1, v0

    .line 1506
    if-gtz p1, :cond_10

    const-wide/16 v1, 0x0

    .line 1507
    .local v1, "bits_exp":J
    :goto_5
    const-wide v12, -0x10000000000001L

    and-long v3, v9, v12

    .line 1508
    .local v3, "bits_mant":J
    or-long v12, v5, v1

    or-long/2addr v12, v3

    invoke-static {v12, v13}, Ljava/lang/Double;->longBitsToDouble(J)D

    move-result-wide v12

    goto/16 :goto_0

    .line 1497
    .end local v1    # "bits_exp":J
    .end local v3    # "bits_mant":J
    .end local v5    # "bits_sign":J
    :cond_e
    const/16 v12, 0x34

    if-ne v11, v12, :cond_d

    const-wide/high16 v12, 0x20000000000000L

    and-long/2addr v12, v9

    const-wide/16 v14, 0x0

    cmp-long v12, v12, v14

    if-eqz v12, :cond_d

    .line 1498
    add-int/lit8 p1, p1, 0x1

    goto :goto_3

    .line 1504
    :cond_f
    const-wide/16 v5, 0x0

    goto :goto_4

    .line 1506
    .restart local v5    # "bits_sign":J
    :cond_10
    move/from16 v0, p1

    int-to-long v12, v0

    const/16 v14, 0x34

    shl-long v1, v12, v14

    goto :goto_5
.end method

.method public final set(I)V
    .locals 1
    .param p1, "y"    # I

    .prologue
    .line 372
    const/4 v0, 0x0

    iput-object v0, p0, Lgnu/math/IntNum;->words:[I

    .line 373
    iput p1, p0, Lgnu/math/IntNum;->ival:I

    .line 374
    return-void
.end method

.method public final set(J)V
    .locals 6
    .param p1, "y"    # J

    .prologue
    const/4 v5, 0x2

    .line 379
    long-to-int v0, p1

    .line 380
    .local v0, "i":I
    int-to-long v1, v0

    cmp-long v1, v1, p1

    if-nez v1, :cond_0

    .line 382
    iput v0, p0, Lgnu/math/IntNum;->ival:I

    .line 383
    const/4 v1, 0x0

    iput-object v1, p0, Lgnu/math/IntNum;->words:[I

    .line 392
    :goto_0
    return-void

    .line 387
    :cond_0
    invoke-virtual {p0, v5}, Lgnu/math/IntNum;->realloc(I)V

    .line 388
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    const/4 v2, 0x0

    aput v0, v1, v2

    .line 389
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    const/4 v2, 0x1

    const/16 v3, 0x20

    shr-long v3, p1, v3

    long-to-int v3, v3

    aput v3, v1, v2

    .line 390
    iput v5, p0, Lgnu/math/IntNum;->ival:I

    goto :goto_0
.end method

.method public final set(Lgnu/math/IntNum;)V
    .locals 4
    .param p1, "y"    # Lgnu/math/IntNum;

    .prologue
    const/4 v3, 0x0

    .line 405
    iget-object v0, p1, Lgnu/math/IntNum;->words:[I

    if-nez v0, :cond_1

    .line 406
    iget v0, p1, Lgnu/math/IntNum;->ival:I

    invoke-virtual {p0, v0}, Lgnu/math/IntNum;->set(I)V

    .line 413
    :cond_0
    :goto_0
    return-void

    .line 407
    :cond_1
    if-eq p0, p1, :cond_0

    .line 409
    iget v0, p1, Lgnu/math/IntNum;->ival:I

    invoke-virtual {p0, v0}, Lgnu/math/IntNum;->realloc(I)V

    .line 410
    iget-object v0, p1, Lgnu/math/IntNum;->words:[I

    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    iget v2, p1, Lgnu/math/IntNum;->ival:I

    invoke-static {v0, v3, v1, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 411
    iget v0, p1, Lgnu/math/IntNum;->ival:I

    iput v0, p0, Lgnu/math/IntNum;->ival:I

    goto :goto_0
.end method

.method public final set([II)V
    .locals 0
    .param p1, "words"    # [I
    .param p2, "length"    # I

    .prologue
    .line 398
    iput p2, p0, Lgnu/math/IntNum;->ival:I

    .line 399
    iput-object p1, p0, Lgnu/math/IntNum;->words:[I

    .line 400
    return-void
.end method

.method public final setAdd(I)V
    .locals 0
    .param p1, "y"    # I

    .prologue
    .line 366
    invoke-virtual {p0, p0, p1}, Lgnu/math/IntNum;->setAdd(Lgnu/math/IntNum;I)V

    .line 367
    return-void
.end method

.method public setAdd(Lgnu/math/IntNum;I)V
    .locals 8
    .param p1, "x"    # Lgnu/math/IntNum;
    .param p2, "y"    # I

    .prologue
    .line 343
    iget-object v4, p1, Lgnu/math/IntNum;->words:[I

    if-nez v4, :cond_0

    .line 345
    iget v4, p1, Lgnu/math/IntNum;->ival:I

    int-to-long v4, v4

    int-to-long v6, p2

    add-long/2addr v4, v6

    invoke-virtual {p0, v4, v5}, Lgnu/math/IntNum;->set(J)V

    .line 361
    :goto_0
    return-void

    .line 348
    :cond_0
    iget v3, p1, Lgnu/math/IntNum;->ival:I

    .line 349
    .local v3, "len":I
    add-int/lit8 v4, v3, 0x1

    invoke-virtual {p0, v4}, Lgnu/math/IntNum;->realloc(I)V

    .line 350
    int-to-long v0, p2

    .line 351
    .local v0, "carry":J
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v3, :cond_1

    .line 353
    iget-object v4, p1, Lgnu/math/IntNum;->words:[I

    aget v4, v4, v2

    int-to-long v4, v4

    const-wide v6, 0xffffffffL

    and-long/2addr v4, v6

    add-long/2addr v0, v4

    .line 354
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    long-to-int v5, v0

    aput v5, v4, v2

    .line 355
    const/16 v4, 0x20

    shr-long/2addr v0, v4

    .line 351
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 357
    :cond_1
    iget-object v4, p1, Lgnu/math/IntNum;->words:[I

    add-int/lit8 v5, v3, -0x1

    aget v4, v4, v5

    if-gez v4, :cond_2

    .line 358
    const-wide/16 v4, 0x1

    sub-long/2addr v0, v4

    .line 359
    :cond_2
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    long-to-int v5, v0

    aput v5, v4, v3

    .line 360
    iget-object v4, p0, Lgnu/math/IntNum;->words:[I

    add-int/lit8 v5, v3, 0x1

    invoke-static {v4, v5}, Lgnu/math/IntNum;->wordsNeeded([II)I

    move-result v4

    iput v4, p0, Lgnu/math/IntNum;->ival:I

    goto :goto_0
.end method

.method setInvert()V
    .locals 3

    .prologue
    .line 1007
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    if-nez v1, :cond_1

    .line 1008
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    xor-int/lit8 v1, v1, -0x1

    iput v1, p0, Lgnu/math/IntNum;->ival:I

    .line 1014
    :cond_0
    return-void

    .line 1011
    :cond_1
    iget v0, p0, Lgnu/math/IntNum;->ival:I

    .local v0, "i":I
    :goto_0
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_0

    .line 1012
    iget-object v1, p0, Lgnu/math/IntNum;->words:[I

    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v2, v2, v0

    xor-int/lit8 v2, v2, -0x1

    aput v2, v1, v0

    goto :goto_0
.end method

.method public final setNegative()V
    .locals 0

    .prologue
    .line 1606
    invoke-virtual {p0, p0}, Lgnu/math/IntNum;->setNegative(Lgnu/math/IntNum;)V

    .line 1607
    return-void
.end method

.method public setNegative(Lgnu/math/IntNum;)V
    .locals 4
    .param p1, "x"    # Lgnu/math/IntNum;

    .prologue
    .line 1588
    iget v0, p1, Lgnu/math/IntNum;->ival:I

    .line 1589
    .local v0, "len":I
    iget-object v2, p1, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_1

    .line 1591
    const/high16 v2, -0x80000000

    if-ne v0, v2, :cond_0

    .line 1592
    int-to-long v2, v0

    neg-long v2, v2

    invoke-virtual {p0, v2, v3}, Lgnu/math/IntNum;->set(J)V

    .line 1601
    :goto_0
    return-void

    .line 1594
    :cond_0
    neg-int v2, v0

    invoke-virtual {p0, v2}, Lgnu/math/IntNum;->set(I)V

    goto :goto_0

    .line 1597
    :cond_1
    add-int/lit8 v2, v0, 0x1

    invoke-virtual {p0, v2}, Lgnu/math/IntNum;->realloc(I)V

    .line 1598
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    iget-object v3, p1, Lgnu/math/IntNum;->words:[I

    invoke-static {v2, v3, v0}, Lgnu/math/IntNum;->negate([I[II)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1599
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    add-int/lit8 v1, v0, 0x1

    .end local v0    # "len":I
    .local v1, "len":I
    const/4 v3, 0x0

    aput v3, v2, v0

    move v0, v1

    .line 1600
    .end local v1    # "len":I
    .restart local v0    # "len":I
    :cond_2
    iput v0, p0, Lgnu/math/IntNum;->ival:I

    goto :goto_0
.end method

.method setShift(Lgnu/math/IntNum;I)V
    .locals 1
    .param p1, "x"    # Lgnu/math/IntNum;
    .param p2, "count"    # I

    .prologue
    .line 1086
    if-lez p2, :cond_0

    .line 1087
    invoke-virtual {p0, p1, p2}, Lgnu/math/IntNum;->setShiftLeft(Lgnu/math/IntNum;I)V

    .line 1090
    :goto_0
    return-void

    .line 1089
    :cond_0
    neg-int v0, p2

    invoke-virtual {p0, p1, v0}, Lgnu/math/IntNum;->setShiftRight(Lgnu/math/IntNum;I)V

    goto :goto_0
.end method

.method setShiftLeft(Lgnu/math/IntNum;I)V
    .locals 10
    .param p1, "x"    # Lgnu/math/IntNum;
    .param p2, "count"    # I

    .prologue
    const/4 v9, 0x0

    .line 1020
    iget-object v6, p1, Lgnu/math/IntNum;->words:[I

    if-nez v6, :cond_2

    .line 1022
    const/16 v6, 0x20

    if-ge p2, v6, :cond_1

    .line 1024
    iget v6, p1, Lgnu/math/IntNum;->ival:I

    int-to-long v6, v6

    shl-long/2addr v6, p2

    invoke-virtual {p0, v6, v7}, Lgnu/math/IntNum;->set(J)V

    .line 1056
    :cond_0
    return-void

    .line 1027
    :cond_1
    const/4 v6, 0x1

    new-array v5, v6, [I

    .line 1028
    .local v5, "xwords":[I
    iget v6, p1, Lgnu/math/IntNum;->ival:I

    aput v6, v5, v9

    .line 1029
    const/4 v4, 0x1

    .line 1036
    .local v4, "xlen":I
    :goto_0
    shr-int/lit8 v3, p2, 0x5

    .line 1037
    .local v3, "word_count":I
    and-int/lit8 p2, p2, 0x1f

    .line 1038
    add-int v1, v4, v3

    .line 1039
    .local v1, "new_len":I
    if-nez p2, :cond_3

    .line 1041
    invoke-virtual {p0, v1}, Lgnu/math/IntNum;->realloc(I)V

    .line 1042
    move v0, v4

    .local v0, "i":I
    :goto_1
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_4

    .line 1043
    iget-object v6, p0, Lgnu/math/IntNum;->words:[I

    add-int v7, v0, v3

    aget v8, v5, v0

    aput v8, v6, v7

    goto :goto_1

    .line 1033
    .end local v0    # "i":I
    .end local v1    # "new_len":I
    .end local v3    # "word_count":I
    .end local v4    # "xlen":I
    .end local v5    # "xwords":[I
    :cond_2
    iget-object v5, p1, Lgnu/math/IntNum;->words:[I

    .line 1034
    .restart local v5    # "xwords":[I
    iget v4, p1, Lgnu/math/IntNum;->ival:I

    .restart local v4    # "xlen":I
    goto :goto_0

    .line 1047
    .restart local v1    # "new_len":I
    .restart local v3    # "word_count":I
    :cond_3
    add-int/lit8 v1, v1, 0x1

    .line 1048
    invoke-virtual {p0, v1}, Lgnu/math/IntNum;->realloc(I)V

    .line 1049
    iget-object v6, p0, Lgnu/math/IntNum;->words:[I

    invoke-static {v6, v3, v5, v4, p2}, Lgnu/math/MPN;->lshift([II[III)I

    move-result v2

    .line 1050
    .local v2, "shift_out":I
    rsub-int/lit8 p2, p2, 0x20

    .line 1051
    iget-object v6, p0, Lgnu/math/IntNum;->words:[I

    add-int/lit8 v7, v1, -0x1

    shl-int v8, v2, p2

    shr-int/2addr v8, p2

    aput v8, v6, v7

    .line 1053
    .end local v2    # "shift_out":I
    :cond_4
    iput v1, p0, Lgnu/math/IntNum;->ival:I

    .line 1054
    move v0, v3

    .restart local v0    # "i":I
    :goto_2
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_0

    .line 1055
    iget-object v6, p0, Lgnu/math/IntNum;->words:[I

    aput v9, v6, v0

    goto :goto_2
.end method

.method setShiftRight(Lgnu/math/IntNum;I)V
    .locals 8
    .param p1, "x"    # Lgnu/math/IntNum;
    .param p2, "count"    # I

    .prologue
    const/4 v4, 0x0

    const/4 v3, -0x1

    .line 1060
    iget-object v5, p1, Lgnu/math/IntNum;->words:[I

    if-nez v5, :cond_3

    .line 1061
    const/16 v5, 0x20

    if-ge p2, v5, :cond_2

    iget v3, p1, Lgnu/math/IntNum;->ival:I

    shr-int/2addr v3, p2

    :cond_0
    :goto_0
    invoke-virtual {p0, v3}, Lgnu/math/IntNum;->set(I)V

    .line 1082
    :cond_1
    :goto_1
    return-void

    .line 1061
    :cond_2
    iget v5, p1, Lgnu/math/IntNum;->ival:I

    if-ltz v5, :cond_0

    move v3, v4

    goto :goto_0

    .line 1062
    :cond_3
    if-nez p2, :cond_4

    .line 1063
    invoke-virtual {p0, p1}, Lgnu/math/IntNum;->set(Lgnu/math/IntNum;)V

    goto :goto_1

    .line 1066
    :cond_4
    invoke-virtual {p1}, Lgnu/math/IntNum;->isNegative()Z

    move-result v1

    .line 1067
    .local v1, "neg":Z
    shr-int/lit8 v2, p2, 0x5

    .line 1068
    .local v2, "word_count":I
    and-int/lit8 p2, p2, 0x1f

    .line 1069
    iget v5, p1, Lgnu/math/IntNum;->ival:I

    sub-int v0, v5, v2

    .line 1070
    .local v0, "d_len":I
    if-gtz v0, :cond_6

    .line 1071
    if-eqz v1, :cond_5

    :goto_2
    invoke-virtual {p0, v3}, Lgnu/math/IntNum;->set(I)V

    goto :goto_1

    :cond_5
    move v3, v4

    goto :goto_2

    .line 1074
    :cond_6
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    if-eqz v3, :cond_7

    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    array-length v3, v3

    if-ge v3, v0, :cond_8

    .line 1075
    :cond_7
    invoke-virtual {p0, v0}, Lgnu/math/IntNum;->realloc(I)V

    .line 1076
    :cond_8
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    iget-object v4, p1, Lgnu/math/IntNum;->words:[I

    invoke-static {v3, v4, v2, v0, p2}, Lgnu/math/MPN;->rshift0([I[IIII)V

    .line 1077
    iput v0, p0, Lgnu/math/IntNum;->ival:I

    .line 1078
    if-eqz v1, :cond_1

    .line 1079
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    add-int/lit8 v4, v0, -0x1

    aget v5, v3, v4

    const/4 v6, -0x2

    rsub-int/lit8 v7, p2, 0x1f

    shl-int/2addr v6, v7

    or-int/2addr v5, v6

    aput v5, v3, v4

    goto :goto_1
.end method

.method public sign()I
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, -0x1

    const/4 v3, 0x1

    .line 198
    iget v1, p0, Lgnu/math/IntNum;->ival:I

    .line 199
    .local v1, "n":I
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    .line 200
    .local v2, "w":[I
    if-nez v2, :cond_3

    .line 201
    if-lez v1, :cond_1

    .line 212
    :cond_0
    :goto_0
    return v3

    .line 201
    :cond_1
    if-gez v1, :cond_2

    move v3, v4

    goto :goto_0

    :cond_2
    move v3, v5

    goto :goto_0

    .line 202
    :cond_3
    add-int/lit8 v1, v1, -0x1

    aget v0, v2, v1

    .line 203
    .local v0, "i":I
    if-gtz v0, :cond_0

    .line 205
    if-gez v0, :cond_4

    move v3, v4

    .line 206
    goto :goto_0

    .line 209
    :cond_4
    if-nez v1, :cond_5

    move v3, v5

    .line 210
    goto :goto_0

    .line 211
    :cond_5
    add-int/lit8 v1, v1, -0x1

    aget v4, v2, v1

    if-eqz v4, :cond_4

    goto :goto_0
.end method

.method public toExactInt(I)Lgnu/math/IntNum;
    .locals 0
    .param p1, "rounding_mode"    # I

    .prologue
    .line 839
    return-object p0
.end method

.method public toInt(I)Lgnu/math/RealNum;
    .locals 0
    .param p1, "rounding_mode"    # I

    .prologue
    .line 844
    return-object p0
.end method

.method public toString(I)Ljava/lang/String;
    .locals 4
    .param p1, "radix"    # I

    .prologue
    .line 1253
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_0

    .line 1254
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v2, p1}, Ljava/lang/Integer;->toString(II)Ljava/lang/String;

    move-result-object v2

    .line 1264
    :goto_0
    return-object v2

    .line 1255
    :cond_0
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    const/4 v3, 0x2

    if-gt v2, v3, :cond_1

    .line 1256
    invoke-virtual {p0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v2

    invoke-static {v2, v3, p1}, Ljava/lang/Long;->toString(JI)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1257
    :cond_1
    iget v2, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {p1}, Lgnu/math/MPN;->chars_per_word(I)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    mul-int v0, v2, v3

    .line 1259
    .local v0, "buf_size":I
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1, v0}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 1263
    .local v1, "buffer":Ljava/lang/StringBuilder;
    invoke-virtual {p0, p1, v1}, Lgnu/math/IntNum;->format(ILjava/lang/StringBuilder;)V

    .line 1264
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 5
    .param p1, "out"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v0, 0x0

    .line 1650
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    if-nez v3, :cond_2

    move v1, v2

    .line 1651
    .local v1, "nwords":I
    :goto_0
    if-gt v1, v2, :cond_5

    .line 1653
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    if-nez v2, :cond_3

    iget v0, p0, Lgnu/math/IntNum;->ival:I

    .line 1654
    .local v0, "i":I
    :cond_0
    :goto_1
    const/high16 v2, -0x40000000    # -2.0f

    if-lt v0, v2, :cond_4

    .line 1655
    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 1669
    .end local v0    # "i":I
    :cond_1
    :goto_2
    return-void

    .line 1650
    .end local v1    # "nwords":I
    :cond_2
    iget-object v3, p0, Lgnu/math/IntNum;->words:[I

    iget v4, p0, Lgnu/math/IntNum;->ival:I

    invoke-static {v3, v4}, Lgnu/math/IntNum;->wordsNeeded([II)I

    move-result v1

    goto :goto_0

    .line 1653
    .restart local v1    # "nwords":I
    :cond_3
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    array-length v2, v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v0, v2, v0

    goto :goto_1

    .line 1658
    .restart local v0    # "i":I
    :cond_4
    const v2, -0x7fffffff

    invoke-interface {p1, v2}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 1659
    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    goto :goto_2

    .line 1664
    .end local v0    # "i":I
    :cond_5
    const/high16 v2, -0x80000000

    or-int/2addr v2, v1

    invoke-interface {p1, v2}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 1665
    :goto_3
    add-int/lit8 v1, v1, -0x1

    if-ltz v1, :cond_1

    .line 1666
    iget-object v2, p0, Lgnu/math/IntNum;->words:[I

    aget v2, v2, v1

    invoke-interface {p1, v2}, Ljava/io/ObjectOutput;->writeInt(I)V

    goto :goto_3
.end method
