.class public Lgnu/kawa/models/WithComposite;
.super Ljava/lang/Object;
.source "WithComposite.java"

# interfaces
.implements Lgnu/kawa/models/Paintable;


# instance fields
.field composite:[Ljava/awt/Composite;

.field paintable:[Lgnu/kawa/models/Paintable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static make(Lgnu/kawa/models/Paintable;Ljava/awt/Composite;)Lgnu/kawa/models/WithComposite;
    .locals 4
    .param p0, "paintable"    # Lgnu/kawa/models/Paintable;
    .param p1, "composite"    # Ljava/awt/Composite;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 12
    new-instance v0, Lgnu/kawa/models/WithComposite;

    invoke-direct {v0}, Lgnu/kawa/models/WithComposite;-><init>()V

    .line 13
    .local v0, "comp":Lgnu/kawa/models/WithComposite;
    new-array v1, v3, [Lgnu/kawa/models/Paintable;

    aput-object p0, v1, v2

    iput-object v1, v0, Lgnu/kawa/models/WithComposite;->paintable:[Lgnu/kawa/models/Paintable;

    .line 14
    new-array v1, v3, [Ljava/awt/Composite;

    aput-object p1, v1, v2

    iput-object v1, v0, Lgnu/kawa/models/WithComposite;->composite:[Ljava/awt/Composite;

    .line 15
    return-object v0
.end method

.method public static make([Lgnu/kawa/models/Paintable;[Ljava/awt/Composite;)Lgnu/kawa/models/WithComposite;
    .locals 1
    .param p0, "paintable"    # [Lgnu/kawa/models/Paintable;
    .param p1, "composite"    # [Ljava/awt/Composite;

    .prologue
    .line 21
    new-instance v0, Lgnu/kawa/models/WithComposite;

    invoke-direct {v0}, Lgnu/kawa/models/WithComposite;-><init>()V

    .line 22
    .local v0, "comp":Lgnu/kawa/models/WithComposite;
    iput-object p0, v0, Lgnu/kawa/models/WithComposite;->paintable:[Lgnu/kawa/models/Paintable;

    .line 23
    iput-object p1, v0, Lgnu/kawa/models/WithComposite;->composite:[Ljava/awt/Composite;

    .line 24
    return-object v0
.end method

.method public static make([Ljava/lang/Object;)Lgnu/kawa/models/WithComposite;
    .locals 8
    .param p0, "arguments"    # [Ljava/lang/Object;

    .prologue
    .line 29
    const/4 v5, 0x0

    .line 30
    .local v5, "n":I
    array-length v3, p0

    .local v3, "i":I
    :cond_0
    :goto_0
    add-int/lit8 v3, v3, -0x1

    if-ltz v3, :cond_1

    .line 32
    aget-object v7, p0, v3

    instance-of v7, v7, Lgnu/kawa/models/Paintable;

    if-eqz v7, :cond_0

    .line 33
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 35
    :cond_1
    new-array v6, v5, [Lgnu/kawa/models/Paintable;

    .line 36
    .local v6, "paintable":[Lgnu/kawa/models/Paintable;
    new-array v2, v5, [Ljava/awt/Composite;

    .line 37
    .local v2, "composite":[Ljava/awt/Composite;
    const/4 v1, 0x0

    .line 38
    .local v1, "comp":Ljava/awt/Composite;
    const/4 v4, 0x0

    .line 39
    .local v4, "j":I
    const/4 v3, 0x0

    :goto_1
    array-length v7, p0

    if-ge v3, v7, :cond_3

    .line 41
    aget-object v0, p0, v3

    .line 42
    .local v0, "arg":Ljava/lang/Object;
    instance-of v7, v0, Lgnu/kawa/models/Paintable;

    if-eqz v7, :cond_2

    .line 44
    aget-object v7, p0, v3

    check-cast v7, Lgnu/kawa/models/Paintable;

    aput-object v7, v6, v4

    .line 45
    aput-object v1, v2, v4

    .line 46
    add-int/lit8 v4, v4, 0x1

    .line 39
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    :cond_2
    move-object v1, v0

    .line 50
    check-cast v1, Ljava/awt/Composite;

    goto :goto_2

    .line 53
    .end local v0    # "arg":Ljava/lang/Object;
    :cond_3
    invoke-static {v6, v2}, Lgnu/kawa/models/WithComposite;->make([Lgnu/kawa/models/Paintable;[Ljava/awt/Composite;)Lgnu/kawa/models/WithComposite;

    move-result-object v7

    return-object v7
.end method


# virtual methods
.method public getBounds2D()Ljava/awt/geom/Rectangle2D;
    .locals 5

    .prologue
    .line 84
    iget-object v3, p0, Lgnu/kawa/models/WithComposite;->paintable:[Lgnu/kawa/models/Paintable;

    array-length v2, v3

    .line 85
    .local v2, "n":I
    if-nez v2, :cond_1

    .line 86
    const/4 v0, 0x0

    .line 90
    :cond_0
    return-object v0

    .line 87
    :cond_1
    iget-object v3, p0, Lgnu/kawa/models/WithComposite;->paintable:[Lgnu/kawa/models/Paintable;

    const/4 v4, 0x0

    aget-object v3, v3, v4

    invoke-interface {v3}, Lgnu/kawa/models/Paintable;->getBounds2D()Ljava/awt/geom/Rectangle2D;

    move-result-object v0

    .line 88
    .local v0, "bounds":Ljava/awt/geom/Rectangle2D;
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 89
    iget-object v3, p0, Lgnu/kawa/models/WithComposite;->paintable:[Lgnu/kawa/models/Paintable;

    aget-object v3, v3, v1

    invoke-interface {v3}, Lgnu/kawa/models/Paintable;->getBounds2D()Ljava/awt/geom/Rectangle2D;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/awt/geom/Rectangle2D;->createUnion(Ljava/awt/geom/Rectangle2D;)Ljava/awt/geom/Rectangle2D;

    move-result-object v0

    .line 88
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public paint(Ljava/awt/Graphics2D;)V
    .locals 6
    .param p1, "graphics"    # Ljava/awt/Graphics2D;

    .prologue
    .line 59
    invoke-virtual {p1}, Ljava/awt/Graphics2D;->getComposite()Ljava/awt/Composite;

    move-result-object v4

    .line 60
    .local v4, "saved":Ljava/awt/Composite;
    move-object v3, v4

    .line 63
    .local v3, "prev":Ljava/awt/Composite;
    :try_start_0
    iget-object v5, p0, Lgnu/kawa/models/WithComposite;->paintable:[Lgnu/kawa/models/Paintable;

    array-length v2, v5

    .line 64
    .local v2, "n":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_1

    .line 66
    iget-object v5, p0, Lgnu/kawa/models/WithComposite;->composite:[Ljava/awt/Composite;

    aget-object v0, v5, v1

    .line 67
    .local v0, "cur":Ljava/awt/Composite;
    if-eqz v0, :cond_0

    if-eq v0, v3, :cond_0

    .line 69
    invoke-virtual {p1, v0}, Ljava/awt/Graphics2D;->setComposite(Ljava/awt/Composite;)V

    .line 70
    move-object v3, v0

    .line 72
    :cond_0
    iget-object v5, p0, Lgnu/kawa/models/WithComposite;->paintable:[Lgnu/kawa/models/Paintable;

    aget-object v5, v5, v1

    invoke-interface {v5, p1}, Lgnu/kawa/models/Paintable;->paint(Ljava/awt/Graphics2D;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 64
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 77
    .end local v0    # "cur":Ljava/awt/Composite;
    :cond_1
    if-eq v3, v4, :cond_2

    .line 78
    invoke-virtual {p1, v4}, Ljava/awt/Graphics2D;->setComposite(Ljava/awt/Composite;)V

    .line 80
    :cond_2
    return-void

    .line 77
    .end local v1    # "i":I
    .end local v2    # "n":I
    :catchall_0
    move-exception v5

    if-eq v3, v4, :cond_3

    .line 78
    invoke-virtual {p1, v4}, Ljava/awt/Graphics2D;->setComposite(Ljava/awt/Composite;)V

    :cond_3
    throw v5
.end method

.method public transform(Ljava/awt/geom/AffineTransform;)Lgnu/kawa/models/Paintable;
    .locals 4
    .param p1, "tr"    # Ljava/awt/geom/AffineTransform;

    .prologue
    .line 95
    iget-object v3, p0, Lgnu/kawa/models/WithComposite;->paintable:[Lgnu/kawa/models/Paintable;

    array-length v1, v3

    .line 96
    .local v1, "n":I
    new-array v2, v1, [Lgnu/kawa/models/Paintable;

    .line 97
    .local v2, "transformed":[Lgnu/kawa/models/Paintable;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 98
    iget-object v3, p0, Lgnu/kawa/models/WithComposite;->paintable:[Lgnu/kawa/models/Paintable;

    aget-object v3, v3, v0

    invoke-interface {v3, p1}, Lgnu/kawa/models/Paintable;->transform(Ljava/awt/geom/AffineTransform;)Lgnu/kawa/models/Paintable;

    move-result-object v3

    aput-object v3, v2, v0

    .line 97
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 99
    :cond_0
    iget-object v3, p0, Lgnu/kawa/models/WithComposite;->composite:[Ljava/awt/Composite;

    invoke-static {v2, v3}, Lgnu/kawa/models/WithComposite;->make([Lgnu/kawa/models/Paintable;[Ljava/awt/Composite;)Lgnu/kawa/models/WithComposite;

    move-result-object v3

    return-object v3
.end method
