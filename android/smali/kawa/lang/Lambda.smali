.class public Lkawa/lang/Lambda;
.super Lkawa/lang/Syntax;
.source "Lambda.java"


# static fields
.field public static final nameKeyword:Lgnu/expr/Keyword;


# instance fields
.field public defaultDefault:Lgnu/expr/Expression;

.field public keyKeyword:Ljava/lang/Object;

.field public optionalKeyword:Ljava/lang/Object;

.field public restKeyword:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-string v0, "name"

    invoke-static {v0}, Lgnu/expr/Keyword;->make(Ljava/lang/String;)Lgnu/expr/Keyword;

    move-result-object v0

    sput-object v0, Lkawa/lang/Lambda;->nameKeyword:Lgnu/expr/Keyword;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 22
    sget-object v0, Lgnu/expr/QuoteExp;->falseExp:Lgnu/expr/QuoteExp;

    iput-object v0, p0, Lkawa/lang/Lambda;->defaultDefault:Lgnu/expr/Expression;

    return-void
.end method

.method private static addParam(Lgnu/expr/Declaration;Lgnu/expr/ScopeExp;Lgnu/expr/LambdaExp;Lkawa/lang/Translator;)V
    .locals 0
    .param p0, "decl"    # Lgnu/expr/Declaration;
    .param p1, "templateScope"    # Lgnu/expr/ScopeExp;
    .param p2, "lexp"    # Lgnu/expr/LambdaExp;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 358
    if-eqz p1, :cond_0

    .line 359
    invoke-virtual {p3, p0, p1}, Lkawa/lang/Translator;->makeRenamedAlias(Lgnu/expr/Declaration;Lgnu/expr/ScopeExp;)Lgnu/expr/Declaration;

    move-result-object p0

    .line 360
    :cond_0
    invoke-virtual {p2, p0}, Lgnu/expr/LambdaExp;->addDeclaration(Lgnu/expr/Declaration;)V

    .line 361
    if-eqz p1, :cond_1

    .line 362
    iput-object p1, p0, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    .line 363
    :cond_1
    return-void
.end method


# virtual methods
.method public print(Lgnu/lists/Consumer;)V
    .locals 1
    .param p1, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 643
    const-string v0, "#<builtin lambda>"

    invoke-interface {p1, v0}, Lgnu/lists/Consumer;->write(Ljava/lang/String;)V

    .line 644
    return-void
.end method

