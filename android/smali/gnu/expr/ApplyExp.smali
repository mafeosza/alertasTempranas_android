.class public Lgnu/expr/ApplyExp;
.super Lgnu/expr/Expression;
.source "ApplyExp.java"


# static fields
.field public static final INLINE_IF_CONSTANT:I = 0x4

.field public static final MAY_CONTAIN_BACK_JUMP:I = 0x8

.field public static final TAILCALL:I = 0x2


# instance fields
.field args:[Lgnu/expr/Expression;

.field context:Lgnu/expr/LambdaExp;

.field func:Lgnu/expr/Expression;

.field public nextCall:Lgnu/expr/ApplyExp;

.field protected type:Lgnu/bytecode/Type;


# direct methods
.method public constructor <init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V
    .locals 2
    .param p1, "m"    # Lgnu/bytecode/Method;
    .param p2, "a"    # [Lgnu/expr/Expression;

    .prologue
    .line 51
    invoke-direct {p0}, Lgnu/expr/Expression;-><init>()V

    .line 52
    new-instance v0, Lgnu/expr/QuoteExp;

    new-instance v1, Lgnu/expr/PrimProcedure;

    invoke-direct {v1, p1}, Lgnu/expr/PrimProcedure;-><init>(Lgnu/bytecode/Method;)V

    invoke-direct {v0, v1}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    .line 53
    iput-object p2, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    .line 54
    return-void
.end method

.method public constructor <init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V
    .locals 0
    .param p1, "f"    # Lgnu/expr/Expression;
    .param p2, "a"    # [Lgnu/expr/Expression;

    .prologue
    .line 46
    invoke-direct {p0}, Lgnu/expr/Expression;-><init>()V

    iput-object p1, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    iput-object p2, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    return-void
.end method

.method public constructor <init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V
    .locals 1
    .param p1, "p"    # Lgnu/mapping/Procedure;
    .param p2, "a"    # [Lgnu/expr/Expression;

    .prologue
    .line 48
    invoke-direct {p0}, Lgnu/expr/Expression;-><init>()V

    new-instance v0, Lgnu/expr/QuoteExp;

    invoke-direct {v0, p1}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    iput-object p2, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    return-void
.end method

.method public static asInlineable(Lgnu/mapping/Procedure;)Lgnu/expr/Inlineable;
    .locals 1
    .param p0, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    .line 576
    instance-of v0, p0, Lgnu/expr/Inlineable;

    if-eqz v0, :cond_0

    .line 577
    check-cast p0, Lgnu/expr/Inlineable;

    .line 578
    .end local p0    # "proc":Lgnu/mapping/Procedure;
    :goto_0
    return-object p0

    .restart local p0    # "proc":Lgnu/mapping/Procedure;
    :cond_0
    sget-object v0, Lgnu/mapping/Procedure;->compilerKey:Lgnu/mapping/LazyPropertyKey;

    invoke-virtual {v0, p0}, Lgnu/mapping/LazyPropertyKey;->get(Lgnu/mapping/PropertySet;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/expr/Inlineable;

    move-object p0, v0

    goto :goto_0
.end method

.method public static compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 1
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "comp"    # Lgnu/expr/Compilation;
    .param p2, "target"    # Lgnu/expr/Target;

    .prologue
    .line 116
    const/4 v0, 0x0

    invoke-static {p0, p1, p2, v0}, Lgnu/expr/ApplyExp;->compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;Z)V

    .line 117
    return-void
.end method

.method static compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;Z)V
    .locals 33
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "comp"    # Lgnu/expr/Compilation;
    .param p2, "target"    # Lgnu/expr/Target;
    .param p3, "checkInlineable"    # Z

    .prologue
    .line 122
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    array-length v5, v0

    .line 123
    .local v5, "args_length":I
    move-object/from16 v0, p0

    iget-object v9, v0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    .line 124
    .local v9, "exp_func":Lgnu/expr/Expression;
    const/4 v12, 0x0

    .line 125
    .local v12, "func_lambda":Lgnu/expr/LambdaExp;
    const/4 v13, 0x0

    .line 126
    .local v13, "func_name":Ljava/lang/String;
    const/16 v19, 0x0

    .line 127
    .local v19, "owner":Lgnu/expr/Declaration;
    const/16 v22, 0x0

    .line 128
    .local v22, "quotedValue":Ljava/lang/Object;
    instance-of v0, v9, Lgnu/expr/LambdaExp;

    move/from16 v28, v0

    if-eqz v28, :cond_0

    move-object v12, v9

    .line 130
    check-cast v12, Lgnu/expr/LambdaExp;

    .line 131
    invoke-virtual {v12}, Lgnu/expr/LambdaExp;->getName()Ljava/lang/String;

    move-result-object v13

    .line 132
    if-nez v13, :cond_28

    .line 133
    const-string v13, "<lambda>"

    move-object/from16 v28, v22

    .line 163
    .end local v22    # "quotedValue":Ljava/lang/Object;
    :goto_0
    if-eqz p3, :cond_8

    move-object/from16 v0, v28

    instance-of v0, v0, Lgnu/mapping/Procedure;

    move/from16 v29, v0

    if-eqz v29, :cond_8

    move-object/from16 v21, v28

    .line 165
    check-cast v21, Lgnu/mapping/Procedure;

    .line 166
    .local v21, "proc":Lgnu/mapping/Procedure;
    move-object/from16 v0, p2

    instance-of v0, v0, Lgnu/expr/IgnoreTarget;

    move/from16 v29, v0

    if-eqz v29, :cond_6

    invoke-virtual/range {v21 .. v21}, Lgnu/mapping/Procedure;->isSideEffectFree()Z

    move-result v29

    if-eqz v29, :cond_6

    .line 168
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_1
    if-ge v15, v5, :cond_7

    .line 169
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    move-object/from16 v28, v0

    aget-object v28, v28, v15

    move-object/from16 v0, v28

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 168
    add-int/lit8 v15, v15, 0x1

    goto :goto_1

    .line 135
    .end local v15    # "i":I
    .end local v21    # "proc":Lgnu/mapping/Procedure;
    .restart local v22    # "quotedValue":Ljava/lang/Object;
    :cond_0
    instance-of v0, v9, Lgnu/expr/ReferenceExp;

    move/from16 v28, v0

    if-eqz v28, :cond_5

    move-object v14, v9

    .line 137
    check-cast v14, Lgnu/expr/ReferenceExp;

    .line 138
    .local v14, "func_ref":Lgnu/expr/ReferenceExp;
    invoke-virtual {v14}, Lgnu/expr/ReferenceExp;->contextDecl()Lgnu/expr/Declaration;

    move-result-object v19

    .line 139
    iget-object v11, v14, Lgnu/expr/ReferenceExp;->binding:Lgnu/expr/Declaration;

    .line 141
    .local v11, "func_decl":Lgnu/expr/Declaration;
    :goto_2
    if-eqz v11, :cond_1

    invoke-virtual {v11}, Lgnu/expr/Declaration;->isAlias()Z

    move-result v28

    if-eqz v28, :cond_1

    iget-object v0, v11, Lgnu/expr/Declaration;->value:Lgnu/expr/Expression;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    instance-of v0, v0, Lgnu/expr/ReferenceExp;

    move/from16 v28, v0

    if-eqz v28, :cond_1

    .line 143
    iget-object v14, v11, Lgnu/expr/Declaration;->value:Lgnu/expr/Expression;

    .end local v14    # "func_ref":Lgnu/expr/ReferenceExp;
    check-cast v14, Lgnu/expr/ReferenceExp;

    .line 144
    .restart local v14    # "func_ref":Lgnu/expr/ReferenceExp;
    if-nez v19, :cond_1

    invoke-virtual {v11}, Lgnu/expr/Declaration;->needsContext()Z

    move-result v28

    if-nez v28, :cond_1

    iget-object v0, v14, Lgnu/expr/ReferenceExp;->binding:Lgnu/expr/Declaration;

    move-object/from16 v28, v0

    if-nez v28, :cond_4

    .line 149
    :cond_1
    const-wide/32 v28, 0x10000

    move-wide/from16 v0, v28

    invoke-virtual {v11, v0, v1}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v28

    if-nez v28, :cond_3

    .line 151
    invoke-virtual {v11}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v27

    .line 152
    .local v27, "value":Lgnu/expr/Expression;
    invoke-virtual {v11}, Lgnu/expr/Declaration;->getName()Ljava/lang/String;

    move-result-object v13

    .line 153
    if-eqz v27, :cond_2

    move-object/from16 v0, v27

    instance-of v0, v0, Lgnu/expr/LambdaExp;

    move/from16 v28, v0

    if-eqz v28, :cond_2

    move-object/from16 v12, v27

    .line 154
    check-cast v12, Lgnu/expr/LambdaExp;

    .line 155
    :cond_2
    if-eqz v27, :cond_3

    move-object/from16 v0, v27

    instance-of v0, v0, Lgnu/expr/QuoteExp;

    move/from16 v28, v0

    if-eqz v28, :cond_3

    .line 156
    check-cast v27, Lgnu/expr/QuoteExp;

    .end local v27    # "value":Lgnu/expr/Expression;
    invoke-virtual/range {v27 .. v27}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v22

    .end local v22    # "quotedValue":Ljava/lang/Object;
    :cond_3
    move-object/from16 v28, v22

    .line 158
    goto/16 :goto_0

    .line 146
    .restart local v22    # "quotedValue":Ljava/lang/Object;
    :cond_4
    iget-object v11, v14, Lgnu/expr/ReferenceExp;->binding:Lgnu/expr/Declaration;

    .line 147
    invoke-virtual {v14}, Lgnu/expr/ReferenceExp;->contextDecl()Lgnu/expr/Declaration;

    move-result-object v19

    goto :goto_2

    .line 159
    .end local v11    # "func_decl":Lgnu/expr/Declaration;
    .end local v14    # "func_ref":Lgnu/expr/ReferenceExp;
    :cond_5
    instance-of v0, v9, Lgnu/expr/QuoteExp;

    move/from16 v28, v0

    if-eqz v28, :cond_28

    move-object/from16 v28, v9

    .line 161
    check-cast v28, Lgnu/expr/QuoteExp;

    invoke-virtual/range {v28 .. v28}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v28, v22

    goto/16 :goto_0

    .line 174
    .end local v22    # "quotedValue":Ljava/lang/Object;
    .restart local v21    # "proc":Lgnu/mapping/Procedure;
    :cond_6
    :try_start_0
    move-object/from16 v0, v21

    move-object/from16 v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    invoke-static {v0, v1, v2, v3}, Lgnu/expr/ApplyExp;->inlineCompile(Lgnu/mapping/Procedure;Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)Z
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v28

    if-eqz v28, :cond_8

    .line 396
    .end local v21    # "proc":Lgnu/mapping/Procedure;
    .end local p2    # "target":Lgnu/expr/Target;
    :cond_7
    :goto_3
    return-void

    .line 177
    .restart local v21    # "proc":Lgnu/mapping/Procedure;
    .restart local p2    # "target":Lgnu/expr/Target;
    :catch_0
    move-exception v8

    .line 179
    .local v8, "ex":Ljava/lang/Throwable;
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v29

    const/16 v30, 0x65

    new-instance v31, Ljava/lang/StringBuilder;

    invoke-direct/range {v31 .. v31}, Ljava/lang/StringBuilder;-><init>()V

    const-string v32, "caught exception in inline-compiler for "

    invoke-virtual/range {v31 .. v32}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v31

    move-object/from16 v0, v31

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v31, " - "

    move-object/from16 v0, v28

    move-object/from16 v1, v31

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v29

    move/from16 v1, v30

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2, v8}, Lgnu/text/SourceMessages;->error(CLjava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_3

    .line 184
    .end local v8    # "ex":Ljava/lang/Throwable;
    .end local v21    # "proc":Lgnu/mapping/Procedure;
    :cond_8
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v6

    .line 187
    .local v6, "code":Lgnu/bytecode/CodeAttr;
    if-eqz v12, :cond_14

    .line 189
    iget v0, v12, Lgnu/expr/LambdaExp;->max_args:I

    move/from16 v28, v0

    if-ltz v28, :cond_9

    iget v0, v12, Lgnu/expr/LambdaExp;->max_args:I

    move/from16 v28, v0

    move/from16 v0, v28

    if-gt v5, v0, :cond_a

    :cond_9
    iget v0, v12, Lgnu/expr/LambdaExp;->min_args:I

    move/from16 v28, v0

    move/from16 v0, v28

    if-ge v5, v0, :cond_b

    .line 192
    :cond_a
    new-instance v28, Ljava/lang/Error;

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, "internal error - wrong number of parameters for "

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    invoke-direct/range {v28 .. v29}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v28

    .line 194
    :cond_b
    invoke-virtual {v12}, Lgnu/expr/LambdaExp;->getCallConvention()I

    move-result v7

    .line 197
    .local v7, "conv":I
    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Lgnu/expr/Compilation;->inlineOk(Lgnu/expr/Expression;)Z

    move-result v28

    if-eqz v28, :cond_14

    const/16 v28, 0x2

    move/from16 v0, v28

    if-le v7, v0, :cond_c

    const/16 v28, 0x3

    move/from16 v0, v28

    if-ne v7, v0, :cond_14

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->isTailCall()Z

    move-result v28

    if-nez v28, :cond_14

    :cond_c
    invoke-virtual {v12, v5}, Lgnu/expr/LambdaExp;->getMethod(I)Lgnu/bytecode/Method;

    move-result-object v18

    .local v18, "method":Lgnu/bytecode/Method;
    if-eqz v18, :cond_14

    .line 203
    new-instance v20, Lgnu/expr/PrimProcedure;

    move-object/from16 v0, v20

    move-object/from16 v1, v18

    invoke-direct {v0, v1, v12}, Lgnu/expr/PrimProcedure;-><init>(Lgnu/bytecode/Method;Lgnu/expr/LambdaExp;)V

    .line 204
    .local v20, "pproc":Lgnu/expr/PrimProcedure;
    invoke-virtual/range {v18 .. v18}, Lgnu/bytecode/Method;->getStaticFlag()Z

    move-result v17

    .line 205
    .local v17, "is_static":Z
    const/4 v10, 0x0

    .line 207
    .local v10, "extraArg":Z
    if-eqz v17, :cond_d

    invoke-virtual {v12}, Lgnu/expr/LambdaExp;->declareClosureEnv()Lgnu/bytecode/Variable;

    move-result-object v28

    if-eqz v28, :cond_f

    .line 209
    :cond_d
    if-eqz v17, :cond_e

    .line 210
    const/4 v10, 0x1

    .line 211
    :cond_e
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->curLambda:Lgnu/expr/LambdaExp;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    if-ne v0, v12, :cond_11

    .line 212
    iget-object v0, v12, Lgnu/expr/LambdaExp;->closureEnv:Lgnu/bytecode/Variable;

    move-object/from16 v28, v0

    if-eqz v28, :cond_10

    iget-object v0, v12, Lgnu/expr/LambdaExp;->closureEnv:Lgnu/bytecode/Variable;

    move-object/from16 v28, v0

    :goto_4
    move-object/from16 v0, v28

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 221
    :cond_f
    :goto_5
    if-eqz v10, :cond_13

    sget-object v28, Lgnu/bytecode/Type;->voidType:Lgnu/bytecode/PrimType;

    :goto_6
    move-object/from16 v0, v20

    move-object/from16 v1, v28

    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    invoke-virtual {v0, v1, v2, v3, v4}, Lgnu/expr/PrimProcedure;->compile(Lgnu/bytecode/Type;Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto/16 :goto_3

    .line 212
    :cond_10
    iget-object v0, v12, Lgnu/expr/LambdaExp;->thisVariable:Lgnu/bytecode/Variable;

    move-object/from16 v28, v0

    goto :goto_4

    .line 215
    :cond_11
    if-eqz v19, :cond_12

    .line 216
    const/16 v28, 0x0

    const/16 v29, 0x0

    sget-object v30, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, v19

    move-object/from16 v1, v28

    move/from16 v2, v29

    move-object/from16 v3, p1

    move-object/from16 v4, v30

    invoke-virtual {v0, v1, v2, v3, v4}, Lgnu/expr/Declaration;->load(Lgnu/expr/AccessExp;ILgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto :goto_5

    .line 218
    :cond_12
    invoke-virtual {v12}, Lgnu/expr/LambdaExp;->getOwningLambda()Lgnu/expr/LambdaExp;

    move-result-object v28

    move-object/from16 v0, v28

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Lgnu/expr/LambdaExp;->loadHeapFrame(Lgnu/expr/Compilation;)V

    goto :goto_5

    .line 221
    :cond_13
    const/16 v28, 0x0

    goto :goto_6

    .line 285
    .end local v7    # "conv":I
    .end local v10    # "extraArg":Z
    .end local v17    # "is_static":Z
    .end local v18    # "method":Lgnu/bytecode/Method;
    .end local v20    # "pproc":Lgnu/expr/PrimProcedure;
    :cond_14
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->isTailCall()Z

    move-result v28

    if-eqz v28, :cond_15

    if-eqz v12, :cond_15

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->curLambda:Lgnu/expr/LambdaExp;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    if-ne v12, v0, :cond_15

    const/16 v24, 0x1

    .line 289
    .local v24, "tail_recurse":Z
    :goto_7
    if-eqz v12, :cond_17

    invoke-virtual {v12}, Lgnu/expr/LambdaExp;->getInlineOnly()Z

    move-result v28

    if-eqz v28, :cond_17

    if-nez v24, :cond_17

    iget v0, v12, Lgnu/expr/LambdaExp;->min_args:I

    move/from16 v28, v0

    move/from16 v0, v28

    if-ne v0, v5, :cond_17

    .line 292
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    move-object/from16 v28, v0

    const/16 v29, 0x0

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    move-object/from16 v2, p1

    invoke-static {v12, v0, v1, v2}, Lgnu/expr/ApplyExp;->pushArgs(Lgnu/expr/LambdaExp;[Lgnu/expr/Expression;[ILgnu/expr/Compilation;)V

    .line 293
    const/16 v28, 0x80

    move/from16 v0, v28

    invoke-virtual {v12, v0}, Lgnu/expr/LambdaExp;->getFlag(I)Z

    move-result v28

    if-eqz v28, :cond_16

    .line 295
    const/16 v28, 0x0

    const/16 v29, 0x0

    move-object/from16 v0, v28

    move/from16 v1, v29

    invoke-static {v6, v12, v0, v1}, Lgnu/expr/ApplyExp;->popParams(Lgnu/bytecode/CodeAttr;Lgnu/expr/LambdaExp;[IZ)V

    .line 296
    const/16 v28, 0x0

    invoke-virtual {v12}, Lgnu/expr/LambdaExp;->getVarScope()Lgnu/bytecode/Scope;

    move-result-object v29

    move/from16 v0, v28

    move-object/from16 v1, v29

    invoke-virtual {v6, v0, v1}, Lgnu/bytecode/CodeAttr;->emitTailCall(ZLgnu/bytecode/Scope;)V

    goto/16 :goto_3

    .line 285
    .end local v24    # "tail_recurse":Z
    :cond_15
    const/16 v24, 0x0

    goto :goto_7

    .line 299
    .restart local v24    # "tail_recurse":Z
    :cond_16
    iget v0, v12, Lgnu/expr/LambdaExp;->flags:I

    move/from16 v28, v0

    move/from16 v0, v28

    or-int/lit16 v0, v0, 0x80

    move/from16 v28, v0

    move/from16 v0, v28

    iput v0, v12, Lgnu/expr/LambdaExp;->flags:I

    .line 300
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->curLambda:Lgnu/expr/LambdaExp;

    move-object/from16 v23, v0

    .line 301
    .local v23, "saveLambda":Lgnu/expr/LambdaExp;
    move-object/from16 v0, p1

    iput-object v12, v0, Lgnu/expr/Compilation;->curLambda:Lgnu/expr/LambdaExp;

    .line 302
    move-object/from16 v0, p1

    invoke-virtual {v12, v0}, Lgnu/expr/LambdaExp;->allocChildClasses(Lgnu/expr/Compilation;)V

    .line 303
    move-object/from16 v0, p1

    invoke-virtual {v12, v0}, Lgnu/expr/LambdaExp;->allocParameters(Lgnu/expr/Compilation;)V

    .line 304
    const/16 v28, 0x0

    const/16 v29, 0x0

    move-object/from16 v0, v28

    move/from16 v1, v29

    invoke-static {v6, v12, v0, v1}, Lgnu/expr/ApplyExp;->popParams(Lgnu/bytecode/CodeAttr;Lgnu/expr/LambdaExp;[IZ)V

    .line 305
    move-object/from16 v0, p1

    invoke-virtual {v12, v0}, Lgnu/expr/LambdaExp;->enterFunction(Lgnu/expr/Compilation;)V

    .line 306
    iget-object v0, v12, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    move-object/from16 v1, p1

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compileWithPosition(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 307
    move-object/from16 v0, p1

    invoke-virtual {v12, v0}, Lgnu/expr/LambdaExp;->compileEnd(Lgnu/expr/Compilation;)V

    .line 308
    move-object/from16 v0, p1

    invoke-virtual {v12, v0}, Lgnu/expr/LambdaExp;->generateApplyMethods(Lgnu/expr/Compilation;)V

    .line 309
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->popScope()Lgnu/bytecode/Scope;

    .line 310
    move-object/from16 v0, v23

    move-object/from16 v1, p1

    iput-object v0, v1, Lgnu/expr/Compilation;->curLambda:Lgnu/expr/LambdaExp;

    goto/16 :goto_3

    .line 314
    .end local v23    # "saveLambda":Lgnu/expr/LambdaExp;
    :cond_17
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->curLambda:Lgnu/expr/LambdaExp;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lgnu/expr/LambdaExp;->isHandlingTailCalls()Z

    move-result v28

    if-eqz v28, :cond_1d

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->isTailCall()Z

    move-result v28

    if-nez v28, :cond_18

    move-object/from16 v0, p2

    instance-of v0, v0, Lgnu/expr/ConsumerTarget;

    move/from16 v28, v0

    if-eqz v28, :cond_1d

    :cond_18
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/Compilation;->curLambda:Lgnu/expr/LambdaExp;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lgnu/expr/LambdaExp;->getInlineOnly()Z

    move-result v28

    if-nez v28, :cond_1d

    .line 318
    sget-object v26, Lgnu/expr/Compilation;->typeCallContext:Lgnu/bytecode/ClassType;

    .line 319
    .local v26, "typeContext":Lgnu/bytecode/ClassType;
    new-instance v28, Lgnu/expr/StackTarget;

    sget-object v29, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    invoke-direct/range {v28 .. v29}, Lgnu/expr/StackTarget;-><init>(Lgnu/bytecode/Type;)V

    move-object/from16 v0, p1

    move-object/from16 v1, v28

    invoke-virtual {v9, v0, v1}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 321
    const/16 v28, 0x4

    move/from16 v0, v28

    if-gt v5, v0, :cond_1a

    .line 323
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_8
    if-ge v15, v5, :cond_19

    .line 324
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    move-object/from16 v28, v0

    aget-object v28, v28, v15

    sget-object v29, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, v28

    move-object/from16 v1, p1

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compileWithPosition(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 323
    add-int/lit8 v15, v15, 0x1

    goto :goto_8

    .line 325
    :cond_19
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->loadCallContext()V

    .line 326
    sget-object v28, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    new-instance v29, Ljava/lang/StringBuilder;

    invoke-direct/range {v29 .. v29}, Ljava/lang/StringBuilder;-><init>()V

    const-string v30, "check"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    add-int/lit8 v30, v5, 0x1

    invoke-virtual/range {v28 .. v30}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvoke(Lgnu/bytecode/Method;)V

    .line 337
    .end local v15    # "i":I
    :goto_9
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->isTailCall()Z

    move-result v28

    if-eqz v28, :cond_1b

    .line 339
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->emitReturn()V

    goto/16 :goto_3

    .line 332
    :cond_1a
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lgnu/expr/ApplyExp;->compileToArray([Lgnu/expr/Expression;Lgnu/expr/Compilation;)V

    .line 333
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->loadCallContext()V

    .line 334
    sget-object v28, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    const-string v29, "checkN"

    const/16 v30, 0x2

    invoke-virtual/range {v28 .. v30}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvoke(Lgnu/bytecode/Method;)V

    goto :goto_9

    :cond_1b
    move-object/from16 v28, p2

    .line 341
    check-cast v28, Lgnu/expr/ConsumerTarget;

    invoke-virtual/range {v28 .. v28}, Lgnu/expr/ConsumerTarget;->isContextTarget()Z

    move-result v28

    if-eqz v28, :cond_1c

    .line 343
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->loadCallContext()V

    .line 344
    const-string v28, "runUntilDone"

    const/16 v29, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvoke(Lgnu/bytecode/Method;)V

    goto/16 :goto_3

    .line 348
    :cond_1c
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->loadCallContext()V

    .line 349
    check-cast p2, Lgnu/expr/ConsumerTarget;

    .end local p2    # "target":Lgnu/expr/Target;
    invoke-virtual/range {p2 .. p2}, Lgnu/expr/ConsumerTarget;->getConsumerVariable()Lgnu/bytecode/Variable;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 350
    const-string v28, "runUntilValue"

    const/16 v29, 0x1

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    move/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvoke(Lgnu/bytecode/Method;)V

    goto/16 :goto_3

    .line 355
    .end local v26    # "typeContext":Lgnu/bytecode/ClassType;
    .restart local p2    # "target":Lgnu/expr/Target;
    :cond_1d
    if-nez v24, :cond_1e

    .line 356
    new-instance v28, Lgnu/expr/StackTarget;

    sget-object v29, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    invoke-direct/range {v28 .. v29}, Lgnu/expr/StackTarget;-><init>(Lgnu/bytecode/Type;)V

    move-object/from16 v0, p1

    move-object/from16 v1, v28

    invoke-virtual {v9, v0, v1}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 358
    :cond_1e
    if-eqz v24, :cond_20

    iget v0, v12, Lgnu/expr/LambdaExp;->min_args:I

    move/from16 v28, v0

    iget v0, v12, Lgnu/expr/LambdaExp;->max_args:I

    move/from16 v29, v0

    move/from16 v0, v28

    move/from16 v1, v29

    if-eq v0, v1, :cond_1f

    const/16 v25, 0x1

    .line 361
    .local v25, "toArray":Z
    :goto_a
    const/16 v16, 0x0

    .line 362
    .local v16, "incValues":[I
    if-eqz v25, :cond_22

    .line 364
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    move-object/from16 v1, p1

    invoke-static {v0, v1}, Lgnu/expr/ApplyExp;->compileToArray([Lgnu/expr/Expression;Lgnu/expr/Compilation;)V

    .line 365
    sget-object v18, Lgnu/expr/Compilation;->applyNmethod:Lgnu/bytecode/Method;

    .line 383
    .restart local v18    # "method":Lgnu/bytecode/Method;
    :goto_b
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->reachableHere()Z

    move-result v28

    if-nez v28, :cond_26

    .line 385
    const/16 v28, 0x65

    const-string v29, "unreachable code"

    move-object/from16 v0, p1

    move/from16 v1, v28

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    goto/16 :goto_3

    .line 358
    .end local v16    # "incValues":[I
    .end local v18    # "method":Lgnu/bytecode/Method;
    .end local v25    # "toArray":Z
    :cond_1f
    const/16 v25, 0x0

    goto :goto_a

    :cond_20
    const/16 v28, 0x4

    move/from16 v0, v28

    if-le v5, v0, :cond_21

    const/16 v25, 0x1

    goto :goto_a

    :cond_21
    const/16 v25, 0x0

    goto :goto_a

    .line 367
    .restart local v16    # "incValues":[I
    .restart local v25    # "toArray":Z
    :cond_22
    if-eqz v24, :cond_23

    .line 369
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    array-length v0, v0

    move/from16 v28, v0

    move/from16 v0, v28

    new-array v0, v0, [I

    move-object/from16 v16, v0

    .line 370
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    move-object/from16 v1, v16

    move-object/from16 v2, p1

    invoke-static {v12, v0, v1, v2}, Lgnu/expr/ApplyExp;->pushArgs(Lgnu/expr/LambdaExp;[Lgnu/expr/Expression;[ILgnu/expr/Compilation;)V

    .line 371
    const/16 v18, 0x0

    .restart local v18    # "method":Lgnu/bytecode/Method;
    goto :goto_b

    .line 375
    .end local v18    # "method":Lgnu/bytecode/Method;
    :cond_23
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_c
    if-ge v15, v5, :cond_24

    .line 377
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    move-object/from16 v28, v0

    aget-object v28, v28, v15

    sget-object v29, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, v28

    move-object/from16 v1, p1

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compileWithPosition(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 378
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->reachableHere()Z

    move-result v28

    if-nez v28, :cond_25

    .line 381
    :cond_24
    sget-object v28, Lgnu/expr/Compilation;->applymethods:[Lgnu/bytecode/Method;

    aget-object v18, v28, v5

    .restart local v18    # "method":Lgnu/bytecode/Method;
    goto :goto_b

    .line 375
    .end local v18    # "method":Lgnu/bytecode/Method;
    :cond_25
    add-int/lit8 v15, v15, 0x1

    goto :goto_c

    .line 388
    .end local v15    # "i":I
    .restart local v18    # "method":Lgnu/bytecode/Method;
    :cond_26
    if-eqz v24, :cond_27

    .line 390
    move-object/from16 v0, v16

    move/from16 v1, v25

    invoke-static {v6, v12, v0, v1}, Lgnu/expr/ApplyExp;->popParams(Lgnu/bytecode/CodeAttr;Lgnu/expr/LambdaExp;[IZ)V

    .line 391
    const/16 v28, 0x0

    invoke-virtual {v12}, Lgnu/expr/LambdaExp;->getVarScope()Lgnu/bytecode/Scope;

    move-result-object v29

    move/from16 v0, v28

    move-object/from16 v1, v29

    invoke-virtual {v6, v0, v1}, Lgnu/bytecode/CodeAttr;->emitTailCall(ZLgnu/bytecode/Scope;)V

    goto/16 :goto_3

    .line 394
    :cond_27
    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvokeVirtual(Lgnu/bytecode/Method;)V

    .line 395
    sget-object v28, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    move-object/from16 v0, p2

    move-object/from16 v1, p1

    move-object/from16 v2, v28

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Target;->compileFromStack(Lgnu/expr/Compilation;Lgnu/bytecode/Type;)V

    goto/16 :goto_3

    .end local v6    # "code":Lgnu/bytecode/CodeAttr;
    .end local v16    # "incValues":[I
    .end local v18    # "method":Lgnu/bytecode/Method;
    .end local v24    # "tail_recurse":Z
    .end local v25    # "toArray":Z
    .restart local v22    # "quotedValue":Ljava/lang/Object;
    :cond_28
    move-object/from16 v28, v22

    goto/16 :goto_0
.end method

.method public static compileToArray([Lgnu/expr/Expression;Lgnu/expr/Compilation;)V
    .locals 5
    .param p0, "args"    # [Lgnu/expr/Expression;
    .param p1, "comp"    # Lgnu/expr/Compilation;

    .prologue
    const/4 v4, 0x1

    .line 70
    invoke-virtual {p1}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v1

    .line 71
    .local v1, "code":Lgnu/bytecode/CodeAttr;
    array-length v3, p0

    if-nez v3, :cond_1

    .line 73
    sget-object v3, Lgnu/expr/Compilation;->noArgsField:Lgnu/bytecode/Field;

    invoke-virtual {v1, v3}, Lgnu/bytecode/CodeAttr;->emitGetStatic(Lgnu/bytecode/Field;)V

    .line 107
    :cond_0
    return-void

    .line 76
    :cond_1
    array-length v3, p0

    invoke-virtual {v1, v3}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 77
    sget-object v3, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    invoke-virtual {v1, v3}, Lgnu/bytecode/CodeAttr;->emitNewArray(Lgnu/bytecode/Type;)V

    .line 78
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v3, p0

    if-ge v2, v3, :cond_0

    .line 80
    aget-object v0, p0, v2

    .line 81
    .local v0, "arg":Lgnu/expr/Expression;
    invoke-virtual {p1}, Lgnu/expr/Compilation;->usingCPStyle()Z

    move-result v3

    if-eqz v3, :cond_2

    instance-of v3, v0, Lgnu/expr/QuoteExp;

    if-nez v3, :cond_2

    instance-of v3, v0, Lgnu/expr/ReferenceExp;

    if-nez v3, :cond_2

    .line 92
    sget-object v3, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    invoke-virtual {v0, p1, v3}, Lgnu/expr/Expression;->compileWithPosition(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 93
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitSwap()V

    .line 94
    invoke-virtual {v1, v4, v4}, Lgnu/bytecode/CodeAttr;->emitDup(II)V

    .line 95
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitSwap()V

    .line 96
    invoke-virtual {v1, v2}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 97
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitSwap()V

    .line 105
    :goto_1
    sget-object v3, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    invoke-virtual {v1, v3}, Lgnu/bytecode/CodeAttr;->emitArrayStore(Lgnu/bytecode/Type;)V

    .line 78
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 101
    :cond_2
    sget-object v3, Lgnu/expr/Compilation;->objArrayType:Lgnu/bytecode/ArrayType;

    invoke-virtual {v1, v3}, Lgnu/bytecode/CodeAttr;->emitDup(Lgnu/bytecode/Type;)V

    .line 102
    invoke-virtual {v1, v2}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 103
    sget-object v3, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    invoke-virtual {v0, p1, v3}, Lgnu/expr/Expression;->compileWithPosition(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto :goto_1
.end method

.method static derefFunc(Lgnu/expr/Expression;)Lgnu/expr/Expression;
    .locals 3
    .param p0, "afunc"    # Lgnu/expr/Expression;

    .prologue
    .line 542
    instance-of v1, p0, Lgnu/expr/ReferenceExp;

    if-eqz v1, :cond_0

    move-object v1, p0

    .line 544
    check-cast v1, Lgnu/expr/ReferenceExp;

    iget-object v0, v1, Lgnu/expr/ReferenceExp;->binding:Lgnu/expr/Declaration;

    .line 545
    .local v0, "func_decl":Lgnu/expr/Declaration;
    invoke-static {v0}, Lgnu/expr/Declaration;->followAliases(Lgnu/expr/Declaration;)Lgnu/expr/Declaration;

    move-result-object v0

    .line 546
    if-eqz v0, :cond_0

    const-wide/32 v1, 0x10000

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v1

    if-nez v1, :cond_0

    .line 547
    invoke-virtual {v0}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object p0

    .line 549
    .end local v0    # "func_decl":Lgnu/expr/Declaration;
    :cond_0
    return-object p0
.end method

.method static inlineCompile(Lgnu/mapping/Procedure;Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)Z
    .locals 2
    .param p0, "proc"    # Lgnu/mapping/Procedure;
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "comp"    # Lgnu/expr/Compilation;
    .param p3, "target"    # Lgnu/expr/Target;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 584
    invoke-static {p0}, Lgnu/expr/ApplyExp;->asInlineable(Lgnu/mapping/Procedure;)Lgnu/expr/Inlineable;

    move-result-object v0

    .line 585
    .local v0, "compiler":Lgnu/expr/Inlineable;
    if-nez v0, :cond_0

    .line 586
    const/4 v1, 0x0

    .line 588
    :goto_0
    return v1

    .line 587
    :cond_0
    invoke-interface {v0, p1, p2, p3}, Lgnu/expr/Inlineable;->compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 588
    const/4 v1, 0x1

    goto :goto_0
.end method

.method private static popParams(Lgnu/bytecode/CodeAttr;II[ILgnu/expr/Declaration;Lgnu/bytecode/Variable;)V
    .locals 6
    .param p0, "code"    # Lgnu/bytecode/CodeAttr;
    .param p1, "paramNo"    # I
    .param p2, "count"    # I
    .param p3, "incValues"    # [I
    .param p4, "decl"    # Lgnu/expr/Declaration;
    .param p5, "vars"    # Lgnu/bytecode/Variable;

    .prologue
    .line 494
    if-lez p2, :cond_0

    .line 496
    add-int/lit8 p2, p2, -0x1

    .line 497
    add-int/lit8 v1, p1, 0x1

    invoke-virtual {p4}, Lgnu/expr/Declaration;->nextDecl()Lgnu/expr/Declaration;

    move-result-object v4

    invoke-virtual {p4}, Lgnu/expr/Declaration;->getVariable()Lgnu/bytecode/Variable;

    move-result-object v0

    if-nez v0, :cond_1

    move-object v5, p5

    :goto_0
    move-object v0, p0

    move v2, p2

    move-object v3, p3

    invoke-static/range {v0 .. v5}, Lgnu/expr/ApplyExp;->popParams(Lgnu/bytecode/CodeAttr;II[ILgnu/expr/Declaration;Lgnu/bytecode/Variable;)V

    .line 499
    invoke-virtual {p4}, Lgnu/expr/Declaration;->ignorable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 501
    if-eqz p3, :cond_2

    aget v0, p3, p1

    const/high16 v1, 0x10000

    if-eq v0, v1, :cond_2

    .line 502
    aget v0, p3, p1

    int-to-short v0, v0

    invoke-virtual {p0, p5, v0}, Lgnu/bytecode/CodeAttr;->emitInc(Lgnu/bytecode/Variable;S)V

    .line 507
    :cond_0
    :goto_1
    return-void

    .line 497
    :cond_1
    invoke-virtual {p5}, Lgnu/bytecode/Variable;->nextVar()Lgnu/bytecode/Variable;

    move-result-object v5

    goto :goto_0

    .line 504
    :cond_2
    invoke-virtual {p0, p5}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    goto :goto_1
.end method

.method private static popParams(Lgnu/bytecode/CodeAttr;Lgnu/expr/LambdaExp;[IZ)V
    .locals 6
    .param p0, "code"    # Lgnu/bytecode/CodeAttr;
    .param p1, "lexp"    # Lgnu/expr/LambdaExp;
    .param p2, "incValues"    # [I
    .param p3, "toArray"    # Z

    .prologue
    const/4 v1, 0x0

    .line 471
    invoke-virtual {p1}, Lgnu/expr/LambdaExp;->getVarScope()Lgnu/bytecode/Scope;

    move-result-object v0

    invoke-virtual {v0}, Lgnu/bytecode/Scope;->firstVar()Lgnu/bytecode/Variable;

    move-result-object v5

    .line 472
    .local v5, "vars":Lgnu/bytecode/Variable;
    invoke-virtual {p1}, Lgnu/expr/LambdaExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v4

    .line 473
    .local v4, "decls":Lgnu/expr/Declaration;
    if-eqz v5, :cond_0

    invoke-virtual {v5}, Lgnu/bytecode/Variable;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v2, "this"

    if-ne v0, v2, :cond_0

    .line 474
    invoke-virtual {v5}, Lgnu/bytecode/Variable;->nextVar()Lgnu/bytecode/Variable;

    move-result-object v5

    .line 475
    :cond_0
    if-eqz v5, :cond_1

    invoke-virtual {v5}, Lgnu/bytecode/Variable;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v2, "$ctx"

    if-ne v0, v2, :cond_1

    .line 476
    invoke-virtual {v5}, Lgnu/bytecode/Variable;->nextVar()Lgnu/bytecode/Variable;

    move-result-object v5

    .line 477
    :cond_1
    if-eqz v5, :cond_3

    invoke-virtual {v5}, Lgnu/bytecode/Variable;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v2, "argsArray"

    if-ne v0, v2, :cond_3

    .line 479
    if-eqz p3, :cond_2

    .line 481
    const/4 v2, 0x1

    const/4 v3, 0x0

    move-object v0, p0

    invoke-static/range {v0 .. v5}, Lgnu/expr/ApplyExp;->popParams(Lgnu/bytecode/CodeAttr;II[ILgnu/expr/Declaration;Lgnu/bytecode/Variable;)V

    .line 487
    :goto_0
    return-void

    .line 484
    :cond_2
    invoke-virtual {v5}, Lgnu/bytecode/Variable;->nextVar()Lgnu/bytecode/Variable;

    move-result-object v5

    .line 486
    :cond_3
    iget v2, p1, Lgnu/expr/LambdaExp;->min_args:I

    move-object v0, p0

    move-object v3, p2

    invoke-static/range {v0 .. v5}, Lgnu/expr/ApplyExp;->popParams(Lgnu/bytecode/CodeAttr;II[ILgnu/expr/Declaration;Lgnu/bytecode/Variable;)V

    goto :goto_0
.end method

.method private static pushArgs(Lgnu/expr/LambdaExp;[Lgnu/expr/Expression;[ILgnu/expr/Compilation;)V
    .locals 6
    .param p0, "lexp"    # Lgnu/expr/LambdaExp;
    .param p1, "args"    # [Lgnu/expr/Expression;
    .param p2, "incValues"    # [I
    .param p3, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 451
    invoke-virtual {p0}, Lgnu/expr/LambdaExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v3

    .line 452
    .local v3, "param":Lgnu/expr/Declaration;
    array-length v1, p1

    .line 453
    .local v1, "args_length":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_3

    .line 455
    aget-object v0, p1, v2

    .line 456
    .local v0, "arg":Lgnu/expr/Expression;
    invoke-virtual {v3}, Lgnu/expr/Declaration;->ignorable()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 457
    sget-object v4, Lgnu/expr/Target;->Ignore:Lgnu/expr/Target;

    invoke-virtual {v0, p3, v4}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 464
    :cond_0
    :goto_1
    invoke-virtual {v3}, Lgnu/expr/Declaration;->nextDecl()Lgnu/expr/Declaration;

    move-result-object v3

    .line 453
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 458
    :cond_1
    if-eqz p2, :cond_2

    invoke-static {v0, v3}, Lgnu/expr/SetExp;->canUseInc(Lgnu/expr/Expression;Lgnu/expr/Declaration;)I

    move-result v4

    aput v4, p2, v2

    const/high16 v5, 0x10000

    if-ne v4, v5, :cond_0

    .line 462
    :cond_2
    invoke-virtual {v3}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v4

    invoke-static {v4}, Lgnu/expr/StackTarget;->getInstance(Lgnu/bytecode/Type;)Lgnu/expr/Target;

    move-result-object v4

    invoke-virtual {v0, p3, v4}, Lgnu/expr/Expression;->compileWithPosition(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto :goto_1

    .line 466
    .end local v0    # "arg":Lgnu/expr/Expression;
    :cond_3
    return-void
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 5
    .param p1, "ctx"    # Lgnu/mapping/CallContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 60
    iget-object v4, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    invoke-virtual {v4, p1}, Lgnu/expr/Expression;->eval(Lgnu/mapping/CallContext;)Ljava/lang/Object;

    move-result-object v2

    .line 61
    .local v2, "proc":Ljava/lang/Object;
    iget-object v4, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    array-length v1, v4

    .line 62
    .local v1, "n":I
    new-array v3, v1, [Ljava/lang/Object;

    .line 63
    .local v3, "vals":[Ljava/lang/Object;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 64
    iget-object v4, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    aget-object v4, v4, v0

    invoke-virtual {v4, p1}, Lgnu/expr/Expression;->eval(Lgnu/mapping/CallContext;)Ljava/lang/Object;

    move-result-object v4

    aput-object v4, v3, v0

    .line 63
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 65
    :cond_0
    check-cast v2, Lgnu/mapping/Procedure;

    .end local v2    # "proc":Ljava/lang/Object;
    invoke-virtual {v2, v3, p1}, Lgnu/mapping/Procedure;->checkN([Ljava/lang/Object;Lgnu/mapping/CallContext;)V

    .line 66
    return-void
.end method

.method public compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 1
    .param p1, "comp"    # Lgnu/expr/Compilation;
    .param p2, "target"    # Lgnu/expr/Target;

    .prologue
    .line 111
    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0}, Lgnu/expr/ApplyExp;->compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;Z)V

    .line 112
    return-void
.end method

.method public deepCopy(Lgnu/kawa/util/IdentityHashTable;)Lgnu/expr/Expression;
    .locals 4
    .param p1, "mapper"    # Lgnu/kawa/util/IdentityHashTable;

    .prologue
    .line 400
    iget-object v3, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    invoke-static {v3, p1}, Lgnu/expr/ApplyExp;->deepCopy(Lgnu/expr/Expression;Lgnu/kawa/util/IdentityHashTable;)Lgnu/expr/Expression;

    move-result-object v2

    .line 401
    .local v2, "f":Lgnu/expr/Expression;
    iget-object v3, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    invoke-static {v3, p1}, Lgnu/expr/ApplyExp;->deepCopy([Lgnu/expr/Expression;Lgnu/kawa/util/IdentityHashTable;)[Lgnu/expr/Expression;

    move-result-object v0

    .line 402
    .local v0, "a":[Lgnu/expr/Expression;
    if-nez v2, :cond_0

    iget-object v3, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    if-nez v3, :cond_1

    :cond_0
    if-nez v0, :cond_2

    iget-object v3, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    if-eqz v3, :cond_2

    .line 403
    :cond_1
    const/4 v1, 0x0

    .line 406
    :goto_0
    return-object v1

    .line 404
    :cond_2
    new-instance v1, Lgnu/expr/ApplyExp;

    invoke-direct {v1, v2, v0}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    .line 405
    .local v1, "copy":Lgnu/expr/ApplyExp;
    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getFlags()I

    move-result v3

    iput v3, v1, Lgnu/expr/ApplyExp;->flags:I

    goto :goto_0
.end method

.method public getArg(I)Lgnu/expr/Expression;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 34
    iget-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public final getArgCount()I
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    array-length v0, v0

    return v0
.end method

.method public final getArgs()[Lgnu/expr/Expression;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    return-object v0
.end method

.method public final getFunction()Lgnu/expr/Expression;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    return-object v0
.end method

.method public final getFunctionValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    instance-of v0, v0, Lgnu/expr/QuoteExp;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    check-cast v0, Lgnu/expr/QuoteExp;

    invoke-virtual {v0}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getType()Lgnu/bytecode/Type;
    .locals 3

    .prologue
    .line 554
    iget-object v2, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    if-eqz v2, :cond_0

    .line 555
    iget-object v2, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    .line 571
    :goto_0
    return-object v2

    .line 556
    :cond_0
    iget-object v2, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    invoke-static {v2}, Lgnu/expr/ApplyExp;->derefFunc(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v0

    .line 558
    .local v0, "afunc":Lgnu/expr/Expression;
    sget-object v2, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    iput-object v2, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    .line 559
    instance-of v2, v0, Lgnu/expr/QuoteExp;

    if-eqz v2, :cond_2

    .line 561
    check-cast v0, Lgnu/expr/QuoteExp;

    .end local v0    # "afunc":Lgnu/expr/Expression;
    invoke-virtual {v0}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v1

    .line 564
    .local v1, "value":Ljava/lang/Object;
    instance-of v2, v1, Lgnu/mapping/Procedure;

    if-eqz v2, :cond_1

    .line 565
    check-cast v1, Lgnu/mapping/Procedure;

    .end local v1    # "value":Ljava/lang/Object;
    iget-object v2, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    invoke-virtual {v1, v2}, Lgnu/mapping/Procedure;->getReturnType([Lgnu/expr/Expression;)Lgnu/bytecode/Type;

    move-result-object v2

    iput-object v2, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    .line 571
    :cond_1
    :goto_1
    iget-object v2, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    goto :goto_0

    .line 567
    .restart local v0    # "afunc":Lgnu/expr/Expression;
    :cond_2
    instance-of v2, v0, Lgnu/expr/LambdaExp;

    if-eqz v2, :cond_1

    .line 569
    check-cast v0, Lgnu/expr/LambdaExp;

    .end local v0    # "afunc":Lgnu/expr/Expression;
    invoke-virtual {v0}, Lgnu/expr/LambdaExp;->getReturnType()Lgnu/bytecode/Type;

    move-result-object v2

    iput-object v2, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    goto :goto_1
.end method

.method public final getTypeRaw()Lgnu/bytecode/Type;
    .locals 1

    .prologue
    .line 514
    iget-object v0, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    return-object v0
.end method

.method public final inlineIfConstant(Lgnu/mapping/Procedure;Lgnu/expr/InlineCalls;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "proc"    # Lgnu/mapping/Procedure;
    .param p2, "visitor"    # Lgnu/expr/InlineCalls;

    .prologue
    .line 593
    invoke-virtual {p2}, Lgnu/expr/InlineCalls;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lgnu/expr/ApplyExp;->inlineIfConstant(Lgnu/mapping/Procedure;Lgnu/text/SourceMessages;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method public final inlineIfConstant(Lgnu/mapping/Procedure;Lgnu/text/SourceMessages;)Lgnu/expr/Expression;
    .locals 9
    .param p1, "proc"    # Lgnu/mapping/Procedure;
    .param p2, "messages"    # Lgnu/text/SourceMessages;

    .prologue
    .line 604
    iget-object v6, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    array-length v4, v6

    .line 605
    .local v4, "len":I
    new-array v5, v4, [Ljava/lang/Object;

    .line 606
    .local v5, "vals":[Ljava/lang/Object;
    move v3, v4

    .local v3, "i":I
    :goto_0
    add-int/lit8 v3, v3, -0x1

    if-ltz v3, :cond_2

    .line 608
    iget-object v6, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    aget-object v0, v6, v3

    .line 609
    .local v0, "arg":Lgnu/expr/Expression;
    instance-of v6, v0, Lgnu/expr/ReferenceExp;

    if-eqz v6, :cond_1

    move-object v6, v0

    .line 611
    check-cast v6, Lgnu/expr/ReferenceExp;

    invoke-virtual {v6}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v1

    .line 612
    .local v1, "decl":Lgnu/expr/Declaration;
    if-eqz v1, :cond_1

    .line 614
    invoke-virtual {v1}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v0

    .line 615
    sget-object v6, Lgnu/expr/QuoteExp;->undefined_exp:Lgnu/expr/QuoteExp;

    if-ne v0, v6, :cond_1

    .line 632
    .end local v0    # "arg":Lgnu/expr/Expression;
    .end local v1    # "decl":Lgnu/expr/Declaration;
    .end local p0    # "this":Lgnu/expr/ApplyExp;
    :cond_0
    :goto_1
    return-object p0

    .line 619
    .restart local v0    # "arg":Lgnu/expr/Expression;
    .restart local p0    # "this":Lgnu/expr/ApplyExp;
    :cond_1
    instance-of v6, v0, Lgnu/expr/QuoteExp;

    if-eqz v6, :cond_0

    .line 621
    check-cast v0, Lgnu/expr/QuoteExp;

    .end local v0    # "arg":Lgnu/expr/Expression;
    invoke-virtual {v0}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v6

    aput-object v6, v5, v3

    goto :goto_0

    .line 625
    :cond_2
    :try_start_0
    new-instance v6, Lgnu/expr/QuoteExp;

    invoke-virtual {p1, v5}, Lgnu/mapping/Procedure;->applyN([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    iget-object v8, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    invoke-direct {v6, v7, v8}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;Lgnu/bytecode/Type;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-object p0, v6

    goto :goto_1

    .line 627
    :catch_0
    move-exception v2

    .line 629
    .local v2, "ex":Ljava/lang/Throwable;
    if-eqz p2, :cond_0

    .line 630
    const/16 v6, 0x77

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "call to "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " throws "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p2, v6, v7}, Lgnu/text/SourceMessages;->error(CLjava/lang/String;)V

    goto :goto_1
.end method

.method public final isTailCall()Z
    .locals 1

    .prologue
    .line 36
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lgnu/expr/ApplyExp;->getFlag(I)Z

    move-result v0

    return v0
.end method

.method protected mustCompile()Z
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x0

    return v0
.end method

.method public print(Lgnu/mapping/OutPort;)V
    .locals 4
    .param p1, "out"    # Lgnu/mapping/OutPort;

    .prologue
    .line 428
    const-string v1, "(Apply"

    const-string v2, ")"

    const/4 v3, 0x2

    invoke-virtual {p1, v1, v2, v3}, Lgnu/mapping/OutPort;->startLogicalBlock(Ljava/lang/String;Ljava/lang/String;I)V

    .line 429
    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->isTailCall()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 430
    const-string v1, " [tailcall]"

    invoke-virtual {p1, v1}, Lgnu/mapping/OutPort;->print(Ljava/lang/String;)V

    .line 431
    :cond_0
    iget-object v1, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    sget-object v2, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    if-eq v1, v2, :cond_1

    .line 433
    const-string v1, " => "

    invoke-virtual {p1, v1}, Lgnu/mapping/OutPort;->print(Ljava/lang/String;)V

    .line 434
    iget-object v1, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    invoke-virtual {p1, v1}, Lgnu/mapping/OutPort;->print(Ljava/lang/Object;)V

    .line 436
    :cond_1
    invoke-virtual {p1}, Lgnu/mapping/OutPort;->writeSpaceFill()V

    .line 437
    invoke-virtual {p0, p1}, Lgnu/expr/ApplyExp;->printLineColumn(Lgnu/mapping/OutPort;)V

    .line 438
    iget-object v1, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    invoke-virtual {v1, p1}, Lgnu/expr/Expression;->print(Lgnu/mapping/OutPort;)V

    .line 439
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    array-length v1, v1

    if-ge v0, v1, :cond_2

    .line 441
    invoke-virtual {p1}, Lgnu/mapping/OutPort;->writeSpaceLinear()V

    .line 442
    iget-object v1, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    aget-object v1, v1, v0

    invoke-virtual {v1, p1}, Lgnu/expr/Expression;->print(Lgnu/mapping/OutPort;)V

    .line 439
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 444
    :cond_2
    const-string v1, ")"

    invoke-virtual {p1, v1}, Lgnu/mapping/OutPort;->endLogicalBlock(Ljava/lang/String;)V

    .line 445
    return-void
.end method

.method public setArg(ILgnu/expr/Expression;)V
    .locals 1
    .param p1, "i"    # I
    .param p2, "arg"    # Lgnu/expr/Expression;

    .prologue
    .line 35
    iget-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    aput-object p2, v0, p1

    return-void
.end method

.method public setArgs([Lgnu/expr/Expression;)V
    .locals 0
    .param p1, "args"    # [Lgnu/expr/Expression;

    .prologue
    .line 33
    iput-object p1, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    return-void
.end method

.method public setFunction(Lgnu/expr/Expression;)V
    .locals 0
    .param p1, "func"    # Lgnu/expr/Expression;

    .prologue
    .line 32
    iput-object p1, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    return-void
.end method

.method public final setTailCall(Z)V
    .locals 1
    .param p1, "tailCall"    # Z

    .prologue
    .line 38
    const/4 v0, 0x2

    invoke-virtual {p0, p1, v0}, Lgnu/expr/ApplyExp;->setFlag(ZI)V

    return-void
.end method

.method public final setType(Lgnu/bytecode/Type;)V
    .locals 0
    .param p1, "type"    # Lgnu/bytecode/Type;

    .prologue
    .line 519
    iput-object p1, p0, Lgnu/expr/ApplyExp;->type:Lgnu/bytecode/Type;

    .line 520
    return-void
.end method

.method public side_effects()Z
    .locals 6

    .prologue
    const/4 v4, 0x1

    .line 524
    iget-object v5, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    invoke-static {v5}, Lgnu/expr/ApplyExp;->derefFunc(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v5

    invoke-virtual {v5}, Lgnu/expr/Expression;->valueIfConstant()Ljava/lang/Object;

    move-result-object v3

    .line 525
    .local v3, "value":Ljava/lang/Object;
    instance-of v5, v3, Lgnu/mapping/Procedure;

    if-eqz v5, :cond_0

    check-cast v3, Lgnu/mapping/Procedure;

    .end local v3    # "value":Ljava/lang/Object;
    invoke-virtual {v3}, Lgnu/mapping/Procedure;->isSideEffectFree()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 528
    iget-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    .line 529
    .local v0, "a":[Lgnu/expr/Expression;
    array-length v1, v0

    .line 530
    .local v1, "alen":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_2

    .line 532
    aget-object v5, v0, v2

    invoke-virtual {v5}, Lgnu/expr/Expression;->side_effects()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 537
    .end local v0    # "a":[Lgnu/expr/Expression;
    .end local v1    # "alen":I
    .end local v2    # "i":I
    :cond_0
    :goto_1
    return v4

    .line 530
    .restart local v0    # "a":[Lgnu/expr/Expression;
    .restart local v1    # "alen":I
    .restart local v2    # "i":I
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 535
    :cond_2
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 638
    sget-object v0, Lgnu/expr/LambdaExp;->unknownContinuation:Lgnu/expr/ApplyExp;

    if-ne p0, v0, :cond_0

    .line 639
    const-string v0, "ApplyExp[unknownContinuation]"

    .line 640
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ApplyExp/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    if-nez v0, :cond_1

    const/4 v0, 0x0

    :goto_1
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    array-length v0, v0

    goto :goto_1
.end method

.method protected visit(Lgnu/expr/ExpVisitor;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            "D:",
            "Ljava/lang/Object;",
            ">(",
            "Lgnu/expr/ExpVisitor",
            "<TR;TD;>;TD;)TR;"
        }
    .end annotation

    .prologue
    .line 411
    .local p1, "visitor":Lgnu/expr/ExpVisitor;, "Lgnu/expr/ExpVisitor<TR;TD;>;"
    .local p2, "d":Ljava/lang/Object;, "TD;"
    invoke-virtual {p1, p0, p2}, Lgnu/expr/ExpVisitor;->visitApplyExp(Lgnu/expr/ApplyExp;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public visitArgs(Lgnu/expr/InlineCalls;)V
    .locals 3
    .param p1, "visitor"    # Lgnu/expr/InlineCalls;

    .prologue
    .line 416
    iget-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    iget-object v1, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    array-length v1, v1

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v1, v2}, Lgnu/expr/InlineCalls;->visitExps([Lgnu/expr/Expression;ILjava/lang/Object;)[Lgnu/expr/Expression;

    move-result-object v0

    iput-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    .line 417
    return-void
.end method

.method protected visitChildren(Lgnu/expr/ExpVisitor;Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<R:",
            "Ljava/lang/Object;",
            "D:",
            "Ljava/lang/Object;",
            ">(",
            "Lgnu/expr/ExpVisitor",
            "<TR;TD;>;TD;)V"
        }
    .end annotation

    .prologue
    .line 421
    .local p1, "visitor":Lgnu/expr/ExpVisitor;, "Lgnu/expr/ExpVisitor<TR;TD;>;"
    .local p2, "d":Ljava/lang/Object;, "TD;"
    iget-object v0, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    invoke-virtual {p1, v0, p2}, Lgnu/expr/ExpVisitor;->visitAndUpdate(Lgnu/expr/Expression;Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v0

    iput-object v0, p0, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    .line 422
    iget-object v0, p1, Lgnu/expr/ExpVisitor;->exitValue:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 423
    iget-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    iget-object v1, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    array-length v1, v1

    invoke-virtual {p1, v0, v1, p2}, Lgnu/expr/ExpVisitor;->visitExps([Lgnu/expr/Expression;ILjava/lang/Object;)[Lgnu/expr/Expression;

    move-result-object v0

    iput-object v0, p0, Lgnu/expr/ApplyExp;->args:[Lgnu/expr/Expression;

    .line 424
    :cond_0
    return-void
.end method
