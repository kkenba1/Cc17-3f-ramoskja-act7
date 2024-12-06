buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
        classpath(libs.gradle.v810) // Adjust to your version
        classpath(libs.kotlin.gradle.plugin.v180) // Adjust to your Kotlin version
    }
}


