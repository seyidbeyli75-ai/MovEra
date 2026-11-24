package com.example.movera.screen.letscreen

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movera.R
import com.example.movera.customComponent.CustomButton
import com.example.movera.customComponent.CustomText
import com.example.movera.customComponent.CustomTextButton
import com.example.movera.ui.theme.Grey2A
import com.example.movera.ui.theme.MainGrey
import com.example.movera.ui.theme.Yellow_Base

@Composable
fun LetScreen(  event: (LetEvent) -> Unit
            ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        IconButton(
            onClick ={ event(LetEvent.BackClick) },
            modifier = Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_go_back),
                contentDescription = "Go Back",
                tint = Color.Unspecified
            )}
            Spacer(modifier = Modifier.height(14.dp))
            Image(
                painter = painterResource(R.drawable.logo_2),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(224.dp)
                    .height(224.dp)

            )
            Spacer(modifier = Modifier.height(14.dp))
            CustomText(text = "Let's you in", color = Color.White, fontSize = 36.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(25.dp))
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = { },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_facebook),
                        contentDescription = "Facebook Icon",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = stringResource(id = R.string.continue_facebook_txt),
                        fontWeight = FontWeight.W600,
                        fontSize = 15.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = { },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_google),
                        contentDescription = "Google Icon",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = stringResource(id = R.string.continue_google_txt),
                        fontWeight = FontWeight.W600,
                        fontSize = 15.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))
            OutlinedButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                onClick = {},
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                ),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_apple),
                        contentDescription = "Apple Icon",
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                        Text(
                        text = stringResource(id = R.string.continue_apple_txt),
                        fontWeight = FontWeight.W600,
                        fontSize = 15.sp
                    )
                }
            }


        Spacer(modifier = Modifier.height(30.dp))
CustomText(text = "--------------- or --------------- ", color = Color.White, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(30.dp))
        CustomButton(
            text = stringResource(R.string.sign_password_txt),
            fontWeight = FontWeight.Bold,
            onClick = { event(LetEvent.LoginClick) },
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
Row(modifier = Modifier,
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center) {
    CustomText(text= stringResource(R.string.not_account), color = Color.White, fontSize = 14.sp)
    Spacer(modifier = Modifier.width(4.dp))
    CustomTextButton(text = stringResource(R.string.sign_up), onClick = { event(LetEvent.SignClick) })
}




    }
}