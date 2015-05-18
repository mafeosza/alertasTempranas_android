.class public Lgnu/xml/XMLParser;
.super Ljava/lang/Object;
.source "XMLParser.java"


# static fields
.field private static final ATTRIBUTE_SEEN_EQ_STATE:I = 0xb

.field private static final ATTRIBUTE_SEEN_NAME_STATE:I = 0x8

.field static final BAD_ENCODING_SYNTAX:Ljava/lang/String; = "bad \'encoding\' declaration"

.field static final BAD_STANDALONE_SYNTAX:Ljava/lang/String; = "bad \'standalone\' declaration"

.field private static final BEGIN_ELEMENT_STATE:I = 0x2

.field private static final DOCTYPE_NAME_SEEN_STATE:I = 0x10

.field private static final DOCTYPE_SEEN_STATE:I = 0xd

.field private static final END_ELEMENT_STATE:I = 0x4

.field private static final EXPECT_NAME_MODIFIER:I = 0x1

.field private static final EXPECT_RIGHT_STATE:I = 0x1b

.field private static final INIT_LEFT_QUEST_STATE:I = 0x1e

.field private static final INIT_LEFT_STATE:I = 0x22

.field private static final INIT_STATE:I = 0x0

.field private static final INIT_TEXT_STATE:I = 0x1f

.field private static final INVALID_VERSION_DECL:I = 0x23

.field private static final MAYBE_ATTRIBUTE_STATE:I = 0xa

.field private static final PREV_WAS_CR_STATE:I = 0x1c

.field private static final SAW_AMP_SHARP_STATE:I = 0x1a

.field private static final SAW_AMP_STATE:I = 0x19

.field private static final SAW_ENTITY_REF:I = 0x6

.field private static final SAW_EOF_ERROR:I = 0x25

.field private static final SAW_ERROR:I = 0x24

.field private static final SAW_LEFT_EXCL_MINUS_STATE:I = 0x16

.field private static final SAW_LEFT_EXCL_STATE:I = 0x14

.field private static final SAW_LEFT_QUEST_STATE:I = 0x15

.field private static final SAW_LEFT_SLASH_STATE:I = 0x13

.field private static final SAW_LEFT_STATE:I = 0xe

.field private static final SKIP_SPACES_MODIFIER:I = 0x2

