.class public Lgnu/kawa/functions/Arrays;
.super Ljava/lang/Object;
.source "Arrays.java"


# static fields
.field static final shapeStrides:[I

.field static final zeros2:[I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x2

    .line 13
    new-array v0, v1, [I

    fill-array-data v0, :array_0

    sput-object v0, Lgnu/kawa/functions/Arrays;->shapeStrides:[I

    .line 14
    new-array v0, v1, [I

    sput-object v0, Lgnu/kawa/functions/Arrays;->zeros2:[I

    return-void

    .line 13
    nop

    :array_0
    .array-data 4
        0x2
        0x1
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static effectiveIndex(Lgnu/lists/Array;Lgnu/mapping/Procedure;[Ljava/lang/Object;[I)I
    .locals 6
    .param p0, "array"    # Lgnu/lists/Array;
    .param p1, "proc"    # Lgnu/mapping/Procedure;
    .param p2, "args"    # [Ljava/lang/Object;
    .param p3, "work"    # [I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 73
    invoke-virtual {p1, p2}, Lgnu/mapping/Procedure;->applyN([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 74
    .local v2, "mapval":Ljava/lang/Object;
    instance-of v4, v2, Lgnu/mapping/Values;

    if-eqz v4, :cond_0

    move-object v3, v2

    .line 76
    check-cast v3, Lgnu/mapping/Values;

    .line 77
    .local v3, "mapvals":Lgnu/mapping/Values;
    const/4 v0, 0x0

    .local v0, "i":I
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_0
    invoke-virtual {v3, v0}, Lgnu/mapping/Values;->nextPos(I)I

    move-result v0

    if-eqz v0, :cond_1

    .line 79
    invoke-virtual {v3, v0}, Lgnu/mapping/Values;->getPosPrevious(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Number;

    invoke-virtual {v4}, Ljava/lang/Number;->intValue()I

    move-result v4

    aput v4, p3, v1

    .line 77
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 83
    .end local v0    # "i":I
    .end local v1    # "j":I
    .end local v3    # "mapvals":Lgnu/mapping/Values;
    :cond_0
    const/4 v4, 0x0

    check-cast v2, Ljava/lang/Number;

    .end local v2    # "mapval":Ljava/lang/Object;
    invoke-virtual {v2}, Ljava/lang/Number;->intValue()I

    move-result v5

    aput v5, p3, v4

    .line 84
    :cond_1
    invoke-interface {p0, p3}, Lgnu/lists/Array;->getEffectiveIndex([I)I

    move-result v4

    return v4
.end method

.method public static make(Lgnu/lists/Array;Ljava/lang/Object;)Lgnu/lists/Array;
    .locals 9
    .param p0, "shape"    # Lgnu/lists/Array;
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 28
    const/4 v8, 0x0

    invoke-interface {p0, v8}, Lgnu/lists/Array;->getSize(I)I

    move-result v5

    .line 29
    .local v5, "rank":I
    new-array v0, v5, [I

    .line 30
    .local v0, "dimensions":[I
    const/4 v4, 0x0

    .line 31
    .local v4, "lowBounds":[I
    const/4 v7, 0x1

    .line 32
    .local v7, "total":I
    move v2, v5

    .local v2, "i":I
    :goto_0
    add-int/lit8 v2, v2, -0x1

    if-ltz v2, :cond_2

    .line 34
    mul-int/lit8 v8, v2, 0x2

    invoke-interface {p0, v8}, Lgnu/lists/Array;->getRowMajor(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Number;

    invoke-virtual {v8}, Ljava/lang/Number;->intValue()I

    move-result v3

    .line 35
    .local v3, "lo":I
    mul-int/lit8 v8, v2, 0x2

    add-int/lit8 v8, v8, 0x1

    invoke-interface {p0, v8}, Lgnu/lists/Array;->getRowMajor(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/lang/Number;

    invoke-virtual {v8}, Ljava/lang/Number;->intValue()I

    move-result v1

    .line 36
    .local v1, "hi":I
    sub-int v6, v1, v3

    .line 37
    .local v6, "size":I
    aput v6, v0, v2

    .line 38
    if-eqz v3, :cond_1

    .line 40
    if-nez v4, :cond_0

    .line 41
    new-array v4, v5, [I

    .line 42
    :cond_0
    aput v3, v4, v2

    .line 44
    :cond_1
    mul-int/2addr v7, v6

    .line 45
    goto :goto_0

    .line 46
    .end local v1    # "hi":I
    .end local v3    # "lo":I
    .end local v6    # "size":I
    :cond_2
    new-instance v8, Lgnu/lists/FVector;

    invoke-direct {v8, v7, p1}, Lgnu/lists/FVector;-><init>(ILjava/lang/Object;)V

    invoke-static {v4, v0, v8}, Lgnu/lists/GeneralArray;->makeSimple([I[ILgnu/lists/SimpleVector;)Lgnu/lists/Array;

    move-result-object v8

    return-object v8
.end method

.method public static makeSimple(Lgnu/lists/Array;Lgnu/lists/SimpleVector;)Lgnu/lists/Array;
    .locals 7
    .param p0, "shape"    # Lgnu/lists/Array;
    .param p1, "base"    # Lgnu/lists/SimpleVector;

    .prologue
    .line 51
    const/4 v6, 0x0

    invoke-interface {p0, v6}, Lgnu/lists/Array;->getSize(I)I

    move-result v5

    .line 52
    .local v5, "rank":I
    new-array v0, v5, [I

    .line 53
    .local v0, "dimensions":[I
    const/4 v4, 0x0

    .line 54
    .local v4, "lowBounds":[I
    move v2, v5

    .local v2, "i":I
    :cond_0
    :goto_0
    add-int/lit8 v2, v2, -0x1

    if-ltz v2, :cond_2

    .line 56
    mul-int/lit8 v6, v2, 0x2

    invoke-interface {p0, v6}, Lgnu/lists/Array;->getRowMajor(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Number;

    invoke-virtual {v6}, Ljava/lang/Number;->intValue()I

    move-result v3

    .line 57
    .local v3, "lo":I
    mul-int/lit8 v6, v2, 0x2

    add-int/lit8 v6, v6, 0x1

    invoke-interface {p0, v6}, Lgnu/lists/Array;->getRowMajor(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Number;

    invoke-virtual {v6}, Ljava/lang/Number;->intValue()I

    move-result v1

    .line 58
    .local v1, "hi":I
    sub-int v6, v1, v3

    aput v6, v0, v2

    .line 59
    if-eqz v3, :cond_0

    .line 61
    if-nez v4, :cond_1

    .line 62
    new-array v4, v5, [I

    .line 63
    :cond_1
    aput v3, v4, v2

    goto :goto_0

    .line 66
    .end local v1    # "hi":I
    .end local v3    # "lo":I
    :cond_2
    invoke-static {v4, v0, p1}, Lgnu/lists/GeneralArray;->makeSimple([I[ILgnu/lists/SimpleVector;)Lgnu/lists/Array;

    move-result-object v6

    return-object v6
.end method

.method public static shape([Ljava/lang/Object;)Lgnu/lists/Array;
    .locals 7
    .param p0, "vals"    # [Ljava/lang/Object;

    .prologue
    const/4 v4, 0x2

    const/4 v6, 0x0

    .line 18
    array-length v2, p0

    .line 19
    .local v2, "len":I
    and-int/lit8 v3, v2, 0x1

    if-eqz v3, :cond_0

    .line 20
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "shape: not an even number of arguments"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 21
    :cond_0
    shr-int/lit8 v0, v2, 0x1

    .line 22
    .local v0, "d":I
    new-array v1, v4, [I

    aput v0, v1, v6

    const/4 v3, 0x1

    aput v4, v1, v3

    .line 23
    .local v1, "dims":[I
    new-instance v3, Lgnu/lists/FVector;

    invoke-direct {v3, p0}, Lgnu/lists/FVector;-><init>([Ljava/lang/Object;)V

    sget-object v4, Lgnu/kawa/functions/Arrays;->zeros2:[I

    sget-object v5, Lgnu/kawa/functions/Arrays;->shapeStrides:[I

    invoke-virtual {v3, v4, v1, v6, v5}, Lgnu/lists/FVector;->transpose([I[II[I)Lgnu/lists/Array;

    move-result-object v3

    return-object v3
.end method

.method public static shareArray(Lgnu/lists/Array;Lgnu/lists/Array;Lgnu/mapping/Procedure;)Lgnu/lists/Array;
    .locals 17
    .param p0, "array"    # Lgnu/lists/Array;
    .param p1, "shape"    # Lgnu/lists/Array;
    .param p2, "proc"    # Lgnu/mapping/Procedure;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 91
    const/16 v16, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-interface {v0, v1}, Lgnu/lists/Array;->getSize(I)I

    move-result v13

    .line 92
    .local v13, "rank":I
    new-array v3, v13, [Ljava/lang/Object;

    .line 93
    .local v3, "args":[Ljava/lang/Object;
    new-array v4, v13, [I

    .line 94
    .local v4, "dimensions":[I
    new-array v10, v13, [I

    .line 95
    .local v10, "lowBounds":[I
    const/4 v5, 0x0

    .line 96
    .local v5, "empty":Z
    move v7, v13

    .local v7, "i":I
    :cond_0
    :goto_0
    add-int/lit8 v7, v7, -0x1

    if-ltz v7, :cond_1

    .line 98
    mul-int/lit8 v16, v7, 0x2

    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-interface {v0, v1}, Lgnu/lists/Array;->getRowMajor(I)Ljava/lang/Object;

    move-result-object v9

    .line 99
    .local v9, "low":Ljava/lang/Object;
    aput-object v9, v3, v7

    .line 100
    check-cast v9, Ljava/lang/Number;

    .end local v9    # "low":Ljava/lang/Object;
    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I

    move-result v8

    .line 101
    .local v8, "lo":I
    aput v8, v10, v7

    .line 102
    mul-int/lit8 v16, v7, 0x2

    add-int/lit8 v16, v16, 0x1

    move-object/from16 v0, p1

    move/from16 v1, v16

    invoke-interface {v0, v1}, Lgnu/lists/Array;->getRowMajor(I)Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/Number;

    invoke-virtual/range {v16 .. v16}, Ljava/lang/Number;->intValue()I

    move-result v6

    .line 103
    .local v6, "hi":I
    sub-int v14, v6, v8

    .line 104
    .local v14, "size":I
    aput v14, v4, v7

    .line 105
    if-gtz v14, :cond_0

    .line 106
    const/4 v5, 0x1

    goto :goto_0

    .line 108
    .end local v6    # "hi":I
    .end local v8    # "lo":I
    .end local v14    # "size":I
    :cond_1
    invoke-interface/range {p0 .. p0}, Lgnu/lists/Array;->rank()I

    move-result v2

    .line 109
    .local v2, "arank":I
    new-array v12, v13, [I

    .line 111
    .local v12, "offsets":[I
    if-eqz v5, :cond_3

    .line 112
    const/4 v11, 0x0

    .line 133
    .local v11, "offset0":I
    :cond_2
    move-object/from16 v0, p0

    invoke-interface {v0, v10, v4, v11, v12}, Lgnu/lists/Array;->transpose([I[II[I)Lgnu/lists/Array;

    move-result-object v16

    return-object v16

    .line 115
    .end local v11    # "offset0":I
    :cond_3
    new-array v15, v2, [I

    .line 116
    .local v15, "work":[I
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-static {v0, v1, v3, v15}, Lgnu/kawa/functions/Arrays;->effectiveIndex(Lgnu/lists/Array;Lgnu/mapping/Procedure;[Ljava/lang/Object;[I)I

    move-result v11

    .line 117
    .restart local v11    # "offset0":I
    move v7, v13

    :goto_1
    add-int/lit8 v7, v7, -0x1

    if-ltz v7, :cond_2

    .line 119
    aget v14, v4, v7

    .line 120
    .restart local v14    # "size":I
    aget v8, v10, v7

    .line 121
    .restart local v8    # "lo":I
    const/16 v16, 0x1

    move/from16 v0, v16

    if-gt v14, v0, :cond_4

    .line 122
    const/16 v16, 0x0

    aput v16, v12, v7

    goto :goto_1

    .line 125
    :cond_4
    aget-object v9, v3, v7

    .line 126
    .restart local v9    # "low":Ljava/lang/Object;
    add-int/lit8 v16, v8, 0x1

    invoke-static/range {v16 .. v16}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v16

    aput-object v16, v3, v7

    .line 127
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-static {v0, v1, v3, v15}, Lgnu/kawa/functions/Arrays;->effectiveIndex(Lgnu/lists/Array;Lgnu/mapping/Procedure;[Ljava/lang/Object;[I)I

    move-result v16

    sub-int v16, v16, v11

    aput v16, v12, v7

    .line 129
    aput-object v9, v3, v7

    goto :goto_1
.end method
