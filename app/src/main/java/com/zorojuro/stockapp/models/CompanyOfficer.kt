package com.zorojuro.stockapp.models

data class CompanyOfficer(
    val age: Int,
    val exercisedValue: Int,
    val fiscalYear: Int,
    val maxAge: Int,
    val name: String,
    val title: String,
    val totalPay: Int,
    val unexercisedValue: Int,
    val yearBorn: Int
)