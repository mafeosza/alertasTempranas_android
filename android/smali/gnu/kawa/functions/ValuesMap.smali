.class public Lgnu/kawa/functions/ValuesMap;
.super Lgnu/mapping/MethodProc;
.source "ValuesMap.java"

# interfaces
.implements Lgnu/expr/Inlineable;


# static fields
.field public static final valuesMap:Lgnu/kawa/functions/ValuesMap;

.field public static final valuesMapWithPos:Lgnu/kawa/functions/ValuesMap;


# instance fields
.field private final startCounter:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 19
    new-instance v0, Lgnu/kawa/functions/ValuesMap;

    const/4 v1, -0x1

    invoke-direct {v0, v1}, Lgnu/kawa/functions/ValuesMap;-><init>(I)V

    sput-object v0, Lgnu/kawa/functions/ValuesMap;->valuesMap:Lgnu/kawa/functions/ValuesMap;

    .line 20
    new-instance v0, Lgnu/kawa/functions/ValuesMap;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lgnu/kawa/functions/ValuesMap;-><init>(I)V

    sput-object v0, Lgnu/kawa/functions/ValuesMap;->valuesMapWithPos:Lgnu/kawa/functions/ValuesMap;

    return-void
.end method

.method private constructor <init>(I)V
    .locals 2
    .param p1, "startCounter"    # I

    .prologue
    .line 23
    invoke-direct {p0}, Lgnu/mapping/MethodProc;-><init>()V

    .line 24
    iput p1, p0, Lgnu/kawa/functions/ValuesMap;->startCounter:I

    .line 25
    sget-object v0, Lgnu/mapping/Procedure;->validateApplyKey:Lgnu/mapping/Symbol;

    const-string v1, "gnu.kawa.functions.CompileMisc:validateApplyValuesMap"

    invoke-virtual {p0, v0, v1}, Lgnu/kawa/functions/ValuesMap;->setProperty(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 27
    return-void
.end method

.method static canInline(Lgnu/expr/ApplyExp;Lgnu/kawa/functions/ValuesMap;)Lgnu/expr/LambdaExp;
    .locals 6
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "proc"    # Lgnu/kawa/functions/ValuesMap;

    .prologue
    const/4 v3, 0x2

    .line 69
    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v1

    .line 72
    .local v1, "args":[Lgnu/expr/Expression;
    array-length v4, v1

    if-ne v4, v3, :cond_1

    const/4 v4, 0x0

    aget-object v0, v1, v4

    .local v0, "arg0":Lgnu/expr/Expression;
    instance-of v4, v0, Lgnu/expr/LambdaExp;

    if-eqz v4, :cond_1

    move-object v2, v0

    .line 74
    check-cast v2, Lgnu/expr/LambdaExp;

    .line 75
    .local v2, "lexp":Lgnu/expr/LambdaExp;
    iget v4, v2, Lgnu/expr/LambdaExp;->min_args:I

    iget v5, v2, Lgnu/expr/LambdaExp;->max_args:I

    if-ne v4, v5, :cond_1

    iget v4, v2, Lgnu/expr/LambdaExp;->min_args:I

    iget v5, p1, Lgnu/kawa/functions/ValuesMap;->startCounter:I

    if-ltz v5, :cond_0

    :goto_0
    if-ne v4, v3, :cond_1

    .line 79
    .end local v0    # "arg0":Lgnu/expr/Expression;
    .end local v2    # "lexp":Lgnu/expr/LambdaExp;
    :goto_1
    return-object v2

    .line 75
    .restart local v0    # "arg0":Lgnu/expr/Expression;
    .restart local v2    # "lexp":Lgnu/expr/LambdaExp;
    :cond_0
    const/4 v3, 0x1

    goto :goto_0

    .line 79
    .end local v0    # "arg0":Lgnu/expr/Expression;
    .end local v2    # "lexp":Lgnu/expr/LambdaExp;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public static compileInlined(Lgnu/expr/LambdaExp;Lgnu/expr/Expression;ILgnu/bytecode/Method;Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 21
    .param p0, "lambda"    # Lgnu/expr/LambdaExp;
    .param p1, "vals"    # Lgnu/expr/Expression;
    .param p2, "startCounter"    # I
    .param p3, "matchesMethod"    # Lgnu/bytecode/Method;
    .param p4, "comp"    # Lgnu/expr/Compilation;
    .param p5, "target"    # Lgnu/expr/Target;

    .prologue
    .line 105
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/LambdaExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v12

    .line 106
    .local v12, "param":Lgnu/expr/Declaration;
    invoke-virtual/range {p4 .. p4}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v6

    .line 107
    .local v6, "code":Lgnu/bytecode/CodeAttr;
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->pushScope()Lgnu/bytecode/Scope;

    move-result-object v15

    .line 110
    .local v15, "scope":Lgnu/bytecode/Scope;
    invoke-virtual {v12}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v13

    .line 111
    .local v13, "paramType":Lgnu/bytecode/Type;
    if-ltz p2, :cond_3

    .line 113
    sget-object v18, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    const-string v19, "position"

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-virtual {v15, v6, v0, v1}, Lgnu/bytecode/Scope;->addVariable(Lgnu/bytecode/CodeAttr;Lgnu/bytecode/Type;Ljava/lang/String;)Lgnu/bytecode/Variable;

    move-result-object v7

    .line 114
    .local v7, "counter":Lgnu/bytecode/Variable;
    move/from16 v0, p2

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 115
    invoke-virtual {v6, v7}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 116
    new-instance v8, Lgnu/expr/Declaration;

    invoke-direct {v8, v7}, Lgnu/expr/Declaration;-><init>(Lgnu/bytecode/Variable;)V

    .line 125
    .local v8, "counterDecl":Lgnu/expr/Declaration;
    :goto_0
    invoke-virtual {v12}, Lgnu/expr/Declaration;->isSimple()Z

    move-result v18

    if-eqz v18, :cond_4

    if-nez p3, :cond_4

    .line 126
    invoke-virtual {v12, v6}, Lgnu/expr/Declaration;->allocateVariable(Lgnu/bytecode/CodeAttr;)Lgnu/bytecode/Variable;

    .line 133
    :goto_1
    if-ltz p2, :cond_5

    .line 135
    const/16 v18, 0x2

    move/from16 v0, v18

    new-array v5, v0, [Lgnu/expr/Expression;

    const/16 v18, 0x0

    new-instance v19, Lgnu/expr/ReferenceExp;

    move-object/from16 v0, v19

    invoke-direct {v0, v12}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v19, v5, v18

    const/16 v18, 0x1

    new-instance v19, Lgnu/expr/ReferenceExp;

    move-object/from16 v0, v19

    invoke-direct {v0, v8}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v19, v5, v18

    .line 140
    .local v5, "args":[Lgnu/expr/Expression;
    :goto_2
    new-instance v3, Lgnu/expr/ApplyExp;

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v5}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    .line 141
    .local v3, "app":Lgnu/expr/Expression;
    if-eqz p3, :cond_1

    .line 144
    invoke-virtual {v3}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lgnu/bytecode/Type;->getImplementationType()Lgnu/bytecode/Type;

    move-result-object v18

    sget-object v19, Lgnu/bytecode/Type;->booleanType:Lgnu/bytecode/PrimType;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    if-eq v0, v1, :cond_0

    .line 145
    new-instance v4, Lgnu/expr/ApplyExp;

    const/16 v18, 0x2

    move/from16 v0, v18

    new-array v0, v0, [Lgnu/expr/Expression;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aput-object v3, v18, v19

    const/16 v19, 0x1

    new-instance v20, Lgnu/expr/ReferenceExp;

    move-object/from16 v0, v20

    invoke-direct {v0, v8}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v20, v18, v19

    move-object/from16 v0, p3

    move-object/from16 v1, v18

    invoke-direct {v4, v0, v1}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    .end local v3    # "app":Lgnu/expr/Expression;
    .local v4, "app":Lgnu/expr/Expression;
    move-object v3, v4

    .line 149
    .end local v4    # "app":Lgnu/expr/Expression;
    .restart local v3    # "app":Lgnu/expr/Expression;
    :cond_0
    new-instance v4, Lgnu/expr/IfExp;

    new-instance v18, Lgnu/expr/ReferenceExp;

    move-object/from16 v0, v18

    invoke-direct {v0, v12}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    sget-object v19, Lgnu/expr/QuoteExp;->voidExp:Lgnu/expr/QuoteExp;

    move-object/from16 v0, v18

    move-object/from16 v1, v19

    invoke-direct {v4, v3, v0, v1}, Lgnu/expr/IfExp;-><init>(Lgnu/expr/Expression;Lgnu/expr/Expression;Lgnu/expr/Expression;)V

    .end local v3    # "app":Lgnu/expr/Expression;
    .restart local v4    # "app":Lgnu/expr/Expression;
    move-object v3, v4

    .line 164
    .end local v4    # "app":Lgnu/expr/Expression;
    .restart local v3    # "app":Lgnu/expr/Expression;
    :cond_1
    sget-object v18, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->addLocal(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;

    move-result-object v10

    .line 165
    .local v10, "indexVar":Lgnu/bytecode/Variable;
    sget-object v18, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->addLocal(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;

    move-result-object v17

    .line 166
    .local v17, "valuesVar":Lgnu/bytecode/Variable;
    sget-object v18, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->addLocal(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;

    move-result-object v11

    .line 168
    .local v11, "nextVar":Lgnu/bytecode/Variable;
    sget-object v18, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, p1

    move-object/from16 v1, p4

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compileWithPosition(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 169
    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 170
    const/16 v18, 0x0

    move/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 171
    invoke-virtual {v6, v10}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 173
    new-instance v16, Lgnu/bytecode/Label;

    move-object/from16 v0, v16

    invoke-direct {v0, v6}, Lgnu/bytecode/Label;-><init>(Lgnu/bytecode/CodeAttr;)V

    .line 174
    .local v16, "top":Lgnu/bytecode/Label;
    new-instance v9, Lgnu/bytecode/Label;

    invoke-direct {v9, v6}, Lgnu/bytecode/Label;-><init>(Lgnu/bytecode/CodeAttr;)V

    .line 175
    .local v9, "doneLabel":Lgnu/bytecode/Label;
    move-object/from16 v0, v16

    invoke-virtual {v0, v6}, Lgnu/bytecode/Label;->define(Lgnu/bytecode/CodeAttr;)V

    .line 176
    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 177
    invoke-virtual {v6, v10}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 178
    sget-object v18, Lgnu/expr/Compilation;->typeValues:Lgnu/bytecode/ClassType;

    const-string v19, "nextIndex"

    const/16 v20, 0x2

    invoke-virtual/range {v18 .. v20}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvokeStatic(Lgnu/bytecode/Method;)V

    .line 179
    sget-object v18, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitDup(Lgnu/bytecode/Type;)V

    .line 180
    invoke-virtual {v6, v11}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 182
    invoke-virtual {v6, v9}, Lgnu/bytecode/CodeAttr;->emitGotoIfIntLtZero(Lgnu/bytecode/Label;)V

    .line 184
    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 185
    invoke-virtual {v6, v10}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 186
    sget-object v18, Lgnu/expr/Compilation;->typeValues:Lgnu/bytecode/ClassType;

    const-string v19, "nextValue"

    const/16 v20, 0x2

    invoke-virtual/range {v18 .. v20}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitInvokeStatic(Lgnu/bytecode/Method;)V

    .line 188
    sget-object v18, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    move-object/from16 v0, p4

    move-object/from16 v1, v18

    invoke-static {v0, v1, v13}, Lgnu/expr/StackTarget;->convert(Lgnu/expr/Compilation;Lgnu/bytecode/Type;Lgnu/bytecode/Type;)V

    .line 189
    move-object/from16 v0, p4

    invoke-virtual {v12, v0}, Lgnu/expr/Declaration;->compileStore(Lgnu/expr/Compilation;)V

    .line 191
    move-object/from16 v0, p4

    move-object/from16 v1, p5

    invoke-virtual {v3, v0, v1}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 193
    if-ltz p2, :cond_2

    .line 195
    const/16 v18, 0x1

    move/from16 v0, v18

    invoke-virtual {v6, v7, v0}, Lgnu/bytecode/CodeAttr;->emitInc(Lgnu/bytecode/Variable;S)V

    .line 198
    :cond_2
    invoke-virtual {v6, v11}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 199
    invoke-virtual {v6, v10}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 200
    move-object/from16 v0, v16

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->emitGoto(Lgnu/bytecode/Label;)V

    .line 202
    invoke-virtual {v9, v6}, Lgnu/bytecode/Label;->define(Lgnu/bytecode/CodeAttr;)V

    .line 204
    invoke-virtual {v6}, Lgnu/bytecode/CodeAttr;->popScope()Lgnu/bytecode/Scope;

    .line 205
    return-void

    .line 120
    .end local v3    # "app":Lgnu/expr/Expression;
    .end local v5    # "args":[Lgnu/expr/Expression;
    .end local v7    # "counter":Lgnu/bytecode/Variable;
    .end local v8    # "counterDecl":Lgnu/expr/Declaration;
    .end local v9    # "doneLabel":Lgnu/bytecode/Label;
    .end local v10    # "indexVar":Lgnu/bytecode/Variable;
    .end local v11    # "nextVar":Lgnu/bytecode/Variable;
    .end local v16    # "top":Lgnu/bytecode/Label;
    .end local v17    # "valuesVar":Lgnu/bytecode/Variable;
    :cond_3
    const/4 v7, 0x0

    .line 121
    .restart local v7    # "counter":Lgnu/bytecode/Variable;
    const/4 v8, 0x0

    .restart local v8    # "counterDecl":Lgnu/expr/Declaration;
    goto/16 :goto_0

    .line 129
    :cond_4
    invoke-virtual {v12}, Lgnu/expr/Declaration;->getName()Ljava/lang/String;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v14

    .line 130
    .local v14, "pname":Ljava/lang/String;
    new-instance v12, Lgnu/expr/Declaration;

    .end local v12    # "param":Lgnu/expr/Declaration;
    invoke-virtual {v13}, Lgnu/bytecode/Type;->getImplementationType()Lgnu/bytecode/Type;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v6, v0, v14}, Lgnu/bytecode/CodeAttr;->addLocal(Lgnu/bytecode/Type;Ljava/lang/String;)Lgnu/bytecode/Variable;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-direct {v12, v0}, Lgnu/expr/Declaration;-><init>(Lgnu/bytecode/Variable;)V

    .restart local v12    # "param":Lgnu/expr/Declaration;
    goto/16 :goto_1

    .line 139
    .end local v14    # "pname":Ljava/lang/String;
    :cond_5
    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v5, v0, [Lgnu/expr/Expression;

    const/16 v18, 0x0

    new-instance v19, Lgnu/expr/ReferenceExp;

    move-object/from16 v0, v19

    invoke-direct {v0, v12}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v19, v5, v18

    .restart local v5    # "args":[Lgnu/expr/Expression;
    goto/16 :goto_2
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
    .line 37
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->getNextArg()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lgnu/mapping/Procedure;

    .line 38
    .local v4, "proc":Lgnu/mapping/Procedure;
    iget-object v3, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 39
    .local v3, "out":Lgnu/lists/Consumer;
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->getNextArg()Ljava/lang/Object;

    move-result-object v6

    .line 40
    .local v6, "val":Ljava/lang/Object;
    const/4 v8, 0x1

    invoke-static {v4, v8}, Lgnu/mapping/Procedure;->checkArgCount(Lgnu/mapping/Procedure;I)V

    .line 41
    instance-of v8, v6, Lgnu/mapping/Values;

    if-eqz v8, :cond_1

    .line 43
    const/4 v2, 0x0

    .line 44
    .local v2, "ipos":I
    iget v0, p0, Lgnu/kawa/functions/ValuesMap;->startCounter:I

    .local v0, "count":I
    move-object v7, v6

    .line 45
    check-cast v7, Lgnu/mapping/Values;

    .line 46
    .local v7, "values":Lgnu/mapping/Values;
    :goto_0
    invoke-virtual {v7, v2}, Lgnu/mapping/Values;->nextPos(I)I

    move-result v2

    if-eqz v2, :cond_2

    .line 48
    invoke-virtual {v7, v2}, Lgnu/mapping/Values;->getPosPrevious(I)Ljava/lang/Object;

    move-result-object v5

    .line 49
    .local v5, "v":Ljava/lang/Object;
    iget v8, p0, Lgnu/kawa/functions/ValuesMap;->startCounter:I

    if-ltz v8, :cond_0

    .line 50
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "count":I
    .local v1, "count":I
    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v8

    invoke-virtual {v4, v5, v8, p1}, Lgnu/mapping/Procedure;->check2(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)V

    move v0, v1

    .line 53
    .end local v1    # "count":I
    .restart local v0    # "count":I
    :goto_1
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->runUntilDone()V

    goto :goto_0

    .line 52
    :cond_0
    invoke-virtual {v4, v5, p1}, Lgnu/mapping/Procedure;->check1(Ljava/lang/Object;Lgnu/mapping/CallContext;)V

    goto :goto_1

    .line 58
    .end local v0    # "count":I
    .end local v2    # "ipos":I
    .end local v5    # "v":Ljava/lang/Object;
    .end local v7    # "values":Lgnu/mapping/Values;
    :cond_1
    iget v8, p0, Lgnu/kawa/functions/ValuesMap;->startCounter:I

    if-ltz v8, :cond_3

    .line 59
    iget v8, p0, Lgnu/kawa/functions/ValuesMap;->startCounter:I

    invoke-static {v8}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v8

    invoke-virtual {v4, v6, v8, p1}, Lgnu/mapping/Procedure;->check2(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)V

    .line 62
    :goto_2
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->runUntilDone()V

    .line 64
    :cond_2
    return-void

    .line 61
    :cond_3
    invoke-virtual {v4, v6, p1}, Lgnu/mapping/Procedure;->check1(Ljava/lang/Object;Lgnu/mapping/CallContext;)V

    goto :goto_2
.end method

.method public compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 7
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "comp"    # Lgnu/expr/Compilation;
    .param p3, "target"    # Lgnu/expr/Target;

    .prologue
    .line 84
    invoke-static {p1, p0}, Lgnu/kawa/functions/ValuesMap;->canInline(Lgnu/expr/ApplyExp;Lgnu/kawa/functions/ValuesMap;)Lgnu/expr/LambdaExp;

    move-result-object v0

    .line 85
    .local v0, "lambda":Lgnu/expr/LambdaExp;
    if-nez v0, :cond_0

    .line 87
    invoke-static {p1, p2, p3}, Lgnu/expr/ApplyExp;->compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 99
    :goto_0
    return-void

    .line 90
    :cond_0
    invoke-virtual {p1}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v6

    .line 91
    .local v6, "args":[Lgnu/expr/Expression;
    instance-of v2, p3, Lgnu/expr/IgnoreTarget;

    if-nez v2, :cond_1

    instance-of v2, p3, Lgnu/expr/ConsumerTarget;

    if-nez v2, :cond_1

    .line 94
    invoke-static {p1, p2, p3}, Lgnu/expr/ConsumerTarget;->compileUsingConsumer(Lgnu/expr/Expression;Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto :goto_0

    .line 97
    :cond_1
    const/4 v2, 0x1

    aget-object v1, v6, v2

    .line 98
    .local v1, "vals":Lgnu/expr/Expression;
    iget v2, p0, Lgnu/kawa/functions/ValuesMap;->startCounter:I

    const/4 v3, 0x0

    move-object v4, p2

    move-object v5, p3

    invoke-static/range {v0 .. v5}, Lgnu/kawa/functions/ValuesMap;->compileInlined(Lgnu/expr/LambdaExp;Lgnu/expr/Expression;ILgnu/bytecode/Method;Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto :goto_0
.end method

.method public getReturnType([Lgnu/expr/Expression;)Lgnu/bytecode/Type;
    .locals 1
    .param p1, "args"    # [Lgnu/expr/Expression;

    .prologue
    .line 209
    sget-object v0, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    return-object v0
.end method

.method public numArgs()I
    .locals 1

    .prologue
    .line 33
    const/16 v0, 0x2002

    return v0
.end method
