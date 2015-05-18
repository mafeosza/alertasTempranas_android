.class Lorg/json/zip/TrieKeep$Node;
.super Ljava/lang/Object;
.source "TrieKeep.java"

# interfaces
.implements Lorg/json/zip/PostMortem;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/json/zip/TrieKeep;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "Node"
.end annotation


# instance fields
.field private integer:I

.field private next:[Lorg/json/zip/TrieKeep$Node;

.field private final this$0:Lorg/json/zip/TrieKeep;


# direct methods
.method public constructor <init>(Lorg/json/zip/TrieKeep;)V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lorg/json/zip/TrieKeep$Node;->this$0:Lorg/json/zip/TrieKeep;

    .line 46
    const/4 v0, -0x1

    iput v0, p0, Lorg/json/zip/TrieKeep$Node;->integer:I

    .line 47
    const/4 v0, 0x0

    iput-object v0, p0, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    .line 48
    return-void
.end method

.method static access$000(Lorg/json/zip/TrieKeep$Node;)I
    .locals 1
    .param p0, "x0"    # Lorg/json/zip/TrieKeep$Node;

    .prologue
    .line 37
    iget v0, p0, Lorg/json/zip/TrieKeep$Node;->integer:I

    return v0
.end method

.method static access$002(Lorg/json/zip/TrieKeep$Node;I)I
    .locals 0
    .param p0, "x0"    # Lorg/json/zip/TrieKeep$Node;
    .param p1, "x1"    # I

    .prologue
    .line 37
    iput p1, p0, Lorg/json/zip/TrieKeep$Node;->integer:I

    return p1
.end method


# virtual methods
.method public get(B)Lorg/json/zip/TrieKeep$Node;
    .locals 1
    .param p1, "cell"    # B

    .prologue
    .line 71
    and-int/lit16 v0, p1, 0xff

    invoke-virtual {p0, v0}, Lorg/json/zip/TrieKeep$Node;->get(I)Lorg/json/zip/TrieKeep$Node;

    move-result-object v0

    return-object v0
.end method

.method public get(I)Lorg/json/zip/TrieKeep$Node;
    .locals 1
    .param p1, "cell"    # I

    .prologue
    .line 59
    iget-object v0, p0, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    aget-object v0, v0, p1

    goto :goto_0
.end method

.method public postMortem(Lorg/json/zip/PostMortem;)Z
    .locals 7
    .param p1, "pm"    # Lorg/json/zip/PostMortem;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 79
    move-object v2, p1

    check-cast v2, Lorg/json/zip/TrieKeep$Node;

    .line 80
    .local v2, "that":Lorg/json/zip/TrieKeep$Node;
    if-nez v2, :cond_1

    .line 81
    const-string v4, "\nMisalign"

    invoke-static {v4}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    .line 107
    :cond_0
    :goto_0
    return v3

    .line 84
    :cond_1
    iget v5, p0, Lorg/json/zip/TrieKeep$Node;->integer:I

    iget v6, v2, Lorg/json/zip/TrieKeep$Node;->integer:I

    if-eq v5, v6, :cond_2

    .line 85
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    const-string v5, "\nInteger "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    iget v5, p0, Lorg/json/zip/TrieKeep$Node;->integer:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v4

    const-string v5, " <> "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    iget v5, v2, Lorg/json/zip/TrieKeep$Node;->integer:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    goto :goto_0

    .line 89
    :cond_2
    iget-object v5, p0, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    if-nez v5, :cond_4

    .line 90
    iget-object v5, v2, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    if-nez v5, :cond_3

    move v3, v4

    .line 91
    goto :goto_0

    .line 93
    :cond_3
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    const-string v5, "\nNext is null "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    iget v5, p0, Lorg/json/zip/TrieKeep$Node;->integer:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    goto :goto_0

    .line 96
    :cond_4
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    const/16 v5, 0x100

    if-ge v0, v5, :cond_7

    .line 97
    iget-object v5, p0, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    aget-object v1, v5, v0

    .line 98
    .local v1, "node":Lorg/json/zip/TrieKeep$Node;
    if-eqz v1, :cond_6

    .line 99
    iget-object v5, v2, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    aget-object v5, v5, v0

    invoke-virtual {v1, v5}, Lorg/json/zip/TrieKeep$Node;->postMortem(Lorg/json/zip/PostMortem;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 96
    :cond_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 102
    :cond_6
    iget-object v5, v2, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    aget-object v5, v5, v0

    if-eqz v5, :cond_5

    .line 103
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    const-string v5, "\nMisalign "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    goto/16 :goto_0

    .end local v1    # "node":Lorg/json/zip/TrieKeep$Node;
    :cond_7
    move v3, v4

    .line 107
    goto/16 :goto_0
.end method

.method public set(BLorg/json/zip/TrieKeep$Node;)V
    .locals 1
    .param p1, "cell"    # B
    .param p2, "node"    # Lorg/json/zip/TrieKeep$Node;

    .prologue
    .line 139
    and-int/lit16 v0, p1, 0xff

    invoke-virtual {p0, v0, p2}, Lorg/json/zip/TrieKeep$Node;->set(ILorg/json/zip/TrieKeep$Node;)V

    .line 140
    return-void
.end method

.method public set(ILorg/json/zip/TrieKeep$Node;)V
    .locals 1
    .param p1, "cell"    # I
    .param p2, "node"    # Lorg/json/zip/TrieKeep$Node;

    .prologue
    .line 119
    iget-object v0, p0, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    if-nez v0, :cond_0

    .line 120
    const/16 v0, 0x100

    new-array v0, v0, [Lorg/json/zip/TrieKeep$Node;

    iput-object v0, p0, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    .line 127
    :cond_0
    iget-object v0, p0, Lorg/json/zip/TrieKeep$Node;->next:[Lorg/json/zip/TrieKeep$Node;

    aput-object p2, v0, p1

    .line 128
    return-void
.end method

.method public vet(B)Lorg/json/zip/TrieKeep$Node;
    .locals 1
    .param p1, "cell"    # B

    .prologue
    .line 168
    and-int/lit16 v0, p1, 0xff

    invoke-virtual {p0, v0}, Lorg/json/zip/TrieKeep$Node;->vet(I)Lorg/json/zip/TrieKeep$Node;

    move-result-object v0

    return-object v0
.end method

.method public vet(I)Lorg/json/zip/TrieKeep$Node;
    .locals 2
    .param p1, "cell"    # I

    .prologue
    .line 151
    invoke-virtual {p0, p1}, Lorg/json/zip/TrieKeep$Node;->get(I)Lorg/json/zip/TrieKeep$Node;

    move-result-object v0

    .line 152
    .local v0, "node":Lorg/json/zip/TrieKeep$Node;
    if-nez v0, :cond_0

    .line 153
    new-instance v0, Lorg/json/zip/TrieKeep$Node;

    .end local v0    # "node":Lorg/json/zip/TrieKeep$Node;
    iget-object v1, p0, Lorg/json/zip/TrieKeep$Node;->this$0:Lorg/json/zip/TrieKeep;

    invoke-direct {v0, v1}, Lorg/json/zip/TrieKeep$Node;-><init>(Lorg/json/zip/TrieKeep;)V

    .line 154
    .restart local v0    # "node":Lorg/json/zip/TrieKeep$Node;
    invoke-virtual {p0, p1, v0}, Lorg/json/zip/TrieKeep$Node;->set(ILorg/json/zip/TrieKeep$Node;)V

    .line 156
    :cond_0
    return-object v0
.end method
