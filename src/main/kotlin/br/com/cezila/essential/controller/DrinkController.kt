package br.com.cezila.essential.controller

import br.com.cezila.essential.dto.DrinkView
import br.com.cezila.essential.dto.NewDrinkForm
import br.com.cezila.essential.dto.UpdateDrinkForm
import br.com.cezila.essential.service.DrinkService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/drinks")
class DrinkController(private val service: DrinkService) {

    @PostMapping
    @Transactional
    fun register(
        @RequestBody @Valid form: NewDrinkForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<DrinkView> {
        val drinkView = service.registerDrink(form)
        val uri = uriBuilder.path("/drinks/${drinkView.id}").build().toUri()
        return ResponseEntity.created(uri).body(drinkView)
    }

    @GetMapping
    fun findAllDrinks(): List<DrinkView> {
        return service.findAllDrinks()
    }

    @GetMapping("/{id}")
    fun findDrinkById(@PathVariable id: String): DrinkView {
        return service.findDrinkById(id)
    }

    @PutMapping
    @Transactional
    fun updateDrink(
        @RequestBody @Valid form: UpdateDrinkForm
    ): ResponseEntity<DrinkView> {
        val drinkView = service.updateDrink(form)
        return ResponseEntity.ok(drinkView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deleteDrink(@PathVariable id: String) {
        service.deleteDrink(id)
    }
}