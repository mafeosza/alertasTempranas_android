.class public Lgnu/kawa/lispexpr/MakeXmlElement;
.super Lkawa/lang/Syntax;
.source "MakeXmlElement.java"


# static fields
.field public static final makeXml:Lgnu/kawa/lispexpr/MakeXmlElement;

.field static final typeNamespace:Lgnu/bytecode/ClassType;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 19
    new-instance v0, Lgnu/kawa/lispexpr/MakeXmlElement;

    invoke-direct {v0}, Lgnu/kawa/lispexpr/MakeXmlElement;-><init>()V

    sput-object v0, Lgnu/kawa/lispexpr/MakeXmlElement;->makeXml:Lgnu/kawa/lispexpr/MakeXmlElement;

    .line 20
    sget-object v0, Lgnu/kawa/lispexpr/MakeXmlElement;->makeXml:Lgnu/kawa/lispexpr/MakeXmlElement;

    const-string v1, "$make-xml$"

    invoke-virtual {v0, v1}, Lgnu/kawa/lispexpr/MakeXmlElement;->setName(Ljava/lang/String;)V

    .line 22
    const-string v0, "gnu.mapping.Namespace"

    invoke-static {v0}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v0

    sput-object v0, Lgnu/kawa/lispexpr/MakeXmlElement;->typeNamespace:Lgnu/bytecode/ClassType;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    return-void
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 28
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 27
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lgnu/lists/Pair;

    .line 28
    .local v16, "pair1":Lgnu/lists/Pair;
    invoke-virtual/range {v16 .. v16}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v6

    .line 29
    .local v6, "namespaceList":Ljava/lang/Object;
    invoke-virtual/range {v16 .. v16}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v15

    .line 30
    .local v15, "obj":Ljava/lang/Object;
    const/4 v12, 0x0

    .line 31
    .local v12, "nsSeen":Z
    move-object/from16 v0, p2

    iget-object v0, v0, Lkawa/lang/Translator;->xmlElementNamespaces:Lgnu/xml/NamespaceBinding;

    move-object/from16 v18, v0

    .line 32
    .local v18, "saveBindings":Lgnu/xml/NamespaceBinding;
    move-object/from16 v9, v18

    .line 33
    .local v9, "nsBindings":Lgnu/xml/NamespaceBinding;
    :goto_0
    instance-of v0, v6, Lgnu/lists/Pair;

    move/from16 v26, v0

    if-eqz v26, :cond_7

    .line 35
    if-nez v12, :cond_0

    .line 37
    invoke-virtual/range {p2 .. p2}, Lkawa/lang/Translator;->letStart()V

    .line 38
    const/4 v12, 0x1

    :cond_0
    move-object v8, v6

    .line 40
    check-cast v8, Lgnu/lists/Pair;

    .line 41
    .local v8, "namespacePair":Lgnu/lists/Pair;
    invoke-virtual {v8}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lgnu/lists/Pair;

    .line 42
    .local v7, "namespaceNode":Lgnu/lists/Pair;
    invoke-virtual {v7}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 43
    .local v11, "nsPrefix":Ljava/lang/String;
    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v26

    if-nez v26, :cond_1

    const/4 v11, 0x0

    .line 44
    :goto_1
    invoke-virtual {v7}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v24

    .line 45
    .local v24, "valueList":Ljava/lang/Object;
    new-instance v20, Ljava/lang/StringBuilder;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuilder;-><init>()V

    .line 46
    .local v20, "sbuf":Ljava/lang/StringBuilder;
    :goto_2
    move-object/from16 v0, v24

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v26, v0

    if-eqz v26, :cond_4

    move-object/from16 v25, v24

    .line 48
    check-cast v25, Lgnu/lists/Pair;

    .line 49
    .local v25, "valuePair":Lgnu/lists/Pair;
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v23

    .line 51
    .local v23, "valueForm":Ljava/lang/Object;
    const/16 v26, 0x0

    move-object/from16 v0, v23

    move/from16 v1, v26

    invoke-static {v0, v1}, Lgnu/lists/LList;->listLength(Ljava/lang/Object;Z)I

    move-result v26

    const/16 v27, 0x2

    move/from16 v0, v26

    move/from16 v1, v27

    if-ne v0, v1, :cond_2

    move-object/from16 v0, v23

    instance-of v0, v0, Lgnu/lists/Pair;

    move/from16 v26, v0

    if-eqz v26, :cond_2

    move-object/from16 v26, v23

    check-cast v26, Lgnu/lists/Pair;

    invoke-virtual/range {v26 .. v26}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v26

    sget-object v27, Lgnu/kawa/xml/MakeText;->makeText:Lgnu/kawa/xml/MakeText;

    move-object/from16 v0, v26

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_2

    .line 55
    check-cast v23, Lgnu/lists/Pair;

    .end local v23    # "valueForm":Ljava/lang/Object;
    invoke-virtual/range {v23 .. v23}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Lgnu/lists/Pair;

    invoke-virtual/range {v26 .. v26}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v21

    .line 62
    .local v21, "value":Ljava/lang/Object;
    :goto_3
    if-nez v21, :cond_3

    .line 64
    move-object/from16 v0, p2

    move-object/from16 v1, v25

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->pushPositionOf(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    .line 65
    .local v19, "savePos":Ljava/lang/Object;
    const/16 v26, 0x65

    const-string v27, "namespace URI must be literal"

    move-object/from16 v0, p2

    move/from16 v1, v26

    move-object/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 66
    move-object/from16 v0, p2

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->popPositionOf(Ljava/lang/Object;)V

    .line 70
    .end local v19    # "savePos":Ljava/lang/Object;
    :goto_4
    invoke-virtual/range {v25 .. v25}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v24

    .line 71
    goto :goto_2

    .line 43
    .end local v20    # "sbuf":Ljava/lang/StringBuilder;
    .end local v21    # "value":Ljava/lang/Object;
    .end local v24    # "valueList":Ljava/lang/Object;
    .end local v25    # "valuePair":Lgnu/lists/Pair;
    :cond_1
    invoke-virtual {v11}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v11

    goto :goto_1

    .line 59
    .restart local v20    # "sbuf":Ljava/lang/StringBuilder;
    .restart local v23    # "valueForm":Ljava/lang/Object;
    .restart local v24    # "valueList":Ljava/lang/Object;
    .restart local v25    # "valuePair":Lgnu/lists/Pair;
    :cond_2
    const/16 v26, 0x0

    move-object/from16 v0, p2

    move-object/from16 v1, v25

    move/from16 v2, v26

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->rewrite_car(Lgnu/lists/Pair;Z)Lgnu/expr/Expression;

    move-result-object v22

    .line 60
    .local v22, "valueExp":Lgnu/expr/Expression;
    invoke-virtual/range {v22 .. v22}, Lgnu/expr/Expression;->valueIfConstant()Ljava/lang/Object;

    move-result-object v21

    .restart local v21    # "value":Ljava/lang/Object;
    goto :goto_3

    .line 69
    .end local v22    # "valueExp":Lgnu/expr/Expression;
    .end local v23    # "valueForm":Ljava/lang/Object;
    :cond_3
    invoke-virtual/range {v20 .. v21}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    goto :goto_4

    .line 72
    .end local v21    # "value":Ljava/lang/Object;
    .end local v25    # "valuePair":Lgnu/lists/Pair;
    :cond_4
    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v14

    .line 76
    .local v14, "nsUri":Ljava/lang/String;
    new-instance v10, Lgnu/xml/NamespaceBinding;

    const-string v26, ""

    move-object/from16 v0, v26

    if-ne v14, v0, :cond_5

    const/16 v26, 0x0

    :goto_5
    move-object/from16 v0, v26

    invoke-direct {v10, v11, v0, v9}, Lgnu/xml/NamespaceBinding;-><init>(Ljava/lang/String;Ljava/lang/String;Lgnu/xml/NamespaceBinding;)V

    .line 81
    .end local v9    # "nsBindings":Lgnu/xml/NamespaceBinding;
    .local v10, "nsBindings":Lgnu/xml/NamespaceBinding;
    if-nez v11, :cond_6

    .line 83
    invoke-static {v14}, Lgnu/mapping/Namespace;->valueOf(Ljava/lang/String;)Lgnu/mapping/Namespace;

    move-result-object v5

    .line 84
    .local v5, "namespace":Lgnu/mapping/Namespace;
    const-string v11, "[default-element-namespace]"

    .line 90
    :goto_6
    sget-object v26, Lgnu/mapping/Namespace;->EmptyNamespace:Lgnu/mapping/Namespace;

    move-object/from16 v0, v26

    invoke-virtual {v0, v11}, Lgnu/mapping/Namespace;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v13

    .line 91
    .local v13, "nsSymbol":Lgnu/mapping/Symbol;
    sget-object v26, Lgnu/kawa/lispexpr/MakeXmlElement;->typeNamespace:Lgnu/bytecode/ClassType;

    new-instance v27, Lgnu/expr/QuoteExp;

    move-object/from16 v0, v27

    invoke-direct {v0, v5}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    move-object/from16 v0, p2

    move-object/from16 v1, v26

    move-object/from16 v2, v27

    invoke-virtual {v0, v13, v1, v2}, Lkawa/lang/Translator;->letVariable(Ljava/lang/Object;Lgnu/bytecode/Type;Lgnu/expr/Expression;)Lgnu/expr/Declaration;

    move-result-object v3

    .line 93
    .local v3, "decl":Lgnu/expr/Declaration;
    const-wide/32 v26, 0x206000

    move-wide/from16 v0, v26

    invoke-virtual {v3, v0, v1}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 95
    invoke-virtual {v8}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    move-object v9, v10

    .line 96
    .end local v10    # "nsBindings":Lgnu/xml/NamespaceBinding;
    .restart local v9    # "nsBindings":Lgnu/xml/NamespaceBinding;
    goto/16 :goto_0

    .end local v3    # "decl":Lgnu/expr/Declaration;
    .end local v5    # "namespace":Lgnu/mapping/Namespace;
    .end local v13    # "nsSymbol":Lgnu/mapping/Symbol;
    :cond_5
    move-object/from16 v26, v14

    .line 76
    goto :goto_5

    .line 88
    .end local v9    # "nsBindings":Lgnu/xml/NamespaceBinding;
    .restart local v10    # "nsBindings":Lgnu/xml/NamespaceBinding;
    :cond_6
    invoke-static {v11, v14}, Lgnu/kawa/xml/XmlNamespace;->getInstance(Ljava/lang/String;Ljava/lang/String;)Lgnu/kawa/xml/XmlNamespace;

    move-result-object v5

    .restart local v5    # "namespace":Lgnu/mapping/Namespace;
    goto :goto_6

    .line 98
    .end local v5    # "namespace":Lgnu/mapping/Namespace;
    .end local v7    # "namespaceNode":Lgnu/lists/Pair;
    .end local v8    # "namespacePair":Lgnu/lists/Pair;
    .end local v10    # "nsBindings":Lgnu/xml/NamespaceBinding;
    .end local v11    # "nsPrefix":Ljava/lang/String;
    .end local v14    # "nsUri":Ljava/lang/String;
    .end local v20    # "sbuf":Ljava/lang/StringBuilder;
    .end local v24    # "valueList":Ljava/lang/Object;
    .restart local v9    # "nsBindings":Lgnu/xml/NamespaceBinding;
    :cond_7
    new-instance v4, Lgnu/kawa/xml/MakeElement;

    invoke-direct {v4}, Lgnu/kawa/xml/MakeElement;-><init>()V

    .line 99
    .local v4, "mkElement":Lgnu/kawa/xml/MakeElement;
    invoke-virtual {v4, v9}, Lgnu/kawa/xml/MakeElement;->setNamespaceNodes(Lgnu/xml/NamespaceBinding;)V

    .line 100
    move-object/from16 v0, p2

    iput-object v9, v0, Lkawa/lang/Translator;->xmlElementNamespaces:Lgnu/xml/NamespaceBinding;

    .line 103
    if-eqz v12, :cond_8

    .line 104
    :try_start_0
    invoke-virtual/range {p2 .. p2}, Lkawa/lang/Translator;->letEnter()V

    .line 105
    :cond_8
    move-object/from16 v0, p1

    invoke-static {v0, v4, v15}, Lkawa/lang/Translator;->makePair(Lgnu/lists/Pair;Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v26

    move-object/from16 v0, p2

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->rewrite(Ljava/lang/Object;)Lgnu/expr/Expression;

    move-result-object v17

    .line 106
    .local v17, "result":Lgnu/expr/Expression;
    if-eqz v12, :cond_9

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->letDone(Lgnu/expr/Expression;)Lgnu/expr/LetExp;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v17

    .line 110
    .end local v17    # "result":Lgnu/expr/Expression;
    :cond_9
    move-object/from16 v0, v18

    move-object/from16 v1, p2

    iput-object v0, v1, Lkawa/lang/Translator;->xmlElementNamespaces:Lgnu/xml/NamespaceBinding;

    return-object v17

    :catchall_0
    move-exception v26

    move-object/from16 v0, v18

    move-object/from16 v1, p2

    iput-object v0, v1, Lkawa/lang/Translator;->xmlElementNamespaces:Lgnu/xml/NamespaceBinding;

    throw v26
.end method
