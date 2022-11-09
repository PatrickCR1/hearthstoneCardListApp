# <p align="center"> Hearthstone CardList Application </p>

# Hearthstone Cardlist
###  <p align="start">  This application shows a list of hearthstone cards to the user, showing name, rarity and cost on the first screen. If you click on any card, it navigates to a second screen where the user have the image and all the informations on that card, incluinding name, flavor, description, rarity, set, type, faction, cost, attack and health. The application uses connection to an API to obtain the list of hearthstone cards. </p>

# :hammer: Project Features
### <p align="start"> The app have the MVVM architecture and uses Koin to do the dependency injection. The View is composed of a main activity that hosts all the fragments, using navigation with safe args to pass the data between the fragments. The first fragment of the application shows a list of cards with no filter, using a drawer layout to navigate to the other fragments, each named by a different class, to show the user a list of cards filtered by the chosen class. </p>

### The complete list and the class fragments shows the list through a RecyclerView, using an Adapter and a ViewHolder. The class fragments inherits from a base fragment, to avoid boiler plate codes. The fragments have a load icon to show while the user waits the connection to the API to be completed.

### The ViewModel is responsible with the navigation, the click listeners and connecting to the repository to get the cards that are shown. The repository connects to the API. The API call uses Retrofit.

### The application has 2 models, one for the API, and one domain model, to be used during the application. The application has support for different device resolutions and orientation.

# Tecnology applied:
### `Kotlin`
### `Android Studio`
### `Object-oriented programming`
### `MVVM Architecture`

# Resources:

### `Constraint Layout`: Feature to make the screen and components.
### `Jetpack Navigation`: Navigation between fragments.
### `Safe Args`: Sharing information between fragments.
### `Picasso`: Load images from internet.
### `Room:`: Data persistence: store data.
### `Retrofit:`: Make calls to an API, to get data and information needed to run the application.
### `Hearthstone Public API`: To get cards informations.
### `Koin`: Dependency Injection
### `Recycler View`: Feature to make lists.

## Dependencies

### You can [access the project dependencies here]().

## 📁 Access the project
### You can [acess the source code from the project](https://github.com/PatrickCR1/hearthstoneCardListApp/tree/Main) ou [download it](https://github.com/PatrickCR1/hearthstoneCardListApp/archive/refs/heads/Main.zip).

## 🛠️ Open and Run the project

After downloading the project, you can open it with Android Studio. To do that, on the launcher screen click in:

- **Open an Existing Project** (or similar option)

- Search where the project files are and select it (In case of zip download, you will need to extract it before searching).
- Then, click ok.

The Android Studio should execute some tasks from Gradle to configure the project, wait until it finishs. When it does, you can run the App.

# Autor
[<img src="https://avatars.githubusercontent.com/u/86331226?v=4" width=115><br><sub>Patrick Contarini Richard</sub>](https://github.com/PatrickCR1) 
