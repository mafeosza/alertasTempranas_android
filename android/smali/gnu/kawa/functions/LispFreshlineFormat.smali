.class Lgnu/kawa/functions/LispFreshlineFormat;
.super Lgnu/text/ReportFormat;
.source "LispFormat.java"


# instance fields
.field count:I


# direct methods
.method public constructor <init>(I)V
    .locals 0
    .param p1, "count"    # I

    .prologue
    .line 1110
    invoke-direct {p0}, Lgnu/text/ReportFormat;-><init>()V

    .line 1111
    iput p1, p0, Lgnu/kawa/functions/LispFreshlineFormat;->count:I

    .line 1112
    return-void
.end method


# virtual methods
.method public format([Ljava/lang/Object;ILjava/io/Writer;Ljava/text/FieldPosition;)I
    .locals 3
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
    .line 1117
    iget v1, p0, Lgnu/kawa/functions/LispFreshlineFormat;->count:I

    const/4 v2, 0x1

    invoke-static {v1, v2, p1, p2}, Lgnu/kawa/functions/LispFreshlineFormat;->getParam(II[Ljava/lang/Object;I)I

    move-result v0

    .line 1118
    .local v0, "count":I
    iget v1, p0, Lgnu/kawa/functions/LispFreshlineFormat;->count:I

    const/high16 v2, -0x60000000

    if-ne v1, v2, :cond_0

    add-int/lit8 p2, p2, 0x1

    .line 1119
    :cond_0
    if-lez v0, :cond_2

    .line 1121
    instance-of v1, p3, Lgnu/mapping/OutPort;

    if-eqz v1, :cond_1

    move-object v1, p3

    .line 1123
    check-cast v1, Lgnu/mapping/OutPort;

    invoke-virtual {v1}, Lgnu/mapping/OutPort;->freshLine()V

    .line 1124
    add-int/lit8 v0, v0, -0x1

    .line 1126
    :cond_1
    :goto_0
    add-int/lit8 v0, v0, -0x1

    if-ltz v0, :cond_2

    .line 1127
    const/16 v1, 0xa

    invoke-virtual {p3, v1}, Ljava/io/Writer;->write(I)V

    goto :goto_0

    .line 1129
    :cond_2
    return p2
.end method
