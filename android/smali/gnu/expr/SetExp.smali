.class public Lgnu/expr/SetExp;
.super Lgnu/expr/AccessExp;
.source "SetExp.java"


# static fields
.field public static final BAD_SHORT:I = 0x10000

.field public static final DEFINING_FLAG:I = 0x2

.field public static final GLOBAL_FLAG:I = 0x4

.field public static final HAS_VALUE:I = 0x40

.field public static final PREFER_BINDING2:I = 0x8

.field public static final PROCEDURE:I = 0x10

.field public static final SET_IF_UNBOUND:I = 0x20


# instance fields
.field new_value:Lgnu/expr/Expression;


# direct methods
.method public constructor <init>(Lgnu/expr/Declaration;Lgnu/expr/Expression;)V
    .locals 1
    .param p1, "decl"    # Lgnu/expr/Declaration;
    .param p2, "val"    # Lgnu/expr/Expression;

    .prologue
    .line 24
    invoke-direct {p0}, Lgnu/expr/AccessExp;-><init>()V

    .line 25
    iput-object p1, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    .line 26
    invoke-virtual {p1}, Lgnu/expr/Declaration;->getSymbol()Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lgnu/expr/SetExp;->symbol:Ljava/lang/Object;

    .line 27
    iput-object p2, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    .line 28
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;Lgnu/expr/Expression;)V
    .locals 0
    .param p1, "symbol"    # Ljava/lang/Object;
    .param p2, "val"    # Lgnu/expr/Expression;

    .prologue
    .line 21
    invoke-direct {p0}, Lgnu/expr/AccessExp;-><init>()V

    iput-object p1, p0, Lgnu/expr/SetExp;->symbol:Ljava/lang/Object;

    iput-object p2, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    return-void
.end method

