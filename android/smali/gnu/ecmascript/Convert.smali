.class public Lgnu/ecmascript/Convert;
.super Ljava/lang/Object;
.source "Convert.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static toInteger(D)D
    .locals 3
    .param p0, "x"    # D

    .prologue
    const-wide/16 v0, 0x0

    .line 31
    invoke-static {p0, p1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 33
    :goto_0
    return-wide v0

    :cond_0
    cmpg-double v0, p0, v0

    if-gez v0, :cond_1

    invoke-static {p0, p1}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v0

    goto :goto_0

    :cond_1
    invoke-static {p0, p1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    goto :goto_0
.end method

.method public static toInteger(Ljava/lang/Object;)D
    .locals 2
    .param p0, "x"    # Ljava/lang/Object;

    .prologue
    .line 38
    invoke-static {p0}, Lgnu/ecmascript/Convert;->toNumber(Ljava/lang/Object;)D

    move-result-wide v0

    invoke-static {v0, v1}, Lgnu/ecmascript/Convert;->toInteger(D)D

    move-result-wide v0

    return-wide v0
.end method

.method public static toNumber(Ljava/lang/Object;)D
    .locals 4
    .param p0, "x"    # Ljava/lang/Object;

    .prologue
    const-wide/high16 v1, 0x7ff8000000000000L    # NaN

    .line 7
    instance-of v3, p0, Ljava/lang/Number;

    if-eqz v3, :cond_1

    .line 8
    check-cast p0, Ljava/lang/Number;

    .end local p0    # "x":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v1

    .line 26
    .local v0, "ex":Ljava/lang/NumberFormatException;
    :cond_0
    :goto_0
    return-wide v1

    .line 11
    .end local v0    # "ex":Ljava/lang/NumberFormatException;
    .restart local p0    # "x":Ljava/lang/Object;
    :cond_1
    instance-of v3, p0, Ljava/lang/Boolean;

    if-eqz v3, :cond_3

    .line 12
    check-cast p0, Ljava/lang/Boolean;

    .end local p0    # "x":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_2

    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    goto :goto_0

    :cond_2
    const-wide/16 v1, 0x0

    goto :goto_0

    .line 13
    .restart local p0    # "x":Ljava/lang/Object;
    :cond_3
    instance-of v3, p0, Ljava/lang/String;

    if-eqz v3, :cond_0

    .line 18
    :try_start_0
    check-cast p0, Ljava/lang/String;

    .end local p0    # "x":Ljava/lang/Object;
    invoke-static {p0}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Double;->doubleValue()D
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v1

    goto :goto_0

    .line 20
    :catch_0
    move-exception v0

    .line 22
    .restart local v0    # "ex":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method


# virtual methods
.method public toInt32(D)I
    .locals 1
    .param p1, "x"    # D

    .prologue
    .line 43
    invoke-static {p1, p2}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1, p2}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 44
    :cond_0
    const/4 v0, 0x0

    .line 46
    :goto_0
    return v0

    :cond_1
    double-to-int v0, p1

    goto :goto_0
.end method

.method public toInt32(Ljava/lang/Object;)I
    .locals 2
    .param p1, "x"    # Ljava/lang/Object;

    .prologue
    .line 51
    invoke-static {p1}, Lgnu/ecmascript/Convert;->toNumber(Ljava/lang/Object;)D

    move-result-wide v0

    invoke-virtual {p0, v0, v1}, Lgnu/ecmascript/Convert;->toInt32(D)I

    move-result v0

    return v0
.end method
