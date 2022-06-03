package br.com.cezila.essential.controller

import br.com.cezila.essential.model.Ingredient
import br.com.cezila.essential.service.IngredientService
import org.springframework.web.bind.annotation.*
import javax.transaction.Transactional
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

}