.method public rewrite(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 8
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 40
    instance-of v0, p1, Lgnu/lists/Pair;

    if-nez v0, :cond_1

    .line 41
    const-string v0, "missing formals in lambda"

    invoke-virtual {p2, v0}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    move-result-object v1

    .line 49
    :cond_0
    :goto_0
    return-object v1

    .line 42
    :cond_1
    invoke-virtual {p2}, Lkawa/lang/Translator;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v0

    invoke-virtual {v0}, Lgnu/text/SourceMessages;->getErrorCount()I

    move-result v6

    .line 43
    .local v6, "old_errors":I
    new-instance v1, Lgnu/expr/LambdaExp;

    invoke-direct {v1}, Lgnu/expr/LambdaExp;-><init>()V

    .local v1, "lexp":Lgnu/expr/LambdaExp;
    move-object v7, p1

    .line 44
    check-cast v7, Lgnu/lists/Pair;

    .line 45
    .local v7, "pair":Lgnu/lists/Pair;
    invoke-static {v1, v7}, Lkawa/lang/Translator;->setLine(Lgnu/expr/Expression;Ljava/lang/Object;)V

    .line 46
    invoke-virtual {v7}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v7}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    const/4 v5, 0x0

    move-object v0, p0

    move-object v4, p2

    invoke-virtual/range {v0 .. v5}, Lkawa/lang/Lambda;->rewrite(Lgnu/expr/LambdaExp;Ljava/lang/Object;Ljava/lang/Object;Lkawa/lang/Translator;Lkawa/lang/TemplateScope;)V

    .line 47
    invoke-virtual {p2}, Lkawa/lang/Translator;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v0

    invoke-virtual {v0}, Lgnu/text/SourceMessages;->getErrorCount()I

    move-result v0

    if-le v0, v6, :cond_0

    .line 48
    new-instance v1, Lgnu/expr/ErrorExp;

    .end local v1    # "lexp":Lgnu/expr/LambdaExp;
    const-string v0, "bad lambda expression"

    invoke-direct {v1, v0}, Lgnu/expr/ErrorExp;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public rewrite(Lgnu/expr/LambdaExp;Ljava/lang/Object;Ljava/lang/Object;Lkawa/lang/Translator;Lkawa/lang/TemplateScope;)V
    .locals 1
    .param p1, "lexp"    # Lgnu/expr/LambdaExp;
    .param p2, "formals"    # Ljava/lang/Object;
    .param p3, "body"    # Ljava/lang/Object;
    .param p4, "tr"    # Lkawa/lang/Translator;
    .param p5, "templateScopeRest"    # Lkawa/lang/TemplateScope;

    .prologue
    .line 61
    invoke-virtual {p0, p1, p2, p4, p5}, Lkawa/lang/Lambda;->rewriteFormals(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;Lkawa/lang/TemplateScope;)V

    .line 62
    instance-of v0, p3, Lgnu/lists/PairWithPosition;

    if-eqz v0, :cond_0

    move-object v0, p3

    .line 63
    check-cast v0, Lgnu/lists/PairWithPosition;

    invoke-virtual {v0}, Lgnu/lists/PairWithPosition;->getFileName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lgnu/expr/LambdaExp;->setFile(Ljava/lang/String;)V

    .line 64
    :cond_0
    invoke-virtual {p0, p1, p3, p4}, Lkawa/lang/Lambda;->rewriteAttrs(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;

    move-result-object p3

    .line 65
    invoke-virtual {p0, p1, p3, p4}, Lkawa/lang/Lambda;->rewriteBody(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;)V

    .line 66
    return-void
.end method

.method public rewriteAttrs(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;
    .locals 24
    .param p1, "lexp"    # Lgnu/expr/LambdaExp;
    .param p2, "body"    # Ljava/lang/Object;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 367
    const/4 v4, 0x0

    .line 368
    .local v4, "accessFlagName":Ljava/lang/String;
    const/4 v6, 0x0

    .line 369
    .local v6, "allocationFlagName":Ljava/lang/String;
    const/4 v3, 0x0

    .line 370
    .local v3, "accessFlag":I
    const/4 v5, 0x0

    .line 371
    .local v5, "allocationFlag":I
    const/16 v17, 0x0

    .line 374
    .local v17, "syntax0":Lkawa/lang/SyntaxForm;
    :goto_0
    move-object/from16 v0, p2

    instance-of v0, v0, Lkawa/lang/SyntaxForm;

    move/from16 v21, v0

    if-eqz v21, :cond_0

    move-object/from16 v17, p2

    .line 376
    check-cast v17, Lkawa/lang/SyntaxForm;

    .line 377
    invoke-interface/range {v17 .. v17}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object p2

    goto :goto_0

    .line 379
    :cond_0
    move-object/from16 v0, p2

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v21, v0

    if-nez v21, :cond_4

    .line 516
    :cond_1
    :goto_1
    or-int/2addr v3, v5

    .line 517
    if-eqz v3, :cond_2

    .line 518
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->nameDecl:Lgnu/expr/Declaration;

    move-object/from16 v21, v0

    int-to-long v0, v3

    move-wide/from16 v22, v0

    invoke-virtual/range {v21 .. v23}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 519
    :cond_2
    if-eqz v17, :cond_3

    .line 520
    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-static {v0, v1}, Lkawa/lang/SyntaxForms;->fromDatumIfNeeded(Ljava/lang/Object;Lkawa/lang/SyntaxForm;)Ljava/lang/Object;

    move-result-object p2

    .line 521
    :cond_3
    return-object p2

    :cond_4
    move-object/from16 v13, p2

    .line 381
    check-cast v13, Lgnu/lists/Pair;

    .line 382
    .local v13, "pair1":Lgnu/lists/Pair;
    invoke-virtual {v13}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v21

    invoke-static/range {v21 .. v21}, Lkawa/lang/Translator;->stripSyntax(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    .line 383
    .local v8, "attrName":Ljava/lang/Object;
    const-string v21, "::"

    move-object/from16 v0, p3

    move-object/from16 v1, v21

    invoke-virtual {v0, v8, v1}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Ljava/lang/String;)Z

    move-result v21

    if-eqz v21, :cond_6

    .line 384
    const/4 v8, 0x0

    .line 388
    .end local v8    # "attrName":Ljava/lang/Object;
    :cond_5
    move-object/from16 v18, v17

    .line 389
    .local v18, "syntax1":Lkawa/lang/SyntaxForm;
    invoke-virtual {v13}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v14

    .line 390
    .local v14, "pair1_cdr":Ljava/lang/Object;
    :goto_2
    instance-of v0, v14, Lkawa/lang/SyntaxForm;

    move/from16 v21, v0

    if-eqz v21, :cond_7

    move-object/from16 v18, v14

    .line 392
    check-cast v18, Lkawa/lang/SyntaxForm;

    .line 393
    invoke-interface/range {v18 .. v18}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v14

    goto :goto_2

    .line 385
    .end local v14    # "pair1_cdr":Ljava/lang/Object;
    .end local v18    # "syntax1":Lkawa/lang/SyntaxForm;
    .restart local v8    # "attrName":Ljava/lang/Object;
    :cond_6
    instance-of v0, v8, Lgnu/expr/Keyword;

    move/from16 v21, v0

    if-nez v21, :cond_5

    goto :goto_1

    .line 395
    .end local v8    # "attrName":Ljava/lang/Object;
    .restart local v14    # "pair1_cdr":Ljava/lang/Object;
    .restart local v18    # "syntax1":Lkawa/lang/SyntaxForm;
    :cond_7
    instance-of v0, v14, Lgnu/lists/Pair;

    move/from16 v21, v0

    if-eqz v21, :cond_1

    move-object v15, v14

    .line 397
    check-cast v15, Lgnu/lists/Pair;

    .line 400
    .local v15, "pair2":Lgnu/lists/Pair;
    if-nez v8, :cond_a

    .line 402
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/LambdaExp;->isClassMethod()Z

    move-result v21

    if-eqz v21, :cond_9

    const-string v21, "*init*"

    invoke-virtual/range {p1 .. p1}, Lgnu/expr/LambdaExp;->getName()Ljava/lang/String;

    move-result-object v22

    invoke-virtual/range {v21 .. v22}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_9

    .line 403
    const/16 v21, 0x65

    const-string v22, "explicit return type for \'*init*\' method"

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 514
    :cond_8
    :goto_3
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p2

    .line 515
    goto/16 :goto_0

    .line 406
    :cond_9
    new-instance v21, Lgnu/expr/LangExp;

    const/16 v22, 0x2

    move/from16 v0, v22

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    aput-object v15, v22, v23

    const/16 v23, 0x1

    aput-object v18, v22, v23

    invoke-direct/range {v21 .. v22}, Lgnu/expr/LangExp;-><init>(Ljava/lang/Object;)V

    move-object/from16 v0, v21

    move-object/from16 v1, p1

    iput-object v0, v1, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    goto :goto_3

    .line 408
    :cond_a
    sget-object v21, Lkawa/standard/object;->accessKeyword:Lgnu/expr/Keyword;

    move-object/from16 v0, v21

    if-ne v8, v0, :cond_13

    .line 410
    move-object/from16 v0, p3

    move-object/from16 v1, v18

    invoke-virtual {v0, v15, v1}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v7

    .line 411
    .local v7, "attrExpr":Lgnu/expr/Expression;
    instance-of v0, v7, Lgnu/expr/QuoteExp;

    move/from16 v21, v0

    if-eqz v21, :cond_b

    check-cast v7, Lgnu/expr/QuoteExp;

    .end local v7    # "attrExpr":Lgnu/expr/Expression;
    invoke-virtual {v7}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v9

    .local v9, "attrValue":Ljava/lang/Object;
    instance-of v0, v9, Lgnu/mapping/SimpleSymbol;

    move/from16 v21, v0

    if-nez v21, :cond_c

    instance-of v0, v9, Ljava/lang/CharSequence;

    move/from16 v21, v0

    if-nez v21, :cond_c

    .line 420
    .end local v9    # "attrValue":Ljava/lang/Object;
    :cond_b
    const/16 v21, 0x65

    const-string v22, "access: value not a constant symbol or string"

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto :goto_3

    .line 421
    .restart local v9    # "attrValue":Ljava/lang/Object;
    :cond_c
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->nameDecl:Lgnu/expr/Declaration;

    move-object/from16 v21, v0

    if-nez v21, :cond_d

    .line 422
    const/16 v21, 0x65

    const-string v22, "access: not allowed for anonymous function"

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto :goto_3

    .line 425
    :cond_d
    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v20

    .line 426
    .local v20, "value":Ljava/lang/String;
    const-string v21, "private"

    move-object/from16 v0, v21

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_f

    .line 427
    const/high16 v3, 0x1000000

    .line 436
    :goto_4
    if-eqz v4, :cond_e

    if-eqz v20, :cond_e

    .line 438
    const/16 v21, 0x65

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "duplicate access specifiers - "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " and "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 442
    :cond_e
    move-object/from16 v4, v20

    goto/16 :goto_3

    .line 428
    :cond_f
    const-string v21, "protected"

    move-object/from16 v0, v21

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_10

    .line 429
    const/high16 v3, 0x2000000

    goto :goto_4

    .line 430
    :cond_10
    const-string v21, "public"

    move-object/from16 v0, v21

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_11

    .line 431
    const/high16 v3, 0x4000000

    goto :goto_4

    .line 432
    :cond_11
    const-string v21, "package"

    move-object/from16 v0, v21

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_12

    .line 433
    const/high16 v3, 0x8000000

    goto :goto_4

    .line 435
    :cond_12
    const/16 v21, 0x65

    const-string v22, "unknown access specifier"

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto :goto_4

    .line 445
    .end local v9    # "attrValue":Ljava/lang/Object;
    .end local v20    # "value":Ljava/lang/String;
    :cond_13
    sget-object v21, Lkawa/standard/object;->allocationKeyword:Lgnu/expr/Keyword;

    move-object/from16 v0, v21

    if-ne v8, v0, :cond_1b

    .line 447
    move-object/from16 v0, p3

    move-object/from16 v1, v18

    invoke-virtual {v0, v15, v1}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v7

    .line 448
    .restart local v7    # "attrExpr":Lgnu/expr/Expression;
    instance-of v0, v7, Lgnu/expr/QuoteExp;

    move/from16 v21, v0

    if-eqz v21, :cond_14

    check-cast v7, Lgnu/expr/QuoteExp;

    .end local v7    # "attrExpr":Lgnu/expr/Expression;
    invoke-virtual {v7}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v9

    .restart local v9    # "attrValue":Ljava/lang/Object;
    instance-of v0, v9, Lgnu/mapping/SimpleSymbol;

    move/from16 v21, v0

    if-nez v21, :cond_15

    instance-of v0, v9, Ljava/lang/CharSequence;

    move/from16 v21, v0

    if-nez v21, :cond_15

    .line 457
    .end local v9    # "attrValue":Ljava/lang/Object;
    :cond_14
    const/16 v21, 0x65

    const-string v22, "allocation: value not a constant symbol or string"

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto/16 :goto_3

    .line 458
    .restart local v9    # "attrValue":Ljava/lang/Object;
    :cond_15
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->nameDecl:Lgnu/expr/Declaration;

    move-object/from16 v21, v0

    if-nez v21, :cond_16

    .line 459
    const/16 v21, 0x65

    const-string v22, "allocation: not allowed for anonymous function"

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto/16 :goto_3

    .line 462
    :cond_16
    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v20

    .line 463
    .restart local v20    # "value":Ljava/lang/String;
    const-string v21, "class"

    move-object/from16 v0, v21

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-nez v21, :cond_17

    const-string v21, "static"

    move-object/from16 v0, v21

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_19

    .line 464
    :cond_17
    const/16 v5, 0x800

    .line 469
    :goto_5
    if-eqz v6, :cond_18

    if-eqz v20, :cond_18

    .line 471
    const/16 v21, 0x65

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "duplicate allocation specifiers - "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " and "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 475
    :cond_18
    move-object/from16 v6, v20

    goto/16 :goto_3

    .line 465
    :cond_19
    const-string v21, "instance"

    move-object/from16 v0, v21

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v21

    if-eqz v21, :cond_1a

    .line 466
    const/16 v5, 0x1000

    goto :goto_5

    .line 468
    :cond_1a
    const/16 v21, 0x65

    const-string v22, "unknown allocation specifier"

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto :goto_5

    .line 478
    .end local v9    # "attrValue":Ljava/lang/Object;
    .end local v20    # "value":Ljava/lang/String;
    :cond_1b
    sget-object v21, Lkawa/standard/object;->throwsKeyword:Lgnu/expr/Keyword;

    move-object/from16 v0, v21

    if-ne v8, v0, :cond_1f

    .line 480
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v9

    .line 481
    .restart local v9    # "attrValue":Ljava/lang/Object;
    invoke-static {v9}, Lkawa/lang/Translator;->listLength(Ljava/lang/Object;)I

    move-result v10

    .line 482
    .local v10, "count":I
    if-gez v10, :cond_1c

    .line 483
    const/16 v21, 0x65

    const-string v22, "throws: not followed by a list"

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto/16 :goto_3

    .line 486
    :cond_1c
    new-array v11, v10, [Lgnu/expr/Expression;

    .line 487
    .local v11, "exps":[Lgnu/expr/Expression;
    move-object/from16 v19, v18

    .line 488
    .local v19, "syntax2":Lkawa/lang/SyntaxForm;
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_6
    if-ge v12, v10, :cond_1e

    .line 490
    :goto_7
    instance-of v0, v9, Lkawa/lang/SyntaxForm;

    move/from16 v21, v0

    if-eqz v21, :cond_1d

    move-object/from16 v19, v9

    .line 492
    check-cast v19, Lkawa/lang/SyntaxForm;

    .line 493
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v9

    goto :goto_7

    :cond_1d
    move-object/from16 v16, v9

    .line 495
    check-cast v16, Lgnu/lists/Pair;

    .line 496
    .local v16, "pair3":Lgnu/lists/Pair;
    move-object/from16 v0, p3

    move-object/from16 v1, v16

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v21

    aput-object v21, v11, v12

    .line 498
    aget-object v21, v11, v12

    move-object/from16 v0, v21

    move-object/from16 v1, v16

    invoke-static {v0, v1}, Lkawa/lang/Translator;->setLine(Lgnu/expr/Expression;Ljava/lang/Object;)V

    .line 499
    invoke-virtual/range {v16 .. v16}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v9

    .line 488
    add-int/lit8 v12, v12, 0x1

    goto :goto_6

    .line 501
    .end local v16    # "pair3":Lgnu/lists/Pair;
    :cond_1e
    move-object/from16 v0, p1

    invoke-virtual {v0, v11}, Lgnu/expr/LambdaExp;->setExceptions([Lgnu/expr/Expression;)V

    goto/16 :goto_3

    .line 504
    .end local v9    # "attrValue":Ljava/lang/Object;
    .end local v10    # "count":I
    .end local v11    # "exps":[Lgnu/expr/Expression;
    .end local v12    # "i":I
    .end local v19    # "syntax2":Lkawa/lang/SyntaxForm;
    :cond_1f
    sget-object v21, Lkawa/lang/Lambda;->nameKeyword:Lgnu/expr/Keyword;

    move-object/from16 v0, v21

    if-ne v8, v0, :cond_20

    .line 506
    move-object/from16 v0, p3

    move-object/from16 v1, v18

    invoke-virtual {v0, v15, v1}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v7

    .line 507
    .restart local v7    # "attrExpr":Lgnu/expr/Expression;
    instance-of v0, v7, Lgnu/expr/QuoteExp;

    move/from16 v21, v0

    if-eqz v21, :cond_8

    .line 508
    check-cast v7, Lgnu/expr/QuoteExp;

    .end local v7    # "attrExpr":Lgnu/expr/Expression;
    invoke-virtual {v7}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v21

    invoke-virtual/range {v21 .. v21}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v21

    move-object/from16 v0, p1

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lgnu/expr/LambdaExp;->setName(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 512
    :cond_20
    const/16 v21, 0x77

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "unknown procedure property "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move/from16 v1, v21

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto/16 :goto_3
.end method

.method public rewriteBody(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;)V
    .locals 25
    .param p1, "lexp"    # Lgnu/expr/LambdaExp;
    .param p2, "body"    # Ljava/lang/Object;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 543
    const/4 v10, 0x0

    .line 546
    .local v10, "numRenamedAlias":I
    move-object/from16 v0, p3

    iget-object v0, v0, Lkawa/lang/Translator;->curMethodLambda:Lgnu/expr/LambdaExp;

    move-object/from16 v22, v0

    if-nez v22, :cond_0

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->nameDecl:Lgnu/expr/Declaration;

    move-object/from16 v22, v0

    if-eqz v22, :cond_0

    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getModule()Lgnu/expr/ModuleExp;

    move-result-object v22

    const/high16 v23, 0x20000

    invoke-virtual/range {v22 .. v23}, Lgnu/expr/ModuleExp;->getFlag(I)Z

    move-result v22

    if-eqz v22, :cond_0

    .line 549
    move-object/from16 v0, p1

    move-object/from16 v1, p3

    iput-object v0, v1, Lkawa/lang/Translator;->curMethodLambda:Lgnu/expr/LambdaExp;

    .line 550
    :cond_0
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->currentScope()Lgnu/expr/ScopeExp;

    move-result-object v5

    .line 551
    .local v5, "curs":Lgnu/expr/ScopeExp;
    move-object/from16 v0, p3

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->pushScope(Lgnu/expr/ScopeExp;)V

    .line 552
    const/4 v14, 0x0

    .line 553
    .local v14, "prev":Lgnu/expr/Declaration;
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->keywords:[Lgnu/expr/Keyword;

    move-object/from16 v22, v0

    if-nez v22, :cond_5

    const/4 v7, 0x0

    .line 554
    .local v7, "key_args":I
    :goto_0
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->defaultArgs:[Lgnu/expr/Expression;

    move-object/from16 v22, v0

    if-nez v22, :cond_6

    const/4 v11, 0x0

    .line 556
    .local v11, "opt_args":I
    :goto_1
    const/4 v3, 0x0

    .line 557
    .local v3, "arg_i":I
    const/4 v12, 0x0

    .line 558
    .local v12, "opt_i":I
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/LambdaExp;->firstDecl()Lgnu/expr/Declaration;

    move-result-object v4

    .local v4, "cur":Lgnu/expr/Declaration;
    :goto_2
    if-eqz v4, :cond_7

    .line 560
    invoke-virtual {v4}, Lgnu/expr/Declaration;->isAlias()Z

    move-result v22

    if-eqz v22, :cond_1

    .line 562
    invoke-static {v4}, Lkawa/lang/Translator;->getOriginalRef(Lgnu/expr/Declaration;)Lgnu/expr/ReferenceExp;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v13

    .line 563
    .local v13, "param":Lgnu/expr/Declaration;
    move-object/from16 v0, p1

    invoke-virtual {v0, v14, v13}, Lgnu/expr/LambdaExp;->replaceFollowing(Lgnu/expr/Declaration;Lgnu/expr/Declaration;)V

    .line 564
    move-object/from16 v0, p1

    iput-object v0, v13, Lgnu/expr/Declaration;->context:Lgnu/expr/ScopeExp;

    .line 565
    move-object/from16 v0, p3

    invoke-virtual {v0, v4}, Lkawa/lang/Translator;->pushRenamedAlias(Lgnu/expr/Declaration;)V

    .line 566
    add-int/lit8 v10, v10, 0x1

    .line 567
    move-object v4, v13

    .line 569
    .end local v13    # "param":Lgnu/expr/Declaration;
    :cond_1
    invoke-virtual {v4}, Lgnu/expr/Declaration;->getTypeExp()Lgnu/expr/Expression;

    move-result-object v18

    .line 570
    .local v18, "texp":Lgnu/expr/Expression;
    move-object/from16 v0, v18

    instance-of v0, v0, Lgnu/expr/LangExp;

    move/from16 v22, v0

    if-eqz v22, :cond_2

    .line 572
    check-cast v18, Lgnu/expr/LangExp;

    .end local v18    # "texp":Lgnu/expr/Expression;
    invoke-virtual/range {v18 .. v18}, Lgnu/expr/LangExp;->getLangValue()Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Lgnu/lists/Pair;

    .line 573
    .local v20, "typeSpecPair":Lgnu/lists/Pair;
    move-object/from16 v0, p3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->exp2Type(Lgnu/lists/Pair;)Lgnu/bytecode/Type;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 575
    .end local v20    # "typeSpecPair":Lgnu/lists/Pair;
    :cond_2
    move-object v14, v4

    .line 577
    move-object/from16 v0, p1

    iget v0, v0, Lgnu/expr/LambdaExp;->min_args:I

    move/from16 v22, v0

    move/from16 v0, v22

    if-lt v3, v0, :cond_4

    move-object/from16 v0, p1

    iget v0, v0, Lgnu/expr/LambdaExp;->min_args:I

    move/from16 v22, v0

    add-int v22, v22, v11

    move/from16 v0, v22

    if-lt v3, v0, :cond_3

    move-object/from16 v0, p1

    iget v0, v0, Lgnu/expr/LambdaExp;->max_args:I

    move/from16 v22, v0

    if-gez v22, :cond_3

    move-object/from16 v0, p1

    iget v0, v0, Lgnu/expr/LambdaExp;->min_args:I

    move/from16 v22, v0

    add-int v22, v22, v11

    move/from16 v0, v22

    if-eq v3, v0, :cond_4

    .line 582
    :cond_3
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->defaultArgs:[Lgnu/expr/Expression;

    move-object/from16 v22, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->defaultArgs:[Lgnu/expr/Expression;

    move-object/from16 v23, v0

    aget-object v23, v23, v12

    move-object/from16 v0, p3

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v23

    aput-object v23, v22, v12

    .line 583
    add-int/lit8 v12, v12, 0x1

    .line 585
    :cond_4
    add-int/lit8 v3, v3, 0x1

    .line 587
    move-object/from16 v0, p3

    iget-object v0, v0, Lkawa/lang/Translator;->lexical:Lgnu/expr/NameLookup;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v0, v4}, Lgnu/expr/NameLookup;->push(Lgnu/expr/Declaration;)V

    .line 558
    invoke-virtual {v4}, Lgnu/expr/Declaration;->nextDecl()Lgnu/expr/Declaration;

    move-result-object v4

    goto/16 :goto_2

    .line 553
    .end local v3    # "arg_i":I
    .end local v4    # "cur":Lgnu/expr/Declaration;
    .end local v7    # "key_args":I
    .end local v11    # "opt_args":I
    .end local v12    # "opt_i":I
    :cond_5
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->keywords:[Lgnu/expr/Keyword;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    array-length v7, v0

    goto/16 :goto_0

    .line 554
    .restart local v7    # "key_args":I
    :cond_6
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->defaultArgs:[Lgnu/expr/Expression;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    array-length v0, v0

    move/from16 v22, v0

    sub-int v11, v22, v7

    goto/16 :goto_1

    .line 590
    .restart local v3    # "arg_i":I
    .restart local v4    # "cur":Lgnu/expr/Declaration;
    .restart local v11    # "opt_args":I
    .restart local v12    # "opt_i":I
    :cond_7
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/LambdaExp;->isClassMethod()Z

    move-result v22

    if-eqz v22, :cond_8

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->nameDecl:Lgnu/expr/Declaration;

    move-object/from16 v22, v0

    const-wide/16 v23, 0x800

    invoke-virtual/range {v22 .. v24}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v22

    if-nez v22, :cond_8

    .line 594
    const/16 v22, 0x0

    new-instance v23, Lgnu/expr/Declaration;

    sget-object v24, Lgnu/expr/ThisExp;->THIS_NAME:Ljava/lang/String;

    invoke-direct/range {v23 .. v24}, Lgnu/expr/Declaration;-><init>(Ljava/lang/Object;)V

    move-object/from16 v0, p1

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lgnu/expr/LambdaExp;->add(Lgnu/expr/Declaration;Lgnu/expr/Declaration;)V

    .line 597
    :cond_8
    move-object/from16 v0, p3

    iget-object v0, v0, Lkawa/lang/Translator;->curLambda:Lgnu/expr/LambdaExp;

    move-object/from16 v17, v0

    .line 598
    .local v17, "saveLambda":Lgnu/expr/LambdaExp;
    move-object/from16 v0, p1

    move-object/from16 v1, p3

    iput-object v0, v1, Lkawa/lang/Translator;->curLambda:Lgnu/expr/LambdaExp;

    .line 599
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->returnType:Lgnu/bytecode/Type;

    move-object/from16 v16, v0

    .line 600
    .local v16, "rtype":Lgnu/bytecode/Type;
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/expr/LangExp;

    move/from16 v22, v0

    if-eqz v22, :cond_9

    .line 602
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    move-object/from16 v22, v0

    check-cast v22, Lgnu/expr/LangExp;

    invoke-virtual/range {v22 .. v22}, Lgnu/expr/LangExp;->getLangValue()Ljava/lang/Object;

    move-result-object v22

    check-cast v22, [Ljava/lang/Object;

    move-object/from16 v19, v22

    check-cast v19, [Ljava/lang/Object;

    .line 603
    .local v19, "tform":[Ljava/lang/Object;
    const/16 v22, 0x0

    aget-object v22, v19, v22

    check-cast v22, Lgnu/lists/Pair;

    const/16 v23, 0x1

    aget-object v23, v19, v23

    check-cast v23, Lkawa/lang/SyntaxForm;

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Lkawa/lang/SyntaxForm;)Lgnu/expr/Expression;

    move-result-object v18

    .line 605
    .restart local v18    # "texp":Lgnu/expr/Expression;
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getLanguage()Lgnu/expr/Language;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lgnu/expr/Language;->getTypeFor(Lgnu/expr/Expression;)Lgnu/bytecode/Type;

    move-result-object v16

    .line 607
    .end local v18    # "texp":Lgnu/expr/Expression;
    .end local v19    # "tform":[Ljava/lang/Object;
    :cond_9
    move-object/from16 v0, p3

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->rewrite_body(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, p1

    iput-object v0, v1, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    .line 608
    move-object/from16 v0, v17

    move-object/from16 v1, p3

    iput-object v0, v1, Lkawa/lang/Translator;->curLambda:Lgnu/expr/LambdaExp;

    .line 612
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/expr/BeginExp;

    move/from16 v22, v0

    if-eqz v22, :cond_d

    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    move-object/from16 v22, v0

    check-cast v22, Lgnu/expr/BeginExp;

    invoke-virtual/range {v22 .. v22}, Lgnu/expr/BeginExp;->getExpressions()[Lgnu/expr/Expression;

    move-result-object v6

    .local v6, "exps":[Lgnu/expr/Expression;
    array-length v8, v6

    .local v8, "len":I
    const/16 v22, 0x1

    move/from16 v0, v22

    if-le v8, v0, :cond_d

    const/16 v22, 0x0

    aget-object v22, v6, v22

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/expr/ReferenceExp;

    move/from16 v22, v0

    if-nez v22, :cond_a

    const/16 v22, 0x0

    aget-object v22, v6, v22

    invoke-virtual/range {v22 .. v22}, Lgnu/expr/Expression;->valueIfConstant()Ljava/lang/Object;

    move-result-object v21

    .local v21, "val":Ljava/lang/Object;
    move-object/from16 v0, v21

    instance-of v0, v0, Lgnu/bytecode/Type;

    move/from16 v22, v0

    if-nez v22, :cond_a

    move-object/from16 v0, v21

    instance-of v0, v0, Ljava/lang/Class;

    move/from16 v22, v0

    if-eqz v22, :cond_d

    .line 619
    .end local v21    # "val":Ljava/lang/Object;
    :cond_a
    const/16 v22, 0x0

    aget-object v15, v6, v22

    .line 620
    .local v15, "rexp":Lgnu/expr/Expression;
    add-int/lit8 v8, v8, -0x1

    .line 621
    const/16 v22, 0x1

    move/from16 v0, v22

    if-ne v8, v0, :cond_c

    .line 622
    const/16 v22, 0x1

    aget-object v22, v6, v22

    move-object/from16 v0, v22

    move-object/from16 v1, p1

    iput-object v0, v1, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    .line 629
    :goto_3
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getLanguage()Lgnu/expr/Language;

    move-result-object v22

    move-object/from16 v0, p1

    move-object/from16 v1, v22

    invoke-virtual {v0, v15, v1}, Lgnu/expr/LambdaExp;->setCoercedReturnValue(Lgnu/expr/Expression;Lgnu/expr/Language;)V

    .line 633
    .end local v6    # "exps":[Lgnu/expr/Expression;
    .end local v8    # "len":I
    .end local v15    # "rexp":Lgnu/expr/Expression;
    :goto_4
    move-object/from16 v0, p3

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->pop(Lgnu/expr/ScopeExp;)V

    .line 634
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/LambdaExp;->countDecls()I

    .line 635
    move-object/from16 v0, p3

    invoke-virtual {v0, v10}, Lkawa/lang/Translator;->popRenamedAlias(I)V

    .line 636
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/LambdaExp;->countDecls()I

    .line 637
    move-object/from16 v0, p3

    iget-object v0, v0, Lkawa/lang/Translator;->curMethodLambda:Lgnu/expr/LambdaExp;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    move-object/from16 v1, p1

    if-ne v0, v1, :cond_b

    .line 638
    const/16 v22, 0x0

    move-object/from16 v0, v22

    move-object/from16 v1, p3

    iput-object v0, v1, Lkawa/lang/Translator;->curMethodLambda:Lgnu/expr/LambdaExp;

    .line 639
    :cond_b
    return-void

    .line 625
    .restart local v6    # "exps":[Lgnu/expr/Expression;
    .restart local v8    # "len":I
    .restart local v15    # "rexp":Lgnu/expr/Expression;
    :cond_c
    new-array v9, v8, [Lgnu/expr/Expression;

    .line 626
    .local v9, "new_body":[Lgnu/expr/Expression;
    const/16 v22, 0x1

    const/16 v23, 0x0

    move/from16 v0, v22

    move/from16 v1, v23

    invoke-static {v6, v0, v9, v1, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 627
    invoke-static {v9}, Lgnu/expr/BeginExp;->canonicalize([Lgnu/expr/Expression;)Lgnu/expr/Expression;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, p1

    iput-object v0, v1, Lgnu/expr/LambdaExp;->body:Lgnu/expr/Expression;

    goto :goto_3

    .line 632
    .end local v6    # "exps":[Lgnu/expr/Expression;
    .end local v8    # "len":I
    .end local v9    # "new_body":[Lgnu/expr/Expression;
    .end local v15    # "rexp":Lgnu/expr/Expression;
    :cond_d
    move-object/from16 v0, p1

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lgnu/expr/LambdaExp;->setCoercedReturnType(Lgnu/bytecode/Type;)V

    goto :goto_4
.end method

.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 2
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 33
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lkawa/lang/Lambda;->rewrite(Ljava/lang/Object;Lkawa/lang/Translator;)Lgnu/expr/Expression;

    move-result-object v0

    .line 34
    .local v0, "exp":Lgnu/expr/Expression;
    invoke-static {v0, p1}, Lkawa/lang/Translator;->setLine(Lgnu/expr/Expression;Ljava/lang/Object;)V

    .line 35
    return-object v0
.end method

.method public rewriteFormals(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;Lkawa/lang/TemplateScope;)V
    .locals 24
    .param p1, "lexp"    # Lgnu/expr/LambdaExp;
    .param p2, "formals"    # Ljava/lang/Object;
    .param p3, "tr"    # Lkawa/lang/Translator;
    .param p4, "templateScopeRest"    # Lkawa/lang/TemplateScope;

    .prologue
    .line 71
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/LambdaExp;->getSymbol()Ljava/lang/Object;

    move-result-object v22

    if-nez v22, :cond_0

    .line 73
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/LambdaExp;->getFileName()Ljava/lang/String;

    move-result-object v6

    .line 74
    .local v6, "filename":Ljava/lang/String;
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/LambdaExp;->getLineNumber()I

    move-result v9

    .line 75
    .local v9, "line":I
    if-eqz v6, :cond_0

    if-lez v9, :cond_0

    .line 76
    move-object/from16 v0, p1

    invoke-virtual {v0, v6, v9}, Lgnu/expr/LambdaExp;->setSourceLocation(Ljava/lang/String;I)V

    .line 79
    .end local v6    # "filename":Ljava/lang/String;
    .end local v9    # "line":I
    :cond_0
    move-object/from16 v3, p2

    .line 80
    .local v3, "bindings":Ljava/lang/Object;
    const/4 v12, -0x1

    .line 81
    .local v12, "opt_args":I
    const/16 v17, -0x1

    .line 82
    .local v17, "rest_args":I
    const/4 v7, -0x1

    .line 86
    .local v7, "key_args":I
    :goto_0
    instance-of v0, v3, Lkawa/lang/SyntaxForm;

    move/from16 v22, v0

    if-eqz v22, :cond_1

    move-object/from16 v19, v3

    .line 88
    check-cast v19, Lkawa/lang/SyntaxForm;

    .line 90
    .local v19, "sf":Lkawa/lang/SyntaxForm;
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v3

    .line 92
    .end local v19    # "sf":Lkawa/lang/SyntaxForm;
    :cond_1
    instance-of v0, v3, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-nez v22, :cond_4

    .line 151
    instance-of v0, v3, Lgnu/mapping/Symbol;

    move/from16 v22, v0

    if-eqz v22, :cond_15

    .line 153
    if-gez v12, :cond_2

    if-gez v7, :cond_2

    if-ltz v17, :cond_13

    .line 155
    :cond_2
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "dotted rest-arg after "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->optionalKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, ", "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->restKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, ", or "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->keyKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    .line 353
    :cond_3
    :goto_1
    return-void

    :cond_4
    move-object v15, v3

    .line 94
    check-cast v15, Lgnu/lists/Pair;

    .line 96
    .local v15, "pair":Lgnu/lists/Pair;
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v16

    .line 97
    .local v16, "pair_car":Ljava/lang/Object;
    move-object/from16 v0, v16

    instance-of v0, v0, Lkawa/lang/SyntaxForm;

    move/from16 v22, v0

    if-eqz v22, :cond_5

    .line 98
    check-cast v16, Lkawa/lang/SyntaxForm;

    .end local v16    # "pair_car":Ljava/lang/Object;
    invoke-interface/range {v16 .. v16}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v16

    .line 99
    .restart local v16    # "pair_car":Ljava/lang/Object;
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->optionalKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v22

    if-ne v0, v1, :cond_9

    .line 101
    if-ltz v12, :cond_6

    .line 103
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "multiple "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->optionalKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " in parameter list"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto :goto_1

    .line 106
    :cond_6
    if-gez v17, :cond_7

    if-ltz v7, :cond_8

    .line 108
    :cond_7
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->optionalKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " after "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->restKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " or "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->keyKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 111
    :cond_8
    const/4 v12, 0x0

    .line 149
    :goto_2
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    .line 84
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    goto/16 :goto_0

    .line 113
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->restKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v22

    if-ne v0, v1, :cond_c

    .line 115
    if-ltz v17, :cond_a

    .line 117
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "multiple "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->restKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " in parameter list"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 121
    :cond_a
    if-ltz v7, :cond_b

    .line 123
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->restKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " after "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->keyKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 127
    :cond_b
    const/16 v17, 0x0

    goto :goto_2

    .line 129
    :cond_c
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->keyKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v22

    if-ne v0, v1, :cond_e

    .line 131
    if-ltz v7, :cond_d

    .line 133
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "multiple "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->keyKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " in parameter list"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 137
    :cond_d
    const/4 v7, 0x0

    goto/16 :goto_2

    .line 139
    :cond_e
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v22

    const-string v23, "::"

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_f

    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-eqz v22, :cond_f

    .line 140
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v15

    .end local v15    # "pair":Lgnu/lists/Pair;
    check-cast v15, Lgnu/lists/Pair;

    .restart local v15    # "pair":Lgnu/lists/Pair;
    goto/16 :goto_2

    .line 141
    :cond_f
    if-ltz v7, :cond_10

    .line 142
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_2

    .line 143
    :cond_10
    if-ltz v17, :cond_11

    .line 144
    add-int/lit8 v17, v17, 0x1

    goto/16 :goto_2

    .line 145
    :cond_11
    if-ltz v12, :cond_12

    .line 146
    add-int/lit8 v12, v12, 0x1

    goto/16 :goto_2

    .line 148
    :cond_12
    move-object/from16 v0, p1

    iget v0, v0, Lgnu/expr/LambdaExp;->min_args:I

    move/from16 v22, v0

    add-int/lit8 v22, v22, 0x1

    move/from16 v0, v22

    move-object/from16 v1, p1

    iput v0, v1, Lgnu/expr/LambdaExp;->min_args:I

    goto/16 :goto_2

    .line 159
    .end local v15    # "pair":Lgnu/lists/Pair;
    .end local v16    # "pair_car":Ljava/lang/Object;
    :cond_13
    const/16 v17, 0x1

    .line 166
    :cond_14
    const/16 v22, 0x1

    move/from16 v0, v17

    move/from16 v1, v22

    if-le v0, v1, :cond_16

    .line 168
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "multiple "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->restKeyword:Ljava/lang/Object;

    move-object/from16 v23, v0

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " parameters"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 161
    :cond_15
    sget-object v22, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v22

    if-eq v3, v0, :cond_14

    .line 163
    const-string v22, "misformed formals in lambda"

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 171
    :cond_16
    if-gez v12, :cond_17

    .line 172
    const/4 v12, 0x0

    .line 173
    :cond_17
    if-gez v17, :cond_18

    .line 174
    const/16 v17, 0x0

    .line 175
    :cond_18
    if-gez v7, :cond_19

    .line 176
    const/4 v7, 0x0

    .line 177
    :cond_19
    if-lez v17, :cond_1e

    .line 178
    const/16 v22, -0x1

    move/from16 v0, v22

    move-object/from16 v1, p1

    iput v0, v1, Lgnu/expr/LambdaExp;->max_args:I

    .line 181
    :goto_3
    add-int v22, v12, v7

    if-lez v22, :cond_1a

    .line 182
    add-int v22, v12, v7

    move/from16 v0, v22

    new-array v0, v0, [Lgnu/expr/Expression;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    move-object/from16 v1, p1

    iput-object v0, v1, Lgnu/expr/LambdaExp;->defaultArgs:[Lgnu/expr/Expression;

    .line 183
    :cond_1a
    if-lez v7, :cond_1b

    .line 184
    new-array v0, v7, [Lgnu/expr/Keyword;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    move-object/from16 v1, p1

    iput-object v0, v1, Lgnu/expr/LambdaExp;->keywords:[Lgnu/expr/Keyword;

    .line 186
    :cond_1b
    move-object/from16 v3, p2

    .line 187
    const/4 v12, 0x0

    .line 188
    const/4 v7, 0x0

    .line 189
    const/4 v10, 0x0

    .line 192
    :goto_4
    instance-of v0, v3, Lkawa/lang/SyntaxForm;

    move/from16 v22, v0

    if-eqz v22, :cond_1c

    move-object/from16 v19, v3

    .line 194
    check-cast v19, Lkawa/lang/SyntaxForm;

    .line 195
    .restart local v19    # "sf":Lkawa/lang/SyntaxForm;
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v3

    .line 198
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getScope()Lkawa/lang/TemplateScope;

    move-result-object p4

    .line 200
    .end local v19    # "sf":Lkawa/lang/SyntaxForm;
    :cond_1c
    move-object/from16 v20, p4

    .line 201
    .local v20, "templateScope":Lkawa/lang/TemplateScope;
    instance-of v0, v3, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-nez v22, :cond_1f

    .line 339
    instance-of v0, v3, Lkawa/lang/SyntaxForm;

    move/from16 v22, v0

    if-eqz v22, :cond_1d

    move-object/from16 v19, v3

    .line 341
    check-cast v19, Lkawa/lang/SyntaxForm;

    .line 342
    .restart local v19    # "sf":Lkawa/lang/SyntaxForm;
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v3

    .line 343
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getScope()Lkawa/lang/TemplateScope;

    move-result-object p4

    .line 345
    .end local v19    # "sf":Lkawa/lang/SyntaxForm;
    :cond_1d
    instance-of v0, v3, Lgnu/mapping/Symbol;

    move/from16 v22, v0

    if-eqz v22, :cond_3

    .line 347
    new-instance v4, Lgnu/expr/Declaration;

    invoke-direct {v4, v3}, Lgnu/expr/Declaration;-><init>(Ljava/lang/Object;)V

    .line 348
    .local v4, "decl":Lgnu/expr/Declaration;
    sget-object v22, Lgnu/kawa/lispexpr/LangObjType;->listType:Lgnu/kawa/lispexpr/LangObjType;

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 349
    const-wide/32 v22, 0x40000

    move-wide/from16 v0, v22

    invoke-virtual {v4, v0, v1}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 350
    const/16 v22, 0x0

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 351
    move-object/from16 v0, p4

    move-object/from16 v1, p1

    move-object/from16 v2, p3

    invoke-static {v4, v0, v1, v2}, Lkawa/lang/Lambda;->addParam(Lgnu/expr/Declaration;Lgnu/expr/ScopeExp;Lgnu/expr/LambdaExp;Lkawa/lang/Translator;)V

    goto/16 :goto_1

    .line 180
    .end local v4    # "decl":Lgnu/expr/Declaration;
    .end local v20    # "templateScope":Lkawa/lang/TemplateScope;
    :cond_1e
    move-object/from16 v0, p1

    iget v0, v0, Lgnu/expr/LambdaExp;->min_args:I

    move/from16 v22, v0

    add-int v22, v22, v12

    mul-int/lit8 v23, v7, 0x2

    add-int v22, v22, v23

    move/from16 v0, v22

    move-object/from16 v1, p1

    iput v0, v1, Lgnu/expr/LambdaExp;->max_args:I

    goto/16 :goto_3

    .restart local v20    # "templateScope":Lkawa/lang/TemplateScope;
    :cond_1f
    move-object v15, v3

    .line 203
    check-cast v15, Lgnu/lists/Pair;

    .line 204
    .restart local v15    # "pair":Lgnu/lists/Pair;
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v16

    .line 205
    .restart local v16    # "pair_car":Ljava/lang/Object;
    move-object/from16 v0, v16

    instance-of v0, v0, Lkawa/lang/SyntaxForm;

    move/from16 v22, v0

    if-eqz v22, :cond_20

    move-object/from16 v19, v16

    .line 207
    check-cast v19, Lkawa/lang/SyntaxForm;

    .line 208
    .restart local v19    # "sf":Lkawa/lang/SyntaxForm;
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v16

    .line 209
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getScope()Lkawa/lang/TemplateScope;

    move-result-object v20

    .line 211
    .end local v19    # "sf":Lkawa/lang/SyntaxForm;
    :cond_20
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->optionalKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v22

    if-eq v0, v1, :cond_21

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->restKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v22

    if-eq v0, v1, :cond_21

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->keyKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v22

    if-ne v0, v1, :cond_22

    .line 214
    :cond_21
    move-object/from16 v10, v16

    .line 190
    :goto_5
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    goto/16 :goto_4

    .line 217
    :cond_22
    move-object/from16 v0, p3

    invoke-virtual {v0, v15}, Lkawa/lang/Translator;->pushPositionOf(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    .line 218
    .local v18, "savePos":Ljava/lang/Object;
    const/4 v11, 0x0

    .line 219
    .local v11, "name":Ljava/lang/Object;
    move-object/from16 v0, p0

    iget-object v5, v0, Lkawa/lang/Lambda;->defaultDefault:Lgnu/expr/Expression;

    .line 220
    .local v5, "defaultValue":Lgnu/expr/Expression;
    const/16 v21, 0x0

    .line 222
    .local v21, "typeSpecPair":Lgnu/lists/Pair;
    const-string v22, "::"

    move-object/from16 v0, p3

    move-object/from16 v1, v16

    move-object/from16 v2, v22

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_23

    .line 224
    const-string v22, "\'::\' must follow parameter name"

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 227
    :cond_23
    move-object/from16 v0, p3

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->namespaceResolve(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    .line 228
    move-object/from16 v0, v16

    instance-of v0, v0, Lgnu/mapping/Symbol;

    move/from16 v22, v0

    if-eqz v22, :cond_26

    .line 230
    move-object/from16 v11, v16

    .line 231
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-eqz v22, :cond_25

    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lgnu/lists/Pair;

    .local v14, "p":Lgnu/lists/Pair;
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v22

    const-string v23, "::"

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_25

    .line 234
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-nez v22, :cond_24

    .line 236
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "\'::\' not followed by a type specifier (for parameter \'"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "\')"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 240
    :cond_24
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v14

    .end local v14    # "p":Lgnu/lists/Pair;
    check-cast v14, Lgnu/lists/Pair;

    .line 241
    .restart local v14    # "p":Lgnu/lists/Pair;
    move-object/from16 v21, v14

    .line 242
    move-object v15, v14

    .line 314
    .end local v5    # "defaultValue":Lgnu/expr/Expression;
    .end local v11    # "name":Ljava/lang/Object;
    .end local v14    # "p":Lgnu/lists/Pair;
    :cond_25
    if-nez v11, :cond_30

    .line 316
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "parameter is neither name nor (name :: type) nor (name default): "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 245
    .restart local v5    # "defaultValue":Lgnu/expr/Expression;
    .restart local v11    # "name":Ljava/lang/Object;
    :cond_26
    move-object/from16 v0, v16

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-eqz v22, :cond_25

    move-object/from16 v14, v16

    .line 247
    check-cast v14, Lgnu/lists/Pair;

    .line 248
    .restart local v14    # "p":Lgnu/lists/Pair;
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v16

    .line 249
    move-object/from16 v0, v16

    instance-of v0, v0, Lkawa/lang/SyntaxForm;

    move/from16 v22, v0

    if-eqz v22, :cond_27

    move-object/from16 v19, v16

    .line 251
    check-cast v19, Lkawa/lang/SyntaxForm;

    .line 252
    .restart local v19    # "sf":Lkawa/lang/SyntaxForm;
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getDatum()Ljava/lang/Object;

    move-result-object v16

    .line 253
    invoke-interface/range {v19 .. v19}, Lkawa/lang/SyntaxForm;->getScope()Lkawa/lang/TemplateScope;

    move-result-object v20

    .line 255
    .end local v19    # "sf":Lkawa/lang/SyntaxForm;
    :cond_27
    move-object/from16 v0, p3

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->namespaceResolve(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    .line 256
    move-object/from16 v0, v16

    instance-of v0, v0, Lgnu/mapping/Symbol;

    move/from16 v22, v0

    if-eqz v22, :cond_25

    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-eqz v22, :cond_25

    .line 259
    move-object/from16 v11, v16

    .line 260
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v14

    .end local v14    # "p":Lgnu/lists/Pair;
    check-cast v14, Lgnu/lists/Pair;

    .line 261
    .restart local v14    # "p":Lgnu/lists/Pair;
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v22

    const-string v23, "::"

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Ljava/lang/String;)Z

    move-result v22

    if-eqz v22, :cond_29

    .line 263
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-nez v22, :cond_28

    .line 265
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "\'::\' not followed by a type specifier (for parameter \'"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "\')"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 269
    :cond_28
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v14

    .end local v14    # "p":Lgnu/lists/Pair;
    check-cast v14, Lgnu/lists/Pair;

    .line 270
    .restart local v14    # "p":Lgnu/lists/Pair;
    move-object/from16 v21, v14

    .line 271
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-eqz v22, :cond_2b

    .line 272
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v14

    .end local v14    # "p":Lgnu/lists/Pair;
    check-cast v14, Lgnu/lists/Pair;

    .line 282
    .restart local v14    # "p":Lgnu/lists/Pair;
    :cond_29
    :goto_6
    if-eqz v14, :cond_2a

    if-eqz v10, :cond_2a

    .line 284
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    .line 285
    .local v5, "defaultValue":Ljava/lang/Object;
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    move-object/from16 v0, v22

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v22, v0

    if-eqz v22, :cond_2d

    .line 286
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v14

    .end local v14    # "p":Lgnu/lists/Pair;
    check-cast v14, Lgnu/lists/Pair;

    .line 296
    .end local v5    # "defaultValue":Ljava/lang/Object;
    .restart local v14    # "p":Lgnu/lists/Pair;
    :cond_2a
    :goto_7
    if-eqz v14, :cond_25

    .line 298
    if-eqz v21, :cond_2f

    .line 300
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "duplicate type specifier for parameter \'"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const/16 v23, 0x27

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 273
    .local v5, "defaultValue":Lgnu/expr/Expression;
    :cond_2b
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    sget-object v23, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    if-ne v0, v1, :cond_2c

    .line 274
    const/4 v14, 0x0

    goto :goto_6

    .line 277
    :cond_2c
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "improper list in specifier for parameter \'"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "\')"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 287
    .local v5, "defaultValue":Ljava/lang/Object;
    :cond_2d
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    sget-object v23, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    if-ne v0, v1, :cond_2e

    .line 288
    const/4 v14, 0x0

    goto :goto_7

    .line 291
    :cond_2e
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "improper list in specifier for parameter \'"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "\')"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 304
    .end local v5    # "defaultValue":Ljava/lang/Object;
    :cond_2f
    move-object/from16 v21, v14

    .line 305
    invoke-virtual {v14}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v22

    sget-object v23, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    if-eq v0, v1, :cond_25

    .line 307
    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "junk at end of specifier for parameter \'"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    const/16 v23, 0x27

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, " after type "

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual {v14}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v23

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    move-object/from16 v0, p3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto/16 :goto_1

    .line 319
    .end local v11    # "name":Ljava/lang/Object;
    .end local v14    # "p":Lgnu/lists/Pair;
    :cond_30
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->optionalKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    if-eq v10, v0, :cond_31

    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->keyKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    if-ne v10, v0, :cond_32

    .line 320
    :cond_31
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->defaultArgs:[Lgnu/expr/Expression;

    move-object/from16 v22, v0

    add-int/lit8 v13, v12, 0x1

    .end local v12    # "opt_args":I
    .local v13, "opt_args":I
    new-instance v23, Lgnu/expr/LangExp;

    move-object/from16 v0, v23

    invoke-direct {v0, v5}, Lgnu/expr/LangExp;-><init>(Ljava/lang/Object;)V

    aput-object v23, v22, v12

    move v12, v13

    .line 321
    .end local v13    # "opt_args":I
    .restart local v12    # "opt_args":I
    :cond_32
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->keyKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    if-ne v10, v0, :cond_33

    .line 322
    move-object/from16 v0, p1

    iget-object v0, v0, Lgnu/expr/LambdaExp;->keywords:[Lgnu/expr/Keyword;

    move-object/from16 v23, v0

    add-int/lit8 v8, v7, 0x1

    .end local v7    # "key_args":I
    .local v8, "key_args":I
    instance-of v0, v11, Lgnu/mapping/Symbol;

    move/from16 v22, v0

    if-eqz v22, :cond_35

    move-object/from16 v22, v11

    check-cast v22, Lgnu/mapping/Symbol;

    invoke-virtual/range {v22 .. v22}, Lgnu/mapping/Symbol;->getName()Ljava/lang/String;

    move-result-object v22

    :goto_8
    invoke-static/range {v22 .. v22}, Lgnu/expr/Keyword;->make(Ljava/lang/String;)Lgnu/expr/Keyword;

    move-result-object v22

    aput-object v22, v23, v7

    move v7, v8

    .line 325
    .end local v8    # "key_args":I
    .restart local v7    # "key_args":I
    :cond_33
    new-instance v4, Lgnu/expr/Declaration;

    invoke-direct {v4, v11}, Lgnu/expr/Declaration;-><init>(Ljava/lang/Object;)V

    .line 326
    .restart local v4    # "decl":Lgnu/expr/Declaration;
    invoke-static {v4, v3}, Lkawa/lang/Translator;->setLine(Lgnu/expr/Declaration;Ljava/lang/Object;)V

    .line 327
    if-eqz v21, :cond_36

    .line 329
    new-instance v22, Lgnu/expr/LangExp;

    move-object/from16 v0, v22

    move-object/from16 v1, v21

    invoke-direct {v0, v1}, Lgnu/expr/LangExp;-><init>(Ljava/lang/Object;)V

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setTypeExp(Lgnu/expr/Expression;)V

    .line 330
    const-wide/16 v22, 0x2000

    move-wide/from16 v0, v22

    invoke-virtual {v4, v0, v1}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 334
    :cond_34
    :goto_9
    const-wide/32 v22, 0x40000

    move-wide/from16 v0, v22

    invoke-virtual {v4, v0, v1}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 335
    const/16 v22, 0x0

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 336
    move-object/from16 v0, v20

    move-object/from16 v1, p1

    move-object/from16 v2, p3

    invoke-static {v4, v0, v1, v2}, Lkawa/lang/Lambda;->addParam(Lgnu/expr/Declaration;Lgnu/expr/ScopeExp;Lgnu/expr/LambdaExp;Lkawa/lang/Translator;)V

    .line 337
    move-object/from16 v0, p3

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    goto/16 :goto_5

    .line 322
    .end local v4    # "decl":Lgnu/expr/Declaration;
    .end local v7    # "key_args":I
    .restart local v8    # "key_args":I
    :cond_35
    invoke-virtual {v11}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v22

    goto :goto_8

    .line 332
    .end local v8    # "key_args":I
    .restart local v4    # "decl":Lgnu/expr/Declaration;
    .restart local v7    # "key_args":I
    :cond_36
    move-object/from16 v0, p0

    iget-object v0, v0, Lkawa/lang/Lambda;->restKeyword:Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    if-ne v10, v0, :cond_34

    .line 333
    sget-object v22, Lgnu/kawa/lispexpr/LangObjType;->listType:Lgnu/kawa/lispexpr/LangObjType;

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    goto :goto_9
.end method

.method public setKeywords(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .param p1, "optional"    # Ljava/lang/Object;
    .param p2, "rest"    # Ljava/lang/Object;
    .param p3, "key"    # Ljava/lang/Object;

    .prologue
    .line 26
    iput-object p1, p0, Lkawa/lang/Lambda;->optionalKeyword:Ljava/lang/Object;

    .line 27
    iput-object p2, p0, Lkawa/lang/Lambda;->restKeyword:Ljava/lang/Object;

    .line 28
    iput-object p3, p0, Lkawa/lang/Lambda;->keyKeyword:Ljava/lang/Object;

    .line 29
    return-void
.end method

.method public skipAttrs(Lgnu/expr/LambdaExp;Ljava/lang/Object;Lkawa/lang/Translator;)Ljava/lang/Object;
    .locals 3
    .param p1, "lexp"    # Lgnu/expr/LambdaExp;
    .param p2, "body"    # Ljava/lang/Object;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 526
    :goto_0
    instance-of v2, p2, Lgnu/lists/Pair;

    if-eqz v2, :cond_0

    move-object v1, p2

    .line 528
    check-cast v1, Lgnu/lists/Pair;

    .line 529
    .local v1, "pair":Lgnu/lists/Pair;
    invoke-virtual {v1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    instance-of v2, v2, Lgnu/lists/Pair;

    if-nez v2, :cond_1

    .line 538
    .end local v1    # "pair":Lgnu/lists/Pair;
    :cond_0
    :goto_1
    return-object p2

    .line 531
    .restart local v1    # "pair":Lgnu/lists/Pair;
    :cond_1
    invoke-virtual {v1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v0

    .line 532
    .local v0, "attrName":Ljava/lang/Object;
    const-string v2, "::"

    invoke-virtual {p3, v0, v2}, Lkawa/lang/Translator;->matches(Ljava/lang/Object;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 533
    const/4 v0, 0x0

    .line 536
    .end local v0    # "attrName":Ljava/lang/Object;
    :cond_2
    invoke-virtual {v1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lgnu/lists/Pair;

    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p2

    .line 537
    goto :goto_0

    .line 534
    .restart local v0    # "attrName":Ljava/lang/Object;
    :cond_3
    instance-of v2, v0, Lgnu/expr/Keyword;

    if-nez v2, :cond_2

    goto :goto_1
.end method
