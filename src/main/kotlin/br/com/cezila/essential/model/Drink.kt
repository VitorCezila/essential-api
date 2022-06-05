package br.com.cezila.essential.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Drink(
    @Id
    var id: String? = null,
    var name: String,
    var description: String?,
    var alcoholContent: Int,
    var difficulty: Int,
    var measurements: List<Measurements>,
    var steps: List<Steps>,
    var author: String?
)
