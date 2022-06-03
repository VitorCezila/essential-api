package br.com.cezila.essential.mapper

import br.com.cezila.essential.dto.MeasurementsView
import br.com.cezila.essential.model.Measurements
import org.springframework.stereotype.Component

@Component
class MeasurementsViewMapper: Mapper<Measurements, MeasurementsView> {

    override fun map(t: Measurements): MeasurementsView {
        return MeasurementsView(
            name = t.ingredient.name,
            amount = t.amount,
            unit = t.unit,
            originalName = "${t.amount} ${t.unit}"
        )
    }
}
