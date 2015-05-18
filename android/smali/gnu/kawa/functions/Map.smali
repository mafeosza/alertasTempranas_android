.class public Lgnu/kawa/functions/Map;
.super Lgnu/mapping/ProcedureN;
.source "Map.java"


# instance fields
.field final applyFieldDecl:Lgnu/expr/Declaration;

.field final applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

.field collect:Z

.field final isEq:Lgnu/kawa/functions/IsEq;


# direct methods
.method public constructor <init>(ZLgnu/kawa/functions/ApplyToArgs;Lgnu/expr/Declaration;Lgnu/kawa/functions/IsEq;)V
    .locals 2
    .param p1, "collect"    # Z
    .param p2, "applyToArgs"    # Lgnu/kawa/functions/ApplyToArgs;
    .param p3, "applyFieldDecl"    # Lgnu/expr/Declaration;
    .param p4, "isEq"    # Lgnu/kawa/functions/IsEq;

    .prologue
    .line 24
    if-eqz p1, :cond_0

    const-string v0, "map"

    :goto_0
    invoke-direct {p0, v0}, Lgnu/mapping/ProcedureN;-><init>(Ljava/lang/String;)V

    .line 25
    iput-boolean p1, p0, Lgnu/kawa/functions/Map;->collect:Z

    .line 26
    iput-object p2, p0, Lgnu/kawa/functions/Map;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    .line 27
    iput-object p3, p0, Lgnu/kawa/functions/Map;->applyFieldDecl:Lgnu/expr/Declaration;

    .line 28
    iput-object p4, p0, Lgnu/kawa/functions/Map;->isEq:Lgnu/kawa/functions/IsEq;

    .line 29
    sget-object v0, Lgnu/mapping/Procedure;->validateApplyKey:Lgnu/mapping/Symbol;

    const-string v1, "gnu.kawa.functions.CompileMisc:validateApplyMap"

    invoke-virtual {p0, v0, v1}, Lgnu/kawa/functions/Map;->setProperty(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 31
    return-void

    .line 24
    :cond_0
    const-string v0, "for-each"

    goto :goto_0
.end method

.method public static forEach1(Lgnu/mapping/Procedure;Ljava/lang/Object;)V
    .locals 2
    .param p0, "proc"    # Lgnu/mapping/Procedure;
    .param p1, "list"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 55
    :goto_0
    sget-object v1, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq p1, v1, :cond_0

    move-object v0, p1

    .line 57
    check-cast v0, Lgnu/lists/Pair;

    .line 58
    .local v0, "pair":Lgnu/lists/Pair;
    invoke-virtual {v0}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v1}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    invoke-virtual {v0}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p1

    .line 60
    goto :goto_0

    .line 61
    .end local v0    # "pair":Lgnu/lists/Pair;
    :cond_0
    return-void
.end method

