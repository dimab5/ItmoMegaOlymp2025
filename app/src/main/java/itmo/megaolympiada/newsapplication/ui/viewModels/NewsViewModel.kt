package itmo.megaolympiada.newsapplication.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import itmo.megaolympiada.newsapplication.api.config.NewsApiConfig
import itmo.megaolympiada.newsapplication.api.models.NewsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(): ViewModel() {
    private val _news = MutableStateFlow<NewsResponse?>(null)
    val news: StateFlow<NewsResponse?> = _news

    fun fetchNews() {
        viewModelScope.launch {
            try {
                _news.value = NewsApiConfig.createNewsApi().getNews("wsj.com", NewsApiConfig.API_KEY)
            } catch (e: Exception) {
                Log.e("Api error", e.message.toString())
            }
        }
    }
}