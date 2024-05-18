package com.firuze.solid.open_closed.factory.after

class CarsProductionManager(private val factories: Map<String, CarFactory>) {
    fun buildCar(model: String) {
        val factory = factories[model]
        factory?.let {
            val car = it.createCar(model)
            car?.apply {
                assemble()
                paint()
                test()
                chooseWheels("Sport")
                chooseSeats("Leather")
                choosePaintColor("Red")
            } ?: println("Unable to build the car: Model '$model' is invalid.")
        } ?: println("Unable to build the car: Factory for model '$model' is not found.")
    }
}

fun main() {
    val factories = mapOf(
        "T10X" to ToggFactory(),
        "T10F" to ToggFactory(),
        "Model S" to TeslaFactory(),
        "Model 3" to TeslaFactory(),
        "A4" to AudiFactory(),
        "Q5" to AudiFactory()
    )

    val manager = CarsProductionManager(factories)
    manager.buildCar("T10X")
    manager.buildCar("Model S")
    manager.buildCar("A4")
    manager.buildCar("UnknownModel")
}
