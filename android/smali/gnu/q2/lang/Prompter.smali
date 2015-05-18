.class Lgnu/q2/lang/Prompter;
.super Lgnu/mapping/Procedure1;
.source "Q2.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 106
    invoke-direct {p0}, Lgnu/mapping/Procedure1;-><init>()V

    return-void
.end method


# virtual methods
.method public apply1(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .param p1, "arg"    # Ljava/lang/Object;

    .prologue
    .line 110
    move-object v1, p1

    check-cast v1, Lgnu/mapping/InPort;

    .line 111
    .local v1, "port":Lgnu/mapping/InPort;
    invoke-virtual {v1}, Lgnu/mapping/InPort;->getLineNumber()I

    move-result v3

    add-int/lit8 v0, v3, 0x1

    .line 112
    .local v0, "line":I
    iget-char v2, v1, Lgnu/mapping/InPort;->readState:C

    .line 113
    .local v2, "state":C
    const/16 v3, 0x5d

    if-ne v2, v3, :cond_0

    .line 114
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "<!--Q2:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "-->"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 119
    :goto_0
    return-object v3

    .line 117
    :cond_0
    const/16 v3, 0xa

    if-ne v2, v3, :cond_1

    .line 118
    const/16 v2, 0x2d

    .line 119
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "#|--Q2:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "|#"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method
