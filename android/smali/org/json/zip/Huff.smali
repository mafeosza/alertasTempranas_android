.class public Lorg/json/zip/Huff;
.super Ljava/lang/Object;
.source "Huff.java"

# interfaces
.implements Lorg/json/zip/None;
.implements Lorg/json/zip/PostMortem;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/json/zip/Huff$Symbol;
    }
.end annotation


# instance fields
.field private final domain:I

.field private final symbols:[Lorg/json/zip/Huff$Symbol;

.field private table:Lorg/json/zip/Huff$Symbol;

.field private upToDate:Z

.field private width:I


# direct methods
.method public constructor <init>(I)V
    .locals 5
    .param p1, "domain"    # I

    .prologue
    .line 133
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 66
    const/4 v2, 0x0

    iput-boolean v2, p0, Lorg/json/zip/Huff;->upToDate:Z

    .line 134
    iput p1, p0, Lorg/json/zip/Huff;->domain:I

    .line 135
    mul-int/lit8 v2, p1, 0x2

    add-int/lit8 v1, v2, -0x1

    .line 136
    .local v1, "length":I
    new-array v2, v1, [Lorg/json/zip/Huff$Symbol;

    iput-object v2, p0, Lorg/json/zip/Huff;->symbols:[Lorg/json/zip/Huff$Symbol;

    .line 140
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p1, :cond_0

    .line 141
    iget-object v2, p0, Lorg/json/zip/Huff;->symbols:[Lorg/json/zip/Huff$Symbol;

    new-instance v3, Lorg/json/zip/Huff$Symbol;

    invoke-direct {v3, v0}, Lorg/json/zip/Huff$Symbol;-><init>(I)V

    aput-object v3, v2, v0

    .line 140
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 146
    :cond_0
    move v0, p1

    :goto_1
    if-ge v0, v1, :cond_1

    .line 147
    iget-object v2, p0, Lorg/json/zip/Huff;->symbols:[Lorg/json/zip/Huff$Symbol;

    new-instance v3, Lorg/json/zip/Huff$Symbol;

    const/4 v4, -0x1

    invoke-direct {v3, v4}, Lorg/json/zip/Huff$Symbol;-><init>(I)V

    aput-object v3, v2, v0

    .line 146
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 149
    :cond_1
    return-void
.end method

.method private postMortem(I)Z
    .locals 8
    .param p1, "integer"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 254
    iget v6, p0, Lorg/json/zip/Huff;->domain:I

    new-array v1, v6, [I

    .line 255
    .local v1, "bits":[I
    iget-object v6, p0, Lorg/json/zip/Huff;->symbols:[Lorg/json/zip/Huff$Symbol;

    aget-object v3, v6, p1

    .line 256
    .local v3, "symbol":Lorg/json/zip/Huff$Symbol;
    iget v6, v3, Lorg/json/zip/Huff$Symbol;->integer:I

    if-eq v6, p1, :cond_1

    .line 284
    :cond_0
    :goto_0
    return v5

    .line 259
    :cond_1
    const/4 v2, 0x0

    .line 261
    .local v2, "i":I
    :goto_1
    iget-object v0, v3, Lorg/json/zip/Huff$Symbol;->back:Lorg/json/zip/Huff$Symbol;

    .line 262
    .local v0, "back":Lorg/json/zip/Huff$Symbol;
    if-nez v0, :cond_2

    .line 275
    iget-object v6, p0, Lorg/json/zip/Huff;->table:Lorg/json/zip/Huff$Symbol;

    if-ne v3, v6, :cond_0

    .line 278
    iput v5, p0, Lorg/json/zip/Huff;->width:I

    .line 279
    iget-object v3, p0, Lorg/json/zip/Huff;->table:Lorg/json/zip/Huff$Symbol;

    .line 280
    :goto_2
    iget v6, v3, Lorg/json/zip/Huff$Symbol;->integer:I

    const/4 v7, -0x1

    if-ne v6, v7, :cond_5

    .line 281
    add-int/lit8 v2, v2, -0x1

    .line 282
    aget v6, v1, v2

    if-eqz v6, :cond_4

    iget-object v3, v3, Lorg/json/zip/Huff$Symbol;->one:Lorg/json/zip/Huff$Symbol;

    :goto_3
    goto :goto_2

    .line 265
    :cond_2
    iget-object v6, v0, Lorg/json/zip/Huff$Symbol;->zero:Lorg/json/zip/Huff$Symbol;

    if-ne v6, v3, :cond_3

    .line 266
    aput v5, v1, v2

    .line 272
    :goto_4
    add-int/lit8 v2, v2, 0x1

    .line 273
    move-object v3, v0

    .line 274
    goto :goto_1

    .line 267
    :cond_3
    iget-object v6, v0, Lorg/json/zip/Huff$Symbol;->one:Lorg/json/zip/Huff$Symbol;

    if-ne v6, v3, :cond_0

    .line 268
    aput v4, v1, v2

    goto :goto_4

    .line 282
    :cond_4
    iget-object v3, v3, Lorg/json/zip/Huff$Symbol;->zero:Lorg/json/zip/Huff$Symbol;

    goto :goto_3

    .line 284
    :cond_5
    iget v6, v3, Lorg/json/zip/Huff$Symbol;->integer:I

    if-ne v6, p1, :cond_6

    if-nez v2, :cond_6

    :goto_5
    move v5, v4

    goto :goto_0

    :cond_6
    move v4, v5

    goto :goto_5
.end method

.method private write(Lorg/json/zip/Huff$Symbol;Lorg/json/zip/BitWriter;)V
    .locals 3
    .param p1, "symbol"    # Lorg/json/zip/Huff$Symbol;
    .param p2, "bitwriter"    # Lorg/json/zip/BitWriter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 372
    :try_start_0
    iget-object v0, p1, Lorg/json/zip/Huff$Symbol;->back:Lorg/json/zip/Huff$Symbol;

    .line 373
    .local v0, "back":Lorg/json/zip/Huff$Symbol;
    if-eqz v0, :cond_0

    .line 374
    iget v2, p0, Lorg/json/zip/Huff;->width:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lorg/json/zip/Huff;->width:I

    .line 375
    invoke-direct {p0, v0, p2}, Lorg/json/zip/Huff;->write(Lorg/json/zip/Huff$Symbol;Lorg/json/zip/BitWriter;)V

    .line 376
    iget-object v2, v0, Lorg/json/zip/Huff$Symbol;->zero:Lorg/json/zip/Huff$Symbol;

    if-ne v2, p1, :cond_1

    .line 377
    invoke-interface {p2}, Lorg/json/zip/BitWriter;->zero()V

    .line 385
    :cond_0
    :goto_0
    return-void

    .line 379
    :cond_1
    invoke-interface {p2}, Lorg/json/zip/BitWriter;->one()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 382
    .end local v0    # "back":Lorg/json/zip/Huff$Symbol;
    :catch_0
    move-exception v1

    .line 383
    .local v1, "e":Ljava/lang/Throwable;
    new-instance v2, Lorg/json/JSONException;

    invoke-direct {v2, v1}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method


# virtual methods
.method public generate()V
    .locals 13

    .prologue
    const/4 v12, 0x0

    .line 158
    iget-boolean v8, p0, Lorg/json/zip/Huff;->upToDate:Z

    if-nez v8, :cond_5

    .line 162
    iget-object v8, p0, Lorg/json/zip/Huff;->symbols:[Lorg/json/zip/Huff$Symbol;

    const/4 v9, 0x0

    aget-object v2, v8, v9

    .line 164
    .local v2, "head":Lorg/json/zip/Huff$Symbol;
    move-object v5, v2

    .line 167
    .local v5, "previous":Lorg/json/zip/Huff$Symbol;
    iput-object v12, p0, Lorg/json/zip/Huff;->table:Lorg/json/zip/Huff$Symbol;

    .line 168
    iput-object v12, v2, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 169
    const/4 v3, 0x1

    .local v3, "i":I
    :goto_0
    iget v8, p0, Lorg/json/zip/Huff;->domain:I

    if-ge v3, v8, :cond_4

    .line 170
    iget-object v8, p0, Lorg/json/zip/Huff;->symbols:[Lorg/json/zip/Huff$Symbol;

    aget-object v7, v8, v3

    .line 174
    .local v7, "symbol":Lorg/json/zip/Huff$Symbol;
    iget-wide v8, v7, Lorg/json/zip/Huff$Symbol;->weight:J

    iget-wide v10, v2, Lorg/json/zip/Huff$Symbol;->weight:J

    cmp-long v8, v8, v10

    if-gez v8, :cond_0

    .line 175
    iput-object v2, v7, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 176
    move-object v2, v7

    .line 169
    :goto_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 182
    :cond_0
    iget-wide v8, v7, Lorg/json/zip/Huff$Symbol;->weight:J

    iget-wide v10, v5, Lorg/json/zip/Huff$Symbol;->weight:J

    cmp-long v8, v8, v10

    if-gez v8, :cond_1

    .line 183
    move-object v5, v2

    .line 190
    :cond_1
    :goto_2
    iget-object v4, v5, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 191
    .local v4, "next":Lorg/json/zip/Huff$Symbol;
    if-eqz v4, :cond_2

    iget-wide v8, v7, Lorg/json/zip/Huff$Symbol;->weight:J

    iget-wide v10, v4, Lorg/json/zip/Huff$Symbol;->weight:J

    cmp-long v8, v8, v10

    if-gez v8, :cond_3

    .line 196
    :cond_2
    iput-object v4, v7, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 197
    iput-object v7, v5, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 198
    move-object v5, v7

    goto :goto_1

    .line 194
    :cond_3
    move-object v5, v4

    goto :goto_2

    .line 205
    .end local v4    # "next":Lorg/json/zip/Huff$Symbol;
    .end local v7    # "symbol":Lorg/json/zip/Huff$Symbol;
    :cond_4
    iget v0, p0, Lorg/json/zip/Huff;->domain:I

    .line 208
    .local v0, "avail":I
    move-object v5, v2

    .line 210
    :goto_3
    move-object v1, v2

    .line 211
    .local v1, "first":Lorg/json/zip/Huff$Symbol;
    iget-object v6, v1, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 212
    .local v6, "second":Lorg/json/zip/Huff$Symbol;
    iget-object v2, v6, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 213
    iget-object v8, p0, Lorg/json/zip/Huff;->symbols:[Lorg/json/zip/Huff$Symbol;

    aget-object v7, v8, v0

    .line 214
    .restart local v7    # "symbol":Lorg/json/zip/Huff$Symbol;
    add-int/lit8 v0, v0, 0x1

    .line 215
    iget-wide v8, v1, Lorg/json/zip/Huff$Symbol;->weight:J

    iget-wide v10, v6, Lorg/json/zip/Huff$Symbol;->weight:J

    add-long/2addr v8, v10

    iput-wide v8, v7, Lorg/json/zip/Huff$Symbol;->weight:J

    .line 216
    iput-object v1, v7, Lorg/json/zip/Huff$Symbol;->zero:Lorg/json/zip/Huff$Symbol;

    .line 217
    iput-object v6, v7, Lorg/json/zip/Huff$Symbol;->one:Lorg/json/zip/Huff$Symbol;

    .line 218
    iput-object v12, v7, Lorg/json/zip/Huff$Symbol;->back:Lorg/json/zip/Huff$Symbol;

    .line 219
    iput-object v7, v1, Lorg/json/zip/Huff$Symbol;->back:Lorg/json/zip/Huff$Symbol;

    .line 220
    iput-object v7, v6, Lorg/json/zip/Huff$Symbol;->back:Lorg/json/zip/Huff$Symbol;

    .line 221
    if-nez v2, :cond_6

    .line 248
    iput-object v7, p0, Lorg/json/zip/Huff;->table:Lorg/json/zip/Huff$Symbol;

    .line 249
    const/4 v8, 0x1

    iput-boolean v8, p0, Lorg/json/zip/Huff;->upToDate:Z

    .line 251
    .end local v0    # "avail":I
    .end local v1    # "first":Lorg/json/zip/Huff$Symbol;
    .end local v2    # "head":Lorg/json/zip/Huff$Symbol;
    .end local v3    # "i":I
    .end local v5    # "previous":Lorg/json/zip/Huff$Symbol;
    .end local v6    # "second":Lorg/json/zip/Huff$Symbol;
    .end local v7    # "symbol":Lorg/json/zip/Huff$Symbol;
    :cond_5
    return-void

    .line 227
    .restart local v0    # "avail":I
    .restart local v1    # "first":Lorg/json/zip/Huff$Symbol;
    .restart local v2    # "head":Lorg/json/zip/Huff$Symbol;
    .restart local v3    # "i":I
    .restart local v5    # "previous":Lorg/json/zip/Huff$Symbol;
    .restart local v6    # "second":Lorg/json/zip/Huff$Symbol;
    .restart local v7    # "symbol":Lorg/json/zip/Huff$Symbol;
    :cond_6
    iget-wide v8, v7, Lorg/json/zip/Huff$Symbol;->weight:J

    iget-wide v10, v2, Lorg/json/zip/Huff$Symbol;->weight:J

    cmp-long v8, v8, v10

    if-gez v8, :cond_8

    .line 228
    iput-object v2, v7, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 229
    move-object v2, v7

    .line 230
    move-object v5, v2

    goto :goto_3

    .line 237
    .restart local v4    # "next":Lorg/json/zip/Huff$Symbol;
    :cond_7
    move-object v5, v4

    .line 233
    .end local v4    # "next":Lorg/json/zip/Huff$Symbol;
    :cond_8
    iget-object v4, v5, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 234
    .restart local v4    # "next":Lorg/json/zip/Huff$Symbol;
    if-eqz v4, :cond_9

    iget-wide v8, v7, Lorg/json/zip/Huff$Symbol;->weight:J

    iget-wide v10, v4, Lorg/json/zip/Huff$Symbol;->weight:J

    cmp-long v8, v8, v10

    if-gez v8, :cond_7

    .line 239
    :cond_9
    iput-object v4, v7, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 240
    iput-object v7, v5, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 241
    move-object v5, v7

    goto :goto_3
.end method

.method public postMortem(Lorg/json/zip/PostMortem;)Z
    .locals 3
    .param p1, "pm"    # Lorg/json/zip/PostMortem;

    .prologue
    .line 295
    const/4 v0, 0x0

    .local v0, "integer":I
    :goto_0
    iget v1, p0, Lorg/json/zip/Huff;->domain:I

    if-ge v0, v1, :cond_1

    .line 296
    invoke-direct {p0, v0}, Lorg/json/zip/Huff;->postMortem(I)Z

    move-result v1

    if-nez v1, :cond_0

    .line 297
    const-string v1, "\nBad huff "

    invoke-static {v1}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    .line 298
    invoke-static {v0, v0}, Lorg/json/zip/JSONzip;->logchar(II)V

    .line 299
    const/4 v1, 0x0

    .line 302
    .end local p1    # "pm":Lorg/json/zip/PostMortem;
    :goto_1
    return v1

    .line 295
    .restart local p1    # "pm":Lorg/json/zip/PostMortem;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 302
    :cond_1
    iget-object v1, p0, Lorg/json/zip/Huff;->table:Lorg/json/zip/Huff$Symbol;

    check-cast p1, Lorg/json/zip/Huff;

    .end local p1    # "pm":Lorg/json/zip/PostMortem;
    iget-object v2, p1, Lorg/json/zip/Huff;->table:Lorg/json/zip/Huff$Symbol;

    invoke-virtual {v1, v2}, Lorg/json/zip/Huff$Symbol;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v1

    goto :goto_1
.end method

.method public read(Lorg/json/zip/BitReader;)I
    .locals 4
    .param p1, "bitreader"    # Lorg/json/zip/BitReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 316
    const/4 v2, 0x0

    :try_start_0
    iput v2, p0, Lorg/json/zip/Huff;->width:I

    .line 317
    iget-object v1, p0, Lorg/json/zip/Huff;->table:Lorg/json/zip/Huff$Symbol;

    .line 318
    .local v1, "symbol":Lorg/json/zip/Huff$Symbol;
    :goto_0
    iget v2, v1, Lorg/json/zip/Huff$Symbol;->integer:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_1

    .line 319
    iget v2, p0, Lorg/json/zip/Huff;->width:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lorg/json/zip/Huff;->width:I

    .line 320
    invoke-interface {p1}, Lorg/json/zip/BitReader;->bit()Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v1, v1, Lorg/json/zip/Huff$Symbol;->one:Lorg/json/zip/Huff$Symbol;

    :goto_1
    goto :goto_0

    :cond_0
    iget-object v1, v1, Lorg/json/zip/Huff$Symbol;->zero:Lorg/json/zip/Huff$Symbol;

    goto :goto_1

    .line 322
    :cond_1
    iget v2, v1, Lorg/json/zip/Huff$Symbol;->integer:I

    invoke-virtual {p0, v2}, Lorg/json/zip/Huff;->tick(I)V

    .line 326
    iget v2, v1, Lorg/json/zip/Huff$Symbol;->integer:I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    return v2

    .line 327
    .end local v1    # "symbol":Lorg/json/zip/Huff$Symbol;
    :catch_0
    move-exception v0

    .line 328
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v2, Lorg/json/JSONException;

    invoke-direct {v2, v0}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v2
.end method

.method public tick(I)V
    .locals 5
    .param p1, "value"    # I

    .prologue
    .line 340
    iget-object v0, p0, Lorg/json/zip/Huff;->symbols:[Lorg/json/zip/Huff$Symbol;

    aget-object v0, v0, p1

    iget-wide v1, v0, Lorg/json/zip/Huff$Symbol;->weight:J

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    iput-wide v1, v0, Lorg/json/zip/Huff$Symbol;->weight:J

    .line 341
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/json/zip/Huff;->upToDate:Z

    .line 342
    return-void
.end method

.method public tick(II)V
    .locals 1
    .param p1, "from"    # I
    .param p2, "to"    # I

    .prologue
    .line 354
    move v0, p1

    .local v0, "value":I
    :goto_0
    if-gt v0, p2, :cond_0

    .line 355
    invoke-virtual {p0, v0}, Lorg/json/zip/Huff;->tick(I)V

    .line 354
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 357
    :cond_0
    return-void
.end method

.method public write(ILorg/json/zip/BitWriter;)V
    .locals 1
    .param p1, "value"    # I
    .param p2, "bitwriter"    # Lorg/json/zip/BitWriter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 399
    const/4 v0, 0x0

    iput v0, p0, Lorg/json/zip/Huff;->width:I

    .line 400
    iget-object v0, p0, Lorg/json/zip/Huff;->symbols:[Lorg/json/zip/Huff$Symbol;

    aget-object v0, v0, p1

    invoke-direct {p0, v0, p2}, Lorg/json/zip/Huff;->write(Lorg/json/zip/Huff$Symbol;Lorg/json/zip/BitWriter;)V

    .line 401
    invoke-virtual {p0, p1}, Lorg/json/zip/Huff;->tick(I)V

    .line 405
    return-void
.end method
