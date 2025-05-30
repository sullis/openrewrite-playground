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
package io.github.sullis.openrewrite.playground.jackson;

import org.junit.jupiter.api.Test;
import org.openrewrite.DocumentExample;
import org.openrewrite.config.Environment;
import org.openrewrite.java.JavaParser;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

import static org.openrewrite.java.Assertions.java;
import static org.openrewrite.maven.Assertions.pomXml;


class UpgradeJackson_2_3Test implements RewriteTest {
    @Override
    public void defaults(RecipeSpec spec) {
        spec
          .parser(JavaParser.fromJavaVersion().classpath(
            "jackson-core", "jackson-core"))
          .recipe(Environment.builder()
            .scanRuntimeClasspath("io.github")
            .build()
            .activateRecipes("io.github.openrewrite.playground.jackson.UpgradeJackson_2_3")
          );
    }

    @DocumentExample
    @Test
    void jacksonUpgrade() {
        rewriteRun(
          //language=xml
          pomXml(
              """
                         <project>
                             <modelVersion>4.0.0</modelVersion>
                             <groupId>org.example</groupId>
                             <artifactId>example</artifactId>
                             <version>1.0.0</version>
                             <dependencies>
                                 <dependency>
                                     <groupId>io.netty</groupId>
                                     <artifactId>netty-common</artifactId>
                                     <version>4.1.110.Final</version>
                                 </dependency>
                                 <dependency>
                                     <groupId>io.netty</groupId>
                                     <artifactId>netty-buffer</artifactId>
                                     <version>4.1.110.Final</version>
                                 </dependency>
                             </dependencies>
                         </project>
                         """
          ),
          //language=java
          java(
            """
              import org.apache.commons.collections.CollectionUtils;
              import org.apache.commons.collections.map.IdentityMap;
              import org.apache.commons.collections.MapUtils;
              import org.apache.commons.collections.FastArrayList;

              import java.util.Map;

              class Test {
                  static void helloApacheCollections() {
                      Object[] input = new Object[] { "one", "two" };
                      CollectionUtils.reverseArray(input);
                      IdentityMap identityMap = new IdentityMap();
                      Map emptyMap = MapUtils.EMPTY_MAP;
                      FastArrayList fastList = new FastArrayList(100);
                  }
              }
              """,
            """
              import org.apache.commons.collections4.CollectionUtils;

              import java.util.Collections;
              import java.util.IdentityHashMap;
              import java.util.Map;
              import java.util.concurrent.CopyOnWriteArrayList;

              class Test {
                  static void helloApacheCollections() {
                      Object[] input = new Object[] { "one", "two" };
                      CollectionUtils.reverseArray(input);
                      IdentityHashMap identityMap = new IdentityHashMap();
                      Map emptyMap = Collections.emptyMap();
                      CopyOnWriteArrayList fastList = new CopyOnWriteArrayList(100);
                  }
              }
              """
          )
        );
    }
}
