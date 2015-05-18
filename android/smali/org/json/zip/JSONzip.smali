.class public abstract Lorg/json/zip/JSONzip;
.super Ljava/lang/Object;
.source "JSONzip.java"

# interfaces
.implements Lorg/json/zip/None;
.implements Lorg/json/zip/PostMortem;


# static fields
.field public static final bcd:[B

.field public static final end:I = 0x100

.field public static final endOfNumber:I

.field public static final int14:J = 0x4000L

.field public static final int4:J = 0x10L

.field public static final int7:J = 0x80L

.field public static final maxSubstringLength:I = 0xa

.field public static final minSubstringLength:I = 0x3

.field public static final probe:Z = false

.field public static final substringLimit:I = 0x28

.field public static final twos:[I

.field public static final zipArrayString:I = 0x6

.field public static final zipArrayValue:I = 0x7

.field public static final zipEmptyArray:I = 0x1

.field public static final zipEmptyObject:I = 0x0

.field public static final zipFalse:I = 0x3

.field public static final zipNull:I = 0x4

.field public static final zipObject:I = 0x5

.field public static final zipTrue:I = 0x2


# instance fields
.field protected final namehuff:Lorg/json/zip/Huff;

.field protected final namekeep:Lorg/json/zip/MapKeep;

.field protected final stringkeep:Lorg/json/zip/MapKeep;

.field protected final substringhuff:Lorg/json/zip/Huff;

.field protected final substringkeep:Lorg/json/zip/TrieKeep;

.field protected final values:Lorg/json/zip/MapKeep;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    const/16 v0, 0x11

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lorg/json/zip/JSONzip;->twos:[I

    .line 60
    const/16 v0, 0xe

    new-array v0, v0, [B

    fill-array-data v0, :array_1

    sput-object v0, Lorg/json/zip/JSONzip;->bcd:[B

    .line 87
    sget-object v0, Lorg/json/zip/JSONzip;->bcd:[B

    array-length v0, v0

    sput v0, Lorg/json/zip/JSONzip;->endOfNumber:I

    return-void

    .line 52
    :array_0
    .array-data 4
        0x1
        0x2
        0x4
        0x8
        0x10
        0x20
        0x40
        0x80
        0x100
        0x200
        0x400
        0x800
        0x1000
        0x2000
        0x4000
        0x8000
        0x10000
    .end array-data

    .line 60
    :array_1
    .array-data 1
        0x30t
        0x31t
        0x32t
        0x33t
        0x34t
        0x35t
        0x36t
        0x37t
        0x38t
        0x39t
        0x2et
        0x2dt
        0x2bt
        0x45t
    .end array-data
.end method

.method protected constructor <init>()V
    .locals 7

    .prologue
    const/16 v6, 0x7d

    const/16 v5, 0x7a

    const/16 v4, 0x61

    const/16 v3, 0x20

    const/16 v2, 0x100

    .line 184
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 185
    new-instance v0, Lorg/json/zip/Huff;

    const/16 v1, 0x101

    invoke-direct {v0, v1}, Lorg/json/zip/Huff;-><init>(I)V

    iput-object v0, p0, Lorg/json/zip/JSONzip;->namehuff:Lorg/json/zip/Huff;

    .line 186
    new-instance v0, Lorg/json/zip/MapKeep;

    const/16 v1, 0x9

    invoke-direct {v0, v1}, Lorg/json/zip/MapKeep;-><init>(I)V

    iput-object v0, p0, Lorg/json/zip/JSONzip;->namekeep:Lorg/json/zip/MapKeep;

    .line 187
    new-instance v0, Lorg/json/zip/MapKeep;

    const/16 v1, 0xb

    invoke-direct {v0, v1}, Lorg/json/zip/MapKeep;-><init>(I)V

    iput-object v0, p0, Lorg/json/zip/JSONzip;->stringkeep:Lorg/json/zip/MapKeep;

    .line 188
    new-instance v0, Lorg/json/zip/Huff;

    const/16 v1, 0x101

    invoke-direct {v0, v1}, Lorg/json/zip/Huff;-><init>(I)V

    iput-object v0, p0, Lorg/json/zip/JSONzip;->substringhuff:Lorg/json/zip/Huff;

    .line 189
    new-instance v0, Lorg/json/zip/TrieKeep;

    const/16 v1, 0xc

    invoke-direct {v0, v1}, Lorg/json/zip/TrieKeep;-><init>(I)V

    iput-object v0, p0, Lorg/json/zip/JSONzip;->substringkeep:Lorg/json/zip/TrieKeep;

    .line 190
    new-instance v0, Lorg/json/zip/MapKeep;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Lorg/json/zip/MapKeep;-><init>(I)V

    iput-object v0, p0, Lorg/json/zip/JSONzip;->values:Lorg/json/zip/MapKeep;

    .line 197
    iget-object v0, p0, Lorg/json/zip/JSONzip;->namehuff:Lorg/json/zip/Huff;

    invoke-virtual {v0, v3, v6}, Lorg/json/zip/Huff;->tick(II)V

    .line 198
    iget-object v0, p0, Lorg/json/zip/JSONzip;->namehuff:Lorg/json/zip/Huff;

    invoke-virtual {v0, v4, v5}, Lorg/json/zip/Huff;->tick(II)V

    .line 199
    iget-object v0, p0, Lorg/json/zip/JSONzip;->namehuff:Lorg/json/zip/Huff;

    invoke-virtual {v0, v2}, Lorg/json/zip/Huff;->tick(I)V

    .line 200
    iget-object v0, p0, Lorg/json/zip/JSONzip;->namehuff:Lorg/json/zip/Huff;

    invoke-virtual {v0, v2}, Lorg/json/zip/Huff;->tick(I)V

    .line 201
    iget-object v0, p0, Lorg/json/zip/JSONzip;->substringhuff:Lorg/json/zip/Huff;

    invoke-virtual {v0, v3, v6}, Lorg/json/zip/Huff;->tick(II)V

    .line 202
    iget-object v0, p0, Lorg/json/zip/JSONzip;->substringhuff:Lorg/json/zip/Huff;

    invoke-virtual {v0, v4, v5}, Lorg/json/zip/Huff;->tick(II)V

    .line 203
    iget-object v0, p0, Lorg/json/zip/JSONzip;->substringhuff:Lorg/json/zip/Huff;

    invoke-virtual {v0, v2}, Lorg/json/zip/Huff;->tick(I)V

    .line 204
    iget-object v0, p0, Lorg/json/zip/JSONzip;->substringhuff:Lorg/json/zip/Huff;

    invoke-virtual {v0, v2}, Lorg/json/zip/Huff;->tick(I)V

    .line 205
    return-void
.end method

.method static log()V
    .locals 1

    .prologue
    .line 219
    const-string v0, "\n"

    invoke-static {v0}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    .line 220
    return-void
.end method

.method static log(I)V
    .locals 2
    .param p0, "integer"    # I

    .prologue
    .line 228
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    .line 229
    return-void
.end method

.method static log(II)V
    .locals 2
    .param p0, "integer"    # I
    .param p1, "width"    # I

    .prologue
    .line 238
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    .line 239
    return-void
.end method

.method static log(Ljava/lang/String;)V
    .locals 1
    .param p0, "string"    # Ljava/lang/String;

    .prologue
    .line 247
    sget-object v0, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v0, p0}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 248
    return-void
.end method

.method static logchar(II)V
    .locals 2
    .param p0, "integer"    # I
    .param p1, "width"    # I

    .prologue
    .line 257
    const/16 v0, 0x20

    if-le p0, v0, :cond_0

    const/16 v0, 0x7d

    if-gt p0, v0, :cond_0

    .line 258
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    const-string v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    int-to-char v1, p0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, "\':"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    .line 262
    :goto_0
    return-void

    .line 260
    :cond_0
    invoke-static {p0, p1}, Lorg/json/zip/JSONzip;->log(II)V

    goto :goto_0
.end method


# virtual methods
.method protected begin()V
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lorg/json/zip/JSONzip;->namehuff:Lorg/json/zip/Huff;

    invoke-virtual {v0}, Lorg/json/zip/Huff;->generate()V

    .line 212
    iget-object v0, p0, Lorg/json/zip/JSONzip;->substringhuff:Lorg/json/zip/Huff;

    invoke-virtual {v0}, Lorg/json/zip/Huff;->generate()V

    .line 213
    return-void
.end method

.method public postMortem(Lorg/json/zip/PostMortem;)Z
    .locals 3
    .param p1, "pm"    # Lorg/json/zip/PostMortem;

    .prologue
    .line 273
    move-object v0, p1

    check-cast v0, Lorg/json/zip/JSONzip;

    .line 274
    .local v0, "that":Lorg/json/zip/JSONzip;
    iget-object v1, p0, Lorg/json/zip/JSONzip;->namehuff:Lorg/json/zip/Huff;

    iget-object v2, v0, Lorg/json/zip/JSONzip;->namehuff:Lorg/json/zip/Huff;

    invoke-virtual {v1, v2}, Lorg/json/zip/Huff;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lorg/json/zip/JSONzip;->namekeep:Lorg/json/zip/MapKeep;

    iget-object v2, v0, Lorg/json/zip/JSONzip;->namekeep:Lorg/json/zip/MapKeep;

    invoke-virtual {v1, v2}, Lorg/json/zip/MapKeep;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lorg/json/zip/JSONzip;->stringkeep:Lorg/json/zip/MapKeep;

    iget-object v2, v0, Lorg/json/zip/JSONzip;->stringkeep:Lorg/json/zip/MapKeep;

    invoke-virtual {v1, v2}, Lorg/json/zip/MapKeep;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lorg/json/zip/JSONzip;->substringhuff:Lorg/json/zip/Huff;

    iget-object v2, v0, Lorg/json/zip/JSONzip;->substringhuff:Lorg/json/zip/Huff;

    invoke-virtual {v1, v2}, Lorg/json/zip/Huff;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lorg/json/zip/JSONzip;->substringkeep:Lorg/json/zip/TrieKeep;

    iget-object v2, v0, Lorg/json/zip/JSONzip;->substringkeep:Lorg/json/zip/TrieKeep;

    invoke-virtual {v1, v2}, Lorg/json/zip/TrieKeep;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lorg/json/zip/JSONzip;->values:Lorg/json/zip/MapKeep;

    iget-object v2, v0, Lorg/json/zip/JSONzip;->values:Lorg/json/zip/MapKeep;

    invoke-virtual {v1, v2}, Lorg/json/zip/MapKeep;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method
