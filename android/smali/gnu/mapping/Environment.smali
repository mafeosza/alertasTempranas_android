.class public abstract Lgnu/mapping/Environment;
.super Lgnu/mapping/PropertySet;
.source "Environment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lgnu/mapping/Environment$InheritedLocal;
    }
.end annotation


# static fields
.field static final CAN_DEFINE:I = 0x1

.field static final CAN_IMPLICITLY_DEFINE:I = 0x4

.field static final CAN_REDEFINE:I = 0x2

.field static final DIRECT_INHERITED_ON_SET:I = 0x10

.field public static final INDIRECT_DEFINES:I = 0x20

.field static final THREAD_SAFE:I = 0x8

.field protected static final curEnvironment:Lgnu/mapping/Environment$InheritedLocal;

.field static final envTable:Ljava/util/Hashtable;

.field static global:Lgnu/mapping/Environment;


# instance fields
.field flags:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 340
    new-instance v0, Ljava/util/Hashtable;

    const/16 v1, 0x32

    invoke-direct {v0, v1}, Ljava/util/Hashtable;-><init>(I)V

    sput-object v0, Lgnu/mapping/Environment;->envTable:Ljava/util/Hashtable;

    .line 371
    new-instance v0, Lgnu/mapping/Environment$InheritedLocal;

    invoke-direct {v0}, Lgnu/mapping/Environment$InheritedLocal;-><init>()V

    sput-object v0, Lgnu/mapping/Environment;->curEnvironment:Lgnu/mapping/Environment$InheritedLocal;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Lgnu/mapping/PropertySet;-><init>()V

    .line 43
    const/16 v0, 0x17

    iput v0, p0, Lgnu/mapping/Environment;->flags:I

    .line 485
    return-void
.end method

.method public static current()Lgnu/mapping/Environment;
    .locals 1

    .prologue
    .line 369
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    return-object v0
.end method

.method public static getCurrent()Lgnu/mapping/Environment;
    .locals 3

    .prologue
    .line 375
    sget-object v1, Lgnu/mapping/Environment;->curEnvironment:Lgnu/mapping/Environment$InheritedLocal;

    invoke-virtual {v1}, Lgnu/mapping/Environment$InheritedLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/Environment;

    .line 376
    .local v0, "env":Lgnu/mapping/Environment;
    if-nez v0, :cond_0

    .line 378
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lgnu/mapping/Environment;->global:Lgnu/mapping/Environment;

    invoke-static {v1, v2}, Lgnu/mapping/Environment;->make(Ljava/lang/String;Lgnu/mapping/Environment;)Lgnu/mapping/InheritingEnvironment;

    move-result-object v0

    .line 379
    iget v1, v0, Lgnu/mapping/Environment;->flags:I

    or-int/lit8 v1, v1, 0x8

    iput v1, v0, Lgnu/mapping/Environment;->flags:I

    .line 380
    sget-object v1, Lgnu/mapping/Environment;->curEnvironment:Lgnu/mapping/Environment$InheritedLocal;

    invoke-virtual {v1, v0}, Lgnu/mapping/Environment$InheritedLocal;->set(Ljava/lang/Object;)V

    .line 382
    :cond_0
    return-object v0
.end method

.method public static getGlobal()Lgnu/mapping/Environment;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lgnu/mapping/Environment;->global:Lgnu/mapping/Environment;

    return-object v0
.end method

.method public static getInstance(Ljava/lang/String;)Lgnu/mapping/Environment;
    .locals 4
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 344
    if-nez p0, :cond_0

    .line 345
    const-string p0, ""

    .line 346
    :cond_0
    sget-object v3, Lgnu/mapping/Environment;->envTable:Ljava/util/Hashtable;

    monitor-enter v3

    .line 348
    :try_start_0
    sget-object v2, Lgnu/mapping/Environment;->envTable:Ljava/util/Hashtable;

    invoke-virtual {v2, p0}, Ljava/util/Hashtable;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/Environment;

    .line 349
    .local v0, "env":Lgnu/mapping/Environment;
    if-eqz v0, :cond_1

    .line 350
    monitor-exit v3

    move-object v1, v0

    .line 354
    .end local v0    # "env":Lgnu/mapping/Environment;
    .local v1, "env":Ljava/lang/Object;
    :goto_0
    return-object v1

    .line 351
    .end local v1    # "env":Ljava/lang/Object;
    .restart local v0    # "env":Lgnu/mapping/Environment;
    :cond_1
    new-instance v0, Lgnu/mapping/SimpleEnvironment;

    .end local v0    # "env":Lgnu/mapping/Environment;
    invoke-direct {v0}, Lgnu/mapping/SimpleEnvironment;-><init>()V

    .line 352
    .restart local v0    # "env":Lgnu/mapping/Environment;
    invoke-virtual {v0, p0}, Lgnu/mapping/Environment;->setName(Ljava/lang/String;)V

    .line 353
    sget-object v2, Lgnu/mapping/Environment;->envTable:Ljava/util/Hashtable;

    invoke-virtual {v2, p0, v0}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 354
    monitor-exit v3

    move-object v1, v0

    .restart local v1    # "env":Ljava/lang/Object;
    goto :goto_0

    .line 355
    .end local v0    # "env":Lgnu/mapping/Environment;
    .end local v1    # "env":Ljava/lang/Object;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public static make(Ljava/lang/String;Lgnu/mapping/Environment;)Lgnu/mapping/InheritingEnvironment;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "parent"    # Lgnu/mapping/Environment;

    .prologue
    .line 428
    new-instance v0, Lgnu/mapping/InheritingEnvironment;

    invoke-direct {v0, p0, p1}, Lgnu/mapping/InheritingEnvironment;-><init>(Ljava/lang/String;Lgnu/mapping/Environment;)V

    return-object v0
