.class public Lkawa/lang/Macro;
.super Lkawa/lang/Syntax;
.source "Macro.java"

# interfaces
.implements Lgnu/text/Printable;
.implements Ljava/io/Externalizable;


# instance fields
.field private capturedScope:Lgnu/expr/ScopeExp;

.field public expander:Ljava/lang/Object;

.field private hygienic:Z

.field instance:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 76
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 14
    const/4 v0, 0x1

    iput-boolean v0, p0, Lkawa/lang/Macro;->hygienic:Z

    .line 77
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/Object;

    .prologue
    .line 95
    invoke-direct {p0, p1}, Lkawa/lang/Syntax;-><init>(Ljava/lang/Object;)V

    .line 14
    const/4 v0, 0x1

    iput-boolean v0, p0, Lkawa/lang/Macro;->hygienic:Z

    .line 96
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;Lgnu/mapping/Procedure;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/Object;
    .param p2, "expander"    # Lgnu/mapping/Procedure;

    .prologue
    .line 89
    invoke-direct {p0, p1}, Lkawa/lang/Syntax;-><init>(Ljava/lang/Object;)V

    .line 14
    const/4 v0, 0x1

    iput-boolean v0, p0, Lkawa/lang/Macro;->hygienic:Z

    .line 90
    new-instance v0, Lgnu/expr/QuoteExp;

    invoke-direct {v0, p2}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lkawa/lang/Macro;->expander:Ljava/lang/Object;

    .line 91
    return-void
.end method

.method public constructor <init>(Lkawa/lang/Macro;)V
    .locals 1
    .param p1, "old"    # Lkawa/lang/Macro;

    .prologue
    .line 81
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 14
    const/4 v0, 0x1

    iput-boolean v0, p0, Lkawa/lang/Macro;->hygienic:Z

    .line 82
    iget-object v0, p1, Lkawa/lang/Macro;->name:Ljava/lang/Object;

    iput-object v0, p0, Lkawa/lang/Macro;->name:Ljava/lang/Object;

    .line 83
    iget-object v0, p1, Lkawa/lang/Macro;->expander:Ljava/lang/Object;

    iput-object v0, p0, Lkawa/lang/Macro;->expander:Ljava/lang/Object;

    .line 84
    iget-boolean v0, p1, Lkawa/lang/Macro;->hygienic:Z

    iput-boolean v0, p0, Lkawa/lang/Macro;->hygienic:Z

    .line 85
    return-void
.end method

.method public static make(Lgnu/expr/Declaration;)Lkawa/lang/Macro;
    .locals 2
    .param p0, "decl"    # Lgnu/expr/Declaration;

    .prologue
    .line 37
    new-instance v0, Lkawa/lang/Macro;

    invoke-virtual {p0}, Lgnu/expr/Declaration;->getSymbol()Ljava/lang/Object;

    move-result-object v1

    invoke-direct {v0, v1}, Lkawa/lang/Macro;-><init>(Ljava/lang/Object;)V

    .line 38
    .local v0, "mac":Lkawa/lang/Macro;
    invoke-virtual {p0}, Lgnu/expr/Declaration;->setSyntax()V

    .line 39
    iget-object v1, p0, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    iput-object v1, v0, Lkawa/lang/Macro;->capturedScope:Lgnu/expr/ScopeExp;

    .line 40
    return-object v0
.end method

.method public static make(Ljava/lang/Object;Lgnu/mapping/Procedure;)Lkawa/lang/Macro;
    .locals 1
    .param p0, "name"    # Ljava/lang/Object;
    .param p1, "expander"    # Lgnu/mapping/Procedure;

    .prologue
    .line 61
    new-instance v0, Lkawa/lang/Macro;

    invoke-direct {v0, p0, p1}, Lkawa/lang/Macro;-><init>(Ljava/lang/Object;Lgnu/mapping/Procedure;)V

    .line 62
    .local v0, "mac":Lkawa/lang/Macro;
    return-object v0
