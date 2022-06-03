package br.com.cezila.essential.model

import javax.persistence.*

@Entity
data class Measurements (
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val sequence: Long? = null,
    @ManyToOne
    val ingredient: Ingredient,
    val amount: Float,
    val unit: String
)