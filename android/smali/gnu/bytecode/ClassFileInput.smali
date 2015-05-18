.class public Lgnu/bytecode/ClassFileInput;
.super Ljava/io/DataInputStream;
.source "ClassFileInput.java"


# instance fields
.field ctype:Lgnu/bytecode/ClassType;

.field str:Ljava/io/InputStream;


# direct methods
.method public constructor <init>(Lgnu/bytecode/ClassType;Ljava/io/InputStream;)V
    .locals 2
    .param p1, "ctype"    # Lgnu/bytecode/ClassType;
    .param p2, "str"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassFormatError;
        }
    .end annotation

    .prologue
    .line 27
    invoke-direct {p0, p2}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 28
    iput-object p1, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    .line 29
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readHeader()Z

    move-result v0

    if-nez v0, :cond_0

    .line 30
    new-instance v0, Ljava/lang/ClassFormatError;

    const-string v1, "invalid magic number"

    invoke-direct {v0, v1}, Ljava/lang/ClassFormatError;-><init>(Ljava/lang/String;)V

    throw v0

    .line 31
    :cond_0
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readConstants()Lgnu/bytecode/ConstantPool;

    move-result-object v0

    iput-object v0, p1, Lgnu/bytecode/ClassType;->constants:Lgnu/bytecode/ConstantPool;

    .line 32
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readClassInfo()V

    .line 33
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readFields()V

    .line 34
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readMethods()V

    .line 35
    invoke-virtual {p0, p1}, Lgnu/bytecode/ClassFileInput;->readAttributes(Lgnu/bytecode/AttrContainer;)I

    .line 36
    return-void
.end method

.method public constructor <init>(Ljava/io/InputStream;)V
    .locals 0
    .param p1, "str"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    invoke-direct {p0, p1}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V

    .line 22
    return-void
.end method

.method public static readClassType(Ljava/io/InputStream;)Lgnu/bytecode/ClassType;
    .locals 2
    .param p0, "str"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassFormatError;
        }
    .end annotation

    .prologue
    .line 44
    new-instance v0, Lgnu/bytecode/ClassType;

    invoke-direct {v0}, Lgnu/bytecode/ClassType;-><init>()V

    .line 45
    .local v0, "ctype":Lgnu/bytecode/ClassType;
    new-instance v1, Lgnu/bytecode/ClassFileInput;

    invoke-direct {v1, v0, p0}, Lgnu/bytecode/ClassFileInput;-><init>(Lgnu/bytecode/ClassType;Ljava/io/InputStream;)V

    .line 46
    return-object v0
.end method


# virtual methods
.method getClassConstant(I)Lgnu/bytecode/CpoolClass;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 351
    iget-object v0, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    iget-object v0, v0, Lgnu/bytecode/ClassType;->constants:Lgnu/bytecode/ConstantPool;

    const/4 v1, 0x7

    invoke-virtual {v0, p1, v1}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v0

    check-cast v0, Lgnu/bytecode/CpoolClass;

    return-object v0
.end method

