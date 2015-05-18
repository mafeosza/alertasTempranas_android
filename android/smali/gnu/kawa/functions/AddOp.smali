.class public Lgnu/kawa/functions/AddOp;
.super Lgnu/kawa/functions/ArithOp;
.source "AddOp.java"


# static fields
.field public static final $Mn:Lgnu/kawa/functions/AddOp;

.field public static final $Pl:Lgnu/kawa/functions/AddOp;


# instance fields
.field plusOrMinus:I


# direct methods
.method public static $Mn(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p0, "arg1"    # Ljava/lang/Object;

    .prologue
    .line 97
    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->classifyValue(Ljava/lang/Object;)I

    move-result v0

    .line 98
    .local v0, "code":I
    packed-switch v0, :pswitch_data_0

    .line 119
    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asNumeric(Ljava/lang/Object;)Lgnu/math/Numeric;

    move-result-object v1

    invoke-virtual {v1}, Lgnu/math/Numeric;->neg()Lgnu/math/Numeric;

    move-result-object v1

    :goto_0
    return-object v1

    .line 101
    :pswitch_0
    new-instance v1, Ljava/lang/Integer;

    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asInt(Ljava/lang/Object;)I

    move-result v2

    neg-int v2, v2

    invoke-direct {v1, v2}, Ljava/lang/Integer;-><init>(I)V

    goto :goto_0

    .line 103
    :pswitch_1
    new-instance v1, Ljava/lang/Long;

    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asLong(Ljava/lang/Object;)J

    move-result-wide v2

    neg-long v2, v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Long;-><init>(J)V

    goto :goto_0

    .line 105
    :pswitch_2
    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asBigInteger(Ljava/lang/Object;)Ljava/math/BigInteger;

    move-result-object v1

    invoke-virtual {v1}, Ljava/math/BigInteger;->negate()Ljava/math/BigInteger;

    move-result-object v1

    goto :goto_0

    .line 107
    :pswitch_3
    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asIntNum(Ljava/lang/Object;)Lgnu/math/IntNum;

    move-result-object v1

    invoke-static {v1}, Lgnu/math/IntNum;->neg(Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v1

    goto :goto_0

    .line 109
    :pswitch_4
    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asBigDecimal(Ljava/lang/Object;)Ljava/math/BigDecimal;

    move-result-object v1

    invoke-virtual {v1}, Ljava/math/BigDecimal;->negate()Ljava/math/BigDecimal;

    move-result-object v1

    goto :goto_0

    .line 111
    :pswitch_5
    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asRatNum(Ljava/lang/Object;)Lgnu/math/RatNum;

    move-result-object v1

    invoke-static {v1}, Lgnu/math/RatNum;->neg(Lgnu/math/RatNum;)Lgnu/math/RatNum;

    move-result-object v1

    goto :goto_0

    .line 113
    :pswitch_6
    new-instance v1, Ljava/lang/Float;

    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asFloat(Ljava/lang/Object;)F

    move-result v2

    neg-float v2, v2

    invoke-direct {v1, v2}, Ljava/lang/Float;-><init>(F)V

    goto :goto_0

    .line 115
    :pswitch_7
    new-instance v1, Ljava/lang/Double;

    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v2

    neg-double v2, v2

    invoke-direct {v1, v2, v3}, Ljava/lang/Double;-><init>(D)V

    goto :goto_0

    .line 117
    :pswitch_8
    new-instance v1, Lgnu/math/DFloNum;

    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v2

    neg-double v2, v2

    invoke-direct {v1, v2, v3}, Lgnu/math/DFloNum;-><init>(D)V

    goto :goto_0

    .line 98
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public static $Mn(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "arg1"    # Ljava/lang/Object;
    .param p1, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 92
    const/4 v0, -0x1

    invoke-static {v0, p0, p1}, Lgnu/kawa/functions/AddOp;->apply2(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static $Mn$V(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p0, "arg1"    # Ljava/lang/Object;
    .param p1, "arg2"    # Ljava/lang/Object;
    .param p2, "arg3"    # Ljava/lang/Object;
    .param p3, "rest"    # [Ljava/lang/Object;

    .prologue
    const/4 v1, -0x1

    .line 133
    invoke-static {v1, p0, p1}, Lgnu/kawa/functions/AddOp;->apply2(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v1, v0, p2}, Lgnu/kawa/functions/AddOp;->apply2(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v1, v0, p3}, Lgnu/kawa/functions/AddOp;->applyN(ILjava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static $Pl(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "arg1"    # Ljava/lang/Object;
    .param p1, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 87
    const/4 v0, 0x1

    invoke-static {v0, p0, p1}, Lgnu/kawa/functions/AddOp;->apply2(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static $Pl$V(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p0, "arg1"    # Ljava/lang/Object;
    .param p1, "arg2"    # Ljava/lang/Object;
    .param p2, "arg3"    # Ljava/lang/Object;
    .param p3, "rest"    # [Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    .line 127
    invoke-static {v1, p0, p1}, Lgnu/kawa/functions/AddOp;->apply2(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v1, v0, p2}, Lgnu/kawa/functions/AddOp;->apply2(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v1, v0, p3}, Lgnu/kawa/functions/AddOp;->applyN(ILjava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 30
    new-instance v0, Lgnu/kawa/functions/AddOp;

    const-string v1, "+"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lgnu/kawa/functions/AddOp;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    .line 31
    new-instance v0, Lgnu/kawa/functions/AddOp;

    const-string v1, "-"

    const/4 v2, -0x1

    invoke-direct {v0, v1, v2}, Lgnu/kawa/functions/AddOp;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "plusOrMinus"    # I

    .prologue
    const/4 v2, 0x1

    .line 20
    if-lez p2, :cond_0

    move v1, v2

    :goto_0
    invoke-direct {p0, p1, v1}, Lgnu/kawa/functions/ArithOp;-><init>(Ljava/lang/String;I)V

    .line 16
    iput v2, p0, Lgnu/kawa/functions/AddOp;->plusOrMinus:I

    .line 21
    iput p2, p0, Lgnu/kawa/functions/AddOp;->plusOrMinus:I

    .line 22
    if-lez p2, :cond_1

    const-string v0, "gnu.kawa.functions.CompileArith:$Pl"

    .line 25
    .local v0, "compiler":Ljava/lang/String;
    :goto_1
    sget-object v1, Lgnu/mapping/Procedure;->compilerKey:Lgnu/mapping/LazyPropertyKey;

    invoke-virtual {v1, p0, v0}, Lgnu/mapping/LazyPropertyKey;->set(Lgnu/mapping/PropertySet;Ljava/lang/String;)V

    .line 26
    sget-object v1, Lgnu/mapping/Procedure;->validateApplyKey:Lgnu/mapping/Symbol;

    const-string v2, "gnu.kawa.functions.CompileArith:validateApplyArithOp"

    invoke-virtual {p0, v1, v2}, Lgnu/kawa/functions/AddOp;->setProperty(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 28
    return-void

    .line 20
    .end local v0    # "compiler":Ljava/lang/String;
    :cond_0
    const/4 v1, 0x2

    goto :goto_0

    .line 22
    :cond_1
    const-string v0, "gnu.kawa.functions.CompileArith:$Mn"

    goto :goto_1
.end method

.method public static apply2(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 27
    .param p0, "plusOrMinus"    # I
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 35
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->classifyValue(Ljava/lang/Object;)I

    move-result v8

    .line 36
    .local v8, "code1":I
    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->classifyValue(Ljava/lang/Object;)I

    move-result v9

    .line 41
    .local v9, "code2":I
    if-ge v8, v9, :cond_0

    move v7, v9

    .line 42
    .local v7, "code":I
    :goto_0
    packed-switch v7, :pswitch_data_0

    .line 79
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asNumeric(Ljava/lang/Object;)Lgnu/math/Numeric;

    move-result-object v22

    .line 80
    .local v22, "num1":Lgnu/math/Numeric;
    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asNumeric(Ljava/lang/Object;)Lgnu/math/Numeric;

    move-result-object v23

    .line 81
    .local v23, "num2":Lgnu/math/Numeric;
    move-object/from16 v0, v22

    move-object/from16 v1, v23

    move/from16 v2, p0

    invoke-virtual {v0, v1, v2}, Lgnu/math/Numeric;->add(Ljava/lang/Object;I)Lgnu/math/Numeric;

    move-result-object v24

    .end local v22    # "num1":Lgnu/math/Numeric;
    .end local v23    # "num2":Lgnu/math/Numeric;
    :goto_1
    return-object v24

    .end local v7    # "code":I
    :cond_0
    move v7, v8

    .line 41
    goto :goto_0

    .line 45
    .restart local v7    # "code":I
    :pswitch_0
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asInt(Ljava/lang/Object;)I

    move-result v16

    .line 46
    .local v16, "i1":I
    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asInt(Ljava/lang/Object;)I

    move-result v17

    .line 47
    .local v17, "i2":I
    new-instance v25, Ljava/lang/Integer;

    if-lez p0, :cond_1

    add-int v24, v16, v17

    :goto_2
    move-object/from16 v0, v25

    move/from16 v1, v24

    invoke-direct {v0, v1}, Ljava/lang/Integer;-><init>(I)V

    move-object/from16 v24, v25

    goto :goto_1

    :cond_1
    sub-int v24, v16, v17

    goto :goto_2

    .line 49
    .end local v16    # "i1":I
    .end local v17    # "i2":I
    :pswitch_1
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asLong(Ljava/lang/Object;)J

    move-result-wide v18

    .line 50
    .local v18, "l1":J
    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asLong(Ljava/lang/Object;)J

    move-result-wide v20

    .line 51
    .local v20, "l2":J
    new-instance v26, Ljava/lang/Long;

    if-lez p0, :cond_2

    add-long v24, v18, v20

    :goto_3
    move-object/from16 v0, v26

    move-wide/from16 v1, v24

    invoke-direct {v0, v1, v2}, Ljava/lang/Long;-><init>(J)V

    move-object/from16 v24, v26

    goto :goto_1

    :cond_2
    sub-long v24, v18, v20

    goto :goto_3

    .line 53
    .end local v18    # "l1":J
    .end local v20    # "l2":J
    :pswitch_2
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asBigInteger(Ljava/lang/Object;)Ljava/math/BigInteger;

    move-result-object v5

    .line 54
    .local v5, "bi1":Ljava/math/BigInteger;
    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asBigInteger(Ljava/lang/Object;)Ljava/math/BigInteger;

    move-result-object v6

    .line 55
    .local v6, "bi2":Ljava/math/BigInteger;
    if-lez p0, :cond_3

    invoke-virtual {v5, v6}, Ljava/math/BigInteger;->add(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v24

    goto :goto_1

    :cond_3
    invoke-virtual {v5, v6}, Ljava/math/BigInteger;->subtract(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v24

    goto :goto_1

    .line 57
    .end local v5    # "bi1":Ljava/math/BigInteger;
    .end local v6    # "bi2":Ljava/math/BigInteger;
    :pswitch_3
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asIntNum(Ljava/lang/Object;)Lgnu/math/IntNum;

    move-result-object v24

    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asIntNum(Ljava/lang/Object;)Lgnu/math/IntNum;

    move-result-object v25

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    move/from16 v2, p0

    invoke-static {v0, v1, v2}, Lgnu/math/IntNum;->add(Lgnu/math/IntNum;Lgnu/math/IntNum;I)Lgnu/math/IntNum;

    move-result-object v24

    goto :goto_1

    .line 60
    :pswitch_4
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asBigDecimal(Ljava/lang/Object;)Ljava/math/BigDecimal;

    move-result-object v3

    .line 61
    .local v3, "bd1":Ljava/math/BigDecimal;
    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asBigDecimal(Ljava/lang/Object;)Ljava/math/BigDecimal;

    move-result-object v4

    .line 62
    .local v4, "bd2":Ljava/math/BigDecimal;
    if-lez p0, :cond_4

    invoke-virtual {v3, v4}, Ljava/math/BigDecimal;->add(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v24

    goto :goto_1

    :cond_4
    invoke-virtual {v3, v4}, Ljava/math/BigDecimal;->subtract(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v24

    goto :goto_1

    .line 64
    .end local v3    # "bd1":Ljava/math/BigDecimal;
    .end local v4    # "bd2":Ljava/math/BigDecimal;
    :pswitch_5
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asRatNum(Ljava/lang/Object;)Lgnu/math/RatNum;

    move-result-object v24

    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asRatNum(Ljava/lang/Object;)Lgnu/math/RatNum;

    move-result-object v25

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    move/from16 v2, p0

    invoke-static {v0, v1, v2}, Lgnu/math/RatNum;->add(Lgnu/math/RatNum;Lgnu/math/RatNum;I)Lgnu/math/RatNum;

    move-result-object v24

    goto/16 :goto_1

    .line 67
    :pswitch_6
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asFloat(Ljava/lang/Object;)F

    move-result v14

    .line 68
    .local v14, "f1":F
    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asFloat(Ljava/lang/Object;)F

    move-result v15

    .line 69
    .local v15, "f2":F
    new-instance v25, Ljava/lang/Float;

    if-lez p0, :cond_5

    add-float v24, v14, v15

    :goto_4
    move-object/from16 v0, v25

    move/from16 v1, v24

    invoke-direct {v0, v1}, Ljava/lang/Float;-><init>(F)V

    move-object/from16 v24, v25

    goto/16 :goto_1

    :cond_5
    sub-float v24, v14, v15

    goto :goto_4

    .line 71
    .end local v14    # "f1":F
    .end local v15    # "f2":F
    :pswitch_7
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v10

    .line 72
    .local v10, "d1":D
    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v12

    .line 73
    .local v12, "d2":D
    new-instance v26, Ljava/lang/Double;

    if-lez p0, :cond_6

    add-double v24, v10, v12

    :goto_5
    move-object/from16 v0, v26

    move-wide/from16 v1, v24

    invoke-direct {v0, v1, v2}, Ljava/lang/Double;-><init>(D)V

    move-object/from16 v24, v26

    goto/16 :goto_1

    :cond_6
    sub-double v24, v10, v12

    goto :goto_5

    .line 75
    .end local v10    # "d1":D
    .end local v12    # "d2":D
    :pswitch_8
    invoke-static/range {p1 .. p1}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v10

    .line 76
    .restart local v10    # "d1":D
    invoke-static/range {p2 .. p2}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v12

    .line 77
    .restart local v12    # "d2":D
    new-instance v26, Lgnu/math/DFloNum;

    if-lez p0, :cond_7

    add-double v24, v10, v12

    :goto_6
    move-object/from16 v0, v26

    move-wide/from16 v1, v24

    invoke-direct {v0, v1, v2}, Lgnu/math/DFloNum;-><init>(D)V

    move-object/from16 v24, v26

    goto/16 :goto_1

    :cond_7
    sub-double v24, v10, v12

    goto :goto_6

    .line 42
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch
.end method

.method public static applyN(ILjava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p0, "plusOrMinus"    # I
    .param p1, "init"    # Ljava/lang/Object;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 151
    array-length v1, p2

    .line 152
    .local v1, "len":I
    move-object v2, p1

    .line 153
    .local v2, "result":Ljava/lang/Object;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 154
    aget-object v3, p2, v0

    invoke-static {p0, v2, v3}, Lgnu/kawa/functions/AddOp;->apply2(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 153
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 155
    :cond_0
    return-object v2
.end method

.method public static applyN(I[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p0, "plusOrMinus"    # I
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 138
    array-length v1, p1

    .line 139
    .local v1, "len":I
    if-nez v1, :cond_1

    .line 140
    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v2

    .line 146
    :cond_0
    :goto_0
    return-object v2

    .line 141
    :cond_1
    const/4 v3, 0x0

    aget-object v2, p1, v3

    .line 142
    .local v2, "result":Ljava/lang/Object;
    const/4 v3, 0x1

    if-ne v1, v3, :cond_2

    if-gez p0, :cond_2

    .line 143
    invoke-static {v2}, Lgnu/kawa/functions/AddOp;->$Mn(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    goto :goto_0

    .line 144
    :cond_2
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_1
    if-ge v0, v1, :cond_0

    .line 145
    aget-object v3, p1, v0

    invoke-static {p0, v2, v3}, Lgnu/kawa/functions/AddOp;->apply2(ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 144
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method


# virtual methods
.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 160
    iget v0, p0, Lgnu/kawa/functions/AddOp;->plusOrMinus:I

    invoke-static {v0, p1}, Lgnu/kawa/functions/AddOp;->applyN(I[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
