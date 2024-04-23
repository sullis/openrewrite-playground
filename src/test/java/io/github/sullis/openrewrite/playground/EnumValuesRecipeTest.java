package io.github.sullis.openrewrite.playground;

import org.junit.jupiter.api.Test;
import org.openrewrite.java.JavaParser;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.assertj.core.api.Assertions.assertThat;


public class EnumValuesRecipeTest implements RewriteTest {
  @Override
  public void defaults(RecipeSpec spec) {
    spec
        .recipe(new EnumValuesRecipe())
        .parser(JavaParser.fromJavaVersion());
  }

  @Test
  void helloWorld() {
    assertThat(true).isTrue();
  }
}
