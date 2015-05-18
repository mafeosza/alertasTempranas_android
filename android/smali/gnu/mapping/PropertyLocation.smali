.class public Lgnu/mapping/PropertyLocation;
.super Lgnu/mapping/Location;
.source "PropertyLocation.java"


# instance fields
.field pair:Lgnu/lists/Pair;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lgnu/mapping/Location;-><init>()V

    return-void
.end method

.method public static getProperty(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "property"    # Ljava/lang/Object;
    .param p2, "defaultValue"    # Ljava/lang/Object;

    .prologue
    .line 147
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lgnu/mapping/PropertyLocation;->getProperty(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Environment;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static getProperty(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Environment;)Ljava/lang/Object;
    .locals 2
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "property"    # Ljava/lang/Object;
    .param p2, "defaultValue"    # Ljava/lang/Object;
    .param p3, "env"    # Lgnu/mapping/Environment;

    .prologue
    .line 129
    instance-of v0, p0, Lgnu/mapping/Symbol;

    if-nez v0, :cond_0

    .line 131
    instance-of v0, p0, Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 132
    check-cast p0, Ljava/lang/String;

    .end local p0    # "symbol":Ljava/lang/Object;
    invoke-static {p0}, Lgnu/mapping/Namespace;->getDefaultSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object p0

    .line 137
    :cond_0
    check-cast p0, Lgnu/mapping/Symbol;

    invoke-virtual {p3, p0, p1, p2}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    .line 134
    .restart local p0    # "symbol":Ljava/lang/Object;
    :cond_1
    sget-object v0, Lgnu/mapping/Symbol;->PLIST:Lgnu/mapping/Symbol;

    sget-object v1, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-virtual {p3, v0, p0, v1}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-static {v0, p1, p2}, Lgnu/mapping/PropertyLocation;->plistGet(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public static getPropertyList(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p0, "symbol"    # Ljava/lang/Object;

    .prologue
    .line 48
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    sget-object v1, Lgnu/mapping/Symbol;->PLIST:Lgnu/mapping/Symbol;

    sget-object v2, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-virtual {v0, v1, p0, v2}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static getPropertyList(Ljava/lang/Object;Lgnu/mapping/Environment;)Ljava/lang/Object;
    .locals 2
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "env"    # Lgnu/mapping/Environment;

    .prologue
    .line 38
    sget-object v0, Lgnu/mapping/Symbol;->PLIST:Lgnu/mapping/Symbol;

    sget-object v1, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-virtual {p1, v0, p0, v1}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public static plistGet(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p0, "plist"    # Ljava/lang/Object;
    .param p1, "prop"    # Ljava/lang/Object;
    .param p2, "dfault"    # Ljava/lang/Object;

    .prologue
    .line 262
    :cond_0
    instance-of v1, p0, Lgnu/lists/Pair;

    if-eqz v1, :cond_1

    move-object v0, p0

    .line 264
    check-cast v0, Lgnu/lists/Pair;

    .line 265
    .local v0, "pair":Lgnu/lists/Pair;
    invoke-virtual {v0}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v1

    if-ne v1, p1, :cond_0

    .line 266
    invoke-virtual {v0}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lgnu/lists/Pair;

    invoke-virtual {v1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object p2

    .line 268
    .end local v0    # "pair":Lgnu/lists/Pair;
    .end local p2    # "dfault":Ljava/lang/Object;
    :cond_1
    return-object p2
.end method

.method public static plistPut(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .param p0, "plist"    # Ljava/lang/Object;
    .param p1, "prop"    # Ljava/lang/Object;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 276
    move-object v1, p0

    .local v1, "p":Ljava/lang/Object;
    :goto_0
    instance-of v3, v1, Lgnu/lists/Pair;

    if-eqz v3, :cond_1

    move-object v2, v1

    .line 278
    check-cast v2, Lgnu/lists/Pair;

    .line 279
    .local v2, "pair":Lgnu/lists/Pair;
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/lists/Pair;

    .line 280
    .local v0, "next":Lgnu/lists/Pair;
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    if-ne v3, p1, :cond_0

    .line 282
    invoke-virtual {v0, p2}, Lgnu/lists/Pair;->setCar(Ljava/lang/Object;)V

    .line 287
    .end local v0    # "next":Lgnu/lists/Pair;
    .end local v2    # "pair":Lgnu/lists/Pair;
    .end local p0    # "plist":Ljava/lang/Object;
    :goto_1
    return-object p0

    .line 285
    .restart local v0    # "next":Lgnu/lists/Pair;
    .restart local v2    # "pair":Lgnu/lists/Pair;
    .restart local p0    # "plist":Ljava/lang/Object;
    :cond_0
    invoke-virtual {v0}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    .line 286
    goto :goto_0

    .line 287
    .end local v0    # "next":Lgnu/lists/Pair;
    .end local v2    # "pair":Lgnu/lists/Pair;
    :cond_1
    new-instance v3, Lgnu/lists/Pair;

    new-instance v4, Lgnu/lists/Pair;

    invoke-direct {v4, p2, p0}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-direct {v3, p1, v4}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    move-object p0, v3

    goto :goto_1
.end method

.method public static plistRemove(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .param p0, "plist"    # Ljava/lang/Object;
    .param p1, "prop"    # Ljava/lang/Object;

    .prologue
    .line 295
    const/4 v3, 0x0

    .line 296
    .local v3, "prev":Lgnu/lists/Pair;
    move-object v1, p0

    .local v1, "p":Ljava/lang/Object;
    :goto_0
    instance-of v4, v1, Lgnu/lists/Pair;

    if-eqz v4, :cond_0

    move-object v2, v1

    .line 298
    check-cast v2, Lgnu/lists/Pair;

    .line 299
    .local v2, "pair":Lgnu/lists/Pair;
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/lists/Pair;

    .line 300
    .local v0, "next":Lgnu/lists/Pair;
    invoke-virtual {v0}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v1

    .line 301
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v4

    if-ne v4, p1, :cond_2

    .line 303
    if-nez v3, :cond_1

    move-object p0, v1

    .line 310
    .end local v0    # "next":Lgnu/lists/Pair;
    .end local v2    # "pair":Lgnu/lists/Pair;
    .end local p0    # "plist":Ljava/lang/Object;
    :cond_0
    :goto_1
    return-object p0

    .line 305
    .restart local v0    # "next":Lgnu/lists/Pair;
    .restart local v2    # "pair":Lgnu/lists/Pair;
    .restart local p0    # "plist":Ljava/lang/Object;
    :cond_1
    invoke-virtual {v3, v1}, Lgnu/lists/Pair;->setCdr(Ljava/lang/Object;)V

    goto :goto_1

    .line 308
    :cond_2
    move-object v3, v0

    .line 309
    goto :goto_0
.end method

.method public static putProperty(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "property"    # Ljava/lang/Object;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 210
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    invoke-static {p0, p1, p2, v0}, Lgnu/mapping/PropertyLocation;->putProperty(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Environment;)V

    .line 211
    return-void
.end method

.method public static putProperty(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Environment;)V
    .locals 6
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "property"    # Ljava/lang/Object;
    .param p2, "newValue"    # Ljava/lang/Object;
    .param p3, "env"    # Lgnu/mapping/Environment;

    .prologue
    .line 154
    instance-of v5, p0, Lgnu/mapping/Symbol;

    if-nez v5, :cond_0

    .line 156
    instance-of v5, p0, Ljava/lang/String;

    if-eqz v5, :cond_1

    .line 157
    check-cast p0, Ljava/lang/String;

    .end local p0    # "symbol":Ljava/lang/Object;
    invoke-static {p0}, Lgnu/mapping/Namespace;->getDefaultSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object p0

    :cond_0
    move-object v5, p0

    .line 165
    check-cast v5, Lgnu/mapping/Symbol;

    invoke-virtual {p3, v5, p1}, Lgnu/mapping/Environment;->lookup(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v1

    .line 166
    .local v1, "loc":Lgnu/mapping/Location;
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lgnu/mapping/Location;->getBase()Lgnu/mapping/Location;

    move-result-object v1

    instance-of v5, v1, Lgnu/mapping/PropertyLocation;

    if-eqz v5, :cond_2

    move-object v5, v1

    .line 167
    check-cast v5, Lgnu/mapping/PropertyLocation;

    invoke-virtual {v5, p2}, Lgnu/mapping/PropertyLocation;->set(Ljava/lang/Object;)V

    .line 202
    .end local v1    # "loc":Lgnu/mapping/Location;
    :goto_0
    return-void

    .line 160
    .restart local p0    # "symbol":Ljava/lang/Object;
    :cond_1
    sget-object v5, Lgnu/mapping/Symbol;->PLIST:Lgnu/mapping/Symbol;

    invoke-virtual {p3, v5, p0}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v0

    .line 161
    .local v0, "lloc":Lgnu/mapping/Location;
    sget-object v5, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-virtual {v0, v5}, Lgnu/mapping/Location;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v5, p1, p2}, Lgnu/mapping/PropertyLocation;->plistPut(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v0, v5}, Lgnu/mapping/Location;->set(Ljava/lang/Object;)V

    goto :goto_0

    .line 170
    .end local v0    # "lloc":Lgnu/mapping/Location;
    .end local p0    # "symbol":Ljava/lang/Object;
    .restart local v1    # "loc":Lgnu/mapping/Location;
    :cond_2
    sget-object v5, Lgnu/mapping/Symbol;->PLIST:Lgnu/mapping/Symbol;

    invoke-virtual {p3, v5, p0}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v0

    .line 171
    .restart local v0    # "lloc":Lgnu/mapping/Location;
    sget-object v5, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-virtual {v0, v5}, Lgnu/mapping/Location;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 172
    .local v3, "plist":Ljava/lang/Object;
    const/4 v2, 0x0

    .line 194
    .local v2, "pair":Lgnu/lists/Pair;
    new-instance v2, Lgnu/lists/Pair;

    .end local v2    # "pair":Lgnu/lists/Pair;
    invoke-direct {v2, p2, v3}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 195
    .restart local v2    # "pair":Lgnu/lists/Pair;
    new-instance v3, Lgnu/lists/Pair;

    .end local v3    # "plist":Ljava/lang/Object;
    invoke-direct {v3, p1, v2}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 196
    .local v3, "plist":Lgnu/lists/Pair;
    invoke-virtual {v0, v3}, Lgnu/mapping/Location;->set(Ljava/lang/Object;)V

    .line 197
    new-instance v4, Lgnu/mapping/PropertyLocation;

    invoke-direct {v4}, Lgnu/mapping/PropertyLocation;-><init>()V

    .line 199
    .local v4, "ploc":Lgnu/mapping/PropertyLocation;
    iput-object v2, v4, Lgnu/mapping/PropertyLocation;->pair:Lgnu/lists/Pair;

    .line 200
    check-cast p0, Lgnu/mapping/Symbol;

    invoke-virtual {p3, p0, p1, v4}, Lgnu/mapping/Environment;->addLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Lgnu/mapping/Location;)Lgnu/mapping/NamedLocation;

    goto :goto_0
.end method

.method public static removeProperty(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 1
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "property"    # Ljava/lang/Object;

    .prologue
    .line 254
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lgnu/mapping/PropertyLocation;->removeProperty(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Environment;)Z

    move-result v0

    return v0
.end method

.method public static removeProperty(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Environment;)Z
    .locals 8
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "property"    # Ljava/lang/Object;
    .param p2, "env"    # Lgnu/mapping/Environment;

    .prologue
    const/4 v6, 0x0

    .line 218
    sget-object v7, Lgnu/mapping/Symbol;->PLIST:Lgnu/mapping/Symbol;

    invoke-virtual {p2, v7, p0}, Lgnu/mapping/Environment;->lookup(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v3

    .line 219
    .local v3, "ploc":Lgnu/mapping/Location;
    if-nez v3, :cond_1

    .line 246
    .end local p0    # "symbol":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v6

    .line 221
    .restart local p0    # "symbol":Ljava/lang/Object;
    :cond_1
    sget-object v7, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-virtual {v3, v7}, Lgnu/mapping/Location;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 222
    .local v2, "plist":Ljava/lang/Object;
    instance-of v7, v2, Lgnu/lists/Pair;

    if-eqz v7, :cond_0

    move-object v1, v2

    .line 224
    check-cast v1, Lgnu/lists/Pair;

    .line 225
    .local v1, "pair":Lgnu/lists/Pair;
    const/4 v4, 0x0

    .line 228
    .local v4, "prev":Lgnu/lists/Pair;
    :goto_1
    invoke-virtual {v1}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v7

    if-ne v7, p1, :cond_3

    .line 236
    invoke-virtual {v1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lgnu/lists/Pair;

    invoke-virtual {v6}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v5

    .line 237
    .local v5, "tail":Ljava/lang/Object;
    if-nez v4, :cond_4

    .line 239
    move-object v2, v5

    .line 240
    invoke-virtual {v3, v2}, Lgnu/mapping/Location;->set(Ljava/lang/Object;)V

    .line 244
    :goto_2
    instance-of v6, p0, Lgnu/mapping/Symbol;

    if-eqz v6, :cond_2

    .line 245
    check-cast p0, Lgnu/mapping/Symbol;

    .end local p0    # "symbol":Ljava/lang/Object;
    invoke-virtual {p2, p0, p1}, Lgnu/mapping/Environment;->remove(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;

    .line 246
    :cond_2
    const/4 v6, 0x1

    goto :goto_0

    .line 230
    .end local v5    # "tail":Ljava/lang/Object;
    .restart local p0    # "symbol":Ljava/lang/Object;
    :cond_3
    invoke-virtual {v1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v0

    .line 231
    .local v0, "next":Ljava/lang/Object;
    instance-of v7, v0, Lgnu/lists/Pair;

    if-eqz v7, :cond_0

    .line 233
    move-object v4, v1

    move-object v1, v0

    .line 234
    check-cast v1, Lgnu/lists/Pair;

    .line 235
    goto :goto_1

    .line 243
    .end local v0    # "next":Ljava/lang/Object;
    .restart local v5    # "tail":Ljava/lang/Object;
    :cond_4
    invoke-virtual {v4, v5}, Lgnu/lists/Pair;->setCdr(Ljava/lang/Object;)V

    goto :goto_2
.end method

.method public static setPropertyList(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 1
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "plist"    # Ljava/lang/Object;

    .prologue
    .line 115
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    invoke-static {p0, p1, v0}, Lgnu/mapping/PropertyLocation;->setPropertyList(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Environment;)V

    .line 117
    return-void
.end method

.method public static setPropertyList(Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/Environment;)V
    .locals 11
    .param p0, "symbol"    # Ljava/lang/Object;
    .param p1, "plist"    # Ljava/lang/Object;
    .param p2, "env"    # Lgnu/mapping/Environment;

    .prologue
    .line 60
    monitor-enter p2

    .line 62
    :try_start_0
    sget-object v10, Lgnu/mapping/Symbol;->PLIST:Lgnu/mapping/Symbol;

    invoke-virtual {p2, v10, p0}, Lgnu/mapping/Environment;->lookup(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v1

    .line 63
    .local v1, "lloc":Lgnu/mapping/Location;
    instance-of v10, p0, Lgnu/mapping/Symbol;

    if-eqz v10, :cond_0

    .line 65
    move-object v0, p0

    check-cast v0, Lgnu/mapping/Symbol;

    move-object v8, v0

    .line 66
    .local v8, "sym":Lgnu/mapping/Symbol;
    sget-object v10, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    invoke-virtual {v1, v10}, Lgnu/mapping/Location;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 67
    .local v3, "old":Ljava/lang/Object;
    move-object v4, v3

    .line 71
    .local v4, "p":Ljava/lang/Object;
    :goto_0
    instance-of v10, v4, Lgnu/lists/Pair;

    if-nez v10, :cond_1

    .line 80
    move-object v4, p1

    .line 83
    :goto_1
    instance-of v10, v4, Lgnu/lists/Pair;

    if-nez v10, :cond_3

    .line 105
    .end local v3    # "old":Ljava/lang/Object;
    .end local v4    # "p":Ljava/lang/Object;
    .end local v8    # "sym":Lgnu/mapping/Symbol;
    :cond_0
    invoke-virtual {v1, p1}, Lgnu/mapping/Location;->set(Ljava/lang/Object;)V

    .line 106
    monitor-exit p2

    .line 107
    return-void

    .line 73
    .restart local v3    # "old":Ljava/lang/Object;
    .restart local v4    # "p":Ljava/lang/Object;
    .restart local v8    # "sym":Lgnu/mapping/Symbol;
    :cond_1
    move-object v0, v4

    check-cast v0, Lgnu/lists/Pair;

    move-object v5, v0

    .line 74
    .local v5, "pair":Lgnu/lists/Pair;
    invoke-virtual {v5}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v7

    .line 75
    .local v7, "property":Ljava/lang/Object;
    const/4 v10, 0x0

    invoke-static {p1, v7, v10}, Lgnu/mapping/PropertyLocation;->plistGet(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    if-eqz v10, :cond_2

    .line 76
    invoke-virtual {p2, v8, v7}, Lgnu/mapping/Environment;->remove(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    :cond_2
    invoke-virtual {v5}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lgnu/lists/Pair;

    invoke-virtual {v10}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    .line 78
    goto :goto_0

    .line 85
    .end local v5    # "pair":Lgnu/lists/Pair;
    .end local v7    # "property":Ljava/lang/Object;
    :cond_3
    move-object v0, v4

    check-cast v0, Lgnu/lists/Pair;

    move-object v5, v0

    .line 86
    .restart local v5    # "pair":Lgnu/lists/Pair;
    invoke-virtual {v5}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v7

    .line 87
    .restart local v7    # "property":Ljava/lang/Object;
    invoke-virtual {p2, v8, v7}, Lgnu/mapping/Environment;->lookup(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v2

    .line 89
    .local v2, "loc":Lgnu/mapping/Location;
    if-eqz v2, :cond_4

    invoke-virtual {v2}, Lgnu/mapping/Location;->getBase()Lgnu/mapping/Location;

    move-result-object v2

    instance-of v10, v2, Lgnu/mapping/PropertyLocation;

    if-eqz v10, :cond_4

    .line 92
    move-object v0, v2

    check-cast v0, Lgnu/mapping/PropertyLocation;

    move-object v6, v0

    .line 99
    .local v6, "ploc":Lgnu/mapping/PropertyLocation;
    :goto_2
    invoke-virtual {v5}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lgnu/lists/Pair;

    .line 100
    .local v9, "valuePair":Lgnu/lists/Pair;
    iput-object v9, v6, Lgnu/mapping/PropertyLocation;->pair:Lgnu/lists/Pair;

    .line 102
    invoke-virtual {v9}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v4

    .line 103
    goto :goto_1

    .line 96
    .end local v6    # "ploc":Lgnu/mapping/PropertyLocation;
    .end local v9    # "valuePair":Lgnu/lists/Pair;
    :cond_4
    new-instance v6, Lgnu/mapping/PropertyLocation;

    invoke-direct {v6}, Lgnu/mapping/PropertyLocation;-><init>()V

    .line 97
    .restart local v6    # "ploc":Lgnu/mapping/PropertyLocation;
    invoke-virtual {p2, v8, v7, v6}, Lgnu/mapping/Environment;->addLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Lgnu/mapping/Location;)Lgnu/mapping/NamedLocation;

    goto :goto_2

    .line 106
    .end local v1    # "lloc":Lgnu/mapping/Location;
    .end local v2    # "loc":Lgnu/mapping/Location;
    .end local v3    # "old":Ljava/lang/Object;
    .end local v4    # "p":Ljava/lang/Object;
    .end local v5    # "pair":Lgnu/lists/Pair;
    .end local v6    # "ploc":Lgnu/mapping/PropertyLocation;
    .end local v7    # "property":Ljava/lang/Object;
    .end local v8    # "sym":Lgnu/mapping/Symbol;
    :catchall_0
    move-exception v10

    monitor-exit p2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v10
.end method


# virtual methods
.method public final get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "defaultValue"    # Ljava/lang/Object;

    .prologue
    .line 19
    iget-object v0, p0, Lgnu/mapping/PropertyLocation;->pair:Lgnu/lists/Pair;

    invoke-virtual {v0}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public isBound()Z
    .locals 1

    .prologue
    .line 24
    const/4 v0, 0x1

    return v0
.end method

.method public final set(Ljava/lang/Object;)V
    .locals 1
    .param p1, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 29
    iget-object v0, p0, Lgnu/mapping/PropertyLocation;->pair:Lgnu/lists/Pair;

    invoke-virtual {v0, p1}, Lgnu/lists/Pair;->setCar(Ljava/lang/Object;)V

    .line 30
    return-void
.end method
