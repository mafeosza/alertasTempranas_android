.class public abstract Lgnu/mapping/Procedure3;
.super Lgnu/mapping/Procedure;
.source "Procedure3.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lgnu/mapping/Procedure;-><init>()V

    .line 13
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "n"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lgnu/mapping/Procedure;-><init>(Ljava/lang/String;)V

    .line 18
    return-void
.end method


# virtual methods
.method public apply0()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 24
    new-instance v0, Lgnu/mapping/WrongArguments;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lgnu/mapping/WrongArguments;-><init>(Lgnu/mapping/Procedure;I)V

    throw v0
.end method

.method public apply1(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "arg1"    # Ljava/lang/Object;

    .prologue
    .line 29
    new-instance v0, Lgnu/mapping/WrongArguments;

    const/4 v1, 0x1

    invoke-direct {v0, p0, v1}, Lgnu/mapping/WrongArguments;-><init>(Lgnu/mapping/Procedure;I)V

    throw v0
.end method

.method public apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 34
    new-instance v0, Lgnu/mapping/WrongArguments;

    const/4 v1, 0x2

    invoke-direct {v0, p0, v1}, Lgnu/mapping/WrongArguments;-><init>(Lgnu/mapping/Procedure;I)V

    throw v0
.end method

.method public abstract apply3(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation
.end method

.method public apply4(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;
    .param p3, "arg3"    # Ljava/lang/Object;
    .param p4, "arg4"    # Ljava/lang/Object;

    .prologue
    .line 41
    new-instance v0, Lgnu/mapping/WrongArguments;

    const/4 v1, 0x4

    invoke-direct {v0, p0, v1}, Lgnu/mapping/WrongArguments;-><init>(Lgnu/mapping/Procedure;I)V

    throw v0
.end method

.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 46
    array-length v0, p1

    const/4 v1, 0x3

    if-eq v0, v1, :cond_0

    .line 47
    new-instance v0, Lgnu/mapping/WrongArguments;

    array-length v1, p1

    invoke-direct {v0, p0, v1}, Lgnu/mapping/WrongArguments;-><init>(Lgnu/mapping/Procedure;I)V

    throw v0

    .line 48
    :cond_0
    const/4 v0, 0x0

    aget-object v0, p1, v0

    const/4 v1, 0x1

    aget-object v1, p1, v1

    const/4 v2, 0x2

    aget-object v2, p1, v2

    invoke-virtual {p0, v0, v1, v2}, Lgnu/mapping/Procedure3;->apply3(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public numArgs()I
    .locals 1

    .prologue
    .line 20
    const/16 v0, 0x3003

    return v0
.end method
