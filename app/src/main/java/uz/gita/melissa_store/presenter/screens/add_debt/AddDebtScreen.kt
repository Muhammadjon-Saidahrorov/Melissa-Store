package uz.gita.melissa_store.presenter.screens.add_debt

import android.content.Context
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import uz.gita.melissa_store.R
import uz.gita.melissa_store.data.CheckData
import uz.gita.melissa_store.presenter.components.CheckDataComponent
import uz.gita.melissa_store.presenter.components.CompleteButton
import uz.gita.melissa_store.presenter.components.EditTextField
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceLarge
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceMedium
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceMediumWidth
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceSmall
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceSmallWidth
import uz.gita.melissa_store.presenter.navigation.AppScreen
import uz.gita.melissa_store.ui.theme.Blue

class AddDebtScreen(private val logicScreen: Boolean) : AppScreen() {
    @Composable
    override fun Content() {
        ContentScreen(logicScreen = logicScreen)
    }
}

@Composable
private fun ContentScreen(logicScreen: Boolean) {

    var ism by remember {
        mutableStateOf("")
    }
    var nom by remember {
        mutableStateOf("")
    }
    var miqdor by remember {
        mutableStateOf("")
    }
    var narx by remember {
        mutableStateOf("")
    }
    var umummiy by remember {
        mutableStateOf("0")
    }

    var ismError by remember {
        mutableStateOf(false)
    }
    var nomError by remember {
        mutableStateOf(false)
    }
    var miqdorError by remember {
        mutableStateOf(false)
    }
    var narxError by remember {
        mutableStateOf(false)
    }


    var logic by remember {
        mutableStateOf(logicScreen)
    }


    var ombor by remember {
        mutableStateOf("")
    }
    var oism by remember {
        mutableStateOf("")
    }
    var onom by remember {
        mutableStateOf("")
    }
    var omiqdor by remember {
        mutableStateOf("")
    }
    var onarx by remember {
        mutableStateOf("")
    }

    var oumummiy by remember {
        mutableStateOf("0")
    }

    var omborError by remember {
        mutableStateOf(false)
    }
    var oismError by remember {
        mutableStateOf(false)
    }
    var onomError by remember {
        mutableStateOf(false)
    }
    var omiqdorError by remember {
        mutableStateOf(false)
    }
    var onarxError by remember {
        mutableStateOf(false)
    }


    var navigator = LocalNavigator.currentOrThrow


    Column {
        Row(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navigator.pop() }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
                    contentDescription = null,
                    tint = Blue
                )

                GetVerticalSpaceSmallWidth()
            }

            Text(
                text = "Orqaga",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 21.sp,
                    fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                    fontWeight = FontWeight(600),
                    color = Color(0xFF2196F3),

                    )
            )

        }

        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Color(0xFFD6D6D6))
        )
        LazyColumn {
            item {

                GetVerticalSpaceLarge()

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        ),
                    ) {
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .height(56.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TextButton(
                                onClick = {
                                    logic = true
                                },
                                modifier = Modifier
                                    .weight(1f),
                            ) {
                                Text(
                                    text = "Qarz qo’shish",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                                        fontWeight = FontWeight(500),
                                        color = if (logic)
                                            Blue
                                        else
                                            Color(0xFF9E9E9E),
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }


                            TextButton(
                                onClick = {
                                    logic = false
                                },
                                modifier = Modifier
                                    .weight(1f),
                            ) {
                                Text(
                                    text = "Sotish",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                                        fontWeight = FontWeight(500),
                                        color = if (!logic)
                                            Blue
                                        else
                                            Color(0xFF9E9E9E),
                                    ),
                                    textAlign = TextAlign.Center
                                )
                            }
                        }
                        Spacer(
                            modifier = Modifier
                                .height(1.dp)
                                .fillMaxWidth()
                                .background(Color(0xFFD6D6D6))
                        )

                        if (logic) {
                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(all = 16.dp)
                            ) {

                                GetVerticalSpaceMedium()
                                Text(
                                    text = "Mijoz ismi",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                EditTextField(
                                    placeHolder = "Ism kiriting",
                                    value = ism,
                                    trailIcon = {
                                        if (ismError) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.frame),
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onValueChanged = {
                                        ism = it
                                    },
                                    supportingText = {
                                        if (ismError) {
                                            Text(
                                                text = "Mijoz ismi kiritilishi shart",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFF44336),
                                                )
                                            )
                                        }
                                    },
                                    error = ismError
                                )

                                GetVerticalSpaceMedium()

                                Text(
                                    text = "Mahsulot nomi",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                EditTextField(
                                    placeHolder = "Mahsulot nomini kiriting",
                                    value = nom,
                                    trailIcon = {
                                        if (nomError) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.frame),
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onValueChanged = {
                                        nom = it
                                    },
                                    supportingText = {
                                        if (nomError) {
                                            Text(
                                                text = "Mahsulot nomi kiritilishi shart",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFF44336),
                                                )
                                            )
                                        }
                                    },
                                    error = nomError
                                )

                                GetVerticalSpaceMedium()

                                Text(
                                    text = "Mahsulot miqdori",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                EditTextField(
                                    placeHolder = "10",
                                    value = miqdor,
                                    trailIcon = {
                                        if (miqdorError) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.frame),
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onValueChanged = {
                                        miqdor = it
                                    },
                                    supportingText = {
                                        if (miqdorError) {
                                            Text(
                                                text = "Mahsulot miqdori kiritilishi shart",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFF44336),
                                                )
                                            )
                                        }
                                    },
                                    error = miqdorError
                                )

                                GetVerticalSpaceMedium()

                                Text(
                                    text = "Mahsulot narxi",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                EditTextField(
                                    placeHolder = "10",
                                    value = narx,
                                    trailIcon = {
                                        if (narxError) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.frame),
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onValueChanged = {
                                        narx = it
                                    },
                                    supportingText = {
                                        if (narxError) {
                                            Text(
                                                text = "Mahsulot narxi kiritilishi shart",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFF44336),
                                                )
                                            )
                                        }
                                    },
                                    error = narxError
                                )

                                GetVerticalSpaceMedium()

                                Text(
                                    text = "Umumiy narx:",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                Text(
                                    text = umummiy,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFBDBDBD),
                                    )
                                )

                                if (narx.isNotEmpty()) {
                                    umummiy = "54,600,000 so’m"
                                }

                            }
                        } else {


                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(all = 16.dp)
                            ) {
                                GetVerticalSpaceMedium()

                                Text(
                                    text = "Omborni tanlang",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                EditTextField(
                                    placeHolder = "Ombor nomini kiriting",
                                    value = ombor,
                                    trailIcon = {
                                        if (omborError) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.frame),
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onValueChanged = {
                                        ombor = it
                                    },
                                    supportingText = {
                                        if (omborError) {
                                            Text(
                                                text = "Ombor nomi kiritilishi shart",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFF44336),
                                                )
                                            )
                                        }
                                    },
                                    error = omborError
                                )

                                GetVerticalSpaceMedium()
                                Text(
                                    text = "Mijoz ismi",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                EditTextField(
                                    placeHolder = "Ism kiriting",
                                    value = oism,
                                    trailIcon = {
                                        if (oismError) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.frame),
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onValueChanged = {
                                        oism = it
                                    },
                                    supportingText = {
                                        if (oismError) {
                                            Text(
                                                text = "Mijoz ismi kiritilishi shart",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFF44336),
                                                )
                                            )
                                        }
                                    },
                                    error = oismError
                                )

                                GetVerticalSpaceMedium()

                                Text(
                                    text = "Mahsulot nomi",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                EditTextField(
                                    placeHolder = "Mahsulot nomini kiriting",
                                    value = onom,
                                    trailIcon = {
                                        if (onomError) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.frame),
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onValueChanged = {
                                        onom = it
                                    },
                                    supportingText = {
                                        if (onomError) {
                                            Text(
                                                text = "Mahsulot nomi kiritilishi shart",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFF44336),
                                                )
                                            )
                                        }
                                    },
                                    error = onomError
                                )

                                GetVerticalSpaceMedium()

                                Text(
                                    text = "Mahsulot miqdori",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                EditTextField(
                                    placeHolder = "10",
                                    value = omiqdor,
                                    trailIcon = {
                                        if (omiqdorError) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.frame),
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onValueChanged = {
                                        omiqdor = it
                                    },
                                    supportingText = {
                                        if (omiqdorError) {
                                            Text(
                                                text = "Mahsulot miqdori kiritilishi shart",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFF44336),
                                                )
                                            )
                                        }
                                    },
                                    error = omiqdorError
                                )

                                GetVerticalSpaceMedium()

                                Text(
                                    text = "Mahsulot narxi",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                EditTextField(
                                    placeHolder = "10",
                                    value = onarx,
                                    trailIcon = {
                                        if (onarxError) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.frame),
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    onValueChanged = {
                                        onarx = it
                                    },
                                    supportingText = {
                                        if (onarxError) {
                                            Text(
                                                text = "Mahsulot narxi kiritilishi shart",
                                                style = TextStyle(
                                                    fontSize = 12.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                    fontWeight = FontWeight(400),
                                                    color = Color(0xFFF44336),
                                                )
                                            )
                                        }
                                    },
                                    error = onarxError
                                )

                                GetVerticalSpaceMedium()

                                Text(
                                    text = "Umumiy narx:",
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF212121),
                                    )
                                )

                                GetVerticalSpaceSmall()

                                Text(
                                    text = oumummiy,
                                    style = TextStyle(
                                        fontSize = 16.sp,
                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFFBDBDBD),
                                    )
                                )

                                if (onarx.isNotEmpty()) {
                                    oumummiy = "2,400,000"
                                }

                            }

                        }
                    }
                }

                GetVerticalSpaceMedium()

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        CompleteButton(
                            text = "Bekor qilish",
                            BorderStroke(1.dp, Color(0xFFD6D6D6)),
                            Color.White,
                            Color(0xFF616161)
                        ) {
                            navigator.pop()
                        }
                    }
                    GetVerticalSpaceMediumWidth()
                    Box(modifier = Modifier.weight(1f)) {
                        CompleteButton(
                            text = "Saqlash",
                            BorderStroke(0.dp, Color(0xFFD6D6D6)),
                            Blue,
                            Color.White,
                        ) {



                            if (logic){
                                ismError = ism.isEmpty()
                                nomError = nom.isEmpty()
                                miqdorError = miqdor.isEmpty()
                                narxError = narx.isEmpty()

                                if (!ismError && !nomError && !miqdorError && !narxError && umummiy != "0") {
                                    navigator.pop()
                                }

                            }else{

                                omborError = ombor.isEmpty()
                                oismError = oism.isEmpty()
                                onomError = onom.isEmpty()
                                omiqdorError = omiqdor.isEmpty()
                                onarxError = onarx.isEmpty()


                                if (!oismError && !onomError && !omiqdorError && !onarxError && oumummiy != "0") {
                                    navigator.pop()
                                }
                            }

                        }
                    }
                }

                GetVerticalSpaceMedium()

            }

        }
    }

}

@Preview(showSystemUi = true)
@Preview
@Composable
private fun ContentScreenPreview() {
    ContentScreen(true)
}
