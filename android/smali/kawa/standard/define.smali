.class public Lkawa/standard/define;
.super Lkawa/lang/Syntax;
.source "define.java"


# static fields
.field public static final defineRaw:Lkawa/standard/define;


# instance fields
.field lambda:Lkawa/lang/Lambda;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 23
    new-instance v0, Lkawa/standard/define;

    sget-object v1, Lkawa/standard/SchemeCompilation;->lambda:Lkawa/lang/Lambda;

    invoke-direct {v0, v1}, Lkawa/standard/define;-><init>(Lkawa/lang/Lambda;)V

    sput-object v0, Lkawa/standard/define;->defineRaw:Lkawa/standard/define;

    return-void
.end method

.method public constructor <init>(Lkawa/lang/Lambda;)V
    .locals 0
    .param p1, "lambda"    # Lkawa/lang/Lambda;

    .prologue
    .line 38
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 39
    iput-object p1, p0, Lkawa/standard/define;->lambda:Lkawa/lang/Lambda;

    .line 40
    return-void
.end method


# virtual methods
.method getName(I)Ljava/lang/String;
    .locals 1
    .param p1, "options"    # I

    .prologue
    .line 29
    and-int/lit8 v0, p1, 0x4

    if-eqz v0, :cond_0

    .line 30
    const-string v0, "define-private"

    .line 34
    :goto_0
    return-object v0

    .line 31
    :cond_0
    and-int/lit8 v0, p1, 0x8

    if-eqz v0, :cond_1

    .line 32
    const-string v0, "define-constant"

    goto :goto_0

    .line 34
    :cond_1
    const-string v0, "define"

    goto :goto_0
.end method

