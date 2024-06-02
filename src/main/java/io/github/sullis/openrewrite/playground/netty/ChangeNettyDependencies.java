package io.github.sullis.openrewrite.playground.netty;

import org.openrewrite.internal.lang.Nullable;
import org.openrewrite.java.dependencies.ChangeDependency;


public class ChangeNettyDependencies
  extends ChangeDependency {
  public ChangeNettyDependencies(String oldGroupId, String oldArtifactId, @Nullable String newGroupId,
      @Nullable String newArtifactId, @Nullable String newVersion, @Nullable String versionPattern,
      @Nullable Boolean overrideManagedVersion, @Nullable Boolean changeManagedDependency) {
    super(oldGroupId, oldArtifactId, newGroupId, newArtifactId, newVersion, versionPattern, overrideManagedVersion,
        changeManagedDependency);
  }
}
