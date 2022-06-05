package br.com.cezila.essential.dto

import br.com.cezila.essential.model.IngredientType
import javax.validation.constraints.NotNull

data class UpdateIngredientForm (

    @field:NotNull(message = "Id field cannot be null") val id: String,
    val name: String?,
    val type: IngredientType?
)