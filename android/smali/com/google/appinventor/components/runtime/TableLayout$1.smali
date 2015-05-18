.class Lcom/google/appinventor/components/runtime/TableLayout$1;
.super Ljava/lang/Object;
.source "TableLayout.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/TableLayout;->addChildLater(Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/TableLayout;

.field final synthetic val$child:Lcom/google/appinventor/components/runtime/AndroidViewComponent;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/TableLayout;Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V
    .locals 0

    .prologue
    .line 123
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/TableLayout$1;->this$0:Lcom/google/appinventor/components/runtime/TableLayout;

    iput-object p2, p0, Lcom/google/appinventor/components/runtime/TableLayout$1;->val$child:Lcom/google/appinventor/components/runtime/AndroidViewComponent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 125
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TableLayout$1;->this$0:Lcom/google/appinventor/components/runtime/TableLayout;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/TableLayout$1;->val$child:Lcom/google/appinventor/components/runtime/AndroidViewComponent;

    # invokes: Lcom/google/appinventor/components/runtime/TableLayout;->addChild(Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V
    invoke-static {v0, v1}, Lcom/google/appinventor/components/runtime/TableLayout;->access$000(Lcom/google/appinventor/components/runtime/TableLayout;Lcom/google/appinventor/components/runtime/AndroidViewComponent;)V

    .line 126
    return-void
.end method
