.class public final Lcom/google/appinventor/components/runtime/util/YailNumberToString;
.super Ljava/lang/Object;
.source "YailNumberToString.java"


# static fields
.field private static final BIGBOUND:D = 1000000.0

.field static final LOG_TAG:Ljava/lang/String; = "YailNumberToString"

.field private static final SMALLBOUND:D = 1.0E-6

.field private static final decPattern:Ljava/lang/String; = "#####0.0####"

.field static decimalFormat:Ljava/text/DecimalFormat; = null

.field static locale:Ljava/util/Locale; = null

.field static sciFormat:Ljava/text/DecimalFormat; = null

.field private static final sciPattern:Ljava/lang/String; = "0.####E0"

.field static symbols:Ljava/text/DecimalFormatSymbols;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 43
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    sput-object v0, Lcom/google/appinventor/components/runtime/util/YailNumberToString;->locale:Ljava/util/Locale;

    .line 44
    new-instance v0, Ljava/text/DecimalFormatSymbols;

    sget-object v1, Lcom/google/appinventor/components/runtime/util/YailNumberToString;->locale:Ljava/util/Locale;

    invoke-direct {v0, v1}, Ljava/text/DecimalFormatSymbols;-><init>(Ljava/util/Locale;)V

    sput-object v0, Lcom/google/appinventor/components/runtime/util/YailNumberToString;->symbols:Ljava/text/DecimalFormatSymbols;

    .line 46
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v1, "#####0.0####"

    sget-object v2, Lcom/google/appinventor/components/runtime/util/YailNumberToString;->symbols:Ljava/text/DecimalFormatSymbols;

    invoke-direct {v0, v1, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;Ljava/text/DecimalFormatSymbols;)V

    sput-object v0, Lcom/google/appinventor/components/runtime/util/YailNumberToString;->decimalFormat:Ljava/text/DecimalFormat;

    .line 47
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v1, "0.####E0"

    sget-object v2, Lcom/google/appinventor/components/runtime/util/YailNumberToString;->symbols:Ljava/text/DecimalFormatSymbols;

    invoke-direct {v0, v1, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;Ljava/text/DecimalFormatSymbols;)V

    sput-object v0, Lcom/google/appinventor/components/runtime/util/YailNumberToString;->sciFormat:Ljava/text/DecimalFormat;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static format(D)Ljava/lang/String;
    .locals 4
    .param p0, "number"    # D

    .prologue
    .line 60
    invoke-static {p0, p1}, Ljava/lang/Math;->rint(D)D

    move-result-wide v2

    cmpl-double v2, p0, v2

    if-nez v2, :cond_0

    .line 61
    double-to-int v2, p0

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    .line 67
    :goto_0
    return-object v2

    .line 63
    :cond_0
    invoke-static {p0, p1}, Ljava/lang/Math;->abs(D)D

    move-result-wide v0

    .line 64
    .local v0, "mag":D
    const-wide v2, 0x412e848000000000L    # 1000000.0

    cmpg-double v2, v0, v2

    if-gez v2, :cond_1

    const-wide v2, 0x3eb0c6f7a0b5ed8dL    # 1.0E-6

    cmpl-double v2, v0, v2

    if-lez v2, :cond_1

    .line 65
    sget-object v2, Lcom/google/appinventor/components/runtime/util/YailNumberToString;->decimalFormat:Ljava/text/DecimalFormat;

    invoke-virtual {v2, p0, p1}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 67
    :cond_1
    sget-object v2, Lcom/google/appinventor/components/runtime/util/YailNumberToString;->sciFormat:Ljava/text/DecimalFormat;

    invoke-virtual {v2, p0, p1}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method
