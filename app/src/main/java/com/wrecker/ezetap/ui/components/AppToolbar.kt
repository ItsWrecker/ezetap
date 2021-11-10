package com.wrecker.ezetap.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.wrecker.ezetap.ui.main.MainViewState


@Composable
fun AppToolbar(
    modifier: Modifier,
    title: String,
    icon: @Composable () -> Unit,
    navigationIcon: @Composable () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        title = {


            Text(
                text = title,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Start,
                maxLines = 1
            )
        },
        actions = {
            icon()
        },
        elevation = 1.dp,
        navigationIcon = { navigationIcon() }
    )
}