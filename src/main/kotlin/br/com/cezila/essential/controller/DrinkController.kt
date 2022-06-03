package br.com.cezila.essential.controller

import br.com.cezila.essential.dto.DrinkView
import br.com.cezila.essential.dto.NewDrinkForm
import br.com.cezila.essential.service.DrinkService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.transaction.Transactional
import javax.validation.Valid

@RestController
@RequestMapping("/drinks")
class DrinkController(private val service: DrinkService) {

    @GetMapping
    fun findAllDrinks(): List<DrinkView> {
        return service.findAllDrinks()
    }

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
}