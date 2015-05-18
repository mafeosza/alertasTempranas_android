.class public Lorg/json/JSONTokener;
.super Ljava/lang/Object;
.source "JSONTokener.java"


# instance fields
.field private character:J

.field private eof:Z

.field private index:J

.field private line:J

.field private previous:C

.field private reader:Ljava/io/Reader;

.field private usePrevious:Z


# direct methods
.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 1
    .param p1, "inputStream"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 74
    new-instance v0, Ljava/io/InputStreamReader;

    invoke-direct {v0, p1}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {p0, v0}, Lorg/json/JSONTokener;-><init>(Ljava/io/Reader;)V

    .line 75
    return-void
.end method

.method public constructor <init>(Ljava/io/Reader;)V
    .locals 4
    .param p1, "reader"    # Ljava/io/Reader;

    .prologue
    const-wide/16 v2, 0x1

    const/4 v1, 0x0

    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    invoke-virtual {p1}, Ljava/io/Reader;->markSupported()Z

    move-result v0

    if-eqz v0, :cond_0

    .end local p1    # "reader":Ljava/io/Reader;
    :goto_0
    iput-object p1, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    .line 61
    iput-boolean v1, p0, Lorg/json/JSONTokener;->eof:Z

    .line 62
    iput-boolean v1, p0, Lorg/json/JSONTokener;->usePrevious:Z

    .line 63
    iput-char v1, p0, Lorg/json/JSONTokener;->previous:C

    .line 64
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lorg/json/JSONTokener;->index:J

    .line 65
    iput-wide v2, p0, Lorg/json/JSONTokener;->character:J

    .line 66
    iput-wide v2, p0, Lorg/json/JSONTokener;->line:J

    .line 67
    return-void

    .line 58
    .restart local p1    # "reader":Ljava/io/Reader;
    :cond_0
    new-instance v0, Ljava/io/BufferedReader;

    invoke-direct {v0, p1}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    move-object p1, v0

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 84
    new-instance v0, Ljava/io/StringReader;

    invoke-direct {v0, p1}, Ljava/io/StringReader;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lorg/json/JSONTokener;-><init>(Ljava/io/Reader;)V

    .line 85
    return-void
.end method

.method public static dehexchar(C)I
    .locals 1
    .param p0, "c"    # C

    .prologue
    .line 111
    const/16 v0, 0x30

    if-lt p0, v0, :cond_0

    const/16 v0, 0x39

    if-gt p0, v0, :cond_0

    .line 112
    add-int/lit8 v0, p0, -0x30

    .line 120
    :goto_0
    return v0

    .line 114
    :cond_0
    const/16 v0, 0x41

    if-lt p0, v0, :cond_1

    const/16 v0, 0x46

    if-gt p0, v0, :cond_1

    .line 115
    add-int/lit8 v0, p0, -0x37

    goto :goto_0

    .line 117
    :cond_1
    const/16 v0, 0x61

    if-lt p0, v0, :cond_2

    const/16 v0, 0x66

    if-gt p0, v0, :cond_2

    .line 118
    add-int/lit8 v0, p0, -0x57

    goto :goto_0

    .line 120
    :cond_2
    const/4 v0, -0x1

    goto :goto_0
.end method


# virtual methods
.method public back()V
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const-wide/16 v4, 0x1

    .line 94
    iget-boolean v0, p0, Lorg/json/JSONTokener;->usePrevious:Z

    if-nez v0, :cond_0

    iget-wide v0, p0, Lorg/json/JSONTokener;->index:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_1

    .line 95
    :cond_0
    new-instance v0, Lorg/json/JSONException;

    const-string v1, "Stepping back two steps is not supported"

    invoke-direct {v0, v1}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 97
    :cond_1
    iget-wide v0, p0, Lorg/json/JSONTokener;->index:J

    sub-long/2addr v0, v4

    iput-wide v0, p0, Lorg/json/JSONTokener;->index:J

    .line 98
    iget-wide v0, p0, Lorg/json/JSONTokener;->character:J

    sub-long/2addr v0, v4

    iput-wide v0, p0, Lorg/json/JSONTokener;->character:J

    .line 99
    const/4 v0, 0x1

    iput-boolean v0, p0, Lorg/json/JSONTokener;->usePrevious:Z

    .line 100
    const/4 v0, 0x0

    iput-boolean v0, p0, Lorg/json/JSONTokener;->eof:Z

    .line 101
    return-void
