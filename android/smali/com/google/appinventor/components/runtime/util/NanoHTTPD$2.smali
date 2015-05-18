.class Lcom/google/appinventor/components/runtime/util/NanoHTTPD$2;
.super Ljava/io/FileInputStream;
.source "NanoHTTPD.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/util/NanoHTTPD;->serveFile(Ljava/lang/String;Ljava/util/Properties;Ljava/io/File;Z)Lcom/google/appinventor/components/runtime/util/NanoHTTPD$Response;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/util/NanoHTTPD;

.field final synthetic val$dataLen:J


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/util/NanoHTTPD;Ljava/io/File;J)V
    .locals 0
    .param p2, "x0"    # Ljava/io/File;

    .prologue
    .line 1044
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$2;->this$0:Lcom/google/appinventor/components/runtime/util/NanoHTTPD;

    iput-wide p3, p0, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$2;->val$dataLen:J

    invoke-direct {p0, p2}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    return-void
.end method


# virtual methods
.method public available()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1045
    iget-wide v0, p0, Lcom/google/appinventor/components/runtime/util/NanoHTTPD$2;->val$dataLen:J

    long-to-int v0, v0

    return v0
.end method
