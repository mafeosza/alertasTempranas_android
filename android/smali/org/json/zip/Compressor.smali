.class public Lorg/json/zip/Compressor;
.super Lorg/json/zip/JSONzip;
.source "Compressor.java"


# instance fields
.field final bitwriter:Lorg/json/zip/BitWriter;


# direct methods
.method public constructor <init>(Lorg/json/zip/BitWriter;)V
    .locals 0
    .param p1, "bitwriter"    # Lorg/json/zip/BitWriter;

    .prologue
    .line 68
    invoke-direct {p0}, Lorg/json/zip/JSONzip;-><init>()V

    .line 69
    iput-object p1, p0, Lorg/json/zip/Compressor;->bitwriter:Lorg/json/zip/BitWriter;

    .line 70
    return-void
.end method

.method private static bcd(C)I
    .locals 1
    .param p0, "digit"    # C

    .prologue
    .line 82
    const/16 v0, 0x30

    if-lt p0, v0, :cond_0

    const/16 v0, 0x39

    if-gt p0, v0, :cond_0

    .line 83
    add-int/lit8 v0, p0, -0x30

    .line 93
    :goto_0
    return v0

    .line 85
    :cond_0
    packed-switch p0, :pswitch_data_0

    .line 93
    :pswitch_0
    const/16 v0, 0xd

    goto :goto_0

    .line 87
    :pswitch_1
    const/16 v0, 0xa

    goto :goto_0

    .line 89
    :pswitch_2
    const/16 v0, 0xb

    goto :goto_0

    .line 91
    :pswitch_3
    const/16 v0, 0xc

    goto :goto_0

    .line 85
    :pswitch_data_0
    .packed-switch 0x2b
        :pswitch_3
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private one()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    .line 116
    invoke-direct {p0, v0, v0}, Lorg/json/zip/Compressor;->write(II)V

    .line 117
    return-void
.end method

