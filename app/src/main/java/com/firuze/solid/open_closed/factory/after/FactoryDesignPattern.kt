package com.firuze.solid.open_closed.factory.after

/**
 *
 * Open/Closed Principle (OCP): Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
 *
 *  */

abstract class Car {
    abstract fun assemble()
    abstract fun paint()
    abstract fun test()

    abstract fun chooseWheels(wheelType: String)
    abstract fun chooseSeats(seatType: String)
    abstract fun choosePaintColor(color: String)
}

class ToggT10X : Car() {
    override fun assemble() = println("Assembling Togg T10X")
    override fun paint() = println("Painting Togg T10X")
    override fun test() = println("Testing Togg T10X")

    override fun chooseWheels(wheelType: String) = println("Choosing wheels for Togg T10X: $wheelType")
    override fun chooseSeats(seatType: String) = println("Choosing seats for Togg T10X: $seatType")
    override fun choosePaintColor(color: String) = println("Choosing paint color for Togg T10X: $color")
}

class ToggT10F : Car() {
    override fun assemble() = println("Assembling Togg T10F")
    override fun paint() = println("Painting Togg T10F")
    override fun test() = println("Testing Togg T10F")

    override fun chooseWheels(wheelType: String) = println("Choosing wheels for Togg T10F: $wheelType")
    override fun chooseSeats(seatType: String) = println("Choosing seats for Togg T10F: $seatType")
    override fun choosePaintColor(color: String) = println("Choosing paint color for Togg T10F: $color")
}

class TeslaModelS : Car() {
    override fun assemble() = println("Assembling Tesla Model S")
    override fun paint() = println("Painting Tesla Model S")
    override fun test() = println("Testing Tesla Model S")

    override fun chooseWheels(wheelType: String) = println("Choosing wheels for Tesla Model S: $wheelType")
    override fun chooseSeats(seatType: String) = println("Choosing seats for Tesla Model S: $seatType")
    override fun choosePaintColor(color: String) = println("Choosing paint color for Tesla Model S: $color")
}

class TeslaModel3 : Car() {
    override fun assemble() = println("Assembling Tesla Model 3")
    override fun paint() = println("Painting Tesla Model 3")
    override fun test() = println("Testing Tesla Model 3")

    override fun chooseWheels(wheelType: String) = println("Choosing wheels for Tesla Model 3: $wheelType")
    override fun chooseSeats(seatType: String) = println("Choosing seats for Tesla Model 3: $seatType")
    override fun choosePaintColor(color: String) = println("Choosing paint color for Tesla Model 3: $color")
}

class AudiA4 : Car() {
    override fun assemble() = println("Assembling Audi A4")
    override fun paint() = println("Painting Audi A4")
    override fun test() = println("Testing Audi A4")

    override fun chooseWheels(wheelType: String) = println("Choosing wheels for Audi A4: $wheelType")
    override fun chooseSeats(seatType: String) = println("Choosing seats for Audi A4: $seatType")
    override fun choosePaintColor(color: String) = println("Choosing paint color for Audi A4: $color")
}

class AudiQ5 : Car() {
    override fun assemble() = println("Assembling Audi Q5")
    override fun paint() = println("Painting Audi Q5")
    override fun test() = println("Testing Audi Q5")

    override fun chooseWheels(wheelType: String) = println("Choosing wheels for Audi Q5: $wheelType")
    override fun chooseSeats(seatType: String) = println("Choosing seats for Audi Q5: $seatType")
    override fun choosePaintColor(color: String) = println("Choosing paint color for Audi Q5: $color")
}

interface CarFactory {
    fun createCar(model: String): Car?
}

class ToggFactory : CarFactory {
    override fun createCar(model: String): Car? {
        return when (model) {
            "T10X" -> ToggT10X()
            "T10F" -> ToggT10F()
            else -> null
        }
    }
}

class TeslaFactory : CarFactory {
    override fun createCar(model: String): Car? {
        return when (model) {
            "Model S" -> TeslaModelS()
            "Model 3" -> TeslaModel3()
            else -> null
        }
    }
}

class AudiFactory : CarFactory {
    override fun createCar(model: String): Car? {
        return when (model) {
            "A4" -> AudiA4()
            "Q5" -> AudiQ5()
            else -> null
        }
    }
}

class CarProductionManager(val factory: CarFactory) {
    fun buildCar(model: String) {
        val car = factory.createCar(model)
        car?.apply {
            assemble()
            paint()
            test()

            chooseWheels("Sport")
            chooseSeats("Leather")
            choosePaintColor("Red")
        } ?: println("Unable to build the car: Model '$model' is invalid.")
    }
}

fun main() {
    val toggFactory = ToggFactory()
    val teslaFactory = TeslaFactory()
    val audiFactory = AudiFactory()

    val toggManager = CarProductionManager(toggFactory)
    toggManager.buildCar("T10X")

    val teslaManager = CarProductionManager(teslaFactory)
    teslaManager.buildCar("Model S")

    val audiManager = CarProductionManager(audiFactory)
    audiManager.buildCar("A4")
}