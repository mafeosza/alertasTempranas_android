.class Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;
.super Ljava/lang/Object;
.source "NxtTouchSensor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/NxtTouchSensor;-><init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/NxtTouchSensor;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 55
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    iget-object v2, v2, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->bluetooth:Lcom/google/appinventor/components/runtime/BluetoothClient;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    iget-object v2, v2, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->bluetooth:Lcom/google/appinventor/components/runtime/BluetoothClient;

    invoke-virtual {v2}, Lcom/google/appinventor/components/runtime/BluetoothClient;->IsConnected()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 56
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    const-string v3, ""

    # invokes: Lcom/google/appinventor/components/runtime/NxtTouchSensor;->getPressedValue(Ljava/lang/String;)Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;
    invoke-static {v2, v3}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->access$000(Lcom/google/appinventor/components/runtime/NxtTouchSensor;Ljava/lang/String;)Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;

    move-result-object v1

    .line 57
    .local v1, "sensorValue":Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;, "Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue<Ljava/lang/Boolean;>;"
    iget-boolean v2, v1, Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;->valid:Z

    if-eqz v2, :cond_2

    .line 58
    iget-object v2, v1, Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;->value:Ljava/lang/Object;

    check-cast v2, Ljava/lang/Boolean;

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_4

    sget-object v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->PRESSED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    .line 60
    .local v0, "currentState":Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;
    :goto_0
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtTouchSensor;->previousState:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;
    invoke-static {v2}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->access$100(Lcom/google/appinventor/components/runtime/NxtTouchSensor;)Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    move-result-object v2

    if-eq v0, v2, :cond_1

    .line 61
    sget-object v2, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->PRESSED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    if-ne v0, v2, :cond_0

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtTouchSensor;->pressedEventEnabled:Z
    invoke-static {v2}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->access$200(Lcom/google/appinventor/components/runtime/NxtTouchSensor;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 62
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    invoke-virtual {v2}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->Pressed()V

    .line 64
    :cond_0
    sget-object v2, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->RELEASED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    if-ne v0, v2, :cond_1

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtTouchSensor;->releasedEventEnabled:Z
    invoke-static {v2}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->access$300(Lcom/google/appinventor/components/runtime/NxtTouchSensor;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 65
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    invoke-virtual {v2}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->Released()V

    .line 69
    :cond_1
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    # setter for: Lcom/google/appinventor/components/runtime/NxtTouchSensor;->previousState:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;
    invoke-static {v2, v0}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->access$102(Lcom/google/appinventor/components/runtime/NxtTouchSensor;Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;)Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    .line 72
    .end local v0    # "currentState":Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;
    .end local v1    # "sensorValue":Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;, "Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue<Ljava/lang/Boolean;>;"
    :cond_2
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    # invokes: Lcom/google/appinventor/components/runtime/NxtTouchSensor;->isHandlerNeeded()Z
    invoke-static {v2}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->access$400(Lcom/google/appinventor/components/runtime/NxtTouchSensor;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 73
    iget-object v2, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtTouchSensor;->handler:Landroid/os/Handler;
    invoke-static {v2}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->access$600(Lcom/google/appinventor/components/runtime/NxtTouchSensor;)Landroid/os/Handler;

    move-result-object v2

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtTouchSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtTouchSensor;->sensorReader:Ljava/lang/Runnable;
    invoke-static {v3}, Lcom/google/appinventor/components/runtime/NxtTouchSensor;->access$500(Lcom/google/appinventor/components/runtime/NxtTouchSensor;)Ljava/lang/Runnable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 75
    :cond_3
    return-void

    .line 58
    .restart local v1    # "sensorValue":Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;, "Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue<Ljava/lang/Boolean;>;"
    :cond_4
    sget-object v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->RELEASED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    goto :goto_0
.end method
