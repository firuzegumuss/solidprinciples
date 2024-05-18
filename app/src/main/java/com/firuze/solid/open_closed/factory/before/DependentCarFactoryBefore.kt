package com.firuze.solid.open_closed.factory.before

abstract class Car {
    abstract fun assemble()
    abstract fun paint()
    abstract fun test()
}

class ToggT10X : Car() {
    override fun assemble() = println("Assembling Togg T10X")
    override fun paint() = println("Painting Togg T10X")
    override fun test() = println("Testing Togg T10X")
}

class ToggT10F : Car() {
    override fun assemble() = println("Assembling Togg T10F")
    override fun paint() = println("Painting Togg T10F")
    override fun test() = println("Testing Togg T10F")
}

class TeslaModelS : Car() {
    override fun assemble() = println("Assembling Tesla Model S")
    override fun paint() = println("Painting Tesla Model S")
    override fun test() = println("Testing Tesla Model S")
}

class TeslaModel3 : Car() {
    override fun assemble() = println("Assembling Tesla Model 3")
    override fun paint() = println("Painting Tesla Model 3")
    override fun test() = println("Testing Tesla Model 3")
}

class DependentCarFactory {
    fun createCar(brand: String, model: String): Car? {
        val car = when (brand) {
            "Togg" -> {
                when (model) {
                    "T10X" -> ToggT10X()
                    "T10F" -> ToggT10F()
                    else -> {
                        println("Error: Invalid Togg model")
                        null
                    }
                }
            }
            "Tesla" -> {
                when (model) {
                    "Model S" -> TeslaModelS()
                    "Model 3" -> TeslaModel3()
                    else -> {
                        println("Error: Invalid Tesla model")
                        null
                    }
                }
            }
            else -> {
                println("Error: Invalid brand")
                return null
            }
        }

        car?.apply {
            assemble()
            paint()
            test()
        }

        return car
    }
}

fun main() {
    val factory = DependentCarFactory()

    val toggCar = factory.createCar("Togg", "T10X")
    toggCar?.apply {
        assemble()
        paint()
        test()
    }

    val teslaCar = factory.createCar("Tesla", "Model S")
    teslaCar?.apply {
        assemble()
        paint()
        test()
    }
}
