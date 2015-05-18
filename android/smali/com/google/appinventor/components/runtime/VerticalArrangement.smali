.class public Lcom/google/appinventor/components/runtime/VerticalArrangement;
.super Lcom/google/appinventor/components/runtime/HVArrangement;
.source "VerticalArrangement.java"


# annotations
.annotation runtime Lcom/google/appinventor/components/annotations/DesignerComponent;
    category = .enum Lcom/google/appinventor/components/common/ComponentCategory;->LAYOUT:Lcom/google/appinventor/components/common/ComponentCategory;
    description = "<p>A formatting element in which to place components that should be displayed one below another.  (The first child component is stored on top, the second beneath it, etc.)  If you wish to have components displayed next to one another, use <code>HorizontalArrangement</code> instead.</p>"
    version = 0x2
.end annotation

.annotation runtime Lcom/google/appinventor/components/annotations/SimpleObject;
.end annotation


# direct methods
.method public constructor <init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V
    .locals 1
    .param p1, "container"    # Lcom/google/appinventor/components/runtime/ComponentContainer;

    .prologue
    .line 32
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/google/appinventor/components/runtime/HVArrangement;-><init>(Lcom/google/appinventor/components/runtime/ComponentContainer;I)V

    .line 33
    return-void
.end method
