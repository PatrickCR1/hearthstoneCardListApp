# hearthstoneCardListApp
Repository of Hearthstone CardList Application

This application shows a list of hearthstone cards to the user, showing name, rarity and cost on the first screen. If you click on any card, it navigates to a second
screen where the user have the image and all the informations on that card, incluinding name, flavor, description, rarity, set, type, faction, cost, attack and
health. The application uses connection to an API to obtain the list of hearthstone cards.

The app have the MVVM architecture and uses Koin to do the dependency injection. The View is composed of a main activity that hosts all the fragments, using navigation
with safe args to pass the data between the fragments. The first fragment of the application shows a list of cards with no filter, using a drawer layout to navigate to
the other fragments, each named by a different class, to show the user a list of cards filtered by the chosen class. 

The complete list and the class fragments shows the list through a RecyclerView, using an Adapter and a ViewHolder. The class fragments inherits from a base fragment,
to avoid boiler plate codes. The fragments have a load icon to show while the user waits the connection to the API to be completed.

The ViewModel is responsible with the navigation, the click listeners and connecting to the repository to get the cards that are shown. The repository connects to
the API. The API call uses Retrofit.

The application has 2 models, one for the API, and one domain model, to be used during the application. The application has support for
different device resolutions and orientation.

The idea of the application comes from a job test, and uses the Hearthstone API: https://rapidapi.com/omgvamp/api/hearthstone.
