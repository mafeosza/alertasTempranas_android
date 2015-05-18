.class public Lkawa/standard/append;
.super Lgnu/mapping/ProcedureN;
.source "append.java"


# static fields
.field public static final append:Lkawa/standard/append;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 12
    new-instance v0, Lkawa/standard/append;

    invoke-direct {v0}, Lkawa/standard/append;-><init>()V

    sput-object v0, Lkawa/standard/append;->append:Lkawa/standard/append;

    .line 13
    sget-object v0, Lkawa/standard/append;->append:Lkawa/standard/append;

    const-string v1, "append"

    invoke-virtual {v0, v1}, Lkawa/standard/append;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lgnu/mapping/ProcedureN;-><init>()V

    return-void
.end method

.method public static append$V([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 13
    .param p0, "args"    # [Ljava/lang/Object;

    .prologue
    .line 22
    array-length v1, p0

    .line 23
    .local v1, "count":I
    if-nez v1, :cond_1

    .line 24
    sget-object v8, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .line 50
    :cond_0
    return-object v8

    .line 25
    :cond_1
    add-int/lit8 v8, v1, -0x1

    aget-object v7, p0, v8

    .line 26
    .local v7, "result":Ljava/lang/Object;
    add-int/lit8 v2, v1, -0x1

    .local v2, "i":I
    move-object v8, v7

    .end local v7    # "result":Ljava/lang/Object;
    :goto_0
    add-int/lit8 v2, v2, -0x1

    if-ltz v2, :cond_0

    .line 28
    aget-object v4, p0, v2

    .line 29
    .local v4, "list":Ljava/lang/Object;
    const/4 v0, 0x0

    .line 30
    .local v0, "copy":Ljava/lang/Object;
    const/4 v3, 0x0

    .local v3, "last":Lgnu/lists/Pair;
    move-object v7, v0

    .line 31
    .end local v0    # "copy":Ljava/lang/Object;
    :goto_1
    instance-of v9, v4, Lgnu/lists/Pair;

    if-eqz v9, :cond_3

    move-object v5, v4

    .line 33
    check-cast v5, Lgnu/lists/Pair;

    .line 34
    .local v5, "list_pair":Lgnu/lists/Pair;
    new-instance v6, Lgnu/lists/Pair;

    invoke-virtual {v5}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v9

    const/4 v10, 0x0

    invoke-direct {v6, v9, v10}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 35
    .local v6, "new_pair":Lgnu/lists/Pair;
    if-nez v3, :cond_2

    .line 36
    move-object v0, v6

    .line 39
    :goto_2
    move-object v3, v6

    .line 40
    invoke-virtual {v5}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    move-object v7, v0

    .line 41
    goto :goto_1

    .line 38
    :cond_2
    invoke-virtual {v3, v6}, Lgnu/lists/Pair;->setCdr(Ljava/lang/Object;)V

    move-object v0, v7

    goto :goto_2

    .line 42
    .end local v5    # "list_pair":Lgnu/lists/Pair;
    .end local v6    # "new_pair":Lgnu/lists/Pair;
    :cond_3
    sget-object v9, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v4, v9, :cond_4

    .line 43
    new-instance v8, Lgnu/mapping/WrongType;

    sget-object v9, Lkawa/standard/append;->append:Lkawa/standard/append;

    add-int/lit8 v10, v2, 0x1

    aget-object v11, p0, v2

    const-string v12, "list"

    invoke-direct {v8, v9, v10, v11, v12}, Lgnu/mapping/WrongType;-><init>(Lgnu/mapping/Procedure;ILjava/lang/Object;Ljava/lang/String;)V

    throw v8

    .line 44
    :cond_4
    if-eqz v3, :cond_5

    .line 46
    invoke-virtual {v3, v8}, Lgnu/lists/Pair;->setCdr(Ljava/lang/Object;)V

    :goto_3
    move-object v8, v7

    .line 49
    goto :goto_0

    :cond_5
    move-object v7, v8

    goto :goto_3
.end method


# virtual methods
.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 17
    invoke-static {p1}, Lkawa/standard/append;->append$V([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
