package br.com.cezila.essential

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EssentialApplication

fun main(args: Array<String>) {
	runApplication<EssentialApplication>(*args)
}
