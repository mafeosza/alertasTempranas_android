.class public Lgnu/kawa/functions/IsEqual;
.super Lgnu/mapping/Procedure2;
.source "IsEqual.java"


# instance fields
.field language:Lgnu/expr/Language;


# direct methods
.method public constructor <init>(Lgnu/expr/Language;Ljava/lang/String;)V
    .locals 0
    .param p1, "language"    # Lgnu/expr/Language;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    invoke-direct {p0}, Lgnu/mapping/Procedure2;-><init>()V

    .line 14
    iput-object p1, p0, Lgnu/kawa/functions/IsEqual;->language:Lgnu/expr/Language;

    .line 15
    invoke-virtual {p0, p2}, Lgnu/kawa/functions/IsEqual;->setName(Ljava/lang/String;)V

    .line 16
    return-void
.end method

.method public static apply(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 18
    .param p0, "arg1"    # Ljava/lang/Object;
    .param p1, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 29
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    if-ne v0, v1, :cond_0

    .line 30
    const/16 v16, 0x1

    .line 129
    :goto_0
    return v16

    .line 31
    :cond_0
    if-eqz p0, :cond_1

    if-nez p1, :cond_2

    .line 32
    :cond_1
    const/16 v16, 0x0

    goto :goto_0

    .line 33
    :cond_2
    move-object/from16 v0, p0

    instance-of v0, v0, Ljava/lang/Number;

    move/from16 v16, v0

    if-eqz v16, :cond_3

    move-object/from16 v0, p1

    instance-of v0, v0, Ljava/lang/Number;

    move/from16 v16, v0

    if-eqz v16, :cond_3

    .line 34
    check-cast p0, Ljava/lang/Number;

    .end local p0    # "arg1":Ljava/lang/Object;
    check-cast p1, Ljava/lang/Number;

    .end local p1    # "arg2":Ljava/lang/Object;
    invoke-static/range {p0 .. p1}, Lgnu/kawa/functions/IsEqual;->numberEquals(Ljava/lang/Number;Ljava/lang/Number;)Z

    move-result v16

    goto :goto_0

    .line 38
    .restart local p0    # "arg1":Ljava/lang/Object;
    .restart local p1    # "arg2":Ljava/lang/Object;
    :cond_3
    move-object/from16 v0, p0

    instance-of v0, v0, Ljava/lang/CharSequence;

    move/from16 v16, v0

    if-eqz v16, :cond_8

    .line 40
    move-object/from16 v0, p1

    instance-of v0, v0, Ljava/lang/CharSequence;

    move/from16 v16, v0

    if-nez v16, :cond_4

    .line 41
    const/16 v16, 0x0

    goto :goto_0

    :cond_4
    move-object/from16 v10, p0

    .line 42
    check-cast v10, Ljava/lang/CharSequence;

    .local v10, "seq1":Ljava/lang/CharSequence;
    move-object/from16 v11, p1

    .line 43
    check-cast v11, Ljava/lang/CharSequence;

    .line 44
    .local v11, "seq2":Ljava/lang/CharSequence;
    invoke-interface {v10}, Ljava/lang/CharSequence;->length()I

    move-result v5

    .line 45
    .local v5, "len1":I
    invoke-interface {v11}, Ljava/lang/CharSequence;->length()I

    move-result v6

    .line 46
    .local v6, "len2":I
    if-eq v5, v6, :cond_5

    .line 47
    const/16 v16, 0x0

    goto :goto_0

    .line 48
    :cond_5
    move v4, v5

    .local v4, "i":I
    :cond_6
    add-int/lit8 v4, v4, -0x1

    if-ltz v4, :cond_7

    .line 50
    invoke-interface {v10, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v16

    invoke-interface {v11, v4}, Ljava/lang/CharSequence;->charAt(I)C

    move-result v17

    move/from16 v0, v16

    move/from16 v1, v17

    if-eq v0, v1, :cond_6

    .line 51
    const/16 v16, 0x0

    goto :goto_0

    .line 53
    :cond_7
    const/16 v16, 0x1

    goto :goto_0

    .line 87
    .end local v4    # "i":I
    .end local v5    # "len1":I
    .end local v6    # "len2":I
    .end local v10    # "seq1":Ljava/lang/CharSequence;
    .end local v11    # "seq2":Ljava/lang/CharSequence;
    :cond_8
    move-object/from16 v0, p0

    instance-of v0, v0, Lgnu/lists/FVector;

    move/from16 v16, v0

    if-eqz v16, :cond_e

    .line 89
    move-object/from16 v0, p1

    instance-of v0, v0, Lgnu/lists/FVector;

    move/from16 v16, v0

    if-nez v16, :cond_9

    .line 90
    const/16 v16, 0x0

    goto :goto_0

    :cond_9
    move-object/from16 v12, p0

    .line 91
    check-cast v12, Lgnu/lists/FVector;

    .local v12, "vec1":Lgnu/lists/FVector;
    move-object/from16 v13, p1

    .line 92
    check-cast v13, Lgnu/lists/FVector;

    .line 93
    .local v13, "vec2":Lgnu/lists/FVector;
    iget v7, v12, Lgnu/lists/FVector;->size:I

    .line 94
    .local v7, "n":I
    iget-object v0, v13, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    move-object/from16 v16, v0

    if-eqz v16, :cond_a

    iget v0, v13, Lgnu/lists/FVector;->size:I

    move/from16 v16, v0

    move/from16 v0, v16

    if-eq v0, v7, :cond_b

    .line 95
    :cond_a
    const/16 v16, 0x0

    goto/16 :goto_0

    .line 96
    :cond_b
    iget-object v2, v12, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 97
    .local v2, "data1":[Ljava/lang/Object;
    iget-object v3, v13, Lgnu/lists/FVector;->data:[Ljava/lang/Object;

    .line 98
    .local v3, "data2":[Ljava/lang/Object;
    move v4, v7

    .restart local v4    # "i":I
    :cond_c
    add-int/lit8 v4, v4, -0x1

    if-ltz v4, :cond_d

    .line 100
    aget-object v16, v2, v4

    aget-object v17, v3, v4

    invoke-static/range {v16 .. v17}, Lgnu/kawa/functions/IsEqual;->apply(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v16

    if-nez v16, :cond_c

    .line 101
    const/16 v16, 0x0

    goto/16 :goto_0

    .line 103
    :cond_d
    const/16 v16, 0x1

    goto/16 :goto_0

    .line 105
    .end local v2    # "data1":[Ljava/lang/Object;
    .end local v3    # "data2":[Ljava/lang/Object;
    .end local v4    # "i":I
    .end local v7    # "n":I
    .end local v12    # "vec1":Lgnu/lists/FVector;
    .end local v13    # "vec2":Lgnu/lists/FVector;
    :cond_e
    move-object/from16 v0, p0

    instance-of v0, v0, Lgnu/lists/LList;

    move/from16 v16, v0

    if-eqz v16, :cond_17

    .line 107
    move-object/from16 v0, p0

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v16, v0

    if-eqz v16, :cond_f

    move-object/from16 v0, p1

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v16, v0

    if-nez v16, :cond_10

    .line 108
    :cond_f
    const/16 v16, 0x0

    goto/16 :goto_0

    :cond_10
    move-object/from16 v8, p0

    .line 109
    check-cast v8, Lgnu/lists/Pair;

    .local v8, "pair1":Lgnu/lists/Pair;
    move-object/from16 v9, p1

    .line 110
    check-cast v9, Lgnu/lists/Pair;

    .line 113
    .local v9, "pair2":Lgnu/lists/Pair;
    :goto_1
    invoke-virtual {v8}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v14

    .line 114
    .local v14, "x1":Ljava/lang/Object;
    invoke-virtual {v9}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v15

    .line 115
    .local v15, "x2":Ljava/lang/Object;
    invoke-static {v14, v15}, Lgnu/kawa/functions/IsEqual;->apply(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v16

    if-nez v16, :cond_11

    .line 116
    const/16 v16, 0x0

    goto/16 :goto_0

    .line 117
    :cond_11
    invoke-virtual {v8}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v14

    .line 118
    invoke-virtual {v9}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v15

    .line 119
    if-ne v14, v15, :cond_12

    .line 120
    const/16 v16, 0x1

    goto/16 :goto_0

    .line 121
    :cond_12
    if-eqz v14, :cond_13

    if-nez v15, :cond_14

    .line 122
    :cond_13
    const/16 v16, 0x0

    goto/16 :goto_0

    .line 123
    :cond_14
    instance-of v0, v14, Lgnu/lists/Pair;

    move/from16 v16, v0

    if-eqz v16, :cond_15

    instance-of v0, v15, Lgnu/lists/Pair;

    move/from16 v16, v0

    if-nez v16, :cond_16

    .line 124
    :cond_15
    invoke-static {v14, v15}, Lgnu/kawa/functions/IsEqual;->apply(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v16

    goto/16 :goto_0

    :cond_16
    move-object v8, v14

    .line 125
    check-cast v8, Lgnu/lists/Pair;

    move-object v9, v15

    .line 126
    check-cast v9, Lgnu/lists/Pair;

    .line 127
    goto :goto_1

    .line 129
    .end local v8    # "pair1":Lgnu/lists/Pair;
    .end local v9    # "pair2":Lgnu/lists/Pair;
    .end local v14    # "x1":Ljava/lang/Object;
    .end local v15    # "x2":Ljava/lang/Object;
    :cond_17
    invoke-virtual/range {p0 .. p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v16

    goto/16 :goto_0
.end method

.method public static numberEquals(Ljava/lang/Number;Ljava/lang/Number;)Z
    .locals 3
    .param p0, "num1"    # Ljava/lang/Number;
    .param p1, "num2"    # Ljava/lang/Number;

    .prologue
    .line 20
    invoke-static {p0}, Lgnu/kawa/functions/Arithmetic;->isExact(Ljava/lang/Number;)Z

    move-result v0

    .line 21
    .local v0, "exact1":Z
    invoke-static {p1}, Lgnu/kawa/functions/Arithmetic;->isExact(Ljava/lang/Number;)Z

    move-result v1

    .line 22
    .local v1, "exact2":Z
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    .line 23
    invoke-static {p0, p1}, Lgnu/kawa/functions/NumberCompare;->$Eq(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    .line 24
    :goto_0
    return v2

    :cond_0
    if-ne v0, v1, :cond_1

    invoke-virtual {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    const/4 v2, 0x1

    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 134
    iget-object v0, p0, Lgnu/kawa/functions/IsEqual;->language:Lgnu/expr/Language;

    invoke-static {p1, p2}, Lgnu/kawa/functions/IsEqual;->apply(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lgnu/expr/Language;->booleanObject(Z)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method
