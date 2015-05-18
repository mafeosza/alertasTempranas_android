.class public abstract Lgnu/kawa/xml/NodeConstructor;
.super Lgnu/mapping/MethodProc;
.source "NodeConstructor.java"

# interfaces
.implements Lgnu/expr/Inlineable;


# static fields
.field static final popNodeConsumerMethod:Lgnu/bytecode/Method;

.field static final popNodeContextMethod:Lgnu/bytecode/Method;

.field static final pushNodeConsumerMethod:Lgnu/bytecode/Method;

.field static final pushNodeContextMethod:Lgnu/bytecode/Method;

.field static final typeKNode:Lgnu/bytecode/ClassType;

.field static final typeNodeConstructor:Lgnu/bytecode/ClassType;

.field static final typeXMLFilter:Lgnu/bytecode/ClassType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x2

    const/4 v2, 0x1

    .line 164
    const-string v0, "gnu.xml.XMLFilter"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    sput-object v0, Lgnu/kawa/xml/NodeConstructor;->typeXMLFilter:Lgnu/bytecode/ClassType;

    .line 166
    const-string v0, "gnu.kawa.xml.KNode"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    sput-object v0, Lgnu/kawa/xml/NodeConstructor;->typeKNode:Lgnu/bytecode/ClassType;

    .line 168
    const-string v0, "gnu.kawa.xml.NodeConstructor"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    sput-object v0, Lgnu/kawa/xml/NodeConstructor;->typeNodeConstructor:Lgnu/bytecode/ClassType;

    .line 170
    sget-object v0, Lgnu/kawa/xml/NodeConstructor;->typeNodeConstructor:Lgnu/bytecode/ClassType;

    const-string v1, "pushNodeContext"

    invoke-virtual {v0, v1, v2}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lgnu/kawa/xml/NodeConstructor;->pushNodeContextMethod:Lgnu/bytecode/Method;

    .line 172
    sget-object v0, Lgnu/kawa/xml/NodeConstructor;->typeNodeConstructor:Lgnu/bytecode/ClassType;

    const-string v1, "popNodeContext"

    invoke-virtual {v0, v1, v3}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lgnu/kawa/xml/NodeConstructor;->popNodeContextMethod:Lgnu/bytecode/Method;

    .line 174
    sget-object v0, Lgnu/kawa/xml/NodeConstructor;->typeNodeConstructor:Lgnu/bytecode/ClassType;

    const-string v1, "pushNodeConsumer"

    invoke-virtual {v0, v1, v2}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lgnu/kawa/xml/NodeConstructor;->pushNodeConsumerMethod:Lgnu/bytecode/Method;

    .line 176
    sget-object v0, Lgnu/kawa/xml/NodeConstructor;->typeNodeConstructor:Lgnu/bytecode/ClassType;

    const-string v1, "popNodeConsumer"

    invoke-virtual {v0, v1, v3}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lgnu/kawa/xml/NodeConstructor;->popNodeConsumerMethod:Lgnu/bytecode/Method;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lgnu/mapping/MethodProc;-><init>()V

    return-void
.end method

