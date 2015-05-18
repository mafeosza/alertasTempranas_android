.class final enum Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;
.super Ljava/lang/Enum;
.source "NxtTouchSensor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/appinventor/components/runtime/NxtTouchSensor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

.field public static final enum PRESSED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

.field public static final enum RELEASED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

.field public static final enum UNKNOWN:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 37
    new-instance v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v2}, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->UNKNOWN:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    new-instance v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    const-string v1, "PRESSED"

    invoke-direct {v0, v1, v3}, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->PRESSED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    new-instance v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    const-string v1, "RELEASED"

    invoke-direct {v0, v1, v4}, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->RELEASED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    sget-object v1, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->UNKNOWN:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    aput-object v1, v0, v2

    sget-object v1, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->PRESSED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    aput-object v1, v0, v3

    sget-object v1, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->RELEASED:Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    aput-object v1, v0, v4

    sput-object v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->$VALUES:[Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 37
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 37
    const-class v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    return-object v0
.end method

.method public static values()[Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->$VALUES:[Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    invoke-virtual {v0}, [Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/google/appinventor/components/runtime/NxtTouchSensor$State;

    return-object v0
.end method
