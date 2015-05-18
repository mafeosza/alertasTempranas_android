.class public Lkawa/standard/syntax;
.super Lkawa/lang/Quote;
.source "syntax.java"


# static fields
.field static final makeTemplateScopeMethod:Lgnu/bytecode/Method;

.field public static final quasiSyntax:Lkawa/standard/syntax;

.field public static final syntax:Lkawa/standard/syntax;

.field static final typeTemplateScope:Lgnu/bytecode/ClassType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 9
    new-instance v0, Lkawa/standard/syntax;

    const-string v1, "syntax"

    invoke-direct {v0, v1, v3}, Lkawa/standard/syntax;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lkawa/standard/syntax;->syntax:Lkawa/standard/syntax;

    .line 10
    new-instance v0, Lkawa/standard/syntax;

    const-string v1, "quasisyntax"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lkawa/standard/syntax;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lkawa/standard/syntax;->quasiSyntax:Lkawa/standard/syntax;

    .line 22
    const-string v0, "kawa.lang.TemplateScope"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    sput-object v0, Lkawa/standard/syntax;->typeTemplateScope:Lgnu/bytecode/ClassType;

    .line 24
    sget-object v0, Lkawa/standard/syntax;->typeTemplateScope:Lgnu/bytecode/ClassType;

    const-string v1, "make"

    invoke-virtual {v0, v1, v3}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lkawa/standard/syntax;->makeTemplateScopeMethod:Lgnu/bytecode/Method;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "isQuasi"    # Z

    .prologue
    .line 14
    invoke-direct {p0, p1, p2}, Lkawa/lang/Quote;-><init>(Ljava/lang/String;Z)V

    .line 15
    return-void
.end method

