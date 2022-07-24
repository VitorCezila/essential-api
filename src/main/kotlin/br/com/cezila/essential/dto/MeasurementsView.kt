package br.com.cezila.essential.dto

import br.com.cezila.essential.model.IngredientType

data class MeasurementsView(
    val id: String? = null, //ingredient id
    val name: String,
    val amount: String,
    val unit: String,
    val originalName: String,
    val ingredientType: IngredientType
)
