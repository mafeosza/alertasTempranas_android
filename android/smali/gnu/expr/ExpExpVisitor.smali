.class public abstract Lgnu/expr/ExpExpVisitor;
.super Lgnu/expr/ExpVisitor;
.source "ExpExpVisitor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<D:",
        "Ljava/lang/Object;",
        ">",
        "Lgnu/expr/ExpVisitor",
        "<",
        "Lgnu/expr/Expression;",
        "TD;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    .local p0, "this":Lgnu/expr/ExpExpVisitor;, "Lgnu/expr/ExpExpVisitor<TD;>;"
    invoke-direct {p0}, Lgnu/expr/ExpVisitor;-><init>()V

    return-void
.end method


# virtual methods
.method protected defaultValue(Lgnu/expr/Expression;Ljava/lang/Object;)Lgnu/expr/Expression;
    .locals 0
    .param p1, "r"    # Lgnu/expr/Expression;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lgnu/expr/Expression;",
            "TD;)",
            "Lgnu/expr/Expression;"
        }
    .end annotation

    .prologue
    .line 17
    .local p0, "this":Lgnu/expr/ExpExpVisitor;, "Lgnu/expr/ExpExpVisitor<TD;>;"
    .local p2, "d":Ljava/lang/Object;, "TD;"
    return-object p1
.end method

.method protected bridge synthetic defaultValue(Lgnu/expr/Expression;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/Expression;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 8
    .local p0, "this":Lgnu/expr/ExpExpVisitor;, "Lgnu/expr/ExpExpVisitor<TD;>;"
    invoke-virtual {p0, p1, p2}, Lgnu/expr/ExpExpVisitor;->defaultValue(Lgnu/expr/Expression;Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method protected update(Lgnu/expr/Expression;Lgnu/expr/Expression;)Lgnu/expr/Expression;
    .locals 0
    .param p1, "exp"    # Lgnu/expr/Expression;
    .param p2, "r"    # Lgnu/expr/Expression;

    .prologue
    .line 12
    .local p0, "this":Lgnu/expr/ExpExpVisitor;, "Lgnu/expr/ExpExpVisitor<TD;>;"
    return-object p2
.end method

.method protected bridge synthetic update(Lgnu/expr/Expression;Ljava/lang/Object;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "x0"    # Lgnu/expr/Expression;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 8
    .local p0, "this":Lgnu/expr/ExpExpVisitor;, "Lgnu/expr/ExpExpVisitor<TD;>;"
    check-cast p2, Lgnu/expr/Expression;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lgnu/expr/ExpExpVisitor;->update(Lgnu/expr/Expression;Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method