.end method

.method public end()Z
    .locals 1

    .prologue
    .line 124
    iget-boolean v0, p0, Lorg/json/JSONTokener;->eof:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lorg/json/JSONTokener;->usePrevious:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public more()Z
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 134
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    .line 135
    invoke-virtual {p0}, Lorg/json/JSONTokener;->end()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 136
    const/4 v0, 0x0

    .line 139
    :goto_0
    return v0

    .line 138
    :cond_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 139
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public next()C
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const-wide/16 v2, 0x0

    const/16 v8, 0xa

    const-wide/16 v4, 0x1

    .line 150
    iget-boolean v6, p0, Lorg/json/JSONTokener;->usePrevious:Z

    if-eqz v6, :cond_1

    .line 151
    const/4 v6, 0x0

    iput-boolean v6, p0, Lorg/json/JSONTokener;->usePrevious:Z

    .line 152
    iget-char v0, p0, Lorg/json/JSONTokener;->previous:C

    .line 165
    .local v0, "c":I
    :cond_0
    :goto_0
    iget-wide v6, p0, Lorg/json/JSONTokener;->index:J

    add-long/2addr v6, v4

    iput-wide v6, p0, Lorg/json/JSONTokener;->index:J

    .line 166
    iget-char v6, p0, Lorg/json/JSONTokener;->previous:C

    const/16 v7, 0xd

    if-ne v6, v7, :cond_3

    .line 167
    iget-wide v6, p0, Lorg/json/JSONTokener;->line:J

    add-long/2addr v6, v4

    iput-wide v6, p0, Lorg/json/JSONTokener;->line:J

    .line 168
    if-ne v0, v8, :cond_2

    :goto_1
    iput-wide v2, p0, Lorg/json/JSONTokener;->character:J

    .line 175
    :goto_2
    int-to-char v2, v0

    iput-char v2, p0, Lorg/json/JSONTokener;->previous:C

    .line 176
    iget-char v2, p0, Lorg/json/JSONTokener;->previous:C

    return v2

    .line 155
    .end local v0    # "c":I
    :cond_1
    :try_start_0
    iget-object v6, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    invoke-virtual {v6}, Ljava/io/Reader;->read()I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 160
    .restart local v0    # "c":I
    if-gtz v0, :cond_0

    .line 161
    const/4 v6, 0x1

    iput-boolean v6, p0, Lorg/json/JSONTokener;->eof:Z

    .line 162
    const/4 v0, 0x0

    goto :goto_0

    .line 156
    .end local v0    # "c":I
    :catch_0
    move-exception v1

    .line 157
    .local v1, "exception":Ljava/io/IOException;
    new-instance v2, Lorg/json/JSONException;

    invoke-direct {v2, v1}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v2

    .end local v1    # "exception":Ljava/io/IOException;
    .restart local v0    # "c":I
    :cond_2
    move-wide v2, v4

    .line 168
    goto :goto_1

    .line 169
    :cond_3
    if-ne v0, v8, :cond_4

    .line 170
    iget-wide v6, p0, Lorg/json/JSONTokener;->line:J

    add-long/2addr v4, v6

    iput-wide v4, p0, Lorg/json/JSONTokener;->line:J

    .line 171
    iput-wide v2, p0, Lorg/json/JSONTokener;->character:J

    goto :goto_2

    .line 173
    :cond_4
    iget-wide v2, p0, Lorg/json/JSONTokener;->character:J

    add-long/2addr v2, v4

    iput-wide v2, p0, Lorg/json/JSONTokener;->character:J

    goto :goto_2
.end method

.method public next(C)C
    .locals 3
    .param p1, "c"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 188
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    .line 189
    .local v0, "n":C
    if-eq v0, p1, :cond_0

    .line 190
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    const-string v2, "Expected \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, "\' and instead saw \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v1

    throw v1

    .line 193
    :cond_0
    return v0
.end method

