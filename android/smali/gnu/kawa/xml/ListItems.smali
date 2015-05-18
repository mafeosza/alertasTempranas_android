.class public Lgnu/kawa/xml/ListItems;
.super Lgnu/mapping/MethodProc;
.source "ListItems.java"


# static fields
.field public static listItems:Lgnu/kawa/xml/ListItems;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    new-instance v0, Lgnu/kawa/xml/ListItems;

    invoke-direct {v0}, Lgnu/kawa/xml/ListItems;-><init>()V

    sput-object v0, Lgnu/kawa/xml/ListItems;->listItems:Lgnu/kawa/xml/ListItems;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lgnu/mapping/MethodProc;-><init>()V

    return-void
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 7
    .param p1, "ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 20
    iget-object v3, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 21
    .local v3, "out":Lgnu/lists/Consumer;
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->getNextArg()Ljava/lang/Object;

    move-result-object v0

    .line 22
    .local v0, "arg":Ljava/lang/Object;
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->lastArg()V

    move-object v2, v0

    .line 25
    check-cast v2, Ljava/util/List;

    .line 26
    .local v2, "list":Ljava/util/List;
    instance-of v5, v0, Lgnu/lists/AbstractSequence;

    if-eqz v5, :cond_1

    .line 28
    check-cast v0, Lgnu/lists/AbstractSequence;

    .end local v0    # "arg":Ljava/lang/Object;
    const/4 v5, 0x0

    const/4 v6, -0x1

    invoke-virtual {v0, v5, v6, v3}, Lgnu/lists/AbstractSequence;->consumePosRange(IILgnu/lists/Consumer;)V

    .line 41
    :cond_0
    return-void

    .line 31
    .restart local v0    # "arg":Ljava/lang/Object;
    :cond_1
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 32
    .local v1, "iter":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 34
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    .line 35
    .local v4, "val":Ljava/lang/Object;
    invoke-static {v4, v3}, Lgnu/mapping/Values;->writeValues(Ljava/lang/Object;Lgnu/lists/Consumer;)V

    goto :goto_0
.end method