.method private write(II)V
    .locals 2
    .param p1, "integer"    # I
    .param p2, "width"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 147
    :try_start_0
    iget-object v1, p0, Lorg/json/zip/Compressor;->bitwriter:Lorg/json/zip/BitWriter;

    invoke-interface {v1, p1, p2}, Lorg/json/zip/BitWriter;->write(II)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 154
    return-void

    .line 151
    :catch_0
    move-exception v0

    .line 152
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v1, Lorg/json/JSONException;

    invoke-direct {v1, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method private write(ILorg/json/zip/Huff;)V
    .locals 1
    .param p1, "integer"    # I
    .param p2, "huff"    # Lorg/json/zip/Huff;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 167
    iget-object v0, p0, Lorg/json/zip/Compressor;->bitwriter:Lorg/json/zip/BitWriter;

    invoke-virtual {p2, p1, v0}, Lorg/json/zip/Huff;->write(ILorg/json/zip/BitWriter;)V

    .line 168
    return-void
.end method

.method private write(Lorg/json/Kim;IILorg/json/zip/Huff;)V
    .locals 2
    .param p1, "kim"    # Lorg/json/Kim;
    .param p2, "from"    # I
    .param p3, "thru"    # I
    .param p4, "huff"    # Lorg/json/zip/Huff;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 198
    move v0, p2

    .local v0, "at":I
    :goto_0
    if-ge v0, p3, :cond_0

    .line 199
    invoke-virtual {p1, v0}, Lorg/json/Kim;->get(I)I

    move-result v1

    invoke-direct {p0, v1, p4}, Lorg/json/zip/Compressor;->write(ILorg/json/zip/Huff;)V

    .line 198
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 201
    :cond_0
    return-void
.end method

.method private write(Lorg/json/Kim;Lorg/json/zip/Huff;)V
    .locals 2
    .param p1, "kim"    # Lorg/json/Kim;
    .param p2, "huff"    # Lorg/json/zip/Huff;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 180
    const/4 v0, 0x0

    iget v1, p1, Lorg/json/Kim;->length:I

    invoke-direct {p0, p1, v0, v1, p2}, Lorg/json/zip/Compressor;->write(Lorg/json/Kim;IILorg/json/zip/Huff;)V

    .line 181
    return-void
.end method

.method private writeAndTick(ILorg/json/zip/Keep;)V
    .locals 1
    .param p1, "integer"    # I
    .param p2, "keep"    # Lorg/json/zip/Keep;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 214
    invoke-virtual {p2}, Lorg/json/zip/Keep;->bitsize()I

    move-result v0

    .line 215
    .local v0, "width":I
    invoke-virtual {p2, p1}, Lorg/json/zip/Keep;->tick(I)V

    .line 219
    invoke-direct {p0, p1, v0}, Lorg/json/zip/Compressor;->write(II)V

    .line 220
    return-void
.end method

.method private writeArray(Lorg/json/JSONArray;)V
    .locals 6
    .param p1, "jsonarray"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x3

    .line 235
    const/4 v2, 0x0

    .line 236
    .local v2, "stringy":Z
    invoke-virtual {p1}, Lorg/json/JSONArray;->length()I

    move-result v1

    .line 237
    .local v1, "length":I
    if-nez v1, :cond_0

    .line 238
    const/4 v4, 0x1

    invoke-direct {p0, v4, v5}, Lorg/json/zip/Compressor;->write(II)V

    .line 274
    :goto_0
    return-void

    .line 240
    :cond_0
    const/4 v4, 0x0

    invoke-virtual {p1, v4}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    .line 241
    .local v3, "value":Ljava/lang/Object;
    if-nez v3, :cond_1

    .line 242
    sget-object v3, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    .line 244
    :cond_1
    instance-of v4, v3, Ljava/lang/String;

    if-eqz v4, :cond_4

    .line 245
    const/4 v2, 0x1

    .line 246
    const/4 v4, 0x6

    invoke-direct {p0, v4, v5}, Lorg/json/zip/Compressor;->write(II)V

    move-object v4, v3

    .line 247
    check-cast v4, Ljava/lang/String;

    invoke-direct {p0, v4}, Lorg/json/zip/Compressor;->writeString(Ljava/lang/String;)V

    .line 252
    :goto_1
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_2
    if-ge v0, v1, :cond_6

    .line 256
    invoke-virtual {p1, v0}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    .line 257
    if-nez v3, :cond_2

    .line 258
    sget-object v3, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    .line 260
    :cond_2
    instance-of v4, v3, Ljava/lang/String;

    if-eq v4, v2, :cond_3

    .line 261
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 263
    :cond_3
    invoke-direct {p0}, Lorg/json/zip/Compressor;->one()V

    .line 264
    instance-of v4, v3, Ljava/lang/String;

    if-eqz v4, :cond_5

    move-object v4, v3

    .line 265
    check-cast v4, Ljava/lang/String;

    invoke-direct {p0, v4}, Lorg/json/zip/Compressor;->writeString(Ljava/lang/String;)V

    .line 252
    :goto_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 249
    .end local v0    # "i":I
    :cond_4
    const/4 v4, 0x7

    invoke-direct {p0, v4, v5}, Lorg/json/zip/Compressor;->write(II)V

    .line 250
    invoke-direct {p0, v3}, Lorg/json/zip/Compressor;->writeValue(Ljava/lang/Object;)V

    goto :goto_1

    .line 267
    .restart local v0    # "i":I
    :cond_5
    invoke-direct {p0, v3}, Lorg/json/zip/Compressor;->writeValue(Ljava/lang/Object;)V

    goto :goto_3

    .line 270
    :cond_6
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 271
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    goto :goto_0
.end method

.method private writeJSON(Ljava/lang/Object;)V
    .locals 3
    .param p1, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x3

    .line 286
    sget-object v1, Lorg/json/JSONObject;->NULL:Ljava/lang/Object;

    invoke-virtual {v1, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 287
    const/4 v1, 0x4

    invoke-direct {p0, v1, v2}, Lorg/json/zip/Compressor;->write(II)V

    .line 308
    .end local p1    # "value":Ljava/lang/Object;
    :goto_0
    return-void

    .line 288
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_0
    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1, p1}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 289
    invoke-direct {p0, v2, v2}, Lorg/json/zip/Compressor;->write(II)V

    goto :goto_0

    .line 290
    :cond_1
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, p1}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 291
    const/4 v1, 0x2

    invoke-direct {p0, v1, v2}, Lorg/json/zip/Compressor;->write(II)V

    goto :goto_0

    .line 293
    :cond_2
    instance-of v1, p1, Ljava/util/Map;

    if-eqz v1, :cond_4

    .line 294
    new-instance v0, Lorg/json/JSONObject;

    check-cast p1, Ljava/util/Map;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    .local v0, "value":Lorg/json/JSONObject;
    move-object p1, v0

    .line 300
    .end local v0    # "value":Lorg/json/JSONObject;
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_3
    :goto_1
    instance-of v1, p1, Lorg/json/JSONObject;

    if-eqz v1, :cond_6

    .line 301
    check-cast p1, Lorg/json/JSONObject;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-direct {p0, p1}, Lorg/json/zip/Compressor;->writeObject(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 295
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_4
    instance-of v1, p1, Ljava/util/Collection;

    if-eqz v1, :cond_5

    .line 296
    new-instance v0, Lorg/json/JSONArray;

    check-cast p1, Ljava/util/Collection;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-direct {v0, p1}, Lorg/json/JSONArray;-><init>(Ljava/util/Collection;)V

    .local v0, "value":Lorg/json/JSONArray;
    move-object p1, v0

    .restart local p1    # "value":Ljava/lang/Object;
    goto :goto_1

    .line 297
    .end local v0    # "value":Lorg/json/JSONArray;
    :cond_5
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->isArray()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 298
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, p1}, Lorg/json/JSONArray;-><init>(Ljava/lang/Object;)V

    .restart local v0    # "value":Lorg/json/JSONArray;
    move-object p1, v0

    goto :goto_1

    .line 302
    .end local v0    # "value":Lorg/json/JSONArray;
    :cond_6
    instance-of v1, p1, Lorg/json/JSONArray;

    if-eqz v1, :cond_7

    .line 303
    check-cast p1, Lorg/json/JSONArray;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-direct {p0, p1}, Lorg/json/zip/Compressor;->writeArray(Lorg/json/JSONArray;)V

    goto :goto_0

    .line 305
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_7
    new-instance v1, Lorg/json/JSONException;

    const-string v2, "Unrecognized object"

    invoke-direct {v1, v2}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private writeName(Ljava/lang/String;)V
    .locals 4
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 322
    new-instance v1, Lorg/json/Kim;

    invoke-direct {v1, p1}, Lorg/json/Kim;-><init>(Ljava/lang/String;)V

    .line 323
    .local v1, "kim":Lorg/json/Kim;
    iget-object v2, p0, Lorg/json/zip/Compressor;->namekeep:Lorg/json/zip/MapKeep;

    invoke-virtual {v2, v1}, Lorg/json/zip/MapKeep;->find(Ljava/lang/Object;)I

    move-result v0

    .line 324
    .local v0, "integer":I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    .line 325
    invoke-direct {p0}, Lorg/json/zip/Compressor;->one()V

    .line 326
    iget-object v2, p0, Lorg/json/zip/Compressor;->namekeep:Lorg/json/zip/MapKeep;

    invoke-direct {p0, v0, v2}, Lorg/json/zip/Compressor;->writeAndTick(ILorg/json/zip/Keep;)V

    .line 336
    :goto_0
    return-void

    .line 331
    :cond_0
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 332
    iget-object v2, p0, Lorg/json/zip/Compressor;->namehuff:Lorg/json/zip/Huff;

    invoke-direct {p0, v1, v2}, Lorg/json/zip/Compressor;->write(Lorg/json/Kim;Lorg/json/zip/Huff;)V

    .line 333
    const/16 v2, 0x100

    iget-object v3, p0, Lorg/json/zip/Compressor;->namehuff:Lorg/json/zip/Huff;

    invoke-direct {p0, v2, v3}, Lorg/json/zip/Compressor;->write(ILorg/json/zip/Huff;)V

    .line 334
    iget-object v2, p0, Lorg/json/zip/Compressor;->namekeep:Lorg/json/zip/MapKeep;

    invoke-virtual {v2, v1}, Lorg/json/zip/MapKeep;->register(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private writeObject(Lorg/json/JSONObject;)V
    .locals 6
    .param p1, "jsonobject"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x3

    .line 350
    const/4 v0, 0x1

    .line 351
    .local v0, "first":Z
    invoke-virtual {p1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v2

    .line 352
    .local v2, "keys":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 356
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 357
    .local v1, "key":Ljava/lang/Object;
    instance-of v4, v1, Ljava/lang/String;

    if-eqz v4, :cond_0

    .line 358
    if-eqz v0, :cond_1

    .line 359
    const/4 v0, 0x0

    .line 360
    const/4 v4, 0x5

    invoke-direct {p0, v4, v5}, Lorg/json/zip/Compressor;->write(II)V

    :goto_1
    move-object v4, v1

    .line 364
    check-cast v4, Ljava/lang/String;

    invoke-direct {p0, v4}, Lorg/json/zip/Compressor;->writeName(Ljava/lang/String;)V

    .line 365
    check-cast v1, Ljava/lang/String;

    .end local v1    # "key":Ljava/lang/Object;
    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    .line 366
    .local v3, "value":Ljava/lang/Object;
    instance-of v4, v3, Ljava/lang/String;

    if-eqz v4, :cond_2

    .line 367
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 368
    check-cast v3, Ljava/lang/String;

    .end local v3    # "value":Ljava/lang/Object;
    invoke-direct {p0, v3}, Lorg/json/zip/Compressor;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 362
    .restart local v1    # "key":Ljava/lang/Object;
    :cond_1
    invoke-direct {p0}, Lorg/json/zip/Compressor;->one()V

    goto :goto_1

    .line 370
    .end local v1    # "key":Ljava/lang/Object;
    .restart local v3    # "value":Ljava/lang/Object;
    :cond_2
    invoke-direct {p0}, Lorg/json/zip/Compressor;->one()V

    .line 371
    invoke-direct {p0, v3}, Lorg/json/zip/Compressor;->writeValue(Ljava/lang/Object;)V

    goto :goto_0

    .line 375
    .end local v3    # "value":Ljava/lang/Object;
    :cond_3
    if-eqz v0, :cond_4

    .line 376
    const/4 v4, 0x0

    invoke-direct {p0, v4, v5}, Lorg/json/zip/Compressor;->write(II)V

    .line 380
    :goto_2
    return-void

    .line 378
    :cond_4
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    goto :goto_2
.end method

.method private writeString(Ljava/lang/String;)V
    .locals 4
    .param p1, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 392
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_0

    .line 393
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 394
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 395
    const/16 v2, 0x100

    iget-object v3, p0, Lorg/json/zip/Compressor;->substringhuff:Lorg/json/zip/Huff;

    invoke-direct {p0, v2, v3}, Lorg/json/zip/Compressor;->write(ILorg/json/zip/Huff;)V

    .line 396
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 416
    :goto_0
    return-void

    .line 398
    :cond_0
    new-instance v1, Lorg/json/Kim;

    invoke-direct {v1, p1}, Lorg/json/Kim;-><init>(Ljava/lang/String;)V

    .line 403
    .local v1, "kim":Lorg/json/Kim;
    iget-object v2, p0, Lorg/json/zip/Compressor;->stringkeep:Lorg/json/zip/MapKeep;

    invoke-virtual {v2, v1}, Lorg/json/zip/MapKeep;->find(Ljava/lang/Object;)I

    move-result v0

    .line 404
    .local v0, "integer":I
    const/4 v2, -0x1

    if-eq v0, v2, :cond_1

    .line 405
    invoke-direct {p0}, Lorg/json/zip/Compressor;->one()V

    .line 406
    iget-object v2, p0, Lorg/json/zip/Compressor;->stringkeep:Lorg/json/zip/MapKeep;

    invoke-direct {p0, v0, v2}, Lorg/json/zip/Compressor;->writeAndTick(ILorg/json/zip/Keep;)V

    goto :goto_0

    .line 412
    :cond_1
    invoke-direct {p0, v1}, Lorg/json/zip/Compressor;->writeSubstring(Lorg/json/Kim;)V

    .line 413
    iget-object v2, p0, Lorg/json/zip/Compressor;->stringkeep:Lorg/json/zip/MapKeep;

    invoke-virtual {v2, v1}, Lorg/json/zip/MapKeep;->register(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private writeSubstring(Lorg/json/Kim;)V
    .locals 10
    .param p1, "kim"    # Lorg/json/Kim;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/16 v9, 0x100

    const/4 v8, -0x1

    .line 425
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v7}, Lorg/json/zip/TrieKeep;->reserve()V

    .line 426
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 427
    const/4 v1, 0x0

    .line 428
    .local v1, "from":I
    iget v5, p1, Lorg/json/Kim;->length:I

    .line 429
    .local v5, "thru":I
    add-int/lit8 v6, v5, -0x3

    .line 430
    .local v6, "until":I
    const/4 v3, -0x1

    .line 431
    .local v3, "previousFrom":I
    const/4 v4, 0x0

    .line 437
    .local v4, "previousThru":I
    :goto_0
    const/4 v2, -0x1

    .line 438
    .local v2, "integer":I
    move v0, v1

    .local v0, "at":I
    :goto_1
    if-gt v0, v6, :cond_0

    .line 439
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v7, p1, v0, v5}, Lorg/json/zip/TrieKeep;->match(Lorg/json/Kim;II)I

    move-result v2

    .line 440
    if-eq v2, v8, :cond_2

    .line 444
    :cond_0
    if-ne v2, v8, :cond_3

    .line 476
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 477
    if-ge v1, v5, :cond_1

    .line 478
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringhuff:Lorg/json/zip/Huff;

    invoke-direct {p0, p1, v1, v5, v7}, Lorg/json/zip/Compressor;->write(Lorg/json/Kim;IILorg/json/zip/Huff;)V

    .line 479
    if-eq v3, v8, :cond_1

    .line 480
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v7, p1, v3, v4}, Lorg/json/zip/TrieKeep;->registerOne(Lorg/json/Kim;II)I

    .line 483
    :cond_1
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringhuff:Lorg/json/zip/Huff;

    invoke-direct {p0, v9, v7}, Lorg/json/zip/Compressor;->write(ILorg/json/zip/Huff;)V

    .line 484
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 489
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v7, p1}, Lorg/json/zip/TrieKeep;->registerMany(Lorg/json/Kim;)V

    .line 490
    return-void

    .line 438
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 452
    :cond_3
    if-eq v1, v0, :cond_4

    .line 453
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 454
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringhuff:Lorg/json/zip/Huff;

    invoke-direct {p0, p1, v1, v0, v7}, Lorg/json/zip/Compressor;->write(Lorg/json/Kim;IILorg/json/zip/Huff;)V

    .line 455
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringhuff:Lorg/json/zip/Huff;

    invoke-direct {p0, v9, v7}, Lorg/json/zip/Compressor;->write(ILorg/json/zip/Huff;)V

    .line 456
    if-eq v3, v8, :cond_4

    .line 457
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v7, p1, v3, v4}, Lorg/json/zip/TrieKeep;->registerOne(Lorg/json/Kim;II)I

    .line 459
    const/4 v3, -0x1

    .line 462
    :cond_4
    invoke-direct {p0}, Lorg/json/zip/Compressor;->one()V

    .line 463
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-direct {p0, v2, v7}, Lorg/json/zip/Compressor;->writeAndTick(ILorg/json/zip/Keep;)V

    .line 464
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v7, v2}, Lorg/json/zip/TrieKeep;->length(I)I

    move-result v7

    add-int v1, v0, v7

    .line 465
    if-eq v3, v8, :cond_5

    .line 466
    iget-object v7, p0, Lorg/json/zip/Compressor;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v7, p1, v3, v4}, Lorg/json/zip/TrieKeep;->registerOne(Lorg/json/Kim;II)I

    .line 468
    const/4 v3, -0x1

    .line 470
    :cond_5
    move v3, v0

    .line 471
    add-int/lit8 v4, v1, 0x1

    .line 472
    goto :goto_0
