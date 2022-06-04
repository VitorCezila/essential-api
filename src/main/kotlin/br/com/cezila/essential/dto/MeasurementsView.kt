package br.com.cezila.essential.dto

data class MeasurementsView(
    val id: String? = null, //ingredient id
    val name: String,
    val amount: Float,
    val unit: String,
    val originalName: String
)
