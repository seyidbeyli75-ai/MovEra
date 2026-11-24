package com.example.movera.screen.startscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movera.customComponent.CustomOutlinedButton
import com.example.movera.customComponent.CustomText
import com.example.movera.ui.theme.WhiteEB
import com.example.movera.ui.theme.Yellow_Base
import com.example.movera.R
import com.example.movera.customComponent.CustomButton

@Composable
fun StartScreen(state: StartUiState,
                event: (StartEvent) -> Unit,
                onNavigateToSplash :() -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.base_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()

        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(

                            0.0f to Color.Black.copy(alpha = 0.4f),
                            0.4f to Color.Transparent,
                            0.7f to Color.Black.copy(alpha = 0.8f),
                            1.0f to Color.Black

                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            CustomText(text = stringResource(R.string.welcome_app_txt),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
            Spacer(Modifier.height(14.dp))
            CustomText(text = stringResource(R.string.the_best_txt),
                fontSize = 16.sp,
                color = WhiteEB,
                fontWeight = FontWeight.Bold)



            Row( modifier = Modifier , Arrangement.spacedBy(6.dp)  ){
                Box(
                    modifier = Modifier
                        .width(32.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .background(Yellow_Base)
                )

                Box(
                    modifier = Modifier
                        .width(8.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .background(White)
                )
                Box(
                    modifier = Modifier
                        .width(8.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .background(White)
                )
            }
            Spacer(Modifier.height(16.dp))
            CustomButton(text =stringResource(R.string.get_started_txt), fontWeight = FontWeight.Bold, onClick = onNavigateToSplash)


        }

    }
}