package uz.gita.melissa_store.presenter.screens.log_in

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.gita.melissa_store.R
import uz.gita.melissa_store.presenter.components.CompleteButton
import uz.gita.melissa_store.presenter.components.EditTextField
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceLarge
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceMedium
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceSmall
import uz.gita.melissa_store.presenter.navigation.AppScreen
import uz.gita.melissa_store.presenter.screens.statistic.StatisticScreen
import uz.gita.melissa_store.ui.theme.Blue

class LogInScreen : AppScreen() {
    @Composable
    override fun Content() {
        ContentScreen()
    }
}


@Composable
private fun ContentScreen() {

    var logIn by remember {
        mutableStateOf("")
    }

    var logInError by remember {
        mutableStateOf(false)
    }

    var parol by remember {
        mutableStateOf("")
    }

    var parolError by remember {
        mutableStateOf(false)
    }

    var parolIsEnabled by remember {
        mutableStateOf(true)
    }


    var navigator = LocalNavigator.currentOrThrow

    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        GetVerticalSpaceMedium()
        Text(
            text = "Melissa-store",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                fontWeight = FontWeight(500),
                color = Blue,
            )
        )
        GetVerticalSpaceLarge()
        GetVerticalSpaceLarge()

        Text(
            text = "Tizimga kirish",
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF212121),
            )
        )
        GetVerticalSpaceMedium()
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur ",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 21.sp,
                fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                fontWeight = FontWeight(400),
                color = Color(0xFF616161),
            )
        )
        GetVerticalSpaceLarge()
        Text(
            text = "Log in",
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF616161),
            )
        )
        GetVerticalSpaceMedium()

        EditTextField(
            placeHolder = "Loginingizni kiriting",
            value = logIn,
            trailIcon = {
                if (logInError) {
                    Icon(
                        painter = painterResource(id = R.drawable.frame),
                        contentDescription = null
                    )
                }
            },
            onValueChanged = {
                logIn = it
            },
            supportingText = {
                if (logInError) {
                    Text(text = "[3-20] belgilik bo'lishi shart")
                }
            },
            error = logInError
        )
        GetVerticalSpaceMedium()
        Text(
            text = "Parol",
            style = TextStyle(
                fontSize = 15.sp,
                lineHeight = 24.sp,
                fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFF616161),
            )
        )
        GetVerticalSpaceMedium()
        EditTextField(
            placeHolder = "Parolingizni kiriting",
            value = parol,
            trailIcon = {
                IconButton(onClick = {
                    parolIsEnabled = !parolIsEnabled
                }) {
                    Icon(
                        painter = if (parolIsEnabled) painterResource(id = R.drawable.view) else painterResource(
                            id = R.drawable.hide
                        ),
                        tint = Color(0xFFBDBDBD),
                        contentDescription = "parol show",
                        modifier = Modifier
                            .size(20.dp)

                    )

                }
            },
            onValueChanged = {
                parol = it
            },
            visualTransformation = if (parolIsEnabled) VisualTransformation.None else PasswordVisualTransformation(),
            supportingText = {
                if (parolError) {
                    Text(text = "[6-20] belgilik bo'lishi shart")
                }
            },
            error = parolError
        )
        GetVerticalSpaceLarge()
        GetVerticalSpaceSmall()

        CompleteButton(text = "Kirish", BorderStroke(0.dp, Color(0xFFD6D6D6)), Blue, Color.White,) {
            logInError = logIn.length < 3
            parolError = parol.length < 6

            if (logIn.length >= 3 && parol.length >= 6){
                navigator.push(StatisticScreen())
            }
        }
    }

}

@Preview(showSystemUi = true)
@Preview
@Composable
private fun ContentScreenPreview() {
    ContentScreen()
}