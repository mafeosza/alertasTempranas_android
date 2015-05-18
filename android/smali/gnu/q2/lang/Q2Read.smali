.class public Lgnu/q2/lang/Q2Read;
.super Lgnu/kawa/lispexpr/LispReader;
.source "Q2Read.java"


# instance fields
.field curIndentation:I

.field expressionStartColumn:I

.field expressionStartFile:Ljava/lang/String;

.field expressionStartLine:I


# direct methods
.method public constructor <init>(Lgnu/mapping/InPort;)V
    .locals 0
    .param p1, "port"    # Lgnu/mapping/InPort;

    .prologue
    .line 21
    invoke-direct {p0, p1}, Lgnu/kawa/lispexpr/LispReader;-><init>(Lgnu/text/LineBufferedReader;)V

    .line 22
    invoke-virtual {p0}, Lgnu/q2/lang/Q2Read;->init()V

    .line 23
    return-void
.end method

.method public constructor <init>(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;)V
    .locals 0
    .param p1, "port"    # Lgnu/mapping/InPort;
    .param p2, "messages"    # Lgnu/text/SourceMessages;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lgnu/kawa/lispexpr/LispReader;-><init>(Lgnu/text/LineBufferedReader;Lgnu/text/SourceMessages;)V

    .line 28
    invoke-virtual {p0}, Lgnu/q2/lang/Q2Read;->init()V

    .line 29
    return-void
.end method

.method public static readObject(Lgnu/mapping/InPort;)Ljava/lang/Object;
    .locals 1
    .param p0, "port"    # Lgnu/mapping/InPort;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 343
    new-instance v0, Lgnu/q2/lang/Q2Read;

    invoke-direct {v0, p0}, Lgnu/q2/lang/Q2Read;-><init>(Lgnu/mapping/InPort;)V

    invoke-virtual {v0}, Lgnu/q2/lang/Q2Read;->readObject()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method init()V
    .locals 2

    .prologue
    .line 16
    iget-object v0, p0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    check-cast v0, Lgnu/mapping/InPort;

    const/16 v1, 0x20

    iput-char v1, v0, Lgnu/mapping/InPort;->readState:C

    .line 17
    return-void
.end method

.method public readCommand()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 149
    invoke-virtual {p0}, Lgnu/q2/lang/Q2Read;->skipIndentation()I

    move-result v0

    .line 150
    .local v0, "indent":I
    if-gez v0, :cond_1

    .line 151
    sget-object v1, Lgnu/lists/Sequence;->eofValue:Ljava/lang/Object;

    .line 156
    :cond_0
    :goto_0
    return-object v1

    .line 152
    :cond_1
    iput v0, p0, Lgnu/q2/lang/Q2Read;->curIndentation:I

    .line 153
    invoke-virtual {p0}, Lgnu/q2/lang/Q2Read;->readIndentCommand()Ljava/lang/Object;

    move-result-object v1

    .line 154
    .local v1, "result":Ljava/lang/Object;
    iget-boolean v2, p0, Lgnu/q2/lang/Q2Read;->interactive:Z

    if-nez v2, :cond_0

    .line 155
    iget-object v2, p0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v2}, Lgnu/text/LineBufferedReader;->reset()V

    goto :goto_0
.end method

