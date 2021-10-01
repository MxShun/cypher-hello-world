import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("io.gitlab.arturbosch.detekt") version "1.18.1"
	kotlin("jvm") version "1.5.31"
	kotlin("plugin.spring") version "1.5.31"
}

group = "cypher"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

detekt {
	buildUponDefaultConfig = true // preconfigure defaults
	allRules = false // activate all available (even unstable) rules.
	config = files("$projectDir/config/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior
	source = files(
		subprojects.flatMap {
			listOf(
				"${it.projectDir}/src/main/kotlin",
				"${it.projectDir}/src/test/kotlin"
			)
		}
	)
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
	// Target version of the generated JVM bytecode. It is used for type resolution.
	jvmTarget = "11"
}

tasks.withType<Test> {
	useJUnitPlatform()
}