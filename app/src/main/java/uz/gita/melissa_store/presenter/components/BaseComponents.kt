package uz.gita.melissa_store.presenter.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GetVerticalSpaceSmall() {
    Spacer(modifier = Modifier.height(8.dp))
}
@Composable
fun GetVerticalSpaceMedium() {
    Spacer(modifier = Modifier.height(16.dp))
}
@Composable
fun GetVerticalSpaceLarge() {
    Spacer(modifier = Modifier.height(32.dp))
}

@Composable
fun GetVerticalSpaceSmallWidth() {
    Spacer(modifier = Modifier.width(8.dp))
}
@Composable
fun GetVerticalSpaceMediumWidth() {
    Spacer(modifier = Modifier.width(16.dp))
}
@Composable
fun GetVerticalSpaceLargeWidth() {
    Spacer(modifier = Modifier.width(32.dp))
}