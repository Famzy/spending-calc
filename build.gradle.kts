
val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.20"
    id("io.ktor.plugin") version "2.3.6"

    // id("com.github.johnrengelman.shadow") version "7.1.0"
}

group = "to.mpanaka"
version = "0.0.1"

application {
    mainClass.set("to.mpanaka.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    // val isDevelopment: Boolean = true

    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

// tasks {
//     shadowJar {
//         configurations = listOf(project.configurations["implementation"])
//       //  mainClassName = "to.mpanaka.ApplicationKt" // Update with your actual package name
//     }
// }

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("com.google.firebase:firebase-admin:9.2.0")
//    implementation("com.google.auth:google-auth-library-credentials:2.5.0")
//     implementation("com.google.auth:google-auth-library-oauth2-http:2.5.0")
//    implementation("io.ktor:ktor-jackson:2.3.6")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
