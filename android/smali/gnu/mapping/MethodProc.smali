.class public abstract Lgnu/mapping/MethodProc;
.super Lgnu/mapping/ProcedureN;
.source "MethodProc.java"


# static fields
.field public static final NO_MATCH:I = -0x1

.field public static final NO_MATCH_AMBIGUOUS:I = -0xd0000

.field public static final NO_MATCH_BAD_TYPE:I = -0xc0000

.field public static final NO_MATCH_TOO_FEW_ARGS:I = -0xf0000

.field public static final NO_MATCH_TOO_MANY_ARGS:I = -0xe0000

.field static final unknownArgTypes:[Lgnu/bytecode/Type;


# instance fields
.field protected argTypes:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 51
    const/4 v0, 0x1

    new-array v0, v0, [Lgnu/bytecode/Type;

    const/4 v1, 0x0

    sget-object v2, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    aput-object v2, v0, v1

    sput-object v0, Lgnu/mapping/MethodProc;->unknownArgTypes:[Lgnu/bytecode/Type;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lgnu/mapping/ProcedureN;-><init>()V

    return-void
.end method

.method public static matchFailAsException(ILgnu/mapping/Procedure;[Ljava/lang/Object;)Ljava/lang/RuntimeException;
    .locals 3
    .param p0, "code"    # I
    .param p1, "proc"    # Lgnu/mapping/Procedure;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 101
    int-to-short v0, p0

    .line 102
    .local v0, "arg":I
    const/high16 v1, -0x10000

    and-int/2addr p0, v1

    .line 103
    const/high16 v1, -0xc0000

    if-eq p0, v1, :cond_0

    .line 104
    new-instance v1, Lgnu/mapping/WrongArguments;

    array-length v2, p2

    invoke-direct {v1, p1, v2}, Lgnu/mapping/WrongArguments;-><init>(Lgnu/mapping/Procedure;I)V

    .line 105
    :goto_0
    return-object v1

    :cond_0
    new-instance v2, Lgnu/mapping/WrongType;

    if-lez v0, :cond_1

    add-int/lit8 v1, v0, -0x1

    aget-object v1, p2, v1

    :goto_1
    invoke-direct {v2, p1, v0, v1}, Lgnu/mapping/WrongType;-><init>(Lgnu/mapping/Procedure;ILjava/lang/Object;)V

    move-object v1, v2

    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public static mostSpecific([Lgnu/mapping/MethodProc;I)I
    .locals 11
    .param p0, "procs"    # [Lgnu/mapping/MethodProc;
    .param p1, "length"    # I

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 170
    if-gt p1, v10, :cond_1

    .line 171
    add-int/lit8 v2, p1, -0x1

    .line 221
    :cond_0
    :goto_0
    return v2

    .line 173
    :cond_1
    aget-object v0, p0, v9

    .line 176
    .local v0, "best":Lgnu/mapping/MethodProc;
    const/4 v3, 0x0

    .line 179
    .local v3, "bests":[Lgnu/mapping/MethodProc;
    const/4 v1, 0x0

    .line 181
    .local v1, "bestn":I
    const/4 v4, 0x1

    .local v4, "i":I
    move v2, v1

    .end local v1    # "bestn":I
    .local v2, "bestn":I
    :goto_1
    if-ge v4, p1, :cond_8

    .line 183
    aget-object v6, p0, v4

    .line 184
    .local v6, "method":Lgnu/mapping/MethodProc;
    if-eqz v0, :cond_4

    .line 186
    invoke-static {v0, v6}, Lgnu/mapping/MethodProc;->mostSpecific(Lgnu/mapping/MethodProc;Lgnu/mapping/MethodProc;)Lgnu/mapping/MethodProc;

    move-result-object v8

    .line 187
    .local v8, "winner":Lgnu/mapping/MethodProc;
    if-nez v8, :cond_3

    .line 189
    if-nez v3, :cond_2

    .line 190
    new-array v3, p1, [Lgnu/mapping/MethodProc;

    .line 191
    :cond_2
    aput-object v0, v3, v9

    .line 192
    aput-object v6, v3, v10

    .line 193
    const/4 v1, 0x2

    .line 194
    .end local v2    # "bestn":I
    .restart local v1    # "bestn":I
    const/4 v0, 0x0

    .line 181
    .end local v8    # "winner":Lgnu/mapping/MethodProc;
    :goto_2
    add-int/lit8 v4, v4, 0x1

    move v2, v1

    .end local v1    # "bestn":I
    .restart local v2    # "bestn":I
    goto :goto_1

    .line 196
    .restart local v8    # "winner":Lgnu/mapping/MethodProc;
    :cond_3
    if-ne v8, v6, :cond_9

    .line 198
    move-object v0, v6

    .line 199
    move v1, v4

    .end local v2    # "bestn":I
    .restart local v1    # "bestn":I
    goto :goto_2

    .line 204
    .end local v1    # "bestn":I
    .end local v8    # "winner":Lgnu/mapping/MethodProc;
    .restart local v2    # "bestn":I
    :cond_4
    const/4 v5, 0x0

    .local v5, "j":I
    :goto_3
    if-ge v5, v2, :cond_7

    .line 206
    aget-object v7, v3, v5

    .line 207
    .local v7, "old":Lgnu/mapping/MethodProc;
    invoke-static {v7, v6}, Lgnu/mapping/MethodProc;->mostSpecific(Lgnu/mapping/MethodProc;Lgnu/mapping/MethodProc;)Lgnu/mapping/MethodProc;

    move-result-object v8

    .line 208
    .restart local v8    # "winner":Lgnu/mapping/MethodProc;
    if-ne v8, v7, :cond_5

    move v1, v2

    .line 209
    .end local v2    # "bestn":I
    .restart local v1    # "bestn":I
    goto :goto_2

    .line 210
    .end local v1    # "bestn":I
    .restart local v2    # "bestn":I
    :cond_5
    if-nez v8, :cond_6

    .line 212
    add-int/lit8 v1, v2, 0x1

    .end local v2    # "bestn":I
    .restart local v1    # "bestn":I
    aput-object v6, v3, v2

    goto :goto_2

    .line 204
    .end local v1    # "bestn":I
    .restart local v2    # "bestn":I
    :cond_6
    add-int/lit8 v5, v5, 0x1

    goto :goto_3

    .line 217
    .end local v7    # "old":Lgnu/mapping/MethodProc;
    .end local v8    # "winner":Lgnu/mapping/MethodProc;
    :cond_7
    move-object v0, v6

    .line 218
    move v1, v4

    .end local v2    # "bestn":I
    .restart local v1    # "bestn":I
    goto :goto_2

    .line 221
    .end local v1    # "bestn":I
    .end local v5    # "j":I
    .end local v6    # "method":Lgnu/mapping/MethodProc;
    .restart local v2    # "bestn":I
    :cond_8
    if-nez v0, :cond_0

    const/4 v2, -0x1

    goto :goto_0

    .restart local v6    # "method":Lgnu/mapping/MethodProc;
    .restart local v8    # "winner":Lgnu/mapping/MethodProc;
    :cond_9
    move v1, v2

    .end local v2    # "bestn":I
    .restart local v1    # "bestn":I
    goto :goto_2
.end method

.method public static mostSpecific(Lgnu/mapping/MethodProc;Lgnu/mapping/MethodProc;)Lgnu/mapping/MethodProc;
    .locals 14
    .param p0, "proc1"    # Lgnu/mapping/MethodProc;
    .param p1, "proc2"    # Lgnu/mapping/MethodProc;

    .prologue
    .line 122
    const/4 v7, 0x0

    .line 124
    .local v7, "not1":Z
    const/4 v8, 0x0

    .line 125
    .local v8, "not2":Z
    invoke-virtual {p0}, Lgnu/mapping/MethodProc;->minArgs()I

    move-result v5

    .line 126
    .local v5, "min1":I
    invoke-virtual {p1}, Lgnu/mapping/MethodProc;->minArgs()I

    move-result v6

    .line 127
    .local v6, "min2":I
    invoke-virtual {p0}, Lgnu/mapping/MethodProc;->maxArgs()I

    move-result v3

    .line 128
    .local v3, "max1":I
    invoke-virtual {p1}, Lgnu/mapping/MethodProc;->maxArgs()I

    move-result v4

    .line 129
    .local v4, "max2":I
    if-ltz v3, :cond_0

    if-lt v3, v6, :cond_1

    :cond_0
    if-ltz v4, :cond_3

    if-ge v4, v5, :cond_3

    .line 131
    :cond_1
    const/4 p0, 0x0

    .line 164
    .end local p0    # "proc1":Lgnu/mapping/MethodProc;
    :cond_2
    :goto_0
    return-object p0

    .line 132
    .restart local p0    # "proc1":Lgnu/mapping/MethodProc;
    :cond_3
    invoke-virtual {p0}, Lgnu/mapping/MethodProc;->numParameters()I

    move-result v9

    .line 133
    .local v9, "num1":I
    invoke-virtual {p1}, Lgnu/mapping/MethodProc;->numParameters()I

    move-result v10

    .line 134
    .local v10, "num2":I
    if-le v9, v10, :cond_7

    move v2, v9

    .line 135
    .local v2, "limit":I
    :goto_1
    if-eq v3, v4, :cond_5

    .line 137
    if-gez v3, :cond_4

    .line 138
    const/4 v7, 0x1

    .line 139
    :cond_4
    if-gez v4, :cond_5

    .line 140
    const/4 v8, 0x1

    .line 142
    :cond_5
    if-ge v5, v6, :cond_8

    .line 143
    const/4 v7, 0x1

    .line 146
    :cond_6
    :goto_2
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_3
    if-ge v1, v2, :cond_b

    .line 148
    invoke-virtual {p0, v1}, Lgnu/mapping/MethodProc;->getParameterType(I)Lgnu/bytecode/Type;

    move-result-object v11

    .line 149
    .local v11, "t1":Lgnu/bytecode/Type;
    invoke-virtual {p1, v1}, Lgnu/mapping/MethodProc;->getParameterType(I)Lgnu/bytecode/Type;

    move-result-object v12

    .line 150
    .local v12, "t2":Lgnu/bytecode/Type;
    invoke-virtual {v11, v12}, Lgnu/bytecode/Type;->compare(Lgnu/bytecode/Type;)I

    move-result v0

    .line 151
    .local v0, "comp":I
    const/4 v13, -0x1

    if-ne v0, v13, :cond_9

    .line 153
    const/4 v8, 0x1

    .line 154
    if-eqz v7, :cond_9

    .line 155
    const/4 p0, 0x0

    goto :goto_0

    .end local v0    # "comp":I
    .end local v1    # "i":I
    .end local v2    # "limit":I
    .end local v11    # "t1":Lgnu/bytecode/Type;
    .end local v12    # "t2":Lgnu/bytecode/Type;
    :cond_7
    move v2, v10

    .line 134
    goto :goto_1

    .line 144
    .restart local v2    # "limit":I
    :cond_8
    if-le v5, v6, :cond_6

    .line 145
    const/4 v8, 0x1

    goto :goto_2

    .line 157
    .restart local v0    # "comp":I
    .restart local v1    # "i":I
    .restart local v11    # "t1":Lgnu/bytecode/Type;
    .restart local v12    # "t2":Lgnu/bytecode/Type;
    :cond_9
    const/4 v13, 0x1

    if-ne v0, v13, :cond_a

    .line 159
    const/4 v7, 0x1

    .line 160
    if-eqz v8, :cond_a

    .line 161
    const/4 p0, 0x0

    goto :goto_0

    .line 146
    :cond_a
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 164
    .end local v0    # "comp":I
    .end local v11    # "t1":Lgnu/bytecode/Type;
    .end local v12    # "t2":Lgnu/bytecode/Type;
    :cond_b
    if-nez v8, :cond_2

    if-eqz v7, :cond_c

    move-object p0, p1

    goto :goto_0

    :cond_c
    const/4 p0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 110
    array-length v1, p1

    invoke-static {p0, v1}, Lgnu/mapping/MethodProc;->checkArgCount(Lgnu/mapping/Procedure;I)V

    .line 111
    invoke-static {}, Lgnu/mapping/CallContext;->getInstance()Lgnu/mapping/CallContext;

    move-result-object v0

    .line 112
    .local v0, "ctx":Lgnu/mapping/CallContext;
    invoke-virtual {p0, p1, v0}, Lgnu/mapping/MethodProc;->checkN([Ljava/lang/Object;Lgnu/mapping/CallContext;)V

    .line 113
    invoke-virtual {v0}, Lgnu/mapping/CallContext;->runUntilValue()Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public getParameterType(I)Lgnu/bytecode/Type;
    .locals 3
    .param p1, "index"    # I

    .prologue
    .line 61
    iget-object v2, p0, Lgnu/mapping/MethodProc;->argTypes:Ljava/lang/Object;

    instance-of v2, v2, [Lgnu/bytecode/Type;

    if-nez v2, :cond_0

    .line 62
    invoke-virtual {p0}, Lgnu/mapping/MethodProc;->resolveParameterTypes()V

    .line 64
    :cond_0
    iget-object v2, p0, Lgnu/mapping/MethodProc;->argTypes:Ljava/lang/Object;

    check-cast v2, [Lgnu/bytecode/Type;

    move-object v0, v2

    check-cast v0, [Lgnu/bytecode/Type;

    .line 65
    .local v0, "atypes":[Lgnu/bytecode/Type;
    array-length v2, v0

    if-ge p1, v2, :cond_2

    array-length v2, v0

    add-int/lit8 v2, v2, -0x1

    if-lt p1, v2, :cond_1

    invoke-virtual {p0}, Lgnu/mapping/MethodProc;->maxArgs()I

    move-result v2

    if-ltz v2, :cond_2

    .line 67
    :cond_1
    aget-object v2, v0, p1

    .line 74
    :goto_0
    return-object v2

    .line 68
    :cond_2
    invoke-virtual {p0}, Lgnu/mapping/MethodProc;->maxArgs()I

    move-result v2

    if-gez v2, :cond_3

    .line 70
    array-length v2, v0

    add-int/lit8 v2, v2, -0x1

    aget-object v1, v0, v2

    .line 71
    .local v1, "rtype":Lgnu/bytecode/Type;
    instance-of v2, v1, Lgnu/bytecode/ArrayType;

    if-eqz v2, :cond_3

    .line 72
    check-cast v1, Lgnu/bytecode/ArrayType;

    .end local v1    # "rtype":Lgnu/bytecode/Type;
    invoke-virtual {v1}, Lgnu/bytecode/ArrayType;->getComponentType()Lgnu/bytecode/Type;

    move-result-object v2

    goto :goto_0

    .line 74
    :cond_3
    sget-object v2, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    goto :goto_0
.end method

.method public isApplicable([Lgnu/bytecode/Type;)I
    .locals 8
    .param p1, "argTypes"    # [Lgnu/bytecode/Type;

    .prologue
    const/4 v6, -0x1

    .line 21
    array-length v0, p1

    .line 22
    .local v0, "argCount":I
    invoke-virtual {p0}, Lgnu/mapping/MethodProc;->numArgs()I

    move-result v3

    .line 23
    .local v3, "num":I
    and-int/lit16 v7, v3, 0xfff

    if-lt v0, v7, :cond_0

    if-ltz v3, :cond_2

    shr-int/lit8 v7, v3, 0xc

    if-le v0, v7, :cond_2

    :cond_0
    move v5, v6

    .line 36
    :cond_1
    :goto_0
    return v5

    .line 26
    :cond_2
    const/4 v5, 0x1

    .line 27
    .local v5, "result":I
    move v2, v0

    .local v2, "i":I
    :cond_3
    :goto_1
    add-int/lit8 v2, v2, -0x1

    if-ltz v2, :cond_1

    .line 29
    invoke-virtual {p0, v2}, Lgnu/mapping/MethodProc;->getParameterType(I)Lgnu/bytecode/Type;

    move-result-object v4

    .line 30
    .local v4, "ptype":Lgnu/bytecode/Type;
    aget-object v7, p1, v2

    invoke-virtual {v4, v7}, Lgnu/bytecode/Type;->compare(Lgnu/bytecode/Type;)I

    move-result v1

    .line 31
    .local v1, "code":I
    const/4 v7, -0x3

    if-ne v1, v7, :cond_4

    move v5, v6

    .line 32
    goto :goto_0

    .line 33
    :cond_4
    if-gez v1, :cond_3

    .line 34
    const/4 v5, 0x0

    goto :goto_1
.end method

.method public numParameters()I
    .locals 3

    .prologue
    .line 42
    invoke-virtual {p0}, Lgnu/mapping/MethodProc;->numArgs()I

    move-result v2

    .line 43
    .local v2, "num":I
    shr-int/lit8 v0, v2, 0xc

    .line 44
    .local v0, "max":I
    if-ltz v0, :cond_0

    .line 48
    .end local v0    # "max":I
    :goto_0
    return v0

    .line 47
    .restart local v0    # "max":I
    :cond_0
    and-int/lit16 v1, v2, 0xfff

    .line 48
    .local v1, "min":I
    add-int/lit8 v0, v1, 0x1

    goto :goto_0
.end method

.method protected resolveParameterTypes()V
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lgnu/mapping/MethodProc;->unknownArgTypes:[Lgnu/bytecode/Type;

    iput-object v0, p0, Lgnu/mapping/MethodProc;->argTypes:Ljava/lang/Object;

    .line 57
    return-void
.end method
