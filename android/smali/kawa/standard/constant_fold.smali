.class public Lkawa/standard/constant_fold;
.super Lkawa/lang/Syntax;
.source "constant_fold.java"


# static fields
.field public static final constant_fold:Lkawa/standard/constant_fold;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 10
    new-instance v0, Lkawa/standard/constant_fold;

    invoke-direct {v0}, Lkawa/standard/constant_fold;-><init>()V

    sput-object v0, Lkawa/standard/constant_fold;->constant_fold:Lkawa/standard/constant_fold;

    .line 11
    sget-object v0, Lkawa/standard/constant_fold;->constant_fold:Lkawa/standard/constant_fold;

    const-string v1, "constant-fold"

    invoke-virtual {v0, v1}, Lkawa/standard/constant_fold;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    return-void
.end method

.method static checkConstant(Lgnu/expr/Expression;Lkawa/lang/Translator;)Ljava/lang/Object;
    .locals 5
    .param p0, "exp"    # Lgnu/expr/Expression;
    .param p1, "tr"    # Lkawa/lang/Translator;

    .prologue
    const/4 v2, 0x0

    .line 15
    instance-of v3, p0, Lgnu/expr/QuoteExp;

    if-eqz v3, :cond_1

    .line 16
    check-cast p0, Lgnu/expr/QuoteExp;

    .end local p0    # "exp":Lgnu/expr/Expression;
    invoke-virtual {p0}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v2

    .line 26
    :cond_0
    :goto_0
    return-object v2

    .line 17
    .restart local p0    # "exp":Lgnu/expr/Expression;
    :cond_1
    instance-of v3, p0, Lgnu/expr/ReferenceExp;

    if-eqz v3, :cond_0

    move-object v1, p0

    .line 19
    check-cast v1, Lgnu/expr/ReferenceExp;

    .line 20
    .local v1, "rexp":Lgnu/expr/ReferenceExp;
    invoke-virtual {v1}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v0

    .line 21
    .local v0, "decl":Lgnu/expr/Declaration;
    if-eqz v0, :cond_2

    const-wide/32 v3, 0x10000

    invoke-virtual {v0, v3, v4}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 22
    :cond_2
    invoke-static {}, Lgnu/mapping/Environment;->user()Lgnu/mapping/Environment;

    move-result-object v3

    invoke-virtual {v1}, Lgnu/expr/ReferenceExp;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4, v2}, Lgnu/mapping/Environment;->get(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    goto :goto_0

    .line 24
    :cond_3
    invoke-static {v0}, Lgnu/expr/Declaration;->followAliases(Lgnu/expr/Declaration;)Lgnu/expr/Declaration;

    move-result-object v2

    invoke-virtual {v2}, Lgnu/expr/Declaration;->getConstantValue()Ljava/lang/Object;

    move-result-object v2

    goto :goto_0
.end method


# virtual methods
.method public rewrite(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 10
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 31
    invoke-virtual {p2, p1}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v3

    .line 32
    .local v3, "exp":Lgnu/expr/Expression;
    instance-of v8, v3, Lgnu/expr/ApplyExp;

    if-nez v8, :cond_0

    move-object v8, v3

    .line 61
    :goto_0
    return-object v8

    :cond_0
    move-object v0, v3

    .line 34
    check-cast v0, Lgnu/expr/ApplyExp;

    .line 35
    .local v0, "aexp":Lgnu/expr/ApplyExp;
    invoke-virtual {v0}, Lgnu/expr/ApplyExp;->getFunction()Lgnu/expr/Expression;

    move-result-object v8

    invoke-static {v8, p2}, Lkawa/standard/constant_fold;->checkConstant(Lgnu/expr/Expression;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v4

    .line 36
    .local v4, "func":Ljava/lang/Object;
    instance-of v8, v4, Lgnu/mapping/Procedure;

    if-nez v8, :cond_1

    move-object v8, v3

    .line 37
    goto :goto_0

    .line 43
    :cond_1
    invoke-virtual {v0}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v1

    .line 44
    .local v1, "args":[Lgnu/expr/Expression;
    array-length v5, v1

    .line 45
    .local v5, "i":I
    new-array v7, v5, [Ljava/lang/Object;

    .line 46
    .local v7, "vals":[Ljava/lang/Object;
    :goto_1
    add-int/lit8 v5, v5, -0x1

    if-ltz v5, :cond_3

    .line 48
    aget-object v8, v1, v5

    invoke-static {v8, p2}, Lkawa/standard/constant_fold;->checkConstant(Lgnu/expr/Expression;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v6

    .line 49
    .local v6, "val":Ljava/lang/Object;
    if-nez v6, :cond_2

    move-object v8, v3

    .line 50
    goto :goto_0

    .line 51
    :cond_2
    aput-object v6, v7, v5

    goto :goto_1

    .line 55
    .end local v6    # "val":Ljava/lang/Object;
    :cond_3
    :try_start_0
    new-instance v8, Lgnu/expr/QuoteExp;

    check-cast v4, Lgnu/mapping/Procedure;

    .end local v4    # "func":Ljava/lang/Object;
    invoke-virtual {v4, v7}, Lgnu/mapping/Procedure;->applyN([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-direct {v8, v9}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 57
    :catch_0
    move-exception v2

    .line 59
    .local v2, "ex":Ljava/lang/Throwable;
    const-string v8, "caught exception in constant-fold:"

    invoke-virtual {p2, v8}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v3

    .line 60
    invoke-virtual {v2}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p2, v8}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-object v8, v3

    .line 61
    goto :goto_0
.end method
