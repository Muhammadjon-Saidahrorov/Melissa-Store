package uz.gita.melissa_store.presenter.screens.statistic

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemColors
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.PlotType
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import co.yml.charts.ui.piechart.charts.DonutPieChart
import co.yml.charts.ui.piechart.models.PieChartConfig
import co.yml.charts.ui.piechart.models.PieChartData
import kotlinx.coroutines.launch
import uz.gita.melissa_store.R
import uz.gita.melissa_store.data.CheckData
import uz.gita.melissa_store.data.MenuItem
import uz.gita.melissa_store.data.Mijozlar
import uz.gita.melissa_store.presenter.components.CheckDataComponent
import uz.gita.melissa_store.presenter.components.CompleteButton
import uz.gita.melissa_store.presenter.components.FloatingActionButtonExample
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceLarge
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceMedium
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceMediumWidth
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceSmall
import uz.gita.melissa_store.presenter.components.GetVerticalSpaceSmallWidth
import uz.gita.melissa_store.presenter.components.transitionAnimation
import uz.gita.melissa_store.presenter.navigation.AppScreen
import uz.gita.melissa_store.presenter.screens.QaytganScreen
import uz.gita.melissa_store.presenter.screens.add_debt.AddDebtScreen
import uz.gita.melissa_store.presenter.screens.kategory.KategoryScreen
import uz.gita.melissa_store.presenter.screens.product.ProductScreen
import uz.gita.melissa_store.presenter.screens.qarzdorlik.QarzdorlikScreen
import uz.gita.melissa_store.presenter.screens.report.ReportScreen
import uz.gita.melissa_store.presenter.screens.sell.SellScreen
import uz.gita.melissa_store.ui.theme.Blue


val mijozList: List<Mijozlar> =
    listOf(
        Mijozlar("Guy Hawkins", "\$275.43"),
        Mijozlar("Jane Cooper", "\$779.58"),
        Mijozlar("Brooklyn Simmons", "\$293.01"),
        Mijozlar("Ronald Richards", "\$739.65"),
        Mijozlar("Eleanor Pena", "\$948.55"),
        Mijozlar("Savannah Nguyen", "\$576.28"),
        Mijozlar("Esther Howard", "\$106.58"),
        Mijozlar("Cody Fisher", "\$601.13"),
        Mijozlar("Devon Lane", "\$490.51"),
    )


class StatisticScreen : AppScreen() {
    @Composable
    override fun Content() {

        val pointsData: List<Point> =
            listOf(
                Point(0f, 20f),
                Point(2f, 40f),
                Point(3f, 35f),
                Point(4f, 60f),
                Point(5f, 37f),
                Point(6f, 72f),
                Point(7f, 68f),
            )

        val OY: List<String> =
            listOf(
                "",
                "1,000,000",
                "3,000,000",
                "5,000,000",
                "7,000,000",
                "10,000,000",
            )

        val OX: List<String> =
            listOf(
                "",
                "Dush",
                "Sesh",
                "Chor",
                "Pay",
                "Juma",
                "Shan",
                "Yak",
            )

        val xAxisData = AxisData.Builder()
            .axisStepSize(50.dp)
            .backgroundColor(Color.White)
            .axisLabelColor(Color(0xFF616161))
            .steps(7)
            .axisLineColor(Color.White)
            .labelData { i -> OX[i] }
            .labelAndAxisLinePadding(16.dp)
            .build()

        val yAxisData = AxisData.Builder()
            .steps(5)
            .axisLabelColor(Color(0xFF616161))
            .axisLineColor(Color.White)
            .backgroundColor(Color.White)
            .labelAndAxisLinePadding(16.dp)
            .labelData { i -> OY[i] }.build()


        val lineChartData = LineChartData(
            linePlotData = LinePlotData(
                lines = listOf(
                    Line(
                        dataPoints = pointsData,
                        LineStyle(color = Color(0xFF2196F3), width = 18f),
                        null,
                        SelectionHighlightPoint(),
                        ShadowUnderLine(color = Color.White),
                        SelectionHighlightPopUp()
                    )
                ),
            ),
            xAxisData = xAxisData,
            yAxisData = yAxisData,
            gridLines = GridLines(),
            backgroundColor = Color.White
        )

        val lineChartData2 = LineChartData(
            linePlotData = LinePlotData(
                lines = listOf(
                    Line(
                        dataPoints = pointsData,
                        LineStyle(color = Color(0xFFAB47BC), width = 18f),
                        null,
                        SelectionHighlightPoint(),
                        ShadowUnderLine(color = Color.White),
                        SelectionHighlightPopUp()
                    )
                ),
            ),
            xAxisData = xAxisData,
            yAxisData = yAxisData,
            gridLines = GridLines(),
            backgroundColor = Color.White
        )

        val donutChartData = PieChartData(
            slices = listOf(
                PieChartData.Slice("Leslie Alexander", 45f, Color(0xFF64B5F6)),
                PieChartData.Slice("Annette Black", 25f, Color(0xFFFFD54F)),
                PieChartData.Slice("Cody Fisher", 30f, Color(0xFF81C784)),
            ),
            plotType = PlotType.Donut
        )

        val donutChartData2 = PieChartData(
            slices = listOf(
                PieChartData.Slice("Theresa Webb", 33f, Color(0xFF64B5F6)),
                PieChartData.Slice("Courtney Henry", 27f, Color(0xFFFFD54F)),
                PieChartData.Slice("Floyd Miles", 40f, Color(0xFF81C784)),
            ),
            plotType = PlotType.Donut
        )

        val donutChartConfig = PieChartConfig(
            labelVisible = true,
            labelFontSize = 24.sp,
            strokeWidth = 32f,
            labelColor = Color.Black,
            activeSliceAlpha = .9f,
            isAnimationEnable = true,
        )


        ContentScreen(
            lineChartData,
            lineChartData2,
            donutChartData,
            donutChartData2,
            donutChartConfig,
        )

    }
}

