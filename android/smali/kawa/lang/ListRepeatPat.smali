.class public Lkawa/lang/ListRepeatPat;
.super Lkawa/lang/Pattern;
.source "ListRepeatPat.java"

# interfaces
.implements Lgnu/text/Printable;
.implements Ljava/io/Externalizable;


# instance fields
.field element_pattern:Lkawa/lang/Pattern;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lkawa/lang/Pattern;-><init>()V

    .line 12
    return-void
.end method

.method public constructor <init>(Lkawa/lang/Pattern;)V
    .locals 0
    .param p1, "element_pattern"    # Lkawa/lang/Pattern;

    .prologue
    .line 15
    invoke-direct {p0}, Lkawa/lang/Pattern;-><init>()V

    .line 16
    iput-object p1, p0, Lkawa/lang/ListRepeatPat;->element_pattern:Lkawa/lang/Pattern;

    .line 17
    return-void
.end method

.method public static make(Lkawa/lang/Pattern;)Lkawa/lang/ListRepeatPat;
    .locals 1
    .param p0, "element_pattern"    # Lkawa/lang/Pattern;

    .prologue
    .line 21
    new-instance v0, Lkawa/lang/ListRepeatPat;

    invoke-direct {v0, p0}, Lkawa/lang/ListRepeatPat;-><init>(Lkawa/lang/Pattern;)V

    return-object v0
.end method


# virtual methods
.method public match(Ljava/lang/Object;[Ljava/lang/Object;I)Z
    .locals 9
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "vars"    # [Ljava/lang/Object;
    .param p3, "start_vars"    # I

    .prologue
    const/4 v7, 0x0

    .line 40
    invoke-static {p1, v7}, Lgnu/lists/LList;->listLength(Ljava/lang/Object;Z)I

    move-result v3

    .line 41
    .local v3, "length":I
    if-gez v3, :cond_0

    move v6, v7

    .line 64
    :goto_0
    return v6

    .line 44
    :cond_0
    iget-object v6, p0, Lkawa/lang/ListRepeatPat;->element_pattern:Lkawa/lang/Pattern;

    invoke-virtual {v6}, Lkawa/lang/Pattern;->varCount()I

    move-result v5

    .line 45
    .local v5, "var_count":I
    move v1, v5

    .local v1, "i":I
    :goto_1
    add-int/lit8 v1, v1, -0x1

    if-ltz v1, :cond_1

    .line 46
    add-int v6, p3, v1

    new-array v8, v3, [Ljava/lang/Object;

    aput-object v8, p2, v6

    goto :goto_1

    .line 47
    :cond_1
    new-array v0, v5, [Ljava/lang/Object;

    .line 48
    .local v0, "element_vars":[Ljava/lang/Object;
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_2
    if-ge v2, v3, :cond_4

    move-object v4, p1

    .line 50
    check-cast v4, Lgnu/lists/Pair;

    .line 58
    .local v4, "pair":Lgnu/lists/Pair;
    iget-object v6, p0, Lkawa/lang/ListRepeatPat;->element_pattern:Lkawa/lang/Pattern;

    invoke-virtual {v4}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v6, v8, v0, v7}, Lkawa/lang/Pattern;->match(Ljava/lang/Object;[Ljava/lang/Object;I)Z

    move-result v6

    if-nez v6, :cond_2

    move v6, v7

    .line 59
    goto :goto_0

    .line 60
    :cond_2
    const/4 v1, 0x0

    :goto_3
    if-ge v1, v5, :cond_3

    .line 61
    add-int v6, p3, v1

    aget-object v6, p2, v6

    check-cast v6, [Ljava/lang/Object;

    check-cast v6, [Ljava/lang/Object;

    aget-object v8, v0, v1

    aput-object v8, v6, v2

    .line 60
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 62
    :cond_3
    invoke-virtual {v4}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p1

    .line 48
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 64
    .end local v4    # "pair":Lgnu/lists/Pair;
    :cond_4
    const/4 v6, 0x1

    goto :goto_0
.end method

.method public print(Lgnu/lists/Consumer;)V
    .locals 1
    .param p1, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 26
    const-string v0, "#<list-repeat-pattern "

    invoke-interface {p1, v0}, Lgnu/lists/Consumer;->write(Ljava/lang/String;)V

    .line 27
    iget-object v0, p0, Lkawa/lang/ListRepeatPat;->element_pattern:Lkawa/lang/Pattern;

    invoke-virtual {v0, p1}, Lkawa/lang/Pattern;->print(Lgnu/lists/Consumer;)V

    .line 28
    const/16 v0, 0x3e

    invoke-interface {p1, v0}, Lgnu/lists/Consumer;->write(I)V

    .line 29
    return-void
.end method

.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 1
    .param p1, "in"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 80
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lkawa/lang/Pattern;

    iput-object v0, p0, Lkawa/lang/ListRepeatPat;->element_pattern:Lkawa/lang/Pattern;

    .line 81
    return-void
.end method

.method public varCount()I
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lkawa/lang/ListRepeatPat;->element_pattern:Lkawa/lang/Pattern;

    invoke-virtual {v0}, Lkawa/lang/Pattern;->varCount()I

    move-result v0

    return v0
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 1
    .param p1, "out"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 74
    iget-object v0, p0, Lkawa/lang/ListRepeatPat;->element_pattern:Lkawa/lang/Pattern;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 75
    return-void
.end method
