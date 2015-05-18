.class public Lkawa/standard/define_member_alias;
.super Lkawa/lang/Syntax;
.source "define_member_alias.java"


# static fields
.field public static final define_member_alias:Lkawa/standard/define_member_alias;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 10
    new-instance v0, Lkawa/standard/define_member_alias;

    invoke-direct {v0}, Lkawa/standard/define_member_alias;-><init>()V

    sput-object v0, Lkawa/standard/define_member_alias;->define_member_alias:Lkawa/standard/define_member_alias;

    .line 12
    sget-object v0, Lkawa/standard/define_member_alias;->define_member_alias:Lkawa/standard/define_member_alias;

    const-string v1, "define-member-alias"

    invoke-virtual {v0, v1}, Lkawa/standard/define_member_alias;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    return-void
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 15
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 34
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    .line 36
    .local v6, "obj":Ljava/lang/Object;
    instance-of v13, v6, Lgnu/lists/Pair;

    if-eqz v13, :cond_0

    move-object v7, v6

    check-cast v7, Lgnu/lists/Pair;

    .local v7, "p1":Lgnu/lists/Pair;
    invoke-virtual {v7}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v13

    instance-of v13, v13, Ljava/lang/String;

    if-nez v13, :cond_1

    invoke-virtual {v7}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v13

    instance-of v13, v13, Lgnu/expr/Declaration;

    if-nez v13, :cond_1

    .line 39
    .end local v7    # "p1":Lgnu/lists/Pair;
    :cond_0
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "missing name in "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {p0}, Lkawa/standard/define_member_alias;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v13

    .line 78
    :goto_0
    return-object v13

    .line 40
    .restart local v7    # "p1":Lgnu/lists/Pair;
    :cond_1
    invoke-virtual {v7}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v13

    instance-of v13, v13, Lgnu/lists/Pair;

    if-eqz v13, :cond_5

    .line 44
    invoke-virtual {v7}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v8

    .line 45
    .local v8, "p1_car":Ljava/lang/Object;
    instance-of v13, v8, Lgnu/expr/Declaration;

    if-eqz v13, :cond_3

    move-object v3, v8

    .line 47
    check-cast v3, Lgnu/expr/Declaration;

    .line 48
    .local v3, "decl":Lgnu/expr/Declaration;
    invoke-virtual {v3}, Lgnu/expr/Declaration;->getName()Ljava/lang/String;

    move-result-object v5

    .line 55
    .local v5, "name":Ljava/lang/String;
    :goto_1
    invoke-virtual {v7}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lgnu/lists/Pair;

    .line 56
    .local v9, "p2":Lgnu/lists/Pair;
    const/4 v4, 0x0

    .line 57
    .local v4, "fname":Lgnu/expr/Expression;
    invoke-virtual {v9}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v13

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v1

    .line 58
    .local v1, "arg":Lgnu/expr/Expression;
    invoke-virtual {v9}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v10

    .line 59
    .local v10, "p2_cdr":Ljava/lang/Object;
    sget-object v13, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v10, v13, :cond_4

    .line 60
    new-instance v4, Lgnu/expr/QuoteExp;

    .end local v4    # "fname":Lgnu/expr/Expression;
    invoke-static {v5}, Lgnu/expr/Compilation;->mangleName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    invoke-direct {v4, v13}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    .line 67
    .restart local v4    # "fname":Lgnu/expr/Expression;
    :cond_2
    :goto_2
    if-eqz v4, :cond_5

    .line 69
    const-string v13, "gnu.kawa.reflect.ClassMemberConstraint"

    invoke-static {v13}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v12

    .line 71
    .local v12, "t":Lgnu/bytecode/ClassType;
    const/4 v13, 0x3

    new-array v2, v13, [Lgnu/expr/Expression;

    .line 72
    .local v2, "args":[Lgnu/expr/Expression;
    const/4 v13, 0x0

    new-instance v14, Lgnu/expr/QuoteExp;

    invoke-direct {v14, v5}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v14, v2, v13

    .line 73
    const/4 v13, 0x1

    aput-object v1, v2, v13

    .line 74
    const/4 v13, 0x2

    aput-object v4, v2, v13

    .line 75
    const-string v13, "define"

    invoke-static {v12, v13, v2}, Lgnu/kawa/reflect/Invoke;->makeInvokeStatic(Lgnu/bytecode/ClassType;Ljava/lang/String;[Lgnu/expr/Expression;)Lgnu/expr/ApplyExp;

    move-result-object v13

    goto :goto_0

    .end local v1    # "arg":Lgnu/expr/Expression;
    .end local v2    # "args":[Lgnu/expr/Expression;
    .end local v3    # "decl":Lgnu/expr/Declaration;
    .end local v4    # "fname":Lgnu/expr/Expression;
    .end local v5    # "name":Ljava/lang/String;
    .end local v9    # "p2":Lgnu/lists/Pair;
    .end local v10    # "p2_cdr":Ljava/lang/Object;
    .end local v12    # "t":Lgnu/bytecode/ClassType;
    :cond_3
    move-object v5, v8

    .line 52
    check-cast v5, Ljava/lang/String;

    .line 53
    .restart local v5    # "name":Ljava/lang/String;
    const/4 v3, 0x0

    .restart local v3    # "decl":Lgnu/expr/Declaration;
    goto :goto_1

    .line 61
    .restart local v1    # "arg":Lgnu/expr/Expression;
    .restart local v4    # "fname":Lgnu/expr/Expression;
    .restart local v9    # "p2":Lgnu/lists/Pair;
    .restart local v10    # "p2_cdr":Ljava/lang/Object;
    :cond_4
    instance-of v13, v10, Lgnu/lists/Pair;

    if-eqz v13, :cond_2

    move-object v11, v10

    .line 63
    check-cast v11, Lgnu/lists/Pair;

    .line 64
    .local v11, "p3":Lgnu/lists/Pair;
    invoke-virtual {v11}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v13

    sget-object v14, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v13, v14, :cond_2

    .line 65
    invoke-virtual {v11}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v13

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v4

    goto :goto_2

    .line 78
    .end local v1    # "arg":Lgnu/expr/Expression;
    .end local v3    # "decl":Lgnu/expr/Declaration;
    .end local v4    # "fname":Lgnu/expr/Expression;
    .end local v5    # "name":Ljava/lang/String;
    .end local v8    # "p1_car":Ljava/lang/Object;
    .end local v9    # "p2":Lgnu/lists/Pair;
    .end local v10    # "p2_cdr":Ljava/lang/Object;
    .end local v11    # "p3":Lgnu/lists/Pair;
    :cond_5
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "invalid syntax for "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {p0}, Lkawa/standard/define_member_alias;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p2

    invoke-virtual {v0, v13}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v13

    goto/16 :goto_0
.end method

.method public scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 5
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "forms"    # Ljava/util/Vector;
    .param p3, "defs"    # Lgnu/expr/ScopeExp;
    .param p4, "tr"    # Lkawa/lang/Translator;

    .prologue
    const/4 v3, 0x1

    .line 19
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Lgnu/lists/Pair;

    if-eqz v4, :cond_0

    invoke-virtual {p4}, Lkawa/lang/Translator;->currentScope()Lgnu/expr/ScopeExp;

    move-result-object v4

    instance-of v4, v4, Lgnu/expr/ModuleExp;

    if-nez v4, :cond_0

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lgnu/lists/Pair;

    .local v2, "p":Lgnu/lists/Pair;
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Ljava/lang/String;

    if-nez v4, :cond_1

    .line 22
    .end local v2    # "p":Lgnu/lists/Pair;
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Lkawa/lang/Syntax;->scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z

    move-result v3

    .line 29
    :goto_0
    return v3

    .line 23
    .restart local v2    # "p":Lgnu/lists/Pair;
    :cond_1
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v1

    .line 24
    .local v1, "name":Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;

    .end local v1    # "name":Ljava/lang/Object;
    sget-object v4, Lgnu/expr/Compilation;->typeSymbol:Lgnu/bytecode/ClassType;

    invoke-virtual {p3, v1, v4}, Lgnu/expr/ScopeExp;->addDeclaration(Ljava/lang/Object;Lgnu/bytecode/Type;)Lgnu/expr/Declaration;

    move-result-object v0

    .line 26
    .local v0, "decl":Lgnu/expr/Declaration;
    invoke-virtual {v0, v3}, Lgnu/expr/Declaration;->setIndirectBinding(Z)V

    .line 27
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    invoke-static {v2, v0, v4}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v4

    invoke-static {p1, p0, v4}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object p1

    .line 28
    invoke-virtual {p2, p1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    goto :goto_0
.end method
