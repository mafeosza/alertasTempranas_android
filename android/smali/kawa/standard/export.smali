.class public Lkawa/standard/export;
.super Lkawa/lang/Syntax;
.source "export.java"


# static fields
.field public static final export:Lkawa/standard/export;

.field public static final module_export:Lkawa/standard/export;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 8
    new-instance v0, Lkawa/standard/export;

    invoke-direct {v0}, Lkawa/standard/export;-><init>()V

    sput-object v0, Lkawa/standard/export;->module_export:Lkawa/standard/export;

    .line 9
    sget-object v0, Lkawa/standard/export;->module_export:Lkawa/standard/export;

    const-string v1, "module-export"

    invoke-virtual {v0, v1}, Lkawa/standard/export;->setName(Ljava/lang/String;)V

    .line 11
    new-instance v0, Lkawa/standard/export;

    invoke-direct {v0}, Lkawa/standard/export;-><init>()V

    sput-object v0, Lkawa/standard/export;->export:Lkawa/standard/export;

    .line 12
    sget-object v0, Lkawa/standard/export;->module_export:Lkawa/standard/export;

    const-string v1, "export"

    invoke-virtual {v0, v1}, Lkawa/standard/export;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    return-void
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 85
    const/4 v0, 0x0

    return-object v0
.end method

.method public scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 12
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "forms"    # Ljava/util/Vector;
    .param p3, "defs"    # Lgnu/expr/ScopeExp;
    .param p4, "tr"    # Lkawa/lang/Translator;

    .prologue
    const/4 v9, 0x1

    .line 17
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    .line 18
    .local v2, "list":Ljava/lang/Object;
    move-object/from16 v0, p4

    invoke-virtual {v0, p1}, Lkawa/lang/Translator;->pushPositionOf(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 21
    .local v5, "savePos":Ljava/lang/Object;
    :try_start_0
    instance-of v8, p3, Lgnu/expr/ModuleExp;

    if-eqz v8, :cond_0

    .line 22
    move-object v0, p3

    check-cast v0, Lgnu/expr/ModuleExp;

    move-object v8, v0

    const/16 v10, 0x4000

    invoke-virtual {v8, v10}, Lgnu/expr/ModuleExp;->setFlag(I)V

    .line 28
    const/4 v4, 0x0

    .line 29
    .local v4, "restSyntax":Lkawa/lang/SyntaxForm;
    :goto_0
    sget-object v8, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v2, v8, :cond_8

    .line 31
    move-object/from16 v0, p4

    invoke-virtual {v0, v2}, Lkawa/lang/Translator;->pushPositionOf(Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    :goto_1
    instance-of v8, v2, Lkawa/lang/SyntaxForm;

    if-eqz v8, :cond_1

    .line 34
    move-object v0, v2

    check-cast v0, Lkawa/lang/SyntaxForm;

    move-object v4, v0

    .line 35
    invoke-interface {v4}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v2

    goto :goto_1

    .line 25
    .end local v4    # "restSyntax":Lkawa/lang/SyntaxForm;
    :cond_0
    const/16 v8, 0x65

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "\'"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {p0}, Lkawa/standard/export;->getName()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "\' not at module level"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    move-object/from16 v0, p4

    invoke-virtual {v0, v8, v10}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 79
    move-object/from16 v0, p4

    invoke-virtual {v0, v5}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    move v8, v9

    :goto_2
    return v8

    .line 37
    .restart local v4    # "restSyntax":Lkawa/lang/SyntaxForm;
    :cond_1
    move-object v3, v4

    .line 38
    .local v3, "nameSyntax":Lkawa/lang/SyntaxForm;
    :try_start_1
    instance-of v8, v2, Lgnu/lists/Pair;

    if-eqz v8, :cond_7

    .line 40
    move-object v0, v2

    check-cast v0, Lgnu/lists/Pair;

    move-object p1, v0

    .line 41
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v7

    .line 42
    .local v7, "symbol":Ljava/lang/Object;
    :goto_3
    instance-of v8, v7, Lkawa/lang/SyntaxForm;

    if-eqz v8, :cond_2

    .line 44
    move-object v0, v7

    check-cast v0, Lkawa/lang/SyntaxForm;

    move-object v3, v0

    .line 45
    invoke-interface {v3}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v7

    goto :goto_3

    .line 47
    :cond_2
    instance-of v8, v7, Ljava/lang/String;

    if-eqz v8, :cond_3

    .line 49
    move-object v0, v7

    check-cast v0, Ljava/lang/String;

    move-object v6, v0

    .line 50
    .local v6, "str":Ljava/lang/String;
    const-string v8, "namespace:"

    invoke-virtual {v6, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 52
    const/16 v8, 0x77

    const-string v10, "\'namespace:\' prefix ignored"

    move-object/from16 v0, p4

    invoke-virtual {v0, v8, v10}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 53
    const/16 v8, 0xa

    invoke-virtual {v6, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v7

    .line 56
    .end local v6    # "str":Ljava/lang/String;
    .end local v7    # "symbol":Ljava/lang/Object;
    :cond_3
    instance-of v8, v7, Ljava/lang/String;

    if-nez v8, :cond_4

    instance-of v8, v7, Lgnu/mapping/Symbol;

    if-eqz v8, :cond_7

    .line 59
    :cond_4
    if-eqz v3, :cond_5

    .line 64
    :cond_5
    invoke-virtual {p3, v7}, Lgnu/expr/ScopeExp;->getNoDefine(Ljava/lang/Object;)Lgnu/expr/Declaration;

    move-result-object v1

    .line 65
    .local v1, "decl":Lgnu/expr/Declaration;
    const-wide/16 v10, 0x200

    invoke-virtual {v1, v10, v11}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v8

    if-eqz v8, :cond_6

    .line 66
    invoke-static {v1, p1}, Lkawa/lang/Translator;->setLine(Lgnu/expr/Declaration;Ljava/lang/Object;)V

    .line 67
    :cond_6
    const-wide/16 v10, 0x400

    invoke-virtual {v1, v10, v11}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 68
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    .line 69
    goto/16 :goto_0

    .line 72
    .end local v1    # "decl":Lgnu/expr/Declaration;
    :cond_7
    const/16 v8, 0x65

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "invalid syntax in \'"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {p0}, Lkawa/standard/export;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const/16 v10, 0x27

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, p4

    invoke-virtual {v0, v8, v9}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 73
    const/4 v8, 0x0

    .line 79
    move-object/from16 v0, p4

    invoke-virtual {v0, v5}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    goto/16 :goto_2

    .end local v3    # "nameSyntax":Lkawa/lang/SyntaxForm;
    :cond_8
    move-object/from16 v0, p4

    invoke-virtual {v0, v5}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    move v8, v9

    goto/16 :goto_2

    .end local v4    # "restSyntax":Lkawa/lang/SyntaxForm;
    :catchall_0
    move-exception v8

    move-object/from16 v0, p4

    invoke-virtual {v0, v5}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    throw v8
.end method
