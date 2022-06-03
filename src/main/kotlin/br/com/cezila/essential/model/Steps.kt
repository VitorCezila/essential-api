package br.com.cezila.essential.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Steps (
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
     val id: Long? = null,
     val number: Int,
     val step: String
)