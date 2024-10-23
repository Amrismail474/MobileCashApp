package com.example.mobilecashapp.presentation.constants

data class Transaction(
    val sender : String,
    val amount:String,
    val date:String,
    val refNumber:String,
    val paymentMethod:String,
)

data class Beneficiary(
    val image:Int,
    val name:String,
    val bank:String,
    val accountNumber:String,
    val amount: String,
    val fee:String,
)