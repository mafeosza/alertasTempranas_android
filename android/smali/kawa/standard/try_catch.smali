.class public Lkawa/standard/try_catch;
.super Ljava/lang/Object;
.source "try_catch.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static rewrite(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/expr/Expression;
    .locals 12
    .param p0, "try_part"    # Ljava/lang/Object;
    .param p1, "clauses"    # Ljava/lang/Object;

    .prologue
    .line 14
    invoke-static {}, Lgnu/expr/Compilation;->getCurrent()Lgnu/expr/Compilation;

    move-result-object v7

    check-cast v7, Lkawa/lang/Translator;

    .line 15
    .local v7, "tr":Lkawa/lang/Translator;
    invoke-virtual {v7, p0}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v8

    .line 16
    .local v8, "try_part_exp":Lgnu/expr/Expression;
    const/4 v5, 0x0

    .line 17
    .local v5, "prev":Lgnu/expr/CatchClause;
    const/4 v1, 0x0

    .local v1, "chain":Lgnu/expr/CatchClause;
    move-object v9, p1

    .line 18
    check-cast v9, Lgnu/lists/FVector;

    .line 19
    .local v9, "vec":Lgnu/lists/FVector;
    invoke-virtual {v9}, Lgnu/lists/FVector;->size()I

    move-result v4

    .line 20
    .local v4, "n":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v4, :cond_3

    .line 22
    sget-object v10, Lkawa/standard/SchemeCompilation;->lambda:Lkawa/lang/Lambda;

    invoke-virtual {v9, v3}, Lgnu/lists/FVector;->get(I)Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v10, v11, v7}, Lkawa/lang/Lambda;->rewrite(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v2

    .line 23
    .local v2, "cl":Lgnu/expr/Expression;
    instance-of v10, v2, Lgnu/expr/ErrorExp;

    if-eqz v10, :cond_0

    .line 39
    .end local v2    # "cl":Lgnu/expr/Expression;
    :goto_1
    return-object v2

    .line 26
    .restart local v2    # "cl":Lgnu/expr/Expression;
    :cond_0
    instance-of v10, v2, Lgnu/expr/LambdaExp;

    if-nez v10, :cond_1

    .line 27
    const-string v10, "internal error with try-catch"

    invoke-virtual {v7, v10}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v2

    goto :goto_1

    .line 28
    :cond_1
    new-instance v0, Lgnu/expr/CatchClause;

    check-cast v2, Lgnu/expr/LambdaExp;

    .end local v2    # "cl":Lgnu/expr/Expression;
    invoke-direct {v0, v2}, Lgnu/expr/CatchClause;-><init>(Lgnu/expr/LambdaExp;)V

    .line 29
    .local v0, "ccl":Lgnu/expr/CatchClause;
    if-nez v5, :cond_2

    .line 30
    move-object v1, v0

    .line 33
    :goto_2
    move-object v5, v0

    .line 20
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 32
    :cond_2
    invoke-virtual {v5, v0}, Lgnu/expr/CatchClause;->setNext(Lgnu/expr/CatchClause;)V

    goto :goto_2

    .line 35
    .end local v0    # "ccl":Lgnu/expr/CatchClause;
    :cond_3
    instance-of v10, v8, Lgnu/expr/ErrorExp;

    if-eqz v10, :cond_4

    move-object v2, v8

    .line 36
    goto :goto_1

    .line 37
    :cond_4
    new-instance v6, Lgnu/expr/TryExp;

    const/4 v10, 0x0

    invoke-direct {v6, v8, v10}, Lgnu/expr/TryExp;-><init>(Lgnu/expr/Expression;Lgnu/expr/Expression;)V

    .line 38
    .local v6, "texp":Lgnu/expr/TryExp;
    invoke-virtual {v6, v1}, Lgnu/expr/TryExp;->setCatchClauses(Lgnu/expr/CatchClause;)V

    move-object v2, v6

    .line 39
    goto :goto_1
.end method
