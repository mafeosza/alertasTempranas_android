.class public Lcom/google/appinventor/components/runtime/TimePicker;
.super Lcom/google/appinventor/components/runtime/ButtonBase;
.source "TimePicker.java"


# annotations
.annotation runtime Lcom/google/appinventor/components/annotations/DesignerComponent;
    category = .enum Lcom/google/appinventor/components/common/ComponentCategory;->USERINTERFACE:Lcom/google/appinventor/components/common/ComponentCategory;
    description = "<p>A button that, when clicked on, launches  a popup dialog to allow the user to select a time.</p>"
    version = 0x2
.end annotation

.annotation runtime Lcom/google/appinventor/components/annotations/SimpleObject;
.end annotation


# instance fields
.field private androidUIHandler:Landroid/os/Handler;

.field private customTime:Z

.field private form:Lcom/google/appinventor/components/runtime/Form;

.field private hour:I

.field private minute:I

.field private time:Landroid/app/TimePickerDialog;

.field private timePickerListener:Landroid/app/TimePickerDialog$OnTimeSetListener;


# direct methods
.method public constructor <init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V
    .locals 7
    .param p1, "container"    # Lcom/google/appinventor/components/runtime/ComponentContainer;

    .prologue
    const/4 v5, 0x0

    .line 54
    invoke-direct {p0, p1}, Lcom/google/appinventor/components/runtime/ButtonBase;-><init>(Lcom/google/appinventor/components/runtime/ComponentContainer;)V

    .line 41
    iput v5, p0, Lcom/google/appinventor/components/runtime/TimePicker;->hour:I

    .line 42
    iput v5, p0, Lcom/google/appinventor/components/runtime/TimePicker;->minute:I

    .line 44
    iput-boolean v5, p0, Lcom/google/appinventor/components/runtime/TimePicker;->customTime:Z

    .line 125
    new-instance v0, Lcom/google/appinventor/components/runtime/TimePicker$1;

    invoke-direct {v0, p0}, Lcom/google/appinventor/components/runtime/TimePicker$1;-><init>(Lcom/google/appinventor/components/runtime/TimePicker;)V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->timePickerListener:Landroid/app/TimePickerDialog$OnTimeSetListener;

    .line 55
    invoke-interface {p1}, Lcom/google/appinventor/components/runtime/ComponentContainer;->$form()Lcom/google/appinventor/components/runtime/Form;

    move-result-object v0

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->form:Lcom/google/appinventor/components/runtime/Form;

    .line 56
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v6

    .line 57
    .local v6, "c":Ljava/util/Calendar;
    const/16 v0, 0xb

    invoke-virtual {v6, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    iput v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->hour:I

    .line 58
    const/16 v0, 0xc

    invoke-virtual {v6, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    iput v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->minute:I

    .line 59
    new-instance v0, Landroid/app/TimePickerDialog;

    iget-object v1, p0, Lcom/google/appinventor/components/runtime/TimePicker;->container:Lcom/google/appinventor/components/runtime/ComponentContainer;

    invoke-interface {v1}, Lcom/google/appinventor/components/runtime/ComponentContainer;->$context()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/google/appinventor/components/runtime/TimePicker;->timePickerListener:Landroid/app/TimePickerDialog$OnTimeSetListener;

    iget v3, p0, Lcom/google/appinventor/components/runtime/TimePicker;->hour:I

    iget v4, p0, Lcom/google/appinventor/components/runtime/TimePicker;->minute:I

    invoke-direct/range {v0 .. v5}, Landroid/app/TimePickerDialog;-><init>(Landroid/content/Context;Landroid/app/TimePickerDialog$OnTimeSetListener;IIZ)V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->time:Landroid/app/TimePickerDialog;

    .line 62
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->androidUIHandler:Landroid/os/Handler;

    .line 64
    return-void
.end method

.method static synthetic access$002(Lcom/google/appinventor/components/runtime/TimePicker;I)I
    .locals 0
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/TimePicker;
    .param p1, "x1"    # I

    .prologue
    .line 39
    iput p1, p0, Lcom/google/appinventor/components/runtime/TimePicker;->hour:I

    return p1
.end method

.method static synthetic access$102(Lcom/google/appinventor/components/runtime/TimePicker;I)I
    .locals 0
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/TimePicker;
    .param p1, "x1"    # I

    .prologue
    .line 39
    iput p1, p0, Lcom/google/appinventor/components/runtime/TimePicker;->minute:I

    return p1
.end method

.method static synthetic access$200(Lcom/google/appinventor/components/runtime/TimePicker;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/TimePicker;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->androidUIHandler:Landroid/os/Handler;

    return-object v0
.end method


# virtual methods
.method public AfterTimeSet()V
    .locals 2
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleEvent;
        description = "This event is run when a user has set the time in the popup dialog."
    .end annotation

    .prologue
    .line 150
    const-string v0, "AfterTimeSet"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {p0, v0, v1}, Lcom/google/appinventor/components/runtime/EventDispatcher;->dispatchEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;[Ljava/lang/Object;)Z

    .line 151
    return-void
.end method

.method public Hour()I
    .locals 1
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        category = .enum Lcom/google/appinventor/components/annotations/PropertyCategory;->APPEARANCE:Lcom/google/appinventor/components/annotations/PropertyCategory;
        description = "The hour of the last time set using the time picker. The hour is in a 24 hour format. If the last time set was 11:53 pm, this property will return 23."
    .end annotation

    .prologue
    .line 79
    iget v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->hour:I

    return v0
.end method

.method public LaunchPicker()V
    .locals 0
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleFunction;
        description = "Launches the TimePicker popup."
    .end annotation

    .prologue
    .line 109
    invoke-virtual {p0}, Lcom/google/appinventor/components/runtime/TimePicker;->click()V

    .line 110
    return-void
.end method

.method public Minute()I
    .locals 1
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleProperty;
        category = .enum Lcom/google/appinventor/components/annotations/PropertyCategory;->APPEARANCE:Lcom/google/appinventor/components/annotations/PropertyCategory;
        description = "The minute of the last time set using the time picker"
    .end annotation

    .prologue
    .line 92
    iget v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->minute:I

    return v0
.end method

.method public SetTimeToDisplay(II)V
    .locals 4
    .param p1, "hour"    # I
    .param p2, "minute"    # I
    .annotation runtime Lcom/google/appinventor/components/annotations/SimpleFunction;
        description = "Set the time to be shown in the Time Picker popup. Current time is shown by default."
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 97
    if-ltz p1, :cond_0

    const/16 v0, 0x17

    if-le p1, v0, :cond_1

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->form:Lcom/google/appinventor/components/runtime/Form;

    const-string v1, "SetTimeToDisplay"

    const/16 v2, 0x8fd

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, p0, v1, v2, v3}, Lcom/google/appinventor/components/runtime/Form;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    .line 105
    :goto_0
    return-void

    .line 99
    :cond_1
    if-ltz p2, :cond_2

    const/16 v0, 0x3b

    if-le p2, v0, :cond_3

    .line 100
    :cond_2
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->form:Lcom/google/appinventor/components/runtime/Form;

    const-string v1, "SetTimeToDisplay"

    const/16 v2, 0x8fe

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, p0, v1, v2, v3}, Lcom/google/appinventor/components/runtime/Form;->dispatchErrorOccurredEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;I[Ljava/lang/Object;)V

    goto :goto_0

    .line 102
    :cond_3
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->time:Landroid/app/TimePickerDialog;

    invoke-virtual {v0, p1, p2}, Landroid/app/TimePickerDialog;->updateTime(II)V

    .line 103
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/appinventor/components/runtime/TimePicker;->customTime:Z

    goto :goto_0
.end method

.method public click()V
    .locals 4

    .prologue
    .line 114
    iget-boolean v3, p0, Lcom/google/appinventor/components/runtime/TimePicker;->customTime:Z

    if-nez v3, :cond_0

    .line 115
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 116
    .local v0, "c":Ljava/util/Calendar;
    const/16 v3, 0xb

    invoke-virtual {v0, v3}, Ljava/util/Calendar;->get(I)I

    move-result v1

    .line 117
    .local v1, "h":I
    const/16 v3, 0xc

    invoke-virtual {v0, v3}, Ljava/util/Calendar;->get(I)I

    move-result v2

    .line 118
    .local v2, "m":I
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/TimePicker;->time:Landroid/app/TimePickerDialog;

    invoke-virtual {v3, v1, v2}, Landroid/app/TimePickerDialog;->updateTime(II)V

    .line 122
    .end local v0    # "c":Ljava/util/Calendar;
    .end local v1    # "h":I
    .end local v2    # "m":I
    :goto_0
    iget-object v3, p0, Lcom/google/appinventor/components/runtime/TimePicker;->time:Landroid/app/TimePickerDialog;

    invoke-virtual {v3}, Landroid/app/TimePickerDialog;->show()V

    .line 123
    return-void

    .line 120
    :cond_0
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/google/appinventor/components/runtime/TimePicker;->customTime:Z

    goto :goto_0
.end method
