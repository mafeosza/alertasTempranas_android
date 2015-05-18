.class Lcom/google/appinventor/components/runtime/TimePicker$1;
.super Ljava/lang/Object;
.source "TimePicker.java"

# interfaces
.implements Landroid/app/TimePickerDialog$OnTimeSetListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/appinventor/components/runtime/TimePicker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/TimePicker;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/TimePicker;)V
    .locals 0

    .prologue
    .line 126
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/TimePicker$1;->this$0:Lcom/google/appinventor/components/runtime/TimePicker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTimeSet(Landroid/widget/TimePicker;II)V
    .locals 2
    .param p1, "view"    # Landroid/widget/TimePicker;
    .param p2, "selectedHour"    # I
    .param p3, "selectedMinute"    # I

    .prologue
    .line 129
    invoke-virtual {p1}, Landroid/widget/TimePicker;->isShown()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker$1;->this$0:Lcom/google/appinventor/components/runtime/TimePicker;

    # setter for: Lcom/google/appinventor/components/runtime/TimePicker;->hour:I
    invoke-static {v0, p2}, Lcom/google/appinventor/components/runtime/TimePicker;->access$002(Lcom/google/appinventor/components/runtime/TimePicker;I)I

    .line 131
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker$1;->this$0:Lcom/google/appinventor/components/runtime/TimePicker;

    # setter for: Lcom/google/appinventor/components/runtime/TimePicker;->minute:I
    invoke-static {v0, p3}, Lcom/google/appinventor/components/runtime/TimePicker;->access$102(Lcom/google/appinventor/components/runtime/TimePicker;I)I

    .line 136
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker$1;->this$0:Lcom/google/appinventor/components/runtime/TimePicker;

    # getter for: Lcom/google/appinventor/components/runtime/TimePicker;->androidUIHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/TimePicker;->access$200(Lcom/google/appinventor/components/runtime/TimePicker;)Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/google/appinventor/components/runtime/TimePicker$1$1;

    invoke-direct {v1, p0}, Lcom/google/appinventor/components/runtime/TimePicker$1$1;-><init>(Lcom/google/appinventor/components/runtime/TimePicker$1;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 142
    :cond_0
    return-void
.end method
