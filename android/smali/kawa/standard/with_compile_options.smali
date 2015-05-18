.class public Lkawa/standard/with_compile_options;
.super Lkawa/lang/Syntax;
.source "with_compile_options.java"


# static fields
.field public static final with_compile_options:Lkawa/standard/with_compile_options;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 9
    new-instance v0, Lkawa/standard/with_compile_options;

    invoke-direct {v0}, Lkawa/standard/with_compile_options;-><init>()V

    sput-object v0, Lkawa/standard/with_compile_options;->with_compile_options:Lkawa/standard/with_compile_options;

    .line 11
    sget-object v0, Lkawa/standard/with_compile_options;->with_compile_options:Lkawa/standard/with_compile_options;

    const-string v1, "with-compile-options"

    invoke-virtual {v0, v1}, Lkawa/standard/with_compile_options;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    return-void
.end method

.method public static getOptions(Ljava/lang/Object;Ljava/util/Stack;Lkawa/lang/Syntax;Lkawa/lang/Translator;)Ljava/lang/Object;
    .locals 13
    .param p0, "form"    # Ljava/lang/Object;
    .param p1, "stack"    # Ljava/util/Stack;
    .param p2, "command"    # Lkawa/lang/Syntax;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 33
    const/4 v7, 0x0

    .line 34
    .local v7, "seenKey":Z
    move-object/from16 v0, p3

    iget-object v3, v0, Lkawa/lang/Translator;->currentOptions:Lgnu/text/Options;

    .line 35
    .local v3, "options":Lgnu/text/Options;
    const/4 v8, 0x0

    .line 38
    .local v8, "syntax":Lkawa/lang/SyntaxForm;
    :goto_0
    instance-of v10, p0, Lkawa/lang/SyntaxForm;

    if-eqz v10, :cond_0

    move-object v8, p0

    .line 40
    check-cast v8, Lkawa/lang/SyntaxForm;

    .line 41
    invoke-interface {v8}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object p0

    goto :goto_0

    .line 43
    :cond_0
    instance-of v10, p0, Lgnu/lists/Pair;

    if-nez v10, :cond_3

    .line 97
    :cond_1
    if-nez v7, :cond_2

    .line 98
    const/16 v10, 0x65

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "no option keyword in "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {p2}, Lkawa/lang/Syntax;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p3

    invoke-virtual {v0, v10, v11}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 99
    :cond_2
    invoke-static {p0, v8}, Lkawa/lang/Translator;->wrapSyntax(Ljava/lang/Object;Lkawa/lang/SyntaxForm;)Ljava/lang/Object;

    move-result-object v10

    :goto_1
    return-object v10

    :cond_3
    move-object v4, p0

    .line 45
    check-cast v4, Lgnu/lists/Pair;

    .line 46
    .local v4, "pair":Lgnu/lists/Pair;
    invoke-virtual {v4}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v10

    invoke-static {v10}, Lkawa/lang/Translator;->stripSyntax(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 47
    .local v5, "pair_car":Ljava/lang/Object;
    instance-of v10, v5, Lgnu/expr/Keyword;

    if-eqz v10, :cond_1

    .line 49
    check-cast v5, Lgnu/expr/Keyword;

    .end local v5    # "pair_car":Ljava/lang/Object;
    invoke-virtual {v5}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v1

    .line 50
    .local v1, "key":Ljava/lang/String;
    const/4 v7, 0x1

    .line 51
    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Lkawa/lang/Translator;->pushPositionOf(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 54
    .local v6, "savePos":Ljava/lang/Object;
    :try_start_0
    invoke-virtual {v4}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p0

    .line 55
    :goto_2
    instance-of v10, p0, Lkawa/lang/SyntaxForm;

    if-eqz v10, :cond_4

    .line 57
    move-object v0, p0

    check-cast v0, Lkawa/lang/SyntaxForm;

    move-object v8, v0

    .line 58
    invoke-interface {v8}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object p0

    goto :goto_2

    .line 60
    :cond_4
    instance-of v10, p0, Lgnu/lists/Pair;

    if-nez v10, :cond_5

    .line 62
    const/16 v10, 0x65

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "keyword "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " not followed by value"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p3

    invoke-virtual {v0, v10, v11}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 63
    sget-object v10, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 94
    move-object/from16 v0, p3

    invoke-virtual {v0, v6}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    goto :goto_1

    .line 65
    :cond_5
    :try_start_1
    move-object v0, p0

    check-cast v0, Lgnu/lists/Pair;

    move-object v4, v0

    .line 66
    invoke-virtual {v4}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v10

    invoke-static {v10}, Lkawa/lang/Translator;->stripSyntax(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    .line 67
    .local v9, "value":Ljava/lang/Object;
    invoke-virtual {v4}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p0

    .line 68
    invoke-virtual {v3, v1}, Lgnu/text/Options;->getLocal(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 69
    .local v2, "oldValue":Ljava/lang/Object;
    invoke-virtual {v3, v1}, Lgnu/text/Options;->getInfo(Ljava/lang/String;)Lgnu/text/Options$OptionInfo;

    move-result-object v10

    if-nez v10, :cond_6

    .line 71
    const/16 v10, 0x77

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "unknown compile option: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p3

    invoke-virtual {v0, v10, v11}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 94
    move-object/from16 v0, p3

    invoke-virtual {v0, v6}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 74
    :cond_6
    :try_start_2
    instance-of v10, v9, Lgnu/lists/FString;

    if-eqz v10, :cond_9

    .line 75
    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    .line 84
    .end local v9    # "value":Ljava/lang/Object;
    :cond_7
    :goto_3
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v10

    invoke-virtual {v3, v1, v9, v10}, Lgnu/text/Options;->set(Ljava/lang/String;Ljava/lang/Object;Lgnu/text/SourceMessages;)V

    .line 85
    if-eqz p1, :cond_8

    .line 87
    invoke-virtual {p1, v1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 88
    invoke-virtual {p1, v2}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 89
    invoke-virtual {p1, v9}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 94
    :cond_8
    move-object/from16 v0, p3

    invoke-virtual {v0, v6}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 76
    .restart local v9    # "value":Ljava/lang/Object;
    :cond_9
    :try_start_3
    instance-of v10, v9, Ljava/lang/Boolean;

    if-nez v10, :cond_7

    instance-of v10, v9, Ljava/lang/Number;

    if-nez v10, :cond_7

    .line 81
    const/4 v9, 0x0

    .line 82
    const/16 v10, 0x65

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "invalid literal value for key "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p3

    invoke-virtual {v0, v10, v11}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_3

    .line 94
    .end local v2    # "oldValue":Ljava/lang/Object;
    .end local v9    # "value":Ljava/lang/Object;
    :catchall_0
    move-exception v10

    move-object/from16 v0, p3

    invoke-virtual {v0, v6}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    throw v10
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 9
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 106
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    .line 108
    .local v2, "obj":Ljava/lang/Object;
    instance-of v7, v2, Lgnu/lists/Pair;

    if-eqz v7, :cond_0

    move-object v3, v2

    check-cast v3, Lgnu/lists/Pair;

    .local v3, "p":Lgnu/lists/Pair;
    invoke-virtual {v3}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v7

    instance-of v7, v7, Ljava/util/Stack;

    if-eqz v7, :cond_0

    .line 111
    invoke-virtual {v3}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Stack;

    .line 112
    .local v6, "stack":Ljava/util/Stack;
    invoke-virtual {v3}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    .line 113
    .local v4, "rest":Ljava/lang/Object;
    iget-object v7, p2, Lkawa/lang/Translator;->currentOptions:Lgnu/text/Options;

    invoke-virtual {v7, v6}, Lgnu/text/Options;->pushOptionValues(Ljava/util/Vector;)V

    .line 123
    .end local v3    # "p":Lgnu/lists/Pair;
    :goto_0
    :try_start_0
    invoke-virtual {p2, v4}, Lkawa/lang/Translator;->rewrite_body(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v5

    .line 125
    .local v5, "result":Lgnu/expr/Expression;
    instance-of v7, v5, Lgnu/expr/BeginExp;

    if-eqz v7, :cond_1

    .line 126
    move-object v0, v5

    check-cast v0, Lgnu/expr/BeginExp;

    move-object v1, v0

    .line 129
    .local v1, "bresult":Lgnu/expr/BeginExp;
    :goto_1
    invoke-virtual {v1, v6}, Lgnu/expr/BeginExp;->setCompileOptions(Ljava/util/Vector;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 134
    iget-object v7, p2, Lkawa/lang/Translator;->currentOptions:Lgnu/text/Options;

    invoke-virtual {v7, v6}, Lgnu/text/Options;->popOptionValues(Ljava/util/Vector;)V

    return-object v1

    .line 117
    .end local v1    # "bresult":Lgnu/expr/BeginExp;
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v5    # "result":Lgnu/expr/Expression;
    .end local v6    # "stack":Ljava/util/Stack;
    :cond_0
    new-instance v6, Ljava/util/Stack;

    invoke-direct {v6}, Ljava/util/Stack;-><init>()V

    .line 118
    .restart local v6    # "stack":Ljava/util/Stack;
    invoke-static {v2, v6, p0, p2}, Lkawa/standard/with_compile_options;->getOptions(Ljava/lang/Object;Ljava/util/Stack;Lkawa/lang/Syntax;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v4

    .restart local v4    # "rest":Ljava/lang/Object;
    goto :goto_0

    .line 128
    .restart local v5    # "result":Lgnu/expr/Expression;
    :cond_1
    :try_start_1
    new-instance v1, Lgnu/expr/BeginExp;

    const/4 v7, 0x1

    new-array v7, v7, [Lgnu/expr/Expression;

    const/4 v8, 0x0

    aput-object v5, v7, v8

    invoke-direct {v1, v7}, Lgnu/expr/BeginExp;-><init>([Lgnu/expr/Expression;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .restart local v1    # "bresult":Lgnu/expr/BeginExp;
    goto :goto_1

    .line 134
    .end local v1    # "bresult":Lgnu/expr/BeginExp;
    .end local v5    # "result":Lgnu/expr/Expression;
    :catchall_0
    move-exception v7

    iget-object v8, p2, Lkawa/lang/Translator;->currentOptions:Lgnu/text/Options;

    invoke-virtual {v8, v6}, Lgnu/text/Options;->popOptionValues(Ljava/util/Vector;)V

    throw v7
.end method

.method public scanForm(Lgnu/lists/Pair;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)V
    .locals 5
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "defs"    # Lgnu/expr/ScopeExp;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 15
    new-instance v2, Ljava/util/Stack;

    invoke-direct {v2}, Ljava/util/Stack;-><init>()V

    .line 16
    .local v2, "stack":Ljava/util/Stack;
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    invoke-static {v3, v2, p0, p3}, Lkawa/standard/with_compile_options;->getOptions(Ljava/lang/Object;Ljava/util/Stack;Lkawa/lang/Syntax;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v0

    .line 17
    .local v0, "rest":Ljava/lang/Object;
    sget-object v3, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v0, v3, :cond_0

    .line 28
    .end local v0    # "rest":Ljava/lang/Object;
    :goto_0
    return-void

    .line 19
    .restart local v0    # "rest":Ljava/lang/Object;
    :cond_0
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    if-ne v0, v3, :cond_1

    .line 21
    const/4 v3, 0x0

    invoke-virtual {p3, v0, p2, v3}, Lkawa/lang/Translator;->scanBody(Ljava/lang/Object;Lgnu/expr/ScopeExp;Z)Lgnu/lists/LList;

    goto :goto_0

    .line 24
    :cond_1
    const/4 v3, 0x1

    invoke-virtual {p3, v0, p2, v3}, Lkawa/lang/Translator;->scanBody(Ljava/lang/Object;Lgnu/expr/ScopeExp;Z)Lgnu/lists/LList;

    move-result-object v0

    .line 25
    .local v0, "rest":Lgnu/lists/LList;
    new-instance v1, Lgnu/lists/Pair;

    invoke-direct {v1, v2, v0}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 26
    .local v1, "rest":Lgnu/lists/Pair;
    iget-object v3, p3, Lkawa/lang/Translator;->currentOptions:Lgnu/text/Options;

    .end local v0    # "rest":Lgnu/lists/LList;
    invoke-virtual {v3, v2}, Lgnu/text/Options;->popOptionValues(Ljava/util/Vector;)V

    .line 27
    iget-object v3, p3, Lkawa/lang/Translator;->formStack:Ljava/util/Stack;

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v4

    invoke-static {p1, v4, v1}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/Stack;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method
