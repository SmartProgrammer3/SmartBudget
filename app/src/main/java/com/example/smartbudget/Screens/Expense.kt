package com.example.smartbudget.Screens

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val amount: Double,
    val title: String,
    val date: Date,
    val notes: String
)

