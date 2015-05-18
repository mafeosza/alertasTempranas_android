.class public Lkawa/standard/module_implements;
.super Lkawa/lang/Syntax;
.source "module_implements.java"


# static fields
.field public static final module_implements:Lkawa/standard/module_implements;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 9
    new-instance v0, Lkawa/standard/module_implements;

    invoke-direct {v0}, Lkawa/standard/module_implements;-><init>()V

    sput-object v0, Lkawa/standard/module_implements;->module_implements:Lkawa/standard/module_implements;

    .line 11
    sget-object v0, Lkawa/standard/module_implements;->module_implements:Lkawa/standard/module_implements;

    const-string v1, "module-implements"

    invoke-virtual {v0, v1}, Lkawa/standard/module_implements;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    return-void
.end method


# virtual methods
.method public scanForm(Lgnu/lists/Pair;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)V
    .locals 8
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "defs"    # Lgnu/expr/ScopeExp;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 15
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v0

    .line 16
    .local v0, "args":Ljava/lang/Object;
    const/4 v6, 0x0

    invoke-static {v0, v6}, Lgnu/lists/LList;->listLength(Ljava/lang/Object;Z)I

    move-result v3

    .line 17
    .local v3, "len":I
    if-gez v3, :cond_0

    .line 19
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "improper argument list for "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0}, Lkawa/standard/module_implements;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p3, v6}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    .line 32
    :goto_0
    return-void

    .line 22
    :cond_0
    new-array v2, v3, [Lgnu/bytecode/ClassType;

    .line 23
    .local v2, "interfaces":[Lgnu/bytecode/ClassType;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v3, :cond_1

    move-object v5, v0

    .line 25
    check-cast v5, Lgnu/lists/Pair;

    .line 26
    .local v5, "pair":Lgnu/lists/Pair;
    invoke-virtual {p3, v5}, Lkawa/lang/Translator;->exp2Type(Lgnu/lists/Pair;)Lgnu/bytecode/Type;

    move-result-object v6

    check-cast v6, Lgnu/bytecode/ClassType;

    aput-object v6, v2, v1

    .line 27
    invoke-virtual {v5}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v0

    .line 23
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 29
    .end local v5    # "pair":Lgnu/lists/Pair;
    :cond_1
    invoke-virtual {p3}, Lkawa/lang/Translator;->getModule()Lgnu/expr/ModuleExp;

    move-result-object v4

    .line 30
    .local v4, "module":Lgnu/expr/ModuleExp;
    invoke-virtual {v4, v2}, Lgnu/expr/ModuleExp;->setInterfaces([Lgnu/bytecode/ClassType;)V

    .line 31
    const/high16 v6, 0x20000

    invoke-virtual {v4, v6}, Lgnu/expr/ModuleExp;->setFlag(I)V

    goto :goto_0
.end method
