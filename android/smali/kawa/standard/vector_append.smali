.class public Lkawa/standard/vector_append;
.super Lgnu/mapping/ProcedureN;
.source "vector_append.java"


# static fields
.field public static final vectorAppend:Lkawa/standard/vector_append;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 12
    new-instance v0, Lkawa/standard/vector_append;

    const-string v1, "vector-append"

    invoke-direct {v0, v1}, Lkawa/standard/vector_append;-><init>(Ljava/lang/String;)V

    sput-object v0, Lkawa/standard/vector_append;->vectorAppend:Lkawa/standard/vector_append;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lgnu/mapping/ProcedureN;-><init>(Ljava/lang/String;)V

    .line 18
    return-void
.end method

.method public static apply$V([Ljava/lang/Object;)Lgnu/lists/FVector;
    .locals 15
    .param p0, "args"    # [Ljava/lang/Object;

    .prologue
    .line 27
    const/4 v4, 0x0

    .line 28
    .local v4, "length":I
    array-length v1, p0

    .line 29
    .local v1, "args_length":I
    move v2, v1

    .local v2, "i":I
    :goto_0
    add-int/lit8 v2, v2, -0x1

    if-ltz v2, :cond_2

    .line 31
    aget-object v0, p0, v2

    .line 32
    .local v0, "arg":Ljava/lang/Object;
    instance-of v12, v0, Lgnu/lists/FVector;

    if-eqz v12, :cond_0

    .line 33
    check-cast v0, Lgnu/lists/FVector;

    .end local v0    # "arg":Ljava/lang/Object;
    invoke-virtual {v0}, Lgnu/lists/FVector;->size()I

    move-result v12

    add-int/2addr v4, v12

    goto :goto_0

    .line 36
    .restart local v0    # "arg":Ljava/lang/Object;
    :cond_0
    const/4 v12, 0x0

    invoke-static {v0, v12}, Lgnu/lists/LList;->listLength(Ljava/lang/Object;Z)I

    move-result v5

    .line 37
    .local v5, "n":I
    if-gez v5, :cond_1

    .line 38
    new-instance v12, Lgnu/mapping/WrongType;

    sget-object v13, Lkawa/standard/vector_append;->vectorAppend:Lkawa/standard/vector_append;

    const-string v14, "list or vector"

    invoke-direct {v12, v13, v2, v0, v14}, Lgnu/mapping/WrongType;-><init>(Lgnu/mapping/Procedure;ILjava/lang/Object;Ljava/lang/String;)V

    throw v12

    .line 39
    :cond_1
    add-int/2addr v4, v5

    goto :goto_0

    .line 42
    .end local v0    # "arg":Ljava/lang/Object;
    .end local v5    # "n":I
    :cond_2
    new-array v9, v4, [Ljava/lang/Object;

    .line 43
    .local v9, "result":[Ljava/lang/Object;
    const/4 v7, 0x0

    .line 44
    .local v7, "position":I
    const/4 v2, 0x0

    :goto_1
    if-ge v2, v1, :cond_6

    .line 46
    aget-object v0, p0, v2

    .line 47
    .restart local v0    # "arg":Ljava/lang/Object;
    instance-of v12, v0, Lgnu/lists/FVector;

    if-eqz v12, :cond_5

    move-object v10, v0

    .line 49
    check-cast v10, Lgnu/lists/FVector;

    .line 50
    .local v10, "vec":Lgnu/lists/FVector;
    invoke-virtual {v10}, Lgnu/lists/FVector;->size()I

    move-result v11

    .line 51
    .local v11, "vec_length":I
    const/4 v3, 0x0

    .local v3, "j":I
    move v8, v7

    .end local v7    # "position":I
    .local v8, "position":I
    :goto_2
    if-ge v3, v11, :cond_3

    .line 52
    add-int/lit8 v7, v8, 0x1

    .end local v8    # "position":I
    .restart local v7    # "position":I
    invoke-virtual {v10, v3}, Lgnu/lists/FVector;->get(I)Ljava/lang/Object;

    move-result-object v12

    aput-object v12, v9, v8

    .line 51
    add-int/lit8 v3, v3, 0x1

    move v8, v7

    .end local v7    # "position":I
    .restart local v8    # "position":I
    goto :goto_2

    :cond_3
    move v7, v8

    .line 44
    .end local v3    # "j":I
    .end local v8    # "position":I
    .end local v10    # "vec":Lgnu/lists/FVector;
    .end local v11    # "vec_length":I
    .restart local v7    # "position":I
    :cond_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 54
    :cond_5
    instance-of v12, v0, Lgnu/lists/Pair;

    if-eqz v12, :cond_4

    .line 56
    :goto_3
    sget-object v12, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v0, v12, :cond_4

    move-object v6, v0

    .line 58
    check-cast v6, Lgnu/lists/Pair;

    .line 59
    .local v6, "pair":Lgnu/lists/Pair;
    add-int/lit8 v8, v7, 0x1

    .end local v7    # "position":I
    .restart local v8    # "position":I
    invoke-virtual {v6}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v12

    aput-object v12, v9, v7

    .line 60
    invoke-virtual {v6}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v0

    move v7, v8

    .line 61
    .end local v8    # "position":I
    .restart local v7    # "position":I
    goto :goto_3

    .line 64
    .end local v0    # "arg":Ljava/lang/Object;
    .end local v6    # "pair":Lgnu/lists/Pair;
    :cond_6
    new-instance v12, Lgnu/lists/FVector;

    invoke-direct {v12, v9}, Lgnu/lists/FVector;-><init>([Ljava/lang/Object;)V

    return-object v12
.end method


# virtual methods
.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 22
    invoke-static {p1}, Lkawa/standard/vector_append;->apply$V([Ljava/lang/Object;)Lgnu/lists/FVector;

    move-result-object v0

    return-object v0
.end method
