.class public Lgnu/kawa/reflect/SlotSet;
.super Lgnu/mapping/Procedure3;
.source "SlotSet.java"

# interfaces
.implements Lgnu/expr/Inlineable;


# static fields
.field public static final set$Mnfield$Ex:Lgnu/kawa/reflect/SlotSet;

.field public static final set$Mnstatic$Mnfield$Ex:Lgnu/kawa/reflect/SlotSet;

.field public static final setFieldReturnObject:Lgnu/kawa/reflect/SlotSet;

.field static final type1Array:[Lgnu/bytecode/Type;


# instance fields
.field isStatic:Z

.field returnSelf:Z


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 16
    new-instance v0, Lgnu/kawa/reflect/SlotSet;

    const-string v1, "set-field!"

    invoke-direct {v0, v1, v3}, Lgnu/kawa/reflect/SlotSet;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lgnu/kawa/reflect/SlotSet;->set$Mnfield$Ex:Lgnu/kawa/reflect/SlotSet;

    .line 17
    new-instance v0, Lgnu/kawa/reflect/SlotSet;

    const-string v1, "set-static-field!"

    invoke-direct {v0, v1, v2}, Lgnu/kawa/reflect/SlotSet;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lgnu/kawa/reflect/SlotSet;->set$Mnstatic$Mnfield$Ex:Lgnu/kawa/reflect/SlotSet;

    .line 19
    new-instance v0, Lgnu/kawa/reflect/SlotSet;

    const-string v1, "set-field-return-object!"

    invoke-direct {v0, v1, v3}, Lgnu/kawa/reflect/SlotSet;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lgnu/kawa/reflect/SlotSet;->setFieldReturnObject:Lgnu/kawa/reflect/SlotSet;

    .line 21
    sget-object v0, Lgnu/kawa/reflect/SlotSet;->setFieldReturnObject:Lgnu/kawa/reflect/SlotSet;

    iput-boolean v2, v0, Lgnu/kawa/reflect/SlotSet;->returnSelf:Z

    .line 132
    new-array v0, v2, [Lgnu/bytecode/Type;

    sput-object v0, Lgnu/kawa/reflect/SlotSet;->type1Array:[Lgnu/bytecode/Type;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "isStatic"    # Z

    .prologue
    .line 25
    invoke-direct {p0, p1}, Lgnu/mapping/Procedure3;-><init>(Ljava/lang/String;)V

    .line 26
    iput-boolean p2, p0, Lgnu/kawa/reflect/SlotSet;->isStatic:Z

    .line 27
    sget-object v0, Lgnu/mapping/Procedure;->validateApplyKey:Lgnu/mapping/Symbol;

    const-string v1, "gnu.kawa.reflect.CompileReflect:validateApplySlotSet"

    invoke-virtual {p0, v0, v1}, Lgnu/kawa/reflect/SlotSet;->setProperty(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 29
    return-void
.end method

.method public static apply(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 21
    .param p0, "isStatic"    # Z
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "member"    # Ljava/lang/Object;
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 43
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    move-result-object v13

    .line 44
    .local v13, "language":Lgnu/expr/Language;
    const/4 v12, 0x0

    .line 48
    .local v12, "illegalAccess":Z
    move-object/from16 v0, p2

    instance-of v0, v0, Ljava/lang/String;

    move/from16 v18, v0

    if-nez v18, :cond_0

    move-object/from16 v0, p2

    instance-of v0, v0, Lgnu/lists/FString;

    move/from16 v18, v0

    if-nez v18, :cond_0

    move-object/from16 v0, p2

    instance-of v0, v0, Lgnu/mapping/Symbol;

    move/from16 v18, v0

    if-eqz v18, :cond_2

    .line 51
    :cond_0
    invoke-virtual/range {p2 .. p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v14

    .line 52
    .local v14, "name":Ljava/lang/String;
    invoke-static {v14}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 53
    .local v6, "fname":Ljava/lang/String;
    if-eqz p0, :cond_1

    invoke-static/range {p1 .. p1}, Lgnu/kawa/reflect/SlotGet;->coerceToClass(Ljava/lang/Object;)Ljava/lang/Class;

    move-result-object v3

    .line 61
    .local v3, "clas":Ljava/lang/Class;
    :goto_0
    :try_start_0
    move-object/from16 v0, p2

    instance-of v0, v0, Lgnu/bytecode/Field;

    move/from16 v18, v0

    if-eqz v18, :cond_3

    move-object/from16 v0, p2

    check-cast v0, Lgnu/bytecode/Field;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lgnu/bytecode/Field;->getReflectField()Ljava/lang/reflect/Field;

    move-result-object v5

    .line 64
    .local v5, "field":Ljava/lang/reflect/Field;
    :goto_1
    invoke-virtual {v5}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v7

    .line 65
    .local v7, "ftype":Ljava/lang/Class;
    move-object/from16 v0, p3

    invoke-virtual {v13, v7, v0}, Lgnu/expr/Language;->coerceFromObject(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v18

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-virtual {v5, v0, v1}, Ljava/lang/reflect/Field;->set(Ljava/lang/Object;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/NoSuchFieldException; {:try_start_0 .. :try_end_0} :catch_5
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_0

    .line 105
    .end local v5    # "field":Ljava/lang/reflect/Field;
    .end local v7    # "ftype":Ljava/lang/Class;
    :goto_2
    return-void

    .line 53
    .end local v3    # "clas":Ljava/lang/Class;
    :cond_1
    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    goto :goto_0

    .end local v6    # "fname":Ljava/lang/String;
    .end local v14    # "name":Ljava/lang/String;
    :cond_2
    move-object/from16 v18, p2

    .line 56
    check-cast v18, Lgnu/bytecode/Member;

    invoke-interface/range {v18 .. v18}, Lgnu/bytecode/Member;->getName()Ljava/lang/String;

    move-result-object v14

    .restart local v14    # "name":Ljava/lang/String;
    move-object v6, v14

    .line 57
    .restart local v6    # "fname":Ljava/lang/String;
    const/4 v3, 0x0

    .restart local v3    # "clas":Ljava/lang/Class;
    goto :goto_0

    .line 61
    :cond_3
    :try_start_1
    invoke-virtual {v3, v6}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    :try_end_1
    .catch Ljava/lang/NoSuchFieldException; {:try_start_1 .. :try_end_1} :catch_5
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v5

    goto :goto_1

    .line 71
    :catch_0
    move-exception v4

    .line 73
    .local v4, "ex":Ljava/lang/IllegalAccessException;
    const/4 v12, 0x1

    .line 80
    .end local v4    # "ex":Ljava/lang/IllegalAccessException;
    :goto_3
    const/4 v10, 0x0

    .line 82
    .local v10, "getmethod":Ljava/lang/reflect/Method;
    :try_start_2
    move-object/from16 v0, p2

    instance-of v11, v0, Lgnu/bytecode/Method;

    .line 83
    .local v11, "haveSetter":Z
    if-eqz v11, :cond_5

    move-object/from16 v16, v6

    .line 85
    .local v16, "setName":Ljava/lang/String;
    :goto_4
    if-eqz v11, :cond_4

    const-string v18, "set"

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z
    :try_end_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_2 .. :try_end_2} :catch_4

    move-result v18

    if-nez v18, :cond_4

    .line 86
    const/4 v11, 0x0

    .line 89
    :cond_4
    if-eqz v11, :cond_6

    :try_start_3
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "get"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const/16 v19, 0x3

    move-object/from16 v0, v16

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 91
    .local v9, "getName":Ljava/lang/String;
    :goto_5
    sget-object v18, Lgnu/kawa/reflect/SlotGet;->noClasses:[Ljava/lang/Class;

    move-object/from16 v0, v18

    invoke-virtual {v3, v9, v0}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_3 .. :try_end_3} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_3 .. :try_end_3} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_3 .. :try_end_3} :catch_4

    move-result-object v10

    .line 98
    :goto_6
    const/16 v18, 0x1

    :try_start_4
    move/from16 v0, v18

    new-array v15, v0, [Ljava/lang/Class;

    .line 99
    .local v15, "setArgTypes":[Ljava/lang/Class;
    const/16 v18, 0x0

    invoke-virtual {v10}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    move-result-object v19

    aput-object v19, v15, v18

    .line 100
    move-object/from16 v0, v16

    invoke-virtual {v3, v0, v15}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v17

    .line 102
    .local v17, "setmethod":Ljava/lang/reflect/Method;
    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v2, v0, [Ljava/lang/Object;

    .line 103
    .local v2, "args":[Ljava/lang/Object;
    const/16 v18, 0x0

    const/16 v19, 0x0

    aget-object v19, v15, v19

    move-object/from16 v0, v19

    move-object/from16 v1, p3

    invoke-virtual {v13, v0, v1}, Lgnu/expr/Language;->coerceFromObject(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v19

    aput-object v19, v2, v18

    .line 104
    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_4
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_4 .. :try_end_4} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_4 .. :try_end_4} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_4 .. :try_end_4} :catch_4

    goto/16 :goto_2

    .line 107
    .end local v2    # "args":[Ljava/lang/Object;
    .end local v9    # "getName":Ljava/lang/String;
    .end local v11    # "haveSetter":Z
    .end local v15    # "setArgTypes":[Ljava/lang/Class;
    .end local v16    # "setName":Ljava/lang/String;
    .end local v17    # "setmethod":Ljava/lang/reflect/Method;
    :catch_1
    move-exception v4

    .line 109
    .local v4, "ex":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v4}, Ljava/lang/reflect/InvocationTargetException;->getTargetException()Ljava/lang/Throwable;

    move-result-object v18

    invoke-static/range {v18 .. v18}, Lgnu/mapping/WrappedException;->wrapIfNeeded(Ljava/lang/Throwable;)Ljava/lang/RuntimeException;

    move-result-object v18

    throw v18

    .line 83
    .end local v4    # "ex":Ljava/lang/reflect/InvocationTargetException;
    .restart local v11    # "haveSetter":Z
    :cond_5
    :try_start_5
    const-string v18, "set"

    move-object/from16 v0, v18

    invoke-static {v0, v14}, Lgnu/expr/ClassExp;->slotToMethodName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_5
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_5 .. :try_end_5} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_5 .. :try_end_5} :catch_4

    move-result-object v16

    goto :goto_4

    .line 89
    .restart local v16    # "setName":Ljava/lang/String;
    :cond_6
    :try_start_6
    const-string v18, "get"

    move-object/from16 v0, v18

    invoke-static {v0, v14}, Lgnu/expr/ClassExp;->slotToMethodName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_6 .. :try_end_6} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_6 .. :try_end_6} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_6 .. :try_end_6} :catch_4

    move-result-object v9

    goto :goto_5

    .line 92
    :catch_2
    move-exception v8

    .line 93
    .local v8, "getEx":Ljava/lang/Exception;
    if-eqz v11, :cond_7

    :try_start_7
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "is"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const/16 v19, 0x3

    move-object/from16 v0, v16

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 95
    .restart local v9    # "getName":Ljava/lang/String;
    :goto_7
    sget-object v18, Lgnu/kawa/reflect/SlotGet;->noClasses:[Ljava/lang/Class;

    move-object/from16 v0, v18

    invoke-virtual {v3, v9, v0}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v10

    goto :goto_6

    .line 93
    .end local v9    # "getName":Ljava/lang/String;
    :cond_7
    const-string v18, "is"

    move-object/from16 v0, v18

    invoke-static {v0, v14}, Lgnu/expr/ClassExp;->slotToMethodName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_7
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_7 .. :try_end_7} :catch_1
    .catch Ljava/lang/IllegalAccessException; {:try_start_7 .. :try_end_7} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_7 .. :try_end_7} :catch_4

    move-result-object v9

    goto :goto_7

    .line 111
    .end local v8    # "getEx":Ljava/lang/Exception;
    .end local v11    # "haveSetter":Z
    .end local v16    # "setName":Ljava/lang/String;
    :catch_3
    move-exception v4

    .line 113
    .local v4, "ex":Ljava/lang/IllegalAccessException;
    const/4 v12, 0x1

    .line 119
    .end local v4    # "ex":Ljava/lang/IllegalAccessException;
    :goto_8
    if-eqz v12, :cond_8

    .line 120
    new-instance v18, Ljava/lang/RuntimeException;

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "illegal access for field "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v18

    .line 122
    :cond_8
    new-instance v18, Ljava/lang/RuntimeException;

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "no such field "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v0, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    const-string v20, " in "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    invoke-direct/range {v18 .. v19}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v18

    .line 115
    :catch_4
    move-exception v18

    goto :goto_8

    .line 68
    .end local v10    # "getmethod":Ljava/lang/reflect/Method;
    :catch_5
    move-exception v18

    goto/16 :goto_3
