.class public Lgnu/expr/PushApply;
.super Lgnu/expr/ExpVisitor;
.source "PushApply.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lgnu/expr/ExpVisitor",
        "<",
        "Lgnu/expr/Expression;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lgnu/expr/ExpVisitor;-><init>()V

    return-void
.end method

.method public static pushApply(Lgnu/expr/Expression;)V
    .locals 2
    .param p0, "exp"    # Lgnu/expr/Expression;

    .prologue
    .line 14
    new-instance v0, Lgnu/expr/PushApply;

    invoke-direct {v0}, Lgnu/expr/PushApply;-><init>()V

    .line 15
    .local v0, "visitor":Lgnu/expr/PushApply;
    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Lgnu/expr/PushApply;->visit(Lgnu/expr/Expression;Ljava/lang/Object;)Ljava/lang/Object;

    .line 16
    return-void
.end method


# virtual methods
.method protected defaultValue(Lgnu/expr/Expression;Ljava/lang/Void;)Lgnu/expr/Expression;
    .locals 0
    .param p1, "r"    # Lgnu/expr/Expression;
    .param p2, "ignored"    # Ljava/lang/Void;

    .prologue
    .line 25
    return-object p1
.end method

.method protected bridge synthetic defaultValue(Lgnu/expr/Expression;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/Expression;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 10
    check-cast p2, Ljava/lang/Void;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/PushApply;->defaultValue(Lgnu/expr/Expression;Ljava/lang/Void;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected update(Lgnu/expr/Expression;Lgnu/expr/Expression;)Lgnu/expr/Expression;
    .locals 0
    .param p1, "exp"    # Lgnu/expr/Expression;
    .param p2, "r"    # Lgnu/expr/Expression;

    .prologue
    .line 20
    return-object p2
.end method

.method protected bridge synthetic update(Lgnu/expr/Expression;Ljava/lang/Object;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/Expression;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 10
    check-cast p2, Lgnu/expr/Expression;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/PushApply;->update(Lgnu/expr/Expression;Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected visitApplyExp(Lgnu/expr/ApplyExp;Ljava/lang/Void;)Lgnu/expr/Expression;
    .locals 7
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "ignored"    # Ljava/lang/Void;

    .prologue
    .line 30
    iget-object v2, p1, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    .line 31
    .local v2, "func":Lgnu/expr/Expression;
    instance-of v6, v2, Lgnu/expr/LetExp;

    if-eqz v6, :cond_0

    instance-of v6, v2, Lgnu/expr/FluidLetExp;

    if-nez v6, :cond_0

    move-object v4, v2

    .line 35
    check-cast v4, Lgnu/expr/LetExp;

    .line 36
    .local v4, "let":Lgnu/expr/LetExp;
    iget-object v1, v4, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    .line 37
    .local v1, "body":Lgnu/expr/Expression;
    iput-object p1, v4, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    .line 38
    iput-object v1, p1, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    .line 39
    invoke-virtual {p0, v4, p2}, Lgnu/expr/PushApply;->visit(Lgnu/expr/Expression;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lgnu/expr/Expression;

    .line 52
    .end local v1    # "body":Lgnu/expr/Expression;
    .end local v4    # "let":Lgnu/expr/LetExp;
    :goto_0
    return-object v6

    .line 41
    :cond_0
    instance-of v6, v2, Lgnu/expr/BeginExp;

    if-eqz v6, :cond_1

    move-object v0, v2

    .line 44
    check-cast v0, Lgnu/expr/BeginExp;

    .line 45
    .local v0, "begin":Lgnu/expr/BeginExp;
    iget-object v5, v0, Lgnu/expr/BeginExp;->exps:[Lgnu/expr/Expression;

    .line 46
    .local v5, "stmts":[Lgnu/expr/Expression;
    iget-object v6, v0, Lgnu/expr/BeginExp;->exps:[Lgnu/expr/Expression;

    array-length v6, v6

    add-int/lit8 v3, v6, -0x1

    .line 47
    .local v3, "last_index":I
    aget-object v6, v5, v3

    iput-object v6, p1, Lgnu/expr/ApplyExp;->func:Lgnu/expr/Expression;

    .line 48
    aput-object p1, v5, v3

    .line 49
    invoke-virtual {p0, v0, p2}, Lgnu/expr/PushApply;->visit(Lgnu/expr/Expression;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lgnu/expr/Expression;

    goto :goto_0

    .line 51
    .end local v0    # "begin":Lgnu/expr/BeginExp;
    .end local v3    # "last_index":I
    .end local v5    # "stmts":[Lgnu/expr/Expression;
    :cond_1
    invoke-virtual {p1, p0, p2}, Lgnu/expr/ApplyExp;->visitChildren(Lgnu/expr/ExpVisitor;Ljava/lang/Object;)V

    move-object v6, p1

    .line 52
    goto :goto_0
.end method

.method protected bridge synthetic visitApplyExp(Lgnu/expr/ApplyExp;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/ApplyExp;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 10
    check-cast p2, Ljava/lang/Void;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/PushApply;->visitApplyExp(Lgnu/expr/ApplyExp;Ljava/lang/Void;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method
