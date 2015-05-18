.class public Lkawa/standard/ImportFromLibrary;
.super Lkawa/lang/Syntax;
.source "ImportFromLibrary.java"


# static fields
.field private static final BUILTIN:Ljava/lang/String; = ""

.field private static final MISSING:Ljava/lang/String;

.field static final SRFI97Map:[[Ljava/lang/String;

.field public static final instance:Lkawa/standard/ImportFromLibrary;


# instance fields
.field public classPrefixPath:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 18
    new-instance v0, Lkawa/standard/ImportFromLibrary;

    invoke-direct {v0}, Lkawa/standard/ImportFromLibrary;-><init>()V

    sput-object v0, Lkawa/standard/ImportFromLibrary;->instance:Lkawa/standard/ImportFromLibrary;

    .line 23
    const/4 v0, 0x0

    sput-object v0, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    .line 25
    const/16 v0, 0x30

    new-array v0, v0, [[Ljava/lang/String;

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "1"

    aput-object v2, v1, v4

    const-string v2, "lists"

    aput-object v2, v1, v5

    const-string v2, "gnu.kawa.slib.srfi1"

    aput-object v2, v1, v6

    aput-object v1, v0, v4

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "2"

    aput-object v2, v1, v4

    const-string v2, "and-let*"

    aput-object v2, v1, v5

    const-string v2, "gnu.kawa.slib.srfi2"

    aput-object v2, v1, v6

    aput-object v1, v0, v5

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "5"

    aput-object v2, v1, v4

    const-string v2, "let"

    aput-object v2, v1, v5

    sget-object v2, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v2, v1, v6

    aput-object v1, v0, v6

    new-array v1, v7, [Ljava/lang/String;

    const-string v2, "6"

    aput-object v2, v1, v4

    const-string v2, "basic-string-ports"

    aput-object v2, v1, v5

    const-string v2, ""

    aput-object v2, v1, v6

    aput-object v1, v0, v7

    const/4 v1, 0x4

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "8"

    aput-object v3, v2, v4

    const-string v3, "receive"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/4 v1, 0x5

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "9"

    aput-object v3, v2, v4

    const-string v3, "records"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/4 v1, 0x6

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "11"

    aput-object v3, v2, v4

    const-string v3, "let-values"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/4 v1, 0x7

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "13"

    aput-object v3, v2, v4

    const-string v3, "strings"

    aput-object v3, v2, v5

    const-string v3, "gnu.kawa.slib.srfi13"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x8

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "14"

    aput-object v3, v2, v4

    const-string v3, "char-sets"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x9

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "16"

    aput-object v3, v2, v4

    const-string v3, "case-lambda"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0xa

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "17"

    aput-object v3, v2, v4

    const-string v3, "generalized-set!"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0xb

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "18"

    aput-object v3, v2, v4

    const-string v3, "multithreading"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0xc

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "19"

    aput-object v3, v2, v4

    const-string v3, "time"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0xd

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "21"

    aput-object v3, v2, v4

    const-string v3, "real-time-multithreading"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0xe

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "23"

    aput-object v3, v2, v4

    const-string v3, "error"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0xf

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "25"

    aput-object v3, v2, v4

    const-string v3, "multi-dimensional-arrays"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x10

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "26"

    aput-object v3, v2, v4

    const-string v3, "cut"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x11

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "27"

    aput-object v3, v2, v4

    const-string v3, "random-bits"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x12

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "28"

    aput-object v3, v2, v4

    const-string v3, "basic-format-strings"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x13

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "29"

    aput-object v3, v2, v4

    const-string v3, "localization"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x14

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "31"

    aput-object v3, v2, v4

    const-string v3, "rec"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x15

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "38"

    aput-object v3, v2, v4

    const-string v3, "with-shared-structure"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x16

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "39"

    aput-object v3, v2, v4

    const-string v3, "parameters"

    aput-object v3, v2, v5

    const-string v3, ""

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x17

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "41"

    aput-object v3, v2, v4

    const-string v3, "streams"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x18

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "42"

    aput-object v3, v2, v4

    const-string v3, "eager-comprehensions"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x19

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "43"

    aput-object v3, v2, v4

    const-string v3, "vectors"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "44"

    aput-object v3, v2, v4

    const-string v3, "collections"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "45"

    aput-object v3, v2, v4

    const-string v3, "lazy"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "46"

    aput-object v3, v2, v4

    const-string v3, "syntax-rules"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x1d

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "47"

    aput-object v3, v2, v4

    const-string v3, "arrays"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x1e

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "48"

    aput-object v3, v2, v4

    const-string v3, "intermediate-format-strings"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x1f

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "51"

    aput-object v3, v2, v4

    const-string v3, "rest-values"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x20

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "54"

    aput-object v3, v2, v4

    const-string v3, "cat"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x21

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "57"

    aput-object v3, v2, v4

    const-string v3, "records"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x22

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "59"

    aput-object v3, v2, v4

    const-string v3, "vicinities"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x23

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "60"

    aput-object v3, v2, v4

    const-string v3, "integer-bits"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x24

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "61"

    aput-object v3, v2, v4

    const-string v3, "cond"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x25

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "63"

    aput-object v3, v2, v4

    const-string v3, "arrays"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x26

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "64"

    aput-object v3, v2, v4

    const-string v3, "testing"

    aput-object v3, v2, v5

    const-string v3, "gnu.kawa.slib.testing"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x27

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "66"

    aput-object v3, v2, v4

    const-string v3, "octet-vectors"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x28

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "67"

    aput-object v3, v2, v4

    const-string v3, "compare-procedures"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x29

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "69"

    aput-object v3, v2, v4

    const-string v3, "basic-hash-tables"

    aput-object v3, v2, v5

    const-string v3, "gnu.kawa.slib.srfi69"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x2a

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "71"

    aput-object v3, v2, v4

    const-string v3, "let"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x2b

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "74"

    aput-object v3, v2, v4

    const-string v3, "blobs"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x2c

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "78"

    aput-object v3, v2, v4

    const-string v3, "lightweight-testing"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x2d

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "86"

    aput-object v3, v2, v4

    const-string v3, "mu-and-nu"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x2e

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "87"

    aput-object v3, v2, v4

    const-string v3, "case"

    aput-object v3, v2, v5

    sget-object v3, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    const/16 v1, 0x2f

    new-array v2, v7, [Ljava/lang/String;

    const-string v3, "95"

    aput-object v3, v2, v4

    const-string v3, "sorting-and-merging"

    aput-object v3, v2, v5

    const-string v3, "kawa.lib.srfi95"

    aput-object v3, v2, v6

    aput-object v2, v0, v1

    sput-object v0, Lkawa/standard/ImportFromLibrary;->SRFI97Map:[[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    .line 16
    invoke-direct {p0}, Lkawa/lang/Syntax;-><init>()V

    .line 20
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, ""

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "kawa.lib."

    aput-object v2, v0, v1

    iput-object v0, p0, Lkawa/standard/ImportFromLibrary;->classPrefixPath:[Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public rewriteForm(Lgnu/lists/Pair;Lkawa/lang/Translator;)Lgnu/expr/Expression;
    .locals 1
    .param p1, "form"    # Lgnu/lists/Pair;
    .param p2, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 223
    const/4 v0, 0x0

    return-object v0
.end method

.method public scanForDefinitions(Lgnu/lists/Pair;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lkawa/lang/Translator;)Z
    .locals 29
    .param p1, "st"    # Lgnu/lists/Pair;
    .param p2, "forms"    # Ljava/util/Vector;
    .param p3, "defs"    # Lgnu/expr/ScopeExp;
    .param p4, "tr"    # Lkawa/lang/Translator;

    .prologue
    .line 79
    const/4 v4, 0x0

    .line 80
    .local v4, "mapper":Lgnu/mapping/Procedure;
    invoke-virtual/range {p1 .. p1}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v8

    .line 81
    .local v8, "args":Ljava/lang/Object;
    instance-of v2, v8, Lgnu/lists/Pair;

    if-nez v2, :cond_0

    .line 82
    const/4 v2, 0x0

    .line 218
    :goto_0
    return v2

    :cond_0
    move-object/from16 v18, v8

    .line 83
    check-cast v18, Lgnu/lists/Pair;

    .line 84
    .local v18, "pair":Lgnu/lists/Pair;
    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v16

    .line 85
    .local v16, "libref":Ljava/lang/Object;
    const/4 v2, 0x0

    move-object/from16 v0, v16

    invoke-static {v0, v2}, Lgnu/lists/LList;->listLength(Ljava/lang/Object;Z)I

    move-result v2

    if-gtz v2, :cond_1

    .line 87
    const/16 v2, 0x65

    const-string v5, "expected <library reference> which must be a list"

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 88
    const/4 v2, 0x0

    goto :goto_0

    .line 90
    :cond_1
    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v19

    .line 91
    .local v19, "rest":Ljava/lang/Object;
    move-object/from16 v0, v19

    instance-of v2, v0, Lgnu/lists/Pair;

    if-eqz v2, :cond_2

    move-object/from16 v2, v19

    check-cast v2, Lgnu/lists/Pair;

    invoke-virtual {v2}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v2

    instance-of v2, v2, Lgnu/mapping/Procedure;

    if-eqz v2, :cond_2

    .line 92
    check-cast v19, Lgnu/lists/Pair;

    .end local v19    # "rest":Ljava/lang/Object;
    invoke-virtual/range {v19 .. v19}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "mapper":Lgnu/mapping/Procedure;
    check-cast v4, Lgnu/mapping/Procedure;

    .line 94
    .restart local v4    # "mapper":Lgnu/mapping/Procedure;
    :cond_2
    const/16 v28, 0x0

    .line 95
    .local v28, "versionSpec":Ljava/lang/Object;
    const/16 v21, 0x0

    .line 96
    .local v21, "sourcePath":Ljava/lang/String;
    new-instance v20, Ljava/lang/StringBuffer;

    invoke-direct/range {v20 .. v20}, Ljava/lang/StringBuffer;-><init>()V

    .line 97
    .end local v28    # "versionSpec":Ljava/lang/Object;
    .local v20, "sbuf":Ljava/lang/StringBuffer;
    :goto_1
    move-object/from16 v0, v16

    instance-of v2, v0, Lgnu/lists/Pair;

    if-eqz v2, :cond_8

    move-object/from16 v18, v16

    .line 99
    check-cast v18, Lgnu/lists/Pair;

    .line 100
    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCar()Ljava/lang/Object;

    move-result-object v9

    .line 101
    .local v9, "car":Ljava/lang/Object;
    invoke-virtual/range {v18 .. v18}, Lgnu/lists/Pair;->getCdr()Ljava/lang/Object;

    move-result-object v10

    .line 102
    .local v10, "cdr":Ljava/lang/Object;
    instance-of v2, v9, Lgnu/lists/Pair;

    if-eqz v2, :cond_4

    .line 104
    if-eqz v28, :cond_3

    .line 106
    const/16 v2, 0x65

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "duplicate version reference - was "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v28

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 108
    :cond_3
    move-object/from16 v28, v9

    .line 109
    .restart local v28    # "versionSpec":Ljava/lang/Object;
    sget-object v2, Ljava/lang/System;->err:Ljava/io/PrintStream;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "import version "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 123
    .end local v28    # "versionSpec":Ljava/lang/Object;
    :goto_2
    move-object/from16 v16, v10

    .line 124
    goto :goto_1

    .line 111
    :cond_4
    instance-of v2, v9, Ljava/lang/String;

    if-eqz v2, :cond_6

    .line 113
    instance-of v2, v10, Lgnu/lists/Pair;

    if-eqz v2, :cond_5

    .line 114
    const/16 v2, 0x65

    const-string v5, "source specifier must be last elemnt in library reference"

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    :cond_5
    move-object/from16 v21, v9

    .line 115
    check-cast v21, Ljava/lang/String;

    goto :goto_2

    .line 119
    :cond_6
    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuffer;->length()I

    move-result v2

    if-lez v2, :cond_7

    .line 120
    const/16 v2, 0x2e

    move-object/from16 v0, v20

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 121
    :cond_7
    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lgnu/expr/Compilation;->mangleNameIfNeeded(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v20

    invoke-virtual {v0, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_2

    .line 126
    .end local v9    # "car":Ljava/lang/Object;
    .end local v10    # "cdr":Ljava/lang/Object;
    :cond_8
    const/4 v3, 0x0

    .line 127
    .local v3, "minfo":Lgnu/expr/ModuleInfo;
    if-eqz v21, :cond_9

    .line 129
    move-object/from16 v0, v21

    move-object/from16 v1, p3

    invoke-static {v0, v1}, Lkawa/standard/require;->lookupModuleFromSourcePath(Ljava/lang/String;Lgnu/expr/ScopeExp;)Lgnu/expr/ModuleInfo;

    move-result-object v3

    .line 130
    if-nez v3, :cond_9

    .line 132
    const/16 v2, 0x65

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "malformed URL: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v21

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 133
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 136
    :cond_9
    invoke-virtual/range {v20 .. v20}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v17

    .line 138
    .local v17, "lname":Ljava/lang/String;
    const-string v2, "srfi."

    move-object/from16 v0, v17

    invoke-virtual {v0, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_14

    .line 140
    const/4 v2, 0x5

    move-object/from16 v0, v17

    invoke-virtual {v0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lgnu/expr/Compilation;->demangleName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 141
    .local v12, "demangled":Ljava/lang/String;
    const/16 v2, 0x2e

    invoke-virtual {v12, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v13

    .line 143
    .local v13, "dot":I
    if-gez v13, :cond_c

    .line 145
    const/16 v24, 0x0

    .line 146
    .local v24, "srfiName":Ljava/lang/String;
    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v13

    .line 150
    :goto_3
    const/16 v26, 0x0

    .line 151
    .local v26, "srfiNumber":Ljava/lang/String;
    const/4 v2, 0x2

    if-ge v13, v2, :cond_a

    const/4 v2, 0x0

    invoke-virtual {v12, v2}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v5, 0x3a

    if-ne v2, v5, :cond_b

    .line 153
    :cond_a
    const/4 v15, 0x1

    .line 155
    .local v15, "i":I
    :goto_4
    if-ne v15, v13, :cond_d

    .line 157
    const/4 v2, 0x1

    invoke-virtual {v12, v2, v13}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v26

    .line 164
    .end local v15    # "i":I
    :cond_b
    if-nez v26, :cond_e

    .line 166
    const/16 v2, 0x65

    const-string v5, "SRFI library reference must have the form: (srfi :NNN [name])"

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 167
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 149
    .end local v24    # "srfiName":Ljava/lang/String;
    .end local v26    # "srfiNumber":Ljava/lang/String;
    :cond_c
    add-int/lit8 v2, v13, 0x1

    invoke-virtual {v12, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v24

    .restart local v24    # "srfiName":Ljava/lang/String;
    goto :goto_3

    .line 160
    .restart local v15    # "i":I
    .restart local v26    # "srfiNumber":Ljava/lang/String;
    :cond_d
    invoke-virtual {v12, v15}, Ljava/lang/String;->charAt(I)C

    move-result v2

    const/16 v5, 0xa

    invoke-static {v2, v5}, Ljava/lang/Character;->digit(CI)I

    move-result v2

    if-ltz v2, :cond_b

    .line 153
    add-int/lit8 v15, v15, 0x1

    goto :goto_4

    .line 169
    .end local v15    # "i":I
    :cond_e
    sget-object v2, Lkawa/standard/ImportFromLibrary;->SRFI97Map:[[Ljava/lang/String;

    array-length v0, v2

    move/from16 v23, v0

    .line 172
    .local v23, "srfiIndex":I
    :cond_f
    add-int/lit8 v23, v23, -0x1

    if-gez v23, :cond_10

    .line 174
    const/16 v2, 0x65

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "unknown SRFI number \'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\' in SRFI library reference"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 175
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 177
    :cond_10
    sget-object v2, Lkawa/standard/ImportFromLibrary;->SRFI97Map:[[Ljava/lang/String;

    aget-object v2, v2, v23

    const/4 v5, 0x0

    aget-object v2, v2, v5

    move-object/from16 v0, v26

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_f

    .line 180
    sget-object v2, Lkawa/standard/ImportFromLibrary;->SRFI97Map:[[Ljava/lang/String;

    aget-object v2, v2, v23

    const/4 v5, 0x1

    aget-object v25, v2, v5

    .line 181
    .local v25, "srfiNameExpected":Ljava/lang/String;
    sget-object v2, Lkawa/standard/ImportFromLibrary;->SRFI97Map:[[Ljava/lang/String;

    aget-object v2, v2, v23

    const/4 v5, 0x2

    aget-object v22, v2, v5

    .line 182
    .local v22, "srfiClass":Ljava/lang/String;
    if-eqz v24, :cond_11

    invoke-virtual/range {v24 .. v25}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_11

    .line 184
    const/16 v2, 0x77

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "the name of SRFI "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " should be \'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v25

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v6, 0x27

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 187
    :cond_11
    const-string v2, ""

    move-object/from16 v0, v22

    if-ne v0, v2, :cond_12

    .line 188
    const/4 v2, 0x1

    goto/16 :goto_0

    .line 189
    :cond_12
    sget-object v2, Lkawa/standard/ImportFromLibrary;->MISSING:Ljava/lang/String;

    move-object/from16 v0, v22

    if-ne v0, v2, :cond_13

    .line 191
    const/16 v2, 0x65

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "sorry - Kawa does not support SRFI "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " ("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v25

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v6, 0x29

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 192
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 195
    :cond_13
    move-object/from16 v17, v22

    .line 198
    .end local v12    # "demangled":Ljava/lang/String;
    .end local v13    # "dot":I
    .end local v22    # "srfiClass":Ljava/lang/String;
    .end local v23    # "srfiIndex":I
    .end local v24    # "srfiName":Ljava/lang/String;
    .end local v25    # "srfiNameExpected":Ljava/lang/String;
    .end local v26    # "srfiNumber":Ljava/lang/String;
    :cond_14
    move-object/from16 v0, p0

    iget-object v2, v0, Lkawa/standard/ImportFromLibrary;->classPrefixPath:[Ljava/lang/String;

    array-length v11, v2

    .line 199
    .local v11, "classPrefixPathLength":I
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_5
    if-ge v15, v11, :cond_15

    .line 201
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v5, v0, Lkawa/standard/ImportFromLibrary;->classPrefixPath:[Ljava/lang/String;

    aget-object v5, v5, v15

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, v17

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v27

    .line 204
    .local v27, "tname":Ljava/lang/String;
    :try_start_0
    invoke-static {}, Lgnu/expr/ModuleManager;->getInstance()Lgnu/expr/ModuleManager;

    move-result-object v2

    move-object/from16 v0, v27

    invoke-virtual {v2, v0}, Lgnu/expr/ModuleManager;->findWithClassName(Ljava/lang/String;)Lgnu/expr/ModuleInfo;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 199
    :goto_6
    add-int/lit8 v15, v15, 0x1

    goto :goto_5

    .line 206
    :catch_0
    move-exception v14

    .line 208
    .local v14, "ex":Ljava/lang/Exception;
    goto :goto_6

    .line 211
    .end local v14    # "ex":Ljava/lang/Exception;
    .end local v27    # "tname":Ljava/lang/String;
    :cond_15
    if-nez v3, :cond_16

    .line 213
    const/16 v2, 0x65

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "unknown class "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p4

    invoke-virtual {v0, v2, v5}, Lkawa/lang/Translator;->error(CLjava/lang/String;)V

    .line 214
    const/4 v2, 0x0

    goto/16 :goto_0

    .line 216
    :cond_16
    const/4 v2, 0x0

    move-object/from16 v5, p2

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    invoke-static/range {v2 .. v7}, Lkawa/standard/require;->importDefinitions(Ljava/lang/String;Lgnu/expr/ModuleInfo;Lgnu/mapping/Procedure;Ljava/util/Vector;Lgnu/expr/ScopeExp;Lgnu/expr/Compilation;)Z

    .line 218
    const/4 v2, 0x1

    goto/16 :goto_0
.end method
