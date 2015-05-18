.class public Lgnu/kawa/functions/MultiplyOp;
.super Lgnu/kawa/functions/ArithOp;
.source "MultiplyOp.java"


# static fields
.field public static final $St:Lgnu/kawa/functions/MultiplyOp;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 16
    new-instance v0, Lgnu/kawa/functions/MultiplyOp;

    const-string v1, "*"

    invoke-direct {v0, v1}, Lgnu/kawa/functions/MultiplyOp;-><init>(Ljava/lang/String;)V

    sput-object v0, Lgnu/kawa/functions/MultiplyOp;->$St:Lgnu/kawa/functions/MultiplyOp;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 20
    const/4 v0, 0x3

    invoke-direct {p0, p1, v0}, Lgnu/kawa/functions/ArithOp;-><init>(Ljava/lang/String;I)V

    .line 21
    sget-object v0, Lgnu/mapping/Procedure;->validateApplyKey:Lgnu/mapping/Symbol;

    const-string v1, "gnu.kawa.functions.CompileArith:validateApplyArithOp"

    invoke-virtual {p0, v0, v1}, Lgnu/kawa/functions/MultiplyOp;->setProperty(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 23
    sget-object v0, Lgnu/mapping/Procedure;->compilerKey:Lgnu/mapping/LazyPropertyKey;

    const-string v1, "*gnu.kawa.functions.CompileArith:forMul"

    invoke-virtual {v0, p0, v1}, Lgnu/mapping/LazyPropertyKey;->set(Lgnu/mapping/PropertySet;Ljava/lang/String;)V

    .line 24
    return-void
.end method

.method public static apply(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "arg1"    # Ljava/lang/Object;
    .param p1, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 33
    check-cast p0, Lgnu/math/Numeric;

    .end local p0    # "arg1":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lgnu/math/Numeric;->mul(Ljava/lang/Object;)Lgnu/math/Numeric;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public applyN([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 25
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 38
    move-object/from16 v0, p1

    array-length v0, v0

    move/from16 v21, v0

    .line 39
    .local v21, "len":I
    if-nez v21, :cond_1

    .line 40
    invoke-static {}, Lgnu/math/IntNum;->one()Lgnu/math/IntNum;

    move-result-object v22

    .line 99
    :cond_0
    return-object v22

    .line 41
    :cond_1
    const/16 v23, 0x0

    aget-object v22, p1, v23

    check-cast v22, Ljava/lang/Number;

    .line 42
    .local v22, "result":Ljava/lang/Number;
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->classifyValue(Ljava/lang/Object;)I

    move-result v6

    .line 43
    .local v6, "code":I
    const/4 v14, 0x1

    .local v14, "i":I
    :goto_0
    move/from16 v0, v21

    if-ge v14, v0, :cond_0

    .line 45
    aget-object v1, p1, v14

    .line 46
    .local v1, "arg2":Ljava/lang/Object;
    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->classifyValue(Ljava/lang/Object;)I

    move-result v7

    .line 47
    .local v7, "code2":I
    if-ge v6, v7, :cond_2

    move v6, v7

    .line 49
    :cond_2
    packed-switch v6, :pswitch_data_0

    .line 95
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asNumeric(Ljava/lang/Object;)Lgnu/math/Numeric;

    move-result-object v23

    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asNumeric(Ljava/lang/Object;)Lgnu/math/Numeric;

    move-result-object v24

    invoke-virtual/range {v23 .. v24}, Lgnu/math/Numeric;->mul(Ljava/lang/Object;)Lgnu/math/Numeric;

    move-result-object v22

    .line 43
    :goto_1
    add-int/lit8 v14, v14, 0x1

    goto :goto_0

    .line 52
    :pswitch_0
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asInt(Ljava/lang/Object;)I

    move-result v15

    .line 53
    .local v15, "i1":I
    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asInt(Ljava/lang/Object;)I

    move-result v16

    .line 54
    .local v16, "i2":I
    new-instance v22, Ljava/lang/Integer;

    .end local v22    # "result":Ljava/lang/Number;
    mul-int v23, v15, v16

    invoke-direct/range {v22 .. v23}, Ljava/lang/Integer;-><init>(I)V

    .line 55
    .restart local v22    # "result":Ljava/lang/Number;
    goto :goto_1

    .line 57
    .end local v15    # "i1":I
    .end local v16    # "i2":I
    :pswitch_1
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asLong(Ljava/lang/Object;)J

    move-result-wide v17

    .line 58
    .local v17, "l1":J
    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asLong(Ljava/lang/Object;)J

    move-result-wide v19

    .line 59
    .local v19, "l2":J
    new-instance v22, Ljava/lang/Long;

    .end local v22    # "result":Ljava/lang/Number;
    mul-long v23, v17, v19

    invoke-direct/range {v22 .. v24}, Ljava/lang/Long;-><init>(J)V

    .line 60
    .restart local v22    # "result":Ljava/lang/Number;
    goto :goto_1

    .line 62
    .end local v17    # "l1":J
    .end local v19    # "l2":J
    :pswitch_2
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asBigInteger(Ljava/lang/Object;)Ljava/math/BigInteger;

    move-result-object v4

    .line 63
    .local v4, "bi1":Ljava/math/BigInteger;
    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asBigInteger(Ljava/lang/Object;)Ljava/math/BigInteger;

    move-result-object v5

    .line 64
    .local v5, "bi2":Ljava/math/BigInteger;
    invoke-virtual {v4, v5}, Ljava/math/BigInteger;->multiply(Ljava/math/BigInteger;)Ljava/math/BigInteger;

    move-result-object v22

    .line 65
    goto :goto_1

    .line 67
    .end local v4    # "bi1":Ljava/math/BigInteger;
    .end local v5    # "bi2":Ljava/math/BigInteger;
    :pswitch_3
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asIntNum(Ljava/lang/Object;)Lgnu/math/IntNum;

    move-result-object v23

    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asIntNum(Ljava/lang/Object;)Lgnu/math/IntNum;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Lgnu/math/IntNum;->times(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/IntNum;

    move-result-object v22

    .line 69
    goto :goto_1

    .line 71
    :pswitch_4
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asBigDecimal(Ljava/lang/Object;)Ljava/math/BigDecimal;

    move-result-object v2

    .line 72
    .local v2, "bd1":Ljava/math/BigDecimal;
    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asBigDecimal(Ljava/lang/Object;)Ljava/math/BigDecimal;

    move-result-object v3

    .line 73
    .local v3, "bd2":Ljava/math/BigDecimal;
    invoke-virtual {v2, v3}, Ljava/math/BigDecimal;->multiply(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v22

    .line 74
    goto :goto_1

    .line 76
    .end local v2    # "bd1":Ljava/math/BigDecimal;
    .end local v3    # "bd2":Ljava/math/BigDecimal;
    :pswitch_5
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asRatNum(Ljava/lang/Object;)Lgnu/math/RatNum;

    move-result-object v23

    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asRatNum(Ljava/lang/Object;)Lgnu/math/RatNum;

    move-result-object v24

    invoke-static/range {v23 .. v24}, Lgnu/math/RatNum;->times(Lgnu/math/RatNum;Lgnu/math/RatNum;)Lgnu/math/RatNum;

    move-result-object v22

    .line 78
    goto :goto_1

    .line 80
    :pswitch_6
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asFloat(Ljava/lang/Object;)F

    move-result v12

    .line 81
    .local v12, "f1":F
    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asFloat(Ljava/lang/Object;)F

    move-result v13

    .line 82
    .local v13, "f2":F
    new-instance v22, Ljava/lang/Float;

    .end local v22    # "result":Ljava/lang/Number;
    mul-float v23, v12, v13

    invoke-direct/range {v22 .. v23}, Ljava/lang/Float;-><init>(F)V

    .line 83
    .restart local v22    # "result":Ljava/lang/Number;
    goto :goto_1

    .line 85
    .end local v12    # "f1":F
    .end local v13    # "f2":F
    :pswitch_7
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v8

    .line 86
    .local v8, "d1":D
    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v10

    .line 87
    .local v10, "d2":D
    new-instance v22, Ljava/lang/Double;

    .end local v22    # "result":Ljava/lang/Number;
    mul-double v23, v8, v10

    invoke-direct/range {v22 .. v24}, Ljava/lang/Double;-><init>(D)V

    .line 88
    .restart local v22    # "result":Ljava/lang/Number;
    goto :goto_1

    .line 90
    .end local v8    # "d1":D
    .end local v10    # "d2":D
    :pswitch_8
    invoke-static/range {v22 .. v22}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v8

    .line 91
    .restart local v8    # "d1":D
    invoke-static {v1}, Lgnu/kawa/functions/Arithmetic;->asDouble(Ljava/lang/Object;)D

    move-result-wide v10

    .line 92
    .restart local v10    # "d2":D
    new-instance v22, Lgnu/math/DFloNum;

    .end local v22    # "result":Ljava/lang/Number;
    mul-double v23, v8, v10

    invoke-direct/range {v22 .. v24}, Lgnu/math/DFloNum;-><init>(D)V

    .line 93
    .restart local v22    # "result":Ljava/lang/Number;
    goto/16 :goto_1

    .line 49
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

.method public defaultResult()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 28
    invoke-static {}, Lgnu/math/IntNum;->one()Lgnu/math/IntNum;

    move-result-object v0

    return-object v0
.end method
