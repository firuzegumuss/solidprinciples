interface VehicleMaintenance {
    fun changeOil()
    fun rotateTires()
    fun replaceBrakes()
    fun checkTransmission()
    fun inspectExhaust()
    fun tuneEngine()
}

class SportsCarMaintenance : VehicleMaintenance {
    override fun changeOil() {
        println("Changing oil for sports car")
    }

    override fun rotateTires() {
        println("Rotating tires for sports car")
    }

    override fun replaceBrakes() {
        println("Replacing brakes for sports car")
    }

    override fun checkTransmission() {
        println("Checking transmission for sports car")
    }

    override fun inspectExhaust() {
        println("Inspecting exhaust for sports car")
    }

    override fun tuneEngine() {
        println("Tuning engine for sports car")
    }
}

class BicycleMaintenance : VehicleMaintenance {
    override fun changeOil() {
        throw UnsupportedOperationException("Bicycles don't use oil")
    }

    override fun rotateTires() {
        println("Rotating tires for bicycle")
    }

    override fun replaceBrakes() {
        println("Replacing brakes for bicycle")
    }

    override fun checkTransmission() {
        throw UnsupportedOperationException("Bicycles don't have transmissions")
    }

    override fun inspectExhaust() {
        throw UnsupportedOperationException("Bicycles don't have exhaust systems")
    }

    override fun tuneEngine() {
        throw UnsupportedOperationException("Bicycles don't have engines")
    }
}

fun main() {
    val sportsCar = SportsCarMaintenance()
    sportsCar.changeOil()  // Çalışır

    val bicycle = BicycleMaintenance()
    bicycle.changeOil()  // UnsupportedOperationException
}