.method public static map1(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6
    .param p0, "proc"    # Lgnu/mapping/Procedure;
    .param p1, "list"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 36
    sget-object v3, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .line 37
    .local v3, "result":Lgnu/lists/LList;
    const/4 v0, 0x0

    .line 38
    .end local v3    # "result":Lgnu/lists/LList;
    .local v0, "last":Lgnu/lists/Pair;
    :goto_0
    sget-object v4, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq p1, v4, :cond_1

    move-object v2, p1

    .line 40
    check-cast v2, Lgnu/lists/Pair;

    .line 41
    .local v2, "pair":Lgnu/lists/Pair;
    new-instance v1, Lgnu/lists/Pair;

    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {p0, v4}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    sget-object v5, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-direct {v1, v4, v5}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 42
    .local v1, "new_pair":Lgnu/lists/Pair;
    if-nez v0, :cond_0

    .line 43
    move-object v3, v1

    .line 46
    :goto_1
    move-object v0, v1

    .line 47
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p1

    .line 48
    goto :goto_0

    .line 45
    :cond_0
    invoke-virtual {v0, v1}, Lgnu/lists/Pair;->setCdr(Ljava/lang/Object;)V

    goto :goto_1

    .line 49
    .end local v1    # "new_pair":Lgnu/lists/Pair;
    .end local v2    # "pair":Lgnu/lists/Pair;
    :cond_1
    return-object v3
.end method


# virtual methods
.method public apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 65
    instance-of v1, p1, Lgnu/mapping/Procedure;

    if-eqz v1, :cond_1

    move-object v0, p1

    .line 67
    check-cast v0, Lgnu/mapping/Procedure;

    .line 68
    .local v0, "proc":Lgnu/mapping/Procedure;
    iget-boolean v1, p0, Lgnu/kawa/functions/Map;->collect:Z

    if-eqz v1, :cond_0

    .line 69
    invoke-static {v0, p2}, Lgnu/kawa/functions/Map;->map1(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 73
    .end local v0    # "proc":Lgnu/mapping/Procedure;
    :goto_0
    return-object v1

    .line 70
    .restart local v0    # "proc":Lgnu/mapping/Procedure;
    :cond_0
    invoke-static {v0, p2}, Lgnu/kawa/functions/Map;->forEach1(Lgnu/mapping/Procedure;Ljava/lang/Object;)V

    .line 71
    sget-object v1, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    goto :goto_0

    .line 73
    .end local v0    # "proc":Lgnu/mapping/Procedure;
    :cond_1
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    invoke-virtual {p0, v1}, Lgnu/kawa/functions/Map;->applyN([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0
.end method

.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 14
    .param p1, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 78
    array-length v12, p1

    add-int/lit8 v0, v12, -0x1

    .line 79
    .local v0, "arity":I
    const/4 v12, 0x1

    if-ne v0, v12, :cond_2

    const/4 v12, 0x0

    aget-object v12, p1, v12

    instance-of v12, v12, Lgnu/mapping/Procedure;

    if-eqz v12, :cond_2

    .line 81
    const/4 v12, 0x0

    aget-object v12, p1, v12

    check-cast v12, Lgnu/mapping/Procedure;

    move-object v8, v12

    check-cast v8, Lgnu/mapping/Procedure;

    .line 82
    .local v8, "proc":Lgnu/mapping/Procedure;
    iget-boolean v12, p0, Lgnu/kawa/functions/Map;->collect:Z

    if-eqz v12, :cond_1

    .line 83
    const/4 v12, 0x1

    aget-object v12, p1, v12

    invoke-static {v8, v12}, Lgnu/kawa/functions/Map;->map1(Lgnu/mapping/Procedure;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    .line 117
    :cond_0
    :goto_0
    return-object v10

    .line 84
    :cond_1
    const/4 v12, 0x1

    aget-object v12, p1, v12

    invoke-static {v8, v12}, Lgnu/kawa/functions/Map;->forEach1(Lgnu/mapping/Procedure;Ljava/lang/Object;)V

    .line 85
    sget-object v10, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    goto :goto_0

    .line 88
    .end local v8    # "proc":Lgnu/mapping/Procedure;
    :cond_2
    const/4 v3, 0x0

    .line 89
    .local v3, "last":Lgnu/lists/Pair;
    iget-boolean v12, p0, Lgnu/kawa/functions/Map;->collect:Z

    if-eqz v12, :cond_4

    .line 90
    sget-object v10, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .line 93
    :goto_1
    new-array v9, v0, [Ljava/lang/Object;

    .line 94
    .local v9, "rest":[Ljava/lang/Object;
    const/4 v12, 0x1

    const/4 v13, 0x0

    invoke-static {p1, v12, v9, v13, v0}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 98
    const/4 v12, 0x0

    aget-object v12, p1, v12

    instance-of v12, v12, Lgnu/mapping/Procedure;

    if-eqz v12, :cond_5

    .line 100
    const/4 v5, 0x0

    .line 101
    .local v5, "need_apply":I
    new-array v1, v0, [Ljava/lang/Object;

    .line 102
    .local v1, "each_args":[Ljava/lang/Object;
    const/4 v12, 0x0

    aget-object v8, p1, v12

    check-cast v8, Lgnu/mapping/Procedure;

    .line 113
    .restart local v8    # "proc":Lgnu/mapping/Procedure;
    :cond_3
    :goto_2
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_3
    if-ge v2, v0, :cond_6

    .line 115
    aget-object v4, v9, v2

    .line 116
    .local v4, "list":Ljava/lang/Object;
    sget-object v12, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v4, v12, :cond_0

    move-object v7, v4

    .line 118
    check-cast v7, Lgnu/lists/Pair;

    .line 119
    .local v7, "pair":Lgnu/lists/Pair;
    add-int v12, v5, v2

    invoke-virtual {v7}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v13

    aput-object v13, v1, v12

    .line 120
    invoke-virtual {v7}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v12

    aput-object v12, v9, v2

    .line 113
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 92
    .end local v1    # "each_args":[Ljava/lang/Object;
    .end local v2    # "i":I
    .end local v4    # "list":Ljava/lang/Object;
    .end local v5    # "need_apply":I
    .end local v7    # "pair":Lgnu/lists/Pair;
    .end local v8    # "proc":Lgnu/mapping/Procedure;
    .end local v9    # "rest":[Ljava/lang/Object;
    :cond_4
    sget-object v10, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    .local v10, "result":Lgnu/mapping/Values;
    goto :goto_1

    .line 106
    .end local v10    # "result":Lgnu/mapping/Values;
    .restart local v9    # "rest":[Ljava/lang/Object;
    :cond_5
    const/4 v5, 0x1

    .line 107
    .restart local v5    # "need_apply":I
    add-int/lit8 v12, v0, 0x1

    new-array v1, v12, [Ljava/lang/Object;

    .line 108
    .restart local v1    # "each_args":[Ljava/lang/Object;
    const/4 v12, 0x0

    const/4 v13, 0x0

    aget-object v13, p1, v13

    aput-object v13, v1, v12

    .line 109
    iget-object v8, p0, Lgnu/kawa/functions/Map;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    .restart local v8    # "proc":Lgnu/mapping/Procedure;
    goto :goto_2

    .line 122
    .restart local v2    # "i":I
    :cond_6
    invoke-virtual {v8, v1}, Lgnu/mapping/Procedure;->applyN([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    .line 123
    .local v11, "value":Ljava/lang/Object;
    iget-boolean v12, p0, Lgnu/kawa/functions/Map;->collect:Z

    if-eqz v12, :cond_3

    .line 125
    new-instance v6, Lgnu/lists/Pair;

    sget-object v12, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-direct {v6, v11, v12}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 126
    .local v6, "new_pair":Lgnu/lists/Pair;
    if-nez v3, :cond_7

    .line 127
    move-object v10, v6

    .line 130
    :goto_4
    move-object v3, v6

    goto :goto_2

    .line 129
    :cond_7
    invoke-virtual {v3, v6}, Lgnu/lists/Pair;->setCdr(Ljava/lang/Object;)V

    goto :goto_4
.end method
