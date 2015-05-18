.class public Lgnu/kawa/slib/srfi1$frame19;
.super Lgnu/expr/ModuleBody;
.source "srfi1.scm"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lgnu/kawa/slib/srfi1;->deleteDuplicates(Ljava/lang/Object;Lgnu/mapping/Procedure;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "frame19"
.end annotation


# instance fields
.field maybe$Mn$Eq:Lgnu/mapping/Procedure;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lgnu/expr/ModuleBody;-><init>()V

    return-void
.end method


# virtual methods
.method public lambda30recur(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .param p1, "lis"    # Ljava/lang/Object;

    .prologue
    .line 1250
    invoke-static {p1}, Lgnu/kawa/slib/srfi1;->isNullList(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    sget-object v4, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v3, v4, :cond_1

    .line 1254
    .end local p1    # "lis":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-object p1

    .line 1251
    .restart local p1    # "lis":Ljava/lang/Object;
    :cond_1
    sget-object v3, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    invoke-virtual {v3, p1}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 1252
    .local v2, "x":Ljava/lang/Object;
    sget-object v3, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    invoke-virtual {v3, p1}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 1251
    .local v1, "tail":Ljava/lang/Object;
    iget-object v3, p0, Lgnu/kawa/slib/srfi1$frame19;->maybe$Mn$Eq:Lgnu/mapping/Procedure;

    invoke-static {v2, v1, v3}, Lgnu/kawa/slib/srfi1;->delete(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {p0, v3}, Lgnu/kawa/slib/srfi1$frame19;->lambda30recur(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 1254
    .local v0, "new$Mntail":Ljava/lang/Object;
    if-eq v1, v0, :cond_0

    invoke-static {v2, v0}, Lkawa/lib/lists;->cons(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object p1

    goto :goto_0
.end method
