package net.zerobuilder.compiler;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;

final class Utilities {

  static String upcase(String s) {
    return LOWER_CAMEL.to(UPPER_CAMEL, s);
  }

  static String downcase(String s) {
    return UPPER_CAMEL.to(LOWER_CAMEL, s);
  }

  static CodeBlock statement(String format, Object... args) {
    return CodeBlock.builder().addStatement(format, args).build();
  }

  static ParameterSpec parameterSpec(TypeName type, String name) {
    return ParameterSpec.builder(type, name).build();
  }

  private Utilities() {
    throw new UnsupportedOperationException("no instances");
  }
}
