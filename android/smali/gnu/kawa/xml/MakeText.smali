.class public Lgnu/kawa/xml/MakeText;
.super Lgnu/kawa/xml/NodeConstructor;
.source "MakeText.java"


# static fields
.field public static final makeText:Lgnu/kawa/xml/MakeText;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    new-instance v0, Lgnu/kawa/xml/MakeText;

    invoke-direct {v0}, Lgnu/kawa/xml/MakeText;-><init>()V

    sput-object v0, Lgnu/kawa/xml/MakeText;->makeText:Lgnu/kawa/xml/MakeText;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lgnu/kawa/xml/NodeConstructor;-><init>()V

    return-void
.end method

.method public static text$X(Ljava/lang/Object;Lgnu/mapping/CallContext;)V
    .locals 3
    .param p0, "arg"    # Ljava/lang/Object;
    .param p1, "ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 28
    if-eqz p0, :cond_0

    instance-of v2, p0, Lgnu/mapping/Values;

    if-eqz v2, :cond_1

    move-object v2, p0

    check-cast v2, Lgnu/mapping/Values;

    invoke-virtual {v2}, Lgnu/mapping/Values;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 40
    :cond_0
    :goto_0
    return-void

    .line 30
    :cond_1
    iget-object v1, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 31
    .local v1, "saved":Lgnu/lists/Consumer;
    invoke-static {p1}, Lgnu/kawa/xml/NodeConstructor;->pushNodeContext(Lgnu/mapping/CallContext;)Lgnu/xml/XMLFilter;

    move-result-object v0

    .line 34
    .local v0, "out":Lgnu/lists/Consumer;
    :try_start_0
    invoke-static {p0, v0}, Lgnu/xml/TextUtils;->textValue(Ljava/lang/Object;Lgnu/lists/Consumer;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 38
    invoke-static {v1, p1}, Lgnu/kawa/xml/NodeConstructor;->popNodeContext(Lgnu/lists/Consumer;Lgnu/mapping/CallContext;)V

    goto :goto_0

    :catchall_0
    move-exception v2

    invoke-static {v1, p1}, Lgnu/kawa/xml/NodeConstructor;->popNodeContext(Lgnu/lists/Consumer;Lgnu/mapping/CallContext;)V

    throw v2
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 1
    .param p1, "ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 44
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lgnu/mapping/CallContext;->getNextArg(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0, p1}, Lgnu/kawa/xml/MakeText;->text$X(Ljava/lang/Object;Lgnu/mapping/CallContext;)V

    .line 45
    return-void
.end method

.method public apply1(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "arg"    # Ljava/lang/Object;

    .prologue
    .line 19
    if-eqz p1, :cond_0

    instance-of v1, p1, Lgnu/mapping/Values;

    if-eqz v1, :cond_1

    move-object v1, p1

    check-cast v1, Lgnu/mapping/Values;

    invoke-virtual {v1}, Lgnu/mapping/Values;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 23
    .end local p1    # "arg":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-object p1

    .line 21
    .restart local p1    # "arg":Ljava/lang/Object;
    :cond_1
    new-instance v0, Lgnu/xml/NodeTree;

    invoke-direct {v0}, Lgnu/xml/NodeTree;-><init>()V

    .line 22
    .local v0, "node":Lgnu/xml/NodeTree;
    new-instance v1, Lgnu/xml/XMLFilter;

    invoke-direct {v1, v0}, Lgnu/xml/XMLFilter;-><init>(Lgnu/lists/Consumer;)V

    invoke-static {p1, v1}, Lgnu/xml/TextUtils;->textValue(Ljava/lang/Object;Lgnu/lists/Consumer;)V

    .line 23
    invoke-static {v0}, Lgnu/kawa/xml/KText;->make(Lgnu/xml/NodeTree;)Lgnu/kawa/xml/KNode;

    move-result-object p1

    goto :goto_0
.end method

.method public compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 0
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "comp"    # Lgnu/expr/Compilation;
    .param p3, "target"    # Lgnu/expr/Target;

    .prologue
    .line 51
    invoke-static {p1, p2, p3}, Lgnu/expr/ApplyExp;->compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 52
    return-void
.end method

.method public compileToNode(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/ConsumerTarget;)V
    .locals 18
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "comp"    # Lgnu/expr/Compilation;
    .param p3, "target"    # Lgnu/expr/ConsumerTarget;

    .prologue
    .line 58
    invoke-virtual/range {p2 .. p2}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v2

    .line 59
    .local v2, "code":Lgnu/bytecode/CodeAttr;
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v1

    .line 60
    .local v1, "args":[Lgnu/expr/Expression;
    const/4 v14, 0x0

    aget-object v11, v1, v14

    .line 61
    .local v11, "texp":Lgnu/expr/Expression;
    invoke-virtual/range {p3 .. p3}, Lgnu/expr/ConsumerTarget;->getConsumerVariable()Lgnu/bytecode/Variable;

    move-result-object v4

    .line 62
    .local v4, "cvar":Lgnu/bytecode/Variable;
    instance-of v14, v11, Lgnu/expr/QuoteExp;

    if-eqz v14, :cond_0

    move-object v14, v11

    .line 64
    check-cast v14, Lgnu/expr/QuoteExp;

    invoke-virtual {v14}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v12

    .line 65
    .local v12, "tval":Ljava/lang/Object;
    instance-of v14, v12, Ljava/lang/String;

    if-eqz v14, :cond_0

    move-object v10, v12

    .line 67
    check-cast v10, Ljava/lang/String;

    .line 68
    .local v10, "str":Ljava/lang/String;
    invoke-static {v10}, Lgnu/bytecode/CodeAttr;->calculateSplit(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 69
    .local v9, "segments":Ljava/lang/String;
    invoke-virtual {v9}, Ljava/lang/String;->length()I

    move-result v5

    .line 70
    .local v5, "numSegments":I
    invoke-virtual {v4}, Lgnu/bytecode/Variable;->getType()Lgnu/bytecode/Type;

    move-result-object v3

    check-cast v3, Lgnu/bytecode/ClassType;

    .line 71
    .local v3, "ctype":Lgnu/bytecode/ClassType;
    const-string v14, "write"

    const/4 v15, 0x1

    new-array v15, v15, [Lgnu/bytecode/Type;

    const/16 v16, 0x0

    sget-object v17, Lgnu/bytecode/Type;->string_type:Lgnu/bytecode/ClassType;

    aput-object v17, v15, v16

    invoke-virtual {v3, v14, v15}, Lgnu/bytecode/ClassType;->getMethod(Ljava/lang/String;[Lgnu/bytecode/Type;)Lgnu/bytecode/Method;

    move-result-object v13

    .line 73
    .local v13, "writer":Lgnu/bytecode/Method;
    const/4 v8, 0x0

    .line 74
    .local v8, "segStart":I
    const/4 v6, 0x0

    .local v6, "seg":I
    :goto_0
    if-ge v6, v5, :cond_1

    .line 76
    invoke-virtual {v2, v4}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 77
    invoke-virtual {v9, v6}, Ljava/lang/String;->charAt(I)C

    move-result v14

    add-int v7, v8, v14

    .line 78
    .local v7, "segEnd":I
    invoke-virtual {v10, v8, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v2, v14}, Lgnu/bytecode/CodeAttr;->emitPushString(Ljava/lang/String;)V

    .line 79
    invoke-virtual {v2, v13}, Lgnu/bytecode/CodeAttr;->emitInvoke(Lgnu/bytecode/Method;)V

    .line 80
    move v8, v7

    .line 74
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 85
    .end local v3    # "ctype":Lgnu/bytecode/ClassType;
    .end local v5    # "numSegments":I
    .end local v6    # "seg":I
    .end local v7    # "segEnd":I
    .end local v8    # "segStart":I
    .end local v9    # "segments":Ljava/lang/String;
    .end local v10    # "str":Ljava/lang/String;
    .end local v12    # "tval":Ljava/lang/Object;
    .end local v13    # "writer":Lgnu/bytecode/Method;
    :cond_0
    sget-object v14, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    move-object/from16 v0, p2

    invoke-virtual {v11, v0, v14}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 86
    invoke-virtual {v2, v4}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 87
    const-string v14, "gnu.xml.TextUtils"

    invoke-static {v14}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v14

    const-string v15, "textValue"

    const/16 v16, 0x2

    invoke-virtual/range {v14 .. v16}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v14

    invoke-virtual {v2, v14}, Lgnu/bytecode/CodeAttr;->emitInvokeStatic(Lgnu/bytecode/Method;)V

    .line 89
    :cond_1
    return-void
.end method

.method public numArgs()I
    .locals 1

    .prologue
    .line 15
    const/16 v0, 0x1001

    return v0
.end method
