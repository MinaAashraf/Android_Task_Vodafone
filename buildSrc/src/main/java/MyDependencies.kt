import Versions.coroutinesVersion
import Versions.dataStore_version
import Versions.hiltVersion
import Versions.lifecycle_version

object Versions {
    const val versionRetrofit = "2.10.0"
    const val versionRetrofitCoroutinesAdapter = "0.9.2"
    const val coroutinesVersion = "1.8.1-Beta"
    const val hiltVersion = "2.48"
    const val lifecycle_version = "2.7.0"
    const val dataStore_version = "1.0.0"
}

object MyDependencies {
    // hilt
    const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
    const val kapt = "com.google.dagger:hilt-android-compiler:$hiltVersion"

    /* // hilt

     "com.google.dagger:hilt-android:2.48"
     ksp("com.google.dagger:hilt-android-compiler:2.48")

     const val hilt = "androidx.hilt:hilt-navigation-compose:1.1.0"

     const val dataStore ="androidx.datastore:datastore-preferences:1.0.0"
 */
    // Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"
    //  const val coroutinesPlayServices = "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.1"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.versionRetrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.versionRetrofit}"

    // Retrofit Coroutines Support
    //const val retrofitCoroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:$${Versions.versionRetrofitCoroutinesAdapter}"


    // ViewModel
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"

    // Compose
    const val composeActivity = "androidx.activity:activity-compose:1.7.0"
    const val composeBom = "androidx.compose:compose-bom:2023.08.00"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeUiText = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"

    //Datastore
    const val dataStore ="androidx.datastore:datastore-preferences:$dataStore_version"

}