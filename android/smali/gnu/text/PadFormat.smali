.class public Lgnu/text/PadFormat;
.super Lgnu/text/ReportFormat;
.source "PadFormat.java"


# instance fields
.field fmt:Ljava/text/Format;

.field minWidth:I

.field padChar:C

.field where:I


# direct methods
.method public constructor <init>(Ljava/text/Format;I)V
    .locals 2
    .param p1, "fmt"    # Ljava/text/Format;
    .param p2, "minWidth"    # I

    .prologue
    .line 29
    const/16 v0, 0x20

    const/16 v1, 0x64

    invoke-direct {p0, p1, p2, v0, v1}, Lgnu/text/PadFormat;-><init>(Ljava/text/Format;ICI)V

    .line 30
    return-void
.end method

.method public constructor <init>(Ljava/text/Format;ICI)V
    .locals 0
    .param p1, "fmt"    # Ljava/text/Format;
    .param p2, "minWidth"    # I
    .param p3, "padChar"    # C
    .param p4, "where"    # I

    .prologue
    .line 20
    invoke-direct {p0}, Lgnu/text/ReportFormat;-><init>()V

    .line 21
    iput-object p1, p0, Lgnu/text/PadFormat;->fmt:Ljava/text/Format;

    .line 22
    iput p2, p0, Lgnu/text/PadFormat;->minWidth:I

    .line 23
    iput-char p3, p0, Lgnu/text/PadFormat;->padChar:C

    .line 24
    iput p4, p0, Lgnu/text/PadFormat;->where:I

    .line 25
    return-void
.end method

