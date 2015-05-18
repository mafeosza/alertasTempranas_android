.class public Lkawa/standard/char_ready_p;
.super Ljava/lang/Object;
.source "char_ready_p.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static ready(Ljava/lang/Object;)Z
    .locals 4
    .param p0, "arg1"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 8
    :try_start_0
    instance-of v2, p0, Ljava/io/InputStream;

    if-eqz v2, :cond_1

    .line 9
    check-cast p0, Ljava/io/InputStream;

    .end local p0    # "arg1":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/io/InputStream;->available()I

    move-result v2

    if-lez v2, :cond_0

    const/4 v1, 0x1

    .line 17
    .local v0, "ex":Ljava/io/IOException;
    .restart local p0    # "arg1":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v1

    .line 10
    .end local v0    # "ex":Ljava/io/IOException;
    :cond_1
    instance-of v2, p0, Ljava/io/Reader;

    if-eqz v2, :cond_2

    .line 11
    check-cast p0, Ljava/io/Reader;

    .end local p0    # "arg1":Ljava/lang/Object;
    invoke-virtual {p0}, Ljava/io/Reader;->ready()Z

    move-result v1

    goto :goto_0

    .line 13
    .restart local p0    # "arg1":Ljava/lang/Object;
    :cond_2
    new-instance v2, Ljava/lang/ClassCastException;

    const-string v3, "invalid argument to char-ready?"

    invoke-direct {v2, v3}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 15
    :catch_0
    move-exception v0

    .line 17
    .restart local v0    # "ex":Ljava/io/IOException;
    goto :goto_0
.end method
