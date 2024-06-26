pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "Android_Task_Vodafone"
include(":app")
include(":core")
include(":data")
include(":features:current_weather:domain")
include(":features:forecast:domain")
include(":features:current_weather:presentation")
include(":features:forecast:presentation")
include(":features:city_input:presentation")
include(":features:city_input:domain")
include(":WeatherLib")
