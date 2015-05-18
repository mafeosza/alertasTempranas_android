.class public Lgnu/bytecode/ZipArchive;
.super Ljava/lang/Object;
.source "ZipArchive.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static copy(Ljava/io/InputStream;Ljava/io/OutputStream;[B)J
    .locals 5
    .param p0, "in"    # Ljava/io/InputStream;
    .param p1, "out"    # Ljava/io/OutputStream;
    .param p2, "buffer"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 25
    const-wide/16 v1, 0x0

    .line 28
    .local v1, "total":J
    :goto_0
    invoke-virtual {p0, p2}, Ljava/io/InputStream;->read([B)I

    move-result v0

    .line 29
    .local v0, "count":I
    if-gtz v0, :cond_0

    .line 30
    return-wide v1

    .line 31
    :cond_0
    const/4 v3, 0x0

    invoke-virtual {p1, p2, v3, v0}, Ljava/io/OutputStream;->write([BII)V

    .line 32
    int-to-long v3, v0

    add-long/2addr v1, v3

    .line 33
    goto :goto_0
.end method

.method public static copy(Ljava/io/InputStream;Ljava/lang/String;[B)V
    .locals 7
    .param p0, "in"    # Ljava/io/InputStream;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "buffer"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 39
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 40
    .local v2, "f":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v1

    .line 41
    .local v1, "dir_name":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 43
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 44
    .local v0, "dir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 45
    sget-object v4, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "mkdirs:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 47
    .end local v0    # "dir":Ljava/io/File;
    :cond_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x2f

    if-eq v4, v5, :cond_1

    .line 49
    new-instance v3, Ljava/io/BufferedOutputStream;

    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v3, v4}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 50
    .local v3, "out":Ljava/io/OutputStream;
    invoke-static {p0, v3, p2}, Lgnu/bytecode/ZipArchive;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;[B)J

    .line 51
    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V

    .line 53
    .end local v3    # "out":Ljava/io/OutputStream;
    :cond_1
    return-void
.end method

.method public static main([Ljava/lang/String;)V
    .locals 20
    .param p0, "args"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 77
    move-object/from16 v0, p0

    array-length v0, v0

    move/from16 v17, v0

    const/16 v18, 0x2

    move/from16 v0, v17

    move/from16 v1, v18

    if-ge v0, v1, :cond_0

    .line 78
    invoke-static {}, Lgnu/bytecode/ZipArchive;->usage()V

    .line 79
    :cond_0
    const/16 v17, 0x0

    aget-object v4, p0, v17

    .line 80
    .local v4, "command":Ljava/lang/String;
    const/16 v17, 0x1

    aget-object v2, p0, v17

    .line 84
    .local v2, "archive_name":Ljava/lang/String;
    :try_start_0
    const-string v17, "t"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_1

    const-string v17, "p"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_1

    const-string v17, "x"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_9

    .line 88
    :cond_1
    sget-object v11, Ljava/lang/System;->out:Ljava/io/PrintStream;

    .line 89
    .local v11, "out":Ljava/io/PrintStream;
    const/16 v17, 0x400

    move/from16 v0, v17

    new-array v3, v0, [B

    .line 90
    .local v3, "buf":[B
    move-object/from16 v0, p0

    array-length v0, v0

    move/from16 v17, v0

    const/16 v18, 0x2

    move/from16 v0, v17

    move/from16 v1, v18

    if-ne v0, v1, :cond_5

    .line 92
    new-instance v9, Ljava/io/BufferedInputStream;

    new-instance v17, Ljava/io/FileInputStream;

    move-object/from16 v0, v17

    invoke-direct {v0, v2}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-direct {v9, v0}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 94
    .local v9, "in":Ljava/io/BufferedInputStream;
    new-instance v16, Ljava/util/zip/ZipInputStream;

    move-object/from16 v0, v16

    invoke-direct {v0, v9}, Ljava/util/zip/ZipInputStream;-><init>(Ljava/io/InputStream;)V

    .line 96
    .local v16, "zin":Ljava/util/zip/ZipInputStream;
    :goto_0
    invoke-virtual/range {v16 .. v16}, Ljava/util/zip/ZipInputStream;->getNextEntry()Ljava/util/zip/ZipEntry;

    move-result-object v15

    .local v15, "zent":Ljava/util/zip/ZipEntry;
    if-eqz v15, :cond_2

    .line 98
    invoke-virtual {v15}, Ljava/util/zip/ZipEntry;->getName()Ljava/lang/String;

    move-result-object v10

    .line 99
    .local v10, "name":Ljava/lang/String;
    const-string v17, "t"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_3

    .line 101
    invoke-virtual {v11, v10}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 102
    const-string v17, " size: "

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 103
    invoke-virtual {v15}, Ljava/util/zip/ZipEntry;->getSize()J

    move-result-wide v17

    move-wide/from16 v0, v17

    invoke-virtual {v11, v0, v1}, Ljava/io/PrintStream;->println(J)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 174
    .end local v3    # "buf":[B
    .end local v9    # "in":Ljava/io/BufferedInputStream;
    .end local v10    # "name":Ljava/lang/String;
    .end local v11    # "out":Ljava/io/PrintStream;
    .end local v15    # "zent":Ljava/util/zip/ZipEntry;
    .end local v16    # "zin":Ljava/util/zip/ZipInputStream;
    :catch_0
    move-exception v6

    .line 176
    .local v6, "ex":Ljava/io/IOException;
    sget-object v17, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "I/O Exception:  "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 178
    .end local v6    # "ex":Ljava/io/IOException;
    :cond_2
    :goto_1
    return-void

    .line 105
    .restart local v3    # "buf":[B
    .restart local v9    # "in":Ljava/io/BufferedInputStream;
    .restart local v10    # "name":Ljava/lang/String;
    .restart local v11    # "out":Ljava/io/PrintStream;
    .restart local v15    # "zent":Ljava/util/zip/ZipEntry;
    .restart local v16    # "zin":Ljava/util/zip/ZipInputStream;
    :cond_3
    :try_start_1
    const-string v17, "p"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_4

    .line 107
    move-object/from16 v0, v16

    invoke-static {v0, v11, v3}, Lgnu/bytecode/ZipArchive;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;[B)J

    goto :goto_0

    .line 111
    :cond_4
    move-object/from16 v0, v16

    invoke-static {v0, v10, v3}, Lgnu/bytecode/ZipArchive;->copy(Ljava/io/InputStream;Ljava/lang/String;[B)V

    goto :goto_0

    .line 117
    .end local v9    # "in":Ljava/io/BufferedInputStream;
    .end local v10    # "name":Ljava/lang/String;
    .end local v15    # "zent":Ljava/util/zip/ZipEntry;
    .end local v16    # "zin":Ljava/util/zip/ZipInputStream;
    :cond_5
    new-instance v13, Ljava/util/zip/ZipFile;

    invoke-direct {v13, v2}, Ljava/util/zip/ZipFile;-><init>(Ljava/lang/String;)V

    .line 118
    .local v13, "zar":Ljava/util/zip/ZipFile;
    const/4 v8, 0x2

    .local v8, "i":I
    :goto_2
    move-object/from16 v0, p0

    array-length v0, v0

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v8, v0, :cond_2

    .line 120
    aget-object v10, p0, v8

    .line 121
    .restart local v10    # "name":Ljava/lang/String;
    invoke-virtual {v13, v10}, Ljava/util/zip/ZipFile;->getEntry(Ljava/lang/String;)Ljava/util/zip/ZipEntry;

    move-result-object v15

    .line 122
    .restart local v15    # "zent":Ljava/util/zip/ZipEntry;
    if-nez v15, :cond_6

    .line 124
    sget-object v17, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "zipfile "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, ":"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    aget-object v19, p0, v8

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " - not found"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 126
    const/16 v17, -0x1

    invoke-static/range {v17 .. v17}, Ljava/lang/System;->exit(I)V

    .line 118
    :goto_3
    add-int/lit8 v8, v8, 0x1

    goto :goto_2

    .line 128
    :cond_6
    const-string v17, "t"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_7

    .line 130
    invoke-virtual {v11, v10}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 131
    const-string v17, " size: "

    move-object/from16 v0, v17

    invoke-virtual {v11, v0}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 132
    invoke-virtual {v15}, Ljava/util/zip/ZipEntry;->getSize()J

    move-result-wide v17

    move-wide/from16 v0, v17

    invoke-virtual {v11, v0, v1}, Ljava/io/PrintStream;->println(J)V

    goto :goto_3

    .line 134
    :cond_7
    const-string v17, "p"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_8

    .line 136
    invoke-virtual {v13, v15}, Ljava/util/zip/ZipFile;->getInputStream(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-static {v0, v11, v3}, Lgnu/bytecode/ZipArchive;->copy(Ljava/io/InputStream;Ljava/io/OutputStream;[B)J

    goto :goto_3

    .line 140
    :cond_8
    invoke-virtual {v13, v15}, Ljava/util/zip/ZipFile;->getInputStream(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-static {v0, v10, v3}, Lgnu/bytecode/ZipArchive;->copy(Ljava/io/InputStream;Ljava/lang/String;[B)V

    goto :goto_3

    .line 145
    .end local v3    # "buf":[B
    .end local v8    # "i":I
    .end local v10    # "name":Ljava/lang/String;
    .end local v11    # "out":Ljava/io/PrintStream;
    .end local v13    # "zar":Ljava/util/zip/ZipFile;
    .end local v15    # "zent":Ljava/util/zip/ZipEntry;
    :cond_9
    const-string v17, "q"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_e

    .line 147
    new-instance v13, Ljava/util/zip/ZipOutputStream;

    new-instance v17, Ljava/io/FileOutputStream;

    move-object/from16 v0, v17

    invoke-direct {v0, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-direct {v13, v0}, Ljava/util/zip/ZipOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 149
    .local v13, "zar":Ljava/util/zip/ZipOutputStream;
    const/4 v8, 0x2

    .restart local v8    # "i":I
    :goto_4
    move-object/from16 v0, p0

    array-length v0, v0

    move/from16 v17, v0

    move/from16 v0, v17

    if-ge v8, v0, :cond_d

    .line 151
    new-instance v9, Ljava/io/File;

    aget-object v17, p0, v8

    move-object/from16 v0, v17

    invoke-direct {v9, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 152
    .local v9, "in":Ljava/io/File;
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v17

    if-nez v17, :cond_a

    .line 153
    new-instance v17, Ljava/io/IOException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v19, p0, v8

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " - not found"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v17

    .line 154
    :cond_a
    invoke-virtual {v9}, Ljava/io/File;->canRead()Z

    move-result v17

    if-nez v17, :cond_b

    .line 155
    new-instance v17, Ljava/io/IOException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v19, p0, v8

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " - not readable"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v17

    .line 156
    :cond_b
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v17

    move-wide/from16 v0, v17

    long-to-int v12, v0

    .line 157
    .local v12, "size":I
    new-instance v7, Ljava/io/FileInputStream;

    invoke-direct {v7, v9}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 158
    .local v7, "fin":Ljava/io/FileInputStream;
    new-array v5, v12, [B

    .line 159
    .local v5, "contents":[B
    invoke-virtual {v7, v5}, Ljava/io/FileInputStream;->read([B)I

    move-result v17

    move/from16 v0, v17

    if-eq v0, v12, :cond_c

    .line 160
    new-instance v17, Ljava/io/IOException;

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v19, p0, v8

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " - read error"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v17

    .line 161
    :cond_c
    invoke-virtual {v7}, Ljava/io/FileInputStream;->close()V

    .line 163
    new-instance v14, Ljava/util/zip/ZipEntry;

    aget-object v17, p0, v8

    move-object/from16 v0, v17

    invoke-direct {v14, v0}, Ljava/util/zip/ZipEntry;-><init>(Ljava/lang/String;)V

    .line 164
    .local v14, "ze":Ljava/util/zip/ZipEntry;
    int-to-long v0, v12

    move-wide/from16 v17, v0

    move-wide/from16 v0, v17

    invoke-virtual {v14, v0, v1}, Ljava/util/zip/ZipEntry;->setSize(J)V

    .line 165
    invoke-virtual {v9}, Ljava/io/File;->lastModified()J

    move-result-wide v17

    move-wide/from16 v0, v17

    invoke-virtual {v14, v0, v1}, Ljava/util/zip/ZipEntry;->setTime(J)V

    .line 166
    invoke-virtual {v13, v14}, Ljava/util/zip/ZipOutputStream;->putNextEntry(Ljava/util/zip/ZipEntry;)V

    .line 167
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v13, v5, v0, v12}, Ljava/util/zip/ZipOutputStream;->write([BII)V

    .line 149
    add-int/lit8 v8, v8, 0x1

    goto/16 :goto_4

    .line 169
    .end local v5    # "contents":[B
    .end local v7    # "fin":Ljava/io/FileInputStream;
    .end local v9    # "in":Ljava/io/File;
    .end local v12    # "size":I
    .end local v14    # "ze":Ljava/util/zip/ZipEntry;
    :cond_d
    invoke-virtual {v13}, Ljava/util/zip/ZipOutputStream;->close()V

    goto/16 :goto_1

    .line 172
    .end local v8    # "i":I
    .end local v13    # "zar":Ljava/util/zip/ZipOutputStream;
    :cond_e
    invoke-static {}, Lgnu/bytecode/ZipArchive;->usage()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1
.end method

.method private static usage()V
    .locals 2

    .prologue
    .line 18
    sget-object v0, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v1, "zipfile [ptxq] archive [file ...]"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 19
    const/4 v0, -0x1

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    .line 20
    return-void
.end method
