package com.example.movera.customComponent

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.size.Size
import com.example.movera.ui.theme.Grey2A
import com.example.movera.ui.theme.Grey3D
import com.example.movera.ui.theme.Yellow_Base

@Composable
fun CustomButton(
    text: String = "",
    onClick: () -> Unit = {},
    icon: Int? = null,
    modifier: Modifier = Modifier,
    containerColor: Color = Yellow_Base,
    contentColor: Color = Color.Black,
    fontSize: TextUnit = 30 .sp,
    fontWeight: FontWeight = FontWeight.Bold,
    shape: Shape = CircleShape
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        onClick = onClick,
        contentPadding = PaddingValues(vertical = 16.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Yellow_Base,
            contentColor = Color.Black
        )
    ) {
        Text(text = text, fontWeight = FontWeight.Bold,fontSize = 18.sp)
    }
}
@Composable
fun CustomButton2(
    text: String = "",
    onClick: () -> Unit = {},
    icon: Int = 0,
    modifier: Modifier = Modifier,
    containerColor: Color = Grey2A,
    contentColor: Color = Color.Black,
    fontSize: TextUnit = 30 .sp,
    fontWeight: FontWeight = FontWeight.Bold,
    shape: Shape = CircleShape
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        onClick = onClick,
        contentPadding = PaddingValues(vertical = 16.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Grey2A,
            contentColor = Color.Black
        )
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = Color.Unspecified
        )
    }
}

    @Composable
    fun CustomTextField(
        value: String = "",
        onValueChange: (String) -> Unit = {},
        label: String = "",
        shape: Shape? = null,
        labelColor: Color = Color.White,
        labelFontSize: TextUnit = 14.sp,
        leadingIcon: @Composable (() -> Unit)? = null,
        trailingIcon: @Composable (() -> Unit)? = null,
        visualTransformation: VisualTransformation = VisualTransformation.None,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
        modifier: Modifier = Modifier
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            shape = shape ?: OutlinedTextFieldDefaults.shape,
            visualTransformation = visualTransformation,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Yellow_Base,
                disabledBorderColor = Grey3D,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White
            ),
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
    }

@Composable
fun CustomTextButton(
    text: String = "",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(
            text = text,
            color = Yellow_Base,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold


        )
    }
}

@Composable
fun CustomOutlinedButton(
    buttonText: String = "",
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    containerColor: Color = Yellow_Base,
    contentColor: Color = Color.Black,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.Bold

) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        Text(text = buttonText)
    }
}

@Composable
fun CustomText(text: String = "",
               modifier: Modifier= Modifier,
               color : Color= Color.White,
               fontSize: TextUnit =14.sp,
               fontWeight: FontWeight= FontWeight.Normal,
               textAlign: TextAlign= TextAlign.Center){
    Text(
        text = text,
        modifier = modifier,
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        textAlign = textAlign
    )
}