.class public Lkawa/standard/set_b;
.super Lkawa/lang/Syntax;
.source "set_b.java"


# static fields
.field public static final set:Lkawa/standard/set_b;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 14
    new-instance v0, Lkawa/standard/set_b;

    invoke-direct {v0}, Lkawa/standard/set_b;-><init>()V

    sput-object v0, Lkawa/standard/set_b;->set:Lkawa/standard/set_b;

    .line 15
    sget-object v0, Lkawa/standard/set_b;->set:Lkawa/standard/set_b;

    const-string v1, "set!"

    invoke-virtual {v0, v1}, Lkawa/standard/set_b;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    return-void
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 25
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 19
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v10

    .line 20
    .local v10, "o1":Ljava/lang/Object;
    const/16 v19, 0x0

    .line 21
    .local v19, "syntax":Lkawa/lang/SyntaxForm;
    :goto_0
    instance-of v0, v10, Lkawa/lang/SyntaxForm;

    move/from16 v22, v0

    if-eqz v22, :cond_0

    move-object/from16 v19, v10

    .line 23
    check-cast v19, Lkawa/lang/SyntaxForm;

    .line 24
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v10

    goto :goto_0

    .line 26
    :cond_0
    instance-of v0, v10, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-nez v22, :cond_2

    .line 27
    const-string v22, "missing name"

    move-object/from16 v0, p2

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v17

    .line 89
    :cond_1
    :goto_1
    return-object v17

    :cond_2
    move-object v12, v10

    .line 28
    check-cast v12, Lgnu/lists/Pair;

    .line 29
    .local v12, "p1":Lgnu/lists/Pair;
    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v12, v1}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v8

    .line 30
    .local v8, "name":Lgnu/expr/Expression;
    invoke-virtual {v12}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v11

    .line 31
    .local v11, "o2":Ljava/lang/Object;
    :goto_2
    instance-of v0, v11, Lkawa/lang/SyntaxForm;

    move/from16 v22, v0

    if-eqz v22, :cond_3

    move-object/from16 v19, v11

    .line 33
    check-cast v19, Lkawa/lang/SyntaxForm;

    .line 34
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v11

    goto :goto_2

    .line 37
    :cond_3
    instance-of v0, v11, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-eqz v22, :cond_4

    move-object v13, v11

    check-cast v13, Lgnu/lists/Pair;

    .local v13, "p2":Lgnu/lists/Pair;
    invoke-virtual {v13}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    sget-object v23, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    if-eq v0, v1, :cond_5

    .line 39
    .end local v13    # "p2":Lgnu/lists/Pair;
    :cond_4
    const-string v22, "missing or extra arguments to set!"

    move-object/from16 v0, p2

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v17

    goto :goto_1

    .line 40
    .restart local v13    # "p2":Lgnu/lists/Pair;
    :cond_5
    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v13, v1}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v20

    .line 42
    .local v20, "value":Lgnu/expr/Expression;
    instance-of v0, v8, Lgnu/expr/ApplyExp;

    move/from16 v22, v0

    if-eqz v22, :cond_7

    move-object v4, v8

    .line 46
    check-cast v4, Lgnu/expr/ApplyExp;

    .line 47
    .local v4, "aexp":Lgnu/expr/ApplyExp;
    invoke-virtual {v4}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v5

    .line 48
    .local v5, "args":[Lgnu/expr/Expression;
    array-length v9, v5

    .line 49
    .local v9, "nargs":I
    const/16 v18, 0x0

    .line 50
    .local v18, "skip":I
    invoke-virtual {v4}, Lgnu/expr/ApplyExp;->getFunction()Lgnu/expr/Expression;

    move-result-object v7

    .line 51
    .local v7, "func":Lgnu/expr/Expression;
    array-length v0, v5

    move/from16 v22, v0

    if-lez v22, :cond_6

    instance-of v0, v7, Lgnu/expr/ReferenceExp;

    move/from16 v22, v0

    if-eqz v22, :cond_6

    move-object/from16 v22, v7

    check-cast v22, Lgnu/expr/ReferenceExp;

    invoke-virtual/range {v22 .. v22}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v22

    sget-object v23, Lkawa/standard/Scheme;->applyFieldDecl:Lgnu/expr/Declaration;

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    if-ne v0, v1, :cond_6

    .line 54
    const/16 v18, 0x1

    .line 55
    add-int/lit8 v9, v9, -0x1

    .line 56
    const/16 v22, 0x0

    aget-object v7, v5, v22

    .line 58
    :cond_6
    const/16 v22, 0x1

    move/from16 v0, v22

    new-array v0, v0, [Lgnu/expr/Expression;

    move-object/from16 v16, v0

    const/16 v22, 0x0

    aput-object v7, v16, v22

    .line 59
    .local v16, "setterArgs":[Lgnu/expr/Expression;
    add-int/lit8 v22, v9, 0x1

    move/from16 v0, v22

    new-array v0, v0, [Lgnu/expr/Expression;

    move-object/from16 v21, v0

    .line 60
    .local v21, "xargs":[Lgnu/expr/Expression;
    const/16 v22, 0x0

    move/from16 v0, v18

    move-object/from16 v1, v21

    move/from16 v2, v22

    invoke-static {v5, v0, v1, v2, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 61
    aput-object v20, v21, v9

    .line 62
    sget-object v15, Lgnu/kawa/functions/CompilationHelpers;->setterDecl:Lgnu/expr/Declaration;

    .line 63
    .local v15, "setter":Lgnu/expr/Declaration;
    new-instance v17, Lgnu/expr/ApplyExp;

    new-instance v22, Lgnu/expr/ApplyExp;

    new-instance v23, Lgnu/expr/ReferenceExp;

    move-object/from16 v0, v23

    invoke-direct {v0, v15}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    move-object/from16 v2, v16

    invoke-direct {v0, v1, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    move-object/from16 v0, v17

    move-object/from16 v1, v22

    move-object/from16 v2, v21

    invoke-direct {v0, v1, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    goto/16 :goto_1

    .line 66
    .end local v4    # "aexp":Lgnu/expr/ApplyExp;
    .end local v5    # "args":[Lgnu/expr/Expression;
    .end local v7    # "func":Lgnu/expr/Expression;
    .end local v9    # "nargs":I
    .end local v15    # "setter":Lgnu/expr/Declaration;
    .end local v16    # "setterArgs":[Lgnu/expr/Expression;
    .end local v18    # "skip":I
    .end local v21    # "xargs":[Lgnu/expr/Expression;
    :cond_7
    instance-of v0, v8, Lgnu/expr/ReferenceExp;

    move/from16 v22, v0

    if-nez v22, :cond_8

    .line 67
    const-string v22, "first set! argument is not a variable name"

    move-object/from16 v0, p2

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v17

    goto/16 :goto_1

    :cond_8
    move-object v14, v8

    .line 69
    check-cast v14, Lgnu/expr/ReferenceExp;

    .line 70
    .local v14, "ref":Lgnu/expr/ReferenceExp;
    invoke-virtual {v14}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v6

    .line 71
    .local v6, "decl":Lgnu/expr/Declaration;
    new-instance v17, Lgnu/expr/SetExp;

    invoke-virtual {v14}, Lgnu/expr/ReferenceExp;->getSymbol()Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v0, v17

    move-object/from16 v1, v22

    move-object/from16 v2, v20

    invoke-direct {v0, v1, v2}, Lgnu/expr/SetExp;-><init>(Ljava/lang/Object;Lgnu/expr/Expression;)V

    .line 72
    .local v17, "sexp":Lgnu/expr/SetExp;
    invoke-virtual {v14}, Lgnu/expr/ReferenceExp;->contextDecl()Lgnu/expr/Declaration;

    move-result-object v22

    move-object/from16 v0, v17

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lgnu/expr/SetExp;->setContextDecl(Lgnu/expr/Declaration;)V

    .line 73
    if-eqz v6, :cond_1

    .line 75
    const/16 v22, 0x1

    move/from16 v0, v22

    invoke-virtual {v6, v0}, Lgnu/expr/Declaration;->setCanWrite(Z)V

    .line 76
    move-object/from16 v0, v17

    invoke-virtual {v0, v6}, Lgnu/expr/SetExp;->setBinding(Lgnu/expr/Declaration;)V

    .line 77
    invoke-static {v6}, Lgnu/expr/Declaration;->followAliases(Lgnu/expr/Declaration;)Lgnu/expr/Declaration;

    move-result-object v6

    .line 78
    if-eqz v6, :cond_9

    .line 79
    move-object/from16 v0, v20

    invoke-virtual {v6, v0}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 80
    :cond_9
    const-wide/16 v22, 0x4000

    move-wide/from16 v0, v22

    invoke-virtual {v6, v0, v1}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v22

    if-eqz v22, :cond_a

    .line 81
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "constant variable "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual {v6}, Lgnu/expr/Declaration;->getName()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " is set!"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p2

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v17

    goto/16 :goto_1

    .line 82
    :cond_a
    iget-object v0, v6, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    move-object/from16 v22, v0

    move-object/from16 v0, p2

    iget-object v0, v0, Lkawa/lang/Translator;->mainLambda:Lgnu/expr/ModuleExp;

    move-object/from16 v23, v0

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    if-eq v0, v1, :cond_1

    iget-object v0, v6, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/expr/ModuleExp;

    move/from16 v22, v0

    if-eqz v22, :cond_1

    const-wide/32 v22, 0x10000000

    move-wide/from16 v0, v22

    invoke-virtual {v6, v0, v1}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v22

    if-nez v22, :cond_1

    iget-object v0, v6, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    move-object/from16 v22, v0

    const/high16 v23, 0x100000

    invoke-virtual/range {v22 .. v23}, Lgnu/expr/ScopeExp;->getFlag(I)Z

    move-result v22

    if-nez v22, :cond_1

    .line 87
    const/16 v22, 0x77

    const-string v23, "imported variable "

    const-string v24, " is set!"

    move-object/from16 v0, p2

    move/from16 v1, v22

    move-object/from16 v2, v23

    move-object/from16 v3, v24

    invoke-virtual {v0, v1, v6, v2, v3}, Lkawa/lang/Translator;->error(CLgnu/expr/Declaration;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1
.end method
