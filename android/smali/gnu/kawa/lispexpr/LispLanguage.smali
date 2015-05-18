.class public abstract Lgnu/kawa/lispexpr/LispLanguage;
.super Lgnu/expr/Language;
.source "LispLanguage.java"


# static fields
.field public static final bracket_apply_sym:Lgnu/mapping/Symbol;

.field public static final bracket_list_sym:Lgnu/mapping/Symbol;

.field public static getNamedPartLocation:Lgnu/kawa/reflect/StaticFieldLocation; = null

.field public static final lookup_sym:Lgnu/mapping/Symbol;

.field public static final quasiquote_sym:Ljava/lang/String; = "quasiquote"

.field public static final quote_sym:Ljava/lang/String; = "quote"

.field public static final unquote_sym:Ljava/lang/String; = "unquote"

.field public static final unquotesplicing_sym:Ljava/lang/String; = "unquote-splicing"


# instance fields
.field public defaultReadTable:Lgnu/kawa/lispexpr/ReadTable;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 25
    sget-object v0, Lgnu/mapping/Namespace;->EmptyNamespace:Lgnu/mapping/Namespace;

    const-string v1, "$lookup$"

    invoke-virtual {v0, v1}, Lgnu/mapping/Namespace;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v0

    sput-object v0, Lgnu/kawa/lispexpr/LispLanguage;->lookup_sym:Lgnu/mapping/Symbol;

    .line 28
    sget-object v0, Lgnu/mapping/Namespace;->EmptyNamespace:Lgnu/mapping/Namespace;

    const-string v1, "$bracket-list$"

    invoke-virtual {v0, v1}, Lgnu/mapping/Namespace;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v0

    sput-object v0, Lgnu/kawa/lispexpr/LispLanguage;->bracket_list_sym:Lgnu/mapping/Symbol;

    .line 32
    sget-object v0, Lgnu/mapping/Namespace;->EmptyNamespace:Lgnu/mapping/Namespace;

    const-string v1, "$bracket-apply$"

    invoke-virtual {v0, v1}, Lgnu/mapping/Namespace;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v0

    sput-object v0, Lgnu/kawa/lispexpr/LispLanguage;->bracket_apply_sym:Lgnu/mapping/Symbol;

    .line 34
    new-instance v0, Lgnu/kawa/reflect/StaticFieldLocation;

    const-string v1, "gnu.kawa.functions.GetNamedPart"

    const-string v2, "getNamedPart"

    invoke-direct {v0, v1, v2}, Lgnu/kawa/reflect/StaticFieldLocation;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lgnu/kawa/lispexpr/LispLanguage;->getNamedPartLocation:Lgnu/kawa/reflect/StaticFieldLocation;

    .line 36
    sget-object v0, Lgnu/kawa/lispexpr/LispLanguage;->getNamedPartLocation:Lgnu/kawa/reflect/StaticFieldLocation;

    invoke-virtual {v0}, Lgnu/kawa/reflect/StaticFieldLocation;->setProcedure()V

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Lgnu/expr/Language;-><init>()V

    .line 39
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispLanguage;->createReadTable()Lgnu/kawa/lispexpr/ReadTable;

    move-result-object v0

    iput-object v0, p0, Lgnu/kawa/lispexpr/LispLanguage;->defaultReadTable:Lgnu/kawa/lispexpr/ReadTable;

    return-void
.end method

