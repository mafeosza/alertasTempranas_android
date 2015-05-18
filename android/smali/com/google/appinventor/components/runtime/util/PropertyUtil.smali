.class public Lcom/google/appinventor/components/runtime/util/PropertyUtil;
.super Ljava/lang/Object;
.source "PropertyUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static copyComponentProperties(Lcom/google/appinventor/components/runtime/Component;Lcom/google/appinventor/components/runtime/Component;)Lcom/google/appinventor/components/runtime/Component;
    .locals 17
    .param p0, "source"    # Lcom/google/appinventor/components/runtime/Component;
    .param p1, "target"    # Lcom/google/appinventor/components/runtime/Component;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 31
    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v15

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v15

    if-nez v15, :cond_0

    .line 32
    new-instance v15, Ljava/lang/IllegalArgumentException;

    const-string v16, "Source and target classes must be identical"

    invoke-direct/range {v15 .. v16}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v15

    .line 35
    :cond_0
    invoke-virtual/range {p0 .. p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    .line 36
    .local v2, "componentClass":Ljava/lang/Class;
    invoke-virtual {v2}, Ljava/lang/Class;->getMethods()[Ljava/lang/reflect/Method;

    move-result-object v4

    .line 37
    .local v4, "componentMethods":[Ljava/lang/reflect/Method;
    move-object v1, v4

    .local v1, "arr$":[Ljava/lang/reflect/Method;
    array-length v8, v1

    .local v8, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    :goto_0
    if-ge v7, v8, :cond_3

    aget-object v3, v1, v7

    .line 39
    .local v3, "componentMethod":Ljava/lang/reflect/Method;
    const-class v15, Lcom/google/appinventor/components/annotations/SimpleProperty;

    invoke-virtual {v3, v15}, Ljava/lang/reflect/Method;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v15

    if-eqz v15, :cond_1

    invoke-virtual {v3}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v15

    array-length v15, v15

    const/16 v16, 0x1

    move/from16 v0, v16

    if-ne v15, v0, :cond_1

    .line 41
    move-object v12, v3

    .line 43
    .local v12, "propertySetterMethod":Ljava/lang/reflect/Method;
    :try_start_0
    invoke-virtual {v12}, Ljava/lang/reflect/Method;->getName()Ljava/lang/String;

    move-result-object v11

    .line 46
    .local v11, "propertyName":Ljava/lang/String;
    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "Copy"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v15, v2}, Lcom/google/appinventor/components/runtime/util/PropertyUtil;->getPropertyCopierMethod(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v9

    .line 48
    .local v9, "propertyCopierMethod":Ljava/lang/reflect/Method;
    if-eqz v9, :cond_2

    .line 49
    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object p0, v15, v16

    move-object/from16 v0, p1

    invoke-virtual {v9, v0, v15}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    .end local v9    # "propertyCopierMethod":Ljava/lang/reflect/Method;
    .end local v11    # "propertyName":Ljava/lang/String;
    .end local v12    # "propertySetterMethod":Ljava/lang/reflect/Method;
    :cond_1
    :goto_1
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 55
    .restart local v9    # "propertyCopierMethod":Ljava/lang/reflect/Method;
    .restart local v11    # "propertyName":Ljava/lang/String;
    .restart local v12    # "propertySetterMethod":Ljava/lang/reflect/Method;
    :cond_2
    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Class;

    invoke-virtual {v2, v11, v15}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v10

    .line 56
    .local v10, "propertyGetterMethod":Ljava/lang/reflect/Method;
    invoke-virtual {v12}, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;

    move-result-object v15

    const/16 v16, 0x0

    aget-object v13, v15, v16

    .line 59
    .local v13, "propertySetterParameterType":Ljava/lang/Class;
    const-class v15, Lcom/google/appinventor/components/annotations/SimpleProperty;

    invoke-virtual {v10, v15}, Ljava/lang/reflect/Method;->isAnnotationPresent(Ljava/lang/Class;)Z

    move-result v15

    if-eqz v15, :cond_1

    invoke-virtual {v10}, Ljava/lang/reflect/Method;->getReturnType()Ljava/lang/Class;

    move-result-object v15

    invoke-virtual {v13, v15}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v15

    if-eqz v15, :cond_1

    .line 61
    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Object;

    move-object/from16 v0, p0

    invoke-virtual {v10, v0, v15}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    .line 62
    .local v14, "propertyValue":Ljava/lang/Object;
    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    aput-object v14, v15, v16

    move-object/from16 v0, p1

    invoke-virtual {v12, v0, v15}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_1

    .line 64
    .end local v9    # "propertyCopierMethod":Ljava/lang/reflect/Method;
    .end local v10    # "propertyGetterMethod":Ljava/lang/reflect/Method;
    .end local v11    # "propertyName":Ljava/lang/String;
    .end local v13    # "propertySetterParameterType":Ljava/lang/Class;
    .end local v14    # "propertyValue":Ljava/lang/Object;
    :catch_0
    move-exception v5

    .line 66
    .local v5, "e":Ljava/lang/NoSuchMethodException;
    goto :goto_1

    .line 67
    .end local v5    # "e":Ljava/lang/NoSuchMethodException;
    :catch_1
    move-exception v6

    .line 69
    .local v6, "e2":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v6}, Ljava/lang/reflect/InvocationTargetException;->getCause()Ljava/lang/Throwable;

    move-result-object v15

    throw v15

    .line 73
    .end local v3    # "componentMethod":Ljava/lang/reflect/Method;
    .end local v6    # "e2":Ljava/lang/reflect/InvocationTargetException;
    .end local v12    # "propertySetterMethod":Ljava/lang/reflect/Method;
    :cond_3
    return-object p1
.end method

.method private static getPropertyCopierMethod(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/reflect/Method;
    .locals 3
    .param p0, "copierMethodName"    # Ljava/lang/String;
    .param p1, "componentClass"    # Ljava/lang/Class;

    .prologue
    .line 84
    :cond_0
    const/4 v1, 0x1

    :try_start_0
    new-array v1, v1, [Ljava/lang/Class;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    invoke-virtual {p1, p0, v1}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 85
    .local v0, "propertyCopierMethod":Ljava/lang/reflect/Method;
    const-class v1, Lcom/google/appinventor/components/annotations/SimplePropertyCopier;

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Method;->isAnnotationPresent(Ljava/lang/Class;)Z
    :try_end_0
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    if-eqz v1, :cond_1

    .line 95
    .end local v0    # "propertyCopierMethod":Ljava/lang/reflect/Method;
    :goto_0
    return-object v0

    .line 88
    :catch_0
    move-exception v1

    .line 91
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;

    move-result-object p1

    .line 92
    if-nez p1, :cond_0

    .line 95
    const/4 v0, 0x0

    goto :goto_0
.end method
