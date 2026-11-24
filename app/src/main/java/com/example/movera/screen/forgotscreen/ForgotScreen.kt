package com.example.movera.screen.forgotscreen

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movera.R
import com.example.movera.customComponent.CustomButton
import com.example.movera.customComponent.CustomButton2
import com.example.movera.customComponent.CustomText
import com.example.movera.customComponent.CustomTextField
import com.example.movera.screen.letscreen.LetEvent
import com.example.movera.screen.loginscreen.LoginEvent
import com.example.movera.screen.loginscreen.LoginUiState
import com.example.movera.ui.theme.Grey2A
import com.example.movera.ui.theme.Grey3D
import com.example.movera.ui.theme.GreyEB
import com.example.movera.ui.theme.Yellow_Base
import kotlinx.coroutines.delay

@Composable
fun ForgotScreen(
    event: (ForgotEvent) -> Unit,
    state: ForgotUiState,

    ) {

    var secondsLeft by rememberSaveable { mutableIntStateOf(59) }

    LaunchedEffect(Unit) {
        while (secondsLeft > 0) {
            delay(1000)
            secondsLeft--
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(
                onClick = { event(ForgotEvent.SignClick) },
                modifier = Modifier
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_go_back),
                    contentDescription = "Go Back",
                    tint = Color.Unspecified
                )
            }
            Spacer(modifier = Modifier.width(14.dp))
            CustomText(
                text = stringResource(R.string.forgot_txt),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(100.dp))

        CustomText(text = stringResource(R.string.code_sended), color = GreyEB, fontSize = 15.sp)
        Spacer(modifier = Modifier.height(25.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CustomTextField(
                state.number1,
                onValueChange = { event(ForgotEvent.OnEnterNumber1(it)) },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 80.dp, height = 56.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

            )
            CustomTextField(
                state.number2,
                onValueChange = { event(ForgotEvent.OnEnterNumber2(it)) },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 80.dp, height = 56.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            CustomTextField(
                state.number3,
                onValueChange = { event(ForgotEvent.OnEnterNumber3(it)) },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 80.dp, height = 56.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            CustomTextField(
                state.number4,
                onValueChange = { event(ForgotEvent.OnEnterNumber4(it)) },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 80.dp, height = 56.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Spacer(Modifier.height(50.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            CustomText(
                text = stringResource(R.string.resend_txt),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp
            )
            CustomText(
                text = "$secondsLeft",
                color = Yellow_Base,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            CustomText(
                text = " s",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            text = stringResource(R.string.verify_txt),
            fontWeight = FontWeight.Bold,
            onClick = { event(ForgotEvent.FillingProfileClick) },
            fontSize = 16.sp
        )


    }
}