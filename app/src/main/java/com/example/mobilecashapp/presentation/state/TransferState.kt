package com.example.mobilecashapp.presentation.state

import com.example.mobilecashapp.R
import com.example.mobilecashapp.presentation.constants.Beneficiary

data class TransferState(
    val amount:String="",
    val bank:String="",
    val benficiary: Beneficiary =
        Beneficiary((R.drawable.ellipse_9__1_),"Jacob Janes","AccessBank","0431609284", "150","10")
)