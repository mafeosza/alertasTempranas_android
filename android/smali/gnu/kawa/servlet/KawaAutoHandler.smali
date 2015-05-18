.class public Lgnu/kawa/servlet/KawaAutoHandler;
.super Ljava/lang/Object;
.source "KawaAutoHandler.java"


# static fields
.field static final MODULE_MAP_ATTRIBUTE:Ljava/lang/String; = "gnu.kawa.module-map"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getModule(Lgnu/kawa/servlet/HttpRequestContext;Lgnu/mapping/CallContext;Z)Ljava/lang/Object;
    .locals 40
    .param p0, "hctx"    # Lgnu/kawa/servlet/HttpRequestContext;
    .param p1, "ctx"    # Lgnu/mapping/CallContext;
    .param p2, "saveClass"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 40
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/servlet/HttpRequestContext;->getRequestPath()Ljava/lang/String;

    move-result-object v26

    .line 42
    .local v26, "path":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/servlet/HttpRequestContext;->getContextPath()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/String;->length()I

    move-result v36

    add-int/lit8 v36, v36, -0x1

    move-object/from16 v0, v26

    move/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v26

    .line 43
    const-string v36, "gnu.kawa.module-map"

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lgnu/kawa/servlet/HttpRequestContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Ljava/util/Hashtable;

    .line 45
    .local v20, "mmap":Ljava/util/Hashtable;
    if-nez v20, :cond_0

    .line 47
    new-instance v20, Ljava/util/Hashtable;

    .end local v20    # "mmap":Ljava/util/Hashtable;
    invoke-direct/range {v20 .. v20}, Ljava/util/Hashtable;-><init>()V

    .line 48
    .restart local v20    # "mmap":Ljava/util/Hashtable;
    const-string v36, "gnu.kawa.module-map"

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    move-object/from16 v2, v20

    invoke-virtual {v0, v1, v2}, Lgnu/kawa/servlet/HttpRequestContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 51
    :cond_0
    const-string v36, "gnu.kawa.module-context"

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lgnu/kawa/servlet/HttpRequestContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lgnu/expr/ModuleContext;

    .line 53
    .local v15, "mcontext":Lgnu/expr/ModuleContext;
    if-nez v15, :cond_1

    .line 54
    invoke-static {}, Lgnu/expr/ModuleContext;->getContext()Lgnu/expr/ModuleContext;

    move-result-object v15

    .line 55
    :cond_1
    sget v36, Lgnu/expr/ModuleContext;->IN_HTTP_SERVER:I

    move/from16 v0, v36

    invoke-virtual {v15, v0}, Lgnu/expr/ModuleContext;->addFlags(I)V

    .line 56
    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v36

    const-string v37, "KawaServlet$Context"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v36

    if-eqz v36, :cond_2

    .line 57
    sget v36, Lgnu/expr/ModuleContext;->IN_SERVLET:I

    move/from16 v0, v36

    invoke-virtual {v15, v0}, Lgnu/expr/ModuleContext;->addFlags(I)V

    .line 58
    :cond_2
    move-object/from16 v0, v20

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lgnu/expr/ModuleInfo;

    .line 59
    .local v18, "minfo":Lgnu/expr/ModuleInfo;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v23

    .line 60
    .local v23, "now":J
    invoke-virtual {v15}, Lgnu/expr/ModuleContext;->getManager()Lgnu/expr/ModuleManager;

    move-result-object v19

    .line 62
    .local v19, "mmanager":Lgnu/expr/ModuleManager;
    if-eqz v18, :cond_3

    move-object/from16 v0, v18

    iget-wide v0, v0, Lgnu/expr/ModuleInfo;->lastCheckedTime:J

    move-wide/from16 v36, v0

    sub-long v36, v23, v36

    move-object/from16 v0, v19

    iget-wide v0, v0, Lgnu/expr/ModuleManager;->lastModifiedCacheTime:J

    move-wide/from16 v38, v0

    cmp-long v36, v36, v38

    if-gez v36, :cond_3

    .line 64
    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Lgnu/expr/ModuleContext;->findInstance(Lgnu/expr/ModuleInfo;)Ljava/lang/Object;

    move-result-object v36

    .line 232
    :goto_0
    return-object v36

    .line 66
    :cond_3
    invoke-virtual/range {v26 .. v26}, Ljava/lang/String;->length()I

    move-result v27

    .line 68
    .local v27, "plen":I
    if-eqz v27, :cond_4

    add-int/lit8 v36, v27, -0x1

    move-object/from16 v0, v26

    move/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v36

    const/16 v37, 0x2f

    move/from16 v0, v36

    move/from16 v1, v37

    if-ne v0, v1, :cond_6

    :cond_4
    const/16 v33, 0x0

    .line 71
    .local v33, "url":Ljava/net/URL;
    :goto_1
    move-object/from16 v32, v26

    .line 72
    .local v32, "upath":Ljava/lang/String;
    if-nez v33, :cond_8

    .line 74
    move-object/from16 v35, v26

    .line 77
    .local v35, "xpath":Ljava/lang/String;
    :cond_5
    const/16 v36, 0x2f

    invoke-virtual/range {v35 .. v36}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v31

    .line 78
    .local v31, "sl":I
    if-gez v31, :cond_7

    .line 95
    .end local v31    # "sl":I
    .end local v35    # "xpath":Ljava/lang/String;
    :goto_2
    if-nez v33, :cond_9

    .line 98
    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    const-string v37, "The requested URL "

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, " was not found on this server."

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, " res/:"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, "/"

    move-object/from16 v0, p0

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Lgnu/kawa/servlet/HttpRequestContext;->getResourceURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v37

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, "\r\n"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    .line 100
    .local v21, "msg":Ljava/lang/String;
    invoke-virtual/range {v21 .. v21}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    .line 101
    .local v6, "bmsg":[B
    const/16 v36, 0x194

    const/16 v37, 0x0

    array-length v0, v6

    move/from16 v38, v0

    move/from16 v0, v38

    int-to-long v0, v0

    move-wide/from16 v38, v0

    move-object/from16 v0, p0

    move/from16 v1, v36

    move-object/from16 v2, v37

    move-wide/from16 v3, v38

    invoke-virtual {v0, v1, v2, v3, v4}, Lgnu/kawa/servlet/HttpRequestContext;->sendResponseHeaders(ILjava/lang/String;J)V

    .line 102
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/servlet/HttpRequestContext;->getResponseStream()Ljava/io/OutputStream;

    move-result-object v25

    .line 105
    .local v25, "out":Ljava/io/OutputStream;
    :try_start_0
    move-object/from16 v0, v25

    invoke-virtual {v0, v6}, Ljava/io/OutputStream;->write([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 111
    const/16 v36, 0x0

    goto/16 :goto_0

    .line 68
    .end local v6    # "bmsg":[B
    .end local v21    # "msg":Ljava/lang/String;
    .end local v25    # "out":Ljava/io/OutputStream;
    .end local v32    # "upath":Ljava/lang/String;
    .end local v33    # "url":Ljava/net/URL;
    :cond_6
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lgnu/kawa/servlet/HttpRequestContext;->getResourceURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v33

    goto :goto_1

    .line 80
    .restart local v31    # "sl":I
    .restart local v32    # "upath":Ljava/lang/String;
    .restart local v33    # "url":Ljava/net/URL;
    .restart local v35    # "xpath":Ljava/lang/String;
    :cond_7
    const/16 v36, 0x0

    move-object/from16 v0, v35

    move/from16 v1, v36

    move/from16 v2, v31

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v35

    .line 81
    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v36

    move-object/from16 v1, v35

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, "/+default+"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v32

    .line 82
    move-object/from16 v0, p0

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lgnu/kawa/servlet/HttpRequestContext;->getResourceURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v33

    .line 83
    if-eqz v33, :cond_5

    .line 85
    const/16 v36, 0x1

    add-int/lit8 v37, v31, 0x1

    move-object/from16 v0, v26

    move/from16 v1, v36

    move/from16 v2, v37

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v36

    add-int/lit8 v37, v31, 0x1

    move-object/from16 v0, v26

    move/from16 v1, v37

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v37

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    move-object/from16 v2, v37

    invoke-virtual {v0, v1, v2}, Lgnu/kawa/servlet/HttpRequestContext;->setScriptAndLocalPath(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 92
    .end local v31    # "sl":I
    .end local v35    # "xpath":Ljava/lang/String;
    :cond_8
    const-string v36, ""

    move-object/from16 v0, p0

    move-object/from16 v1, v26

    move-object/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Lgnu/kawa/servlet/HttpRequestContext;->setScriptAndLocalPath(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 107
    .restart local v6    # "bmsg":[B
    .restart local v21    # "msg":Ljava/lang/String;
    .restart local v25    # "out":Ljava/io/OutputStream;
    :catch_0
    move-exception v11

    .line 109
    .local v11, "ex":Ljava/io/IOException;
    new-instance v36, Ljava/lang/RuntimeException;

    move-object/from16 v0, v36

    invoke-direct {v0, v11}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v36

    .line 114
    .end local v6    # "bmsg":[B
    .end local v11    # "ex":Ljava/io/IOException;
    .end local v21    # "msg":Ljava/lang/String;
    .end local v25    # "out":Ljava/io/OutputStream;
    :cond_9
    invoke-virtual/range {v33 .. v33}, Ljava/net/URL;->toExternalForm()Ljava/lang/String;

    move-result-object v34

    .line 115
    .local v34, "urlString":Ljava/lang/String;
    if-eqz v18, :cond_a

    invoke-virtual/range {v18 .. v18}, Lgnu/expr/ModuleInfo;->getSourceAbsPathname()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, v34

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v36

    if-nez v36, :cond_b

    .line 116
    :cond_a
    move-object/from16 v0, v19

    move-object/from16 v1, v33

    invoke-virtual {v0, v1}, Lgnu/expr/ModuleManager;->findWithURL(Ljava/net/URL;)Lgnu/expr/ModuleInfo;

    move-result-object v18

    .line 117
    :cond_b
    move-object/from16 v0, v18

    move-object/from16 v1, v19

    move-wide/from16 v2, v23

    invoke-virtual {v0, v1, v2, v3}, Lgnu/expr/ModuleInfo;->checkCurrent(Lgnu/expr/ModuleManager;J)Z

    move-result v36

    if-eqz v36, :cond_c

    .line 118
    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Lgnu/expr/ModuleContext;->findInstance(Lgnu/expr/ModuleInfo;)Ljava/lang/Object;

    move-result-object v36

    goto/16 :goto_0

    .line 120
    :cond_c
    move-object/from16 v0, v20

    move-object/from16 v1, v26

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 122
    invoke-virtual/range {v18 .. v18}, Lgnu/expr/ModuleInfo;->getSourceAbsPath()Lgnu/text/Path;

    move-result-object v5

    .line 123
    .local v5, "absPath":Lgnu/text/Path;
    invoke-virtual {v5}, Lgnu/text/Path;->openInputStream()Ljava/io/InputStream;

    move-result-object v29

    .line 124
    .local v29, "resourceStream":Ljava/io/InputStream;
    move-object/from16 v0, v29

    instance-of v0, v0, Ljava/io/BufferedInputStream;

    move/from16 v36, v0

    if-nez v36, :cond_d

    .line 127
    new-instance v30, Ljava/io/BufferedInputStream;

    move-object/from16 v0, v30

    move-object/from16 v1, v29

    invoke-direct {v0, v1}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .end local v29    # "resourceStream":Ljava/io/InputStream;
    .local v30, "resourceStream":Ljava/io/InputStream;
    move-object/from16 v29, v30

    .line 129
    .end local v30    # "resourceStream":Ljava/io/InputStream;
    .restart local v29    # "resourceStream":Ljava/io/InputStream;
    :cond_d
    invoke-static/range {v26 .. v26}, Lgnu/expr/Language;->getInstanceFromFilenameExtension(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v12

    .line 131
    .local v12, "language":Lgnu/expr/Language;
    if-eqz v12, :cond_f

    .line 132
    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    const-string v37, "Compile "

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, " - a "

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual {v12}, Lgnu/expr/Language;->getName()Ljava/lang/String;

    move-result-object v37

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, " source file (based on extension)"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lgnu/kawa/servlet/HttpRequestContext;->log(Ljava/lang/String;)V

    .line 177
    :goto_3
    new-instance v28, Lgnu/mapping/InPort;

    move-object/from16 v0, v28

    move-object/from16 v1, v29

    invoke-direct {v0, v1, v5}, Lgnu/mapping/InPort;-><init>(Ljava/io/InputStream;Lgnu/text/Path;)V

    .line 178
    .local v28, "port":Lgnu/mapping/InPort;
    invoke-static {v12}, Lgnu/expr/Language;->setCurrentLanguage(Lgnu/expr/Language;)V

    .line 179
    new-instance v16, Lgnu/text/SourceMessages;

    invoke-direct/range {v16 .. v16}, Lgnu/text/SourceMessages;-><init>()V

    .line 184
    .local v16, "messages":Lgnu/text/SourceMessages;
    const/16 v36, 0x9

    :try_start_1
    move-object/from16 v0, v28

    move-object/from16 v1, v16

    move/from16 v2, v36

    move-object/from16 v3, v18

    invoke-virtual {v12, v0, v1, v2, v3}, Lgnu/expr/Language;->parse(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;ILgnu/expr/ModuleInfo;)Lgnu/expr/Compilation;
    :try_end_1
    .catch Lgnu/text/SyntaxException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v9

    .line 204
    .local v9, "comp":Lgnu/expr/Compilation;
    :goto_4
    const/4 v8, 0x0

    .line 205
    .local v8, "cl":Ljava/lang/Class;
    invoke-virtual/range {v16 .. v16}, Lgnu/text/SourceMessages;->seenErrors()Z

    move-result v36

    if-nez v36, :cond_e

    .line 207
    invoke-virtual {v9}, Lgnu/expr/Compilation;->getModule()Lgnu/expr/ModuleExp;

    move-result-object v17

    .line 209
    .local v17, "mexp":Lgnu/expr/ModuleExp;
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v10

    .line 210
    .local v10, "env":Lgnu/mapping/Environment;
    const/16 v36, 0x0

    move-object/from16 v0, v33

    move-object/from16 v1, v36

    invoke-static {v10, v9, v0, v1}, Lgnu/expr/ModuleExp;->evalModule1(Lgnu/mapping/Environment;Lgnu/expr/Compilation;Ljava/net/URL;Lgnu/mapping/OutPort;)Ljava/lang/Object;

    move-result-object v8

    .end local v8    # "cl":Ljava/lang/Class;
    check-cast v8, Ljava/lang/Class;

    .line 213
    .end local v10    # "env":Lgnu/mapping/Environment;
    .end local v17    # "mexp":Lgnu/expr/ModuleExp;
    .restart local v8    # "cl":Ljava/lang/Class;
    :cond_e
    invoke-virtual/range {v16 .. v16}, Lgnu/text/SourceMessages;->seenErrors()Z

    move-result v36

    if-eqz v36, :cond_14

    .line 219
    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    const-string v37, "script syntax error:\n"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const/16 v37, 0x14

    move-object/from16 v0, v16

    move/from16 v1, v37

    invoke-virtual {v0, v1}, Lgnu/text/SourceMessages;->toString(I)Ljava/lang/String;

    move-result-object v37

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    .line 220
    .restart local v21    # "msg":Ljava/lang/String;
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    move-object/from16 v36, v0

    check-cast v36, Lgnu/kawa/servlet/ServletPrinter;

    const-string v37, "Content-type"

    const-string v38, "text/plain"

    invoke-virtual/range {v36 .. v38}, Lgnu/kawa/servlet/ServletPrinter;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    const/16 v36, 0x1f4

    const-string v37, "Syntax errors"

    const-wide/16 v38, -0x1

    move-object/from16 v0, p0

    move/from16 v1, v36

    move-object/from16 v2, v37

    move-wide/from16 v3, v38

    invoke-virtual {v0, v1, v2, v3, v4}, Lgnu/kawa/servlet/HttpRequestContext;->sendResponseHeaders(ILjava/lang/String;J)V

    .line 222
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    move-object/from16 v1, v21

    invoke-interface {v0, v1}, Lgnu/lists/Consumer;->write(Ljava/lang/String;)V

    .line 223
    invoke-virtual/range {v18 .. v18}, Lgnu/expr/ModuleInfo;->cleanupAfterCompilation()V

    .line 224
    const/16 v36, 0x0

    goto/16 :goto_0

    .line 136
    .end local v8    # "cl":Ljava/lang/Class;
    .end local v9    # "comp":Lgnu/expr/Compilation;
    .end local v16    # "messages":Lgnu/text/SourceMessages;
    .end local v21    # "msg":Ljava/lang/String;
    .end local v28    # "port":Lgnu/mapping/InPort;
    :cond_f
    invoke-static/range {v29 .. v29}, Lgnu/expr/Language;->detect(Ljava/io/InputStream;)Lgnu/expr/Language;

    move-result-object v12

    .line 137
    if-eqz v12, :cond_10

    .line 138
    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    const-string v37, "Compile "

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, " - a "

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual {v12}, Lgnu/expr/Language;->getName()Ljava/lang/String;

    move-result-object v37

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, " source file (detected from content)"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, p0

    move-object/from16 v1, v36

    invoke-virtual {v0, v1}, Lgnu/kawa/servlet/HttpRequestContext;->log(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 141
    :cond_10
    move-object/from16 v0, v26

    move-object/from16 v1, v32

    if-eq v0, v1, :cond_11

    .line 143
    new-instance v36, Ljava/lang/StringBuilder;

    invoke-direct/range {v36 .. v36}, Ljava/lang/StringBuilder;-><init>()V

    const-string v37, "The requested URL "

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, " was not found on this server."

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, " upath="

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    move-object/from16 v0, v36

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, ".\r\n"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v21

    .line 145
    .restart local v21    # "msg":Ljava/lang/String;
    invoke-virtual/range {v21 .. v21}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    .line 146
    .restart local v6    # "bmsg":[B
    const/16 v36, 0x194

    const/16 v37, 0x0

    array-length v0, v6

    move/from16 v38, v0

    move/from16 v0, v38

    int-to-long v0, v0

    move-wide/from16 v38, v0

    move-object/from16 v0, p0

    move/from16 v1, v36

    move-object/from16 v2, v37

    move-wide/from16 v3, v38

    invoke-virtual {v0, v1, v2, v3, v4}, Lgnu/kawa/servlet/HttpRequestContext;->sendResponseHeaders(ILjava/lang/String;J)V

    .line 147
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/servlet/HttpRequestContext;->getResponseStream()Ljava/io/OutputStream;

    move-result-object v25

    .line 150
    .restart local v25    # "out":Ljava/io/OutputStream;
    :try_start_2
    move-object/from16 v0, v25

    invoke-virtual {v0, v6}, Ljava/io/OutputStream;->write([B)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 156
    const/16 v36, 0x0

    goto/16 :goto_0

    .line 152
    :catch_1
    move-exception v11

    .line 154
    .restart local v11    # "ex":Ljava/io/IOException;
    new-instance v36, Ljava/lang/RuntimeException;

    move-object/from16 v0, v36

    invoke-direct {v0, v11}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v36

    .line 161
    .end local v6    # "bmsg":[B
    .end local v11    # "ex":Ljava/io/IOException;
    .end local v21    # "msg":Ljava/lang/String;
    .end local v25    # "out":Ljava/io/OutputStream;
    :cond_11
    invoke-virtual {v5}, Lgnu/text/Path;->getContentLength()J

    move-result-wide v13

    .line 162
    .local v13, "len":J
    const/16 v36, 0xc8

    const/16 v37, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v36

    move-object/from16 v2, v37

    invoke-virtual {v0, v1, v2, v13, v14}, Lgnu/kawa/servlet/HttpRequestContext;->sendResponseHeaders(ILjava/lang/String;J)V

    .line 163
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/servlet/HttpRequestContext;->getResponseStream()Ljava/io/OutputStream;

    move-result-object v25

    .line 164
    .restart local v25    # "out":Ljava/io/OutputStream;
    const/16 v36, 0x1000

    move/from16 v0, v36

    new-array v7, v0, [B

    .line 167
    .local v7, "buffer":[B
    :goto_5
    move-object/from16 v0, v29

    invoke-virtual {v0, v7}, Ljava/io/InputStream;->read([B)I

    move-result v22

    .line 168
    .local v22, "n":I
    if-gez v22, :cond_12

    .line 172
    invoke-virtual/range {v29 .. v29}, Ljava/io/InputStream;->close()V

    .line 173
    invoke-virtual/range {v25 .. v25}, Ljava/io/OutputStream;->close()V

    .line 174
    const/16 v36, 0x0

    goto/16 :goto_0

    .line 170
    :cond_12
    const/16 v36, 0x0

    move-object/from16 v0, v25

    move/from16 v1, v36

    move/from16 v2, v22

    invoke-virtual {v0, v7, v1, v2}, Ljava/io/OutputStream;->write([BII)V

    goto :goto_5

    .line 196
    .end local v7    # "buffer":[B
    .end local v13    # "len":J
    .end local v22    # "n":I
    .end local v25    # "out":Ljava/io/OutputStream;
    .restart local v16    # "messages":Lgnu/text/SourceMessages;
    .restart local v28    # "port":Lgnu/mapping/InPort;
    :catch_2
    move-exception v11

    .line 198
    .local v11, "ex":Lgnu/text/SyntaxException;
    invoke-virtual {v11}, Lgnu/text/SyntaxException;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v36

    move-object/from16 v0, v36

    move-object/from16 v1, v16

    if-eq v0, v1, :cond_13

    .line 199
    throw v11

    .line 201
    :cond_13
    const/4 v9, 0x0

    .restart local v9    # "comp":Lgnu/expr/Compilation;
    goto/16 :goto_4

    .line 227
    .end local v11    # "ex":Lgnu/text/SyntaxException;
    .restart local v8    # "cl":Ljava/lang/Class;
    :cond_14
    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Lgnu/expr/ModuleInfo;->setModuleClass(Ljava/lang/Class;)V

    .line 232
    move-object/from16 v0, v18

    invoke-virtual {v15, v0}, Lgnu/expr/ModuleContext;->findInstance(Lgnu/expr/ModuleInfo;)Ljava/lang/Object;

    move-result-object v36

    goto/16 :goto_0
.end method

.method public static run(Lgnu/kawa/servlet/HttpRequestContext;Lgnu/mapping/CallContext;)V
    .locals 3
    .param p0, "hctx"    # Lgnu/kawa/servlet/HttpRequestContext;
    .param p1, "ctx"    # Lgnu/mapping/CallContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 30
    const-string v2, "qexo-save-class"

    invoke-virtual {p0, v2}, Lgnu/kawa/servlet/HttpRequestContext;->getRequestParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_1

    const/4 v1, 0x1

    .line 31
    .local v1, "saveClass":Z
    :goto_0
    invoke-static {p0, p1, v1}, Lgnu/kawa/servlet/KawaAutoHandler;->getModule(Lgnu/kawa/servlet/HttpRequestContext;Lgnu/mapping/CallContext;Z)Ljava/lang/Object;

    move-result-object v0

    .line 33
    .local v0, "mod":Ljava/lang/Object;
    instance-of v2, v0, Lgnu/expr/ModuleBody;

    if-eqz v2, :cond_0

    .line 34
    check-cast v0, Lgnu/expr/ModuleBody;

    .end local v0    # "mod":Ljava/lang/Object;
    invoke-virtual {v0, p1}, Lgnu/expr/ModuleBody;->run(Lgnu/mapping/CallContext;)V

    .line 35
    :cond_0
    return-void

    .line 30
    .end local v1    # "saveClass":Z
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
