package net.zerobuilder.examples.basic;

import org.junit.Test;

import static net.zerobuilder.examples.basic.FieldAccessBuilders.fieldAccessBuilder;
import static net.zerobuilder.examples.basic.FieldAccessBuilders.fieldAccessToBuilder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FieldAccessTest {

  @Test
  public void basicTest() {
    FieldAccess getters = fieldAccessBuilder().length(12).width(10).height(11);
    assertThat(getters.length, is(12d));
    assertThat(getters.width, is(10d));
    assertThat(getters.height, is(11d));
    getters = fieldAccessToBuilder(getters).length(0).build();
    assertThat(getters.length, is(0d));
    assertThat(getters.width, is(10d));
    assertThat(getters.height, is(11d));
  }


}