.class public Lgnu/kawa/slib/printf;
.super Lgnu/expr/ModuleBody;
.source "printf.scm"


# static fields
.field public static final $instance:Lgnu/kawa/slib/printf;

.field static final Lit0:Lgnu/math/IntNum;

.field static final Lit1:Lgnu/math/IntNum;

.field static final Lit10:Lgnu/lists/PairWithPosition;

.field static final Lit11:Lgnu/text/Char;

.field static final Lit12:Lgnu/text/Char;

.field static final Lit13:Lgnu/text/Char;

.field static final Lit14:Lgnu/math/IntNum;

.field static final Lit15:Lgnu/math/IntNum;

.field static final Lit16:Lgnu/math/IntNum;

.field static final Lit17:Lgnu/math/IntNum;

.field static final Lit18:Lgnu/text/Char;

.field static final Lit19:Lgnu/text/Char;

.field static final Lit2:Lgnu/lists/PairWithPosition;

.field static final Lit20:Lgnu/text/Char;

.field static final Lit21:Lgnu/text/Char;

.field static final Lit22:Lgnu/text/Char;

.field static final Lit23:Lgnu/text/Char;

.field static final Lit24:Lgnu/text/Char;

.field static final Lit25:Lgnu/text/Char;

.field static final Lit26:Lgnu/text/Char;

.field static final Lit27:Lgnu/text/Char;

.field static final Lit28:Lgnu/text/Char;

.field static final Lit29:Lgnu/text/Char;

.field static final Lit3:Lgnu/text/Char;

.field static final Lit30:Lgnu/text/Char;

.field static final Lit31:Lgnu/text/Char;

.field static final Lit32:Lgnu/text/Char;

.field static final Lit33:Lgnu/lists/PairWithPosition;

.field static final Lit34:Lgnu/mapping/SimpleSymbol;

.field static final Lit35:Lgnu/text/Char;

.field static final Lit36:Lgnu/text/Char;

.field static final Lit37:Lgnu/text/Char;

.field static final Lit38:Lgnu/text/Char;

.field static final Lit39:Lgnu/text/Char;

.field static final Lit4:Lgnu/text/Char;

.field static final Lit40:Lgnu/text/Char;

.field static final Lit41:Lgnu/text/Char;

.field static final Lit42:Lgnu/text/Char;

.field static final Lit43:Lgnu/text/Char;

.field static final Lit44:Lgnu/text/Char;

.field static final Lit45:Lgnu/math/IntNum;

.field static final Lit46:Lgnu/text/Char;

.field static final Lit47:Lgnu/text/Char;

.field static final Lit48:Lgnu/math/IntNum;

.field static final Lit49:Lgnu/text/Char;

.field static final Lit5:Lgnu/text/Char;

.field static final Lit50:Lgnu/math/IntNum;

.field static final Lit51:Lgnu/text/Char;

.field static final Lit52:Lgnu/text/Char;

.field static final Lit53:Lgnu/text/Char;

.field static final Lit54:Lgnu/text/Char;

.field static final Lit55:Lgnu/text/Char;

.field static final Lit56:Lgnu/text/Char;

.field static final Lit57:Lgnu/text/Char;

.field static final Lit58:Lgnu/text/Char;

.field static final Lit59:Lgnu/math/IntNum;

.field static final Lit6:Lgnu/text/Char;

.field static final Lit60:Lgnu/math/IntNum;

.field static final Lit61:Lgnu/math/IntNum;

.field static final Lit62:Lgnu/lists/FVector;

.field static final Lit63:Lgnu/lists/PairWithPosition;

.field static final Lit64:Lgnu/mapping/SimpleSymbol;

.field static final Lit65:Lgnu/text/Char;

.field static final Lit66:Lgnu/text/Char;

.field static final Lit67:Lgnu/mapping/SimpleSymbol;

.field static final Lit68:Lgnu/mapping/SimpleSymbol;

.field static final Lit69:Lgnu/mapping/SimpleSymbol;

.field static final Lit7:Lgnu/math/IntNum;

.field static final Lit70:Lgnu/mapping/SimpleSymbol;

.field static final Lit71:Lgnu/mapping/SimpleSymbol;

.field static final Lit72:Lgnu/mapping/SimpleSymbol;

.field static final Lit8:Lgnu/text/Char;

.field static final Lit9:Lgnu/text/Char;

.field public static final fprintf:Lgnu/expr/ModuleMethod;

.field public static final printf:Lgnu/expr/ModuleMethod;

.field public static final sprintf:Lgnu/expr/ModuleMethod;

.field public static final stdio$Clhex$Mnupper$Mncase$Qu:Z

.field public static final stdio$Cliprintf:Lgnu/expr/ModuleMethod;

.field public static final stdio$Clparse$Mnfloat:Lgnu/expr/ModuleMethod;

.field public static final stdio$Clround$Mnstring:Lgnu/expr/ModuleMethod;


