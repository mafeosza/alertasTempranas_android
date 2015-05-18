.class public Lgnu/kawa/lispexpr/LispReader;
.super Lgnu/text/Lexer;
.source "LispReader.java"


# static fields
.field static final SCM_COMPLEX:I = 0x1

.field public static final SCM_NUMBERS:I = 0x1

.field public static final TOKEN_ESCAPE_CHAR:C = '\uffff'


# instance fields
.field protected seenEscapes:Z

.field sharedStructureTable:Lgnu/kawa/util/GeneralHashTable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lgnu/kawa/util/GeneralHashTable",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lgnu/text/LineBufferedReader;)V
    .locals 0
    .param p1, "port"    # Lgnu/text/LineBufferedReader;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lgnu/text/Lexer;-><init>(Lgnu/text/LineBufferedReader;)V

    .line 21
    return-void
.end method

.method public constructor <init>(Lgnu/text/LineBufferedReader;Lgnu/text/SourceMessages;)V
    .locals 0
    .param p1, "port"    # Lgnu/text/LineBufferedReader;
    .param p2, "messages"    # Lgnu/text/SourceMessages;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lgnu/text/Lexer;-><init>(Lgnu/text/LineBufferedReader;Lgnu/text/SourceMessages;)V

    .line 26
    return-void
.end method

