package br.com.cezila.essential.mapper

import br.com.cezila.essential.dto.DrinkView
import br.com.cezila.essential.model.Drink
import br.com.cezila.essential.service.MeasurementsService
import org.springframework.stereotype.Component

@Component
class DrinkViewMapper(
    private val measurementsService: MeasurementsService
): Mapper<Drink, DrinkView> {

    override fun map(t: Drink): DrinkView {
        return DrinkView(
            id = t.id,
            name = t.name,
            description = t.description,
            alcoholContent = t.alcoholContent,
            difficulty = t.difficulty,
            ingredients = measurementsService.mapOriginalToView(t.measurements),
            steps = t.steps,
            author = t.author
        )
    }
}