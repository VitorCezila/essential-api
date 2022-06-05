package br.com.cezila.essential.service

import br.com.cezila.essential.dto.DrinkView
import br.com.cezila.essential.dto.NewDrinkForm
import br.com.cezila.essential.dto.UpdateDrinkForm
import br.com.cezila.essential.exception.NotFoundException
import br.com.cezila.essential.mapper.DrinkFormMapper
import br.com.cezila.essential.mapper.DrinkViewMapper
import br.com.cezila.essential.mapper.MeasurementsFormMapper
import br.com.cezila.essential.mapper.MeasurementsViewMapper
import br.com.cezila.essential.model.Drink
import br.com.cezila.essential.repository.DrinkRepository
import org.springframework.data.mongodb.repository.Update
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class DrinkService(
    private val repository: DrinkRepository,
    private val drinkViewMapper: DrinkViewMapper,
    private val drinkFormMapper: DrinkFormMapper,
    private val measurementsService: MeasurementsService,
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
        val allDrinks = repository.findAll()
        val id = if(allDrinks.size >= 1) (allDrinks.last().id?.toInt() ?: 1) + 1 else 1
        drink.id = id.toString()
        repository.save(drink)
        return drinkViewMapper.map(drink)
    }

    fun deleteDrink(id: String) {
        repository.deleteById(id)
    }

    fun updateDrink(form: UpdateDrinkForm): DrinkView {
        val drink = repository.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        replaceDrinkData(drink, form)

        repository.deleteById(form.id)
        repository.save(drink)
        return drinkViewMapper.map(drink)
    }

    private fun replaceDrinkData(
        drink: Drink,
        form: UpdateDrinkForm
    ) {
        drink.run {
            id = form.id
            name = form.name ?: name
            description = form.description ?: description
            alcoholContent = form.alcoholContent ?: alcoholContent
            difficulty = form.difficulty ?: difficulty
            measurements = form.ingredients?.let { measurementsService.mapFormsToOriginal(it) } ?: measurements
            steps = form.steps ?: steps
            author = form.author ?: author
        }
    }

}