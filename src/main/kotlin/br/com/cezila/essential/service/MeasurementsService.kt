package br.com.cezila.essential.service

import br.com.cezila.essential.dto.MeasurementsForm
import br.com.cezila.essential.dto.MeasurementsView
import br.com.cezila.essential.mapper.MeasurementsFormMapper
import br.com.cezila.essential.mapper.MeasurementsViewMapper
import br.com.cezila.essential.model.Measurements
import org.springframework.stereotype.Service

@Service
class MeasurementsService(
    private val measurementsFormMapper: MeasurementsFormMapper,
    private val measurementsViewMapper: MeasurementsViewMapper
) {

    fun mapFormsToOriginal(forms: List<MeasurementsForm>): List<Measurements> {
        return forms.map { m ->
            measurementsFormMapper.map(m)
        }
    }

    fun mapOriginalToView(measurements: List<Measurements>): List<MeasurementsView> {
        return measurements.map { m ->
            measurementsViewMapper.map(m)
        }
    }
}