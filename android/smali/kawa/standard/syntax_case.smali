.class public Lkawa/standard/syntax_case;
.super Lkawa/lang/Syntax;
.source "syntax_case.java"


# static fields
.field public static final syntax_case:Lkawa/standard/syntax_case;


# instance fields
.field call_error:Lgnu/expr/PrimProcedure;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 10
    new-instance v0, Lkawa/standard/syntax_case;

    invoke-direct {v0}, Lkawa/standard/syntax_case;-><init>()V

    sput-object v0, Lkawa/standard/syntax_case;->syntax_case:Lkawa/standard/syntax_case;

    .line 11
    sget-object v0, Lkawa/standard/syntax_case;->syntax_case:Lkawa/standard/syntax_case;

    const-string v1, "syntax-case"

    invoke-virtual {v0, v1}, Lkawa/standard/syntax_case;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    return-void
.end method

.method public static error(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6
    .param p0, "kind"    # Ljava/lang/String;
    .param p1, "arg"    # Ljava/lang/Object;

    .prologue
    .line 166
    invoke-static {}, Lgnu/expr/Compilation;->getCurrent()Lgnu/expr/Compilation;

    move-result-object v3

    check-cast v3, Lkawa/lang/Translator;

    .line 167
    .local v3, "tr":Lkawa/lang/Translator;
    if-nez v3, :cond_0

    .line 168
    new-instance v4, Ljava/lang/RuntimeException;

    const-string v5, "no match in syntax-case"

    invoke-direct {v4, v5}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 169
    :cond_0
    invoke-virtual {v3}, Lkawa/lang/Translator;->getCurrentSyntax()Lkawa/lang/Syntax;

    move-result-object v2

    .line 170
    .local v2, "syntax":Lkawa/lang/Syntax;
    if-nez v2, :cond_1

    const-string v1, "some syntax"

    .line 171
    .local v1, "name":Ljava/lang/String;
    :goto_0
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "no matching case while expanding "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 172
    .local v0, "msg":Ljava/lang/String;
    invoke-virtual {v3, v0}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v4

    return-object v4

    .line 170
    .end local v0    # "msg":Ljava/lang/String;
    .end local v1    # "name":Ljava/lang/String;
    :cond_1
    invoke-virtual {v2}, Lkawa/lang/Syntax;->getName()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method


# virtual methods
.method rewriteClauses(Ljava/lang/Object;Lkawa/standard/syntax_case_work;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 28
    .param p1, "clauses"    # Ljava/lang/Object;
    .param p2, "work"    # Lkawa/standard/syntax_case_work;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 18
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getLanguage()Lgnu/expr/Language;

    move-result-object v13

    .line 19
    .local v13, "language":Lgnu/expr/Language;
    sget-object v25, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, p1

    move-object/from16 v1, v25

    if-ne v0, v1, :cond_1

    .line 27
    const/16 v25, 0x2

    move/from16 v0, v25

    new-array v4, v0, [Lgnu/expr/Expression;

    .line 28
    .local v4, "args":[Lgnu/expr/Expression;
    const/16 v25, 0x0

    new-instance v26, Lgnu/expr/QuoteExp;

    const-string v27, "syntax-case"

    invoke-direct/range {v26 .. v27}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v26, v4, v25

    .line 29
    const/16 v25, 0x1

    new-instance v26, Lgnu/expr/ReferenceExp;

    move-object/from16 v0, p2

    iget-object v0, v0, Lkawa/standard/syntax_case_work;->inputExpression:Lgnu/expr/Declaration;

    move-object/from16 v27, v0

    invoke-direct/range {v26 .. v27}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v26, v4, v25

    .line 30
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/standard/syntax_case;->call_error:Lgnu/expr/PrimProcedure;

    move-object/from16 v25, v0

    if-nez v25, :cond_0

    .line 32
    const-string v25, "kawa.standard.syntax_case"

    invoke-static/range {v25 .. v25}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v7

    .line 33
    .local v7, "clas":Lgnu/bytecode/ClassType;
    const/16 v25, 0x2

    move/from16 v0, v25

    new-array v5, v0, [Lgnu/bytecode/Type;

    .line 34
    .local v5, "argtypes":[Lgnu/bytecode/Type;
    const/16 v25, 0x0

    sget-object v26, Lgnu/expr/Compilation;->javaStringType:Lgnu/bytecode/ClassType;

    aput-object v26, v5, v25

    .line 35
    const/16 v25, 0x1

    sget-object v26, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    aput-object v26, v5, v25

    .line 36
    const-string v25, "error"

    sget-object v26, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    const/16 v27, 0x9

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    move/from16 v2, v27

    invoke-virtual {v7, v0, v5, v1, v2}, Lgnu/bytecode/ClassType;->addMethod(Ljava/lang/String;[Lgnu/bytecode/Type;Lgnu/bytecode/Type;I)Lgnu/bytecode/Method;

    move-result-object v14

    .line 39
    .local v14, "method":Lgnu/bytecode/Method;
    new-instance v25, Lgnu/expr/PrimProcedure;

    move-object/from16 v0, v25

    invoke-direct {v0, v14, v13}, Lgnu/expr/PrimProcedure;-><init>(Lgnu/bytecode/Method;Lgnu/expr/Language;)V

    move-object/from16 v0, v25

    move-object/from16 v1, p0

    iput-object v0, v1, Lkawa/standard/syntax_case;->call_error:Lgnu/expr/PrimProcedure;

    .line 41
    .end local v5    # "argtypes":[Lgnu/bytecode/Type;
    .end local v7    # "clas":Lgnu/bytecode/ClassType;
    .end local v14    # "method":Lgnu/bytecode/Method;
    :cond_0
    new-instance v6, Lgnu/expr/ApplyExp;

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/standard/syntax_case;->call_error:Lgnu/expr/PrimProcedure;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    invoke-direct {v6, v0, v4}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .line 111
    .end local v4    # "args":[Lgnu/expr/Expression;
    .end local p1    # "clauses":Ljava/lang/Object;
    :goto_0
    return-object v6

    .line 43
    .restart local p1    # "clauses":Ljava/lang/Object;
    :cond_1
    move-object/from16 v0, p3

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->pushPositionOf(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v20

    .line 47
    .local v20, "savePos":Ljava/lang/Object;
    :try_start_0
    move-object/from16 v0, p1

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v25, v0

    if-eqz v25, :cond_2

    move-object/from16 v0, p1

    check-cast v0, Lgnu/lists/Pair;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v8

    .local v8, "clause":Ljava/lang/Object;
    instance-of v0, v8, Lgnu/lists/Pair;

    move/from16 v25, v0

    if-nez v25, :cond_3

    .line 49
    .end local v8    # "clause":Ljava/lang/Object;
    :cond_2
    const-string v25, "syntax-case:  bad clause list"

    move-object/from16 v0, p3

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v6

    .line 111
    move-object/from16 v0, p3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    goto :goto_0

    .line 50
    .restart local v8    # "clause":Ljava/lang/Object;
    :cond_3
    :try_start_1
    move-object v0, v8

    check-cast v0, Lgnu/lists/Pair;

    move-object/from16 v18, v0

    .line 51
    .local v18, "pair":Lgnu/lists/Pair;
    invoke-static/range {p3 .. p3}, Lkawa/lang/PatternScope;->push(Lkawa/lang/Translator;)Lkawa/lang/PatternScope;

    move-result-object v9

    .line 52
    .local v9, "clauseScope":Lkawa/lang/PatternScope;
    move-object/from16 v0, p3

    iget-object v0, v0, Lkawa/lang/Translator;->matchArray:Lgnu/expr/Declaration;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    iput-object v0, v9, Lkawa/lang/PatternScope;->matchArray:Lgnu/expr/Declaration;

    .line 53
    move-object/from16 v0, p3

    invoke-virtual {v0, v9}, Lkawa/lang/Translator;->push(Lgnu/expr/ScopeExp;)V

    .line 55
    const/16 v21, 0x0

    .line 56
    .local v21, "syntax":Lkawa/lang/SyntaxForm;
    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    .line 57
    .local v22, "tail":Ljava/lang/Object;
    :goto_1
    move-object/from16 v0, v22

    instance-of v0, v0, Lkawa/lang/SyntaxForm;

    move/from16 v25, v0

    if-eqz v25, :cond_4

    .line 59
    move-object/from16 v0, v22

    check-cast v0, Lkawa/lang/SyntaxForm;

    move-object/from16 v21, v0

    .line 60
    invoke-interface/range {v21 .. v21}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v22

    goto :goto_1

    .line 63
    :cond_4
    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v25, v0

    if-nez v25, :cond_5

    .line 64
    const-string v25, "missing syntax-case output expression"

    move-object/from16 v0, p3

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v6

    .line 111
    move-object/from16 v0, p3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    goto :goto_0

    .line 66
    :cond_5
    :try_start_2
    iget-object v0, v9, Lkawa/lang/PatternScope;->pattern_names:Ljava/util/Vector;

    move-object/from16 v25, v0

    invoke-virtual/range {v25 .. v25}, Ljava/util/Vector;->size()I

    move-result v16

    .line 67
    .local v16, "outerVarCount":I
    new-instance v19, Lkawa/lang/SyntaxPattern;

    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v25

    move-object/from16 v0, p2

    iget-object v0, v0, Lkawa/standard/syntax_case_work;->literal_identifiers:[Ljava/lang/Object;

    move-object/from16 v26, v0

    move-object/from16 v0, v19

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    move-object/from16 v3, p3

    invoke-direct {v0, v1, v2, v3}, Lkawa/lang/SyntaxPattern;-><init>(Ljava/lang/Object;[Ljava/lang/Object;Lkawa/lang/Translator;)V

    .line 69
    .local v19, "pattern":Lkawa/lang/SyntaxPattern;
    invoke-virtual/range {v19 .. v19}, Lkawa/lang/SyntaxPattern;->varCount()I

    move-result v24

    .line 70
    .local v24, "varCount":I
    move-object/from16 v0, p2

    iget v0, v0, Lkawa/standard/syntax_case_work;->maxVars:I

    move/from16 v25, v0

    move/from16 v0, v24

    move/from16 v1, v25

    if-le v0, v1, :cond_6

    .line 71
    move/from16 v0, v24

    move-object/from16 v1, p2

    iput v0, v1, Lkawa/standard/syntax_case_work;->maxVars:I

    .line 73
    :cond_6
    new-instance v6, Lgnu/expr/BlockExp;

    invoke-direct {v6}, Lgnu/expr/BlockExp;-><init>()V

    .line 74
    .local v6, "block":Lgnu/expr/BlockExp;
    const/16 v25, 0x4

    move/from16 v0, v25

    new-array v4, v0, [Lgnu/expr/Expression;

    .line 75
    .restart local v4    # "args":[Lgnu/expr/Expression;
    const/16 v25, 0x0

    new-instance v26, Lgnu/expr/QuoteExp;

    move-object/from16 v0, v26

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v26, v4, v25

    .line 76
    const/16 v25, 0x1

    new-instance v26, Lgnu/expr/ReferenceExp;

    move-object/from16 v0, p2

    iget-object v0, v0, Lkawa/standard/syntax_case_work;->inputExpression:Lgnu/expr/Declaration;

    move-object/from16 v27, v0

    invoke-direct/range {v26 .. v27}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v26, v4, v25

    .line 77
    const/16 v25, 0x2

    new-instance v26, Lgnu/expr/ReferenceExp;

    move-object/from16 v0, p3

    iget-object v0, v0, Lkawa/lang/Translator;->matchArray:Lgnu/expr/Declaration;

    move-object/from16 v27, v0

    invoke-direct/range {v26 .. v27}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v26, v4, v25

    .line 78
    const/16 v25, 0x3

    new-instance v26, Lgnu/expr/QuoteExp;

    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v27

    invoke-direct/range {v26 .. v27}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v26, v4, v25

    .line 79
    new-instance v23, Lgnu/expr/ApplyExp;

    new-instance v25, Lgnu/expr/PrimProcedure;

    sget-object v26, Lkawa/lang/Pattern;->matchPatternMethod:Lgnu/bytecode/Method;

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-direct {v0, v1, v13}, Lgnu/expr/PrimProcedure;-><init>(Lgnu/bytecode/Method;Lgnu/expr/Language;)V

    move-object/from16 v0, v23

    move-object/from16 v1, v25

    invoke-direct {v0, v1, v4}, Lgnu/expr/ApplyExp;-><init>(Lgnu/mapping/Procedure;[Lgnu/expr/Expression;)V

    .line 82
    .local v23, "tryMatch":Lgnu/expr/Expression;
    sub-int v15, v24, v16

    .line 83
    .local v15, "newVarCount":I
    new-array v12, v15, [Lgnu/expr/Expression;

    .line 84
    .local v12, "inits":[Lgnu/expr/Expression;
    move v11, v15

    .local v11, "i":I
    :goto_2
    add-int/lit8 v11, v11, -0x1

    if-ltz v11, :cond_7

    .line 85
    sget-object v25, Lgnu/expr/QuoteExp;->undefined_exp:Lgnu/expr/QuoteExp;

    aput-object v25, v12, v11
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 111
    .end local v4    # "args":[Lgnu/expr/Expression;
    .end local v6    # "block":Lgnu/expr/BlockExp;
    .end local v8    # "clause":Ljava/lang/Object;
    .end local v9    # "clauseScope":Lkawa/lang/PatternScope;
    .end local v11    # "i":I
    .end local v12    # "inits":[Lgnu/expr/Expression;
    .end local v15    # "newVarCount":I
    .end local v16    # "outerVarCount":I
    .end local v18    # "pair":Lgnu/lists/Pair;
    .end local v19    # "pattern":Lkawa/lang/SyntaxPattern;
    .end local v21    # "syntax":Lkawa/lang/SyntaxForm;
    .end local v22    # "tail":Ljava/lang/Object;
    .end local v23    # "tryMatch":Lgnu/expr/Expression;
    .end local v24    # "varCount":I
    .end local p1    # "clauses":Ljava/lang/Object;
    :catchall_0
    move-exception v25

    move-object/from16 v0, p3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    throw v25

    .line 86
    .restart local v4    # "args":[Lgnu/expr/Expression;
    .restart local v6    # "block":Lgnu/expr/BlockExp;
    .restart local v8    # "clause":Ljava/lang/Object;
    .restart local v9    # "clauseScope":Lkawa/lang/PatternScope;
    .restart local v11    # "i":I
    .restart local v12    # "inits":[Lgnu/expr/Expression;
    .restart local v15    # "newVarCount":I
    .restart local v16    # "outerVarCount":I
    .restart local v18    # "pair":Lgnu/lists/Pair;
    .restart local v19    # "pattern":Lkawa/lang/SyntaxPattern;
    .restart local v21    # "syntax":Lkawa/lang/SyntaxForm;
    .restart local v22    # "tail":Ljava/lang/Object;
    .restart local v23    # "tryMatch":Lgnu/expr/Expression;
    .restart local v24    # "varCount":I
    .restart local p1    # "clauses":Ljava/lang/Object;
    :cond_7
    :try_start_3
    iput-object v12, v9, Lkawa/lang/PatternScope;->inits:[Lgnu/expr/Expression;

    .line 89
    move-object/from16 v0, v22

    check-cast v0, Lgnu/lists/Pair;

    move-object/from16 v18, v0

    .line 90
    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v25

    sget-object v26, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    if-ne v0, v1, :cond_8

    .line 91
    move-object/from16 v0, p3

    move-object/from16 v1, v18

    move-object/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v17

    .line 101
    .local v17, "output":Lgnu/expr/Expression;
    :goto_3
    move-object/from16 v0, v17

    invoke-virtual {v9, v0}, Lkawa/lang/PatternScope;->setBody(Lgnu/expr/Expression;)V

    .line 103
    move-object/from16 v0, p3

    invoke-virtual {v0, v9}, Lkawa/lang/Translator;->pop(Lgnu/expr/ScopeExp;)V

    .line 104
    invoke-static/range {p3 .. p3}, Lkawa/lang/PatternScope;->pop(Lkawa/lang/Translator;)V

    .line 105
    new-instance v25, Lgnu/expr/IfExp;

    new-instance v26, Lgnu/expr/ExitExp;

    move-object/from16 v0, v26

    invoke-direct {v0, v6}, Lgnu/expr/ExitExp;-><init>(Lgnu/expr/BlockExp;)V

    move-object/from16 v0, v25

    move-object/from16 v1, v23

    move-object/from16 v2, v26

    invoke-direct {v0, v1, v9, v2}, Lgnu/expr/IfExp;-><init>(Lgnu/expr/Expression;Lgnu/expr/Expression;Lgnu/expr/Expression;)V

    check-cast p1, Lgnu/lists/Pair;

    .end local p1    # "clauses":Ljava/lang/Object;
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v26

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    move-object/from16 v2, p2

    move-object/from16 v3, p3

    invoke-virtual {v0, v1, v2, v3}, Lkawa/standard/syntax_case;->rewriteClauses(Ljava/lang/Object;Lkawa/standard/syntax_case_work;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v26

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    invoke-virtual {v6, v0, v1}, Lgnu/expr/BlockExp;->setBody(Lgnu/expr/Expression;Lgnu/expr/Expression;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 111
    move-object/from16 v0, p3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 94
    .end local v17    # "output":Lgnu/expr/Expression;
    .restart local p1    # "clauses":Ljava/lang/Object;
    :cond_8
    :try_start_4
    move-object/from16 v0, p3

    move-object/from16 v1, v18

    move-object/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v10

    .line 95
    .local v10, "fender":Lgnu/expr/Expression;
    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v25

    move-object/from16 v0, v25

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v25, v0

    if-eqz v25, :cond_9

    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v18

    .end local v18    # "pair":Lgnu/lists/Pair;
    check-cast v18, Lgnu/lists/Pair;

    .restart local v18    # "pair":Lgnu/lists/Pair;
    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v25

    sget-object v26, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v25

    move-object/from16 v1, v26

    if-eq v0, v1, :cond_a

    .line 97
    :cond_9
    const-string v25, "syntax-case:  bad clause"

    move-object/from16 v0, p3

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v6

    .line 111
    .end local v6    # "block":Lgnu/expr/BlockExp;
    move-object/from16 v0, p3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 98
    .restart local v6    # "block":Lgnu/expr/BlockExp;
    :cond_a
    :try_start_5
    new-instance v17, Lgnu/expr/IfExp;

    move-object/from16 v0, p3

    move-object/from16 v1, v18

    move-object/from16 v2, v21

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v25

    new-instance v26, Lgnu/expr/ExitExp;

    move-object/from16 v0, v26

    invoke-direct {v0, v6}, Lgnu/expr/ExitExp;-><init>(Lgnu/expr/BlockExp;)V

    move-object/from16 v0, v17

    move-object/from16 v1, v25

    move-object/from16 v2, v26

    invoke-direct {v0, v10, v1, v2}, Lgnu/expr/IfExp;-><init>(Lgnu/expr/Expression;Lgnu/expr/Expression;Lgnu/expr/Expression;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .restart local v17    # "output":Lgnu/expr/Expression;
    goto/16 :goto_3
.end method

.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 11
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 117
    new-instance v7, Lkawa/standard/syntax_case_work;

    invoke-direct {v7}, Lkawa/standard/syntax_case_work;-><init>()V

    .line 119
    .local v7, "work":Lkawa/standard/syntax_case_work;
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    .line 120
    .local v6, "obj":Ljava/lang/Object;
    instance-of v8, v6, Lgnu/lists/Pair;

    if-eqz v8, :cond_1

    move-object v8, v6

    check-cast v8, Lgnu/lists/Pair;

    invoke-virtual {v8}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v8

    instance-of v8, v8, Lgnu/lists/Pair;

    if-eqz v8, :cond_1

    .line 122
    const/4 v8, 0x2

    new-array v3, v8, [Lgnu/expr/Expression;

    .line 123
    .local v3, "linits":[Lgnu/expr/Expression;
    new-instance v2, Lgnu/expr/LetExp;

    invoke-direct {v2, v3}, Lgnu/expr/LetExp;-><init>([Lgnu/expr/Expression;)V

    .line 124
    .local v2, "let":Lgnu/expr/LetExp;
    const/4 v8, 0x0

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v2, v8}, Lgnu/expr/LetExp;->addDeclaration(Ljava/lang/Object;)Lgnu/expr/Declaration;

    move-result-object v8

    iput-object v8, v7, Lkawa/standard/syntax_case_work;->inputExpression:Lgnu/expr/Declaration;

    .line 126
    iget-object v5, p2, Lkawa/lang/Translator;->matchArray:Lgnu/expr/Declaration;

    .line 127
    .local v5, "matchArrayOuter":Lgnu/expr/Declaration;
    const/4 v8, 0x0

    check-cast v8, Ljava/lang/String;

    invoke-virtual {v2, v8}, Lgnu/expr/LetExp;->addDeclaration(Ljava/lang/Object;)Lgnu/expr/Declaration;

    move-result-object v4

    .line 128
    .local v4, "matchArray":Lgnu/expr/Declaration;
    sget-object v8, Lgnu/expr/Compilation;->objArrayType:Lgnu/bytecode/ArrayType;

    invoke-virtual {v4, v8}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 129
    const/4 v8, 0x1

    invoke-virtual {v4, v8}, Lgnu/expr/Declaration;->setCanRead(Z)V

    .line 130
    iput-object v4, p2, Lkawa/lang/Translator;->matchArray:Lgnu/expr/Declaration;

    .line 131
    iget-object v8, v7, Lkawa/standard/syntax_case_work;->inputExpression:Lgnu/expr/Declaration;

    const/4 v9, 0x1

    invoke-virtual {v8, v9}, Lgnu/expr/Declaration;->setCanRead(Z)V

    .line 132
    invoke-virtual {p2, v2}, Lkawa/lang/Translator;->push(Lgnu/expr/ScopeExp;)V

    move-object p1, v6

    .line 134
    check-cast p1, Lgnu/lists/Pair;

    .line 135
    const/4 v8, 0x0

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {p2, v9}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v9

    aput-object v9, v3, v8

    .line 136
    iget-object v8, v7, Lkawa/standard/syntax_case_work;->inputExpression:Lgnu/expr/Declaration;

    const/4 v9, 0x0

    aget-object v9, v3, v9

    invoke-virtual {v8, v9}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 137
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    move-object p1, v6

    .line 139
    check-cast p1, Lgnu/lists/Pair;

    .line 140
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v8

    const/4 v9, 0x0

    invoke-static {v8, v9, p2}, Lkawa/lang/SyntaxPattern;->getLiteralsList(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Lkawa/lang/Translator;)[Ljava/lang/Object;

    move-result-object v8

    iput-object v8, v7, Lkawa/standard/syntax_case_work;->literal_identifiers:[Ljava/lang/Object;

    .line 142
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    .line 144
    invoke-virtual {p0, v6, v7, p2}, Lkawa/standard/syntax_case;->rewriteClauses(Ljava/lang/Object;Lkawa/standard/syntax_case_work;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v8

    iput-object v8, v2, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    .line 145
    invoke-virtual {p2, v2}, Lkawa/lang/Translator;->pop(Lgnu/expr/ScopeExp;)V

    .line 147
    const-string v8, "kawa.lang.SyntaxPattern"

    invoke-static {v8}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v8

    const-string v9, "allocVars"

    const/4 v10, 0x2

    invoke-virtual {v8, v9, v10}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    .line 149
    .local v0, "allocVars":Lgnu/bytecode/Method;
    const/4 v8, 0x2

    new-array v1, v8, [Lgnu/expr/Expression;

    .line 150
    .local v1, "args":[Lgnu/expr/Expression;
    const/4 v8, 0x0

    new-instance v9, Lgnu/expr/QuoteExp;

    iget v10, v7, Lkawa/standard/syntax_case_work;->maxVars:I

    invoke-static {v10}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v10

    invoke-direct {v9, v10}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v9, v1, v8

    .line 151
    if-nez v5, :cond_0

    .line 152
    const/4 v8, 0x1

    sget-object v9, Lgnu/expr/QuoteExp;->nullExp:Lgnu/expr/QuoteExp;

    aput-object v9, v1, v8

    .line 155
    :goto_0
    const/4 v8, 0x1

    new-instance v9, Lgnu/expr/ApplyExp;

    invoke-direct {v9, v0, v1}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    aput-object v9, v3, v8

    .line 156
    const/4 v8, 0x1

    aget-object v8, v3, v8

    invoke-virtual {v4, v8}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 157
    iput-object v5, p2, Lkawa/lang/Translator;->matchArray:Lgnu/expr/Declaration;

    .line 160
    .end local v0    # "allocVars":Lgnu/bytecode/Method;
    .end local v1    # "args":[Lgnu/expr/Expression;
    .end local v2    # "let":Lgnu/expr/LetExp;
    .end local v3    # "linits":[Lgnu/expr/Expression;
    .end local v4    # "matchArray":Lgnu/expr/Declaration;
    .end local v5    # "matchArrayOuter":Lgnu/expr/Declaration;
    :goto_1
    return-object v2

    .line 154
    .restart local v0    # "allocVars":Lgnu/bytecode/Method;
    .restart local v1    # "args":[Lgnu/expr/Expression;
    .restart local v2    # "let":Lgnu/expr/LetExp;
    .restart local v3    # "linits":[Lgnu/expr/Expression;
    .restart local v4    # "matchArray":Lgnu/expr/Declaration;
    .restart local v5    # "matchArrayOuter":Lgnu/expr/Declaration;
    :cond_0
    const/4 v8, 0x1

    new-instance v9, Lgnu/expr/ReferenceExp;

    invoke-direct {v9, v5}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v9, v1, v8

    goto :goto_0

    .line 160
    .end local v0    # "allocVars":Lgnu/bytecode/Method;
    .end local v1    # "args":[Lgnu/expr/Expression;
    .end local v2    # "let":Lgnu/expr/LetExp;
    .end local v3    # "linits":[Lgnu/expr/Expression;
    .end local v4    # "matchArray":Lgnu/expr/Declaration;
    .end local v5    # "matchArrayOuter":Lgnu/expr/Declaration;
    :cond_1
    const-string v8, "insufficiant arguments to syntax-case"

    invoke-virtual {p2, v8}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v2

    goto :goto_1
.end method
