.class public Lgnu/mapping/Setter1;
.super Lgnu/mapping/Setter;
.source "Setter1.java"


# direct methods
.method public constructor <init>(Lgnu/mapping/Procedure;)V
    .locals 0
    .param p1, "getter"    # Lgnu/mapping/Procedure;

    .prologue
    .line 7
    invoke-direct {p0, p1}, Lgnu/mapping/Setter;-><init>(Lgnu/mapping/Procedure;)V

    return-void
.end method


# virtual methods
.method public apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "arg"    # Ljava/lang/Object;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 12
    iget-object v0, p0, Lgnu/mapping/Setter1;->getter:Lgnu/mapping/Procedure;

    invoke-virtual {v0, p1, p2}, Lgnu/mapping/Procedure;->set1(Ljava/lang/Object;Ljava/lang/Object;)V

    sget-object v0, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    return-object v0
.end method

.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 16
    array-length v0, p1

    .line 17
    .local v0, "nargs":I
    const/4 v1, 0x2

    if-eq v0, v1, :cond_0

    .line 18
    new-instance v1, Lgnu/mapping/WrongArguments;

    invoke-direct {v1, p0, v0}, Lgnu/mapping/WrongArguments;-><init>(Lgnu/mapping/Procedure;I)V

    throw v1

    .line 19
    :cond_0
    iget-object v1, p0, Lgnu/mapping/Setter1;->getter:Lgnu/mapping/Procedure;

    const/4 v2, 0x0

    aget-object v2, p1, v2

    const/4 v3, 0x1

    aget-object v3, p1, v3

    invoke-virtual {v1, v2, v3}, Lgnu/mapping/Procedure;->set1(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 20
    sget-object v1, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    return-object v1
.end method

.method public numArgs()I
    .locals 1

    .prologue
    .line 9
    const/16 v0, 0x2002

    return v0
.end method
