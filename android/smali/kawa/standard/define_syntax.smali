.class public Lkawa/standard/define_syntax;
.super Lkawa/lang/Syntax;
.source "define_syntax.java"


# static fields
.field public static final define_macro:Lkawa/standard/define_syntax;

.field public static final define_syntax:Lkawa/standard/define_syntax;

.field static makeHygienic:Lgnu/expr/PrimProcedure;

.field static makeNonHygienic:Lgnu/expr/PrimProcedure;

.field static setCapturedScope:Lgnu/expr/PrimProcedure;

.field static typeMacro:Lgnu/bytecode/ClassType;


# instance fields
.field hygienic:Z


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x3

    const/4 v3, 0x1

    .line 13
    new-instance v0, Lkawa/standard/define_syntax;

    const-string v1, "%define-macro"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lkawa/standard/define_syntax;-><init>(Ljava/lang/Object;Z)V

    sput-object v0, Lkawa/standard/define_syntax;->define_macro:Lkawa/standard/define_syntax;

    .line 16
    new-instance v0, Lkawa/standard/define_syntax;

    const-string v1, "%define-syntax"

    invoke-direct {v0, v1, v3}, Lkawa/standard/define_syntax;-><init>(Ljava/lang/Object;Z)V

    sput-object v0, Lkawa/standard/define_syntax;->define_syntax:Lkawa/standard/define_syntax;

    .line 30
    const-string v0, "kawa.lang.Macro"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    sput-object v0, Lkawa/standard/define_syntax;->typeMacro:Lgnu/bytecode/ClassType;

    .line 31
    new-instance v0, Lgnu/expr/PrimProcedure;

    sget-object v1, Lkawa/standard/define_syntax;->typeMacro:Lgnu/bytecode/ClassType;

    const-string v2, "make"

    invoke-virtual {v1, v2, v4}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v1

    invoke-direct {v0, v1}, Lgnu/expr/PrimProcedure;-><init>(Lgnu/bytecode/Method;)V

    sput-object v0, Lkawa/standard/define_syntax;->makeHygienic:Lgnu/expr/PrimProcedure;

    .line 33
    new-instance v0, Lgnu/expr/PrimProcedure;

    sget-object v1, Lkawa/standard/define_syntax;->typeMacro:Lgnu/bytecode/ClassType;

    const-string v2, "makeNonHygienic"

    invoke-virtual {v1, v2, v4}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v1

    invoke-direct {v0, v1}, Lgnu/expr/PrimProcedure;-><init>(Lgnu/bytecode/Method;)V

    sput-object v0, Lkawa/standard/define_syntax;->makeNonHygienic:Lgnu/expr/PrimProcedure;

    .line 35
    new-instance v0, Lgnu/expr/PrimProcedure;

    sget-object v1, Lkawa/standard/define_syntax;->typeMacro:Lgnu/bytecode/ClassType;

    const-string v2, "setCapturedScope"

    invoke-virtual {v1, v2, v3}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v1

    invoke-direct {v0, v1}, Lgnu/expr/PrimProcedure;-><init>(Lgnu/bytecode/Method;)V

    sput-object v0, Lkawa/standard/define_syntax;->setCapturedScope:Lgnu/expr/PrimProcedure;

    .line 38
    sget-object v0, Lkawa/standard/define_syntax;->makeHygienic:Lgnu/expr/PrimProcedure;

    invoke-virtual {v0}, Lgnu/expr/PrimProcedure;->setSideEffectFree()V

    .line 39
    sget-object v0, Lkawa/standard/define_syntax;->makeNonHygienic:Lgnu/expr/PrimProcedure;

    invoke-virtual {v0}, Lgnu/expr/PrimProcedure;->setSideEffectFree()V

    .line 40
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 21
    const/4 v0, 0x1

    iput-boolean v0, p0, Lkawa/standard/define_syntax;->hygienic:Z

    .line 22
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;Z)V
    .locals 0
    .param p1, "name"    # Ljava/lang/Object;
    .param p2, "hygienic"    # Z

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lkawa/lang/Syntax;-><init>(Ljava/lang/Object;)V

    .line 27
    iput-boolean p2, p0, Lkawa/standard/define_syntax;->hygienic:Z

    .line 28
    return-void
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 46
    const-string v0, "define-syntax not in a body"

    invoke-virtual {p2, v0}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method public scanForm(Lgnu/lists/Pair;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)V
    .locals 17
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "defs"    # Lgnu/expr/ScopeExp;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 51
    const/4 v13, 0x0

    .line 52
    .local v13, "syntax":Lkawa/lang/SyntaxForm;
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v12

    .line 53
    .local v12, "st_cdr":Ljava/lang/Object;
    :goto_0
    instance-of v14, v12, Lkawa/lang/SyntaxForm;

    if-eqz v14, :cond_0

    move-object v13, v12

    .line 55
    check-cast v13, Lkawa/lang/SyntaxForm;

    .line 56
    invoke-interface {v13}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v12

    goto :goto_0

    .line 58
    :cond_0
    move-object v7, v12

    .line 60
    .local v7, "p":Ljava/lang/Object;
    instance-of v14, v7, Lgnu/lists/Pair;

    if-eqz v14, :cond_1

    move-object v8, v7

    .line 62
    check-cast v8, Lgnu/lists/Pair;

    .line 63
    .local v8, "pp":Lgnu/lists/Pair;
    invoke-virtual {v8}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    .line 64
    .local v5, "name":Ljava/lang/Object;
    invoke-virtual {v8}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v7

    .line 68
    .end local v5    # "name":Ljava/lang/Object;
    .end local v8    # "pp":Lgnu/lists/Pair;
    :goto_1
    move-object v6, v13

    .local v6, "nameSyntax":Lkawa/lang/SyntaxForm;
    move-object v14, v5

    .line 69
    :goto_2
    instance-of v15, v14, Lkawa/lang/SyntaxForm;

    if-eqz v15, :cond_2

    move-object v6, v14

    .line 71
    check-cast v6, Lkawa/lang/SyntaxForm;

    .line 72
    invoke-interface {v6}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v5

    .restart local v5    # "name":Ljava/lang/Object;
    move-object v14, v5

    goto :goto_2

    .line 67
    .end local v5    # "name":Ljava/lang/Object;
    .end local v6    # "nameSyntax":Lkawa/lang/SyntaxForm;
    :cond_1
    const/4 v5, 0x0

    .restart local v5    # "name":Ljava/lang/Object;
    goto :goto_1

    .line 74
    .end local v5    # "name":Ljava/lang/Object;
    .restart local v6    # "nameSyntax":Lkawa/lang/SyntaxForm;
    :cond_2
    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Lkawa/lang/Translator;->namespaceResolve(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 75
    .restart local v5    # "name":Ljava/lang/Object;
    instance-of v14, v5, Lgnu/mapping/Symbol;

    if-nez v14, :cond_4

    .line 77
    move-object/from16 v0, p3

    iget-object v14, v0, Lkawa/lang/Translator;->formStack:Ljava/util/Stack;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "missing macro name for "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-static/range {p1 .. p1}, Lkawa/lang/Translator;->safeCar(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p3

    invoke-virtual {v0, v15}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/util/Stack;->addElement(Ljava/lang/Object;)V

    .line 126
    .end local v7    # "p":Ljava/lang/Object;
    :cond_3
    :goto_3
    return-void

    .line 80
    .restart local v7    # "p":Ljava/lang/Object;
    :cond_4
    if-eqz v7, :cond_5

    invoke-static {v7}, Lkawa/lang/Translator;->safeCdr(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    sget-object v15, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v14, v15, :cond_6

    .line 82
    :cond_5
    move-object/from16 v0, p3

    iget-object v14, v0, Lkawa/lang/Translator;->formStack:Ljava/util/Stack;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "invalid syntax for "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual/range {p0 .. p0}, Lkawa/standard/define_syntax;->getName()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    move-object/from16 v0, p3

    invoke-virtual {v0, v15}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v15

    invoke-virtual {v14, v15}, Ljava/util/Stack;->addElement(Ljava/lang/Object;)V

    goto :goto_3

    .line 86
    :cond_6
    move-object/from16 v0, p3

    move-object/from16 v1, p2

    invoke-virtual {v0, v5, v6, v1}, Lkawa/lang/Translator;->define(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Lgnu/expr/ScopeExp;)Lgnu/expr/Declaration;

    move-result-object v3

    .line 87
    .local v3, "decl":Lgnu/expr/Declaration;
    sget-object v14, Lkawa/standard/define_syntax;->typeMacro:Lgnu/bytecode/ClassType;

    invoke-virtual {v3, v14}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 88
    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Lkawa/lang/Translator;->push(Lgnu/expr/Declaration;)V

    .line 90
    move-object/from16 v0, p3

    iget-object v11, v0, Lkawa/lang/Translator;->currentMacroDefinition:Lkawa/lang/Macro;

    .line 91
    .local v11, "savedMacro":Lkawa/lang/Macro;
    invoke-static {v3}, Lkawa/lang/Macro;->make(Lgnu/expr/Declaration;)Lkawa/lang/Macro;

    move-result-object v4

    .line 92
    .local v4, "macro":Lkawa/lang/Macro;
    move-object/from16 v0, p0

    iget-boolean v14, v0, Lkawa/standard/define_syntax;->hygienic:Z

    invoke-virtual {v4, v14}, Lkawa/lang/Macro;->setHygienic(Z)V

    .line 93
    move-object/from16 v0, p3

    iput-object v4, v0, Lkawa/lang/Translator;->currentMacroDefinition:Lkawa/lang/Macro;

    .line 94
    check-cast v7, Lgnu/lists/Pair;

    .end local v7    # "p":Ljava/lang/Object;
    move-object/from16 v0, p3

    invoke-virtual {v0, v7, v13}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v10

    .line 95
    .local v10, "rule":Lgnu/expr/Expression;
    move-object/from16 v0, p3

    iput-object v11, v0, Lkawa/lang/Translator;->currentMacroDefinition:Lkawa/lang/Macro;

    .line 96
    iput-object v10, v4, Lkawa/lang/Macro;->expander:Ljava/lang/Object;

    .line 98
    instance-of v14, v10, Lgnu/expr/LambdaExp;

    if-eqz v14, :cond_7

    move-object v14, v10

    .line 99
    check-cast v14, Lgnu/expr/LambdaExp;

    const/16 v15, 0x100

    invoke-virtual {v14, v15}, Lgnu/expr/LambdaExp;->setFlag(I)V

    .line 100
    :cond_7
    const/4 v14, 0x3

    new-array v2, v14, [Lgnu/expr/Expression;

    .line 101
    .local v2, "args":[Lgnu/expr/Expression;
    const/4 v14, 0x0

    new-instance v15, Lgnu/expr/QuoteExp;

    invoke-direct {v15, v5}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v15, v2, v14

    .line 102
    const/4 v14, 0x1

    aput-object v10, v2, v14

    .line 103
    const/4 v14, 0x2

    invoke-static/range {p2 .. p2}, Lgnu/expr/ThisExp;->makeGivingContext(Lgnu/expr/ScopeExp;)Lgnu/expr/ThisExp;

    move-result-object v15

    aput-object v15, v2, v14

    .line 104
    new-instance v10, Lgnu/expr/ApplyExp;

    .end local v10    # "rule":Lgnu/expr/Expression;
    move-object/from16 v0, p0

    iget-boolean v14, v0, Lkawa/standard/define_syntax;->hygienic:Z

    if-eqz v14, :cond_9

    sget-object v14, Lkawa/standard/define_syntax;->makeHygienic:Lgnu/expr/PrimProcedure;

    :goto_4
    invoke-direct {v10, v14, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .line 106
    .restart local v10    # "rule":Lgnu/expr/Expression;
    invoke-virtual {v3, v10}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 107
    const/4 v14, 0x1

    invoke-virtual {v3, v14}, Lgnu/expr/Declaration;->setProcedureDecl(Z)V

    .line 109
    iget-object v14, v3, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    instance-of v14, v14, Lgnu/expr/ModuleExp;

    if-eqz v14, :cond_3

    .line 111
    new-instance v9, Lgnu/expr/SetExp;

    invoke-direct {v9, v3, v10}, Lgnu/expr/SetExp;-><init>(Lgnu/expr/Declaration;Lgnu/expr/Expression;)V

    .line 112
    .local v9, "result":Lgnu/expr/SetExp;
    const/4 v14, 0x1

    invoke-virtual {v9, v14}, Lgnu/expr/SetExp;->setDefining(Z)V

    .line 113
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getLanguage()Lgnu/expr/Language;

    move-result-object v14

    invoke-virtual {v14}, Lgnu/expr/Language;->hasSeparateFunctionNamespace()Z

    move-result v14

    if-eqz v14, :cond_8

    .line 114
    const/4 v14, 0x1

    invoke-virtual {v9, v14}, Lgnu/expr/SetExp;->setFuncDef(Z)V

    .line 116
    :cond_8
    move-object/from16 v0, p3

    iget-object v14, v0, Lkawa/lang/Translator;->formStack:Ljava/util/Stack;

    invoke-virtual {v14, v9}, Ljava/util/Stack;->addElement(Ljava/lang/Object;)V

    .line 118
    move-object/from16 v0, p3

    iget-boolean v14, v0, Lkawa/lang/Translator;->immediate:Z

    if-eqz v14, :cond_3

    .line 120
    const/4 v14, 0x2

    new-array v2, v14, [Lgnu/expr/Expression;

    .line 121
    const/4 v14, 0x0

    new-instance v15, Lgnu/expr/ReferenceExp;

    invoke-direct {v15, v3}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v15, v2, v14

    .line 122
    const/4 v14, 0x1

    new-instance v15, Lgnu/expr/QuoteExp;

    move-object/from16 v0, p2

    invoke-direct {v15, v0}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v15, v2, v14

    .line 123
    move-object/from16 v0, p3

    iget-object v14, v0, Lkawa/lang/Translator;->formStack:Ljava/util/Stack;

    new-instance v15, Lgnu/expr/ApplyExp;

    sget-object v16, Lkawa/standard/define_syntax;->setCapturedScope:Lgnu/expr/PrimProcedure;

    move-object/from16 v0, v16

    invoke-direct {v15, v0, v2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    invoke-virtual {v14, v15}, Ljava/util/Stack;->addElement(Ljava/lang/Object;)V

    goto/16 :goto_3

    .line 104
    .end local v9    # "result":Lgnu/expr/SetExp;
    .end local v10    # "rule":Lgnu/expr/Expression;
    :cond_9
    sget-object v14, Lkawa/standard/define_syntax;->makeNonHygienic:Lgnu/expr/PrimProcedure;

    goto :goto_4
.end method
