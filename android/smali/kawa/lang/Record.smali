.class public Lkawa/lang/Record;
.super Ljava/lang/Object;
.source "Record.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static getField(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;
    .locals 4
    .param p0, "clas"    # Ljava/lang/Class;
    .param p1, "fname"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/NoSuchFieldException;
        }
    .end annotation

    .prologue
    .line 44
    invoke-static {p0}, Lgnu/bytecode/Type;->make(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v0

    check-cast v0, Lgnu/bytecode/ClassType;

    .line 45
    .local v0, "ctype":Lgnu/bytecode/ClassType;
    invoke-virtual {v0}, Lgnu/bytecode/ClassType;->getFields()Lgnu/bytecode/Field;

    move-result-object v1

    .line 46
    .local v1, "fld":Lgnu/bytecode/Field;
    :goto_0
    if-eqz v1, :cond_2

    .line 48
    invoke-virtual {v1}, Lgnu/bytecode/Field;->getModifiers()I

    move-result v2

    and-int/lit8 v2, v2, 0x9

    const/4 v3, 0x1

    if-eq v2, v3, :cond_1

    .line 46
    :cond_0
    invoke-virtual {v1}, Lgnu/bytecode/Field;->getNext()Lgnu/bytecode/Field;

    move-result-object v1

    goto :goto_0

    .line 51
    :cond_1
    invoke-virtual {v1}, Lgnu/bytecode/Field;->getSourceName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 53
    invoke-virtual {v1}, Lgnu/bytecode/Field;->getReflectField()Ljava/lang/reflect/Field;

    move-result-object v2

    return-object v2

    .line 55
    :cond_2
    new-instance v2, Ljava/lang/NoSuchFieldException;

    invoke-direct {v2}, Ljava/lang/NoSuchFieldException;-><init>()V

    throw v2
.end method

.method public static isRecord(Ljava/lang/Object;)Z
    .locals 1
    .param p0, "obj"    # Ljava/lang/Object;

    .prologue
    .line 17
    instance-of v0, p0, Lkawa/lang/Record;

    return v0
.end method

.method public static makeRecordType(Ljava/lang/String;Lgnu/lists/LList;)Lgnu/bytecode/ClassType;
    .locals 24
    .param p0, "name"    # Ljava/lang/String;
    .param p1, "fnames"    # Lgnu/lists/LList;

    .prologue
    .line 171
    const-string v20, "kawa.lang.Record"

    invoke-static/range {v20 .. v20}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v18

    .line 172
    .local v18, "superClass":Lgnu/bytecode/ClassType;
    invoke-static/range {p0 .. p0}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 173
    .local v13, "mangledName":Ljava/lang/String;
    new-instance v6, Lgnu/bytecode/ClassType;

    invoke-direct {v6, v13}, Lgnu/bytecode/ClassType;-><init>(Ljava/lang/String;)V

    .line 174
    .local v6, "clas":Lgnu/bytecode/ClassType;
    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/bytecode/ClassType;->setSuper(Lgnu/bytecode/ClassType;)V

    .line 175
    const/16 v20, 0x21

    move/from16 v0, v20

    invoke-virtual {v6, v0}, Lgnu/bytecode/ClassType;->setModifiers(I)V

    .line 178
    const-string v20, "<init>"

    sget-object v21, Lgnu/bytecode/Type;->typeArray0:[Lgnu/bytecode/Type;

    sget-object v22, Lgnu/bytecode/Type;->voidType:Lgnu/bytecode/PrimType;

    const/16 v23, 0x1

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    move/from16 v3, v23

    invoke-virtual {v6, v0, v1, v2, v3}, Lgnu/bytecode/ClassType;->addMethod(Ljava/lang/String;[Lgnu/bytecode/Type;Lgnu/bytecode/Type;I)Lgnu/bytecode/Method;

    move-result-object v8

    .line 180
    .local v8, "constructor":Lgnu/bytecode/Method;
    const-string v20, "<init>"

    sget-object v21, Lgnu/bytecode/Type;->typeArray0:[Lgnu/bytecode/Type;

    sget-object v22, Lgnu/bytecode/Type;->voidType:Lgnu/bytecode/PrimType;

    const/16 v23, 0x1

    move-object/from16 v0, v18

    move-object/from16 v1, v20

    move-object/from16 v2, v21

    move-object/from16 v3, v22

    move/from16 v4, v23

    invoke-virtual {v0, v1, v2, v3, v4}, Lgnu/bytecode/ClassType;->addMethod(Ljava/lang/String;[Lgnu/bytecode/Type;Lgnu/bytecode/Type;I)Lgnu/bytecode/Method;

    move-result-object v19

    .line 183
    .local v19, "superConstructor":Lgnu/bytecode/Method;
    invoke-virtual {v8}, Lgnu/bytecode/Method;->startCode()Lgnu/bytecode/CodeAttr;

    move-result-object v7

    .line 184
    .local v7, "code":Lgnu/bytecode/CodeAttr;
    invoke-virtual {v7}, Lgnu/bytecode/CodeAttr;->emitPushThis()V

    .line 185
    move-object/from16 v0, v19

    invoke-virtual {v7, v0}, Lgnu/bytecode/CodeAttr;->emitInvokeSpecial(Lgnu/bytecode/Method;)V

    .line 186
    invoke-virtual {v7}, Lgnu/bytecode/CodeAttr;->emitReturn()V

    .line 187
    move-object/from16 v0, p0

    invoke-virtual {v0, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v20

    if-nez v20, :cond_0

    .line 189
    const-string v20, "getTypeName"

    sget-object v21, Lgnu/bytecode/Type;->typeArray0:[Lgnu/bytecode/Type;

    sget-object v22, Lgnu/expr/Compilation;->typeString:Lgnu/bytecode/ClassType;

    const/16 v23, 0x1

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move-object/from16 v2, v22

    move/from16 v3, v23

    invoke-virtual {v6, v0, v1, v2, v3}, Lgnu/bytecode/ClassType;->addMethod(Ljava/lang/String;[Lgnu/bytecode/Type;Lgnu/bytecode/Type;I)Lgnu/bytecode/Method;

    move-result-object v14

    .line 191
    .local v14, "meth":Lgnu/bytecode/Method;
    invoke-virtual {v14}, Lgnu/bytecode/Method;->startCode()Lgnu/bytecode/CodeAttr;

    move-result-object v7

    .line 192
    move-object/from16 v0, p0

    invoke-virtual {v7, v0}, Lgnu/bytecode/CodeAttr;->emitPushString(Ljava/lang/String;)V

    .line 193
    invoke-virtual {v7}, Lgnu/bytecode/CodeAttr;->emitReturn()V

    .line 198
    .end local v14    # "meth":Lgnu/bytecode/Method;
    :cond_0
    :goto_0
    sget-object v20, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    move-object/from16 v0, p1

    move-object/from16 v1, v20

    if-eq v0, v1, :cond_1

    move-object/from16 v16, p1

    .line 200
    check-cast v16, Lgnu/lists/Pair;

    .line 201
    .local v16, "pair":Lgnu/lists/Pair;
    invoke-virtual/range {v16 .. v16}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v20

    invoke-virtual/range {v20 .. v20}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    .line 203
    .local v11, "fname":Ljava/lang/String;
    invoke-static {v11}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v20

    sget-object v21, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    const/16 v22, 0x1

    move-object/from16 v0, v20

    move-object/from16 v1, v21

    move/from16 v2, v22

    invoke-virtual {v6, v0, v1, v2}, Lgnu/bytecode/ClassType;->addField(Ljava/lang/String;Lgnu/bytecode/Type;I)Lgnu/bytecode/Field;

    move-result-object v10

    .line 205
    .local v10, "fld":Lgnu/bytecode/Field;
    invoke-virtual {v11}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v20

    move-object/from16 v0, v20

    invoke-virtual {v10, v0}, Lgnu/bytecode/Field;->setSourceName(Ljava/lang/String;)V

    .line 206
    invoke-virtual/range {v16 .. v16}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object p1

    .end local p1    # "fnames":Lgnu/lists/LList;
    check-cast p1, Lgnu/lists/LList;

    .line 207
    .restart local p1    # "fnames":Lgnu/lists/LList;
    goto :goto_0

    .line 215
    .end local v10    # "fld":Lgnu/bytecode/Field;
    .end local v11    # "fname":Ljava/lang/String;
    .end local v16    # "pair":Lgnu/lists/Pair;
    :cond_1
    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v5, v0, [[B

    .line 216
    .local v5, "arrays":[[B
    const/16 v20, 0x1

    move/from16 v0, v20

    new-array v15, v0, [Ljava/lang/String;

    .line 217
    .local v15, "names":[Ljava/lang/String;
    const/16 v20, 0x0

    aput-object v13, v15, v20

    .line 218
    const/16 v20, 0x0

    invoke-virtual {v6}, Lgnu/bytecode/ClassType;->writeToArray()[B

    move-result-object v21

    aput-object v21, v5, v20

    .line 219
    new-instance v12, Lgnu/bytecode/ArrayClassLoader;

    invoke-direct {v12, v15, v5}, Lgnu/bytecode/ArrayClassLoader;-><init>([Ljava/lang/String;[[B)V

    .line 222
    .local v12, "loader":Lgnu/bytecode/ArrayClassLoader;
    :try_start_0
    invoke-virtual {v12, v13}, Lgnu/bytecode/ArrayClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v17

    .line 223
    .local v17, "reflectClass":Ljava/lang/Class;
    move-object/from16 v0, v17

    invoke-static {v0, v6}, Lgnu/bytecode/Type;->registerTypeForClass(Ljava/lang/Class;Lgnu/bytecode/Type;)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 224
    return-object v6

    .line 226
    .end local v17    # "reflectClass":Ljava/lang/Class;
    :catch_0
    move-exception v9

    .line 228
    .local v9, "ex":Ljava/lang/ClassNotFoundException;
    new-instance v20, Ljava/lang/InternalError;

    invoke-virtual {v9}, Ljava/lang/ClassNotFoundException;->toString()Ljava/lang/String;

    move-result-object v21

    invoke-direct/range {v20 .. v21}, Ljava/lang/InternalError;-><init>(Ljava/lang/String;)V

    throw v20
.end method

.method public static set1(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 7
    .param p0, "record"    # Ljava/lang/Object;
    .param p1, "fname"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 83
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 86
    .local v0, "clas":Ljava/lang/Class;
    :try_start_0
    invoke-static {v0, p1}, Lkawa/lang/Record;->getField(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    .line 87
    .local v2, "fld":Ljava/lang/reflect/Field;
    invoke-virtual {v2, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 88
    .local v3, "old":Ljava/lang/Object;
    invoke-virtual {v2, p0, p2}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    .line 89
    return-object v3

    .line 91
    .end local v2    # "fld":Ljava/lang/reflect/Field;
    .end local v3    # "old":Ljava/lang/Object;
    :catch_0
    move-exception v1

    .line 94
    .local v1, "ex":Ljava/lang/NoSuchFieldException;
    new-instance v4, Lkawa/lang/GenericError;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "no such field "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " in "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lkawa/lang/GenericError;-><init>(Ljava/lang/String;)V

    throw v4

    .line 96
    .end local v1    # "ex":Ljava/lang/NoSuchFieldException;
    :catch_1
    move-exception v1

    .line 98
    .local v1, "ex":Ljava/lang/IllegalAccessException;
    new-instance v4, Lkawa/lang/GenericError;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "illegal access for field "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lkawa/lang/GenericError;-><init>(Ljava/lang/String;)V

    throw v4
.end method

.method public static typeFieldNames(Lgnu/bytecode/ClassType;)Lgnu/lists/LList;
    .locals 1
    .param p0, "ctype"    # Lgnu/bytecode/ClassType;

    .prologue
    .line 275
    invoke-virtual {p0}, Lgnu/bytecode/ClassType;->getReflectClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lkawa/lang/Record;->typeFieldNames(Ljava/lang/Class;)Lgnu/lists/LList;

    move-result-object v0

    return-object v0
.end method

.method public static typeFieldNames(Ljava/lang/Class;)Lgnu/lists/LList;
    .locals 8
    .param p0, "clas"    # Ljava/lang/Class;

    .prologue
    .line 234
    sget-object v3, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    .line 257
    .local v3, "list":Lgnu/lists/LList;
    invoke-static {p0}, Lgnu/bytecode/Type;->make(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v0

    check-cast v0, Lgnu/bytecode/ClassType;

    .line 258
    .local v0, "ctype":Lgnu/bytecode/ClassType;
    invoke-virtual {v0}, Lgnu/bytecode/ClassType;->getFields()Lgnu/bytecode/Field;

    move-result-object v1

    .line 259
    .local v1, "field":Lgnu/bytecode/Field;
    new-instance v5, Ljava/util/Vector;

    const/16 v6, 0x64

    invoke-direct {v5, v6}, Ljava/util/Vector;-><init>(I)V

    .line 260
    .local v5, "vec":Ljava/util/Vector;
    :goto_0
    if-eqz v1, :cond_1

    .line 262
    invoke-virtual {v1}, Lgnu/bytecode/Field;->getModifiers()I

    move-result v6

    and-int/lit8 v6, v6, 0x9

    const/4 v7, 0x1

    if-ne v6, v7, :cond_0

    .line 264
    invoke-virtual {v1}, Lgnu/bytecode/Field;->getSourceName()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lgnu/mapping/SimpleSymbol;->valueOf(Ljava/lang/String;)Lgnu/mapping/SimpleSymbol;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 260
    :cond_0
    invoke-virtual {v1}, Lgnu/bytecode/Field;->getNext()Lgnu/bytecode/Field;

    move-result-object v1

    goto :goto_0

    .line 266
    :cond_1
    invoke-virtual {v5}, Ljava/util/Vector;->size()I

    move-result v2

    .local v2, "i":I
    move-object v4, v3

    .end local v3    # "list":Lgnu/lists/LList;
    .local v4, "list":Lgnu/lists/LList;
    :goto_1
    add-int/lit8 v2, v2, -0x1

    if-ltz v2, :cond_2

    .line 268
    new-instance v3, Lgnu/lists/Pair;

    invoke-virtual {v5, v2}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v6

    invoke-direct {v3, v6, v4}, Lgnu/lists/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .end local v4    # "list":Lgnu/lists/LList;
    .restart local v3    # "list":Lgnu/lists/LList;
    move-object v4, v3

    .end local v3    # "list":Lgnu/lists/LList;
    .restart local v4    # "list":Lgnu/lists/LList;
    goto :goto_1

    .line 270
    :cond_2
    return-object v4
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 10
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 104
    if-ne p0, p1, :cond_1

    .line 130
    :cond_0
    :goto_0
    return v7

    .line 106
    :cond_1
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    .line 107
    .local v4, "thisClass":Ljava/lang/Class;
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v9

    if-eq v9, v4, :cond_3

    :cond_2
    move v7, v8

    .line 108
    goto :goto_0

    .line 109
    :cond_3
    invoke-static {v4}, Lgnu/bytecode/Type;->make(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v0

    check-cast v0, Lgnu/bytecode/ClassType;

    .line 110
    .local v0, "ctype":Lgnu/bytecode/ClassType;
    invoke-virtual {v0}, Lgnu/bytecode/ClassType;->getFields()Lgnu/bytecode/Field;

    move-result-object v3

    .line 111
    .local v3, "fld":Lgnu/bytecode/Field;
    :goto_1
    if-eqz v3, :cond_0

    .line 113
    invoke-virtual {v3}, Lgnu/bytecode/Field;->getModifiers()I

    move-result v9

    and-int/lit8 v9, v9, 0x9

    if-eq v9, v7, :cond_5

    .line 111
    :cond_4
    invoke-virtual {v3}, Lgnu/bytecode/Field;->getNext()Lgnu/bytecode/Field;

    move-result-object v3

    goto :goto_1

    .line 119
    :cond_5
    :try_start_0
    invoke-virtual {v3}, Lgnu/bytecode/Field;->getReflectField()Ljava/lang/reflect/Field;

    move-result-object v2

    .line 120
    .local v2, "field":Ljava/lang/reflect/Field;
    invoke-virtual {v2, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 121
    .local v5, "value1":Ljava/lang/Object;
    invoke-virtual {v2, p1}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 127
    .local v6, "value2":Ljava/lang/Object;
    invoke-virtual {v5, v6}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_4

    move v7, v8

    .line 128
    goto :goto_0

    .line 123
    .end local v2    # "field":Ljava/lang/reflect/Field;
    .end local v5    # "value1":Ljava/lang/Object;
    .end local v6    # "value2":Ljava/lang/Object;
    :catch_0
    move-exception v1

    .line 125
    .local v1, "ex":Ljava/lang/Exception;
    new-instance v7, Lgnu/mapping/WrappedException;

    invoke-direct {v7, v1}, Lgnu/mapping/WrappedException;-><init>(Ljava/lang/Throwable;)V

    throw v7
.end method

.method public get(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .param p1, "fname"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/Object;

    .prologue
    .line 60
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 63
    .local v0, "clas":Ljava/lang/Class;
    :try_start_0
    invoke-static {v0, p1}, Lkawa/lang/Record;->getField(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v2

    return-object v2

    .line 65
    :catch_0
    move-exception v1

    .line 68
    .local v1, "ex":Ljava/lang/NoSuchFieldException;
    new-instance v2, Lkawa/lang/GenericError;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "no such field "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " in "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lkawa/lang/GenericError;-><init>(Ljava/lang/String;)V

    throw v2

    .line 70
    .end local v1    # "ex":Ljava/lang/NoSuchFieldException;
    :catch_1
    move-exception v1

    .line 72
    .local v1, "ex":Ljava/lang/IllegalAccessException;
    new-instance v2, Lkawa/lang/GenericError;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "illegal access for field "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lkawa/lang/GenericError;-><init>(Ljava/lang/String;)V

    throw v2
.end method

.method public getTypeName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 14
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hashCode()I
    .locals 7

    .prologue
    .line 21
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getFields()[Ljava/lang/reflect/Field;

    move-result-object v2

    .line 22
    .local v2, "fields":[Ljava/lang/reflect/Field;
    const/16 v3, 0x3039

    .line 23
    .local v3, "hash":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    array-length v6, v2

    if-ge v4, v6, :cond_1

    .line 25
    aget-object v1, v2, v4

    .line 29
    .local v1, "field":Ljava/lang/reflect/Field;
    :try_start_0
    invoke-virtual {v1, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 35
    .local v5, "value":Ljava/lang/Object;
    if-eqz v5, :cond_0

    .line 36
    invoke-virtual {v5}, Ljava/lang/Object;->hashCode()I

    move-result v6

    xor-int/2addr v3, v6

    .line 23
    .end local v5    # "value":Ljava/lang/Object;
    :cond_0
    :goto_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 31
    :catch_0
    move-exception v0

    .line 33
    .local v0, "ex":Ljava/lang/IllegalAccessException;
    goto :goto_1

    .line 38
    .end local v0    # "ex":Ljava/lang/IllegalAccessException;
    .end local v1    # "field":Ljava/lang/reflect/Field;
    :cond_1
    return v3
.end method

.method public print(Ljava/io/PrintWriter;)V
    .locals 1
    .param p1, "ps"    # Ljava/io/PrintWriter;

    .prologue
    .line 166
    invoke-virtual {p0}, Lkawa/lang/Record;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 167
    return-void
.end method

.method public put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "fname"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 78
    invoke-static {p0, p1, p2}, Lkawa/lang/Record;->set1(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 8

    .prologue
    .line 135
    new-instance v0, Ljava/lang/StringBuffer;

    const/16 v6, 0xc8

    invoke-direct {v0, v6}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 136
    .local v0, "buf":Ljava/lang/StringBuffer;
    const-string v6, "#<"

    invoke-virtual {v0, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 137
    invoke-virtual {p0}, Lkawa/lang/Record;->getTypeName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 138
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-static {v6}, Lgnu/bytecode/Type;->make(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v1

    check-cast v1, Lgnu/bytecode/ClassType;

    .line 139
    .local v1, "ctype":Lgnu/bytecode/ClassType;
    invoke-virtual {v1}, Lgnu/bytecode/ClassType;->getFields()Lgnu/bytecode/Field;

    move-result-object v4

    .line 140
    .local v4, "fld":Lgnu/bytecode/Field;
    :goto_0
    if-eqz v4, :cond_1

    .line 142
    invoke-virtual {v4}, Lgnu/bytecode/Field;->getModifiers()I

    move-result v6

    and-int/lit8 v6, v6, 0x9

    const/4 v7, 0x1

    if-eq v6, v7, :cond_0

    .line 140
    :goto_1
    invoke-virtual {v4}, Lgnu/bytecode/Field;->getNext()Lgnu/bytecode/Field;

    move-result-object v4

    goto :goto_0

    .line 148
    :cond_0
    :try_start_0
    invoke-virtual {v4}, Lgnu/bytecode/Field;->getReflectField()Ljava/lang/reflect/Field;

    move-result-object v3

    .line 149
    .local v3, "field":Ljava/lang/reflect/Field;
    invoke-virtual {v3, p0}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 155
    .end local v3    # "field":Ljava/lang/reflect/Field;
    :goto_2
    const/16 v6, 0x20

    invoke-virtual {v0, v6}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 156
    invoke-virtual {v4}, Lgnu/bytecode/Field;->getSourceName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 157
    const-string v6, ": "

    invoke-virtual {v0, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 158
    invoke-virtual {v0, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    goto :goto_1

    .line 151
    :catch_0
    move-exception v2

    .line 153
    .local v2, "ex":Ljava/lang/Exception;
    const-string v5, "#<illegal-access>"

    .local v5, "value":Ljava/lang/String;
    goto :goto_2

    .line 160
    .end local v2    # "ex":Ljava/lang/Exception;
    .end local v5    # "value":Ljava/lang/String;
    :cond_1
    const-string v6, ">"

    invoke-virtual {v0, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 161
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method
