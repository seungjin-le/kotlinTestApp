package com.example.kotlintestapp.ui.layouts

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    selectedItems: Set<Int>,
    modifier: Modifier = Modifier,
) {

        val hasSelection = selectedItems.isNotEmpty()
        val topBarText = if (hasSelection) {
            "Selected ${selectedItems.size} items"
        } else {
            "List of items"
        }

        TopAppBar(
            title = {
                Text(topBarText)
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            actions = {
                if (hasSelection) {
                    IconButton(onClick = {
                        /* click action */
                    }) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share items"
                        )
                    }
                }
            },
        )
}
