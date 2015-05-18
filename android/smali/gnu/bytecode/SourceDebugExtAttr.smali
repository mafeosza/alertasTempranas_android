.class public Lgnu/bytecode/SourceDebugExtAttr;
.super Lgnu/bytecode/Attribute;
.source "SourceDebugExtAttr.java"


# instance fields
.field curFileIndex:I

.field curFileName:Ljava/lang/String;

.field curLineIndex:I

.field data:[B

.field private defaultStratumId:Ljava/lang/String;

.field dlength:I

.field fileCount:I

.field fileIDs:[I

.field fileNames:[Ljava/lang/String;

.field lineCount:I

.field lines:[I

.field maxFileID:I

.field private outputFileName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lgnu/bytecode/ClassType;)V
    .locals 2
    .param p1, "cl"    # Lgnu/bytecode/ClassType;

    .prologue
    const/4 v1, -0x1

    .line 193
    const-string v0, "SourceDebugExtension"

    invoke-direct {p0, v0}, Lgnu/bytecode/Attribute;-><init>(Ljava/lang/String;)V

    .line 37
    iput v1, p0, Lgnu/bytecode/SourceDebugExtAttr;->curLineIndex:I

    .line 38
    iput v1, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileIndex:I

    .line 194
    invoke-virtual {p0, p1}, Lgnu/bytecode/SourceDebugExtAttr;->addToFrontOf(Lgnu/bytecode/AttrContainer;)V

    .line 195
    return-void
.end method

.method private fixLine(II)I
    .locals 8
    .param p1, "sourceLine"    # I
    .param p2, "index"    # I

    .prologue
    const/4 v4, -0x1

    .line 44
    iget-object v5, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    aget v3, v5, p2

    .line 45
    .local v3, "sourceMin":I
    iget-object v5, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v6, p2, 0x2

    aget v1, v5, v6

    .line 46
    .local v1, "repeat":I
    if-ge p1, v3, :cond_2

    .line 48
    if-lez p2, :cond_1

    .line 65
    :cond_0
    :goto_0
    return v4

    .line 50
    :cond_1
    add-int v5, v3, v1

    add-int/lit8 v2, v5, -0x1

    .line 51
    .local v2, "sourceMax":I
    iget-object v5, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    aput p1, v5, p2

    .line 52
    iget-object v5, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v6, p2, 0x2

    sub-int v7, v2, p1

    add-int/lit8 v7, v7, 0x1

    aput v7, v5, v6

    .line 53
    iget-object v5, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v6, p2, 0x3

    aput p1, v5, v6

    .line 54
    move v3, p1

    .line 56
    .end local v2    # "sourceMax":I
    :cond_2
    iget-object v5, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v6, p2, 0x3

    aget v5, v5, v6

    sub-int v0, v5, v3

    .line 57
    .local v0, "delta":I
    add-int v5, v3, v1

    if-ge p1, v5, :cond_3

    .line 58
    add-int v4, p1, v0

    goto :goto_0

    .line 59
    :cond_3
    iget v5, p0, Lgnu/bytecode/SourceDebugExtAttr;->lineCount:I

    add-int/lit8 v5, v5, -0x1

    mul-int/lit8 v5, v5, 0x5

    if-eq p2, v5, :cond_4

    if-nez p2, :cond_0

    iget-object v5, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    const/16 v6, 0x8

    aget v5, v5, v6

    if-ge p1, v5, :cond_0

    .line 62
    :cond_4
    iget-object v4, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v5, p2, 0x2

    sub-int v6, p1, v3

    add-int/lit8 v6, v6, 0x1

    aput v6, v4, v5

    .line 63
    add-int v4, p1, v0

    goto :goto_0
.end method


# virtual methods
.method addFile(Ljava/lang/String;)V
    .locals 13
    .param p1, "fname"    # Ljava/lang/String;

    .prologue
    const/4 v12, 0x5

    const/4 v11, -0x1

    const/4 v10, 0x0

    .line 127
    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileName:Ljava/lang/String;

    if-eq v8, p1, :cond_0

    if-eqz p1, :cond_1

    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileName:Ljava/lang/String;

    invoke-virtual {p1, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 183
    :cond_0
    :goto_0
    return-void

    .line 129
    :cond_1
    iput-object p1, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileName:Ljava/lang/String;

    .line 130
    invoke-static {p1}, Lgnu/bytecode/SourceFileAttr;->fixSourceFile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .line 132
    const/16 v8, 0x2f

    invoke-virtual {p1, v8}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v7

    .line 133
    .local v7, "slash":I
    if-ltz v7, :cond_3

    .line 135
    move-object v1, p1

    .line 136
    .local v1, "fpath":Ljava/lang/String;
    add-int/lit8 v8, v7, 0x1

    invoke-virtual {p1, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p1

    .line 137
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const/16 v9, 0xa

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 142
    .end local v1    # "fpath":Ljava/lang/String;
    .local v0, "fentry":Ljava/lang/String;
    :goto_1
    iget v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileIndex:I

    if-ltz v8, :cond_2

    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileNames:[Ljava/lang/String;

    iget v9, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileIndex:I

    aget-object v8, v8, v9

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_0

    .line 145
    :cond_2
    iget v4, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileCount:I

    .line 146
    .local v4, "n":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_2
    if-ge v2, v4, :cond_5

    .line 148
    iget v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileIndex:I

    if-eq v2, v8, :cond_4

    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileNames:[Ljava/lang/String;

    aget-object v8, v8, v2

    invoke-virtual {v0, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    .line 150
    iput v2, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileIndex:I

    .line 151
    iput v11, p0, Lgnu/bytecode/SourceDebugExtAttr;->curLineIndex:I

    goto :goto_0

    .line 140
    .end local v0    # "fentry":Ljava/lang/String;
    .end local v2    # "i":I
    .end local v4    # "n":I
    :cond_3
    move-object v0, p1

    .restart local v0    # "fentry":Ljava/lang/String;
    goto :goto_1

    .line 146
    .restart local v2    # "i":I
    .restart local v4    # "n":I
    :cond_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 156
    :cond_5
    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileIDs:[I

    if-nez v8, :cond_9

    .line 158
    new-array v8, v12, [I

    iput-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileIDs:[I

    .line 159
    new-array v8, v12, [Ljava/lang/String;

    iput-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileNames:[Ljava/lang/String;

    .line 172
    :cond_6
    :goto_3
    iget v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileCount:I

    add-int/lit8 v8, v8, 0x1

    iput v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileCount:I

    .line 173
    iget v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->maxFileID:I

    add-int/lit8 v3, v8, 0x1

    iput v3, p0, Lgnu/bytecode/SourceDebugExtAttr;->maxFileID:I

    .line 174
    .local v3, "id":I
    shl-int/lit8 v3, v3, 0x1

    .line 175
    if-ltz v7, :cond_7

    .line 176
    add-int/lit8 v3, v3, 0x1

    .line 177
    :cond_7
    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileNames:[Ljava/lang/String;

    aput-object v0, v8, v4

    .line 178
    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->outputFileName:Ljava/lang/String;

    if-nez v8, :cond_8

    .line 179
    iput-object p1, p0, Lgnu/bytecode/SourceDebugExtAttr;->outputFileName:Ljava/lang/String;

    .line 180
    :cond_8
    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileIDs:[I

    aput v3, v8, v4

    .line 181
    iput v4, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileIndex:I

    .line 182
    iput v11, p0, Lgnu/bytecode/SourceDebugExtAttr;->curLineIndex:I

    goto/16 :goto_0

    .line 161
    .end local v3    # "id":I
    :cond_9
    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileIDs:[I

    array-length v8, v8

    if-lt v4, v8, :cond_6

    .line 163
    mul-int/lit8 v8, v4, 0x2

    new-array v5, v8, [I

    .line 164
    .local v5, "newIDs":[I
    mul-int/lit8 v8, v4, 0x2

    new-array v6, v8, [Ljava/lang/String;

    .line 165
    .local v6, "newNames":[Ljava/lang/String;
    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileIDs:[I

    invoke-static {v8, v10, v5, v10, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 166
    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileNames:[Ljava/lang/String;

    invoke-static {v8, v10, v6, v10, v4}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 167
    iput-object v5, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileIDs:[I

    .line 168
    iput-object v6, p0, Lgnu/bytecode/SourceDebugExtAttr;->fileNames:[Ljava/lang/String;

    goto :goto_3
.end method

.method public addStratum(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 187
    iput-object p1, p0, Lgnu/bytecode/SourceDebugExtAttr;->defaultStratumId:Ljava/lang/String;

    .line 188
    return-void
.end method

.method public assignConstants(Lgnu/bytecode/ClassType;)V
    .locals 17
    .param p1, "cl"    # Lgnu/bytecode/ClassType;

    .prologue
    .line 206
    invoke-super/range {p0 .. p1}, Lgnu/bytecode/Attribute;->assignConstants(Lgnu/bytecode/ClassType;)V

    .line 208
    new-instance v11, Ljava/lang/StringBuffer;

    invoke-direct {v11}, Ljava/lang/StringBuffer;-><init>()V

    .line 210
    .local v11, "sbuf":Ljava/lang/StringBuffer;
    const-string v14, "SMAP\n"

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 211
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->outputFileName:Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-virtual {v0, v14, v11}, Lgnu/bytecode/SourceDebugExtAttr;->nonAsteriskString(Ljava/lang/String;Ljava/lang/StringBuffer;)V

    const/16 v14, 0xa

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 212
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->defaultStratumId:Ljava/lang/String;

    if-nez v14, :cond_1

    const-string v12, "Java"

    .line 213
    .local v12, "stratum":Ljava/lang/String;
    :goto_0
    move-object/from16 v0, p0

    invoke-virtual {v0, v12, v11}, Lgnu/bytecode/SourceDebugExtAttr;->nonAsteriskString(Ljava/lang/String;Ljava/lang/StringBuffer;)V

    .line 214
    const/16 v14, 0xa

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 216
    const-string v14, "*S "

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 217
    invoke-virtual {v11, v12}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 218
    const/16 v14, 0xa

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 220
    const-string v14, "*F\n"

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 221
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    move-object/from16 v0, p0

    iget v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->fileCount:I

    if-ge v2, v14, :cond_3

    .line 223
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->fileIDs:[I

    aget v4, v14, v2

    .line 224
    .local v4, "id":I
    and-int/lit8 v14, v4, 0x1

    if-eqz v14, :cond_2

    const/4 v13, 0x1

    .line 225
    .local v13, "with_path":Z
    :goto_2
    shr-int/lit8 v4, v4, 0x1

    .line 226
    if-eqz v13, :cond_0

    .line 227
    const-string v14, "+ "

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 228
    :cond_0
    invoke-virtual {v11, v4}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    const/16 v14, 0x20

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 229
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->fileNames:[Ljava/lang/String;

    aget-object v14, v14, v2

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    const/16 v14, 0xa

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 221
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 212
    .end local v2    # "i":I
    .end local v4    # "id":I
    .end local v12    # "stratum":Ljava/lang/String;
    .end local v13    # "with_path":Z
    :cond_1
    move-object/from16 v0, p0

    iget-object v12, v0, Lgnu/bytecode/SourceDebugExtAttr;->defaultStratumId:Ljava/lang/String;

    goto :goto_0

    .line 224
    .restart local v2    # "i":I
    .restart local v4    # "id":I
    .restart local v12    # "stratum":Ljava/lang/String;
    :cond_2
    const/4 v13, 0x0

    goto :goto_2

    .line 232
    .end local v4    # "id":I
    :cond_3
    move-object/from16 v0, p0

    iget v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->lineCount:I

    if-lez v14, :cond_8

    .line 234
    const/4 v9, 0x0

    .line 235
    .local v9, "prevFileID":I
    const-string v14, "*L\n"

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 236
    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 239
    .local v3, "i5":I
    :cond_4
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    aget v5, v14, v3

    .line 240
    .local v5, "inputStartLine":I
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->fileIDs:[I

    move-object/from16 v0, p0

    iget-object v15, v0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v16, v3, 0x1

    aget v15, v15, v16

    aget v14, v14, v15

    shr-int/lit8 v6, v14, 0x1

    .line 241
    .local v6, "lineFileID":I
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v15, v3, 0x2

    aget v10, v14, v15

    .line 242
    .local v10, "repeatCount":I
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v15, v3, 0x3

    aget v8, v14, v15

    .line 243
    .local v8, "outputStartLine":I
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v15, v3, 0x4

    aget v7, v14, v15

    .line 244
    .local v7, "outputLineIncrement":I
    invoke-virtual {v11, v5}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 245
    if-eq v6, v9, :cond_5

    .line 247
    const/16 v14, 0x23

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 248
    invoke-virtual {v11, v6}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 249
    move v9, v6

    .line 251
    :cond_5
    const/4 v14, 0x1

    if-eq v10, v14, :cond_6

    .line 253
    const/16 v14, 0x2c

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 254
    invoke-virtual {v11, v10}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 256
    :cond_6
    const/16 v14, 0x3a

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 257
    invoke-virtual {v11, v8}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 258
    const/4 v14, 0x1

    if-eq v7, v14, :cond_7

    .line 260
    const/16 v14, 0x2c

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 261
    invoke-virtual {v11, v7}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 263
    :cond_7
    const/16 v14, 0xa

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 264
    add-int/lit8 v3, v3, 0x5

    .line 266
    add-int/lit8 v2, v2, 0x1

    move-object/from16 v0, p0

    iget v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->lineCount:I

    if-lt v2, v14, :cond_4

    .line 269
    .end local v3    # "i5":I
    .end local v5    # "inputStartLine":I
    .end local v6    # "lineFileID":I
    .end local v7    # "outputLineIncrement":I
    .end local v8    # "outputStartLine":I
    .end local v9    # "prevFileID":I
    .end local v10    # "repeatCount":I
    :cond_8
    const-string v14, "*E\n"

    invoke-virtual {v11, v14}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 272
    :try_start_0
    invoke-virtual {v11}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v14

    const-string v15, "UTF-8"

    invoke-virtual {v14, v15}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v14

    move-object/from16 v0, p0

    iput-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->data:[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 278
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->data:[B

    array-length v14, v14

    move-object/from16 v0, p0

    iput v14, v0, Lgnu/bytecode/SourceDebugExtAttr;->dlength:I

    .line 279
    return-void

    .line 274
    :catch_0
    move-exception v1

    .line 276
    .local v1, "ex":Ljava/lang/Exception;
    new-instance v14, Ljava/lang/RuntimeException;

    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v14
.end method

.method fixLine(I)I
    .locals 11
    .param p1, "sourceLine"    # I

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 71
    iget v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->curLineIndex:I

    if-ltz v7, :cond_0

    .line 73
    iget v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->curLineIndex:I

    invoke-direct {p0, p1, v7}, Lgnu/bytecode/SourceDebugExtAttr;->fixLine(II)I

    move-result v5

    .line 74
    .local v5, "outLine":I
    if-ltz v5, :cond_0

    .line 122
    .end local v5    # "outLine":I
    :goto_0
    return v5

    .line 77
    :cond_0
    const/4 v2, 0x0

    .line 78
    .local v2, "i5":I
    iget v0, p0, Lgnu/bytecode/SourceDebugExtAttr;->curFileIndex:I

    .line 79
    .local v0, "findex":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lineCount:I

    if-ge v1, v7, :cond_2

    .line 81
    iget v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->curLineIndex:I

    if-eq v2, v7, :cond_1

    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v8, v2, 0x1

    aget v7, v7, v8

    if-ne v0, v7, :cond_1

    .line 83
    invoke-direct {p0, p1, v2}, Lgnu/bytecode/SourceDebugExtAttr;->fixLine(II)I

    move-result v5

    .line 84
    .restart local v5    # "outLine":I
    if-ltz v5, :cond_1

    .line 86
    iput v2, p0, Lgnu/bytecode/SourceDebugExtAttr;->curLineIndex:I

    goto :goto_0

    .line 90
    .end local v5    # "outLine":I
    :cond_1
    add-int/lit8 v2, v2, 0x5

    .line 79
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 92
    :cond_2
    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    if-nez v7, :cond_4

    .line 93
    const/16 v7, 0x14

    new-array v7, v7, [I

    iput-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    .line 101
    :cond_3
    :goto_2
    move v3, p1

    .line 102
    .local v3, "inputStartLine":I
    if-nez v2, :cond_5

    .line 103
    move v6, p1

    .line 115
    .local v6, "outputStartLine":I
    :goto_3
    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    aput v3, v7, v2

    .line 116
    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v8, v2, 0x1

    aput v0, v7, v8

    .line 117
    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v8, v2, 0x2

    aput v10, v7, v8

    .line 118
    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v8, v2, 0x3

    aput v6, v7, v8

    .line 119
    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v8, v2, 0x4

    aput v10, v7, v8

    .line 120
    iput v2, p0, Lgnu/bytecode/SourceDebugExtAttr;->curLineIndex:I

    .line 121
    iget v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lineCount:I

    add-int/lit8 v7, v7, 0x1

    iput v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lineCount:I

    move v5, p1

    .line 122
    goto :goto_0

    .line 94
    .end local v3    # "inputStartLine":I
    .end local v6    # "outputStartLine":I
    :cond_4
    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    array-length v7, v7

    if-lt v2, v7, :cond_3

    .line 96
    mul-int/lit8 v7, v2, 0x2

    new-array v4, v7, [I

    .line 97
    .local v4, "newLines":[I
    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    invoke-static {v7, v9, v4, v9, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 98
    iput-object v4, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    goto :goto_2

    .line 106
    .end local v4    # "newLines":[I
    .restart local v3    # "inputStartLine":I
    :cond_5
    iget-object v7, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v8, v2, -0x5

    add-int/lit8 v8, v8, 0x3

    aget v7, v7, v8

    iget-object v8, p0, Lgnu/bytecode/SourceDebugExtAttr;->lines:[I

    add-int/lit8 v9, v2, -0x5

    add-int/lit8 v9, v9, 0x2

    aget v8, v8, v9

    add-int v6, v7, v8

    .line 107
    .restart local v6    # "outputStartLine":I
    const/4 v7, 0x5

    if-ne v2, v7, :cond_6

    const/16 v7, 0x2710

    if-ge v6, v7, :cond_6

    .line 111
    const/16 v6, 0x2710

    .line 113
    :cond_6
    move p1, v6

    goto :goto_3
.end method

.method public getLength()I
    .locals 1

    .prologue
    .line 283
    iget v0, p0, Lgnu/bytecode/SourceDebugExtAttr;->dlength:I

    return v0
.end method

.method nonAsteriskString(Ljava/lang/String;Ljava/lang/StringBuffer;)V
    .locals 2
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "sbuf"    # Ljava/lang/StringBuffer;

    .prologue
    .line 199
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Ljava/lang/String;->charAt(I)C

    move-result v0

    const/16 v1, 0x2a

    if-ne v0, v1, :cond_1

    .line 200
    :cond_0
    const/16 v0, 0x20

    invoke-virtual {p2, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 201
    :cond_1
    invoke-virtual {p2, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 202
    return-void
.end method

.method public print(Lgnu/bytecode/ClassTypeWriter;)V
    .locals 6
    .param p1, "dst"    # Lgnu/bytecode/ClassTypeWriter;

    .prologue
    .line 295
    const-string v1, "Attribute \""

    invoke-virtual {p1, v1}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 296
    invoke-virtual {p0}, Lgnu/bytecode/SourceDebugExtAttr;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 297
    const-string v1, "\", length:"

    invoke-virtual {p1, v1}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 298
    iget v1, p0, Lgnu/bytecode/SourceDebugExtAttr;->dlength:I

    invoke-virtual {p1, v1}, Lgnu/bytecode/ClassTypeWriter;->println(I)V

    .line 301
    :try_start_0
    new-instance v1, Ljava/lang/String;

    iget-object v2, p0, Lgnu/bytecode/SourceDebugExtAttr;->data:[B

    const/4 v3, 0x0

    iget v4, p0, Lgnu/bytecode/SourceDebugExtAttr;->dlength:I

    const-string v5, "UTF-8"

    invoke-direct {v1, v2, v3, v4, v5}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V

    invoke-virtual {p1, v1}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 307
    :goto_0
    iget v1, p0, Lgnu/bytecode/SourceDebugExtAttr;->dlength:I

    if-lez v1, :cond_0

    iget-object v1, p0, Lgnu/bytecode/SourceDebugExtAttr;->data:[B

    iget v2, p0, Lgnu/bytecode/SourceDebugExtAttr;->dlength:I

    add-int/lit8 v2, v2, -0x1

    aget-byte v1, v1, v2

    const/16 v2, 0xd

    if-eq v1, v2, :cond_0

    iget-object v1, p0, Lgnu/bytecode/SourceDebugExtAttr;->data:[B

    iget v2, p0, Lgnu/bytecode/SourceDebugExtAttr;->dlength:I

    add-int/lit8 v2, v2, -0x1

    aget-byte v1, v1, v2

    const/16 v2, 0xa

    if-eq v1, v2, :cond_0

    .line 308
    invoke-virtual {p1}, Lgnu/bytecode/ClassTypeWriter;->println()V

    .line 309
    :cond_0
    return-void

    .line 303
    :catch_0
    move-exception v0

    .line 305
    .local v0, "ex":Ljava/lang/Exception;
    const-string v1, "(Caught "

    invoke-virtual {p1, v1}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p1, v0}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/Object;)V

    const/16 v1, 0x29

    invoke-virtual {p1, v1}, Lgnu/bytecode/ClassTypeWriter;->println(C)V

    goto :goto_0
.end method

.method public write(Ljava/io/DataOutputStream;)V
    .locals 3
    .param p1, "dstr"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 290
    iget-object v0, p0, Lgnu/bytecode/SourceDebugExtAttr;->data:[B

    const/4 v1, 0x0

    iget v2, p0, Lgnu/bytecode/SourceDebugExtAttr;->dlength:I

    invoke-virtual {p1, v0, v1, v2}, Ljava/io/DataOutputStream;->write([BII)V

    .line 291
    return-void
.end method
