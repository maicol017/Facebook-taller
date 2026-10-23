package me.maicolgutierrez.facebook.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PostActions(){
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        LikeButton()
        CommentButton()
        ShareButton()
    }

}

@Preview(showBackground = true)
@Composable
fun PostActionsPreview(){
    PostActions()
}