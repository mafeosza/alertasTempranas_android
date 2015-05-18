.class abstract Lorg/json/zip/Keep;
.super Ljava/lang/Object;
.source "Keep.java"

# interfaces
.implements Lorg/json/zip/None;
.implements Lorg/json/zip/PostMortem;


# instance fields
.field protected capacity:I

.field protected length:I

.field protected power:I

.field protected uses:[J


# direct methods
.method public constructor <init>(I)V
    .locals 2
    .param p1, "bits"    # I

    .prologue
    const/4 v1, 0x0

    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    sget-object v0, Lorg/json/zip/JSONzip;->twos:[I

    aget v0, v0, p1

    iput v0, p0, Lorg/json/zip/Keep;->capacity:I

    .line 43
    iput v1, p0, Lorg/json/zip/Keep;->length:I

    .line 44
    iput v1, p0, Lorg/json/zip/Keep;->power:I

    .line 45
    iget v0, p0, Lorg/json/zip/Keep;->capacity:I

    new-array v0, v0, [J

    iput-object v0, p0, Lorg/json/zip/Keep;->uses:[J

    .line 46
    return-void
.end method

.method public static age(J)J
    .locals 2
    .param p0, "use"    # J

    .prologue
    .line 56
    const-wide/16 v0, 0x20

    cmp-long v0, p0, v0

    if-ltz v0, :cond_0

    const-wide/16 v0, 0x10

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x2

    div-long v0, p0, v0

    goto :goto_0
.end method


# virtual methods
.method public bitsize()I
    .locals 2

    .prologue
    .line 65
    :goto_0
    sget-object v0, Lorg/json/zip/JSONzip;->twos:[I

    iget v1, p0, Lorg/json/zip/Keep;->power:I

    aget v0, v0, v1

    iget v1, p0, Lorg/json/zip/Keep;->length:I

    if-ge v0, v1, :cond_0

    .line 66
    iget v0, p0, Lorg/json/zip/Keep;->power:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lorg/json/zip/Keep;->power:I

    goto :goto_0

    .line 68
    :cond_0
    iget v0, p0, Lorg/json/zip/Keep;->power:I

    return v0
.end method

.method public tick(I)V
    .locals 5
    .param p1, "integer"    # I

    .prologue
    .line 75
    iget-object v0, p0, Lorg/json/zip/Keep;->uses:[J

    aget-wide v1, v0, p1

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    aput-wide v1, v0, p1

    .line 76
    return-void
.end method

.method public abstract value(I)Ljava/lang/Object;
.end method
