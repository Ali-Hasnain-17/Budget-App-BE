package com.pinchpenny.pinchpenny

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BudgetApplication

fun main(args: Array<String>) {
	runApplication<BudgetApplication>(*args)
}
