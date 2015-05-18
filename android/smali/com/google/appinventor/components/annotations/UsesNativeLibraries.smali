.class public interface abstract annotation Lcom/google/appinventor/components/annotations/UsesNativeLibraries;
.super Ljava/lang/Object;
.source "UsesNativeLibraries.java"

# interfaces
.implements Ljava/lang/annotation/Annotation;


# annotations
.annotation system Ldalvik/annotation/AnnotationDefault;
    value = .subannotation Lcom/google/appinventor/components/annotations/UsesNativeLibraries;
        libraries = ""
        v7aLibraries = ""
    .end subannotation
.end annotation

.annotation runtime Ljava/lang/annotation/Retention;
    value = .enum Ljava/lang/annotation/RetentionPolicy;->RUNTIME:Ljava/lang/annotation/RetentionPolicy;
.end annotation

.annotation runtime Ljava/lang/annotation/Target;
    value = {
        .enum Ljava/lang/annotation/ElementType;->TYPE:Ljava/lang/annotation/ElementType;
    }
.end annotation


# virtual methods
.method public abstract libraries()Ljava/lang/String;
.end method

.method public abstract v7aLibraries()Ljava/lang/String;
.end method