.method static getReadCase()C
    .locals 6

    .prologue
    .line 73
    :try_start_0
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v3

    const-string v4, "symbol-read-case"

    const-string v5, "P"

    invoke-virtual {v3, v4, v5}, Lgnu/mapping/Environment;->get(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 75
    .local v2, "read_case_string":Ljava/lang/String;
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Ljava/lang/String;->charAt(I)C
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 76
    .local v1, "read_case":C
    const/16 v3, 0x50

    if-ne v1, v3, :cond_1

    .line 88
    :cond_0
    :goto_0
    return v1

    .line 77
    :cond_1
    const/16 v3, 0x75

    if-ne v1, v3, :cond_2

    .line 78
    const/16 v1, 0x55

    goto :goto_0

    .line 79
    :cond_2
    const/16 v3, 0x64

    if-eq v1, v3, :cond_3

    const/16 v3, 0x6c

    if-eq v1, v3, :cond_3

    const/16 v3, 0x4c

    if-ne v1, v3, :cond_4

    .line 80
    :cond_3
    const/16 v1, 0x44

    goto :goto_0

    .line 81
    :cond_4
    const/16 v3, 0x69

    if-ne v1, v3, :cond_0

    .line 82
    const/16 v1, 0x49

    goto :goto_0

    .line 84
    .end local v1    # "read_case":C
    :catch_0
    move-exception v0

    .line 86
    .local v0, "ex":Ljava/lang/Exception;
    const/16 v1, 0x50

    .restart local v1    # "read_case":C
    goto :goto_0
.end method

.method private isPotentialNumber([CII)Z
    .locals 6
    .param p1, "buffer"    # [C
    .param p2, "start"    # I
    .param p3, "end"    # I

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 436
    const/4 v2, 0x0

    .line 437
    .local v2, "sawDigits":I
    move v1, p2

    .local v1, "i":I
    :goto_0
    if-ge v1, p3, :cond_7

    .line 439
    aget-char v0, p1, v1

    .line 440
    .local v0, "ch":C
    invoke-static {v0}, Ljava/lang/Character;->isDigit(C)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 441
    add-int/lit8 v2, v2, 0x1

    .line 437
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 442
    :cond_1
    const/16 v5, 0x2d

    if-eq v0, v5, :cond_2

    const/16 v5, 0x2b

    if-ne v0, v5, :cond_3

    .line 444
    :cond_2
    add-int/lit8 v5, v1, 0x1

    if-ne v5, p3, :cond_0

    .line 461
    .end local v0    # "ch":C
    :goto_1
    return v4

    .line 447
    .restart local v0    # "ch":C
    :cond_3
    const/16 v5, 0x23

    if-ne v0, v5, :cond_4

    move v4, v3

    .line 448
    goto :goto_1

    .line 449
    :cond_4
    invoke-static {v0}, Ljava/lang/Character;->isLetter(C)Z

    move-result v5

    if-nez v5, :cond_5

    const/16 v5, 0x2f

    if-eq v0, v5, :cond_5

    const/16 v5, 0x5f

    if-eq v0, v5, :cond_5

    const/16 v5, 0x5e

    if-ne v0, v5, :cond_6

    .line 455
    :cond_5
    if-ne v1, p2, :cond_0

    goto :goto_1

    .line 458
    :cond_6
    const/16 v5, 0x2e

    if-eq v0, v5, :cond_0

    goto :goto_1

    .line 461
    .end local v0    # "ch":C
    :cond_7
    if-lez v2, :cond_8

    :goto_2
    move v4, v3

    goto :goto_1

    :cond_8
    move v3, v4

    goto :goto_2
.end method

.method public static parseNumber(Ljava/lang/CharSequence;I)Ljava/lang/Object;
    .locals 6
    .param p0, "str"    # Ljava/lang/CharSequence;
    .param p1, "radix"    # I

    .prologue
    const/4 v1, 0x0

    .line 475
    instance-of v3, p0, Lgnu/lists/FString;

    if-eqz v3, :cond_0

    move-object v3, p0

    .line 476
    check-cast v3, Lgnu/lists/FString;

    iget-object v0, v3, Lgnu/lists/FString;->data:[C

    .line 479
    .local v0, "buf":[C
    :goto_0
    invoke-interface {p0}, Ljava/lang/CharSequence;->length()I

    move-result v2

    .line 480
    .local v2, "len":I
    const/4 v5, 0x1

    move v3, v1

    move v4, p1

    invoke-static/range {v0 .. v5}, Lgnu/kawa/lispexpr/LispReader;->parseNumber([CIICII)Ljava/lang/Object;

    move-result-object v1

    return-object v1

    .line 478
    .end local v0    # "buf":[C
    .end local v2    # "len":I
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toCharArray()[C

    move-result-object v0

    .restart local v0    # "buf":[C
    goto :goto_0
.end method

.method public static parseNumber([CIICII)Ljava/lang/Object;
    .locals 53
    .param p0, "buffer"    # [C
    .param p1, "start"    # I
    .param p2, "count"    # I
    .param p3, "exactness"    # C
    .param p4, "radix"    # I
    .param p5, "flags"    # I

    .prologue
    .line 498
    add-int v25, p1, p2

    .line 499
    .local v25, "end":I
    move/from16 v11, p1

    .line 500
    .local v11, "pos":I
    move/from16 v0, v25

    if-lt v11, v0, :cond_1

    .line 501
    const-string v16, "no digits"

    .line 887
    :cond_0
    :goto_0
    return-object v16

    .line 502
    :cond_1
    add-int/lit8 v42, v11, 0x1

    .end local v11    # "pos":I
    .local v42, "pos":I
    aget-char v17, p0, v11

    .line 503
    .local v17, "ch":C
    :goto_1
    const/16 v3, 0x23

    move/from16 v0, v17

    if-ne v0, v3, :cond_11

    .line 505
    move/from16 v0, v42

    move/from16 v1, v25

    if-lt v0, v1, :cond_2

    .line 506
    const-string v16, "no digits"

    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto :goto_0

    .line 507
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    :cond_2
    add-int/lit8 v11, v42, 0x1

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    aget-char v17, p0, v42

    .line 508
    sparse-switch v17, :sswitch_data_0

    .line 542
    const/16 v52, 0x0

    .line 545
    .local v52, "value":I
    :goto_2
    const/16 v3, 0xa

    move/from16 v0, v17

    invoke-static {v0, v3}, Ljava/lang/Character;->digit(CI)I

    move-result v23

    .line 546
    .local v23, "dig":I
    if-gez v23, :cond_a

    .line 553
    const/16 v3, 0x52

    move/from16 v0, v17

    if-eq v0, v3, :cond_3

    const/16 v3, 0x72

    move/from16 v0, v17

    if-ne v0, v3, :cond_f

    .line 555
    :cond_3
    if-eqz p4, :cond_c

    .line 556
    const-string v16, "duplicate radix specifier"

    goto :goto_0

    .line 511
    .end local v23    # "dig":I
    .end local v52    # "value":I
    :sswitch_0
    if-eqz p4, :cond_4

    .line 512
    const-string v16, "duplicate radix specifier"

    goto :goto_0

    .line 513
    :cond_4
    const/16 p4, 0x2

    move/from16 v42, v11

    .line 564
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    :goto_3
    move/from16 v0, v42

    move/from16 v1, v25

    if-lt v0, v1, :cond_10

    .line 565
    const-string v16, "no digits"

    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto :goto_0

    .line 516
    :sswitch_1
    if-eqz p4, :cond_5

    .line 517
    const-string v16, "duplicate radix specifier"

    goto :goto_0

    .line 518
    :cond_5
    const/16 p4, 0x8

    move/from16 v42, v11

    .line 519
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    goto :goto_3

    .line 521
    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    :sswitch_2
    if-eqz p4, :cond_6

    .line 522
    const-string v16, "duplicate radix specifier"

    goto :goto_0

    .line 523
    :cond_6
    const/16 p4, 0xa

    move/from16 v42, v11

    .line 524
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    goto :goto_3

    .line 526
    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    :sswitch_3
    if-eqz p4, :cond_7

    .line 527
    const-string v16, "duplicate radix specifier"

    goto :goto_0

    .line 528
    :cond_7
    const/16 p4, 0x10

    move/from16 v42, v11

    .line 529
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    goto :goto_3

    .line 532
    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    :sswitch_4
    if-eqz p3, :cond_9

    .line 534
    const/16 v3, 0x20

    move/from16 v0, p3

    if-ne v0, v3, :cond_8

    .line 535
    const-string v16, "non-prefix exactness specifier"

    goto :goto_0

    .line 537
    :cond_8
    const-string v16, "duplicate exactness specifier"

    goto :goto_0

    .line 539
    :cond_9
    move/from16 p3, v17

    move/from16 v42, v11

    .line 540
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    goto :goto_3

    .line 548
    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    .restart local v23    # "dig":I
    .restart local v52    # "value":I
    :cond_a
    mul-int/lit8 v3, v52, 0xa

    add-int v52, v3, v23

    .line 549
    move/from16 v0, v25

    if-lt v11, v0, :cond_b

    .line 550
    const-string v16, "missing letter after \'#\'"

    goto/16 :goto_0

    .line 551
    :cond_b
    add-int/lit8 v42, v11, 0x1

    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    aget-char v17, p0, v11

    move/from16 v11, v42

    .line 552
    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto :goto_2

    .line 557
    :cond_c
    const/4 v3, 0x2

    move/from16 v0, v52

    if-lt v0, v3, :cond_d

    const/16 v3, 0x23

    move/from16 v0, v52

    if-le v0, v3, :cond_e

    .line 558
    :cond_d
    const-string v16, "invalid radix specifier"

    goto/16 :goto_0

    .line 559
    :cond_e
    move/from16 p4, v52

    move/from16 v42, v11

    .line 560
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    goto :goto_3

    .line 562
    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    :cond_f
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "unknown modifier \'#"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move/from16 v0, v17

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v5, 0x27

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    goto/16 :goto_0

    .line 566
    .end local v11    # "pos":I
    .end local v23    # "dig":I
    .end local v52    # "value":I
    .restart local v42    # "pos":I
    :cond_10
    add-int/lit8 v11, v42, 0x1

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    aget-char v17, p0, v42

    move/from16 v42, v11

    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    goto/16 :goto_1

    .line 568
    :cond_11
    if-nez p3, :cond_12

    .line 569
    const/16 p3, 0x20

    .line 570
    :cond_12
    if-nez p4, :cond_14

    .line 572
    move/from16 v30, p2

    .line 574
    .local v30, "i":I
    :cond_13
    add-int/lit8 v30, v30, -0x1

    if-gez v30, :cond_16

    .line 578
    const/16 p4, 0xa

    .line 589
    .end local v30    # "i":I
    :cond_14
    :goto_4
    const/16 v3, 0x2d

    move/from16 v0, v17

    if-ne v0, v3, :cond_17

    const/4 v7, 0x1

    .line 590
    .local v7, "negative":Z
    :goto_5
    move/from16 v40, v7

    .line 591
    .local v40, "numeratorNegative":Z
    const/16 v3, 0x2d

    move/from16 v0, v17

    if-eq v0, v3, :cond_15

    const/16 v3, 0x2b

    move/from16 v0, v17

    if-ne v0, v3, :cond_18

    :cond_15
    const/16 v49, 0x1

    .line 592
    .local v49, "sign_seen":Z
    :goto_6
    if-eqz v49, :cond_5f

    .line 594
    move/from16 v0, v42

    move/from16 v1, v25

    if-lt v0, v1, :cond_19

    .line 595
    const-string v16, "no digits following sign"

    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto/16 :goto_0

    .line 581
    .end local v7    # "negative":Z
    .end local v11    # "pos":I
    .end local v40    # "numeratorNegative":Z
    .end local v49    # "sign_seen":Z
    .restart local v30    # "i":I
    .restart local v42    # "pos":I
    :cond_16
    add-int v3, p1, v30

    aget-char v3, p0, v3

    const/16 v5, 0x2e

    if-ne v3, v5, :cond_13

    .line 583
    const/16 p4, 0xa

    .line 584
    goto :goto_4

    .line 589
    .end local v30    # "i":I
    :cond_17
    const/4 v7, 0x0

    goto :goto_5

    .line 591
    .restart local v7    # "negative":Z
    .restart local v40    # "numeratorNegative":Z
    :cond_18
    const/16 v49, 0x0

    goto :goto_6

    .line 596
    .restart local v49    # "sign_seen":Z
    :cond_19
    add-int/lit8 v11, v42, 0x1

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    aget-char v17, p0, v42

    .line 600
    :goto_7
    const/16 v3, 0x69

    move/from16 v0, v17

    if-eq v0, v3, :cond_1a

    const/16 v3, 0x49

    move/from16 v0, v17

    if-ne v0, v3, :cond_20

    :cond_1a
    move/from16 v0, v25

    if-ne v11, v0, :cond_20

    add-int/lit8 v3, v11, -0x2

    move/from16 v0, p1

    if-ne v0, v3, :cond_20

    and-int/lit8 v3, p5, 0x1

    if-eqz v3, :cond_20

    .line 603
    aget-char v48, p0, p1

    .line 604
    .local v48, "sign":C
    const/16 v3, 0x2b

    move/from16 v0, v48

    if-eq v0, v3, :cond_1b

    const/16 v3, 0x2d

    move/from16 v0, v48

    if-eq v0, v3, :cond_1b

    .line 605
    const-string v16, "no digits"

    goto/16 :goto_0

    .line 606
    :cond_1b
    const/16 v3, 0x69

    move/from16 v0, p3

    if-eq v0, v3, :cond_1c

    const/16 v3, 0x49

    move/from16 v0, p3

    if-ne v0, v3, :cond_1e

    .line 607
    :cond_1c
    new-instance v16, Lgnu/math/DComplex;

    const-wide/16 v12, 0x0

    if-eqz v7, :cond_1d

    const-wide/high16 v5, -0x4010000000000000L    # -1.0

    :goto_8
    move-object/from16 v0, v16

    invoke-direct {v0, v12, v13, v5, v6}, Lgnu/math/DComplex;-><init>(DD)V

    goto/16 :goto_0

    :cond_1d
    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    goto :goto_8

    .line 608
    :cond_1e
    if-eqz v7, :cond_1f

    invoke-static {}, Lgnu/math/Complex;->imMinusOne()Lgnu/math/CComplex;

    move-result-object v3

    :goto_9
    move-object/from16 v16, v3

    goto/16 :goto_0

    :cond_1f
    invoke-static {}, Lgnu/math/Complex;->imOne()Lgnu/math/CComplex;

    move-result-object v3

    goto :goto_9

    .line 611
    .end local v48    # "sign":C
    :cond_20
    add-int/lit8 v47, v11, -0x1

    .line 612
    .local v47, "realStart":I
    const/16 v29, 0x0

    .line 613
    .local v29, "hash_seen":Z
    const/16 v28, -0x1

    .line 614
    .local v28, "exp_seen":I
    const/4 v4, -0x1

    .line 615
    .local v4, "digits_start":I
    const/16 v22, -0x1

    .line 616
    .local v22, "decimal_point":I
    const/16 v19, 0x0

    .line 617
    .local v19, "copy_needed":Z
    const/16 v51, 0x0

    .line 618
    .local v51, "underscore_seen":Z
    const/16 v39, 0x0

    .line 619
    .local v39, "numerator":Lgnu/math/IntNum;
    const-wide/16 v8, 0x0

    .line 623
    .local v8, "lvalue":J
    :goto_a
    move/from16 v0, v17

    move/from16 v1, p4

    invoke-static {v0, v1}, Ljava/lang/Character;->digit(CI)I

    move-result v24

    .line 624
    .local v24, "digit":I
    if-ltz v24, :cond_25

    .line 626
    if-eqz v29, :cond_21

    if-gez v22, :cond_21

    .line 627
    const-string v16, "digit after \'#\' in number"

    goto/16 :goto_0

    .line 628
    :cond_21
    if-gez v4, :cond_22

    .line 629
    add-int/lit8 v4, v11, -0x1

    .line 630
    :cond_22
    move/from16 v0, p4

    int-to-long v5, v0

    mul-long/2addr v5, v8

    move/from16 v0, v24

    int-to-long v12, v0

    add-long v8, v5, v12

    .line 710
    :goto_b
    move/from16 v0, v25

    if-ne v11, v0, :cond_36

    .line 715
    :cond_23
    :goto_c
    const/16 v33, 0x0

    .line 717
    .local v33, "infnan":C
    if-gez v4, :cond_5e

    .line 719
    if-eqz v49, :cond_24

    add-int/lit8 v3, v11, 0x4

    move/from16 v0, v25

    if-ge v3, v0, :cond_24

    add-int/lit8 v3, v11, 0x3

    aget-char v3, p0, v3

    const/16 v5, 0x2e

    if-ne v3, v5, :cond_24

    add-int/lit8 v3, v11, 0x4

    aget-char v3, p0, v3

    const/16 v5, 0x30

    if-ne v3, v5, :cond_24

    .line 722
    aget-char v3, p0, v11

    const/16 v5, 0x69

    if-ne v3, v5, :cond_37

    add-int/lit8 v3, v11, 0x1

    aget-char v3, p0, v3

    const/16 v5, 0x6e

    if-ne v3, v5, :cond_37

    add-int/lit8 v3, v11, 0x2

    aget-char v3, p0, v3

    const/16 v5, 0x66

    if-ne v3, v5, :cond_37

    .line 726
    const/16 v33, 0x69

    .line 735
    :cond_24
    :goto_d
    if-nez v33, :cond_38

    .line 736
    const-string v16, "no digits"

    goto/16 :goto_0

    .line 634
    .end local v33    # "infnan":C
    :cond_25
    sparse-switch v17, :sswitch_data_1

    .line 706
    add-int/lit8 v11, v11, -0x1

    .line 707
    goto :goto_c

    .line 651
    :sswitch_5
    if-ltz v22, :cond_26

    .line 652
    const-string v16, "duplicate \'.\' in number"

    goto/16 :goto_0

    .line 653
    :cond_26
    const/16 v3, 0xa

    move/from16 v0, p4

    if-eq v0, v3, :cond_27

    .line 654
    const-string v16, "\'.\' in non-decimal number"

    goto/16 :goto_0

    .line 655
    :cond_27
    add-int/lit8 v22, v11, -0x1

    .line 656
    goto :goto_b

    .line 659
    :sswitch_6
    move/from16 v0, v25

    if-eq v11, v0, :cond_28

    const/16 v3, 0xa

    move/from16 v0, p4

    if-eq v0, v3, :cond_29

    .line 661
    :cond_28
    add-int/lit8 v11, v11, -0x1

    .line 662
    goto :goto_c

    .line 664
    :cond_29
    aget-char v36, p0, v11

    .line 665
    .local v36, "next":C
    add-int/lit8 v27, v11, -0x1

    .line 666
    .local v27, "exp_pos":I
    const/16 v3, 0x2b

    move/from16 v0, v36

    if-eq v0, v3, :cond_2a

    const/16 v3, 0x2d

    move/from16 v0, v36

    if-ne v0, v3, :cond_2c

    .line 668
    :cond_2a
    add-int/lit8 v11, v11, 0x1

    move/from16 v0, v25

    if-ge v11, v0, :cond_2b

    aget-char v3, p0, v11

    const/16 v5, 0xa

    invoke-static {v3, v5}, Ljava/lang/Character;->digit(CI)I

    move-result v3

    if-gez v3, :cond_2d

    .line 670
    :cond_2b
    const-string v16, "missing exponent digits"

    goto/16 :goto_0

    .line 672
    :cond_2c
    const/16 v3, 0xa

    move/from16 v0, v36

    invoke-static {v0, v3}, Ljava/lang/Character;->digit(CI)I

    move-result v3

    if-gez v3, :cond_2d

    .line 674
    add-int/lit8 v11, v11, -0x1

    .line 675
    goto/16 :goto_c

    .line 677
    :cond_2d
    if-ltz v28, :cond_2e

    .line 678
    const-string v16, "duplicate exponent"

    goto/16 :goto_0

    .line 679
    :cond_2e
    const/16 v3, 0xa

    move/from16 v0, p4

    if-eq v0, v3, :cond_2f

    .line 680
    const-string v16, "exponent in non-decimal number"

    goto/16 :goto_0

    .line 681
    :cond_2f
    if-gez v4, :cond_30

    .line 682
    const-string v16, "mantissa with no digits"

    goto/16 :goto_0

    .line 683
    :cond_30
    move/from16 v28, v27

    .line 686
    :cond_31
    add-int/lit8 v11, v11, 0x1

    .line 687
    move/from16 v0, v25

    if-ge v11, v0, :cond_23

    aget-char v3, p0, v11

    const/16 v5, 0xa

    invoke-static {v3, v5}, Ljava/lang/Character;->digit(CI)I

    move-result v3

    if-gez v3, :cond_31

    goto/16 :goto_c

    .line 691
    .end local v27    # "exp_pos":I
    .end local v36    # "next":C
    :sswitch_7
    if-eqz v39, :cond_32

    .line 692
    const-string v16, "multiple fraction symbol \'/\'"

    goto/16 :goto_0

    .line 693
    :cond_32
    if-gez v4, :cond_33

    .line 694
    const-string v16, "no digits before fraction symbol \'/\'"

    goto/16 :goto_0

    .line 695
    :cond_33
    if-gez v28, :cond_34

    if-ltz v22, :cond_35

    .line 696
    :cond_34
    const-string v16, "fraction symbol \'/\' following exponent or \'.\'"

    goto/16 :goto_0

    .line 697
    :cond_35
    sub-int v5, v11, v4

    move-object/from16 v3, p0

    move/from16 v6, p4

    invoke-static/range {v3 .. v9}, Lgnu/kawa/lispexpr/LispReader;->valueOf([CIIIZJ)Lgnu/math/IntNum;

    move-result-object v39

    .line 699
    const/4 v4, -0x1

    .line 700
    const-wide/16 v8, 0x0

    .line 701
    const/4 v7, 0x0

    .line 702
    const/16 v29, 0x0

    .line 703
    const/16 v51, 0x0

    .line 704
    goto/16 :goto_b

    .line 712
    :cond_36
    add-int/lit8 v42, v11, 0x1

    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    aget-char v17, p0, v11

    move/from16 v11, v42

    .line 713
    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto/16 :goto_a

    .line 728
    .restart local v33    # "infnan":C
    :cond_37
    aget-char v3, p0, v11

    const/16 v5, 0x6e

    if-ne v3, v5, :cond_24

    add-int/lit8 v3, v11, 0x1

    aget-char v3, p0, v3

    const/16 v5, 0x61

    if-ne v3, v5, :cond_24

    add-int/lit8 v3, v11, 0x2

    aget-char v3, p0, v3

    const/16 v5, 0x6e

    if-ne v3, v5, :cond_24

    .line 732
    const/16 v33, 0x6e

    goto/16 :goto_d

    .line 737
    :cond_38
    add-int/lit8 v11, v11, 0x5

    move/from16 v42, v11

    .line 740
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    :goto_e
    if-nez v29, :cond_39

    if-eqz v51, :cond_39

    .line 745
    :cond_39
    const/16 v3, 0x69

    move/from16 v0, p3

    if-eq v0, v3, :cond_3a

    const/16 v3, 0x49

    move/from16 v0, p3

    if-eq v0, v3, :cond_3a

    const/16 v3, 0x20

    move/from16 v0, p3

    if-ne v0, v3, :cond_3e

    if-eqz v29, :cond_3e

    :cond_3a
    const/16 v32, 0x1

    .line 747
    .local v32, "inexact":Z
    :goto_f
    const/16 v37, 0x0

    .line 748
    .local v37, "number":Lgnu/math/RealNum;
    const/16 v26, 0x0

    .line 749
    .local v26, "exp_char":C
    if-eqz v33, :cond_40

    .line 751
    const/16 v32, 0x1

    .line 752
    const/16 v3, 0x69

    move/from16 v0, v33

    if-ne v0, v3, :cond_3f

    const-wide/high16 v20, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    .line 753
    .local v20, "d":D
    :goto_10
    new-instance v37, Lgnu/math/DFloNum;

    .end local v37    # "number":Lgnu/math/RealNum;
    if-eqz v7, :cond_3b

    move-wide/from16 v0, v20

    neg-double v0, v0

    move-wide/from16 v20, v0

    .end local v20    # "d":D
    :cond_3b
    move-object/from16 v0, v37

    move-wide/from16 v1, v20

    invoke-direct {v0, v1, v2}, Lgnu/math/DFloNum;-><init>(D)V

    .line 807
    .restart local v37    # "number":Lgnu/math/RealNum;
    :goto_11
    const/16 v3, 0x65

    move/from16 v0, p3

    if-eq v0, v3, :cond_3c

    const/16 v3, 0x45

    move/from16 v0, p3

    if-ne v0, v3, :cond_3d

    .line 808
    :cond_3c
    invoke-virtual/range {v37 .. v37}, Lgnu/math/RealNum;->toExact()Lgnu/math/RatNum;

    move-result-object v37

    .line 810
    :cond_3d
    move/from16 v0, v42

    move/from16 v1, v25

    if-ge v0, v1, :cond_5b

    .line 812
    add-int/lit8 v11, v42, 0x1

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    aget-char v17, p0, v42

    .line 814
    const/16 v3, 0x40

    move/from16 v0, v17

    if-ne v0, v3, :cond_50

    .line 816
    sub-int v12, v25, v11

    const/16 v14, 0xa

    move-object/from16 v10, p0

    move/from16 v13, p3

    move/from16 v15, p5

    invoke-static/range {v10 .. v15}, Lgnu/kawa/lispexpr/LispReader;->parseNumber([CIICII)Ljava/lang/Object;

    move-result-object v16

    .line 818
    .local v16, "angle":Ljava/lang/Object;
    move-object/from16 v0, v16

    instance-of v3, v0, Ljava/lang/String;

    if-nez v3, :cond_0

    .line 820
    move-object/from16 v0, v16

    instance-of v3, v0, Lgnu/math/RealNum;

    if-nez v3, :cond_4e

    .line 821
    const-string v16, "invalid complex polar constant"

    goto/16 :goto_0

    .line 745
    .end local v11    # "pos":I
    .end local v16    # "angle":Ljava/lang/Object;
    .end local v26    # "exp_char":C
    .end local v32    # "inexact":Z
    .end local v37    # "number":Lgnu/math/RealNum;
    .restart local v42    # "pos":I
    :cond_3e
    const/16 v32, 0x0

    goto :goto_f

    .line 752
    .restart local v26    # "exp_char":C
    .restart local v32    # "inexact":Z
    .restart local v37    # "number":Lgnu/math/RealNum;
    :cond_3f
    const-wide/high16 v20, 0x7ff8000000000000L    # NaN

    goto :goto_10

    .line 755
    :cond_40
    if-gez v28, :cond_41

    if-ltz v22, :cond_46

    .line 757
    :cond_41
    move/from16 v0, v22

    if-le v4, v0, :cond_42

    if-ltz v22, :cond_42

    .line 758
    move/from16 v4, v22

    .line 759
    :cond_42
    if-eqz v39, :cond_43

    .line 760
    const-string v16, "floating-point number after fraction symbol \'/\'"

    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto/16 :goto_0

    .line 761
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    :cond_43
    new-instance v50, Ljava/lang/String;

    sub-int v3, v42, v4

    move-object/from16 v0, v50

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v4, v3}, Ljava/lang/String;-><init>([CII)V

    .line 762
    .local v50, "str":Ljava/lang/String;
    if-ltz v28, :cond_44

    .line 764
    aget-char v3, p0, v28

    invoke-static {v3}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v26

    .line 765
    const/16 v3, 0x65

    move/from16 v0, v26

    if-eq v0, v3, :cond_44

    .line 767
    sub-int v43, v28, v4

    .line 768
    .local v43, "prefix":I
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v5, 0x0

    move-object/from16 v0, v50

    move/from16 v1, v43

    invoke-virtual {v0, v5, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const/16 v5, 0x65

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    add-int/lit8 v5, v43, 0x1

    move-object/from16 v0, v50

    invoke-virtual {v0, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v50

    .line 771
    .end local v43    # "prefix":I
    :cond_44
    invoke-static/range {v50 .. v50}, Lgnu/lists/Convert;->parseDouble(Ljava/lang/String;)D

    move-result-wide v20

    .line 772
    .restart local v20    # "d":D
    new-instance v37, Lgnu/math/DFloNum;

    .end local v37    # "number":Lgnu/math/RealNum;
    if-eqz v7, :cond_45

    move-wide/from16 v0, v20

    neg-double v0, v0

    move-wide/from16 v20, v0

    .end local v20    # "d":D
    :cond_45
    move-object/from16 v0, v37

    move-wide/from16 v1, v20

    invoke-direct {v0, v1, v2}, Lgnu/math/DFloNum;-><init>(D)V

    .line 773
    .restart local v37    # "number":Lgnu/math/RealNum;
    goto/16 :goto_11

    .line 776
    .end local v50    # "str":Ljava/lang/String;
    :cond_46
    sub-int v5, v42, v4

    move-object/from16 v3, p0

    move/from16 v6, p4

    invoke-static/range {v3 .. v9}, Lgnu/kawa/lispexpr/LispReader;->valueOf([CIIIZJ)Lgnu/math/IntNum;

    move-result-object v34

    .line 778
    .local v34, "iresult":Lgnu/math/IntNum;
    if-nez v39, :cond_47

    .line 779
    move-object/from16 v37, v34

    move-object/from16 v38, v37

    .line 801
    .end local v37    # "number":Lgnu/math/RealNum;
    .local v38, "number":Lgnu/math/RealNum;
    :goto_12
    if-eqz v32, :cond_5d

    invoke-virtual/range {v38 .. v38}, Lgnu/math/RealNum;->isExact()Z

    move-result v3

    if-eqz v3, :cond_5d

    .line 803
    new-instance v37, Lgnu/math/DFloNum;

    if-eqz v40, :cond_4d

    invoke-virtual/range {v38 .. v38}, Lgnu/math/RealNum;->isZero()Z

    move-result v3

    if-eqz v3, :cond_4d

    const-wide/high16 v5, -0x8000000000000000L

    :goto_13
    move-object/from16 v0, v37

    invoke-direct {v0, v5, v6}, Lgnu/math/DFloNum;-><init>(D)V

    .end local v38    # "number":Lgnu/math/RealNum;
    .restart local v37    # "number":Lgnu/math/RealNum;
    goto/16 :goto_11

    .line 784
    :cond_47
    invoke-virtual/range {v34 .. v34}, Lgnu/math/IntNum;->isZero()Z

    move-result v3

    if-eqz v3, :cond_4c

    .line 786
    invoke-virtual/range {v39 .. v39}, Lgnu/math/IntNum;->isZero()Z

    move-result v41

    .line 787
    .local v41, "numeratorZero":Z
    if-eqz v32, :cond_4a

    .line 788
    new-instance v37, Lgnu/math/DFloNum;

    .end local v37    # "number":Lgnu/math/RealNum;
    if-eqz v41, :cond_48

    const-wide/high16 v5, 0x7ff8000000000000L    # NaN

    :goto_14
    move-object/from16 v0, v37

    invoke-direct {v0, v5, v6}, Lgnu/math/DFloNum;-><init>(D)V

    .restart local v37    # "number":Lgnu/math/RealNum;
    :goto_15
    move-object/from16 v38, v37

    .line 795
    .end local v37    # "number":Lgnu/math/RealNum;
    .restart local v38    # "number":Lgnu/math/RealNum;
    goto :goto_12

    .line 788
    .end local v38    # "number":Lgnu/math/RealNum;
    :cond_48
    if-eqz v40, :cond_49

    const-wide/high16 v5, -0x10000000000000L    # Double.NEGATIVE_INFINITY

    goto :goto_14

    :cond_49
    const-wide/high16 v5, 0x7ff0000000000000L    # Double.POSITIVE_INFINITY

    goto :goto_14

    .line 791
    .restart local v37    # "number":Lgnu/math/RealNum;
    :cond_4a
    if-eqz v41, :cond_4b

    .line 792
    const-string v16, "0/0 is undefined"

    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto/16 :goto_0

    .line 794
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    :cond_4b
    move-object/from16 v0, v39

    move-object/from16 v1, v34

    invoke-static {v0, v1}, Lgnu/math/RatNum;->make(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/RatNum;

    move-result-object v37

    goto :goto_15

    .line 798
    .end local v41    # "numeratorZero":Z
    :cond_4c
    move-object/from16 v0, v39

    move-object/from16 v1, v34

    invoke-static {v0, v1}, Lgnu/math/RatNum;->make(Lgnu/math/IntNum;Lgnu/math/IntNum;)Lgnu/math/RatNum;

    move-result-object v37

    move-object/from16 v38, v37

    .end local v37    # "number":Lgnu/math/RealNum;
    .restart local v38    # "number":Lgnu/math/RealNum;
    goto :goto_12

    .line 803
    :cond_4d
    invoke-virtual/range {v38 .. v38}, Lgnu/math/RealNum;->doubleValue()D

    move-result-wide v5

    goto :goto_13

    .end local v34    # "iresult":Lgnu/math/IntNum;
    .end local v38    # "number":Lgnu/math/RealNum;
    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    .restart local v16    # "angle":Ljava/lang/Object;
    .restart local v37    # "number":Lgnu/math/RealNum;
    :cond_4e
    move-object/from16 v45, v16

    .line 822
    check-cast v45, Lgnu/math/RealNum;

    .line 825
    .local v45, "rangle":Lgnu/math/RealNum;
    invoke-virtual/range {v37 .. v37}, Lgnu/math/RealNum;->isZero()Z

    move-result v3

    if-eqz v3, :cond_4f

    invoke-virtual/range {v45 .. v45}, Lgnu/math/RealNum;->isExact()Z

    move-result v3

    if-nez v3, :cond_4f

    .line 826
    new-instance v16, Lgnu/math/DFloNum;

    .end local v16    # "angle":Ljava/lang/Object;
    const-wide/16 v5, 0x0

    move-object/from16 v0, v16

    invoke-direct {v0, v5, v6}, Lgnu/math/DFloNum;-><init>(D)V

    goto/16 :goto_0

    .line 828
    .restart local v16    # "angle":Ljava/lang/Object;
    :cond_4f
    move-object/from16 v0, v37

    move-object/from16 v1, v45

    invoke-static {v0, v1}, Lgnu/math/Complex;->polar(Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/DComplex;

    move-result-object v16

    goto/16 :goto_0

    .line 831
    .end local v16    # "angle":Ljava/lang/Object;
    .end local v45    # "rangle":Lgnu/math/RealNum;
    :cond_50
    const/16 v3, 0x2d

    move/from16 v0, v17

    if-eq v0, v3, :cond_51

    const/16 v3, 0x2b

    move/from16 v0, v17

    if-ne v0, v3, :cond_55

    .line 833
    :cond_51
    add-int/lit8 v11, v11, -0x1

    .line 834
    sub-int v12, v25, v11

    const/16 v14, 0xa

    move-object/from16 v10, p0

    move/from16 v13, p3

    move/from16 v15, p5

    invoke-static/range {v10 .. v15}, Lgnu/kawa/lispexpr/LispReader;->parseNumber([CIICII)Ljava/lang/Object;

    move-result-object v31

    .line 836
    .local v31, "imag":Ljava/lang/Object;
    move-object/from16 v0, v31

    instance-of v3, v0, Ljava/lang/String;

    if-eqz v3, :cond_52

    move-object/from16 v16, v31

    .line 837
    goto/16 :goto_0

    .line 838
    :cond_52
    move-object/from16 v0, v31

    instance-of v3, v0, Lgnu/math/Complex;

    if-nez v3, :cond_53

    .line 839
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "invalid numeric constant ("

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v31

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, ")"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    goto/16 :goto_0

    :cond_53
    move-object/from16 v18, v31

    .line 840
    check-cast v18, Lgnu/math/Complex;

    .line 841
    .local v18, "cimag":Lgnu/math/Complex;
    invoke-virtual/range {v18 .. v18}, Lgnu/math/Complex;->re()Lgnu/math/RealNum;

    move-result-object v46

    .line 842
    .local v46, "re":Lgnu/math/RealNum;
    invoke-virtual/range {v46 .. v46}, Lgnu/math/RealNum;->isZero()Z

    move-result v3

    if-nez v3, :cond_54

    .line 843
    const-string v16, "invalid numeric constant"

    goto/16 :goto_0

    .line 844
    :cond_54
    invoke-virtual/range {v18 .. v18}, Lgnu/math/Complex;->im()Lgnu/math/RealNum;

    move-result-object v3

    move-object/from16 v0, v37

    invoke-static {v0, v3}, Lgnu/math/Complex;->make(Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Complex;

    move-result-object v16

    goto/16 :goto_0

    .line 847
    .end local v18    # "cimag":Lgnu/math/Complex;
    .end local v31    # "imag":Ljava/lang/Object;
    .end local v46    # "re":Lgnu/math/RealNum;
    :cond_55
    const/16 v35, 0x0

    .line 850
    .local v35, "lcount":I
    :goto_16
    invoke-static/range {v17 .. v17}, Ljava/lang/Character;->isLetter(C)Z

    move-result v3

    if-nez v3, :cond_58

    .line 852
    add-int/lit8 v11, v11, -0x1

    .line 861
    :cond_56
    const/4 v3, 0x1

    move/from16 v0, v35

    if-ne v0, v3, :cond_5a

    .line 863
    add-int/lit8 v3, v11, -0x1

    aget-char v44, p0, v3

    .line 864
    .local v44, "prev":C
    const/16 v3, 0x69

    move/from16 v0, v44

    if-eq v0, v3, :cond_57

    const/16 v3, 0x49

    move/from16 v0, v44

    if-ne v0, v3, :cond_5a

    .line 866
    :cond_57
    move/from16 v0, v25

    if-ge v11, v0, :cond_59

    .line 867
    const-string v16, "junk after imaginary suffix \'i\'"

    goto/16 :goto_0

    .line 855
    .end local v44    # "prev":C
    :cond_58
    add-int/lit8 v35, v35, 0x1

    .line 856
    move/from16 v0, v25

    if-eq v11, v0, :cond_56

    .line 858
    add-int/lit8 v42, v11, 0x1

    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    aget-char v17, p0, v11

    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto :goto_16

    .line 868
    .restart local v44    # "prev":C
    :cond_59
    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v3

    move-object/from16 v0, v37

    invoke-static {v3, v0}, Lgnu/math/Complex;->make(Lgnu/math/RealNum;Lgnu/math/RealNum;)Lgnu/math/Complex;

    move-result-object v16

    goto/16 :goto_0

    .line 871
    .end local v44    # "prev":C
    :cond_5a
    const-string v16, "excess junk after number"

    goto/16 :goto_0

    .line 874
    .end local v11    # "pos":I
    .end local v35    # "lcount":I
    .restart local v42    # "pos":I
    :cond_5b
    move-object/from16 v0, v37

    instance-of v3, v0, Lgnu/math/DFloNum;

    if-eqz v3, :cond_5c

    if-lez v26, :cond_5c

    const/16 v3, 0x65

    move/from16 v0, v26

    if-eq v0, v3, :cond_5c

    .line 876
    invoke-virtual/range {v37 .. v37}, Lgnu/math/RealNum;->doubleValue()D

    move-result-wide v20

    .line 877
    .restart local v20    # "d":D
    sparse-switch v26, :sswitch_data_2

    .end local v20    # "d":D
    :cond_5c
    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    move-object/from16 v16, v37

    .line 887
    goto/16 :goto_0

    .line 880
    .end local v11    # "pos":I
    .restart local v20    # "d":D
    .restart local v42    # "pos":I
    :sswitch_8
    move-wide/from16 v0, v20

    double-to-float v3, v0

    invoke-static {v3}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v16

    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto/16 :goto_0

    .line 882
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    :sswitch_9
    invoke-static/range {v20 .. v21}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v16

    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto/16 :goto_0

    .line 884
    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    :sswitch_a
    invoke-static/range {v20 .. v21}, Ljava/math/BigDecimal;->valueOf(D)Ljava/math/BigDecimal;

    move-result-object v16

    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto/16 :goto_0

    .end local v11    # "pos":I
    .end local v20    # "d":D
    .end local v37    # "number":Lgnu/math/RealNum;
    .restart local v34    # "iresult":Lgnu/math/IntNum;
    .restart local v38    # "number":Lgnu/math/RealNum;
    .restart local v42    # "pos":I
    :cond_5d
    move-object/from16 v37, v38

    .end local v38    # "number":Lgnu/math/RealNum;
    .restart local v37    # "number":Lgnu/math/RealNum;
    goto/16 :goto_11

    .end local v26    # "exp_char":C
    .end local v32    # "inexact":Z
    .end local v34    # "iresult":Lgnu/math/IntNum;
    .end local v37    # "number":Lgnu/math/RealNum;
    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    :cond_5e
    move/from16 v42, v11

    .end local v11    # "pos":I
    .restart local v42    # "pos":I
    goto/16 :goto_e

    .end local v4    # "digits_start":I
    .end local v8    # "lvalue":J
    .end local v19    # "copy_needed":Z
    .end local v22    # "decimal_point":I
    .end local v24    # "digit":I
    .end local v28    # "exp_seen":I
    .end local v29    # "hash_seen":Z
    .end local v33    # "infnan":C
    .end local v39    # "numerator":Lgnu/math/IntNum;
    .end local v47    # "realStart":I
    .end local v51    # "underscore_seen":Z
    :cond_5f
    move/from16 v11, v42

    .end local v42    # "pos":I
    .restart local v11    # "pos":I
    goto/16 :goto_7

    .line 508
    :sswitch_data_0
    .sparse-switch
        0x42 -> :sswitch_0
        0x44 -> :sswitch_2
        0x45 -> :sswitch_4
        0x49 -> :sswitch_4
        0x4f -> :sswitch_1
        0x58 -> :sswitch_3
        0x62 -> :sswitch_0
        0x64 -> :sswitch_2
        0x65 -> :sswitch_4
        0x69 -> :sswitch_4
        0x6f -> :sswitch_1
        0x78 -> :sswitch_3
    .end sparse-switch

    .line 634
    :sswitch_data_1
    .sparse-switch
        0x2e -> :sswitch_5
        0x2f -> :sswitch_7
        0x44 -> :sswitch_6
        0x45 -> :sswitch_6
        0x46 -> :sswitch_6
        0x4c -> :sswitch_6
        0x53 -> :sswitch_6
        0x64 -> :sswitch_6
        0x65 -> :sswitch_6
        0x66 -> :sswitch_6
        0x6c -> :sswitch_6
        0x73 -> :sswitch_6
    .end sparse-switch

    .line 877
    :sswitch_data_2
    .sparse-switch
        0x64 -> :sswitch_9
        0x66 -> :sswitch_8
        0x6c -> :sswitch_a
        0x73 -> :sswitch_8
    .end sparse-switch
.end method

.method public static readCharacter(Lgnu/kawa/lispexpr/LispReader;)Ljava/lang/Object;
    .locals 12
    .param p0, "reader"    # Lgnu/kawa/lispexpr/LispReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    const/16 v11, 0x8

    .line 1150
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v0

    .line 1151
    .local v0, "ch":I
    if-gez v0, :cond_0

    .line 1152
    const-string v8, "unexpected EOF in character literal"

    invoke-virtual {p0, v8}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;)V

    .line 1153
    :cond_0
    iget v4, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    .line 1154
    .local v4, "startPos":I
    invoke-virtual {p0, v0}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    .line 1155
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v8

    const/16 v9, 0x44

    invoke-static {}, Lgnu/kawa/lispexpr/ReadTable;->getCurrent()Lgnu/kawa/lispexpr/ReadTable;

    move-result-object v10

    invoke-virtual {p0, v8, v9, v10}, Lgnu/kawa/lispexpr/LispReader;->readToken(ICLgnu/kawa/lispexpr/ReadTable;)V

    .line 1156
    iget-object v5, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    .line 1157
    .local v5, "tokenBuffer":[C
    iget v8, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    sub-int v2, v8, v4

    .line 1158
    .local v2, "length":I
    const/4 v8, 0x1

    if-ne v2, v8, :cond_1

    .line 1159
    aget-char v8, v5, v4

    invoke-static {v8}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v8

    .line 1195
    :goto_0
    return-object v8

    .line 1160
    :cond_1
    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v5, v4, v2}, Ljava/lang/String;-><init>([CII)V

    .line 1161
    .local v3, "name":Ljava/lang/String;
    invoke-static {v3}, Lgnu/text/Char;->nameToChar(Ljava/lang/String;)I

    move-result v0

    .line 1162
    if-ltz v0, :cond_2

    .line 1163
    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v8

    goto :goto_0

    .line 1164
    :cond_2
    aget-char v0, v5, v4

    .line 1165
    const/16 v8, 0x78

    if-eq v0, v8, :cond_3

    const/16 v8, 0x58

    if-ne v0, v8, :cond_5

    .line 1167
    :cond_3
    const/4 v7, 0x0

    .line 1168
    .local v7, "value":I
    const/4 v1, 0x1

    .line 1170
    .local v1, "i":I
    :goto_1
    if-ne v1, v2, :cond_4

    .line 1171
    invoke-static {v7}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v8

    goto :goto_0

    .line 1172
    :cond_4
    add-int v8, v4, v1

    aget-char v8, v5, v8

    const/16 v9, 0x10

    invoke-static {v8, v9}, Ljava/lang/Character;->digit(CI)I

    move-result v6

    .line 1173
    .local v6, "v":I
    if-gez v6, :cond_6

    .line 1180
    .end local v1    # "i":I
    .end local v6    # "v":I
    .end local v7    # "value":I
    :cond_5
    invoke-static {v0, v11}, Ljava/lang/Character;->digit(II)I

    move-result v0

    .line 1181
    if-ltz v0, :cond_8

    .line 1183
    move v7, v0

    .line 1184
    .restart local v7    # "value":I
    const/4 v1, 0x1

    .line 1186
    .restart local v1    # "i":I
    :goto_2
    if-ne v1, v2, :cond_7

    .line 1187
    invoke-static {v7}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v8

    goto :goto_0

    .line 1175
    .restart local v6    # "v":I
    :cond_6
    mul-int/lit8 v8, v7, 0x10

    add-int v7, v8, v6

    .line 1176
    const v8, 0x10ffff

    if-gt v7, v8, :cond_5

    .line 1168
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 1188
    .end local v6    # "v":I
    :cond_7
    add-int v8, v4, v1

    aget-char v8, v5, v8

    invoke-static {v8, v11}, Ljava/lang/Character;->digit(CI)I

    move-result v0

    .line 1189
    if-gez v0, :cond_9

    .line 1194
    .end local v1    # "i":I
    .end local v7    # "value":I
    :cond_8
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "unknown character name: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    .line 1195
    const/16 v8, 0x3f

    invoke-static {v8}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v8

    goto :goto_0

    .line 1191
    .restart local v1    # "i":I
    .restart local v7    # "value":I
    :cond_9
    mul-int/lit8 v8, v7, 0x8

    add-int v7, v8, v0

    .line 1184
    add-int/lit8 v1, v1, 0x1

    goto :goto_2
.end method

.method public static readNumberWithRadix(ILgnu/kawa/lispexpr/LispReader;I)Ljava/lang/Object;
    .locals 8
    .param p0, "previous"    # I
    .param p1, "reader"    # Lgnu/kawa/lispexpr/LispReader;
    .param p2, "radix"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 1123
    iget v0, p1, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    sub-int v1, v0, p0

    .line 1124
    .local v1, "startPos":I
    invoke-virtual {p1}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v0

    const/16 v2, 0x50

    invoke-static {}, Lgnu/kawa/lispexpr/ReadTable;->getCurrent()Lgnu/kawa/lispexpr/ReadTable;

    move-result-object v4

    invoke-virtual {p1, v0, v2, v4}, Lgnu/kawa/lispexpr/LispReader;->readToken(ICLgnu/kawa/lispexpr/ReadTable;)V

    .line 1125
    iget v6, p1, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    .line 1126
    .local v6, "endPos":I
    if-ne v1, v6, :cond_1

    .line 1128
    const-string v0, "missing numeric token"

    invoke-virtual {p1, v0}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    .line 1129
    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v7

    .line 1144
    :cond_0
    :goto_0
    return-object v7

    .line 1131
    :cond_1
    iget-object v0, p1, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    sub-int v2, v6, v1

    move v4, p2

    move v5, v3

    invoke-static/range {v0 .. v5}, Lgnu/kawa/lispexpr/LispReader;->parseNumber([CIICII)Ljava/lang/Object;

    move-result-object v7

    .line 1133
    .local v7, "result":Ljava/lang/Object;
    instance-of v0, v7, Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 1135
    check-cast v7, Ljava/lang/String;

    .end local v7    # "result":Ljava/lang/Object;
    invoke-virtual {p1, v7}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    .line 1136
    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v7

    goto :goto_0

    .line 1138
    .restart local v7    # "result":Ljava/lang/Object;
    :cond_2
    if-nez v7, :cond_0

    .line 1140
    const-string v0, "invalid numeric constant"

    invoke-virtual {p1, v0}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    .line 1141
    invoke-static {}, Lgnu/math/IntNum;->zero()Lgnu/math/IntNum;

    move-result-object v7

    goto :goto_0
.end method

.method public static readSimpleVector(Lgnu/kawa/lispexpr/LispReader;C)Lgnu/lists/SimpleVector;
    .locals 11
    .param p0, "reader"    # Lgnu/kawa/lispexpr/LispReader;
    .param p1, "kind"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    const/16 v10, 0x28

    const/16 v9, 0x20

    const/4 v6, 0x0

    .line 1246
    const/4 v5, 0x0

    .line 1250
    .local v5, "size":I
    :goto_0
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v0

    .line 1251
    .local v0, "ch":I
    if-gez v0, :cond_0

    .line 1252
    const-string v7, "unexpected EOF reading uniform vector"

    invoke-virtual {p0, v7}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;)V

    .line 1253
    :cond_0
    int-to-char v7, v0

    const/16 v8, 0xa

    invoke-static {v7, v8}, Ljava/lang/Character;->digit(CI)I

    move-result v1

    .line 1254
    .local v1, "digit":I
    if-gez v1, :cond_4

    .line 1258
    const/16 v7, 0x8

    if-eq v5, v7, :cond_1

    const/16 v7, 0x10

    if-eq v5, v7, :cond_1

    if-eq v5, v9, :cond_1

    const/16 v7, 0x40

    if-ne v5, v7, :cond_3

    :cond_1
    const/16 v7, 0x46

    if-ne p1, v7, :cond_2

    if-lt v5, v9, :cond_3

    :cond_2
    if-eq v0, v10, :cond_5

    .line 1262
    :cond_3
    const-string v7, "invalid uniform vector syntax"

    invoke-virtual {p0, v7}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    .line 1298
    :goto_1
    return-object v6

    .line 1256
    :cond_4
    mul-int/lit8 v7, v5, 0xa

    add-int v5, v7, v1

    .line 1257
    goto :goto_0

    .line 1265
    :cond_5
    const/4 v7, -0x1

    const/16 v8, 0x29

    invoke-static {p0, v10, v7, v8}, Lgnu/kawa/lispexpr/ReaderParens;->readList(Lgnu/kawa/lispexpr/LispReader;III)Ljava/lang/Object;

    move-result-object v3

    .line 1266
    .local v3, "list":Ljava/lang/Object;
    const/4 v7, 0x0

    invoke-static {v3, v7}, Lgnu/lists/LList;->listLength(Ljava/lang/Object;Z)I

    move-result v2

    .line 1267
    .local v2, "len":I
    if-gez v2, :cond_6

    .line 1269
    const-string v7, "invalid elements in uniform vector syntax"

    invoke-virtual {p0, v7}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    goto :goto_1

    :cond_6
    move-object v4, v3

    .line 1272
    check-cast v4, Lgnu/lists/Sequence;

    .line 1273
    .local v4, "q":Lgnu/lists/Sequence;
    sparse-switch p1, :sswitch_data_0

    goto :goto_1

    .line 1276
    :sswitch_0
    sparse-switch v5, :sswitch_data_1

    .line 1282
    :sswitch_1
    sparse-switch v5, :sswitch_data_2

    .line 1290
    :sswitch_2
    sparse-switch v5, :sswitch_data_3

    goto :goto_1

    .line 1292
    :sswitch_3
    new-instance v6, Lgnu/lists/U8Vector;

    invoke-direct {v6, v4}, Lgnu/lists/U8Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1278
    :sswitch_4
    new-instance v6, Lgnu/lists/F32Vector;

    invoke-direct {v6, v4}, Lgnu/lists/F32Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1279
    :sswitch_5
    new-instance v6, Lgnu/lists/F64Vector;

    invoke-direct {v6, v4}, Lgnu/lists/F64Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1284
    :sswitch_6
    new-instance v6, Lgnu/lists/S8Vector;

    invoke-direct {v6, v4}, Lgnu/lists/S8Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1285
    :sswitch_7
    new-instance v6, Lgnu/lists/S16Vector;

    invoke-direct {v6, v4}, Lgnu/lists/S16Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1286
    :sswitch_8
    new-instance v6, Lgnu/lists/S32Vector;

    invoke-direct {v6, v4}, Lgnu/lists/S32Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1287
    :sswitch_9
    new-instance v6, Lgnu/lists/S64Vector;

    invoke-direct {v6, v4}, Lgnu/lists/S64Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1293
    :sswitch_a
    new-instance v6, Lgnu/lists/U16Vector;

    invoke-direct {v6, v4}, Lgnu/lists/U16Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1294
    :sswitch_b
    new-instance v6, Lgnu/lists/U32Vector;

    invoke-direct {v6, v4}, Lgnu/lists/U32Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1295
    :sswitch_c
    new-instance v6, Lgnu/lists/U64Vector;

    invoke-direct {v6, v4}, Lgnu/lists/U64Vector;-><init>(Lgnu/lists/Sequence;)V

    goto :goto_1

    .line 1273
    :sswitch_data_0
    .sparse-switch
        0x46 -> :sswitch_0
        0x53 -> :sswitch_1
        0x55 -> :sswitch_2
    .end sparse-switch

    .line 1276
    :sswitch_data_1
    .sparse-switch
        0x20 -> :sswitch_4
        0x40 -> :sswitch_5
    .end sparse-switch

    .line 1282
    :sswitch_data_2
    .sparse-switch
        0x8 -> :sswitch_6
        0x10 -> :sswitch_7
        0x20 -> :sswitch_8
        0x40 -> :sswitch_9
    .end sparse-switch

    .line 1290
    :sswitch_data_3
    .sparse-switch
        0x8 -> :sswitch_3
        0x10 -> :sswitch_a
        0x20 -> :sswitch_b
        0x40 -> :sswitch_c
    .end sparse-switch
.end method

.method public static readSpecial(Lgnu/kawa/lispexpr/LispReader;)Ljava/lang/Object;
    .locals 8
    .param p0, "reader"    # Lgnu/kawa/lispexpr/LispReader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 1201
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v0

    .line 1202
    .local v0, "ch":I
    if-gez v0, :cond_0

    .line 1203
    const-string v5, "unexpected EOF in #! special form"

    invoke-virtual {p0, v5}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;)V

    .line 1206
    :cond_0
    const/16 v5, 0x2f

    if-ne v0, v5, :cond_2

    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->getLineNumber()I

    move-result v5

    if-nez v5, :cond_2

    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->getColumnNumber()I

    move-result v5

    const/4 v6, 0x3

    if-ne v5, v6, :cond_2

    .line 1210
    invoke-static {}, Lgnu/kawa/lispexpr/ReaderIgnoreRestOfLine;->getInstance()Lgnu/kawa/lispexpr/ReaderIgnoreRestOfLine;

    move-result-object v4

    const/16 v5, 0x23

    const/4 v6, 0x1

    invoke-virtual {v4, p0, v5, v6}, Lgnu/kawa/lispexpr/ReaderIgnoreRestOfLine;->read(Lgnu/text/Lexer;II)Ljava/lang/Object;

    .line 1211
    sget-object v4, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    .line 1239
    :cond_1
    :goto_0
    return-object v4

    .line 1214
    :cond_2
    iget v3, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    .line 1215
    .local v3, "startPos":I
    invoke-virtual {p0, v0}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    .line 1216
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v5

    const/16 v6, 0x44

    invoke-static {}, Lgnu/kawa/lispexpr/ReadTable;->getCurrent()Lgnu/kawa/lispexpr/ReadTable;

    move-result-object v7

    invoke-virtual {p0, v5, v6, v7}, Lgnu/kawa/lispexpr/LispReader;->readToken(ICLgnu/kawa/lispexpr/ReadTable;)V

    .line 1217
    iget v5, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    sub-int v1, v5, v3

    .line 1218
    .local v1, "length":I
    new-instance v2, Ljava/lang/String;

    iget-object v5, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    invoke-direct {v2, v5, v3, v1}, Ljava/lang/String;-><init>([CII)V

    .line 1219
    .local v2, "name":Ljava/lang/String;
    const-string v5, "optional"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 1220
    sget-object v4, Lgnu/expr/Special;->optional:Lgnu/expr/Special;

    goto :goto_0

    .line 1221
    :cond_3
    const-string v5, "rest"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 1222
    sget-object v4, Lgnu/expr/Special;->rest:Lgnu/expr/Special;

    goto :goto_0

    .line 1223
    :cond_4
    const-string v5, "key"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 1224
    sget-object v4, Lgnu/expr/Special;->key:Lgnu/expr/Special;

    goto :goto_0

    .line 1225
    :cond_5
    const-string v5, "eof"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_6

    .line 1226
    sget-object v4, Lgnu/expr/Special;->eof:Ljava/lang/Object;

    goto :goto_0

    .line 1227
    :cond_6
    const-string v5, "void"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 1229
    sget-object v4, Lgnu/expr/QuoteExp;->voidExp:Lgnu/expr/QuoteExp;

    goto :goto_0

    .line 1230
    :cond_7
    const-string v5, "default"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 1231
    sget-object v4, Lgnu/expr/Special;->dfault:Lgnu/expr/Special;

    goto :goto_0

    .line 1232
    :cond_8
    const-string v5, "undefined"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 1233
    sget-object v4, Lgnu/expr/Special;->undefined:Lgnu/expr/Special;

    goto :goto_0

    .line 1234
    :cond_9
    const-string v5, "abstract"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 1235
    sget-object v4, Lgnu/expr/Special;->abstractSpecial:Lgnu/expr/Special;

    goto :goto_0

    .line 1236
    :cond_a
    const-string v5, "null"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 1238
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "unknown named constant #!"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private static valueOf([CIIIZJ)Lgnu/math/IntNum;
    .locals 2
    .param p0, "buffer"    # [C
    .param p1, "digits_start"    # I
    .param p2, "number_of_digits"    # I
    .param p3, "radix"    # I
    .param p4, "negative"    # Z
    .param p5, "lvalue"    # J

    .prologue
    .line 898
    add-int v0, p2, p3

    const/16 v1, 0x1c

    if-gt v0, v1, :cond_1

    .line 899
    if-eqz p4, :cond_0

    neg-long p5, p5

    .end local p5    # "lvalue":J
    :cond_0
    invoke-static {p5, p6}, Lgnu/math/IntNum;->make(J)Lgnu/math/IntNum;

    move-result-object v0

    .line 901
    :goto_0
    return-object v0

    .restart local p5    # "lvalue":J
    :cond_1
    invoke-static {p0, p1, p2, p3, p4}, Lgnu/math/IntNum;->valueOf([CIIIZ)Lgnu/math/IntNum;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method handlePostfix(Ljava/lang/Object;Lgnu/kawa/lispexpr/ReadTable;II)Ljava/lang/Object;
    .locals 7
    .param p1, "value"    # Ljava/lang/Object;
    .param p2, "rtable"    # Lgnu/kawa/lispexpr/ReadTable;
    .param p3, "line"    # I
    .param p4, "column"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 409
    sget-object v3, Lgnu/expr/QuoteExp;->voidExp:Lgnu/expr/QuoteExp;

    if-ne p1, v3, :cond_0

    .line 410
    sget-object p1, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    .line 413
    .end local p1    # "value":Ljava/lang/Object;
    :cond_0
    :goto_0
    iget-object v3, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v3}, Lgnu/text/LineBufferedReader;->peek()I

    move-result v0

    .line 414
    .local v0, "ch":I
    if-ltz v0, :cond_1

    iget-char v3, p2, Lgnu/kawa/lispexpr/ReadTable;->postfixLookupOperator:C

    if-eq v0, v3, :cond_2

    .line 431
    :cond_1
    :goto_1
    return-object p1

    .line 417
    :cond_2
    iget-object v3, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v3}, Lgnu/text/LineBufferedReader;->read()I

    .line 418
    iget-object v3, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v3}, Lgnu/text/LineBufferedReader;->peek()I

    move-result v1

    .line 419
    .local v1, "ch2":I
    invoke-virtual {p0, v1, p2}, Lgnu/kawa/lispexpr/LispReader;->validPostfixLookupStart(ILgnu/kawa/lispexpr/ReadTable;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 421
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->unread()V

    goto :goto_1

    .line 424
    :cond_3
    iget-object v3, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v3}, Lgnu/text/LineBufferedReader;->read()I

    move-result v0

    .line 425
    invoke-virtual {p2, v0}, Lgnu/kawa/lispexpr/ReadTable;->lookup(I)Lgnu/kawa/lispexpr/ReadTableEntry;

    move-result-object v3

    invoke-virtual {p0, v0, v3, p2}, Lgnu/kawa/lispexpr/LispReader;->readValues(ILgnu/kawa/lispexpr/ReadTableEntry;Lgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;

    move-result-object v2

    .line 426
    .local v2, "rightOperand":Ljava/lang/Object;
    const-string v3, "quasiquote"

    invoke-virtual {p2, v3}, Lgnu/kawa/lispexpr/ReadTable;->makeSymbol(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-static {v3, v2}, Lgnu/lists/LList;->list2(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v3

    invoke-static {p1, v3}, Lgnu/lists/LList;->list2(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object p1

    .line 428
    .local p1, "value":Lgnu/lists/Pair;
    sget-object v3, Lgnu/kawa/lispexpr/LispLanguage;->lookup_sym:Lgnu/mapping/Symbol;

    iget-object v4, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v4}, Lgnu/text/LineBufferedReader;->getName()Ljava/lang/String;

    move-result-object v4

    add-int/lit8 v5, p3, 0x1

    add-int/lit8 v6, p4, 0x1

    invoke-static {v3, p1, v4, v5, v6}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;II)Lgnu/lists/PairWithPosition;

    move-result-object p1

    .line 430
    .local p1, "value":Lgnu/lists/PairWithPosition;
    goto :goto_0
.end method

.method protected makeNil()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1092
    sget-object v0, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    return-object v0
.end method

.method protected makePair(Ljava/lang/Object;II)Lgnu/lists/Pair;
    .locals 1
    .param p1, "car"    # Ljava/lang/Object;
    .param p2, "line"    # I
    .param p3, "column"    # I

    .prologue
    .line 1097
    sget-object v0, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-virtual {p0, p1, v0, p2, p3}, Lgnu/kawa/lispexpr/LispReader;->makePair(Ljava/lang/Object;Ljava/lang/Object;II)Lgnu/lists/Pair;

    move-result-object v0

    return-object v0
.end method

.method protected makePair(Ljava/lang/Object;Ljava/lang/Object;II)Lgnu/lists/Pair;
    .locals 3
    .param p1, "car"    # Ljava/lang/Object;
    .param p2, "cdr"    # Ljava/lang/Object;
    .param p3, "line"    # I
    .param p4, "column"    # I

    .prologue
    .line 1102
    iget-object v1, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v1}, Lgnu/text/LineBufferedReader;->getName()Ljava/lang/String;

    move-result-object v0

    .line 1103
    .local v0, "pname":Ljava/lang/String;
    if-eqz v0, :cond_0

    if-ltz p3, :cond_0

    .line 1104
    add-int/lit8 v1, p3, 0x1

    add-int/lit8 v2, p4, 0x1

    invoke-static {p1, p2, v0, v1, v2}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;II)Lgnu/lists/PairWithPosition;

    move-result-object v1

    .line 1107
    :goto_0
    return-object v1

    :cond_0
    invoke-static {p1, p2}, Lgnu/lists/Pair;->make(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v1

    goto :goto_0
.end method

.method protected readAndHandleToken(IILgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;
    .locals 29
    .param p1, "ch"    # I
    .param p2, "startPos"    # I
    .param p3, "rtable"    # Lgnu/kawa/lispexpr/ReadTable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 133
    invoke-static {}, Lgnu/kawa/lispexpr/LispReader;->getReadCase()C

    move-result v3

    move-object/from16 v0, p0

    move/from16 v1, p1

    move-object/from16 v2, p3

    invoke-virtual {v0, v1, v3, v2}, Lgnu/kawa/lispexpr/LispReader;->readToken(ICLgnu/kawa/lispexpr/ReadTable;)V

    .line 134
    move-object/from16 v0, p0

    iget v11, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    .line 135
    .local v11, "endPos":I
    move-object/from16 v0, p0

    iget-boolean v3, v0, Lgnu/kawa/lispexpr/LispReader;->seenEscapes:Z

    if-nez v3, :cond_0

    .line 137
    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    sub-int v5, v11, p2

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x1

    move/from16 v4, p2

    invoke-static/range {v3 .. v8}, Lgnu/kawa/lispexpr/LispReader;->parseNumber([CIICII)Ljava/lang/Object;

    move-result-object v28

    .line 139
    .local v28, "value":Ljava/lang/Object;
    if-eqz v28, :cond_0

    move-object/from16 v0, v28

    instance-of v3, v0, Ljava/lang/String;

    if-nez v3, :cond_0

    .line 256
    .end local v28    # "value":Ljava/lang/Object;
    :goto_0
    return-object v28

    .line 151
    :cond_0
    invoke-static {}, Lgnu/kawa/lispexpr/LispReader;->getReadCase()C

    move-result v22

    .line 152
    .local v22, "readCase":C
    const/16 v3, 0x49

    move/from16 v0, v22

    if-ne v0, v3, :cond_5

    .line 154
    const/16 v25, 0x0

    .line 155
    .local v25, "upperCount":I
    const/16 v18, 0x0

    .line 156
    .local v18, "lowerCount":I
    move/from16 v13, p2

    .local v13, "i":I
    :goto_1
    if-ge v13, v11, :cond_4

    .line 158
    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    aget-char v10, v3, v13

    .line 159
    .local v10, "ci":C
    const v3, 0xffff

    if-ne v10, v3, :cond_2

    .line 160
    add-int/lit8 v13, v13, 0x1

    .line 156
    :cond_1
    :goto_2
    add-int/lit8 v13, v13, 0x1

    goto :goto_1

    .line 161
    :cond_2
    invoke-static {v10}, Ljava/lang/Character;->isLowerCase(C)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 162
    add-int/lit8 v18, v18, 0x1

    goto :goto_2

    .line 163
    :cond_3
    invoke-static {v10}, Ljava/lang/Character;->isUpperCase(C)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 164
    add-int/lit8 v25, v25, 0x1

    goto :goto_2

    .line 166
    .end local v10    # "ci":C
    :cond_4
    if-nez v18, :cond_6

    .line 167
    const/16 v22, 0x44

    .line 174
    .end local v13    # "i":I
    .end local v18    # "lowerCount":I
    .end local v25    # "upperCount":I
    :cond_5
    :goto_3
    add-int/lit8 v3, p2, 0x2

    if-lt v11, v3, :cond_8

    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    add-int/lit8 v4, v11, -0x1

    aget-char v3, v3, v4

    const/16 v4, 0x7d

    if-ne v3, v4, :cond_8

    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    add-int/lit8 v4, v11, -0x2

    aget-char v3, v3, v4

    const v4, 0xffff

    if-eq v3, v4, :cond_8

    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->peek()I

    move-result v3

    const/16 v4, 0x3a

    if-ne v3, v4, :cond_8

    const/4 v12, 0x1

    .line 179
    .local v12, "handleUri":Z
    :goto_4
    const/16 v19, -0x1

    .line 180
    .local v19, "packageMarker":I
    const/16 v16, -0x1

    .local v16, "lbrace":I
    const/16 v21, -0x1

    .local v21, "rbrace":I
    const/4 v9, 0x0

    .line 181
    .local v9, "braceNesting":I
    move/from16 v14, p2

    .line 182
    .local v14, "j":I
    const/16 v27, 0x0

    .line 183
    .local v27, "uriBad":Z
    move/from16 v13, p2

    .restart local v13    # "i":I
    move v15, v14

    .end local v14    # "j":I
    .local v15, "j":I
    :goto_5
    if-ge v13, v11, :cond_15

    .line 185
    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    aget-char v10, v3, v13

    .line 186
    .restart local v10    # "ci":C
    const v3, 0xffff

    if-ne v10, v3, :cond_9

    .line 188
    add-int/lit8 v13, v13, 0x1

    if-ge v13, v11, :cond_1c

    .line 189
    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    add-int/lit8 v14, v15, 0x1

    .end local v15    # "j":I
    .restart local v14    # "j":I
    move-object/from16 v0, p0

    iget-object v4, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    aget-char v4, v4, v13

    aput-char v4, v3, v15

    .line 183
    :goto_6
    add-int/lit8 v13, v13, 0x1

    move v15, v14

    .end local v14    # "j":I
    .restart local v15    # "j":I
    goto :goto_5

    .line 168
    .end local v9    # "braceNesting":I
    .end local v10    # "ci":C
    .end local v12    # "handleUri":Z
    .end local v15    # "j":I
    .end local v16    # "lbrace":I
    .end local v19    # "packageMarker":I
    .end local v21    # "rbrace":I
    .end local v27    # "uriBad":Z
    .restart local v18    # "lowerCount":I
    .restart local v25    # "upperCount":I
    :cond_6
    if-nez v25, :cond_7

    .line 169
    const/16 v22, 0x55

    goto :goto_3

    .line 171
    :cond_7
    const/16 v22, 0x50

    goto :goto_3

    .line 174
    .end local v13    # "i":I
    .end local v18    # "lowerCount":I
    .end local v25    # "upperCount":I
    :cond_8
    const/4 v12, 0x0

    goto :goto_4

    .line 192
    .restart local v9    # "braceNesting":I
    .restart local v10    # "ci":C
    .restart local v12    # "handleUri":Z
    .restart local v13    # "i":I
    .restart local v15    # "j":I
    .restart local v16    # "lbrace":I
    .restart local v19    # "packageMarker":I
    .restart local v21    # "rbrace":I
    .restart local v27    # "uriBad":Z
    :cond_9
    if-eqz v12, :cond_b

    .line 194
    const/16 v3, 0x7b

    if-ne v10, v3, :cond_e

    .line 196
    if-gez v16, :cond_d

    .line 197
    move/from16 v16, v15

    .line 200
    :cond_a
    :goto_7
    add-int/lit8 v9, v9, 0x1

    .line 216
    :cond_b
    :goto_8
    if-lez v9, :cond_11

    .line 224
    :cond_c
    :goto_9
    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    add-int/lit8 v14, v15, 0x1

    .end local v15    # "j":I
    .restart local v14    # "j":I
    aput-char v10, v3, v15

    goto :goto_6

    .line 198
    .end local v14    # "j":I
    .restart local v15    # "j":I
    :cond_d
    if-nez v9, :cond_a

    .line 199
    const/16 v27, 0x1

    goto :goto_7

    .line 202
    :cond_e
    const/16 v3, 0x7d

    if-ne v10, v3, :cond_b

    .line 204
    add-int/lit8 v9, v9, -0x1

    .line 205
    if-gez v9, :cond_f

    .line 206
    const/16 v27, 0x1

    goto :goto_8

    .line 207
    :cond_f
    if-nez v9, :cond_b

    .line 209
    if-gez v21, :cond_10

    .line 210
    move/from16 v21, v15

    goto :goto_8

    .line 212
    :cond_10
    const/16 v27, 0x1

    goto :goto_8

    .line 218
    :cond_11
    const/16 v3, 0x3a

    if-ne v10, v3, :cond_13

    .line 219
    if-ltz v19, :cond_12

    const/16 v19, -0x1

    :goto_a
    goto :goto_9

    :cond_12
    move/from16 v19, v15

    goto :goto_a

    .line 220
    :cond_13
    const/16 v3, 0x55

    move/from16 v0, v22

    if-ne v0, v3, :cond_14

    .line 221
    invoke-static {v10}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v10

    goto :goto_9

    .line 222
    :cond_14
    const/16 v3, 0x44

    move/from16 v0, v22

    if-ne v0, v3, :cond_c

    .line 223
    invoke-static {v10}, Ljava/lang/Character;->toLowerCase(C)C

    move-result v10

    goto :goto_9

    .line 226
    .end local v10    # "ci":C
    :cond_15
    move v11, v15

    .line 228
    sub-int v17, v11, p2

    .line 230
    .local v17, "len":I
    if-ltz v16, :cond_18

    move/from16 v0, v21

    move/from16 v1, v16

    if-le v0, v1, :cond_18

    .line 232
    if-lez v16, :cond_17

    new-instance v20, Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    sub-int v4, v16, p2

    move-object/from16 v0, v20

    move/from16 v1, p2

    invoke-direct {v0, v3, v1, v4}, Ljava/lang/String;-><init>([CII)V

    .line 233
    .local v20, "prefix":Ljava/lang/String;
    :goto_b
    add-int/lit8 v16, v16, 0x1

    .line 234
    new-instance v26, Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    sub-int v4, v21, v16

    move-object/from16 v0, v26

    move/from16 v1, v16

    invoke-direct {v0, v3, v1, v4}, Ljava/lang/String;-><init>([CII)V

    .line 235
    .local v26, "uri":Ljava/lang/String;
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    .line 236
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    .line 237
    move-object/from16 v0, p3

    move/from16 v1, p1

    invoke-virtual {v0, v1}, Lgnu/kawa/lispexpr/ReadTable;->lookup(I)Lgnu/kawa/lispexpr/ReadTableEntry;

    move-result-object v3

    move-object/from16 v0, p0

    move/from16 v1, p1

    move-object/from16 v2, p3

    invoke-virtual {v0, v1, v3, v2}, Lgnu/kawa/lispexpr/LispReader;->readValues(ILgnu/kawa/lispexpr/ReadTableEntry;Lgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;

    move-result-object v23

    .line 238
    .local v23, "rightOperand":Ljava/lang/Object;
    move-object/from16 v0, v23

    instance-of v3, v0, Lgnu/mapping/SimpleSymbol;

    if-nez v3, :cond_16

    .line 239
    const-string v3, "expected identifier in symbol after \'{URI}:\'"

    move-object/from16 v0, p0

    invoke-virtual {v0, v3}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    .line 241
    :cond_16
    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v26

    move-object/from16 v1, v20

    invoke-static {v3, v0, v1}, Lgnu/mapping/Symbol;->valueOf(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v28

    goto/16 :goto_0

    .line 232
    .end local v20    # "prefix":Ljava/lang/String;
    .end local v23    # "rightOperand":Ljava/lang/Object;
    .end local v26    # "uri":Ljava/lang/String;
    :cond_17
    const/16 v20, 0x0

    goto :goto_b

    .line 244
    :cond_18
    move-object/from16 v0, p3

    iget-boolean v3, v0, Lgnu/kawa/lispexpr/ReadTable;->initialColonIsKeyword:Z

    if-eqz v3, :cond_19

    move/from16 v0, v19

    move/from16 v1, p2

    if-ne v0, v1, :cond_19

    const/4 v3, 0x1

    move/from16 v0, v17

    if-le v0, v3, :cond_19

    .line 246
    add-int/lit8 p2, p2, 0x1

    .line 247
    new-instance v24, Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    sub-int v4, v11, p2

    move-object/from16 v0, v24

    move/from16 v1, p2

    invoke-direct {v0, v3, v1, v4}, Ljava/lang/String;-><init>([CII)V

    .line 248
    .local v24, "str":Ljava/lang/String;
    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lgnu/expr/Keyword;->make(Ljava/lang/String;)Lgnu/expr/Keyword;

    move-result-object v28

    goto/16 :goto_0

    .line 250
    .end local v24    # "str":Ljava/lang/String;
    :cond_19
    move-object/from16 v0, p3

    iget-boolean v3, v0, Lgnu/kawa/lispexpr/ReadTable;->finalColonIsKeyword:Z

    if-eqz v3, :cond_1b

    add-int/lit8 v3, v11, -0x1

    move/from16 v0, v19

    if-ne v0, v3, :cond_1b

    const/4 v3, 0x1

    move/from16 v0, v17

    if-gt v0, v3, :cond_1a

    move-object/from16 v0, p0

    iget-boolean v3, v0, Lgnu/kawa/lispexpr/LispReader;->seenEscapes:Z

    if-eqz v3, :cond_1b

    .line 253
    :cond_1a
    new-instance v24, Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    add-int/lit8 v4, v17, -0x1

    move-object/from16 v0, v24

    move/from16 v1, p2

    invoke-direct {v0, v3, v1, v4}, Ljava/lang/String;-><init>([CII)V

    .line 254
    .restart local v24    # "str":Ljava/lang/String;
    invoke-virtual/range {v24 .. v24}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lgnu/expr/Keyword;->make(Ljava/lang/String;)Lgnu/expr/Keyword;

    move-result-object v28

    goto/16 :goto_0

    .line 256
    .end local v24    # "str":Ljava/lang/String;
    :cond_1b
    new-instance v3, Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lgnu/kawa/lispexpr/LispReader;->tokenBuffer:[C

    move/from16 v0, p2

    move/from16 v1, v17

    invoke-direct {v3, v4, v0, v1}, Ljava/lang/String;-><init>([CII)V

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Lgnu/kawa/lispexpr/ReadTable;->makeSymbol(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v28

    goto/16 :goto_0

    .end local v17    # "len":I
    .restart local v10    # "ci":C
    :cond_1c
    move v14, v15

    .end local v15    # "j":I
    .restart local v14    # "j":I
    goto/16 :goto_6
.end method

.method public readCommand()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 1087
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->readObject()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public readEscape()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 911
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v0

    .line 912
    .local v0, "c":I
    if-gez v0, :cond_0

    .line 914
    const-string v1, "unexpected EOF in character literal"

    invoke-virtual {p0, v1}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;)V

    .line 915
    const/4 v1, -0x1

    .line 917
    :goto_0
    return v1

    :cond_0
    invoke-virtual {p0, v0}, Lgnu/kawa/lispexpr/LispReader;->readEscape(I)I

    move-result v1

    goto :goto_0
.end method

.method public final readEscape(I)I
    .locals 10
    .param p1, "c"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    const/16 v9, 0x20

    const/16 v8, 0x9

    const/4 v5, -0x1

    const/16 v4, 0x3f

    const/16 v7, 0xa

    .line 923
    int-to-char v6, p1

    sparse-switch v6, :sswitch_data_0

    :cond_0
    :goto_0
    move v4, p1

    .line 1047
    :goto_1
    return v4

    .line 925
    :sswitch_0
    const/4 p1, 0x7

    goto :goto_0

    .line 926
    :sswitch_1
    const/16 p1, 0x8

    goto :goto_0

    .line 927
    :sswitch_2
    const/16 p1, 0x9

    goto :goto_0

    .line 928
    :sswitch_3
    const/16 p1, 0xa

    goto :goto_0

    .line 929
    :sswitch_4
    const/16 p1, 0xb

    goto :goto_0

    .line 930
    :sswitch_5
    const/16 p1, 0xc

    goto :goto_0

    .line 931
    :sswitch_6
    const/16 p1, 0xd

    goto :goto_0

    .line 932
    :sswitch_7
    const/16 p1, 0x1b

    goto :goto_0

    .line 933
    :sswitch_8
    const/16 p1, 0x22

    goto :goto_0

    .line 934
    :sswitch_9
    const/16 p1, 0x5c

    goto :goto_0

    .line 960
    :cond_1
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    .line 941
    :sswitch_a
    if-gez p1, :cond_2

    .line 943
    const-string v4, "unexpected EOF in literal"

    invoke-virtual {p0, v4}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;)V

    move v4, v5

    .line 944
    goto :goto_1

    .line 946
    :cond_2
    if-ne p1, v7, :cond_4

    .line 962
    :goto_2
    if-ne p1, v7, :cond_0

    .line 967
    :cond_3
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    .line 968
    if-gez p1, :cond_7

    .line 970
    const-string v4, "unexpected EOF in literal"

    invoke-virtual {p0, v4}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;)V

    move v4, v5

    .line 971
    goto :goto_1

    .line 948
    :cond_4
    const/16 v4, 0xd

    if-ne p1, v4, :cond_6

    .line 950
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->peek()I

    move-result v4

    if-ne v4, v7, :cond_5

    .line 951
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->skip()V

    .line 952
    :cond_5
    const/16 p1, 0xa

    .line 953
    goto :goto_2

    .line 955
    :cond_6
    if-eq p1, v9, :cond_1

    if-eq p1, v8, :cond_1

    .line 957
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->unread(I)V

    goto :goto_2

    .line 973
    :cond_7
    if-eq p1, v9, :cond_3

    if-eq p1, v8, :cond_3

    .line 975
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->unread(I)V

    .line 976
    const/4 v4, -0x2

    goto :goto_1

    .line 980
    :sswitch_b
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    .line 981
    const/16 v5, 0x2d

    if-eq p1, v5, :cond_8

    .line 983
    const-string v5, "Invalid escape character syntax"

    invoke-virtual {p0, v5}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    goto :goto_1

    .line 986
    :cond_8
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    .line 987
    const/16 v4, 0x5c

    if-ne p1, v4, :cond_9

    .line 988
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->readEscape()I

    move-result p1

    .line 989
    :cond_9
    or-int/lit16 v4, p1, 0x80

    goto :goto_1

    .line 991
    :sswitch_c
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    .line 992
    const/16 v5, 0x2d

    if-eq p1, v5, :cond_a

    .line 994
    const-string v5, "Invalid escape character syntax"

    invoke-virtual {p0, v5}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 999
    :cond_a
    :sswitch_d
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    .line 1000
    const/16 v5, 0x5c

    if-ne p1, v5, :cond_b

    .line 1001
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->readEscape()I

    move-result p1

    .line 1002
    :cond_b
    if-ne p1, v4, :cond_c

    .line 1003
    const/16 v4, 0x7f

    goto/16 :goto_1

    .line 1004
    :cond_c
    and-int/lit16 v4, p1, 0x9f

    goto/16 :goto_1

    .line 1014
    :sswitch_e
    add-int/lit8 p1, p1, -0x30

    .line 1015
    const/4 v0, 0x0

    .local v0, "count":I
    :goto_3
    add-int/lit8 v0, v0, 0x1

    const/4 v4, 0x3

    if-ge v0, v4, :cond_0

    .line 1017
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v1

    .line 1018
    .local v1, "d":I
    int-to-char v4, v1

    const/16 v5, 0x8

    invoke-static {v4, v5}, Ljava/lang/Character;->digit(CI)I

    move-result v3

    .line 1019
    .local v3, "v":I
    if-ltz v3, :cond_d

    .line 1020
    shl-int/lit8 v4, p1, 0x3

    add-int p1, v4, v3

    goto :goto_3

    .line 1023
    :cond_d
    if-ltz v1, :cond_0

    .line 1024
    invoke-virtual {p0, v1}, Lgnu/kawa/lispexpr/LispReader;->unread(I)V

    goto/16 :goto_0

    .line 1030
    .end local v0    # "count":I
    .end local v1    # "d":I
    .end local v3    # "v":I
    :sswitch_f
    const/4 p1, 0x0

    .line 1031
    const/4 v2, 0x4

    .local v2, "i":I
    :goto_4
    add-int/lit8 v2, v2, -0x1

    if-ltz v2, :cond_0

    .line 1033
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v1

    .line 1034
    .restart local v1    # "d":I
    if-gez v1, :cond_e

    .line 1035
    const-string v4, "premature EOF in \\u escape"

    invoke-virtual {p0, v4}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;)V

    .line 1036
    :cond_e
    int-to-char v4, v1

    const/16 v5, 0x10

    invoke-static {v4, v5}, Ljava/lang/Character;->digit(CI)I

    move-result v3

    .line 1037
    .restart local v3    # "v":I
    if-gez v3, :cond_f

    .line 1038
    const-string v4, "non-hex character following \\u"

    invoke-virtual {p0, v4}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    .line 1039
    :cond_f
    mul-int/lit8 v4, p1, 0x10

    add-int p1, v4, v3

    .line 1040
    goto :goto_4

    .line 1044
    .end local v1    # "d":I
    .end local v2    # "i":I
    .end local v3    # "v":I
    :sswitch_10
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->readHexEscape()I

    move-result v4

    goto/16 :goto_1

    .line 923
    :sswitch_data_0
    .sparse-switch
        0x9 -> :sswitch_a
        0xa -> :sswitch_a
        0xd -> :sswitch_a
        0x20 -> :sswitch_a
        0x22 -> :sswitch_8
        0x30 -> :sswitch_e
        0x31 -> :sswitch_e
        0x32 -> :sswitch_e
        0x33 -> :sswitch_e
        0x34 -> :sswitch_e
        0x35 -> :sswitch_e
        0x36 -> :sswitch_e
        0x37 -> :sswitch_e
        0x43 -> :sswitch_c
        0x4d -> :sswitch_b
        0x58 -> :sswitch_10
        0x5c -> :sswitch_9
        0x5e -> :sswitch_d
        0x61 -> :sswitch_0
        0x62 -> :sswitch_1
        0x65 -> :sswitch_7
        0x66 -> :sswitch_5
        0x6e -> :sswitch_3
        0x72 -> :sswitch_6
        0x74 -> :sswitch_2
        0x75 -> :sswitch_f
        0x76 -> :sswitch_4
        0x78 -> :sswitch_10
    .end sparse-switch
.end method

.method public readHexEscape()I
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 1053
    const/4 v0, 0x0

    .line 1057
    .local v0, "c":I
    :goto_0
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v1

    .line 1058
    .local v1, "d":I
    int-to-char v3, v1

    const/16 v4, 0x10

    invoke-static {v3, v4}, Ljava/lang/Character;->digit(CI)I

    move-result v2

    .line 1059
    .local v2, "v":I
    if-ltz v2, :cond_0

    .line 1060
    shl-int/lit8 v3, v0, 0x4

    add-int v0, v3, v2

    goto :goto_0

    .line 1063
    :cond_0
    const/16 v3, 0x3b

    if-eq v1, v3, :cond_1

    .line 1066
    if-ltz v1, :cond_1

    .line 1067
    invoke-virtual {p0, v1}, Lgnu/kawa/lispexpr/LispReader;->unread(I)V

    .line 1072
    :cond_1
    return v0
.end method

.method public final readNestedComment(CC)V
    .locals 7
    .param p1, "c1"    # C
    .param p2, "c2"    # C
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 36
    const/4 v1, 0x1

    .line 37
    .local v1, "commentNesting":I
    iget-object v4, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v4}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v3

    .line 38
    .local v3, "startLine":I
    iget-object v4, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v4}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v2

    .line 41
    .local v2, "startColumn":I
    :cond_0
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v0

    .line 42
    .local v0, "c":I
    const/16 v4, 0x7c

    if-ne v0, v4, :cond_2

    .line 44
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v0

    .line 45
    if-ne v0, p1, :cond_1

    .line 46
    add-int/lit8 v1, v1, -0x1

    .line 54
    :cond_1
    :goto_0
    if-gez v0, :cond_3

    .line 56
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "unexpected end-of-file in "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " comment starting here"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    add-int/lit8 v5, v3, 0x1

    add-int/lit8 v6, v2, -0x1

    invoke-virtual {p0, v4, v5, v6}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;II)V

    .line 62
    :goto_1
    return-void

    .line 48
    :cond_2
    if-ne v0, p1, :cond_1

    .line 50
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v0

    .line 51
    if-ne v0, p2, :cond_1

    .line 52
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 61
    :cond_3
    if-gtz v1, :cond_0

    goto :goto_1
.end method

.method public readObject()Ljava/lang/Object;
    .locals 9
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 366
    iget-object v7, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    check-cast v7, Lgnu/mapping/InPort;

    iget-char v4, v7, Lgnu/mapping/InPort;->readState:C

    .line 367
    .local v4, "saveReadState":C
    iget v5, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    .line 368
    .local v5, "startPos":I
    iget-object v7, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    check-cast v7, Lgnu/mapping/InPort;

    const/16 v8, 0x20

    iput-char v8, v7, Lgnu/mapping/InPort;->readState:C

    .line 371
    :try_start_0
    invoke-static {}, Lgnu/kawa/lispexpr/ReadTable;->getCurrent()Lgnu/kawa/lispexpr/ReadTable;

    move-result-object v3

    .line 374
    .local v3, "rtable":Lgnu/kawa/lispexpr/ReadTable;
    :cond_0
    iget-object v7, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v7}, Lgnu/text/LineBufferedReader;->getLineNumber()I

    move-result v2

    .line 375
    .local v2, "line":I
    iget-object v7, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v7}, Lgnu/text/LineBufferedReader;->getColumnNumber()I

    move-result v1

    .line 376
    .local v1, "column":I
    iget-object v7, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v7}, Lgnu/text/LineBufferedReader;->read()I

    move-result v0

    .line 377
    .local v0, "ch":I
    if-gez v0, :cond_1

    .line 378
    sget-object v8, Lgnu/lists/Sequence;->eofValue:Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 387
    iput v5, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    .line 388
    iget-object v7, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    check-cast v7, Lgnu/mapping/InPort;

    iput-char v4, v7, Lgnu/mapping/InPort;->readState:C

    move-object v7, v8

    :goto_0
    return-object v7

    .line 379
    :cond_1
    :try_start_1
    invoke-virtual {p0, v0, v3}, Lgnu/kawa/lispexpr/LispReader;->readValues(ILgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;

    move-result-object v6

    .line 380
    .local v6, "value":Ljava/lang/Object;
    sget-object v7, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    if-eq v6, v7, :cond_0

    .line 382
    invoke-virtual {p0, v6, v3, v2, v1}, Lgnu/kawa/lispexpr/LispReader;->handlePostfix(Ljava/lang/Object;Lgnu/kawa/lispexpr/ReadTable;II)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v8

    .line 387
    iput v5, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    .line 388
    iget-object v7, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    check-cast v7, Lgnu/mapping/InPort;

    iput-char v4, v7, Lgnu/mapping/InPort;->readState:C

    move-object v7, v8

    goto :goto_0

    .line 387
    .end local v0    # "ch":I
    .end local v1    # "column":I
    .end local v2    # "line":I
    .end local v3    # "rtable":Lgnu/kawa/lispexpr/ReadTable;
    .end local v6    # "value":Ljava/lang/Object;
    :catchall_0
    move-exception v7

    move-object v8, v7

    iput v5, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    .line 388
    iget-object v7, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    check-cast v7, Lgnu/mapping/InPort;

    iput-char v4, v7, Lgnu/mapping/InPort;->readState:C

    throw v8
.end method

.method public final readObject(I)Ljava/lang/Object;
    .locals 1
    .param p1, "c"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 1078
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->unread(I)V

    .line 1079
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->readObject()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method readToken(ICLgnu/kawa/lispexpr/ReadTable;)V
    .locals 8
    .param p1, "ch"    # I
    .param p2, "readCase"    # C
    .param p3, "rtable"    # Lgnu/kawa/lispexpr/ReadTable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    const v7, 0xffff

    const/4 v5, 0x1

    .line 269
    const/4 v2, 0x0

    .line 270
    .local v2, "inEscapes":Z
    const/4 v0, 0x0

    .line 273
    .local v0, "braceNesting":I
    :goto_0
    if-gez p1, :cond_0

    .line 275
    if-eqz v2, :cond_3

    .line 276
    const-string v6, "unexpected EOF between escapes"

    invoke-virtual {p0, v6}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;)V

    .line 280
    :cond_0
    invoke-virtual {p3, p1}, Lgnu/kawa/lispexpr/ReadTable;->lookup(I)Lgnu/kawa/lispexpr/ReadTableEntry;

    move-result-object v1

    .line 281
    .local v1, "entry":Lgnu/kawa/lispexpr/ReadTableEntry;
    invoke-virtual {v1}, Lgnu/kawa/lispexpr/ReadTableEntry;->getKind()I

    move-result v3

    .line 282
    .local v3, "kind":I
    if-nez v3, :cond_4

    .line 284
    if-eqz v2, :cond_1

    .line 286
    invoke-virtual {p0, v7}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    .line 287
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    .line 271
    :goto_1
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    goto :goto_0

    .line 290
    :cond_1
    const/16 v6, 0x7d

    if-ne p1, v6, :cond_2

    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_2

    .line 292
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    goto :goto_1

    .line 295
    :cond_2
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->unread(I)V

    .line 361
    .end local v1    # "entry":Lgnu/kawa/lispexpr/ReadTableEntry;
    .end local v3    # "kind":I
    :cond_3
    :goto_2
    return-void

    .line 298
    .restart local v1    # "entry":Lgnu/kawa/lispexpr/ReadTableEntry;
    .restart local v3    # "kind":I
    :cond_4
    iget-char v6, p3, Lgnu/kawa/lispexpr/ReadTable;->postfixLookupOperator:C

    if-ne p1, v6, :cond_6

    if-nez v2, :cond_6

    .line 300
    iget-object v6, p0, Lgnu/kawa/lispexpr/LispReader;->port:Lgnu/text/LineBufferedReader;

    invoke-virtual {v6}, Lgnu/text/LineBufferedReader;->peek()I

    move-result v4

    .line 301
    .local v4, "next":I
    iget-char v6, p3, Lgnu/kawa/lispexpr/ReadTable;->postfixLookupOperator:C

    if-ne v4, v6, :cond_5

    .line 303
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->unread(I)V

    goto :goto_2

    .line 306
    :cond_5
    invoke-virtual {p0, v4, p3}, Lgnu/kawa/lispexpr/LispReader;->validPostfixLookupStart(ILgnu/kawa/lispexpr/ReadTable;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 307
    const/4 v3, 0x5

    .line 310
    .end local v4    # "next":I
    :cond_6
    const/4 v6, 0x3

    if-ne v3, v6, :cond_a

    .line 312
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result p1

    .line 313
    if-gez p1, :cond_7

    .line 314
    const-string v6, "unexpected EOF after single escape"

    invoke-virtual {p0, v6}, Lgnu/kawa/lispexpr/LispReader;->eofError(Ljava/lang/String;)V

    .line 315
    :cond_7
    iget-boolean v6, p3, Lgnu/kawa/lispexpr/ReadTable;->hexEscapeAfterBackslash:Z

    if-eqz v6, :cond_9

    const/16 v6, 0x78

    if-eq p1, v6, :cond_8

    const/16 v6, 0x58

    if-ne p1, v6, :cond_9

    .line 317
    :cond_8
    invoke-virtual {p0}, Lgnu/kawa/lispexpr/LispReader;->readHexEscape()I

    move-result p1

    .line 318
    :cond_9
    invoke-virtual {p0, v7}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    .line 319
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    .line 320
    iput-boolean v5, p0, Lgnu/kawa/lispexpr/LispReader;->seenEscapes:Z

    goto :goto_1

    .line 323
    :cond_a
    const/4 v6, 0x4

    if-ne v3, v6, :cond_c

    .line 325
    if-nez v2, :cond_b

    move v2, v5

    .line 326
    :goto_3
    iput-boolean v5, p0, Lgnu/kawa/lispexpr/LispReader;->seenEscapes:Z

    goto :goto_1

    .line 325
    :cond_b
    const/4 v2, 0x0

    goto :goto_3

    .line 329
    :cond_c
    if-eqz v2, :cond_d

    .line 332
    invoke-virtual {p0, v7}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    .line 333
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    goto :goto_1

    .line 338
    :cond_d
    packed-switch v3, :pswitch_data_0

    :pswitch_0
    goto :goto_1

    .line 356
    :pswitch_1
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->unread(I)V

    goto :goto_2

    .line 341
    :pswitch_2
    const/16 v6, 0x7b

    if-ne p1, v6, :cond_e

    sget-object v6, Lgnu/kawa/lispexpr/ReadTableEntry;->brace:Lgnu/kawa/lispexpr/ReadTableEntry;

    if-ne v1, v6, :cond_e

    .line 342
    add-int/lit8 v0, v0, 0x1

    .line 345
    :cond_e
    :pswitch_3
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->tokenBufferAppend(I)V

    goto :goto_1

    .line 348
    :pswitch_4
    const/4 v2, 0x1

    .line 349
    iput-boolean v5, p0, Lgnu/kawa/lispexpr/LispReader;->seenEscapes:Z

    goto/16 :goto_1

    .line 352
    :pswitch_5
    invoke-virtual {p0, p1}, Lgnu/kawa/lispexpr/LispReader;->unread(I)V

    goto :goto_2

    .line 338
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_4
        :pswitch_5
        :pswitch_3
    .end packed-switch
.end method

.method public readValues(ILgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;
    .locals 1
    .param p1, "ch"    # I
    .param p2, "rtable"    # Lgnu/kawa/lispexpr/ReadTable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 94
    invoke-virtual {p2, p1}, Lgnu/kawa/lispexpr/ReadTable;->lookup(I)Lgnu/kawa/lispexpr/ReadTableEntry;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p2}, Lgnu/kawa/lispexpr/LispReader;->readValues(ILgnu/kawa/lispexpr/ReadTableEntry;Lgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public readValues(ILgnu/kawa/lispexpr/ReadTableEntry;Lgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;
    .locals 5
    .param p1, "ch"    # I
    .param p2, "entry"    # Lgnu/kawa/lispexpr/ReadTableEntry;
    .param p3, "rtable"    # Lgnu/kawa/lispexpr/ReadTable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 103
    iget v2, p0, Lgnu/kawa/lispexpr/LispReader;->tokenBufferLength:I

    .line 105
    .local v2, "startPos":I
    const/4 v3, 0x0

    iput-boolean v3, p0, Lgnu/kawa/lispexpr/LispReader;->seenEscapes:Z

    .line 106
    invoke-virtual {p2}, Lgnu/kawa/lispexpr/ReadTableEntry;->getKind()I

    move-result v1

    .line 107
    .local v1, "kind":I
    packed-switch v1, :pswitch_data_0

    .line 127
    :pswitch_0
    invoke-virtual {p0, p1, v2, p3}, Lgnu/kawa/lispexpr/LispReader;->readAndHandleToken(IILgnu/kawa/lispexpr/ReadTable;)Ljava/lang/Object;

    move-result-object v3

    :goto_0
    return-object v3

    .line 111
    :pswitch_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "invalid character #\\"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    int-to-char v4, p1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 112
    .local v0, "err":Ljava/lang/String;
    iget-boolean v3, p0, Lgnu/kawa/lispexpr/LispReader;->interactive:Z

    if-eqz v3, :cond_0

    invoke-virtual {p0, v0}, Lgnu/kawa/lispexpr/LispReader;->fatal(Ljava/lang/String;)V

    .line 114
    :goto_1
    sget-object v3, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    goto :goto_0

    .line 113
    :cond_0
    invoke-virtual {p0, v0}, Lgnu/kawa/lispexpr/LispReader;->error(Ljava/lang/String;)V

    goto :goto_1

    .line 117
    .end local v0    # "err":Ljava/lang/String;
    :pswitch_2
    sget-object v3, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    goto :goto_0

    .line 120
    :pswitch_3
    const/4 v3, -0x1

    invoke-virtual {p2, p0, p1, v3}, Lgnu/kawa/lispexpr/ReadTableEntry;->read(Lgnu/text/Lexer;II)Ljava/lang/Object;

    move-result-object v3

    goto :goto_0

    .line 107
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_3
    .end packed-switch
.end method

.method protected setCdr(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "pair"    # Ljava/lang/Object;
    .param p2, "cdr"    # Ljava/lang/Object;

    .prologue
    .line 1112
    check-cast p1, Lgnu/lists/Pair;

    .end local p1    # "pair":Ljava/lang/Object;
    invoke-virtual {p1, p2}, Lgnu/lists/Pair;->setCdrBackdoor(Ljava/lang/Object;)V

    .line 1113
    return-void
.end method

.method protected validPostfixLookupStart(ILgnu/kawa/lispexpr/ReadTable;)Z
    .locals 4
    .param p1, "ch"    # I
    .param p2, "rtable"    # Lgnu/kawa/lispexpr/ReadTable;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 395
    if-ltz p1, :cond_0

    const/16 v3, 0x3a

    if-eq p1, v3, :cond_0

    iget-char v3, p2, Lgnu/kawa/lispexpr/ReadTable;->postfixLookupOperator:C

    if-ne p1, v3, :cond_1

    .line 400
    :cond_0
    :goto_0
    return v1

    .line 397
    :cond_1
    const/16 v3, 0x2c

    if-ne p1, v3, :cond_2

    move v1, v2

    .line 398
    goto :goto_0

    .line 399
    :cond_2
    invoke-virtual {p2, p1}, Lgnu/kawa/lispexpr/ReadTable;->lookup(I)Lgnu/kawa/lispexpr/ReadTableEntry;

    move-result-object v3

    invoke-virtual {v3}, Lgnu/kawa/lispexpr/ReadTableEntry;->getKind()I

    move-result v0

    .line 400
    .local v0, "kind":I
    const/4 v3, 0x2

    if-eq v0, v3, :cond_3

    const/4 v3, 0x6

    if-eq v0, v3, :cond_3

    const/4 v3, 0x4

    if-eq v0, v3, :cond_3

    const/4 v3, 0x3

    if-ne v0, v3, :cond_0

    :cond_3
    move v1, v2

    goto :goto_0
.end method
