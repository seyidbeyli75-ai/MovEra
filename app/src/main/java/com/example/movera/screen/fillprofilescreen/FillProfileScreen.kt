package com.example.movera.screen.fillprofilescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movera.R
import com.example.movera.customComponent.CustomButton
import com.example.movera.customComponent.CustomText
import com.example.movera.customComponent.CustomTextField
import com.example.movera.ui.theme.Grey3F
import com.example.movera.ui.theme.Yellow_Base

    @Composable
    fun FillProfileScreen(
        event: (FillProfileEvent) -> Unit,
        state: FillProfileUiState,

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
            ){
                IconButton(
                    onClick = { event(FillProfileEvent.ForgotClick) },
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
                    text = stringResource(R.string.fill_profile_txt),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Image(
                painter = painterResource(R.drawable.profile),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)

            )
            Spacer(modifier = Modifier.height(18.dp))
            CustomTextField(
                state.full_name,
                onValueChange = { event(FillProfileEvent.OnChangeFullName(it)) },
                label = stringResource(R.string.fullname_txt),
                labelFontSize = 15.sp,
                modifier = Modifier.height(58.dp),
                shape = RoundedCornerShape(16.dp)

            )
            CustomTextField(
                state.nickname,
                onValueChange = { event(FillProfileEvent.OnChangeNickName(it)) },
                label = stringResource(R.string.nickname_txt),
                labelFontSize = 15.sp,
                modifier = Modifier.height(58.dp),
                shape = RoundedCornerShape(16.dp)

            )
            Spacer(modifier = Modifier.height(6.dp))

            CustomTextField(
                state.email,
                onValueChange = { event(FillProfileEvent.OnChangeEmail(it)) },
                label = stringResource(R.string.email_txt),
                labelFontSize = 15.sp,
                modifier = Modifier.height(58.dp),
                shape = RoundedCornerShape(16.dp),

                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                trailingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_email),
                        contentDescription = "email"
                    )

                })
            Spacer(modifier = Modifier.height(6.dp))

            CustomTextField(
                state.number,
                onValueChange = { event(FillProfileEvent.OnChangeNumber(it)) },
                label = stringResource(R.string.phoneNumber_txt),
                modifier = Modifier.height(58.dp),
                labelFontSize = 15.sp,
                shape = RoundedCornerShape(16.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                leadingIcon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.flag___dropdown_indicator),
                        contentDescription = "country"
                    )

                })
            Spacer(modifier = Modifier.height(6.dp))

            CustomTextField(
                state.gender,
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.height(58.dp),
                labelFontSize = 15.sp,
                onValueChange = { event(FillProfileEvent.OnChangeGender(it)) },
                label = stringResource(R.string.gender_txt)
            )
            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Button(
                    onClick = { event(FillProfileEvent.HomeClick) },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Grey3F,
                        contentColor = Color.White
                    ),
                ) {
                    Text(
                        text = stringResource(R.string.skip_txt),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


                Spacer(Modifier.width(12.dp))
                Button(
                    onClick = { event(FillProfileEvent.CreateClick) },
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Yellow_Base,
                        contentColor = Color.Black
                    ),
                ) {
                    Text(
                        text = stringResource(R.string.continue_txt),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            }


        }
    }