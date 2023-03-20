package sung.gyun.composedynamicnavigationapp.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ReplyDetailsScreen(
    replyUiState: ReplyUiState,
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit = {}
) {
    BackHandler {
        onBackPressed()
    }
}