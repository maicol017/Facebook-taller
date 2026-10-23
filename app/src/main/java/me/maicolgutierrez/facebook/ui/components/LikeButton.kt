package me.maicolgutierrez.facebook.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable que representa el botón de "Me gusta" (Like) estilo Facebook.
 * Componente sin estado (stateless).
 *
 * @param modifier Modificador de estilo y layout.
 * @param isLiked Indica si la publicación ya tiene "Me gusta".
 * @param text Texto del botón, por defecto "Me gusta".
 * @param onClick Acción al pulsar el botón.
 */
@Composable
fun LikeButton(
    modifier: Modifier = Modifier,
    isLiked: Boolean = false,
    text: String = "Me gusta",
    onClick: () -> Unit = {}
) {
    val contentColor = if (isLiked) Color(0xFF1877F2) else MaterialTheme.colorScheme.onSurfaceVariant
    val iconVector = if (isLiked) Icons.Filled.ThumbUp else Icons.Outlined.ThumbUp

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        // Ícono de pulgar arriba
        Icon(
            imageVector = iconVector,
            contentDescription = text,
            tint = contentColor,
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Texto "Me gusta" a la derecha
        Text(
            text = text,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = contentColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LikeButtonPreview() {
    LikeButton()
}

@Preview(showBackground = true)
@Composable
fun LikeButtonLikedPreview() {
    LikeButton(isLiked = true)
}
