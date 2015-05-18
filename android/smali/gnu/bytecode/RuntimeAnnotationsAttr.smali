.class public Lgnu/bytecode/RuntimeAnnotationsAttr;
.super Lgnu/bytecode/MiscAttr;
.source "RuntimeAnnotationsAttr.java"


# instance fields
.field numEntries:I


# direct methods
.method public constructor <init>(Ljava/lang/String;[BLgnu/bytecode/AttrContainer;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "data"    # [B
    .param p3, "container"    # Lgnu/bytecode/AttrContainer;

    .prologue
    const/4 v1, 0x0

    .line 15
    array-length v0, p2

    invoke-direct {p0, p1, p2, v1, v0}, Lgnu/bytecode/MiscAttr;-><init>(Ljava/lang/String;[BII)V

    .line 16
    invoke-virtual {p0, p3}, Lgnu/bytecode/RuntimeAnnotationsAttr;->addToFrontOf(Lgnu/bytecode/AttrContainer;)V

    .line 17
    invoke-virtual {p0, v1}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u2(I)I

    move-result v0

    iput v0, p0, Lgnu/bytecode/RuntimeAnnotationsAttr;->numEntries:I

    .line 18
    return-void
.end method


# virtual methods
.method public print(Lgnu/bytecode/ClassTypeWriter;)V
    .locals 3
    .param p1, "dst"    # Lgnu/bytecode/ClassTypeWriter;

    .prologue
    .line 22
    const-string v2, "Attribute \""

    invoke-virtual {p1, v2}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 23
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 24
    const-string v2, "\", length:"

    invoke-virtual {p1, v2}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 25
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->getLength()I

    move-result v2

    invoke-virtual {p1, v2}, Lgnu/bytecode/ClassTypeWriter;->print(I)V

    .line 26
    const-string v2, ", number of entries: "

    invoke-virtual {p1, v2}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 27
    iget v2, p0, Lgnu/bytecode/RuntimeAnnotationsAttr;->numEntries:I

    invoke-virtual {p1, v2}, Lgnu/bytecode/ClassTypeWriter;->println(I)V

    .line 28
    iget v1, p0, Lgnu/bytecode/RuntimeAnnotationsAttr;->offset:I

    .line 29
    .local v1, "saveOffset":I
    add-int/lit8 v2, v1, 0x2

    iput v2, p0, Lgnu/bytecode/RuntimeAnnotationsAttr;->offset:I

    .line 30
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget v2, p0, Lgnu/bytecode/RuntimeAnnotationsAttr;->numEntries:I

    if-ge v0, v2, :cond_0

    .line 32
    const/4 v2, 0x2

    invoke-virtual {p0, v2, p1}, Lgnu/bytecode/RuntimeAnnotationsAttr;->printAnnotation(ILgnu/bytecode/ClassTypeWriter;)V

    .line 30
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 34
    :cond_0
    iput v1, p0, Lgnu/bytecode/RuntimeAnnotationsAttr;->offset:I

    .line 35
    return-void
.end method

.method public printAnnotation(ILgnu/bytecode/ClassTypeWriter;)V
    .locals 5
    .param p1, "indentation"    # I
    .param p2, "dst"    # Lgnu/bytecode/ClassTypeWriter;

    .prologue
    .line 39
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u2()I

    move-result v3

    .line 40
    .local v3, "type_index":I
    invoke-virtual {p2, p1}, Lgnu/bytecode/ClassTypeWriter;->printSpaces(I)V

    .line 41
    invoke-virtual {p2, v3}, Lgnu/bytecode/ClassTypeWriter;->printOptionalIndex(I)V

    .line 42
    const/16 v4, 0x40

    invoke-virtual {p2, v4}, Lgnu/bytecode/ClassTypeWriter;->print(C)V

    .line 43
    invoke-virtual {p2, v3}, Lgnu/bytecode/ClassTypeWriter;->printContantUtf8AsClass(I)V

    .line 44
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u2()I

    move-result v2

    .line 45
    .local v2, "num_element_value_pairs":I
    invoke-virtual {p2}, Lgnu/bytecode/ClassTypeWriter;->println()V

    .line 46
    add-int/lit8 p1, p1, 0x2

    .line 47
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 49
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u2()I

    move-result v0

    .line 50
    .local v0, "element_name_index":I
    invoke-virtual {p2, p1}, Lgnu/bytecode/ClassTypeWriter;->printSpaces(I)V

    .line 51
    invoke-virtual {p2, v0}, Lgnu/bytecode/ClassTypeWriter;->printOptionalIndex(I)V

    .line 52
    const/4 v4, 0x1

    invoke-virtual {p2, v0, v4}, Lgnu/bytecode/ClassTypeWriter;->printConstantTersely(II)V

    .line 53
    const-string v4, " => "

    invoke-virtual {p2, v4}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 54
    invoke-virtual {p0, p1, p2}, Lgnu/bytecode/RuntimeAnnotationsAttr;->printAnnotationElementValue(ILgnu/bytecode/ClassTypeWriter;)V

    .line 55
    invoke-virtual {p2}, Lgnu/bytecode/ClassTypeWriter;->println()V

    .line 47
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 57
    .end local v0    # "element_name_index":I
    :cond_0
    return-void
.end method

.method public printAnnotationElementValue(ILgnu/bytecode/ClassTypeWriter;)V
    .locals 13
    .param p1, "indentation"    # I
    .param p2, "dst"    # Lgnu/bytecode/ClassTypeWriter;

    .prologue
    const/4 v12, 0x1

    .line 61
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u1()I

    move-result v8

    .line 62
    .local v8, "tag":I
    iget v10, p2, Lgnu/bytecode/ClassTypeWriter;->flags:I

    and-int/lit8 v10, v10, 0x8

    if-eqz v10, :cond_0

    .line 64
    const-string v10, "[kind:"

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 65
    const/16 v10, 0x41

    if-lt v8, v10, :cond_2

    const/16 v10, 0x7a

    if-gt v8, v10, :cond_2

    .line 66
    int-to-char v10, v8

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(C)V

    .line 69
    :goto_0
    const-string v10, "] "

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 71
    :cond_0
    const/4 v5, 0x0

    .line 72
    .local v5, "expected":I
    sparse-switch v8, :sswitch_data_0

    .line 144
    :cond_1
    :goto_1
    return-void

    .line 68
    .end local v5    # "expected":I
    :cond_2
    invoke-virtual {p2, v8}, Lgnu/bytecode/ClassTypeWriter;->print(I)V

    goto :goto_0

    .line 79
    .restart local v5    # "expected":I
    :sswitch_0
    if-nez v5, :cond_3

    const/4 v5, 0x3

    .line 82
    :cond_3
    :sswitch_1
    if-nez v5, :cond_4

    const/4 v5, 0x5

    .line 85
    :cond_4
    :sswitch_2
    if-nez v5, :cond_5

    const/4 v5, 0x6

    .line 88
    :cond_5
    :sswitch_3
    if-nez v5, :cond_6

    const/4 v5, 0x4

    .line 91
    :cond_6
    :sswitch_4
    if-nez v5, :cond_7

    const/4 v5, 0x1

    .line 93
    :cond_7
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u2()I

    move-result v3

    .line 94
    .local v3, "const_value_index":I
    invoke-virtual {p2, v3}, Lgnu/bytecode/ClassTypeWriter;->getCpoolEntry(I)Lgnu/bytecode/CpoolEntry;

    move-result-object v4

    .line 95
    .local v4, "entry":Lgnu/bytecode/CpoolEntry;
    invoke-virtual {p2, v4}, Lgnu/bytecode/ClassTypeWriter;->printOptionalIndex(Lgnu/bytecode/CpoolEntry;)V

    .line 97
    const/16 v10, 0x5a

    if-ne v8, v10, :cond_a

    if-eqz v4, :cond_a

    invoke-virtual {v4}, Lgnu/bytecode/CpoolEntry;->getTag()I

    move-result v10

    const/4 v11, 0x3

    if-ne v10, v11, :cond_a

    move-object v0, v4

    check-cast v0, Lgnu/bytecode/CpoolValue1;

    .local v0, "cint":Lgnu/bytecode/CpoolValue1;
    iget v10, v0, Lgnu/bytecode/CpoolValue1;->value:I

    if-eqz v10, :cond_8

    iget v10, v0, Lgnu/bytecode/CpoolValue1;->value:I

    if-ne v10, v12, :cond_a

    .line 100
    :cond_8
    iget v10, v0, Lgnu/bytecode/CpoolValue1;->value:I

    if-nez v10, :cond_9

    const-string v10, "false"

    :goto_2
    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    goto :goto_1

    :cond_9
    const-string v10, "true"

    goto :goto_2

    .line 102
    .end local v0    # "cint":Lgnu/bytecode/CpoolValue1;
    :cond_a
    invoke-virtual {p2, v3, v5}, Lgnu/bytecode/ClassTypeWriter;->printConstantTersely(II)V

    goto :goto_1

    .line 105
    .end local v3    # "const_value_index":I
    .end local v4    # "entry":Lgnu/bytecode/CpoolEntry;
    :sswitch_5
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u2()I

    move-result v9

    .line 106
    .local v9, "type_name_index":I
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u2()I

    move-result v2

    .line 107
    .local v2, "const_name_index":I
    const-string v10, "enum["

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 108
    iget v10, p2, Lgnu/bytecode/ClassTypeWriter;->flags:I

    and-int/lit8 v10, v10, 0x8

    if-eqz v10, :cond_b

    .line 109
    const-string v10, "type:"

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 110
    :cond_b
    invoke-virtual {p2, v9}, Lgnu/bytecode/ClassTypeWriter;->printOptionalIndex(I)V

    .line 111
    invoke-virtual {p2, v9}, Lgnu/bytecode/ClassTypeWriter;->printContantUtf8AsClass(I)V

    .line 112
    iget v10, p2, Lgnu/bytecode/ClassTypeWriter;->flags:I

    and-int/lit8 v10, v10, 0x8

    if-eqz v10, :cond_c

    .line 113
    const-string v10, " value:"

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 116
    :goto_3
    invoke-virtual {p2, v2}, Lgnu/bytecode/ClassTypeWriter;->printOptionalIndex(I)V

    .line 117
    invoke-virtual {p2, v2, v12}, Lgnu/bytecode/ClassTypeWriter;->printConstantTersely(II)V

    .line 118
    const-string v10, "]"

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    goto :goto_1

    .line 115
    :cond_c
    const/16 v10, 0x20

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(C)V

    goto :goto_3

    .line 121
    .end local v2    # "const_name_index":I
    .end local v9    # "type_name_index":I
    :sswitch_6
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u2()I

    move-result v1

    .line 122
    .local v1, "class_info_index":I
    invoke-virtual {p2, v1}, Lgnu/bytecode/ClassTypeWriter;->printOptionalIndex(I)V

    .line 123
    invoke-virtual {p2, v1}, Lgnu/bytecode/ClassTypeWriter;->printContantUtf8AsClass(I)V

    goto/16 :goto_1

    .line 126
    .end local v1    # "class_info_index":I
    :sswitch_7
    invoke-virtual {p2}, Lgnu/bytecode/ClassTypeWriter;->println()V

    .line 127
    add-int/lit8 v10, p1, 0x2

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->printSpaces(I)V

    .line 128
    add-int/lit8 v10, p1, 0x2

    invoke-virtual {p0, v10, p2}, Lgnu/bytecode/RuntimeAnnotationsAttr;->printAnnotation(ILgnu/bytecode/ClassTypeWriter;)V

    goto/16 :goto_1

    .line 131
    :sswitch_8
    invoke-virtual {p0}, Lgnu/bytecode/RuntimeAnnotationsAttr;->u2()I

    move-result v7

    .line 132
    .local v7, "num_values":I
    const-string v10, "array length:"

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 133
    invoke-virtual {p2, v7}, Lgnu/bytecode/ClassTypeWriter;->print(I)V

    .line 134
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_4
    if-ge v6, v7, :cond_1

    .line 136
    invoke-virtual {p2}, Lgnu/bytecode/ClassTypeWriter;->println()V

    .line 137
    add-int/lit8 v10, p1, 0x2

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->printSpaces(I)V

    .line 138
    invoke-virtual {p2, v6}, Lgnu/bytecode/ClassTypeWriter;->print(I)V

    .line 139
    const-string v10, ": "

    invoke-virtual {p2, v10}, Lgnu/bytecode/ClassTypeWriter;->print(Ljava/lang/String;)V

    .line 140
    add-int/lit8 v10, p1, 0x2

    invoke-virtual {p0, v10, p2}, Lgnu/bytecode/RuntimeAnnotationsAttr;->printAnnotationElementValue(ILgnu/bytecode/ClassTypeWriter;)V

    .line 134
    add-int/lit8 v6, v6, 0x1

    goto :goto_4

    .line 72
    :sswitch_data_0
    .sparse-switch
        0x40 -> :sswitch_7
        0x42 -> :sswitch_0
        0x43 -> :sswitch_0
        0x44 -> :sswitch_2
        0x46 -> :sswitch_3
        0x49 -> :sswitch_0
        0x4a -> :sswitch_1
        0x53 -> :sswitch_0
        0x5a -> :sswitch_0
        0x5b -> :sswitch_8
        0x63 -> :sswitch_6
        0x65 -> :sswitch_5
        0x73 -> :sswitch_4
    .end sparse-switch
.end method
