.class final Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;
.super Ljava/lang/Object;
.source "EventDispatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/appinventor/components/runtime/EventDispatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "EventRegistry"
.end annotation


# instance fields
.field private final dispatchDelegate:Lcom/google/appinventor/components/runtime/HandlesEventDispatching;

.field private final eventClosuresMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Set",
            "<",
            "Lcom/google/appinventor/components/runtime/EventDispatcher$EventClosure;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/google/appinventor/components/runtime/HandlesEventDispatching;)V
    .locals 1
    .param p1, "dispatchDelegate"    # Lcom/google/appinventor/components/runtime/HandlesEventDispatching;

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 70
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->eventClosuresMap:Ljava/util/HashMap;

    .line 74
    iput-object p1, p0, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->dispatchDelegate:Lcom/google/appinventor/components/runtime/HandlesEventDispatching;

    .line 75
    return-void
.end method

.method static synthetic access$000(Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;)Ljava/util/HashMap;
    .locals 1
    .param p0, "x0"    # Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;

    .prologue
    .line 63
    iget-object v0, p0, Lcom/google/appinventor/components/runtime/EventDispatcher$EventRegistry;->eventClosuresMap:Ljava/util/HashMap;

    return-object v0
.end method