.end method

.method private writeValue(Ljava/lang/Object;)V
    .locals 9
    .param p1, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x2

    .line 500
    instance-of v5, p1, Ljava/lang/Number;

    if-eqz v5, :cond_6

    move-object v5, p1

    .line 501
    check-cast v5, Ljava/lang/Number;

    invoke-static {v5}, Lorg/json/JSONObject;->numberToString(Ljava/lang/Number;)Ljava/lang/String;

    move-result-object v4

    .line 502
    .local v4, "string":Ljava/lang/String;
    iget-object v5, p0, Lorg/json/zip/Compressor;->values:Lorg/json/zip/MapKeep;

    invoke-virtual {v5, v4}, Lorg/json/zip/MapKeep;->find(Ljava/lang/Object;)I

    move-result v1

    .line 503
    .local v1, "integer":I
    const/4 v5, -0x1

    if-eq v1, v5, :cond_0

    .line 504
    invoke-direct {p0, v7, v7}, Lorg/json/zip/Compressor;->write(II)V

    .line 505
    iget-object v5, p0, Lorg/json/zip/Compressor;->values:Lorg/json/zip/MapKeep;

    invoke-direct {p0, v1, v5}, Lorg/json/zip/Compressor;->writeAndTick(ILorg/json/zip/Keep;)V

    .line 538
    .end local v1    # "integer":I
    .end local v4    # "string":Ljava/lang/String;
    .end local p1    # "value":Ljava/lang/Object;
    :goto_0
    return-void

    .line 508
    .restart local v1    # "integer":I
    .restart local v4    # "string":Ljava/lang/String;
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_0
    instance-of v5, p1, Ljava/lang/Integer;

    if-nez v5, :cond_1

    instance-of v5, p1, Ljava/lang/Long;

    if-eqz v5, :cond_4

    .line 509
    :cond_1
    check-cast p1, Ljava/lang/Number;

    .end local p1    # "value":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/Number;->longValue()J

    move-result-wide v2

    .line 510
    .local v2, "longer":J
    const-wide/16 v5, 0x0

    cmp-long v5, v2, v5

    if-ltz v5, :cond_4

    const-wide/16 v5, 0x4000

    cmp-long v5, v2, v5

    if-gez v5, :cond_4

    .line 511
    const/4 v5, 0x0

    invoke-direct {p0, v5, v7}, Lorg/json/zip/Compressor;->write(II)V

    .line 512
    const-wide/16 v5, 0x10

    cmp-long v5, v2, v5

    if-gez v5, :cond_2

    .line 513
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 514
    long-to-int v5, v2

    invoke-direct {p0, v5, v8}, Lorg/json/zip/Compressor;->write(II)V

    goto :goto_0

    .line 517
    :cond_2
    invoke-direct {p0}, Lorg/json/zip/Compressor;->one()V

    .line 518
    const-wide/16 v5, 0x80

    cmp-long v5, v2, v5

    if-gez v5, :cond_3

    .line 519
    invoke-direct {p0}, Lorg/json/zip/Compressor;->zero()V

    .line 520
    long-to-int v5, v2

    const/4 v6, 0x7

    invoke-direct {p0, v5, v6}, Lorg/json/zip/Compressor;->write(II)V

    goto :goto_0

    .line 523
    :cond_3
    invoke-direct {p0}, Lorg/json/zip/Compressor;->one()V

    .line 524
    long-to-int v5, v2

    const/16 v6, 0xe

    invoke-direct {p0, v5, v6}, Lorg/json/zip/Compressor;->write(II)V

    goto :goto_0

    .line 528
    .end local v2    # "longer":J
    :cond_4
    const/4 v5, 0x1

    invoke-direct {p0, v5, v7}, Lorg/json/zip/Compressor;->write(II)V

    .line 529
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    if-ge v0, v5, :cond_5

    .line 530
    invoke-virtual {v4, v0}, Ljava/lang/String;->charAt(I)C

    move-result v5

    invoke-static {v5}, Lorg/json/zip/Compressor;->bcd(C)I

    move-result v5

    invoke-direct {p0, v5, v8}, Lorg/json/zip/Compressor;->write(II)V

    .line 529
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 532
    :cond_5
    sget v5, Lorg/json/zip/Compressor;->endOfNumber:I

    invoke-direct {p0, v5, v8}, Lorg/json/zip/Compressor;->write(II)V

    .line 533
    iget-object v5, p0, Lorg/json/zip/Compressor;->values:Lorg/json/zip/MapKeep;

    invoke-virtual {v5, v4}, Lorg/json/zip/MapKeep;->register(Ljava/lang/Object;)V

    goto :goto_0

    .line 535
    .end local v0    # "i":I
    .end local v1    # "integer":I
    .end local v4    # "string":Ljava/lang/String;
    .restart local p1    # "value":Ljava/lang/Object;
    :cond_6
    const/4 v5, 0x3

    invoke-direct {p0, v5, v7}, Lorg/json/zip/Compressor;->write(II)V

    .line 536
    invoke-direct {p0, p1}, Lorg/json/zip/Compressor;->writeJSON(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private zero()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 551
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-direct {p0, v0, v1}, Lorg/json/zip/Compressor;->write(II)V

    .line 552
    return-void
.end method


# virtual methods
.method public flush()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 104
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lorg/json/zip/Compressor;->pad(I)V

    .line 105
    return-void
.end method

.method public pad(I)V
    .locals 2
    .param p1, "factor"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 130
    :try_start_0
    iget-object v1, p0, Lorg/json/zip/Compressor;->bitwriter:Lorg/json/zip/BitWriter;

    invoke-interface {v1, p1}, Lorg/json/zip/BitWriter;->pad(I)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 134
    return-void

    .line 131
    :catch_0
    move-exception v0

    .line 132
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v1, Lorg/json/JSONException;

    invoke-direct {v1, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public zip(Lorg/json/JSONArray;)V
    .locals 0
    .param p1, "jsonarray"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 572
    invoke-virtual {p0}, Lorg/json/zip/Compressor;->begin()V

    .line 573
    invoke-direct {p0, p1}, Lorg/json/zip/Compressor;->writeJSON(Ljava/lang/Object;)V

    .line 574
    return-void
.end method

.method public zip(Lorg/json/JSONObject;)V
    .locals 0
    .param p1, "jsonobject"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 561
    invoke-virtual {p0}, Lorg/json/zip/Compressor;->begin()V

    .line 562
    invoke-direct {p0, p1}, Lorg/json/zip/Compressor;->writeJSON(Ljava/lang/Object;)V

    .line 563
    return-void
.end method
