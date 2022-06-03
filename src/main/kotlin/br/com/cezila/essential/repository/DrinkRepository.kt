package br.com.cezila.essential.repository

import br.com.cezila.essential.model.Drink
import org.springframework.data.jpa.repository.JpaRepository

interface DrinkRepository: JpaRepository<Drink, Long> {
}