.class public Lgnu/bytecode/dump;
.super Lgnu/bytecode/ClassFileInput;
.source "dump.java"


# instance fields
.field writer:Lgnu/bytecode/ClassTypeWriter;


# direct methods
.method constructor <init>(Ljava/io/InputStream;Lgnu/bytecode/ClassTypeWriter;)V
    .locals 1
    .param p1, "str"    # Ljava/io/InputStream;
    .param p2, "writer"    # Lgnu/bytecode/ClassTypeWriter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassFormatError;
        }
    .end annotation

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lgnu/bytecode/ClassFileInput;-><init>(Ljava/io/InputStream;)V

    .line 35
    new-instance v0, Lgnu/bytecode/ClassType;

    invoke-direct {v0}, Lgnu/bytecode/ClassType;-><init>()V

    iput-object v0, p0, Lgnu/bytecode/dump;->ctype:Lgnu/bytecode/ClassType;

    .line 36
    invoke-virtual {p0}, Lgnu/bytecode/dump;->readFormatVersion()V

    .line 38
    invoke-virtual {p0}, Lgnu/bytecode/dump;->readConstants()Lgnu/bytecode/ConstantPool;

    .line 39
    invoke-virtual {p0}, Lgnu/bytecode/dump;->readClassInfo()V

    .line 40
    invoke-virtual {p0}, Lgnu/bytecode/dump;->readFields()V

    .line 41
    invoke-virtual {p0}, Lgnu/bytecode/dump;->readMethods()V

    .line 42
    iget-object v0, p0, Lgnu/bytecode/dump;->ctype:Lgnu/bytecode/ClassType;

    invoke-virtual {p0, v0}, Lgnu/bytecode/dump;->readAttributes(Lgnu/bytecode/AttrContainer;)I

    .line 44
    iget-object v0, p0, Lgnu/bytecode/dump;->ctype:Lgnu/bytecode/ClassType;

    invoke-virtual {p2, v0}, Lgnu/bytecode/ClassTypeWriter;->print(Lgnu/bytecode/ClassType;)V

    .line 45
    invoke-virtual {p2}, Lgnu/bytecode/ClassTypeWriter;->flush()V

    .line 46
    return-void
.end method

