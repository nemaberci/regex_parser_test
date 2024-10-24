plugins {
    java
    `java-base`
    `java-library`
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven() {
        url = uri("https://maven.pkg.github.com/nemaberci/regex_parser_api")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
    maven() {
        url = uri("https://maven.pkg.github.com/nemaberci/regex_parser_generator")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
}

application {
    mainClass.set("hu.nemaberci.TestMain")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("junit:junit:4.13.2")
    api("hu.nemaberci:regex-api:1.0")
    testAnnotationProcessor("hu.nemaberci:code-gen:1.0.3")
    annotationProcessor("hu.nemaberci:code-gen:1.0.3")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}