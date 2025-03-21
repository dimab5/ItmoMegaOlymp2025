package itmo.megaolympiada.newsapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import itmo.megaolympiada.newsapplication.api.models.Article

@Composable
fun NewsComponent(article: Article) {
    Box {
        AsyncImage(
            model = article.urlToImage,
            contentDescription = "Translated description of what the image contains"
        )

        Text(
            text = article.title ?: "Article hasn't title",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start),
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
                .border(2.dp, MaterialTheme.colors.secondary, shape)
                .background(MaterialTheme.colors.primary, shape)
                .padding(16.dp)
        )
    }
}