.end method

.method public static make()Lgnu/mapping/SimpleEnvironment;
    .locals 1

    .prologue
    .line 418
    new-instance v0, Lgnu/mapping/SimpleEnvironment;

    invoke-direct {v0}, Lgnu/mapping/SimpleEnvironment;-><init>()V

    return-object v0
.end method

.method public static make(Ljava/lang/String;)Lgnu/mapping/SimpleEnvironment;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 423
    new-instance v0, Lgnu/mapping/SimpleEnvironment;

    invoke-direct {v0, p0}, Lgnu/mapping/SimpleEnvironment;-><init>(Ljava/lang/String;)V

    return-object v0
.end method

.method public static restoreCurrent(Lgnu/mapping/Environment;)V
    .locals 1
    .param p0, "saved"    # Lgnu/mapping/Environment;

    .prologue
    .line 399
    sget-object v0, Lgnu/mapping/Environment;->curEnvironment:Lgnu/mapping/Environment$InheritedLocal;

    invoke-virtual {v0, p0}, Lgnu/mapping/Environment$InheritedLocal;->set(Ljava/lang/Object;)V

    .line 400
    return-void
.end method

.method public static setCurrent(Lgnu/mapping/Environment;)V
    .locals 1
    .param p0, "env"    # Lgnu/mapping/Environment;

    .prologue
    .line 387
    sget-object v0, Lgnu/mapping/Environment;->curEnvironment:Lgnu/mapping/Environment$InheritedLocal;

    invoke-virtual {v0, p0}, Lgnu/mapping/Environment$InheritedLocal;->set(Ljava/lang/Object;)V

    .line 388
    return-void
.end method

.method public static setGlobal(Lgnu/mapping/Environment;)V
    .locals 0
    .param p0, "env"    # Lgnu/mapping/Environment;

    .prologue
    .line 20
    sput-object p0, Lgnu/mapping/Environment;->global:Lgnu/mapping/Environment;

    .line 21
    return-void
.end method

.method public static setSaveCurrent(Lgnu/mapping/Environment;)Lgnu/mapping/Environment;
    .locals 2
    .param p0, "env"    # Lgnu/mapping/Environment;

    .prologue
    .line 392
    sget-object v1, Lgnu/mapping/Environment;->curEnvironment:Lgnu/mapping/Environment$InheritedLocal;

    invoke-virtual {v1}, Lgnu/mapping/Environment$InheritedLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/Environment;

    .line 393
    .local v0, "save":Lgnu/mapping/Environment;
    sget-object v1, Lgnu/mapping/Environment;->curEnvironment:Lgnu/mapping/Environment$InheritedLocal;

    invoke-virtual {v1, p0}, Lgnu/mapping/Environment$InheritedLocal;->set(Ljava/lang/Object;)V

    .line 394
    return-object v0
.end method

.method public static user()Lgnu/mapping/Environment;
    .locals 1

    .prologue
    .line 402
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public abstract addLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Lgnu/mapping/Location;)Lgnu/mapping/NamedLocation;
.end method

.method public final addLocation(Lgnu/mapping/EnvironmentKey;Lgnu/mapping/Location;)V
    .locals 2
    .param p1, "key"    # Lgnu/mapping/EnvironmentKey;
    .param p2, "loc"    # Lgnu/mapping/Location;

    .prologue
    .line 413
    invoke-interface {p1}, Lgnu/mapping/EnvironmentKey;->getKeySymbol()Lgnu/mapping/Symbol;

    move-result-object v0

    invoke-interface {p1}, Lgnu/mapping/EnvironmentKey;->getKeyProperty()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p2}, Lgnu/mapping/Environment;->addLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Lgnu/mapping/Location;)Lgnu/mapping/NamedLocation;

    .line 414
    return-void
.end method

