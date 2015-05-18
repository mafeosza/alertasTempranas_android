.class Lgnu/q2/lang/Q2ReaderParens;
.super Lgnu/kawa/lispexpr/ReaderDispatchMisc;
.source "Q2Read.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 359
    invoke-direct {p0}, Lgnu/kawa/lispexpr/ReaderDispatchMisc;-><init>()V

    return-void
.end method


# virtual methods
.method public read(Lgnu/text/Lexer;II)Ljava/lang/Object;
    .locals 6
    .param p1, "in"    # Lgnu/text/Lexer;
    .param p2, "ch"    # I
    .param p3, "count"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 364
    move-object v1, p1

    check-cast v1, Lgnu/q2/lang/Q2Read;

    .line 365
    .local v1, "reader":Lgnu/q2/lang/Q2Read;
    const/16 v4, 0x28

    invoke-virtual {v1, v4}, Lgnu/q2/lang/Q2Read;->pushNesting(C)C

    move-result v3

    .line 368
    .local v3, "saveReadState":C
    const/4 v4, 0x1

    :try_start_0
    invoke-virtual {v1, v4}, Lgnu/q2/lang/Q2Read;->readCommand(Z)Ljava/lang/Object;

    move-result-object v2

    .line 370
    .local v2, "result":Ljava/lang/Object;
    invoke-virtual {v1}, Lgnu/q2/lang/Q2Read;->getPort()Lgnu/text/LineBufferedReader;

    move-result-object v0

    .line 371
    .local v0, "port":Lgnu/text/LineBufferedReader;
    invoke-virtual {v0}, Lgnu/text/LineBufferedReader;->read()I

    move-result v4

    const/16 v5, 0x29

    if-eq v4, v5, :cond_0

    .line 372
    const-string v4, "missing \')\'"

    invoke-virtual {v1, v4}, Lgnu/q2/lang/Q2Read;->error(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 377
    :cond_0
    invoke-virtual {v1, v3}, Lgnu/q2/lang/Q2Read;->popNesting(C)V

    return-object v2

    .end local v0    # "port":Lgnu/text/LineBufferedReader;
    .end local v2    # "result":Ljava/lang/Object;
    :catchall_0
    move-exception v4

    invoke-virtual {v1, v3}, Lgnu/q2/lang/Q2Read;->popNesting(C)V

    throw v4
.end method
