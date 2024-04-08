package uz.gita.melissa_store.presenter.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.melissa_store.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    placeHolder: String,
    value: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    trailIcon: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    onValueChanged: (String) -> Unit,
    paddingHorizontal: Dp = 0.dp,
    paddingTop: Dp = 0.dp,
    supportingText: @Composable () -> Unit,
    error: Boolean = false
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = keyboardOptions,
        value = value,
        onValueChange = onValueChanged,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            cursorColor = Color(0xFF64B5F6),
            focusedBorderColor = Color(0xFF64B5F6),
            unfocusedBorderColor = Color(0xFFE0E0E0),
        ),
        singleLine = true,
        placeholder = {
            Text(
                text = placeHolder,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFBDBDBD),
                )
            )
        },
        shape = RoundedCornerShape(8.dp),
        visualTransformation = visualTransformation,
        trailingIcon = trailIcon,
        supportingText = supportingText,
        isError = error
    )
}