@Composable
private fun ContentScreen(
    lineChartData: LineChartData,
    lineChartData2: LineChartData,
    pieChartData: PieChartData,
    pieChartData2: PieChartData,
    pieChartConfig: PieChartConfig,
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val items = listOf(
        MenuItem(title = "Statistika", icon = R.drawable.statistic),
        MenuItem(title = "Hisobotlar", icon = R.drawable.hisobot),
        MenuItem(title = "Mahsulotlar", icon = R.drawable.mahsulot),
        MenuItem(title = "Kategoriyalar", icon = R.drawable.kategory),
        MenuItem(title = "Qaytgan mahsulotlar", icon = R.drawable.qaytgan),
        MenuItem(title = "Qarzdorlik", icon = R.drawable.qarz),
        MenuItem(title = "Ombor", icon = R.drawable.ombor),
        MenuItem(title = "Ta‘minotchi", icon = R.drawable.taminot),
        MenuItem(title = "Mijozlar", icon = R.drawable.mijoz),
        MenuItem(title = "Xodimlar", icon = R.drawable.xodim),
        MenuItem(title = "Pul birliklar", icon = R.drawable.pul),

        )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    var isOpen by remember {
        mutableStateOf(false)
    }

    var hisobotScreen by remember {
        mutableStateOf(false)
    }

    var mahsulotScreen by remember {
        mutableStateOf(false)
    }

    var kategoryScreen by remember {
        mutableStateOf(false)
    }
    var qaytganScreen by remember {
        mutableStateOf(false)
    }
    var qarzdorlikScreen by remember {
        mutableStateOf(false)
    }


    val transition = updateTransition(targetState = isOpen, label = "")

    val backgroundAlpha = transitionAnimation(
        transition = transition,
        valueForTrue = 0.5f,
        valueForFalse = 0f
    )

    var navigator = LocalNavigator.currentOrThrow
    Surface(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet(
                    drawerContainerColor = Color.White,
                    drawerShape = RoundedCornerShape(0.dp)
                ) {
                    ModalDrawerSheet(
                        drawerContainerColor = Color.White,
                        drawerShape = RoundedCornerShape(0.dp)
                    ) {
                        GetVerticalSpaceMedium()
                        Row(
                            Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            GetVerticalSpaceSmallWidth()
                            Text(
                                text = "Melissa-store",
                                style = TextStyle(
                                    fontSize = 21.sp,
                                    fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFF212121),

                                    )
                            )

                            Spacer(modifier = Modifier.weight(1f))

                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.close()
                                }
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_close_24),
                                    contentDescription = null
                                )
                            }
                        }

                        GetVerticalSpaceLarge()

                        LazyColumn {
                            item {
                                items.forEachIndexed { index, menuItem ->
                                    NavigationDrawerItem(
                                        label = {
                                            Text(
                                                text = menuItem.title,
                                                style = TextStyle(
                                                    fontSize = 15.sp,
                                                    lineHeight = 24.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                                                    fontWeight = FontWeight(500),
                                                    color = if (index == selectedItemIndex) {
                                                        Blue
                                                    } else {
                                                        Color(0xFF424242)
                                                    },
                                                )
                                            )
                                        },
                                        selected = index == selectedItemIndex,
                                        onClick = {
                                            selectedItemIndex = index
                                            hisobotScreen = menuItem.title == "Hisobotlar"
                                            mahsulotScreen = menuItem.title == "Mahsulotlar"
                                            kategoryScreen = menuItem.title == "Kategoriyalar"
                                            qaytganScreen = menuItem.title == "Qaytgan mahsulotlar"
                                            qarzdorlikScreen = menuItem.title == "Qarzdorlik"
                                            scope.launch {
                                                drawerState.close()
                                            }
                                        },
                                        icon = {
                                            Icon(
                                                painter = painterResource(id = menuItem.icon),
                                                contentDescription = null,
                                                tint = if (index == selectedItemIndex) {
                                                    Blue
                                                } else {
                                                    Color(0xFF424242)
                                                }
                                            )
                                        },
                                        modifier = Modifier
                                            .padding(NavigationDrawerItemDefaults.ItemPadding)
                                            .height(50.dp),
                                        colors = NavigationDrawerItemDefaults.colors(
                                            selectedContainerColor = Color(
                                                0xFFE3F2FD
                                            ), unselectedContainerColor = Color.White
                                        ),
                                        shape = RoundedCornerShape(6.dp)
                                    )
                                    GetVerticalSpaceSmall()
                                }
                            }
                        }

                        Spacer(modifier = Modifier.weight(1f))

                        Row(
                            Modifier.padding(NavigationDrawerItemDefaults.ItemPadding),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            GetVerticalSpaceMediumWidth()
                            Icon(
                                painter = painterResource(id = R.drawable.chiq),
                                contentDescription = null,
                                tint = Color(0xFFF44336)
                            )
                            GetVerticalSpaceMediumWidth()
                            Text(
                                text = "Hisobdan chiqish",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    lineHeight = 24.sp,
                                    fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                                    fontWeight = FontWeight(500),
                                    color = Color(0xFFF44336),
                                )
                            )
                        }

                        GetVerticalSpaceMedium()
                        GetVerticalSpaceSmall()

                    }
                }
            },
            drawerState = drawerState,
        ) {

            Box(Modifier.fillMaxSize()) {
                LazyColumn(modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = MutableInteractionSource(),
                    onClick = {

                    }
                )) {
                    item {
                        Column(
                            Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp)
                        ) {
                            GetVerticalSpaceMedium()
                            GetVerticalSpaceSmall()

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
                                    modifier = Modifier.fillMaxSize(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    IconButton(onClick = {
                                        scope.launch {
                                            drawerState.open()
                                        }
                                    }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable._line),
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }

                                    Spacer(modifier = Modifier.weight(1f))
                                    Column(horizontalAlignment = Alignment.End) {
                                        Text(
                                            text = "Albert Flores",
                                            style = TextStyle(
                                                fontSize = 15.sp,
                                                lineHeight = 24.sp,
                                                fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                                                fontWeight = FontWeight(500),
                                                color = Color(0xFF424242),
                                            )
                                        )
                                        Spacer(modifier = Modifier.height(2.dp))
                                        Text(
                                            text = "Sotuvchi",
                                            style = TextStyle(
                                                fontSize = 12.sp,
                                                fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                fontWeight = FontWeight(400),
                                                color = Color(0xFF757575),
                                            )
                                        )
                                    }
                                    GetVerticalSpaceSmallWidth()

                                    Image(
                                        painter = painterResource(id = R.drawable.photo),
                                        contentDescription = "avatar",
                                        modifier = Modifier
                                            .size(44.dp)
                                            .clip(shape = CircleShape),
                                        contentScale = ContentScale.Crop,
                                    )

                                    GetVerticalSpaceMediumWidth()
                                }
                            }

                            if (hisobotScreen) {
                                ReportScreen()
                            } else if (mahsulotScreen) {
                                ProductScreen()
                            } else if (kategoryScreen) {
                                KategoryScreen()
                            } else if (qaytganScreen) {
                                QaytganScreen()
                            } else if (qarzdorlikScreen) {
                                QarzdorlikScreen()
                            } else {
                                Column {

                                    GetVerticalSpaceMedium()
                                    GetVerticalSpaceSmall()


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

                                            CheckDataComponent(CheckData("Oxirgi hafta")) {}

                                            GetVerticalSpaceMedium()
                                            GetVerticalSpaceSmall()


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
                                            GetVerticalSpaceSmall()

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


                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(320.dp),
                                        shape = RoundedCornerShape(8.dp),
                                        colors = CardDefaults.cardColors(Color.White),
                                        elevation = CardDefaults.cardElevation(
                                            defaultElevation = 2.dp
                                        ),
                                    ) {
                                        Column(
                                            Modifier
                                                .fillMaxSize()
                                                .padding(all = 16.dp)
                                        ) {
                                            Row(
                                                Modifier
                                                    .fillMaxWidth()
                                                    .height(50.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = "Byudjet",
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        lineHeight = 21.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF212121),
                                                    )
                                                )
                                                Spacer(modifier = Modifier.weight(1f))
                                                Spacer(
                                                    modifier = Modifier
                                                        .size(12.dp)
                                                        .clip(shape = CircleShape)
                                                        .background(Blue)
                                                )

                                                GetVerticalSpaceMediumWidth()

                                                Text(
                                                    text = "So’m",
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF212121),
                                                    )
                                                )
                                            }
                                            LineChart(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(220.dp),
                                                lineChartData = lineChartData
                                            )
                                        }
                                    }

                                    GetVerticalSpaceMedium()
                                    GetVerticalSpaceSmall()

                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(320.dp),
                                        shape = RoundedCornerShape(8.dp),
                                        colors = CardDefaults.cardColors(Color.White),
                                        elevation = CardDefaults.cardElevation(
                                            defaultElevation = 2.dp
                                        ),
                                    ) {
                                        Column(
                                            Modifier
                                                .fillMaxSize()
                                                .padding(all = 16.dp)
                                        ) {
                                            Row(
                                                Modifier
                                                    .fillMaxWidth()
                                                    .height(50.dp),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = "Daromad",
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        lineHeight = 21.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF212121),
                                                    )
                                                )
                                                Spacer(modifier = Modifier.weight(1f))
                                                Spacer(
                                                    modifier = Modifier
                                                        .size(12.dp)
                                                        .clip(shape = CircleShape)
                                                        .background(Color(0xFFAB47BC))
                                                )

                                                GetVerticalSpaceMediumWidth()

                                                Text(
                                                    text = "So’m",
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF212121),
                                                    )
                                                )
                                            }
                                            LineChart(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .height(220.dp),
                                                lineChartData = lineChartData2
                                            )
                                        }
                                    }

                                    GetVerticalSpaceMedium()
                                    GetVerticalSpaceSmall()

                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(108.dp),
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
                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = "100 mln",
                                                    style = TextStyle(
                                                        fontSize = 24.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                                                        fontWeight = FontWeight(500),
                                                        color = Color(0xFF212121),
                                                    )
                                                )

                                                GetVerticalSpaceMedium()

                                                Text(
                                                    text = "Balans",
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        lineHeight = 21.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF616161),
                                                    )
                                                )
                                                Spacer(modifier = Modifier.weight(1f))

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
                                                    painter = painterResource(id = R.drawable.balans),
                                                    contentDescription = null,
                                                    modifier = Modifier.align(Alignment.Center)
                                                )
                                            }

                                        }

                                    }


                                    GetVerticalSpaceMedium()
                                    GetVerticalSpaceSmall()

                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(108.dp),
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
                                                Spacer(modifier = Modifier.weight(1f))
                                                Text(
                                                    text = "90 mln",
                                                    style = TextStyle(
                                                        fontSize = 24.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_medium)),
                                                        fontWeight = FontWeight(500),
                                                        color = Color(0xFF212121),
                                                    )
                                                )

                                                GetVerticalSpaceMedium()

                                                Text(
                                                    text = " Soft balans",
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        lineHeight = 21.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF616161),
                                                    )
                                                )
                                                Spacer(modifier = Modifier.weight(1f))

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
                                                    painter = painterResource(id = R.drawable.soft_balans),
                                                    contentDescription = null,
                                                    modifier = Modifier.align(Alignment.Center)
                                                )
                                            }

                                        }

                                    }

                                    GetVerticalSpaceMedium()
                                    GetVerticalSpaceSmall()

                                    Row {
                                        Card(
                                            modifier = Modifier
                                                .weight(1f)
                                                .wrapContentHeight(),
                                            shape = RoundedCornerShape(8.dp),
                                            colors = CardDefaults.cardColors(Color.White),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 2.dp
                                            ),
                                        ) {

                                            Column(
                                                Modifier
                                                    .fillMaxWidth()
                                                    .padding(16.dp)
                                            ) {
                                                Text(
                                                    text = "Ta’minotchi",
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        lineHeight = 21.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF212121),
                                                    )
                                                )
                                                GetVerticalSpaceMedium()

                                                DonutPieChart(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    pieChartData,
                                                    pieChartConfig
                                                )

                                                GetVerticalSpaceMedium()

                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.fillMaxWidth()
                                                ) {
                                                    Spacer(
                                                        modifier = Modifier
                                                            .size(12.dp)
                                                            .clip(shape = CircleShape)
                                                            .background(pieChartData.slices[1].color)
                                                    )

                                                    GetVerticalSpaceSmallWidth()

                                                    Text(
                                                        text = pieChartData.slices[1].label,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            lineHeight = 18.sp,
                                                            fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                            fontWeight = FontWeight(400),
                                                            color = Color(0xFF616161),

                                                            )
                                                    )
                                                }

                                                GetVerticalSpaceSmall()

                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.fillMaxWidth()
                                                ) {
                                                    Spacer(
                                                        modifier = Modifier
                                                            .size(12.dp)
                                                            .clip(shape = CircleShape)
                                                            .background(pieChartData.slices[2].color)
                                                    )

                                                    GetVerticalSpaceSmallWidth()

                                                    Text(
                                                        text = pieChartData.slices[2].label,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            lineHeight = 18.sp,
                                                            fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                            fontWeight = FontWeight(400),
                                                            color = Color(0xFF616161),

                                                            )
                                                    )
                                                }

                                                GetVerticalSpaceSmall()

                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.fillMaxWidth()
                                                ) {
                                                    Spacer(
                                                        modifier = Modifier
                                                            .size(12.dp)
                                                            .clip(shape = CircleShape)
                                                            .background(pieChartData.slices[0].color)
                                                    )

                                                    GetVerticalSpaceSmallWidth()

                                                    Text(
                                                        text = pieChartData.slices[0].label,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            lineHeight = 18.sp,
                                                            fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                            fontWeight = FontWeight(400),
                                                            color = Color(0xFF616161),

                                                            )
                                                    )
                                                }

                                            }


                                        }

                                        GetVerticalSpaceSmallWidth()

                                        Card(
                                            modifier = Modifier
                                                .weight(1f)
                                                .wrapContentHeight(),
                                            shape = RoundedCornerShape(8.dp),
                                            colors = CardDefaults.cardColors(Color.White),
                                            elevation = CardDefaults.cardElevation(
                                                defaultElevation = 2.dp
                                            ),
                                        ) {
                                            Column(
                                                Modifier
                                                    .fillMaxWidth()
                                                    .padding(16.dp)
                                            ) {
                                                Text(
                                                    text = "Mijoz",
                                                    style = TextStyle(
                                                        fontSize = 14.sp,
                                                        lineHeight = 21.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF212121),
                                                    )
                                                )
                                                GetVerticalSpaceMedium()

                                                DonutPieChart(
                                                    modifier = Modifier
                                                        .fillMaxWidth(),
                                                    pieChartData2,
                                                    pieChartConfig
                                                )

                                                GetVerticalSpaceMedium()

                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.fillMaxWidth()
                                                ) {
                                                    Spacer(
                                                        modifier = Modifier
                                                            .size(12.dp)
                                                            .clip(shape = CircleShape)
                                                            .background(pieChartData2.slices[1].color)
                                                    )

                                                    GetVerticalSpaceSmallWidth()

                                                    Text(
                                                        text = pieChartData2.slices[1].label,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            lineHeight = 18.sp,
                                                            fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                            fontWeight = FontWeight(400),
                                                            color = Color(0xFF616161),

                                                            )
                                                    )
                                                }

                                                GetVerticalSpaceSmall()

                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.fillMaxWidth()
                                                ) {
                                                    Spacer(
                                                        modifier = Modifier
                                                            .size(12.dp)
                                                            .clip(shape = CircleShape)
                                                            .background(pieChartData2.slices[2].color)
                                                    )

                                                    GetVerticalSpaceSmallWidth()

                                                    Text(
                                                        text = pieChartData2.slices[2].label,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            lineHeight = 18.sp,
                                                            fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                            fontWeight = FontWeight(400),
                                                            color = Color(0xFF616161),

                                                            )
                                                    )
                                                }

                                                GetVerticalSpaceSmall()

                                                Row(
                                                    verticalAlignment = Alignment.CenterVertically,
                                                    modifier = Modifier.fillMaxWidth()
                                                ) {
                                                    Spacer(
                                                        modifier = Modifier
                                                            .size(12.dp)
                                                            .clip(shape = CircleShape)
                                                            .background(pieChartData2.slices[0].color)
                                                    )

                                                    GetVerticalSpaceSmallWidth()

                                                    Text(
                                                        text = pieChartData2.slices[0].label,
                                                        style = TextStyle(
                                                            fontSize = 12.sp,
                                                            lineHeight = 18.sp,
                                                            fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                            fontWeight = FontWeight(400),
                                                            color = Color(0xFF616161),

                                                            )
                                                    )
                                                }


                                            }


                                        }

                                    }

                                    GetVerticalSpaceMedium()
                                    GetVerticalSpaceSmall()

                                    ///////////////////////////////////////////////


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
                                                .padding(16.dp)
                                        ) {
                                            Text(
                                                text = "Eng yaxshi mijozlar",
                                                style = TextStyle(
                                                    fontSize = 14.sp,
                                                    lineHeight = 21.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                    fontWeight = FontWeight(600),
                                                    color = Color(0xFF212121),
                                                )
                                            )

                                            GetVerticalSpaceMedium()

                                            Row {
                                                Text(
                                                    text = "Ism",
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF424242),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = "Summa",
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF424242),
                                                    )
                                                )
                                            }

                                            GetVerticalSpaceSmall()


                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[0].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[0].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[1].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[1].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[2].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[2].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[3].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[3].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[4].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[4].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[5].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[5].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[6].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[6].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[7].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[7].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[8].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[8].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                        }

                                    }

                                    GetVerticalSpaceMedium()
                                    GetVerticalSpaceSmall()

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
                                                .padding(16.dp)
                                        ) {
                                            Text(
                                                text = "Eng yaxshi ta'minotchilar",
                                                style = TextStyle(
                                                    fontSize = 14.sp,
                                                    lineHeight = 21.sp,
                                                    fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                    fontWeight = FontWeight(600),
                                                    color = Color(0xFF212121),
                                                )
                                            )

                                            GetVerticalSpaceMedium()

                                            Row {
                                                Text(
                                                    text = "Ism",
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF424242),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = "Summa",
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF424242),
                                                    )
                                                )
                                            }

                                            GetVerticalSpaceSmall()


                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[0].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[0].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[1].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[1].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[2].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[2].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[3].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[3].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[4].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[4].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[5].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[5].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[6].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[6].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[7].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[7].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))

                                            Row(
                                                Modifier.fillMaxWidth(),
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                Text(
                                                    text = mijozList[8].name,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_regular)),
                                                        fontWeight = FontWeight(400),
                                                        color = Color(0xFF757575),
                                                    )
                                                )

                                                Spacer(modifier = Modifier.weight(1f))

                                                Text(
                                                    text = mijozList[8].sum,
                                                    style = TextStyle(
                                                        fontSize = 12.sp,
                                                        lineHeight = 18.sp,
                                                        fontFamily = FontFamily(Font(R.font.sfprotext_bold)),
                                                        fontWeight = FontWeight(600),
                                                        color = Color(0xFF757575),
                                                    )
                                                )
                                            }
                                        }

                                    }

                                    GetVerticalSpaceMedium()
                                    GetVerticalSpaceSmall()


                                }
                            }

                        }
                    }
                }

                if (isOpen) {
                    Surface(
                        color = Color.Black.copy(alpha = backgroundAlpha),
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable(
                                indication = null,
                                interactionSource = MutableInteractionSource(),
                                onClick = {
                                    isOpen = !isOpen
                                }
                            )
                    ) {

                    }
                }

                FloatingActionButtonExample(
                    isOpen = isOpen,
                    onToggle = {
                        isOpen = !isOpen
                    },
                    onClose = { state ->
                        if (state) {
                            isOpen = false
                        }
                    },
                    onClickSell = {
                        navigator.push(AddDebtScreen(false))
                    },
                    onClickAddBedt = {
                        navigator.push(AddDebtScreen(true))
                    }
                )

            }

            BackHandler(
                enabled = isOpen,
                onBack = {
                    isOpen = !isOpen
                }
            )
        }
    }

}


@Preview(showSystemUi = true)
@Preview
@Composable
private fun ContentScreenPreview() {
}