# direct methods
.method public static constructor <clinit>()V
    .locals 16

    new-instance v0, Lgnu/mapping/SimpleSymbol;

    const-string v1, "fprintf"

    invoke-direct {v0, v1}, Lgnu/mapping/SimpleSymbol;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lgnu/mapping/SimpleSymbol;->readResolve()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/SimpleSymbol;

    sput-object v0, Lgnu/kawa/slib/printf;->Lit72:Lgnu/mapping/SimpleSymbol;

    new-instance v0, Lgnu/mapping/SimpleSymbol;

    const-string v1, "stdio:iprintf"

    invoke-direct {v0, v1}, Lgnu/mapping/SimpleSymbol;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lgnu/mapping/SimpleSymbol;->readResolve()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/SimpleSymbol;

    sput-object v0, Lgnu/kawa/slib/printf;->Lit71:Lgnu/mapping/SimpleSymbol;

    new-instance v0, Lgnu/mapping/SimpleSymbol;

    const-string v1, "stdio:round-string"

    invoke-direct {v0, v1}, Lgnu/mapping/SimpleSymbol;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lgnu/mapping/SimpleSymbol;->readResolve()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/SimpleSymbol;

    sput-object v0, Lgnu/kawa/slib/printf;->Lit70:Lgnu/mapping/SimpleSymbol;

    new-instance v0, Lgnu/mapping/SimpleSymbol;

    const-string v1, "stdio:parse-float"

    invoke-direct {v0, v1}, Lgnu/mapping/SimpleSymbol;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lgnu/mapping/SimpleSymbol;->readResolve()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/SimpleSymbol;

    sput-object v0, Lgnu/kawa/slib/printf;->Lit69:Lgnu/mapping/SimpleSymbol;

    new-instance v0, Lgnu/mapping/SimpleSymbol;

    const-string v1, "sprintf"

    invoke-direct {v0, v1}, Lgnu/mapping/SimpleSymbol;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lgnu/mapping/SimpleSymbol;->readResolve()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/SimpleSymbol;

    sput-object v0, Lgnu/kawa/slib/printf;->Lit68:Lgnu/mapping/SimpleSymbol;

    new-instance v0, Lgnu/mapping/SimpleSymbol;

    const-string v1, "pad"

    invoke-direct {v0, v1}, Lgnu/mapping/SimpleSymbol;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lgnu/mapping/SimpleSymbol;->readResolve()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/SimpleSymbol;

    sput-object v0, Lgnu/kawa/slib/printf;->Lit67:Lgnu/mapping/SimpleSymbol;

    const/16 v0, 0x2a

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit66:Lgnu/text/Char;

    const/16 v0, 0x3f

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit65:Lgnu/text/Char;

    new-instance v0, Lgnu/mapping/SimpleSymbol;

    const-string v1, "format-real"

    invoke-direct {v0, v1}, Lgnu/mapping/SimpleSymbol;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lgnu/mapping/SimpleSymbol;->readResolve()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/SimpleSymbol;

    sput-object v0, Lgnu/kawa/slib/printf;->Lit64:Lgnu/mapping/SimpleSymbol;

    const-string v0, "i"

    sget-object v1, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    const-string v2, "printf.scm"

    const v3, 0x18f00b

    invoke-static {v0, v1, v2, v3}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit63:Lgnu/lists/PairWithPosition;

    const/16 v0, 0x11

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    const-string v2, "y"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "z"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "a"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "f"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "p"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "n"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "u"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "m"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, ""

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "k"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "M"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "G"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "T"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "P"

    aput-object v2, v0, v1

    const/16 v1, 0xe

    const-string v2, "E"

    aput-object v2, v0, v1

    const/16 v1, 0xf

    const-string v2, "Z"

    aput-object v2, v0, v1

    const/16 v1, 0x10

    const-string v2, "Y"

    aput-object v2, v0, v1

    invoke-static {v0}, Lgnu/lists/FVector;->make([Ljava/lang/Object;)Lgnu/lists/FVector;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit62:Lgnu/lists/FVector;

    const/4 v0, 0x3

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit61:Lgnu/math/IntNum;

    const/16 v0, -0xa

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit60:Lgnu/math/IntNum;

    const/4 v0, 0x6

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit59:Lgnu/math/IntNum;

    const/16 v0, 0x4b

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit58:Lgnu/text/Char;

    const/16 v0, 0x6b

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit57:Lgnu/text/Char;

    const/16 v0, 0x47

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit56:Lgnu/text/Char;

    const/16 v0, 0x67

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit55:Lgnu/text/Char;

    const/16 v0, 0x45

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit54:Lgnu/text/Char;

    const/16 v0, 0x42

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit53:Lgnu/text/Char;

    const/16 v0, 0x62

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit52:Lgnu/text/Char;

    const/16 v0, 0x58

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit51:Lgnu/text/Char;

    const/16 v0, 0x10

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit50:Lgnu/math/IntNum;

    const/16 v0, 0x78

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit49:Lgnu/text/Char;

    const/16 v0, 0x8

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit48:Lgnu/math/IntNum;

    const/16 v0, 0x4f

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit47:Lgnu/text/Char;

    const/16 v0, 0x6f

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit46:Lgnu/text/Char;

    const/16 v0, 0xa

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit45:Lgnu/math/IntNum;

    const/16 v0, 0x55

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit44:Lgnu/text/Char;

    const/16 v0, 0x75

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit43:Lgnu/text/Char;

    const/16 v0, 0x49

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit42:Lgnu/text/Char;

    const/16 v0, 0x44

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit41:Lgnu/text/Char;

    const/16 v0, 0x41

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit40:Lgnu/text/Char;

    const/16 v0, 0x61

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit39:Lgnu/text/Char;

    const/16 v0, 0x53

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit38:Lgnu/text/Char;

    const/16 v0, 0x73

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit37:Lgnu/text/Char;

    const/16 v0, 0x43

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit36:Lgnu/text/Char;

    const/16 v0, 0x63

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit35:Lgnu/text/Char;

    new-instance v0, Lgnu/mapping/SimpleSymbol;

    const-string v1, "printf"

    invoke-direct {v0, v1}, Lgnu/mapping/SimpleSymbol;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lgnu/mapping/SimpleSymbol;->readResolve()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lgnu/mapping/SimpleSymbol;

    sput-object v0, Lgnu/kawa/slib/printf;->Lit34:Lgnu/mapping/SimpleSymbol;

    sget-object v0, Lgnu/kawa/slib/printf;->Lit35:Lgnu/text/Char;

    sget-object v1, Lgnu/kawa/slib/printf;->Lit37:Lgnu/text/Char;

    sget-object v2, Lgnu/kawa/slib/printf;->Lit39:Lgnu/text/Char;

    const/16 v3, 0x64

    invoke-static {v3}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v3

    sput-object v3, Lgnu/kawa/slib/printf;->Lit12:Lgnu/text/Char;

    const/16 v4, 0x69

    invoke-static {v4}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v4

    sput-object v4, Lgnu/kawa/slib/printf;->Lit3:Lgnu/text/Char;

    sget-object v5, Lgnu/kawa/slib/printf;->Lit43:Lgnu/text/Char;

    sget-object v6, Lgnu/kawa/slib/printf;->Lit46:Lgnu/text/Char;

    sget-object v7, Lgnu/kawa/slib/printf;->Lit49:Lgnu/text/Char;

    sget-object v8, Lgnu/kawa/slib/printf;->Lit52:Lgnu/text/Char;

    const/16 v9, 0x66

    invoke-static {v9}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v9

    sput-object v9, Lgnu/kawa/slib/printf;->Lit25:Lgnu/text/Char;

    const/16 v10, 0x65

    invoke-static {v10}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v10

    sput-object v10, Lgnu/kawa/slib/printf;->Lit13:Lgnu/text/Char;

    sget-object v11, Lgnu/kawa/slib/printf;->Lit55:Lgnu/text/Char;

    sget-object v12, Lgnu/kawa/slib/printf;->Lit57:Lgnu/text/Char;

    sget-object v13, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    const-string v14, "printf.scm"

    const v15, 0x1b3014

    invoke-static {v12, v13, v14, v15}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v12

    const-string v13, "printf.scm"

    const v14, 0x1b3010

    invoke-static {v11, v12, v13, v14}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v11

    const-string v12, "printf.scm"

    const v13, 0x1b300c

    invoke-static {v10, v11, v12, v13}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v10

    const-string v11, "printf.scm"

    const v12, 0x1b3008

    invoke-static {v9, v10, v11, v12}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v9

    const-string v10, "printf.scm"

    const v11, 0x1b2028

    invoke-static {v8, v9, v10, v11}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v8

    const-string v9, "printf.scm"

    const v10, 0x1b2024

    invoke-static {v7, v8, v9, v10}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v7

    const-string v8, "printf.scm"

    const v9, 0x1b2020

    invoke-static {v6, v7, v8, v9}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v6

    const-string v7, "printf.scm"

    const v8, 0x1b201c

    invoke-static {v5, v6, v7, v8}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v5

    const-string v6, "printf.scm"

    const v7, 0x1b2018

    invoke-static {v4, v5, v6, v7}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v4

    const-string v5, "printf.scm"

    const v6, 0x1b2014

    invoke-static {v3, v4, v5, v6}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v3

    const-string v4, "printf.scm"

    const v5, 0x1b2010

    invoke-static {v2, v3, v4, v5}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v2

    const-string v3, "printf.scm"

    const v4, 0x1b200c

    invoke-static {v1, v2, v3, v4}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v1

    const-string v2, "printf.scm"

    const v3, 0x1b2007

    invoke-static {v0, v1, v2, v3}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit33:Lgnu/lists/PairWithPosition;

    const/16 v0, 0x68

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit32:Lgnu/text/Char;

    const/16 v0, 0x4c

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit31:Lgnu/text/Char;

    const/16 v0, 0x6c

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit30:Lgnu/text/Char;

    const/16 v0, 0x20

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit29:Lgnu/text/Char;

    const/16 v0, 0x25

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit28:Lgnu/text/Char;

    const/16 v0, 0xc

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit27:Lgnu/text/Char;

    const/16 v0, 0x46

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit26:Lgnu/text/Char;

    const/16 v0, 0x9

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit24:Lgnu/text/Char;

    const/16 v0, 0x54

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit23:Lgnu/text/Char;

    const/16 v0, 0x74

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit22:Lgnu/text/Char;

    const/16 v0, 0xa

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit21:Lgnu/text/Char;

    const/16 v0, 0x4e

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit20:Lgnu/text/Char;

    const/16 v0, 0x6e

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit19:Lgnu/text/Char;

    const/16 v0, 0x5c

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit18:Lgnu/text/Char;

    const/4 v0, -0x1

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit17:Lgnu/math/IntNum;

    const/16 v0, 0x9

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit16:Lgnu/math/IntNum;

    const/4 v0, 0x5

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit15:Lgnu/math/IntNum;

    const/4 v0, 0x2

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit14:Lgnu/math/IntNum;

    const/16 v0, 0x2e

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit11:Lgnu/text/Char;

    sget-object v0, Lgnu/kawa/slib/printf;->Lit13:Lgnu/text/Char;

    sget-object v1, Lgnu/kawa/slib/printf;->Lit37:Lgnu/text/Char;

    sget-object v2, Lgnu/kawa/slib/printf;->Lit25:Lgnu/text/Char;

    sget-object v3, Lgnu/kawa/slib/printf;->Lit12:Lgnu/text/Char;

    sget-object v4, Lgnu/kawa/slib/printf;->Lit30:Lgnu/text/Char;

    sget-object v5, Lgnu/kawa/slib/printf;->Lit54:Lgnu/text/Char;

    sget-object v6, Lgnu/kawa/slib/printf;->Lit38:Lgnu/text/Char;

    sget-object v7, Lgnu/kawa/slib/printf;->Lit26:Lgnu/text/Char;

    sget-object v8, Lgnu/kawa/slib/printf;->Lit41:Lgnu/text/Char;

    sget-object v9, Lgnu/kawa/slib/printf;->Lit31:Lgnu/text/Char;

    sget-object v10, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    const-string v11, "printf.scm"

    const v12, 0x4102c

    invoke-static {v9, v10, v11, v12}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v9

    const-string v10, "printf.scm"

    const v11, 0x41028

    invoke-static {v8, v9, v10, v11}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v8

    const-string v9, "printf.scm"

    const v10, 0x41024

    invoke-static {v7, v8, v9, v10}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v7

    const-string v8, "printf.scm"

    const v9, 0x41020

    invoke-static {v6, v7, v8, v9}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v6

    const-string v7, "printf.scm"

    const v8, 0x4101c

    invoke-static {v5, v6, v7, v8}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v5

    const-string v6, "printf.scm"

    const v7, 0x41018

    invoke-static {v4, v5, v6, v7}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v4

    const-string v5, "printf.scm"

    const v6, 0x41014

    invoke-static {v3, v4, v5, v6}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v3

    const-string v4, "printf.scm"

    const v5, 0x41010

    invoke-static {v2, v3, v4, v5}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v2

    const-string v3, "printf.scm"

    const v4, 0x4100c

    invoke-static {v1, v2, v3, v4}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v1

    const-string v2, "printf.scm"

    const v3, 0x41007

    invoke-static {v0, v1, v2, v3}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit10:Lgnu/lists/PairWithPosition;

    const/16 v0, 0x30

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit9:Lgnu/text/Char;

    const/16 v0, 0x23

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit8:Lgnu/text/Char;

    const/4 v0, 0x1

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    const/16 v0, 0x2b

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit6:Lgnu/text/Char;

    const/16 v0, 0x2d

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit5:Lgnu/text/Char;

    const/16 v0, 0x40

    invoke-static {v0}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit4:Lgnu/text/Char;

    sget-object v0, Lgnu/kawa/slib/printf;->Lit6:Lgnu/text/Char;

    sget-object v1, Lgnu/kawa/slib/printf;->Lit5:Lgnu/text/Char;

    sget-object v2, Lgnu/lists/LList;->Empty:Lgnu/lists/LList;

    const-string v3, "printf.scm"

    const v4, 0x6d027

    invoke-static {v1, v2, v3, v4}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v1

    const-string v2, "printf.scm"

    const v3, 0x6d022

    invoke-static {v0, v1, v2, v3}, Lgnu/lists/PairWithPosition;->make(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;I)Lgnu/lists/PairWithPosition;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit2:Lgnu/lists/PairWithPosition;

    const/4 v0, 0x0

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit1:Lgnu/math/IntNum;

    const/16 v0, -0xf

    invoke-static {v0}, Lgnu/math/IntNum;->make(I)Lgnu/math/IntNum;

    move-result-object v0

    sput-object v0, Lgnu/kawa/slib/printf;->Lit0:Lgnu/math/IntNum;

    new-instance v0, Lgnu/kawa/slib/printf;

    invoke-direct {v0}, Lgnu/kawa/slib/printf;-><init>()V

    sput-object v0, Lgnu/kawa/slib/printf;->$instance:Lgnu/kawa/slib/printf;

    new-instance v0, Lgnu/expr/ModuleMethod;

    sget-object v1, Lgnu/kawa/slib/printf;->$instance:Lgnu/kawa/slib/printf;

    const/16 v2, 0x16

    sget-object v3, Lgnu/kawa/slib/printf;->Lit69:Lgnu/mapping/SimpleSymbol;

    const/16 v4, 0x2002

    invoke-direct {v0, v1, v2, v3, v4}, Lgnu/expr/ModuleMethod;-><init>(Lgnu/expr/ModuleBody;ILjava/lang/Object;I)V

    sput-object v0, Lgnu/kawa/slib/printf;->stdio$Clparse$Mnfloat:Lgnu/expr/ModuleMethod;

    new-instance v0, Lgnu/expr/ModuleMethod;

    const/16 v2, 0x17

    sget-object v3, Lgnu/kawa/slib/printf;->Lit70:Lgnu/mapping/SimpleSymbol;

    const/16 v4, 0x3003

    invoke-direct {v0, v1, v2, v3, v4}, Lgnu/expr/ModuleMethod;-><init>(Lgnu/expr/ModuleBody;ILjava/lang/Object;I)V

    sput-object v0, Lgnu/kawa/slib/printf;->stdio$Clround$Mnstring:Lgnu/expr/ModuleMethod;

    new-instance v0, Lgnu/expr/ModuleMethod;

    const/16 v2, 0x18

    sget-object v3, Lgnu/kawa/slib/printf;->Lit71:Lgnu/mapping/SimpleSymbol;

    const/16 v4, -0xffe

    invoke-direct {v0, v1, v2, v3, v4}, Lgnu/expr/ModuleMethod;-><init>(Lgnu/expr/ModuleBody;ILjava/lang/Object;I)V

    sput-object v0, Lgnu/kawa/slib/printf;->stdio$Cliprintf:Lgnu/expr/ModuleMethod;

    new-instance v0, Lgnu/expr/ModuleMethod;

    const/16 v2, 0x19

    sget-object v3, Lgnu/kawa/slib/printf;->Lit72:Lgnu/mapping/SimpleSymbol;

    const/16 v4, -0xffe

    invoke-direct {v0, v1, v2, v3, v4}, Lgnu/expr/ModuleMethod;-><init>(Lgnu/expr/ModuleBody;ILjava/lang/Object;I)V

    sput-object v0, Lgnu/kawa/slib/printf;->fprintf:Lgnu/expr/ModuleMethod;

    new-instance v0, Lgnu/expr/ModuleMethod;

    const/16 v2, 0x1a

    sget-object v3, Lgnu/kawa/slib/printf;->Lit34:Lgnu/mapping/SimpleSymbol;

    const/16 v4, -0xfff

    invoke-direct {v0, v1, v2, v3, v4}, Lgnu/expr/ModuleMethod;-><init>(Lgnu/expr/ModuleBody;ILjava/lang/Object;I)V

    sput-object v0, Lgnu/kawa/slib/printf;->printf:Lgnu/expr/ModuleMethod;

    new-instance v0, Lgnu/expr/ModuleMethod;

    const/16 v2, 0x1b

    sget-object v3, Lgnu/kawa/slib/printf;->Lit68:Lgnu/mapping/SimpleSymbol;

    const/16 v4, -0xffe

    invoke-direct {v0, v1, v2, v3, v4}, Lgnu/expr/ModuleMethod;-><init>(Lgnu/expr/ModuleBody;ILjava/lang/Object;I)V

    sput-object v0, Lgnu/kawa/slib/printf;->sprintf:Lgnu/expr/ModuleMethod;

    sget-object v0, Lgnu/kawa/slib/printf;->$instance:Lgnu/kawa/slib/printf;

    invoke-virtual {v0}, Lgnu/expr/ModuleBody;->run()V

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lgnu/expr/ModuleBody;-><init>()V

    invoke-static {p0}, Lgnu/expr/ModuleInfo;->register(Ljava/lang/Object;)V

    return-void
.end method

.method public static fprintf$V(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .param p0, "port"    # Ljava/lang/Object;
    .param p1, "format"    # Ljava/lang/Object;
    .param p2, "argsArray"    # [Ljava/lang/Object;

    .prologue
    .line 543
    new-instance v1, Lgnu/kawa/slib/printf$frame12;

    invoke-direct {v1}, Lgnu/kawa/slib/printf$frame12;-><init>()V

    iput-object p0, v1, Lgnu/kawa/slib/printf$frame12;->port:Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p2, v2}, Lgnu/lists/LList;->makeList([Ljava/lang/Object;I)Lgnu/lists/LList;

    move-result-object v0

    .line 544
    .local v0, "args":Lgnu/lists/LList;
    sget-object v2, Lgnu/kawa/slib/printf;->Lit1:Lgnu/math/IntNum;

    iput-object v2, v1, Lgnu/kawa/slib/printf$frame12;->cnt:Ljava/lang/Object;

    .line 545
    sget-object v2, Lkawa/standard/Scheme;->apply:Lgnu/kawa/functions/Apply;

    sget-object v3, Lgnu/kawa/slib/printf;->stdio$Cliprintf:Lgnu/expr/ModuleMethod;

    .line 546
    iget-object v4, v1, Lgnu/kawa/slib/printf$frame12;->lambda$Fn18:Lgnu/expr/ModuleMethod;

    .line 550
    invoke-virtual {v2, v3, v4, p1, v0}, Lgnu/mapping/Procedure;->apply4(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 551
    iget-object v1, v1, Lgnu/kawa/slib/printf$frame12;->cnt:Ljava/lang/Object;

    return-object v1
.end method

.method public static printf$V(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .param p0, "format"    # Ljava/lang/Object;
    .param p1, "argsArray"    # [Ljava/lang/Object;

    .prologue
    .line 553
    const/4 v1, 0x0

    invoke-static {p1, v1}, Lgnu/lists/LList;->makeList([Ljava/lang/Object;I)Lgnu/lists/LList;

    move-result-object v0

    .line 554
    .local v0, "args":Lgnu/lists/LList;
    sget-object v1, Lkawa/standard/Scheme;->apply:Lgnu/kawa/functions/Apply;

    sget-object v2, Lgnu/kawa/slib/printf;->fprintf:Lgnu/expr/ModuleMethod;

    sget-object v3, Lkawa/lib/ports;->current$Mnoutput$Mnport:Lgnu/mapping/LocationProc;

    invoke-virtual {v3}, Lgnu/mapping/Procedure;->apply0()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v2, v3, p0, v0}, Lgnu/mapping/Procedure;->apply4(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method public static sprintf$V(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 8
    .param p0, "str"    # Ljava/lang/Object;
    .param p1, "format"    # Ljava/lang/Object;
    .param p2, "argsArray"    # [Ljava/lang/Object;

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 556
    new-instance v4, Lgnu/kawa/slib/printf$frame13;

    invoke-direct {v4}, Lgnu/kawa/slib/printf$frame13;-><init>()V

    iput-object p0, v4, Lgnu/kawa/slib/printf$frame13;->str:Ljava/lang/Object;

    invoke-static {p2, v7}, Lgnu/lists/LList;->makeList([Ljava/lang/Object;I)Lgnu/lists/LList;

    move-result-object v1

    .line 557
    .local v1, "args":Lgnu/lists/LList;
    sget-object v2, Lgnu/kawa/slib/printf;->Lit1:Lgnu/math/IntNum;

    iput-object v2, v4, Lgnu/kawa/slib/printf$frame13;->cnt:Ljava/lang/Object;

    .line 558
    iget-object v2, v4, Lgnu/kawa/slib/printf$frame13;->str:Ljava/lang/Object;

    invoke-static {v2}, Lkawa/lib/strings;->isString(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, v4, Lgnu/kawa/slib/printf$frame13;->str:Ljava/lang/Object;

    .line 561
    :goto_0
    iput-object v2, v4, Lgnu/kawa/slib/printf$frame13;->s:Ljava/lang/Object;

    .line 557
    iget-object v2, v4, Lgnu/kawa/slib/printf$frame13;->s:Ljava/lang/Object;

    :try_start_0
    check-cast v2, Ljava/lang/CharSequence;
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_1

    invoke-static {v2}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iput-object v2, v4, Lgnu/kawa/slib/printf$frame13;->end:Ljava/lang/Object;

    .line 563
    sget-object v2, Lkawa/standard/Scheme;->apply:Lgnu/kawa/functions/Apply;

    sget-object v3, Lgnu/kawa/slib/printf;->stdio$Cliprintf:Lgnu/expr/ModuleMethod;

    .line 564
    iget-object v5, v4, Lgnu/kawa/slib/printf$frame13;->lambda$Fn19:Lgnu/expr/ModuleMethod;

    .line 584
    invoke-virtual {v2, v3, v5, p1, v1}, Lgnu/mapping/Procedure;->apply4(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, v4, Lgnu/kawa/slib/printf$frame13;->str:Ljava/lang/Object;

    invoke-static {v2}, Lkawa/lib/strings;->isString(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 585
    iget-object v2, v4, Lgnu/kawa/slib/printf$frame13;->cnt:Ljava/lang/Object;

    .line 587
    :goto_1
    return-object v2

    .line 558
    :cond_0
    iget-object v2, v4, Lgnu/kawa/slib/printf$frame13;->str:Ljava/lang/Object;

    invoke-static {v2}, Lkawa/lib/numbers;->isNumber(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 559
    iget-object v3, v4, Lgnu/kawa/slib/printf$frame13;->str:Ljava/lang/Object;

    :try_start_1
    move-object v0, v3

    check-cast v0, Ljava/lang/Number;

    move-object v2, v0

    invoke-virtual {v2}, Ljava/lang/Number;->intValue()I
    :try_end_1
    .catch Ljava/lang/ClassCastException; {:try_start_1 .. :try_end_1} :catch_0

    move-result v2

    invoke-static {v2}, Lkawa/lib/strings;->makeString(I)Ljava/lang/CharSequence;

    move-result-object v2

    goto :goto_0

    :cond_1
    iget-object v2, v4, Lgnu/kawa/slib/printf$frame13;->str:Ljava/lang/Object;

    sget-object v3, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v2, v3, :cond_2

    .line 560
    const/16 v2, 0x64

    invoke-static {v2}, Lkawa/lib/strings;->makeString(I)Ljava/lang/CharSequence;

    move-result-object v2

    goto :goto_0

    .line 561
    :cond_2
    sget-object v2, Lgnu/kawa/slib/printf;->Lit68:Lgnu/mapping/SimpleSymbol;

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const-string v5, "first argument not understood"

    aput-object v5, v3, v7

    iget-object v5, v4, Lgnu/kawa/slib/printf$frame13;->str:Ljava/lang/Object;

    aput-object v5, v3, v6

    invoke-static {v2, v3}, Lkawa/lib/misc;->error$V(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    goto :goto_0

    .line 585
    :cond_3
    sget-object v2, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 586
    iget-object v3, v4, Lgnu/kawa/slib/printf$frame13;->end:Ljava/lang/Object;

    iget-object v5, v4, Lgnu/kawa/slib/printf$frame13;->cnt:Ljava/lang/Object;

    invoke-virtual {v2, v3, v5}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    sget-object v3, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v2, v3, :cond_4

    iget-object v2, v4, Lgnu/kawa/slib/printf$frame13;->s:Ljava/lang/Object;

    goto :goto_1

    .line 587
    :cond_4
    iget-object v2, v4, Lgnu/kawa/slib/printf$frame13;->s:Ljava/lang/Object;

    :try_start_2
    check-cast v2, Ljava/lang/CharSequence;
    :try_end_2
    .catch Ljava/lang/ClassCastException; {:try_start_2 .. :try_end_2} :catch_2

    iget-object v4, v4, Lgnu/kawa/slib/printf$frame13;->cnt:Ljava/lang/Object;

    :try_start_3
    move-object v0, v4

    check-cast v0, Ljava/lang/Number;

    move-object v3, v0

    invoke-virtual {v3}, Ljava/lang/Number;->intValue()I
    :try_end_3
    .catch Ljava/lang/ClassCastException; {:try_start_3 .. :try_end_3} :catch_3

    move-result v3

    invoke-static {v2, v7, v3}, Lkawa/lib/strings;->substring(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;

    move-result-object v2

    goto :goto_1

    .line 559
    :catch_0
    move-exception v2

    new-instance v4, Lgnu/mapping/WrongType;

    const-string v5, "make-string"

    invoke-direct {v4, v2, v5, v6, v3}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v4

    .line 562
    :catch_1
    move-exception v3

    new-instance v4, Lgnu/mapping/WrongType;

    const-string v5, "string-length"

    invoke-direct {v4, v3, v5, v6, v2}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v4

    .line 587
    :catch_2
    move-exception v3

    new-instance v4, Lgnu/mapping/WrongType;

    const-string v5, "substring"

    invoke-direct {v4, v3, v5, v6, v2}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v4

    :catch_3
    move-exception v2

    new-instance v3, Lgnu/mapping/WrongType;

    const-string v5, "substring"

    const/4 v6, 0x3

    invoke-direct {v3, v2, v5, v6, v4}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v3
.end method

.method public static stdio$ClIprintf$V(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 17
    .param p0, "out"    # Ljava/lang/Object;
    .param p1, "formatString"    # Ljava/lang/Object;
    .param p2, "argsArray"    # [Ljava/lang/Object;

    .prologue
    .line 186
    new-instance v2, Lgnu/kawa/slib/printf$frame9;

    invoke-direct {v2}, Lgnu/kawa/slib/printf$frame9;-><init>()V

    move-object/from16 v0, p0

    iput-object v0, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    move-object/from16 v0, p1

    iput-object v0, v2, Lgnu/kawa/slib/printf$frame9;->format$Mnstring:Ljava/lang/Object;

    const/4 v9, 0x0

    move-object/from16 v0, p2

    invoke-static {v0, v9}, Lgnu/lists/LList;->makeList([Ljava/lang/Object;I)Lgnu/lists/LList;

    move-result-object v9

    iput-object v9, v2, Lgnu/kawa/slib/printf$frame9;->args:Lgnu/lists/LList;

    .line 187
    const-string v9, ""

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->format$Mnstring:Ljava/lang/Object;

    invoke-static {v9, v10}, Lgnu/kawa/functions/IsEqual;->apply(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_5f

    .line 189
    sget-object v10, Lgnu/kawa/slib/printf;->Lit17:Lgnu/math/IntNum;

    .line 190
    iget-object v9, v2, Lgnu/kawa/slib/printf$frame9;->format$Mnstring:Ljava/lang/Object;

    :try_start_0
    check-cast v9, Ljava/lang/CharSequence;
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    invoke-static {v9}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v11

    .line 191
    iget-object v9, v2, Lgnu/kawa/slib/printf$frame9;->format$Mnstring:Ljava/lang/Object;

    :try_start_1
    check-cast v9, Ljava/lang/CharSequence;
    :try_end_1
    .catch Ljava/lang/ClassCastException; {:try_start_1 .. :try_end_1} :catch_1

    const/4 v12, 0x0

    invoke-static {v9, v12}, Lkawa/lib/strings;->stringRef(Ljava/lang/CharSequence;I)C

    move-result v9

    invoke-static {v9}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v9

    iput-object v9, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    iput v11, v2, Lgnu/kawa/slib/printf$frame9;->fl:I

    iput-object v10, v2, Lgnu/kawa/slib/printf$frame9;->pos:Ljava/lang/Object;

    .line 193
    iget-object v1, v2, Lgnu/kawa/slib/printf$frame9;->args:Lgnu/lists/LList;

    .local v2, "closureEnv":Lgnu/kawa/slib/printf$frame9;
    :goto_0
    new-instance v12, Lgnu/kawa/slib/printf$frame10;

    invoke-direct {v12}, Lgnu/kawa/slib/printf$frame10;-><init>()V

    iput-object v2, v12, Lgnu/kawa/slib/printf$frame10;->staticLink:Lgnu/kawa/slib/printf$frame9;

    iput-object v1, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    .line 217
    sget-object v9, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    iget-object v11, v2, Lgnu/kawa/slib/printf$frame9;->pos:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    iput-object v9, v2, Lgnu/kawa/slib/printf$frame9;->pos:Ljava/lang/Object;

    sget-object v9, Lkawa/standard/Scheme;->numGEq:Lgnu/kawa/functions/NumberCompare;

    .line 195
    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->pos:Ljava/lang/Object;

    iget v11, v2, Lgnu/kawa/slib/printf$frame9;->fl:I

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_1

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v9, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    .line 218
    :goto_1
    invoke-virtual {v2}, Lgnu/kawa/slib/printf$frame9;->lambda19isEndOfFormat()Z

    move-result v7

    .local v7, "x":Z
    if-eqz v7, :cond_3

    if-eqz v7, :cond_2

    sget-object v9, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    :goto_2
    move-object v7, v9

    .line 541
    .end local v2    # "closureEnv":Lgnu/kawa/slib/printf$frame9;
    .end local v7    # "x":Z
    :cond_0
    :goto_3
    return-object v7

    .line 196
    .restart local v2    # "closureEnv":Lgnu/kawa/slib/printf$frame9;
    :cond_1
    iget-object v9, v2, Lgnu/kawa/slib/printf$frame9;->format$Mnstring:Ljava/lang/Object;

    :try_start_2
    check-cast v9, Ljava/lang/CharSequence;
    :try_end_2
    .catch Ljava/lang/ClassCastException; {:try_start_2 .. :try_end_2} :catch_2

    iget-object v11, v2, Lgnu/kawa/slib/printf$frame9;->pos:Ljava/lang/Object;

    :try_start_3
    move-object v0, v11

    check-cast v0, Ljava/lang/Number;

    move-object v10, v0

    invoke-virtual {v10}, Ljava/lang/Number;->intValue()I
    :try_end_3
    .catch Ljava/lang/ClassCastException; {:try_start_3 .. :try_end_3} :catch_3

    move-result v10

    invoke-static {v9, v10}, Lkawa/lib/strings;->stringRef(Ljava/lang/CharSequence;I)C

    move-result v9

    invoke-static {v9}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v9

    iput-object v9, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    goto :goto_1

    .line 218
    .restart local v7    # "x":Z
    :cond_2
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_2

    :cond_3
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 222
    sget-object v10, Lgnu/kawa/slib/printf;->Lit18:Lgnu/text/Char;

    iget-object v11, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_f

    .line 223
    invoke-virtual {v2}, Lgnu/kawa/slib/printf$frame9;->lambda18mustAdvance()Ljava/lang/Object;

    .line 224
    iget-object v6, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    .local v6, "tmp":Ljava/lang/Object;
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit19:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .local v7, "x":Ljava/lang/Object;
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_5

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_6

    .line 225
    :cond_4
    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v11, Lgnu/kawa/slib/printf;->Lit21:Lgnu/text/Char;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    .line 224
    .end local v7    # "x":Ljava/lang/Object;
    .local v8, "x":Ljava/lang/Object;
    :goto_4
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v8, v9, :cond_e

    .line 231
    iget-object v1, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    .local v1, "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 224
    .end local v1    # "args":Ljava/lang/Object;
    .end local v8    # "x":Ljava/lang/Object;
    .restart local v7    # "x":Ljava/lang/Object;
    :cond_5
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit20:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_4

    .line 225
    :cond_6
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 224
    sget-object v10, Lgnu/kawa/slib/printf;->Lit22:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_8

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_9

    .line 226
    :cond_7
    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v11, Lgnu/kawa/slib/printf;->Lit24:Lgnu/text/Char;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    goto :goto_4

    .line 224
    :cond_8
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit23:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_7

    .line 226
    :cond_9
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 224
    sget-object v10, Lgnu/kawa/slib/printf;->Lit25:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_b

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_c

    .line 228
    :cond_a
    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v11, Lgnu/kawa/slib/printf;->Lit27:Lgnu/text/Char;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    goto :goto_4

    .line 224
    :cond_b
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit26:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_a

    .line 228
    :cond_c
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 224
    sget-object v10, Lgnu/kawa/slib/printf;->Lit21:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_d

    sget-object v8, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto :goto_4

    .line 230
    :cond_d
    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    iget-object v11, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    goto :goto_4

    .end local v7    # "x":Ljava/lang/Object;
    .restart local v8    # "x":Ljava/lang/Object;
    :cond_e
    move-object v7, v8

    .line 224
    goto/16 :goto_3

    .end local v6    # "tmp":Ljava/lang/Object;
    .end local v8    # "x":Ljava/lang/Object;
    .local v7, "x":Z
    :cond_f
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 232
    sget-object v10, Lgnu/kawa/slib/printf;->Lit28:Lgnu/text/Char;

    iget-object v11, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_5e

    .line 233
    invoke-virtual {v2}, Lgnu/kawa/slib/printf$frame9;->lambda18mustAdvance()Ljava/lang/Object;

    .line 234
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    sget-object v11, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    sget-object v13, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    sget-object v14, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    .line 239
    sget-object v15, Lgnu/kawa/slib/printf;->Lit1:Lgnu/math/IntNum;

    .line 240
    sget-object v16, Lgnu/kawa/slib/printf;->Lit17:Lgnu/math/IntNum;

    .line 243
    move-object/from16 v0, v16

    iput-object v0, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    iput-object v15, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    iput-object v14, v12, Lgnu/kawa/slib/printf$frame10;->leading$Mn0s:Ljava/lang/Object;

    iput-object v13, v12, Lgnu/kawa/slib/printf$frame10;->alternate$Mnform:Ljava/lang/Object;

    iput-object v11, v12, Lgnu/kawa/slib/printf$frame10;->blank:Ljava/lang/Object;

    iput-object v10, v12, Lgnu/kawa/slib/printf$frame10;->signed:Ljava/lang/Object;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->left$Mnadjust:Ljava/lang/Object;

    .line 256
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->pad:Lgnu/mapping/Procedure;

    .line 276
    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->pad:Lgnu/mapping/Procedure;

    .line 256
    :goto_5
    iget-object v6, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    .restart local v6    # "tmp":Ljava/lang/Object;
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit5:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_10

    .line 409
    sget-object v9, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->left$Mnadjust:Ljava/lang/Object;

    .line 415
    :goto_6
    invoke-virtual {v2}, Lgnu/kawa/slib/printf$frame9;->lambda18mustAdvance()Ljava/lang/Object;

    goto :goto_5

    .line 409
    :cond_10
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 408
    sget-object v10, Lgnu/kawa/slib/printf;->Lit6:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_11

    .line 410
    sget-object v9, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->signed:Ljava/lang/Object;

    goto :goto_6

    :cond_11
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 408
    sget-object v10, Lgnu/kawa/slib/printf;->Lit29:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_12

    .line 411
    sget-object v9, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->blank:Ljava/lang/Object;

    goto :goto_6

    :cond_12
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 408
    sget-object v10, Lgnu/kawa/slib/printf;->Lit8:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_13

    .line 412
    sget-object v9, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->alternate$Mnform:Ljava/lang/Object;

    goto :goto_6

    :cond_13
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 408
    sget-object v10, Lgnu/kawa/slib/printf;->Lit9:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_14

    .line 413
    sget-object v9, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->leading$Mn0s:Ljava/lang/Object;

    goto :goto_6

    .line 415
    :cond_14
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->left$Mnadjust:Ljava/lang/Object;

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_15

    .line 416
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->leading$Mn0s:Ljava/lang/Object;

    :cond_15
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->signed:Ljava/lang/Object;

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_16

    .line 417
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->blank:Ljava/lang/Object;

    .line 419
    :cond_16
    invoke-virtual {v12}, Lgnu/kawa/slib/printf$frame10;->lambda22readFormatNumber()Ljava/lang/Object;

    move-result-object v9

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    :try_start_4
    invoke-static {v9}, Lgnu/kawa/lispexpr/LangObjType;->coerceRealNum(Ljava/lang/Object;)Lgnu/math/RealNum;
    :try_end_4
    .catch Ljava/lang/ClassCastException; {:try_start_4 .. :try_end_4} :catch_4

    move-result-object v9

    invoke-static {v9}, Lkawa/lib/numbers;->isNegative(Lgnu/math/RealNum;)Z

    move-result v9

    if-eqz v9, :cond_17

    .line 421
    sget-object v9, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->left$Mnadjust:Ljava/lang/Object;

    .line 422
    sget-object v9, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    :cond_17
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 423
    sget-object v10, Lgnu/kawa/slib/printf;->Lit11:Lgnu/text/Char;

    iget-object v11, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_18

    .line 424
    invoke-virtual {v2}, Lgnu/kawa/slib/printf$frame9;->lambda18mustAdvance()Ljava/lang/Object;

    .line 425
    invoke-virtual {v12}, Lgnu/kawa/slib/printf$frame10;->lambda22readFormatNumber()Ljava/lang/Object;

    move-result-object v9

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    .line 426
    :cond_18
    iget-object v6, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit30:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .local v7, "x":Ljava/lang/Object;
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_1c

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_19

    .line 428
    :goto_7
    invoke-virtual {v2}, Lgnu/kawa/slib/printf$frame9;->lambda18mustAdvance()Ljava/lang/Object;

    :cond_19
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-static {v9}, Lkawa/lib/lists;->isNull(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_1a

    .line 433
    iget-object v9, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    :try_start_5
    check-cast v9, Lgnu/text/Char;
    :try_end_5
    .catch Ljava/lang/ClassCastException; {:try_start_5 .. :try_end_5} :catch_5

    invoke-static {v9}, Lkawa/lib/rnrs/unicode;->charDowncase(Lgnu/text/Char;)Lgnu/text/Char;

    move-result-object v9

    sget-object v10, Lgnu/kawa/slib/printf;->Lit33:Lgnu/lists/PairWithPosition;

    invoke-static {v9, v10}, Lkawa/lib/lists;->memv(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_1a

    .line 436
    sget-object v9, Lgnu/kawa/slib/printf;->Lit34:Lgnu/mapping/SimpleSymbol;

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string v13, "wrong number of arguments"

    aput-object v13, v10, v11

    const/4 v11, 0x1

    iget-object v13, v2, Lgnu/kawa/slib/printf$frame9;->args:Lgnu/lists/LList;

    invoke-static {v13}, Lkawa/lib/lists;->length(Lgnu/lists/LList;)I

    move-result v13

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v10, v11

    const/4 v11, 0x2

    iget-object v13, v2, Lgnu/kawa/slib/printf$frame9;->format$Mnstring:Ljava/lang/Object;

    aput-object v13, v10, v11

    invoke-static {v9, v10}, Lkawa/lib/misc;->error$V(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 438
    :cond_1a
    iget-object v6, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit35:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_1e

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_1f

    .line 441
    :cond_1b
    sget-object v11, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v13, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    instance-of v10, v9, [Ljava/lang/Object;

    if-eqz v10, :cond_22

    check-cast v9, [Ljava/lang/Object;

    :goto_8
    invoke-static {v9}, Lkawa/lib/strings;->$make$string$([Ljava/lang/Object;)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-virtual {v11, v13, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    sget-object v9, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 426
    .end local v1    # "args":Ljava/lang/Object;
    :cond_1c
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit31:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_1d

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_19

    goto/16 :goto_7

    :cond_1d
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit32:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_19

    goto/16 :goto_7

    .line 438
    :cond_1e
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit36:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_1b

    .line 441
    :cond_1f
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 438
    sget-object v10, Lgnu/kawa/slib/printf;->Lit37:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_23

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_24

    .line 445
    :cond_20
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    .line 446
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-static {v9}, Lkawa/lib/misc;->isSymbol(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_29

    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    :try_start_6
    check-cast v9, Lgnu/mapping/Symbol;
    :try_end_6
    .catch Ljava/lang/ClassCastException; {:try_start_6 .. :try_end_6} :catch_6

    invoke-static {v9}, Lkawa/lib/misc;->symbol$To$String(Lgnu/mapping/Symbol;)Ljava/lang/String;

    move-result-object v4

    .line 449
    .local v4, "s":Ljava/lang/Object;
    :goto_9
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    :try_start_7
    invoke-static {v9}, Lgnu/kawa/lispexpr/LangObjType;->coerceRealNum(Ljava/lang/Object;)Lgnu/math/RealNum;
    :try_end_7
    .catch Ljava/lang/ClassCastException; {:try_start_7 .. :try_end_7} :catch_7

    move-result-object v9

    invoke-static {v9}, Lkawa/lib/numbers;->isNegative(Lgnu/math/RealNum;)Z

    move-result v7

    .local v7, "x":Z
    if-eqz v7, :cond_2b

    if-nez v7, :cond_21

    .line 451
    :goto_a
    :try_start_8
    check-cast v4, Ljava/lang/CharSequence;
    :try_end_8
    .catch Ljava/lang/ClassCastException; {:try_start_8 .. :try_end_8} :catch_9

    .end local v4    # "s":Ljava/lang/Object;
    const/4 v11, 0x0

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    :try_start_9
    move-object v0, v10

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I
    :try_end_9
    .catch Ljava/lang/ClassCastException; {:try_start_9 .. :try_end_9} :catch_a

    move-result v9

    invoke-static {v4, v11, v9}, Lkawa/lib/strings;->substring(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;

    move-result-object v4

    .line 452
    :cond_21
    sget-object v10, Lkawa/standard/Scheme;->numLEq:Lgnu/kawa/functions/NumberCompare;

    .line 454
    iget-object v11, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    :try_start_a
    move-object v0, v4

    check-cast v0, Ljava/lang/CharSequence;

    move-object v9, v0
    :try_end_a
    .catch Ljava/lang/ClassCastException; {:try_start_a .. :try_end_a} :catch_b

    invoke-static {v9}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v10, v11, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_2c

    .line 461
    :goto_b
    invoke-virtual {v2, v4}, Lgnu/kawa/slib/printf$frame9;->lambda21out$St(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .line 452
    .local v7, "x":Ljava/lang/Object;
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    .line 463
    sget-object v9, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 441
    .end local v1    # "args":Ljava/lang/Object;
    :cond_22
    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v14, 0x0

    aput-object v9, v10, v14

    move-object v9, v10

    goto/16 :goto_8

    .line 438
    :cond_23
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit38:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_20

    .line 452
    :cond_24
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 438
    sget-object v10, Lgnu/kawa/slib/printf;->Lit39:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_2f

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_30

    .line 467
    :cond_25
    const-string v9, ""

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    iput-object v10, v12, Lgnu/kawa/slib/printf$frame10;->pr:Ljava/lang/Object;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->os:Ljava/lang/Object;

    .line 468
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    .line 469
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->alternate$Mnform:Ljava/lang/Object;

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_32

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    :goto_c
    sget-object v13, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    .line 470
    iget-object v7, v12, Lgnu/kawa/slib/printf$frame10;->left$Mnadjust:Ljava/lang/Object;

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v10, :cond_33

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->pr:Ljava/lang/Object;

    :try_start_b
    invoke-static {v10}, Lgnu/kawa/lispexpr/LangObjType;->coerceRealNum(Ljava/lang/Object;)Lgnu/math/RealNum;
    :try_end_b
    .catch Ljava/lang/ClassCastException; {:try_start_b .. :try_end_b} :catch_10

    move-result-object v10

    invoke-static {v10}, Lkawa/lib/numbers;->isNegative(Lgnu/math/RealNum;)Z

    move-result v10

    if-eqz v10, :cond_34

    .line 471
    :cond_26
    sget-object v10, Lgnu/kawa/slib/printf;->Lit1:Lgnu/math/IntNum;

    iput-object v10, v12, Lgnu/kawa/slib/printf$frame10;->pr:Ljava/lang/Object;

    .line 472
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->lambda$Fn13:Lgnu/expr/ModuleMethod;

    .line 494
    :goto_d
    invoke-static {v11, v9, v13, v10}, Lgnu/kawa/slib/genwrite;->genericWrite(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 502
    iget-object v7, v12, Lgnu/kawa/slib/printf$frame10;->left$Mnadjust:Ljava/lang/Object;

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_37

    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    :try_start_c
    invoke-static {v9}, Lgnu/kawa/lispexpr/LangObjType;->coerceRealNum(Ljava/lang/Object;)Lgnu/math/RealNum;
    :try_end_c
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_c} :catch_12

    move-result-object v9

    invoke-static {v9}, Lkawa/lib/numbers;->isNegative(Lgnu/math/RealNum;)Z

    move-result v9

    if-eqz v9, :cond_38

    .line 503
    :cond_27
    sget-object v9, Lkawa/standard/Scheme;->numGrt:Lgnu/kawa/functions/NumberCompare;

    .line 504
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    iget-object v11, v12, Lgnu/kawa/slib/printf$frame10;->pr:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_28

    sget-object v11, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v13, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v9, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    iget-object v14, v12, Lgnu/kawa/slib/printf$frame10;->pr:Ljava/lang/Object;

    invoke-virtual {v9, v10, v14}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_d
    move-object v0, v10

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I
    :try_end_d
    .catch Ljava/lang/ClassCastException; {:try_start_d .. :try_end_d} :catch_13

    move-result v9

    sget-object v10, Lgnu/kawa/slib/printf;->Lit29:Lgnu/text/Char;

    invoke-static {v9, v10}, Lkawa/lib/strings;->makeString(ILjava/lang/Object;)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-virtual {v11, v13, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 511
    .end local v7    # "x":Ljava/lang/Object;
    :cond_28
    :goto_e
    sget-object v9, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 446
    .end local v1    # "args":Ljava/lang/Object;
    .restart local v7    # "x":Ljava/lang/Object;
    :cond_29
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    .line 447
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_2a

    const-string v4, "(NULL)"

    goto/16 :goto_9

    .line 448
    :cond_2a
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    goto/16 :goto_9

    .line 449
    .restart local v4    # "s":Ljava/lang/Object;
    .local v7, "x":Z
    :cond_2b
    sget-object v10, Lkawa/standard/Scheme;->numGEq:Lgnu/kawa/functions/NumberCompare;

    .line 450
    iget-object v11, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    :try_start_e
    move-object v0, v4

    check-cast v0, Ljava/lang/CharSequence;

    move-object v9, v0
    :try_end_e
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_e} :catch_8

    invoke-static {v9}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v10, v11, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_21

    goto/16 :goto_a

    .line 454
    .end local v4    # "s":Ljava/lang/Object;
    :cond_2c
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->left$Mnadjust:Ljava/lang/Object;

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_2d

    sget-object v10, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    .line 457
    iget-object v11, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    :try_start_f
    move-object v0, v4

    check-cast v0, Ljava/lang/CharSequence;

    move-object v9, v0
    :try_end_f
    .catch Ljava/lang/ClassCastException; {:try_start_f .. :try_end_f} :catch_c

    invoke-static {v9}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v10, v11, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_10
    move-object v0, v10

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_10 .. :try_end_10} :catch_d

    move-result v9

    sget-object v10, Lgnu/kawa/slib/printf;->Lit29:Lgnu/text/Char;

    invoke-static {v9, v10}, Lkawa/lib/strings;->makeString(ILjava/lang/Object;)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-static {v4, v9}, Lgnu/lists/LList;->list2(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v4

    goto/16 :goto_b

    :cond_2d
    sget-object v10, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    .line 460
    iget-object v11, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    :try_start_11
    move-object v0, v4

    check-cast v0, Ljava/lang/CharSequence;

    move-object v9, v0
    :try_end_11
    .catch Ljava/lang/ClassCastException; {:try_start_11 .. :try_end_11} :catch_e

    invoke-static {v9}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v10, v11, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_12
    move-object v0, v10

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I
    :try_end_12
    .catch Ljava/lang/ClassCastException; {:try_start_12 .. :try_end_12} :catch_f

    move-result v10

    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->leading$Mn0s:Ljava/lang/Object;

    sget-object v11, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v11, :cond_2e

    .line 461
    sget-object v9, Lgnu/kawa/slib/printf;->Lit9:Lgnu/text/Char;

    :goto_f
    invoke-static {v10, v9}, Lkawa/lib/strings;->makeString(ILjava/lang/Object;)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-static {v9, v4}, Lgnu/lists/LList;->list2(Ljava/lang/Object;Ljava/lang/Object;)Lgnu/lists/Pair;

    move-result-object v4

    goto/16 :goto_b

    :cond_2e
    sget-object v9, Lgnu/kawa/slib/printf;->Lit29:Lgnu/text/Char;

    goto :goto_f

    .line 438
    .local v7, "x":Ljava/lang/Object;
    :cond_2f
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit40:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_25

    .line 511
    :cond_30
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 438
    sget-object v10, Lgnu/kawa/slib/printf;->Lit12:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_3c

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_3d

    .line 516
    :cond_31
    :goto_10
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Lgnu/kawa/slib/printf;->Lit45:Lgnu/math/IntNum;

    sget-object v11, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v12, v9, v10, v11}, Lgnu/kawa/slib/printf$frame10;->lambda24integerConvert(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v2, v9}, Lgnu/kawa/slib/printf$frame9;->lambda21out$St(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    .line 517
    sget-object v9, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 469
    .end local v1    # "args":Ljava/lang/Object;
    :cond_32
    sget-object v9, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    goto/16 :goto_c

    .line 470
    :cond_33
    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v7, v10, :cond_26

    .line 472
    :cond_34
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->left$Mnadjust:Ljava/lang/Object;

    sget-object v14, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v10, v14, :cond_35

    .line 476
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->lambda$Fn14:Lgnu/expr/ModuleMethod;

    goto/16 :goto_d

    :cond_35
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->pr:Ljava/lang/Object;

    :try_start_13
    invoke-static {v10}, Lgnu/kawa/lispexpr/LangObjType;->coerceRealNum(Ljava/lang/Object;)Lgnu/math/RealNum;
    :try_end_13
    .catch Ljava/lang/ClassCastException; {:try_start_13 .. :try_end_13} :catch_11

    move-result-object v10

    invoke-static {v10}, Lkawa/lib/numbers;->isNegative(Lgnu/math/RealNum;)Z

    move-result v10

    if-eqz v10, :cond_36

    .line 483
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    iput-object v10, v12, Lgnu/kawa/slib/printf$frame10;->pr:Ljava/lang/Object;

    .line 484
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->lambda$Fn15:Lgnu/expr/ModuleMethod;

    goto/16 :goto_d

    .line 494
    :cond_36
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->lambda$Fn16:Lgnu/expr/ModuleMethod;

    goto/16 :goto_d

    .line 502
    :cond_37
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v7, v9, :cond_27

    .line 504
    :cond_38
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->left$Mnadjust:Ljava/lang/Object;

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_39

    .line 506
    sget-object v9, Lkawa/standard/Scheme;->numGrt:Lgnu/kawa/functions/NumberCompare;

    .line 507
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    sget-object v11, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    iget-object v13, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    iget-object v14, v12, Lgnu/kawa/slib/printf$frame10;->pr:Ljava/lang/Object;

    invoke-virtual {v11, v13, v14}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_28

    .line 508
    sget-object v11, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v13, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v9, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    sget-object v14, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    iget-object v15, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    iget-object v0, v12, Lgnu/kawa/slib/printf$frame10;->pr:Ljava/lang/Object;

    move-object/from16 v16, v0

    invoke-virtual/range {v14 .. v16}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v14

    invoke-virtual {v9, v10, v14}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_14
    move-object v0, v10

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I
    :try_end_14
    .catch Ljava/lang/ClassCastException; {:try_start_14 .. :try_end_14} :catch_14

    move-result v9

    sget-object v10, Lgnu/kawa/slib/printf;->Lit29:Lgnu/text/Char;

    invoke-static {v9, v10}, Lkawa/lib/strings;->makeString(ILjava/lang/Object;)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-virtual {v11, v13, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_e

    .line 509
    :cond_39
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->os:Ljava/lang/Object;

    :try_start_15
    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;
    :try_end_15
    .catch Ljava/lang/ClassCastException; {:try_start_15 .. :try_end_15} :catch_15

    if-eq v9, v10, :cond_3a

    const/4 v9, 0x1

    :goto_11
    add-int/lit8 v9, v9, 0x1

    and-int/lit8 v7, v9, 0x1

    .line 502
    .local v7, "x":Z
    if-nez v7, :cond_28

    sget-object v10, Lkawa/standard/Scheme;->numLEq:Lgnu/kawa/functions/NumberCompare;

    .line 510
    iget-object v11, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->os:Ljava/lang/Object;

    :try_start_16
    check-cast v9, Ljava/lang/CharSequence;
    :try_end_16
    .catch Ljava/lang/ClassCastException; {:try_start_16 .. :try_end_16} :catch_16

    invoke-static {v9}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v10, v11, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_3b

    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    iget-object v11, v12, Lgnu/kawa/slib/printf$frame10;->os:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_e

    .line 509
    .local v7, "x":Ljava/lang/Object;
    :cond_3a
    const/4 v9, 0x0

    goto :goto_11

    .line 511
    .local v7, "x":Z
    :cond_3b
    sget-object v11, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v13, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v10, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    .line 512
    iget-object v14, v12, Lgnu/kawa/slib/printf$frame10;->width:Ljava/lang/Object;

    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->os:Ljava/lang/Object;

    :try_start_17
    check-cast v9, Ljava/lang/CharSequence;
    :try_end_17
    .catch Ljava/lang/ClassCastException; {:try_start_17 .. :try_end_17} :catch_17

    invoke-static {v9}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v10, v14, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_18
    move-object v0, v10

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I
    :try_end_18
    .catch Ljava/lang/ClassCastException; {:try_start_18 .. :try_end_18} :catch_18

    move-result v9

    sget-object v10, Lgnu/kawa/slib/printf;->Lit29:Lgnu/text/Char;

    invoke-static {v9, v10}, Lkawa/lib/strings;->makeString(ILjava/lang/Object;)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-virtual {v11, v13, v9}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .line 511
    .local v7, "x":Ljava/lang/Object;
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_28

    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    .line 513
    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    iget-object v11, v12, Lgnu/kawa/slib/printf$frame10;->os:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_e

    .line 438
    :cond_3c
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit41:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_3f

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v7, v9, :cond_31

    .line 516
    :cond_3d
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 438
    sget-object v10, Lgnu/kawa/slib/printf;->Lit46:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_43

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_44

    .line 519
    :cond_3e
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Lgnu/kawa/slib/printf;->Lit48:Lgnu/math/IntNum;

    sget-object v11, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v12, v9, v10, v11}, Lgnu/kawa/slib/printf$frame10;->lambda24integerConvert(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v2, v9}, Lgnu/kawa/slib/printf$frame9;->lambda21out$St(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    .line 520
    sget-object v9, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 438
    .end local v1    # "args":Ljava/lang/Object;
    :cond_3f
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit3:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_40

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_3d

    goto/16 :goto_10

    :cond_40
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit42:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_41

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_3d

    goto/16 :goto_10

    :cond_41
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit43:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_42

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_3d

    goto/16 :goto_10

    :cond_42
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit44:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_3d

    goto/16 :goto_10

    :cond_43
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit47:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_3e

    .line 519
    :cond_44
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 438
    sget-object v10, Lgnu/kawa/slib/printf;->Lit49:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_46

    .line 522
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    .line 523
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    sget-object v11, Lgnu/kawa/slib/printf;->Lit50:Lgnu/math/IntNum;

    sget-boolean v9, Lgnu/kawa/slib/printf;->stdio$Clhex$Mnupper$Mncase$Qu:Z

    if-eqz v9, :cond_45

    .line 524
    sget-object v9, Lkawa/lib/rnrs/unicode;->string$Mndowncase:Lgnu/expr/ModuleMethod;

    :goto_12
    invoke-virtual {v12, v10, v11, v9}, Lgnu/kawa/slib/printf$frame10;->lambda24integerConvert(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v2, v9}, Lgnu/kawa/slib/printf$frame9;->lambda21out$St(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .line 522
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    .line 525
    sget-object v9, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 524
    .end local v1    # "args":Ljava/lang/Object;
    :cond_45
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    goto :goto_12

    .line 522
    :cond_46
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 438
    sget-object v10, Lgnu/kawa/slib/printf;->Lit51:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_48

    .line 527
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    .line 528
    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    sget-object v11, Lgnu/kawa/slib/printf;->Lit50:Lgnu/math/IntNum;

    sget-boolean v9, Lgnu/kawa/slib/printf;->stdio$Clhex$Mnupper$Mncase$Qu:Z

    if-eqz v9, :cond_47

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    .line 529
    :goto_13
    invoke-virtual {v12, v10, v11, v9}, Lgnu/kawa/slib/printf$frame10;->lambda24integerConvert(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v2, v9}, Lgnu/kawa/slib/printf$frame9;->lambda21out$St(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .line 527
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    .line 530
    sget-object v9, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 529
    .end local v1    # "args":Ljava/lang/Object;
    :cond_47
    sget-object v9, Lkawa/lib/rnrs/unicode;->string$Mnupcase:Lgnu/expr/ModuleMethod;

    goto :goto_13

    .line 527
    :cond_48
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 438
    sget-object v10, Lgnu/kawa/slib/printf;->Lit52:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_4a

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_4b

    .line 532
    :cond_49
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Lgnu/kawa/slib/printf;->Lit14:Lgnu/math/IntNum;

    sget-object v11, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v12, v9, v10, v11}, Lgnu/kawa/slib/printf$frame10;->lambda24integerConvert(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v2, v9}, Lgnu/kawa/slib/printf$frame9;->lambda21out$St(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    .line 533
    sget-object v9, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 438
    .end local v1    # "args":Ljava/lang/Object;
    :cond_4a
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit53:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v9, v10, :cond_49

    .line 532
    :cond_4b
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 438
    sget-object v10, Lgnu/kawa/slib/printf;->Lit28:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_4c

    .line 534
    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v11, Lgnu/kawa/slib/printf;->Lit28:Lgnu/text/Char;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    iget-object v1, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .end local v1    # "args":Ljava/lang/Object;
    :cond_4c
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    .line 438
    sget-object v10, Lgnu/kawa/slib/printf;->Lit25:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_4f

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_50

    .line 536
    :cond_4d
    :goto_14
    sget-object v9, Lkawa/lib/lists;->car:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    iget-object v9, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    .line 306
    .local v3, "num":Ljava/lang/Object;
    new-instance v10, Lgnu/kawa/slib/printf$frame11;

    invoke-direct {v10}, Lgnu/kawa/slib/printf$frame11;-><init>()V

    iput-object v12, v10, Lgnu/kawa/slib/printf$frame11;->staticLink:Lgnu/kawa/slib/printf$frame10;

    iput-object v9, v10, Lgnu/kawa/slib/printf$frame11;->fc:Ljava/lang/Object;

    .line 307
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    :try_start_19
    invoke-static {v9}, Lgnu/kawa/lispexpr/LangObjType;->coerceRealNum(Ljava/lang/Object;)Lgnu/math/RealNum;
    :try_end_19
    .catch Ljava/lang/ClassCastException; {:try_start_19 .. :try_end_19} :catch_19

    move-result-object v9

    invoke-static {v9}, Lkawa/lib/numbers;->isNegative(Lgnu/math/RealNum;)Z

    move-result v9

    if-eqz v9, :cond_57

    .line 376
    sget-object v9, Lgnu/kawa/slib/printf;->Lit59:Lgnu/math/IntNum;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    .line 380
    .end local v7    # "x":Ljava/lang/Object;
    :cond_4e
    :goto_15
    invoke-static {v3}, Lkawa/lib/numbers;->isNumber(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_59

    .line 382
    :try_start_1a
    check-cast v3, Ljava/lang/Number;
    :try_end_1a
    .catch Ljava/lang/ClassCastException; {:try_start_1a .. :try_end_1a} :catch_1c

    .end local v3    # "num":Ljava/lang/Object;
    invoke-static {v3}, Lkawa/lib/numbers;->exact$To$Inexact(Ljava/lang/Number;)Ljava/lang/Number;

    move-result-object v9

    invoke-static {v9}, Lkawa/lib/numbers;->number$To$String(Ljava/lang/Number;)Ljava/lang/CharSequence;

    move-result-object v5

    .line 386
    .local v5, "str":Ljava/lang/Object;
    :goto_16
    iget-object v9, v10, Lgnu/kawa/slib/printf$frame11;->format$Mnreal:Lgnu/mapping/Procedure;

    iput-object v9, v10, Lgnu/kawa/slib/printf$frame11;->format$Mnreal:Lgnu/mapping/Procedure;

    .line 400
    iget-object v9, v10, Lgnu/kawa/slib/printf$frame11;->lambda$Fn17:Lgnu/expr/ModuleMethod;

    invoke-static {v5, v9}, Lgnu/kawa/slib/printf;->stdio$ClParseFloat(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .restart local v7    # "x":Ljava/lang/Object;
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_5c

    .end local v7    # "x":Ljava/lang/Object;
    :goto_17
    invoke-virtual {v2, v7}, Lgnu/kawa/slib/printf$frame9;->lambda21out$St(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .line 536
    .restart local v7    # "x":Ljava/lang/Object;
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    sget-object v9, Lkawa/lib/lists;->cdr:Lgnu/expr/GenericProc;

    iget-object v10, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    invoke-virtual {v9, v10}, Lgnu/mapping/Procedure;->apply1(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 438
    .end local v1    # "args":Ljava/lang/Object;
    .end local v5    # "str":Ljava/lang/Object;
    :cond_4f
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit26:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_51

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-ne v7, v9, :cond_4d

    .line 538
    :cond_50
    invoke-virtual {v2}, Lgnu/kawa/slib/printf$frame9;->lambda19isEndOfFormat()Z

    move-result v9

    if-eqz v9, :cond_5d

    .line 539
    invoke-virtual {v2}, Lgnu/kawa/slib/printf$frame9;->lambda20incomplete()Ljava/lang/Object;

    move-result-object v7

    goto/16 :goto_3

    .line 438
    :cond_51
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit13:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_52

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_50

    goto :goto_14

    :cond_52
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit54:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_53

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_50

    goto/16 :goto_14

    :cond_53
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit55:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_54

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_50

    goto/16 :goto_14

    :cond_54
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit56:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_55

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_50

    goto/16 :goto_14

    :cond_55
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit57:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_56

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_50

    goto/16 :goto_14

    :cond_56
    sget-object v9, Lkawa/standard/Scheme;->isEqv:Lgnu/kawa/functions/IsEqv;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit58:Lgnu/text/Char;

    invoke-virtual {v9, v6, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_50

    goto/16 :goto_14

    .line 377
    .restart local v3    # "num":Ljava/lang/Object;
    :cond_57
    iget-object v9, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    :try_start_1b
    check-cast v9, Ljava/lang/Number;
    :try_end_1b
    .catch Ljava/lang/ClassCastException; {:try_start_1b .. :try_end_1b} :catch_1a

    invoke-static {v9}, Lkawa/lib/numbers;->isZero(Ljava/lang/Number;)Z

    move-result v7

    .local v7, "x":Z
    if-eqz v7, :cond_58

    iget-object v9, v10, Lgnu/kawa/slib/printf$frame11;->fc:Ljava/lang/Object;

    :try_start_1c
    check-cast v9, Lgnu/text/Char;
    :try_end_1c
    .catch Ljava/lang/ClassCastException; {:try_start_1c .. :try_end_1c} :catch_1b

    sget-object v11, Lgnu/kawa/slib/printf;->Lit55:Lgnu/text/Char;

    invoke-static {v9, v11}, Lkawa/lib/rnrs/unicode;->isCharCi$Eq(Lgnu/text/Char;Lgnu/text/Char;)Z

    move-result v9

    if-eqz v9, :cond_4e

    .line 379
    :goto_18
    sget-object v9, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    iput-object v9, v12, Lgnu/kawa/slib/printf$frame10;->precision:Ljava/lang/Object;

    goto/16 :goto_15

    .line 377
    :cond_58
    if-eqz v7, :cond_4e

    goto :goto_18

    .line 382
    .end local v7    # "x":Z
    :cond_59
    invoke-static {v3}, Lkawa/lib/strings;->isString(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_5a

    move-object v5, v3

    .line 383
    goto/16 :goto_16

    :cond_5a
    invoke-static {v3}, Lkawa/lib/misc;->isSymbol(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_5b

    .line 384
    :try_start_1d
    check-cast v3, Lgnu/mapping/Symbol;
    :try_end_1d
    .catch Ljava/lang/ClassCastException; {:try_start_1d .. :try_end_1d} :catch_1d

    .end local v3    # "num":Ljava/lang/Object;
    invoke-static {v3}, Lkawa/lib/misc;->symbol$To$String(Lgnu/mapping/Symbol;)Ljava/lang/String;

    move-result-object v5

    goto/16 :goto_16

    .line 385
    .restart local v3    # "num":Ljava/lang/Object;
    :cond_5b
    const-string v5, "???"

    goto/16 :goto_16

    .line 400
    .end local v3    # "num":Ljava/lang/Object;
    .restart local v5    # "str":Ljava/lang/Object;
    .local v7, "x":Ljava/lang/Object;
    :cond_5c
    const-string v9, "???"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v12, v9, v10}, Lgnu/kawa/slib/printf$frame10;->lambda23pad$V(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    goto/16 :goto_17

    .line 540
    .end local v5    # "str":Ljava/lang/Object;
    :cond_5d
    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v11, Lgnu/kawa/slib/printf;->Lit28:Lgnu/text/Char;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    iget-object v11, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    sget-object v11, Lgnu/kawa/slib/printf;->Lit65:Lgnu/text/Char;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    iget-object v1, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .line 541
    .end local v1    # "args":Ljava/lang/Object;
    .end local v6    # "tmp":Ljava/lang/Object;
    .local v7, "x":Z
    :cond_5e
    sget-object v9, Lkawa/standard/Scheme;->applyToArgs:Lgnu/kawa/functions/ApplyToArgs;

    iget-object v10, v2, Lgnu/kawa/slib/printf$frame9;->out:Ljava/lang/Object;

    iget-object v11, v2, Lgnu/kawa/slib/printf$frame9;->fc:Ljava/lang/Object;

    invoke-virtual {v9, v10, v11}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    .local v7, "x":Ljava/lang/Object;
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v7, v9, :cond_0

    iget-object v1, v12, Lgnu/kawa/slib/printf$frame10;->args:Ljava/lang/Object;

    .restart local v1    # "args":Ljava/lang/Object;
    goto/16 :goto_0

    .end local v1    # "args":Ljava/lang/Object;
    .end local v2    # "closureEnv":Lgnu/kawa/slib/printf$frame9;
    .end local v7    # "x":Ljava/lang/Object;
    :cond_5f
    sget-object v7, Lgnu/mapping/Values;->empty:Lgnu/mapping/Values;

    goto/16 :goto_3

    .line 190
    :catch_0
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "string-length"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 191
    :catch_1
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "string-ref"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 196
    .restart local v2    # "closureEnv":Lgnu/kawa/slib/printf$frame9;
    :catch_2
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "string-ref"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    :catch_3
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v12, "string-ref"

    const/4 v13, 0x2

    invoke-direct {v10, v9, v12, v13, v11}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 420
    .restart local v6    # "tmp":Ljava/lang/Object;
    .local v7, "x":Z
    :catch_4
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "negative?"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 433
    .local v7, "x":Ljava/lang/Object;
    :catch_5
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "char-downcase"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 446
    :catch_6
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "symbol->string"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 449
    .restart local v4    # "s":Ljava/lang/Object;
    :catch_7
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "negative?"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 450
    .local v7, "x":Z
    :catch_8
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-length"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v4}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 451
    :catch_9
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "substring"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v4}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .end local v4    # "s":Ljava/lang/Object;
    :catch_a
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "substring"

    const/4 v13, 0x3

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 454
    :catch_b
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-length"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v4}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 457
    :catch_c
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-length"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v4}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    :catch_d
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "make-string"

    const/4 v13, 0x1

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 460
    :catch_e
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-length"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v4}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    :catch_f
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "make-string"

    const/4 v13, 0x1

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 470
    .local v7, "x":Ljava/lang/Object;
    :catch_10
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "negative?"

    const/4 v13, 0x1

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 482
    :catch_11
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "negative?"

    const/4 v13, 0x1

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 502
    :catch_12
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "negative?"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 504
    :catch_13
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "make-string"

    const/4 v13, 0x1

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 508
    :catch_14
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "make-string"

    const/4 v13, 0x1

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 509
    :catch_15
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "x"

    const/4 v13, -0x2

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 510
    .local v7, "x":Z
    :catch_16
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "string-length"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 512
    :catch_17
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "string-length"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    :catch_18
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "make-string"

    const/4 v13, 0x1

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 375
    .restart local v3    # "num":Ljava/lang/Object;
    .local v7, "x":Ljava/lang/Object;
    :catch_19
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "negative?"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 377
    :catch_1a
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "zero?"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 378
    .local v7, "x":Z
    :catch_1b
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "char-ci=?"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 382
    .end local v7    # "x":Z
    :catch_1c
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "exact->inexact"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v3}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 384
    :catch_1d
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "symbol->string"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v3}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10
.end method

.method public static stdio$ClParseFloat(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5
    .param p0, "str"    # Ljava/lang/Object;
    .param p1, "proc"    # Ljava/lang/Object;

    .prologue
    .line 34
    new-instance v1, Lgnu/kawa/slib/printf$frame;

    invoke-direct {v1}, Lgnu/kawa/slib/printf$frame;-><init>()V

    iput-object p0, v1, Lgnu/kawa/slib/printf$frame;->str:Ljava/lang/Object;

    iput-object p1, v1, Lgnu/kawa/slib/printf$frame;->proc:Ljava/lang/Object;

    .line 35
    iget-object v0, v1, Lgnu/kawa/slib/printf$frame;->str:Ljava/lang/Object;

    :try_start_0
    check-cast v0, Ljava/lang/CharSequence;
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    invoke-static {v0}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v0

    iput v0, v1, Lgnu/kawa/slib/printf$frame;->n:I

    .line 36
    sget-object v0, Lgnu/kawa/slib/printf;->Lit1:Lgnu/math/IntNum;

    iget-object v2, v1, Lgnu/kawa/slib/printf$frame;->lambda$Fn1:Lgnu/expr/ModuleMethod;

    invoke-virtual {v1, v0, v2}, Lgnu/kawa/slib/printf$frame;->lambda4real(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    return-object v0

    .line 35
    :catch_0
    move-exception v1

    new-instance v2, Lgnu/mapping/WrongType;

    const-string v3, "string-length"

    const/4 v4, 0x1

    invoke-direct {v2, v1, v3, v4, v0}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v2
.end method

.method public static stdio$ClRoundString(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 14
    .param p0, "str"    # Ljava/lang/CharSequence;
    .param p1, "ndigs"    # Ljava/lang/Object;
    .param p2, "strip$Mn0s"    # Ljava/lang/Object;

    .prologue
    .line 138
    new-instance v1, Lgnu/kawa/slib/printf$frame8;

    invoke-direct {v1}, Lgnu/kawa/slib/printf$frame8;-><init>()V

    iput-object p0, v1, Lgnu/kawa/slib/printf$frame8;->str:Ljava/lang/CharSequence;

    .line 139
    iget-object v9, v1, Lgnu/kawa/slib/printf$frame8;->str:Ljava/lang/CharSequence;

    invoke-static {v9}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v9

    add-int/lit8 v5, v9, -0x1

    .line 141
    .local v5, "n":I
    sget-object v9, Lkawa/standard/Scheme;->numLss:Lgnu/kawa/functions/NumberCompare;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit1:Lgnu/math/IntNum;

    invoke-virtual {v9, p1, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_3

    const-string v7, ""

    .line 178
    .end local p1    # "ndigs":Ljava/lang/Object;
    .local v7, "res":Ljava/lang/Object;
    :cond_0
    :goto_0
    sget-object v9, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    move-object/from16 v0, p2

    if-eq v0, v9, :cond_2

    .line 179
    :try_start_0
    move-object v0, v7

    check-cast v0, Ljava/lang/CharSequence;

    move-object v9, v0
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_b

    invoke-static {v9}, Lkawa/lib/strings;->stringLength(Ljava/lang/CharSequence;)I

    move-result v9

    add-int/lit8 v9, v9, -0x1

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    .line 180
    :goto_1
    sget-object v9, Lkawa/standard/Scheme;->numLEq:Lgnu/kawa/functions/NumberCompare;

    move-object/from16 v0, p2

    invoke-virtual {v9, v3, v0}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_1
    move-object v0, v10

    check-cast v0, Ljava/lang/Boolean;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_1
    .catch Ljava/lang/ClassCastException; {:try_start_1 .. :try_end_1} :catch_c

    move-result v8

    .local v8, "x":Z
    if-eqz v8, :cond_e

    if-eqz v8, :cond_f

    .line 182
    :cond_1
    :try_start_2
    check-cast v7, Ljava/lang/CharSequence;
    :try_end_2
    .catch Ljava/lang/ClassCastException; {:try_start_2 .. :try_end_2} :catch_f

    .end local v7    # "res":Ljava/lang/Object;
    const/4 v11, 0x0

    sget-object v9, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    invoke-virtual {v9, v3, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_3
    move-object v0, v10

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I
    :try_end_3
    .catch Ljava/lang/ClassCastException; {:try_start_3 .. :try_end_3} :catch_10

    move-result v9

    invoke-static {v7, v11, v9}, Lkawa/lib/strings;->substring(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;

    move-result-object v7

    .line 178
    .end local v8    # "x":Z
    :cond_2
    return-object v7

    .line 141
    .restart local p1    # "ndigs":Ljava/lang/Object;
    :cond_3
    sget-object v9, Lkawa/standard/Scheme;->numEqu:Lgnu/kawa/functions/NumberCompare;

    .line 142
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v9, v10, p1}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_4

    iget-object v7, v1, Lgnu/kawa/slib/printf$frame8;->str:Ljava/lang/CharSequence;

    goto :goto_0

    :cond_4
    sget-object v9, Lkawa/standard/Scheme;->numLss:Lgnu/kawa/functions/NumberCompare;

    .line 143
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v9, v10, p1}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_8

    .line 144
    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    sget-object v11, Lgnu/kawa/slib/printf;->Lit1:Lgnu/math/IntNum;

    aput-object v11, v9, v10

    const/4 v10, 0x1

    sget-object v11, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    sget-object v12, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    move-object/from16 v0, p2

    if-eq v0, v12, :cond_5

    move-object/from16 p1, p2

    .end local p1    # "ndigs":Ljava/lang/Object;
    :cond_5
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {v11, p1, v12}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v9}, Lkawa/lib/numbers;->max([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 145
    .local v6, "padlen":Ljava/lang/Object;
    :try_start_4
    move-object v0, v6

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0
    :try_end_4
    .catch Ljava/lang/ClassCastException; {:try_start_4 .. :try_end_4} :catch_0

    invoke-static {v9}, Lkawa/lib/numbers;->isZero(Ljava/lang/Number;)Z

    move-result v9

    if-eqz v9, :cond_6

    iget-object v9, v1, Lgnu/kawa/slib/printf$frame8;->str:Ljava/lang/CharSequence;

    :goto_2
    move-object v7, v9

    .line 149
    goto/16 :goto_0

    .line 147
    :cond_6
    const/4 v9, 0x2

    new-array v10, v9, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v11, v1, Lgnu/kawa/slib/printf$frame8;->str:Ljava/lang/CharSequence;

    aput-object v11, v10, v9

    const/4 v11, 0x1

    :try_start_5
    move-object v0, v6

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I
    :try_end_5
    .catch Ljava/lang/ClassCastException; {:try_start_5 .. :try_end_5} :catch_1

    move-result v12

    iget-object v9, v1, Lgnu/kawa/slib/printf$frame8;->str:Ljava/lang/CharSequence;

    invoke-static {v9, v5}, Lkawa/lib/strings;->stringRef(Ljava/lang/CharSequence;I)C

    move-result v9

    invoke-static {v9}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v9

    invoke-static {v9}, Lkawa/lib/rnrs/unicode;->isCharNumeric(Lgnu/text/Char;)Z

    move-result v9

    if-eqz v9, :cond_7

    .line 149
    sget-object v9, Lgnu/kawa/slib/printf;->Lit9:Lgnu/text/Char;

    :goto_3
    invoke-static {v12, v9}, Lkawa/lib/strings;->makeString(ILjava/lang/Object;)Ljava/lang/CharSequence;

    move-result-object v9

    aput-object v9, v10, v11

    invoke-static {v10}, Lkawa/lib/strings;->stringAppend([Ljava/lang/Object;)Lgnu/lists/FString;

    move-result-object v9

    goto :goto_2

    :cond_7
    sget-object v9, Lgnu/kawa/slib/printf;->Lit8:Lgnu/text/Char;

    goto :goto_3

    .line 153
    .end local v6    # "padlen":Ljava/lang/Object;
    .restart local p1    # "ndigs":Ljava/lang/Object;
    :cond_8
    iget-object v11, v1, Lgnu/kawa/slib/printf$frame8;->str:Ljava/lang/CharSequence;

    const/4 v12, 0x0

    sget-object v9, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    invoke-virtual {v9, p1, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_6
    move-object v0, v10

    check-cast v0, Ljava/lang/Number;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I
    :try_end_6
    .catch Ljava/lang/ClassCastException; {:try_start_6 .. :try_end_6} :catch_2

    move-result v9

    invoke-static {v11, v12, v9}, Lkawa/lib/strings;->substring(Ljava/lang/CharSequence;II)Ljava/lang/CharSequence;

    move-result-object v7

    .line 159
    .local v7, "res":Ljava/lang/CharSequence;
    sget-object v9, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    invoke-virtual {v9, v10, p1}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v1, v9}, Lgnu/kawa/slib/printf$frame8;->lambda17dig(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 160
    .local v4, "ldig":Ljava/lang/Object;
    sget-object v9, Lkawa/standard/Scheme;->numGrt:Lgnu/kawa/functions/NumberCompare;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit15:Lgnu/math/IntNum;

    invoke-virtual {v9, v4, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_7
    move-object v0, v10

    check-cast v0, Ljava/lang/Boolean;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_7
    .catch Ljava/lang/ClassCastException; {:try_start_7 .. :try_end_7} :catch_3

    move-result v8

    .restart local v8    # "x":Z
    if-eqz v8, :cond_a

    if-eqz v8, :cond_0

    .line 168
    :cond_9
    :goto_4
    move-object v3, p1

    .line 169
    .local v1, "closureEnv":Lgnu/kawa/slib/printf$frame8;
    .local v3, "i":Ljava/lang/Object;
    :goto_5
    invoke-virtual {v1, v3}, Lgnu/kawa/slib/printf$frame8;->lambda17dig(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 170
    .local v2, "d":Ljava/lang/Object;
    sget-object v9, Lkawa/standard/Scheme;->numLss:Lgnu/kawa/functions/NumberCompare;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit16:Lgnu/math/IntNum;

    invoke-virtual {v9, v2, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_d

    .line 171
    :try_start_8
    move-object v0, v7

    check-cast v0, Lgnu/lists/CharSeq;

    move-object v9, v0
    :try_end_8
    .catch Ljava/lang/ClassCastException; {:try_start_8 .. :try_end_8} :catch_6

    :try_start_9
    move-object v0, v3

    check-cast v0, Ljava/lang/Number;

    move-object v10, v0

    invoke-virtual {v10}, Ljava/lang/Number;->intValue()I
    :try_end_9
    .catch Ljava/lang/ClassCastException; {:try_start_9 .. :try_end_9} :catch_7

    move-result v11

    sget-object v10, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    .line 173
    sget-object v12, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    invoke-virtual {v10, v2, v12}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_a
    check-cast v10, Ljava/lang/Number;
    :try_end_a
    .catch Ljava/lang/ClassCastException; {:try_start_a .. :try_end_a} :catch_8

    invoke-static {v10}, Lkawa/lib/numbers;->number$To$String(Ljava/lang/Number;)Ljava/lang/CharSequence;

    move-result-object v10

    const/4 v12, 0x0

    invoke-static {v10, v12}, Lkawa/lib/strings;->stringRef(Ljava/lang/CharSequence;I)C

    move-result v10

    invoke-static {v9, v11, v10}, Lkawa/lib/strings;->stringSet$Ex(Lgnu/lists/CharSeq;IC)V

    goto/16 :goto_0

    .line 161
    .end local v1    # "closureEnv":Lgnu/kawa/slib/printf$frame8;
    .end local v2    # "d":Ljava/lang/Object;
    .end local v3    # "i":Ljava/lang/Object;
    :cond_a
    sget-object v9, Lkawa/standard/Scheme;->numEqu:Lgnu/kawa/functions/NumberCompare;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit15:Lgnu/math/IntNum;

    invoke-virtual {v9, v4, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v10

    :try_start_b
    move-object v0, v10

    check-cast v0, Ljava/lang/Boolean;

    move-object v9, v0

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_b
    .catch Ljava/lang/ClassCastException; {:try_start_b .. :try_end_b} :catch_4

    move-result v8

    if-eqz v8, :cond_c

    .line 162
    sget-object v9, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit14:Lgnu/math/IntNum;

    invoke-virtual {v9, v10, p1}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 163
    .restart local v1    # "closureEnv":Lgnu/kawa/slib/printf$frame8;
    .restart local v3    # "i":Ljava/lang/Object;
    :goto_6
    sget-object v9, Lkawa/standard/Scheme;->numGrt:Lgnu/kawa/functions/NumberCompare;

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v9, v3, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    sget-object v10, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    if-eq v9, v10, :cond_b

    .line 164
    invoke-virtual {v1, p1}, Lgnu/kawa/slib/printf$frame8;->lambda17dig(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Number;

    invoke-virtual {v9}, Ljava/lang/Number;->intValue()I

    move-result v9

    and-int/lit8 v9, v9, 0x1

    if-eqz v9, :cond_0

    goto :goto_4

    .line 165
    :cond_b
    invoke-virtual {v1, v3}, Lgnu/kawa/slib/printf$frame8;->lambda17dig(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    :try_start_c
    check-cast v9, Ljava/lang/Number;
    :try_end_c
    .catch Ljava/lang/ClassCastException; {:try_start_c .. :try_end_c} :catch_5

    invoke-static {v9}, Lkawa/lib/numbers;->isZero(Ljava/lang/Number;)Z

    move-result v9

    if-eqz v9, :cond_9

    .line 166
    sget-object v9, Lgnu/kawa/functions/AddOp;->$Pl:Lgnu/kawa/functions/AddOp;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    invoke-virtual {v9, v3, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    goto :goto_6

    .line 161
    .end local v1    # "closureEnv":Lgnu/kawa/slib/printf$frame8;
    .end local v3    # "i":Ljava/lang/Object;
    :cond_c
    if-eqz v8, :cond_0

    goto/16 :goto_4

    .line 174
    .restart local v1    # "closureEnv":Lgnu/kawa/slib/printf$frame8;
    .restart local v2    # "d":Ljava/lang/Object;
    .restart local v3    # "i":Ljava/lang/Object;
    :cond_d
    :try_start_d
    move-object v0, v7

    check-cast v0, Lgnu/lists/CharSeq;

    move-object v9, v0
    :try_end_d
    .catch Ljava/lang/ClassCastException; {:try_start_d .. :try_end_d} :catch_9

    :try_start_e
    move-object v0, v3

    check-cast v0, Ljava/lang/Number;

    move-object v10, v0

    invoke-virtual {v10}, Ljava/lang/Number;->intValue()I
    :try_end_e
    .catch Ljava/lang/ClassCastException; {:try_start_e .. :try_end_e} :catch_a

    move-result v10

    const/16 v11, 0x30

    invoke-static {v9, v10, v11}, Lkawa/lib/strings;->stringSet$Ex(Lgnu/lists/CharSeq;IC)V

    .line 176
    sget-object v9, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    invoke-virtual {v9, v3, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    goto/16 :goto_5

    .line 180
    .end local v1    # "closureEnv":Lgnu/kawa/slib/printf$frame8;
    .end local v2    # "d":Ljava/lang/Object;
    .end local v3    # "i":Ljava/lang/Object;
    .end local v4    # "ldig":Ljava/lang/Object;
    .end local p1    # "ndigs":Ljava/lang/Object;
    .local v7, "res":Ljava/lang/Object;
    :cond_e
    sget-object v11, Lgnu/kawa/slib/printf;->Lit9:Lgnu/text/Char;

    :try_start_f
    move-object v0, v7

    check-cast v0, Ljava/lang/CharSequence;

    move-object v9, v0
    :try_end_f
    .catch Ljava/lang/ClassCastException; {:try_start_f .. :try_end_f} :catch_d

    :try_start_10
    move-object v0, v3

    check-cast v0, Ljava/lang/Number;

    move-object v10, v0

    invoke-virtual {v10}, Ljava/lang/Number;->intValue()I
    :try_end_10
    .catch Ljava/lang/ClassCastException; {:try_start_10 .. :try_end_10} :catch_e

    move-result v10

    invoke-static {v9, v10}, Lkawa/lib/strings;->stringRef(Ljava/lang/CharSequence;I)C

    move-result v9

    invoke-static {v9}, Lgnu/text/Char;->make(I)Lgnu/text/Char;

    move-result-object v9

    invoke-static {v11, v9}, Lkawa/lib/characters;->isChar$Eq(Lgnu/text/Char;Lgnu/text/Char;)Z

    move-result v9

    if-eqz v9, :cond_1

    .line 183
    :cond_f
    sget-object v9, Lgnu/kawa/functions/AddOp;->$Mn:Lgnu/kawa/functions/AddOp;

    sget-object v10, Lgnu/kawa/slib/printf;->Lit7:Lgnu/math/IntNum;

    invoke-virtual {v9, v3, v10}, Lgnu/mapping/Procedure;->apply2(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .restart local v3    # "i":Ljava/lang/Object;
    goto/16 :goto_1

    .line 145
    .end local v3    # "i":Ljava/lang/Object;
    .end local v7    # "res":Ljava/lang/Object;
    .end local v8    # "x":Z
    .restart local v6    # "padlen":Ljava/lang/Object;
    :catch_0
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "zero?"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v6}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 148
    :catch_1
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "make-string"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v6}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 153
    .end local v6    # "padlen":Ljava/lang/Object;
    .restart local p1    # "ndigs":Ljava/lang/Object;
    :catch_2
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "substring"

    const/4 v13, 0x3

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 160
    .restart local v4    # "ldig":Ljava/lang/Object;
    .local v7, "res":Ljava/lang/CharSequence;
    :catch_3
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "x"

    const/4 v13, -0x2

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 161
    .restart local v8    # "x":Z
    :catch_4
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "x"

    const/4 v13, -0x2

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 165
    .restart local v1    # "closureEnv":Lgnu/kawa/slib/printf$frame8;
    .restart local v3    # "i":Ljava/lang/Object;
    :catch_5
    move-exception v10

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "zero?"

    const/4 v13, 0x1

    invoke-direct {v11, v10, v12, v13, v9}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 171
    .restart local v2    # "d":Ljava/lang/Object;
    :catch_6
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-set!"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v7}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    :catch_7
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-set!"

    const/4 v12, 0x2

    invoke-direct {v10, v9, v11, v12, v3}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 173
    :catch_8
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "number->string"

    const/4 v13, 0x1

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 175
    :catch_9
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-set!"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v7}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    :catch_a
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-set!"

    const/4 v12, 0x2

    invoke-direct {v10, v9, v11, v12, v3}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 179
    .end local v1    # "closureEnv":Lgnu/kawa/slib/printf$frame8;
    .end local v2    # "d":Ljava/lang/Object;
    .end local v3    # "i":Ljava/lang/Object;
    .end local v4    # "ldig":Ljava/lang/Object;
    .end local v8    # "x":Z
    .end local p1    # "ndigs":Ljava/lang/Object;
    .local v7, "res":Ljava/lang/Object;
    :catch_b
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-length"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v7}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 180
    :catch_c
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "x"

    const/4 v13, -0x2

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11

    .line 181
    .restart local v8    # "x":Z
    :catch_d
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-ref"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v7}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    :catch_e
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "string-ref"

    const/4 v12, 0x2

    invoke-direct {v10, v9, v11, v12, v3}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .line 182
    :catch_f
    move-exception v9

    new-instance v10, Lgnu/mapping/WrongType;

    const-string v11, "substring"

    const/4 v12, 0x1

    invoke-direct {v10, v9, v11, v12, v7}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v10

    .end local v7    # "res":Ljava/lang/Object;
    :catch_10
    move-exception v9

    new-instance v11, Lgnu/mapping/WrongType;

    const-string v12, "substring"

    const/4 v13, 0x3

    invoke-direct {v11, v9, v12, v13, v10}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v11
.end method


# virtual methods
.method public apply2(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 2

    .prologue
    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    const/16 v1, 0x16

    if-ne v0, v1, :cond_0

    .line 34
    invoke-static {p2, p3}, Lgnu/kawa/slib/printf;->stdio$ClParseFloat(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2, p3}, Lgnu/expr/ModuleBody;->apply2(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public apply3(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4

    .prologue
    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    const/16 v1, 0x17

    if-ne v0, v1, :cond_0

    .line 138
    :try_start_0
    check-cast p2, Ljava/lang/CharSequence;
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    invoke-static {p2, p3, p4}, Lgnu/kawa/slib/printf;->stdio$ClRoundString(Ljava/lang/CharSequence;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Lgnu/expr/ModuleBody;->apply3(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Lgnu/mapping/WrongType;

    const-string v2, "stdio:round-string"

    const/4 v3, 0x1

    invoke-direct {v1, v0, v2, v3, p2}, Lgnu/mapping/WrongType;-><init>(Ljava/lang/ClassCastException;Ljava/lang/String;ILjava/lang/Object;)V

    throw v1
.end method

.method public applyN(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;
    .locals 5

    .prologue
    const/4 v3, 0x1

    const/4 v1, 0x0

    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    packed-switch v0, :pswitch_data_0

    .line 556
    invoke-super {p0, p1, p2}, Lgnu/expr/ModuleBody;->applyN(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    :goto_0
    return-object v0

    .line 186
    :pswitch_0
    aget-object v2, p2, v1

    aget-object v3, p2, v3

    array-length v0, p2

    add-int/lit8 v1, v0, -0x2

    new-array v0, v1, [Ljava/lang/Object;

    :goto_1
    add-int/lit8 v1, v1, -0x1

    if-gez v1, :cond_0

    invoke-static {v2, v3, v0}, Lgnu/kawa/slib/printf;->stdio$ClIprintf$V(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :cond_0
    add-int/lit8 v4, v1, 0x2

    aget-object v4, p2, v4

    aput-object v4, v0, v1

    goto :goto_1

    .line 543
    :pswitch_1
    aget-object v2, p2, v1

    aget-object v3, p2, v3

    array-length v0, p2

    add-int/lit8 v1, v0, -0x2

    new-array v0, v1, [Ljava/lang/Object;

    :goto_2
    add-int/lit8 v1, v1, -0x1

    if-gez v1, :cond_1

    invoke-static {v2, v3, v0}, Lgnu/kawa/slib/printf;->fprintf$V(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :cond_1
    add-int/lit8 v4, v1, 0x2

    aget-object v4, p2, v4

    aput-object v4, v0, v1

    goto :goto_2

    .line 553
    :pswitch_2
    aget-object v2, p2, v1

    array-length v0, p2

    add-int/lit8 v1, v0, -0x1

    new-array v0, v1, [Ljava/lang/Object;

    :goto_3
    add-int/lit8 v1, v1, -0x1

    if-gez v1, :cond_2

    invoke-static {v2, v0}, Lgnu/kawa/slib/printf;->printf$V(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :cond_2
    add-int/lit8 v3, v1, 0x1

    aget-object v3, p2, v3

    aput-object v3, v0, v1

    goto :goto_3

    .line 556
    :pswitch_3
    aget-object v2, p2, v1

    aget-object v3, p2, v3

    array-length v0, p2

    add-int/lit8 v1, v0, -0x2

    new-array v0, v1, [Ljava/lang/Object;

    :goto_4
    add-int/lit8 v1, v1, -0x1

    if-gez v1, :cond_3

    invoke-static {v2, v3, v0}, Lgnu/kawa/slib/printf;->sprintf$V(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :cond_3
    add-int/lit8 v4, v1, 0x2

    aget-object v4, p2, v4

    aput-object v4, v0, v1

    goto :goto_4

    .line 4294967295
    :pswitch_data_0
    .packed-switch 0x18
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public match2(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    .locals 2

    .prologue
    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    const/16 v1, 0x16

    if-ne v0, v1, :cond_0

    .line 34
    iput-object p2, p4, Lgnu/mapping/CallContext;->value1:Ljava/lang/Object;

    iput-object p3, p4, Lgnu/mapping/CallContext;->value2:Ljava/lang/Object;

    iput-object p1, p4, Lgnu/mapping/CallContext;->proc:Lgnu/mapping/Procedure;

    const/4 v0, 0x2

    iput v0, p4, Lgnu/mapping/CallContext;->pc:I

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Lgnu/expr/ModuleBody;->match2(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I

    move-result v0

    goto :goto_0
.end method

.method public match3(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    .locals 2

    .prologue
    iget v0, p1, Lgnu/expr/ModuleMethod;->selector:I

    const/16 v1, 0x17

    if-ne v0, v1, :cond_1

    .line 138
    instance-of v0, p2, Ljava/lang/CharSequence;

    if-eqz v0, :cond_0

    iput-object p2, p5, Lgnu/mapping/CallContext;->value1:Ljava/lang/Object;

    iput-object p3, p5, Lgnu/mapping/CallContext;->value2:Ljava/lang/Object;

    iput-object p4, p5, Lgnu/mapping/CallContext;->value3:Ljava/lang/Object;

    iput-object p1, p5, Lgnu/mapping/CallContext;->proc:Lgnu/mapping/Procedure;

    const/4 v0, 0x3

    iput v0, p5, Lgnu/mapping/CallContext;->pc:I

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    const v0, -0xbffff

    goto :goto_0

    :cond_1
    invoke-super/range {p0 .. p5}, Lgnu/expr/ModuleBody;->match3(Lgnu/expr/ModuleMethod;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lgnu/mapping/CallContext;)I

    move-result v0

    goto :goto_0
.end method

.method public matchN(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;Lgnu/mapping/CallContext;)I
    .locals 3

    .prologue
    const/4 v2, 0x5

    const/4 v0, 0x0

    iget v1, p1, Lgnu/expr/ModuleMethod;->selector:I

    packed-switch v1, :pswitch_data_0

    .line 186
    invoke-super {p0, p1, p2, p3}, Lgnu/expr/ModuleBody;->matchN(Lgnu/expr/ModuleMethod;[Ljava/lang/Object;Lgnu/mapping/CallContext;)I

    move-result v0

    .line 556
    :goto_0
    return v0

    :pswitch_0
    iput-object p2, p3, Lgnu/mapping/CallContext;->values:[Ljava/lang/Object;

    iput-object p1, p3, Lgnu/mapping/CallContext;->proc:Lgnu/mapping/Procedure;

    iput v2, p3, Lgnu/mapping/CallContext;->pc:I

    goto :goto_0

    .line 553
    :pswitch_1
    iput-object p2, p3, Lgnu/mapping/CallContext;->values:[Ljava/lang/Object;

    iput-object p1, p3, Lgnu/mapping/CallContext;->proc:Lgnu/mapping/Procedure;

    iput v2, p3, Lgnu/mapping/CallContext;->pc:I

    goto :goto_0

    .line 543
    :pswitch_2
    iput-object p2, p3, Lgnu/mapping/CallContext;->values:[Ljava/lang/Object;

    iput-object p1, p3, Lgnu/mapping/CallContext;->proc:Lgnu/mapping/Procedure;

    iput v2, p3, Lgnu/mapping/CallContext;->pc:I

    goto :goto_0

    .line 186
    :pswitch_3
    iput-object p2, p3, Lgnu/mapping/CallContext;->values:[Ljava/lang/Object;

    iput-object p1, p3, Lgnu/mapping/CallContext;->proc:Lgnu/mapping/Procedure;

    iput v2, p3, Lgnu/mapping/CallContext;->pc:I

    goto :goto_0

    .line 4294967295
    :pswitch_data_0
    .packed-switch 0x18
        :pswitch_3
        :pswitch_2
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public final run(Lgnu/mapping/CallContext;)V
    .locals 4
    .param p1, "$ctx"    # Lgnu/mapping/CallContext;

    .prologue
    .line 21
    iget-object v0, p1, Lgnu/mapping/CallContext;->consumer:Lgnu/lists/Consumer;

    .line 24
    .local v0, "$result":Lgnu/lists/Consumer;
    const-string v1, "-F"

    sget-object v2, Lgnu/kawa/slib/printf;->Lit0:Lgnu/math/IntNum;

    const/16 v3, 0x10

    invoke-static {v2, v3}, Lkawa/lib/numbers;->number$To$String(Ljava/lang/Number;I)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-static {v1, v2}, Lkawa/lib/strings;->isString$Eq(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    sput-boolean v1, Lgnu/kawa/slib/printf;->stdio$Clhex$Mnupper$Mncase$Qu:Z

    .line 34
    return-void
.end method
