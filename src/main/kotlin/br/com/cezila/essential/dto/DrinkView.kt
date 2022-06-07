package br.com.cezila.essential.dto

import br.com.cezila.essential.model.Steps

data class DrinkView(
    val id: String?,
    val name: String,
    val image: String,
    val description: String?,
    val alcoholContent: Int,
    val difficulty: Int,
    val ingredients: List<MeasurementsView>,
    val steps: List<Steps>,
    val author: String?
)
