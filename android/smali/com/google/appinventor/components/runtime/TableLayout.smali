.class public Lcom/google/appinventor/components/runtime/TableLayout;
.super Ljava/lang/Object;
.source "TableLayout.java"

# interfaces
.implements Lcom/google/appinventor/components/runtime/Layout;


# annotations
.annotation runtime Lcom/google/appinventor/components/annotations/SimpleObject;
.end annotation


# instance fields
.field private final handler:Landroid/os/Handler;

.field private final layoutManager:Landroid/widget/TableLayout;

.field private numColumns:I

.field private numRows:I


# direct methods
.method constructor <init>(Landroid/content/Context;II)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "numColumns"    # I
    .param p3, "numRows"    # I

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    new-instance v3, Landroid/widget/TableLayout;

    invoke-direct {v3, p1}, Landroid/widget/TableLayout;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    .line 41
    iput p2, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    .line 42
    iput p3, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    .line 43
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    iput-object v3, p0, Lcom/google/appinventor/components/runtime/TableLayout;->handler:Landroid/os/Handler;

    .line 45
    const/4 v1, 0x0

    .local v1, "row":I
    :goto_0
    if-ge v1, p3, :cond_1

    .line 46
    new-instance v2, Landroid/widget/TableRow;

    invoke-direct {v2, p1}, Landroid/widget/TableRow;-><init>(Landroid/content/Context;)V

    .line 47
    .local v2, "tableRow":Landroid/widget/TableRow;
    const/4 v0, 0x0

    .local v0, "col":I
    :goto_1
    if-ge v0, p2, :cond_0

    .line 48
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/TableLayout;->newEmptyCellView()Landroid/view/View;

    move-result-object v3

    invoke-static {}, Lcom/google/appinventor/components/runtime/TableLayout;->newEmptyCellLayoutParams()Landroid/widget/TableRow$LayoutParams;

    move-result-object v4

    invoke-virtual {v2, v3, v0, v4}, Landroid/widget/TableRow;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 47
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 50
    :cond_0
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    new-instance v4, Landroid/widget/TableLayout$LayoutParams;

    invoke-direct {v4}, Landroid/widget/TableLayout$LayoutParams;-><init>()V

    invoke-virtual {v3, v2, v1, v4}, Landroid/widget/TableLayout;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 45
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 52
    .end local v0    # "col":I
    .end local v2    # "tableRow":Landroid/widget/TableRow;
    :cond_1
    return-void
.end method

