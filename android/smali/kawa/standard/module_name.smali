.class public Lkawa/standard/module_name;
.super Lkawa/lang/Syntax;
.source "module_name.java"


# static fields
.field public static final module_name:Lkawa/standard/module_name;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 9
    new-instance v0, Lkawa/standard/module_name;

    invoke-direct {v0}, Lkawa/standard/module_name;-><init>()V

    sput-object v0, Lkawa/standard/module_name;->module_name:Lkawa/standard/module_name;

    .line 10
    sget-object v0, Lkawa/standard/module_name;->module_name:Lkawa/standard/module_name;

    const-string v1, "module-name"

    invoke-virtual {v0, v1}, Lkawa/standard/module_name;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    return-void
.end method


# virtual methods
.method public scanForm(Lgnu/lists/Pair;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)V
    .locals 17
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "defs"    # Lgnu/expr/ScopeExp;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 14
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    .line 15
    .local v6, "form_cdr":Ljava/lang/Object;
    const/4 v11, 0x0

    .line 16
    .local v11, "nameSyntax":Lkawa/lang/SyntaxForm;
    :goto_0
    instance-of v14, v6, Lkawa/lang/SyntaxForm;

    if-eqz v14, :cond_0

    move-object v11, v6

    .line 18
    check-cast v11, Lkawa/lang/SyntaxForm;

    .line 19
    invoke-interface {v11}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v6

    goto :goto_0

    .line 21
    :cond_0
    instance-of v14, v6, Lgnu/lists/Pair;

    if-eqz v14, :cond_1

    check-cast v6, Lgnu/lists/Pair;

    .end local v6    # "form_cdr":Ljava/lang/Object;
    invoke-virtual {v6}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v2

    .line 22
    .local v2, "arg":Ljava/lang/Object;
    :goto_1
    instance-of v14, v2, Lkawa/lang/SyntaxForm;

    if-eqz v14, :cond_2

    move-object v11, v2

    .line 24
    check-cast v11, Lkawa/lang/SyntaxForm;

    .line 25
    invoke-interface {v11}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v2

    goto :goto_1

    .line 21
    .end local v2    # "arg":Ljava/lang/Object;
    .restart local v6    # "form_cdr":Ljava/lang/Object;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    .line 27
    .end local v6    # "form_cdr":Ljava/lang/Object;
    .restart local v2    # "arg":Ljava/lang/Object;
    :cond_2
    const/4 v10, 0x0

    .line 29
    .local v10, "name":Ljava/lang/String;
    const/4 v5, 0x0

    .line 30
    .local v5, "err":Ljava/lang/String;
    const/4 v4, 0x0

    .line 31
    .local v4, "decl":Lgnu/expr/Declaration;
    instance-of v14, v2, Lgnu/lists/Pair;

    if-eqz v14, :cond_5

    move-object v13, v2

    check-cast v13, Lgnu/lists/Pair;

    .local v13, "p":Lgnu/lists/Pair;
    invoke-virtual {v13}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v14

    const-string v15, "quote"

    if-ne v14, v15, :cond_5

    .line 33
    invoke-virtual {v13}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    .line 34
    instance-of v14, v2, Lgnu/lists/Pair;

    if-eqz v14, :cond_3

    move-object v13, v2

    check-cast v13, Lgnu/lists/Pair;

    invoke-virtual {v13}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v14

    sget-object v15, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v14, v15, :cond_3

    invoke-virtual {v13}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v14

    instance-of v14, v14, Ljava/lang/String;

    if-nez v14, :cond_4

    .line 37
    :cond_3
    const-string v5, "invalid quoted symbol for \'module-name\'"

    .line 57
    .end local v13    # "p":Lgnu/lists/Pair;
    :goto_2
    if-eqz v5, :cond_a

    .line 58
    move-object/from16 v0, p3

    iget-object v14, v0, Lkawa/lang/Translator;->formStack:Ljava/util/Stack;

    move-object/from16 v0, p3

    invoke-virtual {v0, v5}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/util/Stack;->add(Ljava/lang/Object;)Z

    .line 95
    :goto_3
    return-void

    .line 39
    .restart local v13    # "p":Lgnu/lists/Pair;
    :cond_4
    invoke-virtual {v13}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v10

    .end local v10    # "name":Ljava/lang/String;
    check-cast v10, Ljava/lang/String;

    .restart local v10    # "name":Ljava/lang/String;
    goto :goto_2

    .line 41
    .end local v13    # "p":Lgnu/lists/Pair;
    :cond_5
    instance-of v14, v2, Lgnu/lists/FString;

    if-nez v14, :cond_6

    instance-of v14, v2, Ljava/lang/String;

    if-eqz v14, :cond_7

    .line 42
    :cond_6
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v10

    goto :goto_2

    .line 43
    :cond_7
    instance-of v14, v2, Lgnu/mapping/Symbol;

    if-eqz v14, :cond_9

    .line 45
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v10

    .line 46
    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v8

    .line 47
    .local v8, "len":I
    const/4 v14, 0x2

    if-le v8, v14, :cond_8

    const/4 v14, 0x0

    invoke-virtual {v10, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    const/16 v15, 0x3c

    if-ne v14, v15, :cond_8

    add-int/lit8 v14, v8, -0x1

    invoke-virtual {v10, v14}, Ljava/lang/String;->charAt(I)C

    move-result v14

    const/16 v15, 0x3e

    if-ne v14, v15, :cond_8

    .line 51
    const/4 v14, 0x1

    add-int/lit8 v15, v8, -0x1

    invoke-virtual {v10, v14, v15}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    .line 53
    :cond_8
    move-object/from16 v0, p3

    move-object/from16 v1, p2

    invoke-virtual {v0, v2, v11, v1}, Lkawa/lang/Translator;->define(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Lgnu/expr/ScopeExp;)Lgnu/expr/Declaration;

    move-result-object v4

    .line 54
    goto :goto_2

    .line 56
    .end local v8    # "len":I
    :cond_9
    const-string v5, "un-implemented expression in module-name"

    goto :goto_2

    .line 61
    :cond_a
    const/16 v14, 0x2e

    invoke-virtual {v10, v14}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v7

    .line 62
    .local v7, "index":I
    move-object v3, v10

    .line 63
    .local v3, "className":Ljava/lang/String;
    if-ltz v7, :cond_e

    .line 64
    const/4 v14, 0x0

    add-int/lit8 v15, v7, 0x1

    invoke-virtual {v10, v14, v15}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p3

    iput-object v14, v0, Lkawa/lang/Translator;->classPrefix:Ljava/lang/String;

    .line 70
    :goto_4
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getModule()Lgnu/expr/ModuleExp;

    move-result-object v9

    .line 71
    .local v9, "module":Lgnu/expr/ModuleExp;
    move-object/from16 v0, p3

    iget-object v14, v0, Lkawa/lang/Translator;->mainClass:Lgnu/bytecode/ClassType;

    if-nez v14, :cond_f

    .line 72
    new-instance v14, Lgnu/bytecode/ClassType;

    invoke-direct {v14, v3}, Lgnu/bytecode/ClassType;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p3

    iput-object v14, v0, Lkawa/lang/Translator;->mainClass:Lgnu/bytecode/ClassType;

    .line 81
    :cond_b
    :goto_5
    move-object/from16 v0, p3

    iget-object v14, v0, Lkawa/lang/Translator;->mainClass:Lgnu/bytecode/ClassType;

    invoke-virtual {v9, v14}, Lgnu/expr/ModuleExp;->setType(Lgnu/bytecode/ClassType;)V

    .line 82
    invoke-virtual {v9, v10}, Lgnu/expr/ModuleExp;->setName(Ljava/lang/String;)V

    .line 84
    if-eqz v4, :cond_d

    .line 86
    new-instance v14, Lgnu/expr/QuoteExp;

    move-object/from16 v0, p3

    iget-object v15, v0, Lkawa/lang/Translator;->mainClass:Lgnu/bytecode/ClassType;

    sget-object v16, Lgnu/expr/Compilation;->typeClass:Lgnu/bytecode/ClassType;

    invoke-direct/range {v14 .. v16}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;Lgnu/bytecode/Type;)V

    invoke-virtual {v4, v14}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 87
    const-wide/32 v14, 0x1004000

    invoke-virtual {v4, v14, v15}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 88
    iget-object v14, v9, Lgnu/expr/ModuleExp;->outer:Lgnu/expr/ScopeExp;

    if-nez v14, :cond_c

    .line 89
    const-wide/16 v14, 0x800

    invoke-virtual {v4, v14, v15}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 90
    :cond_c
    const/4 v14, 0x1

    invoke-virtual {v4, v14}, Lgnu/expr/Declaration;->setPrivate(Z)V

    .line 91
    sget-object v14, Lgnu/expr/Compilation;->typeClass:Lgnu/bytecode/ClassType;

    invoke-virtual {v4, v14}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 93
    :cond_d
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->mustCompileHere()V

    goto/16 :goto_3

    .line 67
    .end local v9    # "module":Lgnu/expr/ModuleExp;
    :cond_e
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p3

    iget-object v15, v0, Lkawa/lang/Translator;->classPrefix:Ljava/lang/String;

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 68
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p3

    iget-object v15, v0, Lkawa/lang/Translator;->classPrefix:Ljava/lang/String;

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-static {v10}, Lgnu/expr/Compilation;->mangleName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_4

    .line 75
    .restart local v9    # "module":Lgnu/expr/ModuleExp;
    :cond_f
    move-object/from16 v0, p3

    iget-object v14, v0, Lkawa/lang/Translator;->mainClass:Lgnu/bytecode/ClassType;

    invoke-virtual {v14}, Lgnu/bytecode/ClassType;->getName()Ljava/lang/String;

    move-result-object v12

    .line 76
    .local v12, "oldName":Ljava/lang/String;
    if-nez v12, :cond_10

    .line 77
    move-object/from16 v0, p3

    iget-object v14, v0, Lkawa/lang/Translator;->mainClass:Lgnu/bytecode/ClassType;

    invoke-virtual {v14, v3}, Lgnu/bytecode/ClassType;->setName(Ljava/lang/String;)V

    goto :goto_5

    .line 78
    :cond_10
    invoke-virtual {v12, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-nez v14, :cond_b

    .line 79
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "duplicate module-name: old name: "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_5
.end method
