package uz.gita.melissa_store.presenter.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.melissa_store.R
import uz.gita.melissa_store.data.CheckData

@Composable
fun CheckDataComponent(
    text: CheckData,
    onCheckDataSelected: (CheckData) -> Unit
) {

    var expanded by remember { mutableStateOf(false) }

    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f
    )

    var parentSize by remember { mutableStateOf(IntSize.Zero) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .onGloballyPositioned {
                    parentSize = it.size
                }
                .clickable { expanded = true },
            verticalAlignment = Alignment.CenterVertically
        ) {
            GetVerticalSpaceSmallWidth()
            Text(
                text = text.title,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF424242),
                )
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                modifier = Modifier
                    .rotate(degrees = angle),
                onClick = { expanded = true }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_drop),
                    contentDescription = null
                )
            }
            DropdownMenu(
                modifier = Modifier
                    .width(with(LocalDensity.current) { parentSize.width.toDp() })
                    .background(Color.White),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
//                text.slice(0..2).forEach { priority ->
                DropdownMenuItem(
                    text = {
                        Text(text = text.title)
                    },
                    onClick = {
                        expanded = false
                        onCheckDataSelected(text)
                    },
                )
//                }
            }
        }
    }
}

@Composable
@Preview
fun CheckDataComponentPreview() {
    val listText = ArrayList<CheckData>()
    listText.add(CheckData("23-29 kunlar"))
    listText.add(CheckData("30-5 kunlar"))
    listText.add(CheckData("Oxirgi hafta"))

    CheckDataComponent(
        text = CheckData("Oxirgi hafta"),
        onCheckDataSelected = {}
    )
}