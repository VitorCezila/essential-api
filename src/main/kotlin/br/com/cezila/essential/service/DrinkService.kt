package br.com.cezila.essential.service

import br.com.cezila.essential.dto.DrinkView
import br.com.cezila.essential.dto.NewDrinkForm
import br.com.cezila.essential.mapper.DrinkFormMapper
import br.com.cezila.essential.mapper.DrinkViewMapper
import br.com.cezila.essential.repository.DrinkRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class DrinkService(
    private val repository: DrinkRepository,
    private val drinkViewMapper: DrinkViewMapper,
    private val drinkFormMapper: DrinkFormMapper
) {

    fun findAllDrinks(): List<DrinkView> {
        return repository.findAll().stream().map { drink ->
            drinkViewMapper.map(drink)
        }.collect(Collectors.toList())
    }

    fun registerDrink(newDrink: NewDrinkForm): DrinkView {
        val drink = drinkFormMapper.map(newDrink)
        repository.save(drink)
        return drinkViewMapper.map(drink)
    }

}