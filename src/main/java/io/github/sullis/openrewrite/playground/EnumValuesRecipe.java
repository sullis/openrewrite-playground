package io.github.sullis.openrewrite.playground;

import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.java.JavaIsoVisitor;


public class EnumValuesRecipe extends Recipe {
  @Override
  public String getDisplayName() {
    return "Java enum values";
  }

  @Override
  public String getDescription() {
    return "Java enum values";
  }

  @Override
  public JavaIsoVisitor<ExecutionContext> getVisitor() {
    return new EnumValuesVisitor();
  }
}
