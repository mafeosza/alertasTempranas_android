.class public Lgnu/expr/ProcInitializer;
.super Lgnu/expr/Initializer;
.source "ProcInitializer.java"


# instance fields
.field proc:Lgnu/expr/LambdaExp;


# direct methods
.method public constructor <init>(Lgnu/expr/LambdaExp;Lgnu/expr/Compilation;Lgnu/bytecode/Field;)V
    .locals 2
    .param p1, "lexp"    # Lgnu/expr/LambdaExp;
    .param p2, "comp"    # Lgnu/expr/Compilation;
    .param p3, "field"    # Lgnu/bytecode/Field;

    .prologue
    .line 10
    invoke-direct {p0}, Lgnu/expr/Initializer;-><init>()V

    .line 11
    iput-object p3, p0, Lgnu/expr/ProcInitializer;->field:Lgnu/bytecode/Field;

    .line 12
    iput-object p1, p0, Lgnu/expr/ProcInitializer;->proc:Lgnu/expr/LambdaExp;

    .line 13
    invoke-virtual {p3}, Lgnu/bytecode/Field;->getStaticFlag()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p2}, Lgnu/expr/Compilation;->getModule()Lgnu/expr/ModuleExp;

    move-result-object v0

    .line 15
    .local v0, "heapLambda":Lgnu/expr/LambdaExp;
    :goto_0
    instance-of v1, v0, Lgnu/expr/ModuleExp;

    if-eqz v1, :cond_1

    invoke-virtual {p2}, Lgnu/expr/Compilation;->isStatic()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 17
    iget-object v1, p2, Lgnu/expr/Compilation;->clinitChain:Lgnu/expr/Initializer;

    iput-object v1, p0, Lgnu/expr/ProcInitializer;->next:Lgnu/expr/Initializer;

    .line 18
    iput-object p0, p2, Lgnu/expr/Compilation;->clinitChain:Lgnu/expr/Initializer;

    .line 25
    :goto_1
    return-void

    .line 13
    .end local v0    # "heapLambda":Lgnu/expr/LambdaExp;
    :cond_0
    invoke-virtual {p1}, Lgnu/expr/LambdaExp;->getOwningLambda()Lgnu/expr/LambdaExp;

    move-result-object v0

    goto :goto_0

    .line 22
    .restart local v0    # "heapLambda":Lgnu/expr/LambdaExp;
    :cond_1
    iget-object v1, v0, Lgnu/expr/LambdaExp;->initChain:Lgnu/expr/Initializer;

    iput-object v1, p0, Lgnu/expr/ProcInitializer;->next:Lgnu/expr/Initializer;

    .line 23
    iput-object p0, v0, Lgnu/expr/LambdaExp;->initChain:Lgnu/expr/Initializer;

    goto :goto_1
.end method

