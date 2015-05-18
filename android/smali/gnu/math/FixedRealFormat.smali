.class public Lgnu/math/FixedRealFormat;
.super Ljava/text/Format;
.source "FixedRealFormat.java"


# instance fields
.field private d:I

.field private i:I

.field public internalPad:Z

.field public overflowChar:C

.field public padChar:C

.field public scale:I

.field public showPlus:Z

.field public width:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/text/Format;-><init>()V

    return-void
.end method

.method private format(Ljava/lang/StringBuffer;Ljava/text/FieldPosition;IIIII)V
    .locals 8
    .param p1, "sbuf"    # Ljava/lang/StringBuffer;
    .param p2, "fpos"    # Ljava/text/FieldPosition;
    .param p3, "length"    # I
    .param p4, "digits"    # I
    .param p5, "decimals"    # I
    .param p6, "signLen"    # I
    .param p7, "oldSize"    # I

    .prologue
    .line 214
    add-int v4, p4, p5

    .line 216
    .local v4, "total_digits":I
    invoke-virtual {p0}, Lgnu/math/FixedRealFormat;->getMinimumIntegerDigits()I

    move-result v5

    .line 217
    .local v5, "zero_digits":I
    if-ltz p4, :cond_2

    if-le p4, v5, :cond_2

    .line 218
    const/4 v5, 0x0

    .line 222
    :goto_0
    add-int v6, p4, v5

    if-gtz v6, :cond_1

    iget v6, p0, Lgnu/math/FixedRealFormat;->width:I

    if-lez v6, :cond_0

    iget v6, p0, Lgnu/math/FixedRealFormat;->width:I

    add-int/lit8 v7, p5, 0x1

    add-int/2addr v7, p6

    if-le v6, v7, :cond_1

    .line 224
    :cond_0
    add-int/lit8 v5, v5, 0x1

    .line 225
    :cond_1
    add-int v6, p6, p3

    add-int/2addr v6, v5

    add-int/lit8 v1, v6, 0x1

    .line 226
    .local v1, "needed":I
    iget v6, p0, Lgnu/math/FixedRealFormat;->width:I

    sub-int v3, v6, v1

    .line 227
    .local v3, "padding":I
    move v0, v5

    .local v0, "i":I
    :goto_1
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_3

    .line 228
    add-int v6, p7, p6

    const/16 v7, 0x30

    invoke-virtual {p1, v6, v7}, Ljava/lang/StringBuffer;->insert(IC)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 220
    .end local v0    # "i":I
    .end local v1    # "needed":I
    .end local v3    # "padding":I
    :cond_2
    sub-int/2addr v5, p4

    goto :goto_0

    .line 229
    .restart local v0    # "i":I
    .restart local v1    # "needed":I
    .restart local v3    # "padding":I
    :cond_3
    if-ltz v3, :cond_5

    .line 231
    move v0, p7

    .line 232
    iget-boolean v6, p0, Lgnu/math/FixedRealFormat;->internalPad:Z

    if-eqz v6, :cond_4

    if-lez p6, :cond_4

    .line 233
    add-int/lit8 v0, v0, 0x1

    .line 234
    :cond_4
    :goto_2
    add-int/lit8 v3, v3, -0x1

    if-ltz v3, :cond_6

    .line 235
    iget-char v6, p0, Lgnu/math/FixedRealFormat;->padChar:C

    invoke-virtual {p1, v0, v6}, Ljava/lang/StringBuffer;->insert(IC)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 237
    :cond_5
    iget-char v6, p0, Lgnu/math/FixedRealFormat;->overflowChar:C

    if-eqz v6, :cond_6

    .line 239
    invoke-virtual {p1, p7}, Ljava/lang/StringBuffer;->setLength(I)V

    .line 240
    iget v6, p0, Lgnu/math/FixedRealFormat;->width:I

    iput v6, p0, Lgnu/math/FixedRealFormat;->i:I

    :goto_3
    iget v6, p0, Lgnu/math/FixedRealFormat;->i:I

    add-int/lit8 v6, v6, -0x1

    iput v6, p0, Lgnu/math/FixedRealFormat;->i:I

    if-ltz v6, :cond_7

    .line 241
    iget-char v6, p0, Lgnu/math/FixedRealFormat;->overflowChar:C

    invoke-virtual {p1, v6}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_3

    .line 244
    :cond_6
    invoke-virtual {p1}, Ljava/lang/StringBuffer;->length()I

    move-result v2

    .line 245
    .local v2, "newSize":I
    sub-int v6, v2, p5

    const/16 v7, 0x2e

    invoke-virtual {p1, v6, v7}, Ljava/lang/StringBuffer;->insert(IC)Ljava/lang/StringBuffer;

    .line 263
    .end local v2    # "newSize":I
    :cond_7
    return-void
