.class public Lcom/google/appinventor/components/runtime/util/TelnetRepl;
.super Lgnu/mapping/Procedure0;
.source "TelnetRepl.java"


# static fields
.field private static final REPL_STACK_SIZE:I = 0x40000


# instance fields
.field language:Lgnu/expr/Language;

.field socket:Ljava/net/Socket;


# direct methods
.method public constructor <init>(Lgnu/expr/Language;Ljava/net/Socket;)V
    .locals 0
    .param p1, "language"    # Lgnu/expr/Language;
    .param p2, "socket"    # Ljava/net/Socket;

    .prologue
    .line 32
    invoke-direct {p0}, Lgnu/mapping/Procedure0;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/util/TelnetRepl;->language:Lgnu/expr/Language;

    .line 34
    iput-object p2, p0, Lcom/google/appinventor/components/runtime/util/TelnetRepl;->socket:Ljava/net/Socket;

    .line 35
    return-void
.end method

.method public static serve(Lgnu/expr/Language;Ljava/net/Socket;)Ljava/lang/Thread;
    .locals 11
    .param p0, "language"    # Lgnu/expr/Language;
    .param p1, "client"    # Ljava/net/Socket;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 70
    new-instance v8, Lkawa/Telnet;

    const/4 v1, 0x1

    invoke-direct {v8, p1, v1}, Lkawa/Telnet;-><init>(Ljava/net/Socket;Z)V

    .line 71
    .local v8, "conn":Lkawa/Telnet;
    invoke-virtual {v8}, Lkawa/Telnet;->getOutputStream()Lkawa/TelnetOutputStream;

    move-result-object v10

    .line 72
    .local v10, "sout":Ljava/io/OutputStream;
    invoke-virtual {v8}, Lkawa/Telnet;->getInputStream()Lkawa/TelnetInputStream;

    move-result-object v9

    .line 73
    .local v9, "sin":Ljava/io/InputStream;
    new-instance v3, Lgnu/mapping/OutPort;

    const-string v1, "/dev/stdout"

    invoke-static {v1}, Lgnu/text/FilePath;->valueOf(Ljava/lang/String;)Lgnu/text/FilePath;

    move-result-object v1

    invoke-direct {v3, v10, v1}, Lgnu/mapping/OutPort;-><init>(Ljava/io/OutputStream;Lgnu/text/Path;)V

    .line 74
    .local v3, "out":Lgnu/mapping/OutPort;
    new-instance v2, Lgnu/mapping/TtyInPort;

    const-string v1, "/dev/stdin"

    invoke-static {v1}, Lgnu/text/FilePath;->valueOf(Ljava/lang/String;)Lgnu/text/FilePath;

    move-result-object v1

    invoke-direct {v2, v9, v1, v3}, Lgnu/mapping/TtyInPort;-><init>(Ljava/io/InputStream;Lgnu/text/Path;Lgnu/mapping/OutPort;)V

    .line 83
    .local v2, "in":Lgnu/mapping/TtyInPort;
    new-instance v0, Lcom/google/appinventor/components/runtime/util/BiggerFuture;

    new-instance v1, Lcom/google/appinventor/components/runtime/util/TelnetRepl;

    invoke-direct {v1, p0, p1}, Lcom/google/appinventor/components/runtime/util/TelnetRepl;-><init>(Lgnu/expr/Language;Ljava/net/Socket;)V

    const-string v5, "Telnet Repl Thread"

    const-wide/32 v6, 0x40000

    move-object v4, v3

    invoke-direct/range {v0 .. v7}, Lcom/google/appinventor/components/runtime/util/BiggerFuture;-><init>(Lgnu/mapping/Procedure;Lgnu/mapping/InPort;Lgnu/mapping/OutPort;Lgnu/mapping/OutPort;Ljava/lang/String;J)V

    .line 86
    .local v0, "thread":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 87
    return-object v0
.end method


# virtual methods
.method public apply0()Ljava/lang/Object;
    .locals 6

    .prologue
    .line 38
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    .line 39
    .local v2, "thread":Ljava/lang/Thread;
    invoke-virtual {v2}, Ljava/lang/Thread;->getContextClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 40
    .local v0, "contextClassLoader":Ljava/lang/ClassLoader;
    if-nez v0, :cond_0

    .line 43
    const-class v3, Lkawa/Telnet;

    invoke-virtual {v3}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/Thread;->setContextClassLoader(Ljava/lang/ClassLoader;)V

    .line 47
    :cond_0
    :try_start_0
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/util/TelnetRepl;->language:Lgnu/expr/Language;

    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v4

    invoke-static {v3, v4}, Lkawa/Shell;->run(Lgnu/expr/Language;Lgnu/mapping/Environment;)Z

    .line 48
    sget-object v3, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 55
    :try_start_1
    iget-object v4, p0, Lcom/google/appinventor/components/runtime/util/TelnetRepl;->socket:Ljava/net/Socket;

    invoke-virtual {v4}, Ljava/net/Socket;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 58
    :goto_0
    return-object v3

    .line 49
    :catch_0
    move-exception v1

    .line 50
    .local v1, "e":Ljava/lang/RuntimeException;
    :try_start_2
    const-string v3, "TelnetRepl"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Repl is exiting with error "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/RuntimeException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 51
    invoke-virtual {v1}, Ljava/lang/RuntimeException;->printStackTrace()V

    .line 52
    throw v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 54
    .end local v1    # "e":Ljava/lang/RuntimeException;
    :catchall_0
    move-exception v3

    .line 55
    :try_start_3
    iget-object v4, p0, Lcom/google/appinventor/components/runtime/util/TelnetRepl;->socket:Ljava/net/Socket;

    invoke-virtual {v4}, Ljava/net/Socket;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    .line 58
    :goto_1
    throw v3

    .line 56
    :catch_1
    move-exception v4

    goto :goto_1

    :catch_2
    move-exception v4

    goto :goto_0
.end method
