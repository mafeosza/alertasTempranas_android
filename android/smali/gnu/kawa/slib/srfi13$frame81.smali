.class public Lgnu/kawa/slib/srfi13$frame81;
.super Lgnu/expr/ModuleBody;
.source "srfi13.scm"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lgnu/kawa/slib/srfi13;->stringCount$V(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "frame81"
.end annotation


# instance fields
.field criterion:Ljava/lang/Object;

.field final lambda$Fn185:Lgnu/expr/ModuleMethod;

.field final lambda$Fn186:Lgnu/expr/ModuleMethod;

.field maybe$Mnstart$Plend:Lgnu/lists/LList;

.field s:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 4

    const/4 v3, 0x0

    invoke-direct {p0}, Lgnu/expr/ModuleBody;-><init>()V

    new-instance v0, Lgnu/expr/ModuleMethod;

    const/16 v1, 0xa0

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v3, v2}, Lgnu/expr/ModuleMethod;-><init>(Lgnu/expr/ModuleBody;ILjava/lang/Object;I)V

    iput-object v0, p0, Lgnu/kawa/slib/srfi13$frame81;->lambda$Fn185:Lgnu/expr/ModuleMethod;

    new-instance v0, Lgnu/expr/ModuleMethod;

    const/16 v1, 0xa1

    const/16 v2, 0x2002

    invoke-direct {v0, p0, v1, v3, v2}, Lgnu/expr/ModuleMethod;-><init>(Lgnu/expr/ModuleBody;ILjava/lang/Object;I)V

    iput-object v0, p0, Lgnu/kawa/slib/srfi13$frame81;->lambda$Fn186:Lgnu/expr/ModuleMethod;

    return-void
.end method


