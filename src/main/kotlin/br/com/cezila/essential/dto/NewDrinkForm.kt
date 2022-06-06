package br.com.cezila.essential.dto

import br.com.cezila.essential.model.Steps
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class NewDrinkForm(
    @field:NotEmpty(message = "Name field cannot be empty")
    val name: String,

    @field:NotEmpty(message = "Image field cannot be empty")
    val image: String,

    @field:NotEmpty(message = "Description field cannot be empty")
    val description: String,

    @field:NotNull(message = "Alcohol Content must be specified")
    val alcoholContent: Int,

    @field:NotNull(message = "Difficulty field cannot be null")
    val difficulty: Int,

    @field:NotNull(message = "Ingredients list cannot be null")
    val ingredients: List<MeasurementsForm>,

    @field:NotNull(message = "Steps list cannot be null")
    val steps: List<Steps>,

    val author: String?
)
