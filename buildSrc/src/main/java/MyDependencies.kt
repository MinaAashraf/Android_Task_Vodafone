import Versions.coil_version
import Versions.compose_viewmodel_version
import Versions.coroutinesVersion
import Versions.coroutines_test_version
import Versions.dataStore_version
import Versions.hiltVersion
import Versions.hilt_compose_verison
import Versions.lifecycle_version
import Versions.mockito_version
import Versions.nav_version
import Versions.weather_formatter_version

object Versions {
    const val versionRetrofit = "2.10.0"
    const val versionRetrofitCoroutinesAdapter = "0.9.2"
    const val coroutinesVersion = "1.8.1-Beta"
    const val hiltVersion = "2.48"
    const val lifecycle_version = "2.7.0"
    const val dataStore_version = "1.0.0"
    const val nav_version = "2.7.7"
    const val hilt_compose_verison = "1.1.0"
    const val compose_viewmodel_version = "2.6.1"
    const val coil_version = "2.6.0"
    const val mockito_version = "1.13.10"
    const val coroutines_test_version = "1.8.1-Beta"
    const val weather_formatter_version = "1.0"


}

object MyDependencies {
    // hilt
    const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
    const val kapt = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    const val hiltWithCompose =  "androidx.hilt:hilt-navigation-compose:$hilt_compose_verison"

    // Coroutines
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutinesVersion"
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.versionRetrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.versionRetrofit}"


    // ViewModel
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version"
    const val lifeCycle = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version"

    // Compose
    const val composeActivity = "androidx.activity:activity-compose:1.7.0"
    const val composeBom = "androidx.compose:compose-bom:2023.08.00"
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeGraphics = "androidx.compose.ui:ui-graphics"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeMaterial3 = "androidx.compose.material3:material3"
    const val composeUiText = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"

    //Datastore
    const val dataStore = "androidx.datastore:datastore-preferences:$dataStore_version"

    // Navigation
    const val navigation = "androidx.navigation:navigation-compose:$nav_version"
    // Coil
    const val coil = "io.coil-kt:coil-compose:$coil_version"

    // Mockito
    const val mockito = "io.mockk:mockk:$mockito_version"

    // coroutines test
    const val  coroutinesTest= "org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutines_test_version"

    // WeatherFormatter (my custom lib)
    const val weatherFormatter = "com.weather:formatter:$weather_formatter_version"

}