.field private static final TEXT_STATE:I = 0x1


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static XMLStreamReader(Ljava/io/InputStream;)Lgnu/text/LineInputStreamReader;
    .locals 15
    .param p0, "strm"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v14, 0x3c

    const/4 v13, 0x2

    const/16 v12, 0x3f

    const/4 v11, 0x0

    const/4 v4, -0x1

    .line 64
    new-instance v6, Lgnu/text/LineInputStreamReader;

    invoke-direct {v6, p0}, Lgnu/text/LineInputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 68
    .local v6, "in":Lgnu/text/LineInputStreamReader;
    invoke-virtual {v6}, Lgnu/text/LineInputStreamReader;->getByte()I

    move-result v1

    .line 69
    .local v1, "b1":I
    if-gez v1, :cond_0

    move v2, v4

    .line 70
    .local v2, "b2":I
    :goto_0
    if-gez v2, :cond_1

    move v3, v4

    .line 71
    .local v3, "b3":I
    :goto_1
    const/16 v10, 0xef

    if-ne v1, v10, :cond_2

    const/16 v10, 0xbb

    if-ne v2, v10, :cond_2

    const/16 v10, 0xbf

    if-ne v3, v10, :cond_2

    .line 73
    const/4 v10, 0x3

    invoke-virtual {v6, v10}, Lgnu/text/LineInputStreamReader;->resetStart(I)V

    .line 74
    const-string v10, "UTF-8"

    invoke-virtual {v6, v10}, Lgnu/text/LineInputStreamReader;->setCharset(Ljava/lang/String;)V

    .line 125
    :goto_2
    invoke-virtual {v6, v11}, Lgnu/text/LineInputStreamReader;->setKeepFullLines(Z)V

    .line 126
    return-object v6

    .line 69
    .end local v2    # "b2":I
    .end local v3    # "b3":I
    :cond_0
    invoke-virtual {v6}, Lgnu/text/LineInputStreamReader;->getByte()I

    move-result v2

    goto :goto_0

    .line 70
    .restart local v2    # "b2":I
    :cond_1
    invoke-virtual {v6}, Lgnu/text/LineInputStreamReader;->getByte()I

    move-result v3

    goto :goto_1

    .line 76
    .restart local v3    # "b3":I
    :cond_2
    const/16 v10, 0xff

    if-ne v1, v10, :cond_3

    const/16 v10, 0xfe

    if-ne v2, v10, :cond_3

    if-eqz v3, :cond_3

    .line 78
    invoke-virtual {v6, v13}, Lgnu/text/LineInputStreamReader;->resetStart(I)V

    .line 79
    const-string v10, "UTF-16LE"

    invoke-virtual {v6, v10}, Lgnu/text/LineInputStreamReader;->setCharset(Ljava/lang/String;)V

    goto :goto_2

    .line 81
    :cond_3
    const/16 v10, 0xfe

    if-ne v1, v10, :cond_4

    const/16 v10, 0xff

    if-ne v2, v10, :cond_4

    if-eqz v3, :cond_4

    .line 83
    invoke-virtual {v6, v13}, Lgnu/text/LineInputStreamReader;->resetStart(I)V

    .line 84
    const-string v10, "UTF-16BE"

    invoke-virtual {v6, v10}, Lgnu/text/LineInputStreamReader;->setCharset(Ljava/lang/String;)V

    goto :goto_2

    .line 88
    :cond_4
    if-gez v3, :cond_5

    .line 89
    .local v4, "b4":I
    :goto_3
    const/16 v10, 0x4c

    if-ne v1, v10, :cond_6

    const/16 v10, 0x6f

    if-ne v2, v10, :cond_6

    const/16 v10, 0xa7

    if-ne v3, v10, :cond_6

    const/16 v10, 0x94

    if-ne v4, v10, :cond_6

    .line 90
    new-instance v10, Ljava/lang/RuntimeException;

    const-string v11, "XMLParser: EBCDIC encodings not supported"

    invoke-direct {v10, v11}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 88
    .end local v4    # "b4":I
    :cond_5
    invoke-virtual {v6}, Lgnu/text/LineInputStreamReader;->getByte()I

    move-result v4

    goto :goto_3

    .line 91
    .restart local v4    # "b4":I
    :cond_6
    invoke-virtual {v6, v11}, Lgnu/text/LineInputStreamReader;->resetStart(I)V

    .line 92
    if-ne v1, v14, :cond_8

    if-ne v2, v12, :cond_7

    const/16 v10, 0x78

    if-ne v3, v10, :cond_7

    const/16 v10, 0x6d

    if-eq v4, v10, :cond_9

    :cond_7
    if-nez v2, :cond_8

    if-ne v3, v12, :cond_8

    if-eqz v4, :cond_9

    :cond_8
    if-nez v1, :cond_11

    if-ne v2, v14, :cond_11

    if-nez v3, :cond_11

    if-ne v4, v12, :cond_11

    .line 96
    :cond_9
    iget-object v5, v6, Lgnu/text/LineInputStreamReader;->buffer:[C

    .line 97
    .local v5, "buffer":[C
    if-nez v5, :cond_a

    .line 98
    const/16 v10, 0x2000

    new-array v5, v10, [C

    iput-object v5, v6, Lgnu/text/LineInputStreamReader;->buffer:[C

    .line 99
    :cond_a
    const/4 v7, 0x0

    .line 100
    .local v7, "pos":I
    const/4 v9, 0x0

    .line 103
    .local v9, "quote":I
    :cond_b
    :goto_4
    invoke-virtual {v6}, Lgnu/text/LineInputStreamReader;->getByte()I

    move-result v0

    .line 104
    .local v0, "b":I
    if-eqz v0, :cond_b

    .line 106
    if-gez v0, :cond_c

    .line 119
    :goto_5
    iput v11, v6, Lgnu/text/LineInputStreamReader;->pos:I

    .line 120
    iput v7, v6, Lgnu/text/LineInputStreamReader;->limit:I

    goto/16 :goto_2

    .line 108
    :cond_c
    add-int/lit8 v8, v7, 0x1

    .end local v7    # "pos":I
    .local v8, "pos":I
    and-int/lit16 v10, v0, 0xff

    int-to-char v10, v10

    aput-char v10, v5, v7

    .line 109
    if-nez v9, :cond_10

    .line 111
    const/16 v10, 0x3e

    if-ne v0, v10, :cond_d

    move v7, v8

    .line 112
    .end local v8    # "pos":I
    .restart local v7    # "pos":I
    goto :goto_5

    .line 113
    .end local v7    # "pos":I
    .restart local v8    # "pos":I
    :cond_d
    const/16 v10, 0x27

    if-eq v0, v10, :cond_e

    const/16 v10, 0x22

    if-ne v0, v10, :cond_f

    .line 114
    :cond_e
    move v9, v0

    :cond_f
    :goto_6
    move v7, v8

    .line 118
    .end local v8    # "pos":I
    .restart local v7    # "pos":I
    goto :goto_4

    .line 116
    .end local v7    # "pos":I
    .restart local v8    # "pos":I
    :cond_10
    if-ne v0, v9, :cond_f

    .line 117
    const/4 v9, 0x0

    goto :goto_6

    .line 123
    .end local v0    # "b":I
    .end local v5    # "buffer":[C
    .end local v8    # "pos":I
    .end local v9    # "quote":I
    :cond_11
    const-string v10, "UTF-8"

    invoke-virtual {v6, v10}, Lgnu/text/LineInputStreamReader;->setCharset(Ljava/lang/String;)V

    goto/16 :goto_2
.end method

.method public static parse(Lgnu/text/LineBufferedReader;Lgnu/text/SourceMessages;Lgnu/lists/Consumer;)V
    .locals 2
    .param p0, "in"    # Lgnu/text/LineBufferedReader;
    .param p1, "messages"    # Lgnu/text/SourceMessages;
    .param p2, "out"    # Lgnu/lists/Consumer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 143
    new-instance v0, Lgnu/xml/XMLFilter;

    invoke-direct {v0, p2}, Lgnu/xml/XMLFilter;-><init>(Lgnu/lists/Consumer;)V

    .line 144
    .local v0, "filter":Lgnu/xml/XMLFilter;
    invoke-virtual {v0, p1}, Lgnu/xml/XMLFilter;->setMessages(Lgnu/text/SourceMessages;)V

    .line 145
    invoke-virtual {v0, p0}, Lgnu/xml/XMLFilter;->setSourceLocator(Lgnu/text/LineBufferedReader;)V

    .line 146
    invoke-virtual {v0}, Lgnu/xml/XMLFilter;->startDocument()V

    .line 147
    invoke-virtual {p0}, Lgnu/text/LineBufferedReader;->getPath()Lgnu/text/Path;

    move-result-object v1

    .line 148
    .local v1, "uri":Lgnu/text/Path;
    if-eqz v1, :cond_0

    .line 149
    invoke-virtual {v0, v1}, Lgnu/xml/XMLFilter;->writeDocumentUri(Ljava/lang/Object;)V

    .line 150
    :cond_0
    invoke-static {p0, v0}, Lgnu/xml/XMLParser;->parse(Lgnu/text/LineBufferedReader;Lgnu/xml/XMLFilter;)V

    .line 151
    invoke-virtual {v0}, Lgnu/xml/XMLFilter;->endDocument()V

    .line 152
    return-void
.end method

.method public static parse(Lgnu/text/LineBufferedReader;Lgnu/text/SourceMessages;Lgnu/xml/XMLFilter;)V
    .locals 1
    .param p0, "in"    # Lgnu/text/LineBufferedReader;
    .param p1, "messages"    # Lgnu/text/SourceMessages;
    .param p2, "filter"    # Lgnu/xml/XMLFilter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 157
    invoke-virtual {p2, p1}, Lgnu/xml/XMLFilter;->setMessages(Lgnu/text/SourceMessages;)V

    .line 158
    invoke-virtual {p2, p0}, Lgnu/xml/XMLFilter;->setSourceLocator(Lgnu/text/LineBufferedReader;)V

    .line 159
    invoke-virtual {p2}, Lgnu/xml/XMLFilter;->startDocument()V

    .line 160
    invoke-virtual {p0}, Lgnu/text/LineBufferedReader;->getPath()Lgnu/text/Path;

    move-result-object v0

    .line 161
    .local v0, "uri":Lgnu/text/Path;
    if-eqz v0, :cond_0

    .line 162
    invoke-virtual {p2, v0}, Lgnu/xml/XMLFilter;->writeDocumentUri(Ljava/lang/Object;)V

    .line 163
    :cond_0
    invoke-static {p0, p2}, Lgnu/xml/XMLParser;->parse(Lgnu/text/LineBufferedReader;Lgnu/xml/XMLFilter;)V

    .line 164
    invoke-virtual {p2}, Lgnu/xml/XMLFilter;->endDocument()V

    .line 165
    invoke-virtual {p0}, Lgnu/text/LineBufferedReader;->close()V

    .line 166
    return-void
.end method

.method public static parse(Lgnu/text/LineBufferedReader;Lgnu/xml/XMLFilter;)V
    .locals 26
    .param p0, "in"    # Lgnu/text/LineBufferedReader;
    .param p1, "out"    # Lgnu/xml/XMLFilter;

    .prologue
    .line 171
    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/text/LineBufferedReader;->buffer:[C

    .line 172
    .local v3, "buffer":[C
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/text/LineBufferedReader;->pos:I

    move/from16 v18, v0

    .line 173
    .local v18, "pos":I
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/text/LineBufferedReader;->limit:I

    move/from16 v16, v0

    .line 189
    .local v16, "limit":I
    const/16 v22, 0x0

    .line 194
    .local v22, "state":I
    const/16 v23, 0x3c

    .line 195
    .local v23, "terminator":C
    const/16 v10, 0xe

    .line 196
    .local v10, "continue_state":I
    const/16 v9, 0x20

    .line 197
    .local v9, "ch":C
    const/4 v5, 0x0

    .line 198
    .local v5, "length":I
    const/4 v6, -0x1

    .line 199
    .local v6, "dstart":I
    const/16 v17, 0x0

    .line 201
    .local v17, "message":Ljava/lang/String;
    move/from16 v4, v16

    .line 206
    .local v4, "start":I
    :goto_0
    packed-switch v22, :pswitch_data_0

    :cond_0
    :pswitch_0
    move/from16 v19, v18

    .line 948
    .end local v18    # "pos":I
    .local v19, "pos":I
    :cond_1
    :goto_1
    move/from16 v0, v19

    move/from16 v1, v16

    if-ge v0, v1, :cond_64

    .line 949
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    aget-char v9, v3, v19

    goto :goto_0

    .line 209
    :pswitch_1
    const/16 v22, 0x1

    .line 210
    const/16 v22, 0x1f

    move/from16 v19, v18

    .line 211
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto :goto_1

    .line 214
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :pswitch_2
    const/16 v2, 0x3c

    if-ne v9, v2, :cond_2

    .line 216
    const/16 v22, 0x22

    move/from16 v19, v18

    .line 217
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto :goto_1

    .line 219
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_2
    const/16 v22, 0x1

    .line 220
    goto :goto_0

    .line 223
    :pswitch_3
    const/16 v2, 0x3f

    if-ne v9, v2, :cond_3

    .line 225
    move/from16 v4, v18

    .line 226
    const/16 v22, 0x21

    move/from16 v19, v18

    .line 227
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto :goto_1

    .line 229
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_3
    const/16 v22, 0xe

    .line 230
    goto :goto_0

    .line 233
    :pswitch_4
    move/from16 v18, v6

    .line 234
    const-string v17, "invalid xml version specifier"

    .line 238
    :pswitch_5
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 239
    const/16 v2, 0x65

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v2, v1}, Lgnu/xml/XMLFilter;->error(CLjava/lang/String;)V

    :cond_4
    move/from16 v19, v18

    .line 242
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    move/from16 v0, v19

    move/from16 v1, v16

    if-lt v0, v1, :cond_5

    move/from16 v18, v19

    .line 989
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :goto_2
    return-void

    .line 244
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_5
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    aget-char v9, v3, v19

    .line 245
    const/16 v2, 0x3e

    if-ne v9, v2, :cond_4

    .line 247
    const/16 v22, 0x1

    move/from16 v19, v18

    .line 248
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto :goto_1

    .line 253
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :pswitch_6
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 254
    const/16 v2, 0x66

    const-string v7, "unexpected end-of-file"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v7}, Lgnu/xml/XMLFilter;->error(CLjava/lang/String;)V

    goto :goto_2

    .line 261
    :pswitch_7
    add-int/lit8 v4, v18, -0x1

    .line 263
    move/from16 v5, v18

    move/from16 v19, v18

    .line 266
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :goto_3
    move/from16 v0, v23

    if-ne v9, v0, :cond_7

    .line 268
    move/from16 v22, v10

    move/from16 v18, v19

    .line 337
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :goto_4
    sub-int v5, v18, v5

    .line 338
    if-lez v5, :cond_6

    .line 340
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 341
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v4, v5}, Lgnu/xml/XMLFilter;->textFromParser([CII)V

    .line 343
    :cond_6
    array-length v4, v3

    move/from16 v19, v18

    .line 344
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 271
    :cond_7
    const/16 v2, 0x26

    if-ne v9, v2, :cond_8

    .line 273
    const/16 v22, 0x19

    move/from16 v18, v19

    .line 274
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto :goto_4

    .line 276
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_8
    const/16 v2, 0xd

    if-ne v9, v2, :cond_e

    .line 278
    sub-int v5, v19, v5

    .line 279
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 280
    if-lez v5, :cond_9

    .line 281
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v4, v5}, Lgnu/xml/XMLFilter;->textFromParser([CII)V

    .line 282
    :cond_9
    move/from16 v0, v19

    move/from16 v1, v16

    if-ge v0, v1, :cond_d

    .line 284
    aget-char v9, v3, v19

    .line 285
    const/16 v2, 0xa

    if-ne v9, v2, :cond_b

    .line 287
    move/from16 v4, v19

    .line 288
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    move/from16 v5, v18

    .line 306
    :goto_5
    const/4 v2, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v2, v1}, Lgnu/text/LineBufferedReader;->incrLineNumber(II)V

    move/from16 v19, v18

    .line 330
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_a
    :goto_6
    move/from16 v0, v19

    move/from16 v1, v16

    if-ne v0, v1, :cond_12

    .line 332
    add-int/lit8 v5, v5, -0x1

    move/from16 v18, v19

    .line 333
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto :goto_4

    .line 292
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_b
    invoke-virtual/range {p1 .. p1}, Lgnu/xml/XMLFilter;->linefeedFromParser()V

    .line 293
    const/16 v2, 0x85

    if-ne v9, v2, :cond_c

    .line 295
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    move/from16 v4, v19

    .line 296
    add-int/lit8 v5, v18, 0x1

    goto :goto_5

    .line 300
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_c
    const/4 v2, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v2, v1}, Lgnu/text/LineBufferedReader;->incrLineNumber(II)V

    .line 301
    move/from16 v4, v19

    .line 302
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    move/from16 v5, v18

    move/from16 v19, v18

    .line 303
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto :goto_3

    .line 310
    :cond_d
    invoke-virtual/range {p1 .. p1}, Lgnu/xml/XMLFilter;->linefeedFromParser()V

    .line 311
    const/16 v22, 0x1c

    .line 312
    goto/16 :goto_1

    .line 315
    :cond_e
    const/16 v2, 0x85

    if-eq v9, v2, :cond_f

    const/16 v2, 0x2028

    if-ne v9, v2, :cond_11

    .line 317
    :cond_f
    sub-int v5, v19, v5

    .line 318
    add-int/lit8 v2, v19, -0x1

    move-object/from16 v0, p0

    iput v2, v0, Lgnu/text/LineBufferedReader;->pos:I

    .line 319
    if-lez v5, :cond_10

    .line 320
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v4, v5}, Lgnu/xml/XMLFilter;->textFromParser([CII)V

    .line 321
    :cond_10
    invoke-virtual/range {p1 .. p1}, Lgnu/xml/XMLFilter;->linefeedFromParser()V

    .line 322
    const/4 v2, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v2, v1}, Lgnu/text/LineBufferedReader;->incrLineNumber(II)V

    .line 323
    add-int/lit8 v5, v19, 0x1

    .line 324
    move/from16 v4, v19

    goto :goto_6

    .line 326
    :cond_11
    const/16 v2, 0xa

    if-ne v9, v2, :cond_a

    .line 328
    const/4 v2, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v19

    invoke-virtual {v0, v2, v1}, Lgnu/text/LineBufferedReader;->incrLineNumber(II)V

    goto :goto_6

    .line 335
    :cond_12
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    aget-char v9, v3, v19

    move/from16 v19, v18

    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_3

    .line 349
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :pswitch_8
    const/16 v22, 0x1

    .line 350
    const/16 v2, 0xa

    if-ne v9, v2, :cond_13

    const/4 v2, 0x1

    move v7, v2

    :goto_7
    const/16 v2, 0x85

    if-ne v9, v2, :cond_14

    const/4 v2, 0x1

    :goto_8
    or-int/2addr v2, v7

    if-eqz v2, :cond_15

    .line 352
    const/4 v2, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v2, v1}, Lgnu/text/LineBufferedReader;->incrLineNumber(II)V

    move/from16 v19, v18

    .line 353
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 350
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_13
    const/4 v2, 0x0

    move v7, v2

    goto :goto_7

    :cond_14
    const/4 v2, 0x0

    goto :goto_8

    .line 357
    :cond_15
    const/4 v2, 0x1

    add-int/lit8 v7, v18, -0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v7}, Lgnu/text/LineBufferedReader;->incrLineNumber(II)V

    goto/16 :goto_0

    .line 367
    :pswitch_9
    const/16 v2, 0x20

    if-eq v9, v2, :cond_0

    const/16 v2, 0x9

    if-ne v9, v2, :cond_16

    move/from16 v19, v18

    .line 368
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 369
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_16
    const/16 v2, 0xa

    if-eq v9, v2, :cond_17

    const/16 v2, 0xd

    if-eq v9, v2, :cond_17

    const/16 v2, 0x85

    if-eq v9, v2, :cond_17

    const/16 v2, 0x2028

    if-ne v9, v2, :cond_18

    .line 372
    :cond_17
    const/4 v2, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v18

    invoke-virtual {v0, v2, v1}, Lgnu/text/LineBufferedReader;->incrLineNumber(II)V

    move/from16 v19, v18

    .line 373
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 376
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_18
    add-int/lit8 v22, v22, -0x2

    .line 377
    goto/16 :goto_0

    .line 386
    :pswitch_a
    add-int/lit8 v5, v4, 0x1

    move/from16 v19, v18

    .line 399
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :goto_9
    const/16 v2, 0x61

    if-lt v9, v2, :cond_19

    const/16 v2, 0x7a

    if-le v9, v2, :cond_21

    :cond_19
    const/16 v2, 0x41

    if-lt v9, v2, :cond_1a

    const/16 v2, 0x5a

    if-le v9, v2, :cond_21

    :cond_1a
    const/16 v2, 0x5f

    if-eq v9, v2, :cond_21

    const/16 v2, 0x3a

    if-eq v9, v2, :cond_21

    const/16 v2, 0xc0

    if-lt v9, v2, :cond_1f

    const/16 v2, 0x2ff

    if-le v9, v2, :cond_21

    const/16 v2, 0x370

    if-lt v9, v2, :cond_1f

    const/16 v2, 0x1fff

    if-gt v9, v2, :cond_1b

    const/16 v2, 0x37e

    if-ne v9, v2, :cond_21

    :cond_1b
    const/16 v2, 0x200c

    if-lt v9, v2, :cond_1f

    const/16 v2, 0x200d

    if-le v9, v2, :cond_21

    const/16 v2, 0x2070

    if-lt v9, v2, :cond_1c

    const/16 v2, 0x218f

    if-le v9, v2, :cond_21

    :cond_1c
    const/16 v2, 0x2c00

    if-lt v9, v2, :cond_1d

    const/16 v2, 0x2fef

    if-le v9, v2, :cond_21

    :cond_1d
    const/16 v2, 0x3001

    if-lt v9, v2, :cond_1e

    const v2, 0xd7ff

    if-le v9, v2, :cond_21

    :cond_1e
    const v2, 0xf900

    if-lt v9, v2, :cond_1f

    const v2, 0xfffd

    if-le v9, v2, :cond_21

    :cond_1f
    move/from16 v0, v19

    if-le v0, v5, :cond_20

    const/16 v2, 0x30

    if-lt v9, v2, :cond_20

    const/16 v2, 0x39

    if-le v9, v2, :cond_21

    :cond_20
    const/16 v2, 0x2e

    if-eq v9, v2, :cond_21

    const/16 v2, 0x2d

    if-eq v9, v2, :cond_21

    const/16 v2, 0xb7

    if-eq v9, v2, :cond_21

    const/16 v2, 0x300

    if-le v9, v2, :cond_22

    const/16 v2, 0x36f

    if-le v9, v2, :cond_21

    const/16 v2, 0x203f

    if-lt v9, v2, :cond_22

    const/16 v2, 0x2040

    if-gt v9, v2, :cond_22

    .line 436
    :cond_21
    move/from16 v0, v19

    move/from16 v1, v16

    if-ge v0, v1, :cond_1

    .line 437
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    aget-char v9, v3, v19

    move/from16 v19, v18

    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_9

    .line 421
    :cond_22
    add-int/lit8 v22, v22, -0x1

    .line 422
    sub-int v5, v19, v5

    .line 423
    if-nez v5, :cond_6d

    .line 425
    const/16 v2, 0x8

    move/from16 v0, v22

    if-ne v0, v2, :cond_23

    .line 426
    const-string v17, "missing or invalid attribute name"

    .line 432
    :goto_a
    const/16 v22, 0x24

    move/from16 v18, v19

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 427
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_23
    const/4 v2, 0x2

    move/from16 v0, v22

    if-eq v0, v2, :cond_24

    const/4 v2, 0x4

    move/from16 v0, v22

    if-ne v0, v2, :cond_25

    .line 429
    :cond_24
    const-string v17, "missing or invalid element name"

    goto :goto_a

    .line 431
    :cond_25
    const-string v17, "missing or invalid name"

    goto :goto_a

    .line 452
    :cond_26
    const/16 v2, 0x78

    if-ne v9, v2, :cond_27

    if-nez v6, :cond_27

    .line 453
    const/16 v6, 0x10

    .line 464
    :goto_b
    move/from16 v0, v19

    move/from16 v1, v16

    if-ge v0, v1, :cond_1

    .line 465
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    aget-char v9, v3, v19

    move/from16 v19, v18

    .line 444
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :goto_c
    const/16 v2, 0x3b

    if-ne v9, v2, :cond_26

    .line 446
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 447
    add-int/lit8 v2, v19, -0x1

    sub-int/2addr v2, v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v5, v3, v4, v2}, Lgnu/xml/XMLFilter;->emitCharacterReference(I[CII)V

    .line 449
    const/16 v22, 0x1

    .line 450
    goto/16 :goto_1

    .line 454
    :cond_27
    const/high16 v2, 0x8000000

    if-lt v5, v2, :cond_29

    .line 469
    :cond_28
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 470
    const/16 v2, 0x65

    const-string v7, "invalid character reference"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v7}, Lgnu/xml/XMLFilter;->error(CLjava/lang/String;)V

    .line 471
    const/16 v22, 0x1

    .line 472
    goto/16 :goto_1

    .line 458
    :cond_29
    if-nez v6, :cond_2a

    const/16 v8, 0xa

    .line 459
    .local v8, "base":I
    :goto_d
    invoke-static {v9, v8}, Ljava/lang/Character;->digit(CI)I

    move-result v11

    .line 460
    .local v11, "digit":I
    if-ltz v11, :cond_28

    .line 462
    mul-int v2, v5, v8

    add-int v5, v2, v11

    goto :goto_b

    .end local v8    # "base":I
    .end local v11    # "digit":I
    :cond_2a
    move v8, v6

    .line 458
    goto :goto_d

    .line 475
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :pswitch_b
    const/16 v2, 0x23

    if-ne v9, v2, :cond_2b

    .line 477
    const/16 v22, 0x1a

    .line 478
    move/from16 v4, v18

    .line 479
    const/4 v5, 0x0

    .line 480
    const/4 v6, 0x0

    move/from16 v19, v18

    .line 481
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 483
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_2b
    add-int/lit8 v4, v18, -0x1

    .line 484
    const/16 v22, 0x7

    .line 485
    goto/16 :goto_0

    .line 488
    :pswitch_c
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 489
    const/16 v2, 0x3b

    if-eq v9, v2, :cond_2c

    .line 490
    const/16 v2, 0x77

    const-string v7, "missing \';\'"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v7}, Lgnu/xml/XMLFilter;->error(CLjava/lang/String;)V

    .line 491
    :cond_2c
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v4, v5}, Lgnu/xml/XMLFilter;->emitEntityReference([CII)V

    .line 492
    move/from16 v4, v16

    .line 493
    const/16 v22, 0x1

    move/from16 v19, v18

    .line 494
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 497
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :pswitch_d
    const/16 v2, 0x2f

    if-ne v9, v2, :cond_2d

    .line 499
    const/16 v22, 0x13

    move/from16 v19, v18

    .line 500
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 502
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_2d
    const/16 v2, 0x3f

    if-ne v9, v2, :cond_2e

    .line 504
    move/from16 v4, v18

    .line 505
    const/16 v22, 0x18

    move/from16 v19, v18

    .line 506
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 508
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_2e
    const/16 v2, 0x21

    if-ne v9, v2, :cond_2f

    .line 510
    const/16 v22, 0x14

    .line 511
    move/from16 v4, v18

    move/from16 v19, v18

    .line 512
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 515
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_2f
    add-int/lit8 v4, v18, -0x1

    .line 516
    const/16 v22, 0x3

    .line 517
    goto/16 :goto_0

    .line 519
    :pswitch_e
    sub-int v2, v18, v5

    move-object/from16 v0, p0

    iput v2, v0, Lgnu/text/LineBufferedReader;->pos:I

    .line 520
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v4, v5}, Lgnu/xml/XMLFilter;->emitStartElement([CII)V

    .line 521
    const/16 v22, 0xc

    .line 522
    move/from16 v4, v16

    .line 523
    goto/16 :goto_0

    .line 527
    :pswitch_f
    if-gez v6, :cond_6c

    .line 528
    add-int/lit8 v6, v18, -0x1

    move/from16 v19, v18

    .line 532
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :goto_e
    const/16 v2, 0x3e

    if-ne v9, v2, :cond_51

    add-int/lit8 v13, v19, -0x2

    .local v13, "end":I
    aget-char v2, v3, v13

    const/16 v7, 0x3f

    if-ne v2, v7, :cond_51

    if-lt v13, v6, :cond_51

    .line 536
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 537
    const/4 v2, 0x3

    if-ne v5, v2, :cond_4f

    aget-char v2, v3, v4

    const/16 v7, 0x78

    if-ne v2, v7, :cond_4f

    add-int/lit8 v2, v4, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x6d

    if-ne v2, v7, :cond_4f

    add-int/lit8 v2, v4, 0x2

    aget-char v2, v3, v2

    const/16 v7, 0x6c

    if-ne v2, v7, :cond_4f

    .line 542
    const/16 v2, 0x1e

    move/from16 v0, v22

    if-ne v0, v2, :cond_4e

    .line 544
    add-int/lit8 v2, v6, 0x7

    if-le v13, v2, :cond_30

    aget-char v2, v3, v6

    const/16 v7, 0x76

    if-ne v2, v7, :cond_30

    add-int/lit8 v2, v6, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x65

    if-ne v2, v7, :cond_30

    add-int/lit8 v2, v6, 0x2

    aget-char v2, v3, v2

    const/16 v7, 0x72

    if-ne v2, v7, :cond_30

    add-int/lit8 v2, v6, 0x3

    aget-char v2, v3, v2

    const/16 v7, 0x73

    if-ne v2, v7, :cond_30

    add-int/lit8 v2, v6, 0x4

    aget-char v2, v3, v2

    const/16 v7, 0x69

    if-ne v2, v7, :cond_30

    add-int/lit8 v2, v6, 0x5

    aget-char v2, v3, v2

    const/16 v7, 0x6f

    if-ne v2, v7, :cond_30

    add-int/lit8 v2, v6, 0x6

    aget-char v2, v3, v2

    const/16 v7, 0x6e

    if-eq v2, v7, :cond_31

    .line 553
    :cond_30
    move/from16 v18, v6

    .line 554
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    const-string v17, "xml declaration without version"

    .line 555
    const/16 v22, 0x24

    .line 556
    goto/16 :goto_0

    .line 558
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_31
    add-int/lit8 v6, v6, 0x7

    .line 559
    aget-char v9, v3, v6

    .line 561
    :goto_f
    invoke-static {v9}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_32

    add-int/lit8 v6, v6, 0x1

    if-ge v6, v13, :cond_32

    .line 562
    aget-char v9, v3, v6

    goto :goto_f

    .line 563
    :cond_32
    const/16 v2, 0x3d

    if-eq v9, v2, :cond_33

    .line 565
    const/16 v22, 0x23

    move/from16 v18, v19

    .line 566
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 568
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_33
    add-int/lit8 v6, v6, 0x1

    aget-char v9, v3, v6

    .line 570
    :goto_10
    invoke-static {v9}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_34

    add-int/lit8 v6, v6, 0x1

    if-ge v6, v13, :cond_34

    .line 571
    aget-char v9, v3, v6

    goto :goto_10

    .line 572
    :cond_34
    const/16 v2, 0x27

    if-eq v9, v2, :cond_35

    const/16 v2, 0x22

    if-eq v9, v2, :cond_35

    .line 574
    const/16 v22, 0x23

    move/from16 v18, v19

    .line 575
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 577
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_35
    move/from16 v20, v9

    .line 578
    .local v20, "quote":C
    add-int/lit8 v6, v6, 0x1

    move v15, v6

    .line 581
    .local v15, "i":I
    :goto_11
    if-ne v15, v13, :cond_36

    .line 583
    const/16 v22, 0x23

    move/from16 v18, v19

    .line 584
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 586
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_36
    aget-char v9, v3, v15

    .line 587
    move/from16 v0, v20

    if-ne v9, v0, :cond_39

    .line 590
    add-int/lit8 v2, v6, 0x3

    if-ne v15, v2, :cond_37

    aget-char v2, v3, v6

    const/16 v7, 0x31

    if-ne v2, v7, :cond_37

    add-int/lit8 v2, v6, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x2e

    if-ne v2, v7, :cond_37

    add-int/lit8 v2, v6, 0x2

    aget-char v9, v3, v2

    const/16 v2, 0x30

    if-eq v9, v2, :cond_38

    :cond_37
    const/16 v2, 0x31

    if-ne v9, v2, :cond_3a

    .line 601
    :cond_38
    add-int/lit8 v6, v15, 0x1

    .line 603
    :goto_12
    if-ge v6, v13, :cond_3b

    aget-char v2, v3, v6

    invoke-static {v2}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_3b

    .line 604
    add-int/lit8 v6, v6, 0x1

    goto :goto_12

    .line 579
    :cond_39
    add-int/lit8 v15, v15, 0x1

    goto :goto_11

    .line 598
    :cond_3a
    const/16 v22, 0x23

    move/from16 v18, v19

    .line 599
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 605
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_3b
    add-int/lit8 v2, v6, 0x7

    if-le v13, v2, :cond_43

    aget-char v2, v3, v6

    const/16 v7, 0x65

    if-ne v2, v7, :cond_43

    add-int/lit8 v2, v6, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x6e

    if-ne v2, v7, :cond_43

    add-int/lit8 v2, v6, 0x2

    aget-char v2, v3, v2

    const/16 v7, 0x63

    if-ne v2, v7, :cond_43

    add-int/lit8 v2, v6, 0x3

    aget-char v2, v3, v2

    const/16 v7, 0x6f

    if-ne v2, v7, :cond_43

    add-int/lit8 v2, v6, 0x4

    aget-char v2, v3, v2

    const/16 v7, 0x64

    if-ne v2, v7, :cond_43

    add-int/lit8 v2, v6, 0x5

    aget-char v2, v3, v2

    const/16 v7, 0x69

    if-ne v2, v7, :cond_43

    add-int/lit8 v2, v6, 0x6

    aget-char v2, v3, v2

    const/16 v7, 0x6e

    if-ne v2, v7, :cond_43

    add-int/lit8 v2, v6, 0x7

    aget-char v2, v3, v2

    const/16 v7, 0x67

    if-ne v2, v7, :cond_43

    .line 615
    add-int/lit8 v6, v6, 0x8

    .line 616
    aget-char v9, v3, v6

    .line 618
    :goto_13
    invoke-static {v9}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_3c

    add-int/lit8 v6, v6, 0x1

    if-ge v6, v13, :cond_3c

    .line 619
    aget-char v9, v3, v6

    goto :goto_13

    .line 620
    :cond_3c
    const/16 v2, 0x3d

    if-eq v9, v2, :cond_3d

    .line 622
    const-string v17, "bad \'encoding\' declaration"

    .line 623
    const/16 v22, 0x24

    move/from16 v18, v19

    .line 624
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 626
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_3d
    add-int/lit8 v6, v6, 0x1

    aget-char v9, v3, v6

    .line 628
    :goto_14
    invoke-static {v9}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_3e

    add-int/lit8 v6, v6, 0x1

    if-ge v6, v13, :cond_3e

    .line 629
    aget-char v9, v3, v6

    goto :goto_14

    .line 630
    :cond_3e
    const/16 v2, 0x27

    if-eq v9, v2, :cond_3f

    const/16 v2, 0x22

    if-eq v9, v2, :cond_3f

    .line 632
    const-string v17, "bad \'encoding\' declaration"

    .line 633
    const/16 v22, 0x24

    move/from16 v18, v19

    .line 634
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 636
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_3f
    move/from16 v20, v9

    .line 637
    add-int/lit8 v6, v6, 0x1

    move v15, v6

    .line 640
    :goto_15
    if-ne v15, v13, :cond_40

    .line 642
    const-string v17, "bad \'encoding\' declaration"

    .line 643
    const/16 v22, 0x24

    move/from16 v18, v19

    .line 644
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 646
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_40
    aget-char v9, v3, v15

    .line 647
    move/from16 v0, v20

    if-ne v9, v0, :cond_42

    .line 650
    new-instance v12, Ljava/lang/String;

    sub-int v2, v15, v6

    invoke-direct {v12, v3, v6, v2}, Ljava/lang/String;-><init>([CII)V

    .line 651
    .local v12, "encoding":Ljava/lang/String;
    move-object/from16 v0, p0

    instance-of v2, v0, Lgnu/text/LineInputStreamReader;

    if-eqz v2, :cond_41

    move-object/from16 v2, p0

    .line 652
    check-cast v2, Lgnu/text/LineInputStreamReader;

    invoke-virtual {v2, v12}, Lgnu/text/LineInputStreamReader;->setCharset(Ljava/lang/String;)V

    .line 653
    :cond_41
    add-int/lit8 v6, v15, 0x1

    .line 655
    :goto_16
    if-ge v6, v13, :cond_43

    aget-char v2, v3, v6

    invoke-static {v2}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_43

    .line 656
    add-int/lit8 v6, v6, 0x1

    goto :goto_16

    .line 638
    .end local v12    # "encoding":Ljava/lang/String;
    :cond_42
    add-int/lit8 v15, v15, 0x1

    goto :goto_15

    .line 658
    :cond_43
    add-int/lit8 v2, v6, 0x9

    if-le v13, v2, :cond_4d

    aget-char v2, v3, v6

    const/16 v7, 0x73

    if-ne v2, v7, :cond_4d

    add-int/lit8 v2, v6, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x74

    if-ne v2, v7, :cond_4d

    add-int/lit8 v2, v6, 0x2

    aget-char v2, v3, v2

    const/16 v7, 0x61

    if-ne v2, v7, :cond_4d

    add-int/lit8 v2, v6, 0x3

    aget-char v2, v3, v2

    const/16 v7, 0x6e

    if-ne v2, v7, :cond_4d

    add-int/lit8 v2, v6, 0x4

    aget-char v2, v3, v2

    const/16 v7, 0x64

    if-ne v2, v7, :cond_4d

    add-int/lit8 v2, v6, 0x5

    aget-char v2, v3, v2

    const/16 v7, 0x61

    if-ne v2, v7, :cond_4d

    add-int/lit8 v2, v6, 0x6

    aget-char v2, v3, v2

    const/16 v7, 0x6c

    if-ne v2, v7, :cond_4d

    add-int/lit8 v2, v6, 0x7

    aget-char v2, v3, v2

    const/16 v7, 0x6f

    if-ne v2, v7, :cond_4d

    add-int/lit8 v2, v6, 0x8

    aget-char v2, v3, v2

    const/16 v7, 0x6e

    if-ne v2, v7, :cond_4d

    add-int/lit8 v2, v6, 0x9

    aget-char v2, v3, v2

    const/16 v7, 0x65

    if-ne v2, v7, :cond_4d

    .line 670
    add-int/lit8 v6, v6, 0xa

    .line 671
    aget-char v9, v3, v6

    .line 673
    :goto_17
    invoke-static {v9}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_44

    add-int/lit8 v6, v6, 0x1

    if-ge v6, v13, :cond_44

    .line 674
    aget-char v9, v3, v6

    goto :goto_17

    .line 675
    :cond_44
    const/16 v2, 0x3d

    if-eq v9, v2, :cond_45

    .line 677
    const-string v17, "bad \'standalone\' declaration"

    .line 678
    const/16 v22, 0x24

    move/from16 v18, v19

    .line 679
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 681
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_45
    add-int/lit8 v6, v6, 0x1

    aget-char v9, v3, v6

    .line 683
    :goto_18
    invoke-static {v9}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_46

    add-int/lit8 v6, v6, 0x1

    if-ge v6, v13, :cond_46

    .line 684
    aget-char v9, v3, v6

    goto :goto_18

    .line 685
    :cond_46
    const/16 v2, 0x27

    if-eq v9, v2, :cond_47

    const/16 v2, 0x22

    if-eq v9, v2, :cond_47

    .line 687
    const-string v17, "bad \'standalone\' declaration"

    .line 688
    const/16 v22, 0x24

    move/from16 v18, v19

    .line 689
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 691
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_47
    move/from16 v20, v9

    .line 692
    add-int/lit8 v6, v6, 0x1

    move v15, v6

    .line 695
    :goto_19
    if-ne v15, v13, :cond_48

    .line 697
    const-string v17, "bad \'standalone\' declaration"

    .line 698
    const/16 v22, 0x24

    move/from16 v18, v19

    .line 699
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 701
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_48
    aget-char v9, v3, v15

    .line 702
    move/from16 v0, v20

    if-ne v9, v0, :cond_4a

    .line 705
    add-int/lit8 v2, v6, 0x3

    if-ne v15, v2, :cond_4b

    aget-char v2, v3, v6

    const/16 v7, 0x79

    if-ne v2, v7, :cond_4b

    add-int/lit8 v2, v6, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x65

    if-ne v2, v7, :cond_4b

    add-int/lit8 v2, v6, 0x2

    aget-char v2, v3, v2

    const/16 v7, 0x73

    if-ne v2, v7, :cond_4b

    .line 722
    :cond_49
    add-int/lit8 v6, v15, 0x1

    .line 724
    :goto_1a
    if-ge v6, v13, :cond_4d

    aget-char v2, v3, v6

    invoke-static {v2}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v2

    if-eqz v2, :cond_4d

    .line 725
    add-int/lit8 v6, v6, 0x1

    goto :goto_1a

    .line 693
    :cond_4a
    add-int/lit8 v15, v15, 0x1

    goto :goto_19

    .line 711
    :cond_4b
    add-int/lit8 v2, v6, 0x2

    if-ne v15, v2, :cond_4c

    aget-char v2, v3, v6

    const/16 v7, 0x6e

    if-ne v2, v7, :cond_4c

    add-int/lit8 v2, v6, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x6f

    if-eq v2, v7, :cond_49

    .line 718
    :cond_4c
    const-string v17, "bad \'standalone\' declaration"

    .line 719
    const/16 v22, 0x24

    move/from16 v18, v19

    .line 720
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 727
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_4d
    if-eq v13, v6, :cond_50

    .line 729
    const-string v17, "junk at end of xml declaration"

    .line 730
    move/from16 v18, v6

    .line 731
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    const/16 v22, 0x24

    .line 732
    goto/16 :goto_0

    .line 737
    .end local v15    # "i":I
    .end local v18    # "pos":I
    .end local v20    # "quote":C
    .restart local v19    # "pos":I
    :cond_4e
    const-string v17, "<?xml must be at start of file"

    .line 738
    const/16 v22, 0x24

    move/from16 v18, v19

    .line 739
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 743
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_4f
    sub-int v7, v13, v6

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Lgnu/xml/XMLFilter;->processingInstructionFromParser([CIIII)V

    .line 745
    :cond_50
    move/from16 v4, v16

    .line 746
    const/4 v6, -0x1

    .line 747
    const/16 v22, 0x1

    .line 748
    goto/16 :goto_1

    .line 750
    .end local v13    # "end":I
    :cond_51
    move/from16 v0, v19

    move/from16 v1, v16

    if-ge v0, v1, :cond_1

    .line 751
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    aget-char v9, v3, v19

    move/from16 v19, v18

    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_e

    .line 811
    :cond_52
    move/from16 v0, v19

    move/from16 v1, v16

    if-ge v0, v1, :cond_1

    .line 812
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    aget-char v9, v3, v19

    move/from16 v19, v18

    .line 760
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :goto_1b
    const/16 v2, 0x3e

    if-ne v9, v2, :cond_55

    .line 762
    add-int/lit8 v2, v19, -0x1

    sub-int v5, v2, v4

    .line 763
    const/4 v2, 0x4

    if-lt v5, v2, :cond_54

    aget-char v2, v3, v4

    const/16 v7, 0x2d

    if-ne v2, v7, :cond_54

    add-int/lit8 v2, v4, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x2d

    if-ne v2, v7, :cond_54

    .line 767
    add-int/lit8 v2, v19, -0x2

    aget-char v2, v3, v2

    const/16 v7, 0x2d

    if-ne v2, v7, :cond_52

    add-int/lit8 v2, v19, -0x3

    aget-char v2, v3, v2

    const/16 v7, 0x2d

    if-ne v2, v7, :cond_52

    .line 770
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 771
    add-int/lit8 v2, v4, 0x2

    add-int/lit8 v7, v5, -0x4

    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v2, v7}, Lgnu/xml/XMLFilter;->commentFromParser([CII)V

    .line 816
    :cond_53
    :goto_1c
    move/from16 v4, v16

    .line 817
    const/16 v22, 0x1

    .line 818
    goto/16 :goto_1

    .line 775
    :cond_54
    const/4 v2, 0x6

    if-lt v5, v2, :cond_53

    aget-char v2, v3, v4

    const/16 v7, 0x5b

    if-ne v2, v7, :cond_53

    add-int/lit8 v2, v4, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x43

    if-ne v2, v7, :cond_53

    add-int/lit8 v2, v4, 0x2

    aget-char v2, v3, v2

    const/16 v7, 0x44

    if-ne v2, v7, :cond_53

    add-int/lit8 v2, v4, 0x3

    aget-char v2, v3, v2

    const/16 v7, 0x41

    if-ne v2, v7, :cond_53

    add-int/lit8 v2, v4, 0x4

    aget-char v2, v3, v2

    const/16 v7, 0x54

    if-ne v2, v7, :cond_53

    add-int/lit8 v2, v4, 0x5

    aget-char v2, v3, v2

    const/16 v7, 0x41

    if-ne v2, v7, :cond_53

    add-int/lit8 v2, v4, 0x6

    aget-char v2, v3, v2

    const/16 v7, 0x5b

    if-ne v2, v7, :cond_53

    .line 784
    add-int/lit8 v2, v19, -0x2

    aget-char v2, v3, v2

    const/16 v7, 0x5d

    if-ne v2, v7, :cond_52

    add-int/lit8 v2, v19, -0x3

    aget-char v2, v3, v2

    const/16 v7, 0x5d

    if-ne v2, v7, :cond_52

    .line 787
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 788
    add-int/lit8 v2, v4, 0x7

    add-int/lit8 v7, v19, -0xa

    sub-int/2addr v7, v4

    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v2, v7}, Lgnu/xml/XMLFilter;->writeCDATA([CII)V

    goto :goto_1c

    .line 798
    :cond_55
    add-int/lit8 v2, v4, 0x7

    move/from16 v0, v19

    if-ne v0, v2, :cond_52

    aget-char v2, v3, v4

    const/16 v7, 0x44

    if-ne v2, v7, :cond_52

    add-int/lit8 v2, v4, 0x1

    aget-char v2, v3, v2

    const/16 v7, 0x4f

    if-ne v2, v7, :cond_52

    add-int/lit8 v2, v4, 0x2

    aget-char v2, v3, v2

    const/16 v7, 0x43

    if-ne v2, v7, :cond_52

    add-int/lit8 v2, v4, 0x3

    aget-char v2, v3, v2

    const/16 v7, 0x54

    if-ne v2, v7, :cond_52

    add-int/lit8 v2, v4, 0x4

    aget-char v2, v3, v2

    const/16 v7, 0x59

    if-ne v2, v7, :cond_52

    add-int/lit8 v2, v4, 0x5

    aget-char v2, v3, v2

    const/16 v7, 0x50

    if-ne v2, v7, :cond_52

    const/16 v2, 0x45

    if-ne v9, v2, :cond_52

    .line 807
    move/from16 v4, v16

    .line 808
    const/16 v22, 0xf

    .line 809
    goto/16 :goto_1

    .line 821
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :pswitch_10
    const/16 v22, 0x11

    .line 822
    add-int/lit8 v4, v18, -0x1

    .line 823
    goto/16 :goto_0

    .line 826
    :pswitch_11
    if-gez v6, :cond_6b

    .line 829
    add-int/lit8 v6, v18, -0x1

    .line 830
    sub-int/2addr v6, v4

    .line 831
    shl-int/lit8 v6, v6, 0x1

    .line 832
    const/16 v23, 0x0

    move/from16 v19, v18

    .line 836
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :goto_1d
    const/16 v2, 0x27

    if-eq v9, v2, :cond_56

    const/16 v2, 0x22

    if-ne v9, v2, :cond_59

    .line 838
    :cond_56
    if-nez v23, :cond_58

    .line 839
    move/from16 v23, v9

    .line 864
    :cond_57
    :goto_1e
    move/from16 v0, v19

    move/from16 v1, v16

    if-ge v0, v1, :cond_1

    .line 865
    add-int/lit8 v18, v19, 0x1

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    aget-char v9, v3, v19

    move/from16 v19, v18

    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto :goto_1d

    .line 840
    :cond_58
    move/from16 v0, v23

    if-ne v0, v9, :cond_57

    .line 841
    const/16 v23, 0x0

    goto :goto_1e

    .line 843
    :cond_59
    if-nez v23, :cond_57

    .line 846
    const/16 v2, 0x5b

    if-ne v9, v2, :cond_5a

    .line 847
    or-int/lit8 v6, v6, 0x1

    goto :goto_1e

    .line 848
    :cond_5a
    const/16 v2, 0x5d

    if-ne v9, v2, :cond_5b

    .line 849
    and-int/lit8 v6, v6, -0x2

    goto :goto_1e

    .line 850
    :cond_5b
    const/16 v2, 0x3e

    if-ne v9, v2, :cond_57

    and-int/lit8 v2, v6, 0x1

    if-nez v2, :cond_57

    .line 852
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 853
    shr-int/lit8 v6, v6, 0x1

    .line 854
    add-int/2addr v6, v4

    .line 855
    add-int/lit8 v2, v19, -0x1

    sub-int v7, v2, v6

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Lgnu/xml/XMLFilter;->emitDoctypeDecl([CIIII)V

    .line 857
    const/16 v23, 0x3c

    .line 858
    move/from16 v4, v16

    .line 859
    const/4 v6, -0x1

    .line 860
    const/16 v22, 0x1

    .line 861
    goto/16 :goto_1

    .line 871
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :pswitch_12
    const/16 v23, 0x3c

    .line 872
    const/16 v10, 0xe

    .line 873
    const/16 v2, 0x2f

    if-ne v9, v2, :cond_5c

    .line 875
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 876
    invoke-virtual/range {p1 .. p1}, Lgnu/xml/XMLFilter;->emitEndAttributes()V

    .line 877
    const/4 v2, 0x0

    const/4 v7, 0x0

    const/16 v25, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v25

    invoke-virtual {v0, v2, v7, v1}, Lgnu/xml/XMLFilter;->emitEndElement([CII)V

    .line 878
    const/16 v22, 0x1b

    move/from16 v19, v18

    .line 879
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 881
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_5c
    const/16 v2, 0x3e

    if-ne v9, v2, :cond_5d

    .line 883
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 884
    invoke-virtual/range {p1 .. p1}, Lgnu/xml/XMLFilter;->emitEndAttributes()V

    .line 885
    const/16 v22, 0x1

    move/from16 v19, v18

    .line 886
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 888
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_5d
    add-int/lit8 v4, v18, -0x1

    .line 889
    const/16 v22, 0x9

    .line 890
    goto/16 :goto_0

    .line 892
    :pswitch_13
    const/16 v2, 0x20

    if-eq v9, v2, :cond_0

    const/16 v2, 0x9

    if-eq v9, v2, :cond_0

    const/16 v2, 0xd

    if-eq v9, v2, :cond_0

    const/16 v2, 0xa

    if-eq v9, v2, :cond_0

    const/16 v2, 0x85

    if-eq v9, v2, :cond_0

    const/16 v2, 0x2028

    if-ne v9, v2, :cond_5e

    move/from16 v19, v18

    .line 894
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 895
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_5e
    sub-int v2, v18, v5

    move-object/from16 v0, p0

    iput v2, v0, Lgnu/text/LineBufferedReader;->pos:I

    .line 896
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v4, v5}, Lgnu/xml/XMLFilter;->emitStartAttribute([CII)V

    .line 897
    move/from16 v4, v16

    .line 898
    const/16 v2, 0x3d

    if-ne v9, v2, :cond_5f

    .line 900
    const/16 v22, 0xb

    move/from16 v19, v18

    .line 901
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 903
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_5f
    invoke-virtual/range {p1 .. p1}, Lgnu/xml/XMLFilter;->emitEndAttributes()V

    .line 904
    const-string v17, "missing or misplaced \'=\' after attribute name"

    .line 905
    const/16 v22, 0x24

    .line 906
    goto/16 :goto_0

    .line 908
    :pswitch_14
    const/16 v2, 0x27

    if-eq v9, v2, :cond_60

    const/16 v2, 0x22

    if-ne v9, v2, :cond_61

    .line 910
    :cond_60
    move/from16 v23, v9

    .line 911
    const/16 v10, 0xc

    .line 912
    const/16 v22, 0x1

    move/from16 v19, v18

    .line 913
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 915
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_61
    const/16 v2, 0x20

    if-eq v9, v2, :cond_0

    const/16 v2, 0x9

    if-eq v9, v2, :cond_0

    const/16 v2, 0xd

    if-eq v9, v2, :cond_0

    const/16 v2, 0xa

    if-eq v9, v2, :cond_0

    const/16 v2, 0x85

    if-eq v9, v2, :cond_0

    const/16 v2, 0x2028

    if-ne v9, v2, :cond_62

    move/from16 v19, v18

    .line 917
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 918
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_62
    const-string v17, "missing or unquoted attribute value"

    .line 919
    const/16 v22, 0x24

    .line 920
    goto/16 :goto_0

    .line 924
    :pswitch_15
    add-int/lit8 v4, v18, -0x1

    .line 925
    const/16 v22, 0x5

    .line 926
    goto/16 :goto_0

    .line 929
    :pswitch_16
    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 930
    move-object/from16 v0, p1

    invoke-virtual {v0, v3, v4, v5}, Lgnu/xml/XMLFilter;->emitEndElement([CII)V

    .line 931
    move/from16 v4, v16

    .line 933
    const/16 v22, 0x1d

    .line 934
    goto/16 :goto_0

    .line 937
    :pswitch_17
    const/16 v2, 0x3e

    if-eq v9, v2, :cond_63

    .line 939
    const-string v17, "missing \'>\'"

    .line 940
    const/16 v22, 0x24

    .line 941
    goto/16 :goto_0

    .line 943
    :cond_63
    const/16 v22, 0x1

    move/from16 v19, v18

    .line 944
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1

    .line 952
    :cond_64
    sub-int v21, v19, v4

    .line 955
    .local v21, "saved":I
    if-lez v21, :cond_65

    .line 957
    :try_start_0
    move-object/from16 v0, p0

    iput v4, v0, Lgnu/text/LineBufferedReader;->pos:I

    .line 958
    add-int/lit8 v2, v21, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lgnu/text/LineBufferedReader;->mark(I)V

    .line 960
    :cond_65
    move/from16 v0, v19

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/text/LineBufferedReader;->pos:I

    .line 961
    invoke-virtual/range {p0 .. p0}, Lgnu/text/LineBufferedReader;->read()I

    move-result v24

    .line 962
    .local v24, "x":I
    if-gez v24, :cond_68

    .line 964
    const/4 v2, 0x1

    move/from16 v0, v22

    if-eq v0, v2, :cond_66

    const/16 v2, 0x1c

    move/from16 v0, v22

    if-ne v0, v2, :cond_67

    :cond_66
    move/from16 v18, v19

    .line 965
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_2

    .line 966
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_67
    const/16 v22, 0x25

    move/from16 v18, v19

    .line 967
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 969
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_68
    if-lez v21, :cond_69

    .line 971
    invoke-virtual/range {p0 .. p0}, Lgnu/text/LineBufferedReader;->reset()V

    .line 972
    move-object/from16 v0, p0

    move/from16 v1, v21

    invoke-virtual {v0, v1}, Lgnu/text/LineBufferedReader;->skip(I)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 981
    :goto_1f
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/text/LineBufferedReader;->pos:I

    move/from16 v18, v0

    .line 982
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/text/LineBufferedReader;->buffer:[C

    .line 984
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/text/LineBufferedReader;->limit:I

    move/from16 v16, v0

    .line 985
    if-lez v21, :cond_6a

    sub-int v4, v18, v21

    .line 986
    :goto_20
    add-int/lit8 v19, v18, 0x1

    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    aget-char v9, v3, v18

    move/from16 v18, v19

    .line 987
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    .line 975
    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    :cond_69
    :try_start_1
    invoke-virtual/range {p0 .. p0}, Lgnu/text/LineBufferedReader;->unread_quick()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1f

    .line 977
    .end local v24    # "x":I
    :catch_0
    move-exception v14

    .line 979
    .local v14, "ex":Ljava/io/IOException;
    new-instance v2, Ljava/lang/RuntimeException;

    invoke-virtual {v14}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v2, v7}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v2

    .end local v14    # "ex":Ljava/io/IOException;
    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    .restart local v24    # "x":I
    :cond_6a
    move/from16 v4, v16

    .line 985
    goto :goto_20

    .end local v21    # "saved":I
    .end local v24    # "x":I
    :cond_6b
    move/from16 v19, v18

    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1d

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :cond_6c
    move/from16 v19, v18

    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_e

    :cond_6d
    move/from16 v18, v19

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    goto/16 :goto_0

    :pswitch_18
    move/from16 v19, v18

    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_1b

    .end local v19    # "pos":I
    .restart local v18    # "pos":I
    :pswitch_19
    move/from16 v19, v18

    .end local v18    # "pos":I
    .restart local v19    # "pos":I
    goto/16 :goto_c

    .line 206
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_7
        :pswitch_e
        :pswitch_a
        :pswitch_16
        :pswitch_a
        :pswitch_c
        :pswitch_a
        :pswitch_13
        :pswitch_a
        :pswitch_12
        :pswitch_14
        :pswitch_9
        :pswitch_10
        :pswitch_d
        :pswitch_9
        :pswitch_11
        :pswitch_a
        :pswitch_0
        :pswitch_15
        :pswitch_18
        :pswitch_f
        :pswitch_0
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_19
        :pswitch_17
        :pswitch_8
        :pswitch_9
        :pswitch_f
        :pswitch_2
        :pswitch_9
        :pswitch_a
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public static parse(Ljava/io/InputStream;Ljava/lang/Object;Lgnu/text/SourceMessages;Lgnu/lists/Consumer;)V
    .locals 1
    .param p0, "strm"    # Ljava/io/InputStream;
    .param p1, "uri"    # Ljava/lang/Object;
    .param p2, "messages"    # Lgnu/text/SourceMessages;
    .param p3, "out"    # Lgnu/lists/Consumer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 133
    invoke-static {p0}, Lgnu/xml/XMLParser;->XMLStreamReader(Ljava/io/InputStream;)Lgnu/text/LineInputStreamReader;

    move-result-object v0

    .line 134
    .local v0, "in":Lgnu/text/LineInputStreamReader;
    if-eqz p1, :cond_0

    .line 135
    invoke-virtual {v0, p1}, Lgnu/text/LineInputStreamReader;->setName(Ljava/lang/Object;)V

    .line 136
    :cond_0
    invoke-static {v0, p2, p3}, Lgnu/xml/XMLParser;->parse(Lgnu/text/LineBufferedReader;Lgnu/text/SourceMessages;Lgnu/lists/Consumer;)V

    .line 137
    invoke-virtual {v0}, Lgnu/text/LineInputStreamReader;->close()V

    .line 138
    return-void
.end method

.method public static parse(Ljava/lang/Object;Lgnu/text/SourceMessages;Lgnu/lists/Consumer;)V
    .locals 1
    .param p0, "uri"    # Ljava/lang/Object;
    .param p1, "messages"    # Lgnu/text/SourceMessages;
    .param p2, "out"    # Lgnu/lists/Consumer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 58
    invoke-static {p0}, Lgnu/text/Path;->openInputStream(Ljava/lang/Object;)Ljava/io/InputStream;

    move-result-object v0

    invoke-static {v0, p0, p1, p2}, Lgnu/xml/XMLParser;->parse(Ljava/io/InputStream;Ljava/lang/Object;Lgnu/text/SourceMessages;Lgnu/lists/Consumer;)V

    .line 59
    return-void
.end method