# virtual methods
.method public apply0(Lgnu/expr/ModuleMethod;)Ljava/lang/Object;
    .locals 2

    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    const/16 v1, 0xa0

    if-ne v0, v1, :cond_0

    invoke-virtual {p0}, Lgnu/kawa/slib/srfi13$frame81;->lambda185()Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1}, Lgnu/expr/ModuleBody;->apply0(Lgnu/expr/ModuleMethod;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public apply2(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    const/16 v1, 0xa1

    if-ne v0, v1, :cond_0

    invoke-virtual {p0, p2, p3}, Lgnu/kawa/slib/srfi13$frame81;->lambda186(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2, p3}, Lgnu/expr/ModuleBody;->apply2(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method lambda185()Ljava/lang/Object;
    .locals 3

    .prologue
    .line 1238
    sget-object v0, Lgnu/kawa/slib/srfi13;->string$Mncount:Lgnu/expr/ModuleMethod;

    iget-object v1, p0, Lgnu/kawa/slib/srfi13$frame81;->s:Ljava/lang/Object;

    iget-object v2, p0, Lgnu/kawa/slib/srfi13$frame81;->maybe$Mnstart$Plend:Lgnu/lists/LList;

    invoke-static {v0, v1, v2}, Lgnu/kawa/slib/srfi13;->stringParseFinalStart$PlEnd(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method lambda186(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 11
    .param p1, "start"    # Ljava/lang/Object;
    .param p2, "end"    # Ljava/lang/Object;

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x1

    .line 1239
    iget-object v4, p0, Lgnu/kawa/slib/srfi13$frame81;->criterion:Ljava/lang/Object;

    invoke-static {v4}, Lkawa/lib/characters;->isChar(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1240
    sget-object v1, Lgnu/kawa/slib/srfi13;->Lit0:Lgnu/math/IntNum;

    move-object v2, p1

    .local v2, "i":Ljava/lang/Object;
    :goto_0
    sget-object v4, Lkawa/standard/Scheme;->numGEq:Lgnu/kawa/functions/NumberCompare;

    .line 1244
    invoke-virtual {v4, v2, p2}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v4, v5, :cond_6

    .line 1240
    sget-object v4, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v5, Lgnu/kawa/slib/srfi13;->Lit1:Lgnu/math/IntNum;

    invoke-virtual {v4, v2, v5}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 1241
    iget-object v4, p0, Lgnu/kawa/slib/srfi13$frame81;->criterion:Ljava/lang/Object;

    :try_start_0
    check-cast v4, Lgnu/text/Char;
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    iget-object v5, p0, Lgnu/kawa/slib/srfi13$frame81;->s:Ljava/lang/Object;

    :try_start_1
    check-cast v5, Ljava/lang/CharSequence;
    :try_end_1
    .catch Ljava/lang/ClassCastException; {:try_start_1 .. :try_end_1} :catch_1

    :try_start_2
    move-object v0, v2

    check-cast v0, Ljava/lang/Number;

    move-object v6, v0

    invoke-virtual {v6}, Ljava/lang/Number;->intValue()I
    :try_end_2
    .catch Ljava/lang/ClassCastException; {:try_start_2 .. :try_end_2} :catch_2

    move-result v6

    invoke-static {v5, v6}, Lkawa/lib/strings;->stringRef(Ljava/lang/CharSequence;I)C

    move-result v5

    invoke-static {v5}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v5

    invoke-static {v4, v5}, Lkawa/lib/characters;->isChar$Eq(Lgnu/text/Char;Lgnu/text/Char;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1242
    sget-object v4, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v5, Lgnu/kawa/slib/srfi13;->Lit1:Lgnu/math/IntNum;

    invoke-virtual {v4, v1, v5}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v2    # "i":Ljava/lang/Object;
    .local v1, "count":Ljava/lang/Object;
    .local v3, "i":Ljava/lang/Object;
    :cond_0
    move-object v2, v3

    .line 1241
    .end local v3    # "i":Ljava/lang/Object;
    .restart local v2    # "i":Ljava/lang/Object;
    goto :goto_0

    .line 1240
    .end local v1    # "count":Ljava/lang/Object;
    .end local v2    # "i":Ljava/lang/Object;
    :cond_1
    sget-object v4, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    .line 1246
    sget-object v5, Lgnu/kawa/slib/srfi13;->loc$char$Mnset$Qu:Lgnu/mapping/Location;

    :try_start_3
    invoke-virtual {v5}, Lgnu/mapping/Location;->get()Ljava/lang/Object;
    :try_end_3
    .catch Lgnu/mapping/UnboundLocationException; {:try_start_3 .. :try_end_3} :catch_3

    move-result-object v5

    iget-object v6, p0, Lgnu/kawa/slib/srfi13$frame81;->criterion:Ljava/lang/Object;

    invoke-virtual {v4, v5, v6}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v4, v5, :cond_3

    .line 1247
    sget-object v1, Lgnu/kawa/slib/srfi13;->Lit0:Lgnu/math/IntNum;

    move-object v2, p1

    .restart local v2    # "i":Ljava/lang/Object;
    :goto_1
    sget-object v4, Lkawa/standard/Scheme;->numGEq:Lgnu/kawa/functions/NumberCompare;

    .line 1251
    invoke-virtual {v4, v2, p2}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v4, v5, :cond_6

    .line 1247
    sget-object v4, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v5, Lgnu/kawa/slib/srfi13;->Lit1:Lgnu/math/IntNum;

    invoke-virtual {v4, v2, v5}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 1248
    sget-object v6, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    sget-object v4, Lgnu/kawa/slib/srfi13;->loc$char$Mnset$Mncontains$Qu:Lgnu/mapping/Location;

    :try_start_4
    invoke-virtual {v4}, Lgnu/mapping/Location;->get()Ljava/lang/Object;
    :try_end_4
    .catch Lgnu/mapping/UnboundLocationException; {:try_start_4 .. :try_end_4} :catch_4

    move-result-object v7

    iget-object v8, p0, Lgnu/kawa/slib/srfi13$frame81;->criterion:Ljava/lang/Object;

    iget-object v4, p0, Lgnu/kawa/slib/srfi13$frame81;->s:Ljava/lang/Object;

    :try_start_5
    check-cast v4, Ljava/lang/CharSequence;
    :try_end_5
    .catch Ljava/lang/ClassCastException; {:try_start_5 .. :try_end_5} :catch_5

    :try_start_6
    move-object v0, v2

    check-cast v0, Ljava/lang/Number;

    move-object v5, v0

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I
    :try_end_6
    .catch Ljava/lang/ClassCastException; {:try_start_6 .. :try_end_6} :catch_6

    move-result v5

    invoke-static {v4, v5}, Lkawa/lib/strings;->stringRef(Ljava/lang/CharSequence;I)C

    move-result v4

    invoke-static {v4}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v4

    invoke-virtual {v6, v7, v8, v4}, Lgnu/mapping/Procedure;->apply3(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v4, v5, :cond_2

    .line 1249
    sget-object v4, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v5, Lgnu/kawa/slib/srfi13;->Lit1:Lgnu/math/IntNum;

    invoke-virtual {v4, v1, v5}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v2    # "i":Ljava/lang/Object;
    .restart local v1    # "count":Ljava/lang/Object;
    .restart local v3    # "i":Ljava/lang/Object;
    :cond_2
    move-object v2, v3

    .line 1248
    .end local v3    # "i":Ljava/lang/Object;
    .restart local v2    # "i":Ljava/lang/Object;
    goto :goto_1

    .line 1247
    .end local v1    # "count":Ljava/lang/Object;
    .end local v2    # "i":Ljava/lang/Object;
    :cond_3
    iget-object v4, p0, Lgnu/kawa/slib/srfi13$frame81;->criterion:Ljava/lang/Object;

    invoke-static {v4}, Lkawa/lib/misc;->isProcedure(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 1254
    sget-object v1, Lgnu/kawa/slib/srfi13;->Lit0:Lgnu/math/IntNum;

    move-object v2, p1

    .restart local v2    # "i":Ljava/lang/Object;
    :goto_2
    sget-object v4, Lkawa/standard/Scheme;->numGEq:Lgnu/kawa/functions/NumberCompare;

    .line 1256
    invoke-virtual {v4, v2, p2}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v4, v5, :cond_6

    .line 1254
    sget-object v4, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v5, Lgnu/kawa/slib/srfi13;->Lit1:Lgnu/math/IntNum;

    invoke-virtual {v4, v2, v5}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 1255
    sget-object v6, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v7, p0, Lgnu/kawa/slib/srfi13$frame81;->criterion:Ljava/lang/Object;

    iget-object v4, p0, Lgnu/kawa/slib/srfi13$frame81;->s:Ljava/lang/Object;

    :try_start_7
    check-cast v4, Ljava/lang/CharSequence;
    :try_end_7
    .catch Ljava/lang/ClassCastException; {:try_start_7 .. :try_end_7} :catch_7

    :try_start_8
    move-object v0, v2

    check-cast v0, Ljava/lang/Number;

    move-object v5, v0

    invoke-virtual {v5}, Ljava/lang/Number;->intValue()I
    :try_end_8
    .catch Ljava/lang/ClassCastException; {:try_start_8 .. :try_end_8} :catch_8

    move-result v5

    invoke-static {v4, v5}, Lkawa/lib/strings;->stringRef(Ljava/lang/CharSequence;I)C

    move-result v4

    invoke-static {v4}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v4

    invoke-virtual {v6, v7, v4}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    sget-object v5, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v4, v5, :cond_4

    sget-object v4, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v5, Lgnu/kawa/slib/srfi13;->Lit1:Lgnu/math/IntNum;

    invoke-virtual {v4, v1, v5}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v2    # "i":Ljava/lang/Object;
    .restart local v1    # "count":Ljava/lang/Object;
    .restart local v3    # "i":Ljava/lang/Object;
    :cond_4
    move-object v2, v3

    .end local v3    # "i":Ljava/lang/Object;
    .restart local v2    # "i":Ljava/lang/Object;
    goto :goto_2

    .line 1258
    .end local v1    # "count":Ljava/lang/Object;
    .end local v2    # "i":Ljava/lang/Object;
    :cond_5
    const-string v4, "CRITERION param is neither char-set or char."

    new-array v5, v10, [Ljava/lang/Object;

    const/4 v6, 0x0

    sget-object v7, Lgnu/kawa/slib/srfi13;->string$Mncount:Lgnu/expr/ModuleMethod;

    aput-object v7, v5, v6

    iget-object v6, p0, Lgnu/kawa/slib/srfi13$frame81;->criterion:Ljava/lang/Object;

    aput-object v6, v5, v9

    invoke-static {v4, v5}, Lkawa/lib/misc;->error$V(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    :cond_6
    return-object v1

    .line 1241
    .restart local v2    # "i":Ljava/lang/Object;
    :catch_0
    move-exception v5

    new-instance v6, Lgnu/mapping/WrongType;

    const-string v7, "char=?"

    invoke-direct {v6, v5, v7, v9, v4}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v6

    :catch_1
    move-exception v4

    new-instance v6, Lgnu/mapping/WrongType;

    const-string v7, "string-ref"

    invoke-direct {v6, v4, v7, v9, v5}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v6

    :catch_2
    move-exception v4

    new-instance v5, Lgnu/mapping/WrongType;

    const-string v6, "string-ref"

    invoke-direct {v5, v4, v6, v10, v2}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v5

    .end local v2    # "i":Ljava/lang/Object;
    :catch_3
    move-exception v4

    const-string v5, "srfi13.scm"

    const/16 v6, 0x4de

    const/4 v7, 0x5

    invoke-virtual {v4, v5, v6, v7}, Lgnu/mapping/UnboundLocationException;->setLine(Ljava/lang/String;II)V

    throw v4

    .restart local v2    # "i":Ljava/lang/Object;
    :catch_4
    move-exception v4

    const-string v5, "srfi13.scm"

    const/16 v6, 0x4e0

    const/16 v7, 0x10

    invoke-virtual {v4, v5, v6, v7}, Lgnu/mapping/UnboundLocationException;->setLine(Ljava/lang/String;II)V

    throw v4

    .line 1248
    :catch_5
    move-exception v5

    new-instance v6, Lgnu/mapping/WrongType;

    const-string v7, "string-ref"

    invoke-direct {v6, v5, v7, v9, v4}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v6

    :catch_6
    move-exception v4

    new-instance v5, Lgnu/mapping/WrongType;

    const-string v6, "string-ref"

    invoke-direct {v5, v4, v6, v10, v2}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v5

    .line 1255
    :catch_7
    move-exception v5

    new-instance v6, Lgnu/mapping/WrongType;

    const-string v7, "string-ref"

    invoke-direct {v6, v5, v7, v9, v4}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v6

    :catch_8
    move-exception v4

    new-instance v5, Lgnu/mapping/WrongType;

    const-string v6, "string-ref"

    invoke-direct {v5, v4, v6, v10, v2}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v5
.end method

.method public match0(Lgnu/expr/ModuleMethod;Lgnu/mapping/CallContext;)I
    .locals 3

    const/4 v0, 0x0

    iget v1, p1, Lgnu/expr/ModuleMethod;->selector:I

    const/16 v2, 0xa0

    if-ne v1, v2, :cond_0

    iput-object p1, p2, Lgnu/mapping/CallContext;->proc:Lgnu/mapping/Procedure;

    iput v0, p2, Lgnu/mapping/CallContext;->pc:I

    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Lgnu/expr/ModuleBody;->match0(Lgnu/expr/ModuleMethod;Lgnu/mapping/CallContext;)I

    move-result v0

    goto :goto_0
.end method

.method public match2(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    .locals 2

    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    const/16 v1, 0xa1

    if-ne v0, v1, :cond_0

    iput-object p2, p4, Lgnu/mapping/CallContext;->value1:Ljava/lang/Object;

    iput-object p3, p4, Lgnu/mapping/CallContext;->value2:Ljava/lang/Object;

    iput-object p1, p4, Lgnu/mapping/CallContext;->proc:Lgnu/mapping/Procedure;

    const/4 v0, 0x2

    iput v0, p4, Lgnu/mapping/CallContext;->pc:I

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Lgnu/expr/ModuleBody;->match2(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I

    move-result v0

    goto :goto_0
.end method
