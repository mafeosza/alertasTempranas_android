.class public final Lcom/google/appinventor/components/runtime/util/ViewUtil;
.super Ljava/lang/Object;
.source "ViewUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method public static setBackgroundDrawable(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p0, "view"    # Landroid/view/View;
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 187
    invoke-virtual {p0, p1}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 188
    invoke-virtual {p0}, Landroid/view/View;->invalidate()V

    .line 189
    return-void
.end method

.method public static setBackgroundImage(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p0, "view"    # Landroid/view/View;
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 171
    invoke-virtual {p0, p1}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 172
    invoke-virtual {p0}, Landroid/view/View;->requestLayout()V

    .line 173
    return-void
.end method

.method public static setChildHeightForHorizontalLayout(Landroid/view/View;I)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;
    .param p1, "height"    # I

    .prologue
    .line 56
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 57
    .local v0, "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    instance-of v2, v0, Landroid/widget/LinearLayout$LayoutParams;

    if-eqz v2, :cond_0

    move-object v1, v0

    .line 58
    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 59
    .local v1, "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    packed-switch p1, :pswitch_data_0

    .line 67
    iput p1, v1, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 70
    :goto_0
    invoke-virtual {p0}, Landroid/view/View;->requestLayout()V

    .line 74
    .end local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :goto_1
    return-void

    .line 61
    .restart local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :pswitch_0
    const/4 v2, -0x2

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->height:I

    goto :goto_0

    .line 64
    :pswitch_1
    const/4 v2, -0x1

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->height:I

    goto :goto_0

    .line 72
    .end local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :cond_0
    const-string v2, "ViewUtil"

    const-string v3, "The view does not have linear layout parameters"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 59
    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static setChildHeightForTableLayout(Landroid/view/View;I)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;
    .param p1, "height"    # I

    .prologue
    .line 147
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 148
    .local v0, "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    instance-of v2, v0, Landroid/widget/TableRow$LayoutParams;

    if-eqz v2, :cond_0

    move-object v1, v0

    .line 149
    check-cast v1, Landroid/widget/TableRow$LayoutParams;

    .line 150
    .local v1, "tableLayoutParams":Landroid/widget/TableRow$LayoutParams;
    packed-switch p1, :pswitch_data_0

    .line 158
    iput p1, v1, Landroid/widget/TableRow$LayoutParams;->height:I

    .line 161
    :goto_0
    invoke-virtual {p0}, Landroid/view/View;->requestLayout()V

    .line 165
    .end local v1    # "tableLayoutParams":Landroid/widget/TableRow$LayoutParams;
    :goto_1
    return-void

    .line 152
    .restart local v1    # "tableLayoutParams":Landroid/widget/TableRow$LayoutParams;
    :pswitch_0
    const/4 v2, -0x2

    iput v2, v1, Landroid/widget/TableRow$LayoutParams;->height:I

    goto :goto_0

    .line 155
    :pswitch_1
    const/4 v2, -0x1

    iput v2, v1, Landroid/widget/TableRow$LayoutParams;->height:I

    goto :goto_0

    .line 163
    .end local v1    # "tableLayoutParams":Landroid/widget/TableRow$LayoutParams;
    :cond_0
    const-string v2, "ViewUtil"

    const-string v3, "The view does not have table layout parameters"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 150
    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static setChildHeightForVerticalLayout(Landroid/view/View;I)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;
    .param p1, "height"    # I

    .prologue
    const/4 v3, 0x0

    .line 102
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 103
    .local v0, "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    instance-of v2, v0, Landroid/widget/LinearLayout$LayoutParams;

    if-eqz v2, :cond_0

    move-object v1, v0

    .line 104
    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 105
    .local v1, "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    packed-switch p1, :pswitch_data_0

    .line 115
    iput p1, v1, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 116
    iput v3, v1, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 119
    :goto_0
    invoke-virtual {p0}, Landroid/view/View;->requestLayout()V

    .line 123
    .end local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :goto_1
    return-void

    .line 107
    .restart local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :pswitch_0
    const/4 v2, -0x2

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 108
    iput v3, v1, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    goto :goto_0

    .line 111
    :pswitch_1
    const/4 v2, 0x0

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->height:I

    .line 112
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    goto :goto_0

    .line 121
    .end local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :cond_0
    const-string v2, "ViewUtil"

    const-string v3, "The view does not have linear layout parameters"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 105
    nop

    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static setChildWidthForHorizontalLayout(Landroid/view/View;I)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;
    .param p1, "width"    # I

    .prologue
    const/4 v3, 0x0

    .line 30
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 31
    .local v0, "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    instance-of v2, v0, Landroid/widget/LinearLayout$LayoutParams;

    if-eqz v2, :cond_0

    move-object v1, v0

    .line 32
    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 33
    .local v1, "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    packed-switch p1, :pswitch_data_0

    .line 43
    iput p1, v1, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 44
    iput v3, v1, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 47
    :goto_0
    invoke-virtual {p0}, Landroid/view/View;->requestLayout()V

    .line 51
    .end local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :goto_1
    return-void

    .line 35
    .restart local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :pswitch_0
    const/4 v2, -0x2

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 36
    iput v3, v1, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    goto :goto_0

    .line 39
    :pswitch_1
    const/4 v2, 0x0

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 40
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    goto :goto_0

    .line 49
    .end local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :cond_0
    const-string v2, "ViewUtil"

    const-string v3, "The view does not have linear layout parameters"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 33
    nop

    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static setChildWidthForTableLayout(Landroid/view/View;I)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;
    .param p1, "width"    # I

    .prologue
    .line 126
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 127
    .local v0, "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    instance-of v2, v0, Landroid/widget/TableRow$LayoutParams;

    if-eqz v2, :cond_0

    move-object v1, v0

    .line 128
    check-cast v1, Landroid/widget/TableRow$LayoutParams;

    .line 129
    .local v1, "tableLayoutParams":Landroid/widget/TableRow$LayoutParams;
    packed-switch p1, :pswitch_data_0

    .line 137
    iput p1, v1, Landroid/widget/TableRow$LayoutParams;->width:I

    .line 140
    :goto_0
    invoke-virtual {p0}, Landroid/view/View;->requestLayout()V

    .line 144
    .end local v1    # "tableLayoutParams":Landroid/widget/TableRow$LayoutParams;
    :goto_1
    return-void

    .line 131
    .restart local v1    # "tableLayoutParams":Landroid/widget/TableRow$LayoutParams;
    :pswitch_0
    const/4 v2, -0x2

    iput v2, v1, Landroid/widget/TableRow$LayoutParams;->width:I

    goto :goto_0

    .line 134
    :pswitch_1
    const/4 v2, -0x1

    iput v2, v1, Landroid/widget/TableRow$LayoutParams;->width:I

    goto :goto_0

    .line 142
    .end local v1    # "tableLayoutParams":Landroid/widget/TableRow$LayoutParams;
    :cond_0
    const-string v2, "ViewUtil"

    const-string v3, "The view does not have table layout parameters"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 129
    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static setChildWidthForVerticalLayout(Landroid/view/View;I)V
    .locals 4
    .param p0, "view"    # Landroid/view/View;
    .param p1, "width"    # I

    .prologue
    .line 79
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 80
    .local v0, "layoutParams":Landroid/view/ViewGroup$LayoutParams;
    instance-of v2, v0, Landroid/widget/LinearLayout$LayoutParams;

    if-eqz v2, :cond_0

    move-object v1, v0

    .line 81
    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;

    .line 82
    .local v1, "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    packed-switch p1, :pswitch_data_0

    .line 90
    iput p1, v1, Landroid/widget/LinearLayout$LayoutParams;->width:I

    .line 93
    :goto_0
    invoke-virtual {p0}, Landroid/view/View;->requestLayout()V

    .line 97
    .end local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :goto_1
    return-void

    .line 84
    .restart local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :pswitch_0
    const/4 v2, -0x2

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->width:I

    goto :goto_0

    .line 87
    :pswitch_1
    const/4 v2, -0x1

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->width:I

    goto :goto_0

    .line 95
    .end local v1    # "linearLayoutParams":Landroid/widget/LinearLayout$LayoutParams;
    :cond_0
    const-string v2, "ViewUtil"

    const-string v3, "The view does not have linear layout parameters"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 82
    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public static setImage(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p0, "view"    # Landroid/widget/ImageView;
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 179
    invoke-virtual {p0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 180
    if-eqz p1, :cond_0

    .line 181
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Landroid/widget/ImageView;->setAdjustViewBounds(Z)V

    .line 183
    :cond_0
    invoke-virtual {p0}, Landroid/widget/ImageView;->requestLayout()V

    .line 184
    return-void
.end method
