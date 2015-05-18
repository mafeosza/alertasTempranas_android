.class Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount$1;
.super Ljava/lang/Object;
.source "AccountChooser.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;)V
    .locals 0

    .prologue
    .line 191
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount$1;->this$1:Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 194
    new-instance v1, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount$1;->this$1:Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;

    iget-object v2, v2, Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;->this$0:Lcom/google/appinventor/components/runtime/util/AccountChooser;

    # getter for: Lcom/google/appinventor/components/runtime/util/AccountChooser;->activity:Landroid/app/Activity;
    invoke-static {v2}, Lcom/google/appinventor/components/runtime/util/AccountChooser;->access$200(Lcom/google/appinventor/components/runtime/util/AccountChooser;)Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount$1;->this$1:Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;

    iget-object v2, v2, Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;->this$0:Lcom/google/appinventor/components/runtime/util/AccountChooser;

    # getter for: Lcom/google/appinventor/components/runtime/util/AccountChooser;->chooseAccountPrompt:Ljava/lang/String;
    invoke-static {v2}, Lcom/google/appinventor/components/runtime/util/AccountChooser;->access$100(Lcom/google/appinventor/components/runtime/util/AccountChooser;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount$1;->this$1:Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount$1;->this$1:Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;

    # getter for: Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;->accountNames:[Ljava/lang/String;
    invoke-static {v2}, Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;->access$000(Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;)[Ljava/lang/String;

    move-result-object v2

    const/4 v3, -0x1

    iget-object v4, p0, Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount$1;->this$1:Lcom/google/appinventor/components/runtime/util/AccountChooser$SelectAccount;

    invoke-virtual {v1, v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setSingleChoiceItems([Ljava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 198
    .local v0, "ab":Landroid/app/AlertDialog$Builder;
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 199
    const-string v1, "AccountChooser"

    const-string v2, "Dialog showing!"

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 200
    return-void
.end method
