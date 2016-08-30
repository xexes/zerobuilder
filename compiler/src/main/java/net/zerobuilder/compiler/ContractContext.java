package net.zerobuilder.compiler;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;

import static com.google.common.base.Optional.absent;
import static com.google.common.collect.Iterables.toArray;
import static com.squareup.javapoet.MethodSpec.methodBuilder;
import static com.squareup.javapoet.TypeSpec.interfaceBuilder;
import static javax.lang.model.element.ElementKind.CONSTRUCTOR;
import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.element.Modifier.PUBLIC;

final class ContractContext {

  private final MyContext context;

  ContractContext(MyContext context) {
    this.context = context;
  }

  ImmutableList<ClassName> stepInterfaceNames() {
    ImmutableList.Builder<ClassName> specs = ImmutableList.builder();
    for (StepSpec spec : context.stepSpecs) {
      specs.add(spec.stepName);
    }
    return specs.build();
  }

  ImmutableList<TypeSpec> stepInterfaces() {
    ImmutableList.Builder<TypeSpec> specs = ImmutableList.builder();
    for (StepSpec spec : context.stepSpecs) {
      specs.add(spec.asInterface(context.maybeAddPublic()));
    }
    return specs.build();
  }

  Optional<TypeSpec> updaterInterface() {
    if (!context.toBuilder()) {
      return absent();
    }
    MethodSpec buildMethod = methodBuilder("build")
        .returns(context.buildVia.getKind() == CONSTRUCTOR
            ? ClassName.get(context.buildElement)
            : TypeName.get(context.buildVia.getReturnType()))
        .addModifiers(PUBLIC, ABSTRACT)
        .build();
    return Optional.of(interfaceBuilder(context.contractUpdaterName())
        .addMethod(buildMethod)
        .addMethods(updateMethods())
        .addModifiers(toArray(context.maybeAddPublic(), Modifier.class))
        .build());
  }

  private ImmutableList<MethodSpec> updateMethods() {
    ClassName updaterName = context.contractUpdaterName();
    ImmutableList.Builder<MethodSpec> builder = ImmutableList.builder();
    for (StepSpec spec : context.stepSpecs) {
      builder.add(spec.asUpdaterInterfaceMethod(updaterName));
    }
    return builder.build();
  }


}