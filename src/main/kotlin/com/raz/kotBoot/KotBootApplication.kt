package com.raz.kotBoot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotBootApplication
fun main(args: Array<String>) {
	runApplication<KotBootApplication>(*args)
}