.method public readAttribute(Ljava/lang/String;ILgnu/bytecode/AttrContainer;)Lgnu/bytecode/Attribute;
    .locals 29
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "length"    # I
    .param p3, "container"    # Lgnu/bytecode/AttrContainer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 174
    const-string v27, "SourceFile"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_1

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/ClassType;

    move/from16 v27, v0

    if-eqz v27, :cond_1

    .line 176
    new-instance v3, Lgnu/bytecode/SourceFileAttr;

    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    check-cast p3, Lgnu/bytecode/ClassType;

    .end local p3    # "container":Lgnu/bytecode/AttrContainer;
    move/from16 v0, v27

    move-object/from16 v1, p3

    invoke-direct {v3, v0, v1}, Lgnu/bytecode/SourceFileAttr;-><init>(ILgnu/bytecode/ClassType;)V

    .line 313
    :cond_0
    :goto_0
    return-object v3

    .line 178
    .restart local p3    # "container":Lgnu/bytecode/AttrContainer;
    :cond_1
    const-string v27, "Code"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_3

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/Method;

    move/from16 v27, v0

    if-eqz v27, :cond_3

    .line 180
    new-instance v6, Lgnu/bytecode/CodeAttr;

    check-cast p3, Lgnu/bytecode/Method;

    .end local p3    # "container":Lgnu/bytecode/AttrContainer;
    move-object/from16 v0, p3

    invoke-direct {v6, v0}, Lgnu/bytecode/CodeAttr;-><init>(Lgnu/bytecode/Method;)V

    .line 181
    .local v6, "code":Lgnu/bytecode/CodeAttr;
    const/16 v27, -0x1

    move/from16 v0, v27

    iput v0, v6, Lgnu/bytecode/CodeAttr;->fixup_count:I

    .line 182
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    move/from16 v0, v27

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->setMaxStack(I)V

    .line 183
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    move/from16 v0, v27

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->setMaxLocals(I)V

    .line 184
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readInt()I

    move-result v7

    .line 185
    .local v7, "code_len":I
    new-array v0, v7, [B

    move-object/from16 v16, v0

    .line 186
    .local v16, "insns":[B
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Lgnu/bytecode/ClassFileInput;->readFully([B)V

    .line 187
    move-object/from16 v0, v16

    invoke-virtual {v6, v0}, Lgnu/bytecode/CodeAttr;->setCode([B)V

    .line 188
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v12

    .line 189
    .local v12, "exception_table_length":I
    const/4 v15, 0x0

    .local v15, "i":I
    :goto_1
    if-ge v15, v12, :cond_2

    .line 191
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v25

    .line 192
    .local v25, "start_pc":I
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v11

    .line 193
    .local v11, "end_pc":I
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v14

    .line 194
    .local v14, "handler_pc":I
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v4

    .line 195
    .local v4, "catch_type":I
    move/from16 v0, v25

    invoke-virtual {v6, v0, v11, v14, v4}, Lgnu/bytecode/CodeAttr;->addHandler(IIII)V

    .line 189
    add-int/lit8 v15, v15, 0x1

    goto :goto_1

    .line 197
    .end local v4    # "catch_type":I
    .end local v11    # "end_pc":I
    .end local v14    # "handler_pc":I
    .end local v25    # "start_pc":I
    :cond_2
    move-object/from16 v0, p0

    invoke-virtual {v0, v6}, Lgnu/bytecode/ClassFileInput;->readAttributes(Lgnu/bytecode/AttrContainer;)I

    move-object v3, v6

    .line 198
    goto :goto_0

    .line 200
    .end local v6    # "code":Lgnu/bytecode/CodeAttr;
    .end local v7    # "code_len":I
    .end local v12    # "exception_table_length":I
    .end local v15    # "i":I
    .end local v16    # "insns":[B
    .restart local p3    # "container":Lgnu/bytecode/AttrContainer;
    :cond_3
    const-string v27, "LineNumberTable"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_5

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/CodeAttr;

    move/from16 v27, v0

    if-eqz v27, :cond_5

    .line 202
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    mul-int/lit8 v9, v27, 0x2

    .line 203
    .local v9, "count":I
    new-array v0, v9, [S

    move-object/from16 v20, v0

    .line 204
    .local v20, "numbers":[S
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_2
    if-ge v15, v9, :cond_4

    .line 206
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readShort()S

    move-result v27

    aput-short v27, v20, v15

    .line 204
    add-int/lit8 v15, v15, 0x1

    goto :goto_2

    .line 208
    :cond_4
    new-instance v3, Lgnu/bytecode/LineNumbersAttr;

    check-cast p3, Lgnu/bytecode/CodeAttr;

    .end local p3    # "container":Lgnu/bytecode/AttrContainer;
    move-object/from16 v0, v20

    move-object/from16 v1, p3

    invoke-direct {v3, v0, v1}, Lgnu/bytecode/LineNumbersAttr;-><init>([SLgnu/bytecode/CodeAttr;)V

    goto/16 :goto_0

    .line 210
    .end local v9    # "count":I
    .end local v15    # "i":I
    .end local v20    # "numbers":[S
    .restart local p3    # "container":Lgnu/bytecode/AttrContainer;
    :cond_5
    const-string v27, "LocalVariableTable"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_c

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/CodeAttr;

    move/from16 v27, v0

    if-eqz v27, :cond_c

    move-object/from16 v6, p3

    .line 212
    check-cast v6, Lgnu/bytecode/CodeAttr;

    .line 213
    .restart local v6    # "code":Lgnu/bytecode/CodeAttr;
    new-instance v3, Lgnu/bytecode/LocalVarsAttr;

    invoke-direct {v3, v6}, Lgnu/bytecode/LocalVarsAttr;-><init>(Lgnu/bytecode/CodeAttr;)V

    .line 214
    .local v3, "attr":Lgnu/bytecode/LocalVarsAttr;
    invoke-virtual {v3}, Lgnu/bytecode/LocalVarsAttr;->getMethod()Lgnu/bytecode/Method;

    move-result-object v18

    .line 215
    .local v18, "method":Lgnu/bytecode/Method;
    iget-object v0, v3, Lgnu/bytecode/LocalVarsAttr;->parameter_scope:Lgnu/bytecode/Scope;

    move-object/from16 v27, v0

    if-nez v27, :cond_6

    .line 216
    invoke-virtual/range {v18 .. v18}, Lgnu/bytecode/Method;->pushScope()Lgnu/bytecode/Scope;

    move-result-object v27

    move-object/from16 v0, v27

    iput-object v0, v3, Lgnu/bytecode/LocalVarsAttr;->parameter_scope:Lgnu/bytecode/Scope;

    .line 217
    :cond_6
    iget-object v0, v3, Lgnu/bytecode/LocalVarsAttr;->parameter_scope:Lgnu/bytecode/Scope;

    move-object/from16 v24, v0

    .line 218
    .local v24, "scope":Lgnu/bytecode/Scope;
    move-object/from16 v0, v24

    iget-object v0, v0, Lgnu/bytecode/Scope;->end:Lgnu/bytecode/Label;

    move-object/from16 v27, v0

    if-nez v27, :cond_7

    .line 219
    new-instance v27, Lgnu/bytecode/Label;

    iget v0, v6, Lgnu/bytecode/CodeAttr;->PC:I

    move/from16 v28, v0

    invoke-direct/range {v27 .. v28}, Lgnu/bytecode/Label;-><init>(I)V

    move-object/from16 v0, v27

    move-object/from16 v1, v24

    iput-object v0, v1, Lgnu/bytecode/Scope;->end:Lgnu/bytecode/Label;

    .line 220
    :cond_7
    invoke-virtual/range {v18 .. v18}, Lgnu/bytecode/Method;->getConstants()Lgnu/bytecode/ConstantPool;

    move-result-object v8

    .line 221
    .local v8, "constants":Lgnu/bytecode/ConstantPool;
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v9

    .line 222
    .restart local v9    # "count":I
    move-object/from16 v0, v24

    iget-object v0, v0, Lgnu/bytecode/Scope;->start:Lgnu/bytecode/Label;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    iget v0, v0, Lgnu/bytecode/Label;->position:I

    move/from16 v23, v0

    .line 223
    .local v23, "prev_start":I
    move-object/from16 v0, v24

    iget-object v0, v0, Lgnu/bytecode/Scope;->end:Lgnu/bytecode/Label;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    iget v0, v0, Lgnu/bytecode/Label;->position:I

    move/from16 v22, v0

    .line 224
    .local v22, "prev_end":I
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_3
    if-ge v15, v9, :cond_0

    .line 226
    new-instance v26, Lgnu/bytecode/Variable;

    invoke-direct/range {v26 .. v26}, Lgnu/bytecode/Variable;-><init>()V

    .line 227
    .local v26, "var":Lgnu/bytecode/Variable;
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v25

    .line 228
    .restart local v25    # "start_pc":I
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    add-int v11, v25, v27

    .line 230
    .restart local v11    # "end_pc":I
    move/from16 v0, v25

    move/from16 v1, v23

    if-ne v0, v1, :cond_8

    move/from16 v0, v22

    if-eq v11, v0, :cond_b

    .line 233
    :cond_8
    :goto_4
    move-object/from16 v0, v24

    iget-object v0, v0, Lgnu/bytecode/Scope;->parent:Lgnu/bytecode/Scope;

    move-object/from16 v27, v0

    if-eqz v27, :cond_a

    move-object/from16 v0, v24

    iget-object v0, v0, Lgnu/bytecode/Scope;->start:Lgnu/bytecode/Label;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    iget v0, v0, Lgnu/bytecode/Label;->position:I

    move/from16 v27, v0

    move/from16 v0, v25

    move/from16 v1, v27

    if-lt v0, v1, :cond_9

    move-object/from16 v0, v24

    iget-object v0, v0, Lgnu/bytecode/Scope;->end:Lgnu/bytecode/Label;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    iget v0, v0, Lgnu/bytecode/Label;->position:I

    move/from16 v27, v0

    move/from16 v0, v27

    if-le v11, v0, :cond_a

    .line 235
    :cond_9
    move-object/from16 v0, v24

    iget-object v0, v0, Lgnu/bytecode/Scope;->parent:Lgnu/bytecode/Scope;

    move-object/from16 v24, v0

    goto :goto_4

    .line 236
    :cond_a
    move-object/from16 v21, v24

    .line 237
    .local v21, "parent":Lgnu/bytecode/Scope;
    new-instance v24, Lgnu/bytecode/Scope;

    .end local v24    # "scope":Lgnu/bytecode/Scope;
    new-instance v27, Lgnu/bytecode/Label;

    move-object/from16 v0, v27

    move/from16 v1, v25

    invoke-direct {v0, v1}, Lgnu/bytecode/Label;-><init>(I)V

    new-instance v28, Lgnu/bytecode/Label;

    move-object/from16 v0, v28

    invoke-direct {v0, v11}, Lgnu/bytecode/Label;-><init>(I)V

    move-object/from16 v0, v24

    move-object/from16 v1, v27

    move-object/from16 v2, v28

    invoke-direct {v0, v1, v2}, Lgnu/bytecode/Scope;-><init>(Lgnu/bytecode/Label;Lgnu/bytecode/Label;)V

    .line 238
    .restart local v24    # "scope":Lgnu/bytecode/Scope;
    move-object/from16 v0, v24

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Lgnu/bytecode/Scope;->linkChild(Lgnu/bytecode/Scope;)V

    .line 239
    move/from16 v23, v25

    .line 240
    move/from16 v22, v11

    .line 242
    .end local v21    # "parent":Lgnu/bytecode/Scope;
    :cond_b
    move-object/from16 v0, v24

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Lgnu/bytecode/Scope;->addVariable(Lgnu/bytecode/Variable;)V

    .line 243
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    move-object/from16 v0, v26

    move/from16 v1, v27

    invoke-virtual {v0, v1, v8}, Lgnu/bytecode/Variable;->setName(ILgnu/bytecode/ConstantPool;)V

    .line 244
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    move-object/from16 v0, v26

    move/from16 v1, v27

    invoke-virtual {v0, v1, v8}, Lgnu/bytecode/Variable;->setSignature(ILgnu/bytecode/ConstantPool;)V

    .line 245
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    move/from16 v0, v27

    move-object/from16 v1, v26

    iput v0, v1, Lgnu/bytecode/Variable;->offset:I

    .line 224
    add-int/lit8 v15, v15, 0x1

    goto/16 :goto_3

    .line 249
    .end local v3    # "attr":Lgnu/bytecode/LocalVarsAttr;
    .end local v6    # "code":Lgnu/bytecode/CodeAttr;
    .end local v8    # "constants":Lgnu/bytecode/ConstantPool;
    .end local v9    # "count":I
    .end local v11    # "end_pc":I
    .end local v15    # "i":I
    .end local v18    # "method":Lgnu/bytecode/Method;
    .end local v22    # "prev_end":I
    .end local v23    # "prev_start":I
    .end local v24    # "scope":Lgnu/bytecode/Scope;
    .end local v25    # "start_pc":I
    .end local v26    # "var":Lgnu/bytecode/Variable;
    :cond_c
    const-string v27, "Signature"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_d

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/Member;

    move/from16 v27, v0

    if-eqz v27, :cond_d

    .line 251
    new-instance v3, Lgnu/bytecode/SignatureAttr;

    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    check-cast p3, Lgnu/bytecode/Member;

    .end local p3    # "container":Lgnu/bytecode/AttrContainer;
    move/from16 v0, v27

    move-object/from16 v1, p3

    invoke-direct {v3, v0, v1}, Lgnu/bytecode/SignatureAttr;-><init>(ILgnu/bytecode/Member;)V

    goto/16 :goto_0

    .line 253
    .restart local p3    # "container":Lgnu/bytecode/AttrContainer;
    :cond_d
    const-string v27, "StackMapTable"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_e

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/CodeAttr;

    move/from16 v27, v0

    if-eqz v27, :cond_e

    .line 255
    move/from16 v0, p2

    new-array v10, v0, [B

    .line 256
    .local v10, "data":[B
    const/16 v27, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v27

    move/from16 v2, p2

    invoke-virtual {v0, v10, v1, v2}, Lgnu/bytecode/ClassFileInput;->readFully([BII)V

    .line 257
    new-instance v3, Lgnu/bytecode/StackMapTableAttr;

    check-cast p3, Lgnu/bytecode/CodeAttr;

    .end local p3    # "container":Lgnu/bytecode/AttrContainer;
    move-object/from16 v0, p3

    invoke-direct {v3, v10, v0}, Lgnu/bytecode/StackMapTableAttr;-><init>([BLgnu/bytecode/CodeAttr;)V

    goto/16 :goto_0

    .line 259
    .end local v10    # "data":[B
    .restart local p3    # "container":Lgnu/bytecode/AttrContainer;
    :cond_e
    const-string v27, "RuntimeVisibleAnnotations"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-eq v0, v1, :cond_f

    const-string v27, "RuntimeInvisibleAnnotations"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_11

    :cond_f
    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/Field;

    move/from16 v27, v0

    if-nez v27, :cond_10

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/Method;

    move/from16 v27, v0

    if-nez v27, :cond_10

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/ClassType;

    move/from16 v27, v0

    if-eqz v27, :cond_11

    .line 265
    :cond_10
    move/from16 v0, p2

    new-array v10, v0, [B

    .line 266
    .restart local v10    # "data":[B
    const/16 v27, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v27

    move/from16 v2, p2

    invoke-virtual {v0, v10, v1, v2}, Lgnu/bytecode/ClassFileInput;->readFully([BII)V

    .line 267
    new-instance v3, Lgnu/bytecode/RuntimeAnnotationsAttr;

    move-object/from16 v0, p1

    move-object/from16 v1, p3

    invoke-direct {v3, v0, v10, v1}, Lgnu/bytecode/RuntimeAnnotationsAttr;-><init>(Ljava/lang/String;[BLgnu/bytecode/AttrContainer;)V

    goto/16 :goto_0

    .line 269
    .end local v10    # "data":[B
    :cond_11
    const-string v27, "ConstantValue"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_12

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/Field;

    move/from16 v27, v0

    if-eqz v27, :cond_12

    .line 271
    new-instance v3, Lgnu/bytecode/ConstantValueAttr;

    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    move/from16 v0, v27

    invoke-direct {v3, v0}, Lgnu/bytecode/ConstantValueAttr;-><init>(I)V

    goto/16 :goto_0

    .line 273
    :cond_12
    const-string v27, "InnerClasses"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_14

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/ClassType;

    move/from16 v27, v0

    if-eqz v27, :cond_14

    .line 275
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v27

    mul-int/lit8 v9, v27, 0x4

    .line 276
    .restart local v9    # "count":I
    new-array v10, v9, [S

    .line 277
    .local v10, "data":[S
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_5
    if-ge v15, v9, :cond_13

    .line 279
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readShort()S

    move-result v27

    aput-short v27, v10, v15

    .line 277
    add-int/lit8 v15, v15, 0x1

    goto :goto_5

    .line 281
    :cond_13
    new-instance v3, Lgnu/bytecode/InnerClassesAttr;

    check-cast p3, Lgnu/bytecode/ClassType;

    .end local p3    # "container":Lgnu/bytecode/AttrContainer;
    move-object/from16 v0, p3

    invoke-direct {v3, v10, v0}, Lgnu/bytecode/InnerClassesAttr;-><init>([SLgnu/bytecode/ClassType;)V

    goto/16 :goto_0

    .line 283
    .end local v9    # "count":I
    .end local v10    # "data":[S
    .end local v15    # "i":I
    .restart local p3    # "container":Lgnu/bytecode/AttrContainer;
    :cond_14
    const-string v27, "EnclosingMethod"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_15

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/ClassType;

    move/from16 v27, v0

    if-eqz v27, :cond_15

    .line 285
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v5

    .line 286
    .local v5, "class_index":I
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v19

    .line 287
    .local v19, "method_index":I
    new-instance v3, Lgnu/bytecode/EnclosingMethodAttr;

    check-cast p3, Lgnu/bytecode/ClassType;

    .end local p3    # "container":Lgnu/bytecode/AttrContainer;
    move/from16 v0, v19

    move-object/from16 v1, p3

    invoke-direct {v3, v5, v0, v1}, Lgnu/bytecode/EnclosingMethodAttr;-><init>(IILgnu/bytecode/ClassType;)V

    goto/16 :goto_0

    .line 289
    .end local v5    # "class_index":I
    .end local v19    # "method_index":I
    .restart local p3    # "container":Lgnu/bytecode/AttrContainer;
    :cond_15
    const-string v27, "Exceptions"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_17

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/Method;

    move/from16 v27, v0

    if-eqz v27, :cond_17

    move-object/from16 v17, p3

    .line 291
    check-cast v17, Lgnu/bytecode/Method;

    .line 292
    .local v17, "meth":Lgnu/bytecode/Method;
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v9

    .line 293
    .restart local v9    # "count":I
    new-array v13, v9, [S

    .line 294
    .local v13, "exn_indices":[S
    const/4 v15, 0x0

    .restart local v15    # "i":I
    :goto_6
    if-ge v15, v9, :cond_16

    .line 295
    invoke-virtual/range {p0 .. p0}, Lgnu/bytecode/ClassFileInput;->readShort()S

    move-result v27

    aput-short v27, v13, v15

    .line 294
    add-int/lit8 v15, v15, 0x1

    goto :goto_6

    .line 296
    :cond_16
    move-object/from16 v0, v17

    invoke-virtual {v0, v13}, Lgnu/bytecode/Method;->setExceptions([S)V

    .line 297
    invoke-virtual/range {v17 .. v17}, Lgnu/bytecode/Method;->getExceptionAttr()Lgnu/bytecode/ExceptionsAttr;

    move-result-object v3

    goto/16 :goto_0

    .line 299
    .end local v9    # "count":I
    .end local v13    # "exn_indices":[S
    .end local v15    # "i":I
    .end local v17    # "meth":Lgnu/bytecode/Method;
    :cond_17
    const-string v27, "SourceDebugExtension"

    move-object/from16 v0, p1

    move-object/from16 v1, v27

    if-ne v0, v1, :cond_18

    move-object/from16 v0, p3

    instance-of v0, v0, Lgnu/bytecode/ClassType;

    move/from16 v27, v0

    if-eqz v27, :cond_18

    .line 301
    new-instance v3, Lgnu/bytecode/SourceDebugExtAttr;

    check-cast p3, Lgnu/bytecode/ClassType;

    .end local p3    # "container":Lgnu/bytecode/AttrContainer;
    move-object/from16 v0, p3

    invoke-direct {v3, v0}, Lgnu/bytecode/SourceDebugExtAttr;-><init>(Lgnu/bytecode/ClassType;)V

    .line 303
    .local v3, "attr":Lgnu/bytecode/SourceDebugExtAttr;
    move/from16 v0, p2

    new-array v10, v0, [B

    .line 304
    .local v10, "data":[B
    const/16 v27, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v27

    move/from16 v2, p2

    invoke-virtual {v0, v10, v1, v2}, Lgnu/bytecode/ClassFileInput;->readFully([BII)V

    .line 305
    iput-object v10, v3, Lgnu/bytecode/SourceDebugExtAttr;->data:[B

    .line 306
    move/from16 v0, p2

    iput v0, v3, Lgnu/bytecode/SourceDebugExtAttr;->dlength:I

    goto/16 :goto_0

    .line 311
    .end local v3    # "attr":Lgnu/bytecode/SourceDebugExtAttr;
    .end local v10    # "data":[B
    .restart local p3    # "container":Lgnu/bytecode/AttrContainer;
    :cond_18
    move/from16 v0, p2

    new-array v10, v0, [B

    .line 312
    .restart local v10    # "data":[B
    const/16 v27, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v27

    move/from16 v2, p2

    invoke-virtual {v0, v10, v1, v2}, Lgnu/bytecode/ClassFileInput;->readFully([BII)V

    .line 313
    new-instance v3, Lgnu/bytecode/MiscAttr;

    move-object/from16 v0, p1

    invoke-direct {v3, v0, v10}, Lgnu/bytecode/MiscAttr;-><init>(Ljava/lang/String;[B)V

    goto/16 :goto_0
.end method

.method public readAttributes(Lgnu/bytecode/AttrContainer;)I
    .locals 10
    .param p1, "container"    # Lgnu/bytecode/AttrContainer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 111
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v1

    .line 112
    .local v1, "count":I
    invoke-interface {p1}, Lgnu/bytecode/AttrContainer;->getAttributes()Lgnu/bytecode/Attribute;

    move-result-object v4

    .line 113
    .local v4, "last":Lgnu/bytecode/Attribute;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_6

    .line 115
    if-eqz v4, :cond_0

    .line 119
    :goto_1
    invoke-virtual {v4}, Lgnu/bytecode/Attribute;->getNext()Lgnu/bytecode/Attribute;

    move-result-object v7

    .line 120
    .local v7, "next":Lgnu/bytecode/Attribute;
    if-nez v7, :cond_3

    .line 126
    .end local v7    # "next":Lgnu/bytecode/Attribute;
    :cond_0
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v3

    .line 127
    .local v3, "index":I
    iget-object v8, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    iget-object v8, v8, Lgnu/bytecode/ClassType;->constants:Lgnu/bytecode/ConstantPool;

    const/4 v9, 0x1

    invoke-virtual {v8, v3, v9}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v6

    check-cast v6, Lgnu/bytecode/CpoolUtf8;

    .line 129
    .local v6, "nameConstant":Lgnu/bytecode/CpoolUtf8;
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readInt()I

    move-result v5

    .line 130
    .local v5, "length":I
    invoke-virtual {v6}, Lgnu/bytecode/CpoolUtf8;->intern()V

    .line 131
    iget-object v8, v6, Lgnu/bytecode/CpoolUtf8;->string:Ljava/lang/String;

    invoke-virtual {p0, v8, v5, p1}, Lgnu/bytecode/ClassFileInput;->readAttribute(Ljava/lang/String;ILgnu/bytecode/AttrContainer;)Lgnu/bytecode/Attribute;

    move-result-object v0

    .line 132
    .local v0, "attr":Lgnu/bytecode/Attribute;
    if-eqz v0, :cond_2

    .line 134
    invoke-virtual {v0}, Lgnu/bytecode/Attribute;->getNameIndex()I

    move-result v8

    if-nez v8, :cond_1

    .line 135
    invoke-virtual {v0, v3}, Lgnu/bytecode/Attribute;->setNameIndex(I)V

    .line 136
    :cond_1
    if-nez v4, :cond_4

    .line 137
    invoke-interface {p1, v0}, Lgnu/bytecode/AttrContainer;->setAttributes(Lgnu/bytecode/Attribute;)V

    .line 147
    :goto_2
    move-object v4, v0

    .line 113
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 122
    .end local v0    # "attr":Lgnu/bytecode/Attribute;
    .end local v3    # "index":I
    .end local v5    # "length":I
    .end local v6    # "nameConstant":Lgnu/bytecode/CpoolUtf8;
    .restart local v7    # "next":Lgnu/bytecode/Attribute;
    :cond_3
    move-object v4, v7

    .line 123
    goto :goto_1

    .line 140
    .end local v7    # "next":Lgnu/bytecode/Attribute;
    .restart local v0    # "attr":Lgnu/bytecode/Attribute;
    .restart local v3    # "index":I
    .restart local v5    # "length":I
    .restart local v6    # "nameConstant":Lgnu/bytecode/CpoolUtf8;
    :cond_4
    invoke-interface {p1}, Lgnu/bytecode/AttrContainer;->getAttributes()Lgnu/bytecode/Attribute;

    move-result-object v8

    if-ne v8, v0, :cond_5

    .line 142
    invoke-virtual {v0}, Lgnu/bytecode/Attribute;->getNext()Lgnu/bytecode/Attribute;

    move-result-object v8

    invoke-interface {p1, v8}, Lgnu/bytecode/AttrContainer;->setAttributes(Lgnu/bytecode/Attribute;)V

    .line 143
    const/4 v8, 0x0

    invoke-virtual {v0, v8}, Lgnu/bytecode/Attribute;->setNext(Lgnu/bytecode/Attribute;)V

    .line 145
    :cond_5
    invoke-virtual {v4, v0}, Lgnu/bytecode/Attribute;->setNext(Lgnu/bytecode/Attribute;)V

    goto :goto_2

    .line 150
    .end local v0    # "attr":Lgnu/bytecode/Attribute;
    .end local v3    # "index":I
    .end local v5    # "length":I
    .end local v6    # "nameConstant":Lgnu/bytecode/CpoolUtf8;
    :cond_6
    return v1
.end method

.method public readClassInfo()V
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/16 v9, 0x2f

    const/16 v8, 0x2e

    .line 72
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v6

    iput v6, v5, Lgnu/bytecode/ClassType;->access_flags:I

    .line 76
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v6

    iput v6, v5, Lgnu/bytecode/ClassType;->thisClassIndex:I

    .line 77
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    iget v5, v5, Lgnu/bytecode/ClassType;->thisClassIndex:I

    invoke-virtual {p0, v5}, Lgnu/bytecode/ClassFileInput;->getClassConstant(I)Lgnu/bytecode/CpoolClass;

    move-result-object v0

    .line 78
    .local v0, "clas":Lgnu/bytecode/CpoolClass;
    iget-object v5, v0, Lgnu/bytecode/CpoolClass;->name:Lgnu/bytecode/CpoolUtf8;

    iget-object v4, v5, Lgnu/bytecode/CpoolUtf8;->string:Ljava/lang/String;

    .line 79
    .local v4, "name":Ljava/lang/String;
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    invoke-virtual {v4, v9, v8}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v5, Lgnu/bytecode/ClassType;->this_name:Ljava/lang/String;

    .line 80
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "L"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ";"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lgnu/bytecode/ClassType;->setSignature(Ljava/lang/String;)V

    .line 82
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v6

    iput v6, v5, Lgnu/bytecode/ClassType;->superClassIndex:I

    .line 83
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    iget v5, v5, Lgnu/bytecode/ClassType;->superClassIndex:I

    if-nez v5, :cond_0

    .line 84
    iget-object v6, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    const/4 v5, 0x0

    check-cast v5, Lgnu/bytecode/ClassType;

    invoke-virtual {v6, v5}, Lgnu/bytecode/ClassType;->setSuper(Lgnu/bytecode/ClassType;)V

    .line 92
    :goto_0
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v3

    .line 93
    .local v3, "nInterfaces":I
    if-lez v3, :cond_1

    .line 95
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    new-array v6, v3, [Lgnu/bytecode/ClassType;

    iput-object v6, v5, Lgnu/bytecode/ClassType;->interfaces:[Lgnu/bytecode/ClassType;

    .line 96
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    new-array v6, v3, [I

    iput-object v6, v5, Lgnu/bytecode/ClassType;->interfaceIndexes:[I

    .line 97
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    if-ge v1, v3, :cond_1

    .line 99
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v2

    .line 100
    .local v2, "index":I
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    iget-object v5, v5, Lgnu/bytecode/ClassType;->interfaceIndexes:[I

    aput v2, v5, v1

    .line 101
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    iget-object v5, v5, Lgnu/bytecode/ClassType;->constants:Lgnu/bytecode/ConstantPool;

    const/4 v6, 0x7

    invoke-virtual {v5, v2, v6}, Lgnu/bytecode/ConstantPool;->getForced(II)Lgnu/bytecode/CpoolEntry;

    move-result-object v0

    .end local v0    # "clas":Lgnu/bytecode/CpoolClass;
    check-cast v0, Lgnu/bytecode/CpoolClass;

    .line 103
    .restart local v0    # "clas":Lgnu/bytecode/CpoolClass;
    iget-object v5, v0, Lgnu/bytecode/CpoolClass;->name:Lgnu/bytecode/CpoolUtf8;

    iget-object v5, v5, Lgnu/bytecode/CpoolUtf8;->string:Ljava/lang/String;

    invoke-virtual {v5, v9, v8}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v4

    .line 104
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    iget-object v5, v5, Lgnu/bytecode/ClassType;->interfaces:[Lgnu/bytecode/ClassType;

    invoke-static {v4}, Lgnu/bytecode/ClassType;->make(Ljava/lang/String;)Lgnu/bytecode/ClassType;

    move-result-object v6

    aput-object v6, v5, v1

    .line 97
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 87
    .end local v1    # "i":I
    .end local v2    # "index":I
    .end local v3    # "nInterfaces":I
    :cond_0
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    iget v5, v5, Lgnu/bytecode/ClassType;->superClassIndex:I

    invoke-virtual {p0, v5}, Lgnu/bytecode/ClassFileInput;->getClassConstant(I)Lgnu/bytecode/CpoolClass;

    move-result-object v0

    .line 88
    iget-object v5, v0, Lgnu/bytecode/CpoolClass;->name:Lgnu/bytecode/CpoolUtf8;

    iget-object v4, v5, Lgnu/bytecode/CpoolUtf8;->string:Ljava/lang/String;

    .line 89
    iget-object v5, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    invoke-virtual {v4, v9, v8}, Ljava/lang/String;->replace(CC)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lgnu/bytecode/ClassType;->setSuper(Ljava/lang/String;)V

    goto :goto_0

    .line 107
    .restart local v3    # "nInterfaces":I
    :cond_1
    return-void
.end method

.method public readConstants()Lgnu/bytecode/ConstantPool;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 67
    new-instance v0, Lgnu/bytecode/ConstantPool;

    invoke-direct {v0, p0}, Lgnu/bytecode/ConstantPool;-><init>(Ljava/io/DataInputStream;)V

    return-object v0
.end method

.method public readFields()V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 319
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v5

    .line 320
    .local v5, "nFields":I
    iget-object v7, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    iget-object v0, v7, Lgnu/bytecode/ClassType;->constants:Lgnu/bytecode/ConstantPool;

    .line 321
    .local v0, "constants":Lgnu/bytecode/ConstantPool;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    if-ge v4, v5, :cond_0

    .line 323
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v2

    .line 324
    .local v2, "flags":I
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v6

    .line 325
    .local v6, "nameIndex":I
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v1

    .line 326
    .local v1, "descriptorIndex":I
    iget-object v7, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    invoke-virtual {v7}, Lgnu/bytecode/ClassType;->addField()Lgnu/bytecode/Field;

    move-result-object v3

    .line 327
    .local v3, "fld":Lgnu/bytecode/Field;
    invoke-virtual {v3, v6, v0}, Lgnu/bytecode/Field;->setName(ILgnu/bytecode/ConstantPool;)V

    .line 328
    invoke-virtual {v3, v1, v0}, Lgnu/bytecode/Field;->setSignature(ILgnu/bytecode/ConstantPool;)V

    .line 329
    iput v2, v3, Lgnu/bytecode/Field;->flags:I

    .line 330
    invoke-virtual {p0, v3}, Lgnu/bytecode/ClassFileInput;->readAttributes(Lgnu/bytecode/AttrContainer;)I

    .line 321
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 332
    .end local v1    # "descriptorIndex":I
    .end local v2    # "flags":I
    .end local v3    # "fld":Lgnu/bytecode/Field;
    .end local v6    # "nameIndex":I
    :cond_0
    return-void
.end method

.method public readFormatVersion()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 60
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v1

    .line 61
    .local v1, "minor":I
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v0

    .line 62
    .local v0, "major":I
    iget-object v2, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    const/high16 v3, 0x10000

    mul-int/2addr v3, v0

    add-int/2addr v3, v1

    iput v3, v2, Lgnu/bytecode/ClassType;->classfileFormatVersion:I

    .line 63
    return-void
.end method

.method public readHeader()Z
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 51
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readInt()I

    move-result v0

    .line 52
    .local v0, "magic":I
    const v1, -0x35014542    # -8346975.0f

    if-eq v0, v1, :cond_0

    .line 53
    const/4 v1, 0x0

    .line 55
    :goto_0
    return v1

    .line 54
    :cond_0
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readFormatVersion()V

    .line 55
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public readMethods()V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 336
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v4

    .line 337
    .local v4, "nMethods":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v4, :cond_0

    .line 339
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v1

    .line 340
    .local v1, "flags":I
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v5

    .line 341
    .local v5, "nameIndex":I
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->readUnsignedShort()I

    move-result v0

    .line 342
    .local v0, "descriptorIndex":I
    iget-object v6, p0, Lgnu/bytecode/ClassFileInput;->ctype:Lgnu/bytecode/ClassType;

    const/4 v7, 0x0

    invoke-virtual {v6, v7, v1}, Lgnu/bytecode/ClassType;->addMethod(Ljava/lang/String;I)Lgnu/bytecode/Method;

    move-result-object v3

    .line 343
    .local v3, "meth":Lgnu/bytecode/Method;
    invoke-virtual {v3, v5}, Lgnu/bytecode/Method;->setName(I)V

    .line 344
    invoke-virtual {v3, v0}, Lgnu/bytecode/Method;->setSignature(I)V

    .line 345
    invoke-virtual {p0, v3}, Lgnu/bytecode/ClassFileInput;->readAttributes(Lgnu/bytecode/AttrContainer;)I

    .line 337
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 347
    .end local v0    # "descriptorIndex":I
    .end local v1    # "flags":I
    .end local v3    # "meth":Lgnu/bytecode/Method;
    .end local v5    # "nameIndex":I
    :cond_0
    return-void
.end method

.method public final skipAttribute(I)V
    .locals 4
    .param p1, "length"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 156
    const/4 v0, 0x0

    .line 157
    .local v0, "read":I
    :goto_0
    if-ge v0, p1, :cond_2

    .line 159
    sub-int v2, p1, v0

    int-to-long v2, v2

    invoke-virtual {p0, v2, v3}, Lgnu/bytecode/ClassFileInput;->skip(J)J

    move-result-wide v2

    long-to-int v1, v2

    .line 160
    .local v1, "skipped":I
    if-nez v1, :cond_1

    .line 162
    invoke-virtual {p0}, Lgnu/bytecode/ClassFileInput;->read()I

    move-result v2

    if-gez v2, :cond_0

    .line 163
    new-instance v2, Ljava/io/EOFException;

    const-string v3, "EOF while reading class files attributes"

    invoke-direct {v2, v3}, Ljava/io/EOFException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 165
    :cond_0
    const/4 v1, 0x1

    .line 167
    :cond_1
    add-int/2addr v0, v1

    .line 168
    goto :goto_0

    .line 169
    .end local v1    # "skipped":I
    :cond_2
    return-void
.end method