.method public final addLocation(Lgnu/mapping/NamedLocation;)V
    .locals 2
    .param p1, "loc"    # Lgnu/mapping/NamedLocation;

    .prologue
    .line 406
    invoke-virtual {p1}, Lgnu/mapping/NamedLocation;->getKeySymbol()Lgnu/mapping/Symbol;

    move-result-object v0

    invoke-virtual {p1}, Lgnu/mapping/NamedLocation;->getKeyProperty()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p1}, Lgnu/mapping/Environment;->addLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Lgnu/mapping/Location;)Lgnu/mapping/NamedLocation;

    .line 407
    return-void
.end method

.method cloneForThread()Lgnu/mapping/SimpleEnvironment;
    .locals 15

    .prologue
    const/4 v14, 0x0

    .line 444
    new-instance v1, Lgnu/mapping/InheritingEnvironment;

    invoke-direct {v1, v14, p0}, Lgnu/mapping/InheritingEnvironment;-><init>(Ljava/lang/String;Lgnu/mapping/Environment;)V

    .line 449
    .local v1, "env":Lgnu/mapping/InheritingEnvironment;
    instance-of v12, p0, Lgnu/mapping/InheritingEnvironment;

    if-eqz v12, :cond_0

    move-object v8, p0

    .line 451
    check-cast v8, Lgnu/mapping/InheritingEnvironment;

    .line 452
    .local v8, "p":Lgnu/mapping/InheritingEnvironment;
    iget v7, v8, Lgnu/mapping/InheritingEnvironment;->numInherited:I

    .line 453
    .local v7, "numInherited":I
    iput v7, v1, Lgnu/mapping/InheritingEnvironment;->numInherited:I

    .line 454
    new-array v12, v7, [Lgnu/mapping/Environment;

    iput-object v12, v1, Lgnu/mapping/InheritingEnvironment;->inherited:[Lgnu/mapping/Environment;

    .line 455
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    if-ge v3, v7, :cond_0

    .line 456
    iget-object v12, v1, Lgnu/mapping/InheritingEnvironment;->inherited:[Lgnu/mapping/Environment;

    iget-object v13, v8, Lgnu/mapping/InheritingEnvironment;->inherited:[Lgnu/mapping/Environment;

    aget-object v13, v13, v3

    aput-object v13, v12, v3

    .line 455
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 459
    .end local v3    # "i":I
    .end local v7    # "numInherited":I
    .end local v8    # "p":Lgnu/mapping/InheritingEnvironment;
    :cond_0
    invoke-virtual {p0}, Lgnu/mapping/Environment;->enumerateLocations()Lgnu/mapping/LocationEnumeration;

    move-result-object v0

    .line 460
    .local v0, "e":Lgnu/mapping/LocationEnumeration;
    :cond_1
    :goto_1
    invoke-virtual {v0}, Lgnu/mapping/LocationEnumeration;->hasMoreElements()Z

    move-result v12

    if-eqz v12, :cond_3

    .line 462
    invoke-virtual {v0}, Lgnu/mapping/LocationEnumeration;->nextLocation()Lgnu/mapping/Location;

    move-result-object v4

    .line 464
    .local v4, "loc":Lgnu/mapping/Location;
    invoke-virtual {v4}, Lgnu/mapping/Location;->getKeySymbol()Lgnu/mapping/Symbol;

    move-result-object v5

    .line 465
    .local v5, "name":Lgnu/mapping/Symbol;
    invoke-virtual {v4}, Lgnu/mapping/Location;->getKeyProperty()Ljava/lang/Object;

    move-result-object v9

    .line 466
    .local v9, "property":Ljava/lang/Object;
    if-eqz v5, :cond_1

    instance-of v12, v4, Lgnu/mapping/NamedLocation;

    if-eqz v12, :cond_1

    move-object v6, v4

    .line 468
    check-cast v6, Lgnu/mapping/NamedLocation;

    .line 469
    .local v6, "nloc":Lgnu/mapping/NamedLocation;
    iget-object v12, v6, Lgnu/mapping/NamedLocation;->base:Lgnu/mapping/Location;

    if-nez v12, :cond_2

    .line 471
    new-instance v10, Lgnu/mapping/SharedLocation;

    const/4 v12, 0x0

    invoke-direct {v10, v5, v9, v12}, Lgnu/mapping/SharedLocation;-><init>(Lgnu/mapping/Symbol;Ljava/lang/Object;I)V

    .line 472
    .local v10, "sloc":Lgnu/mapping/SharedLocation;
    iget-object v12, v6, Lgnu/mapping/NamedLocation;->value:Ljava/lang/Object;

    iput-object v12, v10, Lgnu/mapping/SharedLocation;->value:Ljava/lang/Object;

    .line 473
    iput-object v10, v6, Lgnu/mapping/NamedLocation;->base:Lgnu/mapping/Location;

    .line 474
    iput-object v14, v6, Lgnu/mapping/NamedLocation;->value:Ljava/lang/Object;

    .line 475
    move-object v6, v10

    .line 477
    .end local v10    # "sloc":Lgnu/mapping/SharedLocation;
    :cond_2
    invoke-virtual {v5}, Lgnu/mapping/Symbol;->hashCode()I

    move-result v12

    invoke-static {v9}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v13

    xor-int v2, v12, v13

    .line 478
    .local v2, "hash":I
    invoke-virtual {v1, v5, v9, v2}, Lgnu/mapping/InheritingEnvironment;->addUnboundLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Lgnu/mapping/NamedLocation;

    move-result-object v11

    .line 479
    .local v11, "xloc":Lgnu/mapping/NamedLocation;
    iput-object v6, v11, Lgnu/mapping/NamedLocation;->base:Lgnu/mapping/Location;

    goto :goto_1

    .line 482
    .end local v2    # "hash":I
    .end local v4    # "loc":Lgnu/mapping/Location;
    .end local v5    # "name":Lgnu/mapping/Symbol;
    .end local v6    # "nloc":Lgnu/mapping/NamedLocation;
    .end local v9    # "property":Ljava/lang/Object;
    .end local v11    # "xloc":Lgnu/mapping/NamedLocation;
    :cond_3
    return-object v1
.end method

.method public final containsKey(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "key"    # Ljava/lang/Object;

    .prologue
    .line 149
    const/4 v1, 0x0

    .line 150
    .local v1, "property":Ljava/lang/Object;
    instance-of v3, p1, Lgnu/mapping/EnvironmentKey;

    if-eqz v3, :cond_0

    move-object v0, p1

    .line 152
    check-cast v0, Lgnu/mapping/EnvironmentKey;

    .line 153
    .local v0, "k":Lgnu/mapping/EnvironmentKey;
    invoke-interface {v0}, Lgnu/mapping/EnvironmentKey;->getKeySymbol()Lgnu/mapping/Symbol;

    move-result-object p1

    .line 154
    .local p1, "key":Lgnu/mapping/Symbol;
    invoke-interface {v0}, Lgnu/mapping/EnvironmentKey;->getKeyProperty()Ljava/lang/Object;

    move-result-object v1

    .line 156
    .end local v0    # "k":Lgnu/mapping/EnvironmentKey;
    .end local v1    # "property":Ljava/lang/Object;
    .end local p1    # "key":Lgnu/mapping/Symbol;
    :cond_0
    instance-of v3, p1, Lgnu/mapping/Symbol;

    if-eqz v3, :cond_1

    check-cast p1, Lgnu/mapping/Symbol;

    move-object v2, p1

    .line 158
    .local v2, "sym":Lgnu/mapping/Symbol;
    :goto_0
    invoke-virtual {p0, v2, v1}, Lgnu/mapping/Environment;->isBound(Lgnu/mapping/Symbol;Ljava/lang/Object;)Z

    move-result v3

    return v3

    .line 156
    .end local v2    # "sym":Lgnu/mapping/Symbol;
    :cond_1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v2

    goto :goto_0
.end method

.method public defaultNamespace()Lgnu/mapping/Namespace;
    .locals 1

    .prologue
    .line 332
    invoke-static {}, Lgnu/mapping/Namespace;->getDefault()Lgnu/mapping/Namespace;

    move-result-object v0

    return-object v0
.end method

.method public abstract define(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V
.end method

.method public abstract enumerateAllLocations()Lgnu/mapping/LocationEnumeration;
.end method

.method public abstract enumerateLocations()Lgnu/mapping/LocationEnumeration;
.end method

.method public final get(Lgnu/mapping/EnvironmentKey;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "key"    # Lgnu/mapping/EnvironmentKey;
    .param p2, "defaultValue"    # Ljava/lang/Object;

    .prologue
    .line 183
    invoke-interface {p1}, Lgnu/mapping/EnvironmentKey;->getKeySymbol()Lgnu/mapping/Symbol;

    move-result-object v1

    .line 184
    .local v1, "symbol":Lgnu/mapping/Symbol;
    invoke-interface {p1}, Lgnu/mapping/EnvironmentKey;->getKeyProperty()Ljava/lang/Object;

    move-result-object v0

    .line 185
    .local v0, "property":Ljava/lang/Object;
    invoke-virtual {p0, v1, v0, p2}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    return-object v2
.end method

.method public get(Lgnu/mapping/Symbol;)Ljava/lang/Object;
    .locals 3
    .param p1, "sym"    # Lgnu/mapping/Symbol;

    .prologue
    .line 195
    sget-object v0, Lgnu/mapping/Location;->UNBOUND:Ljava/lang/String;

    .line 196
    .local v0, "unb":Ljava/lang/String;
    const/4 v2, 0x0

    invoke-virtual {p0, p1, v2, v0}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 197
    .local v1, "val":Ljava/lang/Object;
    if-ne v1, v0, :cond_0

    .line 198
    new-instance v2, Lgnu/mapping/UnboundLocationException;

    invoke-direct {v2, p1}, Lgnu/mapping/UnboundLocationException;-><init>(Ljava/lang/Object;)V

    throw v2

    .line 199
    :cond_0
    return-object v1
.end method

.method public get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;
    .param p3, "defaultValue"    # Ljava/lang/Object;

    .prologue
    .line 175
    invoke-virtual {p0, p1, p2}, Lgnu/mapping/Environment;->lookup(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v0

    .line 176
    .local v0, "loc":Lgnu/mapping/Location;
    if-nez v0, :cond_0

    .line 178
    .end local p3    # "defaultValue":Ljava/lang/Object;
    :goto_0
    return-object p3

    .restart local p3    # "defaultValue":Ljava/lang/Object;
    :cond_0
    invoke-virtual {v0, p3}, Lgnu/mapping/Location;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object p3

    goto :goto_0
.end method

.method public final get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p1, "key"    # Ljava/lang/Object;

    .prologue
    .line 223
    const/4 v1, 0x0

    .line 224
    .local v1, "property":Ljava/lang/Object;
    instance-of v3, p1, Lgnu/mapping/EnvironmentKey;

    if-eqz v3, :cond_0

    move-object v0, p1

    .line 226
    check-cast v0, Lgnu/mapping/EnvironmentKey;

    .line 227
    .local v0, "k":Lgnu/mapping/EnvironmentKey;
    invoke-interface {v0}, Lgnu/mapping/EnvironmentKey;->getKeySymbol()Lgnu/mapping/Symbol;

    move-result-object p1

    .line 228
    .local p1, "key":Lgnu/mapping/Symbol;
    invoke-interface {v0}, Lgnu/mapping/EnvironmentKey;->getKeyProperty()Ljava/lang/Object;

    move-result-object v1

    .line 230
    .end local v0    # "k":Lgnu/mapping/EnvironmentKey;
    .end local v1    # "property":Ljava/lang/Object;
    .end local p1    # "key":Lgnu/mapping/Symbol;
    :cond_0
    instance-of v3, p1, Lgnu/mapping/Symbol;

    if-eqz v3, :cond_1

    check-cast p1, Lgnu/mapping/Symbol;

    move-object v2, p1

    .line 232
    .local v2, "sym":Lgnu/mapping/Symbol;
    :goto_0
    const/4 v3, 0x0

    invoke-virtual {p0, v2, v1, v3}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    return-object v3

    .line 230
    .end local v2    # "sym":Lgnu/mapping/Symbol;
    :cond_1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v2

    goto :goto_0
.end method

.method public final get(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/Object;

    .prologue
    .line 190
    invoke-virtual {p0, p1}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1, p2}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getCanDefine()Z
    .locals 1

    .prologue
    .line 55
    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCanRedefine()Z
    .locals 1

    .prologue
    .line 60
    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final getChecked(Ljava/lang/String;)Ljava/lang/Object;
    .locals 4
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 167
    sget-object v1, Lgnu/mapping/Location;->UNBOUND:Ljava/lang/String;

    invoke-virtual {p0, p1, v1}, Lgnu/mapping/Environment;->get(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 168
    .local v0, "value":Ljava/lang/Object;
    sget-object v1, Lgnu/mapping/Location;->UNBOUND:Ljava/lang/String;

    if-ne v0, v1, :cond_0

    .line 169
    new-instance v1, Lgnu/mapping/UnboundLocationException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " in "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lgnu/mapping/UnboundLocationException;-><init>(Ljava/lang/Object;)V

    throw v1

    .line 170
    :cond_0
    return-object v0
.end method

.method public getFlags()I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    return v0
.end method

.method public final getFunction(Lgnu/mapping/Symbol;)Ljava/lang/Object;
    .locals 3
    .param p1, "sym"    # Lgnu/mapping/Symbol;

    .prologue
    .line 209
    sget-object v0, Lgnu/mapping/Location;->UNBOUND:Ljava/lang/String;

    .line 210
    .local v0, "unb":Ljava/lang/String;
    sget-object v2, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    invoke-virtual {p0, p1, v2, v0}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 211
    .local v1, "val":Ljava/lang/Object;
    if-ne v1, v0, :cond_0

    .line 212
    new-instance v2, Lgnu/mapping/UnboundLocationException;

    invoke-direct {v2, p1}, Lgnu/mapping/UnboundLocationException;-><init>(Ljava/lang/Object;)V

    throw v2

    .line 213
    :cond_0
    return-object v1
.end method

.method public final getFunction(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "defaultValue"    # Ljava/lang/Object;

    .prologue
    .line 204
    sget-object v0, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    invoke-virtual {p0, p1, v0, p2}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final getLocation(Lgnu/mapping/Symbol;)Lgnu/mapping/Location;
    .locals 2
    .param p1, "key"    # Lgnu/mapping/Symbol;

    .prologue
    .line 92
    const/4 v0, 0x0

    const/4 v1, 0x1

    invoke-virtual {p0, p1, v0, v1}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Z)Lgnu/mapping/NamedLocation;

    move-result-object v0

    return-object v0
.end method

.method public final getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;
    .locals 1
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;

    .prologue
    .line 85
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Z)Lgnu/mapping/NamedLocation;

    move-result-object v0

    return-object v0
.end method

.method public final getLocation(Ljava/lang/Object;Z)Lgnu/mapping/Location;
    .locals 4
    .param p1, "key"    # Ljava/lang/Object;
    .param p2, "create"    # Z

    .prologue
    .line 122
    const/4 v1, 0x0

    .line 123
    .local v1, "property":Ljava/lang/Object;
    instance-of v3, p1, Lgnu/mapping/EnvironmentKey;

    if-eqz v3, :cond_0

    move-object v0, p1

    .line 125
    check-cast v0, Lgnu/mapping/EnvironmentKey;

    .line 126
    .local v0, "k":Lgnu/mapping/EnvironmentKey;
    invoke-interface {v0}, Lgnu/mapping/EnvironmentKey;->getKeySymbol()Lgnu/mapping/Symbol;

    move-result-object p1

    .line 127
    .local p1, "key":Lgnu/mapping/Symbol;
    invoke-interface {v0}, Lgnu/mapping/EnvironmentKey;->getKeyProperty()Ljava/lang/Object;

    move-result-object v1

    .line 129
    .end local v0    # "k":Lgnu/mapping/EnvironmentKey;
    .end local v1    # "property":Ljava/lang/Object;
    .end local p1    # "key":Lgnu/mapping/Symbol;
    :cond_0
    instance-of v3, p1, Lgnu/mapping/Symbol;

    if-eqz v3, :cond_1

    check-cast p1, Lgnu/mapping/Symbol;

    move-object v2, p1

    .line 131
    .local v2, "sym":Lgnu/mapping/Symbol;
    :goto_0
    invoke-virtual {p0, v2, v1, p2}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Z)Lgnu/mapping/NamedLocation;

    move-result-object v3

    return-object v3

    .line 129
    .end local v2    # "sym":Lgnu/mapping/Symbol;
    :cond_1
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v2

    goto :goto_0
.end method

.method public abstract getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;IZ)Lgnu/mapping/NamedLocation;
.end method

.method public final getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Z)Lgnu/mapping/NamedLocation;
    .locals 3
    .param p1, "name"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;
    .param p3, "create"    # Z

    .prologue
    .line 116
    invoke-virtual {p1}, Lgnu/mapping/Symbol;->hashCode()I

    move-result v1

    invoke-static {p2}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    xor-int v0, v1, v2

    .line 117
    .local v0, "hash":I
    invoke-virtual {p0, p1, p2, v0, p3}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;IZ)Lgnu/mapping/NamedLocation;

    move-result-object v1

    return-object v1
.end method

.method public getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 337
    invoke-virtual {p0}, Lgnu/mapping/Environment;->defaultNamespace()Lgnu/mapping/Namespace;

    move-result-object v0

    invoke-virtual {v0, p1}, Lgnu/mapping/Namespace;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v0

    return-object v0
.end method

.method protected abstract hasMoreElements(Lgnu/mapping/LocationEnumeration;)Z
.end method

.method public final isBound(Lgnu/mapping/Symbol;)Z
    .locals 1
    .param p1, "key"    # Lgnu/mapping/Symbol;

    .prologue
    .line 144
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lgnu/mapping/Environment;->isBound(Lgnu/mapping/Symbol;Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public isBound(Lgnu/mapping/Symbol;Ljava/lang/Object;)Z
    .locals 2
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;

    .prologue
    .line 136
    invoke-virtual {p0, p1, p2}, Lgnu/mapping/Environment;->lookup(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v0

    .line 137
    .local v0, "loc":Lgnu/mapping/Location;
    if-nez v0, :cond_0

    .line 138
    const/4 v1, 0x0

    .line 139
    :goto_0
    return v1

    :cond_0
    invoke-virtual {v0}, Lgnu/mapping/Location;->isBound()Z

    move-result v1

    goto :goto_0
.end method

.method public final isLocked()Z
    .locals 1

    .prologue
    .line 67
    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    and-int/lit8 v0, v0, 0x3

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final lookup(Lgnu/mapping/Symbol;)Lgnu/mapping/Location;
    .locals 2
    .param p1, "key"    # Lgnu/mapping/Symbol;

    .prologue
    .line 107
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-virtual {p0, p1, v0, v1}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Z)Lgnu/mapping/NamedLocation;

    move-result-object v0

    return-object v0
.end method

.method public final lookup(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;
    .locals 1
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;

    .prologue
    .line 99
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;Z)Lgnu/mapping/NamedLocation;

    move-result-object v0

    return-object v0
.end method

.method public abstract lookup(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Lgnu/mapping/NamedLocation;
.end method

.method public final put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "key"    # Ljava/lang/Object;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 253
    const/4 v2, 0x1

    invoke-virtual {p0, p1, v2}, Lgnu/mapping/Environment;->getLocation(Ljava/lang/Object;Z)Lgnu/mapping/Location;

    move-result-object v0

    .line 254
    .local v0, "loc":Lgnu/mapping/Location;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lgnu/mapping/Location;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 255
    .local v1, "oldValue":Ljava/lang/Object;
    invoke-virtual {v0, p2}, Lgnu/mapping/Location;->set(Ljava/lang/Object;)V

    .line 256
    return-object v1
.end method

.method public final put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 266
    invoke-virtual {p0, p1, p2}, Lgnu/mapping/Environment;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public final put(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    .locals 1
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 248
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, p2}, Lgnu/mapping/Environment;->put(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 249
    return-void
.end method

.method public put(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 2
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;
    .param p3, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 237
    invoke-virtual {p0, p1, p2}, Lgnu/mapping/Environment;->getLocation(Lgnu/mapping/Symbol;Ljava/lang/Object;)Lgnu/mapping/Location;

    move-result-object v0

    .line 238
    .local v0, "loc":Lgnu/mapping/Location;
    invoke-virtual {v0}, Lgnu/mapping/Location;->isConstant()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 239
    invoke-virtual {p0, p1, p2, p3}, Lgnu/mapping/Environment;->define(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 242
    :goto_0
    return-void

    .line 241
    :cond_0
    invoke-virtual {v0, p3}, Lgnu/mapping/Location;->set(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public final putFunction(Lgnu/mapping/Symbol;Ljava/lang/Object;)V
    .locals 1
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 261
    sget-object v0, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    invoke-virtual {p0, p1, v0, p2}, Lgnu/mapping/Environment;->put(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 262
    return-void
.end method

.method public final remove(Lgnu/mapping/EnvironmentKey;)Ljava/lang/Object;
    .locals 5
    .param p1, "key"    # Lgnu/mapping/EnvironmentKey;

    .prologue
    .line 293
    invoke-interface {p1}, Lgnu/mapping/EnvironmentKey;->getKeySymbol()Lgnu/mapping/Symbol;

    move-result-object v2

    .line 294
    .local v2, "symbol":Lgnu/mapping/Symbol;
    invoke-interface {p1}, Lgnu/mapping/EnvironmentKey;->getKeyProperty()Ljava/lang/Object;

    move-result-object v1

    .line 295
    .local v1, "property":Ljava/lang/Object;
    invoke-virtual {v2}, Lgnu/mapping/Symbol;->hashCode()I

    move-result v3

    invoke-static {v1}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v4

    xor-int v0, v3, v4

    .line 296
    .local v0, "hash":I
    invoke-virtual {p0, v2, v1, v0}, Lgnu/mapping/Environment;->remove(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v3

    return-object v3
.end method

.method public final remove(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "symbol"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;

    .prologue
    .line 301
    invoke-virtual {p1}, Lgnu/mapping/Symbol;->hashCode()I

    move-result v1

    invoke-static {p2}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v2

    xor-int v0, v1, v2

    .line 302
    .local v0, "hash":I
    invoke-virtual {p0, p1, p2, v0}, Lgnu/mapping/Environment;->remove(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public remove(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Ljava/lang/Object;
    .locals 2
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;
    .param p3, "hash"    # I

    .prologue
    const/4 v1, 0x0

    .line 280
    invoke-virtual {p0, p1, p2, p3}, Lgnu/mapping/Environment;->unlink(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Lgnu/mapping/Location;

    move-result-object v0

    .line 281
    .local v0, "loc":Lgnu/mapping/Location;
    if-nez v0, :cond_0

    .line 285
    :goto_0
    return-object v1

    .line 283
    :cond_0
    invoke-virtual {v0, v1}, Lgnu/mapping/Location;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 284
    .local v1, "value":Ljava/lang/Object;
    invoke-virtual {v0}, Lgnu/mapping/Location;->undefine()V

    goto :goto_0
.end method

.method public final remove(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 6
    .param p1, "key"    # Ljava/lang/Object;

    .prologue
    .line 317
    const/4 v2, 0x0

    .line 318
    .local v2, "property":Ljava/lang/Object;
    instance-of v4, p1, Lgnu/mapping/EnvironmentKey;

    if-eqz v4, :cond_0

    move-object v1, p1

    .line 320
    check-cast v1, Lgnu/mapping/EnvironmentKey;

    .line 321
    .local v1, "k":Lgnu/mapping/EnvironmentKey;
    invoke-interface {v1}, Lgnu/mapping/EnvironmentKey;->getKeySymbol()Lgnu/mapping/Symbol;

    move-result-object v4

    invoke-interface {v1}, Lgnu/mapping/EnvironmentKey;->getKeyProperty()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {p0, v4, v5}, Lgnu/mapping/Environment;->remove(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 326
    .end local v1    # "k":Lgnu/mapping/EnvironmentKey;
    .end local p1    # "key":Ljava/lang/Object;
    :goto_0
    return-object v4

    .line 323
    .restart local p1    # "key":Ljava/lang/Object;
    :cond_0
    instance-of v4, p1, Lgnu/mapping/Symbol;

    if-eqz v4, :cond_1

    check-cast p1, Lgnu/mapping/Symbol;

    .end local p1    # "key":Ljava/lang/Object;
    move-object v3, p1

    .line 325
    .local v3, "symbol":Lgnu/mapping/Symbol;
    :goto_1
    invoke-virtual {v3}, Lgnu/mapping/Symbol;->hashCode()I

    move-result v4

    invoke-static {v2}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v5

    xor-int v0, v4, v5

    .line 326
    .local v0, "hash":I
    invoke-virtual {p0, v3, v2, v0}, Lgnu/mapping/Environment;->remove(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Ljava/lang/Object;

    move-result-object v4

    goto :goto_0

    .line 323
    .end local v0    # "hash":I
    .end local v3    # "symbol":Lgnu/mapping/Symbol;
    .restart local p1    # "key":Ljava/lang/Object;
    :cond_1
    check-cast p1, Ljava/lang/String;

    .end local p1    # "key":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v3

    goto :goto_1
.end method

.method public final remove(Lgnu/mapping/Symbol;)V
    .locals 2
    .param p1, "sym"    # Lgnu/mapping/Symbol;

    .prologue
    .line 307
    const/4 v0, 0x0

    invoke-virtual {p1}, Lgnu/mapping/Symbol;->hashCode()I

    move-result v1

    invoke-virtual {p0, p1, v0, v1}, Lgnu/mapping/Environment;->remove(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Ljava/lang/Object;

    .line 308
    return-void
.end method

.method public final removeFunction(Lgnu/mapping/Symbol;)V
    .locals 1
    .param p1, "sym"    # Lgnu/mapping/Symbol;

    .prologue
    .line 312
    sget-object v0, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    invoke-virtual {p0, p1, v0}, Lgnu/mapping/Environment;->remove(Lgnu/mapping/Symbol;Ljava/lang/Object;)Ljava/lang/Object;

    .line 313
    return-void
.end method

.method public setCanDefine(Z)V
    .locals 1
    .param p1, "canDefine"    # Z

    .prologue
    .line 57
    if-eqz p1, :cond_0

    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lgnu/mapping/Environment;->flags:I

    :goto_0
    return-void

    :cond_0
    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lgnu/mapping/Environment;->flags:I

    goto :goto_0
.end method

.method public setCanRedefine(Z)V
    .locals 1
    .param p1, "canRedefine"    # Z

    .prologue
    .line 62
    if-eqz p1, :cond_0

    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lgnu/mapping/Environment;->flags:I

    :goto_0
    return-void

    :cond_0
    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lgnu/mapping/Environment;->flags:I

    goto :goto_0
.end method

.method public setFlag(ZI)V
    .locals 2
    .param p1, "setting"    # Z
    .param p2, "flag"    # I

    .prologue
    .line 50
    if-eqz p1, :cond_0

    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    or-int/2addr v0, p2

    iput v0, p0, Lgnu/mapping/Environment;->flags:I

    .line 52
    :goto_0
    return-void

    .line 51
    :cond_0
    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    xor-int/lit8 v1, p2, -0x1

    and-int/2addr v0, v1

    iput v0, p0, Lgnu/mapping/Environment;->flags:I

    goto :goto_0
.end method

.method public final setIndirectDefines()V
    .locals 1

    .prologue
    .line 77
    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    or-int/lit8 v0, v0, 0x20

    iput v0, p0, Lgnu/mapping/Environment;->flags:I

    .line 78
    check-cast p0, Lgnu/mapping/InheritingEnvironment;

    .end local p0    # "this":Lgnu/mapping/Environment;
    const v0, 0x7fffffff

    iput v0, p0, Lgnu/mapping/InheritingEnvironment;->baseTimestamp:I

    .line 79
    return-void
.end method

.method public setLocked()V
    .locals 1

    .prologue
    .line 72
    iget v0, p0, Lgnu/mapping/Environment;->flags:I

    and-int/lit8 v0, v0, -0x8

    iput v0, p0, Lgnu/mapping/Environment;->flags:I

    .line 73
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 433
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "#<environment "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lgnu/mapping/Environment;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x3e

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public toStringVerbose()Ljava/lang/String;
    .locals 1

    .prologue
    .line 439
    invoke-virtual {p0}, Lgnu/mapping/Environment;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public unlink(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Lgnu/mapping/Location;
    .locals 2
    .param p1, "key"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;
    .param p3, "hash"    # I

    .prologue
    .line 274
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "unsupported operation: unlink (aka undefine)"

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