.end method


# virtual methods
.method public format(DLjava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;
    .locals 25
    .param p1, "num"    # D
    .param p3, "sbuf"    # Ljava/lang/StringBuffer;
    .param p4, "fpos"    # Ljava/text/FieldPosition;

    .prologue
    .line 68
    invoke-static/range {p1 .. p2}, Ljava/lang/Double;->isNaN(D)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-static/range {p1 .. p2}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 69
    :cond_0
    move-object/from16 v0, p3

    move-wide/from16 v1, p1

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuffer;->append(D)Ljava/lang/StringBuffer;

    move-result-object p3

    .line 188
    .end local p3    # "sbuf":Ljava/lang/StringBuffer;
    :goto_0
    return-object p3

    .line 70
    .restart local p3    # "sbuf":Ljava/lang/StringBuffer;
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lgnu/math/FixedRealFormat;->getMaximumFractionDigits()I

    move-result v3

    if-ltz v3, :cond_2

    .line 71
    invoke-static/range {p1 .. p2}, Lgnu/math/DFloNum;->toExact(D)Lgnu/math/RatNum;

    move-result-object v3

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p4

    invoke-virtual {v0, v3, v1, v2}, Lgnu/math/FixedRealFormat;->format(Lgnu/math/RealNum;Ljava/lang/StringBuffer;Ljava/text/FieldPosition;)V

    goto :goto_0

    .line 75
    :cond_2
    const-wide/16 v3, 0x0

    cmpg-double v3, p1, v3

    if-gez v3, :cond_6

    .line 77
    const/16 v18, 0x1

    .line 78
    .local v18, "negative":Z
    move-wide/from16 v0, p1

    neg-double v0, v0

    move-wide/from16 p1, v0

    .line 82
    :goto_1
    invoke-virtual/range {p3 .. p3}, Ljava/lang/StringBuffer;->length()I

    move-result v10

    .line 83
    .local v10, "oldSize":I
    const/16 v22, 0x1

    .line 84
    .local v22, "signLen":I
    if-eqz v18, :cond_7

    .line 85
    const/16 v3, 0x2d

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 91
    :goto_2
    invoke-static/range {p1 .. p2}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v24

    .line 92
    .local v24, "string":Ljava/lang/String;
    move-object/from16 v0, p0

    iget v12, v0, Lgnu/math/FixedRealFormat;->scale:I

    .line 93
    .local v12, "cur_scale":I
    const/16 v3, 0x45

    move-object/from16 v0, v24

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v21

    .line 94
    .local v21, "seenE":I
    if-ltz v21, :cond_4

    .line 96
    add-int/lit8 v15, v21, 0x1

    .line 97
    .local v15, "expStart":I
    move-object/from16 v0, v24

    invoke-virtual {v0, v15}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x2b

    if-ne v3, v4, :cond_3

    .line 98
    add-int/lit8 v15, v15, 0x1

    .line 99
    :cond_3
    move-object/from16 v0, v24

    invoke-virtual {v0, v15}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v3

    add-int/2addr v12, v3

    .line 100
    const/4 v3, 0x0

    move-object/from16 v0, v24

    move/from16 v1, v21

    invoke-virtual {v0, v3, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v24

    .line 102
    .end local v15    # "expStart":I
    :cond_4
    const/16 v3, 0x2e

    move-object/from16 v0, v24

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(I)I

    move-result v20

    .line 103
    .local v20, "seenDot":I
    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v6

    .line 104
    .local v6, "length":I
    if-ltz v20, :cond_5

    .line 106
    sub-int v3, v6, v20

    add-int/lit8 v3, v3, -0x1

    sub-int/2addr v12, v3

    .line 107
    add-int/lit8 v6, v6, -0x1

    .line 108
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v4, 0x0

    move-object/from16 v0, v24

    move/from16 v1, v20

    invoke-virtual {v0, v4, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    add-int/lit8 v4, v20, 0x1

    move-object/from16 v0, v24

    invoke-virtual {v0, v4}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    .line 111
    :cond_5
    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->length()I

    move-result v16

    .line 114
    .local v16, "i":I
    const/16 v17, 0x0

    .line 115
    .local v17, "initial_zeros":I
    :goto_3
    add-int/lit8 v3, v16, -0x1

    move/from16 v0, v17

    if-ge v0, v3, :cond_9

    move-object/from16 v0, v24

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x30

    if-ne v3, v4, :cond_9

    .line 116
    add-int/lit8 v17, v17, 0x1

    goto :goto_3

    .line 81
    .end local v6    # "length":I
    .end local v10    # "oldSize":I
    .end local v12    # "cur_scale":I
    .end local v16    # "i":I
    .end local v17    # "initial_zeros":I
    .end local v18    # "negative":Z
    .end local v20    # "seenDot":I
    .end local v21    # "seenE":I
    .end local v22    # "signLen":I
    .end local v24    # "string":Ljava/lang/String;
    :cond_6
    const/16 v18, 0x0

    .restart local v18    # "negative":Z
    goto/16 :goto_1

    .line 86
    .restart local v10    # "oldSize":I
    .restart local v22    # "signLen":I
    :cond_7
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lgnu/math/FixedRealFormat;->showPlus:Z

    if-eqz v3, :cond_8

    .line 87
    const/16 v3, 0x2b

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto/16 :goto_2

    .line 89
    :cond_8
    const/16 v22, 0x0

    goto/16 :goto_2

    .line 117
    .restart local v6    # "length":I
    .restart local v12    # "cur_scale":I
    .restart local v16    # "i":I
    .restart local v17    # "initial_zeros":I
    .restart local v20    # "seenDot":I
    .restart local v21    # "seenE":I
    .restart local v24    # "string":Ljava/lang/String;
    :cond_9
    if-lez v17, :cond_a

    .line 119
    move-object/from16 v0, v24

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v24

    .line 120
    sub-int v16, v16, v17

    .line 124
    :cond_a
    add-int v7, v16, v12

    .line 125
    .local v7, "digits":I
    move-object/from16 v0, p0

    iget v3, v0, Lgnu/math/FixedRealFormat;->width:I

    if-lez v3, :cond_d

    .line 129
    :goto_4
    if-gez v7, :cond_b

    .line 131
    const/16 v3, 0x30

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 132
    add-int/lit8 v7, v7, 0x1

    .line 133
    add-int/lit8 v16, v16, 0x1

    goto :goto_4

    .line 135
    :cond_b
    move-object/from16 v0, p0

    iget v3, v0, Lgnu/math/FixedRealFormat;->width:I

    sub-int v3, v3, v22

    add-int/lit8 v3, v3, -0x1

    sub-int v8, v3, v7

    .line 139
    .local v8, "decimals":I
    :goto_5
    if-gez v8, :cond_c

    .line 140
    const/4 v8, 0x0

    .line 141
    :cond_c
    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 142
    :goto_6
    if-lez v12, :cond_f

    .line 144
    const/16 v3, 0x30

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 145
    add-int/lit8 v12, v12, -0x1

    .line 146
    add-int/lit8 v16, v16, 0x1

    goto :goto_6

    .line 138
    .end local v8    # "decimals":I
    :cond_d
    const/16 v3, 0x10

    move/from16 v0, v16

    if-le v0, v3, :cond_e

    const/16 v3, 0x10

    :goto_7
    sub-int v8, v3, v7

    .restart local v8    # "decimals":I
    goto :goto_5

    .end local v8    # "decimals":I
    :cond_e
    move/from16 v3, v16

    goto :goto_7

    .line 148
    .restart local v8    # "decimals":I
    :cond_f
    add-int v14, v10, v22

    .line 149
    .local v14, "digStart":I
    add-int v3, v14, v7

    add-int v13, v3, v8

    .line 150
    .local v13, "digEnd":I
    invoke-virtual/range {p3 .. p3}, Ljava/lang/StringBuffer;->length()I

    move-result v16

    .line 152
    move/from16 v0, v16

    if-lt v13, v0, :cond_10

    .line 154
    move/from16 v13, v16

    .line 155
    const/16 v19, 0x30

    .line 159
    .local v19, "nextDigit":C
    :goto_8
    const/16 v3, 0x35

    move/from16 v0, v19

    if-lt v0, v3, :cond_11

    const/4 v11, 0x1

    .line 160
    .local v11, "addOne":Z
    :goto_9
    if-eqz v11, :cond_12

    const/16 v23, 0x39

    .line 161
    .local v23, "skip":C
    :goto_a
    add-int v3, v14, v7

    if-le v13, v3, :cond_13

    add-int/lit8 v3, v13, -0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v3

    move/from16 v0, v23

    if-ne v3, v0, :cond_13

    .line 162
    add-int/lit8 v13, v13, -0x1

    goto :goto_a

    .line 158
    .end local v11    # "addOne":Z
    .end local v19    # "nextDigit":C
    .end local v23    # "skip":C
    :cond_10
    move-object/from16 v0, p3

    invoke-virtual {v0, v13}, Ljava/lang/StringBuffer;->charAt(I)C

    move-result v19

    .restart local v19    # "nextDigit":C
    goto :goto_8

    .line 159
    :cond_11
    const/4 v11, 0x0

    goto :goto_9

    .line 160
    .restart local v11    # "addOne":Z
    :cond_12
    const/16 v23, 0x30

    goto :goto_a

    .line 163
    .restart local v23    # "skip":C
    :cond_13
    sub-int v6, v13, v14

    .line 164
    sub-int v8, v6, v7

    .line 165
    if-eqz v11, :cond_14

    .line 167
    move-object/from16 v0, p3

    invoke-static {v0, v14, v13}, Lgnu/math/ExponentialFormat;->addOne(Ljava/lang/StringBuffer;II)Z

    move-result v3

    if-eqz v3, :cond_14

    .line 169
    add-int/lit8 v7, v7, 0x1

    .line 170
    const/4 v8, 0x0

    .line 171
    move v6, v7

    .line 174
    :cond_14
    if-nez v8, :cond_16

    move-object/from16 v0, p0

    iget v3, v0, Lgnu/math/FixedRealFormat;->width:I

    if-lez v3, :cond_15

    add-int v3, v22, v7

    add-int/lit8 v3, v3, 0x1

    move-object/from16 v0, p0

    iget v4, v0, Lgnu/math/FixedRealFormat;->width:I

    if-ge v3, v4, :cond_16

    .line 177
    :cond_15
    const/4 v8, 0x1

    .line 178
    add-int/lit8 v6, v6, 0x1

    .line 180
    add-int v3, v14, v7

    const/16 v4, 0x30

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v4}, Ljava/lang/StringBuffer;->insert(IC)Ljava/lang/StringBuffer;

    .line 182
    :cond_16
    add-int v3, v14, v6

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->setLength(I)V

    .line 184
    if-eqz v18, :cond_17

    const/4 v9, 0x1

    :goto_b
    move-object/from16 v3, p0

    move-object/from16 v4, p3

    move-object/from16 v5, p4

    invoke-direct/range {v3 .. v10}, Lgnu/math/FixedRealFormat;->format(Ljava/lang/StringBuffer;Ljava/text/FieldPosition;IIIII)V

    goto/16 :goto_0

    :cond_17
    const/4 v9, 0x0

    goto :goto_b
.end method

.method public format(JLjava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;
    .locals 1
    .param p1, "num"    # J
    .param p3, "sbuf"    # Ljava/lang/StringBuffer;
    .param p4, "fpos"    # Ljava/text/FieldPosition;

    .prologue
    .line 62
    invoke-static {p1, p2}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v0

    invoke-virtual {p0, v0, p3, p4}, Lgnu/math/FixedRealFormat;->format(Lgnu/math/RealNum;Ljava/lang/StringBuffer;Ljava/text/FieldPosition;)V

    .line 63
    return-object p3
.end method

.method public format(Ljava/lang/Object;Ljava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;
    .locals 5
    .param p1, "num"    # Ljava/lang/Object;
    .param p2, "sbuf"    # Ljava/lang/StringBuffer;
    .param p3, "fpos"    # Ljava/text/FieldPosition;

    .prologue
    .line 193
    invoke-static {p1}, Lgnu/math/RealNum;->asRealNumOrNull(Ljava/lang/Object;)Lgnu/math/RealNum;

    move-result-object v1

    .line 194
    .local v1, "rnum":Lgnu/math/RealNum;
    if-nez v1, :cond_2

    .line 196
    instance-of v3, p1, Lgnu/math/Complex;

    if-eqz v3, :cond_1

    .line 199
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 200
    .local v2, "str":Ljava/lang/String;
    iget v3, p0, Lgnu/math/FixedRealFormat;->width:I

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    sub-int v0, v3, v4

    .line 201
    .local v0, "padding":I
    :goto_0
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_0

    .line 202
    const/16 v3, 0x20

    invoke-virtual {p2, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 203
    :cond_0
    invoke-virtual {p2, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 208
    .end local v0    # "padding":I
    .end local v2    # "str":Ljava/lang/String;
    .end local p2    # "sbuf":Ljava/lang/StringBuffer;
    :goto_1
    return-object p2

    .restart local p2    # "sbuf":Ljava/lang/StringBuffer;
    :cond_1
    move-object v1, p1

    .line 206
    check-cast v1, Lgnu/math/RealNum;

    .line 208
    :cond_2
    invoke-virtual {v1}, Lgnu/math/RealNum;->doubleValue()D

    move-result-wide v3

    invoke-virtual {p0, v3, v4, p2, p3}, Lgnu/math/FixedRealFormat;->format(DLjava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;

    move-result-object p2

    goto :goto_1
.end method

.method public format(Lgnu/math/RealNum;Ljava/lang/StringBuffer;Ljava/text/FieldPosition;)V
    .locals 11
    .param p1, "number"    # Lgnu/math/RealNum;
    .param p2, "sbuf"    # Ljava/lang/StringBuffer;
    .param p3, "fpos"    # Ljava/text/FieldPosition;

    .prologue
    .line 34
    instance-of v0, p1, Lgnu/math/RatNum;

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lgnu/math/FixedRealFormat;->getMaximumFractionDigits()I

    move-result v5

    .local v5, "decimals":I
    if-ltz v5, :cond_3

    move-object v9, p1

    .line 37
    check-cast v9, Lgnu/math/RatNum;

    .line 38
    .local v9, "ratnum":Lgnu/math/RatNum;
    invoke-virtual {v9}, Lgnu/math/RatNum;->isNegative()Z

    move-result v8

    .line 39
    .local v8, "negative":Z
    if-eqz v8, :cond_0

    .line 40
    invoke-virtual {v9}, Lgnu/math/RatNum;->rneg()Lgnu/math/RatNum;

    move-result-object v9

    .line 41
    :cond_0
    invoke-virtual {p2}, Ljava/lang/StringBuffer;->length()I

    move-result v7

    .line 42
    .local v7, "oldSize":I
    const/4 v6, 0x1

    .line 43
    .local v6, "signLen":I
    if-eqz v8, :cond_1

    .line 44
    const/16 v0, 0x2d

    invoke-virtual {p2, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 49
    :goto_0
    iget v0, p0, Lgnu/math/FixedRealFormat;->scale:I

    add-int/2addr v0, v5

    invoke-static {v9, v0}, Lgnu/math/RealNum;->toScaledInt(Lgnu/math/RatNum;I)Lgnu/math/IntNum;

    move-result-object v0

    invoke-virtual {v0}, Lgnu/math/IntNum;->toString()Ljava/lang/String;

    move-result-object v10

    .line 51
    .local v10, "string":Ljava/lang/String;
    invoke-virtual {p2, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 52
    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v3

    .line 53
    .local v3, "length":I
    sub-int v4, v3, v5

    .local v4, "digits":I
    move-object v0, p0

    move-object v1, p2

    move-object v2, p3

    .line 54
    invoke-direct/range {v0 .. v7}, Lgnu/math/FixedRealFormat;->format(Ljava/lang/StringBuffer;Ljava/text/FieldPosition;IIIII)V

    .line 58
    .end local v3    # "length":I
    .end local v4    # "digits":I
    .end local v5    # "decimals":I
    .end local v6    # "signLen":I
    .end local v7    # "oldSize":I
    .end local v8    # "negative":Z
    .end local v9    # "ratnum":Lgnu/math/RatNum;
    .end local v10    # "string":Ljava/lang/String;
    :goto_1
    return-void

    .line 45
    .restart local v5    # "decimals":I
    .restart local v6    # "signLen":I
    .restart local v7    # "oldSize":I
    .restart local v8    # "negative":Z
    .restart local v9    # "ratnum":Lgnu/math/RatNum;
    :cond_1
    iget-boolean v0, p0, Lgnu/math/FixedRealFormat;->showPlus:Z

    if-eqz v0, :cond_2

    .line 46
    const/16 v0, 0x2b

    invoke-virtual {p2, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 48
    :cond_2
    const/4 v6, 0x0

    goto :goto_0

    .line 57
    .end local v5    # "decimals":I
    .end local v6    # "signLen":I
    .end local v7    # "oldSize":I
    .end local v8    # "negative":Z
    .end local v9    # "ratnum":Lgnu/math/RatNum;
    :cond_3
    invoke-virtual {p1}, Lgnu/math/RealNum;->doubleValue()D

    move-result-wide v0

    invoke-virtual {p0, v0, v1, p2, p3}, Lgnu/math/FixedRealFormat;->format(DLjava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;

    goto :goto_1
.end method

.method public getMaximumFractionDigits()I
    .locals 1

    .prologue
    .line 18
    iget v0, p0, Lgnu/math/FixedRealFormat;->d:I

    return v0
.end method

.method public getMinimumIntegerDigits()I
    .locals 1

    .prologue
    .line 19
    iget v0, p0, Lgnu/math/FixedRealFormat;->i:I

    return v0
.end method

.method public parse(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/lang/Number;
    .locals 2
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "status"    # Ljava/text/ParsePosition;

    .prologue
    .line 267
    new-instance v0, Ljava/lang/Error;

    const-string v1, "RealFixedFormat.parse - not implemented"

    invoke-direct {v0, v1}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public parseObject(Ljava/lang/String;Ljava/text/ParsePosition;)Ljava/lang/Object;
    .locals 2
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "status"    # Ljava/text/ParsePosition;

    .prologue
    .line 271
    new-instance v0, Ljava/lang/Error;

    const-string v1, "RealFixedFormat.parseObject - not implemented"

    invoke-direct {v0, v1}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setMaximumFractionDigits(I)V
    .locals 0
    .param p1, "d"    # I

    .prologue
    .line 20
    iput p1, p0, Lgnu/math/FixedRealFormat;->d:I

    return-void
.end method

.method public setMinimumIntegerDigits(I)V
    .locals 0
    .param p1, "i"    # I

    .prologue
    .line 21
    iput p1, p0, Lgnu/math/FixedRealFormat;->i:I

    return-void
.end method
