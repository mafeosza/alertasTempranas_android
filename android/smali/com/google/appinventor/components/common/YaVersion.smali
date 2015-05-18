.class public Lcom/google/appinventor/components/common/YaVersion;
.super Ljava/lang/Object;
.source "YaVersion.java"


# static fields
.field public static final ACCELEROMETERSENSOR_COMPONENT_VERSION:I = 0x3

.field public static final ACCEPTABLE_COMPANIONS:[Ljava/lang/String;

.field public static final ACTIVITYSTARTER_COMPONENT_VERSION:I = 0x4

.field public static final BALL_COMPONENT_VERSION:I = 0x5

.field public static final BARCODESCANNER_COMPONENT_VERSION:I = 0x2

.field public static final BLOCKS_LANGUAGE_VERSION:I = 0x12

.field public static final BLUETOOTHCLIENT_COMPONENT_VERSION:I = 0x5

.field public static final BLUETOOTHSERVER_COMPONENT_VERSION:I = 0x5

.field public static final BUTTON_COMPONENT_VERSION:I = 0x6

.field public static final CAMCORDER_COMPONENT_VERSION:I = 0x1

.field public static final CAMERA_COMPONENT_VERSION:I = 0x2

.field public static final CANVAS_COMPONENT_VERSION:I = 0xa

.field public static final CHECKBOX_COMPONENT_VERSION:I = 0x2

.field public static final CLOCK_COMPONENT_VERSION:I = 0x1

.field public static final COMPANION_UPDATE_URL:Ljava/lang/String; = "/companions/MITAI2Companion.asc"

.field public static final COMPANION_UPDATE_URL1:Ljava/lang/String; = "/companions/MITAI2Companion.apk"

.field public static final CONTACTPICKER_COMPONENT_VERSION:I = 0x5

.field public static final DATEPICKER_COMPONENT_VERSION:I = 0x2

.field public static final EMAILPICKER_COMPONENT_VERSION:I = 0x3

.field public static final FILE_COMPONENT_VERSION:I = 0x1

.field public static final FORM_COMPONENT_VERSION:I = 0xe

.field public static final FUSIONTABLESCONTROL_COMPONENT_VERSION:I = 0x3

.field public static final GAMECLIENT_COMPONENT_VERSION:I = 0x1

.field public static final HORIZONTALARRANGEMENT_COMPONENT_VERSION:I = 0x2

.field public static final IMAGEPICKER_COMPONENT_VERSION:I = 0x5

.field public static final IMAGESPRITE_COMPONENT_VERSION:I = 0x6

.field public static final IMAGE_COMPONENT_VERSION:I = 0x1

.field public static final LABEL_COMPONENT_VERSION:I = 0x3

.field public static final LISTPICKER_COMPONENT_VERSION:I = 0x9

.field public static final LISTVIEW_COMPONENT_VERSION:I = 0x4

.field public static final LOCATIONSENSOR_COMPONENT_VERSION:I = 0x2

.field public static final NEARFIELD_COMPONENT_VERSION:I = 0x1

.field public static final NOTIFIER_COMPONENT_VERSION:I = 0x4

.field public static final NXT_COLORSENSOR_COMPONENT_VERSION:I = 0x1

.field public static final NXT_DIRECT_COMMANDS_COMPONENT_VERSION:I = 0x1

.field public static final NXT_DRIVE_COMPONENT_VERSION:I = 0x1

.field public static final NXT_LIGHTSENSOR_COMPONENT_VERSION:I = 0x1

.field public static final NXT_SOUNDSENSOR_COMPONENT_VERSION:I = 0x1

.field public static final NXT_TOUCHSENSOR_COMPONENT_VERSION:I = 0x1

.field public static final NXT_ULTRASONICSENSOR_COMPONENT_VERSION:I = 0x1

.field public static final ORIENTATIONSENSOR_COMPONENT_VERSION:I = 0x2

.field public static final PASSWORDTEXTBOX_COMPONENT_VERSION:I = 0x3

.field public static final PEDOMETER_COMPONENT_VERSION:I = 0x1

.field public static final PHONECALL_COMPONENT_VERSION:I = 0x2

.field public static final PHONENUMBERPICKER_COMPONENT_VERSION:I = 0x4

.field public static final PHONESTATUS_COMPONENT_VERSION:I = 0x1

.field public static final PLAYER_COMPONENT_VERSION:I = 0x6

.field public static final PREFERRED_COMPANION:Ljava/lang/String; = "2.26 or 2.27"

.field public static final PROXIMITYSENSOR_COMPONENT_VERSION:I = 0x1

.field public static final RENDEZVOUS_SERVER:Ljava/lang/String; = "rendezvous.appinventor.mit.edu"

.field public static final SHARING_COMPONENT_VERSION:I = 0x1

.field public static final SLIDER_COMPONENT_VERSION:I = 0x2

.field public static final SOUND_COMPONENT_VERSION:I = 0x3

.field public static final SOUND_RECORDER_COMPONENT_VERSION:I = 0x2

.field public static final SPEECHRECOGNIZER_COMPONENT_VERSION:I = 0x1

.field public static final SPINNER_COMPONENT_VERSION:I = 0x1

.field public static final SPLASH_SURVEY:I = 0x1

.field public static final TABLEARRANGEMENT_COMPONENT_VERSION:I = 0x1

.field public static final TEXTBOX_COMPONENT_VERSION:I = 0x5

.field public static final TEXTING_COMPONENT_VERSION:I = 0x3

.field public static final TEXTTOSPEECH_COMPONENT_VERSION:I = 0x3

.field public static final TIMEPICKER_COMPONENT_VERSION:I = 0x2

.field public static final TINYDB_COMPONENT_VERSION:I = 0x1

.field public static final TINYWEBDB_COMPONENT_VERSION:I = 0x2

.field public static final TWITTER_COMPONENT_VERSION:I = 0x4

.field public static final VERTICALARRANGEMENT_COMPONENT_VERSION:I = 0x2

.field public static final VIDEOPLAYER_COMPONENT_VERSION:I = 0x5

.field public static final VOTING_COMPONENT_VERSION:I = 0x1

.field public static final WEBVIEWER_COMPONENT_VERSION:I = 0x6

.field public static final WEB_COMPONENT_VERSION:I = 0x4

.field public static final YANDEX_COMPONENT_VERSION:I = 0x1

.field public static final YOUNG_ANDROID_VERSION:I = 0x7b


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 910
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "2.24"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "2.24a"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "2.25"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "2.26"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "2.27"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/appinventor/components/common/YaVersion;->ACCEPTABLE_COMPANIONS:[Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    return-void
.end method
