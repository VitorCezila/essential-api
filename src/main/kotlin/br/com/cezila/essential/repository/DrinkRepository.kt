package br.com.cezila.essential.repository

import br.com.cezila.essential.model.Drink
import org.springframework.data.mongodb.repository.MongoRepository

interface DrinkRepository : MongoRepository<Drink, String> {
}