.method public static format(Ljava/text/Format;[Ljava/lang/Object;ILjava/io/Writer;CIIIILjava/text/FieldPosition;)I
    .locals 13
    .param p0, "fmt"    # Ljava/text/Format;
    .param p1, "args"    # [Ljava/lang/Object;
    .param p2, "start"    # I
    .param p3, "dst"    # Ljava/io/Writer;
    .param p4, "padChar"    # C
    .param p5, "minWidth"    # I
    .param p6, "colInc"    # I
    .param p7, "minPad"    # I
    .param p8, "where"    # I
    .param p9, "fpos"    # Ljava/text/FieldPosition;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 68
    new-instance v9, Ljava/lang/StringBuffer;

    const/16 v11, 0xc8

    invoke-direct {v9, v11}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 69
    .local v9, "tbuf":Ljava/lang/StringBuffer;
    instance-of v11, p0, Lgnu/text/ReportFormat;

    if-eqz v11, :cond_6

    .line 70
    check-cast p0, Lgnu/text/ReportFormat;

    .end local p0    # "fmt":Ljava/text/Format;
    move-object/from16 v0, p9

    invoke-virtual {p0, p1, p2, v9, v0}, Lgnu/text/ReportFormat;->format([Ljava/lang/Object;ILjava/lang/StringBuffer;Ljava/text/FieldPosition;)I

    move-result p2

    .line 82
    :goto_0
    invoke-virtual {v9}, Ljava/lang/StringBuffer;->length()I

    move-result v4

    .line 83
    .local v4, "len":I
    move/from16 v0, p5

    move/from16 v1, p6

    move/from16 v2, p7

    invoke-static {v4, v0, v1, v2}, Lgnu/text/PadFormat;->padNeeded(IIII)I

    move-result v5

    .line 84
    .local v5, "pad":I
    const/4 v8, 0x0

    .line 85
    .local v8, "prefix":I
    invoke-virtual {v9}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v10

    .line 86
    .local v10, "text":Ljava/lang/String;
    if-lez v5, :cond_9

    .line 88
    const/4 v11, -0x1

    move/from16 v0, p8

    if-ne v0, v11, :cond_5

    .line 90
    if-lez v4, :cond_4

    .line 92
    const/4 v11, 0x0

    invoke-virtual {v10, v11}, Ljava/lang/String;->charAt(I)C

    move-result v3

    .line 93
    .local v3, "ch":C
    const/16 v11, 0x2d

    if-eq v3, v11, :cond_0

    const/16 v11, 0x2b

    if-ne v3, v11, :cond_1

    .line 95
    :cond_0
    add-int/lit8 v8, v8, 0x1

    .line 96
    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/io/Writer;->write(I)V

    .line 98
    :cond_1
    sub-int v11, v4, v8

    const/4 v12, 0x2

    if-le v11, v12, :cond_3

    invoke-virtual {v10, v8}, Ljava/lang/String;->charAt(I)C

    move-result v11

    const/16 v12, 0x30

    if-ne v11, v12, :cond_3

    .line 100
    const/16 v11, 0x30

    move-object/from16 v0, p3

    invoke-virtual {v0, v11}, Ljava/io/Writer;->write(I)V

    .line 101
    add-int/lit8 v8, v8, 0x1

    invoke-virtual {v10, v8}, Ljava/lang/String;->charAt(I)C

    move-result v3

    .line 102
    const/16 v11, 0x78

    if-eq v3, v11, :cond_2

    const/16 v11, 0x58

    if-ne v3, v11, :cond_3

    .line 104
    :cond_2
    add-int/lit8 v8, v8, 0x1

    .line 105
    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/io/Writer;->write(I)V

    .line 108
    :cond_3
    if-lez v8, :cond_4

    .line 109
    invoke-virtual {v10, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v10

    .line 111
    .end local v3    # "ch":C
    :cond_4
    const/16 p8, 0x0

    .line 113
    :cond_5
    mul-int v11, v5, p8

    div-int/lit8 v6, v11, 0x64

    .line 114
    .local v6, "padAfter":I
    sub-int v7, v5, v6

    .line 123
    .local v7, "padBefore":I
    :goto_1
    add-int/lit8 v7, v7, -0x1

    if-ltz v7, :cond_8

    .line 124
    invoke-virtual/range {p3 .. p4}, Ljava/io/Writer;->write(I)V

    goto :goto_1

    .line 71
    .end local v4    # "len":I
    .end local v5    # "pad":I
    .end local v6    # "padAfter":I
    .end local v7    # "padBefore":I
    .end local v8    # "prefix":I
    .end local v10    # "text":Ljava/lang/String;
    .restart local p0    # "fmt":Ljava/text/Format;
    :cond_6
    instance-of v11, p0, Ljava/text/MessageFormat;

    if-eqz v11, :cond_7

    .line 74
    move-object/from16 v0, p9

    invoke-virtual {p0, p1, v9, v0}, Ljava/text/Format;->format(Ljava/lang/Object;Ljava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;

    .line 75
    array-length p2, p1

    goto :goto_0

    .line 79
    :cond_7
    aget-object v11, p1, p2

    move-object/from16 v0, p9

    invoke-virtual {p0, v11, v9, v0}, Ljava/text/Format;->format(Ljava/lang/Object;Ljava/lang/StringBuffer;Ljava/text/FieldPosition;)Ljava/lang/StringBuffer;

    .line 80
    add-int/lit8 p2, p2, 0x1

    goto/16 :goto_0

    .line 125
    .end local p0    # "fmt":Ljava/text/Format;
    .restart local v4    # "len":I
    .restart local v5    # "pad":I
    .restart local v6    # "padAfter":I
    .restart local v7    # "padBefore":I
    .restart local v8    # "prefix":I
    .restart local v10    # "text":Ljava/lang/String;
    :cond_8
    move-object/from16 v0, p3

    invoke-virtual {v0, v10}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 126
    :goto_2
    add-int/lit8 v6, v6, -0x1

    if-ltz v6, :cond_a

    .line 127
    invoke-virtual/range {p3 .. p4}, Ljava/io/Writer;->write(I)V

    goto :goto_2

    .line 131
    .end local v6    # "padAfter":I
    .end local v7    # "padBefore":I
    :cond_9
    move-object/from16 v0, p3

    invoke-virtual {v0, v10}, Ljava/io/Writer;->write(Ljava/lang/String;)V

    .line 133
    :cond_a
    return p2
.end method

.method public static padNeeded(IIII)I
    .locals 2
    .param p0, "actualWidth"    # I
    .param p1, "minWidth"    # I
    .param p2, "colInc"    # I
    .param p3, "minPad"    # I

    .prologue
    .line 42
    add-int v0, p0, p3

    .line 43
    .local v0, "total":I
    const/4 v1, 0x1

    if-gt p2, v1, :cond_0

    .line 44
    sub-int p2, p1, v0

    .line 45
    :cond_0
    :goto_0
    if-ge v0, p1, :cond_1

    .line 46
    add-int/2addr v0, p2

    goto :goto_0

    .line 47
    :cond_1
    sub-int v1, v0, p0

    return v1
.end method


# virtual methods
.method public format([Ljava/lang/Object;ILjava/io/Writer;Ljava/text/FieldPosition;)I
    .locals 10
    .param p1, "args"    # [Ljava/lang/Object;
    .param p2, "start"    # I
    .param p3, "dst"    # Ljava/io/Writer;
    .param p4, "fpos"    # Ljava/text/FieldPosition;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 36
    iget-object v0, p0, Lgnu/text/PadFormat;->fmt:Ljava/text/Format;

    iget-char v4, p0, Lgnu/text/PadFormat;->padChar:C

    iget v5, p0, Lgnu/text/PadFormat;->minWidth:I

    const/4 v6, 0x1

    const/4 v7, 0x0

    iget v8, p0, Lgnu/text/PadFormat;->where:I

    move-object v1, p1

    move v2, p2

    move-object v3, p3

    move-object v9, p4

    invoke-static/range {v0 .. v9}, Lgnu/text/PadFormat;->format(Ljava/text/Format;[Ljava/lang/Object;ILjava/io/Writer;CIIIILjava/text/FieldPosition;)I

    move-result v0

    return v0
.end method
