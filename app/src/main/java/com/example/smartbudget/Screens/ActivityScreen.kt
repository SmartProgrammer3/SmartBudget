package com.example.smartbudget.Screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.smartbudget.NavItem
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.material3.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ActivityScreen(modifier: Modifier = Modifier) {
    Screen()
}

@Composable
fun Screen() {
    val navItemList = listOf(
        NavItemExpInc("Expenses", Icons.Default.Home, Color.Red),
        NavItemExpInc("Income", Icons.Default.Person, Color.Green),
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.statusBarsPadding(),
        topBar = {
            Column {
                Spacer(modifier = Modifier.height(65.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(72.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                ) {
                    navItemList.fastForEachIndexed {index, navItem->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                                .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                                .height(70.dp)
                        ) {
                            IconButton(onClick = {selectedIndex = index}, modifier = Modifier
                                .padding(8.dp)
                                .fillMaxSize()) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Text(
                                        text = navItem.title,
                                        fontSize = 20.sp, // Aumentar tamanho da fonte
                                        fontWeight = FontWeight.Bold,
                                        color = navItem.color,
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                }
                            }
                        }

                    }
                }
            }
        }
    ) {innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex : Int) {
    when(selectedIndex) {
        0 -> ExpensesScreen()
        1 -> IncomeScreen()
    }
}