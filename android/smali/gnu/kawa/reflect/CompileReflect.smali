.class public Lgnu/kawa/reflect/CompileReflect;
.super Ljava/lang/Object;
.source "CompileReflect.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkKnownClass(Lgnu/bytecode/Type;Lgnu/expr/Compilation;)I
    .locals 4
    .param p0, "type"    # Lgnu/bytecode/Type;
    .param p1, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 16
    instance-of v1, p0, Lgnu/bytecode/ClassType;

    if-eqz v1, :cond_0

    invoke-virtual {p0}, Lgnu/bytecode/Type;->isExisting()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 20
    :try_start_0
    invoke-virtual {p0}, Lgnu/bytecode/Type;->getReflectClass()Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 21
    const/4 v1, 0x1

    .line 29
    :goto_0
    return v1

    .line 23
    :catch_0
    move-exception v0

    .line 25
    .local v0, "ex":Ljava/lang/Exception;
    const/16 v1, 0x65

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "unknown class: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lgnu/bytecode/Type;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v1, v2}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 26
    const/4 v1, -0x1

    goto :goto_0

    .line 29
    .end local v0    # "ex":Ljava/lang/Exception;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static inlineClassName(Lgnu/expr/ApplyExp;ILgnu/expr/InlineCalls;)Lgnu/expr/ApplyExp;
    .locals 8
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "carg"    # I
    .param p2, "walker"    # Lgnu/expr/InlineCalls;

    .prologue
    const/4 v7, 0x0

    .line 38
    invoke-virtual {p2}, Lgnu/expr/InlineCalls;->getCompilation()Lgnu/expr/Compilation;

    move-result-object v1

    .line 39
    .local v1, "comp":Lgnu/expr/Compilation;
    invoke-virtual {v1}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v2

    .line 40
    .local v2, "language":Lgnu/expr/Language;
    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v0

    .line 41
    .local v0, "args":[Lgnu/expr/Expression;
    array-length v6, v0

    if-le v6, p1, :cond_0

    .line 43
    aget-object v6, v0, p1

    invoke-virtual {v2, v6}, Lgnu/expr/Language;->getTypeFor(Lgnu/expr/Expression;)Lgnu/bytecode/Type;

    move-result-object v5

    .line 44
    .local v5, "type":Lgnu/bytecode/Type;
    instance-of v6, v5, Lgnu/bytecode/Type;

    if-nez v6, :cond_1

    .line 54
    .end local v5    # "type":Lgnu/bytecode/Type;
    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_0
    :goto_0
    return-object p0

    .line 46
    .restart local v5    # "type":Lgnu/bytecode/Type;
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_1
    invoke-static {v5, v1}, Lgnu/kawa/reflect/CompileReflect;->checkKnownClass(Lgnu/bytecode/Type;Lgnu/expr/Compilation;)I

    .line 47
    array-length v6, v0

    new-array v3, v6, [Lgnu/expr/Expression;

    .line 48
    .local v3, "nargs":[Lgnu/expr/Expression;
    array-length v6, v0

    invoke-static {v0, v7, v3, v7, v6}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 49
    new-instance v6, Lgnu/expr/QuoteExp;

    invoke-direct {v6, v5}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v6, v3, p1

    .line 50
    new-instance v4, Lgnu/expr/ApplyExp;

    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getFunction()Lgnu/expr/Expression;

    move-result-object v6

    invoke-direct {v4, v6, v3}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    .line 51
    .local v4, "nexp":Lgnu/expr/ApplyExp;
    invoke-virtual {v4, p0}, Lgnu/expr/ApplyExp;->setLine(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-object p0, v4

    .line 52
    goto :goto_0
.end method

.method public static validateApplyInstanceOf(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
    .locals 9
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "visitor"    # Lgnu/expr/InlineCalls;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    const/4 v8, 0x1

    .line 60
    invoke-virtual {p0, p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    .line 61
    invoke-static {p0, v8, p1}, Lgnu/kawa/reflect/CompileReflect;->inlineClassName(Lgnu/expr/ApplyExp;ILgnu/expr/InlineCalls;)Lgnu/expr/ApplyExp;

    move-result-object p0

    .line 62
    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v0

    .line 63
    .local v0, "args":[Lgnu/expr/Expression;
    array-length v6, v0

    const/4 v7, 0x2

    if-ne v6, v7, :cond_5

    .line 65
    const/4 v6, 0x0

    aget-object v5, v0, v6

    .line 66
    .local v5, "value":Lgnu/expr/Expression;
    aget-object v3, v0, v8

    .line 67
    .local v3, "texp":Lgnu/expr/Expression;
    instance-of v6, v3, Lgnu/expr/QuoteExp;

    if-eqz v6, :cond_5

    .line 69
    check-cast v3, Lgnu/expr/QuoteExp;

    .end local v3    # "texp":Lgnu/expr/Expression;
    invoke-virtual {v3}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v2

    .line 70
    .local v2, "t":Ljava/lang/Object;
    instance-of v6, v2, Lgnu/bytecode/Type;

    if-eqz v6, :cond_5

    move-object v4, v2

    .line 72
    check-cast v4, Lgnu/bytecode/Type;

    .line 73
    .local v4, "type":Lgnu/bytecode/Type;
    instance-of v6, v4, Lgnu/bytecode/PrimType;

    if-eqz v6, :cond_0

    .line 74
    check-cast v4, Lgnu/bytecode/PrimType;

    .end local v4    # "type":Lgnu/bytecode/Type;
    invoke-virtual {v4}, Lgnu/bytecode/PrimType;->boxedType()Lgnu/bytecode/ClassType;

    move-result-object v4

    .line 75
    .restart local v4    # "type":Lgnu/bytecode/Type;
    :cond_0
    instance-of v6, v5, Lgnu/expr/QuoteExp;

    if-eqz v6, :cond_2

    .line 76
    check-cast v5, Lgnu/expr/QuoteExp;

    .end local v5    # "value":Lgnu/expr/Expression;
    invoke-virtual {v5}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v4, v6}, Lgnu/bytecode/Type;->isInstance(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    sget-object v6, Lgnu/expr/QuoteExp;->trueExp:Lgnu/expr/QuoteExp;

    .line 89
    .end local v2    # "t":Ljava/lang/Object;
    .end local v4    # "type":Lgnu/bytecode/Type;
    :goto_0
    return-object v6

    .line 76
    .restart local v2    # "t":Ljava/lang/Object;
    .restart local v4    # "type":Lgnu/bytecode/Type;
    :cond_1
    sget-object v6, Lgnu/expr/QuoteExp;->falseExp:Lgnu/expr/QuoteExp;

    goto :goto_0

    .line 78
    .restart local v5    # "value":Lgnu/expr/Expression;
    :cond_2
    invoke-virtual {v5}, Lgnu/expr/Expression;->side_effects()Z

    move-result v6

    if-nez v6, :cond_5

    .line 80
    invoke-virtual {v5}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v6

    invoke-virtual {v4, v6}, Lgnu/bytecode/Type;->compare(Lgnu/bytecode/Type;)I

    move-result v1

    .line 81
    .local v1, "comp":I
    if-eq v1, v8, :cond_3

    if-nez v1, :cond_4

    .line 82
    :cond_3
    sget-object v6, Lgnu/expr/QuoteExp;->trueExp:Lgnu/expr/QuoteExp;

    goto :goto_0

    .line 83
    :cond_4
    const/4 v6, -0x3

    if-ne v1, v6, :cond_5

    .line 84
    sget-object v6, Lgnu/expr/QuoteExp;->falseExp:Lgnu/expr/QuoteExp;

    goto :goto_0

    .end local v1    # "comp":I
    .end local v2    # "t":Ljava/lang/Object;
    .end local v4    # "type":Lgnu/bytecode/Type;
    .end local v5    # "value":Lgnu/expr/Expression;
    :cond_5
    move-object v6, p0

    .line 89
    goto :goto_0
.end method

.method public static validateApplySlotGet(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
    .locals 32
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "visitor"    # Lgnu/expr/InlineCalls;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    .line 95
    invoke-virtual/range {p0 .. p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    .line 96
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/InlineCalls;->getCompilation()Lgnu/expr/Compilation;

    move-result-object v7

    .line 97
    .local v7, "comp":Lgnu/expr/Compilation;
    invoke-virtual {v7}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v19

    .local v19, "language":Lgnu/expr/Language;
    move-object/from16 v13, p3

    .line 98
    check-cast v13, Lgnu/kawa/reflect/SlotGet;

    .line 99
    .local v13, "gproc":Lgnu/kawa/reflect/SlotGet;
    iget-boolean v15, v13, Lgnu/kawa/reflect/SlotGet;->isStatic:Z

    .line 101
    .local v15, "isStatic":Z
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v5

    .line 102
    .local v5, "args":[Lgnu/expr/Expression;
    const/16 v28, 0x0

    aget-object v3, v5, v28

    .line 103
    .local v3, "arg0":Lgnu/expr/Expression;
    const/16 v28, 0x1

    aget-object v4, v5, v28

    .line 104
    .local v4, "arg1":Lgnu/expr/Expression;
    invoke-virtual {v4}, Lgnu/expr/Expression;->valueIfConstant()Ljava/lang/Object;

    move-result-object v27

    .line 105
    .local v27, "val1":Ljava/lang/Object;
    const/16 v22, 0x0

    .line 106
    .local v22, "name":Ljava/lang/String;
    move-object/from16 v0, v27

    instance-of v0, v0, Ljava/lang/String;

    move/from16 v28, v0

    if-nez v28, :cond_0

    move-object/from16 v0, v27

    instance-of v0, v0, Lgnu/lists/FString;

    move/from16 v28, v0

    if-nez v28, :cond_0

    move-object/from16 v0, v27

    instance-of v0, v0, Lgnu/mapping/Symbol;

    move/from16 v28, v0

    if-eqz v28, :cond_1

    .line 109
    :cond_0
    invoke-virtual/range {v27 .. v27}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v22

    .line 112
    if-eqz v15, :cond_6

    .line 114
    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Lgnu/expr/Language;->getTypeFor(Lgnu/expr/Expression;)Lgnu/bytecode/Type;

    move-result-object v26

    .line 115
    .local v26, "type":Lgnu/bytecode/Type;
    move-object/from16 v0, v26

    invoke-static {v0, v7}, Lgnu/kawa/reflect/CompileReflect;->checkKnownClass(Lgnu/bytecode/Type;Lgnu/expr/Compilation;)I

    move-result v18

    .line 116
    .local v18, "known":I
    if-gez v18, :cond_2

    .line 203
    .end local v18    # "known":I
    .end local v26    # "type":Lgnu/bytecode/Type;
    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_1
    :goto_0
    return-object p0

    .line 118
    .restart local v18    # "known":I
    .restart local v26    # "type":Lgnu/bytecode/Type;
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_2
    const-string v28, "class"

    move-object/from16 v0, v28

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v28

    if-eqz v28, :cond_4

    .line 120
    if-lez v18, :cond_3

    .line 121
    invoke-virtual/range {v26 .. v26}, Lgnu/bytecode/Type;->getReflectClass()Ljava/lang/Class;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object p0

    goto :goto_0

    .line 122
    :cond_3
    sget-object v28, Lgnu/expr/Compilation;->typeType:Lgnu/bytecode/ClassType;

    const-string v29, "getReflectClass"

    const/16 v30, 0x0

    invoke-virtual/range {v28 .. v30}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v20

    .line 124
    .local v20, "method":Lgnu/bytecode/Method;
    new-instance p0, Lgnu/expr/ApplyExp;

    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    const/16 v28, 0x1

    move/from16 v0, v28

    new-array v0, v0, [Lgnu/expr/Expression;

    move-object/from16 v28, v0

    const/16 v29, 0x0

    aput-object v3, v28, v29

    move-object/from16 v0, p0

    move-object/from16 v1, v20

    move-object/from16 v2, v28

    invoke-direct {v0, v1, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    goto :goto_0

    .line 126
    .end local v20    # "method":Lgnu/bytecode/Method;
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_4
    if-eqz v26, :cond_5

    .line 128
    const/16 v28, 0x2

    move/from16 v0, v28

    new-array v0, v0, [Lgnu/expr/Expression;

    move-object/from16 v23, v0

    const/16 v28, 0x0

    new-instance v29, Lgnu/expr/QuoteExp;

    move-object/from16 v0, v29

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v29, v23, v28

    const/16 v28, 0x1

    aput-object v4, v23, v28

    .line 130
    .local v23, "nargs":[Lgnu/expr/Expression;
    new-instance v24, Lgnu/expr/ApplyExp;

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->getFunction()Lgnu/expr/Expression;

    move-result-object v28

    move-object/from16 v0, v24

    move-object/from16 v1, v28

    move-object/from16 v2, v23

    invoke-direct {v0, v1, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    .line 131
    .local v24, "nexp":Lgnu/expr/ApplyExp;
    move-object/from16 v0, v24

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lgnu/expr/ApplyExp;->setLine(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    .line 132
    move-object/from16 p0, v24

    .line 137
    .end local v18    # "known":I
    .end local v23    # "nargs":[Lgnu/expr/Expression;
    .end local v24    # "nexp":Lgnu/expr/ApplyExp;
    :cond_5
    :goto_1
    move-object/from16 v0, v26

    instance-of v0, v0, Lgnu/bytecode/ArrayType;

    move/from16 v28, v0

    if-nez v28, :cond_1

    .line 139
    move-object/from16 v0, v26

    instance-of v0, v0, Lgnu/bytecode/ObjectType;

    move/from16 v28, v0

    if-eqz v28, :cond_e

    move-object/from16 v8, v26

    .line 141
    check-cast v8, Lgnu/bytecode/ObjectType;

    .line 142
    .local v8, "ctype":Lgnu/bytecode/ObjectType;
    iget-object v0, v7, Lgnu/expr/Compilation;->curClass:Lgnu/bytecode/ClassType;

    move-object/from16 v28, v0

    if-eqz v28, :cond_7

    iget-object v6, v7, Lgnu/expr/Compilation;->curClass:Lgnu/bytecode/ClassType;

    .line 144
    .local v6, "caller":Lgnu/bytecode/ClassType;
    :goto_2
    move-object/from16 v0, v22

    invoke-static {v8, v0, v6}, Lgnu/kawa/reflect/SlotGet;->lookupMember(Lgnu/bytecode/ObjectType;Ljava/lang/String;Lgnu/bytecode/ClassType;)Lgnu/bytecode/Member;

    move-result-object v25

    .line 145
    .local v25, "part":Lgnu/bytecode/Member;
    move-object/from16 v0, v25

    instance-of v0, v0, Lgnu/bytecode/Field;

    move/from16 v28, v0

    if-eqz v28, :cond_a

    move-object/from16 v10, v25

    .line 147
    check-cast v10, Lgnu/bytecode/Field;

    .line 148
    .local v10, "field":Lgnu/bytecode/Field;
    invoke-virtual {v10}, Lgnu/bytecode/Field;->getModifiers()I

    move-result v21

    .line 149
    .local v21, "modifiers":I
    and-int/lit8 v28, v21, 0x8

    if-eqz v28, :cond_8

    const/16 v16, 0x1

    .line 150
    .local v16, "isStaticField":Z
    :goto_3
    if-eqz v15, :cond_9

    if-nez v16, :cond_9

    .line 151
    new-instance p0, Lgnu/expr/ErrorExp;

    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "cannot access non-static field `"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    move-object/from16 v0, v28

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, "\' using `"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {p3 .. p3}, Lgnu/mapping/Procedure;->getName()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const/16 v29, 0x27

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v7}, Lgnu/expr/ErrorExp;-><init>(Ljava/lang/String;Lgnu/expr/Compilation;)V

    goto/16 :goto_0

    .line 136
    .end local v6    # "caller":Lgnu/bytecode/ClassType;
    .end local v8    # "ctype":Lgnu/bytecode/ObjectType;
    .end local v10    # "field":Lgnu/bytecode/Field;
    .end local v16    # "isStaticField":Z
    .end local v21    # "modifiers":I
    .end local v25    # "part":Lgnu/bytecode/Member;
    .end local v26    # "type":Lgnu/bytecode/Type;
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_6
    invoke-virtual {v3}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v26

    .restart local v26    # "type":Lgnu/bytecode/Type;
    goto :goto_1

    .line 142
    .restart local v8    # "ctype":Lgnu/bytecode/ObjectType;
    :cond_7
    iget-object v6, v7, Lgnu/expr/Compilation;->mainClass:Lgnu/bytecode/ClassType;

    goto :goto_2

    .line 149
    .restart local v6    # "caller":Lgnu/bytecode/ClassType;
    .restart local v10    # "field":Lgnu/bytecode/Field;
    .restart local v21    # "modifiers":I
    .restart local v25    # "part":Lgnu/bytecode/Member;
    :cond_8
    const/16 v16, 0x0

    goto :goto_3

    .line 153
    .restart local v16    # "isStaticField":Z
    :cond_9
    if-eqz v6, :cond_c

    invoke-virtual {v6, v10, v8}, Lgnu/bytecode/ClassType;->isAccessible(Lgnu/bytecode/Member;Lgnu/bytecode/ObjectType;)Z

    move-result v28

    if-nez v28, :cond_c

    .line 155
    new-instance p0, Lgnu/expr/ErrorExp;

    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "field "

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual {v10}, Lgnu/bytecode/Field;->getDeclaringClass()Lgnu/bytecode/ClassType;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Lgnu/bytecode/ClassType;->getName()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const/16 v29, 0x2e

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v28

    move-object/from16 v0, v28

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, " is not accessible here"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v7}, Lgnu/expr/ErrorExp;-><init>(Ljava/lang/String;Lgnu/expr/Compilation;)V

    goto/16 :goto_0

    .line 159
    .end local v10    # "field":Lgnu/bytecode/Field;
    .end local v16    # "isStaticField":Z
    .end local v21    # "modifiers":I
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_a
    move-object/from16 v0, v25

    instance-of v0, v0, Lgnu/bytecode/Method;

    move/from16 v28, v0

    if-eqz v28, :cond_c

    move-object/from16 v20, v25

    .line 161
    check-cast v20, Lgnu/bytecode/Method;

    .line 162
    .restart local v20    # "method":Lgnu/bytecode/Method;
    invoke-virtual/range {v20 .. v20}, Lgnu/bytecode/Method;->getDeclaringClass()Lgnu/bytecode/ClassType;

    move-result-object v9

    .line 163
    .local v9, "dtype":Lgnu/bytecode/ClassType;
    invoke-virtual/range {v20 .. v20}, Lgnu/bytecode/Method;->getModifiers()I

    move-result v21

    .line 164
    .restart local v21    # "modifiers":I
    invoke-virtual/range {v20 .. v20}, Lgnu/bytecode/Method;->getStaticFlag()Z

    move-result v17

    .line 165
    .local v17, "isStaticMethod":Z
    if-eqz v15, :cond_b

    if-nez v17, :cond_b

    .line 166
    new-instance p0, Lgnu/expr/ErrorExp;

    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "cannot call non-static getter method `"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    move-object/from16 v0, v28

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, "\' using `"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {p3 .. p3}, Lgnu/mapping/Procedure;->getName()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const/16 v29, 0x27

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v7}, Lgnu/expr/ErrorExp;-><init>(Ljava/lang/String;Lgnu/expr/Compilation;)V

    goto/16 :goto_0

    .line 168
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_b
    if-eqz v6, :cond_c

    move/from16 v0, v21

    invoke-virtual {v6, v9, v8, v0}, Lgnu/bytecode/ClassType;->isAccessible(Lgnu/bytecode/ClassType;Lgnu/bytecode/ObjectType;I)Z

    move-result v28

    if-nez v28, :cond_c

    .line 169
    new-instance p0, Lgnu/expr/ErrorExp;

    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "method "

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    move-object/from16 v0, v28

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, " is not accessible here"

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1, v7}, Lgnu/expr/ErrorExp;-><init>(Ljava/lang/String;Lgnu/expr/Compilation;)V

    goto/16 :goto_0

    .line 172
    .end local v9    # "dtype":Lgnu/bytecode/ClassType;
    .end local v17    # "isStaticMethod":Z
    .end local v20    # "method":Lgnu/bytecode/Method;
    .end local v21    # "modifiers":I
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_c
    if-eqz v25, :cond_d

    .line 174
    const/16 v28, 0x2

    move/from16 v0, v28

    new-array v0, v0, [Lgnu/expr/Expression;

    move-object/from16 v23, v0

    const/16 v28, 0x0

    aput-object v3, v23, v28

    const/16 v28, 0x1

    new-instance v29, Lgnu/expr/QuoteExp;

    move-object/from16 v0, v29

    move-object/from16 v1, v25

    invoke-direct {v0, v1}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v29, v23, v28

    .line 176
    .restart local v23    # "nargs":[Lgnu/expr/Expression;
    new-instance v24, Lgnu/expr/ApplyExp;

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->getFunction()Lgnu/expr/Expression;

    move-result-object v28

    move-object/from16 v0, v24

    move-object/from16 v1, v28

    move-object/from16 v2, v23

    invoke-direct {v0, v1, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    .line 177
    .restart local v24    # "nexp":Lgnu/expr/ApplyExp;
    move-object/from16 v0, v24

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lgnu/expr/ApplyExp;->setLine(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-object/from16 p0, v24

    .line 178
    goto/16 :goto_0

    .line 180
    .end local v23    # "nargs":[Lgnu/expr/Expression;
    .end local v24    # "nexp":Lgnu/expr/ApplyExp;
    :cond_d
    sget-object v28, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    if-eq v0, v1, :cond_e

    invoke-virtual {v7}, Lgnu/expr/Compilation;->warnUnknownMember()Z

    move-result v28

    if-eqz v28, :cond_e

    .line 181
    const/16 v28, 0x65

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, "no slot `"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    const-string v30, "\' in "

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual {v8}, Lgnu/bytecode/ObjectType;->getName()Ljava/lang/String;

    move-result-object v30

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    move/from16 v0, v28

    move-object/from16 v1, v29

    invoke-virtual {v7, v0, v1}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 184
    .end local v6    # "caller":Lgnu/bytecode/ClassType;
    .end local v8    # "ctype":Lgnu/bytecode/ObjectType;
    .end local v25    # "part":Lgnu/bytecode/Member;
    :cond_e
    invoke-static/range {v22 .. v22}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 187
    .local v11, "fname":Ljava/lang/String;
    invoke-virtual {v11}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v11

    .line 188
    const-string v28, "get"

    move-object/from16 v0, v28

    move-object/from16 v1, v22

    invoke-static {v0, v1}, Lgnu/expr/ClassExp;->slotToMethodName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 189
    .local v12, "getName":Ljava/lang/String;
    const-string v28, "is"

    move-object/from16 v0, v28

    move-object/from16 v1, v22

    invoke-static {v0, v1}, Lgnu/expr/ClassExp;->slotToMethodName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 190
    .local v14, "isName":Ljava/lang/String;
    new-instance v24, Lgnu/expr/ApplyExp;

    sget-object v29, Lgnu/kawa/reflect/Invoke;->invokeStatic:Lgnu/kawa/reflect/Invoke;

    const/16 v28, 0x9

    move/from16 v0, v28

    new-array v0, v0, [Lgnu/expr/Expression;

    move-object/from16 v30, v0

    const/16 v28, 0x0

    const-string v31, "gnu.kawa.reflect.SlotGet"

    invoke-static/range {v31 .. v31}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v31

    aput-object v31, v30, v28

    const/16 v28, 0x1

    const-string v31, "getSlotValue"

    invoke-static/range {v31 .. v31}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v31

    aput-object v31, v30, v28

    const/16 v31, 0x2

    if-eqz v15, :cond_f

    sget-object v28, Lgnu/expr/QuoteExp;->trueExp:Lgnu/expr/QuoteExp;

    :goto_4
    aput-object v28, v30, v31

    const/16 v28, 0x3

    const/16 v31, 0x0

    aget-object v31, v5, v31

    aput-object v31, v30, v28

    const/16 v28, 0x4

    invoke-static/range {v22 .. v22}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v31

    aput-object v31, v30, v28

    const/16 v28, 0x5

    invoke-static {v11}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v31

    aput-object v31, v30, v28

    const/16 v28, 0x6

    invoke-static {v12}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v31

    aput-object v31, v30, v28

    const/16 v28, 0x7

    invoke-static {v14}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v31

    aput-object v31, v30, v28

    const/16 v28, 0x8

    invoke-static/range {v19 .. v19}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v31

    aput-object v31, v30, v28

    move-object/from16 v0, v24

    move-object/from16 v1, v29

    move-object/from16 v2, v30

    invoke-direct {v0, v1, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .line 202
    .restart local v24    # "nexp":Lgnu/expr/ApplyExp;
    move-object/from16 v0, v24

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lgnu/expr/ApplyExp;->setLine(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    .line 203
    const/16 v28, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lgnu/expr/InlineCalls;->visitApplyOnly(Lgnu/expr/ApplyExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object p0

    goto/16 :goto_0

    .line 190
    .end local v24    # "nexp":Lgnu/expr/ApplyExp;
    :cond_f
    sget-object v28, Lgnu/expr/QuoteExp;->falseExp:Lgnu/expr/QuoteExp;

    goto :goto_4
.end method

.method public static validateApplySlotSet(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
    .locals 5
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "visitor"    # Lgnu/expr/InlineCalls;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    const/4 v4, 0x0

    .line 209
    invoke-virtual {p0, p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    move-object v1, p3

    .line 210
    check-cast v1, Lgnu/kawa/reflect/SlotSet;

    .line 215
    .local v1, "sproc":Lgnu/kawa/reflect/SlotSet;
    iget-boolean v0, v1, Lgnu/kawa/reflect/SlotSet;->isStatic:Z

    .line 216
    .local v0, "isStatic":Z
    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lgnu/expr/InlineCalls;->getCompilation()Lgnu/expr/Compilation;

    move-result-object v2

    iget-boolean v2, v2, Lgnu/expr/Compilation;->mustCompile:Z

    if-eqz v2, :cond_0

    .line 217
    invoke-static {p0, v4, p1}, Lgnu/kawa/reflect/CompileReflect;->inlineClassName(Lgnu/expr/ApplyExp;ILgnu/expr/InlineCalls;)Lgnu/expr/ApplyExp;

    move-result-object p0

    .line 218
    :cond_0
    iget-boolean v2, v1, Lgnu/kawa/reflect/SlotSet;->returnSelf:Z

    if-eqz v2, :cond_1

    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getArgCount()I

    move-result v2

    const/4 v3, 0x3

    if-ne v2, v3, :cond_1

    invoke-virtual {p0, v4}, Lgnu/expr/ApplyExp;->getArg(I)Lgnu/expr/Expression;

    move-result-object v2

    invoke-virtual {v2}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v2

    :goto_0
    invoke-virtual {p0, v2}, Lgnu/expr/ApplyExp;->setType(Lgnu/bytecode/Type;)V

    .line 221
    return-object p0

    .line 218
    :cond_1
    sget-object v2, Lgnu/bytecode/Type;->voidType:Lgnu/bytecode/PrimType;

    goto :goto_0
.end method

.method public static validateApplyTypeSwitch(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
    .locals 4
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "visitor"    # Lgnu/expr/InlineCalls;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    .line 227
    invoke-virtual {p0, p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    .line 228
    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v0

    .line 229
    .local v0, "args":[Lgnu/expr/Expression;
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_0
    array-length v3, v0

    if-ge v1, v3, :cond_1

    .line 231
    aget-object v3, v0, v1

    instance-of v3, v3, Lgnu/expr/LambdaExp;

    if-eqz v3, :cond_0

    .line 233
    aget-object v2, v0, v1

    check-cast v2, Lgnu/expr/LambdaExp;

    .line 234
    .local v2, "lexp":Lgnu/expr/LambdaExp;
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lgnu/expr/LambdaExp;->setInlineOnly(Z)V

    .line 235
    iput-object p0, v2, Lgnu/expr/LambdaExp;->returnContinuation:Lgnu/expr/Expression;

    .line 236
    invoke-virtual {p1}, Lgnu/expr/InlineCalls;->getCurrentLambda()Lgnu/expr/LambdaExp;

    move-result-object v3

    iput-object v3, v2, Lgnu/expr/LambdaExp;->inlineHome:Lgnu/expr/LambdaExp;

    .line 229
    .end local v2    # "lexp":Lgnu/expr/LambdaExp;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 239
    :cond_1
    return-object p0
.end method
