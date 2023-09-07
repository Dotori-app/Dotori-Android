package com.msg.presentation.view.music

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.LocalOverscrollConfiguration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.button.DotoriButton
import com.dotori.dotori_components.components.dialog.DotoriDialog
import com.dotori.dotori_components.components.music.DotoriMusicListItem
import com.dotori.dotori_components.components.text_field.DotoriTextField
import com.dotori.dotori_components.components.toggle.DotoriThemeSwitchButton
import com.dotori.dotori_components.theme.CalendarIcon
import com.dotori.dotori_components.theme.DotoriText
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.PlusIcon
import com.dotori.dotori_components.theme.WarningIcon
import com.dotori.dotori_components.theme.White

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MusicScreen(modifier: Modifier = Modifier) {
    var isDark by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        MusicDialog(onDismiss = { showDialog = false }) { }
    }

    CompositionLocalProvider(
        LocalOverscrollConfiguration provides null
    ) {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            item {
                DotoriTopBar {
                    isDark = it
                }
            }
            stickyHeader {
                MusicHeader(
                    showMusicDialog = { showDialog = true }
                )
            }
            item {
                Divider(
                    color = DotoriTheme.colors.background,
                    thickness = 16.dp
                )
            }
            val musicList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
            items(musicList) {
                Box(
                    modifier = Modifier
                        .background(color = DotoriTheme.colors.background)
                        .padding(horizontal = 20.dp)
                ) {
                    DotoriMusicListItem(
                        modifier = Modifier
                            .background(
                                color = DotoriTheme.colors.cardBackground,
                                shape = RoundedCornerShape(
                                    topStart = if (musicList.first() == it) 16.dp else 0.dp,
                                    topEnd = if (musicList.first() == it) 16.dp else 0.dp,
                                    bottomStart = if (musicList.last() == it) 16.dp else 0.dp,
                                    bottomEnd = if (musicList.last() == it) 16.dp else 0.dp
                                )
                            )
                            .padding(horizontal = 16.dp)
                            .padding(
                                top = if (musicList.first() == it) 16.dp else 8.dp,
                                bottom = if (musicList.last() == it) 16.dp else 8.dp
                            ),
                        imageUrl = "",
                        title = "10cm- 서랍(그 해 우리는 OST Part.1)/가사 Audio Lyrics 21.12.07 New Release",
                        name = "2105 김준",
                        date = "16시 23분",
                        onItemClicked = { /*TODO*/ }
                    ) {

                    }
                }
            }
        }
    }
}

@Composable
fun DotoriTopBar(onSwitchClick: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(horizontal = 20.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        DotoriText()
        DotoriThemeSwitchButton(
            onSwitchClick = onSwitchClick
        )
    }
}

@Composable
fun MusicHeader(
    modifier: Modifier = Modifier,
    showMusicDialog: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DotoriTheme.colors.cardBackground)
            .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        Text(
            text = "기상음악 신청",
            style = DotoriTheme.typography.subTitle1,
            color = DotoriTheme.colors.neutral10
        )
        Spacer(modifier = Modifier.weight(1f))
        CalendarIcon(tint = DotoriTheme.colors.neutral20)
        Spacer(modifier = Modifier.width(12.dp))
        PlusIcon(
            modifier = Modifier.clickable { showMusicDialog() },
            tint = DotoriTheme.colors.neutral20,
        )
    }
}

@Composable
fun MusicDialog(
    onDismiss: () -> Unit,
    onButtonClick: () -> Unit
) {
    var musicUrl by remember { mutableStateOf("") }

    DotoriDialog(onDismiss = onDismiss) {
        Column {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "음악 신청",
                    style = DotoriTheme.typography.subTitle1,
                    color = DotoriTheme.colors.neutral10
                )
                WarningIcon()
            }
            Spacer(modifier = Modifier.height(16.dp))
            DotoriTextField(
                value = musicUrl,
                placeholder = "URL을 입력해주세요.",
                onValueChange = { musicUrl = it }
            )
            Spacer(modifier = Modifier.height(8.dp))
            DotoriButton(
                modifier = Modifier.fillMaxWidth(),
                text = "신청하기",
                onClick = onButtonClick
            )
        }
    }
}

@Preview
@Composable
fun MusicScreenTest() {
    MusicScreen()
}