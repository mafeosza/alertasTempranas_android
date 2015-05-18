.class public Lgnu/expr/CheckedTarget;
.super Lgnu/expr/StackTarget;
.source "CheckedTarget.java"


# static fields
.field static initWrongTypeProcMethod:Lgnu/bytecode/Method;

.field static initWrongTypeStringMethod:Lgnu/bytecode/Method;

.field static typeClassCastException:Lgnu/bytecode/ClassType;

.field static typeWrongType:Lgnu/bytecode/ClassType;


# instance fields
.field argno:I

.field proc:Lgnu/expr/LambdaExp;

.field procname:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lgnu/bytecode/Type;)V
    .locals 1
    .param p1, "type"    # Lgnu/bytecode/Type;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lgnu/expr/StackTarget;-><init>(Lgnu/bytecode/Type;)V

    .line 23
    const/4 v0, -0x4

    iput v0, p0, Lgnu/expr/CheckedTarget;->argno:I

    .line 24
    return-void
.end method

.method public constructor <init>(Lgnu/bytecode/Type;Lgnu/expr/LambdaExp;I)V
    .locals 1
    .param p1, "type"    # Lgnu/bytecode/Type;
    .param p2, "proc"    # Lgnu/expr/LambdaExp;
    .param p3, "argno"    # I

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lgnu/expr/StackTarget;-><init>(Lgnu/bytecode/Type;)V

    .line 29
    iput-object p2, p0, Lgnu/expr/CheckedTarget;->proc:Lgnu/expr/LambdaExp;

    .line 30
    invoke-virtual {p2}, Lgnu/expr/LambdaExp;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lgnu/expr/CheckedTarget;->procname:Ljava/lang/String;

    .line 31
    iput p3, p0, Lgnu/expr/CheckedTarget;->argno:I

    .line 32
    return-void
.end method

.method public constructor <init>(Lgnu/bytecode/Type;Ljava/lang/String;I)V
    .locals 0
    .param p1, "type"    # Lgnu/bytecode/Type;
    .param p2, "procname"    # Ljava/lang/String;
    .param p3, "argno"    # I

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lgnu/expr/StackTarget;-><init>(Lgnu/bytecode/Type;)V

    .line 37
    iput-object p2, p0, Lgnu/expr/CheckedTarget;->procname:Ljava/lang/String;

    .line 38
    iput p3, p0, Lgnu/expr/CheckedTarget;->argno:I

    .line 39
    return-void
.end method

.method public static emitCheckedCoerce(Lgnu/expr/Compilation;Lgnu/expr/LambdaExp;ILgnu/bytecode/Type;)V
    .locals 6
    .param p0, "comp"    # Lgnu/expr/Compilation;
    .param p1, "proc"    # Lgnu/expr/LambdaExp;
    .param p2, "argno"    # I
    .param p3, "type"    # Lgnu/bytecode/Type;

    .prologue
    .line 110
    invoke-virtual {p1}, Lgnu/expr/LambdaExp;->getName()Ljava/lang/String;

    move-result-object v2

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move v3, p2

    move-object v4, p3

    invoke-static/range {v0 .. v5}, Lgnu/expr/CheckedTarget;->emitCheckedCoerce(Lgnu/expr/Compilation;Lgnu/expr/LambdaExp;Ljava/lang/String;ILgnu/bytecode/Type;Lgnu/bytecode/Variable;)V

    .line 111
    return-void
.end method

.method public static emitCheckedCoerce(Lgnu/expr/Compilation;Lgnu/expr/LambdaExp;ILgnu/bytecode/Type;Lgnu/bytecode/Variable;)V
    .locals 6
    .param p0, "comp"    # Lgnu/expr/Compilation;
    .param p1, "proc"    # Lgnu/expr/LambdaExp;
    .param p2, "argno"    # I
    .param p3, "type"    # Lgnu/bytecode/Type;
    .param p4, "argValue"    # Lgnu/bytecode/Variable;

    .prologue
    .line 116
    invoke-virtual {p1}, Lgnu/expr/LambdaExp;->getName()Ljava/lang/String;

    move-result-object v2

    move-object v0, p0

    move-object v1, p1

    move v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-static/range {v0 .. v5}, Lgnu/expr/CheckedTarget;->emitCheckedCoerce(Lgnu/expr/Compilation;Lgnu/expr/LambdaExp;Ljava/lang/String;ILgnu/bytecode/Type;Lgnu/bytecode/Variable;)V

    .line 117
    return-void
