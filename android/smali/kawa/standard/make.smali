.class public Lkawa/standard/make;
.super Lgnu/mapping/ProcedureN;
.source "make.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Lgnu/mapping/ProcedureN;-><init>()V

    return-void
.end method


# virtual methods
.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 12
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 12
    array-length v7, p1

    .line 13
    .local v7, "nargs":I
    if-nez v7, :cond_0

    .line 14
    new-instance v9, Lgnu/mapping/WrongArguments;

    invoke-direct {v9, p0, v7}, Lgnu/mapping/WrongArguments;-><init>(Lgnu/mapping/Procedure;I)V

    throw v9

    .line 15
    :cond_0
    const/4 v9, 0x0

    aget-object v1, p1, v9

    .line 17
    .local v1, "arg_0":Ljava/lang/Object;
    instance-of v9, v1, Ljava/lang/Class;

    if-eqz v9, :cond_1

    move-object v2, v1

    .line 18
    check-cast v2, Ljava/lang/Class;

    .line 23
    .local v2, "clas":Ljava/lang/Class;
    :goto_0
    if-nez v2, :cond_3

    .line 24
    new-instance v9, Lgnu/mapping/WrongType;

    const/4 v10, 0x1

    const-string v11, "class"

    invoke-direct {v9, p0, v10, v1, v11}, Lgnu/mapping/WrongType;-><init>(Lgnu/mapping/Procedure;ILjava/lang/Object;Ljava/lang/String;)V

    throw v9

    .line 19
    .end local v2    # "clas":Ljava/lang/Class;
    :cond_1
    instance-of v9, v1, Lgnu/bytecode/ClassType;

    if-eqz v9, :cond_2

    move-object v9, v1

    .line 20
    check-cast v9, Lgnu/bytecode/ClassType;

    invoke-virtual {v9}, Lgnu/bytecode/ClassType;->getReflectClass()Ljava/lang/Class;

    move-result-object v2

    .restart local v2    # "clas":Ljava/lang/Class;
    goto :goto_0

    .line 22
    .end local v2    # "clas":Ljava/lang/Class;
    :cond_2
    const/4 v2, 0x0

    .restart local v2    # "clas":Ljava/lang/Class;
    goto :goto_0

    .line 28
    :cond_3
    :try_start_0
    invoke-virtual {v2}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    .line 34
    .local v8, "result":Ljava/lang/Object;
    const/4 v4, 0x1

    .local v4, "i":I
    move v5, v4

    .end local v4    # "i":I
    .local v5, "i":I
    :goto_1
    if-ge v5, v7, :cond_4

    .line 36
    add-int/lit8 v4, v5, 0x1

    .end local v5    # "i":I
    .restart local v4    # "i":I
    aget-object v6, p1, v5

    check-cast v6, Lgnu/expr/Keyword;

    .line 37
    .local v6, "key":Lgnu/expr/Keyword;
    add-int/lit8 v5, v4, 0x1

    .end local v4    # "i":I
    .restart local v5    # "i":I
    aget-object v0, p1, v4

    .line 38
    .local v0, "arg":Ljava/lang/Object;
    invoke-virtual {v6}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-static {v0, v9, v8}, Lkawa/lang/Record;->set1(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 30
    .end local v0    # "arg":Ljava/lang/Object;
    .end local v5    # "i":I
    .end local v6    # "key":Lgnu/expr/Keyword;
    .end local v8    # "result":Ljava/lang/Object;
    :catch_0
    move-exception v3

    .line 32
    .local v3, "ex":Ljava/lang/Exception;
    new-instance v9, Lgnu/mapping/WrappedException;

    invoke-direct {v9, v3}, Lgnu/mapping/WrappedException;-><init>(Ljava/lang/Throwable;)V

    throw v9

    .line 40
    .end local v3    # "ex":Ljava/lang/Exception;
    .restart local v5    # "i":I
    .restart local v8    # "result":Ljava/lang/Object;
    :cond_4
    return-object v8
.end method

.method public numArgs()I
    .locals 1

    .prologue
    .line 8
    const/16 v0, -0xfff

    return v0
.end method