.method public static canUseInc(Lgnu/expr/Expression;Lgnu/expr/Declaration;)I
    .locals 18
    .param p0, "rhs"    # Lgnu/expr/Expression;
    .param p1, "target"    # Lgnu/expr/Declaration;

    .prologue
    .line 341
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Declaration;->getVariable()Lgnu/bytecode/Variable;

    move-result-object v15

    .line 343
    .local v15, "var":Lgnu/bytecode/Variable;
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Declaration;->isSimple()Z

    move-result v16

    if-eqz v16, :cond_1

    invoke-virtual {v15}, Lgnu/bytecode/Variable;->getType()Lgnu/bytecode/Type;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lgnu/bytecode/Type;->getImplementationType()Lgnu/bytecode/Type;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lgnu/bytecode/Type;->promote()Lgnu/bytecode/Type;

    move-result-object v16

    sget-object v17, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    if-ne v0, v1, :cond_1

    move-object/from16 v0, p0

    instance-of v0, v0, Lgnu/expr/ApplyExp;

    move/from16 v16, v0

    if-eqz v16, :cond_1

    move-object/from16 v2, p0

    check-cast v2, Lgnu/expr/ApplyExp;

    .local v2, "aexp":Lgnu/expr/ApplyExp;
    invoke-virtual {v2}, Lgnu/expr/ApplyExp;->getArgCount()I

    move-result v16

    const/16 v17, 0x2

    move/from16 v0, v16

    move/from16 v1, v17

    if-ne v0, v1, :cond_1

    .line 348
    invoke-virtual {v2}, Lgnu/expr/ApplyExp;->getFunction()Lgnu/expr/Expression;

    move-result-object v6

    .line 349
    .local v6, "funcExp":Lgnu/expr/Expression;
    invoke-virtual {v6}, Lgnu/expr/Expression;->valueIfConstant()Ljava/lang/Object;

    move-result-object v5

    .line 351
    .local v5, "func":Ljava/lang/Object;
    sget-object v16, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    move-object/from16 v0, v16

    if-ne v5, v0, :cond_2

    .line 352
    const/4 v11, 0x1

    .line 357
    .local v11, "sign":I
    :goto_0
    const/16 v16, 0x0

    move/from16 v0, v16

    invoke-virtual {v2, v0}, Lgnu/expr/ApplyExp;->getArg(I)Lgnu/expr/Expression;

    move-result-object v3

    .line 358
    .local v3, "arg0":Lgnu/expr/Expression;
    const/16 v16, 0x1

    move/from16 v0, v16

    invoke-virtual {v2, v0}, Lgnu/expr/ApplyExp;->getArg(I)Lgnu/expr/Expression;

    move-result-object v4

    .line 359
    .local v4, "arg1":Lgnu/expr/Expression;
    instance-of v0, v3, Lgnu/expr/QuoteExp;

    move/from16 v16, v0

    if-eqz v16, :cond_0

    if-lez v11, :cond_0

    .line 361
    move-object v12, v4

    .line 362
    .local v12, "tmp":Lgnu/expr/Expression;
    move-object v4, v3

    .line 363
    move-object v3, v12

    .line 365
    .end local v12    # "tmp":Lgnu/expr/Expression;
    :cond_0
    instance-of v0, v3, Lgnu/expr/ReferenceExp;

    move/from16 v16, v0

    if-eqz v16, :cond_1

    move-object v10, v3

    .line 367
    check-cast v10, Lgnu/expr/ReferenceExp;

    .line 368
    .local v10, "ref0":Lgnu/expr/ReferenceExp;
    invoke-virtual {v10}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v16

    move-object/from16 v0, v16

    move-object/from16 v1, p1

    if-ne v0, v1, :cond_1

    invoke-virtual {v10}, Lgnu/expr/ReferenceExp;->getDontDereference()Z

    move-result v16

    if-eqz v16, :cond_3

    .line 395
    .end local v2    # "aexp":Lgnu/expr/ApplyExp;
    .end local v3    # "arg0":Lgnu/expr/Expression;
    .end local v4    # "arg1":Lgnu/expr/Expression;
    .end local v5    # "func":Ljava/lang/Object;
    .end local v6    # "funcExp":Lgnu/expr/Expression;
    .end local v10    # "ref0":Lgnu/expr/ReferenceExp;
    .end local v11    # "sign":I
    :cond_1
    const/high16 v13, 0x10000

    :goto_1
    return v13

    .line 353
    .restart local v2    # "aexp":Lgnu/expr/ApplyExp;
    .restart local v5    # "func":Ljava/lang/Object;
    .restart local v6    # "funcExp":Lgnu/expr/Expression;
    :cond_2
    sget-object v16, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    move-object/from16 v0, v16

    if-ne v5, v0, :cond_1

    .line 354
    const/4 v11, -0x1

    .restart local v11    # "sign":I
    goto :goto_0

    .line 370
    .restart local v3    # "arg0":Lgnu/expr/Expression;
    .restart local v4    # "arg1":Lgnu/expr/Expression;
    .restart local v10    # "ref0":Lgnu/expr/ReferenceExp;
    :cond_3
    invoke-virtual {v4}, Lgnu/expr/Expression;->valueIfConstant()Ljava/lang/Object;

    move-result-object v14

    .line 372
    .local v14, "value1":Ljava/lang/Object;
    instance-of v0, v14, Ljava/lang/Integer;

    move/from16 v16, v0

    if-eqz v16, :cond_5

    .line 374
    check-cast v14, Ljava/lang/Integer;

    .end local v14    # "value1":Ljava/lang/Object;
    invoke-virtual {v14}, Ljava/lang/Integer;->intValue()I

    move-result v13

    .line 375
    .local v13, "val1":I
    if-gez v11, :cond_4

    .line 376
    neg-int v13, v13

    .line 377
    :cond_4
    int-to-short v0, v13

    move/from16 v16, v0

    move/from16 v0, v16

    if-ne v0, v13, :cond_1

    goto :goto_1

    .line 380
    .end local v13    # "val1":I
    .restart local v14    # "value1":Ljava/lang/Object;
    :cond_5
    instance-of v0, v14, Lgnu/math/IntNum;

    move/from16 v16, v0

    if-eqz v16, :cond_1

    move-object v8, v14

    .line 382
    check-cast v8, Lgnu/math/IntNum;

    .line 383
    .local v8, "int1":Lgnu/math/IntNum;
    const/16 v7, 0x7fff

    .line 384
    .local v7, "hi":I
    neg-int v9, v7

    .line 385
    .local v9, "lo":I
    if-lez v11, :cond_6

    .line 386
    add-int/lit8 v9, v9, -0x1

    .line 389
    :goto_2
    int-to-long v0, v9

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-static {v8, v0, v1}, Lgnu/math/IntNum;->compare(Lgnu/math/IntNum;J)I

    move-result v16

    if-ltz v16, :cond_1

    int-to-long v0, v7

    move-wide/from16 v16, v0

    move-wide/from16 v0, v16

    invoke-static {v8, v0, v1}, Lgnu/math/IntNum;->compare(Lgnu/math/IntNum;J)I

    move-result v16

    if-gtz v16, :cond_1

    .line 391
    invoke-virtual {v8}, Lgnu/math/IntNum;->intValue()I

    move-result v16

    mul-int v13, v11, v16

    goto :goto_1

    .line 388
    :cond_6
    add-int/lit8 v7, v7, 0x1

    goto :goto_2
.end method

.method public static makeDefinition(Lgnu/expr/Declaration;Lgnu/expr/Expression;)Lgnu/expr/SetExp;
    .locals 2
    .param p0, "decl"    # Lgnu/expr/Declaration;
    .param p1, "val"    # Lgnu/expr/Expression;

    .prologue
    .line 39
    new-instance v0, Lgnu/expr/SetExp;

    invoke-direct {v0, p0, p1}, Lgnu/expr/SetExp;-><init>(Lgnu/expr/Declaration;Lgnu/expr/Expression;)V

    .line 40
    .local v0, "sexp":Lgnu/expr/SetExp;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lgnu/expr/SetExp;->setDefining(Z)V

    .line 41
    return-object v0
.end method

