.class public Lcom/google/appinventor/components/runtime/util/HoneycombUtil;
.super Ljava/lang/Object;
.source "HoneycombUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    return-void
.end method

.method public static getContactIdIndex(Landroid/database/Cursor;)I
    .locals 1
    .param p0, "contactCursor"    # Landroid/database/Cursor;

    .prologue
    .line 119
    const-string v0, "contact_id"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getContactProjection()[Ljava/lang/String;
    .locals 3

    .prologue
    .line 59
    const/4 v1, 0x4

    new-array v0, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "display_name"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "photo_thumb_uri"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "photo_uri"

    aput-object v2, v0, v1

    .line 65
    .local v0, "contactProjection":[Ljava/lang/String;
    return-object v0
.end method

.method public static getContentUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Landroid/provider/ContactsContract$Contacts;->CONTENT_URI:Landroid/net/Uri;

    return-object v0
.end method

.method public static getDataContentUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 52
    sget-object v0, Landroid/provider/ContactsContract$Data;->CONTENT_URI:Landroid/net/Uri;

    return-object v0
.end method

.method public static getDataCursor(Ljava/lang/String;Landroid/app/Activity;[Ljava/lang/String;)Landroid/database/Cursor;
    .locals 7
    .param p0, "id"    # Ljava/lang/String;
    .param p1, "activityContext"    # Landroid/app/Activity;
    .param p2, "dataProjection"    # [Ljava/lang/String;

    .prologue
    .line 193
    invoke-virtual {p1}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/ContactsContract$Data;->CONTENT_URI:Landroid/net/Uri;

    const-string v3, "contact_id=? AND (mimetype=? OR mimetype=?)"

    const/4 v2, 0x3

    new-array v4, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    aput-object p0, v4, v2

    const/4 v2, 0x1

    const-string v5, "vnd.android.cursor.item/phone_v2"

    aput-object v5, v4, v2

    const/4 v2, 0x2

    const-string v5, "vnd.android.cursor.item/email_v2"

    aput-object v5, v4, v2

    const/4 v5, 0x0

    move-object v2, p2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 199
    .local v6, "dataCursor":Landroid/database/Cursor;
    return-object v6
.end method

.method public static getDataMimeType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 186
    const-string v0, "mimetype"

    return-object v0
.end method

.method public static getDataProjection()[Ljava/lang/String;
    .locals 3

    .prologue
    .line 85
    const/4 v1, 0x5

    new-array v0, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "mimetype"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "data1"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "data2"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "data1"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "data2"

    aput-object v2, v0, v1

    .line 92
    .local v0, "dataProjection":[Ljava/lang/String;
    return-object v0
.end method

.method public static getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 172
    const-string v0, "display_name"

    return-object v0
.end method

.method public static getEmailAdapterProjection()[Ljava/lang/String;
    .locals 3

    .prologue
    .line 99
    const/4 v1, 0x4

    new-array v0, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "display_name"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "data1"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "mimetype"

    aput-object v2, v0, v1

    .line 105
    .local v0, "emailAdapterProjection":[Ljava/lang/String;
    return-object v0
.end method

.method public static getEmailAddress()Ljava/lang/String;
    .locals 1

    .prologue
    .line 179
    const-string v0, "data1"

    return-object v0
.end method

.method public static getEmailIndex(Landroid/database/Cursor;)I
    .locals 1
    .param p0, "dataCursor"    # Landroid/database/Cursor;

    .prologue
    .line 148
    const-string v0, "data1"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getEmailType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 165
    const-string v0, "vnd.android.cursor.item/email_v2"

    return-object v0
.end method

.method public static getIdIndex(Landroid/database/Cursor;)I
    .locals 1
    .param p0, "contactCursor"    # Landroid/database/Cursor;

    .prologue
    .line 112
    const-string v0, "_id"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getMimeIndex(Landroid/database/Cursor;)I
    .locals 1
    .param p0, "dataCursor"    # Landroid/database/Cursor;

    .prologue
    .line 152
    const-string v0, "mimetype"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getNameIndex(Landroid/database/Cursor;)I
    .locals 1
    .param p0, "contactCursor"    # Landroid/database/Cursor;

    .prologue
    .line 126
    const-string v0, "display_name"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getNameProjection()[Ljava/lang/String;
    .locals 3

    .prologue
    .line 72
    const/4 v1, 0x4

    new-array v0, v1, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "contact_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "display_name"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "photo_thumb_uri"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "data1"

    aput-object v2, v0, v1

    .line 78
    .local v0, "nameProjection":[Ljava/lang/String;
    return-object v0
.end method

.method public static getPhoneContentUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 45
    sget-object v0, Landroid/provider/ContactsContract$CommonDataKinds$Phone;->CONTENT_URI:Landroid/net/Uri;

    return-object v0
.end method

.method public static getPhoneIndex(Landroid/database/Cursor;)I
    .locals 1
    .param p0, "dataCursor"    # Landroid/database/Cursor;

    .prologue
    .line 144
    const-string v0, "data1"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getPhoneType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    const-string v0, "vnd.android.cursor.item/phone_v2"

    return-object v0
.end method

.method public static getPhotoIndex(Landroid/database/Cursor;)I
    .locals 1
    .param p0, "contactCursor"    # Landroid/database/Cursor;

    .prologue
    .line 140
    const-string v0, "photo_uri"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getThumbnailIndex(Landroid/database/Cursor;)I
    .locals 1
    .param p0, "contactCursor"    # Landroid/database/Cursor;

    .prologue
    .line 133
    const-string v0, "photo_thumb_uri"

    invoke-interface {p0, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public static getTimesContacted()Ljava/lang/String;
    .locals 1

    .prologue
    .line 213
    const-string v0, "times_contacted"

    return-object v0
.end method

.method public static openContactPhotoInputStreamHelper(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/io/InputStream;
    .locals 1
    .param p0, "cr"    # Landroid/content/ContentResolver;
    .param p1, "contactUri"    # Landroid/net/Uri;

    .prologue
    .line 206
    invoke-static {p0, p1}, Landroid/provider/ContactsContract$Contacts;->openContactPhotoInputStream(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v0

    return-object v0
.end method
