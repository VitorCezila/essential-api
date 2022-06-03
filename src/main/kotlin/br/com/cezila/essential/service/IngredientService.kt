package br.com.cezila.essential.service

import br.com.cezila.essential.model.Ingredient
import br.com.cezila.essential.repository.IngredientRepository
import org.springframework.stereotype.Service

@Service
class IngredientService(
    private val repository: IngredientRepository
) {

    fun findAllIngredients(): List<Ingredient> {
        return repository.findAll()
    }

    fun queryIngredientsById(id: Long): Ingredient  {
        return repository.getReferenceById(id)
    }

    fun registerIngredient(ingredient: Ingredient) {
        repository.save(ingredient)
    }

}