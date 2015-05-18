.class public Lgnu/kawa/xml/IteratorItems;
.super Lgnu/mapping/MethodProc;
.source "IteratorItems.java"


# static fields
.field public static iteratorItems:Lgnu/kawa/xml/IteratorItems;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    new-instance v0, Lgnu/kawa/xml/IteratorItems;

    invoke-direct {v0}, Lgnu/kawa/xml/IteratorItems;-><init>()V

    sput-object v0, Lgnu/kawa/xml/IteratorItems;->iteratorItems:Lgnu/kawa/xml/IteratorItems;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lgnu/mapping/MethodProc;-><init>()V

    return-void
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 5
    .param p1, "ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 19
    iget-object v2, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 20
    .local v2, "out":Lgnu/lists/Consumer;
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->getNextArg()Ljava/lang/Object;

    move-result-object v0

    .line 21
    .local v0, "arg":Ljava/lang/Object;
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->lastArg()V

    move-object v1, v0

    .line 24
    check-cast v1, Ljava/util/Iterator;

    .line 29
    .local v1, "iter":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 31
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    .line 32
    .local v3, "val":Ljava/lang/Object;
    invoke-static {v3, v2}, Lgnu/mapping/Values;->writeValues(Ljava/lang/Object;Lgnu/lists/Consumer;)V

    goto :goto_0

    .line 34
    .end local v3    # "val":Ljava/lang/Object;
    :cond_0
    return-void
.end method
