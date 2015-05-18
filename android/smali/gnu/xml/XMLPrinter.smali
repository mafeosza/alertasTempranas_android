.class public Lgnu/xml/XMLPrinter;
.super Lgnu/mapping/OutPort;
.source "XMLPrinter.java"

# interfaces
.implements Lgnu/lists/PositionConsumer;
.implements Lgnu/lists/XConsumer;


# static fields
.field private static final COMMENT:I = -0x5

.field private static final ELEMENT_END:I = -0x4

.field private static final ELEMENT_START:I = -0x3

.field static final HtmlEmptyTags:Ljava/lang/String; = "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/"

.field private static final KEYWORD:I = -0x6

.field private static final PROC_INST:I = -0x7

.field private static final WORD:I = -0x2

.field public static final doctypePublic:Lgnu/mapping/ThreadLocation;

.field public static final doctypeSystem:Lgnu/mapping/ThreadLocation;

.field public static final indentLoc:Lgnu/mapping/ThreadLocation;


# instance fields
.field canonicalize:Z

.field public canonicalizeCDATA:Z

.field elementNameStack:[Ljava/lang/Object;

.field elementNesting:I

.field public escapeNonAscii:Z

.field public escapeText:Z

.field inAttribute:Z

.field inComment:I

.field inDocument:Z

.field inStartTag:Z

.field public indentAttributes:Z

.field isHtml:Z

.field isHtmlOrXhtml:Z

.field namespaceBindings:Lgnu/xml/NamespaceBinding;

.field namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

.field needXMLdecl:Z

.field prev:I

.field public printIndent:I

.field printXMLdecl:Z

.field savedHighSurrogate:C

.field public strict:Z

.field style:Ljava/lang/Object;

.field undeclareNamespaces:Z

.field public useEmptyElementTag:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 54
    new-instance v0, Lgnu/mapping/ThreadLocation;

    const-string v1, "doctype-system"

    invoke-direct {v0, v1}, Lgnu/mapping/ThreadLocation;-><init>(Ljava/lang/String;)V

    sput-object v0, Lgnu/xml/XMLPrinter;->doctypeSystem:Lgnu/mapping/ThreadLocation;

    .line 59
    new-instance v0, Lgnu/mapping/ThreadLocation;

    const-string v1, "doctype-public"

    invoke-direct {v0, v1}, Lgnu/mapping/ThreadLocation;-><init>(Ljava/lang/String;)V

    sput-object v0, Lgnu/xml/XMLPrinter;->doctypePublic:Lgnu/mapping/ThreadLocation;

    .line 61
    new-instance v0, Lgnu/mapping/ThreadLocation;

    const-string v1, "xml-indent"

    invoke-direct {v0, v1}, Lgnu/mapping/ThreadLocation;-><init>(Ljava/lang/String;)V

    sput-object v0, Lgnu/xml/XMLPrinter;->indentLoc:Lgnu/mapping/ThreadLocation;

    return-void
.end method

.method public constructor <init>(Lgnu/mapping/OutPort;Z)V
    .locals 4
    .param p1, "out"    # Lgnu/mapping/OutPort;
    .param p2, "autoFlush"    # Z

    .prologue
    const/16 v3, 0x14

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 90
    invoke-direct {p0, p1, p2}, Lgnu/mapping/OutPort;-><init>(Lgnu/mapping/OutPort;Z)V

    .line 25
    const/4 v0, -0x1

    iput v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    .line 29
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->printXMLdecl:Z

    .line 32
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 33
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    .line 36
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    .line 37
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->canonicalize:Z

    .line 45
    const/4 v0, 0x2

    iput v0, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    .line 46
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    .line 47
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeNonAscii:Z

    .line 48
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtml:Z

    .line 49
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    .line 50
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->undeclareNamespaces:Z

    .line 67
    sget-object v0, Lgnu/xml/NamespaceBinding;->predefinedXML:Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 70
    new-array v0, v3, [Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    .line 72
    new-array v0, v3, [Ljava/lang/Object;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    .line 84
    const/16 v0, 0x20

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 91
    return-void
.end method

.method public constructor <init>(Ljava/io/OutputStream;)V
    .locals 4
    .param p1, "out"    # Ljava/io/OutputStream;

    .prologue
    const/16 v3, 0x14

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 110
    new-instance v0, Ljava/io/OutputStreamWriter;

    invoke-direct {v0, p1}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    invoke-direct {p0, v0, v1, v1}, Lgnu/mapping/OutPort;-><init>(Ljava/io/Writer;ZZ)V

    .line 25
    const/4 v0, -0x1

    iput v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    .line 29
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->printXMLdecl:Z

    .line 32
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 33
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    .line 36
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    .line 37
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->canonicalize:Z

    .line 45
    const/4 v0, 0x2

    iput v0, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    .line 46
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    .line 47
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeNonAscii:Z

    .line 48
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtml:Z

    .line 49
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    .line 50
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->undeclareNamespaces:Z

    .line 67
    sget-object v0, Lgnu/xml/NamespaceBinding;->predefinedXML:Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 70
    new-array v0, v3, [Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    .line 72
    new-array v0, v3, [Ljava/lang/Object;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    .line 84
    const/16 v0, 0x20

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 111
    return-void
.end method

.method public constructor <init>(Ljava/io/OutputStream;Lgnu/text/Path;)V
    .locals 4
    .param p1, "out"    # Ljava/io/OutputStream;
    .param p2, "path"    # Lgnu/text/Path;

    .prologue
    const/16 v3, 0x14

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 115
    new-instance v0, Ljava/io/OutputStreamWriter;

    invoke-direct {v0, p1}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    invoke-direct {p0, v0, v2, v1, p2}, Lgnu/mapping/OutPort;-><init>(Ljava/io/Writer;ZZLgnu/text/Path;)V

    .line 25
    const/4 v0, -0x1

    iput v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    .line 29
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->printXMLdecl:Z

    .line 32
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 33
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    .line 36
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    .line 37
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->canonicalize:Z

    .line 45
    const/4 v0, 0x2

    iput v0, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    .line 46
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    .line 47
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeNonAscii:Z

    .line 48
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtml:Z

    .line 49
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    .line 50
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->undeclareNamespaces:Z

    .line 67
    sget-object v0, Lgnu/xml/NamespaceBinding;->predefinedXML:Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 70
    new-array v0, v3, [Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    .line 72
    new-array v0, v3, [Ljava/lang/Object;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    .line 84
    const/16 v0, 0x20

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 116
    return-void
.end method

.method public constructor <init>(Ljava/io/OutputStream;Z)V
    .locals 4
    .param p1, "out"    # Ljava/io/OutputStream;
    .param p2, "autoFlush"    # Z

    .prologue
    const/16 v3, 0x14

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 100
    new-instance v0, Ljava/io/OutputStreamWriter;

    invoke-direct {v0, p1}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    invoke-direct {p0, v0, v2, p2}, Lgnu/mapping/OutPort;-><init>(Ljava/io/Writer;ZZ)V

    .line 25
    const/4 v0, -0x1

    iput v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    .line 29
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->printXMLdecl:Z

    .line 32
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 33
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    .line 36
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    .line 37
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->canonicalize:Z

    .line 45
    const/4 v0, 0x2

    iput v0, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    .line 46
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    .line 47
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeNonAscii:Z

    .line 48
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtml:Z

    .line 49
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    .line 50
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->undeclareNamespaces:Z

    .line 67
    sget-object v0, Lgnu/xml/NamespaceBinding;->predefinedXML:Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 70
    new-array v0, v3, [Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    .line 72
    new-array v0, v3, [Ljava/lang/Object;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    .line 84
    const/16 v0, 0x20

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 101
    return-void
.end method

.method public constructor <init>(Ljava/io/Writer;)V
    .locals 4
    .param p1, "out"    # Ljava/io/Writer;

    .prologue
    const/16 v3, 0x14

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 105
    invoke-direct {p0, p1}, Lgnu/mapping/OutPort;-><init>(Ljava/io/Writer;)V

    .line 25
    const/4 v0, -0x1

    iput v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    .line 29
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->printXMLdecl:Z

    .line 32
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 33
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    .line 36
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    .line 37
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->canonicalize:Z

    .line 45
    const/4 v0, 0x2

    iput v0, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    .line 46
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    .line 47
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeNonAscii:Z

    .line 48
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtml:Z

    .line 49
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    .line 50
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->undeclareNamespaces:Z

    .line 67
    sget-object v0, Lgnu/xml/NamespaceBinding;->predefinedXML:Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 70
    new-array v0, v3, [Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    .line 72
    new-array v0, v3, [Ljava/lang/Object;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    .line 84
    const/16 v0, 0x20

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 106
    return-void
.end method

.method public constructor <init>(Ljava/io/Writer;Z)V
    .locals 4
    .param p1, "out"    # Ljava/io/Writer;
    .param p2, "autoFlush"    # Z

    .prologue
    const/16 v3, 0x14

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 95
    invoke-direct {p0, p1, p2}, Lgnu/mapping/OutPort;-><init>(Ljava/io/Writer;Z)V

    .line 25
    const/4 v0, -0x1

    iput v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    .line 29
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->printXMLdecl:Z

    .line 32
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 33
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    .line 36
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    .line 37
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->canonicalize:Z

    .line 45
    const/4 v0, 0x2

    iput v0, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    .line 46
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    .line 47
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->escapeNonAscii:Z

    .line 48
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtml:Z

    .line 49
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    .line 50
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->undeclareNamespaces:Z

    .line 67
    sget-object v0, Lgnu/xml/NamespaceBinding;->predefinedXML:Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 70
    new-array v0, v3, [Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    .line 72
    new-array v0, v3, [Ljava/lang/Object;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    .line 84
    const/16 v0, 0x20

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 96
    return-void
.end method

.method static formatDecimal(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    const/16 v5, 0x2e

    .line 692
    invoke-virtual {p0, v5}, Ljava/lang/String;->indexOf(I)I

    move-result v1

    .line 693
    .local v1, "dot":I
    if-ltz v1, :cond_2

    .line 695
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    .line 696
    .local v2, "len":I
    move v3, v2

    .line 698
    .local v3, "pos":I
    :cond_0
    add-int/lit8 v3, v3, -0x1

    invoke-virtual {p0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 699
    .local v0, "ch":C
    const/16 v4, 0x30

    if-eq v0, v4, :cond_0

    .line 701
    if-eq v0, v5, :cond_1

    .line 702
    add-int/lit8 v3, v3, 0x1

    .line 703
    :cond_1
    if-ne v3, v2, :cond_3

    .line 707
    .end local v0    # "ch":C
    .end local v2    # "len":I
    .end local v3    # "pos":I
    .end local p0    # "str":Ljava/lang/String;
    :cond_2
    :goto_0
    return-object p0

    .line 703
    .restart local v0    # "ch":C
    .restart local v2    # "len":I
    .restart local v3    # "pos":I
    .restart local p0    # "str":Ljava/lang/String;
    :cond_3
    const/4 v4, 0x0

    invoke-virtual {p0, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    goto :goto_0
.end method

.method public static formatDecimal(Ljava/math/BigDecimal;)Ljava/lang/String;
    .locals 1
    .param p0, "dec"    # Ljava/math/BigDecimal;

    .prologue
    .line 684
    invoke-virtual {p0}, Ljava/math/BigDecimal;->toPlainString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lgnu/xml/XMLPrinter;->formatDecimal(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static formatDouble(D)Ljava/lang/String;
    .locals 8
    .param p0, "d"    # D

    .prologue
    const-wide/16 v6, 0x0

    .line 643
    invoke-static {p0, p1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 644
    const-string v4, "NaN"

    .line 655
    :goto_0
    return-object v4

    .line 645
    :cond_0
    cmpg-double v4, p0, v6

    if-gez v4, :cond_1

    const/4 v3, 0x1

    .line 646
    .local v3, "neg":Z
    :goto_1
    invoke-static {p0, p1}, Ljava/lang/Double;->isInfinite(D)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 647
    if-eqz v3, :cond_2

    const-string v4, "-INF"

    goto :goto_0

    .line 645
    .end local v3    # "neg":Z
    :cond_1
    const/4 v3, 0x0

    goto :goto_1

    .line 647
    .restart local v3    # "neg":Z
    :cond_2
    const-string v4, "INF"

    goto :goto_0

    .line 648
    :cond_3
    if-eqz v3, :cond_5

    neg-double v0, p0

    .line 649
    .local v0, "dabs":D
    :goto_2
    invoke-static {p0, p1}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v2

    .line 652
    .local v2, "dstr":Ljava/lang/String;
    const-wide v4, 0x412e848000000000L    # 1000000.0

    cmpl-double v4, v0, v4

    if-gez v4, :cond_4

    const-wide v4, 0x3eb0c6f7a0b5ed8dL    # 1.0E-6

    cmpg-double v4, v0, v4

    if-gez v4, :cond_6

    :cond_4
    cmpl-double v4, v0, v6

    if-eqz v4, :cond_6

    .line 653
    invoke-static {v2}, Lgnu/math/RealNum;->toStringScientific(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .end local v0    # "dabs":D
    .end local v2    # "dstr":Ljava/lang/String;
    :cond_5
    move-wide v0, p0

    .line 648
    goto :goto_2

    .line 655
    .restart local v0    # "dabs":D
    .restart local v2    # "dstr":Ljava/lang/String;
    :cond_6
    invoke-static {v2}, Lgnu/math/RealNum;->toStringDecimal(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lgnu/xml/XMLPrinter;->formatDecimal(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    goto :goto_0
.end method

.method public static formatFloat(F)Ljava/lang/String;
    .locals 7
    .param p0, "f"    # F

    .prologue
    .line 661
    invoke-static {p0}, Ljava/lang/Float;->isNaN(F)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 662
    const-string v3, "NaN"

    .line 673
    :goto_0
    return-object v3

    .line 663
    :cond_0
    const/4 v3, 0x0

    cmpg-float v3, p0, v3

    if-gez v3, :cond_1

    const/4 v2, 0x1

    .line 664
    .local v2, "neg":Z
    :goto_1
    invoke-static {p0}, Ljava/lang/Float;->isInfinite(F)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 665
    if-eqz v2, :cond_2

    const-string v3, "-INF"

    goto :goto_0

    .line 663
    .end local v2    # "neg":Z
    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    .line 665
    .restart local v2    # "neg":Z
    :cond_2
    const-string v3, "INF"

    goto :goto_0

    .line 666
    :cond_3
    if-eqz v2, :cond_5

    neg-float v0, p0

    .line 667
    .local v0, "fabs":F
    :goto_2
    invoke-static {p0}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v1

    .line 670
    .local v1, "fstr":Ljava/lang/String;
    const v3, 0x49742400    # 1000000.0f

    cmpl-float v3, v0, v3

    if-gez v3, :cond_4

    float-to-double v3, v0

    const-wide v5, 0x3eb0c6f7a0b5ed8dL    # 1.0E-6

    cmpg-double v3, v3, v5

    if-gez v3, :cond_6

    :cond_4
    float-to-double v3, v0

    const-wide/16 v5, 0x0

    cmpl-double v3, v3, v5

    if-eqz v3, :cond_6

    .line 671
    invoke-static {v1}, Lgnu/math/RealNum;->toStringScientific(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0

    .end local v0    # "fabs":F
    .end local v1    # "fstr":Ljava/lang/String;
    :cond_5
    move v0, p0

    .line 666
    goto :goto_2

    .line 673
    .restart local v0    # "fabs":F
    .restart local v1    # "fstr":Ljava/lang/String;
    :cond_6
    invoke-static {v1}, Lgnu/math/RealNum;->toStringDecimal(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lgnu/xml/XMLPrinter;->formatDecimal(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public static isHtmlEmptyElementTag(Ljava/lang/String;)Z
    .locals 4
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    const/16 v3, 0x2f

    .line 514
    const-string v1, "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/"

    invoke-virtual {v1, p0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 515
    .local v0, "index":I
    if-lez v0, :cond_0

    const-string v1, "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/"

    add-int/lit8 v2, v0, -0x1

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v1

    if-ne v1, v3, :cond_0

    const-string v1, "/area/base/basefont/br/col/frame/hr/img/input/isindex/link/meta/para/"

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v2, v0

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v1

    if-ne v1, v3, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static make(Lgnu/mapping/OutPort;Ljava/lang/Object;)Lgnu/xml/XMLPrinter;
    .locals 2
    .param p0, "out"    # Lgnu/mapping/OutPort;
    .param p1, "style"    # Ljava/lang/Object;

    .prologue
    .line 120
    new-instance v0, Lgnu/xml/XMLPrinter;

    const/4 v1, 0x1

    invoke-direct {v0, p0, v1}, Lgnu/xml/XMLPrinter;-><init>(Lgnu/mapping/OutPort;Z)V

    .line 121
    .local v0, "xout":Lgnu/xml/XMLPrinter;
    invoke-virtual {v0, p1}, Lgnu/xml/XMLPrinter;->setStyle(Ljava/lang/Object;)V

    .line 122
    return-object v0
.end method

.method private startWord()V
    .locals 0

    .prologue
    .line 241
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 242
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->writeWordStart()V

    .line 243
    return-void
.end method

.method public static toString(Ljava/lang/Object;)Ljava/lang/String;
    .locals 2
    .param p0, "value"    # Ljava/lang/Object;

    .prologue
    .line 129
    new-instance v0, Ljava/io/StringWriter;

    invoke-direct {v0}, Ljava/io/StringWriter;-><init>()V

    .line 130
    .local v0, "stringWriter":Ljava/io/StringWriter;
    new-instance v1, Lgnu/xml/XMLPrinter;

    invoke-direct {v1, v0}, Lgnu/xml/XMLPrinter;-><init>(Ljava/io/Writer;)V

    invoke-virtual {v1, p0}, Lgnu/xml/XMLPrinter;->writeObject(Ljava/lang/Object;)V

    .line 131
    invoke-virtual {v0}, Ljava/io/StringWriter;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public beginComment()V
    .locals 2

    .prologue
    .line 842
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 843
    iget v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v0, :cond_1

    .line 845
    iget v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    const/4 v1, -0x3

    if-eq v0, v1, :cond_0

    iget v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    const/4 v1, -0x4

    if-eq v0, v1, :cond_0

    iget v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    const/4 v1, -0x5

    if-ne v0, v1, :cond_1

    .line 846
    :cond_0
    iget v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-lez v0, :cond_2

    const/16 v0, 0x52

    :goto_0
    invoke-virtual {p0, v0}, Lgnu/xml/XMLPrinter;->writeBreak(I)V

    .line 849
    :cond_1
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v1, "<!--"

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 850
    const/4 v0, 0x1

    iput v0, p0, Lgnu/xml/XMLPrinter;->inComment:I

    .line 851
    return-void

    .line 846
    :cond_2
    const/16 v0, 0x4e

    goto :goto_0
.end method

.method public beginEntity(Ljava/lang/Object;)V
    .locals 0
    .param p1, "base"    # Ljava/lang/Object;

    .prologue
    .line 323
    return-void
.end method

.method public closeTag()V
    .locals 5

    .prologue
    const/16 v4, 0x3e

    const/4 v3, 0x0

    .line 264
    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    if-eqz v0, :cond_2

    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    if-nez v0, :cond_2

    .line 266
    iget v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v0, :cond_0

    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->indentAttributes:Z

    if-eqz v0, :cond_0

    .line 267
    const-string v0, ""

    invoke-virtual {p0, v0}, Lgnu/xml/XMLPrinter;->endLogicalBlock(Ljava/lang/String;)V

    .line 268
    :cond_0
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v0, v4}, Lgnu/text/PrettyWriter;->write(I)V

    .line 269
    iput-boolean v3, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    .line 270
    const/4 v0, -0x3

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 283
    :cond_1
    :goto_0
    return-void

    .line 272
    :cond_2
    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    if-eqz v0, :cond_1

    .line 275
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v1, "<?xml version=\"1.0\"?>\n"

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 276
    iget v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v0, :cond_3

    .line 278
    const-string v0, ""

    const-string v1, ""

    const/4 v2, 0x2

    invoke-virtual {p0, v0, v1, v2}, Lgnu/xml/XMLPrinter;->startLogicalBlock(Ljava/lang/String;Ljava/lang/String;I)V

    .line 280
    :cond_3
    iput-boolean v3, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    .line 281
    iput v4, p0, Lgnu/xml/XMLPrinter;->prev:I

    goto :goto_0
.end method

.method public consume(Lgnu/lists/SeqPosition;)V
    .locals 2
    .param p1, "position"    # Lgnu/lists/SeqPosition;

    .prologue
    .line 919
    iget-object v0, p1, Lgnu/lists/SeqPosition;->sequence:Lgnu/lists/AbstractSequence;

    iget v1, p1, Lgnu/lists/SeqPosition;->ipos:I

    invoke-virtual {v0, v1, p0}, Lgnu/lists/AbstractSequence;->consumeNext(ILgnu/lists/Consumer;)Z

    .line 920
    return-void
.end method

.method public endAttribute()V
    .locals 2

    .prologue
    .line 617
    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    if-eqz v0, :cond_1

    .line 619
    iget v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    const/4 v1, -0x6

    if-eq v0, v1, :cond_0

    .line 621
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const/16 v1, 0x22

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(I)V

    .line 622
    const/4 v0, 0x0

    iput-boolean v0, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 624
    :cond_0
    const/16 v0, 0x20

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 626
    :cond_1
    return-void
.end method

.method public endComment()V
    .locals 2

    .prologue
    .line 855
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v1, "-->"

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 856
    const/4 v0, -0x5

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 857
    const/4 v0, 0x0

    iput v0, p0, Lgnu/xml/XMLPrinter;->inComment:I

    .line 858
    return-void
.end method

.method public endDocument()V
    .locals 1

    .prologue
    .line 315
    const/4 v0, 0x0

    iput-boolean v0, p0, Lgnu/xml/XMLPrinter;->inDocument:Z

    .line 316
    iget v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v0, :cond_0

    .line 317
    const-string v0, ""

    invoke-virtual {p0, v0}, Lgnu/xml/XMLPrinter;->endLogicalBlock(Ljava/lang/String;)V

    .line 318
    :cond_0
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->freshLine()V

    .line 319
    return-void
.end method

.method public endElement()V
    .locals 14

    .prologue
    const/4 v13, 0x0

    const/4 v8, 0x1

    const/4 v12, -0x4

    const/4 v9, 0x0

    .line 536
    iget v10, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    if-nez v10, :cond_0

    .line 537
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 538
    :cond_0
    iget-object v10, p0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    iget v11, p0, Lgnu/xml/XMLPrinter;->elementNesting:I

    add-int/lit8 v11, v11, -0x1

    aget-object v5, v10, v11

    .line 541
    .local v5, "type":Ljava/lang/Object;
    invoke-virtual {p0, v5}, Lgnu/xml/XMLPrinter;->getHtmlTag(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 543
    .local v6, "typeName":Ljava/lang/String;
    iget-boolean v10, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    if-eqz v10, :cond_d

    .line 545
    iget v10, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v10, :cond_1

    iget-boolean v10, p0, Lgnu/xml/XMLPrinter;->indentAttributes:Z

    if-eqz v10, :cond_1

    .line 547
    const-string v10, ""

    invoke-virtual {p0, v10}, Lgnu/xml/XMLPrinter;->endLogicalBlock(Ljava/lang/String;)V

    .line 549
    :cond_1
    const/4 v0, 0x0

    .line 550
    .local v0, "end":Ljava/lang/String;
    if-eqz v6, :cond_8

    invoke-static {v6}, Lgnu/xml/XMLPrinter;->isHtmlEmptyElementTag(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_8

    move v1, v8

    .line 551
    .local v1, "isEmpty":Z
    :goto_0
    iget v10, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    if-eqz v10, :cond_2

    if-eqz v6, :cond_3

    if-nez v1, :cond_3

    .line 554
    :cond_2
    instance-of v10, v5, Lgnu/mapping/Symbol;

    if-eqz v10, :cond_3

    move-object v4, v5

    .line 556
    check-cast v4, Lgnu/mapping/Symbol;

    .line 557
    .local v4, "sym":Lgnu/mapping/Symbol;
    invoke-virtual {v4}, Lgnu/mapping/Symbol;->getPrefix()Ljava/lang/String;

    move-result-object v3

    .line 558
    .local v3, "prefix":Ljava/lang/String;
    invoke-virtual {v4}, Lgnu/mapping/Symbol;->getNamespaceURI()Ljava/lang/String;

    move-result-object v7

    .line 559
    .local v7, "uri":Ljava/lang/String;
    invoke-virtual {v4}, Lgnu/mapping/Symbol;->getLocalName()Ljava/lang/String;

    move-result-object v2

    .line 560
    .local v2, "local":Ljava/lang/String;
    const-string v10, ""

    if-eq v3, v10, :cond_9

    .line 561
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "></"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ":"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ">"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 566
    .end local v2    # "local":Ljava/lang/String;
    .end local v3    # "prefix":Ljava/lang/String;
    .end local v4    # "sym":Lgnu/mapping/Symbol;
    .end local v7    # "uri":Ljava/lang/String;
    :cond_3
    :goto_1
    if-nez v0, :cond_4

    .line 567
    if-eqz v1, :cond_b

    iget-boolean v10, p0, Lgnu/xml/XMLPrinter;->isHtml:Z

    if-eqz v10, :cond_b

    const-string v0, ">"

    .line 568
    :cond_4
    :goto_2
    iget-object v10, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v10, v0}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 569
    iput-boolean v9, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    .line 584
    .end local v0    # "end":Ljava/lang/String;
    .end local v1    # "isEmpty":Z
    :goto_3
    iget v9, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v9, :cond_5

    .line 586
    const-string v9, ""

    invoke-virtual {p0, v9}, Lgnu/xml/XMLPrinter;->endLogicalBlock(Ljava/lang/String;)V

    .line 588
    :cond_5
    iput v12, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 589
    if-eqz v6, :cond_7

    iget-boolean v9, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    if-nez v9, :cond_7

    const-string v9, "script"

    invoke-virtual {v9, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_6

    const-string v9, "style"

    invoke-virtual {v9, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 591
    :cond_6
    iput-boolean v8, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    .line 593
    :cond_7
    iget-object v8, p0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    iget v9, p0, Lgnu/xml/XMLPrinter;->elementNesting:I

    add-int/lit8 v9, v9, -0x1

    iput v9, p0, Lgnu/xml/XMLPrinter;->elementNesting:I

    aget-object v8, v8, v9

    iput-object v8, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 594
    iget-object v8, p0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    iget v9, p0, Lgnu/xml/XMLPrinter;->elementNesting:I

    aput-object v13, v8, v9

    .line 595
    iget-object v8, p0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    iget v9, p0, Lgnu/xml/XMLPrinter;->elementNesting:I

    aput-object v13, v8, v9

    .line 596
    return-void

    .restart local v0    # "end":Ljava/lang/String;
    :cond_8
    move v1, v9

    .line 550
    goto/16 :goto_0

    .line 562
    .restart local v1    # "isEmpty":Z
    .restart local v2    # "local":Ljava/lang/String;
    .restart local v3    # "prefix":Ljava/lang/String;
    .restart local v4    # "sym":Lgnu/mapping/Symbol;
    .restart local v7    # "uri":Ljava/lang/String;
    :cond_9
    const-string v10, ""

    if-eq v7, v10, :cond_a

    if-nez v7, :cond_3

    .line 563
    :cond_a
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "></"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, ">"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 567
    .end local v2    # "local":Ljava/lang/String;
    .end local v3    # "prefix":Ljava/lang/String;
    .end local v4    # "sym":Lgnu/mapping/Symbol;
    .end local v7    # "uri":Ljava/lang/String;
    :cond_b
    iget v10, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    const/4 v11, 0x2

    if-ne v10, v11, :cond_c

    const-string v0, " />"

    goto :goto_2

    :cond_c
    const-string v0, "/>"

    goto :goto_2

    .line 573
    .end local v0    # "end":Ljava/lang/String;
    .end local v1    # "isEmpty":Z
    :cond_d
    iget v10, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v10, :cond_e

    .line 575
    invoke-virtual {p0, v9, v9}, Lgnu/xml/XMLPrinter;->setIndentation(IZ)V

    .line 576
    iget v9, p0, Lgnu/xml/XMLPrinter;->prev:I

    if-ne v9, v12, :cond_e

    .line 577
    iget v9, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-lez v9, :cond_f

    const/16 v9, 0x52

    :goto_4
    invoke-virtual {p0, v9}, Lgnu/xml/XMLPrinter;->writeBreak(I)V

    .line 580
    :cond_e
    iget-object v9, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v10, "</"

    invoke-virtual {v9, v10}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 581
    invoke-virtual {p0, v5}, Lgnu/xml/XMLPrinter;->writeQName(Ljava/lang/Object;)V

    .line 582
    iget-object v9, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v10, ">"

    invoke-virtual {v9, v10}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto/16 :goto_3

    .line 577
    :cond_f
    const/16 v9, 0x4e

    goto :goto_4
.end method

.method public endEntity()V
    .locals 0

    .prologue
    .line 327
    return-void
.end method

.method protected endNumber()V
    .locals 0

    .prologue
    .line 259
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->writeWordEnd()V

    .line 260
    return-void
.end method

.method public error(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "code"    # Ljava/lang/String;

    .prologue
    .line 924
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "serialization error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x5d

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected getHtmlTag(Ljava/lang/Object;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Ljava/lang/Object;

    .prologue
    .line 521
    instance-of v2, p1, Lgnu/mapping/Symbol;

    if-eqz v2, :cond_1

    move-object v0, p1

    .line 523
    check-cast v0, Lgnu/mapping/Symbol;

    .line 524
    .local v0, "sym":Lgnu/mapping/Symbol;
    invoke-virtual {v0}, Lgnu/mapping/Symbol;->getNamespaceURI()Ljava/lang/String;

    move-result-object v1

    .line 525
    .local v1, "uri":Ljava/lang/String;
    const-string v2, "http://www.w3.org/1999/xhtml"

    if-eq v1, v2, :cond_0

    iget-boolean v2, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    if-eqz v2, :cond_2

    const-string v2, ""

    if-ne v1, v2, :cond_2

    .line 527
    :cond_0
    invoke-virtual {v0}, Lgnu/mapping/Symbol;->getLocalPart()Ljava/lang/String;

    move-result-object v2

    .line 531
    .end local v0    # "sym":Lgnu/mapping/Symbol;
    .end local v1    # "uri":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 529
    :cond_1
    iget-boolean v2, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    if-eqz v2, :cond_2

    .line 530
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 531
    :cond_2
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public ignoring()Z
    .locals 1

    .prologue
    .line 770
    const/4 v0, 0x0

    return v0
.end method

.method mustHexEscape(I)Z
    .locals 1
    .param p1, "v"    # I

    .prologue
    .line 160
    const/16 v0, 0x7f

    if-lt p1, v0, :cond_0

    const/16 v0, 0x9f

    if-le p1, v0, :cond_1

    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->escapeNonAscii:Z

    if-nez v0, :cond_1

    :cond_0
    const/16 v0, 0x2028

    if-eq p1, v0, :cond_1

    const/16 v0, 0x20

    if-ge p1, v0, :cond_2

    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    if-nez v0, :cond_1

    const/16 v0, 0x9

    if-eq p1, v0, :cond_2

    const/16 v0, 0xa

    if-eq p1, v0, :cond_2

    :cond_1
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public print(Ljava/lang/Object;)V
    .locals 2
    .param p1, "v"    # Ljava/lang/Object;

    .prologue
    .line 712
    instance-of v0, p1, Ljava/math/BigDecimal;

    if-eqz v0, :cond_1

    .line 713
    check-cast p1, Ljava/math/BigDecimal;

    .end local p1    # "v":Ljava/lang/Object;
    invoke-static {p1}, Lgnu/xml/XMLPrinter;->formatDecimal(Ljava/math/BigDecimal;)Ljava/lang/String;

    move-result-object p1

    .line 718
    :cond_0
    :goto_0
    if-nez p1, :cond_4

    const-string v0, "(null)"

    :goto_1
    invoke-virtual {p0, v0}, Lgnu/xml/XMLPrinter;->write(Ljava/lang/String;)V

    .line 719
    return-void

    .line 714
    .restart local p1    # "v":Ljava/lang/Object;
    :cond_1
    instance-of v0, p1, Ljava/lang/Double;

    if-nez v0, :cond_2

    instance-of v0, p1, Lgnu/math/DFloNum;

    if-eqz v0, :cond_3

    .line 715
    :cond_2
    check-cast p1, Ljava/lang/Number;

    .end local p1    # "v":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/Number;->doubleValue()D

    move-result-wide v0

    invoke-static {v0, v1}, Lgnu/xml/XMLPrinter;->formatDouble(D)Ljava/lang/String;

    move-result-object p1

    .local p1, "v":Ljava/lang/String;
    goto :goto_0

    .line 716
    .local p1, "v":Ljava/lang/Object;
    :cond_3
    instance-of v0, p1, Ljava/lang/Float;

    if-eqz v0, :cond_0

    .line 717
    check-cast p1, Ljava/lang/Float;

    .end local p1    # "v":Ljava/lang/Object;
    invoke-virtual {p1}, Ljava/lang/Float;->floatValue()F

    move-result v0

    invoke-static {v0}, Lgnu/xml/XMLPrinter;->formatFloat(F)Ljava/lang/String;

    move-result-object p1

    .local p1, "v":Ljava/lang/String;
    goto :goto_0

    .line 718
    .end local p1    # "v":Ljava/lang/String;
    :cond_4
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method setIndentMode()V
    .locals 4

    .prologue
    const/4 v0, 0x0

    const/4 v3, -0x1

    .line 287
    sget-object v2, Lgnu/xml/XMLPrinter;->indentLoc:Lgnu/mapping/ThreadLocation;

    invoke-virtual {v2, v0}, Lgnu/mapping/ThreadLocation;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 288
    .local v1, "xmlIndent":Ljava/lang/Object;
    if-nez v1, :cond_0

    .line 289
    .local v0, "indent":Ljava/lang/String;
    :goto_0
    if-nez v0, :cond_1

    .line 290
    iput v3, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    .line 297
    :goto_1
    return-void

    .line 288
    .end local v0    # "indent":Ljava/lang/String;
    :cond_0
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 291
    .restart local v0    # "indent":Ljava/lang/String;
    :cond_1
    const-string v2, "pretty"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 292
    const/4 v2, 0x0

    iput v2, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    goto :goto_1

    .line 293
    :cond_2
    const-string v2, "always"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    const-string v2, "yes"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 294
    :cond_3
    const/4 v2, 0x1

    iput v2, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    goto :goto_1

    .line 296
    :cond_4
    iput v3, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    goto :goto_1
.end method

.method public setPrintXMLdecl(Z)V
    .locals 0
    .param p1, "value"    # Z

    .prologue
    .line 30
    iput-boolean p1, p0, Lgnu/xml/XMLPrinter;->printXMLdecl:Z

    return-void
.end method

.method public setStyle(Ljava/lang/Object;)V
    .locals 5
    .param p1, "style"    # Ljava/lang/Object;

    .prologue
    const/4 v4, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 136
    iput-object p1, p0, Lgnu/xml/XMLPrinter;->style:Ljava/lang/Object;

    .line 137
    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->canonicalize:Z

    if-eqz v0, :cond_3

    move v0, v1

    :goto_0
    iput v0, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    .line 138
    const-string v0, "html"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 140
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->isHtml:Z

    .line 141
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    .line 142
    iput v4, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    .line 144
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    sget-object v3, Lgnu/xml/NamespaceBinding;->predefinedXML:Lgnu/xml/NamespaceBinding;

    if-ne v0, v3, :cond_0

    .line 145
    sget-object v0, Lgnu/kawa/xml/XmlNamespace;->HTML_BINDINGS:Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 149
    :cond_0
    :goto_1
    const-string v0, "xhtml"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 151
    iput-boolean v2, p0, Lgnu/xml/XMLPrinter;->isHtmlOrXhtml:Z

    .line 152
    iput v4, p0, Lgnu/xml/XMLPrinter;->useEmptyElementTag:I

    .line 154
    :cond_1
    const-string v0, "plain"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 155
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    .line 156
    :cond_2
    return-void

    :cond_3
    move v0, v2

    .line 137
    goto :goto_0

    .line 147
    :cond_4
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    sget-object v3, Lgnu/kawa/xml/XmlNamespace;->HTML_BINDINGS:Lgnu/xml/NamespaceBinding;

    if-ne v0, v3, :cond_0

    .line 148
    sget-object v0, Lgnu/xml/NamespaceBinding;->predefinedXML:Lgnu/xml/NamespaceBinding;

    iput-object v0, p0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    goto :goto_1
.end method

.method public startAttribute(Ljava/lang/Object;)V
    .locals 3
    .param p1, "attrType"    # Ljava/lang/Object;

    .prologue
    const/16 v2, 0x20

    .line 602
    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->inStartTag:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->strict:Z

    if-eqz v0, :cond_0

    .line 603
    const-string v0, "attribute not in element"

    const-string v1, "SENR0001"

    invoke-virtual {p0, v0, v1}, Lgnu/xml/XMLPrinter;->error(Ljava/lang/String;Ljava/lang/String;)V

    .line 604
    :cond_0
    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    if-eqz v0, :cond_1

    .line 605
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const/16 v1, 0x22

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(I)V

    .line 606
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 607
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v0, v2}, Lgnu/text/PrettyWriter;->write(I)V

    .line 608
    iget v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v0, :cond_2

    .line 609
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->writeBreakFill()V

    .line 610
    :cond_2
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 611
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v1, "=\""

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 612
    iput v2, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 613
    return-void
.end method

.method public startDocument()V
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 301
    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->printXMLdecl:Z

    if-eqz v0, :cond_0

    .line 305
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    .line 307
    :cond_0
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->setIndentMode()V

    .line 308
    iput-boolean v1, p0, Lgnu/xml/XMLPrinter;->inDocument:Z

    .line 309
    iget v0, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v0, :cond_1

    iget-boolean v0, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    if-nez v0, :cond_1

    .line 310
    const-string v0, ""

    const-string v1, ""

    const/4 v2, 0x2

    invoke-virtual {p0, v0, v1, v2}, Lgnu/xml/XMLPrinter;->startLogicalBlock(Ljava/lang/String;Ljava/lang/String;I)V

    .line 311
    :cond_1
    return-void
.end method

.method public startElement(Ljava/lang/Object;)V
    .locals 28
    .param p1, "type"    # Ljava/lang/Object;

    .prologue
    .line 348
    invoke-virtual/range {p0 .. p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 349
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->elementNesting:I

    move/from16 v24, v0

    if-nez v24, :cond_2

    .line 351
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lgnu/xml/XMLPrinter;->inDocument:Z

    move/from16 v24, v0

    if-nez v24, :cond_0

    .line 352
    invoke-virtual/range {p0 .. p0}, Lgnu/xml/XMLPrinter;->setIndentMode()V

    .line 353
    :cond_0
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->prev:I

    move/from16 v24, v0

    const/16 v25, -0x7

    move/from16 v0, v24

    move/from16 v1, v25

    if-ne v0, v1, :cond_1

    .line 354
    const/16 v24, 0xa

    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Lgnu/xml/XMLPrinter;->write(I)V

    .line 355
    :cond_1
    sget-object v24, Lgnu/xml/XMLPrinter;->doctypeSystem:Lgnu/mapping/ThreadLocation;

    const/16 v25, 0x0

    invoke-virtual/range {v24 .. v25}, Lgnu/mapping/ThreadLocation;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v21

    .line 356
    .local v21, "systemIdentifier":Ljava/lang/Object;
    if-eqz v21, :cond_2

    .line 358
    invoke-virtual/range {v21 .. v21}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v20

    .line 359
    .local v20, "systemId":Ljava/lang/String;
    invoke-virtual/range {v20 .. v20}, Ljava/lang/String;->length()I

    move-result v24

    if-lez v24, :cond_2

    .line 361
    sget-object v24, Lgnu/xml/XMLPrinter;->doctypePublic:Lgnu/mapping/ThreadLocation;

    const/16 v25, 0x0

    invoke-virtual/range {v24 .. v25}, Lgnu/mapping/ThreadLocation;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v16

    .line 362
    .local v16, "publicIdentifier":Ljava/lang/Object;
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, "<!DOCTYPE "

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 363
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v25

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 364
    if-nez v16, :cond_8

    const/4 v15, 0x0

    .line 366
    .local v15, "publicId":Ljava/lang/String;
    :goto_0
    if-eqz v15, :cond_9

    invoke-virtual {v15}, Ljava/lang/String;->length()I

    move-result v24

    if-lez v24, :cond_9

    .line 368
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, " PUBLIC \""

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 369
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    invoke-virtual {v0, v15}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 370
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, "\" \""

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 376
    :goto_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 377
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, "\">"

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 378
    invoke-virtual/range {p0 .. p0}, Lgnu/xml/XMLPrinter;->println()V

    .line 382
    .end local v15    # "publicId":Ljava/lang/String;
    .end local v16    # "publicIdentifier":Ljava/lang/Object;
    .end local v20    # "systemId":Ljava/lang/String;
    .end local v21    # "systemIdentifier":Ljava/lang/Object;
    :cond_2
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->printIndent:I

    move/from16 v24, v0

    if-ltz v24, :cond_5

    .line 384
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->prev:I

    move/from16 v24, v0

    const/16 v25, -0x3

    move/from16 v0, v24

    move/from16 v1, v25

    if-eq v0, v1, :cond_3

    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->prev:I

    move/from16 v24, v0

    const/16 v25, -0x4

    move/from16 v0, v24

    move/from16 v1, v25

    if-eq v0, v1, :cond_3

    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->prev:I

    move/from16 v24, v0

    const/16 v25, -0x5

    move/from16 v0, v24

    move/from16 v1, v25

    if-ne v0, v1, :cond_4

    .line 385
    :cond_3
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->printIndent:I

    move/from16 v24, v0

    if-lez v24, :cond_a

    const/16 v24, 0x52

    :goto_2
    move-object/from16 v0, p0

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Lgnu/xml/XMLPrinter;->writeBreak(I)V

    .line 387
    :cond_4
    const-string v24, ""

    const-string v25, ""

    const/16 v26, 0x2

    move-object/from16 v0, p0

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    move/from16 v3, v26

    invoke-virtual {v0, v1, v2, v3}, Lgnu/xml/XMLPrinter;->startLogicalBlock(Ljava/lang/String;Ljava/lang/String;I)V

    .line 389
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const/16 v25, 0x3c

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(I)V

    .line 390
    invoke-virtual/range {p0 .. p1}, Lgnu/xml/XMLPrinter;->writeQName(Ljava/lang/Object;)V

    .line 391
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->printIndent:I

    move/from16 v24, v0

    if-ltz v24, :cond_6

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lgnu/xml/XMLPrinter;->indentAttributes:Z

    move/from16 v24, v0

    if-eqz v24, :cond_6

    .line 392
    const-string v24, ""

    const-string v25, ""

    const/16 v26, 0x2

    move-object/from16 v0, p0

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    move/from16 v3, v26

    invoke-virtual {v0, v1, v2, v3}, Lgnu/xml/XMLPrinter;->startLogicalBlock(Ljava/lang/String;Ljava/lang/String;I)V

    .line 393
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    move-object/from16 v24, v0

    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->elementNesting:I

    move/from16 v25, v0

    aput-object p1, v24, v25

    .line 394
    const/4 v4, 0x0

    .line 395
    .local v4, "elementBindings":Lgnu/xml/NamespaceBinding;
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    move-object/from16 v24, v0

    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->elementNesting:I

    move/from16 v25, v0

    add-int/lit8 v26, v25, 0x1

    move/from16 v0, v26

    move-object/from16 v1, p0

    iput v0, v1, Lgnu/xml/XMLPrinter;->elementNesting:I

    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    move-object/from16 v26, v0

    aput-object v26, v24, v25

    .line 396
    move-object/from16 v0, p1

    instance-of v0, v0, Lgnu/xml/XName;

    move/from16 v24, v0

    if-eqz v24, :cond_1a

    move-object/from16 v24, p1

    .line 398
    check-cast v24, Lgnu/xml/XName;

    move-object/from16 v0, v24

    iget-object v4, v0, Lgnu/xml/XName;->namespaceNodes:Lgnu/xml/NamespaceBinding;

    .line 399
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    invoke-static {v4, v0}, Lgnu/xml/NamespaceBinding;->commonAncestor(Lgnu/xml/NamespaceBinding;Lgnu/xml/NamespaceBinding;)Lgnu/xml/NamespaceBinding;

    move-result-object v7

    .line 401
    .local v7, "join":Lgnu/xml/NamespaceBinding;
    if-nez v4, :cond_b

    const/4 v12, 0x0

    .line 403
    .local v12, "numBindings":I
    :goto_3
    new-array v0, v12, [Lgnu/xml/NamespaceBinding;

    move-object/from16 v19, v0

    .line 404
    .local v19, "sortedBindings":[Lgnu/xml/NamespaceBinding;
    const/4 v5, 0x0

    .line 405
    .local v5, "i":I
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lgnu/xml/XMLPrinter;->canonicalize:Z

    move/from16 v18, v0

    .line 407
    .local v18, "sortNamespaces":Z
    move-object v9, v4

    .local v9, "ns":Lgnu/xml/NamespaceBinding;
    :goto_4
    if-eq v9, v7, :cond_11

    .line 409
    move v6, v5

    .line 410
    .local v6, "j":I
    const/16 v17, 0x0

    .line 411
    .local v17, "skip":Z
    invoke-virtual {v9}, Lgnu/xml/NamespaceBinding;->getUri()Ljava/lang/String;

    move-result-object v23

    .line 412
    .local v23, "uri":Ljava/lang/String;
    invoke-virtual {v9}, Lgnu/xml/NamespaceBinding;->getPrefix()Ljava/lang/String;

    move-result-object v13

    .line 413
    .local v13, "prefix":Ljava/lang/String;
    :cond_7
    :goto_5
    add-int/lit8 v6, v6, -0x1

    if-ltz v6, :cond_d

    .line 415
    aget-object v10, v19, v6

    .line 417
    .local v10, "ns_j":Lgnu/xml/NamespaceBinding;
    invoke-virtual {v10}, Lgnu/xml/NamespaceBinding;->getPrefix()Ljava/lang/String;

    move-result-object v14

    .line 418
    .local v14, "prefix_j":Ljava/lang/String;
    if-ne v13, v14, :cond_c

    .line 407
    .end local v10    # "ns_j":Lgnu/xml/NamespaceBinding;
    .end local v14    # "prefix_j":Ljava/lang/String;
    :goto_6
    iget-object v9, v9, Lgnu/xml/NamespaceBinding;->next:Lgnu/xml/NamespaceBinding;

    goto :goto_4

    .line 364
    .end local v4    # "elementBindings":Lgnu/xml/NamespaceBinding;
    .end local v5    # "i":I
    .end local v6    # "j":I
    .end local v7    # "join":Lgnu/xml/NamespaceBinding;
    .end local v9    # "ns":Lgnu/xml/NamespaceBinding;
    .end local v12    # "numBindings":I
    .end local v13    # "prefix":Ljava/lang/String;
    .end local v17    # "skip":Z
    .end local v18    # "sortNamespaces":Z
    .end local v19    # "sortedBindings":[Lgnu/xml/NamespaceBinding;
    .end local v23    # "uri":Ljava/lang/String;
    .restart local v16    # "publicIdentifier":Ljava/lang/Object;
    .restart local v20    # "systemId":Ljava/lang/String;
    .restart local v21    # "systemIdentifier":Ljava/lang/Object;
    :cond_8
    invoke-virtual/range {v16 .. v16}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v15

    goto/16 :goto_0

    .line 374
    .restart local v15    # "publicId":Ljava/lang/String;
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, " SYSTEM \""

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 385
    .end local v15    # "publicId":Ljava/lang/String;
    .end local v16    # "publicIdentifier":Ljava/lang/Object;
    .end local v20    # "systemId":Ljava/lang/String;
    .end local v21    # "systemIdentifier":Ljava/lang/Object;
    :cond_a
    const/16 v24, 0x4e

    goto/16 :goto_2

    .line 401
    .restart local v4    # "elementBindings":Lgnu/xml/NamespaceBinding;
    .restart local v7    # "join":Lgnu/xml/NamespaceBinding;
    :cond_b
    invoke-virtual {v4, v7}, Lgnu/xml/NamespaceBinding;->count(Lgnu/xml/NamespaceBinding;)I

    move-result v12

    goto :goto_3

    .line 424
    .restart local v5    # "i":I
    .restart local v6    # "j":I
    .restart local v9    # "ns":Lgnu/xml/NamespaceBinding;
    .restart local v10    # "ns_j":Lgnu/xml/NamespaceBinding;
    .restart local v12    # "numBindings":I
    .restart local v13    # "prefix":Ljava/lang/String;
    .restart local v14    # "prefix_j":Ljava/lang/String;
    .restart local v17    # "skip":Z
    .restart local v18    # "sortNamespaces":Z
    .restart local v19    # "sortedBindings":[Lgnu/xml/NamespaceBinding;
    .restart local v23    # "uri":Ljava/lang/String;
    :cond_c
    if-eqz v18, :cond_7

    .line 426
    if-nez v13, :cond_e

    .line 432
    .end local v10    # "ns_j":Lgnu/xml/NamespaceBinding;
    .end local v14    # "prefix_j":Ljava/lang/String;
    :cond_d
    if-eqz v18, :cond_10

    .line 433
    add-int/lit8 v6, v6, 0x1

    .line 436
    :goto_7
    aput-object v9, v19, v6

    .line 437
    add-int/lit8 v5, v5, 0x1

    goto :goto_6

    .line 428
    .restart local v10    # "ns_j":Lgnu/xml/NamespaceBinding;
    .restart local v14    # "prefix_j":Ljava/lang/String;
    :cond_e
    if-eqz v14, :cond_f

    invoke-virtual {v13, v14}, Ljava/lang/String;->compareTo(Ljava/lang/String;)I

    move-result v24

    if-lez v24, :cond_d

    .line 430
    :cond_f
    add-int/lit8 v24, v6, 0x1

    aput-object v10, v19, v24

    goto :goto_5

    .line 435
    .end local v10    # "ns_j":Lgnu/xml/NamespaceBinding;
    .end local v14    # "prefix_j":Ljava/lang/String;
    :cond_10
    move v6, v5

    goto :goto_7

    .line 439
    .end local v6    # "j":I
    .end local v13    # "prefix":Ljava/lang/String;
    .end local v17    # "skip":Z
    .end local v23    # "uri":Ljava/lang/String;
    :cond_11
    move v12, v5

    .line 442
    move v5, v12

    :cond_12
    :goto_8
    add-int/lit8 v5, v5, -0x1

    if-ltz v5, :cond_16

    .line 444
    aget-object v9, v19, v5

    .line 445
    iget-object v13, v9, Lgnu/xml/NamespaceBinding;->prefix:Ljava/lang/String;

    .line 446
    .restart local v13    # "prefix":Ljava/lang/String;
    iget-object v0, v9, Lgnu/xml/NamespaceBinding;->uri:Ljava/lang/String;

    move-object/from16 v23, v0

    .line 447
    .restart local v23    # "uri":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    invoke-virtual {v0, v13}, Lgnu/xml/NamespaceBinding;->resolve(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    if-eq v0, v1, :cond_12

    .line 450
    if-nez v23, :cond_13

    if-eqz v13, :cond_13

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lgnu/xml/XMLPrinter;->undeclareNamespaces:Z

    move/from16 v24, v0

    if-eqz v24, :cond_12

    .line 452
    :cond_13
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const/16 v25, 0x20

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(I)V

    .line 453
    if-nez v13, :cond_15

    .line 454
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, "xmlns"

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 460
    :goto_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, "=\""

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 461
    const/16 v24, 0x1

    move/from16 v0, v24

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 462
    if-eqz v23, :cond_14

    .line 463
    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lgnu/xml/XMLPrinter;->write(Ljava/lang/String;)V

    .line 464
    :cond_14
    const/16 v24, 0x0

    move/from16 v0, v24

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lgnu/xml/XMLPrinter;->inAttribute:Z

    .line 465
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const/16 v25, 0x22

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(I)V

    goto :goto_8

    .line 457
    :cond_15
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, "xmlns:"

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 458
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    invoke-virtual {v0, v13}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto :goto_9

    .line 467
    .end local v13    # "prefix":Ljava/lang/String;
    .end local v23    # "uri":Ljava/lang/String;
    :cond_16
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lgnu/xml/XMLPrinter;->undeclareNamespaces:Z

    move/from16 v24, v0

    if-eqz v24, :cond_19

    .line 472
    move-object/from16 v0, p0

    iget-object v9, v0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 473
    :goto_a
    if-eq v9, v7, :cond_19

    .line 475
    iget-object v13, v9, Lgnu/xml/NamespaceBinding;->prefix:Ljava/lang/String;

    .line 476
    .restart local v13    # "prefix":Ljava/lang/String;
    iget-object v0, v9, Lgnu/xml/NamespaceBinding;->uri:Ljava/lang/String;

    move-object/from16 v24, v0

    if-eqz v24, :cond_17

    invoke-virtual {v4, v13}, Lgnu/xml/NamespaceBinding;->resolve(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v24

    if-nez v24, :cond_17

    .line 478
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const/16 v25, 0x20

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(I)V

    .line 479
    if-nez v13, :cond_18

    .line 480
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, "xmlns"

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 486
    :goto_b
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, "=\"\""

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 473
    :cond_17
    iget-object v9, v9, Lgnu/xml/NamespaceBinding;->next:Lgnu/xml/NamespaceBinding;

    goto :goto_a

    .line 483
    :cond_18
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    const-string v25, "xmlns:"

    invoke-virtual/range {v24 .. v25}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 484
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    move-object/from16 v24, v0

    move-object/from16 v0, v24

    invoke-virtual {v0, v13}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto :goto_b

    .line 490
    .end local v13    # "prefix":Ljava/lang/String;
    :cond_19
    move-object/from16 v0, p0

    iput-object v4, v0, Lgnu/xml/XMLPrinter;->namespaceBindings:Lgnu/xml/NamespaceBinding;

    .line 492
    .end local v5    # "i":I
    .end local v7    # "join":Lgnu/xml/NamespaceBinding;
    .end local v9    # "ns":Lgnu/xml/NamespaceBinding;
    .end local v12    # "numBindings":I
    .end local v18    # "sortNamespaces":Z
    .end local v19    # "sortedBindings":[Lgnu/xml/NamespaceBinding;
    :cond_1a
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->elementNesting:I

    move/from16 v24, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    move-object/from16 v25, v0

    move-object/from16 v0, v25

    array-length v0, v0

    move/from16 v25, v0

    move/from16 v0, v24

    move/from16 v1, v25

    if-lt v0, v1, :cond_1b

    .line 494
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->elementNesting:I

    move/from16 v24, v0

    mul-int/lit8 v24, v24, 0x2

    move/from16 v0, v24

    new-array v11, v0, [Lgnu/xml/NamespaceBinding;

    .line 495
    .local v11, "nstmp":[Lgnu/xml/NamespaceBinding;
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    move-object/from16 v24, v0

    const/16 v25, 0x0

    const/16 v26, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->elementNesting:I

    move/from16 v27, v0

    move-object/from16 v0, v24

    move/from16 v1, v25

    move/from16 v2, v26

    move/from16 v3, v27

    invoke-static {v0, v1, v11, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 496
    move-object/from16 v0, p0

    iput-object v11, v0, Lgnu/xml/XMLPrinter;->namespaceSaveStack:[Lgnu/xml/NamespaceBinding;

    .line 497
    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->elementNesting:I

    move/from16 v24, v0

    mul-int/lit8 v24, v24, 0x2

    move/from16 v0, v24

    new-array v8, v0, [Ljava/lang/Object;

    .line 498
    .local v8, "nmtmp":[Ljava/lang/Object;
    move-object/from16 v0, p0

    iget-object v0, v0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    move-object/from16 v24, v0

    const/16 v25, 0x0

    const/16 v26, 0x0

    move-object/from16 v0, p0

    iget v0, v0, Lgnu/xml/XMLPrinter;->elementNesting:I

    move/from16 v27, v0

    move-object/from16 v0, v24

    move/from16 v1, v25

    move/from16 v2, v26

    move/from16 v3, v27

    invoke-static {v0, v1, v8, v2, v3}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 499
    move-object/from16 v0, p0

    iput-object v8, v0, Lgnu/xml/XMLPrinter;->elementNameStack:[Ljava/lang/Object;

    .line 502
    .end local v8    # "nmtmp":[Ljava/lang/Object;
    .end local v11    # "nstmp":[Lgnu/xml/NamespaceBinding;
    :cond_1b
    const/16 v24, 0x1

    move/from16 v0, v24

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lgnu/xml/XMLPrinter;->inStartTag:Z

    .line 504
    invoke-virtual/range {p0 .. p1}, Lgnu/xml/XMLPrinter;->getHtmlTag(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v22

    .line 505
    .local v22, "typeName":Ljava/lang/String;
    const-string v24, "script"

    move-object/from16 v0, v24

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-nez v24, :cond_1c

    const-string v24, "style"

    move-object/from16 v0, v24

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v24

    if-eqz v24, :cond_1d

    .line 506
    :cond_1c
    const/16 v24, 0x0

    move/from16 v0, v24

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lgnu/xml/XMLPrinter;->escapeText:Z

    .line 507
    :cond_1d
    return-void
.end method

.method protected startNumber()V
    .locals 0

    .prologue
    .line 254
    invoke-direct {p0}, Lgnu/xml/XMLPrinter;->startWord()V

    .line 255
    return-void
.end method

.method public write(I)V
    .locals 7
    .param p1, "v"    # I

    .prologue
    const v6, 0xdc00

    const v5, 0xd800

    const/16 v4, 0xd

    const/16 v3, 0xa

    const/4 v2, 0x1

    .line 169
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 170
    iget v1, p0, Lgnu/xml/XMLPrinter;->printIndent:I

    if-ltz v1, :cond_4

    .line 172
    if-eq p1, v4, :cond_0

    if-ne p1, v3, :cond_4

    .line 174
    :cond_0
    if-ne p1, v3, :cond_1

    iget v1, p0, Lgnu/xml/XMLPrinter;->prev:I

    if-eq v1, v4, :cond_2

    .line 175
    :cond_1
    const/16 v1, 0x52

    invoke-virtual {p0, v1}, Lgnu/xml/XMLPrinter;->writeBreak(I)V

    .line 176
    :cond_2
    iget v1, p0, Lgnu/xml/XMLPrinter;->inComment:I

    if-lez v1, :cond_3

    .line 177
    iput v2, p0, Lgnu/xml/XMLPrinter;->inComment:I

    .line 237
    :cond_3
    :goto_0
    return-void

    .line 181
    :cond_4
    iget-boolean v1, p0, Lgnu/xml/XMLPrinter;->escapeText:Z

    if-nez v1, :cond_5

    .line 183
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v1, p1}, Lgnu/text/PrettyWriter;->write(I)V

    .line 184
    iput p1, p0, Lgnu/xml/XMLPrinter;->prev:I

    goto :goto_0

    .line 186
    :cond_5
    iget v1, p0, Lgnu/xml/XMLPrinter;->inComment:I

    if-lez v1, :cond_8

    .line 188
    const/16 v1, 0x2d

    if-ne p1, v1, :cond_7

    .line 190
    iget v1, p0, Lgnu/xml/XMLPrinter;->inComment:I

    if-ne v1, v2, :cond_6

    .line 191
    const/4 v1, 0x2

    iput v1, p0, Lgnu/xml/XMLPrinter;->inComment:I

    .line 197
    :goto_1
    invoke-super {p0, p1}, Lgnu/mapping/OutPort;->write(I)V

    goto :goto_0

    .line 193
    :cond_6
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Lgnu/text/PrettyWriter;->write(I)V

    goto :goto_1

    .line 196
    :cond_7
    iput v2, p0, Lgnu/xml/XMLPrinter;->inComment:I

    goto :goto_1

    .line 201
    :cond_8
    const/16 v1, 0x3b

    iput v1, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 202
    const/16 v1, 0x3c

    if-ne p1, v1, :cond_a

    iget-boolean v1, p0, Lgnu/xml/XMLPrinter;->isHtml:Z

    if-eqz v1, :cond_9

    iget-boolean v1, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    if-nez v1, :cond_a

    .line 203
    :cond_9
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v2, "&lt;"

    invoke-virtual {v1, v2}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 204
    :cond_a
    const/16 v1, 0x3e

    if-ne p1, v1, :cond_b

    .line 205
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v2, "&gt;"

    invoke-virtual {v1, v2}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 206
    :cond_b
    const/16 v1, 0x26

    if-ne p1, v1, :cond_c

    .line 207
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v2, "&amp;"

    invoke-virtual {v1, v2}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 208
    :cond_c
    const/16 v1, 0x22

    if-ne p1, v1, :cond_d

    iget-boolean v1, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    if-eqz v1, :cond_d

    .line 209
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v2, "&quot;"

    invoke-virtual {v1, v2}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto :goto_0

    .line 210
    :cond_d
    invoke-virtual {p0, p1}, Lgnu/xml/XMLPrinter;->mustHexEscape(I)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 212
    move v0, p1

    .line 213
    .local v0, "i":I
    if-lt p1, v5, :cond_f

    .line 215
    if-ge p1, v6, :cond_e

    .line 217
    int-to-char v1, p1

    iput-char v1, p0, Lgnu/xml/XMLPrinter;->savedHighSurrogate:C

    goto :goto_0

    .line 220
    :cond_e
    const v1, 0xe000

    if-ge p1, v1, :cond_f

    .line 224
    iget-char v1, p0, Lgnu/xml/XMLPrinter;->savedHighSurrogate:C

    sub-int/2addr v1, v5

    mul-int/lit16 v1, v1, 0x400

    sub-int v2, v0, v6

    add-int/2addr v1, v2

    const/high16 v2, 0x10000

    add-int v0, v1, v2

    .line 226
    const/4 v1, 0x0

    iput-char v1, p0, Lgnu/xml/XMLPrinter;->savedHighSurrogate:C

    .line 229
    :cond_f
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "&#x"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 233
    .end local v0    # "i":I
    :cond_10
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v1, p1}, Lgnu/text/PrettyWriter;->write(I)V

    .line 234
    iput p1, p0, Lgnu/xml/XMLPrinter;->prev:I

    goto/16 :goto_0
.end method

.method public write(Ljava/lang/String;II)V
    .locals 7
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "start"    # I
    .param p3, "length"    # I

    .prologue
    const/16 v6, 0x2d

    .line 775
    if-lez p3, :cond_6

    .line 777
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 778
    add-int v2, p2, p3

    .line 779
    .local v2, "limit":I
    const/4 v1, 0x0

    .local v1, "count":I
    move v3, p2

    .line 780
    .end local p2    # "start":I
    .local v3, "start":I
    :goto_0
    if-ge v3, v2, :cond_4

    .line 782
    add-int/lit8 p2, v3, 0x1

    .end local v3    # "start":I
    .restart local p2    # "start":I
    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 783
    .local v0, "c":C
    invoke-virtual {p0, v0}, Lgnu/xml/XMLPrinter;->mustHexEscape(I)Z

    move-result v4

    if-nez v4, :cond_0

    iget v4, p0, Lgnu/xml/XMLPrinter;->inComment:I

    if-lez v4, :cond_2

    if-eq v0, v6, :cond_0

    iget v4, p0, Lgnu/xml/XMLPrinter;->inComment:I

    const/4 v5, 0x2

    if-ne v4, v5, :cond_3

    .line 788
    :cond_0
    if-lez v1, :cond_1

    .line 789
    iget-object v4, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    add-int/lit8 v5, p2, -0x1

    sub-int/2addr v5, v1

    invoke-virtual {v4, p1, v5, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;II)V

    .line 790
    :cond_1
    invoke-virtual {p0, v0}, Lgnu/xml/XMLPrinter;->write(I)V

    .line 791
    const/4 v1, 0x0

    :goto_1
    move v3, p2

    .line 795
    .end local p2    # "start":I
    .restart local v3    # "start":I
    goto :goto_0

    .line 783
    .end local v3    # "start":I
    .restart local p2    # "start":I
    :cond_2
    const/16 v4, 0x3c

    if-eq v0, v4, :cond_0

    const/16 v4, 0x3e

    if-eq v0, v4, :cond_0

    const/16 v4, 0x26

    if-eq v0, v4, :cond_0

    iget-boolean v4, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    if-eqz v4, :cond_3

    const/16 v4, 0x22

    if-eq v0, v4, :cond_0

    const/16 v4, 0x20

    if-lt v0, v4, :cond_0

    .line 794
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 796
    .end local v0    # "c":C
    .end local p2    # "start":I
    .restart local v3    # "start":I
    :cond_4
    if-lez v1, :cond_5

    .line 797
    iget-object v4, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    sub-int v5, v2, v1

    invoke-virtual {v4, p1, v5, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;II)V

    :cond_5
    move p2, v3

    .line 799
    .end local v1    # "count":I
    .end local v2    # "limit":I
    .end local v3    # "start":I
    .restart local p2    # "start":I
    :cond_6
    iput v6, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 800
    return-void
.end method

.method public write([CII)V
    .locals 7
    .param p1, "buf"    # [C
    .param p2, "off"    # I
    .param p3, "len"    # I

    .prologue
    const/16 v6, 0x2d

    .line 804
    if-lez p3, :cond_6

    .line 806
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 807
    add-int v2, p2, p3

    .line 808
    .local v2, "limit":I
    const/4 v1, 0x0

    .local v1, "count":I
    move v3, p2

    .line 809
    .end local p2    # "off":I
    .local v3, "off":I
    :goto_0
    if-ge v3, v2, :cond_4

    .line 811
    add-int/lit8 p2, v3, 0x1

    .end local v3    # "off":I
    .restart local p2    # "off":I
    aget-char v0, p1, v3

    .line 812
    .local v0, "c":C
    invoke-virtual {p0, v0}, Lgnu/xml/XMLPrinter;->mustHexEscape(I)Z

    move-result v4

    if-nez v4, :cond_0

    iget v4, p0, Lgnu/xml/XMLPrinter;->inComment:I

    if-lez v4, :cond_2

    if-eq v0, v6, :cond_0

    iget v4, p0, Lgnu/xml/XMLPrinter;->inComment:I

    const/4 v5, 0x2

    if-ne v4, v5, :cond_3

    .line 817
    :cond_0
    if-lez v1, :cond_1

    .line 818
    iget-object v4, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    add-int/lit8 v5, p2, -0x1

    sub-int/2addr v5, v1

    invoke-virtual {v4, p1, v5, v1}, Lgnu/text/PrettyWriter;->write([CII)V

    .line 819
    :cond_1
    invoke-virtual {p0, v0}, Lgnu/xml/XMLPrinter;->write(I)V

    .line 820
    const/4 v1, 0x0

    :goto_1
    move v3, p2

    .line 824
    .end local p2    # "off":I
    .restart local v3    # "off":I
    goto :goto_0

    .line 812
    .end local v3    # "off":I
    .restart local p2    # "off":I
    :cond_2
    const/16 v4, 0x3c

    if-eq v0, v4, :cond_0

    const/16 v4, 0x3e

    if-eq v0, v4, :cond_0

    const/16 v4, 0x26

    if-eq v0, v4, :cond_0

    iget-boolean v4, p0, Lgnu/xml/XMLPrinter;->inAttribute:Z

    if-eqz v4, :cond_3

    const/16 v4, 0x22

    if-eq v0, v4, :cond_0

    const/16 v4, 0x20

    if-lt v0, v4, :cond_0

    .line 823
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 825
    .end local v0    # "c":C
    .end local p2    # "off":I
    .restart local v3    # "off":I
    :cond_4
    if-lez v1, :cond_5

    .line 826
    iget-object v4, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    sub-int v5, v2, v1

    invoke-virtual {v4, p1, v5, v1}, Lgnu/text/PrettyWriter;->write([CII)V

    :cond_5
    move p2, v3

    .line 828
    .end local v1    # "count":I
    .end local v2    # "limit":I
    .end local v3    # "off":I
    .restart local p2    # "off":I
    :cond_6
    iput v6, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 829
    return-void
.end method

.method public writeBaseUri(Ljava/lang/Object;)V
    .locals 0
    .param p1, "uri"    # Ljava/lang/Object;

    .prologue
    .line 838
    return-void
.end method

.method public writeBoolean(Z)V
    .locals 0
    .param p1, "v"    # Z

    .prologue
    .line 247
    invoke-direct {p0}, Lgnu/xml/XMLPrinter;->startWord()V

    .line 248
    invoke-super {p0, p1}, Lgnu/mapping/OutPort;->print(Z)V

    .line 249
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->writeWordEnd()V

    .line 250
    return-void
.end method

.method public writeCDATA([CII)V
    .locals 6
    .param p1, "chars"    # [C
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    const/16 v5, 0x5d

    const/16 v4, 0x3e

    .line 876
    iget-boolean v2, p0, Lgnu/xml/XMLPrinter;->canonicalizeCDATA:Z

    if-eqz v2, :cond_0

    .line 878
    invoke-virtual {p0, p1, p2, p3}, Lgnu/xml/XMLPrinter;->write([CII)V

    .line 901
    :goto_0
    return-void

    .line 881
    :cond_0
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 882
    iget-object v2, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v3, "<![CDATA["

    invoke-virtual {v2, v3}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 883
    add-int v1, p2, p3

    .line 886
    .local v1, "limit":I
    move v0, p2

    .local v0, "i":I
    :goto_1
    add-int/lit8 v2, v1, -0x2

    if-ge v0, v2, :cond_3

    .line 888
    aget-char v2, p1, v0

    if-ne v2, v5, :cond_2

    add-int/lit8 v2, v0, 0x1

    aget-char v2, p1, v2

    if-ne v2, v5, :cond_2

    add-int/lit8 v2, v0, 0x2

    aget-char v2, p1, v2

    if-ne v2, v4, :cond_2

    .line 890
    if-le v0, p2, :cond_1

    .line 891
    iget-object v2, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    sub-int v3, v0, p2

    invoke-virtual {v2, p1, p2, v3}, Lgnu/text/PrettyWriter;->write([CII)V

    .line 892
    :cond_1
    const-string v2, "]]]><![CDATA[]>"

    invoke-virtual {p0, v2}, Lgnu/xml/XMLPrinter;->print(Ljava/lang/String;)V

    .line 893
    add-int/lit8 p2, v0, 0x3

    .line 894
    sub-int p3, v1, p2

    .line 895
    add-int/lit8 v0, v0, 0x2

    .line 886
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 898
    :cond_3
    iget-object v2, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v2, p1, p2, p3}, Lgnu/text/PrettyWriter;->write([CII)V

    .line 899
    iget-object v2, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v3, "]]>"

    invoke-virtual {v2, v3}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 900
    iput v4, p0, Lgnu/xml/XMLPrinter;->prev:I

    goto :goto_0
.end method

.method public writeComment(Ljava/lang/String;)V
    .locals 0
    .param p1, "chars"    # Ljava/lang/String;

    .prologue
    .line 862
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->beginComment()V

    .line 863
    invoke-virtual {p0, p1}, Lgnu/xml/XMLPrinter;->write(Ljava/lang/String;)V

    .line 864
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->endComment()V

    .line 865
    return-void
.end method

.method public writeComment([CII)V
    .locals 0
    .param p1, "chars"    # [C
    .param p2, "offset"    # I
    .param p3, "length"    # I

    .prologue
    .line 869
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->beginComment()V

    .line 870
    invoke-virtual {p0, p1, p2, p3}, Lgnu/xml/XMLPrinter;->write([CII)V

    .line 871
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->endComment()V

    .line 872
    return-void
.end method

.method public writeDouble(D)V
    .locals 2
    .param p1, "d"    # D

    .prologue
    .line 630
    invoke-direct {p0}, Lgnu/xml/XMLPrinter;->startWord()V

    .line 631
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-static {p1, p2}, Lgnu/xml/XMLPrinter;->formatDouble(D)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 632
    return-void
.end method

.method public writeFloat(F)V
    .locals 2
    .param p1, "f"    # F

    .prologue
    .line 636
    invoke-direct {p0}, Lgnu/xml/XMLPrinter;->startWord()V

    .line 637
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-static {p1}, Lgnu/xml/XMLPrinter;->formatFloat(F)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 638
    return-void
.end method

.method public writeObject(Ljava/lang/Object;)V
    .locals 4
    .param p1, "v"    # Ljava/lang/Object;

    .prologue
    const/16 v3, 0x2d

    .line 723
    instance-of v1, p1, Lgnu/lists/SeqPosition;

    if-eqz v1, :cond_1

    .line 725
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v1}, Lgnu/text/PrettyWriter;->clearWordEnd()V

    move-object v0, p1

    .line 726
    check-cast v0, Lgnu/lists/SeqPosition;

    .line 727
    .local v0, "pos":Lgnu/lists/SeqPosition;
    iget-object v1, v0, Lgnu/lists/SeqPosition;->sequence:Lgnu/lists/AbstractSequence;

    iget v2, v0, Lgnu/lists/SeqPosition;->ipos:I

    invoke-virtual {v1, v2, p0}, Lgnu/lists/AbstractSequence;->consumeNext(ILgnu/lists/Consumer;)Z

    .line 728
    iget-object v1, v0, Lgnu/lists/SeqPosition;->sequence:Lgnu/lists/AbstractSequence;

    instance-of v1, v1, Lgnu/xml/NodeTree;

    if-eqz v1, :cond_0

    .line 729
    iput v3, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 760
    .end local v0    # "pos":Lgnu/lists/SeqPosition;
    .end local p1    # "v":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-void

    .line 732
    .restart local p1    # "v":Ljava/lang/Object;
    :cond_1
    instance-of v1, p1, Lgnu/lists/Consumable;

    if-eqz v1, :cond_2

    instance-of v1, p1, Lgnu/lists/UnescapedData;

    if-nez v1, :cond_2

    .line 734
    check-cast p1, Lgnu/lists/Consumable;

    .end local p1    # "v":Ljava/lang/Object;
    invoke-interface {p1, p0}, Lgnu/lists/Consumable;->consume(Lgnu/lists/Consumer;)V

    goto :goto_0

    .line 737
    .restart local p1    # "v":Ljava/lang/Object;
    :cond_2
    instance-of v1, p1, Lgnu/expr/Keyword;

    if-eqz v1, :cond_3

    .line 739
    check-cast p1, Lgnu/expr/Keyword;

    .end local p1    # "v":Ljava/lang/Object;
    invoke-virtual {p1}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lgnu/xml/XMLPrinter;->startAttribute(Ljava/lang/Object;)V

    .line 740
    const/4 v1, -0x6

    iput v1, p0, Lgnu/xml/XMLPrinter;->prev:I

    goto :goto_0

    .line 743
    .restart local p1    # "v":Ljava/lang/Object;
    :cond_3
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 744
    instance-of v1, p1, Lgnu/lists/UnescapedData;

    if-eqz v1, :cond_4

    .line 746
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v1}, Lgnu/text/PrettyWriter;->clearWordEnd()V

    .line 747
    iget-object v1, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    check-cast p1, Lgnu/lists/UnescapedData;

    .end local p1    # "v":Ljava/lang/Object;
    invoke-virtual {p1}, Lgnu/lists/UnescapedData;->getData()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 748
    iput v3, p0, Lgnu/xml/XMLPrinter;->prev:I

    goto :goto_0

    .line 750
    .restart local p1    # "v":Ljava/lang/Object;
    :cond_4
    instance-of v1, p1, Lgnu/text/Char;

    if-eqz v1, :cond_5

    .line 751
    check-cast p1, Lgnu/text/Char;

    .end local p1    # "v":Ljava/lang/Object;
    invoke-virtual {p1}, Lgnu/text/Char;->intValue()I

    move-result v1

    invoke-static {v1, p0}, Lgnu/text/Char;->print(ILgnu/lists/Consumer;)V

    goto :goto_0

    .line 754
    .restart local p1    # "v":Ljava/lang/Object;
    :cond_5
    invoke-direct {p0}, Lgnu/xml/XMLPrinter;->startWord()V

    .line 755
    const/16 v1, 0x20

    iput v1, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 756
    invoke-virtual {p0, p1}, Lgnu/xml/XMLPrinter;->print(Ljava/lang/Object;)V

    .line 757
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->writeWordEnd()V

    .line 758
    const/4 v1, -0x2

    iput v1, p0, Lgnu/xml/XMLPrinter;->prev:I

    goto :goto_0
.end method

.method public writePosition(Lgnu/lists/AbstractSequence;I)V
    .locals 0
    .param p1, "seq"    # Lgnu/lists/AbstractSequence;
    .param p2, "ipos"    # I

    .prologue
    .line 833
    invoke-virtual {p1, p2, p0}, Lgnu/lists/AbstractSequence;->consumeNext(ILgnu/lists/Consumer;)Z

    .line 834
    return-void
.end method

.method public writeProcessingInstruction(Ljava/lang/String;[CII)V
    .locals 2
    .param p1, "target"    # Ljava/lang/String;
    .param p2, "content"    # [C
    .param p3, "offset"    # I
    .param p4, "length"    # I

    .prologue
    .line 906
    const-string v0, "xml"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 907
    const/4 v0, 0x0

    iput-boolean v0, p0, Lgnu/xml/XMLPrinter;->needXMLdecl:Z

    .line 908
    :cond_0
    invoke-virtual {p0}, Lgnu/xml/XMLPrinter;->closeTag()V

    .line 909
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v1, "<?"

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 910
    invoke-virtual {p0, p1}, Lgnu/xml/XMLPrinter;->print(Ljava/lang/String;)V

    .line 911
    const/16 v0, 0x20

    invoke-virtual {p0, v0}, Lgnu/xml/XMLPrinter;->print(C)V

    .line 912
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v0, p2, p3, p4}, Lgnu/text/PrettyWriter;->write([CII)V

    .line 913
    iget-object v0, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const-string v1, "?>"

    invoke-virtual {v0, v1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 914
    const/4 v0, -0x7

    iput v0, p0, Lgnu/xml/XMLPrinter;->prev:I

    .line 915
    return-void
.end method

.method protected writeQName(Ljava/lang/Object;)V
    .locals 4
    .param p1, "name"    # Ljava/lang/Object;

    .prologue
    .line 331
    instance-of v2, p1, Lgnu/mapping/Symbol;

    if-eqz v2, :cond_1

    move-object v1, p1

    .line 333
    check-cast v1, Lgnu/mapping/Symbol;

    .line 334
    .local v1, "sname":Lgnu/mapping/Symbol;
    invoke-virtual {v1}, Lgnu/mapping/Symbol;->getPrefix()Ljava/lang/String;

    move-result-object v0

    .line 335
    .local v0, "prefix":Ljava/lang/String;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_0

    .line 337
    iget-object v2, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v2, v0}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 338
    iget-object v2, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    const/16 v3, 0x3a

    invoke-virtual {v2, v3}, Lgnu/text/PrettyWriter;->write(I)V

    .line 340
    :cond_0
    iget-object v2, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    invoke-virtual {v1}, Lgnu/mapping/Symbol;->getLocalPart()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    .line 344
    .end local v0    # "prefix":Ljava/lang/String;
    .end local v1    # "sname":Lgnu/mapping/Symbol;
    .end local p1    # "name":Ljava/lang/Object;
    :goto_0
    return-void

    .line 343
    .restart local p1    # "name":Ljava/lang/Object;
    :cond_1
    iget-object v2, p0, Lgnu/xml/XMLPrinter;->bout:Lgnu/text/PrettyWriter;

    if-nez p1, :cond_2

    const-string p1, "{null name}"

    .end local p1    # "name":Ljava/lang/Object;
    :goto_1
    invoke-virtual {v2, p1}, Lgnu/text/PrettyWriter;->write(Ljava/lang/String;)V

    goto :goto_0

    .restart local p1    # "name":Ljava/lang/Object;
    :cond_2
    check-cast p1, Ljava/lang/String;

    goto :goto_1
.end method
