.class public Lgnu/expr/Keyword;
.super Lgnu/mapping/Symbol;
.source "Keyword.java"

# interfaces
.implements Lgnu/text/Printable;
.implements Ljava/io/Externalizable;


# static fields
.field public static final keywordNamespace:Lgnu/mapping/Namespace;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 10
    invoke-static {}, Lgnu/mapping/Namespace;->create()Lgnu/mapping/Namespace;

    move-result-object v0

    sput-object v0, Lgnu/expr/Keyword;->keywordNamespace:Lgnu/mapping/Namespace;

    .line 11
    sget-object v0, Lgnu/expr/Keyword;->keywordNamespace:Lgnu/mapping/Namespace;

    const-string v1, "(keywords)"

    invoke-virtual {v0, v1}, Lgnu/mapping/Namespace;->setName(Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lgnu/mapping/Symbol;-><init>()V

    .line 15
    return-void
.end method

.method public constructor <init>(Lgnu/mapping/Namespace;Ljava/lang/String;)V
    .locals 0
    .param p1, "namespace"    # Lgnu/mapping/Namespace;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lgnu/mapping/Symbol;-><init>(Lgnu/mapping/Namespace;Ljava/lang/String;)V

    .line 26
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 19
    sget-object v0, Lgnu/expr/Keyword;->keywordNamespace:Lgnu/mapping/Namespace;

    invoke-direct {p0, v0, p1}, Lgnu/mapping/Symbol;-><init>(Lgnu/mapping/Namespace;Ljava/lang/String;)V

    .line 20
    return-void
.end method

.method public static isKeyword(Ljava/lang/Object;)Z
    .locals 1
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    .line 62
    instance-of v0, p0, Lgnu/expr/Keyword;

    return v0
.end method

.method public static make(Ljava/lang/String;)Lgnu/expr/Keyword;
    .locals 4
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-virtual {p0}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 44
    .local v0, "hash":I
    sget-object v2, Lgnu/expr/Keyword;->keywordNamespace:Lgnu/mapping/Namespace;

    const/4 v3, 0x0

    invoke-virtual {v2, p0, v0, v3}, Lgnu/mapping/Namespace;->lookup(Ljava/lang/String;IZ)Lgnu/mapping/Symbol;

    move-result-object v1

    check-cast v1, Lgnu/expr/Keyword;

    .line 45
    .local v1, "keyword":Lgnu/expr/Keyword;
    if-nez v1, :cond_0

    .line 47
    new-instance v1, Lgnu/expr/Keyword;

    .end local v1    # "keyword":Lgnu/expr/Keyword;
    invoke-direct {v1, p0}, Lgnu/expr/Keyword;-><init>(Ljava/lang/String;)V

    .line 48
    .restart local v1    # "keyword":Lgnu/expr/Keyword;
    sget-object v2, Lgnu/expr/Keyword;->keywordNamespace:Lgnu/mapping/Namespace;

    invoke-virtual {v2, v1, v0}, Lgnu/mapping/Namespace;->add(Lgnu/mapping/Symbol;I)Lgnu/mapping/Symbol;

    .line 50
    :cond_0
    return-object v1
.end method

.method public static searchForKeyword([Ljava/lang/Object;ILjava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p0, "vals"    # [Ljava/lang/Object;
    .param p1, "offset"    # I
    .param p2, "keyword"    # Ljava/lang/Object;

    .prologue
    .line 89
    move v0, p1

    .local v0, "i":I
    :goto_0
    array-length v1, p0

    if-ge v0, v1, :cond_1

    .line 91
    aget-object v1, p0, v0

    if-ne v1, p2, :cond_0

    .line 92
    add-int/lit8 v1, v0, 0x1

    aget-object v1, p0, v1

    .line 94
    :goto_1
    return-object v1

    .line 89
    :cond_0
    add-int/lit8 v0, v0, 0x2

    goto :goto_0

    .line 94
    :cond_1
    sget-object v1, Lgnu/expr/Special;->dfault:Lgnu/expr/Special;

    goto :goto_1
.end method

.method public static searchForKeyword([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p0, "vals"    # [Ljava/lang/Object;
    .param p1, "offset"    # I
    .param p2, "keyword"    # Ljava/lang/Object;
    .param p3, "dfault"    # Ljava/lang/Object;

    .prologue
    .line 112
    move v0, p1

    .local v0, "i":I
    :goto_0
    array-length v1, p0

    if-ge v0, v1, :cond_0

    .line 114
    aget-object v1, p0, v0

    if-ne v1, p2, :cond_1

    .line 115
    add-int/lit8 v1, v0, 0x1

    aget-object p3, p0, v1

    .line 117
    .end local p3    # "dfault":Ljava/lang/Object;
    :cond_0
    return-object p3

    .line 112
    .restart local p3    # "dfault":Ljava/lang/Object;
    :cond_1
    add-int/lit8 v0, v0, 0x2

    goto :goto_0
.end method


# virtual methods
.method public asSymbol()Lgnu/mapping/Symbol;
    .locals 2

    .prologue
    .line 33
    sget-object v0, Lgnu/mapping/Namespace;->EmptyNamespace:Lgnu/mapping/Namespace;

    invoke-virtual {p0}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lgnu/mapping/Namespace;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v0

    return-object v0
.end method

.method public print(Lgnu/lists/Consumer;)V
    .locals 1
    .param p1, "out"    # Lgnu/lists/Consumer;

    .prologue
    .line 72
    invoke-virtual {p0}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, p1}, Lgnu/expr/Symbols;->print(Ljava/lang/String;Lgnu/lists/Consumer;)V

    .line 73
    const/16 v0, 0x3a

    invoke-interface {p1, v0}, Lgnu/lists/Consumer;->write(I)V

    .line 74
    return-void
.end method

.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 1
    .param p1, "in"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 128
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lgnu/expr/Keyword;->name:Ljava/lang/String;

    .line 129
    return-void
.end method

.method public readResolve()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/ObjectStreamException;
        }
    .end annotation

    .prologue
    .line 133
    sget-object v0, Lgnu/expr/Keyword;->keywordNamespace:Lgnu/mapping/Namespace;

    invoke-virtual {p0}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lgnu/expr/Keyword;->make(Ljava/lang/Object;Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v0

    return-object v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 67
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x3a

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 1
    .param p1, "out"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 122
    invoke-virtual {p0}, Lgnu/expr/Keyword;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 123
    return-void
.end method
