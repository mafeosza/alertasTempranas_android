.class public Lgnu/expr/Symbols;
.super Ljava/lang/Object;
.source "Symbols.java"


# static fields
.field private static gensym_counter:I


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    return-void
.end method

.method static declared-synchronized generateInt()I
    .locals 2

    .prologue
    .line 20
    const-class v1, Lgnu/expr/Symbols;

    monitor-enter v1

    :try_start_0
    sget v0, Lgnu/expr/Symbols;->gensym_counter:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lgnu/expr/Symbols;->gensym_counter:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static final gentemp()Lgnu/mapping/SimpleSymbol;
    .locals 2

    .prologue
    .line 59
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "GS."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lgnu/expr/Symbols;->generateInt()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lgnu/mapping/SimpleSymbol;->valueOf(Ljava/lang/String;)Lgnu/mapping/SimpleSymbol;

    move-result-object v0

    return-object v0
.end method

.method public static final intern(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 74
    invoke-static {p0}, Lgnu/expr/Symbols;->make(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static make(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 69
    invoke-virtual {p0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static print(Ljava/lang/String;Lgnu/lists/Consumer;)V
    .locals 7
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "out"    # Lgnu/lists/Consumer;

    .prologue
    const/16 v6, 0x2e

    const/4 v5, 0x1

    .line 79
    instance-of v4, p1, Lgnu/mapping/OutPort;

    if-eqz v4, :cond_5

    move-object v4, p1

    check-cast v4, Lgnu/mapping/OutPort;

    iget-boolean v4, v4, Lgnu/mapping/OutPort;->printReadable:Z

    if-eqz v4, :cond_5

    move v3, v5

    .line 81
    .local v3, "readable":Z
    :goto_0
    if-eqz v3, :cond_6

    .line 83
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 84
    .local v2, "len":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v2, :cond_7

    .line 86
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 87
    .local v0, "ch":C
    invoke-static {v0}, Ljava/lang/Character;->isLowerCase(C)Z

    move-result v4

    if-nez v4, :cond_4

    const/16 v4, 0x21

    if-eq v0, v4, :cond_4

    const/16 v4, 0x24

    if-eq v0, v4, :cond_4

    const/16 v4, 0x25

    if-eq v0, v4, :cond_4

    const/16 v4, 0x26

    if-eq v0, v4, :cond_4

    const/16 v4, 0x2a

    if-eq v0, v4, :cond_4

    const/16 v4, 0x2f

    if-eq v0, v4, :cond_4

    const/16 v4, 0x3a

    if-eq v0, v4, :cond_4

    const/16 v4, 0x3c

    if-eq v0, v4, :cond_4

    const/16 v4, 0x3d

    if-eq v0, v4, :cond_4

    const/16 v4, 0x3e

    if-eq v0, v4, :cond_4

    const/16 v4, 0x3f

    if-eq v0, v4, :cond_4

    const/16 v4, 0x7e

    if-eq v0, v4, :cond_4

    const/16 v4, 0x5f

    if-eq v0, v4, :cond_4

    const/16 v4, 0x5e

    if-eq v0, v4, :cond_4

    const/16 v4, 0x2b

    if-eq v0, v4, :cond_0

    const/16 v4, 0x2d

    if-ne v0, v4, :cond_1

    :cond_0
    if-gtz v1, :cond_4

    if-eq v2, v5, :cond_4

    :cond_1
    invoke-static {v0}, Ljava/lang/Character;->isDigit(C)Z

    move-result v4

    if-eqz v4, :cond_2

    if-gtz v1, :cond_4

    :cond_2
    if-ne v0, v6, :cond_3

    if-eqz v1, :cond_4

    add-int/lit8 v4, v1, -0x1

    invoke-virtual {p0, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-eq v4, v6, :cond_4

    .line 95
    :cond_3
    const/16 v4, 0x5c

    invoke-interface {p1, v4}, Lgnu/lists/Consumer;->write(I)V

    .line 96
    :cond_4
    invoke-interface {p1, v0}, Lgnu/lists/Consumer;->write(I)V

    .line 84
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 79
    .end local v0    # "ch":C
    .end local v1    # "i":I
    .end local v2    # "len":I
    .end local v3    # "readable":Z
    :cond_5
    const/4 v3, 0x0

    goto :goto_0

    .line 100
    .restart local v3    # "readable":Z
    :cond_6
    invoke-interface {p1, p0}, Lgnu/lists/Consumer;->write(Ljava/lang/String;)V

    .line 101
    :cond_7
    return-void
.end method
