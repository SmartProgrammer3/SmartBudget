package com.example.smartbudget.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smartbudget.R

@Composable
fun ActivityScreen(modifier: Modifier = Modifier) {
    var foodExpense by remember { mutableStateOf(0) }
    var schoolExpense by remember { mutableStateOf(0) }
    var investmentExpense by remember { mutableStateOf(0) }
    var clothesExpenses by remember { mutableStateOf(0) }
    var healthExpense by remember { mutableStateOf(0) }
    var transportExpense by remember { mutableStateOf(0) }
    var entertainmentsExpense by remember { mutableStateOf(0) }
    var houseExpense by remember { mutableStateOf(0) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF000000)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ExpenseButton(category = "Food\n& supermarket", expense = foodExpense, isMultiLine = true, iconResId = R.drawable.food_icon)
        ExpenseButton(category = "School", expense = schoolExpense, iconResId = R.drawable.school_icon)
        ExpenseButton(category = "Investments", expense = investmentExpense, iconResId = R.drawable.investments_icon)
        ExpenseButton(category = "Clothes\n& accessories", expense = clothesExpenses, isMultiLine = true, iconResId = R.drawable.clothes_icon)
        ExpenseButton(category = "Health", expense = healthExpense, iconResId = R.drawable.health_icon)
        ExpenseButton(category = "Transportation", expense = transportExpense, iconResId = R.drawable.transport_icon)
        ExpenseButton(category = "Entertainment", expense = entertainmentsExpense, iconResId = R.drawable.entertainment_icon)
        ExpenseButton(category = "Housing", expense = houseExpense, iconResId = R.drawable.house_icon)
    }
}

@Composable
fun ExpenseButton(category: String, expense: Int, iconResId: Int, isMultiLine: Boolean = false, modifier: Modifier = Modifier) {
    Button(
        onClick = { /* Adicione lógica para incrementar a despesa */ },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .border(2.dp, Color.Gray, RoundedCornerShape(8.dp)) // Adiciona o outline cinza
            .height(if (isMultiLine) 80.dp else 56.dp), // Ajuste a altura para botões multi-line
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null,
                modifier = Modifier.size(48.dp).padding(end = 4.dp)
            )
            Text(
                text = category,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = "€$expense",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
    }
}
