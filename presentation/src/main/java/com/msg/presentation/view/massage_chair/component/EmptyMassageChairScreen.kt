package com.msg.presentation.view.massage_chair.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import com.msg.presentation.R

@Composable
fun EmptyMassageChairScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DotoriTheme.colors.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val image = painterResource(
            id = if (DotoriTheme.isSystemIsDarkTheme())
                R.drawable.ic_empty_massage_chair_icon_dark
            else R.drawable.ic_empty_massage_chair_icon_light
        )

        Image(
            painter = image,
            contentDescription = "empty massage chair student"
        )

        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "안마의자를 신청한 인원이 없습니다..",
            style = DotoriTheme.typography.subTitle2,
            color = DotoriTheme.colors.neutral10
        )

        Text(
            text = "홈에서 안마의자 신청을 해보세요!",
            style = DotoriTheme.typography.caption,
            color = DotoriTheme.colors.neutral20
        )
    }
}