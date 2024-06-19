/*
 * Copyright 2024 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
