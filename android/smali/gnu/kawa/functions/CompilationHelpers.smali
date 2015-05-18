.class public Lgnu/kawa/functions/CompilationHelpers;
.super Ljava/lang/Object;
.source "CompilationHelpers.java"


# static fields
.field public static final setterDecl:Lgnu/expr/Declaration;

.field static final setterField:Lgnu/bytecode/Field;

.field static final setterType:Lgnu/bytecode/ClassType;

.field static final typeList:Lgnu/bytecode/ClassType;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 30
    const-string v0, "java.util.List"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    sput-object v0, Lgnu/kawa/functions/CompilationHelpers;->typeList:Lgnu/bytecode/ClassType;

    .line 103
    const-string v0, "gnu.kawa.functions.Setter"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    sput-object v0, Lgnu/kawa/functions/CompilationHelpers;->setterType:Lgnu/bytecode/ClassType;

    .line 104
    sget-object v0, Lgnu/kawa/functions/CompilationHelpers;->setterType:Lgnu/bytecode/ClassType;

    const-string v1, "setter"

    invoke-virtual {v0, v1}, Lgnu/bytecode/ClassType;->getDeclaredField(Ljava/lang/String;)Lgnu/bytecode/Field;

    move-result-object v0

    sput-object v0, Lgnu/kawa/functions/CompilationHelpers;->setterField:Lgnu/bytecode/Field;

    .line 105
    new-instance v0, Lgnu/expr/Declaration;

    const-string v1, "setter"

    sget-object v2, Lgnu/kawa/functions/CompilationHelpers;->setterField:Lgnu/bytecode/Field;

    invoke-direct {v0, v1, v2}, Lgnu/expr/Declaration;-><init>(Ljava/lang/Object;Lgnu/bytecode/Field;)V

    sput-object v0, Lgnu/kawa/functions/CompilationHelpers;->setterDecl:Lgnu/expr/Declaration;

    .line 106
    sget-object v0, Lgnu/kawa/functions/CompilationHelpers;->setterDecl:Lgnu/expr/Declaration;

    new-instance v1, Lgnu/expr/QuoteExp;

    sget-object v2, Lgnu/kawa/functions/Setter;->setter:Lgnu/kawa/functions/Setter;

    invoke-direct {v1, v2}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static nonNumeric(Lgnu/expr/Expression;)Z
    .locals 3
    .param p0, "exp"    # Lgnu/expr/Expression;

    .prologue
    const/4 v1, 0x0

    .line 21
    instance-of v2, p0, Lgnu/expr/QuoteExp;

    if-eqz v2, :cond_0

    .line 23
    check-cast p0, Lgnu/expr/QuoteExp;

    .end local p0    # "exp":Lgnu/expr/Expression;
    invoke-virtual {p0}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v0

    .line 24
    .local v0, "value":Ljava/lang/Object;
    instance-of v2, v0, Lgnu/math/Numeric;

    if-nez v2, :cond_0

    instance-of v2, v0, Lgnu/text/Char;

    if-nez v2, :cond_0

    instance-of v2, v0, Lgnu/mapping/Symbol;

    if-nez v2, :cond_0

    const/4 v1, 0x1

    .line 27
    :cond_0
    return v1
.end method

