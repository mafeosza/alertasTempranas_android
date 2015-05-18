.class Lorg/json/zip/MapKeep;
.super Lorg/json/zip/Keep;
.source "MapKeep.java"


# instance fields
.field private list:[Ljava/lang/Object;

.field private map:Ljava/util/HashMap;


# direct methods
.method public constructor <init>(I)V
    .locals 2
    .param p1, "bits"    # I

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lorg/json/zip/Keep;-><init>(I)V

    .line 50
    iget v0, p0, Lorg/json/zip/MapKeep;->capacity:I

    new-array v0, v0, [Ljava/lang/Object;

    iput-object v0, p0, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    .line 51
    new-instance v0, Ljava/util/HashMap;

    iget v1, p0, Lorg/json/zip/MapKeep;->capacity:I

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    iput-object v0, p0, Lorg/json/zip/MapKeep;->map:Ljava/util/HashMap;

    .line 52
    return-void
.end method

.method private compact()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 60
    const/4 v0, 0x0

    .line 61
    .local v0, "from":I
    const/4 v2, 0x0

    .line 62
    .local v2, "to":I
    :goto_0
    iget v5, p0, Lorg/json/zip/MapKeep;->capacity:I

    if-ge v0, v5, :cond_1

    .line 63
    iget-object v5, p0, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aget-object v1, v5, v0

    .line 64
    .local v1, "key":Ljava/lang/Object;
    iget-object v5, p0, Lorg/json/zip/MapKeep;->uses:[J

    aget-wide v5, v5, v0

    invoke-static {v5, v6}, Lorg/json/zip/MapKeep;->age(J)J

    move-result-wide v3

    .line 65
    .local v3, "usage":J
    const-wide/16 v5, 0x0

    cmp-long v5, v3, v5

    if-lez v5, :cond_0

    .line 66
    iget-object v5, p0, Lorg/json/zip/MapKeep;->uses:[J

    aput-wide v3, v5, v2

    .line 67
    iget-object v5, p0, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aput-object v1, v5, v2

    .line 68
    iget-object v5, p0, Lorg/json/zip/MapKeep;->map:Ljava/util/HashMap;

    new-instance v6, Ljava/lang/Integer;

    invoke-direct {v6, v2}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v5, v1, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    add-int/lit8 v2, v2, 0x1

    .line 73
    :goto_1
    add-int/lit8 v0, v0, 0x1

    .line 74
    goto :goto_0

    .line 71
    :cond_0
    iget-object v5, p0, Lorg/json/zip/MapKeep;->map:Ljava/util/HashMap;

    invoke-virtual {v5, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 75
    .end local v1    # "key":Ljava/lang/Object;
    .end local v3    # "usage":J
    :cond_1
    iget v5, p0, Lorg/json/zip/MapKeep;->capacity:I

    if-ge v2, v5, :cond_2

    .line 76
    iput v2, p0, Lorg/json/zip/MapKeep;->length:I

    .line 81
    :goto_2
    iput v7, p0, Lorg/json/zip/MapKeep;->power:I

    .line 82
    return-void

    .line 78
    :cond_2
    iget-object v5, p0, Lorg/json/zip/MapKeep;->map:Ljava/util/HashMap;

    invoke-virtual {v5}, Ljava/util/HashMap;->clear()V

    .line 79
    iput v7, p0, Lorg/json/zip/MapKeep;->length:I

    goto :goto_2
.end method


# virtual methods
.method public find(Ljava/lang/Object;)I
    .locals 2
    .param p1, "key"    # Ljava/lang/Object;

    .prologue
    .line 93
    iget-object v1, p0, Lorg/json/zip/MapKeep;->map:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 94
    .local v0, "o":Ljava/lang/Object;
    instance-of v1, v0, Ljava/lang/Integer;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/Integer;

    .end local v0    # "o":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    :goto_0
    return v1

    .restart local v0    # "o":Ljava/lang/Object;
    :cond_0
    const/4 v1, -0x1

    goto :goto_0
.end method

.method public postMortem(Lorg/json/zip/PostMortem;)Z
    .locals 9
    .param p1, "pm"    # Lorg/json/zip/PostMortem;

    .prologue
    const/4 v6, 0x0

    .line 98
    move-object v4, p1

    check-cast v4, Lorg/json/zip/MapKeep;

    .line 99
    .local v4, "that":Lorg/json/zip/MapKeep;
    iget v5, p0, Lorg/json/zip/MapKeep;->length:I

    iget v7, v4, Lorg/json/zip/MapKeep;->length:I

    if-eq v5, v7, :cond_0

    .line 100
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    iget v7, p0, Lorg/json/zip/MapKeep;->length:I

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v7, " <> "

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget v7, v4, Lorg/json/zip/MapKeep;->length:I

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    move v5, v6

    .line 125
    :goto_0
    return v5

    .line 103
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget v5, p0, Lorg/json/zip/MapKeep;->length:I

    if-ge v1, v5, :cond_5

    .line 105
    iget-object v5, p0, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aget-object v5, v5, v1

    instance-of v5, v5, Lorg/json/Kim;

    if-eqz v5, :cond_1

    .line 106
    iget-object v5, p0, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aget-object v5, v5, v1

    check-cast v5, Lorg/json/Kim;

    iget-object v7, v4, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aget-object v7, v7, v1

    invoke-virtual {v5, v7}, Lorg/json/Kim;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 118
    .local v0, "b":Z
    :goto_2
    if-nez v0, :cond_4

    .line 119
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    const-string v7, "\n["

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v7, "]\n "

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget-object v7, p0, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aget-object v7, v7, v1

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v7, "\n "

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget-object v7, v4, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aget-object v7, v7, v1

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v7, "\n "

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget-object v7, p0, Lorg/json/zip/MapKeep;->uses:[J

    aget-wide v7, v7, v1

    invoke-virtual {v5, v7, v8}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v5

    const-string v7, "\n "

    invoke-virtual {v5, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v5

    iget-object v7, v4, Lorg/json/zip/MapKeep;->uses:[J

    aget-wide v7, v7, v1

    invoke-virtual {v5, v7, v8}, Ljava/lang/StringBuffer;->append(J)Ljava/lang/StringBuffer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lorg/json/zip/JSONzip;->log(Ljava/lang/String;)V

    move v5, v6

    .line 122
    goto :goto_0

    .line 108
    .end local v0    # "b":Z
    :cond_1
    iget-object v5, p0, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aget-object v2, v5, v1

    .line 109
    .local v2, "o":Ljava/lang/Object;
    iget-object v5, v4, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aget-object v3, v5, v1

    .line 110
    .local v3, "q":Ljava/lang/Object;
    instance-of v5, v2, Ljava/lang/Number;

    if-eqz v5, :cond_2

    .line 111
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 113
    .end local v2    # "o":Ljava/lang/Object;
    :cond_2
    instance-of v5, v3, Ljava/lang/Number;

    if-eqz v5, :cond_3

    .line 114
    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 116
    .end local v3    # "q":Ljava/lang/Object;
    :cond_3
    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    .restart local v0    # "b":Z
    goto :goto_2

    .line 103
    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto/16 :goto_1

    .line 125
    .end local v0    # "b":Z
    :cond_5
    const/4 v5, 0x1

    goto/16 :goto_0
.end method

.method public register(Ljava/lang/Object;)V
    .locals 4
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 140
    iget v0, p0, Lorg/json/zip/MapKeep;->length:I

    iget v1, p0, Lorg/json/zip/MapKeep;->capacity:I

    if-lt v0, v1, :cond_0

    .line 141
    invoke-direct {p0}, Lorg/json/zip/MapKeep;->compact()V

    .line 143
    :cond_0
    iget-object v0, p0, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    iget v1, p0, Lorg/json/zip/MapKeep;->length:I

    aput-object p1, v0, v1

    .line 144
    iget-object v0, p0, Lorg/json/zip/MapKeep;->map:Ljava/util/HashMap;

    new-instance v1, Ljava/lang/Integer;

    iget v2, p0, Lorg/json/zip/MapKeep;->length:I

    invoke-direct {v1, v2}, Ljava/lang/Integer;-><init>(I)V

    invoke-virtual {v0, p1, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    iget-object v0, p0, Lorg/json/zip/MapKeep;->uses:[J

    iget v1, p0, Lorg/json/zip/MapKeep;->length:I

    const-wide/16 v2, 0x1

    aput-wide v2, v0, v1

    .line 149
    iget v0, p0, Lorg/json/zip/MapKeep;->length:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lorg/json/zip/MapKeep;->length:I

    .line 150
    return-void
.end method

.method public value(I)Ljava/lang/Object;
    .locals 1
    .param p1, "integer"    # I

    .prologue
    .line 158
    iget-object v0, p0, Lorg/json/zip/MapKeep;->list:[Ljava/lang/Object;

    aget-object v0, v0, p1

    return-object v0
.end method
