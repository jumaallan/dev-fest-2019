# \[ 🚧 Work in progress 👷‍♀️⛏👷🔧️👷🔧 🚧 \] DevFest19


👀  Writing DevFest19 App using [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/), in 100% Kotlin. 

This goes without saying, much help from:
 
* :camel: @wangerekaharun [Harun Wangereka](https://github.com/wangerekaharun), Android Developer @ Apps:Lab - help with many things along the way
 
* :camel: @JabezNzomo99 [Jabez Nzomo](https://github.com/JabezNzomo99), a student and an Android Maestro - helping with writing tests for this codebase.

* :camel: @etonotieno [Eton Otieno](https://github.com/etonotieno), a self taughtdev and an Kotlin Ninja - help with writing the code base - open for job offers.

The code is open for external contributions and PRs! :rocket: 

### Background

This is a basic app that shows how to use Dynamic App Modules, which allow you to separate certain features and resources from the base module of your app and include them in your App Bundle. 

Users can download and install these modules later on demand after they've already installed the base APK of the app using Dynamic Delivery. 

### Features

This app uses the following technologies:

> Kotlin - core language

> MVVM Architecture - ViewModel, LiveData, Paging, Navigation 

> Room DB - Offline local persistence

> KOIN - Dependency Injection

> Dynamic App Modules

> App Bundles 

> Firebase - Performance, Crashlytics, Analytics

The app only acts as a guide on how to use this components. You can refer to the relevant documentation from the official Android Documentation. 

We will try to keep this repo up to date, as newer technologies come up, until we retire it during the DevFest20.


### Modules

This app has the following modules:

> core - This is an Android Library, and contains the shared code across modules 

> movies - show movies info

> music - show music info

> news - show news info

> weather - show weather info

Each module will be connected to an external public api, to pull random data.

### Credits

Just crediting various resources that helped shape up this project:

* Icons - [icons8](https://icons8.com)