package br.com.cezila.essential.service

import br.com.cezila.essential.dto.UpdateIngredientForm
import br.com.cezila.essential.exception.NotFoundException
import br.com.cezila.essential.model.Ingredient
import br.com.cezila.essential.repository.IngredientRepository
import org.springframework.stereotype.Service

@Service
class IngredientService(
    private val repository: IngredientRepository,
    private val notFoundMessage: String = "Ingredient not found!"
) {

    fun registerIngredient(ingredient: Ingredient): Ingredient {
        val ingredients = repository.findAll()
        val id = if (ingredients.size >= 1) (ingredients.last().id?.toInt() ?: 1) + 1 else 1
        ingredient.id = id.toString()
        repository.save(ingredient)
        return ingredient
    }


    fun findAllIngredients(): List<Ingredient> {
        return repository.findAll()
    }

    fun queryIngredientsById(id: String): Ingredient {
        return repository.findById(id)
            .orElseThrow { NotFoundException(notFoundMessage) }
    }

    fun updateIngredient(form: UpdateIngredientForm): Ingredient {
        val ingredient = repository.findById(form.id)
            .orElseThrow { NotFoundException(notFoundMessage) }

        ingredient.run {
            id = form.id
            name = form.name ?: name
            type = form.type ?: type
        }

        repository.deleteById(form.id)
        repository.save(ingredient)
        return ingredient
    }

    fun deleteIgredient(id: String) {
        repository.deleteById(id)
    }

}