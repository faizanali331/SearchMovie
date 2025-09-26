# SearchMovie – Android App

SearchMovie is an Android application built with **Kotlin** and **Jetpack Compose** that allows users to search for movies and view detailed information fetched from the OMDb API.

---

##  Features

-  **Search movies** by title with live updates.
-  **View detailed movie information** (poster, IMDb rating, actors, awards, genre, runtime, etc.).
-  **Modern UI** built entirely with Jetpack Compose.
-  **MVVM architecture** with ViewModel, Repository, and StateFlow.
-  **Retrofit integration** for API calls.
-  **Kotlin Coroutines** for asynchronous and smooth data fetching.
-  **Coil** for image loading.

---

##  Tech Stack

| Technology / Library | Purpose |
|----------------------|---------|
| **Kotlin** | Programming language for Android |
| **Jetpack Compose** | Declarative UI toolkit used to build screens (`HomeScreen`, `MovieDetail`) |
| **Material 3 Components** | Modern UI elements (TextField, Icon, Text) |
| **MVVM Architecture** | Separates UI, business logic, and data access layers |
| **ViewModel** (androidx.lifecycle) | Manages UI-related data and survives configuration changes |
| **StateFlow** | Reactive state management for UI updates |
| **Coroutines** (kotlinx.coroutines) | Handles background API calls asynchronously |
| **Retrofit** (square/retrofit2) | REST client for making HTTP requests to the OMDb API |
| **Gson Converter** (converter-gson) | Converts JSON responses from OMDb API into Kotlin data classes |
| **Coil** (coil3.compose) | Efficiently loads and displays images from URLs |
| **Navigation-Compose** | Handles screen-to-screen navigation within Jetpack Compose |
| **AndroidX Lifecycle ViewModel Compose** | Injects ViewModel into Composables easily |

---

##  Project Structure

com.example.searchmovie/
├── MainActivity.kt # App entry point, sets up AppNavigation
├── HomeScreen.kt # UI for movie search results
├── MovieDetail.kt # UI for detailed movie information
├── MovieViewModel.kt # ViewModel managing movie data and API calls
├── MovieRepository.kt # Repository fetching data from OMDb API
├── navigation/
│ └── AppNavigation.kt # Compose Navigation between HomeScreen and MovieDetail
├── component/
│ ├── SearchField.kt # Reusable Search bar UI component
│ └── MovieSearchedUI.kt # UI for a single movie item in the list
├── api/
│ ├── MovieApiService.kt # Retrofit interface defining API endpoints
│ └── RetrofitClient.kt # Creates Retrofit instance for API calls
└── model/
├── Movie.kt # Data class for movie details
├── MovieList.kt # Data class for movie search response
└── Search.kt # Data class for a single movie item


---

##  API Integration

- **Base URL**: `https://www.omdbapi.com/`
- **Endpoints**:
  - `GET ?s=<title>&apikey=<apiKey>` → Search movies.
  - `GET ?i=<imdbID>&apikey=<apiKey>` → Get detailed movie info.
- **API Key**: Replace the default key in `RetrofitClient.kt` with your own OMDb API key if needed.

---

##  Dependencies Used

Add these to your `build.gradle (Module: app)`:

```gradle
dependencies {
    // Kotlin + Coroutines
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:<latest-version>"

    // Jetpack Compose UI
    implementation "androidx.compose.ui:ui:<latest-version>"
    implementation "androidx.compose.material3:material3:<latest-version>"
    implementation "androidx.compose.ui:ui-tooling-preview:<latest-version>"
    debugImplementation "androidx.compose.ui:ui-tooling:<latest-version>"

    // Lifecycle + ViewModel
    implementation "androidx.lifecycle:lifecycle-runtime-ktx:<latest-version>"
    implementation "androidx.lifecycle:lifecycle-viewmodel-compose:<latest-version>"

    // Navigation for Compose
    implementation "androidx.navigation:navigation-compose:<latest-version>"

    // Retrofit + Gson
    implementation "com.squareup.retrofit2:retrofit:<latest-version>"
    implementation "com.squareup.retrofit2:converter-gson:<latest-version>"

    // Coil for image loading
    implementation "io.coil-kt:coil-compose:<latest-version>"
}


### Setup & Run

Clone the repository:
git clone https://github.com/faizanali331/searchmovie.git


Open in Android Studio.

Add your OMDb API key inside RetrofitClient.kt.
Sync Gradle and run on an emulator or device.
