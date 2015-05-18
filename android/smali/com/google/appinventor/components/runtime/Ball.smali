.class public final Lcom/google/appinventor/components/runtime/Ball;
.super Lcom/google/appinventor/components/runtime/Sprite;
.source "Ball.java"


# annotations
.annotation runtime Lcom/google/appinventor/components/annotations/DesignerComponent;
    category = .enum Lcom/google/appinventor/components/common/ComponentCategory;->ANIMATION:Lcom/google/appinventor/components/common/ComponentCategory;
    description = "<p>A round \'sprite\' that can be placed on a <code>Canvas</code>, where it can react to touches and drags, interact with other sprites (<code>ImageSprite</code>s and other <code>Ball</code>s) and the edge of the Canvas, and move according to its property values.</p><p>For example, to have a <code>Ball</code> move 4 pixels toward the top of a <code>Canvas</code> every 500 milliseconds (half second), you would set the <code>Speed</code> property to 4 [pixels], the <code>Interval</code> property to 500 [milliseconds], the <code>Heading</code> property to 90 [degrees], and the <code>Enabled</code> property to <code>True</code>.  These and its other properties can be changed at any time.</p><p>The difference between a Ball and an <code>ImageSprite</code> is that the latter can get its appearance from an image file, while a Ball\'s appearance can only be changed by varying its <code>PaintColor</code> and <code>Radius</code> properties.</p>"
    version = 0x5
.end annotation

.annotation runtime Lcom/google/appinventor/components/annotations/SimpleObject;
.end annotation


# static fields
.field static final DEFAULT_RADIUS:I = 0x5


# instance fields
.field private paint:Landroid/graphics/Paint;

.field private paintColor:I

.field private radius:I


# direct methods
.method public constructor <init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V
    .locals 1
    .param p1, "container"    # Lcom/google/appinventor/components/runtime/ComponentContainer;

    .prologue
    .line 52
    invoke-direct {p0, p1}, Lcom/google/appinventor/components/runtime/Sprite;-><init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V

    .line 53
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/Ball;->paint:Landroid/graphics/Paint;

    .line 56
    const/high16 v0, -0x1000000

    invoke-virtual {p0, v0}, Lcom/google/appinventor/components/runtime/Ball;->PaintColor(I)V

    .line 57
    const/4 v0, 0x5

    invoke-virtual {p0, v0}, Lcom/google/appinventor/components/runtime/Ball;->Radius(I)V

    .line 58
    return-void
.end method


# virtual methods
.method public Height()I
    .locals 1

    .prologue
    .line 74
    iget v0, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    mul-int/lit8 v0, v0, 0x2

    return v0
.end method

.method public Height(I)V
    .locals 0
    .param p1, "height"    # I

    .prologue
    .line 80
    return-void
.end method

.method public PaintColor()I
    .locals 1
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        category = .enum Lcom/google/appinventor/components/annotations/PropertyCategory;->APPEARANCE:Lcom/google/appinventor/components/annotations/PropertyCategory;
    .end annotation

    .prologue
    .line 126
    iget v0, p0, Lcom/google/appinventor/components/runtime/Ball;->paintColor:I

    return v0
.end method

.method public PaintColor(I)V
    .locals 2
    .param p1, "argb"    # I
    .annotation runtime Lcom/google/appinventor/components/annotations/DesignerProperty;
        defaultValue = "&HFF000000"
        editorType = "color"
    .end annotation

    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
    .end annotation

    .prologue
    .line 138
    iput p1, p0, Lcom/google/appinventor/components/runtime/Ball;->paintColor:I

    .line 139
    if-eqz p1, :cond_0

    .line 140
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Ball;->paint:Landroid/graphics/Paint;

    invoke-static {v0, p1}, Lcom/google/appinventor/components/runtime/util/PaintUtil;->changePaint(Landroid/graphics/Paint;I)V

    .line 145
    :goto_0
    invoke-virtual {p0}, Lcom/google/appinventor/components/runtime/Ball;->registerChange()V

    .line 146
    return-void

    .line 143
    :cond_0
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Ball;->paint:Landroid/graphics/Paint;

    const/high16 v1, -0x1000000

    invoke-static {v0, v1}, Lcom/google/appinventor/components/runtime/util/PaintUtil;->changePaint(Landroid/graphics/Paint;I)V

    goto :goto_0
.end method

.method public Radius()I
    .locals 1
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
    .end annotation

    .prologue
    .line 115
    iget v0, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    return v0
.end method

.method public Radius(I)V
    .locals 0
    .param p1, "radius"    # I
    .annotation runtime Lcom/google/appinventor/components/annotations/DesignerProperty;
        defaultValue = "5"
        editorType = "non_negative_integer"
    .end annotation

    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        category = .enum Lcom/google/appinventor/components/annotations/PropertyCategory;->APPEARANCE:Lcom/google/appinventor/components/annotations/PropertyCategory;
    .end annotation

    .prologue
    .line 109
    iput p1, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    .line 110
    invoke-virtual {p0}, Lcom/google/appinventor/components/runtime/Ball;->registerChange()V

    .line 111
    return-void
.end method

.method public Width()I
    .locals 1

    .prologue
    .line 84
    iget v0, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    mul-int/lit8 v0, v0, 0x2

    return v0
.end method

.method public Width(I)V
    .locals 0
    .param p1, "width"    # I

    .prologue
    .line 90
    return-void
.end method

.method public containsPoint(DD)Z
    .locals 10
    .param p1, "qx"    # D
    .param p3, "qy"    # D

    .prologue
    .line 94
    iget-wide v4, p0, Lcom/google/appinventor/components/runtime/Ball;->xLeft:D

    iget v6, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    int-to-double v6, v6

    add-double v0, v4, v6

    .line 95
    .local v0, "xCenter":D
    iget-wide v4, p0, Lcom/google/appinventor/components/runtime/Ball;->yTop:D

    iget v6, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    int-to-double v6, v6

    add-double v2, v4, v6

    .line 96
    .local v2, "yCenter":D
    sub-double v4, p1, v0

    sub-double v6, p1, v0

    mul-double/2addr v4, v6

    sub-double v6, p3, v2

    sub-double v8, p3, v2

    mul-double/2addr v6, v8

    add-double/2addr v4, v6

    iget v6, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    iget v7, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    mul-int/2addr v6, v7

    int-to-double v6, v6

    cmpg-double v4, v4, v6

    if-gtz v4, :cond_0

    const/4 v4, 0x1

    :goto_0
    return v4

    :cond_0
    const/4 v4, 0x0

    goto :goto_0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 64
    iget-boolean v0, p0, Lcom/google/appinventor/components/runtime/Ball;->visible:Z

    if-eqz v0, :cond_0

    .line 65
    iget-wide v0, p0, Lcom/google/appinventor/components/runtime/Ball;->xLeft:D

    double-to-float v0, v0

    iget v1, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    int-to-float v1, v1

    add-float/2addr v0, v1

    iget-wide v1, p0, Lcom/google/appinventor/components/runtime/Ball;->yTop:D

    double-to-float v1, v1

    iget v2, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    int-to-float v2, v2

    add-float/2addr v1, v2

    iget v2, p0, Lcom/google/appinventor/components/runtime/Ball;->radius:I

    int-to-float v2, v2

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/Ball;->paint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawCircle(FFFLandroid/graphics/Paint;)V

    .line 67
    :cond_0
    return-void
.end method
