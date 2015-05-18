.class Lorg/json/zip/Huff$Symbol;
.super Ljava/lang/Object;
.source "Huff.java"

# interfaces
.implements Lorg/json/zip/PostMortem;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/json/zip/Huff;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "Symbol"
.end annotation


# instance fields
.field public back:Lorg/json/zip/Huff$Symbol;

.field public final integer:I

.field public next:Lorg/json/zip/Huff$Symbol;

.field public one:Lorg/json/zip/Huff$Symbol;

.field public weight:J

.field public zero:Lorg/json/zip/Huff$Symbol;


# direct methods
.method public constructor <init>(I)V
    .locals 3
    .param p1, "integer"    # I

    .prologue
    const/4 v2, 0x0

    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    iput p1, p0, Lorg/json/zip/Huff$Symbol;->integer:I

    .line 89
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lorg/json/zip/Huff$Symbol;->weight:J

    .line 90
    iput-object v2, p0, Lorg/json/zip/Huff$Symbol;->next:Lorg/json/zip/Huff$Symbol;

    .line 91
    iput-object v2, p0, Lorg/json/zip/Huff$Symbol;->back:Lorg/json/zip/Huff$Symbol;

    .line 92
    iput-object v2, p0, Lorg/json/zip/Huff$Symbol;->one:Lorg/json/zip/Huff$Symbol;

    .line 93
    iput-object v2, p0, Lorg/json/zip/Huff$Symbol;->zero:Lorg/json/zip/Huff$Symbol;

    .line 94
    return-void
.end method


# virtual methods
.method public postMortem(Lorg/json/zip/PostMortem;)Z
    .locals 11
    .param p1, "pm"    # Lorg/json/zip/PostMortem;

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 97
    const/4 v1, 0x1

    .local v1, "result":Z
    move-object v2, p1

    .line 98
    check-cast v2, Lorg/json/zip/Huff$Symbol;

    .line 100
    .local v2, "that":Lorg/json/zip/Huff$Symbol;
    iget v4, p0, Lorg/json/zip/Huff$Symbol;->integer:I

    iget v7, v2, Lorg/json/zip/Huff$Symbol;->integer:I

    if-ne v4, v7, :cond_0

    iget-wide v7, p0, Lorg/json/zip/Huff$Symbol;->weight:J

    iget-wide v9, v2, Lorg/json/zip/Huff$Symbol;->weight:J

    cmp-long v4, v7, v9

    if-eqz v4, :cond_1

    .line 122
    :cond_0
    :goto_0
    return v6

    .line 103
    :cond_1
    iget-object v4, p0, Lorg/json/zip/Huff$Symbol;->back:Lorg/json/zip/Huff$Symbol;

    if-eqz v4, :cond_2

    move v4, v5

    :goto_1
    iget-object v7, v2, Lorg/json/zip/Huff$Symbol;->back:Lorg/json/zip/Huff$Symbol;

    if-eqz v7, :cond_3

    :goto_2
    if-ne v4, v5, :cond_0

    .line 106
    iget-object v3, p0, Lorg/json/zip/Huff$Symbol;->zero:Lorg/json/zip/Huff$Symbol;

    .line 107
    .local v3, "zero":Lorg/json/zip/Huff$Symbol;
    iget-object v0, p0, Lorg/json/zip/Huff$Symbol;->one:Lorg/json/zip/Huff$Symbol;

    .line 108
    .local v0, "one":Lorg/json/zip/Huff$Symbol;
    if-nez v3, :cond_4

    .line 109
    iget-object v4, v2, Lorg/json/zip/Huff$Symbol;->zero:Lorg/json/zip/Huff$Symbol;

    if-nez v4, :cond_0

    .line 115
    :goto_3
    if-nez v0, :cond_5

    .line 116
    iget-object v4, v2, Lorg/json/zip/Huff$Symbol;->one:Lorg/json/zip/Huff$Symbol;

    if-nez v4, :cond_0

    :goto_4
    move v6, v1

    .line 122
    goto :goto_0

    .end local v0    # "one":Lorg/json/zip/Huff$Symbol;
    .end local v3    # "zero":Lorg/json/zip/Huff$Symbol;
    :cond_2
    move v4, v6

    .line 103
    goto :goto_1

    :cond_3
    move v5, v6

    goto :goto_2

    .line 113
    .restart local v0    # "one":Lorg/json/zip/Huff$Symbol;
    .restart local v3    # "zero":Lorg/json/zip/Huff$Symbol;
    :cond_4
    iget-object v4, v2, Lorg/json/zip/Huff$Symbol;->zero:Lorg/json/zip/Huff$Symbol;

    invoke-virtual {v3, v4}, Lorg/json/zip/Huff$Symbol;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v1

    goto :goto_3

    .line 120
    :cond_5
    iget-object v4, v2, Lorg/json/zip/Huff$Symbol;->one:Lorg/json/zip/Huff$Symbol;

    invoke-virtual {v0, v4}, Lorg/json/zip/Huff$Symbol;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v1

    goto :goto_4
.end method
