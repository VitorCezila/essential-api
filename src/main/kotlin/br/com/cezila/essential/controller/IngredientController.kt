package br.com.cezila.essential.controller

import br.com.cezila.essential.dto.UpdateIngredientForm
import br.com.cezila.essential.model.Ingredient
import br.com.cezila.essential.service.IngredientService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/ingredients")
class IngredientController(
    private val service: IngredientService
) {

    @PostMapping
    @Transactional
    fun register(
        @RequestBody @Valid form: Ingredient
    ): Ingredient {
        return service.registerIngredient(form)
    }

    @GetMapping
    fun findAllDrinks(): List<Ingredient> {
        return service.findAllIngredients()
    }

    @GetMapping("/{id}")
    fun findDrinkById(@PathVariable id: String): Ingredient {
        return service.queryIngredientsById(id)
    }

    @PutMapping
    fun updateIngredient(@RequestBody @Valid form: UpdateIngredientForm): ResponseEntity<Ingredient> {
        val ingredient = service.updateIngredient(form)
        return ResponseEntity.ok(ingredient)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deleteDrink(@PathVariable id: String) {
        return service.deleteIgredient(id)
    }

}