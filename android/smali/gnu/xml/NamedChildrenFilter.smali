.class public Lgnu/xml/NamedChildrenFilter;
.super Lgnu/lists/FilterConsumer;
.source "NamedChildrenFilter.java"


# instance fields
.field level:I

.field localName:Ljava/lang/String;

.field matchLevel:I

.field namespaceURI:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lgnu/lists/Consumer;)V
    .locals 1
    .param p1, "namespaceURI"    # Ljava/lang/String;
    .param p2, "localName"    # Ljava/lang/String;
    .param p3, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 28
    invoke-direct {p0, p3}, Lgnu/lists/FilterConsumer;-><init>(Lgnu/lists/Consumer;)V

    .line 29
    iput-object p1, p0, Lgnu/xml/NamedChildrenFilter;->namespaceURI:Ljava/lang/String;

    .line 30
    iput-object p2, p0, Lgnu/xml/NamedChildrenFilter;->localName:Ljava/lang/String;

    .line 31
    const/4 v0, 0x1

    iput-boolean v0, p0, Lgnu/xml/NamedChildrenFilter;->skipping:Z

    .line 32
    return-void
.end method

.method public static make(Ljava/lang/String;Ljava/lang/String;Lgnu/lists/Consumer;)Lgnu/xml/NamedChildrenFilter;
    .locals 1
    .param p0, "namespaceURI"    # Ljava/lang/String;
    .param p1, "localName"    # Ljava/lang/String;
    .param p2, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 22
    new-instance v0, Lgnu/xml/NamedChildrenFilter;

    invoke-direct {v0, p0, p1, p2}, Lgnu/xml/NamedChildrenFilter;-><init>(Ljava/lang/String;Ljava/lang/String;Lgnu/lists/Consumer;)V

    return-object v0
.end method


# virtual methods
.method public endDocument()V
    .locals 1

    .prologue
    .line 42
    iget v0, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    .line 43
    invoke-super {p0}, Lgnu/lists/FilterConsumer;->endDocument()V

    .line 44
    return-void
.end method

.method public endElement()V
    .locals 2

    .prologue
    .line 80
    iget v0, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    .line 81
    invoke-super {p0}, Lgnu/lists/FilterConsumer;->endElement()V

    .line 82
    iget-boolean v0, p0, Lgnu/xml/NamedChildrenFilter;->skipping:Z

    if-nez v0, :cond_0

    iget v0, p0, Lgnu/xml/NamedChildrenFilter;->matchLevel:I

    iget v1, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    if-ne v0, v1, :cond_0

    .line 83
    const/4 v0, 0x1

    iput-boolean v0, p0, Lgnu/xml/NamedChildrenFilter;->skipping:Z

    .line 84
    :cond_0
    return-void
.end method

.method public startDocument()V
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    .line 37
    invoke-super {p0}, Lgnu/lists/FilterConsumer;->startDocument()V

    .line 38
    return-void
.end method

