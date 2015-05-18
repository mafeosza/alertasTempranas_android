.class public Lkawa/standard/define_autoload;
.super Lkawa/lang/Syntax;
.source "define_autoload.java"


# static fields
.field public static final define_autoload:Lkawa/standard/define_autoload;

.field public static final define_autoloads_from_file:Lkawa/standard/define_autoload;


# instance fields
.field fromFile:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 14
    new-instance v0, Lkawa/standard/define_autoload;

    const-string v1, "define-autoload"

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lkawa/standard/define_autoload;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lkawa/standard/define_autoload;->define_autoload:Lkawa/standard/define_autoload;

    .line 16
    new-instance v0, Lkawa/standard/define_autoload;

    const-string v1, "define-autoloads-from-file"

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Lkawa/standard/define_autoload;-><init>(Ljava/lang/String;Z)V

    sput-object v0, Lkawa/standard/define_autoload;->define_autoloads_from_file:Lkawa/standard/define_autoload;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "fromFile"    # Z

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lkawa/lang/Syntax;-><init>(Ljava/lang/Object;)V

    .line 24
    iput-boolean p2, p0, Lkawa/standard/define_autoload;->fromFile:Z

    .line 25
    return-void
.end method

.method public static findAutoloadComments(Lgnu/kawa/lispexpr/LispReader;Ljava/lang/String;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)V
    .locals 21
    .param p0, "in"    # Lgnu/kawa/lispexpr/LispReader;
    .param p1, "filename"    # Ljava/lang/String;
    .param p2, "defs"    # Lgnu/expr/ScopeExp;
    .param p3, "tr"    # Lkawa/lang/Translator;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lgnu/text/SyntaxException;
        }
    .end annotation

    .prologue
    .line 143
    const/4 v11, 0x1

    .line 144
    .local v11, "lineStart":Z
    const-string v12, ";;;###autoload"

    .line 145
    .local v12, "magic":Ljava/lang/String;
    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v13

    .line 149
    .local v13, "magicLength":I
    :cond_0
    :goto_0
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->peek()I

    move-result v4

    .line 150
    .local v4, "ch":I
    if-gez v4, :cond_2

    .line 230
    :cond_1
    :goto_1
    return-void

    .line 152
    :cond_2
    const/16 v18, 0xa

    move/from16 v0, v18

    if-eq v4, v0, :cond_3

    const/16 v18, 0xd

    move/from16 v0, v18

    if-ne v4, v0, :cond_4

    .line 154
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    .line 155
    const/4 v11, 0x1

    .line 156
    goto :goto_0

    .line 158
    :cond_4
    if-eqz v11, :cond_e

    const/16 v18, 0x3b

    move/from16 v0, v18

    if-ne v4, v0, :cond_e

    .line 160
    const/4 v9, 0x0

    .local v9, "i":I
    move v10, v9

    .line 163
    .end local v9    # "i":I
    .local v10, "i":I
    :cond_5
    :goto_2
    if-ne v10, v13, :cond_7

    .line 177
    if-lez v10, :cond_e

    .line 179
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->readObject()Ljava/lang/Object;

    move-result-object v8

    .line 180
    .local v8, "form":Ljava/lang/Object;
    instance-of v0, v8, Lgnu/lists/Pair;

    move/from16 v18, v0

    if-eqz v18, :cond_6

    move-object v15, v8

    .line 182
    check-cast v15, Lgnu/lists/Pair;

    .line 183
    .local v15, "pair":Lgnu/lists/Pair;
    const/16 v17, 0x0

    .line 184
    .local v17, "value":Ljava/lang/Object;
    const/4 v14, 0x0

    .line 185
    .local v14, "name":Ljava/lang/String;
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v3

    .line 186
    .local v3, "car":Ljava/lang/Object;
    instance-of v0, v3, Ljava/lang/String;

    move/from16 v18, v0

    if-eqz v18, :cond_b

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 190
    .end local v3    # "car":Ljava/lang/Object;
    .local v5, "command":Ljava/lang/String;
    :goto_3
    const-string v18, "defun"

    move-object/from16 v0, v18

    if-ne v5, v0, :cond_d

    .line 192
    invoke-virtual {v15}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v18

    check-cast v18, Lgnu/lists/Pair;

    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v14

    .line 193
    new-instance v17, Lkawa/lang/AutoloadProcedure;

    .end local v17    # "value":Ljava/lang/Object;
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getLanguage()Lgnu/expr/Language;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    move-object/from16 v2, v18

    invoke-direct {v0, v14, v1, v2}, Lkawa/lang/AutoloadProcedure;-><init>(Ljava/lang/String;Ljava/lang/String;Lgnu/expr/Language;)V

    .line 199
    :goto_4
    if-eqz v17, :cond_6

    .line 201
    const/16 v18, 0x77

    move-object/from16 v0, p2

    move/from16 v1, v18

    move-object/from16 v2, p3

    invoke-virtual {v0, v14, v1, v2}, Lgnu/expr/ScopeExp;->getDefine(Ljava/lang/Object;CLgnu/expr/Compilation;)Lgnu/expr/Declaration;

    move-result-object v6

    .line 202
    .local v6, "decl":Lgnu/expr/Declaration;
    new-instance v7, Lgnu/expr/QuoteExp;

    move-object/from16 v0, v17

    invoke-direct {v7, v0}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    .line 203
    .local v7, "ex":Lgnu/expr/Expression;
    const-wide/16 v18, 0x4000

    move-wide/from16 v0, v18

    invoke-virtual {v6, v0, v1}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 204
    invoke-virtual {v6, v7}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    .line 205
    const/16 v18, 0x1

    move/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/expr/Declaration;->setProcedureDecl(Z)V

    .line 206
    sget-object v18, Lgnu/expr/Compilation;->typeProcedure:Lgnu/bytecode/ClassType;

    move-object/from16 v0, v18

    invoke-virtual {v6, v0}, Lgnu/expr/Declaration;->setType(Lgnu/bytecode/Type;)V

    .line 209
    .end local v5    # "command":Ljava/lang/String;
    .end local v6    # "decl":Lgnu/expr/Declaration;
    .end local v7    # "ex":Lgnu/expr/Expression;
    .end local v14    # "name":Ljava/lang/String;
    .end local v15    # "pair":Lgnu/lists/Pair;
    :cond_6
    const/4 v11, 0x0

    .line 210
    goto/16 :goto_0

    .line 165
    .end local v8    # "form":Ljava/lang/Object;
    :cond_7
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->read()I

    move-result v4

    .line 166
    if-ltz v4, :cond_1

    .line 168
    const/16 v18, 0xa

    move/from16 v0, v18

    if-eq v4, v0, :cond_8

    const/16 v18, 0xd

    move/from16 v0, v18

    if-ne v4, v0, :cond_9

    .line 170
    :cond_8
    const/4 v11, 0x1

    .line 171
    goto/16 :goto_0

    .line 173
    :cond_9
    if-ltz v10, :cond_5

    add-int/lit8 v9, v10, 0x1

    .end local v10    # "i":I
    .restart local v9    # "i":I
    invoke-virtual {v12, v10}, Ljava/lang/String;->charAt(I)C

    move-result v18

    move/from16 v0, v18

    if-ne v4, v0, :cond_a

    move v10, v9

    .line 174
    .end local v9    # "i":I
    .restart local v10    # "i":I
    goto/16 :goto_2

    .line 175
    .end local v10    # "i":I
    .restart local v9    # "i":I
    :cond_a
    const/4 v9, -0x1

    move v10, v9

    .end local v9    # "i":I
    .restart local v10    # "i":I
    goto/16 :goto_2

    .line 186
    .restart local v3    # "car":Ljava/lang/Object;
    .restart local v8    # "form":Ljava/lang/Object;
    .restart local v14    # "name":Ljava/lang/String;
    .restart local v15    # "pair":Lgnu/lists/Pair;
    .restart local v17    # "value":Ljava/lang/Object;
    :cond_b
    instance-of v0, v3, Lgnu/mapping/Symbol;

    move/from16 v18, v0

    if-eqz v18, :cond_c

    check-cast v3, Lgnu/mapping/Symbol;

    .end local v3    # "car":Ljava/lang/Object;
    invoke-virtual {v3}, Lgnu/mapping/Symbol;->getName()Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_3

    .restart local v3    # "car":Ljava/lang/Object;
    :cond_c
    const/4 v5, 0x0

    goto/16 :goto_3

    .line 197
    .end local v3    # "car":Ljava/lang/Object;
    .restart local v5    # "command":Ljava/lang/String;
    :cond_d
    const/16 v18, 0x77

    new-instance v19, Ljava/lang/StringBuilder;

    invoke-direct/range {v19 .. v19}, Ljava/lang/StringBuilder;-><init>()V

    const-string v20, "unsupported ;;;###autoload followed by: "

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual {v15}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v20

    invoke-virtual/range {v19 .. v20}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v19

    invoke-virtual/range {v19 .. v19}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, p3

    move/from16 v1, v18

    move-object/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    goto/16 :goto_4

    .line 213
    .end local v5    # "command":Ljava/lang/String;
    .end local v8    # "form":Ljava/lang/Object;
    .end local v10    # "i":I
    .end local v14    # "name":Ljava/lang/String;
    .end local v15    # "pair":Lgnu/lists/Pair;
    .end local v17    # "value":Ljava/lang/Object;
    :cond_e
    const/4 v11, 0x0

    .line 214
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->skip()V

    .line 215
    const/16 v18, 0x23

    move/from16 v0, v18

    if-ne v4, v0, :cond_f

    .line 217
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->peek()I

    move-result v18

    const/16 v19, 0x7c

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_f

    .line 219
    invoke-virtual/range {p0 .. p0}, Lgnu/kawa/lispexpr/LispReader;->skip()V

    .line 220
    const/16 v18, 0x23

    const/16 v19, 0x7c

    move-object/from16 v0, p0

    move/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v0, v1, v2}, Lgnu/kawa/lispexpr/LispReader;->readNestedComment(CC)V

    goto/16 :goto_0

    .line 224
    :cond_f
    int-to-char v0, v4

    move/from16 v18, v0

    invoke-static/range {v18 .. v18}, Ljava/lang/Character;->isWhitespace(C)Z

    move-result v18

    if-nez v18, :cond_0

    .line 228
    move-object/from16 v0, p0

    invoke-virtual {v0, v4}, Lgnu/kawa/lispexpr/LispReader;->readObject(I)Ljava/lang/Object;

    move-result-object v16

    .line 229
    .local v16, "skipped":Ljava/lang/Object;
    sget-object v18, Lgnu/lists/Sequence;->eofValue:Ljava/lang/Object;

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    if-ne v0, v1, :cond_0

    goto/16 :goto_1
