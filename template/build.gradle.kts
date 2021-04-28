plugins {
    kotlin("js") version "1.4.32"
}

group = "com.kumatheta"
version = "1.0"

repositories {
    jcenter()
    mavenLocal()
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains:kotlin-react:17.0.0-pre.133-kotlin-1.4.21")
    implementation("org.jetbrains:kotlin-extensions:1.0.1-pre.133-kotlin-1.4.21")
    implementation(npm("react", "17.0.2"))
    implementation(npm("react-native", "0.64.0"))
    implementation(npm("react-native-navigation", "^7.1.0"))
}

kotlin {
    js(IR) {
        moduleName = "shared"
        nodejs {
        }
        useCommonJs()
        binaries.executable()
    }
}

val reactNativeDir = "react"

val srcDirs = arrayOf(
    layout.buildDirectory.dir("compileSync/kotlin"),
    layout.buildDirectory.dir("tmp/publicPackageJson"),
    layout.buildDirectory.dir("processedResources/js/main")
)
val generatedDir = "$reactNativeDir/generated"

tasks.register<Copy>("copyDevelopment") {
    group = "kotlin react native"
    dependsOn("developmentExecutableCompileSync", "publicPackageJson")
    from(*srcDirs)
    into(generatedDir)
}
tasks.register<Copy>("copyProduction") {
    group = "kotlin react native"
    dependsOn("productionExecutableCompileSync", "publicPackageJson")
    from(*srcDirs)
    into(generatedDir)
}
tasks.register<Copy>("cleanCopyDevelopment") {
    group = "kotlin react native"
    dependsOn("developmentExecutableCompileSync", "publicPackageJson")
    doFirst {
        delete(generatedDir)
    }
    from(*srcDirs)
    into(generatedDir)
}
tasks.register<Copy>("cleanCopyProduction") {
    group = "kotlin react native"
    dependsOn("productionExecutableCompileSync", "publicPackageJson")
    doFirst {
        delete(generatedDir)
    }
    from(*srcDirs)
    into(generatedDir)
}
