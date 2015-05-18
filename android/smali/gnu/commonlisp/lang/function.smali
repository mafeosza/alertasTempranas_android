.class public Lgnu/commonlisp/lang/function;
.super Lkawa/lang/Syntax;
.source "function.java"


# instance fields
.field lambda:Lkawa/lang/Syntax;


# direct methods
.method public constructor <init>(Lkawa/lang/Syntax;)V
    .locals 0
    .param p1, "lambda"    # Lkawa/lang/Syntax;

    .prologue
    .line 12
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 13
    iput-object p1, p0, Lgnu/commonlisp/lang/function;->lambda:Lkawa/lang/Syntax;

    .line 14
    return-void
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 6
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 18
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    .line 19
    .local v1, "obj":Ljava/lang/Object;
    instance-of v4, v1, Lgnu/lists/Pair;

    if-eqz v4, :cond_5

    move-object v2, v1

    .line 21
    check-cast v2, Lgnu/lists/Pair;

    .line 22
    .local v2, "pair":Lgnu/lists/Pair;
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    sget-object v5, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v4, v5, :cond_0

    .line 23
    const-string v4, "too many forms after \'function\'"

    invoke-virtual {p2, v4}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v3

    .line 42
    .end local v2    # "pair":Lgnu/lists/Pair;
    :goto_0
    return-object v3

    .line 24
    .restart local v2    # "pair":Lgnu/lists/Pair;
    :cond_0
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v0

    .line 25
    .local v0, "name":Ljava/lang/Object;
    instance-of v4, v0, Ljava/lang/String;

    if-nez v4, :cond_1

    instance-of v4, v0, Lgnu/mapping/Symbol;

    if-eqz v4, :cond_2

    .line 27
    :cond_1
    new-instance v3, Lgnu/expr/ReferenceExp;

    invoke-direct {v3, v0}, Lgnu/expr/ReferenceExp;-><init>(Ljava/lang/Object;)V

    .line 28
    .local v3, "rexp":Lgnu/expr/ReferenceExp;
    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lgnu/expr/ReferenceExp;->setProcedureName(Z)V

    .line 29
    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Lgnu/expr/ReferenceExp;->setFlag(I)V

    goto :goto_0

    .line 32
    .end local v3    # "rexp":Lgnu/expr/ReferenceExp;
    :cond_2
    instance-of v4, v0, Lgnu/lists/Pair;

    if-eqz v4, :cond_5

    move-object v2, v0

    .line 34
    check-cast v2, Lgnu/lists/Pair;

    .line 35
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v0

    .line 36
    instance-of v4, v0, Ljava/lang/String;

    if-eqz v4, :cond_4

    const-string v4, "lambda"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 39
    .end local v0    # "name":Ljava/lang/Object;
    :cond_3
    iget-object v4, p0, Lgnu/commonlisp/lang/function;->lambda:Lkawa/lang/Syntax;

    invoke-virtual {v4, v2, p2}, Lkawa/lang/Syntax;->rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v3

    goto :goto_0

    .line 36
    .restart local v0    # "name":Ljava/lang/Object;
    :cond_4
    instance-of v4, v0, Lgnu/mapping/Symbol;

    if-eqz v4, :cond_5

    const-string v4, "lambda"

    check-cast v0, Lgnu/mapping/Symbol;

    .end local v0    # "name":Ljava/lang/Object;
    invoke-virtual {v0}, Lgnu/mapping/Symbol;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 42
    .end local v2    # "pair":Lgnu/lists/Pair;
    :cond_5
    const-string v4, "function must be followed by name or lambda expression"

    invoke-virtual {p2, v4}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v3

    goto :goto_0
.end method
