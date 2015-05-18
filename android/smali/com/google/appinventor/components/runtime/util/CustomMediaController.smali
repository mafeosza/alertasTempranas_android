.class public Lcom/google/appinventor/components/runtime/util/CustomMediaController;
.super Landroid/widget/MediaController;
.source "CustomMediaController.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# instance fields
.field private mAnchorView:Landroid/view/View;

.field private mShowTime:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    invoke-direct {p0, p1}, Landroid/widget/MediaController;-><init>(Landroid/content/Context;)V

    .line 35
    const/16 v0, 0xbb8

    iput v0, p0, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->mShowTime:I

    .line 39
    return-void
.end method


# virtual methods
.method public addTo(Landroid/view/ViewGroup;Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 3
    .param p1, "parent"    # Landroid/view/ViewGroup;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 76
    invoke-virtual {p0}, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 77
    .local v0, "mParent":Landroid/view/ViewParent;
    if-eqz v0, :cond_0

    instance-of v1, v0, Landroid/view/ViewGroup;

    if-eqz v1, :cond_0

    .line 78
    check-cast v0, Landroid/view/ViewGroup;

    .end local v0    # "mParent":Landroid/view/ViewParent;
    invoke-virtual {v0, p0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 79
    invoke-virtual {p1, p0, p2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 80
    const/4 v1, 0x1

    .line 84
    :goto_0
    return v1

    .line 82
    .restart local v0    # "mParent":Landroid/view/ViewParent;
    :cond_0
    const-string v1, "CustomMediaController.addTo"

    const-string v2, "MediaController not available in fullscreen."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 84
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public hide()V
    .locals 1

    .prologue
    .line 105
    invoke-super {p0}, Landroid/widget/MediaController;->hide()V

    .line 106
    const/4 v0, 0x4

    invoke-virtual {p0, v0}, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->setVisibility(I)V

    .line 107
    return-void
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->mAnchorView:Landroid/view/View;

    if-ne p1, v0, :cond_0

    .line 117
    iget v0, p0, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->mShowTime:I

    invoke-virtual {p0, v0}, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->show(I)V

    .line 119
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public setAnchorView(Landroid/view/View;)V
    .locals 1
    .param p1, "anchorView"    # Landroid/view/View;

    .prologue
    .line 94
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->mAnchorView:Landroid/view/View;

    .line 95
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->mAnchorView:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 96
    invoke-super {p0, p1}, Landroid/widget/MediaController;->setAnchorView(Landroid/view/View;)V

    .line 97
    return-void
.end method

.method public show()V
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->setVisibility(I)V

    .line 60
    invoke-super {p0}, Landroid/widget/MediaController;->show()V

    .line 61
    return-void
.end method

.method public show(I)V
    .locals 1
    .param p1, "timeout"    # I

    .prologue
    .line 49
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/appinventor/components/runtime/util/CustomMediaController;->setVisibility(I)V

    .line 50
    invoke-super {p0, p1}, Landroid/widget/MediaController;->show(I)V

    .line 51
    return-void
.end method
