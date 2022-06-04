package br.com.cezila.essential.repository

import br.com.cezila.essential.model.Ingredient
import org.springframework.data.mongodb.repository.MongoRepository

interface IngredientRepository: MongoRepository<Ingredient, String> {
}