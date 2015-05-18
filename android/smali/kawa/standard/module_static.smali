.class public Lkawa/standard/module_static;
.super Lkawa/lang/Syntax;
.source "module_static.java"


# static fields
.field public static final module_static:Lkawa/standard/module_static;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 10
    new-instance v0, Lkawa/standard/module_static;

    invoke-direct {v0}, Lkawa/standard/module_static;-><init>()V

    sput-object v0, Lkawa/standard/module_static;->module_static:Lkawa/standard/module_static;

    .line 11
    sget-object v0, Lkawa/standard/module_static;->module_static:Lkawa/standard/module_static;

    const-string v1, "module-static"

    invoke-virtual {v0, v1}, Lkawa/standard/module_static;->setName(Ljava/lang/String;)V

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
    .locals 1
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 80
    const/4 v0, 0x0

    return-object v0
.end method

.method public scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 11
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "forms"    # Ljava/util/Vector;
    .param p3, "defs"    # Lgnu/expr/ScopeExp;
    .param p4, "tr"    # Lkawa/lang/Translator;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    const/high16 v10, 0x10000

    const v9, 0x8000

    const/16 v8, 0x65

    .line 16
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    .line 17
    .local v1, "list":Ljava/lang/Object;
    instance-of v6, p3, Lgnu/expr/ModuleExp;

    if-nez v6, :cond_1

    .line 19
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p0}, Lkawa/standard/module_static;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\' not at module level"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p4, v8, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 75
    :cond_0
    :goto_0
    return v4

    :cond_1
    move-object v2, p3

    .line 22
    check-cast v2, Lgnu/expr/ModuleExp;

    .line 23
    .local v2, "mexp":Lgnu/expr/ModuleExp;
    instance-of v6, v1, Lgnu/lists/Pair;

    if-eqz v6, :cond_4

    move-object p1, v1

    check-cast p1, Lgnu/lists/Pair;

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    sget-object v7, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v6, v7, :cond_4

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    instance-of v6, v6, Ljava/lang/Boolean;

    if-eqz v6, :cond_4

    .line 27
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    sget-object v6, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v5, v6, :cond_3

    .line 28
    invoke-virtual {v2, v10}, Lgnu/expr/ModuleExp;->setFlag(I)V

    .line 72
    :cond_2
    :goto_1
    invoke-virtual {v2, v10}, Lgnu/expr/ModuleExp;->getFlag(I)Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-virtual {v2, v9}, Lgnu/expr/ModuleExp;->getFlag(I)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 74
    const-string v5, "inconsistent module-static specifiers"

    invoke-virtual {p4, v8, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto :goto_0

    .line 30
    :cond_3
    invoke-virtual {v2, v9}, Lgnu/expr/ModuleExp;->setFlag(I)V

    goto :goto_1

    .line 32
    :cond_4
    instance-of v6, v1, Lgnu/lists/Pair;

    if-eqz v6, :cond_6

    move-object p1, v1

    check-cast p1, Lgnu/lists/Pair;

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    sget-object v7, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v6, v7, :cond_6

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    instance-of v6, v6, Lgnu/lists/Pair;

    if-eqz v6, :cond_6

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object p1

    .end local p1    # "st":Lgnu/lists/Pair;
    check-cast p1, Lgnu/lists/Pair;

    .restart local p1    # "st":Lgnu/lists/Pair;
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    const-string v7, "quote"

    invoke-virtual {p4, v6, v7}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 37
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p1

    .end local p1    # "st":Lgnu/lists/Pair;
    check-cast p1, Lgnu/lists/Pair;

    .restart local p1    # "st":Lgnu/lists/Pair;
    sget-object v6, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq p1, v6, :cond_5

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    instance-of v6, v6, Lgnu/mapping/SimpleSymbol;

    if-eqz v6, :cond_5

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v7, "init-run"

    if-ne v6, v7, :cond_5

    .line 42
    invoke-virtual {v2, v9}, Lgnu/expr/ModuleExp;->setFlag(I)V

    .line 43
    const/high16 v5, 0x40000

    invoke-virtual {v2, v5}, Lgnu/expr/ModuleExp;->setFlag(I)V

    goto :goto_1

    .line 47
    :cond_5
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "invalid quoted symbol for \'"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p0}, Lkawa/standard/module_static;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v6, 0x27

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p4, v8, v4}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    move v4, v5

    .line 48
    goto/16 :goto_0

    .line 53
    :cond_6
    invoke-virtual {v2, v10}, Lgnu/expr/ModuleExp;->setFlag(I)V

    .line 56
    :goto_2
    sget-object v6, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v1, v6, :cond_2

    .line 58
    instance-of v6, v1, Lgnu/lists/Pair;

    if-eqz v6, :cond_7

    move-object p1, v1

    check-cast p1, Lgnu/lists/Pair;

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    instance-of v6, v6, Lgnu/mapping/Symbol;

    if-nez v6, :cond_8

    .line 61
    :cond_7
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "invalid syntax in \'"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p0}, Lkawa/standard/module_static;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v6, 0x27

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p4, v8, v4}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    move v4, v5

    .line 62
    goto/16 :goto_0

    .line 64
    :cond_8
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lgnu/mapping/Symbol;

    .line 65
    .local v3, "symbol":Lgnu/mapping/Symbol;
    invoke-virtual {p3, v3}, Lgnu/expr/ScopeExp;->getNoDefine(Ljava/lang/Object;)Lgnu/expr/Declaration;

    move-result-object v0

    .line 66
    .local v0, "decl":Lgnu/expr/Declaration;
    const-wide/16 v6, 0x200

    invoke-virtual {v0, v6, v7}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 67
    invoke-static {v0, p1}, Lkawa/lang/Translator;->setLine(Lgnu/expr/Declaration;Ljava/lang/Object;)V

    .line 68
    :cond_9
    const-wide/16 v6, 0x800

    invoke-virtual {v0, v6, v7}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 69
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    .line 70
    goto :goto_2
.end method
