.class public Lkawa/standard/read_line;
.super Ljava/lang/Object;
.source "read_line.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static apply(Lgnu/text/LineBufferedReader;Ljava/lang/String;)Ljava/lang/Object;
    .locals 17
    .param p0, "in"    # Lgnu/text/LineBufferedReader;
    .param p1, "handling"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 11
    invoke-virtual/range {p0 .. p0}, Lgnu/text/LineBufferedReader;->read()I

    move-result v2

    .line 12
    .local v2, "ch":I
    if-gez v2, :cond_1

    .line 13
    sget-object v3, Lgnu/expr/Special;->eof:Ljava/lang/Object;

    .line 86
    :cond_0
    :goto_0
    return-object v3

    .line 14
    :cond_1
    move-object/from16 v0, p0

    iget v15, v0, Lgnu/text/LineBufferedReader;->pos:I

    add-int/lit8 v13, v15, -0x1

    .line 15
    .local v13, "start":I
    move v10, v13

    .line 16
    .local v10, "pos":I
    move-object/from16 v0, p0

    iget v8, v0, Lgnu/text/LineBufferedReader;->limit:I

    .line 17
    .local v8, "limit":I
    move-object/from16 v0, p0

    iget-object v1, v0, Lgnu/text/LineBufferedReader;->buffer:[C

    .line 18
    .local v1, "buffer":[C
    const/4 v4, -0x1

    .local v4, "delim":I
    move v11, v10

    .line 21
    .end local v10    # "pos":I
    .local v11, "pos":I
    :goto_1
    if-ge v11, v8, :cond_8

    .line 23
    add-int/lit8 v10, v11, 0x1

    .end local v11    # "pos":I
    .restart local v10    # "pos":I
    aget-char v2, v1, v11

    .line 24
    const/16 v15, 0xd

    if-eq v2, v15, :cond_2

    const/16 v15, 0xa

    if-ne v2, v15, :cond_13

    .line 26
    :cond_2
    add-int/lit8 v10, v10, -0x1

    .line 27
    const-string v15, "trim"

    move-object/from16 v0, p1

    if-eq v0, v15, :cond_3

    const-string v15, "peek"

    move-object/from16 v0, p1

    if-ne v0, v15, :cond_7

    .line 29
    :cond_3
    const-string v15, "peek"

    move-object/from16 v0, p1

    if-ne v0, v15, :cond_4

    .line 30
    const/4 v4, 0x0

    .line 31
    :cond_4
    const/16 v15, 0xa

    if-ne v2, v15, :cond_5

    .line 32
    const/4 v4, 0x1

    .line 37
    :goto_2
    add-int v15, v10, v4

    move-object/from16 v0, p0

    iput v15, v0, Lgnu/text/LineBufferedReader;->pos:I

    .line 45
    :goto_3
    new-instance v3, Lgnu/lists/FString;

    sub-int v15, v10, v13

    invoke-direct {v3, v1, v13, v15}, Lgnu/lists/FString;-><init>([CII)V

    goto :goto_0

    .line 33
    :cond_5
    add-int/lit8 v15, v10, 0x1

    if-ge v15, v8, :cond_9

    .line 34
    add-int/lit8 v15, v10, 0x1

    aget-char v15, v1, v15

    const/16 v16, 0xa

    move/from16 v0, v16

    if-ne v15, v0, :cond_6

    const/4 v4, 0x2

    :goto_4
    goto :goto_2

    :cond_6
    const/4 v4, 0x1

    goto :goto_4

    .line 39
    :cond_7
    const-string v15, "concat"

    move-object/from16 v0, p1

    if-ne v0, v15, :cond_9

    const/16 v15, 0xa

    if-ne v2, v15, :cond_9

    .line 41
    add-int/lit8 v10, v10, 0x1

    move-object/from16 v0, p0

    iput v10, v0, Lgnu/text/LineBufferedReader;->pos:I

    goto :goto_3

    .end local v10    # "pos":I
    .restart local v11    # "pos":I
    :cond_8
    move v10, v11

    .line 51
    .end local v11    # "pos":I
    .restart local v10    # "pos":I
    :cond_9
    new-instance v12, Ljava/lang/StringBuffer;

    const/16 v15, 0x64

    invoke-direct {v12, v15}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 52
    .local v12, "sbuf":Ljava/lang/StringBuffer;
    if-le v10, v13, :cond_a

    .line 53
    sub-int v15, v10, v13

    invoke-virtual {v12, v1, v13, v15}, Ljava/lang/StringBuffer;->append([CII)Ljava/lang/StringBuffer;

    .line 54
    :cond_a
    move-object/from16 v0, p0

    iput v10, v0, Lgnu/text/LineBufferedReader;->pos:I

    .line 55
    const-string v15, "peek"

    move-object/from16 v0, p1

    if-ne v0, v15, :cond_c

    const/16 v9, 0x50

    .line 58
    .local v9, "mode":C
    :goto_5
    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v9}, Lgnu/text/LineBufferedReader;->readLine(Ljava/lang/StringBuffer;C)V

    .line 59
    invoke-virtual {v12}, Ljava/lang/StringBuffer;->length()I

    move-result v7

    .line 60
    .local v7, "length":I
    const-string v15, "split"

    move-object/from16 v0, p1

    if-ne v0, v15, :cond_b

    .line 62
    if-nez v7, :cond_f

    .line 63
    const/4 v4, 0x0

    .line 78
    :cond_b
    :goto_6
    new-instance v3, Lgnu/lists/FString;

    const/4 v15, 0x0

    invoke-direct {v3, v12, v15, v7}, Lgnu/lists/FString;-><init>(Ljava/lang/StringBuffer;II)V

    .line 79
    .local v3, "dataStr":Lgnu/lists/FString;
    const-string v15, "split"

    move-object/from16 v0, p1

    if-ne v0, v15, :cond_0

    .line 81
    new-instance v5, Lgnu/lists/FString;

    sub-int v15, v7, v4

    invoke-direct {v5, v12, v15, v4}, Lgnu/lists/FString;-><init>(Ljava/lang/StringBuffer;II)V

    .line 82
    .local v5, "delimStr":Lgnu/lists/FString;
    const/4 v15, 0x2

    new-array v14, v15, [Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object v3, v14, v15

    const/4 v15, 0x1

    aput-object v5, v14, v15

    .line 83
    .local v14, "values":[Ljava/lang/Object;
    new-instance v3, Lgnu/mapping/Values;

    .end local v3    # "dataStr":Lgnu/lists/FString;
    invoke-direct {v3, v14}, Lgnu/mapping/Values;-><init>([Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 55
    .end local v5    # "delimStr":Lgnu/lists/FString;
    .end local v7    # "length":I
    .end local v9    # "mode":C
    .end local v14    # "values":[Ljava/lang/Object;
    :cond_c
    const-string v15, "concat"

    move-object/from16 v0, p1

    if-eq v0, v15, :cond_d

    const-string v15, "split"

    move-object/from16 v0, p1

    if-ne v0, v15, :cond_e

    :cond_d
    const/16 v9, 0x41

    goto :goto_5

    :cond_e
    const/16 v9, 0x49

    goto :goto_5

    .line 66
    .restart local v7    # "length":I
    .restart local v9    # "mode":C
    :cond_f
    add-int/lit8 v15, v7, -0x1

    invoke-virtual {v12, v15}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v6

    .line 67
    .local v6, "last":C
    const/16 v15, 0xd

    if-ne v6, v15, :cond_10

    .line 68
    const/4 v4, 0x1

    .line 75
    :goto_7
    sub-int/2addr v7, v4

    goto :goto_6

    .line 69
    :cond_10
    const/16 v15, 0xa

    if-eq v6, v15, :cond_11

    .line 70
    const/4 v4, 0x0

    goto :goto_7

    .line 71
    :cond_11
    const/4 v15, 0x2

    if-le v6, v15, :cond_12

    add-int/lit8 v15, v7, -0x2

    invoke-virtual {v12, v15}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v15

    const/16 v16, 0xd

    move/from16 v0, v16

    if-ne v15, v0, :cond_12

    .line 72
    const/4 v4, 0x2

    goto :goto_7

    .line 74
    :cond_12
    const/4 v4, 0x1

    goto :goto_7

    .end local v6    # "last":C
    .end local v7    # "length":I
    .end local v9    # "mode":C
    .end local v12    # "sbuf":Ljava/lang/StringBuffer;
    :cond_13
    move v11, v10

    .end local v10    # "pos":I
    .restart local v11    # "pos":I
    goto/16 :goto_1
.end method
