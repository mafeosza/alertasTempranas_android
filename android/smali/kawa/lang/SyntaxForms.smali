.class public Lkawa/lang/SyntaxForms;
.super Ljava/lang/Object;
.source "SyntaxForms.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lkawa/lang/SyntaxForms$PairSyntaxForm;,
        Lkawa/lang/SyntaxForms$SimpleSyntaxForm;
    }
.end annotation


# static fields
.field public static final DEBUGGING:Z = true


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 147
    return-void
.end method

.method public static freeIdentifierEquals(Lkawa/lang/SyntaxForm;Lkawa/lang/SyntaxForm;)Z
    .locals 5
    .param p0, "id1"    # Lkawa/lang/SyntaxForm;
    .param p1, "id2"    # Lkawa/lang/SyntaxForm;

    .prologue
    const/4 v4, -0x1

    .line 47
    invoke-static {}, Lgnu/expr/Compilation;->getCurrent()Lgnu/expr/Compilation;

    move-result-object v0

    check-cast v0, Lkawa/lang/Translator;

    .line 48
    .local v0, "tr":Lkawa/lang/Translator;
    iget-object v1, v0, Lkawa/lang/Translator;->lexical:Lgnu/expr/NameLookup;

    invoke-interface {p0}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2, v4}, Lgnu/expr/NameLookup;->lookup(Ljava/lang/Object;I)Lgnu/expr/Declaration;

    move-result-object v1

    iget-object v2, v0, Lkawa/lang/Translator;->lexical:Lgnu/expr/NameLookup;

    invoke-interface {p1}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v2, v3, v4}, Lgnu/expr/NameLookup;->lookup(Ljava/lang/Object;I)Lgnu/expr/Declaration;

    move-result-object v2

    if-ne v1, v2, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static fromDatum(Ljava/lang/Object;Lkawa/lang/SyntaxForm;)Ljava/lang/Object;
    .locals 1
    .param p0, "datum"    # Ljava/lang/Object;
    .param p1, "template"    # Lkawa/lang/SyntaxForm;

    .prologue
    .line 62
    invoke-interface {p1}, Lkawa/lang/SyntaxForm;->getScope()Lkawa/lang/TemplateScope;

    move-result-object v0

    invoke-static {p0, v0}, Lkawa/lang/SyntaxForms;->makeForm(Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static fromDatumIfNeeded(Ljava/lang/Object;Lkawa/lang/SyntaxForm;)Ljava/lang/Object;
    .locals 1
    .param p0, "datum"    # Ljava/lang/Object;
    .param p1, "template"    # Lkawa/lang/SyntaxForm;

    .prologue
    .line 67
    invoke-interface {p1}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v0

    if-ne p0, v0, :cond_0

    .line 72
    .end local p1    # "template":Lkawa/lang/SyntaxForm;
    :goto_0
    return-object p1

    .line 69
    .restart local p1    # "template":Lkawa/lang/SyntaxForm;
    :cond_0
    instance-of v0, p0, Lkawa/lang/SyntaxForm;

    if-eqz v0, :cond_1

    .line 70
    check-cast p0, Lkawa/lang/SyntaxForm;

    .end local p0    # "datum":Ljava/lang/Object;
    move-object p1, p0

    goto :goto_0

    .line 72
    .restart local p0    # "datum":Ljava/lang/Object;
    :cond_1
    invoke-static {p0, p1}, Lkawa/lang/SyntaxForms;->fromDatum(Ljava/lang/Object;Lkawa/lang/SyntaxForm;)Ljava/lang/Object;

    move-result-object p1

    goto :goto_0
.end method

.method public static isIdentifier(Lkawa/lang/SyntaxForm;)Z
    .locals 1
    .param p0, "form"    # Lkawa/lang/SyntaxForm;

    .prologue
    .line 53
    invoke-interface {p0}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lgnu/mapping/Symbol;

    return v0
.end method

.method public static makeForm(Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;
    .locals 1
    .param p0, "datum"    # Ljava/lang/Object;
    .param p1, "scope"    # Lkawa/lang/TemplateScope;

    .prologue
    .line 17
    instance-of v0, p0, Lgnu/lists/Pair;

    if-eqz v0, :cond_1

    .line 18
    new-instance v0, Lkawa/lang/SyntaxForms$PairSyntaxForm;

    check-cast p0, Lgnu/lists/Pair;

    .end local p0    # "datum":Ljava/lang/Object;
    invoke-direct {v0, p0, p1}, Lkawa/lang/SyntaxForms$PairSyntaxForm;-><init>(Lgnu/lists/Pair;Lkawa/lang/TemplateScope;)V

    move-object p0, v0

    .line 21
    :cond_0
    :goto_0
    return-object p0

    .line 19
    .restart local p0    # "datum":Ljava/lang/Object;
    :cond_1
    sget-object v0, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq p0, v0, :cond_0

    .line 21
    new-instance v0, Lkawa/lang/SyntaxForms$SimpleSyntaxForm;

    invoke-direct {v0, p0, p1}, Lkawa/lang/SyntaxForms$SimpleSyntaxForm;-><init>(Ljava/lang/Object;Lkawa/lang/TemplateScope;)V

    move-object p0, v0

    goto :goto_0
.end method

.method public static makeWithTemplate(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p0, "template"    # Ljava/lang/Object;
    .param p1, "form"    # Ljava/lang/Object;

    .prologue
    .line 33
    instance-of v1, p1, Lkawa/lang/SyntaxForm;

    if-eqz v1, :cond_1

    .line 34
    check-cast p1, Lkawa/lang/SyntaxForm;

    .line 42
    .end local p1    # "form":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-object p1

    .line 35
    .restart local p1    # "form":Ljava/lang/Object;
    :cond_1
    instance-of v1, p0, Lkawa/lang/SyntaxForm;

    if-eqz v1, :cond_0

    move-object v0, p0

    .line 37
    check-cast v0, Lkawa/lang/SyntaxForm;

    .line 38
    .local v0, "sform":Lkawa/lang/SyntaxForm;
    invoke-interface {v0}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v1

    if-ne p1, v1, :cond_2

    move-object p1, v0

    .line 39
    goto :goto_0

    .line 40
    :cond_2
    invoke-static {p1, v0}, Lkawa/lang/SyntaxForms;->fromDatum(Ljava/lang/Object;Lkawa/lang/SyntaxForm;)Ljava/lang/Object;

    move-result-object p1

    goto :goto_0
.end method

.method public static rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;
    .locals 2
    .param p0, "x"    # Ljava/lang/Object;

    .prologue
    .line 77
    invoke-static {}, Lgnu/expr/Compilation;->getCurrent()Lgnu/expr/Compilation;

    move-result-object v0

    check-cast v0, Lkawa/lang/Translator;

    .line 78
    .local v0, "tr":Lkawa/lang/Translator;
    invoke-virtual {v0, p0}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v1

    return-object v1
.end method

.method public static rewriteBody(Ljava/lang/Object;)Lgnu/expr/Expression;
    .locals 2
    .param p0, "x"    # Ljava/lang/Object;

    .prologue
    .line 83
    invoke-static {}, Lgnu/expr/Compilation;->getCurrent()Lgnu/expr/Compilation;

    move-result-object v0

    check-cast v0, Lkawa/lang/Translator;

    .line 84
    .local v0, "tr":Lkawa/lang/Translator;
    invoke-virtual {v0, p0}, Lkawa/lang/Translator;->rewrite_body(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v1

    return-object v1
.end method

.method public static toString(Lkawa/lang/SyntaxForm;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "sform"    # Lkawa/lang/SyntaxForm;
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 91
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v2, "#<syntax"

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 92
    .local v0, "sbuf":Ljava/lang/StringBuilder;
    if-eqz p1, :cond_0

    .line 94
    const/16 v2, 0x23

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 95
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 97
    :cond_0
    const/16 v2, 0x20

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 98
    invoke-interface {p0}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 101
    invoke-interface {p0}, Lkawa/lang/SyntaxForm;->getScope()Lkawa/lang/TemplateScope;

    move-result-object v1

    .line 102
    .local v1, "scope":Lkawa/lang/TemplateScope;
    if-nez v1, :cond_1

    .line 104
    const-string v2, " in null"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 112
    :goto_0
    const-string v2, ">"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 113
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 108
    :cond_1
    const-string v2, " in #"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 109
    iget v2, v1, Lkawa/lang/TemplateScope;->id:I

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    goto :goto_0
.end method
