.class public Lcom/google/appinventor/components/runtime/util/OrientationSensorUtil;
.super Ljava/lang/Object;
.source "OrientationSensorUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    return-void
.end method

.method static mod(FF)F
    .locals 3
    .param p0, "dividend"    # F
    .param p1, "quotient"    # F

    .prologue
    .line 33
    rem-float v0, p0, p1

    .line 34
    .local v0, "result":F
    const/4 v1, 0x0

    cmpl-float v1, v0, v1

    if-eqz v1, :cond_0

    invoke-static {p0}, Ljava/lang/Math;->signum(F)F

    move-result v1

    invoke-static {p1}, Ljava/lang/Math;->signum(F)F

    move-result v2

    cmpl-float v1, v1, v2

    if-nez v1, :cond_1

    .line 37
    .end local v0    # "result":F
    :cond_0
    :goto_0
    return v0

    .restart local v0    # "result":F
    :cond_1
    add-float/2addr v0, p1

    goto :goto_0
.end method

.method public static normalizeAzimuth(F)F
    .locals 1
    .param p0, "azimuth"    # F

    .prologue
    .line 48
    const/high16 v0, 0x43b40000    # 360.0f

    invoke-static {p0, v0}, Lcom/google/appinventor/components/runtime/util/OrientationSensorUtil;->mod(FF)F

    move-result v0

    return v0
.end method

.method public static normalizePitch(F)F
    .locals 3
    .param p0, "pitch"    # F

    .prologue
    const/high16 v2, 0x43340000    # 180.0f

    .line 58
    add-float v0, p0, v2

    const/high16 v1, 0x43b40000    # 360.0f

    invoke-static {v0, v1}, Lcom/google/appinventor/components/runtime/util/OrientationSensorUtil;->mod(FF)F

    move-result v0

    sub-float/2addr v0, v2

    return v0
.end method

.method public static normalizeRoll(F)F
    .locals 2
    .param p0, "roll"    # F

    .prologue
    const/high16 v1, 0x43340000    # 180.0f

    .line 82
    invoke-static {p0, v1}, Ljava/lang/Math;->min(FF)F

    move-result p0

    .line 83
    const/high16 v0, -0x3ccc0000    # -180.0f

    invoke-static {p0, v0}, Ljava/lang/Math;->max(FF)F

    move-result p0

    .line 86
    const/high16 v0, -0x3d4c0000    # -90.0f

    cmpl-float v0, p0, v0

    if-ltz v0, :cond_1

    const/high16 v0, 0x42b40000    # 90.0f

    cmpg-float v0, p0, v0

    if-gtz v0, :cond_1

    .line 97
    :cond_0
    :goto_0
    return p0

    .line 91
    :cond_1
    sub-float p0, v1, p0

    .line 94
    const/high16 v0, 0x43870000    # 270.0f

    cmpl-float v0, p0, v0

    if-ltz v0, :cond_0

    .line 95
    const/high16 v0, 0x43b40000    # 360.0f

    sub-float/2addr p0, v0

    goto :goto_0
.end method