.method public static emitLoadModuleMethod(Lgnu/expr/LambdaExp;Lgnu/expr/Compilation;)V
    .locals 25
    .param p0, "proc"    # Lgnu/expr/LambdaExp;
    .param p1, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 30
    move-object/from16 v0, p0

    iget-object v14, v0, Lgnu/expr/LambdaExp;->nameDecl:Lgnu/expr/Declaration;

    .line 31
    .local v14, "pdecl":Lgnu/expr/Declaration;
    if-nez v14, :cond_2

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/LambdaExp;->getName()Ljava/lang/String;

    move-result-object v15

    .line 32
    .local v15, "pname":Ljava/lang/Object;
    :goto_0
    const/4 v12, 0x0

    .line 33
    .local v12, "oldproc":Lgnu/expr/ModuleMethod;
    move-object/from16 v0, p1

    iget-boolean v0, v0, Lgnu/expr/Compilation;->immediate:Z

    move/from16 v21, v0

    if-eqz v21, :cond_0

    if-eqz v15, :cond_0

    if-eqz v14, :cond_0

    .line 37
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v4

    .line 38
    .local v4, "env":Lgnu/mapping/Environment;
    instance-of v0, v15, Lgnu/mapping/Symbol;

    move/from16 v21, v0

    if-eqz v21, :cond_3

    move-object/from16 v21, v15

    check-cast v21, Lgnu/mapping/Symbol;

    move-object/from16 v18, v21

    .line 40
    .local v18, "sym":Lgnu/mapping/Symbol;
    :goto_1
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v21

    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/LambdaExp;->nameDecl:Lgnu/expr/Declaration;

    move-object/from16 v22, v0

    invoke-virtual/range {v21 .. v22}, Lgnu/expr/Language;->getEnvPropertyFor(Lgnu/expr/Declaration;)Ljava/lang/Object;

    move-result-object v17

    .line 41
    .local v17, "property":Ljava/lang/Object;
    const/16 v21, 0x0

    move-object/from16 v0, v18

    move-object/from16 v1, v17

    move-object/from16 v2, v21

    invoke-virtual {v4, v0, v1, v2}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    .line 42
    .local v11, "old":Ljava/lang/Object;
    instance-of v0, v11, Lgnu/expr/ModuleMethod;

    move/from16 v21, v0

    if-eqz v21, :cond_0

    move-object v12, v11

    .line 43
    check-cast v12, Lgnu/expr/ModuleMethod;

    .line 45
    .end local v4    # "env":Lgnu/mapping/Environment;
    .end local v11    # "old":Ljava/lang/Object;
    .end local v17    # "property":Ljava/lang/Object;
    .end local v18    # "sym":Lgnu/mapping/Symbol;
    :cond_0
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v3

    .line 46
    .local v3, "code":Lgnu/bytecode/CodeAttr;
    sget-object v16, Lgnu/expr/Compilation;->typeModuleMethod:Lgnu/bytecode/ClassType;

    .line 48
    .local v16, "procClass":Lgnu/bytecode/ClassType;
    if-nez v12, :cond_4

    .line 50
    move-object/from16 v0, v16

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitNew(Lgnu/bytecode/ClassType;)V

    .line 51
    const/16 v21, 0x1

    move/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitDup(I)V

    .line 52
    const-string v7, "<init>"

    .line 59
    .local v7, "initName":Ljava/lang/String;
    :goto_2
    const/16 v21, 0x4

    move-object/from16 v0, v16

    move/from16 v1, v21

    invoke-virtual {v0, v7, v1}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v6

    .line 60
    .local v6, "initModuleMethod":Lgnu/bytecode/Method;
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/LambdaExp;->getNeedsClosureEnv()Z

    move-result v21

    if-eqz v21, :cond_5

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/LambdaExp;->getOwningLambda()Lgnu/expr/LambdaExp;

    move-result-object v13

    .line 62
    .local v13, "owning":Lgnu/expr/LambdaExp;
    :goto_3
    instance-of v0, v13, Lgnu/expr/ClassExp;

    move/from16 v21, v0

    if-eqz v21, :cond_6

    iget-object v0, v13, Lgnu/expr/LambdaExp;->staticLinkField:Lgnu/bytecode/Field;

    move-object/from16 v21, v0

    if-eqz v21, :cond_6

    .line 63
    invoke-virtual {v3}, Lgnu/bytecode/CodeAttr;->getCurrentScope()Lgnu/bytecode/Scope;

    move-result-object v21

    const/16 v22, 0x1

    invoke-virtual/range {v21 .. v22}, Lgnu/bytecode/Scope;->getVariable(I)Lgnu/bytecode/Variable;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 93
    :goto_4
    invoke-virtual/range {p0 .. p1}, Lgnu/expr/LambdaExp;->getSelectorValue(Lgnu/expr/Compilation;)I

    move-result v21

    move/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 94
    sget-object v21, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v15, v1}, Lgnu/expr/Compilation;->compileConstant(Ljava/lang/Object;Lgnu/expr/Target;)V

    .line 97
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/expr/LambdaExp;->min_args:I

    move/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/LambdaExp;->keywords:[Lgnu/expr/Keyword;

    move-object/from16 v21, v0

    if-nez v21, :cond_b

    move-object/from16 v0, p0

    iget v0, v0, Lgnu/expr/LambdaExp;->max_args:I

    move/from16 v21, v0

    :goto_5
    shl-int/lit8 v21, v21, 0xc

    or-int v21, v21, v22

    move/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 99
    invoke-virtual {v3, v6}, Lgnu/bytecode/CodeAttr;->emitInvoke(Lgnu/bytecode/Method;)V

    .line 101
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/LambdaExp;->properties:[Ljava/lang/Object;

    move-object/from16 v21, v0

    if-eqz v21, :cond_d

    .line 103
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/LambdaExp;->properties:[Ljava/lang/Object;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    array-length v9, v0

    .line 104
    .local v9, "len":I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_6
    if-ge v5, v9, :cond_d

    .line 106
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/LambdaExp;->properties:[Ljava/lang/Object;

    move-object/from16 v21, v0

    aget-object v8, v21, v5

    .line 108
    .local v8, "key":Ljava/lang/Object;
    if-eqz v8, :cond_1

    sget-object v21, Lgnu/mapping/PropertySet;->nameKey:Lgnu/mapping/Symbol;

    move-object/from16 v0, v21

    if-eq v8, v0, :cond_1

    .line 110
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/LambdaExp;->properties:[Ljava/lang/Object;

    move-object/from16 v21, v0

    add-int/lit8 v22, v5, 0x1

    aget-object v20, v21, v22

    .line 111
    .local v20, "val":Ljava/lang/Object;
    const/16 v21, 0x1

    move/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitDup(I)V

    .line 112
    move-object/from16 v0, p1

    invoke-virtual {v0, v8}, Lgnu/expr/Compilation;->compileConstant(Ljava/lang/Object;)V

    .line 113
    sget-object v19, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    .line 114
    .local v19, "target":Lgnu/expr/Target;
    move-object/from16 v0, v20

    instance-of v0, v0, Lgnu/expr/Expression;

    move/from16 v21, v0

    if-eqz v21, :cond_c

    .line 115
    check-cast v20, Lgnu/expr/Expression;

    .end local v20    # "val":Ljava/lang/Object;
    move-object/from16 v0, v20

    move-object/from16 v1, p1

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 118
    :goto_7
    const-string v21, "gnu.mapping.PropertySet"

    invoke-static/range {v21 .. v21}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v21

    const-string v22, "setProperty"

    const/16 v23, 0x2

    invoke-virtual/range {v21 .. v23}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v10

    .line 120
    .local v10, "m":Lgnu/bytecode/Method;
    invoke-virtual {v3, v10}, Lgnu/bytecode/CodeAttr;->emitInvokeVirtual(Lgnu/bytecode/Method;)V

    .line 104
    .end local v10    # "m":Lgnu/bytecode/Method;
    .end local v19    # "target":Lgnu/expr/Target;
    :cond_1
    add-int/lit8 v5, v5, 0x2

    goto :goto_6

    .line 31
    .end local v3    # "code":Lgnu/bytecode/CodeAttr;
    .end local v5    # "i":I
    .end local v6    # "initModuleMethod":Lgnu/bytecode/Method;
    .end local v7    # "initName":Ljava/lang/String;
    .end local v8    # "key":Ljava/lang/Object;
    .end local v9    # "len":I
    .end local v12    # "oldproc":Lgnu/expr/ModuleMethod;
    .end local v13    # "owning":Lgnu/expr/LambdaExp;
    .end local v15    # "pname":Ljava/lang/Object;
    .end local v16    # "procClass":Lgnu/bytecode/ClassType;
    :cond_2
    invoke-virtual {v14}, Lgnu/expr/Declaration;->getSymbol()Ljava/lang/Object;

    move-result-object v15

    goto/16 :goto_0

    .line 38
    .restart local v4    # "env":Lgnu/mapping/Environment;
    .restart local v12    # "oldproc":Lgnu/expr/ModuleMethod;
    .restart local v15    # "pname":Ljava/lang/Object;
    :cond_3
    const-string v21, ""

    invoke-virtual {v15}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v22

    invoke-static/range {v21 .. v22}, Lgnu/mapping/Symbol;->make(Ljava/lang/Object;Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v18

    goto/16 :goto_1

    .line 56
    .end local v4    # "env":Lgnu/mapping/Environment;
    .restart local v3    # "code":Lgnu/bytecode/CodeAttr;
    .restart local v16    # "procClass":Lgnu/bytecode/ClassType;
    :cond_4
    invoke-static/range {v16 .. v16}, Lgnu/expr/Target;->pushValue(Lgnu/bytecode/Type;)Lgnu/expr/Target;

    move-result-object v21

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v12, v1}, Lgnu/expr/Compilation;->compileConstant(Ljava/lang/Object;Lgnu/expr/Target;)V

    .line 57
    const-string v7, "init"

    .restart local v7    # "initName":Ljava/lang/String;
    goto/16 :goto_2

    .line 60
    .restart local v6    # "initModuleMethod":Lgnu/bytecode/Method;
    :cond_5
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->getModule()Lgnu/expr/ModuleExp;

    move-result-object v13

    goto/16 :goto_3

    .line 64
    .restart local v13    # "owning":Lgnu/expr/LambdaExp;
    :cond_6
    instance-of v0, v13, Lgnu/expr/ModuleExp;

    move/from16 v21, v0

    if-eqz v21, :cond_7

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleClass:Lgnu/bytecode/ClassType;

    move-object/from16 v21, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->mainClass:Lgnu/bytecode/ClassType;

    move-object/from16 v22, v0

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    if-ne v0, v1, :cond_8

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->method:Lgnu/bytecode/Method;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lgnu/bytecode/Method;->getStaticFlag()Z

    move-result v21

    if-nez v21, :cond_8

    .line 67
    :cond_7
    invoke-virtual {v3}, Lgnu/bytecode/CodeAttr;->emitPushThis()V

    goto/16 :goto_4

    .line 70
    :cond_8
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleInstanceVar:Lgnu/bytecode/Variable;

    move-object/from16 v21, v0

    if-nez v21, :cond_9

    .line 72
    iget-object v0, v3, Lgnu/bytecode/CodeAttr;->locals:Lgnu/bytecode/LocalVarsAttr;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lgnu/bytecode/LocalVarsAttr;->current_scope:Lgnu/bytecode/Scope;

    move-object/from16 v21, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleClass:Lgnu/bytecode/ClassType;

    move-object/from16 v22, v0

    const-string v23, "$instance"

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v3, v1, v2}, Lgnu/bytecode/Scope;->addVariable(Lgnu/bytecode/CodeAttr;Lgnu/bytecode/Type;Ljava/lang/String;)Lgnu/bytecode/Variable;

    move-result-object v21

    move-object/from16 v0, v21

    move-object/from16 v1, p1

    iput-object v0, v1, Lgnu/expr/Compilation;->moduleInstanceVar:Lgnu/bytecode/Variable;

    .line 76
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleClass:Lgnu/bytecode/ClassType;

    move-object/from16 v21, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->mainClass:Lgnu/bytecode/ClassType;

    move-object/from16 v22, v0

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    if-eq v0, v1, :cond_a

    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->isStatic()Z

    move-result v21

    if-nez v21, :cond_a

    .line 78
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleClass:Lgnu/bytecode/ClassType;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitNew(Lgnu/bytecode/ClassType;)V

    .line 79
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleClass:Lgnu/bytecode/ClassType;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitDup(Lgnu/bytecode/Type;)V

    .line 80
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleClass:Lgnu/bytecode/ClassType;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lgnu/bytecode/ClassType;->constructor:Lgnu/bytecode/Method;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitInvokeSpecial(Lgnu/bytecode/Method;)V

    .line 81
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleClass:Lgnu/bytecode/ClassType;

    move-object/from16 v21, v0

    const-string v22, "$main"

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->mainClass:Lgnu/bytecode/ClassType;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    invoke-virtual/range {v21 .. v24}, Lgnu/bytecode/ClassType;->addField(Ljava/lang/String;Lgnu/bytecode/Type;I)Lgnu/bytecode/Field;

    move-result-object v21

    move-object/from16 v0, v21

    move-object/from16 v1, p1

    iput-object v0, v1, Lgnu/expr/Compilation;->moduleInstanceMainField:Lgnu/bytecode/Field;

    .line 83
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleClass:Lgnu/bytecode/ClassType;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitDup(Lgnu/bytecode/Type;)V

    .line 84
    invoke-virtual {v3}, Lgnu/bytecode/CodeAttr;->emitPushThis()V

    .line 85
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleInstanceMainField:Lgnu/bytecode/Field;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitPutField(Lgnu/bytecode/Field;)V

    .line 89
    :goto_8
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleInstanceVar:Lgnu/bytecode/Variable;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 91
    :cond_9
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleInstanceVar:Lgnu/bytecode/Variable;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    goto/16 :goto_4

    .line 88
    :cond_a
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->moduleInstanceMainField:Lgnu/bytecode/Field;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lgnu/bytecode/CodeAttr;->emitGetStatic(Lgnu/bytecode/Field;)V

    goto :goto_8

    .line 97
    :cond_b
    const/16 v21, -0x1

    goto/16 :goto_5

    .line 117
    .restart local v5    # "i":I
    .restart local v8    # "key":Ljava/lang/Object;
    .restart local v9    # "len":I
    .restart local v19    # "target":Lgnu/expr/Target;
    .restart local v20    # "val":Ljava/lang/Object;
    :cond_c
    move-object/from16 v0, p1

    move-object/from16 v1, v20

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Compilation;->compileConstant(Ljava/lang/Object;Lgnu/expr/Target;)V

    goto/16 :goto_7

    .line 124
    .end local v5    # "i":I
    .end local v8    # "key":Ljava/lang/Object;
    .end local v9    # "len":I
    .end local v19    # "target":Lgnu/expr/Target;
    .end local v20    # "val":Ljava/lang/Object;
    :cond_d
    return-void
.end method


# virtual methods
.method public emit(Lgnu/expr/Compilation;)V
    .locals 2
    .param p1, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 128
    invoke-virtual {p1}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v0

    .line 129
    .local v0, "code":Lgnu/bytecode/CodeAttr;
    iget-object v1, p0, Lgnu/expr/ProcInitializer;->field:Lgnu/bytecode/Field;

    invoke-virtual {v1}, Lgnu/bytecode/Field;->getStaticFlag()Z

    move-result v1

    if-nez v1, :cond_0

    .line 130
    invoke-virtual {v0}, Lgnu/bytecode/CodeAttr;->emitPushThis()V

    .line 132
    :cond_0
    iget-object v1, p0, Lgnu/expr/ProcInitializer;->proc:Lgnu/expr/LambdaExp;

    invoke-static {v1, p1}, Lgnu/expr/ProcInitializer;->emitLoadModuleMethod(Lgnu/expr/LambdaExp;Lgnu/expr/Compilation;)V

    .line 134
    iget-object v1, p0, Lgnu/expr/ProcInitializer;->field:Lgnu/bytecode/Field;

    invoke-virtual {v1}, Lgnu/bytecode/Field;->getStaticFlag()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 135
    iget-object v1, p0, Lgnu/expr/ProcInitializer;->field:Lgnu/bytecode/Field;

    invoke-virtual {v0, v1}, Lgnu/bytecode/CodeAttr;->emitPutStatic(Lgnu/bytecode/Field;)V

    .line 138
    :goto_0
    return-void

    .line 137
    :cond_1
    iget-object v1, p0, Lgnu/expr/ProcInitializer;->field:Lgnu/bytecode/Field;

    invoke-virtual {v0, v1}, Lgnu/bytecode/CodeAttr;->emitPutField(Lgnu/bytecode/Field;)V

    goto :goto_0
.end method

.method public reportError(Ljava/lang/String;Lgnu/expr/Compilation;)V
    .locals 7
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 142
    invoke-virtual {p2}, Lgnu/expr/Compilation;->getFileName()Ljava/lang/String;

    move-result-object v2

    .line 143
    .local v2, "saveFile":Ljava/lang/String;
    invoke-virtual {p2}, Lgnu/expr/Compilation;->getLineNumber()I

    move-result v3

    .line 144
    .local v3, "saveLine":I
    invoke-virtual {p2}, Lgnu/expr/Compilation;->getColumnNumber()I

    move-result v1

    .line 145
    .local v1, "saveColumn":I
    iget-object v5, p0, Lgnu/expr/ProcInitializer;->proc:Lgnu/expr/LambdaExp;

    invoke-virtual {p2, v5}, Lgnu/expr/Compilation;->setLocation(Lgnu/text/SourceLocator;)V

    .line 146
    iget-object v5, p0, Lgnu/expr/ProcInitializer;->proc:Lgnu/expr/LambdaExp;

    invoke-virtual {v5}, Lgnu/expr/LambdaExp;->getName()Ljava/lang/String;

    move-result-object v0

    .line 147
    .local v0, "name":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4, p1}, Ljava/lang/StringBuffer;-><init>(Ljava/lang/String;)V

    .line 148
    .local v4, "sbuf":Ljava/lang/StringBuffer;
    if-nez v0, :cond_0

    .line 149
    const-string v5, "unnamed procedure"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 155
    :goto_0
    const/16 v5, 0x65

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p2, v5, v6}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 156
    invoke-virtual {p2, v2, v3, v1}, Lgnu/expr/Compilation;->setLine(Ljava/lang/String;II)V

    .line 157
    return-void

    .line 152
    :cond_0
    const-string v5, "procedure "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 153
    invoke-virtual {v4, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method
