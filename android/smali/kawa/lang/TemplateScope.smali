.class public Lkawa/lang/TemplateScope;
.super Lgnu/expr/LetExp;
.source "TemplateScope.java"

# interfaces
.implements Ljava/io/Externalizable;


# instance fields
.field macroContext:Lgnu/expr/Declaration;

.field private syntax:Lkawa/lang/Syntax;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lgnu/expr/LetExp;-><init>([Lgnu/expr/Expression;)V

    .line 24
    return-void
.end method

.method public constructor <init>(Lgnu/expr/ScopeExp;)V
    .locals 1
    .param p1, "outer"    # Lgnu/expr/ScopeExp;

    .prologue
    .line 28
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lgnu/expr/LetExp;-><init>([Lgnu/expr/Expression;)V

    .line 29
    iput-object p1, p0, Lkawa/lang/TemplateScope;->outer:Lgnu/expr/ScopeExp;

    .line 30
    return-void
.end method

.method public static make()Lkawa/lang/TemplateScope;
    .locals 1

    .prologue
    .line 34
    invoke-static {}, Lgnu/expr/Compilation;->getCurrent()Lgnu/expr/Compilation;

    move-result-object v0

    check-cast v0, Lkawa/lang/Translator;

    invoke-static {v0}, Lkawa/lang/TemplateScope;->make(Lkawa/lang/Translator;)Lkawa/lang/TemplateScope;

    move-result-object v0

    return-object v0
.end method

.method public static make(Lkawa/lang/Translator;)Lkawa/lang/TemplateScope;
    .locals 3
    .param p0, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 39
    new-instance v1, Lkawa/lang/TemplateScope;

    invoke-direct {v1}, Lkawa/lang/TemplateScope;-><init>()V

    .line 40
    .local v1, "templateScope":Lkawa/lang/TemplateScope;
    invoke-virtual {p0}, Lkawa/lang/Translator;->getCurrentSyntax()Lkawa/lang/Syntax;

    move-result-object v0

    .line 41
    .local v0, "curSyntax":Lkawa/lang/Syntax;
    instance-of v2, v0, Lkawa/lang/Macro;

    if-eqz v2, :cond_0

    move-object v2, v0

    .line 43
    check-cast v2, Lkawa/lang/Macro;

    invoke-virtual {v2}, Lkawa/lang/Macro;->getCapturedScope()Lgnu/expr/ScopeExp;

    move-result-object v2

    iput-object v2, v1, Lkawa/lang/TemplateScope;->outer:Lgnu/expr/ScopeExp;

    .line 44
    iget-object v2, p0, Lkawa/lang/Translator;->macroContext:Lgnu/expr/Declaration;

    iput-object v2, v1, Lkawa/lang/TemplateScope;->macroContext:Lgnu/expr/Declaration;

    .line 46
    :cond_0
    iput-object v0, v1, Lkawa/lang/TemplateScope;->syntax:Lkawa/lang/Syntax;

    .line 47
    return-object v1
.end method


# virtual methods
.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 1
    .param p1, "in"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 60
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/expr/ScopeExp;

    iput-object v0, p0, Lkawa/lang/TemplateScope;->outer:Lgnu/expr/ScopeExp;

    .line 61
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 50
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-super {p0}, Lgnu/expr/LetExp;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "(for "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lkawa/lang/TemplateScope;->syntax:Lkawa/lang/Syntax;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

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
    .line 54
    iget-object v0, p0, Lkawa/lang/TemplateScope;->outer:Lgnu/expr/ScopeExp;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 55
    return-void
.end method
