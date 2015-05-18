.class public Lgnu/kawa/lispexpr/ReaderParens;
.super Lgnu/kawa/lispexpr/ReadTableEntry;
.source "ReaderParens.java"


# static fields
.field private static instance:Lgnu/kawa/lispexpr/ReaderParens;


# instance fields
.field close:C

.field command:Ljava/lang/Object;

.field kind:I

.field open:C


# direct methods
.method public constructor <init>(CCILjava/lang/Object;)V
    .locals 0
    .param p1, "open"    # C
    .param p2, "close"    # C
    .param p3, "kind"    # I
    .param p4, "command"    # Ljava/lang/Object;

    .prologue
    .line 50
    invoke-direct {p0}, Lgnu/kawa/lispexpr/ReadTableEntry;-><init>()V

    .line 51
    iput-char p1, p0, Lgnu/kawa/lispexpr/ReaderParens;->open:C

    .line 52
    iput-char p2, p0, Lgnu/kawa/lispexpr/ReaderParens;->close:C

    .line 53
    iput p3, p0, Lgnu/kawa/lispexpr/ReaderParens;->kind:I

    .line 54
    iput-object p4, p0, Lgnu/kawa/lispexpr/ReaderParens;->command:Ljava/lang/Object;

    .line 55
    return-void
.end method

.method public static getInstance(CC)Lgnu/kawa/lispexpr/ReaderParens;
    .locals 1
    .param p0, "open"    # C
    .param p1, "close"    # C

    .prologue
    .line 24
    const/4 v0, 0x5

    invoke-static {p0, p1, v0}, Lgnu/kawa/lispexpr/ReaderParens;->getInstance(CCI)Lgnu/kawa/lispexpr/ReaderParens;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance(CCI)Lgnu/kawa/lispexpr/ReaderParens;
    .locals 2
    .param p0, "open"    # C
    .param p1, "close"    # C
    .param p2, "kind"    # I

    .prologue
    const/4 v1, 0x0

    .line 29
    const/16 v0, 0x28

    if-ne p0, v0, :cond_1

    const/16 v0, 0x29

    if-ne p1, v0, :cond_1

    const/4 v0, 0x5

    if-ne p2, v0, :cond_1

    .line 31
    sget-object v0, Lgnu/kawa/lispexpr/ReaderParens;->instance:Lgnu/kawa/lispexpr/ReaderParens;

    if-nez v0, :cond_0

    .line 32
    new-instance v0, Lgnu/kawa/lispexpr/ReaderParens;

    invoke-direct {v0, p0, p1, p2, v1}, Lgnu/kawa/lispexpr/ReaderParens;-><init>(CCILjava/lang/Object;)V

    sput-object v0, Lgnu/kawa/lispexpr/ReaderParens;->instance:Lgnu/kawa/lispexpr/ReaderParens;

    .line 33
    :cond_0
    sget-object v0, Lgnu/kawa/lispexpr/ReaderParens;->instance:Lgnu/kawa/lispexpr/ReaderParens;

    .line 37
    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Lgnu/kawa/lispexpr/ReaderParens;

    invoke-direct {v0, p0, p1, p2, v1}, Lgnu/kawa/lispexpr/ReaderParens;-><init>(CCILjava/lang/Object;)V

    goto :goto_0
.end method

.method public static getInstance(CCILjava/lang/Object;)Lgnu/kawa/lispexpr/ReaderParens;
    .locals 1
    .param p0, "open"    # C
    .param p1, "close"    # C
    .param p2, "kind"    # I
    .param p3, "command"    # Ljava/lang/Object;

    .prologue
    .line 43
    if-nez p3, :cond_0

    .line 44
    invoke-static {p0, p1, p2}, Lgnu/kawa/lispexpr/ReaderParens;->getInstance(CCI)Lgnu/kawa/lispexpr/ReaderParens;

    move-result-object v0

    .line 46
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lgnu/kawa/lispexpr/ReaderParens;

    invoke-direct {v0, p0, p1, p2, p3}, Lgnu/kawa/lispexpr/ReaderParens;-><init>(CCILjava/lang/Object;)V

    goto :goto_0
.end method

