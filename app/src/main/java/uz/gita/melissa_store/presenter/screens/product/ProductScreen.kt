package uz.gita.melissa_store.presenter.screens.product

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.melissa_store.R
import uz.gita.melissa_store.data.CheckData
import uz.gita.melissa_store.presenter.components.CheckDataComponent
import uz.gita.melissa_store.presenter.components.CompleteButton
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceMedium
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceMediumWidth
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceSmall
import uz.gita.melissa_store.ui.theme.Blue

@Composable
fun ProductScreen() {
    GetVerticalSpaceMedium()
    GetVerticalSpaceSmall()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "6",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF424242),
                    )
                )

                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "Kategoriya",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF757575),
                    )
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(shape = CircleShape)
                    .background(Color(0xFFE3F2FD))
            ) {
                Icon(
                    tint = Blue,
                    painter = painterResource(id = R.drawable._burchak),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }

    }

    GetVerticalSpaceMedium()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {

                Text(
                    text = "7729",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF424242),
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Umumiy soni",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF757575),
                    )
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(shape = CircleShape)
                    .background(Color(0xFFE8F5E9))
            ) {
                Icon(
                    tint = Color(0xFF4CAF50),
                    painter = painterResource(id = R.drawable.kubik),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }

    }


    GetVerticalSpaceMedium()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {

                Text(
                    text = "112,000,000 so’m",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                        fontWeight = FontWeight(500),
                        color = Color(0xFF424242),
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Umumiy narx",
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 21.sp,
                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF757575),
                    )
                )

            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(shape = CircleShape)
                    .background(Color(0xFFFFF8E1))
            ) {
                Icon(
                    tint = Color(0xFFFFC107),
                    painter = painterResource(id = R.drawable.dollor_katta),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }

    }

    GetVerticalSpaceMedium()

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp)
        ) {
            Text(
                text = "Saralash",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                    fontWeight = FontWeight(500),
                    color = Color(0xFF424242),
                )
            )

            GetVerticalSpaceMedium()
            GetVerticalSpaceSmall()

            CheckDataComponent(CheckData("Ombor")) {}
            GetVerticalSpaceMedium()

            CheckDataComponent(CheckData("Ta'minotchi")) {}
            GetVerticalSpaceMedium()

            CheckDataComponent(CheckData("Kategoriya")) {}

            GetVerticalSpaceMedium()

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(Color.White),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                ),
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GetVerticalSpaceMediumWidth()
                    Text(
                        text = "01.01.2023",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF9E9E9E),
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.change),
                            contentDescription = null
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "01.02.2023",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF9E9E9E),
                        )
                    )
                    GetVerticalSpaceMediumWidth()
                }

            }

            GetVerticalSpaceMedium()

            CompleteButton(
                text = "Saralash",
                BorderStroke(0.dp, Color(0xFFD6D6D6)),
                Blue,
                Color.White,
            ) {

            }
        }
    }

    GetVerticalSpaceMedium()
    GetVerticalSpaceSmall()
}