.class public Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;
.super Lcom/google/appinventor/components/runtime/util/NanoHTTPD;
.source "AppInvHTTPD.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "AppInvHTTPD"

.field private static final MIME_JSON:Ljava/lang/String; = "application/json"

.field private static final YAV_SKEW_BACKWARD:I = 0x4

.field private static final YAV_SKEW_FORWARD:I = 0x1

.field private static hmacKey:[B

.field private static seq:I


# instance fields
.field private final androidUIHandler:Landroid/os/Handler;

.field private form:Lcom/google/appinventor/components/runtime/ReplForm;

.field private rootDir:Ljava/io/File;

.field private scheme:Lgnu/expr/Language;

.field private secure:Z


# direct methods
.method public constructor <init>(ILjava/io/File;ZLcom/google/appinventor/components/runtime/ReplForm;)V
    .locals 1
    .param p1, "port"    # I
    .param p2, "wwwroot"    # Ljava/io/File;
    .param p3, "secure"    # Z
    .param p4, "form"    # Lcom/google/appinventor/components/runtime/ReplForm;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 59
    invoke-direct {p0, p1, p2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD;-><init>(ILjava/io/File;)V

    .line 55
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->androidUIHandler:Landroid/os/Handler;

    .line 60
    iput-object p2, p0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->rootDir:Ljava/io/File;

    .line 61
    const-string v0, "scheme"

    invoke-static {v0}, Lkawa/standard/Scheme;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->scheme:Lgnu/expr/Language;

    .line 62
    iput-object p4, p0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    .line 63
    iput-boolean p3, p0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->secure:Z

    .line 64
    invoke-static {}, Lgnu/expr/ModuleExp;->mustNeverCompile()V

    .line 65
    return-void
.end method

.method static synthetic access$000(Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;)Lcom/google/appinventor/components/runtime/ReplForm;
    .locals 1
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    return-object v0
.end method

.method private copyFile(Ljava/io/File;Ljava/io/File;)V
    .locals 6
    .param p1, "infile"    # Ljava/io/File;
    .param p2, "outfile"    # Ljava/io/File;

    .prologue
    .line 413
    :try_start_0
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 414
    .local v2, "in":Ljava/io/FileInputStream;
    new-instance v4, Ljava/io/FileOutputStream;

    invoke-direct {v4, p2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 415
    .local v4, "out":Ljava/io/FileOutputStream;
    const v5, 0x8000

    new-array v0, v5, [B

    .line 418
    .local v0, "buffer":[B
    :goto_0
    invoke-virtual {v2, v0}, Ljava/io/FileInputStream;->read([B)I

    move-result v3

    .local v3, "len":I
    if-lez v3, :cond_0

    .line 419
    const/4 v5, 0x0

    invoke-virtual {v4, v0, v5, v3}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 424
    .end local v0    # "buffer":[B
    .end local v2    # "in":Ljava/io/FileInputStream;
    .end local v3    # "len":I
    .end local v4    # "out":Ljava/io/FileOutputStream;
    :catch_0
    move-exception v1

    .line 425
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    .line 427
    .end local v1    # "e":Ljava/io/IOException;
    :goto_1
    return-void

    .line 422
    .restart local v0    # "buffer":[B
    .restart local v2    # "in":Ljava/io/FileInputStream;
    .restart local v3    # "len":I
    .restart local v4    # "out":Ljava/io/FileOutputStream;
    :cond_0
    :try_start_1
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V

    .line 423
    invoke-virtual {v4}, Ljava/io/FileOutputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method private doPackageUpdate(Ljava/lang/String;)V
    .locals 1
    .param p1, "inurl"    # Ljava/lang/String;

    .prologue
    .line 439
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    invoke-static {v0, p1}, Lcom/google/appinventor/components/runtime/util/PackageInstaller;->doPackageInstall(Lcom/google/appinventor/components/runtime/Form;Ljava/lang/String;)V

    .line 440
    return-void
.end method

.method public static setHmacKey(Ljava/lang/String;)V
    .locals 1
    .param p0, "inputKey"    # Ljava/lang/String;

    .prologue
    .line 434
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    sput-object v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->hmacKey:[B

    .line 435
    const/4 v0, 0x1

    sput v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->seq:I

    .line 436
    return-void
.end method


# virtual methods
.method public resetSeq()V
    .locals 1

    .prologue
    .line 443
    const/4 v0, 0x1

    sput v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->seq:I

    .line 444
    return-void
.end method

.method public serve(Ljava/lang/String;Ljava/lang/String;Ljava/util/Properties;Ljava/util/Properties;Ljava/util/Properties;Ljava/net/Socket;)Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .locals 50
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "method"    # Ljava/lang/String;
    .param p3, "header"    # Ljava/util/Properties;
    .param p4, "parms"    # Ljava/util/Properties;
    .param p5, "files"    # Ljava/util/Properties;
    .param p6, "mySocket"    # Ljava/net/Socket;

    .prologue
    .line 77
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v44

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, " \'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "\' "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 84
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->secure:Z

    move/from16 v43, v0

    if-eqz v43, :cond_1

    .line 85
    invoke-virtual/range {p6 .. p6}, Ljava/net/Socket;->getInetAddress()Ljava/net/InetAddress;

    move-result-object v29

    .line 86
    .local v29, "myAddress":Ljava/net/InetAddress;
    invoke-virtual/range {v29 .. v29}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v19

    .line 87
    .local v19, "hostAddress":Ljava/lang/String;
    const-string v43, "127.0.0.1"

    move-object/from16 v0, v19

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-nez v43, :cond_1

    .line 88
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "Debug: hostAddress = "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, " while in secure mode, closing connection."

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 89
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    new-instance v45, Ljava/lang/StringBuilder;

    invoke-direct/range {v45 .. v45}, Ljava/lang/StringBuilder;-><init>()V

    const-string v46, "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid Source Location "

    invoke-virtual/range {v45 .. v46}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    move-object/from16 v0, v45

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    const-string v46, "\"}"

    invoke-virtual/range {v45 .. v46}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    invoke-virtual/range {v45 .. v45}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v45

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    .local v35, "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 94
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 96
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 408
    .end local v19    # "hostAddress":Ljava/lang/String;
    .end local v29    # "myAddress":Ljava/net/InetAddress;
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :cond_0
    :goto_0
    return-object v35

    .line 101
    :cond_1
    const-string v43, "OPTIONS"

    move-object/from16 v0, p2

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-eqz v43, :cond_3

    .line 105
    invoke-virtual/range {p3 .. p3}, Ljava/util/Properties;->propertyNames()Ljava/util/Enumeration;

    move-result-object v10

    .line 106
    .local v10, "e":Ljava/util/Enumeration;
    :goto_1
    invoke-interface {v10}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v43

    if-eqz v43, :cond_2

    .line 108
    invoke-interface {v10}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v41

    check-cast v41, Ljava/lang/String;

    .line 109
    .local v41, "value":Ljava/lang/String;
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "  HDR: \'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v41

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "\' = \'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, p3

    move-object/from16 v1, v41

    invoke-virtual {v0, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v45

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "\'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 112
    .end local v41    # "value":Ljava/lang/String;
    :cond_2
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "text/plain"

    const-string v45, "OK"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 121
    .end local v10    # "e":Ljava/util/Enumeration;
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :cond_3
    const-string v43, "/_newblocks"

    move-object/from16 v0, p1

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-eqz v43, :cond_a

    .line 122
    const-string v43, "seq"

    const-string v44, "0"

    move-object/from16 v0, p4

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 123
    .local v22, "inSeq":Ljava/lang/String;
    invoke-static/range {v22 .. v22}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v26

    .line 124
    .local v26, "iseq":I
    const-string v43, "blockid"

    move-object/from16 v0, p4

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 125
    .local v7, "blockid":Ljava/lang/String;
    const-string v43, "code"

    move-object/from16 v0, p4

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 126
    .local v8, "code":Ljava/lang/String;
    const-string v43, "mac"

    const-string v44, "no key provided"

    move-object/from16 v0, p4

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 127
    .local v21, "inMac":Ljava/lang/String;
    const-string v9, ""

    .line 128
    .local v9, "compMac":Ljava/lang/String;
    move-object/from16 v23, v8

    .line 129
    .local v23, "input_code":Ljava/lang/String;
    sget-object v43, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->hmacKey:[B

    if-eqz v43, :cond_8

    .line 131
    :try_start_0
    const-string v43, "HmacSHA1"

    invoke-static/range {v43 .. v43}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object v18

    .line 132
    .local v18, "hmacSha1":Ljavax/crypto/Mac;
    new-instance v27, Ljavax/crypto/spec/SecretKeySpec;

    sget-object v43, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->hmacKey:[B

    const-string v44, "RAW"

    move-object/from16 v0, v27

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-direct {v0, v1, v2}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 133
    .local v27, "key":Ljavax/crypto/spec/SecretKeySpec;
    move-object/from16 v0, v18

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    .line 134
    new-instance v43, Ljava/lang/StringBuilder;

    invoke-direct/range {v43 .. v43}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v43

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    move-object/from16 v0, v43

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    move-object/from16 v0, v43

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    invoke-virtual/range {v43 .. v43}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v43

    invoke-virtual/range {v43 .. v43}, Ljava/lang/String;->getBytes()[B

    move-result-object v43

    move-object/from16 v0, v18

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljavax/crypto/Mac;->doFinal([B)[B

    move-result-object v39

    .line 135
    .local v39, "tmpMac":[B
    new-instance v36, Ljava/lang/StringBuffer;

    move-object/from16 v0, v39

    array-length v0, v0

    move/from16 v43, v0

    mul-int/lit8 v43, v43, 0x2

    move-object/from16 v0, v36

    move/from16 v1, v43

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 136
    .local v36, "sb":Ljava/lang/StringBuffer;
    new-instance v17, Ljava/util/Formatter;

    move-object/from16 v0, v17

    move-object/from16 v1, v36

    invoke-direct {v0, v1}, Ljava/util/Formatter;-><init>(Ljava/lang/Appendable;)V

    .line 137
    .local v17, "formatter":Ljava/util/Formatter;
    move-object/from16 v5, v39

    .local v5, "arr$":[B
    array-length v0, v5

    move/from16 v28, v0

    .local v28, "len$":I
    const/16 v20, 0x0

    .local v20, "i$":I
    :goto_2
    move/from16 v0, v20

    move/from16 v1, v28

    if-ge v0, v1, :cond_4

    aget-byte v6, v5, v20

    .line 138
    .local v6, "b":B
    const-string v43, "%02x"

    const/16 v44, 0x1

    move/from16 v0, v44

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v44, v0

    const/16 v45, 0x0

    invoke-static {v6}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v46

    aput-object v46, v44, v45

    move-object/from16 v0, v17

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    .line 137
    add-int/lit8 v20, v20, 0x1

    goto :goto_2

    .line 139
    .end local v6    # "b":B
    :cond_4
    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v9

    .line 147
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "Incoming Mac = "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 148
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "Computed Mac = "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 149
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "Incoming seq = "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 150
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "Computed seq = "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    sget v45, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->seq:I

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 151
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "blockid = "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    move-object/from16 v0, v21

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-nez v43, :cond_5

    .line 153
    const-string v43, "AppInvHTTPD"

    const-string v44, "Hmac does not match"

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 154
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v43, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v44, v0

    const-string v45, "AppInvHTTPD"

    const/16 v46, 0x709

    const/16 v47, 0x1

    move/from16 v0, v47

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v47, v0

    const/16 v48, 0x0

    const-string v49, "Invalid HMAC"

    aput-object v49, v47, v48

    invoke-virtual/range {v43 .. v47}, Lcom/google/appinventor/components/runtime/ReplForm;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    .line 156
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const-string v45, "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid MAC\"}"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    goto/16 :goto_0

    .line 140
    .end local v5    # "arr$":[B
    .end local v17    # "formatter":Ljava/util/Formatter;
    .end local v18    # "hmacSha1":Ljavax/crypto/Mac;
    .end local v20    # "i$":I
    .end local v27    # "key":Ljavax/crypto/spec/SecretKeySpec;
    .end local v28    # "len$":I
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .end local v36    # "sb":Ljava/lang/StringBuffer;
    .end local v39    # "tmpMac":[B
    :catch_0
    move-exception v10

    .line 141
    .local v10, "e":Ljava/lang/Exception;
    const-string v43, "AppInvHTTPD"

    const-string v44, "Error working with hmac"

    move-object/from16 v0, v43

    move-object/from16 v1, v44

    invoke-static {v0, v1, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 142
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v43, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v44, v0

    const-string v45, "AppInvHTTPD"

    const/16 v46, 0x709

    const/16 v47, 0x1

    move/from16 v0, v47

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v47, v0

    const/16 v48, 0x0

    const-string v49, "Exception working on HMAC"

    aput-object v49, v47, v48

    invoke-virtual/range {v43 .. v47}, Lcom/google/appinventor/components/runtime/ReplForm;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    .line 144
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "text/plain"

    const-string v45, "NOT"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    goto/16 :goto_0

    .line 159
    .end local v10    # "e":Ljava/lang/Exception;
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .restart local v5    # "arr$":[B
    .restart local v17    # "formatter":Ljava/util/Formatter;
    .restart local v18    # "hmacSha1":Ljavax/crypto/Mac;
    .restart local v20    # "i$":I
    .restart local v27    # "key":Ljavax/crypto/spec/SecretKeySpec;
    .restart local v28    # "len$":I
    .restart local v36    # "sb":Ljava/lang/StringBuffer;
    .restart local v39    # "tmpMac":[B
    :cond_5
    sget v43, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->seq:I

    move/from16 v0, v43

    move/from16 v1, v26

    if-eq v0, v1, :cond_6

    sget v43, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->seq:I

    add-int/lit8 v44, v26, 0x1

    move/from16 v0, v43

    move/from16 v1, v44

    if-eq v0, v1, :cond_6

    .line 160
    const-string v43, "AppInvHTTPD"

    const-string v44, "Seq does not match"

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 161
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v43, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v44, v0

    const-string v45, "AppInvHTTPD"

    const/16 v46, 0x709

    const/16 v47, 0x1

    move/from16 v0, v47

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v47, v0

    const/16 v48, 0x0

    const-string v49, "Invalid Seq"

    aput-object v49, v47, v48

    invoke-virtual/range {v43 .. v47}, Lcom/google/appinventor/components/runtime/ReplForm;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    .line 163
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const-string v45, "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid Seq\"}"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    goto/16 :goto_0

    .line 168
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :cond_6
    sget v43, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->seq:I

    add-int/lit8 v44, v26, 0x1

    move/from16 v0, v43

    move/from16 v1, v44

    if-ne v0, v1, :cond_7

    .line 169
    const-string v43, "AppInvHTTPD"

    const-string v44, "Seq Fixup Invoked"

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 170
    :cond_7
    add-int/lit8 v43, v26, 0x1

    sput v43, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->seq:I

    .line 179
    new-instance v43, Ljava/lang/StringBuilder;

    invoke-direct/range {v43 .. v43}, Ljava/lang/StringBuilder;-><init>()V

    const-string v44, "(begin (require <com.google.youngandroid.runtime>) (process-repl-input "

    invoke-virtual/range {v43 .. v44}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    move-object/from16 v0, v43

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    const-string v44, " (begin "

    invoke-virtual/range {v43 .. v44}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    move-object/from16 v0, v43

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    const-string v44, " )))"

    invoke-virtual/range {v43 .. v44}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    invoke-virtual/range {v43 .. v43}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 182
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "To Eval: "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 188
    :try_start_1
    const-string v43, "#f"

    move-object/from16 v0, v23

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-eqz v43, :cond_9

    .line 189
    const-string v43, "AppInvHTTPD"

    const-string v44, "Skipping evaluation of #f"

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 193
    :goto_3
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const/16 v45, 0x0

    invoke-static/range {v45 .. v45}, Lcom/google/appinventor/components/runtime/util/RetValManager;->fetch(Z)Ljava/lang/String;

    move-result-object v45

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 199
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :goto_4
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 172
    .end local v5    # "arr$":[B
    .end local v17    # "formatter":Ljava/util/Formatter;
    .end local v18    # "hmacSha1":Ljavax/crypto/Mac;
    .end local v20    # "i$":I
    .end local v27    # "key":Ljavax/crypto/spec/SecretKeySpec;
    .end local v28    # "len$":I
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .end local v36    # "sb":Ljava/lang/StringBuffer;
    .end local v39    # "tmpMac":[B
    :cond_8
    const-string v43, "AppInvHTTPD"

    const-string v44, "No HMAC Key"

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 173
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v43, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v44, v0

    const-string v45, "AppInvHTTPD"

    const/16 v46, 0x709

    const/16 v47, 0x1

    move/from16 v0, v47

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v47, v0

    const/16 v48, 0x0

    const-string v49, "No HMAC Key"

    aput-object v49, v47, v48

    invoke-virtual/range {v43 .. v47}, Lcom/google/appinventor/components/runtime/ReplForm;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    .line 175
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const-string v45, "{\"status\" : \"BAD\", \"message\" : \"Security Error: No HMAC Key\"}"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    goto/16 :goto_0

    .line 191
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .restart local v5    # "arr$":[B
    .restart local v17    # "formatter":Ljava/util/Formatter;
    .restart local v18    # "hmacSha1":Ljavax/crypto/Mac;
    .restart local v20    # "i$":I
    .restart local v27    # "key":Ljavax/crypto/spec/SecretKeySpec;
    .restart local v28    # "len$":I
    .restart local v36    # "sb":Ljava/lang/StringBuffer;
    .restart local v39    # "tmpMac":[B
    :cond_9
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->scheme:Lgnu/expr/Language;

    move-object/from16 v43, v0

    move-object/from16 v0, v43

    invoke-virtual {v0, v8}, Lgnu/expr/Language;->eval(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_3

    .line 194
    :catch_1
    move-exception v12

    .line 195
    .local v12, "ex":Ljava/lang/Throwable;
    const-string v43, "AppInvHTTPD"

    const-string v44, "newblocks: Scheme Failure"

    move-object/from16 v0, v43

    move-object/from16 v1, v44

    invoke-static {v0, v1, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 196
    const-string v43, "BAD"

    invoke-virtual {v12}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v44

    move-object/from16 v0, v43

    move-object/from16 v1, v44

    invoke-static {v7, v0, v1}, Lcom/google/appinventor/components/runtime/util/RetValManager;->appendReturnValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const/16 v45, 0x0

    invoke-static/range {v45 .. v45}, Lcom/google/appinventor/components/runtime/util/RetValManager;->fetch(Z)Ljava/lang/String;

    move-result-object v45

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    goto/16 :goto_4

    .line 204
    .end local v5    # "arr$":[B
    .end local v7    # "blockid":Ljava/lang/String;
    .end local v8    # "code":Ljava/lang/String;
    .end local v9    # "compMac":Ljava/lang/String;
    .end local v12    # "ex":Ljava/lang/Throwable;
    .end local v17    # "formatter":Ljava/util/Formatter;
    .end local v18    # "hmacSha1":Ljavax/crypto/Mac;
    .end local v20    # "i$":I
    .end local v21    # "inMac":Ljava/lang/String;
    .end local v22    # "inSeq":Ljava/lang/String;
    .end local v23    # "input_code":Ljava/lang/String;
    .end local v26    # "iseq":I
    .end local v27    # "key":Ljavax/crypto/spec/SecretKeySpec;
    .end local v28    # "len$":I
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .end local v36    # "sb":Ljava/lang/StringBuffer;
    .end local v39    # "tmpMac":[B
    :cond_a
    const-string v43, "/_values"

    move-object/from16 v0, p1

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-eqz v43, :cond_b

    .line 205
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const/16 v45, 0x1

    invoke-static/range {v45 .. v45}, Lcom/google/appinventor/components/runtime/util/RetValManager;->fetch(Z)Ljava/lang/String;

    move-result-object v45

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 209
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 211
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :cond_b
    const-string v43, "/_getversion"

    move-object/from16 v0, p1

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-eqz v43, :cond_e

    .line 214
    :try_start_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v43, v0

    invoke-virtual/range {v43 .. v43}, Lcom/google/appinventor/components/runtime/ReplForm;->getPackageName()Ljava/lang/String;

    move-result-object v32

    .line 215
    .local v32, "packageName":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v43, v0

    invoke-virtual/range {v43 .. v43}, Lcom/google/appinventor/components/runtime/ReplForm;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v43

    const/16 v44, 0x0

    move-object/from16 v0, v43

    move-object/from16 v1, v32

    move/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v31

    .line 217
    .local v31, "pInfo":Landroid/content/pm/PackageInfo;
    invoke-static {}, Lcom/google/appinventor/components/runtime/util/SdkLevel;->getLevel()I

    move-result v43

    const/16 v44, 0x5

    move/from16 v0, v43

    move/from16 v1, v44

    if-lt v0, v1, :cond_d

    .line 218
    const-string v43, "edu.mit.appinventor.aicompanion3"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v44, v0

    invoke-static/range {v43 .. v44}, Lcom/google/appinventor/components/runtime/util/EclairUtil;->getInstallerPackageName(Ljava/lang/String;Landroid/app/Activity;)Ljava/lang/String;

    move-result-object v24

    .line 225
    .local v24, "installer":Ljava/lang/String;
    :goto_5
    move-object/from16 v0, v31

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    move-object/from16 v42, v0

    .line 226
    .local v42, "versionName":Ljava/lang/String;
    if-nez v24, :cond_c

    .line 227
    const-string v24, "Not Known"

    .line 228
    :cond_c
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    new-instance v45, Ljava/lang/StringBuilder;

    invoke-direct/range {v45 .. v45}, Ljava/lang/StringBuilder;-><init>()V

    const-string v46, "{\"version\" : \""

    invoke-virtual/range {v45 .. v46}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    move-object/from16 v0, v45

    move-object/from16 v1, v42

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    const-string v46, "\", \"fingerprint\" : \""

    invoke-virtual/range {v45 .. v46}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    sget-object v46, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    invoke-virtual/range {v45 .. v46}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    const-string v46, "\","

    invoke-virtual/range {v45 .. v46}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    const-string v46, " \"installer\" : \""

    invoke-virtual/range {v45 .. v46}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    move-object/from16 v0, v45

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    const-string v46, "\", \"package\" : \""

    invoke-virtual/range {v45 .. v46}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    move-object/from16 v0, v45

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    const-string v46, "\" }"

    invoke-virtual/range {v45 .. v46}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v45

    invoke-virtual/range {v45 .. v45}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v45

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_3 .. :try_end_3} :catch_2

    .line 235
    .end local v24    # "installer":Ljava/lang/String;
    .end local v31    # "pInfo":Landroid/content/pm/PackageInfo;
    .end local v32    # "packageName":Ljava/lang/String;
    .end local v42    # "versionName":Ljava/lang/String;
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :goto_6
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 236
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 237
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->secure:Z

    move/from16 v43, v0

    if-eqz v43, :cond_0

    .line 240
    const/16 v43, 0x1

    sput v43, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->seq:I

    .line 241
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->androidUIHandler:Landroid/os/Handler;

    move-object/from16 v43, v0

    new-instance v44, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD$1;

    move-object/from16 v0, v44

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD$1;-><init>(Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;)V

    invoke-virtual/range {v43 .. v44}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto/16 :goto_0

    .line 220
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .restart local v31    # "pInfo":Landroid/content/pm/PackageInfo;
    .restart local v32    # "packageName":Ljava/lang/String;
    :cond_d
    :try_start_4
    const-string v24, "Not Known"
    :try_end_4
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_4 .. :try_end_4} :catch_2

    .restart local v24    # "installer":Ljava/lang/String;
    goto/16 :goto_5

    .line 231
    .end local v24    # "installer":Ljava/lang/String;
    .end local v31    # "pInfo":Landroid/content/pm/PackageInfo;
    .end local v32    # "packageName":Ljava/lang/String;
    :catch_2
    move-exception v30

    .line 232
    .local v30, "n":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual/range {v30 .. v30}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    .line 233
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const-string v45, "{\"verison\" : \"Unknown\""

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    goto :goto_6

    .line 248
    .end local v30    # "n":Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :cond_e
    const-string v43, "/_update"

    move-object/from16 v0, p1

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-nez v43, :cond_f

    const-string v43, "/_install"

    move-object/from16 v0, p1

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-eqz v43, :cond_13

    .line 249
    :cond_f
    const-string v43, "url"

    const-string v44, ""

    move-object/from16 v0, p4

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v40

    .line 250
    .local v40, "url":Ljava/lang/String;
    const-string v43, "mac"

    const-string v44, ""

    move-object/from16 v0, p4

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v21

    .line 252
    .restart local v21    # "inMac":Ljava/lang/String;
    const-string v43, ""

    move-object/from16 v0, v40

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-nez v43, :cond_12

    sget-object v43, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->hmacKey:[B

    if-eqz v43, :cond_12

    const-string v43, ""

    move-object/from16 v0, v21

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-nez v43, :cond_12

    .line 254
    :try_start_5
    new-instance v27, Ljavax/crypto/spec/SecretKeySpec;

    sget-object v43, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->hmacKey:[B

    const-string v44, "RAW"

    move-object/from16 v0, v27

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-direct {v0, v1, v2}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 255
    .restart local v27    # "key":Ljavax/crypto/spec/SecretKeySpec;
    const-string v43, "HmacSHA1"

    invoke-static/range {v43 .. v43}, Ljavax/crypto/Mac;->getInstance(Ljava/lang/String;)Ljavax/crypto/Mac;

    move-result-object v18

    .line 256
    .restart local v18    # "hmacSha1":Ljavax/crypto/Mac;
    move-object/from16 v0, v18

    move-object/from16 v1, v27

    invoke-virtual {v0, v1}, Ljavax/crypto/Mac;->init(Ljava/security/Key;)V

    .line 257
    invoke-virtual/range {v40 .. v40}, Ljava/lang/String;->getBytes()[B

    move-result-object v43

    move-object/from16 v0, v18

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljavax/crypto/Mac;->doFinal([B)[B

    move-result-object v39

    .line 258
    .restart local v39    # "tmpMac":[B
    new-instance v36, Ljava/lang/StringBuffer;

    move-object/from16 v0, v39

    array-length v0, v0

    move/from16 v43, v0

    mul-int/lit8 v43, v43, 0x2

    move-object/from16 v0, v36

    move/from16 v1, v43

    invoke-direct {v0, v1}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 259
    .restart local v36    # "sb":Ljava/lang/StringBuffer;
    new-instance v17, Ljava/util/Formatter;

    move-object/from16 v0, v17

    move-object/from16 v1, v36

    invoke-direct {v0, v1}, Ljava/util/Formatter;-><init>(Ljava/lang/Appendable;)V

    .line 260
    .restart local v17    # "formatter":Ljava/util/Formatter;
    move-object/from16 v5, v39

    .restart local v5    # "arr$":[B
    array-length v0, v5

    move/from16 v28, v0

    .restart local v28    # "len$":I
    const/16 v20, 0x0

    .restart local v20    # "i$":I
    :goto_7
    move/from16 v0, v20

    move/from16 v1, v28

    if-ge v0, v1, :cond_10

    aget-byte v6, v5, v20

    .line 261
    .restart local v6    # "b":B
    const-string v43, "%02x"

    const/16 v44, 0x1

    move/from16 v0, v44

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v44, v0

    const/16 v45, 0x0

    invoke-static {v6}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v46

    aput-object v46, v44, v45

    move-object/from16 v0, v17

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Ljava/util/Formatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/Formatter;

    .line 260
    add-int/lit8 v20, v20, 0x1

    goto :goto_7

    .line 262
    .end local v6    # "b":B
    :cond_10
    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    move-result-object v9

    .line 274
    .restart local v9    # "compMac":Ljava/lang/String;
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "Incoming Mac (update) = "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 275
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "Computed Mac (update) = "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    invoke-virtual {v0, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 276
    move-object/from16 v0, v21

    invoke-virtual {v0, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-nez v43, :cond_11

    .line 277
    const-string v43, "AppInvHTTPD"

    const-string v44, "Hmac does not match"

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v43, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v44, v0

    const-string v45, "AppInvHTTPD"

    const/16 v46, 0x709

    const/16 v47, 0x1

    move/from16 v0, v47

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v47, v0

    const/16 v48, 0x0

    const-string v49, "Invalid HMAC (update)"

    aput-object v49, v47, v48

    invoke-virtual/range {v43 .. v47}, Lcom/google/appinventor/components/runtime/ReplForm;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    .line 280
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const-string v45, "{\"status\" : \"BAD\", \"message\" : \"Security Error: Invalid MAC\"}"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 281
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 282
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 284
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 263
    .end local v5    # "arr$":[B
    .end local v9    # "compMac":Ljava/lang/String;
    .end local v17    # "formatter":Ljava/util/Formatter;
    .end local v18    # "hmacSha1":Ljavax/crypto/Mac;
    .end local v20    # "i$":I
    .end local v27    # "key":Ljavax/crypto/spec/SecretKeySpec;
    .end local v28    # "len$":I
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .end local v36    # "sb":Ljava/lang/StringBuffer;
    .end local v39    # "tmpMac":[B
    :catch_3
    move-exception v10

    .line 264
    .restart local v10    # "e":Ljava/lang/Exception;
    const-string v43, "AppInvHTTPD"

    const-string v44, "Error verifying update"

    move-object/from16 v0, v43

    move-object/from16 v1, v44

    invoke-static {v0, v1, v10}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 265
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v43, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v44, v0

    const-string v45, "AppInvHTTPD"

    const/16 v46, 0x709

    const/16 v47, 0x1

    move/from16 v0, v47

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v47, v0

    const/16 v48, 0x0

    const-string v49, "Exception working on HMAC for update"

    aput-object v49, v47, v48

    invoke-virtual/range {v43 .. v47}, Lcom/google/appinventor/components/runtime/ReplForm;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    .line 267
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const-string v45, "{\"status\" : \"BAD\", \"message\" : \"Security Error: Exception processing MAC\"}"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 268
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 269
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 270
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 271
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 287
    .end local v10    # "e":Ljava/lang/Exception;
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .restart local v5    # "arr$":[B
    .restart local v9    # "compMac":Ljava/lang/String;
    .restart local v17    # "formatter":Ljava/util/Formatter;
    .restart local v18    # "hmacSha1":Ljavax/crypto/Mac;
    .restart local v20    # "i$":I
    .restart local v27    # "key":Ljavax/crypto/spec/SecretKeySpec;
    .restart local v28    # "len$":I
    .restart local v36    # "sb":Ljava/lang/StringBuffer;
    .restart local v39    # "tmpMac":[B
    :cond_11
    move-object/from16 v0, p0

    move-object/from16 v1, v40

    invoke-direct {v0, v1}, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->doPackageUpdate(Ljava/lang/String;)V

    .line 288
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const-string v45, "{\"status\" : \"OK\", \"message\" : \"Update Should Happen\"}"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 289
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 290
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 292
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 295
    .end local v5    # "arr$":[B
    .end local v9    # "compMac":Ljava/lang/String;
    .end local v17    # "formatter":Ljava/util/Formatter;
    .end local v18    # "hmacSha1":Ljavax/crypto/Mac;
    .end local v20    # "i$":I
    .end local v27    # "key":Ljavax/crypto/spec/SecretKeySpec;
    .end local v28    # "len$":I
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .end local v36    # "sb":Ljava/lang/StringBuffer;
    .end local v39    # "tmpMac":[B
    :cond_12
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "application/json"

    const-string v45, "{\"status\" : \"BAD\", \"message\" : \"Missing Parameters\"}"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 297
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 302
    .end local v21    # "inMac":Ljava/lang/String;
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .end local v40    # "url":Ljava/lang/String;
    :cond_13
    const-string v43, "/_package"

    move-object/from16 v0, p1

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-eqz v43, :cond_15

    .line 304
    const-string v43, "package"

    const/16 v44, 0x0

    move-object/from16 v0, p4

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v33

    .line 305
    .local v33, "packageapk":Ljava/lang/String;
    if-nez v33, :cond_14

    .line 306
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "text/plain"

    const-string v45, "NOT OK"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    goto/16 :goto_0

    .line 309
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :cond_14
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->rootDir:Ljava/io/File;

    move-object/from16 v45, v0

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "/"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v33

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 310
    new-instance v25, Landroid/content/Intent;

    const-string v43, "android.intent.action.VIEW"

    move-object/from16 v0, v25

    move-object/from16 v1, v43

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 311
    .local v25, "intent":Landroid/content/Intent;
    new-instance v43, Ljava/io/File;

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->rootDir:Ljava/io/File;

    move-object/from16 v45, v0

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "/"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v33

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-direct/range {v43 .. v44}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static/range {v43 .. v43}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v34

    .line 312
    .local v34, "packageuri":Landroid/net/Uri;
    const-string v43, "application/vnd.android.package-archive"

    move-object/from16 v0, v25

    move-object/from16 v1, v34

    move-object/from16 v2, v43

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 313
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->form:Lcom/google/appinventor/components/runtime/ReplForm;

    move-object/from16 v43, v0

    move-object/from16 v0, v43

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lcom/google/appinventor/components/runtime/ReplForm;->startActivity(Landroid/content/Intent;)V

    .line 314
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "text/plain"

    const-string v45, "OK"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 315
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    goto/16 :goto_0

    .line 318
    .end local v25    # "intent":Landroid/content/Intent;
    .end local v33    # "packageapk":Ljava/lang/String;
    .end local v34    # "packageuri":Landroid/net/Uri;
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :cond_15
    const-string v43, "PUT"

    move-object/from16 v0, p2

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v43

    if-eqz v43, :cond_1c

    .line 319
    const/16 v43, 0x0

    invoke-static/range {v43 .. v43}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    .line 320
    .local v11, "error":Ljava/lang/Boolean;
    const-string v43, "content"

    const/16 v44, 0x0

    move-object/from16 v0, p5

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v38

    .line 321
    .local v38, "tmpFileName":Ljava/lang/String;
    if-eqz v38, :cond_1a

    .line 322
    new-instance v14, Ljava/io/File;

    move-object/from16 v0, v38

    invoke-direct {v14, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 323
    .local v14, "fileFrom":Ljava/io/File;
    const-string v43, "filename"

    const/16 v44, 0x0

    move-object/from16 v0, p4

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Ljava/util/Properties;->getProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 324
    .local v16, "filename":Ljava/lang/String;
    if-eqz v16, :cond_17

    .line 325
    const-string v43, ".."

    move-object/from16 v0, v16

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v43

    if-nez v43, :cond_16

    const-string v43, ".."

    move-object/from16 v0, v16

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v43

    if-nez v43, :cond_16

    const-string v43, "../"

    move-object/from16 v0, v16

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v43

    if-ltz v43, :cond_17

    .line 327
    :cond_16
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, " Ignoring invalid filename: "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 328
    const/16 v16, 0x0

    .line 331
    :cond_17
    if-eqz v16, :cond_19

    .line 333
    new-instance v15, Ljava/io/File;

    new-instance v43, Ljava/lang/StringBuilder;

    invoke-direct/range {v43 .. v43}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->rootDir:Ljava/io/File;

    move-object/from16 v44, v0

    invoke-virtual/range {v43 .. v44}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v43

    const-string v44, "/"

    invoke-virtual/range {v43 .. v44}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    move-object/from16 v0, v43

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    invoke-virtual/range {v43 .. v43}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v43

    move-object/from16 v0, v43

    invoke-direct {v15, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 334
    .local v15, "fileTo":Ljava/io/File;
    invoke-virtual {v14, v15}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v43

    if-nez v43, :cond_18

    .line 335
    move-object/from16 v0, p0

    invoke-direct {v0, v14, v15}, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 336
    invoke-virtual {v14}, Ljava/io/File;->delete()Z

    .line 347
    .end local v14    # "fileFrom":Ljava/io/File;
    .end local v15    # "fileTo":Ljava/io/File;
    .end local v16    # "filename":Ljava/lang/String;
    :cond_18
    :goto_8
    invoke-virtual {v11}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v43

    if-eqz v43, :cond_1b

    .line 348
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "text/plain"

    const-string v45, "NOTOK"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 349
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 350
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 351
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 352
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 339
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .restart local v14    # "fileFrom":Ljava/io/File;
    .restart local v16    # "filename":Ljava/lang/String;
    :cond_19
    invoke-virtual {v14}, Ljava/io/File;->delete()Z

    .line 340
    const-string v43, "AppInvHTTPD"

    const-string v44, "Received content without a file name!"

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 341
    const/16 v43, 0x1

    invoke-static/range {v43 .. v43}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    goto :goto_8

    .line 344
    .end local v14    # "fileFrom":Ljava/io/File;
    .end local v16    # "filename":Ljava/lang/String;
    :cond_1a
    const-string v43, "AppInvHTTPD"

    const-string v44, "Received PUT without content."

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 345
    const/16 v43, 0x1

    invoke-static/range {v43 .. v43}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v11

    goto :goto_8

    .line 355
    :cond_1b
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "text/plain"

    const-string v45, "OK"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 356
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 357
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 359
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 364
    .end local v11    # "error":Ljava/lang/Boolean;
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    .end local v38    # "tmpFileName":Ljava/lang/String;
    :cond_1c
    invoke-virtual/range {p3 .. p3}, Ljava/util/Properties;->propertyNames()Ljava/util/Enumeration;

    move-result-object v10

    .line 365
    .local v10, "e":Ljava/util/Enumeration;
    :goto_9
    invoke-interface {v10}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v43

    if-eqz v43, :cond_1d

    .line 367
    invoke-interface {v10}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v41

    check-cast v41, Ljava/lang/String;

    .line 368
    .restart local v41    # "value":Ljava/lang/String;
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "  HDR: \'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v41

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "\' = \'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, p3

    move-object/from16 v1, v41

    invoke-virtual {v0, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v45

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "\'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_9

    .line 371
    .end local v41    # "value":Ljava/lang/String;
    :cond_1d
    invoke-virtual/range {p4 .. p4}, Ljava/util/Properties;->propertyNames()Ljava/util/Enumeration;

    move-result-object v10

    .line 372
    :goto_a
    invoke-interface {v10}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v43

    if-eqz v43, :cond_1e

    .line 374
    invoke-interface {v10}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v41

    check-cast v41, Ljava/lang/String;

    .line 375
    .restart local v41    # "value":Ljava/lang/String;
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, "  PRM: \'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v41

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "\' = \'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, p4

    move-object/from16 v1, v41

    invoke-virtual {v0, v1}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v45

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "\'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_a

    .line 378
    .end local v41    # "value":Ljava/lang/String;
    :cond_1e
    invoke-virtual/range {p5 .. p5}, Ljava/util/Properties;->propertyNames()Ljava/util/Enumeration;

    move-result-object v10

    .line 379
    invoke-interface {v10}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v43

    if-eqz v43, :cond_23

    .line 381
    invoke-interface {v10}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/lang/String;

    .line 382
    .local v13, "fieldname":Ljava/lang/String;
    move-object/from16 v0, p5

    invoke-virtual {v0, v13}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v37

    .line 383
    .local v37, "tempLocation":Ljava/lang/String;
    move-object/from16 v0, p4

    invoke-virtual {v0, v13}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v16

    .line 384
    .restart local v16    # "filename":Ljava/lang/String;
    const-string v43, ".."

    move-object/from16 v0, v16

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v43

    if-nez v43, :cond_1f

    const-string v43, ".."

    move-object/from16 v0, v16

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v43

    if-nez v43, :cond_1f

    const-string v43, "../"

    move-object/from16 v0, v16

    move-object/from16 v1, v43

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v43

    if-ltz v43, :cond_20

    .line 386
    :cond_1f
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, " Ignoring invalid filename: "

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 387
    const/16 v16, 0x0

    .line 389
    :cond_20
    new-instance v14, Ljava/io/File;

    move-object/from16 v0, v37

    invoke-direct {v14, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 390
    .restart local v14    # "fileFrom":Ljava/io/File;
    if-nez v16, :cond_22

    .line 391
    invoke-virtual {v14}, Ljava/io/File;->delete()Z

    .line 399
    :cond_21
    :goto_b
    const-string v43, "AppInvHTTPD"

    new-instance v44, Ljava/lang/StringBuilder;

    invoke-direct/range {v44 .. v44}, Ljava/lang/StringBuilder;-><init>()V

    const-string v45, " UPLOADED: \'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "\' was at \'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    move-object/from16 v0, v44

    move-object/from16 v1, v37

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    const-string v45, "\'"

    invoke-virtual/range {v44 .. v45}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v44

    invoke-virtual/range {v44 .. v44}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v44

    invoke-static/range {v43 .. v44}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 400
    new-instance v35, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    const-string v43, "200 OK"

    const-string v44, "text/plain"

    const-string v45, "OK"

    move-object/from16 v0, v35

    move-object/from16 v1, p0

    move-object/from16 v2, v43

    move-object/from16 v3, v44

    move-object/from16 v4, v45

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;-><init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 401
    .restart local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    const-string v43, "Access-Control-Allow-Origin"

    const-string v44, "*"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 402
    const-string v43, "Access-Control-Allow-Headers"

    const-string v44, "origin, content-type"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 403
    const-string v43, "Access-Control-Allow-Methods"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 404
    const-string v43, "Allow"

    const-string v44, "POST,OPTIONS,GET,HEAD,PUT"

    move-object/from16 v0, v35

    move-object/from16 v1, v43

    move-object/from16 v2, v44

    invoke-virtual {v0, v1, v2}, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 393
    .end local v35    # "res":Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
    :cond_22
    new-instance v15, Ljava/io/File;

    new-instance v43, Ljava/lang/StringBuilder;

    invoke-direct/range {v43 .. v43}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->rootDir:Ljava/io/File;

    move-object/from16 v44, v0

    invoke-virtual/range {v43 .. v44}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v43

    const-string v44, "/"

    invoke-virtual/range {v43 .. v44}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    move-object/from16 v0, v43

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v43

    invoke-virtual/range {v43 .. v43}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v43

    move-object/from16 v0, v43

    invoke-direct {v15, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 394
    .restart local v15    # "fileTo":Ljava/io/File;
    invoke-virtual {v14, v15}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    move-result v43

    if-nez v43, :cond_21

    .line 395
    move-object/from16 v0, p0

    invoke-direct {v0, v14, v15}, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->copyFile(Ljava/io/File;Ljava/io/File;)V

    .line 396
    invoke-virtual {v14}, Ljava/io/File;->delete()Z

    goto/16 :goto_b

    .line 408
    .end local v13    # "fieldname":Ljava/lang/String;
    .end local v14    # "fileFrom":Ljava/io/File;
    .end local v15    # "fileTo":Ljava/io/File;
    .end local v16    # "filename":Ljava/lang/String;
    .end local v37    # "tempLocation":Ljava/lang/String;
    :cond_23
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->rootDir:Ljava/io/File;

    move-object/from16 v43, v0

    const/16 v44, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-object/from16 v2, p3

    move-object/from16 v3, v43

    move/from16 v4, v44

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/google/appinventor/components/runtime/util/AppInvHTTPD;->serveFile(Ljava/lang/String;Ljava/util/Properties;Ljava/io/File;Z)Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;

    move-result-object v35

    goto/16 :goto_0
.end method
