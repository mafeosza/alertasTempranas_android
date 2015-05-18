.class public Lgnu/kawa/reflect/CompileInvoke;
.super Ljava/lang/Object;
.source "CompileInvoke.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static append([Lgnu/expr/PrimProcedure;ILjava/lang/StringBuffer;)V
    .locals 2
    .param p0, "methods"    # [Lgnu/expr/PrimProcedure;
    .param p1, "mcount"    # I
    .param p2, "sbuf"    # Ljava/lang/StringBuffer;

    .prologue
    .line 455
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p1, :cond_0

    .line 457
    const-string v1, "\n  candidate: "

    invoke-virtual {p2, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 458
    aget-object v1, p0, v0

    invoke-virtual {p2, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 455
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 460
    :cond_0
    return-void
.end method

.method static checkKeywords(Lgnu/bytecode/ObjectType;[Lgnu/expr/Expression;ILgnu/bytecode/ClassType;)[Ljava/lang/Object;
    .locals 9
    .param p0, "type"    # Lgnu/bytecode/ObjectType;
    .param p1, "args"    # [Lgnu/expr/Expression;
    .param p2, "start"    # I
    .param p3, "caller"    # Lgnu/bytecode/ClassType;

    .prologue
    .line 419
    array-length v2, p1

    .line 420
    .local v2, "len":I
    const/4 v4, 0x0

    .line 422
    .local v4, "npairs":I
    :goto_0
    mul-int/lit8 v7, v4, 0x2

    add-int/2addr v7, p2

    add-int/lit8 v7, v7, 0x1

    if-ge v7, v2, :cond_0

    mul-int/lit8 v7, v4, 0x2

    add-int/2addr v7, p2

    aget-object v7, p1, v7

    invoke-virtual {v7}, Lgnu/expr/Expression;->valueIfConstant()Ljava/lang/Object;

    move-result-object v7

    instance-of v7, v7, Lgnu/expr/Keyword;

    if-eqz v7, :cond_0

    .line 423
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 424
    :cond_0
    new-array v0, v4, [Ljava/lang/Object;

    .line 425
    .local v0, "fields":[Ljava/lang/Object;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v4, :cond_3

    .line 427
    mul-int/lit8 v7, v1, 0x2

    add-int/2addr v7, p2

    aget-object v7, p1, v7

    invoke-virtual {v7}, Lgnu/expr/Expression;->valueIfConstant()Ljava/lang/Object;

    move-result-object v6

    .line 428
    .local v6, "value":Ljava/lang/Object;
    check-cast v6, Lgnu/expr/Keyword;

    .end local v6    # "value":Ljava/lang/Object;
    invoke-virtual {v6}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v3

    .line 430
    .local v3, "name":Ljava/lang/String;
    invoke-static {p0, v3, p3}, Lgnu/kawa/reflect/SlotSet;->lookupMember(Lgnu/bytecode/ObjectType;Ljava/lang/String;Lgnu/bytecode/ClassType;)Lgnu/bytecode/Member;

    move-result-object v5

    .line 431
    .local v5, "slot":Lgnu/bytecode/Member;
    if-nez v5, :cond_1

    .line 436
    const-string v7, "add"

    invoke-static {v7, v3}, Lgnu/expr/ClassExp;->slotToMethodName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    sget-object v8, Lgnu/kawa/reflect/SlotSet;->type1Array:[Lgnu/bytecode/Type;

    invoke-virtual {p0, v7, v8}, Lgnu/bytecode/ObjectType;->getMethod(Ljava/lang/String;[Lgnu/bytecode/Type;)Lgnu/bytecode/Method;

    move-result-object v5

    .line 438
    :cond_1
    if-eqz v5, :cond_2

    .end local v5    # "slot":Lgnu/bytecode/Member;
    :goto_2
    aput-object v5, v0, v1

    .line 425
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .restart local v5    # "slot":Lgnu/bytecode/Member;
    :cond_2
    move-object v5, v3

    .line 438
    goto :goto_2

    .line 440
    .end local v3    # "name":Ljava/lang/String;
    .end local v5    # "slot":Lgnu/bytecode/Member;
    :cond_3
    return-object v0
.end method

.method private static getMethodName([Lgnu/expr/Expression;C)Ljava/lang/String;
    .locals 3
    .param p0, "args"    # [Lgnu/expr/Expression;
    .param p1, "kind"    # C

    .prologue
    .line 445
    const/16 v1, 0x4e

    if-ne p1, v1, :cond_0

    .line 446
    const-string v1, "<init>"

    .line 450
    :goto_0
    return-object v1

    .line 447
    :cond_0
    const/16 v1, 0x50

    if-ne p1, v1, :cond_1

    const/4 v0, 0x2

    .line 448
    .local v0, "nameIndex":I
    :goto_1
    array-length v1, p0

    add-int/lit8 v2, v0, 0x1

    if-lt v1, v2, :cond_2

    .line 449
    aget-object v1, p0, v0

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lgnu/kawa/reflect/ClassMethods;->checkName(Lgnu/expr/Expression;Z)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 447
    .end local v0    # "nameIndex":I
    :cond_1
    const/4 v0, 0x1

    goto :goto_1

    .line 450
    .restart local v0    # "nameIndex":I
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected static getMethods(Lgnu/bytecode/ObjectType;Ljava/lang/String;Lgnu/bytecode/ClassType;Lgnu/kawa/reflect/Invoke;)[Lgnu/expr/PrimProcedure;
    .locals 3
    .param p0, "ctype"    # Lgnu/bytecode/ObjectType;
    .param p1, "mname"    # Ljava/lang/String;
    .param p2, "caller"    # Lgnu/bytecode/ClassType;
    .param p3, "iproc"    # Lgnu/kawa/reflect/Invoke;

    .prologue
    const/16 v2, 0x56

    const/16 v1, 0x50

    .line 465
    iget-char v0, p3, Lgnu/kawa/reflect/Invoke;->kind:C

    .line 466
    .local v0, "kind":I
    if-ne v0, v1, :cond_0

    :goto_0
    iget-object v2, p3, Lgnu/kawa/reflect/Invoke;->language:Lgnu/expr/Language;

    invoke-static {p0, p1, v1, p2, v2}, Lgnu/kawa/reflect/ClassMethods;->getMethods(Lgnu/bytecode/ObjectType;Ljava/lang/String;CLgnu/bytecode/ClassType;Lgnu/expr/Language;)[Lgnu/expr/PrimProcedure;

    move-result-object v1

    return-object v1

    :cond_0
    const/16 v1, 0x2a

    if-eq v0, v1, :cond_1

    if-ne v0, v2, :cond_2

    :cond_1
    move v1, v2

    goto :goto_0

    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static declared-synchronized getStaticMethod(Lgnu/bytecode/ClassType;Ljava/lang/String;[Lgnu/expr/Expression;)Lgnu/expr/PrimProcedure;
    .locals 13
    .param p0, "type"    # Lgnu/bytecode/ClassType;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "args"    # [Lgnu/expr/Expression;

    .prologue
    const/4 v11, 0x0

    .line 514
    const-class v12, Lgnu/kawa/reflect/CompileInvoke;

    monitor-enter v12

    const/4 v1, 0x0

    :try_start_0
    sget-object v2, Lgnu/kawa/reflect/Invoke;->invokeStatic:Lgnu/kawa/reflect/Invoke;

    invoke-static {p0, p1, v1, v2}, Lgnu/kawa/reflect/CompileInvoke;->getMethods(Lgnu/bytecode/ObjectType;Ljava/lang/String;Lgnu/bytecode/ClassType;Lgnu/kawa/reflect/Invoke;)[Lgnu/expr/PrimProcedure;

    move-result-object v0

    .line 515
    .local v0, "methods":[Lgnu/expr/PrimProcedure;
    array-length v3, p2

    const/4 v4, 0x0

    const/4 v5, -0x1

    move-object v1, p0

    move-object v2, p2

    invoke-static/range {v0 .. v5}, Lgnu/kawa/reflect/CompileInvoke;->selectApplicable([Lgnu/expr/PrimProcedure;Lgnu/bytecode/ObjectType;[Lgnu/expr/Expression;III)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v8

    .line 516
    .local v8, "num":J
    const/16 v1, 0x20

    shr-long v1, v8, v1

    long-to-int v10, v1

    .line 517
    .local v10, "okCount":I
    long-to-int v7, v8

    .line 519
    .local v7, "maybeCount":I
    if-nez v0, :cond_0

    .line 520
    const/4 v6, -0x1

    .line 527
    .local v6, "index":I
    :goto_0
    if-gez v6, :cond_3

    move-object v1, v11

    :goto_1
    monitor-exit v12

    return-object v1

    .line 521
    .end local v6    # "index":I
    :cond_0
    if-lez v10, :cond_1

    .line 522
    :try_start_1
    invoke-static {v0, v10}, Lgnu/mapping/MethodProc;->mostSpecific([Lgnu/mapping/MethodProc;I)I

    move-result v6

    .restart local v6    # "index":I
    goto :goto_0

    .line 523
    .end local v6    # "index":I
    :cond_1
    const/4 v1, 0x1

    if-ne v7, v1, :cond_2

    .line 524
    const/4 v6, 0x0

    .restart local v6    # "index":I
    goto :goto_0

    .line 526
    .end local v6    # "index":I
    :cond_2
    const/4 v6, -0x1

    .restart local v6    # "index":I
    goto :goto_0

    .line 527
    :cond_3
    aget-object v1, v0, v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 514
    .end local v0    # "methods":[Lgnu/expr/PrimProcedure;
    .end local v6    # "index":I
    .end local v7    # "maybeCount":I
    .end local v8    # "num":J
    .end local v10    # "okCount":I
    :catchall_0
    move-exception v1

    monitor-exit v12

    throw v1
.end method

.method static hasKeywordArgument(I[Lgnu/expr/Expression;)I
    .locals 2
    .param p0, "argsStartIndex"    # I
    .param p1, "args"    # [Lgnu/expr/Expression;

    .prologue
    .line 475
    move v0, p0

    .local v0, "i":I
    :goto_0
    array-length v1, p1

    if-ge v0, v1, :cond_1

    .line 477
    aget-object v1, p1, v0

    invoke-virtual {v1}, Lgnu/expr/Expression;->valueIfConstant()Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lgnu/expr/Keyword;

    if-eqz v1, :cond_0

    .line 480
    .end local v0    # "i":I
    :goto_1
    return v0

    .line 475
    .restart local v0    # "i":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 480
    :cond_1
    array-length v0, p1

    goto :goto_1
.end method

.method private static selectApplicable([Lgnu/expr/PrimProcedure;Lgnu/bytecode/ObjectType;[Lgnu/expr/Expression;III)J
    .locals 8
    .param p0, "methods"    # [Lgnu/expr/PrimProcedure;
    .param p1, "ctype"    # Lgnu/bytecode/ObjectType;
    .param p2, "args"    # [Lgnu/expr/Expression;
    .param p3, "margsLength"    # I
    .param p4, "argsStartIndex"    # I
    .param p5, "objIndex"    # I

    .prologue
    .line 488
    new-array v2, p3, [Lgnu/bytecode/Type;

    .line 490
    .local v2, "atypes":[Lgnu/bytecode/Type;
    const/4 v3, 0x0

    .line 491
    .local v3, "dst":I
    if-ltz p5, :cond_0

    .line 492
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "dst":I
    .local v4, "dst":I
    aput-object p1, v2, v3

    move v3, v4

    .line 493
    .end local v4    # "dst":I
    .restart local v3    # "dst":I
    :cond_0
    move v5, p4

    .line 494
    .local v5, "src":I
    :goto_0
    array-length v6, p2

    if-ge v5, v6, :cond_4

    array-length v6, v2

    if-ge v3, v6, :cond_4

    .line 497
    aget-object v0, p2, v5

    .line 498
    .local v0, "arg":Lgnu/expr/Expression;
    const/4 v1, 0x0

    .line 500
    .local v1, "atype":Lgnu/bytecode/Type;
    invoke-static {v0}, Lgnu/expr/InlineCalls;->checkIntValue(Lgnu/expr/Expression;)Ljava/lang/Integer;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 501
    sget-object v1, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    .line 506
    :cond_1
    :goto_1
    aput-object v1, v2, v3

    .line 495
    add-int/lit8 v5, v5, 0x1

    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 502
    :cond_2
    invoke-static {v0}, Lgnu/expr/InlineCalls;->checkLongValue(Lgnu/expr/Expression;)Ljava/lang/Long;

    move-result-object v6

    if-eqz v6, :cond_3

    .line 503
    sget-object v1, Lgnu/bytecode/Type;->longType:Lgnu/bytecode/PrimType;

    goto :goto_1

    .line 504
    :cond_3
    if-nez v1, :cond_1

    .line 505
    invoke-virtual {v0}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v1

    goto :goto_1

    .line 508
    .end local v0    # "arg":Lgnu/expr/Expression;
    .end local v1    # "atype":Lgnu/bytecode/Type;
    :cond_4
    invoke-static {p0, v2}, Lgnu/kawa/reflect/ClassMethods;->selectApplicable([Lgnu/expr/PrimProcedure;[Lgnu/bytecode/Type;)J

    move-result-wide v6

    return-wide v6
.end method

.method public static validateApplyInvoke(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
    .locals 69
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "visitor"    # Lgnu/expr/InlineCalls;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    .line 13
    move-object/from16 v35, p3

    check-cast v35, Lgnu/kawa/reflect/Invoke;

    .line 14
    .local v35, "iproc":Lgnu/kawa/reflect/Invoke;
    move-object/from16 v0, v35

    iget-char v0, v0, Lgnu/kawa/reflect/Invoke;->kind:C

    move/from16 v39, v0

    .line 15
    .local v39, "kind":C
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/InlineCalls;->getCompilation()Lgnu/expr/Compilation;

    move-result-object v24

    .line 16
    .local v24, "comp":Lgnu/expr/Compilation;
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v5

    .line 17
    .local v5, "args":[Lgnu/expr/Expression;
    array-length v0, v5

    move/from16 v48, v0

    .line 18
    .local v48, "nargs":I
    move-object/from16 v0, v24

    iget-boolean v9, v0, Lgnu/expr/Compilation;->mustCompile:Z

    if-eqz v9, :cond_1

    if-eqz v48, :cond_1

    const/16 v9, 0x56

    move/from16 v0, v39

    if-eq v0, v9, :cond_0

    const/16 v9, 0x2a

    move/from16 v0, v39

    if-ne v0, v9, :cond_2

    :cond_0
    const/4 v9, 0x1

    move/from16 v0, v48

    if-ne v0, v9, :cond_2

    .line 23
    :cond_1
    invoke-virtual/range {p0 .. p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    .line 411
    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    :goto_0
    return-object p0

    .line 27
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_2
    const/4 v9, 0x0

    aget-object v9, v5, v9

    const/4 v10, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v10}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v19

    .line 28
    .local v19, "arg0":Lgnu/expr/Expression;
    const/4 v9, 0x0

    aput-object v19, v5, v9

    .line 29
    const/16 v9, 0x56

    move/from16 v0, v39

    if-eq v0, v9, :cond_3

    const/16 v9, 0x2a

    move/from16 v0, v39

    if-ne v0, v9, :cond_8

    :cond_3
    invoke-virtual/range {v19 .. v19}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v66

    .line 30
    .local v66, "type0":Lgnu/bytecode/Type;
    :goto_1
    move-object/from16 v0, v66

    instance-of v9, v0, Lgnu/expr/PairClassType;

    if-eqz v9, :cond_9

    const/16 v9, 0x4e

    move/from16 v0, v39

    if-ne v0, v9, :cond_9

    .line 31
    check-cast v66, Lgnu/expr/PairClassType;

    .end local v66    # "type0":Lgnu/bytecode/Type;
    move-object/from16 v0, v66

    iget-object v0, v0, Lgnu/expr/PairClassType;->instanceType:Lgnu/bytecode/ClassType;

    move-object/from16 v65, v0

    .line 36
    .local v65, "type":Lgnu/bytecode/ObjectType;
    :goto_2
    move/from16 v0, v39

    invoke-static {v5, v0}, Lgnu/kawa/reflect/CompileInvoke;->getMethodName([Lgnu/expr/Expression;C)Ljava/lang/String;

    move-result-object v47

    .line 39
    .local v47, "name":Ljava/lang/String;
    const/16 v9, 0x56

    move/from16 v0, v39

    if-eq v0, v9, :cond_4

    const/16 v9, 0x2a

    move/from16 v0, v39

    if-ne v0, v9, :cond_b

    .line 41
    :cond_4
    add-int/lit8 v6, v48, -0x1

    .line 42
    .local v6, "margsLength":I
    const/4 v7, 0x2

    .line 43
    .local v7, "argsStartIndex":I
    const/4 v8, 0x0

    .line 69
    .local v8, "objIndex":I
    :goto_3
    const/16 v9, 0x4e

    move/from16 v0, v39

    if-ne v0, v9, :cond_14

    move-object/from16 v0, v65

    instance-of v9, v0, Lgnu/bytecode/ArrayType;

    if-eqz v9, :cond_14

    move-object/from16 v21, v65

    .line 71
    check-cast v21, Lgnu/bytecode/ArrayType;

    .line 72
    .local v21, "atype":Lgnu/bytecode/ArrayType;
    invoke-virtual/range {v21 .. v21}, Lgnu/bytecode/ArrayType;->getComponentType()Lgnu/bytecode/Type;

    move-result-object v29

    .line 73
    .local v29, "elementType":Lgnu/bytecode/Type;
    const/16 v60, 0x0

    .line 74
    .local v60, "sizeArg":Lgnu/expr/Expression;
    const/16 v42, 0x0

    .line 75
    .local v42, "lengthSpecified":Z
    array-length v9, v5

    const/4 v10, 0x3

    if-lt v9, v10, :cond_6

    const/4 v9, 0x1

    aget-object v9, v5, v9

    instance-of v9, v9, Lgnu/expr/QuoteExp;

    if-eqz v9, :cond_6

    .line 77
    const/4 v9, 0x1

    aget-object v9, v5, v9

    check-cast v9, Lgnu/expr/QuoteExp;

    invoke-virtual {v9}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v20

    .line 78
    .local v20, "arg1":Ljava/lang/Object;
    move-object/from16 v0, v20

    instance-of v9, v0, Lgnu/expr/Keyword;

    if-eqz v9, :cond_6

    const-string v9, "length"

    check-cast v20, Lgnu/expr/Keyword;

    .end local v20    # "arg1":Ljava/lang/Object;
    invoke-virtual/range {v20 .. v20}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v47

    move-object/from16 v0, v47

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_5

    const-string v9, "size"

    move-object/from16 v0, v47

    invoke-virtual {v9, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_6

    .line 82
    :cond_5
    const/4 v9, 0x2

    aget-object v60, v5, v9

    .line 83
    const/16 v42, 0x1

    .line 86
    :cond_6
    if-nez v60, :cond_7

    .line 87
    new-instance v9, Ljava/lang/Integer;

    array-length v10, v5

    add-int/lit8 v10, v10, -0x1

    invoke-direct {v9, v10}, Ljava/lang/Integer;-><init>(I)V

    invoke-static {v9}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v60

    .line 88
    :cond_7
    sget-object v9, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    move-object/from16 v0, p1

    move-object/from16 v1, v60

    invoke-virtual {v0, v1, v9}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v60

    .line 89
    new-instance v17, Lgnu/expr/ApplyExp;

    new-instance v9, Lgnu/kawa/reflect/ArrayNew;

    move-object/from16 v0, v29

    invoke-direct {v9, v0}, Lgnu/kawa/reflect/ArrayNew;-><init>(Lgnu/bytecode/Type;)V

    const/4 v10, 0x1

    new-array v10, v10, [Lgnu/expr/Expression;

    const/4 v11, 0x0

    aput-object v60, v10, v11

    move-object/from16 v0, v17

    invoke-direct {v0, v9, v10}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .line 91
    .local v17, "alloc":Lgnu/expr/ApplyExp;
    move-object/from16 v0, v17

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lgnu/expr/ApplyExp;->setType(Lgnu/bytecode/Type;)V

    .line 92
    if-eqz v42, :cond_10

    array-length v9, v5

    const/4 v10, 0x3

    if-ne v9, v10, :cond_10

    move-object/from16 p0, v17

    .line 93
    goto/16 :goto_0

    .line 29
    .end local v6    # "margsLength":I
    .end local v7    # "argsStartIndex":I
    .end local v8    # "objIndex":I
    .end local v17    # "alloc":Lgnu/expr/ApplyExp;
    .end local v21    # "atype":Lgnu/bytecode/ArrayType;
    .end local v29    # "elementType":Lgnu/bytecode/Type;
    .end local v42    # "lengthSpecified":Z
    .end local v47    # "name":Ljava/lang/String;
    .end local v60    # "sizeArg":Lgnu/expr/Expression;
    .end local v65    # "type":Lgnu/bytecode/ObjectType;
    :cond_8
    move-object/from16 v0, v35

    iget-object v9, v0, Lgnu/kawa/reflect/Invoke;->language:Lgnu/expr/Language;

    move-object/from16 v0, v19

    invoke-virtual {v9, v0}, Lgnu/expr/Language;->getTypeFor(Lgnu/expr/Expression;)Lgnu/bytecode/Type;

    move-result-object v66

    goto/16 :goto_1

    .line 32
    .restart local v66    # "type0":Lgnu/bytecode/Type;
    :cond_9
    move-object/from16 v0, v66

    instance-of v9, v0, Lgnu/bytecode/ObjectType;

    if-eqz v9, :cond_a

    move-object/from16 v65, v66

    .line 33
    check-cast v65, Lgnu/bytecode/ObjectType;

    .restart local v65    # "type":Lgnu/bytecode/ObjectType;
    goto/16 :goto_2

    .line 35
    .end local v65    # "type":Lgnu/bytecode/ObjectType;
    :cond_a
    const/16 v65, 0x0

    .restart local v65    # "type":Lgnu/bytecode/ObjectType;
    goto/16 :goto_2

    .line 45
    .end local v66    # "type0":Lgnu/bytecode/Type;
    .restart local v47    # "name":Ljava/lang/String;
    :cond_b
    const/16 v9, 0x4e

    move/from16 v0, v39

    if-ne v0, v9, :cond_c

    .line 47
    move/from16 v6, v48

    .line 48
    .restart local v6    # "margsLength":I
    const/4 v7, 0x0

    .line 49
    .restart local v7    # "argsStartIndex":I
    const/4 v8, -0x1

    .restart local v8    # "objIndex":I
    goto/16 :goto_3

    .line 51
    .end local v6    # "margsLength":I
    .end local v7    # "argsStartIndex":I
    .end local v8    # "objIndex":I
    :cond_c
    const/16 v9, 0x53

    move/from16 v0, v39

    if-eq v0, v9, :cond_d

    const/16 v9, 0x73

    move/from16 v0, v39

    if-ne v0, v9, :cond_e

    .line 53
    :cond_d
    add-int/lit8 v6, v48, -0x2

    .line 54
    .restart local v6    # "margsLength":I
    const/4 v7, 0x2

    .line 55
    .restart local v7    # "argsStartIndex":I
    const/4 v8, -0x1

    .restart local v8    # "objIndex":I
    goto/16 :goto_3

    .line 57
    .end local v6    # "margsLength":I
    .end local v7    # "argsStartIndex":I
    .end local v8    # "objIndex":I
    :cond_e
    const/16 v9, 0x50

    move/from16 v0, v39

    if-ne v0, v9, :cond_f

    .line 59
    add-int/lit8 v6, v48, -0x2

    .line 60
    .restart local v6    # "margsLength":I
    const/4 v7, 0x3

    .line 61
    .restart local v7    # "argsStartIndex":I
    const/4 v8, 0x1

    .restart local v8    # "objIndex":I
    goto/16 :goto_3

    .line 65
    .end local v6    # "margsLength":I
    .end local v7    # "argsStartIndex":I
    .end local v8    # "objIndex":I
    :cond_f
    invoke-virtual/range {p0 .. p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    goto/16 :goto_0

    .line 94
    .restart local v6    # "margsLength":I
    .restart local v7    # "argsStartIndex":I
    .restart local v8    # "objIndex":I
    .restart local v17    # "alloc":Lgnu/expr/ApplyExp;
    .restart local v21    # "atype":Lgnu/bytecode/ArrayType;
    .restart local v29    # "elementType":Lgnu/bytecode/Type;
    .restart local v42    # "lengthSpecified":Z
    .restart local v60    # "sizeArg":Lgnu/expr/Expression;
    :cond_10
    new-instance v43, Lgnu/expr/LetExp;

    const/4 v9, 0x1

    new-array v9, v9, [Lgnu/expr/Expression;

    const/4 v10, 0x0

    aput-object v17, v9, v10

    move-object/from16 v0, v43

    invoke-direct {v0, v9}, Lgnu/expr/LetExp;-><init>([Lgnu/expr/Expression;)V

    .line 95
    .local v43, "let":Lgnu/expr/LetExp;
    const/4 v9, 0x0

    check-cast v9, Ljava/lang/String;

    move-object/from16 v0, v43

    move-object/from16 v1, v21

    invoke-virtual {v0, v9, v1}, Lgnu/expr/LetExp;->addDeclaration(Ljava/lang/Object;Lgnu/bytecode/Type;)Lgnu/expr/Declaration;

    move-result-object v15

    .line 96
    .local v15, "adecl":Lgnu/expr/Declaration;
    move-object/from16 v0, v17

    invoke-virtual {v15, v0}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 97
    new-instance v22, Lgnu/expr/BeginExp;

    invoke-direct/range {v22 .. v22}, Lgnu/expr/BeginExp;-><init>()V

    .line 98
    .local v22, "begin":Lgnu/expr/BeginExp;
    const/16 v34, 0x0

    .line 99
    .local v34, "index":I
    if-eqz v42, :cond_12

    const/16 v32, 0x3

    .local v32, "i":I
    :goto_4
    array-length v9, v5

    move/from16 v0, v32

    if-ge v0, v9, :cond_13

    .line 101
    aget-object v18, v5, v32

    .line 102
    .local v18, "arg":Lgnu/expr/Expression;
    if-eqz v42, :cond_11

    add-int/lit8 v9, v32, 0x1

    array-length v10, v5

    if-ge v9, v10, :cond_11

    move-object/from16 v0, v18

    instance-of v9, v0, Lgnu/expr/QuoteExp;

    if-eqz v9, :cond_11

    move-object/from16 v9, v18

    .line 104
    check-cast v9, Lgnu/expr/QuoteExp;

    invoke-virtual {v9}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v37

    .line 105
    .local v37, "key":Ljava/lang/Object;
    move-object/from16 v0, v37

    instance-of v9, v0, Lgnu/expr/Keyword;

    if-eqz v9, :cond_11

    .line 107
    check-cast v37, Lgnu/expr/Keyword;

    .end local v37    # "key":Ljava/lang/Object;
    invoke-virtual/range {v37 .. v37}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v40

    .line 110
    .local v40, "kname":Ljava/lang/String;
    :try_start_0
    invoke-static/range {v40 .. v40}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v34

    .line 111
    add-int/lit8 v32, v32, 0x1

    aget-object v18, v5, v32
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 120
    .end local v40    # "kname":Ljava/lang/String;
    :cond_11
    move-object/from16 v0, p1

    move-object/from16 v1, v18

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v18

    .line 121
    new-instance v9, Lgnu/expr/ApplyExp;

    new-instance v10, Lgnu/kawa/reflect/ArraySet;

    move-object/from16 v0, v29

    invoke-direct {v10, v0}, Lgnu/kawa/reflect/ArraySet;-><init>(Lgnu/bytecode/Type;)V

    const/4 v11, 0x3

    new-array v11, v11, [Lgnu/expr/Expression;

    const/4 v12, 0x0

    new-instance v13, Lgnu/expr/ReferenceExp;

    invoke-direct {v13, v15}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v13, v11, v12

    const/4 v12, 0x1

    new-instance v13, Ljava/lang/Integer;

    move/from16 v0, v34

    invoke-direct {v13, v0}, Ljava/lang/Integer;-><init>(I)V

    invoke-static {v13}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x2

    aput-object v18, v11, v12

    invoke-direct {v9, v10, v11}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    move-object/from16 v0, v22

    invoke-virtual {v0, v9}, Lgnu/expr/BeginExp;->add(Lgnu/expr/Expression;)V

    .line 126
    add-int/lit8 v34, v34, 0x1

    .line 99
    add-int/lit8 v32, v32, 0x1

    goto :goto_4

    .end local v18    # "arg":Lgnu/expr/Expression;
    .end local v32    # "i":I
    :cond_12
    const/16 v32, 0x1

    goto :goto_4

    .line 113
    .restart local v18    # "arg":Lgnu/expr/Expression;
    .restart local v32    # "i":I
    .restart local v40    # "kname":Ljava/lang/String;
    :catch_0
    move-exception v31

    .line 115
    .local v31, "ex":Ljava/lang/Throwable;
    const/16 v9, 0x65

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "non-integer keyword \'"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    move-object/from16 v0, v40

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\' in array constructor"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, v24

    invoke-virtual {v0, v9, v10}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    goto/16 :goto_0

    .line 128
    .end local v18    # "arg":Lgnu/expr/Expression;
    .end local v31    # "ex":Ljava/lang/Throwable;
    .end local v40    # "kname":Ljava/lang/String;
    :cond_13
    new-instance v9, Lgnu/expr/ReferenceExp;

    invoke-direct {v9, v15}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    move-object/from16 v0, v22

    invoke-virtual {v0, v9}, Lgnu/expr/BeginExp;->add(Lgnu/expr/Expression;)V

    .line 129
    move-object/from16 v0, v22

    move-object/from16 v1, v43

    iput-object v0, v1, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    move-object/from16 p0, v43

    .line 130
    goto/16 :goto_0

    .line 132
    .end local v15    # "adecl":Lgnu/expr/Declaration;
    .end local v17    # "alloc":Lgnu/expr/ApplyExp;
    .end local v21    # "atype":Lgnu/bytecode/ArrayType;
    .end local v22    # "begin":Lgnu/expr/BeginExp;
    .end local v29    # "elementType":Lgnu/bytecode/Type;
    .end local v32    # "i":I
    .end local v34    # "index":I
    .end local v42    # "lengthSpecified":Z
    .end local v43    # "let":Lgnu/expr/LetExp;
    .end local v60    # "sizeArg":Lgnu/expr/Expression;
    :cond_14
    if-eqz v65, :cond_49

    if-eqz v47, :cond_49

    .line 134
    move-object/from16 v0, v65

    instance-of v9, v0, Lgnu/expr/TypeValue;

    if-eqz v9, :cond_15

    const/16 v9, 0x4e

    move/from16 v0, v39

    if-ne v0, v9, :cond_15

    move-object/from16 v9, v65

    .line 136
    check-cast v9, Lgnu/expr/TypeValue;

    invoke-interface {v9}, Lgnu/expr/TypeValue;->getConstructor()Lgnu/mapping/Procedure;

    move-result-object v25

    .line 137
    .local v25, "constructor":Lgnu/mapping/Procedure;
    if-eqz v25, :cond_15

    .line 139
    add-int/lit8 v9, v48, -0x1

    new-array v0, v9, [Lgnu/expr/Expression;

    move-object/from16 v68, v0

    .line 140
    .local v68, "xargs":[Lgnu/expr/Expression;
    const/4 v9, 0x1

    const/4 v10, 0x0

    add-int/lit8 v11, v48, -0x1

    move-object/from16 v0, v68

    invoke-static {v5, v9, v0, v10, v11}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 141
    new-instance v9, Lgnu/expr/ApplyExp;

    move-object/from16 v0, v25

    move-object/from16 v1, v68

    invoke-direct {v9, v0, v1}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v9, v1}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object p0

    goto/16 :goto_0

    .line 145
    .end local v25    # "constructor":Lgnu/mapping/Procedure;
    .end local v68    # "xargs":[Lgnu/expr/Expression;
    :cond_15
    if-nez v24, :cond_19

    const/16 v23, 0x0

    .line 148
    .local v23, "caller":Lgnu/bytecode/ClassType;
    :goto_5
    move-object/from16 v4, v65

    .line 152
    .local v4, "ctype":Lgnu/bytecode/ObjectType;
    :try_start_1
    move-object/from16 v0, v47

    move-object/from16 v1, v23

    move-object/from16 v2, v35

    invoke-static {v4, v0, v1, v2}, Lgnu/kawa/reflect/CompileInvoke;->getMethods(Lgnu/bytecode/ObjectType;Ljava/lang/String;Lgnu/bytecode/ClassType;Lgnu/kawa/reflect/Invoke;)[Lgnu/expr/PrimProcedure;

    move-result-object v3

    .line 153
    .local v3, "methods":[Lgnu/expr/PrimProcedure;
    invoke-static {v3, v6}, Lgnu/kawa/reflect/ClassMethods;->selectApplicable([Lgnu/expr/PrimProcedure;I)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result v52

    .line 160
    .local v52, "numCode":I
    const/16 v34, -0x1

    .line 163
    .restart local v34    # "index":I
    const/16 v9, 0x4e

    move/from16 v0, v39

    if-ne v0, v9, :cond_26

    const/4 v9, 0x1

    invoke-static {v9, v5}, Lgnu/kawa/reflect/CompileInvoke;->hasKeywordArgument(I[Lgnu/expr/Expression;)I

    move-result v38

    .local v38, "keywordStart":I
    array-length v9, v5

    move/from16 v0, v38

    if-lt v0, v9, :cond_16

    if-gtz v52, :cond_26

    const/4 v9, 0x1

    new-array v9, v9, [Lgnu/bytecode/Type;

    const/4 v10, 0x0

    sget-object v11, Lgnu/expr/Compilation;->typeClassType:Lgnu/bytecode/ClassType;

    aput-object v11, v9, v10

    invoke-static {v3, v9}, Lgnu/kawa/reflect/ClassMethods;->selectApplicable([Lgnu/expr/PrimProcedure;[Lgnu/bytecode/Type;)J

    move-result-wide v9

    const/16 v11, 0x20

    shr-long/2addr v9, v11

    const-wide/16 v11, 0x1

    cmp-long v9, v9, v11

    if-nez v9, :cond_26

    :cond_16
    move/from16 v0, v38

    move-object/from16 v1, v23

    invoke-static {v4, v5, v0, v1}, Lgnu/kawa/reflect/CompileInvoke;->checkKeywords(Lgnu/bytecode/ObjectType;[Lgnu/expr/Expression;ILgnu/bytecode/ClassType;)[Ljava/lang/Object;

    move-result-object v62

    .local v62, "slots":[Ljava/lang/Object;
    move-object/from16 v0, v62

    array-length v9, v0

    mul-int/lit8 v9, v9, 0x2

    array-length v10, v5

    sub-int v10, v10, v38

    if-eq v9, v10, :cond_17

    const-string v9, "add"

    const/16 v10, 0x56

    const/4 v11, 0x0

    move-object/from16 v0, v35

    iget-object v12, v0, Lgnu/kawa/reflect/Invoke;->language:Lgnu/expr/Language;

    invoke-static {v4, v9, v10, v11, v12}, Lgnu/kawa/reflect/ClassMethods;->getMethods(Lgnu/bytecode/ObjectType;Ljava/lang/String;CLgnu/bytecode/ClassType;Lgnu/expr/Language;)[Lgnu/expr/PrimProcedure;

    move-result-object v9

    const/4 v10, 0x2

    invoke-static {v9, v10}, Lgnu/kawa/reflect/ClassMethods;->selectApplicable([Lgnu/expr/PrimProcedure;I)I

    move-result v9

    if-lez v9, :cond_26

    .line 174
    :cond_17
    const/16 v30, 0x0

    .line 175
    .local v30, "errbuf":Ljava/lang/StringBuffer;
    const/16 v32, 0x0

    .restart local v32    # "i":I
    :goto_6
    move-object/from16 v0, v62

    array-length v9, v0

    move/from16 v0, v32

    if-ge v0, v9, :cond_1c

    .line 177
    aget-object v9, v62, v32

    instance-of v9, v9, Ljava/lang/String;

    if-eqz v9, :cond_18

    .line 179
    if-nez v30, :cond_1b

    .line 181
    new-instance v30, Ljava/lang/StringBuffer;

    .end local v30    # "errbuf":Ljava/lang/StringBuffer;
    invoke-direct/range {v30 .. v30}, Ljava/lang/StringBuffer;-><init>()V

    .line 182
    .restart local v30    # "errbuf":Ljava/lang/StringBuffer;
    const-string v9, "no field or setter "

    move-object/from16 v0, v30

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 186
    :goto_7
    const/16 v9, 0x60

    move-object/from16 v0, v30

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 187
    aget-object v9, v62, v32

    move-object/from16 v0, v30

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 188
    const/16 v9, 0x27

    move-object/from16 v0, v30

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 175
    :cond_18
    add-int/lit8 v32, v32, 0x1

    goto :goto_6

    .line 145
    .end local v3    # "methods":[Lgnu/expr/PrimProcedure;
    .end local v4    # "ctype":Lgnu/bytecode/ObjectType;
    .end local v23    # "caller":Lgnu/bytecode/ClassType;
    .end local v30    # "errbuf":Ljava/lang/StringBuffer;
    .end local v32    # "i":I
    .end local v34    # "index":I
    .end local v38    # "keywordStart":I
    .end local v52    # "numCode":I
    .end local v62    # "slots":[Ljava/lang/Object;
    :cond_19
    move-object/from16 v0, v24

    iget-object v9, v0, Lgnu/expr/Compilation;->curClass:Lgnu/bytecode/ClassType;

    if-eqz v9, :cond_1a

    move-object/from16 v0, v24

    iget-object v0, v0, Lgnu/expr/Compilation;->curClass:Lgnu/bytecode/ClassType;

    move-object/from16 v23, v0

    goto/16 :goto_5

    :cond_1a
    move-object/from16 v0, v24

    iget-object v0, v0, Lgnu/expr/Compilation;->mainClass:Lgnu/bytecode/ClassType;

    move-object/from16 v23, v0

    goto/16 :goto_5

    .line 155
    .restart local v4    # "ctype":Lgnu/bytecode/ObjectType;
    .restart local v23    # "caller":Lgnu/bytecode/ClassType;
    :catch_1
    move-exception v31

    .line 157
    .local v31, "ex":Ljava/lang/Exception;
    const/16 v9, 0x77

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "unknown class: "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual/range {v65 .. v65}, Lgnu/bytecode/ObjectType;->getName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, v24

    invoke-virtual {v0, v9, v10}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    goto/16 :goto_0

    .line 185
    .end local v31    # "ex":Ljava/lang/Exception;
    .restart local v3    # "methods":[Lgnu/expr/PrimProcedure;
    .restart local v30    # "errbuf":Ljava/lang/StringBuffer;
    .restart local v32    # "i":I
    .restart local v34    # "index":I
    .restart local v38    # "keywordStart":I
    .restart local v52    # "numCode":I
    .restart local v62    # "slots":[Ljava/lang/Object;
    :cond_1b
    const-string v9, ", "

    move-object/from16 v0, v30

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_7

    .line 191
    :cond_1c
    if-eqz v30, :cond_1d

    .line 193
    const-string v9, " in class "

    move-object/from16 v0, v30

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 194
    invoke-virtual/range {v65 .. v65}, Lgnu/bytecode/ObjectType;->getName()Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, v30

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 195
    const/16 v9, 0x77

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, v24

    invoke-virtual {v0, v9, v10}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    goto/16 :goto_0

    .line 201
    :cond_1d
    array-length v9, v5

    move/from16 v0, v38

    if-ge v0, v9, :cond_1f

    .line 203
    move/from16 v0, v38

    new-array v0, v0, [Lgnu/expr/Expression;

    move-object/from16 v68, v0

    .line 204
    .restart local v68    # "xargs":[Lgnu/expr/Expression;
    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object/from16 v0, v68

    move/from16 v1, v38

    invoke-static {v5, v9, v0, v10, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 205
    new-instance v9, Lgnu/expr/ApplyExp;

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->getFunction()Lgnu/expr/Expression;

    move-result-object v10

    move-object/from16 v0, v68

    invoke-direct {v9, v10, v0}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v4}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v16

    check-cast v16, Lgnu/expr/ApplyExp;

    .line 209
    .end local v68    # "xargs":[Lgnu/expr/Expression;
    .local v16, "ae":Lgnu/expr/ApplyExp;
    :goto_8
    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lgnu/expr/ApplyExp;->setType(Lgnu/bytecode/Type;)V

    .line 210
    move-object/from16 v28, v16

    .line 211
    .local v28, "e":Lgnu/expr/Expression;
    array-length v9, v5

    if-lez v9, :cond_25

    .line 213
    const/16 v32, 0x0

    :goto_9
    move-object/from16 v0, v62

    array-length v9, v0

    move/from16 v0, v32

    if-ge v0, v9, :cond_22

    .line 215
    aget-object v61, v62, v32

    .line 217
    .local v61, "slot":Ljava/lang/Object;
    move-object/from16 v0, v61

    instance-of v9, v0, Lgnu/bytecode/Method;

    if-eqz v9, :cond_20

    move-object/from16 v9, v61

    .line 218
    check-cast v9, Lgnu/bytecode/Method;

    invoke-virtual {v9}, Lgnu/bytecode/Method;->getParameterTypes()[Lgnu/bytecode/Type;

    move-result-object v9

    const/4 v10, 0x0

    aget-object v64, v9, v10

    .line 223
    .local v64, "stype":Lgnu/bytecode/Type;
    :goto_a
    if-eqz v64, :cond_1e

    .line 224
    move-object/from16 v0, v35

    iget-object v9, v0, Lgnu/kawa/reflect/Invoke;->language:Lgnu/expr/Language;

    move-object/from16 v0, v64

    invoke-virtual {v9, v0}, Lgnu/expr/Language;->getLangTypeFor(Lgnu/bytecode/Type;)Lgnu/bytecode/Type;

    move-result-object v64

    .line 225
    :cond_1e
    mul-int/lit8 v9, v32, 0x2

    add-int v9, v9, v38

    add-int/lit8 v9, v9, 0x1

    aget-object v9, v5, v9

    move-object/from16 v0, p1

    move-object/from16 v1, v64

    invoke-virtual {v0, v9, v1}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v18

    .line 226
    .restart local v18    # "arg":Lgnu/expr/Expression;
    const/4 v9, 0x3

    new-array v0, v9, [Lgnu/expr/Expression;

    move-object/from16 v58, v0

    const/4 v9, 0x0

    aput-object v16, v58, v9

    const/4 v9, 0x1

    new-instance v10, Lgnu/expr/QuoteExp;

    move-object/from16 v0, v61

    invoke-direct {v10, v0}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v10, v58, v9

    const/4 v9, 0x2

    aput-object v18, v58, v9

    .line 228
    .local v58, "sargs":[Lgnu/expr/Expression;
    new-instance v16, Lgnu/expr/ApplyExp;

    .end local v16    # "ae":Lgnu/expr/ApplyExp;
    sget-object v9, Lgnu/kawa/reflect/SlotSet;->setFieldReturnObject:Lgnu/kawa/reflect/SlotSet;

    move-object/from16 v0, v16

    move-object/from16 v1, v58

    invoke-direct {v0, v9, v1}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .line 229
    .restart local v16    # "ae":Lgnu/expr/ApplyExp;
    move-object/from16 v0, v16

    invoke-virtual {v0, v4}, Lgnu/expr/ApplyExp;->setType(Lgnu/bytecode/Type;)V

    .line 213
    add-int/lit8 v32, v32, 0x1

    goto :goto_9

    .line 208
    .end local v16    # "ae":Lgnu/expr/ApplyExp;
    .end local v18    # "arg":Lgnu/expr/Expression;
    .end local v28    # "e":Lgnu/expr/Expression;
    .end local v58    # "sargs":[Lgnu/expr/Expression;
    .end local v61    # "slot":Ljava/lang/Object;
    .end local v64    # "stype":Lgnu/bytecode/Type;
    :cond_1f
    new-instance v16, Lgnu/expr/ApplyExp;

    const/4 v9, 0x0

    aget-object v9, v3, v9

    const/4 v10, 0x1

    new-array v10, v10, [Lgnu/expr/Expression;

    const/4 v11, 0x0

    aput-object v19, v10, v11

    move-object/from16 v0, v16

    invoke-direct {v0, v9, v10}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .restart local v16    # "ae":Lgnu/expr/ApplyExp;
    goto :goto_8

    .line 219
    .restart local v28    # "e":Lgnu/expr/Expression;
    .restart local v61    # "slot":Ljava/lang/Object;
    :cond_20
    move-object/from16 v0, v61

    instance-of v9, v0, Lgnu/bytecode/Field;

    if-eqz v9, :cond_21

    move-object/from16 v9, v61

    .line 220
    check-cast v9, Lgnu/bytecode/Field;

    invoke-virtual {v9}, Lgnu/bytecode/Field;->getType()Lgnu/bytecode/Type;

    move-result-object v64

    .restart local v64    # "stype":Lgnu/bytecode/Type;
    goto :goto_a

    .line 222
    .end local v64    # "stype":Lgnu/bytecode/Type;
    :cond_21
    const/16 v64, 0x0

    .restart local v64    # "stype":Lgnu/bytecode/Type;
    goto :goto_a

    .line 231
    .end local v61    # "slot":Ljava/lang/Object;
    .end local v64    # "stype":Lgnu/bytecode/Type;
    :cond_22
    array-length v9, v5

    move/from16 v0, v38

    if-ne v0, v9, :cond_23

    const/16 v58, 0x1

    .line 233
    .local v58, "sargs":I
    :goto_b
    move-object/from16 v28, v16

    .line 234
    array-length v9, v5

    move/from16 v0, v58

    if-ge v0, v9, :cond_25

    .line 236
    new-instance v43, Lgnu/expr/LetExp;

    const/4 v9, 0x1

    new-array v9, v9, [Lgnu/expr/Expression;

    const/4 v10, 0x0

    aput-object v28, v9, v10

    move-object/from16 v0, v43

    invoke-direct {v0, v9}, Lgnu/expr/LetExp;-><init>([Lgnu/expr/Expression;)V

    .line 237
    .restart local v43    # "let":Lgnu/expr/LetExp;
    const/4 v9, 0x0

    check-cast v9, Ljava/lang/String;

    move-object/from16 v0, v43

    invoke-virtual {v0, v9, v4}, Lgnu/expr/LetExp;->addDeclaration(Ljava/lang/Object;Lgnu/bytecode/Type;)Lgnu/expr/Declaration;

    move-result-object v15

    .line 238
    .restart local v15    # "adecl":Lgnu/expr/Declaration;
    move-object/from16 v0, v28

    invoke-virtual {v15, v0}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 239
    new-instance v22, Lgnu/expr/BeginExp;

    invoke-direct/range {v22 .. v22}, Lgnu/expr/BeginExp;-><init>()V

    .line 240
    .restart local v22    # "begin":Lgnu/expr/BeginExp;
    move/from16 v32, v58

    :goto_c
    array-length v9, v5

    move/from16 v0, v32

    if-ge v0, v9, :cond_24

    .line 242
    const/4 v9, 0x3

    new-array v0, v9, [Lgnu/expr/Expression;

    move-object/from16 v33, v0

    const/4 v9, 0x0

    new-instance v10, Lgnu/expr/ReferenceExp;

    invoke-direct {v10, v15}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v10, v33, v9

    const/4 v9, 0x1

    const-string v10, "add"

    invoke-static {v10}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v10

    aput-object v10, v33, v9

    const/4 v9, 0x2

    aget-object v10, v5, v32

    aput-object v10, v33, v9

    .line 247
    .local v33, "iargs":[Lgnu/expr/Expression;
    new-instance v9, Lgnu/expr/ApplyExp;

    sget-object v10, Lgnu/kawa/reflect/Invoke;->invoke:Lgnu/kawa/reflect/Invoke;

    move-object/from16 v0, v33

    invoke-direct {v9, v10, v0}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    const/4 v10, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v9, v10}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v9

    move-object/from16 v0, v22

    invoke-virtual {v0, v9}, Lgnu/expr/BeginExp;->add(Lgnu/expr/Expression;)V

    .line 240
    add-int/lit8 v32, v32, 0x1

    goto :goto_c

    .line 231
    .end local v15    # "adecl":Lgnu/expr/Declaration;
    .end local v22    # "begin":Lgnu/expr/BeginExp;
    .end local v33    # "iargs":[Lgnu/expr/Expression;
    .end local v43    # "let":Lgnu/expr/LetExp;
    .end local v58    # "sargs":I
    :cond_23
    move-object/from16 v0, v62

    array-length v9, v0

    mul-int/lit8 v9, v9, 0x2

    add-int v58, v9, v38

    goto :goto_b

    .line 251
    .restart local v15    # "adecl":Lgnu/expr/Declaration;
    .restart local v22    # "begin":Lgnu/expr/BeginExp;
    .restart local v43    # "let":Lgnu/expr/LetExp;
    .restart local v58    # "sargs":I
    :cond_24
    new-instance v9, Lgnu/expr/ReferenceExp;

    invoke-direct {v9, v15}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    move-object/from16 v0, v22

    invoke-virtual {v0, v9}, Lgnu/expr/BeginExp;->add(Lgnu/expr/Expression;)V

    .line 252
    move-object/from16 v0, v22

    move-object/from16 v1, v43

    iput-object v0, v1, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    .line 253
    move-object/from16 v28, v43

    .line 256
    .end local v15    # "adecl":Lgnu/expr/Declaration;
    .end local v22    # "begin":Lgnu/expr/BeginExp;
    .end local v43    # "let":Lgnu/expr/LetExp;
    .end local v58    # "sargs":I
    :cond_25
    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lgnu/expr/Expression;->setLine(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v9

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v9, v1}, Lgnu/expr/InlineCalls;->checkType(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object p0

    goto/16 :goto_0

    .line 260
    .end local v16    # "ae":Lgnu/expr/ApplyExp;
    .end local v28    # "e":Lgnu/expr/Expression;
    .end local v30    # "errbuf":Ljava/lang/StringBuffer;
    .end local v32    # "i":I
    .end local v38    # "keywordStart":I
    .end local v62    # "slots":[Ljava/lang/Object;
    :cond_26
    if-ltz v52, :cond_38

    .line 262
    const/16 v32, 0x1

    .restart local v32    # "i":I
    :goto_d
    move/from16 v0, v32

    move/from16 v1, v48

    if-ge v0, v1, :cond_32

    .line 264
    const/16 v21, 0x0

    .line 265
    .local v21, "atype":Lgnu/bytecode/Type;
    add-int/lit8 v9, v48, -0x1

    move/from16 v0, v32

    if-ne v0, v9, :cond_2a

    const/16 v41, 0x1

    .line 266
    .local v41, "last":Z
    :goto_e
    const/16 v9, 0x50

    move/from16 v0, v39

    if-ne v0, v9, :cond_27

    const/4 v9, 0x2

    move/from16 v0, v32

    if-eq v0, v9, :cond_28

    :cond_27
    const/16 v9, 0x4e

    move/from16 v0, v39

    if-eq v0, v9, :cond_2b

    const/4 v9, 0x1

    move/from16 v0, v32

    if-ne v0, v9, :cond_2b

    .line 267
    :cond_28
    const/16 v21, 0x0

    .line 298
    :cond_29
    :goto_f
    aget-object v9, v5, v32

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v9, v1}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v9

    aput-object v9, v5, v32

    .line 262
    add-int/lit8 v32, v32, 0x1

    goto :goto_d

    .line 265
    .end local v41    # "last":Z
    :cond_2a
    const/16 v41, 0x0

    goto :goto_e

    .line 268
    .restart local v41    # "last":Z
    :cond_2b
    const/16 v9, 0x50

    move/from16 v0, v39

    if-ne v0, v9, :cond_2c

    const/4 v9, 0x1

    move/from16 v0, v32

    if-ne v0, v9, :cond_2c

    .line 269
    move-object/from16 v21, v4

    goto :goto_f

    .line 270
    :cond_2c
    if-lez v52, :cond_29

    .line 272
    const/16 v9, 0x4e

    move/from16 v0, v39

    if-ne v0, v9, :cond_2d

    const/4 v9, 0x1

    :goto_10
    sub-int v54, v32, v9

    .line 273
    .local v54, "pi":I
    const/16 v36, 0x0

    .local v36, "j":I
    :goto_11
    move/from16 v0, v36

    move/from16 v1, v52

    if-ge v0, v1, :cond_29

    .line 275
    aget-object v56, v3, v36

    .line 276
    .local v56, "pproc":Lgnu/expr/PrimProcedure;
    const/16 v9, 0x53

    move/from16 v0, v39

    if-eq v0, v9, :cond_2e

    invoke-virtual/range {v56 .. v56}, Lgnu/expr/PrimProcedure;->takesTarget()Z

    move-result v9

    if-eqz v9, :cond_2e

    const/4 v9, 0x1

    :goto_12
    add-int v55, v54, v9

    .line 279
    .local v55, "pii":I
    if-eqz v41, :cond_2f

    invoke-virtual/range {v56 .. v56}, Lgnu/expr/PrimProcedure;->takesVarArgs()Z

    move-result v9

    if-eqz v9, :cond_2f

    invoke-virtual/range {v56 .. v56}, Lgnu/expr/PrimProcedure;->minArgs()I

    move-result v9

    move/from16 v0, v55

    if-ne v0, v9, :cond_2f

    .line 281
    const/16 v21, 0x0

    .line 294
    :goto_13
    if-eqz v21, :cond_29

    .line 273
    add-int/lit8 v36, v36, 0x1

    goto :goto_11

    .end local v36    # "j":I
    .end local v54    # "pi":I
    .end local v55    # "pii":I
    .end local v56    # "pproc":Lgnu/expr/PrimProcedure;
    :cond_2d
    move v9, v7

    .line 272
    goto :goto_10

    .line 276
    .restart local v36    # "j":I
    .restart local v54    # "pi":I
    .restart local v56    # "pproc":Lgnu/expr/PrimProcedure;
    :cond_2e
    const/4 v9, 0x0

    goto :goto_12

    .line 284
    .restart local v55    # "pii":I
    :cond_2f
    move-object/from16 v0, v56

    move/from16 v1, v55

    invoke-virtual {v0, v1}, Lgnu/expr/PrimProcedure;->getParameterType(I)Lgnu/bytecode/Type;

    move-result-object v57

    .line 285
    .local v57, "ptype":Lgnu/bytecode/Type;
    if-nez v36, :cond_30

    .line 286
    move-object/from16 v21, v57

    goto :goto_13

    .line 287
    :cond_30
    move-object/from16 v0, v57

    instance-of v9, v0, Lgnu/bytecode/PrimType;

    move-object/from16 v0, v21

    instance-of v10, v0, Lgnu/bytecode/PrimType;

    if-eq v9, v10, :cond_31

    .line 288
    const/16 v21, 0x0

    goto :goto_13

    .line 291
    :cond_31
    move-object/from16 v0, v21

    move-object/from16 v1, v57

    invoke-static {v0, v1}, Lgnu/bytecode/Type;->lowestCommonSuperType(Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Type;

    move-result-object v21

    goto :goto_13

    .line 300
    .end local v21    # "atype":Lgnu/bytecode/Type;
    .end local v36    # "j":I
    .end local v41    # "last":Z
    .end local v54    # "pi":I
    .end local v55    # "pii":I
    .end local v56    # "pproc":Lgnu/expr/PrimProcedure;
    .end local v57    # "ptype":Lgnu/bytecode/Type;
    :cond_32
    invoke-static/range {v3 .. v8}, Lgnu/kawa/reflect/CompileInvoke;->selectApplicable([Lgnu/expr/PrimProcedure;Lgnu/bytecode/ObjectType;[Lgnu/expr/Expression;III)J

    move-result-wide v50

    .line 302
    .local v50, "num":J
    const/16 v9, 0x20

    shr-long v9, v50, v9

    long-to-int v0, v9

    move/from16 v53, v0

    .line 303
    .local v53, "okCount":I
    move-wide/from16 v0, v50

    long-to-int v0, v0

    move/from16 v45, v0

    .line 310
    .end local v32    # "i":I
    .end local v50    # "num":J
    .local v45, "maybeCount":I
    :goto_14
    array-length v0, v3

    move/from16 v49, v0

    .line 311
    .local v49, "nmethods":I
    add-int v9, v53, v45

    if-nez v9, :cond_33

    const/16 v9, 0x4e

    move/from16 v0, v39

    if-ne v0, v9, :cond_33

    .line 313
    const-string v9, "valueOf"

    sget-object v10, Lgnu/kawa/reflect/Invoke;->invokeStatic:Lgnu/kawa/reflect/Invoke;

    move-object/from16 v0, v23

    invoke-static {v4, v9, v0, v10}, Lgnu/kawa/reflect/CompileInvoke;->getMethods(Lgnu/bytecode/ObjectType;Ljava/lang/String;Lgnu/bytecode/ClassType;Lgnu/kawa/reflect/Invoke;)[Lgnu/expr/PrimProcedure;

    move-result-object v3

    .line 314
    const/4 v7, 0x1

    .line 315
    add-int/lit8 v6, v48, -0x1

    .line 316
    const/4 v14, -0x1

    move-object v9, v3

    move-object v10, v4

    move-object v11, v5

    move v12, v6

    move v13, v7

    invoke-static/range {v9 .. v14}, Lgnu/kawa/reflect/CompileInvoke;->selectApplicable([Lgnu/expr/PrimProcedure;Lgnu/bytecode/ObjectType;[Lgnu/expr/Expression;III)J

    move-result-wide v50

    .line 318
    .restart local v50    # "num":J
    const/16 v9, 0x20

    shr-long v9, v50, v9

    long-to-int v0, v9

    move/from16 v53, v0

    .line 319
    move-wide/from16 v0, v50

    long-to-int v0, v0

    move/from16 v45, v0

    .line 321
    .end local v50    # "num":J
    :cond_33
    add-int v9, v53, v45

    if-nez v9, :cond_3d

    .line 323
    const/16 v9, 0x50

    move/from16 v0, v39

    if-eq v0, v9, :cond_34

    invoke-virtual/range {v24 .. v24}, Lgnu/expr/Compilation;->warnInvokeUnknownMethod()Z

    move-result v9

    if-eqz v9, :cond_36

    .line 325
    :cond_34
    const/16 v9, 0x4e

    move/from16 v0, v39

    if-ne v0, v9, :cond_35

    .line 326
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v47

    invoke-virtual {v9, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "/valueOf"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v47

    .line 327
    :cond_35
    new-instance v59, Ljava/lang/StringBuilder;

    invoke-direct/range {v59 .. v59}, Ljava/lang/StringBuilder;-><init>()V

    .line 328
    .local v59, "sbuf":Ljava/lang/StringBuilder;
    array-length v9, v3

    add-int v9, v9, v49

    if-nez v9, :cond_39

    .line 329
    const-string v9, "no accessible method \'"

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 336
    :goto_15
    move-object/from16 v0, v59

    move-object/from16 v1, v47

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 337
    const-string v9, "\' in "

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 338
    invoke-virtual/range {v65 .. v65}, Lgnu/bytecode/ObjectType;->getName()Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 339
    const/16 v9, 0x50

    move/from16 v0, v39

    if-ne v0, v9, :cond_3c

    const/16 v9, 0x65

    :goto_16
    invoke-virtual/range {v59 .. v59}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, v24

    invoke-virtual {v0, v9, v10}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 391
    .end local v59    # "sbuf":Ljava/lang/StringBuilder;
    :cond_36
    :goto_17
    if-ltz v34, :cond_49

    .line 393
    new-array v0, v6, [Lgnu/expr/Expression;

    move-object/from16 v44, v0

    .line 394
    .local v44, "margs":[Lgnu/expr/Expression;
    aget-object v46, v3, v34

    .line 395
    .local v46, "method":Lgnu/expr/PrimProcedure;
    invoke-virtual/range {v46 .. v46}, Lgnu/expr/PrimProcedure;->takesVarArgs()Z

    move-result v67

    .line 396
    .local v67, "variable":Z
    const/16 v26, 0x0

    .line 397
    .local v26, "dst":I
    if-ltz v8, :cond_37

    .line 398
    add-int/lit8 v27, v26, 0x1

    .end local v26    # "dst":I
    .local v27, "dst":I
    aget-object v9, v5, v8

    aput-object v9, v44, v26

    move/from16 v26, v27

    .line 399
    .end local v27    # "dst":I
    .restart local v26    # "dst":I
    :cond_37
    move/from16 v63, v7

    .line 400
    .local v63, "src":I
    :goto_18
    array-length v9, v5

    move/from16 v0, v63

    if-ge v0, v9, :cond_48

    move-object/from16 v0, v44

    array-length v9, v0

    move/from16 v0, v26

    if-ge v0, v9, :cond_48

    .line 403
    aget-object v9, v5, v63

    aput-object v9, v44, v26

    .line 401
    add-int/lit8 v63, v63, 0x1

    add-int/lit8 v26, v26, 0x1

    goto :goto_18

    .line 307
    .end local v26    # "dst":I
    .end local v44    # "margs":[Lgnu/expr/Expression;
    .end local v45    # "maybeCount":I
    .end local v46    # "method":Lgnu/expr/PrimProcedure;
    .end local v49    # "nmethods":I
    .end local v53    # "okCount":I
    .end local v63    # "src":I
    .end local v67    # "variable":Z
    :cond_38
    const/16 v53, 0x0

    .line 308
    .restart local v53    # "okCount":I
    const/16 v45, 0x0

    .restart local v45    # "maybeCount":I
    goto/16 :goto_14

    .line 330
    .restart local v49    # "nmethods":I
    .restart local v59    # "sbuf":Ljava/lang/StringBuilder;
    :cond_39
    const/high16 v9, -0xf0000

    move/from16 v0, v52

    if-ne v0, v9, :cond_3a

    .line 331
    const-string v9, "too few arguments for method \'"

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_15

    .line 332
    :cond_3a
    const/high16 v9, -0xe0000

    move/from16 v0, v52

    if-ne v0, v9, :cond_3b

    .line 333
    const-string v9, "too many arguments for method \'"

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_15

    .line 335
    :cond_3b
    const-string v9, "no possibly applicable method \'"

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_15

    .line 339
    :cond_3c
    const/16 v9, 0x77

    goto :goto_16

    .line 342
    .end local v59    # "sbuf":Ljava/lang/StringBuilder;
    :cond_3d
    const/4 v9, 0x1

    move/from16 v0, v53

    if-eq v0, v9, :cond_3e

    if-nez v53, :cond_3f

    const/4 v9, 0x1

    move/from16 v0, v45

    if-ne v0, v9, :cond_3f

    .line 343
    :cond_3e
    const/16 v34, 0x0

    goto :goto_17

    .line 344
    :cond_3f
    if-lez v53, :cond_45

    .line 346
    move/from16 v0, v53

    invoke-static {v3, v0}, Lgnu/mapping/MethodProc;->mostSpecific([Lgnu/mapping/MethodProc;I)I

    move-result v34

    .line 347
    if-gez v34, :cond_40

    .line 349
    const/16 v9, 0x53

    move/from16 v0, v39

    if-ne v0, v9, :cond_40

    .line 354
    const/16 v32, 0x0

    .restart local v32    # "i":I
    :goto_19
    move/from16 v0, v32

    move/from16 v1, v53

    if-ge v0, v1, :cond_40

    .line 356
    aget-object v9, v3, v32

    invoke-virtual {v9}, Lgnu/expr/PrimProcedure;->getStaticFlag()Z

    move-result v9

    if-eqz v9, :cond_43

    .line 358
    if-ltz v34, :cond_42

    .line 360
    const/16 v34, -0x1

    .line 369
    .end local v32    # "i":I
    :cond_40
    if-gez v34, :cond_36

    const/16 v9, 0x50

    move/from16 v0, v39

    if-eq v0, v9, :cond_41

    invoke-virtual/range {v24 .. v24}, Lgnu/expr/Compilation;->warnInvokeUnknownMethod()Z

    move-result v9

    if-eqz v9, :cond_36

    .line 372
    :cond_41
    new-instance v59, Ljava/lang/StringBuffer;

    invoke-direct/range {v59 .. v59}, Ljava/lang/StringBuffer;-><init>()V

    .line 373
    .local v59, "sbuf":Ljava/lang/StringBuffer;
    const-string v9, "more than one definitely applicable method `"

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 374
    move-object/from16 v0, v59

    move-object/from16 v1, v47

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 375
    const-string v9, "\' in "

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 376
    invoke-virtual/range {v65 .. v65}, Lgnu/bytecode/ObjectType;->getName()Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 377
    move/from16 v0, v53

    move-object/from16 v1, v59

    invoke-static {v3, v0, v1}, Lgnu/kawa/reflect/CompileInvoke;->append([Lgnu/expr/PrimProcedure;ILjava/lang/StringBuffer;)V

    .line 378
    const/16 v9, 0x50

    move/from16 v0, v39

    if-ne v0, v9, :cond_44

    const/16 v9, 0x65

    :goto_1a
    invoke-virtual/range {v59 .. v59}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, v24

    invoke-virtual {v0, v9, v10}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    goto/16 :goto_17

    .line 364
    .end local v59    # "sbuf":Ljava/lang/StringBuffer;
    .restart local v32    # "i":I
    :cond_42
    move/from16 v34, v32

    .line 354
    :cond_43
    add-int/lit8 v32, v32, 0x1

    goto :goto_19

    .line 378
    .end local v32    # "i":I
    .restart local v59    # "sbuf":Ljava/lang/StringBuffer;
    :cond_44
    const/16 v9, 0x77

    goto :goto_1a

    .line 381
    .end local v59    # "sbuf":Ljava/lang/StringBuffer;
    :cond_45
    const/16 v9, 0x50

    move/from16 v0, v39

    if-eq v0, v9, :cond_46

    invoke-virtual/range {v24 .. v24}, Lgnu/expr/Compilation;->warnInvokeUnknownMethod()Z

    move-result v9

    if-eqz v9, :cond_36

    .line 383
    :cond_46
    new-instance v59, Ljava/lang/StringBuffer;

    invoke-direct/range {v59 .. v59}, Ljava/lang/StringBuffer;-><init>()V

    .line 384
    .restart local v59    # "sbuf":Ljava/lang/StringBuffer;
    const-string v9, "more than one possibly applicable method \'"

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 385
    move-object/from16 v0, v59

    move-object/from16 v1, v47

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 386
    const-string v9, "\' in "

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 387
    invoke-virtual/range {v65 .. v65}, Lgnu/bytecode/ObjectType;->getName()Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, v59

    invoke-virtual {v0, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 388
    move/from16 v0, v45

    move-object/from16 v1, v59

    invoke-static {v3, v0, v1}, Lgnu/kawa/reflect/CompileInvoke;->append([Lgnu/expr/PrimProcedure;ILjava/lang/StringBuffer;)V

    .line 389
    const/16 v9, 0x50

    move/from16 v0, v39

    if-ne v0, v9, :cond_47

    const/16 v9, 0x65

    :goto_1b
    invoke-virtual/range {v59 .. v59}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, v24

    invoke-virtual {v0, v9, v10}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    goto/16 :goto_17

    :cond_47
    const/16 v9, 0x77

    goto :goto_1b

    .line 405
    .end local v59    # "sbuf":Ljava/lang/StringBuffer;
    .restart local v26    # "dst":I
    .restart local v44    # "margs":[Lgnu/expr/Expression;
    .restart local v46    # "method":Lgnu/expr/PrimProcedure;
    .restart local v63    # "src":I
    .restart local v67    # "variable":Z
    :cond_48
    new-instance v28, Lgnu/expr/ApplyExp;

    move-object/from16 v0, v28

    move-object/from16 v1, v46

    move-object/from16 v2, v44

    invoke-direct {v0, v1, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .line 406
    .local v28, "e":Lgnu/expr/ApplyExp;
    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lgnu/expr/ApplyExp;->setLine(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    .line 407
    move-object/from16 v0, p1

    move-object/from16 v1, v28

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2}, Lgnu/expr/InlineCalls;->visitApplyOnly(Lgnu/expr/ApplyExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object p0

    goto/16 :goto_0

    .line 410
    .end local v3    # "methods":[Lgnu/expr/PrimProcedure;
    .end local v4    # "ctype":Lgnu/bytecode/ObjectType;
    .end local v23    # "caller":Lgnu/bytecode/ClassType;
    .end local v26    # "dst":I
    .end local v28    # "e":Lgnu/expr/ApplyExp;
    .end local v34    # "index":I
    .end local v44    # "margs":[Lgnu/expr/Expression;
    .end local v45    # "maybeCount":I
    .end local v46    # "method":Lgnu/expr/PrimProcedure;
    .end local v49    # "nmethods":I
    .end local v52    # "numCode":I
    .end local v53    # "okCount":I
    .end local v63    # "src":I
    .end local v67    # "variable":Z
    :cond_49
    invoke-virtual/range {p0 .. p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    goto/16 :goto_0
.end method