.method public next(I)Ljava/lang/String;
    .locals 3
    .param p1, "n"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 207
    if-nez p1, :cond_0

    .line 208
    const-string v2, ""

    .line 221
    :goto_0
    return-object v2

    .line 211
    :cond_0
    new-array v0, p1, [C

    .line 212
    .local v0, "chars":[C
    const/4 v1, 0x0

    .line 214
    .local v1, "pos":I
    :goto_1
    if-ge v1, p1, :cond_2

    .line 215
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v2

    aput-char v2, v0, v1

    .line 216
    invoke-virtual {p0}, Lorg/json/JSONTokener;->end()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 217
    const-string v2, "Substring bounds error"

    invoke-virtual {p0, v2}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 219
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 221
    :cond_2
    new-instance v2, Ljava/lang/String;

    invoke-direct {v2, v0}, Ljava/lang/String;-><init>([C)V

    goto :goto_0
.end method

.method public nextClean()C
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 232
    :cond_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    .line 233
    .local v0, "c":C
    if-eqz v0, :cond_1

    const/16 v1, 0x20

    if-le v0, v1, :cond_0

    .line 234
    :cond_1
    return v0
.end method

.method public nextString(C)Ljava/lang/String;
    .locals 4
    .param p1, "quote"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 253
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 255
    .local v1, "sb":Ljava/lang/StringBuffer;
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    .line 256
    .local v0, "c":C
    sparse-switch v0, :sswitch_data_0

    .line 293
    if-ne v0, p1, :cond_0

    .line 294
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 260
    :sswitch_0
    const-string v2, "Unterminated string"

    invoke-virtual {p0, v2}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 262
    :sswitch_1
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    .line 263
    sparse-switch v0, :sswitch_data_1

    .line 289
    const-string v2, "Illegal escape."

    invoke-virtual {p0, v2}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v2

    throw v2

    .line 265
    :sswitch_2
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 268
    :sswitch_3
    const/16 v2, 0x9

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 271
    :sswitch_4
    const/16 v2, 0xa

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 274
    :sswitch_5
    const/16 v2, 0xc

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 277
    :sswitch_6
    const/16 v2, 0xd

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 280
    :sswitch_7
    const/4 v2, 0x4

    invoke-virtual {p0, v2}, Lorg/json/JSONTokener;->next(I)Ljava/lang/String;

    move-result-object v2

    const/16 v3, 0x10

    invoke-static {v2, v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v2

    int-to-char v2, v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 286
    :sswitch_8
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 296
    :cond_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 256
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0xa -> :sswitch_0
        0xd -> :sswitch_0
        0x5c -> :sswitch_1
    .end sparse-switch

    .line 263
    :sswitch_data_1
    .sparse-switch
        0x22 -> :sswitch_8
        0x27 -> :sswitch_8
        0x2f -> :sswitch_8
        0x5c -> :sswitch_8
        0x62 -> :sswitch_2
        0x66 -> :sswitch_5
        0x6e -> :sswitch_4
        0x72 -> :sswitch_6
        0x74 -> :sswitch_3
        0x75 -> :sswitch_7
    .end sparse-switch
.end method

.method public nextTo(C)Ljava/lang/String;
    .locals 3
    .param p1, "delimiter"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 309
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 311
    .local v1, "sb":Ljava/lang/StringBuffer;
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    .line 312
    .local v0, "c":C
    if-eq v0, p1, :cond_0

    if-eqz v0, :cond_0

    const/16 v2, 0xa

    if-eq v0, v2, :cond_0

    const/16 v2, 0xd

    if-ne v0, v2, :cond_2

    .line 313
    :cond_0
    if-eqz v0, :cond_1

    .line 314
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 316
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 318
    :cond_2
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public nextTo(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "delimiters"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 331
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 333
    .local v1, "sb":Ljava/lang/StringBuffer;
    :goto_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    .line 334
    .local v0, "c":C
    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    if-gez v2, :cond_0

    if-eqz v0, :cond_0

    const/16 v2, 0xa

    if-eq v0, v2, :cond_0

    const/16 v2, 0xd

    if-ne v0, v2, :cond_2

    .line 336
    :cond_0
    if-eqz v0, :cond_1

    .line 337
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 339
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 341
    :cond_2
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public nextValue()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 354
    invoke-virtual {p0}, Lorg/json/JSONTokener;->nextClean()C

    move-result v0

    .line 357
    .local v0, "c":C
    sparse-switch v0, :sswitch_data_0

    .line 378
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 379
    .local v1, "sb":Ljava/lang/StringBuffer;
    :goto_0
    const/16 v3, 0x20

    if-lt v0, v3, :cond_0

    const-string v3, ",:]}/\\\"[{;=#"

    invoke-virtual {v3, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    if-gez v3, :cond_0

    .line 380
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 381
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    goto :goto_0

    .line 360
    .end local v1    # "sb":Ljava/lang/StringBuffer;
    :sswitch_0
    invoke-virtual {p0, v0}, Lorg/json/JSONTokener;->nextString(C)Ljava/lang/String;

    move-result-object v3

    .line 389
    :goto_1
    return-object v3

    .line 362
    :sswitch_1
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 363
    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, p0}, Lorg/json/JSONObject;-><init>(Lorg/json/JSONTokener;)V

    goto :goto_1

    .line 365
    :sswitch_2
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 366
    new-instance v3, Lorg/json/JSONArray;

    invoke-direct {v3, p0}, Lorg/json/JSONArray;-><init>(Lorg/json/JSONTokener;)V

    goto :goto_1

    .line 383
    .restart local v1    # "sb":Ljava/lang/StringBuffer;
    :cond_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    .line 385
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 386
    .local v2, "string":Ljava/lang/String;
    const-string v3, ""

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 387
    const-string v3, "Missing value"

    invoke-virtual {p0, v3}, Lorg/json/JSONTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v3

    throw v3

    .line 389
    :cond_1
    invoke-static {v2}, Lorg/json/JSONObject;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    goto :goto_1

    .line 357
    :sswitch_data_0
    .sparse-switch
        0x22 -> :sswitch_0
        0x27 -> :sswitch_0
        0x5b -> :sswitch_2
        0x7b -> :sswitch_1
    .end sparse-switch
.end method

.method public skipTo(C)C
    .locals 10
    .param p1, "to"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 403
    :try_start_0
    iget-wide v4, p0, Lorg/json/JSONTokener;->index:J

    .line 404
    .local v4, "startIndex":J
    iget-wide v2, p0, Lorg/json/JSONTokener;->character:J

    .line 405
    .local v2, "startCharacter":J
    iget-wide v6, p0, Lorg/json/JSONTokener;->line:J

    .line 406
    .local v6, "startLine":J
    iget-object v8, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    const v9, 0xf4240

    invoke-virtual {v8, v9}, Ljava/io/Reader;->mark(I)V

    .line 408
    :cond_0
    invoke-virtual {p0}, Lorg/json/JSONTokener;->next()C

    move-result v0

    .line 409
    .local v0, "c":C
    if-nez v0, :cond_1

    .line 410
    iget-object v8, p0, Lorg/json/JSONTokener;->reader:Ljava/io/Reader;

    invoke-virtual {v8}, Ljava/io/Reader;->reset()V

    .line 411
    iput-wide v4, p0, Lorg/json/JSONTokener;->index:J

    .line 412
    iput-wide v2, p0, Lorg/json/JSONTokener;->character:J

    .line 413
    iput-wide v6, p0, Lorg/json/JSONTokener;->line:J
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 422
    :goto_0
    return v0

    .line 416
    :cond_1
    if-ne v0, p1, :cond_0

    .line 421
    invoke-virtual {p0}, Lorg/json/JSONTokener;->back()V

    goto :goto_0

    .line 417
    .end local v0    # "c":C
    .end local v2    # "startCharacter":J
    .end local v4    # "startIndex":J
    .end local v6    # "startLine":J
    :catch_0
    move-exception v1

    .line 418
    .local v1, "exc":Ljava/io/IOException;
    new-instance v8, Lorg/json/JSONException;

    invoke-direct {v8, v1}, Lorg/json/JSONException;-><init>(Ljava/lang/Throwable;)V

    throw v8
.end method

.method public syntaxError(Ljava/lang/String;)Lorg/json/JSONException;
    .locals 3
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 433
    new-instance v0, Lorg/json/JSONException;

    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {p0}, Lorg/json/JSONTokener;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 443
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, " at "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    iget-wide v1, p0, Lorg/json/JSONTokener;->index:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " [character "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    iget-wide v1, p0, Lorg/json/JSONTokener;->character:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " line "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    iget-wide v1, p0, Lorg/json/JSONTokener;->line:J

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
