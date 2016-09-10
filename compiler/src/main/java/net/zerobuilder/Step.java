package net.zerobuilder;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * <p>
 * An optional annotation on {@link Goal} parameters.
 * </p><p>
 * In the case of a <em>field</em> goal, this annotation goes on the <em>setters</em> of the target type.
 * </p>
 *
 * @see Goal
 * @see Builder
 */
@Retention(SOURCE)
@Target({PARAMETER, METHOD})
public @interface Step {

  /**
   * <p>Overrides the default position in the generated sequence of steps
   * for this parameter.</p>
   */
  int value();

}