.method static makeSyntax(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 8
    .param p0, "form"    # Ljava/lang/Object;
    .param p1, "tr"    # Lkawa/lang/Translator;

    .prologue
    const/4 v7, 0x2

    .line 65
    new-instance v3, Lkawa/lang/SyntaxTemplate;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4, p1}, Lkawa/lang/SyntaxTemplate;-><init>(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Lkawa/lang/Translator;)V

    .line 66
    .local v3, "template":Lkawa/lang/SyntaxTemplate;
    sget-object v1, Lgnu/expr/QuoteExp;->nullExp:Lgnu/expr/QuoteExp;

    .line 67
    .local v1, "matchArray":Lgnu/expr/Expression;
    iget-object v2, p1, Lkawa/lang/Translator;->patternScope:Lkawa/lang/PatternScope;

    .line 68
    .local v2, "patternScope":Lkawa/lang/PatternScope;
    if-eqz v2, :cond_0

    iget-object v4, v2, Lkawa/lang/PatternScope;->matchArray:Lgnu/expr/Declaration;

    if-eqz v4, :cond_0

    .line 69
    new-instance v1, Lgnu/expr/ReferenceExp;

    .end local v1    # "matchArray":Lgnu/expr/Expression;
    iget-object v4, v2, Lkawa/lang/PatternScope;->matchArray:Lgnu/expr/Declaration;

    invoke-direct {v1, v4}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    .line 70
    .restart local v1    # "matchArray":Lgnu/expr/Expression;
    :cond_0
    const/4 v4, 0x3

    new-array v0, v4, [Lgnu/expr/Expression;

    const/4 v4, 0x0

    new-instance v5, Lgnu/expr/QuoteExp;

    invoke-direct {v5, v3}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    aput-object v5, v0, v4

    const/4 v4, 0x1

    aput-object v1, v0, v4

    new-instance v4, Lgnu/expr/ReferenceExp;

    iget-object v5, p1, Lkawa/lang/Translator;->templateScopeDecl:Lgnu/expr/Declaration;

    invoke-direct {v4, v5}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v4, v0, v7

    .line 71
    .local v0, "args":[Lgnu/expr/Expression;
    new-instance v4, Lgnu/expr/ApplyExp;

    const-string v5, "kawa.lang.SyntaxTemplate"

    invoke-static {v5}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v5

    const-string v6, "execute"

    invoke-virtual {v5, v6, v7}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v5

    invoke-direct {v4, v5, v0}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    return-object v4
.end method


# virtual methods
.method protected expandColonForms()Z
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    return v0
.end method

.method protected leaf(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "val"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 60
    invoke-static {p1, p2}, Lkawa/standard/syntax;->makeSyntax(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v0

    return-object v0
.end method

.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 6
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 29
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    instance-of v4, v4, Lgnu/lists/Pair;

    if-eqz v4, :cond_0

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lgnu/lists/Pair;

    move-object p1, v4

    check-cast p1, Lgnu/lists/Pair;

    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    sget-object v5, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v4, v5, :cond_1

    .line 31
    :cond_0
    const-string v4, "syntax forms requires a single form"

    invoke-virtual {p2, v4}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v0

    .line 54
    :goto_0
    return-object v0

    .line 32
    :cond_1
    iget-object v2, p2, Lkawa/lang/Translator;->templateScopeDecl:Lgnu/expr/Declaration;

    .line 33
    .local v2, "saveTemplateScopeDecl":Lgnu/expr/Declaration;
    if-nez v2, :cond_2

    .line 35
    invoke-virtual {p2}, Lkawa/lang/Translator;->letStart()V

    .line 36
    new-instance v1, Lgnu/expr/ApplyExp;

    sget-object v4, Lkawa/standard/syntax;->makeTemplateScopeMethod:Lgnu/bytecode/Method;

    sget-object v5, Lgnu/expr/Expression;->noExpressions:[Lgnu/expr/Expression;

    invoke-direct {v1, v4, v5}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    .line 39
    .local v1, "init":Lgnu/expr/Expression;
    const/4 v4, 0x0

    sget-object v5, Lkawa/standard/syntax;->typeTemplateScope:Lgnu/bytecode/ClassType;

    invoke-virtual {p2, v4, v5, v1}, Lkawa/lang/Translator;->letVariable(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;

    move-result-object v3

    .line 40
    .local v3, "templateScopeDecl":Lgnu/expr/Declaration;
    invoke-virtual {v3}, Lgnu/expr/Declaration;->setCanRead()V

    .line 41
    iput-object v3, p2, Lkawa/lang/Translator;->templateScopeDecl:Lgnu/expr/Declaration;

    .line 42
    invoke-virtual {p2}, Lkawa/lang/Translator;->letEnter()V

    .line 47
    .end local v1    # "init":Lgnu/expr/Expression;
    .end local v3    # "templateScopeDecl":Lgnu/expr/Declaration;
    :cond_2
    :try_start_0
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    iget-boolean v4, p0, Lkawa/standard/syntax;->isQuasi:Z

    if-eqz v4, :cond_4

    const/4 v4, 0x1

    :goto_1
    invoke-virtual {p0, v5, v4, p2}, Lkawa/standard/syntax;->expand(Ljava/lang/Object;ILkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {p0, v4, p2}, Lkawa/standard/syntax;->coerceExpression(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v0

    .line 50
    .local v0, "body":Lgnu/expr/Expression;
    if-nez v2, :cond_3

    invoke-virtual {p2, v0}, Lkawa/lang/Translator;->letDone(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 54
    .end local v0    # "body":Lgnu/expr/Expression;
    :cond_3
    iput-object v2, p2, Lkawa/lang/Translator;->templateScopeDecl:Lgnu/expr/Declaration;

    goto :goto_0

    .line 47
    :cond_4
    const/4 v4, -0x1

    goto :goto_1

    .line 54
    :catchall_0
    move-exception v4

    iput-object v2, p2, Lkawa/lang/Translator;->templateScopeDecl:Lgnu/expr/Declaration;

    throw v4
.end method
