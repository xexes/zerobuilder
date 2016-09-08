package net.zerobuilder.examples.basic;

import net.zerobuilder.Builder;
import net.zerobuilder.Goal;

@Builder
final class Getters {

  private final double lenght;
  private final double width;
  private final double height;

  @Goal(toBuilder = true)
  Getters(double lenght, double width, double height) {
    this.lenght = lenght;
    this.width = width;
    this.height = height;
  }

  double getLenght() {
    return lenght;
  }

  double getWidth() {
    return width;
  }

  double getHeight() {
    return height;
  }
}