.method public static main([Ljava/lang/String;)V
    .locals 27
    .param p0, "args"    # [Ljava/lang/String;

    .prologue
    .line 153
    move-object/from16 v0, p0

    array-length v4, v0

    .line 154
    .local v4, "alen":I
    new-instance v19, Lgnu/bytecode/ClassTypeWriter;

    const/16 v24, 0x0

    sget-object v25, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const/16 v26, 0x0

    move-object/from16 v0, v19

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    move/from16 v3, v26

    invoke-direct {v0, v1, v2, v3}, Lgnu/bytecode/ClassTypeWriter;-><init>(Lgnu/bytecode/ClassType;Ljava/io/OutputStream;I)V

    .line 155
    .local v19, "out":Lgnu/bytecode/ClassTypeWriter;
    if-nez v4, :cond_0

    .line 156
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    invoke-static/range {v24 .. v24}, Lgnu/bytecode/dump;->usage(Ljava/io/PrintStream;)V

    .line 157
    :cond_0
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_0
    if-ge v14, v4, :cond_a

    .line 159
    aget-object v12, p0, v14

    .line 160
    .local v12, "filename":Ljava/lang/String;
    const-string v24, "-verbose"

    move-object/from16 v0, v24

    invoke-virtual {v12, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-nez v24, :cond_1

    const-string v24, "--verbose"

    move-object/from16 v0, v24

    invoke-virtual {v12, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_2

    .line 162
    :cond_1
    const/16 v24, 0xf

    move-object/from16 v0, v19

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Lgnu/bytecode/ClassTypeWriter;->setFlags(I)V

    .line 157
    :goto_1
    add-int/lit8 v14, v14, 0x1

    goto :goto_0

    .line 165
    :cond_2
    invoke-static {v12}, Lgnu/bytecode/dump;->uriSchemeSpecified(Ljava/lang/String;)Z

    move-result v17

    .line 169
    .local v17, "isURL":Z
    if-eqz v17, :cond_9

    .line 171
    :try_start_0
    const-string v24, "jar:"

    move-object/from16 v0, v24

    invoke-virtual {v12, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v16

    .line 172
    .local v16, "isJarURL":Z
    if-eqz v16, :cond_4

    .line 174
    const/16 v24, 0x4

    move/from16 v0, v24

    invoke-virtual {v12, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v20

    .line 176
    .local v20, "part":Ljava/lang/String;
    invoke-static/range {v20 .. v20}, Lgnu/bytecode/dump;->uriSchemeSpecified(Ljava/lang/String;)Z

    move-result v24

    if-nez v24, :cond_3

    .line 178
    const/16 v24, 0x21

    move-object/from16 v0, v20

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(I)I

    move-result v11

    .line 179
    .local v11, "excl":I
    if-ltz v11, :cond_3

    .line 181
    const/16 v24, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v24

    invoke-virtual {v0, v1, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v13

    .line 183
    .local v13, "filepart":Ljava/lang/String;
    new-instance v24, Ljava/io/File;

    move-object/from16 v0, v24

    invoke-direct {v0, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v24 .. v24}, Ljava/io/File;->toURI()Ljava/net/URI;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/net/URI;->toURL()Ljava/net/URL;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v13

    .line 187
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-direct/range {v24 .. v24}, Ljava/lang/StringBuilder;-><init>()V

    const-string v25, "jar:"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    move-object/from16 v0, v24

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    move-object/from16 v0, v20

    invoke-virtual {v0, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 191
    .end local v11    # "excl":I
    .end local v13    # "filepart":Ljava/lang/String;
    :cond_3
    const-string v24, "!/"

    move-object/from16 v0, v20

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v24

    if-gez v24, :cond_4

    .line 193
    const/16 v24, 0x21

    move/from16 v0, v24

    invoke-virtual {v12, v0}, Ljava/lang/String;->lastIndexOf(I)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v11

    .line 194
    .restart local v11    # "excl":I
    if-gtz v11, :cond_5

    .line 195
    const/16 v16, 0x0

    .line 207
    .end local v11    # "excl":I
    .end local v20    # "part":Ljava/lang/String;
    :cond_4
    :goto_2
    :try_start_1
    new-instance v23, Ljava/net/URL;

    move-object/from16 v0, v23

    invoke-direct {v0, v12}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/util/zip/ZipException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 210
    .local v23, "url":Ljava/net/URL;
    :try_start_2
    invoke-virtual/range {v23 .. v23}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;
    :try_end_2
    .catch Ljava/util/zip/ZipException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/io/FileNotFoundException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    move-result-object v15

    .line 302
    .end local v16    # "isJarURL":Z
    .end local v23    # "url":Ljava/net/URL;
    .local v15, "in":Ljava/io/InputStream;
    :goto_3
    :try_start_3
    move-object/from16 v0, v19

    invoke-static {v15, v12, v0}, Lgnu/bytecode/dump;->process(Ljava/io/InputStream;Ljava/lang/String;Lgnu/bytecode/ClassTypeWriter;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    goto/16 :goto_1

    .line 305
    .end local v15    # "in":Ljava/io/InputStream;
    :catch_0
    move-exception v7

    .line 307
    .local v7, "e":Ljava/io/IOException;
    invoke-virtual {v7}, Ljava/io/IOException;->printStackTrace()V

    .line 308
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, "caught "

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 309
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    move-object/from16 v0, v24

    invoke-virtual {v0, v7}, Ljava/io/PrintStream;->print(Ljava/lang/Object;)V

    .line 310
    const/16 v24, -0x1

    invoke-static/range {v24 .. v24}, Ljava/lang/System;->exit(I)V

    goto/16 :goto_1

    .line 196
    .end local v7    # "e":Ljava/io/IOException;
    .restart local v11    # "excl":I
    .restart local v16    # "isJarURL":Z
    .restart local v20    # "part":Ljava/lang/String;
    :cond_5
    const/16 v24, 0x2f

    :try_start_4
    move/from16 v0, v24

    invoke-virtual {v12, v0, v11}, Ljava/lang/String;->indexOf(II)I

    move-result v24

    if-gez v24, :cond_4

    .line 198
    add-int/lit8 v24, v11, 0x1

    move/from16 v0, v24

    invoke-virtual {v12, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v20

    .line 199
    const/16 v24, 0x2e

    const/16 v25, 0x2f

    move-object/from16 v0, v20

    move/from16 v1, v24

    move/from16 v2, v25

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v20

    .line 200
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-direct/range {v24 .. v24}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v25, 0x0

    add-int/lit8 v26, v11, 0x1

    move/from16 v0, v25

    move/from16 v1, v26

    invoke-virtual {v12, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    const/16 v25, 0x2f

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v24

    move-object/from16 v0, v24

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, ".class"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0

    move-result-object v12

    goto :goto_2

    .line 212
    .end local v11    # "excl":I
    .end local v20    # "part":Ljava/lang/String;
    .restart local v23    # "url":Ljava/net/URL;
    :catch_1
    move-exception v8

    .line 214
    .local v8, "e1":Ljava/util/zip/ZipException;
    if-eqz v16, :cond_7

    .line 216
    :try_start_5
    invoke-virtual/range {v23 .. v23}, Ljava/net/URL;->getFile()Ljava/lang/String;

    move-result-object v13

    .line 217
    .restart local v13    # "filepart":Ljava/lang/String;
    const/16 v24, 0x21

    move/from16 v0, v24

    invoke-virtual {v13, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v22

    .line 218
    .local v22, "sl":I
    if-lez v22, :cond_6

    .line 219
    const/16 v24, 0x0

    move/from16 v0, v24

    move/from16 v1, v22

    invoke-virtual {v13, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;
    :try_end_5
    .catch Ljava/io/FileNotFoundException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/util/zip/ZipException; {:try_start_5 .. :try_end_5} :catch_4
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0

    move-result-object v13

    .line 222
    :cond_6
    :try_start_6
    new-instance v24, Ljava/net/URL;

    move-object/from16 v0, v24

    invoke-direct {v0, v13}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v24 .. v24}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;
    :try_end_6
    .catch Ljava/io/FileNotFoundException; {:try_start_6 .. :try_end_6} :catch_3
    .catch Ljava/util/zip/ZipException; {:try_start_6 .. :try_end_6} :catch_4
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0

    .line 232
    .end local v13    # "filepart":Ljava/lang/String;
    .end local v22    # "sl":I
    :cond_7
    :goto_4
    :try_start_7
    throw v8
    :try_end_7
    .catch Ljava/io/FileNotFoundException; {:try_start_7 .. :try_end_7} :catch_2
    .catch Ljava/util/zip/ZipException; {:try_start_7 .. :try_end_7} :catch_4
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_0

    .line 235
    .end local v8    # "e1":Ljava/util/zip/ZipException;
    .end local v23    # "url":Ljava/net/URL;
    :catch_2
    move-exception v8

    .line 237
    .local v8, "e1":Ljava/io/FileNotFoundException;
    :try_start_8
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, "File for URL "

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 238
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    move-object/from16 v0, v24

    invoke-virtual {v0, v12}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 239
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, " not found."

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 240
    const/16 v24, -0x1

    invoke-static/range {v24 .. v24}, Ljava/lang/System;->exit(I)V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_0

    .line 241
    const/4 v15, 0x0

    .line 253
    .restart local v15    # "in":Ljava/io/InputStream;
    goto/16 :goto_3

    .line 224
    .end local v15    # "in":Ljava/io/InputStream;
    .local v8, "e1":Ljava/util/zip/ZipException;
    .restart local v13    # "filepart":Ljava/lang/String;
    .restart local v22    # "sl":I
    .restart local v23    # "url":Ljava/net/URL;
    :catch_3
    move-exception v9

    .line 226
    .local v9, "e2":Ljava/io/FileNotFoundException;
    :try_start_9
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, "Jar File for URL "

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 227
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    move-object/from16 v0, v24

    invoke-virtual {v0, v13}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 228
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, " not found."

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 229
    const/16 v24, -0x1

    invoke-static/range {v24 .. v24}, Ljava/lang/System;->exit(I)V
    :try_end_9
    .catch Ljava/io/FileNotFoundException; {:try_start_9 .. :try_end_9} :catch_2
    .catch Ljava/util/zip/ZipException; {:try_start_9 .. :try_end_9} :catch_4
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_0

    goto :goto_4

    .line 243
    .end local v8    # "e1":Ljava/util/zip/ZipException;
    .end local v9    # "e2":Ljava/io/FileNotFoundException;
    .end local v13    # "filepart":Ljava/lang/String;
    .end local v22    # "sl":I
    .end local v23    # "url":Ljava/net/URL;
    :catch_4
    move-exception v8

    .line 245
    .restart local v8    # "e1":Ljava/util/zip/ZipException;
    :try_start_a
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, "Error opening zip archive "

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 246
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    move-object/from16 v0, v24

    invoke-virtual {v0, v12}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 247
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, " not found."

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 248
    invoke-virtual {v8}, Ljava/util/zip/ZipException;->printStackTrace()V

    .line 249
    invoke-virtual {v8}, Ljava/util/zip/ZipException;->getCause()Ljava/lang/Throwable;

    move-result-object v24

    if-eqz v24, :cond_8

    .line 250
    invoke-virtual {v8}, Ljava/util/zip/ZipException;->getCause()Ljava/lang/Throwable;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/Throwable;->printStackTrace()V

    .line 251
    :cond_8
    const/16 v24, -0x1

    invoke-static/range {v24 .. v24}, Ljava/lang/System;->exit(I)V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_0

    .line 252
    const/4 v15, 0x0

    .restart local v15    # "in":Ljava/io/InputStream;
    goto/16 :goto_3

    .line 259
    .end local v8    # "e1":Ljava/util/zip/ZipException;
    .end local v15    # "in":Ljava/io/InputStream;
    .end local v16    # "isJarURL":Z
    :cond_9
    :try_start_b
    new-instance v15, Ljava/io/FileInputStream;

    invoke-direct {v15, v12}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_b
    .catch Ljava/io/FileNotFoundException; {:try_start_b .. :try_end_b} :catch_5
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_0

    .restart local v15    # "in":Ljava/io/InputStream;
    goto/16 :goto_3

    .line 261
    .end local v15    # "in":Ljava/io/InputStream;
    :catch_5
    move-exception v8

    .line 267
    .local v8, "e1":Ljava/io/FileNotFoundException;
    :try_start_c
    invoke-static {v12}, Lgnu/bytecode/ObjectType;->getContextClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v5

    .line 268
    .local v5, "clas":Ljava/lang/Class;
    invoke-virtual {v5}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;
    :try_end_c
    .catch Ljava/lang/NoClassDefFoundError; {:try_start_c .. :try_end_c} :catch_6
    .catch Ljava/lang/Throwable; {:try_start_c .. :try_end_c} :catch_7
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_0

    move-result-object v18

    .line 284
    .end local v5    # "clas":Ljava/lang/Class;
    .local v18, "loader":Ljava/lang/ClassLoader;
    :goto_5
    :try_start_d
    new-instance v24, Ljava/lang/StringBuilder;

    invoke-direct/range {v24 .. v24}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v25, 0x2e

    const/16 v26, 0x2f

    move/from16 v0, v25

    move/from16 v1, v26

    invoke-virtual {v12, v0, v1}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    const-string v25, ".class"

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_0

    move-result-object v6

    .line 287
    .local v6, "clfilename":Ljava/lang/String;
    :try_start_e
    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Ljava/lang/ClassLoader;->getResource(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v21

    .line 288
    .local v21, "resource":Ljava/net/URL;
    invoke-virtual/range {v21 .. v21}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v15

    .line 289
    .restart local v15    # "in":Ljava/io/InputStream;
    invoke-virtual/range {v21 .. v21}, Ljava/net/URL;->toString()Ljava/lang/String;
    :try_end_e
    .catch Ljava/lang/Throwable; {:try_start_e .. :try_end_e} :catch_8
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_0

    move-result-object v12

    goto/16 :goto_3

    .line 270
    .end local v6    # "clfilename":Ljava/lang/String;
    .end local v15    # "in":Ljava/io/InputStream;
    .end local v18    # "loader":Ljava/lang/ClassLoader;
    .end local v21    # "resource":Ljava/net/URL;
    :catch_6
    move-exception v9

    .line 272
    .local v9, "e2":Ljava/lang/NoClassDefFoundError;
    :try_start_f
    invoke-static {}, Lgnu/bytecode/ObjectType;->getContextClassLoader()Ljava/lang/ClassLoader;

    move-result-object v18

    .line 282
    .restart local v18    # "loader":Ljava/lang/ClassLoader;
    goto :goto_5

    .line 274
    .end local v9    # "e2":Ljava/lang/NoClassDefFoundError;
    .end local v18    # "loader":Ljava/lang/ClassLoader;
    :catch_7
    move-exception v9

    .line 276
    .local v9, "e2":Ljava/lang/Throwable;
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, "File "

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 277
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    move-object/from16 v0, v24

    invoke-virtual {v0, v12}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 278
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, " not found."

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 279
    const/16 v24, -0x1

    invoke-static/range {v24 .. v24}, Ljava/lang/System;->exit(I)V

    .line 280
    const/16 v18, 0x0

    .line 281
    .restart local v18    # "loader":Ljava/lang/ClassLoader;
    goto :goto_5

    .line 291
    .end local v9    # "e2":Ljava/lang/Throwable;
    .restart local v6    # "clfilename":Ljava/lang/String;
    :catch_8
    move-exception v10

    .line 293
    .local v10, "ex":Ljava/lang/Throwable;
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, "Can\'t find .class file for class "

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 294
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    move-object/from16 v0, v24

    invoke-virtual {v0, v12}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 295
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v25, " - "

    invoke-virtual/range {v24 .. v25}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 296
    sget-object v24, Ljava/lang/System;->err:Ljava/io/PrintStream;

    move-object/from16 v0, v24

    invoke-virtual {v0, v10}, Ljava/io/PrintStream;->println(Ljava/lang/Object;)V

    .line 297
    const/16 v24, -0x1

    invoke-static/range {v24 .. v24}, Ljava/lang/System;->exit(I)V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_0

    .line 298
    const/4 v15, 0x0

    .restart local v15    # "in":Ljava/io/InputStream;
    goto/16 :goto_3

    .line 313
    .end local v6    # "clfilename":Ljava/lang/String;
    .end local v8    # "e1":Ljava/io/FileNotFoundException;
    .end local v10    # "ex":Ljava/lang/Throwable;
    .end local v12    # "filename":Ljava/lang/String;
    .end local v15    # "in":Ljava/io/InputStream;
    .end local v17    # "isURL":Z
    .end local v18    # "loader":Ljava/lang/ClassLoader;
    :cond_a
    return-void
.end method

.method public static process(Ljava/io/InputStream;Ljava/lang/String;Lgnu/bytecode/ClassTypeWriter;)V
    .locals 9
    .param p0, "in"    # Ljava/io/InputStream;
    .param p1, "filename"    # Ljava/lang/String;
    .param p2, "out"    # Lgnu/bytecode/ClassTypeWriter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, -0x1

    const v7, -0x35014542    # -8346975.0f

    const/16 v6, 0x2e

    .line 91
    new-instance v0, Ljava/io/BufferedInputStream;

    invoke-direct {v0, p0}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 92
    .local v0, "inp":Ljava/io/InputStream;
    const/4 v5, 0x5

    invoke-virtual {v0, v5}, Ljava/io/InputStream;->mark(I)V

    .line 93
    invoke-static {v0}, Lgnu/bytecode/dump;->readMagic(Ljava/io/InputStream;)I

    move-result v1

    .line 94
    .local v1, "magic":I
    if-ne v1, v7, :cond_0

    .line 96
    const-string v5, "Reading .class from "

    invoke-virtual {p2, v5}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 97
    invoke-virtual {p2, p1}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 98
    invoke-virtual {p2, v6}, Lgnu/bytecode/ClassTypeWriter;->println(C)V

    .line 99
    new-instance v5, Lgnu/bytecode/dump;

    invoke-direct {v5, v0, p2}, Lgnu/bytecode/dump;-><init>(Ljava/io/InputStream;Lgnu/bytecode/ClassTypeWriter;)V

    .line 144
    :goto_0
    return-void

    .line 101
    :cond_0
    const v5, 0x504b0304

    if-ne v1, v5, :cond_4

    .line 103
    invoke-virtual {v0}, Ljava/io/InputStream;->reset()V

    .line 104
    const-string v5, "Reading classes from archive "

    invoke-virtual {p2, v5}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 105
    invoke-virtual {p2, p1}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 106
    invoke-virtual {p2, v6}, Lgnu/bytecode/ClassTypeWriter;->println(C)V

    .line 107
    new-instance v4, Ljava/util/zip/ZipInputStream;

    invoke-direct {v4, v0}, Ljava/util/zip/ZipInputStream;-><init>(Ljava/io/InputStream;)V

    .line 109
    .local v4, "zin":Ljava/util/zip/ZipInputStream;
    :goto_1
    invoke-virtual {v4}, Ljava/util/zip/ZipInputStream;->getNextEntry()Ljava/util/zip/ZipEntry;

    move-result-object v3

    .local v3, "zent":Ljava/util/zip/ZipEntry;
    if-eqz v3, :cond_3

    .line 111
    invoke-virtual {v3}, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;

    move-result-object v2

    .line 112
    .local v2, "name":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/util/zip/ZipEntry;->isDirectory()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 114
    const-string v5, "Archive directory: "

    invoke-virtual {p2, v5}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 115
    invoke-virtual {p2, v2}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 116
    invoke-virtual {p2, v6}, Lgnu/bytecode/ClassTypeWriter;->println(C)V

    goto :goto_1

    .line 120
    :cond_1
    invoke-virtual {p2}, Lgnu/bytecode/ClassTypeWriter;->println()V

    .line 121
    invoke-static {v4}, Lgnu/bytecode/dump;->readMagic(Ljava/io/InputStream;)I

    move-result v1

    .line 122
    if-ne v1, v7, :cond_2

    .line 124
    const-string v5, "Reading class member: "

    invoke-virtual {p2, v5}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 125
    invoke-virtual {p2, v2}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 126
    invoke-virtual {p2, v6}, Lgnu/bytecode/ClassTypeWriter;->println(C)V

    .line 127
    new-instance v5, Lgnu/bytecode/dump;

    invoke-direct {v5, v4, p2}, Lgnu/bytecode/dump;-><init>(Ljava/io/InputStream;Lgnu/bytecode/ClassTypeWriter;)V

    goto :goto_1

    .line 131
    :cond_2
    const-string v5, "Skipping non-class member: "

    invoke-virtual {p2, v5}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 132
    invoke-virtual {p2, v2}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 133
    invoke-virtual {p2, v6}, Lgnu/bytecode/ClassTypeWriter;->println(C)V

    goto :goto_1

    .line 137
    .end local v2    # "name":Ljava/lang/String;
    :cond_3
    invoke-static {v8}, Ljava/lang/System;->exit(I)V

    goto :goto_0

    .line 141
    .end local v3    # "zent":Ljava/util/zip/ZipEntry;
    .end local v4    # "zin":Ljava/util/zip/ZipInputStream;
    :cond_4
    sget-object v5, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "File "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " is not a valid .class file"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 142
    invoke-static {v8}, Ljava/lang/System;->exit(I)V

    goto :goto_0
.end method

.method public static process(Ljava/io/InputStream;Ljava/lang/String;Ljava/io/OutputStream;I)V
    .locals 2
    .param p0, "in"    # Ljava/io/InputStream;
    .param p1, "filename"    # Ljava/lang/String;
    .param p2, "out"    # Ljava/io/OutputStream;
    .param p3, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 77
    new-instance v0, Lgnu/bytecode/ClassTypeWriter;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p2, p3}, Lgnu/bytecode/ClassTypeWriter;-><init>(Lgnu/bytecode/ClassType;Ljava/io/OutputStream;I)V

    invoke-static {p0, p1, v0}, Lgnu/bytecode/dump;->process(Ljava/io/InputStream;Ljava/lang/String;Lgnu/bytecode/ClassTypeWriter;)V

    .line 78
    return-void
.end method

.method public static process(Ljava/io/InputStream;Ljava/lang/String;Ljava/io/Writer;I)V
    .locals 2
    .param p0, "in"    # Ljava/io/InputStream;
    .param p1, "filename"    # Ljava/lang/String;
    .param p2, "out"    # Ljava/io/Writer;
    .param p3, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 84
    new-instance v0, Lgnu/bytecode/ClassTypeWriter;

    const/4 v1, 0x0

    invoke-direct {v0, v1, p2, p3}, Lgnu/bytecode/ClassTypeWriter;-><init>(Lgnu/bytecode/ClassType;Ljava/io/Writer;I)V

    invoke-static {p0, p1, v0}, Lgnu/bytecode/dump;->process(Ljava/io/InputStream;Ljava/lang/String;Lgnu/bytecode/ClassTypeWriter;)V

    .line 85
    return-void
.end method

.method static readMagic(Ljava/io/InputStream;)I
    .locals 5
    .param p0, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 62
    const/4 v2, 0x0

    .line 63
    .local v2, "magic":I
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_0
    const/4 v3, 0x4

    if-ge v1, v3, :cond_0

    .line 65
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v0

    .line 66
    .local v0, "b":I
    if-gez v0, :cond_1

    .line 70
    .end local v0    # "b":I
    :cond_0
    return v2

    .line 68
    .restart local v0    # "b":I
    :cond_1
    shl-int/lit8 v3, v2, 0x8

    and-int/lit16 v4, v0, 0xff

    or-int v2, v3, v4

    .line 63
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method static uriSchemeLength(Ljava/lang/String;)I
    .locals 5
    .param p0, "uri"    # Ljava/lang/String;

    .prologue
    const/4 v3, -0x1

    .line 325
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 326
    .local v2, "len":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_4

    .line 328
    invoke-virtual {p0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 329
    .local v0, "ch":C
    const/16 v4, 0x3a

    if-ne v0, v4, :cond_0

    .line 336
    .end local v0    # "ch":C
    .end local v1    # "i":I
    :goto_1
    return v1

    .line 331
    .restart local v0    # "ch":C
    .restart local v1    # "i":I
    :cond_0
    if-nez v1, :cond_2

    invoke-static {v0}, Ljava/lang/Character;->isLetter(C)Z

    move-result v4

    if-nez v4, :cond_3

    :cond_1
    move v1, v3

    .line 334
    goto :goto_1

    .line 331
    :cond_2
    invoke-static {v0}, Ljava/lang/Character;->isLetterOrDigit(C)Z

    move-result v4

    if-nez v4, :cond_3

    const/16 v4, 0x2b

    if-eq v0, v4, :cond_3

    const/16 v4, 0x2d

    if-eq v0, v4, :cond_3

    const/16 v4, 0x2e

    if-ne v0, v4, :cond_1

    .line 326
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .end local v0    # "ch":C
    :cond_4
    move v1, v3

    .line 336
    goto :goto_1
.end method

.method static uriSchemeSpecified(Ljava/lang/String;)Z
    .locals 6
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 348
    invoke-static {p0}, Lgnu/bytecode/dump;->uriSchemeLength(Ljava/lang/String;)I

    move-result v1

    .line 349
    .local v1, "ulen":I
    if-ne v1, v3, :cond_3

    sget-char v4, Ljava/io/File;->separatorChar:C

    const/16 v5, 0x5c

    if-ne v4, v5, :cond_3

    .line 351
    invoke-virtual {p0, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 352
    .local v0, "drive":C
    const/16 v4, 0x61

    if-lt v0, v4, :cond_0

    const/16 v4, 0x7a

    if-le v0, v4, :cond_2

    :cond_0
    const/16 v4, 0x41

    if-lt v0, v4, :cond_1

    const/16 v4, 0x5a

    if-le v0, v4, :cond_2

    :cond_1
    move v2, v3

    .line 355
    .end local v0    # "drive":C
    :cond_2
    :goto_0
    return v2

    :cond_3
    if-lez v1, :cond_4

    :goto_1
    move v2, v3

    goto :goto_0

    :cond_4
    move v3, v2

    goto :goto_1
.end method

.method public static usage(Ljava/io/PrintStream;)V
    .locals 1
    .param p0, "err"    # Ljava/io/PrintStream;

    .prologue
    .line 360
    const-string v0, "Prints and dis-assembles the contents of JVM .class files."

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 361
    const-string v0, "Usage: [--verbose] class-or-jar ..."

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 362
    const-string v0, "where a class-or-jar can be one of:"

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 363
    const-string v0, "- a fully-qualified class name; or"

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 364
    const-string v0, "- the name of a .class file, or a URL reference to one; or"

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 365
    const-string v0, "- the name of a .jar or .zip archive file, or a URL reference to one."

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 366
    const-string v0, "If a .jar/.zip archive is named, all its.class file members are printed."

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 367
    invoke-virtual {p0}, Ljava/io/PrintStream;->println()V

    .line 368
    const-string v0, "You can name a single .class member of an archive with a jar: URL,"

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 369
    const-string v0, "which looks like: jar:jar-spec!/p1/p2/cl.class"

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 370
    const-string v0, "The jar-spec can be a URL or the name of the .jar file."

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 371
    const-string v0, "You can also use the shorthand syntax: jar:jar-spec!p1.p2.cl"

    invoke-virtual {p0, v0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 372
    const/4 v0, -0x1

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    .line 373
    return-void
.end method


# virtual methods
.method public readAttribute(Ljava/lang/String;ILgnu/bytecode/AttrContainer;)Lgnu/bytecode/Attribute;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "length"    # I
    .param p3, "container"    # Lgnu/bytecode/AttrContainer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 57
    invoke-super {p0, p1, p2, p3}, Lgnu/bytecode/ClassFileInput;->readAttribute(Ljava/lang/String;ILgnu/bytecode/AttrContainer;)Lgnu/bytecode/Attribute;

    move-result-object v0

    return-object v0
.end method

.method public readConstants()Lgnu/bytecode/ConstantPool;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 50
    iget-object v0, p0, Lgnu/bytecode/dump;->ctype:Lgnu/bytecode/ClassType;

    invoke-super {p0}, Lgnu/bytecode/ClassFileInput;->readConstants()Lgnu/bytecode/ConstantPool;

    move-result-object v1

    iput-object v1, v0, Lgnu/bytecode/ClassType;->constants:Lgnu/bytecode/ConstantPool;

    .line 51
    iget-object v0, p0, Lgnu/bytecode/dump;->ctype:Lgnu/bytecode/ClassType;

    iget-object v0, v0, Lgnu/bytecode/ClassType;->constants:Lgnu/bytecode/ConstantPool;

    return-object v0
.end method
