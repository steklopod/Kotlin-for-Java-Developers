import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "ru.steklopod"
version = "1.0-SNAPSHOT"

plugins {
    java
    application
    kotlin("jvm") version "1.3.0-release-212"
}


dependencies {
    compile group : 'org.jetbrains', name: 'annotations', version: '16.0.3'

    testCompile("junit:junit:4.12")
    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
    testCompile(kotlin("test"))
    testCompile(kotlin("test-junit"))
}

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

kapt {
    useBuildCache = true
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict", "-Xjvm-default=enable")
    }
}

task<Wrapper>("wrapper") {
    gradleVersion = "4.10.2"
    distributionType = Wrapper.DistributionType.ALL
}