.end method

.method static compileSet(Lgnu/mapping/Procedure;Lgnu/bytecode/ObjectType;Lgnu/expr/Expression;Ljava/lang/Object;Lgnu/expr/Compilation;)V
    .locals 13
    .param p0, "thisProc"    # Lgnu/mapping/Procedure;
    .param p1, "ctype"    # Lgnu/bytecode/ObjectType;
    .param p2, "valArg"    # Lgnu/expr/Expression;
    .param p3, "part"    # Ljava/lang/Object;
    .param p4, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 158
    invoke-virtual/range {p4 .. p4}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v1

    .line 159
    .local v1, "code":Lgnu/bytecode/CodeAttr;
    invoke-virtual/range {p4 .. p4}, Lgnu/expr/Compilation;->getLanguage()Lgnu/expr/Language;

    move-result-object v7

    .line 160
    .local v7, "language":Lgnu/expr/Language;
    instance-of v10, p0, Lgnu/kawa/reflect/SlotSet;

    if-eqz v10, :cond_2

    move-object v10, p0

    check-cast v10, Lgnu/kawa/reflect/SlotSet;

    iget-boolean v10, v10, Lgnu/kawa/reflect/SlotSet;->isStatic:Z

    if-eqz v10, :cond_2

    const/4 v4, 0x1

    .line 162
    .local v4, "isStatic":Z
    :goto_0
    move-object/from16 v0, p3

    instance-of v10, v0, Lgnu/bytecode/Field;

    if-eqz v10, :cond_4

    move-object/from16 v2, p3

    .line 164
    check-cast v2, Lgnu/bytecode/Field;

    .line 165
    .local v2, "field":Lgnu/bytecode/Field;
    invoke-virtual {v2}, Lgnu/bytecode/Field;->getStaticFlag()Z

    move-result v5

    .line 166
    .local v5, "isStaticField":Z
    invoke-virtual {v2}, Lgnu/bytecode/Field;->getType()Lgnu/bytecode/Type;

    move-result-object v10

    invoke-virtual {v7, v10}, Lgnu/expr/Language;->getLangTypeFor(Lgnu/bytecode/Type;)Lgnu/bytecode/Type;

    move-result-object v3

    .line 167
    .local v3, "ftype":Lgnu/bytecode/Type;
    if-eqz v4, :cond_0

    if-nez v5, :cond_0

    .line 168
    const/16 v10, 0x65

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "cannot access non-static field `"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v2}, Lgnu/bytecode/Field;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "\' using `"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {p0}, Lgnu/mapping/Procedure;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const/16 v12, 0x27

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p4

    invoke-virtual {v0, v10, v11}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 170
    :cond_0
    invoke-static {v3}, Lgnu/expr/CheckedTarget;->getInstance(Lgnu/bytecode/Type;)Lgnu/expr/Target;

    move-result-object v10

    move-object/from16 v0, p4

    invoke-virtual {p2, v0, v10}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 171
    if-eqz v5, :cond_3

    .line 172
    invoke-virtual {v1, v2}, Lgnu/bytecode/CodeAttr;->emitPutStatic(Lgnu/bytecode/Field;)V

    .line 195
    .end local v2    # "field":Lgnu/bytecode/Field;
    .end local v3    # "ftype":Lgnu/bytecode/Type;
    .end local v5    # "isStaticField":Z
    :cond_1
    :goto_1
    return-void

    .line 160
    .end local v4    # "isStatic":Z
    :cond_2
    const/4 v4, 0x0

    goto :goto_0

    .line 174
    .restart local v2    # "field":Lgnu/bytecode/Field;
    .restart local v3    # "ftype":Lgnu/bytecode/Type;
    .restart local v4    # "isStatic":Z
    .restart local v5    # "isStaticField":Z
    :cond_3
    invoke-virtual {v1, v2}, Lgnu/bytecode/CodeAttr;->emitPutField(Lgnu/bytecode/Field;)V

    goto :goto_1

    .line 177
    .end local v2    # "field":Lgnu/bytecode/Field;
    .end local v3    # "ftype":Lgnu/bytecode/Type;
    .end local v5    # "isStaticField":Z
    :cond_4
    move-object/from16 v0, p3

    instance-of v10, v0, Lgnu/bytecode/Method;

    if-eqz v10, :cond_1

    move-object/from16 v8, p3

    .line 179
    check-cast v8, Lgnu/bytecode/Method;

    .line 180
    .local v8, "method":Lgnu/bytecode/Method;
    invoke-virtual {v8}, Lgnu/bytecode/Method;->getStaticFlag()Z

    move-result v6

    .line 181
    .local v6, "isStaticMethod":Z
    if-eqz v4, :cond_5

    if-nez v6, :cond_5

    .line 182
    const/16 v10, 0x65

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "cannot call non-static getter method `"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v8}, Lgnu/bytecode/Method;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "\' using `"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {p0}, Lgnu/mapping/Procedure;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const/16 v12, 0x27

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    move-object/from16 v0, p4

    invoke-virtual {v0, v10, v11}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 185
    :cond_5
    invoke-virtual {v8}, Lgnu/bytecode/Method;->getParameterTypes()[Lgnu/bytecode/Type;

    move-result-object v9

    .line 186
    .local v9, "setArgTypes":[Lgnu/bytecode/Type;
    const/4 v10, 0x0

    aget-object v10, v9, v10

    invoke-virtual {v7, v10}, Lgnu/expr/Language;->getLangTypeFor(Lgnu/bytecode/Type;)Lgnu/bytecode/Type;

    move-result-object v10

    invoke-static {v10}, Lgnu/expr/CheckedTarget;->getInstance(Lgnu/bytecode/Type;)Lgnu/expr/Target;

    move-result-object v10

    move-object/from16 v0, p4

    invoke-virtual {p2, v0, v10}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 187
    if-eqz v6, :cond_6

    .line 188
    invoke-virtual {v1, v8}, Lgnu/bytecode/CodeAttr;->emitInvokeStatic(Lgnu/bytecode/Method;)V

    .line 191
    :goto_2
    invoke-virtual {v8}, Lgnu/bytecode/Method;->getReturnType()Lgnu/bytecode/Type;

    move-result-object v10

    invoke-virtual {v10}, Lgnu/bytecode/Type;->isVoid()Z

    move-result v10

    if-nez v10, :cond_1

    .line 192
    const/4 v10, 0x1

    invoke-virtual {v1, v10}, Lgnu/bytecode/CodeAttr;->emitPop(I)V

    goto :goto_1

    .line 190
    :cond_6
    invoke-virtual {v1, v8}, Lgnu/bytecode/CodeAttr;->emitInvoke(Lgnu/bytecode/Method;)V

    goto :goto_2
.end method

.method public static lookupMember(Lgnu/bytecode/ObjectType;Ljava/lang/String;Lgnu/bytecode/ClassType;)Lgnu/bytecode/Member;
    .locals 5
    .param p0, "clas"    # Lgnu/bytecode/ObjectType;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "caller"    # Lgnu/bytecode/ClassType;

    .prologue
    .line 137
    invoke-static {p1}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const/4 v4, -0x1

    invoke-virtual {p0, v3, v4}, Lgnu/bytecode/ObjectType;->getField(Ljava/lang/String;I)Lgnu/bytecode/Field;

    move-result-object v0

    .line 139
    .local v0, "field":Lgnu/bytecode/Field;
    if-eqz v0, :cond_2

    .line 141
    if-nez p2, :cond_0

    .line 142
    sget-object p2, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    .line 143
    :cond_0
    invoke-virtual {p2, v0, p0}, Lgnu/bytecode/ClassType;->isAccessible(Lgnu/bytecode/Member;Lgnu/bytecode/ObjectType;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 152
    .end local v0    # "field":Lgnu/bytecode/Field;
    :cond_1
    :goto_0
    return-object v0

    .line 147
    .restart local v0    # "field":Lgnu/bytecode/Field;
    :cond_2
    const-string v3, "set"

    invoke-static {v3, p1}, Lgnu/expr/ClassExp;->slotToMethodName(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 148
    .local v2, "setName":Ljava/lang/String;
    sget-object v3, Lgnu/kawa/reflect/SlotSet;->type1Array:[Lgnu/bytecode/Type;

    invoke-virtual {p0, v2, v3}, Lgnu/bytecode/ObjectType;->getMethod(Ljava/lang/String;[Lgnu/bytecode/Type;)Lgnu/bytecode/Method;

    move-result-object v1

    .line 149
    .local v1, "method":Lgnu/bytecode/Method;
    if-eqz v1, :cond_1

    move-object v0, v1

    .line 152
    goto :goto_0
.end method

.method public static setField(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p0, "obj"    # Ljava/lang/Object;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 33
    const/4 v0, 0x0

    invoke-static {v0, p0, p1, p2}, Lgnu/kawa/reflect/SlotSet;->apply(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 34
    return-void
.end method

.method public static setStaticField(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p0, "obj"    # Ljava/lang/Object;
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 38
    const/4 v0, 0x1

    invoke-static {v0, p0, p1, p2}, Lgnu/kawa/reflect/SlotSet;->apply(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 39
    return-void
.end method


# virtual methods
.method public apply3(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "fname"    # Ljava/lang/Object;
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 128
    iget-boolean v0, p0, Lgnu/kawa/reflect/SlotSet;->isStatic:Z

    invoke-static {v0, p1, p2, p3}, Lgnu/kawa/reflect/SlotSet;->apply(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 129
    iget-boolean v0, p0, Lgnu/kawa/reflect/SlotSet;->returnSelf:Z

    if-eqz v0, :cond_0

    .end local p1    # "obj":Ljava/lang/Object;
    :goto_0
    return-object p1

    .restart local p1    # "obj":Ljava/lang/Object;
    :cond_0
    sget-object p1, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    goto :goto_0
.end method

.method public compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V
    .locals 20
    .param p1, "exp"    # Lgnu/expr/ApplyExp;
    .param p2, "comp"    # Lgnu/expr/Compilation;
    .param p3, "target"    # Lgnu/expr/Target;

    .prologue
    .line 199
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/ApplyExp;->getArgs()[Lgnu/expr/Expression;

    move-result-object v5

    .line 200
    .local v5, "args":[Lgnu/expr/Expression;
    array-length v12, v5

    .line 201
    .local v12, "nargs":I
    const/16 v17, 0x3

    move/from16 v0, v17

    if-eq v12, v0, :cond_1

    .line 203
    const/16 v17, 0x3

    move/from16 v0, v17

    if-ge v12, v0, :cond_0

    const-string v10, "too few"

    .line 204
    .local v10, "msg":Ljava/lang/String;
    :goto_0
    const/16 v17, 0x65

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " arguments to `"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/reflect/SlotSet;->getName()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const/16 v19, 0x27

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p2

    move/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 205
    const/16 v17, 0x0

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    move-object/from16 v2, p3

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Compilation;->compileConstant(Ljava/lang/Object;Lgnu/expr/Target;)V

    .line 263
    .end local v10    # "msg":Ljava/lang/String;
    :goto_1
    return-void

    .line 203
    :cond_0
    const-string v10, "too many"

    goto :goto_0

    .line 208
    :cond_1
    const/16 v17, 0x0

    aget-object v3, v5, v17

    .line 209
    .local v3, "arg0":Lgnu/expr/Expression;
    const/16 v17, 0x1

    aget-object v4, v5, v17

    .line 210
    .local v4, "arg1":Lgnu/expr/Expression;
    const/16 v17, 0x2

    aget-object v16, v5, v17

    .line 211
    .local v16, "value":Lgnu/expr/Expression;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lgnu/kawa/reflect/SlotSet;->isStatic:Z

    move/from16 v17, v0

    if-eqz v17, :cond_6

    invoke-static {v3}, Lkawa/standard/Scheme;->exp2Type(Lgnu/expr/Expression;)Lgnu/bytecode/Type;

    move-result-object v14

    .line 213
    .local v14, "type":Lgnu/bytecode/Type;
    :goto_2
    const/4 v13, 0x0

    .line 214
    .local v13, "part":Lgnu/bytecode/Member;
    instance-of v0, v14, Lgnu/bytecode/ObjectType;

    move/from16 v17, v0

    if-eqz v17, :cond_d

    instance-of v0, v4, Lgnu/expr/QuoteExp;

    move/from16 v17, v0

    if-eqz v17, :cond_d

    .line 216
    check-cast v4, Lgnu/expr/QuoteExp;

    .end local v4    # "arg1":Lgnu/expr/Expression;
    invoke-virtual {v4}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v15

    .local v15, "val1":Ljava/lang/Object;
    move-object v7, v14

    .line 217
    check-cast v7, Lgnu/bytecode/ObjectType;

    .line 219
    .local v7, "ctype":Lgnu/bytecode/ObjectType;
    move-object/from16 v0, p2

    iget-object v0, v0, Lgnu/expr/Compilation;->curClass:Lgnu/bytecode/ClassType;

    move-object/from16 v17, v0

    if-eqz v17, :cond_7

    move-object/from16 v0, p2

    iget-object v6, v0, Lgnu/expr/Compilation;->curClass:Lgnu/bytecode/ClassType;

    .line 221
    .local v6, "caller":Lgnu/bytecode/ClassType;
    :goto_3
    instance-of v0, v15, Ljava/lang/String;

    move/from16 v17, v0

    if-nez v17, :cond_2

    instance-of v0, v15, Lgnu/lists/FString;

    move/from16 v17, v0

    if-nez v17, :cond_2

    instance-of v0, v15, Lgnu/mapping/Symbol;

    move/from16 v17, v0

    if-eqz v17, :cond_8

    .line 225
    :cond_2
    invoke-virtual {v15}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    .line 226
    .local v11, "name":Ljava/lang/String;
    invoke-static {v7, v11, v6}, Lgnu/kawa/reflect/SlotSet;->lookupMember(Lgnu/bytecode/ObjectType;Ljava/lang/String;Lgnu/bytecode/ClassType;)Lgnu/bytecode/Member;

    move-result-object v13

    .line 227
    if-nez v13, :cond_3

    sget-object v17, Lgnu/bytecode/Type;->pointer_type:Lgnu/bytecode/ClassType;

    move-object/from16 v0, v17

    if-eq v14, v0, :cond_3

    invoke-virtual/range {p2 .. p2}, Lgnu/expr/Compilation;->warnUnknownMember()Z

    move-result v17

    if-eqz v17, :cond_3

    .line 229
    const/16 v17, 0x77

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "no slot `"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "\' in "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual {v7}, Lgnu/bytecode/ObjectType;->getName()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p2

    move/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 241
    :cond_3
    :goto_4
    if-eqz v13, :cond_d

    .line 243
    invoke-interface {v13}, Lgnu/bytecode/Member;->getModifiers()I

    move-result v9

    .line 244
    .local v9, "modifiers":I
    and-int/lit8 v17, v9, 0x8

    if-eqz v17, :cond_a

    const/4 v8, 0x1

    .line 245
    .local v8, "isStaticField":Z
    :goto_5
    if-eqz v6, :cond_4

    invoke-virtual {v6, v13, v7}, Lgnu/bytecode/ClassType;->isAccessible(Lgnu/bytecode/Member;Lgnu/bytecode/ObjectType;)Z

    move-result v17

    if-nez v17, :cond_4

    .line 246
    const/16 v17, 0x65

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "slot \'"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "\' in "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-interface {v13}, Lgnu/bytecode/Member;->getDeclaringClass()Lgnu/bytecode/ClassType;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Lgnu/bytecode/ClassType;->getName()Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, " not accessible here"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, p2

    move/from16 v1, v17

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Compilation;->error(CLjava/lang/String;)V

    .line 249
    :cond_4
    const/16 v17, 0x0

    aget-object v18, v5, v17

    if-eqz v8, :cond_b

    sget-object v17, Lgnu/expr/Target;->Ignore:Lgnu/expr/Target;

    :goto_6
    move-object/from16 v0, v18

    move-object/from16 v1, p2

    move-object/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Expression;->compile(Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    .line 252
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lgnu/kawa/reflect/SlotSet;->returnSelf:Z

    move/from16 v17, v0

    if-eqz v17, :cond_5

    .line 253
    invoke-virtual/range {p2 .. p2}, Lgnu/expr/Compilation;->getCode()Lgnu/bytecode/CodeAttr;

    move-result-object v17

    invoke-virtual {v7}, Lgnu/bytecode/ObjectType;->getImplementationType()Lgnu/bytecode/Type;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Lgnu/bytecode/CodeAttr;->emitDup(Lgnu/bytecode/Type;)V

    .line 254
    :cond_5
    const/16 v17, 0x2

    aget-object v17, v5, v17

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, p2

    invoke-static {v0, v7, v1, v13, v2}, Lgnu/kawa/reflect/SlotSet;->compileSet(Lgnu/mapping/Procedure;Lgnu/bytecode/ObjectType;Lgnu/expr/Expression;Ljava/lang/Object;Lgnu/expr/Compilation;)V

    .line 255
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lgnu/kawa/reflect/SlotSet;->returnSelf:Z

    move/from16 v17, v0

    if-eqz v17, :cond_c

    .line 256
    move-object/from16 v0, p3

    move-object/from16 v1, p2

    invoke-virtual {v0, v1, v7}, Lgnu/expr/Target;->compileFromStack(Lgnu/expr/Compilation;Lgnu/bytecode/Type;)V

    goto/16 :goto_1

    .line 211
    .end local v6    # "caller":Lgnu/bytecode/ClassType;
    .end local v7    # "ctype":Lgnu/bytecode/ObjectType;
    .end local v8    # "isStaticField":Z
    .end local v9    # "modifiers":I
    .end local v11    # "name":Ljava/lang/String;
    .end local v13    # "part":Lgnu/bytecode/Member;
    .end local v14    # "type":Lgnu/bytecode/Type;
    .end local v15    # "val1":Ljava/lang/Object;
    .restart local v4    # "arg1":Lgnu/expr/Expression;
    :cond_6
    invoke-virtual {v3}, Lgnu/expr/Expression;->getType()Lgnu/bytecode/Type;

    move-result-object v14

    goto/16 :goto_2

    .line 219
    .end local v4    # "arg1":Lgnu/expr/Expression;
    .restart local v7    # "ctype":Lgnu/bytecode/ObjectType;
    .restart local v13    # "part":Lgnu/bytecode/Member;
    .restart local v14    # "type":Lgnu/bytecode/Type;
    .restart local v15    # "val1":Ljava/lang/Object;
    :cond_7
    move-object/from16 v0, p2

    iget-object v6, v0, Lgnu/expr/Compilation;->mainClass:Lgnu/bytecode/ClassType;

    goto/16 :goto_3

    .line 231
    .restart local v6    # "caller":Lgnu/bytecode/ClassType;
    :cond_8
    instance-of v0, v15, Lgnu/bytecode/Member;

    move/from16 v17, v0

    if-eqz v17, :cond_9

    move-object v13, v15

    .line 235
    check-cast v13, Lgnu/bytecode/Member;

    .line 236
    invoke-interface {v13}, Lgnu/bytecode/Member;->getName()Ljava/lang/String;

    move-result-object v11

    .restart local v11    # "name":Ljava/lang/String;
    goto/16 :goto_4

    .line 239
    .end local v11    # "name":Ljava/lang/String;
    :cond_9
    const/4 v11, 0x0

    .restart local v11    # "name":Ljava/lang/String;
    goto/16 :goto_4

    .line 244
    .restart local v9    # "modifiers":I
    :cond_a
    const/4 v8, 0x0

    goto/16 :goto_5

    .line 249
    .restart local v8    # "isStaticField":Z
    :cond_b
    invoke-static {v7}, Lgnu/expr/Target;->pushValue(Lgnu/bytecode/Type;)Lgnu/expr/Target;

    move-result-object v17

    goto :goto_6

    .line 258
    :cond_c
    sget-object v17, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    move-object/from16 v2, p3

    invoke-virtual {v0, v1, v2}, Lgnu/expr/Compilation;->compileConstant(Ljava/lang/Object;Lgnu/expr/Target;)V

    goto/16 :goto_1

    .line 262
    .end local v6    # "caller":Lgnu/bytecode/ClassType;
    .end local v7    # "ctype":Lgnu/bytecode/ObjectType;
    .end local v8    # "isStaticField":Z
    .end local v9    # "modifiers":I
    .end local v11    # "name":Ljava/lang/String;
    .end local v15    # "val1":Ljava/lang/Object;
    :cond_d
    invoke-static/range {p1 .. p3}, Lgnu/expr/ApplyExp;->compile(Lgnu/expr/ApplyExp;Lgnu/expr/Compilation;Lgnu/expr/Target;)V

    goto/16 :goto_1
.end method
