.class public Lkawa/repl;
.super Lgnu/mapping/Procedure0or1;
.source "repl.java"


# static fields
.field public static compilationTopname:Ljava/lang/String;

.field static defaultParseOptions:I

.field public static homeDirectory:Ljava/lang/String;

.field public static noConsole:Z

.field static previousLanguage:Lgnu/expr/Language;

.field static shutdownRegistered:Z


# instance fields
.field language:Lgnu/expr/Language;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const/4 v0, 0x0

    sput-object v0, Lkawa/repl;->compilationTopname:Ljava/lang/String;

    .line 23
    const/16 v0, 0x48

    sput v0, Lkawa/repl;->defaultParseOptions:I

    .line 176
    sget-object v0, Lgnu/text/WriterManager;->instance:Lgnu/text/WriterManager;

    invoke-virtual {v0}, Lgnu/text/WriterManager;->registerShutdownHook()Z

    move-result v0

    sput-boolean v0, Lkawa/repl;->shutdownRegistered:Z

    return-void
.end method

.method public constructor <init>(Lgnu/expr/Language;)V
    .locals 0
    .param p1, "language"    # Lgnu/expr/Language;

    .prologue
    .line 26
    invoke-direct {p0}, Lgnu/mapping/Procedure0or1;-><init>()V

    .line 27
    iput-object p1, p0, Lkawa/repl;->language:Lgnu/expr/Language;

    .line 28
    return-void
.end method

.method static bad_option(Ljava/lang/String;)V
    .locals 3
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 44
    sget-object v0, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "kawa: bad option \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 45
    sget-object v0, Ljava/lang/System;->err:Ljava/io/PrintStream;

    invoke-static {v0}, Lkawa/repl;->printOptions(Ljava/io/PrintStream;)V

    .line 46
    const/4 v0, -0x1

    invoke-static {v0}, Ljava/lang/System;->exit(I)V

    .line 47
    return-void
.end method

