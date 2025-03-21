package itmo.megaolympiada.newsapplication.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import itmo.megaolympiada.newsapplication.ui.pages.AuthPage
import itmo.megaolympiada.newsapplication.ui.pages.NewsPage

sealed class Routes(val route: String) {
    data object Auth : Routes("auth")
    data object News : Routes("news")
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.Auth.route) {
        composable(Routes.Auth.route) { AuthPage() }
        composable(Routes.News.route) { NewsPage() }
    }
}