.end method

.method static emitCheckedCoerce(Lgnu/expr/Compilation;Lgnu/expr/LambdaExp;Ljava/lang/String;ILgnu/bytecode/Type;Lgnu/bytecode/Variable;)V
    .locals 14
    .param p0, "comp"    # Lgnu/expr/Compilation;
    .param p1, "proc"    # Lgnu/expr/LambdaExp;
    .param p2, "procname"    # Ljava/lang/String;
    .param p3, "argno"    # I
    .param p4, "type"    # Lgnu/bytecode/Type;
    .param p5, "argValue"    # Lgnu/bytecode/Variable;

    .prologue
    .line 123
    invoke-virtual {p0}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v1

    .line 128
    .local v1, "code":Lgnu/bytecode/CodeAttr;
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->isInTry()Z

    move-result v6

    .line 129
    .local v6, "isInTry":Z
    invoke-static {}, Lgnu/expr/CheckedTarget;->initWrongType()V

    .line 130
    new-instance v9, Lgnu/bytecode/Label;

    invoke-direct {v9, v1}, Lgnu/bytecode/Label;-><init>(Lgnu/bytecode/CodeAttr;)V

    .line 132
    .local v9, "startTry":Lgnu/bytecode/Label;
    if-nez p5, :cond_2

    sget-object v12, Lgnu/bytecode/Type;->toStringType:Lgnu/bytecode/ClassType;

    move-object/from16 v0, p4

    if-eq v0, v12, :cond_2

    .line 134
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->pushScope()Lgnu/bytecode/Scope;

    move-result-object v11

    .line 135
    .local v11, "tmpScope":Lgnu/bytecode/Scope;
    sget-object v12, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    invoke-virtual {v1, v12}, Lgnu/bytecode/CodeAttr;->addLocal(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;

    move-result-object p5

    .line 136
    const/4 v12, 0x1

    invoke-virtual {v1, v12}, Lgnu/bytecode/CodeAttr;->emitDup(I)V

    .line 137
    move-object/from16 v0, p5

    invoke-virtual {v1, v0}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 141
    :goto_0
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->getPC()I

    move-result v8

    .line 142
    .local v8, "startPC":I
    invoke-virtual {v9, v1}, Lgnu/bytecode/Label;->define(Lgnu/bytecode/CodeAttr;)V

    .line 143
    move-object/from16 v0, p4

    invoke-static {v0, p0}, Lgnu/expr/CheckedTarget;->emitCoerceFromObject(Lgnu/bytecode/Type;Lgnu/expr/Compilation;)V

    .line 145
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->getPC()I

    move-result v3

    .line 150
    .local v3, "endPC":I
    if-eq v3, v8, :cond_0

    sget-object v12, Lgnu/bytecode/Type;->toStringType:Lgnu/bytecode/ClassType;

    move-object/from16 v0, p4

    if-ne v0, v12, :cond_3

    .line 155
    :cond_0
    if-eqz v11, :cond_1

    .line 156
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->popScope()Lgnu/bytecode/Scope;

    .line 204
    .end local p2    # "procname":Ljava/lang/String;
    :cond_1
    :goto_1
    return-void

    .line 140
    .end local v3    # "endPC":I
    .end local v8    # "startPC":I
    .end local v11    # "tmpScope":Lgnu/bytecode/Scope;
    .restart local p2    # "procname":Ljava/lang/String;
    :cond_2
    const/4 v11, 0x0

    .restart local v11    # "tmpScope":Lgnu/bytecode/Scope;
    goto :goto_0

    .line 160
    .restart local v3    # "endPC":I
    .restart local v8    # "startPC":I
    :cond_3
    new-instance v4, Lgnu/bytecode/Label;

    invoke-direct {v4, v1}, Lgnu/bytecode/Label;-><init>(Lgnu/bytecode/CodeAttr;)V

    .line 161
    .local v4, "endTry":Lgnu/bytecode/Label;
    invoke-virtual {v4, v1}, Lgnu/bytecode/Label;->define(Lgnu/bytecode/CodeAttr;)V

    .line 163
    new-instance v2, Lgnu/bytecode/Label;

    invoke-direct {v2, v1}, Lgnu/bytecode/Label;-><init>(Lgnu/bytecode/CodeAttr;)V

    .line 164
    .local v2, "endLabel":Lgnu/bytecode/Label;
    invoke-virtual {v2, v1}, Lgnu/bytecode/Label;->setTypes(Lgnu/bytecode/CodeAttr;)V

    .line 165
    if-eqz v6, :cond_4

    .line 166
    invoke-virtual {v1, v2}, Lgnu/bytecode/CodeAttr;->emitGoto(Lgnu/bytecode/Label;)V

    .line 167
    :cond_4
    const/4 v5, 0x0

    .line 168
    .local v5, "fragment_cookie":I
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->setUnreachable()V

    .line 169
    if-nez v6, :cond_5

    .line 170
    invoke-virtual {v1, v2}, Lgnu/bytecode/CodeAttr;->beginFragment(Lgnu/bytecode/Label;)I

    move-result v5

    .line 171
    :cond_5
    sget-object v12, Lgnu/expr/CheckedTarget;->typeClassCastException:Lgnu/bytecode/ClassType;

    invoke-virtual {v1, v9, v4, v12}, Lgnu/bytecode/CodeAttr;->addHandler(Lgnu/bytecode/Label;Lgnu/bytecode/Label;Lgnu/bytecode/ClassType;)V

    .line 174
    const/4 v10, 0x0

    .line 175
    .local v10, "thisIsProc":Z
    if-eqz p1, :cond_6

    invoke-virtual {p1}, Lgnu/expr/LambdaExp;->isClassGenerated()Z

    move-result v12

    if-eqz v12, :cond_6

    iget-object v12, p0, Lgnu/expr/Compilation;->method:Lgnu/bytecode/Method;

    invoke-virtual {v12}, Lgnu/bytecode/Method;->getStaticFlag()Z

    move-result v12

    if-nez v12, :cond_6

    .line 178
    iget-object v12, p0, Lgnu/expr/Compilation;->method:Lgnu/bytecode/Method;

    invoke-virtual {v12}, Lgnu/bytecode/Method;->getDeclaringClass()Lgnu/bytecode/ClassType;

    move-result-object v12

    invoke-virtual {p1, p0}, Lgnu/expr/LambdaExp;->getCompiledClassType(Lgnu/expr/Compilation;)Lgnu/bytecode/ClassType;

    move-result-object v13

    if-ne v12, v13, :cond_6

    .line 179
    const/4 v10, 0x1

    .line 181
    :cond_6
    invoke-virtual {p0}, Lgnu/expr/Compilation;->getLineNumber()I

    move-result v7

    .line 182
    .local v7, "line":I
    if-lez v7, :cond_7

    .line 183
    invoke-virtual {v1, v7}, Lgnu/bytecode/CodeAttr;->putLineNumber(I)V

    .line 184
    :cond_7
    sget-object v12, Lgnu/expr/CheckedTarget;->typeWrongType:Lgnu/bytecode/ClassType;

    invoke-virtual {v1, v12}, Lgnu/bytecode/CodeAttr;->emitNew(Lgnu/bytecode/ClassType;)V

    .line 185
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitDupX()V

    .line 186
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitSwap()V

    .line 187
    if-eqz v10, :cond_9

    .line 188
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitPushThis()V

    .line 193
    .end local p2    # "procname":Ljava/lang/String;
    :goto_2
    move/from16 v0, p3

    invoke-virtual {v1, v0}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 194
    move-object/from16 v0, p5

    invoke-virtual {v1, v0}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 195
    if-eqz v10, :cond_b

    sget-object v12, Lgnu/expr/CheckedTarget;->initWrongTypeProcMethod:Lgnu/bytecode/Method;

    :goto_3
    invoke-virtual {v1, v12}, Lgnu/bytecode/CodeAttr;->emitInvokeSpecial(Lgnu/bytecode/Method;)V

    .line 197
    if-eqz v11, :cond_8

    .line 198
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->popScope()Lgnu/bytecode/Scope;

    .line 199
    :cond_8
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitThrow()V

    .line 200
    if-eqz v6, :cond_c

    .line 201
    invoke-virtual {v2, v1}, Lgnu/bytecode/Label;->define(Lgnu/bytecode/CodeAttr;)V

    goto :goto_1

    .line 190
    .restart local p2    # "procname":Ljava/lang/String;
    :cond_9
    if-nez p2, :cond_a

    const/4 v12, -0x4

    move/from16 v0, p3

    if-eq v0, v12, :cond_a

    const-string p2, "lambda"

    .end local p2    # "procname":Ljava/lang/String;
    :cond_a
    move-object/from16 v0, p2

    invoke-virtual {v1, v0}, Lgnu/bytecode/CodeAttr;->emitPushString(Ljava/lang/String;)V

    goto :goto_2

    .line 195
    :cond_b
    sget-object v12, Lgnu/expr/CheckedTarget;->initWrongTypeStringMethod:Lgnu/bytecode/Method;

    goto :goto_3

    .line 203
    :cond_c
    invoke-virtual {v1, v5}, Lgnu/bytecode/CodeAttr;->endFragment(I)V

    goto/16 :goto_1
.end method

.method public static emitCheckedCoerce(Lgnu/expr/Compilation;Ljava/lang/String;ILgnu/bytecode/Type;)V
    .locals 6
    .param p0, "comp"    # Lgnu/expr/Compilation;
    .param p1, "procname"    # Ljava/lang/String;
    .param p2, "argno"    # I
    .param p3, "type"    # Lgnu/bytecode/Type;

    .prologue
    const/4 v1, 0x0

    .line 104
    move-object v0, p0

    move-object v2, p1

    move v3, p2

    move-object v4, p3

    move-object v5, v1

    invoke-static/range {v0 .. v5}, Lgnu/expr/CheckedTarget;->emitCheckedCoerce(Lgnu/expr/Compilation;Lgnu/expr/LambdaExp;Ljava/lang/String;ILgnu/bytecode/Type;Lgnu/bytecode/Variable;)V

    .line 105
    return-void
.end method

.method public static getInstance(Lgnu/bytecode/Type;)Lgnu/expr/Target;
    .locals 1
    .param p0, "type"    # Lgnu/bytecode/Type;

    .prologue
    .line 55
    sget-object v0, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    if-ne p0, v0, :cond_0

    sget-object v0, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lgnu/expr/CheckedTarget;

    invoke-direct {v0, p0}, Lgnu/expr/CheckedTarget;-><init>(Lgnu/bytecode/Type;)V

    goto :goto_0
.end method

.method public static getInstance(Lgnu/bytecode/Type;Lgnu/expr/LambdaExp;I)Lgnu/expr/Target;
    .locals 1
    .param p0, "type"    # Lgnu/bytecode/Type;
    .param p1, "proc"    # Lgnu/expr/LambdaExp;
    .param p2, "argno"    # I

    .prologue
    .line 49
    sget-object v0, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    if-ne p0, v0, :cond_0

    sget-object v0, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lgnu/expr/CheckedTarget;

    invoke-direct {v0, p0, p1, p2}, Lgnu/expr/CheckedTarget;-><init>(Lgnu/bytecode/Type;Lgnu/expr/LambdaExp;I)V

    goto :goto_0
.end method

.method public static getInstance(Lgnu/bytecode/Type;Ljava/lang/String;I)Lgnu/expr/Target;
    .locals 1
    .param p0, "type"    # Lgnu/bytecode/Type;
    .param p1, "procname"    # Ljava/lang/String;
    .param p2, "argno"    # I

    .prologue
    .line 43
    sget-object v0, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    if-ne p0, v0, :cond_0

    sget-object v0, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lgnu/expr/CheckedTarget;

    invoke-direct {v0, p0, p1, p2}, Lgnu/expr/CheckedTarget;-><init>(Lgnu/bytecode/Type;Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public static getInstance(Lgnu/expr/Declaration;)Lgnu/expr/Target;
    .locals 3
    .param p0, "decl"    # Lgnu/expr/Declaration;

    .prologue
    .line 61
    invoke-virtual {p0}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v0

    invoke-virtual {p0}, Lgnu/expr/Declaration;->getName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, -0x2

    invoke-static {v0, v1, v2}, Lgnu/expr/CheckedTarget;->getInstance(Lgnu/bytecode/Type;Ljava/lang/String;I)Lgnu/expr/Target;

    move-result-object v0

    return-object v0
.end method

.method private static initWrongType()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 71
    sget-object v1, Lgnu/expr/CheckedTarget;->typeClassCastException:Lgnu/bytecode/ClassType;

    if-nez v1, :cond_0

    .line 72
    const-string v1, "java.lang.ClassCastException"

    invoke-static {v1}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v1

    sput-object v1, Lgnu/expr/CheckedTarget;->typeClassCastException:Lgnu/bytecode/ClassType;

    .line 73
    :cond_0
    sget-object v1, Lgnu/expr/CheckedTarget;->typeWrongType:Lgnu/bytecode/ClassType;

    if-nez v1, :cond_1

    .line 75
    const-string v1, "gnu.mapping.WrongType"

    invoke-static {v1}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v1

    sput-object v1, Lgnu/expr/CheckedTarget;->typeWrongType:Lgnu/bytecode/ClassType;

    .line 76
    new-array v0, v8, [Lgnu/bytecode/Type;

    .line 77
    .local v0, "args":[Lgnu/bytecode/Type;
    sget-object v1, Lgnu/expr/CheckedTarget;->typeClassCastException:Lgnu/bytecode/ClassType;

    aput-object v1, v0, v5

    .line 78
    sget-object v1, Lgnu/expr/Compilation;->javaStringType:Lgnu/bytecode/ClassType;

    aput-object v1, v0, v4

    .line 79
    sget-object v1, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    aput-object v1, v0, v6

    .line 80
    sget-object v1, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    aput-object v1, v0, v7

    .line 81
    sget-object v1, Lgnu/expr/CheckedTarget;->typeWrongType:Lgnu/bytecode/ClassType;

    const-string v2, "<init>"

    sget-object v3, Lgnu/bytecode/Type;->voidType:Lgnu/bytecode/PrimType;

    invoke-virtual {v1, v2, v4, v0, v3}, Lgnu/bytecode/ClassType;->addMethod(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;

    move-result-object v1

    sput-object v1, Lgnu/expr/CheckedTarget;->initWrongTypeStringMethod:Lgnu/bytecode/Method;

    .line 84
    new-array v0, v8, [Lgnu/bytecode/Type;

    .line 85
    sget-object v1, Lgnu/expr/CheckedTarget;->typeClassCastException:Lgnu/bytecode/ClassType;

    aput-object v1, v0, v5

    .line 86
    sget-object v1, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    aput-object v1, v0, v4

    .line 87
    sget-object v1, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    aput-object v1, v0, v6

    .line 88
    sget-object v1, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    aput-object v1, v0, v7

    .line 89
    sget-object v1, Lgnu/expr/CheckedTarget;->typeWrongType:Lgnu/bytecode/ClassType;

    const-string v2, "<init>"

    sget-object v3, Lgnu/bytecode/Type;->voidType:Lgnu/bytecode/PrimType;

    invoke-virtual {v1, v2, v4, v0, v3}, Lgnu/bytecode/ClassType;->addMethod(Ljava/lang/String;I[Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Method;

    move-result-object v1

    sput-object v1, Lgnu/expr/CheckedTarget;->initWrongTypeProcMethod:Lgnu/bytecode/Method;

    .line 93
    :cond_1
    return-void
.end method


# virtual methods
.method public compileFromStack(Lgnu/expr/Compilation;Lgnu/bytecode/Type;)V
    .locals 6
    .param p1, "comp"    # Lgnu/expr/Compilation;
    .param p2, "stackType"    # Lgnu/bytecode/Type;

    .prologue
    .line 97
    invoke-virtual {p0, p1, p2}, Lgnu/expr/CheckedTarget;->compileFromStack0(Lgnu/expr/Compilation;Lgnu/bytecode/Type;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 98
    iget-object v1, p0, Lgnu/expr/CheckedTarget;->proc:Lgnu/expr/LambdaExp;

    iget-object v2, p0, Lgnu/expr/CheckedTarget;->procname:Ljava/lang/String;

    iget v3, p0, Lgnu/expr/CheckedTarget;->argno:I

    iget-object v4, p0, Lgnu/expr/CheckedTarget;->type:Lgnu/bytecode/Type;

    const/4 v5, 0x0

    move-object v0, p1

    invoke-static/range {v0 .. v5}, Lgnu/expr/CheckedTarget;->emitCheckedCoerce(Lgnu/expr/Compilation;Lgnu/expr/LambdaExp;Ljava/lang/String;ILgnu/bytecode/Type;Lgnu/bytecode/Variable;)V

    .line 99
    :cond_0
    return-void
.end method
