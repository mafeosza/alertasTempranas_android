.class public Lkawa/lang/Quote;
.super Lkawa/lang/Syntax;
.source "Quote.java"


# static fields
.field private static final CYCLE:Ljava/lang/Object;

.field protected static final QUOTE_DEPTH:I = -0x1

.field private static final WORKING:Ljava/lang/Object;

.field static final appendMethod:Lgnu/bytecode/Method;

.field static final consXMethod:Lgnu/bytecode/Method;

.field static final makePairMethod:Lgnu/bytecode/Method;

.field static final makeVectorMethod:Lgnu/bytecode/Method;

.field public static final plainQuote:Lkawa/lang/Quote;

.field public static final quasiQuote:Lkawa/lang/Quote;

.field static final quoteType:Lgnu/bytecode/ClassType;

.field static final vectorAppendMethod:Lgnu/bytecode/Method;


# instance fields
.field protected isQuasi:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 21
    new-instance v0, Lkawa/lang/Quote;

    const-string v1, "quote"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lkawa/lang/Quote;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lkawa/lang/Quote;->plainQuote:Lkawa/lang/Quote;

    .line 22
    new-instance v0, Lkawa/lang/Quote;

    const-string v1, "quasiquote"

    invoke-direct {v0, v1, v3}, Lkawa/lang/Quote;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lkawa/lang/Quote;->quasiQuote:Lkawa/lang/Quote;

    .line 289
    new-instance v0, Ljava/lang/String;

    const-string v1, "(working)"

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    sput-object v0, Lkawa/lang/Quote;->WORKING:Ljava/lang/Object;

    .line 290
    new-instance v0, Ljava/lang/String;

    const-string v1, "(cycle)"

    invoke-direct {v0, v1}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    sput-object v0, Lkawa/lang/Quote;->CYCLE:Ljava/lang/Object;

    .line 475
    const-string v0, "kawa.standard.vector_append"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    const-string v1, "apply$V"

    invoke-virtual {v0, v1, v3}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lkawa/lang/Quote;->vectorAppendMethod:Lgnu/bytecode/Method;

    .line 478
    const-string v0, "kawa.lang.Quote"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    sput-object v0, Lkawa/lang/Quote;->quoteType:Lgnu/bytecode/ClassType;

    .line 479
    sget-object v0, Lkawa/lang/Quote;->quoteType:Lgnu/bytecode/ClassType;

    const-string v1, "consX$V"

    invoke-virtual {v0, v1, v3}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lkawa/lang/Quote;->consXMethod:Lgnu/bytecode/Method;

    .line 480
    sget-object v0, Lkawa/lang/Quote;->quoteType:Lgnu/bytecode/ClassType;

    const-string v1, "append$V"

    invoke-virtual {v0, v1, v3}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lkawa/lang/Quote;->appendMethod:Lgnu/bytecode/Method;

    .line 481
    sget-object v0, Lgnu/expr/Compilation;->typePair:Lgnu/bytecode/ClassType;

    const-string v1, "make"

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lkawa/lang/Quote;->makePairMethod:Lgnu/bytecode/Method;

    .line 482
    const-string v0, "gnu.lists.FVector"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    const-string v1, "make"

    invoke-virtual {v0, v1, v3}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v0

    sput-object v0, Lkawa/lang/Quote;->makeVectorMethod:Lgnu/bytecode/Method;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "isQuasi"    # Z

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lkawa/lang/Syntax;-><init>(Ljava/lang/Object;)V

    .line 27
    iput-boolean p2, p0, Lkawa/lang/Quote;->isQuasi:Z

    .line 28
    return-void
.end method

