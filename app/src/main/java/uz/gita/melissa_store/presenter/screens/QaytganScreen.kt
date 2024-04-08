package uz.gita.melissa_store.presenter.screens

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
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceMedium
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceSmall
import uz.gita.melissa_store.ui.theme.Blue


@Composable
fun QaytganScreen() {
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
                    text = "Qaytgan mahsulotlar soni",
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
                    painter = painterResource(id = R.drawable.refresh),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

        }

    }

    GetVerticalSpaceSmall()
    GetVerticalSpaceMedium()
}