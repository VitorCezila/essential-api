package br.com.cezila.essential.controller

import br.com.cezila.essential.model.Ingredient
import br.com.cezila.essential.service.IngredientService
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/ingredients")
class IngredientController(
    private val service: IngredientService
) {

    @GetMapping
    fun findAllDrinks(): List<Ingredient> {
        return service.findAllIngredients()
    }

    @PostMapping
    @Transactional
    fun register(
        @RequestBody @Valid form: Ingredient
    ) {
        service.registerIngredient(form)
    }

    @DeleteMapping("/{id}")
    @Transactional
    fun deleteDrink(@PathVariable id: String) {
        return service.deleteIgredient(id)
    }

    @GetMapping("/{id}")
    fun findDrinkById(@PathVariable id: String): Ingredient {
        return service.queryIngredientsById(id)
    }

}