.method public static makeDefinition(Ljava/lang/Object;Lgnu/expr/Expression;)Lgnu/expr/SetExp;
    .locals 2
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "val"    # Lgnu/expr/Expression;

    .prologue
    .line 32
    new-instance v0, Lgnu/expr/SetExp;

    invoke-direct {v0, p0, p1}, Lgnu/expr/SetExp;-><init>(Ljava/lang/Object;Lgnu/expr/Expression;)V

    .line 33
    .local v0, "sexp":Lgnu/expr/SetExp;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lgnu/expr/SetExp;->setDefining(Z)V

    .line 34
    return-object v0
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 9
    .param p1, "ctx"    # Lgnu/mapping/CallContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 88
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    .line 89
    .local v0, "env":Lgnu/mapping/Environment;
    iget-object v7, p0, Lgnu/expr/SetExp;->symbol:Ljava/lang/Object;

    instance-of v7, v7, Lgnu/mapping/Symbol;

    if-eqz v7, :cond_3

    iget-object v7, p0, Lgnu/expr/SetExp;->symbol:Ljava/lang/Object;

    check-cast v7, Lgnu/mapping/Symbol;

    move-object v6, v7

    .line 91
    .local v6, "sym":Lgnu/mapping/Symbol;
    :goto_0
    const/4 v5, 0x0

    .line 92
    .local v5, "property":Ljava/lang/Object;
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    move-result-object v2

    .line 93
    .local v2, "language":Lgnu/expr/Language;
    invoke-virtual {p0}, Lgnu/expr/SetExp;->isFuncDef()Z

    move-result v7

    if-eqz v7, :cond_0

    invoke-virtual {v2}, Lgnu/expr/Language;->hasSeparateFunctionNamespace()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 94
    sget-object v5, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    .line 95
    .end local v5    # "property":Ljava/lang/Object;
    :cond_0
    invoke-virtual {p0}, Lgnu/expr/SetExp;->isSetIfUnbound()Z

    move-result v7

    if-eqz v7, :cond_4

    .line 97
    invoke-virtual {v0, v6, v5}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v3

    .line 98
    .local v3, "loc":Lgnu/mapping/Location;
    invoke-virtual {v3}, Lgnu/mapping/Location;->isBound()Z

    move-result v7

    if-nez v7, :cond_1

    .line 99
    iget-object v7, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    invoke-virtual {v7, v0}, Lgnu/expr/Expression;->eval(Lgnu/mapping/Environment;)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v3, v7}, Lgnu/mapping/Location;->set(Ljava/lang/Object;)V

    .line 100
    :cond_1
    invoke-virtual {p0}, Lgnu/expr/SetExp;->getHasValue()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 101
    invoke-virtual {p1, v3}, Lgnu/mapping/CallContext;->writeValue(Ljava/lang/Object;)V

    .line 135
    .end local v3    # "loc":Lgnu/mapping/Location;
    :cond_2
    :goto_1
    return-void

    .line 89
    .end local v2    # "language":Lgnu/expr/Language;
    .end local v6    # "sym":Lgnu/mapping/Symbol;
    :cond_3
    iget-object v7, p0, Lgnu/expr/SetExp;->symbol:Ljava/lang/Object;

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v6

    goto :goto_0

    .line 105
    .restart local v2    # "language":Lgnu/expr/Language;
    .restart local v6    # "sym":Lgnu/mapping/Symbol;
    :cond_4
    iget-object v7, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    invoke-virtual {v7, v0}, Lgnu/expr/Expression;->eval(Lgnu/mapping/Environment;)Ljava/lang/Object;

    move-result-object v4

    .line 106
    .local v4, "new_val":Ljava/lang/Object;
    iget-object v7, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    if-eqz v7, :cond_7

    iget-object v7, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    iget-object v7, v7, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    instance-of v7, v7, Lgnu/expr/ModuleExp;

    if-nez v7, :cond_7

    .line 108
    iget-object v7, p1, Lgnu/mapping/CallContext;->evalFrames:[[Ljava/lang/Object;

    iget-object v8, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    iget-object v8, v8, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    invoke-static {v8}, Lgnu/expr/ScopeExp;->nesting(Lgnu/expr/ScopeExp;)I

    move-result v8

    aget-object v1, v7, v8

    .line 109
    .local v1, "evalFrame":[Ljava/lang/Object;
    iget-object v7, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    invoke-virtual {v7}, Lgnu/expr/Declaration;->isIndirectBinding()Z

    move-result v7

    if-eqz v7, :cond_6

    .line 112
    invoke-virtual {p0}, Lgnu/expr/SetExp;->isDefining()Z

    move-result v7

    if-eqz v7, :cond_5

    .line 113
    iget-object v7, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    iget v7, v7, Lgnu/expr/Declaration;->evalIndex:I

    invoke-static {v6}, Lgnu/mapping/Location;->make(Lgnu/mapping/Symbol;)Lgnu/mapping/IndirectableLocation;

    move-result-object v8

    aput-object v8, v1, v7

    .line 114
    :cond_5
    iget-object v7, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    iget v7, v7, Lgnu/expr/Declaration;->evalIndex:I

    aget-object v3, v1, v7

    check-cast v3, Lgnu/mapping/Location;

    .line 115
    .restart local v3    # "loc":Lgnu/mapping/Location;
    iget-object v7, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    invoke-virtual {v3, v7}, Lgnu/mapping/Location;->set(Ljava/lang/Object;)V

    .line 133
    .end local v1    # "evalFrame":[Ljava/lang/Object;
    .end local v3    # "loc":Lgnu/mapping/Location;
    :goto_2
    invoke-virtual {p0}, Lgnu/expr/SetExp;->getHasValue()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 134
    invoke-virtual {p1, v4}, Lgnu/mapping/CallContext;->writeValue(Ljava/lang/Object;)V

    goto :goto_1

    .line 118
    .restart local v1    # "evalFrame":[Ljava/lang/Object;
    :cond_6
    iget-object v7, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    iget v7, v7, Lgnu/expr/Declaration;->evalIndex:I

    aput-object v4, v1, v7

    goto :goto_2

    .line 120
    .end local v1    # "evalFrame":[Ljava/lang/Object;
    :cond_7
    invoke-virtual {p0}, Lgnu/expr/SetExp;->isDefining()Z

    move-result v7

    if-eqz v7, :cond_8

    .line 127
    invoke-virtual {v0, v6, v5, v4}, Lgnu/mapping/Environment;->define(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_2

    .line 131
    :cond_8
    invoke-virtual {v0, v6, v5, v4}, Lgnu/mapping/Environment;->put(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_2
.end method

.method public compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 27
    .param p1, "comp"    # Lgnu/expr/Compilation;
    .param p2, "target"    # Lgnu/expr/Target;

    .prologue
    .line 139
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    instance-of v0, v0, Lgnu/expr/LambdaExp;

    move/from16 v24, v0

    if-eqz v24, :cond_0

    move-object/from16 v0, p2

    instance-of v0, v0, Lgnu/expr/IgnoreTarget;

    move/from16 v24, v0

    if-eqz v24, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    check-cast v24, Lgnu/expr/LambdaExp;

    invoke-virtual/range {v24 .. v24}, Lgnu/expr/LambdaExp;->getInlineOnly()Z

    move-result v24

    if-eqz v24, :cond_0

    .line 330
    :goto_0
    return-void

    .line 144
    :cond_0
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v6

    .line 146
    .local v6, "code":Lgnu/bytecode/CodeAttr;
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/SetExp;->getHasValue()Z

    move-result v24

    if-eqz v24, :cond_2

    move-object/from16 v0, p2

    instance-of v0, v0, Lgnu/expr/IgnoreTarget;

    move/from16 v24, v0

    if-nez v24, :cond_2

    const/4 v13, 0x1

    .line 151
    .local v13, "needValue":Z
    :goto_1
    const/16 v22, 0x0

    .line 159
    .local v22, "valuePushed":Z
    move-object/from16 v0, p0

    iget-object v7, v0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    .line 160
    .local v7, "decl":Lgnu/expr/Declaration;
    invoke-virtual {v7}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v8

    .line 161
    .local v8, "declValue":Lgnu/expr/Expression;
    instance-of v0, v8, Lgnu/expr/LambdaExp;

    move/from16 v24, v0

    if-eqz v24, :cond_3

    iget-object v0, v7, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    instance-of v0, v0, Lgnu/expr/ModuleExp;

    move/from16 v24, v0

    if-eqz v24, :cond_3

    invoke-virtual {v7}, Lgnu/expr/Declaration;->ignorable()Z

    move-result v24

    if-nez v24, :cond_3

    move-object/from16 v24, v8

    check-cast v24, Lgnu/expr/LambdaExp;

    invoke-virtual/range {v24 .. v24}, Lgnu/expr/LambdaExp;->getName()Ljava/lang/String;

    move-result-object v24

    if-eqz v24, :cond_3

    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    if-ne v8, v0, :cond_3

    .line 167
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    check-cast v24, Lgnu/expr/LambdaExp;

    move-object/from16 v0, v24

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Lgnu/expr/LambdaExp;->compileSetField(Lgnu/expr/Compilation;)Lgnu/bytecode/Field;

    .line 323
    :cond_1
    :goto_2
    if-eqz v13, :cond_1a

    if-nez v22, :cond_1a

    .line 324
    new-instance v24, Ljava/lang/Error;

    const-string v25, "SetExp.compile: not implemented - return value"

    invoke-direct/range {v24 .. v25}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v24

    .line 146
    .end local v7    # "decl":Lgnu/expr/Declaration;
    .end local v8    # "declValue":Lgnu/expr/Expression;
    .end local v13    # "needValue":Z
    .end local v22    # "valuePushed":Z
    :cond_2
    const/4 v13, 0x0

    goto :goto_1

    .line 169
    .restart local v7    # "decl":Lgnu/expr/Declaration;
    .restart local v8    # "declValue":Lgnu/expr/Expression;
    .restart local v13    # "needValue":Z
    .restart local v22    # "valuePushed":Z
    :cond_3
    invoke-virtual {v7}, Lgnu/expr/Declaration;->shouldEarlyInit()Z

    move-result v24

    if-nez v24, :cond_4

    invoke-virtual {v7}, Lgnu/expr/Declaration;->isAlias()Z

    move-result v24

    if-eqz v24, :cond_6

    :cond_4
    iget-object v0, v7, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    instance-of v0, v0, Lgnu/expr/ModuleExp;

    move/from16 v24, v0

    if-eqz v24, :cond_6

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/SetExp;->isDefining()Z

    move-result v24

    if-eqz v24, :cond_6

    invoke-virtual {v7}, Lgnu/expr/Declaration;->ignorable()Z

    move-result v24

    if-nez v24, :cond_6

    .line 173
    invoke-virtual {v7}, Lgnu/expr/Declaration;->shouldEarlyInit()Z

    move-result v24

    if-eqz v24, :cond_5

    .line 174
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    move-object/from16 v1, p1

    invoke-static {v7, v0, v1}, Lgnu/expr/BindingInitializer;->create(Lgnu/expr/Declaration;Lgnu/expr/Expression;Lgnu/expr/Compilation;)V

    .line 175
    :cond_5
    if-eqz v13, :cond_1

    .line 177
    const/16 v24, 0x0

    sget-object v25, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, p0

    move/from16 v1, v24

    move-object/from16 v2, p1

    move-object/from16 v3, v25

    invoke-virtual {v7, v0, v1, v2, v3}, Lgnu/expr/Declaration;->load(Lgnu/expr/AccessExp;ILgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 178
    const/16 v22, 0x1

    goto :goto_2

    .line 183
    :cond_6
    move-object/from16 v4, p0

    .line 184
    .local v4, "access":Lgnu/expr/AccessExp;
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/SetExp;->contextDecl()Lgnu/expr/Declaration;

    move-result-object v15

    .line 185
    .local v15, "owner":Lgnu/expr/Declaration;
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/SetExp;->isDefining()Z

    move-result v24

    if-nez v24, :cond_7

    .line 187
    :goto_3
    if-eqz v7, :cond_7

    invoke-virtual {v7}, Lgnu/expr/Declaration;->isAlias()Z

    move-result v24

    if-eqz v24, :cond_7

    .line 189
    invoke-virtual {v7}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v8

    .line 190
    instance-of v0, v8, Lgnu/expr/ReferenceExp;

    move/from16 v24, v0

    if-nez v24, :cond_8

    .line 203
    :cond_7
    invoke-virtual {v7}, Lgnu/expr/Declaration;->ignorable()Z

    move-result v24

    if-eqz v24, :cond_a

    .line 204
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    sget-object v25, Lgnu/expr/Target;->Ignore:Lgnu/expr/Target;

    move-object/from16 v0, v24

    move-object/from16 v1, p1

    move-object/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto/16 :goto_2

    :cond_8
    move-object/from16 v16, v8

    .line 192
    check-cast v16, Lgnu/expr/ReferenceExp;

    .line 193
    .local v16, "rexp":Lgnu/expr/ReferenceExp;
    move-object/from16 v0, v16

    iget-object v14, v0, Lgnu/expr/ReferenceExp;->binding:Lgnu/expr/Declaration;

    .line 194
    .local v14, "orig":Lgnu/expr/Declaration;
    if-eqz v14, :cond_7

    .line 196
    if-eqz v15, :cond_9

    invoke-virtual {v14}, Lgnu/expr/Declaration;->needsContext()Z

    move-result v24

    if-nez v24, :cond_7

    .line 198
    :cond_9
    invoke-virtual/range {v16 .. v16}, Lgnu/expr/ReferenceExp;->contextDecl()Lgnu/expr/Declaration;

    move-result-object v15

    .line 199
    move-object/from16 v4, v16

    .line 200
    move-object v7, v14

    .line 201
    goto :goto_3

    .line 205
    .end local v14    # "orig":Lgnu/expr/Declaration;
    .end local v16    # "rexp":Lgnu/expr/ReferenceExp;
    :cond_a
    invoke-virtual {v7}, Lgnu/expr/Declaration;->isAlias()Z

    move-result v24

    if-eqz v24, :cond_b

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/SetExp;->isDefining()Z

    move-result v24

    if-eqz v24, :cond_b

    .line 207
    const/16 v24, 0x2

    sget-object v25, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, p0

    move/from16 v1, v24

    move-object/from16 v2, p1

    move-object/from16 v3, v25

    invoke-virtual {v7, v0, v1, v2, v3}, Lgnu/expr/Declaration;->load(Lgnu/expr/AccessExp;ILgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 209
    const-string v24, "gnu.mapping.IndirectableLocation"

    invoke-static/range {v24 .. v24}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v11

    .line 211
    .local v11, "locType":Lgnu/bytecode/ClassType;
    invoke-virtual {v6, v11}, Lgnu/bytecode/CodeAttr;->emitCheckcast(Lgnu/bytecode/Type;)V

    .line 212
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    sget-object v25, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, v24

    move-object/from16 v1, p1

    move-object/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 213
    const-string v24, "setAlias"

    const/16 v25, 0x1

    move-object/from16 v0, v24

    move/from16 v1, v25

    invoke-virtual {v11, v0, v1}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v12

    .line 214
    .local v12, "meth":Lgnu/bytecode/Method;
    invoke-virtual {v6, v12}, Lgnu/bytecode/CodeAttr;->emitInvokeVirtual(Lgnu/bytecode/Method;)V

    goto/16 :goto_2

    .line 216
    .end local v11    # "locType":Lgnu/bytecode/ClassType;
    .end local v12    # "meth":Lgnu/bytecode/Method;
    :cond_b
    invoke-virtual {v7}, Lgnu/expr/Declaration;->isIndirectBinding()Z

    move-result v24

    if-eqz v24, :cond_f

    .line 218
    const/16 v24, 0x2

    sget-object v25, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move/from16 v0, v24

    move-object/from16 v1, p1

    move-object/from16 v2, v25

    invoke-virtual {v7, v4, v0, v1, v2}, Lgnu/expr/Declaration;->load(Lgnu/expr/AccessExp;ILgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 220
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/SetExp;->isSetIfUnbound()Z

    move-result v24

    if-eqz v24, :cond_d

    .line 222
    if-eqz v13, :cond_c

    .line 224
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->emitDup()V

    .line 225
    const/16 v22, 0x1

    .line 227
    :cond_c
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->pushScope()Lgnu/bytecode/Scope;

    .line 228
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->emitDup()V

    .line 229
    sget-object v24, Lgnu/expr/Compilation;->typeLocation:Lgnu/bytecode/ClassType;

    move-object/from16 v0, v24

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->addLocal(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;

    move-result-object v20

    .line 230
    .local v20, "symLoc":Lgnu/bytecode/Variable;
    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 231
    sget-object v24, Lgnu/expr/Compilation;->typeLocation:Lgnu/bytecode/ClassType;

    const-string v25, "isBound"

    const/16 v26, 0x0

    invoke-virtual/range {v24 .. v26}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v24

    move-object/from16 v0, v24

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvokeVirtual(Lgnu/bytecode/Method;)V

    .line 233
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->emitIfIntEqZero()V

    .line 234
    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 236
    .end local v20    # "symLoc":Lgnu/bytecode/Variable;
    :cond_d
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    sget-object v25, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, v24

    move-object/from16 v1, p1

    move-object/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 237
    if-eqz v13, :cond_e

    invoke-virtual/range {p0 .. p0}, Lgnu/expr/SetExp;->isSetIfUnbound()Z

    move-result v24

    if-nez v24, :cond_e

    .line 239
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->emitDupX()V

    .line 240
    const/16 v22, 0x1

    .line 242
    :cond_e
    const-string v19, "set"

    .line 243
    .local v19, "setterName":Ljava/lang/String;
    sget-object v24, Lgnu/expr/Compilation;->typeLocation:Lgnu/bytecode/ClassType;

    const/16 v25, 0x1

    move-object/from16 v0, v24

    move-object/from16 v1, v19

    move/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v24

    move-object/from16 v0, v24

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvokeVirtual(Lgnu/bytecode/Method;)V

    .line 245
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/SetExp;->isSetIfUnbound()Z

    move-result v24

    if-eqz v24, :cond_1

    .line 247
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->emitFi()V

    .line 248
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->popScope()Lgnu/bytecode/Scope;

    goto/16 :goto_2

    .line 251
    .end local v19    # "setterName":Ljava/lang/String;
    :cond_f
    invoke-virtual {v7}, Lgnu/expr/Declaration;->isSimple()Z

    move-result v24

    if-eqz v24, :cond_13

    .line 253
    invoke-virtual {v7}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v21

    .line 254
    .local v21, "type":Lgnu/bytecode/Type;
    invoke-virtual {v7}, Lgnu/expr/Declaration;->getVariable()Lgnu/bytecode/Variable;

    move-result-object v23

    .line 255
    .local v23, "var":Lgnu/bytecode/Variable;
    if-nez v23, :cond_10

    .line 256
    invoke-virtual {v7, v6}, Lgnu/expr/Declaration;->allocateVariable(Lgnu/bytecode/CodeAttr;)Lgnu/bytecode/Variable;

    move-result-object v23

    .line 257
    :cond_10
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    invoke-static {v0, v7}, Lgnu/expr/SetExp;->canUseInc(Lgnu/expr/Expression;Lgnu/expr/Declaration;)I

    move-result v9

    .line 258
    .local v9, "delta":I
    const/high16 v24, 0x10000

    move/from16 v0, v24

    if-eq v9, v0, :cond_11

    .line 260
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v24

    int-to-short v0, v9

    move/from16 v25, v0

    move-object/from16 v0, v24

    move-object/from16 v1, v23

    move/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Lgnu/bytecode/CodeAttr;->emitInc(Lgnu/bytecode/Variable;S)V

    .line 261
    if-eqz v13, :cond_1

    .line 263
    move-object/from16 v0, v23

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 264
    const/16 v22, 0x1

    goto/16 :goto_2

    .line 269
    :cond_11
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v7}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Declaration;)V

    .line 270
    if-eqz v13, :cond_12

    .line 272
    move-object/from16 v0, v21

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitDup(Lgnu/bytecode/Type;)V

    .line 273
    const/16 v22, 0x1

    .line 275
    :cond_12
    move-object/from16 v0, v23

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    goto/16 :goto_2

    .line 278
    .end local v9    # "delta":I
    .end local v21    # "type":Lgnu/bytecode/Type;
    .end local v23    # "var":Lgnu/bytecode/Variable;
    :cond_13
    iget-object v0, v7, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    instance-of v0, v0, Lgnu/expr/ClassExp;

    move/from16 v24, v0

    if-eqz v24, :cond_15

    iget-object v0, v7, Lgnu/expr/Declaration;->field:Lgnu/bytecode/Field;

    move-object/from16 v24, v0

    if-nez v24, :cond_15

    const/16 v24, 0x10

    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Lgnu/expr/SetExp;->getFlag(I)Z

    move-result v24

    if-nez v24, :cond_15

    iget-object v0, v7, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    move-object/from16 v24, v0

    check-cast v24, Lgnu/expr/ClassExp;

    invoke-virtual/range {v24 .. v24}, Lgnu/expr/ClassExp;->isMakingClassPair()Z

    move-result v24

    if-eqz v24, :cond_15

    .line 282
    const-string v24, "set"

    invoke-virtual {v7}, Lgnu/expr/Declaration;->getName()Ljava/lang/String;

    move-result-object v25

    invoke-static/range {v24 .. v25}, Lgnu/expr/ClassExp;->slotToMethodName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v17

    .line 283
    .local v17, "setName":Ljava/lang/String;
    iget-object v5, v7, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    check-cast v5, Lgnu/expr/ClassExp;

    .line 284
    .local v5, "cl":Lgnu/expr/ClassExp;
    iget-object v0, v5, Lgnu/expr/ClassExp;->type:Lgnu/bytecode/ClassType;

    move-object/from16 v24, v0

    const/16 v25, 0x1

    move-object/from16 v0, v24

    move-object/from16 v1, v17

    move/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v18

    .line 285
    .local v18, "setter":Lgnu/bytecode/Method;
    move-object/from16 v0, p1

    invoke-virtual {v5, v0}, Lgnu/expr/ClassExp;->loadHeapFrame(Lgnu/expr/Compilation;)V

    .line 286
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v7}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Declaration;)V

    .line 287
    if-eqz v13, :cond_14

    .line 289
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->emitDupX()V

    .line 290
    const/16 v22, 0x1

    .line 292
    :cond_14
    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvoke(Lgnu/bytecode/Method;)V

    goto/16 :goto_2

    .line 296
    .end local v5    # "cl":Lgnu/expr/ClassExp;
    .end local v17    # "setName":Ljava/lang/String;
    .end local v18    # "setter":Lgnu/bytecode/Method;
    :cond_15
    iget-object v10, v7, Lgnu/expr/Declaration;->field:Lgnu/bytecode/Field;

    .line 297
    .local v10, "field":Lgnu/bytecode/Field;
    invoke-virtual {v10}, Lgnu/bytecode/Field;->getStaticFlag()Z

    move-result v24

    if-nez v24, :cond_16

    .line 298
    move-object/from16 v0, p1

    invoke-virtual {v7, v15, v0}, Lgnu/expr/Declaration;->loadOwningObject(Lgnu/expr/Declaration;Lgnu/expr/Compilation;)V

    .line 299
    :cond_16
    invoke-virtual {v10}, Lgnu/bytecode/Field;->getType()Lgnu/bytecode/Type;

    move-result-object v21

    .line 300
    .restart local v21    # "type":Lgnu/bytecode/Type;
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v7}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Declaration;)V

    .line 301
    invoke-virtual {v10}, Lgnu/bytecode/Field;->getDeclaringClass()Lgnu/bytecode/ClassType;

    move-result-object v24

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Lgnu/expr/Compilation;->usedClass(Lgnu/bytecode/Type;)V

    .line 302
    invoke-virtual {v10}, Lgnu/bytecode/Field;->getStaticFlag()Z

    move-result v24

    if-eqz v24, :cond_18

    .line 304
    if-eqz v13, :cond_17

    .line 306
    move-object/from16 v0, v21

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitDup(Lgnu/bytecode/Type;)V

    .line 307
    const/16 v22, 0x1

    .line 309
    :cond_17
    invoke-virtual {v6, v10}, Lgnu/bytecode/CodeAttr;->emitPutStatic(Lgnu/bytecode/Field;)V

    goto/16 :goto_2

    .line 313
    :cond_18
    if-eqz v13, :cond_19

    .line 315
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->emitDupX()V

    .line 316
    const/16 v22, 0x1

    .line 318
    :cond_19
    invoke-virtual {v6, v10}, Lgnu/bytecode/CodeAttr;->emitPutField(Lgnu/bytecode/Field;)V

    goto/16 :goto_2

    .line 326
    .end local v4    # "access":Lgnu/expr/AccessExp;
    .end local v10    # "field":Lgnu/bytecode/Field;
    .end local v15    # "owner":Lgnu/expr/Declaration;
    .end local v21    # "type":Lgnu/bytecode/Type;
    :cond_1a
    if-eqz v13, :cond_1b

    .line 327
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/SetExp;->getType()Lgnu/bytecode/Type;

    move-result-object v24

    move-object/from16 v0, p2

    move-object/from16 v1, p1

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Target;->compileFromStack(Lgnu/expr/Compilation;Lgnu/bytecode/Type;)V

    goto/16 :goto_0

    .line 329
    :cond_1b
    sget-object v24, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    move-object/from16 v2, p2

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Compilation;->compileConstant(Ljava/lang/Object;Lgnu/expr/Target;)V

    goto/16 :goto_0
.end method

.method public final getHasValue()Z
    .locals 1

    .prologue
    .line 66
    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    and-int/lit8 v0, v0, 0x40

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getNewValue()Lgnu/expr/Expression;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    return-object v0
.end method

.method public final getType()Lgnu/bytecode/Type;
    .locals 1

    .prologue
    .line 400
    invoke-virtual {p0}, Lgnu/expr/SetExp;->getHasValue()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lgnu/bytecode/Type;->voidType:Lgnu/bytecode/PrimType;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    if-nez v0, :cond_1

    sget-object v0, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    invoke-virtual {v0}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v0

    goto :goto_0
.end method

.method public final isDefining()Z
    .locals 1

    .prologue
    .line 56
    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final isFuncDef()Z
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final isSetIfUnbound()Z
    .locals 1

    .prologue
    .line 79
    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    and-int/lit8 v0, v0, 0x20

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected mustCompile()Z
    .locals 1

    .prologue
    .line 84
    const/4 v0, 0x0

    return v0
.end method

.method public print(Lgnu/mapping/OutPort;)V
    .locals 4
    .param p1, "out"    # Lgnu/mapping/OutPort;

    .prologue
    const/16 v3, 0x2f

    .line 415
    invoke-virtual {p0}, Lgnu/expr/SetExp;->isDefining()Z

    move-result v0

    if-eqz v0, :cond_3

    const-string v0, "(Define"

    :goto_0
    const-string v1, ")"

    const/4 v2, 0x2

    invoke-virtual {p1, v0, v1, v2}, Lgnu/mapping/OutPort;->startLogicalBlock(Ljava/lang/String;Ljava/lang/String;I)V

    .line 416
    invoke-virtual {p1}, Lgnu/mapping/OutPort;->writeSpaceFill()V

    .line 417
    invoke-virtual {p0, p1}, Lgnu/expr/SetExp;->printLineColumn(Lgnu/mapping/OutPort;)V

    .line 418
    iget-object v0, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lgnu/expr/SetExp;->symbol:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    invoke-virtual {v1}, Lgnu/expr/Declaration;->getName()Ljava/lang/String;

    move-result-object v1

    if-eq v0, v1, :cond_1

    .line 420
    :cond_0
    invoke-virtual {p1, v3}, Lgnu/mapping/OutPort;->print(C)V

    .line 421
    iget-object v0, p0, Lgnu/expr/SetExp;->symbol:Ljava/lang/Object;

    invoke-virtual {p1, v0}, Lgnu/mapping/OutPort;->print(Ljava/lang/Object;)V

    .line 423
    :cond_1
    iget-object v0, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    if-eqz v0, :cond_2

    .line 425
    invoke-virtual {p1, v3}, Lgnu/mapping/OutPort;->print(C)V

    .line 426
    iget-object v0, p0, Lgnu/expr/SetExp;->binding:Lgnu/expr/Declaration;

    invoke-virtual {p1, v0}, Lgnu/mapping/OutPort;->print(Ljava/lang/Object;)V

    .line 428
    :cond_2
    invoke-virtual {p1}, Lgnu/mapping/OutPort;->writeSpaceLinear()V

    .line 429
    iget-object v0, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    invoke-virtual {v0, p1}, Lgnu/expr/Expression;->print(Lgnu/mapping/OutPort;)V

    .line 430
    const-string v0, ")"

    invoke-virtual {p1, v0}, Lgnu/mapping/OutPort;->endLogicalBlock(Ljava/lang/String;)V

    .line 431
    return-void

    .line 415
    :cond_3
    const-string v0, "(Set"

    goto :goto_0
.end method

.method public final setDefining(Z)V
    .locals 1
    .param p1, "value"    # Z

    .prologue
    .line 61
    if-eqz p1, :cond_0

    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lgnu/expr/SetExp;->flags:I

    .line 62
    :goto_0
    return-void

    .line 61
    :cond_0
    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lgnu/expr/SetExp;->flags:I

    goto :goto_0
.end method

.method public final setFuncDef(Z)V
    .locals 1
    .param p1, "value"    # Z

    .prologue
    .line 76
    if-eqz p1, :cond_0

    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    or-int/lit8 v0, v0, 0x10

    iput v0, p0, Lgnu/expr/SetExp;->flags:I

    :goto_0
    return-void

    :cond_0
    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    and-int/lit8 v0, v0, -0x11

    iput v0, p0, Lgnu/expr/SetExp;->flags:I

    goto :goto_0
.end method

.method public final setHasValue(Z)V
    .locals 1
    .param p1, "value"    # Z

    .prologue
    .line 69
    if-eqz p1, :cond_0

    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    or-int/lit8 v0, v0, 0x40

    iput v0, p0, Lgnu/expr/SetExp;->flags:I

    :goto_0
    return-void

    :cond_0
    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    and-int/lit8 v0, v0, -0x41

    iput v0, p0, Lgnu/expr/SetExp;->flags:I

    goto :goto_0
.end method

.method public final setSetIfUnbound(Z)V
    .locals 1
    .param p1, "value"    # Z

    .prologue
    .line 82
    if-eqz p1, :cond_0

    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    or-int/lit8 v0, v0, 0x20

    iput v0, p0, Lgnu/expr/SetExp;->flags:I

    :goto_0
    return-void

    :cond_0
    iget v0, p0, Lgnu/expr/SetExp;->flags:I

    and-int/lit8 v0, v0, -0x21

    iput v0, p0, Lgnu/expr/SetExp;->flags:I

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 435
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "SetExp["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lgnu/expr/SetExp;->symbol:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
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
    .line 406
    .local p1, "visitor":Lgnu/expr/ExpVisitor;, "Lgnu/expr/ExpVisitor<TR;TD;>;"
    .local p2, "d":Ljava/lang/Object;, "TD;"
    invoke-virtual {p1, p0, p2}, Lgnu/expr/ExpVisitor;->visitSetExp(Lgnu/expr/SetExp;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected visitChildren(Lgnu/expr/ExpVisitor;Ljava/lang/Object;)V
    .locals 1
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
    .line 411
    .local p1, "visitor":Lgnu/expr/ExpVisitor;, "Lgnu/expr/ExpVisitor<TR;TD;>;"
    .local p2, "d":Ljava/lang/Object;, "TD;"
    iget-object v0, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    invoke-virtual {p1, v0, p2}, Lgnu/expr/ExpVisitor;->visitAndUpdate(Lgnu/expr/Expression;Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v0

    iput-object v0, p0, Lgnu/expr/SetExp;->new_value:Lgnu/expr/Expression;

    .line 412
    return-void
.end method
