.class Lgnu/kawa/functions/LispIterationFormat;
.super Lgnu/text/ReportFormat;
.source "LispFormat.java"


# instance fields
.field atLeastOnce:Z

.field body:Ljava/text/Format;

.field maxIterations:I

.field seenAt:Z

.field seenColon:Z


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 935
    invoke-direct {p0}, Lgnu/text/ReportFormat;-><init>()V

    return-void
.end method

.method public static format(Ljava/text/Format;I[Ljava/lang/Object;ILjava/io/Writer;ZZ)I
    .locals 7
    .param p0, "body"    # Ljava/text/Format;
    .param p1, "maxIterations"    # I
    .param p2, "args"    # [Ljava/lang/Object;
    .param p3, "start"    # I
    .param p4, "dst"    # Ljava/io/Writer;
    .param p5, "seenColon"    # Z
    .param p6, "atLeastOnce"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 949
    const/4 v2, 0x0

    .line 951
    .local v2, "i":I
    :goto_0
    if-ne v2, p1, :cond_1

    const/4 v4, -0x1

    if-eq p1, v4, :cond_1

    .line 977
    :cond_0
    :goto_1
    return p3

    .line 953
    :cond_1
    array-length v4, p2

    if-ne p3, v4, :cond_2

    if-gtz v2, :cond_0

    if-eqz p6, :cond_0

    .line 955
    :cond_2
    if-eqz p5, :cond_5

    .line 957
    aget-object v0, p2, p3

    .line 958
    .local v0, "curArg":Ljava/lang/Object;
    invoke-static {v0}, Lgnu/kawa/functions/LispFormat;->asArray(Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    .line 959
    .local v1, "curArr":[Ljava/lang/Object;
    if-nez v1, :cond_3

    .line 962
    :cond_3
    const/4 v4, 0x0

    invoke-static {p0, v1, v4, p4, v6}, Lgnu/text/ReportFormat;->format(Ljava/text/Format;[Ljava/lang/Object;ILjava/io/Writer;Ljava/text/FieldPosition;)I

    move-result v3

    .line 963
    .local v3, "result":I
    add-int/lit8 p3, p3, 0x1

    .line 964
    invoke-static {v3}, Lgnu/text/ReportFormat;->resultCode(I)I

    move-result v4

    const/16 v5, 0xf2

    if-eq v4, v5, :cond_0

    .line 949
    .end local v0    # "curArg":Ljava/lang/Object;
    .end local v1    # "curArr":[Ljava/lang/Object;
    .end local v3    # "result":I
    :cond_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 969
    :cond_5
    invoke-static {p0, p2, p3, p4, v6}, Lgnu/text/ReportFormat;->format(Ljava/text/Format;[Ljava/lang/Object;ILjava/io/Writer;Ljava/text/FieldPosition;)I

    move-result p3

    .line 970
    if-gez p3, :cond_4

    .line 972
    invoke-static {p3}, Lgnu/text/ReportFormat;->nextArg(I)I

    move-result p3

    .line 973
    goto :goto_1
.end method


# virtual methods
.method public format([Ljava/lang/Object;ILjava/io/Writer;Ljava/text/FieldPosition;)I
    .locals 11
    .param p1, "args"    # [Ljava/lang/Object;
    .param p2, "start"    # I
    .param p3, "dst"    # Ljava/io/Writer;
    .param p4, "fpos"    # Ljava/text/FieldPosition;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 984
    iget v3, p0, Lgnu/kawa/functions/LispIterationFormat;->maxIterations:I

    const/4 v4, -0x1

    invoke-static {v3, v4, p1, p2}, Lgnu/kawa/functions/LispIterationFormat;->getParam(II[Ljava/lang/Object;I)I

    move-result v1

    .line 986
    .local v1, "maxIterations":I
    iget v3, p0, Lgnu/kawa/functions/LispIterationFormat;->maxIterations:I

    const/high16 v4, -0x60000000

    if-ne v3, v4, :cond_0

    add-int/lit8 p2, p2, 0x1

    .line 988
    :cond_0
    iget-object v0, p0, Lgnu/kawa/functions/LispIterationFormat;->body:Ljava/text/Format;

    .line 989
    .local v0, "body":Ljava/text/Format;
    if-nez v0, :cond_1

    .line 992
    add-int/lit8 v10, p2, 0x1

    .end local p2    # "start":I
    .local v10, "start":I
    aget-object v7, p1, p2

    .line 993
    .local v7, "arg":Ljava/lang/Object;
    instance-of v3, v7, Ljava/text/Format;

    if-eqz v3, :cond_2

    move-object v0, v7

    .line 994
    check-cast v0, Ljava/text/Format;

    move p2, v10

    .line 1008
    .end local v7    # "arg":Ljava/lang/Object;
    .end local v10    # "start":I
    .restart local p2    # "start":I
    :cond_1
    :goto_0
    iget-boolean v3, p0, Lgnu/kawa/functions/LispIterationFormat;->seenAt:Z

    if-eqz v3, :cond_3

    .line 1010
    iget-boolean v5, p0, Lgnu/kawa/functions/LispIterationFormat;->seenColon:Z

    iget-boolean v6, p0, Lgnu/kawa/functions/LispIterationFormat;->atLeastOnce:Z

    move-object v2, p1

    move v3, p2

    move-object v4, p3

    invoke-static/range {v0 .. v6}, Lgnu/kawa/functions/LispIterationFormat;->format(Ljava/text/Format;I[Ljava/lang/Object;ILjava/io/Writer;ZZ)I

    move-result v3

    .line 1022
    :goto_1
    return v3

    .line 999
    .end local p2    # "start":I
    .restart local v7    # "arg":Ljava/lang/Object;
    .restart local v10    # "start":I
    :cond_2
    :try_start_0
    new-instance v8, Lgnu/kawa/functions/LispFormat;

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v8, v3}, Lgnu/kawa/functions/LispFormat;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local v0    # "body":Ljava/text/Format;
    .local v8, "body":Ljava/text/Format;
    move-object v0, v8

    .end local v8    # "body":Ljava/text/Format;
    .restart local v0    # "body":Ljava/text/Format;
    move p2, v10

    .line 1005
    .end local v10    # "start":I
    .restart local p2    # "start":I
    goto :goto_0

    .line 1001
    .end local p2    # "start":I
    .restart local v10    # "start":I
    :catch_0
    move-exception v9

    .line 1003
    .local v9, "ex":Ljava/lang/Exception;
    const-string v3, "<invalid argument for \"~{~}\" format>"

    invoke-static {p3, v3}, Lgnu/kawa/functions/LispIterationFormat;->print(Ljava/io/Writer;Ljava/lang/String;)V

    .line 1004
    array-length v3, p1

    move p2, v10

    .end local v10    # "start":I
    .restart local p2    # "start":I
    goto :goto_1

    .line 1015
    .end local v7    # "arg":Ljava/lang/Object;
    .end local v9    # "ex":Ljava/lang/Exception;
    :cond_3
    aget-object v7, p1, p2

    .line 1016
    .restart local v7    # "arg":Ljava/lang/Object;
    invoke-static {v7}, Lgnu/kawa/functions/LispFormat;->asArray(Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    .line 1017
    .local v2, "curArgs":[Ljava/lang/Object;
    if-nez v2, :cond_4

    .line 1018
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "{"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "}"

    invoke-virtual {v4}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p3, v3}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 1022
    :goto_2
    add-int/lit8 v3, p2, 0x1

    goto :goto_1

    .line 1020
    :cond_4
    const/4 v3, 0x0

    iget-boolean v5, p0, Lgnu/kawa/functions/LispIterationFormat;->seenColon:Z

    iget-boolean v6, p0, Lgnu/kawa/functions/LispIterationFormat;->atLeastOnce:Z

    move-object v4, p3

    invoke-static/range {v0 .. v6}, Lgnu/kawa/functions/LispIterationFormat;->format(Ljava/text/Format;I[Ljava/lang/Object;ILjava/io/Writer;ZZ)I

    goto :goto_2
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1028
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 1029
    .local v0, "sbuf":Ljava/lang/StringBuffer;
    const-string v1, "LispIterationFormat["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1030
    iget-object v1, p0, Lgnu/kawa/functions/LispIterationFormat;->body:Ljava/text/Format;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 1031
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1032
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
