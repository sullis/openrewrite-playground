
buildscript {
    repositories {
        gradlePluginPortal()
    }
}

plugins {
    java
    `java-library`
}

group = "io.github.sullis"
description = "openrewrite-playground"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

val openrewriteVersion = "8.23.3"

dependencies {
    implementation(platform("org.openrewrite:rewrite-bom:$openrewriteVersion"))
    implementation("org.openrewrite:rewrite-core")
    implementation("org.openrewrite:rewrite-java")
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.25.2")

    testImplementation("org.openrewrite:rewrite-java-17")
    testImplementation("org.openrewrite:rewrite-test")
    testImplementation("org.openrewrite:rewrite-maven")
}

tasks.test {
    useJUnitPlatform()
    failFast = true
    maxParallelForks = 1
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
    toolchain {
        languageVersion = JavaLanguageVersion.of(11)
    }
}
