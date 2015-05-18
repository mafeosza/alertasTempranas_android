.class public Lcom/google/appinventor/components/runtime/util/BiggerFuture;
.super Ljava/lang/Thread;
.source "BiggerFuture.java"


# direct methods
.method public constructor <init>(Lgnu/mapping/Procedure;Lgnu/mapping/InPort;Lgnu/mapping/OutPort;Lgnu/mapping/OutPort;Ljava/lang/String;J)V
    .locals 6
    .param p1, "action"    # Lgnu/mapping/Procedure;
    .param p2, "in"    # Lgnu/mapping/InPort;
    .param p3, "out"    # Lgnu/mapping/OutPort;
    .param p4, "err"    # Lgnu/mapping/OutPort;
    .param p5, "threadName"    # Ljava/lang/String;
    .param p6, "stackSize"    # J

    .prologue
    .line 20
    new-instance v1, Ljava/lang/ThreadGroup;

    const-string v0, "biggerthreads"

    invoke-direct {v1, v0}, Ljava/lang/ThreadGroup;-><init>(Ljava/lang/String;)V

    new-instance v2, Lgnu/mapping/RunnableClosure;

    invoke-direct {v2, p1, p2, p3, p4}, Lgnu/mapping/RunnableClosure;-><init>(Lgnu/mapping/Procedure;Lgnu/mapping/InPort;Lgnu/mapping/OutPort;Lgnu/mapping/OutPort;)V

    move-object v0, p0

    move-object v3, p5

    move-wide v4, p6

    invoke-direct/range {v0 .. v5}, Ljava/lang/Thread;-><init>(Ljava/lang/ThreadGroup;Ljava/lang/Runnable;Ljava/lang/String;J)V

    .line 23
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 26
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 27
    .local v0, "buf":Ljava/lang/StringBuffer;
    const-string v1, "#<future "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 28
    invoke-virtual {p0}, Lcom/google/appinventor/components/runtime/util/BiggerFuture;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 29
    const-string v1, ">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 30
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
