package itmo.megaolympiada.newsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import itmo.megaolympiada.newsapplication.ui.pages.NewsPage
import itmo.megaolympiada.newsapplication.ui.theme.NewsApplicationTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            NewsApplicationTheme {
                NewsPage()
            }
        }
    }
}