package br.com.cezila.essential.dto

import br.com.cezila.essential.model.Steps
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class UpdateDrinkForm (

    @field:NotNull(message = "Id field cannot be null")
    @field:NotEmpty(message = "Id field cannot be empty")
    val id: String,

    val name: String?,
    val description: String?,
    val alcoholContent: Int?,
    val difficulty: Int?,
    val ingredients: List<MeasurementsForm>?,
    val steps: List<Steps>?,
    val author: String?
)