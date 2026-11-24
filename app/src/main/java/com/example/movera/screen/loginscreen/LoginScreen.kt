package com.example.movera.screen.loginscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
import com.example.movera.customComponent.CustomTextButton
import com.example.movera.customComponent.CustomTextField
import com.example.movera.screen.letscreen.LetEvent
import com.example.movera.screen.letscreen.LetUiState
import com.example.movera.ui.theme.Grey2A
import com.example.movera.ui.theme.Grey3D
import com.example.movera.ui.theme.Yellow_Base

@Composable
fun LoginScreen(
    state: LoginUiState,
    event: (LoginEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        IconButton(
            onClick = { event(LoginEvent.LetClick) },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_go_back),
                contentDescription = "Go Back",
                tint = Color.Unspecified
            )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Image(
            painter = painterResource(R.drawable.movera_logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(80.dp)
                .height(120.dp)

        )
        Spacer(modifier = Modifier.height(9.dp))
        CustomText(
            text = stringResource(R.string.login_account),
            color = Color.White,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        CustomTextField(
            state.email,
            onValueChange = { event(LoginEvent.OnChangeEmail(it)) },
            label = stringResource(R.string.email_txt),
            modifier = Modifier.height(58.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_email),
                    contentDescription = "email"
                )

            })
        CustomTextField(
            state.password,
            onValueChange = { event(LoginEvent.OnChangePassword(it)) },
            label = stringResource(R.string.password_txt),
            modifier = Modifier.height(58.dp),
                    visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_password),
                    contentDescription = "password"
                )

            })
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = state.rememberMe,
                onCheckedChange = { event(LoginEvent.OnRememberMeChange(it)) },
                colors = CheckboxDefaults.colors(
                    checkedColor = Yellow_Base,
                    uncheckedColor = Color.White,
                    checkmarkColor = Color.White
                )
            )
            CustomText(
                text = stringResource(R.string.remember_me),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
        state.errorMessage?.let { message ->
            CustomText(text = message, color = Color.Red, fontSize = 14.sp)
        }
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(
            text = stringResource(R.string.sign_txt),
            fontWeight = FontWeight.Bold,
            onClick = { event(LoginEvent.SignInClick)},
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(18.dp))

        CustomTextButton(text = stringResource(R.string.forgot_password_txt), onClick = {event(LoginEvent.ForgotClick)})
        Spacer(Modifier.height(16.dp))
        CustomText(text = "-------------or continue with ------------- ", color = Color.White, fontSize = 15.sp)
        Spacer(modifier = Modifier.height(18.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
           ) {
            CustomButton2(
                onClick = {},
                containerColor = Grey3D,
                icon = R.drawable.ic_facebook,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 80.dp, height = 56.dp),
            )
            CustomButton2(
                onClick = {},
                containerColor = Grey3D,
                icon = R.drawable.ic_google,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 80.dp, height = 56.dp),
            )
            CustomButton2(
                onClick = {},
                containerColor = Grey3D,
                icon = R.drawable.ic_apple,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.size(width = 80.dp, height = 56.dp),
            )
        }
        Spacer(modifier = Modifier.weight(1f))

        Row(modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            CustomText(text= stringResource(R.string.not_account), color = Color.White, fontSize = 15.sp)
            Spacer(modifier = Modifier.width(4.dp))
            CustomTextButton(text = stringResource(R.string.sign_up), onClick = { event(LoginEvent.SignClick) })
        }

    }
}
