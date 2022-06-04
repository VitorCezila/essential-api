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

    fun queryIngredientsById(id: String): Ingredient  {
        return repository.findById(id).get()
    }

    fun registerIngredient(ingredient: Ingredient) {
        val id = repository.findAll().size + 1
        ingredient.id = id.toString()
        repository.save(ingredient)
    }

    fun deleteIgredient(id: String) {
        repository.deleteById(id)
    }

}