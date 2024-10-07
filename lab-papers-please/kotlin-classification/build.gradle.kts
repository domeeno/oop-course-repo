plugins {
    kotlin("jvm") version "1.9.23"
    kotlin("plugin.serialization") version "2.0.20"
}

group = "oop.practice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.18.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}