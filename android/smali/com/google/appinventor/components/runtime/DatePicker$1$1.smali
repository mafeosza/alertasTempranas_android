.class Lcom/google/appinventor/components/runtime/DatePicker$1$1;
.super Ljava/lang/Object;
.source "DatePicker.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/DatePicker$1;->onDateSet(Landroid/widget/DatePicker;III)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/google/appinventor/components/runtime/DatePicker$1;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/DatePicker$1;)V
    .locals 0

    .prologue
    .line 164
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/DatePicker$1$1;->this$1:Lcom/google/appinventor/components/runtime/DatePicker$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/DatePicker$1$1;->this$1:Lcom/google/appinventor/components/runtime/DatePicker$1;

    iget-object v0, v0, Lcom/google/appinventor/components/runtime/DatePicker$1;->this$0:Lcom/google/appinventor/components/runtime/DatePicker;

    invoke-virtual {v0}, Lcom/google/appinventor/components/runtime/DatePicker;->AfterDateSet()V

    .line 167
    return-void
.end method
