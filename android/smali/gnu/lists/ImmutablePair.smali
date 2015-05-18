.class public Lgnu/lists/ImmutablePair;
.super Lgnu/lists/Pair;
.source "ImmutablePair.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lgnu/lists/Pair;-><init>()V

    .line 17
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "carval"    # Ljava/lang/Object;
    .param p2, "cdrval"    # Ljava/lang/Object;

    .prologue
    .line 10
    invoke-direct {p0}, Lgnu/lists/Pair;-><init>()V

    .line 11
    iput-object p1, p0, Lgnu/lists/ImmutablePair;->car:Ljava/lang/Object;

    .line 12
    iput-object p2, p0, Lgnu/lists/ImmutablePair;->cdr:Ljava/lang/Object;

    .line 13
    return-void
.end method


# virtual methods
.method public setCar(Ljava/lang/Object;)V
    .locals 2
    .param p1, "car"    # Ljava/lang/Object;

    .prologue
    .line 21
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "cannot modify read-only pair"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setCdr(Ljava/lang/Object;)V
    .locals 2
    .param p1, "cdr"    # Ljava/lang/Object;

    .prologue
    .line 26
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "cannot modify read-only pair"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
