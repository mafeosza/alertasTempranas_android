.class public Lgnu/q2/lang/Q2Apply;
.super Lgnu/mapping/MethodProc;
.source "Q2Apply.java"


# static fields
.field public static q2Apply:Lgnu/q2/lang/Q2Apply;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    new-instance v0, Lgnu/q2/lang/Q2Apply;

    invoke-direct {v0}, Lgnu/q2/lang/Q2Apply;-><init>()V

    sput-object v0, Lgnu/q2/lang/Q2Apply;->q2Apply:Lgnu/q2/lang/Q2Apply;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lgnu/mapping/MethodProc;-><init>()V

    return-void
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 8
    .param p1, "ctx"    # Lgnu/mapping/CallContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 13
    sget-object v1, Lgnu/expr/Special;->dfault:Lgnu/expr/Special;

    .line 14
    .local v1, "endMarker":Lgnu/expr/Special;
    invoke-virtual {p1, v1}, Lgnu/mapping/CallContext;->getNextArg(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 15
    .local v0, "arg":Ljava/lang/Object;
    instance-of v6, v0, Lgnu/mapping/Procedure;

    if-nez v6, :cond_0

    instance-of v6, v0, Lgnu/bytecode/Type;

    if-nez v6, :cond_0

    instance-of v6, v0, Ljava/lang/Class;

    if-eqz v6, :cond_7

    .line 18
    :cond_0
    new-instance v5, Ljava/util/Vector;

    invoke-direct {v5}, Ljava/util/Vector;-><init>()V

    .line 19
    .local v5, "vec":Ljava/util/Vector;
    instance-of v6, v0, Lgnu/mapping/Procedure;

    if-eqz v6, :cond_2

    move-object v3, v0

    .line 20
    check-cast v3, Lgnu/mapping/Procedure;

    .line 28
    .local v3, "proc":Lgnu/mapping/Procedure;
    :cond_1
    :goto_0
    invoke-virtual {p1, v1}, Lgnu/mapping/CallContext;->getNextArg(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 29
    if-ne v0, v1, :cond_3

    .line 40
    invoke-virtual {v5}, Ljava/util/Vector;->toArray()[Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v3, v6}, Lgnu/mapping/Procedure;->applyN([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 41
    instance-of v6, v0, Lgnu/lists/Consumable;

    if-eqz v6, :cond_5

    move-object v6, v0

    .line 42
    check-cast v6, Lgnu/lists/Consumable;

    iget-object v7, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    invoke-interface {v6, v7}, Lgnu/lists/Consumable;->consume(Lgnu/lists/Consumer;)V

    .line 57
    .end local v3    # "proc":Lgnu/mapping/Procedure;
    .end local v5    # "vec":Ljava/util/Vector;
    :goto_1
    return-void

    .line 23
    .restart local v5    # "vec":Ljava/util/Vector;
    :cond_2
    invoke-virtual {v5, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 24
    sget-object v3, Lgnu/kawa/reflect/Invoke;->make:Lgnu/kawa/reflect/Invoke;

    .restart local v3    # "proc":Lgnu/mapping/Procedure;
    goto :goto_0

    .line 31
    :cond_3
    instance-of v6, v0, Lgnu/mapping/Values;

    if-eqz v6, :cond_4

    move-object v6, v0

    .line 33
    check-cast v6, Lgnu/mapping/Values;

    invoke-virtual {v6}, Lgnu/mapping/Values;->getValues()[Ljava/lang/Object;

    move-result-object v4

    .line 34
    .local v4, "vals":[Ljava/lang/Object;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_2
    array-length v6, v4

    if-ge v2, v6, :cond_1

    .line 35
    aget-object v6, v4, v2

    invoke-virtual {v5, v6}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 34
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 38
    .end local v2    # "i":I
    .end local v4    # "vals":[Ljava/lang/Object;
    :cond_4
    invoke-virtual {v5, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 44
    :cond_5
    invoke-virtual {p1, v0}, Lgnu/mapping/CallContext;->writeValue(Ljava/lang/Object;)V

    goto :goto_1

    .line 51
    .end local v3    # "proc":Lgnu/mapping/Procedure;
    .end local v5    # "vec":Ljava/util/Vector;
    :cond_6
    instance-of v6, v0, Lgnu/lists/Consumable;

    if-eqz v6, :cond_8

    .line 52
    check-cast v0, Lgnu/lists/Consumable;

    .end local v0    # "arg":Ljava/lang/Object;
    iget-object v6, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    invoke-interface {v0, v6}, Lgnu/lists/Consumable;->consume(Lgnu/lists/Consumer;)V

    .line 55
    :goto_3
    invoke-virtual {p1, v1}, Lgnu/mapping/CallContext;->getNextArg(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 49
    .restart local v0    # "arg":Ljava/lang/Object;
    :cond_7
    if-ne v0, v1, :cond_6

    goto :goto_1

    .line 54
    :cond_8
    invoke-virtual {p1, v0}, Lgnu/mapping/CallContext;->writeValue(Ljava/lang/Object;)V

    goto :goto_3
.end method
