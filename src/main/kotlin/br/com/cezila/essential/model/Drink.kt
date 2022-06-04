package br.com.cezila.essential.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Drink(
    @Id
    var id: String? = null,
    val name: String,
    val description: String?,
    val alcoholContent: Int,
    val difficulty: Int,
    val measurements: List<Measurements>,
    val steps: List<Steps>,
    val author: String?
)
