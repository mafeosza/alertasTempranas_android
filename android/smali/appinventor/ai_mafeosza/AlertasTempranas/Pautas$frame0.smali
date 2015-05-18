.class public Lappinventor/ai_mafeosza/AlertasTempranas/Pautas$frame0;
.super Lgnu/expr/ModuleBody;
.source "Pautas.yail"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lappinventor/ai_mafeosza/AlertasTempranas/Pautas;->lambda20(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "frame0"
.end annotation


# instance fields
.field $end:Ljava/lang/Object;

.field final lambda$Fn20:Lgnu/expr/ModuleMethod;


# direct methods
.method public constructor <init>()V
    .locals 4

    invoke-direct {p0}, Lgnu/expr/ModuleBody;-><init>()V

    new-instance v0, Lgnu/expr/ModuleMethod;

    const/4 v1, 0x1

    const/4 v2, 0x0

    const/16 v3, 0x1001

    invoke-direct {v0, p0, v1, v2, v3}, Lgnu/expr/ModuleMethod;-><init>(Lgnu/expr/ModuleBody;ILjava/lang/Object;I)V

    iput-object v0, p0, Lappinventor/ai_mafeosza/AlertasTempranas/Pautas$frame0;->lambda$Fn20:Lgnu/expr/ModuleMethod;

    return-void
.end method


# virtual methods
.method public apply1(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    invoke-virtual {p0, p2}, Lappinventor/ai_mafeosza/AlertasTempranas/Pautas$frame0;->lambda21(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2}, Lgnu/expr/ModuleBody;->apply1(Lgnu/expr/ModuleMethod;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method lambda21(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 8
    .param p1, "$item"    # Ljava/lang/Object;

    .prologue
    .line 21
    sget-object v0, Lappinventor/ai_mafeosza/AlertasTempranas/Pautas;->Lit3:Lgnu/mapping/SimpleSymbol;

    sget-object v1, Lcom/google/youngandroid/runtime;->$Stthe$Mnnull$Mnvalue$St:Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/google/youngandroid/runtime;->lookupGlobalVarInCurrentFormEnvironment(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v0, v1, :cond_0

    sget-object v0, Lappinventor/ai_mafeosza/AlertasTempranas/Pautas;->Lit3:Lgnu/mapping/SimpleSymbol;

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-static {v0, v1}, Lcom/google/youngandroid/runtime;->addGlobalVarToCurrentFormEnvironment(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Lappinventor/ai_mafeosza/AlertasTempranas/Pautas;->Lit4:Lgnu/mapping/SimpleSymbol;

    sget-object v1, Lkawa/lib/strings;->string$Mnappend:Lgnu/expr/ModuleMethod;

    sget-object v2, Lappinventor/ai_mafeosza/AlertasTempranas/Pautas;->Lit4:Lgnu/mapping/SimpleSymbol;

    sget-object v3, Lcom/google/youngandroid/runtime;->$Stthe$Mnnull$Mnvalue$St:Ljava/lang/Object;

    invoke-static {v2, v3}, Lcom/google/youngandroid/runtime;->lookupGlobalVarInCurrentFormEnvironment(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    const-string v3, ""

    sget-object v4, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    sget-object v5, Lappinventor/ai_mafeosza/AlertasTempranas/Pautas;->Lit14:Lgnu/mapping/SimpleSymbol;

    sget-object v6, Lcom/google/youngandroid/runtime;->$Stthe$Mnnull$Mnvalue$St:Ljava/lang/Object;

    invoke-static {v5, v6}, Lcom/google/youngandroid/runtime;->lookupGlobalVarInCurrentFormEnvironment(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    const-string v6, ""

    iget-object v7, p0, Lappinventor/ai_mafeosza/AlertasTempranas/Pautas$frame0;->$end:Ljava/lang/Object;

    invoke-virtual {v4, v5, p1, v6, v7}, Lgnu/mapping/Procedure;->apply4(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v2, v3, v4}, Lgnu/lists/LList;->list3(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v2

    sget-object v3, Lappinventor/ai_mafeosza/AlertasTempranas/Pautas;->Lit54:Lgnu/lists/PairWithPosition;

    const-string v4, "join"

    invoke-static {v1, v2, v3, v4}, Lcom/google/youngandroid/runtime;->callYailPrimitive(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/google/youngandroid/runtime;->addGlobalVarToCurrentFormEnvironment(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public match1(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    .locals 2

    const/4 v1, 0x1

    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    if-ne v0, v1, :cond_0

    iput-object p2, p3, Lgnu/mapping/CallContext;->value1:Ljava/lang/Object;

    iput-object p1, p3, Lgnu/mapping/CallContext;->proc:Lgnu/mapping/Procedure;

    iput v1, p3, Lgnu/mapping/CallContext;->pc:I

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2, p3}, Lgnu/expr/ModuleBody;->match1(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Lgnu/mapping/CallContext;)I

    move-result v0

    goto :goto_0
.end method
