.class public Lgnu/kawa/functions/Apply;
.super Lgnu/mapping/ProcedureN;
.source "Apply.java"


# instance fields
.field applyToArgs:Lgnu/kawa/functions/ApplyToArgs;


# direct methods
.method public constructor <init>(Ljava/lang/String;Lgnu/kawa/functions/ApplyToArgs;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "applyToArgs"    # Lgnu/kawa/functions/ApplyToArgs;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Lgnu/mapping/ProcedureN;-><init>(Ljava/lang/String;)V

    .line 16
    iput-object p2, p0, Lgnu/kawa/functions/Apply;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    .line 17
    return-void
.end method

.method public static getArguments([Ljava/lang/Object;ILgnu/mapping/Procedure;)[Ljava/lang/Object;
    .locals 17
    .param p0, "args"    # [Ljava/lang/Object;
    .param p1, "skip"    # I
    .param p2, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    .line 21
    move-object/from16 v0, p0

    array-length v1, v0

    .line 22
    .local v1, "count":I
    add-int/lit8 v12, p1, 0x1

    if-ge v1, v12, :cond_0

    .line 23
    new-instance v12, Lgnu/mapping/WrongArguments;

    const-string v13, "apply"

    const/4 v14, 0x2

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "(apply proc [args] args) [count:"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, " skip:"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move/from16 v0, p1

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "]"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v12, v13, v14, v15}, Lgnu/mapping/WrongArguments;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    throw v12

    .line 24
    :cond_0
    add-int/lit8 v12, v1, -0x1

    aget-object v5, p0, v12

    .line 26
    .local v5, "last":Ljava/lang/Object;
    instance-of v12, v5, [Ljava/lang/Object;

    if-eqz v12, :cond_2

    move-object v12, v5

    .line 28
    check-cast v12, [Ljava/lang/Object;

    move-object v6, v12

    check-cast v6, [Ljava/lang/Object;

    .line 29
    .local v6, "last_arr":[Ljava/lang/Object;
    const/4 v12, 0x2

    if-ne v1, v12, :cond_1

    .line 65
    .end local v6    # "last_arr":[Ljava/lang/Object;
    :goto_0
    return-object v6

    .line 31
    .restart local v6    # "last_arr":[Ljava/lang/Object;
    :cond_1
    array-length v7, v6

    .line 37
    .end local v6    # "last_arr":[Ljava/lang/Object;
    .local v7, "last_count":I
    :goto_1
    if-gez v7, :cond_4

    .line 38
    new-instance v12, Lgnu/mapping/WrongType;

    const-string v13, "sequence or array"

    move-object/from16 v0, p2

    invoke-direct {v12, v0, v1, v5, v13}, Lgnu/mapping/WrongType;-><init>(Lgnu/mapping/Procedure;ILjava/lang/Object;Ljava/lang/String;)V

    throw v12

    .line 33
    .end local v7    # "last_count":I
    :cond_2
    instance-of v12, v5, Lgnu/lists/Sequence;

    if-eqz v12, :cond_3

    move-object v12, v5

    .line 34
    check-cast v12, Lgnu/lists/Sequence;

    invoke-interface {v12}, Lgnu/lists/Sequence;->size()I

    move-result v7

    .restart local v7    # "last_count":I
    goto :goto_1

    .line 36
    .end local v7    # "last_count":I
    :cond_3
    const/4 v7, -0x1

    .restart local v7    # "last_count":I
    goto :goto_1

    .line 39
    :cond_4
    sub-int v12, v1, p1

    add-int/lit8 v12, v12, -0x1

    add-int v9, v7, v12

    .line 40
    .local v9, "numArgs":I
    new-array v11, v9, [Ljava/lang/Object;

    .line 42
    .local v11, "proc_args":[Ljava/lang/Object;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_2
    sub-int v12, v1, p1

    add-int/lit8 v12, v12, -0x1

    if-ge v2, v12, :cond_5

    .line 43
    add-int v12, v2, p1

    aget-object v12, p0, v12

    aput-object v12, v11, v2

    .line 42
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 44
    :cond_5
    instance-of v12, v5, [Ljava/lang/Object;

    if-eqz v12, :cond_7

    move-object v12, v5

    .line 46
    check-cast v12, [Ljava/lang/Object;

    check-cast v12, [Ljava/lang/Object;

    const/4 v13, 0x0

    invoke-static {v12, v13, v11, v2, v7}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    :cond_6
    :goto_3
    move-object v6, v11

    .line 65
    goto :goto_0

    .line 51
    :cond_7
    :goto_4
    instance-of v12, v5, Lgnu/lists/Pair;

    if-eqz v12, :cond_8

    move-object v10, v5

    .line 53
    check-cast v10, Lgnu/lists/Pair;

    .line 54
    .local v10, "pair":Lgnu/lists/Pair;
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "i":I
    .local v3, "i":I
    invoke-virtual {v10}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v12

    aput-object v12, v11, v2

    .line 55
    invoke-virtual {v10}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v5

    .line 56
    add-int/lit8 v7, v7, -0x1

    move v2, v3

    .line 57
    .end local v3    # "i":I
    .restart local v2    # "i":I
    goto :goto_4

    .line 58
    .end local v10    # "pair":Lgnu/lists/Pair;
    :cond_8
    if-lez v7, :cond_6

    move-object v8, v5

    .line 60
    check-cast v8, Lgnu/lists/Sequence;

    .line 61
    .local v8, "last_seq":Lgnu/lists/Sequence;
    const/4 v4, 0x0

    .local v4, "j":I
    move v3, v2

    .end local v2    # "i":I
    .restart local v3    # "i":I
    :goto_5
    if-ge v4, v7, :cond_9

    .line 62
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "i":I
    .restart local v2    # "i":I
    invoke-interface {v8, v4}, Lgnu/lists/Sequence;->get(I)Ljava/lang/Object;

    move-result-object v12

    aput-object v12, v11, v3

    .line 61
    add-int/lit8 v4, v4, 0x1

    move v3, v2

    .end local v2    # "i":I
    .restart local v3    # "i":I
    goto :goto_5

    :cond_9
    move v2, v3

    .end local v3    # "i":I
    .restart local v2    # "i":I
    goto :goto_3
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 3
    .param p1, "ctx"    # Lgnu/mapping/CallContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 75
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->getArgs()[Ljava/lang/Object;

    move-result-object v0

    .line 76
    .local v0, "args":[Ljava/lang/Object;
    iget-object v1, p0, Lgnu/kawa/functions/Apply;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    const/4 v2, 0x0

    invoke-static {v0, v2, p0}, Lgnu/kawa/functions/Apply;->getArguments([Ljava/lang/Object;ILgnu/mapping/Procedure;)[Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2, p1}, Lgnu/kawa/functions/ApplyToArgs;->checkN([Ljava/lang/Object;Lgnu/mapping/CallContext;)V

    .line 77
    return-void
.end method

.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 70
    iget-object v0, p0, Lgnu/kawa/functions/Apply;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    const/4 v1, 0x0

    invoke-static {p1, v1, p0}, Lgnu/kawa/functions/Apply;->getArguments([Ljava/lang/Object;ILgnu/mapping/Procedure;)[Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lgnu/kawa/functions/ApplyToArgs;->applyN([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