.end method

.method public static make(Ljava/lang/Object;Lgnu/mapping/Procedure;Ljava/lang/Object;)Lkawa/lang/Macro;
    .locals 1
    .param p0, "name"    # Ljava/lang/Object;
    .param p1, "expander"    # Lgnu/mapping/Procedure;
    .param p2, "instance"    # Ljava/lang/Object;

    .prologue
    .line 67
    new-instance v0, Lkawa/lang/Macro;

    invoke-direct {v0, p0, p1}, Lkawa/lang/Macro;-><init>(Ljava/lang/Object;Lgnu/mapping/Procedure;)V

    .line 68
    .local v0, "mac":Lkawa/lang/Macro;
    iput-object p2, v0, Lkawa/lang/Macro;->instance:Ljava/lang/Object;

    .line 69
    return-object v0
.end method

.method public static makeNonHygienic(Ljava/lang/Object;Lgnu/mapping/Procedure;)Lkawa/lang/Macro;
    .locals 2
    .param p0, "name"    # Ljava/lang/Object;
    .param p1, "expander"    # Lgnu/mapping/Procedure;

    .prologue
    .line 45
    new-instance v0, Lkawa/lang/Macro;

    invoke-direct {v0, p0, p1}, Lkawa/lang/Macro;-><init>(Ljava/lang/Object;Lgnu/mapping/Procedure;)V

    .line 46
    .local v0, "mac":Lkawa/lang/Macro;
    const/4 v1, 0x0

    iput-boolean v1, v0, Lkawa/lang/Macro;->hygienic:Z

    .line 47
    return-object v0
.end method

.method public static makeNonHygienic(Ljava/lang/Object;Lgnu/mapping/Procedure;Ljava/lang/Object;)Lkawa/lang/Macro;
    .locals 2
    .param p0, "name"    # Ljava/lang/Object;
    .param p1, "expander"    # Lgnu/mapping/Procedure;
    .param p2, "instance"    # Ljava/lang/Object;

    .prologue
    .line 53
    new-instance v0, Lkawa/lang/Macro;

    invoke-direct {v0, p0, p1}, Lkawa/lang/Macro;-><init>(Ljava/lang/Object;Lgnu/mapping/Procedure;)V

    .line 54
    .local v0, "mac":Lkawa/lang/Macro;
    const/4 v1, 0x0

    iput-boolean v1, v0, Lkawa/lang/Macro;->hygienic:Z

    .line 55
    iput-object p2, v0, Lkawa/lang/Macro;->instance:Ljava/lang/Object;

    .line 56
    return-object v0
.end method