.end method

.method public static process(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 10
    .param p0, "names"    # Ljava/lang/Object;
    .param p1, "filename"    # Ljava/lang/Object;
    .param p2, "forms"    # Ljava/util/Vector;
    .param p3, "defs"    # Lgnu/expr/ScopeExp;
    .param p4, "tr"    # Lkawa/lang/Translator;

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 239
    instance-of v9, p0, Lgnu/lists/Pair;

    if-eqz v9, :cond_2

    move-object v5, p0

    .line 241
    check-cast v5, Lgnu/lists/Pair;

    .line 242
    .local v5, "p":Lgnu/lists/Pair;
    invoke-virtual {v5}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v9

    invoke-static {v9, p1, p2, p3, p4}, Lkawa/standard/define_autoload;->process(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-virtual {v5}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v9

    invoke-static {v9, p1, p2, p3, p4}, Lkawa/standard/define_autoload;->process(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 285
    .end local v5    # "p":Lgnu/lists/Pair;
    .end local p1    # "filename":Ljava/lang/Object;
    :cond_0
    :goto_0
    return v7

    .restart local v5    # "p":Lgnu/lists/Pair;
    .restart local p1    # "filename":Ljava/lang/Object;
    :cond_1
    move v7, v8

    .line 242
    goto :goto_0

    .line 245
    .end local v5    # "p":Lgnu/lists/Pair;
    :cond_2
    sget-object v9, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-eq p0, v9, :cond_0

    .line 270
    instance-of v9, p0, Ljava/lang/String;

    if-nez v9, :cond_3

    instance-of v9, p0, Lgnu/mapping/Symbol;

    if-eqz v9, :cond_5

    .line 272
    :cond_3
    invoke-virtual {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 273
    .local v4, "name":Ljava/lang/String;
    const/16 v9, 0x77

    invoke-virtual {p3, v4, v9, p4}, Lgnu/expr/ScopeExp;->getDefine(Ljava/lang/Object;CLgnu/expr/Compilation;)Lgnu/expr/Declaration;

    move-result-object v0

    .line 274
    .local v0, "decl":Lgnu/expr/Declaration;
    instance-of v9, p1, Ljava/lang/String;

    if-eqz v9, :cond_4

    move-object v2, p1

    check-cast v2, Ljava/lang/String;

    .local v2, "fn":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v3

    .local v3, "len":I
    const/4 v9, 0x2

    if-le v3, v9, :cond_4

    invoke-virtual {v2, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    const/16 v9, 0x3c

    if-ne v8, v9, :cond_4

    add-int/lit8 v8, v3, -0x1

    invoke-virtual {v2, v8}, Ljava/lang/String;->charAt(I)C

    move-result v8

    const/16 v9, 0x3e

    if-ne v8, v9, :cond_4

    .line 277
    add-int/lit8 v8, v3, -0x1

    invoke-virtual {v2, v7, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 278
    .end local v2    # "fn":Ljava/lang/String;
    .end local v3    # "len":I
    .end local p1    # "filename":Ljava/lang/Object;
    :cond_4
    new-instance v6, Lkawa/lang/AutoloadProcedure;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p4}, Lkawa/lang/Translator;->getLanguage()Lgnu/expr/Language;

    move-result-object v9

    invoke-direct {v6, v4, v8, v9}, Lkawa/lang/AutoloadProcedure;-><init>(Ljava/lang/String;Ljava/lang/String;Lgnu/expr/Language;)V

    .line 280
    .local v6, "value":Lkawa/lang/AutoloadProcedure;
    new-instance v1, Lgnu/expr/QuoteExp;

    invoke-direct {v1, v6}, Lgnu/expr/QuoteExp;-><init>(Ljava/lang/Object;)V

    .line 281
    .local v1, "ex":Lgnu/expr/Expression;
    const-wide/16 v8, 0x4000

    invoke-virtual {v0, v8, v9}, Lgnu/expr/Declaration;->setFlag(J)V

    .line 282
    invoke-virtual {v0, v1}, Lgnu/expr/Declaration;->noteValue(Lgnu/expr/Expression;)V

    goto :goto_0

    .end local v0    # "decl":Lgnu/expr/Declaration;
    .end local v1    # "ex":Lgnu/expr/Expression;
    .end local v4    # "name":Ljava/lang/String;
    .end local v6    # "value":Lkawa/lang/AutoloadProcedure;
    .restart local p1    # "filename":Ljava/lang/Object;
    :cond_5
    move v7, v8

    .line 285
    goto :goto_0
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 290
    const/4 v0, 0x0

    return-object v0
.end method

.method public scanFile(Ljava/lang/String;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 20
    .param p1, "filespec"    # Ljava/lang/String;
    .param p2, "defs"    # Lgnu/expr/ScopeExp;
    .param p3, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 70
    const-string v17, ".el"

    move-object/from16 v0, p1

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_0

    .line 72
    :cond_0
    new-instance v9, Ljava/io/File;

    move-object/from16 v0, p1

    invoke-direct {v9, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 73
    .local v9, "file":Ljava/io/File;
    invoke-virtual {v9}, Ljava/io/File;->isAbsolute()Z

    move-result v17

    if-nez v17, :cond_1

    .line 74
    new-instance v9, Ljava/io/File;

    .end local v9    # "file":Ljava/io/File;
    new-instance v17, Ljava/io/File;

    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getFileName()Ljava/lang/String;

    move-result-object v18

    invoke-direct/range {v17 .. v18}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v17 .. v17}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-direct {v9, v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 75
    .restart local v9    # "file":Ljava/io/File;
    :cond_1
    invoke-virtual {v9}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v10

    .line 76
    .local v10, "filename":Ljava/lang/String;
    const/16 v17, 0x2e

    move/from16 v0, v17

    invoke-virtual {v10, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v5

    .line 78
    .local v5, "dot":I
    if-ltz v5, :cond_5

    .line 80
    invoke-virtual {v10, v5}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v7

    .line 81
    .local v7, "extension":Ljava/lang/String;
    invoke-static {v7}, Lgnu/expr/Language;->getInstance(Ljava/lang/String;)Lgnu/expr/Language;

    move-result-object v12

    .line 82
    .local v12, "language":Lgnu/expr/Language;
    if-nez v12, :cond_2

    .line 84
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "unknown extension for "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p3

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    .line 85
    const/16 v17, 0x1

    .line 136
    .end local v7    # "extension":Ljava/lang/String;
    .end local v12    # "language":Lgnu/expr/Language;
    :goto_0
    return v17

    .line 106
    .restart local v7    # "extension":Ljava/lang/String;
    .restart local v12    # "language":Lgnu/expr/Language;
    :cond_2
    move-object/from16 v0, p3

    iget-object v15, v0, Lkawa/lang/Translator;->classPrefix:Ljava/lang/String;

    .line 107
    .local v15, "prefix":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v8

    .line 108
    .local v8, "extlen":I
    invoke-virtual/range {p1 .. p1}, Ljava/lang/String;->length()I

    move-result v16

    .line 109
    .local v16, "speclen":I
    const/16 v17, 0x0

    sub-int v18, v16, v8

    move-object/from16 v0, p1

    move/from16 v1, v17

    move/from16 v2, v18

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 110
    .local v4, "cname":Ljava/lang/String;
    :goto_1
    const-string v17, "../"

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v17

    if-eqz v17, :cond_4

    .line 112
    const/16 v17, 0x2e

    invoke-virtual {v15}, Ljava/lang/String;->length()I

    move-result v18

    add-int/lit8 v18, v18, -0x2

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v15, v0, v1}, Ljava/lang/String;->lastIndexOf(II)I

    move-result v11

    .line 113
    .local v11, "i":I
    if-gez v11, :cond_3

    .line 115
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "cannot use relative filename \""

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "\" with simple prefix \""

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "\""

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p3

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    .line 117
    const/16 v17, 0x0

    goto :goto_0

    .line 119
    :cond_3
    const/16 v17, 0x0

    add-int/lit8 v18, v11, 0x1

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v15, v0, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v15

    .line 120
    const/16 v17, 0x3

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    .line 121
    goto :goto_1

    .line 122
    .end local v11    # "i":I
    :cond_4
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v17

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    const/16 v18, 0x2f

    const/16 v19, 0x2e

    invoke-virtual/range {v17 .. v19}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v3

    .line 126
    .local v3, "classname":Ljava/lang/String;
    :try_start_0
    invoke-static {v10}, Lgnu/mapping/InPort;->openFile(Ljava/lang/Object;)Lgnu/mapping/InPort;

    move-result-object v14

    .line 127
    .local v14, "port":Lgnu/mapping/InPort;
    invoke-virtual/range {p3 .. p3}, Lkawa/lang/Translator;->getMessages()Lgnu/text/SourceMessages;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v12, v14, v0}, Lgnu/expr/Language;->getLexer(Lgnu/mapping/InPort;Lgnu/text/SourceMessages;)Lgnu/text/Lexer;

    move-result-object v13

    .line 128
    .local v13, "lexer":Lgnu/text/Lexer;
    check-cast v13, Lgnu/kawa/lispexpr/LispReader;

    .end local v13    # "lexer":Lgnu/text/Lexer;
    move-object/from16 v0, p2

    move-object/from16 v1, p3

    invoke-static {v13, v3, v0, v1}, Lkawa/standard/define_autoload;->findAutoloadComments(Lgnu/kawa/lispexpr/LispReader;Ljava/lang/String;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 136
    .end local v3    # "classname":Ljava/lang/String;
    .end local v4    # "cname":Ljava/lang/String;
    .end local v7    # "extension":Ljava/lang/String;
    .end local v8    # "extlen":I
    .end local v12    # "language":Lgnu/expr/Language;
    .end local v14    # "port":Lgnu/mapping/InPort;
    .end local v15    # "prefix":Ljava/lang/String;
    .end local v16    # "speclen":I
    :cond_5
    const/16 v17, 0x1

    goto/16 :goto_0

    .line 130
    .restart local v3    # "classname":Ljava/lang/String;
    .restart local v4    # "cname":Ljava/lang/String;
    .restart local v7    # "extension":Ljava/lang/String;
    .restart local v8    # "extlen":I
    .restart local v12    # "language":Lgnu/expr/Language;
    .restart local v15    # "prefix":Ljava/lang/String;
    .restart local v16    # "speclen":I
    :catch_0
    move-exception v6

    .line 132
    .local v6, "ex":Ljava/lang/Exception;
    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    const-string v18, "error reading "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, ": "

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, p3

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    .line 133
    const/16 v17, 0x1

    goto/16 :goto_0
.end method

.method public scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 6
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "forms"    # Ljava/util/Vector;
    .param p3, "defs"    # Lgnu/expr/ScopeExp;
    .param p4, "tr"    # Lkawa/lang/Translator;

    .prologue
    const/4 v4, 0x0

    .line 30
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v5

    instance-of v5, v5, Lgnu/lists/Pair;

    if-nez v5, :cond_1

    .line 31
    invoke-super {p0, p1, p2, p3, p4}, Lkawa/lang/Syntax;->scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z

    move-result v4

    .line 65
    :cond_0
    :goto_0
    return v4

    .line 32
    :cond_1
    invoke-virtual {p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lgnu/lists/Pair;

    .line 33
    .local v2, "p":Lgnu/lists/Pair;
    iget-boolean v5, p0, Lkawa/standard/define_autoload;->fromFile:Z

    if-eqz v5, :cond_5

    .line 38
    :goto_1
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    instance-of v5, v5, Ljava/lang/CharSequence;

    if-nez v5, :cond_3

    .line 53
    :cond_2
    const-string v5, "invalid syntax for define-autoloads-from-file"

    invoke-virtual {p4, v5}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto :goto_0

    .line 44
    :cond_3
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5, p3, p4}, Lkawa/standard/define_autoload;->scanFile(Ljava/lang/String;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 46
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v3

    .line 47
    .local v3, "rest":Ljava/lang/Object;
    sget-object v5, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    if-ne v3, v5, :cond_4

    .line 48
    const/4 v4, 0x1

    goto :goto_0

    .line 49
    :cond_4
    instance-of v5, v3, Lgnu/lists/Pair;

    if-eqz v5, :cond_2

    .line 51
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "p":Lgnu/lists/Pair;
    check-cast v2, Lgnu/lists/Pair;

    .line 52
    .restart local v2    # "p":Lgnu/lists/Pair;
    goto :goto_1

    .line 56
    .end local v3    # "rest":Ljava/lang/Object;
    :cond_5
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v1

    .line 57
    .local v1, "names":Ljava/lang/Object;
    const/4 v0, 0x0

    .line 58
    .local v0, "filename":Ljava/lang/Object;
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v5

    instance-of v5, v5, Lgnu/lists/Pair;

    if-eqz v5, :cond_6

    .line 60
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "p":Lgnu/lists/Pair;
    check-cast v2, Lgnu/lists/Pair;

    .line 61
    .restart local v2    # "p":Lgnu/lists/Pair;
    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v0

    .line 62
    invoke-static {v1, v0, p2, p3, p4}, Lkawa/standard/define_autoload;->process(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z

    move-result v4

    goto :goto_0

    .line 64
    :cond_6
    const-string v5, "invalid syntax for define-autoload"

    invoke-virtual {p4, v5}, Lkawa/lang/Translator;->syntaxError(Ljava/lang/String;)Lgnu/expr/Expression;

    goto :goto_0
.end method
