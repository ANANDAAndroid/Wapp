package com.clone.whatsapp.domain.utils

object Constant {
    data class Country(
        val name: String,
        val code: String
    )

    val countryList = listOf(
        Country("United States", "+ 1"),
        Country("Canada", "+ 1"),
        Country("United Kingdom", "+ 44"),
        Country("Australia", "+ 61"),
        Country("Germany", "+ 49"),
        Country("France", "+ 33"),
        Country("India", "+ 91"),
        Country("China", "+ 86"),
        Country("Japan", "+ 81"),
        Country("Brazil", "+ 55"),
        Country("Mexico", "+ 52"),
        Country("South Korea", "+ 82"),
        Country("Italy", "+ 39"),
        Country("Spain", "+ 34"),
        Country("Netherlands", "+ 31"),
        Country("Russia", "+ 7"),
        Country("Sweden", "+ 46"),
        Country("Switzerland", "+ 41"),
        Country("Norway", "+ 47"),
        Country("Denmark", "+ 45")
    )
}