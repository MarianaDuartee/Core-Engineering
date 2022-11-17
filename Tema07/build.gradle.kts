plugins {
    id("java")
}

group = "org.marianaduarte.tema08"
version = "1.0-SNAPSHOT"
var junitVersao = "org.junit.jupiter:junit-jupiter-api:5.8.1"

repositories {
    mavenCentral()
}

dependencies {

    testImplementation(junitVersao)
    testRuntimeOnly(junitVersao)
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
