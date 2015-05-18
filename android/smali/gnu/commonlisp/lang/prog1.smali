.class public Lgnu/commonlisp/lang/prog1;
.super Lkawa/lang/Syntax;
.source "prog1.java"


# static fields
.field public static final prog1:Lgnu/commonlisp/lang/prog1;

.field public static final prog2:Lgnu/commonlisp/lang/prog1;


# instance fields
.field index:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 11
    new-instance v0, Lgnu/commonlisp/lang/prog1;

    const-string v1, "prog1"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lgnu/commonlisp/lang/prog1;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lgnu/commonlisp/lang/prog1;->prog1:Lgnu/commonlisp/lang/prog1;

    .line 12
    new-instance v0, Lgnu/commonlisp/lang/prog1;

    const-string v1, "prog2"

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lgnu/commonlisp/lang/prog1;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lgnu/commonlisp/lang/prog1;->prog2:Lgnu/commonlisp/lang/prog1;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "index"    # I

    .prologue
    .line 15
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 16
    iput p2, p0, Lgnu/commonlisp/lang/prog1;->index:I

    .line 17
    invoke-virtual {p0, p1}, Lgnu/commonlisp/lang/prog1;->setName(Ljava/lang/String;)V

    .line 18
    return-void
.end method


# virtual methods
.method public rewrite(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 10
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 22
    invoke-static {p1}, Lgnu/lists/LList;->length(Ljava/lang/Object;)I

    move-result v5

    .line 23
    .local v5, "nexps":I
    iget v7, p0, Lgnu/commonlisp/lang/prog1;->index:I

    if-ge v5, v7, :cond_0

    .line 24
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "too few expressions in "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p0}, Lgnu/commonlisp/lang/prog1;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p2, v7}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v4

    .line 49
    :goto_0
    return-object v4

    .line 25
    :cond_0
    iget v7, p0, Lgnu/commonlisp/lang/prog1;->index:I

    const/4 v8, 0x2

    if-ne v7, v8, :cond_1

    move-object v6, p1

    .line 27
    check-cast v6, Lgnu/lists/Pair;

    .line 28
    .local v6, "pair":Lgnu/lists/Pair;
    new-instance v4, Lgnu/expr/BeginExp;

    invoke-virtual {v6}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {p2, v7}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v7

    sget-object v8, Lgnu/commonlisp/lang/prog1;->prog1:Lgnu/commonlisp/lang/prog1;

    invoke-virtual {v6}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v8, v9, p2}, Lgnu/commonlisp/lang/prog1;->rewrite(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v8

    invoke-direct {v4, v7, v8}, Lgnu/expr/BeginExp;-><init>(Lgnu/expr/Expression;Lgnu/expr/Expression;)V

    goto :goto_0

    .line 33
    .end local v6    # "pair":Lgnu/lists/Pair;
    :cond_1
    const/4 v7, 0x1

    new-array v3, v7, [Lgnu/expr/Expression;

    .line 34
    .local v3, "inits":[Lgnu/expr/Expression;
    new-instance v4, Lgnu/expr/LetExp;

    invoke-direct {v4, v3}, Lgnu/expr/LetExp;-><init>([Lgnu/expr/Expression;)V

    .line 35
    .local v4, "let":Lgnu/expr/LetExp;
    new-array v0, v5, [Lgnu/expr/Expression;

    .local v0, "body":[Lgnu/expr/Expression;
    move-object v6, p1

    .line 36
    check-cast v6, Lgnu/lists/Pair;

    .line 37
    .restart local v6    # "pair":Lgnu/lists/Pair;
    const/4 v7, 0x0

    invoke-virtual {v6}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {p2, v8}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v8

    aput-object v8, v3, v7

    .line 38
    invoke-virtual {v6}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p1

    .line 39
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    add-int/lit8 v7, v5, -0x1

    if-ge v2, v7, :cond_2

    move-object v6, p1

    .line 41
    check-cast v6, Lgnu/lists/Pair;

    .line 42
    invoke-virtual {v6}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {p2, v7}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v7

    aput-object v7, v0, v2

    .line 43
    invoke-virtual {v6}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p1

    .line 39
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 45
    :cond_2
    const/4 v7, 0x0

    check-cast v7, Ljava/lang/Object;

    invoke-virtual {v4, v7}, Lgnu/expr/LetExp;->addDeclaration(Ljava/lang/Object;)Lgnu/expr/Declaration;

    move-result-object v1

    .line 46
    .local v1, "decl":Lgnu/expr/Declaration;
    add-int/lit8 v7, v5, -0x1

    new-instance v8, Lgnu/expr/ReferenceExp;

    invoke-direct {v8, v1}, Lgnu/expr/ReferenceExp;-><init>(Lgnu/expr/Declaration;)V

    aput-object v8, v0, v7

    .line 47
    invoke-static {v0}, Lgnu/expr/BeginExp;->canonicalize([Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v7

    iput-object v7, v4, Lgnu/expr/LetExp;->body:Lgnu/expr/Expression;

    .line 48
    invoke-virtual {p2}, Lkawa/lang/Translator;->mustCompileHere()V

    goto :goto_0
.end method
