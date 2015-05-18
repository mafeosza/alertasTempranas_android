.class public Lkawa/standard/define_alias;
.super Lkawa/lang/Syntax;
.source "define_alias.java"


# static fields
.field public static final define_alias:Lkawa/standard/define_alias;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 10
    new-instance v0, Lkawa/standard/define_alias;

    invoke-direct {v0}, Lkawa/standard/define_alias;-><init>()V

    sput-object v0, Lkawa/standard/define_alias;->define_alias:Lkawa/standard/define_alias;

    .line 11
    sget-object v0, Lkawa/standard/define_alias;->define_alias:Lkawa/standard/define_alias;

    const-string v1, "define-alias"

    invoke-virtual {v0, v1}, Lkawa/standard/define_alias;->setName(Ljava/lang/String;)V

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
.method public rewrite(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 88
    const-string v0, "define-alias is only allowed in a <body>"

    invoke-virtual {p2, v0}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method public scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 15
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "forms"    # Ljava/util/Vector;
    .param p3, "defs"    # Lgnu/expr/ScopeExp;
    .param p4, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 16
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    .line 17
    .local v6, "formCdr":Ljava/lang/Object;
    const/4 v7, 0x0

    .line 18
    .local v7, "formSyntax":Lkawa/lang/SyntaxForm;
    :goto_0
    instance-of v13, v6, Lkawa/lang/SyntaxForm;

    if-eqz v13, :cond_0

    move-object v7, v6

    .line 20
    check-cast v7, Lkawa/lang/SyntaxForm;

    .line 21
    invoke-interface {v7}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v6

    goto :goto_0

    .line 23
    :cond_0
    instance-of v13, v6, Lgnu/lists/Pair;

    if-eqz v13, :cond_8

    move-object v10, v6

    .line 25
    check-cast v10, Lgnu/lists/Pair;

    .line 26
    .local v10, "p":Lgnu/lists/Pair;
    move-object v9, v7

    .line 27
    .local v9, "nameSyntax":Lkawa/lang/SyntaxForm;
    invoke-virtual {v10}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v8

    .line 28
    .local v8, "name":Ljava/lang/Object;
    :goto_1
    instance-of v13, v8, Lkawa/lang/SyntaxForm;

    if-eqz v13, :cond_1

    move-object v9, v8

    .line 30
    check-cast v9, Lkawa/lang/SyntaxForm;

    .line 31
    invoke-interface {v9}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v8

    goto :goto_1

    .line 33
    :cond_1
    invoke-virtual {v10}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    .line 34
    :goto_2
    instance-of v13, v6, Lkawa/lang/SyntaxForm;

    if-eqz v13, :cond_2

    move-object v7, v6

    .line 36
    check-cast v7, Lkawa/lang/SyntaxForm;

    .line 37
    invoke-interface {v7}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v6

    goto :goto_2

    .line 39
    :cond_2
    instance-of v13, v8, Ljava/lang/String;

    if-nez v13, :cond_3

    instance-of v13, v8, Lgnu/mapping/Symbol;

    if-eqz v13, :cond_8

    :cond_3
    instance-of v13, v6, Lgnu/lists/Pair;

    if-eqz v13, :cond_8

    move-object v10, v6

    check-cast v10, Lgnu/lists/Pair;

    invoke-virtual {v10}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v13

    sget-object v14, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v13, v14, :cond_8

    .line 43
    move-object/from16 v0, p4

    move-object/from16 v1, p3

    invoke-virtual {v0, v8, v9, v1}, Lkawa/lang/Translator;->define(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Lgnu/expr/ScopeExp;)Lgnu/expr/Declaration;

    move-result-object v4

    .line 44
    .local v4, "decl":Lgnu/expr/Declaration;
    const/4 v13, 0x1

    invoke-virtual {v4, v13}, Lgnu/expr/Declaration;->setIndirectBinding(Z)V

    .line 45
    const/4 v13, 0x1

    invoke-virtual {v4, v13}, Lgnu/expr/Declaration;->setAlias(Z)V

    .line 46
    move-object/from16 v0, p4

    invoke-virtual {v0, v10, v7}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v2

    .line 47
    .local v2, "arg":Lgnu/expr/Expression;
    instance-of v13, v2, Lgnu/expr/ReferenceExp;

    if-eqz v13, :cond_6

    move-object v11, v2

    .line 49
    check-cast v11, Lgnu/expr/ReferenceExp;

    .line 50
    .local v11, "rarg":Lgnu/expr/ReferenceExp;
    invoke-virtual {v11}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v13

    invoke-static {v13}, Lgnu/expr/Declaration;->followAliases(Lgnu/expr/Declaration;)Lgnu/expr/Declaration;

    move-result-object v3

    .line 52
    .local v3, "d":Lgnu/expr/Declaration;
    if-eqz v3, :cond_5

    invoke-virtual {v3}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v5

    .local v5, "dval":Lgnu/expr/Expression;
    instance-of v13, v5, Lgnu/expr/ClassExp;

    if-nez v13, :cond_4

    instance-of v13, v5, Lgnu/expr/ModuleExp;

    if-eqz v13, :cond_5

    .line 56
    :cond_4
    const/4 v13, 0x0

    invoke-virtual {v4, v13}, Lgnu/expr/Declaration;->setIndirectBinding(Z)V

    .line 57
    const-wide/16 v13, 0x4000

    invoke-virtual {v4, v13, v14}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 72
    .end local v3    # "d":Lgnu/expr/Declaration;
    .end local v5    # "dval":Lgnu/expr/Expression;
    .end local v11    # "rarg":Lgnu/expr/ReferenceExp;
    :goto_3
    invoke-virtual/range {p4 .. p4}, Lkawa/lang/Translator;->mustCompileHere()V

    .line 73
    move-object/from16 v0, p4

    invoke-virtual {v0, v4}, Lkawa/lang/Translator;->push(Lgnu/expr/Declaration;)V

    .line 74
    new-instance v12, Lgnu/expr/SetExp;

    invoke-direct {v12, v4, v2}, Lgnu/expr/SetExp;-><init>(Lgnu/expr/Declaration;Lgnu/expr/Expression;)V

    .line 75
    .local v12, "sexp":Lgnu/expr/SetExp;
    move-object/from16 v0, p4

    invoke-virtual {v0, v12}, Lkawa/lang/Translator;->setLineOf(Lgnu/expr/Expression;)V

    .line 76
    invoke-virtual {v4, v2}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 77
    const/4 v13, 0x1

    invoke-virtual {v12, v13}, Lgnu/expr/SetExp;->setDefining(Z)V

    .line 78
    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 79
    const/4 v13, 0x1

    .line 83
    .end local v2    # "arg":Lgnu/expr/Expression;
    .end local v4    # "decl":Lgnu/expr/Declaration;
    .end local v8    # "name":Ljava/lang/Object;
    .end local v9    # "nameSyntax":Lkawa/lang/SyntaxForm;
    .end local v10    # "p":Lgnu/lists/Pair;
    .end local v12    # "sexp":Lgnu/expr/SetExp;
    :goto_4
    return v13

    .line 60
    .restart local v2    # "arg":Lgnu/expr/Expression;
    .restart local v3    # "d":Lgnu/expr/Declaration;
    .restart local v4    # "decl":Lgnu/expr/Declaration;
    .restart local v8    # "name":Ljava/lang/Object;
    .restart local v9    # "nameSyntax":Lkawa/lang/SyntaxForm;
    .restart local v10    # "p":Lgnu/lists/Pair;
    .restart local v11    # "rarg":Lgnu/expr/ReferenceExp;
    :cond_5
    const/4 v13, 0x1

    invoke-virtual {v11, v13}, Lgnu/expr/ReferenceExp;->setDontDereference(Z)V

    goto :goto_3

    .line 62
    .end local v3    # "d":Lgnu/expr/Declaration;
    .end local v11    # "rarg":Lgnu/expr/ReferenceExp;
    :cond_6
    instance-of v13, v2, Lgnu/expr/QuoteExp;

    if-eqz v13, :cond_7

    .line 64
    const/4 v13, 0x0

    invoke-virtual {v4, v13}, Lgnu/expr/Declaration;->setIndirectBinding(Z)V

    .line 65
    const-wide/16 v13, 0x4000

    invoke-virtual {v4, v13, v14}, Lgnu/expr/Declaration;->setFlag(J)V

    goto :goto_3

    .line 69
    :cond_7
    move-object/from16 v0, p4

    invoke-static {v2, v0}, Lkawa/standard/location;->rewrite(Lgnu/expr/Expression;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v2

    .line 70
    const-string v13, "gnu.mapping.Location"

    invoke-static {v13}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v13

    invoke-virtual {v4, v13}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    goto :goto_3

    .line 82
    .end local v2    # "arg":Lgnu/expr/Expression;
    .end local v4    # "decl":Lgnu/expr/Declaration;
    .end local v8    # "name":Ljava/lang/Object;
    .end local v9    # "nameSyntax":Lkawa/lang/SyntaxForm;
    .end local v10    # "p":Lgnu/lists/Pair;
    :cond_8
    const/16 v13, 0x65

    const-string v14, "invalid syntax for define-alias"

    move-object/from16 v0, p4

    invoke-virtual {v0, v13, v14}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 83
    const/4 v13, 0x0

    goto :goto_4
.end method
