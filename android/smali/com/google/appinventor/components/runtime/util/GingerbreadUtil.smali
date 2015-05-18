.class public Lcom/google/appinventor/components/runtime/util/GingerbreadUtil;
.super Ljava/lang/Object;
.source "GingerbreadUtil.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    return-void
.end method

.method public static clearCookies(Ljava/net/CookieHandler;)Z
    .locals 3
    .param p0, "cookieHandler"    # Ljava/net/CookieHandler;

    .prologue
    .line 55
    instance-of v2, p0, Ljava/net/CookieManager;

    if-eqz v2, :cond_0

    move-object v0, p0

    .line 56
    check-cast v0, Ljava/net/CookieManager;

    .line 57
    .local v0, "cookieManager":Ljava/net/CookieManager;
    invoke-virtual {v0}, Ljava/net/CookieManager;->getCookieStore()Ljava/net/CookieStore;

    move-result-object v1

    .line 58
    .local v1, "cookieStore":Ljava/net/CookieStore;
    if-eqz v1, :cond_0

    .line 59
    invoke-interface {v1}, Ljava/net/CookieStore;->removeAll()Z

    .line 60
    const/4 v2, 0x1

    .line 63
    .end local v0    # "cookieManager":Ljava/net/CookieManager;
    .end local v1    # "cookieStore":Ljava/net/CookieStore;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static createTextRecord(Ljava/lang/String;Z)Landroid/nfc/NdefRecord;
    .locals 11
    .param p0, "payload"    # Ljava/lang/String;
    .param p1, "encodeInUtf8"    # Z

    .prologue
    const/4 v10, 0x1

    const/4 v7, 0x0

    .line 84
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v8

    invoke-virtual {v8}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v8

    const-string v9, "US-ASCII"

    invoke-static {v9}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v1

    .line 85
    .local v1, "langBytes":[B
    if-eqz p1, :cond_0

    const-string v8, "UTF-8"

    invoke-static {v8}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v6

    .line 86
    .local v6, "utfEncoding":Ljava/nio/charset/Charset;
    :goto_0
    invoke-virtual {p0, v6}, Ljava/lang/String;->getBytes(Ljava/nio/charset/Charset;)[B

    move-result-object v4

    .line 87
    .local v4, "textBytes":[B
    if-eqz p1, :cond_1

    move v5, v7

    .line 88
    .local v5, "utfBit":I
    :goto_1
    array-length v8, v1

    add-int/2addr v8, v5

    int-to-char v3, v8

    .line 89
    .local v3, "status":C
    array-length v8, v1

    add-int/lit8 v8, v8, 0x1

    array-length v9, v4

    add-int/2addr v8, v9

    new-array v0, v8, [B

    .line 90
    .local v0, "data":[B
    int-to-byte v8, v3

    aput-byte v8, v0, v7

    .line 91
    array-length v8, v1

    invoke-static {v1, v7, v0, v10, v8}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 92
    array-length v8, v1

    add-int/lit8 v8, v8, 0x1

    array-length v9, v4

    invoke-static {v4, v7, v0, v8, v9}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 93
    new-instance v2, Landroid/nfc/NdefRecord;

    sget-object v8, Landroid/nfc/NdefRecord;->RTD_TEXT:[B

    new-array v7, v7, [B

    invoke-direct {v2, v10, v8, v7, v0}, Landroid/nfc/NdefRecord;-><init>(S[B[B[B)V

    .line 95
    .local v2, "record":Landroid/nfc/NdefRecord;
    return-object v2

    .line 85
    .end local v0    # "data":[B
    .end local v2    # "record":Landroid/nfc/NdefRecord;
    .end local v3    # "status":C
    .end local v4    # "textBytes":[B
    .end local v5    # "utfBit":I
    .end local v6    # "utfEncoding":Ljava/nio/charset/Charset;
    :cond_0
    const-string v8, "UTF-16"

    invoke-static {v8}, Ljava/nio/charset/Charset;->forName(Ljava/lang/String;)Ljava/nio/charset/Charset;

    move-result-object v6

    goto :goto_0

    .line 87
    .restart local v4    # "textBytes":[B
    .restart local v6    # "utfEncoding":Ljava/nio/charset/Charset;
    :cond_1
    const/16 v5, 0x80

    goto :goto_1
.end method

.method public static disableNFCAdapter(Landroid/app/Activity;Landroid/nfc/NfcAdapter;)V
    .locals 0
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "nfcAdapter"    # Landroid/nfc/NfcAdapter;

    .prologue
    .line 80
    invoke-virtual {p1, p0}, Landroid/nfc/NfcAdapter;->disableForegroundNdefPush(Landroid/app/Activity;)V

    .line 81
    return-void
.end method

.method public static enableNFCWriteMode(Landroid/app/Activity;Landroid/nfc/NfcAdapter;Ljava/lang/String;)V
    .locals 4
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "nfcAdapter"    # Landroid/nfc/NfcAdapter;
    .param p2, "textToWrite"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 74
    invoke-static {p2, v2}, Lcom/google/appinventor/components/runtime/util/GingerbreadUtil;->createTextRecord(Ljava/lang/String;Z)Landroid/nfc/NdefRecord;

    move-result-object v1

    .line 75
    .local v1, "textRecord":Landroid/nfc/NdefRecord;
    new-instance v0, Landroid/nfc/NdefMessage;

    new-array v2, v2, [Landroid/nfc/NdefRecord;

    const/4 v3, 0x0

    aput-object v1, v2, v3

    invoke-direct {v0, v2}, Landroid/nfc/NdefMessage;-><init>([Landroid/nfc/NdefRecord;)V

    .line 76
    .local v0, "msg":Landroid/nfc/NdefMessage;
    invoke-virtual {p1, p0, v0}, Landroid/nfc/NfcAdapter;->enableForegroundNdefPush(Landroid/app/Activity;Landroid/nfc/NdefMessage;)V

    .line 77
    return-void
.end method

.method public static newCookieManager()Ljava/net/CookieHandler;
    .locals 1

    .prologue
    .line 44
    new-instance v0, Ljava/net/CookieManager;

    invoke-direct {v0}, Ljava/net/CookieManager;-><init>()V

    return-object v0
.end method

.method public static newNfcAdapter(Landroid/content/Context;)Landroid/nfc/NfcAdapter;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 70
    invoke-static {p0}, Landroid/nfc/NfcAdapter;->getDefaultAdapter(Landroid/content/Context;)Landroid/nfc/NfcAdapter;

    move-result-object v0

    return-object v0
.end method

.method public static resolveNFCIntent(Landroid/content/Intent;Lcom/google/appinventor/components/runtime/NearField;)V
    .locals 14
    .param p0, "intent"    # Landroid/content/Intent;
    .param p1, "nfc"    # Lcom/google/appinventor/components/runtime/NearField;

    .prologue
    const/4 v13, 0x1

    const/4 v12, 0x0

    .line 99
    invoke-virtual {p0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 101
    .local v0, "action":Ljava/lang/String;
    const-string v11, "android.nfc.action.NDEF_DISCOVERED"

    invoke-virtual {v11, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_5

    .line 109
    invoke-virtual {p1}, Lcom/google/appinventor/components/runtime/NearField;->ReadMode()Z

    move-result v11

    if-eqz v11, :cond_3

    .line 111
    const-string v11, "android.nfc.extra.NDEF_MESSAGES"

    invoke-virtual {p0, v11}, Landroid/content/Intent;->getParcelableArrayExtra(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object v8

    .line 113
    .local v8, "rawMsgs":[Landroid/os/Parcelable;
    if-eqz v8, :cond_0

    .line 114
    array-length v11, v8

    new-array v6, v11, [Landroid/nfc/NdefMessage;

    .line 115
    .local v6, "msgs":[Landroid/nfc/NdefMessage;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v11, v8

    if-ge v3, v11, :cond_1

    .line 116
    aget-object v11, v8, v3

    check-cast v11, Landroid/nfc/NdefMessage;

    aput-object v11, v6, v3

    .line 115
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 122
    .end local v3    # "i":I
    .end local v6    # "msgs":[Landroid/nfc/NdefMessage;
    :cond_0
    new-array v2, v12, [B

    .line 123
    .local v2, "empty":[B
    new-instance v9, Landroid/nfc/NdefRecord;

    const/4 v11, 0x5

    invoke-direct {v9, v11, v2, v2, v2}, Landroid/nfc/NdefRecord;-><init>(S[B[B[B)V

    .line 124
    .local v9, "record":Landroid/nfc/NdefRecord;
    new-instance v5, Landroid/nfc/NdefMessage;

    new-array v11, v13, [Landroid/nfc/NdefRecord;

    aput-object v9, v11, v12

    invoke-direct {v5, v11}, Landroid/nfc/NdefMessage;-><init>([Landroid/nfc/NdefRecord;)V

    .line 125
    .local v5, "msg":Landroid/nfc/NdefMessage;
    new-array v6, v13, [Landroid/nfc/NdefMessage;

    aput-object v5, v6, v12

    .line 127
    .end local v2    # "empty":[B
    .end local v5    # "msg":Landroid/nfc/NdefMessage;
    .end local v9    # "record":Landroid/nfc/NdefRecord;
    .restart local v6    # "msgs":[Landroid/nfc/NdefMessage;
    :cond_1
    aget-object v11, v6, v12

    invoke-virtual {v11}, Landroid/nfc/NdefMessage;->getRecords()[Landroid/nfc/NdefRecord;

    move-result-object v11

    aget-object v11, v11, v12

    invoke-virtual {v11}, Landroid/nfc/NdefRecord;->getPayload()[B

    move-result-object v7

    .line 129
    .local v7, "payload":[B
    new-instance v11, Ljava/lang/String;

    invoke-direct {v11, v7}, Ljava/lang/String;-><init>([B)V

    const/4 v12, 0x3

    invoke-virtual {v11, v12}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    .line 130
    .local v4, "message":Ljava/lang/String;
    invoke-virtual {p1, v4}, Lcom/google/appinventor/components/runtime/NearField;->TagRead(Ljava/lang/String;)V

    .line 145
    .end local v4    # "message":Ljava/lang/String;
    .end local v6    # "msgs":[Landroid/nfc/NdefMessage;
    .end local v7    # "payload":[B
    .end local v8    # "rawMsgs":[Landroid/os/Parcelable;
    :cond_2
    :goto_1
    return-void

    .line 132
    :cond_3
    const-string v11, "android.nfc.extra.TAG"

    invoke-virtual {p0, v11}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/nfc/Tag;

    .line 133
    .local v1, "detectedTag":Landroid/nfc/Tag;
    const/4 v5, 0x0

    .line 134
    .restart local v5    # "msg":Landroid/nfc/NdefMessage;
    invoke-virtual {p1}, Lcom/google/appinventor/components/runtime/NearField;->WriteType()I

    move-result v11

    if-ne v11, v13, :cond_4

    .line 135
    invoke-virtual {p1}, Lcom/google/appinventor/components/runtime/NearField;->TextToWrite()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11, v13}, Lcom/google/appinventor/components/runtime/util/GingerbreadUtil;->createTextRecord(Ljava/lang/String;Z)Landroid/nfc/NdefRecord;

    move-result-object v10

    .line 136
    .local v10, "textRecord":Landroid/nfc/NdefRecord;
    new-instance v5, Landroid/nfc/NdefMessage;

    .end local v5    # "msg":Landroid/nfc/NdefMessage;
    new-array v11, v13, [Landroid/nfc/NdefRecord;

    aput-object v10, v11, v12

    invoke-direct {v5, v11}, Landroid/nfc/NdefMessage;-><init>([Landroid/nfc/NdefRecord;)V

    .line 138
    .end local v10    # "textRecord":Landroid/nfc/NdefRecord;
    .restart local v5    # "msg":Landroid/nfc/NdefMessage;
    :cond_4
    invoke-static {v5, v1}, Lcom/google/appinventor/components/runtime/util/GingerbreadUtil;->writeNFCTag(Landroid/nfc/NdefMessage;Landroid/nfc/Tag;)Z

    move-result v11

    if-eqz v11, :cond_2

    .line 139
    invoke-virtual {p1}, Lcom/google/appinventor/components/runtime/NearField;->TagWritten()V

    goto :goto_1

    .line 143
    .end local v1    # "detectedTag":Landroid/nfc/Tag;
    .end local v5    # "msg":Landroid/nfc/NdefMessage;
    :cond_5
    const-string v11, "nearfield"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "Unknown intent "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method public static writeNFCTag(Landroid/nfc/NdefMessage;Landroid/nfc/Tag;)Z
    .locals 7
    .param p0, "message"    # Landroid/nfc/NdefMessage;
    .param p1, "tag"    # Landroid/nfc/Tag;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 151
    invoke-virtual {p0}, Landroid/nfc/NdefMessage;->toByteArray()[B

    move-result-object v6

    array-length v3, v6

    .line 153
    .local v3, "size":I
    :try_start_0
    invoke-static {p1}, Landroid/nfc/tech/Ndef;->get(Landroid/nfc/Tag;)Landroid/nfc/tech/Ndef;

    move-result-object v2

    .line 154
    .local v2, "ndef":Landroid/nfc/tech/Ndef;
    if-eqz v2, :cond_2

    .line 155
    invoke-virtual {v2}, Landroid/nfc/tech/Ndef;->connect()V

    .line 156
    invoke-virtual {v2}, Landroid/nfc/tech/Ndef;->isWritable()Z

    move-result v6

    if-nez v6, :cond_1

    .line 179
    .end local v2    # "ndef":Landroid/nfc/tech/Ndef;
    :cond_0
    :goto_0
    return v4

    .line 159
    .restart local v2    # "ndef":Landroid/nfc/tech/Ndef;
    :cond_1
    invoke-virtual {v2}, Landroid/nfc/tech/Ndef;->getMaxSize()I

    move-result v6

    if-lt v6, v3, :cond_0

    .line 162
    invoke-virtual {v2, p0}, Landroid/nfc/tech/Ndef;->writeNdefMessage(Landroid/nfc/NdefMessage;)V

    move v4, v5

    .line 163
    goto :goto_0

    .line 165
    :cond_2
    invoke-static {p1}, Landroid/nfc/tech/NdefFormatable;->get(Landroid/nfc/Tag;)Landroid/nfc/tech/NdefFormatable;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v1

    .line 166
    .local v1, "format":Landroid/nfc/tech/NdefFormatable;
    if-eqz v1, :cond_0

    .line 168
    :try_start_1
    invoke-virtual {v1}, Landroid/nfc/tech/NdefFormatable;->connect()V

    .line 169
    invoke-virtual {v1, p0}, Landroid/nfc/tech/NdefFormatable;->format(Landroid/nfc/NdefMessage;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move v4, v5

    .line 170
    goto :goto_0

    .line 171
    :catch_0
    move-exception v0

    .line 172
    .local v0, "e":Ljava/io/IOException;
    goto :goto_0

    .line 178
    .end local v0    # "e":Ljava/io/IOException;
    .end local v1    # "format":Landroid/nfc/tech/NdefFormatable;
    .end local v2    # "ndef":Landroid/nfc/tech/Ndef;
    :catch_1
    move-exception v0

    .line 179
    .local v0, "e":Ljava/lang/Exception;
    goto :goto_0
.end method
