package br.com.cezila.essential.model

import javax.persistence.*

@Entity
data class Drink(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String?,
    val alcoholContent: Int,
    val difficulty: Int,
    @OneToMany(cascade = [CascadeType.ALL])
    val measurements: List<Measurements>,
    @OneToMany(cascade = [CascadeType.ALL])
    val steps: List<Steps>,
    val author: String?
)
