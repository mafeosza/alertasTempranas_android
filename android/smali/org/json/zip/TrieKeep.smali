.class Lorg/json/zip/TrieKeep;
.super Lorg/json/zip/Keep;
.source "TrieKeep.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/json/zip/TrieKeep$Node;
    }
.end annotation


# instance fields
.field private froms:[I

.field private kims:[Lorg/json/Kim;

.field private root:Lorg/json/zip/TrieKeep$Node;

.field private thrus:[I


# direct methods
.method public constructor <init>(I)V
    .locals 1
    .param p1, "bits"    # I

    .prologue
    .line 185
    invoke-direct {p0, p1}, Lorg/json/zip/Keep;-><init>(I)V

    .line 186
    iget v0, p0, Lorg/json/zip/TrieKeep;->capacity:I

    new-array v0, v0, [I

    iput-object v0, p0, Lorg/json/zip/TrieKeep;->froms:[I

    .line 187
    iget v0, p0, Lorg/json/zip/TrieKeep;->capacity:I

    new-array v0, v0, [I

    iput-object v0, p0, Lorg/json/zip/TrieKeep;->thrus:[I

    .line 188
    iget v0, p0, Lorg/json/zip/TrieKeep;->capacity:I

    new-array v0, v0, [Lorg/json/Kim;

    iput-object v0, p0, Lorg/json/zip/TrieKeep;->kims:[Lorg/json/Kim;

    .line 189
    new-instance v0, Lorg/json/zip/TrieKeep$Node;

    invoke-direct {v0, p0}, Lorg/json/zip/TrieKeep$Node;-><init>(Lorg/json/zip/TrieKeep;)V

    iput-object v0, p0, Lorg/json/zip/TrieKeep;->root:Lorg/json/zip/TrieKeep$Node;

    .line 190
    return-void
.end method


# virtual methods
.method public kim(I)Lorg/json/Kim;
    .locals 6
    .param p1, "integer"    # I

    .prologue
    .line 199
    iget-object v4, p0, Lorg/json/zip/TrieKeep;->kims:[Lorg/json/Kim;

    aget-object v1, v4, p1

    .line 200
    .local v1, "kim":Lorg/json/Kim;
    iget-object v4, p0, Lorg/json/zip/TrieKeep;->froms:[I

    aget v0, v4, p1

    .line 201
    .local v0, "from":I
    iget-object v4, p0, Lorg/json/zip/TrieKeep;->thrus:[I

    aget v3, v4, p1

    .line 202
    .local v3, "thru":I
    if-nez v0, :cond_0

    iget v4, v1, Lorg/json/Kim;->length:I

    if-eq v3, v4, :cond_1

    .line 203
    :cond_0
    new-instance v2, Lorg/json/Kim;

    invoke-direct {v2, v1, v0, v3}, Lorg/json/Kim;-><init>(Lorg/json/Kim;II)V

    .line 204
    .end local v1    # "kim":Lorg/json/Kim;
    .local v2, "kim":Lorg/json/Kim;
    iget-object v4, p0, Lorg/json/zip/TrieKeep;->froms:[I

    const/4 v5, 0x0

    aput v5, v4, p1

    .line 205
    iget-object v4, p0, Lorg/json/zip/TrieKeep;->thrus:[I

    iget v5, v2, Lorg/json/Kim;->length:I

    aput v5, v4, p1

    .line 206
    iget-object v4, p0, Lorg/json/zip/TrieKeep;->kims:[Lorg/json/Kim;

    aput-object v2, v4, p1

    move-object v1, v2

    .line 208
    .end local v2    # "kim":Lorg/json/Kim;
    .restart local v1    # "kim":Lorg/json/Kim;
    :cond_1
    return-object v1
.end method

.method public length(I)I
    .locals 2
    .param p1, "integer"    # I

    .prologue
    .line 219
    iget-object v0, p0, Lorg/json/zip/TrieKeep;->thrus:[I

    aget v0, v0, p1

    iget-object v1, p0, Lorg/json/zip/TrieKeep;->froms:[I

    aget v1, v1, p1

    sub-int/2addr v0, v1

    return v0
.end method

.method public match(Lorg/json/Kim;II)I
    .locals 5
    .param p1, "kim"    # Lorg/json/Kim;
    .param p2, "from"    # I
    .param p3, "thru"    # I

    .prologue
    .line 231
    iget-object v2, p0, Lorg/json/zip/TrieKeep;->root:Lorg/json/zip/TrieKeep$Node;

    .line 232
    .local v2, "node":Lorg/json/zip/TrieKeep$Node;
    const/4 v1, -0x1

    .line 233
    .local v1, "best":I
    move v0, p2

    .local v0, "at":I
    :goto_0
    if-ge v0, p3, :cond_0

    .line 234
    invoke-virtual {p1, v0}, Lorg/json/Kim;->get(I)I

    move-result v3

    invoke-virtual {v2, v3}, Lorg/json/zip/TrieKeep$Node;->get(I)Lorg/json/zip/TrieKeep$Node;

    move-result-object v2

    .line 235
    if-nez v2, :cond_1

    .line 243
    :cond_0
    return v1

    .line 238
    :cond_1
    invoke-static {v2}, Lorg/json/zip/TrieKeep$Node;->access$000(Lorg/json/zip/TrieKeep$Node;)I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_2

    .line 239
    invoke-static {v2}, Lorg/json/zip/TrieKeep$Node;->access$000(Lorg/json/zip/TrieKeep$Node;)I

    move-result v1

    .line 241
    :cond_2
    add-int/lit8 p2, p2, 0x1

    .line 233
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public postMortem(Lorg/json/zip/PostMortem;)Z
    .locals 8
    .param p1, "pm"    # Lorg/json/zip/PostMortem;

    .prologue
    const/4 v5, 0x0

    .line 247
    const/4 v1, 0x1

    .local v1, "result":Z
    move-object v2, p1

    .line 248
    check-cast v2, Lorg/json/zip/TrieKeep;

    .line 249
    .local v2, "that":Lorg/json/zip/TrieKeep;
    iget v6, p0, Lorg/json/zip/TrieKeep;->length:I

    iget v7, v2, Lorg/json/zip/TrieKeep;->length:I

    if-eq v6, v7, :cond_1

    .line 250
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    const-string v7, "\nLength "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    iget v7, p0, Lorg/json/zip/TrieKeep;->length:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v6

    const-string v7, " <> "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    iget v7, v2, Lorg/json/zip/TrieKeep;->length:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    .line 266
    :cond_0
    :goto_0
    return v5

    .line 253
    :cond_1
    iget v6, p0, Lorg/json/zip/TrieKeep;->capacity:I

    iget v7, v2, Lorg/json/zip/TrieKeep;->capacity:I

    if-eq v6, v7, :cond_2

    .line 254
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    const-string v7, "\nCapacity "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    iget v7, p0, Lorg/json/zip/TrieKeep;->capacity:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v6

    const-string v7, " <> "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    iget v7, v2, Lorg/json/zip/TrieKeep;->capacity:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    goto :goto_0

    .line 258
    :cond_2
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget v6, p0, Lorg/json/zip/TrieKeep;->length:I

    if-ge v0, v6, :cond_4

    .line 259
    invoke-virtual {p0, v0}, Lorg/json/zip/TrieKeep;->kim(I)Lorg/json/Kim;

    move-result-object v4

    .line 260
    .local v4, "thiskim":Lorg/json/Kim;
    invoke-virtual {v2, v0}, Lorg/json/zip/TrieKeep;->kim(I)Lorg/json/Kim;

    move-result-object v3

    .line 261
    .local v3, "thatkim":Lorg/json/Kim;
    invoke-virtual {v4, v3}, Lorg/json/Kim;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 262
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    const-string v7, "\n["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v6

    const-string v7, "] "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v6

    const-string v7, " <> "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    .line 263
    const/4 v1, 0x0

    .line 258
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 266
    .end local v3    # "thatkim":Lorg/json/Kim;
    .end local v4    # "thiskim":Lorg/json/Kim;
    :cond_4
    if-eqz v1, :cond_0

    iget-object v6, p0, Lorg/json/zip/TrieKeep;->root:Lorg/json/zip/TrieKeep$Node;

    iget-object v7, v2, Lorg/json/zip/TrieKeep;->root:Lorg/json/zip/TrieKeep$Node;

    invoke-virtual {v6, v7}, Lorg/json/zip/TrieKeep$Node;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v6

    if-eqz v6, :cond_0

    const/4 v5, 0x1

    goto :goto_0
.end method

.method public registerMany(Lorg/json/Kim;)V
    .locals 12
    .param p1, "kim"    # Lorg/json/Kim;

    .prologue
    .line 270
    iget v3, p1, Lorg/json/Kim;->length:I

    .line 271
    .local v3, "length":I
    iget v8, p0, Lorg/json/zip/TrieKeep;->capacity:I

    iget v9, p0, Lorg/json/zip/TrieKeep;->length:I

    sub-int v4, v8, v9

    .line 272
    .local v4, "limit":I
    const/16 v8, 0x28

    if-le v4, v8, :cond_0

    .line 273
    const/16 v4, 0x28

    .line 275
    :cond_0
    add-int/lit8 v7, v3, -0x2

    .line 276
    .local v7, "until":I
    const/4 v1, 0x0

    .local v1, "from":I
    :goto_0
    if-ge v1, v7, :cond_2

    .line 277
    sub-int v2, v3, v1

    .line 278
    .local v2, "len":I
    const/16 v8, 0xa

    if-le v2, v8, :cond_1

    .line 279
    const/16 v2, 0xa

    .line 281
    :cond_1
    add-int/2addr v2, v1

    .line 282
    iget-object v6, p0, Lorg/json/zip/TrieKeep;->root:Lorg/json/zip/TrieKeep$Node;

    .line 283
    .local v6, "node":Lorg/json/zip/TrieKeep$Node;
    move v0, v1

    .local v0, "at":I
    :goto_1
    if-ge v0, v2, :cond_4

    .line 284
    invoke-virtual {p1, v0}, Lorg/json/Kim;->get(I)I

    move-result v8

    invoke-virtual {v6, v8}, Lorg/json/zip/TrieKeep$Node;->vet(I)Lorg/json/zip/TrieKeep$Node;

    move-result-object v5

    .line 285
    .local v5, "next":Lorg/json/zip/TrieKeep$Node;
    invoke-static {v5}, Lorg/json/zip/TrieKeep$Node;->access$000(Lorg/json/zip/TrieKeep$Node;)I

    move-result v8

    const/4 v9, -0x1

    if-ne v8, v9, :cond_3

    sub-int v8, v0, v1

    const/4 v9, 0x2

    if-lt v8, v9, :cond_3

    .line 287
    iget v8, p0, Lorg/json/zip/TrieKeep;->length:I

    invoke-static {v5, v8}, Lorg/json/zip/TrieKeep$Node;->access$002(Lorg/json/zip/TrieKeep$Node;I)I

    .line 288
    iget-object v8, p0, Lorg/json/zip/TrieKeep;->uses:[J

    iget v9, p0, Lorg/json/zip/TrieKeep;->length:I

    const-wide/16 v10, 0x1

    aput-wide v10, v8, v9

    .line 289
    iget-object v8, p0, Lorg/json/zip/TrieKeep;->kims:[Lorg/json/Kim;

    iget v9, p0, Lorg/json/zip/TrieKeep;->length:I

    aput-object p1, v8, v9

    .line 290
    iget-object v8, p0, Lorg/json/zip/TrieKeep;->froms:[I

    iget v9, p0, Lorg/json/zip/TrieKeep;->length:I

    aput v1, v8, v9

    .line 291
    iget-object v8, p0, Lorg/json/zip/TrieKeep;->thrus:[I

    iget v9, p0, Lorg/json/zip/TrieKeep;->length:I

    add-int/lit8 v10, v0, 0x1

    aput v10, v8, v9

    .line 299
    iget v8, p0, Lorg/json/zip/TrieKeep;->length:I

    add-int/lit8 v8, v8, 0x1

    iput v8, p0, Lorg/json/zip/TrieKeep;->length:I

    .line 300
    add-int/lit8 v4, v4, -0x1

    .line 301
    if-gtz v4, :cond_3

    .line 308
    .end local v0    # "at":I
    .end local v2    # "len":I
    .end local v5    # "next":Lorg/json/zip/TrieKeep$Node;
    .end local v6    # "node":Lorg/json/zip/TrieKeep$Node;
    :cond_2
    return-void

    .line 305
    .restart local v0    # "at":I
    .restart local v2    # "len":I
    .restart local v5    # "next":Lorg/json/zip/TrieKeep$Node;
    .restart local v6    # "node":Lorg/json/zip/TrieKeep$Node;
    :cond_3
    move-object v6, v5

    .line 283
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 276
    .end local v5    # "next":Lorg/json/zip/TrieKeep$Node;
    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public registerOne(Lorg/json/Kim;II)I
    .locals 6
    .param p1, "kim"    # Lorg/json/Kim;
    .param p2, "from"    # I
    .param p3, "thru"    # I

    .prologue
    const/4 v1, -0x1

    .line 318
    iget v3, p0, Lorg/json/zip/TrieKeep;->length:I

    iget v4, p0, Lorg/json/zip/TrieKeep;->capacity:I

    if-ge v3, v4, :cond_1

    .line 319
    iget-object v2, p0, Lorg/json/zip/TrieKeep;->root:Lorg/json/zip/TrieKeep$Node;

    .line 320
    .local v2, "node":Lorg/json/zip/TrieKeep$Node;
    move v0, p2

    .local v0, "at":I
    :goto_0
    if-ge v0, p3, :cond_0

    .line 321
    invoke-virtual {p1, v0}, Lorg/json/Kim;->get(I)I

    move-result v3

    invoke-virtual {v2, v3}, Lorg/json/zip/TrieKeep$Node;->vet(I)Lorg/json/zip/TrieKeep$Node;

    move-result-object v2

    .line 320
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 323
    :cond_0
    invoke-static {v2}, Lorg/json/zip/TrieKeep$Node;->access$000(Lorg/json/zip/TrieKeep$Node;)I

    move-result v3

    if-ne v3, v1, :cond_1

    .line 324
    iget v1, p0, Lorg/json/zip/TrieKeep;->length:I

    .line 325
    .local v1, "integer":I
    invoke-static {v2, v1}, Lorg/json/zip/TrieKeep$Node;->access$002(Lorg/json/zip/TrieKeep$Node;I)I

    .line 326
    iget-object v3, p0, Lorg/json/zip/TrieKeep;->uses:[J

    const-wide/16 v4, 0x1

    aput-wide v4, v3, v1

    .line 327
    iget-object v3, p0, Lorg/json/zip/TrieKeep;->kims:[Lorg/json/Kim;

    aput-object p1, v3, v1

    .line 328
    iget-object v3, p0, Lorg/json/zip/TrieKeep;->froms:[I

    aput p2, v3, v1

    .line 329
    iget-object v3, p0, Lorg/json/zip/TrieKeep;->thrus:[I

    aput p3, v3, v1

    .line 336
    iget v3, p0, Lorg/json/zip/TrieKeep;->length:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lorg/json/zip/TrieKeep;->length:I

    .line 340
    .end local v0    # "at":I
    .end local v1    # "integer":I
    .end local v2    # "node":Lorg/json/zip/TrieKeep$Node;
    :cond_1
    return v1
.end method

.method public registerOne(Lorg/json/Kim;)V
    .locals 3
    .param p1, "kim"    # Lorg/json/Kim;

    .prologue
    .line 311
    const/4 v1, 0x0

    iget v2, p1, Lorg/json/Kim;->length:I

    invoke-virtual {p0, p1, v1, v2}, Lorg/json/zip/TrieKeep;->registerOne(Lorg/json/Kim;II)I

    move-result v0

    .line 312
    .local v0, "integer":I
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 313
    iget-object v1, p0, Lorg/json/zip/TrieKeep;->kims:[Lorg/json/Kim;

    aput-object p1, v1, v0

    .line 315
    :cond_0
    return-void
.end method

.method public reserve()V
    .locals 13

    .prologue
    const/16 v12, 0x28

    const/4 v11, 0x0

    .line 350
    iget v7, p0, Lorg/json/zip/TrieKeep;->capacity:I

    iget v8, p0, Lorg/json/zip/TrieKeep;->length:I

    sub-int/2addr v7, v8

    if-ge v7, v12, :cond_4

    .line 351
    const/4 v1, 0x0

    .line 352
    .local v1, "from":I
    const/4 v6, 0x0

    .line 353
    .local v6, "to":I
    new-instance v7, Lorg/json/zip/TrieKeep$Node;

    invoke-direct {v7, p0}, Lorg/json/zip/TrieKeep$Node;-><init>(Lorg/json/zip/TrieKeep;)V

    iput-object v7, p0, Lorg/json/zip/TrieKeep;->root:Lorg/json/zip/TrieKeep$Node;

    .line 354
    :goto_0
    iget v7, p0, Lorg/json/zip/TrieKeep;->capacity:I

    if-ge v1, v7, :cond_2

    .line 355
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->uses:[J

    aget-wide v7, v7, v1

    const-wide/16 v9, 0x1

    cmp-long v7, v7, v9

    if-lez v7, :cond_1

    .line 356
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->kims:[Lorg/json/Kim;

    aget-object v2, v7, v1

    .line 357
    .local v2, "kim":Lorg/json/Kim;
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->thrus:[I

    aget v5, v7, v1

    .line 358
    .local v5, "thru":I
    iget-object v4, p0, Lorg/json/zip/TrieKeep;->root:Lorg/json/zip/TrieKeep$Node;

    .line 359
    .local v4, "node":Lorg/json/zip/TrieKeep$Node;
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->froms:[I

    aget v0, v7, v1

    .local v0, "at":I
    :goto_1
    if-ge v0, v5, :cond_0

    .line 360
    invoke-virtual {v2, v0}, Lorg/json/Kim;->get(I)I

    move-result v7

    invoke-virtual {v4, v7}, Lorg/json/zip/TrieKeep$Node;->vet(I)Lorg/json/zip/TrieKeep$Node;

    move-result-object v3

    .line 361
    .local v3, "next":Lorg/json/zip/TrieKeep$Node;
    move-object v4, v3

    .line 359
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 363
    .end local v3    # "next":Lorg/json/zip/TrieKeep$Node;
    :cond_0
    invoke-static {v4, v6}, Lorg/json/zip/TrieKeep$Node;->access$002(Lorg/json/zip/TrieKeep$Node;I)I

    .line 364
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->uses:[J

    iget-object v8, p0, Lorg/json/zip/TrieKeep;->uses:[J

    aget-wide v8, v8, v1

    invoke-static {v8, v9}, Lorg/json/zip/TrieKeep;->age(J)J

    move-result-wide v8

    aput-wide v8, v7, v6

    .line 365
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->froms:[I

    iget-object v8, p0, Lorg/json/zip/TrieKeep;->froms:[I

    aget v8, v8, v1

    aput v8, v7, v6

    .line 366
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->thrus:[I

    aput v5, v7, v6

    .line 367
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->kims:[Lorg/json/Kim;

    aput-object v2, v7, v6

    .line 368
    add-int/lit8 v6, v6, 0x1

    .line 370
    .end local v0    # "at":I
    .end local v2    # "kim":Lorg/json/Kim;
    .end local v4    # "node":Lorg/json/zip/TrieKeep$Node;
    .end local v5    # "thru":I
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 376
    :cond_2
    iget v7, p0, Lorg/json/zip/TrieKeep;->capacity:I

    sub-int/2addr v7, v6

    if-ge v7, v12, :cond_3

    .line 377
    iput v11, p0, Lorg/json/zip/TrieKeep;->power:I

    .line 378
    new-instance v7, Lorg/json/zip/TrieKeep$Node;

    invoke-direct {v7, p0}, Lorg/json/zip/TrieKeep$Node;-><init>(Lorg/json/zip/TrieKeep;)V

    iput-object v7, p0, Lorg/json/zip/TrieKeep;->root:Lorg/json/zip/TrieKeep$Node;

    .line 379
    const/4 v6, 0x0

    .line 381
    :cond_3
    iput v6, p0, Lorg/json/zip/TrieKeep;->length:I

    .line 382
    :goto_2
    iget v7, p0, Lorg/json/zip/TrieKeep;->capacity:I

    if-ge v6, v7, :cond_4

    .line 383
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->uses:[J

    const-wide/16 v8, 0x0

    aput-wide v8, v7, v6

    .line 384
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->kims:[Lorg/json/Kim;

    const/4 v8, 0x0

    aput-object v8, v7, v6

    .line 385
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->froms:[I

    aput v11, v7, v6

    .line 386
    iget-object v7, p0, Lorg/json/zip/TrieKeep;->thrus:[I

    aput v11, v7, v6

    .line 387
    add-int/lit8 v6, v6, 0x1

    goto :goto_2

    .line 391
    .end local v1    # "from":I
    .end local v6    # "to":I
    :cond_4
    return-void
.end method

.method public value(I)Ljava/lang/Object;
    .locals 1
    .param p1, "integer"    # I

    .prologue
    .line 394
    invoke-virtual {p0, p1}, Lorg/json/zip/TrieKeep;->kim(I)Lorg/json/Kim;

    move-result-object v0

    return-object v0
.end method
