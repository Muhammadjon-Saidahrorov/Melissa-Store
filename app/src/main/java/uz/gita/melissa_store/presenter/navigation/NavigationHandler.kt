package uz.gita.melissa_store.presenter.navigation

import cafe.adriel.voyager.navigator.Navigator
import kotlinx.coroutines.flow.Flow

typealias NavigationArgs = Navigator.() -> Unit

interface NavigationHandler {
    val navigationStack: Flow<NavigationArgs>
}