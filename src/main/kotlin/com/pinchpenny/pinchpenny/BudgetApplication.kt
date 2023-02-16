package com.pinchpenny.pinchpenny

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class BudgetApplication

fun main(args: Array<String>) {
	runApplication<com.pinchpenny.pinchpenny.BudgetApplication>(*args)
}