package br.com.cezila.essential.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class MeasurementsForm (

    @field:NotNull(message = "Id ingredient cannot be null")
    val ingredientId: Long,

    @field:NotNull(message = "Amount ingredient cannot be null")
    val amount: String,

    @field:NotEmpty(message = "Unit ingredient cannot be empty")
    val unit: String
)