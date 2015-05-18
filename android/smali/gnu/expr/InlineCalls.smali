.class public Lgnu/expr/InlineCalls;
.super Lgnu/expr/ExpExpVisitor;
.source "InlineCalls.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lgnu/expr/ExpExpVisitor",
        "<",
        "Lgnu/bytecode/Type;",
        ">;"
    }
.end annotation


# static fields
.field private static inlinerMethodArgTypes:[Ljava/lang/Class;


# direct methods
.method public constructor <init>(Lgnu/expr/Compilation;)V
    .locals 0
    .param p1, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 37
    invoke-direct {p0}, Lgnu/expr/ExpExpVisitor;-><init>()V

    .line 38
    invoke-virtual {p0, p1}, Lgnu/expr/InlineCalls;->setContext(Lgnu/expr/Compilation;)V

    .line 39
    return-void
.end method

.method public static checkIntValue(Lgnu/expr/Expression;)Ljava/lang/Integer;
    .locals 4
    .param p0, "exp"    # Lgnu/expr/Expression;

    .prologue
    .line 130
    instance-of v3, p0, Lgnu/expr/QuoteExp;

    if-eqz v3, :cond_0

    move-object v1, p0

    .line 132
    check-cast v1, Lgnu/expr/QuoteExp;

    .line 133
    .local v1, "qarg":Lgnu/expr/QuoteExp;
    invoke-virtual {v1}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v2

    .line 134
    .local v2, "value":Ljava/lang/Object;
    invoke-virtual {v1}, Lgnu/expr/QuoteExp;->isExplicitlyTyped()Z

    move-result v3

    if-nez v3, :cond_0

    instance-of v3, v2, Lgnu/math/IntNum;

    if-eqz v3, :cond_0

    move-object v0, v2

    .line 136
    check-cast v0, Lgnu/math/IntNum;

    .line 137
    .local v0, "ivalue":Lgnu/math/IntNum;
    invoke-virtual {v0}, Lgnu/math/IntNum;->inIntRange()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 138
    invoke-virtual {v0}, Lgnu/math/IntNum;->intValue()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    .line 141
    .end local v0    # "ivalue":Lgnu/math/IntNum;
    .end local v1    # "qarg":Lgnu/expr/QuoteExp;
    .end local v2    # "value":Ljava/lang/Object;
    :goto_0
    return-object v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static checkLongValue(Lgnu/expr/Expression;)Ljava/lang/Long;
    .locals 5
    .param p0, "exp"    # Lgnu/expr/Expression;

    .prologue
    .line 146
    instance-of v3, p0, Lgnu/expr/QuoteExp;

    if-eqz v3, :cond_0

    move-object v1, p0

    .line 148
    check-cast v1, Lgnu/expr/QuoteExp;

    .line 149
    .local v1, "qarg":Lgnu/expr/QuoteExp;
    invoke-virtual {v1}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v2

    .line 150
    .local v2, "value":Ljava/lang/Object;
    invoke-virtual {v1}, Lgnu/expr/QuoteExp;->isExplicitlyTyped()Z

    move-result v3

    if-nez v3, :cond_0

    instance-of v3, v2, Lgnu/math/IntNum;

    if-eqz v3, :cond_0

    move-object v0, v2

    .line 152
    check-cast v0, Lgnu/math/IntNum;

    .line 153
    .local v0, "ivalue":Lgnu/math/IntNum;
    invoke-virtual {v0}, Lgnu/math/IntNum;->inLongRange()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 154
    invoke-virtual {v0}, Lgnu/math/IntNum;->longValue()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    .line 157
    .end local v0    # "ivalue":Lgnu/math/IntNum;
    .end local v1    # "qarg":Lgnu/expr/QuoteExp;
    .end local v2    # "value":Ljava/lang/Object;
    :goto_0
    return-object v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method private static declared-synchronized getInlinerMethodArgTypes()[Ljava/lang/Class;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 407
    const-class v2, Lgnu/expr/InlineCalls;

    monitor-enter v2

    :try_start_0
    sget-object v0, Lgnu/expr/InlineCalls;->inlinerMethodArgTypes:[Ljava/lang/Class;

    .line 408
    .local v0, "t":[Ljava/lang/Class;
    if-nez v0, :cond_0

    .line 410
    const/4 v1, 0x4

    new-array v0, v1, [Ljava/lang/Class;

    .end local v0    # "t":[Ljava/lang/Class;
    const/4 v1, 0x0

    const-string v3, "gnu.expr.ApplyExp"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    aput-object v3, v0, v1

    const/4 v1, 0x1

    const-string v3, "gnu.expr.InlineCalls"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    aput-object v3, v0, v1

    const/4 v1, 0x2

    const-string v3, "gnu.bytecode.Type"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    aput-object v3, v0, v1

    const/4 v1, 0x3

    const-string v3, "gnu.mapping.Procedure"

    invoke-static {v3}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    aput-object v3, v0, v1

    .line 414
    .restart local v0    # "t":[Ljava/lang/Class;
    sput-object v0, Lgnu/expr/InlineCalls;->inlinerMethodArgTypes:[Ljava/lang/Class;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 416
    :cond_0
    monitor-exit v2

    return-object v0

    .line 407
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static inlineCall(Lgnu/expr/LambdaExp;[Lgnu/expr/Expression;Z)Lgnu/expr/Expression;
    .locals 14
    .param p0, "lexp"    # Lgnu/expr/LambdaExp;
    .param p1, "args"    # [Lgnu/expr/Expression;
    .param p2, "makeCopy"    # Z

    .prologue
    .line 492
    iget-object v11, p0, Lgnu/expr/LambdaExp;->keywords:[Lgnu/expr/Keyword;

    if-nez v11, :cond_0

    iget-object v11, p0, Lgnu/expr/LambdaExp;->nameDecl:Lgnu/expr/Declaration;

    if-eqz v11, :cond_1

    if-nez p2, :cond_1

    .line 497
    :cond_0
    const/4 v4, 0x0

    .line 587
    :goto_0
    return-object v4

    .line 498
    :cond_1
    iget v11, p0, Lgnu/expr/LambdaExp;->max_args:I

    if-gez v11, :cond_4

    const/4 v9, 0x1

    .line 499
    .local v9, "varArgs":Z
    :goto_1
    iget v11, p0, Lgnu/expr/LambdaExp;->min_args:I

    iget v12, p0, Lgnu/expr/LambdaExp;->max_args:I

    if-ne v11, v12, :cond_2

    iget v11, p0, Lgnu/expr/LambdaExp;->min_args:I

    array-length v12, p1

    if-eq v11, v12, :cond_3

    :cond_2
    if-eqz v9, :cond_d

    iget v11, p0, Lgnu/expr/LambdaExp;->min_args:I

    if-nez v11, :cond_d

    .line 503
    :cond_3
    const/4 v8, 0x0

    .line 504
    .local v8, "prev":Lgnu/expr/Declaration;
    const/4 v2, 0x0

    .line 507
    .local v2, "i":I
    if-eqz p2, :cond_5

    .line 509
    new-instance v5, Lgnu/kawa/util/IdentityHashTable;

    invoke-direct {v5}, Lgnu/kawa/util/IdentityHashTable;-><init>()V

    .line 510
    .local v5, "mapper":Lgnu/kawa/util/IdentityHashTable;
    invoke-static {p1, v5}, Lgnu/expr/Expression;->deepCopy([Lgnu/expr/Expression;Lgnu/kawa/util/IdentityHashTable;)[Lgnu/expr/Expression;

    move-result-object v1

    .line 511
    .local v1, "cargs":[Lgnu/expr/Expression;
    if-nez v1, :cond_6

    if-eqz p1, :cond_6

    .line 512
    const/4 v4, 0x0

    goto :goto_0

    .line 498
    .end local v1    # "cargs":[Lgnu/expr/Expression;
    .end local v2    # "i":I
    .end local v5    # "mapper":Lgnu/kawa/util/IdentityHashTable;
    .end local v8    # "prev":Lgnu/expr/Declaration;
    .end local v9    # "varArgs":Z
    :cond_4
    const/4 v9, 0x0

    goto :goto_1

    .line 516
    .restart local v2    # "i":I
    .restart local v8    # "prev":Lgnu/expr/Declaration;
    .restart local v9    # "varArgs":Z
    :cond_5
    const/4 v5, 0x0

    .line 517
    .restart local v5    # "mapper":Lgnu/kawa/util/IdentityHashTable;
    move-object v1, p1

    .line 519
    .restart local v1    # "cargs":[Lgnu/expr/Expression;
    :cond_6
    if-eqz v9, :cond_7

    .line 521
    array-length v11, p1

    add-int/lit8 v11, v11, 0x1

    new-array v10, v11, [Lgnu/expr/Expression;

    .line 522
    .local v10, "xargs":[Lgnu/expr/Expression;
    const/4 v11, 0x0

    invoke-virtual {p0}, Lgnu/expr/LambdaExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v12

    iget-object v12, v12, Lgnu/expr/Declaration;->type:Lgnu/bytecode/Type;

    invoke-static {v12}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v12

    aput-object v12, v10, v11

    .line 523
    const/4 v11, 0x0

    const/4 v12, 0x1

    array-length v13, p1

    invoke-static {p1, v11, v10, v12, v13}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 524
    const/4 v11, 0x1

    new-array v1, v11, [Lgnu/expr/Expression;

    .end local v1    # "cargs":[Lgnu/expr/Expression;
    const/4 v11, 0x0

    new-instance v12, Lgnu/expr/ApplyExp;

    sget-object v13, Lgnu/kawa/reflect/Invoke;->make:Lgnu/kawa/reflect/Invoke;

    invoke-direct {v12, v13, v10}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    aput-object v12, v1, v11

    .line 526
    .end local v10    # "xargs":[Lgnu/expr/Expression;
    .restart local v1    # "cargs":[Lgnu/expr/Expression;
    :cond_7
    new-instance v4, Lgnu/expr/LetExp;

    invoke-direct {v4, v1}, Lgnu/expr/LetExp;-><init>([Lgnu/expr/Expression;)V

    .line 527
    .local v4, "let":Lgnu/expr/LetExp;
    invoke-virtual {p0}, Lgnu/expr/LambdaExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v7

    .local v7, "param":Lgnu/expr/Declaration;
    :goto_2
    if-eqz v7, :cond_b

    .line 529
    invoke-virtual {v7}, Lgnu/expr/Declaration;->nextDecl()Lgnu/expr/Declaration;

    move-result-object v6

    .line 530
    .local v6, "next":Lgnu/expr/Declaration;
    if-eqz p2, :cond_a

    .line 532
    iget-object v11, v7, Lgnu/expr/Declaration;->symbol:Ljava/lang/Object;

    iget-object v12, v7, Lgnu/expr/Declaration;->type:Lgnu/bytecode/Type;

    invoke-virtual {v4, v11, v12}, Lgnu/expr/LetExp;->addDeclaration(Ljava/lang/Object;Lgnu/bytecode/Type;)Lgnu/expr/Declaration;

    move-result-object v3

    .line 533
    .local v3, "ldecl":Lgnu/expr/Declaration;
    iget-object v11, v7, Lgnu/expr/Declaration;->typeExp:Lgnu/expr/Expression;

    if-eqz v11, :cond_8

    .line 535
    iget-object v11, v7, Lgnu/expr/Declaration;->typeExp:Lgnu/expr/Expression;

    invoke-static {v11}, Lgnu/expr/Expression;->deepCopy(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v11

    iput-object v11, v3, Lgnu/expr/Declaration;->typeExp:Lgnu/expr/Expression;

    .line 536
    iget-object v11, v3, Lgnu/expr/Declaration;->typeExp:Lgnu/expr/Expression;

    if-nez v11, :cond_8

    .line 537
    const/4 v4, 0x0

    goto :goto_0

    .line 540
    :cond_8
    invoke-virtual {v5, v7, v3}, Lgnu/kawa/util/IdentityHashTable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 547
    .end local v3    # "ldecl":Lgnu/expr/Declaration;
    :goto_3
    if-nez v9, :cond_9

    .line 549
    invoke-virtual {v7}, Lgnu/expr/Declaration;->getCanWrite()Z

    move-result v11

    if-nez v11, :cond_9

    .line 550
    aget-object v11, v1, v2

    invoke-virtual {v7, v11}, Lgnu/expr/Declaration;->setValue(Lgnu/expr/Expression;)V

    .line 552
    :cond_9
    move-object v8, v7

    .line 553
    move-object v7, v6

    .line 527
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 544
    :cond_a
    invoke-virtual {p0, v8, v7}, Lgnu/expr/LambdaExp;->remove(Lgnu/expr/Declaration;Lgnu/expr/Declaration;)V

    .line 545
    invoke-virtual {v4, v8, v7}, Lgnu/expr/LetExp;->add(Lgnu/expr/Declaration;Lgnu/expr/Declaration;)V

    goto :goto_3

    .line 562
    .end local v6    # "next":Lgnu/expr/Declaration;
    :cond_b
    iget-object v0, p0, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    .line 563
    .local v0, "body":Lgnu/expr/Expression;
    if-eqz p2, :cond_c

    .line 565
    invoke-static {v0, v5}, Lgnu/expr/Expression;->deepCopy(Lgnu/expr/Expression;Lgnu/kawa/util/IdentityHashTable;)Lgnu/expr/Expression;

    move-result-object v0

    .line 566
    if-nez v0, :cond_c

    iget-object v11, p0, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    if-eqz v11, :cond_c

    .line 567
    const/4 v4, 0x0

    goto/16 :goto_0

    .line 569
    :cond_c
    iput-object v0, v4, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    goto/16 :goto_0

    .line 587
    .end local v0    # "body":Lgnu/expr/Expression;
    .end local v1    # "cargs":[Lgnu/expr/Expression;
    .end local v2    # "i":I
    .end local v4    # "let":Lgnu/expr/LetExp;
    .end local v5    # "mapper":Lgnu/kawa/util/IdentityHashTable;
    .end local v7    # "param":Lgnu/expr/Declaration;
    .end local v8    # "prev":Lgnu/expr/Declaration;
    :cond_d
    const/4 v4, 0x0

    goto/16 :goto_0
.end method

.method public static inlineCalls(Lgnu/expr/Expression;Lgnu/expr/Compilation;)Lgnu/expr/Expression;
    .locals 2
    .param p0, "exp"    # Lgnu/expr/Expression;
    .param p1, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 32
    new-instance v0, Lgnu/expr/InlineCalls;

    invoke-direct {v0, p1}, Lgnu/expr/InlineCalls;-><init>(Lgnu/expr/Compilation;)V

    .line 33
    .local v0, "visitor":Lgnu/expr/InlineCalls;
    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public checkType(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 13
    .param p1, "exp"    # Lgnu/expr/Expression;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    const/4 v3, 0x1

    const/4 v10, 0x0

    .line 54
    invoke-virtual {p1}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v2

    .line 56
    .local v2, "expType":Lgnu/bytecode/Type;
    instance-of v9, p2, Lgnu/bytecode/ClassType;

    if-eqz v9, :cond_3

    move-object v9, p2

    check-cast v9, Lgnu/bytecode/ClassType;

    invoke-virtual {v9}, Lgnu/bytecode/ClassType;->isInterface()Z

    move-result v9

    if-eqz v9, :cond_3

    sget-object v9, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    invoke-virtual {v2, v9}, Lgnu/bytecode/Type;->isSubtype(Lgnu/bytecode/Type;)Z

    move-result v9

    if-eqz v9, :cond_3

    invoke-virtual {v2, p2}, Lgnu/bytecode/Type;->isSubtype(Lgnu/bytecode/Type;)Z

    move-result v9

    if-nez v9, :cond_3

    .line 60
    instance-of v9, p1, Lgnu/expr/LambdaExp;

    if-eqz v9, :cond_0

    move-object v9, p2

    .line 62
    check-cast v9, Lgnu/bytecode/ClassType;

    invoke-virtual {v9}, Lgnu/bytecode/ClassType;->checkSingleAbstractMethod()Lgnu/bytecode/Method;

    move-result-object v0

    .line 63
    .local v0, "amethod":Lgnu/bytecode/Method;
    if-eqz v0, :cond_0

    move-object v5, p1

    .line 65
    check-cast v5, Lgnu/expr/LambdaExp;

    .line 66
    .local v5, "lexp":Lgnu/expr/LambdaExp;
    new-instance v8, Lgnu/expr/ObjectExp;

    invoke-direct {v8}, Lgnu/expr/ObjectExp;-><init>()V

    .line 67
    .local v8, "oexp":Lgnu/expr/ObjectExp;
    invoke-virtual {v8, p1}, Lgnu/expr/ObjectExp;->setLocation(Lgnu/text/SourceLocator;)V

    .line 68
    new-array v9, v3, [Lgnu/expr/Expression;

    new-instance v11, Lgnu/expr/QuoteExp;

    invoke-direct {v11, p2}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v11, v9, v10

    iput-object v9, v8, Lgnu/expr/ObjectExp;->supers:[Lgnu/expr/Expression;

    .line 69
    invoke-virtual {p0}, Lgnu/expr/InlineCalls;->getCompilation()Lgnu/expr/Compilation;

    move-result-object v9

    invoke-virtual {v8, v9}, Lgnu/expr/ObjectExp;->setTypes(Lgnu/expr/Compilation;)V

    .line 70
    invoke-virtual {v0}, Lgnu/bytecode/Method;->getName()Ljava/lang/String;

    move-result-object v7

    .line 71
    .local v7, "mname":Ljava/lang/String;
    invoke-virtual {v8, v5, v7}, Lgnu/expr/ObjectExp;->addMethod(Lgnu/expr/LambdaExp;Ljava/lang/Object;)Lgnu/expr/Declaration;

    .line 72
    sget-object v9, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    invoke-virtual {v8, v7, v9}, Lgnu/expr/ObjectExp;->addDeclaration(Ljava/lang/Object;Lgnu/bytecode/Type;)Lgnu/expr/Declaration;

    move-result-object v6

    .line 73
    .local v6, "mdecl":Lgnu/expr/Declaration;
    iput-object v5, v8, Lgnu/expr/ObjectExp;->firstChild:Lgnu/expr/LambdaExp;

    .line 74
    iget-object v9, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    invoke-virtual {v8, v9}, Lgnu/expr/ObjectExp;->declareParts(Lgnu/expr/Compilation;)V

    .line 75
    invoke-virtual {p0, v8, p2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v1

    .line 100
    .end local v0    # "amethod":Lgnu/bytecode/Method;
    .end local v5    # "lexp":Lgnu/expr/LambdaExp;
    .end local v6    # "mdecl":Lgnu/expr/Declaration;
    .end local v7    # "mname":Ljava/lang/String;
    .end local v8    # "oexp":Lgnu/expr/ObjectExp;
    :goto_0
    return-object v1

    .line 78
    :cond_0
    const/4 v3, 0x1

    .line 92
    .local v3, "incompatible":Z
    :cond_1
    if-eqz v3, :cond_2

    .line 94
    iget-object v9, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    invoke-virtual {v9}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v4

    .line 95
    .local v4, "language":Lgnu/expr/Language;
    iget-object v9, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    const/16 v10, 0x77

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "type "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v4, v2}, Lgnu/expr/Language;->formatType(Lgnu/bytecode/Type;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " is incompatible with required type "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v4, p2}, Lgnu/expr/Language;->formatType(Lgnu/bytecode/Type;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v10, v11, p1}, Lgnu/expr/Compilation;->error(CLjava/lang/String;Lgnu/text/SourceLocator;)V

    .end local v4    # "language":Lgnu/expr/Language;
    :cond_2
    move-object v1, p1

    .line 100
    goto :goto_0

    .line 82
    .end local v3    # "incompatible":Z
    :cond_3
    sget-object v9, Lgnu/bytecode/Type;->toStringType:Lgnu/bytecode/ClassType;

    if-ne v2, v9, :cond_4

    .line 83
    sget-object v2, Lgnu/bytecode/Type;->javalangStringType:Lgnu/bytecode/ClassType;

    .line 84
    :cond_4
    if-eqz p2, :cond_5

    invoke-virtual {p2, v2}, Lgnu/bytecode/Type;->compare(Lgnu/bytecode/Type;)I

    move-result v9

    const/4 v11, -0x3

    if-ne v9, v11, :cond_5

    .line 85
    .restart local v3    # "incompatible":Z
    :goto_1
    if-eqz v3, :cond_1

    instance-of v9, p2, Lgnu/expr/TypeValue;

    if-eqz v9, :cond_1

    move-object v9, p2

    .line 87
    check-cast v9, Lgnu/expr/TypeValue;

    invoke-interface {v9, p1}, Lgnu/expr/TypeValue;->convertValue(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v1

    .line 88
    .local v1, "converted":Lgnu/expr/Expression;
    if-eqz v1, :cond_1

    goto :goto_0

    .end local v1    # "converted":Lgnu/expr/Expression;
    .end local v3    # "incompatible":Z
    :cond_5
    move v3, v10

    .line 84
    goto :goto_1
.end method

.method public fixIntValue(Lgnu/expr/Expression;)Lgnu/expr/QuoteExp;
    .locals 4
    .param p1, "exp"    # Lgnu/expr/Expression;

    .prologue
    .line 162
    invoke-static {p1}, Lgnu/expr/InlineCalls;->checkIntValue(Lgnu/expr/Expression;)Ljava/lang/Integer;

    move-result-object v0

    .line 163
    .local v0, "ival":Ljava/lang/Integer;
    if-eqz v0, :cond_0

    .line 164
    new-instance v1, Lgnu/expr/QuoteExp;

    iget-object v2, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    invoke-virtual {v2}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v2

    sget-object v3, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    invoke-virtual {v2, v3}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;Lgnu/bytecode/Type;)V

    .line 165
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public fixLongValue(Lgnu/expr/Expression;)Lgnu/expr/QuoteExp;
    .locals 4
    .param p1, "exp"    # Lgnu/expr/Expression;

    .prologue
    .line 170
    invoke-static {p1}, Lgnu/expr/InlineCalls;->checkLongValue(Lgnu/expr/Expression;)Ljava/lang/Long;

    move-result-object v0

    .line 171
    .local v0, "ival":Ljava/lang/Long;
    if-eqz v0, :cond_0

    .line 172
    new-instance v1, Lgnu/expr/QuoteExp;

    iget-object v2, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    invoke-virtual {v2}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v2

    sget-object v3, Ljava/lang/Long;->TYPE:Ljava/lang/Class;

    invoke-virtual {v2, v3}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;Lgnu/bytecode/Type;)V

    .line 173
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public maybeInline(Lgnu/expr/ApplyExp;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
    .locals 14
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    .line 425
    :try_start_0
    monitor-enter p3
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 427
    :try_start_1
    sget-object v10, Lgnu/mapping/Procedure;->validateApplyKey:Lgnu/mapping/Symbol;

    const/4 v11, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v10, v11}, Lgnu/mapping/Procedure;->getProperty(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 428
    .local v5, "inliner":Ljava/lang/Object;
    instance-of v10, v5, Ljava/lang/String;

    if-eqz v10, :cond_2

    .line 430
    move-object v0, v5

    check-cast v0, Ljava/lang/String;

    move-object v6, v0

    .line 431
    .local v6, "inliners":Ljava/lang/String;
    const/16 v10, 0x3a

    invoke-virtual {v6, v10}, Ljava/lang/String;->indexOf(I)I

    move-result v3

    .line 435
    .local v3, "colon":I
    const/4 v7, 0x0

    .line 437
    .local v7, "method":Ljava/lang/reflect/Method;
    if-lez v3, :cond_0

    .line 439
    const/4 v10, 0x0

    invoke-virtual {v6, v10, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 440
    .local v2, "cname":Ljava/lang/String;
    add-int/lit8 v10, v3, 0x1

    invoke-virtual {v6, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    .line 441
    .local v8, "mname":Ljava/lang/String;
    const/4 v10, 0x1

    invoke-virtual/range {p3 .. p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v11

    invoke-static {v2, v10, v11}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v1

    .line 445
    .local v1, "clas":Ljava/lang/Class;
    invoke-static {}, Lgnu/expr/InlineCalls;->getInlinerMethodArgTypes()[Ljava/lang/Class;

    move-result-object v10

    invoke-virtual {v1, v8, v10}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v7

    .line 448
    .end local v1    # "clas":Ljava/lang/Class;
    .end local v2    # "cname":Ljava/lang/String;
    .end local v8    # "mname":Ljava/lang/String;
    :cond_0
    if-nez v7, :cond_1

    .line 450
    const/16 v10, 0x65

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "inliner property string for "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    move-object/from16 v0, p3

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " is not of the form CLASS:METHOD"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {p0, v10, v11}, Lgnu/expr/InlineCalls;->error(CLjava/lang/String;)V

    .line 451
    const/4 v10, 0x0

    monitor-exit p3

    .line 478
    .end local v3    # "colon":I
    .end local v5    # "inliner":Ljava/lang/Object;
    .end local v6    # "inliners":Ljava/lang/String;
    .end local v7    # "method":Ljava/lang/reflect/Method;
    :goto_0
    return-object v10

    .line 453
    .restart local v3    # "colon":I
    .restart local v5    # "inliner":Ljava/lang/Object;
    .restart local v6    # "inliners":Ljava/lang/String;
    .restart local v7    # "method":Ljava/lang/reflect/Method;
    :cond_1
    move-object v5, v7

    .line 455
    .end local v3    # "colon":I
    .end local v5    # "inliner":Ljava/lang/Object;
    .end local v6    # "inliners":Ljava/lang/String;
    .end local v7    # "method":Ljava/lang/reflect/Method;
    :cond_2
    monitor-exit p3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 456
    if-eqz v5, :cond_4

    .line 462
    const/4 v10, 0x4

    :try_start_2
    new-array v9, v10, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object p1, v9, v10

    const/4 v10, 0x1

    aput-object p0, v9, v10

    const/4 v10, 0x2

    aput-object p2, v9, v10

    const/4 v10, 0x3

    aput-object p3, v9, v10

    .line 463
    .local v9, "vargs":[Ljava/lang/Object;
    instance-of v10, v5, Lgnu/mapping/Procedure;

    if-eqz v10, :cond_5

    .line 464
    check-cast v5, Lgnu/mapping/Procedure;

    invoke-virtual {v5, v9}, Lgnu/mapping/Procedure;->applyN([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lgnu/expr/Expression;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 455
    .end local v9    # "vargs":[Ljava/lang/Object;
    :catchall_0
    move-exception v10

    :try_start_3
    monitor-exit p3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v10
    :try_end_4
    .catch Ljava/lang/Throwable; {:try_start_4 .. :try_end_4} :catch_0

    .line 472
    :catch_0
    move-exception v4

    .line 474
    .local v4, "ex":Ljava/lang/Throwable;
    instance-of v10, v4, Ljava/lang/reflect/InvocationTargetException;

    if-eqz v10, :cond_3

    .line 475
    check-cast v4, Ljava/lang/reflect/InvocationTargetException;

    .end local v4    # "ex":Ljava/lang/Throwable;
    invoke-virtual {v4}, Ljava/lang/reflect/InvocationTargetException;->getTargetException()Ljava/lang/Throwable;

    move-result-object v4

    .line 476
    .restart local v4    # "ex":Ljava/lang/Throwable;
    :cond_3
    iget-object v10, p0, Lgnu/expr/InlineCalls;->messages:Lgnu/text/SourceMessages;

    const/16 v11, 0x65

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "caught exception in inliner for "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    move-object/from16 v0, p3

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " - "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v10, v11, v12, v4}, Lgnu/text/SourceMessages;->error(CLjava/lang/String;Ljava/lang/Throwable;)V

    .line 478
    .end local v4    # "ex":Ljava/lang/Throwable;
    :cond_4
    const/4 v10, 0x0

    goto :goto_0

    .line 466
    .restart local v9    # "vargs":[Ljava/lang/Object;
    :cond_5
    :try_start_5
    instance-of v10, v5, Ljava/lang/reflect/Method;

    if-eqz v10, :cond_4

    .line 467
    check-cast v5, Ljava/lang/reflect/Method;

    const/4 v10, 0x0

    invoke-virtual {v5, v10, v9}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lgnu/expr/Expression;
    :try_end_5
    .catch Ljava/lang/Throwable; {:try_start_5 .. :try_end_5} :catch_0

    goto :goto_0
.end method

.method public visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 2
    .param p1, "exp"    # Lgnu/expr/Expression;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    const/4 v1, 0x1

    .line 43
    invoke-virtual {p1, v1}, Lgnu/expr/Expression;->getFlag(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 45
    invoke-virtual {p1, v1}, Lgnu/expr/Expression;->setFlag(I)V

    .line 46
    invoke-super {p0, p1, p2}, Lgnu/expr/ExpExpVisitor;->visit(Lgnu/expr/Expression;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p1

    .end local p1    # "exp":Lgnu/expr/Expression;
    check-cast p1, Lgnu/expr/Expression;

    .line 47
    .restart local p1    # "exp":Lgnu/expr/Expression;
    invoke-virtual {p1, v1}, Lgnu/expr/Expression;->setFlag(I)V

    .line 49
    :cond_0
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->checkType(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic visit(Lgnu/expr/Expression;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/Expression;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitApplyExp(Lgnu/expr/ApplyExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 7
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    const/4 v6, 0x0

    .line 105
    iget-object v0, p1, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    .line 110
    .local v0, "func":Lgnu/expr/Expression;
    instance-of v3, v0, Lgnu/expr/LambdaExp;

    if-eqz v3, :cond_0

    move-object v2, v0

    .line 112
    check-cast v2, Lgnu/expr/LambdaExp;

    .local v2, "lexp":Lgnu/expr/LambdaExp;
    move-object v3, v0

    .line 113
    check-cast v3, Lgnu/expr/LambdaExp;

    iget-object v4, p1, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    const/4 v5, 0x0

    invoke-static {v3, v4, v5}, Lgnu/expr/InlineCalls;->inlineCall(Lgnu/expr/LambdaExp;[Lgnu/expr/Expression;Z)Lgnu/expr/Expression;

    move-result-object v1

    .line 114
    .local v1, "inlined":Lgnu/expr/Expression;
    if-eqz v1, :cond_0

    .line 115
    invoke-virtual {p0, v1, p2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v3

    .line 119
    .end local v1    # "inlined":Lgnu/expr/Expression;
    .end local v2    # "lexp":Lgnu/expr/LambdaExp;
    :goto_0
    return-object v3

    .line 117
    :cond_0
    invoke-virtual {p0, v0, v6}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    .line 118
    iput-object v0, p1, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    .line 119
    invoke-virtual {v0, p1, p0, p2, v6}, Lgnu/expr/Expression;->validateApply(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/expr/Declaration;)Lgnu/expr/Expression;

    move-result-object v3

    goto :goto_0
.end method

.method protected bridge synthetic visitApplyExp(Lgnu/expr/ApplyExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/ApplyExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitApplyExp(Lgnu/expr/ApplyExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method public final visitApplyOnly(Lgnu/expr/ApplyExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 2
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    .line 125
    iget-object v0, p1, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, p0, p2, v1}, Lgnu/expr/Expression;->validateApply(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/expr/Declaration;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitBeginExp(Lgnu/expr/BeginExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 5
    .param p1, "exp"    # Lgnu/expr/BeginExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    .line 269
    iget v2, p1, Lgnu/expr/BeginExp;->length:I

    add-int/lit8 v1, v2, -0x1

    .line 270
    .local v1, "last":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-gt v0, v1, :cond_1

    .line 272
    iget-object v3, p1, Lgnu/expr/BeginExp;->exps:[Lgnu/expr/Expression;

    iget-object v2, p1, Lgnu/expr/BeginExp;->exps:[Lgnu/expr/Expression;

    aget-object v4, v2, v0

    if-ge v0, v1, :cond_0

    const/4 v2, 0x0

    :goto_1
    invoke-virtual {p0, v4, v2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v2

    aput-object v2, v3, v0

    .line 270
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_0
    move-object v2, p2

    .line 272
    goto :goto_1

    .line 274
    :cond_1
    return-object p1
.end method

.method protected bridge synthetic visitBeginExp(Lgnu/expr/BeginExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/BeginExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitBeginExp(Lgnu/expr/BeginExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitIfExp(Lgnu/expr/IfExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 8
    .param p1, "exp"    # Lgnu/expr/IfExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    .line 237
    iget-object v4, p1, Lgnu/expr/IfExp;->test:Lgnu/expr/Expression;

    const/4 v5, 0x0

    invoke-virtual {v4, p0, v5}, Lgnu/expr/Expression;->visit(Lgnu/expr/ExpVisitor;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lgnu/expr/Expression;

    .line 238
    .local v1, "test":Lgnu/expr/Expression;
    instance-of v4, v1, Lgnu/expr/ReferenceExp;

    if-eqz v4, :cond_0

    move-object v4, v1

    .line 240
    check-cast v4, Lgnu/expr/ReferenceExp;

    invoke-virtual {v4}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v0

    .line 241
    .local v0, "decl":Lgnu/expr/Declaration;
    if-eqz v0, :cond_0

    .line 243
    invoke-virtual {v0}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v3

    .line 244
    .local v3, "value":Lgnu/expr/Expression;
    instance-of v4, v3, Lgnu/expr/QuoteExp;

    if-eqz v4, :cond_0

    sget-object v4, Lgnu/expr/QuoteExp;->undefined_exp:Lgnu/expr/QuoteExp;

    if-eq v3, v4, :cond_0

    .line 245
    move-object v1, v3

    .line 248
    .end local v0    # "decl":Lgnu/expr/Declaration;
    .end local v3    # "value":Lgnu/expr/Expression;
    :cond_0
    iput-object v1, p1, Lgnu/expr/IfExp;->test:Lgnu/expr/Expression;

    .line 249
    iget-object v4, p0, Lgnu/expr/InlineCalls;->exitValue:Ljava/lang/Object;

    if-nez v4, :cond_1

    .line 250
    iget-object v4, p1, Lgnu/expr/IfExp;->then_clause:Lgnu/expr/Expression;

    invoke-virtual {p0, v4, p2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v4

    iput-object v4, p1, Lgnu/expr/IfExp;->then_clause:Lgnu/expr/Expression;

    .line 251
    :cond_1
    iget-object v4, p0, Lgnu/expr/InlineCalls;->exitValue:Ljava/lang/Object;

    if-nez v4, :cond_2

    iget-object v4, p1, Lgnu/expr/IfExp;->else_clause:Lgnu/expr/Expression;

    if-eqz v4, :cond_2

    .line 252
    iget-object v4, p1, Lgnu/expr/IfExp;->else_clause:Lgnu/expr/Expression;

    invoke-virtual {p0, v4, p2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v4

    iput-object v4, p1, Lgnu/expr/IfExp;->else_clause:Lgnu/expr/Expression;

    .line 253
    :cond_2
    instance-of v4, v1, Lgnu/expr/QuoteExp;

    if-eqz v4, :cond_4

    .line 255
    iget-object v4, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    invoke-virtual {v4}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v4

    check-cast v1, Lgnu/expr/QuoteExp;

    .end local v1    # "test":Lgnu/expr/Expression;
    invoke-virtual {v1}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Lgnu/expr/Language;->isTrue(Ljava/lang/Object;)Z

    move-result v2

    .line 256
    .local v2, "truth":Z
    invoke-virtual {p1, v2}, Lgnu/expr/IfExp;->select(Z)Lgnu/expr/Expression;

    move-result-object p1

    .line 264
    .end local v2    # "truth":Z
    .end local p1    # "exp":Lgnu/expr/IfExp;
    :cond_3
    :goto_0
    return-object p1

    .line 258
    .restart local v1    # "test":Lgnu/expr/Expression;
    .restart local p1    # "exp":Lgnu/expr/IfExp;
    :cond_4
    invoke-virtual {v1}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v4

    invoke-virtual {v4}, Lgnu/bytecode/Type;->isVoid()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 260
    iget-object v4, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    invoke-virtual {v4}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v4

    sget-object v5, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    invoke-virtual {v4, v5}, Lgnu/expr/Language;->isTrue(Ljava/lang/Object;)Z

    move-result v2

    .line 261
    .restart local v2    # "truth":Z
    iget-object v4, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    const/16 v5, 0x77

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "void-valued condition is always "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 262
    new-instance v4, Lgnu/expr/BeginExp;

    invoke-virtual {p1, v2}, Lgnu/expr/IfExp;->select(Z)Lgnu/expr/Expression;

    move-result-object v5

    invoke-direct {v4, v1, v5}, Lgnu/expr/BeginExp;-><init>(Lgnu/expr/Expression;Lgnu/expr/Expression;)V

    move-object p1, v4

    goto :goto_0
.end method

.method protected bridge synthetic visitIfExp(Lgnu/expr/IfExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/IfExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitIfExp(Lgnu/expr/IfExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitLambdaExp(Lgnu/expr/LambdaExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 2
    .param p1, "exp"    # Lgnu/expr/LambdaExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    .line 343
    invoke-virtual {p1}, Lgnu/expr/LambdaExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v0

    .line 344
    .local v0, "firstDecl":Lgnu/expr/Declaration;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lgnu/expr/Declaration;->isThisParameter()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Lgnu/expr/LambdaExp;->isClassMethod()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, v0, Lgnu/expr/Declaration;->type:Lgnu/bytecode/Type;

    if-nez v1, :cond_0

    .line 347
    iget-object v1, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    iget-object v1, v1, Lgnu/expr/Compilation;->mainClass:Lgnu/bytecode/ClassType;

    invoke-virtual {v0, v1}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 349
    :cond_0
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitScopeExp(Lgnu/expr/ScopeExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v1

    return-object v1
.end method

.method protected bridge synthetic visitLambdaExp(Lgnu/expr/LambdaExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/LambdaExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitLambdaExp(Lgnu/expr/LambdaExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitLetExp(Lgnu/expr/LetExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 13
    .param p1, "exp"    # Lgnu/expr/LetExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    .line 298
    invoke-virtual {p1}, Lgnu/expr/LetExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v1

    .line 299
    .local v1, "decl":Lgnu/expr/Declaration;
    iget-object v11, p1, Lgnu/expr/LetExp;->inits:[Lgnu/expr/Expression;

    array-length v7, v11

    .line 300
    .local v7, "n":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v7, :cond_2

    .line 302
    iget-object v11, p1, Lgnu/expr/LetExp;->inits:[Lgnu/expr/Expression;

    aget-object v6, v11, v4

    .line 303
    .local v6, "init0":Lgnu/expr/Expression;
    const-wide/16 v11, 0x2000

    invoke-virtual {v1, v11, v12}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v10

    .line 304
    .local v10, "typeSpecified":Z
    if-eqz v10, :cond_1

    sget-object v11, Lgnu/expr/QuoteExp;->undefined_exp:Lgnu/expr/QuoteExp;

    if-eq v6, v11, :cond_1

    invoke-virtual {v1}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v2

    .line 305
    .local v2, "dtype":Lgnu/bytecode/Type;
    :goto_1
    invoke-virtual {p0, v6, v2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v5

    .line 306
    .local v5, "init":Lgnu/expr/Expression;
    iget-object v11, p1, Lgnu/expr/LetExp;->inits:[Lgnu/expr/Expression;

    aput-object v5, v11, v4

    .line 307
    iget-object v3, v1, Lgnu/expr/Declaration;->value:Lgnu/expr/Expression;

    .line 308
    .local v3, "dvalue":Lgnu/expr/Expression;
    if-ne v3, v6, :cond_0

    .line 310
    move-object v3, v5

    iput-object v5, v1, Lgnu/expr/Declaration;->value:Lgnu/expr/Expression;

    .line 311
    if-nez v10, :cond_0

    .line 312
    invoke-virtual {v3}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v11

    invoke-virtual {v1, v11}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 300
    :cond_0
    add-int/lit8 v4, v4, 0x1

    invoke-virtual {v1}, Lgnu/expr/Declaration;->nextDecl()Lgnu/expr/Declaration;

    move-result-object v1

    goto :goto_0

    .line 304
    .end local v2    # "dtype":Lgnu/bytecode/Type;
    .end local v3    # "dvalue":Lgnu/expr/Expression;
    .end local v5    # "init":Lgnu/expr/Expression;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    .line 316
    .end local v6    # "init0":Lgnu/expr/Expression;
    .end local v10    # "typeSpecified":Z
    :cond_2
    iget-object v11, p0, Lgnu/expr/InlineCalls;->exitValue:Ljava/lang/Object;

    if-nez v11, :cond_3

    .line 317
    iget-object v11, p1, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    invoke-virtual {p0, v11, p2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v11

    iput-object v11, p1, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    .line 318
    :cond_3
    iget-object v11, p1, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    instance-of v11, v11, Lgnu/expr/ReferenceExp;

    if-eqz v11, :cond_5

    .line 320
    iget-object v8, p1, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    check-cast v8, Lgnu/expr/ReferenceExp;

    .line 321
    .local v8, "ref":Lgnu/expr/ReferenceExp;
    invoke-virtual {v8}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v0

    .line 322
    .local v0, "d":Lgnu/expr/Declaration;
    if-eqz v0, :cond_5

    iget-object v11, v0, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    if-ne v11, p1, :cond_5

    invoke-virtual {v8}, Lgnu/expr/ReferenceExp;->getDontDereference()Z

    move-result v11

    if-nez v11, :cond_5

    .line 324
    const/4 v11, 0x1

    if-ne v7, v11, :cond_5

    .line 326
    iget-object v11, p1, Lgnu/expr/LetExp;->inits:[Lgnu/expr/Expression;

    const/4 v12, 0x0

    aget-object v5, v11, v12

    .line 327
    .restart local v5    # "init":Lgnu/expr/Expression;
    invoke-virtual {v0}, Lgnu/expr/Declaration;->getTypeExp()Lgnu/expr/Expression;

    move-result-object v9

    .line 330
    .local v9, "texp":Lgnu/expr/Expression;
    sget-object v11, Lgnu/expr/QuoteExp;->classObjectExp:Lgnu/expr/QuoteExp;

    if-eq v9, v11, :cond_4

    .line 331
    invoke-static {v5, v9}, Lgnu/expr/Compilation;->makeCoercion(Lgnu/expr/Expression;Lgnu/expr/Expression;)Lgnu/expr/ApplyExp;

    move-result-object v11

    const/4 v12, 0x0

    invoke-virtual {p0, v11, v12}, Lgnu/expr/InlineCalls;->visitApplyOnly(Lgnu/expr/ApplyExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v5

    .line 338
    .end local v0    # "d":Lgnu/expr/Declaration;
    .end local v5    # "init":Lgnu/expr/Expression;
    .end local v8    # "ref":Lgnu/expr/ReferenceExp;
    .end local v9    # "texp":Lgnu/expr/Expression;
    :cond_4
    :goto_2
    return-object v5

    :cond_5
    move-object v5, p1

    goto :goto_2
.end method

.method protected bridge synthetic visitLetExp(Lgnu/expr/LetExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/LetExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitLetExp(Lgnu/expr/LetExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitQuoteExp(Lgnu/expr/QuoteExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 7
    .param p1, "exp"    # Lgnu/expr/QuoteExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    .line 179
    invoke-virtual {p1}, Lgnu/expr/QuoteExp;->getRawType()Lgnu/bytecode/Type;

    move-result-object v5

    if-nez v5, :cond_1

    invoke-virtual {p1}, Lgnu/expr/QuoteExp;->isSharedConstant()Z

    move-result v5

    if-nez v5, :cond_1

    invoke-virtual {p1}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v3

    .local v3, "value":Ljava/lang/Object;
    if-eqz v3, :cond_1

    .line 182
    iget-object v5, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    invoke-virtual {v5}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v0

    .line 183
    .local v0, "language":Lgnu/expr/Language;
    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v0, v5}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v4

    .line 184
    .local v4, "vtype":Lgnu/bytecode/Type;
    sget-object v5, Lgnu/bytecode/Type;->toStringType:Lgnu/bytecode/ClassType;

    if-ne v4, v5, :cond_0

    .line 185
    sget-object v4, Lgnu/bytecode/Type;->javalangStringType:Lgnu/bytecode/ClassType;

    .line 186
    :cond_0
    iput-object v4, p1, Lgnu/expr/QuoteExp;->type:Lgnu/bytecode/Type;

    .line 187
    instance-of v5, p2, Lgnu/bytecode/PrimType;

    if-eqz v5, :cond_1

    .line 189
    invoke-virtual {p2}, Lgnu/bytecode/Type;->getSignature()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Ljava/lang/String;->charAt(I)C

    move-result v2

    .line 190
    .local v2, "sig1":C
    const/16 v5, 0x49

    if-ne v2, v5, :cond_2

    invoke-virtual {p0, p1}, Lgnu/expr/InlineCalls;->fixIntValue(Lgnu/expr/Expression;)Lgnu/expr/QuoteExp;

    move-result-object v1

    .line 192
    .local v1, "ret":Lgnu/expr/QuoteExp;
    :goto_0
    if-eqz v1, :cond_1

    .line 193
    move-object p1, v1

    .line 196
    .end local v0    # "language":Lgnu/expr/Language;
    .end local v1    # "ret":Lgnu/expr/QuoteExp;
    .end local v2    # "sig1":C
    .end local v3    # "value":Ljava/lang/Object;
    .end local v4    # "vtype":Lgnu/bytecode/Type;
    :cond_1
    return-object p1

    .line 190
    .restart local v0    # "language":Lgnu/expr/Language;
    .restart local v2    # "sig1":C
    .restart local v3    # "value":Ljava/lang/Object;
    .restart local v4    # "vtype":Lgnu/bytecode/Type;
    :cond_2
    const/16 v5, 0x4a

    if-ne v2, v5, :cond_3

    invoke-virtual {p0, p1}, Lgnu/expr/InlineCalls;->fixLongValue(Lgnu/expr/Expression;)Lgnu/expr/QuoteExp;

    move-result-object v1

    goto :goto_0

    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic visitQuoteExp(Lgnu/expr/QuoteExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/QuoteExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitQuoteExp(Lgnu/expr/QuoteExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitReferenceExp(Lgnu/expr/ReferenceExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 11
    .param p1, "exp"    # Lgnu/expr/ReferenceExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    const-wide/32 v9, 0x100080

    const/16 v8, 0x65

    .line 201
    invoke-virtual {p1}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v0

    .line 202
    .local v0, "decl":Lgnu/expr/Declaration;
    if-eqz v0, :cond_3

    iget-object v5, v0, Lgnu/expr/Declaration;->field:Lgnu/bytecode/Field;

    if-nez v5, :cond_3

    invoke-virtual {v0}, Lgnu/expr/Declaration;->getCanWrite()Z

    move-result v5

    if-nez v5, :cond_3

    .line 204
    invoke-virtual {v0}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v2

    .line 205
    .local v2, "dval":Lgnu/expr/Expression;
    instance-of v5, v2, Lgnu/expr/QuoteExp;

    if-eqz v5, :cond_0

    sget-object v5, Lgnu/expr/QuoteExp;->undefined_exp:Lgnu/expr/QuoteExp;

    if-eq v2, v5, :cond_0

    .line 206
    check-cast v2, Lgnu/expr/QuoteExp;

    .end local v2    # "dval":Lgnu/expr/Expression;
    invoke-virtual {p0, v2, p2}, Lgnu/expr/InlineCalls;->visitQuoteExp(Lgnu/expr/QuoteExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v5

    .line 232
    :goto_0
    return-object v5

    .line 207
    .restart local v2    # "dval":Lgnu/expr/Expression;
    :cond_0
    instance-of v5, v2, Lgnu/expr/ReferenceExp;

    if-eqz v5, :cond_2

    invoke-virtual {v0}, Lgnu/expr/Declaration;->isAlias()Z

    move-result v5

    if-nez v5, :cond_2

    move-object v4, v2

    .line 209
    check-cast v4, Lgnu/expr/ReferenceExp;

    .line 210
    .local v4, "rval":Lgnu/expr/ReferenceExp;
    invoke-virtual {v4}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v3

    .line 211
    .local v3, "rdecl":Lgnu/expr/Declaration;
    invoke-virtual {v0}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v1

    .line 212
    .local v1, "dtype":Lgnu/bytecode/Type;
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Lgnu/expr/Declaration;->getCanWrite()Z

    move-result v5

    if-nez v5, :cond_2

    if-eqz v1, :cond_1

    sget-object v5, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    if-eq v1, v5, :cond_1

    invoke-virtual {v3}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v5

    if-ne v1, v5, :cond_2

    :cond_1
    invoke-virtual {v4}, Lgnu/expr/ReferenceExp;->getDontDereference()Z

    move-result v5

    if-nez v5, :cond_2

    .line 217
    invoke-virtual {p0, v4, p2}, Lgnu/expr/InlineCalls;->visitReferenceExp(Lgnu/expr/ReferenceExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v5

    goto :goto_0

    .line 219
    .end local v1    # "dtype":Lgnu/bytecode/Type;
    .end local v3    # "rdecl":Lgnu/expr/Declaration;
    .end local v4    # "rval":Lgnu/expr/ReferenceExp;
    :cond_2
    invoke-virtual {p1}, Lgnu/expr/ReferenceExp;->isProcedureName()Z

    move-result v5

    if-nez v5, :cond_3

    iget-wide v5, v0, Lgnu/expr/Declaration;->flags:J

    and-long/2addr v5, v9

    cmp-long v5, v5, v9

    if-nez v5, :cond_3

    .line 228
    iget-object v5, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "unimplemented: reference to method "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Lgnu/expr/Declaration;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " as variable"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v8, v6}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 229
    iget-object v5, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    const-string v6, "here is the definition of "

    const-string v7, ""

    invoke-virtual {v5, v8, v0, v6, v7}, Lgnu/expr/Compilation;->error(CLgnu/expr/Declaration;Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    .end local v2    # "dval":Lgnu/expr/Expression;
    :cond_3
    invoke-super {p0, p1, p2}, Lgnu/expr/ExpExpVisitor;->visitReferenceExp(Lgnu/expr/ReferenceExp;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lgnu/expr/Expression;

    goto :goto_0
.end method

.method protected bridge synthetic visitReferenceExp(Lgnu/expr/ReferenceExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/ReferenceExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitReferenceExp(Lgnu/expr/ReferenceExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitScopeExp(Lgnu/expr/ScopeExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 3
    .param p1, "exp"    # Lgnu/expr/ScopeExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    .line 279
    const/4 v2, 0x0

    invoke-virtual {p1, p0, v2}, Lgnu/expr/ScopeExp;->visitChildren(Lgnu/expr/ExpVisitor;Ljava/lang/Object;)V

    .line 280
    invoke-virtual {p0, p1}, Lgnu/expr/InlineCalls;->visitDeclarationTypes(Lgnu/expr/ScopeExp;)V

    .line 281
    invoke-virtual {p1}, Lgnu/expr/ScopeExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v0

    .local v0, "decl":Lgnu/expr/Declaration;
    :goto_0
    if-eqz v0, :cond_2

    .line 284
    iget-object v2, v0, Lgnu/expr/Declaration;->type:Lgnu/bytecode/Type;

    if-nez v2, :cond_0

    .line 286
    invoke-virtual {v0}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v1

    .line 287
    .local v1, "val":Lgnu/expr/Expression;
    sget-object v2, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    iput-object v2, v0, Lgnu/expr/Declaration;->type:Lgnu/bytecode/Type;

    .line 288
    if-eqz v1, :cond_1

    sget-object v2, Lgnu/expr/QuoteExp;->undefined_exp:Lgnu/expr/QuoteExp;

    if-eq v1, v2, :cond_1

    invoke-virtual {v1}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v2

    :goto_1
    invoke-virtual {v0, v2}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 282
    .end local v1    # "val":Lgnu/expr/Expression;
    :cond_0
    invoke-virtual {v0}, Lgnu/expr/Declaration;->nextDecl()Lgnu/expr/Declaration;

    move-result-object v0

    goto :goto_0

    .line 288
    .restart local v1    # "val":Lgnu/expr/Expression;
    :cond_1
    sget-object v2, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    goto :goto_1

    .line 293
    .end local v1    # "val":Lgnu/expr/Expression;
    :cond_2
    return-object p1
.end method

.method protected bridge synthetic visitScopeExp(Lgnu/expr/ScopeExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/ScopeExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitScopeExp(Lgnu/expr/ScopeExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitSetExp(Lgnu/expr/SetExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 5
    .param p1, "exp"    # Lgnu/expr/SetExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    const-wide/32 v3, 0x100080

    .line 368
    invoke-virtual {p1}, Lgnu/expr/SetExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v0

    .line 369
    .local v0, "decl":Lgnu/expr/Declaration;
    invoke-super {p0, p1, p2}, Lgnu/expr/ExpExpVisitor;->visitSetExp(Lgnu/expr/SetExp;Ljava/lang/Object;)Ljava/lang/Object;

    .line 370
    invoke-virtual {p1}, Lgnu/expr/SetExp;->isDefining()Z

    move-result v1

    if-nez v1, :cond_0

    if-eqz v0, :cond_0

    iget-wide v1, v0, Lgnu/expr/Declaration;->flags:J

    and-long/2addr v1, v3

    cmp-long v1, v1, v3

    if-nez v1, :cond_0

    .line 373
    iget-object v1, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    const/16 v2, 0x65

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "can\'t assign to method "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lgnu/expr/Declaration;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, p1}, Lgnu/expr/Compilation;->error(CLjava/lang/String;Lgnu/text/SourceLocator;)V

    .line 374
    :cond_0
    if-eqz v0, :cond_1

    const-wide/16 v1, 0x2000

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 376
    invoke-virtual {v0}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v1

    iget-object v2, p0, Lgnu/expr/InlineCalls;->comp:Lgnu/expr/Compilation;

    invoke-static {v1, v2}, Lgnu/kawa/reflect/CompileReflect;->checkKnownClass(Lgnu/bytecode/Type;Lgnu/expr/Compilation;)I

    move-result v1

    if-gez v1, :cond_1

    .line 377
    sget-object v1, Lgnu/bytecode/Type;->errorType:Lgnu/bytecode/ObjectType;

    invoke-virtual {v0, v1}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 392
    :cond_1
    return-object p1
.end method

.method protected bridge synthetic visitSetExp(Lgnu/expr/SetExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/SetExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitSetExp(Lgnu/expr/SetExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitSetExpValue(Lgnu/expr/Expression;Lgnu/bytecode/Type;Lgnu/expr/Declaration;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "new_value"    # Lgnu/expr/Expression;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "decl"    # Lgnu/expr/Declaration;

    .prologue
    .line 363
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Lgnu/expr/Declaration;->isAlias()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p0, p1, v0}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0

    :cond_1
    iget-object v0, p3, Lgnu/expr/Declaration;->type:Lgnu/bytecode/Type;

    goto :goto_0
.end method

.method protected bridge synthetic visitSetExpValue(Lgnu/expr/Expression;Ljava/lang/Object;Lgnu/expr/Declaration;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/Expression;
    .param p2, "x1"    # Ljava/lang/Object;
    .param p3, "x2"    # Lgnu/expr/Declaration;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2, p3}, Lgnu/expr/InlineCalls;->visitSetExpValue(Lgnu/expr/Expression;Lgnu/bytecode/Type;Lgnu/expr/Declaration;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitTryExp(Lgnu/expr/TryExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "exp"    # Lgnu/expr/TryExp;
    .param p2, "required"    # Lgnu/bytecode/Type;

    .prologue
    .line 354
    invoke-virtual {p1}, Lgnu/expr/TryExp;->getCatchClauses()Lgnu/expr/CatchClause;

    move-result-object v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lgnu/expr/TryExp;->getFinallyClause()Lgnu/expr/Expression;

    move-result-object v0

    if-nez v0, :cond_0

    .line 355
    iget-object v0, p1, Lgnu/expr/TryExp;->try_clause:Lgnu/expr/Expression;

    invoke-virtual {p0, v0, p2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    .line 357
    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2}, Lgnu/expr/ExpExpVisitor;->visitTryExp(Lgnu/expr/TryExp;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/expr/Expression;

    goto :goto_0
.end method

.method protected bridge synthetic visitTryExp(Lgnu/expr/TryExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/TryExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 28
    check-cast p2, Lgnu/bytecode/Type;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/InlineCalls;->visitTryExp(Lgnu/expr/TryExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method