.method public static langSymbolToSymbol(Ljava/lang/Object;)Lgnu/mapping/Symbol;
    .locals 1
    .param p0, "sym"    # Ljava/lang/Object;

    .prologue
    .line 176
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    move-result-object v0

    check-cast v0, Lgnu/kawa/lispexpr/LispLanguage;

    invoke-virtual {v0, p0}, Lgnu/kawa/lispexpr/LispLanguage;->fromLangSymbol(Ljava/lang/Object;)Lgnu/mapping/Symbol;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public checkDefaultBinding(Lgnu/mapping/Symbol;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "name"    # Lgnu/mapping/Symbol;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 192
    const/4 v0, 0x0

    return-object v0
.end method

.method public abstract createReadTable()Lgnu/kawa/lispexpr/ReadTable;
.end method

.method public declFromField(Lgnu/expr/ModuleExp;Ljava/lang/Object;Lgnu/bytecode/Field;)Lgnu/expr/Declaration;
    .locals 3
    .param p1, "mod"    # Lgnu/expr/ModuleExp;
    .param p2, "fvalue"    # Ljava/lang/Object;
    .param p3, "fld"    # Lgnu/bytecode/Field;

    .prologue
    .line 129
    invoke-super {p0, p1, p2, p3}, Lgnu/expr/Language;->declFromField(Lgnu/expr/ModuleExp;Ljava/lang/Object;Lgnu/bytecode/Field;)Lgnu/expr/Declaration;

    move-result-object v0

    .line 130
    .local v0, "fdecl":Lgnu/expr/Declaration;
    invoke-virtual {p3}, Lgnu/bytecode/Field;->getModifiers()I

    move-result v2

    and-int/lit8 v2, v2, 0x10

    if-eqz v2, :cond_1

    const/4 v1, 0x1

    .line 131
    .local v1, "isFinal":Z
    :goto_0
    if-eqz v1, :cond_0

    instance-of v2, p2, Lkawa/lang/Syntax;

    if-eqz v2, :cond_0

    .line 132
    invoke-virtual {v0}, Lgnu/expr/Declaration;->setSyntax()V

    .line 133
    :cond_0
    return-object v0

    .line 130
    .end local v1    # "isFinal":Z
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected defSntxStFld(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "cname"    # Ljava/lang/String;

    .prologue
    .line 154
    invoke-static {p1}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, p2, v0}, Lgnu/kawa/lispexpr/LispLanguage;->defSntxStFld(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 155
    return-void
.end method

.method protected defSntxStFld(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "cname"    # Ljava/lang/String;
    .param p3, "fname"    # Ljava/lang/String;

    .prologue
    .line 144
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispLanguage;->hasSeparateFunctionNamespace()Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v1, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    .line 146
    .local v1, "property":Ljava/lang/Object;
    :goto_0
    iget-object v2, p0, Lgnu/kawa/lispexpr/LispLanguage;->environ:Lgnu/mapping/Environment;

    iget-object v3, p0, Lgnu/kawa/lispexpr/LispLanguage;->environ:Lgnu/mapping/Environment;

    invoke-virtual {v3, p1}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v3

    invoke-static {v2, v3, v1, p2, p3}, Lgnu/kawa/reflect/StaticFieldLocation;->define(Lgnu/mapping/Environment;Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Lgnu/kawa/reflect/StaticFieldLocation;

    move-result-object v0

    .line 149
    .local v0, "loc":Lgnu/kawa/reflect/StaticFieldLocation;
    invoke-virtual {v0}, Lgnu/kawa/reflect/StaticFieldLocation;->setSyntax()V

    .line 150
    return-void

    .line 144
    .end local v0    # "loc":Lgnu/kawa/reflect/StaticFieldLocation;
    .end local v1    # "property":Ljava/lang/Object;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected fromLangSymbol(Ljava/lang/Object;)Lgnu/mapping/Symbol;
    .locals 1
    .param p1, "sym"    # Ljava/lang/Object;

    .prologue
    .line 181
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 182
    check-cast p1, Ljava/lang/String;

    .end local p1    # "sym":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispLanguage;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object p1

    .line 183
    :goto_0
    return-object p1

    .restart local p1    # "sym":Ljava/lang/Object;
    :cond_0
    check-cast p1, Lgnu/mapping/Symbol;

    goto :goto_0
.end method

.method public getCompilation(Lgnu/text/Lexer;Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)Lgnu/expr/Compilation;
    .locals 1
    .param p1, "lexer"    # Lgnu/text/Lexer;
    .param p2, "messages"    # Lgnu/text/SourceMessages;
    .param p3, "lexical"    # Lgnu/expr/NameLookup;

    .prologue
    .line 51
    new-instance v0, Lkawa/lang/Translator;

    invoke-direct {v0, p0, p2, p3}, Lkawa/lang/Translator;-><init>(Lgnu/expr/Language;Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)V

    return-object v0
.end method

.method public getLexer(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;)Lgnu/text/Lexer;
    .locals 1
    .param p1, "inp"    # Lgnu/mapping/InPort;
    .param p2, "messages"    # Lgnu/text/SourceMessages;

    .prologue
    .line 46
    new-instance v0, Lgnu/kawa/lispexpr/LispReader;

    invoke-direct {v0, p1, p2}, Lgnu/kawa/lispexpr/LispReader;-><init>(Lgnu/text/LineBufferedReader;Lgnu/text/SourceMessages;)V

    return-object v0
.end method

.method public makeApply(Lgnu/expr/Expression;[Lgnu/expr/Expression;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "func"    # Lgnu/expr/Expression;
    .param p2, "args"    # [Lgnu/expr/Expression;

    .prologue
    .line 165
    new-instance v0, Lgnu/expr/ApplyExp;

    invoke-direct {v0, p1, p2}, Lgnu/expr/ApplyExp;-><init>(Lgnu/expr/Expression;[Lgnu/expr/Expression;)V

    return-object v0
.end method

.method public makeBody([Lgnu/expr/Expression;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "exps"    # [Lgnu/expr/Expression;

    .prologue
    .line 160
    new-instance v0, Lgnu/expr/BeginExp;

    invoke-direct {v0, p1}, Lgnu/expr/BeginExp;-><init>([Lgnu/expr/Expression;)V

    return-object v0
.end method

.method public parse(Lgnu/expr/Compilation;I)Z
    .locals 12
    .param p1, "comp"    # Lgnu/expr/Compilation;
    .param p2, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 57
    move-object v7, p1

    check-cast v7, Lkawa/lang/Translator;

    .line 58
    .local v7, "tr":Lkawa/lang/Translator;
    iget-object v2, v7, Lkawa/lang/Translator;->lexer:Lgnu/text/Lexer;

    .line 59
    .local v2, "lexer":Lgnu/text/Lexer;
    iget-object v3, v7, Lkawa/lang/Translator;->mainLambda:Lgnu/expr/ModuleExp;

    .line 60
    .local v3, "mexp":Lgnu/expr/ModuleExp;
    new-instance v1, Lgnu/mapping/Values;

    invoke-direct {v1}, Lgnu/mapping/Values;-><init>()V

    .local v1, "forms":Lgnu/mapping/Values;
    move-object v4, v2

    .line 61
    check-cast v4, Lgnu/kawa/lispexpr/LispReader;

    .line 62
    .local v4, "reader":Lgnu/kawa/lispexpr/LispReader;
    invoke-static {v7}, Lgnu/expr/Compilation;->setSaveCurrent(Lgnu/expr/Compilation;)Lgnu/expr/Compilation;

    move-result-object v5

    .line 65
    .local v5, "saveComp":Lgnu/expr/Compilation;
    :try_start_0
    iget-object v10, v7, Lkawa/lang/Translator;->pendingForm:Ljava/lang/Object;

    if-eqz v10, :cond_0

    .line 67
    iget-object v10, v7, Lkawa/lang/Translator;->pendingForm:Ljava/lang/Object;

    invoke-virtual {v7, v10, v3}, Lkawa/lang/Translator;->scanForm(Ljava/lang/Object;Lgnu/expr/ScopeExp;)V

    .line 68
    const/4 v10, 0x0

    iput-object v10, v7, Lkawa/lang/Translator;->pendingForm:Ljava/lang/Object;

    .line 72
    :cond_0
    invoke-virtual {v4}, Lgnu/kawa/lispexpr/LispReader;->readCommand()Ljava/lang/Object;

    move-result-object v6

    .line 73
    .local v6, "sexp":Ljava/lang/Object;
    sget-object v10, Lgnu/lists/Sequence;->eofValue:Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v6, v10, :cond_1

    .line 75
    and-int/lit8 v10, p2, 0x4

    if-eqz v10, :cond_2

    .line 115
    invoke-static {v5}, Lgnu/expr/Compilation;->restoreCurrent(Lgnu/expr/Compilation;)V

    .line 117
    :goto_0
    return v8

    .line 79
    :cond_1
    :try_start_1
    invoke-virtual {v7, v6, v3}, Lkawa/lang/Translator;->scanForm(Ljava/lang/Object;Lgnu/expr/ScopeExp;)V

    .line 80
    and-int/lit8 v10, p2, 0x4

    if-eqz v10, :cond_6

    .line 82
    invoke-virtual {v7}, Lkawa/lang/Translator;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v8

    invoke-virtual {v8}, Lgnu/text/SourceMessages;->seenErrors()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 87
    :goto_1
    invoke-virtual {v4}, Lgnu/kawa/lispexpr/LispReader;->peek()I

    move-result v0

    .line 88
    .local v0, "ch":I
    if-ltz v0, :cond_2

    const/16 v8, 0xd

    if-eq v0, v8, :cond_2

    const/16 v8, 0xa

    if-ne v0, v8, :cond_5

    .line 101
    .end local v0    # "ch":I
    :cond_2
    invoke-virtual {v2}, Lgnu/text/Lexer;->peek()I

    move-result v8

    const/16 v10, 0x29

    if-ne v8, v10, :cond_3

    .line 102
    const-string v8, "An unexpected close paren was read."

    invoke-virtual {v2, v8}, Lgnu/text/Lexer;->fatal(Ljava/lang/String;)V

    .line 105
    :cond_3
    invoke-virtual {v7, v3}, Lkawa/lang/Translator;->finishModule(Lgnu/expr/ModuleExp;)V

    .line 107
    and-int/lit8 v8, p2, 0x8

    if-nez v8, :cond_4

    .line 109
    const/4 v8, 0x0

    iput v8, v7, Lkawa/lang/Translator;->firstForm:I

    .line 111
    :cond_4
    const/4 v8, 0x4

    invoke-virtual {v7, v8}, Lkawa/lang/Translator;->setState(I)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 115
    invoke-static {v5}, Lgnu/expr/Compilation;->restoreCurrent(Lgnu/expr/Compilation;)V

    move v8, v9

    .line 117
    goto :goto_0

    .line 90
    .restart local v0    # "ch":I
    :cond_5
    :try_start_2
    invoke-virtual {v4}, Lgnu/kawa/lispexpr/LispReader;->skip()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 115
    .end local v0    # "ch":I
    .end local v6    # "sexp":Ljava/lang/Object;
    :catchall_0
    move-exception v8

    invoke-static {v5}, Lgnu/expr/Compilation;->restoreCurrent(Lgnu/expr/Compilation;)V

    throw v8

    .line 95
    .restart local v6    # "sexp":Ljava/lang/Object;
    :cond_6
    and-int/lit8 v10, p2, 0x8

    if-eqz v10, :cond_0

    :try_start_3
    invoke-virtual {v7}, Lkawa/lang/Translator;->getState()I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result v10

    const/4 v11, 0x2

    if-lt v10, v11, :cond_0

    .line 115
    invoke-static {v5}, Lgnu/expr/Compilation;->restoreCurrent(Lgnu/expr/Compilation;)V

    move v8, v9

    goto :goto_0
.end method

.method public resolve(Lgnu/expr/Compilation;)V
    .locals 2
    .param p1, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 123
    move-object v0, p1

    check-cast v0, Lkawa/lang/Translator;

    .line 124
    .local v0, "tr":Lkawa/lang/Translator;
    invoke-virtual {v0}, Lkawa/lang/Translator;->getModule()Lgnu/expr/ModuleExp;

    move-result-object v1

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->resolveModule(Lgnu/expr/ModuleExp;)V

    .line 125
    return-void
.end method

.method public selfEvaluatingSymbol(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 170
    instance-of v0, p1, Lgnu/expr/Keyword;

    return v0
.end method