.method public readCommand(Z)Ljava/lang/Object;
    .locals 22
    .param p1, "forceList"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 241
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v9

    .line 242
    .local v9, "line":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v18

    .line 243
    .local v18, "startColumn":I
    move/from16 v8, v18

    .line 244
    .local v8, "lastColumn":I
    sget-object v14, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .line 245
    .local v14, "obj":Lgnu/lists/LList;
    const/16 v17, 0x0

    .local v17, "pair":Lgnu/lists/PairWithPosition;
    const/4 v7, 0x0

    .line 248
    .end local v14    # "obj":Lgnu/lists/LList;
    .local v7, "last":Lgnu/lists/PairWithPosition;
    :cond_0
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->read()I

    move-result v3

    .line 249
    .local v3, "ch":I
    if-gez v3, :cond_3

    .line 330
    :cond_1
    if-nez p1, :cond_2

    .line 332
    if-ne v14, v7, :cond_11

    .line 333
    invoke-virtual {v7}, Lgnu/lists/PairWithPosition;->getCar()Ljava/lang/Object;

    move-result-object v14

    .line 337
    :cond_2
    :goto_1
    return-object v14

    .line 251
    :cond_3
    const/16 v19, 0x20

    move/from16 v0, v19

    if-eq v3, v0, :cond_0

    const/16 v19, 0x9

    move/from16 v0, v19

    if-eq v3, v0, :cond_0

    .line 253
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->unread()V

    .line 254
    const/16 v19, 0x29

    move/from16 v0, v19

    if-eq v3, v0, :cond_1

    .line 256
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v9

    .line 257
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v4

    .line 258
    .local v4, "column":I
    :cond_4
    const/16 v19, 0xd

    move/from16 v0, v19

    if-eq v3, v0, :cond_5

    const/16 v19, 0xa

    move/from16 v0, v19

    if-ne v3, v0, :cond_6

    .line 260
    :cond_5
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->singleLine()Z

    move-result v19

    if-nez v19, :cond_2

    .line 262
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->read()I

    move-result v3

    .line 263
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->skipIndentation()I

    .line 264
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v4

    .line 265
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->peek()I

    move-result v3

    .line 266
    move/from16 v0, v18

    if-gt v4, v0, :cond_4

    .line 269
    :cond_6
    move/from16 v0, v18

    if-gt v4, v0, :cond_7

    if-nez v7, :cond_1

    .line 272
    :cond_7
    if-ne v4, v8, :cond_8

    if-eqz v7, :cond_8

    .line 273
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->readCommand()Ljava/lang/Object;

    move-result-object v12

    .line 308
    .local v12, "next":Ljava/lang/Object;
    :goto_2
    sget-object v19, Lgnu/lists/Sequence;->eofValue:Ljava/lang/Object;

    move-object/from16 v0, v19

    if-eq v12, v0, :cond_1

    .line 310
    move v8, v4

    .line 311
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lgnu/text/LineBufferedReader;->getName()Ljava/lang/String;

    move-result-object v6

    .line 312
    .local v6, "filename":Ljava/lang/String;
    sget-object v19, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    add-int/lit8 v20, v9, 0x1

    add-int/lit8 v21, v4, 0x1

    move-object/from16 v0, v19

    move/from16 v1, v20

    move/from16 v2, v21

    invoke-static {v12, v0, v6, v1, v2}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;II)Lgnu/lists/PairWithPosition;

    move-result-object v5

    .line 314
    .local v5, "cur":Lgnu/lists/PairWithPosition;
    if-nez v7, :cond_f

    .line 316
    move-object/from16 v17, v5

    .line 317
    move-object v14, v5

    .line 328
    :goto_3
    move-object v7, v5

    .line 329
    goto/16 :goto_0

    .line 274
    .end local v5    # "cur":Lgnu/lists/PairWithPosition;
    .end local v6    # "filename":Ljava/lang/String;
    .end local v12    # "next":Ljava/lang/Object;
    :cond_8
    if-ge v4, v8, :cond_e

    if-eqz v7, :cond_e

    .line 276
    move-object/from16 v15, v17

    .line 279
    .local v15, "p":Lgnu/lists/PairWithPosition;
    :goto_4
    invoke-virtual {v15}, Lgnu/lists/PairWithPosition;->getCdr()Ljava/lang/Object;

    move-result-object v10

    .line 280
    .local v10, "n":Ljava/lang/Object;
    sget-object v19, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v19

    if-ne v10, v0, :cond_a

    .line 304
    :cond_9
    :goto_5
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->readCommand()Ljava/lang/Object;

    move-result-object v12

    .line 305
    .restart local v12    # "next":Ljava/lang/Object;
    goto :goto_2

    .end local v12    # "next":Ljava/lang/Object;
    :cond_a
    move-object v13, v10

    .line 282
    check-cast v13, Lgnu/lists/PairWithPosition;

    .line 283
    .local v13, "np":Lgnu/lists/PairWithPosition;
    invoke-virtual {v13}, Lgnu/lists/PairWithPosition;->getColumnNumber()I

    move-result v19

    add-int/lit8 v16, v19, -0x1

    .line 284
    .local v16, "pColumn":I
    move/from16 v0, v16

    if-lt v0, v4, :cond_d

    .line 286
    move/from16 v0, v16

    if-le v0, v4, :cond_b

    .line 287
    const/16 v19, 0x65

    const-string v20, "some tokens on previous line indented more than current line"

    move-object/from16 v0, p0

    move/from16 v1, v19

    move-object/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lgnu/q2/lang/Q2Read;->error(CLjava/lang/String;)V

    .line 288
    :cond_b
    invoke-virtual {v13}, Lgnu/lists/PairWithPosition;->getCdr()Ljava/lang/Object;

    move-result-object v10

    .line 289
    sget-object v19, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v19

    if-eq v10, v0, :cond_9

    move-object/from16 v19, v10

    .line 291
    check-cast v19, Lgnu/lists/PairWithPosition;

    invoke-virtual/range {v19 .. v19}, Lgnu/lists/PairWithPosition;->getColumnNumber()I

    move-result v19

    add-int/lit8 v19, v19, -0x1

    move/from16 v0, v19

    if-ne v0, v4, :cond_c

    move-object v15, v10

    .line 293
    check-cast v15, Lgnu/lists/PairWithPosition;

    .line 294
    goto :goto_4

    .line 296
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v19, v0

    invoke-virtual/range {v19 .. v19}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v19

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v13, v1, v4}, Lgnu/q2/lang/Q2Read;->makePair(Ljava/lang/Object;II)Lgnu/lists/Pair;

    move-result-object v7

    .end local v7    # "last":Lgnu/lists/PairWithPosition;
    check-cast v7, Lgnu/lists/PairWithPosition;

    .line 298
    .restart local v7    # "last":Lgnu/lists/PairWithPosition;
    invoke-virtual {v15, v7}, Lgnu/lists/PairWithPosition;->setCdrBackdoor(Ljava/lang/Object;)V

    goto :goto_5

    .line 302
    :cond_d
    move-object v15, v13

    .line 303
    goto :goto_4

    .line 307
    .end local v10    # "n":Ljava/lang/Object;
    .end local v13    # "np":Lgnu/lists/PairWithPosition;
    .end local v15    # "p":Lgnu/lists/PairWithPosition;
    .end local v16    # "pColumn":I
    :cond_e
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->readObject()Ljava/lang/Object;

    move-result-object v12

    .restart local v12    # "next":Ljava/lang/Object;
    goto/16 :goto_2

    .line 319
    .restart local v5    # "cur":Lgnu/lists/PairWithPosition;
    .restart local v6    # "filename":Ljava/lang/String;
    :cond_f
    invoke-virtual {v7}, Lgnu/lists/PairWithPosition;->getCar()Ljava/lang/Object;

    move-result-object v19

    move-object/from16 v0, v19

    instance-of v0, v0, Lgnu/expr/Keyword;

    move/from16 v19, v0

    if-eqz v19, :cond_10

    .line 321
    new-instance v11, Lgnu/expr/QuoteExp;

    invoke-virtual {v7}, Lgnu/lists/PairWithPosition;->getCar()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lgnu/expr/Keyword;

    invoke-virtual/range {v19 .. v19}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-direct {v11, v0}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    .line 322
    .local v11, "name":Lgnu/expr/QuoteExp;
    new-instance v19, Lgnu/lists/PairWithPosition;

    sget-object v20, Lgnu/kawa/xml/MakeAttribute;->makeAttribute:Lgnu/kawa/xml/MakeAttribute;

    new-instance v21, Lgnu/lists/PairWithPosition;

    move-object/from16 v0, v21

    invoke-direct {v0, v7, v11, v5}, Lgnu/lists/PairWithPosition;-><init>(Lgnu/text/SourceLocator;Ljava/lang/Object;Ljava/lang/Object;)V

    move-object/from16 v0, v19

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    invoke-direct {v0, v7, v1, v2}, Lgnu/lists/PairWithPosition;-><init>(Lgnu/text/SourceLocator;Ljava/lang/Object;Ljava/lang/Object;)V

    move-object/from16 v0, v19

    invoke-virtual {v7, v0}, Lgnu/lists/PairWithPosition;->setCar(Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 327
    .end local v11    # "name":Lgnu/expr/QuoteExp;
    :cond_10
    invoke-virtual {v7, v5}, Lgnu/lists/PairWithPosition;->setCdrBackdoor(Ljava/lang/Object;)V

    goto/16 :goto_3

    .line 334
    .end local v4    # "column":I
    .end local v5    # "cur":Lgnu/lists/PairWithPosition;
    .end local v6    # "filename":Ljava/lang/String;
    .end local v12    # "next":Ljava/lang/Object;
    :cond_11
    if-nez v7, :cond_2

    .line 335
    sget-object v14, Lgnu/expr/QuoteExp;->voidExp:Lgnu/expr/QuoteExp;

    .local v14, "obj":Lgnu/expr/QuoteExp;
    goto/16 :goto_1
.end method

.method readIndentCommand()Ljava/lang/Object;
    .locals 19
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 69
    move-object/from16 v0, p0

    iget v14, v0, Lgnu/q2/lang/Q2Read;->curIndentation:I

    .line 70
    .local v14, "startIndentation":I
    sget-object v12, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .line 71
    .local v12, "rresult":Lgnu/lists/LList;
    sget-object v8, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .line 72
    .local v8, "obj":Lgnu/lists/LList;
    const/4 v9, 0x0

    .local v9, "pair":Lgnu/lists/PairWithPosition;
    const/4 v6, 0x0

    .line 76
    .local v6, "last":Lgnu/lists/PairWithPosition;
    :cond_0
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->read()I

    move-result v3

    .line 77
    .local v3, "ch":I
    if-gez v3, :cond_2

    .line 138
    :cond_1
    :goto_1
    invoke-static {v12}, Lgnu/lists/LList;->reverseInPlace(Ljava/lang/Object;)Lgnu/lists/LList;

    move-result-object v17

    return-object v17

    .line 79
    :cond_2
    const/16 v17, 0x20

    move/from16 v0, v17

    if-eq v3, v0, :cond_0

    const/16 v17, 0x9

    move/from16 v0, v17

    if-eq v3, v0, :cond_0

    .line 81
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->unread()V

    .line 82
    const/16 v17, 0x29

    move/from16 v0, v17

    if-eq v3, v0, :cond_1

    .line 84
    const/16 v17, 0xd

    move/from16 v0, v17

    if-eq v3, v0, :cond_3

    const/16 v17, 0xa

    move/from16 v0, v17

    if-ne v3, v0, :cond_9

    .line 86
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->singleLine()Z

    move-result v17

    if-nez v17, :cond_1

    .line 88
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->read()I

    move-result v3

    .line 89
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v17, v0

    const v18, 0x7fffffff

    invoke-virtual/range {v17 .. v18}, Lgnu/text/LineBufferedReader;->mark(I)V

    .line 90
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->skipIndentation()I

    move-result v15

    .line 91
    .local v15, "subIndentation":I
    sget-object v10, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .line 92
    .local v10, "qresult":Lgnu/lists/LList;
    move-object/from16 v0, p0

    iput v15, v0, Lgnu/q2/lang/Q2Read;->curIndentation:I

    .line 95
    :goto_2
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/q2/lang/Q2Read;->curIndentation:I

    move/from16 v17, v0

    const/16 v18, -0x1

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_5

    .line 123
    :cond_4
    :goto_3
    sget-object v17, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v17

    if-eq v10, v0, :cond_1

    .line 125
    new-instance v11, Lgnu/lists/Pair;

    sget-object v17, Lkawa/standard/begin;->begin:Lkawa/standard/begin;

    invoke-static {v10}, Lgnu/lists/LList;->reverseInPlace(Ljava/lang/Object;)Lgnu/lists/LList;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-direct {v11, v0, v1}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 127
    .end local v10    # "qresult":Lgnu/lists/LList;
    .local v11, "qresult":Lgnu/lists/LList;
    new-instance v13, Lgnu/lists/Pair;

    invoke-direct {v13, v11, v12}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .end local v12    # "rresult":Lgnu/lists/LList;
    .local v13, "rresult":Lgnu/lists/LList;
    move-object v12, v13

    .end local v13    # "rresult":Lgnu/lists/LList;
    .restart local v12    # "rresult":Lgnu/lists/LList;
    goto :goto_1

    .line 97
    .end local v11    # "qresult":Lgnu/lists/LList;
    .restart local v10    # "qresult":Lgnu/lists/LList;
    :cond_5
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/q2/lang/Q2Read;->curIndentation:I

    move/from16 v17, v0

    move/from16 v0, v17

    if-ne v15, v0, :cond_4

    .line 101
    invoke-static {v15, v14}, Lgnu/q2/lang/Q2;->compareIndentation(II)I

    move-result v5

    .line 102
    .local v5, "comparedIndent":I
    const/high16 v17, -0x80000000

    move/from16 v0, v17

    if-ne v5, v0, :cond_6

    .line 104
    const/16 v17, 0x65

    const-string v18, "cannot compare indentation - mix of tabs and spaces"

    move-object/from16 v0, p0

    move/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lgnu/q2/lang/Q2Read;->error(CLjava/lang/String;)V

    goto :goto_3

    .line 107
    :cond_6
    const/16 v17, -0x1

    move/from16 v0, v17

    if-eq v5, v0, :cond_7

    const/16 v17, 0x1

    move/from16 v0, v17

    if-ne v5, v0, :cond_8

    .line 109
    :cond_7
    const/16 v17, 0x65

    const-string v18, "indentation must differ by 2 or more"

    move-object/from16 v0, p0

    move/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lgnu/q2/lang/Q2Read;->error(CLjava/lang/String;)V

    goto :goto_3

    .line 112
    :cond_8
    if-lez v5, :cond_4

    .line 118
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v7

    .line 119
    .local v7, "line":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v4

    .line 120
    .local v4, "column":I
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->readIndentCommand()Ljava/lang/Object;

    move-result-object v16

    .line 121
    .local v16, "val":Ljava/lang/Object;
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1, v10, v7, v4}, Lgnu/q2/lang/Q2Read;->makePair(Ljava/lang/Object;Ljava/lang/Object;II)Lgnu/lists/Pair;

    move-result-object v10

    .line 122
    goto/16 :goto_2

    .line 131
    .end local v4    # "column":I
    .end local v5    # "comparedIndent":I
    .end local v7    # "line":I
    .end local v10    # "qresult":Lgnu/lists/LList;
    .end local v15    # "subIndentation":I
    .end local v16    # "val":Ljava/lang/Object;
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v7

    .line 132
    .restart local v7    # "line":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v4

    .line 134
    .restart local v4    # "column":I
    invoke-virtual/range {p0 .. p0}, Lgnu/q2/lang/Q2Read;->readObject()Ljava/lang/Object;

    move-result-object v16

    .line 136
    .restart local v16    # "val":Ljava/lang/Object;
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1, v12, v7, v4}, Lgnu/q2/lang/Q2Read;->makePair(Ljava/lang/Object;Ljava/lang/Object;II)Lgnu/lists/Pair;

    move-result-object v12

    .line 137
    goto/16 :goto_0
