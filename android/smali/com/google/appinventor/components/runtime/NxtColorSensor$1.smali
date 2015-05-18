.class Lcom/google/appinventor/components/runtime/NxtColorSensor$1;
.super Ljava/lang/Object;
.source "NxtColorSensor.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/appinventor/components/runtime/NxtColorSensor;-><init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/NxtColorSensor;)V
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 97
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    iget-object v3, v3, Lcom/google/appinventor/components/runtime/NxtColorSensor;->bluetooth:Lcom/google/appinventor/components/runtime/BluetoothClient;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    iget-object v3, v3, Lcom/google/appinventor/components/runtime/NxtColorSensor;->bluetooth:Lcom/google/appinventor/components/runtime/BluetoothClient;

    invoke-virtual {v3}, Lcom/google/appinventor/components/runtime/BluetoothClient;->IsConnected()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 98
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->detectColor:Z
    invoke-static {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$000(Lcom/google/appinventor/components/runtime/NxtColorSensor;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 100
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    const-string v4, ""

    # invokes: Lcom/google/appinventor/components/runtime/NxtColorSensor;->getColorValue(Ljava/lang/String;)Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;
    invoke-static {v3, v4}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$100(Lcom/google/appinventor/components/runtime/NxtColorSensor;Ljava/lang/String;)Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;

    move-result-object v2

    .line 101
    .local v2, "sensorValue":Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;, "Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue<Ljava/lang/Integer;>;"
    iget-boolean v3, v2, Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;->valid:Z

    if-eqz v3, :cond_1

    .line 102
    iget-object v3, v2, Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;->value:Ljava/lang/Object;

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 104
    .local v0, "currentColor":I
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->previousColor:I
    invoke-static {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$200(Lcom/google/appinventor/components/runtime/NxtColorSensor;)I

    move-result v3

    if-eq v0, v3, :cond_0

    .line 105
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    invoke-virtual {v3, v0}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->ColorChanged(I)V

    .line 108
    :cond_0
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # setter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->previousColor:I
    invoke-static {v3, v0}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$202(Lcom/google/appinventor/components/runtime/NxtColorSensor;I)I

    .line 140
    .end local v0    # "currentColor":I
    .end local v2    # "sensorValue":Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;, "Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue<Ljava/lang/Integer;>;"
    :cond_1
    :goto_0
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # invokes: Lcom/google/appinventor/components/runtime/NxtColorSensor;->isHandlerNeeded()Z
    invoke-static {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$1000(Lcom/google/appinventor/components/runtime/NxtColorSensor;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 141
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->handler:Landroid/os/Handler;
    invoke-static {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$1200(Lcom/google/appinventor/components/runtime/NxtColorSensor;)Landroid/os/Handler;

    move-result-object v3

    iget-object v4, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->sensorReader:Ljava/lang/Runnable;
    invoke-static {v4}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$1100(Lcom/google/appinventor/components/runtime/NxtColorSensor;)Ljava/lang/Runnable;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 143
    :cond_2
    return-void

    .line 113
    :cond_3
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    const-string v4, ""

    # invokes: Lcom/google/appinventor/components/runtime/NxtColorSensor;->getLightValue(Ljava/lang/String;)Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;
    invoke-static {v3, v4}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$300(Lcom/google/appinventor/components/runtime/NxtColorSensor;Ljava/lang/String;)Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;

    move-result-object v2

    .line 114
    .restart local v2    # "sensorValue":Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;, "Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue<Ljava/lang/Integer;>;"
    iget-boolean v3, v2, Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;->valid:Z

    if-eqz v3, :cond_1

    .line 116
    iget-object v3, v2, Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;->value:Ljava/lang/Object;

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iget-object v4, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->bottomOfRange:I
    invoke-static {v4}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$400(Lcom/google/appinventor/components/runtime/NxtColorSensor;)I

    move-result v4

    if-ge v3, v4, :cond_7

    .line 117
    sget-object v1, Lcom/google/appinventor/components/runtime/NxtColorSensor$State;->BELOW_RANGE:Lcom/google/appinventor/components/runtime/NxtColorSensor$State;

    .line 124
    .local v1, "currentState":Lcom/google/appinventor/components/runtime/NxtColorSensor$State;
    :goto_1
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->previousState:Lcom/google/appinventor/components/runtime/NxtColorSensor$State;
    invoke-static {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$600(Lcom/google/appinventor/components/runtime/NxtColorSensor;)Lcom/google/appinventor/components/runtime/NxtColorSensor$State;

    move-result-object v3

    if-eq v1, v3, :cond_6

    .line 125
    sget-object v3, Lcom/google/appinventor/components/runtime/NxtColorSensor$State;->BELOW_RANGE:Lcom/google/appinventor/components/runtime/NxtColorSensor$State;

    if-ne v1, v3, :cond_4

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->belowRangeEventEnabled:Z
    invoke-static {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$700(Lcom/google/appinventor/components/runtime/NxtColorSensor;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 126
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    invoke-virtual {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->BelowRange()V

    .line 128
    :cond_4
    sget-object v3, Lcom/google/appinventor/components/runtime/NxtColorSensor$State;->WITHIN_RANGE:Lcom/google/appinventor/components/runtime/NxtColorSensor$State;

    if-ne v1, v3, :cond_5

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->withinRangeEventEnabled:Z
    invoke-static {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$800(Lcom/google/appinventor/components/runtime/NxtColorSensor;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 129
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    invoke-virtual {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->WithinRange()V

    .line 131
    :cond_5
    sget-object v3, Lcom/google/appinventor/components/runtime/NxtColorSensor$State;->ABOVE_RANGE:Lcom/google/appinventor/components/runtime/NxtColorSensor$State;

    if-ne v1, v3, :cond_6

    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->aboveRangeEventEnabled:Z
    invoke-static {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$900(Lcom/google/appinventor/components/runtime/NxtColorSensor;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 132
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    invoke-virtual {v3}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->AboveRange()V

    .line 136
    :cond_6
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # setter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->previousState:Lcom/google/appinventor/components/runtime/NxtColorSensor$State;
    invoke-static {v3, v1}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$602(Lcom/google/appinventor/components/runtime/NxtColorSensor;Lcom/google/appinventor/components/runtime/NxtColorSensor$State;)Lcom/google/appinventor/components/runtime/NxtColorSensor$State;

    goto :goto_0

    .line 118
    .end local v1    # "currentState":Lcom/google/appinventor/components/runtime/NxtColorSensor$State;
    :cond_7
    iget-object v3, v2, Lcom/google/appinventor/components/runtime/LegoMindstormsNxtSensor$SensorValue;->value:Ljava/lang/Object;

    check-cast v3, Ljava/lang/Integer;

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    iget-object v4, p0, Lcom/google/appinventor/components/runtime/NxtColorSensor$1;->this$0:Lcom/google/appinventor/components/runtime/NxtColorSensor;

    # getter for: Lcom/google/appinventor/components/runtime/NxtColorSensor;->topOfRange:I
    invoke-static {v4}, Lcom/google/appinventor/components/runtime/NxtColorSensor;->access$500(Lcom/google/appinventor/components/runtime/NxtColorSensor;)I

    move-result v4

    if-le v3, v4, :cond_8

    .line 119
    sget-object v1, Lcom/google/appinventor/components/runtime/NxtColorSensor$State;->ABOVE_RANGE:Lcom/google/appinventor/components/runtime/NxtColorSensor$State;

    .restart local v1    # "currentState":Lcom/google/appinventor/components/runtime/NxtColorSensor$State;
    goto :goto_1

    .line 121
    .end local v1    # "currentState":Lcom/google/appinventor/components/runtime/NxtColorSensor$State;
    :cond_8
    sget-object v1, Lcom/google/appinventor/components/runtime/NxtColorSensor$State;->WITHIN_RANGE:Lcom/google/appinventor/components/runtime/NxtColorSensor$State;

    .restart local v1    # "currentState":Lcom/google/appinventor/components/runtime/NxtColorSensor$State;
    goto :goto_1
.end method
