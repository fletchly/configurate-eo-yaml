plugins {
    java
    `java-library`
}

group = "io.fletchly.configurate"
version = "4.2.0"
description = "YAML loader for Configurate implemented using eo-yaml."

repositories {
    mavenCentral()
}

dependencies {
    // configurate-core
    api("org.spongepowered:configurate-core:${project.property("configurateVersion")}")

    // eo-yaml
    implementation("com.amihaiemil.web:eo-yaml:8.0.6")

    // test dependencies
    testImplementation(platform("org.junit:junit-bom:6.0.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

java {
    withJavadocJar()
    withSourcesJar()
}