.method public static readList(Lgnu/kawa/lispexpr/LispReader;III)Ljava/lang/Object;
    .locals 20
    .param p0, "lexer"    # Lgnu/kawa/lispexpr/LispReader;
    .param p1, "ch"    # I
    .param p2, "count"    # I
    .param p3, "close"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 80
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->getPort()Lgnu/text/LineBufferedReader;

    move-result-object v10

    .line 81
    .local v10, "port":Lgnu/text/LineBufferedReader;
    const/16 v18, 0x5d

    move/from16 v0, p3

    move/from16 v1, v18

    if-ne v0, v1, :cond_0

    const/16 v18, 0x5b

    :goto_0
    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Lgnu/kawa/lispexpr/LispReader;->pushNesting(C)C

    move-result v12

    .line 82
    .local v12, "saveReadState":C
    invoke-virtual {v10}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v16

    .line 83
    .local v16, "startLine":I
    invoke-virtual {v10}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v15

    .line 86
    .local v15, "startColumn":I
    const/4 v6, 0x0

    .line 87
    .local v6, "last":Ljava/lang/Object;
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->makeNil()Ljava/lang/Object;

    move-result-object v8

    .line 88
    .local v8, "list":Ljava/lang/Object;
    const/4 v13, 0x0

    .line 89
    .local v13, "sawDot":Z
    const/4 v14, 0x0

    .line 90
    .local v14, "sawDotCdr":Z
    invoke-static {}, Lgnu/kawa/lispexpr/ReadTable;->getCurrent()Lgnu/kawa/lispexpr/ReadTable;

    move-result-object v11

    .line 93
    .end local v6    # "last":Ljava/lang/Object;
    .local v11, "readTable":Lgnu/kawa/lispexpr/ReadTable;
    :goto_1
    invoke-virtual {v10}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v7

    .line 94
    .local v7, "line":I
    invoke-virtual {v10}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v3

    .line 95
    .local v3, "column":I
    invoke-virtual {v10}, Lgnu/text/LineBufferedReader;->read()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result p1

    .line 96
    move/from16 v0, p1

    move/from16 v1, p3

    if-ne v0, v1, :cond_1

    .line 181
    :goto_2
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lgnu/kawa/lispexpr/LispReader;->popNesting(C)V

    return-object v8

    .line 81
    .end local v3    # "column":I
    .end local v7    # "line":I
    .end local v8    # "list":Ljava/lang/Object;
    .end local v11    # "readTable":Lgnu/kawa/lispexpr/ReadTable;
    .end local v12    # "saveReadState":C
    .end local v13    # "sawDot":Z
    .end local v14    # "sawDotCdr":Z
    .end local v15    # "startColumn":I
    .end local v16    # "startLine":I
    :cond_0
    const/16 v18, 0x28

    goto :goto_0

    .line 98
    .restart local v3    # "column":I
    .restart local v7    # "line":I
    .restart local v8    # "list":Ljava/lang/Object;
    .restart local v11    # "readTable":Lgnu/kawa/lispexpr/ReadTable;
    .restart local v12    # "saveReadState":C
    .restart local v13    # "sawDot":Z
    .restart local v14    # "sawDotCdr":Z
    .restart local v15    # "startColumn":I
    .restart local v16    # "startLine":I
    :cond_1
    if-gez p1, :cond_2

    .line 99
    :try_start_1
    const-string v18, "unexpected EOF in list starting here"

    add-int/lit8 v19, v16, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v0, v1, v2, v15}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;II)V

    .line 102
    :cond_2
    const/16 v18, 0x2e

    move/from16 v0, p1

    move/from16 v1, v18

    if-ne v0, v1, :cond_8

    .line 104
    invoke-virtual {v10}, Lgnu/text/LineBufferedReader;->peek()I

    move-result p1

    .line 105
    move/from16 v0, p1

    invoke-virtual {v11, v0}, Lgnu/kawa/lispexpr/ReadTable;->lookup(I)Lgnu/kawa/lispexpr/ReadTableEntry;

    move-result-object v4

    .line 106
    .local v4, "entry":Lgnu/kawa/lispexpr/ReadTableEntry;
    invoke-virtual {v4}, Lgnu/kawa/lispexpr/ReadTableEntry;->getKind()I

    move-result v5

    .line 107
    .local v5, "kind":I
    const/16 v18, 0x1

    move/from16 v0, v18

    if-eq v5, v0, :cond_3

    const/16 v18, 0x5

    move/from16 v0, v18

    if-eq v5, v0, :cond_3

    if-nez v5, :cond_7

    .line 111
    :cond_3
    invoke-virtual {v10}, Lgnu/text/LineBufferedReader;->skip()V

    .line 112
    add-int/lit8 v3, v3, 0x1

    .line 113
    move/from16 v0, p1

    move/from16 v1, p3

    if-ne v0, v1, :cond_4

    .line 115
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "unexpected \'"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move/from16 v0, p3

    int-to-char v0, v0

    move/from16 v19, v0

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "\' after \'.\'"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2

    .line 181
    .end local v3    # "column":I
    .end local v4    # "entry":Lgnu/kawa/lispexpr/ReadTableEntry;
    .end local v5    # "kind":I
    .end local v7    # "line":I
    .end local v8    # "list":Ljava/lang/Object;
    .end local v11    # "readTable":Lgnu/kawa/lispexpr/ReadTable;
    .end local v13    # "sawDot":Z
    .end local v14    # "sawDotCdr":Z
    :catchall_0
    move-exception v18

    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lgnu/kawa/lispexpr/LispReader;->popNesting(C)V

    throw v18

    .line 119
    .restart local v3    # "column":I
    .restart local v4    # "entry":Lgnu/kawa/lispexpr/ReadTableEntry;
    .restart local v5    # "kind":I
    .restart local v7    # "line":I
    .restart local v8    # "list":Ljava/lang/Object;
    .restart local v11    # "readTable":Lgnu/kawa/lispexpr/ReadTable;
    .restart local v13    # "sawDot":Z
    .restart local v14    # "sawDotCdr":Z
    :cond_4
    if-gez p1, :cond_5

    .line 120
    :try_start_2
    const-string v18, "unexpected EOF in list starting here"

    add-int/lit8 v19, v16, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v0, v1, v2, v15}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;II)V

    .line 122
    :cond_5
    if-eqz v13, :cond_6

    .line 124
    const-string v18, "multiple \'.\' in list"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    .line 125
    const/4 v14, 0x0

    .line 126
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->makeNil()Ljava/lang/Object;

    move-result-object v8

    .line 127
    const/4 v6, 0x0

    .line 129
    :cond_6
    const/4 v13, 0x1

    :goto_3
    move-object v9, v8

    .line 140
    .end local v5    # "kind":I
    .end local v8    # "list":Ljava/lang/Object;
    .local v9, "list":Ljava/lang/Object;
    :goto_4
    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-virtual {v0, v1, v4, v11}, Lgnu/kawa/lispexpr/LispReader;->readValues(ILgnu/kawa/lispexpr/ReadTableEntry;Lgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;

    move-result-object v17

    .line 141
    .local v17, "value":Ljava/lang/Object;
    sget-object v18, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    if-ne v0, v1, :cond_9

    move-object v8, v9

    .line 142
    .end local v9    # "list":Ljava/lang/Object;
    .restart local v8    # "list":Ljava/lang/Object;
    goto/16 :goto_1

    .line 134
    .end local v17    # "value":Ljava/lang/Object;
    .restart local v5    # "kind":I
    :cond_7
    const/16 p1, 0x2e

    .line 135
    invoke-static {}, Lgnu/kawa/lispexpr/ReadTableEntry;->getConstituentInstance()Lgnu/kawa/lispexpr/ReadTableEntry;

    move-result-object v4

    goto :goto_3

    .line 139
    .end local v4    # "entry":Lgnu/kawa/lispexpr/ReadTableEntry;
    .end local v5    # "kind":I
    :cond_8
    move/from16 v0, p1

    invoke-virtual {v11, v0}, Lgnu/kawa/lispexpr/ReadTable;->lookup(I)Lgnu/kawa/lispexpr/ReadTableEntry;

    move-result-object v4

    .restart local v4    # "entry":Lgnu/kawa/lispexpr/ReadTableEntry;
    move-object v9, v8

    .end local v8    # "list":Ljava/lang/Object;
    .restart local v9    # "list":Ljava/lang/Object;
    goto :goto_4

    .line 143
    .restart local v17    # "value":Ljava/lang/Object;
    :cond_9
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v11, v7, v3}, Lgnu/kawa/lispexpr/LispReader;->handlePostfix(Ljava/lang/Object;Lgnu/kawa/lispexpr/ReadTable;II)Ljava/lang/Object;

    move-result-object v17

    .line 150
    if-eqz v14, :cond_a

    .line 152
    const-string v18, "multiple values after \'.\'"

    move-object/from16 v0, p0

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    .line 153
    const/4 v6, 0x0

    .line 154
    .restart local v6    # "last":Ljava/lang/Object;
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->makeNil()Ljava/lang/Object;

    move-result-object v8

    .line 155
    .end local v9    # "list":Ljava/lang/Object;
    .restart local v8    # "list":Ljava/lang/Object;
    const/4 v14, 0x0

    .line 156
    goto/16 :goto_1

    .line 158
    .end local v6    # "last":Ljava/lang/Object;
    .end local v8    # "list":Ljava/lang/Object;
    .restart local v9    # "list":Ljava/lang/Object;
    :cond_a
    if-eqz v13, :cond_b

    .line 160
    const/4 v14, 0x1

    move-object/from16 v8, v17

    .line 171
    .end local v17    # "value":Ljava/lang/Object;
    .local v8, "value":Ljava/lang/Object;
    :goto_5
    if-nez v6, :cond_d

    .end local v9    # "list":Ljava/lang/Object;
    .local v8, "list":Ljava/lang/Object;
    move-object v9, v8

    .line 175
    .end local v8    # "list":Ljava/lang/Object;
    .restart local v9    # "list":Ljava/lang/Object;
    :goto_6
    move-object v6, v8

    .restart local v6    # "last":Ljava/lang/Object;
    move-object v8, v9

    .line 176
    .end local v9    # "list":Ljava/lang/Object;
    .restart local v8    # "list":Ljava/lang/Object;
    goto/16 :goto_1

    .line 164
    .end local v6    # "last":Ljava/lang/Object;
    .end local v8    # "list":Ljava/lang/Object;
    .restart local v9    # "list":Ljava/lang/Object;
    .restart local v17    # "value":Ljava/lang/Object;
    :cond_b
    if-nez v6, :cond_c

    .line 166
    move/from16 v7, v16

    .line 167
    add-int/lit8 v3, v15, -0x1

    .line 169
    :cond_c
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1, v7, v3}, Lgnu/kawa/lispexpr/LispReader;->makePair(Ljava/lang/Object;II)Lgnu/lists/Pair;

    move-result-object v17

    .local v17, "value":Lgnu/lists/Pair;
    move-object/from16 v8, v17

    .local v8, "value":Ljava/lang/Object;
    goto :goto_5

    .line 174
    .end local v17    # "value":Lgnu/lists/Pair;
    :cond_d
    move-object/from16 v0, p0

    invoke-virtual {v0, v6, v8}, Lgnu/kawa/lispexpr/LispReader;->setCdr(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_6
.end method


# virtual methods
.method public getKind()I
    .locals 1

    .prologue
    .line 17
    iget v0, p0, Lgnu/kawa/lispexpr/ReaderParens;->kind:I

    return v0
.end method

.method public read(Lgnu/text/Lexer;II)Ljava/lang/Object;
    .locals 7
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
    .line 63
    move-object v5, p1

    check-cast v5, Lgnu/kawa/lispexpr/LispReader;

    iget-char v6, p0, Lgnu/kawa/lispexpr/ReaderParens;->close:C

    invoke-static {v5, p2, p3, v6}, Lgnu/kawa/lispexpr/ReaderParens;->readList(Lgnu/kawa/lispexpr/LispReader;III)Ljava/lang/Object;

    move-result-object v2

    .line 64
    .local v2, "r":Ljava/lang/Object;
    iget-object v5, p0, Lgnu/kawa/lispexpr/ReaderParens;->command:Ljava/lang/Object;

    if-eqz v5, :cond_0

    .line 66
    invoke-virtual {p1}, Lgnu/text/Lexer;->getPort()Lgnu/text/LineBufferedReader;

    move-result-object v1

    .line 67
    .local v1, "port":Lgnu/text/LineBufferedReader;
    invoke-virtual {v1}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v4

    .line 68
    .local v4, "startLine":I
    invoke-virtual {v1}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v3

    .local v3, "startColumn":I
    move-object v5, p1

    .line 69
    check-cast v5, Lgnu/kawa/lispexpr/LispReader;

    iget-object v6, p0, Lgnu/kawa/lispexpr/ReaderParens;->command:Ljava/lang/Object;

    invoke-virtual {v5, v6, v4, v3}, Lgnu/kawa/lispexpr/LispReader;->makePair(Ljava/lang/Object;II)Lgnu/lists/Pair;

    move-result-object v0

    .line 70
    .local v0, "p":Lgnu/lists/Pair;
    check-cast p1, Lgnu/kawa/lispexpr/LispReader;

    .end local p1    # "in":Lgnu/text/Lexer;
    invoke-virtual {p1, v0, v2}, Lgnu/kawa/lispexpr/LispReader;->setCdr(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 71
    move-object v2, v0

    .line 73
    .end local v0    # "p":Lgnu/lists/Pair;
    .end local v1    # "port":Lgnu/text/LineBufferedReader;
    .end local v2    # "r":Ljava/lang/Object;
    .end local v3    # "startColumn":I
    .end local v4    # "startLine":I
    :cond_0
    return-object v2
.end method
