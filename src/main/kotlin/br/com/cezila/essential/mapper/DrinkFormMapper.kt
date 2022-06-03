package br.com.cezila.essential.mapper

import br.com.cezila.essential.dto.NewDrinkForm
import br.com.cezila.essential.model.Drink
import br.com.cezila.essential.service.IngredientService
import br.com.cezila.essential.service.MeasurementsService
import org.springframework.stereotype.Component

@Component
class DrinkFormMapper(
    private val measurementsService: MeasurementsService
): Mapper<NewDrinkForm, Drink> {

    override fun map(t: NewDrinkForm): Drink {
        return Drink(
            name = t.name,
            description = t.description,
            alcoholContent = t.alcoholContent,
            difficulty = t.difficulty,
            measurements = measurementsService.mapFormsToOriginal(t.ingredients),
            steps = t.steps,
            author = t.author
        )
    }
}