.end method

.method saveExpressionStartPosition()V
    .locals 1

    .prologue
    .line 353
    iget-object v0, p0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v0}, Lgnu/text/LineBufferedReader;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lgnu/q2/lang/Q2Read;->expressionStartFile:Ljava/lang/String;

    .line 354
    iget-object v0, p0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v0}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v0

    iput v0, p0, Lgnu/q2/lang/Q2Read;->expressionStartLine:I

    .line 355
    iget-object v0, p0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v0}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v0

    iput v0, p0, Lgnu/q2/lang/Q2Read;->expressionStartColumn:I

    .line 356
    return-void
.end method

.method singleLine()Z
    .locals 1

    .prologue
    .line 143
    iget-boolean v0, p0, Lgnu/q2/lang/Q2Read;->interactive:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lgnu/q2/lang/Q2Read;->nesting:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method skipIndentation()I
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 37
    const/4 v2, 0x0

    .local v2, "numTabs":I
    const/4 v1, 0x0

    .line 38
    .local v1, "numSpaces":I
    iget-object v3, p0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v3}, Lgnu/text/LineBufferedReader;->read()I

    move-result v0

    .line 39
    .local v0, "ch":I
    :goto_0
    const/16 v3, 0x9

    if-ne v0, v3, :cond_0

    .line 41
    add-int/lit8 v2, v2, 0x1

    .line 42
    iget-object v3, p0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v3}, Lgnu/text/LineBufferedReader;->read()I

    move-result v0

    goto :goto_0

    .line 44
    :cond_0
    :goto_1
    const/16 v3, 0x20

    if-ne v0, v3, :cond_1

    .line 46
    add-int/lit8 v1, v1, 0x1

    .line 47
    iget-object v3, p0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v3}, Lgnu/text/LineBufferedReader;->read()I

    move-result v0

    goto :goto_1

    .line 49
    :cond_1
    if-gez v0, :cond_2

    .line 50
    const/4 v3, -0x1

    .line 52
    :goto_2
    return v3

    .line 51
    :cond_2
    iget-object v3, p0, Lgnu/q2/lang/Q2Read;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v3}, Lgnu/text/LineBufferedReader;->unread()V

    .line 52
    shl-int/lit8 v3, v2, 0x10

    add-int/2addr v3, v1

    goto :goto_2
.end method
