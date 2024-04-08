package uz.gita.melissa_store.presenter.screens.sell

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import uz.gita.melissa_store.presenter.navigation.AppScreen

class SellScreen: AppScreen() {
    @Composable
    override fun Content() {
        Box {
            Text(text = "Sell Screen", modifier = Modifier.align(Alignment.Center), fontSize = 42.sp)
        }
    }
}


