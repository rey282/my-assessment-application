# My Assessment Application

## Overview
This Android app was developed for the NIT3213 Final Assignment.  
It connects to the provided API (`https://nit3213api.onrender.com/`) and demonstrates:
- Login with API authentication
- Displaying data in a Dashboard
- Viewing details on a separate screen
- Using Koin for dependency injection

---

## Features
1. Login Screen
    - Enter First Name (username) and Student ID (password).
    - Makes a POST request to authenticate.
    - On success, receives a `keypass` and opens the Dashboard.

2. Dashboard Screen
    - Uses `RecyclerView` to list entities from the `/dashboard/{keypass}` endpoint.
    - Shows two summary fields (e.g., `itemName` + `material`, or `exerciseName` + `muscleGroup`).
    - Works with different API data structures.
    - Clicking an item opens the Details screen.

3. Details Screen
    - Displays all information for the selected entity.
    - Automatically adapts to any API fields (fashion, exercises, etc.).

---

## Technology Used
- Kotlin (Android)
- Retrofit + Gson (API requests + JSON parsing)
- RecyclerView (list display)
- Koin (dependency injection)

---

## Project Structure
MainActivity.kt -> Login screen
DashboardActivity.kt -> Dashboard with RecyclerView
DetailsActivity.kt -> Shows entity details
ApiService.kt -> Retrofit API interface
AppModule.kt -> Koin DI module (provides Retrofit + ApiService)
MyAssessmentApp.kt -> Application class (starts Koin)
EntityAdapter.kt -> RecyclerView adapter
DashboardResponse.kt -> API response model
LoginRequest.kt -> Login payload
LoginResponse.kt -> Login response

## How to Run
1. Open the project in Android Studio.
2. Connect a device or use an emulator.
3. Run the app.
4. Use:
    - Username = Your first name
    - Password = Student ID without the “s”.

---

## Notes
- The app supports different APIs since it dynamically handles entity fields.
- Koin is used instead of Hilt for simpler dependency injection setup.  