

plugins {
    id("com.android.application")
    id("androidx.navigation.safeargs")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.example.mycityapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.mycityapp"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}
dependencies {
    dependencies {
        implementation(libs.androidx.navigation.fragment.ktx.v253) {
            exclude(group = "xpp3", module = "xpp3")
            exclude(group = "xmlpull", module = "xmlpull")
        }
        implementation(libs.androidx.navigation.ui.ktx.v253) {
            exclude(group = "xpp3", module = "xpp3")
            exclude(group = "xmlpull", module = "xmlpull")
        }
        implementation(libs.androidx.navigation.safe.args.generator) {
            exclude(group = "xpp3", module = "xpp3")
            exclude(group = "xmlpull", module = "xmlpull")
        }

        implementation(libs.material.v160)
        implementation(libs.androidx.lifecycle.viewmodel.ktx.v262)
        implementation(libs.androidx.lifecycle.livedata.ktx.v262)
        implementation(libs.recyclerview)
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)

        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.espresso.core)
        implementation(kotlin("script-runtime"))
    }


}