.method public static append$V([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 12
    .param p0, "args"    # [Ljava/lang/Object;

    .prologue
    .line 435
    array-length v2, p0

    .line 436
    .local v2, "count":I
    if-nez v2, :cond_1

    .line 437
    sget-object v10, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .line 472
    :cond_0
    return-object v10

    .line 438
    :cond_1
    add-int/lit8 v10, v2, -0x1

    aget-object v8, p0, v10

    .line 439
    .local v8, "result":Ljava/lang/Object;
    add-int/lit8 v3, v2, -0x1

    .local v3, "i":I
    move-object v10, v8

    .end local v8    # "result":Ljava/lang/Object;
    :goto_0
    add-int/lit8 v3, v3, -0x1

    if-ltz v3, :cond_0

    .line 441
    aget-object v5, p0, v3

    .line 442
    .local v5, "list":Ljava/lang/Object;
    const/4 v1, 0x0

    .line 443
    .local v1, "copy":Ljava/lang/Object;
    const/4 v4, 0x0

    .line 444
    .local v4, "last":Lgnu/lists/Pair;
    const/4 v9, 0x0

    .local v9, "syntax":Lkawa/lang/SyntaxForm;
    move-object v8, v1

    .line 447
    .end local v1    # "copy":Ljava/lang/Object;
    :goto_1
    instance-of v11, v5, Lkawa/lang/SyntaxForm;

    if-eqz v11, :cond_2

    move-object v9, v5

    .line 449
    check-cast v9, Lkawa/lang/SyntaxForm;

    .line 450
    invoke-interface {v9}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v5

    goto :goto_1

    .line 452
    :cond_2
    sget-object v11, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v5, v11, :cond_3

    .line 466
    if-eqz v4, :cond_6

    .line 468
    invoke-virtual {v4, v10}, Lgnu/lists/Pair;->setCdr(Ljava/lang/Object;)V

    :goto_2
    move-object v10, v8

    .line 471
    goto :goto_0

    :cond_3
    move-object v6, v5

    .line 454
    check-cast v6, Lgnu/lists/Pair;

    .line 455
    .local v6, "list_pair":Lgnu/lists/Pair;
    invoke-virtual {v6}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v0

    .line 456
    .local v0, "car":Ljava/lang/Object;
    if-eqz v9, :cond_4

    instance-of v11, v0, Lkawa/lang/SyntaxForm;

    if-nez v11, :cond_4

    .line 457
    invoke-interface {v9}, Lkawa/lang/SyntaxForm;->getScope()Lkawa/lang/TemplateScope;

    move-result-object v11

    invoke-static {v0, v11}, Lkawa/lang/SyntaxForms;->makeForm(Ljava/lang/Object;Lkawa/lang/TemplateScope;)Ljava/lang/Object;

    move-result-object v0

    .line 458
    :cond_4
    new-instance v7, Lgnu/lists/Pair;

    const/4 v11, 0x0

    invoke-direct {v7, v0, v11}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 459
    .local v7, "new_pair":Lgnu/lists/Pair;
    if-nez v4, :cond_5

    .line 460
    move-object v1, v7

    .line 463
    :goto_3
    move-object v4, v7

    .line 464
    invoke-virtual {v6}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v5

    move-object v8, v1

    .line 465
    goto :goto_1

    .line 462
    :cond_5
    invoke-virtual {v4, v7}, Lgnu/lists/Pair;->setCdr(Ljava/lang/Object;)V

    move-object v1, v8

    goto :goto_3

    .end local v0    # "car":Ljava/lang/Object;
    .end local v6    # "list_pair":Lgnu/lists/Pair;
    .end local v7    # "new_pair":Lgnu/lists/Pair;
    :cond_6
    move-object v8, v10

    goto :goto_2
.end method

.method public static consX$V([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "args"    # [Ljava/lang/Object;

    .prologue
    .line 429
    invoke-static {p0}, Lgnu/lists/LList;->consX([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method private static makeInvokeMakeVector([Lgnu/expr/Expression;)Lgnu/expr/ApplyExp;
    .locals 2
    .param p0, "args"    # [Lgnu/expr/Expression;

    .prologue
    .line 414
    new-instance v0, Lgnu/expr/ApplyExp;

    sget-object v1, Lkawa/lang/Quote;->makeVectorMethod:Lgnu/bytecode/Method;

    invoke-direct {v0, v1, p0}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    return-object v0
.end method

.method public static makeSymbol(Lgnu/mapping/Namespace;Ljava/lang/Object;)Lgnu/mapping/Symbol;
    .locals 2
    .param p0, "ns"    # Lgnu/mapping/Namespace;
    .param p1, "local"    # Ljava/lang/Object;

    .prologue
    .line 79
    instance-of v1, p1, Ljava/lang/CharSequence;

    if-eqz v1, :cond_0

    .line 80
    check-cast p1, Ljava/lang/CharSequence;

    .end local p1    # "local":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 87
    .local v0, "name":Ljava/lang/String;
    :goto_0
    invoke-virtual {v0}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lgnu/mapping/Namespace;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v1

    return-object v1

    .end local v0    # "name":Ljava/lang/String;
    .restart local p1    # "local":Ljava/lang/Object;
    :cond_0
    move-object v0, p1

    .line 86
    check-cast v0, Ljava/lang/String;

    .restart local v0    # "name":Ljava/lang/String;
    goto :goto_0
.end method

.method public static quote(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    .line 57
    sget-object v1, Lkawa/lang/Quote;->plainQuote:Lkawa/lang/Quote;

    const/4 v2, -0x1

    invoke-static {}, Lgnu/expr/Compilation;->getCurrent()Lgnu/expr/Compilation;

    move-result-object v0

    check-cast v0, Lkawa/lang/Translator;

    invoke-virtual {v1, p0, v2, v0}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static quote(Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;
    .locals 2
    .param p0, "obj"    # Ljava/lang/Object;
    .param p1, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 50
    sget-object v0, Lkawa/lang/Quote;->plainQuote:Lkawa/lang/Quote;

    const/4 v1, -0x1

    invoke-virtual {v0, p0, v1, p1}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method protected coerceExpression(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "val"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 62
    instance-of v0, p1, Lgnu/expr/Expression;

    if-eqz v0, :cond_0

    check-cast p1, Lgnu/expr/Expression;

    .end local p1    # "val":Ljava/lang/Object;
    :goto_0
    return-object p1

    .restart local p1    # "val":Ljava/lang/Object;
    :cond_0
    invoke-virtual {p0, p1, p2}, Lkawa/lang/Quote;->leaf(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object p1

    goto :goto_0
.end method

.method expand(Ljava/lang/Object;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;
    .locals 22
    .param p1, "template"    # Ljava/lang/Object;
    .param p2, "depth"    # I
    .param p3, "syntax"    # Lkawa/lang/SyntaxForm;
    .param p4, "seen"    # Ljava/lang/Object;
    .param p5, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 305
    move-object/from16 v13, p4

    check-cast v13, Ljava/util/IdentityHashMap;

    .line 306
    .local v13, "map":Ljava/util/IdentityHashMap;
    move-object/from16 v0, p1

    invoke-virtual {v13, v0}, Ljava/util/IdentityHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    .line 307
    .local v16, "old":Ljava/lang/Object;
    sget-object v3, Lkawa/lang/Quote;->WORKING:Ljava/lang/Object;

    move-object/from16 v0, v16

    if-ne v0, v3, :cond_1

    .line 309
    sget-object v3, Lkawa/lang/Quote;->CYCLE:Ljava/lang/Object;

    move-object/from16 v0, p1

    invoke-virtual {v13, v0, v3}, Ljava/util/IdentityHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 409
    .end local v16    # "old":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-object v16

    .line 312
    .restart local v16    # "old":Ljava/lang/Object;
    :cond_1
    sget-object v3, Lkawa/lang/Quote;->CYCLE:Ljava/lang/Object;

    move-object/from16 v0, v16

    if-eq v0, v3, :cond_0

    .line 316
    if-nez v16, :cond_0

    .line 320
    move-object/from16 v0, p1

    instance-of v3, v0, Lgnu/lists/Pair;

    if-eqz v3, :cond_3

    move-object/from16 v4, p1

    .line 321
    check-cast v4, Lgnu/lists/Pair;

    move-object/from16 v3, p0

    move/from16 v5, p2

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p5

    invoke-virtual/range {v3 .. v8}, Lkawa/lang/Quote;->expand_pair(Lgnu/lists/Pair;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v19

    .local v19, "result":Ljava/lang/Object;
    move-object/from16 v16, v19

    .line 405
    .end local v16    # "old":Ljava/lang/Object;
    .end local v19    # "result":Ljava/lang/Object;
    :goto_1
    move-object/from16 v0, p1

    move-object/from16 v1, v16

    if-eq v0, v1, :cond_2

    move-object/from16 v0, p1

    invoke-virtual {v13, v0}, Ljava/util/IdentityHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    sget-object v6, Lkawa/lang/Quote;->CYCLE:Ljava/lang/Object;

    if-ne v3, v6, :cond_2

    .line 406
    const/16 v3, 0x65

    const-string v6, "cycle in non-literal data"

    move-object/from16 v0, p5

    invoke-virtual {v0, v3, v6}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 407
    :cond_2
    move-object/from16 v0, p1

    move-object/from16 v1, v16

    invoke-virtual {v13, v0, v1}, Ljava/util/IdentityHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 322
    .restart local v16    # "old":Ljava/lang/Object;
    :cond_3
    move-object/from16 v0, p1

    instance-of v3, v0, Lkawa/lang/SyntaxForm;

    if-eqz v3, :cond_4

    move-object/from16 p3, p1

    .line 324
    check-cast p3, Lkawa/lang/SyntaxForm;

    .line 325
    invoke-interface/range {p3 .. p3}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v4

    move-object/from16 v3, p0

    move/from16 v5, p2

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p5

    invoke-virtual/range {v3 .. v8}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v19

    .restart local v19    # "result":Ljava/lang/Object;
    move-object/from16 v16, v19

    goto :goto_1

    .line 327
    .end local v19    # "result":Ljava/lang/Object;
    :cond_4
    move-object/from16 v0, p1

    instance-of v3, v0, Lgnu/lists/FVector;

    if-eqz v3, :cond_13

    move-object/from16 v21, p1

    .line 329
    check-cast v21, Lgnu/lists/FVector;

    .line 330
    .local v21, "vector":Lgnu/lists/FVector;
    invoke-virtual/range {v21 .. v21}, Lgnu/lists/FVector;->size()I

    move-result v15

    .line 331
    .local v15, "n":I
    new-array v11, v15, [Ljava/lang/Object;

    .line 337
    .local v11, "buffer":[Ljava/lang/Object;
    new-array v0, v15, [B

    move-object/from16 v20, v0

    .line 338
    .local v20, "state":[B
    const/4 v14, 0x0

    .line 339
    .local v14, "max_state":B
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_2
    if-ge v12, v15, :cond_b

    .line 341
    move-object/from16 v0, v21

    invoke-virtual {v0, v12}, Lgnu/lists/FVector;->get(I)Ljava/lang/Object;

    move-result-object v4

    .line 342
    .local v4, "element":Ljava/lang/Object;
    move/from16 v5, p2

    .line 344
    .local v5, "element_depth":I
    instance-of v3, v4, Lgnu/lists/Pair;

    if-eqz v3, :cond_8

    const/4 v3, -0x1

    move/from16 v0, p2

    if-le v0, v3, :cond_8

    move-object/from16 v17, v4

    check-cast v17, Lgnu/lists/Pair;

    .local v17, "pair":Lgnu/lists/Pair;
    invoke-virtual/range {v17 .. v17}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    const-string v6, "unquote-splicing"

    move-object/from16 v0, p5

    move-object/from16 v1, p3

    invoke-virtual {v0, v3, v1, v6}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_8

    add-int/lit8 v5, v5, -0x1

    if-nez v5, :cond_8

    .line 350
    invoke-virtual/range {v17 .. v17}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    instance-of v3, v3, Lgnu/lists/Pair;

    if-eqz v3, :cond_5

    invoke-virtual/range {v17 .. v17}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lgnu/lists/Pair;

    .local v18, "pair_cdr":Lgnu/lists/Pair;
    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    sget-object v6, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v3, v6, :cond_6

    .line 352
    .end local v18    # "pair_cdr":Lgnu/lists/Pair;
    :cond_5
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "invalid used of "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {v17 .. v17}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, " in quasiquote template"

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p5

    invoke-virtual {v0, v3}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v16

    goto/16 :goto_0

    .line 354
    .restart local v18    # "pair_cdr":Lgnu/lists/Pair;
    :cond_6
    move-object/from16 v0, p5

    move-object/from16 v1, v18

    move-object/from16 v2, p3

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v3

    aput-object v3, v11, v12

    .line 355
    const/4 v3, 0x3

    aput-byte v3, v20, v12

    .line 367
    .end local v17    # "pair":Lgnu/lists/Pair;
    .end local v18    # "pair_cdr":Lgnu/lists/Pair;
    :goto_3
    aget-byte v3, v20, v12

    if-le v3, v14, :cond_7

    .line 368
    aget-byte v14, v20, v12

    .line 339
    :cond_7
    add-int/lit8 v12, v12, 0x1

    goto :goto_2

    :cond_8
    move-object/from16 v3, p0

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p5

    .line 359
    invoke-virtual/range {v3 .. v8}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v3

    aput-object v3, v11, v12

    .line 360
    aget-object v3, v11, v12

    if-ne v3, v4, :cond_9

    .line 361
    const/4 v3, 0x0

    aput-byte v3, v20, v12

    goto :goto_3

    .line 362
    :cond_9
    aget-object v3, v11, v12

    instance-of v3, v3, Lgnu/expr/Expression;

    if-eqz v3, :cond_a

    .line 363
    const/4 v3, 0x2

    aput-byte v3, v20, v12

    goto :goto_3

    .line 365
    :cond_a
    const/4 v3, 0x1

    aput-byte v3, v20, v12

    goto :goto_3

    .line 370
    .end local v4    # "element":Ljava/lang/Object;
    .end local v5    # "element_depth":I
    :cond_b
    if-nez v14, :cond_c

    .line 371
    move-object/from16 v19, v21

    :goto_4
    move-object/from16 v16, v19

    .line 401
    goto/16 :goto_1

    .line 372
    :cond_c
    const/4 v3, 0x1

    if-ne v14, v3, :cond_d

    .line 373
    new-instance v19, Lgnu/lists/FVector;

    move-object/from16 v0, v19

    invoke-direct {v0, v11}, Lgnu/lists/FVector;-><init>([Ljava/lang/Object;)V

    .local v19, "result":Lgnu/lists/FVector;
    goto :goto_4

    .line 376
    .end local v19    # "result":Lgnu/lists/FVector;
    :cond_d
    new-array v10, v15, [Lgnu/expr/Expression;

    .line 377
    .local v10, "args":[Lgnu/expr/Expression;
    const/4 v12, 0x0

    :goto_5
    if-ge v12, v15, :cond_11

    .line 379
    aget-byte v3, v20, v12

    const/4 v6, 0x3

    if-ne v3, v6, :cond_e

    .line 380
    aget-object v3, v11, v12

    check-cast v3, Lgnu/expr/Expression;

    aput-object v3, v10, v12

    .line 377
    :goto_6
    add-int/lit8 v12, v12, 0x1

    goto :goto_5

    .line 381
    :cond_e
    const/4 v3, 0x3

    if-ge v14, v3, :cond_f

    .line 382
    aget-object v3, v11, v12

    move-object/from16 v0, p0

    move-object/from16 v1, p5

    invoke-virtual {v0, v3, v1}, Lkawa/lang/Quote;->coerceExpression(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v3

    aput-object v3, v10, v12

    goto :goto_6

    .line 383
    :cond_f
    aget-byte v3, v20, v12

    const/4 v6, 0x2

    if-ge v3, v6, :cond_10

    .line 385
    const/4 v3, 0x1

    new-array v9, v3, [Ljava/lang/Object;

    .line 386
    .local v9, "arg1":[Ljava/lang/Object;
    const/4 v3, 0x0

    aget-object v6, v11, v12

    aput-object v6, v9, v3

    .line 387
    new-instance v3, Lgnu/lists/FVector;

    invoke-direct {v3, v9}, Lgnu/lists/FVector;-><init>([Ljava/lang/Object;)V

    move-object/from16 v0, p0

    move-object/from16 v1, p5

    invoke-virtual {v0, v3, v1}, Lkawa/lang/Quote;->leaf(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v3

    aput-object v3, v10, v12

    goto :goto_6

    .line 391
    .end local v9    # "arg1":[Ljava/lang/Object;
    :cond_10
    const/4 v3, 0x1

    new-array v9, v3, [Lgnu/expr/Expression;

    .line 392
    .local v9, "arg1":[Lgnu/expr/Expression;
    const/4 v6, 0x0

    aget-object v3, v11, v12

    check-cast v3, Lgnu/expr/Expression;

    aput-object v3, v9, v6

    .line 393
    invoke-static {v9}, Lkawa/lang/Quote;->makeInvokeMakeVector([Lgnu/expr/Expression;)Lgnu/expr/ApplyExp;

    move-result-object v3

    aput-object v3, v10, v12

    goto :goto_6

    .line 396
    .end local v9    # "arg1":[Lgnu/expr/Expression;
    :cond_11
    const/4 v3, 0x3

    if-ge v14, v3, :cond_12

    .line 397
    invoke-static {v10}, Lkawa/lang/Quote;->makeInvokeMakeVector([Lgnu/expr/Expression;)Lgnu/expr/ApplyExp;

    move-result-object v19

    .local v19, "result":Lgnu/expr/ApplyExp;
    goto :goto_4

    .line 399
    .end local v19    # "result":Lgnu/expr/ApplyExp;
    :cond_12
    new-instance v19, Lgnu/expr/ApplyExp;

    sget-object v3, Lkawa/lang/Quote;->vectorAppendMethod:Lgnu/bytecode/Method;

    move-object/from16 v0, v19

    invoke-direct {v0, v3, v10}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    .restart local v19    # "result":Lgnu/expr/ApplyExp;
    goto :goto_4

    .line 403
    .end local v10    # "args":[Lgnu/expr/Expression;
    .end local v11    # "buffer":[Ljava/lang/Object;
    .end local v12    # "i":I
    .end local v14    # "max_state":B
    .end local v15    # "n":I
    .end local v19    # "result":Lgnu/expr/ApplyExp;
    .end local v20    # "state":[B
    .end local v21    # "vector":Lgnu/lists/FVector;
    :cond_13
    move-object/from16 v19, p1

    .local v19, "result":Ljava/lang/Object;
    move-object/from16 v16, v19

    goto/16 :goto_1
.end method

.method protected expand(Ljava/lang/Object;ILkawa/lang/Translator;)Ljava/lang/Object;
    .locals 6
    .param p1, "template"    # Ljava/lang/Object;
    .param p2, "depth"    # I
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 39
    new-instance v4, Ljava/util/IdentityHashMap;

    invoke-direct {v4}, Ljava/util/IdentityHashMap;-><init>()V

    .line 43
    .local v4, "seen":Ljava/util/IdentityHashMap;
    const/4 v3, 0x0

    move-object v0, p0

    move-object v1, p1

    move v2, p2

    move-object v5, p3

    invoke-virtual/range {v0 .. v5}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected expandColonForms()Z
    .locals 1

    .prologue
    .line 72
    const/4 v0, 0x1

    return v0
.end method

.method expand_pair(Lgnu/lists/Pair;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;
    .locals 38
    .param p1, "list"    # Lgnu/lists/Pair;
    .param p2, "depth"    # I
    .param p3, "syntax"    # Lkawa/lang/SyntaxForm;
    .param p4, "seen"    # Ljava/lang/Object;
    .param p5, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 93
    move-object/from16 v25, p1

    .line 101
    .local v25, "pair":Lgnu/lists/Pair;
    :goto_0
    move-object/from16 v30, v25

    .line 107
    .local v30, "rest":Lgnu/lists/Pair;
    invoke-virtual/range {p0 .. p0}, Lkawa/lang/Quote;->expandColonForms()Z

    move-result v3

    if-eqz v3, :cond_4

    move-object/from16 v0, v25

    move-object/from16 v1, p1

    if-ne v0, v1, :cond_4

    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    sget-object v5, Lgnu/kawa/lispexpr/LispLanguage;->lookup_sym:Lgnu/mapping/Symbol;

    move-object/from16 v0, p5

    move-object/from16 v1, p3

    invoke-virtual {v0, v3, v1, v5}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Lgnu/mapping/Symbol;)Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    instance-of v3, v3, Lgnu/lists/Pair;

    if-eqz v3, :cond_4

    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Lgnu/lists/Pair;

    .local v23, "p1":Lgnu/lists/Pair;
    move-object/from16 v0, v23

    instance-of v3, v0, Lgnu/lists/Pair;

    if-eqz v3, :cond_4

    invoke-virtual/range {v23 .. v23}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v24

    check-cast v24, Lgnu/lists/Pair;

    .local v24, "p2":Lgnu/lists/Pair;
    move-object/from16 v0, v24

    instance-of v3, v0, Lgnu/lists/Pair;

    if-eqz v3, :cond_4

    invoke-virtual/range {v24 .. v24}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    sget-object v5, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v3, v5, :cond_4

    .line 115
    const/4 v3, 0x0

    move-object/from16 v0, p5

    move-object/from16 v1, v23

    invoke-virtual {v0, v1, v3}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Z)Lgnu/expr/Expression;

    move-result-object v28

    .line 116
    .local v28, "part1":Lgnu/expr/Expression;
    const/4 v3, 0x0

    move-object/from16 v0, p5

    move-object/from16 v1, v24

    invoke-virtual {v0, v1, v3}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Z)Lgnu/expr/Expression;

    move-result-object v29

    .line 117
    .local v29, "part2":Lgnu/expr/Expression;
    move-object/from16 v0, p5

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->namespaceResolvePrefix(Lgnu/expr/Expression;)Lgnu/mapping/Namespace;

    move-result-object v20

    .line 118
    .local v20, "ns":Lgnu/mapping/Namespace;
    move-object/from16 v0, p5

    move-object/from16 v1, v20

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->namespaceResolve(Lgnu/mapping/Namespace;Lgnu/expr/Expression;)Lgnu/mapping/Symbol;

    move-result-object v35

    .line 120
    .local v35, "sym":Lgnu/mapping/Symbol;
    if-eqz v35, :cond_0

    .line 121
    move-object/from16 v13, v35

    .local v13, "cdr":Lgnu/mapping/Symbol;
    move-object/from16 v4, v30

    .local v4, "rest":Ljava/lang/Object;
    move-object v3, v13

    .line 245
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v13    # "cdr":Lgnu/mapping/Symbol;
    .end local v20    # "ns":Lgnu/mapping/Namespace;
    .end local v23    # "p1":Lgnu/lists/Pair;
    .end local v24    # "p2":Lgnu/lists/Pair;
    .end local v28    # "part1":Lgnu/expr/Expression;
    .end local v29    # "part2":Lgnu/expr/Expression;
    .end local v30    # "rest":Lgnu/lists/Pair;
    .end local v35    # "sym":Lgnu/mapping/Symbol;
    :goto_1
    move-object/from16 v0, p1

    if-ne v0, v4, :cond_18

    .line 286
    :goto_2
    return-object v3

    .line 122
    .restart local v20    # "ns":Lgnu/mapping/Namespace;
    .restart local v23    # "p1":Lgnu/lists/Pair;
    .restart local v24    # "p2":Lgnu/lists/Pair;
    .restart local v28    # "part1":Lgnu/expr/Expression;
    .restart local v29    # "part2":Lgnu/expr/Expression;
    .restart local v30    # "rest":Lgnu/lists/Pair;
    .restart local v35    # "sym":Lgnu/mapping/Symbol;
    :cond_0
    if-eqz v20, :cond_1

    const/4 v3, 0x1

    move/from16 v0, p2

    if-ne v0, v3, :cond_1

    .line 123
    new-instance v13, Lgnu/expr/ApplyExp;

    sget-object v3, Lkawa/lang/Quote;->quoteType:Lgnu/bytecode/ClassType;

    const-string v5, "makeSymbol"

    const/4 v6, 0x2

    invoke-virtual {v3, v5, v6}, Lgnu/bytecode/ClassType;->getDeclaredMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v3

    const/4 v5, 0x2

    new-array v5, v5, [Lgnu/expr/Expression;

    const/4 v6, 0x0

    invoke-static/range {v20 .. v20}, Lgnu/expr/QuoteExp;->getInstance(Ljava/lang/Object;)Lgnu/expr/QuoteExp;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object v29, v5, v6

    invoke-direct {v13, v3, v5}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    .local v13, "cdr":Lgnu/expr/ApplyExp;
    move-object/from16 v4, v30

    .restart local v4    # "rest":Ljava/lang/Object;
    move-object v3, v13

    goto :goto_1

    .line 126
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v13    # "cdr":Lgnu/expr/ApplyExp;
    :cond_1
    move-object/from16 v0, v28

    instance-of v3, v0, Lgnu/expr/ReferenceExp;

    if-eqz v3, :cond_2

    move-object/from16 v0, v29

    instance-of v3, v0, Lgnu/expr/QuoteExp;

    if-eqz v3, :cond_2

    .line 128
    invoke-virtual/range {p5 .. p5}, Lkawa/lang/Translator;->getGlobalEnvironment()Lgnu/mapping/Environment;

    move-result-object v3

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    check-cast v28, Lgnu/expr/ReferenceExp;

    .end local v28    # "part1":Lgnu/expr/Expression;
    invoke-virtual/range {v28 .. v28}, Lgnu/expr/ReferenceExp;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v6, 0x3a

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    check-cast v29, Lgnu/expr/QuoteExp;

    .end local v29    # "part2":Lgnu/expr/Expression;
    invoke-virtual/range {v29 .. v29}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v13

    .local v13, "cdr":Lgnu/mapping/Symbol;
    move-object/from16 v4, v30

    .restart local v4    # "rest":Ljava/lang/Object;
    move-object v3, v13

    goto :goto_1

    .line 129
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v13    # "cdr":Lgnu/mapping/Symbol;
    .restart local v28    # "part1":Lgnu/expr/Expression;
    .restart local v29    # "part2":Lgnu/expr/Expression;
    :cond_2
    invoke-static/range {v28 .. v29}, Lgnu/kawa/functions/CompileNamedPart;->combineName(Lgnu/expr/Expression;Lgnu/expr/Expression;)Ljava/lang/String;

    move-result-object v14

    .local v14, "combinedName":Ljava/lang/String;
    if-eqz v14, :cond_3

    .line 130
    invoke-virtual/range {p5 .. p5}, Lkawa/lang/Translator;->getGlobalEnvironment()Lgnu/mapping/Environment;

    move-result-object v3

    invoke-virtual {v3, v14}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v13

    .restart local v13    # "cdr":Lgnu/mapping/Symbol;
    move-object/from16 v4, v30

    .restart local v4    # "rest":Ljava/lang/Object;
    move-object v3, v13

    goto :goto_1

    .line 133
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v13    # "cdr":Lgnu/mapping/Symbol;
    :cond_3
    move-object/from16 v0, p5

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->pushPositionOf(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v32

    .line 134
    .local v32, "save":Ljava/lang/Object;
    const/16 v3, 0x65

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual/range {v23 .. v23}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\' is not a valid prefix"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p5

    invoke-virtual {v0, v3, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 135
    move-object/from16 v0, p5

    move-object/from16 v1, v32

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    .line 136
    move-object/from16 v13, v35

    .restart local v13    # "cdr":Lgnu/mapping/Symbol;
    move-object/from16 v4, v30

    .restart local v4    # "rest":Ljava/lang/Object;
    move-object v3, v13

    .line 138
    goto/16 :goto_1

    .line 140
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v13    # "cdr":Lgnu/mapping/Symbol;
    .end local v14    # "combinedName":Ljava/lang/String;
    .end local v20    # "ns":Lgnu/mapping/Namespace;
    .end local v23    # "p1":Lgnu/lists/Pair;
    .end local v24    # "p2":Lgnu/lists/Pair;
    .end local v28    # "part1":Lgnu/expr/Expression;
    .end local v29    # "part2":Lgnu/expr/Expression;
    .end local v32    # "save":Ljava/lang/Object;
    .end local v35    # "sym":Lgnu/mapping/Symbol;
    :cond_4
    if-gez p2, :cond_6

    .line 162
    :cond_5
    :goto_3
    const/4 v3, 0x1

    move/from16 v0, p2

    if-ne v0, v3, :cond_13

    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    instance-of v3, v3, Lgnu/lists/Pair;

    if-eqz v3, :cond_13

    .line 164
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v15

    .line 165
    .local v15, "form":Ljava/lang/Object;
    move-object/from16 v34, p3

    .line 166
    .local v34, "subsyntax":Lkawa/lang/SyntaxForm;
    :goto_4
    instance-of v3, v15, Lkawa/lang/SyntaxForm;

    if-eqz v3, :cond_b

    move-object/from16 v34, v15

    .line 168
    check-cast v34, Lkawa/lang/SyntaxForm;

    .line 169
    invoke-interface/range {v34 .. v34}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v15

    goto :goto_4

    .line 143
    .end local v15    # "form":Ljava/lang/Object;
    .end local v34    # "subsyntax":Lkawa/lang/SyntaxForm;
    :cond_6
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    const-string v5, "quasiquote"

    move-object/from16 v0, p5

    move-object/from16 v1, p3

    invoke-virtual {v0, v3, v1, v5}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 144
    add-int/lit8 p2, p2, 0x1

    goto :goto_3

    .line 145
    :cond_7
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    const-string v5, "unquote"

    move-object/from16 v0, p5

    move-object/from16 v1, p3

    invoke-virtual {v0, v3, v1, v5}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 147
    add-int/lit8 p2, p2, -0x1

    .line 149
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    instance-of v3, v3, Lgnu/lists/Pair;

    if-eqz v3, :cond_8

    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Lgnu/lists/Pair;

    .local v26, "pair_cdr":Lgnu/lists/Pair;
    invoke-virtual/range {v26 .. v26}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    sget-object v5, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v3, v5, :cond_9

    .line 151
    .end local v26    # "pair_cdr":Lgnu/lists/Pair;
    :cond_8
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "invalid used of "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, " in quasiquote template"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p5

    invoke-virtual {v0, v3}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v3

    goto/16 :goto_2

    .line 153
    .restart local v26    # "pair_cdr":Lgnu/lists/Pair;
    :cond_9
    if-nez p2, :cond_5

    .line 155
    move-object/from16 v0, p5

    move-object/from16 v1, v26

    move-object/from16 v2, p3

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v13

    .local v13, "cdr":Lgnu/expr/Expression;
    move-object/from16 v4, v30

    .restart local v4    # "rest":Ljava/lang/Object;
    move-object v3, v13

    .line 156
    goto/16 :goto_1

    .line 159
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v13    # "cdr":Lgnu/expr/Expression;
    .end local v26    # "pair_cdr":Lgnu/lists/Pair;
    :cond_a
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    const-string v5, "unquote-splicing"

    move-object/from16 v0, p5

    move-object/from16 v1, p3

    invoke-virtual {v0, v3, v1, v5}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 160
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "invalid used of "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, " in quasiquote template"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p5

    invoke-virtual {v0, v3}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v3

    goto/16 :goto_2

    .line 171
    .restart local v15    # "form":Ljava/lang/Object;
    .restart local v34    # "subsyntax":Lkawa/lang/SyntaxForm;
    :cond_b
    const/16 v33, -0x1

    .line 172
    .local v33, "splicing":I
    instance-of v3, v15, Lgnu/lists/Pair;

    if-eqz v3, :cond_c

    move-object v3, v15

    .line 174
    check-cast v3, Lgnu/lists/Pair;

    invoke-virtual {v3}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v21

    .line 175
    .local v21, "op":Ljava/lang/Object;
    const-string v3, "unquote"

    move-object/from16 v0, p5

    move-object/from16 v1, v21

    move-object/from16 v2, v34

    invoke-virtual {v0, v1, v2, v3}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_f

    .line 176
    const/16 v33, 0x0

    .line 180
    .end local v21    # "op":Ljava/lang/Object;
    :cond_c
    :goto_5
    if-ltz v33, :cond_13

    .line 182
    check-cast v15, Lgnu/lists/Pair;

    .end local v15    # "form":Ljava/lang/Object;
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v15

    .line 183
    .restart local v15    # "form":Ljava/lang/Object;
    new-instance v37, Ljava/util/Vector;

    invoke-direct/range {v37 .. v37}, Ljava/util/Vector;-><init>()V

    .line 184
    .local v37, "vec":Ljava/util/Vector;
    const/4 v13, 0x0

    .line 189
    .local v13, "cdr":Ljava/lang/Object;
    :goto_6
    instance-of v3, v15, Lkawa/lang/SyntaxForm;

    if-eqz v3, :cond_d

    move-object/from16 v34, v15

    .line 191
    check-cast v34, Lkawa/lang/SyntaxForm;

    .line 192
    invoke-interface/range {v34 .. v34}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v15

    .line 194
    :cond_d
    sget-object v3, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v15, v3, :cond_10

    .line 204
    invoke-virtual/range {v37 .. v37}, Ljava/util/Vector;->size()I

    move-result v3

    add-int/lit8 v17, v3, 0x1

    .line 205
    .local v17, "nargs":I
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    const/4 v5, 0x1

    move-object/from16 v3, p0

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p5

    invoke-virtual/range {v3 .. v8}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v13

    .line 206
    const/4 v3, 0x1

    move/from16 v0, v17

    if-le v0, v3, :cond_e

    .line 208
    move/from16 v0, v17

    new-array v11, v0, [Lgnu/expr/Expression;

    .line 209
    .local v11, "args":[Lgnu/expr/Expression;
    move-object/from16 v0, v37

    invoke-virtual {v0, v11}, Ljava/util/Vector;->copyInto([Ljava/lang/Object;)V

    .line 210
    add-int/lit8 v3, v17, -0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p5

    invoke-virtual {v0, v13, v1}, Lkawa/lang/Quote;->coerceExpression(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v5

    aput-object v5, v11, v3

    .line 211
    if-nez v33, :cond_12

    sget-object v16, Lkawa/lang/Quote;->consXMethod:Lgnu/bytecode/Method;

    .line 212
    .local v16, "method":Lgnu/bytecode/Method;
    :goto_7
    new-instance v13, Lgnu/expr/ApplyExp;

    .end local v13    # "cdr":Ljava/lang/Object;
    move-object/from16 v0, v16

    invoke-direct {v13, v0, v11}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    .line 214
    .end local v11    # "args":[Lgnu/expr/Expression;
    .end local v16    # "method":Lgnu/bytecode/Method;
    :cond_e
    move-object/from16 v4, v25

    .end local v30    # "rest":Lgnu/lists/Pair;
    .local v4, "rest":Lgnu/lists/Pair;
    move-object v3, v13

    .line 215
    goto/16 :goto_1

    .line 177
    .end local v4    # "rest":Lgnu/lists/Pair;
    .end local v17    # "nargs":I
    .end local v37    # "vec":Ljava/util/Vector;
    .restart local v21    # "op":Ljava/lang/Object;
    .restart local v30    # "rest":Lgnu/lists/Pair;
    :cond_f
    const-string v3, "unquote-splicing"

    move-object/from16 v0, p5

    move-object/from16 v1, v21

    move-object/from16 v2, v34

    invoke-virtual {v0, v1, v2, v3}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Lkawa/lang/SyntaxForm;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_c

    .line 178
    const/16 v33, 0x1

    goto :goto_5

    .line 196
    .end local v21    # "op":Ljava/lang/Object;
    .restart local v13    # "cdr":Ljava/lang/Object;
    .restart local v37    # "vec":Ljava/util/Vector;
    :cond_10
    instance-of v3, v15, Lgnu/lists/Pair;

    if-eqz v3, :cond_11

    move-object v3, v15

    .line 198
    check-cast v3, Lgnu/lists/Pair;

    move-object/from16 v0, p5

    move-object/from16 v1, v34

    invoke-virtual {v0, v3, v1}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v3

    move-object/from16 v0, v37

    invoke-virtual {v0, v3}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 199
    check-cast v15, Lgnu/lists/Pair;

    .end local v15    # "form":Ljava/lang/Object;
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v15

    .restart local v15    # "form":Ljava/lang/Object;
    goto :goto_6

    .line 202
    :cond_11
    const-string v3, "improper list argument to unquote"

    move-object/from16 v0, p5

    invoke-virtual {v0, v3}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v3

    goto/16 :goto_2

    .line 211
    .restart local v11    # "args":[Lgnu/expr/Expression;
    .restart local v17    # "nargs":I
    :cond_12
    sget-object v16, Lkawa/lang/Quote;->appendMethod:Lgnu/bytecode/Method;

    goto :goto_7

    .line 218
    .end local v11    # "args":[Lgnu/expr/Expression;
    .end local v13    # "cdr":Ljava/lang/Object;
    .end local v15    # "form":Ljava/lang/Object;
    .end local v17    # "nargs":I
    .end local v33    # "splicing":I
    .end local v34    # "subsyntax":Lkawa/lang/SyntaxForm;
    .end local v37    # "vec":Ljava/util/Vector;
    :cond_13
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v4

    move-object/from16 v3, p0

    move/from16 v5, p2

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p5

    invoke-virtual/range {v3 .. v8}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v12

    .line 219
    .local v12, "car":Ljava/lang/Object;
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    if-ne v12, v3, :cond_15

    .line 221
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    .line 222
    .local v4, "rest":Ljava/lang/Object;
    instance-of v3, v4, Lgnu/lists/Pair;

    .end local v30    # "rest":Lgnu/lists/Pair;
    if-eqz v3, :cond_14

    move-object/from16 v25, v4

    .line 224
    check-cast v25, Lgnu/lists/Pair;

    .line 225
    goto/16 :goto_0

    :cond_14
    move-object/from16 v3, p0

    move/from16 v5, p2

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p5

    .line 227
    invoke-virtual/range {v3 .. v8}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v13

    .restart local v13    # "cdr":Ljava/lang/Object;
    move-object v3, v13

    .line 228
    goto/16 :goto_1

    .line 230
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v13    # "cdr":Ljava/lang/Object;
    .restart local v30    # "rest":Lgnu/lists/Pair;
    :cond_15
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    move-object/from16 v5, p0

    move/from16 v7, p2

    move-object/from16 v8, p3

    move-object/from16 v9, p4

    move-object/from16 v10, p5

    invoke-virtual/range {v5 .. v10}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/SyntaxForm;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v13

    .line 231
    .restart local v13    # "cdr":Ljava/lang/Object;
    instance-of v3, v12, Lgnu/expr/Expression;

    if-nez v3, :cond_16

    instance-of v3, v13, Lgnu/expr/Expression;

    if-eqz v3, :cond_17

    .line 233
    :cond_16
    const/4 v3, 0x2

    new-array v11, v3, [Lgnu/expr/Expression;

    .line 234
    .restart local v11    # "args":[Lgnu/expr/Expression;
    const/4 v3, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, p5

    invoke-virtual {v0, v12, v1}, Lkawa/lang/Quote;->coerceExpression(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v5

    aput-object v5, v11, v3

    .line 235
    const/4 v3, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p5

    invoke-virtual {v0, v13, v1}, Lkawa/lang/Quote;->coerceExpression(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v5

    aput-object v5, v11, v3

    .line 236
    new-instance v13, Lgnu/expr/ApplyExp;

    .end local v13    # "cdr":Ljava/lang/Object;
    sget-object v3, Lkawa/lang/Quote;->makePairMethod:Lgnu/bytecode/Method;

    invoke-direct {v13, v3, v11}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    .local v13, "cdr":Lgnu/expr/ApplyExp;
    move-object/from16 v4, v30

    .restart local v4    # "rest":Ljava/lang/Object;
    move-object v3, v13

    .line 237
    goto/16 :goto_1

    .line 239
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v11    # "args":[Lgnu/expr/Expression;
    .local v13, "cdr":Ljava/lang/Object;
    :cond_17
    move-object/from16 v0, v25

    invoke-static {v0, v12, v13}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v13

    .local v13, "cdr":Lgnu/lists/Pair;
    move-object/from16 v4, v30

    .restart local v4    # "rest":Ljava/lang/Object;
    move-object v3, v13

    .line 240
    goto/16 :goto_1

    .line 247
    .end local v4    # "rest":Ljava/lang/Object;
    .end local v12    # "car":Ljava/lang/Object;
    .end local v13    # "cdr":Lgnu/lists/Pair;
    .end local v30    # "rest":Lgnu/lists/Pair;
    :cond_18
    move-object/from16 v22, p1

    .line 248
    .local v22, "p":Lgnu/lists/Pair;
    const/16 v5, 0x14

    new-array v0, v5, [Lgnu/lists/Pair;

    move-object/from16 v27, v0

    .line 249
    .local v27, "pairs":[Lgnu/lists/Pair;
    const/16 v18, 0x0

    .line 252
    .local v18, "npairs":I
    :goto_8
    move-object/from16 v0, v27

    array-length v5, v0

    move/from16 v0, v18

    if-lt v0, v5, :cond_19

    .line 254
    mul-int/lit8 v5, v18, 0x2

    new-array v0, v5, [Lgnu/lists/Pair;

    move-object/from16 v36, v0

    .line 255
    .local v36, "tmp":[Lgnu/lists/Pair;
    const/4 v5, 0x0

    const/4 v6, 0x0

    move-object/from16 v0, v27

    move-object/from16 v1, v36

    move/from16 v2, v18

    invoke-static {v0, v5, v1, v6, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 256
    move-object/from16 v27, v36

    .line 258
    .end local v36    # "tmp":[Lgnu/lists/Pair;
    :cond_19
    add-int/lit8 v19, v18, 0x1

    .end local v18    # "npairs":I
    .local v19, "npairs":I
    aput-object v22, v27, v18

    .line 259
    invoke-virtual/range {v22 .. v22}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v5

    if-ne v5, v4, :cond_1a

    .line 263
    instance-of v5, v3, Lgnu/expr/Expression;

    if-eqz v5, :cond_1b

    sget-object v31, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .local v31, "result":Ljava/lang/Object;
    :goto_9
    move/from16 v18, v19

    .line 264
    .end local v19    # "npairs":I
    .end local v31    # "result":Ljava/lang/Object;
    .restart local v18    # "npairs":I
    :goto_a
    add-int/lit8 v18, v18, -0x1

    if-ltz v18, :cond_1c

    .line 266
    aget-object v22, v27, v18

    .line 267
    invoke-virtual/range {v22 .. v22}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    move-object/from16 v0, v22

    move-object/from16 v1, v31

    invoke-static {v0, v5, v1}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v31

    .local v31, "result":Lgnu/lists/Pair;
    goto :goto_a

    .line 261
    .end local v18    # "npairs":I
    .end local v31    # "result":Lgnu/lists/Pair;
    .restart local v19    # "npairs":I
    :cond_1a
    invoke-virtual/range {v22 .. v22}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    .end local v22    # "p":Lgnu/lists/Pair;
    check-cast v22, Lgnu/lists/Pair;

    .restart local v22    # "p":Lgnu/lists/Pair;
    move/from16 v18, v19

    .end local v19    # "npairs":I
    .restart local v18    # "npairs":I
    goto :goto_8

    .end local v18    # "npairs":I
    .restart local v19    # "npairs":I
    :cond_1b
    move-object/from16 v31, v3

    .line 263
    goto :goto_9

    .line 270
    .end local v19    # "npairs":I
    .restart local v18    # "npairs":I
    :cond_1c
    instance-of v5, v3, Lgnu/expr/Expression;

    if-eqz v5, :cond_1e

    .line 272
    const/4 v5, 0x2

    new-array v11, v5, [Lgnu/expr/Expression;

    .line 273
    .restart local v11    # "args":[Lgnu/expr/Expression;
    const/4 v5, 0x1

    check-cast v3, Lgnu/expr/Expression;

    aput-object v3, v11, v5

    .line 274
    const/4 v3, 0x1

    move/from16 v0, v18

    if-ne v0, v3, :cond_1d

    .line 277
    const/4 v3, 0x0

    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    move-object/from16 v0, p0

    move-object/from16 v1, p5

    invoke-virtual {v0, v5, v1}, Lkawa/lang/Quote;->leaf(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v5

    aput-object v5, v11, v3

    .line 278
    new-instance v3, Lgnu/expr/ApplyExp;

    sget-object v5, Lkawa/lang/Quote;->makePairMethod:Lgnu/bytecode/Method;

    invoke-direct {v3, v5, v11}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    goto/16 :goto_2

    .line 282
    :cond_1d
    const/4 v3, 0x0

    move-object/from16 v0, p0

    move-object/from16 v1, v31

    move-object/from16 v2, p5

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Quote;->leaf(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v5

    aput-object v5, v11, v3

    .line 283
    new-instance v3, Lgnu/expr/ApplyExp;

    sget-object v5, Lkawa/lang/Quote;->appendMethod:Lgnu/bytecode/Method;

    invoke-direct {v3, v5, v11}, Lgnu/expr/ApplyExp;-><init>(Lgnu/bytecode/Method;[Lgnu/expr/Expression;)V

    goto/16 :goto_2

    .end local v11    # "args":[Lgnu/expr/Expression;
    :cond_1e
    move-object/from16 v3, v31

    .line 286
    goto/16 :goto_2
.end method

.method protected leaf(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "val"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 67
    new-instance v0, Lgnu/expr/QuoteExp;

    invoke-direct {v0, p1}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    return-object v0
.end method

.method public rewrite(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 3
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 420
    instance-of v1, p1, Lgnu/lists/Pair;

    if-eqz v1, :cond_0

    move-object v0, p1

    check-cast v0, Lgnu/lists/Pair;

    .local v0, "pair":Lgnu/lists/Pair;
    invoke-virtual {v0}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    sget-object v2, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq v1, v2, :cond_1

    .line 422
    .end local v0    # "pair":Lgnu/lists/Pair;
    :cond_0
    const-string v1, "wrong number of arguments to quote"

    invoke-virtual {p2, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v1

    .line 423
    :goto_0
    return-object v1

    .restart local v0    # "pair":Lgnu/lists/Pair;
    :cond_1
    invoke-virtual {v0}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v2

    iget-boolean v1, p0, Lkawa/lang/Quote;->isQuasi:Z

    if-eqz v1, :cond_2

    const/4 v1, 0x1

    :goto_1
    invoke-virtual {p0, v2, v1, p2}, Lkawa/lang/Quote;->expand(Ljava/lang/Object;ILkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lkawa/lang/Quote;->coerceExpression(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v1

    goto :goto_0

    :cond_2
    const/4 v1, -0x1

    goto :goto_1
.end method
