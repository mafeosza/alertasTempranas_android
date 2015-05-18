.class public Lgnu/commonlisp/lang/defun;
.super Lkawa/lang/Syntax;
.source "defun.java"


# instance fields
.field lambdaSyntax:Lkawa/lang/Lambda;


# direct methods
.method public constructor <init>(Lkawa/lang/Lambda;)V
    .locals 0
    .param p1, "lambdaSyntax"    # Lkawa/lang/Lambda;

    .prologue
    .line 17
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 18
    iput-object p1, p0, Lgnu/commonlisp/lang/defun;->lambdaSyntax:Lkawa/lang/Lambda;

    .line 19
    return-void
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 15
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 49
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v9

    .line 50
    .local v9, "obj":Ljava/lang/Object;
    const/4 v8, 0x0

    .line 51
    .local v8, "name":Ljava/lang/Object;
    const/4 v14, 0x0

    .line 52
    .local v14, "value":Lgnu/expr/Expression;
    const/4 v7, 0x0

    .line 54
    .local v7, "decl":Lgnu/expr/Declaration;
    instance-of v1, v9, Lgnu/lists/Pair;

    if-eqz v1, :cond_6

    move-object v10, v9

    .line 56
    check-cast v10, Lgnu/lists/Pair;

    .line 57
    .local v10, "p1":Lgnu/lists/Pair;
    invoke-virtual {v10}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v11

    .line 59
    .local v11, "p1_car":Ljava/lang/Object;
    instance-of v1, v11, Lgnu/mapping/Symbol;

    if-nez v1, :cond_0

    instance-of v1, v11, Ljava/lang/String;

    if-eqz v1, :cond_5

    .line 61
    :cond_0
    invoke-virtual {v11}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    .line 68
    .end local v8    # "name":Ljava/lang/Object;
    :cond_1
    :goto_0
    if-eqz v8, :cond_6

    invoke-virtual {v10}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Lgnu/lists/Pair;

    if-eqz v1, :cond_6

    .line 70
    invoke-virtual {v10}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v12

    check-cast v12, Lgnu/lists/Pair;

    .line 71
    .local v12, "p2":Lgnu/lists/Pair;
    new-instance v2, Lgnu/expr/LambdaExp;

    invoke-direct {v2}, Lgnu/expr/LambdaExp;-><init>()V

    .line 72
    .local v2, "lexp":Lgnu/expr/LambdaExp;
    iget-object v1, p0, Lgnu/commonlisp/lang/defun;->lambdaSyntax:Lkawa/lang/Lambda;

    invoke-virtual {v12}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v12}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    const/4 v6, 0x0

    move-object/from16 v5, p2

    invoke-virtual/range {v1 .. v6}, Lkawa/lang/Lambda;->rewrite(Lgnu/expr/LambdaExp;Ljava/lang/Object;Ljava/lang/Object;Lkawa/lang/Translator;Lkawa/lang/TemplateScope;)V

    .line 73
    invoke-virtual {v2, v8}, Lgnu/expr/LambdaExp;->setSymbol(Ljava/lang/Object;)V

    .line 74
    instance-of v1, v12, Lgnu/lists/PairWithPosition;

    if-eqz v1, :cond_2

    .line 75
    check-cast v12, Lgnu/lists/PairWithPosition;

    .end local v12    # "p2":Lgnu/lists/Pair;
    invoke-virtual {v2, v12}, Lgnu/expr/LambdaExp;->setLocation(Lgnu/text/SourceLocator;)V

    .line 76
    :cond_2
    move-object v14, v2

    .line 77
    new-instance v13, Lgnu/expr/SetExp;

    invoke-direct {v13, v8, v14}, Lgnu/expr/SetExp;-><init>(Ljava/lang/Object;Lgnu/expr/Expression;)V

    .line 78
    .local v13, "sexp":Lgnu/expr/SetExp;
    const/4 v1, 0x1

    invoke-virtual {v13, v1}, Lgnu/expr/SetExp;->setDefining(Z)V

    .line 79
    const/4 v1, 0x1

    invoke-virtual {v13, v1}, Lgnu/expr/SetExp;->setFuncDef(Z)V

    .line 80
    if-eqz v7, :cond_4

    .line 82
    invoke-virtual {v13, v7}, Lgnu/expr/SetExp;->setBinding(Lgnu/expr/Declaration;)V

    .line 83
    iget-object v1, v7, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    instance-of v1, v1, Lgnu/expr/ModuleExp;

    if-eqz v1, :cond_3

    invoke-virtual {v7}, Lgnu/expr/Declaration;->getCanWrite()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 84
    const/4 v14, 0x0

    .line 85
    :cond_3
    invoke-virtual {v7, v14}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 90
    .end local v2    # "lexp":Lgnu/expr/LambdaExp;
    .end local v10    # "p1":Lgnu/lists/Pair;
    .end local v11    # "p1_car":Ljava/lang/Object;
    .end local v13    # "sexp":Lgnu/expr/SetExp;
    :cond_4
    :goto_1
    return-object v13

    .line 63
    .restart local v8    # "name":Ljava/lang/Object;
    .restart local v10    # "p1":Lgnu/lists/Pair;
    .restart local v11    # "p1_car":Ljava/lang/Object;
    :cond_5
    instance-of v1, v11, Lgnu/expr/Declaration;

    if-eqz v1, :cond_1

    move-object v7, v11

    .line 65
    check-cast v7, Lgnu/expr/Declaration;

    .line 66
    invoke-virtual {v7}, Lgnu/expr/Declaration;->getSymbol()Ljava/lang/Object;

    move-result-object v8

    goto :goto_0

    .line 90
    .end local v8    # "name":Ljava/lang/Object;
    .end local v10    # "p1":Lgnu/lists/Pair;
    .end local v11    # "p1_car":Ljava/lang/Object;
    :cond_6
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "invalid syntax for "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lgnu/commonlisp/lang/defun;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v13

    goto :goto_1
