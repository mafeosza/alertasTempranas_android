.class public Lcom/google/appinventor/components/runtime/EventDispatcher;
.super Ljava/lang/Object;
.source "EventDispatcher.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/appinventor/components/runtime/EventDispatcher$1;,
        Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;,
        Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;
    }
.end annotation


# static fields
.field private static final DEBUG:Z

.field private static final mapDispatchDelegateToEventRegistry:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/google/appinventor/components/runtime/HandlesEventDispatching;",
            "Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 81
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/google/appinventor/components/runtime/EventDispatcher;->mapDispatchDelegateToEventRegistry:Ljava/util/Map;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    return-void
.end method

.method private static varargs delegateDispatchEvent(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;Ljava/util/Set;Lcom/google/appinventor/components/runtime/Component;[Ljava/lang/Object;)Z
    .locals 5
    .param p0, "dispatchDelegate"    # Lcom/google/appinventor/components/runtime/HandlesEventDispatching;
    .param p2, "component"    # Lcom/google/appinventor/components/runtime/Component;
    .param p3, "args"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/appinventor/components/runtime/HandlesEventDispatching;",
            "Ljava/util/Set",
            "<",
            "Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;",
            ">;",
            "Lcom/google/appinventor/components/runtime/Component;",
            "[",
            "Ljava/lang/Object;",
            ")Z"
        }
    .end annotation

    .prologue
    .line 218
    .local p1, "eventClosures":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;>;"
    const/4 v0, 0x0

    .line 219
    .local v0, "dispatched":Z
    invoke-interface {p1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;

    .line 220
    .local v1, "eventClosure":Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;
    # getter for: Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;->componentId:Ljava/lang/String;
    invoke-static {v1}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;->access$200(Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;)Ljava/lang/String;

    move-result-object v3

    # getter for: Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;->eventName:Ljava/lang/String;
    invoke-static {v1}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;->access$300(Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {p0, p2, v3, v4, p3}, Lcom/google/appinventor/components/runtime/HandlesEventDispatching;->dispatchEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 228
    const/4 v0, 0x1

    goto :goto_0

    .line 231
    .end local v1    # "eventClosure":Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;
    :cond_1
    return v0
.end method

.method public static varargs dispatchEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;[Ljava/lang/Object;)Z
    .locals 5
    .param p0, "component"    # Lcom/google/appinventor/components/runtime/Component;
    .param p1, "eventName"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 192
    const/4 v1, 0x0

    .line 193
    .local v1, "dispatched":Z
    invoke-interface {p0}, Lcom/google/appinventor/components/runtime/Component;->getDispatchDelegate()Lcom/google/appinventor/components/runtime/HandlesEventDispatching;

    move-result-object v0

    .line 194
    .local v0, "dispatchDelegate":Lcom/google/appinventor/components/runtime/HandlesEventDispatching;
    invoke-interface {v0, p0, p1}, Lcom/google/appinventor/components/runtime/HandlesEventDispatching;->canDispatchEvent(Lcom/google/appinventor/components/runtime/Component;Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 195
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/EventDispatcher;->getEventRegistry(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;)Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;

    move-result-object v2

    .line 196
    .local v2, "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    # getter for: Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->eventClosuresMap:Ljava/util/HashMap;
    invoke-static {v2}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->access$000(Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;)Ljava/util/HashMap;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Set;

    .line 197
    .local v3, "eventClosures":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;>;"
    if-eqz v3, :cond_0

    invoke-interface {v3}, Ljava/util/Set;->size()I

    move-result v4

    if-lez v4, :cond_0

    .line 198
    invoke-static {v0, v3, p0, p2}, Lcom/google/appinventor/components/runtime/EventDispatcher;->delegateDispatchEvent(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;Ljava/util/Set;Lcom/google/appinventor/components/runtime/Component;[Ljava/lang/Object;)Z

    move-result v1

    .line 201
    .end local v2    # "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    .end local v3    # "eventClosures":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;>;"
    :cond_0
    return v1
.end method

.method private static getEventRegistry(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;)Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    .locals 2
    .param p0, "dispatchDelegate"    # Lcom/google/appinventor/components/runtime/HandlesEventDispatching;

    .prologue
    .line 87
    sget-object v1, Lcom/google/appinventor/components/runtime/EventDispatcher;->mapDispatchDelegateToEventRegistry:Ljava/util/Map;

    invoke-interface {v1, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;

    .line 88
    .local v0, "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    if-nez v0, :cond_0

    .line 89
    new-instance v0, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;

    .end local v0    # "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    invoke-direct {v0, p0}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;-><init>(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;)V

    .line 90
    .restart local v0    # "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    sget-object v1, Lcom/google/appinventor/components/runtime/EventDispatcher;->mapDispatchDelegateToEventRegistry:Ljava/util/Map;

    invoke-interface {v1, p0, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 92
    :cond_0
    return-object v0
.end method

.method public static makeFullEventName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "componentId"    # Ljava/lang/String;
    .param p1, "eventName"    # Ljava/lang/String;

    .prologue
    .line 240
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x24

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static registerEventForDelegation(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p0, "dispatchDelegate"    # Lcom/google/appinventor/components/runtime/HandlesEventDispatching;
    .param p1, "componentId"    # Ljava/lang/String;
    .param p2, "eventName"    # Ljava/lang/String;

    .prologue
    .line 111
    invoke-static {p0}, Lcom/google/appinventor/components/runtime/EventDispatcher;->getEventRegistry(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;)Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;

    move-result-object v0

    .line 112
    .local v0, "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    # getter for: Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->eventClosuresMap:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->access$000(Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;)Ljava/util/HashMap;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Set;

    .line 113
    .local v1, "eventClosures":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;>;"
    if-nez v1, :cond_0

    .line 114
    new-instance v1, Ljava/util/HashSet;

    .end local v1    # "eventClosures":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;>;"
    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    .line 115
    .restart local v1    # "eventClosures":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;>;"
    # getter for: Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->eventClosuresMap:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->access$000(Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;)Ljava/util/HashMap;

    move-result-object v2

    invoke-virtual {v2, p2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 118
    :cond_0
    new-instance v2, Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;

    const/4 v3, 0x0

    invoke-direct {v2, p1, p2, v3}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/google/appinventor/components/runtime/EventDispatcher$1;)V

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 123
    return-void
.end method

.method public static removeDispatchDelegate(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;)V
    .locals 2
    .param p0, "dispatchDelegate"    # Lcom/google/appinventor/components/runtime/HandlesEventDispatching;

    .prologue
    .line 175
    invoke-static {p0}, Lcom/google/appinventor/components/runtime/EventDispatcher;->removeEventRegistry(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;)Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;

    move-result-object v0

    .line 176
    .local v0, "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    if-eqz v0, :cond_0

    .line 177
    # getter for: Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->eventClosuresMap:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->access$000(Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/HashMap;->clear()V

    .line 179
    :cond_0
    return-void
.end method

.method private static removeEventRegistry(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;)Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    .locals 1
    .param p0, "dispatchDelegate"    # Lcom/google/appinventor/components/runtime/HandlesEventDispatching;

    .prologue
    .line 96
    sget-object v0, Lcom/google/appinventor/components/runtime/EventDispatcher;->mapDispatchDelegateToEventRegistry:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;

    return-object v0
.end method

.method public static unregisterAllEventsForDelegation()V
    .locals 3

    .prologue
    .line 162
    sget-object v2, Lcom/google/appinventor/components/runtime/EventDispatcher;->mapDispatchDelegateToEventRegistry:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;

    .line 163
    .local v0, "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    # getter for: Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->eventClosuresMap:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->access$000(Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;)Ljava/util/HashMap;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    goto :goto_0

    .line 165
    .end local v0    # "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    :cond_0
    return-void
.end method

.method public static unregisterEventForDelegation(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "dispatchDelegate"    # Lcom/google/appinventor/components/runtime/HandlesEventDispatching;
    .param p1, "componentId"    # Ljava/lang/String;
    .param p2, "eventName"    # Ljava/lang/String;

    .prologue
    .line 136
    invoke-static {p0}, Lcom/google/appinventor/components/runtime/EventDispatcher;->getEventRegistry(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;)Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;

    move-result-object v0

    .line 137
    .local v0, "er":Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
    # getter for: Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->eventClosuresMap:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->access$000(Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;)Ljava/util/HashMap;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Set;

    .line 138
    .local v2, "eventClosures":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;>;"
    if-eqz v2, :cond_0

    invoke-interface {v2}, Ljava/util/Set;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 154
    :cond_0
    return-void

    .line 141
    :cond_1
    new-instance v4, Ljava/util/HashSet;

    invoke-direct {v4}, Ljava/util/HashSet;-><init>()V

    .line 142
    .local v4, "toDelete":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;

    .line 143
    .local v1, "eventClosure":Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;
    # getter for: Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;->componentId:Ljava/lang/String;
    invoke-static {v1}, Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;->access$200(Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 144
    invoke-interface {v4, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 147
    .end local v1    # "eventClosure":Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;
    :cond_3
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;

    .line 152
    .restart local v1    # "eventClosure":Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;
    invoke-interface {v2, v1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    goto :goto_1
.end method
