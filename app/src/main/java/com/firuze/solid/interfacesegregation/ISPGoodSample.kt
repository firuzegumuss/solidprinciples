package com.firuze.solid.interfacesegregation


/**
 *
 *  Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use.
 *
 * */


interface OilChangeable {
    fun changeOil()
}

// Lastik dönüşü
interface TireRotatable {
    fun rotateTires()
}

// Fren değiştirme
interface BrakeReplaceable {
    fun replaceBrakes()
}

class SportsCarMaintenance : OilChangeable, TireRotatable, BrakeReplaceable {
    override fun changeOil() {
        println("Changing oil for sports car")
    }

    override fun rotateTires() {
        println("Rotating tires for sports car")
    }

    override fun replaceBrakes() {
        println("Replacing brakes for sports car")
    }
}

class BicycleMaintenance : TireRotatable, BrakeReplaceable {
    override fun rotateTires() {
        println("Rotating tires for bicycle")
    }

    override fun replaceBrakes() {
        println("Replacing brakes for bicycle")
    }
}

fun main() {
    val sportsCar = SportsCarMaintenance()
    sportsCar.changeOil()

    val bicycle = BicycleMaintenance()
    try {
       // bicycle.changeOil()  // Artık UnsupportedOperationException atmaz çünkü bu işlev gereksiz
    } catch (e: Exception) {
        println("Error: ${e.message}")
    }

    bicycle.rotateTires()
}
