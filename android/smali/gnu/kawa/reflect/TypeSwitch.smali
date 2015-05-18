.class public Lgnu/kawa/reflect/TypeSwitch;
.super Lgnu/mapping/MethodProc;
.source "TypeSwitch.java"

# interfaces
.implements Lgnu/expr/Inlineable;


# static fields
.field public static final typeSwitch:Lgnu/kawa/reflect/TypeSwitch;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 20
    new-instance v0, Lgnu/kawa/reflect/TypeSwitch;

    const-string v1, "typeswitch"

    invoke-direct {v0, v1}, Lgnu/kawa/reflect/TypeSwitch;-><init>(Ljava/lang/String;)V

    sput-object v0, Lgnu/kawa/reflect/TypeSwitch;->typeSwitch:Lgnu/kawa/reflect/TypeSwitch;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 23
    invoke-direct {p0}, Lgnu/mapping/MethodProc;-><init>()V

    .line 24
    invoke-virtual {p0, p1}, Lgnu/kawa/reflect/TypeSwitch;->setName(Ljava/lang/String;)V

    .line 25
    sget-object v0, Lgnu/mapping/Procedure;->validateApplyKey:Lgnu/mapping/Symbol;

    const-string v1, "gnu.kawa.reflect.CompileReflect:validateApplyTypeSwitch"

    invoke-virtual {p0, v0, v1}, Lgnu/kawa/reflect/TypeSwitch;->setProperty(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 27
    return-void
.end method


# virtual methods
.method public apply(Lgnu/mapping/CallContext;)V
    .locals 8
    .param p1, "ctx"    # Lgnu/mapping/CallContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 33
    invoke-virtual {p1}, Lgnu/mapping/CallContext;->getArgs()[Ljava/lang/Object;

    move-result-object v0

    .line 34
    .local v0, "args":[Ljava/lang/Object;
    const/4 v7, 0x0

    aget-object v6, v0, v7

    .line 35
    .local v6, "selector":Ljava/lang/Object;
    array-length v7, v0

    add-int/lit8 v5, v7, -0x1

    .line 36
    .local v5, "n":I
    const/4 v3, 0x1

    .local v3, "i":I
    :goto_0
    if-ge v3, v5, :cond_1

    .line 38
    aget-object v1, v0, v3

    check-cast v1, Lgnu/mapping/MethodProc;

    .line 39
    .local v1, "caseProc":Lgnu/mapping/MethodProc;
    invoke-virtual {v1, v6, p1}, Lgnu/mapping/MethodProc;->match1(Ljava/lang/Object;Lgnu/mapping/CallContext;)I

    move-result v4

    .line 40
    .local v4, "m":I
    if-ltz v4, :cond_0

    .line 45
    .end local v1    # "caseProc":Lgnu/mapping/MethodProc;
    .end local v4    # "m":I
    :goto_1
    return-void

    .line 36
    .restart local v1    # "caseProc":Lgnu/mapping/MethodProc;
    .restart local v4    # "m":I
    :cond_0
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 43
    .end local v1    # "caseProc":Lgnu/mapping/MethodProc;
    .end local v4    # "m":I
    :cond_1
    aget-object v2, v0, v5

    check-cast v2, Lgnu/mapping/Procedure;

    .line 44
    .local v2, "defaultProc":Lgnu/mapping/Procedure;
    invoke-virtual {v2, v6, p1}, Lgnu/mapping/Procedure;->check1(Ljava/lang/Object;Lgnu/mapping/CallContext;)V

    goto :goto_1
.end method

.method public compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 11
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "comp"    # Lgnu/expr/Compilation;
    .param p3, "target"    # Lgnu/expr/Target;

    .prologue
    .line 49
    invoke-virtual {p1}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v1

    .line 51
    .local v1, "args":[Lgnu/expr/Expression;
    invoke-virtual {p2}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v2

    .line 52
    .local v2, "code":Lgnu/bytecode/CodeAttr;
    invoke-virtual {v2}, Lgnu/bytecode/CodeAttr;->pushScope()Lgnu/bytecode/Scope;

    .line 53
    sget-object v9, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    invoke-virtual {v2, v9}, Lgnu/bytecode/CodeAttr;->addLocal(Lgnu/bytecode/Type;)Lgnu/bytecode/Variable;

    move-result-object v7

    .line 54
    .local v7, "selector":Lgnu/bytecode/Variable;
    const/4 v9, 0x0

    aget-object v9, v1, v9

    sget-object v10, Lgnu/expr/Target;->pushObject:Lgnu/expr/Target;

    invoke-virtual {v9, p2, v10}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 55
    invoke-virtual {v2, v7}, Lgnu/bytecode/CodeAttr;->emitStore(Lgnu/bytecode/Variable;)V

    .line 57
    const/4 v3, 0x1

    .local v3, "i":I
    :goto_0
    array-length v9, v1

    if-ge v3, v9, :cond_6

    .line 59
    const/4 v9, 0x1

    if-le v3, v9, :cond_0

    .line 60
    invoke-virtual {v2}, Lgnu/bytecode/CodeAttr;->emitElse()V

    .line 62
    :cond_0
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "i":I
    .local v4, "i":I
    aget-object v0, v1, v3

    .line 64
    .local v0, "arg":Lgnu/expr/Expression;
    instance-of v9, v0, Lgnu/expr/LambdaExp;

    if-eqz v9, :cond_5

    move-object v5, v0

    .line 66
    check-cast v5, Lgnu/expr/LambdaExp;

    .line 67
    .local v5, "lambda":Lgnu/expr/LambdaExp;
    invoke-virtual {v5}, Lgnu/expr/LambdaExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v6

    .line 68
    .local v6, "param":Lgnu/expr/Declaration;
    invoke-virtual {v6}, Lgnu/expr/Declaration;->getType()Lgnu/bytecode/Type;

    move-result-object v8

    .line 69
    .local v8, "type":Lgnu/bytecode/Type;
    invoke-virtual {v6}, Lgnu/expr/Declaration;->getCanRead()Z

    move-result v9

    if-nez v9, :cond_2

    .line 70
    const/4 v6, 0x0

    .line 74
    :goto_1
    instance-of v9, v8, Lgnu/expr/TypeValue;

    if-eqz v9, :cond_3

    .line 75
    check-cast v8, Lgnu/expr/TypeValue;

    .end local v8    # "type":Lgnu/bytecode/Type;
    invoke-interface {v8, v7, v6, p2}, Lgnu/expr/TypeValue;->emitTestIf(Lgnu/bytecode/Variable;Lgnu/expr/Declaration;Lgnu/expr/Compilation;)V

    .line 90
    :cond_1
    :goto_2
    invoke-virtual {v5, p2}, Lgnu/expr/LambdaExp;->allocChildClasses(Lgnu/expr/Compilation;)V

    .line 91
    iget-object v9, v5, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    invoke-virtual {v9, p2, p3}, Lgnu/expr/Expression;->compileWithPosition(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    move v3, v4

    .line 97
    .end local v4    # "i":I
    .restart local v3    # "i":I
    goto :goto_0

    .line 72
    .end local v3    # "i":I
    .restart local v4    # "i":I
    .restart local v8    # "type":Lgnu/bytecode/Type;
    :cond_2
    invoke-virtual {v6, v2}, Lgnu/expr/Declaration;->allocateVariable(Lgnu/bytecode/CodeAttr;)Lgnu/bytecode/Variable;

    goto :goto_1

    .line 78
    :cond_3
    array-length v9, v1

    if-ge v4, v9, :cond_4

    .line 80
    invoke-virtual {v2, v7}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 81
    invoke-virtual {v8, v2}, Lgnu/bytecode/Type;->emitIsInstance(Lgnu/bytecode/CodeAttr;)V

    .line 82
    invoke-virtual {v2}, Lgnu/bytecode/CodeAttr;->emitIfIntNotZero()V

    .line 84
    :cond_4
    if-eqz v6, :cond_1

    .line 86
    invoke-virtual {v2, v7}, Lgnu/bytecode/CodeAttr;->emitLoad(Lgnu/bytecode/Variable;)V

    .line 87
    invoke-virtual {v6, p2}, Lgnu/expr/Declaration;->compileStore(Lgnu/expr/Compilation;)V

    goto :goto_2

    .line 95
    .end local v5    # "lambda":Lgnu/expr/LambdaExp;
    .end local v6    # "param":Lgnu/expr/Declaration;
    .end local v8    # "type":Lgnu/bytecode/Type;
    :cond_5
    new-instance v9, Ljava/lang/Error;

    const-string v10, "not implemented: typeswitch arg not LambdaExp"

    invoke-direct {v9, v10}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v9

    .line 98
    .end local v0    # "arg":Lgnu/expr/Expression;
    .end local v4    # "i":I
    .restart local v3    # "i":I
    :cond_6
    array-length v9, v1

    add-int/lit8 v3, v9, -0x2

    :goto_3
    add-int/lit8 v3, v3, -0x1

    if-ltz v3, :cond_7

    .line 99
    invoke-virtual {v2}, Lgnu/bytecode/CodeAttr;->emitFi()V

    goto :goto_3

    .line 101
    :cond_7
    invoke-virtual {v2}, Lgnu/bytecode/CodeAttr;->popScope()Lgnu/bytecode/Scope;

    .line 102
    return-void
.end method

.method public getReturnType([Lgnu/expr/Expression;)Lgnu/bytecode/Type;
    .locals 1
    .param p1, "args"    # [Lgnu/expr/Expression;

    .prologue
    .line 107
    sget-object v0, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    return-object v0
.end method

.method public numArgs()I
    .locals 1

    .prologue
    .line 29
    const/16 v0, -0xffe

    return v0
.end method