.method public static compileChild(Lgnu/expr/Expression;Lgnu/expr/Compilation;Lgnu/expr/ConsumerTarget;)V
    .locals 4
    .param p0, "arg"    # Lgnu/expr/Expression;
    .param p1, "comp"    # Lgnu/expr/Compilation;
    .param p2, "target"    # Lgnu/expr/ConsumerTarget;

    .prologue
    .line 65
    instance-of v3, p0, Lgnu/expr/ApplyExp;

    if-eqz v3, :cond_0

    move-object v0, p0

    .line 67
    check-cast v0, Lgnu/expr/ApplyExp;

    .line 68
    .local v0, "app":Lgnu/expr/ApplyExp;
    invoke-virtual {v0}, Lgnu/expr/ApplyExp;->getFunction()Lgnu/expr/Expression;

    move-result-object v1

    .line 69
    .local v1, "func":Lgnu/expr/Expression;
    instance-of v3, v1, Lgnu/expr/QuoteExp;

    if-eqz v3, :cond_0

    .line 71
    check-cast v1, Lgnu/expr/QuoteExp;

    .end local v1    # "func":Lgnu/expr/Expression;
    invoke-virtual {v1}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v2

    .line 72
    .local v2, "proc":Ljava/lang/Object;
    instance-of v3, v2, Lgnu/kawa/xml/NodeConstructor;

    if-eqz v3, :cond_0

    .line 74
    check-cast v2, Lgnu/kawa/xml/NodeConstructor;

    .end local v2    # "proc":Ljava/lang/Object;
    invoke-virtual {v2, v0, p1, p2}, Lgnu/kawa/xml/NodeConstructor;->compileToNode(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/ConsumerTarget;)V

    .line 80
    .end local v0    # "app":Lgnu/expr/ApplyExp;
    :goto_0
    return-void

    .line 79
    :cond_0
    invoke-virtual {p0, p1, p2}, Lgnu/expr/Expression;->compileWithPosition(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto :goto_0
.end method

.method public static compileUsingNodeTree(Lgnu/expr/Expression;Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 5
    .param p0, "exp"    # Lgnu/expr/Expression;
    .param p1, "comp"    # Lgnu/expr/Compilation;
    .param p2, "target"    # Lgnu/expr/Target;

    .prologue
    .line 88
    sget-object v2, Lgnu/kawa/xml/NodeConstructor;->typeNodeConstructor:Lgnu/bytecode/ClassType;

    const-string v3, "makeNode"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v1

    .line 89
    .local v1, "makeMethod":Lgnu/bytecode/Method;
    sget-object v2, Lgnu/kawa/xml/NodeConstructor;->typeNodeConstructor:Lgnu/bytecode/ClassType;

    const-string v3, "finishNode"

    const/4 v4, 0x1

    invoke-virtual {v2, v3, v4}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    .line 90
    .local v0, "makeKNodeMethod":Lgnu/bytecode/Method;
    invoke-static {p0, p1, p2, v1, v0}, Lgnu/expr/ConsumerTarget;->compileUsingConsumer(Lgnu/expr/Expression;Lgnu/expr/Compilation;Lgnu/expr/Target;Lgnu/bytecode/Method;Lgnu/bytecode/Method;)V

    .line 92
    return-void
.end method

.method public static finishNode(Lgnu/xml/XMLFilter;)Lgnu/kawa/xml/KNode;
    .locals 1
    .param p0, "filter"    # Lgnu/xml/XMLFilter;

    .prologue
    .line 101
    iget-object v0, p0, Lgnu/xml/XMLFilter;->out:Lgnu/lists/Consumer;

    check-cast v0, Lgnu/xml/NodeTree;

    invoke-static {v0}, Lgnu/kawa/xml/KNode;->make(Lgnu/xml/NodeTree;)Lgnu/kawa/xml/KNode;

    move-result-object v0

    return-object v0
.end method

.method public static makeNode()Lgnu/xml/XMLFilter;
    .locals 2

    .prologue
    .line 96
    new-instance v0, Lgnu/xml/XMLFilter;

    new-instance v1, Lgnu/xml/NodeTree;

    invoke-direct {v1}, Lgnu/xml/NodeTree;-><init>()V

    invoke-direct {v0, v1}, Lgnu/xml/XMLFilter;-><init>(Lgnu/lists/Consumer;)V

    return-object v0
.end method

.method public static popNodeConsumer(Lgnu/lists/Consumer;Lgnu/lists/Consumer;)V
    .locals 1
    .param p0, "saved"    # Lgnu/lists/Consumer;
    .param p1, "current"    # Lgnu/lists/Consumer;

    .prologue
    .line 27
    if-eq p0, p1, :cond_1

    .line 28
    instance-of v0, p1, Lgnu/xml/XMLFilter;

    if-eqz v0, :cond_0

    check-cast p1, Lgnu/xml/XMLFilter;

    .end local p1    # "current":Lgnu/lists/Consumer;
    iget-object v0, p1, Lgnu/xml/XMLFilter;->out:Lgnu/lists/Consumer;

    check-cast v0, Lgnu/xml/NodeTree;

    invoke-static {v0}, Lgnu/kawa/xml/KNode;->make(Lgnu/xml/NodeTree;)Lgnu/kawa/xml/KNode;

    move-result-object p1

    :cond_0
    invoke-interface {p0, p1}, Lgnu/lists/Consumer;->writeObject(Ljava/lang/Object;)V

    .line 31
    :cond_1
    return-void
.end method

.method public static popNodeContext(Lgnu/lists/Consumer;Lgnu/mapping/CallContext;)V
    .locals 2
    .param p0, "saved"    # Lgnu/lists/Consumer;
    .param p1, "ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 52
    iget-object v0, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 53
    .local v0, "current":Lgnu/lists/Consumer;
    if-eq p0, v0, :cond_1

    .line 55
    instance-of v1, v0, Lgnu/xml/XMLFilter;

    if-eqz v1, :cond_0

    .line 56
    check-cast v0, Lgnu/xml/XMLFilter;

    .end local v0    # "current":Lgnu/lists/Consumer;
    iget-object v1, v0, Lgnu/xml/XMLFilter;->out:Lgnu/lists/Consumer;

    check-cast v1, Lgnu/xml/NodeTree;

    invoke-static {v1}, Lgnu/kawa/xml/KNode;->make(Lgnu/xml/NodeTree;)Lgnu/kawa/xml/KNode;

    move-result-object v0

    .line 57
    :cond_0
    invoke-interface {p0, v0}, Lgnu/lists/Consumer;->writeObject(Ljava/lang/Object;)V

    .line 58
    iput-object p0, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 60
    :cond_1
    return-void
.end method

.method public static pushNodeConsumer(Lgnu/lists/Consumer;)Lgnu/xml/XMLFilter;
    .locals 1
    .param p0, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 19
    instance-of v0, p0, Lgnu/xml/XMLFilter;

    if-eqz v0, :cond_0

    .line 20
    check-cast p0, Lgnu/xml/XMLFilter;

    .line 22
    .end local p0    # "out":Lgnu/lists/Consumer;
    :goto_0
    return-object p0

    .restart local p0    # "out":Lgnu/lists/Consumer;
    :cond_0
    new-instance p0, Lgnu/xml/XMLFilter;

    .end local p0    # "out":Lgnu/lists/Consumer;
    new-instance v0, Lgnu/xml/NodeTree;

    invoke-direct {v0}, Lgnu/xml/NodeTree;-><init>()V

    invoke-direct {p0, v0}, Lgnu/xml/XMLFilter;-><init>(Lgnu/lists/Consumer;)V

    goto :goto_0
.end method

.method public static pushNodeContext(Lgnu/mapping/CallContext;)Lgnu/xml/XMLFilter;
    .locals 3
    .param p0, "ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 35
    iget-object v1, p0, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 36
    .local v1, "out":Lgnu/lists/Consumer;
    instance-of v2, v1, Lgnu/xml/XMLFilter;

    if-eqz v2, :cond_0

    .line 37
    check-cast v1, Lgnu/xml/XMLFilter;

    .line 46
    .end local v1    # "out":Lgnu/lists/Consumer;
    :goto_0
    return-object v1

    .line 44
    .restart local v1    # "out":Lgnu/lists/Consumer;
    :cond_0
    new-instance v0, Lgnu/xml/XMLFilter;

    new-instance v2, Lgnu/xml/NodeTree;

    invoke-direct {v2}, Lgnu/xml/NodeTree;-><init>()V

    invoke-direct {v0, v2}, Lgnu/xml/XMLFilter;-><init>(Lgnu/lists/Consumer;)V

    .line 45
    .local v0, "filter":Lgnu/xml/XMLFilter;
    iput-object v0, p0, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    move-object v1, v0

    .line 46
    goto :goto_0
.end method


# virtual methods
.method public compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 11
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "comp"    # Lgnu/expr/Compilation;
    .param p3, "target"    # Lgnu/expr/Target;

    .prologue
    .line 106
    instance-of v9, p3, Lgnu/expr/IgnoreTarget;

    if-eqz v9, :cond_0

    .line 107
    invoke-static {p1, p2, p3}, Lgnu/expr/ApplyExp;->compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 157
    :goto_0
    return-void

    .line 108
    :cond_0
    instance-of v9, p3, Lgnu/expr/ConsumerTarget;

    if-nez v9, :cond_1

    .line 109
    invoke-static {p1, p2, p3}, Lgnu/kawa/xml/NodeConstructor;->compileUsingNodeTree(Lgnu/expr/Expression;Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto :goto_0

    :cond_1
    move-object v2, p3

    .line 112
    check-cast v2, Lgnu/expr/ConsumerTarget;

    .line 113
    .local v2, "ctarget":Lgnu/expr/ConsumerTarget;
    invoke-virtual {v2}, Lgnu/expr/ConsumerTarget;->getConsumerVariable()Lgnu/bytecode/Variable;

    move-result-object v4

    .line 114
    .local v4, "cvar":Lgnu/bytecode/Variable;
    invoke-virtual {v4}, Lgnu/bytecode/Variable;->getType()Lgnu/bytecode/Type;

    move-result-object v3

    .line 115
    .local v3, "ctype":Lgnu/bytecode/Type;
    sget-object v9, Lgnu/kawa/xml/NodeConstructor;->typeXMLFilter:Lgnu/bytecode/ClassType;

    invoke-virtual {v3, v9}, Lgnu/bytecode/Type;->isSubtype(Lgnu/bytecode/Type;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 116
    invoke-virtual {p0, p1, p2, v2}, Lgnu/kawa/xml/NodeConstructor;->compileToNode(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/ConsumerTarget;)V

    goto :goto_0

    .line 119
    :cond_2
    invoke-virtual {p1}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v0

    .line 120
    .local v0, "args":[Lgnu/expr/Expression;
    array-length v5, v0

    .line 121
    .local v5, "nargs":I
    invoke-virtual {p2}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v1

    .line 122
    .local v1, "code":Lgnu/bytecode/CodeAttr;
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->pushScope()Lgnu/bytecode/Scope;

    move-result-object v6

    .line 123
    .local v6, "scope":Lgnu/bytecode/Scope;
    sget-object v9, Lgnu/kawa/xml/NodeConstructor;->typeXMLFilter:Lgnu/bytecode/ClassType;

    const/4 v10, 0x0

    invoke-virtual {v6, v1, v9, v10}, Lgnu/bytecode/Scope;->addVariable(Lgnu/bytecode/CodeAttr;Lgnu/bytecode/Type;Ljava/lang/String;)Lgnu/bytecode/Variable;

    move-result-object v8

    .line 125
    .local v8, "xvar":Lgnu/bytecode/Variable;
    invoke-virtual {v2}, Lgnu/expr/ConsumerTarget;->isContextTarget()Z

    move-result v9

    if-eqz v9, :cond_3

    .line 127
    invoke-virtual {p2}, Lgnu/expr/Compilation;->loadCallContext()V

    .line 128
    sget-object v9, Lgnu/kawa/xml/NodeConstructor;->pushNodeContextMethod:Lgnu/bytecode/Method;

    invoke-virtual {v1, v9}, Lgnu/bytecode/CodeAttr;->emitInvokeStatic(Lgnu/bytecode/Method;)V

    .line 135
    :goto_1
    invoke-virtual {v1, v8}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 136
    const/4 v9, 0x1

    sget-object v10, Lgnu/bytecode/Type;->void_type:Lgnu/bytecode/PrimType;

    invoke-virtual {v1, v9, v10}, Lgnu/bytecode/CodeAttr;->emitTryStart(ZLgnu/bytecode/Type;)V

    .line 137
    new-instance v7, Lgnu/expr/ConsumerTarget;

    invoke-direct {v7, v8}, Lgnu/expr/ConsumerTarget;-><init>(Lgnu/bytecode/Variable;)V

    .line 138
    .local v7, "xtarget":Lgnu/expr/ConsumerTarget;
    invoke-virtual {p0, p1, p2, v7}, Lgnu/kawa/xml/NodeConstructor;->compileToNode(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/ConsumerTarget;)V

    .line 139
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitTryEnd()V

    .line 140
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitFinallyStart()V

    .line 141
    invoke-virtual {v1, v4}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 142
    invoke-virtual {v2}, Lgnu/expr/ConsumerTarget;->isContextTarget()Z

    move-result v9

    if-eqz v9, :cond_4

    .line 144
    invoke-virtual {p2}, Lgnu/expr/Compilation;->loadCallContext()V

    .line 145
    sget-object v9, Lgnu/kawa/xml/NodeConstructor;->popNodeContextMethod:Lgnu/bytecode/Method;

    invoke-virtual {v1, v9}, Lgnu/bytecode/CodeAttr;->emitInvokeStatic(Lgnu/bytecode/Method;)V

    .line 152
    :goto_2
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitFinallyEnd()V

    .line 153
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->emitTryCatchEnd()V

    .line 154
    invoke-virtual {v1}, Lgnu/bytecode/CodeAttr;->popScope()Lgnu/bytecode/Scope;

    goto :goto_0

    .line 132
    .end local v7    # "xtarget":Lgnu/expr/ConsumerTarget;
    :cond_3
    invoke-virtual {v1, v4}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 133
    sget-object v9, Lgnu/kawa/xml/NodeConstructor;->pushNodeConsumerMethod:Lgnu/bytecode/Method;

    invoke-virtual {v1, v9}, Lgnu/bytecode/CodeAttr;->emitInvokeStatic(Lgnu/bytecode/Method;)V

    goto :goto_1

    .line 149
    .restart local v7    # "xtarget":Lgnu/expr/ConsumerTarget;
    :cond_4
    invoke-virtual {v1, v8}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 150
    sget-object v9, Lgnu/kawa/xml/NodeConstructor;->popNodeConsumerMethod:Lgnu/bytecode/Method;

    invoke-virtual {v1, v9}, Lgnu/bytecode/CodeAttr;->emitInvokeStatic(Lgnu/bytecode/Method;)V

    goto :goto_2
.end method

.method public abstract compileToNode(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/ConsumerTarget;)V
.end method

.method public getReturnType([Lgnu/expr/Expression;)Lgnu/bytecode/Type;
    .locals 1
    .param p1, "args"    # [Lgnu/expr/Expression;

    .prologue
    .line 161
    sget-object v0, Lgnu/expr/Compilation;->typeObject:Lgnu/bytecode/ClassType;

    return-object v0
.end method
