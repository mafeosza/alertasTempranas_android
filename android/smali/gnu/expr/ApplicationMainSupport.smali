.class public Lgnu/expr/ApplicationMainSupport;
.super Ljava/lang/Object;
.source "ApplicationMainSupport.java"


# static fields
.field public static commandLineArgArray:[Ljava/lang/String;

.field public static commandLineArguments:Lgnu/lists/FVector;

.field public static processCommandLinePropertyAssignments:Z

.field static propertyFields:[[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 109
    const/16 v0, 0xa

    new-array v0, v0, [[Ljava/lang/String;

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "out:doctype-system"

    aput-object v2, v1, v4

    const-string v2, "gnu.xml.XMLPrinter"

    aput-object v2, v1, v5

    const-string v2, "doctypeSystem"

    aput-object v2, v1, v6

    aput-object v1, v0, v4

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "out:doctype-public"

    aput-object v2, v1, v4

    const-string v2, "gnu.xml.XMLPrinter"

    aput-object v2, v1, v5

    const-string v2, "doctypePublic"

    aput-object v2, v1, v6

    aput-object v1, v0, v5

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "out:base"

    aput-object v2, v1, v4

    const-string v2, "gnu.kawa.functions.DisplayFormat"

    aput-object v2, v1, v5

    const-string v2, "outBase"

    aput-object v2, v1, v6

    aput-object v1, v0, v6

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "out:radix"

    aput-object v2, v1, v4

    const-string v2, "gnu.kawa.functions.DisplayFormat"

    aput-object v2, v1, v5

    const-string v2, "outRadix"

    aput-object v2, v1, v6

    aput-object v1, v0, v7

    const/4 v1, 0x4

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "out:line-length"

    aput-object v3, v2, v4

    const-string v3, "gnu.text.PrettyWriter"

    aput-object v3, v2, v5

    const-string v3, "lineLengthLoc"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/4 v1, 0x5

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "out:right-margin"

    aput-object v3, v2, v4

    const-string v3, "gnu.text.PrettyWriter"

    aput-object v3, v2, v5

    const-string v3, "lineLengthLoc"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/4 v1, 0x6

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "out:miser-width"

    aput-object v3, v2, v4

    const-string v3, "gnu.text.PrettyWriter"

    aput-object v3, v2, v5

    const-string v3, "miserWidthLoc"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/4 v1, 0x7

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "out:xml-indent"

    aput-object v3, v2, v4

    const-string v3, "gnu.xml.XMLPrinter"

    aput-object v3, v2, v5

    const-string v3, "indentLoc"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x8

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "display:toolkit"

    aput-object v3, v2, v4

    const-string v3, "gnu.kawa.models.Display"

    aput-object v3, v2, v5

    const-string v3, "myDisplay"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const/4 v2, 0x0

    aput-object v2, v0, v1

    sput-object v0, Lgnu/expr/ApplicationMainSupport;->propertyFields:[[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static processArgs([Ljava/lang/String;)V
    .locals 2
    .param p0, "args"    # [Ljava/lang/String;

    .prologue
    .line 34
    const/4 v0, 0x0

    .line 35
    .local v0, "iarg":I
    sget-boolean v1, Lgnu/expr/ApplicationMainSupport;->processCommandLinePropertyAssignments:Z

    if-eqz v1, :cond_0

    .line 37
    :goto_0
    array-length v1, p0

    if-ge v0, v1, :cond_0

    aget-object v1, p0, v0

    invoke-static {v1}, Lgnu/expr/ApplicationMainSupport;->processSetProperty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 38
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 40
    :cond_0
    invoke-static {p0, v0}, Lgnu/expr/ApplicationMainSupport;->setArgs([Ljava/lang/String;I)V

    .line 41
    return-void
.end method

.method public static processSetProperties()V
    .locals 3

    .prologue
    .line 18
    sget-object v0, Lgnu/expr/ApplicationMainSupport;->commandLineArgArray:[Ljava/lang/String;

    .line 19
    .local v0, "args":[Ljava/lang/String;
    if-nez v0, :cond_1

    .line 20
    const/4 v2, 0x1

    sput-boolean v2, Lgnu/expr/ApplicationMainSupport;->processCommandLinePropertyAssignments:Z

    .line 29
    :cond_0
    :goto_0
    return-void

    .line 23
    :cond_1
    const/4 v1, 0x0

    .line 24
    .local v1, "iarg":I
    :goto_1
    array-length v2, v0

    if-ge v1, v2, :cond_2

    aget-object v2, v0, v1

    invoke-static {v2}, Lgnu/expr/ApplicationMainSupport;->processSetProperty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 25
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 26
    :cond_2
    if-eqz v1, :cond_0

    .line 27
    invoke-static {v0, v1}, Lgnu/expr/ApplicationMainSupport;->setArgs([Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public static processSetProperty(Ljava/lang/String;)Z
    .locals 15
    .param p0, "arg"    # Ljava/lang/String;

    .prologue
    .line 66
    const/16 v12, 0x3d

    invoke-virtual {p0, v12}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    .line 67
    .local v0, "ci":I
    if-gtz v0, :cond_0

    .line 68
    const/4 v12, 0x0

    .line 101
    :goto_0
    return v12

    .line 69
    :cond_0
    const/4 v12, 0x0

    invoke-virtual {p0, v12, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    .line 70
    .local v7, "key":Ljava/lang/String;
    add-int/lit8 v12, v0, 0x1

    invoke-virtual {p0, v12}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v11

    .line 71
    .local v11, "value":Ljava/lang/String;
    const/4 v6, 0x0

    .line 73
    .local v6, "i":I
    :goto_1
    sget-object v12, Lgnu/expr/ApplicationMainSupport;->propertyFields:[[Ljava/lang/String;

    aget-object v9, v12, v6

    .line 74
    .local v9, "propertyField":[Ljava/lang/String;
    if-nez v9, :cond_1

    .line 96
    :goto_2
    invoke-static {v7}, Lgnu/mapping/Symbol;->parse(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v10

    .line 98
    .local v10, "symbol":Lgnu/mapping/Symbol;
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    .line 99
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v3

    .line 100
    .local v3, "current":Lgnu/mapping/Environment;
    const/4 v12, 0x0

    invoke-virtual {v3, v10, v12, v11}, Lgnu/mapping/Environment;->define(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 101
    const/4 v12, 0x1

    goto :goto_0

    .line 76
    .end local v3    # "current":Lgnu/mapping/Environment;
    .end local v10    # "symbol":Lgnu/mapping/Symbol;
    :cond_1
    const/4 v12, 0x0

    aget-object v12, v9, v12

    invoke-virtual {v7, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 78
    const/4 v12, 0x1

    aget-object v2, v9, v12

    .line 79
    .local v2, "cname":Ljava/lang/String;
    const/4 v12, 0x2

    aget-object v5, v9, v12

    .line 82
    .local v5, "fname":Ljava/lang/String;
    :try_start_0
    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 83
    .local v1, "clas":Ljava/lang/Class;
    invoke-virtual {v1, v5}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v12

    const/4 v13, 0x0

    invoke-virtual {v12, v13}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lgnu/mapping/ThreadLocation;

    .line 85
    .local v8, "loc":Lgnu/mapping/ThreadLocation;
    invoke-virtual {v8, v11}, Lgnu/mapping/ThreadLocation;->setGlobal(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_2

    .line 88
    .end local v1    # "clas":Ljava/lang/Class;
    .end local v8    # "loc":Lgnu/mapping/ThreadLocation;
    :catch_0
    move-exception v4

    .line 90
    .local v4, "ex":Ljava/lang/Throwable;
    sget-object v12, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "error setting property "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, " field "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const/16 v14, 0x2e

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ": "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 92
    const/4 v12, -0x1

    invoke-static {v12}, Ljava/lang/System;->exit(I)V

    .line 71
    .end local v2    # "cname":Ljava/lang/String;
    .end local v4    # "ex":Ljava/lang/Throwable;
    .end local v5    # "fname":Ljava/lang/String;
    :cond_2
    add-int/lit8 v6, v6, 0x1

    goto :goto_1
.end method

.method public static setArgs([Ljava/lang/String;I)V
    .locals 7
    .param p0, "args"    # [Ljava/lang/String;
    .param p1, "arg_start"    # I

    .prologue
    .line 45
    array-length v4, p0

    sub-int v2, v4, p1

    .line 46
    .local v2, "nargs":I
    new-array v0, v2, [Ljava/lang/Object;

    .line 47
    .local v0, "array":[Ljava/lang/Object;
    if-nez p1, :cond_0

    .line 48
    sput-object p0, Lgnu/expr/ApplicationMainSupport;->commandLineArgArray:[Ljava/lang/String;

    .line 56
    :goto_0
    move v1, v2

    .local v1, "i":I
    :goto_1
    add-int/lit8 v1, v1, -0x1

    if-ltz v1, :cond_2

    .line 57
    new-instance v4, Lgnu/lists/FString;

    add-int v5, v1, p1

    aget-object v5, p0, v5

    invoke-direct {v4, v5}, Lgnu/lists/FString;-><init>(Ljava/lang/String;)V

    aput-object v4, v0, v1

    goto :goto_1

    .line 51
    .end local v1    # "i":I
    :cond_0
    new-array v3, v2, [Ljava/lang/String;

    .line 52
    .local v3, "strings":[Ljava/lang/String;
    move v1, v2

    .restart local v1    # "i":I
    :goto_2
    add-int/lit8 v1, v1, -0x1

    if-ltz v1, :cond_1

    .line 53
    add-int v4, v1, p1

    aget-object v4, p0, v4

    aput-object v4, v3, v1

    goto :goto_2

    .line 54
    :cond_1
    sput-object v3, Lgnu/expr/ApplicationMainSupport;->commandLineArgArray:[Ljava/lang/String;

    goto :goto_0

    .line 58
    .end local v3    # "strings":[Ljava/lang/String;
    :cond_2
    new-instance v4, Lgnu/lists/FVector;

    invoke-direct {v4, v0}, Lgnu/lists/FVector;-><init>([Ljava/lang/Object;)V

    sput-object v4, Lgnu/expr/ApplicationMainSupport;->commandLineArguments:Lgnu/lists/FVector;

    .line 60
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v4

    const-string v5, "command-line-arguments"

    sget-object v6, Lgnu/expr/ApplicationMainSupport;->commandLineArguments:Lgnu/lists/FVector;

    invoke-virtual {v4, v5, v6}, Lgnu/mapping/Environment;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 62
    return-void
.end method
