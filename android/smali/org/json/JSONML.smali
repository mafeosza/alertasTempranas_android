.class public Lorg/json/JSONML;
.super Ljava/lang/Object;
.source "JSONML.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;)Ljava/lang/Object;
    .locals 12
    .param p0, "x"    # Lorg/json/XMLTokener;
    .param p1, "arrayForm"    # Z
    .param p2, "ja"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/16 v11, 0x5b

    const/16 v10, 0x2d

    .line 56
    const/4 v2, 0x0

    .line 58
    .local v2, "closeTag":Ljava/lang/String;
    const/4 v4, 0x0

    .line 59
    .local v4, "newja":Lorg/json/JSONArray;
    const/4 v5, 0x0

    .line 61
    .local v5, "newjo":Lorg/json/JSONObject;
    const/4 v6, 0x0

    .line 70
    .local v6, "tagName":Ljava/lang/String;
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lorg/json/XMLTokener;->more()Z

    move-result v8

    if-nez v8, :cond_1

    .line 71
    const-string v8, "Bad XML"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 73
    :cond_1
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextContent()Ljava/lang/Object;

    move-result-object v7

    .line 74
    .local v7, "token":Ljava/lang/Object;
    sget-object v8, Lorg/json/XML;->LT:Ljava/lang/Character;

    if-ne v7, v8, :cond_21

    .line 75
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v7

    .line 76
    instance-of v8, v7, Ljava/lang/Character;

    if-eqz v8, :cond_e

    .line 77
    sget-object v8, Lorg/json/XML;->SLASH:Ljava/lang/Character;

    if-ne v7, v8, :cond_3

    .line 81
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v7

    .line 82
    instance-of v8, v7, Ljava/lang/String;

    if-nez v8, :cond_2

    .line 83
    new-instance v8, Lorg/json/JSONException;

    new-instance v9, Ljava/lang/StringBuffer;

    invoke-direct {v9}, Ljava/lang/StringBuffer;-><init>()V

    const-string v10, "Expected a closing name instead of \'"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {v9, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v9

    const-string v10, "\'."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lorg/json/JSONException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 87
    :cond_2
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v8

    sget-object v9, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-eq v8, v9, :cond_1a

    .line 88
    const-string v8, "Misshaped close tag"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 91
    :cond_3
    sget-object v8, Lorg/json/XML;->BANG:Ljava/lang/Character;

    if-ne v7, v8, :cond_c

    .line 95
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v1

    .line 96
    .local v1, "c":C
    if-ne v1, v10, :cond_5

    .line 97
    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v8

    if-ne v8, v10, :cond_4

    .line 98
    const-string v8, "-->"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->skipPast(Ljava/lang/String;)Z

    goto :goto_0

    .line 100
    :cond_4
    invoke-virtual {p0}, Lorg/json/XMLTokener;->back()V

    goto :goto_0

    .line 102
    :cond_5
    if-ne v1, v11, :cond_7

    .line 103
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v7

    .line 104
    const-string v8, "CDATA"

    invoke-virtual {v7, v8}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    invoke-virtual {p0}, Lorg/json/XMLTokener;->next()C

    move-result v8

    if-ne v8, v11, :cond_6

    .line 105
    if-eqz p2, :cond_0

    .line 106
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextCDATA()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p2, v8}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto/16 :goto_0

    .line 109
    :cond_6
    const-string v8, "Expected \'CDATA[\'"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 112
    :cond_7
    const/4 v3, 0x1

    .line 114
    .local v3, "i":I
    :cond_8
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextMeta()Ljava/lang/Object;

    move-result-object v7

    .line 115
    if-nez v7, :cond_9

    .line 116
    const-string v8, "Missing \'>\' after \'<!\'."

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 117
    :cond_9
    sget-object v8, Lorg/json/XML;->LT:Ljava/lang/Character;

    if-ne v7, v8, :cond_b

    .line 118
    add-int/lit8 v3, v3, 0x1

    .line 122
    :cond_a
    :goto_1
    if-gtz v3, :cond_8

    goto/16 :goto_0

    .line 119
    :cond_b
    sget-object v8, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-ne v7, v8, :cond_a

    .line 120
    add-int/lit8 v3, v3, -0x1

    goto :goto_1

    .line 124
    .end local v1    # "c":C
    .end local v3    # "i":I
    :cond_c
    sget-object v8, Lorg/json/XML;->QUEST:Ljava/lang/Character;

    if-ne v7, v8, :cond_d

    .line 128
    const-string v8, "?>"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->skipPast(Ljava/lang/String;)Z

    goto/16 :goto_0

    .line 130
    :cond_d
    const-string v8, "Misshaped tag"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 136
    :cond_e
    instance-of v8, v7, Ljava/lang/String;

    if-nez v8, :cond_f

    .line 137
    new-instance v8, Ljava/lang/StringBuffer;

    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    const-string v9, "Bad tagName \'"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v8, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, "\'."

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    :cond_f
    move-object v6, v7

    .line 139
    check-cast v6, Ljava/lang/String;

    .line 140
    new-instance v4, Lorg/json/JSONArray;

    .end local v4    # "newja":Lorg/json/JSONArray;
    invoke-direct {v4}, Lorg/json/JSONArray;-><init>()V

    .line 141
    .restart local v4    # "newja":Lorg/json/JSONArray;
    new-instance v5, Lorg/json/JSONObject;

    .end local v5    # "newjo":Lorg/json/JSONObject;
    invoke-direct {v5}, Lorg/json/JSONObject;-><init>()V

    .line 142
    .restart local v5    # "newjo":Lorg/json/JSONObject;
    if-eqz p1, :cond_11

    .line 143
    invoke-virtual {v4, v6}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 144
    if-eqz p2, :cond_10

    .line 145
    invoke-virtual {p2, v4}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 153
    :cond_10
    :goto_2
    const/4 v7, 0x0

    .line 155
    .end local v7    # "token":Ljava/lang/Object;
    :goto_3
    if-nez v7, :cond_23

    .line 156
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v7

    .restart local v7    # "token":Ljava/lang/Object;
    move-object v0, v7

    .line 158
    .end local v7    # "token":Ljava/lang/Object;
    :goto_4
    if-nez v0, :cond_12

    .line 159
    const-string v8, "Misshaped tag"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 148
    .restart local v7    # "token":Ljava/lang/Object;
    :cond_11
    const-string v8, "tagName"

    invoke-virtual {v5, v8, v6}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 149
    if-eqz p2, :cond_10

    .line 150
    invoke-virtual {p2, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto :goto_2

    .line 161
    .end local v7    # "token":Ljava/lang/Object;
    :cond_12
    instance-of v8, v0, Ljava/lang/String;

    if-nez v8, :cond_14

    .line 183
    if-eqz p1, :cond_13

    invoke-virtual {v5}, Lorg/json/JSONObject;->length()I

    move-result v8

    if-lez v8, :cond_13

    .line 184
    invoke-virtual {v4, v5}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    .line 189
    :cond_13
    sget-object v8, Lorg/json/XML;->SLASH:Ljava/lang/Character;

    if-ne v0, v8, :cond_1c

    .line 190
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v8

    sget-object v9, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-eq v8, v9, :cond_19

    .line 191
    const-string v8, "Misshaped tag"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 167
    :cond_14
    check-cast v0, Ljava/lang/String;

    .line 168
    .local v0, "attribute":Ljava/lang/String;
    if-nez p1, :cond_16

    const-string v8, "tagName"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_15

    const-string v8, "childNode"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_16

    .line 169
    :cond_15
    const-string v8, "Reserved attribute."

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 171
    :cond_16
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v7

    .line 172
    .restart local v7    # "token":Ljava/lang/Object;
    sget-object v8, Lorg/json/XML;->EQ:Ljava/lang/Character;

    if-ne v7, v8, :cond_18

    .line 173
    invoke-virtual {p0}, Lorg/json/XMLTokener;->nextToken()Ljava/lang/Object;

    move-result-object v7

    .line 174
    instance-of v8, v7, Ljava/lang/String;

    if-nez v8, :cond_17

    .line 175
    const-string v8, "Missing value"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 177
    :cond_17
    check-cast v7, Ljava/lang/String;

    .end local v7    # "token":Ljava/lang/Object;
    invoke-static {v7}, Lorg/json/XML;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v5, v0, v8}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 178
    const/4 v7, 0x0

    .restart local v7    # "token":Ljava/lang/Object;
    goto :goto_3

    .line 180
    :cond_18
    const-string v8, ""

    invoke-virtual {v5, v0, v8}, Lorg/json/JSONObject;->accumulate(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    goto :goto_3

    .line 193
    .end local v0    # "attribute":Ljava/lang/String;
    .end local v7    # "token":Ljava/lang/Object;
    :cond_19
    if-nez p2, :cond_0

    .line 194
    if-eqz p1, :cond_1b

    move-object v7, v4

    .line 221
    :cond_1a
    :goto_5
    return-object v7

    :cond_1b
    move-object v7, v5

    .line 197
    goto :goto_5

    .line 204
    :cond_1c
    sget-object v8, Lorg/json/XML;->GT:Ljava/lang/Character;

    if-eq v0, v8, :cond_1d

    .line 205
    const-string v8, "Misshaped tag"

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 207
    :cond_1d
    invoke-static {p0, p1, v4}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "closeTag":Ljava/lang/String;
    check-cast v2, Ljava/lang/String;

    .line 208
    .restart local v2    # "closeTag":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 209
    invoke-virtual {v2, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_1e

    .line 210
    new-instance v8, Ljava/lang/StringBuffer;

    invoke-direct {v8}, Ljava/lang/StringBuffer;-><init>()V

    const-string v9, "Mismatched \'"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, "\' and \'"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v8, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    const-string v9, "\'"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0, v8}, Lorg/json/XMLTokener;->syntaxError(Ljava/lang/String;)Lorg/json/JSONException;

    move-result-object v8

    throw v8

    .line 213
    :cond_1e
    const/4 v6, 0x0

    .line 214
    if-nez p1, :cond_1f

    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v8

    if-lez v8, :cond_1f

    .line 215
    const-string v8, "childNodes"

    invoke-virtual {v5, v8, v4}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 217
    :cond_1f
    if-nez p2, :cond_0

    .line 218
    if-eqz p1, :cond_20

    move-object v7, v4

    .line 219
    goto :goto_5

    :cond_20
    move-object v7, v5

    .line 221
    goto :goto_5

    .line 228
    .restart local v7    # "token":Ljava/lang/Object;
    :cond_21
    if-eqz p2, :cond_0

    .line 229
    instance-of v8, v7, Ljava/lang/String;

    if-eqz v8, :cond_22

    check-cast v7, Ljava/lang/String;

    .end local v7    # "token":Ljava/lang/Object;
    invoke-static {v7}, Lorg/json/XML;->stringToValue(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    :cond_22
    invoke-virtual {p2, v7}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;

    goto/16 :goto_0

    :cond_23
    move-object v0, v7

    goto/16 :goto_4
.end method

.method public static toJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;
    .locals 1
    .param p0, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 251
    new-instance v0, Lorg/json/XMLTokener;

    invoke-direct {v0, p0}, Lorg/json/XMLTokener;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lorg/json/JSONML;->toJSONArray(Lorg/json/XMLTokener;)Lorg/json/JSONArray;

    move-result-object v0

    return-object v0
.end method

.method public static toJSONArray(Lorg/json/XMLTokener;)Lorg/json/JSONArray;
    .locals 2
    .param p0, "x"    # Lorg/json/XMLTokener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 268
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONArray;

    return-object v0
.end method

.method public static toJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 1
    .param p0, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 304
    new-instance v0, Lorg/json/XMLTokener;

    invoke-direct {v0, p0}, Lorg/json/XMLTokener;-><init>(Ljava/lang/String;)V

    invoke-static {v0}, Lorg/json/JSONML;->toJSONObject(Lorg/json/XMLTokener;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method public static toJSONObject(Lorg/json/XMLTokener;)Lorg/json/JSONObject;
    .locals 2
    .param p0, "x"    # Lorg/json/XMLTokener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 286
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lorg/json/JSONML;->parse(Lorg/json/XMLTokener;ZLorg/json/JSONArray;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/json/JSONObject;

    return-object v0
.end method

.method public static toString(Lorg/json/JSONArray;)Ljava/lang/String;
    .locals 14
    .param p0, "ja"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/16 v13, 0x3c

    const/16 v12, 0x2f

    const/16 v11, 0x22

    const/16 v10, 0x3e

    .line 321
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    .line 327
    .local v6, "sb":Ljava/lang/StringBuffer;
    const/4 v9, 0x0

    invoke-virtual {p0, v9}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 328
    .local v7, "tagName":Ljava/lang/String;
    invoke-static {v7}, Lorg/json/XML;->noSpace(Ljava/lang/String;)V

    .line 329
    invoke-static {v7}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 330
    invoke-virtual {v6, v13}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 331
    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 333
    const/4 v9, 0x1

    invoke-virtual {p0, v9}, Lorg/json/JSONArray;->opt(I)Ljava/lang/Object;

    move-result-object v5

    .line 334
    .local v5, "object":Ljava/lang/Object;
    instance-of v9, v5, Lorg/json/JSONObject;

    if-eqz v9, :cond_1

    .line 335
    const/4 v0, 0x2

    .local v0, "i":I
    move-object v1, v5

    .line 336
    check-cast v1, Lorg/json/JSONObject;

    .line 340
    .local v1, "jo":Lorg/json/JSONObject;
    invoke-virtual {v1}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v3

    .line 341
    .local v3, "keys":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    .line 342
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 343
    .local v2, "key":Ljava/lang/String;
    invoke-static {v2}, Lorg/json/XML;->noSpace(Ljava/lang/String;)V

    .line 344
    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 345
    .local v8, "value":Ljava/lang/String;
    if-eqz v8, :cond_0

    .line 346
    const/16 v9, 0x20

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 347
    invoke-static {v2}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 348
    const/16 v9, 0x3d

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 349
    invoke-virtual {v6, v11}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 350
    invoke-static {v8}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 351
    invoke-virtual {v6, v11}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 355
    .end local v0    # "i":I
    .end local v1    # "jo":Lorg/json/JSONObject;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Iterator;
    .end local v8    # "value":Ljava/lang/String;
    :cond_1
    const/4 v0, 0x1

    .line 360
    .restart local v0    # "i":I
    :cond_2
    invoke-virtual {p0}, Lorg/json/JSONArray;->length()I

    move-result v4

    .line 361
    .local v4, "length":I
    if-lt v0, v4, :cond_3

    .line 362
    invoke-virtual {v6, v12}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 363
    invoke-virtual {v6, v10}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 384
    :goto_1
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    return-object v9

    .line 365
    :cond_3
    invoke-virtual {v6, v10}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 367
    :cond_4
    invoke-virtual {p0, v0}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    .line 368
    add-int/lit8 v0, v0, 0x1

    .line 369
    if-eqz v5, :cond_5

    .line 370
    instance-of v9, v5, Ljava/lang/String;

    if-eqz v9, :cond_6

    .line 371
    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 378
    :cond_5
    :goto_2
    if-lt v0, v4, :cond_4

    .line 379
    invoke-virtual {v6, v13}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 380
    invoke-virtual {v6, v12}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 381
    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 382
    invoke-virtual {v6, v10}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 372
    :cond_6
    instance-of v9, v5, Lorg/json/JSONObject;

    if-eqz v9, :cond_7

    move-object v9, v5

    .line 373
    check-cast v9, Lorg/json/JSONObject;

    invoke-static {v9}, Lorg/json/JSONML;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 374
    :cond_7
    instance-of v9, v5, Lorg/json/JSONArray;

    if-eqz v9, :cond_5

    move-object v9, v5

    .line 375
    check-cast v9, Lorg/json/JSONArray;

    invoke-static {v9}, Lorg/json/JSONML;->toString(Lorg/json/JSONArray;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2
.end method

.method public static toString(Lorg/json/JSONObject;)Ljava/lang/String;
    .locals 14
    .param p0, "jo"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    const/16 v13, 0x3c

    const/16 v12, 0x2f

    const/16 v11, 0x22

    const/16 v10, 0x3e

    .line 397
    new-instance v6, Ljava/lang/StringBuffer;

    invoke-direct {v6}, Ljava/lang/StringBuffer;-><init>()V

    .line 409
    .local v6, "sb":Ljava/lang/StringBuffer;
    const-string v9, "tagName"

    invoke-virtual {p0, v9}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 410
    .local v7, "tagName":Ljava/lang/String;
    if-nez v7, :cond_0

    .line 411
    invoke-virtual {p0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 465
    :goto_0
    return-object v9

    .line 413
    :cond_0
    invoke-static {v7}, Lorg/json/XML;->noSpace(Ljava/lang/String;)V

    .line 414
    invoke-static {v7}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 415
    invoke-virtual {v6, v13}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 416
    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 420
    invoke-virtual {p0}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v3

    .line 421
    .local v3, "keys":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    .line 422
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 423
    .local v2, "key":Ljava/lang/String;
    const-string v9, "tagName"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_1

    const-string v9, "childNodes"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_1

    .line 424
    invoke-static {v2}, Lorg/json/XML;->noSpace(Ljava/lang/String;)V

    .line 425
    invoke-virtual {p0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 426
    .local v8, "value":Ljava/lang/String;
    if-eqz v8, :cond_1

    .line 427
    const/16 v9, 0x20

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 428
    invoke-static {v2}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 429
    const/16 v9, 0x3d

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 430
    invoke-virtual {v6, v11}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 431
    invoke-static {v8}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 432
    invoke-virtual {v6, v11}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 439
    .end local v2    # "key":Ljava/lang/String;
    .end local v8    # "value":Ljava/lang/String;
    :cond_2
    const-string v9, "childNodes"

    invoke-virtual {p0, v9}, Lorg/json/JSONObject;->optJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 440
    .local v1, "ja":Lorg/json/JSONArray;
    if-nez v1, :cond_3

    .line 441
    invoke-virtual {v6, v12}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 442
    invoke-virtual {v6, v10}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 465
    :goto_2
    invoke-virtual {v6}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v9

    goto :goto_0

    .line 444
    :cond_3
    invoke-virtual {v6, v10}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 445
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v4

    .line 446
    .local v4, "length":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_3
    if-ge v0, v4, :cond_8

    .line 447
    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    .line 448
    .local v5, "object":Ljava/lang/Object;
    if-eqz v5, :cond_4

    .line 449
    instance-of v9, v5, Ljava/lang/String;

    if-eqz v9, :cond_5

    .line 450
    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lorg/json/XML;->escape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 446
    .end local v5    # "object":Ljava/lang/Object;
    :cond_4
    :goto_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 451
    .restart local v5    # "object":Ljava/lang/Object;
    :cond_5
    instance-of v9, v5, Lorg/json/JSONObject;

    if-eqz v9, :cond_6

    .line 452
    check-cast v5, Lorg/json/JSONObject;

    .end local v5    # "object":Ljava/lang/Object;
    invoke-static {v5}, Lorg/json/JSONML;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_4

    .line 453
    .restart local v5    # "object":Ljava/lang/Object;
    :cond_6
    instance-of v9, v5, Lorg/json/JSONArray;

    if-eqz v9, :cond_7

    .line 454
    check-cast v5, Lorg/json/JSONArray;

    .end local v5    # "object":Ljava/lang/Object;
    invoke-static {v5}, Lorg/json/JSONML;->toString(Lorg/json/JSONArray;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_4

    .line 456
    .restart local v5    # "object":Ljava/lang/Object;
    :cond_7
    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v6, v9}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_4

    .line 460
    .end local v5    # "object":Ljava/lang/Object;
    :cond_8
    invoke-virtual {v6, v13}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 461
    invoke-virtual {v6, v12}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 462
    invoke-virtual {v6, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 463
    invoke-virtual {v6, v10}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_2
.end method
