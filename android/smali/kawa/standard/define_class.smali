.class public Lkawa/standard/define_class;
.super Lkawa/lang/Syntax;
.source "define_class.java"


# static fields
.field public static final define_class:Lkawa/standard/define_class;

.field public static final define_simple_class:Lkawa/standard/define_class;


# instance fields
.field isSimple:Z

.field objectSyntax:Lkawa/standard/object;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 9
    new-instance v0, Lkawa/standard/define_class;

    const-string v1, "define-class"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lkawa/standard/define_class;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lkawa/standard/define_class;->define_class:Lkawa/standard/define_class;

    .line 11
    new-instance v0, Lkawa/standard/define_class;

    const-string v1, "define-simple-class"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lkawa/standard/define_class;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lkawa/standard/define_class;->define_simple_class:Lkawa/standard/define_class;

    return-void
.end method

.method constructor <init>(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "isSimple"    # Z

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lkawa/lang/Syntax;-><init>(Ljava/lang/Object;)V

    .line 26
    sget-object v0, Lkawa/standard/object;->objectSyntax:Lkawa/standard/object;

    iput-object v0, p0, Lkawa/standard/define_class;->objectSyntax:Lkawa/standard/object;

    .line 27
    iput-boolean p2, p0, Lkawa/standard/define_class;->isSimple:Z

    .line 28
    return-void
.end method

.method constructor <init>(Lkawa/standard/object;Z)V
    .locals 0
    .param p1, "objectSyntax"    # Lkawa/standard/object;
    .param p2, "isSimple"    # Z

    .prologue
    .line 18
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 19
    iput-object p1, p0, Lkawa/standard/define_class;->objectSyntax:Lkawa/standard/object;

    .line 20
    iput-boolean p2, p0, Lkawa/standard/define_class;->isSimple:Z

    .line 21
    return-void
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 7
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 99
    const/4 v0, 0x0

    .line 100
    .local v0, "decl":Lgnu/expr/Declaration;
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    .line 101
    .local v2, "form_cdr":Ljava/lang/Object;
    instance-of v5, v2, Lgnu/lists/Pair;

    if-eqz v5, :cond_1

    move-object p1, v2

    .line 103
    check-cast p1, Lgnu/lists/Pair;

    .line 104
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v1

    .line 105
    .local v1, "form_car":Ljava/lang/Object;
    instance-of v5, v1, Lgnu/expr/Declaration;

    if-nez v5, :cond_0

    .line 106
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lkawa/standard/define_class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " can only be used in <body>"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2, v5}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v4

    .line 113
    .end local v1    # "form_car":Ljava/lang/Object;
    :goto_0
    return-object v4

    .restart local v1    # "form_car":Ljava/lang/Object;
    :cond_0
    move-object v0, v1

    .line 107
    check-cast v0, Lgnu/expr/Declaration;

    .line 109
    .end local v1    # "form_car":Ljava/lang/Object;
    :cond_1
    invoke-virtual {v0}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object v3

    check-cast v3, Lgnu/expr/ClassExp;

    .line 110
    .local v3, "oexp":Lgnu/expr/ClassExp;
    iget-object v6, p0, Lkawa/standard/define_class;->objectSyntax:Lkawa/standard/object;

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Ljava/lang/Object;

    check-cast v5, [Ljava/lang/Object;

    invoke-virtual {v6, v5, p2}, Lkawa/standard/object;->rewriteClassDef([Ljava/lang/Object;Lkawa/lang/Translator;)V

    .line 111
    new-instance v4, Lgnu/expr/SetExp;

    invoke-direct {v4, v0, v3}, Lgnu/expr/SetExp;-><init>(Lgnu/expr/Declaration;Lgnu/expr/Expression;)V

    .line 112
    .local v4, "sexp":Lgnu/expr/SetExp;
    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lgnu/expr/SetExp;->setDefining(Z)V

    goto :goto_0
.end method

.method public scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 15
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "forms"    # Ljava/util/Vector;
    .param p3, "defs"    # Lgnu/expr/ScopeExp;
    .param p4, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 33
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v12

    .line 34
    .local v12, "st_cdr":Ljava/lang/Object;
    const/4 v6, 0x0

    .line 35
    .local v6, "nameSyntax":Lkawa/lang/SyntaxForm;
    :goto_0
    instance-of v13, v12, Lkawa/lang/SyntaxForm;

    if-eqz v13, :cond_0

    move-object v6, v12

    .line 37
    check-cast v6, Lkawa/lang/SyntaxForm;

    .line 38
    invoke-interface {v6}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v12

    goto :goto_0

    .line 40
    :cond_0
    instance-of v13, v12, Lgnu/lists/Pair;

    if-nez v13, :cond_1

    .line 41
    invoke-super/range {p0 .. p4}, Lkawa/lang/Syntax;->scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z

    move-result v13

    .line 93
    :goto_1
    return v13

    :cond_1
    move-object v9, v12

    .line 42
    check-cast v9, Lgnu/lists/Pair;

    .line 43
    .local v9, "p":Lgnu/lists/Pair;
    invoke-virtual {v9}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    .line 44
    .local v5, "name":Ljava/lang/Object;
    :goto_2
    instance-of v13, v5, Lkawa/lang/SyntaxForm;

    if-eqz v13, :cond_2

    move-object v6, v5

    .line 46
    check-cast v6, Lkawa/lang/SyntaxForm;

    .line 47
    invoke-interface {v6}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v5

    goto :goto_2

    .line 49
    :cond_2
    move-object/from16 v0, p4

    invoke-virtual {v0, v5}, Lkawa/lang/Translator;->namespaceResolve(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 50
    instance-of v13, v5, Ljava/lang/String;

    if-nez v13, :cond_3

    instance-of v13, v5, Lgnu/mapping/Symbol;

    if-nez v13, :cond_3

    .line 52
    const/16 v13, 0x65

    const-string v14, "missing class name"

    move-object/from16 v0, p4

    invoke-virtual {v0, v13, v14}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 53
    const/4 v13, 0x0

    goto :goto_1

    .line 55
    :cond_3
    move-object/from16 v0, p4

    move-object/from16 v1, p3

    invoke-virtual {v0, v5, v6, v1}, Lkawa/lang/Translator;->define(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Lgnu/expr/ScopeExp;)Lgnu/expr/Declaration;

    move-result-object v3

    .line 56
    .local v3, "decl":Lgnu/expr/Declaration;
    instance-of v13, v9, Lgnu/lists/PairWithPosition;

    if-eqz v13, :cond_4

    move-object v13, v9

    .line 57
    check-cast v13, Lgnu/lists/PairWithPosition;

    invoke-virtual {v3, v13}, Lgnu/expr/Declaration;->setLocation(Lgnu/text/SourceLocator;)V

    .line 58
    :cond_4
    new-instance v8, Lgnu/expr/ClassExp;

    iget-boolean v13, p0, Lkawa/standard/define_class;->isSimple:Z

    invoke-direct {v8, v13}, Lgnu/expr/ClassExp;-><init>(Z)V

    .line 59
    .local v8, "oexp":Lgnu/expr/ClassExp;
    invoke-virtual {v3, v8}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 60
    const-wide/32 v13, 0x20004000

    invoke-virtual {v3, v13, v14}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 61
    iget-boolean v13, p0, Lkawa/standard/define_class;->isSimple:Z

    if-eqz v13, :cond_6

    sget-object v13, Lgnu/expr/Compilation;->typeClass:Lgnu/bytecode/ClassType;

    :goto_3
    invoke-virtual {v3, v13}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 62
    invoke-virtual/range {p4 .. p4}, Lkawa/lang/Translator;->mustCompileHere()V

    .line 64
    instance-of v13, v5, Lgnu/mapping/Symbol;

    if-eqz v13, :cond_7

    check-cast v5, Lgnu/mapping/Symbol;

    .end local v5    # "name":Ljava/lang/Object;
    invoke-virtual {v5}, Lgnu/mapping/Symbol;->getName()Ljava/lang/String;

    move-result-object v2

    .line 66
    .local v2, "cname":Ljava/lang/String;
    :goto_4
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v7

    .line 67
    .local v7, "nlen":I
    const/4 v13, 0x2

    if-le v7, v13, :cond_5

    const/4 v13, 0x0

    invoke-virtual {v2, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    const/16 v14, 0x3c

    if-ne v13, v14, :cond_5

    add-int/lit8 v13, v7, -0x1

    invoke-virtual {v2, v13}, Ljava/lang/String;->charAt(I)C

    move-result v13

    const/16 v14, 0x3e

    if-ne v13, v14, :cond_5

    .line 68
    const/4 v13, 0x1

    add-int/lit8 v14, v7, -0x1

    invoke-virtual {v2, v13, v14}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 69
    :cond_5
    invoke-virtual {v8, v2}, Lgnu/expr/ClassExp;->setName(Ljava/lang/String;)V

    .line 71
    invoke-virtual {v9}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    .line 72
    .local v4, "members":Ljava/lang/Object;
    :goto_5
    instance-of v13, v4, Lkawa/lang/SyntaxForm;

    if-eqz v13, :cond_8

    move-object v6, v4

    .line 74
    check-cast v6, Lkawa/lang/SyntaxForm;

    .line 75
    invoke-interface {v6}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v4

    goto :goto_5

    .line 61
    .end local v2    # "cname":Ljava/lang/String;
    .end local v4    # "members":Ljava/lang/Object;
    .end local v7    # "nlen":I
    .restart local v5    # "name":Ljava/lang/Object;
    :cond_6
    sget-object v13, Lgnu/expr/Compilation;->typeClassType:Lgnu/bytecode/ClassType;

    goto :goto_3

    .line 64
    :cond_7
    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_4

    .line 77
    .end local v5    # "name":Ljava/lang/Object;
    .restart local v2    # "cname":Ljava/lang/String;
    .restart local v4    # "members":Ljava/lang/Object;
    .restart local v7    # "nlen":I
    :cond_8
    instance-of v13, v4, Lgnu/lists/Pair;

    if-nez v13, :cond_9

    .line 79
    const/16 v13, 0x65

    const-string v14, "missing class members"

    move-object/from16 v0, p4

    invoke-virtual {v0, v13, v14}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 80
    const/4 v13, 0x0

    goto/16 :goto_1

    :cond_9
    move-object v9, v4

    .line 82
    check-cast v9, Lgnu/lists/Pair;

    .line 83
    invoke-virtual/range {p4 .. p4}, Lkawa/lang/Translator;->currentScope()Lgnu/expr/ScopeExp;

    move-result-object v10

    .line 84
    .local v10, "save_scope":Lgnu/expr/ScopeExp;
    if-eqz v6, :cond_a

    .line 85
    invoke-interface {v6}, Lkawa/lang/SyntaxForm;->getScope()Lkawa/lang/TemplateScope;

    move-result-object v13

    move-object/from16 v0, p4

    invoke-virtual {v0, v13}, Lkawa/lang/Translator;->setCurrentScope(Lgnu/expr/ScopeExp;)V

    .line 86
    :cond_a
    iget-object v13, p0, Lkawa/standard/define_class;->objectSyntax:Lkawa/standard/object;

    move-object/from16 v0, p4

    invoke-virtual {v13, v9, v8, v0}, Lkawa/standard/object;->scanClassDef(Lgnu/lists/Pair;Lgnu/expr/ClassExp;Lkawa/lang/Translator;)[Ljava/lang/Object;

    move-result-object v11

    .line 87
    .local v11, "saved":[Ljava/lang/Object;
    if-eqz v6, :cond_b

    .line 88
    move-object/from16 v0, p4

    invoke-virtual {v0, v10}, Lkawa/lang/Translator;->setCurrentScope(Lgnu/expr/ScopeExp;)V

    .line 89
    :cond_b
    if-nez v11, :cond_c

    .line 90
    const/4 v13, 0x0

    goto/16 :goto_1

    .line 91
    :cond_c
    invoke-static {v9, v3, v11}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v13

    move-object/from16 v0, p1

    invoke-static {v0, p0, v13}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object p1

    .line 92
    move-object/from16 v0, p2

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 93
    const/4 v13, 0x1

    goto/16 :goto_1
.end method
