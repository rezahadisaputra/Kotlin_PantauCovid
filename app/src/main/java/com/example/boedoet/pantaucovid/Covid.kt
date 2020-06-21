package com.example.boedoet.pantaucovid

data class Covid (
    var Provinsi: String = "",
    var Positive: Int = 0,
    var Sembuh: Int = 0,
    var Meninggal: Int = 0,
    var Photo: String = ""
)