.end method

.method public scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 7
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "forms"    # Ljava/util/Vector;
    .param p3, "defs"    # Lgnu/expr/ScopeExp;
    .param p4, "tr"    # Lkawa/lang/Translator;

    .prologue
    const/4 v3, 0x1

    .line 25
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Lgnu/lists/Pair;

    if-eqz v4, :cond_0

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lgnu/lists/Pair;

    .local v1, "p":Lgnu/lists/Pair;
    invoke-virtual {v1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Ljava/lang/String;

    if-nez v4, :cond_1

    invoke-virtual {v1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Lgnu/mapping/Symbol;

    if-nez v4, :cond_1

    .line 28
    .end local v1    # "p":Lgnu/lists/Pair;
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Lkawa/lang/Syntax;->scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z

    move-result v3

    .line 44
    :goto_0
    return v3

    .line 29
    .restart local v1    # "p":Lgnu/lists/Pair;
    :cond_1
    invoke-virtual {v1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v2

    .line 30
    .local v2, "sym":Ljava/lang/Object;
    invoke-virtual {p3, v2}, Lgnu/expr/ScopeExp;->lookup(Ljava/lang/Object;)Lgnu/expr/Declaration;

    move-result-object v0

    .line 31
    .local v0, "decl":Lgnu/expr/Declaration;
    if-nez v0, :cond_3

    .line 33
    new-instance v0, Lgnu/expr/Declaration;

    .end local v0    # "decl":Lgnu/expr/Declaration;
    invoke-direct {v0, v2}, Lgnu/expr/Declaration;-><init>(Ljava/lang/Object;)V

    .line 34
    .restart local v0    # "decl":Lgnu/expr/Declaration;
    invoke-virtual {v0, v3}, Lgnu/expr/Declaration;->setProcedureDecl(Z)V

    .line 35
    invoke-virtual {p3, v0}, Lgnu/expr/ScopeExp;->addDeclaration(Lgnu/expr/Declaration;)V

    .line 40
    :goto_1
    instance-of v4, p3, Lgnu/expr/ModuleExp;

    if-eqz v4, :cond_2

    .line 41
    invoke-virtual {v0, v3}, Lgnu/expr/Declaration;->setCanRead(Z)V

    .line 42
    :cond_2
    invoke-virtual {v1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    invoke-static {v1, v0, v4}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v4

    invoke-static {p1, p0, v4}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object p1

    .line 43
    invoke-virtual {p2, p1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    goto :goto_0

    .line 38
    :cond_3
    const/16 v4, 0x77

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "duplicate declaration for `"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p4, v4, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto :goto_1
.end method
