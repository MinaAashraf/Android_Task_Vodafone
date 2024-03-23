plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.android_task_vodafone.features.forecast.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation(project(":core"))
    implementation(project(":features:forecast:domain"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Compose
    implementation(MyDependencies.composeActivity)
    implementation(platform(MyDependencies.composeBom))
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
    kapt(MyDependencies.kapt)

    //ViewModel
    implementation(MyDependencies.viewModel)
    implementation(MyDependencies.lifeCycle)

    // Navigation
    implementation(MyDependencies.navigation)

    // Mockito
    testImplementation(MyDependencies.mockito)

    // Coroutines Test
    testImplementation(MyDependencies.coroutinesTest)


}
kapt {
    correctErrorTypes = true
}