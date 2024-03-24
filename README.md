## Key words:             
    * Jetpack Compose
    * Multi module
    * Dependency Management
    * Clean Architecture
    * Solid principles
    * MVVM, MVI
    * Dependency Injection
    * Unit tests 
    * CI/CD (Lint, Test, Build), using Github actions
    * Publishing lib to maven local
    * Navigation Components

## Modules:
     * :core (not depend on any other module)
     * :app (depend on all other modules)
     * :features:city_input 
     * :features:current_weather 
     * :features:forecast 
     * :data (depend on features domains, core)
     * Each module under features :
         - contains :domain | :presenton modules inside it where:
           - each :domain (depend on :core only)
           - each :presentation (depend on :core and :domain in the same feature)


## Libraries
    * Retrofit
    * Hilt
    * Coroutines
    * Flow
    * DataStore
    * Coil
    * Mockk
  
  
## Ci/Cd :
<img src="https://github.com/MinaAashraf/Android_Task_Vodafone/assets/48159614/361299ab-1e4d-4d6c-a575-fdad33cf1cf0">