.method public startElement(Ljava/lang/Object;)V
    .locals 5
    .param p1, "type"    # Ljava/lang/Object;

    .prologue
    .line 48
    iget-boolean v3, p0, Lgnu/xml/NamedChildrenFilter;->skipping:Z

    if-eqz v3, :cond_2

    iget v3, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    const/4 v4, 0x1

    if-ne v3, v4, :cond_2

    .line 55
    instance-of v3, p1, Lgnu/mapping/Symbol;

    if-eqz v3, :cond_3

    move-object v2, p1

    .line 57
    check-cast v2, Lgnu/mapping/Symbol;

    .line 58
    .local v2, "qname":Lgnu/mapping/Symbol;
    invoke-virtual {v2}, Lgnu/mapping/Symbol;->getNamespaceURI()Ljava/lang/String;

    move-result-object v1

    .line 59
    .local v1, "curNamespaceURI":Ljava/lang/String;
    invoke-virtual {v2}, Lgnu/mapping/Symbol;->getLocalName()Ljava/lang/String;

    move-result-object v0

    .line 66
    .end local v2    # "qname":Lgnu/mapping/Symbol;
    .local v0, "curLocalName":Ljava/lang/String;
    :goto_0
    iget-object v3, p0, Lgnu/xml/NamedChildrenFilter;->localName:Ljava/lang/String;

    if-eq v3, v0, :cond_0

    iget-object v3, p0, Lgnu/xml/NamedChildrenFilter;->localName:Ljava/lang/String;

    if-nez v3, :cond_2

    :cond_0
    iget-object v3, p0, Lgnu/xml/NamedChildrenFilter;->namespaceURI:Ljava/lang/String;

    if-eq v3, v1, :cond_1

    iget-object v3, p0, Lgnu/xml/NamedChildrenFilter;->namespaceURI:Ljava/lang/String;

    if-nez v3, :cond_2

    .line 69
    :cond_1
    const/4 v3, 0x0

    iput-boolean v3, p0, Lgnu/xml/NamedChildrenFilter;->skipping:Z

    .line 70
    iget v3, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    iput v3, p0, Lgnu/xml/NamedChildrenFilter;->matchLevel:I

    .line 74
    .end local v0    # "curLocalName":Ljava/lang/String;
    .end local v1    # "curNamespaceURI":Ljava/lang/String;
    :cond_2
    invoke-super {p0, p1}, Lgnu/lists/FilterConsumer;->startElement(Ljava/lang/Object;)V

    .line 75
    iget v3, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lgnu/xml/NamedChildrenFilter;->level:I

    .line 76
    return-void

    .line 63
    :cond_3
    const-string v1, ""

    .line 64
    .restart local v1    # "curNamespaceURI":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "curLocalName":Ljava/lang/String;
    goto :goto_0
.end method

.method public writeObject(Ljava/lang/Object;)V
    .locals 3
    .param p1, "val"    # Ljava/lang/Object;

    .prologue
    .line 88
    instance-of v1, p1, Lgnu/lists/SeqPosition;

    if-eqz v1, :cond_0

    move-object v0, p1

    .line 90
    check-cast v0, Lgnu/lists/SeqPosition;

    .line 91
    .local v0, "pos":Lgnu/lists/SeqPosition;
    iget-object v1, v0, Lgnu/lists/SeqPosition;->sequence:Lgnu/lists/AbstractSequence;

    instance-of v1, v1, Lgnu/lists/TreeList;

    if-eqz v1, :cond_0

    .line 93
    iget-object v1, v0, Lgnu/lists/SeqPosition;->sequence:Lgnu/lists/AbstractSequence;

    check-cast v1, Lgnu/lists/TreeList;

    iget v2, v0, Lgnu/lists/SeqPosition;->ipos:I

    invoke-virtual {v1, v2, p0}, Lgnu/lists/TreeList;->consumeNext(ILgnu/lists/Consumer;)Z

    .line 101
    .end local v0    # "pos":Lgnu/lists/SeqPosition;
    .end local p1    # "val":Ljava/lang/Object;
    :goto_0
    return-void

    .line 97
    .restart local p1    # "val":Ljava/lang/Object;
    :cond_0
    instance-of v1, p1, Lgnu/lists/Consumable;

    if-eqz v1, :cond_1

    .line 98
    check-cast p1, Lgnu/lists/Consumable;

    .end local p1    # "val":Ljava/lang/Object;
    invoke-interface {p1, p0}, Lgnu/lists/Consumable;->consume(Lgnu/lists/Consumer;)V

    goto :goto_0

    .line 100
    .restart local p1    # "val":Ljava/lang/Object;
    :cond_1
    invoke-super {p0, p1}, Lgnu/lists/FilterConsumer;->writeObject(Ljava/lang/Object;)V

    goto :goto_0
.end method
