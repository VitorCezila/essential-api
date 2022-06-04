package br.com.cezila.essential.service

import br.com.cezila.essential.dto.DrinkView
import br.com.cezila.essential.dto.NewDrinkForm
import br.com.cezila.essential.exception.NotFoundException
import br.com.cezila.essential.mapper.DrinkFormMapper
import br.com.cezila.essential.mapper.DrinkViewMapper
import br.com.cezila.essential.repository.DrinkRepository
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException.NotFound
import java.util.stream.Collectors

@Service
class DrinkService(
    private val repository: DrinkRepository,
    private val drinkViewMapper: DrinkViewMapper,
    private val drinkFormMapper: DrinkFormMapper,
    private val notFoundMessage: String = "Drink not found!"
) {

    fun findAllDrinks(): List<DrinkView> {
        return repository.findAll().stream().map { drink ->
            drinkViewMapper.map(drink)
        }.collect(Collectors.toList())
    }

    fun findDrinkById(id: String): DrinkView {
        val drink = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return drinkViewMapper.map(drink)
    }

    fun registerDrink(newDrink: NewDrinkForm): DrinkView {
        val drink = drinkFormMapper.map(newDrink)
        val id = repository.findAll().size + 1
        drink.id = id.toString()
        repository.save(drink)
        return drinkViewMapper.map(drink)
    }

}