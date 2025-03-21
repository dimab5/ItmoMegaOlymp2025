package itmo.megaolympiada.newsapplication.ui.pages

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import itmo.megaolympiada.newsapplication.ui.viewModels.NewsViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import itmo.megaolympiada.newsapplication.ui.components.NewsComponent
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewsPage(newsViewModel: NewsViewModel = hiltViewModel()) {
    val news by newsViewModel.news.collectAsState()

    LaunchedEffect(Unit) {
        newsViewModel.fetchNews()
    }

    if (news != null) {
        LazyColumn {
            item {
                Text(
                    text = "Found ${news!!.totalResults} news. See this below!",
                    Modifier.padding(10.dp)
                )
            }
            items(news!!.articles) { article ->
                NewsComponent(article)
            }
        }
    }
    else {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp),
            strokeWidth = 8.dp,
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}