.method static synthetic access$000(Lcom/google/appinventor/components/runtime/TableLayout;Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/TableLayout;
    .param p1, "x1"    # Lcom/google/appinventor/components/runtime/AndroidViewComponent;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lcom/google/appinventor/components/runtime/TableLayout;->addChild(Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V

    return-void
.end method

.method private addChild(Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V
    .locals 7
    .param p1, "child"    # Lcom/google/appinventor/components/runtime/AndroidViewComponent;

    .prologue
    const/4 v4, -0x1

    .line 131
    invoke-virtual {p1}, Lcom/google/appinventor/components/runtime/AndroidViewComponent;->Row()I

    move-result v2

    .line 132
    .local v2, "row":I
    invoke-virtual {p1}, Lcom/google/appinventor/components/runtime/AndroidViewComponent;->Column()I

    move-result v1

    .line 133
    .local v1, "col":I
    if-eq v2, v4, :cond_0

    if-ne v1, v4, :cond_1

    .line 135
    :cond_0
    invoke-direct {p0, p1}, Lcom/google/appinventor/components/runtime/TableLayout;->addChildLater(Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V

    .line 152
    :goto_0
    return-void

    .line 139
    :cond_1
    if-ltz v2, :cond_3

    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    if-ge v2, v4, :cond_3

    .line 140
    if-ltz v1, :cond_2

    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    if-ge v1, v4, :cond_2

    .line 141
    iget-object v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    invoke-virtual {v4, v2}, Landroid/widget/TableLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TableRow;

    .line 142
    .local v3, "tableRow":Landroid/widget/TableRow;
    invoke-virtual {v3, v1}, Landroid/widget/TableRow;->removeViewAt(I)V

    .line 143
    invoke-virtual {p1}, Lcom/google/appinventor/components/runtime/AndroidViewComponent;->getView()Landroid/view/View;

    move-result-object v0

    .line 144
    .local v0, "cellView":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    invoke-virtual {v3, v0, v1, v4}, Landroid/widget/TableRow;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    .line 146
    .end local v0    # "cellView":Landroid/view/View;
    .end local v3    # "tableRow":Landroid/widget/TableRow;
    :cond_2
    const-string v4, "TableLayout"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Child has illegal Column property: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 149
    :cond_3
    const-string v4, "TableLayout"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Child has illegal Row property: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private addChildLater(Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V
    .locals 2
    .param p1, "child"    # Lcom/google/appinventor/components/runtime/AndroidViewComponent;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TableLayout;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/google/appinventor/components/runtime/TableLayout$1;

    invoke-direct {v1, p0, p1}, Lcom/google/appinventor/components/runtime/TableLayout$1;-><init>(Lcom/google/appinventor/components/runtime/TableLayout;Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 128
    return-void
.end method

.method private static newCellLayoutParams()Landroid/widget/TableRow$LayoutParams;
    .locals 1

    .prologue
    .line 163
    new-instance v0, Landroid/widget/TableRow$LayoutParams;

    invoke-direct {v0}, Landroid/widget/TableRow$LayoutParams;-><init>()V

    return-object v0
.end method

.method private static newEmptyCellLayoutParams()Landroid/widget/TableRow$LayoutParams;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 159
    new-instance v0, Landroid/widget/TableRow$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/widget/TableRow$LayoutParams;-><init>(II)V

    return-object v0
.end method

.method private newEmptyCellView()Landroid/view/View;
    .locals 2

    .prologue
    .line 155
    new-instance v0, Landroid/widget/TextView;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    invoke-virtual {v1}, Landroid/widget/TableLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    return-object v0
.end method


# virtual methods
.method public add(Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V
    .locals 2
    .param p1, "child"    # Lcom/google/appinventor/components/runtime/AndroidViewComponent;

    .prologue
    .line 115
    invoke-virtual {p1}, Lcom/google/appinventor/components/runtime/AndroidViewComponent;->getView()Landroid/view/View;

    move-result-object v0

    invoke-static {}, Lcom/google/appinventor/components/runtime/TableLayout;->newCellLayoutParams()Landroid/widget/TableRow$LayoutParams;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 116
    invoke-direct {p0, p1}, Lcom/google/appinventor/components/runtime/TableLayout;->addChildLater(Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V

    .line 117
    return-void
.end method

.method public getLayoutManager()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    return-object v0
.end method

.method getNumColumns()I
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    return v0
.end method

.method getNumRows()I
    .locals 1

    .prologue
    .line 81
    iget v0, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    return v0
.end method

.method setNumColumns(I)V
    .locals 6
    .param p1, "newNumColumns"    # I

    .prologue
    .line 59
    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    if-le p1, v4, :cond_3

    .line 61
    iget-object v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    invoke-virtual {v4}, Landroid/widget/TableLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 62
    .local v1, "context":Landroid/content/Context;
    const/4 v2, 0x0

    .local v2, "row":I
    :goto_0
    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    if-ge v2, v4, :cond_1

    .line 63
    iget-object v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    invoke-virtual {v4, v2}, Landroid/widget/TableLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TableRow;

    .line 64
    .local v3, "tableRow":Landroid/widget/TableRow;
    iget v0, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    .local v0, "col":I
    :goto_1
    if-ge v0, p1, :cond_0

    .line 65
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/TableLayout;->newEmptyCellView()Landroid/view/View;

    move-result-object v4

    invoke-static {}, Lcom/google/appinventor/components/runtime/TableLayout;->newEmptyCellLayoutParams()Landroid/widget/TableRow$LayoutParams;

    move-result-object v5

    invoke-virtual {v3, v4, v0, v5}, Landroid/widget/TableRow;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 64
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 62
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 68
    .end local v0    # "col":I
    .end local v3    # "tableRow":Landroid/widget/TableRow;
    :cond_1
    iput p1, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    .line 78
    .end local v1    # "context":Landroid/content/Context;
    .end local v2    # "row":I
    :cond_2
    :goto_2
    return-void

    .line 70
    :cond_3
    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    if-ge p1, v4, :cond_2

    .line 72
    const/4 v2, 0x0

    .restart local v2    # "row":I
    :goto_3
    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    if-ge v2, v4, :cond_4

    .line 73
    iget-object v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    invoke-virtual {v4, v2}, Landroid/widget/TableLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TableRow;

    .line 74
    .restart local v3    # "tableRow":Landroid/widget/TableRow;
    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    sub-int/2addr v4, p1

    invoke-virtual {v3, p1, v4}, Landroid/widget/TableRow;->removeViews(II)V

    .line 72
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 76
    .end local v3    # "tableRow":Landroid/widget/TableRow;
    :cond_4
    iput p1, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    goto :goto_2
.end method

.method setNumRows(I)V
    .locals 6
    .param p1, "newNumRows"    # I

    .prologue
    .line 85
    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    if-le p1, v4, :cond_3

    .line 87
    iget-object v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    invoke-virtual {v4}, Landroid/widget/TableLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 88
    .local v1, "context":Landroid/content/Context;
    iget v2, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    .local v2, "row":I
    :goto_0
    if-ge v2, p1, :cond_1

    .line 89
    new-instance v3, Landroid/widget/TableRow;

    invoke-direct {v3, v1}, Landroid/widget/TableRow;-><init>(Landroid/content/Context;)V

    .line 90
    .local v3, "tableRow":Landroid/widget/TableRow;
    const/4 v0, 0x0

    .local v0, "col":I
    :goto_1
    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numColumns:I

    if-ge v0, v4, :cond_0

    .line 91
    invoke-direct {p0}, Lcom/google/appinventor/components/runtime/TableLayout;->newEmptyCellView()Landroid/view/View;

    move-result-object v4

    invoke-static {}, Lcom/google/appinventor/components/runtime/TableLayout;->newEmptyCellLayoutParams()Landroid/widget/TableRow$LayoutParams;

    move-result-object v5

    invoke-virtual {v3, v4, v0, v5}, Landroid/widget/TableRow;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 90
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 93
    :cond_0
    iget-object v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    new-instance v5, Landroid/widget/TableLayout$LayoutParams;

    invoke-direct {v5}, Landroid/widget/TableLayout$LayoutParams;-><init>()V

    invoke-virtual {v4, v3, v2, v5}, Landroid/widget/TableLayout;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 88
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 95
    .end local v0    # "col":I
    .end local v3    # "tableRow":Landroid/widget/TableRow;
    :cond_1
    iput p1, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    .line 101
    .end local v1    # "context":Landroid/content/Context;
    .end local v2    # "row":I
    :cond_2
    :goto_2
    return-void

    .line 96
    :cond_3
    iget v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    if-ge p1, v4, :cond_2

    .line 98
    iget-object v4, p0, Lcom/google/appinventor/components/runtime/TableLayout;->layoutManager:Landroid/widget/TableLayout;

    iget v5, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    sub-int/2addr v5, p1

    invoke-virtual {v4, p1, v5}, Landroid/widget/TableLayout;->removeViews(II)V

    .line 99
    iput p1, p0, Lcom/google/appinventor/components/runtime/TableLayout;->numRows:I

    goto :goto_2
.end method
