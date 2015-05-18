.class public Lgnu/bytecode/ConstantPool;
.super Ljava/lang/Object;
.source "ConstantPool.java"


# static fields
.field public static final CLASS:B = 0x7t

.field public static final DOUBLE:B = 0x6t

.field public static final FIELDREF:B = 0x9t

.field public static final FLOAT:B = 0x4t

.field public static final INTEGER:B = 0x3t

.field public static final INTERFACE_METHODREF:B = 0xbt

.field public static final LONG:B = 0x5t

.field public static final METHODREF:B = 0xat

.field public static final NAME_AND_TYPE:B = 0xct

.field public static final STRING:B = 0x8t

.field public static final UTF8:B = 0x1t


# instance fields
.field count:I

.field hashTab:[Lgnu/bytecode/CpoolEntry;

.field locked:Z

.field pool:[Lgnu/bytecode/CpoolEntry;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 340
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(Ljava/io/DataInputStream;)V
    .locals 8
    .param p1, "dstr"    # Ljava/io/DataInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x1

    .line 344
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 345
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    iput v5, p0, Lgnu/bytecode/ConstantPool;->count:I

    .line 346
    iget v5, p0, Lgnu/bytecode/ConstantPool;->count:I

    add-int/lit8 v5, v5, 0x1

    new-array v5, v5, [Lgnu/bytecode/CpoolEntry;

    iput-object v5, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    .line 347
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_0
    iget v5, p0, Lgnu/bytecode/ConstantPool;->count:I

    if-gt v1, v5, :cond_0

    .line 349
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readByte()B

    move-result v4

    .line 350
    .local v4, "tag":B
    invoke-virtual {p0, v1, v4}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v0

    .line 351
    .local v0, "entry":Lgnu/bytecode/CpoolEntry;
    packed-switch v4, :pswitch_data_0

    .line 347
    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :goto_1
    :pswitch_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 354
    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :pswitch_1
    check-cast v0, Lgnu/bytecode/CpoolUtf8;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readUTF()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v0, Lgnu/bytecode/CpoolUtf8;->string:Ljava/lang/String;

    goto :goto_1

    .line 358
    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :pswitch_2
    check-cast v0, Lgnu/bytecode/CpoolValue1;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readInt()I

    move-result v5

    iput v5, v0, Lgnu/bytecode/CpoolValue1;->value:I

    goto :goto_1

    .line 362
    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :pswitch_3
    check-cast v0, Lgnu/bytecode/CpoolValue2;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readLong()J

    move-result-wide v5

    iput-wide v5, v0, Lgnu/bytecode/CpoolValue2;->value:J

    .line 363
    add-int/lit8 v1, v1, 0x1

    .line 364
    goto :goto_1

    .line 366
    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :pswitch_4
    check-cast v0, Lgnu/bytecode/CpoolClass;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v5

    invoke-virtual {p0, v5, v7}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v5

    check-cast v5, Lgnu/bytecode/CpoolUtf8;

    iput-object v5, v0, Lgnu/bytecode/CpoolClass;->name:Lgnu/bytecode/CpoolUtf8;

    goto :goto_1

    .line 370
    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :pswitch_5
    check-cast v0, Lgnu/bytecode/CpoolString;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v5

    invoke-virtual {p0, v5, v7}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v5

    check-cast v5, Lgnu/bytecode/CpoolUtf8;

    iput-object v5, v0, Lgnu/bytecode/CpoolString;->str:Lgnu/bytecode/CpoolUtf8;

    goto :goto_1

    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :pswitch_6
    move-object v3, v0

    .line 376
    check-cast v3, Lgnu/bytecode/CpoolRef;

    .line 377
    .local v3, "ref":Lgnu/bytecode/CpoolRef;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v5

    invoke-virtual {p0, v5}, Lgnu/bytecode/ConstantPool;->getForcedClass(I)Lgnu/bytecode/CpoolClass;

    move-result-object v5

    iput-object v5, v3, Lgnu/bytecode/CpoolRef;->clas:Lgnu/bytecode/CpoolClass;

    .line 378
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v5

    const/16 v6, 0xc

    invoke-virtual {p0, v5, v6}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v5

    check-cast v5, Lgnu/bytecode/CpoolNameAndType;

    iput-object v5, v3, Lgnu/bytecode/CpoolRef;->nameAndType:Lgnu/bytecode/CpoolNameAndType;

    goto :goto_1

    .end local v3    # "ref":Lgnu/bytecode/CpoolRef;
    :pswitch_7
    move-object v2, v0

    .line 382
    check-cast v2, Lgnu/bytecode/CpoolNameAndType;

    .line 383
    .local v2, "ntyp":Lgnu/bytecode/CpoolNameAndType;
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v5

    invoke-virtual {p0, v5, v7}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v5

    check-cast v5, Lgnu/bytecode/CpoolUtf8;

    iput-object v5, v2, Lgnu/bytecode/CpoolNameAndType;->name:Lgnu/bytecode/CpoolUtf8;

    .line 384
    invoke-virtual {p1}, Ljava/io/DataInputStream;->readUnsignedShort()I

    move-result v5

    invoke-virtual {p0, v5, v7}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v5

    check-cast v5, Lgnu/bytecode/CpoolUtf8;

    iput-object v5, v2, Lgnu/bytecode/CpoolNameAndType;->type:Lgnu/bytecode/CpoolUtf8;

    goto :goto_1

    .line 388
    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    .end local v2    # "ntyp":Lgnu/bytecode/CpoolNameAndType;
    .end local v4    # "tag":B
    :cond_0
    return-void

    .line 351
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_2
        :pswitch_3
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method


# virtual methods
.method public addClass(Lgnu/bytecode/CpoolUtf8;)Lgnu/bytecode/CpoolClass;
    .locals 6
    .param p1, "name"    # Lgnu/bytecode/CpoolUtf8;

    .prologue
    .line 109
    invoke-static {p1}, Lgnu/bytecode/CpoolClass;->hashCode(Lgnu/bytecode/CpoolUtf8;)I

    move-result v2

    .line 112
    .local v2, "h":I
    iget-object v4, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    if-nez v4, :cond_0

    .line 113
    invoke-virtual {p0}, Lgnu/bytecode/ConstantPool;->rehash()V

    .line 114
    :cond_0
    const v4, 0x7fffffff

    and-int/2addr v4, v2

    iget-object v5, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    array-length v5, v5

    rem-int v3, v4, v5

    .line 115
    .local v3, "index":I
    iget-object v4, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    aget-object v1, v4, v3

    .local v1, "entry":Lgnu/bytecode/CpoolEntry;
    :goto_0
    if-eqz v1, :cond_2

    .line 117
    iget v4, v1, Lgnu/bytecode/CpoolEntry;->hash:I

    if-ne v2, v4, :cond_1

    instance-of v4, v1, Lgnu/bytecode/CpoolClass;

    if-eqz v4, :cond_1

    move-object v0, v1

    .line 119
    check-cast v0, Lgnu/bytecode/CpoolClass;

    .line 120
    .local v0, "ent":Lgnu/bytecode/CpoolClass;
    iget-object v4, v0, Lgnu/bytecode/CpoolClass;->name:Lgnu/bytecode/CpoolUtf8;

    if-ne v4, p1, :cond_1

    .line 124
    .end local v0    # "ent":Lgnu/bytecode/CpoolClass;
    :goto_1
    return-object v0

    .line 115
    :cond_1
    iget-object v1, v1, Lgnu/bytecode/CpoolEntry;->next:Lgnu/bytecode/CpoolEntry;

    goto :goto_0

    .line 124
    :cond_2
    new-instance v0, Lgnu/bytecode/CpoolClass;

    invoke-direct {v0, p0, v2, p1}, Lgnu/bytecode/CpoolClass;-><init>(Lgnu/bytecode/ConstantPool;ILgnu/bytecode/CpoolUtf8;)V

    goto :goto_1
.end method

.method public addClass(Lgnu/bytecode/ObjectType;)Lgnu/bytecode/CpoolClass;
    .locals 2
    .param p1, "otype"    # Lgnu/bytecode/ObjectType;

    .prologue
    .line 102
    invoke-virtual {p1}, Lgnu/bytecode/ObjectType;->getInternalName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lgnu/bytecode/ConstantPool;->addUtf8(Ljava/lang/String;)Lgnu/bytecode/CpoolUtf8;

    move-result-object v1

    invoke-virtual {p0, v1}, Lgnu/bytecode/ConstantPool;->addClass(Lgnu/bytecode/CpoolUtf8;)Lgnu/bytecode/CpoolClass;

    move-result-object v0

    .line 103
    .local v0, "entry":Lgnu/bytecode/CpoolClass;
    iput-object p1, v0, Lgnu/bytecode/CpoolClass;->clas:Lgnu/bytecode/ObjectType;

    .line 104
    return-object v0
.end method

.method public addDouble(D)Lgnu/bytecode/CpoolValue2;
    .locals 3
    .param p1, "val"    # D

    .prologue
    .line 184
    const/4 v0, 0x6

    invoke-static {p1, p2}, Ljava/lang/Double;->doubleToLongBits(D)J

    move-result-wide v1

    invoke-virtual {p0, v0, v1, v2}, Lgnu/bytecode/ConstantPool;->addValue2(IJ)Lgnu/bytecode/CpoolValue2;

    move-result-object v0

    return-object v0
.end method

.method public addFieldRef(Lgnu/bytecode/Field;)Lgnu/bytecode/CpoolRef;
    .locals 4
    .param p1, "field"    # Lgnu/bytecode/Field;

    .prologue
    .line 283
    iget-object v3, p1, Lgnu/bytecode/Field;->owner:Lgnu/bytecode/ClassType;

    invoke-virtual {p0, v3}, Lgnu/bytecode/ConstantPool;->addClass(Lgnu/bytecode/ObjectType;)Lgnu/bytecode/CpoolClass;

    move-result-object v0

    .line 284
    .local v0, "clas":Lgnu/bytecode/CpoolClass;
    const/16 v2, 0x9

    .line 285
    .local v2, "tag":I
    invoke-virtual {p0, p1}, Lgnu/bytecode/ConstantPool;->addNameAndType(Lgnu/bytecode/Field;)Lgnu/bytecode/CpoolNameAndType;

    move-result-object v1

    .line 286
    .local v1, "nameType":Lgnu/bytecode/CpoolNameAndType;
    invoke-virtual {p0, v2, v0, v1}, Lgnu/bytecode/ConstantPool;->addRef(ILgnu/bytecode/CpoolClass;Lgnu/bytecode/CpoolNameAndType;)Lgnu/bytecode/CpoolRef;

    move-result-object v3

    return-object v3
.end method

.method public addFloat(F)Lgnu/bytecode/CpoolValue1;
    .locals 2
    .param p1, "val"    # F

    .prologue
    .line 179
    const/4 v0, 0x4

    invoke-static {p1}, Ljava/lang/Float;->floatToIntBits(F)I

    move-result v1

    invoke-virtual {p0, v0, v1}, Lgnu/bytecode/ConstantPool;->addValue1(II)Lgnu/bytecode/CpoolValue1;

    move-result-object v0

    return-object v0
.end method

.method public addInt(I)Lgnu/bytecode/CpoolValue1;
    .locals 1
    .param p1, "val"    # I

    .prologue
    .line 169
    const/4 v0, 0x3

    invoke-virtual {p0, v0, p1}, Lgnu/bytecode/ConstantPool;->addValue1(II)Lgnu/bytecode/CpoolValue1;

    move-result-object v0

    return-object v0
.end method

.method public addLong(J)Lgnu/bytecode/CpoolValue2;
    .locals 1
    .param p1, "val"    # J

    .prologue
    .line 174
    const/4 v0, 0x5

    invoke-virtual {p0, v0, p1, p2}, Lgnu/bytecode/ConstantPool;->addValue2(IJ)Lgnu/bytecode/CpoolValue2;

    move-result-object v0

    return-object v0
.end method

.method public addMethodRef(Lgnu/bytecode/Method;)Lgnu/bytecode/CpoolRef;
    .locals 4
    .param p1, "method"    # Lgnu/bytecode/Method;

    .prologue
    .line 271
    iget-object v3, p1, Lgnu/bytecode/Method;->classfile:Lgnu/bytecode/ClassType;

    invoke-virtual {p0, v3}, Lgnu/bytecode/ConstantPool;->addClass(Lgnu/bytecode/ObjectType;)Lgnu/bytecode/CpoolClass;

    move-result-object v0

    .line 273
    .local v0, "clas":Lgnu/bytecode/CpoolClass;
    invoke-virtual {p1}, Lgnu/bytecode/Method;->getDeclaringClass()Lgnu/bytecode/ClassType;

    move-result-object v3

    invoke-virtual {v3}, Lgnu/bytecode/ClassType;->getModifiers()I

    move-result v3

    and-int/lit16 v3, v3, 0x200

    if-nez v3, :cond_0

    .line 274
    const/16 v2, 0xa

    .line 277
    .local v2, "tag":I
    :goto_0
    invoke-virtual {p0, p1}, Lgnu/bytecode/ConstantPool;->addNameAndType(Lgnu/bytecode/Method;)Lgnu/bytecode/CpoolNameAndType;

    move-result-object v1

    .line 278
    .local v1, "nameType":Lgnu/bytecode/CpoolNameAndType;
    invoke-virtual {p0, v2, v0, v1}, Lgnu/bytecode/ConstantPool;->addRef(ILgnu/bytecode/CpoolClass;Lgnu/bytecode/CpoolNameAndType;)Lgnu/bytecode/CpoolRef;

    move-result-object v3

    return-object v3

    .line 276
    .end local v1    # "nameType":Lgnu/bytecode/CpoolNameAndType;
    .end local v2    # "tag":I
    :cond_0
    const/16 v2, 0xb

    .restart local v2    # "tag":I
    goto :goto_0
.end method

.method public addNameAndType(Lgnu/bytecode/CpoolUtf8;Lgnu/bytecode/CpoolUtf8;)Lgnu/bytecode/CpoolNameAndType;
    .locals 5
    .param p1, "name"    # Lgnu/bytecode/CpoolUtf8;
    .param p2, "type"    # Lgnu/bytecode/CpoolUtf8;

    .prologue
    .line 229
    invoke-static {p1, p2}, Lgnu/bytecode/CpoolNameAndType;->hashCode(Lgnu/bytecode/CpoolUtf8;Lgnu/bytecode/CpoolUtf8;)I

    move-result v1

    .line 232
    .local v1, "h":I
    iget-object v3, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    if-nez v3, :cond_0

    .line 233
    invoke-virtual {p0}, Lgnu/bytecode/ConstantPool;->rehash()V

    .line 234
    :cond_0
    const v3, 0x7fffffff

    and-int/2addr v3, v1

    iget-object v4, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    array-length v4, v4

    rem-int v2, v3, v4

    .line 235
    .local v2, "index":I
    iget-object v3, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    aget-object v0, v3, v2

    .local v0, "entry":Lgnu/bytecode/CpoolEntry;
    :goto_0
    if-eqz v0, :cond_2

    .line 237
    iget v3, v0, Lgnu/bytecode/CpoolEntry;->hash:I

    if-ne v1, v3, :cond_1

    instance-of v3, v0, Lgnu/bytecode/CpoolNameAndType;

    if-eqz v3, :cond_1

    move-object v3, v0

    check-cast v3, Lgnu/bytecode/CpoolNameAndType;

    iget-object v3, v3, Lgnu/bytecode/CpoolNameAndType;->name:Lgnu/bytecode/CpoolUtf8;

    if-ne v3, p1, :cond_1

    move-object v3, v0

    check-cast v3, Lgnu/bytecode/CpoolNameAndType;

    iget-object v3, v3, Lgnu/bytecode/CpoolNameAndType;->type:Lgnu/bytecode/CpoolUtf8;

    if-ne v3, p2, :cond_1

    .line 241
    check-cast v0, Lgnu/bytecode/CpoolNameAndType;

    .line 243
    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :goto_1
    return-object v0

    .line 235
    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :cond_1
    iget-object v0, v0, Lgnu/bytecode/CpoolEntry;->next:Lgnu/bytecode/CpoolEntry;

    goto :goto_0

    .line 243
    :cond_2
    new-instance v0, Lgnu/bytecode/CpoolNameAndType;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-direct {v0, p0, v1, p1, p2}, Lgnu/bytecode/CpoolNameAndType;-><init>(Lgnu/bytecode/ConstantPool;ILgnu/bytecode/CpoolUtf8;Lgnu/bytecode/CpoolUtf8;)V

    goto :goto_1
.end method

.method public addNameAndType(Lgnu/bytecode/Field;)Lgnu/bytecode/CpoolNameAndType;
    .locals 3
    .param p1, "field"    # Lgnu/bytecode/Field;

    .prologue
    .line 221
    invoke-virtual {p1}, Lgnu/bytecode/Field;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lgnu/bytecode/ConstantPool;->addUtf8(Ljava/lang/String;)Lgnu/bytecode/CpoolUtf8;

    move-result-object v0

    .line 222
    .local v0, "name":Lgnu/bytecode/CpoolUtf8;
    invoke-virtual {p1}, Lgnu/bytecode/Field;->getSignature()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lgnu/bytecode/ConstantPool;->addUtf8(Ljava/lang/String;)Lgnu/bytecode/CpoolUtf8;

    move-result-object v1

    .line 223
    .local v1, "type":Lgnu/bytecode/CpoolUtf8;
    invoke-virtual {p0, v0, v1}, Lgnu/bytecode/ConstantPool;->addNameAndType(Lgnu/bytecode/CpoolUtf8;Lgnu/bytecode/CpoolUtf8;)Lgnu/bytecode/CpoolNameAndType;

    move-result-object v2

    return-object v2
.end method

.method public addNameAndType(Lgnu/bytecode/Method;)Lgnu/bytecode/CpoolNameAndType;
    .locals 3
    .param p1, "method"    # Lgnu/bytecode/Method;

    .prologue
    .line 214
    invoke-virtual {p1}, Lgnu/bytecode/Method;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lgnu/bytecode/ConstantPool;->addUtf8(Ljava/lang/String;)Lgnu/bytecode/CpoolUtf8;

    move-result-object v0

    .line 215
    .local v0, "name":Lgnu/bytecode/CpoolUtf8;
    invoke-virtual {p1}, Lgnu/bytecode/Method;->getSignature()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v2}, Lgnu/bytecode/ConstantPool;->addUtf8(Ljava/lang/String;)Lgnu/bytecode/CpoolUtf8;

    move-result-object v1

    .line 216
    .local v1, "type":Lgnu/bytecode/CpoolUtf8;
    invoke-virtual {p0, v0, v1}, Lgnu/bytecode/ConstantPool;->addNameAndType(Lgnu/bytecode/CpoolUtf8;Lgnu/bytecode/CpoolUtf8;)Lgnu/bytecode/CpoolNameAndType;

    move-result-object v2

    return-object v2
.end method

.method public addRef(ILgnu/bytecode/CpoolClass;Lgnu/bytecode/CpoolNameAndType;)Lgnu/bytecode/CpoolRef;
    .locals 9
    .param p1, "tag"    # I
    .param p2, "clas"    # Lgnu/bytecode/CpoolClass;
    .param p3, "nameAndType"    # Lgnu/bytecode/CpoolNameAndType;

    .prologue
    .line 249
    invoke-static {p2, p3}, Lgnu/bytecode/CpoolRef;->hashCode(Lgnu/bytecode/CpoolClass;Lgnu/bytecode/CpoolNameAndType;)I

    move-result v2

    .line 252
    .local v2, "h":I
    iget-object v0, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    if-nez v0, :cond_0

    .line 253
    invoke-virtual {p0}, Lgnu/bytecode/ConstantPool;->rehash()V

    .line 254
    :cond_0
    const v0, 0x7fffffff

    and-int/2addr v0, v2

    iget-object v1, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    array-length v1, v1

    rem-int v7, v0, v1

    .line 255
    .local v7, "index":I
    iget-object v0, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    aget-object v6, v0, v7

    .local v6, "entry":Lgnu/bytecode/CpoolEntry;
    :goto_0
    if-eqz v6, :cond_2

    .line 257
    iget v0, v6, Lgnu/bytecode/CpoolEntry;->hash:I

    if-ne v2, v0, :cond_1

    instance-of v0, v6, Lgnu/bytecode/CpoolRef;

    if-eqz v0, :cond_1

    move-object v8, v6

    .line 259
    check-cast v8, Lgnu/bytecode/CpoolRef;

    .line 260
    .local v8, "ref":Lgnu/bytecode/CpoolRef;
    iget v0, v8, Lgnu/bytecode/CpoolRef;->tag:I

    if-ne v0, p1, :cond_1

    iget-object v0, v8, Lgnu/bytecode/CpoolRef;->clas:Lgnu/bytecode/CpoolClass;

    if-ne v0, p2, :cond_1

    iget-object v0, v8, Lgnu/bytecode/CpoolRef;->nameAndType:Lgnu/bytecode/CpoolNameAndType;

    if-ne v0, p3, :cond_1

    .line 266
    .end local v8    # "ref":Lgnu/bytecode/CpoolRef;
    :goto_1
    return-object v8

    .line 255
    :cond_1
    iget-object v6, v6, Lgnu/bytecode/CpoolEntry;->next:Lgnu/bytecode/CpoolEntry;

    goto :goto_0

    .line 266
    :cond_2
    new-instance v0, Lgnu/bytecode/CpoolRef;

    move-object v1, p0

    move v3, p1

    move-object v4, p2

    move-object v5, p3

    invoke-direct/range {v0 .. v5}, Lgnu/bytecode/CpoolRef;-><init>(Lgnu/bytecode/ConstantPool;IILgnu/bytecode/CpoolClass;Lgnu/bytecode/CpoolNameAndType;)V

    move-object v8, v0

    goto :goto_1
.end method

.method public addString(Lgnu/bytecode/CpoolUtf8;)Lgnu/bytecode/CpoolString;
    .locals 6
    .param p1, "str"    # Lgnu/bytecode/CpoolUtf8;

    .prologue
    .line 194
    invoke-static {p1}, Lgnu/bytecode/CpoolString;->hashCode(Lgnu/bytecode/CpoolUtf8;)I

    move-result v2

    .line 197
    .local v2, "h":I
    iget-object v4, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    if-nez v4, :cond_0

    .line 198
    invoke-virtual {p0}, Lgnu/bytecode/ConstantPool;->rehash()V

    .line 199
    :cond_0
    const v4, 0x7fffffff

    and-int/2addr v4, v2

    iget-object v5, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    array-length v5, v5

    rem-int v3, v4, v5

    .line 200
    .local v3, "index":I
    iget-object v4, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    aget-object v1, v4, v3

    .local v1, "entry":Lgnu/bytecode/CpoolEntry;
    :goto_0
    if-eqz v1, :cond_2

    .line 202
    iget v4, v1, Lgnu/bytecode/CpoolEntry;->hash:I

    if-ne v2, v4, :cond_1

    instance-of v4, v1, Lgnu/bytecode/CpoolString;

    if-eqz v4, :cond_1

    move-object v0, v1

    .line 204
    check-cast v0, Lgnu/bytecode/CpoolString;

    .line 205
    .local v0, "ent":Lgnu/bytecode/CpoolString;
    iget-object v4, v0, Lgnu/bytecode/CpoolString;->str:Lgnu/bytecode/CpoolUtf8;

    if-ne v4, p1, :cond_1

    .line 209
    .end local v0    # "ent":Lgnu/bytecode/CpoolString;
    :goto_1
    return-object v0

    .line 200
    :cond_1
    iget-object v1, v1, Lgnu/bytecode/CpoolEntry;->next:Lgnu/bytecode/CpoolEntry;

    goto :goto_0

    .line 209
    :cond_2
    new-instance v0, Lgnu/bytecode/CpoolString;

    invoke-direct {v0, p0, v2, p1}, Lgnu/bytecode/CpoolString;-><init>(Lgnu/bytecode/ConstantPool;ILgnu/bytecode/CpoolUtf8;)V

    goto :goto_1
.end method

.method public final addString(Ljava/lang/String;)Lgnu/bytecode/CpoolString;
    .locals 1
    .param p1, "string"    # Ljava/lang/String;

    .prologue
    .line 189
    invoke-virtual {p0, p1}, Lgnu/bytecode/ConstantPool;->addUtf8(Ljava/lang/String;)Lgnu/bytecode/CpoolUtf8;

    move-result-object v0

    invoke-virtual {p0, v0}, Lgnu/bytecode/ConstantPool;->addString(Lgnu/bytecode/CpoolUtf8;)Lgnu/bytecode/CpoolString;

    move-result-object v0

    return-object v0
.end method

.method public addUtf8(Ljava/lang/String;)Lgnu/bytecode/CpoolUtf8;
    .locals 7
    .param p1, "s"    # Ljava/lang/String;

    .prologue
    .line 78
    invoke-virtual {p1}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object p1

    .line 79
    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v1

    .line 82
    .local v1, "h":I
    iget-object v4, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    if-nez v4, :cond_0

    .line 83
    invoke-virtual {p0}, Lgnu/bytecode/ConstantPool;->rehash()V

    .line 85
    :cond_0
    const v4, 0x7fffffff

    and-int/2addr v4, v1

    iget-object v5, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    array-length v5, v5

    rem-int v2, v4, v5

    .line 86
    .local v2, "index":I
    iget-object v4, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    aget-object v0, v4, v2

    .local v0, "entry":Lgnu/bytecode/CpoolEntry;
    :goto_0
    if-eqz v0, :cond_2

    .line 88
    iget v4, v0, Lgnu/bytecode/CpoolEntry;->hash:I

    if-ne v1, v4, :cond_1

    instance-of v4, v0, Lgnu/bytecode/CpoolUtf8;

    if-eqz v4, :cond_1

    move-object v3, v0

    .line 90
    check-cast v3, Lgnu/bytecode/CpoolUtf8;

    .line 91
    .local v3, "utf":Lgnu/bytecode/CpoolUtf8;
    iget-object v4, v3, Lgnu/bytecode/CpoolUtf8;->string:Ljava/lang/String;

    if-ne v4, p1, :cond_1

    .line 97
    .end local v3    # "utf":Lgnu/bytecode/CpoolUtf8;
    :goto_1
    return-object v3

    .line 86
    :cond_1
    iget-object v0, v0, Lgnu/bytecode/CpoolEntry;->next:Lgnu/bytecode/CpoolEntry;

    goto :goto_0

    .line 95
    :cond_2
    iget-boolean v4, p0, Lgnu/bytecode/ConstantPool;->locked:Z

    if-eqz v4, :cond_3

    .line 96
    new-instance v4, Ljava/lang/Error;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "adding new Utf8 entry to locked contant pool: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v4

    .line 97
    :cond_3
    new-instance v3, Lgnu/bytecode/CpoolUtf8;

    invoke-direct {v3, p0, v1, p1}, Lgnu/bytecode/CpoolUtf8;-><init>(Lgnu/bytecode/ConstantPool;ILjava/lang/String;)V

    goto :goto_1
.end method

.method addValue1(II)Lgnu/bytecode/CpoolValue1;
    .locals 6
    .param p1, "tag"    # I
    .param p2, "val"    # I

    .prologue
    .line 129
    invoke-static {p2}, Lgnu/bytecode/CpoolValue1;->hashCode(I)I

    move-result v2

    .line 132
    .local v2, "h":I
    iget-object v4, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    if-nez v4, :cond_0

    .line 133
    invoke-virtual {p0}, Lgnu/bytecode/ConstantPool;->rehash()V

    .line 134
    :cond_0
    const v4, 0x7fffffff

    and-int/2addr v4, v2

    iget-object v5, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    array-length v5, v5

    rem-int v3, v4, v5

    .line 135
    .local v3, "index":I
    iget-object v4, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    aget-object v1, v4, v3

    .local v1, "entry":Lgnu/bytecode/CpoolEntry;
    :goto_0
    if-eqz v1, :cond_2

    .line 137
    iget v4, v1, Lgnu/bytecode/CpoolEntry;->hash:I

    if-ne v2, v4, :cond_1

    instance-of v4, v1, Lgnu/bytecode/CpoolValue1;

    if-eqz v4, :cond_1

    move-object v0, v1

    .line 139
    check-cast v0, Lgnu/bytecode/CpoolValue1;

    .line 140
    .local v0, "ent":Lgnu/bytecode/CpoolValue1;
    iget v4, v0, Lgnu/bytecode/CpoolValue1;->tag:I

    if-ne v4, p1, :cond_1

    iget v4, v0, Lgnu/bytecode/CpoolValue1;->value:I

    if-ne v4, p2, :cond_1

    .line 144
    .end local v0    # "ent":Lgnu/bytecode/CpoolValue1;
    :goto_1
    return-object v0

    .line 135
    :cond_1
    iget-object v1, v1, Lgnu/bytecode/CpoolEntry;->next:Lgnu/bytecode/CpoolEntry;

    goto :goto_0

    .line 144
    :cond_2
    new-instance v0, Lgnu/bytecode/CpoolValue1;

    invoke-direct {v0, p0, p1, v2, p2}, Lgnu/bytecode/CpoolValue1;-><init>(Lgnu/bytecode/ConstantPool;III)V

    goto :goto_1
.end method

.method addValue2(IJ)Lgnu/bytecode/CpoolValue2;
    .locals 9
    .param p1, "tag"    # I
    .param p2, "val"    # J

    .prologue
    .line 149
    invoke-static {p2, p3}, Lgnu/bytecode/CpoolValue2;->hashCode(J)I

    move-result v3

    .line 152
    .local v3, "h":I
    iget-object v0, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    if-nez v0, :cond_0

    .line 153
    invoke-virtual {p0}, Lgnu/bytecode/ConstantPool;->rehash()V

    .line 154
    :cond_0
    const v0, 0x7fffffff

    and-int/2addr v0, v3

    iget-object v1, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    array-length v1, v1

    rem-int v8, v0, v1

    .line 155
    .local v8, "index":I
    iget-object v0, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    aget-object v7, v0, v8

    .local v7, "entry":Lgnu/bytecode/CpoolEntry;
    :goto_0
    if-eqz v7, :cond_2

    .line 157
    iget v0, v7, Lgnu/bytecode/CpoolEntry;->hash:I

    if-ne v3, v0, :cond_1

    instance-of v0, v7, Lgnu/bytecode/CpoolValue2;

    if-eqz v0, :cond_1

    move-object v6, v7

    .line 159
    check-cast v6, Lgnu/bytecode/CpoolValue2;

    .line 160
    .local v6, "ent":Lgnu/bytecode/CpoolValue2;
    iget v0, v6, Lgnu/bytecode/CpoolValue2;->tag:I

    if-ne v0, p1, :cond_1

    iget-wide v0, v6, Lgnu/bytecode/CpoolValue2;->value:J

    cmp-long v0, v0, p2

    if-nez v0, :cond_1

    .line 164
    .end local v6    # "ent":Lgnu/bytecode/CpoolValue2;
    :goto_1
    return-object v6

    .line 155
    :cond_1
    iget-object v7, v7, Lgnu/bytecode/CpoolEntry;->next:Lgnu/bytecode/CpoolEntry;

    goto :goto_0

    .line 164
    :cond_2
    new-instance v0, Lgnu/bytecode/CpoolValue2;

    move-object v1, p0

    move v2, p1

    move-wide v4, p2

    invoke-direct/range {v0 .. v5}, Lgnu/bytecode/CpoolValue2;-><init>(Lgnu/bytecode/ConstantPool;IIJ)V

    move-object v6, v0

    goto :goto_1
.end method

.method public final getCount()I
    .locals 1

    .prologue
    .line 34
    iget v0, p0, Lgnu/bytecode/ConstantPool;->count:I

    return v0
.end method

.method getForced(II)Lgnu/bytecode/CpoolEntry;
    .locals 4
    .param p1, "index"    # I
    .param p2, "tag"    # I

    .prologue
    .line 307
    const v1, 0xffff

    and-int/2addr p1, v1

    .line 308
    iget-object v1, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    aget-object v0, v1, p1

    .line 309
    .local v0, "entry":Lgnu/bytecode/CpoolEntry;
    if-nez v0, :cond_2

    .line 311
    iget-boolean v1, p0, Lgnu/bytecode/ConstantPool;->locked:Z

    if-eqz v1, :cond_0

    .line 312
    new-instance v1, Ljava/lang/Error;

    const-string v2, "adding new entry to locked contant pool"

    invoke-direct {v1, v2}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v1

    .line 313
    :cond_0
    packed-switch p2, :pswitch_data_0

    .line 327
    :goto_0
    :pswitch_0
    iget-object v1, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    aput-object v0, v1, p1

    .line 328
    iput p1, v0, Lgnu/bytecode/CpoolEntry;->index:I

    .line 332
    :cond_1
    return-object v0

    .line 315
    :pswitch_1
    new-instance v0, Lgnu/bytecode/CpoolUtf8;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-direct {v0}, Lgnu/bytecode/CpoolUtf8;-><init>()V

    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    goto :goto_0

    .line 317
    :pswitch_2
    new-instance v0, Lgnu/bytecode/CpoolValue1;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-direct {v0, p2}, Lgnu/bytecode/CpoolValue1;-><init>(I)V

    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    goto :goto_0

    .line 319
    :pswitch_3
    new-instance v0, Lgnu/bytecode/CpoolValue2;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-direct {v0, p2}, Lgnu/bytecode/CpoolValue2;-><init>(I)V

    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    goto :goto_0

    .line 320
    :pswitch_4
    new-instance v0, Lgnu/bytecode/CpoolClass;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-direct {v0}, Lgnu/bytecode/CpoolClass;-><init>()V

    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    goto :goto_0

    .line 321
    :pswitch_5
    new-instance v0, Lgnu/bytecode/CpoolString;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-direct {v0}, Lgnu/bytecode/CpoolString;-><init>()V

    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    goto :goto_0

    .line 324
    :pswitch_6
    new-instance v0, Lgnu/bytecode/CpoolRef;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-direct {v0, p2}, Lgnu/bytecode/CpoolRef;-><init>(I)V

    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    goto :goto_0

    .line 325
    :pswitch_7
    new-instance v0, Lgnu/bytecode/CpoolNameAndType;

    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    invoke-direct {v0}, Lgnu/bytecode/CpoolNameAndType;-><init>()V

    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    goto :goto_0

    .line 330
    :cond_2
    invoke-virtual {v0}, Lgnu/bytecode/CpoolEntry;->getTag()I

    move-result v1

    if-eq v1, p2, :cond_1

    .line 331
    new-instance v1, Ljava/lang/ClassFormatError;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "conflicting constant pool tags at "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/ClassFormatError;-><init>(Ljava/lang/String;)V

    throw v1

    .line 313
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_2
        :pswitch_3
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_6
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method getForcedClass(I)Lgnu/bytecode/CpoolClass;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 337
    const/4 v0, 0x7

    invoke-virtual {p0, p1, v0}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v0

    check-cast v0, Lgnu/bytecode/CpoolClass;

    return-object v0
.end method

.method public final getPoolEntry(I)Lgnu/bytecode/CpoolEntry;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 43
    iget-object v0, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    aget-object v0, v0, p1

    return-object v0
.end method

.method rehash()V
    .locals 4

    .prologue
    .line 52
    iget-object v2, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    if-nez v2, :cond_1

    iget v2, p0, Lgnu/bytecode/ConstantPool;->count:I

    if-lez v2, :cond_1

    .line 55
    iget-object v2, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    array-length v1, v2

    .local v1, "i":I
    :cond_0
    :goto_0
    add-int/lit8 v1, v1, -0x1

    if-ltz v1, :cond_1

    .line 57
    iget-object v2, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    aget-object v0, v2, v1

    .line 59
    .local v0, "entry":Lgnu/bytecode/CpoolEntry;
    if-eqz v0, :cond_0

    .line 60
    invoke-virtual {v0}, Lgnu/bytecode/CpoolEntry;->hashCode()I

    goto :goto_0

    .line 64
    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    .end local v1    # "i":I
    :cond_1
    iget v2, p0, Lgnu/bytecode/ConstantPool;->count:I

    const/4 v3, 0x5

    if-ge v2, v3, :cond_3

    const/16 v2, 0x65

    :goto_1
    new-array v2, v2, [Lgnu/bytecode/CpoolEntry;

    iput-object v2, p0, Lgnu/bytecode/ConstantPool;->hashTab:[Lgnu/bytecode/CpoolEntry;

    .line 65
    iget-object v2, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    if-eqz v2, :cond_4

    .line 67
    iget-object v2, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    array-length v1, v2

    .restart local v1    # "i":I
    :cond_2
    :goto_2
    add-int/lit8 v1, v1, -0x1

    if-ltz v1, :cond_4

    .line 69
    iget-object v2, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    aget-object v0, v2, v1

    .line 70
    .restart local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    if-eqz v0, :cond_2

    .line 71
    invoke-virtual {v0, p0}, Lgnu/bytecode/CpoolEntry;->add_hashed(Lgnu/bytecode/ConstantPool;)V

    goto :goto_2

    .line 64
    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    .end local v1    # "i":I
    :cond_3
    iget v2, p0, Lgnu/bytecode/ConstantPool;->count:I

    mul-int/lit8 v2, v2, 0x2

    goto :goto_1

    .line 74
    :cond_4
    return-void
.end method

.method write(Ljava/io/DataOutputStream;)V
    .locals 3
    .param p1, "dstr"    # Ljava/io/DataOutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 291
    iget v2, p0, Lgnu/bytecode/ConstantPool;->count:I

    add-int/lit8 v2, v2, 0x1

    invoke-virtual {p1, v2}, Ljava/io/DataOutputStream;->writeShort(I)V

    .line 292
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_0
    iget v2, p0, Lgnu/bytecode/ConstantPool;->count:I

    if-gt v1, v2, :cond_1

    .line 294
    iget-object v2, p0, Lgnu/bytecode/ConstantPool;->pool:[Lgnu/bytecode/CpoolEntry;

    aget-object v0, v2, v1

    .line 295
    .local v0, "entry":Lgnu/bytecode/CpoolEntry;
    if-eqz v0, :cond_0

    .line 296
    invoke-virtual {v0, p1}, Lgnu/bytecode/CpoolEntry;->write(Ljava/io/DataOutputStream;)V

    .line 292
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 298
    .end local v0    # "entry":Lgnu/bytecode/CpoolEntry;
    :cond_1
    const/4 v2, 0x1

    iput-boolean v2, p0, Lgnu/bytecode/ConstantPool;->locked:Z

    .line 299
    return-void
.end method
