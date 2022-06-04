package br.com.cezila.essential.mapper

import br.com.cezila.essential.dto.MeasurementsForm
import br.com.cezila.essential.model.Measurements
import br.com.cezila.essential.service.IngredientService
import org.springframework.stereotype.Component

@Component
class MeasurementsFormMapper(
    private val ingredientService: IngredientService
): Mapper<MeasurementsForm, Measurements> {
    override fun map(t: MeasurementsForm): Measurements {
        return Measurements(
            ingredient = ingredientService.queryIngredientsById(t.ingredientId.toString()),
            amount = t.amount,
            unit = t.unit
        )
    }
}