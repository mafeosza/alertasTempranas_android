.class public interface abstract Lorg/json/zip/BitReader;
.super Ljava/lang/Object;
.source "BitReader.java"


# virtual methods
.method public abstract bit()Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract nrBits()J
.end method

.method public abstract pad(I)Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public abstract read(I)I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
