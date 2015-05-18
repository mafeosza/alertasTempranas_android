.class public Lkawa/standard/IfFeature;
.super Ljava/lang/Object;
.source "IfFeature.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static hasFeature(Ljava/lang/String;)Z
    .locals 8
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 22
    const-string v6, "kawa"

    if-ne p0, v6, :cond_1

    .line 85
    :cond_0
    :goto_0
    return v4

    .line 24
    :cond_1
    const-string v6, "srfi-0"

    if-eq p0, v6, :cond_0

    .line 27
    const-string v6, "srfi-4"

    if-eq p0, v6, :cond_0

    .line 29
    const-string v6, "srfi-6"

    if-eq p0, v6, :cond_0

    .line 31
    const-string v6, "srfi-8"

    if-eq p0, v6, :cond_0

    .line 33
    const-string v6, "srfi-9"

    if-eq p0, v6, :cond_0

    .line 35
    const-string v6, "srfi-11"

    if-eq p0, v6, :cond_0

    .line 37
    const-string v6, "srfi-16"

    if-eq p0, v6, :cond_0

    .line 39
    const-string v6, "srfi-17"

    if-eq p0, v6, :cond_0

    .line 41
    const-string v6, "srfi-23"

    if-eq p0, v6, :cond_0

    .line 43
    const-string v6, "srfi-25"

    if-eq p0, v6, :cond_0

    .line 45
    const-string v6, "srfi-26"

    if-eq p0, v6, :cond_0

    .line 47
    const-string v6, "srfi-28"

    if-eq p0, v6, :cond_0

    .line 49
    const-string v6, "srfi-30"

    if-eq p0, v6, :cond_0

    .line 51
    const-string v6, "srfi-39"

    if-eq p0, v6, :cond_0

    .line 71
    const-string v6, "in-http-server"

    if-eq p0, v6, :cond_2

    const-string v6, "in-servlet"

    if-ne p0, v6, :cond_4

    .line 73
    :cond_2
    invoke-static {}, Lgnu/expr/ModuleContext;->getContext()Lgnu/expr/ModuleContext;

    move-result-object v6

    invoke-virtual {v6}, Lgnu/expr/ModuleContext;->getFlags()I

    move-result v2

    .line 74
    .local v2, "mflags":I
    const-string v6, "in-http-server"

    if-ne p0, v6, :cond_3

    .line 75
    sget v6, Lgnu/expr/ModuleContext;->IN_HTTP_SERVER:I

    and-int/2addr v6, v2

    if-nez v6, :cond_0

    move v4, v5

    goto :goto_0

    .line 76
    :cond_3
    const-string v6, "in-servlet"

    if-ne p0, v6, :cond_4

    .line 77
    sget v6, Lgnu/expr/ModuleContext;->IN_SERVLET:I

    and-int/2addr v6, v2

    if-nez v6, :cond_0

    move v4, v5

    goto :goto_0

    .line 80
    .end local v2    # "mflags":I
    :cond_4
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "%provide%"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    .line 81
    .local v3, "provide_name":Ljava/lang/String;
    invoke-static {}, Lgnu/expr/Compilation;->getCurrent()Lgnu/expr/Compilation;

    move-result-object v0

    .line 82
    .local v0, "comp":Lgnu/expr/Compilation;
    const/4 v6, -0x1

    invoke-virtual {v0, v3, v6}, Lgnu/expr/Compilation;->lookup(Ljava/lang/Object;I)Lgnu/expr/Declaration;

    move-result-object v1

    .line 83
    .local v1, "decl":Lgnu/expr/Declaration;
    if-eqz v1, :cond_5

    const-wide/32 v6, 0x10000

    invoke-virtual {v1, v6, v7}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v6

    if-eqz v6, :cond_0

    :cond_5
    move v4, v5

    .line 85
    goto/16 :goto_0
.end method

.method public static testFeature(Ljava/lang/Object;)Z
    .locals 2
    .param p0, "form"    # Ljava/lang/Object;

    .prologue
    .line 10
    instance-of v1, p0, Lkawa/lang/SyntaxForm;

    if-eqz v1, :cond_0

    move-object v0, p0

    .line 12
    check-cast v0, Lkawa/lang/SyntaxForm;

    .line 13
    .local v0, "sf":Lkawa/lang/SyntaxForm;
    invoke-interface {v0}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object p0

    .line 15
    .end local v0    # "sf":Lkawa/lang/SyntaxForm;
    :cond_0
    instance-of v1, p0, Ljava/lang/String;

    if-nez v1, :cond_1

    instance-of v1, p0, Lgnu/mapping/SimpleSymbol;

    if-eqz v1, :cond_2

    .line 16
    :cond_1
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lkawa/standard/IfFeature;->hasFeature(Ljava/lang/String;)Z

    move-result v1

    .line 17
    :goto_0
    return v1

    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method