# virtual methods
.method public expand(Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;
    .locals 14
    .param p1, "form"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 126
    :try_start_0
    iget-object v3, p0, Lkawa/lang/Macro;->expander:Ljava/lang/Object;

    .line 127
    .local v3, "exp":Ljava/lang/Object;
    instance-of v11, v3, Lgnu/mapping/Procedure;

    if-eqz v11, :cond_1

    instance-of v11, v3, Lgnu/expr/Expression;

    if-nez v11, :cond_1

    .line 128
    move-object v0, v3

    check-cast v0, Lgnu/mapping/Procedure;

    move-object v8, v0

    .line 161
    .end local v3    # "exp":Ljava/lang/Object;
    .local v8, "pr":Lgnu/mapping/Procedure;
    :goto_0
    iget-boolean v11, p0, Lkawa/lang/Macro;->hygienic:Z

    if-nez v11, :cond_6

    .line 163
    invoke-static/range {p1 .. p2}, Lkawa/lang/Quote;->quote(Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object p1

    .line 164
    invoke-static {p1}, Lkawa/lang/Translator;->listLength(Ljava/lang/Object;)I

    move-result v5

    .line 165
    .local v5, "nargs":I
    if-gtz v5, :cond_3

    .line 166
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "invalid macro argument list to "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v9

    .line 190
    .end local v5    # "nargs":I
    .end local v8    # "pr":Lgnu/mapping/Procedure;
    :cond_0
    :goto_1
    return-object v9

    .line 131
    .restart local v3    # "exp":Ljava/lang/Object;
    :cond_1
    instance-of v11, v3, Lgnu/expr/Expression;

    if-nez v11, :cond_2

    .line 133
    move-object/from16 v0, p2

    iget-object v10, v0, Lkawa/lang/Translator;->currentMacroDefinition:Lkawa/lang/Macro;

    .line 134
    .local v10, "savedMacro":Lkawa/lang/Macro;
    move-object/from16 v0, p2

    iput-object p0, v0, Lkawa/lang/Translator;->currentMacroDefinition:Lkawa/lang/Macro;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 137
    :try_start_1
    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v3

    .line 138
    .local v3, "exp":Lgnu/expr/Expression;
    iput-object v3, p0, Lkawa/lang/Macro;->expander:Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 142
    :try_start_2
    move-object/from16 v0, p2

    iput-object v10, v0, Lkawa/lang/Translator;->currentMacroDefinition:Lkawa/lang/Macro;

    .line 157
    .end local v3    # "exp":Lgnu/expr/Expression;
    .end local v10    # "savedMacro":Lkawa/lang/Macro;
    :cond_2
    check-cast v3, Lgnu/expr/Expression;

    invoke-virtual/range {p2 .. p2}, Lkawa/lang/Translator;->getGlobalEnvironment()Lgnu/mapping/Environment;

    move-result-object v11

    invoke-virtual {v3, v11}, Lgnu/expr/Expression;->eval(Lgnu/mapping/Environment;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lgnu/mapping/Procedure;

    .restart local v8    # "pr":Lgnu/mapping/Procedure;
    goto :goto_0

    .line 142
    .end local v8    # "pr":Lgnu/mapping/Procedure;
    .restart local v10    # "savedMacro":Lkawa/lang/Macro;
    :catchall_0
    move-exception v11

    move-object/from16 v0, p2

    iput-object v10, v0, Lkawa/lang/Translator;->currentMacroDefinition:Lkawa/lang/Macro;

    throw v11
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0

    .line 188
    .end local v10    # "savedMacro":Lkawa/lang/Macro;
    :catch_0
    move-exception v2

    .line 190
    .local v2, "ex":Ljava/lang/Throwable;
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "evaluating syntax transformer \'"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {p0}, Lkawa/lang/Macro;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "\' threw "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v9

    goto :goto_1

    .line 167
    .end local v2    # "ex":Ljava/lang/Throwable;
    .restart local v5    # "nargs":I
    .restart local v8    # "pr":Lgnu/mapping/Procedure;
    :cond_3
    add-int/lit8 v11, v5, -0x1

    :try_start_3
    new-array v1, v11, [Ljava/lang/Object;

    .line 168
    .local v1, "args":[Ljava/lang/Object;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_2
    if-ge v4, v5, :cond_5

    .line 170
    move-object v0, p1

    check-cast v0, Lgnu/lists/Pair;

    move-object v7, v0

    .line 171
    .local v7, "pair":Lgnu/lists/Pair;
    if-lez v4, :cond_4

    .line 172
    add-int/lit8 v11, v4, -0x1

    invoke-virtual {v7}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v12

    aput-object v12, v1, v11

    .line 173
    :cond_4
    invoke-virtual {v7}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p1

    .line 168
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 175
    .end local v7    # "pair":Lgnu/lists/Pair;
    :cond_5
    invoke-virtual {v8, v1}, Lgnu/mapping/Procedure;->applyN([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    .line 179
    .end local v1    # "args":[Ljava/lang/Object;
    .end local v4    # "i":I
    .end local v5    # "nargs":I
    .local v9, "result":Ljava/lang/Object;
    :goto_3
    instance-of v11, p1, Lgnu/lists/PairWithPosition;

    if-eqz v11, :cond_0

    instance-of v11, v9, Lgnu/lists/Pair;

    if-eqz v11, :cond_0

    instance-of v11, v9, Lgnu/lists/PairWithPosition;

    if-nez v11, :cond_0

    .line 182
    move-object v0, v9

    check-cast v0, Lgnu/lists/Pair;

    move-object v6, v0

    .line 183
    .local v6, "p":Lgnu/lists/Pair;
    new-instance v9, Lgnu/lists/PairWithPosition;

    .end local v9    # "result":Ljava/lang/Object;
    move-object v0, p1

    check-cast v0, Lgnu/lists/PairWithPosition;

    move-object v11, v0

    invoke-virtual {v6}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v12

    invoke-virtual {v6}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v13

    invoke-direct {v9, v11, v12, v13}, Lgnu/lists/PairWithPosition;-><init>(Lgnu/text/SourceLocator;Ljava/lang/Object;Ljava/lang/Object;)V

    .local v9, "result":Lgnu/lists/PairWithPosition;
    goto/16 :goto_1

    .line 178
    .end local v6    # "p":Lgnu/lists/Pair;
    .end local v9    # "result":Lgnu/lists/PairWithPosition;
    :cond_6
    invoke-virtual {v8, p1}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_0

    move-result-object v9

    .local v9, "result":Ljava/lang/Object;
    goto :goto_3
.end method

.method public getCapturedScope()Lgnu/expr/ScopeExp;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lkawa/lang/Macro;->capturedScope:Lgnu/expr/ScopeExp;

    if-nez v0, :cond_0

    .line 22
    iget-object v0, p0, Lkawa/lang/Macro;->instance:Ljava/lang/Object;

    instance-of v0, v0, Lgnu/expr/ModuleExp;

    if-eqz v0, :cond_1

    .line 23
    iget-object v0, p0, Lkawa/lang/Macro;->instance:Ljava/lang/Object;

    check-cast v0, Lgnu/expr/ModuleExp;

    iput-object v0, p0, Lkawa/lang/Macro;->capturedScope:Lgnu/expr/ScopeExp;

    .line 27
    :cond_0
    :goto_0
    iget-object v0, p0, Lkawa/lang/Macro;->capturedScope:Lgnu/expr/ScopeExp;

    return-object v0

    .line 24
    :cond_1
    iget-object v0, p0, Lkawa/lang/Macro;->instance:Ljava/lang/Object;

    if-eqz v0, :cond_0

    .line 25
    iget-object v0, p0, Lkawa/lang/Macro;->instance:Ljava/lang/Object;

    invoke-static {v0}, Lgnu/expr/ModuleInfo;->findFromInstance(Ljava/lang/Object;)Lgnu/expr/ModuleInfo;

    move-result-object v0

    invoke-virtual {v0}, Lgnu/expr/ModuleInfo;->getModuleExp()Lgnu/expr/ModuleExp;

    move-result-object v0

    iput-object v0, p0, Lkawa/lang/Macro;->capturedScope:Lgnu/expr/ScopeExp;

    goto :goto_0
.end method

.method public final isHygienic()Z
    .locals 1

    .prologue
    .line 72
    iget-boolean v0, p0, Lkawa/lang/Macro;->hygienic:Z

    return v0
.end method

.method public print(Lgnu/lists/Consumer;)V
    .locals 1
    .param p1, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 116
    const-string v0, "#<macro "

    invoke-interface {p1, v0}, Lgnu/lists/Consumer;->write(Ljava/lang/String;)V

    .line 117
    invoke-virtual {p0}, Lkawa/lang/Macro;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Lgnu/lists/Consumer;->write(Ljava/lang/String;)V

    .line 118
    const/16 v0, 0x3e

    invoke-interface {p1, v0}, Lgnu/lists/Consumer;->write(I)V

    .line 119
    return-void
.end method

.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 2
    .param p1, "in"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 228
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {p0, v0}, Lkawa/lang/Macro;->setName(Ljava/lang/String;)V

    .line 229
    new-instance v0, Lgnu/expr/QuoteExp;

    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v1

    invoke-direct {v0, v1}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lkawa/lang/Macro;->expander:Ljava/lang/Object;

    .line 230
    return-void
.end method

.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 101
    invoke-virtual {p0, p1, p2}, Lkawa/lang/Macro;->expand(Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p2, v0}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method public rewriteForm(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "form"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 106
    invoke-virtual {p0, p1, p2}, Lkawa/lang/Macro;->expand(Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {p2, v0}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method public scanForm(Lgnu/lists/Pair;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)V
    .locals 6
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "defs"    # Lgnu/expr/ScopeExp;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 197
    invoke-virtual {p3}, Lkawa/lang/Translator;->getFileName()Ljava/lang/String;

    move-result-object v2

    .line 198
    .local v2, "save_filename":Ljava/lang/String;
    invoke-virtual {p3}, Lkawa/lang/Translator;->getLineNumber()I

    move-result v3

    .line 199
    .local v3, "save_line":I
    invoke-virtual {p3}, Lkawa/lang/Translator;->getColumnNumber()I

    move-result v1

    .line 200
    .local v1, "save_column":I
    iget-object v0, p3, Lkawa/lang/Translator;->currentSyntax:Lkawa/lang/Syntax;

    .line 203
    .local v0, "saveSyntax":Lkawa/lang/Syntax;
    :try_start_0
    invoke-virtual {p3, p1}, Lkawa/lang/Translator;->setLine(Ljava/lang/Object;)V

    .line 204
    iput-object p0, p3, Lkawa/lang/Translator;->currentSyntax:Lkawa/lang/Syntax;

    .line 205
    invoke-virtual {p0, p1, p3}, Lkawa/lang/Macro;->expand(Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v4

    .line 206
    .local v4, "x":Ljava/lang/Object;
    invoke-virtual {p3, v4, p2}, Lkawa/lang/Translator;->scanForm(Ljava/lang/Object;Lgnu/expr/ScopeExp;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 210
    invoke-virtual {p3, v2, v3, v1}, Lkawa/lang/Translator;->setLine(Ljava/lang/String;II)V

    .line 211
    iput-object v0, p3, Lkawa/lang/Translator;->currentSyntax:Lkawa/lang/Syntax;

    .line 213
    return-void

    .line 210
    .end local v4    # "x":Ljava/lang/Object;
    :catchall_0
    move-exception v5

    invoke-virtual {p3, v2, v3, v1}, Lkawa/lang/Translator;->setLine(Ljava/lang/String;II)V

    .line 211
    iput-object v0, p3, Lkawa/lang/Translator;->currentSyntax:Lkawa/lang/Syntax;

    throw v5
.end method

.method public setCapturedScope(Lgnu/expr/ScopeExp;)V
    .locals 0
    .param p1, "scope"    # Lgnu/expr/ScopeExp;

    .prologue
    .line 32
    iput-object p1, p0, Lkawa/lang/Macro;->capturedScope:Lgnu/expr/ScopeExp;

    .line 33
    return-void
.end method

.method public final setHygienic(Z)V
    .locals 0
    .param p1, "hygienic"    # Z

    .prologue
    .line 73
    iput-boolean p1, p0, Lkawa/lang/Macro;->hygienic:Z

    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 111
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "#<macro "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lkawa/lang/Macro;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x3e

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 1
    .param p1, "out"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 221
    invoke-virtual {p0}, Lkawa/lang/Macro;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 222
    iget-object v0, p0, Lkawa/lang/Macro;->expander:Ljava/lang/Object;

    check-cast v0, Lgnu/expr/QuoteExp;

    invoke-virtual {v0}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 223
    return-void
.end method
