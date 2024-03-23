plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.android_task_vodafone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android_task_vodafone"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation(project(":core"))
    implementation(project(":data"))
    implementation(project(":features:city_input:domain"))
    implementation(project(":features:forecast:domain"))
    implementation(project(":features:current_weather:domain"))
    implementation(project(":features:city_input:presentation"))
    implementation(project(":features:forecast:presentation"))
    implementation(project(":features:current_weather:presentation"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    //Compose
    implementation(MyDependencies.composeActivity)
    implementation(platform(MyDependencies.composeBom))
   // implementation(platform(MyDependencies.composeViewModel))
    implementation(MyDependencies.composeUi)
    implementation(MyDependencies.composeGraphics)
    implementation(MyDependencies.composePreview)
    implementation(MyDependencies.composeMaterial3)
    androidTestImplementation(platform(MyDependencies.composeBom))
    androidTestImplementation(MyDependencies.composeUiText)
    debugImplementation(MyDependencies.composeUiTooling)
    debugImplementation(MyDependencies.composeUiTestManifest)


    // hilt
    implementation(MyDependencies.hilt)
    implementation(MyDependencies.hiltWithCompose)
    kapt(MyDependencies.kapt)

    // Retrofit
    implementation(MyDependencies.retrofit)
    implementation(MyDependencies.gsonConverter)

    // Navigation
    implementation(MyDependencies.navigation)



}

kapt {
    correctErrorTypes = true
}

