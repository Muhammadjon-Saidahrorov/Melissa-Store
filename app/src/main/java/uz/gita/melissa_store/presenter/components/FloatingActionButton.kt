package uz.gita.melissa_store.presenter.components

import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.MotionDurationScale
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.melissa_store.R
import uz.gita.melissa_store.ui.theme.Blue

@Composable
fun FloatingActionButtonExample(
    isOpen: Boolean,
    onToggle: () -> Unit,
    onClose: (state: Boolean) -> Unit,
    onClickSell: () -> Unit,
    onClickAddBedt: () -> Unit
) {

    val transition = updateTransition(targetState = isOpen, label = "")

    val rotation = transitionAnimation(
        transition = transition,
        valueForTrue = 45f,
        valueForFalse = 0f
    )

    val backgroundAlpha = transitionAnimation(
        transition = transition,
        valueForTrue = 0.5f,
        valueForFalse = 0f
    )

    val actionMenuScale = transitionAnimation(
        transition = transition,
        valueForTrue = 1f,
        valueForFalse = 0f
    )

//    Surface(
//        color = Color.Black.copy(alpha = backgroundAlpha),
//        modifier = Modifier.fillMaxSize()
//    ) {
    Box(
        modifier = Modifier
            .fillMaxSize()
//            .clickable(
//                indication = null,
//                interactionSource = MutableInteractionSource(),
//                onClick = {
//                    onClose.invoke(isOpen)
//                }
//            )
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 40.dp, end = 16.dp)
                .wrapContentSize(),
            horizontalAlignment = Alignment.End
        ) {
            if (isOpen) {

                FloatingActionMenus(
                    isOpen = isOpen,
                    actionMenuScale = actionMenuScale,
                    onClose = onClose,
                    onClickSell = onClickSell,
                    onClickAddBedt = onClickAddBedt
                )

                Spacer(modifier = Modifier.padding(vertical = 20.dp))
            }

            FloatingActionButton(
                onClick = {
                    onToggle()
                },
                shape = RoundedCornerShape(8.dp),
                containerColor = Blue,
                contentColor = Color.Gray,
                elevation = FloatingActionButtonDefaults.elevation(2.dp),
                content = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = null,
                        modifier = Modifier
                            .rotate(rotation)
                            .size(32.dp),
                        tint = Color.White,
                    )
                }
            )

            GetVerticalSpaceMedium()

        }
    }
//    }
}

@Composable
fun FloatingActionMenus(
    isOpen: Boolean,
    actionMenuScale: Float,
    onClose: (state: Boolean) -> Unit,
    onClickSell: () -> Unit,
    onClickAddBedt: () -> Unit
) {

    Button(
        modifier = Modifier
            .scale(actionMenuScale)
            .height(50.dp),
        onClick = {
            onClose.invoke(isOpen)
            onClickSell.invoke()
        },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue, contentColor = Color.Gray)
    ) {
        Text(
            text = "Sotish",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.4.sp,
            )
        )
    }

    GetVerticalSpaceMedium()

    Button(
        modifier = Modifier
            .scale(actionMenuScale)
            .height(50.dp),
        onClick = {
            onClose.invoke(isOpen)
            onClickAddBedt.invoke()
        },
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Blue, contentColor = Color.Gray)
    ) {
        Text(
            text = "Qarz qo’shish",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                fontWeight = FontWeight(500),
                color = Color(0xFFFFFFFF),
                letterSpacing = 0.4.sp,
            )
        )
    }

    GetVerticalSpaceMedium()
}

@Composable
fun transitionAnimation(
    transition: Transition<Boolean>,
    valueForTrue: Float,
    valueForFalse: Float
): Float {

    val animationValue: Float by transition.animateFloat(
        label = "",
        transitionSpec = {
            tween(durationMillis = 250)
        }
    ) {
        if (it) {
            valueForTrue
        } else {
            valueForFalse
        }
    }
    return animationValue
}