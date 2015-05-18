.class public Lorg/json/Kim;
.super Ljava/lang/Object;
.source "Kim.java"


# instance fields
.field private bytes:[B

.field private hashcode:I

.field public length:I

.field private string:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 14
    .param p1, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const v13, 0xdbff

    const v12, 0xd800

    const/16 v11, 0x3fff

    const/16 v10, 0x7f

    const/4 v9, 0x0

    .line 154
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    const/4 v8, 0x0

    iput-object v8, p0, Lorg/json/Kim;->bytes:[B

    .line 74
    iput v9, p0, Lorg/json/Kim;->hashcode:I

    .line 80
    iput v9, p0, Lorg/json/Kim;->length:I

    .line 85
    const/4 v8, 0x0

    iput-object v8, p0, Lorg/json/Kim;->string:Ljava/lang/String;

    .line 155
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v6

    .line 156
    .local v6, "stringLength":I
    iput v9, p0, Lorg/json/Kim;->hashcode:I

    .line 157
    iput v9, p0, Lorg/json/Kim;->length:I

    .line 162
    if-lez v6, :cond_9

    .line 163
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    if-ge v5, v6, :cond_4

    .line 164
    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 165
    .local v2, "c":I
    if-gt v2, v10, :cond_0

    .line 166
    iget v8, p0, Lorg/json/Kim;->length:I

    add-int/lit8 v8, v8, 0x1

    iput v8, p0, Lorg/json/Kim;->length:I

    .line 163
    :goto_1
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 167
    :cond_0
    if-gt v2, v11, :cond_1

    .line 168
    iget v8, p0, Lorg/json/Kim;->length:I

    add-int/lit8 v8, v8, 0x2

    iput v8, p0, Lorg/json/Kim;->length:I

    goto :goto_1

    .line 170
    :cond_1
    if-lt v2, v12, :cond_3

    const v8, 0xdfff

    if-gt v2, v8, :cond_3

    .line 171
    add-int/lit8 v5, v5, 0x1

    .line 172
    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v4

    .line 173
    .local v4, "d":I
    if-gt v2, v13, :cond_2

    const v8, 0xdc00

    if-lt v4, v8, :cond_2

    const v8, 0xdfff

    if-le v4, v8, :cond_3

    .line 174
    :cond_2
    new-instance v8, Lorg/json/JSONException;

    const-string v9, "Bad UTF16"

    invoke-direct {v8, v9}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 177
    .end local v4    # "d":I
    :cond_3
    iget v8, p0, Lorg/json/Kim;->length:I

    add-int/lit8 v8, v8, 0x3

    iput v8, p0, Lorg/json/Kim;->length:I

    goto :goto_1

    .line 184
    .end local v2    # "c":I
    :cond_4
    iget v8, p0, Lorg/json/Kim;->length:I

    new-array v8, v8, [B

    iput-object v8, p0, Lorg/json/Kim;->bytes:[B

    .line 185
    const/4 v0, 0x0

    .line 187
    .local v0, "at":I
    const/4 v7, 0x1

    .line 188
    .local v7, "sum":I
    const/4 v5, 0x0

    :goto_2
    if-ge v5, v6, :cond_8

    .line 189
    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v3

    .line 190
    .local v3, "character":I
    if-gt v3, v10, :cond_5

    .line 191
    iget-object v8, p0, Lorg/json/Kim;->bytes:[B

    int-to-byte v9, v3

    aput-byte v9, v8, v0

    .line 192
    add-int/2addr v7, v3

    .line 193
    iget v8, p0, Lorg/json/Kim;->hashcode:I

    add-int/2addr v8, v7

    iput v8, p0, Lorg/json/Kim;->hashcode:I

    .line 194
    add-int/lit8 v0, v0, 0x1

    .line 188
    :goto_3
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 195
    :cond_5
    if-gt v3, v11, :cond_6

    .line 196
    ushr-int/lit8 v8, v3, 0x7

    or-int/lit16 v1, v8, 0x80

    .line 197
    .local v1, "b":I
    iget-object v8, p0, Lorg/json/Kim;->bytes:[B

    int-to-byte v9, v1

    aput-byte v9, v8, v0

    .line 198
    add-int/2addr v7, v1

    .line 199
    iget v8, p0, Lorg/json/Kim;->hashcode:I

    add-int/2addr v8, v7

    iput v8, p0, Lorg/json/Kim;->hashcode:I

    .line 200
    add-int/lit8 v0, v0, 0x1

    .line 201
    and-int/lit8 v1, v3, 0x7f

    .line 202
    iget-object v8, p0, Lorg/json/Kim;->bytes:[B

    int-to-byte v9, v1

    aput-byte v9, v8, v0

    .line 203
    add-int/2addr v7, v1

    .line 204
    iget v8, p0, Lorg/json/Kim;->hashcode:I

    add-int/2addr v8, v7

    iput v8, p0, Lorg/json/Kim;->hashcode:I

    .line 205
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 207
    .end local v1    # "b":I
    :cond_6
    if-lt v3, v12, :cond_7

    if-gt v3, v13, :cond_7

    .line 208
    add-int/lit8 v5, v5, 0x1

    .line 209
    and-int/lit16 v8, v3, 0x3ff

    shl-int/lit8 v8, v8, 0xa

    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v9

    and-int/lit16 v9, v9, 0x3ff

    or-int/2addr v8, v9

    const/high16 v9, 0x10000

    add-int v3, v8, v9

    .line 212
    :cond_7
    ushr-int/lit8 v8, v3, 0xe

    or-int/lit16 v1, v8, 0x80

    .line 213
    .restart local v1    # "b":I
    iget-object v8, p0, Lorg/json/Kim;->bytes:[B

    int-to-byte v9, v1

    aput-byte v9, v8, v0

    .line 214
    add-int/2addr v7, v1

    .line 215
    iget v8, p0, Lorg/json/Kim;->hashcode:I

    add-int/2addr v8, v7

    iput v8, p0, Lorg/json/Kim;->hashcode:I

    .line 216
    add-int/lit8 v0, v0, 0x1

    .line 217
    ushr-int/lit8 v8, v3, 0x7

    and-int/lit16 v8, v8, 0xff

    or-int/lit16 v1, v8, 0x80

    .line 218
    iget-object v8, p0, Lorg/json/Kim;->bytes:[B

    int-to-byte v9, v1

    aput-byte v9, v8, v0

    .line 219
    add-int/2addr v7, v1

    .line 220
    iget v8, p0, Lorg/json/Kim;->hashcode:I

    add-int/2addr v8, v7

    iput v8, p0, Lorg/json/Kim;->hashcode:I

    .line 221
    add-int/lit8 v0, v0, 0x1

    .line 222
    and-int/lit8 v1, v3, 0x7f

    .line 223
    iget-object v8, p0, Lorg/json/Kim;->bytes:[B

    int-to-byte v9, v1

    aput-byte v9, v8, v0

    .line 224
    add-int/2addr v7, v1

    .line 225
    iget v8, p0, Lorg/json/Kim;->hashcode:I

    add-int/2addr v8, v7

    iput v8, p0, Lorg/json/Kim;->hashcode:I

    .line 226
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 229
    .end local v1    # "b":I
    .end local v3    # "character":I
    :cond_8
    iget v8, p0, Lorg/json/Kim;->hashcode:I

    shl-int/lit8 v9, v7, 0x10

    add-int/2addr v8, v9

    iput v8, p0, Lorg/json/Kim;->hashcode:I

    .line 231
    .end local v0    # "at":I
    .end local v5    # "i":I
    .end local v7    # "sum":I
    :cond_9
    return-void
.end method

.method public constructor <init>(Lorg/json/Kim;II)V
    .locals 1
    .param p1, "kim"    # Lorg/json/Kim;
    .param p2, "from"    # I
    .param p3, "thru"    # I

    .prologue
    .line 143
    iget-object v0, p1, Lorg/json/Kim;->bytes:[B

    invoke-direct {p0, v0, p2, p3}, Lorg/json/Kim;-><init>([BII)V

    .line 144
    return-void
.end method

.method public constructor <init>([BI)V
    .locals 1
    .param p1, "bytes"    # [B
    .param p2, "length"    # I

    .prologue
    .line 127
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2}, Lorg/json/Kim;-><init>([BII)V

    .line 128
    return-void
.end method

.method public constructor <init>([BII)V
    .locals 5
    .param p1, "bytes"    # [B
    .param p2, "from"    # I
    .param p3, "thru"    # I

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    iput-object v4, p0, Lorg/json/Kim;->bytes:[B

    .line 74
    iput v3, p0, Lorg/json/Kim;->hashcode:I

    .line 80
    iput v3, p0, Lorg/json/Kim;->length:I

    .line 85
    iput-object v4, p0, Lorg/json/Kim;->string:Ljava/lang/String;

    .line 102
    const/4 v1, 0x1

    .line 104
    .local v1, "sum":I
    iput v3, p0, Lorg/json/Kim;->hashcode:I

    .line 105
    sub-int v3, p3, p2

    iput v3, p0, Lorg/json/Kim;->length:I

    .line 106
    iget v3, p0, Lorg/json/Kim;->length:I

    if-lez v3, :cond_1

    .line 107
    iget v3, p0, Lorg/json/Kim;->length:I

    new-array v3, v3, [B

    iput-object v3, p0, Lorg/json/Kim;->bytes:[B

    .line 108
    const/4 v0, 0x0

    .local v0, "at":I
    :goto_0
    iget v3, p0, Lorg/json/Kim;->length:I

    if-ge v0, v3, :cond_0

    .line 109
    add-int v3, v0, p2

    aget-byte v3, p1, v3

    and-int/lit16 v2, v3, 0xff

    .line 110
    .local v2, "value":I
    add-int/2addr v1, v2

    .line 111
    iget v3, p0, Lorg/json/Kim;->hashcode:I

    add-int/2addr v3, v1

    iput v3, p0, Lorg/json/Kim;->hashcode:I

    .line 112
    iget-object v3, p0, Lorg/json/Kim;->bytes:[B

    int-to-byte v4, v2

    aput-byte v4, v3, v0

    .line 108
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 114
    .end local v2    # "value":I
    :cond_0
    iget v3, p0, Lorg/json/Kim;->hashcode:I

    shl-int/lit8 v4, v1, 0x10

    add-int/2addr v3, v4

    iput v3, p0, Lorg/json/Kim;->hashcode:I

    .line 116
    .end local v0    # "at":I
    :cond_1
    return-void
.end method

.method public static characterSize(I)I
    .locals 3
    .param p0, "character"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 278
    if-ltz p0, :cond_0

    const v0, 0x10ffff

    if-le p0, v0, :cond_1

    .line 279
    :cond_0
    new-instance v0, Lorg/json/JSONException;

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "Bad character "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 281
    :cond_1
    const/16 v0, 0x7f

    if-gt p0, v0, :cond_2

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/16 v0, 0x3fff

    if-gt p0, v0, :cond_3

    const/4 v0, 0x2

    goto :goto_0

    :cond_3
    const/4 v0, 0x3

    goto :goto_0
.end method


# virtual methods
.method public characterAt(I)I
    .locals 7
    .param p1, "at"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 245
    invoke-virtual {p0, p1}, Lorg/json/Kim;->get(I)I

    move-result v0

    .line 246
    .local v0, "c":I
    and-int/lit16 v4, v0, 0x80

    if-nez v4, :cond_1

    move v3, v0

    .line 261
    :cond_0
    :goto_0
    return v3

    .line 250
    :cond_1
    add-int/lit8 v4, p1, 0x1

    invoke-virtual {p0, v4}, Lorg/json/Kim;->get(I)I

    move-result v1

    .line 251
    .local v1, "c1":I
    and-int/lit16 v4, v1, 0x80

    if-nez v4, :cond_3

    .line 252
    and-int/lit8 v4, v0, 0x7f

    shl-int/lit8 v4, v4, 0x7

    or-int v3, v4, v1

    .line 253
    .local v3, "character":I
    const/16 v4, 0x7f

    if-gt v3, v4, :cond_0

    .line 264
    :cond_2
    new-instance v4, Lorg/json/JSONException;

    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    const-string v6, "Bad character at "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 257
    .end local v3    # "character":I
    :cond_3
    add-int/lit8 v4, p1, 0x2

    invoke-virtual {p0, v4}, Lorg/json/Kim;->get(I)I

    move-result v2

    .line 258
    .local v2, "c2":I
    and-int/lit8 v4, v0, 0x7f

    shl-int/lit8 v4, v4, 0xe

    and-int/lit8 v5, v1, 0x7f

    shl-int/lit8 v5, v5, 0x7

    or-int/2addr v4, v5

    or-int v3, v4, v2

    .line 259
    .restart local v3    # "character":I
    and-int/lit16 v4, v2, 0x80

    if-nez v4, :cond_2

    const/16 v4, 0x3fff

    if-le v3, v4, :cond_2

    const v4, 0x10ffff

    if-gt v3, v4, :cond_2

    const v4, 0xd800

    if-lt v3, v4, :cond_0

    const v4, 0xdfff

    if-le v3, v4, :cond_2

    goto :goto_0
.end method

.method public copy([BI)I
    .locals 3
    .param p1, "bytes"    # [B
    .param p2, "at"    # I

    .prologue
    .line 294
    iget-object v0, p0, Lorg/json/Kim;->bytes:[B

    const/4 v1, 0x0

    iget v2, p0, Lorg/json/Kim;->length:I

    invoke-static {v0, v1, p1, p2, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 295
    iget v0, p0, Lorg/json/Kim;->length:I

    add-int/2addr v0, p2

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 308
    instance-of v2, p1, Lorg/json/Kim;

    if-nez v2, :cond_1

    .line 318
    :cond_0
    :goto_0
    return v1

    :cond_1
    move-object v0, p1

    .line 311
    check-cast v0, Lorg/json/Kim;

    .line 312
    .local v0, "that":Lorg/json/Kim;
    if-ne p0, v0, :cond_2

    .line 313
    const/4 v1, 0x1

    goto :goto_0

    .line 315
    :cond_2
    iget v2, p0, Lorg/json/Kim;->hashcode:I

    iget v3, v0, Lorg/json/Kim;->hashcode:I

    if-ne v2, v3, :cond_0

    .line 318
    iget-object v1, p0, Lorg/json/Kim;->bytes:[B

    iget-object v2, v0, Lorg/json/Kim;->bytes:[B

    invoke-static {v1, v2}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v1

    goto :goto_0
.end method

.method public get(I)I
    .locals 3
    .param p1, "at"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 330
    if-ltz p1, :cond_0

    iget v0, p0, Lorg/json/Kim;->length:I

    if-le p1, v0, :cond_1

    .line 331
    :cond_0
    new-instance v0, Lorg/json/JSONException;

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "Bad character at "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 333
    :cond_1
    iget-object v0, p0, Lorg/json/Kim;->bytes:[B

    aget-byte v0, v0, p1

    and-int/lit16 v0, v0, 0xff

    return v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 340
    iget v0, p0, Lorg/json/Kim;->hashcode:I

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 7
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/high16 v6, 0x10000

    .line 353
    iget-object v4, p0, Lorg/json/Kim;->string:Ljava/lang/String;

    if-nez v4, :cond_2

    .line 355
    const/4 v3, 0x0

    .line 356
    .local v3, "length":I
    iget v4, p0, Lorg/json/Kim;->length:I

    new-array v2, v4, [C

    .line 357
    .local v2, "chars":[C
    const/4 v0, 0x0

    .local v0, "at":I
    :goto_0
    iget v4, p0, Lorg/json/Kim;->length:I

    if-ge v0, v4, :cond_1

    .line 358
    invoke-virtual {p0, v0}, Lorg/json/Kim;->characterAt(I)I

    move-result v1

    .line 359
    .local v1, "c":I
    if-ge v1, v6, :cond_0

    .line 360
    int-to-char v4, v1

    aput-char v4, v2, v3

    .line 361
    add-int/lit8 v3, v3, 0x1

    .line 357
    :goto_1
    invoke-static {v1}, Lorg/json/Kim;->characterSize(I)I

    move-result v4

    add-int/2addr v0, v4

    goto :goto_0

    .line 363
    :cond_0
    const v4, 0xd800

    sub-int v5, v1, v6

    ushr-int/lit8 v5, v5, 0xa

    or-int/2addr v4, v5

    int-to-char v4, v4

    aput-char v4, v2, v3

    .line 364
    add-int/lit8 v3, v3, 0x1

    .line 365
    const v4, 0xdc00

    and-int/lit16 v5, v1, 0x3ff

    or-int/2addr v4, v5

    int-to-char v4, v4

    aput-char v4, v2, v3

    .line 366
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 369
    .end local v1    # "c":I
    :cond_1
    new-instance v4, Ljava/lang/String;

    const/4 v5, 0x0

    invoke-direct {v4, v2, v5, v3}, Ljava/lang/String;-><init>([CII)V

    iput-object v4, p0, Lorg/json/Kim;->string:Ljava/lang/String;

    .line 371
    .end local v0    # "at":I
    .end local v2    # "chars":[C
    .end local v3    # "length":I
    :cond_2
    iget-object v4, p0, Lorg/json/Kim;->string:Ljava/lang/String;

    return-object v4
.end method