.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 20
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 119
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lgnu/lists/Pair;

    .line 120
    .local v9, "p1":Lgnu/lists/Pair;
    invoke-virtual {v9}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lgnu/lists/Pair;

    .line 121
    .local v10, "p2":Lgnu/lists/Pair;
    invoke-virtual {v10}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Lgnu/lists/Pair;

    .line 122
    .local v11, "p3":Lgnu/lists/Pair;
    invoke-virtual {v11}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lgnu/lists/Pair;

    .line 123
    .local v12, "p4":Lgnu/lists/Pair;
    invoke-virtual {v9}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lkawa/lang/Translator;->stripSyntax(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .line 124
    .local v7, "name":Ljava/lang/Object;
    invoke-virtual {v10}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Lkawa/lang/Translator;->stripSyntax(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Ljava/lang/Number;

    invoke-virtual/range {v17 .. v17}, Ljava/lang/Number;->intValue()I

    move-result v8

    .line 125
    .local v8, "options":I
    and-int/lit8 v17, v8, 0x4

    if-eqz v17, :cond_1

    const/4 v6, 0x1

    .line 127
    .local v6, "makePrivate":Z
    :goto_0
    instance-of v0, v7, Lgnu/expr/Declaration;

    move/from16 v17, v0

    if-nez v17, :cond_2

    .line 128
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    invoke-virtual {v0, v8}, Lkawa/standard/define;->getName(I)Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, " is only allowed in a <body>"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v13

    .line 163
    :cond_0
    :goto_1
    return-object v13

    .line 125
    .end local v6    # "makePrivate":Z
    :cond_1
    const/4 v6, 0x0

    goto :goto_0

    .restart local v6    # "makePrivate":Z
    :cond_2
    move-object v4, v7

    .line 129
    check-cast v4, Lgnu/expr/Declaration;

    .line 131
    .local v4, "decl":Lgnu/expr/Declaration;
    const-wide/16 v17, 0x2000

    move-wide/from16 v0, v17

    invoke-virtual {v4, v0, v1}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v17

    if-eqz v17, :cond_3

    .line 133
    invoke-virtual {v4}, Lgnu/expr/Declaration;->getTypeExp()Lgnu/expr/Expression;

    move-result-object v14

    .line 134
    .local v14, "texp":Lgnu/expr/Expression;
    instance-of v0, v14, Lgnu/expr/LangExp;

    move/from16 v17, v0

    if-eqz v17, :cond_3

    .line 136
    check-cast v14, Lgnu/expr/LangExp;

    .end local v14    # "texp":Lgnu/expr/Expression;
    invoke-virtual {v14}, Lgnu/expr/LangExp;->getLangValue()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lgnu/lists/Pair;

    .line 137
    .local v15, "typeSpecPair":Lgnu/lists/Pair;
    move-object/from16 v0, p2

    invoke-virtual {v0, v15}, Lkawa/lang/Translator;->exp2Type(Lgnu/lists/Pair;)Lgnu/bytecode/Type;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 142
    .end local v15    # "typeSpecPair":Lgnu/lists/Pair;
    :cond_3
    and-int/lit8 v17, v8, 0x2

    if-eqz v17, :cond_5

    .line 144
    invoke-virtual {v4}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v5

    check-cast v5, Lgnu/expr/LambdaExp;

    .line 145
    .local v5, "lexp":Lgnu/expr/LambdaExp;
    invoke-virtual {v12}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    .line 146
    .local v3, "body":Ljava/lang/Object;
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/standard/define;->lambda:Lkawa/lang/Lambda;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    move-object/from16 v1, p2

    invoke-virtual {v0, v5, v3, v1}, Lkawa/lang/Lambda;->rewriteBody(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;)V

    .line 147
    move-object/from16 v16, v5

    .line 148
    .local v16, "value":Lgnu/expr/Expression;
    sget-boolean v17, Lgnu/expr/Compilation;->inlineOk:Z

    if-nez v17, :cond_4

    .line 149
    const/16 v17, 0x0

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 158
    .end local v3    # "body":Ljava/lang/Object;
    .end local v5    # "lexp":Lgnu/expr/LambdaExp;
    :cond_4
    :goto_2
    new-instance v13, Lgnu/expr/SetExp;

    move-object/from16 v0, v16

    invoke-direct {v13, v4, v0}, Lgnu/expr/SetExp;-><init>(Lgnu/expr/Declaration;Lgnu/expr/Expression;)V

    .line 159
    .local v13, "sexp":Lgnu/expr/SetExp;
    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-virtual {v13, v0}, Lgnu/expr/SetExp;->setDefining(Z)V

    .line 160
    if-eqz v6, :cond_0

    invoke-virtual/range {p2 .. p2}, Lkawa/lang/Translator;->currentScope()Lgnu/expr/ScopeExp;

    move-result-object v17

    move-object/from16 v0, v17

    instance-of v0, v0, Lgnu/expr/ModuleExp;

    move/from16 v17, v0

    if-nez v17, :cond_0

    .line 161
    const/16 v17, 0x77

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "define-private not at top level "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {p2 .. p2}, Lkawa/lang/Translator;->currentScope()Lgnu/expr/ScopeExp;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p2

    move/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto/16 :goto_1

    .line 153
    .end local v13    # "sexp":Lgnu/expr/SetExp;
    .end local v16    # "value":Lgnu/expr/Expression;
    :cond_5
    invoke-virtual {v12}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v17

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v16

    .line 154
    .restart local v16    # "value":Lgnu/expr/Expression;
    iget-object v0, v4, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    instance-of v0, v0, Lgnu/expr/ModuleExp;

    move/from16 v17, v0

    if-eqz v17, :cond_6

    if-nez v6, :cond_6

    invoke-virtual {v4}, Lgnu/expr/Declaration;->getCanWrite()Z

    move-result v17

    if-eqz v17, :cond_6

    const/16 v17, 0x0

    :goto_3
    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    goto :goto_2

    :cond_6
    move-object/from16 v17, v16

    goto :goto_3
.end method

.method public scanForm(Lgnu/lists/Pair;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)V
    .locals 24
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "defs"    # Lgnu/expr/ScopeExp;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 44
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lgnu/lists/Pair;

    .line 45
    .local v12, "p1":Lgnu/lists/Pair;
    invoke-virtual {v12}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lgnu/lists/Pair;

    .line 46
    .local v13, "p2":Lgnu/lists/Pair;
    invoke-virtual {v13}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lgnu/lists/Pair;

    .line 47
    .local v15, "p3":Lgnu/lists/Pair;
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lgnu/lists/Pair;

    .line 48
    .local v16, "p4":Lgnu/lists/Pair;
    const/4 v10, 0x0

    .line 49
    .local v10, "nameSyntax":Lkawa/lang/SyntaxForm;
    invoke-virtual {v12}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v9

    .line 50
    .local v9, "name":Ljava/lang/Object;
    :goto_0
    instance-of v0, v9, Lkawa/lang/SyntaxForm;

    move/from16 v20, v0

    if-eqz v20, :cond_0

    move-object v10, v9

    .line 52
    check-cast v10, Lkawa/lang/SyntaxForm;

    .line 53
    invoke-interface {v10}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v9

    goto :goto_0

    .line 55
    :cond_0
    invoke-virtual {v13}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v20

    invoke-static/range {v20 .. v20}, Lkawa/lang/Translator;->stripSyntax(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/lang/Number;

    invoke-virtual/range {v20 .. v20}, Ljava/lang/Number;->intValue()I

    move-result v11

    .line 56
    .local v11, "options":I
    and-int/lit8 v20, v11, 0x4

    if-eqz v20, :cond_a

    const/4 v8, 0x1

    .line 57
    .local v8, "makePrivate":Z
    :goto_1
    and-int/lit8 v20, v11, 0x8

    if-eqz v20, :cond_b

    const/4 v7, 0x1

    .line 59
    .local v7, "makeConstant":Z
    :goto_2
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->currentScope()Lgnu/expr/ScopeExp;

    move-result-object v19

    .line 60
    .local v19, "scope":Lgnu/expr/ScopeExp;
    move-object/from16 v0, p3

    invoke-virtual {v0, v9}, Lkawa/lang/Translator;->namespaceResolve(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    .line 61
    instance-of v0, v9, Lgnu/mapping/Symbol;

    move/from16 v20, v0

    if-nez v20, :cond_1

    .line 63
    const/16 v20, 0x65

    new-instance v21, Ljava/lang/StringBuilder;

    invoke-direct/range {v21 .. v21}, Ljava/lang/StringBuilder;-><init>()V

    const-string v22, "\'"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v21

    const-string v22, "\' is not a valid identifier"

    invoke-virtual/range {v21 .. v22}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, p3

    move/from16 v1, v20

    move-object/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 64
    const/4 v9, 0x0

    .line 67
    .end local v9    # "name":Ljava/lang/Object;
    :cond_1
    move-object/from16 v0, p3

    invoke-virtual {v0, v12}, Lkawa/lang/Translator;->pushPositionOf(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    .line 68
    .local v18, "savePos":Ljava/lang/Object;
    move-object/from16 v0, p3

    move-object/from16 v1, p2

    invoke-virtual {v0, v9, v10, v1}, Lkawa/lang/Translator;->define(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Lgnu/expr/ScopeExp;)Lgnu/expr/Declaration;

    move-result-object v4

    .line 69
    .local v4, "decl":Lgnu/expr/Declaration;
    move-object/from16 v0, p3

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    .line 70
    invoke-virtual {v4}, Lgnu/expr/Declaration;->getSymbol()Ljava/lang/Object;

    move-result-object v9

    .line 71
    .restart local v9    # "name":Ljava/lang/Object;
    if-eqz v8, :cond_2

    .line 73
    const-wide/32 v20, 0x1000000

    move-wide/from16 v0, v20

    invoke-virtual {v4, v0, v1}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 74
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setPrivate(Z)V

    .line 76
    :cond_2
    if-eqz v7, :cond_3

    .line 77
    const-wide/16 v20, 0x4000

    move-wide/from16 v0, v20

    invoke-virtual {v4, v0, v1}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 78
    :cond_3
    const-wide/32 v20, 0x40000

    move-wide/from16 v0, v20

    invoke-virtual {v4, v0, v1}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 80
    and-int/lit8 v20, v11, 0x2

    if-eqz v20, :cond_6

    .line 82
    new-instance v6, Lgnu/expr/LambdaExp;

    invoke-direct {v6}, Lgnu/expr/LambdaExp;-><init>()V

    .line 83
    .local v6, "lexp":Lgnu/expr/LambdaExp;
    invoke-virtual {v6, v9}, Lgnu/expr/LambdaExp;->setSymbol(Ljava/lang/Object;)V

    .line 84
    sget-boolean v20, Lgnu/expr/Compilation;->inlineOk:Z

    if-eqz v20, :cond_4

    .line 86
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setProcedureDecl(Z)V

    .line 87
    sget-object v20, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 88
    iput-object v4, v6, Lgnu/expr/LambdaExp;->nameDecl:Lgnu/expr/Declaration;

    .line 90
    :cond_4
    invoke-virtual/range {v16 .. v16}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    .line 91
    .local v5, "formals":Ljava/lang/Object;
    invoke-virtual/range {v16 .. v16}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    .line 92
    .local v3, "body":Ljava/lang/Object;
    invoke-static {v6, v12}, Lkawa/lang/Translator;->setLine(Lgnu/expr/Expression;Ljava/lang/Object;)V

    .line 93
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/standard/define;->lambda:Lkawa/lang/Lambda;

    move-object/from16 v20, v0

    const/16 v21, 0x0

    move-object/from16 v0, v20

    move-object/from16 v1, p3

    move-object/from16 v2, v21

    invoke-virtual {v0, v6, v5, v1, v2}, Lkawa/lang/Lambda;->rewriteFormals(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;Lkawa/lang/TemplateScope;)V

    .line 94
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/standard/define;->lambda:Lkawa/lang/Lambda;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move-object/from16 v1, p3

    invoke-virtual {v0, v6, v3, v1}, Lkawa/lang/Lambda;->rewriteAttrs(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v17

    .line 95
    .local v17, "realBody":Ljava/lang/Object;
    move-object/from16 v0, v17

    if-eq v0, v3, :cond_5

    .line 96
    new-instance v14, Lgnu/lists/Pair;

    invoke-virtual {v13}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v20

    new-instance v21, Lgnu/lists/Pair;

    invoke-virtual {v15}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v22

    new-instance v23, Lgnu/lists/Pair;

    move-object/from16 v0, v23

    move-object/from16 v1, v17

    invoke-direct {v0, v5, v1}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-direct/range {v21 .. v23}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    invoke-direct {v14, v0, v1}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .end local v13    # "p2":Lgnu/lists/Pair;
    .local v14, "p2":Lgnu/lists/Pair;
    move-object v13, v14

    .line 97
    .end local v14    # "p2":Lgnu/lists/Pair;
    .restart local v13    # "p2":Lgnu/lists/Pair;
    :cond_5
    invoke-virtual {v4, v6}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 100
    .end local v3    # "body":Ljava/lang/Object;
    .end local v5    # "formals":Ljava/lang/Object;
    .end local v6    # "lexp":Lgnu/expr/LambdaExp;
    .end local v17    # "realBody":Ljava/lang/Object;
    :cond_6
    move-object/from16 v0, p2

    instance-of v0, v0, Lgnu/expr/ModuleExp;

    move/from16 v20, v0

    if-eqz v20, :cond_8

    if-nez v8, :cond_8

    sget-boolean v20, Lgnu/expr/Compilation;->inlineOk:Z

    if-eqz v20, :cond_7

    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->sharedModuleDefs()Z

    move-result v20

    if-eqz v20, :cond_8

    .line 102
    :cond_7
    const/16 v20, 0x1

    move/from16 v0, v20

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setCanWrite(Z)V

    .line 104
    :cond_8
    and-int/lit8 v20, v11, 0x1

    if-eqz v20, :cond_9

    .line 106
    new-instance v20, Lgnu/expr/LangExp;

    move-object/from16 v0, v20

    invoke-direct {v0, v15}, Lgnu/expr/LangExp;-><init>(Ljava/lang/Object;)V

    move-object/from16 v0, v20

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setTypeExp(Lgnu/expr/Expression;)V

    .line 107
    const-wide/16 v20, 0x2000

    move-wide/from16 v0, v20

    invoke-virtual {v4, v0, v1}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 110
    :cond_9
    invoke-static {v12, v4, v13}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v20

    move-object/from16 v0, p1

    move-object/from16 v1, p0

    move-object/from16 v2, v20

    invoke-static {v0, v1, v2}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object p1

    .line 112
    invoke-static {v4, v12}, Lkawa/lang/Translator;->setLine(Lgnu/expr/Declaration;Ljava/lang/Object;)V

    .line 114
    move-object/from16 v0, p3

    iget-object v0, v0, Lkawa/lang/Translator;->formStack:Ljava/util/Stack;

    move-object/from16 v20, v0

    move-object/from16 v0, v20

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/Stack;->addElement(Ljava/lang/Object;)V

    .line 115
    return-void

    .line 56
    .end local v4    # "decl":Lgnu/expr/Declaration;
    .end local v7    # "makeConstant":Z
    .end local v8    # "makePrivate":Z
    .end local v18    # "savePos":Ljava/lang/Object;
    .end local v19    # "scope":Lgnu/expr/ScopeExp;
    :cond_a
    const/4 v8, 0x0

    goto/16 :goto_1

    .line 57
    .restart local v8    # "makePrivate":Z
    :cond_b
    const/4 v7, 0x0

    goto/16 :goto_2
.end method