.method static checkInitFile()V
    .locals 7

    .prologue
    .line 125
    sget-object v4, Lkawa/repl;->homeDirectory:Ljava/lang/String;

    if-nez v4, :cond_0

    .line 127
    const/4 v1, 0x0

    .line 128
    .local v1, "initFile":Ljava/io/File;
    const-string v4, "user.home"

    invoke-static {v4}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    sput-object v4, Lkawa/repl;->homeDirectory:Ljava/lang/String;

    .line 130
    sget-object v4, Lkawa/repl;->homeDirectory:Ljava/lang/String;

    if-eqz v4, :cond_2

    .line 132
    new-instance v3, Lgnu/lists/FString;

    sget-object v4, Lkawa/repl;->homeDirectory:Ljava/lang/String;

    invoke-direct {v3, v4}, Lgnu/lists/FString;-><init>(Ljava/lang/String;)V

    .line 133
    .local v3, "scmHomeDirectory":Lgnu/lists/FString;
    const-string v4, "file.separator"

    invoke-static {v4}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 134
    .local v0, "file_separator":Ljava/lang/String;
    const-string v4, "/"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    const-string v2, ".kawarc.scm"

    .line 137
    .local v2, "kawarc_name":Ljava/lang/String;
    :goto_0
    new-instance v1, Ljava/io/File;

    .end local v1    # "initFile":Ljava/io/File;
    sget-object v4, Lkawa/repl;->homeDirectory:Ljava/lang/String;

    invoke-direct {v1, v4, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 141
    .end local v0    # "file_separator":Ljava/lang/String;
    .end local v2    # "kawarc_name":Ljava/lang/String;
    .end local v3    # "scmHomeDirectory":Lgnu/lists/FString;
    .restart local v1    # "initFile":Ljava/io/File;
    :goto_1
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v4

    const-string v5, "home-directory"

    invoke-virtual {v4, v5, v3}, Lgnu/mapping/Environment;->put(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 143
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    const/4 v6, 0x0

    invoke-static {v4, v5, v6}, Lkawa/Shell;->runFileOrClass(Ljava/lang/String;ZI)Z

    move-result v4

    if-nez v4, :cond_0

    .line 144
    const/4 v4, -0x1

    invoke-static {v4}, Ljava/lang/System;->exit(I)V

    .line 146
    :cond_0
    return-void

    .line 134
    .restart local v0    # "file_separator":Ljava/lang/String;
    .restart local v3    # "scmHomeDirectory":Lgnu/lists/FString;
    :cond_1
    const-string v2, "kawarc.scm"

    goto :goto_0

    .line 140
    .end local v0    # "file_separator":Ljava/lang/String;
    .end local v3    # "scmHomeDirectory":Lgnu/lists/FString;
    :cond_2
    sget-object v3, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    .local v3, "scmHomeDirectory":Ljava/lang/Boolean;
    goto :goto_1
.end method

.method public static compileFiles([Ljava/lang/String;II)V
    .locals 18
    .param p0, "args"    # [Ljava/lang/String;
    .param p1, "iArg"    # I
    .param p2, "maxArg"    # I

    .prologue
    .line 718
    invoke-static {}, Lgnu/expr/ModuleManager;->getInstance()Lgnu/expr/ModuleManager;

    move-result-object v11

    .line 719
    .local v11, "manager":Lgnu/expr/ModuleManager;
    sub-int v15, p2, p1

    new-array v4, v15, [Lgnu/expr/Compilation;

    .line 720
    .local v4, "comps":[Lgnu/expr/Compilation;
    sub-int v15, p2, p1

    new-array v9, v15, [Lgnu/expr/ModuleInfo;

    .line 721
    .local v9, "infos":[Lgnu/expr/ModuleInfo;
    new-instance v12, Lgnu/text/SourceMessages;

    invoke-direct {v12}, Lgnu/text/SourceMessages;-><init>()V

    .line 722
    .local v12, "messages":Lgnu/text/SourceMessages;
    move/from16 v8, p1

    .local v8, "i":I
    :goto_0
    move/from16 v0, p2

    if-ge v8, v0, :cond_3

    .line 724
    aget-object v1, p0, v8

    .line 725
    .local v1, "arg":Ljava/lang/String;
    invoke-static {v1}, Lkawa/repl;->getLanguageFromFilenameExtension(Ljava/lang/String;)V

    .line 726
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    move-result-object v10

    .line 727
    .local v10, "language":Lgnu/expr/Language;
    const/4 v3, 0x0

    .line 733
    .local v3, "comp":Lgnu/expr/Compilation;
    :try_start_0
    invoke-static {v1}, Lgnu/mapping/InPort;->openFile(Ljava/lang/Object;)Lgnu/mapping/InPort;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v7

    .line 742
    .local v7, "fstream":Lgnu/mapping/InPort;
    :try_start_1
    sget v15, Lkawa/repl;->defaultParseOptions:I

    invoke-virtual {v10, v7, v12, v15}, Lgnu/expr/Language;->parse(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;I)Lgnu/expr/Compilation;

    move-result-object v3

    .line 746
    sget-object v15, Lkawa/repl;->compilationTopname:Ljava/lang/String;

    if-eqz v15, :cond_0

    .line 748
    sget-object v15, Lkawa/repl;->compilationTopname:Ljava/lang/String;

    invoke-static {v15}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 750
    .local v2, "cname":Ljava/lang/String;
    new-instance v5, Lgnu/bytecode/ClassType;

    invoke-direct {v5, v2}, Lgnu/bytecode/ClassType;-><init>(Ljava/lang/String;)V

    .line 751
    .local v5, "ctype":Lgnu/bytecode/ClassType;
    invoke-virtual {v3}, Lgnu/expr/Compilation;->getModule()Lgnu/expr/ModuleExp;

    move-result-object v13

    .line 752
    .local v13, "mexp":Lgnu/expr/ModuleExp;
    invoke-virtual {v13, v5}, Lgnu/expr/ModuleExp;->setType(Lgnu/bytecode/ClassType;)V

    .line 753
    sget-object v15, Lkawa/repl;->compilationTopname:Ljava/lang/String;

    invoke-virtual {v13, v15}, Lgnu/expr/ModuleExp;->setName(Ljava/lang/String;)V

    .line 754
    iput-object v5, v3, Lgnu/expr/Compilation;->mainClass:Lgnu/bytecode/ClassType;

    .line 757
    .end local v2    # "cname":Ljava/lang/String;
    .end local v5    # "ctype":Lgnu/bytecode/ClassType;
    .end local v13    # "mexp":Lgnu/expr/ModuleExp;
    :cond_0
    sub-int v15, v8, p1

    invoke-virtual {v11, v3}, Lgnu/expr/ModuleManager;->find(Lgnu/expr/Compilation;)Lgnu/expr/ModuleInfo;

    move-result-object v16

    aput-object v16, v9, v15

    .line 758
    sub-int v15, v8, p1

    aput-object v3, v4, v15
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 767
    .end local v7    # "fstream":Lgnu/mapping/InPort;
    :cond_1
    :goto_1
    invoke-virtual {v12}, Lgnu/text/SourceMessages;->seenErrorsOrWarnings()Z

    move-result v15

    if-eqz v15, :cond_2

    .line 769
    sget-object v15, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "(compiling "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const/16 v17, 0x29

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 770
    sget-object v15, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const/16 v16, 0x14

    move/from16 v0, v16

    invoke-virtual {v12, v15, v0}, Lgnu/text/SourceMessages;->checkErrors(Ljava/io/PrintStream;I)Z

    move-result v15

    if-eqz v15, :cond_2

    .line 771
    const/4 v15, 0x1

    invoke-static {v15}, Ljava/lang/System;->exit(I)V

    .line 722
    :cond_2
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 735
    :catch_0
    move-exception v6

    .line 737
    .local v6, "ex":Ljava/io/FileNotFoundException;
    :try_start_2
    sget-object v15, Ljava/lang/System;->err:Ljava/io/PrintStream;

    invoke-virtual {v15, v6}, Ljava/io/PrintStream;->println(Ljava/lang/Object;)V

    .line 738
    const/4 v15, -0x1

    invoke-static {v15}, Ljava/lang/System;->exit(I)V
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_1

    .line 775
    .end local v1    # "arg":Ljava/lang/String;
    .end local v3    # "comp":Lgnu/expr/Compilation;
    .end local v6    # "ex":Ljava/io/FileNotFoundException;
    .end local v10    # "language":Lgnu/expr/Language;
    :cond_3
    move/from16 v8, p1

    :goto_2
    move/from16 v0, p2

    if-ge v8, v0, :cond_7

    .line 777
    aget-object v1, p0, v8

    .line 778
    .restart local v1    # "arg":Ljava/lang/String;
    sub-int v15, v8, p1

    aget-object v3, v4, v15

    .line 781
    .restart local v3    # "comp":Lgnu/expr/Compilation;
    :try_start_3
    sget-object v15, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v16, Ljava/lang/StringBuilder;

    invoke-direct/range {v16 .. v16}, Ljava/lang/StringBuilder;-><init>()V

    const-string v17, "(compiling "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, " to "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    iget-object v0, v3, Lgnu/expr/Compilation;->mainClass:Lgnu/bytecode/ClassType;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lgnu/bytecode/ClassType;->getName()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const/16 v17, 0x29

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 783
    sub-int v15, v8, p1

    aget-object v15, v9, v15

    const/16 v16, 0xe

    invoke-virtual/range {v15 .. v16}, Lgnu/expr/ModuleInfo;->loadByStages(I)V

    .line 784
    invoke-virtual {v12}, Lgnu/text/SourceMessages;->seenErrors()Z

    move-result v14

    .line 785
    .local v14, "sawErrors":Z
    sget-object v15, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const/16 v16, 0x32

    move/from16 v0, v16

    invoke-virtual {v12, v15, v0}, Lgnu/text/SourceMessages;->checkErrors(Ljava/io/PrintStream;I)Z

    .line 786
    if-eqz v14, :cond_4

    .line 787
    const/4 v15, -0x1

    invoke-static {v15}, Ljava/lang/System;->exit(I)V

    .line 788
    :cond_4
    sub-int v15, v8, p1

    aput-object v3, v4, v15

    .line 789
    invoke-virtual {v12}, Lgnu/text/SourceMessages;->seenErrors()Z

    move-result v14

    .line 790
    sget-object v15, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const/16 v16, 0x32

    move/from16 v0, v16

    invoke-virtual {v12, v15, v0}, Lgnu/text/SourceMessages;->checkErrors(Ljava/io/PrintStream;I)Z

    .line 791
    if-eqz v14, :cond_5

    .line 792
    const/4 v15, -0x1

    invoke-static {v15}, Ljava/lang/System;->exit(I)V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_2

    .line 775
    .end local v14    # "sawErrors":Z
    :cond_5
    :goto_3
    add-int/lit8 v8, v8, 0x1

    goto :goto_2

    .line 761
    .restart local v10    # "language":Lgnu/expr/Language;
    :catch_1
    move-exception v6

    .line 763
    .local v6, "ex":Ljava/lang/Throwable;
    instance-of v15, v6, Lgnu/text/SyntaxException;

    if-eqz v15, :cond_6

    move-object v15, v6

    check-cast v15, Lgnu/text/SyntaxException;

    invoke-virtual {v15}, Lgnu/text/SyntaxException;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v15

    if-eq v15, v12, :cond_1

    .line 765
    :cond_6
    invoke-static {v6, v3, v1}, Lkawa/repl;->internalError(Ljava/lang/Throwable;Lgnu/expr/Compilation;Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 794
    .end local v6    # "ex":Ljava/lang/Throwable;
    .end local v10    # "language":Lgnu/expr/Language;
    :catch_2
    move-exception v6

    .line 796
    .restart local v6    # "ex":Ljava/lang/Throwable;
    invoke-static {v6, v3, v1}, Lkawa/repl;->internalError(Ljava/lang/Throwable;Lgnu/expr/Compilation;Ljava/lang/Object;)V

    goto :goto_3

    .line 799
    .end local v1    # "arg":Ljava/lang/String;
    .end local v3    # "comp":Lgnu/expr/Compilation;
    .end local v6    # "ex":Ljava/lang/Throwable;
    :cond_7
    return-void
.end method

.method public static getLanguage()V
    .locals 1

    .prologue
    .line 169
    sget-object v0, Lkawa/repl;->previousLanguage:Lgnu/expr/Language;

    if-nez v0, :cond_0

    .line 171
    const/4 v0, 0x0

    invoke-static {v0}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v0

    sput-object v0, Lkawa/repl;->previousLanguage:Lgnu/expr/Language;

    .line 172
    sget-object v0, Lkawa/repl;->previousLanguage:Lgnu/expr/Language;

    invoke-static {v0}, Lgnu/expr/Language;->setDefaults(Lgnu/expr/Language;)V

    .line 174
    :cond_0
    return-void
.end method

.method public static getLanguageFromFilenameExtension(Ljava/lang/String;)V
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 155
    sget-object v0, Lkawa/repl;->previousLanguage:Lgnu/expr/Language;

    if-nez v0, :cond_0

    .line 157
    invoke-static {p0}, Lgnu/expr/Language;->getInstanceFromFilenameExtension(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v0

    sput-object v0, Lkawa/repl;->previousLanguage:Lgnu/expr/Language;

    .line 158
    sget-object v0, Lkawa/repl;->previousLanguage:Lgnu/expr/Language;

    if-eqz v0, :cond_0

    .line 160
    sget-object v0, Lkawa/repl;->previousLanguage:Lgnu/expr/Language;

    invoke-static {v0}, Lgnu/expr/Language;->setDefaults(Lgnu/expr/Language;)V

    .line 165
    :goto_0
    return-void

    .line 164
    :cond_0
    invoke-static {}, Lkawa/repl;->getLanguage()V

    goto :goto_0
.end method

.method static internalError(Ljava/lang/Throwable;Lgnu/expr/Compilation;Ljava/lang/Object;)V
    .locals 5
    .param p0, "ex"    # Ljava/lang/Throwable;
    .param p1, "comp"    # Lgnu/expr/Compilation;
    .param p2, "arg"    # Ljava/lang/Object;

    .prologue
    .line 803
    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    .line 804
    .local v2, "sbuf":Ljava/lang/StringBuffer;
    if-eqz p1, :cond_0

    .line 806
    invoke-virtual {p1}, Lgnu/expr/Compilation;->getFileName()Ljava/lang/String;

    move-result-object v0

    .line 807
    .local v0, "file":Ljava/lang/String;
    invoke-virtual {p1}, Lgnu/expr/Compilation;->getLineNumber()I

    move-result v1

    .line 808
    .local v1, "line":I
    if-eqz v0, :cond_0

    if-lez v1, :cond_0

    .line 810
    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 811
    const/16 v3, 0x3a

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 812
    invoke-virtual {v2, v1}, Ljava/lang/StringBuffer;->append(I)Ljava/lang/StringBuffer;

    .line 813
    const-string v3, ": "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 816
    .end local v0    # "file":Ljava/lang/String;
    .end local v1    # "line":I
    :cond_0
    const-string v3, "internal error while compiling "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 817
    invoke-virtual {v2, p2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 818
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 819
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    invoke-virtual {p0, v3}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintStream;)V

    .line 820
    const/4 v3, -0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    .line 821
    return-void
.end method

.method public static main([Ljava/lang/String;)V
    .locals 5
    .param p0, "args"    # [Ljava/lang/String;

    .prologue
    .line 827
    const/4 v3, 0x0

    :try_start_0
    array-length v4, p0

    invoke-static {p0, v3, v4}, Lkawa/repl;->processArgs([Ljava/lang/String;II)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    .line 828
    .local v1, "iArg":I
    if-gez v1, :cond_1

    .line 857
    sget-boolean v3, Lkawa/repl;->shutdownRegistered:Z

    if-nez v3, :cond_0

    .line 860
    invoke-static {}, Lgnu/mapping/OutPort;->runCleanups()V

    .line 862
    :cond_0
    invoke-static {}, Lgnu/expr/ModuleBody;->exitDecrement()V

    .line 864
    :goto_0
    return-void

    .line 831
    :cond_1
    :try_start_1
    array-length v3, p0

    if-ge v1, v3, :cond_4

    .line 833
    aget-object v0, p0, v1

    .line 834
    .local v0, "filename":Ljava/lang/String;
    invoke-static {v0}, Lkawa/repl;->getLanguageFromFilenameExtension(Ljava/lang/String;)V

    .line 835
    add-int/lit8 v3, v1, 0x1

    invoke-static {p0, v3}, Lkawa/repl;->setArgs([Ljava/lang/String;I)V

    .line 836
    invoke-static {}, Lkawa/repl;->checkInitFile()V

    .line 837
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v0, v3, v4}, Lkawa/Shell;->runFileOrClass(Ljava/lang/String;ZI)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v2

    .line 857
    .end local v0    # "filename":Ljava/lang/String;
    :cond_2
    :goto_1
    sget-boolean v3, Lkawa/repl;->shutdownRegistered:Z

    if-nez v3, :cond_3

    .line 860
    invoke-static {}, Lgnu/mapping/OutPort;->runCleanups()V

    .line 862
    :cond_3
    invoke-static {}, Lgnu/expr/ModuleBody;->exitDecrement()V

    goto :goto_0

    .line 841
    :cond_4
    :try_start_2
    invoke-static {}, Lkawa/repl;->getLanguage()V

    .line 842
    invoke-static {p0, v1}, Lkawa/repl;->setArgs([Ljava/lang/String;I)V

    .line 843
    invoke-static {}, Lkawa/repl;->checkInitFile()V

    .line 844
    invoke-static {}, Lkawa/repl;->shouldUseGuiConsole()Z

    move-result v3

    if-eqz v3, :cond_6

    .line 845
    invoke-static {}, Lkawa/repl;->startGuiConsole()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1

    .line 857
    .end local v1    # "iArg":I
    :catchall_0
    move-exception v3

    sget-boolean v4, Lkawa/repl;->shutdownRegistered:Z

    if-nez v4, :cond_5

    .line 860
    invoke-static {}, Lgnu/mapping/OutPort;->runCleanups()V

    .line 862
    :cond_5
    invoke-static {}, Lgnu/expr/ModuleBody;->exitDecrement()V

    throw v3

    .line 848
    .restart local v1    # "iArg":I
    :cond_6
    :try_start_3
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    move-result-object v3

    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v4

    invoke-static {v3, v4}, Lkawa/Shell;->run(Lgnu/expr/Language;Lgnu/mapping/Environment;)Z

    move-result v2

    .line 850
    .local v2, "ok":Z
    if-nez v2, :cond_2

    .line 851
    const/4 v3, -0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1
.end method

.method public static printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "out"    # Ljava/io/PrintStream;
    .param p1, "option"    # Ljava/lang/String;
    .param p2, "doc"    # Ljava/lang/String;

    .prologue
    .line 51
    const-string v2, " "

    invoke-virtual {p0, v2}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p0, p1}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 54
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v1, v2, 0x1

    .line 55
    .local v1, "len":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    rsub-int/lit8 v2, v1, 0x1e

    if-ge v0, v2, :cond_0

    .line 56
    const-string v2, " "

    invoke-virtual {p0, v2}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 55
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 57
    :cond_0
    const-string v2, " "

    invoke-virtual {p0, v2}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 58
    invoke-virtual {p0, p2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 59
    return-void
.end method

.method public static printOptions(Ljava/io/PrintStream;)V
    .locals 9
    .param p0, "out"    # Ljava/io/PrintStream;

    .prologue
    .line 63
    const-string v7, "Usage: [java kawa.repl | kawa] [options ...]"

    invoke-virtual {p0, v7}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 64
    invoke-virtual {p0}, Ljava/io/PrintStream;->println()V

    .line 65
    const-string v7, " Generic options:"

    invoke-virtual {p0, v7}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 66
    const-string v7, "--help"

    const-string v8, "Show help about options"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    const-string v7, "--author"

    const-string v8, "Show author information"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    const-string v7, "--version"

    const-string v8, "Show version information"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    invoke-virtual {p0}, Ljava/io/PrintStream;->println()V

    .line 70
    const-string v7, " Options"

    invoke-virtual {p0, v7}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 71
    const-string v7, "-e <expr>"

    const-string v8, "Evaluate expression <expr>"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    const-string v7, "-c <expr>"

    const-string v8, "Same as -e, but make sure ~/.kawarc.scm is run first"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    const-string v7, "-f <filename>"

    const-string v8, "File to interpret"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    const-string v7, "-s| --"

    const-string v8, "Start reading commands interactively from console"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    const-string v7, "-w"

    const-string v8, "Launch the interpreter in a GUI window"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    const-string v7, "--server <port>"

    const-string v8, "Start a server accepting telnet connections on <port>"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    const-string v7, "--debug-dump-zip"

    const-string v8, "Compiled interactive expressions to a zip archive"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 78
    const-string v7, "--debug-print-expr"

    const-string v8, "Print generated internal expressions"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    const-string v7, "--debug-print-final-expr"

    const-string v8, "Print expression after any optimizations"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    const-string v7, "--debug-error-prints-stack-trace"

    const-string v8, "Print stack trace with errors"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 81
    const-string v7, "--debug-warning-prints-stack-trace"

    const-string v8, "Print stack trace with warnings"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    const-string v7, "--[no-]full-tailcalls"

    const-string v8, "(Don\'t) use full tail-calls"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    const-string v7, "-C <filename> ..."

    const-string v8, "Compile named files to Java class files"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 84
    const-string v7, "--output-format <format>"

    const-string v8, "Use <format> when printing top-level output"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 85
    const-string v7, "--<language>"

    const-string v8, "Select source language, one of:"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    invoke-static {}, Lgnu/expr/Language;->getLanguages()[[Ljava/lang/String;

    move-result-object v4

    .line 87
    .local v4, "languages":[[Ljava/lang/String;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v7, v4

    if-ge v0, v7, :cond_2

    .line 89
    const-string v7, "   "

    invoke-virtual {p0, v7}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 90
    aget-object v3, v4, v0

    .line 92
    .local v3, "lang":[Ljava/lang/String;
    array-length v7, v3

    add-int/lit8 v6, v7, -0x1

    .line 93
    .local v6, "nwords":I
    const/4 v1, 0x0

    .local v1, "j":I
    :goto_1
    if-ge v1, v6, :cond_0

    .line 94
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v8, v3, v1

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, v7}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 93
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 95
    :cond_0
    if-nez v0, :cond_1

    .line 96
    const-string v7, "[default]"

    invoke-virtual {p0, v7}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 97
    :cond_1
    invoke-virtual {p0}, Ljava/io/PrintStream;->println()V

    .line 87
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 99
    .end local v1    # "j":I
    .end local v3    # "lang":[Ljava/lang/String;
    .end local v6    # "nwords":I
    :cond_2
    const-string v7, " Compilation options, must be specified before -C"

    invoke-virtual {p0, v7}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 100
    const-string v7, "-d <dirname>"

    const-string v8, "Directory to place .class files in"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 101
    const-string v7, "-P <prefix>"

    const-string v8, "Prefix to prepand to class names"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    const-string v7, "-T <topname>"

    const-string v8, "name to give to top-level class"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    const-string v7, "--main"

    const-string v8, "Generate an application, with a main method"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    const-string v7, "--applet"

    const-string v8, "Generate an applet"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 106
    const-string v7, "--servlet"

    const-string v8, "Generate a servlet"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 107
    const-string v7, "--module-static"

    const-string v8, "Top-level definitions are by default static"

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    sget-object v7, Lgnu/expr/Compilation;->options:Lgnu/text/Options;

    invoke-virtual {v7}, Lgnu/text/Options;->keys()Ljava/util/ArrayList;

    move-result-object v2

    .line 110
    .local v2, "keys":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v0, 0x0

    :goto_2
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v7

    if-ge v0, v7, :cond_3

    .line 112
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 113
    .local v5, "name":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "--"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    sget-object v8, Lgnu/expr/Compilation;->options:Lgnu/text/Options;

    invoke-virtual {v8, v5}, Lgnu/text/Options;->getDoc(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-static {p0, v7, v8}, Lkawa/repl;->printOption(Ljava/io/PrintStream;Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 116
    .end local v5    # "name":Ljava/lang/String;
    :cond_3
    invoke-virtual {p0}, Ljava/io/PrintStream;->println()V

    .line 117
    const-string v7, "For more information go to:  http://www.gnu.org/software/kawa/"

    invoke-virtual {p0, v7}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 118
    return-void
.end method

.method public static processArgs([Ljava/lang/String;II)I
    .locals 45
    .param p0, "args"    # [Ljava/lang/String;
    .param p1, "iArg"    # I
    .param p2, "maxArg"    # I

    .prologue
    .line 181
    const/16 v39, 0x0

    .line 182
    .local v39, "something_done":Z
    :goto_0
    move/from16 v0, p1

    move/from16 v1, p2

    if-ge v0, v1, :cond_62

    .line 184
    aget-object v14, p0, p1

    .line 185
    .local v14, "arg":Ljava/lang/String;
    const-string v3, "-c"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string v3, "-e"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 187
    :cond_0
    add-int/lit8 p1, p1, 0x1

    .line 188
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_1

    .line 189
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 190
    :cond_1
    invoke-static {}, Lkawa/repl;->getLanguage()V

    .line 191
    add-int/lit8 v3, p1, 0x1

    move-object/from16 v0, p0

    invoke-static {v0, v3}, Lkawa/repl;->setArgs([Ljava/lang/String;I)V

    .line 192
    const-string v3, "-c"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 193
    invoke-static {}, Lkawa/repl;->checkInitFile()V

    .line 194
    :cond_2
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    move-result-object v2

    .line 195
    .local v2, "language":Lgnu/expr/Language;
    new-instance v7, Lgnu/text/SourceMessages;

    invoke-direct {v7}, Lgnu/text/SourceMessages;-><init>()V

    .line 196
    .local v7, "messages":Lgnu/text/SourceMessages;
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v3

    new-instance v4, Lgnu/mapping/CharArrayInPort;

    aget-object v5, p0, p1

    invoke-direct {v4, v5}, Lgnu/mapping/CharArrayInPort;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lgnu/mapping/OutPort;->outDefault()Lgnu/mapping/OutPort;

    move-result-object v5

    const/4 v6, 0x0

    invoke-static/range {v2 .. v7}, Lkawa/Shell;->run(Lgnu/expr/Language;Lgnu/mapping/Environment;Lgnu/mapping/InPort;Lgnu/mapping/OutPort;Lgnu/mapping/OutPort;Lgnu/text/SourceMessages;)Ljava/lang/Throwable;

    move-result-object v21

    .line 200
    .local v21, "ex":Ljava/lang/Throwable;
    if-eqz v21, :cond_3

    .line 202
    invoke-static {}, Lgnu/mapping/OutPort;->errDefault()Lgnu/mapping/OutPort;

    move-result-object v3

    move-object/from16 v0, v21

    invoke-static {v0, v7, v3}, Lkawa/Shell;->printError(Ljava/lang/Throwable;Lgnu/text/SourceMessages;Lgnu/mapping/OutPort;)V

    .line 203
    const/4 v3, -0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    .line 205
    :cond_3
    const/16 v39, 0x1

    .line 182
    .end local v2    # "language":Lgnu/expr/Language;
    .end local v7    # "messages":Lgnu/text/SourceMessages;
    .end local v21    # "ex":Ljava/lang/Throwable;
    :cond_4
    :goto_1
    add-int/lit8 p1, p1, 0x1

    goto :goto_0

    .line 207
    :cond_5
    const-string v3, "-f"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 209
    add-int/lit8 p1, p1, 0x1

    .line 210
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_6

    .line 211
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 212
    :cond_6
    aget-object v22, p0, p1

    .line 213
    .local v22, "filename":Ljava/lang/String;
    invoke-static/range {v22 .. v22}, Lkawa/repl;->getLanguageFromFilenameExtension(Ljava/lang/String;)V

    .line 214
    add-int/lit8 v3, p1, 0x1

    move-object/from16 v0, p0

    invoke-static {v0, v3}, Lkawa/repl;->setArgs([Ljava/lang/String;I)V

    .line 215
    invoke-static {}, Lkawa/repl;->checkInitFile()V

    .line 216
    const/4 v3, 0x1

    const/4 v4, 0x0

    move-object/from16 v0, v22

    invoke-static {v0, v3, v4}, Lkawa/Shell;->runFileOrClass(Ljava/lang/String;ZI)Z

    move-result v3

    if-nez v3, :cond_7

    .line 217
    const/4 v3, -0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    .line 218
    :cond_7
    const/16 v39, 0x1

    .line 219
    goto :goto_1

    .line 220
    .end local v22    # "filename":Ljava/lang/String;
    :cond_8
    const-string v3, "--script"

    invoke-virtual {v14, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_c

    .line 222
    const/16 v3, 0x8

    invoke-virtual {v14, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v18

    .line 223
    .local v18, "count":Ljava/lang/String;
    add-int/lit8 p1, p1, 0x1

    .line 224
    const/16 v37, 0x0

    .line 225
    .local v37, "skipLines":I
    invoke-virtual/range {v18 .. v18}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_9

    .line 229
    :try_start_0
    invoke-static/range {v18 .. v18}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v37

    .line 236
    :cond_9
    :goto_2
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_a

    .line 237
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 238
    :cond_a
    aget-object v22, p0, p1

    .line 239
    .restart local v22    # "filename":Ljava/lang/String;
    invoke-static/range {v22 .. v22}, Lkawa/repl;->getLanguageFromFilenameExtension(Ljava/lang/String;)V

    .line 240
    add-int/lit8 v3, p1, 0x1

    move-object/from16 v0, p0

    invoke-static {v0, v3}, Lkawa/repl;->setArgs([Ljava/lang/String;I)V

    .line 241
    invoke-static {}, Lkawa/repl;->checkInitFile()V

    .line 242
    const/4 v3, 0x1

    move-object/from16 v0, v22

    move/from16 v1, v37

    invoke-static {v0, v3, v1}, Lkawa/Shell;->runFileOrClass(Ljava/lang/String;ZI)Z

    move-result v3

    if-nez v3, :cond_b

    .line 243
    const/4 v3, -0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    .line 244
    :cond_b
    const/4 v3, -0x1

    .line 713
    .end local v14    # "arg":Ljava/lang/String;
    .end local v18    # "count":Ljava/lang/String;
    .end local v22    # "filename":Ljava/lang/String;
    .end local v37    # "skipLines":I
    :goto_3
    return v3

    .line 231
    .restart local v14    # "arg":Ljava/lang/String;
    .restart local v18    # "count":Ljava/lang/String;
    .restart local v37    # "skipLines":I
    :catch_0
    move-exception v21

    .line 233
    .restart local v21    # "ex":Ljava/lang/Throwable;
    move/from16 p1, p2

    goto :goto_2

    .line 246
    .end local v18    # "count":Ljava/lang/String;
    .end local v21    # "ex":Ljava/lang/Throwable;
    .end local v37    # "skipLines":I
    :cond_c
    const-string v3, "\\"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1c

    .line 249
    add-int/lit8 p1, p1, 0x1

    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_d

    .line 250
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 251
    :cond_d
    aget-object v22, p0, p1

    .line 253
    .restart local v22    # "filename":Ljava/lang/String;
    new-instance v7, Lgnu/text/SourceMessages;

    invoke-direct {v7}, Lgnu/text/SourceMessages;-><init>()V

    .line 256
    .restart local v7    # "messages":Lgnu/text/SourceMessages;
    :try_start_1
    new-instance v23, Ljava/io/BufferedInputStream;

    new-instance v3, Ljava/io/FileInputStream;

    move-object/from16 v0, v22

    invoke-direct {v3, v0}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v23

    invoke-direct {v0, v3}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 257
    .local v23, "fstream":Ljava/io/InputStream;
    invoke-virtual/range {v23 .. v23}, Ljava/io/InputStream;->read()I

    move-result v15

    .line 258
    .local v15, "ch":I
    const/16 v3, 0x23

    if-ne v15, v3, :cond_14

    .line 260
    new-instance v34, Ljava/lang/StringBuffer;

    const/16 v3, 0x64

    move-object/from16 v0, v34

    invoke-direct {v0, v3}, Ljava/lang/StringBuffer;-><init>(I)V

    .line 261
    .local v34, "sbuf":Ljava/lang/StringBuffer;
    new-instance v44, Ljava/util/Vector;

    const/16 v3, 0xa

    move-object/from16 v0, v44

    invoke-direct {v0, v3}, Ljava/util/Vector;-><init>(I)V

    .line 262
    .local v44, "xargs":Ljava/util/Vector;
    const/16 v43, 0x0

    .line 263
    .local v43, "state":I
    :goto_4
    const/16 v3, 0xa

    if-eq v15, v3, :cond_e

    const/16 v3, 0xd

    if-eq v15, v3, :cond_e

    if-ltz v15, :cond_e

    .line 264
    invoke-virtual/range {v23 .. v23}, Ljava/io/InputStream;->read()I

    move-result v15

    goto :goto_4

    .line 267
    :cond_e
    :goto_5
    invoke-virtual/range {v23 .. v23}, Ljava/io/InputStream;->read()I

    move-result v15

    .line 268
    if-gez v15, :cond_f

    .line 270
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "unexpected end-of-file processing argument line for: \'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v22

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v5, 0x27

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 271
    const/4 v3, -0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    .line 273
    :cond_f
    if-nez v43, :cond_19

    .line 275
    const/16 v3, 0x5c

    if-eq v15, v3, :cond_10

    const/16 v3, 0x27

    if-eq v15, v3, :cond_10

    const/16 v3, 0x22

    if-ne v15, v3, :cond_11

    .line 277
    :cond_10
    move/from16 v43, v15

    .line 278
    goto :goto_5

    .line 280
    :cond_11
    const/16 v3, 0xa

    if-eq v15, v3, :cond_12

    const/16 v3, 0xd

    if-ne v15, v3, :cond_17

    .line 301
    :cond_12
    invoke-virtual/range {v34 .. v34}, Ljava/lang/StringBuffer;->length()I

    move-result v3

    if-lez v3, :cond_13

    .line 302
    invoke-virtual/range {v34 .. v34}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v44

    invoke-virtual {v0, v3}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 303
    :cond_13
    invoke-virtual/range {v44 .. v44}, Ljava/util/Vector;->size()I

    move-result v29

    .line 304
    .local v29, "nxargs":I
    if-lez v29, :cond_14

    .line 306
    move/from16 v0, v29

    new-array v0, v0, [Ljava/lang/String;

    move-object/from16 v33, v0

    .line 307
    .local v33, "sargs":[Ljava/lang/String;
    move-object/from16 v0, v44

    move-object/from16 v1, v33

    invoke-virtual {v0, v1}, Ljava/util/Vector;->copyInto([Ljava/lang/Object;)V

    .line 308
    const/4 v3, 0x0

    move-object/from16 v0, v33

    move/from16 v1, v29

    invoke-static {v0, v3, v1}, Lkawa/repl;->processArgs([Ljava/lang/String;II)I

    move-result v24

    .line 309
    .local v24, "ixarg":I
    if-ltz v24, :cond_14

    move/from16 v0, v24

    move/from16 v1, v29

    if-ge v0, v1, :cond_14

    .line 311
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, ""

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sub-int v5, v29, v24

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " unused meta args"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 315
    .end local v24    # "ixarg":I
    .end local v29    # "nxargs":I
    .end local v33    # "sargs":[Ljava/lang/String;
    .end local v34    # "sbuf":Ljava/lang/StringBuffer;
    .end local v43    # "state":I
    .end local v44    # "xargs":Ljava/util/Vector;
    :cond_14
    invoke-static/range {v22 .. v22}, Lkawa/repl;->getLanguageFromFilenameExtension(Ljava/lang/String;)V

    .line 316
    move-object/from16 v0, v23

    move-object/from16 v1, v22

    invoke-static {v0, v1}, Lgnu/mapping/InPort;->openFile(Ljava/io/InputStream;Ljava/lang/Object;)Lgnu/mapping/InPort;

    move-result-object v10

    .line 318
    .local v10, "freader":Lgnu/mapping/InPort;
    add-int/lit8 v3, p1, 0x1

    move-object/from16 v0, p0

    invoke-static {v0, v3}, Lkawa/repl;->setArgs([Ljava/lang/String;I)V

    .line 319
    invoke-static {}, Lkawa/repl;->checkInitFile()V

    .line 320
    invoke-static {}, Lgnu/mapping/OutPort;->errDefault()Lgnu/mapping/OutPort;

    move-result-object v20

    .line 321
    .local v20, "err":Lgnu/mapping/OutPort;
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    move-result-object v8

    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v9

    invoke-static {}, Lgnu/mapping/OutPort;->outDefault()Lgnu/mapping/OutPort;

    move-result-object v11

    const/4 v12, 0x0

    move-object v13, v7

    invoke-static/range {v8 .. v13}, Lkawa/Shell;->run(Lgnu/expr/Language;Lgnu/mapping/Environment;Lgnu/mapping/InPort;Lgnu/mapping/OutPort;Lgnu/mapping/OutPort;Lgnu/text/SourceMessages;)Ljava/lang/Throwable;

    move-result-object v21

    .line 325
    .restart local v21    # "ex":Ljava/lang/Throwable;
    const/16 v3, 0x14

    move-object/from16 v0, v20

    invoke-virtual {v7, v0, v3}, Lgnu/text/SourceMessages;->printAll(Ljava/io/PrintWriter;I)V

    .line 326
    if-eqz v21, :cond_16

    .line 328
    move-object/from16 v0, v21

    instance-of v3, v0, Lgnu/text/SyntaxException;

    if-eqz v3, :cond_15

    .line 330
    move-object/from16 v0, v21

    check-cast v0, Lgnu/text/SyntaxException;

    move-object/from16 v35, v0

    .line 331
    .local v35, "se":Lgnu/text/SyntaxException;
    invoke-virtual/range {v35 .. v35}, Lgnu/text/SyntaxException;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v3

    if-ne v3, v7, :cond_15

    .line 332
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    .line 334
    .end local v35    # "se":Lgnu/text/SyntaxException;
    :cond_15
    throw v21
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_1

    .line 337
    .end local v10    # "freader":Lgnu/mapping/InPort;
    .end local v15    # "ch":I
    .end local v20    # "err":Lgnu/mapping/OutPort;
    .end local v21    # "ex":Ljava/lang/Throwable;
    .end local v23    # "fstream":Ljava/io/InputStream;
    :catch_1
    move-exception v21

    .line 339
    .restart local v21    # "ex":Ljava/lang/Throwable;
    invoke-static {}, Lgnu/mapping/OutPort;->errDefault()Lgnu/mapping/OutPort;

    move-result-object v3

    move-object/from16 v0, v21

    invoke-static {v0, v7, v3}, Lkawa/Shell;->printError(Ljava/lang/Throwable;Lgnu/text/SourceMessages;Lgnu/mapping/OutPort;)V

    .line 340
    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    .line 342
    :cond_16
    const/4 v3, -0x1

    goto/16 :goto_3

    .line 282
    .end local v21    # "ex":Ljava/lang/Throwable;
    .restart local v15    # "ch":I
    .restart local v23    # "fstream":Ljava/io/InputStream;
    .restart local v34    # "sbuf":Ljava/lang/StringBuffer;
    .restart local v43    # "state":I
    .restart local v44    # "xargs":Ljava/util/Vector;
    :cond_17
    const/16 v3, 0x20

    if-eq v15, v3, :cond_18

    const/16 v3, 0x9

    if-ne v15, v3, :cond_1a

    .line 284
    :cond_18
    :try_start_2
    invoke-virtual/range {v34 .. v34}, Ljava/lang/StringBuffer;->length()I

    move-result v3

    if-lez v3, :cond_e

    .line 286
    invoke-virtual/range {v34 .. v34}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, v44

    invoke-virtual {v0, v3}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V

    .line 287
    const/4 v3, 0x0

    move-object/from16 v0, v34

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->setLength(I)V

    goto/16 :goto_5

    .line 292
    :cond_19
    const/16 v3, 0x5c

    move/from16 v0, v43

    if-ne v0, v3, :cond_1b

    .line 293
    const/16 v43, 0x0

    .line 299
    :cond_1a
    int-to-char v3, v15

    move-object/from16 v0, v34

    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_5

    .line 294
    :cond_1b
    move/from16 v0, v43

    if-ne v15, v0, :cond_1a

    .line 296
    const/16 v43, 0x0

    .line 297
    goto/16 :goto_5

    .line 344
    .end local v7    # "messages":Lgnu/text/SourceMessages;
    .end local v15    # "ch":I
    .end local v22    # "filename":Ljava/lang/String;
    .end local v23    # "fstream":Ljava/io/InputStream;
    .end local v34    # "sbuf":Ljava/lang/StringBuffer;
    .end local v43    # "state":I
    .end local v44    # "xargs":Ljava/util/Vector;
    :cond_1c
    const-string v3, "-s"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1d

    const-string v3, "--"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1e

    .line 346
    :cond_1d
    add-int/lit8 p1, p1, 0x1

    .line 347
    invoke-static {}, Lkawa/repl;->getLanguage()V

    .line 348
    invoke-static/range {p0 .. p1}, Lkawa/repl;->setArgs([Ljava/lang/String;I)V

    .line 349
    invoke-static {}, Lkawa/repl;->checkInitFile()V

    .line 350
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    move-result-object v3

    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v4

    invoke-static {v3, v4}, Lkawa/Shell;->run(Lgnu/expr/Language;Lgnu/mapping/Environment;)Z

    .line 351
    const/4 v3, -0x1

    goto/16 :goto_3

    .line 353
    :cond_1e
    const-string v3, "-w"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1f

    .line 355
    add-int/lit8 p1, p1, 0x1

    .line 356
    invoke-static {}, Lkawa/repl;->getLanguage()V

    .line 357
    invoke-static/range {p0 .. p1}, Lkawa/repl;->setArgs([Ljava/lang/String;I)V

    .line 358
    invoke-static {}, Lkawa/repl;->checkInitFile()V

    .line 359
    invoke-static {}, Lkawa/repl;->startGuiConsole()V

    .line 360
    const/16 v39, 0x1

    goto/16 :goto_1

    .line 362
    :cond_1f
    const-string v3, "-d"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_21

    .line 364
    add-int/lit8 p1, p1, 0x1

    .line 365
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_20

    .line 366
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 367
    :cond_20
    invoke-static {}, Lgnu/expr/ModuleManager;->getInstance()Lgnu/expr/ModuleManager;

    move-result-object v26

    .line 368
    .local v26, "manager":Lgnu/expr/ModuleManager;
    aget-object v3, p0, p1

    move-object/from16 v0, v26

    invoke-virtual {v0, v3}, Lgnu/expr/ModuleManager;->setCompilationDirectory(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 370
    .end local v26    # "manager":Lgnu/expr/ModuleManager;
    :cond_21
    const-string v3, "--target"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_22

    const-string v3, "target"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2d

    .line 372
    :cond_22
    add-int/lit8 p1, p1, 0x1

    .line 373
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_23

    .line 374
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 375
    :cond_23
    aget-object v14, p0, p1

    .line 376
    const-string v3, "7"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_24

    .line 377
    const/high16 v3, 0x330000

    sput v3, Lgnu/expr/Compilation;->defaultClassFileVersion:I

    .line 378
    :cond_24
    const-string v3, "6"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_25

    const-string v3, "1.6"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_26

    .line 379
    :cond_25
    const/high16 v3, 0x320000

    sput v3, Lgnu/expr/Compilation;->defaultClassFileVersion:I

    goto/16 :goto_1

    .line 380
    :cond_26
    const-string v3, "5"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_27

    const-string v3, "1.5"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_28

    .line 381
    :cond_27
    const/high16 v3, 0x310000    # 4.49994E-39f

    sput v3, Lgnu/expr/Compilation;->defaultClassFileVersion:I

    goto/16 :goto_1

    .line 382
    :cond_28
    const-string v3, "1.4"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_29

    .line 383
    const/high16 v3, 0x300000

    sput v3, Lgnu/expr/Compilation;->defaultClassFileVersion:I

    goto/16 :goto_1

    .line 384
    :cond_29
    const-string v3, "1.3"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2a

    .line 385
    const/high16 v3, 0x2f0000

    sput v3, Lgnu/expr/Compilation;->defaultClassFileVersion:I

    goto/16 :goto_1

    .line 386
    :cond_2a
    const-string v3, "1.2"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2b

    .line 387
    const/high16 v3, 0x2e0000

    sput v3, Lgnu/expr/Compilation;->defaultClassFileVersion:I

    goto/16 :goto_1

    .line 388
    :cond_2b
    const-string v3, "1.1"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2c

    .line 389
    const v3, 0x2d0003

    sput v3, Lgnu/expr/Compilation;->defaultClassFileVersion:I

    goto/16 :goto_1

    .line 391
    :cond_2c
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 393
    :cond_2d
    const-string v3, "-P"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2f

    .line 395
    add-int/lit8 p1, p1, 0x1

    .line 396
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_2e

    .line 397
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 398
    :cond_2e
    aget-object v3, p0, p1

    sput-object v3, Lgnu/expr/Compilation;->classPrefixDefault:Ljava/lang/String;

    goto/16 :goto_1

    .line 400
    :cond_2f
    const-string v3, "-T"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_31

    .line 402
    add-int/lit8 p1, p1, 0x1

    .line 403
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_30

    .line 404
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 405
    :cond_30
    aget-object v3, p0, p1

    sput-object v3, Lkawa/repl;->compilationTopname:Ljava/lang/String;

    goto/16 :goto_1

    .line 407
    :cond_31
    const-string v3, "-C"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_33

    .line 409
    add-int/lit8 p1, p1, 0x1

    .line 410
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_32

    .line 411
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 412
    :cond_32
    invoke-static/range {p0 .. p2}, Lkawa/repl;->compileFiles([Ljava/lang/String;II)V

    .line 413
    const/4 v3, -0x1

    goto/16 :goto_3

    .line 415
    :cond_33
    const-string v3, "--output-format"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_34

    const-string v3, "--format"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_36

    .line 418
    :cond_34
    add-int/lit8 p1, p1, 0x1

    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_35

    .line 419
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 420
    :cond_35
    aget-object v3, p0, p1

    invoke-static {v3}, Lkawa/Shell;->setDefaultFormat(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 422
    :cond_36
    const-string v3, "--connect"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_39

    .line 424
    add-int/lit8 p1, p1, 0x1

    .line 425
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_37

    .line 426
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 428
    :cond_37
    aget-object v3, p0, p1

    const-string v4, "-"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_38

    .line 429
    const/16 v31, 0x0

    .line 444
    .local v31, "port":I
    :goto_6
    :try_start_3
    new-instance v38, Ljava/net/Socket;

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v3

    move-object/from16 v0, v38

    move/from16 v1, v31

    invoke-direct {v0, v3, v1}, Ljava/net/Socket;-><init>(Ljava/net/InetAddress;I)V

    .line 445
    .local v38, "socket":Ljava/net/Socket;
    new-instance v17, Lkawa/Telnet;

    const/4 v3, 0x1

    move-object/from16 v0, v17

    move-object/from16 v1, v38

    invoke-direct {v0, v1, v3}, Lkawa/Telnet;-><init>(Ljava/net/Socket;Z)V

    .line 446
    .local v17, "conn":Lkawa/Telnet;
    invoke-virtual/range {v17 .. v17}, Lkawa/Telnet;->getInputStream()Lkawa/TelnetInputStream;

    move-result-object v36

    .line 447
    .local v36, "sin":Ljava/io/InputStream;
    invoke-virtual/range {v17 .. v17}, Lkawa/Telnet;->getOutputStream()Lkawa/TelnetOutputStream;

    move-result-object v40

    .line 448
    .local v40, "sout":Ljava/io/OutputStream;
    new-instance v32, Ljava/io/PrintStream;

    const/4 v3, 0x1

    move-object/from16 v0, v32

    move-object/from16 v1, v40

    invoke-direct {v0, v1, v3}, Ljava/io/PrintStream;-><init>(Ljava/io/OutputStream;Z)V

    .line 449
    .local v32, "pout":Ljava/io/PrintStream;
    invoke-static/range {v36 .. v36}, Ljava/lang/System;->setIn(Ljava/io/InputStream;)V

    .line 450
    invoke-static/range {v32 .. v32}, Ljava/lang/System;->setOut(Ljava/io/PrintStream;)V

    .line 451
    invoke-static/range {v32 .. v32}, Ljava/lang/System;->setErr(Ljava/io/PrintStream;)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    goto/16 :goto_1

    .line 453
    .end local v17    # "conn":Lkawa/Telnet;
    .end local v32    # "pout":Ljava/io/PrintStream;
    .end local v36    # "sin":Ljava/io/InputStream;
    .end local v38    # "socket":Ljava/net/Socket;
    .end local v40    # "sout":Ljava/io/OutputStream;
    :catch_2
    move-exception v21

    .line 455
    .local v21, "ex":Ljava/io/IOException;
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    move-object/from16 v0, v21

    invoke-virtual {v0, v3}, Ljava/io/IOException;->printStackTrace(Ljava/io/PrintStream;)V

    .line 456
    new-instance v3, Ljava/lang/Error;

    invoke-virtual/range {v21 .. v21}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v3

    .line 434
    .end local v21    # "ex":Ljava/io/IOException;
    .end local v31    # "port":I
    :cond_38
    :try_start_4
    aget-object v3, p0, p1

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_4
    .catch Ljava/lang/NumberFormatException; {:try_start_4 .. :try_end_4} :catch_3

    move-result v31

    .restart local v31    # "port":I
    goto :goto_6

    .line 436
    .end local v31    # "port":I
    :catch_3
    move-exception v21

    .line 438
    .local v21, "ex":Ljava/lang/NumberFormatException;
    const-string v3, "--connect port#"

    invoke-static {v3}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 439
    const/16 v31, -0x1

    .restart local v31    # "port":I
    goto :goto_6

    .line 459
    .end local v21    # "ex":Ljava/lang/NumberFormatException;
    .end local v31    # "port":I
    :cond_39
    const-string v3, "--server"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3c

    .line 461
    invoke-static {}, Lkawa/repl;->getLanguage()V

    .line 462
    add-int/lit8 p1, p1, 0x1

    .line 463
    move/from16 v0, p1

    move/from16 v1, p2

    if-ne v0, v1, :cond_3a

    .line 464
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 466
    :cond_3a
    aget-object v3, p0, p1

    const-string v4, "-"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3b

    .line 467
    const/16 v31, 0x0

    .line 482
    .restart local v31    # "port":I
    :goto_7
    :try_start_5
    new-instance v41, Ljava/net/ServerSocket;

    move-object/from16 v0, v41

    move/from16 v1, v31

    invoke-direct {v0, v1}, Ljava/net/ServerSocket;-><init>(I)V

    .line 484
    .local v41, "ssocket":Ljava/net/ServerSocket;
    invoke-virtual/range {v41 .. v41}, Ljava/net/ServerSocket;->getLocalPort()I

    move-result v31

    .line 485
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Listening on port "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move/from16 v0, v31

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 488
    :goto_8
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v4, "waiting ... "

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    invoke-virtual {v3}, Ljava/io/PrintStream;->flush()V

    .line 489
    invoke-virtual/range {v41 .. v41}, Ljava/net/ServerSocket;->accept()Ljava/net/Socket;

    move-result-object v16

    .line 490
    .local v16, "client":Ljava/net/Socket;
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "got connection from "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v16 .. v16}, Ljava/net/Socket;->getInetAddress()Ljava/net/InetAddress;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " port:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v16 .. v16}, Ljava/net/Socket;->getPort()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 493
    invoke-static {}, Lgnu/expr/Language;->getDefaultLanguage()Lgnu/expr/Language;

    move-result-object v3

    move-object/from16 v0, v16

    invoke-static {v3, v0}, Lkawa/TelnetRepl;->serve(Lgnu/expr/Language;Ljava/net/Socket;)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_4

    goto :goto_8

    .line 496
    .end local v16    # "client":Ljava/net/Socket;
    .end local v41    # "ssocket":Ljava/net/ServerSocket;
    :catch_4
    move-exception v21

    .line 498
    .local v21, "ex":Ljava/io/IOException;
    new-instance v3, Ljava/lang/Error;

    invoke-virtual/range {v21 .. v21}, Ljava/io/IOException;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/Error;-><init>(Ljava/lang/String;)V

    throw v3

    .line 472
    .end local v21    # "ex":Ljava/io/IOException;
    .end local v31    # "port":I
    :cond_3b
    :try_start_6
    aget-object v3, p0, p1

    invoke-static {v3}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_6
    .catch Ljava/lang/NumberFormatException; {:try_start_6 .. :try_end_6} :catch_5

    move-result v31

    .restart local v31    # "port":I
    goto :goto_7

    .line 474
    .end local v31    # "port":I
    :catch_5
    move-exception v21

    .line 476
    .local v21, "ex":Ljava/lang/NumberFormatException;
    const-string v3, "--server port#"

    invoke-static {v3}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 477
    const/16 v31, -0x1

    .restart local v31    # "port":I
    goto/16 :goto_7

    .line 501
    .end local v21    # "ex":Ljava/lang/NumberFormatException;
    .end local v31    # "port":I
    :cond_3c
    const-string v3, "--http-auto-handler"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3e

    .line 503
    add-int/lit8 p1, p1, 0x2

    .line 504
    move/from16 v0, p1

    move/from16 v1, p2

    if-lt v0, v1, :cond_3d

    .line 505
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 521
    :cond_3d
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v4, "kawa: HttpServer classes not found"

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 522
    const/4 v3, -0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    goto/16 :goto_1

    .line 525
    :cond_3e
    const-string v3, "--http-start"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_40

    .line 527
    add-int/lit8 p1, p1, 0x1

    .line 528
    move/from16 v0, p1

    move/from16 v1, p2

    if-lt v0, v1, :cond_3f

    .line 529
    const-string v3, "missing httpd port argument"

    invoke-static {v3}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    .line 556
    :cond_3f
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    const-string v4, "kawa: HttpServer classes not found"

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 557
    const/4 v3, -0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    goto/16 :goto_1

    .line 560
    :cond_40
    const-string v3, "--main"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_41

    .line 562
    const/4 v3, 0x1

    sput-boolean v3, Lgnu/expr/Compilation;->generateMainDefault:Z

    goto/16 :goto_1

    .line 564
    :cond_41
    const-string v3, "--applet"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_42

    .line 566
    sget v3, Lkawa/repl;->defaultParseOptions:I

    or-int/lit8 v3, v3, 0x10

    sput v3, Lkawa/repl;->defaultParseOptions:I

    goto/16 :goto_1

    .line 568
    :cond_42
    const-string v3, "--servlet"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_43

    .line 570
    sget v3, Lkawa/repl;->defaultParseOptions:I

    or-int/lit8 v3, v3, 0x20

    sput v3, Lkawa/repl;->defaultParseOptions:I

    .line 571
    const/4 v3, 0x2

    sput v3, Lgnu/kawa/servlet/HttpRequestContext;->importServletDefinitions:I

    goto/16 :goto_1

    .line 573
    :cond_43
    const-string v3, "--debug-dump-zip"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_44

    .line 575
    const-string v3, "kawa-zip-dump-"

    sput-object v3, Lgnu/expr/ModuleExp;->dumpZipPrefix:Ljava/lang/String;

    goto/16 :goto_1

    .line 577
    :cond_44
    const-string v3, "--debug-print-expr"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_45

    .line 579
    const/4 v3, 0x1

    sput-boolean v3, Lgnu/expr/Compilation;->debugPrintExpr:Z

    goto/16 :goto_1

    .line 581
    :cond_45
    const-string v3, "--debug-print-final-expr"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_46

    .line 583
    const/4 v3, 0x1

    sput-boolean v3, Lgnu/expr/Compilation;->debugPrintFinalExpr:Z

    goto/16 :goto_1

    .line 585
    :cond_46
    const-string v3, "--debug-error-prints-stack-trace"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_47

    .line 587
    const/4 v3, 0x1

    sput-boolean v3, Lgnu/text/SourceMessages;->debugStackTraceOnError:Z

    goto/16 :goto_1

    .line 589
    :cond_47
    const-string v3, "--debug-warning-prints-stack-trace"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_48

    .line 591
    const/4 v3, 0x1

    sput-boolean v3, Lgnu/text/SourceMessages;->debugStackTraceOnWarning:Z

    goto/16 :goto_1

    .line 593
    :cond_48
    const-string v3, "--module-nonstatic"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_49

    const-string v3, "--no-module-static"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4a

    .line 596
    :cond_49
    const/4 v3, -0x1

    sput v3, Lgnu/expr/Compilation;->moduleStatic:I

    goto/16 :goto_1

    .line 598
    :cond_4a
    const-string v3, "--module-static"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4b

    .line 600
    const/4 v3, 0x1

    sput v3, Lgnu/expr/Compilation;->moduleStatic:I

    goto/16 :goto_1

    .line 602
    :cond_4b
    const-string v3, "--module-static-run"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4c

    .line 604
    const/4 v3, 0x2

    sput v3, Lgnu/expr/Compilation;->moduleStatic:I

    goto/16 :goto_1

    .line 606
    :cond_4c
    const-string v3, "--no-inline"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_4d

    const-string v3, "--inline=none"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4e

    .line 609
    :cond_4d
    const/4 v3, 0x0

    sput-boolean v3, Lgnu/expr/Compilation;->inlineOk:Z

    goto/16 :goto_1

    .line 611
    :cond_4e
    const-string v3, "--no-console"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4f

    .line 612
    const/4 v3, 0x1

    sput-boolean v3, Lkawa/repl;->noConsole:Z

    goto/16 :goto_1

    .line 613
    :cond_4f
    const-string v3, "--inline"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_50

    .line 615
    const/4 v3, 0x1

    sput-boolean v3, Lgnu/expr/Compilation;->inlineOk:Z

    goto/16 :goto_1

    .line 617
    :cond_50
    const-string v3, "--cps"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_51

    .line 619
    const/4 v3, 0x4

    sput v3, Lgnu/expr/Compilation;->defaultCallConvention:I

    goto/16 :goto_1

    .line 622
    :cond_51
    const-string v3, "--full-tailcalls"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_52

    .line 624
    const/4 v3, 0x3

    sput v3, Lgnu/expr/Compilation;->defaultCallConvention:I

    goto/16 :goto_1

    .line 627
    :cond_52
    const-string v3, "--no-full-tailcalls"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_53

    .line 629
    const/4 v3, 0x1

    sput v3, Lgnu/expr/Compilation;->defaultCallConvention:I

    goto/16 :goto_1

    .line 632
    :cond_53
    const-string v3, "--pedantic"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_54

    .line 634
    const/4 v3, 0x1

    sput-boolean v3, Lgnu/expr/Language;->requirePedantic:Z

    goto/16 :goto_1

    .line 636
    :cond_54
    const-string v3, "--help"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_55

    .line 638
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-static {v3}, Lkawa/repl;->printOptions(Ljava/io/PrintStream;)V

    .line 639
    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    goto/16 :goto_1

    .line 641
    :cond_55
    const-string v3, "--author"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_56

    .line 643
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v4, "Per Bothner <per@bothner.com>"

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 644
    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    goto/16 :goto_1

    .line 646
    :cond_56
    const-string v3, "--version"

    invoke-virtual {v14, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_57

    .line 648
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v4, "Kawa "

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 649
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-static {}, Lkawa/Version;->getVersion()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 650
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    invoke-virtual {v3}, Ljava/io/PrintStream;->println()V

    .line 651
    sget-object v3, Ljava/lang/System;->out:Ljava/io/PrintStream;

    const-string v4, "Copyright (C) 2009 Per Bothner"

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 652
    const/16 v39, 0x1

    goto/16 :goto_1

    .line 654
    :cond_57
    invoke-virtual {v14}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_61

    const/4 v3, 0x0

    invoke-virtual {v14, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x2d

    if-ne v3, v4, :cond_61

    .line 656
    move-object/from16 v28, v14

    .line 657
    .local v28, "name":Ljava/lang/String;
    invoke-virtual/range {v28 .. v28}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x2

    if-le v3, v4, :cond_58

    const/4 v3, 0x0

    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x2d

    if-ne v3, v4, :cond_58

    .line 658
    const/4 v3, 0x1

    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Ljava/lang/String;->charAt(I)C

    move-result v3

    const/16 v4, 0x2d

    if-ne v3, v4, :cond_59

    const/4 v3, 0x2

    :goto_9
    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v28

    .line 659
    :cond_58
    invoke-static/range {v28 .. v28}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v25

    .line 660
    .local v25, "lang":Lgnu/expr/Language;
    if-eqz v25, :cond_5b

    .line 662
    sget-object v3, Lkawa/repl;->previousLanguage:Lgnu/expr/Language;

    if-nez v3, :cond_5a

    .line 663
    invoke-static/range {v25 .. v25}, Lgnu/expr/Language;->setDefaults(Lgnu/expr/Language;)V

    .line 666
    :goto_a
    sput-object v25, Lkawa/repl;->previousLanguage:Lgnu/expr/Language;

    goto/16 :goto_1

    .line 658
    .end local v25    # "lang":Lgnu/expr/Language;
    :cond_59
    const/4 v3, 0x1

    goto :goto_9

    .line 665
    .restart local v25    # "lang":Lgnu/expr/Language;
    :cond_5a
    invoke-static/range {v25 .. v25}, Lgnu/expr/Language;->setCurrentLanguage(Lgnu/expr/Language;)V

    goto :goto_a

    .line 671
    :cond_5b
    const-string v3, "="

    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v19

    .line 673
    .local v19, "eq":I
    if-gez v19, :cond_5e

    .line 674
    const/16 v30, 0x0

    .line 682
    .local v30, "opt_value":Ljava/lang/String;
    :goto_b
    const-string v3, "no-"

    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_5f

    invoke-virtual/range {v28 .. v28}, Ljava/lang/String;->length()I

    move-result v3

    const/4 v4, 0x3

    if-le v3, v4, :cond_5f

    const/16 v42, 0x1

    .line 684
    .local v42, "startsWithNo":Z
    :goto_c
    if-nez v30, :cond_5c

    if-eqz v42, :cond_5c

    .line 686
    const-string v30, "no"

    .line 687
    const/4 v3, 0x3

    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v28

    .line 690
    :cond_5c
    sget-object v3, Lgnu/expr/Compilation;->options:Lgnu/text/Options;

    move-object/from16 v0, v28

    move-object/from16 v1, v30

    invoke-virtual {v3, v0, v1}, Lgnu/text/Options;->set(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v27

    .line 691
    .local v27, "msg":Ljava/lang/String;
    if-eqz v27, :cond_4

    .line 694
    if-eqz v42, :cond_5d

    const-string v3, "unknown option name"

    move-object/from16 v0, v27

    if-ne v0, v3, :cond_5d

    .line 695
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "both \'--no-\' prefix and \'="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, v30

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\' specified"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v27

    .line 697
    :cond_5d
    const-string v3, "unknown option name"

    move-object/from16 v0, v27

    if-ne v0, v3, :cond_60

    .line 699
    invoke-static {v14}, Lkawa/repl;->bad_option(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 677
    .end local v27    # "msg":Ljava/lang/String;
    .end local v30    # "opt_value":Ljava/lang/String;
    .end local v42    # "startsWithNo":Z
    :cond_5e
    add-int/lit8 v3, v19, 0x1

    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v30

    .line 678
    .restart local v30    # "opt_value":Ljava/lang/String;
    const/4 v3, 0x0

    move-object/from16 v0, v28

    move/from16 v1, v19

    invoke-virtual {v0, v3, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v28

    goto :goto_b

    .line 682
    :cond_5f
    const/16 v42, 0x0

    goto :goto_c

    .line 703
    .restart local v27    # "msg":Ljava/lang/String;
    .restart local v42    # "startsWithNo":Z
    :cond_60
    sget-object v3, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "kawa: bad option \'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\': "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v27

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 705
    const/4 v3, -0x1

    invoke-static {v3}, Ljava/lang/System;->exit(I)V

    goto/16 :goto_1

    .line 710
    .end local v19    # "eq":I
    .end local v25    # "lang":Lgnu/expr/Language;
    .end local v27    # "msg":Ljava/lang/String;
    .end local v28    # "name":Ljava/lang/String;
    .end local v30    # "opt_value":Ljava/lang/String;
    .end local v42    # "startsWithNo":Z
    :cond_61
    invoke-static {v14}, Lgnu/expr/ApplicationMainSupport;->processSetProperty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 713
    .end local v14    # "arg":Ljava/lang/String;
    :cond_62
    if-eqz v39, :cond_63

    const/4 v3, -0x1

    goto/16 :goto_3

    :cond_63
    move/from16 v3, p1

    goto/16 :goto_3
.end method

.method public static setArgs([Ljava/lang/String;I)V
    .locals 0
    .param p0, "args"    # [Ljava/lang/String;
    .param p1, "arg_start"    # I

    .prologue
    .line 150
    invoke-static {p0, p1}, Lgnu/expr/ApplicationMainSupport;->setArgs([Ljava/lang/String;I)V

    .line 151
    return-void
.end method

.method public static shouldUseGuiConsole()Z
    .locals 5

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 870
    sget-boolean v2, Lkawa/repl;->noConsole:Z

    if-eqz v2, :cond_1

    .line 882
    :cond_0
    :goto_0
    return v0

    .line 874
    :cond_1
    :try_start_0
    const-string v2, "java.lang.System"

    invoke-static {v2}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v2

    const-string v3, "console"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Class;

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v2, v3, v4}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    if-eqz v2, :cond_0

    :goto_1
    move v0, v1

    .line 882
    goto :goto_0

    .line 879
    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method private static startGuiConsole()V
    .locals 4

    .prologue
    .line 891
    :try_start_0
    const-string v1, "kawa.GuiConsole"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 898
    .local v0, "ex":Ljava/lang/Exception;
    :goto_0
    return-void

    .line 893
    .end local v0    # "ex":Ljava/lang/Exception;
    :catch_0
    move-exception v0

    .line 895
    .restart local v0    # "ex":Ljava/lang/Exception;
    sget-object v1, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "failed to create Kawa window: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 896
    const/4 v1, -0x1

    invoke-static {v1}, Ljava/lang/System;->exit(I)V

    goto :goto_0
.end method


# virtual methods
.method public apply0()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 32
    iget-object v0, p0, Lkawa/repl;->language:Lgnu/expr/Language;

    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v1

    invoke-static {v0, v1}, Lkawa/Shell;->run(Lgnu/expr/Language;Lgnu/mapping/Environment;)Z

    .line 33
    sget-object v0, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    return-object v0
.end method

.method public apply1(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "env"    # Ljava/lang/Object;

    .prologue
    .line 38
    iget-object v0, p0, Lkawa/repl;->language:Lgnu/expr/Language;

    check-cast p1, Lgnu/mapping/Environment;

    .end local p1    # "env":Ljava/lang/Object;
    invoke-static {v0, p1}, Lkawa/Shell;->run(Lgnu/expr/Language;Lgnu/mapping/Environment;)Z

    .line 39
    sget-object v0, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    return-object v0
.end method