.method public static validateApplyToArgs(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
    .locals 18
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "visitor"    # Lgnu/expr/InlineCalls;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "applyToArgs"    # Lgnu/mapping/Procedure;

    .prologue
    .line 41
    invoke-virtual/range {p0 .. p0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v2

    .line 42
    .local v2, "args":[Lgnu/expr/Expression;
    array-length v14, v2

    add-int/lit8 v8, v14, -0x1

    .line 43
    .local v8, "nargs":I
    if-ltz v8, :cond_8

    .line 45
    const/4 v14, 0x0

    aget-object v10, v2, v14

    .line 46
    .local v10, "proc":Lgnu/expr/Expression;
    const/4 v14, 0x1

    invoke-virtual {v10, v14}, Lgnu/expr/Expression;->getFlag(I)Z

    move-result v14

    if-nez v14, :cond_1

    .line 48
    instance-of v14, v10, Lgnu/expr/LambdaExp;

    if-eqz v14, :cond_0

    .line 50
    new-array v12, v8, [Lgnu/expr/Expression;

    .line 51
    .local v12, "rargs":[Lgnu/expr/Expression;
    const/4 v14, 0x1

    const/4 v15, 0x0

    invoke-static {v2, v14, v12, v15, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 52
    new-instance v14, Lgnu/expr/ApplyExp;

    invoke-direct {v14, v10, v12}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    move-object/from16 v0, p0

    invoke-virtual {v14, v0}, Lgnu/expr/ApplyExp;->setLine(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v14

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v14, v1}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object p0

    .line 100
    .end local v10    # "proc":Lgnu/expr/Expression;
    .end local v12    # "rargs":[Lgnu/expr/Expression;
    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    :goto_0
    return-object p0

    .line 54
    .restart local v10    # "proc":Lgnu/expr/Expression;
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_0
    const/4 v14, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v10, v14}, Lgnu/expr/InlineCalls;->visit(Lgnu/expr/Expression;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object v10

    .line 55
    const/4 v14, 0x0

    aput-object v10, v2, v14

    .line 57
    :cond_1
    invoke-virtual {v10}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v14

    invoke-virtual {v14}, Lgnu/bytecode/Type;->getRealType()Lgnu/bytecode/Type;

    move-result-object v11

    .line 58
    .local v11, "ptype":Lgnu/bytecode/Type;
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/InlineCalls;->getCompilation()Lgnu/expr/Compilation;

    move-result-object v3

    .line 59
    .local v3, "comp":Lgnu/expr/Compilation;
    invoke-virtual {v3}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v7

    .line 60
    .local v7, "language":Lgnu/expr/Language;
    sget-object v14, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    invoke-virtual {v11, v14}, Lgnu/bytecode/Type;->isSubtype(Lgnu/bytecode/Type;)Z

    move-result v14

    if-eqz v14, :cond_2

    .line 62
    new-array v12, v8, [Lgnu/expr/Expression;

    .line 63
    .restart local v12    # "rargs":[Lgnu/expr/Expression;
    const/4 v14, 0x1

    const/4 v15, 0x0

    invoke-static {v2, v14, v12, v15, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 64
    new-instance v9, Lgnu/expr/ApplyExp;

    invoke-direct {v9, v10, v12}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    .line 65
    .local v9, "nexp":Lgnu/expr/ApplyExp;
    move-object/from16 v0, p0

    invoke-virtual {v9, v0}, Lgnu/expr/ApplyExp;->setLine(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    .line 66
    const/4 v14, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v10, v9, v0, v1, v14}, Lgnu/expr/Expression;->validateApply(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/expr/Declaration;)Lgnu/expr/Expression;

    move-result-object p0

    goto :goto_0

    .line 70
    .end local v9    # "nexp":Lgnu/expr/ApplyExp;
    .end local v12    # "rargs":[Lgnu/expr/Expression;
    :cond_2
    const/4 v13, 0x0

    .line 71
    .local v13, "result":Lgnu/expr/ApplyExp;
    invoke-static {v11, v3}, Lgnu/kawa/reflect/CompileReflect;->checkKnownClass(Lgnu/bytecode/Type;Lgnu/expr/Compilation;)I

    move-result v14

    if-gez v14, :cond_4

    .line 93
    .end local v11    # "ptype":Lgnu/bytecode/Type;
    :cond_3
    :goto_1
    if-eqz v13, :cond_8

    .line 95
    move-object/from16 v0, p0

    invoke-virtual {v13, v0}, Lgnu/expr/ApplyExp;->setLine(Lgnu/expr/Expression;)Lgnu/expr/Expression;

    .line 96
    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v13, v1}, Lgnu/expr/InlineCalls;->visitApplyOnly(Lgnu/expr/ApplyExp;Lgnu/bytecode/Type;)Lgnu/expr/Expression;

    move-result-object p0

    goto :goto_0

    .line 73
    .restart local v11    # "ptype":Lgnu/bytecode/Type;
    :cond_4
    sget-object v14, Lgnu/expr/Compilation;->typeType:Lgnu/bytecode/ClassType;

    invoke-virtual {v11, v14}, Lgnu/bytecode/Type;->isSubtype(Lgnu/bytecode/Type;)Z

    move-result v14

    if-nez v14, :cond_5

    const/4 v14, 0x0

    invoke-virtual {v7, v10, v14}, Lgnu/expr/Language;->getTypeFor(Lgnu/expr/Expression;Z)Lgnu/bytecode/Type;

    move-result-object v14

    if-eqz v14, :cond_6

    .line 76
    :cond_5
    new-instance v13, Lgnu/expr/ApplyExp;

    .end local v13    # "result":Lgnu/expr/ApplyExp;
    sget-object v14, Lgnu/kawa/reflect/Invoke;->make:Lgnu/kawa/reflect/Invoke;

    invoke-direct {v13, v14, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .restart local v13    # "result":Lgnu/expr/ApplyExp;
    goto :goto_1

    .line 78
    :cond_6
    instance-of v14, v11, Lgnu/bytecode/ArrayType;

    if-eqz v14, :cond_7

    .line 80
    check-cast v11, Lgnu/bytecode/ArrayType;

    .end local v11    # "ptype":Lgnu/bytecode/Type;
    invoke-virtual {v11}, Lgnu/bytecode/ArrayType;->getComponentType()Lgnu/bytecode/Type;

    move-result-object v5

    .line 81
    .local v5, "elementType":Lgnu/bytecode/Type;
    new-instance v13, Lgnu/expr/ApplyExp;

    .end local v13    # "result":Lgnu/expr/ApplyExp;
    new-instance v14, Lgnu/kawa/reflect/ArrayGet;

    invoke-direct {v14, v5}, Lgnu/kawa/reflect/ArrayGet;-><init>(Lgnu/bytecode/Type;)V

    invoke-direct {v13, v14, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .line 82
    .restart local v13    # "result":Lgnu/expr/ApplyExp;
    goto :goto_1

    .line 83
    .end local v5    # "elementType":Lgnu/bytecode/Type;
    .restart local v11    # "ptype":Lgnu/bytecode/Type;
    :cond_7
    instance-of v14, v11, Lgnu/bytecode/ClassType;

    if-eqz v14, :cond_3

    move-object v4, v11

    check-cast v4, Lgnu/bytecode/ClassType;

    .local v4, "ctype":Lgnu/bytecode/ClassType;
    sget-object v14, Lgnu/kawa/functions/CompilationHelpers;->typeList:Lgnu/bytecode/ClassType;

    invoke-virtual {v4, v14}, Lgnu/bytecode/ClassType;->isSubclass(Lgnu/bytecode/ClassType;)Z

    move-result v14

    if-eqz v14, :cond_3

    const/4 v14, 0x1

    if-ne v8, v14, :cond_3

    .line 90
    const-string v14, "get"

    const/4 v15, 0x1

    new-array v15, v15, [Lgnu/bytecode/Type;

    const/16 v16, 0x0

    sget-object v17, Lgnu/bytecode/Type;->intType:Lgnu/bytecode/PrimType;

    aput-object v17, v15, v16

    invoke-virtual {v4, v14, v15}, Lgnu/bytecode/ClassType;->getMethod(Ljava/lang/String;[Lgnu/bytecode/Type;)Lgnu/bytecode/Method;

    move-result-object v6

    .line 91
    .local v6, "get":Lgnu/bytecode/Method;
    new-instance v13, Lgnu/expr/ApplyExp;

    .end local v13    # "result":Lgnu/expr/ApplyExp;
    invoke-direct {v13, v6, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    .restart local v13    # "result":Lgnu/expr/ApplyExp;
    goto :goto_1

    .line 99
    .end local v3    # "comp":Lgnu/expr/Compilation;
    .end local v4    # "ctype":Lgnu/bytecode/ClassType;
    .end local v6    # "get":Lgnu/bytecode/Method;
    .end local v7    # "language":Lgnu/expr/Language;
    .end local v10    # "proc":Lgnu/expr/Expression;
    .end local v11    # "ptype":Lgnu/bytecode/Type;
    .end local v13    # "result":Lgnu/expr/ApplyExp;
    :cond_8
    invoke-virtual/range {p0 .. p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    goto/16 :goto_0
.end method

.method public static validateIsEqv(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
    .locals 2
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "visitor"    # Lgnu/expr/InlineCalls;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    .line 160
    invoke-virtual {p0, p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    .line 161
    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v0

    .line 162
    .local v0, "args":[Lgnu/expr/Expression;
    const/4 v1, 0x0

    aget-object v1, v0, v1

    invoke-static {v1}, Lgnu/kawa/functions/CompilationHelpers;->nonNumeric(Lgnu/expr/Expression;)Z

    move-result v1

    if-nez v1, :cond_0

    const/4 v1, 0x1

    aget-object v1, v0, v1

    invoke-static {v1}, Lgnu/kawa/functions/CompilationHelpers;->nonNumeric(Lgnu/expr/Expression;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 163
    :cond_0
    new-instance p0, Lgnu/expr/ApplyExp;

    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    check-cast p3, Lgnu/kawa/functions/IsEqv;

    .end local p3    # "proc":Lgnu/mapping/Procedure;
    iget-object v1, p3, Lgnu/kawa/functions/IsEqv;->isEq:Lgnu/kawa/functions/IsEq;

    invoke-direct {p0, v1, v0}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .line 164
    :cond_1
    return-object p0
.end method

.method public static validateSetter(Lgnu/expr/ApplyExp;Lgnu/expr/InlineCalls;Lgnu/bytecode/Type;Lgnu/mapping/Procedure;)Lgnu/expr/Expression;
    .locals 9
    .param p0, "exp"    # Lgnu/expr/ApplyExp;
    .param p1, "visitor"    # Lgnu/expr/InlineCalls;
    .param p2, "required"    # Lgnu/bytecode/Type;
    .param p3, "proc"    # Lgnu/mapping/Procedure;

    .prologue
    .line 111
    invoke-virtual {p0, p1}, Lgnu/expr/ApplyExp;->visitArgs(Lgnu/expr/InlineCalls;)V

    .line 112
    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v2

    .line 113
    .local v2, "args":[Lgnu/expr/Expression;
    array-length v7, v2

    const/4 v8, 0x1

    if-ne v7, v8, :cond_0

    .line 115
    const/4 v7, 0x0

    aget-object v0, v2, v7

    .line 116
    .local v0, "arg":Lgnu/expr/Expression;
    invoke-virtual {v0}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v1

    .line 118
    .local v1, "argType":Lgnu/bytecode/Type;
    instance-of v7, v1, Lgnu/bytecode/ArrayType;

    if-eqz v7, :cond_1

    .line 120
    new-instance p0, Lgnu/kawa/functions/SetArrayExp;

    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    check-cast v1, Lgnu/bytecode/ArrayType;

    .end local v1    # "argType":Lgnu/bytecode/Type;
    invoke-direct {p0, v0, v1}, Lgnu/kawa/functions/SetArrayExp;-><init>(Lgnu/expr/Expression;Lgnu/bytecode/ArrayType;)V

    .line 154
    .end local v0    # "arg":Lgnu/expr/Expression;
    :cond_0
    :goto_0
    return-object p0

    .line 122
    .restart local v0    # "arg":Lgnu/expr/Expression;
    .restart local v1    # "argType":Lgnu/bytecode/Type;
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_1
    instance-of v7, v1, Lgnu/bytecode/ClassType;

    if-eqz v7, :cond_2

    move-object v3, v1

    check-cast v3, Lgnu/bytecode/ClassType;

    .local v3, "ctype":Lgnu/bytecode/ClassType;
    sget-object v7, Lgnu/kawa/functions/CompilationHelpers;->typeList:Lgnu/bytecode/ClassType;

    invoke-virtual {v3, v7}, Lgnu/bytecode/ClassType;->isSubclass(Lgnu/bytecode/ClassType;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 125
    instance-of v7, p0, Lgnu/kawa/functions/SetListExp;

    if-nez v7, :cond_0

    .line 128
    new-instance v7, Lgnu/kawa/functions/SetListExp;

    invoke-virtual {p0}, Lgnu/expr/ApplyExp;->getFunction()Lgnu/expr/Expression;

    move-result-object v8

    invoke-direct {v7, v8, v2}, Lgnu/kawa/functions/SetListExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    move-object p0, v7

    goto :goto_0

    .line 130
    .end local v3    # "ctype":Lgnu/bytecode/ClassType;
    :cond_2
    instance-of v7, v0, Lgnu/expr/ReferenceExp;

    if-eqz v7, :cond_3

    move-object v7, v0

    .line 132
    check-cast v7, Lgnu/expr/ReferenceExp;

    invoke-virtual {v7}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v4

    .line 133
    .local v4, "decl":Lgnu/expr/Declaration;
    if-eqz v4, :cond_3

    .line 134
    invoke-virtual {v4}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v0

    .line 136
    .end local v4    # "decl":Lgnu/expr/Declaration;
    :cond_3
    instance-of v7, v0, Lgnu/expr/QuoteExp;

    if-eqz v7, :cond_0

    .line 138
    check-cast v0, Lgnu/expr/QuoteExp;

    .end local v0    # "arg":Lgnu/expr/Expression;
    invoke-virtual {v0}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v6

    .line 139
    .local v6, "value":Ljava/lang/Object;
    instance-of v7, v6, Lgnu/mapping/Procedure;

    if-eqz v7, :cond_0

    .line 141
    check-cast v6, Lgnu/mapping/Procedure;

    .end local v6    # "value":Ljava/lang/Object;
    invoke-virtual {v6}, Lgnu/mapping/Procedure;->getSetter()Lgnu/mapping/Procedure;

    move-result-object v5

    .line 142
    .local v5, "setter":Lgnu/mapping/Procedure;
    instance-of v7, v5, Lgnu/mapping/Procedure;

    if-eqz v7, :cond_0

    .line 144
    instance-of v7, v5, Ljava/io/Externalizable;

    if-eqz v7, :cond_4

    .line 145
    new-instance p0, Lgnu/expr/QuoteExp;

    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    invoke-direct {p0, v5}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    goto :goto_0

    .line 146
    .restart local p0    # "exp":Lgnu/expr/ApplyExp;
    :cond_4
    check-cast v5, Lgnu/mapping/Procedure;

    .end local v5    # "setter":Lgnu/mapping/Procedure;
    invoke-static {v5}, Lgnu/expr/Declaration;->getDeclaration(Lgnu/mapping/Named;)Lgnu/expr/Declaration;

    move-result-object v4

    .line 148
    .restart local v4    # "decl":Lgnu/expr/Declaration;
    if-eqz v4, :cond_0

    .line 149
    new-instance p0, Lgnu/expr/ReferenceExp;

    .end local p0    # "exp":Lgnu/expr/ApplyExp;
    invoke-direct {p0, v4}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    goto :goto_0
.end method
