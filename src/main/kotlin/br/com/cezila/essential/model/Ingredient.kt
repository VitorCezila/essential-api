package br.com.cezila.essential.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.NotNull

@Document
data class Ingredient(
    @Id
    var id: String? = null,
    @NotNull
    var name: String,
    @NotNull
    var type: IngredientType
)
