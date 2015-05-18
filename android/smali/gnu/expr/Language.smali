.class public abstract Lgnu/expr/Language;
.super Ljava/lang/Object;
.source "Language.java"


# static fields
.field public static final FUNCTION_NAMESPACE:I = 0x2

.field public static final NAMESPACE_PREFIX_NAMESPACE:I = 0x4

.field public static final PARSE_CURRENT_NAMES:I = 0x2

.field public static final PARSE_EXPLICIT:I = 0x40

.field public static final PARSE_FOR_APPLET:I = 0x10

.field public static final PARSE_FOR_EVAL:I = 0x3

.field public static final PARSE_FOR_SERVLET:I = 0x20

.field public static final PARSE_IMMEDIATE:I = 0x1

.field public static final PARSE_ONE_LINE:I = 0x4

.field public static final PARSE_PROLOG:I = 0x8

.field public static final VALUE_NAMESPACE:I = 0x1

.field protected static final current:Ljava/lang/InheritableThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/InheritableThreadLocal",
            "<",
            "Lgnu/expr/Language;",
            ">;"
        }
    .end annotation
.end field

.field static envCounter:I

.field protected static env_counter:I

.field protected static global:Lgnu/expr/Language;

.field static languages:[[Ljava/lang/String;

.field public static requirePedantic:Z


# instance fields
.field protected environ:Lgnu/mapping/Environment;

.field protected userEnv:Lgnu/mapping/Environment;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 26
    new-instance v0, Ljava/lang/InheritableThreadLocal;

    invoke-direct {v0}, Ljava/lang/InheritableThreadLocal;-><init>()V

    sput-object v0, Lgnu/expr/Language;->current:Ljava/lang/InheritableThreadLocal;

    .line 36
    invoke-static {}, Lgnu/expr/BuiltinEnvironment;->getInstance()Lgnu/expr/BuiltinEnvironment;

    move-result-object v0

    invoke-static {v0}, Lgnu/mapping/Environment;->setGlobal(Lgnu/mapping/Environment;)V

    .line 62
    const/16 v0, 0x8

    new-array v0, v0, [[Ljava/lang/String;

    new-array v1, v8, [Ljava/lang/String;

    const-string v2, "scheme"

    aput-object v2, v1, v5

    const-string v2, ".scm"

    aput-object v2, v1, v4

    const-string v2, ".sc"

    aput-object v2, v1, v6

    const-string v2, "kawa.standard.Scheme"

    aput-object v2, v1, v7

    aput-object v1, v0, v5

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "krl"

    aput-object v2, v1, v5

    const-string v2, ".krl"

    aput-object v2, v1, v4

    const-string v2, "gnu.kawa.brl.BRL"

    aput-object v2, v1, v6

    aput-object v1, v0, v4

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "brl"

    aput-object v2, v1, v5

    const-string v2, ".brl"

    aput-object v2, v1, v4

    const-string v2, "gnu.kawa.brl.BRL"

    aput-object v2, v1, v6

    aput-object v1, v0, v6

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/String;

    const-string v2, "emacs"

    aput-object v2, v1, v5

    const-string v2, "elisp"

    aput-object v2, v1, v4

    const-string v2, "emacs-lisp"

    aput-object v2, v1, v6

    const-string v2, ".el"

    aput-object v2, v1, v7

    const-string v2, "gnu.jemacs.lang.ELisp"

    aput-object v2, v1, v8

    aput-object v1, v0, v7

    const/4 v1, 0x5

    new-array v1, v1, [Ljava/lang/String;

    const-string v2, "xquery"

    aput-object v2, v1, v5

    const-string v2, ".xquery"

    aput-object v2, v1, v4

    const-string v2, ".xq"

    aput-object v2, v1, v6

    const-string v2, ".xql"

    aput-object v2, v1, v7

    const-string v2, "gnu.xquery.lang.XQuery"

    aput-object v2, v1, v8

    aput-object v1, v0, v8

    const/4 v1, 0x5

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "q2"

    aput-object v3, v2, v5

    const-string v3, ".q2"

    aput-object v3, v2, v4

    const-string v3, "gnu.q2.lang.Q2"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/4 v1, 0x6

    new-array v2, v8, [Ljava/lang/String;

    const-string v3, "xslt"

    aput-object v3, v2, v5

    const-string v3, "xsl"

    aput-object v3, v2, v4

    const-string v3, ".xsl"

    aput-object v3, v2, v6

    const-string v3, "gnu.kawa.xslt.XSLT"

    aput-object v3, v2, v7

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const/16 v2, 0x8

    new-array v2, v2, [Ljava/lang/String;

    const-string v3, "commonlisp"

    aput-object v3, v2, v5

    const-string v3, "common-lisp"

    aput-object v3, v2, v4

    const-string v3, "clisp"

    aput-object v3, v2, v6

    const-string v3, "lisp"

    aput-object v3, v2, v7

    const-string v3, ".lisp"

    aput-object v3, v2, v8

    const/4 v3, 0x5

    const-string v4, ".lsp"

    aput-object v4, v2, v3

    const/4 v3, 0x6

    const-string v4, ".cl"

    aput-object v4, v2, v3

    const/4 v3, 0x7

    const-string v4, "gnu.commonlisp.lang.CommonLisp"

    aput-object v4, v2, v3

    aput-object v2, v0, v1

    sput-object v0, Lgnu/expr/Language;->languages:[[Ljava/lang/String;

    .line 954
    sput v5, Lgnu/expr/Language;->env_counter:I

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 222
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 223
    invoke-static {}, Lgnu/expr/KawaConvert;->getInstance()Lgnu/lists/Convert;

    move-result-object v0

    invoke-static {v0}, Lgnu/lists/Convert;->setInstance(Lgnu/lists/Convert;)V

    .line 224
    return-void
.end method

.method public static detect(Lgnu/mapping/InPort;)Lgnu/expr/Language;
    .locals 2
    .param p0, "port"    # Lgnu/mapping/InPort;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 127
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 128
    .local v0, "sbuf":Ljava/lang/StringBuffer;
    const/16 v1, 0x12c

    invoke-virtual {p0, v1}, Lgnu/mapping/InPort;->mark(I)V

    .line 129
    const/16 v1, 0x50

    invoke-virtual {p0, v0, v1}, Lgnu/mapping/InPort;->readLine(Ljava/lang/StringBuffer;C)V

    .line 130
    invoke-virtual {p0}, Lgnu/mapping/InPort;->reset()V

    .line 131
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lgnu/expr/Language;->detect(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v1

    return-object v1
.end method

.method public static detect(Ljava/io/InputStream;)Lgnu/expr/Language;
    .locals 4
    .param p0, "in"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v3, 0xc8

    .line 104
    invoke-virtual {p0}, Ljava/io/InputStream;->markSupported()Z

    move-result v2

    if-nez v2, :cond_0

    .line 105
    const/4 v2, 0x0

    .line 118
    :goto_0
    return-object v2

    .line 106
    :cond_0
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 107
    .local v1, "sbuf":Ljava/lang/StringBuffer;
    invoke-virtual {p0, v3}, Ljava/io/InputStream;->mark(I)V

    .line 110
    :goto_1
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->length()I

    move-result v2

    if-lt v2, v3, :cond_2

    .line 117
    :cond_1
    invoke-virtual {p0}, Ljava/io/InputStream;->reset()V

    .line 118
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lgnu/expr/Language;->detect(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v2

    goto :goto_0

    .line 112
    :cond_2
    invoke-virtual {p0}, Ljava/io/InputStream;->read()I

    move-result v0

    .line 113
    .local v0, "c":I
    if-ltz v0, :cond_1

    const/16 v2, 0xa

    if-eq v0, v2, :cond_1

    const/16 v2, 0xd

    if-eq v0, v2, :cond_1

    .line 115
    int-to-char v2, v0

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_1
.end method

.method public static detect(Ljava/lang/String;)Lgnu/expr/Language;
    .locals 12
    .param p0, "line"    # Ljava/lang/String;

    .prologue
    const/16 v11, 0x3b

    const/4 v10, 0x7

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 140
    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    .line 142
    .local v4, "str":Ljava/lang/String;
    const-string v6, "kawa:"

    invoke-virtual {v4, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 143
    .local v2, "k":I
    if-ltz v2, :cond_1

    .line 145
    add-int/lit8 v0, v2, 0x5

    .line 146
    .local v0, "i":I
    move v1, v0

    .line 148
    .local v1, "j":I
    :goto_0
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v6

    if-ge v1, v6, :cond_0

    invoke-virtual {v4, v1}, Ljava/lang/String;->charAt(I)C

    move-result v6

    invoke-static {v6}, Ljava/lang/Character;->isJavaIdentifierPart(C)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 149
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 150
    :cond_0
    if-le v1, v0, :cond_1

    .line 152
    invoke-virtual {v4, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 153
    .local v5, "w":Ljava/lang/String;
    invoke-static {v5}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v3

    .line 154
    .local v3, "lang":Lgnu/expr/Language;
    if-eqz v3, :cond_1

    .line 174
    .end local v0    # "i":I
    .end local v1    # "j":I
    .end local v3    # "lang":Lgnu/expr/Language;
    .end local v5    # "w":Ljava/lang/String;
    :goto_1
    return-object v3

    .line 159
    :cond_1
    const-string v6, "-*- scheme -*-"

    invoke-virtual {v4, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    if-ltz v6, :cond_2

    .line 160
    const-string v6, "scheme"

    invoke-static {v6}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v3

    goto :goto_1

    .line 161
    :cond_2
    const-string v6, "-*- xquery -*-"

    invoke-virtual {v4, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    if-ltz v6, :cond_3

    .line 162
    const-string v6, "xquery"

    invoke-static {v6}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v3

    goto :goto_1

    .line 163
    :cond_3
    const-string v6, "-*- emacs-lisp -*-"

    invoke-virtual {v4, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    if-ltz v6, :cond_4

    .line 164
    const-string v6, "elisp"

    invoke-static {v6}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v3

    goto :goto_1

    .line 165
    :cond_4
    const-string v6, "-*- common-lisp -*-"

    invoke-virtual {v4, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    if-gez v6, :cond_5

    const-string v6, "-*- lisp -*-"

    invoke-virtual {v4, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v6

    if-ltz v6, :cond_6

    .line 167
    :cond_5
    const-string v6, "common-lisp"

    invoke-static {v6}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v3

    goto :goto_1

    .line 169
    :cond_6
    invoke-virtual {v4, v8}, Ljava/lang/String;->charAt(I)C

    move-result v6

    const/16 v7, 0x28

    if-ne v6, v7, :cond_7

    invoke-virtual {v4, v9}, Ljava/lang/String;->charAt(I)C

    move-result v6

    const/16 v7, 0x3a

    if-eq v6, v7, :cond_8

    :cond_7
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v6

    if-lt v6, v10, :cond_9

    invoke-virtual {v4, v8, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    const-string v7, "xquery "

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 171
    :cond_8
    const-string v6, "xquery"

    invoke-static {v6}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v3

    goto :goto_1

    .line 172
    :cond_9
    invoke-virtual {v4, v8}, Ljava/lang/String;->charAt(I)C

    move-result v6

    if-ne v6, v11, :cond_a

    invoke-virtual {v4, v9}, Ljava/lang/String;->charAt(I)C

    move-result v6

    if-ne v6, v11, :cond_a

    .line 173
    const-string v6, "scheme"

    invoke-static {v6}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v3

    goto :goto_1

    .line 174
    :cond_a
    const/4 v3, 0x0

    goto/16 :goto_1
.end method

.method public static getDefaultLanguage()Lgnu/expr/Language;
    .locals 2

    .prologue
    .line 32
    sget-object v1, Lgnu/expr/Language;->current:Ljava/lang/InheritableThreadLocal;

    invoke-virtual {v1}, Ljava/lang/InheritableThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/expr/Language;

    .line 33
    .local v0, "lang":Lgnu/expr/Language;
    if-eqz v0, :cond_0

    .end local v0    # "lang":Lgnu/expr/Language;
    :goto_0
    return-object v0

    .restart local v0    # "lang":Lgnu/expr/Language;
    :cond_0
    sget-object v0, Lgnu/expr/Language;->global:Lgnu/expr/Language;

    goto :goto_0
.end method

.method public static getInstance(Ljava/lang/String;)Lgnu/expr/Language;
    .locals 8
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 193
    sget-object v7, Lgnu/expr/Language;->languages:[[Ljava/lang/String;

    array-length v4, v7

    .line 194
    .local v4, "langCount":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v4, :cond_3

    .line 196
    sget-object v7, Lgnu/expr/Language;->languages:[[Ljava/lang/String;

    aget-object v6, v7, v1

    .line 197
    .local v6, "names":[Ljava/lang/String;
    array-length v7, v6

    add-int/lit8 v5, v7, -0x1

    .line 198
    .local v5, "nameCount":I
    move v2, v5

    .local v2, "j":I
    :cond_0
    add-int/lit8 v2, v2, -0x1

    if-ltz v2, :cond_2

    .line 200
    if-eqz p0, :cond_1

    aget-object v7, v6, v2

    invoke-virtual {v7, p0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 205
    :cond_1
    :try_start_0
    aget-object v7, v6, v5

    invoke-static {v7}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 214
    .local v3, "langClass":Ljava/lang/Class;
    const/4 v7, 0x0

    aget-object v7, v6, v7

    invoke-static {v7, v3}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;Ljava/lang/Class;)Lgnu/expr/Language;

    move-result-object v7

    .line 218
    .end local v2    # "j":I
    .end local v3    # "langClass":Ljava/lang/Class;
    .end local v5    # "nameCount":I
    .end local v6    # "names":[Ljava/lang/String;
    :goto_1
    return-object v7

    .line 207
    .restart local v2    # "j":I
    .restart local v5    # "nameCount":I
    .restart local v6    # "names":[Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 194
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 218
    .end local v2    # "j":I
    .end local v5    # "nameCount":I
    .end local v6    # "names":[Ljava/lang/String;
    :cond_3
    const/4 v7, 0x0

    goto :goto_1
.end method

.method public static getInstance(Ljava/lang/String;Ljava/lang/Class;)Lgnu/expr/Language;
    .locals 9
    .param p0, "langName"    # Ljava/lang/String;
    .param p1, "langClass"    # Ljava/lang/Class;

    .prologue
    .line 231
    const/4 v6, 0x0

    :try_start_0
    new-array v0, v6, [Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 234
    .local v0, "args":[Ljava/lang/Class;
    :try_start_1
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v7, 0x0

    invoke-virtual {p0, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    invoke-static {v7}, Ljava/lang/Character;->toTitleCase(C)C

    move-result v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v6

    const/4 v7, 0x1

    invoke-virtual {p0, v7}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 237
    .local v1, "capitalizedName":Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "get"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "Instance"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 238
    .local v4, "methodName":Ljava/lang/String;
    invoke-virtual {p1, v4, v0}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v3

    .line 245
    .end local v1    # "capitalizedName":Ljava/lang/String;
    .end local v4    # "methodName":Ljava/lang/String;
    .local v3, "method":Ljava/lang/reflect/Method;
    :goto_0
    const/4 v6, 0x0

    :try_start_2
    sget-object v7, Lgnu/mapping/Values;->noArgs:[Ljava/lang/Object;

    invoke-virtual {v3, v6, v7}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lgnu/expr/Language;

    return-object v6

    .line 240
    .end local v3    # "method":Ljava/lang/reflect/Method;
    :catch_0
    move-exception v2

    .line 242
    .local v2, "ex":Ljava/lang/Exception;
    const-string v6, "getInstance"

    invoke-virtual {p1, v6, v0}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v3

    .restart local v3    # "method":Ljava/lang/reflect/Method;
    goto :goto_0

    .line 247
    .end local v0    # "args":[Ljava/lang/Class;
    .end local v2    # "ex":Ljava/lang/Exception;
    .end local v3    # "method":Ljava/lang/reflect/Method;
    :catch_1
    move-exception v2

    .line 249
    .restart local v2    # "ex":Ljava/lang/Exception;
    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object p0

    .line 251
    instance-of v6, v2, Ljava/lang/reflect/InvocationTargetException;

    if-eqz v6, :cond_0

    .line 252
    check-cast v2, Ljava/lang/reflect/InvocationTargetException;

    .end local v2    # "ex":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/reflect/InvocationTargetException;->getTargetException()Ljava/lang/Throwable;

    move-result-object v5

    .line 256
    .local v5, "th":Ljava/lang/Throwable;
    :goto_1
    new-instance v6, Lgnu/mapping/WrappedException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "getInstance for \'"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "\' failed"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7, v5}, Lgnu/mapping/WrappedException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v6

    .line 254
    .end local v5    # "th":Ljava/lang/Throwable;
    .restart local v2    # "ex":Ljava/lang/Exception;
    :cond_0
    move-object v5, v2

    .restart local v5    # "th":Ljava/lang/Throwable;
    goto :goto_1
.end method

.method public static getInstanceFromFilenameExtension(Ljava/lang/String;)Lgnu/expr/Language;
    .locals 3
    .param p0, "filename"    # Ljava/lang/String;

    .prologue
    .line 179
    const/16 v2, 0x2e

    invoke-virtual {p0, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v0

    .line 180
    .local v0, "dot":I
    if-lez v0, :cond_0

    .line 182
    invoke-virtual {p0, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v1

    .line 183
    .local v1, "lang":Lgnu/expr/Language;
    if-eqz v1, :cond_0

    .line 186
    .end local v1    # "lang":Lgnu/expr/Language;
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getLanguages()[[Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    sget-object v0, Lgnu/expr/Language;->languages:[[Ljava/lang/String;

    return-object v0
.end method

.method public static registerLanguage([Ljava/lang/String;)V
    .locals 4
    .param p0, "langMapping"    # [Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 92
    sget-object v1, Lgnu/expr/Language;->languages:[[Ljava/lang/String;

    array-length v1, v1

    add-int/lit8 v1, v1, 0x1

    new-array v0, v1, [[Ljava/lang/String;

    .line 93
    .local v0, "newLangs":[[Ljava/lang/String;
    sget-object v1, Lgnu/expr/Language;->languages:[[Ljava/lang/String;

    sget-object v2, Lgnu/expr/Language;->languages:[[Ljava/lang/String;

    array-length v2, v2

    invoke-static {v1, v3, v0, v3, v2}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 94
    array-length v1, v0

    add-int/lit8 v1, v1, -0x1

    aput-object p0, v0, v1

    .line 95
    sput-object v0, Lgnu/expr/Language;->languages:[[Ljava/lang/String;

    .line 96
    return-void
.end method

.method public static restoreCurrent(Lgnu/expr/Language;)V
    .locals 1
    .param p0, "saved"    # Lgnu/expr/Language;

    .prologue
    .line 52
    sget-object v0, Lgnu/expr/Language;->current:Ljava/lang/InheritableThreadLocal;

    invoke-virtual {v0, p0}, Ljava/lang/InheritableThreadLocal;->set(Ljava/lang/Object;)V

    .line 53
    return-void
.end method

.method public static setCurrentLanguage(Lgnu/expr/Language;)V
    .locals 1
    .param p0, "language"    # Lgnu/expr/Language;

    .prologue
    .line 40
    sget-object v0, Lgnu/expr/Language;->current:Ljava/lang/InheritableThreadLocal;

    invoke-virtual {v0, p0}, Ljava/lang/InheritableThreadLocal;->set(Ljava/lang/Object;)V

    .line 41
    return-void
.end method

.method public static declared-synchronized setDefaults(Lgnu/expr/Language;)V
    .locals 3
    .param p0, "lang"    # Lgnu/expr/Language;

    .prologue
    .line 840
    const-class v1, Lgnu/expr/Language;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Lgnu/expr/Language;->setCurrentLanguage(Lgnu/expr/Language;)V

    .line 841
    sput-object p0, Lgnu/expr/Language;->global:Lgnu/expr/Language;

    .line 845
    invoke-static {}, Lgnu/mapping/Environment;->getGlobal()Lgnu/mapping/Environment;

    move-result-object v0

    invoke-static {}, Lgnu/expr/BuiltinEnvironment;->getInstance()Lgnu/expr/BuiltinEnvironment;

    move-result-object v2

    if-ne v0, v2, :cond_0

    .line 846
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    invoke-static {v0}, Lgnu/mapping/Environment;->setGlobal(Lgnu/mapping/Environment;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 847
    :cond_0
    monitor-exit v1

    return-void

    .line 840
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static setSaveCurrent(Lgnu/expr/Language;)Lgnu/expr/Language;
    .locals 2
    .param p0, "language"    # Lgnu/expr/Language;

    .prologue
    .line 45
    sget-object v1, Lgnu/expr/Language;->current:Ljava/lang/InheritableThreadLocal;

    invoke-virtual {v1}, Ljava/lang/InheritableThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/expr/Language;

    .line 46
    .local v0, "save":Lgnu/expr/Language;
    sget-object v1, Lgnu/expr/Language;->current:Ljava/lang/InheritableThreadLocal;

    invoke-virtual {v1, p0}, Ljava/lang/InheritableThreadLocal;->set(Ljava/lang/Object;)V

    .line 47
    return-object v0
.end method

.method public static string2Type(Ljava/lang/String;)Lgnu/bytecode/Type;
    .locals 4
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 573
    const-string v2, "[]"

    invoke-virtual {p0, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 575
    const/4 v2, 0x0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x2

    invoke-virtual {p0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lgnu/expr/Language;->string2Type(Ljava/lang/String;)Lgnu/bytecode/Type;

    move-result-object v0

    .line 576
    .local v0, "t":Lgnu/bytecode/Type;
    if-nez v0, :cond_0

    move-object v0, v1

    .line 584
    .end local v0    # "t":Lgnu/bytecode/Type;
    :goto_0
    return-object v0

    .line 578
    .restart local v0    # "t":Lgnu/bytecode/Type;
    :cond_0
    invoke-static {v0}, Lgnu/bytecode/ArrayType;->make(Lgnu/bytecode/Type;)Lgnu/bytecode/ArrayType;

    move-result-object v0

    goto :goto_0

    .line 580
    .end local v0    # "t":Lgnu/bytecode/Type;
    :cond_1
    invoke-static {p0}, Lgnu/bytecode/Type;->isValidJavaTypeName(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 581
    invoke-static {p0}, Lgnu/bytecode/Type;->getType(Ljava/lang/String;)Lgnu/bytecode/Type;

    move-result-object v0

    .restart local v0    # "t":Lgnu/bytecode/Type;
    goto :goto_0

    .end local v0    # "t":Lgnu/bytecode/Type;
    :cond_2
    move-object v0, v1

    .line 583
    goto :goto_0
.end method

.method public static unionType(Lgnu/bytecode/Type;Lgnu/bytecode/Type;)Lgnu/bytecode/Type;
    .locals 8
    .param p0, "t1"    # Lgnu/bytecode/Type;
    .param p1, "t2"    # Lgnu/bytecode/Type;

    .prologue
    const/16 v7, 0x46

    const/16 v6, 0x44

    const/16 v5, 0x42

    const/4 v4, 0x0

    const/16 v3, 0x49

    .line 692
    sget-object v2, Lgnu/bytecode/Type;->toStringType:Lgnu/bytecode/ClassType;

    if-ne p0, v2, :cond_0

    .line 693
    sget-object p0, Lgnu/bytecode/Type;->javalangStringType:Lgnu/bytecode/ClassType;

    .line 694
    :cond_0
    sget-object v2, Lgnu/bytecode/Type;->toStringType:Lgnu/bytecode/ClassType;

    if-ne p1, v2, :cond_1

    .line 695
    sget-object p1, Lgnu/bytecode/Type;->javalangStringType:Lgnu/bytecode/ClassType;

    .line 696
    :cond_1
    if-ne p0, p1, :cond_3

    .line 716
    .end local p0    # "t1":Lgnu/bytecode/Type;
    :cond_2
    :goto_0
    return-object p0

    .line 698
    .restart local p0    # "t1":Lgnu/bytecode/Type;
    :cond_3
    instance-of v2, p0, Lgnu/bytecode/PrimType;

    if-eqz v2, :cond_b

    instance-of v2, p1, Lgnu/bytecode/PrimType;

    if-eqz v2, :cond_b

    .line 700
    invoke-virtual {p0}, Lgnu/bytecode/Type;->getSignature()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 701
    .local v0, "sig1":C
    invoke-virtual {p1}, Lgnu/bytecode/Type;->getSignature()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v1

    .line 702
    .local v1, "sig2":C
    if-eq v0, v1, :cond_2

    .line 704
    if-eq v0, v5, :cond_4

    const/16 v2, 0x53

    if-eq v0, v2, :cond_4

    if-ne v0, v3, :cond_6

    :cond_4
    if-eq v1, v3, :cond_5

    const/16 v2, 0x4a

    if-ne v1, v2, :cond_6

    :cond_5
    move-object p0, p1

    .line 705
    goto :goto_0

    .line 706
    :cond_6
    if-eq v1, v5, :cond_7

    const/16 v2, 0x53

    if-eq v1, v2, :cond_7

    if-ne v1, v3, :cond_8

    :cond_7
    if-eq v0, v3, :cond_2

    const/16 v2, 0x4a

    if-eq v0, v2, :cond_2

    .line 708
    :cond_8
    if-ne v0, v7, :cond_9

    if-ne v1, v6, :cond_9

    move-object p0, p1

    .line 709
    goto :goto_0

    .line 710
    :cond_9
    if-ne v1, v7, :cond_a

    if-eq v0, v6, :cond_2

    .line 712
    :cond_a
    sget-object p0, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    goto :goto_0

    .line 716
    .end local v0    # "sig1":C
    .end local v1    # "sig2":C
    :cond_b
    sget-object p0, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    goto :goto_0
.end method


# virtual methods
.method public final asType(Ljava/lang/Object;)Lgnu/bytecode/Type;
    .locals 2
    .param p1, "spec"    # Ljava/lang/Object;

    .prologue
    .line 616
    const/4 v1, 0x1

    invoke-virtual {p0, p1, v1}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Object;Z)Lgnu/bytecode/Type;

    move-result-object v0

    .line 617
    .local v0, "type":Lgnu/bytecode/Type;
    if-nez v0, :cond_0

    check-cast p1, Lgnu/bytecode/Type;

    .end local p1    # "spec":Ljava/lang/Object;
    :goto_0
    return-object p1

    .restart local p1    # "spec":Ljava/lang/Object;
    :cond_0
    move-object p1, v0

    goto :goto_0
.end method

.method public booleanObject(Z)Ljava/lang/Object;
    .locals 1
    .param p1, "b"    # Z

    .prologue
    .line 269
    if-eqz p1, :cond_0

    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_0
.end method

.method public coerceFromObject(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "clas"    # Ljava/lang/Class;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    .line 830
    invoke-virtual {p0, p1}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v0

    invoke-virtual {v0, p2}, Lgnu/bytecode/Type;->coerceFromObject(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public coerceToObject(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "clas"    # Ljava/lang/Class;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    .line 835
    invoke-virtual {p0, p1}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v0

    invoke-virtual {v0, p2}, Lgnu/bytecode/Type;->coerceToObject(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public declFromField(Lgnu/expr/ModuleExp;Ljava/lang/Object;Lgnu/bytecode/Field;)Lgnu/expr/Declaration;
    .locals 15
    .param p1, "mod"    # Lgnu/expr/ModuleExp;
    .param p2, "fvalue"    # Ljava/lang/Object;
    .param p3, "fld"    # Lgnu/bytecode/Field;

    .prologue
    .line 721
    invoke-virtual/range {p3 .. p3}, Lgnu/bytecode/Field;->getName()Ljava/lang/String;

    move-result-object v5

    .line 722
    .local v5, "fname":Ljava/lang/String;
    invoke-virtual/range {p3 .. p3}, Lgnu/bytecode/Field;->getType()Lgnu/bytecode/Type;

    move-result-object v6

    .line 723
    .local v6, "ftype":Lgnu/bytecode/Type;
    sget-object v13, Lgnu/expr/Compilation;->typeLocation:Lgnu/bytecode/ClassType;

    invoke-virtual {v6, v13}, Lgnu/bytecode/Type;->isSubtype(Lgnu/bytecode/Type;)Z

    move-result v7

    .line 728
    .local v7, "isAlias":Z
    const/4 v2, 0x0

    .line 729
    .local v2, "externalAccess":Z
    invoke-virtual/range {p3 .. p3}, Lgnu/bytecode/Field;->getModifiers()I

    move-result v13

    and-int/lit8 v13, v13, 0x10

    if-eqz v13, :cond_6

    const/4 v8, 0x1

    .line 730
    .local v8, "isFinal":Z
    :goto_0
    const-string v13, "$instance"

    invoke-virtual {v5, v13}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v9

    .local v9, "isImportedInstance":Z
    if-eqz v9, :cond_7

    .line 731
    move-object v4, v5

    .line 744
    .end local p2    # "fvalue":Ljava/lang/Object;
    :goto_1
    instance-of v13, v4, Ljava/lang/String;

    if-eqz v13, :cond_0

    .line 746
    invoke-virtual/range {p1 .. p1}, Lgnu/expr/ModuleExp;->getNamespaceUri()Ljava/lang/String;

    move-result-object v12

    .local v12, "uri":Ljava/lang/String;
    move-object v11, v4

    .line 747
    check-cast v11, Ljava/lang/String;

    .line 749
    .local v11, "sname":Ljava/lang/String;
    if-nez v12, :cond_a

    .line 750
    invoke-static {v11}, Lgnu/mapping/SimpleSymbol;->valueOf(Ljava/lang/String;)Lgnu/mapping/SimpleSymbol;

    move-result-object v4

    .line 754
    .end local v11    # "sname":Ljava/lang/String;
    .end local v12    # "uri":Ljava/lang/String;
    :cond_0
    :goto_2
    if-eqz v7, :cond_b

    sget-object v1, Lgnu/bytecode/Type;->objectType:Lgnu/bytecode/ClassType;

    .line 756
    .local v1, "dtype":Lgnu/bytecode/Type;
    :goto_3
    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v1}, Lgnu/expr/ModuleExp;->addDeclaration(Ljava/lang/Object;Lgnu/bytecode/Type;)Lgnu/expr/Declaration;

    move-result-object v3

    .line 757
    .local v3, "fdecl":Lgnu/expr/Declaration;
    invoke-virtual/range {p3 .. p3}, Lgnu/bytecode/Field;->getModifiers()I

    move-result v13

    and-int/lit8 v13, v13, 0x8

    if-eqz v13, :cond_c

    const/4 v10, 0x1

    .line 758
    .local v10, "isStatic":Z
    :goto_4
    if-eqz v7, :cond_d

    .line 760
    const/4 v13, 0x1

    invoke-virtual {v3, v13}, Lgnu/expr/Declaration;->setIndirectBinding(Z)V

    .line 761
    instance-of v13, v6, Lgnu/bytecode/ClassType;

    if-eqz v13, :cond_1

    check-cast v6, Lgnu/bytecode/ClassType;

    .end local v6    # "ftype":Lgnu/bytecode/Type;
    const-string v13, "gnu.mapping.ThreadLocation"

    invoke-virtual {v6, v13}, Lgnu/bytecode/ClassType;->isSubclass(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_1

    .line 763
    const-wide/32 v13, 0x10000000

    invoke-virtual {v3, v13, v14}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 772
    :cond_1
    :goto_5
    if-eqz v10, :cond_2

    .line 773
    const-wide/16 v13, 0x800

    invoke-virtual {v3, v13, v14}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 774
    :cond_2
    move-object/from16 v0, p3

    iput-object v0, v3, Lgnu/expr/Declaration;->field:Lgnu/bytecode/Field;

    .line 775
    if-eqz v8, :cond_3

    if-nez v7, :cond_3

    .line 776
    const-wide/16 v13, 0x4000

    invoke-virtual {v3, v13, v14}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 777
    :cond_3
    if-eqz v9, :cond_4

    .line 778
    const-wide/32 v13, 0x40000000

    invoke-virtual {v3, v13, v14}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 779
    :cond_4
    const/4 v13, 0x0

    invoke-virtual {v3, v13}, Lgnu/expr/Declaration;->setSimple(Z)V

    .line 780
    if-eqz v2, :cond_5

    .line 781
    const-wide/32 v13, 0x80020

    invoke-virtual {v3, v13, v14}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 782
    :cond_5
    return-object v3

    .line 729
    .end local v1    # "dtype":Lgnu/bytecode/Type;
    .end local v3    # "fdecl":Lgnu/expr/Declaration;
    .end local v8    # "isFinal":Z
    .end local v9    # "isImportedInstance":Z
    .end local v10    # "isStatic":Z
    .restart local v6    # "ftype":Lgnu/bytecode/Type;
    .restart local p2    # "fvalue":Ljava/lang/Object;
    :cond_6
    const/4 v8, 0x0

    goto :goto_0

    .line 732
    .restart local v8    # "isFinal":Z
    .restart local v9    # "isImportedInstance":Z
    :cond_7
    if-eqz v8, :cond_8

    move-object/from16 v0, p2

    instance-of v13, v0, Lgnu/mapping/Named;

    if-eqz v13, :cond_8

    .line 733
    check-cast p2, Lgnu/mapping/Named;

    .end local p2    # "fvalue":Ljava/lang/Object;
    invoke-interface/range {p2 .. p2}, Lgnu/mapping/Named;->getSymbol()Ljava/lang/Object;

    move-result-object v4

    .local v4, "fdname":Ljava/lang/Object;
    goto :goto_1

    .line 737
    .end local v4    # "fdname":Ljava/lang/Object;
    .restart local p2    # "fvalue":Ljava/lang/Object;
    :cond_8
    const-string v13, "$Prvt$"

    invoke-virtual {v5, v13}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_9

    .line 739
    const/4 v2, 0x1

    .line 740
    const-string v13, "$Prvt$"

    invoke-virtual {v13}, Ljava/lang/String;->length()I

    move-result v13

    invoke-virtual {v5, v13}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    .line 742
    :cond_9
    const/4 v13, 0x1

    invoke-static {v5, v13}, Lgnu/expr/Compilation;->demangleName(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/String;->intern()Ljava/lang/String;

    move-result-object v4

    .local v4, "fdname":Ljava/lang/String;
    goto/16 :goto_1

    .line 752
    .end local v4    # "fdname":Ljava/lang/String;
    .end local p2    # "fvalue":Ljava/lang/Object;
    .restart local v11    # "sname":Ljava/lang/String;
    .restart local v12    # "uri":Ljava/lang/String;
    :cond_a
    invoke-static {v12, v11}, Lgnu/mapping/Symbol;->make(Ljava/lang/Object;Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v4

    .local v4, "fdname":Lgnu/mapping/Symbol;
    goto/16 :goto_2

    .line 754
    .end local v4    # "fdname":Lgnu/mapping/Symbol;
    .end local v11    # "sname":Ljava/lang/String;
    .end local v12    # "uri":Ljava/lang/String;
    :cond_b
    invoke-virtual {v6}, Lgnu/bytecode/Type;->getReflectClass()Ljava/lang/Class;

    move-result-object v13

    invoke-virtual {p0, v13}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v1

    goto/16 :goto_3

    .line 757
    .restart local v1    # "dtype":Lgnu/bytecode/Type;
    .restart local v3    # "fdecl":Lgnu/expr/Declaration;
    :cond_c
    const/4 v10, 0x0

    goto/16 :goto_4

    .line 765
    .restart local v10    # "isStatic":Z
    :cond_d
    if-eqz v8, :cond_1

    instance-of v13, v6, Lgnu/bytecode/ClassType;

    if-eqz v13, :cond_1

    .line 767
    sget-object v13, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    invoke-virtual {v6, v13}, Lgnu/bytecode/Type;->isSubtype(Lgnu/bytecode/Type;)Z

    move-result v13

    if-eqz v13, :cond_e

    .line 768
    const/4 v13, 0x1

    invoke-virtual {v3, v13}, Lgnu/expr/Declaration;->setProcedureDecl(Z)V

    goto :goto_5

    .line 769
    :cond_e
    check-cast v6, Lgnu/bytecode/ClassType;

    .end local v6    # "ftype":Lgnu/bytecode/Type;
    const-string v13, "gnu.mapping.Namespace"

    invoke-virtual {v6, v13}, Lgnu/bytecode/ClassType;->isSubclass(Ljava/lang/String;)Z

    move-result v13

    if-eqz v13, :cond_1

    .line 770
    const-wide/32 v13, 0x200000

    invoke-virtual {v3, v13, v14}, Lgnu/expr/Declaration;->setFlag(J)V

    goto/16 :goto_5
.end method

.method protected defAliasStFld(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "cname"    # Ljava/lang/String;
    .param p3, "fname"    # Ljava/lang/String;

    .prologue
    .line 326
    iget-object v0, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    invoke-virtual {p0, p1}, Lgnu/expr/Language;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v1

    const/4 v2, 0x0

    invoke-static {v0, v1, v2, p2, p3}, Lgnu/kawa/reflect/StaticFieldLocation;->define(Lgnu/mapping/Environment;Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Lgnu/kawa/reflect/StaticFieldLocation;

    .line 327
    return-void
.end method

.method protected defProcStFld(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "cname"    # Ljava/lang/String;

    .prologue
    .line 352
    invoke-static {p1}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, p2, v0}, Lgnu/expr/Language;->defProcStFld(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 353
    return-void
.end method

.method protected defProcStFld(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "cname"    # Ljava/lang/String;
    .param p3, "fname"    # Ljava/lang/String;

    .prologue
    .line 337
    invoke-virtual {p0}, Lgnu/expr/Language;->hasSeparateFunctionNamespace()Z

    move-result v3

    if-eqz v3, :cond_0

    sget-object v1, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    .line 339
    .local v1, "property":Ljava/lang/Object;
    :goto_0
    invoke-virtual {p0, p1}, Lgnu/expr/Language;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v2

    .line 340
    .local v2, "sym":Lgnu/mapping/Symbol;
    iget-object v3, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    invoke-static {v3, v2, v1, p2, p3}, Lgnu/kawa/reflect/StaticFieldLocation;->define(Lgnu/mapping/Environment;Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Lgnu/kawa/reflect/StaticFieldLocation;

    move-result-object v0

    .line 342
    .local v0, "loc":Lgnu/kawa/reflect/StaticFieldLocation;
    invoke-virtual {v0}, Lgnu/kawa/reflect/StaticFieldLocation;->setProcedure()V

    .line 343
    return-void

    .line 337
    .end local v0    # "loc":Lgnu/kawa/reflect/StaticFieldLocation;
    .end local v1    # "property":Ljava/lang/Object;
    .end local v2    # "sym":Lgnu/mapping/Symbol;
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public define(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 3
    .param p1, "sym"    # Ljava/lang/String;
    .param p2, "p"    # Ljava/lang/Object;

    .prologue
    .line 318
    invoke-virtual {p0, p1}, Lgnu/expr/Language;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v0

    .line 319
    .local v0, "s":Lgnu/mapping/Symbol;
    iget-object v1, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v2, p2}, Lgnu/mapping/Environment;->define(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 320
    return-void
.end method

.method public final defineFunction(Lgnu/mapping/Named;)V
    .locals 4
    .param p1, "proc"    # Lgnu/mapping/Named;

    .prologue
    .line 358
    invoke-interface {p1}, Lgnu/mapping/Named;->getSymbol()Ljava/lang/Object;

    move-result-object v0

    .line 359
    .local v0, "name":Ljava/lang/Object;
    instance-of v3, v0, Lgnu/mapping/Symbol;

    if-eqz v3, :cond_0

    check-cast v0, Lgnu/mapping/Symbol;

    .end local v0    # "name":Ljava/lang/Object;
    move-object v2, v0

    .line 361
    .local v2, "sym":Lgnu/mapping/Symbol;
    :goto_0
    invoke-virtual {p0}, Lgnu/expr/Language;->hasSeparateFunctionNamespace()Z

    move-result v3

    if-eqz v3, :cond_1

    sget-object v1, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    .line 363
    .local v1, "property":Ljava/lang/Object;
    :goto_1
    iget-object v3, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    invoke-virtual {v3, v2, v1, p1}, Lgnu/mapping/Environment;->define(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 364
    return-void

    .line 359
    .end local v1    # "property":Ljava/lang/Object;
    .end local v2    # "sym":Lgnu/mapping/Symbol;
    .restart local v0    # "name":Ljava/lang/Object;
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lgnu/expr/Language;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v2

    goto :goto_0

    .line 361
    .end local v0    # "name":Ljava/lang/Object;
    .restart local v2    # "sym":Lgnu/mapping/Symbol;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public defineFunction(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "proc"    # Ljava/lang/Object;

    .prologue
    .line 371
    invoke-virtual {p0}, Lgnu/expr/Language;->hasSeparateFunctionNamespace()Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    .line 373
    .local v0, "property":Ljava/lang/Object;
    :goto_0
    iget-object v1, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    invoke-virtual {p0, p1}, Lgnu/expr/Language;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v2

    invoke-virtual {v1, v2, v0, p2}, Lgnu/mapping/Environment;->define(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 374
    return-void

    .line 371
    .end local v0    # "property":Ljava/lang/Object;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public emitCoerceToBoolean(Lgnu/bytecode/CodeAttr;)V
    .locals 2
    .param p1, "code"    # Lgnu/bytecode/CodeAttr;

    .prologue
    const/4 v1, 0x0

    .line 820
    invoke-virtual {p0, v1, p1}, Lgnu/expr/Language;->emitPushBoolean(ZLgnu/bytecode/CodeAttr;)V

    .line 821
    invoke-virtual {p1}, Lgnu/bytecode/CodeAttr;->emitIfNEq()V

    .line 822
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 823
    invoke-virtual {p1}, Lgnu/bytecode/CodeAttr;->emitElse()V

    .line 824
    invoke-virtual {p1, v1}, Lgnu/bytecode/CodeAttr;->emitPushInt(I)V

    .line 825
    invoke-virtual {p1}, Lgnu/bytecode/CodeAttr;->emitFi()V

    .line 826
    return-void
.end method

.method public emitPushBoolean(ZLgnu/bytecode/CodeAttr;)V
    .locals 1
    .param p1, "value"    # Z
    .param p2, "code"    # Lgnu/bytecode/CodeAttr;

    .prologue
    .line 811
    if-eqz p1, :cond_0

    sget-object v0, Lgnu/expr/Compilation;->trueConstant:Lgnu/bytecode/Field;

    :goto_0
    invoke-virtual {p2, v0}, Lgnu/bytecode/CodeAttr;->emitGetStatic(Lgnu/bytecode/Field;)V

    .line 813
    return-void

    .line 811
    :cond_0
    sget-object v0, Lgnu/expr/Compilation;->falseConstant:Lgnu/bytecode/Field;

    goto :goto_0
.end method

.method public final eval(Lgnu/mapping/InPort;)Ljava/lang/Object;
    .locals 4
    .param p1, "port"    # Lgnu/mapping/InPort;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 879
    invoke-static {}, Lgnu/mapping/CallContext;->getInstance()Lgnu/mapping/CallContext;

    move-result-object v0

    .line 880
    .local v0, "ctx":Lgnu/mapping/CallContext;
    invoke-virtual {v0}, Lgnu/mapping/CallContext;->startFromContext()I

    move-result v2

    .line 883
    .local v2, "oldIndex":I
    :try_start_0
    invoke-virtual {p0, p1, v0}, Lgnu/expr/Language;->eval(Lgnu/mapping/InPort;Lgnu/mapping/CallContext;)V

    .line 884
    invoke-virtual {v0, v2}, Lgnu/mapping/CallContext;->getFromContext(I)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    return-object v3

    .line 886
    :catch_0
    move-exception v1

    .line 888
    .local v1, "ex":Ljava/lang/Throwable;
    invoke-virtual {v0, v2}, Lgnu/mapping/CallContext;->cleanupFromContext(I)V

    .line 889
    throw v1
.end method

.method public final eval(Ljava/io/Reader;)Ljava/lang/Object;
    .locals 1
    .param p1, "in"    # Ljava/io/Reader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 873
    instance-of v0, p1, Lgnu/mapping/InPort;

    if-eqz v0, :cond_0

    check-cast p1, Lgnu/mapping/InPort;

    .end local p1    # "in":Ljava/io/Reader;
    :goto_0
    invoke-virtual {p0, p1}, Lgnu/expr/Language;->eval(Lgnu/mapping/InPort;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .restart local p1    # "in":Ljava/io/Reader;
    :cond_0
    new-instance v0, Lgnu/mapping/InPort;

    invoke-direct {v0, p1}, Lgnu/mapping/InPort;-><init>(Ljava/io/Reader;)V

    move-object p1, v0

    goto :goto_0
.end method

.method public final eval(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "string"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 865
    new-instance v0, Lgnu/mapping/CharArrayInPort;

    invoke-direct {v0, p1}, Lgnu/mapping/CharArrayInPort;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lgnu/expr/Language;->eval(Lgnu/mapping/InPort;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public eval(Lgnu/mapping/InPort;Lgnu/mapping/CallContext;)V
    .locals 6
    .param p1, "port"    # Lgnu/mapping/InPort;
    .param p2, "ctx"    # Lgnu/mapping/CallContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 938
    new-instance v1, Lgnu/text/SourceMessages;

    invoke-direct {v1}, Lgnu/text/SourceMessages;-><init>()V

    .line 939
    .local v1, "messages":Lgnu/text/SourceMessages;
    invoke-static {p0}, Lgnu/expr/Language;->setSaveCurrent(Lgnu/expr/Language;)Lgnu/expr/Language;

    move-result-object v2

    .line 942
    .local v2, "saveLang":Lgnu/expr/Language;
    const/4 v3, 0x3

    :try_start_0
    invoke-virtual {p0, p1, v1, v3}, Lgnu/expr/Language;->parse(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;I)Lgnu/expr/Compilation;

    move-result-object v0

    .line 943
    .local v0, "comp":Lgnu/expr/Compilation;
    invoke-virtual {p0}, Lgnu/expr/Language;->getEnvironment()Lgnu/mapping/Environment;

    move-result-object v3

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {v3, p2, v0, v4, v5}, Lgnu/expr/ModuleExp;->evalModule(Lgnu/mapping/Environment;Lgnu/mapping/CallContext;Lgnu/expr/Compilation;Ljava/net/URL;Lgnu/mapping/OutPort;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 947
    invoke-static {v2}, Lgnu/expr/Language;->restoreCurrent(Lgnu/expr/Language;)V

    .line 949
    invoke-virtual {v1}, Lgnu/text/SourceMessages;->seenErrors()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 950
    new-instance v3, Ljava/lang/RuntimeException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "invalid syntax in eval form:\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const/16 v5, 0x14

    invoke-virtual {v1, v5}, Lgnu/text/SourceMessages;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 947
    .end local v0    # "comp":Lgnu/expr/Compilation;
    :catchall_0
    move-exception v3

    invoke-static {v2}, Lgnu/expr/Language;->restoreCurrent(Lgnu/expr/Language;)V

    throw v3

    .line 952
    .restart local v0    # "comp":Lgnu/expr/Compilation;
    :cond_0
    return-void
.end method

.method public eval(Ljava/io/Reader;Lgnu/lists/Consumer;)V
    .locals 4
    .param p1, "in"    # Ljava/io/Reader;
    .param p2, "out"    # Lgnu/lists/Consumer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 922
    instance-of v3, p1, Lgnu/mapping/InPort;

    if-eqz v3, :cond_0

    check-cast p1, Lgnu/mapping/InPort;

    .end local p1    # "in":Ljava/io/Reader;
    move-object v1, p1

    .line 923
    .local v1, "port":Lgnu/mapping/InPort;
    :goto_0
    invoke-static {}, Lgnu/mapping/CallContext;->getInstance()Lgnu/mapping/CallContext;

    move-result-object v0

    .line 924
    .local v0, "ctx":Lgnu/mapping/CallContext;
    iget-object v2, v0, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 927
    .local v2, "save":Lgnu/lists/Consumer;
    :try_start_0
    iput-object p2, v0, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 928
    invoke-virtual {p0, v1, v0}, Lgnu/expr/Language;->eval(Lgnu/mapping/InPort;Lgnu/mapping/CallContext;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 932
    iput-object v2, v0, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 934
    return-void

    .line 922
    .end local v0    # "ctx":Lgnu/mapping/CallContext;
    .end local v1    # "port":Lgnu/mapping/InPort;
    .end local v2    # "save":Lgnu/lists/Consumer;
    .restart local p1    # "in":Ljava/io/Reader;
    :cond_0
    new-instance v1, Lgnu/mapping/InPort;

    invoke-direct {v1, p1}, Lgnu/mapping/InPort;-><init>(Ljava/io/Reader;)V

    goto :goto_0

    .line 932
    .end local p1    # "in":Ljava/io/Reader;
    .restart local v0    # "ctx":Lgnu/mapping/CallContext;
    .restart local v1    # "port":Lgnu/mapping/InPort;
    .restart local v2    # "save":Lgnu/lists/Consumer;
    :catchall_0
    move-exception v3

    iput-object v2, v0, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    throw v3
.end method

.method public final eval(Ljava/io/Reader;Ljava/io/Writer;)V
    .locals 1
    .param p1, "in"    # Ljava/io/Reader;
    .param p2, "out"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 916
    invoke-virtual {p0, p2}, Lgnu/expr/Language;->getOutputConsumer(Ljava/io/Writer;)Lgnu/lists/Consumer;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lgnu/expr/Language;->eval(Ljava/io/Reader;Lgnu/lists/Consumer;)V

    .line 917
    return-void
.end method

.method public final eval(Ljava/lang/String;Lgnu/lists/Consumer;)V
    .locals 1
    .param p1, "string"    # Ljava/lang/String;
    .param p2, "out"    # Lgnu/lists/Consumer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 910
    new-instance v0, Lgnu/mapping/CharArrayInPort;

    invoke-direct {v0, p1}, Lgnu/mapping/CharArrayInPort;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, p2}, Lgnu/expr/Language;->eval(Ljava/io/Reader;Lgnu/lists/Consumer;)V

    .line 911
    return-void
.end method

.method public final eval(Ljava/lang/String;Lgnu/lists/PrintConsumer;)V
    .locals 1
    .param p1, "string"    # Ljava/lang/String;
    .param p2, "out"    # Lgnu/lists/PrintConsumer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 904
    invoke-virtual {p0, p2}, Lgnu/expr/Language;->getOutputConsumer(Ljava/io/Writer;)Lgnu/lists/Consumer;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Lgnu/expr/Language;->eval(Ljava/lang/String;Lgnu/lists/Consumer;)V

    .line 905
    return-void
.end method

.method public final eval(Ljava/lang/String;Ljava/io/Writer;)V
    .locals 1
    .param p1, "string"    # Ljava/lang/String;
    .param p2, "out"    # Ljava/io/Writer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 896
    new-instance v0, Lgnu/mapping/CharArrayInPort;

    invoke-direct {v0, p1}, Lgnu/mapping/CharArrayInPort;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, p2}, Lgnu/expr/Language;->eval(Ljava/io/Reader;Ljava/io/Writer;)V

    .line 897
    return-void
.end method

.method public formatType(Lgnu/bytecode/Type;)Ljava/lang/String;
    .locals 1
    .param p1, "type"    # Lgnu/bytecode/Type;

    .prologue
    .line 567
    invoke-virtual {p1}, Lgnu/bytecode/Type;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCompilation(Lgnu/text/Lexer;Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)Lgnu/expr/Compilation;
    .locals 1
    .param p1, "lexer"    # Lgnu/text/Lexer;
    .param p2, "messages"    # Lgnu/text/SourceMessages;
    .param p3, "lexical"    # Lgnu/expr/NameLookup;

    .prologue
    .line 454
    new-instance v0, Lgnu/expr/Compilation;

    invoke-direct {v0, p0, p2, p3}, Lgnu/expr/Compilation;-><init>(Lgnu/expr/Language;Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)V

    return-object v0
.end method

.method public getEnvPropertyFor(Lgnu/expr/Declaration;)Ljava/lang/Object;
    .locals 1
    .param p1, "decl"    # Lgnu/expr/Declaration;

    .prologue
    .line 388
    invoke-virtual {p0}, Lgnu/expr/Language;->hasSeparateFunctionNamespace()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lgnu/expr/Declaration;->isProcedureDecl()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 389
    sget-object v0, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    .line 390
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getEnvPropertyFor(Ljava/lang/reflect/Field;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 3
    .param p1, "fld"    # Ljava/lang/reflect/Field;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v0, 0x0

    .line 378
    invoke-virtual {p0}, Lgnu/expr/Language;->hasSeparateFunctionNamespace()Z

    move-result v1

    if-nez v1, :cond_1

    .line 383
    :cond_0
    :goto_0
    return-object v0

    .line 380
    :cond_1
    sget-object v1, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    invoke-virtual {v1}, Lgnu/bytecode/ClassType;->getReflectClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/reflect/Field;->getType()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 382
    sget-object v0, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    goto :goto_0
.end method

.method public final getEnvironment()Lgnu/mapping/Environment;
    .locals 1

    .prologue
    .line 298
    iget-object v0, p0, Lgnu/expr/Language;->userEnv:Lgnu/mapping/Environment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lgnu/expr/Language;->userEnv:Lgnu/mapping/Environment;

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v0

    goto :goto_0
.end method

.method public getFormat(Z)Lgnu/lists/AbstractFormat;
    .locals 1
    .param p1, "readable"    # Z

    .prologue
    .line 430
    const/4 v0, 0x0

    return-object v0
.end method

.method public getLangEnvironment()Lgnu/mapping/Environment;
    .locals 1

    .prologue
    .line 308
    iget-object v0, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    return-object v0
.end method

.method public final getLangTypeFor(Lgnu/bytecode/Type;)Lgnu/bytecode/Type;
    .locals 2
    .param p1, "type"    # Lgnu/bytecode/Type;

    .prologue
    .line 556
    invoke-virtual {p1}, Lgnu/bytecode/Type;->isExisting()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 558
    invoke-virtual {p1}, Lgnu/bytecode/Type;->getReflectClass()Ljava/lang/Class;

    move-result-object v0

    .line 559
    .local v0, "clas":Ljava/lang/Class;
    if-eqz v0, :cond_0

    .line 560
    invoke-virtual {p0, v0}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object p1

    .line 562
    .end local v0    # "clas":Ljava/lang/Class;
    .end local p1    # "type":Lgnu/bytecode/Type;
    :cond_0
    return-object p1
.end method

.method public abstract getLexer(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;)Lgnu/text/Lexer;
.end method

.method public getName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 443
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    .line 444
    .local v1, "name":Ljava/lang/String;
    const/16 v2, 0x2e

    invoke-virtual {v1, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v0

    .line 445
    .local v0, "dot":I
    if-ltz v0, :cond_0

    .line 446
    add-int/lit8 v2, v0, 0x1

    invoke-virtual {v1, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 447
    :cond_0
    return-object v1
.end method

.method public getNamespaceOf(Lgnu/expr/Declaration;)I
    .locals 1
    .param p1, "decl"    # Lgnu/expr/Declaration;

    .prologue
    .line 799
    const/4 v0, 0x1

    return v0
.end method

.method public final getNewEnvironment()Lgnu/mapping/Environment;
    .locals 2

    .prologue
    .line 305
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "environment-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget v1, Lgnu/expr/Language;->envCounter:I

    add-int/lit8 v1, v1, 0x1

    sput v1, Lgnu/expr/Language;->envCounter:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    invoke-static {v0, v1}, Lgnu/mapping/Environment;->make(Ljava/lang/String;Lgnu/mapping/Environment;)Lgnu/mapping/InheritingEnvironment;

    move-result-object v0

    return-object v0
.end method

.method public getOutputConsumer(Ljava/io/Writer;)Lgnu/lists/Consumer;
    .locals 2
    .param p1, "out"    # Ljava/io/Writer;

    .prologue
    .line 435
    instance-of v1, p1, Lgnu/mapping/OutPort;

    if-eqz v1, :cond_0

    check-cast p1, Lgnu/mapping/OutPort;

    .end local p1    # "out":Ljava/io/Writer;
    move-object v0, p1

    .line 437
    .local v0, "oport":Lgnu/mapping/OutPort;
    :goto_0
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lgnu/expr/Language;->getFormat(Z)Lgnu/lists/AbstractFormat;

    move-result-object v1

    iput-object v1, v0, Lgnu/mapping/OutPort;->objectFormat:Lgnu/lists/AbstractFormat;

    .line 438
    return-object v0

    .line 435
    .end local v0    # "oport":Lgnu/mapping/OutPort;
    .restart local p1    # "out":Ljava/io/Writer;
    :cond_0
    new-instance v0, Lgnu/mapping/OutPort;

    invoke-direct {v0, p1}, Lgnu/mapping/OutPort;-><init>(Ljava/io/Writer;)V

    goto :goto_0
.end method

.method public getPrompter()Lgnu/mapping/Procedure;
    .locals 5

    .prologue
    .line 851
    const/4 v1, 0x0

    .line 852
    .local v1, "property":Ljava/lang/Object;
    invoke-virtual {p0}, Lgnu/expr/Language;->hasSeparateFunctionNamespace()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 853
    sget-object v1, Lgnu/mapping/EnvironmentKey;->FUNCTION:Ljava/lang/Object;

    .line 854
    .end local v1    # "property":Ljava/lang/Object;
    :cond_0
    invoke-virtual {p0}, Lgnu/expr/Language;->getEnvironment()Lgnu/mapping/Environment;

    move-result-object v2

    const-string v3, "default-prompter"

    invoke-virtual {p0, v3}, Lgnu/expr/Language;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v1, v4}, Lgnu/mapping/Environment;->get(Lgnu/mapping/Symbol;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/Procedure;

    .line 856
    .local v0, "prompter":Lgnu/mapping/Procedure;
    if-eqz v0, :cond_1

    .line 859
    .end local v0    # "prompter":Lgnu/mapping/Procedure;
    :goto_0
    return-object v0

    .restart local v0    # "prompter":Lgnu/mapping/Procedure;
    :cond_1
    new-instance v0, Lgnu/expr/SimplePrompter;

    .end local v0    # "prompter":Lgnu/mapping/Procedure;
    invoke-direct {v0}, Lgnu/expr/SimplePrompter;-><init>()V

    goto :goto_0
.end method

.method public getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 420
    iget-object v0, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    invoke-virtual {v0, p1}, Lgnu/mapping/Environment;->getSymbol(Ljava/lang/String;)Lgnu/mapping/Symbol;

    move-result-object v0

    return-object v0
.end method

.method public final getTypeFor(Lgnu/expr/Expression;)Lgnu/bytecode/Type;
    .locals 1
    .param p1, "exp"    # Lgnu/expr/Expression;

    .prologue
    .line 622
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lgnu/expr/Language;->getTypeFor(Lgnu/expr/Expression;Z)Lgnu/bytecode/Type;

    move-result-object v0

    return-object v0
.end method

.method public getTypeFor(Lgnu/expr/Expression;Z)Lgnu/bytecode/Type;
    .locals 10
    .param p1, "exp"    # Lgnu/expr/Expression;
    .param p2, "lenient"    # Z

    .prologue
    const/4 v6, 0x0

    const/4 v9, 0x1

    .line 627
    instance-of v7, p1, Lgnu/expr/QuoteExp;

    if-eqz v7, :cond_3

    move-object v7, p1

    .line 629
    check-cast v7, Lgnu/expr/QuoteExp;

    invoke-virtual {v7}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v6

    .line 630
    .local v6, "value":Ljava/lang/Object;
    instance-of v7, v6, Lgnu/bytecode/Type;

    if-eqz v7, :cond_1

    .line 631
    check-cast v6, Lgnu/bytecode/Type;

    .line 687
    .end local v6    # "value":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-object v6

    .line 632
    .restart local v6    # "value":Ljava/lang/Object;
    :cond_1
    instance-of v7, v6, Ljava/lang/Class;

    if-eqz v7, :cond_2

    .line 633
    check-cast v6, Ljava/lang/Class;

    .end local v6    # "value":Ljava/lang/Object;
    invoke-static {v6}, Lgnu/bytecode/Type;->make(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v6

    goto :goto_0

    .line 634
    .restart local v6    # "value":Ljava/lang/Object;
    :cond_2
    invoke-virtual {p0, v6, p2}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Object;Z)Lgnu/bytecode/Type;

    move-result-object v6

    goto :goto_0

    .line 636
    .end local v6    # "value":Ljava/lang/Object;
    :cond_3
    instance-of v7, p1, Lgnu/expr/ReferenceExp;

    if-eqz v7, :cond_c

    move-object v4, p1

    .line 638
    check-cast v4, Lgnu/expr/ReferenceExp;

    .line 639
    .local v4, "rexp":Lgnu/expr/ReferenceExp;
    invoke-virtual {v4}, Lgnu/expr/ReferenceExp;->getBinding()Lgnu/expr/Declaration;

    move-result-object v7

    invoke-static {v7}, Lgnu/expr/Declaration;->followAliases(Lgnu/expr/Declaration;)Lgnu/expr/Declaration;

    move-result-object v0

    .line 640
    .local v0, "decl":Lgnu/expr/Declaration;
    invoke-virtual {v4}, Lgnu/expr/ReferenceExp;->getName()Ljava/lang/String;

    move-result-object v3

    .line 641
    .local v3, "name":Ljava/lang/String;
    if-eqz v0, :cond_8

    .line 643
    invoke-virtual {v0}, Lgnu/expr/Declaration;->getValue()Lgnu/expr/Expression;

    move-result-object p1

    .line 644
    instance-of v7, p1, Lgnu/expr/QuoteExp;

    if-eqz v7, :cond_4

    const-wide/16 v7, 0x4000

    invoke-virtual {v0, v7, v8}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-virtual {v0}, Lgnu/expr/Declaration;->isIndirectBinding()Z

    move-result v7

    if-nez v7, :cond_4

    move-object v7, p1

    .line 648
    check-cast v7, Lgnu/expr/QuoteExp;

    invoke-virtual {v7}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v5

    .line 649
    .local v5, "val":Ljava/lang/Object;
    invoke-virtual {p0, v5, p2}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Object;Z)Lgnu/bytecode/Type;

    move-result-object v6

    goto :goto_0

    .line 651
    .end local v5    # "val":Ljava/lang/Object;
    :cond_4
    instance-of v7, p1, Lgnu/expr/ClassExp;

    if-nez v7, :cond_5

    instance-of v7, p1, Lgnu/expr/ModuleExp;

    if-eqz v7, :cond_6

    .line 653
    :cond_5
    invoke-virtual {v0, v9}, Lgnu/expr/Declaration;->setCanRead(Z)V

    move-object v7, p1

    .line 654
    check-cast v7, Lgnu/expr/LambdaExp;

    invoke-virtual {v7}, Lgnu/expr/LambdaExp;->getClassType()Lgnu/bytecode/ClassType;

    move-result-object v6

    goto :goto_0

    .line 656
    :cond_6
    invoke-virtual {v0}, Lgnu/expr/Declaration;->isAlias()Z

    move-result v7

    if-eqz v7, :cond_9

    instance-of v7, p1, Lgnu/expr/QuoteExp;

    if-eqz v7, :cond_9

    move-object v7, p1

    .line 659
    check-cast v7, Lgnu/expr/QuoteExp;

    invoke-virtual {v7}, Lgnu/expr/QuoteExp;->getValue()Ljava/lang/Object;

    move-result-object v5

    .line 660
    .restart local v5    # "val":Ljava/lang/Object;
    instance-of v7, v5, Lgnu/mapping/Location;

    if-eqz v7, :cond_8

    move-object v2, v5

    .line 662
    check-cast v2, Lgnu/mapping/Location;

    .line 663
    .local v2, "loc":Lgnu/mapping/Location;
    invoke-virtual {v2}, Lgnu/mapping/Location;->isBound()Z

    move-result v7

    if-eqz v7, :cond_7

    .line 664
    invoke-virtual {v2}, Lgnu/mapping/Location;->get()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {p0, v7, p2}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Object;Z)Lgnu/bytecode/Type;

    move-result-object v6

    goto/16 :goto_0

    .line 665
    :cond_7
    instance-of v7, v2, Lgnu/mapping/Named;

    if-eqz v7, :cond_0

    .line 667
    check-cast v2, Lgnu/mapping/Named;

    .end local v2    # "loc":Lgnu/mapping/Location;
    invoke-interface {v2}, Lgnu/mapping/Named;->getName()Ljava/lang/String;

    move-result-object v3

    .line 673
    .end local v5    # "val":Ljava/lang/Object;
    :cond_8
    invoke-virtual {p0}, Lgnu/expr/Language;->getEnvironment()Lgnu/mapping/Environment;

    move-result-object v7

    invoke-virtual {v7, v3}, Lgnu/mapping/Environment;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 674
    .restart local v5    # "val":Ljava/lang/Object;
    instance-of v7, v5, Lgnu/bytecode/Type;

    if-eqz v7, :cond_a

    .line 675
    check-cast v5, Lgnu/bytecode/Type;

    .end local v5    # "val":Ljava/lang/Object;
    move-object v6, v5

    goto/16 :goto_0

    .line 670
    :cond_9
    const-wide/32 v7, 0x10000

    invoke-virtual {v0, v7, v8}, Lgnu/expr/Declaration;->getFlag(J)Z

    move-result v7

    if-nez v7, :cond_8

    .line 671
    invoke-virtual {p0, p1, p2}, Lgnu/expr/Language;->getTypeFor(Lgnu/expr/Expression;Z)Lgnu/bytecode/Type;

    move-result-object v6

    goto/16 :goto_0

    .line 676
    .restart local v5    # "val":Ljava/lang/Object;
    :cond_a
    instance-of v7, v5, Lgnu/kawa/lispexpr/ClassNamespace;

    if-eqz v7, :cond_b

    .line 677
    check-cast v5, Lgnu/kawa/lispexpr/ClassNamespace;

    .end local v5    # "val":Ljava/lang/Object;
    invoke-virtual {v5}, Lgnu/kawa/lispexpr/ClassNamespace;->getClassType()Lgnu/bytecode/ClassType;

    move-result-object v6

    goto/16 :goto_0

    .line 678
    .restart local v5    # "val":Ljava/lang/Object;
    :cond_b
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v1

    .line 679
    .local v1, "len":I
    const/4 v7, 0x2

    if-le v1, v7, :cond_0

    const/4 v7, 0x0

    invoke-virtual {v3, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    const/16 v8, 0x3c

    if-ne v7, v8, :cond_0

    add-int/lit8 v7, v1, -0x1

    invoke-virtual {v3, v7}, Ljava/lang/String;->charAt(I)C

    move-result v7

    const/16 v8, 0x3e

    if-ne v7, v8, :cond_0

    .line 681
    add-int/lit8 v7, v1, -0x1

    invoke-virtual {v3, v9, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0, v7}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/String;)Lgnu/bytecode/Type;

    move-result-object v6

    goto/16 :goto_0

    .line 683
    .end local v0    # "decl":Lgnu/expr/Declaration;
    .end local v1    # "len":I
    .end local v3    # "name":Ljava/lang/String;
    .end local v4    # "rexp":Lgnu/expr/ReferenceExp;
    .end local v5    # "val":Ljava/lang/Object;
    :cond_c
    instance-of v7, p1, Lgnu/expr/ClassExp;

    if-nez v7, :cond_d

    instance-of v7, p1, Lgnu/expr/ModuleExp;

    if-eqz v7, :cond_0

    :cond_d
    move-object v7, p1

    .line 685
    check-cast v7, Lgnu/expr/LambdaExp;

    invoke-virtual {v7}, Lgnu/expr/LambdaExp;->getClassType()Lgnu/bytecode/ClassType;

    move-result-object v6

    goto/16 :goto_0
.end method

.method public getTypeFor(Ljava/lang/Class;)Lgnu/bytecode/Type;
    .locals 1
    .param p1, "clas"    # Ljava/lang/Class;

    .prologue
    .line 551
    invoke-static {p1}, Lgnu/bytecode/Type;->make(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object v0

    return-object v0
.end method

.method public final getTypeFor(Ljava/lang/Object;Z)Lgnu/bytecode/Type;
    .locals 2
    .param p1, "spec"    # Ljava/lang/Object;
    .param p2, "lenient"    # Z

    .prologue
    .line 594
    instance-of v1, p1, Lgnu/bytecode/Type;

    if-eqz v1, :cond_0

    .line 595
    check-cast p1, Lgnu/bytecode/Type;

    .line 610
    .end local p1    # "spec":Ljava/lang/Object;
    :goto_0
    return-object p1

    .line 596
    .restart local p1    # "spec":Ljava/lang/Object;
    :cond_0
    instance-of v1, p1, Ljava/lang/Class;

    if-eqz v1, :cond_1

    .line 597
    check-cast p1, Ljava/lang/Class;

    .end local p1    # "spec":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/Class;)Lgnu/bytecode/Type;

    move-result-object p1

    goto :goto_0

    .line 598
    .restart local p1    # "spec":Ljava/lang/Object;
    :cond_1
    if-eqz p2, :cond_4

    instance-of v1, p1, Lgnu/lists/FString;

    if-nez v1, :cond_3

    instance-of v1, p1, Ljava/lang/String;

    if-nez v1, :cond_3

    instance-of v1, p1, Lgnu/mapping/Symbol;

    if-eqz v1, :cond_2

    move-object v1, p1

    check-cast v1, Lgnu/mapping/Symbol;

    invoke-virtual {v1}, Lgnu/mapping/Symbol;->hasEmptyNamespace()Z

    move-result v1

    if-nez v1, :cond_3

    :cond_2
    instance-of v1, p1, Lgnu/lists/CharSeq;

    if-eqz v1, :cond_4

    .line 603
    :cond_3
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lgnu/expr/Language;->getTypeFor(Ljava/lang/String;)Lgnu/bytecode/Type;

    move-result-object p1

    goto :goto_0

    .line 604
    :cond_4
    instance-of v1, p1, Lgnu/mapping/Namespace;

    if-eqz v1, :cond_5

    .line 606
    check-cast p1, Lgnu/mapping/Namespace;

    .end local p1    # "spec":Ljava/lang/Object;
    invoke-virtual {p1}, Lgnu/mapping/Namespace;->getName()Ljava/lang/String;

    move-result-object v0

    .line 607
    .local v0, "uri":Ljava/lang/String;
    if-eqz v0, :cond_5

    const-string v1, "class:"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 608
    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lgnu/expr/Language;->string2Type(Ljava/lang/String;)Lgnu/bytecode/Type;

    move-result-object v1

    invoke-virtual {p0, v1}, Lgnu/expr/Language;->getLangTypeFor(Lgnu/bytecode/Type;)Lgnu/bytecode/Type;

    move-result-object p1

    goto :goto_0

    .line 610
    .end local v0    # "uri":Ljava/lang/String;
    :cond_5
    const/4 p1, 0x0

    goto :goto_0
.end method

.method public getTypeFor(Ljava/lang/String;)Lgnu/bytecode/Type;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 589
    invoke-static {p1}, Lgnu/expr/Language;->string2Type(Ljava/lang/String;)Lgnu/bytecode/Type;

    move-result-object v0

    return-object v0
.end method

.method public hasNamespace(Lgnu/expr/Declaration;I)Z
    .locals 1
    .param p1, "decl"    # Lgnu/expr/Declaration;
    .param p2, "namespace"    # I

    .prologue
    .line 806
    invoke-virtual {p0, p1}, Lgnu/expr/Language;->getNamespaceOf(Lgnu/expr/Declaration;)I

    move-result v0

    and-int/2addr v0, p2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasSeparateFunctionNamespace()Z
    .locals 1

    .prologue
    .line 282
    const/4 v0, 0x0

    return v0
.end method

.method public isTrue(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 264
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public loadClass(Ljava/lang/String;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 399
    :try_start_0
    invoke-static {p1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 407
    .local v0, "clas":Ljava/lang/Class;
    :try_start_1
    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v2

    .line 408
    .local v2, "inst":Ljava/lang/Object;
    invoke-static {}, Lgnu/mapping/Environment;->getCurrent()Lgnu/mapping/Environment;

    move-result-object v3

    invoke-static {v2, p0, v3}, Lgnu/kawa/reflect/ClassMemberLocation;->defineAll(Ljava/lang/Object;Lgnu/expr/Language;Lgnu/mapping/Environment;)V

    .line 409
    instance-of v3, v2, Lgnu/expr/ModuleBody;

    if-eqz v3, :cond_0

    .line 410
    check-cast v2, Lgnu/expr/ModuleBody;

    .end local v2    # "inst":Ljava/lang/Object;
    invoke-virtual {v2}, Lgnu/expr/ModuleBody;->run()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 416
    :cond_0
    return-void

    .line 401
    .end local v0    # "clas":Ljava/lang/Class;
    :catch_0
    move-exception v1

    .line 403
    .local v1, "ex":Ljava/lang/ClassNotFoundException;
    throw v1

    .line 412
    .end local v1    # "ex":Ljava/lang/ClassNotFoundException;
    .restart local v0    # "clas":Ljava/lang/Class;
    :catch_1
    move-exception v1

    .line 414
    .local v1, "ex":Ljava/lang/Exception;
    new-instance v3, Lgnu/mapping/WrappedException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "cannot load "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4, v1}, Lgnu/mapping/WrappedException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3
.end method

.method public lookup(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 425
    iget-object v0, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    invoke-virtual {v0, p1}, Lgnu/mapping/Environment;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public lookupBuiltin(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Lgnu/mapping/NamedLocation;
    .locals 1
    .param p1, "name"    # Lgnu/mapping/Symbol;
    .param p2, "property"    # Ljava/lang/Object;
    .param p3, "hash"    # I

    .prologue
    .line 312
    iget-object v0, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lgnu/expr/Language;->environ:Lgnu/mapping/Environment;

    invoke-virtual {v0, p1, p2, p3}, Lgnu/mapping/Environment;->lookup(Lgnu/mapping/Symbol;Ljava/lang/Object;I)Lgnu/mapping/NamedLocation;

    move-result-object v0

    goto :goto_0
.end method

.method public noValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 275
    sget-object v0, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    return-object v0
.end method

.method public final parse(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;I)Lgnu/expr/Compilation;
    .locals 2
    .param p1, "port"    # Lgnu/mapping/InPort;
    .param p2, "messages"    # Lgnu/text/SourceMessages;
    .param p3, "options"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 491
    invoke-virtual {p0, p1, p2}, Lgnu/expr/Language;->getLexer(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;)Lgnu/text/Lexer;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, p3, v1}, Lgnu/expr/Language;->parse(Lgnu/text/Lexer;ILgnu/expr/ModuleInfo;)Lgnu/expr/Compilation;

    move-result-object v0

    return-object v0
.end method

.method public final parse(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;ILgnu/expr/ModuleInfo;)Lgnu/expr/Compilation;
    .locals 1
    .param p1, "port"    # Lgnu/mapping/InPort;
    .param p2, "messages"    # Lgnu/text/SourceMessages;
    .param p3, "options"    # I
    .param p4, "info"    # Lgnu/expr/ModuleInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 507
    invoke-virtual {p0, p1, p2}, Lgnu/expr/Language;->getLexer(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;)Lgnu/text/Lexer;

    move-result-object v0

    invoke-virtual {p0, v0, p3, p4}, Lgnu/expr/Language;->parse(Lgnu/text/Lexer;ILgnu/expr/ModuleInfo;)Lgnu/expr/Compilation;

    move-result-object v0

    return-object v0
.end method

.method public final parse(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;Lgnu/expr/ModuleInfo;)Lgnu/expr/Compilation;
    .locals 2
    .param p1, "port"    # Lgnu/mapping/InPort;
    .param p2, "messages"    # Lgnu/text/SourceMessages;
    .param p3, "info"    # Lgnu/expr/ModuleInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 499
    invoke-virtual {p0, p1, p2}, Lgnu/expr/Language;->getLexer(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;)Lgnu/text/Lexer;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {p0, v0, v1, p3}, Lgnu/expr/Language;->parse(Lgnu/text/Lexer;ILgnu/expr/ModuleInfo;)Lgnu/expr/Compilation;

    move-result-object v0

    return-object v0
.end method

.method public final parse(Lgnu/text/Lexer;ILgnu/expr/ModuleInfo;)Lgnu/expr/Compilation;
    .locals 6
    .param p1, "lexer"    # Lgnu/text/Lexer;
    .param p2, "options"    # I
    .param p3, "info"    # Lgnu/expr/ModuleInfo;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 513
    invoke-virtual {p1}, Lgnu/text/Lexer;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v2

    .line 514
    .local v2, "messages":Lgnu/text/SourceMessages;
    and-int/lit8 v5, p2, 0x2

    if-eqz v5, :cond_6

    invoke-virtual {p0}, Lgnu/expr/Language;->getEnvironment()Lgnu/mapping/Environment;

    move-result-object v5

    invoke-static {v5, p0}, Lgnu/expr/NameLookup;->getInstance(Lgnu/mapping/Environment;Lgnu/expr/Language;)Lgnu/expr/NameLookup;

    move-result-object v1

    .line 517
    .local v1, "lexical":Lgnu/expr/NameLookup;
    :goto_0
    and-int/lit8 v5, p2, 0x1

    if-eqz v5, :cond_7

    move v0, v4

    .line 518
    .local v0, "immediate":Z
    :goto_1
    invoke-virtual {p0, p1, v2, v1}, Lgnu/expr/Language;->getCompilation(Lgnu/text/Lexer;Lgnu/text/SourceMessages;Lgnu/expr/NameLookup;)Lgnu/expr/Compilation;

    move-result-object v3

    .line 519
    .local v3, "tr":Lgnu/expr/Compilation;
    sget-boolean v5, Lgnu/expr/Language;->requirePedantic:Z

    if-eqz v5, :cond_0

    .line 520
    iput-boolean v4, v3, Lgnu/expr/Compilation;->pedantic:Z

    .line 521
    :cond_0
    if-nez v0, :cond_1

    .line 522
    iput-boolean v4, v3, Lgnu/expr/Compilation;->mustCompile:Z

    .line 523
    :cond_1
    iput-boolean v0, v3, Lgnu/expr/Compilation;->immediate:Z

    .line 524
    iput p2, v3, Lgnu/expr/Compilation;->langOptions:I

    .line 525
    and-int/lit8 v5, p2, 0x40

    if-eqz v5, :cond_2

    .line 526
    iput-boolean v4, v3, Lgnu/expr/Compilation;->explicit:Z

    .line 527
    :cond_2
    and-int/lit8 v5, p2, 0x8

    if-eqz v5, :cond_3

    .line 528
    invoke-virtual {v3, v4}, Lgnu/expr/Compilation;->setState(I)V

    .line 529
    :cond_3
    invoke-virtual {v3, p1}, Lgnu/expr/Compilation;->pushNewModule(Lgnu/text/Lexer;)Lgnu/expr/ModuleExp;

    .line 530
    if-eqz p3, :cond_4

    .line 531
    invoke-virtual {p3, v3}, Lgnu/expr/ModuleInfo;->setCompilation(Lgnu/expr/Compilation;)V

    .line 532
    :cond_4
    invoke-virtual {p0, v3, p2}, Lgnu/expr/Language;->parse(Lgnu/expr/Compilation;I)Z

    move-result v5

    if-nez v5, :cond_8

    .line 533
    const/4 v3, 0x0

    .line 536
    .end local v3    # "tr":Lgnu/expr/Compilation;
    :cond_5
    :goto_2
    return-object v3

    .line 514
    .end local v0    # "immediate":Z
    .end local v1    # "lexical":Lgnu/expr/NameLookup;
    :cond_6
    new-instance v1, Lgnu/expr/NameLookup;

    invoke-direct {v1, p0}, Lgnu/expr/NameLookup;-><init>(Lgnu/expr/Language;)V

    goto :goto_0

    .line 517
    .restart local v1    # "lexical":Lgnu/expr/NameLookup;
    :cond_7
    const/4 v0, 0x0

    goto :goto_1

    .line 534
    .restart local v0    # "immediate":Z
    .restart local v3    # "tr":Lgnu/expr/Compilation;
    :cond_8
    invoke-virtual {v3}, Lgnu/expr/Compilation;->getState()I

    move-result v5

    if-ne v5, v4, :cond_5

    .line 535
    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Lgnu/expr/Compilation;->setState(I)V

    goto :goto_2
.end method

.method public abstract parse(Lgnu/expr/Compilation;I)Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation
.end method

.method public resolve(Lgnu/expr/Compilation;)V
    .locals 0
    .param p1, "comp"    # Lgnu/expr/Compilation;

    .prologue
    .line 547
    return-void
.end method

.method public runAsApplication([Ljava/lang/String;)V
    .locals 0
    .param p1, "args"    # [Ljava/lang/String;

    .prologue
    .line 958
    invoke-static {p0}, Lgnu/expr/Language;->setDefaults(Lgnu/expr/Language;)V

    .line 959
    invoke-static {p1}, Lkawa/repl;->main([Ljava/lang/String;)V

    .line 960
    return-void
.end method
