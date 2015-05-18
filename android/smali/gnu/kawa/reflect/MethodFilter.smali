.class Lgnu/kawa/reflect/MethodFilter;
.super Ljava/lang/Object;
.source "ClassMethods.java"

# interfaces
.implements Lgnu/bytecode/Filter;


# instance fields
.field caller:Lgnu/bytecode/ClassType;

.field modifiers:I

.field modmask:I

.field name:Ljava/lang/String;

.field nlen:I

.field receiver:Lgnu/bytecode/ObjectType;


# direct methods
.method public constructor <init>(Ljava/lang/String;IILgnu/bytecode/ClassType;Lgnu/bytecode/ObjectType;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "modifiers"    # I
    .param p3, "modmask"    # I
    .param p4, "caller"    # Lgnu/bytecode/ClassType;
    .param p5, "receiver"    # Lgnu/bytecode/ObjectType;

    .prologue
    .line 306
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 307
    iput-object p1, p0, Lgnu/kawa/reflect/MethodFilter;->name:Ljava/lang/String;

    .line 308
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    iput v0, p0, Lgnu/kawa/reflect/MethodFilter;->nlen:I

    .line 309
    iput p2, p0, Lgnu/kawa/reflect/MethodFilter;->modifiers:I

    .line 310
    iput p3, p0, Lgnu/kawa/reflect/MethodFilter;->modmask:I

    .line 311
    iput-object p4, p0, Lgnu/kawa/reflect/MethodFilter;->caller:Lgnu/bytecode/ClassType;

    .line 312
    iput-object p5, p0, Lgnu/kawa/reflect/MethodFilter;->receiver:Lgnu/bytecode/ObjectType;

    .line 313
    return-void
.end method


# virtual methods
.method public select(Ljava/lang/Object;)Z
    .locals 10
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v7, 0x0

    .line 317
    move-object v2, p1

    check-cast v2, Lgnu/bytecode/Method;

    .line 318
    .local v2, "method":Lgnu/bytecode/Method;
    invoke-virtual {v2}, Lgnu/bytecode/Method;->getName()Ljava/lang/String;

    move-result-object v5

    .line 319
    .local v5, "mname":Ljava/lang/String;
    invoke-virtual {v2}, Lgnu/bytecode/Method;->getModifiers()I

    move-result v4

    .line 320
    .local v4, "mmods":I
    iget v6, p0, Lgnu/kawa/reflect/MethodFilter;->modmask:I

    and-int/2addr v6, v4

    iget v8, p0, Lgnu/kawa/reflect/MethodFilter;->modifiers:I

    if-ne v6, v8, :cond_0

    and-int/lit16 v6, v4, 0x1000

    if-nez v6, :cond_0

    iget-object v6, p0, Lgnu/kawa/reflect/MethodFilter;->name:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 335
    :cond_0
    :goto_0
    return v7

    .line 324
    :cond_1
    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v3

    .line 326
    .local v3, "mlen":I
    iget v6, p0, Lgnu/kawa/reflect/MethodFilter;->nlen:I

    if-eq v3, v6, :cond_3

    iget v6, p0, Lgnu/kawa/reflect/MethodFilter;->nlen:I

    add-int/lit8 v6, v6, 0x2

    if-ne v3, v6, :cond_2

    iget v6, p0, Lgnu/kawa/reflect/MethodFilter;->nlen:I

    invoke-virtual {v5, v6}, Ljava/lang/String;->charAt(I)C

    move-result v6

    const/16 v8, 0x24

    if-ne v6, v8, :cond_2

    iget v6, p0, Lgnu/kawa/reflect/MethodFilter;->nlen:I

    add-int/lit8 v6, v6, 0x1

    invoke-virtual {v5, v6}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .local v0, "c":C
    const/16 v6, 0x56

    if-eq v0, v6, :cond_3

    const/16 v6, 0x58

    if-eq v0, v6, :cond_3

    .end local v0    # "c":C
    :cond_2
    iget v6, p0, Lgnu/kawa/reflect/MethodFilter;->nlen:I

    add-int/lit8 v6, v6, 0x4

    if-ne v3, v6, :cond_0

    const-string v6, "$V$X"

    invoke-virtual {v5, v6}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 333
    :cond_3
    iget-object v6, p0, Lgnu/kawa/reflect/MethodFilter;->receiver:Lgnu/bytecode/ObjectType;

    instance-of v6, v6, Lgnu/bytecode/ClassType;

    if-eqz v6, :cond_5

    iget-object v6, p0, Lgnu/kawa/reflect/MethodFilter;->receiver:Lgnu/bytecode/ObjectType;

    check-cast v6, Lgnu/bytecode/ClassType;

    move-object v1, v6

    .line 335
    .local v1, "declaring":Lgnu/bytecode/ClassType;
    :goto_1
    iget-object v6, p0, Lgnu/kawa/reflect/MethodFilter;->caller:Lgnu/bytecode/ClassType;

    if-eqz v6, :cond_4

    iget-object v6, p0, Lgnu/kawa/reflect/MethodFilter;->caller:Lgnu/bytecode/ClassType;

    iget-object v8, p0, Lgnu/kawa/reflect/MethodFilter;->receiver:Lgnu/bytecode/ObjectType;

    invoke-virtual {v2}, Lgnu/bytecode/Method;->getModifiers()I

    move-result v9

    invoke-virtual {v6, v1, v8, v9}, Lgnu/bytecode/ClassType;->isAccessible(Lgnu/bytecode/ClassType;Lgnu/bytecode/ObjectType;I)Z

    move-result v6

    if-eqz v6, :cond_6

    :cond_4
    const/4 v6, 0x1

    :goto_2
    move v7, v6

    goto :goto_0

    .line 333
    .end local v1    # "declaring":Lgnu/bytecode/ClassType;
    :cond_5
    invoke-virtual {v2}, Lgnu/bytecode/Method;->getDeclaringClass()Lgnu/bytecode/ClassType;

    move-result-object v1

    goto :goto_1

    .restart local v1    # "declaring":Lgnu/bytecode/ClassType;
    :cond_6
    move v6, v7

    .line 335
    goto :goto_2
.end method
