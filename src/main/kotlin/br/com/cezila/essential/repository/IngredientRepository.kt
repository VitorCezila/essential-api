package br.com.cezila.essential.repository

import br.com.cezila.essential.model.Ingredient
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientRepository: JpaRepository<Ingredient, Long> {
}