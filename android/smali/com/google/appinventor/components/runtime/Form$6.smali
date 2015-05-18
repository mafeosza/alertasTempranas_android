.class Lcom/google/appinventor/components/runtime/Form$6;
.super Ljava/lang/Object;
.source "Form.java"

# interfaces
.implements Landroid/view/MenuItem$OnMenuItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/Form;->addAboutInfoToMenu(Landroid/view/Menu;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/Form;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/Form;)V
    .locals 0

    .prologue
    .line 1389
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/Form$6;->this$0:Lcom/google/appinventor/components/runtime/Form;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 1391
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/Form$6;->this$0:Lcom/google/appinventor/components/runtime/Form;

    # invokes: Lcom/google/appinventor/components/runtime/Form;->showAboutApplicationNotification()V
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/Form;->access$500(Lcom/google/appinventor/components/runtime/Form;)V

    .line 1392
    const/4 v0, 0x1

    return v0
.end method
