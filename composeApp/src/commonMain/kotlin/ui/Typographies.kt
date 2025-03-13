package ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class Typographies {
    companion object {
        @Composable
        fun H1(text: String) {
            Text(text = text, style = MaterialTheme.typography.headlineLarge)
        }

        @Composable
        fun H2(text: String) {
            Text(text = text, style = MaterialTheme.typography.headlineMedium)
        }

        @Composable
        fun H3(text: String) {
            Text(text = text, style = MaterialTheme.typography.headlineSmall)
        }

        @Composable
        fun Body(text: String) {
            Text(text = text, style = MaterialTheme.typography.bodyLarge)
        }
    }
}