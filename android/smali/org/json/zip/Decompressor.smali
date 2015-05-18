.class public Lorg/json/zip/Decompressor;
.super Lorg/json/zip/JSONzip;
.source "Decompressor.java"


# instance fields
.field bitreader:Lorg/json/zip/BitReader;


# direct methods
.method public constructor <init>(Lorg/json/zip/BitReader;)V
    .locals 0
    .param p1, "bitreader"    # Lorg/json/zip/BitReader;

    .prologue
    .line 56
    invoke-direct {p0}, Lorg/json/zip/JSONzip;-><init>()V

    .line 57
    iput-object p1, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    .line 58
    return-void
.end method

.method private bit()Z
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 69
    :try_start_0
    iget-object v2, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    invoke-interface {v2}, Lorg/json/zip/BitReader;->bit()Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 73
    .local v1, "value":Z
    return v1

    .line 74
    .end local v1    # "value":Z
    :catch_0
    move-exception v0

    .line 75
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v2, Lorg/json/JSONException;

    invoke-direct {v2, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method private getAndTick(Lorg/json/zip/Keep;Lorg/json/zip/BitReader;)Ljava/lang/Object;
    .locals 6
    .param p1, "keep"    # Lorg/json/zip/Keep;
    .param p2, "bitreader"    # Lorg/json/zip/BitReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 92
    :try_start_0
    invoke-virtual {p1}, Lorg/json/zip/Keep;->bitsize()I

    move-result v3

    .line 93
    .local v3, "width":I
    invoke-interface {p2, v3}, Lorg/json/zip/BitReader;->read(I)I

    move-result v1

    .line 94
    .local v1, "integer":I
    invoke-virtual {p1, v1}, Lorg/json/zip/Keep;->value(I)Ljava/lang/Object;

    move-result-object v2

    .line 99
    .local v2, "value":Ljava/lang/Object;
    iget v4, p1, Lorg/json/zip/Keep;->length:I

    if-lt v1, v4, :cond_0

    .line 100
    new-instance v4, Lorg/json/JSONException;

    const-string v5, "Deep error."

    invoke-direct {v4, v5}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 104
    .end local v1    # "integer":I
    .end local v2    # "value":Ljava/lang/Object;
    .end local v3    # "width":I
    :catch_0
    move-exception v0

    .line 105
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v4, Lorg/json/JSONException;

    invoke-direct {v4, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 102
    .end local v0    # "e":Ljava/lang/Throwable;
    .restart local v1    # "integer":I
    .restart local v2    # "value":Ljava/lang/Object;
    .restart local v3    # "width":I
    :cond_0
    :try_start_1
    invoke-virtual {p1, v1}, Lorg/json/zip/Keep;->tick(I)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    .line 103
    return-object v2
.end method

.method private read(I)I
    .locals 3
    .param p1, "width"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 135
    :try_start_0
    iget-object v2, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    invoke-interface {v2, p1}, Lorg/json/zip/BitReader;->read(I)I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 139
    .local v1, "value":I
    return v1

    .line 140
    .end local v1    # "value":I
    :catch_0
    move-exception v0

    .line 141
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v2, Lorg/json/JSONException;

    invoke-direct {v2, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method private readArray(Z)Lorg/json/JSONArray;
    .locals 2
    .param p1, "stringy"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 154
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    .line 155
    .local v0, "jsonarray":Lorg/json/JSONArray;
    if-eqz p1, :cond_0

    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readString()Ljava/lang/String;

    move-result-object v1

    :goto_0
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 160
    :goto_1
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v1

    if-nez v1, :cond_3

    .line 161
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v1

    if-nez v1, :cond_1

    .line 162
    return-object v0

    .line 155
    :cond_0
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readValue()Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 164
    :cond_1
    if-eqz p1, :cond_2

    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readValue()Ljava/lang/Object;

    move-result-object v1

    :goto_2
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_1

    :cond_2
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readString()Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    .line 166
    :cond_3
    if-eqz p1, :cond_4

    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readString()Ljava/lang/String;

    move-result-object v1

    :goto_3
    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_1

    :cond_4
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readValue()Ljava/lang/Object;

    move-result-object v1

    goto :goto_3
.end method

.method private readJSON()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 178
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lorg/json/zip/Decompressor;->read(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 194
    :pswitch_0
    sget-object v0, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    :goto_0
    return-object v0

    .line 180
    :pswitch_1
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readObject()Lorg/json/JSONObject;

    move-result-object v0

    goto :goto_0

    .line 182
    :pswitch_2
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lorg/json/zip/Decompressor;->readArray(Z)Lorg/json/JSONArray;

    move-result-object v0

    goto :goto_0

    .line 184
    :pswitch_3
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lorg/json/zip/Decompressor;->readArray(Z)Lorg/json/JSONArray;

    move-result-object v0

    goto :goto_0

    .line 186
    :pswitch_4
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    goto :goto_0

    .line 188
    :pswitch_5
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    goto :goto_0

    .line 190
    :pswitch_6
    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_0

    .line 192
    :pswitch_7
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_0

    .line 178
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private readName()Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 199
    const/high16 v4, 0x10000

    new-array v0, v4, [B

    .line 200
    .local v0, "bytes":[B
    const/4 v3, 0x0

    .line 201
    .local v3, "length":I
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v4

    if-nez v4, :cond_2

    .line 203
    :goto_0
    iget-object v4, p0, Lorg/json/zip/Decompressor;->namehuff:Lorg/json/zip/Huff;

    iget-object v5, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    invoke-virtual {v4, v5}, Lorg/json/zip/Huff;->read(Lorg/json/zip/BitReader;)I

    move-result v1

    .line 204
    .local v1, "c":I
    const/16 v4, 0x100

    if-ne v1, v4, :cond_0

    .line 210
    if-nez v3, :cond_1

    .line 211
    const-string v4, ""

    .line 217
    .end local v1    # "c":I
    :goto_1
    return-object v4

    .line 207
    .restart local v1    # "c":I
    :cond_0
    int-to-byte v4, v1

    aput-byte v4, v0, v3

    .line 208
    add-int/lit8 v3, v3, 0x1

    .line 209
    goto :goto_0

    .line 213
    :cond_1
    new-instance v2, Lorg/json/Kim;

    invoke-direct {v2, v0, v3}, Lorg/json/Kim;-><init>([BI)V

    .line 214
    .local v2, "kim":Lorg/json/Kim;
    iget-object v4, p0, Lorg/json/zip/Decompressor;->namekeep:Lorg/json/zip/MapKeep;

    invoke-virtual {v4, v2}, Lorg/json/zip/MapKeep;->register(Ljava/lang/Object;)V

    .line 215
    invoke-virtual {v2}, Lorg/json/Kim;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 217
    .end local v1    # "c":I
    .end local v2    # "kim":Lorg/json/Kim;
    :cond_2
    iget-object v4, p0, Lorg/json/zip/Decompressor;->namekeep:Lorg/json/zip/MapKeep;

    iget-object v5, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    invoke-direct {p0, v4, v5}, Lorg/json/zip/Decompressor;->getAndTick(Lorg/json/zip/Keep;Lorg/json/zip/BitReader;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    goto :goto_1
.end method

.method private readObject()Lorg/json/JSONObject;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 221
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 226
    .local v0, "jsonobject":Lorg/json/JSONObject;
    :cond_0
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readName()Ljava/lang/String;

    move-result-object v1

    .line 227
    .local v1, "name":Ljava/lang/String;
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v2

    if-nez v2, :cond_1

    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readString()Ljava/lang/String;

    move-result-object v2

    :goto_0
    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 228
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v2

    if-nez v2, :cond_0

    .line 229
    return-object v0

    .line 227
    :cond_1
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readValue()Ljava/lang/Object;

    move-result-object v2

    goto :goto_0
.end method

.method private readString()Ljava/lang/String;
    .locals 12
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v11, -0x1

    .line 236
    const/4 v2, 0x0

    .line 237
    .local v2, "from":I
    const/4 v7, 0x0

    .line 238
    .local v7, "thru":I
    const/4 v5, -0x1

    .line 239
    .local v5, "previousFrom":I
    const/4 v6, 0x0

    .line 240
    .local v6, "previousThru":I
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 241
    iget-object v8, p0, Lorg/json/zip/Decompressor;->stringkeep:Lorg/json/zip/MapKeep;

    iget-object v9, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    invoke-direct {p0, v8, v9}, Lorg/json/zip/Decompressor;->getAndTick(Lorg/json/zip/Keep;Lorg/json/zip/BitReader;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    .line 285
    :goto_0
    return-object v8

    .line 243
    :cond_0
    const/high16 v8, 0x10000

    new-array v0, v8, [B

    .line 244
    .local v0, "bytes":[B
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v4

    .line 245
    .local v4, "one":Z
    iget-object v8, p0, Lorg/json/zip/Decompressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v8}, Lorg/json/zip/TrieKeep;->reserve()V

    .line 247
    :goto_1
    if-eqz v4, :cond_2

    .line 248
    move v2, v7

    .line 249
    iget-object v8, p0, Lorg/json/zip/Decompressor;->substringkeep:Lorg/json/zip/TrieKeep;

    iget-object v9, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    invoke-direct {p0, v8, v9}, Lorg/json/zip/Decompressor;->getAndTick(Lorg/json/zip/Keep;Lorg/json/zip/BitReader;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lorg/json/Kim;

    .line 250
    .local v3, "kim":Lorg/json/Kim;
    invoke-virtual {v3, v0, v2}, Lorg/json/Kim;->copy([BI)I

    move-result v7

    .line 251
    if-eq v5, v11, :cond_1

    .line 252
    iget-object v8, p0, Lorg/json/zip/Decompressor;->substringkeep:Lorg/json/zip/TrieKeep;

    new-instance v9, Lorg/json/Kim;

    add-int/lit8 v10, v6, 0x1

    invoke-direct {v9, v0, v5, v10}, Lorg/json/Kim;-><init>([BII)V

    invoke-virtual {v8, v9}, Lorg/json/zip/TrieKeep;->registerOne(Lorg/json/Kim;)V

    .line 255
    :cond_1
    move v5, v2

    .line 256
    move v6, v7

    .line 257
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v4

    goto :goto_1

    .line 259
    .end local v3    # "kim":Lorg/json/Kim;
    :cond_2
    const/4 v2, -0x1

    .line 261
    :cond_3
    :goto_2
    iget-object v8, p0, Lorg/json/zip/Decompressor;->substringhuff:Lorg/json/zip/Huff;

    iget-object v9, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    invoke-virtual {v8, v9}, Lorg/json/zip/Huff;->read(Lorg/json/zip/BitReader;)I

    move-result v1

    .line 262
    .local v1, "c":I
    const/16 v8, 0x100

    if-ne v1, v8, :cond_4

    .line 273
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v8

    if-nez v8, :cond_5

    .line 279
    if-nez v7, :cond_6

    .line 280
    const-string v8, ""

    goto :goto_0

    .line 265
    :cond_4
    int-to-byte v8, v1

    aput-byte v8, v0, v7

    .line 266
    add-int/lit8 v7, v7, 0x1

    .line 267
    if-eq v5, v11, :cond_3

    .line 268
    iget-object v8, p0, Lorg/json/zip/Decompressor;->substringkeep:Lorg/json/zip/TrieKeep;

    new-instance v9, Lorg/json/Kim;

    add-int/lit8 v10, v6, 0x1

    invoke-direct {v9, v0, v5, v10}, Lorg/json/Kim;-><init>([BII)V

    invoke-virtual {v8, v9}, Lorg/json/zip/TrieKeep;->registerOne(Lorg/json/Kim;)V

    .line 270
    const/4 v5, -0x1

    goto :goto_2

    .line 276
    :cond_5
    const/4 v4, 0x1

    goto :goto_1

    .line 282
    :cond_6
    new-instance v3, Lorg/json/Kim;

    invoke-direct {v3, v0, v7}, Lorg/json/Kim;-><init>([BI)V

    .line 283
    .restart local v3    # "kim":Lorg/json/Kim;
    iget-object v8, p0, Lorg/json/zip/Decompressor;->stringkeep:Lorg/json/zip/MapKeep;

    invoke-virtual {v8, v3}, Lorg/json/zip/MapKeep;->register(Ljava/lang/Object;)V

    .line 284
    iget-object v8, p0, Lorg/json/zip/Decompressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v8, v3}, Lorg/json/zip/TrieKeep;->registerMany(Lorg/json/Kim;)V

    .line 285
    invoke-virtual {v3}, Lorg/json/Kim;->toString()Ljava/lang/String;

    move-result-object v8

    goto :goto_0
.end method

.method private readValue()Ljava/lang/Object;
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x4

    .line 289
    const/4 v6, 0x2

    invoke-direct {p0, v6}, Lorg/json/zip/Decompressor;->read(I)I

    move-result v6

    packed-switch v6, :pswitch_data_0

    .line 317
    new-instance v5, Lorg/json/JSONException;

    const-string v6, "Impossible."

    invoke-direct {v5, v6}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 291
    :pswitch_0
    new-instance v4, Ljava/lang/Integer;

    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v6

    if-nez v6, :cond_0

    :goto_0
    invoke-direct {p0, v5}, Lorg/json/zip/Decompressor;->read(I)I

    move-result v5

    invoke-direct {v4, v5}, Ljava/lang/Integer;-><init>(I)V

    .line 315
    :goto_1
    return-object v4

    .line 291
    :cond_0
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->bit()Z

    move-result v5

    if-nez v5, :cond_1

    const/4 v5, 0x7

    goto :goto_0

    :cond_1
    const/16 v5, 0xe

    goto :goto_0

    .line 293
    :pswitch_1
    const/16 v6, 0x100

    new-array v0, v6, [B

    .line 294
    .local v0, "bytes":[B
    const/4 v3, 0x0

    .line 296
    .local v3, "length":I
    :goto_2
    invoke-direct {p0, v5}, Lorg/json/zip/Decompressor;->read(I)I

    move-result v1

    .line 297
    .local v1, "c":I
    sget v6, Lorg/json/zip/Decompressor;->endOfNumber:I

    if-ne v1, v6, :cond_2

    .line 305
    :try_start_0
    new-instance v5, Ljava/lang/String;

    const/4 v6, 0x0

    const-string v7, "US-ASCII"

    invoke-direct {v5, v0, v6, v3, v7}, Ljava/lang/String;-><init>([BIILjava/lang/String;)V

    invoke-static {v5}, Lorg/json/JSONObject;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 310
    .local v4, "value":Ljava/lang/Object;
    iget-object v5, p0, Lorg/json/zip/Decompressor;->values:Lorg/json/zip/MapKeep;

    invoke-virtual {v5, v4}, Lorg/json/zip/MapKeep;->register(Ljava/lang/Object;)V

    goto :goto_1

    .line 300
    .end local v4    # "value":Ljava/lang/Object;
    :cond_2
    sget-object v6, Lorg/json/zip/Decompressor;->bcd:[B

    aget-byte v6, v6, v1

    aput-byte v6, v0, v3

    .line 301
    add-int/lit8 v3, v3, 0x1

    .line 302
    goto :goto_2

    .line 307
    :catch_0
    move-exception v2

    .line 308
    .local v2, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v5, Lorg/json/JSONException;

    invoke-direct {v5, v2}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 313
    .end local v0    # "bytes":[B
    .end local v1    # "c":I
    .end local v2    # "e":Ljava/io/UnsupportedEncodingException;
    .end local v3    # "length":I
    :pswitch_2
    iget-object v5, p0, Lorg/json/zip/Decompressor;->values:Lorg/json/zip/MapKeep;

    iget-object v6, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    invoke-direct {p0, v5, v6}, Lorg/json/zip/Decompressor;->getAndTick(Lorg/json/zip/Keep;Lorg/json/zip/BitReader;)Ljava/lang/Object;

    move-result-object v4

    goto :goto_1

    .line 315
    :pswitch_3
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readJSON()Ljava/lang/Object;

    move-result-object v4

    goto :goto_1

    .line 289
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method


# virtual methods
.method public pad(I)Z
    .locals 2
    .param p1, "factor"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 119
    :try_start_0
    iget-object v1, p0, Lorg/json/zip/Decompressor;->bitreader:Lorg/json/zip/BitReader;

    invoke-interface {v1, p1}, Lorg/json/zip/BitReader;->pad(I)Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    return v1

    .line 120
    :catch_0
    move-exception v0

    .line 121
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v1, Lorg/json/JSONException;

    invoke-direct {v1, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public unzip()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 322
    invoke-virtual {p0}, Lorg/json/zip/Decompressor;->begin()V

    .line 323
    invoke-direct {p0}, Lorg/json/zip/Decompressor;->readJSON()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
