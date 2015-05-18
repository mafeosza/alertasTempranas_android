.class Lcom/google/appinventor/components/runtime/util/EclairUtil$1$2;
.super Ljava/lang/Object;
.source "EclairUtil.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/util/EclairUtil$1;->onGeolocationPermissionsShowPrompt(Ljava/lang/String;Landroid/webkit/GeolocationPermissions$Callback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/util/EclairUtil$1;

.field final synthetic val$theCallback:Landroid/webkit/GeolocationPermissions$Callback;

.field final synthetic val$theOrigin:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/util/EclairUtil$1;Landroid/webkit/GeolocationPermissions$Callback;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/util/EclairUtil$1$2;->this$0:Lcom/google/appinventor/components/runtime/util/EclairUtil$1;

    iput-object p2, p0, Lcom/google/appinventor/components/runtime/util/EclairUtil$1$2;->val$theCallback:Landroid/webkit/GeolocationPermissions$Callback;

    iput-object p3, p0, Lcom/google/appinventor/components/runtime/util/EclairUtil$1$2;->val$theOrigin:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 81
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/util/EclairUtil$1$2;->val$theCallback:Landroid/webkit/GeolocationPermissions$Callback;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/util/EclairUtil$1$2;->val$theOrigin:Ljava/lang/String;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-interface {v0, v1, v2, v3}, Landroid/webkit/GeolocationPermissions$Callback;->invoke(Ljava/lang/String;ZZ)V

    .line 82
    return-void
.end method
