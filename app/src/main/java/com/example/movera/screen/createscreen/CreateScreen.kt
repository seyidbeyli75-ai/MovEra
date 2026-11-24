package com.example.movera.screen.createscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.movera.customComponent.CustomText
import com.example.movera.customComponent.CustomTextField
import com.example.movera.ui.theme.Yellow_Base

@Composable
fun CreateScreen(
    event: (CreateEvent) -> Unit,
    state: CreateUiState,

    ) {
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
                onClick = { event(CreateEvent.FillingProfileClick) },
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
                text = stringResource(R.string.creatingPassword_txt),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(18.dp))
        Image(
            painter = painterResource(R.drawable.sarili_image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(342.dp)
                .height(296.dp)

        )
        Spacer(modifier = Modifier.height(18.dp))
        CustomText(
            text = stringResource(R.string.creatingYourPassword_txt),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(18.dp))

        CustomTextField(
            state.superPassword,
            onValueChange = { event(CreateEvent.OnChangeSuperPassword(it)) },
            label = stringResource(R.string.superPassword_txt),
            shape = RoundedCornerShape(16.dp),

            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
labelFontSize = 18.sp,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_password),
                    contentDescription = "password"
                )

            })
        Spacer(modifier = Modifier.height(8.dp))

        CustomTextField(
            state.secretPassword,
            onValueChange = { event(CreateEvent.OnChangeSecretPassword(it)) },
            label = stringResource(R.string.superPassword_txt),
            shape = RoundedCornerShape(16.dp),

            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            labelFontSize = 18.sp,
            leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_password),
                    contentDescription = "password"
                )

            })
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Checkbox(
                checked = state.rememberMe,
                onCheckedChange = { event(CreateEvent.OnRememberMeChange(it)) },
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

        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            text = stringResource(R.string.continue_txt),
            fontWeight = FontWeight.Bold,
            onClick = { event(CreateEvent.HomeClick) },
            fontSize = 16.sp
        )

        }


    }
